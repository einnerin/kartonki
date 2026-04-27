package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Здоровье и фитнес", уровень L5 (носитель языка).
 *
 * Set 1791: «Здоровье и фитнес» — носитель языка (EPIC+LEGENDARY):
 *           эндокринология, физиология, патология, фармакология, клинические исследования.
 *           Профессиональная лексика для биохакеров, спортивных врачей и
 *           продвинутых читателей научпопа на иврите.
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   health_endocrine    — эндокринология: кортизол, инсулиновая чувств., щитовидка, лептин
 *   health_physiology   — физиология: гомеостаз, митохондрии, нейропластичность, аутофагия
 *   health_pathology    — патология: воспаление, аутоиммун, оксид. стресс, мет.синдром
 *   health_pharmacology — фармакология: T½, биодоступность, взаимод., off-label
 *   health_clinical     — клиника: РКИ, ноцебо, доказат. практика, лонгитюд, биомаркер
 *
 * Word IDs: setId × 100 + position (179101..179125).
 *
 * Пересечения с другими наборами:
 *   - HealthFitness L1L2L3 (1727-1729) — основы/базовый/средний; здесь не повторяются.
 *   - HealthFitness L4 (1790, параллельная задача) — продвинутый; здесь не повторяются.
 *   - Medicine V2 — клинические термины общего пользования; в этом наборе намеренно
 *     избегаются: вместо «фармакокинетика» — «период полураспада», вместо «плацебо» —
 *     антоним «ноцебо», «синдром» заменён на «תִּסְמֹנֶת», «биомаркер» — латиница.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewHealthFitnessL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1791, languagePair = "he-ru", orderIndex = 1791,
            name = "Здоровье и фитнес",
            description = "Уровень носителя: эндокринология, физиология, патология, фармакология, клиника",
            topic = "Здоровье и фитнес", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1791 — Здоровье и фитнес: носитель языка (L5, EPIC+LEGENDARY)
        // 5 групп × 5 слов: endocrine, physiology, pathology, pharmacology, clinical
        // ══════════════════════════════════════════════════════════════════════

        // ── health_endocrine (5) — гормоны и эндокринная система ──
        WordEntity(
            id = 179101, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_endocrine", transliteration = "kortizol",
            original = "כּוֹרְטִיזוֹל", translation = "кортизол",
            definition = "הוֹרְמוֹן שֶׁהַגּוּף מַפְרִישׁ בְּזְמַן לַחַץ אוֹ סַכָּנָה כְּדֵי לְגַיֵּס אֶנֶרְגְיָה.",
            definitionNative = "Гормон, который тело выбрасывает при стрессе или опасности — чтобы поднять энергию.",
            example = "רָמַת כּוֹרְטִיזוֹל גְּבוֹהָה בַּבֹּקֶר שׁוֹבֶרֶת אֶת הַשֵּׁנָה הָעֲמֻקָּה.",
            exampleNative = "Высокий уровень כּוֹרְטִיזוֹל утром ломает глубокий сон.",
         fillInBlankExclusions = listOf(179102L, 179103L, 179104L, 179105L)),
        WordEntity(
            id = 179102, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_endocrine", transliteration = "regishut le-insulin",
            original = "רְגִישׁוּת לְאִינְסוּלִין", translation = "чувствительность к инсулину",
            definition = "מִדַּת הַתְּגוּבָה שֶׁל הַתָּאִים לַהוֹרְמוֹן הַמּוֹבִיל סוּכָּר לְתוֹךְ הַשְּׁרִיר.",
            definitionNative = "Насколько клетки откликаются на гормон, который тащит сахар в мышцу.",
            example = "אִמּוּן כֹּחַ קָבוּעַ מְשַׁפֵּר רְגִישׁוּת לְאִינְסוּלִין תּוֹךְ חֳדָשַׁיִם.",
            exampleNative = "Регулярная силовая улучшает רְגִישׁוּת לְאִינְסוּלִין за пару месяцев.",
         fillInBlankExclusions = listOf(179101L, 179103L, 179104L, 179105L)),
        WordEntity(
            id = 179103, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_endocrine", transliteration = "hormon hatris",
            original = "הוֹרְמוֹן הַתְּרִיס", translation = "тиреоидный гормон",
            definition = "חֹמֶר שֶׁבַּלּוּטָה צַוָּארִית מְפִיקָה כְּדֵי לְקַבֵּעַ אֶת קֶצֶב הַחִילּוּף בַּגּוּף.",
            definitionNative = "Вещество, что шейная железа делает — задаёт скорость обмена в теле.",
            example = "חֹסֶר בְּהוֹרְמוֹן הַתְּרִיס גּוֹרֵם לַעֲיֵפוּת כְּרוֹנִית וְעֲלִיָּה בַּמִּשְׁקָל.",
            exampleNative = "Нехватка הוֹרְמוֹן הַתְּרִיס даёт хроническую усталость и набор веса.",
         fillInBlankExclusions = listOf(179101L, 179102L, 179104L, 179105L)),
        WordEntity(
            id = 179104, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_endocrine", transliteration = "teshishut yoteret ha-kilya",
            original = "תְּשִׁישׁוּת יוֹתֶרֶת הַכִּלְיָה", translation = "надпочечниковая усталость",
            definition = "מַצָּב שֶׁבּוֹ הַבְּלוֹטוֹת מֵעַל הַכְּלָיוֹת אֵינָן מַסְפִּיקוֹת לְהָגִיב לְלַחַץ מִמֻשָּׁךְ.",
            definitionNative = "Состояние, когда железы над почками уже не успевают отвечать на долгий стресс.",
            example = "אַחֲרֵי שָׁנָה שֶׁל לְחָצִים בַּעֲבוֹדָה הִיא חָוְתָה תְּשִׁישׁוּת יוֹתֶרֶת הַכִּלְיָה.",
            exampleNative = "После года рабочих стрессов она пережила תְּשִׁישׁוּת יוֹתֶרֶת הַכִּלְיָה.",
         fillInBlankExclusions = listOf(179101L, 179102L, 179103L, 179105L)),
        WordEntity(
            id = 179105, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_endocrine", transliteration = "leptin",
            original = "לֵפְּטִין", translation = "лептин",
            definition = "הוֹרְמוֹן שֶׁתָּאֵי הַשֻּׁמָּן שׁוֹלְחִים לַמֹּחַ כְּדֵי לוֹמַר שֶׁכְּבָר אָכַלְנוּ דַּי.",
            definitionNative = "Гормон, который жировые клетки шлют в мозг — сообщить, что мы уже наелись.",
            example = "תְּנַגְדוּת לְלֵפְּטִין שׁוֹמֶרֶת תְּחוּשַׁת רָעָב גַּם אַחֲרֵי אֲרוּחָה גְּדוֹלָה.",
            exampleNative = "Резистентность к לֵפְּטִין держит чувство голода даже после большой еды.",
         fillInBlankExclusions = listOf(179101L, 179102L, 179103L, 179104L)),

        // ── health_physiology (5) — клеточная физиология и регуляция ──
        WordEntity(
            id = 179106, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_physiology", transliteration = "homeostazis",
            original = "הוֹמֵיאוֹסְטָזִיס", translation = "гомеостаз",
            definition = "הַיְּכֹלֶת שֶׁל הַגּוּף לִשְׁמֹר עַל סְבִיבָה פְּנִימִית יַצִּיבָה לַמְרוֹת שִׁנּוּיִים מִבַּחוּץ.",
            definitionNative = "Способность тела держать ровную внутреннюю среду, несмотря на внешние сдвиги.",
            example = "אֲפִילוּ בַּמִּדְבָּר הַחַם הַגּוּף שׁוֹמֵר עַל הוֹמֵיאוֹסְטָזִיס שֶׁל טֶמְפֶּרָטוּרָה.",
            exampleNative = "Даже в жаркой пустыне тело держит הוֹמֵיאוֹסְטָזִיס температуры.",
         fillInBlankExclusions = listOf(179107L, 179108L, 179109L, 179110L)),
        WordEntity(
            id = 179107, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_physiology", transliteration = "tifkud mitokhondriya",
            original = "תִּפְקוּד מִיטוֹכוֹנְדְּרְיָה", translation = "функция митохондрий",
            definition = "הַפְּעוּלָה שֶׁל מִפְעָלוֹת הָאֶנֶרְגְיָה הַזְּעִירוֹת בְּתוֹךְ כָּל תָּא חַי.",
            definitionNative = "Работа крошечных энергетических заводов — внутри каждой живой клетки.",
            example = "תִּפְקוּד מִיטוֹכוֹנְדְּרְיָה לָקוּי קָשׁוּר לְהַרְבֵּה מַחֲלוֹת הַזִּקְנָה.",
            exampleNative = "Слабый תִּפְקוּד מִיטוֹכוֹנְדְּרְיָה связан со многими старческими болезнями.",
         fillInBlankExclusions = listOf(179106L, 179108L, 179109L, 179110L)),
        WordEntity(
            id = 179108, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_physiology", transliteration = "neuroplastiyut",
            original = "נוֹירוֹפְּלָסְטִיּוּת", translation = "нейропластичность",
            definition = "יְכֹלֶת הַמֹּחַ לִיצֹר וְלִשְׁנוֹת קִשּׁוּרִים בֵּין תָּאֵי עֲצָבִים בְּכָל גִּיל.",
            definitionNative = "Способность мозга строить и менять связи между нервными клетками в любом возрасте.",
            example = "נוֹירוֹפְּלָסְטִיּוּת מְאַפְשֶׁרֶת לְמִי שֶׁעָבַר שָׁבָץ לִלְמֹד מֵחָדָשׁ לְדַבֵּר.",
            exampleNative = "נוֹירוֹפְּלָסְטִיּוּת позволяет тому, кто пережил инсульт, заново учиться говорить.",
         fillInBlankExclusions = listOf(179106L, 179107L, 179109L, 179110L)),
        WordEntity(
            id = 179109, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_physiology", transliteration = "autofagiya",
            original = "אוֹטוֹפָגִיָה", translation = "аутофагия",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ הַתָּא אוֹכֵל וּמְחַזֵּר רְכִיבִים פְּגוּמִים שֶׁלּוֹ בְּעַצְמוֹ.",
            definitionNative = "Процесс, в котором клетка сама поедает и перерабатывает свои испорченные части.",
            example = "צוֹם מְמֻשָּׁךְ מַפְעִיל אוֹטוֹפָגִיָה וּמְנַקֶּה אֶת הַתָּא מִזְּבָלִים.",
            exampleNative = "Долгий пост запускает אוֹטוֹפָגִיָה и чистит клетку от мусора.",
         fillInBlankExclusions = listOf(179106L, 179107L, 179108L, 179110L)),
        WordEntity(
            id = 179110, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_physiology", transliteration = "telomer",
            original = "טֶלוֹמֵר", translation = "теломер",
            definition = "כֹּבַע מָגֵן בַּקְצֵה הַכְּרוֹמוֹסוֹם שֶׁמִּתְקַצֵּר בְּכָל חֲלֻקַּת תָּא.",
            definitionNative = "Защитный колпачок на конце хромосомы — он укорачивается с каждым делением клетки.",
            example = "אֹרֶךְ טֶלוֹמֵר מְשַׁמֵּשׁ הַיּוֹם כְּסַמָּן בִּיוֹלוֹגִי שֶׁל הַזְדַּקְּנוּת.",
            exampleNative = "Длина טֶלוֹמֵר сегодня служит биомаркером старения.",
         fillInBlankExclusions = listOf(179106L, 179107L, 179108L, 179109L)),

        // ── health_pathology (5) — патологические процессы ──
        WordEntity(
            id = 179111, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_pathology", transliteration = "daleket khronit",
            original = "דַּלֶּקֶת כְּרוֹנִית", translation = "хроническое воспаление",
            definition = "תְּגוּבָה חִיסּוּנִית מַתְמֶשֶׁת בְּעוֹצְמָה נְמוּכָה שֶׁפּוֹגַעַת בִּרְקָמוֹת בְּלִי כְּאֵב חַד.",
            definitionNative = "Длительная иммунная реакция тлеющей силы — портит ткани без острой боли.",
            example = "דַּלֶּקֶת כְּרוֹנִית בָּמְעַיִם נֶחְשֶׁבֶת לְשֹׁרֶשׁ מַחֲלוֹת לֵב רַבּוֹת.",
            exampleNative = "דַּלֶּקֶת כְּרוֹנִית в кишечнике считается корнем многих сердечных болезней.",
         fillInBlankExclusions = listOf(179112L, 179113L, 179114L, 179115L)),
        WordEntity(
            id = 179112, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_pathology", transliteration = "makhala autoimunit",
            original = "מַחֲלָה אוֹטוֹאִימוּנִית", translation = "аутоиммунное заболевание",
            definition = "מַצָּב שֶׁבּוֹ מַעֲרֶכֶת הַחִיסּוּן תּוֹקֶפֶת אֶת רִקְמוֹת הַגּוּף שֶׁלָּהּ עַצְמָהּ.",
            definitionNative = "Состояние, когда иммунка нападает на собственные ткани тела.",
            example = "טִיפּוּלִים בְּמַחֲלָה אוֹטוֹאִימוּנִית מְכַוְּנִים לְהַרְגִּיעַ אֶת הַחִיסּוּן.",
            exampleNative = "Терапии при מַחֲלָה אוֹטוֹאִימוּנִית нацелены успокоить иммунную систему.",
         fillInBlankExclusions = listOf(179111L, 179113L, 179114L, 179115L)),
        WordEntity(
            id = 179113, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_pathology", transliteration = "okets khamtsoni",
            original = "עֹקֶץ חַמְצוֹנִי", translation = "окислительный стресс",
            definition = "מַצָּב שֶׁל עֹדֶף רַדִּיקָלִים חָפְשִׁיִּים שֶׁפּוֹגְעִים בִּדְנָ\"א וּבִקְרוּמֵי תָאִים.",
            definitionNative = "Перебор свободных радикалов — повреждают ДНК и клеточные мембраны.",
            example = "עֹקֶץ חַמְצוֹנִי מוּגְבָּר מַחֲרִיף סוּכֶּרֶת וּמַחֲלוֹת לֵב.",
            exampleNative = "Усиленный עֹקֶץ חַמְצוֹנִי утяжеляет диабет и сердечные болезни.",
         fillInBlankExclusions = listOf(179111L, 179112L, 179114L, 179115L)),
        WordEntity(
            id = 179114, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_pathology", transliteration = "tismonet metabolit",
            original = "תִּסְמֹנֶת מֶטָבּוֹלִית", translation = "метаболический синдром",
            definition = "צֵרוּף שֶׁל הַשְׁמָנָה בִּטְנִית, סוּכָּר גָּבוֹהַּ וְלַחַץ דָּם שֶׁמַּגְדִּיל סִכּוּן לְלֵב.",
            definitionNative = "Связка брюшного ожирения, высокого сахара и давления — поднимает риск для сердца.",
            example = "תִּסְמֹנֶת מֶטָבּוֹלִית פּוֹגַעַת בִּכְשְׁלִישׁ מֵהָאוּכְלוּסִיָּה הַבּוֹגֶרֶת.",
            exampleNative = "תִּסְמֹנֶת מֶטָבּוֹלִית бьёт по примерно трети взрослого населения.",
         fillInBlankExclusions = listOf(179111L, 179112L, 179113L, 179115L)),
        WordEntity(
            id = 179115, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_pathology", transliteration = "sarkopenya",
            original = "סַרְקוֹפֶּנְיָה", translation = "саркопения",
            definition = "אִבּוּד הַדְרָגָתִי שֶׁל מָסַת שְׁרִיר וְכֹחַ שֶׁמְּלַוֶה הַזְּקֵנִים בְּלִי הִתְעַמְּלוּת.",
            definitionNative = "Постепенная потеря мышечной массы и силы у пожилых без физических нагрузок.",
            example = "סַרְקוֹפֶּנְיָה אַחֲרֵי גִּיל שִׁבְעִים מַעֲלָה אֶת הַסִּכּוּן לִנְפִילוֹת קָשׁוֹת.",
            exampleNative = "סַרְקוֹפֶּנְיָה после семидесяти повышает риск тяжёлых падений.",
         fillInBlankExclusions = listOf(179111L, 179112L, 179113L, 179114L)),

        // ── health_pharmacology (5) — фармакокинетика и применение лекарств ──
        WordEntity(
            id = 179116, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_pharmacology", transliteration = "makhatsit khayim",
            original = "מַחֲצִית חַיִּים", translation = "период полураспада (T½)",
            definition = "פֶּרֶק זְמַן שֶׁבּוֹ רֵיכּוּז הַחֹמֶר בַּדָּם יוֹרֵד לַחֲמִישִּׁים אָחוּז מֵהַשִּׁעוּר הַהַתְחָלָתִי.",
            definitionNative = "Срок, за который концентрация вещества в крови падает до пятидесяти процентов.",
            example = "מַחֲצִית חַיִּים קְצָרָה דּוֹרֶשֶׁת מָנוֹת תְּכוּפוֹת לְאֹרֶךְ הַיּוֹם.",
            exampleNative = "Короткий מַחֲצִית חַיִּים требует частых доз в течение дня.",
         fillInBlankExclusions = listOf(179117L, 179118L, 179119L, 179120L)),
        WordEntity(
            id = 179117, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_pharmacology", transliteration = "zminut biologit",
            original = "זְמִינוּת בִּיוֹלוֹגִית", translation = "биодоступность",
            definition = "הָאָחוּז מֵחֹמֶר פָּעִיל שֶׁמַּצְלִיחַ לְהַגִּיעַ לִזְרִימַת הַדָּם וְלַשְׁפִּיעַ עַל הַגּוּף.",
            definitionNative = "Процент действующего вещества, что доходит до кровотока и влияет на тело.",
            example = "כַּדּוּרִים בְּלִיעָה לִפְעָמִים בַּעֲלֵי זְמִינוּת בִּיוֹלוֹגִית נְמוּכָה מִזְּרִיקוֹת.",
            exampleNative = "У глотаемых таблеток часто זְמִינוּת בִּיוֹלוֹגִית ниже, чем у уколов.",
         fillInBlankExclusions = listOf(179116L, 179118L, 179119L, 179120L)),
        WordEntity(
            id = 179118, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_pharmacology", transliteration = "interaktsya tarufatit",
            original = "אִינְטֵרַקְצְיָה תְּרוּפָתִית", translation = "лекарственное взаимодействие",
            definition = "הַשְׁפָּעָה הֲדָדִית בֵּין שְׁתֵּי תְּרוּפוֹת שֶׁמְּשַׁנָּה אֶת הַפְּעוּלָה אוֹ הַסִּכּוּן.",
            definitionNative = "Взаимное влияние двух препаратов — меняет действие или поднимает риск.",
            example = "אִינְטֵרַקְצְיָה תְּרוּפָתִית בֵּין סְטָטִינִים לְמִיץ אֶשְׁכּוֹלִית מְסֻכֶּנֶת.",
            exampleNative = "אִינְטֵרַקְצְיָה תְּרוּפָתִית между статинами и грейпфрутовым соком опасна.",
         fillInBlankExclusions = listOf(179116L, 179117L, 179119L, 179120L)),
        WordEntity(
            id = 179119, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_pharmacology", transliteration = "hora'at neged",
            original = "הוֹרָאַת נֶגֶד", translation = "противопоказание",
            definition = "מַצָּב רְפוּאִי שֶׁבּוֹ אָסוּר לָקַחַת תְּרוּפָה מְסֻיֶּמֶת בִּגְלַל סַכָּנָה לַחוֹלֶה.",
            definitionNative = "Случай, когда определённое лекарство принимать нельзя — есть угроза больному.",
            example = "הֵרָיוֹן הוּא הוֹרָאַת נֶגֶד לְהַרְבֵּה תְּרוּפוֹת לְכַאֲבֵי גַּב חֲזָקִים.",
            exampleNative = "Беременность — это הוֹרָאַת נֶגֶד для многих сильных лекарств от боли в спине.",
         fillInBlankExclusions = listOf(179116L, 179117L, 179118L, 179120L)),
        WordEntity(
            id = 179120, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_pharmacology", transliteration = "shimush of-leybel",
            original = "שִׁמּוּשׁ אוֹף-לֵייבֶּל", translation = "off-label применение",
            definition = "מַתַּן תְּרוּפָה לְמַטָּרָה שֶׁלֹּא רְשׁוּמָה רִשְׁמִית בָּעָלוֹן הַמְאֻשָּׁר.",
            definitionNative = "Назначение препарата для цели, что официально не записана в утверждённой инструкции.",
            example = "שִׁמּוּשׁ אוֹף-לֵייבֶּל בִּתְרוּפוֹת סוּכֶּרֶת לִירִידָה בַּמִּשְׁקָל הִתְפַּשֵּׁט מְאוֹד.",
            exampleNative = "שִׁמּוּשׁ אוֹף-לֵייבֶּל диабетических лекарств для похудения сильно распространился.",
         fillInBlankExclusions = listOf(179116L, 179117L, 179118L, 179119L)),

        // ── health_clinical (5) — клинические исследования и доказательность ──
        WordEntity(
            id = 179121, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_clinical", transliteration = "mekhkar mevukar akra'i",
            original = "מֶחְקָר מְבֻקָּר אַקְרָאִי", translation = "РКИ (рандомизированное контролируемое исследование)",
            definition = "נִסּוּי שֶׁבּוֹ מְשַׁתְּפִים מְחֻלָּקִים בְּהַגְרָלָה לִקְבוּצַת טִיפּוּל וּלִקְבוּצַת בִּקֹּרֶת.",
            definitionNative = "Опыт, в котором участников по жребию делят на группу лечения и группу сравнения.",
            example = "מֶחְקָר מְבֻקָּר אַקְרָאִי מַסְפִּיק גָּדוֹל הוּא הַסְּטַנְדַּרְט הָרְפוּאִי הַגָּבוֹהַּ בְּיוֹתֵר.",
            exampleNative = "Достаточно крупный מֶחְקָר מְבֻקָּר אַקְרָאִי — самый высокий медицинский стандарт.",
         fillInBlankExclusions = listOf(179122L, 179123L, 179124L, 179125L)),
        WordEntity(
            id = 179122, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_clinical", transliteration = "efekt notsebo",
            original = "אֶפֶקְט נוֹצֵבּוֹ", translation = "эффект ноцебо",
            definition = "הַחְמָרָה אֲמִיתִּית בַּתְּחוּשָׁה רַק מִכֹּחַ הַצִּפִּיָּה הַשְּׁלִילִית שֶׁל הַחוֹלֶה.",
            definitionNative = "Реальное ухудшение самочувствия — только из-за негативного ожидания больного.",
            example = "אֶפֶקְט נוֹצֵבּוֹ גָּרַם לְמְשַׁתְּפִים לָחוּשׁ בְּחִילָה גַּם מִכַּדּוּר סָכָּר.",
            exampleNative = "אֶפֶקְט נוֹצֵבּוֹ заставил участников чувствовать тошноту даже от сахарной таблетки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179123, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_clinical", transliteration = "praktika mevuseset re'ayot",
            original = "פְּרַקְטִיקָה מְבוּסֶּסֶת רְאָיוֹת", translation = "доказательная практика",
            definition = "גִישָׁה שֶׁמַּחְלִיטָה עַל טִיפּוּל רַק לְפִי מֶחְקָרִים אֵיכוּתִיִּים, לֹא רַק נִסָּיוֹן אִישִׁי.",
            definitionNative = "Подход, что выбирает лечение по качественным исследованиям, а не по личному опыту.",
            example = "פְּרַקְטִיקָה מְבוּסֶּסֶת רְאָיוֹת הַחֲלִיפָה אֶת רֹב הַמַּסּוֹרוֹת הַיְשָׁנוֹת בָּרְפוּאָה.",
            exampleNative = "פְּרַקְטִיקָה מְבוּסֶּסֶת רְאָיוֹת сменила большинство старых традиций в медицине.",
         fillInBlankExclusions = listOf(179121L, 179122L, 179124L, 179125L)),
        WordEntity(
            id = 179124, setId = 1791, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "health_clinical", transliteration = "ma'akav orekh-tvakh",
            original = "מַעֲקָב אֹרֶךְ-טְוָוח", translation = "продольное (лонгитюдное) исследование",
            definition = "צוּרַת מֶחְקָר שֶׁעוֹקֶבֶת אַחַר אוֹתָהּ קְבוּצַת אֲנָשִׁים פְּעָמִים רַבּוֹת לְאֹרֶךְ שָׁנִים.",
            definitionNative = "Тип работы, что много раз отслеживает одну и ту же группу людей в течение лет.",
            example = "מַעֲגַל פְרֵימִינְגְהֵם הוּא מַעֲקָב אֹרֶךְ-טְוָוח קְלָאסִי עַל מַחֲלוֹת לֵב.",
            exampleNative = "Фрэмингемский цикл — классический מַעֲקָב אֹרֶךְ-טְוָוח по сердечным болезням.",
         fillInBlankExclusions = listOf(179121L, 179122L, 179123L, 179125L)),
        WordEntity(
            id = 179125, setId = 1791, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "health_clinical", transliteration = "biomarker",
            original = "בִּיוֹמַרְקֵר", translation = "биомаркер",
            definition = "מַדָּד מָדִיד בַּגּוּף שֶׁמֵּעִיד עַל מַצָּב בִּיאוֹלוֹגִי, מַחֲלָה אוֹ תְּגוּבָה לְטִיפּוּל.",
            definitionNative = "Измеримый показатель в теле — отражает состояние, болезнь или ответ на лечение.",
            example = "רָמַת C-רֵאַקְטִיב הִיא בִּיוֹמַרְקֵר נָפוֹץ לְהַעֲרָכַת דַּלֶּקֶת בַּגּוּף.",
            exampleNative = "Уровень C-реактивного белка — частый בִּיוֹמַרְקֵר для оценки воспаления в теле.",
         fillInBlankExclusions = listOf(179121L, 179122L, 179123L, 179124L)),
    )
}
