#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: text fields must end with sentence terminator.

definition / definitionNative / example / exampleNative — каждое поле должно
заканчиваться на одно из: . ! ? … " ” » ) ]

Why: типографическая чистота. Hebrew examples без точек выглядели как обрывки;
definition'ы без точек смотрелись фрагментами. Стандарт явно требует
«одно предложение» — а предложение заканчивается терминатором.

Usage: validate_text_terminators.py <setId>
Exit: 0 = clean, 1 = violations, 2 = bad args
"""
import sys
import io
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402

TERMINATORS = set('.!?…"”»)]')
FIELDS = ("definition", "definitionNative", "example", "exampleNative")


def violations_for(word):
    bad = []
    for fld in FIELDS:
        val = (word.get(fld) or "").rstrip()
        if not val:
            continue
        if val[-1] not in TERMINATORS:
            bad.append((fld, val[-30:]))
    return bad


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    bad = []
    for w in words:
        vios = violations_for(w)
        if vios:
            bad.append((w["id"], w["original"], vios))
    if bad:
        print(f"❌ setId={set_id}: {len(bad)} слов с полями без терминатора (. ! ? …)")
        for wid, orig, vios in bad[:15]:
            for fld, snip in vios:
                print(f"    {wid} «{orig}» — {fld} оканчивается: …{snip!r}")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    Каждое из definition/definitionNative/example/exampleNative — "
              "одно полное предложение. Допустимые терминаторы: . ! ? … \" ” » ) ]")
        return 1
    print(f"✅ setId={set_id}: все text-поля заканчиваются терминатором")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_text_terminators.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
