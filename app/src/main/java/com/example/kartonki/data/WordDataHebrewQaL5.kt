package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "QA и тестирование", L5 «Носитель языка» (EPIC+LEGENDARY).
 *
 * Set 1773: «QA и тестирование» — носитель языка L5:
 *           Управление качеством — head of QA, стратегия, культура, метрики, аудит.
 *
 * Целевая аудитория — русскоязычные QA-менеджеры и архитекторы качества
 * в израильском хайтеке. Лексика как в реальной речи QA-руководителей:
 * иврит + английские заимствования (רֵישׁ קְיוּ-אֵיי, אַסְטְרָטֶגְיַת בְּדִיקוֹת,
 * אֶמ-טִי-טִי-אַר, אַייסוֹ 9001).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   qa_leadership  — лидерство: head of QA, QA-архитектор, test lead, principal, quality manager
 *   qa_strategy    — стратегия: test strategy, risk-based, test charter, exploratory mission, quality vision
 *   qa_culture     — культура: quality ownership, blameless post-mortem, knowledge sharing, mentoring, T-shaped
 *   qa_metrics     — метрики: defect leakage, MTTR, test efficiency, escape rate, COQ
 *   qa_compliance  — комплаенс: ISO 9001, audit trail, regulatory testing, validation protocol, traceability
 *
 * Word IDs: setId × 100 + position (177301..177325).
 *
 * Пересечения с другими наборами темы и хайтеком — проверены:
 *   - QaL2 (1761): unit/integration/e2e/smoke, баг-репорт, тест-план, акceptance criteria,
 *     ретест, sign-off, регрессионный набор. В этом сете не повторяются.
 *   - QaL3 (1762): Selenium, Playwright, perf-варианты, contract test, code coverage,
 *     security testing, accessibility audit. В этом сете не повторяются.
 *   - HightechL4 (1748): KPI, OKR, retention, churn, NPS, аудит безопасности, GDPR, дашборд.
 *     Здесь — иные QA-метрики (defect leakage, MTTR, escape rate, COQ) и иной аудит (ISO).
 *   - HightechL5 (1749): C-level, раунды, exit, pivot, attrition, ownership, accountability.
 *     Здесь — лидерство в QA-вертикали и иной набор культурных терминов.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewQaL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1773, languagePair = "he-ru", orderIndex = 1773,
            name = "QA и тестирование",
            description = "Управление качеством: head of QA, стратегия, культура, метрики, аудит",
            topic = "QA и тестирование", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1773 — QA и тестирование: носитель языка (L5, EPIC+LEGENDARY)
        // 5 групп × 5 слов: leadership, strategy, culture, metrics, compliance
        // ══════════════════════════════════════════════════════════════════════

        // ── qa_leadership (5) — управленческие роли в QA ──
        WordEntity(
            id = 177301, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_leadership", transliteration = "reish kyu-ei",
            original = "רֵישׁ קְיוּ-אֵיי", translation = "head of QA (директор по качеству)",
            definition = "הָאָדָם הַבָּכִיר שֶׁמַּחְלִיט עַל כָּל מְדִינִיּוּת הָאֵיכוּת בַּחֶבְרָה כֻּלָּהּ.",
            definitionNative = "Старший человек, решающий всю политику качества в фирме целиком.",
            example = "רֵישׁ קְיוּ-אֵיי הִצְהִיר שֶׁאֵין שִׁחְרוּר בְּלִי מַעֲבָר שֶׁל סוֹלְלַת הַסַּף.",
            exampleNative = "רֵישׁ קְיוּ-אֵיי заявил: без прохождения базовой батареи релиза не будет.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177302, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_leadership", transliteration = "arkhitekt eikhut",
            original = "אַרְכִיטֶקְט אֵיכוּת", translation = "QA-архитектор",
            definition = "מֻמְחֶה שֶׁמְעַצֵּב אֶת הַתַּשְׁתִּית הַטֶּכְנִית שֶׁל בְּדִיקוֹת — מִסְגָּרוֹת, כְּלִים, שִׁכְבוֹת.",
            definitionNative = "Эксперт, проектирующий техническую базу проверок — фреймворки, инструменты, слои.",
            example = "אַרְכִיטֶקְט אֵיכוּת בָּחַר בְּתַשְׁתִּית מְאֻחֶדֶת לְכָל קַוֵּי הַמּוּצָר.",
            exampleNative = "אַרְכִיטֶקְט אֵיכוּת выбрал единую базу для всех продуктовых линий.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177303, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_leadership", transliteration = "test lid",
            original = "טֶסְט לִיד", translation = "test lead (ведущий тестировщик)",
            definition = "מוֹבִיל מִקְצוֹעִי שֶׁל קְבוּצָה קְטַנָּה — מְחַלֵּק מְשִׂימוֹת וּמְלַוֶּה אֶת הַמִּקְצוֹעִיּוּת.",
            definitionNative = "Профессиональный лидер маленькой группы — раздаёт задачи и сопровождает квалификацию.",
            example = "הַטֶּסְט לִיד עָבַר עַל כָּל תַּסְרִיט וְנָתַן הֶעָרוֹת לִפְנֵי הַחֲתִימָה.",
            exampleNative = "Наш טֶסְט לִיד прошёлся по каждому сценарию и оставил замечания до подписи.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177304, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_leadership", transliteration = "printsipl injinir",
            original = "פְּרִינְסִיפַּל אִינְגִ'ינִיר", translation = "principal engineer (старший инженер)",
            definition = "דַּרְגָּה הַגְּבוֹהָה בְּיוֹתֵר בְּמַסְלוּל הַמִּקְצוֹעִי — הַשְׁפָּעָה רְחָבָה בְּלִי לְנַהֵל אֲנָשִׁים.",
            definitionNative = "Высшая ступень профессионального трека — широкое влияние без управления людьми.",
            example = "פְּרִינְסִיפַּל אִינְגִ'ינִיר הוֹבִיל אֶת מַעֲבַר הָאוֹטוֹמַצְיָה לְמַחְסָן מְרֻכָּז.",
            exampleNative = "פְּרִינְסִיפַּל אִינְגִ'ינִיר возглавил переход автоматизации на единый репозиторий.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177305, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_leadership", transliteration = "menahel eikhut",
            original = "מְנַהֵל אֵיכוּת", translation = "quality manager (менеджер качества)",
            definition = "אַחְרַאי תִּפְעוּלִי עַל לוּחַ זְמַנִּים, תַּקְצִיב וּתְפוּקָה שֶׁל קְבוּצוֹת בְּדִיקָה כַּמָּה.",
            definitionNative = "Операционный ответственный за сроки, бюджет и выработку нескольких тестовых групп.",
            example = "מְנַהֵל אֵיכוּת מָסַר דּוּחַ רִבְעוֹנִי לְהַנְהָלָה עִם תַּכְנִית שִׁפּוּר מְדֻיֶּקֶת.",
            exampleNative = "מְנַהֵל אֵיכוּת подал руководству квартальный отчёт с точным планом улучшений.",
            isFillInBlankSafe = false,
        ),

        // ── qa_strategy (5) — стратегические подходы к качеству ──
        WordEntity(
            id = 177306, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_strategy", transliteration = "astrategyat bdikot",
            original = "אַסְטְרָטֶגְיַת בְּדִיקוֹת", translation = "тестовая стратегия",
            definition = "מַסְמָךְ בָּכִיר שֶׁמַּגְדִּיר עִקְּרוֹנוֹת כְּלָלִיִּים — לֹא תַּסְרִיטִים פְּרָטָנִיִּים.",
            definitionNative = "Старший документ, задающий общие принципы — не отдельные сценарии.",
            example = "אַסְטְרָטֶגְיַת בְּדִיקוֹת לִשְׁנָה הַבָּאָה הִתְמַקְדָה בְּקִצּוּר זְמַן הַסָּבָב.",
            exampleNative = "אַסְטְרָטֶגְיַת בְּדִיקוֹת на следующий год сосредоточилась на сокращении времени прогона.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177307, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_strategy", transliteration = "gisha mevuseset sikun",
            original = "גִּישָׁה מְבֻסֶּסֶת סִיכּוּן", translation = "risk-based testing (по уровню риска)",
            definition = "סִדְרוּר עֲדִיפֻיּוֹת לְפִי הַסְּבָרָה לְכִשָּׁלוֹן וְעֹצֶם הַנֶּזֶק לַלָּקוֹחַ.",
            definitionNative = "Расстановка приоритетов по вероятности отказа и масштабу ущерба для клиента.",
            example = "גִּישָׁה מְבֻסֶּסֶת סִיכּוּן הִכְוִינָה אוֹתָנוּ לִפְתֹּחַ מוֹדוּל הַתַּשְׁלוּמִים תְּחִלָּה.",
            exampleNative = "גִּישָׁה מְבֻסֶּסֶת סִיכּוּן направила нас сначала вскрывать платёжный модуль.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177308, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_strategy", transliteration = "test charter",
            original = "טֶסְט צַ'רְטֶר", translation = "test charter (карта сессии)",
            definition = "טֹפֶס קָצָר שֶׁמַּתְוֶה מַטָּרָה, גְּבוּל זְמַן וְאֵזוֹר חֲקִירָה לְמַפְגָּשׁ יָחִיד.",
            definitionNative = "Короткая бумага — задаёт цель, рамку времени и зону исследования одной сессии.",
            example = "כָּל טֶסְט צַ'רְטֶר נִכְתַּב חֲצִי שָׁעָה לִפְנֵי הַמַּפְגָּשׁ עַצְמוֹ.",
            exampleNative = "Каждый טֶסְט צַ'רְטֶר пишется за полчаса до самой сессии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177309, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_strategy", transliteration = "missiyat khakira",
            original = "מִשִּׂימַת חֲקִירָה", translation = "exploratory mission (исследовательское задание)",
            definition = "יַעַד פְּתוּחַ לְמַפְגָּשׁ סַקְרָנוּת — לְלֹא צְעָדִים מֻקְדָּמִים, רַק כִּוּוּן כְּלָלִי.",
            definitionNative = "Открытая цель для любопытной сессии — без заранее заданных шагов, только направление.",
            example = "מִשִּׂימַת חֲקִירָה עַל מָסָךְ הָרִשּׁוּם הֵבִיאָה שִׁשָּׁה כִּשְׁלוֹנוֹת חֲדָשִׁים.",
            exampleNative = "מִשִּׂימַת חֲקִירָה по экрану регистрации принесла шесть свежих провалов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177310, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_strategy", transliteration = "khazon eikhut",
            original = "חָזוֹן אֵיכוּת", translation = "quality vision (видение качества)",
            definition = "הַצְהָרָה אֲרֻכַּת טֶוַח עַל הַמַּצָּב הָרָצוּי שֶׁל הַמּוּצָר בְּעֵינֵי הַלָּקוֹחַ.",
            definitionNative = "Долгосрочное заявление о желаемом состоянии продукта в глазах клиента.",
            example = "חָזוֹן אֵיכוּת קָצָר וּבָרוּר אִחֵד אֶת כָּל הַקְּבוּצוֹת סְבִיב מַטָּרָה אַחַת.",
            exampleNative = "Короткое и ясное חָזוֹן אֵיכוּת объединило все группы вокруг одной цели.",
            isFillInBlankSafe = false,
        ),

        // ── qa_culture (5) — культура и развитие людей ──
        WordEntity(
            id = 177311, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_culture", transliteration = "be'alut al eikhut",
            original = "בַּעֲלוּת עַל אֵיכוּת", translation = "quality ownership (личная ответственность за качество)",
            definition = "תְּחוּשָׁה שֶׁכָּל אֶחָד בַּצֶּוֶות, לֹא רַק הַבּוֹדְקִים, אַחְרַאי לְמַה שֶּׁמַּגִּיעַ לַלָּקוֹחַ.",
            definitionNative = "Чувство, что каждый в команде, а не только тестировщики, отвечает за то, что доедет до клиента.",
            example = "בַּעֲלוּת עַל אֵיכוּת בַּצֶּוֶות הוֹרִידָה לָנוּ אֶת מִסְפַּר הַתִּיקֵטִים בְּחֵצִי.",
            exampleNative = "בַּעֲלוּת עַל אֵיכוּת в команде уронила число тикетов вдвое.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177312, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_culture", transliteration = "tukhkir lelo ashma",
            original = "תַּחְקִיר לְלֹא אַשְׁמָה", translation = "blameless post-mortem (разбор без обвинений)",
            definition = "פְּגִישָׁה אַחֲרֵי תַּקָּלָה שֶׁמְּחַפֶּשֶׂת סִבָּה מַעֲרַכְתִּית בִּמְקוֹם לְהַצְבִּיעַ עַל אִישׁ.",
            definitionNative = "Встреча после поломки — ищет системную причину вместо того, чтобы тыкать пальцем в человека.",
            example = "תַּחְקִיר לְלֹא אַשְׁמָה הֵבִיא לְשִׁנּוּי אֲמִתִּי בַּצִּינּוֹר שֶׁל הַמַּעֲרֶכֶת.",
            exampleNative = "תַּחְקִיר לְלֹא אַשְׁמָה привёл к настоящему изменению в системном пайплайне.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177313, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_culture", transliteration = "shituf yeda",
            original = "שִׁתּוּף יֶדַע", translation = "knowledge sharing (распространение знаний)",
            definition = "פְּעֻלָּה קְבוּעָה שֶׁל הַעֲבָרַת מַה שֶּׁמִּישֶׁהוּ לָמַד אֶל שְׁאַר הָאַנָשִׁים בְּקִבּוּץ.",
            definitionNative = "Постоянное действие — передача того, чему один научился, всем остальным в коллективе.",
            example = "שִׁתּוּף יֶדַע שְׁבוּעִי בַּזּוּם הוֹרִיד אֶת הַתְּלוּת בִּשְׁנֵי וֵותִיקִים.",
            exampleNative = "שִׁתּוּף יֶדַע еженедельно в Zoom уменьшил зависимость от двух старожилов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177314, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_culture", transliteration = "tokhnit khanikha",
            original = "תָּכְנִית חֲנִיכָה", translation = "mentoring program (программа наставничества)",
            definition = "מִסְגֶּרֶת מְסֻדֶּרֶת שֶׁבָּהּ אִישׁ בָּכִיר מְלַוֶּה מִתְחִיל לְאֹרֶךְ חֳדָשִׁים.",
            definitionNative = "Упорядоченная рамка, в которой старший сопровождает новичка на протяжении месяцев.",
            example = "תָּכְנִית חֲנִיכָה שֶׁל חֲצִי שָׁנָה הֶעֱלְתָה אֶת רָמַת הַזּוּטָרִים בְּמַהֲרָה.",
            exampleNative = "תָּכְנִית חֲנִיכָה на полгода быстро подняла уровень младших.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177315, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_culture", transliteration = "bodek ti-sheipd",
            original = "בּוֹדֵק T-שֵׁייפְּד", translation = "T-shaped tester (универсал с глубокой специализацией)",
            definition = "אִישׁ מִקְצוֹעַ עִם עֹמֶק אֶחָד בּוֹלֵט וְרֹחַב כְּלָלִי שֶׁל יְכֹלוֹת קְרוֹבוֹת.",
            definitionNative = "Спец с одной выраженной глубиной и общей широтой смежных умений.",
            example = "בּוֹדֵק T-שֵׁייפְּד מְשַׁלֵּב מֻמְחִיּוּת בִּכְלֵי עוֹמֶס עִם הֲבָנָה כּוֹלֶלֶת בַּתּוֹכְנָה.",
            exampleNative = "בּוֹדֵק T-שֵׁייפְּד совмещает экспертизу в нагрузке с общим пониманием продукта.",
            isFillInBlankSafe = false,
        ),

        // ── qa_metrics (5) — метрики качества для управленцев ──
        WordEntity(
            id = 177316, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_metrics", transliteration = "dlifat tkalot",
            original = "דְּלִיפַת תַּקָּלוֹת", translation = "defect leakage (утечка дефектов в прод)",
            definition = "כַּמָּה כְּשָׁלִים בָּרְחוּ מֵהַשְּׁלַבִּים הַמֻּקְדָּמִים וְהִגִּיעוּ עַד הַלָּקוֹחַ הַסּוֹפִי.",
            definitionNative = "Сколько провалов сбежало с ранних стадий и доехало до конечного клиента.",
            example = "דְּלִיפַת תַּקָּלוֹת שֶׁל שְׁלֹשָׁה אָחוּז נֶחְשֶׁבֶת מְצֻיֶּנֶת בַּתַּעֲשִׂיָּה.",
            exampleNative = "דְּלִיפַת תַּקָּלוֹת в три процента считается отличной по индустрии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177317, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_metrics", transliteration = "em-ti-ti-ar",
            original = "אֶמ-טִי-טִי-אַר", translation = "MTTR (среднее время починки)",
            definition = "מִסְפָּר מְמֻצָּע שֶׁל דַּקּוֹת אוֹ שָׁעוֹת מֵרֶגַע גִּלּוּי הַבְּעָיָה וְעַד פִּתְרוֹן מָלֵא.",
            definitionNative = "Среднее число минут или часов от обнаружения проблемы до полного решения.",
            example = "אֶמ-טִי-טִי-אַר יָרַד מִשָּׁעָה לְעֶשְׂרִים דַּקּוֹת אַחֲרֵי שֶׁשִּׁפַּרְנוּ אֶת הַתִּעוּד.",
            exampleNative = "אֶמ-טִי-טִי-אַר упал с часа до двадцати минут после улучшения документации.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177318, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_metrics", transliteration = "yeyilut bdika",
            original = "יְעִילוּת בְּדִיקָה", translation = "test efficiency (отдача от тестов)",
            definition = "יַחַס בֵּין מִסְפַּר הַתַּקָּלוֹת שֶׁנִּמְצְאוּ לְמִסְפַּר הַשָּׁעוֹת שֶׁהֻשְׁקְעוּ.",
            definitionNative = "Соотношение между числом найденных поломок и количеством вложенных часов.",
            example = "יְעִילוּת בְּדִיקָה גְּבוֹהָה שִׁכְנְעָה אֶת הַהַנְהָלָה לִשְׁמֹר עַל גֹּדֶל הַצֶּוֶות.",
            exampleNative = "Высокий יְעִילוּת בְּדִיקָה убедил руководство сохранить размер команды.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177319, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_metrics", transliteration = "akhuz briha",
            original = "אֲחוּז בְּרִיחָה", translation = "escape rate (доля сбежавших дефектов)",
            definition = "אָחוּז הַתַּקָּלוֹת שֶׁעָבְרוּ אֶת הַסַּף מִבְּלִי שֶׁאַף שָׁלָב הִצְלִיחַ לִתְפֹּס אוֹתָן.",
            definitionNative = "Доля поломок, перешедших порог так, что ни одна стадия их не словила.",
            example = "אֲחוּז בְּרִיחָה דּוּ-סִפְרָתִי הִתְרִיעַ עַל פְּגָם בִּתְהֲלִיךְ הַסְּקִירָה שֶׁל הַקּוֹד.",
            exampleNative = "Двузначный אֲחוּז בְּרִיחָה подал сигнал о дефекте процесса ревью кода.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177320, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_metrics", transliteration = "alut ha-eikhut",
            original = "עֲלוּת הָאֵיכוּת", translation = "COQ (cost of quality, стоимость качества)",
            definition = "סְכוּם כָּל הַהוֹצָאוֹת עַל מְנִיעָה, גִּלּוּי וְתִקּוּן שֶׁל פְּגָמִים בְּמוּצָר.",
            definitionNative = "Сумма всех расходов на предупреждение, обнаружение и починку дефектов в продукте.",
            example = "עֲלוּת הָאֵיכוּת הֻצְגָה לַדִּירֶקְטוֹרְיוֹן כְּחֵלֶק מֵהַסַּקִירָה הַשְּׁנָתִית.",
            exampleNative = "עֲלוּת הָאֵיכוּת представили совету директоров в годовом обзоре.",
            isFillInBlankSafe = false,
        ),

        // ── qa_compliance (5) — стандарты, аудит и регуляторные проверки ──
        WordEntity(
            id = 177321, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_compliance", transliteration = "ayso 9001",
            original = "אַייסוֹ 9001", translation = "ISO 9001 (международный стандарт качества)",
            definition = "תֶּקֶן בֵּינְלְאֻמִּי שֶׁמַּגְדִּיר אֵיךְ צָרִיךְ לְנַהֵל תַּהֲלִיכִים כְּדֵי לְהַבְטִיחַ אֵיכוּת קְבוּעָה.",
            definitionNative = "Международный стандарт — задаёт, как вести процессы ради постоянного качества.",
            example = "אַייסוֹ 9001 חִיֵּב אוֹתָנוּ לְתַעֵד כָּל שִׁנּוּי בִּסְפֵרוֹת הַבְּדִיקָה.",
            exampleNative = "אַייסוֹ 9001 обязал нас фиксировать каждое изменение в тестовых средах.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177322, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_compliance", transliteration = "shvil bikoret",
            original = "שְׁבִיל בִּקֹּרֶת", translation = "audit trail (след аудита)",
            definition = "רְשׁוּמָה כְּרוֹנוֹלוֹגִית שֶׁל פְּעֻלּוֹת — מִי, מָתַי וּמָה שִׁנָּה בַּמַּעֲרֶכֶת.",
            definitionNative = "Хронологическая запись действий — кто, когда и что менял в системе.",
            example = "שְׁבִיל בִּקֹּרֶת הִתְגַּלָּה כִּמְקוֹר הַזָּהָב בַּחֲקִירָה שֶׁל הָרְגוּלָטוֹר.",
            exampleNative = "שְׁבִיל בִּקֹּרֶת оказался золотым источником при расследовании регулятора.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177323, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_compliance", transliteration = "bdikat regulatzya",
            original = "בְּדִיקַת רֶגוּלַצְיָה", translation = "regulatory testing (регуляторная проверка)",
            definition = "סְקִירָה רִשְׁמִית שֶׁמְּוַדֵּאת שֶׁמּוּצָר עוֹמֵד בִּדְרִישׁוֹת חוֹק שֶׁל מְדִינָה אוֹ עַנָף.",
            definitionNative = "Официальный обзор — соответствует ли продукт требованиям закона страны или отрасли.",
            example = "בְּדִיקַת רֶגוּלַצְיָה לִקְרַאת כְּנִיסָה לְשׁוּק גֶּרְמַנְיָה אָרְכָה אַרְבָּעָה חֳדָשִׁים.",
            exampleNative = "בְּדִיקַת רֶגוּלַצְיָה перед выходом на немецкий рынок длилась четыре месяца.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177324, setId = 1773, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "qa_compliance", transliteration = "protokol imut",
            original = "פְּרוֹטוֹקוֹל אִמּוּת", translation = "validation protocol (протокол валидации)",
            definition = "מַסְמָךְ פוֹרְמָלִי שֶׁמְּפָרֵט אֵיךְ מוֹכִיחִים שֶׁמַּעֲרֶכֶת עוֹשָׂה בְּדִיוּק מָה שֶׁאָמְרוּ עָלֶיהָ.",
            definitionNative = "Формальный документ — описывает, как доказать, что система делает ровно заявленное.",
            example = "פְּרוֹטוֹקוֹל אִמּוּת לְמַכְשִׁיר רְפוּאִי דּוֹרֵשׁ חֲתִימָה שֶׁל שְׁלֹשָׁה גּוֹרְמִים.",
            exampleNative = "פְּרוֹטוֹקוֹל אִמּוּת для медицинского прибора требует подписи трёх инстанций.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177325, setId = 1773, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "qa_compliance", transliteration = "matritsat ekiv",
            original = "מַטְרִיצַת עֵקִיב", translation = "traceability matrix (матрица прослеживаемости)",
            definition = "טַבְלָה שֶׁמְּקַשֶּׁרֶת כָּל דְּרִישָׁה מֵהַלָּקוֹחַ אֶל בְּדִיקָה מַתְאִימָה שֶׁבּוֹדֶקֶת אוֹתָהּ.",
            definitionNative = "Таблица — связывает каждое требование клиента с конкретной проверкой, что его покрывает.",
            example = "מַטְרִיצַת עֵקִיב גִּלְּתָה שְׁתֵּי דְּרִישׁוֹת בְּלִי כִּסּוּי לִפְנֵי הַשִּׁחְרוּר.",
            exampleNative = "מַטְרִיצַת עֵקִיב вскрыла два требования без покрытия перед релизом.",
            isFillInBlankSafe = false,
        ),
    )
}
