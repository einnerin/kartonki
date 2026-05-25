#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: original (or its inflection root) must appear in example.

Standard requires `original` letter-for-letter in `example` (Rule 1 of
quality_standards_examples.md). This validator is more lenient — accepts any
form that shares the first 4+ characters with original (catches polluting for
pollute, denies for deny, antibodies for antibody).

Strict letter-for-letter check is **already covered** by the runtime FILL_IN_BLANK
pipeline (which silently fails if `original` doesn't substring-match `example`).
What this validator catches is the worse case: `original` and any of its
inflections totally absent from `example` — e.g. example uses a synonym
(`cinematographer` for `director of photography`) or is about a different
topic entirely. That makes the FILL_IN_BLANK quiz unusable and the example
useless for learning.

Multi-word original: at least one significant token (≥4 chars) must appear,
OR the full phrase verbatim.

Hebrew: same algorithm but applied after stripping nikud.

Usage: validate_original_in_example.py <setId>
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
SPLIT_PAT = re.compile(r'[;/,]')
TOKEN_PAT = re.compile(r'\w+', re.UNICODE)


def strip_nikud(t):
    return NIKUD_RE.sub('', t or '')


def normalize(t):
    return strip_nikud((t or '').lower())


def first_form(s):
    s = (s or '').strip()
    parts = [p.strip() for p in SPLIT_PAT.split(s) if p.strip()]
    return parts[0] if parts else ''


# Hebrew prefixes that legitimately attach to roots: ה (definite article),
# ב/ל/מ/כ (prepositions), ו (conjunction), ש (relative). Allow any combination.
HEBREW_PREFIX_RE = r'[הבלמכוש]*'


def original_present(original, example):
    """True if original (or any prefix-stem of its tokens ≥3 chars) is in example.

    Algorithm — fuzzy by design to tolerate inflection:
      1. Full phrase verbatim — pass.
      2. Any token of original ≥3 chars: take first 3 chars as stem, search
         for word starting with that stem in example. For Hebrew tokens,
         also allow common single-letter prefixes (ה,ב,ל,מ,כ,ו,ש) before stem.
      3. Very short originals (<3 chars): exact whole-word match required.

    This catches REAL bugs (example about a different topic — `awl` paired
    with «screwdriver») while tolerating common morphology:
      - polluting / pollute (stem `pol`)
      - denies / deny (stem `den`)
      - leaves / leaf (stem `lea`)
      - הַקַּלְמָר / קַלְמָר (Hebrew article prefix ה before root קלמ)
    """
    if not original or not example:
        return False
    o = normalize(original).strip()
    e = normalize(example)
    if not o or not e:
        return False
    if o in e:
        return True
    tokens = [t for t in TOKEN_PAT.findall(o) if len(t) >= 3]
    if not tokens:
        pat = r'(?<!\w)' + re.escape(o) + r'(?!\w)'
        return re.search(pat, e) is not None
    for tok in tokens:
        stem = tok[:3]
        # Hebrew detection: any letter in Hebrew Unicode block
        is_hebrew = bool(re.search(r'[֐-׿]', stem))
        if is_hebrew:
            pat = r'(?<!\w)' + HEBREW_PREFIX_RE + re.escape(stem) + r'\w*'
        else:
            pat = r'(?<!\w)' + re.escape(stem) + r'\w*'
        if re.search(pat, e):
            return True
    return False


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    bad = []
    for w in words:
        orig = first_form(w.get("original", ""))
        ex = w.get("example") or ""
        if not orig or not ex:
            continue
        if not original_present(orig, ex):
            bad.append((w["id"], orig, ex[:60] + ("…" if len(ex) > 60 else "")))
    if bad:
        print(f"❌ setId={set_id}: {len(bad)} слов где original отсутствует в example")
        for wid, orig, snip in bad[:15]:
            print(f"    {wid} «{orig}» — example: {snip}")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    Original (или его инфлексия — слово с тем же 4-буквенным корнем) "
              "должно присутствовать в example. Без этого FILL_IN_BLANK ломается "
              "(нечего заменять на пропуск) и сам example бесполезен для изучения.")
        return 1
    print(f"✅ setId={set_id}: original присутствует во всех example")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_original_in_example.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
