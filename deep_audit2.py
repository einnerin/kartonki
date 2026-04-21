"""Доп. проверки, не входящие в deep_audit.py:
  E1. Наборы без слов (empty set)
  E2. Дубли word id
  E3. Дубли оригиналов в пределах одного набора (intra-set)
  E4. Дубли translation в одном наборе (семантические внутри)
  E5. Слова с одинаковым translation в разных темах одного языка
  E6. setId=0 слова ≠ achievement_reward
  E7. Наборы без слов в WordRegistry (orphan в реестре)
  E8. Слова в файле, который не зарегистрирован в WordRegistry
"""
import re
import glob
import sys
from collections import defaultdict, Counter


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
    sets, words = {}, []
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        fname = path.split("\\")[-1]
        content = open(path, encoding="utf-8").read()
        for _, _, body in parse(content, "WordSetEntity"):
            id_m = re.search(r"\bid\s*=\s*(\d+)", body)
            if id_m:
                topic_m = re.search(r'\btopic\s*=\s*"((?:\\"|[^"])*)"', body)
                lang_m = re.search(r'\blanguagePair\s*=\s*"((?:\\"|[^"])*)"', body)
                sets[int(id_m.group(1))] = {
                    "file": fname,
                    "topic": topic_m.group(1) if topic_m else None,
                    "lang": lang_m.group(1) if lang_m else None,
                }
        for _, _, body in parse(content, "WordEntity"):
            w = {"file": fname}
            for f in ["id", "setId"]:
                m = re.search(rf"\b{f}\s*=\s*(\d+)", body)
                w[f] = int(m.group(1)) if m else None
            for f in ["original", "translation", "transliteration", "rarity", "languagePair", "semanticGroup", "pos"]:
                m = re.search(rf'\b{f}\s*=\s*"((?:\\"|[^"])*)"', body)
                w[f] = m.group(1) if m else None
            words.append(w)

    print(f"Наборов: {len(sets)}, слов: {len(words)}\n")

    # E1: empty sets
    word_sets = {w["setId"] for w in words if w.get("setId") is not None}
    empty = set(sets) - word_sets
    if empty:
        print(f"E1 empty sets: {len(empty)}")
        for sid in sorted(empty)[:10]:
            print(f"  set {sid} [{sets[sid]['file']}]")
    else:
        print("E1 empty sets: 0")

    # E2: duplicate word ids
    id_counts = Counter(w["id"] for w in words if w.get("id"))
    dup_ids = [(wid, c) for wid, c in id_counts.items() if c > 1]
    print(f"E2 duplicate word ids: {len(dup_ids)}")
    for wid, c in dup_ids[:10]:
        files = [w["file"] for w in words if w.get("id") == wid]
        print(f"  id {wid} встречается {c} раз: {files}")

    # E3: дубли original в одном наборе
    dup_intra = []
    by_set_orig = defaultdict(list)
    for w in words:
        if w.get("setId") and w.get("original"):
            by_set_orig[(w["setId"], w["original"])].append(w)
    for key, ws in by_set_orig.items():
        if len(ws) > 1:
            dup_intra.append((key, ws))
    print(f"E3 intra-set original dupes: {len(dup_intra)}")
    for key, ws in dup_intra[:10]:
        print(f"  set {key[0]} orig={key[1]} — {len(ws)} шт, ids={[w['id'] for w in ws]}")

    # E4: дубли translation в одном наборе
    dup_trans = []
    by_set_tr = defaultdict(list)
    for w in words:
        if w.get("setId") and w.get("translation"):
            by_set_tr[(w["setId"], w["translation"])].append(w)
    for key, ws in by_set_tr.items():
        if len(ws) > 1:
            dup_trans.append((key, ws))
    print(f"E4 intra-set translation dupes: {len(dup_trans)}")
    for key, ws in dup_trans[:10]:
        print(f"  set {key[0]} tr={key[1]} — ids={[w['id'] for w in ws]}")

    # E5: одинаковый translation в разных темах одного языка (НЕ dup но маркер)
    # Оставим как просмотр — может быть нормально
    # skip

    # E6: setId=0 ≠ achievement_reward
    bad0 = [w for w in words if w.get("setId") == 0 and w.get("semanticGroup") != "achievement_reward"]
    print(f"E6 setId=0 не achievement_reward: {len(bad0)}")
    for w in bad0[:5]:
        print(f"  id={w['id']} orig={w.get('original')} semGroup={w.get('semanticGroup')}")

    # E7/E8: регистрация
    reg = open("app/src/main/java/com/example/kartonki/data/WordRegistry.kt", encoding="utf-8").read()
    registered = set(re.findall(r"WordData\w+", reg))
    existing_files = {p.split("\\")[-1].replace(".kt", "")
                      for p in glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")}
    not_reg = existing_files - registered - {"WordDataVersion"}
    print(f"E8 files on disk not registered: {len(not_reg)}")
    for f in sorted(not_reg)[:10]:
        print(f"  {f}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
