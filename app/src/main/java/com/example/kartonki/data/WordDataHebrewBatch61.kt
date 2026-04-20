package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch61 {

    val sets: List<WordSetEntity> get() = listOf(

        WordSetEntity(
            id = 1344, languagePair = "he-ru", orderIndex = 1344,
            name = "Математика: основы 2",
            description = "Фигуры, измерения, числа и операции",
            topic = "Математика",
            level = 1),

        WordSetEntity(
            id = 1345, languagePair = "he-ru", orderIndex = 1345,
            name = "Математика: продвинутый",
            description = "Алгебра, координатная геометрия, функции",
            topic = "Математика",
            level = 2),

        WordSetEntity(
            id = 1346, languagePair = "he-ru", orderIndex = 1346,
            name = "Математика: углублённый",
            description = "Тригонометрия, векторы, вероятность, начала анализа",
            topic = "Математика",
            level = 3),

        WordSetEntity(
            id = 1347, languagePair = "he-ru", orderIndex = 1347,
            name = "Математика: профессиональный",
            description = "Линейная алгебра, теория вероятностей, доказательства",
            topic = "Математика",
            level = 4),

        WordSetEntity(
            id = 1348, languagePair = "he-ru", orderIndex = 1348,
            name = "Математика: носитель языка",
            description = "Абстрактная алгебра, топология, теория чисел",
            topic = "Математика",
            level = 5),
    )

    val words: List<WordEntity> get() = listOf(

        // ── Set 1344: Математика: основы 2 (level=1, COMMON+UNCOMMON) ────────

        WordEntity(id = 134401, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶפֶס", transliteration = "efes", translation = "ноль"),

        WordEntity(id = 134402, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶחָד", transliteration = "ekhad", translation = "один"),

        WordEntity(id = 134403, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "שְׁנַיִם", transliteration = "shnayim", translation = "два"),

        WordEntity(id = 134404, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "מֵאָה", transliteration = "mea", translation = "сто"),

        WordEntity(id = 134405, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶלֶף", transliteration = "elef", translation = "тысяча"),

        WordEntity(id = 134406, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "מִסְפָּר", transliteration = "mispar", translation = "число"),

        WordEntity(id = 134407, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "חִבּוּר", transliteration = "hibur", translation = "сложение"),

        WordEntity(id = 134408, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "מִינוּס", transliteration = "minus", translation = "минус"),

        WordEntity(id = 134409, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "כָּפוּל", transliteration = "kaful", translation = "умножить, умноженное на"),

        WordEntity(id = 134410, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "מְרוּבָּע", transliteration = "meruva", translation = "квадрат (фигура)"),

        WordEntity(id = 134411, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "עִגּוּל", transliteration = "igul", translation = "круг"),

        WordEntity(id = 134412, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "מְשֻׁלָּשׁ", transliteration = "meshulash", translation = "треугольник"),

        WordEntity(id = 134413, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "קַו", transliteration = "kav", translation = "линия"),

        WordEntity(id = 134414, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "נְקוּדָה", transliteration = "nekuda", translation = "точка"),

        WordEntity(id = 134415, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "זָוִית", transliteration = "zavit", translation = "угол"),

        WordEntity(id = 134416, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "אֹרֶךְ", transliteration = "orekh", translation = "длина"),

        WordEntity(id = 134417, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "רֹחַב", transliteration = "rokhav", translation = "ширина"),

        WordEntity(id = 134418, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "גֹּבַהּ", transliteration = "govah", translation = "высота"),

        WordEntity(id = 134419, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "לְחַלֵּק", transliteration = "lekhalek", translation = "делить"),

        WordEntity(id = 134420, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "תוֹצָאָה", transliteration = "totsa'a", translation = "результат, ответ"),

        WordEntity(id = 134421, setId = 1344, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶיקֵּף", transliteration = "heikef", translation = "периметр / длина окружности"),

        WordEntity(id = 134422, setId = 1344, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שֶׁטַח", transliteration = "shetakh", translation = "площадь (фигуры)"),

        WordEntity(id = 134423, setId = 1344, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נְפַח", transliteration = "nefakh", translation = "объём"),

        WordEntity(id = 134424, setId = 1344, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִסְפָּר שָׁלֵם", transliteration = "mispar shalem", translation = "целое число"),

        WordEntity(id = 134425, setId = 1344, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שְׁבָרִים", transliteration = "shvarim", translation = "дроби"),

        // ── Set 1345: Математика: продвинутый (level=2, UNCOMMON+RARE) ────────

        WordEntity(id = 134501, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּרָף", transliteration = "graf", translation = "граф, график"),

        WordEntity(id = 134502, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צִיר", transliteration = "tsir", translation = "ось (координат)"),

        WordEntity(id = 134503, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נוּסְחָה", transliteration = "nuskha", translation = "формула"),

        WordEntity(id = 134504, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַקְדֵּם", transliteration = "makdem", translation = "коэффициент"),

        WordEntity(id = 134505, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֶזְקָה", transliteration = "khezka", translation = "степень (2³)"),

        WordEntity(id = 134506, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שֹׁרֶשׁ רִבּוּעִי", transliteration = "shoresh ribui", translation = "квадратный корень"),

        WordEntity(id = 134507, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פוּנְקְצִיָּה", transliteration = "funktsiya", translation = "функция"),

        WordEntity(id = 134508, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִשְׁתַּנֶּה", transliteration = "mishtane", translation = "переменная"),

        WordEntity(id = 134509, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְבוּעַ", transliteration = "kvua", translation = "константа, постоянная"),

        WordEntity(id = 134510, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַעֲרֶכֶת צִירִים", transliteration = "ma'arekhet tsirim", translation = "система координат"),

        WordEntity(id = 134511, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שִׁפּוּעַ", transliteration = "shipua", translation = "наклон, угловой коэффициент"),

        WordEntity(id = 134512, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִי-שָׁוְיוֹן", transliteration = "i-shivyon", translation = "неравенство"),

        WordEntity(id = 134513, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְלַבֵּן", transliteration = "melaben", translation = "прямоугольник"),

        WordEntity(id = 134514, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זָוִית יְשָׁרָה", transliteration = "zavit yeshara", translation = "прямой угол (90°)"),

        WordEntity(id = 134515, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רָדִיּוּס", transliteration = "radiyus", translation = "радиус"),

        WordEntity(id = 134516, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קֹטֶר", transliteration = "koter", translation = "диаметр"),

        WordEntity(id = 134517, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְעָגָל", transliteration = "me'agal", translation = "окружность"),

        WordEntity(id = 134518, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טְרָפֶּז", transliteration = "trapes", translation = "трапеция"),

        WordEntity(id = 134519, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְעוּיָן", transliteration = "me'uyan", translation = "ромб"),

        WordEntity(id = 134520, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "פָּרָבּוֹלָה", transliteration = "parabola", translation = "парабола"),

        WordEntity(id = 134521, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "אֶלִיפְּסָה", transliteration = "elipsa", translation = "эллипс"),

        WordEntity(id = 134522, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "לוֹגָרִיתְם", transliteration = "logaritm", translation = "логарифм"),

        WordEntity(id = 134523, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "אֶקְסְפּוֹנֶנְט", transliteration = "eksponent", translation = "показатель степени, экспонента"),

        WordEntity(id = 134524, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "פּוֹלִינוֹם", transliteration = "polinom", translation = "многочлен"),

        WordEntity(id = 134525, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "אֲסִימְפְּטוֹטָה", transliteration = "asimptota", translation = "асимптота"),

        // ── Set 1346: Математика: углублённый (level=3, RARE+EPIC) ───────────

        WordEntity(id = 134601, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "סִינוּס", transliteration = "sinus", translation = "синус"),

        WordEntity(id = 134602, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "קוֹסִינוּס", transliteration = "kosinus", translation = "косинус"),

        WordEntity(id = 134603, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "טַנְגֶּנְס", transliteration = "tangens", translation = "тангенс"),

        WordEntity(id = 134604, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "וֶקְטוֹר", transliteration = "vektor", translation = "вектор"),

        WordEntity(id = 134605, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "מַטְרִיצָה", transliteration = "matritsa", translation = "матрица"),

        WordEntity(id = 134606, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "גְּבוּל", transliteration = "gvul", translation = "предел (limit)"),

        WordEntity(id = 134607, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "נְגִיזָה", transliteration = "negiza", translation = "производная"),

        WordEntity(id = 134608, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "אִינְטֶגְרָל", transliteration = "integral", translation = "интеграл"),

        WordEntity(id = 134609, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "הִסְתַּבְּרוּת", transliteration = "histabrut", translation = "вероятность"),

        WordEntity(id = 134610, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "סְטָטִיסְטִיקָה", transliteration = "statistika", translation = "статистика"),

        WordEntity(id = 134611, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "מֵיצָע", transliteration = "meitsav", translation = "среднее значение"),

        WordEntity(id = 134612, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "חֲצִיוֹן", transliteration = "khatsyon", translation = "медиана"),

        WordEntity(id = 134613, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "שׁוּנוּת", transliteration = "shunit", translation = "дисперсия"),

        WordEntity(id = 134614, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "סְטִיַּת תֶּקֶן", transliteration = "stiyat taken", translation = "стандартное отклонение"),

        WordEntity(id = 134615, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "פִּיזּוּר", transliteration = "pizur", translation = "распределение"),

        WordEntity(id = 134616, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "מִשְׁוָאָה דִּיפֶרֶנְצִיָאלִית", transliteration = "mishvaa diferentsialit", translation = "дифференциальное уравнение"),

        WordEntity(id = 134617, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "גֵּיאוֹמֶטְרִיָּה אֲנָלִיטִית", transliteration = "geometriya analitit", translation = "аналитическая геометрия"),

        WordEntity(id = 134618, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "קוֹאוֹרְדִינָטוֹת פּוֹלָרִיּוֹת", transliteration = "koordinatot polariyot", translation = "полярные координаты"),

        WordEntity(id = 134619, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "חֶשְׁבּוֹן דִּיפֶרֶנְצִיָאלִי", transliteration = "kheshbon diferentsiali", translation = "дифференциальное исчисление"),

        WordEntity(id = 134620, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "חֶשְׁבּוֹן אִינְטֶגְרָלִי", transliteration = "kheshbon integrali", translation = "интегральное исчисление"),

        WordEntity(id = 134621, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "מִסְפָּרִים מְדוּמִּים", transliteration = "misparim meduмim", translation = "комплексные числа"),

        WordEntity(id = 134622, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "טוֹר אִינְסוֹפִי", transliteration = "tor insofi", translation = "бесконечный ряд"),

        WordEntity(id = 134623, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "הִתְכַּנְּסוּת", transliteration = "hitkansut", translation = "сходимость (ряда)"),

        WordEntity(id = 134624, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "מֶרְחָב רַב-מִמְדִּי", transliteration = "merkhav rav-mimdi", translation = "многомерное пространство"),

        WordEntity(id = 134625, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "מֶשֶׁק וֶקְטוֹרִי", transliteration = "meshek vektori", translation = "векторное произведение"),

        // ── Set 1347: Математика: профессиональный (level=4, EPIC+LEGENDARY) ──

        WordEntity(id = 134701, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "תֶּאוֹרֵם", transliteration = "te'orem", translation = "теорема"),

        WordEntity(id = 134702, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "הוֹכָחָה", transliteration = "hokhakha", translation = "доказательство"),

        WordEntity(id = 134703, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "אַקְסִיוֹמָה", transliteration = "aksioma", translation = "аксиома"),

        WordEntity(id = 134704, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "לֶמָּה", transliteration = "lema", translation = "лемма"),

        WordEntity(id = 134705, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "מֶרְחָב וֶקְטוֹרִי", transliteration = "merkhav vektori", translation = "векторное пространство"),

        WordEntity(id = 134706, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "עֶרֶךְ עַצְמִי", transliteration = "erekh atsmi", translation = "собственное значение (eigenvalue)"),

        WordEntity(id = 134707, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "וֶקְטוֹר עַצְמִי", transliteration = "vektor atsmi", translation = "собственный вектор"),

        WordEntity(id = 134708, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "דֶּטֶרְמִינַנְטָה", transliteration = "determinanta", translation = "определитель матрицы"),

        WordEntity(id = 134709, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "טְרַנְסְפוֹרְמַצְיָה לִינֵיאָרִית", transliteration = "transformatsiya lineari", translation = "линейное преобразование"),

        WordEntity(id = 134710, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "אוֹרְתוֹגוֹנַלִיּוּת", transliteration = "ortogonaliut", translation = "ортогональность"),

        WordEntity(id = 134711, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "הִתְפַּלְּגוּת נוֹרְמָלִית", transliteration = "hitpallegut normalit", translation = "нормальное распределение"),

        WordEntity(id = 134712, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "בְּדִיקַת הַשְׁעָרָה", transliteration = "bdikat hasha'ara", translation = "проверка гипотезы"),

        WordEntity(id = 134713, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "רָוַח בִּיטָּחוֹן", transliteration = "ravakh bitakhon", translation = "доверительный интервал"),

        WordEntity(id = 134714, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "רֶגְרֶסְיָה", transliteration = "regressiya", translation = "регрессия"),

        WordEntity(id = 134715, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "מְתַאֵם", transliteration = "meta'em", translation = "коэффициент корреляции"),

        WordEntity(id = 134716, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "תּוֹרַת הַסְּתָבְרוּת", transliteration = "torat hahistabrut", translation = "теория вероятностей"),

        WordEntity(id = 134717, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "מַדְרֵגַת מַטְרִיצָה", transliteration = "madregat matritsa", translation = "ранг матрицы"),

        WordEntity(id = 134718, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "טוֹר פוּרְיֶה", transliteration = "tor Furye", translation = "ряд Фурье"),

        WordEntity(id = 134719, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "טְרַנְסְפוֹרְם לַפְּלַס", transliteration = "transform Laplas", translation = "преобразование Лапласа"),

        WordEntity(id = 134720, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הִתְפַּלְּגוּת פּוּאָסוֹן", transliteration = "hitpallegut Puason", translation = "распределение Пуассона"),

        WordEntity(id = 134721, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶרְחָב הִילְבֶּרְט", transliteration = "merkhav Hilbert", translation = "пространство Гильберта"),

        WordEntity(id = 134722, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "חֶשְׁבּוֹן וַרִיַצְיוֹנִי", transliteration = "kheshbon variatsioni", translation = "вариационное исчисление"),

        WordEntity(id = 134723, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תֶּאוֹרֵם סְטוֹקְס", transliteration = "te'orem Stoks", translation = "теорема Стокса"),

        WordEntity(id = 134724, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "טוֹפּוֹלוֹגִיָּה", transliteration = "topologiya", translation = "топология"),

        WordEntity(id = 134725, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶרְחָב מֶטְרִי", transliteration = "merkhav metri", translation = "метрическое пространство"),

        // ── Set 1348: Математика: носитель языка (level=5, LEGENDARY) ─────────

        WordEntity(id = 134801, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תּוֹרַת הַקְּבוּצוֹת", transliteration = "torat hakevutsot", translation = "теория множеств"),

        WordEntity(id = 134802, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תּוֹרַת הַמִּסְפָּרִים", transliteration = "torat hamisparim", translation = "теория чисел"),

        WordEntity(id = 134803, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אַלְגֶּבְּרָה אַבְסְטְרַקְטִית", transliteration = "algebra abstraktit", translation = "абстрактная алгебра"),

        WordEntity(id = 134804, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תּוֹרַת הַקְּבוּצוֹת הָאֵינְסוֹפִיּוֹת", transliteration = "torat hakevutsot ha'insofiуот", translation = "теория бесконечных множеств"),

        WordEntity(id = 134805, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "חֲבוּרָה", transliteration = "khavura", translation = "группа (алгебраическая структура)"),

        WordEntity(id = 134806, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "טַבַּעַת", transliteration = "taba'at", translation = "кольцо (алгебраическая структура)"),

        WordEntity(id = 134807, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שָׂדֶה", transliteration = "sade", translation = "поле (алгебраическая структура)"),

        WordEntity(id = 134808, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הוֹמוֹמוֹרְפִיזְם", transliteration = "homomorfizm", translation = "гомоморфизм"),

        WordEntity(id = 134809, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אִיזוֹמוֹרְפִיזְם", transliteration = "izomorfizm", translation = "изоморфизм"),

        WordEntity(id = 134810, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מַנִּיפוֹלְד", transliteration = "manifold", translation = "многообразие (топологическое)"),

        WordEntity(id = 134811, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מַרְחָב טוֹפּוֹלוֹגִי", transliteration = "merkhav topologi", translation = "топологическое пространство"),

        WordEntity(id = 134812, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "קְטֵגוֹרְיָה", transliteration = "kategoriya", translation = "категория (теория категорий)"),

        WordEntity(id = 134813, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פוּנְקְטוֹר", transliteration = "funktor", translation = "функтор"),

        WordEntity(id = 134814, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מִסְפָּרִים פְּרִימִים", transliteration = "misparim primim", translation = "простые числа"),

        WordEntity(id = 134815, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הַשְׁעָרַת רִימַן", transliteration = "hasha'arat Riman", translation = "гипотеза Римана"),

        WordEntity(id = 134816, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פוּנְקְצִיַּת זֶטָא", transliteration = "funktsiyat zeta", translation = "дзета-функция"),

        WordEntity(id = 134817, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "לוֹגִיקָה מַתֶּמָטִית", transliteration = "logika matematit", translation = "математическая логика"),

        WordEntity(id = 134818, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שְׁלֵמוּת פוֹרְמָלִית", transliteration = "shlemut formalit", translation = "полнота (формальной системы)"),

        WordEntity(id = 134819, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תֶּאוֹרֵם אִי-הַשְׁלֵמוּת", transliteration = "te'orem i-hashlemut", translation = "теорема о неполноте (Гёдель)"),

        WordEntity(id = 134820, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הִנָּחַת הַקוֹנְטִינוּוּם", transliteration = "hinakhat hakontinuum", translation = "континуум-гипотеза"),

        WordEntity(id = 134821, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶרְחָב בָּנַח", transliteration = "merkhav Banakh", translation = "банахово пространство"),

        WordEntity(id = 134822, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מַשְׁוָאוֹת נָבְיֵה-סְטוֹקְס", transliteration = "mashvaot Navye-Stoks", translation = "уравнения Навье-Стокса"),

        WordEntity(id = 134823, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "גֵּאוֹמֶטְרִיָּה לֹא-אֶוְקְלִידִית", transliteration = "geometriya lo-evklidit", translation = "неевклидова геометрия"),

        WordEntity(id = 134824, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תּוֹרַת הַמִּשְׂחָקִים", transliteration = "torat hamiskhakim", translation = "теория игр"),

        WordEntity(id = 134825, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "כּוֹשֶׁר הִמָּנוּת", transliteration = "kosher himаnut", translation = "вычислимость (computability)"),
    )
}
