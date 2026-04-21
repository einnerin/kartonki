"""Находит английские наборы с нарушением разброса редкости (>2 смежных уровня).

Разброс = (max_rarity_level - min_rarity_level + 1) для редкостей, реально
присутствующих в наборе. Правило: ≤ 2 смежных.
"""
import re
import glob
import sys
from collections import defaultdict, Counter

RARITY_LEVEL = {"COMMON": 1, "UNCOMMON": 2, "RARE": 3, "EPIC": 4, "LEGENDARY": 5}
LEVEL_TO_NAME = {1: "COMMON", 2: "UNCOMMON", 3: "RARE", 4: "EPIC", 5: "LEGENDARY"}


def collect():
    """Возвращает {set_id: {'name', 'file', 'level', 'rarities': Counter}}."""
    data = {}
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordDataEnglish*.kt")):
        content = open(path, encoding="utf-8").read()
        # WordSetEntity
        for m in re.finditer(r"WordSetEntity\s*\(([^)]+)\)", content, re.DOTALL):
            body = m.group(1)
            sid_m = re.search(r"\bid\s*=\s*(\d+)", body)
            name_m = re.search(r'\bname\s*=\s*"((?:\\"|[^"])*)"', body)
            level_m = re.search(r"\blevel\s*=\s*(\d+)", body)
            topic_m = re.search(r'\btopic\s*=\s*"((?:\\"|[^"])*)"', body)
            if sid_m and name_m and level_m and topic_m:
                data[int(sid_m.group(1))] = {
                    "name": name_m.group(1),
                    "file": path.split("\\")[-1],
                    "level": int(level_m.group(1)),
                    "topic": topic_m.group(1),
                    "rarities": Counter(),
                    "words": [],
                }
        # WordEntity
        for m in re.finditer(r"WordEntity\s*\(([^)]+)\)", content, re.DOTALL):
            body = m.group(1)
            sid_m = re.search(r"\bsetId\s*=\s*(\d+)", body)
            rar_m = re.search(r'\brarity\s*=\s*"(\w+)"', body)
            orig_m = re.search(r'\boriginal\s*=\s*"([^"]+)"', body)
            if sid_m and rar_m:
                set_id = int(sid_m.group(1))
                if set_id in data:
                    data[set_id]["rarities"][rar_m.group(1)] += 1
                    data[set_id]["words"].append((rar_m.group(1), orig_m.group(1) if orig_m else ""))
    return data


def spread(counter):
    if not counter:
        return 0
    levels = [RARITY_LEVEL[r] for r in counter if counter[r] > 0]
    return max(levels) - min(levels) + 1


def main():
    data = collect()
    bad = []
    for set_id, info in data.items():
        s = spread(info["rarities"])
        if s > 2:
            bad.append((set_id, info, s))
    bad.sort(key=lambda x: -x[2])

    with open("audit_spread.txt", "w", encoding="utf-8") as f:
        f.write(f"=== Наборы с разбросом >2: {len(bad)} из {len(data)} ===\n\n")
        for set_id, info, s in bad:
            rar_str = " ".join(f"{LEVEL_TO_NAME[i][:3]}={info['rarities'][LEVEL_TO_NAME[i]]}" for i in range(1, 6))
            f.write(f"[{set_id}] L{info['level']}, spread={s}  {rar_str}  | {info['name']} ({info['file']})\n")
    print(f"Найдено: {len(bad)} из {len(data)}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
