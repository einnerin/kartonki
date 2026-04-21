import re, sys
sys.stdout.reconfigure(encoding='utf-8')

# Заменяю פֶּסִימִיּוּת в set 1531 на что-то ещё
path = "app/src/main/java/com/example/kartonki/data/WordDataHebrewBatch87.kt"
content = open(path, encoding="utf-8").read()

old = "פֶּסִימִיּוּת"
new_orig = "הֲגָנַת הָאֶגוֹ"
new_trl = "hагана hа-эго"
new_tr = "защита эго (психол.)"

pat = (rf'(WordEntity\([^)]*?setId\s*=\s*1531\b[^)]*?)'
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
    print(f"set 1531: {old} → {new_orig}")
else:
    print("не нашёл")
