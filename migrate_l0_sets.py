#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Full migration of L0 he-ru sets: add topic + level + rename + fix rarity."""
import re, glob, os, sys, io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

DATA_DIR = "app/src/main/java/com/example/kartonki/data"

RARITY = {'COMMON': 0, 'UNCOMMON': 1, 'RARE': 2, 'EPIC': 3, 'LEGENDARY': 4}
RARITY_BY_IDX = {v: k for k, v in RARITY.items()}
CHANGE_MAP = {
    1: {'RARE': 'UNCOMMON', 'EPIC': 'UNCOMMON', 'LEGENDARY': 'UNCOMMON'},
    2: {'COMMON': 'UNCOMMON', 'EPIC': 'RARE', 'LEGENDARY': 'RARE'},
    3: {'COMMON': 'RARE', 'UNCOMMON': 'RARE', 'LEGENDARY': 'EPIC'},
    4: {'COMMON': 'EPIC', 'UNCOMMON': 'EPIC', 'RARE': 'EPIC'},
    5: {'COMMON': 'LEGENDARY', 'UNCOMMON': 'LEGENDARY', 'RARE': 'LEGENDARY', 'EPIC': 'LEGENDARY'},
}

# Mapping: setId -> (topic, level, new_name)
# Conflicts resolved by using suffix " 2"
SET_MIGRATION = {
    1022: ("Документы", 1, "Документы: основы"),
    1023: ("Алия", 1, "Алия: основы"),
    1024: ("Банк", 1, "Банк: основы"),
    1025: ("Аэропорт", 1, "Аэропорт: основы"),
    1034: ("Полиция", 1, "Полиция: основы"),
    1035: ("Шаббат", 1, "Шаббат: основы"),
    1036: ("Налоги", 2, "Налоги: продвинутый"),
    1037: ("Природа Израиля", 1, "Природа Израиля: основы"),
    1142: ("Битуах Леуми", 2, "Битуах Леуми: продвинутый"),
    1143: ("Рынок и базар", 1, "Рынок и базар: основы"),
    1144: ("Безопасность", 1, "Безопасность: основы"),
    1145: ("Транспорт", 1, "Транспорт: основы 2"),   # conflict → 2
    1146: ("Армия", 1, "Армия: основы 2"),            # conflict → 2
    1147: ("Кошер", 1, "Кошер: основы"),
    1148: ("Ресторан", 1, "Ресторан: основы"),
    1149: ("Интернет", 1, "Интернет: основы"),
    1150: ("Ремонт", 1, "Ремонт: основы"),
    1151: ("Праздники", 1, "Праздники: основы"),
    1152: ("Супермаркет", 1, "Супермаркет: основы"),
    1153: ("Страховка", 2, "Страховка: продвинутый"),
    1166: ("Животные", 1, "Животные: основы"),
    1167: ("Время", 1, "Время: основы"),
    1168: ("Город", 1, "Город: основы 2"),            # conflict → 2
    1169: ("Эмоции", 1, "Эмоции: основы"),
    1170: ("Религия", 1, "Религия: основы 2"),        # conflict → 2
    1171: ("Больница", 1, "Больница: основы"),
    1172: ("Еда", 1, "Еда: основы"),
    1173: ("Цвета", 1, "Цвета: основы"),
    1174: ("Профессии", 1, "Профессии: основы"),
    1175: ("Дом", 1, "Дом: основы"),
    1176: ("Университет", 1, "Университет: основы"),
    1177: ("Политика", 1, "Политика: основы 2"),      # conflict → 2
    1178: ("Автомобиль", 1, "Автомобиль: основы"),
    1179: ("СМИ", 1, "СМИ: основы"),
    1180: ("Технологии", 1, "Технологии: основы 2"),  # conflict → 2
    1181: ("Алия", 2, "Алия: продвинутый"),
    1182: ("Психология", 1, "Психология: основы 2"),  # conflict → 2
    1183: ("Экология", 1, "Экология: основы"),
    1184: ("Музыка", 1, "Музыка: основы"),
    1185: ("Искусство", 1, "Искусство: основы"),
    1186: ("Кино", 1, "Кино: основы"),
    1187: ("Покупка жилья", 1, "Покупка жилья: основы"),
    1188: ("Море", 1, "Море: основы"),
    1189: ("Карьера", 1, "Карьера: основы"),
    1196: ("Покупки", 1, "Покупки: основы"),
    1197: ("Район", 1, "Район: основы"),
    1198: ("Свадьба", 1, "Свадьба: основы"),
    1199: ("Прилагательные", 1, "Прилагательные: основы"),
    1200: ("Глаголы", 1, "Глаголы: основы"),
    1201: ("Математика", 1, "Математика: основы"),
    1202: ("Риторика", 4, "Риторика: профессиональный"),
    1203: ("Философия", 4, "Философия: профессиональный 2"),  # conflict → 2
    1204: ("Дипломатия", 4, "Дипломатия: профессиональный"),
    1205: ("Иудаика", 4, "Иудаика: профессиональный"),
    1206: ("Психоанализ", 4, "Психоанализ: профессиональный"),
    1207: ("Академический язык", 4, "Академический язык: профессиональный"),
}

