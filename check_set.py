import re, sys
from collections import Counter
sys.stdout.reconfigure(encoding='utf-8')

def parse(content, kind="WordEntity"):
    blocks = []
    for m in re.finditer(rf"{kind}\s*\(", content):
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
                        blocks.append(content[m.end():i])
                        break
            i += 1
    return blocks

content = open('app/src/main/java/com/example/kartonki/data/WordDataEnglishExpanded.kt', encoding='utf-8').read()
counter = Counter()
for body in parse(content, "WordEntity"):
    sid = re.search(r'setId\s*=\s*225\b', body)
    if not sid: continue
    rar = re.search(r'rarity\s*=\s*"(\w+)"', body)
    if rar:
        counter[rar.group(1)] += 1
print(f'Set 225 редкости: {dict(counter)}')
print(f'Всего слов: {sum(counter.values())}')
