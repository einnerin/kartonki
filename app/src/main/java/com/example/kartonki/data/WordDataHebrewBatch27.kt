package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch27 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1103, languagePair = "he-ru", orderIndex = 1103,
            name = "Природа и экология: продвинутый 2", description = "Земледелие, животноводство и агротехнологии"
        ,
            topic = "Природа и экология",
            level = 2),
        WordSetEntity(
            id = 1104, languagePair = "he-ru", orderIndex = 1104,
            name = "Одежда: продвинутый", description = "Индустрия моды, дизайн и эстетика"
        ,
            topic = "Одежда",
            level = 2),
        WordSetEntity(
            id = 1105, languagePair = "he-ru", orderIndex = 1105,
            name = "Наука: профессиональный", description = "Мозг, нейроны и когнитивные процессы"
        ,
            topic = "Наука",
            level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1103: Сельское хозяйство ─────────────────────────────────
        // UNCOMMON (A2-B1)
        WordEntity(id = 110301, setId = 1103, languagePair = "he-ru", original = "בַּצּוֹרֶת", translation = "засуха", transliteration = "batzóret", rarity = "UNCOMMON"),
        WordEntity(id = 110302, setId = 1103, languagePair = "he-ru", original = "עִיבּוּד אֲדָמָה", translation = "обработка земли; земледелие", transliteration = "ibud adama", rarity = "UNCOMMON"),
        WordEntity(id = 110303, setId = 1103, languagePair = "he-ru", original = "קַרְקַע", translation = "почва; грунт", transliteration = "karka", rarity = "UNCOMMON"),
        WordEntity(id = 110304, setId = 1103, languagePair = "he-ru", original = "מִרְעֶה", translation = "пастбище", transliteration = "mir'e", rarity = "UNCOMMON"),
        WordEntity(id = 110305, setId = 1103, languagePair = "he-ru", original = "פּוֹרְיוּת", translation = "плодородность", transliteration = "poriyut", rarity = "UNCOMMON"),
        WordEntity(id = 110306, setId = 1103, languagePair = "he-ru", original = "עֶדֶר", translation = "стадо; отара", transliteration = "eder", rarity = "UNCOMMON"),
        WordEntity(id = 110307, setId = 1103, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דֶּשֶׁן", translation = "удобрение"),
        WordEntity(id = 110308, setId = 1103, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חַמָּמָה", translation = "теплица"),
        WordEntity(id = 110309, setId = 1103, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַחֲרֵשָׁה", translation = "плуг"),
        WordEntity(id = 110310, setId = 1103, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גִּידוּל", translation = "культивация"),
        WordEntity(id = 110311, setId = 1103, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בָּקָר", translation = "крупный рогатый скот"),
        WordEntity(id = 110312, setId = 1103, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כֶּבֶשׂ", translation = "овца"),
        WordEntity(id = 110313, setId = 1103, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כְּרֶם", translation = "виноградник"),
        WordEntity(id = 110314, setId = 1103, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אוֹרְגָּנִי", translation = "органический"),
        WordEntity(id = 110315, setId = 1103, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֶלְקָה", translation = "земельный участок"),
        WordEntity(id = 110316, setId = 1103, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קוֹמְבַּיְן", translation = "комбайн"),
        WordEntity(id = 110317, setId = 1103, languagePair = "he-ru", rarity = "RARE",
            original = "הַדְבָּרָה", translation = "борьба с вредителями"),
        WordEntity(id = 110318, setId = 1103, languagePair = "he-ru", rarity = "RARE",
            original = "חֲרִישָׁה", translation = "вспашка"),
        WordEntity(id = 110319, setId = 1103, languagePair = "he-ru", rarity = "RARE",
            original = "זְרִיעַת כִּסּוּי", translation = "покровные культуры"),
        WordEntity(id = 110320, setId = 1103, languagePair = "he-ru", rarity = "RARE",
            original = "רוֹטַצְיַת גִּידוּלִים", translation = "севооборот"),
        WordEntity(id = 110321, setId = 1103, languagePair = "he-ru", rarity = "RARE",
            original = "אַקְוָה-פּוֹנִיקָה", translation = "аквапоника"),
        // RARE (B2)
        WordEntity(id = 110322, setId = 1103, languagePair = "he-ru", original = "אָגְרוֹ-טֶכְנוֹלוֹגְיָה", translation = "агротехнология", transliteration = "agro-tekhnologiya", rarity = "RARE"),
        WordEntity(id = 110323, setId = 1103, languagePair = "he-ru", original = "חֲקְלָאוּת קַיֶּמֶת", translation = "устойчивое сельское хозяйство", transliteration = "khaklaút kayyémet", rarity = "RARE"),
        WordEntity(id = 110324, setId = 1103, languagePair = "he-ru", original = "שִׁיקּוּם אֲדָמוֹת", translation = "рекультивация земель", transliteration = "shikum adamot", rarity = "RARE"),
        WordEntity(id = 110325, setId = 1103, languagePair = "he-ru", original = "מִחְזוּר אוֹרְגָּנִי", translation = "органический рециклинг", transliteration = "mikhzur organi", rarity = "RARE"),

        // ── Set 1104: Мода и стиль ────────────────────────────────────────
        // UNCOMMON (A2-B1)
        WordEntity(id = 110401, setId = 1104, languagePair = "he-ru", original = "קְרִיצָה", translation = "вязание; трикотаж", transliteration = "kritza", rarity = "UNCOMMON"),
        WordEntity(id = 110402, setId = 1104, languagePair = "he-ru", original = "כְּפָתוֹר", translation = "пуговица", transliteration = "kfator", rarity = "UNCOMMON"),
        WordEntity(id = 110403, setId = 1104, languagePair = "he-ru", original = "פַּשְׁתָּן", translation = "лён; льняная ткань", transliteration = "pashtan", rarity = "UNCOMMON"),
        WordEntity(id = 110404, setId = 1104, languagePair = "he-ru", original = "נַיְלוֹן", translation = "нейлон", transliteration = "naylo n", rarity = "UNCOMMON"),
        WordEntity(id = 110405, setId = 1104, languagePair = "he-ru", original = "שְׂמַלַּת עֶרֶב", translation = "вечернее платье", transliteration = "smlat erev", rarity = "UNCOMMON"),
        WordEntity(id = 110406, setId = 1104, languagePair = "he-ru", original = "צֶמֶר גֶּפֶן", translation = "хлопок", transliteration = "tzemer gefen", rarity = "UNCOMMON"),
        WordEntity(id = 110407, setId = 1104, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּצוּגַת אוֹפְנָה", translation = "показ мод"),
        WordEntity(id = 110408, setId = 1104, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פּוֹדְיוּם", translation = "подиум"),
        WordEntity(id = 110409, setId = 1104, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חוּלְצָה", translation = "рубашка"),
        WordEntity(id = 110410, setId = 1104, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּפִירָה", translation = "пошив"),
        WordEntity(id = 110411, setId = 1104, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֲקְסֶסוֹאָר", translation = "аксессуар"),
        WordEntity(id = 110412, setId = 1104, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְטַיְלִיסְט", translation = "стилист"),
        WordEntity(id = 110413, setId = 1104, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מֵי בּוֹשֶׁם", translation = "духи"),
        WordEntity(id = 110414, setId = 1104, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צֶמֶר", translation = "шерсть"),
        WordEntity(id = 110415, setId = 1104, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֱלֶגַנְטִי", translation = "элегантный"),
        WordEntity(id = 110416, setId = 1104, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹדֶרְנִי", translation = "современный"),
        WordEntity(id = 110417, setId = 1104, languagePair = "he-ru", rarity = "RARE",
            original = "טְרֶנְד", translation = "тренд"),
        WordEntity(id = 110418, setId = 1104, languagePair = "he-ru", rarity = "RARE",
            original = "וִינְטַאזׁ׳", translation = "винтаж"),
        WordEntity(id = 110419, setId = 1104, languagePair = "he-ru", rarity = "RARE",
            original = "הוֹט קוּטוּר", translation = "от-кутюр"),
        WordEntity(id = 110420, setId = 1104, languagePair = "he-ru", rarity = "RARE",
            original = "פְּרֶט-אָ-פּוֹרְטֶה", translation = "прет-а-порте"),
        WordEntity(id = 110421, setId = 1104, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹפְנַת רְחוֹב", translation = "уличная мода"),
        // RARE (B2)
        WordEntity(id = 110422, setId = 1104, languagePair = "he-ru", original = "עִצּוּב טֶקְסְטִיל", translation = "дизайн текстиля", transliteration = "itzuv tekstil", rarity = "RARE"),
        WordEntity(id = 110423, setId = 1104, languagePair = "he-ru", original = "מוֹדָה אוֹרְגָּנִית", translation = "органическая мода; экомода", transliteration = "moda organit", rarity = "RARE"),
        WordEntity(id = 110424, setId = 1104, languagePair = "he-ru", original = "אִינְדוּסְטְרִיַּת הַלְּבוּשׁ", translation = "лёгкая промышленность; индустрия одежды", transliteration = "industryat halvush", rarity = "RARE"),
        WordEntity(id = 110425, setId = 1104, languagePair = "he-ru", original = "עִיצּוּב לְבוּשׁ", translation = "дизайн одежды", transliteration = "itzuv lvush", rarity = "RARE"),

        // ── Set 1105: Нейронауки ──────────────────────────────────────────
        // RARE (B2)
        WordEntity(id = 110501, setId = 1105, languagePair = "he-ru", original = "גַּרְעִין הַבָּסִיס", translation = "базальные ганглии", transliteration = "gar'in habasis", rarity = "RARE"),
        WordEntity(id = 110502, setId = 1105, languagePair = "he-ru", original = "מַסְלוּל מוֹטוֹרִי", translation = "моторный путь", transliteration = "maslul motori", rarity = "RARE"),
        WordEntity(id = 110503, setId = 1105, languagePair = "he-ru", original = "פּוֹטֶנְצְיָאל מְנוּחָה", translation = "потенциал покоя", transliteration = "potentsial menukha", rarity = "RARE"),
        WordEntity(id = 110504, setId = 1105, languagePair = "he-ru", original = "תְּגוּבָה עֲצָבִית", translation = "нервный ответ", transliteration = "teguva atzavit", rarity = "RARE"),
        WordEntity(id = 110505, setId = 1105, languagePair = "he-ru", original = "מַנְגָּנוֹן זִיכָּרוֹן", translation = "механизм памяти", transliteration = "menganon zikaron", rarity = "RARE"),
        WordEntity(id = 110506, setId = 1105, languagePair = "he-ru", original = "גֵּאוֹגְרָפְיַת הַמֹּחַ", translation = "топография мозга", transliteration = "ge'ografyat hamoah", rarity = "RARE"),
        WordEntity(id = 110507, setId = 1105, languagePair = "he-ru", original = "שִׁוּוּי מִשְׁקַל עֲצָבִי", translation = "нейронное равновесие", transliteration = "shivuy mishkal atzavi", rarity = "RARE"),
        WordEntity(id = 110508, setId = 1105, languagePair = "he-ru", original = "קֶלֶט חוּשִׁי", translation = "сенсорный ввод", transliteration = "kelet khushi", rarity = "RARE"),
        WordEntity(id = 110509, setId = 1105, languagePair = "he-ru", original = "פַּקַּד עֲצָבִי", translation = "нервный командный центр", transliteration = "pakad atzavi", rarity = "RARE"),

        // EPIC (C1)
        WordEntity(id = 110510, setId = 1105, languagePair = "he-ru", original = "תַּהֲלִיךְ עֲצָבִי", translation = "нейронный процесс", transliteration = "tahalikh atzavi", rarity = "EPIC"),
        WordEntity(id = 110511, setId = 1105, languagePair = "he-ru", original = "קוֹד עֲצָבִי", translation = "нейронный код", transliteration = "kod atzavi", rarity = "EPIC"),
        WordEntity(id = 110512, setId = 1105, languagePair = "he-ru", original = "אִינְטֶגְרַצְיַת חוּשִׁים", translation = "сенсорная интеграция", transliteration = "integratziyat khushim", rarity = "EPIC"),
        WordEntity(id = 110513, setId = 1105, languagePair = "he-ru", original = "חִישׁוּב עֲצָבִי", translation = "нейронные вычисления", transliteration = "khishub atzavi", rarity = "EPIC"),
        WordEntity(id = 110514, setId = 1105, languagePair = "he-ru", original = "מִסְגֶּרֶת עֲצָבִית", translation = "нейронная архитектура", transliteration = "misgeret atzavit", rarity = "EPIC"),
        WordEntity(id = 110515, setId = 1105, languagePair = "he-ru", original = "תְּגוּבָה קוֹגְנִיטִיבִית", translation = "когнитивный ответ", transliteration = "teguva kognitivit", rarity = "EPIC"),
        WordEntity(id = 110516, setId = 1105, languagePair = "he-ru", original = "נְבִיאוּת עֲצָבִית", translation = "нейропредсказание", transliteration = "nviyut atzavit", rarity = "EPIC"),
        WordEntity(id = 110517, setId = 1105, languagePair = "he-ru", rarity = "RARE",
            original = "נוֹירוֹגֶּנֶזָה", translation = "нейрогенез"),
        WordEntity(id = 110518, setId = 1105, languagePair = "he-ru", rarity = "RARE",
            original = "מִיֶּלִין", translation = "миелин"),
        WordEntity(id = 110519, setId = 1105, languagePair = "he-ru", rarity = "RARE",
            original = "גְּלִיָּה", translation = "глиальные клетки"),
        WordEntity(id = 110520, setId = 1105, languagePair = "he-ru", rarity = "RARE",
            original = "נוֹירוֹדֶגֶנֶרַצְיָה", translation = "нейродегенерация"),
        WordEntity(id = 110521, setId = 1105, languagePair = "he-ru", rarity = "RARE",
            original = "בֵּינָה מְלָאכוּתִית עֲצַבִּית", translation = "нейронная сеть ИИ"),
        WordEntity(id = 110522, setId = 1105, languagePair = "he-ru", rarity = "EPIC",
            original = "נוֹירוֹאִימֵיגִ׳ינְג", translation = "нейровизуализация"),
        WordEntity(id = 110523, setId = 1105, languagePair = "he-ru", rarity = "EPIC",
            original = "קוֹנֶקְטוֹם", translation = "коннектом"),
        WordEntity(id = 110524, setId = 1105, languagePair = "he-ru", rarity = "EPIC",
            original = "נוֹירוֹמוֹדוּלַצְיָה", translation = "нейромодуляция"),
        // EPIC (C1)
        WordEntity(id = 110525, setId = 1105, languagePair = "he-ru", original = "אִינְטֶגְרַצְיַת מוֹחַ-מַחְשֵׁב", translation = "интерфейс мозг-компьютер", transliteration = "integratziyat moah-makhshev", rarity = "EPIC"),
    )
}
