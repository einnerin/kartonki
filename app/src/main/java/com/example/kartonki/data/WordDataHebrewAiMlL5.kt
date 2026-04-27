package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "AI и ML", уровень L5 (носитель языка).
 *
 * Set 1757: «AI и ML» — носитель языка (EPIC + LEGENDARY):
 *           управление AI-командой и стратегия. Роли в ML-команде,
 *           инфраструктура ML-платформы, этика и риски AI,
 *           governance и регуляторика, AI-стратегия компании.
 *
 * Аудитория — русскоязычные сеньоры/тимлиды/CTO/CPO в израильских
 * AI-стартапах и крупных tech-компаниях. Лексика реальная: смесь иврита
 * с английскими заимствованиями, как реально говорят в командах
 * (אֶם-אֶל רִיסֵרְצֶ'ר, אַפְּלַייד סַייאַנְטִיסְט, GPU קְלַסְטֶר,
 * אֵיי-אַיי גוֹבֵרְנֶנְס, הָלוּצִינַצְיוֹת, אַלַיינְמֶנְט).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   aiml_team       — роли в команде: ML researcher, applied scientist,
 *                     ML engineer, MLOps engineer, head of AI
 *   aiml_platform   — ML-платформа: feature store, experiment tracking,
 *                     GPU cluster, A/B testing, data lakehouse
 *   aiml_ethics     — этика и риски: bias detection, fairness,
 *                     hallucinations, interpretability, AI alignment
 *   aiml_governance — governance: AI governance, compliance, model card,
 *                     audit trail, AI Act
 *   aiml_strategy   — стратегия: compute budget, server farm,
 *                     build vs buy, ROI of AI, AI-first product
 *
 * Word IDs: setId × 100 + position (175701..175725).
 *
 * Пересечения сознательно избегали:
 *   - HightechL5 (1749) — другая тема (раунды, IPO, exit, attrition).
 *     Из этого сета не повторяются: CTO, IPO, fundraising, valuation, exit.
 *   - AiMlL3 (1755) и AiMlL4 (1756) — параллельные сеты, в задании
 *     явно прописан запрет на дубли с ними: fine-tuning, RAG, vector DB,
 *     GPU как одиночный термин, model, dataset.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewAiMlL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1757, languagePair = "he-ru", orderIndex = 1757,
            name = "AI и ML",
            description = "Управление AI-командой: ML platform, ethics, GPU-бюджет, governance",
            topic = "AI и ML", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1757 — AI и ML: носитель языка (L5, EPIC + LEGENDARY)
        // 5 групп × 5 слов: team, platform, ethics, governance, strategy
        // ══════════════════════════════════════════════════════════════════════

        // ── aiml_team (5) — роли и должности в ML-команде ──
        WordEntity(
            id = 175701, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_team", transliteration = "em-el riserchʼer",
            original = "אֶם-אֶל רִיסֵרְצֶ'ר", translation = "ML-исследователь",
            definition = "אִישׁ צֶוֶות שֶׁמְּפַתֵּחַ אַלְגוֹרִיתְמִים חֲדָשִׁים וּמְפַרְסֵם מַאֲמָרִים בְּכֵנָסִים מַדָּעִיִּים.",
            definitionNative = "Человек в команде, который придумывает новые алгоритмы и публикует научные статьи.",
            example = "אֶם-אֶל רִיסֵרְצֶ'ר חָדָשׁ הִצְטָרֵף לַצֶּוֶות יָשַׁר מִדּוֹקְטוֹרָט בְּסְטָנְפוֹרְד.",
            exampleNative = "Новый אֶם-אֶל רִיסֵרְצֶ'ר пришёл в команду прямо после докторантуры в Стэнфорде.",
         fillInBlankExclusions = listOf(175702L, 175703L, 175704L, 175705L)),
        WordEntity(
            id = 175702, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_team", transliteration = "applaid sayantist",
            original = "אַפְּלַייד סַייאַנְטִיסְט", translation = "applied scientist",
            definition = "אִישׁ מֶחְקָר שֶׁמּוֹרִיד רַעֲיוֹנוֹת אֲקָדֵמִיִּים לְפִתְרוֹנוֹת שֶׁבָּאֱמֶת רָצִים אֵצֶל לָקוֹחוֹת.",
            definitionNative = "Учёный, который доводит академические идеи до решений, реально работающих у клиентов.",
            example = "אַפְּלַייד סַייאַנְטִיסְט בְּאָמָזוֹן עוֹבֵד עַל מַעֲרֶכֶת הַמְלָצוֹת בִּזְמַן אֱמֶת.",
            exampleNative = "אַפְּלַייד סַייאַנְטִיסְט в Amazon работает над системой рекомендаций в реальном времени.",
         fillInBlankExclusions = listOf(175701L, 175703L, 175704L, 175705L)),
        WordEntity(
            id = 175703, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_team", transliteration = "em-el inzhʼinir",
            original = "אֶם-אֶל אִינְגִ'ינִיר", translation = "ML-инженер",
            definition = "מְהַנְדֵּס שֶׁבּוֹנֶה צִנּוֹרוֹת אִימּוּן וְיִישּׂוּם שֶׁל בִּינָה מְלָאכוּתִית בְּסְבִיבָה אֲמִיתִית.",
            definitionNative = "Инженер, что строит трубопроводы тренировки и применения ИИ в реальной среде.",
            example = "אֶם-אֶל אִינְגִ'ינִיר תִּקֵּן בָּאג שֶׁגָּרַם לְהַטָיָה בִּתְחַזּוּת הַמְּחִירִים.",
            exampleNative = "אֶם-אֶל אִינְגִ'ינִיר починил баг, из-за которого предсказания цен были смещены.",
         fillInBlankExclusions = listOf(175701L, 175702L, 175704L, 175705L)),
        WordEntity(
            id = 175704, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_team", transliteration = "em-lops inzhʼinir",
            original = "מַ\"לוֹפְּס אִינְגִ'ינִיר", translation = "MLOps-инженер",
            definition = "מְהַנְדֵּס שֶׁאַחְרָאִי עַל הַתַּשְׁתִּית, פְּרִיסָה וּמַעֲקָב אַחַר מוֹדֵלִים בְּפְּרוֹדַקְשֶׁן.",
            definitionNative = "Инженер, отвечающий за инфраструктуру, выкладку и слежку за моделями в продакшене.",
            example = "מַ\"לוֹפְּס אִינְגִ'ינִיר אוֹטוֹמַט אֶת הַסְּבָב הַשָּׁבוּעִי שֶׁל אִימּוּן מֵחָדָשׁ.",
            exampleNative = "מַ\"לוֹפְּס אִינְגִ'ינִיר автоматизировал еженедельный цикл переобучения моделей.",
         fillInBlankExclusions = listOf(175701L, 175702L, 175703L, 175705L)),
        WordEntity(
            id = 175705, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_team", transliteration = "hed of ei-ai",
            original = "הֵד אוֹף אֵיי-אַיי", translation = "Head of AI (глава направления ИИ)",
            definition = "מְנַהֵל בָּכִיר שֶׁמַּחְלִיט עַל הַחֲזוֹן הַטֶּכְנוֹלוֹגִי וְהַתַּקְצִיב שֶׁל כָּל יְכוֹלוֹת הַבִּינָה.",
            definitionNative = "Старший управленец, решающий технологическое видение и бюджет всех ИИ-возможностей фирмы.",
            example = "הֵד אוֹף אֵיי-אַיי קָבַע שֶׁכָּל מוּצָר חָדָשׁ יִכְלוֹל יְכוֹלוֹת גֵ'נֵרָטִיבִיּוֹת.",
            exampleNative = "הֵד אוֹף אֵיי-אַיי решил, что любой новый продукт будет содержать генеративные функции.",
         fillInBlankExclusions = listOf(175701L, 175702L, 175703L, 175704L)),

        // ── aiml_platform (5) — инфраструктура ML-платформы ──
        WordEntity(
            id = 175706, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_platform", transliteration = "fichʼer stor",
            original = "פִיצֶ'ר סְטוֹר", translation = "feature store (хранилище фич)",
            definition = "מַחְסָן מֶרְכָּזִי שֶׁל מַאֲפְיֵינִים מְעֻבָּדִים שֶׁאוֹתָם מְשַׁתְּפִים בֵּין צְוָתִים וּבֵין מוֹדֵלִים.",
            definitionNative = "Центральный склад готовых признаков — их делят между командами и моделями.",
            example = "פִיצֶ'ר סְטוֹר חָסַךְ לָנוּ חֹדֶשׁ עֲבוֹדָה כְּפוּלָה עַל אוֹתָם נְתוּנִים.",
            exampleNative = "פִיצֶ'ר סְטוֹר сэкономил нам месяц двойной работы над одними и теми же данными.",
         fillInBlankExclusions = listOf(175707L, 175708L, 175709L, 175710L)),
        WordEntity(
            id = 175707, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_platform", transliteration = "eksperiment treking",
            original = "אֶקְסְפֶּרִימֶנְט טְרֵקִינְג", translation = "experiment tracking",
            definition = "מַעֲרֶכֶת שֶׁשּׁוֹמֶרֶת תּוֹצְאוֹת שֶׁל כָּל רִיצָה כְּדֵי לְהַשְׁווֹת גִּרְסָאוֹת בִּמְהִירוּת.",
            definitionNative = "Система, что хранит итоги каждого прогона — для быстрого сравнения версий.",
            example = "בְּלִי אֶקְסְפֶּרִימֶנְט טְרֵקִינְג נִשְׁכַּח אֵיזוֹ הִיפֶּרְפָּרָמֶטֶר נָתְנָה אֶת הַתּוֹצָאָה.",
            exampleNative = "Без אֶקְסְפֶּרִימֶנְט טְרֵקִינְג забывается, какой гиперпараметр дал лучший результат.",
         fillInBlankExclusions = listOf(175706L, 175708L, 175709L, 175710L)),
        WordEntity(
            id = 175708, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_platform", transliteration = "GPU klaster",
            original = "GPU קְלַסְטֶר", translation = "GPU-кластер",
            definition = "אֲסֵפָה שֶׁל מַאוֹת כַּרְטִיסִים גְּרָפִיִּים מְחֻבָּרִים יַחַד לְהַפְעָלָה שֶׁל אִימּוּנִים כְּבֵדִים.",
            definitionNative = "Связка из сотен графических карт — для тяжёлых тренировок моделей.",
            example = "GPU קְלַסְטֶר חָדָשׁ הִקְטִין אֶת זְמַן הָאִימּוּן מִשָּׁבוּעַ לְשָׁעוֹת.",
            exampleNative = "Новый GPU קְלַסְטֶר сократил время тренировки с недели до часов.",
         fillInBlankExclusions = listOf(175706L, 175707L, 175709L, 175710L)),
        WordEntity(
            id = 175709, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_platform", transliteration = "mivkhan A/B",
            original = "מִבְחַן A/B", translation = "A/B-тест",
            definition = "הַשְׁוָאָה מְבֻקֶּרֶת בֵּין שְׁתֵּי גִּרְסָאוֹת מוּצָר עַל קְבוּצוֹת מִשְׁתַּמְשִׁים מֻקְבָּלוֹת.",
            definitionNative = "Контролируемое сравнение двух версий продукта на схожих группах пользователей.",
            example = "מִבְחַן A/B הוֹכִיחַ שֶׁכַּפְתּוֹר יָרֹק מַעֲלֶה הַמְרוֹת בְּשִׁבְעָה אָחוּז.",
            exampleNative = "מִבְחַן A/B доказал, что зелёная кнопка повышает конверсию на семь процентов.",
         fillInBlankExclusions = listOf(175706L, 175707L, 175708L, 175710L)),
        WordEntity(
            id = 175710, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_platform", transliteration = "data leikhaus",
            original = "דַּאטָה לֵייקְהָאוּס", translation = "data lakehouse",
            definition = "אַרְכִיטֶקְטוּרָה הַמְשַׁלֶּבֶת אִחְסוּן זוֹל שֶׁל אֲגַם נְתוּנִים עִם בְּדִיקוֹת קְפֵדָנִיּוֹת שֶׁל מַחְסָן.",
            definitionNative = "Архитектура — соединяет дешёвое хранение озера данных со строгими проверками склада.",
            example = "מַעֲבָר לְדַּאטָה לֵייקְהָאוּס חָסַךְ לָנוּ מֵאוֹת אַלְפֵי דּוֹלָר עַל סְנוֹפְלֵייק.",
            exampleNative = "Переход на דַּאטָה לֵייקְהָאוּס сэкономил сотни тысяч долларов на Snowflake.",
         fillInBlankExclusions = listOf(175706L, 175707L, 175708L, 175709L)),

        // ── aiml_ethics (5) — этика, риски и ответственный AI ──
        WordEntity(
            id = 175711, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_ethics", transliteration = "zihui hatayot",
            original = "זִיהוּי הַטָיוֹת", translation = "детекция предвзятости (bias detection)",
            definition = "תַּהֲלִיךְ שֶׁמּוֹצֵא אֵיפֹה הַמּוֹדֵל מַפְלֶה קְבוּצוֹת אוּכְלוּסִיָּה לְפִי מִין, גִּזְעָה אוֹ גִּיל.",
            definitionNative = "Поиск мест, где модель плохо обращается с группами по полу, расе или возрасту.",
            example = "זִיהוּי הַטָיוֹת חָשַׂף שֶׁהַמּוֹדֵל פָּחוֹת מְדֻיָּק עַל פָּנִים כֵּהוֹת.",
            exampleNative = "זִיהוּי הַטָיוֹת показал, что модель менее точна на тёмных лицах.",
         fillInBlankExclusions = listOf(175712L, 175713L, 175714L, 175715L)),
        WordEntity(
            id = 175712, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_ethics", transliteration = "hognut",
            original = "הוֹגְנוּת", translation = "справедливость (fairness в AI)",
            definition = "עִקָּרוֹן שֶׁמִּתְחַיֵּב לִשְׁוִויוֹן בְּהַחְלָטוֹת אוֹטוֹמָטִיּוֹת לְכָל קְבוּצוֹת מִשְׁתַּמְשִׁים.",
            definitionNative = "Принцип равенства автоматических решений между всеми группами пользователей.",
            example = "וַעֲדַת הוֹגְנוּת בָּדְקָה כָּל אַלְגוֹרִיתְם לִפְנֵי שֶׁעָלָה לִפְּרוֹדַקְשֶׁן.",
            exampleNative = "Комитет по הוֹגְנוּת проверял каждый алгоритм перед выходом в продакшен.",
         fillInBlankExclusions = listOf(175711L, 175713L, 175714L, 175715L)),
        WordEntity(
            id = 175713, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_ethics", transliteration = "halutsinatsiyot",
            original = "הָלוּצִינַצְיוֹת", translation = "галлюцинации (выдуманные ответы LLM)",
            definition = "תְּשׁוּבוֹת בְּטוּחוֹת שֶׁל מוֹדֵל שָׂפָה שֶׁנִּשְׁמָעוֹת אֲמִינוֹת אֲבָל מַמְצִיאוֹת עוּבְדוֹת.",
            definitionNative = "Уверенные ответы языковой модели — звучат правдоподобно, но факты выдуманы.",
            example = "הָלוּצִינַצְיוֹת שֶׁל הַצָּ'אטְבּוֹט גָּרְמוּ לִתְלוּנָה רִשְׁמִית מִלָּקוֹחַ.",
            exampleNative = "הָלוּצִינַצְיוֹת чат-бота привели к официальной жалобе от клиента.",
         fillInBlankExclusions = listOf(175711L, 175712L, 175714L, 175715L)),
        WordEntity(
            id = 175714, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_ethics", transliteration = "hesberiyut",
            original = "הֶסְבֵּרִיוּת", translation = "интерпретируемость (interpretability)",
            definition = "יְכוֹלֶת לְהַרְאוֹת בְּשָׂפָה פְּשׁוּטָה לָמָּה הַמּוֹדֵל בָּחַר תְּשׁוּבָה זוֹ עַל פְּנֵי אַחֶרֶת.",
            definitionNative = "Способность объяснить простыми словами, почему модель выбрала именно этот ответ.",
            example = "הֶסְבֵּרִיוּת חֲשׁוּבָה בִּמְיֻחָד בְּאַשְׁרַאי שֶׁבּוֹ הַחְלָטָה מְשַׁנָּה חַיֵּי אָדָם.",
            exampleNative = "הֶסְבֵּרִיוּת особенно важна в кредитах, где решение меняет жизнь человека.",
         fillInBlankExclusions = listOf(175711L, 175712L, 175713L, 175715L)),
        WordEntity(
            id = 175715, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_ethics", transliteration = "ei-ai alaynment",
            original = "אֵיי-אַיי אַלַיינְמֶנְט", translation = "AI alignment (согласование целей ИИ)",
            definition = "מְחֲקָר שֶׁמְּוַדֵּא שֶׁמַּעֲרָכוֹת חֲכָמוֹת מְמַלְּאוֹת אַחַר כַּוָּונוֹת אֱנוֹשִׁיּוֹת וְלֹא סוֹטוֹת מֵהֶן.",
            definitionNative = "Исследования: умные системы следуют человеческим намерениям и не уходят в сторону.",
            example = "צֶוֶות אַלַיינְמֶנְט בְּאַנְתְ'רוֹפִּיק מַעֲסִיק עַשְׂרוֹת חוֹקְרִים בִּלְבַד.",
            exampleNative = "Команда אַלַיינְמֶנְט в Anthropic насчитывает лишь десятки исследователей.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_governance (5) — governance и регуляторика AI ──
        WordEntity(
            id = 175716, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_governance", transliteration = "ei-ai governens",
            original = "אֵיי-אַיי גוֹבֵרְנֶנְס", translation = "AI governance (управление AI в фирме)",
            definition = "מַעֲרֶכֶת נְהָלִים פְּנִימִיִּים שֶׁקּוֹבַעַת מִי מְאַשֵּׁר הַשָּׁקַת מוֹדֵל וְעַל אֵיזֶה תַּקָּנוֹת.",
            definitionNative = "Внутренние правила: кто разрешает запуск модели и по каким нормам.",
            example = "מְדִינִיּוּת אֵיי-אַיי גוֹבֵרְנֶנְס דּוֹרֶשֶׁת אִישּׁוּר מִשְׁפָּטִי לְכָל יְכוֹלָה גֵ'נֵרָטִיבִית.",
            exampleNative = "Политика אֵיי-אַיי גוֹבֵרְנֶנְס требует юридическое одобрение для каждой генеративной функции.",
         fillInBlankExclusions = listOf(175717L, 175718L, 175719L, 175720L)),
        WordEntity(
            id = 175717, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_governance", transliteration = "kompliyens",
            original = "קוֹמְפְּלָיֶנְס", translation = "compliance (соответствие нормам)",
            definition = "עֲמִידָה שִׁיטָתִית בְּדַרְשׁוֹת חוֹק וְתַקָּנוֹת רִשְׁמִיּוֹת בְּכָל פְּעֻלָּה עִסְקִית.",
            definitionNative = "Регулярное следование требованиям закона и официальным правилам — в каждом действии бизнеса.",
            example = "קוֹמְפְּלָיֶנְס בְּחֶבְרַת בִּיטּוּחַ דּוֹרֵשׁ תִּעוּד שֶׁל כָּל הַחְלָטַת מוֹדֵל.",
            exampleNative = "קוֹמְפְּלָיֶנְס в страховой требует документировать каждое решение модели.",
         fillInBlankExclusions = listOf(175716L, 175718L, 175719L, 175720L)),
        WordEntity(
            id = 175718, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_governance", transliteration = "model card",
            original = "מוֹדֵל קַארְד", translation = "model card (паспорт модели)",
            definition = "מִסְמָךְ קָצָר שֶׁמְּתָאֵר עַל מָה הַמּוֹדֵל אֻמַּן, לְמָה הוּא מַתְאִים וְאֵיפֹה הוּא נִכְשַׁל.",
            definitionNative = "Короткий документ — на чём модель тренировалась, для чего годится и где плохо работает.",
            example = "מוֹדֵל קַארְד עַל גִ'יטְהָאבּ הוּא תְּנָאי לְשִׁתּוּף מוֹדֵל בְּקוֹד פָּתוּחַ.",
            exampleNative = "מוֹדֵל קַארְד на GitHub — обязательное условие для публикации открытой модели.",
         fillInBlankExclusions = listOf(175716L, 175717L, 175719L, 175720L)),
        WordEntity(
            id = 175719, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_governance", transliteration = "odit treyl",
            original = "אוֹדִיט טְרֵייל", translation = "audit trail (журнал аудита)",
            definition = "רֶצֶף רְשׁוּמוֹת בְּלִתִּי נִיתָּן לְשִׁינּוּי שֶׁמְּתָעֵד מִי עָשָׂה מָה וּמָתַי בַּמַּעֲרֶכֶת.",
            definitionNative = "Неизменяемая последовательность записей — кто, что и когда делал в системе.",
            example = "אוֹדִיט טְרֵייל מְלָאֵה הוּא תְּנָאי בְּסִיסִי בְּכָל מַעֲרֶכֶת רְפוּאִית.",
            exampleNative = "Полный אוֹדִיט טְרֵייל — базовое условие в любой медицинской системе.",
         fillInBlankExclusions = listOf(175716L, 175717L, 175718L, 175720L)),
        WordEntity(
            id = 175720, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_governance", transliteration = "khok ha-ei-ai",
            original = "חוֹק הָאֵיי-אַיי", translation = "AI Act (европейский закон о регулировании ИИ)",
            definition = "רֶגוּלַצְיָה אֵירוֹפִּית שֶׁמְּסַוֶּגֶת מַעֲרָכוֹת חֲכָמוֹת לְפִי רָמַת סִכּוּן וְכוֹפָה דְּרִישׁוֹת בְּהֶתְאֵם.",
            definitionNative = "Европейский закон — делит умные системы по уровню риска и налагает разные требования.",
            example = "חוֹק הָאֵיי-אַיי יְחַיֵּב חֶבְרוֹת אֲמֵרִיקָאִיוֹת לְשַׁנּוֹת מוּצָרִים שֶׁנִּמְכָּרִים בָּאִיחוּד.",
            exampleNative = "חוֹק הָאֵיי-אַיי заставит американские фирмы переделать продукты для рынка ЕС.",
         fillInBlankExclusions = listOf(175716L, 175717L, 175718L, 175719L)),

        // ── aiml_strategy (5) — стратегия AI на уровне компании ──
        WordEntity(
            id = 175721, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_strategy", transliteration = "taktsiv khishuv",
            original = "תַּקְצִיב חִישּׁוּב", translation = "compute budget (бюджет вычислений)",
            definition = "סְכוּם הַכֶּסֶף וְהַשָּׁעוֹת שֶׁהַחֶבְרָה מַקְצָה לְאִימּוּן וְלִרְצוֹף שֶׁל מַעֲרָכוֹת חֲכָמוֹת.",
            definitionNative = "Сумма денег и часов, что фирма выделяет на тренировку и работу умных систем.",
            example = "תַּקְצִיב חִישּׁוּב שֶׁל הַחֶבְרָה הָיָה גָּדוֹל יוֹתֵר מִתַּקְצִיב הַמַּשָּׂכוֹרוֹת.",
            exampleNative = "תַּקְצִיב חִישּׁוּב фирмы оказался больше бюджета на зарплаты.",
         fillInBlankExclusions = listOf(175722L, 175724L, 175725L)),
        WordEntity(
            id = 175722, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_strategy", transliteration = "khavat sharatim",
            original = "חַוַּת שְׁרָתִים", translation = "серверная ферма (GPU farm)",
            definition = "מָבְנֶה עָנָק עִם אַלְפֵי מַחְשְׁבִים מְקֻרָרִים שֶׁמַּפְעִילִים אֶת הָאִימּוּן יוֹמָם וָלַיְלָה.",
            definitionNative = "Огромное здание с тысячами охлаждаемых машин — крутят тренировки днём и ночью.",
            example = "חַוַּת שְׁרָתִים בְּטֶקְסַס מִתְחַמֶּמֶת כָּל-כָּךְ שֶׁבָּנִינוּ מַעֲרֶכֶת קֵרוּר עַצְמָאִית.",
            exampleNative = "חַוַּת שְׁרָתִים в Техасе так греется, что мы построили автономную систему охлаждения.",
         fillInBlankExclusions = listOf(175721L, 175724L, 175725L)),
        WordEntity(
            id = 175723, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "aiml_strategy", transliteration = "bne o kne",
            original = "בְּנֵה אוֹ קְנֵה", translation = "build vs buy (строить или покупать)",
            definition = "דִּילֶמָה אִסְטְרָטֶגִית: לְפַתֵּחַ פִּתְרוֹן בְּעַצְמְךָ אוֹ לְהִשְׁתַּמֵּשׁ בְּכֵלִים מוּכָנִים.",
            definitionNative = "Стратегическая дилемма — сделать решение самому или взять готовый инструмент.",
            example = "הַחְלָטַת בְּנֵה אוֹ קְנֵה בִּמְשִׁיכַת מוֹדֵלִים נָחְתְּכָה לְטוֹבַת אַנְתְ'רוֹפִּיק.",
            exampleNative = "Решение בְּנֵה אוֹ קְנֵה по моделям было сделано в пользу Anthropic.",
        ),
        WordEntity(
            id = 175724, setId = 1757, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_strategy", transliteration = "hekhzer al ei-ai",
            original = "הֶחְזֵר עַל אֵיי-אַיי", translation = "ROI of AI (отдача от вложений в ИИ)",
            definition = "מְדִידָה כַּמָּה כֶּסֶף הַחֶבְרָה הִרְוִיחָה מִכָּל שֶׁקֶל שֶׁהֻשְׁקַע בְּפִתּוּחַ מַעֲרָכוֹת חֲכָמוֹת.",
            definitionNative = "Замер: сколько денег фирма заработала на каждом шекеле, вложенном в умные системы.",
            example = "הֶחְזֵר עַל אֵיי-אַיי בִּפְּרוֹיֶיקְט הָיָה שְׁלִילִי שָׁנָתַיִם לִפְנֵי שֶׁהָפַךְ לְחִיּוּבִי.",
            exampleNative = "הֶחְזֵר עַל אֵיי-אַיי в проекте был отрицательным два года, прежде чем стал плюсом.",
         fillInBlankExclusions = listOf(175721L, 175722L, 175725L)),
        WordEntity(
            id = 175725, setId = 1757, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_strategy", transliteration = "mutsar ei-ai-feirst",
            original = "מוּצָר אֵיי-אַיי-פֵירְסְט", translation = "AI-first продукт",
            definition = "מוּצָר שֶׁבּוֹ הַיְכוֹלוֹת הַחֲכָמוֹת הֵן הַלֵּב, לֹא תּוֹסֶפֶת מְאֻחֶרֶת לְמָה שֶׁכְּבָר קַיָּם.",
            definitionNative = "Продукт, в котором умные функции — сердце, а не поздняя надстройка над готовым.",
            example = "מוּצָר אֵיי-אַיי-פֵירְסְט מַתְחִיל מֵהַשְּׁאֵלָה אֵיךְ הַמּוֹדֵל יִפְתֹּר אֶת הַבְּעָיָה.",
            exampleNative = "מוּצָר אֵיי-אַיי-פֵירְסְט начинается с вопроса, как именно модель решит задачу.",
         fillInBlankExclusions = listOf(175721L, 175722L, 175724L)),
    )
}
