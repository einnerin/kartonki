#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: no mixed-script characters within a single word.

Found in audit (set 76 id=7602 «ephemeral»): exampleNative "Слава в наши дни
часто **bывает** ephemeral..." — the word «bывает» starts with Latin `b`
(U+0062) instead of Cyrillic `б` (U+0431). They look identical in most fonts
but are different codepoints. Result: invisible typo that breaks search,
spell-check, and any future text processing.

This validator catches the class generically: any single word (alpha
sequence) containing characters from MULTIPLE scripts at once is flagged.
Scripts considered:
  - Latin (a-z, A-Z)
  - Cyrillic (а-я, А-Я)
  - Hebrew (א-ת, U+0590-U+05FF range)

Single-letter "outsiders" allowed in brand names (iPhone, KCal) — we only
flag when 1-2 outsider chars are sandwiched in a ≥3-char native run.
Specifically: a word is bad if it has chars from >1 script AND the minority
script contributes only 1-2 chars (likely a typo, not legitimate brand mix).

Fields scanned: definition, definitionNative, example, exampleNative
(NOT transliteration — that's intentionally Latin-in-Hebrew-set).

Usage: validate_no_mixed_script_in_words.py <setId>
Exit: 0 = clean, 1 = violations, 2 = bad args
"""
import sys
import io
import re
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402

LATIN = re.compile(r'[A-Za-z]')
CYR = re.compile(r'[А-Яа-яЁё]')
HEB = re.compile(r'[֐-׿]')
WORD = re.compile(r'\w+', re.UNICODE)

FIELDS = ("definition", "definitionNative", "example", "exampleNative")


def script_of(ch):
    if LATIN.match(ch):
        return "latin"
    if CYR.match(ch):
        return "cyrillic"
    if HEB.match(ch):
        return "hebrew"
    return None


# Whitelist: minority chars allowed mid-word because of legitimate cross-script
# convention. Letter `h` Latin inside Cyrillic word — convention for Hebrew letter
# ה in academic/religious transliteration: «Бауhаус», «hавдала», «Йеhуда»,
# «зеhут». Almost never a typo for these tokens.
# Letter `х` Cyrillic inside Hebrew word — same logic in reverse, but very rare.
ACCEPTABLE_MINORITY = {
    ("latin", "cyrillic"): {"h"},   # Hebrew ה transliterated as h
    ("cyrillic", "latin"): set(),   # No common case
    ("hebrew", "latin"): set(),
    ("latin", "hebrew"): set(),
}


def find_violations(word_obj):
    bad = []
    for fld in FIELDS:
        text = word_obj.get(fld) or ""
        if not text:
            continue
        for m in WORD.finditer(text):
            tok = m.group(0)
            if len(tok) < 3:
                continue
            counts = {"latin": 0, "cyrillic": 0, "hebrew": 0}
            minority_chars_by_script = {"latin": [], "cyrillic": [], "hebrew": []}
            for ch in tok:
                s = script_of(ch)
                if s:
                    counts[s] += 1
                    minority_chars_by_script[s].append(ch.lower())
            present = [(s, c) for s, c in counts.items() if c > 0]
            if len(present) < 2:
                continue
            present.sort(key=lambda x: -x[1])
            major, major_count = present[0]
            minor, minor_count = present[1]
            if not (minor_count <= 2 and major_count >= 3):
                continue
            # Check whitelist: if all minority chars are acceptable for this pair
            allowed = ACCEPTABLE_MINORITY.get((minor, major), set())
            minority_chars = set(minority_chars_by_script[minor])
            if minority_chars and minority_chars.issubset(allowed):
                continue  # legit convention, not a typo
            bad.append((fld, tok, f"{minor}={minor_count} mid-{major}"))
    return bad


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    out = []
    for w in words:
        vios = find_violations(w)
        if vios:
            out.append((w["id"], w["original"], vios))
    if out:
        print(f"❌ setId={set_id}: {len(out)} слов с mixed-script внутри одного слова")
        for wid, orig, vios in out[:15]:
            for fld, tok, reason in vios:
                print(f"    {wid} «{orig}» — {fld}: word «{tok}» ({reason})")
        if len(out) > 15:
            print(f"    ... and {len(out) - 15} more")
        print()
        print("    Mixed-script внутри одного слова — почти всегда опечатка: "
              "латинская «b» вместо кириллической «б», арабская «ت» вместо "
              "ивритской «ת» и т.п. Глаз не отличит, но кодпоинты разные.")
        return 1
    print(f"✅ setId={set_id}: нет mixed-script слов")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_no_mixed_script_in_words.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
