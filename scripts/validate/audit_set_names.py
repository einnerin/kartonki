#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Audit set names against the naming pattern:
    {topic}: {level_word} — {subtopic}

Categories:
- OK: name matches pattern perfectly
- NO_LEVEL: name lacks the level word (ломает валидатор 6b в find_real_dupes)
- NO_SUBTOPIC: name has level but no subtopic, while другие наборы этого уровня
  в той же теме есть (значит подтема нужна)
- NUMERIC_SUFFIX: name uses "уровень N" (продвинутый 1/2/3) instead of named subtopic
- UNKNOWN_LEVEL: level doesn't map to any of the 5 standard words
"""
import re, glob, sys, io
from collections import defaultdict

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

LEVEL_WORDS = {
    1: ("основы", "основы"),
    2: ("продвинутый", "продвинутый"),
    3: ("углублённый", "углубленный"),
    4: ("профессиональный", "профессиональный"),
    5: ("носитель", "носитель языка"),
}

def classify(name: str, level: int, topic: str, same_level_count: int) -> tuple[str, str]:
    """Returns (category, suggestion). Category: OK / NO_LEVEL / NUMERIC_SUFFIX / NO_SUBTOPIC / UNKNOWN_LEVEL."""
    if level not in LEVEL_WORDS:
        return ("UNKNOWN_LEVEL", f"level={level} не соответствует 1-5")
    level_variants = LEVEL_WORDS[level]
    name_lower = name.lower()
    # Check if any level word is present
    level_present = any(v.lower() in name_lower for v in level_variants)
    if not level_present:
        suggestion = f"'{topic}: {level_variants[0]} — <подтема>'"
        return ("NO_LEVEL", suggestion)
    # Check for numeric suffix (уровень N)
    # Find pattern: один из level-слов, потом пробел, потом цифры
    for v in level_variants:
        m = re.search(rf'{re.escape(v)}\s+(\d+)\s*$', name, flags=re.IGNORECASE)
        if m:
            return ("NUMERIC_SUFFIX", f"содержит порядковый номер '{m.group(0)}' вместо подтемы")
    # Check if subtopic is present (after em dash or colon-space-word)
    # Pattern "{level_word} — {subtopic}" or "{level_word}: {subtopic}"
    has_em_dash = any(f"{v} —" in name or f"{v}—" in name for v in level_variants)
    has_colon_after_level = any(re.search(rf'{re.escape(v)}\s*:', name, flags=re.IGNORECASE) for v in level_variants)
    # Or subtopic could be at end without separator
    has_subtopic = has_em_dash or has_colon_after_level
    # Simpler: если после слова уровня есть ещё >= 1 слово — считаем что подтема есть
    # (например "Медицина: основы у врача" — нет разделителя, но подтема есть)
    for v in level_variants:
        # After the level word, is there substantial text?
        idx = name_lower.find(v.lower())
        if idx >= 0:
            tail = name[idx + len(v):].strip(": —–-").strip()
            if tail and not tail.isdigit():
                has_subtopic = True
                break
    if not has_subtopic and same_level_count >= 2:
        return ("NO_SUBTOPIC", f"несколько наборов уровня '{level_variants[0]}' в теме '{topic}' без уточнения")
    return ("OK", "")


def main():
    # Collect all sets across WordData*.kt
    sets = []  # list of dicts
    for f in glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt'):
        with open(f, encoding='utf-8') as fh:
            content = fh.read()
        for m in re.finditer(r'WordSetEntity\(([^)]+)\)', content, re.DOTALL):
            body = m.group(1)
            id_m = re.search(r'\bid\s*=\s*(\d+)', body)
            name_m = re.search(r'name\s*=\s*"([^"]+)"', body)
            topic_m = re.search(r'topic\s*=\s*"([^"]+)"', body)
            level_m = re.search(r'level\s*=\s*(\d+)', body)
            lang_m = re.search(r'languagePair\s*=\s*"([^"]+)"', body)
            if id_m and name_m and topic_m and level_m and lang_m:
                sets.append({
                    'id': int(id_m.group(1)),
                    'name': name_m.group(1),
                    'topic': topic_m.group(1),
                    'level': int(level_m.group(1)),
                    'lang': lang_m.group(1),
                    'file': f.replace('\\', '/').split('/')[-1],
                })

    # Count sets per (topic, level) — needed for NO_SUBTOPIC detection
    counts = defaultdict(int)
    for s in sets:
        counts[(s['topic'], s['level'])] += 1

    # Classify each
    by_category = defaultdict(list)
    for s in sets:
        cat, sugg = classify(s['name'], s['level'], s['topic'], counts[(s['topic'], s['level'])])
        s['category'] = cat
        s['suggestion'] = sugg
        by_category[cat].append(s)

    # Report
    total = len(sets)
    print(f"Всего наборов в коде (en-ru + he-ru, включая skeleton): {total}")
    print()
    for cat in ('OK', 'NO_LEVEL', 'NUMERIC_SUFFIX', 'NO_SUBTOPIC', 'UNKNOWN_LEVEL'):
        items = by_category.get(cat, [])
        print(f"=== {cat}: {len(items)} ===")
        if cat == 'OK':
            # just count
            continue
        # Show up to 15 examples per category
        shown = items[:25]
        for s in shown:
            print(f"  [{s['lang']}] setId={s['id']} '{s['name']}' (topic={s['topic']}, level={s['level']})")
            if s['suggestion']:
                print(f"    → {s['suggestion']}")
        if len(items) > 25:
            print(f"  ... и ещё {len(items) - 25}")
        print()


if __name__ == '__main__':
    main()
