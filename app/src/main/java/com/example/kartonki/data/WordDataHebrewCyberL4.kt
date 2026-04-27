package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Кибербезопасность", уровень 4 (профессиональный).
 *
 * Set 1768: «Кибербезопасность» — профессиональный L4 (EPIC + LEGENDARY).
 * Узкоспециальная лексика для security-инженеров, аналитиков SOC,
 * пентестеров, GRC-специалистов и архитекторов безопасности в израильских
 * компаниях.
 *
 * Лексика двуязычная: иврит + плотный слой английских заимствований
 * (פֶּנְ-טֶסְט здесь намеренно не дублируется — Hightech L4 уже имеет это
 * слово, поэтому здесь использован «академический» вариант מִבְחַן חֲדִירָה).
 * Похожая ситуация с GDPR — в Hightech L4 это גִ׳י-דִּי-פִּי-אַר, здесь —
 * описательная форма תַּקָּנַת הֲגַנַּת מֵידָע אֵירוֹפִּית (European Data Protection
 * Regulation), как её называют юристы и комплаенс-специалисты.
 *
 * Распределение редкостей:
 *   13 EPIC + 12 LEGENDARY (без выхода за 2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   cyber_pentesting    — наступательная безопасность: pentest, red/blue team, vuln scan, exploit
 *   cyber_response      — реагирование: incident response, forensics, IOC, SIEM, SOC
 *   cyber_governance    — нормативка и стандарты: compliance, ISO 27001, SOC 2, GDPR, data residency
 *   cyber_advanced      — современные архитектуры: zero trust, micro-segmentation, BYOD, container, supply chain
 *   cyber_cryptography  — криптография: symmetric, public key, hash, digital signature, salt
 *
 * Word IDs: setId × 100 + position (176801..176825).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewCyberL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1768, languagePair = "he-ru", orderIndex = 1768,
            name = "Кибербезопасность",
            description = "Продвинутый: пентест, инциденты, governance, zero trust, криптография",
            topic = "Кибербезопасность", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1768 — Кибербезопасность: профессиональный (L4, EPIC + LEGENDARY)
        // 5 групп × 5 слов: pentesting, response, governance, advanced, cryptography
        // ══════════════════════════════════════════════════════════════════════

        // ── cyber_pentesting (5) — наступательная безопасность и поиск дыр ──
        WordEntity(
            id = 176801, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_pentesting", transliteration = "mivkhan khadira",
            original = "מִבְחַן חֲדִירָה", translation = "пентест",
            definition = "בְּדִיקָה מֻזְמֶנֶת שֶׁבָּהּ הָאקֵר חוֹקִי מְנַסֶּה לִשְׁבֹּר מַעֲרֶכֶת וּלְדַוֵּחַ עַל חוּלְשׁוֹת.",
            definitionNative = "Заказная проверка: легальный хакер пробует сломать систему и доложить о слабых местах.",
            example = "מִבְחַן חֲדִירָה לִפְנֵי הַשִּׁחְרוּר חָשַׂף בָּאג קְרִיטִי בָּאוֹתֶנְטִיקַצְיָה.",
            exampleNative = "מִבְחַן חֲדִירָה перед релизом вскрыл критический баг в аутентификации.",
         fillInBlankExclusions = listOf(176802L, 176803L, 176804L, 176805L)),
        WordEntity(
            id = 176802, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_pentesting", transliteration = "red tim",
            original = "רֵד טִים", translation = "red team",
            definition = "צֶוֶות תּוֹקֵף שֶׁמְּחַקֶּה הַתְקָפָה אֲמִתִּית כְּדֵי לִבְחֹן אֶת הַהֲגָנָה שֶׁל הַחֶבְרָה.",
            definitionNative = "Атакующая команда — имитирует настоящую атаку, чтобы проверить защиту фирмы.",
            example = "רֵד טִים הִצְלִיחַ לְהַגִּיעַ לְשֶׁרֶת הַשְּׁכֹר תּוֹךְ שָׁלֹשׁ שָׁעוֹת.",
            exampleNative = "רֵד טִים дотянулся до зарплатного сервера за три часа.",
         fillInBlankExclusions = listOf(176801L, 176803L, 176804L, 176805L)),
        WordEntity(
            id = 176803, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_pentesting", transliteration = "blu tim",
            original = "בְּלוּ טִים", translation = "blue team",
            definition = "צֶוֶות מְגֵן שֶׁמְּזַהֶה תְּקִיפוֹת בִּזְמַן אֱמֶת וְעוֹצֵר אוֹתָן בַּסְּבִיבָה הַחַיָּה.",
            definitionNative = "Защитная команда — ловит атаки в реальном времени и останавливает их на боевом окружении.",
            example = "בְּלוּ טִים שֶׁל הַחֶבְרָה זִהָה אֶת הַסְּרִיקָה תּוֹךְ שְׁתֵּי דַּקּוֹת.",
            exampleNative = "בְּלוּ טִם фирмы засёк скан за две минуты.",
         fillInBlankExclusions = listOf(176801L, 176802L, 176804L, 176805L)),
        WordEntity(
            id = 176804, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_pentesting", transliteration = "srikat khulshot",
            original = "סְרִיקַת חוּלְשׁוֹת", translation = "сканирование уязвимостей",
            definition = "מַעֲבָר אוֹטוֹמָטִי עַל שֶׁרֶת אוֹ אַפְּלִיקַצְיָה כְּדֵי לִמְצֹא נְקֻדּוֹת תּוֹרְפָּה יְדוּעוֹת.",
            definitionNative = "Автоматический проход по серверу или приложению — найти известные слабые точки.",
            example = "סְרִיקַת חוּלְשׁוֹת שְׁבוּעִית מַרִיצָה אֶת נֶסוּס עַל כָּל הַסְּבִיבָה.",
            exampleNative = "Еженедельный סְרִיקַת חוּלְשׁוֹת гоняет Nessus по всему окружению.",
         fillInBlankExclusions = listOf(176801L, 176802L, 176803L, 176805L)),
        WordEntity(
            id = 176805, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_pentesting", transliteration = "eksploit",
            original = "אֶקְסְפְּלוֹיט", translation = "эксплойт",
            definition = "קוֹד שֶׁמְּנַצֵּל בָּאג סְפֵצִיפִי וּמְקַבֵּל גִּישָׁה אֲסוּרָה לַמַּעֲרֶכֶת.",
            definitionNative = "Код — пользуется конкретным багом и получает запрещённый доступ к системе.",
            example = "אֶקְסְפְּלוֹיט פֻּרְסַם בָּרֶשֶׁת לִפְנֵי שֶׁהוֹצִיאוּ פַּאצְ׳ רִשְׁמִי.",
            exampleNative = "אֶקְסְפְּלוֹיט выложили в сеть до выхода официального патча.",
         fillInBlankExclusions = listOf(176801L, 176802L, 176803L, 176804L)),

        // ── cyber_response (5) — реагирование на инциденты и SOC ──
        WordEntity(
            id = 176806, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_response", transliteration = "tguvat eru'a",
            original = "תְּגוּבַת אֵרוּעַ", translation = "incident response",
            definition = "תַּהֲלִיךְ מְסֻדָּר שֶׁמַּפְעִיל הַצֶּוֶות בִּזְמַן הַתְקָפָה כְּדֵי לִבְלֹם אוֹתָהּ וְלִלְמֹד מִמֶּנָּה.",
            definitionNative = "Упорядоченный процесс — команда запускает его при атаке, чтобы остановить и разобрать.",
            example = "תְּגוּבַת אֵרוּעַ בַּחֶבְרָה מְוַסֶּתֶת לְפִי פְּלֵייבּוּקִים מוּכָנִים מֵרֹאשׁ.",
            exampleNative = "תְּגוּבַת אֵרוּעַ в фирме идёт по плейбукам, готовым заранее.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176807, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_response", transliteration = "forenzika digitalit",
            original = "פוֹרֶנְזִיקָה דִּיגִיטָלִית", translation = "цифровая криминалистика",
            definition = "חֲקִירָה שֶׁל דִּיסְקִים, לוֹגִים וְזִכָּרוֹן כְּדֵי לְהָבִין אֵיךְ בְּדִיּוּק קָרְתָה הַפְּרִיצָה.",
            definitionNative = "Расследование дисков, логов и памяти — понять, как именно случился взлом.",
            example = "פוֹרֶנְזִיקָה דִּיגִיטָלִית גִּלְּתָה שֶׁהַפּוֹרֵץ נִשְׁאַר בָּרֶשֶׁת חֳדָשַׁיִם.",
            exampleNative = "פוֹרֶנְזִיקָה דִּיגִיטָלִית показала, что взломщик сидел в сети два месяца.",
         fillInBlankExclusions = listOf(176806L, 176808L, 176809L, 176810L)),
        WordEntity(
            id = 176808, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_response", transliteration = "siman hitparzut",
            original = "סִימַן הִתְפָּרְצוּת", translation = "IOC (индикатор компрометации)",
            definition = "פְּרָט קָטָן בַּלּוֹג — אַי-פִּי, גִ׳יבּוּב אוֹ דּוֹמֵיין — שֶׁמְּגַלֶּה שֶׁמַּשֶּׁהוּ זָר נִכְנַס.",
            definitionNative = "Маленькая деталь в логе — IP, хеш или домен — выдаёт, что зашёл кто-то чужой.",
            example = "סִימַן הִתְפָּרְצוּת חָדָשׁ הִגִּיעַ מִקְּהִילַת הָאַבְטָחָה הַבֵּינְלְאֻמִּית.",
            exampleNative = "Новый סִימַן הִתְפָּרְצוּת пришёл от мирового security-комьюнити.",
         fillInBlankExclusions = listOf(176806L, 176807L, 176809L, 176810L)),
        WordEntity(
            id = 176809, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_response", transliteration = "siyem",
            original = "סִיֵם", translation = "SIEM",
            definition = "מַעֲרֶכֶת שֶׁאוֹסֶפֶת לוֹגִים מִכָּל מָקוֹם וּמַתְרִיעָה כְּשֶׁהֵם מַרְכִּיבִים תְּמוּנָה חֲשׁוּדָה.",
            definitionNative = "Система — собирает логи отовсюду и сигналит, когда они складываются в подозрительную картину.",
            example = "סִיֵם הִתְרִיעַ עַל מֵאָה נִסְיוֹנוֹת כְּנִיסָה בְּדַקָּה לְחֶשְׁבּוֹן הַמְּנַהֵל.",
            exampleNative = "סִיֵם сигналил о ста попытках входа в минуту в админский аккаунт.",
         fillInBlankExclusions = listOf(176806L, 176807L, 176808L, 176810L)),
        WordEntity(
            id = 176810, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_response", transliteration = "merkaz tafu'a avtakha",
            original = "מֶרְכַּז תַּפְעוּל אַבְטָחָה", translation = "SOC (security operations center)",
            definition = "חֶדֶר עִם מָסַכִּים שֶׁבּוֹ אֲנָלִיסְטִים מְנַטְּרִים אֵרוּעֵי סַייבֶּר עֶשְׂרִים-וְאַרְבַּע שָׁעוֹת בַּיּוֹם.",
            definitionNative = "Комната с экранами — аналитики мониторят кибер-события двадцать четыре часа в сутки.",
            example = "מֶרְכַּז תַּפְעוּל אַבְטָחָה הוּקַם בָּקַמְפּוּס אַחֲרֵי הַתְקָפַת הַכֹּפֶר.",
            exampleNative = "מֶרְכַּז תַּפְעוּל אַבְטָחָה открыли в кампусе после атаки шифровальщика.",
         fillInBlankExclusions = listOf(176806L, 176807L, 176808L, 176809L)),

        // ── cyber_governance (5) — нормативка, стандарты, регуляция ──
        WordEntity(
            id = 176811, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_governance", transliteration = "tsiyut regulatori",
            original = "צִיּוּת רֶגוּלָטוֹרִי", translation = "compliance",
            definition = "עֲמִידָה שֶׁל הַחֶבְרָה בְּכָל הַחֻקִּים וְהַתְּקָנִים שֶׁחָלִים עָלֶיהָ בְּתָחוּם הַסַּייבֶּר.",
            definitionNative = "Соответствие фирмы всем законам и стандартам, что действуют для неё в кибер-сфере.",
            example = "צִיּוּת רֶגוּלָטוֹרִי דּוֹרֵשׁ דּוּ\"חַ רֻבְעוֹנִי לִמְבַקֵּר רָאשִׁי.",
            exampleNative = "צִיּוּת רֶגוּלָטוֹרִי требует квартальный отчёт для главного аудитора.",
         fillInBlankExclusions = listOf(176812L, 176813L, 176814L, 176815L)),
        WordEntity(
            id = 176812, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_governance", transliteration = "aiso esrim ve-sheva elef",
            original = "אַייסוֹ 27001", translation = "ISO 27001",
            definition = "תֶּקֶן בֵּינְלְאֻמִּי שֶׁמַּגְדִּיר אֵיךְ אִרְגּוּן צָרִיךְ לְנַהֵל אֶת אַבְטָחַת הַמֵּידָע שֶׁלּוֹ.",
            definitionNative = "Международный стандарт — определяет, как организация обязана управлять защитой данных.",
            example = "אַייסוֹ 27001 הִתְקַבֵּל אַחֲרֵי שָׁנָה וָחֵצִי שֶׁל הַכָנָה רְצוּפָה.",
            exampleNative = "אַייסוֹ 27001 получили после полутора лет непрерывной подготовки.",
         fillInBlankExclusions = listOf(176811L, 176813L, 176814L, 176815L)),
        WordEntity(
            id = 176813, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_governance", transliteration = "odit sok shtaim",
            original = "אוֹדִיט סוֹק 2", translation = "SOC 2 (аудит)",
            definition = "בִּקֹּרֶת חִיצוֹנִית שֶׁבּוֹדֶקֶת אֵיךְ סְפַּק שֶׁרוּת עָנָן שׁוֹמֵר עַל מֵידָע שֶׁל לָקוֹחוֹת.",
            definitionNative = "Внешняя проверка — как облачный провайдер хранит данные клиентов.",
            example = "אוֹדִיט סוֹק 2 חוֹבָה לְכָל סְטַארְטָאפּ שֶׁמּוֹכֵר לְשׁוּק אָמֵרִיקָנִי.",
            exampleNative = "אוֹדִיט סוֹק 2 — обязалово для каждого стартапа, что продаёт на рынке США.",
         fillInBlankExclusions = listOf(176811L, 176812L, 176814L, 176815L)),
        WordEntity(
            id = 176814, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_governance", transliteration = "takkanat haganat meida eropit",
            original = "תַּקָּנַת הֲגַנַּת מֵידָע אֵירוֹפִּית", translation = "GDPR",
            definition = "חֹק יַבַּשְׁתִּי שֶׁמְּחַיֵּב חֶבְרָה לִשְׁמֹר עַל פְּרָטָיו הָאִישִׁיִּים שֶׁל כָּל אֶזְרָח.",
            definitionNative = "Континентальный закон — обязывает фирму беречь личные данные каждого гражданина.",
            example = "תַּקָּנַת הֲגַנַּת מֵידָע אֵירוֹפִּית חִיְּבָה אוֹתָנוּ לִמְחֹק לְקוֹחוֹת לְפִי דְּרִישָׁה.",
            exampleNative = "תַּקָּנַת הֲגַנַּת מֵידָע אֵירוֹפִּית обязала нас удалять клиентов по запросу.",
         fillInBlankExclusions = listOf(176811L, 176812L, 176813L, 176815L)),
        WordEntity(
            id = 176815, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_governance", transliteration = "akhsun meida mekomi",
            original = "אִחְסוּן מֵידָע מְקוֹמִי", translation = "data residency",
            definition = "דְּרִישָׁה שֶׁמֵּידַע שֶׁל אֶזְרָחֵי מְדִינָה יִשָּׁמֵר רַק עַל שְׁרָתִים בְּתוֹךְ הַמְּדִינָה הַזּוֹ.",
            definitionNative = "Требование: данные граждан страны хранятся только на серверах внутри неё.",
            example = "אִחְסוּן מֵידָע מְקוֹמִי הֶחְלִיט בְּאֵיזוֹ אֲזוֹרֵי עָנָן נוּכַל לִעֲבֹד.",
            exampleNative = "אִחְסוּן מֵידָע מְקוֹמִי определил, в каких облачных регионах нам можно работать.",
         fillInBlankExclusions = listOf(176811L, 176812L, 176813L, 176814L)),

        // ── cyber_advanced (5) — современные архитектуры безопасности ──
        WordEntity(
            id = 176816, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_advanced", transliteration = "ziro trast",
            original = "זִירוֹ טְרַסְט", translation = "zero trust",
            definition = "גִּישָׁה שֶׁבָּהּ אַף מִשְׁתַּמֵּשׁ אוֹ שֶׁרֶת לֹא נֶחְשָׁב אָמִין מֵרֹאשׁ — כָּל בַּקָּשָׁה נִבְדֶּקֶת שׁוּב.",
            definitionNative = "Подход: ни юзер, ни сервер не считается доверенным заранее — каждый запрос проверяется заново.",
            example = "מַעֲבָר לְזִירוֹ טְרַסְט הֶעֱלִים אֶת הַסְּגִירוּת שֶׁל הָרֶשֶׁת הַפְּנִימִית.",
            exampleNative = "Переход на זִירוֹ טְרַסְט убрал замкнутость внутренней сети.",
         fillInBlankExclusions = listOf(176817L, 176818L, 176819L, 176820L)),
        WordEntity(
            id = 176817, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_advanced", transliteration = "mikro-segmentatsya",
            original = "מִיקְרוֹ-סֶגְמֶנְטַצְיָה", translation = "микро-сегментация",
            definition = "חֲלוּקָה שֶׁל הָרֶשֶׁת לְאֵזוֹרִים זְעִירִים כָּךְ שֶׁפּוֹרֵץ לֹא יוּכַל לָנוּעַ בָּהּ חָפְשִׁי.",
            definitionNative = "Деление сети на крошечные зоны — взломщик не сможет свободно по ней двигаться.",
            example = "מִיקְרוֹ-סֶגְמֶנְטַצְיָה בְּקוּבֶּרְנֵטֶס מַגְבִּילָה כָּל פּוֹד לִשְׁכֵנִים מֻגְדָּרִים.",
            exampleNative = "מִיקְרוֹ-סֶגְמֶנְטַצְיָה в Kubernetes ограничивает каждый под определёнными соседями.",
         fillInBlankExclusions = listOf(176816L, 176818L, 176819L, 176820L)),
        WordEntity(
            id = 176818, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_advanced", transliteration = "bi-vai-o-di",
            original = "בִּי-וַי-אוֹ-דִּי", translation = "BYOD (личное устройство на работе)",
            definition = "מְדִינִיּוּת שֶׁמַּתִּירָה לְעוֹבֵד לְהִתְחַבֵּר לְמַעַרְכוֹת הַחֶבְרָה דֶּרֶךְ הַטֵּלֵפוֹן הַפְּרָטִי שֶׁלּוֹ.",
            definitionNative = "Политика — разрешает работнику подключаться к системам фирмы со своего личного телефона.",
            example = "בִּי-וַי-אוֹ-דִּי דּוֹרֵשׁ הַתְקָנַת אַפְּלִיקַצְיַת נִהוּל מַכְשִׁירִים עַל כָּל מַכְשִׁיר.",
            exampleNative = "בִּי-וַי-אוֹ-דִּי требует MDM-приложение на каждом устройстве.",
         fillInBlankExclusions = listOf(176816L, 176817L, 176819L, 176820L)),
        WordEntity(
            id = 176819, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_advanced", transliteration = "avtakhat konteyner",
            original = "אַבְטָחַת קוֹנְטֵיינֶר", translation = "container security",
            definition = "סְרִיקָה וְהַקְשָׁחָה שֶׁל דְּמוּיוֹת דּוֹקֵר וְשֶׁל סְבִיבַת הָרִיצָה לִפְנֵי הַעֲלָאָה לָעֲנָן.",
            definitionNative = "Проверка и закалка докер-образов и среды выполнения — до загрузки в облако.",
            example = "אַבְטָחַת קוֹנְטֵיינֶר חָסְמָה תְּמוּנָה עִם סְפְרִיָּה פְּגִיעָה.",
            exampleNative = "אַבְטָחַת קוֹנְטֵיינֶר заблокировала образ с уязвимой библиотекой.",
         fillInBlankExclusions = listOf(176816L, 176817L, 176818L, 176820L)),
        WordEntity(
            id = 176820, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_advanced", transliteration = "saplay tsheyn atak",
            original = "סַפְּלַיי צֵ'יין אַטָאק", translation = "supply chain attack",
            definition = "פְּרִיצָה דֶּרֶךְ סְפָק חִיצוֹנִי שֶׁמַּשְׁפִּיעָה עַל מֵאוֹת חֲבָרוֹת שֶׁמְּשׁתַּמְּשׁוֹת בָּאוֹתוֹ הַכְּלִי.",
            definitionNative = "Взлом через внешнего поставщика — задевает сотни фирм, что используют один и тот же инструмент.",
            example = "סַפְּלַיי צֵ'יין אַטָאק עַל סוֹלָרְוִוינְדְס הִדְהֵד בִּמְמַשְׁלַת אַרְצוֹת הַבְּרִית.",
            exampleNative = "סַפְּלַיי צֵ'יין אַטָאק на SolarWinds аукнулась в правительстве США.",
         fillInBlankExclusions = listOf(176816L, 176817L, 176818L, 176819L)),

        // ── cyber_cryptography (5) — криптографические примитивы ──
        WordEntity(
            id = 176821, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_cryptography", transliteration = "hatspana simetrit",
            original = "הַצְפָּנָה סִימֶטְרִית", translation = "симметричное шифрование",
            definition = "שִׁיטָה שֶׁבָּהּ אוֹתוֹ סִיסְמָה סוֹדִית מְשַׁמֶּשֶׁת גַּם לִסְגִירָה וְגַם לִפְתִיחָה שֶׁל הַמֵּידָע.",
            definitionNative = "Способ — один и тот же секрет служит и для запирания, и для открывания данных.",
            example = "הַצְפָּנָה סִימֶטְרִית מַתְאִימָה לְקֳבָצִים גְּדוֹלִים בְּגַלְלָ מְהִירוּתָהּ.",
            exampleNative = "הַצְפָּנָה סִימֶטְרִית подходит большим файлам — за счёт скорости.",
         fillInBlankExclusions = listOf(176822L, 176823L, 176824L, 176825L)),
        WordEntity(
            id = 176822, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_cryptography", transliteration = "maftea'kh tsiburi",
            original = "מַפְתֵּחַ צִבּוּרִי", translation = "публичный ключ (асимметричное шифрование)",
            definition = "צֵרוּף שֶׁכָּל אֶחָד יָכוֹל לִרְאוֹת — מְשַׁמֵּשׁ לְהַצְפִּין מֵידָע אוֹ לְאַמֵּת חֲתִימָה.",
            definitionNative = "Комбинация, которую может видеть каждый — для зашифровки данных или проверки подписи.",
            example = "מַפְתֵּחַ צִבּוּרִי מְפֻרְסָם בָּשֶׁרֶת כָּךְ שֶׁכָּל אֶחָד יָכוֹל לִשְׁלֹחַ הוֹדָעָה מֻצְפֶּנֶת.",
            exampleNative = "מַפְתֵּחַ צִבּוּרִי опубликован на сервере — каждый может слать зашифрованное сообщение.",
         fillInBlankExclusions = listOf(176821L, 176823L, 176824L, 176825L)),
        WordEntity(
            id = 176823, setId = 1768, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_cryptography", transliteration = "funktsiyat gibuv",
            original = "פוּנְקְצִיַּת גִּיבּוּב", translation = "хеш-функция",
            definition = "מָתֶמָטִיקָה שֶׁמְּמִירָה כָּל קֹבֶץ לְמַחְרֹזֶת קְצָרָה וְקְבוּעָה — וְלֹא חוֹזֶרֶת אַחוֹרָה.",
            definitionNative = "Математика — превращает любой файл в короткую и постоянную строку, без обратного хода.",
            example = "פוּנְקְצִיַּת גִּיבּוּב מְשַׁמֶּשֶׁת לִשְׁמִירַת סִיסְמָאוֹת בְּלִי לְשָׁמְרָן בְּגָלוּי.",
            exampleNative = "פוּנְקְצִיַּת גִּיבּוּב хранит пароли так, чтобы они не лежали в открытом виде.",
         fillInBlankExclusions = listOf(176821L, 176822L, 176824L, 176825L)),
        WordEntity(
            id = 176824, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_cryptography", transliteration = "khatima digitalit",
            original = "חֲתִימָה דִּיגִיטָלִית", translation = "цифровая подпись",
            definition = "סִימָן מָתֶמָטִי שֶׁמּוֹכִיחַ שֶׁמִּסְמָךְ נִשְׁלַח עַל יָדֵי אִישׁ סְפֵצִיפִי וְלֹא שֻׁנָּה.",
            definitionNative = "Математический знак — доказывает, что документ отправил конкретный человек и его не правили.",
            example = "חֲתִימָה דִּיגִיטָלִית עַל הַחוֹזֶה מַחְלִיפָה אֶת הָעֵט בָּעֵסֶק הַבֵּינְלְאֻמִּי.",
            exampleNative = "חֲתִימָה דִּיגִיטָלִית на договоре заменяет ручку в международном бизнесе.",
         fillInBlankExclusions = listOf(176821L, 176822L, 176823L, 176825L)),
        WordEntity(
            id = 176825, setId = 1768, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_cryptography", transliteration = "salt kriptografi",
            original = "סָאלְט קְרִיפְּטוֹגְרָפִי", translation = "криптографическая соль",
            definition = "מַחְרֹזֶת אַקְרָאִית שֶׁמּוֹסִיפִים לְסִיסְמָה — כָּךְ שֶׁשְּׁתֵּי סִיסְמָאוֹת זֵהוֹת יִתֵּנוּ פְּלָט שׁוֹנֶה.",
            definitionNative = "Случайная строка — добавляют к паролю до подсчёта, чтобы две одинаковые дали разный результат.",
            example = "סָאלְט קְרִיפְּטוֹגְרָפִי יִחוּדִי לְכָל מִשְׁתַּמֵּשׁ מוֹנֵעַ הַתְקָפָה בְּטַבְלָאוֹת מוּכָנוֹת.",
            exampleNative = "Уникальный для каждого юзера סָאלְט קְרִיפְּטוֹגְרָפִי блокирует атаку по готовым таблицам.",
         fillInBlankExclusions = listOf(176821L, 176822L, 176823L, 176824L)),
    )
}
