#!/usr/bin/env python3
"""
Extracts positive (clean-parse) Gleam source snippets from the gleam compiler's
parse-test snapshots into standalone .gleam files for the corpus validator.

Why snapshots and not tests.rs: the insta snapshots carry the input source in their
YAML front-matter `expression:` field, already separated from the parse tree, and the
presence of an error block / error tree tells us the expected outcome. That is far more
robust than regex-scraping Rust macro invocations.

Two snippet shapes appear:
  - module-level   (assert_parse_module!): starts with imports / pub / type / const / fn
  - statement/expr (assert_parse!, assert_statement!): a bare expression or statement,
    which is NOT a valid top-level module item, so we wrap it in `fn main() { ... }`.

Usage:
  scripts/extract-compiler-parse-tests.py <gleam-repo-or-tag> <out-dir>

If the first arg looks like a tag (vX.Y.Z) it is sparse-cloned; otherwise it is treated
as a path to an existing gleam checkout.
"""
import os
import re
import subprocess
import sys
import tempfile

SNAPSHOT_SUBDIR = "compiler-core/src/parse/snapshots"

# Heuristic: does this source parse as a module, or does it need wrapping in fn main?
MODULE_STARTERS = (
    "import ", "pub ", "type ", "const ", "fn ", "@", "opaque ",
)


def looks_like_module(src: str) -> bool:
    for line in src.strip().splitlines():
        # A byte order mark (U+FEFF) is not Python whitespace, so str.strip() leaves it
        # in place; drop it so a leading BOM doesn't hide a module-level starter keyword.
        line = line.strip().lstrip("\ufeff").strip()
        if not line or line.startswith("//"):
            continue
        return line.startswith(MODULE_STARTERS)
    return False


def unescape_yaml_double_quoted(s: str) -> str:
    # insta writes the input as a double-quoted YAML scalar; handle the escapes that
    # actually occur in these files: \n \t \" \\ and \uXXXX.
    out = []
    i = 0
    while i < len(s):
        c = s[i]
        if c == "\\" and i + 1 < len(s):
            n = s[i + 1]
            mapping = {"n": "\n", "t": "\t", '"': '"', "\\": "\\", "0": "\0", "r": "\r"}
            if n in mapping:
                out.append(mapping[n])
                i += 2
                continue
            if n == "u":
                out.append(chr(int(s[i + 2:i + 6], 16)))
                i += 6
                continue
        out.append(c)
        i += 1
    return "".join(out)


def extract_expression_field(text: str):
    # Front matter is the first `---\n ... \n---\n` block; we want its `expression:` value,
    # which may be a quoted scalar (possibly spanning lines via \n escapes, but insta keeps
    # it on one logical line).
    m = re.search(r"^expression:\s*(.*)$", text, re.MULTILINE)
    if not m:
        return None
    raw = m.group(1).strip()
    if raw.startswith('"'):
        # find the closing unescaped quote
        body = raw[1:]
        result = []
        i = 0
        while i < len(body):
            if body[i] == "\\":
                result.append(body[i:i + 2])
                i += 2
                continue
            if body[i] == '"':
                break
            result.append(body[i])
            i += 1
        return unescape_yaml_double_quoted("".join(result))
    return raw  # unquoted scalar


def is_positive(text: str) -> bool:
    # Body after the second `---` is the parse tree for positives, or an error block /
    # error tree for negatives. Error snapshots contain a top-level error marker.
    body = text.split("---", 2)[-1]
    if "----- ERROR" in body or re.search(r"^error:", body, re.MULTILINE):
        return False
    # Some error cases render as a `ParseError` / `LexicalError` debug tree with no banner.
    if "ParseError" in body or "LexicalError" in body:
        return False
    return True


def resolve_repo(arg: str, workdir: str) -> str:
    if re.fullmatch(r"v\d+\.\d+\.\d+", arg):
        dest = os.path.join(workdir, "gleam")
        subprocess.run(
            ["git", "clone", "--quiet", "--depth", "1", "--branch", arg,
             "--filter=blob:none", "--sparse",
             "https://github.com/gleam-lang/gleam.git", dest],
            check=True,
        )
        subprocess.run(["git", "-C", dest, "sparse-checkout", "set", SNAPSHOT_SUBDIR],
                       check=True)
        return dest
    return arg


def main():
    if len(sys.argv) != 3:
        print(__doc__)
        sys.exit(1)
    repo_arg, out_dir = sys.argv[1], sys.argv[2]
    os.makedirs(out_dir, exist_ok=True)

    with tempfile.TemporaryDirectory() as workdir:
        repo = resolve_repo(repo_arg, workdir)
        snap_dir = os.path.join(repo, SNAPSHOT_SUBDIR)
        if not os.path.isdir(snap_dir):
            print(f"Snapshot dir not found: {snap_dir}", file=sys.stderr)
            sys.exit(1)

        written = skipped_neg = skipped_empty = 0
        for fname in sorted(os.listdir(snap_dir)):
            if not fname.endswith(".snap"):
                continue
            text = open(os.path.join(snap_dir, fname), encoding="utf-8").read()
            if not is_positive(text):
                skipped_neg += 1
                continue
            src = extract_expression_field(text)
            if not src or not src.strip():
                skipped_empty += 1
                continue
            if not looks_like_module(src):
                src = "fn main() {\n" + "\n".join(
                    "  " + line if line.strip() else line
                    for line in src.strip("\n").splitlines()
                ) + "\n}\n"
            elif not src.endswith("\n"):
                src += "\n"

            stem = fname.removeprefix("gleam_core__parse__tests__").removesuffix(".snap")
            with open(os.path.join(out_dir, f"{stem}.gleam"), "w", encoding="utf-8") as fh:
                fh.write(src)
            written += 1

        print(f"Wrote {written} positive snippets to {out_dir}")
        print(f"Skipped {skipped_neg} error snapshots, {skipped_empty} empty")


if __name__ == "__main__":
    main()
