import re, glob, sys
from collections import Counter
sys.stdout.reconfigure(encoding='utf-8')

RARITY_LEVEL = {'COMMON': 1, 'UNCOMMON': 2, 'RARE': 3, 'EPIC': 4, 'LEGENDARY': 5}


def parse(content, kind):
    out = []
    for m in re.finditer(rf'{kind}\s*\(', content):
        i = m.end(); depth = 1; in_str = False; esc = False
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
                        out.append(content[m.end():i]); break
            i += 1
    return out


set_rar = {}
for f in glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt'):
    content = open(f, encoding='utf-8').read()
    for body in parse(content, 'WordEntity'):
        sid = re.search(r'\bsetId\s*=\s*(\d+)', body)
        rar = re.search(r'\brarity\s*=\s*"(\w+)"', body)
        if sid and rar:
            s = int(sid.group(1))
            if s == 0: continue
            set_rar.setdefault(s, Counter())[rar.group(1)] += 1

bad = 0
for sid, c in set_rar.items():
    levels = [RARITY_LEVEL[r] for r in c if c[r] > 0]
    if levels and max(levels) - min(levels) + 1 > 2:
        bad += 1
        print(f'BAD set {sid}: {dict(c)}')
print(f'Total sets with spread > 2: {bad}')
