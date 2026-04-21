"""Автогенератор транслитерации hebrew→cyrillic.

Учитывает:
  - matres lectionis (יִ = и; וֹ = о; וּ = у)
  - дагеш (בּ = б, כּ = к, פּ = п)
  - шин/син точки (שׁ = ш, שׂ = с)
  - немой ה в конце слова
  - алеф/аин в середине опускаются
"""
import re
import glob
import sys

CONS = {
    'א': "'", 'ע': "'",
    'ב': 'в', 'ג': 'г', 'ד': 'д', 'ה': 'h',
    'ו': 'в', 'ז': 'з', 'ח': 'х', 'ט': 'т', 'י': 'й',
    'כ': 'х', 'ך': 'х', 'ל': 'л',
    'מ': 'м', 'ם': 'м', 'נ': 'н', 'ן': 'н',
    'ס': 'с', 'פ': 'ф', 'ף': 'ф',
    'צ': 'ц', 'ץ': 'ц', 'ק': 'к', 'ר': 'р',
    'ש': 'ш', 'ת': 'т',
}

VOWELS = {
    '\u05B0': '',   # shva
    '\u05B1': 'э',
    '\u05B2': 'а',
    '\u05B3': 'о',
    '\u05B4': 'и',  # hirik
    '\u05B5': 'э',  # tzere
    '\u05B6': 'э',  # segol
    '\u05B7': 'а',  # patach
    '\u05B8': 'а',  # kamatz
    '\u05B9': 'о',  # holam (may be on letter or on vav)
    '\u05BA': 'о',  # holam haser
    '\u05BB': 'у',  # kubuts
}

DAGESH = '\u05BC'
SHIN_DOT = '\u05C1'
SIN_DOT = '\u05C2'
HEBREW_LETTERS = set(CONS)
FINAL_LETTERS = {'ך', 'ם', 'ן', 'ף', 'ץ'}


def _letter_with_diacritics(word, i):
    """Возвращает (letter, diacritics set, end_index)."""
    letter = word[i]
    j = i + 1
    diac = set()
    while j < len(word):
        c = word[j]
        if c in VOWELS or c in (DAGESH, SHIN_DOT, SIN_DOT):
            diac.add(c)
            j += 1
        elif 0x0591 <= ord(c) <= 0x05C7 and c not in HEBREW_LETTERS:
            # Прочие огласовки/кантилляция — игнорируем
            j += 1
        else:
            break
    return letter, diac, j


def transliterate(word: str) -> str:
    # Нормализуем
    word = word.strip()
    # Разбиваем на токены (слова через пробел/дефис)
    tokens = re.split(r"(\s+|-)", word)
    out_tokens = []
    for tok in tokens:
        if re.match(r"\s+|-", tok):
            out_tokens.append(tok)
            continue
        if not any(c in HEBREW_LETTERS for c in tok):
            out_tokens.append(tok)
            continue
        # Разбираем токен букву за буквой
        letters = []
        i = 0
        while i < len(tok):
            ch = tok[i]
            if ch in HEBREW_LETTERS:
                letter, diac, j = _letter_with_diacritics(tok, i)
                letters.append({"letter": letter, "diac": diac})
                i = j
            else:
                # Пропускаем гершаим/кавычки
                i += 1

        # Теперь пройдём по буквам, применяя контекст-правила
        out = []
        n = len(letters)
        for k, ld in enumerate(letters):
            letter = ld["letter"]
            diac = ld["diac"]
            vowel = None
            for v in VOWELS:
                if v in diac:
                    vowel = VOWELS[v]
                    break
            dagesh = DAGESH in diac
            shin_d = SHIN_DOT in diac
            sin_d = SIN_DOT in diac

            prev = letters[k - 1] if k > 0 else None
            nxt = letters[k + 1] if k + 1 < n else None

            cons = CONS[letter]

            # Спецправила
            if letter == 'ב':
                cons = 'б' if dagesh else 'в'
            elif letter in ('כ', 'ך'):
                cons = 'к' if dagesh else 'х'
            elif letter in ('פ', 'ף'):
                cons = 'п' if dagesh else 'ф'
            elif letter == 'ש':
                cons = 'с' if sin_d else 'ш'
            elif letter == 'ו':
                # matres lectionis или согласная?
                # - וּ (dagesh): если в начале — «ву», в середине — продлевает в «у»
                # - וֹ (holam): «о»
                # - ו без огласовок в конце — обычно «в»
                has_holam = '\u05B9' in diac
                if has_holam:
                    # matres «о»
                    cons = ''
                    vowel = 'о'
                elif dagesh:
                    # shuruk «у»
                    cons = ''
                    vowel = 'у'
                else:
                    # Обычная вав — «в»
                    cons = 'в'
            elif letter == 'י':
                # matres? если предыдущая буква имеет hirik — это часть «и»
                # если сам имеет огласовку — согласная «й»
                prev_hirik = prev and '\u05B4' in prev["diac"]
                if prev_hirik and not vowel:
                    cons = ''  # уже отражено в предыдущей «и»
                elif not vowel and not diac and k > 0:
                    # matres «и» без огласовки
                    cons = 'и'
                else:
                    cons = 'й'
            elif letter in ('א', 'ע'):
                cons = ''  # алеф/аин немые
            elif letter == 'ה' and k == n - 1 and not vowel:
                # Конечный немой hey
                cons = ''

            out.append(cons)
            if vowel:
                out.append(vowel)

        result = ''.join(out)
        # Подчистки
        result = re.sub(r"''+", "", result)
        result = re.sub(r"\s+", " ", result).strip()
        out_tokens.append(result or "?")

    return ''.join(out_tokens)


