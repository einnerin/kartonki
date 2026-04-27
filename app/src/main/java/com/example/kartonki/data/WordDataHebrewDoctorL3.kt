package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: «У врача в Израиле», level 3 (1 set, 25 words).
 * Углублённая лексика приёма у израильских врачей: специалисты,
 * лабораторные анализы, инструментальные обследования, прививки и
 * экстренная помощь.
 *
 * Set 1804 (level 3, RARE + EPIC) — заполняет уровень между
 * level 1 (1802) и level 2 (1803) в новой теме «У врача в Израиле».
 *
 * Не пересекается с уже существующими сетами «Медицина» (1600–1606,
 * MedicineV2): отброшены кардиолог/ортопед/гинеколог/нефролог/эндокринолог,
 * УЗИ/КТ/МРТ, гастроскопия/колоноскопия/маммография, периодический осмотр,
 * חִיסּוּן (single word) и תַּרְכִּיב (single word). Допустимы пересечения
 * с темами «Врач» (1408–1412), «Больница и работа медсестрой» (Batch67) и
 * «Ветеринар» (Batch75) — это разные topic.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC (2 смежных уровня, RARE+EPIC).
 *
 * Пять подгрупп по 5 слов каждая:
 *   doctor_specialists    — врачи-специалисты, не входящие в MedicineV2 1605
 *   doctor_tests          — лабораторные и инструментальные анализы
 *   doctor_examinations   — инструментальные/диагностические обследования
 *   doctor_immunization   — прививки и иммунопрофилактика
 *   doctor_emergency      — скорая помощь и приёмное отделение
 *
 * isFillInBlankSafe = false везде — pipeline `fillInBlankExclusions`
 * ещё не прогнан для этого нового сета (Phase A pending).
 */
