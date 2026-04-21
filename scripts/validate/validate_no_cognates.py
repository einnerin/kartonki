#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Heuristic cognate detection: flag if any stem-like substring of `original` or
`translation` appears in definition/definitionNative. Imperfect — has false
positives (legitimate word overlap) and false negatives (irregular morphology,
synonyms of cognates). Designed to catch obvious мisuse, not substitute for
human review.

Rules:
- English original: stem = first N chars where N = max(4, len-2). Check if
  substring appears in definition (case-insensitive).
- Russian translation: same heuristic — first N chars.
- For multi-word originals: check only the full phrase as a whole. Individual
  components are allowed per the multi-word exception in
  docs/claude/quality_standards_definitions.md.
- Short original (<4 chars): skip cognate check (too prone to false positives).
"""
import sys
import io
import re
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402


# Words to strip from translation before stemming (e.g. "яблоко (Red)" → "яблоко")
PAREN_PAT = re.compile(r'\([^)]*\)')
# Translations often have multiple variants separated by ; or /
TRANSLATION_SPLIT = re.compile(r'[;/,]')


def stem(word):
    """Return a rough stem — first max(4, len-2) chars, lowercased."""
    w = word.strip().lower()
    if len(w) < 4:
        return None
    # cut off last 1-2 chars for English (suffixes s, ed, ing, ly)
    # and 2-3 chars for Russian (ать, ить, ость, ный, ский etc.)
    n = max(4, len(w) - 2)
    return w[:n]


def extract_terms(original, translation):
    """
    Return list of (label, stems) pairs to check.
    For multi-word original: check the full phrase as substring only.
    For single-word: check the stem.
    """
    terms = []
    orig = original.strip().lower()
    if " " in orig or "-" in orig:
        # Multi-word — check full phrase as substring (exact)
        terms.append(("original_phrase", [orig]))
    else:
        s = stem(orig)
        if s:
            terms.append(("original", [s]))
    # Translation — split by separators, strip parens
    tr_clean = PAREN_PAT.sub("", translation).strip()
    for tr in TRANSLATION_SPLIT.split(tr_clean):
        tr = tr.strip().lower()
        if not tr:
            continue
        if " " in tr or "-" in tr:
            # multi-word translation, check phrase
            terms.append(("translation_phrase", [tr]))
        else:
            s = stem(tr)
            if s:
                terms.append(("translation", [s]))
    return terms


def find_cognate(text, terms):
    """Return list of (term_label, matched_fragment) for any stems found in text."""
    if not text:
        return []
    low = text.lower()
    hits = []
    for label, stems in terms:
        for s in stems:
            if s in low:
                hits.append((label, s))
    return hits


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    violations = []
    for w in words:
        terms = extract_terms(w["original"], w["translation"])
        for field in ("definition", "definitionNative"):
            text = w.get(field)
            if not text:
                continue
            # definition (изучаемый язык) — ищем однокоренные original.
            # definitionNative (русский) — ищем И однокоренные translation,
            # И литеральное проникновение original (если автор ленясь вставил
            # английское слово в русский текст — «napkin» в русской деф.).
            # Транслитерацию (computer↔компьютер без общего translation-стема)
            # текущий подход не ловит — это отдельная задача с translit-таблицей.
            if field == "definition":
                relevant = [t for t in terms if t[0] in ("original", "original_phrase")]
            else:  # definitionNative — оба источника
                relevant = [t for t in terms if t[0] in (
                    "translation", "translation_phrase",
                    "original", "original_phrase",
                )]
            hits = find_cognate(text, relevant)
            if hits:
                violations.append((w["id"], w["original"], field, hits))
    if violations:
        print(f"⚠️  setId={set_id}: {len(violations)} возможных однокоренных "
              f"(эвристика — возможны ложные срабатывания)")
        for wid, orig, field, hits in violations[:15]:
            h = ", ".join(f"{lbl}:«{s}»" for lbl, s in hits)
            print(f"    {wid} «{orig}» {field} содержит: {h}")
        if len(violations) > 15:
            print(f"    ... and {len(violations) - 15} more")
        return 1
    print(f"✅ setId={set_id}: явных однокоренных не найдено")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_no_cognates.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
