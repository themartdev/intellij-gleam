#!/usr/bin/env bash
set -euo pipefail

if [[ $# -ne 1 ]]; then
  echo "Usage: $0 <release-version>"
  exit 1
fi

RELEASE_VERSION="$1"
# overwrite pluginVersion in gradle.properties
sed -i.bak -E "s/^pluginVersion=.*$/pluginVersion=${RELEASE_VERSION}/" gradle.properties
rm gradle.properties.bak