object WordDataHebrewDoctorL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1804, languagePair = "he-ru", orderIndex = 1804,
            name = "У врача в Израиле",
            description = "Углублённый: специалисты, анализы, обследования, прививки",
            topic = "У врача в Израиле", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1804 — У врача в Израиле: углублённый (RARE + EPIC, B2–C1)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── doctor_specialists (5) — узкие специалисты не из MedicineV2 1605 ──
        WordEntity(
            id = 180401, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "doctor_specialists", transliteration = "psikhiater",
            original = "פְּסִיכִיאָטֶר", translation = "психиатр",
            definition = "רוֹפֵא שֶׁמְּטַפֵּל בְּהַפְרָעוֹת נֶפֶשׁ קָשׁוֹת וְרוֹשֵׁם תְּרוּפוֹת.",
            definitionNative = "Врач, который лечит душевные расстройства и выписывает лекарства.",
            example = "פְּסִיכִיאָטֶר רָשַׁם לוֹ תְּרוּפָה נֶגֶד דִּכָּאוֹן אַחֲרֵי שִׂיחָה אֲרוּכָּה.",
            exampleNative = "פְּסִיכִיאָטֶר выписал ему таблетки от депрессии после долгой беседы.", fillInBlankExclusions = listOf(180402L, 180403L, 180404L, 180405L)),
        WordEntity(
            id = 180402, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "doctor_specialists", transliteration = "alergolog",
            original = "אַלֶרְגוֹלוֹג", translation = "аллерголог",
            definition = "רוֹפֵא שֶׁבּוֹדֵק תְּגוּבוֹת חַד שֶׁל הַגּוּף לְמָזוֹן, אָבָק אוֹ צֶמַח.",
            definitionNative = "Врач, выясняющий, на что у тела бурная реакция: еда, пыль или цветы.",
            example = "אַלֶרְגוֹלוֹג מָצָא לִי רְגִישׁוּת לְבוֹטֶנִים אַחֲרֵי בְּדִיקַת עוֹר.",
            exampleNative = "אַלֶרְגוֹלוֹג нашёл у меня чувствительность к арахису по кожной пробе.", fillInBlankExclusions = listOf(180401L, 180403L, 180404L, 180405L)),
        WordEntity(
            id = 180403, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "doctor_specialists", transliteration = "gastroenterolog",
            original = "גָסְטְרוֹאֶנְטֶרוֹלוֹג", translation = "гастроэнтеролог",
            definition = "רוֹפֵא לְמַחֲלוֹת קֵיבָה, מֵעַיִם וְכָבֵד.",
            definitionNative = "Врач, занимающийся болезнями желудка, кишечника и печени.",
            example = "גָסְטְרוֹאֶנְטֶרוֹלוֹג שָׁלַח אוֹתִי לִבְדִיקָה לְאוּלְצוּס בַּקֵּיבָה.",
            exampleNative = "גָסְטְרוֹאֶנְטֶרוֹלוֹג отправил меня на проверку язвы желудка.", fillInBlankExclusions = listOf(180401L, 180402L, 180404L, 180405L)),
        WordEntity(
            id = 180404, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_specialists", transliteration = "onkolog",
            original = "אוֹנְקוֹלוֹג", translation = "онколог",
            definition = "רוֹפֵא לְגִּדּוּלִים סַרְטָנִיִּים וְהַטִּיפּוּל בָּהֶם.",
            definitionNative = "Врач по злокачественным опухолям и подбору лечения от них.",
            example = "אוֹנְקוֹלוֹג בָּחַר לָהּ פְּרוֹטוֹקוֹל טִיפּוּל אַחֲרֵי תּוֹצְאוֹת הַבִּיוֹפְּסְיָה.",
            exampleNative = "אוֹנְקוֹלוֹג подобрал ей протокол лечения после результатов биопсии.", fillInBlankExclusions = listOf(180401L, 180402L, 180403L, 180405L)),
        WordEntity(
            id = 180405, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_specialists", transliteration = "neirokhirurg",
            original = "נוֹירוֹכִירוּרְג", translation = "нейрохирург",
            definition = "מְנַתֵּחַ שֶׁמְּבַצֵּעַ נִיתּוּחִים בַּמּוֹחַ וּבְעַמּוּד הַשִּׁדְרָה.",
            definitionNative = "Хирург, который оперирует мозг и позвоночник.",
            example = "נוֹירוֹכִירוּרְג נִיתֵּחַ אוֹתוֹ עֶשֶׂר שָׁעוֹת לְהוֹצָאַת גִּידוּל בַּמּוֹחַ.",
            exampleNative = "נוֹירוֹכִירוּרְג оперировал его десять часов, удаляя опухоль мозга.", fillInBlankExclusions = listOf(180401L, 180402L, 180403L, 180404L)),

        // ── doctor_tests (5) — лабораторные и кардиологические анализы ──
        WordEntity(
            id = 180406, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_tests", transliteration = "bdikat sheten",
            original = "בְּדִיקַת שֶׁתֶן", translation = "анализ мочи",
            definition = "בְּחִינַת נוֹזֵל הַכְּלָיוֹת בַּמַּעְבָּדָה לְזִהוּי דַּלֶּקֶת אוֹ סוּכָּר.",
            definitionNative = "Лабораторная проверка жидкости почек на воспаление или сахар.",
            example = "בְּדִיקַת שֶׁתֶן הִתְבַּקְּשָׁה בַּבֹּקֶר עַל קִיבָה רֵיקָה.",
            exampleNative = "בְּדִיקַת שֶׁתֶן нужно было сдать утром натощак.", fillInBlankExclusions = listOf(180408L, 180409L, 180410L)),
        WordEntity(
            id = 180407, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "doctor_tests", transliteration = "elektrokardiogram",
            original = "אֶלֶקְטְרוֹקַרְדְּיוֹגְרַם", translation = "электрокардиограмма",
            definition = "רִישׁוּם פְּעִילוּת חַשְׁמַלִּית שֶׁל שְׁרִיר הַלֵּב עַל נְיָר.",
            definitionNative = "Запись электрической работы сердечной мышцы на бумагу.",
            example = "אֶלֶקְטְרוֹקַרְדְּיוֹגְרַם הִצְבִּיעַ עַל הַפְרָעוֹת קַלּוֹת בַּקֶּצֶב.",
            exampleNative = "אֶלֶקְטְרוֹקַרְדְּיוֹגְרַם показала лёгкие нарушения ритма сердца.", fillInBlankExclusions = listOf(180413L)),
        WordEntity(
            id = 180408, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_tests", transliteration = "bdikat tifkudei kaved",
            original = "בְּדִיקַת תִּפְקוּדֵי כָּבֵד", translation = "печёночные пробы",
            definition = "סִדְרַת בְּדִיקוֹת דָּם שֶׁמַּרְאָה כַּמָּה הָאֵיבָר עַל יַד הַקֵּיבָה עוֹבֵד טוֹב.",
            definitionNative = "Серия анализов крови о работе органа справа над желудком.",
            example = "בְּדִיקַת תִּפְקוּדֵי כָּבֵד הִתְבַּקְּשָׁה אַחֲרֵי שָׁנָה שֶׁל תְּרוּפָה כְּרוֹנִית.",
            exampleNative = "בְּדִיקַת תִּפְקוּדֵי כָּבֵד назначили после года приёма постоянного лекарства.", fillInBlankExclusions = listOf(180406L, 180409L, 180410L)),
        WordEntity(
            id = 180409, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_tests", transliteration = "tarbit garon",
            original = "תַּרְבִּית גָּרוֹן", translation = "посев из горла",
            definition = "לְקִיחַת מִשְׁטָח מֵהַפֶּה לְזִהוּי הַחַיְדַּק שֶׁגּוֹרֵם לְדַלֶּקֶת.",
            definitionNative = "Мазок из горла для выяснения, какая бактерия вызывает воспаление.",
            example = "תַּרְבִּית גָּרוֹן אִישְּׁרָה זִיהוּם בַּקְטֶרְיָאלִי וְלֹא וִירוּסִי.",
            exampleNative = "תַּרְבִּית גָּרוֹן подтвердил бактериальную, а не вирусную инфекцию.", fillInBlankExclusions = listOf(180406L, 180408L, 180410L)),
        WordEntity(
            id = 180410, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_tests", transliteration = "hormonei tireoid",
            original = "הוֹרְמוֹנֵי תִּרְאוֹיד", translation = "гормоны щитовидной железы",
            definition = "חוֹמָרִים מִבְּלוּטָה בַּצַּוָּאר שֶׁמַּכְתִּיבִים אֶת קֶצֶב הַחִילּוּף בַּגּוּף.",
            definitionNative = "Вещества из железы на шее, задающие скорость обмена веществ.",
            example = "הוֹרְמוֹנֵי תִּרְאוֹיד הָיוּ נְמוּכִים וְהִסְבִּירוּ אֶת הָעֲיֵפוּת הַמַּתְמֶדֶת.",
            exampleNative = "הוֹרְמוֹנֵי תִּרְאוֹיד оказались низкими и объяснили постоянную усталость.", fillInBlankExclusions = listOf(180406L, 180408L, 180409L)),

        // ── doctor_examinations (5) — инструментальные обследования ──
        WordEntity(
            id = 180411, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_examinations", transliteration = "bdikat re'iya",
            original = "בְּדִיקַת רְאִיָּה", translation = "проверка зрения",
            definition = "מַעֲרֶכֶת מִבְחָנִים אֵצֶל אוֹפְּטוֹמֶטְרִיסְט לְמַעַן חֶדּוּת הָעַיִן.",
            definitionNative = "Серия тестов у оптометриста на остроту глаза.",
            example = "בְּדִיקַת רְאִיָּה גִּלְּתָה צֹרֶךְ בְּמִשְׁקְפַיִם רָאִיָּה לִקְרִיאָה.",
            exampleNative = "בְּדִיקַת רְאִיָּה показала, что для чтения нужны очки.", fillInBlankExclusions = listOf(180412L, 180414L)),
        WordEntity(
            id = 180412, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_examinations", transliteration = "bdikat shmi'a",
            original = "בְּדִיקַת שְׁמִיעָה", translation = "проверка слуха",
            definition = "מִבְחָן בְּחֶדֶר שֶׁקֶט עִם אוֹזְנִיּוֹת לְהַעֲרָכַת קְלִיטַת צְלִילִים.",
            definitionNative = "Тест в тихой комнате с наушниками на восприятие звуков.",
            example = "בְּדִיקַת שְׁמִיעָה הוֹכִיחָה יְרִידָה בָּאֹזֶן הַשְּׂמָאלִית.",
            exampleNative = "בְּדִיקַת שְׁמִיעָה показала снижение в левом ухе.", fillInBlankExclusions = listOf(180411L, 180414L)),
        WordEntity(
            id = 180413, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_examinations", transliteration = "ekokardiografya",
            original = "אֶכוֹקַרְדְּיוֹגְרַפְיָה", translation = "эхокардиография",
            definition = "צִילוּם הַלֵּב בְּעֶזְרַת גַּלֵּי קוֹל גְּבוֹהִים מִתּוֹךְ הַחָזֶה.",
            definitionNative = "Снимок сердца с помощью ультразвуковых волн через грудную клетку.",
            example = "אֶכוֹקַרְדְּיוֹגְרַפְיָה גִּלְּתָה הַרְחָבָה קַלָּה שֶׁל חֲדַר הַלֵּב הַשְּׂמָאלִי.",
            exampleNative = "אֶכוֹקַרְדְּיוֹגְרַפְיָה показала лёгкое расширение левого желудочка.", fillInBlankExclusions = listOf(180407L, 180415L)),
        WordEntity(
            id = 180414, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_examinations", transliteration = "mipuy atsamot",
            original = "מִיפּוּי עֲצָמוֹת", translation = "сцинтиграфия костей",
            definition = "סְרִיקַת שֶׁלֶד שְׁלֵמָה אַחֲרֵי הַזְרָקַת חוֹמֶר רָדִיוֹאַקְטִיבִי קַל.",
            definitionNative = "Сканирование скелета после укола слабого радиоактивного вещества.",
            example = "מִיפּוּי עֲצָמוֹת לֹא מָצָא גְּרוּרוֹת בִּצְלָעוֹת אוֹ בָּאֲגַן.",
            exampleNative = "מִיפּוּי עֲצָמוֹת не нашёл метастазов в рёбрах или тазу.", fillInBlankExclusions = listOf(180411L, 180412L)),
        WordEntity(
            id = 180415, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_examinations", transliteration = "dermatoskopya",
            original = "דֶּרְמָטוֹסְקוֹפְּיָה", translation = "дерматоскопия",
            definition = "בְּחִינַת שׁוּמוֹת בְּזַכּוּכִית מַגְדֶּלֶת מְיוּחֶדֶת אֵצֶל רוֹפֵא הָעוֹר.",
            definitionNative = "Осмотр родинок особой увеличительной лупой у кожного врача.",
            example = "דֶּרְמָטוֹסְקוֹפְּיָה רוּטִינִית מוֹצֵאת שׁוּמוֹת חֲשׁוּדוֹת בְּשָׁלָב מוּקְדָּם.",
            exampleNative = "דֶּרְמָטוֹסְקוֹפְּיָה на регулярной основе ловит подозрительные родинки рано.", fillInBlankExclusions = listOf(180413L)),

        // ── doctor_immunization (5) — прививки и иммунопрофилактика ──
        WordEntity(
            id = 180416, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_immunization", transliteration = "khisun shapa'at",
            original = "חִסּוּן שַׁפַּעַת", translation = "прививка от гриппа",
            definition = "זְרִיקָה שְׁנָתִית שֶׁמְּגִינָה מִפְּנֵי וִירוּס הַחֹרֶף הַנָּפוֹץ.",
            definitionNative = "Ежегодный укол, защищающий от распространённого зимнего вируса.",
            example = "חִסּוּן שַׁפַּעַת חוֹפְשִׁי בַּקֻּפָּה לְכָל מְבוּטָּחֵי הַגִּיל הַשְּׁלִישִׁי.",
            exampleNative = "חִסּוּן שַׁפַּעַת бесплатна в кассе для всех застрахованных пенсионеров.", fillInBlankExclusions = listOf(180417L, 180418L, 180420L)),
        WordEntity(
            id = 180417, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_immunization", transliteration = "khisun yeladim",
            original = "חִסּוּן יְלָדִים", translation = "детская вакцинация",
            definition = "סְדַר זְרִיקוֹת לְפֶעוֹט לְפִי לוּחַ הַמִּשְׂרָד הַכָּלָלִי.",
            definitionNative = "Серия уколов малышу по графику министерства здравоохранения.",
            example = "חִסּוּן יְלָדִים נִעֱרָךְ לְפִי גִּיל בִּשְׁלֹשָׁה, חֹדֶשׁ, שָׁנָה.",
            exampleNative = "חִסּוּן יְלָדִים делают по возрасту: в три, в полгода, в год.", fillInBlankExclusions = listOf(180416L, 180418L, 180420L)),
        WordEntity(
            id = 180418, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_immunization", transliteration = "mana dokhefet",
            original = "מָנָה דּוֹחֶפֶת", translation = "бустер-доза",
            definition = "זְרִיקָה נוֹסֶפֶת אַחֲרֵי הַסְּדַרָה הָעִקָּרִית לְהַחְזָקַת הַהֲגָנָה.",
            definitionNative = "Дополнительный укол после основного курса для поддержания защиты.",
            example = "מָנָה דּוֹחֶפֶת נֶגֶד קוֹרוֹנָה הוּמְלְצָה חֲצִי שָׁנָה אַחַר הַזְּרִיקָה הָרִאשׁוֹנָה.",
            exampleNative = "מָנָה דּוֹחֶפֶת от ковида рекомендована через полгода после первой.", fillInBlankExclusions = listOf(180416L, 180417L, 180420L)),
        WordEntity(
            id = 180419, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_immunization", transliteration = "nogdanim",
            original = "נוֹגְדָנִים", translation = "антитела",
            definition = "חֶלְבּוֹנִים בַּדָּם שֶׁמְּזַהִים מַזִּיק וְנִצְמָדִים אֵלָיו לְהַשְׁמָדָה.",
            definitionNative = "Белки крови, которые цепляются к чужому и помогают его уничтожить.",
            example = "נוֹגְדָנִים נִמְצְאוּ בַּדָּם שֵׁשׁ שָׁנִים אַחֲרֵי הַמַּחֲלָה.",
            exampleNative = "נוֹגְדָנִים нашлись в крови ещё через шесть лет после болезни."),
        WordEntity(
            id = 180420, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_immunization", transliteration = "tipat khalav",
            original = "טִפַּת חָלָב", translation = "пункт «Типат халав»",
            definition = "מִרְפָּאָה צִיבּוּרִית שֶׁעוֹקֶבֶת אַחַר תִּינוֹקוֹת וּמַעֲבִירָה לָהֶם זְרִיקוֹת.",
            definitionNative = "Государственная клиника, наблюдающая младенцев и делающая им прививки.",
            example = "טִפַּת חָלָב מַזְמִינָה אֶת הַתִּינוֹק לִבְדִיקַת מִשְׁקָל וְזְרִיקָה.",
            exampleNative = "טִפַּת חָלָב приглашает младенца на взвешивание и укол.", fillInBlankExclusions = listOf(180416L, 180417L, 180418L)),

        // ── doctor_emergency (5) — скорая помощь и приёмное отделение ──
        WordEntity(
            id = 180421, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_emergency", transliteration = "magen david adom",
            original = "מַגֵּן דָּוִד אָדוֹם", translation = "Маген Давид Адом",
            definition = "אִרְגּוּן הַחֵירוּם הַלְּאוּמִּי הַמַּפְעִיל אַמְבּוּלַנְסִים בְּכָל יִשְׂרָאֵל.",
            definitionNative = "Государственная служба, гоняющая машины скорой по всему Израилю.",
            example = "מַגֵּן דָּוִד אָדוֹם הִגִּיעַ תּוֹךְ שֶׁבַע דַּקּוֹת לְמָקוֹם הַתְּאוּנָה.",
            exampleNative = "מַגֵּן דָּוִד אָדוֹם приехал к месту аварии за семь минут.", fillInBlankExclusions = listOf(180422L, 180423L, 180424L)),
        WordEntity(
            id = 180422, setId = 1804, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_emergency", transliteration = "khadar miyun",
            original = "חֲדַר מִיּוּן", translation = "приёмное отделение",
            definition = "מַחְלָקָה בְּבֵית הַחוֹלִים שֶׁמְּקַבֶּלֶת חוֹלִים דְּחוּפִים בְּכָל שָׁעָה.",
            definitionNative = "Отделение в больнице, принимающее срочных больных в любой час.",
            example = "חֲדַר מִיּוּן הָיָה עָמוּס וְהִמְתַּנּוּ לְרוֹפֵא שָׁלֹשׁ שָׁעוֹת.",
            exampleNative = "חֲדַר מִיּוּן был забит, и врача мы ждали три часа.", fillInBlankExclusions = listOf(180421L, 180423L, 180424L)),
        WordEntity(
            id = 180423, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_emergency", transliteration = "rekhev hatzala",
            original = "רֶכֶב הַצָּלָה", translation = "спасательный реанимобиль",
            definition = "מְכוֹנִית מְצֻיֶּדֶת בַּצֶּוֶת רְפוּאִי לְפִינּוּי פְּצוּעִים בְּמַצָּב חָמוּר.",
            definitionNative = "Машина с медбригадой для эвакуации тяжелораненых.",
            example = "רֶכֶב הַצָּלָה הִגִּיעַ תּוֹךְ דַּקּוֹת לִזְקֵן שֶׁקָּרַס בָּרְחוֹב.",
            exampleNative = "Спасательный реанимобиль приехал за минуты к упавшему на улице старику.", fillInBlankExclusions = listOf(180421L, 180422L, 180424L)),
        WordEntity(
            id = 180424, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_emergency", transliteration = "mokad kherum refui",
            original = "מוּקָד חֵרוּם רְפוּאִי", translation = "пункт неотложной помощи",
            definition = "מָקוֹם פָּתוּחַ עֶשְׂרִים וְאַרְבַּע שָׁעוֹת לְקַבָּלַת חוֹלִים בְּלִי תּוֹר.",
            definitionNative = "Место, открытое круглосуточно, принимающее больных без очереди.",
            example = "פָּנִינוּ לְמוּקָד חֵרוּם רְפוּאִי בִּשְׁתַּיִם לִפְנוֹת בֹּקֶר עִם חֹם גָּבוֹהַּ.",
            exampleNative = "Мы обратились в пункт неотложной помощи в два часа ночи с высокой температурой.", fillInBlankExclusions = listOf(180421L, 180422L, 180423L)),
        WordEntity(
            id = 180425, setId = 1804, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_emergency", transliteration = "triaz",
            original = "טְרִיאַז'", translation = "триаж",
            definition = "מִיּוּן מָהִיר שֶׁל פְּצוּעִים לְפִי דְּחִיפוּת הַטִּיפּוּל הָרָצוּי.",
            definitionNative = "Быстрая сортировка пострадавших по срочности нужной помощи.",
            example = "טְרִיאַז' חִילֵּק אֶת הַפְּצוּעִים לִשְׁלֹשָׁה צְבָעִים לְפִי חוּמְרָה.",
            exampleNative = "טְרִיאַז' разделил пострадавших на три цвета по тяжести.",
            isFillInBlankSafe = false),
    )
}
