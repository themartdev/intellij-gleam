#!/usr/bin/env bash
set -euo pipefail

# read current pluginVersion (e.g. 0.4.3-SNAPSHOT)
CURRENT=$(grep '^pluginVersion=' gradle.properties | cut -d= -f2)
BASE=${CURRENT%-SNAPSHOT}

# split into parts and bump patch
IFS='.' read -r MAJOR MINOR PATCH <<< "$BASE"
MINOR=$((MINOR + 1))
NEXT="${MAJOR}.${MINOR}.0-SNAPSHOT"

# update gradle.properties
sed -i.bak -E "s/^pluginVersion=.*$/pluginVersion=${NEXT}/" gradle.properties
rm gradle.properties.bak

# emit new version for CI
echo "${NEXT}"
