"""Приводит разброс редкости в английских наборах к ≤2 смежных уровней.

Логика: в каждом наборе находим 'target' редкость (доминанту = most common).
Все слова с редкостью на ≥2 уровня от target — подтягиваются в диапазон
[target-1, target+1]. Слова на target-1/target/target+1 не трогаются.

Это исправляет: outliers вверх (понижаются) и outliers вниз (повышаются).
Цель — согласованный набор, разброс = 2 смежных вокруг доминанты.

ВАЖНО: setId=0 (achievement rewards) не трогаем.
"""
import re
import glob
import sys
from collections import defaultdict, Counter

RARITY_LEVEL = {"COMMON": 1, "UNCOMMON": 2, "RARE": 3, "EPIC": 4, "LEGENDARY": 5}
LEVEL_RARITY = {v: k for k, v in RARITY_LEVEL.items()}


def collect_sets():
    """{set_id: {'file', 'level', 'rarities': Counter}}"""
    data = {}
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordDataEnglish*.kt")):
        content = open(path, encoding="utf-8").read()
        for m in re.finditer(r"WordSetEntity\s*\(([^)]+)\)", content, re.DOTALL):
            body = m.group(1)
            sid = re.search(r"\bid\s*=\s*(\d+)", body)
            lvl = re.search(r"\blevel\s*=\s*(\d+)", body)
            if sid and lvl:
                set_id = int(sid.group(1))
                data[set_id] = {"file": path, "level": int(lvl.group(1)), "rarities": Counter()}
        for m in re.finditer(r"WordEntity\s*\(([^)]+)\)", content, re.DOTALL):
            body = m.group(1)
            sid = re.search(r"\bsetId\s*=\s*(\d+)", body)
            rar = re.search(r'\brarity\s*=\s*"(\w+)"', body)
            if sid and rar:
                set_id = int(sid.group(1))
                if set_id == 0:
                    continue
                if set_id in data:
                    data[set_id]["rarities"][rar.group(1)] += 1
    return data


def compute_target(info):
    """Target = most common rarity. Fallback — по set level."""
    if not info["rarities"]:
        return info["level"]
    return RARITY_LEVEL[info["rarities"].most_common(1)[0][0]]


def spread(counter):
    if not counter:
        return 0
    levels = [RARITY_LEVEL[r] for r in counter if counter[r] > 0]
    return max(levels) - min(levels) + 1 if levels else 0


def plan_fixes(data):
    """Ужимает набор до 2 смежных уровней редкости вокруг доминанты.

    target = доминанта. Решаем, какой сосед: тот, где больше слов.
    Окно [target, target+1] ИЛИ [target-1, target]. Всё вне окна клампится в окно.
    """
    plans = {}
    for set_id, info in data.items():
        if spread(info["rarities"]) <= 2:
            continue
        target = compute_target(info)
        # Сколько слов ВЫШЕ target и НИЖЕ
        above = sum(c for r, c in info["rarities"].items() if RARITY_LEVEL[r] > target)
        below = sum(c for r, c in info["rarities"].items() if RARITY_LEVEL[r] < target)
        # Если вес ниже больше — окно [target-1, target]; иначе [target, target+1]
        if below >= above:
            lo, hi = max(1, target - 1), target
        else:
            lo, hi = target, min(5, target + 1)
        mapping = {}
        for rar in info["rarities"]:
            rl = RARITY_LEVEL[rar]
            if rl < lo:
                mapping[rar] = LEVEL_RARITY[lo]
            elif rl > hi:
                mapping[rar] = LEVEL_RARITY[hi]
        if mapping:
            plans[set_id] = (target, mapping)
    return plans


def apply_fixes(plans):
    """Применяет карту к файлам: заменяет rarity у WordEntity с подходящим setId."""
    # группируем по файлу
    by_file = defaultdict(dict)
    # нужен setId→file_map
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordDataEnglish*.kt")):
        content = open(path, encoding="utf-8").read()
        changed = 0

        def fix_word(m: re.Match) -> str:
            body = m.group(1)
            sid_m = re.search(r"\bsetId\s*=\s*(\d+)", body)
            if not sid_m:
                return m.group(0)
            set_id = int(sid_m.group(1))
            if set_id not in plans:
                return m.group(0)
            _, mapping = plans[set_id]
            rar_m = re.search(r'\brarity\s*=\s*"(\w+)"', body)
            if not rar_m:
                return m.group(0)
            old = rar_m.group(1)
            if old not in mapping:
                return m.group(0)
            new = mapping[old]
            new_body = re.sub(
                r'(\brarity\s*=\s*")' + re.escape(old) + r'(")',
                rf'\g<1>{new}\g<2>',
                body,
                count=1,
            )
            return f"WordEntity({new_body})"

        new_content, n = re.subn(
            r"WordEntity\s*\(([^)]+)\)", fix_word, content, flags=re.DOTALL
        )
        # Вычислим сколько реально поменялось
        if new_content != content:
            diffs = sum(1 for a, b in zip(
                re.findall(r'rarity\s*=\s*"(\w+)"', content),
                re.findall(r'rarity\s*=\s*"(\w+)"', new_content)
            ) if a != b)
            changed = diffs
            open(path, "w", encoding="utf-8").write(new_content)
            print(f"{path.split(chr(92))[-1]}: {changed} изменений")


def main():
    data = collect_sets()
    plans = plan_fixes(data)
    print(f"Проблемных наборов: {len(plans)}")
    for sid, (target, mapping) in sorted(plans.items()):
        print(f"  [{sid}] L{data[sid]['level']} target={LEVEL_RARITY[target]} "
              f"map={ {k: v for k, v in mapping.items()} }")
    print()
    apply_fixes(plans)


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
