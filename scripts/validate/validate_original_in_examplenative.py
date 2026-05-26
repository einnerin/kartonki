#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: exampleNative must anchor to the studied word.

Two legitimate patterns for exampleNative in Kartonki:
  - Pattern A (embedded original): «Наш dog каждый вечер встречает меня»
  - Pattern B (pure Russian): «Она наполнила тележку овощами» (original=cart)

Both work — Pattern A shows the foreign word in Russian context, Pattern B
shows the Russian translation in context. What's BROKEN is when NEITHER is
present: «Буйную толпу пришлось успокаивать охране» for original=
obstreperous, translation=буйный — neither word appears, learner has no
anchor between sentence and word. This was the bug found in audit (Set 76).

Algorithm:
  1. If original appears literally in exampleNative → OK (Pattern A)
     - For Hebrew: prefix-tolerant via HebrewBlankMatcher
     - For Latin: case-insensitive whole-word
  2. If translation (first form, split by ;/,) — take 4-char stem — appears
     as whole-word start in exampleNative → OK (Pattern B)
     This tolerates Russian inflexion: «тележка» translation stem «теле»
     matches «тележку», «тележке», «тележкой».
  3. Otherwise → fail.

Usage: validate_original_in_examplenative.py <setId>
Exit: 0 = clean, 1 = violations, 2 = bad args
"""
import sys
import io
import re
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402
from hebrew_blank_matcher import can_make_blank  # noqa: E402

SPLIT_PAT = re.compile(r'[;/,]')
PAREN_PAT = re.compile(r'\([^)]*\)')


def first_form(s):
    parts = [p.strip() for p in SPLIT_PAT.split((s or '').strip()) if p.strip()]
    return parts[0] if parts else ''


def translation_canon(translation):
    """First form of translation with parenthetical notes stripped."""
    t = PAREN_PAT.sub('', translation or '').strip()
    return first_form(t)


def original_in_exn(original, exn, lang):
    """True if original (Pattern A) appears in exampleNative."""
    if not original or not exn:
        return False
    if lang == "he-ru":
        return can_make_blank(exn, original)
    pat = r'\b' + re.escape(original) + r'\b'
    return bool(re.search(pat, exn, re.IGNORECASE))


def translation_in_exn(translation, exn):
    """True if translation stem (Pattern B) appears in exampleNative.
    Uses 4-char stem with whole-word start for Russian inflexion tolerance."""
    if not translation or not exn:
        return False
    tokens = re.findall(r'[А-Яа-яЁё]+', translation)
    # Skip Russian function words too short or too common
    SKIP = {"быть", "это", "тот", "сам", "весь", "свой"}
    for tok in tokens:
        if len(tok) < 4:
            continue
        if tok.lower() in SKIP:
            continue
        stem = tok[:4]
        # Whole-word start: no Cyrillic letter before
        pat = r'(?<![А-Яа-яЁё])' + re.escape(stem) + r'[А-Яа-яЁё]*'
        if re.search(pat, exn, re.IGNORECASE):
            return True
    return False


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    bad = []
    for w in words:
        original = first_form(w.get("original", ""))
        translation = translation_canon(w.get("translation", ""))
        exn = w.get("exampleNative") or ""
        if not original or not exn:
            continue
        # Pass if EITHER pattern matches
        if original_in_exn(original, exn, w.get("lang", "")):
            continue
        if translation_in_exn(translation, exn):
            continue
        bad.append((w["id"], original, translation, exn[:70] + ("…" if len(exn) > 70 else "")))
    if bad:
        print(f"❌ setId={set_id}: {len(bad)} слов где exampleNative не якорит ни к "
              f"original, ни к translation")
        for wid, orig, tr, snip in bad[:15]:
            print(f"    {wid} «{orig}» (tr={tr!r}) — exN: {snip}")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    exampleNative должна содержать ЛИБО `original` (как вкрапление: "
              "«Наш dog встречает меня»), ЛИБО производную от `translation` "
              "(«Она наполнила тележку...»). Без обоих — карточка не связывает "
              "слово со смыслом.")
        return 1
    print(f"✅ setId={set_id}: exampleNative якорит к слову")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_original_in_examplenative.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
