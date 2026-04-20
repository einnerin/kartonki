#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Apply rarity label fixes to all he-ru word sets based on their level."""
import re, glob, os, sys, io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

DATA_DIR = "app/src/main/java/com/example/kartonki/data"

# For each level, map wrong rarity → correct rarity (move to nearest allowed boundary)
# Level 1 (основы):       COMMON+UNCOMMON allowed
# Level 2 (продвинутый):  UNCOMMON+RARE allowed
# Level 3 (углублённый):  RARE+EPIC allowed
# Level 4 (профессиональный): EPIC+LEGENDARY allowed
# Level 5 (носитель языка):   LEGENDARY only
CHANGE_MAP = {
    1: {'RARE': 'UNCOMMON', 'EPIC': 'UNCOMMON', 'LEGENDARY': 'UNCOMMON'},
    2: {'COMMON': 'UNCOMMON', 'EPIC': 'RARE', 'LEGENDARY': 'RARE'},
    3: {'COMMON': 'RARE', 'UNCOMMON': 'RARE', 'LEGENDARY': 'EPIC'},
    4: {'COMMON': 'EPIC', 'UNCOMMON': 'EPIC', 'RARE': 'EPIC'},
    5: {'COMMON': 'LEGENDARY', 'UNCOMMON': 'LEGENDARY', 'RARE': 'LEGENDARY', 'EPIC': 'LEGENDARY'},
}

files = sorted(glob.glob(os.path.join(DATA_DIR, "WordDataHebrew*.kt")))
total_changes = 0

for f in files:
    with open(f, encoding='utf-8') as fh:
        content = fh.read()

    # Parse set levels
    set_level = {}
    for m in re.finditer(r'WordSetEntity\([^)]+\)', content, re.DOTALL):
        block = m.group(0)
        id_m = re.search(r'\bid\s*=\s*(\d+)', block)
        level_m = re.search(r'level\s*=\s*(\d+)', block)
        if id_m and level_m:
            set_level[int(id_m.group(1))] = int(level_m.group(1))

    if not set_level:
        continue

    # Find all WordEntity blocks and plan substitutions
    # We need to replace rarity in context: find the word block and replace its rarity
    new_content = content
    file_changes = 0

    for m in re.finditer(r'(WordEntity\([^)]+\))', content, re.DOTALL):
        block = m.group(1)
        sid_m = re.search(r'setId\s*=\s*(\d+)', block)
        rar_m = re.search(r'rarity\s*=\s*"([^"]+)"', block)
        if not sid_m or not rar_m:
            continue
        sid = int(sid_m.group(1))
        if sid not in set_level:
            continue
        level = set_level[sid]
        rarity = rar_m.group(1)
        fixes = CHANGE_MAP.get(level, {})
        if rarity not in fixes:
            continue

        new_rarity = fixes[rarity]
        # Replace only within this specific block occurrence
        old_block = block
        new_block = re.sub(
            r'(rarity\s*=\s*")' + rarity + r'"',
            r'\g<1>' + new_rarity + '"',
            old_block,
            count=1
        )
        if new_block != old_block:
            # Replace only first occurrence in new_content (to handle duplicates safely)
            new_content = new_content.replace(old_block, new_block, 1)
            file_changes += 1

    if file_changes > 0:
        with open(f, 'w', encoding='utf-8') as fh:
            fh.write(new_content)
        print(f"  {os.path.basename(f)}: {file_changes} changes")
        total_changes += file_changes

print(f"\nTotal changes applied: {total_changes}")
