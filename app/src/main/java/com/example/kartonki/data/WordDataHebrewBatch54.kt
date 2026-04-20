package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch54 {

    val sets: List<WordSetEntity> get() = listOf(

        WordSetEntity(
            id = 1305, languagePair = "he-ru", orderIndex = 1305,
            name = "Строительство: основы",
            description = "Базовые термины строительной индустрии Израиля",
            topic = "Строительство",
            level = 1),

        WordSetEntity(
            id = 1306, languagePair = "he-ru", orderIndex = 1306,
            name = "Строительство: углублённый",
            description = "Профессиональные строительные термины и документация",
            topic = "Строительство",
            level = 3),

        WordSetEntity(
            id = 1307, languagePair = "he-ru", orderIndex = 1307,
            name = "Строительство: профессиональный",
            description = "Высокопрофессиональные термины строительной отрасли",
            topic = "Строительство",
            level = 4),

        WordSetEntity(
            id = 1308, languagePair = "he-ru", orderIndex = 1308,
            name = "Строительство: профессиональный 2",
            description = "Архитектурно-инженерная документация и градостроительство",
            topic = "Строительство",
            level = 4),

        WordSetEntity(
            id = 1309, languagePair = "he-ru", orderIndex = 1309,
            name = "Строительство: носитель языка",
            description = "Академический дискурс: урбанистика, феноменология, деконструктивизм",
            topic = "Строительство",
            level = 5),
    )

    val words: List<WordEntity> get() = listOf(

        // ── Set 1305: Строительство: основы (level=1, COMMON+UNCOMMON) ────────────

        WordEntity(id = 130501, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "שֶׁלֶד בִּנְיָן", transliteration = "shelet binyan", translation = "каркас здания / несущая конструкция"),

        WordEntity(id = 130502, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "מֶחִיצָה", transliteration = "mekhitsa", translation = "перегородка"),

        WordEntity(id = 130503, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "רְצָפָה", transliteration = "ritspa", translation = "пол"),

        WordEntity(id = 130504, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹמֶר בִּינְיָן", transliteration = "khomer binyan", translation = "строительный материал"),

        WordEntity(id = 130505, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "גֶּג שָׁטוּחַ", transliteration = "gag shatuakh", translation = "плоская кровля"),

        WordEntity(id = 130506, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "גֶּרֶם מַדְרֵגוֹת", transliteration = "garem madregot", translation = "лестничный пролёт / марш лестницы"),

        WordEntity(id = 130507, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "נְחֹשֶׁת", transliteration = "n'khoshet", translation = "медь / медное соединение"),

        WordEntity(id = 130508, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "מִבְנֵה פְּלָדָה", transliteration = "mibneh p'lada", translation = "стальная конструкция"),

        WordEntity(id = 130509, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "עַמּוּד תּוֹמֵךְ", transliteration = "amud tomekh", translation = "несущая колонна / опорная стойка"),

        WordEntity(id = 130510, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "תּוֹשָׁבֶת", transliteration = "toshevet", translation = "кронштейн / крепёж"),

        WordEntity(id = 130511, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "גֶּבֶשׁ", transliteration = "gevesh", translation = "гипс / штукатурка"),

        WordEntity(id = 130512, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶבֶן גִּיר", transliteration = "even gir", translation = "известняк / известняковый камень"),

        WordEntity(id = 130513, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "מֶלֶט", transliteration = "melet", translation = "цемент"),

        WordEntity(id = 130514, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "עָפָר", transliteration = "afar", translation = "грунт / земля"),

        WordEntity(id = 130515, setId = 1305, languagePair = "he-ru", rarity = "COMMON",
            original = "אוּמָן", transliteration = "uman", translation = "мастер / ремесленник"),

        WordEntity(id = 130516, setId = 1305, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קַבְּלָן", transliteration = "kablan", translation = "прораб / подрядчик"),

        WordEntity(id = 130517, setId = 1305, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲגוּרָן", transliteration = "aguran", translation = "подъёмный кран"),

        WordEntity(id = 130518, setId = 1305, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּיגּוּם", transliteration = "pigum", translation = "строительные леса"),

        WordEntity(id = 130519, setId = 1305, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּעָלָה", transliteration = "te'ala", translation = "траншея / канава"),

        WordEntity(id = 130520, setId = 1305, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יְסוֹדוֹת", transliteration = "yesodot", translation = "фундамент / основание"),

        WordEntity(id = 130521, setId = 1305, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רִתּוּךְ", transliteration = "ritukh", translation = "сварка"),

        WordEntity(id = 130522, setId = 1305, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שַׂרְבִיט", transliteration = "sarbit", translation = "металлический прут / арматурный стержень"),

        WordEntity(id = 130523, setId = 1305, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חִיוּט חַשְׁמַל", transliteration = "khiyut khashmal", translation = "электропроводка"),

        WordEntity(id = 130524, setId = 1305, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תָּכְנִית הַנְדָּסִית", transliteration = "takhnit handasit", translation = "инженерный чертёж / технический план"),

        WordEntity(id = 130525, setId = 1305, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּכנִית בְּנִיָּה", transliteration = "tkhnit bniya", translation = "проект строительства"),

        // ── Set 1306: Строительство: продвинутый (level=2, UNCOMMON+RARE) ────────────

        WordEntity(id = 130601, setId = 1306, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תָּכְנִית", transliteration = "takhnit", translation = "чертёж / план"),

        WordEntity(id = 130602, setId = 1306, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּרוֹיֶקְט בִּנְיָן", transliteration = "proyekt binyan", translation = "проект здания"),

        WordEntity(id = 130603, setId = 1306, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַרְמָטוּרָה", transliteration = "armatura", translation = "арматура / стальной каркас"),

        WordEntity(id = 130604, setId = 1306, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּבְנִית יְצִיקָה", transliteration = "tavnit yetzika", translation = "опалубка"),

        WordEntity(id = 130605, setId = 1306, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חִפּוּי", transliteration = "khipuy", translation = "облицовка / обшивка"),

        WordEntity(id = 130606, setId = 1306, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בִּידוּד", transliteration = "bidud", translation = "изоляция / утепление"),

        WordEntity(id = 130607, setId = 1306, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַעֲרֶכֶת אֲוִירָה", transliteration = "ma'arekhet avira", translation = "вентиляционная система"),

        WordEntity(id = 130608, setId = 1306, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טַיָּח", transliteration = "tayakh", translation = "штукатур"),

        WordEntity(id = 130609, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹטוֹקַד", transliteration = "AutoCAD", translation = "AutoCAD (программа проектирования)"),

        WordEntity(id = 130610, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "מִפְרָט טֶכְנִי", transliteration = "mifrat tekhni", translation = "техническая спецификация"),

        WordEntity(id = 130611, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "קַבְּלָן מִשְׁנֶה", transliteration = "kablan mishne", translation = "субподрядчик"),

        WordEntity(id = 130612, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "פִּקּוּחַ", transliteration = "pikuakh", translation = "инспекция / надзор"),

        WordEntity(id = 130613, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "בִּטָּחוֹן עֲבוֹדָה", transliteration = "bitakhon avoda", translation = "безопасность труда / охрана труда"),

        WordEntity(id = 130614, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "בַּנָּאי", transliteration = "banai", translation = "каменщик"),

        WordEntity(id = 130615, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "קְדִיחָה", transliteration = "kdikha", translation = "бурение / сверление"),

        WordEntity(id = 130616, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "מֵדָּדִי", transliteration = "medadi", translation = "геодезия / землемерие"),

        WordEntity(id = 130617, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "חוֹזֶה קְבָלָנוּת", transliteration = "khoze kabalanot", translation = "подрядный договор"),

        WordEntity(id = 130618, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "מְסִירַת פְּרוֹיֶקְט", transliteration = "mesirat proyekt", translation = "сдача объекта"),

        WordEntity(id = 130619, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "רְשִׁימַת לִיקּוּיִים", transliteration = "reshimat liku'im", translation = "дефектовка / список недоделок"),

        WordEntity(id = 130620, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "מַעֲרֶכֶת כִּבּוּי אֵשׁ", transliteration = "ma'arekhet kibuy esh", translation = "противопожарная система"),

        WordEntity(id = 130621, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "אִיטוּם מַיִם", transliteration = "atum mayim", translation = "гидроизоляция"),

        WordEntity(id = 130622, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "בִּידוּד אָקוּסְטִי", transliteration = "bidud akusti", translation = "звукоизоляция"),

        WordEntity(id = 130623, setId = 1306, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קוֹנְסְטְרוּקְצִיָּה נוֹשֵׂאת", transliteration = "konstruktsiya noset", translation = "несущая конструкция"),

        WordEntity(id = 130624, setId = 1306, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חוֹמְרֵי בִּנְיָן", transliteration = "khomrei binyan", translation = "строительные материалы"),

        WordEntity(id = 130625, setId = 1306, languagePair = "he-ru", rarity = "RARE",
            original = "תִּשְׁתִּית", transliteration = "tishtit", translation = "инфраструктура"),

        // ── Set 1307: Строительство: углублённый (level=3, RARE+EPIC) ────────────

        WordEntity(id = 130701, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "בֶּטוֹן מְזוּיָּן", transliteration = "beton mezuyan", translation = "армированный бетон / железобетон"),

        WordEntity(id = 130702, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "עֲמִידוּת רְעִידַת אֲדָמָה", transliteration = "amidut re'idat adama", translation = "сейсмостойкость"),

        WordEntity(id = 130703, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "תַּקְנוֹת בְּנִיָּה", transliteration = "takanot bniya", translation = "строительные нормы / строительный регламент"),

        WordEntity(id = 130704, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "מִידּוּל BIM", transliteration = "midul BIM", translation = "BIM-моделирование"),

        WordEntity(id = 130705, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "מַחֲזוֹר אֶפֶס", transliteration = "makhazor efes", translation = "нулевой цикл"),

        WordEntity(id = 130706, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "דְּחִיסַת קַרְקַע", transliteration = "dkhisat karka", translation = "консолидация грунта / уплотнение почвы"),

        WordEntity(id = 130707, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "כּוֹשֶׁר נְשִׂיאָה", transliteration = "kosher nesi'a", translation = "несущая способность"),

        WordEntity(id = 130708, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "סֶרֶן קְשִׁיחוּת", transliteration = "seren kshikhut", translation = "диафрагма жёсткости"),

        WordEntity(id = 130709, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "קוֹנְסְטְרוּקְצִיוֹת קְדוּמוֹת מְתוּחוֹת", transliteration = "konstruktsiyot kdumot metukot", translation = "преднапряжённые конструкции"),

        WordEntity(id = 130710, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "יְעִילוּת אֶנֶרְגֶטִית", transliteration = "ye'ilut energetit", translation = "энергоэффективность"),

        WordEntity(id = 130711, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "בַּיִת פַּסִיבִי", transliteration = "bayit pasivi", translation = "пассивный дом"),

        WordEntity(id = 130712, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "אַקוּסְטִיקַת מִבְנֶה", transliteration = "akustika mivne", translation = "акустика здания"),

        WordEntity(id = 130713, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "חֲוָוַת דַּעַת מְהַנְדֵּס", transliteration = "khavvat da'at mehandés", translation = "экспертиза проекта / инженерное заключение"),

        WordEntity(id = 130714, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "פִּקּוּחַ טֶכְנִי", transliteration = "pikuakh tekhni", translation = "технический надзор"),

        WordEntity(id = 130715, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "חָנְיוֹן תַּת-קַרְקָעִי", transliteration = "khanyon tat-karka'i", translation = "подземный паркинг"),

        WordEntity(id = 130716, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "חֲזִית מְאֻוְורֶרֶת", transliteration = "khazit me'uvveret", translation = "вентилируемый фасад / вентфасад"),

        WordEntity(id = 130717, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "גֶּשֶׁר תֶּרְמִי", transliteration = "gesher termi", translation = "тепловой мост"),

        WordEntity(id = 130718, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹמֶדֶן", transliteration = "omdan", translation = "смета / предварительная стоимостная оценка"),

        WordEntity(id = 130719, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "נֶאֱמָנוּת כְּסָפִים", transliteration = "ne'emanut kesafim", translation = "эскроу / счёт условного депонирования"),

        WordEntity(id = 130720, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "חֲתִימַת מְהַנְדֵּס", transliteration = "khatimat mehandés", translation = "подпись инженера / инженерное утверждение"),

        WordEntity(id = 130721, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "פְּנִים וְחוּץ", transliteration = "pnim ve-khutz", translation = "интерьер и экстерьер"),

        WordEntity(id = 130722, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "בְּדִיקַת קַרְקַע", transliteration = "bdikat karka", translation = "исследование грунта / геотехническая экспертиза"),

        WordEntity(id = 130723, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "תִּכְנוּן אַדְרִיכָלִי", transliteration = "tikhnun adrikali", translation = "архитектурное проектирование"),

        WordEntity(id = 130724, setId = 1307, languagePair = "he-ru", rarity = "EPIC",
            original = "אוֹפְטִימִיזַצְיַת מִבְנֶה", transliteration = "optimizatsyat mivne", translation = "оптимизация конструкции"),

        WordEntity(id = 130725, setId = 1307, languagePair = "he-ru", rarity = "RARE",
            original = "רֶגֶשׁ סֵיסְמִי", transliteration = "regesh seyismi", translation = "сейсмическая нагрузка"),

        // ── Set 1308: Строительство: профессиональный (level=4, EPIC+LEGENDARY) ────────────

        WordEntity(id = 130801, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "תִּיעוּד תִּכְנוּן עִירוֹנִי", transliteration = "ti'ud tikhnun ironi", translation = "градостроительная документация"),

        WordEntity(id = 130802, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "אִיזוּר שֶׁטַח", transliteration = "izur shétakh", translation = "зонирование территории"),

        WordEntity(id = 130803, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "עִירוֹנִיּוּת", transliteration = "ironiyut", translation = "урбанистика / градостроительство"),

        WordEntity(id = 130804, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "שִׁקּוּם מִבְנֵי מוֹרֶשֶׁת", transliteration = "shikum mivnei moreshet", translation = "реконструкция объектов культурного наследия"),

        WordEntity(id = 130805, setId = 1308, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מִיקְרוֹ-אִיזוּר סֵיסְמִי", transliteration = "mikro-izur seysmi", translation = "сейсмическое микрорайонирование"),

        WordEntity(id = 130806, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "בְּנִיָּה בַּת-קַיְּמָא", transliteration = "bniya bat-kayama", translation = "устойчивое строительство"),

        WordEntity(id = 130807, setId = 1308, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תְּעוּדַת LEED", transliteration = "te'udat LEED", translation = "LEED-сертификация"),

        WordEntity(id = 130808, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "תִּכְנוּן מְשׁוּלָּב", transliteration = "tikhnun meshulav", translation = "интегрированное проектирование"),

        WordEntity(id = 130809, setId = 1308, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מַחְזוֹר חַיִּים שֶׁל מִבְנֶה", transliteration = "makhzor khayim shel mivne", translation = "жизненный цикл здания"),

        WordEntity(id = 130810, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "כְּדָאִיּוּת כַּלְכָּלִית-טֶכְנִית", transliteration = "kdaiyut kalkalit-tekhniit", translation = "технико-экономическое обоснование"),

        WordEntity(id = 130811, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "תִּכְנוּן מֶרְחָבִי", transliteration = "tikhnun merkhavi", translation = "пространственное планирование"),

        WordEntity(id = 130812, setId = 1308, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תַּשְׁתִּית קְרִיטִית", transliteration = "tashtit kritit", translation = "критическая инфраструктура"),

        WordEntity(id = 130813, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "תַּמְרִיץ בְּנִיָּה", transliteration = "tamritz bniya", translation = "строительный стимул / льгота при строительстве"),

        WordEntity(id = 130814, setId = 1308, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פַּרְצֶלַּצְיָה", transliteration = "partsellatsya", translation = "парцелляция / разбивка на участки"),

        WordEntity(id = 130815, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "שִׁנּוּי יַעֲדוּ קַרְקַע", transliteration = "shinuy ya'ado karka", translation = "изменение целевого назначения земли"),

        WordEntity(id = 130816, setId = 1308, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מַעֲרֶכֶת גֵּאוֹגְרָפִית מֵידָע", transliteration = "ma'arekhet ge'ografit meida", translation = "геоинформационная система / ГИС"),

        WordEntity(id = 130817, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "נְדִידַת אֲדָמוֹת", transliteration = "ndidat adamot", translation = "оползень / смещение грунта"),

        WordEntity(id = 130818, setId = 1308, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הֶסְדֵּר שְׁכוּנָתִי", transliteration = "hesder shekhunatit", translation = "квартальная планировка / соглашение о застройке квартала"),

        WordEntity(id = 130819, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "עֹמֶס תִּכְנוּן", transliteration = "omes tikhnun", translation = "проектная нагрузка"),

        WordEntity(id = 130820, setId = 1308, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶטָּא-תִּכְנוּן", transliteration = "meta-tikhnun", translation = "мета-проектирование"),

        WordEntity(id = 130821, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "תִּשְׁתִּית נְסִיּוֹנִית", transliteration = "tashtit nisyonit", translation = "экспериментальная инфраструктура"),

        WordEntity(id = 130822, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "רֶגוּלָצְיַת עֲנַף הַבִּנְיָן", transliteration = "regulatsyat anaf habinyan", translation = "регулирование строительной отрасли"),

        WordEntity(id = 130823, setId = 1308, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אֶסְתֵּטִיקַת הַמֶּרְחָב הָעִירוֹנִי", transliteration = "estetika hamérkhav ha'ironi", translation = "эстетика городского пространства"),

        WordEntity(id = 130824, setId = 1308, languagePair = "he-ru", rarity = "EPIC",
            original = "שִׁתּוּף צִבּוּרִי בְּתִכְנוּן", transliteration = "shituf tzibburi betikhnun", translation = "общественное участие в планировании"),

        WordEntity(id = 130825, setId = 1308, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תֶּוֶר פְּרִיסַת בְּנִיָּה", transliteration = "tever prisat bniya", translation = "схема распределения застройки"),

        // ── Set 1309: Строительство: носитель языка (level=5, LEGENDARY) ────────────

        WordEntity(id = 130901, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פֶנוֹמֶנוֹלוֹגְיָה אַדְרִיכָלִית", transliteration = "fenomenologya adrikhalit", translation = "архитектурная феноменология"),

        WordEntity(id = 130902, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "עִיר פּוֹסְט-תַּעֲשִׂיָּתִית", transliteration = "ir post-ta'asiyatit", translation = "постиндустриальный город"),

        WordEntity(id = 130903, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "סוֹצְיוֹלוֹגְיָה מֶרְחָבִית", transliteration = "sotsyologya merkhavit", translation = "пространственная социология"),

        WordEntity(id = 130904, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "דֶּקוֹנְסְטְרוּקְטִיבִיזְם אַדְרִיכָלִי", transliteration = "dekonstruktivizm adrikali", translation = "деконструктивизм в архитектуре"),

        WordEntity(id = 130905, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "עִיר חֲכָמָה", transliteration = "ir khakhama", translation = "умный город"),

        WordEntity(id = 130906, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אוּרְבָּנִיזְם חָדָשׁ", transliteration = "urbanism khadash", translation = "новый урбанизм"),

        WordEntity(id = 130907, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "טוֹפּוֹגְרָפְיָה חֶבְרָתִית", transliteration = "topografya khevratit", translation = "социальная топография"),

        WordEntity(id = 130908, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פֶּנוֹמֶנוֹלוֹגְיָה שֶׁל הַמֶּרְחָב", transliteration = "fenomenologya shel hammerkhav", translation = "феноменология пространства"),

        WordEntity(id = 130909, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אַרְכִיטֶקְטוּרָה בִּיוֹפִילִית", transliteration = "arkhitektura biofilit", translation = "биофильная архитектура"),

        WordEntity(id = 130910, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׂיחַ אַדְרִיכָלִי", transliteration = "si'akh adrikali", translation = "архитектурный дискурс"),

        WordEntity(id = 130911, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תֵּאוֹרְיַת הַמֶּרְחָב", transliteration = "teoriyat hamérkhav", translation = "теория пространства"),

        WordEntity(id = 130912, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "בִּנְיָן בְּר-קַיְּמָא", transliteration = "binyan bar-kayama", translation = "устойчивое здание / зелёное строительство"),

        WordEntity(id = 130913, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "גֵּנוֹסַגְרֵגַצְיָה עִירוֹנִית", transliteration = "genosagregatsya ironit", translation = "городская сегрегация"),

        WordEntity(id = 130914, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "טִפּוֹלוֹגְיָה אַדְרִיכָלִית", transliteration = "tipologya adrikhalit", translation = "архитектурная типология"),

        WordEntity(id = 130915, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶרְחָב צִבּוּרִי", transliteration = "merkhav tzibburi", translation = "общественное пространство"),

        WordEntity(id = 130916, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פְּרוֹגְרַמָּה אַדְרִיכָלִית", transliteration = "programa adrikhalit", translation = "архитектурная программа / архитектурное задание"),

        WordEntity(id = 130917, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הַשְׁפָּעַת הַמָּקוֹם", transliteration = "hashpa'at hamakom", translation = "genius loci / дух места"),

        WordEntity(id = 130918, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "עִירוּב שְׁימוּשִׁים", transliteration = "eruv shimushim", translation = "смешанное землепользование"),

        WordEntity(id = 130919, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "עִיצּוּב בְּשִׂיתּוּף", transliteration = "itzuv beshituf", translation = "соучаствующее проектирование / совместный дизайн"),

        WordEntity(id = 130920, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אַדְרִיכָלוּת קְרִיטִית", transliteration = "adrikhdalut kritit", translation = "критическая архитектура"),

        WordEntity(id = 130921, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מַרְקָם עִירוֹנִי", transliteration = "markam ironi", translation = "городская ткань / городская среда"),

        WordEntity(id = 130922, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "זִהוּי מָקוֹם", transliteration = "zihui makom", translation = "идентичность места / место-идентичность"),

        WordEntity(id = 130923, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "רֶטְרוֹפִיט אֶנֶרְגֶטִי", transliteration = "retrofit energeti", translation = "энергетический ретрофит / глубокая энергомодернизация"),

        WordEntity(id = 130924, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "כַּלְכָּלָה מֵעְגָּלִית בְּבִנְיָן", transliteration = "kalkala me'agalit bebinyan", translation = "циркулярная экономика в строительстве"),

        WordEntity(id = 130925, setId = 1309, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶטָּבּוֹלִיזְם עִירוֹנִי", transliteration = "metabolism ironi", translation = "городской метаболизм"),
    )
}
