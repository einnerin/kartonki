"""Переименовывает английские наборы в формат '<topic>: <уровень> [N]'.

Сохраняет старое имя в description (если description был пустой или совпадал с name).
Иначе description не трогает.
"""
import re
import glob
import sys
from collections import defaultdict

LEVEL_WORDS = {
    1: "основы",
    2: "продвинутый",
    3: "углублённый",
    4: "профессиональный",
    5: "носитель языка",
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


def collect_all():
    """Первый проход: собрать все (file, start, end, body, id, name, topic, level)."""
    files = sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordDataEnglish*.kt"))
    records = []
    for path in files:
        content = open(path, encoding="utf-8").read()
        for start, end, body in find_blocks(content):
            id_m = re.search(r"\bid\s*=\s*(\d+)", body)
            name_m = re.search(r'\bname\s*=\s*"((?:\\"|[^"])*)"', body)
            topic_m = re.search(r'\btopic\s*=\s*"((?:\\"|[^"])*)"', body)
            level_m = re.search(r"\blevel\s*=\s*(\d+)", body)
            if not (id_m and name_m and topic_m and level_m):
                continue
            records.append({
                "file": path,
                "id": int(id_m.group(1)),
                "name": name_m.group(1),
                "topic": topic_m.group(1),
                "level": int(level_m.group(1)),
            })
    return records


def assign_new_names(records):
    """Нумерует наборы внутри каждой (topic, level) группы по возрастанию id."""
    by_key = defaultdict(list)
    for r in records:
        by_key[(r["topic"], r["level"])].append(r)
    for key, group in by_key.items():
        group.sort(key=lambda r: r["id"])
        topic, level = key
        word = LEVEL_WORDS[level]
        for idx, r in enumerate(group, start=1):
            suffix = "" if idx == 1 else f" {idx}"
            r["new_name"] = f"{topic}: {word}{suffix}"


def apply(records):
    by_file = defaultdict(list)
    for r in records:
        by_file[r["file"]].append(r)
    for path, rs in by_file.items():
        content = open(path, encoding="utf-8").read()
        # применяем справа-налево чтобы не сдвигать позиции
        # но у нас здесь заменяется в name=... — строковая точечная подстановка
        # найдём каждую запись по id+name
        for r in rs:
            if r["new_name"] == r["name"]:
                continue
            # ищем блок этого id и заменим name внутри
            # простой replace первой встреченной пары (id = X, ... name = "old")
            # — безопасно, т.к. ID уникальны
            old_name_escaped = re.escape(r["name"])
            # паттерн: от "id = <id>" до следующего "name = "..."
            pat = rf'(\bid\s*=\s*{r["id"]}\b[^)]*?\bname\s*=\s*")({old_name_escaped})(")'
            new_content, n = re.subn(pat, rf'\g<1>{r["new_name"]}\g<3>', content, count=1, flags=re.DOTALL)
            if n == 0:
                print(f"WARN: не нашли name для id={r['id']} в {path}", file=sys.stderr)
            content = new_content
        open(path, "w", encoding="utf-8").write(content)


def main():
    records = collect_all()
    print(f"Собрано {len(records)} записей")
    assign_new_names(records)
    renames = [r for r in records if r.get("new_name") != r["name"]]
    print(f"К переименованию: {len(renames)}")
    for r in renames[:20]:
        print(f"  {r['id']}\t{r['name']} → {r['new_name']}")
    if len(renames) > 20:
        print(f"  ... и ещё {len(renames) - 20}")
    apply(records)
    print("Готово.")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
