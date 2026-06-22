package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch61 {

    val sets: List<WordSetEntity> get() = listOf(

        WordSetEntity(
            id = 1344, languagePair = "he-ru", orderIndex = 1344,
            name = "Математика",
            description = "Фигуры, измерения, числа и операции",
            topic = "Математика",
            level = 1),

        WordSetEntity(
            id = 1345, languagePair = "he-ru", orderIndex = 1345,
            name = "Математика",
            description = "Алгебра, координатная геометрия, функции",
            topic = "Математика",
            level = 2),

        WordSetEntity(
            id = 1346, languagePair = "he-ru", orderIndex = 1346,
            name = "Математика",
            description = "Тригонометрия, векторы, вероятность, начала анализа",
            topic = "Математика",
            level = 3),

        WordSetEntity(
            id = 1347, languagePair = "he-ru", orderIndex = 1347,
            name = "Математика",
            description = "Линейная алгебра, теория вероятностей, доказательства",
            topic = "Математика",
            level = 4),

        WordSetEntity(
            id = 1348, languagePair = "he-ru", orderIndex = 1348,
            name = "Математика",
            description = "Абстрактная алгебра, топология, теория чисел",
            topic = "Математика",
            level = 5),
    )

    val words: List<WordEntity> get() = listOf(

        // ── Set 1344: Математика: основы 2 (level=1, COMMON+UNCOMMON) ────────

        WordEntity(id = 134401, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶפֶס", translation = "ноль"),

        WordEntity(id = 134402, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶחָד", translation = "один"),

        WordEntity(id = 134403, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "שְׁנַיִם", translation = "два"),

        WordEntity(id = 134404, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "מֵאָה", translation = "сто"),

        WordEntity(id = 134405, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶלֶף", translation = "тысяча"),

        WordEntity(id = 134406, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "מִסְפָּר", translation = "число"),

        WordEntity(id = 134407, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "חִבּוּר", translation = "сложение"),

        WordEntity(id = 134408, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "מִינוּס", translation = "минус"),

        WordEntity(id = 134409, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "כָּפוּל", translation = "умножить, умноженное на"),

        WordEntity(id = 134410, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "מְרוּבָּע", translation = "квадрат (фигура)"),

        WordEntity(id = 134411, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "עִגּוּל", translation = "круг"),

        WordEntity(id = 134412, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "מְשֻׁלָּשׁ", translation = "треугольник"),

        WordEntity(id = 134413, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "קַו", translation = "линия"),

        WordEntity(id = 134414, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "נְקוּדָה", translation = "точка"),

        WordEntity(id = 134415, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "זָוִית", translation = "угол"),

        WordEntity(id = 134416, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "אֹרֶךְ", translation = "длина"),

        WordEntity(id = 134417, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "רֹחַב", translation = "ширина"),

        WordEntity(id = 134418, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "גֹּבַהּ", translation = "высота"),

        WordEntity(id = 134419, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "לְחַלֵּק", translation = "делить"),

        WordEntity(id = 134420, setId = 1344, languagePair = "he-ru", rarity = "COMMON",
            original = "תוֹצָאָה", translation = "результат, ответ"),

        WordEntity(id = 134421, setId = 1344, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶיקֵּף", translation = "периметр / длина окружности"),

        WordEntity(id = 134422, setId = 1344, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שֶׁטַח", translation = "площадь (фигуры)"),

        WordEntity(id = 134423, setId = 1344, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נְפַח", translation = "объём"),

        WordEntity(id = 134424, setId = 1344, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִסְפָּר שָׁלֵם", translation = "целое число"),

        WordEntity(id = 134425, setId = 1344, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שְׁבָרִים", translation = "дроби"),

        // ── Set 1345: Математика: продвинутый (level=2, UNCOMMON+RARE) ────────

        WordEntity(id = 134501, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּרָף", translation = "граф, график"),

        WordEntity(id = 134502, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צִיר", translation = "ось (координат)"),

        WordEntity(id = 134503, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נוּסְחָה", translation = "формула"),

        WordEntity(id = 134504, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְקַדֵּם", translation = "коэффициент"),

        WordEntity(id = 134505, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֶזְקָה", translation = "степень (2³)"),

        WordEntity(id = 134506, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שֹׁרֶשׁ רִבּוּעִי", translation = "квадратный корень"),

        WordEntity(id = 134507, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פוּנְקְצִיָּה", translation = "функция"),

        WordEntity(id = 134508, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִשְׁתַּנֶּה", translation = "переменная"),

        WordEntity(id = 134509, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְבוּעַ", translation = "константа, постоянная"),

        WordEntity(id = 134510, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַעֲרֶכֶת צִירִים", translation = "система координат"),

        WordEntity(id = 134511, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שִׁפּוּעַ", translation = "наклон, угловой коэффициент"),

        WordEntity(id = 134512, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִי-שִׁוְיוֹן", translation = "неравенство"),

        WordEntity(id = 134513, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְלַבֵּן", translation = "прямоугольник"),

        WordEntity(id = 134514, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זָוִית יְשָׁרָה", translation = "прямой угол (90°)"),

        WordEntity(id = 134515, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רָדִיּוּס", translation = "радиус"),

        WordEntity(id = 134516, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קֹטֶר", translation = "диаметр"),

        WordEntity(id = 134517, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְעָגָל", translation = "окружность"),

        WordEntity(id = 134518, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טְרָפֶּז", translation = "трапеция"),

        WordEntity(id = 134519, setId = 1345, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְעוּיָן", translation = "ромб"),

        WordEntity(id = 134520, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "פָּרָבּוֹלָה", translation = "парабола"),

        WordEntity(id = 134521, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "אֶלִיפְּסָה", translation = "эллипс"),

        WordEntity(id = 134522, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "לוֹגָרִיתְם", translation = "логарифм"),

        WordEntity(id = 134523, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "אֶקְסְפּוֹנֶנְט", translation = "показатель степени, экспонента"),

        WordEntity(id = 134524, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "פּוֹלִינוֹם", translation = "многочлен"),

        WordEntity(id = 134525, setId = 1345, languagePair = "he-ru", rarity = "RARE",
            original = "אֲסִימְפְּטוֹטָה", translation = "асимптота"),

        // ── Set 1346: Математика: углублённый (level=3, RARE+EPIC) ───────────

        WordEntity(id = 134601, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "סִינוּס", translation = "синус"),

        WordEntity(id = 134602, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "קוֹסִינוּס", translation = "косинус"),

        WordEntity(id = 134603, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "טַנְגֶּנְס", translation = "тангенс"),

        WordEntity(id = 134604, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "וֶקְטוֹר", translation = "вектор"),

        WordEntity(id = 134605, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "מַטְרִיצָה", translation = "матрица"),

        WordEntity(id = 134606, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "גְּבוּל", translation = "предел (limit)"),

        WordEntity(id = 134607, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "נְגִיזָה", translation = "производная"),

        WordEntity(id = 134608, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "אִינְטֶגְרָל", translation = "интеграл"),

        WordEntity(id = 134609, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "הִסְתַּבְּרוּת", translation = "вероятность"),

        WordEntity(id = 134610, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "סְטָטִיסְטִיקָה", translation = "статистика"),

        WordEntity(id = 134611, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "מֵיצָע", translation = "среднее значение"),

        WordEntity(id = 134612, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "חֶצְיוֹן", translation = "медиана"),

        WordEntity(id = 134613, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "שׁוּנוּת", translation = "дисперсия"),

        WordEntity(id = 134614, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "סְטִיַּת תֶּקֶן", translation = "стандартное отклонение"),

        WordEntity(id = 134615, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "פִּיזּוּר", translation = "распределение"),

        WordEntity(id = 134616, setId = 1346, languagePair = "he-ru", rarity = "RARE",
            original = "מִשְׁוָאָה דִּיפֶרֶנְצִיָאלִית", translation = "дифференциальное уравнение"),

        WordEntity(id = 134617, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "גֵּיאוֹמֶטְרִיָּה אֲנָלִיטִית", translation = "аналитическая геометрия"),

        WordEntity(id = 134618, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "קוֹאוֹרְדִינָטוֹת פּוֹלָרִיּוֹת", translation = "полярные координаты"),

        WordEntity(id = 134619, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "חֶשְׁבּוֹן דִּיפֶרֶנְצִיָאלִי", translation = "дифференциальное исчисление"),

        WordEntity(id = 134620, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "חֶשְׁבּוֹן אִינְטֶגְרָלִי", translation = "интегральное исчисление"),

        WordEntity(id = 134621, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "מִסְפָּרִים מְדוּמִּים", translation = "комплексные числа"),

        WordEntity(id = 134622, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "טוֹר אִינְסוֹפִי", translation = "бесконечный ряд"),

        WordEntity(id = 134623, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "הִתְכַּנְּסוּת", translation = "сходимость (ряда)"),

        WordEntity(id = 134624, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "מֶרְחָב רַב-מִמְדִּי", translation = "многомерное пространство"),

        WordEntity(id = 134625, setId = 1346, languagePair = "he-ru", rarity = "EPIC",
            original = "מֶשֶׁק וֶקְטוֹרִי", translation = "векторное произведение"),

        // ── Set 1347: Математика: профессиональный (level=4, EPIC+LEGENDARY) ──

        WordEntity(id = 134701, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "תֶּאוֹרֵם", translation = "теорема"),

        WordEntity(id = 134702, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "הוֹכָחָה", translation = "доказательство"),

        WordEntity(id = 134703, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "אַקְסִיוֹמָה", translation = "аксиома"),

        WordEntity(id = 134704, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "לֶמָּה", translation = "лемма"),

        WordEntity(id = 134705, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "מֶרְחָב וֶקְטוֹרִי", translation = "векторное пространство"),

        WordEntity(id = 134706, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "עֶרֶךְ עַצְמִי", translation = "собственное значение (eigenvalue)"),

        WordEntity(id = 134707, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "וֶקְטוֹר עַצְמִי", translation = "собственный вектор"),

        WordEntity(id = 134708, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "דֶּטֶרְמִינַנְטָה", translation = "определитель матрицы"),

        WordEntity(id = 134709, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "טְרַנְסְפוֹרְמַצְיָה לִינֵיאָרִית", translation = "линейное преобразование"),

        WordEntity(id = 134710, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "אוֹרְתוֹגוֹנַלִיּוּת", translation = "ортогональность"),

        WordEntity(id = 134711, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "הִתְפַּלְּגוּת נוֹרְמָלִית", translation = "нормальное распределение"),

        WordEntity(id = 134712, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "בְּדִיקַת הַשְׁעָרָה", translation = "проверка гипотезы"),

        WordEntity(id = 134713, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "רָוַח בִּיטָּחוֹן", translation = "доверительный интервал"),

        WordEntity(id = 134714, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "רֶגְרֶסְיָה", translation = "регрессия"),

        WordEntity(id = 134715, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "מְתַאֵם", translation = "коэффициент корреляции"),

        WordEntity(id = 134716, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "תּוֹרַת הַסְּתָבְרוּת", translation = "теория вероятностей"),

        WordEntity(id = 134717, setId = 1347, languagePair = "he-ru", rarity = "EPIC",
            original = "מַדְרֵגַת מַטְרִיצָה", translation = "ранг матрицы"),

        WordEntity(id = 134718, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "טוֹר פוּרְיֶה", translation = "ряд Фурье"),

        WordEntity(id = 134719, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "טְרַנְסְפוֹרְם לַפְּלַס", translation = "преобразование Лапласа"),

        WordEntity(id = 134720, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הִתְפַּלְּגוּת פּוּאָסוֹן", translation = "распределение Пуассона"),

        WordEntity(id = 134721, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶרְחָב הִילְבֶּרְט", translation = "пространство Гильберта"),

        WordEntity(id = 134722, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "חֶשְׁבּוֹן וַרִיַצְיוֹנִי", translation = "вариационное исчисление"),

        WordEntity(id = 134723, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תֶּאוֹרֵם סְטוֹקְס", translation = "теорема Стокса"),

        WordEntity(id = 134724, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "טוֹפּוֹלוֹגִיָּה", translation = "топология"),

        WordEntity(id = 134725, setId = 1347, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶרְחָב מֶטְרִי", translation = "метрическое пространство"),

        // ── Set 1348: Математика: носитель языка (level=5, LEGENDARY) ─────────

        WordEntity(id = 134801, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תּוֹרַת הַקְּבוּצוֹת", translation = "теория множеств"),

        WordEntity(id = 134802, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תּוֹרַת הַמִּסְפָּרִים", translation = "теория чисел"),

        WordEntity(id = 134803, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אַלְגֶּבְּרָה אַבְסְטְרַקְטִית", translation = "абстрактная алгебра"),

        WordEntity(id = 134804, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תּוֹרַת הַקְּבוּצוֹת הָאֵינְסוֹפִיּוֹת", translation = "теория бесконечных множеств"),

        WordEntity(id = 134805, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "חֲבוּרָה", translation = "группа (алгебраическая структура)"),

        WordEntity(id = 134806, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "טַבַּעַת", translation = "кольцо (алгебраическая структура)"),

        WordEntity(id = 134807, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שָׂדֶה", translation = "поле (алгебраическая структура)"),

        WordEntity(id = 134808, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הוֹמוֹמוֹרְפִיזְם", translation = "гомоморфизм"),

        WordEntity(id = 134809, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אִיזוֹמוֹרְפִיזְם", translation = "изоморфизм"),

        WordEntity(id = 134810, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מַנִּיפוֹלְד", translation = "многообразие (топологическое)"),

        WordEntity(id = 134811, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מַרְחָב טוֹפּוֹלוֹגִי", translation = "топологическое пространство"),

        WordEntity(id = 134812, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "קָטֵגוֹרְיָה", translation = "категория (теория категорий)"),

        WordEntity(id = 134813, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פוּנְקְטוֹר", translation = "функтор"),

        WordEntity(id = 134814, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מִסְפָּרִים פְּרִימִים", translation = "простые числа"),

        WordEntity(id = 134815, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הַשְׁעָרַת רִימַן", translation = "гипотеза Римана"),

        WordEntity(id = 134816, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פוּנְקְצִיַּת זֶטָא", translation = "дзета-функция"),

        WordEntity(id = 134817, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "לוֹגִיקָה מַתֶּמָטִית", translation = "математическая логика"),

        WordEntity(id = 134818, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שְׁלֵמוּת פוֹרְמָלִית", translation = "полнота (формальной системы)"),

        WordEntity(id = 134819, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תֶּאוֹרֵם אִי-הַשְׁלֵמוּת", translation = "теорема о неполноте (Гёдель)"),

        WordEntity(id = 134820, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הִנָּחַת הַקוֹנְטִינוּוּם", translation = "континуум-гипотеза"),

        WordEntity(id = 134821, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶרְחָב בָּנַח", translation = "банахово пространство"),

        WordEntity(id = 134822, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מַשְׁוָאוֹת נָבְיֵה-סְטוֹקְס", translation = "уравнения Навье-Стокса"),

        WordEntity(id = 134823, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "גֵּאוֹמֶטְרִיָּה לֹא-אֶוְקְלִידִית", translation = "неевклидова геометрия"),

        WordEntity(id = 134824, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תּוֹרַת הַמִּשְׂחָקִים", translation = "теория игр"),

        WordEntity(id = 134825, setId = 1348, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "כּוֹשֶׁר הִמָּנוּת", translation = "вычислимость (computability)"),
    )
}
