#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validate semanticGroup size distribution within a setId.

Rules (see docs/claude/quality_standards_metadata.md):
- 1 word    → BLOCK (useless for tier1 distractors — broken markup)
- 2 words   → WARN (allowed for antonymic pairs)
- 3-8       → ideal
- 9+        → WARN (not ideal — dilutes tier1 — but works:
              QuizBuilder.pickDistractors still picks 3 random from the pool)

Exit 0 on pass or warnings only, 1 on BLOCK.

History: before 2026-04-23, size ≥13 was BLOCK. Softened to WARN after the
Phase 2 experiment showed that bulk regrouping (splitting 25-in-1 groups
into 3-8-word subgroups) had cascade effects on validate_blank_ambiguity —
new semanticGroup boundaries invalidated the LLM-generated
fillInBlankExclusions and required a full re-run of Phase A on each
regrouped set. 5-7h of work for no user-visible quiz improvement. The
"dangerous twins" philosophy is preserved as an ideal but not enforced.
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
        elif size == 2:
            warns.append(f"{group} ({size} — пара; ок для антонимов)")
        elif size >= 9:
            warns.append(f"{group} ({size} слов — крупная, размывает tier1)")
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
