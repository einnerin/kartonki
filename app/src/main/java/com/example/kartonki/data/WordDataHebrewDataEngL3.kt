package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Data Engineering", L3 «Углублённый» (RARE+EPIC).
 *
 * Set 1763: «Data Engineering» — углублённый L3:
 *           Хранилища (warehouse, lake, S3, Parquet, columnar),
 *           ETL/ELT (batch, streaming, pipeline),
 *           обработка (Spark, Hadoop, MapReduce, partitioning, shuffle),
 *           оркестрация (Airflow, DAG, scheduler, dependency, backfill),
 *           качество (data quality, schema enforcement, dedup, late arrival, watermark).
 *
 * Тема ориентирована на data-инженера, изучающего иврит для работы в израильском
 * хайтеке (Mobileye, Lightricks, Lemonade, Wix). Лексика — реальная речь в офисах,
 * где английские заимствования звучат как ивритские слова: דָּאטָה לֵייק,
 * סְפַּארְק, אֵיירְפְלוֹאוּ, פַּרְקֵט, אֵי-טִי-אֵל. Так и говорят в data-командах.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC (L3 = специальная инженерная
 * лексика хранения и обработки данных).
 *
 * SemanticGroups (5 × 5):
 *   de_storage        — хранение: warehouse, lake, S3, Parquet, columnar
 *   de_etl            — конвейеры: ETL, ELT, batch, streaming, pipeline
 *   de_processing     — обработка: Spark, Hadoop, MapReduce, partition, shuffle
 *   de_orchestration  — оркестрация: Airflow, DAG, scheduler, task dependency, backfill
 *   de_quality        — качество: data quality, schema enforcement, dedup, late arrival, watermark
 *
 * Word IDs: setId × 100 + position (176301..176325).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewDataEngL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1763, languagePair = "he-ru", orderIndex = 1763,
            name = "Data Engineering",
            description = "Основы дата-инженерии: хранение, ETL, обработка, оркестрация",
            topic = "Data Engineering", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1763 — Data Engineering: углублённый (L3, RARE+EPIC)
        // 5 групп × 5 слов: storage, etl, processing, orchestration, quality
        // ══════════════════════════════════════════════════════════════════════

        // ── de_storage (5) — хранилища данных ──
        WordEntity(
            id = 176301, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_storage", transliteration = "data verhaus",
            original = "דָּאטָה וֵייְארְהָאוּס", translation = "хранилище данных",
            definition = "מָסַד מֶרְכָּזִי גָּדוֹל שֶׁאוֹסֵף נְתוּנִים מִמְּקוֹרוֹת רַבִּים — בְּשָׁבִיל דּוּחוֹת וְאָנָלִיטִיקָה.",
            definitionNative = "Большая центральная база — собирает данные из многих источников для отчётов и аналитики.",
            example = "הָעֲבָרָה לְדָּאטָה וֵייְארְהָאוּס חָדָשׁ הוֹרִידָה אֶת זְמַן הַדּוּחוֹת.",
            exampleNative = "Переход на новый דָּאטָה וֵייְארְהָאוּס сократил время отчётов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176302, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_storage", transliteration = "data leyk",
            original = "דָּאטָה לֵייק", translation = "озеро данных",
            definition = "אַחְסוּן זוֹל לְקַבְצֵי גַּלְמִי שׁוֹנִים — לוֹגִים, תְּמוּנוֹת, JSON — בְּלִי סְכֵמָה קְבוּעָה.",
            definitionNative = "Дешёвое хранилище разных сырых файлов — логов, картинок, JSON — без жёсткой схемы.",
            example = "כָּל הַקְּלִיקִים שֶׁל הַמִּשְׁתַּמְּשִׁים זוֹרְמִים יְשִׁירוֹת לְדָּאטָה לֵייק.",
            exampleNative = "Все клики пользователей текут прямо в דָּאטָה לֵייק.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176303, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_storage", transliteration = "es shalosh",
            original = "S3", translation = "S3 (объектное хранилище)",
            definition = "שֵׁרוּת אַחְסוּן עַל הָעָנָן שֶׁל אֲמָזוֹן — שׁוֹמֵר קַבְצֵי-עָנָק בְּמְחִיר נָמוּךְ לְפֵר ג׳יגה.",
            definitionNative = "Сервис хранения от Amazon — держит огромные файлы за низкую цену за гигабайт.",
            example = "כָּל הַקְבָצִים הַסְּטָטִיִּים שֶׁל הָאַתָר יוֹשְׁבִים בְּ-S3.",
            exampleNative = "Все статичные файлы сайта лежат в S3.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176304, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_storage", transliteration = "parket",
            original = "פַּרְקֵט", translation = "Parquet (формат файлов)",
            definition = "פוֹרְמָט קְבָצִים דָּחוּס שֶׁשּׁוֹמֵר לְפִי עַמּוּדוֹת — קָרִיא מָהִיר בִּשְׁאֵילְתוֹת אָנָלִיטִיוֹת.",
            definitionNative = "Сжатый формат файлов, хранит по столбцам — быстро читается аналитическими запросами.",
            example = "הִמַּרְנוּ אֶת הַטַּבְלָאוֹת לְפַּרְקֵט וְהַשְּׁאֵילְתוֹת רָצוֹת פִּי שְׁמוֹנֶה מַהֵר.",
            exampleNative = "Мы конвертировали таблицы в פַּרְקֵט — запросы бегут в восемь раз быстрее.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176305, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_storage", transliteration = "ihsun amudi",
            original = "אִחְסוּן עַמּוּדִי", translation = "колоночное хранение",
            definition = "שִׁיטַת שְׁמִירָה שֶׁבָּהּ כָּל עַמּוּדָה יוֹשֶׁבֶת בְּקֹבֶץ נִפְרָד — מְצֻיָּן לְקְרִיאָה שֶׁל שָׂדוֹת בּוֹדְדִים.",
            definitionNative = "Способ хранения, где каждый столбец лежит в отдельном файле — отлично читать одиночные поля.",
            example = "אִחְסוּן עַמּוּדִי חוֹסֵךְ הַרְבֵּה זִכָּרוֹן כְּשֶׁשּׁוֹלְפִים שְׁתֵּי עַמּוּדוֹת מִתּוֹךְ מֵאָה.",
            exampleNative = "אִחְסוּן עַמּוּדִי экономит много памяти, когда тянем два столбца из ста.",
            isFillInBlankSafe = false,
        ),

        // ── de_etl (5) — конвейеры данных ──
        WordEntity(
            id = 176306, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_etl", transliteration = "i-ti-el",
            original = "אֵי-טִי-אֵל", translation = "ETL (extract-transform-load)",
            definition = "תַּהֲלִיךְ שֶׁשּׁוֹאֵב נְתוּנִים מִמָּקוֹר, מְעַבֵּד אוֹתָם בְּדֶרֶךְ וְשׁוֹמֵר לַיַּעַד הַסּוֹפִי.",
            definitionNative = "Процесс — тянет данные из источника, обрабатывает по дороге и кладёт в финальное место.",
            example = "תַּהֲלִיךְ אֵי-טִי-אֵל לֵילִי מַעֲבִיר אֶת כָּל הַמְּכִירוֹת לַמֶּחְסָן.",
            exampleNative = "Ночной אֵי-טִי-אֵל переносит все продажи в хранилище.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176307, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_etl", transliteration = "i-el-ti",
            original = "אֵי-אֵל-טִי", translation = "ELT (extract-load-transform)",
            definition = "גִּישָׁה הַפוּכָה לְאֵי-טִי-אֵל — קוֹדֵם טוֹעֲנִים גַּלְמִי לַמֶּחְסָן וְרַק שָׁם מְעַבְּדִים בִּשְׁאֵילְתוֹת.",
            definitionNative = "Подход наоборот — сначала грузят сырое в хранилище и только там обрабатывают запросами.",
            example = "אֵי-אֵל-טִי הָפַךְ פּוֹפּוּלָרִי בְּעִדָּן הַמַּחְסָנִים הָעַנָנִיִּים הַחֲזָקִים.",
            exampleNative = "אֵי-אֵל-טִי стал популярным в эпоху мощных облачных хранилищ.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176308, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_etl", transliteration = "ibud batch",
            original = "עִבּוּד בָּאצ׳", translation = "пакетная обработка",
            definition = "רִיצָה שֶׁאוֹסֶפֶת חֲבִילָה גְּדוֹלָה שֶׁל נְתוּנִים וּמְעַבֶּדֶת אוֹתָהּ יַחַד פַּעַם בִּזְמַן קָבוּעַ.",
            definitionNative = "Прогон, собирающий большую партию данных и обрабатывающий её разом по расписанию.",
            example = "עִבּוּד בָּאצ׳ יוֹמִי מְסַכֵּם אֶת כָּל הָעִסְקוֹת וְשׁוֹלֵחַ דּוּחַ לַהַנְהָלָה.",
            exampleNative = "Ежедневный עִבּוּד בָּאצ׳ суммирует все сделки и шлёт отчёт руководству.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176309, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_etl", transliteration = "khaluka be-zman emet",
            original = "חֲלוּקָה בִּזְמַן אֱמֶת", translation = "обработка в реальном времени",
            definition = "קְלִיטַת אֵירוּעִים אֶחָד אֶחָד מִיָּד עִם הַגָּעָתָם — בְּלִי לְחַכּוֹת לְחֲבִילָה גְּדוֹלָה.",
            definitionNative = "Приём событий по одному сразу при поступлении — без ожидания большой партии.",
            example = "חֲלוּקָה בִּזְמַן אֱמֶת שֶׁל טְרַנְזַקְצְיוֹת מְזַהָה הוֹנָאָה לִפְנֵי שֶׁהִיא מַסְפִּיקָה לִקְרוֹת.",
            exampleNative = "חֲלוּקָה בִּזְמַן אֱמֶת транзакций ловит мошенничество прежде, чем оно успеет произойти.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176310, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_etl", transliteration = "paypline",
            original = "פַּיְיפְּלַיְין", translation = "конвейер данных (pipeline)",
            definition = "שַׁרְשֶׁרֶת שֶׁל שְׁלָבִים שֶׁמַּעֲבִירָה נְתוּנִים מִמָּקוֹר אֶחָד דֶּרֶךְ עִבּוּדִים עַד לַתּוֹצָאָה.",
            definitionNative = "Цепочка шагов, ведущая данные от источника через обработки к итогу.",
            example = "כָּל פַּיְיפְּלַיְין מְתֻעָד בִּקְרַיוֹן עִם בְּעָלִים אַחֲרָאִי.",
            exampleNative = "Каждый פַּיְיפְּלַיְין задокументирован на вики, с ответственным владельцем.",
            isFillInBlankSafe = false,
        ),

        // ── de_processing (5) — обработка данных ──
        WordEntity(
            id = 176311, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_processing", transliteration = "spark",
            original = "סְפַּארְק", translation = "Spark (движок обработки)",
            definition = "מָנוֹעַ עִבּוּד מָקְבִּילִי לְכַמֻּיּוֹת עֲצוּמוֹת — מְחַלֵּק עֲבוֹדָה בֵּין הַרְבֵּה מְכוֹנוֹת בָּעַת.",
            definitionNative = "Параллельный движок для огромных объёмов — делит работу между многими машинами сразу.",
            example = "ג׳וֹב שֶׁל סְפַּארְק עִבֵּד שְׁלוֹשָׁה טֵרָה תּוֹךְ עֶשְׂרִים דַּקּוֹת.",
            exampleNative = "Джоб סְפַּארְק обработал три терабайта за двадцать минут.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176312, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_processing", transliteration = "hadup",
            original = "הָאדוּפּ", translation = "Hadoop (платформа)",
            definition = "מַעֲרֶכֶת קְלָאסִית לִשְׁמִירָה וְעִבּוּד נְתוּנִים עַל אֶשְׁכּוֹל גָּדוֹל שֶׁל מְכוֹנוֹת זְעוּמוֹת.",
            definitionNative = "Классическая платформа — хранит и обрабатывает данные на большом кластере дешёвых машин.",
            example = "הַחֶבְרָה הוֹרִידָה אֶת אֶשְׁכּוֹל הָאדוּפּ הַיָּשָׁן וְעָבְרָה לְעָנָן.",
            exampleNative = "Фирма погасила старый кластер הָאדוּפּ и переехала в облако.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176313, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_processing", transliteration = "map-rid'us",
            original = "מָאפּ-רִידְיוּס", translation = "MapReduce (модель)",
            definition = "תַּבְנִית עִבּוּד מָקְבִּילִי בִּשְׁנֵי שְׁלָבִים — קוֹדֶם מְמַפִּים כָּל פְּרִיט וְאַחַר כָּךְ מְצַמְצְמִים יַחַד.",
            definitionNative = "Шаблон параллельной обработки в два шага — сначала разметить каждую запись, потом свернуть вместе.",
            example = "אַלְגוֹרִיתְם הַסְּפִירָה הַקְּלָאסִי שֶׁל מָאפּ-רִידְיוּס סוֹפֵר מִילִים בִּסְפָרִים שְׁלֵמִים.",
            exampleNative = "Классический алгоритм מָאפּ-רִידְיוּס считает слова в целых книгах.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176314, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_processing", transliteration = "partitsya",
            original = "פַּרְטִיצְיָה", translation = "партиционирование",
            definition = "חֲלוּקַת טַבְלָה גְּדוֹלָה לִפְרוּסוֹת לְפִי תַּאֲרִיךְ אוֹ אֵזוֹר — כְּדֵי לִקְרֹא רַק אֶת הַחֵלֶק הַנָּחוּץ.",
            definitionNative = "Деление большой таблицы на куски по дате или региону — чтобы читать только нужный.",
            example = "פַּרְטִיצְיָה לְפִי יוֹם מַזְמִינָה רַק שָׁלוֹשׁ מֵאוֹת מֶגָה בִּמְקוֹם טֵרָה שָׁלֵם.",
            exampleNative = "פַּרְטִיצְיָה по дню тянет триста мегабайт вместо целого терабайта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176315, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_processing", transliteration = "shafl",
            original = "שָׁאפְל", translation = "shuffle (перемешивание)",
            definition = "שְׁלָב יָקָר שֶׁבּוֹ נְתוּנִים זוֹרְמִים בֵּין מְכוֹנוֹת בְּאֶשְׁכּוֹל כְּדֵי לְקַבֵּץ לְפִי מַפְתֵּחַ מְשֻׁתָּף.",
            definitionNative = "Дорогой шаг — данные текут между машинами в кластере, чтобы сгруппироваться по общему ключу.",
            example = "צִמְצַמְנוּ שָׁאפְל וְהוֹרַדְנוּ אֶת מֶשֶׁךְ הַג׳וֹב מִשָּׁעָה לִשְׁמוֹנֶה דַּקּוֹת.",
            exampleNative = "Мы сократили שָׁאפְל — и время джоба упало с часа до восьми минут.",
            isFillInBlankSafe = false,
        ),

        // ── de_orchestration (5) — оркестрация задач ──
        WordEntity(
            id = 176316, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_orchestration", transliteration = "eyrflou",
            original = "אֵיירְפְלוֹאוּ", translation = "Airflow (оркестратор)",
            definition = "כְּלִי שֶׁמַּגְדִּיר וּמַפְעִיל סֵדֶר רִיצָה שֶׁל מְשִׂימוֹת נְתוּנִים — עַל פִּי לוּחַ זְמַנִּים וּתְלוּת.",
            definitionNative = "Инструмент — задаёт и запускает порядок прогона задач по данным, по расписанию и зависимостям.",
            example = "אֵיירְפְלוֹאוּ שׁוֹלֵחַ הַתְרָעָה לְסְלֶק כְּשֶׁמְּשִׂימָה נוֹפֶלֶת בָּאֶמְצַע הַלַּיְלָה.",
            exampleNative = "אֵיירְפְלוֹאוּ шлёт алёрт в Slack, когда задача падает посреди ночи.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176317, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_orchestration", transliteration = "deyag",
            original = "דֵּיאַג", translation = "DAG (граф задач)",
            definition = "תַּרְשִׁים שֶׁל מְשִׂימוֹת בְּלוּלְאוֹת — חִצִּים מַרְאִים מַה רָץ אַחֲרֵי מַה וְלֹא חוֹזְרִים אַחוֹרָה.",
            definitionNative = "Схема задач без циклов — стрелки показывают, что после чего идёт, и не возвращаются назад.",
            example = "כָּל פַּיְיפְּלַיְין מוּגְדָּר בִּקְוָבֶץ פַּיְתוֹן שֶׁמַּחְזִיר דֵּיאַג שָׁלֵם.",
            exampleNative = "Каждый пайплайн описан в Python-файле, возвращающем целый דֵּיאַג.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176318, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_orchestration", transliteration = "metazmen",
            original = "מְתַזְמֵן", translation = "планировщик",
            definition = "רְכִיב שֶׁמַּחֲלִיט מָתַי לְהַפְעִיל כָּל מְשִׂימָה לְפִי שָׁעוֹן אוֹ לְפִי הוֹפָעַת קֹבֶץ חָדָשׁ.",
            definitionNative = "Компонент, решающий, когда стартовать каждую задачу — по часам или по приходу нового файла.",
            example = "הַמְּתַזְמֵן הִפְעִיל אֶת הַעִבּוּד מִיָּד אַחֲרֵי שֶׁהַקֹּבֶץ נָחַת בְּ-S3.",
            exampleNative = "מְתַזְמֵן запустил обработку, как только файл сел в S3.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176319, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_orchestration", transliteration = "tlut bein meshimot",
            original = "תְּלוּת בֵּין מְשִׂימוֹת", translation = "зависимость между задачами",
            definition = "כְּלָל שֶׁאוֹמֵר שֶׁמְּשִׂימָה אַחַת תַּתְחִיל רַק כְּשֶׁאַחֶרֶת סִיְּמָה בְּהַצְלָחָה — בִּשְׁבִיל סֵדֶר נָכוֹן.",
            definitionNative = "Правило — одна задача стартует только после успешного финиша другой, для правильного порядка.",
            example = "הוֹסַפְתִּי תְּלוּת בֵּין מְשִׂימוֹת כְּדֵי שֶׁהַדּוּחַ לֹא יָרוּץ עַל טַבְלָה רֵיקָה.",
            exampleNative = "Я добавил תְּלוּת בֵּין מְשִׂימוֹת — чтобы отчёт не пошёл по пустой таблице.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176320, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_orchestration", transliteration = "bek-fil",
            original = "בֶּקְפִיל", translation = "backfill (досчёт прошлого)",
            definition = "רִיצָה רֶטְרוֹאַקְטִיבִית עַל תַּאֲרִיכִים שֶׁעָבְרוּ — כְּדֵי לְמַלֵּא אֶת הַטַּבְלָה לְאַחַר תִּקּוּן בָּאג.",
            definitionNative = "Ретроактивный прогон по прошедшим датам — заполнить таблицу после починки бага.",
            example = "בֶּקְפִיל שֶׁל חֹדֶשׁ אֶחָד לָקַח לַאֶשְׁכּוֹל אַרְבַּע שָׁעוֹת רְצוּפוֹת.",
            exampleNative = "בֶּקְפִיל за один месяц занял у кластера четыре часа подряд.",
            isFillInBlankSafe = false,
        ),

        // ── de_quality (5) — качество данных ──
        WordEntity(
            id = 176321, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_quality", transliteration = "eykhut data",
            original = "אֵיכוּת דָּאטָה", translation = "качество данных",
            definition = "מִדָּה שֶׁל אֱמוּנָה בַּטַּבְלָאוֹת — אִם הַשּׁוּרוֹת מְלֵאוֹת, נְכוֹנוֹת וּעֲדִיכָנִיוֹת.",
            definitionNative = "Мера доверия к таблицам — насколько строки полные, корректные и свежие.",
            example = "צֶוֶות אֵיכוּת דָּאטָה מַרִיץ מֵאָה בְּדִיקוֹת אוֹטוֹמָטִיּוֹת בְּכָל בֹּקֶר.",
            exampleNative = "Команда אֵיכוּת דָּאטָה прогоняет сотню автопроверок каждое утро.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176322, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_quality", transliteration = "akhifat skhema",
            original = "אַכִיפַת סְכֵמָה", translation = "контроль схемы",
            definition = "דְּחִיָּה אוֹטוֹמָטִית שֶׁל שׁוּרוֹת שֶׁלֹּא מַתְאִימוֹת לַמִּבְנֶה הַצָּפוּי — שֵׁם שָׂדֶה אוֹ סוּג שָׁגוּי.",
            definitionNative = "Автоматический отказ строкам, не подходящим под ожидаемое устройство — имя поля или тип.",
            example = "אַכִיפַת סְכֵמָה בִּכְנִיסָה תָּפְסָה שָׂדֶה חָדָשׁ שֶׁהוֹסִיפוּ בְּלִי לְעַדְכֵּן.",
            exampleNative = "אַכִיפַת סְכֵמָה на входе поймала новое поле, добавленное без оповещения.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176323, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_quality", transliteration = "deduplikatsya",
            original = "דֶּדוּפְּלִיקַצְיָה", translation = "дедупликация",
            definition = "סִלּוּק שׁוּרוֹת זֵהוֹת שֶׁהִגִּיעוּ פַּעֲמַיִם בִּגְלַל נִסְיוֹן חוֹזֵר אוֹ בָּאג בָּאַסְפָנִים.",
            definitionNative = "Удаление одинаковых строк, попавших дважды из-за повтора попытки или бага в коллекторах.",
            example = "אַחֲרֵי דֶּדוּפְּלִיקַצְיָה הַטַּבְלָה הִתְכַּוְּצָה בִּשְׁלוֹשִׁים אֲחוּזִים.",
            exampleNative = "После דֶּדוּפְּלִיקַצְיָה таблица сжалась на тридцать процентов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176324, setId = 1763, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "de_quality", transliteration = "naitunim me'uharim",
            original = "נְתוּנִים מְאֻחָרִים", translation = "поздно прибывшие данные",
            definition = "אֵירוּעִים שֶׁמַּגִּיעִים אַחֲרֵי שֶׁכְּבָר סָגַרְנוּ אֶת הַחַלּוֹן שֶׁלָּהֶם — בִּגְלַל רֶשֶׁת אִיטִּית אוֹ תּוֹר עָמוּס.",
            definitionNative = "События, приходящие после закрытия их окна — из-за медленной сети или забитой очереди.",
            example = "נְתוּנִים מְאֻחָרִים מֵאַפְלִיקַצְיוֹת נַיָּדוֹת מַגִּיעִים גַּם שָׁעָה אַחֲרֵי הָאֵירוּעַ.",
            exampleNative = "נְתוּנִים מְאֻחָרִים от мобилок приходят и через час после события.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176325, setId = 1763, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_quality", transliteration = "vatermark",
            original = "וָוטֶרְמַארְק", translation = "watermark (граница времени)",
            definition = "סִימָן שֶׁאוֹמֵר עַד אֵיזוֹ נְקֻדַּת זְמַן רוֹאִים אֶת הַזֶּרֶם כִּשְׁלֵם — מָה שֶׁמְּאַחֵר אַחֲרֵי כֵן יִדָּחֶה.",
            definitionNative = "Метка — до какой точки во времени поток считается полным; всё опоздавшее после неё отбросят.",
            example = "וָוטֶרְמַארְק שֶׁל חָמֵשׁ דַּקּוֹת מְאַזֵּן בֵּין מְהִירוּת לְבֵין דִּיוּק.",
            exampleNative = "וָוטֶרְמַארְק на пять минут балансирует между скоростью и точностью.",
            isFillInBlankSafe = false,
        ),
    )
}
