"""Финальная починка разброса редкости — с правильным парсером скобок в строках.

Парсит WordEntity балансируя круглые скобки и игнорируя те, что внутри "".
Применяет clamp ко ВСЕМ словам (en-ru + he-ru).
"""
import re
import glob
import sys
from collections import defaultdict, Counter

RARITY_LEVEL = {"COMMON": 1, "UNCOMMON": 2, "RARE": 3, "EPIC": 4, "LEGENDARY": 5}
LEVEL_RARITY = {v: k for k, v in RARITY_LEVEL.items()}


def parse_blocks(content, kind="WordEntity"):
    """Возвращает список (start, end, body) для всех <kind>(...) с правильным учётом строк."""
    blocks = []
    for m in re.finditer(rf"{kind}\s*\(", content):
        start = m.start()
        i = m.end()
        depth = 1
        in_str = False
        esc = False
        while i < len(content) and depth > 0:
            ch = content[i]
            if esc:
                esc = False
            elif ch == "\\":
                esc = True
            elif ch == '"':
                in_str = not in_str
            elif not in_str:
                if ch == "(":
                    depth += 1
                elif ch == ")":
                    depth -= 1
                    if depth == 0:
                        blocks.append((start, i + 1, content[m.end():i]))
                        break
            i += 1
    return blocks


def collect():
    """{set_id: {'file', 'level', 'rarities': Counter}}"""
    data = {}
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        content = open(path, encoding="utf-8").read()
        for _, _, body in parse_blocks(content, "WordSetEntity"):
            sid = re.search(r"\bid\s*=\s*(\d+)", body)
            lvl = re.search(r"\blevel\s*=\s*(\d+)", body)
            if sid and lvl:
                data[int(sid.group(1))] = {
                    "file": path, "level": int(lvl.group(1)), "rarities": Counter()
                }
        for _, _, body in parse_blocks(content, "WordEntity"):
            sid = re.search(r"\bsetId\s*=\s*(\d+)", body)
            rar = re.search(r'\brarity\s*=\s*"(\w+)"', body)
            if sid and rar:
                sid_v = int(sid.group(1))
                if sid_v == 0:
                    continue
                if sid_v in data:
                    data[sid_v]["rarities"][rar.group(1)] += 1
    return data


def spread(counter):
    levels = [RARITY_LEVEL[r] for r in counter if counter[r] > 0]
    return max(levels) - min(levels) + 1 if levels else 0


def plan(data):
    plans = {}
    for sid, info in data.items():
        if spread(info["rarities"]) <= 2:
            continue
        total = sum(info["rarities"].values())
        if total < 5:  # слишком маленький — пропускаем
            continue
        dom = RARITY_LEVEL[info["rarities"].most_common(1)[0][0]]
        target = dom if abs(dom - info["level"]) <= 1 else info["level"]
        above = sum(c for r, c in info["rarities"].items() if RARITY_LEVEL[r] > target)
        below = sum(c for r, c in info["rarities"].items() if RARITY_LEVEL[r] < target)
        if below > above:
            lo, hi = max(1, target - 1), target
        elif above > below:
            lo, hi = target, min(5, target + 1)
        else:
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
            plans[sid] = mapping
    return plans


def apply(plans):
    total = 0
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        content = open(path, encoding="utf-8").read()
        blocks = parse_blocks(content, "WordEntity")
        # справа-налево
        changed = 0
        for start, end, body in reversed(blocks):
            sid_m = re.search(r"\bsetId\s*=\s*(\d+)", body)
            rar_m = re.search(r'\brarity\s*=\s*"(\w+)"', body)
            if not (sid_m and rar_m):
                continue
            sid = int(sid_m.group(1))
            if sid not in plans:
                continue
            old = rar_m.group(1)
            if old not in plans[sid]:
                continue
            new = plans[sid][old]
            new_body = re.sub(
                r'(\brarity\s*=\s*")' + re.escape(old) + r'(")',
                rf'\g<1>{new}\g<2>',
                body, count=1,
            )
            content = content[:start] + f"WordEntity({new_body})" + content[end:]
            changed += 1
        if changed:
            open(path, "w", encoding="utf-8").write(content)
            total += changed
            print(f"{path.split(chr(92))[-1]}: {changed}")
    print(f"\nВсего изменений: {total}")


def main():
    for it in range(5):
        data = collect()
        plans = plan(data)
        print(f"--- Итерация {it+1}: {len(plans)} проблемных ---")
        if not plans:
            print("Готово, все наборы чистые.")
            break
        apply(plans)


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
