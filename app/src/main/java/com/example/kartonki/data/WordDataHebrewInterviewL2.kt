package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Собеседования", уровень L2 (продвинутый, UNCOMMON+RARE).
 *
 * Set 1753: «Собеседования» — поиск работы и нетворкинг (этап ДО собеседования):
 *   объявления о вакансиях, отклики и трекинг, нетворкинг, кадровые агентства,
 *   альтернативные пути в индустрию.
 *
 * Лексика смешанная: иврит + израильский лексикон рынка труда (хайтек),
 * включая англицизмы, которые реально звучат в офисах (פְרִילַנְס, מִיטָאפּ,
 * הִיבְּרִידִית). Тема ориентирована на русскоязычных репатриантов в Израиле,
 * только начинающих поиск работы — до того, как назначен первый звонок.
 *
 * Кросс-тематические пересечения с «Работа и карьера» (WordDataHebrewWorkV2.kt)
 * допустимы по правилу: дубли `original` между РАЗНЫМИ темами разрешены.
 *
 * Связь со смежными сетами темы:
 *   1752 (L1) — основы: ивритская база поиска (запланирован отдельно).
 *   1753 (L2) — этот сет: поиск, отклики, нетворкинг.
 *   1750 (L3) — резюме, рекрутер, первый звонок, опыт, мотивация.
 *   1751 (L4) — технические этапы и переговоры.
 *
 * Ни одно `original` из 1750/1751 не повторяется. Ни одной однокоренной пары
 * внутри 1753 (проверены шорошим всех 25 слов).
 *
 * Распределение редкостей: 13 UNCOMMON + 12 RARE.
 *
 * SemanticGroups (5 × 5):
 *   job_search_listings    — атрибуты вакансий: доска, ответственность,
 *                             часы, формат, фильтры
 *   job_search_applying    — отклик и трекинг: отправка, подтверждение,
 *                             отказ, фидбек, прогресс
 *   job_search_networking  — нетворкинг: конференция, митап, рекомендация,
 *                             тёплый контакт, внутренний реферал
 *   job_search_agency      — агентства и посредники: кадровая компания,
 *                             консультант, база, комиссия, эксклюзив
 *   job_search_alt_paths   — альтернативные пути: временная, фриланс,
 *                             стажировка, смена карьеры, переподготовка
 *
 * Word IDs: setId × 100 + position (175301..175325).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewInterviewL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1753, languagePair = "he-ru", orderIndex = 1753,
            name = "Собеседования",
            description = "Поиск работы и нетворкинг: вакансии, отклики, рекомендации, агентства",
            topic = "Собеседования", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1753 — Собеседования: продвинутый (L2, UNCOMMON+RARE)
        // 5 групп × 5 слов: listings, applying, networking, agency, alt_paths
        // ══════════════════════════════════════════════════════════════════════

        // ── job_search_listings (5) — атрибуты и поиск вакансий ──
        WordEntity(
            id = 175301, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_listings", transliteration = "luakh drushim",
            original = "לוּחַ דְּרוּשִׁים", translation = "доска вакансий",
            definition = "אֲתָר אוֹ עַמּוּד שֶׁבּוֹ מְפַרְסְמִים הַרְבֵּה מִשְׂרוֹת פְּנוּיוֹת בְּמָקוֹם אֶחָד.",
            definitionNative = "Сайт или страница, где собрано множество свободных позиций в одном месте.",
            example = "סָרַקְתִּי לוּחַ דְּרוּשִׁים גָּדוֹל בְּכָל בֹּקֶר עִם הַקָּפֶה.",
            exampleNative = "Я просматривал большую לוּחַ דְּרוּשִׁים каждое утро с кофе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175302, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_listings", transliteration = "tkhumey akhrayut",
            original = "תְּחוּמֵי אַחְרָיוּת", translation = "зоны ответственности",
            definition = "רְשִׁימַת הַמְּשִׂימוֹת שֶׁעַל הָעוֹבֵד לְבַצֵּעַ בִּפְעוּלָה הַיּוֹמְיוֹמִית בַּמִּשְׂרָה.",
            definitionNative = "Список задач, которые сотрудник выполняет каждый день на этой позиции.",
            example = "תְּחוּמֵי אַחְרָיוּת הָיוּ רְחָבִים מִדַּי לִשְׁתֵּי שָׁנוֹת נִסָּיוֹן.",
            exampleNative = "תְּחוּמֵי אַחְרָיוּת оказались слишком широкими для двух лет опыта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175303, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_listings", transliteration = "sha'ot gmishot",
            original = "שָׁעוֹת גְּמִישׁוֹת", translation = "гибкие часы",
            definition = "סִדּוּר זְמַן שֶׁבּוֹ הָעוֹבֵד בּוֹחֵר מָתַי לְהַתְחִיל וּמָתַי לִגְמֹר אֶת הַיּוֹם.",
            definitionNative = "График, при котором работник сам выбирает время начала и конца дня.",
            example = "שָׁעוֹת גְּמִישׁוֹת חָשׁוּבוֹת לִי בִּגְלַל הַיְּלָדִים בַּגַּן.",
            exampleNative = "שָׁעוֹת גְּמִישׁוֹת важны мне из-за детей в саду.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175304, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_listings", transliteration = "misra hibridit",
            original = "מִשְׂרָה הִיבְּרִידִית", translation = "гибридная позиция",
            definition = "פוֹרְמָט שֶׁל חֵצִי מִשְּׁרַד וְחֵצִי מֵרָחוֹק — כַּמָּה יָמִים בְּשָׁבוּעַ פֹּה וְשָׁם.",
            definitionNative = "Формат: половина в офисе, половина из дома — несколько дней в неделю там и там.",
            example = "מִשְׂרָה הִיבְּרִידִית מַאֲפְשֶׁרֶת לִי לָגוּר רָחוֹק יוֹתֵר מִתֵּל אָבִיב.",
            exampleNative = "מִשְׂרָה הִיבְּרִידִית позволяет мне жить дальше от Тель-Авива.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175305, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_listings", transliteration = "sinun totsa'ot",
            original = "סִנּוּן תּוֹצָאוֹת", translation = "фильтрация результатов",
            definition = "צִמְצוּם רְשִׁימָה אֲרֻכָּה לְפִי מָקוֹם, רָמָה אוֹ הֶיקֵף, כְּדֵי לִרְאוֹת רַק מַתְאִים.",
            definitionNative = "Сужение длинного списка по месту, уровню или объёму — чтобы видеть только подходящее.",
            example = "אַחֲרֵי סִנּוּן תּוֹצָאוֹת נִשְׁאֲרוּ לִי שְׁתֵּים עֶשְׂרֵה הַצָּעוֹת.",
            exampleNative = "После סִנּוּן תּוֹצָאוֹת у меня осталось двенадцать предложений.",
            isFillInBlankSafe = false,
        ),

        // ── job_search_applying (5) — отклик и трекинг ──
        WordEntity(
            id = 175306, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_applying", transliteration = "shlikhat masmakhim",
            original = "שְׁלִיחַת מַסְמָכִים", translation = "отправка документов",
            definition = "פְּעֻלַּת הַעֲבָרַת קוֹרוֹת חַיִּים וּתְעוּדוֹת לַחֶבְרָה כְּחֵלֶק מִדְּחִיפַת מֻעֳמָדוּת.",
            definitionNative = "Передача резюме и сертификатов в фирму как часть подачи на вакансию.",
            example = "שְׁלִיחַת מַסְמָכִים אוֹרֶכֶת חֲצִי שָׁעָה לְכָל מִשְׂרָה.",
            exampleNative = "שְׁלִיחַת מַסְמָכִים занимает полчаса на каждую вакансию.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175307, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_applying", transliteration = "ishur kabala",
            original = "אִישׁוּר קַבָּלָה", translation = "подтверждение получения",
            definition = "מֶסֶר אוֹטוֹמָטִי מֵהַחֶבְרָה שֶׁאוֹמֵר שֶׁהַחֳמָרִים שֶׁשְּׁלַחְתָּ הִגִּיעוּ אֲלֵיהֶם.",
            definitionNative = "Автосообщение от фирмы: материалы, которые ты отправил, дошли до них.",
            example = "אִישׁוּר קַבָּלָה הִגִּיעַ לְמַיְל תּוֹךְ דַּקָּה אַחַת בִּלְבַד.",
            exampleNative = "אִישׁוּר קַבָּלָה пришёл на почту всего за одну минуту.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175308, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_applying", transliteration = "dkhiya menumeket",
            original = "דְּחִיָּה מְנֻמֶּקֶת", translation = "обоснованный отказ",
            definition = "תְּשׁוּבָה שְׁלִילִית מֵחֶבְרָה עִם הֶסְבֵּר קָצָר לָמָּה הַמֻּעֳמָד לֹא הִתְקַבֵּל.",
            definitionNative = "Отрицательный ответ от фирмы с кратким объяснением, почему кандидат не подошёл.",
            example = "דְּחִיָּה מְנֻמֶּקֶת עוֹזֶרֶת לִי לְהַשְׁתַּפֵּר לִפְנֵי הָרֵאָיוֹן הַבָּא.",
            exampleNative = "דְּחִיָּה מְנֻמֶּקֶת помогает мне расти перед следующим интервью.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175309, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_applying", transliteration = "bakashat mashov",
            original = "בַּקָּשַׁת מַשׁוֹב", translation = "запрос обратной связи",
            definition = "פְּנִיָּה לְחֶבְרָה אַחֲרֵי תְּשׁוּבָה שְׁלִילִית כְּדֵי לָדַעַת מָה לְשַׁפֵּר בַּפַּעַם הַבָּאָה.",
            definitionNative = "Обращение к фирме после отказа: чтобы узнать, что улучшить в следующий раз.",
            example = "שָׁלַחְתִּי בַּקָּשַׁת מַשׁוֹב מְנֻמֶּסֶת אַחֲרֵי הָרֵאָיוֹן הַשֵּׁנִי.",
            exampleNative = "Я отправил вежливую בַּקָּשַׁת מַשׁוֹב после второго интервью.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175310, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_applying", transliteration = "ma'akav hitkadmut",
            original = "מַעֲקַב הִתְקַדְּמוּת", translation = "отслеживание прогресса",
            definition = "טַבְלָה אוֹ אַפְּלִיקַצְיָה שֶׁבָּהּ רוֹשְׁמִים אֵיךְ כָּל פְּנִיָּה לְחֶבְרָה זָזָה הָלְאָה.",
            definitionNative = "Таблица или приложение: записывают, как каждое обращение в фирму движется дальше.",
            example = "מַעֲקַב הִתְקַדְּמוּת מְסֻדָּר חָסַךְ לִי שָׁעוֹת בַּשָּׁבוּעַ הַשֵּׁנִי.",
            exampleNative = "Упорядоченный מַעֲקַב הִתְקַדְּמוּת сэкономил мне часы на второй неделе.",
            isFillInBlankSafe = false,
        ),

        // ── job_search_networking (5) — нетворкинг и связи ──
        WordEntity(
            id = 175311, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_networking", transliteration = "kenes miktso'i",
            original = "כֵּנֶס מִקְצוֹעִי", translation = "отраслевая конференция",
            definition = "אֵירוּעַ גָּדוֹל שֶׁאַנְשֵׁי הַתְּחוּם נִפְגָּשִׁים בּוֹ, שׁוֹמְעִים הַרְצָאוֹת וּמַכִּירִים זֶה אֶת זֶה.",
            definitionNative = "Большое мероприятие: тысячи людей сферы встречаются, слушают доклады и знакомятся.",
            example = "כֵּנֶס מִקְצוֹעִי בְּתֵל אָבִיב הֵבִיא לִי שְׁתֵּי הִכָּרוּיוֹת חֲשׁוּבוֹת.",
            exampleNative = "כֵּנֶס מִקְצוֹעִי в Тель-Авиве принёс мне два важных знакомства.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175312, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_networking", transliteration = "mitap",
            original = "מִיטָאפּ", translation = "митап (отраслевая встреча)",
            definition = "מִפְגָּשׁ קָטָן וּלֹא רִשְׁמִי שֶׁל אַנְשֵׁי הַתְּחוּם אַחֲרֵי הָעֲבוֹדָה בְּפַאבּ אוֹ בְּמִשְׂרָד.",
            definitionNative = "Маленькая неформальная встреча людей сферы после работы — в пабе или офисе.",
            example = "בַּמִּיטָאפּ פָּגַשְׁתִּי בָּחוּר שֶׁעוֹבֵד בַּחֶבְרָה שֶׁל חֲלוֹמוֹתַי.",
            exampleNative = "На מִיטָאפּ я встретил парня из фирмы моей мечты.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175313, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_networking", transliteration = "hamlatsa ishit",
            original = "הֶמְלָצָה אִישִׁית", translation = "личная рекомендация",
            definition = "מִכְתָּב אוֹ דְּבָרִים טוֹבִים שֶׁמִּישֶׁהוּ אוֹמֵר עֲלֵיךָ לְחֶבְרָה שֶׁמְּחַפֶּשֶׂת עוֹבֵד.",
            definitionNative = "Письмо или хорошие слова — кто-то говорит о тебе фирме, которая ищет сотрудника.",
            example = "הֶמְלָצָה אִישִׁית מִבּוֹס יָשָׁן פָּתְחָה לִי דֶּלֶת בְּלִי רֵאָיוֹן רִאשׁוֹן.",
            exampleNative = "הֶמְלָצָה אִישִׁית от старого босса открыла мне дверь без первого интервью.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175314, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_networking", transliteration = "kesher kham",
            original = "קֶשֶׁר חַם", translation = "тёплый контакт (warm intro)",
            definition = "הִכָּרוּת דֶּרֶךְ חָבֵר מְשֻׁתָּף, לֹא מֵאֶפֶס — מַה שֶּׁמַעֲלֶה אֶת סִכּוּי הַתְּשׁוּבָה.",
            definitionNative = "Знакомство через общего друга, а не с нуля — это сильно поднимает шанс ответа.",
            example = "קֶשֶׁר חַם דֶּרֶךְ עָמִית לְלִימּוּדִים הוֹבִיל אוֹתִי לְמַנְכָּ\"ל.",
            exampleNative = "קֶשֶׁר חַם через коллегу по учёбе вывел меня на гендиректора.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175315, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_networking", transliteration = "hafnaya pnimit",
            original = "הַפְנָיָה פְּנִימִית", translation = "внутренний реферал",
            definition = "כְּשֶׁעוֹבֵד בַּחֶבְרָה מַעֲבִיר אֶת קוֹרוֹת הַחַיִּים שֶׁלְּךָ יָשָׁר לַמְּגַיֵּיס מִבִּפְנִים.",
            definitionNative = "Когда сотрудник внутри фирмы передаёт твоё резюме рекрутеру изнутри.",
            example = "הַפְנָיָה פְּנִימִית מֵחָבֵר זִרְזָה אֶת הַתַּהֲלִיךְ בְּשָׁבוּעַ שָׁלֵם.",
            exampleNative = "הַפְנָיָה פְּנִימִית от друга ускорила процесс на целую неделю.",
            isFillInBlankSafe = false,
        ),

        // ── job_search_agency (5) — кадровые агентства и посредники ──
        WordEntity(
            id = 175316, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_agency", transliteration = "khevrat hasama",
            original = "חֶבְרַת הַשָּׂמָה", translation = "кадровая компания",
            definition = "עֵסֶק חִיצוֹנִי שֶׁמְּחַבֵּר בֵּין מְחַפְּשֵׂי עֲבוֹדָה לְבֵין מַעֲסִיקִים — וְלוֹקֵחַ אֲחוּז.",
            definitionNative = "Внешний бизнес-посредник между ищущими работу и работодателями — берёт процент.",
            example = "חֶבְרַת הַשָּׂמָה הִצִּיעָה לִי שָׁלוֹשׁ מִשְׂרוֹת בִּתְעַשִּׂיַּת הַסַּיְבֶּר.",
            exampleNative = "חֶבְרַת הַשָּׂמָה предложила мне три позиции в кибер-индустрии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175317, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_agency", transliteration = "yo'ets karyera",
            original = "יוֹעֵץ קַרְיֶירָה", translation = "карьерный консультант",
            definition = "אִישׁ מִקְצוֹעַ שֶׁעוֹזֵר לְהָבִין לְאָן לִפְנוֹת בַּשּׁוּק וְאֵיךְ לְהַצִּיג אֶת עַצְמְךָ נָכוֹן.",
            definitionNative = "Профессионал — помогает понять, куда идти на рынке и как правильно себя подать.",
            example = "יוֹעֵץ קַרְיֶירָה עָזַר לִי לְזַהוֹת חֲזָקוֹת שֶׁלֹּא רָאִיתִי לְבַד.",
            exampleNative = "יוֹעֵץ קַרְיֶירָה помог мне увидеть сильные стороны, которых я не замечал.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175318, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_agency", transliteration = "ma'agar mu'amadim",
            original = "מַאֲגַר מוּעֳמָדִים", translation = "база кандидатов",
            definition = "אֹסֶף גָּדוֹל שֶׁל קוֹרוֹת חַיִּים שֶׁל אַנָשִׁים מוּכָנִים, שֶׁמְּגַיְּיסִים שׁוֹלְפִים מִמֶּנּוּ.",
            definitionNative = "Большой набор резюме готовых людей — рекрутеры подбирают оттуда.",
            example = "אֲנִי בְּתוֹךְ מַאֲגַר מוּעֳמָדִים שֶׁל שָׁלוֹשׁ סוֹכְנֻיוֹת בּוֹ זְמַנִּית.",
            exampleNative = "Я внутри מַאֲגַר מוּעֳמָדִים трёх агентств одновременно.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175319, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_agency", transliteration = "amlat itur",
            original = "עֲמָלַת אִתּוּר", translation = "комиссия за поиск (расценка агентства)",
            definition = "סְכוּם שֶׁמַּעֲסִיק מְשַׁלֵּם לַסּוֹכְנוּת אַחֲרֵי שֶׁהַמֻּעֳמָד שֶׁלָּהּ הִתְקַבֵּל.",
            definitionNative = "Сумма, которую работодатель платит агентству, когда приведённый кандидат принят.",
            example = "עֲמָלַת אִתּוּר נֶעֱנֵית בְּשָׁלִישׁ הַמַּשְׂכֹּרֶת הַשְּׁנָתִית בַּחֲבִילָה.",
            exampleNative = "עֲמָלַת אִתּוּר встаёт в треть годовой зарплаты в этой схеме.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175320, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_agency", transliteration = "heskem bil'adiyut",
            original = "הֶסְכֵּם בִּלְעַדִיּוּת", translation = "эксклюзивный договор",
            definition = "חוֹזֶה שֶׁבּוֹ מְחַפֵּשׂ עֲבוֹדָה מַבְטִיחַ לַסּוֹכְנוּת אַחַת בִּלְבַד אֶת הַטִּפּוּל בּוֹ.",
            definitionNative = "Контракт: ищущий работу обещает только одному агентству заниматься его кейсом.",
            example = "סָרַבְתִּי לַחְתֹּם עַל הֶסְכֵּם בִּלְעַדִיּוּת לִשְׁנָתַיִם.",
            exampleNative = "Я отказался подписывать הֶסְכֵּם בִּלְעַדִיּוּת на два года.",
            isFillInBlankSafe = false,
        ),

        // ── job_search_alt_paths (5) — альтернативные пути в индустрию ──
        WordEntity(
            id = 175321, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_alt_paths", transliteration = "avoda zmanit",
            original = "עֲבוֹדָה זְמַנִּית", translation = "временная работа",
            definition = "תַּפְקִיד לִתְקוּפָה קְצָרָה עִם תַּאֲרִיךְ סִיּוּם יָדוּעַ — לְכַמָּה חֳדָשִׁים אוֹ לְפְּרוֹיֶקְט.",
            definitionNative = "Должность на короткий срок с известной датой окончания — на пару месяцев или проект.",
            example = "עֲבוֹדָה זְמַנִּית בַּקֵּיץ נָתְנָה לִי הַכְנָסָה בִּזְמַן הַחִפּוּשׂ.",
            exampleNative = "עֲבוֹדָה זְמַנִּית летом дала мне доход во время поиска.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175322, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_alt_paths", transliteration = "frilans",
            original = "פְרִילַנְס", translation = "фриланс",
            definition = "מָתְכֹּנֶת עַצְמָאִית: לוֹקְחִים פְּרוֹיֶקְטִים מִכַּמָּה לָקוֹחוֹת בְּלִי מַעֲסִיק קָבוּעַ.",
            definitionNative = "Формат: ты сам по себе, берёшь проекты у нескольких клиентов, не привязан к одному офису.",
            example = "אַחֲרֵי שָׁנָה שֶׁל פְרִילַנְס הֶחְלַטְתִּי לַחֲזוֹר לְמִשְׂרָה קְבוּעָה.",
            exampleNative = "После года פְרִילַנְס я решил вернуться на постоянную позицию.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175323, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_alt_paths", transliteration = "hitmakhut ma'asit",
            original = "הִתְמַחוּת מַעֲשִׂית", translation = "практическая стажировка",
            definition = "תְּקוּפָה קְצָרָה בַּחֶבְרָה שֶׁבָּהּ מַתְחִיל לוֹמֵד אֶת הָעֲבוֹדָה לְצַד עוֹבְדִים מְנֻסִּים.",
            definitionNative = "Короткий период в фирме, где новичок учится делу рядом с опытными сотрудниками.",
            example = "הִתְמַחוּת מַעֲשִׂית בַּסְּטַרְטְאַפּ הֶעֱנִיקָה לִי נִסָּיוֹן אֲמִיתִּי.",
            exampleNative = "הִתְמַחוּת מַעֲשִׂית в стартапе дала мне настоящий боевой опыт.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175324, setId = 1753, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "job_search_alt_paths", transliteration = "shinuy karyera",
            original = "שִׁנּוּי קַרְיֶירָה", translation = "смена карьеры",
            definition = "מַעֲבָר מִתְּחוּם אֶחָד לִתְחוּם אַחֵר לְגַמְרֵי, לְעִתִּים אַחֲרֵי לִימּוּדִים נוֹסָפִים.",
            definitionNative = "Переход из одной сферы в совершенно другую — иногда после дополнительного обучения.",
            example = "שִׁנּוּי קַרְיֶירָה מֵהוֹרָאָה לְהַייטֵק לָקַח לִי שָׁלוֹשׁ שָׁנִים.",
            exampleNative = "שִׁנּוּי קַרְיֶירָה из преподавания в хайтек занял у меня три года.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175325, setId = 1753, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "job_search_alt_paths", transliteration = "hakhshara intensivit",
            original = "הַכְשָׁרָה אִינְטֶנְסִיבִית", translation = "интенсивная переподготовка",
            definition = "תָּכְנִית לִימּוּד צְפוּפָה שֶׁל כַּמָּה חֳדָשִׁים שֶׁמְּלַמֶּדֶת מִקְצוֹעַ חָדָשׁ מֵאֶפֶס.",
            definitionNative = "Плотная учебная программа на несколько месяцев — учит новой профессии с нуля.",
            example = "הַכְשָׁרָה אִינְטֶנְסִיבִית פָּתְחָה לִי דֶּלֶת לְהַייטֵק.",
            exampleNative = "הַכְשָׁרָה אִינְטֶנְסִיבִית открыла мне дверь в хайтек.",
            isFillInBlankSafe = false,
        ),
    )
}
