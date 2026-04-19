#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import re, glob, sys, io, os
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

RARITY = {'COMMON': 0, 'UNCOMMON': 1, 'RARE': 2, 'EPIC': 3, 'LEGENDARY': 4}
LEVEL_RANGE = {1: (0,1), 2: (1,2), 3: (1,2), 4: (2,3), 5: (3,4)}

DATA_DIR = "app/src/main/java/com/example/kartonki/data"
files = sorted(glob.glob(os.path.join(DATA_DIR, "WordDataHebrew*.kt")))

file_stats = []
for f in files:
    with open(f, encoding='utf-8') as fh:
        content = fh.read()

    set_info = {}
    for m in re.finditer(r'WordSetEntity\([^)]+\)', content, re.DOTALL):
        block = m.group(0)
        id_m = re.search(r'\bid\s*=\s*(\d+)', block)
        level_m = re.search(r'level\s*=\s*(\d+)', block)
        if id_m and level_m:
            set_info[int(id_m.group(1))] = int(level_m.group(1))

    bad_by_set = {}
    for m in re.finditer(r'WordEntity\([^)]+\)', content, re.DOTALL):
        block = m.group(0)
        sid_m = re.search(r'setId\s*=\s*(\d+)', block)
        rar_m = re.search(r'rarity\s*=\s*"([^"]+)"', block)
        id_m = re.search(r'\bid\s*=\s*(\d+)', block)
        orig_m = re.search(r'original\s*=\s*"([^"]+)"', block)
        if sid_m and rar_m:
            sid = int(sid_m.group(1))
            if sid in set_info:
                level = set_info[sid]
                if level in LEVEL_RANGE:
                    min_ok, max_ok = LEVEL_RANGE[level]
                    rar_val = RARITY.get(rar_m.group(1), 0)
                    if rar_val < min_ok or rar_val > max_ok:
                        if sid not in bad_by_set:
                            bad_by_set[sid] = []
                        bad_by_set[sid].append((int(id_m.group(1)) if id_m else 0, rar_m.group(1), orig_m.group(1) if orig_m else '?'))

    total_bad = sum(len(v) for v in bad_by_set.values())
    if total_bad > 0:
        fname = os.path.basename(f)
        file_stats.append((total_bad, fname, bad_by_set))

for count, fname, bad_by_set in sorted(file_stats):
    print(f"\n{count:3d} violations: {fname}")
    for sid in sorted(bad_by_set):
        words = bad_by_set[sid]
        print(f"  Set {sid} ({len(words)} bad):")
        for wid, rar, orig in words:
            print(f"    {wid} [{rar}] {orig}")
