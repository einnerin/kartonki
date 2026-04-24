#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Массово переименовывает WordSetEntity по паттерну:
    {topic}: {level_word} — {subtopic}

Где {subtopic} берётся из существующего description (если он осмысленный).
Затрагивает только filled setIds; skeleton'ы пропускает (их description
часто пустой или generic).

Usage:
    python scripts/validate/rename_set_names.py --dry-run
    python scripts/validate/rename_set_names.py --apply
"""
import argparse
import re
import sys
import io
import glob
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

LEVEL_WORDS = {
    1: 'основы', 2: 'продвинутый', 3: 'углублённый',
    4: 'профессиональный', 5: 'носитель',
}

# Плохие description которые не подходят как подтема (слишком generic)
BAD_DESCRIPTIONS = {
    '', 'нет описания', 'base', 'test',
}


def lower_first(s: str) -> str:
    """Первую букву строки опускаем (для вставки после тире)."""
    if not s:
        return s
    return s[0].lower() + s[1:]


def build_new_name(topic: str, level: int, description: str) -> str | None:
    lvl_word = LEVEL_WORDS.get(level)
    if not lvl_word:
        return None
    desc_clean = description.strip()
    if desc_clean.lower() in BAD_DESCRIPTIONS or len(desc_clean) < 3:
        return None
    # Если description совпадает с topic — мусор, не используем
    if desc_clean.lower() == topic.lower():
        return None
    return f"{topic}: {lvl_word} — {lower_first(desc_clean)}"


def classify_current_name(name: str, level: int, topic: str, counts: dict) -> str:
    """OK / NO_LEVEL / NUMERIC_SUFFIX / NO_SUBTOPIC"""
    lvl_word = LEVEL_WORDS.get(level, '')
    if not lvl_word or lvl_word not in name.lower():
        return 'NO_LEVEL'
    if re.search(rf'{lvl_word}\s+\d+\s*$', name, re.IGNORECASE):
        return 'NUMERIC_SUFFIX'
    idx = name.lower().find(lvl_word)
    tail = name[idx + len(lvl_word):].strip(': —–-').strip()
    has_subtopic = tail and not tail.isdigit()
    if not has_subtopic and counts.get((topic, level), 0) >= 2:
        return 'NO_SUBTOPIC'
    return 'OK'


def process_files(apply: bool):
    # First pass: parse all sets to build counts per (topic, level)
    all_sets = []
    for path in glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt'):
        content = Path(path).read_text(encoding='utf-8')
        for m in re.finditer(r'WordSetEntity\(([^)]+)\)', content, re.DOTALL):
            body = m.group(1)
            id_m = re.search(r'\bid\s*=\s*(\d+)', body)
            name_m = re.search(r'name\s*=\s*"([^"]+)"', body)
            topic_m = re.search(r'topic\s*=\s*"([^"]+)"', body)
            level_m = re.search(r'level\s*=\s*(\d+)', body)
            desc_m = re.search(r'description\s*=\s*"([^"]*)"', body)
            if id_m and name_m and topic_m and level_m:
                all_sets.append({
                    'id': int(id_m.group(1)),
                    'name': name_m.group(1),
                    'topic': topic_m.group(1),
                    'level': int(level_m.group(1)),
                    'description': desc_m.group(1) if desc_m else '',
                    'file': path,
                })

    # Count sets per (topic, level)
    counts = {}
    for s in all_sets:
        key = (s['topic'], s['level'])
        counts[key] = counts.get(key, 0) + 1

    # Plan renames
    renames_by_file = {}  # file -> list of (old_name, new_name, id)
    skipped = []
    for s in all_sets:
        cat = classify_current_name(s['name'], s['level'], s['topic'], counts)
        if cat == 'OK':
            continue
        new_name = build_new_name(s['topic'], s['level'], s['description'])
        if not new_name:
            skipped.append((s['id'], s['name'], cat, s['description']))
            continue
        if new_name == s['name']:
            continue
        renames_by_file.setdefault(s['file'], []).append(
            (s['name'], new_name, s['id'])
        )

    # Report
    total_renames = sum(len(v) for v in renames_by_file.values())
    print(f"Планируется переименовать: {total_renames} сетов")
    print(f"Пропущено (неподходящий description): {len(skipped)}")
    print()
    # Show first 15 rename examples
    shown = 0
    for f, lst in renames_by_file.items():
        for old, new, sid in lst[:5]:
            print(f"  [{sid}] {old}")
            print(f"        → {new}")
            shown += 1
            if shown >= 20:
                break
        if shown >= 20:
            break
    if total_renames > 20:
        print(f"  ... и ещё {total_renames - 20}")
    print()
    if skipped:
        print("Пропущенные (нужны руками):")
        for sid, name, cat, desc in skipped[:15]:
            print(f"  [{sid}] {name} (cat={cat}, desc='{desc[:40]}')")
        if len(skipped) > 15:
            print(f"  ... и ещё {len(skipped) - 15}")

    if not apply:
        print("\nDry-run — ничего не изменено. Запусти с --apply чтобы применить.")
        return 0

    # Apply
    for path, lst in renames_by_file.items():
        content = Path(path).read_text(encoding='utf-8')
        for old, new, sid in lst:
            # Replace name = "old" (inside WordSetEntity with matching id)
            # Use a targeted regex bounded by the id= field to avoid wrong matches
            # Pattern: id = <sid>[,\s].* name = "old"
            pattern = re.compile(
                rf'(id\s*=\s*{sid}\b[^)]*?name\s*=\s*")' + re.escape(old) + r'(")',
                re.DOTALL
            )
            new_content, n = pattern.subn(r'\1' + new + r'\2', content, count=1)
            if n == 0:
                print(f"  WARN: не нашёл name='{old}' для id={sid} в {path}")
            content = new_content
        Path(path).write_text(content, encoding='utf-8', newline='\n')
    print(f"Применено. Затронуто файлов: {len(renames_by_file)}")
    return 0


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--apply', action='store_true', help='Actually rename (without это dry-run)')
    args = parser.parse_args()
    return process_files(args.apply)


if __name__ == '__main__':
    sys.exit(main())
