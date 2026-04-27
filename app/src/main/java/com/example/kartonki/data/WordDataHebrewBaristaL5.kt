package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Кофейня и работа баристой", уровень 5 (носитель языка).
 *
 * Set 1797: «Кофейня и работа баристой» — носитель языка (EPIC + LEGENDARY):
 *           управление кофейней, экономика операций, контроль качества,
 *           тренинг и сертификация, кофейная культура и философия третьей волны.
 *
 * Тема не пересекается со словами из BaristaL1L2L3 (1739-1741, базовая лексика
 * + оборудование + спешелти-обжарка). Здесь — операционно-управленческий
 * слой и культурная философия профессии. Ни одно слово не дублирует
 * original'ы 1739-1741, нет однокоренных пар внутри сета и с предыдущими.
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   barista_management — менеджмент: директор, ответственный за поставки,
 *                        расписание, делегирование, найм
 *   barista_economics  — экономика: себестоимость, маржинальность,
 *                        средний чек, оборот, потери продуктов
 *   barista_quality    — контроль качества: Q-grader, аудит, сравнительный
 *                        тест, оценочный лист, единообразие
 *   barista_training   — обучение: профобучение, чек-лист задач, стандарт
 *                        сервиса, наставничество, сертификация
 *   barista_culture    — культура: третья волна, наследие, ритуал питья,
 *                        наука гостеприимства, этичное потребление
 *
 * Word IDs: setId × 100 + position (179701..179725).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён
 * до прохода LLM-pipeline по набору.
 */
