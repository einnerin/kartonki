#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: russian translation must NOT appear in its own
definitionNative.

Mirror of validate_no_headword_in_def.py: that one guards the study-language
side (original in definition), this one guards the russian side (translation
in definitionNative). Symmetric class of bug.

definitionNative renders on LEGENDARY card flip next to translation
(CardView.kt). If the russian word from translation appears literally in the
explanation, the learner sees the answer in the explanation text — same
tautology problem as headword-in-definition, just for the opposite field.

Multi-value translations split by [;/,] — we check the FIRST variant only
(canonical) to avoid false positives from alternative forms appearing
anywhere.

Usage: validate_no_translation_in_defnative.py <setId>
Exit: 0 = clean, 1 = violations, 2 = bad args
"""
import sys
import io
import re
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402

PAREN_PAT = re.compile(r'\([^)]*\)')
SPLIT_PAT = re.compile(r'[;/,]')

# Russian function words too common to flag — appear as glue in any text.
# Keep tight: only words that genuinely cannot be paraphrased away.
COMMON_GLUE = {
    "еда", "вода", "дом", "день", "ночь", "год", "час", "рука",
}


def normalize(text):
    return (text or '').lower().strip()


def canonical_translation(translation):
    """First variant of translation, lowercased, parens stripped."""
    t = PAREN_PAT.sub('', translation or '').strip()
    parts = [p.strip() for p in SPLIT_PAT.split(t) if p.strip()]
    return normalize(parts[0]) if parts else ''


def word_in_text(needle, haystack):
    """Whole-token (multi-word phrase) match of needle in haystack."""
    if not needle or not haystack:
        return False
    n = re.escape(needle)
    # Boundary = no Cyrillic letter, no Latin letter, no digit
    pat = r'(?<![a-zа-яё0-9])' + n + r'(?![a-zа-яё0-9])'
    return re.search(pat, haystack) is not None


def find_violations(word):
    """Return list of (field, snippet) where translation appears in
    definitionNative."""
    translation = word.get("translation") or ""
    def_native = word.get("definitionNative") or ""
    if not translation or not def_native:
        return []
    cand = canonical_translation(translation)
    if not cand or len(cand) < 3:
        return []
    if cand in COMMON_GLUE:
        return []
    if word_in_text(cand, normalize(def_native)):
        snippet = def_native[:60] + ("…" if len(def_native) > 60 else "")
        return [("definitionNative", cand, snippet)]
    return []


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
        print(f"❌ setId={set_id}: {len(bad)} слов содержат translation "
              f"в своём definitionNative (тавтология на LEGENDARY card flip)")
        for wid, orig, vios in bad[:15]:
            for field, cand, snippet in vios:
                print(f"    {wid} «{orig}» — translation:«{cand}» в {field}: {snippet}")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    Русский translation в собственном definitionNative — "
              "тавтология: пользователь на flip видит перевод и тут же его "
              "пересказ. Перепиши definitionNative без упоминания translation, "
              "раскрывая смысл другими словами.")
        return 1
    print(f"✅ setId={set_id}: translation не встречается в собственных definitionNative")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_no_translation_in_defnative.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
