#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: headword must NOT appear in its own definition.

This is a stricter cousin of validate_no_cognates.py. The cognate validator
uses stem-matching heuristics and stays warn-only because of false positives
(notably Hebrew, where the bare-letter stem of a word almost guarantees a
substring match somewhere in a long definition).

This check is narrow and unambiguous:
  - Single-word `original` → check exact whole-word occurrence in `definition`
    (after stripping Hebrew nikud + lowercasing).
  - Multi-word `original` → check the FULL phrase as substring (per quality
    standard, individual component words are allowed in definitions).

When the headword literally appears in its own definition, quizzes degenerate
to surface-form matching: the learner doesn't need to know the word's meaning,
they just look for the matching glyph cluster. This is a 100% bug — promoted
to BLOCKING in the pre-commit hook.

Rationale for separation from validate_no_cognates: that script's stem
heuristic deliberately accepts false positives to catch English/Russian
near-matches (work/working/worker). This script is intentionally strict:
exact match only, no stemming, no false positives.

Usage: validate_no_headword_in_def.py <setId>
Exit: 0 = clean, 1 = violations, 2 = bad args
"""
import sys
import io
import re
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402

NIKUD_RE = re.compile(r'[֑-ׇ]')


def strip_nikud(text):
    return NIKUD_RE.sub('', text or '')


def normalize(text):
    """Lowercase + strip Hebrew nikud."""
    return strip_nikud((text or '').lower())


def word_in_text(needle, haystack):
    """Whole-token match of needle in haystack (both normalized)."""
    if not needle or not haystack:
        return False
    n = re.escape(needle)
    # Boundary = no Hebrew letter, no Latin letter, no Cyrillic letter, no digit
    pat = r'(?<![א-תa-zа-яё0-9])' + n + r'(?![א-תa-zа-яё0-9])'
    return re.search(pat, haystack) is not None


def find_violations(word):
    """Return list of (field, snippet) for fields where headword appears literally."""
    orig = word.get("original") or ""
    if not orig:
        return []
    orig_norm = normalize(orig).strip()
    if not orig_norm:
        return []
    violations = []
    # Only check `definition` (study-language side). definitionNative is in
    # Russian; we don't want to flag Russian headword (translation) presence
    # there — that's validate_no_cognates' job and has different policy.
    text = word.get("definition") or ""
    text_norm = normalize(text)
    if text_norm and word_in_text(orig_norm, text_norm):
        snippet = text[:60] + ("…" if len(text) > 60 else "")
        violations.append(("definition", snippet))
    return violations


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
        print(f"❌ setId={set_id}: {len(bad)} слов содержат original "
              f"в своём definition (грубая ошибка качества квиза)")
        for wid, orig, vios in bad[:15]:
            for field, snippet in vios:
                print(f"    {wid} «{orig}» — {field}: {snippet}")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    Headword в собственном definition превращает квиз в "
              "matching: пользователь видит совпадающую форму и угадывает "
              "без знания значения слова. Перепиши definition без "
              "упоминания самого слова.")
        return 1
    print(f"✅ setId={set_id}: headword не встречается в собственных definitions")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_no_headword_in_def.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
