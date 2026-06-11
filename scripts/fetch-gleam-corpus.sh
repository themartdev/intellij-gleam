#!/usr/bin/env bash
#
# Fetches a corpus of real Gleam source files to validate the plugin's parser against.
#
# Sources:
#   1. test/language from gleam-lang/gleam at the given tag (the compiler's own
#      language test suite - new syntax shows up here as soon as it ships)
#   2. (optional, --with-stdlib) src/ and test/ from gleam-lang/stdlib at its latest tag
#
# Usage:
#   scripts/fetch-gleam-corpus.sh <gleam-tag> <output-dir> [--with-stdlib]
#
# Example:
#   scripts/fetch-gleam-corpus.sh v1.14.0 build/gleam-corpus --with-stdlib
#
set -euo pipefail

if [[ $# -lt 2 ]]; then
    echo "Usage: $0 <gleam-tag> <output-dir> [--with-stdlib]" >&2
    exit 1
fi

TAG="$1"
OUT_DIR="$(mkdir -p "$2" && cd "$2" && pwd)"
WITH_STDLIB="${3:-}"

WORK_DIR="$(mktemp -d)"
trap 'rm -rf "$WORK_DIR"' EXIT

sparse_fetch() {
    local repo_url="$1" ref="$2" sparse_path="$3" dest="$4" clone_dir
    clone_dir="$WORK_DIR/$(basename "$dest")-clone"
    echo "Fetching $sparse_path from $repo_url at $ref ..."
    git clone --quiet --depth 1 --branch "$ref" --filter=blob:none --sparse "$repo_url" "$clone_dir"
    git -C "$clone_dir" sparse-checkout set "$sparse_path"
    mkdir -p "$dest"
    cp -r "$clone_dir/$sparse_path/." "$dest/"
}

rm -rf "$OUT_DIR/gleam-test-language" "$OUT_DIR/stdlib"

sparse_fetch "https://github.com/gleam-lang/gleam.git" "$TAG" "test/language" "$OUT_DIR/gleam-test-language"

if [[ "$WITH_STDLIB" == "--with-stdlib" ]]; then
    STDLIB_TAG="$(git ls-remote --tags --refs https://github.com/gleam-lang/stdlib.git \
        | awk -F/ '{print $NF}' | grep -E '^v[0-9]+\.[0-9]+\.[0-9]+$' | sort -V | tail -1)"
    echo "Latest stdlib tag: $STDLIB_TAG"
    sparse_fetch "https://github.com/gleam-lang/stdlib.git" "$STDLIB_TAG" "src" "$OUT_DIR/stdlib/src"
    sparse_fetch "https://github.com/gleam-lang/stdlib.git" "$STDLIB_TAG" "test" "$OUT_DIR/stdlib/test"
fi

COUNT="$(find "$OUT_DIR" -name '*.gleam' | wc -l | tr -d ' ')"
echo "Corpus ready: $COUNT .gleam files in $OUT_DIR"
if [[ "$COUNT" -eq 0 ]]; then
    echo "ERROR: no .gleam files fetched" >&2
    exit 1
fi
