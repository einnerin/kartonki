"""Перенумеровывает WordEntity id по формуле setId × 100 + позиция (1..25).

Глобальная нумерация: если слова набора распределены по нескольким файлам
(например, Immigrant.kt + ImmigrantExtra.kt), позиция считается сквозной.
Порядок обхода — по WordRegistry.kt (чтобы не перепутать).

setId=0 (achievement rewards) не трогает.
"""
import re
import sys
from collections import defaultdict


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
                        out.append((start, i + 1, content[m.end():i])); break
            i += 1
    return out


def main():
    # Порядок из WordRegistry.kt
    reg_text = open("app/src/main/java/com/example/kartonki/data/WordRegistry.kt", encoding="utf-8").read()
    order = []
    seen = set()
    for m in re.finditer(r"WordData\w+", reg_text):
        name = m.group(0)
        if name in seen or name in ("WordDataVersion",):
            continue
        seen.add(name)
        order.append(name)

    # 1) Первый проход: глобальные счётчики позиций по setId в порядке регистра
    positions = defaultdict(int)
    # file → list of (start, end, sid, new_id)
    plan = {}

    for name in order:
        path = f"app/src/main/java/com/example/kartonki/data/{name}.kt"
        content = open(path, encoding="utf-8").read()
        blocks = parse(content, "WordEntity")
        file_plan = []
        for start, end, body in blocks:
            sid_m = re.search(r"\bsetId\s*=\s*(\d+)", body)
            id_m = re.search(r"\bid\s*=\s*(\d+)", body)
            if not (sid_m and id_m):
                continue
            sid = int(sid_m.group(1))
            if sid == 0:
                file_plan.append((start, end, int(id_m.group(1))))
                continue
            positions[sid] += 1
            new_id = sid * 100 + positions[sid]
            file_plan.append((start, end, new_id))
        plan[path] = (content, blocks, file_plan)

    # 2) Применяем
    total = 0
    for path, (content, blocks, file_plan) in plan.items():
        # справа-налево
        for (start, end, new_id), (_, _, body) in zip(reversed(file_plan), reversed(blocks)):
            id_m = re.search(r"\bid\s*=\s*(\d+)", body)
            if not id_m: continue
            cur_id = int(id_m.group(1))
            if cur_id == new_id:
                continue
            new_body = re.sub(r"(\bid\s*=\s*)\d+", rf"\g<1>{new_id}", body, count=1)
            content = content[:start] + f"WordEntity({new_body})" + content[end:]
            total += 1
        open(path, "w", encoding="utf-8").write(content)
    print(f"Перенумеровано слов: {total}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
