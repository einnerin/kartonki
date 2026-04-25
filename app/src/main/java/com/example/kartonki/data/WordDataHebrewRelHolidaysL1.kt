package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — Religion & Holidays L1 (set 1710).
 *
 * 25 базовых слов уровня A1-A2, посвящённых атрибутам, блюдам, поздравлениям
 * и предметам еврейских праздников. Дополняет тему «Религия и праздники»,
 * закрывая отсутствующий L1-уровень. 15 COMMON + 10 UNCOMMON.
 *
 * Не пересекается со словами в существующих сетах темы «Религия и праздники»
 * (1035, 1147, 1151, 1170, 1198, 1205, 1511, 1512, 1513, 1541) и темы «Религия»
 * (1053, 1070, 1071, 1282, 1283, 1284, 1701) — в них уже разобраны сами праздники
 * (Шабат, Песах, Рош а-Шана, Йом Кипур, Суккот, Ханука, Пурим), молитвенные
 * предметы (мезуза, талит, шофар), кашрут, исход и Тора.
 *
 * Этот сет фокусируется на бытовых и наглядных приметах праздничного цикла:
 * стол, блюда, поздравления гостей, наряды Пурима, песнопения.
 *
 * Все слова помечены isFillInBlankSafe = false: ивритская морфология
 * (огласовки, префиксы ה/ב/ל/מ, смихут) ломает наивную подстрочную замену
 * в FILL_IN_BLANK; квиз будет включён после прогона LLM-pipeline и расстановки
 * fillInBlankExclusions (см. docs/claude/fill-in-blank-pipeline.md).
 */
