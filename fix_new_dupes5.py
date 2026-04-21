import re, sys
sys.stdout.reconfigure(encoding='utf-8')

REPLACEMENTS = [
    (20106, "sandpaper", "[ˈsændˌpeɪpər]", "наждачная бумага"),
]
PATH = "app/src/main/java/com/example/kartonki/data/WordDataEnglishExpanded.kt"
content = open(PATH, encoding='utf-8').read()
for wid, orig, pron, tr in REPLACEMENTS:
    pat = (rf'(WordEntity\([^)]*?\bid\s*=\s*{wid}\b[^)]*?)'
           rf'original\s*=\s*"[^"]*"([^)]*?)'
           rf'transliteration\s*=\s*"[^"]*"([^)]*?)'
           rf'translation\s*=\s*"[^"]*"')
    new, n = re.subn(pat, rf'\g<1>original = "{orig}"\g<2>transliteration = "{pron}"\g<3>translation = "{tr}"', content, count=1, flags=re.DOTALL)
    if n:
        content = new
        print(f"id={wid} → {orig}")
open(PATH, "w", encoding='utf-8').write(content)
