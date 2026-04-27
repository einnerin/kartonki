package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Продуктовый менеджмент", уровень 4 (профессиональный).
 *
 * Set 1766: «Продуктовый менеджмент» — профессиональный L4 (EPIC + LEGENDARY).
 * Лексика senior PM: продуктовая стратегия, growth-эксперименты, продвинутые
 * релизные практики, бизнес-владение и софт-скиллы лидера команды.
 *
 * Целевая аудитория — русскоязычные репатрианты, работающие продактами в
 * израильских компаниях. Лексика двуязычная: иврит + многочисленные английские
 * заимствования (וִיזְיוֹן, מִישֶׁן, אַייאַי-אַר-אַר-אַר, גְּרוֹאוּת' אֶקְסְפֶּרִימֶנְט,
 * פִיצֶ'ר טוֹגֶל, גְּרֵייְד'וּאֵל רוֹלאַאוּט, רַייס, מוֹסְקוֹאוּ, אֵל-טִי-וִי) — так
 * реально говорят на product review и квартальных планёрках.
 *
 * Распределение редкостей:
 *   13 EPIC + 12 LEGENDARY (без выхода за 2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   pm_strategy  — vision, mission, стратегические OKR, сегментация, competitive moat
 *   pm_growth    — activation, AARRR, viral loop, growth experiment, experimentation velocity
 *   pm_advanced  — feature toggle, gradual rollout, canary release, deprecation, sunset
 *   pm_business  — P&L ownership, pricing strategy, packaging, монетизация, LTV
 *   pm_skills    — cross-functional leadership, conflict resolution, prioritization, RICE, MoSCoW
 *
 * Word IDs: setId × 100 + position (176601..176625).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 *
 * Дифференциация от соседних сетов (важно):
 *   • Hightech L4 (1748): уже занимает KPI, OKR (общий), retention, churn, NPS, roadmap,
 *     stakeholder, gating, A/B-тест, фиче-флаг, дашборд. В этом сете — продуктовая
 *     стратегия и growth, не операционные метрики.
 *   • Startup L5 (1760): growth hacking, виральный коэффициент, юнит-экономика, CAC/LTV
 *     ratio. Здесь — отдельный LTV (אֵל-טִי-וִי) как бизнес-метрика владельца продукта.
 *   • PmL3 (1765, параллельно): KPI, retention, roadmap, stakeholder — не дублируем.
 */
object WordDataHebrewPmL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1766, languagePair = "he-ru", orderIndex = 1766,
            name = "Продуктовый менеджмент",
            description = "Продвинутый PM: стратегия, growth, A/B-тесты, монетизация, фреймворки",
            topic = "Продуктовый менеджмент", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1766 — Продуктовый менеджмент: профессиональный (L4, EPIC + LEGENDARY)
        // 5 групп × 5 слов: strategy, growth, advanced, business, skills
        // ══════════════════════════════════════════════════════════════════════

        // ── pm_strategy (5) — продуктовая стратегия и позиционирование ──
        WordEntity(
            id = 176601, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_strategy", transliteration = "vizyon",
            original = "וִיזְיוֹן", translation = "vision (видение продукта)",
            definition = "תְּמוּנָה רְחוֹקָה שֶׁל מַה הַמּוּצָר אָמוּר לִהְיוֹת עוֹד חָמֵשׁ אוֹ עֶשֶׂר שָׁנִים.",
            definitionNative = "Далёкая картинка — каким продукт должен стать через пять или десять лет.",
            example = "וִיזְיוֹן שֶׁל הַמּוּצָר נִכְתַּב בִּשְׁתַּיִם שׁוּרוֹת קְצָרוֹת וּבְרוּרוֹת.",
            exampleNative = "וִיזְיוֹן продукта уместился в две короткие ясные строки.",
         fillInBlankExclusions = listOf(176602L, 176603L, 176604L, 176605L)),
        WordEntity(
            id = 176602, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_strategy", transliteration = "mishen",
            original = "מִישֶׁן", translation = "mission (миссия продукта)",
            definition = "הַסִּבָּה הַיּוֹמְיוֹמִית לְמַעְשֵׂה הַחֶבְרָה — לְמִי וְלָמָה הִיא קַיֶּמֶת עַכְשָׁו.",
            definitionNative = "Ежедневный смысл существования компании — для кого и зачем она работает сейчас.",
            example = "מִישֶׁן שֶׁל הַסְּטַארְט-אַפּ הָיָה לְפָשֵּׁט תַּשְׁלוּמִים לְעַצְמָאִים.",
            exampleNative = "מִישֶׁן стартапа была — упростить платежи самозанятым.",
         fillInBlankExclusions = listOf(176601L, 176603L, 176604L, 176605L)),
        WordEntity(
            id = 176603, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_strategy", transliteration = "okr-im istrategiyim",
            original = "אוֹ-קֵיי-אַרִים אִסְטְרָטֶגִיִּים", translation = "стратегические OKR",
            definition = "יַעֲדֵי שָׁנָה גְּדוֹלִים שֶׁמְּחַבְּרִים בֵּין כְּלַל הַחֶבְרָה לִקְבוּצוֹת הַפִּתּוּחַ הַשּׁוֹנוֹת.",
            definitionNative = "Большие годовые цели — связывают всю компанию с разными командами разработки.",
            example = "אוֹ-קֵיי-אַרִים אִסְטְרָטֶגִיִּים שֶׁל הַשָּׁנָה דּוּרְגוּ לְפִי הַשְׁפָּעָה עַל הַהַכְנָסוֹת.",
            exampleNative = "אוֹ-קֵיי-אַרִים אִסְטְרָטֶגִיִּים на год расставили по влиянию на выручку.",
         fillInBlankExclusions = listOf(176601L, 176602L, 176604L, 176605L)),
        WordEntity(
            id = 176604, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_strategy", transliteration = "pilug shuk",
            original = "פִּלּוּג שׁוּק", translation = "сегментация рынка",
            definition = "חִתּוּךְ קְהַל הַיַּעַד לִקְבוּצוֹת קְטַנּוֹת לְפִי תְּכוּנוֹת מְשֻׁתָּפוֹת.",
            definitionNative = "Разделение целевой аудитории на маленькие группы по общим признакам.",
            example = "פִּלּוּג שׁוּק חָשַׂף שֶׁשִּׁבְעִים אָחוּז מֵהַהַכְנָסָה מַגִּיעַ מִקְּהַל מְצֻמְצָם.",
            exampleNative = "פִּלּוּג שׁוּק показал, что семьдесят процентов выручки идут от узкой группы.",
         fillInBlankExclusions = listOf(176601L, 176602L, 176603L, 176605L)),
        WordEntity(
            id = 176605, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_strategy", transliteration = "yitron tachari bar-kayama",
            original = "יִתְרוֹן תַּחֲרוּתִי בַּר-קַיָּמָא", translation = "competitive moat (устойчивое преимущество)",
            definition = "מַשֶּׁהוּ קָשֶׁה לְהַעְתָּקָה שֶׁמַּגֵן עַל הַחֶבְרָה מִתַּחֲרוּת לְאֹרֶךְ שָׁנִים.",
            definitionNative = "Что-то трудно копируемое — годами защищает компанию от конкурентов.",
            example = "יִתְרוֹן תַּחֲרוּתִי בַּר-קַיָּמָא נִבְנָה עַל בָּסִיס נְתוּנִים יִחוּדִיִּים שֶׁל הַחֶבְרָה.",
            exampleNative = "יִתְרוֹן תַּחֲרוּתִי בַּר-קַיָּמָא построили на уникальных данных компании.",
         fillInBlankExclusions = listOf(176601L, 176602L, 176603L, 176604L)),

        // ── pm_growth (5) — рост, воронки и эксперименты ──
        WordEntity(
            id = 176606, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_growth", transliteration = "aktivatsya",
            original = "אַקְטִיבַצְיָה", translation = "activation (активация пользователя)",
            definition = "הָרֶגַע שֶׁבּוֹ מִשְׁתַּמֵּשׁ חָדָשׁ הִגִּיעַ לַעֲרֵךְ הָרִאשׁוֹן וְקָלַט בָּמָּה הַמּוּצָר עוֹזֵר לוֹ.",
            definitionNative = "Момент, когда новичок дошёл до первой ценности и понял, чем продукт ему полезен.",
            example = "אַקְטִיבַצְיָה הִתְרַחֲשָׁה אֵצֶל אַרְבָּעִים אָחוּז מֵהַנִּרְשָׁמִים בַּיּוֹם הָרִאשׁוֹן.",
            exampleNative = "אַקְטִיבַצְיָה случилась у сорока процентов зарегистрировавшихся в первый день.",
         fillInBlankExclusions = listOf(176607L, 176608L, 176609L, 176610L)),
        WordEntity(
            id = 176607, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_growth", transliteration = "aiei-ar-ar-ar",
            original = "אַייאַי-אַר-אַר-אַר", translation = "AARRR (воронка пиратских метрик)",
            definition = "מָסְגֶּרֶת חָמֵשׁ שְׁלָבִים שֶׁעוֹקֶבֶת אַחֲרֵי הַמִּשְׁתַּמֵּשׁ מֵהַגַּעַת לַמּוּצָר וְעַד הַמְלָצָה לַחֲבֵרִים.",
            definitionNative = "Рамка из пяти этапов — отслеживает путь юзера от прихода до рекомендации друзьям.",
            example = "אַייאַי-אַר-אַר-אַר הִצְבִּיעַ עַל בַּעֲיָה גְּדוֹלָה דַּוְקָא בִּשְׁלַב הַשִּׁמּוּר.",
            exampleNative = "אַייאַי-אַר-אַר-אַר указал на главную проблему именно на этапе удержания.",
         fillInBlankExclusions = listOf(176606L, 176608L, 176609L, 176610L)),
        WordEntity(
            id = 176608, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_growth", transliteration = "luliat virus",
            original = "לוּלְיַת וִירוּס", translation = "viral loop (вирусная петля)",
            definition = "מַעֲגָל סָגוּר שֶׁבּוֹ כָּל מִשְׁתַּמֵּשׁ פָּעִיל מַזְמִין מִשְׁתַּמְּשִׁים נוֹסָפִים לְלֹא הוֹצָאָה עַל פִּרְסוּם.",
            definitionNative = "Замкнутый круг — каждый активный юзер приводит ещё одного без затрат на рекламу.",
            example = "לוּלְיַת וִירוּס בָּאַפְּלִיקַצְיָה הוֹרִידָה אֶת עֲלוּת הָרְכִישָׁה בַּחֲצִי.",
            exampleNative = "לוּלְיַת וִירוּס в приложении уронила стоимость привлечения вдвое.",
         fillInBlankExclusions = listOf(176606L, 176607L, 176609L, 176610L)),
        WordEntity(
            id = 176609, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_growth", transliteration = "growt eksperiment",
            original = "גְּרוֹאוּת' אֶקְסְפֶּרִימֶנְט", translation = "growth experiment (рост-эксперимент)",
            definition = "בְּדִיקָה קְצָרָה עִם הַשְׁעָרָה בְּרוּרָה עַל אֵיךְ לְהַגְדִּיל מַסְפַּר מִשְׁתַּמְּשִׁים אוֹ הַכְנָסָה.",
            definitionNative = "Короткая проверка с чёткой гипотезой — как увеличить число юзеров или выручку.",
            example = "גְּרוֹאוּת' אֶקְסְפֶּרִימֶנְט עַל מָסָךְ הַתַּשְׁלוּם רָץ בְּמֶשֶׁךְ שְׁבוּעַיִם בִּלְבַד.",
            exampleNative = "גְּרוֹאוּת' אֶקְסְפֶּרִימֶנְט на экране оплаты крутили всего две недели.",
         fillInBlankExclusions = listOf(176606L, 176607L, 176608L, 176610L)),
        WordEntity(
            id = 176610, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_growth", transliteration = "kets ha-nisuim",
            original = "קֶצֶב הַנִּסּוּיִים", translation = "темп экспериментов",
            definition = "מַסְפַּר הַבְּדִיקוֹת שֶׁצֶּוֶות הַמּוּצָר מַצְלִיחַ לְהָרִיץ בְּכָל רֹבַע אוֹ חֹדֶשׁ.",
            definitionNative = "Сколько проверок гипотез продуктовая команда успевает прогнать за квартал или месяц.",
            example = "קֶצֶב הַנִּסּוּיִים הֻכְפַּל אַחֲרֵי הַשְׁקַעַת זְמַן בְּכֵלֵי בְּדִיקָה אוֹטוֹמָטִיִּים.",
            exampleNative = "קֶצֶב הַנִּסּוּיִים удвоился — после вложений в автоматические инструменты тестирования.",
         fillInBlankExclusions = listOf(176606L, 176607L, 176608L, 176609L)),

        // ── pm_advanced (5) — продвинутые релизные практики ──
        WordEntity(
            id = 176611, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_advanced", transliteration = "ficher togel",
            original = "פִיצֶ'ר טוֹגֶל", translation = "feature toggle (переключатель функции)",
            definition = "הַחְלָפָה שֶׁמַּפְעִילָה אוֹ סוֹגֶרֶת יְכֹלֶת לְפִי קְבוּצַת מִשְׁתַּמְּשִׁים בְּלִי מַהֲדוּרָה חֲדָשָׁה.",
            definitionNative = "Переключатель — открывает или закрывает функцию для группы юзеров без новой сборки.",
            example = "פִיצֶ'ר טוֹגֶל אִפְשֵׁר לְהַפְעִיל אֶת הַתַּשְׁלוּם הֶחָדָשׁ רַק לִמְפַתְּחִים פְּנִימִיִּים.",
            exampleNative = "פִיצֶ'ר טוֹגֶל позволил включить новую оплату только внутренним разработчикам.",
         fillInBlankExclusions = listOf(176612L, 176613L, 176614L, 176615L)),
        WordEntity(
            id = 176612, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_advanced", transliteration = "greijdual rolaut",
            original = "גְּרֵייְד'וּאֵל רוֹלאַאוּט", translation = "gradual rollout (постепенный выкат)",
            definition = "פְּתִיחַת יְכֹלֶת בִּהֲדָרָגָה לְאָחוּז גָּדֵל וְהוֹלֵךְ שֶׁל הַקָּהָל לְאוֹרֶךְ יָמִים.",
            definitionNative = "Открытие функции по шагам — растущему проценту аудитории на протяжении нескольких дней.",
            example = "גְּרֵייְד'וּאֵל רוֹלאַאוּט הֵחֵל מֵחָמֵשׁ אָחוּז וְעָלָה לְמֵאָה תּוֹךְ שָׁבוּעַ.",
            exampleNative = "גְּרֵייְד'וּאֵל רוֹלאַאוּט стартовал с пяти процентов и вырос до ста за неделю.",
         fillInBlankExclusions = listOf(176611L, 176613L, 176614L, 176615L)),
        WordEntity(
            id = 176613, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_advanced", transliteration = "kanari rilis",
            original = "קַנָרִי רִילִיס", translation = "canary release (канареечный релиз)",
            definition = "הוֹצָאַת גִּרְסָה חֲדָשָׁה תְּחִלָּה לִקְבוּצָה זְעִירָה כְּדֵי לִתְפֹּס בְּעָיוֹת לִפְנֵי כֻּלָּם.",
            definitionNative = "Выпуск новой версии сначала на крошечную группу — поймать проблемы раньше всех.",
            example = "קַנָרִי רִילִיס חָשַׂף בָּאג חָמוּר עוֹד לִפְנֵי שֶׁהִגִּיעַ לִכְלַל הַמִּשְׁתַּמְּשִׁים.",
            exampleNative = "קַנָרִי רִילִיס выявил серьёзный баг ещё до выкатки на всех юзеров.",
         fillInBlankExclusions = listOf(176611L, 176612L, 176614L, 176615L)),
        WordEntity(
            id = 176614, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_advanced", transliteration = "hotsaa mi-shimush",
            original = "הוֹצָאָה מִשִּׁמּוּשׁ", translation = "deprecation (вывод из обихода)",
            definition = "הַכְרָזָה רִשְׁמִית שֶׁיְּכֹלֶת קַיֶּמֶת תַּפְסִיק לִפְעֹל בְּתַאֲרִיךְ עָתִידִי יָדוּעַ.",
            definitionNative = "Официальное объявление — действующая функция перестанет работать в известную будущую дату.",
            example = "הוֹצָאָה מִשִּׁמּוּשׁ שֶׁל הָאֵיי-פִּי-אַי הַיָּשָׁן הֻכְרְזָה חֲצִי שָׁנָה מֵרֹאשׁ.",
            exampleNative = "הוֹצָאָה מִשִּׁמּוּשׁ старого API объявили за полгода вперёд.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176615, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_advanced", transliteration = "kibuy ficher",
            original = "כִּבּוּי פִיצֶ'ר", translation = "sunset (отключение функции)",
            definition = "סְגִירָה סוֹפִית שֶׁל יְכֹלֶת אַחֲרֵי שֶׁעָבְרָה תְּקוּפַת הַהוֹדָעָה לַמִּשְׁתַּמְּשִׁים.",
            definitionNative = "Окончательное закрытие функции — после периода уведомления юзеров.",
            example = "כִּבּוּי פִיצֶ'ר הָעַתִּיק יִתְבַּצֵּעַ בְּסוֹף הָרֹבַע הַבָּא.",
            exampleNative = "כִּבּוּי פִיצֶ'ר старого функционала запланирован на конец следующего квартала.",
         fillInBlankExclusions = listOf(176611L, 176612L, 176613L, 176614L)),

        // ── pm_business (5) — бизнес-владение продуктом ──
        WordEntity(
            id = 176616, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_business", transliteration = "akhrayut revakh ve-hefsed",
            original = "אַחְרָיוּת רֶוַח וְהֶפְסֵד", translation = "P&L ownership (ответственность за P&L)",
            definition = "חוֹבָה אִישִׁית שֶׁל מְנַהֵל מוּצָר עַל הַהַכְנָסוֹת וְהַהוֹצָאוֹת שֶׁל קַו הַמּוּצָר שֶׁלּוֹ.",
            definitionNative = "Личная обязанность продакта — за выручку и затраты по своей продуктовой линейке.",
            example = "אַחְרָיוּת רֶוַח וְהֶפְסֵד עָבְרָה לַפִּי-אֵם אַחֲרֵי הָאַרְגּוּן הֶחָדָשׁ.",
            exampleNative = "אַחְרָיוּת רֶוַח וְהֶפְסֵד перешла к PM после новой реорганизации.",
         fillInBlankExclusions = listOf(176617L, 176618L, 176619L, 176620L)),
        WordEntity(
            id = 176617, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_business", transliteration = "istrategiyat tmkhur",
            original = "אִסְטְרָטֶגְיַת תִּמְחוּר", translation = "стратегия ценообразования",
            definition = "הַחְלָטָה שִׁיטָתִית עַל מַחִירִים לְפִי תַּחֲרוּת, שׁוּלֵי רֶוַח וְעֶרֶךְ נִתְפָּס לַלָּקוֹחַ.",
            definitionNative = "Системное решение по ценам — с учётом конкуренции, маржи и воспринимаемой ценности.",
            example = "אִסְטְרָטֶגְיַת תִּמְחוּר חֲדָשָׁה הֶעֶלְתָה אֶת הַשּׁוּלַיִם בְּשִׁבְעָה אָחוּז.",
            exampleNative = "אִסְטְרָטֶגְיַת תִּמְחוּר новая подняла маржу на семь процентов.",
         fillInBlankExclusions = listOf(176616L, 176618L, 176619L, 176620L)),
        WordEntity(
            id = 176618, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_business", transliteration = "arizat khavilot",
            original = "אֲרִיזַת חֲבִילוֹת", translation = "packaging (упаковка тарифов)",
            definition = "אִרְגוּן יְכֹלוֹת הַמּוּצָר לִקְבוּצוֹת מַחִיר שׁוֹנוֹת — חִנָּם, פְּרוֹ וְאַרְגּוּנִי.",
            definitionNative = "Сборка возможностей продукта в разные тарифные пакеты — бесплатный, про, корпоративный.",
            example = "אֲרִיזַת חֲבִילוֹת נִבְנְתָה מֵחָדָשׁ אַחֲרֵי שֶׁרָאִינוּ אֵיךְ הַלָּקוֹחוֹת מְשַׁלְּמִים.",
            exampleNative = "אֲרִיזַת חֲבִילוֹת перестроили — после анализа того, как клиенты платят.",
         fillInBlankExclusions = listOf(176616L, 176617L, 176619L, 176620L)),
        WordEntity(
            id = 176619, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_business", transliteration = "monetizatsya",
            original = "מוֹנֵטִיזַצְיָה", translation = "монетизация",
            definition = "הַדֶּרֶךְ שֶׁבָּהּ מוּצָר הוֹפֵךְ לְהָבִיא כֶּסֶף — מָנוּי, פִּרְסוּם, עֲמָלָה אוֹ קְנִיָּה חַד-פַּעֲמִית.",
            definitionNative = "Способ, которым продукт начинает приносить деньги — подписка, реклама, комиссия или разовая покупка.",
            example = "מוֹנֵטִיזַצְיָה דֶּרֶךְ מָנוּי חָדְשִׁי הִתְבָּרְרָה כְּטוֹבָה יוֹתֵר מִפִּרְסוּם.",
            exampleNative = "מוֹנֵטִיזַצְיָה через месячную подписку оказалась лучше рекламы.",
         fillInBlankExclusions = listOf(176616L, 176617L, 176618L, 176620L)),
        WordEntity(
            id = 176620, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_business", transliteration = "el-ti-vi",
            original = "אֵל-טִי-וִי", translation = "LTV (lifetime value)",
            definition = "סַךְ הַכֶּסֶף שֶׁלָּקוֹחַ מֵבִיא לַחֶבְרָה לְאֹרֶךְ כָּל זְמַן הַקְּשָׁר אִתָּהּ.",
            definitionNative = "Сумма денег, которую клиент приносит компании за всё время отношений с ней.",
            example = "אֵל-טִי-וִי שֶׁל לָקוֹחַ פְּרֵמְיוּם הָיָה גָּדוֹל פִּי שָׁלוֹשׁ מִשֶּׁל הַחִנָּמִי.",
            exampleNative = "אֵל-טִי-וִי клиента премиум-плана был втрое больше, чем у бесплатного.",
         fillInBlankExclusions = listOf(176616L, 176617L, 176618L, 176619L)),

        // ── pm_skills (5) — лидерство и приоритизация ──
        WordEntity(
            id = 176621, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_skills", transliteration = "manhigut bein-tskhumit",
            original = "מַנְהִיגוּת בֵּין-תְּחוּמִית", translation = "cross-functional leadership",
            definition = "הוֹבָלָה שֶׁל אַנָשִׁים מֵהַנְדָּסָה, עִצּוּב, שִׁוּוּק וּמְכִירוֹת בְּלִי סַמְכוּת רִשְׁמִית עֲלֵיהֶם.",
            definitionNative = "Ведение людей из инженерии, дизайна, маркетинга и продаж — без формальной власти над ними.",
            example = "מַנְהִיגוּת בֵּין-תְּחוּמִית הִיא הַכִּשְׁרוֹן הַחָשׁוּב בְּיוֹתֵר שֶׁל מְנַהֵל מוּצָר בָּכִיר.",
            exampleNative = "מַנְהִיגוּת בֵּין-תְּחוּמִית — самый важный навык старшего PM.",
         fillInBlankExclusions = listOf(176622L, 176623L, 176624L, 176625L)),
        WordEntity(
            id = 176622, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_skills", transliteration = "yishuv konflikt",
            original = "יִשּׁוּב קוֹנְפְלִיקְט", translation = "разрешение конфликтов",
            definition = "מִיּוּן חִלּוּקֵי דֵּעוֹת בֵּין צְוָתִים בְּצוּרָה שֶׁשּׁוֹמֶרֶת עַל יַחֲסִים וְלַהַחְלָטוֹת בְּרוּרוֹת.",
            definitionNative = "Разбор разногласий между командами — так, чтобы сберечь отношения и принять ясные решения.",
            example = "יִשּׁוּב קוֹנְפְלִיקְט בֵּין הָאֵנְגִ'ינִירִינְג לְעִצּוּב נָדְרַשׁ עַל סְדַר עֲדִיפוּיוֹת.",
            exampleNative = "יִשּׁוּב קוֹנְפְלִיקְט между инженерами и дизайном понадобился из-за приоритетов.",
         fillInBlankExclusions = listOf(176621L, 176623L, 176624L, 176625L)),
        WordEntity(
            id = 176623, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_skills", transliteration = "shitat tioof",
            original = "שִׁיטַת תִּעוּף", translation = "фреймворк приоритизации",
            definition = "כְּלִי מִסּוּדָר לְהַחְלִיט אֵיזוֹ מְשִׂימוֹת בָּאוֹת בָּרֹאשׁ וְאֵיזוֹ נִדְחוֹת לְלֹא רֶגֶשׁ.",
            definitionNative = "Упорядоченный инструмент — какие задачи берём первыми, а какие откладываем без эмоций.",
            example = "שִׁיטַת תִּעוּף נִבְחֲרָה בִּתְחִלַּת כָּל רֹבַע עַל יְדֵי צֶוֶות הַמּוּצָר.",
            exampleNative = "שִׁיטַת תִּעוּף выбирали в начале каждого квартала командой продукта.",
         fillInBlankExclusions = listOf(176621L, 176622L, 176624L, 176625L)),
        WordEntity(
            id = 176624, setId = 1766, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "pm_skills", transliteration = "rais",
            original = "רַייס", translation = "RICE (метод приоритизации)",
            definition = "נוּסְחַת חִשּׁוּב שֶׁמּוֹדֶדֶת רַעְיוֹן לְפִי טְוָח, הַשְׁפָּעָה, בִּטָּחוֹן וּמַאֲמָץ.",
            definitionNative = "Расчётная формула — оценивает идею по охвату, влиянию, уверенности и затратам усилий.",
            example = "רַייס סִיֵּעַ לְהַחְלִיט בֵּין שְׁתֵּי יָזְמוֹת שֶׁנִּרְאוּ בְּעֶרֶךְ זֵהוֹת בַּהַתְחָלָה.",
            exampleNative = "רַייס помог решить — между двумя инициативами, что в начале выглядели одинаковыми.",
         fillInBlankExclusions = listOf(176621L, 176622L, 176623L, 176625L)),
        WordEntity(
            id = 176625, setId = 1766, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "pm_skills", transliteration = "moskou",
            original = "מוֹסְקוֹאוּ", translation = "MoSCoW (must/should/could/won't)",
            definition = "חֲלוּקָה שֶׁל בַּקָּשׁוֹת לְאַרְבַּע סוֹגוֹת — חַיָּב, רָצוּי, אֶפְשָׁרִי וְלֹא עַכְשָׁו.",
            definitionNative = "Деление запросов на четыре корзины — обязан, желателен, можно и не сейчас.",
            example = "מוֹסְקוֹאוּ עָזַר לְצֶוֶות הַמּוּצָר לְסַנֵּן אֶת רְשִׁימַת הָרֵכִיבִים לִפְנֵי הַשִּׁחְרוּר.",
            exampleNative = "מוֹסְקוֹאוּ помог продактам отфильтровать список фич перед релизом.",
            isFillInBlankSafe = false,
        ),
    )
}
