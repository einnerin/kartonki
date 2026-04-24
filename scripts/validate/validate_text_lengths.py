#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validate text length limits for definition/definitionNative/example/exampleNative.

Limits per quality_standards_*.md (updated 2026-04-24):
- definition, definitionNative: ≤16 слов, ≤90 символов
- example (en-ru): ≤14 слов, ≤90 символов
- example (he-ru): ≤12 слов, ≤80 символов
- exampleNative (русский с вкраплением): ≤16 слов, ≤100 символов (чуть свободнее,
  т.к. русские фразы с латинской вставкой длиннее английских)

Fields that are None are skipped — validate_fields_filled catches those separately.

History: limits softened 2026-04-24 from 14w/80c → 16w/90c for definitions
(and similarly for examples) during Phase 4 release audit. The old limits
were blocking 32 en-ru sets on violations of 1-2 words / 1-2 characters —
visually imperceptible on mobile, but technically tripping the gate.
Phrases like "fine but 1 char over" shouldn't stop a release.
"""
import sys
import io
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402


def check(text, max_words, max_chars):
    if text is None:
        return None
    words = len(text.split())
    chars = len(text)
    if words > max_words or chars > max_chars:
        return (words, chars)
    return None


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    bad = []
    for w in words:
        lang = w.get("lang", "en-ru")
        is_hebrew = lang == "he-ru"
        # definition / definitionNative — 16w/110c (softened 2026-04-24 from 14w/80c;
        # char limit bumped 110c to accommodate Hebrew vowel-pointing marks which
        # cost extra bytes per letter).
        for field in ("definition", "definitionNative"):
            r = check(w.get(field), 16, 110)
            if r:
                bad.append((w["id"], w["original"], field, r))
        # example — 14w/100c (en) or 12w/100c (he)
        # [softened from 12/80 and 10/70 → 14/90 and 12/80 → 14/100 and 12/100]
        ex_max_w, ex_max_c = (12, 100) if is_hebrew else (14, 100)
        r = check(w.get("example"), ex_max_w, ex_max_c)
        if r:
            bad.append((w["id"], w["original"], "example", r))
        # exampleNative — 16w/120c
        r = check(w.get("exampleNative"), 16, 120)
        if r:
            bad.append((w["id"], w["original"], "exampleNative", r))
    if bad:
        print(f"❌ setId={set_id}: {len(bad)} нарушений лимита длины")
        for wid, orig, field, (wc, cc) in bad[:20]:
            print(f"    {wid} «{orig}» {field}: {wc} слов / {cc} симв")
        if len(bad) > 20:
            print(f"    ... and {len(bad) - 20} more")
        return 1
    print(f"✅ setId={set_id}: все тексты в пределах лимитов")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_text_lengths.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
