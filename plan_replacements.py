#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
plan_replacements.py — инструмент подготовки замен нарушающих слов.

Режимы:
  python plan_replacements.py              — показать все нарушения с нужными редкостями
  python plan_replacements.py <file.kt>    — только один файл
  python plan_replacements.py check СЛОВО1 СЛОВО2 ...  — проверить, свободны ли слова
"""
import re, glob, sys, io, os

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

RARITY      = {'COMMON': 0, 'UNCOMMON': 1, 'RARE': 2, 'EPIC': 3, 'LEGENDARY': 4}
RARITY_NAME = {0: 'COMMON', 1: 'UNCOMMON', 2: 'RARE', 3: 'EPIC', 4: 'LEGENDARY'}
LEVEL_RANGE = {1: (0, 1), 2: (1, 2), 3: (1, 2), 4: (2, 3), 5: (3, 4)}
DATA_DIR    = "app/src/main/java/com/example/kartonki/data"


def load_all_words():
    """Возвращает dict: original → {'rarity': str, 'topic': str, 'setId': int} для всех he-ru файлов."""
    used = {}
    for f in glob.glob(os.path.join(DATA_DIR, "WordDataHebrew*.kt")):
        text = open(f, encoding='utf-8').read()
        # Parse set topics
        set_topics = {}
        for m in re.finditer(r'WordSetEntity\([^)]+\)', text, re.DOTALL):
            block = m.group(0)
            id_m = re.search(r'\bid\s*=\s*(\d+)', block)
            topic_m = re.search(r'topic\s*=\s*"([^"]+)"', block)
            if id_m:
                set_topics[int(id_m.group(1))] = topic_m.group(1) if topic_m else ""
        for m in re.finditer(r'WordEntity\([^)]+\)', text, re.DOTALL):
            block = m.group(0)
            orig_m = re.search(r'original\s*=\s*"([^"]+)"', block)
            rar_m = re.search(r'rarity\s*=\s*"([^"]+)"', block)
            sid_m = re.search(r'setId\s*=\s*(\d+)', block)
            if orig_m:
                orig = orig_m.group(1)
                sid = int(sid_m.group(1)) if sid_m else 0
                used[orig] = {
                    'rarity': rar_m.group(1) if rar_m else 'COMMON',
                    'topic': set_topics.get(sid, ""),
                    'setId': sid,
                }
    return used


def parse_file(path):
    """Возвращает (set_info, violations).
    set_info: {set_id: {'level': int, 'name': str, 'topic': str}}
    violations: {set_id: [(word_id, rarity, original)]}
    """
    with open(path, encoding='utf-8') as fh:
        content = fh.read()

    set_info = {}
    for m in re.finditer(r'WordSetEntity\([^)]+\)', content, re.DOTALL):
        block = m.group(0)
        id_m    = re.search(r'\bid\s*=\s*(\d+)', block)
        level_m = re.search(r'level\s*=\s*(\d+)', block)
        name_m  = re.search(r'name\s*=\s*"([^"]+)"', block)
        topic_m = re.search(r'topic\s*=\s*"([^"]+)"', block)
        if id_m and level_m:
            set_info[int(id_m.group(1))] = {
                'level': int(level_m.group(1)),
                'name':  name_m.group(1)  if name_m  else '?',
                'topic': topic_m.group(1) if topic_m else '?',
            }

    violations = {}
    for m in re.finditer(r'WordEntity\([^)]+\)', content, re.DOTALL):
        block  = m.group(0)
        sid_m  = re.search(r'setId\s*=\s*(\d+)', block)
        rar_m  = re.search(r'rarity\s*=\s*"([^"]+)"', block)
        id_m   = re.search(r'\bid\s*=\s*(\d+)', block)
        orig_m = re.search(r'original\s*=\s*"([^"]+)"', block)
        if not (sid_m and rar_m):
            continue
        sid = int(sid_m.group(1))
        if sid not in set_info:
            continue
        level = set_info[sid]['level']
        if level not in LEVEL_RANGE:
            continue
        min_ok, max_ok = LEVEL_RANGE[level]
        rar_val = RARITY.get(rar_m.group(1), 0)
        if rar_val < min_ok or rar_val > max_ok:
            violations.setdefault(sid, []).append((
                int(id_m.group(1)) if id_m else 0,
                rar_m.group(1),
                orig_m.group(1) if orig_m else '?',
            ))

    return set_info, violations


def show_plan(files):
    results = []
    for f in files:
        set_info, violations = parse_file(f)
        if violations:
            total = sum(len(v) for v in violations.values())
            results.append((total, f, set_info, violations))

    results.sort()
    grand_total = sum(r[0] for r in results)
    print(f"Всего нарушений: {grand_total} в {len(results)} файлах\n")
    print("=" * 70)

    for total, f, set_info, violations in results:
        print(f"\n{'─'*70}")
        print(f"Файл : {os.path.basename(f)}  ({total} нарушений)")
        for sid in sorted(violations):
            info = set_info[sid]
            level = info['level']
            min_ok, max_ok = LEVEL_RANGE[level]
            allowed = ' или '.join(RARITY_NAME[r] for r in range(min_ok, max_ok + 1))
            print(f"\n  Набор {sid} «{info['name']}»")
            print(f"  Тема: {info['topic']} | Уровень: {level} | Нужна редкость: {allowed}")
            print(f"  {'ID':>8}  {'ТЕКУЩАЯ':10}  {'НУЖНА':10}  СЛОВО")
            for wid, rar, orig in violations[sid]:
                rar_val  = RARITY[rar]
                # ближайшая допустимая редкость
                target   = RARITY_NAME[min(max_ok, max(min_ok, rar_val))]
                flag     = '⬇' if rar_val > max_ok else '⬆'
                print(f"  {wid:>8}  {rar:10}  {target:10}  {flag} {orig}")


def check_words(candidates, candidate_topic=None, candidate_rarity=None):
    """
    candidate_topic:  тема набора, куда хотим добавить слово (для проверки same-topic)
    candidate_rarity: редкость, с которой хотим добавить слово (для проверки разной редкости)
    """
    used = load_all_words()
    print(f"Проверка {len(candidates)} слов против {len(used)} занятых:\n")
    free = ok_diff_topic = blocked_same_topic = blocked_diff_rarity = 0
    for w in candidates:
        if w not in used:
            print(f"  ✅ FREE              {w}")
            free += 1
        else:
            info = used[w]
            ex_topic = info['topic']
            ex_rarity = info['rarity']
            same_topic = (candidate_topic and ex_topic == candidate_topic)
            diff_rarity = (candidate_rarity and ex_rarity != candidate_rarity)
            if same_topic or diff_rarity:
                reason = "та же тема" if same_topic else f"редкость: {ex_rarity}"
                print(f"  ❌ CONFLICT  [{reason}]  {w}  (set {info['setId']})")
                if same_topic:
                    blocked_same_topic += 1
                else:
                    blocked_diff_rarity += 1
            else:
                # Different topic, same rarity → acceptable
                print(f"  ✅ OK (др. тема)     {w}  [{ex_topic}, {ex_rarity}, set {info['setId']}]")
                ok_diff_topic += 1
    total_free = free + ok_diff_topic
    total_blocked = blocked_same_topic + blocked_diff_rarity
    print(f"\nСвободны: {free}  ОК (др. тема): {ok_diff_topic}  Конфликт: {total_blocked}")


# ── entrypoint ────────────────────────────────────────────────────────────────

if len(sys.argv) >= 2 and sys.argv[1] == 'check':
    check_words(sys.argv[2:])
elif len(sys.argv) == 2 and sys.argv[1].endswith('.kt'):
    path = sys.argv[1]
    if not os.path.isabs(path):
        path = os.path.join(DATA_DIR, path)
    show_plan([path])
else:
    files = sorted(glob.glob(os.path.join(DATA_DIR, "WordDataHebrew*.kt")))
    show_plan(files)
