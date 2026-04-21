"""Переразмечает level he-ru наборов по реальной редкости слов (как relevel_english)."""
import re
import glob
import sys
from collections import defaultdict, Counter

RARITY_LEVEL = {"COMMON": 1, "UNCOMMON": 2, "RARE": 3, "EPIC": 4, "LEGENDARY": 5}

GLOB = "app/src/main/java/com/example/kartonki/data/WordDataHebrew*.kt"


def find_blocks(content):
    blocks = []
    for m in re.finditer(r"WordSetEntity\s*\(", content):
        start = m.start(); i = m.end(); depth = 1; in_str = False; esc = False
        while i < len(content) and depth > 0:
            ch = content[i]
            if esc: esc = False
            elif ch == "\\": esc = True
            elif ch == '"': in_str = not in_str
            elif not in_str:
                if ch == "(": depth += 1
                elif ch == ")":
                    depth -= 1
                    if depth == 0:
                        blocks.append((start, i + 1, content[m.end():i])); break
            i += 1
    return blocks


def collect_rarities():
    rar = defaultdict(Counter)
    for path in sorted(glob.glob(GLOB)):
        content = open(path, encoding="utf-8").read()
        for m in re.finditer(r"WordEntity\s*\(([^)]+)\)", content, re.DOTALL):
            body = m.group(1)
            sid = re.search(r"\bsetId\s*=\s*(\d+)", body)
            rm = re.search(r'\brarity\s*=\s*"(\w+)"', body)
            if sid and rm:
                s = int(sid.group(1))
                if s == 0: continue
                rar[s][rm.group(1)] += 1
    return rar


def recommend_level(counter, cur):
    total = sum(counter.values())
    if total < 15:
        return cur
    for r, c in counter.most_common():
        if c >= 10:
            return RARITY_LEVEL[r]
    for r in ["LEGENDARY", "EPIC", "RARE", "UNCOMMON", "COMMON"]:
        if counter.get(r, 0) >= 8:
            return RARITY_LEVEL[r]
    return RARITY_LEVEL[counter.most_common(1)[0][0]]


def main():
    set_rar = collect_rarities()
    changes = []
    for path in sorted(glob.glob(GLOB)):
        content = open(path, encoding="utf-8").read()
        blocks = find_blocks(content)
        local = []
        for start, end, body in reversed(blocks):
            id_m = re.search(r"\bid\s*=\s*(\d+)", body)
            lvl_m = re.search(r"\blevel\s*=\s*(\d+)", body)
            name_m = re.search(r'\bname\s*=\s*"((?:\\"|[^"])*)"', body)
            if not (id_m and lvl_m and name_m): continue
            sid = int(id_m.group(1)); cur = int(lvl_m.group(1))
            rec = recommend_level(set_rar.get(sid, Counter()), cur)
            if rec == cur: continue
            new_body = re.sub(r"\blevel\s*=\s*\d+", f"level = {rec}", body, count=1)
            content = content[:start] + f"WordSetEntity({new_body})" + content[end:]
            local.append((sid, name_m.group(1), cur, rec))
        if local:
            open(path, "w", encoding="utf-8").write(content)
            changes.extend(local)
    for sid, name, cur, new in sorted(changes):
        print(f"  {sid}\tL{cur}→L{new}\t{name}")
    print(f"\nПереразмечено: {len(changes)}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
