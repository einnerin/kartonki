package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Стартап" (вход в мир молодых компаний, базовая лексика).
 *
 * Set 1788: «Стартап» — основы (L1, COMMON+UNCOMMON):
 *           компания, основатель, команда, риск, рост.
 *
 * Тема ориентирована на русскоязычных репатриантов в Израиле, которые впервые
 * сталкиваются с израильской стартап-сценой: первая работа в молодой команде,
 * первый разговор с инвестором, первая попытка собственного бизнеса. Лексика —
 * самые общие понятия (компания, деньги, прибыль, рост, провал), без специальных
 * финансовых терминов: те идут в L3-L5 (1758-1760) и в наборах серии «Бизнес».
 *
 * Кросс-тематические пересечения с темами «Бизнес» и «Деньги» допустимы по правилу:
 * дубли `original` между РАЗНЫМИ темами разрешены. Внутри темы «Стартап» (1758-1760)
 * пересечений нет — L1 даёт обзорные слова, L3-L5 — узкие термины (MVP, runway, SAFE,
 * валидация, акселератор и т.д.).
 *
 * Распределение редкостей:
 *   Set 1788: 13 COMMON + 12 UNCOMMON.
 *
 * SemanticGroups (5 × 5):
 *   startup_basic_company — компания и сцена: фирма, стартап, новый бизнес,
 *                           маленькая фирма, сообщество предпринимателей
 *   startup_basic_people  — кто там работает: основатель, инвестор, советник,
 *                           наставник, первый сотрудник
 *   startup_basic_money   — деньги стартапа: собственные деньги, привлечение
 *                           капитала, прибыль, убыток, бюджет
 *   startup_basic_growth  — как растёт: развитие, клиенты, расширение,
 *                           зарубежный рынок, успех
 *   startup_basic_risk    — что может пойти не так: риск, провал, конкуренция,
 *                           ошибка, важный вывод
 *
 * Word IDs: setId × 100 + position (178801..178825).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewStartupL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1788, languagePair = "he-ru", orderIndex = 1788,
            name = "Стартап",
            description = "Базовая лексика: компания, основатель, команда, риск, рост",
            topic = "Стартап", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1788 — Стартап: основы (L1, COMMON+UNCOMMON, A1-A2)
        // 5 групп × 5 слов: company, people, money, growth, risk
        // ══════════════════════════════════════════════════════════════════════

        // ── startup_basic_company (5) — компания и сцена ──
        WordEntity(
            id = 178801, setId = 1788, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "startup_basic_company", transliteration = "khevra",
            original = "חֶבְרָה", translation = "компания (фирма)",
            definition = "אִרְגּוּן שֶׁבּוֹ אֲנָשִׁים עוֹבְדִים יַחַד וּמוֹכְרִים מַשֶּׁהוּ לְלָקוֹחוֹת.",
            definitionNative = "Организация, где люди работают вместе и продают что-то клиентам.",
            example = "הַחֶבְרָה שֶׁלָּנוּ הוּקְמָה לִפְנֵי שְׁנָתַיִם בְּתֵל אָבִיב.",
            exampleNative = "Наша חֶבְרָה была основана два года назад в Тель-Авиве.",
         fillInBlankExclusions = listOf(178802L, 178803L, 178804L, 178805L)),
        WordEntity(
            id = 178802, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_company", transliteration = "start-ap",
            original = "סְטַארְט-אַפּ", translation = "стартап",
            definition = "עֵסֶק טָרִי שֶׁמְּחַפֵּשׂ דֶּרֶךְ צְמִיחָה מְהִירָה בְּעֶזְרַת רַעְיוֹן חָדָשׁ.",
            definitionNative = "Свежий бизнес, что ищет путь быстрого роста через свежую идею.",
            example = "סְטַארְט-אַפּ מִתֵּל אָבִיב גִּיֵּס שְׁנֵי מִילְיוֹן דּוֹלָר לְפִתּוּחַ הַמּוּצָר.",
            exampleNative = "סְטַארְט-אַפּ из Тель-Авива поднял два миллиона долларов на разработку продукта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178803, setId = 1788, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "startup_basic_company", transliteration = "esek khadash",
            original = "עֵסֶק חָדָשׁ", translation = "новый бизнес",
            definition = "מַשֶּׁהוּ שֶׁבִּדְיוּק פּוֹתְחִים כְּדֵי לְהַרְוִויחַ כֶּסֶף בְּדֶרֶךְ עַצְמָאִית.",
            definitionNative = "Что-то, что только открывают, чтобы зарабатывать самостоятельно.",
            example = "אַחֲרֵי הַשֵּׁרוּת פָּתַחְתִּי עֵסֶק חָדָשׁ עִם חָבֵר מֵהַתִּיכוֹן.",
            exampleNative = "После службы я открыл עֵסֶק חָדָשׁ с другом со школы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178804, setId = 1788, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "startup_basic_company", transliteration = "firma ktana",
            original = "פִירְמָה קְטַנָּה", translation = "маленькая фирма",
            definition = "מִשְׂרָד עִם מְעַט עוֹבְדִים שֶׁכָּל אֶחָד שָׁם מַכִּיר אֶת כֻּלָּם.",
            definitionNative = "Контора с парой сотрудников — каждый знает там всех.",
            example = "פִירְמָה קְטַנָּה כְּמוֹ שֶׁלָּנוּ נוֹתֶנֶת לָעוֹבְדִים הַרְבֵּה אַחְרָיוּת.",
            exampleNative = "פִירְמָה קְטַנָּה вроде нашей даёт сотрудникам много ответственности.",
         fillInBlankExclusions = listOf(178801L, 178802L, 178803L, 178805L)),
        WordEntity(
            id = 178805, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_company", transliteration = "kehilat ha-yazamim",
            original = "קְהִילַּת הַיְּזָמִים", translation = "сообщество предпринимателей",
            definition = "כָּל הָאֲנָשִׁים שֶׁפָּתְחוּ עֲסָקִים וְנִפְגָּשִׁים לְהַחֲלִיף סִפּוּרִים וְעֵצוֹת.",
            definitionNative = "Люди, что открыли свои дела, и встречаются обмениваться историями и советами.",
            example = "קְהִילַּת הַיְּזָמִים בְּיִשְׂרָאֵל נֶחְשֶׁבֶת בֵּין הַחָזָקוֹת בָּעוֹלָם.",
            exampleNative = "קְהִילַּת הַיְּזָמִים в Израиле считается одной из сильнейших в мире.",
         fillInBlankExclusions = listOf(178801L, 178802L, 178803L, 178804L)),

        // ── startup_basic_people (5) — кто там работает ──
        WordEntity(
            id = 178806, setId = 1788, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "startup_basic_people", transliteration = "meyased",
            original = "מְיַסֵּד", translation = "основатель",
            definition = "אִישׁ שֶׁפָּתַח עֵסֶק מִכְּלוּם וְלוֹקֵחַ הַחְלָטוֹת בַּהַתְחָלָה.",
            definitionNative = "Человек, который открыл бизнес с нуля и решает всё на старте.",
            example = "הַמְּיַסֵּד הָרִאשׁוֹן עוֹדֶנּוּ עוֹבֵד בַּחֶבְרָה אַחֲרֵי עֶשֶׂר שָׁנִים.",
            exampleNative = "Первый מְיַסֵּד до сих пор работает в фирме спустя десять лет.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178807, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_people", transliteration = "mashkia",
            original = "מַשְׁקִיעַ", translation = "инвестор",
            definition = "מִי שֶׁנּוֹתֵן כֶּסֶף לַחֶבְרָה כְּדֵי לְקַבֵּל חֵלֶק מֵהָרֶוַח בֶּעָתִיד.",
            definitionNative = "Тот, кто даёт фирме деньги, чтобы получить долю прибыли в будущем.",
            example = "מַשְׁקִיעַ מֵאַמֵרִיקָה הִתְעַנְיֵן בָּרַעְיוֹן שֶׁלָּנוּ אַחֲרֵי הַכֶּנֶס.",
            exampleNative = "מַשְׁקִיעַ из Америки заинтересовался нашей идеей после конференции.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178808, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_people", transliteration = "yo'ets",
            original = "יוֹעֵץ", translation = "советник",
            definition = "אִישׁ מְנֻסֶּה שֶׁנּוֹתֵן עֵצוֹת לַחֶבְרָה תְּמוּרַת תַּשְׁלוּם אוֹ מְנָיוֹת.",
            definitionNative = "Опытный человек, что даёт советы фирме за плату или акции.",
            example = "הַיּוֹעֵץ שֶׁלָּנוּ הִצִּיעַ לְפַשֵּׁט אֶת הַמּוּצָר לְשׁוּק קָטָן יוֹתֵר.",
            exampleNative = "Наш יוֹעֵץ предложил упростить продукт для рынка поменьше.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178809, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_people", transliteration = "khoneikh",
            original = "חוֹנֵךְ", translation = "наставник",
            definition = "מִישֶׁהוּ מְנֻסֶּה שֶׁמְּלַוֶּה אִישׁ צָעִיר וְעוֹזֵר לוֹ לִגְדּוֹל בָּעֲבוֹדָה.",
            definitionNative = "Опытный человек, что сопровождает молодого и помогает ему расти в работе.",
            example = "חוֹנֵךְ טוֹב יָכוֹל לַחְסֹךְ לִיזָם שָׁנִים שֶׁל טָעֻיּוֹת.",
            exampleNative = "Хороший חוֹנֵךְ способен сэкономить предпринимателю годы ошибок.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178810, setId = 1788, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "startup_basic_people", transliteration = "oved rishon",
            original = "עוֹבֵד רִאשׁוֹן", translation = "первый сотрудник",
            definition = "הָאִישׁ שֶׁהִצְטָרֵף לַצֶּוֶות מִיָּד אַחֲרֵי הַמְּיַסְּדִים וְעָשָׂה כִּמְעַט הַכֹּל.",
            definitionNative = "Человек, что присоединился к команде сразу после основателей и делал всё подряд.",
            example = "הָעוֹבֵד רִאשׁוֹן שֶׁלָּנוּ עוֹדֶנּוּ אַחְרַאי עַל שֵׁרוּת לְלָקוֹחוֹת.",
            exampleNative = "Наш עוֹבֵד רִאשׁוֹן до сих пор отвечает за поддержку клиентов.",
         fillInBlankExclusions = listOf(178806L, 178807L, 178808L, 178809L)),

        // ── startup_basic_money (5) — деньги стартапа ──
        WordEntity(
            id = 178811, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_money", transliteration = "kesef atsmi",
            original = "כֶּסֶף עַצְמִי", translation = "собственные деньги",
            definition = "מַה שֶּׁשָּׂמִים מֵהַחִסָּכוֹן הָאִישִׁי כְּדֵי לְהַתְחִיל בְּלִי לְבַקֵּשׁ מֵאַף אֶחָד.",
            definitionNative = "То, что вкладывают из личных сбережений, чтобы начать без чужой помощи.",
            example = "הִשְׁקַעְנוּ כֶּסֶף עַצְמִי כְּדֵי לִבְנוֹת אֶת הַגִּרְסָה הָרִאשׁוֹנָה לְבַד.",
            exampleNative = "Мы вложили כֶּסֶף עַצְמִי, чтобы построить первую версию сами.",
         fillInBlankExclusions = listOf(178812L, 178813L, 178814L, 178815L)),
        WordEntity(
            id = 178812, setId = 1788, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "startup_basic_money", transliteration = "giyus hon",
            original = "גִּיּוּס הוֹן", translation = "привлечение капитала",
            definition = "כְּשֶׁעֵסֶק מְבַקֵּשׁ כֶּסֶף מֵאֲנָשִׁים מִבַּחוּץ כְּדֵי לִגְדּוֹל מַהֵר יוֹתֵר.",
            definitionNative = "Когда бизнес просит деньги у людей со стороны, чтобы расти быстрее.",
            example = "גִּיּוּס הוֹן רִאשׁוֹן לָקַח לָנוּ חֲצִי שָׁנָה וְהַרְבֵּה פְּגִישׁוֹת.",
            exampleNative = "Первое גִּיּוּס הוֹן заняло у нас полгода и кучу встреч.",
         fillInBlankExclusions = listOf(178811L, 178813L, 178814L, 178815L)),
        WordEntity(
            id = 178813, setId = 1788, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "startup_basic_money", transliteration = "revakh",
            original = "רֶוַח", translation = "прибыль",
            definition = "מַה שֶּׁנִּשְׁאָר מֵהַכֶּסֶף שֶׁל הַלָּקוֹחוֹת אַחֲרֵי שֶׁמְּשַׁלְּמִים עַל הַכֹּל.",
            definitionNative = "То, что остаётся от клиентских денег после оплаты всех расходов.",
            example = "רֶוַח קָטָן מִכָּל לָקוֹחַ הוֹפֵךְ לְסַכּוּם רְצִינִי בְּסוֹף הַשָּׁנָה.",
            exampleNative = "Маленький רֶוַח с каждого клиента превращается в серьёзную сумму к концу года.",
         fillInBlankExclusions = listOf(178811L, 178812L, 178814L, 178815L)),
        WordEntity(
            id = 178814, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_money", transliteration = "hefsed",
            original = "הֶפְסֵד", translation = "убыток",
            definition = "כְּשֶׁהוֹצִיאוּ יוֹתֵר כֶּסֶף מִמַּה שֶּׁהִכְנִיסוּ וְנִשְׁאָרִים בְּמִינוּס.",
            definitionNative = "Когда потратили больше, чем заработали — и остаются в минусе.",
            example = "הָרִבְעוֹן הָרִאשׁוֹן נִסְגַּר בְּהֶפְסֵד בִּגְלַל הַעֲסָקַת מְפַתְּחִים.",
            exampleNative = "Первый квартал закрылся в הֶפְסֵד из-за найма разработчиков.",
         fillInBlankExclusions = listOf(178811L, 178812L, 178813L, 178815L)),
        WordEntity(
            id = 178815, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_money", transliteration = "taktsiv",
            original = "תַּקְצִיב", translation = "бюджет",
            definition = "תָּכְנִית כַּמָּה כֶּסֶף מֻתָּר לְהוֹצִיא עַל כָּל דָּבָר בַּחֹדֶשׁ אוֹ בַּשָּׁנָה.",
            definitionNative = "План, сколько денег можно потратить на каждое дело за месяц или год.",
            example = "הַתַּקְצִיב לְשִׁוּוּק הַחֹדֶשׁ קָטָן מִדַּי לְפִי הַמְּעַצֵּב.",
            exampleNative = "תַּקְצִיב на маркетинг этого месяца, по мнению дизайнера, маловат.",
         fillInBlankExclusions = listOf(178811L, 178812L, 178813L, 178814L)),

        // ── startup_basic_growth (5) — как растёт ──
        WordEntity(
            id = 178816, setId = 1788, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "startup_basic_growth", transliteration = "hitpatkhut",
            original = "הִתְפַּתְּחוּת", translation = "развитие",
            definition = "כְּשֶׁהֶעֵסֶק נַעֲשֶׂה גָּדוֹל יוֹתֵר — יוֹתֵר אֲנָשִׁים, יוֹתֵר כֶּסֶף, יוֹתֵר עָרִים.",
            definitionNative = "Когда бизнес становится больше — людей, денег и городов больше.",
            example = "הַהִתְפַּתְּחוּת הָאֲמִיתִּית הִתְחִילָה רַק אַחֲרֵי שָׁנָה וָחֵצִי.",
            exampleNative = "Настоящее הִתְפַּתְּחוּת началось только через полтора года.",
         fillInBlankExclusions = listOf(178817L, 178818L, 178819L, 178820L)),
        WordEntity(
            id = 178817, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_growth", transliteration = "lakokhot",
            original = "לָקוֹחוֹת", translation = "клиенты",
            definition = "אֲנָשִׁים שֶׁמְּשַׁלְּמִים בִּשְׁבִיל הַשֵּׁרוּת אוֹ הַמּוּצָר שֶׁלָּכֶם.",
            definitionNative = "Люди, что платят за ваш сервис или продукт.",
            example = "מֵאָה לָקוֹחוֹת רִאשׁוֹנִים מַגִּיעִים בְּדֶרֶךְ כְּלָל מֵהֶמְלָצוֹת שֶׁל חֲבֵרִים.",
            exampleNative = "Первые сто לָקוֹחוֹת обычно приходят по рекомендациям друзей.",
         fillInBlankExclusions = listOf(178816L, 178818L, 178819L, 178820L)),
        WordEntity(
            id = 178818, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_growth", transliteration = "harkhava",
            original = "הַרְחָבָה", translation = "расширение",
            definition = "כְּשֶׁמּוֹסִיפִים תְּחוּמִים, מוּצָרִים אוֹ מְקוֹמוֹת חֲדָשִׁים לְמַה שֶּׁכְּבָר עוֹשִׂים.",
            definitionNative = "Когда добавляют новые направления, продукты или места к тому, что уже делают.",
            example = "הַהַרְחָבָה לְשׁוּק הָעִסְקִי דָּרְשָׁה צֶוֶות מְכִירוֹת חָדָשׁ לְגַמְרֵי.",
            exampleNative = "הַרְחָבָה на корпоративный рынок потребовала совсем новой команды продаж.",
         fillInBlankExclusions = listOf(178816L, 178817L, 178819L, 178820L)),
        WordEntity(
            id = 178819, setId = 1788, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "startup_basic_growth", transliteration = "shuk zar",
            original = "שׁוּק זָר", translation = "зарубежный рынок",
            definition = "מְדִינָה אַחֶרֶת שֶׁלְּשָׁם מוֹכְרִים אַחֲרֵי שֶׁהָאָרֶץ שֶׁלָּנוּ כְּבָר קְטַנָּה לְהַמְשֵׁךְ.",
            definitionNative = "Другая страна, куда продают, когда родной страны уже мало для развития.",
            example = "כְּנִיסָה לְשׁוּק זָר דָּרְשָׁה תִּרְגּוּם וְשִׁנּוּי שִׁיטוֹת תַּשְׁלוּם.",
            exampleNative = "Выход на שׁוּק זָר потребовал перевода и смены платёжных способов.",
         fillInBlankExclusions = listOf(178816L, 178817L, 178818L, 178820L)),
        WordEntity(
            id = 178820, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_growth", transliteration = "hatslakha",
            original = "הַצְלָחָה", translation = "успех",
            definition = "כְּשֶׁמַּשֶּׁהוּ קָשֶׁה שֶׁתִּכְנַנְתֶּם בָּאֱמֶת קָרָה וְעָבַד טוֹב יוֹתֵר מֵהַצָּפוּי.",
            definitionNative = "Когда трудное, что вы задумали, и правда случилось — даже лучше ожиданий.",
            example = "הַהַצְלָחָה שֶׁל הַקַּמְפֵּיין הִפְתִּיעָה גַּם אֶת הַמְּיַסְּדִים בְּעַצְמָם.",
            exampleNative = "הַצְלָחָה кампании удивила и самих основателей.",
         fillInBlankExclusions = listOf(178816L, 178817L, 178818L, 178819L, 178822L)),

        // ── startup_basic_risk (5) — что может пойти не так ──
        WordEntity(
            id = 178821, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_risk", transliteration = "sikun",
            original = "סִיכּוּן", translation = "риск",
            definition = "סִכּוּי שֶׁדָּבָר רַע יִקְרֶה — תַּשְׁלוּם לֹא יָבוֹא, מוּצָר לֹא יִמָּכֵר.",
            definitionNative = "Шанс, что произойдёт плохое — оплата не придёт, продукт не продастся.",
            example = "כָּל פְּתִיחַת עֵסֶק כּוֹלֶלֶת סִיכּוּן לְאַבֵּד אֶת הַחִסָּכוֹן הָאִישִׁי.",
            exampleNative = "В любом запуске бизнеса есть סִיכּוּן потерять личные сбережения.",
         fillInBlankExclusions = listOf(178822L, 178823L, 178824L, 178825L)),
        WordEntity(
            id = 178822, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_risk", transliteration = "kishalon",
            original = "כִּשָּׁלוֹן", translation = "провал",
            definition = "כְּשֶׁעֵסֶק לֹא הַצְלִיחַ וְצָרִיךְ לִסְגֹּר אוֹתוֹ אַחֲרֵי שֶׁהַכֶּסֶף נִגְמָר.",
            definitionNative = "Когда бизнес не получился и его нужно закрывать после того, как кончились деньги.",
            example = "כִּשָּׁלוֹן רִאשׁוֹן לִמֵּד אוֹתִי לִשְׁאֹל לָקוֹחוֹת לִפְנֵי הַפִּתּוּחַ.",
            exampleNative = "Первый כִּשָּׁלוֹן научил меня спрашивать клиентов до разработки.",
         fillInBlankExclusions = listOf(178821L, 178823L, 178824L, 178825L)),
        WordEntity(
            id = 178823, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_risk", transliteration = "takharut",
            original = "תַּחֲרוּת", translation = "конкуренция",
            definition = "כְּשֶׁחֲבָרוֹת אֲחֵרוֹת מוֹכְרוֹת מַשֶּׁהוּ דּוֹמֶה וְכָל אַחַת רוֹצָה אֶת אוֹתָם הַלָּקוֹחוֹת.",
            definitionNative = "Когда другие фирмы продают похожее и каждая хочет тех же клиентов.",
            example = "הַתַּחֲרוּת בַּשּׁוּק הַמְּקוֹמִי גָּדְלָה מְאוֹד אַחֲרֵי הַמַּגֵּפָה.",
            exampleNative = "תַּחֲרוּת на местном рынке сильно выросла после пандемии.",
         fillInBlankExclusions = listOf(178821L, 178822L, 178824L, 178825L)),
        WordEntity(
            id = 178824, setId = 1788, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "startup_basic_risk", transliteration = "ta'ut",
            original = "טָעוּת", translation = "ошибка",
            definition = "הַחְלָטָה שֶׁהִתְבָּרְרָה כִּלְקוּיָה אַחֲרֵי שֶׁכְּבָר הִשְׁקִיעוּ זְמַן וְכֶסֶף.",
            definitionNative = "Решение, что оказалось неверным уже после вложенных времени и денег.",
            example = "הָיְתָה לִי טָעוּת לִשְׂכֹּר מִשְׂרָד גָּדוֹל לִפְנֵי הַלָּקוֹחַ הָרִאשׁוֹן.",
            exampleNative = "Я сделал טָעוּת, сняв большой офис до первого клиента.",
         fillInBlankExclusions = listOf(178821L, 178822L, 178823L, 178825L)),
        WordEntity(
            id = 178825, setId = 1788, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_basic_risk", transliteration = "maskana khashuva",
            original = "מַסְקָנָה חֲשׁוּבָה", translation = "важный вывод",
            definition = "מַה שֶּׁמְּבִינִים אַחֲרֵי דָּבָר שֶׁלֹּא הָלַךְ טוֹב כְּדֵי לֹא לַחְזֹר עָלָיו.",
            definitionNative = "То, что осознают после неудачного дела — чтобы его не повторять.",
            example = "מַסְקָנָה חֲשׁוּבָה מֵהָרִבְעוֹן הַזֶּה הִיא לְדַבֵּר עִם הַשּׁוּק מֻקְדָּם יוֹתֵר.",
            exampleNative = "מַסְקָנָה חֲשׁוּבָה этого квартала — говорить с рынком пораньше.",
         fillInBlankExclusions = listOf(178821L, 178822L, 178823L, 178824L)),
    )
}
