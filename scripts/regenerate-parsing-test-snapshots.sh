#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
TARGET_DIR="$SCRIPT_DIR/../src/test/testData/parser"

to_delete=()

while IFS= read -r txt; do
  base="${txt%.txt}"
  shopt -s nullglob
  for sib in "$base".*; do
    if [[ "$sib" != "$txt" ]]; then
      to_delete+=("$txt")
      break
    fi
  done
  shopt -u nullglob
done < <(find "$TARGET_DIR" -type f -name '*.txt')

if [[ ${#to_delete[@]} -eq 0 ]]; then
  echo "No snapshots to delete."
  exit 0
fi

echo "The following .txt snapshots will be deleted:"
printf '  %s\n' "${to_delete[@]}"

read -r -p "Proceed with deletion? [Y/n] " answer
answer=${answer:-Y}

if [[ "$answer" =~ ^[Yy]$ ]]; then
  for file in "${to_delete[@]}"; do
    rm "$file"
    echo "Deleted: $file"
  done
  echo "Done."
else
  echo "Aborted."
  exit 1
fi
