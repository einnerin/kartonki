#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: no clerical Russian in definition fields and exampleNative.

Standard quality_standards_definitions.md §4 forbids: «устранить»,
«посредством», «осуществить», «являться», «данный», «указанный», «путём».
quality_standards_examples.md §5 forbids similar constructs in examples:
«является», «используется для», «представляет собой», «характеризуется».

These are stiff bureaucratic phrasings — they make educational text feel like
a 1980s textbook, the opposite of "живой стиль учителя" the standard demands.

Algorithm: scan {definition, definitionNative, example, exampleNative} for any
forbidden token as a whole word (case-insensitive). Multi-word phrases match
as literal substring.

Single-word tokens use word-boundary regex to avoid false positives:
- «данный» does NOT match «данные» (those are intentionally different)
- «путём» does NOT match «путём-сообщения» random hyphenations

Usage: validate_no_clerical.py <setId>
Exit: 0 = clean, 1 = violations, 2 = bad args
"""
import sys
import io
import re
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402

# Canonical list from docs/claude/quality_standards_definitions.md §4 +
# docs/claude/quality_standards_examples.md §5.
# Each entry is matched as a whole-word token (case-insensitive); multi-word
# entries are matched as literal substring.
CLERICAL_TOKENS = [
    # ── Single words — unambiguously bureaucratic ────────────────────────────
    # These have no legitimate non-bureaucratic meaning in educational text.
    "посредством",
    "осуществить",
    "осуществлять",
    "осуществляется",
    "являться",
    "является",
    "являющийся",
    "являющаяся",
    "являющееся",
    "являющиеся",
    "характеризуется",
    "характеризующийся",
    # ── Multi-word phrases — context-disambiguating ──────────────────────────
    # Single tokens like «данный», «указанный», «путём» have legitimate uses
    # («данные» = data; «путём проб» = «via trial»). We only ban them when
    # they appear in unambiguously bureaucratic phrases.
    "представляет собой",
    "представляющий собой",
    "используется для",
    "применяется для",
    "широко применяется",
    "данный объект",
    "данная вещь",
    "данное явление",
    "данный предмет",
    "данная задача",
    "указанный объект",
    "указанная вещь",
    "путём осуществления",
    "путём проведения",
    # ── Removed (too many false positives) ───────────────────────────────────
    # «устранить» — legit for «устранить ошибку»
    # «данный/-ая/-ое/-ые/-ых» — collides with «данные» (data)
    # «указанный/-ая» bare — collides with «выше указанный» factual use
    # «путём/путем» bare — legit «путём проб», «этим путём»
]

# Fields to scan. `definition` for he-ru is Russian — scanned too.
# `definition` for en-ru is English — we still scan (a cyrillic clerical word
# in English text is itself a bug, but won't match these tokens anyway).
FIELDS = ("definition", "definitionNative", "example", "exampleNative")


def find_violations(word):
    bad = []  # list of (field, token, snippet)
    for fld in FIELDS:
        val = (word.get(fld) or "").lower()
        if not val:
            continue
        for tok in CLERICAL_TOKENS:
            if " " in tok:
                # Multi-word: literal substring
                if tok in val:
                    bad.append((fld, tok, _snip_around(word.get(fld), tok)))
                    break
            else:
                # Single word: whole-word match
                pat = r'(?<![а-яё])' + re.escape(tok) + r'(?![а-яё])'
                if re.search(pat, val):
                    bad.append((fld, tok, _snip_around(word.get(fld), tok)))
                    break
    return bad


def _snip_around(text, token):
    """60-char window around the first match."""
    if not text:
        return ""
    low = text.lower()
    i = low.find(token.lower())
    if i < 0:
        return text[:60]
    start = max(0, i - 20)
    end = min(len(text), i + len(token) + 30)
    s = text[start:end]
    if start > 0:
        s = "…" + s
    if end < len(text):
        s = s + "…"
    return s


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    bad = []
    for w in words:
        vios = find_violations(w)
        if vios:
            bad.append((w["id"], w["original"], vios))
    if bad:
        print(f"❌ setId={set_id}: {len(bad)} слов с канцеляритом")
        for wid, orig, vios in bad[:15]:
            for fld, tok, snip in vios:
                print(f"    {wid} «{orig}» — {fld} содержит «{tok}»: {snip}")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    Канцелярит запрещён quality_standards_definitions.md §4 и "
              "quality_standards_examples.md §5. Перепиши живым языком: "
              "«использовать для» → «им X-ят», «представляет собой» → "
              "«это X», «являющийся» → пропустить, «данный» → «этот» / убрать.")
        return 1
    print(f"✅ setId={set_id}: канцелярит не обнаружен")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_no_clerical.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
