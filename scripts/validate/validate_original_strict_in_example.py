#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: en-ru original must appear in example LETTER-FOR-LETTER.

Stricter cousin of validate_original_in_example.py — that one uses 3-char stem
matching to tolerate inflexions (cookie/cookies passes). This one enforces
Rule 1 of quality_standards_examples.md: the original word stands in the
example exactly as written, modulo case at sentence start.

Why strict matters: the runtime FILL_IN_BLANK does case-insensitive substring
replace (`example.replace(original, "_____", ignoreCase = true)`). If example
has `cookies` but original is `cookie`, the replace matches the substring
→ result is `___s` in the UI — ugly trailing letter. Worse, the blank becomes
ambiguous (cookies/brownies/muffins all read the same).

Scope:
  - en-ru only. Hebrew has its own runtime matcher (HebrewBlankMatcher) with
    prefix tolerance — strict letter-for-letter would over-block legitimate
    Hebrew morphology. validate_blank_ambiguity_hebrew handles he-ru.
  - Multi-word originals: full phrase substring (case-insensitive).
  - Pluralia tantum (scissors, trousers, etc.) whitelisted — these words
    only exist in plural form, so `original` IS the plural.

Usage: validate_original_strict_in_example.py <setId>
Exit: 0 = clean / non-en-ru, 1 = violations, 2 = bad args
"""
import sys
import io
import re
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402

# Pluralia tantum from docs/claude/quality_standards_examples.md §1 exception.
PLURALIA_TANTUM = {
    "scissors", "trousers", "pants", "jeans", "shorts", "glasses",
    "sunglasses", "goggles", "pajamas", "clothes", "headphones",
    "binoculars", "tongs", "tweezers", "pliers", "scales", "belongings",
    "surroundings", "stairs",
}

SPLIT_PAT = re.compile(r'[;/,]')


def first_form(original):
    parts = [p.strip() for p in SPLIT_PAT.split((original or "").strip()) if p.strip()]
    return parts[0] if parts else ""


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    # Skip non-en-ru sets silently
    if not any(w.get("lang") == "en-ru" for w in words):
        print(f"✅ setId={set_id}: not en-ru, skipped")
        return 0
    bad = []
    for w in words:
        if w.get("lang") != "en-ru":
            continue
        first = first_form(w.get("original", ""))
        ex = w.get("example") or ""
        if not first or not ex:
            continue
        if first.lower() in PLURALIA_TANTUM:
            continue
        # Whole-word, case-insensitive
        pat = r'\b' + re.escape(first) + r'\b'
        if not re.search(pat, ex, re.IGNORECASE):
            bad.append((w["id"], first, ex[:60] + ("…" if len(ex) > 60 else "")))
    if bad:
        print(f"❌ setId={set_id}: {len(bad)} en-ru слов где original "
              f"отсутствует буква-в-букву в example")
        for wid, orig, snip in bad[:15]:
            print(f"    {wid} «{orig}» — ex: {snip}")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    Rule 1 стандарта quality_standards_examples.md: целевое слово "
              "должно стоять в example БУКВА-В-БУКВУ как в `original`. "
              "Inflexion (cookies для cookie, eats для eat, walked для walk) "
              "ломает FILL_IN_BLANK → \"___s\" / \"___ed\" в UI.")
        print("    Перепиши example в базовой форме слова.")
        return 1
    print(f"✅ setId={set_id}: original буква-в-букву во всех en-ru example")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_original_strict_in_example.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
