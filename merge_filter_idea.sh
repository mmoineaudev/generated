#!/bin/bash

# Target branch
TARGET_BRANCH="main"

# List of users (comma-separated)
USERS="user1,user2,user3"

# Convert user list into an array for easier handling in the loop
IFS=',' read -r -a USER_ARRAY <<< "$USERS"

# Create a temporary file to store merge commits
TEMP_FILE=$(mktemp)

# Extract all merge commits from the target branch
git log --merges --pretty=format:"%H %an" "$TARGET_BRANCH" > "$TEMP_FILE"

# Filter out the merges made by the specified users and print the commit hashes
for USER in "${USER_ARRAY[@]}"; do
    grep "$USER" "$TEMP_FILE"
done

# Clean up temporary file
rm -f "$TEMP_FILE"
