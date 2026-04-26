package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Data Engineering", уровень 5 (носитель языка).
 *
 * Set 1776: «Data Engineering» — носитель языка L5 (EPIC + LEGENDARY).
 * Стратегическая лексика дата-платформ для CDO, главных архитекторов и
 * стратегов: data mesh / fabric / lakehouse, federated query, MDM, data
 * governance высшего уровня (ethics, residency, sovereignty, GDPR rights).
 *
 * Целевая аудитория — русскоязычные сеньоры/руководители в израильском
 * хайтеке, ведущие data-стратегию компании. Лексика — реальная речь на
 * стратегических митингах: смесь иврита с английскими заимствованиями
 * (דָּאטָה מֵשׁ, לֵייקְהָאוּס, אֶם-דִּי-אֶם, סִי-דִּי-אוֹ, אֶנוֹנִימִיזַצְיָה).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   de_architecture_advanced — стратегические архитектуры: data mesh, fabric, lakehouse, medallion, domain
 *   de_query_advanced        — продвинутые запросы: federated query, query federation, push-down, materialized aggregation, columnar engine
 *   de_master_data           — MDM: master data, golden record, deduplication, entity resolution, reference data
 *   de_strategy              — стратегия: CDO, data strategy, democratization, literacy, ROI of data
 *   de_advanced_governance   — продвинутый governance: residency, sovereignty, GDPR rights, ethics, anonymization
 *
 * Word IDs: setId × 100 + position (177601..177625).
 *
 * Пересечения с другими наборами:
 *   - DataEng L3 (1763) содержит warehouse, lake, ETL, Spark, partition. Здесь — следующий
 *     уровень абстракции: lakehouse как архитектура, columnar engine как движок (не формат).
 *   - DataEng L4 (1764) содержит каталог, lineage, contract, OLAP, materialized view.
 *     Здесь не пересекается: MDM/golden record — другая ось, federated query ≠ materialized view,
 *     columnar engine ≠ Parquet (формат vs. движок), aggregation ≠ view.
 *   - Hightech L4 (1748) содержит GDPR в общем виде; здесь — конкретное право субъекта данных
 *     (זְכוּת נוֹשֵׂא הַמֵּידָע) — другая лексема, другая тема.
 *   - Hightech L5 (1749) содержит CTO/CPO/VP R&D. Здесь — CDO, отдельная C-level роль.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewDataEngL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1776, languagePair = "he-ru", orderIndex = 1776,
            name = "Data Engineering",
            description = "Стратегия данных: data mesh, lakehouse, federated query, MDM, governance",
            topic = "Data Engineering", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1776 — Data Engineering: носитель языка (L5, EPIC + LEGENDARY)
        // 5 групп × 5 слов: architecture_advanced, query_advanced, master_data, strategy, advanced_governance
        // ══════════════════════════════════════════════════════════════════════

        // ── de_architecture_advanced (5) — стратегические архитектуры данных ──
        WordEntity(
            id = 177601, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_architecture_advanced", transliteration = "data mesh",
            original = "דָּאטָה מֵשׁ", translation = "data mesh",
            definition = "גִּישָׁה שֶׁבָּהּ כָּל תְּחוּם עִסְקִי אַחְרַאי בְּעַצְמוֹ עַל הַמֵּידָע שֶׁלּוֹ כְּמוּצָר.",
            definitionNative = "Подход — каждый бизнес-домен сам отвечает за свои данные как за продукт.",
            example = "מַעֲבָר לְדָּאטָה מֵשׁ פִּזֵּר אֶת הָאַחְרָיוּת מֵהַצֶּוֶות הַמֶּרְכָּזִי לְכָל יְחִידוֹת הַחֶבְרָה.",
            exampleNative = "Переход на דָּאטָה מֵשׁ распределил ответственность с центра по подразделениям.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177602, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_architecture_advanced", transliteration = "data fabric",
            original = "דָּאטָה פֶבְּרִיק", translation = "data fabric",
            definition = "שִׁכְבָה אַחֲדוּתִית שֶׁמְּחַבֶּרֶת מַאֲגָרִים מְפֻזָּרִים לִתְחוּשָׁה שֶׁל מְקוֹר אֶחָד.",
            definitionNative = "Единый слой — связывает разрозненные хранилища в ощущение одного источника.",
            example = "דָּאטָה פֶבְּרִיק חָסַךְ לָנוּ שִׁכְפּוּל שֶׁל טַבְלָאוֹת בֵּין שָׁלוֹשׁ עֲנָנִים שׁוֹנִים.",
            exampleNative = "דָּאטָה פֶבְּרִיק избавил нас от копий таблиц между тремя облаками.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177603, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_architecture_advanced", transliteration = "leykhaus",
            original = "לֵייקְהָאוּס", translation = "lakehouse",
            definition = "אַרְכִיטֶקְטוּרָה שֶׁמְּשַׁלֶּבֶת אַחְסוּן זוֹל שֶׁל לֵייק עִם שְׁאֵלוֹת מְבֻנּוֹת שֶׁל מַחְסָן.",
            definitionNative = "Архитектура — соединяет дешёвое хранение озера со структурными запросами хранилища.",
            example = "מַעֲבָר לְלֵייקְהָאוּס בְּדֵלְתָּא לֵייק חָסַךְ לָנוּ שִׁכְפּוּל מַשְׁמָעוּתִי שֶׁל מֵידָע.",
            exampleNative = "Переход на לֵייקְהָאוּס на Delta Lake избавил нас от существенного дублирования данных.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177604, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_architecture_advanced", transliteration = "arkhitekturat medalyon",
            original = "אַרְכִיטֶקְטוּרַת מֵדַלְיוֹן", translation = "medallion architecture",
            definition = "תַּבְנִית בִּשְׁלוֹשׁ שִׁכְבוֹת — בְּרוֹנְזֶה לְגַלְמִי, כֶּסֶף לְמְעוּבָּד, זָהָב לִמְזֻכָּךְ.",
            definitionNative = "Шаблон в три слоя — бронза для сырого, серебро для обработанного, золото для очищенного.",
            example = "אַרְכִיטֶקְטוּרַת מֵדַלְיוֹן הֵקְלָה עַל הַסְּדֶר וְהַמַּעֲקָב אַחַר אֵיכוּת הַמֵּידָע.",
            exampleNative = "אַרְכִיטֶקְטוּרַת מֵדַלְיוֹן облегчила порядок и слежение за качеством данных.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177605, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_architecture_advanced", transliteration = "tkhum data",
            original = "תְּחוּם דָּאטָה", translation = "data domain",
            definition = "אֵזוֹר עִסְקִי מֻגְדָּר — לְמָשָׁל מְכִירוֹת אוֹ לוֹגִיסְטִיקָה — שֶׁמַּחֲזִיק אֶת הַמֵּידָע שֶׁלּוֹ.",
            definitionNative = "Очерченная бизнес-зона — например, продажи или логистика — владеющая своими данными.",
            example = "כָּל תְּחוּם דָּאטָה אֵצְלֵנוּ מַעֲסִיק מְהַנְדֵס אֶחָד שֶׁאַחְרַאי עַל הַשִּׁכְבָה הַזָּהֻבָּה.",
            exampleNative = "Каждый תְּחוּם דָּאטָה у нас держит одного инженера на золотом слое.",
            isFillInBlankSafe = false,
        ),

        // ── de_query_advanced (5) — продвинутые запросы и движки ──
        WordEntity(
            id = 177606, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_query_advanced", transliteration = "she'ela federativit",
            original = "שְׁאֵלָה פֶדֵרָטִיבִית", translation = "federated query",
            definition = "פְּנִיָּה אַחַת שֶׁמּוֹשֶׁכֶת תּוֹצָאוֹת מִכַּמָּה מַאֲגָרִים נִפְרָדִים בְּלִי לְהַעֲתִיק אוֹתָם מֵרֹאשׁ.",
            definitionNative = "Один запрос — тянет результат из нескольких раздельных баз без копирования заранее.",
            example = "שְׁאֵלָה פֶדֵרָטִיבִית אַחַת אִחֲדָה לָנוּ נְתוּנִים מִשִּׁבְעָה מַאֲגָרִים בְּלִי הַעֲתָקָה.",
            exampleNative = "Одна שְׁאֵלָה פֶדֵרָטִיבִית собрала нам данные из семи баз без копирования.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177607, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_query_advanced", transliteration = "ihud mekorot",
            original = "אִיחוּד מְקוֹרוֹת", translation = "query federation (объединение источников)",
            definition = "טֶכְנִיקָה שֶׁמְּצִיגָה כַּמָּה מַאֲגָרִים שׁוֹנִים כְּמַעֲרֶכֶת אַחַת לַמִּשְׁתַּמֵּשׁ הַסּוֹפִי.",
            definitionNative = "Техника — показывает несколько разных хранилищ как одну систему конечному пользователю.",
            example = "אִיחוּד מְקוֹרוֹת בְּטְרִינוֹ פָּתַח לָאַנָלִיסְטִים גִּישָׁה לְכָל שֶׁבַע הַחֲטִיבוֹת.",
            exampleNative = "אִיחוּד מְקוֹרוֹת в Trino открыл аналитикам доступ ко всем семи дивизионам.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177608, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_query_advanced", transliteration = "dkhifat tnai",
            original = "דְּחִיפַת תְּנַאי", translation = "push-down predicate",
            definition = "אוֹפְּטִימִיזַצְיָה שֶׁבָּהּ הַסִּנּוּן מָתַחֲלִיף לְצַד הַמַּקוֹר — קוֹרְאִים פָּחוֹת שׁוּרוֹת.",
            definitionNative = "Оптимизация — фильтр уезжает на сторону источника, читается меньше строк.",
            example = "דְּחִיפַת תְּנַאי הוֹרִידָה אֶת הַזְּמַן מִשָּׁלוֹשׁ דַּקּוֹת לִשְׁתֵּי שְׁנִיּוֹת.",
            exampleNative = "דְּחִיפַת תְּנַאי опустила время с трёх минут до двух секунд.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177609, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_query_advanced", transliteration = "tsbira me-rosh",
            original = "צְבִירָה מֵרֹאשׁ", translation = "materialized aggregation",
            definition = "סִכּוּם שָׁמוּר מֵרֹאשׁ שֶׁל מַסְפָּרִים גְּדוֹלִים כְּדֵי שֶׁדּוּחוֹת יַחְזְרוּ מִיָּד.",
            definitionNative = "Заранее сохранённая сводка крупных чисел, чтобы отчёты возвращались мгновенно.",
            example = "צְבִירָה מֵרֹאשׁ שֶׁל הַמְּכִירוֹת לְפִי חֹדֶשׁ מַחְזִירָה אֶת הַדּוּחַ בְּפָחוֹת מִשְּׁנִיָּה.",
            exampleNative = "צְבִירָה מֵרֹאשׁ продаж по месяцу возвращает отчёт меньше чем за секунду.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177610, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_query_advanced", transliteration = "manoa amudi",
            original = "מָנוֹעַ עַמּוּדִי", translation = "columnar engine",
            definition = "תּוֹכְנָה שֶׁקּוֹרֵאת קַבְצֵי עַמּוּדוֹת מָהִיר וּמַרִיצָה שְׁאֵלוֹת אָנָלִיטִיוֹת בִּדְחִיסָה גְּבוֹהָה.",
            definitionNative = "Софт — быстро читает столбцовые файлы и катает аналитические запросы со сжатием.",
            example = "מָנוֹעַ עַמּוּדִי בְּקְלִיקְהָאוּס סוֹרֵק מִילְיַארְד שׁוּרוֹת בִּשְׁתֵּי שְׁנִיּוֹת.",
            exampleNative = "מָנוֹעַ עַמּוּדִי в ClickHouse сканирует миллиард строк за две секунды.",
            isFillInBlankSafe = false,
        ),

        // ── de_master_data (5) — управление мастер-данными ──
        WordEntity(
            id = 177611, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_master_data", transliteration = "em-di-em",
            original = "אֶם-דִּי-אֶם", translation = "master data management (MDM)",
            definition = "מַעֲרֶכֶת שֶׁמְּתַחְזֶקֶת גִּרְסָה אֶחָת אֲמִיתִית שֶׁל כָּל יֵשׁוּת חֲשׁוּבָה — לָקוֹחַ, מוּצָר אוֹ סַפָּק.",
            definitionNative = "Система — поддерживает одну истинную версию каждой важной сущности: клиент, продукт или поставщик.",
            example = "פְּרוֹיֶיקְט אֶם-דִּי-אֶם נִמְשַׁךְ שָׁנָה וּמַחֲצִית וְאִיחֵד שִׁבְעָה מַאֲגָרֵי לְקוֹחוֹת.",
            exampleNative = "Проект אֶם-דִּי-אֶם длился полтора года и слил семь баз клиентов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177612, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_master_data", transliteration = "rishum mukhshar",
            original = "רִישׁוּם מֻכְשָׁר", translation = "golden record (эталонная запись)",
            definition = "הָרְשׁוּמָה הַסּוֹפִית וְהַנְּכוֹנָה בְּיוֹתֵר שֶׁל יֵשׁוּת — אַחֲרֵי שֶׁאִיחֲדוּ כָּל הַמְּקוֹרוֹת.",
            definitionNative = "Финальная и самая корректная запись о сущности — после слияния всех источников.",
            example = "רִישׁוּם מֻכְשָׁר שֶׁל לָקוֹחַ מַכִּיל אֶת הַכְּתֹבֶת הָעַדְכָּנִית בְּיוֹתֵר מִכָּל מַעֲרֶכֶת.",
            exampleNative = "רִישׁוּם מֻכְשָׁר клиента содержит самый свежий адрес из всех систем.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177613, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_master_data", transliteration = "iikuy kfilim",
            original = "נִיקּוּי כְּפִילִים", translation = "очистка дубликатов (data deduplication)",
            definition = "תַּהֲלִיךְ שֶׁמְּזַהֶה רְשׁוּמוֹת זֵהוֹת אוֹ דּוֹמוֹת מְאוֹד וּמַשְׁאִיר רַק אַחַת מֵהֶן.",
            definitionNative = "Процесс — находит идентичные или очень похожие записи и оставляет лишь одну.",
            example = "נִיקּוּי כְּפִילִים בִּרְשׁוּמוֹת לְקוֹחוֹת חָסַךְ עֶשְׂרִים אֲחוּזֵי שׁוּרוֹת.",
            exampleNative = "נִיקּוּי כְּפִילִים в клиентских записях сэкономил двадцать процентов строк.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177614, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_master_data", transliteration = "zihuy yeshuyot",
            original = "זִיהוּי יֵשׁוּיוֹת", translation = "entity resolution",
            definition = "טֶכְנִיקָה לְקַבֵּעַ שֶׁשְּׁתֵּי רְשׁוּמוֹת שׁוֹנוֹת מִמַּאֲגָרִים שׁוֹנִים מַתְיַחְסוֹת לְאוֹתוֹ אִישׁ.",
            definitionNative = "Техника — определить, что две разные записи из разных баз относятся к одному человеку.",
            example = "אַלְגוֹרִיתְם זִיהוּי יֵשׁוּיוֹת חִבֵּר רְשׁוּמוֹת מֵהַסִינִיף וּמֵהַאֲתָר.",
            exampleNative = "Алгоритм זִיהוּי יֵשׁוּיוֹת связал записи из филиала и с сайта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177615, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_master_data", transliteration = "data referens",
            original = "דָּאטָה רֵפֶרֶנְס", translation = "reference data (справочники)",
            definition = "טַבְלָאוֹת קְבוּעוֹת שֶׁל קוֹדִים וְעֶרְכֵי בָּסִיס — לְמָשָׁל מְדִינוֹת, מַטְבְּעוֹת אוֹ סְטָטוּסִים.",
            definitionNative = "Постоянные таблицы кодов и базовых значений — например, страны, валюты или статусы.",
            example = "דָּאטָה רֵפֶרֶנְס שֶׁל מַטְבְּעוֹת מִתְעַדְכֵּן בְּכָל לַיְלָה מֵהַבַּנְק.",
            exampleNative = "דָּאטָה רֵפֶרֶנְס валют обновляется каждой ночью прямо из банка.",
            isFillInBlankSafe = false,
        ),

        // ── de_strategy (5) — стратегия данных и руководство ──
        WordEntity(
            id = 177616, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_strategy", transliteration = "si-di-o",
            original = "סִי-דִּי-אוֹ", translation = "CDO (директор по данным)",
            definition = "מְנַהֵל בָּכִיר בִּדְרַג הַהַנְהָלָה שֶׁאַחְרַאי עַל הַנֶּכֶס הָאִסְטְרָטֶגִי שֶׁל הַמֵּידָע בָּעֵסֶק.",
            definitionNative = "Высший управленец C-level — отвечает за стратегический актив информации в бизнесе.",
            example = "סִי-דִּי-אוֹ הוּגַשׁ יָשִׁיר לַמְּנַכָּ״ל וְלֹא לַסַּמְנְכָּ״ל הַטֶּכְנוֹלוֹגִי.",
            exampleNative = "סִי-דִּי-אוֹ подчиняется напрямую CEO, а не техническому VP.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177617, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_strategy", transliteration = "estrategiyat data",
            original = "אֶסְטְרָטֶגְיַית דָּאטָה", translation = "data strategy",
            definition = "תּוֹכְנִית רַב-שְׁנָתִית שֶׁמַּגְדִּירָה אֵיךְ הָעֵסֶק מַפִּיק עֵרֶךְ מֵהַמֵּידָע שֶׁבִּרְשׁוּתוֹ.",
            definitionNative = "Многолетний план — как бизнес извлекает ценность из имеющейся информации.",
            example = "אֶסְטְרָטֶגְיַית דָּאטָה לְחָמֵשׁ שָׁנִים אֻשְּׁרָה בִּישִׁיבַת הַדִּירֶקְטוֹרְיוֹן.",
            exampleNative = "אֶסְטְרָטֶגְיַית דָּאטָה на пять лет утвердили на заседании совета директоров.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177618, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_strategy", transliteration = "demokratizatsya",
            original = "דֵּמוֹקְרָטִיזַצְיָה", translation = "data democratization",
            definition = "מְגַמָּה שֶׁבָּהּ גִּישָׁה לַמֵּידָע נִפְתַּחַת לְכָל הָעוֹבְדִים, לֹא רַק לַמְּהַנְדְסִים אוֹ לַאֲנָלִיסְטִים.",
            definitionNative = "Тенденция — доступ к информации открывается всем сотрудникам, не только инженерам и аналитикам.",
            example = "דֵּמוֹקְרָטִיזַצְיָה הִקְפִּיצָה שְׁאֵלוֹת שְׁבוּעִיּוֹת מֵאֶלֶף לַעֲשֶׂרֶת אֲלָפִים.",
            exampleNative = "דֵּמוֹקְרָטִיזַצְיָה подняла недельные запросы с тысячи до десяти тысяч.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177619, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_strategy", transliteration = "oryanut data",
            original = "אוֹרְיָנוּת דָּאטָה", translation = "data literacy",
            definition = "יְכוֹלֶת שֶׁל עוֹבְדִים רְגִילִים לִקְרֹא, לְפָרֵשׁ וּלְקַבֵּל הַחְלָטוֹת לְפִי גְּרָפִים וּמַסְפָּרִים.",
            definitionNative = "Способность обычных работников читать, толковать и решать на основе графиков и чисел.",
            example = "סָדְנַת אוֹרְיָנוּת דָּאטָה לִשְׁלוֹשׁ מֵאוֹת עוֹבְדִים נִפְתְּחָה בְּתוֹם הָרֹבַע.",
            exampleNative = "Воркшоп אוֹרְיָנוּת דָּאטָה на триста сотрудников открыли в конце квартала.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177620, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_strategy", transliteration = "tsuat data",
            original = "תְּשׁוּאַת דָּאטָה", translation = "ROI of data (отдача от данных)",
            definition = "מַדָּד שֶׁמּוֹדֵד כַּמָּה כֶּסֶף הָעֵסֶק רוֹוֵחַ מֵהָהַשְׁקָעָה בַּתַּשְׁתִּית וּבַצֶּוֶות שֶׁלַּמֵּידָע.",
            definitionNative = "Метрика — сколько денег бизнес зарабатывает с вложений в инфраструктуру и команду данных.",
            example = "תְּשׁוּאַת דָּאטָה מַעֲרִיכָה אֶת הַחִסָּכוֹן בִּמְלָאי בִּשְׁמוֹנָה מִילְיוֹן שֶׁקֶל בַּשָּׁנָה.",
            exampleNative = "תְּשׁוּאַת דָּאטָה оценивает экономию на складе в восемь миллионов шекелей в год.",
            isFillInBlankSafe = false,
        ),

        // ── de_advanced_governance (5) — продвинутая регуляция и этика данных ──
        WordEntity(
            id = 177621, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_advanced_governance", transliteration = "tushavut data",
            original = "תּוֹשָׁבוּת דָּאטָה", translation = "data residency",
            definition = "דְּרִישָׁה שֶׁמֵּידָע פִיזִי יִשְׁמֹר בִּמְדִינָה מְסוּיֶמֶת — לְמָשָׁל אֵירוֹפָּה אוֹ יִשְׂרָאֵל.",
            definitionNative = "Требование — физически держать данные в определённой стране: например, в Европе или Израиле.",
            example = "תּוֹשָׁבוּת דָּאטָה גֶּרְמָנִית חִיְּבָה אוֹתָנוּ לִשְׂכּוֹר שֶׁרֶת בְּפְרַנְקְפוּרְט.",
            exampleNative = "Немецкая תּוֹשָׁבוּת דָּאטָה обязала арендовать сервер во Франкфурте.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177622, setId = 1776, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_advanced_governance", transliteration = "ribonut data",
            original = "רִיבּוֹנוּת דָּאטָה", translation = "data sovereignty",
            definition = "עֶקְרוֹן שֶׁלְּפִיו הַמֵּידָע כָּפוּף לְחֻקֵּי הַמְּדִינָה שֶׁבָּהּ הוּא נֶאֱסַף אוֹ נִשְׁמָר.",
            definitionNative = "Принцип — данные подчиняются законам страны, где их собирают или хранят.",
            example = "רִיבּוֹנוּת דָּאטָה הִקְשְׁתָה עָלֵינוּ לְהַעֲבִיר אֶת הַשֵּׁרוּת לְעַנְנֵי אַמְרִיקָנִי.",
            exampleNative = "רִיבּוֹנוּת דָּאטָה помешала нам перенести сервис в американское облако.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177623, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_advanced_governance", transliteration = "zkhut nose ha-meyda",
            original = "זְכוּת נוֹשֵׂא הַמֵּידָע", translation = "GDPR data subject right",
            definition = "סַמְכוּת שֶׁל אֶזְרָח אֵירוֹפֵּי לִדְרוֹשׁ מִן הַחֶבְרָה לִמְחֹק אוֹ לִשְׁלֹחַ אֵלָיו אֶת הַמֵּידָע עָלָיו.",
            definitionNative = "Полномочие европейца требовать у фирмы стереть или прислать ему данные о нём.",
            example = "בַּקָּשַׁת זְכוּת נוֹשֵׂא הַמֵּידָע מֵאֶזְרָח גֶּרְמָנִי הִגִּיעָה דֶּרֶךְ הַ-DPO.",
            exampleNative = "Запрос זְכוּת נוֹשֵׂא הַמֵּידָע от немецкого гражданина пришёл через DPO.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177624, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_advanced_governance", transliteration = "etika shel data",
            original = "אֶתִיקָה שֶׁל דָּאטָה", translation = "data ethics",
            definition = "כְּלָלִים מוּסָרִיִּים שֶׁל אִסּוּף וְשִׁמּוּשׁ בְּמֵידָע — מֵעֵבֶר לְמָה שֶׁהַחוֹק מַתִּיר.",
            definitionNative = "Моральные правила сбора и использования информации — за пределами того, что позволяет закон.",
            example = "וַעֲדַת אֶתִיקָה שֶׁל דָּאטָה פָּסְלָה שִׁמּוּשׁ בְּמִקּוּם הַמִּשְׁתַּמֵּשׁ לְפִרְסוּם.",
            exampleNative = "Комитет אֶתִיקָה שֶׁל דָּאטָה запретил использовать локацию пользователя для рекламы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177625, setId = 1776, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_advanced_governance", transliteration = "anonimizatsya",
            original = "אֲנוֹנִימִיזַצְיָה", translation = "anonymization",
            definition = "תַּהֲלִיךְ שֶׁמּוֹחֵק מֵרְשׁוּמוֹת אֶת הַסִּימָנִים שֶׁמְּזַהִים אִישׁ פְּרָטִי בְּלִי לְבַטֵּל אֶת הַשִּׁמּוּשׁ.",
            definitionNative = "Процесс — стирает из записей метки, выдающие конкретного человека, без потери пригодности.",
            example = "אֲנוֹנִימִיזַצְיָה שֶׁל לוֹגֵי הַחֵיפּוּשׂ אִפְשְׁרָה לָנוּ לִשְׁתֵּף נְתוּנִים עִם חוֹקְרִים.",
            exampleNative = "אֲנוֹנִימִיזַצְיָה поисковых логов позволила делиться данными с исследователями.",
            isFillInBlankSafe = false,
        ),
    )
}
