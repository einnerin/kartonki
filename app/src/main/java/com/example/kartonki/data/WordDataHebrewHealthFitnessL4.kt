package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Здоровье и фитнес", L4 «Профессиональный» (EPIC+LEGENDARY).
 *
 * Set 1790: «Здоровье и фитнес» — профессиональный L4:
 *           спортивная медицина, нутрициология, ментальное здоровье,
 *           биомеханика, продвинутые методики тренировок.
 *
 * Лексика — для тренеров, физиотерапевтов, спортивных диетологов и
 * образованных любителей. Часть терминов — заимствования
 * (קִינֶמָטִיקָה, הִיפֶּרְטְרוֹפְיָה, פְּרוֹטוֹקוֹל), часть — устоявшиеся ивритские
 * многословные конструкции (טְוָוח תְּנוּעָה, מֶרְכַּז כֹּבֶד, מַחֲזוֹר פַּחְמֵימוֹת).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY (спред 2 смежных).
 *
 * SemanticGroups (5 × 5):
 *   health_sports_med         — спортивная медицина: разрыв связки, ротаторная манжета,
 *                               теннисный локоть, протокол реабилитации
 *   health_nutrition          — нутрициология: гликемический индекс, интервальное голодание,
 *                               кето, синтез белка, углеводная цикловка
 *   health_mental             — ментальное здоровье: осознанность, КПТ, выгорание,
 *                               гигиена сна, тревожное расстройство
 *   health_biomechanics       — биомеханика: кинематика, амплитуда движения, анализ походки,
 *                               анатомическая ось, центр тяжести
 *   health_advanced_training  — продвинутый тренинг: прогрессивная нагрузка, разгрузочная
 *                               неделя, гипертрофия, анаэробный порог, тейпер
 *
 * Word IDs: setId × 100 + position (179001..179025).
 *
 * Дубли с HealthFitness L1L2L3 (1727-1729) и Medicine V2 (1601-1606) проверены:
 * пересечений по `original` нет. Однокоренные внутри набора отсутствуют.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewHealthFitnessL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1790, languagePair = "he-ru", orderIndex = 1790,
            name = "Здоровье и фитнес",
            description = "Углублённый: спортивная медицина, питание, ментальное здоровье, биомеханика",
            topic = "Здоровье и фитнес", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1790 — Здоровье и фитнес: профессиональный (L4, EPIC+LEGENDARY)
        // 5 групп × 5 слов: sports_med, nutrition, mental, biomechanics, advanced_training
        // ══════════════════════════════════════════════════════════════════════

        // ── health_sports_med (5) — спортивная медицина и травмы ──
        WordEntity(
            id = 179001, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_sports_med", transliteration = "rfuat sport",
            original = "רְפוּאַת סְפּוֹרְט", translation = "спортивная медицина",
            definition = "תְּחוּם רְפוּאִי הָעוֹסֵק בִּפְצִיעוֹת אַתְלֵטִים וּבְשִׁיפּוּר בִּטְחוֹן הַגּוּף בָּאִמּוּן.",
            definitionNative = "Раздел медицины — про травмы атлетов и безопасность тела на тренировке.",
            example = "מְרַפֵּא רְפוּאַת סְפּוֹרְט בָּדַק לִי אֶת הַבֶּרֶךְ אַחֲרֵי הַמֵּרוֹץ הָאָרֹךְ.",
            exampleNative = "Специалист по רְפוּאַת סְפּוֹרְט проверил мне колено после долгого забега.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179002, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_sports_med", transliteration = "kriat retsua",
            original = "קְרִיעַת רְצוּעָה", translation = "разрыв связки",
            definition = "פְּגִיעָה חֲמוּרָה שֶׁבָּהּ הַסִּיב הַמְּחַבֵּר עֶצֶם לְעֶצֶם נִקְרַע לִשְׁנַיִם.",
            definitionNative = "Тяжёлая травма — волокно между двумя костями рвётся пополам.",
            example = "קְרִיעַת רְצוּעָה צוֹלֶבֶת קִדְמִית מַרְחִיקָה כַּדּוּרְגְּלָן לְכָל הָעוֹנָה.",
            exampleNative = "קְרִיעַת רְצוּעָה крестообразной выводит футболиста на весь сезон.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179003, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_sports_med", transliteration = "sharvul mesovev",
            original = "שַׁרְווּל מְסוֹבֵב", translation = "ротаторная манжета (плеча)",
            definition = "קְבוּצַת אַרְבָּעָה שְׁרִירִים קְטַנִּים שֶׁמְּיַצְּבִים אֶת מִפְרַק הַכָּתֵף.",
            definitionNative = "Группа из четырёх малых мышц, удерживающих плечевой сустав.",
            example = "פְּגִיעָה בַּשַּׁרְווּל הַמְּסוֹבֵב נְפוּצָה אֵצֶל מַגִּישֵׁי טֶנִיס וְשַׂחְיָנִים.",
            exampleNative = "Травма שַׁרְווּל מְסוֹבֵב частая у теннисистов на подаче и пловцов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179004, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_sports_med", transliteration = "marpek tenisai",
            original = "מַרְפֵּק טֶנִיסַאי", translation = "теннисный локоть",
            definition = "כְּאֵב כְּרוֹנִי בַּצַּד הַחִיצוֹנִי שֶׁל הַמַּרְפֵּק מֵעוֹמֶס חוֹזֵר עַל גִּידֵי הַיָּד.",
            definitionNative = "Хроническая боль с внешней стороны локтя от повторной нагрузки на сухожилия.",
            example = "מַרְפֵּק טֶנִיסַאי תָּקַף אֶת הַנַּגָּר אַחֲרֵי שָׁנָה שֶׁל עֲבוֹדָה בְּמַבְרֵגָה.",
            exampleNative = "מַרְפֵּק טֶנִיסַאי настиг столяра после года работы шуруповёртом.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179005, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_sports_med", transliteration = "protokol shikum",
            original = "פְּרוֹטוֹקוֹל שִׁיקוּם", translation = "протокол реабилитации",
            definition = "תָּכְנִית כְּתוּבָה עִם שְׁלַבִּים וְזְמַנִּים לַחֲזָרָה בִּטּוּחָה לִפְעִילוּת אַחֲרֵי פְּצִיעָה.",
            definitionNative = "Письменный план — этапы и сроки безопасного возврата к нагрузке после травмы.",
            example = "פְּרוֹטוֹקוֹל שִׁיקוּם מְפֹרָט הִחְזִיר אוֹתִי לָרוּץ תּוֹךְ אַרְבָּעָה חֳדָשִׁים.",
            exampleNative = "Подробный פְּרוֹטוֹקוֹל שִׁיקוּם вернул меня на пробежку за четыре месяца.",
            isFillInBlankSafe = false,
        ),

        // ── health_nutrition (5) — нутрициология и режимы питания ──
        WordEntity(
            id = 179006, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_nutrition", transliteration = "madad glikemi",
            original = "מַדַּד גְּלִיקֵמִי", translation = "гликемический индекс",
            definition = "מִסְפָּר הַמַּרְאֶה עַד כַּמָּה מָנָה שֶׁל אֹכֶל מַעֲלָה אֶת רָמַת הַסֻּכָּר בַּדָּם.",
            definitionNative = "Число, показывающее, насколько порция еды поднимает сахар в крови.",
            example = "אוֹרֶז לָבָן עִם מַדַּד גְּלִיקֵמִי גָּבוֹהַּ לֹא מַתְאִים לְפְנֵי הַשֵּׁנָה.",
            exampleNative = "Белый рис с высоким מַדַּד גְּלִיקֵמִי не годится перед сном.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179007, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_nutrition", transliteration = "tsom le-serugin",
            original = "צוֹם לְסֵרוּגִין", translation = "интервальное голодание",
            definition = "שִׁיטָה שֶׁל אֲכִילָה בְּחַלּוֹן זְמַן צַר וְהִמָּנְעוּת מֵאֹכֶל בִּשְׁאָר הַשָּׁעוֹת.",
            definitionNative = "Способ — есть в узком окне времени и не есть в остальные часы.",
            example = "צוֹם לְסֵרוּגִין שֶׁל שֵׁשׁ עֶשְׂרֵה שָׁעוֹת עוֹזֵר לִי לִישׁוֹן יוֹתֵר טוֹב.",
            exampleNative = "צוֹם לְסֵרוּגִין по шестнадцать часов помогает мне крепче спать.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179008, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_nutrition", transliteration = "diyetа ketogenit",
            original = "דִּיאֵטָה קֵטוֹגֶנִית", translation = "кетогенная диета",
            definition = "תַּפְרִיט עָשִׁיר בְּשֻׁמָּן וְדַל מְאֹד בְּסֻכָּר שֶׁמַּעֲבִיר אֶת הַגּוּף לִשְׂרֵפַת קֵטוֹנִים.",
            definitionNative = "Меню с обилием жира и почти без сахара, переводящее тело на кетоны.",
            example = "דִּיאֵטָה קֵטוֹגֶנִית קִשָּׁה לִתְחָלָה אֲבָל מַרְגִּיעָה אֶת הַתֵּאָבוֹן.",
            exampleNative = "דִּיאֵטָה קֵטוֹגֶנִית тяжела в начале, зато глушит аппетит.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179009, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_nutrition", transliteration = "sintezat khelbon",
            original = "סִינְתֶּזַת חֶלְבּוֹן", translation = "синтез белка (мышечный)",
            definition = "תַּהֲלִיךְ בְּתוֹךְ הַתָּא שֶׁבּוֹ הַשְּׁרִיר בּוֹנֶה רִקְמָה חֲדָשָׁה אַחֲרֵי מַאֲמָץ.",
            definitionNative = "Процесс в клетке — мышца строит новую ткань после нагрузки.",
            example = "סִינְתֶּזַת חֶלְבּוֹן בִּשְׂיָאָהּ בִּשְׁתַּיִם שָׁעוֹת לְאַחַר הַתַּרְגִּיל.",
            exampleNative = "סִינְתֶּזַת חֶלְבּוֹן на пике через два часа после упражнения.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179010, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_nutrition", transliteration = "makhzor pakhmemot",
            original = "מַחֲזוֹר פַּחְמֵימוֹת", translation = "углеводная цикловка",
            definition = "שִׁיטָה שֶׁל יָמִים גְּבוֹהִים וְיָמִים נְמוּכִים שֶׁל סֻכָּרִים בָּלוּחַ הַשְּׁבוּעִי.",
            definitionNative = "Чередование высоких и низких дней по сахарам в недельном плане.",
            example = "מַחֲזוֹר פַּחְמֵימוֹת מְשַׁמֵּר מָסַת שְׁרִיר בִּתְקוּפַת הֲרָזַיָה.",
            exampleNative = "מַחֲזוֹר פַּחְמֵימוֹת сохраняет мышечную массу в период похудения.",
            isFillInBlankSafe = false,
        ),

        // ── health_mental (5) — ментальное здоровье ──
        WordEntity(
            id = 179011, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_mental", transliteration = "kashivut",
            original = "קַשִּׁיבוּת", translation = "осознанность; майндфулнес",
            definition = "מַצָּב שֶׁל תְּשׁוּמַת לֵב מְלֵאָה לָרֶגַע הַנּוֹכְחִי בְּלִי שִׁפּוּט מַחְשְׁבוֹת וְרְגָשׁוֹת.",
            definitionNative = "Состояние полного внимания к текущему моменту без оценки мыслей.",
            example = "תַּרְגּוּל קַשִּׁיבוּת חֲמֵשׁ דַּקּוֹת בַּבֹּקֶר מַרְגִּיעַ לִי אֶת הַיּוֹם.",
            exampleNative = "Пять минут קַשִּׁיבוּת утром делают мне весь день спокойнее.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179012, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_mental", transliteration = "tipul kognitivi-hitnahaguti",
            original = "טִיפּוּל קוֹגְנִיטִיבִי-הִתְנַהֲגוּתִי", translation = "когнитивно-поведенческая терапия",
            definition = "שִׁיטַת פְּסִיכוֹתֶרָפְיָה מֻבְנֵית הַמְּלַמֶּדֶת לְזַהוֹת מַחְשְׁבוֹת מְעַוְּתוֹת וּלְשַׁנּוֹת תְּגוּבוֹת.",
            definitionNative = "Структурированный метод — учит ловить искажённые мысли и менять реакции.",
            example = "טִיפּוּל קוֹגְנִיטִיבִי-הִתְנַהֲגוּתִי הוֹרִיד לָהּ אֶת הַתְּקָפוֹת תּוֹךְ עֶשֶׂר פְּגִישׁוֹת.",
            exampleNative = "טִיפּוּל קוֹגְנִיטִיבִי-הִתְנַהֲגוּתִי сократил ей приступы за десять сессий.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179013, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_mental", transliteration = "tashishut miktso'it",
            original = "תַּשִּׁישׁוּת מִקְצוֹעִית", translation = "профессиональное выгорание",
            definition = "מַצָּב שֶׁל אַזִילָה רִגְשִׁית וַחֲסָר מוֹטִיבַצְיָה בְּעֲבוֹדָה מִתְמַשֶּׁכֶת תַּחַת לַחַץ.",
            definitionNative = "Эмоциональная опустошённость и потеря мотивации от долгой работы под давлением.",
            example = "תַּשִּׁישׁוּת מִקְצוֹעִית הִכְרִיחָה אוֹתָהּ לָקַחַת חֳדָשַׁיִם חֻפְשָׁה בְּלִי תַשְׁלוּם.",
            exampleNative = "תַּשִּׁישׁוּת מִקְצוֹעִית заставила её взять два месяца неоплачиваемого отпуска.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179014, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_mental", transliteration = "higyenat shena",
            original = "הִיגְיֵנַת שֵׁנָה", translation = "гигиена сна",
            definition = "אֹסֶף הֶרְגֵּלִים לִפְנֵי לַיְלָה שֶׁעוֹזְרִים לְהֵרָדֵם מַהֵר וְלִישׁוֹן עָמֹק.",
            definitionNative = "Набор привычек перед ночью — помогают быстрее уснуть и спать глубоко.",
            example = "הִיגְיֵנַת שֵׁנָה בְּסִיסִית כּוֹלֶלֶת הַפְסָקַת מָסָךְ שָׁעָה לִפְנֵי הַמִּטָּה.",
            exampleNative = "Базовая הִיגְיֵנַת שֵׁנָה включает отказ от экранов за час до постели.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179015, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_mental", transliteration = "hafraat kharada",
            original = "הַפְרָעַת חֲרָדָה", translation = "тревожное расстройство",
            definition = "מַחֲלָה נַפְשִׁית מְאֻבְחֶנֶת שֶׁל פַּחַד מֻגְזָם וּמְתַמִּיד הַמַּפְרִיעַ לְתִפְקוּד יוֹמְיוֹמִי.",
            definitionNative = "Диагноз — постоянный непомерный страх, мешающий работать и общаться.",
            example = "הַפְרָעַת חֲרָדָה כְּלָלִית נֶחְשֶׁפֶת לִפְעָמִים רַק אַחֲרֵי שָׁנִים שֶׁל סֵבֶל.",
            exampleNative = "הַפְרָעַת חֲרָדָה общая иногда вскрывается лишь после лет страданий.",
            isFillInBlankSafe = false,
        ),

        // ── health_biomechanics (5) — биомеханика углублённо ──
        WordEntity(
            id = 179016, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_biomechanics", transliteration = "kinematika",
            original = "קִינֶמָטִיקָה", translation = "кинематика (движения)",
            definition = "תְּחוּם הַחוֹקֵר אֶת מַסְלוּל וּמְהִירוּת חֵלְקֵי הַגּוּף בְּלִי לְהִתְיַחֵס לַכֹּחַ.",
            definitionNative = "Раздел — изучает траекторию и скорость частей тела без учёта силы.",
            example = "קִינֶמָטִיקָה שֶׁל זְרִיקַת כַּדּוּר נִבְדֶּקֶת בְּמִצְלֵמוֹת מְהִירוֹת בַּמַּעְבָּדָה.",
            exampleNative = "קִינֶמָטִיקָה броска мяча снимается скоростными камерами в лаборатории.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179017, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_biomechanics", transliteration = "tvakh tnu'a",
            original = "טְוָוח תְּנוּעָה", translation = "амплитуда движения; ROM",
            definition = "הַמֶּרְחָק הַמַּקְסִימָלִי שֶׁמִּפְרָק עוֹבֵר מִקָּצֶה אֶחָד לַשֵּׁנִי בְּלִי כְּפִיָּה.",
            definitionNative = "Максимальное расстояние, которое сустав проходит от края до края без боли.",
            example = "טְוָוח תְּנוּעָה מָלֵא בָּכָתֵף נִמְדָּד בְּזָוִית מַעֲלוֹת מֵעַל הָרֹאשׁ.",
            exampleNative = "Полный טְוָוח תְּנוּעָה плеча меряют углом над головой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179018, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_biomechanics", transliteration = "analizat halikha",
            original = "אֲנָלִיזַת הֲלִיכָה", translation = "анализ походки",
            definition = "בְּדִיקָה הַמְּזַהָה אִי-סִדְרֵי תְּנוּעָה בְּצוּרַת הַצַּעַד וּבְעֹמֶס עַל הַמִּפְרָקִים.",
            definitionNative = "Обследование — ловит сбои движения в форме шага и в нагрузке на суставы.",
            example = "אֲנָלִיזַת הֲלִיכָה בָּמַעְבָּדָה גִּלְּתָה אִי סִימֶטְרְיָה אַחֲרֵי הַשֶּׁבֶר.",
            exampleNative = "אֲנָלִיזַת הֲלִיכָה в лаборатории нашла асимметрию после перелома.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179019, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_biomechanics", transliteration = "tsir anatomi",
            original = "צִיר אַנָטוֹמִי", translation = "анатомическая ось",
            definition = "קַו דִּמְיוֹנִי שֶׁעוֹבֵר דֶּרֶךְ הַגּוּף וּמְשַׁמֵּשׁ נְקֻדַּת אַחֲזוּת לְזָוִית הַתְּנוּעָה.",
            definitionNative = "Воображаемая линия через тело — точка отсчёта для угла движения.",
            example = "מַחְקַר תְּנוּעָה מַגְדִּיר תָּמִיד אֶת צִיר אַנָטוֹמִי לִפְנֵי מְדִידוֹת.",
            exampleNative = "Любое исследование движения сначала задаёт צִיר אַנָטוֹמִי, а затем меряет.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179020, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_biomechanics", transliteration = "merkaz koved",
            original = "מֶרְכַּז כֹּבֶד", translation = "центр тяжести (тела)",
            definition = "הַנְּקֻדָּה שֶׁבָּהּ מִתְרַכֵּז כָּל מִשְׁקַל הַגּוּף וְשֶׁדַּרְכָּהּ עוֹבֵר כֹּחַ הַכְּבִידָה.",
            definitionNative = "Точка, где сосредоточен весь вес тела и через которую идёт сила тяжести.",
            example = "מֶרְכַּז כֹּבֶד נָמוּךְ נוֹתֵן יִתְרוֹן לְמִתְאַבְּקִים מוּל יָרִיב גָּבוֹהַּ.",
            exampleNative = "Низкий מֶרְכַּז כֹּבֶד даёт борцу преимущество против высокого соперника.",
            isFillInBlankSafe = false,
        ),

        // ── health_advanced_training (5) — продвинутые методики тренировок ──
        WordEntity(
            id = 179021, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "health_advanced_training", transliteration = "omes mitkadem",
            original = "עוֹמֶס מִתְקַדֵּם", translation = "прогрессивная нагрузка",
            definition = "עִקָּרוֹן שֶׁל הַעֲלָאָה הֲדַרְגָּתִית בִּכֹבֶד אוֹ בְּכַמּוּת לְכָל אִמּוּן עוֹקֵב.",
            definitionNative = "Принцип постепенного роста веса или объёма из тренировки в тренировку.",
            example = "עוֹמֶס מִתְקַדֵּם שֶׁל קִילוֹ אֶחָד לְשָׁבוּעַ מַעֲלֶה בִּטְחָה אֶת הָרְמָה.",
            exampleNative = "עוֹמֶס מִתְקַדֵּם по килограмму в неделю безопасно поднимает уровень.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179022, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_advanced_training", transliteration = "shavua hafkhata",
            original = "שָׁבוּעַ הַפְחָתָה", translation = "разгрузочная неделя",
            definition = "פֶּרֶק שִׁבְעָה יָמִים שֶׁל אִמּוּנִים קַלִּים בִּכְוָנָה לְמַתֵּן אֶת הָעֲיֵפוּת הַמִּצְטַבֶּרֶת.",
            definitionNative = "Семь дней лёгких занятий специально, чтобы сбить копящуюся усталость.",
            example = "שָׁבוּעַ הַפְחָתָה כָּל אַרְבָּעָה שָׁבוּעוֹת מוֹנֵעַ פְּצִיעוֹת בְּטֶרֶם זְמָן.",
            exampleNative = "שָׁבוּעַ הַפְחָתָה раз в четыре недели бережёт от ранних травм.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179023, setId = 1790, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_advanced_training", transliteration = "hipertrofiya",
            original = "הִיפֶּרְטְרוֹפְיָה", translation = "гипертрофия (мышечный рост)",
            definition = "גְּדִילָה שֶׁל סִיבֵי שְׁרִיר בְּעֹבִי מִתְּגוּבָה לְעוֹמֶס חוֹזֵר וּמְבֻקָּר.",
            definitionNative = "Утолщение мышечных волокон в ответ на повторную и контролируемую нагрузку.",
            example = "הִיפֶּרְטְרוֹפְיָה מֵרַבִּית מִתְקַבֶּלֶת בְּחֶזְרוֹת שֶׁל שְׁמוֹנֶה עַד שְׁתֵּים עֶשְׂרֵה.",
            exampleNative = "Максимум הִיפֶּרְטְרוֹפְיָה получают на повторах от восьми до двенадцати.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179024, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_advanced_training", transliteration = "saf anaerobi",
            original = "סַף אַנְאֵרוֹבִי", translation = "анаэробный порог",
            definition = "הָעֲצִימוּת שֶׁמֵּעָלֶיהָ הַגּוּף לֹא מַסְפִּיק לְהַזִּין שְׁרִירִים בְּחַמְצָן בִּלְבַד.",
            definitionNative = "Интенсивность, выше которой телу уже не хватает одного кислорода.",
            example = "סַף אַנְאֵרוֹבִי גָּבוֹהַּ מַרְשֶׁה לְרָץ לְשַׁמֵּר קֶצֶב מָרָתוֹן בְּלִי הִתְמוֹטְטוּת.",
            exampleNative = "Высокий סַף אַנְאֵרוֹבִי даёт бегуну держать марафонский темп без срыва.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179025, setId = 1790, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "health_advanced_training", transliteration = "tkufat khidud",
            original = "תְּקוּפַת חִדּוּד", translation = "тейпер; финишная разгрузка перед стартом",
            definition = "שָׁבוּעוֹת אֲחַרוֹנִים לִפְנֵי תַחֲרוּת שֶׁבָּהֶם מַפְחִיתִים נֶפַח כְּדֵי לְהַגִּיעַ רַעֲנָן.",
            definitionNative = "Последние недели перед стартом — снижают объём, чтобы прийти свежим.",
            example = "תְּקוּפַת חִדּוּד שֶׁל שְׁלוֹשָׁה שָׁבוּעוֹת מַעֲנִיקָה רַגְלַיִם קַלּוֹת בַּזִּינוּק.",
            exampleNative = "תְּקוּפַת חִדּוּד на три недели даёт лёгкие ноги на старте.",
            isFillInBlankSafe = false,
        ),
    )
}
