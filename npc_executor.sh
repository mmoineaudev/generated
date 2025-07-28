#!/bin/bash

# Colors for better output
RED='\033[0;31m'
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Initialize variables
CONFIG_FILE="${1:-steps.json}"

process_step() {
    local step_index="${1}"
    local model=$(jq -r ".steps[$step_index].model" "$CONFIG_FILE")
    local prompt=$(jq -r ".steps[$step_index].prompt" "$CONFIG_FILE")
    local input_file=$(jq -r ".steps[$step_index].input_file // \"\"" "$CONFIG_FILE") # Default to empty string if not specified
    local output_file=$(jq -r ".steps[$step_index].output_file // \"./output_$(($step_index + 1)).md\"" "$CONFIG_FILE")


    if [[ -f ${input_file} ]]; then
        echo "context propagation..."
        echo "$(cat ${input_file})" > ${output_file}
        wc -l ${output_file}
        ollama run "$model" "${prompt}" < "${input_file}" >> "$output_file" 
        if [ $? -ne 0 ]; then
            echo -e "${RED}Error${NC}: Failed to execute Ollama command for model $model"
            exit 1
        fi
    else
        # Use printf to ensure text output with correct encoding
        ollama run "$model" "${prompt}" > "$output_file"
        if [ $? -ne 0 ]; then
            echo -e "${RED}Error${NC}: Failed to execute Ollama command for model $model"
            exit 1
        fi
    fi

    # Ensure file is text with LF endings and UTF-8 encoding
    dos2unix "$output_file" || {
        echo -e "${YELLOW}Warning${NC}: Could not convert line endings in $output_file."
    }
    iconv -f "utf-8" -t "utf-8" "$output_file" > /dev/null 2>&1 || {
        echo -e "${YELLOW}Warning${NC}: Could not ensure UTF-8 encoding for $output_file."
    }

    echo -e "${GREEN} Step $((step_index + 1)) completed. Output saved to: $output_file ${NC}"
}

main() {
    echo -e "${BLUE}Starting script...${NC}"

    # Validate the configuration file
    if ! jq '.' "$CONFIG_FILE" > /dev/null 2>&1; then
        echo -e "${RED}Error${NC}: Invalid JSON format in $CONFIG_FILE"
        exit 1
    fi

    local total_steps=$(jq '.steps | length' "$CONFIG_FILE")

    # Record start time
    start_time=$(date +%s)

    for ((i=0; i<total_steps; i++)); do
        echo -e "${BLUE}Processing step $(($i+1))/${total_steps}${NC}"
        process_step "$i"
    done

    # Calculate total time
    end_time=$(date +%s)
    total_seconds=$((end_time - start_time))
    echo -e "\n${BLUE}Total execution time: $(($total_seconds / 60)) minutes and $(($total_seconds % 60)) seconds${NC}"

    # Create results directory named after today's date
    current_date=$(date +%Y%m%d%HH%MM)
    results_dir="results_$current_date"
    echo -e "${BLUE}Creating results directory: $results_dir${NC}"
    mkdir -p "$results_dir"

    # Copy steps.json and all output files to results directory
    echo -e "${BLUE}Copying configuration and results to $results_dir${NC}"
    cp "$CONFIG_FILE" "$results_dir/"

    # Extract all output file paths from the JSON and copy them
    jq -r '.steps[].output_file' "$CONFIG_FILE" | while read -r output_path; do
        if [[ -f "$output_path" ]]; then
            cp "$output_path" "$results_dir/"
            echo -e "${GREEN}Copied: $output_path${NC}"
        else
            echo -e "${RED}Warning${NC}: Output file $output_path does not exist."
        fi
    done

    echo -e "${BLUE}Script execution completed successfully!${NC}"
}

# Execute the main function
main "$@"

trap 'echo -e "${RED}Error occurred. Exiting...${NC}"; exit 1' ERR