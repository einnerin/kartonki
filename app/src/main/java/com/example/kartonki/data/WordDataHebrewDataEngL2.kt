package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Data Engineering", L2 «Продвинутый базовый» (UNCOMMON+RARE).
 *
 * Set 1775: «Data Engineering» — продвинутый базовый L2:
 *           SQL-запросы (join, where, group by, order by),
 *           Excel (формула, сводная, макрос, лист, диапазон),
 *           BI-дашборды (виджет, slicer, drill-down, метрика),
 *           скрипты для аналитики (Python script, pandas, CSV, JSON, лог),
 *           источники данных (источник, API, БД, экспорт, интеграция).
 *
 * Целевая аудитория — русскоязычные репатрианты в Израиле, делающие первые
 * шаги в data-инженерии: аналитики, junior data engineer'ы, продакты,
 * которые начинают писать SQL и работать с дашбордами на иврите.
 * Лексика двуязычная: иврит + английские заимствования (שְׁאִילְתָּה, ג׳וֹיְן,
 * פַּייתוֹן, פַּנְדָּס, סִי-אֶס-וִי, ג׳וֹסוֹן, דַּשְׁבּוֹרְד) — так реально говорят
 * в смешанных командах в израильских хайтек-офисах.
 *
 * Распределение редкостей: 13 UNCOMMON + 12 RARE.
 *
 * SemanticGroups (5 × 5):
 *   data_sql_basic   — базовый SQL: запрос, join, фильтр-условие, группировка, сортировка
 *   data_excel       — Excel: формула, сводная, макрос, лист, диапазон
 *   data_bi          — BI: дашборд, виджет, slicer, drill-down, метрика
 *   data_scripts     — скрипты: Python-script, pandas, CSV, JSON, лог
 *   data_sources     — источники: источник данных, API, подключение к БД, экспорт, интеграция
 *
 * Word IDs: setId × 100 + position (177501..177525).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewDataEngL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1775, languagePair = "he-ru", orderIndex = 1775,
            name = "Data Engineering",
            description = "Продвинутый базовый: SQL, BI, Excel, скрипты, источники данных",
            topic = "Data Engineering", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1775 — Data Engineering: продвинутый базовый (L2, UNCOMMON+RARE)
        // 5 групп × 5 слов: sql_basic, excel, bi, scripts, sources
        // ══════════════════════════════════════════════════════════════════════

        // ── data_sql_basic (5) — базовые SQL-операции ──
        WordEntity(
            id = 177501, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_sql_basic", transliteration = "she'ilta",
            original = "שְׁאִילְתָּה", translation = "запрос (SQL query)",
            definition = "פְּקֻדָּה כְּתוּבָה בְּשָׂפַת SQL שֶׁשּׁוֹלֶפֶת אוֹ מְעַדְכֶּנֶת שׁוּרוֹת בְּטַבְלָה.",
            definitionNative = "Команда на языке SQL — достаёт или меняет строки в таблице.",
            example = "כָּתַבְתִּי שְׁאִילְתָּה שֶׁמַּחְזִירָה אֶת כָּל הַלְּקוֹחוֹת מֵרוּסְיָה.",
            exampleNative = "Я написал שְׁאִילְתָּה, которая возвращает всех клиентов из России.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177502, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_sql_basic", transliteration = "join",
            original = "ג׳וֹיְן", translation = "джойн (объединение таблиц)",
            definition = "פְּעֻלָּה שֶׁמְּחַבֶּרֶת שְׁתֵּי טַבְלָאוֹת לְפִי עַמּוּדָה מְשֻׁתֶּפֶת — לְקַבֵּל שׁוּרָה רְחָבָה אַחַת.",
            definitionNative = "Действие, объединяющее две таблицы по общей колонке — получается одна широкая строка.",
            example = "בְּלִי ג׳וֹיְן בֵּין הַזְמָנוֹת לִלְקוֹחוֹת, אִי אֶפְשָׁר לִרְאוֹת אֶת שְׁמוֹת הַקּוֹנִים.",
            exampleNative = "Без ג׳וֹיְן между заказами и клиентами не увидеть имена покупателей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177503, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_sql_basic", transliteration = "tnay sinun",
            original = "תְּנַאי סִינּוּן", translation = "условие фильтра (WHERE)",
            definition = "כְּלָל שֶׁמַּשְׁאִיר רַק שׁוּרוֹת שֶׁעוֹמְדוֹת בּוֹ — לְמָשָׁל סְכוּם גָּדוֹל מֵאֶלֶף.",
            definitionNative = "Правило, оставляющее только подходящие строки — например, сумма больше тысячи.",
            example = "הוֹסַפְתִּי תְּנַאי סִינּוּן עַל הַתַּאֲרִיךְ, וְהַדּוּחַ הִתְקַצֵּר פִּי עֲשָׂרָה.",
            exampleNative = "Я добавил תְּנַאי סִינּוּן по дате — и отчёт сократился в десять раз.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177504, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_sql_basic", transliteration = "kibutz",
            original = "קִבּוּץ", translation = "группировка (GROUP BY)",
            definition = "אִחוּד שׁוּרוֹת לְפִי עֵרֶךְ מְשֻׁתָּף בְּעַמּוּדָה — כְּדֵי לִסְכֹּם, לִסְפֹּר אוֹ לְמַצֵּעַ.",
            definitionNative = "Объединение строк по общему значению в колонке — чтобы суммировать, считать или усреднять.",
            example = "קִבּוּץ לְפִי מְדִינָה הֶרְאָה שֶׁשְּׁלִישׁ הַמְּכִירוֹת מַגִּיעַ מִגֶּרְמַנְיָה.",
            exampleNative = "קִבּוּץ по стране показал, что треть продаж идёт из Германии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177505, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_sql_basic", transliteration = "miyun",
            original = "מִיּוּן", translation = "сортировка (ORDER BY)",
            definition = "סִדּוּר תּוֹצָאוֹת לְפִי עַמּוּדָה — מֵהַקָּטָן לַגָּדוֹל, מֵהַחָדָשׁ לַיָּשָׁן וְכוּ׳.",
            definitionNative = "Упорядочивание результатов по колонке — от меньшего к большему, от свежего к старому и т.п.",
            example = "מִיּוּן לְפִי הַכְנָסָה יוֹרֶדֶת שָׂם אֶת הַלְּקוֹחוֹת הַגְּדוֹלִים בְּרֹאשׁ הָרְשִׁימָה.",
            exampleNative = "מִיּוּן по убыванию выручки ставит крупных клиентов в начало списка.",
            isFillInBlankSafe = false,
        ),

        // ── data_excel (5) — работа в Excel ──
        WordEntity(
            id = 177506, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_excel", transliteration = "formula",
            original = "פוֹרְמוּלָה", translation = "формула",
            definition = "בִּטּוּי שֶׁמְּחַשֵּׁב עֵרֶךְ בְּתָא עַל סְמַךְ תָּאִים אֲחֵרִים — מַתְחִיל בְּסִימָן שָׁוֶה.",
            definitionNative = "Выражение, считающее значение в ячейке через другие ячейки — начинается со знака равно.",
            example = "כָּתַבְתִּי פוֹרְמוּלָה שֶׁסּוֹכֶמֶת אֶת כָּל הַחֶשְׁבּוֹנִיּוֹת מֵהַחֹדֶשׁ הַקּוֹדֵם.",
            exampleNative = "Я написал פוֹרְמוּלָה, которая суммирует все счета за прошлый месяц.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177507, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_excel", transliteration = "tavlat tsir",
            original = "טַבְלַת צִיר", translation = "сводная таблица (pivot)",
            definition = "כְּלִי בְּאֶקְסֶל שֶׁמְּסַכֵּם נְתוּנִים לְפִי שׁוּרוֹת וְעַמּוּדוֹת לְפִי בְּחִירַת הַמִּשְׁתַּמֵּשׁ.",
            definitionNative = "Инструмент в Excel — сводит данные по строкам и столбцам по выбору пользователя.",
            example = "טַבְלַת צִיר חָשְׂפָה שֶׁשּׁלֹשָׁה מוּצָרִים אַחֲרָאִים עַל מֶחֱצִית הָרֶוַח.",
            exampleNative = "טַבְלַת צִיר показала, что три товара дают половину прибыли.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177508, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_excel", transliteration = "makro",
            original = "מָקְרוֹ", translation = "макрос",
            definition = "סֵדֶר פְּעֻלּוֹת מֻקְלָט שֶׁאֶקְסֶל מַפְעִיל מֵחָדָשׁ בְּלַחִיצַת כַּפְתּוֹר אַחַת — חוֹסֵךְ עֲבוֹדָה יָדָנִית.",
            definitionNative = "Записанная последовательность действий — Excel повторяет её по одному клику, экономя ручной труд.",
            example = "כָּתַבְתִּי מָקְרוֹ שֶׁמְּעַצֵּב אֶת הַדּוּחַ הַשְּׁבוּעִי בִּשְׁתֵּי שְׁנִיּוֹת.",
            exampleNative = "Я написал מָקְרוֹ, который оформляет недельный отчёт за две секунды.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177509, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_excel", transliteration = "gilayon",
            original = "גִּלָּיוֹן", translation = "лист",
            definition = "דַּף נִפְרָד בְּתוֹךְ קֹבֶץ אֶקְסֶל אֶחָד — אֶפְשָׁר לִפְתֹּחַ כַּמָּה דַּפִּים בְּלַשׁוֹנִיּוֹת לְמַטָּה.",
            definitionNative = "Отдельная страница внутри одного файла Excel — несколько листов открываются вкладками снизу.",
            example = "פִּצַּלְתִּי אֶת הַדּוּחַ לִשְׁלוֹשָׁה גִּלָּיוֹנוֹת — אֶחָד לְכָל רֶבַע שָׁנָה.",
            exampleNative = "Я разбил отчёт на три גִּלָּיוֹנוֹת — по одному на каждый квартал.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177510, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_excel", transliteration = "tvakh",
            original = "טְוָוח", translation = "диапазон ячеек",
            definition = "קְבוּצַת תָּאִים רְצוּפָה עַל הַגִּלָּיוֹן — לְמָשָׁל מִ-A1 עַד C20 — שֶׁפּוֹרְמוּלָה פּוֹעֶלֶת עָלֶיהָ.",
            definitionNative = "Сплошная группа ячеек на листе — например A1 до C20 — над которой работает формула.",
            example = "סִמַּנְתִּי טְוָוח שֶׁל מֵאָה שׁוּרוֹת וְצִבַּעְתִּי אוֹתוֹ צָהֹב.",
            exampleNative = "Я выделил טְוָוח из ста строк и закрасил его жёлтым.",
            isFillInBlankSafe = false,
        ),

        // ── data_bi (5) — BI-дашборды ──
        WordEntity(
            id = 177511, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_bi", transliteration = "lukhot bakara",
            original = "לוּחַ בַּקָּרָה", translation = "панель управления (BI)",
            definition = "מָסָךְ אֶחָד שֶׁמְּרַכֵּז גְּרָפִים וּמַסְפָּרִים עִקָּרִיִּים עַל הָעֵסֶק.",
            definitionNative = "Один экран — собирает главные графики и цифры о работе бизнеса.",
            example = "הַמְּנַהֵל פּוֹתֵחַ לוּחַ בַּקָּרָה שֶׁל הַמְּכִירוֹת כָּל בֹּקֶר.",
            exampleNative = "Руководитель открывает לוּחַ בַּקָּרָה продаж каждое утро.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177512, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_bi", transliteration = "vidzhet",
            original = "וִידְגֶ׳ט", translation = "виджет",
            definition = "אֵיבָר חָזוּתִי בּוֹדֵד עַל הַמָּסָךְ — גְּרָף, מַחוֹג אוֹ מִסְפָּר גָּדוֹל — שֶׁמַּצִּיג מֵידָע אֶחָד.",
            definitionNative = "Отдельный визуальный элемент на экране — график, шкала или большое число — показывает одну метрику.",
            example = "הוֹסַפְתִּי וִידְגֶ׳ט שֶׁל סַךְ הַהַזְמָנוֹת בַּפִּנָּה הָעֶלְיוֹנָה שְׂמָאלָה.",
            exampleNative = "Я добавил וִידְגֶ׳ט с общим числом заказов в левом верхнем углу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177513, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_bi", transliteration = "slayser",
            original = "סְלַייסֶר", translation = "slicer (фильтр-кнопка)",
            definition = "כַּפְתּוֹר אִינְטֶרְאַקְטִיבִי עַל דַּשְׁבּוֹרְד שֶׁמְּצַמְצֵם בְּלַחִיצָה אֶת כָּל הַגְּרָפִים לְעֵרֶךְ אֶחָד.",
            definitionNative = "Интерактивная кнопка на дашборде — нажатие сужает все графики до одного значения.",
            example = "סְלַייסֶר שֶׁל אֵזוֹר מַתְמַקֵּד אוֹתִי בְּמֶרְכָּז הָאָרֶץ בְּלַחִיצָה אַחַת.",
            exampleNative = "סְלַייסֶר по региону одним кликом фокусирует меня на центре страны.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177514, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_bi", transliteration = "dril-daun",
            original = "דְּרִיל-דָּאוּן", translation = "drill-down (углубление)",
            definition = "מַעֲבָר בִּלְחִיצָה מִסַּךְ-הַכֹּל גָּבוֹהַ אֶל הַפֵּרוּט הַפְּנִימִי שֶׁעוֹמֵד מֵאָחוֹר.",
            definitionNative = "Клик-переход с верхнего итога вглубь — к подробностям, лежащим под ним.",
            example = "דְּרִיל-דָּאוּן עַל הָרֶבַע הָרִאשׁוֹן הוֹרִיד אוֹתִי לְרָמַת הַחֳדָשִׁים הַבּוֹדְדִים.",
            exampleNative = "דְּרִיל-דָּאוּן по первому кварталу опустил меня до уровня отдельных месяцев.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177515, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_bi", transliteration = "metrika",
            original = "מֶטְרִיקָה", translation = "метрика (показатель)",
            definition = "מִסְפָּר אֶחָד שֶׁמּוֹדֵד הֵבֵט מָסוּיָּם בָּעֵסֶק — הַכְנָסָה, אָחוּז עֲזִיבָה אוֹ זְמַן תְּגוּבָה.",
            definitionNative = "Одно число, измеряющее аспект бизнеса — выручка, процент оттока или время отклика.",
            example = "הַמֶּטְרִיקָה הַחֲשׁוּבָה לָנוּ הַשָּׁנָה הִיא אָחוּז הַחֲזָרָה שֶׁל לְקוֹחוֹת.",
            exampleNative = "Главная מֶטְרִיקָה для нас в этом году — процент возврата клиентов.",
            isFillInBlankSafe = false,
        ),

        // ── data_scripts (5) — скрипты для аналитики ──
        WordEntity(
            id = 177516, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_scripts", transliteration = "skript paython",
            original = "סְקְרִיפְּט פַּייתוֹן", translation = "Python-скрипт",
            definition = "קֹבֶץ קוֹד קָצָר בְּשָׂפַת פַּייתוֹן שֶׁמְּבַצֵּעַ מְשִׂימָה אַחַת — לְמָשָׁל מַעֲבִיר מֵידָע מִקֹּבֶץ אֶחָד לַשֵּׁנִי.",
            definitionNative = "Короткий файл кода на Python — выполняет одну задачу, например, переносит данные из одного файла в другой.",
            example = "סְקְרִיפְּט פַּייתוֹן רָץ כָּל בֹּקֶר וּמַכִּין אֶת הַדּוּחַ הַיּוֹמִי.",
            exampleNative = "סְקְרִיפְּט פַּייתוֹן запускается каждое утро и готовит ежедневный отчёт.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177517, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_scripts", transliteration = "pandas",
            original = "פַּנְדָּס", translation = "pandas (библиотека)",
            definition = "סִפְרִיָּה פּוֹפּוּלָרִית בְּפַּייתוֹן לַעֲבוֹדָה עִם טַבְלָאוֹת — קוֹרֵאת, מְסַנֶּנֶת וּמְנַתַּחַת בְּקַלּוּת.",
            definitionNative = "Популярная библиотека Python для работы с таблицами — читает, фильтрует и анализирует легко.",
            example = "בְּפַּנְדָּס שׁוּרָה אַחַת מַחֲלִיפָה עֶשְׂרִים שׁוּרוֹת קוֹד רָגִיל.",
            exampleNative = "В פַּנְדָּס одна строка заменяет двадцать строк обычного кода.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177518, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_scripts", transliteration = "si-es-vi",
            original = "סִי-אֶס-וִי", translation = "CSV (формат)",
            definition = "פוֹרְמָט קֹבֶץ פָּשׁוּט שֶׁבּוֹ כָּל שׁוּרָה הִיא רְשׁוּמָה וְהָעַמּוּדוֹת מֻפְרָדוֹת בְּפְסִיקִים.",
            definitionNative = "Простой формат файла — каждая строка это запись, а колонки разделены запятыми.",
            example = "הַלָּקוֹחַ שָׁלַח לִי קֹבֶץ סִי-אֶס-וִי עִם חֲמֵשׁ-עֶשְׂרֵה אֶלֶף שׁוּרוֹת.",
            exampleNative = "Клиент прислал мне файл סִי-אֶס-וִי с пятнадцатью тысячами строк.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177519, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_scripts", transliteration = "json",
            original = "ג׳וֹסוֹן", translation = "JSON (формат)",
            definition = "פוֹרְמָט מֻבְנֶה לְמֵידָע מְקֻנַּן שֶׁמַּעֲבִירִים בֵּין שֵׁרוּתִים — שָׂדוֹת, רְשִׁימוֹת וְאוֹבְּיֶיקְטִים מְקֻנָּנִים.",
            definitionNative = "Структурированный формат для вложенных данных — поля, списки и вложенные объекты.",
            example = "כָּל תְּגוּבָה מֵהָ-API חוֹזֶרֶת כְּג׳וֹסוֹן עִם חֲמִשָּׁה שָׂדוֹת רָאשִׁיִּים.",
            exampleNative = "Каждый ответ от API возвращается как ג׳וֹסוֹן с пятью главными полями.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177520, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_scripts", transliteration = "log",
            original = "לוֹג", translation = "лог-файл (журнал)",
            definition = "תֵּעוּד אוֹטוֹמָטִי שֶׁל כָּל מָה שֶׁקּוֹרֶה לַתָּכְנִית — שְׁגִיאוֹת, אַזְהָרוֹת וְאֵירוּעִים רְגִילִים.",
            definitionNative = "Автоматическая запись всего, что происходит с программой — ошибки, предупреждения и обычные события.",
            example = "כְּשֶׁהַסְּקְרִיפְּט נָפַל, פָּתַחְתִּי אֶת הַלּוֹג וּמָצָאתִי שׁוּרַת הַשְּׁגִיאָה תּוֹךְ דַּקָּה.",
            exampleNative = "Когда скрипт упал, я открыл לוֹג и нашёл строку ошибки за минуту.",
            isFillInBlankSafe = false,
        ),

        // ── data_sources (5) — источники данных ──
        WordEntity(
            id = 177521, setId = 1775, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "data_sources", transliteration = "mkor netunim",
            original = "מְקוֹר נְתוּנִים", translation = "источник данных",
            definition = "מַעֲרֶכֶת חִיצוֹנִית שֶׁמִּמֶּנָּה הַדּוּחַ אוֹ הַדַּשְׁבּוֹרְד שׁוֹאֵב מֵידָע — אַפְּלִיקַצְיָה, גִּלָּיוֹן אוֹ שֵׁרוּת.",
            definitionNative = "Внешняя система, из которой отчёт или дашборд берёт информацию — приложение, лист или сервис.",
            example = "חִבַּרְנוּ שְׁלוֹשָׁה מְקוֹרוֹת נְתוּנִים לַדּוּחַ הֶחָדָשׁ.",
            exampleNative = "Мы подключили три מְקוֹרוֹת נְתוּנִים к новому отчёту.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177522, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_sources", transliteration = "kriat API",
            original = "קְרִיאַת API", translation = "вызов API",
            definition = "פְּנִיָּה תֻּכְנָתִית לְשֵׁרוּת חִיצוֹנִי שֶׁמַּחֲזִיר מֵידָע מְעֻדְכָּן — לְפִי כְּתֹבֶת וְהַרְשָׁאָה.",
            definitionNative = "Программное обращение к внешнему сервису — возвращает свежие данные по адресу и с авторизацией.",
            example = "כָּל קְרִיאַת API לַשֵּׁרוּת שֶׁל מֶזֶג הָאֲוִיר עוֹלָה לָנוּ אֲגוֹרָה אַחַת.",
            exampleNative = "Каждый קְרִיאַת API к погодному сервису стоит нам одну агору.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177523, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_sources", transliteration = "khibur lemasad",
            original = "חִבּוּר לְמַסָּד", translation = "подключение к БД",
            definition = "עֲרוּץ פָּתוּחַ בֵּין הַסְּקְרִיפְּט לַמַּסָּד — דֶּרֶךְ כְּתֹבֶת, מִשְׁתַּמֵּשׁ וְסִיסְמָה — שֶׁדַּרְכּוֹ עוֹבְרוֹת שְׁאֵלוֹת.",
            definitionNative = "Открытый канал между скриптом и базой — через адрес, логин и пароль — по нему ходят запросы.",
            example = "הַחִבּוּר לְמַסָּד נָפַל בְּאֶמְצַע הַלַּיְלָה וְכָל הָעֲבוֹדָה נֶעֶצְרָה.",
            exampleNative = "חִבּוּר לְמַסָּד упал посреди ночи — и вся работа встала.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177524, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_sources", transliteration = "eksport",
            original = "אֶקְסְפּוֹרְט", translation = "экспорт",
            definition = "הוֹצָאַת תּוֹצָאוֹת מִתּוֹךְ הַמַּעֲרֶכֶת לְפוֹרְמָט חִיצוֹנִי — לְשִׁתּוּף עִם אֲחֵרִים.",
            definitionNative = "Вынос результатов из системы во внешний формат — для передачи другим.",
            example = "אֶקְסְפּוֹרְט שֶׁל הַלְּקוֹחוֹת הַפְּעִילִים לוֹקֵחַ פָּחוֹת מֵחֲצִי דַּקָּה.",
            exampleNative = "אֶקְסְפּוֹרְט активных клиентов занимает меньше полминуты.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177525, setId = 1775, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "data_sources", transliteration = "integratsya",
            original = "אִינְטֶגְרַצְיָה", translation = "интеграция",
            definition = "חִבּוּר מָתְמִיד בֵּין שְׁתֵּי מַעֲרָכוֹת שֶׁמַּחֲלִיפוֹת מֵידָע אוֹטוֹמָטִית — בְּלִי הַעֲבָרָה יָדָנִית.",
            definitionNative = "Постоянная связка двух систем, обменивающихся данными автоматически — без ручной передачи.",
            example = "הָאִינְטֶגְרַצְיָה עִם זַאפְּיֶר חוֹסֶכֶת לָנוּ שָׁלוֹשׁ שָׁעוֹת עֲבוֹדָה כָּל יוֹם.",
            exampleNative = "אִינְטֶגְרַצְיָה с Zapier экономит нам три часа работы каждый день.",
            isFillInBlankSafe = false,
        ),
    )
}
