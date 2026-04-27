package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "QA и тестирование", L4 «Профессиональный» (EPIC+LEGENDARY).
 *
 * Set 1772: «QA и тестирование» — профессиональный L4:
 *           QA-инфраструктура: тестовые платформы, observability, mobile,
 *           security testing, quality engineering.
 *
 * Лексика — для senior-QA и SDET в израильском хайтеке. Большинство терминов
 * звучат по-английски в разговорной речи команд (BrowserStack, Sauce Labs,
 * Appium, Espresso, fuzzing, shift-left), но в формальных документах
 * и митингах появляются и ивритские формы (חַוַּת מַכְשִׁירִים, פְלָטְפוֹרְמַת
 * בְּדִיקוֹת, פִּירָמִידַת בְּדִיקוֹת, שַׁעֲרֵי אֵיכוּת).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY (спред 2 смежных).
 *
 * SemanticGroups (5 × 5):
 *   qa_platforms              — тестовые платформы: test platform, BrowserStack, Sauce Labs, in-house grid, parallel farm
 *   qa_observability          — observability QA: analytics, defect prediction, test impact, telemetry, dashboard
 *   qa_mobile                 — mobile testing: emulator, real device farm, Espresso, XCUITest, Appium
 *   qa_security               — security testing: DAST, SAST, IAST, fuzzing, app penetration test
 *   qa_quality_engineering    — quality engineering: QE, shift-left, test pyramid, DoD, quality gates
 *
 * Word IDs: setId × 100 + position (177201..177225).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewQaL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1772, languagePair = "he-ru", orderIndex = 1772,
            name = "QA и тестирование",
            description = "QA-инфраструктура: тестовые платформы, observability, mobile/security testing",
            topic = "QA и тестирование", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1772 — QA и тестирование: профессиональный (L4, EPIC+LEGENDARY)
        // 5 групп × 5 слов: platforms, observability, mobile, security, quality_engineering
        // ══════════════════════════════════════════════════════════════════════

        // ── qa_platforms (5) — тестовые платформы и облачные фермы ──
        WordEntity(
            id = 177201, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_platforms", transliteration = "platforma bdikot",
            original = "פְלָטְפוֹרְמַת בְּדִיקוֹת", translation = "тестовая платформа",
            definition = "מַעֲרֶכֶת אַחַת שֶׁמְּרַכֶּזֶת הַרָצָה, כְּלִים וְדוּחוֹת לְכָל סוּגֵי הַבְּדִיקוֹת בָּאִרְגּוּן.",
            definitionNative = "Единая система — собирает прогон, инструменты и отчёты для всех видов тестов в фирме.",
            example = "פְלָטְפוֹרְמַת בְּדִיקוֹת מֶרְכָּזִית הִחְלִיפָה לָנוּ שִׁבְעָה כְּלִים נְפְרָדִים.",
            exampleNative = "פְלָטְפוֹרְמַת בְּדִיקוֹת заменила нам семь разрозненных инструментов.",
         fillInBlankExclusions = listOf(177202L, 177203L, 177204L, 177205L)),
        WordEntity(
            id = 177202, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_platforms", transliteration = "brauzer-stak",
            original = "בְּרָאוּזֶר-סְטָק", translation = "BrowserStack",
            definition = "שֵׁרוּת עֲנָן שֶׁמַּרְשֶׁה לְהָרִיץ בְּדִיקוֹת עַל מֵאוֹת דַּפְדְּפָנִים אֲמִתִּיִּים מֵרָחוֹק.",
            definitionNative = "Облачный сервис — позволяет гонять проверки на сотнях настоящих браузеров удалённо.",
            example = "בְּרָאוּזֶר-סְטָק חָסַךְ לָנוּ אַחְזָקָה שֶׁל מַעְבָּדָה פִיזִית בַּמִּשְׂרָד.",
            exampleNative = "בְּרָאוּזֶר-סְטָק избавил нас от содержания физической лаборатории в офисе.",
         fillInBlankExclusions = listOf(177201L, 177203L, 177204L, 177205L, 177212L)),
        WordEntity(
            id = 177203, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_platforms", transliteration = "saus labs",
            original = "סָאוּס לַבְּס", translation = "Sauce Labs",
            definition = "סְפַּק עֲנָן וָתִיק לְבְדִיקוֹת מַקְבִּילוֹת שֶׁל אַתְרֵי וֵוב וְאַפְּלִיקַצְיוֹת מוֹבַיְיל.",
            definitionNative = "Старый облачный поставщик — параллельные проверки веб-сайтов и мобильных приложений.",
            example = "סָאוּס לַבְּס מַרְצֵב לָנוּ אַרְבַּע מֵאוֹת רִיצוֹת מַקְבִּילוֹת לְפֶחַד הָרַחַשׁ.",
            exampleNative = "סָאוּס לַבְּס крутит нам четыреста параллельных прогонов в часы пика.",
         fillInBlankExclusions = listOf(177201L, 177202L, 177204L, 177205L)),
        WordEntity(
            id = 177204, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_platforms", transliteration = "grid pnimi",
            original = "גְּרִיד פְּנִימִי", translation = "in-house grid (внутренний грид)",
            definition = "אֶשְׁכּוֹל שְׁרָתִים שֶׁל הַחֶבְרָה עַצְמָהּ — מְקַבֵּל מְשִׂימוֹת בְּדִיקָה וּמְחַלֵּק בֵּינֵיהֶן.",
            definitionNative = "Серверный кластер самой фирмы — принимает тестовые задания и распределяет между ними.",
            example = "גְּרִיד פְּנִימִי הָיָה זוֹל יוֹתֵר אֲבָל דָּרַשׁ צֶוֶות תַּחֲזוּקָה מָלֵא.",
            exampleNative = "גְּרִיד פְּנִימִי вышел дешевле, но потребовал отдельной команды поддержки.",
         fillInBlankExclusions = listOf(177201L, 177202L, 177203L, 177205L)),
        WordEntity(
            id = 177205, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_platforms", transliteration = "khavat ritsot makbilot",
            original = "חַוַּת רִיצוֹת מַקְבִּילוֹת", translation = "parallel execution farm (ферма параллельных прогонов)",
            definition = "מָאֲגָר מְכוֹנוֹת גָּדוֹל שֶׁמְּקַצֵּר סָבָב שֶׁל אֲלָפִים בְּדִיקוֹת לְדַקּוֹת בּוֹדְדוֹת.",
            definitionNative = "Большой пул машин — сокращает прогон тысяч проверок до считанных минут.",
            example = "חַוַּת רִיצוֹת מַקְבִּילוֹת חֲדָשָׁה הוֹרִידָה אֶת הַסָּבָב מִשָּׁעָתַיִם לְשָׁלוֹשׁ דַּקּוֹת.",
            exampleNative = "Новая חַוַּת רִיצוֹת מַקְבִּילוֹת уронила прогон с двух часов до трёх минут.",
         fillInBlankExclusions = listOf(177201L, 177202L, 177203L, 177204L)),

        // ── qa_observability (5) — наблюдаемость и аналитика тестов ──
        WordEntity(
            id = 177206, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_observability", transliteration = "analitika shel bdikot",
            original = "אָנָלִיטִיקַת בְּדִיקוֹת", translation = "test analytics (аналитика тестов)",
            definition = "אִסּוּף וְהַצָּגַת מַסְפָּרִים עַל מִי נוֹפֵל הֲכִי הַרְבֵּה, אֵיפֹה אִטִּי וְלָמָּה מֻרְכָּב.",
            definitionNative = "Сбор и показ цифр — кто падает чаще всех, где медленно и почему сложно.",
            example = "אָנָלִיטִיקַת בְּדִיקוֹת חָשְׂפָה שֶׁשְּׁלוֹשִׁים אָחוּז מֵהַסָּבָב מְבֻזְבָּז עַל זְלִיגוֹת.",
            exampleNative = "אָנָלִיטִיקַת בְּדִיקוֹת вскрыла, что треть прогона уходит впустую на флапы.",
         fillInBlankExclusions = listOf(177207L, 177208L, 177209L, 177210L)),
        WordEntity(
            id = 177207, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_observability", transliteration = "nibuy takalot",
            original = "נִבּוּי תְּקָלוֹת", translation = "defect prediction",
            definition = "מוֹדֶל שֶׁמַּחֲזֶה בְּאֵיזוֹ קְבָצִים סָבִיר שֶׁתִּפֹּל בְּעָיָה לִפְנֵי שֶׁהַסָּבָב בִּכְלָל יָרוּץ.",
            definitionNative = "Модель — прогноз, в каких файлах вероятна поломка, ещё до запуска прогона.",
            example = "נִבּוּי תְּקָלוֹת הִכְוִין אוֹתָנוּ לִשְׁלוֹשָׁה מוֹדוּלִים מְסֻכָּנִים לִפְנֵי הָרִילִיז.",
            exampleNative = "נִבּוּי תְּקָלוֹת направил нас на три рисковых модуля до релиза.",
         fillInBlankExclusions = listOf(177206L, 177208L, 177209L, 177210L)),
        WordEntity(
            id = 177208, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_observability", transliteration = "nituakh hashpaa",
            original = "נִתּוּחַ הַשְׁפָּעָה", translation = "test impact analysis",
            definition = "שִׁיטָה שֶׁבּוֹחֶרֶת רַק אֶת הַבְּדִיקוֹת הָרֶלֶוַונְטִיּוֹת לַשִּׁנּוּי הַזֶּה לְפִי תְּלוּת בַּקּוֹד.",
            definitionNative = "Метод — выбирает только проверки, которые касаются именно этой правки, по графу зависимостей.",
            example = "נִתּוּחַ הַשְׁפָּעָה צִמְצֵם אֶת סָבָב הַפּוּל רִיקְוֵוסְט בִּשְׁמוֹנִים אָחוּז.",
            exampleNative = "נִתּוּחַ הַשְׁפָּעָה урезал прогон на пулреквесте на восемьдесят процентов.",
         fillInBlankExclusions = listOf(177206L, 177207L, 177209L, 177210L)),
        WordEntity(
            id = 177209, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_observability", transliteration = "telemetria bibdikot",
            original = "טֶלֶמֶטְרִיָּה בִּבְדִיקוֹת", translation = "телеметрия в тестах",
            definition = "אִסּוּף נְקֻדּוֹת מְדִידָה מִכָּל שְׁלָב בָּרָצָה כְּדֵי לַחֲקֹר אַחַר כָּךְ אִטִּיּוּת אוֹ נְפִילָה.",
            definitionNative = "Сбор замеров с каждого шага прогона — чтобы потом расследовать тормоза или падение.",
            example = "טֶלֶמֶטְרִיָּה בִּבְדִיקוֹת הִצְבִּיעָה עַל קְרִיאַת רֶשֶׁת אַחַת שֶׁלָּקְחָה שָׁלוֹשׁ שְׁנִיּוֹת.",
            exampleNative = "טֶלֶמֶטְרִיָּה בִּבְדִיקוֹת указала на один сетевой запрос длиной в три секунды.",
         fillInBlankExclusions = listOf(177206L, 177207L, 177208L, 177210L)),
        WordEntity(
            id = 177210, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_observability", transliteration = "dashbord eikhut",
            original = "דַּשְׁבּוֹרְד אֵיכוּת", translation = "QA dashboard (дашборд качества)",
            definition = "מָסָךְ מְרֻכָּז שֶׁמַּצִּיג בִּזְמַן אֱמֶת אֵילוּ סָבָבִים הִצְלִיחוּ וְכַמָּה בָּאגִים פְּתוּחִים.",
            definitionNative = "Сводный экран — в реальном времени показывает прошедшие прогоны и открытые баги.",
            example = "דַּשְׁבּוֹרְד אֵיכוּת תָּלוּי בְּמִסְדְּרוֹן הַצֶּוֶות וּמִתְעַדְכֵּן כָּל חָמֵשׁ דַּקּוֹת.",
            exampleNative = "דַּשְׁבּוֹרְד אֵיכוּת висит в коридоре команды и обновляется каждые пять минут.",
         fillInBlankExclusions = listOf(177206L, 177207L, 177208L, 177209L)),

        // ── qa_mobile (5) — мобильное тестирование ──
        WordEntity(
            id = 177211, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_mobile", transliteration = "emulator",
            original = "אֶמוּלָטוֹר", translation = "эмулятор",
            definition = "תּוֹכְנָה שֶׁמְּחַקָּה מַכְשִׁיר נַיָּד עַל הַמַּחְשֵׁב — בְּלִי לְהַחֲזִיק טֵלֵפוֹן פִיזִי.",
            definitionNative = "Программа — имитирует мобильный девайс на компьютере, без физического телефона в руках.",
            example = "אֶמוּלָטוֹר אֶחָד עַל מַק חָסַךְ לָנוּ קְנִיַּת חֲמִשָּׁה דְּגָמִים שׁוֹנִים.",
            exampleNative = "אֶמוּלָטוֹר на маке избавил нас от закупки пяти разных моделей.",
         fillInBlankExclusions = listOf(177212L, 177213L, 177214L, 177215L)),
        WordEntity(
            id = 177212, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_mobile", transliteration = "khavat makhshirim",
            original = "חַוַּת מַכְשִׁירִים אֲמִתִּיִּים", translation = "real device farm (ферма реальных устройств)",
            definition = "מַעְבָּדָה עִם עֲשָׂרוֹת טֵלֵפוֹנִים פִיזִיִּים מְחֻבָּרִים לְשֶׁרֵת לְבְדִיקָה מֵרָחוֹק.",
            definitionNative = "Лаборатория с десятками физических телефонов — подключены к серверу для удалённой проверки.",
            example = "חַוַּת מַכְשִׁירִים אֲמִתִּיִּים תָּפְסָה בָּאג שֶׁלֹּא הִתְגַּלָּה עַל אֶמוּלָטוֹר אֶחָד.",
            exampleNative = "חַוַּת מַכְשִׁירִים אֲמִתִּיִּים поймала баг, которого ни один эмулятор не показывал.",
         fillInBlankExclusions = listOf(177213L, 177214L, 177215L)),
        WordEntity(
            id = 177213, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_mobile", transliteration = "espreso freymvork",
            original = "אֶסְפְּרֵסוֹ פְרֵיימוֹרְק", translation = "Espresso (Android UI testing)",
            definition = "סִפְרִיָּה רִשְׁמִית שֶׁל גוּגֶל לִבְדִיקַת מָסָכִים בְּאַנְדְרוֹאִיד עִם הַמְתָּנוֹת חֲכָמוֹת.",
            definitionNative = "Официальная библиотека Google — проверка экранов на Android с умными ожиданиями.",
            example = "אֶסְפְּרֵסוֹ פְרֵיימוֹרְק כָּתוּב בְּקוֹטְלִין וּמִשְׁתַּלֵּב בַּגְּרָדֵל בְּקַלּוּת.",
            exampleNative = "אֶסְפְּרֵסוֹ פְרֵיימוֹרְק написан на Kotlin и легко встаёт в Gradle.",
         fillInBlankExclusions = listOf(177211L, 177212L, 177214L, 177215L)),
        WordEntity(
            id = 177214, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_mobile", transliteration = "ekskyu-ai-test",
            original = "אֶקְסְקְיוּ-אַי-טֶסְט", translation = "XCUITest (iOS)",
            definition = "הַכְּלִי הָרִשְׁמִי שֶׁל אֶפֶּל לְבְדִיקוֹת מָמְשָׁק עַל אַיְיפוֹן וְאַיְיפַּד מִתּוֹךְ הַסְּבִיבָה שֶׁלָּהֶם.",
            definitionNative = "Официальный инструмент Apple — проверка интерфейса на iPhone и iPad из их же среды.",
            example = "אֶקְסְקְיוּ-אַי-טֶסְט מִשְׁתַּלֵּב יָשִׁיר בִּזְ׳קְסְקוֹד וְלֹא דּוֹרֵשׁ סְפְרִיָּה חִיצוֹנִית.",
            exampleNative = "אֶקְסְקְיוּ-אַי-טֶסְט встаёт прямо в Xcode и не требует внешней библиотеки.",
         fillInBlankExclusions = listOf(177211L, 177212L, 177213L, 177215L)),
        WordEntity(
            id = 177215, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_mobile", transliteration = "es-pi-i-am",
            original = "אֵס-פִּי-אִי-אַם", translation = "Appium",
            definition = "כְּלִי חוֹצֶה מַעֲרָכוֹת שֶׁמַּרִיץ אוֹתוֹ סְקְרִיפְט גַּם עַל אַנְדְרוֹאִיד וְגַם עַל אַיי-אוֹ-אֶס.",
            definitionNative = "Кросс-платформенный инструмент — гоняет один и тот же скрипт и на Android, и на iOS.",
            example = "אֵס-פִּי-אִי-אַם אִפְשֵׁר לָנוּ צֶוֶות אֶחָד בִּמְקוֹם שְׁנֵי צֶוֶותִים נִפְרָדִים.",
            exampleNative = "אֵס-פִּי-אִי-אַם позволил иметь одну команду вместо двух раздельных.",
         fillInBlankExclusions = listOf(177211L, 177212L, 177213L, 177214L)),

        // ── qa_security (5) — security testing ──
        WordEntity(
            id = 177216, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_security", transliteration = "dast",
            original = "דַּ\"סְט", translation = "DAST (динамический анализ безопасности)",
            definition = "סְרִיקָה שֶׁתּוֹקֶפֶת אֶת הַמַּעֲרֶכֶת רָצָה מִבַּחוּץ כְּדֵי לִמְצֹא חוּלְשׁוֹת בִּזְמַן אֱמֶת.",
            definitionNative = "Сканер — атакует работающую систему снаружи и ищет слабые места в реальном времени.",
            example = "דַּ\"סְט שְׁבוּעִי גִּלָּה הַזְרָקָה אֶפְשָׁרִית בְּטֹפֶס הַחִפּוּשׂ הַחָדָשׁ.",
            exampleNative = "Еженедельный דַּ\"סְט выявил возможную инъекцию в новой форме поиска.",
         fillInBlankExclusions = listOf(177217L, 177218L, 177219L, 177220L)),
        WordEntity(
            id = 177217, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_security", transliteration = "sast",
            original = "סַ\"סְט", translation = "SAST (статический анализ безопасности)",
            definition = "סְרִיקָה שֶׁקּוֹרֵאת אֶת הַקּוֹד עַצְמוֹ בְּלִי לְהָרִיץ אוֹתוֹ וּמַצִּיגָה דְּפוּסִים מְסֻכָּנִים.",
            definitionNative = "Сканер — читает сам код, не запуская его, и выделяет опасные шаблоны.",
            example = "סַ\"סְט תָּפַס שִׁמּוּשׁ בְּסִפְרִיָּה יְשָׁנָה עִם פִּרְצָה מֻכֶּרֶת.",
            exampleNative = "סַ\"סְט поймал использование старой библиотеки с известной дырой.",
         fillInBlankExclusions = listOf(177216L, 177218L, 177219L, 177220L)),
        WordEntity(
            id = 177218, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_security", transliteration = "ai-ast",
            original = "אַי-אַ\"סְט", translation = "IAST (интерактивный анализ безопасности)",
            definition = "גִּישָׁה מְשֻׁלֶּבֶת — רָצָה בְּתוֹךְ הַשֶּׁרֵת בִּזְמַן הַבְּדִיקוֹת וּמַצְבִּיעָה עַל קְרִיאוֹת מְסֻכָּנוֹת.",
            definitionNative = "Гибридный подход — крутится внутри сервера во время тестов и подсвечивает опасные вызовы.",
            example = "אַי-אַ\"סְט הִצְלִיחַ לְמַקֵּם פִּרְצָה בִּשְׁכָבוֹת עֲמֻקּוֹת שֶׁל הַ-API.",
            exampleNative = "אַי-אַ\"סְט сумел локализовать дыру в глубоких слоях API.",
         fillInBlankExclusions = listOf(177216L, 177217L, 177219L, 177220L)),
        WordEntity(
            id = 177219, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_security", transliteration = "fuzzing",
            original = "פַּזִּינְג", translation = "fuzzing (фаззинг)",
            definition = "טֶכְנִיקָה שֶׁמַּזְרִיקָה אַלְפֵי קְלָטִים אַקְרָאִיִּים כְּדֵי לִמְצֹא קְרִיסָה בִּלְתִּי צְפוּיָה בַּקּוֹד.",
            definitionNative = "Техника — заливает тысячи случайных входных данных, чтобы вызвать неожиданное падение кода.",
            example = "פַּזִּינְג עַל מְפָרֵשׁ הַקְּבָצִים הִפִּיל אוֹתוֹ אַחֲרֵי שָׁלֹשׁ דַּקּוֹת רִיצָה.",
            exampleNative = "פַּזִּינְג по парсеру файлов уронил его через три минуты прогона.",
         fillInBlankExclusions = listOf(177216L, 177217L, 177218L, 177220L)),
        WordEntity(
            id = 177220, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_security", transliteration = "pentest aplikativi",
            original = "פֶּנְטֶסְט אַפְּלִיקָטִיבִי", translation = "application penetration test (от QA-команды)",
            definition = "תַּקִּיפָה מְבֻקֶּרֶת שֶׁל בּוֹדֵק עַל הָאַפְּלִיקַצְיָה כְּאִלּוּ הוּא תּוֹקֵף אֲמִתִּי מִבַּחוּץ.",
            definitionNative = "Контролируемая атака тестировщика на приложение — будто настоящий злоумышленник снаружи.",
            example = "פֶּנְטֶסְט אַפְּלִיקָטִיבִי לִפְנֵי הַשִּׁחְרוּר חָשַׂף שָׁלוֹשׁ פִּרְצוֹת הַרְשָׁאָה.",
            exampleNative = "פֶּנְטֶסְט אַפְּלִיקָטִיבִי перед релизом вскрыл три дыры в правах.",
         fillInBlankExclusions = listOf(177216L, 177217L, 177218L, 177219L)),

        // ── qa_quality_engineering (5) — инженерия качества и подходы ──
        WordEntity(
            id = 177221, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_quality_engineering", transliteration = "handasat eikhut",
            original = "הַנְדָּסַת אֵיכוּת", translation = "quality engineering",
            definition = "גִּישָׁה שֶׁבָּהּ הָאֵיכוּת הִיא אַחֲרָיוּת שֶׁל כָּל הַצֶּוֶות, לֹא רַק שֶׁל הַבּוֹדְקִים.",
            definitionNative = "Подход — за качество отвечает вся команда, а не только тестировщики.",
            example = "מַעֲבָר לְהַנְדָּסַת אֵיכוּת דָּרַשׁ מֵהַמְפַתְּחִים לִכְתֹּב יוֹתֵר בְּדִיקוֹת בְּעַצְמָם.",
            exampleNative = "Переход на הַנְדָּסַת אֵיכוּת потребовал от разработчиков самим писать больше проверок.",
         fillInBlankExclusions = listOf(177222L, 177223L, 177224L, 177225L)),
        WordEntity(
            id = 177222, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_quality_engineering", transliteration = "shift-left",
            original = "שִׁיפְט-לֵפְט", translation = "shift-left testing",
            definition = "עִקָּרוֹן שֶׁמַּקְדִּים בְּדִיקוֹת לִשְׁלָבִים מֻקְדָּמִים שֶׁל הַתִּכְנוּן בִּמְקוֹם רַק לִפְנֵי שִׁחְרוּר.",
            definitionNative = "Принцип — двигать проверки на ранние стадии планирования, а не только перед релизом.",
            example = "שִׁיפְט-לֵפְט אִפְשֵׁר לָנוּ לִתְפֹּס בָּעֲיוֹת תִּכְנוּן עוֹד בְּדִיוּן הַסְפֶּק.",
            exampleNative = "שִׁיפְט-לֵפְט дал ловить проблемы дизайна ещё на обсуждении ТЗ.",
         fillInBlankExclusions = listOf(177221L, 177223L, 177224L, 177225L)),
        WordEntity(
            id = 177223, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_quality_engineering", transliteration = "piramidat bdikot",
            original = "פִּירָמִידַת בְּדִיקוֹת", translation = "test pyramid (пирамида тестов)",
            definition = "מוֹדֶל שֶׁבּוֹ רֹב הַבְּדִיקוֹת קְטַנּוֹת וּמְהִירוֹת, וּמְעַט בִּלְבַד אִטִּיּוֹת וְכוֹלְלוֹת.",
            definitionNative = "Модель — большинство проверок мелкие и быстрые, а медленных и сквозных немного.",
            example = "פִּירָמִידַת בְּדִיקוֹת אִידֵאָלִית מְשַׁמֶּרֶת אֶת הַסָּבָב מִתַּחַת לְעֶשֶׂר דַּקּוֹת.",
            exampleNative = "Идеальная פִּירָמִידַת בְּדִיקוֹת держит прогон ниже десяти минут.",
         fillInBlankExclusions = listOf(177221L, 177222L, 177224L, 177225L)),
        WordEntity(
            id = 177224, setId = 1772, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_quality_engineering", transliteration = "hagdarat siyum",
            original = "הַגְדָּרַת סִיּוּם", translation = "definition of done",
            definition = "רְשִׁימָה מוּסְכֶּמֶת שֶׁל תְּנָאִים שֶׁכָּל מְשִׂימָה צְרִיכָה לְקַיֵּם לִפְנֵי שֶׁהִיא נֶחְשֶׁבֶת מוּכְנָה.",
            definitionNative = "Согласованный список условий — каждая задача обязана выполнить их, чтобы считаться завершённой.",
            example = "הַגְדָּרַת סִיּוּם שֶׁלָּנוּ דּוֹרֶשֶׁת קוֹד רֵוויוּ, יוּנִיט וְעִדְכּוּן מִסְמָכִים.",
            exampleNative = "Наша הַגְדָּרַת סִיּוּם требует код-ревью, юнит и обновление документации.",
         fillInBlankExclusions = listOf(177221L, 177222L, 177223L, 177225L)),
        WordEntity(
            id = 177225, setId = 1772, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_quality_engineering", transliteration = "shaarey eikhut",
            original = "שַׁעֲרֵי אֵיכוּת", translation = "quality gates",
            definition = "סַפִּים אוֹטוֹמָטִיִּים בָּקּוֹ שֶׁלֹּא נוֹתְנִים לְקוֹד לְהִתְקַדֵּם אִם מַדָּד מְסֻיָּם נָפַל.",
            definitionNative = "Автоматические пороги в конвейере — не пускают код дальше, если упал какой-то показатель.",
            example = "שַׁעֲרֵי אֵיכוּת חָסְמוּ אֶת הַמִּיזּוּג כִּי הַכִּסּוּי יָרַד מִתַּחַת לִשְׁמוֹנִים אָחוּז.",
            exampleNative = "שַׁעֲרֵי אֵיכוּת заблокировали мерж — покрытие упало ниже восьмидесяти процентов.",
         fillInBlankExclusions = listOf(177221L, 177222L, 177223L, 177224L)),
    )
}
