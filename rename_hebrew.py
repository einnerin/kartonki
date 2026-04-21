"""Переименовывает he-ru наборы в '<topic>: <уровень> [N]' после relevel."""
import re
import glob
import sys
from collections import defaultdict

LEVEL_WORDS = {1: "основы", 2: "продвинутый", 3: "углублённый",
               4: "профессиональный", 5: "носитель языка"}
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


def collect():
    records = []
    for path in sorted(glob.glob(GLOB)):
        content = open(path, encoding="utf-8").read()
        for start, end, body in find_blocks(content):
            id_m = re.search(r"\bid\s*=\s*(\d+)", body)
            name_m = re.search(r'\bname\s*=\s*"((?:\\"|[^"])*)"', body)
            topic_m = re.search(r'\btopic\s*=\s*"((?:\\"|[^"])*)"', body)
            level_m = re.search(r"\blevel\s*=\s*(\d+)", body)
            if not (id_m and name_m and topic_m and level_m): continue
            records.append({"file": path, "id": int(id_m.group(1)),
                            "name": name_m.group(1), "topic": topic_m.group(1),
                            "level": int(level_m.group(1))})
    return records


def assign(records):
    groups = defaultdict(list)
    for r in records:
        groups[(r["topic"], r["level"])].append(r)
    for (topic, level), g in groups.items():
        g.sort(key=lambda r: r["id"])
        word = LEVEL_WORDS[level]
        for idx, r in enumerate(g, 1):
            suffix = "" if idx == 1 else f" {idx}"
            r["new_name"] = f"{topic}: {word}{suffix}"


def apply(records):
    by_file = defaultdict(list)
    for r in records:
        by_file[r["file"]].append(r)
    for path, rs in by_file.items():
        content = open(path, encoding="utf-8").read()
        for r in rs:
            if r["new_name"] == r["name"]: continue
            old_esc = re.escape(r["name"])
            pat = rf'(\bid\s*=\s*{r["id"]}\b[^)]*?\bname\s*=\s*")({old_esc})(")'
            content, _ = re.subn(pat, rf'\g<1>{r["new_name"]}\g<3>', content, count=1, flags=re.DOTALL)
        open(path, "w", encoding="utf-8").write(content)


def main():
    records = collect()
    assign(records)
    renames = [r for r in records if r.get("new_name") != r["name"]]
    print(f"Переименований: {len(renames)}")
    for r in renames[:15]:
        print(f"  {r['id']}\t{r['name']} → {r['new_name']}")
    if len(renames) > 15:
        print(f"  ... +{len(renames) - 15}")
    apply(records)


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
