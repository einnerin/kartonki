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


cov = defaultdict(lambda: defaultdict(int))
for f in glob.glob('app/src/main/java/com/example/kartonki/data/WordDataEnglish*.kt'):
    content = open(f, encoding='utf-8').read()
    for body in parse(content, 'WordSetEntity'):
        t = re.search(r'topic\s*=\s*"([^"]+)"', body)
        l = re.search(r'level\s*=\s*(\d+)', body)
        lang = re.search(r'languagePair\s*=\s*"([^"]+)"', body)
        if t and l and lang and lang.group(1) == 'en-ru':
            cov[t.group(1)][int(l.group(1))] += 1

with open('coverage_en.txt', 'w', encoding='utf-8') as out:
    out.write('Topic                          L1 L2 L3 L4 L5  missing\n')
    for t in sorted(cov):
        c = [cov[t].get(i, 0) for i in range(1, 6)]
        m = ','.join(str(i) for i in range(1, 6) if cov[t].get(i, 0) == 0) or '-'
        out.write(f'{t:30} {c[0]:>2} {c[1]:>2} {c[2]:>2} {c[3]:>2} {c[4]:>2}  {m}\n')
print('written coverage_en.txt')
