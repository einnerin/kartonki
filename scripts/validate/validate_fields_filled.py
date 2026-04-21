#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validate that every WordEntity in a given setId has all 6 required text/metadata
fields non-null and non-empty: definition, definitionNative, example, exampleNative,
pos, semanticGroup.

Exit 0 if all fields populated, 1 if any missing.
"""
import sys
import io
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402


REQUIRED_FIELDS = [
    "definition", "definitionNative",
    "example", "exampleNative",
    "pos", "semanticGroup",
]


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    missing = []
    for w in words:
        bad = [f for f in REQUIRED_FIELDS if not w.get(f)]
        if bad:
            missing.append((w["id"], w["original"], bad))
    if missing:
        print(f"❌ setId={set_id}: {len(missing)}/{len(words)} words missing required fields")
        for wid, orig, bad in missing[:15]:
            print(f"    {wid} «{orig}» → missing: {', '.join(bad)}")
        if len(missing) > 15:
            print(f"    ... and {len(missing) - 15} more")
        return 1
    print(f"✅ setId={set_id}: all {len(words)} words have required fields")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_fields_filled.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
