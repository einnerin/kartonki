#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: Hebrew transliteration must NOT use IPA notation.

`transliteration` для he-ru слов — это произносительная подсказка для
русскоязычного учащегося. Конвенция (см. существующие he-ru слова):
  - Латинская транскрипция: `makhshev`, `akhbar`, `tikiya`, `ha'ataka`
  - Допустим апостроф для гортанной смычки: `ma'arakha`, `ha'ataka`
  - Допустимы цифры и acute (хотя стилистически рекомендуется опускать)

ЗАПРЕЩЕНО:
  - IPA-символы: æ ɑ ɔ ə ɛ ɪ ʊ ʌ ɚ ɝ θ ð ʃ ʒ ŋ ː ˈ ˌ ɡ (вместо g)
  - IPA-скобки `[...]` (это en-ru формат)

Why: на карточке he-ru transliteration рендерится одним стилем. Mix IPA-стиля
en-ru и латинский он не отличает — выглядит непоследовательно.

Usage: validate_hebrew_transliteration_format.py <setId>
Exit: 0 = clean, 1 = violations, 2 = bad args
"""
import sys
import io
import re
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import ROOT, parse_words  # noqa: E402

# IPA-only characters that should not appear in Hebrew transliteration.
IPA_FORBIDDEN = set('æɑɔəɛɪʊʌɚɝθðʃʒŋːˈˌɡɹɫɾɲ')


def find_block_transliteration(content, set_id):
    """Find (id, transliteration) for all WordEntity in this setId."""
    out = []
    for m in re.finditer(r'WordEntity\(([^)]*?)\)', content, re.DOTALL):
        block = m.group(1)
        sid_m = re.search(r'\bsetId\s*=\s*(\d+)', block)
        if not sid_m or int(sid_m.group(1)) != set_id:
            continue
        id_m = re.search(r'\bid\s*=\s*(\d+)', block)
        tr_m = re.search(r'\btransliteration\s*=\s*"([^"]+)"', block)
        if id_m and tr_m:
            out.append((int(id_m.group(1)), tr_m.group(1)))
    return out


def validate(set_id):
    bad = []
    # Skeleton sets (all words missing definition) are scheduled for text-author
    # — they're excluded from release via WordRegistry.EXCLUDE_SKELETON_SETS_FROM_RELEASE.
    # Don't gate them on transliteration format; text-author will fix on full fill.
    set_words = []
    for kt in sorted(ROOT.glob("WordData*.kt")):
        if kt.name in ("WordRegistry.kt", "WordDataVersion.kt"):
            continue
        for w in parse_words(kt):
            if w["setId"] == set_id:
                set_words.append(w)
    if not set_words:
        print(f"✅ setId={set_id}: no words found")
        return 0
    if not any(w.get("lang") == "he-ru" for w in set_words):
        return 0  # Not he-ru, skip silently
    if all(not w.get("definition") for w in set_words):
        print(f"✅ setId={set_id}: skeleton set (scheduled for text-author), skipped")
        return 0

    # Find which file contains this setId, then scan it
    for kt in sorted(ROOT.glob("WordData*.kt")):
        if kt.name in ("WordRegistry.kt", "WordDataVersion.kt"):
            continue
        content = kt.read_text(encoding='utf-8')
        if not re.search(rf'\bsetId\s*=\s*{set_id}\b', content):
            continue
        for wid, tr in find_block_transliteration(content, set_id):
            has_ipa = any(c in tr for c in IPA_FORBIDDEN)
            has_brackets = tr.startswith('[') and tr.endswith(']')
            if has_ipa or has_brackets:
                bad.append((wid, tr))
        break

    if bad:
        print(f"❌ setId={set_id}: {len(bad)} he-ru слов с IPA-стилем transliteration")
        for wid, tr in bad[:15]:
            print(f"    {wid} — transliteration = {tr!r}")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    Hebrew transliteration — латинская транскрипция (makhshev, akhbar), "
              "не IPA. Запрещены символы: æ ɑ ɔ ə ɛ ɪ ʊ ʌ θ ð ʃ ʒ ŋ ː ˈ ˌ ɡ "
              "и скобки [...] (это en-ru формат).")
        return 1
    print(f"✅ setId={set_id}: hebrew transliteration в правильном формате")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_hebrew_transliteration_format.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
