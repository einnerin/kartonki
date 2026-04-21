#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validate that every word in a setId has a pos value from the allowed set
(long forms only). See docs/claude/quality_standards_metadata.md.
"""
import sys
import io
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id, ALLOWED_POS  # noqa: E402


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    bad = []
    for w in words:
        pos = w.get("pos")
        if not pos or pos not in ALLOWED_POS:
            bad.append((w["id"], w["original"], pos or "(null)"))
    if bad:
        print(f"❌ setId={set_id}: {len(bad)} слов с недопустимым pos")
        print(f"    Допустимы: {', '.join(sorted(ALLOWED_POS))}")
        for wid, orig, pos in bad[:20]:
            print(f"    {wid} «{orig}» → pos=\"{pos}\"")
        if len(bad) > 20:
            print(f"    ... and {len(bad) - 20} more")
        return 1
    print(f"✅ setId={set_id}: все {len(words)} слов имеют pos из допустимого множества")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_pos_values.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
