"""Заменяет original+translation+transliteration у 9 моих добавленных слов, оказавшихся дублями."""
import re
import sys

# (file, setId, old_original, new_original, new_translit, new_translation)
REPLACEMENTS = [
    ("WordDataHebrewBatch87.kt", 1531, "מוֹטִיבַצְיָה", "אוֹפְּטִימִיּוּת", "оптимиют", "оптимизм"),
    ("WordDataHebrewBatch80.kt", 1500, "תַּחְבּוֹשֶׁת", "גֶּבֶס", "гэвэс", "гипс / фиксирующая повязка"),
    ("WordDataHebrewBatch85.kt", 1523, "בִּיוֹמַסָּה", "מַסְלוּל טִיּוּל", "маслул тийул", "туристический маршрут (в природе)"),
    ("WordDataHebrewBatch91.kt", 1550, "קוּפַּת חוֹלִים", "חַדְרֵי טִיפּוּל", "хадрэй типуль", "процедурные кабинеты"),
    ("WordDataHebrewBatch76.kt", 1483, "שְׁטָר", "מַטְבֵּעַ מְקוֹמִי", "матбэа мэкоми", "местная валюта"),
    ("WordDataHebrewBatch77.kt", 1489, "הַסָּעָה", "נַהֲגוּת", "наhагут", "водительская работа"),
    ("WordDataHebrewBatch84.kt", 1517, "תֵּיבַת דֹּאַר", "דֹּאַר רָשׁוּם", "доар рашум", "заказное письмо"),
    ("WordDataHebrewBatch86.kt", 1526, "דּוּד שֶׁמֶשׁ", "פִילְטֵר מַיִם", "фильтэр маим", "фильтр для воды"),
    ("WordDataHebrewBatch88.kt", 1536, "רֶלַטִיבִיזְם", "פּוֹזִיטִיבִיזְם", "позитивизм", "позитивизм (фил. школа)"),
]


def main():
    for file, sid, old, new_orig, new_trl, new_tr in REPLACEMENTS:
        path = f"app/src/main/java/com/example/kartonki/data/{file}"
        content = open(path, encoding="utf-8").read()
        # Ищем WordEntity с этим setId и этим original
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
            print(f"  {file} set {sid}: {old} → {new_orig}")
        else:
            print(f"  ! не нашёл {old} в {file} set {sid}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
