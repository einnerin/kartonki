#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Comprehensive audit of all word sets.
"""

import re
import sys
import io
from pathlib import Path
from collections import defaultdict

# Force UTF-8 output on Windows
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

DATA_DIR = Path("app/src/main/java/com/example/kartonki/data")

RARITY_LEVEL = {"COMMON": 0, "UNCOMMON": 1, "RARE": 2, "EPIC": 3, "LEGENDARY": 4}
CEFR_LEVEL = {"A1": 0, "A2": 1, "B1": 1, "B2": 2, "C1": 3, "C2": 4}

SUFFIXES = [
    "ing", "ed", "er", "est", "tion", "sion", "ness", "ment",
    "ity", "ive", "al", "ly", "ful", "less", "able", "ible",
    "ise", "ize", "ify", "en"
]

def normalize(s):
    return re.sub(r'[\u05B0-\u05C7]', '', s).strip().lower()

def get_ceiling(description):
    levels = re.findall(r'\b(A1|A2|B1|B2|C1|C2)\b', description or "")
    if not levels:
        return 4
    return max(CEFR_LEVEL.get(l, 0) for l in levels)

def is_derivative(w1, w2):
    w1, w2 = w1.lower().split()[0], w2.lower().split()[0]
    if w1 == w2 or len(w1) < 4 or len(w2) < 4:
        return False
    # Prefix check: shared prefix >= 4 chars and >= 75% of shorter word
    plen = 0
    for a, b in zip(w1, w2):
        if a == b: plen += 1
        else: break
    if plen >= 4 and plen >= min(len(w1), len(w2)) * 0.75:
        return True
    # Suffix stripping
    for s in SUFFIXES:
        for long, short in [(w1, w2), (w2, w1)]:
            if long.endswith(s) and len(long) - len(s) >= 4:
                stem = long[:-len(s)]
                if short == stem or short.startswith(stem):
                    return True
    return False

def extract_field(block, field_name):
    """Extract a field value from a WordEntity block."""
    # Try quoted value
    m = re.search(field_name + r'\s*=\s*"((?:[^"\\]|\\.)*)"', block)
    if m:
        return m.group(1)
    # Try null
    m = re.search(field_name + r'\s*=\s*null', block)
    if m:
        return None
    return None

def parse_all_words():
    """Parse all WordEntity instances by splitting on WordEntity( boundaries."""
    words = []
    set_descriptions = {}

    for kt_file in sorted(DATA_DIR.glob("WordData*.kt")):
        content = kt_file.read_text(encoding="utf-8")

        # Extract set descriptions from comments like "SET 43 — RARE — Academic language"
        for m in re.finditer(r'SET\s+(\d+)[^\n]*?[\u2501\-]{2,}\s*([^\n]+)', content):
            sid = int(m.group(1))
            desc = m.group(2).strip()
            set_descriptions[sid] = desc

        # Split content on WordEntity( to get individual blocks
        parts = re.split(r'(?=WordEntity\s*\()', content)
        for part in parts:
            if not part.strip().startswith('WordEntity'):
                continue

            # Find the matching closing ) - count parens
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
            if end < 0:
                block = part
            else:
                block = part[:end]

            wid = extract_field(block, 'id')
            if not wid:
                m = re.search(r'\bid\s*=\s*(\d+)', block)
                wid = m.group(1) if m else None
            sid = extract_field(block, 'setId')
            if not sid:
                m = re.search(r'\bsetId\s*=\s*(\d+)', block)
                sid = m.group(1) if m else None
            rarity = extract_field(block, 'rarity')
            original = extract_field(block, 'original')
            translation = extract_field(block, 'translation')
            lang = extract_field(block, 'languagePair')

            if wid and sid and original and rarity and lang:
                words.append({
                    "id": int(wid),
                    "setId": int(sid),
                    "original": original,
                    "translation": translation or "",
                    "rarity": rarity,
                    "lang": lang,
                    "file": kt_file.name,
                })

    return words, set_descriptions

def run_audit():
    print("Loading words...")
    words, set_descs = parse_all_words()
    n_sets = len(set(w['setId'] for w in words))
    print(f"Loaded {len(words)} words from {n_sets} sets\n")

    by_set = defaultdict(list)
    for w in words:
        by_set[w["setId"]].append(w)

    all_issues = defaultdict(list)

    # ── 1. Set sizes ──────────────────────────────────────────────────────
    print("=== 1. Set sizes ===")
    for sid in sorted(by_set):
        ws = by_set[sid]
        if len(ws) != 25:
            msg = f"Set {sid}: {len(ws)} words [{ws[0]['file']}]"
            all_issues["size"].append(msg)
            print(f"  {msg}")
    if not all_issues["size"]:
        print("  OK - all sets have 25 words")

    # ── 2. Rarity violations ──────────────────────────────────────────────
    print("\n=== 2. Rarity level violations ===")
    for sid in sorted(by_set):
        desc = set_descs.get(sid, "")
        ceiling = get_ceiling(desc)
        for w in by_set[sid]:
            wlevel = RARITY_LEVEL.get(w["rarity"], 0)
            if wlevel > ceiling:
                msg = f"Set {sid} [{desc[:35]}]: {w['original']} = {w['rarity']}"
                all_issues["rarity"].append(msg)
                print(f"  {msg}")
    if not all_issues["rarity"]:
        print("  OK - no rarity violations (note: sets without CEFR desc are unchecked)")

    # ── 3. Synonyms (same translation in same set) ────────────────────────
    print("\n=== 3. Synonyms within a set ===")
    for sid in sorted(by_set):
        trans_map = defaultdict(list)
        for w in by_set[sid]:
            # Normalize: take first part before / ( ;
            key = re.sub(r'[\s/\(,;].*', '', w["translation"]).strip().lower()
            if len(key) > 2:
                trans_map[key].append(w["original"])
        for trans, originals in trans_map.items():
            if len(originals) > 1:
                msg = f"Set {sid}: [{', '.join(originals)}] -> '{trans}'"
                all_issues["synonyms"].append(msg)
                print(f"  {msg}")
    if not all_issues["synonyms"]:
        print("  OK - no synonyms found")

    # ── 4. Cross-set duplicates ───────────────────────────────────────────
    print("\n=== 4. Cross-set duplicates ===")
    orig_map = defaultdict(list)
    for w in words:
        key = (normalize(w["original"]), w["lang"])
        orig_map[key].append(w["setId"])
    for (orig, lang), sids in sorted(orig_map.items()):
        if len(set(sids)) > 1:
            msg = f"'{orig}' [{lang}] in sets: {sorted(set(sids))}"
            all_issues["duplicates"].append(msg)
            print(f"  {msg}")
    if not all_issues["duplicates"]:
        print("  OK - no cross-set duplicates")

    # ── 5. Derivative pairs within a set ─────────────────────────────────
    print("\n=== 5. Derivative pairs within a set ===")
    for sid in sorted(by_set):
        originals = [w["original"] for w in by_set[sid]]
        for i in range(len(originals)):
            for j in range(i + 1, len(originals)):
                if is_derivative(originals[i], originals[j]):
                    msg = f"Set {sid}: '{originals[i]}' / '{originals[j]}'"
                    all_issues["derivatives"].append(msg)
                    print(f"  {msg}")
    if not all_issues["derivatives"]:
        print("  OK - no derivative pairs found")

    # ── Summary ───────────────────────────────────────────────────────────
    total = sum(len(v) for v in all_issues.values())
    print(f"\n{'='*55}")
    print(f"TOTAL ISSUES: {total}")
    for cat, msgs in all_issues.items():
        if msgs:
            print(f"  {cat}: {len(msgs)}")
    return all_issues

if __name__ == "__main__":
    run_audit()
