import re, glob, sys
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


n_no_lang = 0
files_affected = set()
for f in glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt'):
    content = open(f, encoding='utf-8').read()
    for body in parse(content, 'WordEntity'):
        if 'languagePair' not in body:
            sid = re.search(r'setId\s*=\s*(\d+)', body)
            if sid and int(sid.group(1)) == 0:
                continue
            n_no_lang += 1
            files_affected.add(f.split('\\')[-1])
print(f'Words without languagePair: {n_no_lang}')
print(f'Files affected ({len(files_affected)}):')
for fn in sorted(files_affected):
    print(f'  {fn}')
