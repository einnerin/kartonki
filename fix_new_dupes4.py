import re, sys
sys.stdout.reconfigure(encoding='utf-8')

REPLACEMENTS = [
    (20106, "level", "[ˈlevəl]", "строительный уровень"),
    (24818, "covalent bond", "[koʊˈveɪlənt bɒnd]", "ковалентная связь"),
]

# Ещё есть "scene" в 20624 (set 206)? Посмотрим выше: 1. show remaining
# "Scene" уже заменён на "backdrop" -- дубль scene в наборе 23 не должен быть
# Посмотрю что за дубль в теме "Культура и искусство" set 23

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
