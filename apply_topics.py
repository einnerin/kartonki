#!/usr/bin/env python3
"""Add topic/level to all 129 non-Immigrant he-ru WordSetEntity records.

Usage: python apply_topics.py [--dry-run]
"""

import re
import sys
import pathlib
from collections import defaultdict

DATA = pathlib.Path("app/src/main/java/com/example/kartonki/data")
DRY_RUN = "--dry-run" in sys.argv

# ── Complete topic/level mapping for all 129 non-Immigrant he-ru sets ─────────
# Format: setId -> (topic, level)
# level 1 = основы, 2 = продвинутый, 3 = профессиональный
TOPIC_MAP = {
    # Технологии
    1001: ("Технологии", 1),   # Компьютер и интернет
    1002: ("Технологии", 2),   # Программирование
    1003: ("Технологии", 3),   # Информатика
    1014: ("Технологии", 2),   # IT: углублённо
    1018: ("Технологии", 1),   # Компьютерные игры
    1019: ("Технологии", 1),   # Смартфон и гаджеты
    1020: ("Технологии", 2),   # Веб-разработка
    1021: ("Технологии", 3),   # Кибербезопасность
    1059: ("Технологии", 2),   # Хайтек: основы
    1060: ("Технологии", 3),   # Хайтек: углублённо
    1083: ("Технологии", 1),   # Социальные сети
    1099: ("Технологии", 3),   # ИТ-безопасность
    1108: ("Технологии", 3),   # Квантовые вычисления
    1109: ("Технологии", 2),   # Робототехника
    # Медицина
    1045: ("Медицина", 2),     # Больница и медицина
    1061: ("Медицина", 1),     # Медицина: основы
    1062: ("Медицина", 2),     # Медицина: углублённо
    1088: ("Медицина", 3),     # Медицина: углублённо (специалисты)
    1096: ("Медицина", 2),     # Питание и здоровье
    1122: ("Медицина", 1),     # Тело человека
    # Право
    1063: ("Право", 1),        # Право: основы
    1064: ("Право", 2),        # Право: углублённо
    1089: ("Право", 3),        # Право (судебная система)
    # Финансы
    1054: ("Финансы", 2),      # Банк: углублённо
    1073: ("Финансы", 2),      # Стартапы
    1081: ("Финансы", 2),      # Финансы
    1091: ("Финансы", 3),      # Экономика
    # Работа и карьера
    1015: ("Работа и карьера", 1),  # Работа и карьера
    1055: ("Работа и карьера", 2),  # Карьера
    1065: ("Работа и карьера", 1),  # Маркетинг: основы
    1066: ("Работа и карьера", 2),  # Маркетинг: углублённо
    1113: ("Работа и карьера", 2),  # Лидерство и менеджмент
    1115: ("Работа и карьера", 3),  # Промышленность
    1125: ("Работа и карьера", 1),  # Профессии
    # Дом и быт
    1007: ("Дом и быт", 1),    # Дом и быт
    1047: ("Дом и быт", 1),    # Торговый центр
    1049: ("Дом и быт", 1),    # Соседи и дом
    1050: ("Дом и быт", 1),    # Красота и уход
    1051: ("Дом и быт", 2),    # Ремонт дома
    1132: ("Дом и быт", 1),    # Мебель и дом
    # Еда и кулинария
    1006: ("Еда и кулинария", 1),   # Еда и напитки
    1042: ("Еда и кулинария", 1),   # Ресторан и кафе
    1043: ("Еда и кулинария", 1),   # Кулинария и кухня
    1044: ("Еда и кулинария", 1),   # Супермаркет
    1084: ("Еда и кулинария", 3),   # Кулинария: углублённо
    1124: ("Еда и кулинария", 1),   # Фрукты и овощи
    1139: ("Еда и кулинария", 1),   # Еда и напитки (расширенный)
    # Семья
    1005: ("Семья", 1),        # Семья и люди
    1039: ("Семья", 1),        # Свадьба и мероприятия
    1048: ("Семья", 1),        # Дети и родительство
    # Транспорт
    1008: ("Транспорт", 1),    # Транспорт
    1046: ("Транспорт", 1),    # Общественный транспорт
    1106: ("Транспорт", 2),    # Авиация
    1112: ("Транспорт", 2),    # Морское дело
    1133: ("Транспорт", 1),    # Транспорт (расширенный)
    # Природа и экология
    1011: ("Природа и экология", 1),  # Погода и природа
    1038: ("Природа и экология", 1),  # Пляж
    1052: ("Природа и экология", 1),  # Прогулки на природе
    1056: ("Природа и экология", 1),  # Климат
    1057: ("Природа и экология", 1),  # Домашние животные
    1078: ("Природа и экология", 2),  # Экология
    1093: ("Природа и экология", 3),  # Климат и устойчивость
    1103: ("Природа и экология", 2),  # Сельское хозяйство
    1123: ("Природа и экология", 1),  # Животные
    1128: ("Природа и экология", 1),  # Птицы
    1129: ("Природа и экология", 1),  # Насекомые и мелкая живность
    1135: ("Природа и экология", 1),  # Погода
    1140: ("Природа и экология", 1),  # Природа
    # Культура и искусство
    1012: ("Культура и искусство", 1),  # Кино
    1013: ("Культура и искусство", 2),  # Кино: углублённо
    1072: ("Культура и искусство", 1),  # Музыка
    1075: ("Культура и искусство", 2),  # Искусство
    1076: ("Культура и искусство", 2),  # СМИ и журналистика
    1079: ("Культура и искусство", 1),  # Театр
    1090: ("Культура и искусство", 2),  # Литература
    1114: ("Культура и искусство", 2),  # Кино и телевидение
    1130: ("Культура и искусство", 1),  # Музыкальные инструменты
    # Образование
    1040: ("Образование", 1),  # Ульпан и учёба
    1080: ("Образование", 2),  # Университет
    1121: ("Образование", 1),  # Цвета и формы
    1126: ("Образование", 1),  # Календарь и время
    1127: ("Образование", 1),  # Числа и счёт
    1131: ("Образование", 1),  # Школьные предметы
    # Спорт
    1041: ("Спорт", 1),        # Спорт и фитнес
    1085: ("Спорт", 2),        # Спорт: углублённо
    1136: ("Спорт", 1),        # Спорт
    # Психология
    1016: ("Психология", 1),   # Эмоции и характер
    1058: ("Психология", 2),   # Психическое здоровье
    1087: ("Психология", 3),   # Психология: углублённо
    1138: ("Психология", 1),   # Эмоции
    1141: ("Психология", 1),   # Описание человека
    1209: ("Психология", 2),   # Когнитивные науки
    # Наука
    1077: ("Наука", 1),        # Наука
    1095: ("Наука", 2),        # Антропология
    1097: ("Наука", 2),        # Математика
    1098: ("Наука", 2),        # Физика и химия
    1100: ("Наука", 2),        # Астрономия
    1101: ("Наука", 2),        # Биология
    1102: ("Наука", 2),        # Геология
    1105: ("Наука", 3),        # Нейронауки
    1107: ("Наука", 3),        # Биотехнология
    1111: ("Наука", 2),        # Демография
    1117: ("Наука", 2),        # Социология
    1118: ("Наука", 2),        # Археология
    1120: ("Наука", 2),        # Энергетика
    1208: ("Наука", 3),        # Социология (углублённая)
    1210: ("Наука", 3),        # Нейронаука
    1211: ("Наука", 3),        # Генетика
    # Политика
    1069: ("Политика", 1),     # Политика
    1119: ("Политика", 2),     # Переговоры
    # Религия
    1053: ("Религия", 1),      # Праздники
    1070: ("Религия", 1),      # Религия: основы
    1071: ("Религия", 2),      # Религия: углублённо
    # Армия
    1067: ("Армия", 1),        # Армия: основы
    1068: ("Армия", 2),        # Армия: углублённо
    1116: ("Армия", 2),        # Военное дело
    # Алия и Израиль
    1074: ("Алия и Израиль", 1),  # Путешествия
    1082: ("Алия и Израиль", 2),  # История Израиля
    # Одежда
    1010: ("Одежда", 1),       # Одежда
    1104: ("Одежда", 2),       # Мода и стиль
    1134: ("Одежда", 1),       # Одежда (расширенный)
    # Город
    1009: ("Город", 1),        # Город и места
    1110: ("Город", 2),        # Городское планирование
    1137: ("Город", 1),        # Город
    # Философия
    1017: ("Философия", 2),    # Абстрактные понятия
    1092: ("Философия", 2),    # Философия
    # Лингвистика
    1094: ("Лингвистика", 2),  # Лингвистика
    # Архитектура
    1086: ("Архитектура", 2),  # Архитектура
    # Приветствия
    1004: ("Приветствия", 1),  # Приветствия и общение
}

