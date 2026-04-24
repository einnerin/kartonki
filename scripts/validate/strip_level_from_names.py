#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Применяет новый паттерн названий (утверждено 2026-04-24):
    name = "{тема}: {краткая подтема}"
    description = детали (можно длиннее)

Трансформации:
1. Убрать слово уровня (основы / продвинутый / углублённый / профессиональный / носитель)
   вместе с тире-разделителем ' — '.
2. Если в подтеме есть ':' — разделить: всё до ':' остаётся в name, всё после
   переносится в description (с Capital первой буквы).
3. Если описание совпадает с оставшейся подтемой — оставить как есть (UI показывает).
"""
import re, sys, io, glob, argparse
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

LEVEL_WORDS = {
    1: ('основы',),
    2: ('продвинутый',),
    3: ('углублённый', 'углубленный'),
    4: ('профессиональный',),
    5: ('носитель языка', 'носитель'),
}


def cap_first(s: str) -> str:
    if not s:
        return s
    return s[0].upper() + s[1:]


def transform_name(name: str, topic: str, level: int, old_description: str) -> tuple[str, str] | None:
    """Returns (new_name, new_description) or None if no change needed."""
    lvl_variants = LEVEL_WORDS.get(level, ())
    # Strip "topic: " prefix to work with the subtopic
    prefix = f"{topic}:"
    if not name.startswith(prefix):
        return None  # Имя не соответствует паттерну «topic: ...» — не трогаем

    remainder = name[len(prefix):].strip()

    # Strip level word (if it's the first word of remainder, possibly followed by em-dash)
    for lvl in lvl_variants:
        # Pattern: "уровень — subtopic" or "уровень - subtopic" or just "уровень"
        m = re.match(rf'^{re.escape(lvl)}\s*[—–-]\s*(.+)$', remainder, re.IGNORECASE)
        if m:
            remainder = m.group(1).strip()
            break
        # "уровень N" numeric suffix
        m = re.match(rf'^{re.escape(lvl)}\s+\d+\s*$', remainder, re.IGNORECASE)
        if m:
            # Нет subtopic — оставить с description как подтемой
            remainder = old_description.strip() or remainder
            break
        # Просто "уровень" без подтемы (только если description есть)
        if remainder.lower() == lvl.lower():
            remainder = old_description.strip() or remainder
            break

    # Split on ":" — first part stays in name, rest goes to description
    if ':' in remainder:
        part1, part2 = remainder.split(':', 1)
        new_name_subtopic = part1.strip()
        new_description = cap_first(part2.strip())
    else:
        new_name_subtopic = remainder.strip()
        new_description = old_description.strip()

    # Build new name
    new_name = f"{topic}: {new_name_subtopic}"

    if new_name == name and new_description == old_description:
        return None
    return new_name, new_description


def process(apply: bool):
    files_changes = {}  # path -> list of (old_name, new_name, old_desc, new_desc, sid)
    for path in glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt'):
        content = Path(path).read_text(encoding='utf-8')
        for m in re.finditer(r'WordSetEntity\(([^)]+)\)', content, re.DOTALL):
            body = m.group(1)
            id_m = re.search(r'\bid\s*=\s*(\d+)', body)
            name_m = re.search(r'name\s*=\s*"([^"]+)"', body)
            topic_m = re.search(r'topic\s*=\s*"([^"]+)"', body)
            level_m = re.search(r'level\s*=\s*(\d+)', body)
            desc_m = re.search(r'description\s*=\s*"([^"]*)"', body)
            if not (id_m and name_m and topic_m and level_m and desc_m):
                continue
            sid = int(id_m.group(1))
            old_name = name_m.group(1)
            old_desc = desc_m.group(1)
            result = transform_name(old_name, topic_m.group(1), int(level_m.group(1)), old_desc)
            if not result:
                continue
            new_name, new_desc = result
            files_changes.setdefault(path, []).append((old_name, new_name, old_desc, new_desc, sid))

    total = sum(len(v) for v in files_changes.values())
    print(f"Запланировано правок: {total}")
    shown = 0
    for path, lst in files_changes.items():
        for old_name, new_name, old_desc, new_desc, sid in lst[:3]:
            print(f"  [{sid}] name: '{old_name}'")
            print(f"        → '{new_name}'")
            if old_desc != new_desc:
                print(f"     desc: '{old_desc}' → '{new_desc}'")
            shown += 1
            if shown >= 20: break
        if shown >= 20: break
    print()

    if not apply:
        print("Dry run. Запусти с --apply чтобы применить.")
        return 0

    for path, lst in files_changes.items():
        content = Path(path).read_text(encoding='utf-8')
        for old_name, new_name, old_desc, new_desc, sid in lst:
            # Replace name
            name_pattern = re.compile(
                rf'(id\s*=\s*{sid}\b[^)]*?name\s*=\s*")' + re.escape(old_name) + r'(")',
                re.DOTALL
            )
            content, n1 = name_pattern.subn(r'\1' + new_name + r'\2', content, count=1)
            # Replace description (if changed)
            if old_desc != new_desc:
                desc_pattern = re.compile(
                    rf'(id\s*=\s*{sid}\b[^)]*?description\s*=\s*")' + re.escape(old_desc) + r'(")',
                    re.DOTALL
                )
                content, n2 = desc_pattern.subn(r'\1' + new_desc + r'\2', content, count=1)
        Path(path).write_text(content, encoding='utf-8', newline='\n')
    print(f"Применено. Файлов: {len(files_changes)}")
    return 0


def main():
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument('--apply', action='store_true')
    args = ap.parse_args()
    return process(args.apply)


if __name__ == '__main__':
    sys.exit(main())
