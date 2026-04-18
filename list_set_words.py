#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import re, io, sys
from pathlib import Path
from collections import defaultdict
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
DATA_DIR = Path("app/src/main/java/com/example/kartonki/data")

def extract_field(block, field_name):
    m = re.search(field_name + r'\s*=\s*"((?:[^"\\]|\\.)*)"', block)
    return m.group(1) if m else None

all_he_ru = set()
set_words = defaultdict(list)

for kt_file in sorted(DATA_DIR.glob("WordData*.kt")):
    content = kt_file.read_text(encoding="utf-8")
    parts = re.split(r'(?=WordEntity\s*\()', content)
    for part in parts:
        if not part.strip().startswith('WordEntity'):
            continue
        depth = 0; end = -1
        for i, ch in enumerate(part):
            if ch == '(': depth += 1
            elif ch == ')':
                depth -= 1
                if depth == 0: end = i + 1; break
        block = part[:end] if end >= 0 else part
        sid_m = re.search(r'\bsetId\s*=\s*(\d+)', block)
        orig = extract_field(block, 'original')
        lang = extract_field(block, 'languagePair')
        if sid_m and orig and lang == 'he-ru':
            all_he_ru.add(orig)
            set_words[int(sid_m.group(1))].append(orig)

SETS = [1070, 1174]
for sid in SETS:
    print(f"\nSET {sid}:")
    for w in set_words[sid]:
        print(f"  {w}")

# Candidate words not in any set
candidates_1070 = ["כּוֹהֵן", "אֲרוֹן קֹדֶשׁ", "בַּר מִצְוָה", "בַּת מִצְוָה", "מִנְחָה", "תְּפִלִּין"]
candidates_1174 = ["גַּנָּן", "מְלַצֵּר", "שָׁלִיחַ", "גַּבַּאי", "אוֹפְּטוֹמֶטְרִיסְט", "כַּבַּאי"]

print("\n=== Candidates for set 1070 (not in any he-ru set) ===")
for c in candidates_1070:
    status = "TAKEN" if c in all_he_ru else "FREE"
    print(f"  {c}: {status}")

print("\n=== Candidates for set 1174 (not in any he-ru set) ===")
for c in candidates_1174:
    status = "TAKEN" if c in all_he_ru else "FREE"
    print(f"  {c}: {status}")