LEVEL_WORDS = {1: "основы", 2: "продвинутый", 3: "профессиональный"}
CEFR_RE = re.compile(r'\s+[A-C][1-2](?:/[A-C][1-2])+\b')


def generate_name_map(topic_map):
    """Assign sequential names within each (topic, level) group."""
    groups = defaultdict(list)
    for sid, (topic, level) in topic_map.items():
        groups[(topic, level)].append(sid)

    name_map = {}
    for (topic, level), sids in groups.items():
        base = f"{topic}: {LEVEL_WORDS[level]}"
        for i, sid in enumerate(sorted(sids)):
            name_map[sid] = base if i == 0 else f"{base} {i + 1}"
    return name_map


def extract_entity_blocks(content):
    """Yield (start, end, block_text) for each WordSetEntity(...) in content."""
    search_start = 0
    while True:
        idx = content.find("WordSetEntity(", search_start)
        if idx == -1:
            break
        # Find matching closing paren
        depth = 0
        i = idx + len("WordSetEntity(") - 1  # position of '('
        in_string = False
        escape = False
        while i < len(content):
            ch = content[i]
            if escape:
                escape = False
            elif ch == '\\' and in_string:
                escape = True
            elif ch == '"':
                in_string = not in_string
            elif not in_string:
                if ch == '(':
                    depth += 1
                elif ch == ')':
                    depth -= 1
                    if depth == 0:
                        yield (idx, i + 1, content[idx:i + 1])
                        search_start = i + 1
                        break
            i += 1
        else:
            break


