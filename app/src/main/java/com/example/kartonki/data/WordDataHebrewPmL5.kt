package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Продуктовый менеджмент", уровень 5 (носитель языка).
 *
 * Set 1779: «Продуктовый менеджмент» — носитель языка L5 (EPIC + LEGENDARY).
 * Лексика PM-leadership уровня CPO/VP product: управление портфелем продуктов,
 * продуктовая часть M&A, дизайн PM-организации и продвинутые концепции.
 *
 * Целевая аудитория — русскоязычные репатрианты, занимающие senior PM/CPO
 * позиции в израильском хайтеке. Лексика двуязычная: иврит + многочисленные
 * английские заимствования (סִי-פִּי-אוֹ, וִי-פִּי פְּרוֹדַקְט, גְּרוּפ פִּי-אֵם,
 * פְּרִינְסִיפָּל פִּי-אֵם, רֹאשׁ גְּרוֹאוּת, מַפַּת וָורְדְלִי, מוֹדֶל קַאנוֹ,
 * פִּי-אֶל-גִ'י) — так реально говорят на product leadership-форумах
 * и executive-планёрках в Тель-Авиве.
 *
 * Распределение редкостей:
 *   13 EPIC + 12 LEGENDARY (без выхода за 2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   pm_leadership         — высшие PM-роли: CPO, VP product, group PM, principal PM, head of growth
 *   pm_portfolio          — управление портфелем: product portfolio, line of business, family, sunset, cannibalization
 *   pm_ma                 — продуктовая часть M&A: аудит, integration plan, day-1, post-merger alignment, bolt-on
 *   pm_org_design         — дизайн PM-организации: PM org design, embedded PM, platform PM, career ladder, IC track
 *   pm_advanced_concepts  — продвинутые концепции: Wardley map, JTBD framework, Kano model, RACI, PLG
 *
 * Word IDs: setId × 100 + position (177901..177925).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 *
 * Дифференциация от соседних сетов (важно):
 *   • PmL3 (1765): уже занимает PRD, бэклог, sprint planning, north star, DAU, conversion,
 *     discovery, JTBD (базовый ג׳וֹבְּס טוּ בִּי דָּאן), iteration, design review, GTM,
 *     persona, user story. Здесь — leadership-уровень и портфель.
 *   • PmL4 (1766): vision, mission, OKR, AARRR, viral loop, growth experiment, feature toggle,
 *     gradual rollout, canary, P&L ownership, pricing, packaging, монетизация, LTV, RICE,
 *     MoSCoW. Здесь — рамки выше: leadership, M&A, org design, advanced concepts (Wardley, Kano).
 *   • Hightech L5 (1749) занимает CTO, IPO (явный запрет), VP R&D, due diligence,
 *     M&A термин, PMF, pivot, attrition. PM L5 — только продуктовый ракурс
 *     (CPO-роль через продукт, M&A через продуктовую интеграцию).
 *   • CPO (סִי-פִּי-אוֹ) формально присутствует в Hightech L5 как C-level роль, но
 *     темы разные (Хайтек vs Продуктовый менеджмент) — допустимо по правилам.
 */
object WordDataHebrewPmL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1779, languagePair = "he-ru", orderIndex = 1779,
            name = "Продуктовый менеджмент",
            description = "PM-leadership: CPO, портфель продуктов, M&A продуктов, организация PM-команды",
            topic = "Продуктовый менеджмент", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1779 — Продуктовый менеджмент: носитель языка (L5, EPIC + LEGENDARY)
        // 5 групп × 5 слов: leadership, portfolio, ma, org_design, advanced_concepts
        // ══════════════════════════════════════════════════════════════════════

        // ── pm_leadership (5) — высшие PM-роли в организации ──
        WordEntity(
            id = 177901, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_leadership", transliteration = "si-pi-o",
            original = "סִי-פִּי-אוֹ", translation = "CPO (директор по продукту)",
            definition = "הָאָדָם הַבָּכִיר שֶׁאַחְרָאִי עַל הַחֲזוֹן הַכּוֹלֵל שֶׁל כָּל קַוֵּי הַמּוּצָר בַּחֶבְרָה.",
            definitionNative = "Самый старший человек, отвечающий за общее видение всех продуктовых линий компании.",
            example = "הַסִּי-פִּי-אוֹ הִצִּיג בָּעֲצֶרֶת אֶת הַתּוֹכְנִית לְשָׁלוֹשׁ שָׁנִים קָדִימָה.",
            exampleNative = "סִי-פִּי-אוֹ представил на собрании план на три года вперёд.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177902, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_leadership", transliteration = "vi-pi prodakt",
            original = "וִי-פִּי פְּרוֹדַקְט", translation = "VP product (вице-президент по продукту)",
            definition = "סְגַן נָשִׂיא שֶׁמְּנַהֵל אֶת כָּל מַחְלֶקֶת הַפִּי-אֵם וּמְדַוֵּחַ יָשִׁיר לַסִּי-פִּי-אוֹ.",
            definitionNative = "Замглавы — ведёт весь продуктовый отдел и подчиняется напрямую CPO.",
            example = "וִי-פִּי פְּרוֹדַקְט שָׂכַר שִׁשָּׁה מְנַהֲלִים חֲדָשִׁים תּוֹךְ רֹבַע אֶחָד.",
            exampleNative = "וִי-פִּי פְּרוֹדַקְט нанял шесть новых руководителей за один квартал.",
         fillInBlankExclusions = listOf(177901L, 177903L, 177904L, 177905L)),
        WordEntity(
            id = 177903, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_leadership", transliteration = "grup pi-em",
            original = "גְּרוּפ פִּי-אֵם", translation = "group PM (руководитель группы продактов)",
            definition = "מְנַהֵל בֵּינַיִם שֶׁמּוֹבִיל שְׁלוֹשָׁה אוֹ אַרְבָּעָה מְנַהֲלֵי מוּצָר עַל אֵזוֹר אֶחָד.",
            definitionNative = "Руководитель среднего звена — ведёт трёх или четырёх продактов в одной зоне.",
            example = "גְּרוּפ פִּי-אֵם אַחֲרַאִי עַל אֵזוֹר הַתַּשְׁלוּמִים מִתְחַלֵּף כָּל שְׁנָתַיִם בִּמְמֻצַּע.",
            exampleNative = "גְּרוּפ פִּי-אֵם в зоне платежей в среднем меняется раз в два года.",
         fillInBlankExclusions = listOf(177901L, 177902L, 177904L, 177905L, 177918L)),
        WordEntity(
            id = 177904, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_leadership", transliteration = "prinsipal pi-em",
            original = "פְּרִינְסִיפָּל פִּי-אֵם", translation = "principal PM (главный продакт без подчинённых)",
            definition = "מוּמְחֶה בָּכִיר שֶׁפּוֹתֵר בְּעָיוֹת קָשׁוֹת בְּלִי לְנַהֵל אַף אֶחָד תַּחְתָּיו.",
            definitionNative = "Старший эксперт — решает сложные задачи, не имея никого в подчинении.",
            example = "פְּרִינְסִיפָּל פִּי-אֵם הִצְטָרֵף לְצֶוֶות הָאַייאַיי וְשִׁנָּה אֶת הַמַּחְשָׁבָה עַל הַתַּכְנוּן.",
            exampleNative = "פְּרִינְסִיפָּל פִּי-אֵם пришёл в команду AI и поменял подход к планированию.",
         fillInBlankExclusions = listOf(177901L, 177902L, 177903L, 177905L, 177918L)),
        WordEntity(
            id = 177905, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_leadership", transliteration = "rosh growt",
            original = "רֹאשׁ גְּרוֹאוּת", translation = "head of growth (руководитель роста)",
            definition = "מְנַהֵל שֶׁבָּעֲלֵיהוּ הַחוֹבָה לְהַגְדִּיל אֶת מִסְפַּר הַמִּשְׁתַּמְּשִׁים וְאֶת הַהַכְנָסוֹת.",
            definitionNative = "Руководитель, на котором обязанность увеличивать число пользователей и выручку.",
            example = "רֹאשׁ גְּרוֹאוּת הִצְלִיחַ לְהַכְפִּיל אֶת מִסְפַּר הַנִּרְשָׁמִים תּוֹךְ חֲצִי שָׁנָה.",
            exampleNative = "רֹאשׁ גְּרוֹאוּת сумел удвоить число регистраций за полгода.",
         fillInBlankExclusions = listOf(177901L, 177902L, 177903L, 177904L)),

        // ── pm_portfolio (5) — управление портфелем продуктов ──
        WordEntity(
            id = 177906, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_portfolio", transliteration = "tik mutsarim",
            original = "תִּיק מוּצָרִים", translation = "продуктовый портфель",
            definition = "אוֹסֶף שֶׁל כָּל הַמּוּצָרִים שֶׁל הַחֶבְרָה שֶׁמְּנֻהָלִים יַחַד כִּמְכֻלָּל אֶחָד.",
            definitionNative = "Совокупность всех изделий компании, которыми управляют вместе как единым целым.",
            example = "תִּיק מוּצָרִים שֶׁל הַחֶבְרָה גָּדַל לְשִׁבְעָה קַוִּים אַחֲרֵי הָרְכִישׁוֹת.",
            exampleNative = "תִּיק מוּצָרִים компании вырос до семи линеек после покупок.",
         fillInBlankExclusions = listOf(177907L, 177908L, 177909L, 177910L)),
        WordEntity(
            id = 177907, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_portfolio", transliteration = "kav asakim",
            original = "קַו עֲסָקִים", translation = "line of business (направление бизнеса)",
            definition = "תְּחוּם פְּעִילוּת עִם הַכְנָסוֹת וְהוֹצָאוֹת מֻפְרָדוֹת מִשְּׁאָר הַחֶבְרָה.",
            definitionNative = "Направление деятельности с отдельной выручкой и затратами от остальной компании.",
            example = "קַו עֲסָקִים שֶׁל אַבְטָחַת מֵידָע גָּדַל מָהֵר מִכָּל הַשְּׁאָר בָּרֹבַע הַזֶּה.",
            exampleNative = "קַו עֲסָקִים по информбезопасности рос быстрее всех остальных в этом квартале.",
         fillInBlankExclusions = listOf(177906L, 177908L, 177909L, 177910L)),
        WordEntity(
            id = 177908, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_portfolio", transliteration = "mishpakhat mutsarim",
            original = "מִשְׁפַּחַת מוּצָרִים", translation = "продуктовая семья",
            definition = "קְבוּצָה שֶׁל הַצָּעוֹת קְרוֹבוֹת זוֹ לָזוֹ שֶׁחוֹלְקוֹת קְהַל יַעַד וְזֵהוּת מוּתְגִית.",
            definitionNative = "Группа близких предложений — общая аудитория и общая узнаваемость бренда.",
            example = "מִשְׁפַּחַת מוּצָרִים שֶׁל אוֹפִיס שׁוּוְקָה תַּחַת חֲבִילָה אַחַת לְלָקוֹחוֹת אַרְגּוּנִיִּים.",
            exampleNative = "מִשְׁפַּחַת מוּצָרִים офиса продавали единым пакетом корпоративным клиентам.",
         fillInBlankExclusions = listOf(177906L, 177907L, 177909L, 177910L)),
        WordEntity(
            id = 177909, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_portfolio", transliteration = "shkiat mutsar",
            original = "שְׁקִיעַת מוּצָר", translation = "sunsetting product (закрытие продукта)",
            definition = "תַּהֲלִיךְ מְסֻדָּר שֶׁל סְגִירַת הַצָּעָה שְׁלֵמָה לְלָקוֹחוֹת אַחֲרֵי שָׁנִים שֶׁל פְּעִילוּת.",
            definitionNative = "Упорядоченный процесс закрытия целого предложения клиентам — после лет работы.",
            example = "שְׁקִיעַת מוּצָר הָעַתִּיק נִמְשְׁכָה שָׁנָה שְׁלֵמָה עִם הוֹדָעוֹת לַלָּקוֹחוֹת.",
            exampleNative = "שְׁקִיעַת מוּצָר старого тянулась целый год с уведомлениями клиентам.",
         fillInBlankExclusions = listOf(177906L, 177907L, 177908L, 177910L)),
        WordEntity(
            id = 177910, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_portfolio", transliteration = "kanibalizatsya shel mutsar",
            original = "קַנִיבָּלִיזַצְיָה שֶׁל מוּצָר", translation = "каннибализация продукта",
            definition = "מַצָּב שֶׁבּוֹ הַצָּעָה חֲדָשָׁה שֶׁל הַחֶבְרָה גּוֹרֶעֶת מְכִירוֹת מֵהַצָּעוֹת קַיָּמוֹת שֶׁלָּהּ.",
            definitionNative = "Положение, когда новое предложение фирмы отбирает продажи у её же существующих.",
            example = "קַנִיבָּלִיזַצְיָה שֶׁל מוּצָר אִיֵּם עַל הַתָּכְנִית לְשַׁחְרֵר אֶת הַגִּרְסָה הַחִנָּמִית.",
            exampleNative = "קַנִיבָּלִיזַצְיָה שֶׁל מוּצָר угрожала плану выпустить бесплатную версию.",
         fillInBlankExclusions = listOf(177906L, 177907L, 177908L, 177909L)),

        // ── pm_ma (5) — продуктовая часть M&A ──
        WordEntity(
            id = 177911, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_ma", transliteration = "audit mutsari",
            original = "אוֹדִיט מוּצָרִי", translation = "продуктовый аудит при M&A",
            definition = "בְּדִיקָה מַעֲמִיקָה שֶׁל מַצָּב הַהַצָּעוֹת אֵצֶל חֶבְרַת מַטָּרָה לִפְנֵי שֶׁחוֹתְמִים עַל הָעִסְקָה.",
            definitionNative = "Глубокая проверка состояния предложений у компании-цели — до подписания сделки.",
            example = "אוֹדִיט מוּצָרִי גִּלָּה שֶׁשְּׁלוֹשָׁה מֵחֲמֵשֶׁת הַקַּוִּים נִמְצָאִים בִּשְׁחִיקָה.",
            exampleNative = "אוֹדִיט מוּצָרִי обнаружил, что три из пяти линеек уже в стагнации.",
         fillInBlankExclusions = listOf(177912L, 177913L, 177914L, 177915L)),
        WordEntity(
            id = 177912, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_ma", transliteration = "tokhnit integratsya",
            original = "תָּכְנִית אִינְטֶגְרַצְיָה", translation = "integration plan (план интеграции продуктов)",
            definition = "מִסְמָךְ שֶׁמְּפָרֵט אֵיךְ שְׁתֵּי מַעֲרָכוֹת מוּצָר נִכְנָסוֹת לְמַעֲרֶכֶת אַחַת תּוֹךְ חֳדָשִׁים.",
            definitionNative = "Документ — как два набора систем сольются в один за несколько месяцев.",
            example = "תָּכְנִית אִינְטֶגְרַצְיָה לְשָׁלוֹשׁ שָׁנִים נֶחְתְּמָה בַּיּוֹם שֶׁלִּפְנֵי הַסְּגִירָה.",
            exampleNative = "תָּכְנִית אִינְטֶגְרַצְיָה на три года подписали за день до закрытия сделки.",
         fillInBlankExclusions = listOf(177911L, 177913L, 177914L, 177915L)),
        WordEntity(
            id = 177913, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_ma", transliteration = "deyi-van mutsari",
            original = "דֵיי-וָאן מוּצָרִי", translation = "day-1 продукт (продукт первого дня)",
            definition = "מַצַּב הַהַצָּעוֹת בַּיּוֹם הָרִאשׁוֹן אַחֲרֵי שֶׁהָעִסְקָה נִכְנְסָה לְתֹקֶף לִפְנֵי שִׁנּוּיִים.",
            definitionNative = "Состояние предложений в первый день после вступления сделки в силу — до изменений.",
            example = "דֵיי-וָאן מוּצָרִי תֻּכְנַן כָּךְ שֶׁשּׁוּם לָקוֹחַ לֹא יַרְגִּישׁ הֶבְדֵּל.",
            exampleNative = "דֵיי-וָאן מוּצָרִי спланировали так, чтобы ни один клиент не заметил разницы.",
         fillInBlankExclusions = listOf(177911L, 177912L, 177914L, 177915L)),
        WordEntity(
            id = 177914, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_ma", transliteration = "yishur akharei mizug",
            original = "יִישׁוּר אַחֲרֵי מִיזּוּג", translation = "post-merger product alignment",
            definition = "תַּהֲלִיךְ הַתְאָמַת חֲזוֹן וּמַפַּת דֶּרֶךְ בֵּין שְׁתֵּי קְבוּצוֹת פִּתּוּחַ אַחֲרֵי שֶׁאוּחֲדוּ.",
            definitionNative = "Подгонка видения и дорожной карты между двумя командами разработки после объединения.",
            example = "יִישׁוּר אַחֲרֵי מִיזּוּג אָרַךְ תֵּשַׁע חֳדָשִׁים שֶׁל וִיכּוּחִים לְלֹא הֶכְרַע.",
            exampleNative = "יִישׁוּר אַחֲרֵי מִיזּוּג длился девять месяцев бесконечных споров.",
         fillInBlankExclusions = listOf(177911L, 177912L, 177913L, 177915L)),
        WordEntity(
            id = 177915, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_ma", transliteration = "rekhishat hashlama",
            original = "רְכִישַׁת הַשְׁלָמָה", translation = "bolt-on acquisition (точечная покупка)",
            definition = "קְנִיָּה קְטַנָּה שֶׁמּוֹסִיפָה יְכֹלֶת מְסֻיֶּמֶת לַתִּיק הַקַּיָּם בְּלִי לְשַׁנּוֹת אֶת מִבְנֵה הַחֶבְרָה.",
            definitionNative = "Маленькая покупка — добавляет конкретную способность к набору без перестройки фирмы.",
            example = "רְכִישַׁת הַשְׁלָמָה שֶׁל סְטַארְט-אַפּ זָעִיר הוֹסִיפָה לָנוּ יְכֹלוֹת אַייאַיי בְּחֳדָשַׁיִם.",
            exampleNative = "רְכִישַׁת הַשְׁלָמָה крошечного стартапа добавила нам AI-возможности за два месяца.",
         fillInBlankExclusions = listOf(177911L, 177912L, 177913L, 177914L)),

        // ── pm_org_design (5) — дизайн PM-организации ──
        WordEntity(
            id = 177916, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_org_design", transliteration = "itsuv irgun pi-em",
            original = "עִצּוּב אִרְגּוּן פִּי-אֵם", translation = "PM org design (дизайн PM-организации)",
            definition = "הַחְלָטָה אֵיךְ לְחַלֵּק מְנַהֲלֵי מוּצָר לִקְבוּצוֹת לְפִי אֵזוֹרִים, פְּלַטְפוֹרְמוֹת וּלְקוּחוֹת.",
            definitionNative = "Решение — как разделить продактов на группы по зонам, платформам и клиентам.",
            example = "עִצּוּב אִרְגּוּן פִּי-אֵם נֶעֱשָׂה מֵחָדָשׁ אַחֲרֵי הַכְפָּלַת הַצֶּוֶות.",
            exampleNative = "עִצּוּב אִרְגּוּן פִּי-אֵם переделали после удвоения команды.",
         fillInBlankExclusions = listOf(177917L, 177918L, 177919L, 177920L)),
        WordEntity(
            id = 177917, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_org_design", transliteration = "model embedded",
            original = "מוֹדֶל מְשֻׁבָּץ", translation = "embedded PM model (встроенный продакт)",
            definition = "צוּרָה שֶׁבָּהּ מְנַהֵל מוּצָר יוֹשֵׁב יוֹם-יוֹם בְּתוֹךְ צֶוֶות הַנְדָּסָה אֶחָד וְלֹא בְּמַחְלָקָה נִפְרֶדֶת.",
            definitionNative = "Способ, при котором продакт ежедневно сидит внутри одной инженерной команды, а не в отдельном отделе.",
            example = "מוֹדֶל מְשֻׁבָּץ הוֹרִיד אֶת זְמַן הַתְּגוּבָה שֶׁל הַצְּוָתִים בַּחֲצִי.",
            exampleNative = "מוֹדֶל מְשֻׁבָּץ снизил время реакции команд вдвое.",
         fillInBlankExclusions = listOf(177916L, 177918L, 177919L, 177920L)),
        WordEntity(
            id = 177918, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_org_design", transliteration = "platforma pi-em",
            original = "פִּי-אֵם פְּלַטְפוֹרְמָה", translation = "platform PM (продакт платформы)",
            definition = "פִּי-אֵם שֶׁעוֹבֵד עַל תַּשְׁתִּית פְּנִימִית שֶׁמְּשַׁמֶּשֶׁת אֶת כָּל שְׁאָר צְוָתֵי הַמּוּצָר.",
            definitionNative = "Продакт, который работает над внутренней инфраструктурой — её используют все остальные команды.",
            example = "פִּי-אֵם פְּלַטְפוֹרְמָה הִשְׁקִיעַ חֲצִי שָׁנָה בִּבְנִיַּת מַעֲרֶכֶת הַתְרָאוֹת אַחַת.",
            exampleNative = "פִּי-אֵם פְּלַטְפוֹרְמָה вложил полгода в построение единой системы уведомлений.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(177901L, 177902L, 177903L, 177904L, 177905L, 177916L, 177917L, 177919L, 177920L)),
        WordEntity(
            id = 177919, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_org_design", transliteration = "sulam karyera",
            original = "סֻלַּם קַרְיֶרָה", translation = "career ladder (карьерная лестница продактов)",
            definition = "מַסְמָךְ שֶׁמְּתָאֵר אֵיזוֹ דַּרְגוֹת קַיָּמוֹת בַּתַּפְקִיד וּמָה צָרִיךְ לַעֲשׂוֹת לַעֲבֹר מֵאַחַת לַשְּׁנִיָּה.",
            definitionNative = "Документ — какие ступени существуют в роли и что нужно сделать, чтобы перейти выше.",
            example = "סֻלַּם קַרְיֶרָה בָּרוּר הוּא אֶחָד מִכְּלֵי שִׁמּוּר עוֹבְדִים הַחֲזָקִים.",
            exampleNative = "Чёткий סֻלַּם קַרְיֶרָה — один из мощных инструментов удержания сотрудников.",
         fillInBlankExclusions = listOf(177916L, 177917L, 177918L, 177920L)),
        WordEntity(
            id = 177920, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_org_design", transliteration = "maslul ai-si",
            original = "מַסְלוּל אַיי-סִי", translation = "IC track (трек individual contributor)",
            definition = "אֶפְשָׁרוּת קִידוּם לְעֹמֶק מִקְצוֹעִי לְלֹא חוֹבָה לְנַהֵל אֲחֵרִים — לְעוֹבְדִים שֶׁאוֹהֲבִים פִּתְרוֹן בְּעָיוֹת.",
            definitionNative = "Возможность роста в глубину профессии — без обязанности руководить, для тех, кто любит решать задачи.",
            example = "מַסְלוּל אַיי-סִי נִפְתָּח רַק בְּחָמֵשׁ הַשָּׁנִים הָאַחֲרוֹנוֹת בְּחֶבְרוֹת אִיסְרְאֵלִיּוֹת.",
            exampleNative = "מַסְלוּל אַיי-סִי открыли только за последние пять лет в израильских компаниях.",
         fillInBlankExclusions = listOf(177916L, 177917L, 177918L, 177919L)),

        // ── pm_advanced_concepts (5) — продвинутые концепции и фреймворки ──
        WordEntity(
            id = 177921, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_advanced_concepts", transliteration = "mapat vordli",
            original = "מַפַּת וָורְדְלִי", translation = "Wardley map (карта Уордли)",
            definition = "תַּרְשִׁים שֶׁמַּרְאֶה לְאָן רְכִיבֵי הַמַּעֲרֶכֶת זָזִים מִחִדּוּשׁ לַאֲחִידוּת לְאֹרֶךְ זְמַן.",
            definitionNative = "Схема — куда движутся компоненты системы от новизны к стандартизации со временем.",
            example = "מַפַּת וָורְדְלִי גִּלְּתָה שֶׁכֻּלָּנוּ בּוֹנִים תַּשְׁתִּית שֶׁכְּבָר זוֹלָה בַּעֲנָן.",
            exampleNative = "מַפַּת וָורְדְלִי показала: мы строим инфраструктуру, что в облаке уже копеечная.",
         fillInBlankExclusions = listOf(177922L, 177923L, 177924L, 177925L)),
        WordEntity(
            id = 177922, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_advanced_concepts", transliteration = "masgeret jobs maamika",
            original = "מַסְגֶּרֶת ג'וֹבְּס מַעֲמִיקָה", translation = "JTBD framework углублённый",
            definition = "גִּישָׁה מַעֲמִיקָה שֶׁבּוֹדֶקֶת לֹא רַק אֵיזוֹ מְשִׂימָה הַלָּקוֹחַ פּוֹתֵר אֶלָּא גַּם רַגְשׁוֹת וְהֶקְשֵׁר.",
            definitionNative = "Глубокий подход — изучает не только задачу клиента, но и его эмоции и контекст.",
            example = "מַסְגֶּרֶת ג'וֹבְּס מַעֲמִיקָה הוֹבִילָה אוֹתָנוּ לְעַצֵּב מָסַךְ אַחֵר לְגַמְרֵי.",
            exampleNative = "מַסְגֶּרֶת ג'וֹבְּס מַעֲמִיקָה привела нас к совершенно иному дизайну экрана.",
         fillInBlankExclusions = listOf(177921L, 177923L, 177924L, 177925L)),
        WordEntity(
            id = 177923, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_advanced_concepts", transliteration = "model kano",
            original = "מוֹדֶל קַאנוֹ", translation = "Kano model (модель Кано)",
            definition = "כְּלִי שֶׁמְּסַוֵּג יְכֹלוֹת לְאַרְבָּעָה סוּגִים — חוֹבָה, רְצוּיוֹת, מַפְתִּיעוֹת וְשִׁכְבָּת אֲדִישׁוּת.",
            definitionNative = "Инструмент — делит возможности на четыре типа: обязательные, желаемые, удивляющие и безразличные.",
            example = "מוֹדֶל קַאנוֹ עָזַר לִקְבֹּעַ אֵיזוֹ פִיצֶ'רִים בֶּאֱמֶת יִשְׂמְחוּ אֶת הַלָּקוֹחוֹת.",
            exampleNative = "מוֹדֶל קַאנוֹ помог решить — какие фичи действительно обрадуют клиентов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177924, setId = 1779, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_advanced_concepts", transliteration = "matritsat raki",
            original = "מַטְרִיצַת רַאקִ\"י", translation = "RACI matrix (матрица RACI)",
            definition = "טַבְלָה שֶׁמְּחַלֶּקֶת תַּפְקִידִים בִּפְרוֹיֶיקְט לְאַרְבָּעָה סוּגִים — מְבַצֵּעַ, אַחְרַאי, מְיַעֵץ וּמְעֻדְכָּן.",
            definitionNative = "Таблица — делит роли в проекте на четыре вида: исполнитель, ответственный, советник и информируемый.",
            example = "מַטְרִיצַת רַאקִ\"י לְהַשָּׁקַת הַמּוּצָר נִבְנְתָה בְּמִפְגָּשׁ אֶחָד שֶׁל שְׁעָתַיִם.",
            exampleNative = "מַטְרִיצַת רַאקִ\"י для запуска продукта построили за одну встречу в два часа.",
         fillInBlankExclusions = listOf(177921L, 177922L, 177923L, 177925L)),
        WordEntity(
            id = 177925, setId = 1779, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_advanced_concepts", transliteration = "pi-el-ji",
            original = "פִּי-אֶל-גִ'י", translation = "PLG (product-led growth)",
            definition = "גִּישָׁה שֶׁבָּהּ הַהַצָּעָה עַצְמָהּ מוֹשֶׁכֶת מִשְׁתַּמְּשִׁים חֲדָשִׁים בְּלִי תְּלוּת בְּמַעֲרָךְ מְכִירוֹת אַקְטִיבִי.",
            definitionNative = "Подход, в котором само предложение привлекает новых юзеров — без активной службы продаж.",
            example = "פִּי-אֶל-גִ'י הוּא הַסּוֹד שֶׁל סְלַאק וְשֶׁל פִיגְמָה בִּשְׁנוֹת הַצְּמִיחָה הַמְּהִירָה.",
            exampleNative = "פִּי-אֶל-גִ'י — это секрет Slack и Figma в годы быстрого роста.",
         fillInBlankExclusions = listOf(177921L, 177922L, 177923L, 177924L)),
    )
}
