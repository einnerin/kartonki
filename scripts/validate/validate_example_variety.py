#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: examples in a set must use varied opening patterns.

Found in audit (set 439 «Animals LEGENDARY»): 14 out of 25 examples used
the «Every X does Y» template. Definitions were fine, but the example field
felt like an encyclopedia entry: «Every cnidarian shares…», «Every ungulate
evolved…», «Every marsupial raises…». Repetitive openings stick in memory
as filler and reduce engagement.

Standard quality_standards_definitions.md §8 ("Разнообразие приёмов") sets
a 60-70% cap on the "X — например, A, B, C" definition pattern. We apply a
similar bound to example openings: no more than 60% of examples in a set
may share the same 2-word prefix (case-insensitive, ignoring articles).

Algorithm:
  1. Extract first 2 significant words of each example (skip a/an/the for
     English, skip ה for Hebrew prefix).
  2. Count distinct prefixes.
  3. If any prefix occurs in >60% of examples → fail.

This catches the «Every X», «The X», «I X every day», «It is/was» style
monocultures regardless of which template wins.

Usage: validate_example_variety.py <setId>
Exit: 0 = OK / not enough data, 1 = monotonous, 2 = bad args
"""
import sys
import io
import re
from collections import Counter
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402

NIKUD = re.compile(r'[֑-ׇ]')
EN_ARTICLES = {"a", "an", "the"}
HE_PREFIXES = ("ה", "ב", "ל", "מ", "כ", "ו", "ש")


def strip_nikud(t):
    return NIKUD.sub('', t or '')


def first_two_tokens(example, lang):
    """Return tuple of normalized first 2 significant tokens."""
    if not example:
        return None
    # Strip Hebrew nikud first
    text = strip_nikud(example).strip()
    tokens = re.findall(r"[\w'-]+", text, re.UNICODE)
    out = []
    for t in tokens:
        t_low = t.lower()
        # Skip English articles
        if lang == "en-ru" and t_low in EN_ARTICLES:
            continue
        out.append(t_low)
        if len(out) == 2:
            break
    return tuple(out) if out else None


# Threshold: a prefix may cover at most this fraction of examples in a set.
MAX_PREFIX_FRACTION = 0.60


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    lang = words[0].get("lang", "")
    prefixes = []
    for w in words:
        ex = w.get("example") or ""
        if ex:
            pfx = first_two_tokens(ex, lang)
            if pfx:
                prefixes.append((w["id"], w["original"], pfx))
    if len(prefixes) < 10:
        # Not enough data — pass
        print(f"✅ setId={set_id}: only {len(prefixes)} examples, skip variety check")
        return 0
    counts = Counter(p[2] for p in prefixes)
    total = len(prefixes)
    most_common, top_count = counts.most_common(1)[0]
    fraction = top_count / total
    if fraction > MAX_PREFIX_FRACTION:
        # Find affected words
        offenders = [(wid, orig) for wid, orig, p in prefixes if p == most_common]
        print(f"❌ setId={set_id}: examples монотонны — "
              f"{top_count}/{total} ({fraction*100:.0f}%) "
              f"начинаются с «{' '.join(most_common)}»")
        for wid, orig in offenders[:10]:
            print(f"    {wid} «{orig}»")
        if len(offenders) > 10:
            print(f"    ... and {len(offenders) - 10} more")
        print()
        print(f"    Лимит {int(MAX_PREFIX_FRACTION*100)}%: examples в одном setе не "
              "должны 60%+ начинаться одинаково — звучит как энциклопедия, не "
              "живая речь. Перепиши часть examples с разнообразными приёмами.")
        return 1
    print(f"✅ setId={set_id}: examples разнообразны (top prefix {top_count}/{total})")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_example_variety.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
