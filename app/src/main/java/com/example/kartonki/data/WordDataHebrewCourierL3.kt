package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Courier, level 3 (1 set, 25 words).
 * Углублённая лексика опытного курьера: маршруты с промежуточными точками,
 * типы доставок, проблемные ситуации, расчёты тарифов и подтверждение получения.
 *
 * Set 1717 (level 3, RARE + EPIC) — заполняет пробел между level 2 (1355, 1561)
 * и level 4 (1356) в теме «Курьер».
 *
 * Не пересекается с уже существующими сетами темы «Курьер»
 * (1354 L1, 1355 L2, 1561 L2, 1356 L4, 1357 L5, 1358 L5).
 *
 * Распределение редкостей: 15 RARE + 10 EPIC (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов каждая:
 *   courier_routes_advanced — маршрут и точки на нём
 *   courier_delivery_types  — режимы и типы доставок
 *   courier_problems        — проблемные ситуации
 *   courier_calculations    — расчёты и тарифы
 *   courier_handoff         — передача и подтверждение получения
 */
object WordDataHebrewCourierL3 {

    val sets = listOf(
        WordSetEntity(
            id = 1717, languagePair = "he-ru", orderIndex = 1717,
            name = "Доставка и работа курьером",
            description = "Маршруты, типы доставок, проблемы, расчёты",
            topic = "Доставка и работа курьером", level = 3,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1717 — Курьер: углублённый (RARE + EPIC, B2–C1)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── courier_routes_advanced (5) — маршрут и точки на нём ──
        WordEntity(
            id = 171701, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_routes_advanced", transliteration = "nekudat isuf",
            original = "נְקוּדַת אִיסּוּף", translation = "точка забора посылки",
            definition = "מָקוֹם שֶׁבּוֹ הַשָּׁלִיחַ אוֹסֵף חֲבִילוֹת מֵהַשּׁוֹלֵחַ לִפְנֵי מַסְלוּל.",
            definitionNative = "Место, откуда курьер забирает товар у отправителя перед рейсом.",
            example = "הִגַּעְנוּ לִנְקוּדַת אִיסּוּף בְּתֵל אָבִיב בַּשָּׁעָה שֶׁבַע.",
            exampleNative = "Мы прибыли в נְקוּדַת אִיסּוּף в Тель-Авиве в семь утра.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171702L, 171703L, 171704L, 171705L)),
        WordEntity(
            id = 171702, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_routes_advanced", transliteration = "ktovet meshana",
            original = "כְּתֹבֶת מְשַׁנָּה", translation = "изменённый адрес доставки",
            definition = "מַעַן חָדָשׁ שֶׁהַלָּקוֹחַ מְבַקֵּשׁ אַחֲרֵי שֶׁהַחֲבִילָה כְּבָר בַּדֶּרֶךְ.",
            definitionNative = "Новый адрес, который заказчик просит уже после выезда курьера.",
            example = "כְּתֹבֶת מְשַׁנָּה הִגִּיעָה אַחֲרֵי שֶׁכְּבָר יָצָאתִי לַסִּבּוּב.",
            exampleNative = "כְּתֹבֶת מְשַׁנָּה пришла, когда я уже вышел в рейс.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171701L, 171703L, 171704L, 171705L, 171712L)),
        WordEntity(
            id = 171703, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_routes_advanced", transliteration = "takhanat beinayim",
            original = "תַּחֲנַת בֵּינַיִם", translation = "промежуточная остановка",
            definition = "עֲצִירָה קְצָרָה לִמְסִירַת חֲבִילָה אַחַת בְּאֶמְצַע מַסְלוּל אָרוֹךְ.",
            definitionNative = "Короткая остановка для одной выдачи на середине длинного рейса.",
            example = "בַּתַּחֲנַת בֵּינַיִם הוֹרַדְתִּי שָׁלוֹשׁ חֲבִילוֹת קְטַנּוֹת.",
            exampleNative = "На תַּחֲנַת בֵּינַיִם я выгрузил три небольшие посылки.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171701L, 171702L, 171704L, 171705L)),
        WordEntity(
            id = 171704, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_routes_advanced", transliteration = "me'akeh hamaslul",
            original = "מְעַקֶּה הַמַּסְלוּל", translation = "объезд по маршруту",
            definition = "סְטִיָּה זְמַנִּית מֵהַדֶּרֶךְ הָרְגִילָה בִּגְלַל סְגִירָה אוֹ עֲבוֹדוֹת.",
            definitionNative = "Временный обход обычной дороги из-за работ или закрытий.",
            example = "מְעַקֶּה הַמַּסְלוּל הוֹסִיף לִי עֶשְׂרִים דַּקּוֹת לַזְּמַן.",
            exampleNative = "מְעַקֶּה הַמַּסְלוּל добавил мне двадцать минут в пути.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171701L, 171702L, 171703L, 171705L, 171708L, 171710L, 171714L, 171724L, 171725L)),
        WordEntity(
            id = 171705, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_routes_advanced", transliteration = "siyur yomi",
            original = "סִיּוּר יוֹמִי", translation = "дневной обход курьера",
            definition = "סֵדֶר הַנְּסִיעוֹת שֶׁהַשָּׁלִיחַ מְבַצֵּעַ מֵהַבֹּקֶר עַד סוֹף הַמִּשְׁמֶרֶת.",
            definitionNative = "Порядок поездок курьера от утра до конца смены.",
            example = "סִיּוּר יוֹמִי כּוֹלֵל הַיּוֹם אַרְבָּעִים נְקוּדּוֹת מְסִירָה.",
            exampleNative = "סִיּוּר יוֹמִי сегодня включает сорок точек выдачи.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171701L, 171702L, 171703L, 171704L)),

        // ── courier_delivery_types (5) — режимы и типы доставок ──
        WordEntity(
            id = 171706, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_delivery_types", transliteration = "mishloakh miyadi",
            original = "מִשְׁלוֹחַ מִיָּדִי", translation = "моментальная доставка",
            definition = "שֵׁרוּת שֶׁבּוֹ הַחֲבִילָה מַגִּיעָה תּוֹךְ שָׁעָה אוֹ פָּחוֹת.",
            definitionNative = "Услуга, при которой посылка приходит в течение часа или быстрее.",
            example = "הִזְמַנְתִּי מִשְׁלוֹחַ מִיָּדִי שֶׁל תְּרוּפוֹת מֵהַבֵּית מֶרְקַחַת.",
            exampleNative = "Я заказал מִשְׁלוֹחַ מִיָּדִי лекарств из аптеки.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171707L, 171708L, 171709L, 171710L)),
        WordEntity(
            id = 171707, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_delivery_types", transliteration = "mishloakh metuzman",
            original = "מִשְׁלוֹחַ מְתֻזְמָן", translation = "доставка в назначенное время",
            definition = "מְסִירָה בְּחַלּוֹן זְמַן צַר שֶׁהַלָּקוֹחַ בָּחַר מֵרֹאשׁ.",
            definitionNative = "Выдача в узком окне времени, заранее выбранном получателем.",
            example = "מִשְׁלוֹחַ מְתֻזְמָן בָּא בְּדִיּוּק בֵּין שָׁלוֹשׁ לְאַרְבַּע.",
            exampleNative = "מִשְׁלוֹחַ מְתֻזְמָן приехал ровно между тремя и четырьмя.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171705L, 171706L, 171708L, 171709L, 171710L, 171724L)),
        WordEntity(
            id = 171708, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_delivery_types", transliteration = "mishloakh komot",
            original = "מִשְׁלוֹחַ קוֹמוֹת", translation = "доставка с подъёмом на этаж",
            definition = "שֵׁרוּת שֶׁבּוֹ הַשָּׁלִיחַ מֵרִים אֶת הַחֲבִילָה עַד דֶּלֶת הַדִּיָּרָה.",
            definitionNative = "Услуга, когда курьер поднимает посылку прямо к двери квартиры.",
            example = "בִּקַּשְׁתִּי מִשְׁלוֹחַ קוֹמוֹת כִּי הַמַּעֲלִית מְקֻלְקֶּלֶת.",
            exampleNative = "Я попросил מִשְׁלוֹחַ קוֹמוֹת, потому что лифт сломан.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171706L, 171707L, 171709L, 171710L, 171722L)),
        WordEntity(
            id = 171709, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_delivery_types", transliteration = "mishloakh shavir",
            original = "מִשְׁלוֹחַ שָׁבִיר", translation = "доставка хрупкого товара",
            definition = "הוֹבָלָה זְהִירָה שֶׁל פְּרִיט שֶׁעָלוּל לְהִשָּׁבֵר מֵרַעַד אוֹ נְפִילָה.",
            definitionNative = "Бережная перевозка предмета, который легко разбить от тряски.",
            example = "מִשְׁלוֹחַ שָׁבִיר עָטוּף תָּמִיד בִּשְׁתֵּי שִׁכְבוֹת קֶצֶף.",
            exampleNative = "מִשְׁלוֹחַ שָׁבִיר всегда упакован в два слоя пены.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171706L, 171707L, 171708L, 171710L)),
        WordEntity(
            id = 171710, setId = 1717, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "courier_delivery_types", transliteration = "mishloakh avor",
            original = "מִשְׁלוֹחַ עֲבוֹר", translation = "доставка через посредника",
            definition = "מְסִירָה דֶּרֶךְ אָדָם שְׁלִישִׁי שֶׁמַּעֲבִיר אֶת הַחֲבִילָה לַמְּקַבֵּל.",
            definitionNative = "Передача через третье лицо, которое доносит товар получателю.",
            example = "מִשְׁלוֹחַ עֲבוֹר נִמְסַר לַשָּׁכֵן מִקּוֹמָה שְׁנִיָּה.",
            exampleNative = "מִשְׁלוֹחַ עֲבוֹר передан соседу со второго этажа.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171706L, 171707L, 171708L, 171709L)),

        // ── courier_problems (5) — проблемные ситуации ──
        WordEntity(
            id = 171711, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_problems", transliteration = "seruv lekabel",
            original = "סֵרוּב לְקַבֵּל", translation = "отказ получателя принять",
            definition = "מַצָּב שֶׁבּוֹ הַלָּקוֹחַ אוֹמֵר שֶׁאֵינוֹ רוֹצֶה אֶת הַפְּרִיט שֶׁהֻזְמַן.",
            definitionNative = "Случай, когда заказчик заявляет, что не хочет заказанный товар.",
            example = "אַחֲרֵי סֵרוּב לְקַבֵּל הֶחֱזַרְתִּי אֶת הַחֲבִילָה לַמַּחְסָן.",
            exampleNative = "После סֵרוּב לְקַבֵּל я отвёз посылку обратно на склад.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171712L, 171713L, 171714L, 171715L)),
        WordEntity(
            id = 171712, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_problems", transliteration = "ktovet shguya",
            original = "כְּתֹבֶת שְׁגוּיָה", translation = "ошибочный адрес",
            definition = "מַעַן לֹא נָכוֹן שֶׁנִּרְשַׁם בְּהַזְמָנָה וְלֹא קַיָּם בַּמְצִיאוּת.",
            definitionNative = "Неправильный адрес, записанный в заказе и не существующий в реальности.",
            example = "כְּתֹבֶת שְׁגוּיָה גָּרְמָה לִי לְבַזְבֵּז חֲצִי שָׁעָה.",
            exampleNative = "כְּתֹבֶת שְׁגוּיָה заставила меня потерять полчаса.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171701L, 171702L, 171703L, 171711L, 171713L, 171714L, 171715L, 171717L, 171721L)),
        WordEntity(
            id = 171713, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_problems", transliteration = "khavila avuda",
            original = "חֲבִילָה אֲבוּדָה", translation = "потерянная посылка",
            definition = "פְּרִיט שֶׁנֶּעֱלַם אֵי שָׁם בֵּין הַמַּחְסָן לַמְּקַבֵּל וְלֹא נִמְצָא.",
            definitionNative = "Товар, исчезнувший где-то между складом и получателем.",
            example = "חֲבִילָה אֲבוּדָה דּוֹרֶשֶׁת חֲקִירָה פְּנִימִית בַּחֶבְרָה.",
            exampleNative = "חֲבִילָה אֲבוּדָה требует внутреннего расследования в фирме.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171702L, 171711L, 171712L, 171714L, 171715L, 171722L)),
        WordEntity(
            id = 171714, setId = 1717, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "courier_problems", transliteration = "ikuv bimsira",
            original = "עִכּוּב בִּמְסִירָה", translation = "задержка доставки",
            definition = "אִחוּר בִּזְמַן הַהַגָּעָה אֵצֶל הַלָּקוֹחַ מֵעֵבֶר לְמַה שֶּׁהֻבְטַח.",
            definitionNative = "Опоздание прибытия к заказчику сверх обещанного срока.",
            example = "עִכּוּב בִּמְסִירָה גָּרַם לְלָקוֹחַ לְהִתְלוֹנֵן בַּטֵּלֵפוֹן.",
            exampleNative = "עִכּוּב בִּמְסִירָה заставил клиента жаловаться по телефону.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171704L, 171710L, 171711L, 171712L, 171713L, 171715L, 171716L, 171717L, 171718L)),
        WordEntity(
            id = 171715, setId = 1717, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "courier_problems", transliteration = "takala barekhev",
            original = "תַּקָּלָה בָּרֶכֶב", translation = "поломка транспорта",
            definition = "כִּשָּׁלוֹן טֶכְנִי בָּאוֹפַנּוֹעַ אוֹ בָּרֶכֶב שֶׁעוֹצֵר אֶת הַסִּבּוּב.",
            definitionNative = "Техническая неисправность скутера или машины, прерывающая рейс.",
            example = "תַּקָּלָה בָּרֶכֶב אִלְּצָה אוֹתִי לִקְרֹא לְגָרָר בַּדֶּרֶךְ.",
            exampleNative = "תַּקָּלָה בָּרֶכֶב заставила меня вызвать эвакуатор по пути.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171711L, 171712L, 171713L, 171714L)),

        // ── courier_calculations (5) — расчёты и тарифы ──
        WordEntity(
            id = 171716, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_calculations", transliteration = "ta'arif basis",
            original = "תַּעֲרִיף בָּסִיס", translation = "базовый тариф доставки",
            definition = "מְחִיר הַתְחָלָתִי שֶׁכָּל לָקוֹחַ מְשַׁלֵּם לִפְנֵי תּוֹסָפוֹת.",
            definitionNative = "Стартовая цена, которую заказчик платит до любых надбавок.",
            example = "תַּעֲרִיף בָּסִיס בְּתוֹךְ הָעִיר עוֹמֵד עַל אַרְבָּעִים שֶׁקֶל.",
            exampleNative = "תַּעֲרִיף בָּסִיס внутри города стоит сорок шекелей.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171717L, 171718L, 171719L, 171720L)),
        WordEntity(
            id = 171717, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_calculations", transliteration = "tosefet merkhak",
            original = "תּוֹסֶפֶת מֶרְחָק", translation = "доплата за дальность",
            definition = "סְכוּם נוֹסָף שֶׁמֻּתְוָסֵף לְכָל קִילוֹמֶטֶר מֵעֵבֶר לִתְחוּם הָרָגִיל.",
            definitionNative = "Сумма, добавляемая за каждый километр сверх стандартной зоны.",
            example = "תּוֹסֶפֶת מֶרְחָק לְהֶרְצֵלִיָּה הָיְתָה עֶשְׂרִים שֶׁקֶל.",
            exampleNative = "תּוֹסֶפֶת מֶרְחָק до Герцлии составила двадцать шекелей.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171716L, 171718L, 171719L, 171720L, 171723L)),
        WordEntity(
            id = 171718, setId = 1717, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "courier_calculations", transliteration = "dmei khaniya",
            original = "דְּמֵי חֲנִיָּה", translation = "оплата парковки",
            definition = "כֶּסֶף שֶׁהַשָּׁלִיחַ מוֹצִיא עַל מָקוֹם חֲנָיָה לְיָד הַלָּקוֹחַ.",
            definitionNative = "Деньги, что курьер тратит на стоянку рядом с клиентом.",
            example = "דְּמֵי חֲנִיָּה בְּמֶרְכַּז הָעִיר אוֹכְלִים חֵלֶק מֵהַשָּׂכָר.",
            exampleNative = "דְּמֵי חֲנִיָּה в центре съедают часть заработка.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171716L, 171717L, 171719L, 171720L)),
        WordEntity(
            id = 171719, setId = 1717, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "courier_calculations", transliteration = "tashlum bimzuman",
            original = "תַּשְׁלוּם בִּמְזוּמָן", translation = "оплата наличными при получении",
            definition = "כֶּסֶף שֶׁהַמְּקַבֵּל מוֹסֵר לַשָּׁלִיחַ בָּרֶגַע שֶׁמְּקַבֵּל אֶת הַפְּרִיט.",
            definitionNative = "Деньги, что получатель отдаёт курьеру в момент получения товара.",
            example = "תַּשְׁלוּם בִּמְזוּמָן עֲדַיִן נָפוֹץ בְּשׁוּקֵי אוֹכֶל.",
            exampleNative = "תַּשְׁלוּם בִּמְזוּמָן всё ещё распространён на продуктовых рынках.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171716L, 171717L, 171718L, 171720L)),
        WordEntity(
            id = 171720, setId = 1717, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "courier_calculations", transliteration = "kabala bikhtav",
            original = "קַבָּלָה בִּכְתָב", translation = "письменная квитанция",
            definition = "פֶּתֶק רָשְׁמִי שֶׁמְּאַשֵּׁר אֶת סְכוּם הַתַּשְׁלוּם וְאֶת הַתַּאֲרִיךְ.",
            definitionNative = "Официальная бумага, удостоверяющая сумму и дату оплаты.",
            example = "בִּקַּשְׁתִּי קַבָּלָה בִּכְתָב לַחֲשׁוּב לִפְנֵי שֶׁעֲזַבְתִּי.",
            exampleNative = "Я попросил קַבָּלָה בִּכְתָב для отчёта перед уходом.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171716L, 171717L, 171718L, 171719L, 171721L, 171724L)),

        // ── courier_handoff (5) — передача и подтверждение получения ──
        WordEntity(
            id = 171721, setId = 1717, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "courier_handoff", transliteration = "srikat barkod",
            original = "סְרִיקַת בָּרְקוֹד", translation = "сканирование штрихкода",
            definition = "פְּעֻלָּה שֶׁמְּעַדְכֶּנֶת בַּמַּעֲרֶכֶת שֶׁהַחֲבִילָה הִגִּיעָה לַיָּעַד.",
            definitionNative = "Действие, отмечающее в системе прибытие посылки на точку.",
            example = "סְרִיקַת בָּרְקוֹד נִכְשְׁלָה כִּי הַמַּדְבֵּקָה קְרוּעָה.",
            exampleNative = "סְרִיקַת בָּרְקוֹד не сработало — наклейка порвана.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171722L, 171723L, 171724L, 171725L)),
        WordEntity(
            id = 171722, setId = 1717, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "courier_handoff", transliteration = "msira lashakhen",
            original = "מְסִירָה לְשָׁכֵן", translation = "выдача соседу",
            definition = "מַצָּב שֶׁבּוֹ הַחֲבִילָה נִשְׁאֶרֶת אֵצֶל אָדָם מֵהַבִּנְיָן הַסָּמוּךְ.",
            definitionNative = "Случай, когда товар оставляют у человека из соседней квартиры.",
            example = "מְסִירָה לְשָׁכֵן דּוֹרֶשֶׁת אִישּׁוּר טֶלֶפוֹנִי מֵהַלָּקוֹחַ.",
            exampleNative = "מְסִירָה לְשָׁכֵן требует устного согласия клиента по телефону.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171701L, 171702L, 171712L, 171717L, 171721L, 171723L, 171724L, 171725L)),
        WordEntity(
            id = 171723, setId = 1717, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "courier_handoff", transliteration = "msira ishit",
            original = "מְסִירָה אִישִׁית", translation = "вручение лично в руки",
            definition = "הַעֲבָרַת הַפְּרִיט יָשִׁיר לְיַד הַמְּקַבֵּל בְּלִי מְתַוְּכִים.",
            definitionNative = "Передача товара прямо в руки получателю без посредников.",
            example = "מְסִירָה אִישִׁית חוֹבָה בְּמִסְמְכֵי בָּתֵי דִּין.",
            exampleNative = "מְסִירָה אִישִׁית обязательна для судебных документов.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171720L, 171721L, 171722L, 171724L, 171725L)),
        WordEntity(
            id = 171724, setId = 1717, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "courier_handoff", transliteration = "ishur bitmuna",
            original = "אִישּׁוּר בִּתְמוּנָה", translation = "фото-подтверждение получения",
            definition = "צִלּוּם שֶׁמַּרְאֶה אֶת הַחֲבִילָה אֵצֶל הַמְּקַבֵּל לִרְאָיָה.",
            definitionNative = "Снимок, показывающий посылку у получателя как доказательство.",
            example = "אִישּׁוּר בִּתְמוּנָה נִשְׁמָר בָּאַפְּלִיקַצְיָה לְשָׁנָה שְׁלֵמָה.",
            exampleNative = "אִישּׁוּר בִּתְמוּנָה хранится в приложении целый год.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171711L, 171721L, 171722L, 171723L, 171725L)),
        WordEntity(
            id = 171725, setId = 1717, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "courier_handoff", transliteration = "ma'akav khavila",
            original = "מַעֲקָב חֲבִילָה", translation = "проверка статуса посылки",
            definition = "בְּדִיקָה אֵיפֹה הַפְּרִיט נִמְצָא בְּכָל שָׁלָב מֵהַשּׁוֹלֵחַ עַד הַסּוֹף.",
            definitionNative = "Проверка местонахождения товара на каждом шаге пути.",
            example = "מַעֲקָב חֲבִילָה הֶרְאָה שֶׁהַטֻּפָּס עָבַר אֶת הַמּוֹכֵס.",
            exampleNative = "מַעֲקָב חֲבִילָה показал, что груз прошёл таможню.",
            isFillInBlankSafe = true,
         fillInBlankExclusions = listOf(171721L, 171722L, 171723L, 171724L)),
    )
}
