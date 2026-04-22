#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Verify that staged WordData*.kt changes consist ONLY of isFillInBlankSafe
marker additions — no changes to any content or identity field. Used by the
pre-commit hook when METADATA_ONLY_COMMIT=1 is set, as a safety net so that
flag cannot be misused to slip unrelated content changes past the quality
gates.

Exit 0 when every staged WordData*.kt line change is "added isFillInBlankSafe
marker and nothing else". Exit 1 otherwise, with a diagnostic showing the
offending lines.

Whitelist is intentionally narrow: only `isFillInBlankSafe` marker additions
with their separator punctuation are considered legitimate. Any other field
touch (even whitespace-only reformatting) fails the check.
"""
import argparse
import io
import os
import re
import subprocess
import sys
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

# The marker together with its attaching separator. mark_ambiguous_blanks.py
# emits exactly one of two byte-strings right before the closing ')':
#   - `, isFillInBlankSafe = false`  — Case A (no trailing comma in the block)
#   - ` isFillInBlankSafe = false`   — Case B (block already ends with ',\n  )')
# We match those two literal forms (with a small tolerance around `=` for
# future tweaks). The pattern MUST NOT be greedy on surrounding whitespace —
# doing so strips legitimate indentation from trailing-comma lines and
# produces false positives.
_MARKER_PATTERN = re.compile(r'(?:, | )isFillInBlankSafe\s*=\s*false')

_DATA_DIR_PREFIX = "app/src/main/java/com/example/kartonki/data/"


def load_diff(diff_file: str | None) -> str:
    if diff_file:
        return Path(diff_file).read_text(encoding="utf-8", errors="replace")
    result = subprocess.run(
        ["git", "diff", "--cached", "-U0", "--", _DATA_DIR_PREFIX],
        capture_output=True, text=True, encoding="utf-8", errors="replace",
    )
    return result.stdout


def parse_hunks(diff_text: str):
    """
    Parse a unified diff and yield (file, removed_lines, added_lines) tuples,
    one per hunk. Context lines are ignored (we pass -U0 so there shouldn't
    be any). Hunks are flushed on every `@@` header and at every file boundary.
    """
    hunks = []
    current_file = None
    removed: list[str] = []
    added: list[str] = []
    in_hunk = False

    def flush():
        if current_file and (removed or added):
            hunks.append((current_file, list(removed), list(added)))
        removed.clear()
        added.clear()

    for raw in diff_text.split('\n'):
        if raw.startswith('diff --git'):
            flush()
            m = re.match(r'diff --git a/(.*?) b/', raw)
            current_file = m.group(1) if m else None
            in_hunk = False
        elif raw.startswith('+++') or raw.startswith('---'):
            continue
        elif raw.startswith('@@'):
            flush()
            in_hunk = True
        elif in_hunk:
            if raw.startswith('-'):
                removed.append(raw[1:])
            elif raw.startswith('+'):
                added.append(raw[1:])
            # Context (' ' prefix) — ignored; won't appear with -U0
    flush()
    return hunks


def normalize_added(added_line: str) -> str:
    """Remove the isFillInBlankSafe marker (with its separator) if present."""
    return _MARKER_PATTERN.sub('', added_line, count=1)


def validate(diff_file: str | None = None) -> int:
    diff = load_diff(diff_file)
    if not diff.strip():
        print("✅ METADATA_ONLY_COMMIT check: no WordData changes in staged diff.")
        return 0

    hunks = parse_hunks(diff)
    violations: list[tuple[str, str]] = []

    for kt_file, removed, added in hunks:
        if not kt_file.endswith('.kt') or 'WordData' not in kt_file:
            # Only enforce on seed data files; anything else will be caught
            # by the normal hook path.
            continue
        if kt_file.endswith('WordDataVersion.kt'):
            # Bumped by any data commit; version change is required-adjacent,
            # not a content edit. Hook block 2c enforces the bump elsewhere.
            continue
        if len(removed) != len(added):
            violations.append((
                kt_file,
                f"hunk counts differ: {len(removed)} removed vs {len(added)} added "
                f"— not a pure marker injection",
            ))
            continue
        for r_line, a_line in zip(removed, added):
            if normalize_added(a_line) != r_line:
                r_short = r_line.rstrip()[:110]
                a_short = a_line.rstrip()[:110]
                violations.append((
                    kt_file,
                    f"non-whitelisted change:\n"
                    f"      - {r_short}\n"
                    f"      + {a_short}",
                ))

    if violations:
        print("❌ METADATA_ONLY_COMMIT check FAILED: diff touches non-whitelisted fields.")
        print("   Whitelist is {isFillInBlankSafe}. Anything else requires a normal commit.")
        for f, msg in violations[:25]:
            print(f"  {f}: {msg}")
        if len(violations) > 25:
            print(f"  ... and {len(violations) - 25} more violations")
        return 1

    print("✅ METADATA_ONLY_COMMIT check OK: every diff line is a pure marker addition.")
    return 0


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "--diff-file",
        help="Read unified diff from a file instead of running git diff "
             "(used by unit tests in .githooks/tests/).",
    )
    args = parser.parse_args()
    return validate(args.diff_file)


if __name__ == "__main__":
    sys.exit(main())