object WordDataHebrewRelHolidaysL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1710, languagePair = "he-ru", orderIndex = 210,
            name = "Религия и праздники",
            description = "Основные праздники: шабат, Рош а-Шана, Песах, Ханука",
            topic = "Религия и праздники", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ════════════════════════════════════════════════════════════════════
        // Set 1710 — Религия и праздники: основы (level 1, COMMON+UNCOMMON)
        // 6 групп × 3-5 слов: holidays_table, holidays_food, holidays_celebration,
        //                     holidays_greetings, holidays_purim, holidays_song
        // 15 COMMON + 10 UNCOMMON
        // ════════════════════════════════════════════════════════════════════

        // ── holidays_table (4 — 3 COMMON + 1 UNCOMMON; праздничный стол) ──
        WordEntity(
            id = 171001, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holidays_table", transliteration = "kosit",
            original = "כּוֹסִית", translation = "рюмка",
            definition = "כְּלִי קָטָן וְאָרֹךְ לִשְׁתִיַּת יַיִן בִּסְעוּדַת חַג.",
            definitionNative = "Маленький узкий бокал для вина за праздничным столом.",
            example = "סָבָּא הִגְבִּיהַּ אֶת הַכּוֹסִית וְאָמַר לְחַיִּים.",
            exampleNative = "Дедушка поднял כּוֹסִית и сказал «лехаим».",
        ),
        WordEntity(
            id = 171002, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "holidays_table", transliteration = "meits anavim",
            original = "מֵיץ עֲנָבִים", translation = "виноградный сок",
            definition = "מַשְׁקֶה מָתוֹק מִפֵּרוֹת אָדֻמִּים שֶׁשּׁוֹתִים יְלָדִים בַּקִּדּוּשׁ.",
            definitionNative = "Сладкий напиток из красных ягод, который пьют дети во время кидуша.",
            example = "הַיְּלָדִים שׁוֹתִים מֵיץ עֲנָבִים בִּמְקוֹם יַיִן.",
            exampleNative = "Дети пьют מֵיץ עֲנָבִים вместо вина.",
         fillInBlankExclusions = listOf(171003L, 171004L)),
        WordEntity(
            id = 171003, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "holidays_table", transliteration = "bakbuk yain",
            original = "בַּקְבּוּק יַיִן", translation = "бутылка вина",
            definition = "כְּלִי זְכוּכִית סָגוּר עִם מַשְׁקֶה אָדֹם לְשֻׁלְחַן הַחַג.",
            definitionNative = "Закрытый стеклянный сосуд с красным напитком для праздничного стола.",
            example = "הֵבֵאתִי בַּקְבּוּק יַיִן מַתָּנָה לְעֶרֶב הַחַג.",
            exampleNative = "Я принёс בַּקְבּוּק יַיִן в подарок к праздничному вечеру.",
         fillInBlankExclusions = listOf(171002L, 171004L)),
        WordEntity(
            id = 171004, setId = 1710, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "holidays_table", transliteration = "mapat shabat",
            original = "מַפַּת שַׁבָּת", translation = "субботняя скатерть",
            definition = "בַּד לָבָן יָפֶה שֶׁפּוֹרְשִׂים עַל הַשֻּׁלְחָן לִכְבוֹד הַחַג.",
            definitionNative = "Красивое белое полотно, которое стелют на стол ради праздника.",
            example = "אִמָּא פּוֹרֶשֶׂת מַפַּת שַׁבָּת לְבָנָה כָּל יוֹם שִׁשִּׁי.",
            exampleNative = "Мама стелет белую מַפַּת שַׁבָּת каждую пятницу.",
         fillInBlankExclusions = listOf(171002L, 171003L)),

        // ── holidays_food (5 — 3 COMMON + 2 UNCOMMON; праздничные блюда) ──
        WordEntity(
            id = 171005, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holidays_food", transliteration = "sufganiya",
            original = "סֻפְגָּנִיָּה", translation = "пончик (ханукальный)",
            definition = "מַאֲפֶה עָגֹל מָתוֹק עִם רִבָּה בִּפְנִים שֶׁאוֹכְלִים בַּחֲנֻכָּה.",
            definitionNative = "Круглая сладкая выпечка с джемом внутри, которую едят на Хануку.",
            example = "כָּל יֶלֶד קִבֵּל סֻפְגָּנִיָּה אַחֲרֵי הַדְלָקַת הַנֵּרוֹת.",
            exampleNative = "Каждый ребёнок получил סֻפְגָּנִיָּה после зажигания свечей.",
         fillInBlankExclusions = listOf(171006L, 171007L)),
        WordEntity(
            id = 171006, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holidays_food", transliteration = "leviva",
            original = "לְבִיבָה", translation = "оладья (картофельная)",
            definition = "פְּרוּסָה שְׁטוּחָה מְטֻגֶּנֶת מִתַּפּוּחֵי אֲדָמָה לְשֻׁלְחַן הַחֲנֻכָּה.",
            definitionNative = "Жареный плоский ломтик из картошки, который подают на Хануку.",
            example = "סָבְתָא טִגְּנָה לְבִיבָה זְהֻבָּה לְכָל אוֹרֵחַ.",
            exampleNative = "Бабушка пожарила золотистую לְבִיבָה каждому гостю.",
         fillInBlankExclusions = listOf(171005L, 171007L)),
        WordEntity(
            id = 171007, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holidays_food", transliteration = "tmarim",
            original = "תְּמָרִים", translation = "финики",
            definition = "פֵּרוֹת קְטַנִּים חוּמִים וּמְתוּקִים שֶׁאוֹכְלִים בְּרֹאשׁ הַשָּׁנָה.",
            definitionNative = "Маленькие коричневые сладкие плоды, которые едят на еврейский Новый год.",
            example = "סִדַּרְנוּ תְּמָרִים בְּקַעֲרָה לִקְרַאת לֵיל הַחַג.",
            exampleNative = "Мы выложили תְּמָרִים в миску перед праздничным вечером.",
         fillInBlankExclusions = listOf(171005L, 171006L)),
        WordEntity(
            id = 171008, setId = 1710, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "holidays_food", transliteration = "ugat dvash",
            original = "עֻגַת דְּבַשׁ", translation = "медовик",
            definition = "מַאֲפֶה רַךְ וְחוּם מָתוֹק שֶׁמַּכִּינִים בְּרֹאשׁ הַשָּׁנָה לְשָׁנָה מְתוּקָה.",
            definitionNative = "Мягкая коричневая сладкая выпечка, которую готовят на Новый год к сладкому году.",
            example = "אִמָּא אוֹפָה עֻגַת דְּבַשׁ גְּבוֹהָה לְכָל הָאוֹרְחִים.",
            exampleNative = "Мама печёт высокий עֻגַת דְּבַשׁ для всех гостей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 171009, setId = 1710, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "holidays_food", transliteration = "tapukhei dvash",
            original = "תַּפּוּחֵי דְּבַשׁ", translation = "яблоки в мёду",
            definition = "פְּרוּסוֹת פְּרִי טוֹבְלוֹת בְּנוֹזֵל זְהֻבָּה — סִימָן לְשָׁנָה טוֹבָה.",
            definitionNative = "Дольки фрукта, обмакнутые в золотистую жидкость — символ доброго года.",
            example = "בְּעֶרֶב הַחַג טָבַלְנוּ תַּפּוּחֵי דְּבַשׁ עַל הַשֻּׁלְחָן.",
            exampleNative = "В праздничный вечер мы обмакнули תַּפּוּחֵי דְּבַשׁ за столом.",
            isFillInBlankSafe = false,
        ),

        // ── holidays_celebration (5 — 3 COMMON + 2 UNCOMMON; трапеза и гости) ──
        WordEntity(
            id = 171010, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "holidays_celebration", transliteration = "arukhat khag",
            original = "אֲרוּחַת חַג", translation = "праздничный обед",
            definition = "אֲכִילָה גְּדוֹלָה וּמְשֻׁתֶּפֶת בְּיוֹם מְיֻחָד שֶׁל הַשָּׁנָה.",
            definitionNative = "Большой совместный приём пищи в особый день года.",
            example = "כָּל הַמִּשְׁפָּחָה הִתְכַּנְּסָה לַאֲרוּחַת חַג שִׂמְחָה.",
            exampleNative = "Вся семья собралась на радостный אֲרוּחַת חַג.",
         fillInBlankExclusions = listOf(171011L, 171012L, 171013L, 171014L)),
        WordEntity(
            id = 171011, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "holidays_celebration", transliteration = "orkhei hakhag",
            original = "אוֹרְחֵי הַחַג", translation = "гости праздника",
            definition = "אֲנָשִׁים שֶׁבָּאוּ לַבַּיִת לַחֲגֹג בְּיוֹם הַמּוֹעֵד.",
            definitionNative = "Люди, которые пришли в дом отметить торжественный день вместе.",
            example = "הַסַּלּוֹן הָיָה מָלֵא שִׂמְחָה כְּשֶׁהִגִּיעוּ אוֹרְחֵי הַחַג.",
            exampleNative = "Гостиная наполнилась радостью, когда пришли אוֹרְחֵי הַחַג.",
         fillInBlankExclusions = listOf(171010L, 171012L, 171013L, 171014L)),
        WordEntity(
            id = 171012, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "holidays_celebration", transliteration = "matanot lekhag",
            original = "מַתָּנוֹת לְחַג", translation = "подарки к празднику",
            definition = "דְּבָרִים יָפִים שֶׁנּוֹתְנִים לִילָדִים אוֹ לַחֲבֵרִים בְּיוֹם הַמּוֹעֵד.",
            definitionNative = "Красивые вещи, которые дарят детям или друзьям в торжественный день.",
            example = "הַסָּבִים תָּמִיד מְבִיאִים מַתָּנוֹת לְחַג לַנְּכָדִים שֶׁלָּהֶם.",
            exampleNative = "Дедушки и бабушки всегда приносят מַתָּנוֹת לְחַג своим внукам.",
         fillInBlankExclusions = listOf(171010L, 171011L, 171013L, 171014L)),
        WordEntity(
            id = 171013, setId = 1710, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "holidays_celebration", transliteration = "se'uda khagigit",
            original = "סְעוּדָה חֲגִיגִית", translation = "торжественная трапеза",
            definition = "אֲכִילָה רִשְׁמִית עִם בְּגָדִים יָפִים וּבְרָכוֹת מְיֻחָדוֹת.",
            definitionNative = "Официальный приём пищи с нарядной одеждой и особыми благословениями.",
            example = "הִזְמַנּוּ אֶת כָּל הַשְּׁכֵנִים לִסְעוּדָה חֲגִיגִית בָּעֶרֶב.",
            exampleNative = "Мы пригласили всех соседей на סְעוּדָה חֲגִיגִית вечером.",
         fillInBlankExclusions = listOf(171010L, 171011L, 171012L, 171014L)),
        WordEntity(
            id = 171014, setId = 1710, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "holidays_celebration", transliteration = "se'udat shabat",
            original = "סִעוּדַת שַׁבָּת", translation = "субботняя трапеза",
            definition = "אֲכִילָה אִטִּית וּמְהֻדֶּרֶת בְּיוֹם הַמְּנוּחָה הַשְּׁבִיעִי.",
            definitionNative = "Неспешный изысканный приём пищи в седьмой день покоя недели.",
            example = "סִעוּדַת שַׁבָּת מַתְחִילָה אַחֲרֵי הַקִּדּוּשׁ עַל הַיַּיִן.",
            exampleNative = "סִעוּדַת שַׁבָּת начинается после кидуша над вином.",
         fillInBlankExclusions = listOf(171010L, 171011L, 171012L, 171013L)),

        // ── holidays_greetings (5 — 3 COMMON + 2 UNCOMMON; поздравления, восклицания) ──
        WordEntity(
            id = 171015, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "holidays_greetings", transliteration = "mazal tov",
            original = "מַזַּל טוֹב", translation = "поздравляю!",
            definition = "אֲמִירַת שִׂמְחָה לְאָדָם שֶׁקָּרָה לוֹ דָּבָר טוֹב וְחָשׁוּב.",
            definitionNative = "Радостное восклицание человеку, у которого случилось что-то хорошее и важное.",
            example = "כָּל הָאוֹרְחִים אָמְרוּ מַזַּל טוֹב לֶחָתָן הַצָּעִיר.",
            exampleNative = "Все гости сказали מַזַּל טוֹב молодому жениху.",
         fillInBlankExclusions = listOf(171016L, 171017L, 171018L, 171019L)),
        WordEntity(
            id = 171016, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "interjection", semanticGroup = "holidays_greetings", transliteration = "amen",
            original = "אָמֵן", translation = "аминь",
            definition = "מִלָּה קְצָרָה שֶׁאוֹמְרִים לְאַחַר בְּרָכָה — סִימָן לְהַסְכָּמָה.",
            definitionNative = "Короткое слово после благословения — знак согласия и подтверждения.",
            example = "כָּל הַקָּהָל עָנָה אָמֵן בִּקְרִיאָה רוֹעֶמֶת.",
            exampleNative = "Вся община ответила אָמֵן громким возгласом.",
         fillInBlankExclusions = listOf(171015L, 171017L)),
        WordEntity(
            id = 171017, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "interjection", semanticGroup = "holidays_greetings", transliteration = "halleluya",
            original = "הַלְלוּיָה", translation = "слава Богу!",
            definition = "קְרִיאַת שֶׁבַח וְשִׂמְחָה לְאֵל בִּזְמַן תְּפִלָּה אוֹ שִׁיר.",
            definitionNative = "Восторженное прославление Бога во время молитвы или песни.",
            example = "הַסַּבָּא קָרָא הַלְלוּיָה כְּשֶׁשָּׁמַע אֶת הַחֲדָשׁוֹת הַטּוֹבוֹת.",
            exampleNative = "Дедушка воскликнул הַלְלוּיָה, когда услышал хорошие новости.",
         fillInBlankExclusions = listOf(171016L)),
        WordEntity(
            id = 171018, setId = 1710, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "holidays_greetings", transliteration = "shnat brakha",
            original = "שְׁנַת בְּרָכָה", translation = "благословенный год",
            definition = "אִחוּל לְזְמַן טוֹב, בָּרִיא וּמְלֵא הַצְלָחָה לִפְנֵי הָאָדָם.",
            definitionNative = "Пожелание хорошего, здорового и удачного периода впереди.",
            example = "הָרַב אִחֵל לַקָּהָל שְׁנַת בְּרָכָה טוֹבָה לְכֻלָּם.",
            exampleNative = "Раввин пожелал общине доброго שְׁנַת בְּרָכָה для всех.",
         fillInBlankExclusions = listOf(171015L, 171019L)),
        WordEntity(
            id = 171019, setId = 1710, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "holidays_greetings", transliteration = "tsom kal",
            original = "צוֹם קַל", translation = "лёгкого поста!",
            definition = "אִחוּל שֶׁאוֹמְרִים לִפְנֵי יוֹם שֶׁבּוֹ לֹא אוֹכְלִים וְלֹא שׁוֹתִים.",
            definitionNative = "Пожелание перед днём, когда нельзя есть и пить.",
            example = "הַחֲבֵרִים בָּעֲבוֹדָה אִחֲלוּ אֶחָד לַשֵּׁנִי צוֹם קַל.",
            exampleNative = "Коллеги на работе пожелали друг другу צוֹם קַל.",
         fillInBlankExclusions = listOf(171015L, 171018L)),

        // ── holidays_purim (3 — 2 COMMON + 1 UNCOMMON; атрибуты Пурима) ──
        WordEntity(
            id = 171020, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holidays_purim", transliteration = "masekha",
            original = "מַסֵּכָה", translation = "маска (карнавальная)",
            definition = "כִּסּוּי לַפָּנִים שֶׁיְּלָדִים לוֹבְשִׁים בִּפְּעָמִיִם שֶׁל שִׂמְחָה.",
            definitionNative = "Покрытие на лицо, которое дети надевают по случаю весёлого торжества.",
            example = "הַיֶּלֶד בָּחַר מַסֵּכָה שֶׁל אַרְיֵה לִכְבוֹד הַחַג.",
            exampleNative = "Мальчик выбрал מַסֵּכָה льва ради праздника.",
         fillInBlankExclusions = listOf(171021L, 171022L)),
        WordEntity(
            id = 171021, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holidays_purim", transliteration = "ra'ashan",
            original = "רַעֲשָׁן", translation = "трещотка (пуримская)",
            definition = "כְּלִי קָטָן שֶׁיְּלָדִים מְסוֹבְבִים כְּדֵי לְהַשְׁמִיעַ קוֹל גָּדוֹל.",
            definitionNative = "Маленький инструмент, которым дети крутят, чтобы получился громкий звук.",
            example = "בְּקְרִיאַת שֵׁם הָמָן הַיְּלָדִים סוֹבְבוּ אֶת הָרַעֲשָׁן.",
            exampleNative = "При имени Амана дети крутили רַעֲשָׁן.",
         fillInBlankExclusions = listOf(171020L, 171022L)),
        WordEntity(
            id = 171022, setId = 1710, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays_purim", transliteration = "malbushim",
            original = "מַלְבּוּשִׁים", translation = "наряды (карнавальные)",
            definition = "בְּגָדִים מְיֻחָדִים שֶׁלּוֹבְשִׁים לִכְבוֹד יוֹם הַחַג הָעַלִּיז.",
            definitionNative = "Особые одеяния, которые надевают ради весёлого торжественного дня.",
            example = "הָאַחָיוֹת תָּפְרוּ מַלְבּוּשִׁים מַרְהִיבִים לִקְרַאת הַמְּסִבָּה.",
            exampleNative = "Сёстры сшили роскошные מַלְבּוּשִׁים к приёму.",
         fillInBlankExclusions = listOf(171020L, 171021L, 171023L)),

        // ── holidays_song (3 — 1 COMMON + 2 UNCOMMON; песнопения и шествия) ──
        WordEntity(
            id = 171023, setId = 1710, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holidays_song", transliteration = "dgalim",
            original = "דְּגָלִים", translation = "флажки (праздничные)",
            definition = "פִּסּוֹת בַּד צִבְעוֹנִיּוֹת עַל מַקֵּל שֶׁיְּלָדִים מְנִיפִים בְּחַג.",
            definitionNative = "Цветные кусочки ткани на палочке, которыми дети машут на торжестве.",
            example = "הַיְּלָדִים הוֹלְכִים בַּתַּהֲלוּכָה וּמַחְזִיקִים דְּגָלִים.",
            exampleNative = "Дети идут в шествии и держат דְּגָלִים.",
         fillInBlankExclusions = listOf(171022L, 171024L, 171025L)),
        WordEntity(
            id = 171024, setId = 1710, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays_song", transliteration = "mizmor",
            original = "מִזְמוֹר", translation = "псалом",
            definition = "פֶּרֶק קָצָר שֶׁל שִׁיר וְתוֹדָה לֶאֱלֹהִים מִתּוֹךְ סֵפֶר תְּהִלִּים.",
            definitionNative = "Короткая глава песни-благодарности Богу из священной книги в Танахе.",
            example = "הַחַזָּן שָׁר מִזְמוֹר עַתִּיק בְּקוֹל רַךְ וְעָדִין.",
            exampleNative = "Кантор пел старинный מִזְמוֹר тихим нежным голосом.",
         fillInBlankExclusions = listOf(171023L, 171025L)),
        WordEntity(
            id = 171025, setId = 1710, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays_song", transliteration = "tehila",
            original = "תְּהִילָּה", translation = "хвала, прославление",
            definition = "מִלִּים שֶׁל הוֹקָרָה גְּדוֹלָה לֶאֱלֹהִים בִּזְמַן הַתְּפִלָּה.",
            definitionNative = "Слова великого почитания Бога во время молитвы.",
            example = "כָּל בֹּקֶר הוּא אוֹמֵר תְּהִילָּה לְאֵל בְּלֵב מָלֵא.",
            exampleNative = "Каждое утро он произносит תְּהִילָּה Богу с полным сердцем.",
         fillInBlankExclusions = listOf(171023L, 171024L)),
    )
}