def strip_cefr(text):
    return CEFR_RE.sub('', text).strip().rstrip(':').strip()


def transform_block(block, sid, topic, level, new_name):
    """Apply all transformations to one WordSetEntity block."""
    # Update name
    block = re.sub(r'(name\s*=\s*)"[^"]*"',
                   lambda m: m.group(1) + f'"{new_name}"', block)

    # Strip CEFR from description
    block = re.sub(r'(description\s*=\s*)"([^"]*)"',
                   lambda m: m.group(1) + '"' + strip_cefr(m.group(2)) + '"',
                   block)

    # Add topic/level if not present (insert before closing ')')
    has_topic = bool(re.search(r'\btopic\s*=', block))
    has_level = bool(re.search(r'\blevel\s*=', block))

    if not has_topic or not has_level:
        extra = []
        if not has_topic:
            extra.append(f'topic = "{topic}"')
        if not has_level:
            extra.append(f"level = {level}")
        # Detect trailing comma before the closing ')': e.g. "...,\n        )"
        # Strip trailing whitespace before ')' to check for comma
        pre_close = block[:-1].rstrip()
        has_trailing_comma = pre_close.endswith(',')
        if has_trailing_comma:
            # Trailing comma already present — just add new fields without leading comma
            block = block[:-1].rstrip() + "\n            " + \
                    ",\n            ".join(extra) + "\n        )"
        else:
            addition = ",\n            " + ",\n            ".join(extra)
            block = block[:-1] + addition + ")"

    return block


def process_file(filepath, topic_map, name_map):
    content = filepath.read_text(encoding="utf-8")
    result = list(content)  # mutable char list for in-place edits
    offset = 0

    changes = []
    for start, end, block in extract_entity_blocks(content):
        sid_m = re.search(r'\bid\s*=\s*(\d+)', block)
        if not sid_m:
            continue
        sid = int(sid_m.group(1))
        if sid not in topic_map:
            continue

        topic, level = topic_map[sid]
        new_name = name_map[sid]
        new_block = transform_block(block, sid, topic, level, new_name)

        if new_block != block:
            changes.append((start, end, new_block))

    if not changes:
        return 0

    # Apply changes back-to-front to preserve indices
    new_content = content
    for start, end, new_block in reversed(changes):
        new_content = new_content[:start] + new_block + new_content[end:]

    if not DRY_RUN:
        filepath.write_text(new_content, encoding="utf-8")

    return len(changes)


def main():
    name_map = generate_name_map(TOPIC_MAP)

    # Show name assignments
    print("=== Назначение имён ===\n")
    by_topic = defaultdict(list)
    for sid, nm in sorted(name_map.items()):
        topic, level = TOPIC_MAP[sid]
        by_topic[topic].append(f"  {sid}: {nm}")
    for topic in sorted(by_topic):
        print(f"{topic}:")
        for line in by_topic[topic]:
            print(line)
    print()

    # Process files
    files = [f for f in DATA.glob("WordDataHebrew*.kt") if "Immigrant" not in f.name]
    total_changes = 0
    for f in sorted(files):
        n = process_file(f, TOPIC_MAP, name_map)
        if n:
            print(f"  {'[DRY] ' if DRY_RUN else ''}{f.name}: {n} изменений")
            total_changes += n

    print(f"\nИтого изменено наборов: {total_changes}")
    if DRY_RUN:
        print("(dry run — файлы не записаны)")


if __name__ == "__main__":
    main()