def parse(content, kind):
    out = []
    for m in re.finditer(rf"{kind}\s*\(", content):
        start = m.start(); i = m.end(); depth = 1; in_str = False; esc = False
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
                        out.append((start, i + 1, content[m.end():i])); break
            i += 1
    return out


def main():
    set_lang = {}
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        content = open(path, encoding="utf-8").read()
        for _, _, body in parse(content, "WordSetEntity"):
            sid = re.search(r"\bid\s*=\s*(\d+)", body)
            lang = re.search(r'\blanguagePair\s*=\s*"([^"]+)"', body)
            if sid and lang:
                set_lang[int(sid.group(1))] = lang.group(1)

    total = 0
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        content = open(path, encoding="utf-8").read()
        blocks = parse(content, "WordEntity")
        changed = 0
        for start, end, body in reversed(blocks):
            sid_m = re.search(r"\bsetId\s*=\s*(\d+)", body)
            orig_m = re.search(r'\boriginal\s*=\s*"((?:\\"|[^"])*)"', body)
            if not sid_m or not orig_m: continue
            sid = int(sid_m.group(1))
            if sid == 0 or set_lang.get(sid) != 'he-ru': continue
            if re.search(r'\btransliteration\s*=\s*"[^"]+"', body): continue

            translit = transliterate(orig_m.group(1))
            trimmed = body.rstrip().rstrip(",").rstrip()
            new_body = f'{trimmed}, transliteration = "{translit}"'
            content = content[:start] + f"WordEntity({new_body})" + content[end:]
            changed += 1
        if changed:
            open(path, "w", encoding="utf-8").write(content)
            total += changed
            print(f"{path.split(chr(92))[-1]}: +{changed}")
    print(f"\nИтого: {total}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    # Тесты
    samples = [
        ('אָחוֹת', 'ахот'),
        ('רוֹפֵא', 'рофэ'),
        ('חוֹלֶה', 'холэ'),
        ('בֵּית חוֹלִים', 'бэйт холим'),
        ('מִיטָה', 'мита'),
        ('תְּרוּפָה', 'труфа'),
        ('מַחְלָה', 'махла'),
        ('כְּאֵב', 'кэв'),
        ('חוֹם', 'хом'),
        ('לַחַץ דָּם', 'лахац дам'),
        ('אַנְטְרָקְט', 'антракт'),
        ('אוֹרְכֶסְטְרָה', 'оркэстра'),
        ('שָׁלוֹם', 'шалом'),
        ('יִשְׂרָאֵל', 'исраэл'),
        ('בּוֹקֶר', 'бокэр'),
    ]
    print("Тесты:")
    for orig, expected in samples:
        got = transliterate(orig)
        mark = "✓" if got == expected else "!"
        print(f"  {mark} {orig} → {got} (ожидал: {expected})")
    print()
    main()
