package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Продуктовый менеджмент", L3 «Углублённый» (RARE+EPIC).
 *
 * Set 1765: «Продуктовый менеджмент» — углублённый L3:
 *           Базовые навыки PM: исследования, планирование, метрики, коммуникация.
 *
 * Тема ориентирована на русскоязычных репатриантов, входящих в роль PM
 * в израильском хайтеке. Лексика отражает реальную PM-речь в офисах
 * Тель-Авива и Герцлии: множество английских заимствований
 * (פֶּרְסוֹנָה, פִּי-אַר-דִּי, יוּזֶר סְטוֹרִי, נוֹרְט סְטָאר, גוֹ-טוּ-מַארְקֶט, דִּיסְקָבֶרִי,
 * אִיטֵרַצְיָה) — так реально говорят на discovery-сессиях и planning-митингах.
 *
 * Намеренно НЕ дублирует Хайтек L4 (1748): KPI, OKR, retention, roadmap,
 * stakeholder уже там как корпоративные термины — здесь PM-специфичные ракурсы:
 * נוֹרְט סְטָאר вместо KPI, דַּאוּ вместо retention, בַּעֲלֵי עִנְיָן вместо
 * stakeholder. С PM L4 (1766) тоже нет дублей: там стратегия, growth и P&L.
 * С Собеседования L3 (1750) пересечений нет: рекрутер/портфолио — HR.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC.
 *
 * SemanticGroups (5 × 5):
 *   pm_research       — исследования: user interview, опрос, persona, JTBD, customer feedback
 *   pm_planning       — планирование: PRD, product backlog, sprint planning, prioritization, user story
 *   pm_metrics        — метрики: north star, conversion rate, DAU, engagement, customer journey
 *   pm_collaboration  — коммуникация: stakeholder alignment, design review, eng spec, GTM, launch checklist
 *   pm_lifecycle      — жизненный цикл: discovery, assumption test, build, ship, iterate
 *
 * Word IDs: setId × 100 + position (176501..176525).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewPmL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1765, languagePair = "he-ru", orderIndex = 1765,
            name = "Продуктовый менеджмент",
            description = "Базовые навыки PM: исследования, планирование, метрики, коммуникация",
            topic = "Продуктовый менеджмент", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1765 — Продуктовый менеджмент: углублённый (L3, RARE+EPIC)
        // 5 групп × 5 слов: research, planning, metrics, collaboration, lifecycle
        // ══════════════════════════════════════════════════════════════════════

        // ── pm_research (5) — исследования и понимание пользователя ──
        WordEntity(
            id = 176501, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_research", transliteration = "reayon mishtamshim",
            original = "רֵאָיוֹן מִשְׁתַּמְּשִׁים", translation = "интервью с пользователями",
            definition = "שִׂיחָה אִישִׁית עִם אָדָם מֵהַקָּהָל — לְהָבִין אֵיךְ הוּא חַי וּמָה כּוֹאֵב לוֹ.",
            definitionNative = "Личный разговор с человеком из аудитории — понять, как он живёт и что у него болит.",
            example = "רֵאָיוֹן מִשְׁתַּמְּשִׁים אֶחָד גִּלָּה לָנוּ בַּעֲיָה שֶׁלֹּא הִכַּרְנוּ.",
            exampleNative = "Один רֵאָיוֹן מִשְׁתַּמְּשִׁים открыл нам проблему, о которой мы не знали.",
         fillInBlankExclusions = listOf(176502L, 176503L, 176504L, 176505L)),
        WordEntity(
            id = 176502, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_research", transliteration = "seker",
            original = "סֶקֶר", translation = "опрос",
            definition = "שְׁאֵלוֹת זֵהוּת לְהַרְבֵּה אַנָשִׁים בְּבַת אַחַת — לִקְבֹּל מַסְפָּרִים וְלֹא רַק סִפּוּר.",
            definitionNative = "Одинаковая анкета сразу для многих людей — получить числа, а не только истории.",
            example = "שָׁלַחְנוּ סֶקֶר קָצָר וְקִבַּלְנוּ אֶלֶף תְּשׁוּבוֹת בְּיוֹמַיִם.",
            exampleNative = "Мы разослали короткий סֶקֶר и получили тысячу ответов за два дня.",
         fillInBlankExclusions = listOf(176501L, 176503L, 176504L, 176505L)),
        WordEntity(
            id = 176503, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_research", transliteration = "personah",
            original = "פֶּרְסוֹנָה", translation = "персона (типичный пользователь)",
            definition = "דְּמוּת מְדֻמְיֶנֶת שֶׁמְּסַכֶּמֶת קְבוּצַת לָקוֹחוֹת אֲמִיתִּית עִם שֵׁם, גִּיל וְצֹרֶךְ עִקָּרִי.",
            definitionNative = "Воображаемая фигура — сводит группу клиентов к имени, возрасту и главной нужде.",
            example = "בָּנִינוּ פֶּרְסוֹנָה שֶׁל אִמָּא עוֹבֶדֶת בַּת שְׁלוֹשִׁים וּשְׁמוֹנֶה.",
            exampleNative = "Мы построили פֶּרְסוֹנָה работающей мамы тридцати восьми лет.",
         fillInBlankExclusions = listOf(176501L, 176502L, 176504L, 176505L)),
        WordEntity(
            id = 176504, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_research", transliteration = "jobs tu bi dan",
            original = "ג׳וֹבְּס טוּ בִּי דָּאן", translation = "jobs to be done (JTBD)",
            definition = "גִּישָׁה שֶׁשּׁוֹאֶלֶת לְשֵׁם אֵיזוֹ מְשִׂימָה אֲנָשִׁים מַעֲסִיקִים אֶת הַמּוּצָר בְּחַיֵּיהֶם.",
            definitionNative = "Подход: ради какой задачи в жизни люди «нанимают» продукт.",
            example = "ג׳וֹבְּס טוּ בִּי דָּאן עָזַר לָנוּ לְהָבִין שֶׁמַּתְחָרִים שֶׁלָּנוּ הֵם וֵוייז וּסְפּוֹטִיפַי.",
            exampleNative = "ג׳וֹבְּס טוּ בִּי דָּאן помог понять — наши конкуренты Waze и Spotify.",
         fillInBlankExclusions = listOf(176501L, 176502L, 176503L, 176505L)),
        WordEntity(
            id = 176505, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_research", transliteration = "mishuv lakokhot",
            original = "מִשּׁוּב לָקוֹחוֹת", translation = "обратная связь от клиентов",
            definition = "הֶעָרוֹת וְתְלוּנוֹת שֶׁמַּגִּיעוֹת אַחֲרֵי שִׁמּוּשׁ בַּמּוּצָר — בְּצַ׳אט, בְּדֹאַר אוֹ בִּסְקָרִים.",
            definitionNative = "Замечания и жалобы после использования продукта — в чате, почте или опросах.",
            example = "מִשּׁוּב לָקוֹחוֹת מֵהַחֹדֶשׁ הָאַחֲרוֹן הִצְבִּיעַ עַל בָּעיוֹת בָּאוֹנְבּוֹרְדִּינְג.",
            exampleNative = "מִשּׁוּב לָקוֹחוֹת за последний месяц указал на проблемы в онбординге.",
         fillInBlankExclusions = listOf(176501L, 176502L, 176503L, 176504L)),

        // ── pm_planning (5) — планирование работы ──
        WordEntity(
            id = 176506, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_planning", transliteration = "pi-ar-di",
            original = "פִּי-אַר-דִּי", translation = "PRD (документ требований к продукту)",
            definition = "מִסְמָךְ מְפֹרָט שֶׁמְּתָאֵר מָה הַפִיצֶ׳ר עוֹשֶׂה, לְמִי הוּא וְאֵיךְ נָדַע שֶׁהִצְלִיחַ.",
            definitionNative = "Подробный документ — что делает фича, для кого и как поймём, что удалась.",
            example = "כָּתַבְתִּי פִּי-אַר-דִּי בָּהִיר וְהַצֶּוֶות אִשֵּׁר אוֹתוֹ בְּלִי שְׁאֵלוֹת.",
            exampleNative = "Я написал чёткий פִּי-אַר-דִּי, и команда утвердила его без вопросов.",
         fillInBlankExclusions = listOf(176507L, 176508L, 176509L, 176510L)),
        WordEntity(
            id = 176507, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_planning", transliteration = "baklog mutsar",
            original = "בַּקְלוֹג מוּצָר", translation = "беклог продукта",
            definition = "רְשִׁימָה מְסֻדֶּרֶת שֶׁל כָּל הָעֲבוֹדוֹת הֶעֲתִידִיּוֹת עַל הַמּוּצָר — מִן הַחָשׁוּב לַפָּחוֹת.",
            definitionNative = "Упорядоченный список всех будущих работ над продуктом — от важного к менее важному.",
            example = "בַּקְלוֹג מוּצָר שֶׁלָּנוּ גָּדַל לִשְׁתַּיִם מֵאוֹת מְשִׂימוֹת בִּתְחִלַּת הַשָּׁנָה.",
            exampleNative = "Наш בַּקְלוֹג מוּצָר вырос до двухсот задач к началу года.",
         fillInBlankExclusions = listOf(176506L, 176508L, 176509L, 176510L)),
        WordEntity(
            id = 176508, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_planning", transliteration = "tikhnun sprint",
            original = "תִּכְנוּן סְפְּרִינְט", translation = "планирование спринта",
            definition = "מִפְגָּשׁ בְּתְחִלַּת שָׁבוּעַיִם שֶׁבּוֹ הַצֶּוֶות בּוֹחֵר אֵיזוֹ מְשִׂימוֹת לְבַצֵּעַ עַד הַסּוֹף.",
            definitionNative = "Встреча в начале двух недель: команда выбирает, какие задачи довести до конца.",
            example = "תִּכְנוּן סְפְּרִינְט הַשָּׁבוּעַ לָקַח שָׁעָה וָחֵצִי בִּלְבַד.",
            exampleNative = "תִּכְנוּן סְפְּרִינְט на этой неделе занял всего полтора часа.",
         fillInBlankExclusions = listOf(176506L, 176507L, 176509L, 176510L)),
        WordEntity(
            id = 176509, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_planning", transliteration = "tiadduf",
            original = "תִּעְדוּף", translation = "приоритизация",
            definition = "הַחְלָטָה מָה לַעֲשׂוֹת רִאשׁוֹן וּמָה לִדְחוֹת — לְפִי עֵרֶךְ לַלָּקוֹחַ וְעֲלוּת לְצֶוֶות.",
            definitionNative = "Решение — что делать первым, что отложить — по ценности клиенту и стоимости команде.",
            example = "תִּעְדוּף נָכוֹן חוֹסֵךְ חֳדָשִׁים שֶׁל פִּתּוּחַ עַל פִיצֶ׳רִים שֶׁאַף אֶחָד לֹא רוֹצֶה.",
            exampleNative = "Правильный תִּעְדוּף экономит месяцы разработки на ненужных фичах.",
         fillInBlankExclusions = listOf(176506L, 176507L, 176508L, 176510L)),
        WordEntity(
            id = 176510, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_planning", transliteration = "yuzer stori",
            original = "יוּזֶר סְטוֹרִי", translation = "user story (история пользователя)",
            definition = "מִשְׁפָּט קָצָר בִּפוֹרְמָט «כְּמִישֶׁהוּ אֲנִי רוֹצֶה X כְּדֵי לְהַשִּׂיג Y» — כָּכָה כּוֹתְבִים דְּרִישׁוֹת.",
            definitionNative = "Короткая фраза «как такой-то я хочу X, чтобы Y» — так пишут требования.",
            example = "כָּל יוּזֶר סְטוֹרִי בַּסְּפְּרִינְט קִבֵּל קְרִיטֶרְיוֹן קַבָּלָה בָּהִיר.",
            exampleNative = "Каждая יוּזֶר סְטוֹרִי в спринте получила чёткий критерий приёмки.",
         fillInBlankExclusions = listOf(176506L, 176507L, 176508L, 176509L)),

        // ── pm_metrics (5) — продуктовые метрики ──
        WordEntity(
            id = 176511, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_metrics", transliteration = "nort star",
            original = "נוֹרְט סְטָאר", translation = "north star (главная метрика продукта)",
            definition = "הַמַּדָּד הַיָּחִיד שֶׁמְּסַמֵּן אִם הַמּוּצָר בֶּאֱמֶת מַבִּיא עֵרֶךְ לַלָּקוֹחוֹת לְאֹרֶךְ זְמַן.",
            definitionNative = "Единственный показатель — реально ли продукт даёт ценность клиентам со временем.",
            example = "נוֹרְט סְטָאר שֶׁל סְפּוֹטִיפַי הוּא דַּקּוֹת הַאֲזָנָה לְמִשְׁתַּמֵּשׁ.",
            exampleNative = "נוֹרְט סְטָאר у Spotify — минуты прослушивания на пользователя.",
         fillInBlankExclusions = listOf(176512L, 176513L, 176514L, 176515L)),
        WordEntity(
            id = 176512, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_metrics", transliteration = "shiur hamara",
            original = "שִׁעוּר הַמָּרָה", translation = "коэффициент конверсии",
            definition = "אָחוּז הָאַנָשִׁים שֶׁעָבְרוּ אֶת הַשָּׁלָב הַמְּבֻקָּשׁ — לְמָשָׁל נִרְשְׁמוּ אַחֲרֵי כְּנִיסָה לַדַּף.",
            definitionNative = "Доля людей, прошедших нужный шаг — например, зарегистрировались после захода на страницу.",
            example = "שִׁעוּר הַהַמָּרָה שֶׁל דַּף הַנְּחִיתָה עָלָה מִשְּׁנֵי אֲחוּזִים לַחֲמִשָּׁה.",
            exampleNative = "שִׁעוּר הַמָּרָה лендинга вырос с двух процентов до пяти.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176513, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_metrics", transliteration = "dau",
            original = "דַּאוּ", translation = "DAU (ежедневные активные пользователи)",
            definition = "מַסְפַּר הָאַנָשִׁים הַשּׁוֹנִים שֶׁנִּכְנְסוּ לַמּוּצָר בְּמֶשֶׁךְ יוֹם אֶחָד שֶׁלָּם.",
            definitionNative = "Число разных людей, заходивших в продукт за один сутки.",
            example = "דַּאוּ קָפַץ מֵעֶשְׂרִים אֶלֶף לְשִׁבְעִים אֶלֶף אַחֲרֵי שֶׁעָלִינוּ לִטְלִיוִיזְיָה.",
            exampleNative = "דַּאוּ скакнул с двадцати тысяч до семидесяти после выхода на телевидение.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176514, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_metrics", transliteration = "meuravut",
            original = "מְעֻרָבוּת", translation = "вовлечённость",
            definition = "הַמִּדָּה שֶׁבָּהּ אַנָשִׁים פּוֹעֲלִים בַּמּוּצָר — לוֹחֲצִים, גּוֹלְלִים, מַשְׁאִירִים תְּגוּבוֹת.",
            definitionNative = "Насколько люди действуют в продукте — кликают, скроллят, оставляют комментарии.",
            example = "מְעֻרָבוּת בַּפִיד יָרְדָה אַחֲרֵי שֶׁשִּׁנִּינוּ אֶת הָאַלְגוֹרִיתְם.",
            exampleNative = "מְעֻרָבוּת в ленте упала после того, как мы поменяли алгоритм.",
         fillInBlankExclusions = listOf(176511L, 176512L, 176513L, 176515L)),
        WordEntity(
            id = 176515, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_metrics", transliteration = "masa lakoakh",
            original = "מַסַּע לָקוֹחַ", translation = "путь клиента (customer journey)",
            definition = "תֵּאוּר שָׁלָב אַחַר שָׁלָב שֶׁל מָה שֶׁמַּרְגִּישׁ לָקוֹחַ מֵהָרֶגַע הָרִאשׁוֹן וְעַד הַקְּנִיָּה.",
            definitionNative = "Шаг за шагом — что чувствует клиент с первого момента и до покупки.",
            example = "מִפַּרְנוּ אֶת מַסַּע הַלָּקוֹחַ עַל הַלּוּחַ וְגִלִּינוּ שִׁשָּׁה נְקֻדּוֹת חִכּוּךְ.",
            exampleNative = "Мы расписали מַסַּע לָקוֹחַ на доске и нашли шесть точек трения.",
            isFillInBlankSafe = false,
        ),

        // ── pm_collaboration (5) — работа со смежниками ──
        WordEntity(
            id = 176516, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_collaboration", transliteration = "teum baalei inyan",
            original = "תֵּאוּם בַּעֲלֵי עִנְיָן", translation = "согласование со смежниками",
            definition = "מִפְגָּשׁ אוֹ סְבִיבַת שְׁלִיחוֹת שֶׁבָּהּ מְפַתֵּחַ הַמּוּצָר מַשִּׂיג הַסְכָּמָה מִכָּל הַגְּזָרוֹת.",
            definitionNative = "Встреча или серия писем — продакт получает согласие от всех заинтересованных отделов.",
            example = "תֵּאוּם בַּעֲלֵי עִנְיָן לָקַח שָׁבוּעַ עַד שֶׁיָּצָאנוּ לְפִתּוּחַ.",
            exampleNative = "תֵּאוּם בַּעֲלֵי עִנְיָן занял неделю, пока мы вышли на разработку.",
         fillInBlankExclusions = listOf(176517L, 176518L, 176519L, 176520L)),
        WordEntity(
            id = 176517, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_collaboration", transliteration = "skirat itsuv",
            original = "סְקִירַת עִצּוּב", translation = "design review",
            definition = "מִפְגָּשׁ קָצָר שֶׁבּוֹ מְעַצֵּב מַצִּיג הַצָּעוֹת לְמָסַךְ וְהַצֶּוֶות נוֹתֵן הֶעָרוֹת לְפִי קוֹמְפּוֹנֶנְטִים.",
            definitionNative = "Короткая встреча: дизайнер показывает варианты экранов, а команда даёт замечания по компонентам.",
            example = "סְקִירַת עִצּוּב לְמָסַךְ הַתַּשְׁלוּם נִקְבְּעָה לְיוֹם רְבִיעִי בְּשָׁלוֹשׁ.",
            exampleNative = "סְקִירַת עִצּוּב для экрана оплаты назначили на среду в три.",
         fillInBlankExclusions = listOf(176516L, 176518L, 176519L, 176520L)),
        WordEntity(
            id = 176518, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_collaboration", transliteration = "mifrat handasi",
            original = "מִפְרָט הַנְדָּסִי", translation = "инженерная спецификация",
            definition = "מִסְמָךְ שֶׁכּוֹתֵב מְהַנְדֵּס לִפְנֵי קִידוּד — אֵיךְ הַמַּעֲרֶכֶת תְּמַלֵּא אֶת דְּרִישׁוֹת הַמּוּצָר.",
            definitionNative = "Документ инженера до кодинга — как система выполнит требования продукта.",
            example = "מִפְרָט הַנְדָּסִי הוּכַן עַל יְדֵי הַטֵּק לִיד אַחֲרֵי שֶׁאִישַׁרְתִּי אֶת הַפִּי-אַר-דִּי.",
            exampleNative = "מִפְרָט הַנְדָּסִי подготовил тимлид после того, как я утвердил PRD.",
         fillInBlankExclusions = listOf(176516L, 176517L, 176519L, 176520L)),
        WordEntity(
            id = 176519, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_collaboration", transliteration = "go-tu-market",
            original = "גוֹ-טוּ-מַארְקֶט", translation = "go-to-market (стратегия выхода)",
            definition = "תָּכְנִית כּוֹלֶלֶת אֵיךְ מַגִּיעִים לְלָקוֹחוֹת רִאשׁוֹנִים — שִׁוּוּק, מְחִירוֹן וְעַרוּצֵי מְכִירָה.",
            definitionNative = "Общий план — как добраться до первых клиентов: маркетинг, цены и каналы продаж.",
            example = "גוֹ-טוּ-מַארְקֶט לְשׁוּק הָאַמֵרִיקַאי דָּרַשׁ שֻׁתָּפִים מְקוֹמִיִּים.",
            exampleNative = "גוֹ-טוּ-מַארְקֶט на американский рынок потребовал местных партнёров.",
         fillInBlankExclusions = listOf(176516L, 176517L, 176518L, 176520L)),
        WordEntity(
            id = 176520, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_collaboration", transliteration = "checklist hashaka",
            original = "צֶ׳קְלִיסְט הַשָּׁקָה", translation = "чеклист запуска",
            definition = "רְשִׁימַת בְּדִיקוֹת לִפְנֵי שֶׁפִיצֶ׳ר חָדָשׁ פּוֹתֵחַ לַכֹּל — תִּעְוּד, תְּמִיכָה וְתִקְשֹׁרֶת.",
            definitionNative = "Список проверок до открытия фичи всем — документация, поддержка и коммуникации.",
            example = "צֶ׳קְלִיסְט הַשָּׁקָה הָיָה מָלֵא לְגַמְרֵי לִפְנֵי הַסְּגִירָה הָאַחֲרוֹנָה.",
            exampleNative = "צֶ׳קְלִיסְט הַשָּׁקָה был полностью закрыт перед финальным гейтом.",
         fillInBlankExclusions = listOf(176516L, 176517L, 176518L, 176519L)),

        // ── pm_lifecycle (5) — фазы жизненного цикла продукта ──
        WordEntity(
            id = 176521, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_lifecycle", transliteration = "diskaveri",
            original = "דִּיסְקָבֶרִי", translation = "discovery (стадия исследования)",
            definition = "שָׁלָב לִפְנֵי כְּתִיבַת קוֹד שֶׁבּוֹ מְבָרְרִים מָה כּוֹאֵב לַלָּקוֹחַ וְאִם בִּכְלָל כְּדַאי לִפְתֹּחַ.",
            definitionNative = "Стадия до кодинга — выясняют, что у клиента болит и стоит ли вообще делать.",
            example = "דִּיסְקָבֶרִי שֶׁל הַפִיצֶ׳ר הֶחָדָשׁ נִמְשַׁךְ שִׁשָּׁה שָׁבוּעוֹת שְׁלֵמִים.",
            exampleNative = "דִּיסְקָבֶרִי новой фичи длился целых шесть недель.",
         fillInBlankExclusions = listOf(176522L, 176523L, 176524L, 176525L)),
        WordEntity(
            id = 176522, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_lifecycle", transliteration = "bdikat hanakha",
            original = "בְּדִיקַת הַנָּחָה", translation = "проверка гипотезы",
            definition = "נִסּוּי קָטָן וּזָרִיז שֶׁמַּרְאֶה אִם אֲמִירָה עַל הַשּׁוּק נְכוֹנָה לִפְנֵי הַשְׁקָעַת קוֹד.",
            definitionNative = "Маленький быстрый эксперимент — верно ли утверждение о рынке, до вложения кода.",
            example = "בְּדִיקַת הַנָּחָה עִם דַּף נְחִיתָה הוֹכִיחָה שֶׁאַף אֶחָד לֹא רוֹצֶה אֶת הַפִיצֶ׳ר.",
            exampleNative = "בְּדִיקַת הַנָּחָה с лендингом доказала: фича никому не нужна.",
         fillInBlankExclusions = listOf(176521L, 176523L, 176524L, 176525L)),
        WordEntity(
            id = 176523, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_lifecycle", transliteration = "shlav pituakh",
            original = "שְׁלַב פִּתּוּחַ", translation = "стадия разработки",
            definition = "פֶּרֶק זְמַן שֶׁבּוֹ הַצֶּוֶות בּוֹנֶה אֶת הַפִיצֶ׳ר עַל פִּי הַמִּפְרָט וְעוֹשֶׂה בְּדִיקוֹת פְנִימִיּוֹת.",
            definitionNative = "Период, когда команда строит фичу по спецификации и проверяет её внутри.",
            example = "שְׁלַב פִּתּוּחַ נִמְשַׁךְ שְׁמוֹנָה שָׁבוּעוֹת בִּגְלַל אִינְטֶגְרַצְיוֹת רְחָבוֹת.",
            exampleNative = "שְׁלַב פִּתּוּחַ длился восемь недель из-за широких интеграций.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176524, setId = 1765, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_lifecycle", transliteration = "aliya leavir",
            original = "עֲלִיָּה לְאֲוִיר", translation = "выпуск (запуск в эфир)",
            definition = "הָרֶגַע שֶׁבּוֹ הַפִיצֶ׳ר נִפְתָּח לְכָל הַלָּקוֹחוֹת אַחֲרֵי בְּדִיקוֹת וְאִישּׁוּרִים סוֹפִיִּים.",
            definitionNative = "Момент, когда фичу открывают всем клиентам после финальных проверок и согласований.",
            example = "עֲלִיָּה לְאֲוִיר נִדְחֲתָה בְּשָׁבוּעַ בִּגְלַל בָּאג חָמוּר בָּאוֹנְבּוֹרְדִּינְג.",
            exampleNative = "עֲלִיָּה לְאֲוִיר перенесли на неделю из-за серьёзного бага в онбординге.",
         fillInBlankExclusions = listOf(176521L, 176522L, 176523L, 176525L)),
        WordEntity(
            id = 176525, setId = 1765, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_lifecycle", transliteration = "iteratsya",
            original = "אִיטֵרַצְיָה", translation = "итерация (цикл доработки)",
            definition = "סִבּוּב נוֹסָף שֶׁל שִׁפּוּר אַחֲרֵי שֶׁמַּמְצִיאִים מָה לֹא עָבַד וְלוֹמְדִים מִמֶּנּוּ לֶעֳבוֹדָה הַבָּאָה.",
            definitionNative = "Очередной круг улучшений — после того, как ясно, что не сработало.",
            example = "אַחֲרֵי אִיטֵרַצְיָה שְׁלִישִׁית הַצֶּוֶות מָצָא אֶת הָעִצּוּב הַנָּכוֹן.",
            exampleNative = "После третьей אִיטֵרַצְיָה команда нашла правильный дизайн.",
         fillInBlankExclusions = listOf(176521L, 176522L, 176523L, 176524L)),
    )
}
