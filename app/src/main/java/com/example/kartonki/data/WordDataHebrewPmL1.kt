package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Продуктовый менеджмент", уровень 1 «Основы» (COMMON+UNCOMMON).
 *
 * Set 1777: «Продуктовый менеджмент» — основы (L1):
 *           Базовая лексика: продукт, пользователь, отзыв, идея, цели.
 *
 * Тема ориентирована на русскоязычных репатриантов, делающих первые шаги
 * в продуктовом менеджменте в израильском хайтеке. Это лексика, которую
 * слышишь в первый рабочий месяц на любых product-стендапах: о продукте,
 * пользователях, обратной связи, идеях и целях команды.
 *
 * В отличие от старших уровней, здесь — общеупотребительные ивритские слова
 * без англицизмов из жаргона PM (PRD, OKR, AARRR, JTBD и т.п. живут в L3/L4).
 *
 * Намеренно НЕ дублирует:
 *   • PmL3 (1765, RARE+EPIC): профессиональный PM-словарь — interview, persona,
 *     PRD, backlog, conversion rate, DAU, north star, customer journey.
 *   • PmL4 (1766, EPIC+LEGENDARY): senior-уровень — vision, mission, OKR,
 *     AARRR, viral loop, feature toggle, P&L ownership, RICE, MoSCoW.
 *   • Хайтек L1 (1745): хотя обе темы об индустрии, дубли originals не
 *     создаются — здесь общие термины продуктового мышления (мууцар, шерут,
 *     юкхолет), там — узко-индустриальные роли и инструменты (метахнет,
 *     платформа, лаптоп). Хайтек уже имеет аппликацию/сайт — но они в РАЗНЫХ
 *     темах, дубли originals между темами разрешены.
 *
 * Распределение редкостей:
 *   13 COMMON + 12 UNCOMMON.
 *
 * SemanticGroups (5 × 5):
 *   pm_basic_users    — кому продукт служит: пользователь, клиент, посетитель,
 *                       подписчик, аудитория
 *   pm_basic_product  — что мы строим: продукт, сервис, приложение, сайт, функция
 *   pm_basic_feedback — что нам говорят: отзыв, оценка, комментарий, жалоба,
 *                       благодарность
 *   pm_basic_ideas    — откуда берётся работа: идея, запрос, потребность,
 *                       проблема, решение
 *   pm_basic_goals    — куда движемся: цель, задача, план, дедлайн, успех
 *
 * Word IDs: setId × 100 + position (177701..177725).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewPmL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1777, languagePair = "he-ru", orderIndex = 1777,
            name = "Продуктовый менеджмент",
            description = "Базовая лексика: продукт, пользователь, отзыв, идея, цели",
            topic = "Продуктовый менеджмент", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1777 — Продуктовый менеджмент: основы (L1, COMMON+UNCOMMON, A1-A2)
        // 5 групп × 5 слов: users, product, feedback, ideas, goals
        // ══════════════════════════════════════════════════════════════════════

        // ── pm_basic_users (5) — кому продукт служит ──
        WordEntity(
            id = 177701, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_users", transliteration = "mishtamesh",
            original = "מִשְׁתַּמֵּשׁ", translation = "пользователь",
            definition = "מִי שֶׁפּוֹתֵחַ מוּצָר וּמַפְעִיל אוֹתוֹ בַּחַיִּים שֶׁל יוֹם-יוֹם.",
            definitionNative = "Тот, кто открывает продукт и пользуется им в обычной жизни.",
            example = "כָּל מִשְׁתַּמֵּשׁ חָדָשׁ עוֹבֵר אוֹנְבּוֹרְדִּינְג שֶׁל שָׁלוֹשׁ דַּקּוֹת.",
            exampleNative = "Каждый новый מִשְׁתַּמֵּשׁ проходит онбординг на три минуты.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177702, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_users", transliteration = "lakoach",
            original = "לָקוֹחַ", translation = "клиент",
            definition = "אָדָם אוֹ חֶבְרָה שֶׁמְּשַׁלֵּם כֶּסֶף עַל הַשֵּׁרוּת אוֹ הַסַּחוֹרָה.",
            definitionNative = "Человек или фирма, что платит деньги за услугу или товар.",
            example = "כָּל לָקוֹחַ חָשׁוּב לָנוּ — בִּמְיֻחָד בַּחֹדֶשׁ הָרִאשׁוֹן אַחֲרֵי הַהַשְׁקָה.",
            exampleNative = "Каждый לָקוֹחַ нам важен — особенно в первый месяц после запуска.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177703, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_users", transliteration = "mevaker",
            original = "מְבַקֵּר", translation = "посетитель",
            definition = "מִי שֶׁנִּכְנָס לַדַּף אוֹ לָאַתָר רַק לְזְמַן קָצָר וְלֹא בְּהֶכְרֵחַ נִרְשָׁם.",
            definitionNative = "Тот, кто заходит на страницу или сайт ненадолго и не обязательно регистрируется.",
            example = "כָּל מְבַקֵּר בַּדַּף שֶׁלָּנוּ נִשְׁאָר בַּמֻּצָע פָּחוֹת מִדַּקָּה.",
            exampleNative = "Каждый מְבַקֵּר на нашей странице остаётся в среднем меньше минуты.",
         fillInBlankExclusions = listOf(177701L, 177702L, 177704L, 177705L)),
        WordEntity(
            id = 177704, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_users", transliteration = "okev",
            original = "עוֹקֵב", translation = "подписчик",
            definition = "מִי שֶׁבָּחַר לְקַבֵּל עִדְכּוּנִים מֵהַחֶבְרָה בְּדֹאַר אוֹ בָּרֶשֶׁת הַחֶבְרָתִית.",
            definitionNative = "Тот, кто согласился получать обновления от компании по почте или в соцсети.",
            example = "כָּל עוֹקֵב חָדָשׁ בָּעַמּוּד שֶׁלָּנוּ מַגְדִּיל אֶת הַחֲשִׂיפָה הָאַרְגָּנִית.",
            exampleNative = "Каждый новый עוֹקֵב на нашей странице растит органический охват.",
         fillInBlankExclusions = listOf(177701L, 177702L, 177703L, 177705L)),
        WordEntity(
            id = 177705, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_users", transliteration = "kahal",
            original = "קָהָל", translation = "аудитория",
            definition = "קְבוּצָה גְּדוֹלָה שֶׁל אַנָשִׁים שֶׁהַמּוּצָר מְכַוֵּן אֲלֵיהֶם בְּסוֹף.",
            definitionNative = "Большая группа людей, на которую продукт в итоге нацелен.",
            example = "קָהָל שֶׁלָּנוּ מְכִיל הוֹרִים צְעִירִים בְּגִיל שְׁלוֹשִׁים עַד אַרְבָּעִים.",
            exampleNative = "Наш קָהָל включает молодых родителей от тридцати до сорока лет.",
         fillInBlankExclusions = listOf(177701L, 177702L, 177703L, 177704L)),

        // ── pm_basic_product (5) — что мы строим ──
        WordEntity(
            id = 177706, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_product", transliteration = "mutsar",
            original = "מוּצָר", translation = "продукт",
            definition = "מַשֶּׁהוּ שֶׁחֶבְרָה מַכִּינָה כְּדֵי לִמְכֹּר אוֹ לָתֵת לְאַנָשִׁים בַּחַיִּים שֶׁלָּהֶם.",
            definitionNative = "То, что компания делает на продажу или для людей в их жизни.",
            example = "מוּצָר חָדָשׁ שֶׁלָּנוּ יוֹצֵא לָאֲוִיר בַּחֹדֶשׁ הַבָּא.",
            exampleNative = "Наш новый מוּצָר выходит в эфир в следующем месяце.",
         fillInBlankExclusions = listOf(177707L, 177708L, 177709L, 177710L)),
        WordEntity(
            id = 177707, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_product", transliteration = "sherut",
            original = "שֵׁרוּת", translation = "сервис",
            definition = "פְּעֻלָּה שֶׁחֶבְרָה עוֹשָׂה עֲבוּר אַנָשִׁים תְּמוּרַת תַּשְׁלוּם — לֹא חֵפֶץ פִיזִי.",
            definitionNative = "Действие, что фирма делает за плату — не физическая вещь, а помощь или работа.",
            example = "אֲנַחְנוּ נוֹתְנִים שֵׁרוּת שֶׁל אִחְסוּן קְבָצִים בָּעָנָן לִמְפַתְּחִים.",
            exampleNative = "Мы предоставляем שֵׁרוּת облачного хранения файлов разработчикам.",
         fillInBlankExclusions = listOf(177706L, 177708L, 177709L, 177710L)),
        WordEntity(
            id = 177708, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_product", transliteration = "aplikatsya",
            original = "אַפְּלִיקַצְיָה", translation = "приложение",
            definition = "תּוֹכְנָה לַטֶּלֶפוֹן שֶׁעוֹשָׂה דָּבָר אֶחָד טוֹב — מַפָּה, מוּזִיקָה אוֹ קְנִיּוֹת.",
            definitionNative = "Программа в телефоне для одного дела — карты, музыка или покупки.",
            example = "אַפְּלִיקַצְיָה שֶׁלָּנוּ עָלְתָה לְמָקוֹם שְׁלִישִׁי בַּחֲנוּת בְּיִשְׂרָאֵל.",
            exampleNative = "Наша אַפְּלִיקַצְיָה поднялась до третьего места в магазине в Израиле.",
         fillInBlankExclusions = listOf(177706L, 177707L, 177709L, 177710L)),
        WordEntity(
            id = 177709, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_product", transliteration = "atar",
            original = "אֲתַר", translation = "сайт",
            definition = "אֹסֶף דַּפִּים בָּרֶשֶׁת עִם כְּתֹבֶת קְבוּעָה שֶׁפּוֹתְחִים בַּדַּפְדְּפָן.",
            definitionNative = "Набор страниц в сети с постоянным адресом — открывают в браузере.",
            example = "הָאֲתַר שֶׁל הַחֶבְרָה נִבְנָה מֵחָדָשׁ בְּעִצּוּב מוֹדֶרְנִי.",
            exampleNative = "Корпоративный אֲתַר перестроили в современном дизайне.",
         fillInBlankExclusions = listOf(177706L, 177707L, 177708L, 177710L)),
        WordEntity(
            id = 177710, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_product", transliteration = "yekholet",
            original = "יְכוֹלֶת", translation = "функция",
            definition = "מַשֶּׁהוּ שֶׁהַמּוּצָר יוֹדֵעַ לַעֲשׂוֹת — לְמָשָׁל לְהַתְרִיעַ אוֹ לְשַׁמֵּר נְתוּנִים.",
            definitionNative = "То, что продукт умеет делать — например, оповещать или сохранять данные.",
            example = "הוֹסַפְנוּ יְכוֹלֶת חֲדָשָׁה לְשִׁתּוּף קָבְצֵי וִידֵאוֹ בֵּין צְוָתִים.",
            exampleNative = "Мы добавили новую יְכוֹלֶת — обмен видеофайлами между командами.",
         fillInBlankExclusions = listOf(177706L, 177707L, 177708L, 177709L)),

        // ── pm_basic_feedback (5) — что нам говорят пользователи ──
        WordEntity(
            id = 177711, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_feedback", transliteration = "khavat daat",
            original = "חַוַּת דַּעַת", translation = "отзыв",
            definition = "טֶקְסְט שֶׁלָּקוֹחַ כּוֹתֵב אַחֲרֵי שִׁמּוּשׁ — מָה הָיָה טוֹב וּמָה הִפְרִיעַ לוֹ.",
            definitionNative = "Текст, что клиент пишет после использования — что было хорошо и что мешало.",
            example = "כָּתַבְתִּי חַוַּת דַּעַת אֲרֻכָּה עַל הַמִּסְעָדָה הַחֲדָשָׁה בָּרְחוֹב הָרָאשִׁי.",
            exampleNative = "Я написал длинный חַוַּת דַּעַת про новый ресторан на главной улице.",
         fillInBlankExclusions = listOf(177712L, 177713L, 177714L, 177715L)),
        WordEntity(
            id = 177712, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_feedback", transliteration = "derug",
            original = "דֵּרוּג", translation = "оценка",
            definition = "מַסְפָּר אוֹ כּוֹכָבִים שֶׁלָּקוֹחַ נוֹתֵן לַמּוּצָר — מֵאֶחָד עַד חֲמִשָּׁה לְרֹב.",
            definitionNative = "Цифра или звёзды, что клиент ставит продукту — обычно от одного до пяти.",
            example = "הַדֵּרוּג שֶׁלָּנוּ בַּחֲנוּת יָרַד בִּגְלַל בָּאג בָּגִּרְסָה הָאַחֲרוֹנָה.",
            exampleNative = "Наш דֵּרוּג в магазине упал из-за бага в последней версии.",
         fillInBlankExclusions = listOf(177711L, 177713L, 177714L, 177715L)),
        WordEntity(
            id = 177713, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_feedback", transliteration = "tguva",
            original = "תְּגוּבָה", translation = "комментарий",
            definition = "מִשְׁפָּט קָצָר שֶׁמִּישֶׁהוּ מוֹסִיף לְפוֹסְט אוֹ לְוִידֵאוֹ כְּדֵי לַעֲנוֹת אוֹ לְהַבִּיעַ דֵּעָה.",
            definitionNative = "Короткая фраза — её добавляют к посту или видео, чтобы ответить или высказать мнение.",
            example = "קִבַּלְנוּ תְּגוּבָה זוֹעֶמֶת מִלָּקוֹחַ עַל זְמַן הַטְּעִינָה הָאָרֹךְ.",
            exampleNative = "Мы получили гневный תְּגוּבָה от клиента на долгое время загрузки.",
         fillInBlankExclusions = listOf(177711L, 177712L, 177714L, 177715L)),
        WordEntity(
            id = 177714, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_feedback", transliteration = "tluna",
            original = "תְּלוּנָה", translation = "жалоба",
            definition = "פְּנִיָּה כַּעֲסָנִית שֶׁלָּקוֹחַ שׁוֹלֵחַ כְּשֶׁמַּשֶּׁהוּ לֹא עוֹבֵד אוֹ פָּגַע בּוֹ.",
            definitionNative = "Сердитое обращение клиента — когда что-то не работает или его обидели.",
            example = "פָּתַחְנוּ תְּלוּנָה רִשְׁמִית לַמּוֹקֵד אַחֲרֵי שֶׁהַמַּשְׁלוֹחַ אִחֵר בִּשְׁבוּעַיִם.",
            exampleNative = "Мы открыли официальную תְּלוּנָה в кол-центр после того, как доставка опоздала на две недели.",
         fillInBlankExclusions = listOf(177711L, 177712L, 177713L, 177715L)),
        WordEntity(
            id = 177715, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_feedback", transliteration = "toda",
            original = "תּוֹדָה", translation = "благодарность",
            definition = "מִלָּה שֶׁאוֹמְרִים כְּשֶׁמִּישֶׁהוּ עָזַר אוֹ עָשָׂה דָּבָר טוֹב בִּשְׁבִיל אַחֵר.",
            definitionNative = "Слово, которое говорят, когда кто-то помог или сделал хорошее для другого.",
            example = "כָּל לָקוֹחַ שֶׁכָּתַב לָנוּ תּוֹדָה חַמָּה הוּזְכַּר בַּפְּגִישָׁה הַשְּׁבוּעִית.",
            exampleNative = "Каждый клиент, написавший нам тёплую תּוֹדָה, упомянут на еженедельной встрече.",
         fillInBlankExclusions = listOf(177711L, 177712L, 177713L, 177714L)),

        // ── pm_basic_ideas (5) — откуда берётся работа ──
        WordEntity(
            id = 177716, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_ideas", transliteration = "rayon",
            original = "רַעְיוֹן", translation = "идея",
            definition = "מַחֲשָׁבָה חֲדָשָׁה עַל מַה שֶׁשָּׁוֶה לִבְנוֹת אוֹ לְשַׁפֵּר בַּמּוּצָר.",
            definitionNative = "Свежая мысль о том, что стоит построить или улучшить в продукте.",
            example = "רַעְיוֹן שֶׁל מְפַתֵּחַ צָעִיר הָפַךְ לַפִּיצֶ'ר הַכִּי פּוֹפּוּלָרִי בַּמּוּצָר.",
            exampleNative = "רַעְיוֹן молодого разработчика стал самой популярной фичей в продукте.",
         fillInBlankExclusions = listOf(177717L, 177718L, 177719L, 177720L)),
        WordEntity(
            id = 177717, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_ideas", transliteration = "bakasha",
            original = "בַּקָּשָׁה", translation = "запрос",
            definition = "פְּנִיָּה שֶׁלָּקוֹחַ שׁוֹלֵחַ כְּדֵי שֶׁנּוֹסִיף יְכוֹלֶת אוֹ נְשַׁנֶּה מַשֶּׁהוּ קַיָּם.",
            definitionNative = "Обращение клиента — чтобы мы добавили возможность или поменяли что-то существующее.",
            example = "בַּקָּשָׁה לְמַצָּב כֵּהֶה הָיְתָה הַנְּפוֹצָה בְּיוֹתֵר בָּרֹבַע הָאַחֲרוֹן.",
            exampleNative = "בַּקָּשָׁה о тёмной теме была самой частой за последний квартал.",
         fillInBlankExclusions = listOf(177716L, 177718L, 177719L, 177720L)),
        WordEntity(
            id = 177718, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_ideas", transliteration = "tsorekh",
            original = "צֹרֶךְ", translation = "потребность",
            definition = "מַשֶּׁהוּ שֶׁחָסֵר לָאָדָם בַּחַיִּים — הוּא יְשַׁלֵּם כְּדֵי לְקַבֵּל פִּתְרוֹן בִּשְׁבִילוֹ.",
            definitionNative = "То, чего человеку не хватает в жизни — он заплатит, чтобы получить ответ на это.",
            example = "זִהִינוּ צֹרֶךְ אֲמִיתִּי בְּקֶרֶב הוֹרִים שֶׁעוֹבְדִים מֵהַבַּיִת.",
            exampleNative = "Мы выявили реальный צֹרֶךְ среди родителей, что работают из дома.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177719, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_ideas", transliteration = "beaya",
            original = "בְּעָיָה", translation = "проблема",
            definition = "מַצָּב שֶׁמַּפְרִיעַ לָאָדָם לְהַשִּׂיג מָה שֶׁהוּא רוֹצֶה אוֹ צָרִיךְ.",
            definitionNative = "Ситуация, что мешает человеку получить желаемое или нужное.",
            example = "מָצָאנוּ בְּעָיָה גְּדוֹלָה בָּמָסָךְ הַתַּשְׁלוּם — מִשְׁתַּמְּשִׁים נוֹטְשִׁים שָׁם.",
            exampleNative = "Мы нашли серьёзный בְּעָיָה на экране оплаты — пользователи там уходят.",
         fillInBlankExclusions = listOf(177716L, 177717L, 177718L, 177720L)),
        WordEntity(
            id = 177720, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_ideas", transliteration = "pitaron",
            original = "פִּתְרוֹן", translation = "решение",
            definition = "דֶּרֶךְ לְהוֹצִיא אֶת הָאָדָם מִמַּצָּב קָשֶׁה אוֹ לַעֲנוֹת עַל מַה שֶׁחָסֵר לוֹ.",
            definitionNative = "Способ вытащить человека из трудной ситуации или дать ему то, чего не хватало.",
            example = "הִצַּעְנוּ פִּתְרוֹן פָּשׁוּט שֶׁחוֹסֵךְ לַלָּקוֹחַ שָׁלוֹשׁ הַקְלָדוֹת בָּטוֹפֶס.",
            exampleNative = "Мы предложили простой פִּתְרוֹן — экономит клиенту три ввода в форме.",
         fillInBlankExclusions = listOf(177716L, 177717L, 177718L, 177719L)),

        // ── pm_basic_goals (5) — куда движемся ──
        WordEntity(
            id = 177721, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_goals", transliteration = "matara",
            original = "מַטָּרָה", translation = "цель",
            definition = "מָקוֹם רָחוֹק שֶׁאֵלָיו רוֹצִים לְהַגִּיעַ בַּסּוֹף — בָּעֲבוֹדָה אוֹ בַּחַיִּים.",
            definitionNative = "Дальнее место, куда хотят прийти в итоге — на работе или в жизни.",
            example = "מַטָּרָה שֶׁל הָרֹבַע הִיא מִילְיוֹן מִשְׁתַּמְּשִׁים פְּעִילִים בַּחֹדֶשׁ.",
            exampleNative = "מַטָּרָה на квартал — миллион активных пользователей в месяц.",
         fillInBlankExclusions = listOf(177722L, 177723L, 177724L, 177725L)),
        WordEntity(
            id = 177722, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_goals", transliteration = "mesima",
            original = "מְשִׂימָה", translation = "задача",
            definition = "פְּעֻלָּה אַחַת שֶׁצָּרִיךְ לִגְמֹר עַד תַּאֲרִיךְ מְסֻיָּם — חֵלֶק מִתָּכְנִית גְּדוֹלָה יוֹתֵר.",
            definitionNative = "Одно действие, что нужно довести до конца к определённой дате — часть большего плана.",
            example = "כָּל מְשִׂימָה בַּסְּפְּרִינְט מְקַבֶּלֶת בַּעַל אַחְרָיוּת בָּהִיר וְזְמַן צָפוּי.",
            exampleNative = "Каждый מְשִׂימָה в спринте получает чёткого ответственного и ожидаемое время.",
         fillInBlankExclusions = listOf(177721L, 177723L, 177724L, 177725L)),
        WordEntity(
            id = 177723, setId = 1777, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "pm_basic_goals", transliteration = "tokhnit",
            original = "תָּכְנִית", translation = "план",
            definition = "רְשִׁימָה מְסֻדֶּרֶת שֶׁל צְעָדִים שֶׁעוֹשִׂים אֶחָד אַחֲרֵי הַשֵּׁנִי כְּדֵי לְהַגִּיעַ לַמַּטָּרָה.",
            definitionNative = "Упорядоченный список шагов — их делают один за другим, чтобы прийти к цели.",
            example = "הַתָּכְנִית לָרֹבַע הַבָּא כְּלָלָה שְׁלוֹשָׁה פִיצְ׳רִים גְּדוֹלִים וְעֶשֶׂר תִּקּוּנִים.",
            exampleNative = "Наша תָּכְנִית на следующий квартал включает три большие фичи и десяток правок.",
         fillInBlankExclusions = listOf(177721L, 177722L, 177724L, 177725L)),
        WordEntity(
            id = 177724, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_goals", transliteration = "dedlain",
            original = "דֶּדְלַיין", translation = "дедлайн",
            definition = "תַּאֲרִיךְ אַחֲרוֹן שֶׁעַד אֵלָיו חַיָּבִים לִגְמֹר מַשֶּׁהוּ — אַחֲרֵי זֶה כְּבָר מְאֻחָר.",
            definitionNative = "Последняя дата, к которой обязаны закончить — после неё уже поздно.",
            example = "הַדֶּדְלַיין שֶׁל הָרִילִיס נִדְחָה בְּשָׁבוּעַ בִּגְלַל אִינְטֶגְרַצְיָה עִם בַּנְק.",
            exampleNative = "דֶּדְלַיין релиза сдвинули на неделю из-за интеграции с банком.",
         fillInBlankExclusions = listOf(177721L, 177722L, 177723L, 177725L)),
        WordEntity(
            id = 177725, setId = 1777, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_basic_goals", transliteration = "hatslakha",
            original = "הַצְלָחָה", translation = "успех",
            definition = "תּוֹצָאָה טוֹבָה שֶׁבָּהּ הַמַּטָּרָה שֶׁתַּכְנַנּוּ הָגִיעָה לְמָקוֹם בָּהִיר וְנִמְדָּד.",
            definitionNative = "Хороший результат — когда задуманная цель пришла к ясному и измеримому исходу.",
            example = "הַהַצְלָחָה שֶׁל הַהַשְׁקָה הָפְתִּיעָה אֲפִילוּ אֶת הַמַּשְׁקִיעִים הַוָּתִיקִים.",
            exampleNative = "הַצְלָחָה запуска удивила даже опытных инвесторов.",
         fillInBlankExclusions = listOf(177721L, 177722L, 177723L, 177724L)),
    )
}
