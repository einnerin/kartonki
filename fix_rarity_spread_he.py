"""Приводит разброс редкости в he-ru наборах к ≤2 смежных уровней.

Та же логика что для en-ru: окно 2 смежных вокруг доминанты, outliers клампятся.
"""
import re
import glob
import sys
from collections import defaultdict, Counter

RARITY_LEVEL = {"COMMON": 1, "UNCOMMON": 2, "RARE": 3, "EPIC": 4, "LEGENDARY": 5}
LEVEL_RARITY = {v: k for k, v in RARITY_LEVEL.items()}

FILES_GLOB = "app/src/main/java/com/example/kartonki/data/WordDataHebrew*.kt"


def collect_sets():
    data = {}
    for path in sorted(glob.glob(FILES_GLOB)):
        content = open(path, encoding="utf-8").read()
        for m in re.finditer(r"WordSetEntity\s*\(([^)]+)\)", content, re.DOTALL):
            body = m.group(1)
            sid = re.search(r"\bid\s*=\s*(\d+)", body)
            lvl = re.search(r"\blevel\s*=\s*(\d+)", body)
            if sid and lvl:
                data[int(sid.group(1))] = {"file": path, "level": int(lvl.group(1)), "rarities": Counter()}
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


def spread(counter):
    if not counter:
        return 0
    levels = [RARITY_LEVEL[r] for r in counter if counter[r] > 0]
    return max(levels) - min(levels) + 1 if levels else 0


def compute_target(info):
    if not info["rarities"]:
        return info["level"]
    # target — доминанта (most common). Если доминанта далеко от level набора,
    # предпочитаем level (rarity помечена объективно, но набор был задуман как level).
    dom = RARITY_LEVEL[info["rarities"].most_common(1)[0][0]]
    # Если level и dom смежные — используем dom, иначе level
    if abs(dom - info["level"]) <= 1:
        return dom
    return info["level"]


def plan_fixes(data):
    plans = {}
    for set_id, info in data.items():
        if spread(info["rarities"]) <= 2:
            continue
        target = compute_target(info)
        above = sum(c for r, c in info["rarities"].items() if RARITY_LEVEL[r] > target)
        below = sum(c for r, c in info["rarities"].items() if RARITY_LEVEL[r] < target)
        if below > above:
            lo, hi = max(1, target - 1), target
        elif above > below:
            lo, hi = target, min(5, target + 1)
        else:
            # Равенство — выбираем симметрично, но для L4+ вверх, L1-2 вниз
            if target >= 4:
                lo, hi = target, min(5, target + 1)
            else:
                lo, hi = max(1, target - 1), target
        mapping = {}
        for rar in info["rarities"]:
            rl = RARITY_LEVEL[rar]
            if rl < lo:
                mapping[rar] = LEVEL_RARITY[lo]
            elif rl > hi:
                mapping[rar] = LEVEL_RARITY[hi]
        if mapping:
            plans[set_id] = (target, lo, hi, mapping)
    return plans


def apply_fixes(plans):
    total = 0
    for path in sorted(glob.glob(FILES_GLOB)):
        content = open(path, encoding="utf-8").read()

        def fix_word(m: re.Match) -> str:
            body = m.group(1)
            sid_m = re.search(r"\bsetId\s*=\s*(\d+)", body)
            if not sid_m:
                return m.group(0)
            set_id = int(sid_m.group(1))
            if set_id not in plans:
                return m.group(0)
            _, _, _, mapping = plans[set_id]
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

        new_content = re.sub(
            r"WordEntity\s*\(([^)]+)\)", fix_word, content, flags=re.DOTALL
        )
        if new_content != content:
            n = sum(1 for a, b in zip(
                re.findall(r'rarity\s*=\s*"(\w+)"', content),
                re.findall(r'rarity\s*=\s*"(\w+)"', new_content)
            ) if a != b)
            total += n
            open(path, "w", encoding="utf-8").write(new_content)
            print(f"{path.split(chr(92))[-1]}: {n} изменений")
    print(f"\nИтого: {total} слов")


def main():
    data = collect_sets()
    # Несколько проходов, пока не сойдётся
    for iteration in range(5):
        plans = plan_fixes(data)
        print(f"--- Итерация {iteration + 1}: {len(plans)} проблемных наборов ---")
        if not plans:
            print("Готово.")
            break
        for sid, (t, lo, hi, m) in sorted(plans.items())[:5]:
            print(f"  [{sid}] L{data[sid]['level']} target={LEVEL_RARITY[t]} "
                  f"window=[{LEVEL_RARITY[lo]},{LEVEL_RARITY[hi]}]")
        apply_fixes(plans)
        data = collect_sets()


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
