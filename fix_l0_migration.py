#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Fix remaining issues in L0 migration: add level field, fix duplicate names, strip CEFR."""
import re, glob, os, sys, io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

DATA_DIR = "app/src/main/java/com/example/kartonki/data"

# Corrected names for conflicts (where " 2" was already taken → use " 3")
NAME_FIXES = {
    1145: ("Транспорт", 1, "Транспорт: основы 3"),
    1168: ("Город", 1, "Город: основы 3"),
    1170: ("Религия", 1, "Религия: основы 3"),
    1180: ("Технологии", 1, "Технологии: основы 3"),
    1182: ("Психология", 1, "Психология: основы 3"),
}

# Level assignments for all L0 sets
LEVEL_MAP = {
    1022: 1, 1023: 1, 1024: 1, 1025: 1,
    1034: 1, 1035: 1, 1036: 2, 1037: 1,
    1142: 2, 1143: 1, 1144: 1,
    1145: 1, 1146: 1, 1147: 1,
    1148: 1, 1149: 1, 1150: 1, 1151: 1, 1152: 1, 1153: 2,
    1166: 1, 1167: 1, 1168: 1, 1169: 1, 1170: 1, 1171: 1,
    1172: 1, 1173: 1, 1174: 1, 1175: 1, 1176: 1, 1177: 1,
    1178: 1, 1179: 1, 1180: 1, 1181: 2, 1182: 1, 1183: 1,
    1184: 1, 1185: 1, 1186: 1, 1187: 1, 1188: 1, 1189: 1,
    1196: 1, 1197: 1, 1198: 1, 1199: 1, 1200: 1, 1201: 1,
    1202: 4, 1203: 4, 1204: 4, 1205: 4, 1206: 4, 1207: 4,
}

CEFR_PATTERN = re.compile(r'\s*[A-C]\d[+\-–/][A-C]?\d?[+\-–/]?[A-C]?\d?[+–]?$')

files = sorted(glob.glob(os.path.join(DATA_DIR, "WordDataHebrew*.kt")))
total = 0

for f in files:
    with open(f, encoding='utf-8') as fh:
        content = fh.read()

    new_content = content
    changed = 0

    for m in re.finditer(r'(WordSetEntity\([^)]+\))', content, re.DOTALL):
        block = m.group(1)
        id_m = re.search(r'\bid\s*=\s*(\d+)', block)
        if not id_m:
            continue
        sid = int(id_m.group(1))
        if sid not in LEVEL_MAP:
            continue

        new_block = block
        level = LEVEL_MAP[sid]

        # Fix name if needed
        if sid in NAME_FIXES:
            _, _, new_name = NAME_FIXES[sid]
            name_m = re.search(r'name\s*=\s*"([^"]+)"', new_block)
            if name_m and name_m.group(1) != new_name:
                new_block = new_block.replace(f'name = "{name_m.group(1)}"', f'name = "{new_name}"', 1)

        # Strip CEFR from description
        desc_m = re.search(r'(description\s*=\s*")([^"]+)(")', new_block)
        if desc_m:
            desc = desc_m.group(2)
            cleaned = CEFR_PATTERN.sub('', desc).rstrip()
            # Also strip trailing spaces before CEFR
            cleaned = re.sub(r'\s+[A-C]\d[\+\-–/][A-C]?\d.*$', '', cleaned).rstrip()
            if cleaned != desc:
                new_block = new_block[:desc_m.start(2)] + cleaned + new_block[desc_m.end(2):]

        # Add or update level field
        level_m = re.search(r'level\s*=\s*(\d+)', new_block)
        if level_m:
            if int(level_m.group(1)) != level:
                new_block = re.sub(r'level\s*=\s*\d+', f'level = {level}', new_block, count=1)
        else:
            # Add level before the final closing paren of the WordSetEntity block
            new_block = new_block.rstrip()
            if new_block.endswith(')'):
                new_block = new_block[:-1] + f', level = {level})'

        if new_block != block:
            new_content = new_content.replace(block, new_block, 1)
            changed += 1

    if changed:
        with open(f, 'w', encoding='utf-8') as fh:
            fh.write(new_content)
        print(f"  {os.path.basename(f)}: {changed} sets updated")
        total += changed

print(f"\nTotal: {total}")
