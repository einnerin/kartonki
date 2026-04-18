#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import sys, io, re
from pathlib import Path
from collections import defaultdict

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

ROOT = Path("app/src/main/java/com/example/kartonki/data")

def parse_registry_order():
    text = (ROOT / "WordRegistry.kt").read_text(encoding="utf-8")
    m = re.search(r'val allWords.*?get\(\)\s*=(.*?)(?=\n[ \t]*val |\Z)', text, re.DOTALL)
    body = m.group(1)
    seen, order = set(), []
    for obj in re.findall(r'(WordData\w+)\.', body):
        if obj not in seen:
            seen.add(obj)
            order.append(obj + ".kt")
    return order

def _parse_blocks(content, entity_name):
    for part in re.split(rf'(?={entity_name}\s*\()', content):
        if not part.strip().startswith(entity_name):
            continue
        depth = 0; end = -1
        for i, ch in enumerate(part):
            if ch == '(': depth += 1
            elif ch == ')':
                depth -= 1
                if depth == 0: end = i + 1; break
        yield part[:end] if end >= 0 else part

def ef(block, fn):
    pattern = fn + r'\s*=\s*"((?:[^"\\]|\\.)*)"'
    m = re.search(pattern, block)
    return m.group(1) if m else None

def eif(block, fn):
    m = re.search(fn + r'\s*=\s*(\d+)', block)
    return int(m.group(1)) if m else None

def parse_words(kt_file):
    content = kt_file.read_text(encoding="utf-8")
    words = []
    for block in _parse_blocks(content, "WordEntity"):
        wid = eif(block, r'\bid')
        sid = eif(block, r'\bsetId')
        original = ef(block, 'original')
        rarity = ef(block, 'rarity') or "COMMON"
        lang = ef(block, 'languagePair')
        if wid and sid and original and lang:
            words.append({"id": wid, "setId": sid, "original": original,
                          "rarity": rarity, "lang": lang, "file": kt_file.name})
    return words

def parse_sets(kt_file):
    content = kt_file.read_text(encoding="utf-8")
    sets = []
    for block in _parse_blocks(content, "WordSetEntity"):
        sid = eif(block, r'\bid')
        name = ef(block, 'name')
        lang = ef(block, 'languagePair')
        topic = ef(block, 'topic') or ""
        if sid and name and lang:
            sets.append({"id": sid, "name": name, "lang": lang, "topic": topic, "file": kt_file.name})
    return sets

registry_order = parse_registry_order()
all_words, all_sets = [], []
for fname in registry_order:
    fpath = ROOT / fname
    if fpath.exists():
        all_words.extend(parse_words(fpath))
        all_sets.extend(parse_sets(fpath))

set_name_map = {s["id"]: s["name"] for s in all_sets}
set_topic_map = {s["id"]: s["topic"] for s in all_sets}

seen = {}
warnings = []
for w in all_words:
    key = (w["original"], w["lang"])
    if key in seen:
        prev = seen[key]
        warnings.append({"original": w["original"], "rarity": w["rarity"],
                         "loser_set": prev["setId"], "loser_file": prev["file"],
                         "winner_set": w["setId"], "winner_file": w["file"]})
        seen[key] = w
    else:
        seen[key] = w

by_winner = defaultdict(list)
for w in warnings:
    by_winner[w["winner_set"]].append(w)

for winner_sid in sorted(by_winner):
    ws = by_winner[winner_sid]
    winner_name = set_name_map.get(winner_sid, "?")
    winner_file = ws[0]["winner_file"]
    print(f"=== Set {winner_sid} \"{winner_name}\" [{winner_file}] ===")
    for w in ws:
        loser_name = set_name_map.get(w["loser_set"], "?")
        print(f"  {w['original']} ({w['rarity']}) <- loser {w['loser_set']} \"{loser_name}\"")
