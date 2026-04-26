package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "QA и тестирование" (контроль качества в израильском хайтеке).
 *
 * Set 1761: «QA и тестирование» — продвинутый L2 (UNCOMMON+RARE):
 *           ежедневная работа QA-инженера — типы тестов, жизненный цикл бага,
 *           ручное тестирование, тестовые среды, коммуникация с разработкой.
 *
 * Лексика смешанная: иврит + множество английских заимствований
 * (יוּנִיט טֶסְט, סְמוֹק טֶסְט, בָּאג רִיפּוֹרְט, סֵבֵרִיטִי, מוֹק) — так реально
 * говорят в израильских хайтек-компаниях.
 *
 * Распределение редкостей: 13 UNCOMMON + 12 RARE.
 *
 * SemanticGroups (5 × 5):
 *   qa_test_types       — типы тестов: unit, integration, e2e, smoke, sanity
 *   qa_bug_lifecycle    — жизненный цикл бага: репорт, severity, воспроизведение, верификация, закрытие
 *   qa_manual           — ручное тестирование: тест-план, тест-кейс, сценарий, чеклист, exploratory
 *   qa_environment      — тестовые среды и инфра: test env, sandbox, prod, test data, mock
 *   qa_communication    — коммуникация: acceptance criteria, retest, sign-off, regression suite, эскалация
 *
 * Word IDs: setId × 100 + position (176101..176125).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewQaL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1761, languagePair = "he-ru", orderIndex = 1761,
            name = "QA и тестирование",
            description = "Основы QA: типы тестов, баги, тест-планы, ручное тестирование",
            topic = "QA и тестирование", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1761 — QA и тестирование: продвинутый (L2, UNCOMMON+RARE)
        // 5 групп × 5 слов: test_types, bug_lifecycle, manual, environment, communication
        // ══════════════════════════════════════════════════════════════════════

        // ── qa_test_types (5) — типы автоматических тестов ──
        WordEntity(
            id = 176101, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_test_types", transliteration = "yunit test",
            original = "יוּנִיט טֶסְט", translation = "юнит-тест",
            definition = "בְּדִיקָה אוֹטוֹמָטִית קְצָרָה שֶׁל פּוּנְקְצְיָה אַחַת בִּלְבַד, בְּלִי תְּלוּת בְּכָל הַמַּעֲרֶכֶת.",
            definitionNative = "Короткая автопроверка одной функции — без зависимости от всей системы.",
            example = "כָּל מְפַתֵּחַ צָרִיךְ לִכְתֹּב יוּנִיט טֶסְט לְכָל פּוּנְקְצְיָה חֲדָשָׁה.",
            exampleNative = "Каждый разработчик должен писать יוּנִיט טֶסְט для любой новой функции.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176102, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_test_types", transliteration = "integratzia test",
            original = "אִינְטֶגְרַצְיָה טֶסְט", translation = "интеграционный тест",
            definition = "בְּדִיקָה שֶׁמְּוַדֵּאת שֶׁכַּמָּה רְכִיבִים נִפְרָדִים עוֹבְדִים נָכוֹן בְּיַחַד.",
            definitionNative = "Проверяет, что несколько отдельных компонентов корректно работают вместе.",
            example = "אִינְטֶגְרַצְיָה טֶסְט תָּפַס תַּקָּלָה בַּחִיבּוּר בֵּין הַשֵּׁרֵת לְמַסַּד הַנְּתוּנִים.",
            exampleNative = "אִינְטֶגְרַצְיָה טֶסְט поймал поломку связки сервера и базы данных.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176103, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_test_types", transliteration = "i-tu-i",
            original = "אִי-טוּ-אִי", translation = "e2e тест (end-to-end)",
            definition = "בְּדִיקָה שֶׁעוֹבֶרֶת עַל כָּל הַמַּסְלוּל שֶׁל הַמִּשְׁתַּמֵּשׁ — מֵהַכְּנִיסָה וְעַד הַתַּשְׁלוּם.",
            definitionNative = "Проверка всего пути пользователя — от входа до оплаты включительно.",
            example = "הַ-אִי-טוּ-אִי שֶׁל הַתַּשְׁלוּם נִכְשַׁל אַחֲרֵי הַשִּׁדְרוּג שֶׁל הַסְּפֵרָיָה.",
            exampleNative = "Платёжный אִי-טוּ-אִי упал после обновления библиотеки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176104, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_test_types", transliteration = "smok test",
            original = "סְמוֹק טֶסְט", translation = "смоук-тест",
            definition = "סִדְרָה זְרִיזָה שֶׁל בְּדִיקוֹת בְּסִיסִיּוֹת לִפְנֵי כָּל הַשְּׁאָר — שֶׁהַמַּעֲרֶכֶת בִּכְלָל עוֹלָה.",
            definitionNative = "Быстрый набор базовых проверок — стартует ли система вообще, до прочих тестов.",
            example = "אַחֲרֵי כָּל דֶּפְּלוֹי הַ-סְמוֹק טֶסְט רָץ אוֹטוֹמָטִית עַל הַסְּבִיבָה הַחֲדָשָׁה.",
            exampleNative = "После каждого выката סְמוֹק טֶסְט автоматически прогоняется по новой среде.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176105, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_test_types", transliteration = "saniti chek",
            original = "סָנִיטִי צֵ'ק", translation = "санити-чек",
            definition = "מַעֲבָר מָהִיר עַל הַתַּכְלִית הָעִיקָּרִית כְּדֵי לִרְאוֹת שֶׁשּׁוּם דָּבָר קְרִיטִי לֹא נִשְׁבַּר.",
            definitionNative = "Беглый прогон главной фичи — убедиться, что ничего критичного не сломалось.",
            example = "לִפְנֵי הַשִּׁחְרוּר עָשִׂינוּ סָנִיטִי צֵ'ק יְדָנִי עַל שְׁלוֹשָׁה דַּפֵּי הַמַּפְתֵּחַ.",
            exampleNative = "Перед релизом мы вручную делали סָנִיטִי צֵ'ק по трём ключевым страницам.",
            isFillInBlankSafe = false,
        ),

        // ── qa_bug_lifecycle (5) — жизненный цикл бага ──
        WordEntity(
            id = 176106, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_bug_lifecycle", transliteration = "bag riport",
            original = "בָּאג רִיפּוֹרְט", translation = "баг-репорт",
            definition = "מִסְמָךְ קָצָר שֶׁמַּגְדִּיר בְּדִיּוּק אֵיךְ הִתְגַּלְּתָה תַּקָּלָה וְאֵיךְ מְשַׁחְזְרִים אוֹתָהּ.",
            definitionNative = "Короткий документ — точно описывает, как обнаружили поломку и как её повторить.",
            example = "כָּתַבְתִּי בָּאג רִיפּוֹרְט מְסֻדָּר עִם וִידֵאוֹ קָצָר וְלוֹגִים שֶׁל הַדַּפְדְּפָן.",
            exampleNative = "Я составил аккуратный בָּאג רִיפּוֹרְט с коротким видео и логами браузера.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176107, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_bug_lifecycle", transliteration = "severiti",
            original = "סֵבֵרִיטִי", translation = "критичность бага (severity)",
            definition = "דַּרְגַּת הַחֻמְרָה שֶׁל הַתַּקָּלָה — מְעַצְבֶּנֶת קְטַנָּה אוֹ מַפִּילָה אֶת כָּל הַשֵּׁרוּת.",
            definitionNative = "Степень тяжести поломки — мелкая досада или падение всего сервиса.",
            example = "סֵבֵרִיטִי עֶלְיוֹנָה הוּגְדְּרָה כִּי הַמִּשְׁתַּמְּשִׁים לֹא הִצְלִיחוּ לְהַשְׁלִים רְכִישָׁה.",
            exampleNative = "Высший סֵבֵרִיטִי выставили, потому что пользователи не могли завершить покупку.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176108, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_bug_lifecycle", transliteration = "reprodaktzia",
            original = "רֶפְּרוֹדַקְצְיָה", translation = "воспроизведение бага",
            definition = "פְּעֻלָּה שֶׁל לִגְרֹם לַתַּקָּלָה לִקְרוֹת שׁוּב, מוּל מְפַתֵּחַ אוֹ בִּסְבִיבָה אַחֶרֶת.",
            definitionNative = "Заставить поломку случиться снова — на глазах разработчика или на другой среде.",
            example = "בְּלִי רֶפְּרוֹדַקְצְיָה אֲמִינָה אִי אֶפְשָׁר לְתַקֵּן שׁוּם בָּאג מֻרְכָּב.",
            exampleNative = "Без надёжной רֶפְּרוֹדַקְצְיָה невозможно починить ни один сложный баг.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176109, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_bug_lifecycle", transliteration = "ishur tikun",
            original = "אִישׁוּר תִּיקּוּן", translation = "верификация починки",
            definition = "בְּדִיקָה חוֹזֶרֶת שֶׁל בּוֹדֵק הָאֵיכוּת אַחֲרֵי שֶׁהַמְּפַתֵּחַ אָמַר שֶׁהַתַּקָּלָה נִפְתְּרָה.",
            definitionNative = "Повторная проверка тестировщика после того, как разработчик заявил о починке.",
            example = "אַחֲרֵי אִישׁוּר תִּיקּוּן הַתִּיקֶט עָבַר לְסַטָּטוּס סָגוּר בַּמַּעֲרֶכֶת.",
            exampleNative = "После אִישׁוּר תִּיקּוּן тикет перешёл в закрытый статус в системе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176110, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_bug_lifecycle", transliteration = "sgira",
            original = "סְגִירָה", translation = "закрытие бага",
            definition = "סוֹף הַמַּסָּע שֶׁל הַתַּקָּלָה — אַחֲרֵי תִּיקּוּן וּוִידּוּא שֶׁהַכֹּל עוֹבֵד שׁוּב.",
            definitionNative = "Финал пути поломки — после починки и подтверждения, что всё снова работает.",
            example = "הַסְּגִירָה שֶׁל הַתִּיקֶט עָקְבָה מִיָּד אַחֲרֵי שֶׁהַטֶּסְטֶר אִישֵּׁר אֶת הַפִיצֶ׳ר.",
            exampleNative = "סְגִירָה тикета произошла сразу после того, как тестировщик подтвердил фичу.",
            isFillInBlankSafe = false,
        ),

        // ── qa_manual (5) — артефакты ручного тестирования ──
        WordEntity(
            id = 176111, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_manual", transliteration = "test plan",
            original = "טֶסְט פְּלָאן", translation = "тест-план",
            definition = "מִסְמָךְ עִם הָאַסְטְרָטֶגְיָה הַכּוֹלֶלֶת — מָה בּוֹדְקִים, אֵיךְ וּמָתַי לִפְנֵי שִׁחְרוּר.",
            definitionNative = "Документ с общей стратегией — что, как и когда проверяют до релиза.",
            example = "כָּתַבְנוּ טֶסְט פְּלָאן מְפֹרָט לִפְנֵי הַתְחָלַת הַחֹדֶשׁ הַחֲדָשׁ שֶׁל הַפִיצֶ׳רִים.",
            exampleNative = "Мы написали подробный טֶסְט פְּלָאן до начала нового месяца с фичами.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176112, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_manual", transliteration = "mikre bdika",
            original = "מִקְרֵה בְּדִיקָה", translation = "тест-кейс",
            definition = "תֵּאוּר שֶׁל מַצָּב מְסֻיָּם עִם צְעָדִים מְדֻיָּקִים וְהַתּוֹצָאָה הַמְצֻפָּה מֵהַתּוֹכְנָה.",
            definitionNative = "Описание конкретной ситуации — точные шаги и ожидаемый результат от программы.",
            example = "כָּל מִקְרֵה בְּדִיקָה רָשׁוּם בַּמַּעֲרֶכֶת עִם תְּנָאִים מַקְדִּימִים וּשְׁלָבִים מִסְפָּרִיִּים.",
            exampleNative = "Каждый מִקְרֵה בְּדִיקָה записан в системе с предусловиями и нумерованными шагами.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176113, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_manual", transliteration = "tarkhish",
            original = "תַּרְחִישׁ", translation = "тестовый сценарий",
            definition = "סִדְרָה שְׁלֵמָה שֶׁל פְּעֻלּוֹת מִשְׁתַּמֵּשׁ — לְמָשָׁל הַזְמָנַת מַסְעָדָה עִם תַּשְׁלוּם וְבִיטּוּל.",
            definitionNative = "Полная цепочка действий пользователя — например, заказ ресторана с оплатой и отменой.",
            example = "הַ-תַּרְחִישׁ הַחֲדָשׁ כָּלַל הַרְשָׁמָה, הַזְמָנָה וְשִׁחְרוּר חֶשְׁבּוֹן בְּפֶחוֹת מִשָּׁעָה.",
            exampleNative = "Новый תַּרְחִישׁ включал регистрацию, заказ и закрытие счёта меньше чем за час.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176114, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_manual", transliteration = "cheklist",
            original = "צֵ'קְלִיסְט", translation = "чеклист",
            definition = "רְשִׁימָה קְצָרָה שֶׁל פְּרִיטִים שֶׁל «לְסַמֵּן וִי» — שֶׁשּׁוּם דָּבָר חָשׁוּב לֹא נִשְׁכַּח.",
            definitionNative = "Короткий список пунктов «поставить галочку» — чтобы ничего важного не забыть.",
            example = "הַ-צֵ'קְלִיסְט שֶׁל הַשִּׁחְרוּר כָּלַל אַרְבַּע עֶשְׂרֵה נְקֻדּוֹת חוֹבָה לְכָל מְפַתֵּחַ.",
            exampleNative = "צֵ'קְלִיסְט релиза включал четырнадцать обязательных пунктов для каждого разработчика.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176115, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_manual", transliteration = "exploratori",
            original = "אֶקְסְפְּלוֹרָטוֹרִי", translation = "исследовательское тестирование",
            definition = "סִגְנוֹן לֹא מְתֻכְנָן שֶׁבּוֹ הַבּוֹדֵק מְשׂוֹחֵחַ עִם הַתּוֹכְנָה כְּמוֹ מִשְׁתַּמֵּשׁ סַקְרָן.",
            definitionNative = "Незапланированный стиль — тестировщик общается с программой как любопытный пользователь.",
            example = "סֶשֵׁן אֶקְסְפְּלוֹרָטוֹרִי שֶׁל שָׁעָה גִּלָּה אַרְבָּעָה בָּאגִים שֶׁאוֹטוֹמַצְיָה פִּסְפְּסָה.",
            exampleNative = "Часовая сессия אֶקְסְפְּלוֹרָטוֹרִי нашла четыре бага, которые автоматизация прошляпила.",
            isFillInBlankSafe = false,
        ),

        // ── qa_environment (5) — тестовые среды и инфраструктура ──
        WordEntity(
            id = 176116, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_environment", transliteration = "svivat testim",
            original = "סְבִיבַת טֶסְטִים", translation = "тестовая среда",
            definition = "מַעֲרֶכֶת מְבֻדֶּדֶת שֶׁבָּהּ אֶפְשָׁר לְהָרִיץ בְּדִיקוֹת בְּלִי לְהַפְרִיעַ לַמִּשְׁתַּמְּשִׁים.",
            definitionNative = "Изолированная система — там можно прогонять проверки, не мешая пользователям.",
            example = "סְבִיבַת טֶסְטִים שֶׁלָּנוּ נוֹפֶלֶת כָּל יוֹם רִאשׁוֹן בִּגְלַל גִּבּוּי כָּבֵד.",
            exampleNative = "Наша סְבִיבַת טֶסְטִים падает каждое воскресенье из-за тяжёлого бэкапа.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176117, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_environment", transliteration = "sandboks",
            original = "סַנְדְבּוֹקְס", translation = "песочница",
            definition = "מָקוֹם בָּטוּחַ לְהִתְנַסּוֹת בְּחֹפֶשׁ — בְּלִי שׁוּם סַכָּנָה לִנְתוּנֵי אֱמֶת.",
            definitionNative = "Безопасное место для свободных экспериментов — без риска для боевых данных.",
            example = "מְפַתְּחֵי הַ-API מְשַׁחְקִים בַּסַנְדְבּוֹקְס לִפְנֵי שֶׁמְּחַבְּרִים לַקּוֹחוֹת אֲמִתִּיִּים.",
            exampleNative = "Разработчики API играются в סַנְדְבּוֹקְס, прежде чем подключать настоящих клиентов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176118, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_environment", transliteration = "prodakshen",
            original = "פְּרוֹדַקְשֶׁן", translation = "продакшен",
            definition = "הַסְּבִיבָה הָאֲמִתִּית שֶׁמַּגִּיעָה לַלָּקוֹחוֹת בָּעוֹלָם — שָׁם כָּל טָעוּת נִרְאֵית מִיָּד.",
            definitionNative = "Боевая среда, которая видна реальным клиентам в мире — там любая ошибка заметна сразу.",
            example = "אַף פַּעַם לֹא מְדַבְּרִים יָשִׁיר עִם פְּרוֹדַקְשֶׁן בְּלִי גִּבּוּי וְבִדְקָה כְּפוּלָה.",
            exampleNative = "Никогда не лезут напрямую в פְּרוֹדַקְשֶׁן без бэкапа и двойной проверки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176119, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_environment", transliteration = "datat test",
            original = "דָּאטַת טֶסְט", translation = "тестовые данные",
            definition = "אוֹסֶף שֶׁל מִשְׁתַּמְּשִׁים, מוּצָרִים וְעֶסְקוֹת מְזֻיָּפִים שֶׁמִּתְכַּנְּנִים מֵרֹאשׁ לִבְדִיקוֹת.",
            definitionNative = "Набор фейковых пользователей, товаров и сделок — заранее заготовленных для проверок.",
            example = "צָרִיךְ לְרַעֲנֵן אֶת דָּאטַת טֶסְט שֶׁל הַתַּשְׁלוּמִים אַחֲרֵי כָּל גִּרְסָה.",
            exampleNative = "Платёжную דָּאטַת טֶסְט надо обновлять после каждой версии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176120, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_environment", transliteration = "mok",
            original = "מוֹק", translation = "мок (заглушка)",
            definition = "תַּחְלִיף מְזֻיָּף שֶׁל שֵׁרוּת חִיצוֹנִי — מַחְזִיר תְּשׁוּבָה קְבוּעָה וְמַהִיר.",
            definitionNative = "Фейковая замена внешнего сервиса — отдаёт фиксированный ответ и работает быстро.",
            example = "כְּדַי לִבְדֹּק לְלֹא רֶשֶׁת בָּנִינוּ מוֹק שֶׁל שֵׁרוּת הַתַּשְׁלוּמִים שֶׁל סְטְרַייפ.",
            exampleNative = "Чтобы тестировать офлайн, мы собрали מוֹק платёжного сервиса Stripe.",
            isFillInBlankSafe = false,
        ),

        // ── qa_communication (5) — взаимодействие с разработкой ──
        WordEntity(
            id = 176121, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_communication", transliteration = "kriteryon kabala",
            original = "קְרִיטֶרְיוֹן קַבָּלָה", translation = "критерий приёмки",
            definition = "תְּנַאי שֶׁבּוֹדֵק הָאֵיכוּת מְבַקֵּשׁ לִפְנֵי שֶׁהוּא מוּכָן לְאַשֵּׁר אֶת הַפִיצֶ׳ר.",
            definitionNative = "Условие, которое тестировщик требует выполнить, прежде чем одобрить фичу.",
            example = "הַתִּיקֶט לֹא נִכְנַס לַסְּפְּרִינְט לִפְנֵי שֶׁכָּל קְרִיטֶרְיוֹן קַבָּלָה הָיָה כָּתוּב.",
            exampleNative = "Тикет не вошёл в спринт, пока каждый קְרִיטֶרְיוֹן קַבָּלָה не был расписан.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176122, setId = 1761, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_communication", transliteration = "ritest",
            original = "רִיטֶסְט", translation = "ретест",
            definition = "הַרָצָה חוֹזֶרֶת שֶׁל אוֹתוֹ מַסְלוּל בְּדִיקָה אַחֲרֵי שֶׁהַמְּפַתֵּחַ אָמַר שֶׁתִּקֵּן.",
            definitionNative = "Повторный прогон того же сценария после того, как разработчик заявил о починке.",
            example = "אַחֲרֵי כָּל הוֹטְפִיקְס אֲנִי עוֹשָׂה רִיטֶסְט יָדָנִי שֶׁל שְׁלוֹשָׁה תַּרְחִישִׁים מַקְבִּילִים.",
            exampleNative = "После каждого хотфикса я делаю ручной רִיטֶסְט трёх параллельных сценариев.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176123, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_communication", transliteration = "sayn-of",
            original = "סַיְין-אוֹף", translation = "сайн-офф / финальное добро",
            definition = "הַסְכָּמָה רִשְׁמִית שֶׁל בּוֹדֵק הָאֵיכוּת שֶׁמּוּצָר מוּכָן לְשִׁחְרוּר לַלָּקוֹחוֹת.",
            definitionNative = "Формальное согласие тестировщика, что продукт готов к выкатке клиентам.",
            example = "בְּלִי סַיְין-אוֹף שֶׁל QA הַשִׁחְרוּר נִדְחָה לְמַחְרָת בַּבֹּקֶר.",
            exampleNative = "Без סַיְין-אוֹף от QA релиз отложили на следующее утро.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176124, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_communication", transliteration = "regresia suit",
            original = "רֶגְרֶסְיָה סוּיט", translation = "регрессионный набор",
            definition = "אוֹסֶף קָבוּעַ שֶׁל בְּדִיקוֹת שֶׁרָצוֹת לִפְנֵי כָּל גִּרְסָה — שֶׁשּׁוּם דָּבָר יָשָׁן לֹא נִשְׁבַּר.",
            definitionNative = "Постоянный набор проверок перед каждой версией — чтобы старое не сломалось.",
            example = "רֶגְרֶסְיָה סוּיט שֶׁלָּנוּ רָץ עַל הַשֵּׁרֵת שָׁלוֹשׁ שָׁעוֹת בְּלַיְלָה לִפְנֵי הַשִׁחְרוּר.",
            exampleNative = "Наш רֶגְרֶסְיָה סוּיט крутится на сервере три часа ночью перед релизом.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176125, setId = 1761, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "qa_communication", transliteration = "eskalatzia",
            original = "אֶסְקָלַצְיָה", translation = "эскалация (передача наверх)",
            definition = "הַעֲבָרַת בְּעָיָה לְמִישֶׁהוּ בָּכִיר יוֹתֵר כְּשֶׁהַצֶּוֶות לֹא מַצְלִיחַ לְפַתֵּר אוֹתָהּ.",
            definitionNative = "Передача проблемы кому-то старше, когда команда не справляется сама.",
            example = "אַחֲרֵי שָׁעָה בְּלִי תְּשׁוּבָה הֶחְלַטְתִּי עַל אֶסְקָלַצְיָה לַמְּנַהֵל הַטֶּכְנִי.",
            exampleNative = "Через час без ответа я решился на אֶסְקָלַצְיָה к техническому руководителю.",
            isFillInBlankSafe = false,
        ),
    )
}
