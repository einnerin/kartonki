#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: original must use script matching its languagePair.

We caught one such bug by accident (id=101625 had Arabic ت U+062A instead of
Hebrew ת U+05EA). The two glyphs look IDENTICAL in most fonts but are different
codepoints, so:
  - validate_no_headword_in_def doesn't match the original against the example
  - quizzes silently break with no visible cause
  - copy-paste from another source can introduce mixed-script silently

This validator enforces script consistency:
  - he-ru:  `original` may contain only Hebrew letters (U+0590-U+05FF range)
            + ASCII punctuation, spaces, and ASCII apostrophe.
            Latin letters allowed (for international tech terms like "API"
            embedded inside compound Hebrew phrases — rare but legitimate).
            Arabic, Cyrillic, etc → BLOCK.
  - en-ru:  `original` may contain only Latin letters + ASCII punctuation
            (including hyphen, apostrophe).
            Hebrew, Cyrillic, Arabic → BLOCK.

Usage: validate_no_foreign_script_in_original.py <setId>
Exit: 0 = clean, 1 = violations, 2 = bad args
"""
import sys
import io
import unicodedata
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402

# Unicode block ranges
HEBREW_RANGE = (0x0590, 0x05FF)       # Hebrew + nikud
ARABIC_RANGE = (0x0600, 0x06FF)       # Arabic (the trap!)
CYRILLIC_RANGE = (0x0400, 0x04FF)     # Russian, Ukrainian, etc.
LATIN_BASIC = (0x0041, 0x007A)        # A-Z, a-z (with gaps; we'll use isalpha + ord)


def script_of(ch):
    cp = ord(ch)
    if HEBREW_RANGE[0] <= cp <= HEBREW_RANGE[1]:
        return "hebrew"
    if ARABIC_RANGE[0] <= cp <= ARABIC_RANGE[1]:
        return "arabic"
    if CYRILLIC_RANGE[0] <= cp <= CYRILLIC_RANGE[1]:
        return "cyrillic"
    if ch.isalpha():
        # Heuristic: any other alphabetic codepoint that maps to Latin block
        try:
            name = unicodedata.name(ch, "")
            if "LATIN" in name:
                return "latin"
            return "other"
        except Exception:
            return "other"
    return None  # punctuation / digit / space — not a letter


# Allowed scripts per languagePair.
ALLOWED = {
    "he-ru": {"hebrew", "latin", None},   # latin for embedded brand/tech words
    "en-ru": {"latin", None},              # strict
}


def find_violations(word):
    lang = word.get("lang")
    orig = word.get("original") or ""
    if not lang or not orig:
        return []
    allowed = ALLOWED.get(lang)
    if allowed is None:
        return []  # Unknown languagePair — skip
    bad_chars = []
    for ch in orig:
        s = script_of(ch)
        if s not in allowed:
            bad_chars.append((ch, s, hex(ord(ch))))
    # Dedupe while preserving order
    seen = set()
    unique = []
    for ch, s, cp in bad_chars:
        key = (ch, cp)
        if key not in seen:
            seen.add(key)
            unique.append((ch, s, cp))
    return unique


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    bad = []
    for w in words:
        vios = find_violations(w)
        if vios:
            bad.append((w["id"], w.get("lang"), w["original"], vios))
    if bad:
        print(f"❌ setId={set_id}: {len(bad)} слов с чужим script в original")
        for wid, lang, orig, vios in bad[:15]:
            chars_summary = ", ".join(f"«{ch}» ({s}, {cp})" for ch, s, cp in vios[:3])
            print(f"    {wid} [{lang}] «{orig}»: {chars_summary}")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    Опечатка — символ выглядит как hebrew/latin, но кодпоинт из "
              "другого алфавита (например Arabic ت U+062A vs Hebrew ת U+05EA, "
              "Cyrillic а U+0430 vs Latin a U+0061). Заменить на правильный кодпоинт.")
        return 1
    print(f"✅ setId={set_id}: original содержит только корректный script")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_no_foreign_script_in_original.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
