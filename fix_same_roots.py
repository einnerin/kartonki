"""Заменяет одно слово из каждой однокоренной пары на синоним."""
import re
import sys

# (word_id, new_original, new_pron, new_translation)
# В каждой паре заменяю более сложное/длинное слово на независимое
REPLACEMENTS = [
    (20020, "crate", "[kreɪt]", "ящик / клеть"),
    (20106, "wrench", "[rentʃ]", "гаечный ключ"),
    (20620, "preview", "[ˈpriːvjuː]", "предварительный просмотр / анонс"),
    (20624, "scene", "[siːn]", "сцена / эпизод"),
    (21722, "serfdom", "[ˈsɜːrfdəm]", "крепостничество"),
    (23312, "dormancy", "[ˈdɔːrmənsi]", "покой / спячка (состояние)"),
    (23321, "scavenger", "[ˈskævɪndʒər]", "падальщик / детритофаг"),
    (24219, "tribute", "[ˈtrɪbjuːt]", "дань / почтение"),
    (24505, "director of photography", "[dɪˈrektər ʌv fəˈtɒɡrəfi]", "оператор-постановщик"),
    (24820, "anode", "[ˈænoʊd]", "анод"),
    (24818, "valence", "[ˈveɪləns]", "валентность"),
]

PATH = "app/src/main/java/com/example/kartonki/data/WordDataEnglishExpanded.kt"


def main():
    content = open(PATH, encoding="utf-8").read()
    n = 0
    for wid, new_orig, new_pron, new_tr in REPLACEMENTS:
        pat = (rf'(WordEntity\([^)]*?\bid\s*=\s*{wid}\b[^)]*?)'
               rf'original\s*=\s*"[^"]*"([^)]*?)'
               rf'transliteration\s*=\s*"[^"]*"([^)]*?)'
               rf'translation\s*=\s*"[^"]*"')
        new_content, count = re.subn(
            pat,
            rf'\g<1>original = "{new_orig}"\g<2>transliteration = "{new_pron}"\g<3>translation = "{new_tr}"',
            content, count=1, flags=re.DOTALL,
        )
        if count:
            content = new_content
            n += 1
            print(f"  id={wid}: → {new_orig}")
        else:
            print(f"  ! id={wid} не нашёл")
    open(PATH, "w", encoding="utf-8").write(content)
    print(f"\nОбновлено: {n}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
