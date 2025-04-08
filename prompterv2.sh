#!/bin/bash

# Utility functions
function print_header() {
    local message=$1
    echo -e "\033[1;32m== ${message} ==\033[0m"
}

function print_prompt() {
    local message=$1
    echo -e "\033[1;34m${message}\033[0m"
}

function print_warning() {
    local message=$1
    echo -e "\033[1;31m${message}\033[0m"
}

function get_user_confirmation() {
    local prompt=$1
    while true; do
        read -p "${prompt} [y/n]: " answer
        case ${answer} in
            [Yy]) return 0 ;;
            [Nn]) return 1 ;;
            *) echo "Please answer yes or no." ;;
        esac
    done
}

# Main methods
function gather_goal() {
    print_header "Final Goal"
    print_prompt "What is the primary objective you want the AI to achieve?"
    read -p "> " goal
    while ! get_user_confirmation "Confirm your goal: ${goal}"; do
        read -p "> " goal
    done
    result="${goal}"
}

function gather_context() {
    print_header "Context"
    print_prompt "Please provide any relevant background or context."
    read -p "> " context
    while ! get_user_confirmation "Confirm the context: ${context}"; do
        read -p "> " context
    done
    result="${result} | Context: ${context}"
}

function gather_warnings() {
    print_header "Warnings/Constraints"
    print_prompt "List any constraints or warnings for the AI."
    read -p "> " warnings
    while ! get_user_confirmation "Confirm the warnings: ${warnings}"; do
        read -p "> " warnings
    done
    result="${result} | Warnings: ${warnings}"
}

function gather_example() {
    print_header "Example"
    print_prompt "Provide an example of what you expect."
    read -p "> " example
    while ! get_user_confirmation "Confirm the example: ${example}"; do
        read -p "> " example
    done
    result="${result} | Example: ${example}"
}

# Main execution
declare result=""

gather_goal
gather_context
gather_warnings
gather_example

echo -e "\033[1;33mGenerated Prompt:\033[0m"
echo "${result}"
