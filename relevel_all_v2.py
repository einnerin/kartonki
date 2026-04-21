"""Relevel + rename для en-ru и he-ru с правильным парсером."""
import re
import glob
import sys
from collections import defaultdict, Counter

RARITY_LEVEL = {"COMMON": 1, "UNCOMMON": 2, "RARE": 3, "EPIC": 4, "LEGENDARY": 5}
LEVEL_WORDS = {1: "основы", 2: "продвинутый", 3: "углублённый",
               4: "профессиональный", 5: "носитель языка"}


def parse(content, kind):
    out = []
    for m in re.finditer(rf"{kind}\s*\(", content):
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
                        out.append((start, i + 1, content[m.end():i]))
                        break
            i += 1
    return out


def lang_from_path(path):
    if "English" in path: return "en"
    if "Hebrew" in path: return "he"
    return None


def collect_rarities():
    rar = defaultdict(Counter)
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        if not lang_from_path(path): continue
        content = open(path, encoding="utf-8").read()
        for _, _, body in parse(content, "WordEntity"):
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


def relevel():
    set_rar = collect_rarities()
    changes = 0
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        if not lang_from_path(path): continue
        content = open(path, encoding="utf-8").read()
        blocks = parse(content, "WordSetEntity")
        local = 0
        for start, end, body in reversed(blocks):
            id_m = re.search(r"\bid\s*=\s*(\d+)", body)
            lvl_m = re.search(r"\blevel\s*=\s*(\d+)", body)
            if not (id_m and lvl_m): continue
            sid = int(id_m.group(1)); cur = int(lvl_m.group(1))
            rec = recommend_level(set_rar.get(sid, Counter()), cur)
            if rec == cur: continue
            new_body = re.sub(r"\blevel\s*=\s*\d+", f"level = {rec}", body, count=1)
            content = content[:start] + f"WordSetEntity({new_body})" + content[end:]
            local += 1
        if local:
            open(path, "w", encoding="utf-8").write(content)
            changes += local
    print(f"Relevel: {changes} наборов")


def rename_all():
    """Переименовывает наборы по schema '<topic>: <level> [N]' в рамках (lang, topic, level)."""
    records = []
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        lang = lang_from_path(path)
        if not lang: continue
        content = open(path, encoding="utf-8").read()
        for _, _, body in parse(content, "WordSetEntity"):
            id_m = re.search(r"\bid\s*=\s*(\d+)", body)
            name_m = re.search(r'\bname\s*=\s*"((?:\\"|[^"])*)"', body)
            topic_m = re.search(r'\btopic\s*=\s*"((?:\\"|[^"])*)"', body)
            level_m = re.search(r"\blevel\s*=\s*(\d+)", body)
            if not (id_m and name_m and topic_m and level_m): continue
            records.append({
                "file": path, "lang": lang,
                "id": int(id_m.group(1)), "name": name_m.group(1),
                "topic": topic_m.group(1), "level": int(level_m.group(1)),
            })
    groups = defaultdict(list)
    for r in records:
        groups[(r["lang"], r["topic"], r["level"])].append(r)
    for key, g in groups.items():
        g.sort(key=lambda r: r["id"])
        _, topic, level = key
        word = LEVEL_WORDS[level]
        for idx, r in enumerate(g, 1):
            suffix = "" if idx == 1 else f" {idx}"
            r["new_name"] = f"{topic}: {word}{suffix}"
    by_file = defaultdict(list)
    for r in records:
        by_file[r["file"]].append(r)
    changes = 0
    for path, rs in by_file.items():
        content = open(path, encoding="utf-8").read()
        for r in rs:
            if r.get("new_name") == r["name"]: continue
            pat = rf'(\bid\s*=\s*{r["id"]}\b[^)]*?\bname\s*=\s*")' + re.escape(r["name"]) + r'(")'
            new_content, n = re.subn(pat, rf'\g<1>{r["new_name"]}\g<2>', content, count=1, flags=re.DOTALL)
            if n:
                content = new_content
                changes += 1
        open(path, "w", encoding="utf-8").write(content)
    print(f"Rename: {changes} имён")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    relevel()
    rename_all()
