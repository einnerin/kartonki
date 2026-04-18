#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Simulates Room's insertAllOrReplace behaviour:
  - unique index on (original, languagePair)
  - REPLACE strategy → LAST occurrence in registry order wins

Registry order mirrors WordRegistry.kt allWords:
  English* → Hebrew* → Immigrant1-6 → HebrewBatch5-39 → Immigrant7-16

Words that appear in multiple sets: the last set "owns" the word in the DB.
Earlier sets lose the word → end up with < 25 entries.

Output: list of affected sets with count of stolen words.
"""

import re, io, sys
from pathlib import Path
from collections import defaultdict

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

DATA_DIR = Path("app/src/main/java/com/example/kartonki/data")

# Registry order — must match WordRegistry.kt allWords exactly
REGISTRY_ORDER = [
    "WordDataEnglish.kt",
    "WordDataEnglishExpanded.kt",
    "WordDataEnglishBatch3.kt",
    "WordDataEnglishBatch4.kt",
    "WordDataEnglishBatch5.kt",
    "WordDataEnglishBatch6.kt",
    "WordDataEnglishBatch7.kt",
    "WordDataEnglishBatch8.kt",
    "WordDataEnglishBatch9.kt",
    "WordDataEnglishBatch10.kt",
    "WordDataEnglishBatch11.kt",
    "WordDataEnglishBatch12.kt",
    "WordDataHebrew.kt",
    "WordDataHebrewEveryday.kt",
    "WordDataHebrewMore.kt",
    "WordDataHebrewAdvanced.kt",
    "WordDataHebrewTech.kt",
    "WordDataHebrewImmigrant.kt",
    "WordDataHebrewImmigrant2.kt",
    "WordDataHebrewImmigrant3.kt",
    "WordDataHebrewImmigrant4.kt",
    "WordDataHebrewImmigrant5.kt",
    "WordDataHebrewImmigrant6.kt",
    "WordDataHebrewImmigrantExtra.kt",
    "WordDataHebrewBatch5.kt",
    "WordDataHebrewBatch6.kt",
    "WordDataHebrewBatch7.kt",
    "WordDataHebrewBatch8.kt",
    "WordDataHebrewBatch9.kt",
    "WordDataHebrewBatch10.kt",
    "WordDataHebrewBatch11.kt",
    "WordDataHebrewBatch12.kt",
    "WordDataHebrewBatch13.kt",
    "WordDataHebrewBatch14.kt",
    "WordDataHebrewBatch15.kt",
    "WordDataHebrewBatch16.kt",
    "WordDataHebrewBatch17.kt",
    "WordDataHebrewBatch18.kt",
    "WordDataHebrewBatch19.kt",
    "WordDataHebrewBatch20.kt",
    "WordDataHebrewBatch21.kt",
    "WordDataHebrewBatch22.kt",
    "WordDataHebrewBatch23.kt",
    "WordDataHebrewBatch24.kt",
    "WordDataHebrewBatch25.kt",
    "WordDataHebrewBatch26.kt",
    "WordDataHebrewBatch27.kt",
    "WordDataHebrewBatch28.kt",
    "WordDataHebrewBatch29.kt",
    "WordDataHebrewBatch30.kt",
    "WordDataHebrewBatch31.kt",
    "WordDataHebrewBatch32.kt",
    "WordDataHebrewBatch33.kt",
    "WordDataHebrewBatch34.kt",
    "WordDataHebrewBatch35.kt",
    "WordDataHebrewBatch36.kt",
    "WordDataHebrewBatch37.kt",
    "WordDataHebrewBatch38.kt",
    "WordDataHebrewBatch39.kt",
    "WordDataHebrewImmigrant7.kt",
    "WordDataHebrewImmigrant8.kt",
    "WordDataHebrewImmigrant9.kt",
    "WordDataHebrewImmigrant10.kt",
    "WordDataHebrewImmigrant11.kt",
    "WordDataHebrewImmigrant12.kt",
    "WordDataHebrewImmigrant13.kt",
    "WordDataHebrewImmigrant14.kt",
    "WordDataHebrewImmigrant15.kt",
    "WordDataHebrewImmigrant16.kt",
]

def extract_field(block, field_name):
    m = re.search(field_name + r'\s*=\s*"((?:[^"\\]|\\.)*)"', block)
    if m:
        return m.group(1)
    m = re.search(field_name + r'\s*=\s*null', block)
    if m:
        return None
    return None

def parse_file(kt_file):
    content = kt_file.read_text(encoding="utf-8")
    words = []
    parts = re.split(r'(?=WordEntity\s*\()', content)
    for part in parts:
        if not part.strip().startswith('WordEntity'):
            continue
        depth = 0
        end = -1
        for i, ch in enumerate(part):
            if ch == '(': depth += 1
            elif ch == ')':
                depth -= 1
                if depth == 0:
                    end = i + 1
                    break
        block = part[:end] if end >= 0 else part

        wid = re.search(r'\bid\s*=\s*(\d+)', block)
        sid = re.search(r'\bsetId\s*=\s*(\d+)', block)
        original = extract_field(block, 'original')
        rarity = extract_field(block, 'rarity')
        lang = extract_field(block, 'languagePair')
        translation = extract_field(block, 'translation')

        if wid and sid and original and lang:
            words.append({
                "id": int(wid.group(1)),
                "setId": int(sid.group(1)),
                "original": original,
                "rarity": rarity,
                "lang": lang,
                "translation": translation or "",
                "file": kt_file.name,
            })
    return words

def main():
    # Parse in registry order
    all_words = []
    for fname in REGISTRY_ORDER:
        fpath = DATA_DIR / fname
        if fpath.exists():
            all_words.extend(parse_file(fpath))
        else:
            print(f"  [WARN] not found: {fname}")

    print(f"Total words parsed: {len(all_words)}\n")

    # Simulate REPLACE: last occurrence wins
    db = {}  # (original, lang) -> word dict
    for w in all_words:
        key = (w["original"], w["lang"])
        db[key] = w  # REPLACE: overwrite

    # Count words per set in the simulated DB
    set_counts = defaultdict(int)
    set_names = {}
    for w in all_words:
        set_names[w["setId"]] = w["file"]

    for w in db.values():
        set_counts[w["setId"]] += 1

    # Find sets with != 25 words
    # Also count words per set in source
    source_counts = defaultdict(int)
    for w in all_words:
        source_counts[w["setId"]] += 1

    # Find real duplicates (same raw original+lang)
    seen = {}
    real_dupes = []  # (original, lang, loser_set, winner_set)
    for w in all_words:
        key = (w["original"], w["lang"])
        if key in seen:
            real_dupes.append({
                "original": w["original"],
                "lang": w["lang"],
                "loser_set": seen[key]["setId"],
                "loser_file": seen[key]["file"],
                "winner_set": w["setId"],
                "winner_file": w["file"],
                "translation": w["translation"],
            })
            seen[key] = w  # update to latest
        else:
            seen[key] = w

    print(f"=== Real DB duplicates (same raw original+lang): {len(real_dupes)} ===\n")

    # Group by loser set
    loser_sets = defaultdict(list)
    for d in real_dupes:
        loser_sets[d["loser_set"]].append(d)

    for sid in sorted(loser_sets):
        stolen = loser_sets[sid]
        file = stolen[0]["loser_file"]
        db_count = set_counts.get(sid, 0)
        print(f"Set {sid} [{file}] → {db_count} words in DB (loses {len(stolen)}):")
        for d in stolen:
            print(f"    '{d['original']}' → stolen by set {d['winner_set']} [{d['winner_file']}]")

    print(f"\n=== Sets with < 25 words in simulated DB ===\n")
    problem_sets = {sid: cnt for sid, cnt in set_counts.items() if cnt != 25}
    for sid in sorted(problem_sets):
        print(f"  Set {sid}: {problem_sets[sid]} words [{set_names.get(sid, '?')}]")

    if not problem_sets:
        print("  None — all sets have 25 words!")

    print(f"\nSummary: {len(real_dupes)} stolen words, {len(problem_sets)} sets with != 25 words")

if __name__ == "__main__":
    main()
