package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Architecture, level 4 (1 set, 25 words).
 * Профессиональная лексика проектирования и строительства: фундаменты,
 * несущие конструкции, материалы, чертежи, инженерные стили XX–XXI вв.
 *
 * Set 1706:
 *   1706 (level 4, EPIC + LEGENDARY) — профессиональная архитектура: проектирование, конструкции
 *
 * Не пересекается с уже существующими сетами темы «Архитектура» (1086, 1259, 1260):
 * там покрыты базовые элементы, классические стили и философия пространства,
 * а здесь — инженерия, материалы и стилевые направления модерна/постмодерна.
 *
 * Распределение редкостей: 15 EPIC + 10 LEGENDARY (2 смежных уровня).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewArchL4 {

    val sets = listOf(
        WordSetEntity(
            id = 1706, languagePair = "he-ru", orderIndex = 1706,
            name = "Архитектура",
            description = "Профессиональная архитектура: проектирование, конструкции",
            topic = "Архитектура", level = 4,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1706 — Архитектура: профессиональный (EPIC + LEGENDARY, C1–C2)
        // 5 групп × 5 слов: foundations, materials, design, styles_pro, classical_pro
        // ══════════════════════════════════════════════════════════════════════

        // ── architecture_foundations (5) — несущие конструкции ──
        WordEntity(
            id = 170601, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "architecture_foundations", transliteration = "yesod",
            original = "יְסוֹד", translation = "фундамент",
            definition = "הַחֵלֶק הַתַּחְתּוֹן שֶׁל הַמִּבְנֶה הַנּוֹשֵׂא אֶת כָּל מִשְׁקַל הַבַּיִת.",
            definitionNative = "Нижняя часть здания, передающая нагрузку на грунт.",
            example = "הַיְסוֹד נִבְנָה מִבֶּטוֹן מְזֻיָּן עָמֹק.",
            exampleNative = "יְסוֹד залит из глубокого армированного бетона.",
         fillInBlankExclusions = listOf(170603L, 170604L, 170605L)),
        WordEntity(
            id = 170602, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "architecture_foundations", transliteration = "sheled mivne",
            original = "שֶׁלֶד מִבְנֶה", translation = "каркас здания",
            definition = "מַעֲרֶכֶת קוֹרוֹת וְעַמּוּדִים שֶׁמַּחֲזִיקָה אֶת הַבַּיִת מִבִּפְנִים.",
            definitionNative = "Внутренняя система балок и стоек, держащая всё здание.",
            example = "שֶׁלֶד מִבְנֶה מִפְּלָדָה הוּא הָעֲמִיד בְּיוֹתֵר.",
            exampleNative = "Стальной שֶׁלֶד מִבְנֶה — самый прочный из всех видов.",
         fillInBlankExclusions = listOf(170605L)),
        WordEntity(
            id = 170603, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "architecture_foundations", transliteration = "zikuy",
            original = "זִיּוּן", translation = "арматура",
            definition = "מוֹטוֹת בַּרְזֶל הַטְּמוּנִים בְּתוֹךְ הַבֶּטוֹן לְחִזּוּקוֹ.",
            definitionNative = "Стальные стержни, спрятанные внутри бетона ради прочности.",
            example = "פּוֹעֲלִים סִדְּרוּ אֶת הַזִּיּוּן לִפְנֵי שְׁפִיכַת הַבֶּטוֹן.",
            exampleNative = "Рабочие уложили זִיּוּן перед заливкой бетона.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170604, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "architecture_foundations", transliteration = "mekhitsa",
            original = "מְחִיצָה", translation = "перегородка",
            definition = "קִיר פְּנִימִי קַל הַמַּפְרִיד חֲדָרִים בְּלִי לָשֵׂאת מִשְׁקַל.",
            definitionNative = "Лёгкая внутренняя стена, делящая комнаты без нагрузки.",
            example = "פֵּרַקְנוּ אֶת הַמְּחִיצָה בֵּין הַסָּלוֹן וְהַמִּטְבָּח.",
            exampleNative = "Мы снесли מְחִיצָה между гостиной и кухней.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170605, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "architecture_foundations", transliteration = "pilon",
            original = "פִּילוֹן", translation = "пилон",
            definition = "מִגְדָּל אוֹ עַמּוּד גָּבוֹהַּ הַמַּחֲזִיק כְּבָלִים שֶׁל גֶּשֶׁר תָּלוּי.",
            definitionNative = "Башня или стойка, держащая тросы висячего моста.",
            example = "הַפִּילוֹן הַגָּבוֹהַּ נִרְאֶה גַּם מֵרְחוֹק רַב.",
            exampleNative = "Высокий פִּילוֹן виден даже с большого расстояния.",
         fillInBlankExclusions = listOf(170601L, 170603L, 170604L)),

        // ── architecture_materials (5) — современные стройматериалы ──
        WordEntity(
            id = 170606, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "architecture_materials", transliteration = "beton mezuyan",
            original = "בֶּטוֹן מְזֻיָּן", translation = "железобетон",
            definition = "תַּעֲרֹבֶת חֲזָקָה שֶׁל בֶּטוֹן עִם שִׁלְדַּת מַתֶּכֶת בְּתוֹכוֹ.",
            definitionNative = "Прочная смесь бетона со стальной арматурой внутри.",
            example = "הַגֶּשֶׁר נִבְנָה כֻּלּוֹ מִבֶּטוֹן מְזֻיָּן.",
            exampleNative = "Мост построили целиком из בֶּטוֹן מְזֻיָּן.",
         fillInBlankExclusions = listOf(170608L, 170609L)),
        WordEntity(
            id = 170607, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "architecture_materials", transliteration = "geves",
            original = "גֶּבֶס", translation = "гипс; гипсокартон",
            definition = "חֹמֶר רַךְ לְבָנִיָּה פְּנִימִית שֶׁל קִירוֹת קַלִּים.",
            definitionNative = "Лёгкий материал для внутренних перегородок и потолков.",
            example = "הַקִּירוֹת הַפְּנִימִיִּים נִבְנוּ מִגֶּבֶס.",
            exampleNative = "Внутренние перегородки сделаны из גֶּבֶס.",
         fillInBlankExclusions = listOf(170610L)),
        WordEntity(
            id = 170608, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "architecture_materials", transliteration = "bidud termi",
            original = "בִּדּוּד תֶּרְמִי", translation = "теплоизоляция",
            definition = "שִׁכְבָה הַמּוֹנַעַת אֲבֵדַת חֹם מֵהַבַּיִת בַּחֹרֶף.",
            definitionNative = "Слой, удерживающий тепло в доме зимой и прохладу летом.",
            example = "הַקַּבְלָן הוֹסִיף בִּדּוּד תֶּרְמִי לַקִּירוֹת הַחִיצוֹנִיִּים.",
            exampleNative = "Подрядчик добавил בִּדּוּד תֶּרְמִי к наружным стенам.",
         fillInBlankExclusions = listOf(170606L, 170607L, 170609L, 170610L)),
        WordEntity(
            id = 170609, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "architecture_materials", transliteration = "aitum",
            original = "אִטּוּם", translation = "гидроизоляция",
            definition = "עֲבוֹדָה הַמּוֹנַעַת חֲדִירַת מַיִם דֶּרֶךְ הַגָּג אוֹ הַקִּירוֹת.",
            definitionNative = "Защитный слой против протечек влаги через крышу или стены.",
            example = "אַחֲרֵי הַגֶּשֶׁם גִּלִּינוּ שֶׁהָאִטּוּם נִפְגַּם.",
            exampleNative = "После дождя обнаружили, что אִטּוּם повреждён.",
         fillInBlankExclusions = listOf(170606L, 170608L)),
        WordEntity(
            id = 170610, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "architecture_materials", transliteration = "sheleg",
            original = "טִיט", translation = "цементный раствор",
            definition = "תַּעֲרֹבֶת רְטֻבָּה הַמְחַבֶּרֶת לְבֵנִים בִּשְׁעַת הַבְּנִיָּה.",
            definitionNative = "Влажная смесь, скрепляющая кирпичи во время кладки.",
            example = "הַבַּנַּאי עֵרְבֵב טִיט טָרִי לִפְנֵי הַשָּׁעָה הַשְּׁמִינִית.",
            exampleNative = "Каменщик замешал свежий טִיט до восьми утра.",
         fillInBlankExclusions = listOf(170607L)),

        // ── architecture_design (5) — проектирование и чертежи ──
        WordEntity(
            id = 170611, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "architecture_design", transliteration = "sirtut",
            original = "שִׂרְטוּט", translation = "чертёж",
            definition = "צִיּוּר מְדֻיָּק שֶׁל הַמִּבְנֶה עִם מְמַדִּים וְקַוֵּי מִדָּה.",
            definitionNative = "Точный графический документ с размерами и масштабом.",
            example = "הָאַדְרִיכָל הִגִּישׁ אֶת הַשִּׂרְטוּט הַסּוֹפִי לָעִירִיָּה.",
            exampleNative = "Архитектор сдал итоговый שִׂרְטוּט в мэрию.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170612, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "architecture_design", transliteration = "skitsa",
            original = "סְקִיצָה", translation = "эскиз",
            definition = "שִׂרְטוּט רִאשׁוֹנִי וְגַס שֶׁל רַעְיוֹן הַמִּבְנֶה לְפְנֵי הַתָּכְנִית.",
            definitionNative = "Первый набросок идеи здания до точного проекта.",
            example = "הוּא צִיֵּר סְקִיצָה עַל מַפִּית בַּמִּסְעָדָה.",
            exampleNative = "Он набросал סְקִיצָה прямо на салфетке в кафе.",
         fillInBlankExclusions = listOf(170611L, 170613L, 170614L, 170615L)),
        WordEntity(
            id = 170613, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "architecture_design", transliteration = "khatakh",
            original = "חֲתָךְ", translation = "разрез (чертёж)",
            definition = "הַצָּגָה אֳנָכִית שֶׁל הַמִּבְנֶה כְּאִלּוּ נֶחְתַּךְ בְּסַכִּין דִּמְיוֹנִית.",
            definitionNative = "Вертикальное сечение здания, показывающее устройство этажей.",
            example = "הַחֲתָךְ מַרְאֶה אֶת גֹּבַהּ הַתִּקְרָה בְּכָל קוֹמָה.",
            exampleNative = "חֲתָךְ показывает высоту потолков на каждом этаже.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170614, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "architecture_design", transliteration = "tokhnit av",
            original = "תָּכְנִית אָב", translation = "генеральный план",
            definition = "מִסְמָךְ הַמַּגְדִּיר אֶת הַפִּתּוּחַ הָעֲתִידִי שֶׁל שְׁכוּנָה אוֹ עִיר.",
            definitionNative = "Документ, описывающий перспективное развитие района или города.",
            example = "תָּכְנִית אָב חֲדָשָׁה נֶחְתְּמָה אַחֲרֵי שְׁנָתַיִם שֶׁל וִיכּוּחִים.",
            exampleNative = "Новый תָּכְנִית אָב утвердили после двух лет дискуссий.",
         fillInBlankExclusions = listOf(170612L, 170615L)),
        WordEntity(
            id = 170615, setId = 1706, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "architecture_design", transliteration = "perspektiva",
            original = "פֶּרְסְפֶּקְטִיבָה", translation = "перспектива",
            definition = "צִיּוּר תְּלַת־מֵמַדִּי הַמַּדְמֶה אֵיךְ יֵרָאֶה הַמִּבְנֶה לְעוֹבֵר אֹרַח.",
            definitionNative = "Объёмный рисунок здания глазами случайного прохожего.",
            example = "הַפֶּרְסְפֶּקְטִיבָה שִׁכְנְעָה אֶת הַוַּעֲדָה לְאַשֵּׁר אֶת הַפְּרוֹיֶקְט.",
            exampleNative = "פֶּרְסְפֶּקְטִיבָה убедила комиссию утвердить проект.",
         fillInBlankExclusions = listOf(170611L, 170612L, 170613L)),

        // ── architecture_styles_pro (5) — направления XX–XXI вв. ──
        WordEntity(
            id = 170616, setId = 1706, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "architecture_styles_pro", transliteration = "modernizm",
            original = "מוֹדֶרְנִיזְם", translation = "модернизм",
            definition = "תְּנוּעָה אַדְרִיכָלִית שֶׁל הַמֵּאָה הָעֶשְׂרִים הַדּוֹחָה קִשּׁוּטִים מְיֻתָּרִים.",
            definitionNative = "Течение XX века, отказавшееся от лишнего декора в пользу функции.",
            example = "הַבִּנְיָן הַזֶּה הוּא דֻּגְמָה קְלָאסִית לְמוֹדֶרְנִיזְם.",
            exampleNative = "Это здание — классический пример מוֹדֶרְנִיזְם.",
         fillInBlankExclusions = listOf(170618L, 170619L, 170620L)),
        WordEntity(
            id = 170617, setId = 1706, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "architecture_styles_pro", transliteration = "adrikhalut organit",
            original = "אַדְרִיכָלוּת אוֹרְגָנִית", translation = "органическая архитектура",
            definition = "גִּישָׁה הַמְשַׁלֶּבֶת אֶת הַמִּבְנֶה בַּנּוֹף וּמְחַקָּה צוּרוֹת מִן הַטֶּבַע.",
            definitionNative = "Подход, вписывающий здание в ландшафт и подражающий формам природы.",
            example = "הַבַּיִת הָעוֹמֵד מֵעַל הַמַּפַּל הוּא סֵמֶל אַדְרִיכָלוּת אוֹרְגָנִית.",
            exampleNative = "Дом над водопадом — символ אַדְרִיכָלוּת אוֹרְגָנִית.",
         fillInBlankExclusions = listOf(170616L, 170618L, 170619L, 170620L)),
        WordEntity(
            id = 170618, setId = 1706, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "architecture_styles_pro", transliteration = "post-modernizm",
            original = "פּוֹסְט־מוֹדֶרְנִיזְם", translation = "постмодернизм",
            definition = "תְּגוּבָה לַסִּגְנוֹן הַמּוֹדֶרְנִי הַמַּחֲזִירָה הוּמוֹר וְצִיטוּטִים מֵהֶעָבָר.",
            definitionNative = "Реакция на сухой модернизм с возвратом игры цитатами и иронии.",
            example = "פּוֹסְט־מוֹדֶרְנִיזְם הִכְנִיס שׁוּב צֶבַע וּמִשְׂחָק לָעִיר.",
            exampleNative = "פּוֹסְט־מוֹדֶרְנִיזְם вернул в город цвет и игру форм.",
         fillInBlankExclusions = listOf(170616L, 170619L, 170620L)),
        WordEntity(
            id = 170619, setId = 1706, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "architecture_styles_pro", transliteration = "dekonstruktivizm",
            original = "דֵּקוֹנְסְטְרוּקְטִיבִיזְם", translation = "деконструктивизм",
            definition = "סִגְנוֹן שֶׁשּׁוֹבֵר אֶת הַסִּימֶטְרְיָה וְיוֹצֵר רֹשֶׁם שֶׁל קְרִיסָה מְבֻיֶּמֶת.",
            definitionNative = "Стиль, ломающий симметрию ради эффекта управляемого распада.",
            example = "מוּזֵיאוֹן גֵּהְרִי מַדְגִּים דֵּקוֹנְסְטְרוּקְטִיבִיזְם בְּשִׂיא טֹהַר.",
            exampleNative = "Музей Гери — דֵּקוֹנְסְטְרוּקְטִיבִיזְם в чистом виде.",
         fillInBlankExclusions = listOf(170616L, 170617L, 170618L, 170620L)),
        WordEntity(
            id = 170620, setId = 1706, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "architecture_styles_pro", transliteration = "metabolizm",
            original = "מֶטָבּוֹלִיזְם", translation = "метаболизм (архитектура)",
            definition = "תְּנוּעָה יַפָּנִית שֶׁתִּכְנְנָה עָרִים כְּתָאִים מִתְחַלְּפִים בְּמוֹ הַזְּמַן.",
            definitionNative = "Японское движение, проектировавшее города как сменяемые клетки.",
            example = "מִגְדַּל הַקַּפְּסוּלוֹת בְּטוֹקְיוֹ הָיָה סֵמֶל הַמֶּטָבּוֹלִיזְם.",
            exampleNative = "Капсульная башня в Токио стала символом מֶטָבּוֹלִיזְם.",
            isFillInBlankSafe = false,
        ),

        // ── architecture_classical_pro (5) — классические термины и детали ──
        WordEntity(
            id = 170621, setId = 1706, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "architecture_classical_pro", transliteration = "pilaster",
            original = "פִּילַסְטֶר", translation = "пилястра",
            definition = "עַמּוּד שָׁטוּחַ הַבּוֹלֵט מְעַט מִן הַקִּיר וּמְשַׁמֵּשׁ קִשּׁוּט בִּלְבַד.",
            definitionNative = "Плоский выступ из стены, имитирующий колонну для украшения.",
            example = "פִּילַסְטֶר עָדִין מַעֲטֵר אֶת חֲזִית הַבַּיִת הַקְּלָאסִי.",
            exampleNative = "Изящный פִּילַסְטֶר украшает фасад классического особняка.",
         fillInBlankExclusions = listOf(170605L, 170622L, 170623L, 170624L, 170625L)),
        WordEntity(
            id = 170622, setId = 1706, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "architecture_classical_pro", transliteration = "kontrafors",
            original = "קוֹנְטְרָפוֹרְס", translation = "контрфорс",
            definition = "תּוֹמֵךְ אֳנָכִי מָסִיבִי הַמַּחֲזִיק קִיר חִיצוֹנִי גָּבוֹהַּ מִפְּנֵי קְרִיסָה.",
            definitionNative = "Массивный наружный упор, удерживающий высокую стену собора.",
            example = "הַקְּתֶדְרָלָה הַגּוֹתִית נִתְמֶכֶת בְּקוֹנְטְרָפוֹרְס מִן הַחוּץ.",
            exampleNative = "Готический собор поддержан קוֹנְטְרָפוֹרְס снаружи.",
         fillInBlankExclusions = listOf(170621L, 170623L, 170624L, 170625L)),
        WordEntity(
            id = 170623, setId = 1706, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "architecture_classical_pro", transliteration = "friz",
            original = "פְרִיז", translation = "фриз",
            definition = "פַּס מְעֻטָּר אֳפֻקִּי שֶׁעוֹבֵר לְאֹרֶךְ חֵלֶק עֶלְיוֹן שֶׁל קִיר.",
            definitionNative = "Узкая декоративная полоса наверху стены или в антаблементе.",
            example = "הַפְרִיז עַל הַמּוּזֵיאוֹן מְצַיֵּר סְצֵנוֹת מִן הַמִּיתוֹלוֹגְיָה.",
            exampleNative = "פְרִיז на музее изображает мифологические сцены.",
         fillInBlankExclusions = listOf(170621L, 170622L, 170624L, 170625L)),
        WordEntity(
            id = 170624, setId = 1706, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "architecture_classical_pro", transliteration = "timpanon",
            original = "טִימְפָּנוֹן", translation = "тимпан",
            definition = "מִשְׁטָח מְשֻׁלָּשׁ מְעֻטָּר שֶׁמֵּעַל הַכְּנִיסָה הָרָאשִׁית שֶׁל הַמִּקְדָּשׁ.",
            definitionNative = "Треугольное декоративное поле над парадным входом храма.",
            example = "טִימְפָּנוֹן מְפֹאָר עִטֵּר אֶת הַכְּנִיסָה לַתֵּיאַטְרוֹן.",
            exampleNative = "Богато украшенный טִימְפָּנוֹן венчал вход в театр.",
         fillInBlankExclusions = listOf(170605L, 170621L, 170622L, 170623L, 170625L)),
        WordEntity(
            id = 170625, setId = 1706, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "architecture_classical_pro", transliteration = "antablement",
            original = "אַנְטַבְּלֶמֶנְט", translation = "антаблемент",
            definition = "חֵלֶק עֶלְיוֹן שֶׁל הַסֵּדֶר הַקְּלָאסִי הַמּוּנָח עַל הָעַמּוּדִים.",
            definitionNative = "Верхняя часть классического ордера, лежащая на колоннах.",
            example = "הָאַנְטַבְּלֶמֶנְט הַשִּׁישׁ הַלָּבָן הִדְהֵד יְוָנִית עַתִּיקָה.",
            exampleNative = "Белый мраморный אַנְטַבְּלֶמֶנְט отсылал к античной Греции.",
         fillInBlankExclusions = listOf(170621L, 170622L, 170623L, 170624L)),
    )
}
