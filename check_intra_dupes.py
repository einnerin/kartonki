"""
Ищет дубли original-слов ВНУТРИ одного набора (setId).
"""
import re, glob, sys, os
from collections import defaultdict

sys.stdout.reconfigure(encoding="utf-8")

base = os.path.dirname(os.path.abspath(__file__))
data_dir = os.path.join(base, "app", "src", "main", "java", "com", "example", "kartonki", "data")
files = glob.glob(os.path.join(data_dir, "WordData*.kt"))

word_pat  = re.compile(r'WordEntity\(\s*id\s*=\s*(\d+),\s*setId\s*=\s*(\d+)[^)]*original\s*=\s*"([^"]+)"')
set_pat   = re.compile(r'WordSetEntity\([^)]*\bid\s*=\s*(\d+)[^)]*languagePair\s*=\s*"he-ru"')

sets     = defaultdict(list)   # setId -> [(wordId, original)]
file_of  = {}                  # setId -> filename

for f in sorted(files):
    fname = os.path.basename(f)
    content = open(f, encoding="utf-8").read()
    for m in set_pat.finditer(content):
        file_of[int(m.group(1))] = fname
    for m in word_pat.finditer(content):
        sets[int(m.group(2))].append((int(m.group(1)), m.group(3)))

found = False
for sid in sorted(sets):
    seen = defaultdict(list)
    for wid, orig in sets[sid]:
        seen[orig].append(wid)
    dups = {o: ids for o, ids in seen.items() if len(ids) > 1}
    if dups:
        found = True
        fname = file_of.get(sid, "?")
        print(f"Set {sid} [{fname}]:")
        for orig, ids in dups.items():
            print(f"  ДУБЛЬ: {orig!r}  wordIds={ids}")

if not found:
    print("✅ Дублей внутри наборов не найдено")
