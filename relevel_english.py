"""Переразмечает level английских наборов по реальной редкости слов внутри.

Правило: level = редкость, которая составляет БОЛЬШИНСТВО (>=10 из 25).
Если явного большинства нет — level ставится по самой «тяжёлой» редкости,
встречающейся >=8 раз (ближе к центру массы набора).

COMMON → L1, UNCOMMON → L2, RARE → L3, EPIC → L4, LEGENDARY → L5.
"""
import re
import glob
import sys
from collections import defaultdict, Counter

RARITY_LEVEL = {
    "COMMON": 1,
    "UNCOMMON": 2,
    "RARE": 3,
    "EPIC": 4,
    "LEGENDARY": 5,
}


def find_blocks(content: str):
    blocks = []
    for m in re.finditer(r"WordSetEntity\s*\(", content):
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


def collect_set_rarities():
    """Возвращает {set_id: Counter(rarity)}. setId=0 (achievement rewards) игнорируется."""
    rar = defaultdict(Counter)
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordDataEnglish*.kt")):
        content = open(path, encoding="utf-8").read()
        # setId и rarity могут быть в разном порядке — ищем оба поля в любой последовательности
        for m in re.finditer(r"WordEntity\s*\(([^)]+)\)", content, re.DOTALL):
            body = m.group(1)
            sid = re.search(r"setId\s*=\s*(\d+)", body)
            rar_m = re.search(r'rarity\s*=\s*"(\w+)"', body)
            if sid and rar_m:
                set_id = int(sid.group(1))
                if set_id == 0:
                    continue
                rar[set_id][rar_m.group(1)] += 1
    return rar


def recommend_level(counter: Counter, current_level: int) -> int:
    """Возвращает рекомендованный level по распределению редкостей."""
    total = sum(counter.values())
    # Мало данных — не трогаем
    if total < 15:
        return current_level

    # Явное большинство (>=10) — level по нему
    for r, c in counter.most_common():
        if c >= 10:
            return RARITY_LEVEL[r]

    # «Тяжёлая» редкость с большим вкладом (>=8 из 25)
    for r in ["LEGENDARY", "EPIC", "RARE", "UNCOMMON", "COMMON"]:
        if counter.get(r, 0) >= 8:
            return RARITY_LEVEL[r]

    # Фоллбэк — most_common[0]
    return RARITY_LEVEL[counter.most_common(1)[0][0]]


def process_file(path: str, set_rarities: dict) -> list:
    content = open(path, encoding="utf-8").read()
    blocks = find_blocks(content)
    changes = []
    for start, end, body in reversed(blocks):
        id_m = re.search(r"\bid\s*=\s*(\d+)", body)
        level_m = re.search(r"\blevel\s*=\s*(\d+)", body)
        name_m = re.search(r'\bname\s*=\s*"((?:\\"|[^"])*)"', body)
        if not (id_m and level_m and name_m):
            continue
        set_id = int(id_m.group(1))
        cur_level = int(level_m.group(1))
        rec_level = recommend_level(set_rarities.get(set_id, Counter()), cur_level)
        if rec_level == cur_level:
            continue
        new_body = re.sub(r"\blevel\s*=\s*\d+", f"level = {rec_level}", body, count=1)
        content = content[:start] + f"WordSetEntity({new_body})" + content[end:]
        changes.append((set_id, name_m.group(1), cur_level, rec_level,
                        dict(set_rarities.get(set_id, Counter()))))
    if changes:
        open(path, "w", encoding="utf-8").write(content)
    return list(reversed(changes))


def main():
    set_rarities = collect_set_rarities()
    total = 0
    distribution_before = Counter()
    distribution_after = Counter()
    files = sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordDataEnglish*.kt"))
    for f in files:
        changes = process_file(f, set_rarities)
        total += len(changes)
        for set_id, name, cur, new, counter in changes:
            distribution_before[cur] += 1
            distribution_after[new] += 1
            print(f"  {set_id}\tL{cur}→L{new}\t{name}\t({counter})")
    print(f"\nПереразмечено: {total} наборов")
    print(f"  Было:  {dict(distribution_before)}")
    print(f"  Стало: {dict(distribution_after)}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
