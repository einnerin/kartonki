import re, glob, sys
from collections import defaultdict
sys.stdout.reconfigure(encoding='utf-8')


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


words = []
for path in sorted(glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt')):
    content = open(path, encoding='utf-8').read()
    for body in parse(content, 'WordEntity'):
        w = {'file': path.split('\\')[-1]}
        for f in ['id', 'setId']:
            m = re.search(rf'\b{f}\s*=\s*(\d+)', body)
            w[f] = int(m.group(1)) if m else None
        for f in ['original', 'translation']:
            m = re.search(rf'\b{f}\s*=\s*"((?:\\"|[^"])*)"', body)
            w[f] = m.group(1) if m else None
        words.append(w)

by = defaultdict(list)
for w in words:
    if w.get('setId') and w.get('translation'):
        by[(w['setId'], w['translation'])].append(w)

for key, ws in by.items():
    if len(ws) > 1:
        print(f'set {key[0]} "{key[1]}":')
        for w in ws:
            print(f'  id={w["id"]}  orig="{w["original"]}"  [{w["file"]}]')
