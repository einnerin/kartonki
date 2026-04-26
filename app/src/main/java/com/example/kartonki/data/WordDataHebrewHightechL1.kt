package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Хайтек" (вход в индустрию, базовая лексика).
 *
 * Set 1745: «Хайтек» — основы (L1, COMMON+UNCOMMON):
 *           роли, продукты, инструменты, офисное пространство, базовые действия.
 *
 * Тема ориентирована на русскоязычных репатриантов в Израиле, которые впервые
 * попадают в израильский хайтек: первая работа, первый офис, первый митинг.
 * Лексика — реальная смесь иврита и английских заимствований, как и говорят
 * в коридорах и слаках израильских компаний (אַפְּלִיקַצְיָה, סַיְט, פִיצְ׳ר,
 * בָּאג, מִיטִינְג, רִילִיס) — НЕ ивритизированные кальки.
 *
 * Кросс-тематические пересечения с темами «Программист» (1349-1353),
 * «Технологии» (1001, 1248-1249), «Собеседования» (1750-1751) допустимы
 * по правилу: дубли `original` между РАЗНЫМИ темами разрешены. Здесь — широкий
 * обзорный взгляд на индустрию, в «Программист» — узкий профильный.
 *
 * Распределение редкостей:
 *   Set 1745: 13 COMMON + 12 UNCOMMON.
 *
 * SemanticGroups (5 × 5):
 *   hightech_intro          — кто работает в хайтеке: программист, разработчик,
 *                             QA, продуктовый менеджер, дизайнер
 *   hightech_products       — что они делают: платформа, приложение, сайт,
 *                             фича, баг
 *   hightech_tools          — рабочие инструменты: компьютер, ноутбук, монитор,
 *                             клавиатура, мышь
 *   hightech_workplace      — место работы: офис, опен-спейс, переговорка,
 *                             мини-кухня, парковка
 *   hightech_basic_actions  — базовые действия и события: писать код,
 *                             отлаживать, релиз, митинг, имейл
 *
 * Word IDs: setId × 100 + position (174501..174525).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewHightechL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1745, languagePair = "he-ru", orderIndex = 1745,
            name = "Хайтек",
            description = "Вход в индустрию: базовая лексика для нового хайтекиста",
            topic = "Хайтек", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1745 — Хайтек: основы (L1, COMMON+UNCOMMON, A1-A2)
        // 5 групп × 5 слов: intro, products, tools, workplace, basic_actions
        // ══════════════════════════════════════════════════════════════════════

        // ── hightech_intro (5) — роли в хайтеке ──
        WordEntity(
            id = 174501, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_intro", transliteration = "metakhnet",
            original = "מְתַכְנֵת", translation = "программист",
            definition = "אָדָם שֶׁכּוֹתֵב הוֹרָאוֹת לְמַחְשֵׁב בְּשָׂפָה מְיֻחֶדֶת.",
            definitionNative = "Человек, который пишет инструкции для компьютера на специальном языке.",
            example = "כָּל מְתַכְנֵת בְּחֶבְרָה שֶׁלָּנוּ עוֹבֵד בִּשְׁתֵּי שָׂפוֹת.",
            exampleNative = "Каждый מְתַכְנֵת в нашей фирме работает на двух языках.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174502, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_intro", transliteration = "mefateakh",
            original = "מְפַתֵּחַ", translation = "разработчик",
            definition = "עוֹבֵד שֶׁבּוֹנֶה מוּצָרִים דִּיגִיטָלִיִּים מֵהַתְחָלָה עַד הַסּוֹף.",
            definitionNative = "Сотрудник, который строит цифровые продукты от начала до конца.",
            example = "מְפַתֵּחַ צָעִיר הִצְטָרֵף לַצֶּוֶות שֶׁלִּי בְּחֹדֶשׁ שֶׁעָבַר.",
            exampleNative = "Молодой מְפַתֵּחַ присоединился к моей команде в прошлом месяце.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174503, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_intro", transliteration = "kyu ei",
            original = "קְיוּ אֵיי", translation = "QA-инженер (тестировщик)",
            definition = "מִי שֶׁמְּחַפֵּשׂ בְּעָיוֹת בַּמּוּצָר לִפְנֵי שֶׁהוּא מַגִּיעַ לַלָּקוֹחַ.",
            definitionNative = "Тот, кто ищет проблемы в продукте до того, как он попадёт к клиенту.",
            example = "קְיוּ אֵיי מָצָא חָמֵשׁ בְּעָיוֹת בַּגִּרְסָה הָאַחֲרוֹנָה.",
            exampleNative = "קְיוּ אֵיי нашёл пять проблем в последней версии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174504, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_intro", transliteration = "menahel mutsar",
            original = "מְנַהֵל מוּצָר", translation = "продуктовый менеджер",
            definition = "אַחְרַאי עַל הַחֲזוֹן שֶׁל הַמּוּצָר וְעַל מָה נִבְנֶה קֹדֶם.",
            definitionNative = "Отвечает за видение продукта и за то, что строится в первую очередь.",
            example = "מְנַהֵל מוּצָר הִצִּיג רוֹאוּדְמַפ לַחֲצִי שָׁנָה הַבָּא.",
            exampleNative = "מְנַהֵל מוּצָר показал роадмап на следующие полгода.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174505, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_intro", transliteration = "me'atsev",
            original = "מְעַצֵּב", translation = "дизайнер",
            definition = "אִישׁ שֶׁמְּתַכְנֵן אֵיךְ הַמָּסָךְ נִרְאֶה וְאֵיךְ נוֹחַ לְהִשְׁתַּמֵּשׁ בּוֹ.",
            definitionNative = "Человек, который придумывает, как выглядит экран и удобно ли им пользоваться.",
            example = "הַמְּעַצֵּב שֶׁלָּנוּ מַחְלִיף צֶבַע שֶׁל כַּפְתּוֹר חָשׁוּב.",
            exampleNative = "Наш מְעַצֵּב меняет цвет важной кнопки.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_products (5) — продукт и его части ──
        WordEntity(
            id = 174506, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_products", transliteration = "platforma",
            original = "פְּלַטְפוֹרְמָה", translation = "платформа",
            definition = "מַעֲרֶכֶת גְּדוֹלָה שֶׁעָלֶיהָ רָצִים שֵׁרוּתִים אוֹ אַפְּלִיקַצְיוֹת רַבִּים.",
            definitionNative = "Большая система, на которой работают много сервисов или приложений.",
            example = "כָּל הַחֶבְרָה הַחֲדָשָׁה רָצָה עַל פְּלַטְפוֹרְמָה אַחַת בָּעָנָן.",
            exampleNative = "Вся новая компания работает на одной פְּלַטְפוֹרְמָה в облаке.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174507, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_products", transliteration = "aplikatsya",
            original = "אַפְּלִיקַצְיָה", translation = "приложение",
            definition = "תּוֹכְנָה קְטַנָּה לַטֶּלֶפוֹן שֶׁעוֹשָׂה דָּבָר אֶחָד טוֹב — מַפָּה, מוּזִיקָה אוֹ הוֹדָעוֹת.",
            definitionNative = "Маленькая программа в телефоне для одного дела — карты, музыка или сообщения.",
            example = "הוֹרַדְתִּי אַפְּלִיקַצְיָה חֲדָשָׁה לְמַעֲקַב אַחֲרֵי הוֹצָאוֹת.",
            exampleNative = "Я скачал новое אַפְּלִיקַצְיָה для отслеживания расходов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174508, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_products", transliteration = "sait",
            original = "סַיְט", translation = "сайт",
            definition = "דַּף בָּרֶשֶׁת עִם כְּתֹבֶת קְבוּעָה שֶׁפּוֹתְחִים בַּדַּפְדְּפָן.",
            definitionNative = "Страница в сети с постоянным адресом — её открывают в браузере.",
            example = "הַסַּיְט שֶׁל הַחֶבְרָה לֹא נִטְעַן הַבֹּקֶר בִּגְלַל תַּקָּלָה.",
            exampleNative = "Корпоративный סַיְט не загружался с утра из-за сбоя.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174509, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_products", transliteration = "ficher",
            original = "פִיצְ׳ר", translation = "фича",
            definition = "יְכֹלֶת חֲדָשָׁה בַּמּוּצָר שֶׁמּוֹסִיפִים כְּדֵי שֶׁמִּשְׁתַּמְּשִׁים יִרְצוּ אוֹתוֹ יוֹתֵר.",
            definitionNative = "Новая возможность в продукте — её добавляют, чтобы юзеры хотели его сильнее.",
            example = "הַפִיצְ׳ר הֶחָדָשׁ קָפַץ לַחָבְרֵי הַצֶּוֶות בַּהַתְחָלָה.",
            exampleNative = "Свежий פִיצְ׳ר сначала достался членам команды.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174510, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_products", transliteration = "bag",
            original = "בָּאג", translation = "баг",
            definition = "שְׁגִיאָה בַּמּוּצָר שֶׁגּוֹרֶמֶת לוֹ לְהִתְנַהֵג לֹא כְּמוֹ שֶׁצָּפוּי.",
            definitionNative = "Поломка в продукте — он ведёт себя не так, как ожидается.",
            example = "פָּתַחְתִּי כַּרְטִיס עַל בָּאג שֶׁמַּפִּיל אֶת הַטֹּפֶס.",
            exampleNative = "Я завёл тикет на בָּאג, из-за которого падает форма.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_tools (5) — рабочие инструменты ──
        WordEntity(
            id = 174511, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_tools", transliteration = "makhshev",
            original = "מַחְשֵׁב", translation = "компьютер",
            definition = "מְכוֹנָה חַשְׁמַלִּית שֶׁמְּעַבֶּדֶת מֵידָע וּמַרִיצָה תּוֹכְנוֹת.",
            definitionNative = "Электрическая машина, что обрабатывает данные и запускает программы.",
            example = "הַמַּחְשֵׁב בָּעֲבוֹדָה מַתְחִיל לְהִיוֹת אִטִּי בַּצָּהֳרַיִם.",
            exampleNative = "Рабочий מַחְשֵׁב начинает тормозить ближе к обеду.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174512, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_tools", transliteration = "laptop",
            original = "לַפְטוֹפּ", translation = "ноутбук",
            definition = "מַחְשֵׁב נַיָּד עִם סוֹלְלָה שֶׁאֶפְשָׁר לָקַחַת לִישִׁיבָה אוֹ לַבַּיִת.",
            definitionNative = "Переносной компьютер с батареей — берут на встречу или домой.",
            example = "לָקַחְתִּי לַפְטוֹפּ לַמִּסְפָּרָה כְּדֵי לַעֲנוֹת לַמַּנְהֵל.",
            exampleNative = "Я взял לַפְטוֹפּ в парикмахерскую, чтобы ответить руководителю.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174513, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_tools", transliteration = "masakh",
            original = "מָסָךְ", translation = "монитор",
            definition = "לוּחַ זְכוּכִית גָּדוֹל שֶׁמַּרְאֶה אֶת הַתְּמוּנָה מֵהַמַּחְשֵׁב.",
            definitionNative = "Большая стеклянная панель, что показывает картинку с компьютера.",
            example = "חִבַּרְתִּי מָסָךְ נוֹסָף כְּדֵי לִרְאוֹת שְׁנֵי קְבָצִים בְּיַחַד.",
            exampleNative = "Я подключил второй מָסָךְ, чтобы видеть два файла рядом.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174514, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_tools", transliteration = "makledet",
            original = "מַקְלֶדֶת", translation = "клавиатура",
            definition = "לוּחַ עִם כַּפְתּוֹרֵי אוֹתִיּוֹת וּמִסְפָּרִים לִכְתִיבָה לְתוֹךְ הַמַּחְשֵׁב.",
            definitionNative = "Доска с кнопками букв и цифр — нужна, чтобы печатать в компьютер.",
            example = "שָׁפַכְתִּי קָפֶה עַל הַמַּקְלֶדֶת הַחֲדָשָׁה בְּטָעוּת.",
            exampleNative = "Я случайно пролил кофе на новую מַקְלֶדֶת.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174515, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_tools", transliteration = "akhbar",
            original = "עַכְבָּר", translation = "мышь (компьютерная)",
            definition = "מַכְשִׁיר קָטָן בַּיָּד שֶׁמַּזִיז אֶת הַסַּמָּן עַל הַמָּסָךְ.",
            definitionNative = "Маленькая штука в руке — двигает курсор по экрану.",
            example = "הַסּוֹלְלָה שֶׁל הָעַכְבָּר הָאַלְחוּטִי נִגְמְרָה לִי שׁוּב.",
            exampleNative = "Батарейка беспроводного עַכְבָּר у меня снова села.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_workplace (5) — место работы ──
        WordEntity(
            id = 174516, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_workplace", transliteration = "misrad",
            original = "מִשְׂרָד", translation = "офис",
            definition = "בִּנְיָן אוֹ קוֹמָה שֶׁבָּהּ הָעוֹבְדִים מַגִּיעִים לַעֲבוֹד יַחַד בַּיּוֹם.",
            definitionNative = "Здание или этаж, куда сотрудники приходят работать вместе днём.",
            example = "הַמִּשְׂרָד שֶׁלָּנוּ נִמְצָא בַּקּוֹמָה הַשְּׁמִינִית בְּהֶרְצְלִיָּה.",
            exampleNative = "Наш מִשְׂרָד находится на восьмом этаже в Герцлии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174517, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_workplace", transliteration = "open speis",
            original = "אוֹפֶּן סְפֵייס", translation = "опен-спейс",
            definition = "חֶדֶר אֶחָד גָּדוֹל בְּלִי קִירוֹת בֵּין שֻׁלְחָנוֹת שֶׁל עוֹבְדִים שׁוֹנִים.",
            definitionNative = "Один большой зал без стен между столами разных сотрудников.",
            example = "בָּאוֹפֶּן סְפֵייס שֶׁלָּנוּ קָשֶׁה לְהִתְרַכֵּז בְּלִי אֹזְנִיּוֹת.",
            exampleNative = "В нашем אוֹפֶּן סְפֵייס сложно сосредоточиться без наушников.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174518, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_workplace", transliteration = "khadar yeshivot",
            original = "חֲדַר יְשִׁיבוֹת", translation = "переговорка",
            definition = "חֶדֶר סָגוּר עִם שֻׁלְחָן וּמָסָךְ לְשִׂיחוֹת חֲשׁוּבוֹת בְּלִי רַעַשׁ מִבַּחוּץ.",
            definitionNative = "Закрытый кабинет со столом и экраном — для важных бесед без шума снаружи.",
            example = "הִזְמַנְתִּי חֲדַר יְשִׁיבוֹת לְשִׂיחָה עִם הַלָּקוֹחַ בָּאַרְבַּע.",
            exampleNative = "Я забронировал חֲדַר יְשִׁיבוֹת для разговора с клиентом в четыре.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174519, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_workplace", transliteration = "mitbakhon",
            original = "מִטְבָּחוֹן", translation = "мини-кухня",
            definition = "פִּינָה קְטַנָּה בָּעֲבוֹדָה עִם מְכוֹנַת קָפֶה וְחֲטִיפִים בְּחִנָּם.",
            definitionNative = "Уголок на работе с кофемашиной и снеками — берут бесплатно.",
            example = "כָּל בֹּקֶר אֲנִי פּוֹגֵשׁ אֶת הַצֶּוֶות בַּמִּטְבָּחוֹן.",
            exampleNative = "Каждое утро я встречаюсь с командой в מִטְבָּחוֹן.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174520, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_workplace", transliteration = "khanaya",
            original = "חֲנָיָה", translation = "парковка",
            definition = "מָקוֹם תַּחַת הַבִּנְיָן שֶׁבּוֹ הָעוֹבְדִים מַשְׁאִירִים אֶת הָרֶכֶב.",
            definitionNative = "Место под зданием, где сотрудники оставляют машину.",
            example = "הַחֲנָיָה בַּחֶבְרָה הָיְתָה מְלֵאָה כְּבָר בְּשֶׁבַע וָחֵצִי.",
            exampleNative = "חֲנָיָה в фирме была забита уже к половине восьмого.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_basic_actions (5) — базовые действия и события ──
        WordEntity(
            id = 174521, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "hightech_basic_actions", transliteration = "likhtov kod",
            original = "לִכְתֹּב קוֹד", translation = "писать код",
            definition = "לְהַקְלִיד הוֹרָאוֹת בְּשָׂפָה מְיֻחֶדֶת כְּדֵי שֶׁהַמַּחְשֵׁב יַעֲשֶׂה מַשֶּׁהוּ.",
            definitionNative = "Набирать инструкции на специальном языке — чтобы машина что-то сделала.",
            example = "אֲנִי אוֹהֵב לִכְתֹּב קוֹד עִם מוּזִיקָה בָּאֹזְנִיּוֹת בַּלַּיְלָה.",
            exampleNative = "Я люблю לִכְתֹּב קוֹד под музыку в наушниках по ночам.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174522, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "hightech_basic_actions", transliteration = "levadek",
            original = "לְבַדֵּק", translation = "отлаживать (дебажить)",
            definition = "לְחַפֵּשׂ אֶת מָקוֹר הַשְּׁגִיאָה בַּקּוֹד וּלְתַקֵּן אוֹתָהּ.",
            definitionNative = "Искать источник ошибки в коде и исправлять её.",
            example = "יָשַׁבְתִּי לְבַדֵּק אֶת הַשֵּׁרוּת עַד שָׁלוֹשׁ בַּלַּיְלָה.",
            exampleNative = "Я сидел לְבַדֵּק сервис до трёх ночи.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174523, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_basic_actions", transliteration = "rilis",
            original = "רִילִיס", translation = "релиз",
            definition = "רֶגַע שֶׁבּוֹ גִּרְסָה חֲדָשָׁה שֶׁל הַמּוּצָר יוֹצֵאת לַמִּשְׁתַּמְּשִׁים בַּחוּץ.",
            definitionNative = "Момент, когда новая версия продукта выходит к юзерам наружу.",
            example = "הָרִילִיס נִדְחָה בְּשָׁבוּעַ בִּגְלַל בְּעָיוֹת בַּשֵּׁרוּת.",
            exampleNative = "רִילִיס сдвинули на неделю из-за проблем в сервисе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174524, setId = 1745, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_basic_actions", transliteration = "miting",
            original = "מִיטִינְג", translation = "митинг (созвон)",
            definition = "שִׂיחָה מְתֻכְנֶנֶת שֶׁל כַּמָּה אֲנָשִׁים בַּזּוּם אוֹ בַּחֶדֶר.",
            definitionNative = "Запланированный разговор нескольких людей в Зуме или в кабинете.",
            example = "יֵשׁ לִי מִיטִינְג עִם הַמְּעַצֵּב בְּעֶשֶׂר וָרֶבַע.",
            exampleNative = "У меня מִיטִינְג с дизайнером в десять пятнадцать.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174525, setId = 1745, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "hightech_basic_actions", transliteration = "imeil",
            original = "אִימֵייל", translation = "имейл",
            definition = "הוֹדָעַת טֶקְסְט שֶׁעוֹבֶרֶת בָּרֶשֶׁת מִכְּתֹבֶת אַחַת לִשְׁנִיָּה.",
            definitionNative = "Текстовое сообщение по сети — с одного адреса на другой.",
            example = "שָׁלַחְתִּי אִימֵייל לַמַּנְהֵל עִם סִכּוּם הַשָּׁבוּעַ.",
            exampleNative = "Я отправил אִימֵייל руководителю с итогами недели.",
            isFillInBlankSafe = false,
        ),
    )
}
