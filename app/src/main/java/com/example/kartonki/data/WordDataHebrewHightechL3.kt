package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Хайтек", L3 «Углублённый» (RARE+EPIC).
 *
 * Set 1747: «Хайтек» — углублённый L3:
 *           Архитектура и стек: фреймворки, базы данных, API, cloud, паттерны.
 *
 * Тема ориентирована на разработчика, который изучает иврит для работы
 * в израильском хайтеке. Лексика отражает реальную речь в тель-авивских
 * офисах: множество английских заимствований (פְרֵיימְוֶורְק, קוֹמְפּוֹנֶנְט,
 * אֶנְדְּפּוֹינְט, קוֹנְטֵיינֶר, מַיקְרוֹסֶרְוִיס и т.д.) — так реально говорят инженеры.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC (L3 = специальная архитектурная
 * лексика, не базовый офисный сленг).
 *
 * SemanticGroups (5 × 5):
 *   hightech_frontend       — фронтенд: фреймворк, компонент, рендер, state, бандлер
 *   hightech_backend        — бэкенд: эндпоинт, API, middleware, ORM, очередь сообщений
 *   hightech_database       — БД: схема, индекс, query, миграция, репликация
 *   hightech_cloud          — облако: cloud-сервис, контейнер, оркестрация, scaling, регион
 *   hightech_arch_patterns  — паттерны: микросервис, монолит, event sourcing, кэш-слой, LB
 *
 * Word IDs: setId × 100 + position (174701..174725).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewHightechL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1747, languagePair = "he-ru", orderIndex = 1747,
            name = "Хайтек",
            description = "Архитектура и стек: фреймворки, базы данных, API, cloud",
            topic = "Хайтек", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1747 — Хайтек: углублённый (L3, RARE+EPIC)
        // 5 групп × 5 слов: frontend, backend, database, cloud, arch_patterns
        // ══════════════════════════════════════════════════════════════════════

        // ── hightech_frontend (5) — клиентская разработка ──
        WordEntity(
            id = 174701, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_frontend", transliteration = "freymverk",
            original = "פְרֵיימְוֶורְק", translation = "фреймворк",
            definition = "סֵט מוּכָן שֶׁל קוֹד וְכֵלִים שֶׁעֲלֵיהֶם בּוֹנִים אַפְּלִיקַצְיָה — חוֹסֵךְ זְמַן.",
            definitionNative = "Готовый набор кода и инструментов, на котором собирают приложение — экономит время.",
            example = "הַצֶּוֶות בָּחַר פְרֵיימְוֶורְק חָדָשׁ בִּשְׁבִיל הַמְּמַשֵּׁק הַחָדָשׁ.",
            exampleNative = "Команда выбрала новый פְרֵיימְוֶורְק для нового интерфейса.",
         fillInBlankExclusions = listOf(174702L, 174703L, 174704L, 174705L)),
        WordEntity(
            id = 174702, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_frontend", transliteration = "komponent",
            original = "קוֹמְפּוֹנֶנְט", translation = "компонент UI",
            definition = "חֲתִיכַת מִמְשָׁק עַצְמָאִית, כְּמוֹ כַּפְתּוֹר אוֹ טֹפֶס, שֶׁמַּרְכִּיבִים מִמֶּנָּה דַּף.",
            definitionNative = "Самостоятельный кусок интерфейса — кнопка или форма — из которого собирают страницу.",
            example = "כָּתַבְתִּי קוֹמְפּוֹנֶנְט שֶׁמּוּשַׁמַּשׁ בְּחָמֵשׁ עֲמוּדִים שׁוֹנִים בָּאַתָר.",
            exampleNative = "Я написал קוֹמְפּוֹנֶנְט, который используется на пяти разных страницах сайта.",
         fillInBlankExclusions = listOf(174701L, 174703L, 174704L, 174705L)),
        WordEntity(
            id = 174703, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_frontend", transliteration = "render",
            original = "רֶנְדֶר", translation = "рендеринг (отрисовка)",
            definition = "הַשָּׁלָב שֶׁבּוֹ הַדַּפְדְּפָן הוֹפֵךְ קוֹד לְתְּמוּנָה אֲמִיתִּית עַל הַמָּסָךְ.",
            definitionNative = "Этап, когда браузер превращает код в реальную картинку на экране.",
            example = "רֶנְדֶר שֶׁל הָרְשִׁימָה הָאֲרֻכָּה הָיָה אִיטִּי בִּמְכוֹנוֹת חַלָּשׁוֹת.",
            exampleNative = "רֶנְדֶר длинного списка был медленным на слабых машинах.",
         fillInBlankExclusions = listOf(174701L, 174702L, 174704L, 174705L)),
        WordEntity(
            id = 174704, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_frontend", transliteration = "nihul steyt",
            original = "נִיהוּל סְטֵייט", translation = "управление состоянием (state-management)",
            definition = "שִׁיטָה לִשְׁמֹר וּלְעַדְכֵּן נְתוּנִים מְשֻׁתָּפִים בֵּין חֲלָקִים שׁוֹנִים שֶׁל הָאַפְּלִיקַצְיָה.",
            definitionNative = "Способ хранить и обновлять общие данные между разными частями приложения.",
            example = "נִיהוּל סְטֵייט מְסֻדָּר חוֹסֵךְ הַרְבֵּה בָּאגִים בִּטְפָסִים גְּדוֹלִים.",
            exampleNative = "Аккуратный נִיהוּל סְטֵייט экономит много багов в больших формах.",
         fillInBlankExclusions = listOf(174701L, 174702L, 174703L, 174705L)),
        WordEntity(
            id = 174705, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_frontend", transliteration = "bandler",
            original = "בַּנְדְּלֶר", translation = "сборщик (bundler)",
            definition = "כְּלִי שֶׁמְּאַחֵד הַרְבֵּה קַבְצֵי קוֹד לִקְבָצִים מְעַטִים שֶׁהַדַּפְדְּפָן טוֹעֵן מַהֵר.",
            definitionNative = "Инструмент, объединяющий много файлов кода в несколько — браузер грузит их быстрее.",
            example = "הַבַּנְדְּלֶר הֶחָדָשׁ הוֹרִיד אֶת זְמַן הַטְּעִינָה לְשָׁנִיָּה אַחַת.",
            exampleNative = "Новый בַּנְדְּלֶר опустил время загрузки до одной секунды.",
         fillInBlankExclusions = listOf(174701L, 174702L, 174703L, 174704L)),

        // ── hightech_backend (5) — серверная сторона ──
        WordEntity(
            id = 174706, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_backend", transliteration = "endpoint",
            original = "אֶנְדְּפּוֹינְט", translation = "эндпоинт",
            definition = "כְּתֹבֶת מְסֻיֶּמֶת שֶׁאֵלֶיהָ הָאַפְּלִיקַצְיָה פּוֹנָה כְּדֵי לִקְרֹא אוֹ לִכְתֹּב נְתוּנִים.",
            definitionNative = "Конкретный адрес, к которому приложение обращается, чтобы прочитать или записать данные.",
            example = "הַמְּפַתֵּחַ הוֹסִיף אֶנְדְּפּוֹינְט חָדָשׁ לְשִׁלוּחַ הוֹדָעוֹת מַעֲרֶכֶת.",
            exampleNative = "Разработчик добавил новый אֶנְדְּפּוֹינְט для отправки системных сообщений.",
         fillInBlankExclusions = listOf(174707L, 174708L, 174709L, 174710L)),
        WordEntity(
            id = 174707, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_backend", transliteration = "ey-pi-ay",
            original = "אֵיי-פִּי-אַיי", translation = "API (REST-интерфейс)",
            definition = "חֻקֵּי הַשִּׂיחָה בֵּין שְׁתֵּי תּוֹכְנוֹת — מָה לִשְׁאֹל וּבְאֵיזֶה פוֹרְמָט מְקַבְּלִים תְּשׁוּבָה.",
            definitionNative = "Правила разговора между двумя программами — что спрашивать и в каком формате приходит ответ.",
            example = "אֵיי-פִּי-אַיי שֶׁל הַבַּנְק חָסַם אֶת הַבַּקָּשׁוֹת אַחֲרֵי שֶׁהַמַּפְתֵּחַ פָּג.",
            exampleNative = "אֵיי-פִּי-אַיי банка заблокировал запросы после того, как ключ истёк.",
         fillInBlankExclusions = listOf(174706L, 174708L, 174709L, 174710L)),
        WordEntity(
            id = 174708, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_backend", transliteration = "midlveyer",
            original = "מִידְלְוֵוייר", translation = "middleware",
            definition = "שִׁכְבַת קוֹד שֶׁיּוֹשֶׁבֶת בֵּין הַבַּקָּשָׁה לְבֵין הַלּוֹגִיקָה וּמְבַצַּעַת בְּדִיקוֹת אוֹ רִישׁוּם.",
            definitionNative = "Слой кода между запросом и логикой — проверяет, логирует или меняет данные.",
            example = "הוֹסַפְתִּי מִידְלְוֵוייר לִבְדִיקַת הַרְשָׁאוֹת לִפְנֵי כָּל בַּקָּשָׁה.",
            exampleNative = "Я добавил מִידְלְוֵוייר для проверки прав перед каждым запросом.",
         fillInBlankExclusions = listOf(174706L, 174707L, 174709L, 174710L)),
        WordEntity(
            id = 174709, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_backend", transliteration = "o-ar-em",
            original = "אוֹ-אַר-אֶם", translation = "ORM (объектно-реляционный слой)",
            definition = "סִפְרִיָּה שֶׁמְּתַרְגֶּמֶת קוֹד תּוֹכְנָה לִשְׁאִילְתוֹת מָסַד בְּלִי לִכְתֹּב SQL בַּיָּד.",
            definitionNative = "Библиотека, переводящая код в обращения к базе — без писания SQL руками.",
            example = "אוֹ-אַר-אֶם פּוֹפּוּלָרִי בִּפְּרוֹיֶקְטִים שֶׁל פַּיְתוֹן וְרוּבִּי.",
            exampleNative = "אוֹ-אַר-אֶם популярен в проектах на Python и Ruby.",
         fillInBlankExclusions = listOf(174706L, 174707L, 174708L, 174710L)),
        WordEntity(
            id = 174710, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_backend", transliteration = "mesej kyu",
            original = "מֶסֶג׳ קְיוּ", translation = "очередь сообщений",
            definition = "תָּא בּוּפֶר שֶׁמַּחְזִיק עֲבוֹדוֹת בְּהַמְתָּנָה כְּדֵי שֶׁשֵׁרוּתִים יְעַבְּדוּ אוֹתָן בַּתּוֹר.",
            definitionNative = "Буфер, в котором задачи стоят в очереди, чтобы сервисы обрабатывали их по порядку.",
            example = "מֶסֶג׳ קְיוּ מְפָרֵק לוֹאוּד גָּדוֹל לְבַקָּשׁוֹת קְטַנּוֹת.",
            exampleNative = "מֶסֶג׳ קְיוּ разбивает большую нагрузку на маленькие задачи.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_database (5) — базы данных ──
        WordEntity(
            id = 174711, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_database", transliteration = "skhema",
            original = "סְכֵמָה", translation = "схема БД",
            definition = "תֵּאוּר שֶׁל מִבְנֶה הַמָּסַד — אֵילוּ טַבְלָאוֹת קַיָּמוֹת וְאֵילוּ שָׂדוֹת בָּהֶן.",
            definitionNative = "Описание устройства базы — какие таблицы существуют и какие в них поля.",
            example = "צִיַּרְנוּ סְכֵמָה עַל הַלּוּחַ לִפְנֵי שֶׁהִתְחַלְנוּ לִכְתֹּב קוֹד.",
            exampleNative = "Мы нарисовали סְכֵמָה на доске перед тем, как начали писать код.",
         fillInBlankExclusions = listOf(174712L, 174713L, 174714L, 174715L)),
        WordEntity(
            id = 174712, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_database", transliteration = "indeks",
            original = "אִינְדֶּקְס", translation = "индекс (БД)",
            definition = "מִבְנֶה עֵזֶר שֶׁמְּזָרֵז חִפּוּשׂ עַל שָׂדֶה מְסֻיָּם בְּטַבְלָאוֹת גְּדוֹלוֹת.",
            definitionNative = "Вспомогательная структура — ускоряет поиск по конкретному полю в больших таблицах.",
            example = "הוֹסִיפוּ אִינְדֶּקְס עַל שְׂדֵה הַתַּאֲרִיךְ וְהַשְּׁאֵלָה רָצָה פִּי עֲשָׂרָה מַהֵר.",
            exampleNative = "Добавили אִינְדֶּקְס на поле даты — и запрос побежал в десять раз быстрее.",
         fillInBlankExclusions = listOf(174711L, 174713L, 174714L, 174715L)),
        WordEntity(
            id = 174713, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_database", transliteration = "she'ilta",
            original = "שְׁאִילְתָּה", translation = "запрос (query)",
            definition = "פְּקוּדָה שֶׁמַּגִּיעָה לַמָּסַד וּמְבַקֶּשֶׁת לִקְרֹא אוֹ לְשַׁנּוֹת רְשׁוּמוֹת.",
            definitionNative = "Команда к базе — попросить прочитать или изменить записи.",
            example = "הַשְּׁאִילְתָּה הַזֹּאת שׁוֹלֶפֶת אֶת כָּל הַלָּקוֹחוֹת מֵהַשָּׁבוּעַ הַשּׁוֹעֵב.",
            exampleNative = "Эта שְׁאִילְתָּה вытаскивает всех клиентов с прошлой недели.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174714, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_database", transliteration = "migratsya",
            original = "מִיגְרַצְיָה", translation = "миграция (схемы)",
            definition = "סְקְרִיפְּט שֶׁמְּשַׁנֶּה אֶת הַמָּסַד מִגִּרְסָה אַחַת לַחֲדָשָׁה בְּלִי לְאַבֵּד נְתוּנִים.",
            definitionNative = "Скрипт, переводящий базу с одной версии на новую — без потери данных.",
            example = "הַמִּיגְרַצְיָה הָאַחֲרוֹנָה הוֹסִיפָה שָׂדֶה לַזֶּהוּת בִּשְׁלוֹשׁ טַבְלָאוֹת.",
            exampleNative = "Последняя מִיגְרַצְיָה добавила поле для идентификации в трёх таблицах.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174715, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_database", transliteration = "replikatsya",
            original = "רֶפְּלִיקַצְיָה", translation = "репликация (БД)",
            definition = "הַעְתָּקָה אוֹטוֹמָטִית שֶׁל נְתוּנִים מִשָּׂרָת רָאשִׁי לְשָׂרָתִים מִשְׁנִיִּים.",
            definitionNative = "Автоматическое копирование данных с главного сервера на дополнительные.",
            example = "רֶפְּלִיקַצְיָה הִצִּילָה אוֹתָנוּ כְּשֶׁהַשָּׂרָת הָרִאשִׁי קָרַס בָּלַיְלָה.",
            exampleNative = "רֶפְּלִיקַצְיָה спасла нас, когда главный сервер упал ночью.",
         fillInBlankExclusions = listOf(174711L, 174712L, 174713L, 174714L)),

        // ── hightech_cloud (5) — облачная инфраструктура ──
        WordEntity(
            id = 174716, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_cloud", transliteration = "sherut anan",
            original = "שֵׁירוּת עָנָן", translation = "облачный сервис",
            definition = "תַּחֲנַת חִישּׁוּב מְרֻחֶקֶת שֶׁמַּשְׂכִּירָה כֹּחַ וְזִכָּרוֹן לְפִי שִׂמּוּשׁ אֲמִיתִּי.",
            definitionNative = "Удалённая вычислительная станция — сдаёт мощность и память по реальному использованию.",
            example = "הַחֶבְרָה עָבְרָה מִשָּׂרָתִים פְרָטִיִּים לְשֵׁירוּת עָנָן זוֹל יוֹתֵר.",
            exampleNative = "Фирма перешла с приватных серверов на дешёвый שֵׁירוּת עָנָן.",
         fillInBlankExclusions = listOf(174717L, 174718L, 174719L, 174720L)),
        WordEntity(
            id = 174717, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_cloud", transliteration = "konteyner",
            original = "קוֹנְטֵיינֶר", translation = "контейнер",
            definition = "אֲרִיזָה קַלָּה שֶׁכּוֹלֶלֶת תּוֹכְנָה וְאֶת כָּל מָה שֶׁצְּרִיכָה לִרְאֹץ בְּכָל מָקוֹם.",
            definitionNative = "Лёгкая упаковка с программой и всем, что ей нужно — запускается где угодно.",
            example = "כָּל מִיקְרוֹסֶרְוִיס יוֹשֵׁב בְּקוֹנְטֵיינֶר נִפְרָד עִם הַסְּפָרִיּוֹת שֶׁלּוֹ.",
            exampleNative = "Каждый микросервис сидит в отдельном קוֹנְטֵיינֶר со своими библиотеками.",
         fillInBlankExclusions = listOf(174716L, 174718L, 174719L, 174720L)),
        WordEntity(
            id = 174718, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_cloud", transliteration = "orkestratsya",
            original = "אוֹרְקֶסְטְרַצְיָה", translation = "оркестрация",
            definition = "תֵּאוּם אוֹטוֹמָטִי שֶׁל הַרְבֵּה קוֹנְטֵיינֶרִים — מִי קָם, מִי נָפַל וּמִי מְקַבֵּל תְּנוּעָה.",
            definitionNative = "Автокоординация многих контейнеров — кто стартовал, кто упал и кто получает трафик.",
            example = "כּוּבֶּרְנֵטֶס הוּא הַכְּלִי הָרָאשִׁי לְאוֹרְקֶסְטְרַצְיָה הַיּוֹם.",
            exampleNative = "Kubernetes — главный инструмент для אוֹרְקֶסְטְרַצְיָה сегодня.",
         fillInBlankExclusions = listOf(174716L, 174717L, 174719L, 174720L)),
        WordEntity(
            id = 174719, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_cloud", transliteration = "skeyling",
            original = "סְקֵיילִינְג", translation = "масштабирование (scaling)",
            definition = "הוֹסָפָה אוֹטוֹמָטִית שֶׁל מַשְׁאַבִּים כְּשֶׁיֵשׁ הַרְבֵּה תְּנוּעָה — וְהוֹרָדָה כְּשֶׁשֶּׁקֶט.",
            definitionNative = "Автодобавление ресурсов при росте трафика и снятие — когда тихо.",
            example = "סְקֵיילִינְג אוֹטוֹמָטִי הָצִיל אֶת הָאַתָר בְּסוֹף שָׁבוּעַ שֶׁל מִבְצַע.",
            exampleNative = "Автоматический סְקֵיילִינְג спас сайт в выходные распродажи.",
         fillInBlankExclusions = listOf(174716L, 174717L, 174718L, 174720L)),
        WordEntity(
            id = 174720, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_cloud", transliteration = "regyon",
            original = "רֶגְיוֹן", translation = "регион (облачный)",
            definition = "אֵזוֹר גֵּאוֹגְרָפִי שֶׁבּוֹ סַפָּק הָעָנָן מַחֲזִיק חַוָּת שָׂרָתִים פִיסִית.",
            definitionNative = "Географическая зона, в которой облачный провайдер физически держит дата-центр.",
            example = "בָּחַרְנוּ רֶגְיוֹן בְּפְרַנְקְפוּרְט כְּדֵי שֶׁהַחֻקִּים הָאֵירוֹפִּיִּים יָחוּלוּ.",
            exampleNative = "Мы выбрали רֶגְיוֹן во Франкфурте, чтобы попасть под европейские законы.",
         fillInBlankExclusions = listOf(174716L, 174717L, 174718L, 174719L)),

        // ── hightech_arch_patterns (5) — архитектурные паттерны ──
        WordEntity(
            id = 174721, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_arch_patterns", transliteration = "maykroservis",
            original = "מַיקְרוֹסֶרְוִיס", translation = "микросервис",
            definition = "שֵׁרוּת קָטָן וְעַצְמָאִי שֶׁאַחְרַאי עַל יְכוֹלֶת אַחַת בִּלְבַד וּמְדַבֵּר עִם אֲחֵרִים.",
            definitionNative = "Маленький независимый сервис — отвечает за одну задачу и общается с другими.",
            example = "פֵּירַקְנוּ אֶת הַמּוֹנוֹלִית הַיָּשָׁן לִשְׁמוֹנָה שֶׁל מַיקְרוֹסֶרְוִיס נִפְרָדִים.",
            exampleNative = "Мы разбили старый монолит на восемь отдельных מַיקְרוֹסֶרְוִיס.",
         fillInBlankExclusions = listOf(174722L, 174723L, 174724L, 174725L)),
        WordEntity(
            id = 174722, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_arch_patterns", transliteration = "monolit",
            original = "מוֹנוֹלִית", translation = "монолит",
            definition = "אַפְּלִיקַצְיָה גְּדוֹלָה אַחַת שֶׁכָּל הַחֲלָקִים שֶׁלָּהּ אֲרוּזִים יַחַד וְעוֹלִים בִּפְעֻלָּה אַחַת.",
            definitionNative = "Одно большое приложение — все его части упакованы вместе и поднимаются одной командой.",
            example = "מוֹנוֹלִית קַל לְהָקִים בַּהַתְחָלָה אֲבָל קָשֶׁה לְתַחֲזֵק עִם הַזְּמַן.",
            exampleNative = "מוֹנוֹלִית легко поднять в начале — но трудно поддерживать со временем.",
         fillInBlankExclusions = listOf(174721L, 174723L, 174724L, 174725L)),
        WordEntity(
            id = 174723, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_arch_patterns", transliteration = "ivent sorsing",
            original = "אִיוֶנְט סוֹרְסִינְג", translation = "event sourcing",
            definition = "גִּישָׁה שֶׁשּׁוֹמֶרֶת כָּל פְּעֻלָּה כְּאֵירוּעַ נִפְרָד וּבוֹנָה אֶת הַמַּצָּב מֵהֶם בַּסּוֹף.",
            definitionNative = "Подход — каждое действие сохраняют как отдельное событие, и из них собирают итоговое состояние.",
            example = "אִיוֶנְט סוֹרְסִינְג מֻשְׁלָם לְמַעֲרָכוֹת בַּנְקָאִיּוֹת בִּגְלַל נַתִיב הַבְּדִיקָה הַמָּלֵא.",
            exampleNative = "אִיוֶנְט סוֹרְסִינְג идеально для банков — благодаря полному audit-следу.",
         fillInBlankExclusions = listOf(174721L, 174722L, 174724L, 174725L)),
        WordEntity(
            id = 174724, setId = 1747, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_arch_patterns", transliteration = "shikhvat kesh",
            original = "שִׁכְבַת קֵישׁ", translation = "кэш-слой",
            definition = "אֵזוֹר זְמַנִּי בְּזִכָּרוֹן מָהִיר שֶׁשּׁוֹמֵר תְּשׁוּבוֹת תְּכוּפוֹת כְּדֵי לֹא לִדְרֹשׁ אוֹתָן שׁוּב.",
            definitionNative = "Временная зона в быстрой памяти — хранит частые ответы, чтобы не запрашивать заново.",
            example = "שִׁכְבַת קֵישׁ מוּל הַמָּסַד הוֹרִידָה אֶת זְמַן הַתְּגוּבָה לְעֶשֶׂר אֲלָפִית הַשָּׁנִיָּה.",
            exampleNative = "שִׁכְבַת קֵישׁ перед базой опустила время отклика до десяти миллисекунд.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174725, setId = 1747, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_arch_patterns", transliteration = "loud balanser",
            original = "לוֹאוּד בָּלַנְסֶר", translation = "балансировщик нагрузки",
            definition = "רְכִיב שֶׁמְּחַלֵּק בַּקָּשׁוֹת נִכְנָסוֹת בֵּין מַסְפַּר שָׂרָתִים כְּדֵי שֶׁאַף אֶחָד לֹא יִקְרֹס.",
            definitionNative = "Компонент, делящий входящие запросы между несколькими серверами — чтобы никто не упал.",
            example = "הוֹסַפְנוּ לוֹאוּד בָּלַנְסֶר מוּל שִׁשָּׁה שָׂרָתִים בִּשְׁעוֹת הַשִּׂיא.",
            exampleNative = "Мы поставили לוֹאוּד בָּלַנְסֶר перед шестью серверами в часы пик.",
         fillInBlankExclusions = listOf(174721L, 174722L, 174723L, 174724L)),
    )
}
