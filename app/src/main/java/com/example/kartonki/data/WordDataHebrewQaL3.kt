package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "QA и тестирование", L3 «Углублённый» (RARE+EPIC).
 *
 * Set 1762: «QA и тестирование» — углублённый L3:
 *           Автоматизация и нагрузочное: фреймворки, perf, API-тесты, CI.
 *
 * Тема ориентирована на QA-инженера или SDET, изучающего иврит для работы
 * в израильском хайтеке. В реальной речи израильских QA-команд лексика
 * почти полностью английская — Selenium, Playwright, Cypress, Postman,
 * load test, flaky test, code coverage. Никудим выставлены на ивритские
 * прочтения английских терминов.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC. RARE — часто звучащая
 * лексика автоматизации (Selenium, Postman, load test, code coverage).
 * EPIC — продвинутые практики (chaos, mutation, contract, accessibility).
 *
 * SemanticGroups (5 × 5):
 *   qa_automation — UI-автоматизация: Selenium, Playwright, Cypress, Cucumber, Page Object
 *   qa_perf       — нагрузочное: load, stress, soak, spike, benchmark
 *   qa_api        — API-тесты: REST testing, Postman, contract, mock server, schema validation
 *   qa_ci         — CI: integration, parallel runs, flaky test, test report, code coverage
 *   qa_advanced   — продвинутые виды: chaos, mutation, security, accessibility, visual regression
 *
 * Word IDs: setId × 100 + position (176201..176225).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewQaL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1762, languagePair = "he-ru", orderIndex = 1762,
            name = "QA и тестирование",
            description = "Автоматизация и нагрузочное: фреймворки, perf, API-тесты, CI",
            topic = "QA и тестирование", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1762 — QA и тестирование: углублённый (L3, RARE+EPIC)
        // 5 групп × 5 слов: automation, perf, api, ci, advanced
        // ══════════════════════════════════════════════════════════════════════

        // ── qa_automation (5) — UI-автоматизация ──
        WordEntity(
            id = 176201, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_automation", transliteration = "selenyum",
            original = "סֵלֵנְיוּם", translation = "Selenium",
            definition = "כְּלִי וָתִיק שֶׁמְּדַמֶּה לְחִיצוֹת וַהֲקְלָדוֹת בְּדַפְדְּפָן לְבְדִיקוֹת אוֹטוֹמָטִיּוֹת.",
            definitionNative = "Старый инструмент — имитирует клики и набор в браузере для автотестов.",
            example = "כָּתַבְנוּ אֶת בְּדִיקוֹת הַצֶּ׳קְאַאוּט הָרִאשׁוֹנוֹת בְּסֵלֵנְיוּם לִפְנֵי שָׁנִים.",
            exampleNative = "Первые тесты чекаута мы написали на סֵלֵנְיוּם много лет назад.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176202, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_automation", transliteration = "pleyvreyt",
            original = "פְּלֵייוֵוייט", translation = "Playwright",
            definition = "כְּלִי מוֹדֶרְנִי לִבְדִיקוֹת דַּפְדְּפָן עִם הַמְתָּנָה חֲכָמָה לַפַעֻלָּה הַבָּאָה.",
            definitionNative = "Современный инструмент для браузерных тестов — умно ждёт следующего действия.",
            example = "עָבַרְנוּ לִפְּלֵייוֵוייט וְהַבְּדִיקוֹת הִפְסִיקוּ לִתְקֹעַ עַל אֲנִימַצְיוֹת.",
            exampleNative = "Перешли на פְּלֵייוֵוייט — и тесты перестали зависать на анимациях.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176203, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_automation", transliteration = "sayfres",
            original = "סָיְיפְּרֶס", translation = "Cypress",
            definition = "כְּלִי בְּדִיקוֹת שֶׁרָץ בְּתוֹךְ הַדַּפְדְּפָן עַצְמוֹ וּמַרְאֶה בִּזְמַן אֲמִתִּי כָּל שָׁלָב.",
            definitionNative = "Тестовый инструмент, работающий внутри самого браузера — показывает каждый шаг вживую.",
            example = "סָיְיפְּרֶס נָתַן לָנוּ דִּיבָּאג חָזוּתִי שֶׁל כָּל בְּדִיקָה שֶׁנָּפְלָה.",
            exampleNative = "סָיְיפְּרֶס дал нам визуальный дебаг каждого упавшего теста.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176204, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_automation", transliteration = "kyukamber",
            original = "קְיוּקַמְבֶּר", translation = "Cucumber (BDD-фреймворк)",
            definition = "מַעֲרֶכֶת שֶׁמְּתַרְגֶּמֶת תֵּאוּר תַּסְרִיט בִּשְׂפָה אֱנוֹשִׁית לִבְדִיקוֹת מְבַצְעוֹת.",
            definitionNative = "Система — переводит сценарий, написанный человеческим языком, в исполняемые проверки.",
            example = "מְנַהֲלֵי הַמּוּצָר כּוֹתְבִים תַּסְרִיטֵי קְיוּקַמְבֶּר וְהַמְפַתְּחִים מְמַמְּשִׁים.",
            exampleNative = "Продакты пишут сценарии קְיוּקַמְבֶּר, а разработчики их реализуют.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176205, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_automation", transliteration = "peyj o-bjekt",
            original = "פֵּייג׳ אוֹבְּגֶ׳קְט", translation = "page object (паттерн)",
            definition = "תַּבְנִית שֶׁעוֹטֶפֶת כָּל מָסָךְ בְּמַחְלָקָה אַחַת — קוֹד הַבְּדִיקוֹת לֹא נוֹגֵעַ בְּסֵלֶקְטוֹרִים.",
            definitionNative = "Шаблон — оборачивает каждый экран в один класс; код тестов не трогает селекторы.",
            example = "פֵּייג׳ אוֹבְּגֶ׳קְט מְסֻדָּר חָסַךְ לָנוּ שָׁבוּעַ עֲבוֹדָה בְּכָל שִׁפּוּץ עִצּוּב.",
            exampleNative = "Аккуратный פֵּייג׳ אוֹבְּגֶ׳קְט экономил нам неделю работы при каждом редизайне.",
            isFillInBlankSafe = false,
        ),

        // ── qa_perf (5) — нагрузочное тестирование ──
        WordEntity(
            id = 176206, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_perf", transliteration = "load test",
            original = "לוֹאד טֶסְט", translation = "load test (нагрузочный)",
            definition = "בְּדִיקָה שֶׁמַּעֲמִיסָה עַל הַמַּעֲרֶכֶת תְּנוּעָה צְפוּיָה כְּדֵי לִרְאוֹת אִם הִיא עוֹמֶדֶת.",
            definitionNative = "Проверка — даёт системе ожидаемый трафик и смотрит, выдержит ли она.",
            example = "הַלוֹאד טֶסְט הִרְאָה שֶׁהָאַתָר מַחֲזִיק חָמֵשׁ אֲלָפִים מִשְׁתַּמְּשִׁים בְּמַקְבִּיל.",
            exampleNative = "לוֹאד טֶסְט показал, что сайт держит пять тысяч пользователей одновременно.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176207, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_perf", transliteration = "stres test",
            original = "סְטְרֶס טֶסְט", translation = "stress test (на пределе)",
            definition = "בְּדִיקָה שֶׁדּוֹחֶפֶת אֶת הַמַּעֲרֶכֶת מֵעֵבֶר לַגְּבוּל כְּדֵי לִרְאוֹת אֵיךְ הִיא נִשְׁבֶּרֶת.",
            definitionNative = "Проверка — толкает систему за предел, чтобы понять, как именно она ломается.",
            example = "סְטְרֶס טֶסְט גִּלָּה דְּלִיפַת זִכָּרוֹן שֶׁהַסְּתִירָה אֶת עַצְמָהּ בִּתְנָאֵי שִׂיא.",
            exampleNative = "סְטְרֶס טֶסְט вскрыл утечку памяти, которая пряталась под пиковой нагрузкой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176208, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_perf", transliteration = "souk test",
            original = "סוֹאוּק טֶסְט", translation = "soak test (длительный)",
            definition = "הַעֲמָסָה רְצוּפָה לְשָׁעוֹת אוֹ יָמִים שֶׁבּוֹדֶקֶת אִם בְּעָיוֹת מִצְטַבְּרוֹת לְאַט.",
            definitionNative = "Долгая нагрузка на часы или дни — проверяет, копятся ли проблемы постепенно.",
            example = "סוֹאוּק טֶסְט שֶׁל יוֹמַיִם חָשַׂף שֶׁהַזִּכָּרוֹן זָחַל לְמַעְלָה כָּל שָׁעָה.",
            exampleNative = "Двухдневный סוֹאוּק טֶסְט вскрыл, что память ползла вверх каждый час.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176209, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_perf", transliteration = "spayk test",
            original = "סְפַּייק טֶסְט", translation = "spike test (резкий всплеск)",
            definition = "קְפִיצָה פִּתְאוֹמִית בִּתְנוּעָה כְּדֵי לִרְאוֹת אִם הַשָּׂרָתִים מִתְאוֹשְׁשִׁים מַהֵר.",
            definitionNative = "Резкий всплеск трафика — проверяет, как быстро серверы возвращаются в норму.",
            example = "סְפַּייק טֶסְט הוֹכִיחַ שֶׁהַסְּקֵיילִינְג הַאוֹטוֹמָטִי לֹא מַסְפִּיק מַהֵר.",
            exampleNative = "סְפַּייק טֶסְט доказал, что автоскейлинг недостаточно быстр.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176210, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_perf", transliteration = "benchmark",
            original = "בֶּנְצ׳מַארְק", translation = "бенчмарк (эталонный замер)",
            definition = "מְדִידָה אֲחִידָה שֶׁל בִּצּוּעִים שֶׁמַּשְׁוָה גִּרְסָאוֹת אוֹ פִּתְרוֹנוֹת זֶה לְזֶה.",
            definitionNative = "Стандартный замер производительности — сравнивает версии или решения между собой.",
            example = "הַבֶּנְצ׳מַארְק הִרְאָה שֶׁהַגִּרְסָה הַחֲדָשָׁה מַהִירָה פִּי שְׁתַּיִם מֵהַיְּשָׁנָה.",
            exampleNative = "בֶּנְצ׳מַארְק показал, что новая версия в два раза быстрее старой.",
            isFillInBlankSafe = false,
        ),

        // ── qa_api (5) — API-тесты ──
        WordEntity(
            id = 176211, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_api", transliteration = "testey rest",
            original = "טֶסְטֵי רֶסְט", translation = "REST testing (тестирование REST)",
            definition = "סִדְרָה שֶׁשּׁוֹלַחַת בַּקָּשׁוֹת לְשָׂרָת וּמוֹדֶדֶת אִם הַתְּשׁוּבָה תּוֹאֶמֶת לַצָּפוּי.",
            definitionNative = "Серия — посылает запросы серверу и сверяет, совпадает ли ответ с ожидаемым.",
            example = "טֶסְטֵי רֶסְט קְצָרִים תּוֹפְסִים רֶגְרֶסְיוֹת לִפְנֵי שֶׁהַמְפַתֵּחַ שׁוֹלֵחַ קוֹד.",
            exampleNative = "Короткие טֶסְטֵי רֶסְט ловят регрессии до того, как разработчик отправит код.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176212, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_api", transliteration = "postman",
            original = "פּוֹסְטְמַן", translation = "Postman",
            definition = "כְּלִי גְּרָפִי לִשְׁלִיחַת בַּקָּשׁוֹת יְדָנִיּוֹת וְלִשְׁמִירַת אוֹסְפֵי קְרִיאוֹת לִקְבוּצוֹת.",
            definitionNative = "Графический инструмент — посылает запросы вручную и хранит коллекции вызовов для команд.",
            example = "אוֹסֵף פּוֹסְטְמַן מְשֻׁתָּף מַעֲבִיר מָהֵר יְדִיעוֹת בֵּין מְפַתְּחִים לְבוֹחֲנִים.",
            exampleNative = "Общая коллекция פּוֹסְטְמַן быстро передаёт знания между разработчиками и тестировщиками.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176213, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_api", transliteration = "kontrakt test",
            original = "קוֹנְטְרַקְט טֶסְט", translation = "contract test (контрактный)",
            definition = "בְּדִיקָה שֶׁמְּוַדֵּאת שֶׁשְּׁנֵי שֵׁרוּתִים מַסְכִּימִים עַל פוֹרְמָט הַהוֹדָעוֹת בֵּינֵיהֶם.",
            definitionNative = "Проверка — следит, чтобы два сервиса согласовывали формат сообщений между собой.",
            example = "קוֹנְטְרַקְט טֶסְט מָנַע מֵהַצַּד שֶׁל הַתַּשְׁלוּמִים לִשְׁבֹּר שִׁירוּת הַהַזְמָנוֹת.",
            exampleNative = "קוֹנְטְרַקְט טֶסְט не дал команде платежей сломать сервис заказов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176214, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_api", transliteration = "mok server",
            original = "מוֹק סֶרְוֶור", translation = "mock server (заглушка)",
            definition = "שָׂרָת מְדֻמֶּה שֶׁמַּחְזִיר תְּשׁוּבוֹת מוּכָנוֹת בִּמְקוֹם הַמַּעֲרֶכֶת הָאֲמִתִּית.",
            definitionNative = "Поддельный сервер — отдаёт заранее заготовленные ответы вместо настоящей системы.",
            example = "הָרַמְנוּ מוֹק סֶרְוֶור כְּשֶׁשִּׁירוּת הַחִיוּב הָיָה לְמַטָּה לְתַחֲזוּקָה.",
            exampleNative = "Мы подняли מוֹק סֶרְוֶור, пока биллинг был на профилактике.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176215, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_api", transliteration = "imut skhema",
            original = "אִימוּת סְכֵמָה", translation = "schema validation (проверка схемы)",
            definition = "בְּדִיקָה שֶׁכָּל שָׂדֶה בִּתְשׁוּבָה תּוֹאֶם לַסּוּג וְלַמִּבְנֶה שֶׁהֻגְדְּרוּ מֵרֹאשׁ.",
            definitionNative = "Проверка — каждое поле в ответе соответствует заранее заданному типу и структуре.",
            example = "אִימוּת סְכֵמָה תָּפַס אֶת הַשָּׂדֶה הֶחָסֵר רֶגַע לִפְנֵי הָעֲלִיָּה לִיצוּר.",
            exampleNative = "אִימוּת סְכֵמָה поймал пропавшее поле за миг до выкладки в прод.",
            isFillInBlankSafe = false,
        ),

        // ── qa_ci (5) — CI / интеграция ──
        WordEntity(
            id = 176216, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_ci", transliteration = "shiluv si-ai",
            original = "שִׁילּוּב סִי-אַיי", translation = "CI integration (встраивание в CI)",
            definition = "חִבּוּר הַבְּדִיקוֹת לְצִינּוֹר הַבְּנִיָּה כְּדֵי שֶׁיָּרוּצוּ אַחֲרֵי כָּל שִׁנּוּי קוֹד.",
            definitionNative = "Подключение тестов к сборочному конвейеру — чтобы они шли после каждого изменения кода.",
            example = "שִׁילּוּב סִי-אַיי טוֹב חוֹסֵם פּוּל רִיקְוֵוסְט שֶׁשּׁוֹבֵר בְּדִיקָה.",
            exampleNative = "Хороший שִׁילּוּב סִי-אַיי блокирует пулреквест, который ломает тест.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176217, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_ci", transliteration = "ritsa makbila",
            original = "רִיצָה מַקְבִּילָה", translation = "parallel runs (параллельные прогоны)",
            definition = "חֲלוּקַת חֲבִילוֹת בְּדִיקוֹת בֵּין מְכוֹנוֹת רַבּוֹת כְּדֵי לְקַצֵּר אֶת זְמַן הַסָּבָב.",
            definitionNative = "Деление пакетов тестов между многими машинами — чтобы сократить общее время прогона.",
            example = "רִיצָה מַקְבִּילָה קִצְּרָה אֶת הַסָּבָב מִשָּׁעָה לְשֶׁבַע דַּקּוֹת.",
            exampleNative = "רִיצָה מַקְבִּילָה сократила прогон с часа до семи минут.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176218, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_ci", transliteration = "fleyki test",
            original = "פְלֵייקִי טֶסְט", translation = "flaky test (нестабильный)",
            definition = "בְּדִיקָה שֶׁפַּעַם עוֹבֶרֶת וּפַעַם נוֹפֶלֶת בְּלִי שֶׁהַקּוֹד הִשְׁתַּנָּה.",
            definitionNative = "Тест, который то проходит, то падает — без всяких изменений в коде.",
            example = "פְלֵייקִי טֶסְט שׁוֹחֵק אֶת הָאֵמוּן שֶׁל הַצֶּוֶות בְּמַעֲרֶכֶת הַבְּדִיקוֹת.",
            exampleNative = "פְלֵייקִי טֶסְט размывает доверие команды ко всей тестовой системе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176219, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_ci", transliteration = "doch testim",
            original = "דּוּ\"חַ טֶסְטִים", translation = "test report (отчёт)",
            definition = "סִכּוּם תּוֹצָאוֹת אַחֲרֵי הָרָצָה — מָה עָבַר, מָה נָפַל וְכַמָּה זְמַן לָקַח.",
            definitionNative = "Сводка по итогам прогона — что прошло, что упало и сколько заняло времени.",
            example = "דּוּ\"חַ טֶסְטִים יוֹמִי נִשְׁלָח לַמְנַהֵל עִם קִשּׁוּרִים לְלוֹגִים.",
            exampleNative = "Дневной דּוּ\"חַ טֶסְטִים отправляется менеджеру со ссылками на логи.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176220, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_ci", transliteration = "kavridj",
            original = "קַאוֵורִידְ׳ג׳", translation = "code coverage (покрытие кода)",
            definition = "אָחוּז שׁוּרוֹת הַקּוֹד שֶׁעָבְרוּ דֶּרֶךְ בְּדִיקוֹת אוֹטוֹמָטִיּוֹת בָּרָצָה אַחַת.",
            definitionNative = "Доля строк кода, которые прошли через автотесты за один прогон.",
            example = "קַאוֵורִידְ׳ג׳ נָפַל לְשִׁבְעִים אָחוּז וְהַחֲסִימָה הִתְנַשְּׁפָה אוֹטוֹמָטִית.",
            exampleNative = "קַאוֵורִידְ׳ג׳ упал до семидесяти процентов — и блокировка сработала автоматически.",
            isFillInBlankSafe = false,
        ),

        // ── qa_advanced (5) — продвинутые виды тестирования ──
        WordEntity(
            id = 176221, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_advanced", transliteration = "handasat kha-os",
            original = "הַנְדָּסַת כָאוֹס", translation = "chaos engineering",
            definition = "גִּישָׁה שֶׁמְּפִילָה רְכִיבִים בִּכְוָנָה בִּסְבִיבַת יְצוּר כְּדֵי לִבְדֹּק חֳסֶן.",
            definitionNative = "Подход — намеренно роняет компоненты в проде, чтобы проверить устойчивость.",
            example = "הַנְדָּסַת כָאוֹס חָשְׂפָה תְּלוּת חֲבוּיָה בֵּין הַחִפּוּשׂ לְתַשְׁלוּם.",
            exampleNative = "הַנְדָּסַת כָאוֹס вскрыла скрытую зависимость между поиском и оплатой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176222, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_advanced", transliteration = "myutey-shen testing",
            original = "מְיוּטֵיישֶׁן טֶסְטִינְג", translation = "mutation testing",
            definition = "טֶכְנִיקָה שֶׁמְּשַׁנָּה אֶת הַקּוֹד בִּזְעִירוּת וּבוֹדֶקֶת אִם הַבְּדִיקוֹת קוֹלְטוֹת אֶת הַשִּׁנּוּי.",
            definitionNative = "Техника — вносит микро-правки в код и смотрит, ловят ли тесты эти изменения.",
            example = "מְיוּטֵיישֶׁן טֶסְטִינְג חָשַׂף שֶׁשְּׁלִישׁ מֵהַבְּדִיקוֹת לֹא בָּדְקוּ כְּלוּם בֶּאֱמֶת.",
            exampleNative = "מְיוּטֵיישֶׁן טֶסְטִינְג вскрыл, что треть тестов на самом деле ничего не проверяли.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176223, setId = 1762, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_advanced", transliteration = "test avtakha",
            original = "טֶסְט אַבְטָחָה", translation = "security testing (проверка безопасности)",
            definition = "סְקִירָה שֶׁמְּחַפֶּשֶׂת חוֹרִים שֶׁתּוֹקֵף יָכוֹל לְנַצֵּל — הַזְרָקָה, גְּנֵיבַת מוֹשָׁב, הַרְשָׁאוֹת.",
            definitionNative = "Проверка — ищет дыры, которыми может воспользоваться атакующий: инъекции, кража сессий, права.",
            example = "טֶסְט אַבְטָחָה שְׁבוּעִי גִּלָּה הַזְרָקַת SQL בִּשְׂדֵה הַחִפּוּשׂ.",
            exampleNative = "Еженедельный טֶסְט אַבְטָחָה обнаружил SQL-инъекцию в поле поиска.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176224, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_advanced", transliteration = "bikoret negishut",
            original = "בִּקֹּרֶת נְגִישׁוּת", translation = "accessibility audit (аудит доступности)",
            definition = "סְרִיקָה שֶׁבּוֹדֶקֶת שֶׁאֲנָשִׁים עִם מֻגְבָּלוּת יְכוֹלִים לְהִשְׁתַּמֵּשׁ בָּאַתָר אוֹ בָּאַפְּלִיקַצְיָה.",
            definitionNative = "Проверка — могут ли люди с ограничениями пользоваться сайтом или приложением.",
            example = "בִּקֹּרֶת נְגִישׁוּת חָשַׂף שֶׁמְּקָרְאֵי מָסָךְ לֹא קָרְאוּ אֶת תָּפְרִיט הָרָאשִׁי.",
            exampleNative = "בִּקֹּרֶת נְגִישׁוּת вскрыл, что скринридеры не читали главное меню.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176225, setId = 1762, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_advanced", transliteration = "regresya khazutit",
            original = "רֶגְרֶסְיָה חֲזוּתִית", translation = "visual regression (визуальная регрессия)",
            definition = "הַשְׁוָאָה אוֹטוֹמָטִית שֶׁל צִילּוּמֵי מָסָךְ לִפְנֵי וְאַחֲרֵי שִׁנּוּי כְּדֵי לִתְפֹּס סְטִיּוֹת עִצּוּב.",
            definitionNative = "Автосравнение скриншотов до и после изменения — чтобы поймать смещения вёрстки.",
            example = "רֶגְרֶסְיָה חֲזוּתִית הַתְרִיעָה עַל כַּפְתּוֹר שֶׁזָּז שְׁתֵּי פִּיקְסְלִים יָמִינָה.",
            exampleNative = "רֶגְרֶסְיָה חֲזוּתִית предупредила о кнопке, которая сдвинулась на два пикселя вправо.",
            isFillInBlankSafe = false,
        ),
    )
}
