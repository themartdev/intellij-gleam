#!/usr/bin/env bash
#
# Validates the plugin parser against a Gleam release, locally.
# This is the same fetch + test sequence the gleam-release-watch workflow runs in CI,
# minus the GitHub issue creation.
#
# Usage:
#   scripts/validate-gleam-release.sh [tag] [--with-stdlib] [--skip-fetch]
#
#   tag             Gleam tag, e.g. v1.14.0. Defaults to the latest stable release
#                   (resolved via the GitHub API, no auth needed for public repos).
#   --with-stdlib   Also include the latest stdlib in the corpus.
#   --skip-fetch    Reuse the existing build/gleam-corpus (fast iteration on grammar fixes).
#
# Examples:
#   scripts/validate-gleam-release.sh                          # latest release
#   scripts/validate-gleam-release.sh v1.14.0 --with-stdlib    # specific tag + stdlib
#   scripts/validate-gleam-release.sh v1.14.0 --skip-fetch     # rerun without refetching
#
set -euo pipefail
cd "$(dirname "$0")/.."

TAG=""
WITH_STDLIB=""
SKIP_FETCH=0
for arg in "$@"; do
    case "$arg" in
        --with-stdlib) WITH_STDLIB="--with-stdlib" ;;
        --skip-fetch)  SKIP_FETCH=1 ;;
        v*)            TAG="$arg" ;;
        *) echo "Unknown argument: $arg" >&2; exit 1 ;;
    esac
done

if [[ -z "$TAG" ]]; then
    echo "Resolving latest Gleam release..."
    TAG=$(git ls-remote --tags --refs https://github.com/gleam-lang/gleam.git \
        | awk -F/ '{print $NF}' | grep -E '^v[0-9]+\.[0-9]+\.[0-9]+$' | sort -V | tail -1)
    [[ -n "$TAG" ]] || { echo "Could not resolve latest release" >&2; exit 1; }
    echo "Latest: $TAG"
fi

CORPUS_DIR="$PWD/build/gleam-corpus"
REPORT="$PWD/build/gleam-corpus-report.md"

if [[ "$SKIP_FETCH" -eq 1 && -d "$CORPUS_DIR" ]]; then
    echo "Reusing existing corpus in $CORPUS_DIR"
else
    ./scripts/fetch-gleam-corpus.sh "$TAG" "$CORPUS_DIR" $WITH_STDLIB
fi

echo "Validating parser against Gleam $TAG ..."
set +e
./gradlew test --tests '*GleamExternalCorpusTest' \
    -Pgleam.corpus.dir="$CORPUS_DIR" \
    -Pgleam.corpus.report="$REPORT"
RESULT=$?
set -e

echo
echo "================================================================"
if [[ -f "$REPORT" ]]; then
    cat "$REPORT"
    echo "(report saved to $REPORT)"
fi
if [[ $RESULT -eq 0 ]]; then
    echo "RESULT: PASS - parser handles Gleam $TAG"
else
    echo "RESULT: FAIL - see report above"
fi
exit $RESULT
