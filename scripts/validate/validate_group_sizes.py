#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validate semanticGroup size distribution within a setId.

Rules (see docs/claude/quality_standards_metadata.md):
- 1 word    → BLOCK (useless for tier1 distractors)
- 2 words   → OK (allowed for antonymic pairs)
- 3-8       → ideal
- 9-12      → WARN (allowed for naturally large axes: months, teens)
- 13+       → BLOCK (dilutes tier1)

Exit 0 on pass or warnings only, 1 on any block.
"""
import sys
import io
from collections import Counter
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    groups = Counter(w.get("semanticGroup") or "(null)" for w in words)
    blocks, warns = [], []
    for group, size in groups.items():
        if size == 1:
            blocks.append(f"{group} (1 слово — нет tier1-близнецов)")
        elif size >= 13:
            blocks.append(f"{group} ({size} слов — слишком большая, дробить)")
        elif size == 2 or 9 <= size <= 12:
            warns.append(f"{group} ({size})")
    if blocks:
        print(f"❌ setId={set_id}: {len(blocks)} нарушений размера групп")
        for b in blocks:
            print(f"    BLOCK: {b}")
        for w in warns:
            print(f"    WARN:  {w}")
        return 1
    if warns:
        print(f"⚠️  setId={set_id}: {len(warns)} групп вне оптимума 3-8 (допустимо)")
        for w in warns:
            print(f"    WARN: {w}")
        return 0
    print(f"✅ setId={set_id}: все {len(groups)} групп в оптимуме 3-8")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_group_sizes.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