object WordDataHebrewBaristaL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1797, languagePair = "he-ru", orderIndex = 1797,
            name = "Кофейня и работа баристой",
            description = "Управление кофейней: оператор, экономика, тренинг, культура кофе",
            topic = "Кофейня и работа баристой", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1797 — Кофейня и работа баристой: носитель языка (L5, EPIC + LEGENDARY)
        // 5 групп × 5 слов: management, economics, quality, training, culture
        // ══════════════════════════════════════════════════════════════════════

        // ── barista_management (5) — управление и кадровые роли ──
        WordEntity(
            id = 179701, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_management", transliteration = "menahel beit kafe",
            original = "מְנַהֵל בֵּית קָפֶה", translation = "директор кофейни",
            definition = "אָדָם שֶׁאַחְרָאִי עַל כָּל מַה שֶּׁקּוֹרֶה בַּמָּקוֹם — צֶוֶת, כֶּסֶף וְלָקוֹחוֹת.",
            definitionNative = "Главный над всем заведением — командой, деньгами и гостями.",
            example = "מְנַהֵל בֵּית קָפֶה הִחְלִיט לִפְתֹּחַ סָנִיף שֵׁנִי בָּעִיר.",
            exampleNative = "מְנַהֵל בֵּית קָפֶה решил открыть второй филиал в городе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179702, setId = 1797, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_management", transliteration = "akhrai aspaka",
            original = "אַחֲרַאי הַסְפָּקָה", translation = "ответственный за поставки",
            definition = "עוֹבֵד שֶׁדּוֹאֵג לְכָךְ שֶׁתָּמִיד יִהְיוּ פּוֹלִים, חָלָב וּכְלֵי עֲבוֹדָה בַּמַּחְסָן.",
            definitionNative = "Сотрудник следит, чтобы на складе всегда были зёрна, молоко и инвентарь.",
            example = "אַחֲרַאי הַסְפָּקָה הִזְמִין שַׂקֵּי פּוֹלִים נוֹסָפִים לִפְנֵי הַחַג.",
            exampleNative = "אַחֲרַאי הַסְפָּקָה заказал дополнительные мешки зёрен перед праздником.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179703, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_management", transliteration = "sidur avoda",
            original = "סִדּוּר עֲבוֹדָה", translation = "график работы",
            definition = "טַבְלָה שֶׁמּוֹרָה לְכָל אֶחָד בַּצֶּוֶת מָתַי לָבוֹא וּמָתַי לָלֶכֶת הַבַּיְתָה.",
            definitionNative = "Таблица — кому из команды когда приходить и когда домой.",
            example = "תָּלִיתִי אֶת סִדּוּר עֲבוֹדָה בַּמִּטְבָּח לִפְנֵי הַשַּׁבָּת.",
            exampleNative = "Я повесил סִדּוּר עֲבוֹדָה на кухне перед субботой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179704, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_management", transliteration = "khalukat tafkidim",
            original = "חֲלוּקַת תַּפְקִידִים", translation = "распределение обязанностей",
            definition = "כְּשֶׁכָּל אֶחָד בַּצֶּוֶת יוֹדֵעַ בְּדִיּוּק עַל מָה הוּא אַחְרָאִי בַּמִּשְׁמֶרֶת.",
            definitionNative = "Когда каждый в команде точно знает, за что отвечает в смену.",
            example = "חֲלוּקַת תַּפְקִידִים בְּרוּרָה מוֹרִידָה רִיבִים בֵּין הַצֶּוֶת.",
            exampleNative = "Понятная חֲלוּקַת תַּפְקִידִים уменьшает ссоры между сотрудниками.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179705, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_management", transliteration = "giyus muamadim",
            original = "גִּיּוּס מֻעֳמָדִים", translation = "найм кандидатов",
            definition = "תַּהֲלִיךְ שֶׁל חִפּוּשׁ אֲנָשִׁים חֲדָשִׁים, רֵאָיוֹן וּבְחִירָה לְעַבְדָה בַּמָּקוֹם.",
            definitionNative = "Поиск новых людей, собеседование и выбор сотрудника на работу.",
            example = "גִּיּוּס מֻעֳמָדִים אָרַךְ חֹדֶשׁ עַד שֶׁמָּצָאנוּ אֶת הַמַּתְאִים.",
            exampleNative = "גִּיּוּס מֻעֳמָדִים длился месяц, пока мы нашли подходящего.",
            isFillInBlankSafe = false,
        ),

        // ── barista_economics (5) — экономика заведения ──
        WordEntity(
            id = 179706, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_economics", transliteration = "alut hakos",
            original = "עֲלוּת הַכּוֹס", translation = "себестоимость чашки",
            definition = "כַּמָּה כֶּסֶף יוֹצֵא לַבַּעְלִים לְהָכִין מָנָה אַחַת — חוּמְרֵי גֶּלֶם וְעֲבוֹדָה.",
            definitionNative = "Сколько уходит у хозяина на одну порцию — продукты и труд.",
            example = "עֲלוּת הַכּוֹס שֶׁל לָאטֶה גָּדוֹל הִיא כִּשְׁלוֹשָׁה שְׁקָלִים בִּלְבַד.",
            exampleNative = "עֲלוּת הַכּוֹס большого латте — около трёх шекелей всего.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179707, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_economics", transliteration = "rivkhiyut",
            original = "רִוְוחִיּוּת", translation = "маржинальность, доходность",
            definition = "כַּמָּה כֶּסֶף נִשְׁאָר לַבַּעְלִים מִכָּל מְכִירָה אַחֲרֵי הַהוֹצָאוֹת.",
            definitionNative = "Сколько денег остаётся хозяину с каждой продажи после расходов.",
            example = "רִוְוחִיּוּת הָעֳסָק עָלְתָה אַחֲרֵי שֶׁהוֹרַדְנוּ עוֹבְדִים מְיֻתָּרִים.",
            exampleNative = "רִוְוחִיּוּת бизнеса выросла после сокращения лишних сотрудников.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179708, setId = 1797, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_economics", transliteration = "sal kniya memutsa",
            original = "סַל קְנִיָּה מְמֻצָּע", translation = "средний чек заказа",
            definition = "סְכוּם טִיפּוּסִי שֶׁלָּקוֹחַ מְשַׁלֵּם בְּבִקּוּר אֶחָד עַל כָּל מָה שֶׁלָּקַח.",
            definitionNative = "Типичная сумма, которую гость платит за один визит.",
            example = "סַל קְנִיָּה מְמֻצָּע גָּדַל אַחֲרֵי שֶׁהוֹסַפְנוּ מַאֲפִים טְרִיִּים.",
            exampleNative = "סַל קְנִיָּה מְמֻצָּע вырос после добавления свежей выпечки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179709, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_economics", transliteration = "makhzor yomi",
            original = "מַחְזוֹר יוֹמִי", translation = "дневной оборот",
            definition = "סַךְ הַכֶּסֶף שֶׁהַקֻּפָּה אָסְפָה מִכָּל הַמְּכִירוֹת מֵהַבֹּקֶר עַד הַסְּגִירָה.",
            definitionNative = "Итог всех чеков кассы за одни сутки работы.",
            example = "מַחְזוֹר יוֹמִי שָׁבוּר הַשֵּׂיא בַּחֻפְשָׁה הַגְּדוֹלָה שֶׁל הַיְּלָדִים.",
            exampleNative = "מַחְזוֹר יוֹמִי побил рекорд в большие школьные каникулы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179710, setId = 1797, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_economics", transliteration = "pkhat khomarim",
            original = "פְּחָת חֳמָרִים", translation = "потери продуктов, списания",
            definition = "אֲבֵדָה כַּסְפִּית מִתּוֹצָר שֶׁהִתְקַלְקֵל, נִשְׁפַּךְ אוֹ עָבַר תָּאֲרִיךְ אַחֲרוֹן.",
            definitionNative = "Денежная утрата от испортившегося, разлитого или просроченного сырья.",
            example = "פְּחָת חֳמָרִים יָרַד מֵחָמֵשׁ אָחוּז לִשְׁתַּיִם בְּעֶזְרַת מְדִידָה מְדֻיֶּקֶת.",
            exampleNative = "פְּחָת חֳמָרִים упал с пяти процентов до двух благодаря точному учёту.",
            isFillInBlankSafe = false,
        ),

        // ── barista_quality (5) — контроль качества ──
        WordEntity(
            id = 179711, setId = 1797, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_quality", transliteration = "kyu greider",
            original = "קְיוּ-גְרֵיידֶר", translation = "Q-grader (профдегустатор)",
            definition = "מֻמְחֶה מֻסְמָךְ בֵּינְלְאֻמִּי שֶׁנּוֹתֵן צִיּוּן רִשְׁמִי לְפוֹלִים יְרֻקִּים מֵאַרְצוֹת מָקוֹר.",
            definitionNative = "Сертифицированный международный эксперт ставит официальную оценку зелёным зёрнам.",
            example = "קְיוּ-גְרֵיידֶר הִגִּיעַ מֵיָּפָן לִבְדֹּק אֶת הַיְבוּל הַחָדָשׁ.",
            exampleNative = "קְיוּ-גְרֵיידֶר приехал из Японии проверить новый урожай.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179712, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_quality", transliteration = "bikoret eikhut",
            original = "בִּקֹּרֶת אֵיכוּת", translation = "аудит качества",
            definition = "בְּדִיקָה רִשְׁמִית שֶׁל אִישׁ חִיצוֹנִי אֵיךְ הַמָּקוֹם עוֹמֵד בְּסְטַנְדַּרְטִים מִקְצוֹעִיִּים.",
            definitionNative = "Официальная проверка постороннего — соответствует ли заведение профстандартам.",
            example = "בִּקֹּרֶת אֵיכוּת מְפַתַּעַת חָשְׂפָה בְּעָיוֹת בִּפְרוֹצֶדוּרַת הַנִּקָּיוֹן.",
            exampleNative = "Внеплановый בִּקֹּרֶת אֵיכוּת вскрыл проблемы с уборкой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179713, setId = 1797, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_quality", transliteration = "mivkhan hashvaati",
            original = "מִבְחָן הַשְׁוָאָתִי", translation = "сравнительный тест (cupping)",
            definition = "כְּשֶׁמַּגִּישִׁים יַחַד כַּמָּה דְּגָמִים סְמוּיִים כְּדֵי לְהַחְלִיט אֵיזֶה הָכִי טוֹב.",
            definitionNative = "Когда вместе подают несколько обезличенных образцов и выбирают лучший.",
            example = "עָרַכְנוּ מִבְחָן הַשְׁוָאָתִי בֵּין שְׁלוֹשָׁה סַפָּקִים חֲדָשִׁים.",
            exampleNative = "Мы устроили מִבְחָן הַשְׁוָאָתִי между тремя новыми поставщиками.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179714, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_quality", transliteration = "daf haarakha",
            original = "דַּף הַעֲרָכָה", translation = "оценочный лист",
            definition = "טֹפֶס עִם נְקֻדּוֹת לְצִיּוּן רֵיחַ, מִרְקָם וּתְכוּנוֹת שֶׁל כָּל דֶּגֶם נִבְדָּק.",
            definitionNative = "Бланк с пунктами для пометок о запахе, текстуре и свойствах каждого образца.",
            example = "מִלֵּאתִי דַּף הַעֲרָכָה לְכָל פּוֹל וְהִשְׁוֵיתִי בַּסּוֹף.",
            exampleNative = "Я заполнил דַּף הַעֲרָכָה на каждое зерно и сравнил в конце.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179715, setId = 1797, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_quality", transliteration = "akhidut mashke",
            original = "אֲחִידוּת מַשְׁקֶה", translation = "единообразие напитка",
            definition = "כְּשֶׁכָּל מָנָה יוֹצֵאת בְּדִיּוּק כְּמוֹ הַקּוֹדֶמֶת, בְּלִי הַבְדֵּלִים בֵּין מִשְׁמְרוֹת.",
            definitionNative = "Когда каждая порция выходит ровно как предыдущая, без отличий между сменами.",
            example = "אֲחִידוּת מַשְׁקֶה הִיא הַסּוֹד שֶׁל רֶשֶׁת מַצְלִיחָה.",
            exampleNative = "אֲחִידוּת מַשְׁקֶה — секрет успешной сети.",
            isFillInBlankSafe = false,
        ),

        // ── barista_training (5) — обучение и наставничество ──
        WordEntity(
            id = 179716, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_training", transliteration = "hakhshara miktsoit",
            original = "הַכְשָׁרָה מִקְצוֹעִית", translation = "профессиональная подготовка",
            definition = "קוּרְס מְסֻדָּר שֶׁמְּלַמֵּד עוֹבֵד חָדָשׁ אֶת כָּל הַטְּכָנִיקוֹת מֵהַיְּסוֹדוֹת.",
            definitionNative = "Систематический курс — учит новичка всем техникам с азов.",
            example = "הַכְשָׁרָה מִקְצוֹעִית אוֹרֶכֶת חֹדֶשׁ לִפְנֵי שֶׁעוֹלִים לַדֶּלְפֵּק.",
            exampleNative = "הַכְשָׁרָה מִקְצוֹעִית длится месяц до выхода за стойку.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179717, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_training", transliteration = "reshimat mesimot",
            original = "רְשִׁימַת מְשִׁימוֹת", translation = "чек-лист задач",
            definition = "דַּף עִם פְּעֻלּוֹת מְסֻדָּרוֹת שֶׁצָּרִיךְ לְבַצֵּעַ וּלְסַמֵּן בְּאוֹתוֹ סֵדֶר כָּל בֹּקֶר.",
            definitionNative = "Лист с упорядоченными действиями — выполнить и отметить в том же порядке.",
            example = "רְשִׁימַת מְשִׁימוֹת תְּלוּיָה לְיַד הַמִּטְבָּח לְכָל מִי שֶׁמַּתְחִיל.",
            exampleNative = "רְשִׁימַת מְשִׁימוֹת висит у кухни для каждого, кто начинает.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179718, setId = 1797, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_training", transliteration = "teken sherut",
            original = "תֶּקֶן שֵׁרוּת", translation = "стандарт обслуживания",
            definition = "מִסְמָךְ שֶׁמַּגְדִּיר אֵיךְ לְקַבֵּל לָקוֹחַ, לְדַבֵּר וְלִתֵּן מָנָה בְּכָל מִקְרֶה.",
            definitionNative = "Документ — как принять гостя, говорить и подавать заказ в каждом случае.",
            example = "תֶּקֶן שֵׁרוּת אָסַר לְהַשְׁאִיר שֻׁלְחָן בְּלִי טִפּוּל מֵעַל שָׁלוֹשׁ דַּקּוֹת.",
            exampleNative = "תֶּקֶן שֵׁרוּת запрещает оставлять стол без внимания дольше трёх минут.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179719, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_training", transliteration = "khanikha",
            original = "חֲנִיכָה", translation = "наставничество",
            definition = "כְּשֶׁעוֹבֵד וָתִיק מַעֲבִיר אֶת הַיֵּדַע שֶׁלּוֹ לְעוֹבֵד צָעִיר וְעוֹזֵר בִּצְעָדִים רִאשׁוֹנִים.",
            definitionNative = "Когда опытный передаёт знания молодому и помогает на первых шагах.",
            example = "חֲנִיכָה אֵצֶל וָתִיק שָׁוָה יוֹתֵר מִכָּל סֵפֶר לִמּוּד.",
            exampleNative = "חֲנִיכָה у ветерана стоит больше любого учебника.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179720, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_training", transliteration = "hasmakha",
            original = "הַסְמָכָה", translation = "сертификация",
            definition = "תְּעוּדָה רִשְׁמִית שֶׁמְּאַשֶּׁרֶת שֶׁאָדָם עָבַר מִבְחָנִים וְיוֹדֵעַ אֶת הַמִּקְצוֹעַ.",
            definitionNative = "Официальная бумага подтверждает, что человек сдал тесты и владеет ремеслом.",
            example = "בְּלִי הַסְמָכָה רִשְׁמִית קָשֶׁה לְהִתְקַבֵּל לְרֶשֶׁת בֵּינְלְאֻמִּית.",
            exampleNative = "Без официальной הַסְמָכָה трудно попасть в международную сеть.",
            isFillInBlankSafe = false,
        ),

        // ── barista_culture (5) — культура и философия ──
        WordEntity(
            id = 179721, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_culture", transliteration = "gal shlishi",
            original = "גַּל שְׁלִישִׁי", translation = "третья волна (кофейная культура)",
            definition = "תְּקוּפָה מוֹדֶרְנִית שֶׁבָּהּ הַמַּשְׁקֶה הַחַם נֶחְשָׁב לְאָמָּנוּת וְלֹא רַק לַסְּחוֹרָה.",
            definitionNative = "Современная эпоха — горячий напиток как искусство, а не товар.",
            example = "גַּל שְׁלִישִׁי הִגִּיעַ לְתֵל אָבִיב וְשִׁנָּה אֶת הַשּׁוּק לָנֶצַח.",
            exampleNative = "גַּל שְׁלִישִׁי пришёл в Тель-Авив и навсегда изменил рынок.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179722, setId = 1797, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_culture", transliteration = "moreshet kulinarit",
            original = "מוֹרֶשֶׁת קוּלִינָרִית", translation = "кулинарное наследие",
            definition = "מָסֹרֶת אֲרֻכָּה שֶׁל מַתְכּוֹנִים וְהֶרְגֵּלִים שֶׁעוֹבְרִים מִדּוֹר לְדוֹר בְּתוֹךְ עַם.",
            definitionNative = "Долгая традиция рецептов и привычек, идущая из поколения в поколение.",
            example = "מוֹרֶשֶׁת קוּלִינָרִית עוֹתְּמָאנִית הִשְׁפִּיעָה עַל אֵיךְ שׁוֹתִים בָּאָרֶץ.",
            exampleNative = "Османская מוֹרֶשֶׁת קוּלִינָרִית повлияла на то, как пьют в Израиле.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179723, setId = 1797, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_culture", transliteration = "tarbut hashtiya",
            original = "תַּרְבּוּת הַשְּׁתִיָּה", translation = "культура питья",
            definition = "אֹסֶף שֶׁל מִנְהָגִים וְכְלָלִים אֵיךְ אֲנָשִׁים מַגִּישִׁים וּמְבַלִּים בְּזְמַן הַמַּשְׁקֶה.",
            definitionNative = "Свод обычаев — как подают и проводят время за чашкой в обществе.",
            example = "תַּרְבּוּת הַשְּׁתִיָּה הַטּוּרְקִית מַעֲבִירָה אֲנָשִׁים שָׁעוֹת אֲרֻכּוֹת בְּשִׂיחָה.",
            exampleNative = "Турецкая תַּרְבּוּת הַשְּׁתִיָּה удерживает людей часами в беседе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179724, setId = 1797, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_culture", transliteration = "torat haerukh",
            original = "תּוֹרַת הָאֵירוּחַ", translation = "наука гостеприимства",
            definition = "גִּישָׁה מִקְצוֹעִית אֵיךְ לְקַבֵּל אֲנָשִׁים בְּאֹפֶן שֶׁיַּרְגִּישׁוּ בְּבַיִת וְיַחְזְרוּ שׁוּב.",
            definitionNative = "Профподход — как принять людей, чтобы чувствовали себя дома и вернулись.",
            example = "תּוֹרַת הָאֵירוּחַ הַיַּפָּנִית מְלַמֶּדֶת שֶׁכָּל פְּרָט קָטָן חָשׁוּב.",
            exampleNative = "Японская תּוֹרַת הָאֵירוּחַ учит, что важна каждая мелочь.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179725, setId = 1797, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_culture", transliteration = "tsrikha etit",
            original = "צְרִיכָה אֶתִית", translation = "этичное потребление",
            definition = "בְּחִירָה לִקְנוֹת רַק מִסַּפָּקִים שֶׁמְּשַׁלְּמִים נָכוֹן לַחַוַּאִים וְשׁוֹמְרִים עַל הַטֶּבַע.",
            definitionNative = "Выбор покупать у тех, кто честно платит фермерам и бережёт природу.",
            example = "צְרִיכָה אֶתִית הוֹפְכָה לְמִגְמָה אַחֲרֵי שֶׁדּוֹר חָדָשׁ דּוֹרֵשׁ שְׁקִיפוּת.",
            exampleNative = "צְרִיכָה אֶתִית стала трендом, когда новое поколение требует прозрачности.",
            isFillInBlankSafe = false,
        ),
    )
}
