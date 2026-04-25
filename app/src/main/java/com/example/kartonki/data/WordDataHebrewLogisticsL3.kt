package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Logistics, level 3 (1 set, 25 words).
 * Углублённая лексика логистики: управление складом, цепочки поставок,
 * отслеживание грузов, координация с водителями.
 *
 * Set 1718 (level 3, RARE + EPIC) — заполняет пробел между level 2 (1321)
 * и level 4 (1322) в теме «Логистика».
 *
 * Не пересекается с уже существующими сетами темы «Логистика»
 * (1320, 1321, 1322, 1323, 1324).
 *
 * Распределение редкостей: 15 RARE + 10 EPIC (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов каждая:
 *   logistics_warehouse_ops        — операции на складе
 *   logistics_route_planning       — планирование маршрутов
 *   logistics_cargo_tracking       — отслеживание грузов
 *   logistics_driver_coordination  — координация с водителями
 *   logistics_supply_chain         — цепочка поставок
 */
object WordDataHebrewLogisticsL3 {

    val sets = listOf(
        WordSetEntity(
            id = 1718, languagePair = "he-ru", orderIndex = 1718,
            name = "Логистика",
            description = "Управление складом, цепочки поставок, отслеживание грузов",
            topic = "Логистика", level = 3,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1718 — Логистика: углублённый (RARE + EPIC, B2–C1)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── logistics_warehouse_ops (5) — операции на складе ──
        WordEntity(
            id = 171801, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_warehouse_ops", transliteration = "ezor ikhsun",
            original = "אֵזוֹר אִחְסוּן", translation = "зона хранения",
            definition = "חֵלֶק מִן הַמַּחְסָן שֶׁבּוֹ מַנִּיחִים סְחוֹרָה לְפִי קָטֵגוֹרְיָה.",
            definitionNative = "Часть склада, куда раскладывают товар по группам и категориям.",
            example = "כָּל סוּג מוּצָר מְקֻבָּל אֶל אֵזוֹר אִחְסוּן מְיֻחָד.",
            exampleNative = "Каждый тип товара ставят в свой אֵזוֹר אִחְסוּן.",
            fillInBlankExclusions = listOf(171802L, 171803L, 171804L, 171805L)),
        WordEntity(
            id = 171802, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_warehouse_ops", transliteration = "madafei ikhsun",
            original = "מַדְפֵי אִחְסוּן", translation = "стеллажи (для хранения)",
            definition = "מַסְגָּרוֹת מַתָּכֶת גְּבוֹהוֹת לְהַנָּחַת סְחוֹרָה בְּקוֹמוֹת.",
            definitionNative = "Высокие металлические рамы — для хранения товара рядами и ярусами.",
            example = "מַדְפֵי אִחְסוּן חֲדָשִׁים מַכְפִּילִים אֶת קִבּוּל הַמַּחְסָן.",
            exampleNative = "Новые מַדְפֵי אִחְסוּן удваивают вместимость склада.",
            fillInBlankExclusions = listOf(171801L, 171803L, 171804L, 171805L)),
        WordEntity(
            id = 171803, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_warehouse_ops", transliteration = "sfirat melai",
            original = "סְפִירַת מְלַאי", translation = "инвентаризация",
            definition = "בְּדִיקָה יְדוּעָה כַּמָּה פְּרִיטִים יֵשׁ בָּאֱמֶת מוּל הָרָשׁוּם בַּמַּחְשֵׁב.",
            definitionNative = "Сверка реального количества товаров с числами в учётной системе.",
            example = "סְפִירַת מְלַאי שְׁנָתִית גִּלְּתָה פַּעַר שֶׁל אַרְבָּעִים פְּרִיטִים.",
            exampleNative = "Годовая סְפִירַת מְלַאי выявила недостачу сорока единиц.",
            fillInBlankExclusions = listOf(171801L, 171802L, 171804L, 171805L)),
        WordEntity(
            id = 171804, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_warehouse_ops", transliteration = "pikuakh melai",
            original = "פִּקּוּחַ מְלַאי", translation = "контроль складских запасов",
            definition = "מַעֲקָב יוֹמִי שֶׁל כַּמּוּת הַמּוּצָרִים כְּדֵי לֹא לְהַגִּיעַ לְחֶסֶר.",
            definitionNative = "Ежедневная проверка запасов, чтобы не остаться без товара на полках.",
            example = "פִּקּוּחַ מְלַאי קָפְדָנִי מוֹנֵעַ הַזְמָנוֹת מְבֻטָּלוֹת.",
            exampleNative = "Строгий פִּקּוּחַ מְלַאי уберегает от отменённых заказов.",
            fillInBlankExclusions = listOf(171801L, 171802L, 171803L, 171805L)),
        WordEntity(
            id = 171805, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_warehouse_ops", transliteration = "petakh te'ina",
            original = "פֶּתַח טְעִינָה", translation = "погрузочные ворота",
            definition = "שַׁעַר רָחָב שֶׁבּוֹ מַשָּׂאִיּוֹת נִגָּשׁוֹת לַמַּחְסָן לְקַבֵּל סְחוֹרָה.",
            definitionNative = "Широкие ворота, к которым подъезжают грузовики для загрузки товара.",
            example = "מַשָּׂאִית הִתְקָרְבָה לְפֶתַח טְעִינָה מִסְפָּר שָׁלֹשׁ.",
            exampleNative = "Грузовик подъехал к פֶּתַח טְעִינָה номер три.",
            fillInBlankExclusions = listOf(171801L, 171802L, 171803L, 171804L)),

        // ── logistics_route_planning (5) — планирование маршрутов ──
        WordEntity(
            id = 171806, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_route_planning", transliteration = "tikhnun maslulim",
            original = "תַּכְנוּן מַסְלוּלִים", translation = "планирование маршрутов",
            definition = "בְּחִירַת הַדְּרָכִים הַטּוֹבוֹת בְּיוֹתֵר לְכָל מַשָּׂאִית בַּיּוֹם הָעוֹבֵד.",
            definitionNative = "Подбор лучших дорог для каждой машины на предстоящий рабочий день.",
            example = "תַּכְנוּן מַסְלוּלִים חָכָם חוֹסֵךְ שָׁעָה בְּכָל סִבּוּב.",
            exampleNative = "Грамотный תַּכְנוּן מַסְלוּלִים экономит час на каждом круге.",
            fillInBlankExclusions = listOf(171807L, 171808L, 171809L, 171810L)),
        WordEntity(
            id = 171807, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_route_planning", transliteration = "tizmun mishlokhim",
            original = "תִּזְמוּן מִשְׁלוֹחִים", translation = "график доставок",
            definition = "סִדּוּר שְׁעָתִי שֶׁל הַסְּפָקוֹת לְפִי בַּקָּשׁוֹת הַלְּקוֹחוֹת.",
            definitionNative = "Часовое расписание поставок, составленное под пожелания клиентов.",
            example = "תִּזְמוּן מִשְׁלוֹחִים לַחֲנוּיוֹת הַמָּזוֹן נִקְבָּע אֶמֶשׁ.",
            exampleNative = "תִּזְמוּן מִשְׁלוֹחִים для продуктовых был утверждён вчера вечером.",
            fillInBlankExclusions = listOf(171806L, 171808L, 171809L, 171810L)),
        WordEntity(
            id = 171808, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_route_planning", transliteration = "svav hovala",
            original = "סְבָב הוֹבָלָה", translation = "транспортный круг (рейс по точкам)",
            definition = "מַסְלוּל סָגוּר שֶׁבּוֹ הַנֶּהָג מִתְחִיל וּמְסַיֵּם בְּאוֹתוֹ הַמָּקוֹם.",
            definitionNative = "Замкнутый рейс, начинающийся и кончающийся в одной точке базы.",
            example = "סְבָב הוֹבָלָה אֶחָד עוֹבֵר בִּשְׁמוֹנֶה חֲנוּיוֹת בָּעִיר.",
            exampleNative = "Один סְבָב הוֹבָלָה охватывает восемь магазинов в городе.",
            fillInBlankExclusions = listOf(171806L, 171807L, 171809L, 171810L)),
        WordEntity(
            id = 171809, setId = 1718, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "logistics_route_planning", transliteration = "optimum nefakh",
            original = "אוֹפְּטִימוּם נֶפַח", translation = "оптимальное использование объёма",
            definition = "סִדּוּר חֲבִילוֹת בְּתוֹךְ הָרֶכֶב שֶׁמְּמַלֵּא אֶת הַמָּקוֹם בְּלִי לְהַשְׁאִיר רֶוַח.",
            definitionNative = "Укладка коробок в кузове так, чтобы не пропадало ни одного куба места.",
            example = "אוֹפְּטִימוּם נֶפַח חוֹסֵךְ נְסִיעָה שְׁנִיָּה לָאוֹתוֹ לָקוֹחַ.",
            exampleNative = "אוֹפְּטִימוּם נֶפַח избавляет от повторного рейса к тому же клиенту.",
            fillInBlankExclusions = listOf(171806L, 171807L, 171808L, 171810L)),
        WordEntity(
            id = 171810, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_route_planning", transliteration = "omes yomi",
            original = "עוֹמֶס יוֹמִי", translation = "дневная нагрузка (на автопарк)",
            definition = "כַּמּוּת הַמִּשְׁלוֹחִים שֶׁכָּל צֶוֶת צָרִיךְ לְהַעֲבִיר בְּמֶשֶׁךְ הַמִּשְׁמֶרֶת.",
            definitionNative = "Объём поставок, который бригада должна развезти за одну смену.",
            example = "עוֹמֶס יוֹמִי גָּבוֹהַּ דּוֹרֵשׁ עוֹד שְׁנֵי נְהָגִים זְמַנִּיִּים.",
            exampleNative = "Высокий עוֹמֶס יוֹמִי требует двух дополнительных временных водителей.",
            fillInBlankExclusions = listOf(171806L, 171807L, 171808L, 171809L)),

        // ── logistics_cargo_tracking (5) — отслеживание грузов ──
        WordEntity(
            id = 171811, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_cargo_tracking", transliteration = "status mishloakh",
            original = "סְטָטוּס מִשְׁלוֹחַ", translation = "статус отправления",
            definition = "צִיּוּן בַּמַּעֲרֶכֶת אֵיפֹה הַחֲבִילָה כָּעֵת — בַּמַּחְסָן, בַּדֶּרֶךְ אוֹ נִמְסְרָה.",
            definitionNative = "Пометка в системе: где сейчас посылка — на складе, в пути или вручена.",
            example = "סְטָטוּס מִשְׁלוֹחַ הִתְעַדְכֵּן לְ\"בְּדֶרֶךְ אֶל הַלָּקוֹחַ\".",
            exampleNative = "סְטָטוּס מִשְׁלוֹחַ обновился на «в пути к получателю».",
            fillInBlankExclusions = listOf(171812L, 171813L, 171814L, 171815L)),
        WordEntity(
            id = 171812, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_cargo_tracking", transliteration = "ishur kabala",
            original = "אִשּׁוּר קְבָלָה", translation = "подтверждение получения",
            definition = "חֲתִימָה אוֹ צִילוּם שֶׁל הַנִּמְעָן בִּזְמַן שֶׁהַחֲבִילָה הוֹשַׁג בְּיָדָיו.",
            definitionNative = "Подпись или фото получателя в момент, когда посылка вручена в руки.",
            example = "אִשּׁוּר קְבָלָה נִשְׁלַח אַחֲרֵי הַמְּסִירָה אֶל הַשּׁוֹלֵחַ.",
            exampleNative = "אִשּׁוּר קְבָלָה отправили отправителю сразу после вручения.",
            fillInBlankExclusions = listOf(171811L, 171813L, 171814L, 171815L)),
        WordEntity(
            id = 171813, setId = 1718, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "logistics_cargo_tracking", transliteration = "zihui tag",
            original = "זִהוּי תָּג", translation = "идентификация по метке (RFID)",
            definition = "קְרִיאָה אוֹטוֹמָטִית שֶׁל קוֹדְ עַל הָאֲרִיזָה בְּלִי לִפְתֹּחַ אוֹתָהּ.",
            definitionNative = "Автоматическое чтение кода на упаковке без вскрытия коробки.",
            example = "זִהוּי תָּג מְהִיר חוֹסֵךְ דַּקּוֹת בִּכְנִיסָה לַמַּחְסָן.",
            exampleNative = "Быстрое זִהוּי תָּג экономит минуты на въезде в склад.",
            fillInBlankExclusions = listOf(171811L, 171812L, 171814L, 171815L)),
        WordEntity(
            id = 171814, setId = 1718, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "logistics_cargo_tracking", transliteration = "hoda'at ikhur",
            original = "הוֹדָעַת אִחוּר", translation = "уведомление о задержке",
            definition = "מֶסֶר אוֹטוֹמָטִי שֶׁמּוֹדִיעַ לַלָּקוֹחַ שֶׁהַמִּשְׁלוֹחַ יַגִּיעַ מְאֻחָר.",
            definitionNative = "Авто-сообщение клиенту о том, что доставка прибудет позже срока.",
            example = "הוֹדָעַת אִחוּר נִשְׁלְחָה כְּשֶׁהַתְּנוּעָה נֶעֶצְרָה בַּכְּבִישׁ.",
            exampleNative = "הוֹדָעַת אִחוּר отправили, когда движение встало на трассе.",
            fillInBlankExclusions = listOf(171811L, 171812L, 171813L, 171815L)),
        WordEntity(
            id = 171815, setId = 1718, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "logistics_cargo_tracking", transliteration = "tag itur",
            original = "תָּג אִיתוּר", translation = "GPS-трекер на грузе",
            definition = "מַכְשִׁיר קָטָן עַל הָאֲרִיזָה הַשּׁוֹלֵחַ אֶת מְקוֹמוֹ בִּזְמַן אֲמִיתִּי.",
            definitionNative = "Маленькое устройство на упаковке, передающее координаты в реальном времени.",
            example = "תָּג אִיתוּר עַל הַמְּכוֹלָה מַסְפִּיק לִשְׁלוֹשִׁים יוֹם.",
            exampleNative = "תָּג אִיתוּר на контейнере держит заряд тридцать дней.",
            fillInBlankExclusions = listOf(171811L, 171812L, 171813L, 171814L)),

        // ── logistics_driver_coordination (5) — координация с водителями ──
        WordEntity(
            id = 171816, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_driver_coordination", transliteration = "tadrukh nehag",
            original = "תַּדְרוּךְ נֶהָג", translation = "инструктаж водителя",
            definition = "פְּגִישָׁה קְצָרָה לִפְנֵי נְסִיעָה עִם הֶסְבֵּר עַל מַסְלוּל וּלְקוֹחוֹת.",
            definitionNative = "Короткая встреча перед рейсом — пройтись по маршруту и клиентам.",
            example = "תַּדְרוּךְ נֶהָג בַּבֹּקֶר אוֹרֵךְ עֶשֶׂר דַּקּוֹת בִּלְבַד.",
            exampleNative = "Утренний תַּדְרוּךְ נֶהָג занимает всего десять минут.",
            fillInBlankExclusions = listOf(171817L, 171818L, 171819L, 171820L)),
        WordEntity(
            id = 171817, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_driver_coordination", transliteration = "ha'amasat masa",
            original = "הַעֲמָסַת מַשָּׂא", translation = "погрузка груза",
            definition = "הַעֲבָרַת חֲבִילוֹת מִן הַמַּחְסָן אֶל תּוֹךְ הָרֶכֶב לִפְנֵי הַיְּצִיאָה.",
            definitionNative = "Перенос коробок со склада в кузов перед самым выездом машины.",
            example = "הַעֲמָסַת מַשָּׂא לְמַשָּׂאִית גְּדוֹלָה לוֹקֶחֶת כְּשָׁעָה.",
            exampleNative = "הַעֲמָסַת מַשָּׂא на большой грузовик занимает около часа.",
            fillInBlankExclusions = listOf(171816L, 171818L, 171819L, 171820L)),
        WordEntity(
            id = 171818, setId = 1718, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "logistics_driver_coordination", transliteration = "tahalikh prika",
            original = "תַּהֲלִיךְ פְּרִיקָה", translation = "процесс разгрузки",
            definition = "סֵדֶר הַפְּעֻלּוֹת בִּרְדִיפַת הַסְּחוֹרָה מִן הָרֶכֶב אֶל הַמַּחְסָן.",
            definitionNative = "Порядок действий при выгрузке товара из машины обратно в склад.",
            example = "תַּהֲלִיךְ פְּרִיקָה מְסֻדָּר חוֹסֵךְ נֶזֶק לַחֲבִילוֹת.",
            exampleNative = "Чёткий תַּהֲלִיךְ פְּרִיקָה уберегает коробки от повреждений.",
            fillInBlankExclusions = listOf(171816L, 171817L, 171819L, 171820L)),
        WordEntity(
            id = 171819, setId = 1718, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "logistics_driver_coordination", transliteration = "khalukat mishmarot",
            original = "חֲלוּקַת מִשְׁמָרוֹת", translation = "распределение смен (среди водителей)",
            definition = "סִדּוּר מִי נוֹסֵעַ בַּבֹּקֶר וּמִי בָּעֶרֶב לְפִי זְמִינוּת הַצֶּוֶת.",
            definitionNative = "Расписание, кто едет утром и кто вечером, по доступности бригады.",
            example = "חֲלוּקַת מִשְׁמָרוֹת חֲדָשָׁה הִקְלָה עַל נְהָגֵי הַסּוֹף שָׁבוּעַ.",
            exampleNative = "Новая חֲלוּקַת מִשְׁמָרוֹת облегчила жизнь водителям выходных.",
            fillInBlankExclusions = listOf(171816L, 171817L, 171818L, 171820L)),
        WordEntity(
            id = 171820, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_driver_coordination", transliteration = "svav nehagim",
            original = "סְבָב נְהָגִים", translation = "ротация водителей",
            definition = "הַחְלָפָה תְּקוּפָתִית בֵּין הַנְּהָגִים עַל אוֹתוֹ הַמַּסְלוּל.",
            definitionNative = "Периодическая смена водителей, едущих по одному и тому же рейсу.",
            example = "סְבָב נְהָגִים מוֹנֵעַ מֵעִיפוּת מִדַּרְכֵי שִׁגְרָה.",
            exampleNative = "סְבָב נְהָגִים защищает от усталости на привычных трассах.",
            fillInBlankExclusions = listOf(171816L, 171817L, 171818L, 171819L)),

        // ── logistics_supply_chain (5) — цепочка поставок ──
        WordEntity(
            id = 171821, setId = 1718, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "logistics_supply_chain", transliteration = "sapak rashi",
            original = "סַפָּק רָאשִׁי", translation = "основной поставщик",
            definition = "חֶבְרָה שֶׁמְּסַפֶּקֶת אֶת רֹב הַסְּחוֹרָה לַלָּקוֹחַ עַל בָּסִיס קָבוּעַ.",
            definitionNative = "Компания, которая поставляет основную долю товара клиенту на регулярной основе.",
            example = "סַפָּק רָאשִׁי שִׁנָּה מְחִירִים, וְהִשְׁפִּיעַ עַל כָּל הָרֶשֶׁת.",
            exampleNative = "סַפָּק רָאשִׁי изменил цены — это ударило по всей сети.",
            fillInBlankExclusions = listOf(171822L, 171823L, 171824L, 171825L)),
        WordEntity(
            id = 171822, setId = 1718, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "logistics_supply_chain", transliteration = "hazmanat rekhesh",
            original = "הַזְמָנַת רֶכֶשׁ", translation = "заявка на закупку",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁבּוֹ מְבַקְּשִׁים לִקְנוֹת סְחוֹרָה מִסַּפָּק חִיצוֹנִי.",
            definitionNative = "Официальная бумага с просьбой купить товар у внешнего поставщика.",
            example = "הַזְמָנַת רֶכֶשׁ אֻשְּׁרָה אַחֲרֵי שָׁעָתַיִם בִּלְבַד.",
            exampleNative = "הַזְמָנַת רֶכֶשׁ согласовали всего за два часа.",
            fillInBlankExclusions = listOf(171821L, 171823L, 171824L, 171825L)),
        WordEntity(
            id = 171823, setId = 1718, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "logistics_supply_chain", transliteration = "mishloakh nikhnas",
            original = "מִשְׁלוֹחַ נִכְנָס", translation = "входящая поставка",
            definition = "סְחוֹרָה שֶׁמַּגִּיעָה אֶל הַחֶבְרָה מֵחוּץ — לְקַבָּלָה וּלְאִחְסוּן.",
            definitionNative = "Товар, прибывающий в компанию извне, на приёмку и хранение.",
            example = "מִשְׁלוֹחַ נִכְנָס מִסִּין יַגִּיעַ בִּתְחִלַּת הַשָּׁבוּעַ.",
            exampleNative = "מִשְׁלוֹחַ נִכְנָס из Китая прибудет в начале недели.",
            fillInBlankExclusions = listOf(171821L, 171822L, 171824L, 171825L)),
        WordEntity(
            id = 171824, setId = 1718, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "logistics_supply_chain", transliteration = "mishloakh yotse",
            original = "מִשְׁלוֹחַ יוֹצֵא", translation = "исходящая отгрузка",
            definition = "סְחוֹרָה שֶׁעוֹזֶבֶת אֶת הַמַּחְסָן בִּכְוּוּן הַלָּקוֹחַ הַסּוֹפִי.",
            definitionNative = "Товар, покидающий склад в направлении конечного покупателя.",
            example = "מִשְׁלוֹחַ יוֹצֵא רִאשׁוֹן עוֹזֵב כָּל בֹּקֶר בְּשֵׁשׁ.",
            exampleNative = "Первый מִשְׁלוֹחַ יוֹצֵא уезжает каждое утро ровно в шесть.",
            fillInBlankExclusions = listOf(171821L, 171822L, 171823L, 171825L)),
        WordEntity(
            id = 171825, setId = 1718, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "logistics_supply_chain", transliteration = "skhora gmura",
            original = "סְחוֹרָה גְּמוּרָה", translation = "готовая продукция",
            definition = "מוּצָר שֶׁעָבַר אֶת כָּל שָׁלָבֵי הַיְּצוּר וּמוּכָן לִשְׁלִיחָה לַלָּקוֹחַ.",
            definitionNative = "Изделие, прошедшее все стадии производства и готовое к отправке клиенту.",
            example = "סְחוֹרָה גְּמוּרָה מַמְתִּינָה עַל הַמַּדָּף לְמִשְׁלוֹחַ בָּעֶרֶב.",
            exampleNative = "סְחוֹרָה גְּמוּרָה ждёт на стеллаже отправки вечером.",
            fillInBlankExclusions = listOf(171821L, 171822L, 171823L, 171824L)),
    )
}
