package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Data Engineering", L1 «Основы» (COMMON+UNCOMMON).
 *
 * Set 1774: «Data Engineering» — основы L1 (A1-A2):
 *           базовая лексика данных, таблиц, файлов, отчётов — то, с чем
 *           сталкивается каждый аналитик в первый день работы в офисе.
 *
 * Тема ориентирована на русскоязычных репатриантов в Израиле, делающих первые
 * шаги в работе с данными — Excel, Google Sheets, простые отчёты, выгрузки.
 * Лексика — обычный офисный иврит без хардкорной инженерии (Spark/Kafka в L3/L4),
 * с лёгкими английскими заимствованиями (טֶקְסְט, פוֹרְמָט, פִילְטֶר, גְּרָף).
 *
 * Распределение редкостей: 13 COMMON + 12 UNCOMMON.
 *
 * SemanticGroups (5 × 5):
 *   data_basics    — основа: данные, число, текст, дата, имя
 *   data_storage   — где лежит: файл, папка, документ, формат, размер
 *   data_table     — структура таблицы: таблица, строка, столбец, ячейка, заголовок
 *   data_actions   — что делают с данными: открыть, сохранить, экспорт, импорт, фильтровать
 *   data_reports   — что показывают: отчёт, диаграмма, график, итог, выгрузка
 *
 * Word IDs: setId × 100 + position (177401..177425).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewDataEngL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1774, languagePair = "he-ru", orderIndex = 1774,
            name = "Data Engineering",
            description = "Базовая лексика дата-инженерии: данные, таблицы, файлы, отчёты",
            topic = "Data Engineering", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1774 — Data Engineering: основы (L1, COMMON+UNCOMMON, A1-A2)
        // 5 групп × 5 слов: basics, storage, table, actions, reports
        // ══════════════════════════════════════════════════════════════════════

        // ── data_basics (5) — базовые понятия о данных ──
        WordEntity(
            id = 177401, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_basics", transliteration = "netunim",
            original = "נְתוּנִים", translation = "данные",
            definition = "מֵידָע מְסֻדָּר שֶׁשּׁוֹמְרִים בַּמַּחְשֵׁב — מִסְפָּרִים, שֵׁמוֹת אוֹ תַּאֲרִיכִים.",
            definitionNative = "Упорядоченная информация в компьютере — числа, имена или даты.",
            example = "כָּל הַנְּתוּנִים שֶׁל הַלָּקוֹחוֹת יוֹשְׁבִים בַּמַּחְשֵׁב הָרָאשִׁי.",
            exampleNative = "Все נְתוּנִים клиентов лежат на главном компьютере.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177402, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_basics", transliteration = "mispar",
            original = "מִסְפָּר", translation = "число",
            definition = "סִימָן שֶׁמְּסַפֵּר כַּמָּה יֵשׁ — אֶחָד, שְׁתַּיִם, מֵאָה אוֹ אֶלֶף.",
            definitionNative = "Знак, что говорит о количестве — один, два, сто или тысяча.",
            example = "כָּל מִסְפָּר בָּעַמּוּדָה הַזּוֹ אָמוּר לִהְיוֹת חִיוּבִי.",
            exampleNative = "Каждый מִסְפָּר в этой колонке должен быть положительным.",
         fillInBlankExclusions = listOf(177401L, 177403L, 177404L, 177405L)),
        WordEntity(
            id = 177403, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_basics", transliteration = "tekst",
            original = "טֶקְסְט", translation = "текст",
            definition = "אוֹתִיּוֹת וּמִילִים שֶׁמַּרְכִּיבוֹת מִשְׁפָּט — לְעֻמַּת מִסְפָּר אוֹ תַּאֲרִיךְ.",
            definitionNative = "Буквы и слова, складывающиеся в фразу — в отличие от числа или даты.",
            example = "הוֹסַפְתִּי עַמּוּדַת טֶקְסְט קְצָרָה לְהֶעָרוֹת מֵהַלָּקוֹחַ.",
            exampleNative = "Я добавил короткую колонку טֶקְסְט для заметок от клиента.",
         fillInBlankExclusions = listOf(177401L, 177402L, 177404L, 177405L)),
        WordEntity(
            id = 177404, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_basics", transliteration = "ta'arikh",
            original = "תַּאֲרִיךְ", translation = "дата",
            definition = "יוֹם בַּלּוּחַ שָׁנָה — לְמָשָׁל שְׁלוֹשִׁים בְּמַארְס אַלְפַּיִם עֶשְׂרִים וְשָׁלֹשׁ.",
            definitionNative = "День в календаре — например, тридцатое марта две тысячи двадцать третьего.",
            example = "כָּל שׁוּרָה כּוֹלֶלֶת תַּאֲרִיךְ שֶׁל הָעִסְקָה בְּפוֹרְמָט אָמֵרִיקָאִי.",
            exampleNative = "Каждая строка содержит תַּאֲרִיךְ сделки в американском формате.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177405, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_basics", transliteration = "shem",
            original = "שֵׁם", translation = "имя",
            definition = "מִילָה שֶׁמְּזַהָה אָדָם, חֶבְרָה אוֹ מָקוֹם — כְּמוֹ דָּן, גוּגֶל אוֹ חֵיפָה.",
            definitionNative = "Слово, опознающее человека, фирму или место — как Дан, Гугл или Хайфа.",
            example = "כָּל שֵׁם בַּטַּבְלָה כָּתוּב בְּאוֹתִיּוֹת גְּדוֹלוֹת בָּאַנְגְּלִית.",
            exampleNative = "Каждое שֵׁם в таблице написано большими буквами по-английски.",
         fillInBlankExclusions = listOf(177401L, 177402L, 177403L, 177404L)),

        // ── data_storage (5) — где данные лежат ──
        WordEntity(
            id = 177406, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_storage", transliteration = "kovets",
            original = "קֹבֶץ", translation = "файл",
            definition = "יְחִידָה שֶׁל מֵידָע בַּמַּחְשֵׁב עִם שֵׁם — לְמָשָׁל מִסְמָךְ, תְּמוּנָה אוֹ סֶרְטוֹן.",
            definitionNative = "Единица информации в компьютере с именем — например, документ, картинка или ролик.",
            example = "שָׁלַחְתִּי לְךָ קֹבֶץ עִם כָּל הַמְּכִירוֹת שֶׁל הַחֹדֶשׁ הַשֶּׁעָבַר.",
            exampleNative = "Я отправил тебе קֹבֶץ со всеми продажами за прошлый месяц.",
         fillInBlankExclusions = listOf(177407L, 177408L, 177409L, 177410L)),
        WordEntity(
            id = 177407, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_storage", transliteration = "tikiya",
            original = "תִּיקִיָּה", translation = "папка",
            definition = "מְקוֹם בַּמַּחְשֵׁב שֶׁאוֹסֵף כַּמָּה קְבָצִים יַחַד — כְּמוֹ מַגֵּרָה בְּשֻׁלְחָן.",
            definitionNative = "Место в компьютере, что собирает несколько файлов вместе — как ящик в столе.",
            example = "פָּתַחְתִּי תִּיקִיָּה חֲדָשָׁה לְכָל הַדּוּחוֹת שֶׁל הָרֶבַע הַזֶּה.",
            exampleNative = "Я открыл свежую תִּיקִיָּה для всех отчётов этого квартала.",
         fillInBlankExclusions = listOf(177406L, 177408L, 177409L, 177410L)),
        WordEntity(
            id = 177408, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_storage", transliteration = "mismakh",
            original = "מִסְמָךְ", translation = "документ",
            definition = "קֹבֶץ עִם טֶקְסְט מְסֻדָּר — חוֹזֶה, מִכְתָּב רִשְׁמִי אוֹ דַּף הוֹרָאוֹת לָעוֹבְדִים.",
            definitionNative = "Файл с упорядоченным текстом — договор, официальное письмо или памятка для сотрудников.",
            example = "צֵרַפְתִּי מִסְמָךְ עִם הַסְבֵּר עַל הַשְּׁדוֹת הַחֲדָשִׁים בַּטַּבְלָה.",
            exampleNative = "Я приложил מִסְמָךְ с пояснением о новых полях в таблице.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177409, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_storage", transliteration = "format",
            original = "פוֹרְמָט", translation = "формат",
            definition = "סוּג שֶׁל קֹבֶץ — לְמָשָׁל אֶקְסֶל, פִּי-דִּי-אֵף אוֹ סִי-אֵס-וִי לְטַבְלָאוֹת.",
            definitionNative = "Тип файла — например Excel, PDF или CSV для таблиц.",
            example = "הַלָּקוֹחַ בִּקֵּשׁ אֶת הַדּוּחַ בְּפוֹרְמָט אֶקְסֶל וְלֹא בְּפִי-דִּי-אֵף.",
            exampleNative = "Клиент попросил отчёт в פוֹרְמָט Excel, а не в PDF.",
         fillInBlankExclusions = listOf(177406L, 177407L, 177408L, 177410L)),
        WordEntity(
            id = 177410, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_storage", transliteration = "godel",
            original = "גֹּדֶל", translation = "размер (файла)",
            definition = "כַּמָּה מָקוֹם הַקֹּבֶץ תּוֹפֵס בַּמַּחְשֵׁב — נִמְדַּד בְּמֶגָה אוֹ ג׳יגָה.",
            definitionNative = "Сколько места занимает файл в компьютере — измеряется в мегах или гигах.",
            example = "גֹּדֶל הַקֹּבֶץ הָיָה גָּדוֹל מִדַּי לִשְׁלִיחָה בָּדּוֹאַר.",
            exampleNative = "גֹּדֶל файла оказался слишком велик для отправки по почте.",
         fillInBlankExclusions = listOf(177406L, 177407L, 177408L, 177409L)),

        // ── data_table (5) — структура таблицы ──
        WordEntity(
            id = 177411, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_table", transliteration = "tavla",
            original = "טַבְלָה", translation = "таблица",
            definition = "רֶשֶׁת שֶׁל שׁוּרוֹת וְעַמּוּדוֹת שֶׁמְּסַדֶּרֶת מֵידָע לְפִי קָטֵגוֹרְיוֹת.",
            definitionNative = "Сетка строк и столбцов — упорядочивает информацию по категориям.",
            example = "בָּנִיתִי טַבְלָה שֶׁל מִשְׁתַּמְּשִׁים עִם חָמֵשׁ עַמּוּדוֹת בִּלְבַד.",
            exampleNative = "Я построил טַבְלָה пользователей всего из пяти колонок.",
         fillInBlankExclusions = listOf(177412L, 177413L, 177414L, 177415L)),
        WordEntity(
            id = 177412, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_table", transliteration = "shura",
            original = "שׁוּרָה", translation = "строка",
            definition = "קַו אוֹפְקִי בַּטַּבְלָה — שֶׁמְּסַפֵּר עַל לָקוֹחַ אֶחָד אוֹ עַל עִסְקָה אַחַת.",
            definitionNative = "Горизонтальная линия в таблице — рассказывает об одном клиенте или одной сделке.",
            example = "כָּל שׁוּרָה בַּטַּבְלָה הַזּוֹ הִיא הַזְמָנָה אַחַת מֵהָאָתָר.",
            exampleNative = "Каждая שׁוּרָה в этой таблице — один заказ с сайта.",
         fillInBlankExclusions = listOf(177411L, 177413L, 177414L, 177415L)),
        WordEntity(
            id = 177413, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_table", transliteration = "amuda",
            original = "עַמּוּדָה", translation = "столбец",
            definition = "קַו אֲנָכִי בַּטַּבְלָה — שֶׁמַּחֲזִיק תְּכוּנָה אַחַת לְכָל שׁוּרָה, כְּמוֹ גִּיל אוֹ עִיר.",
            definitionNative = "Вертикальная линия в таблице — держит одну характеристику для каждой строки, как возраст или город.",
            example = "מָחַקְתִּי עַמּוּדָה שֶׁל מִסְפַּר טֶלֶפוֹן כִּי לֹא הָיִינוּ צְרִיכִים אוֹתָהּ.",
            exampleNative = "Я удалил עַמּוּדָה номера телефона — она нам не нужна.",
         fillInBlankExclusions = listOf(177411L, 177412L, 177414L, 177415L)),
        WordEntity(
            id = 177414, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_table", transliteration = "ta",
            original = "תָּא", translation = "ячейка",
            definition = "רִבּוּעַ קָטָן בַּטַּבְלָה — הַמִּפְגָּשׁ שֶׁל שׁוּרָה אַחַת עִם עַמּוּדָה אַחַת.",
            definitionNative = "Маленький квадратик в таблице — место встречи одной строки с одним столбцом.",
            example = "כָּתַבְתִּי נֻסְחָה בַּתָּא הַזֶּה כְּדֵי לְחַשֵּׁב אֶת הַסְּכוּם.",
            exampleNative = "Я написал формулу в этом תָּא, чтобы посчитать сумму.",
         fillInBlankExclusions = listOf(177411L, 177412L, 177413L, 177415L)),
        WordEntity(
            id = 177415, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_table", transliteration = "koteret",
            original = "כּוֹתֶרֶת", translation = "заголовок (столбца)",
            definition = "הַשּׁוּרָה הָעֶלְיוֹנָה שֶׁל הַטַּבְלָה — שֶׁמַּגִּידָה מָה כָּל עַמּוּדָה מְכִילָה.",
            definitionNative = "Самая верхняя строка таблицы — говорит, что в каждом столбце.",
            example = "שִׁנִּיתִי אֶת הַכּוֹתֶרֶת מֵ-״תַּאֲרִיךְ״ לְ-״תַּאֲרִיךְ הַזְמָנָה״.",
            exampleNative = "Я сменил כּוֹתֶרֶת с «дата» на «дата заказа».",
         fillInBlankExclusions = listOf(177411L, 177412L, 177413L, 177414L)),

        // ── data_actions (5) — что делают с данными ──
        WordEntity(
            id = 177416, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "data_actions", transliteration = "liftoakh",
            original = "לִפְתֹּחַ", translation = "открыть (файл)",
            definition = "לִלְחֹץ עַל קֹבֶץ כְּדֵי לִרְאוֹת אֶת הַתֹּכֶן שֶׁבּוֹ עַל הַמָּסָךְ.",
            definitionNative = "Кликнуть по файлу — чтобы увидеть его содержимое на экране.",
            example = "אֲנִי לֹא מַצְלִיחַ לִפְתֹּחַ אֶת הַקֹּבֶץ הַזֶּה — אוּלַי הוּא שָׁבוּר.",
            exampleNative = "У меня не получается לִפְתֹּחַ этот файл — может, он сломан.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177417, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "data_actions", transliteration = "lishmor",
            original = "לִשְׁמֹר", translation = "сохранить",
            definition = "לְהַשְׁאִיר אֶת הָעֲבוֹדָה בַּמַּחְשֵׁב כְּדֵי שֶׁלֹּא תֹּאבַד אַחֲרֵי כִּבּוּי.",
            definitionNative = "Оставить работу в компьютере — чтобы она не пропала после выключения.",
            example = "אַל תִּשְׁכַּח לִשְׁמֹר אֶת הַטַּבְלָה לִפְנֵי שֶׁאַתָּה סוֹגֵר אֶת הַמָּסָךְ.",
            exampleNative = "Не забудь לִשְׁמֹר таблицу перед закрытием экрана.",
         fillInBlankExclusions = listOf(177416L, 177418L, 177419L, 177420L)),
        WordEntity(
            id = 177418, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "data_actions", transliteration = "leyatse",
            original = "לְיַצֵּא", translation = "экспортировать",
            definition = "לְהוֹצִיא אֶת הַטַּבְלָה הַחוּצָה לְפוֹרְמָט אַחֵר — לְמָשָׁל אֶקְסֶל אוֹ סִי-אֵס-וִי.",
            definitionNative = "Вывести таблицу наружу в другой формат — например Excel или CSV.",
            example = "צָרִיךְ לְיַצֵּא אֶת הָרְשִׁימָה כְּדֵי לִשְׁלֹחַ לַלָּקוֹחַ.",
            exampleNative = "Нужно לְיַצֵּא список — чтобы отправить клиенту.",
         fillInBlankExclusions = listOf(177416L, 177417L, 177419L, 177420L)),
        WordEntity(
            id = 177419, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "data_actions", transliteration = "leyabe",
            original = "לְיַבֵּא", translation = "импортировать",
            definition = "לִמְשֹׁךְ נְתוּנִים מִקֹּבֶץ חִיצוֹנִי פְּנִימָה לַמַּעֲרֶכֶת הַנּוֹכְחִית.",
            definitionNative = "Втянуть данные из внешнего файла внутрь текущей системы.",
            example = "אֶפְשָׁר לְיַבֵּא אֶת רְשִׁימַת אַנְשֵׁי הַקֶּשֶׁר יְשִׁירוֹת מִ-ג׳יִימֵייל.",
            exampleNative = "Можно לְיַבֵּא список контактов прямо из Gmail.",
         fillInBlankExclusions = listOf(177416L, 177417L, 177418L, 177420L)),
        WordEntity(
            id = 177420, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "data_actions", transliteration = "lesanen",
            original = "לְסַנֵּן", translation = "фильтровать",
            definition = "לְהַשְׁאִיר רַק אֶת הַשּׁוּרוֹת שֶׁעוֹמְדוֹת בִּתְנַאי — וּלְהַסְתִּיר אֶת הַשְּׁאָר זְמַנִּית.",
            definitionNative = "Оставить только строки, что подходят под условие — а остальные временно спрятать.",
            example = "אֶפְשָׁר לְסַנֵּן אֶת הַטַּבְלָה לְפִי הָעִיר וּלְקַבֵּל רַק אֶת תֵּל-אָבִיב.",
            exampleNative = "Можно לְסַנֵּן таблицу по городу — и получить только Тель-Авив.",
         fillInBlankExclusions = listOf(177416L, 177417L, 177418L, 177419L)),

        // ── data_reports (5) — что показывают начальству ──
        WordEntity(
            id = 177421, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_reports", transliteration = "duakh",
            original = "דּוּחַ", translation = "отчёт",
            definition = "מִסְמָךְ שֶׁמַּרְאֶה לַמַּנְהֵל מָה קָרָה בָּעֵסֶק בְּתֹם שָׁבוּעַ אוֹ חֹדֶשׁ.",
            definitionNative = "Документ, показывающий руководителю, что произошло в бизнесе за неделю или месяц.",
            example = "אֲנִי שׁוֹלֵחַ דּוּחַ לַמַּנְהֵל בְּכָל יוֹם רִאשׁוֹן בַּבֹּקֶר.",
            exampleNative = "Я отправляю דּוּחַ руководителю каждое воскресенье утром.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177422, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_reports", transliteration = "diagrama",
            original = "דִּיאַגְרָמָה", translation = "диаграмма",
            definition = "צִיּוּר עִם עִגּוּל אוֹ עַמּוּדוֹת — מַרְאֶה אֵיךְ הַסַּךְ מִתְחַלֵּק בֵּין חֲלָקִים.",
            definitionNative = "Рисунок с кругом или столбиками — показывает, как сумма делится между частями.",
            example = "הוֹסַפְתִּי דִּיאַגְרָמָה צִבְעוֹנִית לְהַצָּגַת חֲלוּקַת הַמְּכִירוֹת.",
            exampleNative = "Я добавил цветную דִּיאַגְרָמָה — для показа разбивки продаж.",
         fillInBlankExclusions = listOf(177421L, 177423L, 177424L, 177425L)),
        WordEntity(
            id = 177423, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_reports", transliteration = "graf",
            original = "גְּרָף", translation = "график",
            definition = "צִיּוּר עִם קַו עוֹלֶה אוֹ יוֹרֵד — מַרְאֶה אֵיךְ מִסְפָּר מִשְׁתַּנֶּה לְאֹרֶךְ זְמַן.",
            definitionNative = "Рисунок с поднимающейся или падающей линией — показывает, как число меняется во времени.",
            example = "הַגְּרָף מַרְאֶה עֲלִיָּה חַדָּה בַּהַזְמָנוֹת מֵרֹאשׁ הַשָּׁנָה.",
            exampleNative = "גְּרָף показывает резкий рост заказов с начала года.",
         fillInBlankExclusions = listOf(177421L, 177422L, 177424L, 177425L)),
        WordEntity(
            id = 177424, setId = 1774, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "data_reports", transliteration = "sikum",
            original = "סִכּוּם", translation = "итог",
            definition = "מִסְפָּר אֶחָד שֶׁמְּחַבֵּר אֶת כָּל הַשּׁוּרוֹת — לְמָשָׁל סַךְ הַמְּכִירוֹת לַחֹדֶשׁ.",
            definitionNative = "Одно число, складывающее все строки — например, сумма продаж за месяц.",
            example = "הַסִּכּוּם בַּשּׁוּרָה הַתַּחְתּוֹנָה לֹא תוֹאֵם אֶת הַחֶשְׁבּוֹנִית.",
            exampleNative = "סִכּוּם в нижней строке не сходится со счётом-фактурой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177425, setId = 1774, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_reports", transliteration = "damp",
            original = "דַּאמְפּ", translation = "выгрузка (dump)",
            definition = "קֹבֶץ גָּדוֹל שֶׁמַּכִיל הַעְתָּקָה שְׁלֵמָה שֶׁל הַטַּבְלָה — בְּדֶרֶךְ כְּלָל לְגִבּוּי אוֹ לִבְדִיקָה.",
            definitionNative = "Большой файл — полная копия таблицы, обычно для бэкапа или проверки.",
            example = "הַ-דַּאמְפּ הַיּוֹמִי שֶׁל הַמַּסַּד שָׁמוּר בָּעָנָן לְשִׁבְעָה יָמִים אֲחוֹרָה.",
            exampleNative = "Ежедневный דַּאמְפּ базы хранится в облаке семь дней назад.",
            isFillInBlankSafe = false,
        ),
    )
}
