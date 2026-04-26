package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Cook, level 4 (1 set, 25 words).
 * Профессиональная лексика шеф-повара премиум-кухни:
 * иерархия бригады, продвинутые техники, авторские блюда,
 * винные пары и банкетный сервис.
 *
 * Set 1722 (level 4, EPIC + LEGENDARY) — заполняет нишу между
 * level 3 (1376) и level 5 (1377, 1378) в теме «Повар».
 *
 * Не пересекается с уже существующими сетами темы «Повар»
 * (1374 L1, 1375 L2, 1376 L3, 1377 L4 «управление», 1378 L5, 1556 L2).
 *
 * Распределение редкостей: 15 EPIC + 10 LEGENDARY (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов каждая:
 *   cook_chef_brigade        — иерархия и станции бригады
 *   cook_advanced_techniques — продвинутые техники готовки
 *   cook_signature_dishes    — авторские блюда и подача
 *   cook_wine_pairing        — винные пары к блюдам
 *   cook_banquet             — банкетная и фуршетная кухня
 */
object WordDataHebrewCookL4 {

    val sets = listOf(
        WordSetEntity(
            id = 1722, languagePair = "he-ru", orderIndex = 1722,
            name = "Кухня и работа поваром",
            description = "Бригада, авторские блюда, винные пары, банкеты",
            topic = "Кухня и работа поваром", level = 4,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1722 — Повар: профессиональный (EPIC + LEGENDARY, C1–C2)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── cook_chef_brigade (5) — иерархия и станции бригады ──
        WordEntity(
            id = 172201, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cook_chef_brigade", transliteration = "su-shef",
            original = "סוּ-שֶׁף", translation = "су-шеф, заместитель шефа",
            definition = "סְגַן שֶׁל רֹאשׁ הַמִּטְבָּח שֶׁמְּנַהֵל אֶת הַמִּשְׁמֶרֶת בִּזְמַן הֶעְדֵּר.",
            definitionNative = "Заместитель главы кухни, ведущий смену в его отсутствие.",
            example = "סוּ-שֶׁף הִדְרִיךְ אֶת הַטַּבָּחִים בִּזְמַן הָאַרְבָּעִים מָנוֹת לַשַּׁבָּת.",
            exampleNative = "סוּ-שֶׁף руководил поварами при подаче сорока блюд в субботу.",
            fillInBlankExclusions = listOf(172202L, 172203L, 172204L, 172205L)),
        WordEntity(
            id = 172202, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_chef_brigade", transliteration = "shef patiseri",
            original = "שֶׁף פָּטִיסְרִי", translation = "шеф-кондитер",
            definition = "אַחְרַאי עַל קִנּוּחִים, מַאֲפִים וּמְנוֹת מְתוּקוֹת בְּמִטְבָּח גָּדוֹל.",
            definitionNative = "Ответственный за десерты, выпечку и сладкие подачи в большой кухне.",
            example = "שֶׁף פָּטִיסְרִי הִכִין סוּפְלֶה שׁוֹקוֹלָד לְכָל הָאוֹרְחִים בָּעֶרֶב.",
            exampleNative = "שֶׁף פָּטִיסְרִי приготовил шоколадное суфле всем гостям вечера.",
            fillInBlankExclusions = listOf(172201L, 172203L, 172204L, 172205L)),
        WordEntity(
            id = 172203, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_chef_brigade", transliteration = "shef salot",
            original = "שֶׁף סָאלוֹט", translation = "шеф холодной станции",
            definition = "אַחְרַאי עַל סָלָטִים, מָנוֹת קְרִירוֹת וּמַאֲכָלִים שֶׁאֵינָם מְבֻשָּׁלִים.",
            definitionNative = "Ответственный за салаты, холодные блюда и невареные закуски.",
            example = "שֶׁף סָאלוֹט סִדֵּר עֶשְׂרִים מָנוֹת פְּתִיחָה בְּתוֹךְ עֶשֶׂר דַּקּוֹת.",
            exampleNative = "שֶׁף סָאלוֹט выложил двадцать стартеров за десять минут.",
            fillInBlankExclusions = listOf(172201L, 172202L, 172204L, 172205L)),
        WordEntity(
            id = 172204, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_chef_brigade", transliteration = "shef sote",
            original = "שֶׁף סוֹטֶה", translation = "повар-сотейник, повар горячего цеха",
            definition = "טַבָּח שֶׁמְּתַמְחֶה בִּמְנוֹת מַחֲבַת חַמָּה עִם רֹטֶב מַהִיר.",
            definitionNative = "Повар, специализирующийся на сковороде с быстрым соусом.",
            example = "שֶׁף סוֹטֶה זָרַק חָמָאָה לַמַּחֲבַת בְּדִיּוּק בָּרֶגַע הַנָּכוֹן.",
            exampleNative = "שֶׁף סוֹטֶה бросил масло на сковороду точно в нужный момент.",
            fillInBlankExclusions = listOf(172201L, 172202L, 172203L, 172205L)),
        WordEntity(
            id = 172205, setId = 1722, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cook_chef_brigade", transliteration = "shef gril",
            original = "שֶׁף גָּרִיל", translation = "шеф гриль-станции",
            definition = "מִקְצוֹעָן הָאַחְרָאִי עַל בָּשָׂר וְדָגִים שֶׁמְּקַבְּלִים אֵשׁ פְּתוּחָה יְשִׁירָה.",
            definitionNative = "Профессионал, отвечающий за мясо и рыбу на открытом огне.",
            example = "שֶׁף גָּרִיל בָּדַק כָּל סְטֵיק בְּמַד חֹם פְּנִימִי.",
            exampleNative = "שֶׁף גָּרִיל проверил каждый стейк термометром изнутри.",
            fillInBlankExclusions = listOf(172201L, 172202L, 172203L, 172204L)),

        // ── cook_advanced_techniques (5) — продвинутые техники ──
        WordEntity(
            id = 172206, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_advanced_techniques", transliteration = "ishun kar",
            original = "עִשּׁוּן קַר", translation = "холодное копчение",
            definition = "טִפּוּל בְּעָשָׁן בִּטֶמְפֵּרָטוּרָה נְמוּכָה כְּדֵי לְשַׁמֵּר טַעַם בְּלִי לְבַשֵּׁל.",
            definitionNative = "Обработка дымом при низком градусе, чтобы дать аромат без варки.",
            example = "עִשּׁוּן קַר נוֹתֵן לַסַּלְמוֹן צֶבַע יָפֶה וְרֵיחַ עָדִין.",
            exampleNative = "עִשּׁוּן קַר придаёт лососю красивый цвет и тонкий запах.",
            fillInBlankExclusions = listOf(172207L, 172208L, 172209L, 172210L)),
        WordEntity(
            id = 172207, setId = 1722, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cook_advanced_techniques", transliteration = "de-glasaz",
            original = "דֵּי-גְלָסָאז'", translation = "дегласирование, развод соуса жидкостью",
            definition = "מְזִיגַת יַיִן אוֹ צִיר עַל שְׁאֵרִיּוֹת מַחֲבַת לִיצִירַת רֹטֶב עָשִׁיר.",
            definitionNative = "Залив вина или бульона на остатки в сковороде для густого соуса.",
            example = "דֵּי-גְלָסָאז' אַחֲרֵי הָאוֹמְצָה הוֹצִיא רֹטֶב בְּצֶבַע עָמוֹק.",
            exampleNative = "דֵּי-גְלָסָאז' после отбивной дал соус глубокого цвета.",
            fillInBlankExclusions = listOf(172206L, 172208L, 172209L, 172210L)),
        WordEntity(
            id = 172208, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cook_advanced_techniques", transliteration = "flambe",
            original = "פְלָמְבֶּה", translation = "фламбирование, поджиг алкоголя",
            definition = "הַצָּתָה שֶׁל אַלְכּוֹהוֹל בַּמַּחֲבַת לְהוֹסִיף טַעַם וּלְהַצִּיג לָאוֹרֵחַ.",
            definitionNative = "Поджог алкоголя на сковороде ради вкуса и зрелища для гостя.",
            example = "פְלָמְבֶּה שֶׁל קוֹנְיָאק עַל הָאוֹמְצָה הִדְהִים אֶת כָּל הַשֻּׁלְחָן.",
            exampleNative = "פְלָמְבֶּה коньяком на отбивной поразил весь стол.",
            fillInBlankExclusions = listOf(172206L, 172207L, 172209L, 172210L)),
        WordEntity(
            id = 172209, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_advanced_techniques", transliteration = "redutsiya iti",
            original = "רֵדוּקְצְיָה אִטִּית", translation = "медленное уваривание соуса",
            definition = "צִמְצוּם נוֹזְלִים עַל אֵשׁ קְטַנָּה לְהַעֲשִׁיר אֶת הַטַּעַם וְהַמִּרְקָם.",
            definitionNative = "Уменьшение жидкости на малом огне для густоты и насыщенности.",
            example = "רֵדוּקְצְיָה אִטִּית שֶׁל יַיִן אָדֹם נִמְשְׁכָה כִּמְעַט שָׁעָה.",
            exampleNative = "רֵדוּקְצְיָה אִטִּית красного вина длилась почти час.",
            fillInBlankExclusions = listOf(172206L, 172207L, 172208L, 172210L)),
        WordEntity(
            id = 172210, setId = 1722, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cook_advanced_techniques", transliteration = "sferifikatsiya",
            original = "סְפֵרִיפִיקַצְיָה", translation = "сферификация (молекулярная)",
            definition = "הֲפִיכַת נוֹזֶל לְכַדּוּרִים זְעִירִים בְּקַלְצְיוּם — טֶכְנִיקָה מוֹלֶקוּלָרִית.",
            definitionNative = "Превращение жидкости в шарики через кальций — молекулярная техника.",
            example = "סְפֵרִיפִיקַצְיָה שֶׁל מִיץ זֵיתִים נָתְנָה כַּדּוּרֵי טַעַם עַל הַצַּלַּחַת.",
            exampleNative = "סְפֵרִיפִיקַצְיָה оливкового сока дала шарики вкуса на тарелке.",
            fillInBlankExclusions = listOf(172206L, 172207L, 172208L, 172209L)),

        // ── cook_signature_dishes (5) — авторские блюда и подача ──
        WordEntity(
            id = 172211, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_signature_dishes", transliteration = "manat khatima",
            original = "מָנַת חֲתִימָה", translation = "фирменное блюдо шефа",
            definition = "פְּרִיט מִן הַתַּפְרִיט שֶׁמְּזֻהֶה אִישִׁית עִם הַטַּבָּח וּמַצִּיג סִגְנוֹן שֶׁלּוֹ.",
            definitionNative = "Блюдо из меню, ассоциирующееся лично с поваром и его стилем.",
            example = "מָנַת חֲתִימָה שֶׁל הַשֶּׁף הִיא דָּג רַעַף עִם רֹטֶב לִימוֹן.",
            exampleNative = "מָנַת חֲתִימָה шефа — рыба-черепица под лимонным соусом.",
            fillInBlankExclusions = listOf(172212L, 172213L, 172214L, 172215L)),
        WordEntity(
            id = 172212, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_signature_dishes", transliteration = "tafrit te'imot",
            original = "תַּפְרִיט טְעִימוֹת", translation = "дегустационное меню",
            definition = "סִדְרַת מָנוֹת קְטַנּוֹת שֶׁבָּהּ הַשֶּׁף מַצִּיג אֶת מֵיטַב יְצִירוֹתָיו.",
            definitionNative = "Серия маленьких блюд, в которой шеф показывает свои лучшие работы.",
            example = "תַּפְרִיט טְעִימוֹת בָּעֶרֶב כָּלַל שֶׁבַע מָנוֹת קְטַנּוֹת.",
            exampleNative = "תַּפְרִיט טְעִימוֹת сегодня вечером включал семь маленьких блюд.",
            fillInBlankExclusions = listOf(172211L, 172213L, 172214L, 172215L)),
        WordEntity(
            id = 172213, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_signature_dishes", transliteration = "shilov ta'amim",
            original = "שִׁלּוּב טַעֲמִים", translation = "сочетание вкусов",
            definition = "אִחוּד שֶׁל מַרְכִּיבִים שׁוֹנִים לִיצִירַת הַרְמוֹנְיָה אַחַת בַּפֶּה.",
            definitionNative = "Соединение разных продуктов в единую гармонию во рту.",
            example = "שִׁלּוּב טַעֲמִים שֶׁל מָנְגוֹ וְצִ'ילִי הִפְתִּיעַ אֶת הַסּוֹעֲדִים.",
            exampleNative = "שִׁלּוּב טַעֲמִים манго и чили удивило посетителей.",
            fillInBlankExclusions = listOf(172211L, 172212L, 172214L, 172215L)),
        WordEntity(
            id = 172214, setId = 1722, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cook_signature_dishes", transliteration = "interpretatsiya kulinarit",
            original = "אִינְטֶרְפְּרֶטַצְיָה קוּלִינָרִית", translation = "авторская трактовка классики",
            definition = "גִּרְסָה חֲדָשָׁה שֶׁל מָנָה מָסּוֹרְתִּית עִם נְגִיעָה אִישִׁית שֶׁל הַטַּבָּח.",
            definitionNative = "Новая версия классического блюда с личным почерком повара.",
            example = "אִינְטֶרְפְּרֶטַצְיָה קוּלִינָרִית שֶׁל חוּמּוּס הָיְתָה עִם בָּטָטָה צְלוּיָה.",
            exampleNative = "אִינְטֶרְפְּרֶטַצְיָה קוּלִינָרִית хумуса оказалась с печёным бататом.",
            fillInBlankExclusions = listOf(172211L, 172212L, 172213L, 172215L)),
        WordEntity(
            id = 172215, setId = 1722, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cook_signature_dishes", transliteration = "esttetikat tsalakhat",
            original = "אֶסְתֶּטִיקַת צַלַּחַת", translation = "эстетика подачи на тарелке",
            definition = "אָמָּנוּת סִדּוּר הַמָּזוֹן עַל הַכְּלִי לְהַשְׁפִּיעַ עַל הָעַיִן לִפְנֵי הַפֶּה.",
            definitionNative = "Искусство выкладки еды, действующее на глаз раньше, чем на рот.",
            example = "אֶסְתֶּטִיקַת צַלַּחַת בַּמִּסְעָדָה הַזֹּאת מַזְכִּירָה תְּמוּנַת שֶׁמֶן.",
            exampleNative = "אֶסְתֶּטִיקַת צַלַּחַת в этом ресторане напоминает картину маслом.",
            fillInBlankExclusions = listOf(172211L, 172212L, 172213L, 172214L)),

        // ── cook_wine_pairing (5) — винные пары ──
        WordEntity(
            id = 172216, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_wine_pairing", transliteration = "shidukh yain",
            original = "שִׁדּוּךְ יַיִן", translation = "винная пара к блюду",
            definition = "בְּחִירַת מַשְׁקֶה שֶׁמַּדְגִּישׁ אוֹ מְאַזֵּן אֶת טַעַם הָאֹכֶל.",
            definitionNative = "Подбор напитка, который подчеркивает или уравновешивает блюдо.",
            example = "שִׁדּוּךְ יַיִן מֻצְלָח לְמָנַת הַסְטֵיק הָיָה מָאלְבֶּק אַרְגֶּנְטִינָאִי.",
            exampleNative = "שִׁדּוּךְ יַיִן к стейку оказалось аргентинским мальбеком.",
            fillInBlankExclusions = listOf(172217L, 172218L, 172219L, 172220L)),
        WordEntity(
            id = 172217, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_wine_pairing", transliteration = "yain melaveh",
            original = "יַיִן מְלַוֶּה", translation = "сопровождающее вино к блюду",
            definition = "מַשְׁקֶה שֶׁמּוֹסִיפִים לְמָנָה כְּדֵי לִיצֹר חֲוָיַת אֲרוּחָה שְׁלֵמָה.",
            definitionNative = "Напиток, добавленный к блюду для целостного впечатления от ужина.",
            example = "יַיִן מְלַוֶּה לַקִּנּוּחַ הָיָה מוֹסְקָטֶל אִיטַלְקִי קָלִיל.",
            exampleNative = "יַיִן מְלַוֶּה к десерту был лёгким итальянским мускателем.",
            fillInBlankExclusions = listOf(172216L, 172218L, 172219L, 172220L)),
        WordEntity(
            id = 172218, setId = 1722, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cook_wine_pairing", transliteration = "ta'am mashlim",
            original = "טַעַם מַשְׁלִים", translation = "комплементарный вкус",
            definition = "תְּכוּנָה בַּמַּשְׁקֶה אוֹ בָּאֹכֶל שֶׁמְּמַלֵּאת חָסֵר אֵצֶל בֶּן זוּגוֹ.",
            definitionNative = "Свойство напитка или еды, восполняющее то, чего не хватает партнёру.",
            example = "טַעַם מַשְׁלִים שֶׁל גְּבִינָה כָּחֻלָּה הוּא מַשְׁקֶה מָתוֹק.",
            exampleNative = "טַעַם מַשְׁלִים для голубого сыра — сладкий напиток.",
            fillInBlankExclusions = listOf(172216L, 172217L, 172219L, 172220L)),
        WordEntity(
            id = 172219, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_wine_pairing", transliteration = "yain levan kar",
            original = "יַיִן לָבָן קַר", translation = "охлаждённое белое вино",
            definition = "מַשְׁקֶה בָּהִיר שֶׁמַּגִּישִׁים בְּקֵרוּר לִדְגֵי יָם וְעוֹף עָדִין.",
            definitionNative = "Светлый напиток, подаваемый охлаждённым к рыбе и нежной птице.",
            example = "יַיִן לָבָן קַר הִתְאִים מוֹשְׁלָם לַדָּג שֶׁעַל הַשֻּׁלְחָן.",
            exampleNative = "יַיִן לָבָן קַר идеально подошёл к рыбе на столе.",
            fillInBlankExclusions = listOf(172216L, 172217L, 172218L, 172220L)),
        WordEntity(
            id = 172220, setId = 1722, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cook_wine_pairing", transliteration = "rezonans ta'amim",
            original = "רֵזוֹנָנְס טַעֲמִים", translation = "резонанс вкусов вина и блюда",
            definition = "תּוֹפָעָה שֶׁבָּהּ הַמַּשְׁקֶה וְהָאֹכֶל מַגְדִּילִים זֶה אֶת זֶה בַּפֶּה.",
            definitionNative = "Явление, когда напиток и еда усиливают друг друга во рту.",
            example = "רֵזוֹנָנְס טַעֲמִים בֵּין שׁוֹקוֹלָד לְפּוֹרְט הָיָה מֻשְׁלָם.",
            exampleNative = "רֵזוֹנָנְס טַעֲמִים между шоколадом и портвейном был идеальным.",
            fillInBlankExclusions = listOf(172216L, 172217L, 172218L, 172219L)),

        // ── cook_banquet (5) — банкетная и фуршетная кухня ──
        WordEntity(
            id = 172221, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_banquet", transliteration = "bishul lebanket",
            original = "בִּישּׁוּל לְבַנְקֶט", translation = "банкетная готовка большими партиями",
            definition = "הֲכָנַת מָנוֹת בְּכַמּוּת גְּדוֹלָה לְאֵירוּעַ מְרֻכָּז עִם שָׁעָה אַחַת לְהַגָּשָׁה.",
            definitionNative = "Готовка большой партии для мероприятия с одним временем подачи.",
            example = "בִּישּׁוּל לְבַנְקֶט שֶׁל מָאתַיִם אִישׁ דּוֹרֵשׁ תִּכְנוּן מֻקְפָּד.",
            exampleNative = "בִּישּׁוּל לְבַנְקֶט на двести гостей требует точного планирования.",
            fillInBlankExclusions = listOf(172222L, 172223L, 172224L, 172225L)),
        WordEntity(
            id = 172222, setId = 1722, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cook_banquet", transliteration = "takhanat bufe",
            original = "תַּחֲנַת בּוּפֶה", translation = "буфетная станция на банкете",
            definition = "פִּנָּה עִם מָנוֹת חַמּוֹת אוֹ קָרוֹת שֶׁהָאוֹרְחִים לוֹקְחִים מֵעַצְמָם.",
            definitionNative = "Угол с горячими или холодными блюдами, что гости берут сами.",
            example = "תַּחֲנַת בּוּפֶה שֶׁל פַּסְטָה מָשְׁכָה תּוֹר אָרֹךְ בָּעֶרֶב.",
            exampleNative = "תַּחֲנַת בּוּפֶה с пастой собрала длинную очередь вечером.",
            fillInBlankExclusions = listOf(172221L, 172223L, 172224L, 172225L)),
        WordEntity(
            id = 172223, setId = 1722, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cook_banquet", transliteration = "hovalat manot",
            original = "הוֹבָלַת מָנוֹת", translation = "вынос блюд для большой группы",
            definition = "הַעֲבָרַת אֹכֶל מֻכָן מֵהַמִּטְבָּח לָאוּלָם בְּצוּרָה מְהִירָה וּמְסֻדֶּרֶת.",
            definitionNative = "Перемещение готовой еды из кухни в зал быстро и упорядоченно.",
            example = "הוֹבָלַת מָנוֹת לְמֵאָה אוֹרְחִים נִמְשְׁכָה רַק שְׁמוֹנֶה דַּקּוֹת.",
            exampleNative = "הוֹבָלַת מָנוֹת на сто гостей заняла лишь восемь минут.",
            fillInBlankExclusions = listOf(172221L, 172222L, 172224L, 172225L)),
        WordEntity(
            id = 172224, setId = 1722, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cook_banquet", transliteration = "tafrit erua",
            original = "תַּפְרִיט אֵירוּעַ", translation = "меню банкета",
            definition = "רְשִׁימַת מָנוֹת שֶׁמּוּסְכָּמוֹת מֵרֹאשׁ עִם הַלָּקוֹחַ לְפִי תַּקְצִיב וּמַטָּרָה.",
            definitionNative = "Список блюд, согласованный с заказчиком по бюджету и поводу.",
            example = "תַּפְרִיט אֵירוּעַ לַחֲתוּנָה כָּלַל אַרְבָּעָה קוּרְסִים יְקָרִים.",
            exampleNative = "תַּפְרִיט אֵירוּעַ на свадьбу включал четыре дорогих курса.",
            fillInBlankExclusions = listOf(172221L, 172222L, 172223L, 172225L)),
        WordEntity(
            id = 172225, setId = 1722, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cook_banquet", transliteration = "te'um im meltsarim",
            original = "תֵּאוּם עִם מֶלְצָרִים", translation = "координация с официантами",
            definition = "סִנְכְרוּן בֵּין מִטְבָּח לְצֶוֶת הָאוּלָם כְּדֵי שֶׁכָּל מָנָה תֵּצֵא בַּזְּמַן.",
            definitionNative = "Согласование кухни и зала, чтобы каждое блюдо вышло вовремя.",
            example = "תֵּאוּם עִם מֶלְצָרִים לִפְנֵי בַּנְקֶט מוֹנֵעַ עַכֶּבֶת בְּהַגָּשָׁה.",
            exampleNative = "תֵּאוּם עִם מֶלְצָרִים перед банкетом предотвращает задержку подачи.",
            fillInBlankExclusions = listOf(172221L, 172222L, 172223L, 172224L)),
    )
}
