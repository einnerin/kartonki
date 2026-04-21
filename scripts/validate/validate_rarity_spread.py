#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validate rarity spread within a setId: all rarities must fit within 2 adjacent
levels on the scale COMMON(0) → UNCOMMON(1) → RARE(2) → EPIC(3) → LEGENDARY(4).

Max allowed spread = max_index - min_index ≤ 1 (i.e. 2 adjacent levels).
"""
import sys
import io
from collections import Counter
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id, RARITY_INDEX, RARITY_ORDER  # noqa: E402


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    rarities = Counter(w["rarity"] for w in words)
    indices = sorted({RARITY_INDEX.get(r, -1) for r in rarities})
    indices = [i for i in indices if i >= 0]
    if not indices:
        print(f"❌ setId={set_id}: no valid rarity values")
        return 1
    spread = indices[-1] - indices[0]
    distribution = ", ".join(f"{RARITY_ORDER[i]}:{rarities.get(RARITY_ORDER[i], 0)}" for i in indices)
    if spread > 1:
        present = [RARITY_ORDER[i] for i in indices]
        print(f"❌ setId={set_id}: разброс {spread+1} смежных уровней (допустимо ≤2)")
        print(f"    Присутствуют: {', '.join(present)}")
        print(f"    Распределение: {distribution}")
        return 1
    print(f"✅ setId={set_id}: разброс {spread+1} уровня ({distribution})")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_rarity_spread.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
