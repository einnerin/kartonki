#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Simulates Room's insertAllOrReplace behaviour:
  - unique index on (original, languagePair)
  - REPLACE strategy → LAST occurrence in registry order wins

Registry order is derived automatically from WordRegistry.kt allWords —
no manual list to maintain. Adding a new WordData file to WordRegistry.kt
is all that's needed for this script to pick it up.
"""

import re, io, sys
from pathlib import Path
from collections import defaultdict

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

ROOT = Path("app/src/main/java/com/example/kartonki/data")
REGISTRY_FILE = ROOT / "WordRegistry.kt"


def parse_registry_order():
    """
    Parse WordRegistry.kt and return ordered list of .kt filenames
    in the same order they appear in the allWords property.
    Duplicate object references (e.g. achievementRewardWords) are ignored —
    only the first mention of each object counts.
    """
    text = REGISTRY_FILE.read_text(encoding="utf-8")

    # Extract the allWords property body (handles multiline get() = ... val next)
    m = re.search(r'val allWords.*?get\(\)\s*=(.*?)(?=\n[ \t]*val |\Z)', text, re.DOTALL)
    if not m:
        raise RuntimeError("Could not find allWords property in WordRegistry.kt")
    body = m.group(1)

    # Find all WordDataXxx references in order
    seen = set()
    order = []
    for obj_name in re.findall(r'(WordData\w+)\.', body):
        if obj_name not in seen:
            seen.add(obj_name)
            order.append(obj_name + ".kt")
    return order


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
            if ch == '(':
                depth += 1
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
    registry_order = parse_registry_order()

    all_words = []
    for fname in registry_order:
        fpath = ROOT / fname
        if fpath.exists():
            all_words.extend(parse_file(fpath))
        else:
            print(f"  [WARN] file listed in WordRegistry.kt but not found on disk: {fname}")

    print(f"Total words parsed: {len(all_words)}\n")

    # Simulate REPLACE: last occurrence wins
    db = {}
    for w in all_words:
        key = (w["original"], w["lang"])
        db[key] = w

    # Count words per set in the simulated DB
    set_counts = defaultdict(int)
    set_names = {}
    for w in all_words:
        set_names[w["setId"]] = w["file"]
    for w in db.values():
        set_counts[w["setId"]] += 1

    # Find real duplicates
    seen = {}
    real_dupes = []
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
            seen[key] = w
        else:
            seen[key] = w

    print(f"=== Real DB duplicates (same raw original+lang): {len(real_dupes)} ===\n")

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

    print(f"\n=== Sets with != 25 words in simulated DB ===\n")
    problem_sets = {sid: cnt for sid, cnt in set_counts.items() if cnt != 25}
    for sid in sorted(problem_sets):
        print(f"  Set {sid}: {problem_sets[sid]} words [{set_names.get(sid, '?')}]")

    if not problem_sets:
        print("  None — all sets have 25 words!")

    print(f"\nSummary: {len(real_dupes)} stolen words, {len(problem_sets)} sets with != 25 words")

    # Non-zero exit code for use in pre-commit hook
    if real_dupes or problem_sets:
        sys.exit(1)


if __name__ == "__main__":
    main()
