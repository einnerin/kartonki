package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Городская жизнь и услуги", level 1 (A1-A2).
 * Один сет × 25 слов. setId = 1837.
 *
 *  - 18 COMMON + 7 UNCOMMON (2 смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      urban_l1_services  — банк, почта, мэрия, аптека, супермаркет (5)
 *      urban_l1_postbank  — банкомат, касса, посылка, марка, часы приёма (5)
 *      urban_l1_navigate  — адрес, карта, направление, угол, вход (5)
 *      urban_l1_actions   — спрашивать, покупать, платить, переходить,
 *                           стоять в очереди (5)
 *      urban_l1_admin     — справка, бланк, подпись, очередь, секретарь (5)
 *  - Базовая повседневная лексика про городские услуги, почтово-банковские
 *    операции, навигацию и мини-бюрократию. Никудим везде (стандарт he-ru).
 *  - Несколько фундаментальных оригиналов (בַּנְק, דֹּאַר, עִירִיָּה,
 *    סוּפֶּרְמַרְקֶט, כְּתֹבֶת, מַפָּה, לִקְנוֹת, לְשַׁלֵּם, לִשְׁאֹל, תּוֹר,
 *    חֲתִימָה, טֹפֶס, תְּעוּדָה, מַזְכִּירָה, חֲבִילָה) пересекаются с set
 *    1009 «Город», set 1705 «Город L1», set 1807 «Бюрократия и документы»,
 *    set 1703 «Право», set 1200 «Алия» и др. — формально это другие темы,
 *    дубли в разных темах допустимы по политике
 *    (`docs/claude/feedback_duplicate_words_policy.md`). Без них L1 «Городская
 *    жизнь и услуги» неполноценен — это самые базовые A1-A2 слова, без которых
 *    тема пустая.
 */
object WordDataHebrewUrbanLifeL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1837, languagePair = "he-ru", orderIndex = 1837,
            name = "Городская жизнь и услуги",
            description = "Банк, почта, транспорт, очереди и базовые услуги",
            topic = "Городская жизнь и услуги", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── urban_l1_services (5) ───────────────────────────────────────
        WordEntity(
            id = 183701, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_services",
            original = "בַּנְק", translation = "банк",
            transliteration = "банк",
            definition = "מוֹסָד שֶׁבּוֹ שׁוֹמְרִים כֶּסֶף וּמְקַבְּלִים הַלְוָאוֹת לַקְּנִיּוֹת.",
            definitionNative = "Учреждение, где хранят деньги и получают кредиты на покупки.",
            example = "אֲנִי הוֹלֵךְ לַבַּנְק לְהַפְקִיד אֶת הַמַּשְׂכֹּרֶת הַחֹדֶשׁ.",
            exampleNative = "Я иду в בַּנְק положить зарплату на счёт в этом месяце.",
         fillInBlankExclusions = listOf(183702L, 183703L, 183704L, 183705L)),
        WordEntity(
            id = 183702, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_services",
            original = "דֹּאַר", translation = "почта",
            transliteration = "доар",
            definition = "מָקוֹם שֶׁבּוֹ שׁוֹלְחִים מִכְתָּבִים וַחֲבִילוֹת לְעָרִים אֲחֵרוֹת.",
            definitionNative = "Заведение, откуда отправляют письма и посылки в другие города.",
            example = "הַדֹּאַר נִמְצָא לְיַד הָעִירִיָּה בְּמֶרְכַּז הָעִיר.",
            exampleNative = "דֹּאַר находится рядом с мэрией в самом центре города.",
         fillInBlankExclusions = listOf(183701L, 183704L, 183705L)),
        WordEntity(
            id = 183703, setId = 1837, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "urban_l1_services",
            original = "עִירִיָּה", translation = "мэрия",
            transliteration = "ирия",
            definition = "מוֹסָד עִירוֹנִי שֶׁמְּנַהֵל אֶת חַיֵּי הַתּוֹשָׁבִים בְּגֶבֶל הָעִיר.",
            definitionNative = "Городское учреждение, что ведает жизнью жителей в пределах города.",
            example = "הָעִירִיָּה הוֹדִיעָה עַל סְגִירַת רְחוֹב לְשִׁפּוּצִים.",
            exampleNative = "עִירִיָּה объявила о закрытии улицы на ремонтные работы.",
         fillInBlankExclusions = listOf(183701L, 183702L, 183704L, 183705L)),
        WordEntity(
            id = 183704, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_services",
            original = "בֵּית מִרְקַחַת", translation = "аптека",
            transliteration = "бейт миркахат",
            definition = "חֲנוּת רִשְׁמִית שֶׁבָּהּ מוֹכְרִים תְּרוּפוֹת לְפִי מִרְשַׁם רוֹפֵא.",
            definitionNative = "Официальный магазин, где продают лекарства по рецепту врача.",
            example = "קָנִיתִי בְּבֵית מִרְקַחַת תְּרוּפָה לְכַאֵב גָּרוֹן.",
            exampleNative = "Я купил в בֵּית מִרְקַחַת лекарство от боли в горле.",
        ),
        WordEntity(
            id = 183705, setId = 1837, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "urban_l1_services",
            original = "סוּפֶּרְמַרְקֶט", translation = "супермаркет",
            transliteration = "супермаркет",
            definition = "חֲנוּת גְּדוֹלָה שֶׁבָּהּ קוֹנִים אֹכֶל וּמוּצָרִים לַבַּיִת.",
            definitionNative = "Большой магазин, где покупают еду и товары для дома сразу.",
            example = "כָּל יוֹם שִׁשִּׁי אֲנַחְנוּ קוֹנִים בַּסּוּפֶּרְמַרְקֶט לְשַׁבָּת.",
            exampleNative = "Каждую пятницу мы закупаемся в סוּפֶּרְמַרְקֶט на субботу заранее.",
        ),

        // ─── urban_l1_postbank (5) ───────────────────────────────────────
        WordEntity(
            id = 183706, setId = 1837, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "urban_l1_postbank",
            original = "כַּסְפּוֹמָט", translation = "банкомат",
            transliteration = "каспомат",
            definition = "מַכְשִׁיר אוֹטוֹמָטִי שֶׁמּוֹצִיא כֶּסֶף מֵחֶשְׁבּוֹן הַבַּנְק לְפִי כַּרְטִיס.",
            definitionNative = "Автоматический аппарат, что выдаёт деньги со счёта по карте.",
            example = "הוֹצֵאתִי מָאתַיִם שֶׁקֶל מֵהַכַּסְפּוֹמָט עַל יַד הַסּוּפֶּר.",
            exampleNative = "Я снял двести шекелей в כַּסְפּוֹמָט рядом с супермаркетом.",
         fillInBlankExclusions = listOf(183707L, 183708L, 183709L, 183710L)),
        WordEntity(
            id = 183707, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_postbank",
            original = "קֻפָּה", translation = "касса",
            transliteration = "купа",
            definition = "מָקוֹם בַּחֲנוּת שֶׁבּוֹ מְשַׁלְּמִים עַל הַמּוּצָרִים בְּמַזּוּמָן אוֹ בְּכַרְטִיס.",
            definitionNative = "Место в магазине, где платят за товары наличными или картой.",
            example = "הָיָה תּוֹר אָרֹךְ בַּקֻּפָּה לְיַד הַיְּצִיאָה.",
            exampleNative = "Была длинная очередь у קֻפָּה рядом с выходом из магазина.",
        ),
        WordEntity(
            id = 183708, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_postbank",
            original = "חֲבִילָה", translation = "посылка",
            transliteration = "хавила",
            definition = "קֻפְסָה אוֹ חֲפָצִים אֲרוּזִים שֶׁשּׁוֹלְחִים דֶּרֶךְ הַדֹּאַר לְכָתֹבֶת אַחֶרֶת.",
            definitionNative = "Коробка с упакованными вещами, что пересылают почтой на другой адрес.",
            example = "הִגִּיעָה לִי חֲבִילָה גְּדוֹלָה מֵהוֹרָי בָּרוּסְיָה.",
            exampleNative = "Мне пришла большая חֲבִילָה от родителей из России.",
         fillInBlankExclusions = listOf(183706L, 183707L, 183709L, 183710L, 183712L)),
        WordEntity(
            id = 183709, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_postbank",
            original = "בּוּל", translation = "почтовая марка",
            transliteration = "буль",
            definition = "פֶּתֶק קָטָן שֶׁמַּדְבִּיקִים עַל מַעֲטָפָה כְּדֵי לְשַׁלֵּם עַל מִשְׁלוֹחַ.",
            definitionNative = "Маленькая бумажка, что наклеивают на конверт как оплату пересылки.",
            example = "הִדְבַּקְתִּי בּוּל יָקָר עַל הַמַּעֲטָפָה לְחוּץ לָאָרֶץ.",
            exampleNative = "Я наклеил дорогой בּוּל на конверт за границу.",
         fillInBlankExclusions = listOf(183706L, 183707L, 183708L, 183710L)),
        WordEntity(
            id = 183710, setId = 1837, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "urban_l1_postbank",
            original = "שְׁעוֹת קַבָּלָה", translation = "часы приёма",
            transliteration = "шеот кабала",
            definition = "הַזְּמַן בַּיּוֹם שֶׁבּוֹ הַמּוֹסָד פָּתוּחַ וּמְקַבֵּל אֶת הַתּוֹשָׁבִים.",
            definitionNative = "Время дня, когда учреждение открыто и принимает посетителей.",
            example = "שְׁעוֹת הַקַּבָּלָה שֶׁל הַבַּנְק הֵן רַק בַּבֹּקֶר.",
            exampleNative = "שְׁעוֹת קַבָּלָה банка — только утром, после обеда уже закрыто.",
        ),

        // ─── urban_l1_navigate (5) ───────────────────────────────────────
        WordEntity(
            id = 183711, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_navigate",
            original = "כְּתֹבֶת", translation = "адрес",
            transliteration = "ктовэт",
            definition = "שֵׁם הָרְחוֹב וּמִסְפַּר הַבַּיִת שֶׁמַּרְאִים אֵיפֹה גָּר אָדָם.",
            definitionNative = "Название улицы и номер дома, что показывают, где живёт человек.",
            example = "תֵּן לִי אֶת הַכְּתֹבֶת הַמְּדֻיֶּקֶת שֶׁל הַמִּשְׂרָד.",
            exampleNative = "Дай мне точный כְּתֹבֶת офиса, чтобы я не заблудился по дороге.",
         fillInBlankExclusions = listOf(183712L, 183713L, 183714L, 183715L)),
        WordEntity(
            id = 183712, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_navigate",
            original = "מַפָּה", translation = "карта",
            transliteration = "мапа",
            definition = "צִיּוּר שֶׁל הָעִיר עִם רְחוֹבוֹת וּמְקוֹמוֹת חֲשׁוּבִים לִמְצֹא דֶּרֶךְ.",
            definitionNative = "Рисунок города с улицами и важными местами, чтобы найти дорогу.",
            example = "פָּתַחְתִּי אֶת הַמַּפָּה בַּטֶּלֶפוֹן לִרְאוֹת לְאָן לִפְנוֹת.",
            exampleNative = "Я открыл מַפָּה в телефоне, чтобы понять, куда поворачивать дальше.",
        ),
        WordEntity(
            id = 183713, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_navigate",
            original = "כִּוּוּן", translation = "направление",
            transliteration = "кивун",
            definition = "הַצַּד שֶׁאֵלָיו הוֹלְכִים אוֹ נוֹסְעִים — צָפוֹן, דָּרוֹם, יָמִינָה אוֹ שְׂמֹאלָה.",
            definitionNative = "Сторона, в которую идут или едут — север, юг, направо или налево.",
            example = "אֲנִי הוֹלֵךְ בַּכִּוּוּן הַשְּׁגוּי, צָרִיךְ לַחֲזֹר אֲחוֹרָה.",
            exampleNative = "Я иду в неправильный כִּוּוּן и должен теперь возвращаться назад.",
         fillInBlankExclusions = listOf(183711L, 183712L, 183714L, 183715L)),
        WordEntity(
            id = 183714, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_navigate",
            original = "פִּנָּה", translation = "угол",
            transliteration = "пина",
            definition = "מָקוֹם שֶׁבּוֹ נִפְגָּשִׁים שְׁנֵי קִירוֹת אוֹ שְׁנֵי רְחוֹבוֹת בְּזָוִית.",
            definitionNative = "Место, где встречаются две стены или две улицы под углом.",
            example = "הַחֲנוּת נִמְצֵאת בַּפִּנָּה שֶׁל הָרְחוֹב וְהַשְּׁדֵרָה.",
            exampleNative = "Магазин стоит на פִּנָּה улицы и проспекта, прямо напротив банка.",
         fillInBlankExclusions = listOf(183711L, 183712L, 183713L, 183715L)),
        WordEntity(
            id = 183715, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_navigate",
            original = "כְּנִיסָה", translation = "вход",
            transliteration = "книса",
            definition = "הַמָּקוֹם שֶׁדֶּרֶךְ הוֹלְכִים פְּנִימָה לְבִנְיָן אוֹ לַחֲנוּת.",
            definitionNative = "Место, через которое заходят внутрь здания или магазина.",
            example = "הַכְּנִיסָה לַבַּנְק נִסְגֶּרֶת בִּשָׁלוֹשׁ אַחַר הַצָּהֳרַיִם.",
            exampleNative = "כְּנִיסָה в банк закрывают в три часа дня без исключений.",
         fillInBlankExclusions = listOf(183711L, 183712L, 183713L, 183714L)),

        // ─── urban_l1_actions (5) ────────────────────────────────────────
        WordEntity(
            id = 183716, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "urban_l1_actions",
            original = "לִשְׁאֹל", translation = "спрашивать",
            transliteration = "лишъоль",
            definition = "לִפְנוֹת לְמִישֶׁהוּ בְּשְׁאֵלָה כְּדֵי לְקַבֵּל מֵידָע אוֹ הַסְבָּרָה.",
            definitionNative = "Обратиться к кому-то с вопросом, чтобы получить сведения или объяснение.",
            example = "אֲנִי אוֹהֵב לִשְׁאֹל אֶת הָאֲנָשִׁים בָּרְחוֹב אֵיךְ לְהַגִּיעַ.",
            exampleNative = "Я люблю לִשְׁאֹל прохожих на улице, как добраться до места.",
         fillInBlankExclusions = listOf(183717L, 183718L, 183719L, 183720L)),
        WordEntity(
            id = 183717, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "urban_l1_actions",
            original = "לִקְנוֹת", translation = "покупать",
            transliteration = "ликнот",
            definition = "לָקַחַת מוּצָר תְּמוּרַת תַּשְׁלוּם בְּכֶסֶף בַּחֲנוּת אוֹ בַּשּׁוּק.",
            definitionNative = "Брать товар за оплату деньгами в магазине или на рынке.",
            example = "אֲנִי הוֹלֵךְ לִקְנוֹת לֶחֶם וְחָלָב בַּסּוּפֶּר.",
            exampleNative = "Я иду לִקְנוֹת хлеб и молоко в супермаркете на углу.",
         fillInBlankExclusions = listOf(183716L, 183718L, 183719L, 183720L)),
        WordEntity(
            id = 183718, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "urban_l1_actions",
            original = "לְשַׁלֵּם", translation = "платить",
            transliteration = "лешалем",
            definition = "לָתֵת כֶּסֶף תְּמוּרַת מוּצָר אוֹ שֵׁרוּת שֶׁקִּבַּלְתָּ.",
            definitionNative = "Отдавать деньги за товар или услугу, что ты получил.",
            example = "אֶפְשָׁר לְשַׁלֵּם בִּמְזוּמָן אוֹ בְּכַרְטִיס אַשְׁרַאי.",
            exampleNative = "Можно לְשַׁלֵּם наличными или кредитной картой на ваш выбор.",
         fillInBlankExclusions = listOf(183716L, 183717L, 183719L, 183720L)),
        WordEntity(
            id = 183719, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "urban_l1_actions",
            original = "לַחֲצוֹת", translation = "переходить (улицу)",
            transliteration = "лахацот",
            definition = "לַעֲבֹר מִצַּד אֶחָד שֶׁל הַכְּבִישׁ לַצַּד הַשֵּׁנִי בְּרֶגֶל.",
            definitionNative = "Перейти с одной стороны дороги на другую сторону пешком.",
            example = "צָרִיךְ לַחֲצוֹת אֶת הַכְּבִישׁ רַק בְּאוֹר יָרֹק.",
            exampleNative = "Можно לַחֲצוֹת дорогу только на зелёный сигнал светофора.",
         fillInBlankExclusions = listOf(183716L, 183717L, 183718L, 183720L)),
        WordEntity(
            id = 183720, setId = 1837, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "urban_l1_actions",
            original = "לַעֲמֹד בַּתּוֹר", translation = "стоять в очереди",
            transliteration = "лаамод батор",
            definition = "לְחַכּוֹת בְּשׁוּרָה שֶׁל אֲנָשִׁים אֶחָד אַחֲרֵי הַשֵּׁנִי לְקַבָּלַת שֵׁרוּת.",
            definitionNative = "Ждать в цепочке людей друг за другом для получения услуги.",
            example = "צְרִיכִים לַעֲמֹד בַּתּוֹר חֲצִי שָׁעָה בַּדֹּאַר.",
            exampleNative = "Приходится לַעֲמֹד בַּתּוֹר на почте по полчаса каждое утро.",
         fillInBlankExclusions = listOf(183716L, 183717L, 183718L, 183719L)),

        // ─── urban_l1_admin (5) ──────────────────────────────────────────
        WordEntity(
            id = 183721, setId = 1837, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "urban_l1_admin",
            original = "תְּעוּדָה", translation = "справка",
            transliteration = "теуда",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁמְּאַשֵּׁר עֻבְדָה אוֹ זְכוּת שֶׁל אָדָם.",
            definitionNative = "Официальная бумага, что подтверждает факт или право человека.",
            example = "הֵבֵאתִי תְּעוּדָה מֵהָעֲבוֹדָה לְבַנְק עַל גֹּבַהּ הַמַּשְׂכֹּרֶת.",
            exampleNative = "Я принёс в банк תְּעוּדָה с работы о размере зарплаты.",
         fillInBlankExclusions = listOf(183722L, 183723L, 183724L, 183725L)),
        WordEntity(
            id = 183722, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_admin",
            original = "טֹפֶס", translation = "бланк",
            transliteration = "тофес",
            definition = "דַּף מוּכָן עִם שׁוּרוֹת וּמִשְׁבְּצוֹת שֶׁבָּהֶם כּוֹתְבִים פְּרָטִים.",
            definitionNative = "Готовый лист с строками и графами, в которые вписывают данные.",
            example = "מִלֵּאתִי אֶת הַטֹּפֶס בַּכְּנִיסָה לַמִּשְׂרָד.",
            exampleNative = "Я заполнил טֹפֶס прямо у входа в офис ведомства.",
        ),
        WordEntity(
            id = 183723, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_admin",
            original = "חֲתִימָה", translation = "подпись",
            transliteration = "хатима",
            definition = "כְּתִיבַת הַשֵּׁם שֶׁלָּךְ בִּכְתָב יָד בְּסוֹף הַמִּסְמָךְ לְאִשּׁוּר.",
            definitionNative = "Написание твоего имени от руки в конце документа для утверждения.",
            example = "צָרִיךְ חֲתִימָה שֶׁל שְׁנֵי הַהוֹרִים עַל הַטֹּפֶס.",
            exampleNative = "Нужна חֲתִימָה обоих родителей на бланке для регистрации.",
         fillInBlankExclusions = listOf(183711L, 183721L, 183722L, 183724L, 183725L)),
        WordEntity(
            id = 183724, setId = 1837, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "urban_l1_admin",
            original = "תּוֹר", translation = "очередь",
            transliteration = "тор",
            definition = "שׁוּרָה שֶׁל אֲנָשִׁים שֶׁמְּחַכִּים אֶחָד אַחֲרֵי הַשֵּׁנִי לְקַבָּלַת שֵׁרוּת.",
            definitionNative = "Цепочка людей, что ждут друг за другом получения услуги.",
            example = "הַתּוֹר בַּבַּנְק הָיָה אָרֹךְ מְאוֹד הַבֹּקֶר.",
            exampleNative = "תּוֹר в банке был очень длинным сегодня утром у самого открытия.",
         fillInBlankExclusions = listOf(183721L, 183722L, 183723L, 183725L)),
        WordEntity(
            id = 183725, setId = 1837, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "urban_l1_admin",
            original = "מַזְכִּירָה", translation = "секретарь (женщина)",
            transliteration = "мазкира",
            definition = "אִשָּׁה שֶׁעוֹבֶדֶת בְּמִשְׂרָד וְקוֹבַעַת תּוֹרִים וּפְגִישׁוֹת לַפָּקִידִים.",
            definitionNative = "Женщина, что работает в офисе и записывает посетителей к служащим.",
            example = "הַמַּזְכִּירָה רָשְׁמָה אוֹתִי לַפְּגִישָׁה בְּיוֹם שְׁלִישִׁי.",
            exampleNative = "מַזְכִּירָה записала меня на встречу во вторник к десяти утра.",
        ),
    )
}
