"""Дозаполняет 29 неполных he-ru наборов до 25 слов.

ADDITIONS: dict {set_id: [(rarity, original, translit, translation), ...]}
Слова вставляются в конец val words = listOf(...) соответствующего объекта.
"""
import re
import glob
import sys
from collections import defaultdict

ADDITIONS = {
    # --- +1 слово
    1478: [("COMMON", "דַפְדְּפָן", "дафдэфан", "браузер")],
    1483: [("COMMON", "שְׁטָר", "штар", "банкнота / купюра")],
    1487: [("COMMON", "קוּרְסִים", "курсим", "курсы повышения квалификации")],
    1494: [("UNCOMMON", "קַמְפֵּיין", "кампэйн", "политическая кампания")],
    1495: [("UNCOMMON", "תַּקָּנוֹן", "таканон", "устав / регламент")],
    1496: [("UNCOMMON", "פְּרַקְלִיטוּת", "праклитут", "прокуратура")],
    1499: [("COMMON", "עִיר הַבִּירָה", "ир hа-бира", "столица")],
    1518: [("UNCOMMON", "בּוֹטָנִיקָה", "ботаника", "ботаника")],
    1520: [("UNCOMMON", "מוּסְמָךְ", "мусмах", "сертифицированный / дипломированный")],
    1536: [("RARE", "רֶלַטִיבִיזְם", "релятивизм", "релятивизм (философский)")],
    1538: [("UNCOMMON", "שׁוֹמֵר רְחוֹב", "шомэр рхов", "уличный охранник / дружинник")],
    1547: [("UNCOMMON", "מַדְרֵגוֹת חֵרוּם", "мадрэгот херум", "аварийная лестница")],
    1548: [("RARE", "אוֹטוֹנוֹמְיָה מוּנִיצִיפָּלִית", "отономия муниципалит", "муниципальная автономия")],
    1554: [("UNCOMMON", "פְּעִילוּת פִּיקּוּחַ", "пэилут пикуах", "надзорная деятельность")],
    1556: [("UNCOMMON", "בָּשָׂר טָחוּן", "басар тахун", "фарш")],

    # --- +2 слова
    1486: [
        ("COMMON", "מְנַהֵל", "мэнаhэл", "начальник / управляющий"),
        ("COMMON", "צֶוֶת", "цэвэт", "команда / коллектив"),
    ],
    1489: [
        ("COMMON", "הַסָּעָה", "hасаа", "перевозка / доставка"),
        ("COMMON", "שַׁיָּט", "шаят", "водитель автобуса"),
    ],
    1521: [
        ("RARE", "מֶנְטוֹרִינְג", "мэнторинг", "менторинг / наставничество"),
        ("RARE", "תְּמִיכָה מִקְצוֹעִית", "тмиха микцоит", "профессиональная поддержка"),
    ],
    1522: [
        ("UNCOMMON", "מוֹנוֹרֵיל", "монорель", "монорельс"),
        ("UNCOMMON", "חָסוּם", "хасум", "заблокирован (о дороге)"),
    ],
    1523: [
        ("RARE", "בִּיוֹמַסָּה", "биомаса", "биомасса"),
        ("RARE", "סַחֲלַב בַּר", "сахлав бар", "дикая орхидея"),
    ],
    1525: [
        ("UNCOMMON", "אוֹסֶף אָמָּנוּתִי", "осэф аманути", "художественная коллекция"),
        ("UNCOMMON", "חֲלִילָן", "халилан", "флейтист"),
    ],
    1550: [
        ("UNCOMMON", "חֲדַר מִיוּן", "хадар миюн", "приёмное отделение"),
        ("UNCOMMON", "קוּפַּת חוֹלִים", "купат холим", "больничная касса"),
    ],

    # --- +3 слова
    1500: [
        ("COMMON", "זְרִיקָה", "зрика", "укол / инъекция"),
        ("COMMON", "תַּחְבּוֹשֶׁת", "тахбошэт", "повязка / бинт"),
        ("COMMON", "מַדְחוֹם", "мадхом", "термометр"),
    ],

    # --- +4 слова
    1488: [
        ("COMMON", "סַפְסַל תַּחֲנָה", "сафсаль тахана", "скамейка на остановке"),
        ("COMMON", "שֶׁלֶט רְחוֹב", "шэлэт рхов", "уличный знак"),
        ("COMMON", "סִימּוּן דְּרָכִים", "симун драхим", "разметка на дорогах"),
        ("COMMON", "נְסִיעַת בֹּקֶר", "нэсият бокэр", "утренняя поездка"),
    ],
    1517: [
        ("UNCOMMON", "הַחְלָפַת דִּירָה", "hахлафат дира", "обмен квартиры"),
        ("UNCOMMON", "רֶנוֹבַצְיָה", "рэновация", "реновация"),
        ("UNCOMMON", "דַּוָּר", "давар", "почтальон"),
        ("UNCOMMON", "תֵּיבַת דֹּאַר", "тэйват доар", "почтовый ящик"),
    ],
    1519: [
        ("RARE", "הֶתְקֵפָה", "hэткафа", "приступ (медицинский)"),
        ("RARE", "הַרְעָלָה", "hарала", "отравление"),
        ("RARE", "גִּידּוּל", "гидуль", "опухоль / новообразование"),
        ("RARE", "תַּפְקוּד רֵיאָה", "тафкуд рэа", "функция лёгких"),
    ],
    1524: [
        ("RARE", "בּוּרְסַת מְנָיוֹת", "бурсат мэнайот", "фондовая биржа"),
        ("RARE", "מַשְׁבֵּר פִינַנְסִי", "машбэр финанси", "финансовый кризис"),
        ("RARE", "חוֹב לְאוּמִי", "хов лэуми", "государственный долг"),
        ("RARE", "תַּשְׁקִיף הַנְפָּקָה", "ташкиф hанпака", "проспект эмиссии"),
    ],

    # --- +5 слов
    1526: [
        ("UNCOMMON", "מְאַוְרֵר", "мэаврэр", "вентилятор"),
        ("UNCOMMON", "דּוּד שֶׁמֶשׁ", "дуд шэмэш", "солнечный бойлер"),
        ("UNCOMMON", "שִׁילוּט דִּירָה", "шилут дира", "домовые указатели"),
        ("UNCOMMON", "דֶּלֶת פַּלָדָה", "дэлэт палада", "стальная дверь"),
        ("UNCOMMON", "גְּנֵרָטוֹר חֵרוּם", "гэнэратор херум", "аварийный генератор"),
    ],
    1531: [
        ("UNCOMMON", "מוֹטִיבַצְיָה", "мотивация", "мотивация (психологическая)"),
        ("UNCOMMON", "קִנְאָה", "кинъа", "зависть / ревность"),
        ("UNCOMMON", "חֲשִׁיבָה חִיּוּבִית", "хашива хиювит", "позитивное мышление"),
        ("UNCOMMON", "רֶזִילְיָאנְצְיָה", "рэзильянция", "резильентность / устойчивость"),
        ("UNCOMMON", "תְּמִיכָה הֲדָדִית", "тмиха hададит", "взаимная поддержка"),
    ],
}


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
    # Найти файл для каждого set_id
    set_file = {}
    max_id_in_set = defaultdict(int)
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        content = open(path, encoding="utf-8").read()
        for _, _, body in parse(content, "WordSetEntity"):
            sid = re.search(r"\bid\s*=\s*(\d+)", body)
            if sid:
                set_file[int(sid.group(1))] = path
        for _, _, body in parse(content, "WordEntity"):
            sid = re.search(r"\bsetId\s*=\s*(\d+)", body)
            wid = re.search(r"\bid\s*=\s*(\d+)", body)
            if sid and wid:
                s = int(sid.group(1))
                max_id_in_set[s] = max(max_id_in_set[s], int(wid.group(1)))

    # По файлу группируем дополнения
    by_file = defaultdict(list)
    for sid, words in ADDITIONS.items():
        path = set_file.get(sid)
        if not path:
            print(f"! set {sid} не найден в файлах")
            continue
        next_id = max_id_in_set[sid] + 1
        for rar, orig, trl, tr in words:
            by_file[path].append((sid, next_id, rar, orig, trl, tr))
            next_id += 1

    for path, additions in by_file.items():
        content = open(path, encoding="utf-8").read()
        # Вставляем перед последней закрывающей `)` в listOf объекта
        # Находим последнее WordEntity перед закрытием listOf
        # Простой способ: найти `)` + `\n    )` — конец listOf
        # Альтернатива — найти самый последний WordEntity и вставить после него

        # Найдём позиции всех WordEntity блоков
        blocks = parse(content, "WordEntity")
        # Сгруппируем по set_id добавления для точной вставки
        for sid, wid, rar, orig, trl, tr in additions:
            # Найти последний WordEntity с этим setId
            last_end = None
            last_indent = None
            for start, end, body in blocks:
                sid_m = re.search(r"\bsetId\s*=\s*(\d+)", body)
                if sid_m and int(sid_m.group(1)) == sid:
                    last_end = end
                    # Сохраняем отступ строки
                    line_start = content.rfind("\n", 0, start) + 1
                    last_indent = content[line_start:start]
            if last_end is None:
                print(f"! не нашёл слов setId={sid} в {path}")
                continue
            # Сформировать новый блок
            new_block = (
                f',\n{last_indent}WordEntity(id = {wid}, setId = {sid}, languagePair = "he-ru", '
                f'rarity = "{rar}",\n{last_indent}    original = "{orig}", translation = "{tr}", '
                f'transliteration = "{trl}")'
            )
            # Исходная строка заканчивалась на "),"
            # Вставляем перед первой `,` или `)` после last_end? Просто после last_end?
            # Аккуратно: нужно вставить новый WordEntity(...) с запятой после последнего существующего
            # Последний существующий уже имеет `)` и возможно `,` после
            # Найдём: last_end указывает на ) + 1 текущего. Если после него `,` — пропустим.
            insert_pos = last_end
            if insert_pos < len(content) and content[insert_pos] == ",":
                insert_pos += 1
            content = content[:insert_pos] + new_block + content[insert_pos:]
            # blocks уже не валиден после вставки — пересчитаем
            blocks = parse(content, "WordEntity")
        open(path, "w", encoding="utf-8").write(content)
        print(f"{path.split(chr(92))[-1]}: +{len(additions)} слов")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
