#!/bin/bash

# Colors for terminal output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'  # No Color

# Script documentation
echo -e "${BLUE}=== JSON Configuration Generator ===${NC}"
echo "This script generates a JSON configuration file for processing steps."
echo "Each step includes model, prompt, input and output filenames."

# Initialize an empty array to store the steps
steps=()

while true; do
    # Clear screen
    echo -e "\n${YELLOW}=== New Step ===${NC}"

    echo "$(ollama list)"
    # Read model name with example
    echo -e "${BLUE}[Model]${NC} Enter model name : ${GREEN}"
    read -p " " model
    
    # Read input filename
    echo -e "${BLUE}[Input]${NC} Enter input filename: ${GREEN}"
    read -p " " input_file
    
    # Read output filename
    echo -e "${BLUE}[Output]${NC} Enter output filename: ${GREEN}"
    read -p " " output_file
    
    # Read prompt text with description
    echo -e "\n${BLUE}[Prompt]${NC} Enter the prompt (press Ctrl+C to exit):"
    read -e prompt

    # Validate that all fields are provided
    if [ -z "$model" ] || [ -z "$output_file" ] || [ -z "$prompt" ]; then
        echo -e "\n${RED}Error:${NC} All fields must be filled."
        continue
    fi

    if [ ! -z "$model" ] && [ ! -z "$output_file" ] && [ ! -z "$prompt" ] && [ -z $input_file ]; then
      # Add the step to the steps array as a JSON object without input
      steps+=("{
          \"model\": \"$model\",
          \"prompt\": \"$prompt\",
          \"output_file\": \"$output_file\"
      }")

    elif [ ! -z "$model" ] && [ ! -z "$output_file" ] && [ ! -z "$prompt" ] && [ ! -z $input_file ]; then 
      
      # Add the step to the steps array as a JSON object
      steps+=("{
          \"model\": \"$model\",
          \"prompt\": \"$prompt\",
          \"input_file\": \"$input_file\",
          \"output_file\": \"$output_file\"
      }")

    fi

    # Ask if the user is finished adding steps
    echo -e "\n${BLUE}Are you finished?${NC} (y/n) ${GREEN}" 
    read -p "" finish
    
    if [ "$finish" == "y" ]; then
        break
    fi

done

# Construct and format the JSON output
json_output="{ \"steps\": [ $(printf "%s," "${steps[@]}") "
echo "${json_output}"

json_output="${json_output::-2}  "  # Remove trailing comma

json_output="${json_output} ] }"
echo "${json_output}"
# Output the generated JSON with proper formatting using jq if available
echo -e "\n${YELLOW}=== Generated JSON ===${NC}"
if command -v jq &> /dev/null; then
    echo "$json_output" | jq .
else
    echo -e "${RED}Warning:${NC} jq not installed. Output will not be formatted."
    echo "$json_output"
fi

echo $json_output > steps_$(date +%Y%m%d%HH%MM).json

# Exit message
echo -e "\n${GREEN}=== Script completed successfully ===${NC}"

exit 0