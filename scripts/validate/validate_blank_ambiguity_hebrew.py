#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: he-ru words with isFillInBlankSafe=true MUST be
matchable by HebrewBlankMatcher.

Mirror of the Kotlin HebrewBlankMatcher runtime: if Python can_make_blank()
returns False but the word is marked safe, then at runtime FILL_IN_BLANK
will silently fall back to MULTIPLE_CHOICE_TRANSLATION — a quiz-quality
regression invisible from data. Catch it here.

Conversely, if a word is marked isFillInBlankSafe=false but the matcher
CAN find the original in the example, the false flag is over-conservative
— FILL_IN_BLANK would have worked. WARN only (informational; the autofix
script handles this).

Only applies to he-ru. Other languages use strict substring replace at
runtime — they have validate_original_in_example covering the same class.

Usage: validate_blank_ambiguity_hebrew.py <setId>
Exit: 0 = clean, 1 = violations, 2 = bad args
"""
import sys
import io
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402
from hebrew_blank_matcher import can_make_blank  # noqa: E402


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    # Skip non-Hebrew sets silently — they're not in our scope.
    if not any(w.get("lang") == "he-ru" for w in words):
        print(f"✅ setId={set_id}: not he-ru, skipped")
        return 0
    bad = []
    warn = []
    for w in words:
        if w.get("lang") != "he-ru":
            continue
        ex = w.get("example") or ""
        orig = w.get("original") or ""
        if not ex or not orig:
            continue
        can = can_make_blank(ex, orig)
        is_safe = w.get("isFillInBlankSafe", True)
        if is_safe and not can:
            bad.append((w["id"], orig, ex[:50]))
        elif not is_safe and can:
            warn.append((w["id"], orig, ex[:50]))
    if bad:
        print(f"❌ setId={set_id}: {len(bad)} he-ru слов помечены safe, "
              f"но matcher не найдёт original в example (FILL_IN_BLANK сломается)")
        for wid, orig, snip in bad[:15]:
            print(f"    {wid} «{orig}» — ex: {snip}…")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    Либо поставь isFillInBlankSafe = false (если форма слова в example "
              "отличается от original за пределами prefix-letters ה/ב/ל/מ/כ/ו/ש), "
              "либо перепиши example чтобы original был распознан matcher'ом.")
        return 1
    if warn:
        print(f"⚠️  setId={set_id}: {len(warn)} he-ru слов помечены unsafe "
              f"но matcher МОЖЕТ найти original (можно разморозить)")
        for wid, orig, snip in warn[:5]:
            print(f"    {wid} «{orig}» — ex: {snip}…")
        if len(warn) > 5:
            print(f"    ... and {len(warn) - 5} more")
        print()
        print("    Не блокирует, но если убрать isFillInBlankSafe = false — "
              "квиз FILL_IN_BLANK будет работать корректно.")
    print(f"✅ setId={set_id}: he-ru blank-ambiguity OK")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_blank_ambiguity_hebrew.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
