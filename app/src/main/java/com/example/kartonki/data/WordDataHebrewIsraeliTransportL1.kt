package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic «Транспорт в Израиле», level 1 (A1-A2).
 * Один сет × 25 слов. setId = 1852.
 *
 *  - 17 COMMON + 8 UNCOMMON (2 смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      transport_l1_vehicles       — אוטובוס, מונית, רכבת, אופניים, רכב (5)
 *      transport_l1_rav_kav        — רב-קו, כרטיס, תעודת תלמיד, הטענה, חיוב (5)
 *      transport_l1_stops_stations — תחנה, רציף, תחנת רכבת, מסע, נוסע (5)
 *      transport_l1_navigation     — קו, מסלול, יעד, כיוון, מפה (5)
 *      transport_l1_daily_actions  — לחכות, לעלות, לרדת, לנסוע, להזמין (5)
 *  - Тема — повседневная мобильность израильтян: автобус и Рав-Кав, поезд
 *    и центральный автовокзал, маршруты Moovit, такси Gett. Никудим везде
 *    (стандарт he-ru). Огласовки в `example` ставятся только на целевом слове.
 *  - Базовые оригиналы (אוֹטוֹבּוּס, מוֹנִית, רַכֶּבֶת, אוֹפַנַּיִם, רֶכֶב,
 *    כַּרְטִיס, רַב-קַו, מַפָּה, תַּחֲנָה, מַסְלוּל, כִּוּוּן, יַעַד, קַו,
 *    לִנְסוֹעַ, לַעֲלוֹת, לָרֶדֶת, לְהַזְמִין, נוֹסֵעַ, רָצִיף, חִיּוּב,
 *    תַּחֲנַת רַכֶּבֶת) пересекаются с сериями City L1, Transport V2, UrbanLife,
 *    Aliya, Cuisine — это другие темы (Город / Транспорт / Городская жизнь /
 *    Алия и Израиль / Кулинария Израиля), дубли в разных темах допустимы по
 *    политике. Без них L1 «Транспорт в Израиле» неполноценен — это корневой
 *    словарь израильской мобильности, без которого тема пустая. Rarity
 *    выровнены под существующие записи.
 */
object WordDataHebrewIsraeliTransportL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1852, languagePair = "he-ru", orderIndex = 1852,
            name = "Транспорт в Израиле",
            description = "Автобус, Рав-Кав, поезд, такси и маршруты по стране",
            topic = "Транспорт в Израиле", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── transport_l1_vehicles (5) ───────────────────────────────────
        WordEntity(
            id = 185201, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_vehicles",
            original = "אוֹטוֹבּוּס", translation = "автобус",
            definition = "כְּלִי תַּחְבּוּרָה גָּדוֹל שֶׁמַּסִּיעַ הַרְבֵּה נוֹסְעִים בַּקַּו הָעִירוֹנִי.",
            definitionNative = "Большой транспорт, что возит много пассажиров по городскому маршруту.",
            example = "אוֹטוֹבּוּס מִסְפָּר חֲמִשִּׁים וְחָמֵשׁ נוֹסֵעַ לָעֲבוֹדָה שֶׁלִּי בַּבֹּקֶר.",
            exampleNative = "אוֹטוֹבּוּס номер пятьдесят пять идёт прямо до моей работы утром.",
         fillInBlankExclusions = listOf(185202L, 185203L, 185204L, 185205L, 185216L)),
        WordEntity(
            id = 185202, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_vehicles",
            original = "מוֹנִית", translation = "такси",
            definition = "מְכוֹנִית עִם נֶהָג שֶׁמַּסִּיעָה לְפִי בַּקָּשָׁה תְּמוּרַת תַּשְׁלוּם בַּמּוֹנֶה.",
            definitionNative = "Машина с водителем, что везёт по адресу за оплату по счётчику.",
            example = "הִזְמַנְתִּי מוֹנִית בְּגֶט וְהִיא הִגִּיעָה תּוֹךְ שָׁלוֹשׁ דַּקּוֹת.",
            exampleNative = "Я заказал מוֹנִית через Gett, и она пришла за три минуты.",
         fillInBlankExclusions = listOf(185201L, 185203L, 185204L, 185205L)),
        WordEntity(
            id = 185203, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_vehicles",
            original = "רַכֶּבֶת", translation = "поезд",
            definition = "כְּלִי תַּחְבּוּרָה אָרֹךְ עַל פַּסֵּי בַּרְזֶל שֶׁעוֹבֵר בֵּין עָרִים בִּמְהִירוּת.",
            definitionNative = "Длинный транспорт на железных рельсах, что быстро ходит между городами.",
            example = "הָרַכֶּבֶת מִתֵּל אָבִיב לְחֵיפָה יוֹצֵאת כָּל חֲצִי שָׁעָה.",
            exampleNative = "רַכֶּבֶת из Тель-Авива в Хайфу отправляется каждые полчаса.",
         fillInBlankExclusions = listOf(185201L, 185202L, 185204L, 185205L)),
        WordEntity(
            id = 185204, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_vehicles",
            original = "אוֹפַנַּיִם", translation = "велосипед",
            definition = "כְּלִי רֶכֶב קָטָן עִם שְׁנֵי גַּלְגַּלִּים שֶׁמַּנִּיעִים בְּכֹחַ הָרַגְלַיִם.",
            definitionNative = "Маленький транспорт с двумя колёсами, что движется силой ног.",
            example = "אֲנִי רוֹכֵב עַל אוֹפַנַּיִם לַחוֹף בְּכָל יוֹם שִׁשִּׁי בַּבֹּקֶר.",
            exampleNative = "Я катаюсь на אוֹפַנַּיִם до пляжа каждую пятницу с утра.",
         fillInBlankExclusions = listOf(185201L, 185202L, 185203L, 185205L)),
        WordEntity(
            id = 185205, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_vehicles",
            original = "רֶכֶב", translation = "транспортное средство",
            definition = "כָּל כְּלִי תַּחְבּוּרָה פְּרָטִי אוֹ צִבּוּרִי שֶׁמַּסִּיעַ אֲנָשִׁים בַּכְּבִישׁ.",
            definitionNative = "Любая машина или повозка, что возит людей по дорогам.",
            example = "אֵין לִי רֶכֶב פְּרָטִי, אֲנִי נוֹסֵעַ רַק בְּתַחְבּוּרָה צִבּוּרִית.",
            exampleNative = "У меня нет своего רֶכֶב, я езжу только общественным транспортом.",
         fillInBlankExclusions = listOf(185201L, 185202L, 185203L, 185204L)),

        // ─── transport_l1_rav_kav (5) ────────────────────────────────────
        WordEntity(
            id = 185206, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_rav_kav",
            original = "רַב-קַו", translation = "Рав-Кав (проездная карта)",
            definition = "כַּרְטִיס חָכָם רַב-שִׁמּוּשִׁי לְתַשְׁלוּם עַל אוֹטוֹבּוּס וְרַכֶּבֶת בְּיִשְׂרָאֵל.",
            definitionNative = "Многоразовая смарт-карта для оплаты автобусов и поездов в Израиле.",
            example = "שָׁכַחְתִּי אֶת הָרַב-קַו בַּבַּיִת וְשִׁלַּמְתִּי לַנֶּהָג בִּמְזוּמָן.",
            exampleNative = "Я забыл רַב-קַו дома и заплатил водителю наличными.",
         fillInBlankExclusions = listOf(185207L, 185208L, 185209L, 185210L)),
        WordEntity(
            id = 185207, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_rav_kav",
            original = "כַּרְטִיס", translation = "билет",
            definition = "אִשּׁוּר בְּכְתָב אוֹ דִּיגִיטָלִי שֶׁמַּתִּיר לִנְסוֹעַ בִּכְלִי תַּחְבּוּרָה.",
            definitionNative = "Бумажный или цифровой документ, что разрешает поездку в транспорте.",
            example = "קָנִיתִי כַּרְטִיס בּוֹדֵד לָאוֹטוֹבּוּס בְּעֶשֶׂר שְׁקָלִים.",
            exampleNative = "Я купил разовый כַּרְטִיס на автобус за десять шекелей.",
         fillInBlankExclusions = listOf(185206L, 185209L, 185210L)),
        WordEntity(
            id = 185208, setId = 1852, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "transport_l1_rav_kav",
            original = "תְּעוּדַת תַּלְמִיד", translation = "ученический билет",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁמּוֹכִיחַ שֶׁאַתָּה תַּלְמִיד וְזַכַּאי לְהַנָּחָה בַּתַּחְבּוּרָה.",
            definitionNative = "Документ, что подтверждает статус ученика и право на скидку в транспорте.",
            example = "הֶרְאֵיתִי לַנֶּהָג תְּעוּדַת תַּלְמִיד וְקִבַּלְתִּי הַנָּחָה שֶׁל חֲמִשִּׁים אָחוּז.",
            exampleNative = "Я показал водителю תְּעוּדַת תַּלְמִיד и получил скидку пятьдесят процентов.",
        ),
        WordEntity(
            id = 185209, setId = 1852, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l1_rav_kav",
            original = "הַטְעָנָה", translation = "пополнение (карты)",
            definition = "הוֹסָפַת כֶּסֶף אוֹ נְסִיעוֹת לָרַב-קַו בְּעֶמְדָּה אוֹ בָּאַפְלִיקַצְיָה.",
            definitionNative = "Добавление денег или поездок на Рав-Кав через автомат или приложение.",
            example = "עָשִׂיתִי הַטְעָנָה שֶׁל מֵאָה שֶׁקֶל לָרַב-קַו בָּעֶמְדָּה בַּתַּחֲנָה.",
            exampleNative = "Я сделал הַטְעָנָה на сто шекелей в терминале на остановке утром.",
         fillInBlankExclusions = listOf(185207L, 185210L)),
        WordEntity(
            id = 185210, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_rav_kav",
            original = "חִיּוּב", translation = "списание (с карты)",
            definition = "הוֹרָדָה אוֹטוֹמָטִית שֶׁל סְכוּם הַנְּסִיעָה מֵהָרַב-קַו בִּכְנִיסָה לִכְלִי הַתַּחְבּוּרָה.",
            definitionNative = "Автоматическое снятие суммы за поездку с Рав-Кав при входе в транспорт.",
            example = "הִקַּשְׁתִּי אֶת הָרַב-קַו וְהַחִיּוּב הָיָה שִׁשָּׁה שְׁקָלִים וְחֵצִי.",
            exampleNative = "Я приложил Рав-Кав, и חִיּוּב составил шесть с половиной шекелей.",
         fillInBlankExclusions = listOf(185207L, 185209L)),

        // ─── transport_l1_stops_stations (5) ─────────────────────────────
        WordEntity(
            id = 185211, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_stops_stations",
            original = "תַּחֲנָה", translation = "остановка",
            definition = "מָקוֹם בָּרְחוֹב שֶׁבּוֹ הָאוֹטוֹבּוּס עוֹצֵר וְהַנּוֹסְעִים עוֹלִים אוֹ יוֹרְדִים.",
            definitionNative = "Место на улице, где автобус стоит и пассажиры заходят или выходят.",
            example = "תַּחֲנָה קְרוֹבָה לַבַּיִת שֶׁלִּי נִמְצֵאת מוּל הַסּוּפֶּרְמַרְקֶט.",
            exampleNative = "Ближайшая ко мне תַּחֲנָה находится прямо напротив супермаркета.",
         fillInBlankExclusions = listOf(185212L, 185213L, 185214L, 185215L)),
        WordEntity(
            id = 185212, setId = 1852, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l1_stops_stations",
            original = "רָצִיף", translation = "перрон",
            definition = "מִדְרֶכֶת מוּגְבֶּהֶת עַל יַד פַּסֵּי הָרַכֶּבֶת לַעֲלִיָּה וִירִידָה שֶׁל נוֹסְעִים.",
            definitionNative = "Приподнятая платформа возле рельсов, чтобы пассажиры могли войти и выйти.",
            example = "הָרַכֶּבֶת לִירוּשָׁלַיִם יוֹצֵאת מֵרָצִיף שָׁלֹשׁ בְּעוֹד שָׁלֹשׁ דַּקּוֹת.",
            exampleNative = "Поезд в Иерусалим уходит с רָצִיף номер три через три минуты.",
         fillInBlankExclusions = listOf(185211L, 185214L, 185215L)),
        WordEntity(
            id = 185213, setId = 1852, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "transport_l1_stops_stations",
            original = "תַּחֲנַת רַכֶּבֶת", translation = "железнодорожная станция",
            definition = "בִּנְיָן עִם רְצִיפִים שֶׁבּוֹ רַכָּבוֹת עוֹצְרוֹת לִקְלוֹט וּלְהוֹרִיד נוֹסְעִים.",
            definitionNative = "Здание с перронами, где поезда останавливаются принять и высадить пассажиров.",
            example = "תַּחֲנַת רַכֶּבֶת חֲדָשָׁה נִפְתְּחָה רַק בַּשָּׁנָה שֶׁעָבְרָה לְיַד הַיָּם.",
            exampleNative = "Новая תַּחֲנַת רַכֶּבֶת открылась только в прошлом году у моря.",
         fillInBlankExclusions = listOf(185211L)),
        WordEntity(
            id = 185214, setId = 1852, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l1_stops_stations",
            original = "מָסָע", translation = "поездка",
            definition = "נְסִיעָה אֲרֻכָּה אוֹ מְעַנְיֶנֶת מִנְּקֻדָּה אַחַת לִנְקֻדָּה אַחֶרֶת בְּכְלִי תַּחְבּוּרָה.",
            definitionNative = "Долгое путешествие из одной точки в другую на машине или автобусе.",
            example = "הַמָּסָע מֵהַצָּפוֹן לְאֵילַת אָרַךְ שֵׁשׁ שָׁעוֹת בְּלִי הַפְסָקוֹת.",
            exampleNative = "מָסָע с севера до Эйлата занял шесть часов без остановок.",
        ),
        WordEntity(
            id = 185215, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_stops_stations",
            original = "נוֹסֵעַ", translation = "пассажир",
            definition = "אָדָם הַנִּמְצָא בִּכְלִי תַּחְבּוּרָה כְּלָקוֹחַ וְעוֹבֵר בּוֹ מִמָּקוֹם לְמָקוֹם.",
            definitionNative = "Человек, что платит и едет в транспорте как клиент, а не как водитель.",
            example = "כָּל נוֹסֵעַ צָרִיךְ לְהַקִּישׁ אֶת הָרַב-קַו בִּכְנִיסָה לָאוֹטוֹבּוּס.",
            exampleNative = "Каждый נוֹסֵעַ должен приложить Рав-Кав при входе в автобус.",
        ),

        // ─── transport_l1_navigation (5) ─────────────────────────────────
        WordEntity(
            id = 185216, setId = 1852, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l1_navigation",
            original = "קַו", translation = "линия (маршрута)",
            definition = "מַסְלוּל קָבוּעַ שֶׁל אוֹטוֹבּוּס אוֹ רַכֶּבֶת עִם מִסְפָּר וְרֶצֶף תַּחֲנוֹת קָבוּעַ.",
            definitionNative = "Постоянный маршрут автобуса или поезда с номером и набором остановок.",
            example = "קַו חֲמִשִּׁים וְאַרְבַּע נוֹסֵעַ מֵהַתַּחֲנָה הַמֶּרְכָּזִית לְאוּנִיבֶרְסִיטָה.",
            exampleNative = "קַו пятьдесят четыре идёт от центральной станции до университета.",
         fillInBlankExclusions = listOf(185201L, 185217L, 185218L, 185219L, 185220L)),
        WordEntity(
            id = 185217, setId = 1852, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l1_navigation",
            original = "מַסְלוּל", translation = "маршрут",
            definition = "אֹסֶף הָרְחוֹבוֹת וְהַתַּחֲנוֹת שֶׁבָּהֶם עוֹבֵר קַו תַּחְבּוּרָה מֵהַתְחָלָה לַסּוֹף.",
            definitionNative = "Набор улиц и остановок, по которым идёт линия транспорта от старта до финиша.",
            example = "מוּבִיט הִצִּיעַ לִי מַסְלוּל קָצָר יוֹתֵר עִם רַק חֲלִיפָה אַחַת.",
            exampleNative = "Moovit предложил мне מַסְלוּל короче с одной пересадкой вместо двух.",
         fillInBlankExclusions = listOf(185216L, 185218L, 185219L, 185220L)),
        WordEntity(
            id = 185218, setId = 1852, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l1_navigation",
            original = "יַעַד", translation = "пункт назначения",
            definition = "הַמָּקוֹם הַסּוֹפִי שֶׁאֵלָיו רוֹצִים לְהַגִּיעַ בִּנְסִיעָה אוֹ בְּמָסָע.",
            definitionNative = "Конечная точка, куда хотят добраться в поездке или путешествии.",
            example = "הַיַּעַד שֶׁל הָאוֹטוֹבּוּס הַזֶּה הוּא בְּאֵר שֶׁבַע, לֹא תֵּל אָבִיב.",
            exampleNative = "יַעַד этого автобуса — Беэр-Шева, а не Тель-Авив.",
        ),
        WordEntity(
            id = 185219, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_navigation",
            original = "כִּוּוּן", translation = "направление",
            definition = "הַצַּד אוֹ הַקַּו אֵלָיו נוֹסְעִים — צָפוֹן, דָּרוֹם, יָמִינָה אוֹ שְׂמֹאלָה.",
            definitionNative = "Сторона, в которую едут — север, юг, направо или налево.",
            example = "כִּוּוּן הַנְּסִיעָה שֶׁלִּי הוּא צָפוֹן, לֹא דָּרוֹם כְּמוֹ שֶׁחָשַׁבְתִּי.",
            exampleNative = "כִּוּוּן моей поездки — север, а не юг, как я раньше думал.",
         fillInBlankExclusions = listOf(185216L, 185217L, 185218L, 185220L)),
        WordEntity(
            id = 185220, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "transport_l1_navigation",
            original = "מַפָּה", translation = "карта",
            definition = "תְּמוּנָה גֵּאוֹגְרָפִית שֶׁמַּרְאָה רְחוֹבוֹת, תַּחֲנוֹת וְקַוֵּי תַּחְבּוּרָה בָּעִיר.",
            definitionNative = "Географический рисунок, что показывает улицы, остановки и линии транспорта.",
            example = "פָּתַחְתִּי אֶת הַמַּפָּה בַּטֶּלֶפוֹן לִרְאוֹת אֵיפֹה הַתַּחֲנָה הֲכִי קְרוֹבָה.",
            exampleNative = "Я открыл מַפָּה в телефоне, чтобы найти ближайшую остановку.",
        ),

        // ─── transport_l1_daily_actions (5) ──────────────────────────────
        WordEntity(
            id = 185221, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "transport_l1_daily_actions",
            original = "לְחַכּוֹת", translation = "ждать",
            definition = "לַעֲמֹד בְּמָקוֹם וּלְהַמְתִּין עַד שֶׁמַּשֶּׁהוּ אוֹ מִישֶׁהוּ יַגִּיעַ.",
            definitionNative = "Стоять на месте, пока кто-то или что-то не подойдёт или не приедет.",
            example = "הָיִיתִי צָרִיךְ לְחַכּוֹת רֶבַע שָׁעָה לָאוֹטוֹבּוּס בַּגֶּשֶׁם.",
            exampleNative = "Мне пришлось לְחַכּוֹת пятнадцать минут автобуса прямо под дождём.",
         fillInBlankExclusions = listOf(185222L, 185223L, 185224L, 185225L)),
        WordEntity(
            id = 185222, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "transport_l1_daily_actions",
            original = "לַעֲלוֹת", translation = "садиться (в транспорт)",
            definition = "לְהִכָּנֵס לִכְלִי תַּחְבּוּרָה דֶּרֶךְ הַדֶּלֶת לִפְנֵי שֶׁהַנְּסִיעָה מַתְחִילָה.",
            definitionNative = "Заходить в транспорт через дверь до того, как поездка начнётся.",
            example = "צָרִיךְ לַעֲלוֹת לָאוֹטוֹבּוּס דֶּרֶךְ הַדֶּלֶת הַקִּדְמִית בְּלִי לִדְחֹף.",
            exampleNative = "Надо לַעֲלוֹת в автобус через переднюю дверь, не толкаясь у входа.",
         fillInBlankExclusions = listOf(185221L, 185223L, 185224L, 185225L)),
        WordEntity(
            id = 185223, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "transport_l1_daily_actions",
            original = "לָרֶדֶת", translation = "выходить (из транспорта)",
            definition = "לָצֵאת מִכְּלִי תַּחְבּוּרָה דֶּרֶךְ הַדֶּלֶת בְּסוֹף הַנְּסִיעָה אוֹ בַּתַּחֲנָה.",
            definitionNative = "Покинуть машину или автобус через дверь в конце пути или на остановке.",
            example = "צָרִיךְ לָרֶדֶת בַּתַּחֲנָה הַבָּאָה לְיַד הָעִירִיָּה הַחֲדָשָׁה.",
            exampleNative = "Надо לָרֶדֶת на следующей остановке возле новой мэрии города.",
         fillInBlankExclusions = listOf(185221L, 185222L, 185224L, 185225L)),
        WordEntity(
            id = 185224, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "transport_l1_daily_actions",
            original = "לִנְסוֹעַ", translation = "ехать",
            definition = "לָלֶכֶת מִמָּקוֹם לְמָקוֹם בִּכְלִי תַּחְבּוּרָה כְּמוֹ אוֹטוֹבּוּס אוֹ רַכֶּבֶת.",
            definitionNative = "Перемещаться из одного места в другое в транспорте — автобусе или поезде.",
            example = "אֲנִי אוֹהֵב לִנְסוֹעַ בָּרַכֶּבֶת וּלְהִסְתַּכֵּל עַל הַשָּׂדוֹת.",
            exampleNative = "Я люблю לִנְסוֹעַ в поезде и смотреть на поля за окном.",
        ),
        WordEntity(
            id = 185225, setId = 1852, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "transport_l1_daily_actions",
            original = "לְהַזְמִין", translation = "заказывать (такси)",
            definition = "לְבַקֵּשׁ מוֹנִית דֶּרֶךְ אַפְלִיקַצְיָה אוֹ בַּטֶּלֶפוֹן וּלְחַכּוֹת שֶׁתַּגִּיעַ.",
            definitionNative = "Просить такси через приложение или по телефону и ждать, пока подъедет.",
            example = "הֶחְלַטְתִּי לְהַזְמִין מוֹנִית בְּגֶט כִּי הָאוֹטוֹבּוּס הָאַחֲרוֹן יָצָא.",
            exampleNative = "Я решил לְהַזְמִין такси в Gett, потому что последний автобус уже ушёл.",
         fillInBlankExclusions = listOf(185221L, 185222L, 185223L, 185224L)),
    )
}