files = sorted(glob.glob(os.path.join(DATA_DIR, "WordData*.kt")))
total_changes = 0

for f in files:
    with open(f, encoding='utf-8') as fh:
        content = fh.read()

    new_content = content
    file_changes = 0

    # 1. Update WordSetEntity blocks (add topic, level, rename)
    set_changes_count = [0]

    def update_set_entity(m):
        block = m.group(0)
        id_m = re.search(r'\bid\s*=\s*(\d+)', block)
        if not id_m:
            return block
        sid = int(id_m.group(1))
        if sid not in SET_MIGRATION:
            return block
        topic, level, new_name = SET_MIGRATION[sid]

        changed = False
        # Update name
        old_name_m = re.search(r'name\s*=\s*"([^"]+)"', block)
        if old_name_m:
            old_name = old_name_m.group(1)
            if old_name != new_name:
                block = block.replace(f'name = "{old_name}"', f'name = "{new_name}"', 1)
                changed = True

        # Update or add topic
        topic_m = re.search(r'topic\s*=\s*"([^"]*)"', block)
        if topic_m:
            old_topic = topic_m.group(1)
            if old_topic != topic:
                block = re.sub(r'topic\s*=\s*"[^"]*"', f'topic = "{topic}"', block, count=1)
                changed = True
        else:
            block = re.sub(r'(\s*\))\s*$', f',\n    topic = "{topic}"\\1', block)
            changed = True

        # Update level
        level_m = re.search(r'level\s*=\s*(\d+)', block)
        if level_m:
            old_level = int(level_m.group(1))
            if old_level != level:
                block = re.sub(r'level\s*=\s*\d+', f'level = {level}', block, count=1)
                changed = True

        if changed:
            set_changes_count[0] += 1
        return block

    new_content = re.sub(r'WordSetEntity\([^)]+\)', update_set_entity, new_content, flags=re.DOTALL)
    file_changes += set_changes_count[0]

    # 2. Fix rarity in WordEntity blocks using global level from SET_MIGRATION
    for m in re.finditer(r'(WordEntity\([^)]+\))', content, re.DOTALL):
        block = m.group(1)
        sid_m = re.search(r'setId\s*=\s*(\d+)', block)
        rar_m = re.search(r'rarity\s*=\s*"([^"]+)"', block)
        if not sid_m or not rar_m:
            continue
        sid = int(sid_m.group(1))
        if sid not in SET_MIGRATION:
            continue
        _, level, _ = SET_MIGRATION[sid]
        rarity = rar_m.group(1)
        fixes = CHANGE_MAP.get(level, {})
        if rarity not in fixes:
            continue
        new_rarity = fixes[rarity]
        old_block = block
        new_block = re.sub(r'(rarity\s*=\s*")' + rarity + r'"',
                           r'\g<1>' + new_rarity + '"', old_block, count=1)
        if new_block != old_block:
            new_content = new_content.replace(old_block, new_block, 1)
            file_changes += 1

    if file_changes > 0 or new_content != content:
        with open(f, 'w', encoding='utf-8') as fh:
            fh.write(new_content)
        if file_changes > 0:
            print(f"  {os.path.basename(f)}: {file_changes} changes")
            total_changes += file_changes

print(f"\nTotal: {total_changes} changes")
