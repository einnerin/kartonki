package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Retail, level 4 (1 set, 25 words).
 * Профессиональная лексика управляющего магазином: операционные процессы,
 * визуальный мерчандайзинг, KPI и метрики, договоры с поставщиками,
 * борьба с потерями.
 *
 * Set 1723 (level 4, EPIC + LEGENDARY) — заполняет пробел между level 3 (1366)
 * и level 5 (1367, 1368) в теме «Розница». Существующие сеты темы:
 * 1364 L1, 1365 L2, 1366 L3, 1367 L5, 1368 L5.
 *
 * Слова не пересекаются с другими сетами темы «Розница» и с близкими темами
 * «Бухгалтерия» / «Маркетинг» (проверено grep по original).
 *
 * Распределение редкостей: 15 EPIC + 10 LEGENDARY (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов каждая:
 *   retail_store_operations  — операционные действия менеджера
 *   retail_visual_merch      — визуальный мерчандайзинг
 *   retail_kpi_metrics       — KPI и метрики магазина
 *   retail_supplier_deals    — договоры с поставщиками
 *   retail_loss_prevention   — борьба с потерями
 */
object WordDataHebrewRetailL4 {

    val sets = listOf(
        WordSetEntity(
            id = 1723, languagePair = "he-ru", orderIndex = 1723,
            name = "Розница",
            description = "Управляющий магазином: операции, KPI, поставщики, потери",
            topic = "Розница", level = 4,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1723 — Розница: профессиональный (EPIC + LEGENDARY, C1–C2)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── retail_store_operations (5) — операционные действия менеджера ──
        WordEntity(
            id = 172301, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_store_operations", transliteration = "kabalat skhora",
            original = "קַבָּלַת סְחוֹרָה", translation = "приёмка товара",
            definition = "פְּעֻלָּה שֶׁבָּהּ הַחֲנוּת בּוֹדֶקֶת מִשְׁלוֹחַ חָדָשׁ מוּל הַתְּעוּדָה.",
            definitionNative = "Когда магазин сверяет привезённый груз с накладной перед оприходованием.",
            example = "קַבָּלַת סְחוֹרָה אוֹרְכָה הַבֹּקֶר כִּמְעַט שָׁעָה וָחֵצִי.",
            exampleNative = "קַבָּלַת סְחוֹרָה заняла сегодня утром почти полтора часа.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172302L, 172304L, 172305L)),
        WordEntity(
            id = 172302, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_store_operations", transliteration = "klitat melai",
            original = "קְלִיטַת מְלַאי", translation = "оприходование запаса",
            definition = "הַכְנָסַת הַפְּרִיטִים הַחֲדָשִׁים לַמַּעֲרֶכֶת אַחֲרֵי שֶׁהִגִּיעוּ לַחֲנוּת.",
            definitionNative = "Внесение новых товаров в учётную систему после доставки в магазин.",
            example = "קְלִיטַת מְלַאי נַעֲשֵׂית בַּסּוֹרֵק לְיַד דֶּלֶת הַמַּחְסָן.",
            exampleNative = "קְלִיטַת מְלַאי делается сканером возле двери склада.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172301L, 172304L, 172305L)),
        WordEntity(
            id = 172303, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "retail_store_operations", transliteration = "inventar",
            original = "אִינְוֶנְטָר", translation = "инвентаризация",
            definition = "סְפִירָה מְלֵאָה שֶׁל כָּל הַפְּרִיטִים בַּחֲנוּת לְהַשְׁוָאָה לַסְּפָרִים.",
            definitionNative = "Полный пересчёт всех товаров в магазине ради сверки с книгами.",
            example = "אִינְוֶנְטָר שֶׁל סוֹף הַשָּׁנָה נִמְשַׁךְ לַיְלָה שָׁלֵם.",
            exampleNative = "אִינְוֶנְטָר в конце года длилась всю ночь напролёт.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172304, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_store_operations", transliteration = "bikoret pnimit",
            original = "בִּקֹּרֶת פְּנִימִית", translation = "внутренний аудит магазина",
            definition = "בְּדִיקָה שֶׁל סְדָרִים וְשֶׁל קוּפָּה עַל יְדֵי צֶוֶת מִתּוֹךְ הָרֶשֶׁת.",
            definitionNative = "Проверка процессов и кассы силами сотрудников самой сети.",
            example = "בִּקֹּרֶת פְּנִימִית גִּלְּתָה פְּעָרִים קְטַנִּים בְּסִכּוּם הַקּוּפָּה.",
            exampleNative = "בִּקֹּרֶת פְּנִימִית выявила небольшие расхождения по кассе.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172301L, 172302L, 172305L, 172324L)),
        WordEntity(
            id = 172305, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_store_operations", transliteration = "sgirat khodesh",
            original = "סָגִירַת חוֹדֶשׁ", translation = "закрытие месяца",
            definition = "סִכּוּם רָשְׁמִי שֶׁל הַכְנָסוֹת וְהוֹצָאוֹת בְּסוֹף תְּקוּפַת דִּוּוּחַ.",
            definitionNative = "Официальное подведение итогов выручки и расходов за отчётный период.",
            example = "סָגִירַת חוֹדֶשׁ דּוֹרֶשֶׁת הַשְׁוָאָה בֵּין מְלַאי לַסְּפָרִים.",
            exampleNative = "סָגִירַת חוֹדֶשׁ требует сверки склада с бухгалтерскими книгами.",
            isFillInBlankSafe = true),

        // ── retail_visual_merch (5) — визуальный мерчандайзинг ──
        WordEntity(
            id = 172306, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_visual_merch", transliteration = "siduré madaf",
            original = "סִדּוּרֵי מַדָּף", translation = "расстановка на полке",
            definition = "הַסֵּדֶר שֶׁבּוֹ הַפְּרִיטִים מוּצָגִים לְפִי גֹּבַהּ עֵינַיִם וְקָטֶגוֹרְיָה.",
            definitionNative = "Порядок выкладки товаров по высоте глаз и тематическим зонам.",
            example = "סִדּוּרֵי מַדָּף הִתְחַלְּפוּ בִּגְלַל הַשָּׁקַת קַו חָדָשׁ.",
            exampleNative = "סִדּוּרֵי מַדָּף поменяли из-за выпуска новой линейки товаров.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172308L, 172309L, 172310L, 172323L)),
        WordEntity(
            id = 172307, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "retail_visual_merch", transliteration = "frontaz",
            original = "פְרוֹנְטַאז'", translation = "фейсинг (количество фасадов товара)",
            definition = "כַּמָּה יְחִידוֹת שֶׁל אוֹתוֹ מוּצָר רוֹאִים מִקֶּדֶם הַמַּדָּף.",
            definitionNative = "Сколько единиц одного товара видно с лицевой стороны полки.",
            example = "הוֹסַפְנוּ פְרוֹנְטַאז' לַמּוּצָר הַפּוֹפּוּלָרִי בִּגְלַל הַבִּקּוּשׁ.",
            exampleNative = "Мы расширили פְרוֹנְטַאז' популярного товара из-за спроса.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172308, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_visual_merch", transliteration = "teurat madaf",
            original = "תְּאוּרַת מָדָף", translation = "подсветка полки",
            definition = "אוֹר מְכֻוָּן עַל מַדָּף כְּדֵי לְהַבְלִיט מוּצָר וּלְמָשֹׁךְ עַיִן.",
            definitionNative = "Направленный свет на полку, чтобы выделить товар и притянуть взгляд.",
            example = "תְּאוּרַת מָדָף חַמָּה הִגְבִּירָה אֶת מְכִירוֹת הַיַּיִן.",
            exampleNative = "Тёплая תְּאוּרַת מָדָף подняла продажи вина.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172306L, 172309L, 172310L)),
        WordEntity(
            id = 172309, setId = 1723, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "retail_visual_merch", transliteration = "hatsagat khalon",
            original = "הַצָּגַת חַלּוֹן", translation = "оформление витрины",
            definition = "סִידּוּר אָמָּנוּתִי שֶׁל פְּרִיטִים מֵאֲחוֹרֵי זְכוּכִית הַכְּנִיסָה לַחֲנוּת.",
            definitionNative = "Художественная композиция товаров за стеклом у входа в магазин.",
            example = "הַצָּגַת חַלּוֹן הֶחָדָשָׁה מָשְׁכָה הוֹלְכֵי רֶגֶל מֵרָחוֹק.",
            exampleNative = "Новая הַצָּגַת חַלּוֹן притягивала прохожих издалека.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172306L, 172308L, 172310L)),
        WordEntity(
            id = 172310, setId = 1723, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "retail_visual_merch", transliteration = "psikhologyat kone",
            original = "פְּסִיכוֹלוֹגְיַת קוֹנֶה", translation = "психология покупателя",
            definition = "מַדָּע שֶׁבּוֹחֵן אֵיךְ אָדָם בּוֹחֵר מַה לִּקְנוֹת בְּתוֹךְ הֶחָנוּת.",
            definitionNative = "Наука о том, как человек принимает решение о покупке прямо в зале.",
            example = "פְּסִיכוֹלוֹגְיַת קוֹנֶה מַסְבִּירָה לָמָּה צְבָעִים חַמִּים מְעוֹדְדִים מְכִירָה.",
            exampleNative = "פְּסִיכוֹלוֹגְיַת קוֹנֶה объясняет, почему тёплые цвета подталкивают к покупке.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172306L, 172308L, 172309L)),

        // ── retail_kpi_metrics (5) — KPI и метрики магазина ──
        WordEntity(
            id = 172311, setId = 1723, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "retail_kpi_metrics", transliteration = "hakhnasa lamem-rebuá",
            original = "הַכְנָסָה לְמ\"ר", translation = "выручка на квадратный метр",
            definition = "כַּמָּה כֶּסֶף מַכְנִיס כָּל מֶטֶר רִבּוּעַ שֶׁל שְׁטַח מֶכֶר.",
            definitionNative = "Сколько денег приносит каждый квадратный метр торгового зала.",
            example = "הַכְנָסָה לְמ\"ר בַּסַּנִיף הַמֶּרְכָּזִי גְּבוֹהָה פִּי שְׁתַּיִם.",
            exampleNative = "הַכְנָסָה לְמ\"ר в центральном филиале вдвое выше остальных.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172312L, 172313L, 172314L, 172315L)),
        WordEntity(
            id = 172312, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_kpi_metrics", transliteration = "sal memutsa",
            original = "סַל מְמוּצָע", translation = "средняя корзина покупателя",
            definition = "הַסְּכוּם הָרָגִיל שֶׁלָּקוֹחַ מוֹצִיא בְּבִקּוּר אֶחָד בַּחֲנוּת.",
            definitionNative = "Обычная сумма, которую покупатель тратит за один заход в магазин.",
            example = "סַל מְמוּצָע בְּסוֹפֵי שָׁבוּעַ קוֹפֵץ בִּשְׁלוֹשִׁים אָחוּז.",
            exampleNative = "סַל מְמוּצָע в выходные подскакивает на тридцать процентов.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172311L, 172313L, 172314L, 172315L, 172322L)),
        WordEntity(
            id = 172313, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_kpi_metrics", transliteration = "yeilut oved",
            original = "יְעִילוּת עוֹבֵד", translation = "производительность сотрудника",
            definition = "מַדָּד שֶׁמַּרְאֶה כַּמָּה מְכִירוֹת מֵבִיא כָּל אִישׁ בְּמִשְׁמֶרֶת.",
            definitionNative = "Показатель того, сколько продаж даёт каждый человек за смену.",
            example = "יְעִילוּת עוֹבֵד מַשְׁפִּיעָה יָשִׁיר עַל הַבּוֹנוּס הַחָדְשִׁי.",
            exampleNative = "יְעִילוּת עוֹבֵד прямо влияет на месячный бонус кассира.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172311L, 172312L, 172314L, 172315L)),
        WordEntity(
            id = 172314, setId = 1723, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "retail_kpi_metrics", transliteration = "shi'ur khazara",
            original = "שִׁעוּר חֲזָרָה", translation = "доля возвратов товара",
            definition = "הַחֵלֶק מִכְּלַל הַמְּכִירוֹת שֶׁהוּחְזַר עַל יְדֵי לְקוּחוֹת בְּתוֹךְ חוֹדֶשׁ.",
            definitionNative = "Часть всех продаж, которую покупатели вернули обратно за месяц.",
            example = "שִׁעוּר חֲזָרָה גָּבוֹהַּ מְסַמֵּן בְּעָיָה בְּאֵיכוּת הַמּוּצָר.",
            exampleNative = "Высокий שִׁעוּר חֲזָרָה сигналит о проблеме с качеством товара.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172311L, 172312L, 172313L, 172315L, 172322L)),
        WordEntity(
            id = 172315, setId = 1723, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "retail_kpi_metrics", transliteration = "mekhirot lesha'a",
            original = "מְכִירוֹת לְשָׁעָה", translation = "продажи в час",
            definition = "סְכוּם מְכִירוֹת מְמֻצָּע בְּכָל שָׁעַת פְּעִילוּת בַּחֲנוּת.",
            definitionNative = "Средняя сумма продаж за каждый рабочий час магазина.",
            example = "מְכִירוֹת לְשָׁעָה אַחַר הַצָּהֳרַיִם תָּמִיד גְּבוֹהוֹת מֵהַבֹּקֶר.",
            exampleNative = "מְכִירוֹת לְשָׁעָה во второй половине дня всегда выше утренних.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172311L, 172312L, 172313L, 172314L, 172321L)),

        // ── retail_supplier_deals (5) — договоры с поставщиками ──
        WordEntity(
            id = 172316, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_supplier_deals", transliteration = "heskem rav-shnati",
            original = "הֶסְכֵּם רָב-שְׁנָתִי", translation = "многолетний договор",
            definition = "חוֹזֶה אֲרֹךְ טַוָוח עִם סַפָּק עַל אַסְפָּקָה קְבוּעָה לִשְׁנָתַיִם וָמַעְלָה.",
            definitionNative = "Длинный контракт с поставщиком о регулярных поставках на два года и больше.",
            example = "חָתַמְנוּ הֶסְכֵּם רָב-שְׁנָתִי עִם הַיֶּקֶב מֵהַגָּלִיל.",
            exampleNative = "Мы подписали הֶסְכֵּם רָב-שְׁנָתִי с винодельней из Галилеи.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172318L, 172319L, 172320L)),
        WordEntity(
            id = 172317, setId = 1723, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "retail_supplier_deals", transliteration = "retrobonus",
            original = "רֶטְרוֹבּוֹנוּס", translation = "ретробонус от поставщика",
            definition = "הַחְזֵר כֶּסֶף שֶׁסַפָּק נוֹתֵן לַחֲנוּת אַחֲרֵי שֶׁעָבְרוּ סַף יַעַד מוּסְכָּם.",
            definitionNative = "Возврат денег от поставщика магазину после превышения целевого порога продаж.",
            example = "הַסַּפָּק שִׁלֵּם רֶטְרוֹבּוֹנוּס שֶׁל חֲצִי אָחוּז עַל הַמַּחְזוֹר.",
            exampleNative = "Поставщик выплатил רֶטְרוֹבּוֹנוּס полпроцента от оборота.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172318, setId = 1723, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "retail_supplier_deals", transliteration = "tnaei madaf",
            original = "תְּנַאי מָדָף", translation = "условия выкладки",
            definition = "סְעִיפֵי הֶסְכֵּם עַל מָקוֹם וּבוֹלְטוּת הַמּוּצָר עַל גַּבֵּי הַמַּדָּף.",
            definitionNative = "Пункты соглашения о месте и заметности товара на полке магазина.",
            example = "תְּנַאי מָדָף הוֹסִיפוּ עַשְׂרוֹת אַלְפֵי שֶׁקֶל לַחוֹזֶה.",
            exampleNative = "תְּנַאי מָדָף добавили десятки тысяч шекелей к контракту.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172316L, 172319L, 172320L, 172323L)),
        WordEntity(
            id = 172319, setId = 1723, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "retail_supplier_deals", transliteration = "mekhir minimum",
            original = "מְחִיר מִינִימוּם", translation = "минимальная розничная цена",
            definition = "הַסַּף הַתַּחְתּוֹן שֶׁמִּתַּחְתָּיו אָסוּר לִמְכֹּר אֶת הַפְּרִיט בַּחֲנוּת.",
            definitionNative = "Нижний порог, ниже которого нельзя продавать товар в зале.",
            example = "הַיַּצְרָן הִכְתִּיב מְחִיר מִינִימוּם לְכָל קִמְעוֹנַאי בָּרֶשֶׁת.",
            exampleNative = "Производитель установил מְחִיר מִינִימוּם для каждого розничного партнёра.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172306L, 172307L, 172308L, 172316L, 172317L, 172318L, 172320L)),
        WordEntity(
            id = 172320, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_supplier_deals", transliteration = "akhrayut sapak",
            original = "אַחְרָיוּת סַפָּק", translation = "гарантия поставщика",
            definition = "הַתְחַיְּבוּת שֶׁל יַצְרָן לְהַחְלִיף פְּגוּמִים תּוֹךְ תְּקוּפָה מוּסְכֶּמֶת.",
            definitionNative = "Обязательство производителя заменить бракованный товар в оговорённый срок.",
            example = "אַחְרָיוּת סַפָּק כִּסְּתָה אֶת הַמַּקְפִּיא הַמְּקֻלְקָל.",
            exampleNative = "אַחְרָיוּת סַפָּק покрыла сломанный морозильный шкаф.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172316L, 172318L, 172319L)),

        // ── retail_loss_prevention (5) — борьба с потерями ──
        WordEntity(
            id = 172321, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_loss_prevention", transliteration = "gnevot khanut",
            original = "גְּנֵבוֹת חֲנוּת", translation = "магазинные кражи",
            definition = "מִקְרִים שֶׁבָּהֶם לָקוֹחוֹת לוֹקְחִים פְּרִיטִים בְּלִי לְשַׁלֵּם בַּקּוּפָּה.",
            definitionNative = "Случаи, когда посетители уносят товар, не оплачивая его на кассе.",
            example = "גְּנֵבוֹת חֲנוּת גָּדְלוּ בְּחֹדֶשׁ דֵּצֶמְבֶּר בִּגְלַל הַצְּפִיפוּת.",
            exampleNative = "גְּנֵבוֹת חֲנוּת выросли в декабре из-за толчеи в зале.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172315L, 172322L, 172323L, 172324L, 172325L)),
        WordEntity(
            id = 172322, setId = 1723, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "retail_loss_prevention", transliteration = "pakhat melai",
            original = "פַחַת מְלַאי", translation = "усушка / естественная убыль запасов",
            definition = "הַפְרֵשׁ שֶׁבֵּין הַסְּפִירָה בַּמַּחְסָן לְמַה שֶּׁרָשׁוּם בַּסְּפָרִים בְּלִי הֶסְבֵּר.",
            definitionNative = "Разница между фактическим остатком и учётным без явной причины.",
            example = "פַחַת מְלַאי שָׁנָתִי עָמַד עַל אָחוּז וָחֵצִי מֵהַמַּחְזוֹר.",
            exampleNative = "פַחַת מְלַאי за год составил полтора процента от оборота.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172314L, 172317L, 172321L, 172323L, 172324L, 172325L)),
        WordEntity(
            id = 172323, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_loss_prevention", transliteration = "tagei avtakha",
            original = "תַּגֵּי אֲבְטָחָה", translation = "защитные противокражные бирки",
            definition = "פְּרִיטִים מַגְנֵטִיִּים שֶׁמַּפְעִילִים אַזְעָקָה אִם יוֹצְאִים בְּלִי תַּשְׁלוּם.",
            definitionNative = "Магнитные клипсы, которые включают сигнал на выходе без оплаты товара.",
            example = "תַּגֵּי אֲבְטָחָה מְקֻבָּעִים בִּפְרִיטֵי לְבוּשׁ יְקָרִים.",
            exampleNative = "תַּגֵּי אֲבְטָחָה крепят на дорогую одежду в зале.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172321L, 172322L, 172324L, 172325L)),
        WordEntity(
            id = 172324, setId = 1723, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "retail_loss_prevention", transliteration = "matslemat avtakha",
            original = "מַצְלֵמַת אֲבְטָחָה", translation = "камера видеонаблюдения",
            definition = "מַכְשִׁיר שֶׁמַּקְלִיט מַה קּוֹרֶה בָּאוּלָם לְזִהוּי גַּנָּבִים אַחַר כָּךְ.",
            definitionNative = "Прибор, записывающий зал, чтобы потом распознать злоумышленников.",
            example = "מַצְלֵמַת אֲבְטָחָה תָּפְסָה אֶת הָאִישׁ לְיַד מַדַּף הַיַּיִן.",
            exampleNative = "מַצְלֵמַת אֲבְטָחָה поймала мужчину возле винной полки.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172304L, 172321L, 172322L, 172323L, 172325L)),
        WordEntity(
            id = 172325, setId = 1723, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "retail_loss_prevention", transliteration = "lakoakh nistar",
            original = "לְקוּחַ נִסְתָּר", translation = "тайный покупатель",
            definition = "אָדָם שֶׁמְּדַמֶּה קְנִיָּה רְגִילָה כְּדֵי לִבְדֹּק שֵׁרוּת וּסְדָרִים.",
            definitionNative = "Человек, имитирующий обычную покупку, чтобы оценить сервис и порядок.",
            example = "לְקוּחַ נִסְתָּר הִגִּישׁ דּוּחַ עַל הַזְמַנַּת תּוֹר אֶצְלֵנוּ.",
            exampleNative = "לְקוּחַ נִסְתָּר сдал отчёт о времени ожидания у нас в очереди.",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(172321L, 172322L, 172323L, 172324L)),
    )
}
