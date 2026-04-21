"""Удаляет дубли original слов внутри одной темы. Оставляет в наборе с меньшим setId,
удаляет WordEntity из набора с бо́льшим setId (обычно это мой Batch, а старое — stable).

Удаление: заменяет строку WordEntity(...) вместе с финальной запятой и переводом
на пустую строку.
"""
import re
import glob
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


def collect():
    sets = {}
    words = []
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        content = open(path, encoding="utf-8").read()
        for _, _, body in parse(content, "WordSetEntity"):
            id_m = re.search(r"\bid\s*=\s*(\d+)", body)
            topic_m = re.search(r'\btopic\s*=\s*"((?:\\"|[^"])*)"', body)
            lang_m = re.search(r'\blanguagePair\s*=\s*"((?:\\"|[^"])*)"', body)
            if id_m:
                sets[int(id_m.group(1))] = {
                    "file": path, "topic": topic_m.group(1) if topic_m else None,
                    "lang": lang_m.group(1) if lang_m else None,
                }
        for start, end, body in parse(content, "WordEntity"):
            sid_m = re.search(r"\bsetId\s*=\s*(\d+)", body)
            orig_m = re.search(r'\boriginal\s*=\s*"((?:\\"|[^"])*)"', body)
            if sid_m and orig_m:
                words.append({
                    "file": path, "start": start, "end": end,
                    "setId": int(sid_m.group(1)),
                    "original": orig_m.group(1),
                })
    return sets, words


def find_dupes(sets, words):
    """Возвращает (topic, lang, original) → list[word]."""
    buckets = defaultdict(list)
    for w in words:
        if w["setId"] == 0:
            continue
        si = sets.get(w["setId"])
        if not si or not si["topic"] or not si["lang"]:
            continue
        key = (si["lang"], si["topic"], w["original"])
        buckets[key].append(w)
    return {k: v for k, v in buckets.items() if len(v) > 1}


def plan_removals(dupes):
    """Из каждой группы дублей оставляем word с МИНИМАЛЬНЫМ setId, остальные удаляем."""
    removals = []
    for key, group in dupes.items():
        group.sort(key=lambda w: w["setId"])
        keeper = group[0]
        for w in group[1:]:
            removals.append(w)
    return removals


def apply_removals(removals):
    """Группируем по файлу и удаляем в обратном порядке позиций."""
    by_file = defaultdict(list)
    for r in removals:
        by_file[r["file"]].append(r)
    for path, rems in by_file.items():
        content = open(path, encoding="utf-8").read()
        # сортировать по start в убывающем порядке
        rems.sort(key=lambda r: -r["start"])
        for r in rems:
            start, end = r["start"], r["end"]
            # захватим предшествующий whitespace (отступ) + WordEntity(...) + запятую + \n
            # Найти начало строки с отступом
            line_start = content.rfind("\n", 0, start) + 1
            # Конец — до \n после запятой
            j = end
            while j < len(content) and content[j] in ", ":
                j += 1
            if j < len(content) and content[j] == "\n":
                j += 1
            # Удаляем весь этот кусок
            content = content[:line_start] + content[j:]
        open(path, "w", encoding="utf-8").write(content)
        print(f"{path.split(chr(92))[-1]}: удалено {len(rems)} дублей")


def main():
    sets, words = collect()
    dupes = find_dupes(sets, words)
    print(f"Дублирующихся групп: {len(dupes)}")
    removals = plan_removals(dupes)
    print(f"К удалению: {len(removals)}")
    # Показать первые 10
    for r in removals[:10]:
        si = sets[r["setId"]]
        print(f'  "{r["original"]}" из set {r["setId"]} ({si["topic"]}) [{r["file"].split(chr(92))[-1]}]')
    if len(removals) > 10:
        print(f"  ... ещё {len(removals) - 10}")
    apply_removals(removals)


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
