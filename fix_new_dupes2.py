import re, sys
sys.stdout.reconfigure(encoding='utf-8')

REPLACEMENTS = [
    ("WordDataHebrewBatch87.kt", 1531, "אוֹפְּטִימִיּוּת", "פֶּסִימִיּוּת", "пэсимиют", "пессимизм / пессимистичный взгляд"),
    ("WordDataHebrewBatch80.kt", 1500, "גֶּבֶס", "סַד", "сад", "шина (медицинская) / лангетка"),
]

for file, sid, old, new_orig, new_trl, new_tr in REPLACEMENTS:
    path = f"app/src/main/java/com/example/kartonki/data/{file}"
    content = open(path, encoding="utf-8").read()
    pat = (rf'(WordEntity\([^)]*?setId\s*=\s*{sid}\b[^)]*?)'
           rf'original\s*=\s*"{re.escape(old)}"'
           rf'([^)]*?translation\s*=\s*")[^"]*(")'
           rf'([^)]*?transliteration\s*=\s*")[^"]*(")')
    new_content, n = re.subn(
        pat,
        rf'\g<1>original = "{new_orig}"\g<2>{new_tr}\g<3>\g<4>{new_trl}\g<5>',
        content, count=1, flags=re.DOTALL,
    )
    if n:
        open(path, "w", encoding="utf-8").write(new_content)
        print(f"{file} set {sid}: {old} → {new_orig}")
