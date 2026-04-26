package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Driver, level 4 (1 set, 25 words).
 * Профессиональная лексика опытного водителя: коммерческие перевозки,
 * диспетчерская работа, юридические тонкости, специальная техника.
 *
 * Set 1715 (level 4, EPIC + LEGENDARY) — заполняет пробел между level 3 (1385)
 * и level 5 (1386, 1387) в теме «Водитель».
 *
 * Не пересекается с уже существующими сетами темы «Водитель»
 * (1383, 1384, 1385, 1386, 1387, 1559).
 *
 * Распределение редкостей: 15 EPIC + 10 LEGENDARY (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов каждая:
 *   driver_dispatch         — диспетчерская работа
 *   driver_documents_pro    — профессиональные документы
 *   driver_special_cargo    — специальные грузы
 *   driver_special_vehicle  — спецтехника / составы
 *   driver_legal_pro        — юридические тонкости профессии
 */
object WordDataHebrewDriverL4 {

    val sets = listOf(
        WordSetEntity(
            id = 1715, languagePair = "he-ru", orderIndex = 1715,
            name = "Дороги и работа водителем",
            description = "Коммерческие перевозки, диспетчерская, спецтехника",
            topic = "Дороги и работа водителем", level = 4,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1715 — Водитель: профессиональный (EPIC + LEGENDARY, C1–C2)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── driver_dispatch (5) — диспетчерская работа ──
        WordEntity(
            id = 171501, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_dispatch", transliteration = "menahel mishmeret",
            original = "מְנַהֵל מִשְׁמֶרֶת", translation = "диспетчер смены",
            definition = "אַחְרַאי שֶׁמְּחַלֵּק עֲבוֹדָה לְצֶוֶת הַנְּהָגִים בְּמֶשֶׁךְ הַשָּׁעוֹת.",
            definitionNative = "Сотрудник, распределяющий рейсы между водителями в течение часов.",
            example = "מְנַהֵל מִשְׁמֶרֶת חִלֵּק אֶת הַנְּסִיעוֹת בֵּין שְׁמוֹנָה צְוָתִים.",
            exampleNative = "מְנַהֵל מִשְׁמֶרֶת распределил рейсы между восемью бригадами.",
         fillInBlankExclusions = listOf(171502L, 171503L, 171504L, 171505L)),
        WordEntity(
            id = 171502, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_dispatch", transliteration = "khadar bakara",
            original = "חֲדַר בַּקָּרָה", translation = "диспетчерская",
            definition = "חֶדֶר עִם מָסָכִים שֶׁבּוֹ עוֹקְבִים אַחַר כָּל הַמַּשָּׂאִיּוֹת.",
            definitionNative = "Помещение с экранами, откуда следят за всеми машинами на рейсе.",
            example = "בַּחֲדַר בַּקָּרָה מַסָּכִים מַרְאִים מִקּוּם רֶכֶב בִּזְמַן אֲמִיתִּי.",
            exampleNative = "В חֲדַר בַּקָּרָה экраны показывают машины в реальном времени.",
         fillInBlankExclusions = listOf(171501L, 171503L, 171504L, 171505L)),
        WordEntity(
            id = 171503, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_dispatch", transliteration = "shibutz nesi'ot",
            original = "שִׁבּוּץ נְסִיעוֹת", translation = "распределение рейсов",
            definition = "חַלּוּקַת מַסְלוּלִים בֵּין נְהָגִים לְפִי כִּשּׁוּרִים וְזְמִינוּת.",
            definitionNative = "Назначение маршрутов разным водителям с учётом смен и навыков.",
            example = "שִׁבּוּץ נְסִיעוֹת מְסֻדָּר חוֹסֵךְ דֶּלֶק וְשָׁעוֹת עֲבוֹדָה.",
            exampleNative = "Грамотное שִׁבּוּץ נְסִיעוֹת экономит топливо и часы работы.",
         fillInBlankExclusions = listOf(171501L, 171502L, 171504L, 171505L)),
        WordEntity(
            id = 171504, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_dispatch", transliteration = "ikhul zmanim",
            original = "אִיכּוּל זְמַנִּים", translation = "расчёт времени в пути",
            definition = "הַעֲרָכָה כַּמָּה שָׁעוֹת תִּקַּח כָּל נְסִיעָה לְפִי הַתְּנוּעָה בַּדֶּרֶךְ.",
            definitionNative = "Оценка длительности рейса с учётом пробок и условий дороги.",
            example = "אִיכּוּל זְמַנִּים מְדֻיָּק עוֹזֵר לִפְגֹּשׁ אֶת הַלָּקוֹחַ בִּזְמַן.",
            exampleNative = "Точный אִיכּוּל זְמַנִּים помогает прибыть к клиенту вовремя.",
         fillInBlankExclusions = listOf(171501L, 171502L, 171503L, 171505L)),
        WordEntity(
            id = 171505, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_dispatch", transliteration = "te'um masa'ot",
            original = "תֵּאוּם מַשָּׂאוֹת", translation = "координация грузов",
            definition = "סִנְכְּרוּן בֵּין מִשְׁלוֹחִים שׁוֹנִים כְּדֵי לִמְלֵא רֶכֶב בְּמַחֲזוֹר אֶחָד.",
            definitionNative = "Согласование разных грузов, чтобы машина шла полной за один заезд.",
            example = "תֵּאוּם מַשָּׂאוֹת בֵּין שְׁלֹשָׁה לְקוֹחוֹת חָסַךְ נְסִיעָה רֵיקָה.",
            exampleNative = "תֵּאוּם מַשָּׂאוֹת между тремя клиентами избавил от пустого рейса.",
         fillInBlankExclusions = listOf(171501L, 171502L, 171503L, 171504L)),

        // ── driver_documents_pro (5) — профессиональные документы ──
        WordEntity(
            id = 171506, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_documents_pro", transliteration = "shtar mit'an",
            original = "שְׁטָר מִטְעָן", translation = "коносамент, грузовой документ",
            definition = "מִסְמָךְ הַמְפָרֵט מַה הוּבַל, מִמִּי וּלְמִי, וְכַמָּה זֶה שׁוֹקֵל.",
            definitionNative = "Бумага с описанием груза: что везут, от кого, кому и сколько весит.",
            example = "הַנֶּהָג חָתַם עַל שְׁטָר מִטְעָן בַּמַּחְסָן.",
            exampleNative = "Водитель подписал שְׁטָר מִטְעָן ещё на складе.",
         fillInBlankExclusions = listOf(171507L, 171508L, 171509L, 171510L, 171525L)),
        WordEntity(
            id = 171507, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_documents_pro", transliteration = "ishur ma'avar gvul",
            original = "אִישׁוּר מַעֲבָר גְּבוּל", translation = "разрешение на пересечение границы",
            definition = "תְּעוּדָה הַמְּתִירָה לְרֶכֶב מִסְחָרִי לַחֲצוֹת לִמְדִינָה אַחֶרֶת.",
            definitionNative = "Документ, дающий грузовой машине право выехать в другую страну.",
            example = "בְּלִי אִישׁוּר מַעֲבָר גְּבוּל לֹא יְאֻפְשַׁר מַעֲבָר.",
            exampleNative = "Без אִישׁוּר מַעֲבָר גְּבוּל через КПП не пропустят.",
         fillInBlankExclusions = listOf(171506L, 171508L, 171509L, 171510L)),
        WordEntity(
            id = 171508, setId = 1715, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "driver_documents_pro", transliteration = "kartis tachograph",
            original = "כַּרְטִיס תַּכּוֹגְרַף", translation = "карточка тахографа",
            definition = "כַּרְטִיס חָכָם הָאִישִׁי שֶׁל הַנֶּהָג שֶׁשּׁוֹמֵר אֶת שְׁעוֹת הַנְּהִיגָה.",
            definitionNative = "Личная смарт-карта, фиксирующая часы за рулём конкретного человека.",
            example = "הַשּׁוֹטֵר בִּקֵּשׁ לִרְאוֹת אֶת הַכַּרְטִיס תַּכּוֹגְרַף.",
            exampleNative = "Полицейский попросил предъявить כַּרְטִיס תַּכּוֹגְרַף.",
         fillInBlankExclusions = listOf(171506L, 171507L, 171509L, 171510L)),
        WordEntity(
            id = 171509, setId = 1715, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "driver_documents_pro", transliteration = "rishum she'ot nehiga",
            original = "רִשּׁוּם שְׁעוֹת נְהִיגָה", translation = "учёт часов за рулём",
            definition = "תִּעוּד מְדֻיָּק שֶׁל זְמַן עֲבוֹדָה וּזְמַן מְנוּחָה לְכָל יוֹם.",
            definitionNative = "Точная фиксация рабочих и отдыхающих часов по каждому дню.",
            example = "רִשּׁוּם שְׁעוֹת נְהִיגָה נִשְׁמָר בַּמָּחְשֵׁב עֶשְׂרִים וּשְׁמוֹנֶה יָמִים.",
            exampleNative = "רִשּׁוּם שְׁעוֹת נְהִיגָה хранится в системе двадцать восемь дней.",
         fillInBlankExclusions = listOf(171506L, 171507L, 171508L, 171510L)),
        WordEntity(
            id = 171510, setId = 1715, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "driver_documents_pro", transliteration = "te'udat ADR",
            original = "תְּעוּדַת ADR", translation = "сертификат ADR (опасные грузы)",
            definition = "אִישׁוּר מְיֻחָד לְהוֹבָלַת חֳמָרִים מְסֻכָּנִים כְּגוֹן דֶּלֶק אוֹ חוּמְצָה.",
            definitionNative = "Особое свидетельство для перевозки топлива, кислот и подобных веществ.",
            example = "בְּלִי תְּעוּדַת ADR אָסוּר לְהוֹבִיל חֳמָרִים מְסֻכָּנִים.",
            exampleNative = "Без תְּעוּדַת ADR опасные вещества везти запрещено.",
         fillInBlankExclusions = listOf(171506L, 171507L, 171508L, 171509L)),

        // ── driver_special_cargo (5) — специальные грузы ──
        WordEntity(
            id = 171511, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_special_cargo", transliteration = "mash'it mekureret",
            original = "מַשְׁאִית מְקֻרֶּרֶת", translation = "рефрижератор (фургон)",
            definition = "רֶכֶב הוֹבָלָה עִם תָּא קֵרוּר לְמוּצָרִים שֶׁמִּתְקַלְקְלִים בַּחֹם.",
            definitionNative = "Грузовик с холодным отсеком для скоропортящихся продуктов.",
            example = "מַשְׁאִית מְקֻרֶּרֶת הֵבִיאָה גְּלִידָה לַחֲנוּת.",
            exampleNative = "מַשְׁאִית מְקֻרֶּרֶת привезла мороженое в магазин.",
         fillInBlankExclusions = listOf(171512L, 171513L, 171514L, 171515L)),
        WordEntity(
            id = 171512, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_special_cargo", transliteration = "masa khai",
            original = "מַשָּׂא חַי", translation = "живой груз (скот, птица)",
            definition = "בַּעֲלֵי חַיִּים שֶׁמּוֹבִילִים בִּכְלִי רֶכֶב מְיֻחָד וּמְאֻוְרָר.",
            definitionNative = "Животных, что везут на специально приспособленном проветриваемом транспорте.",
            example = "הוֹבָלַת מַשָּׂא חַי דּוֹרֶשֶׁת חֲנִיּוֹת קְצָרוֹת לְמַיִם.",
            exampleNative = "מַשָּׂא חַי требует коротких остановок для воды.",
         fillInBlankExclusions = listOf(171511L, 171513L, 171514L, 171515L)),
        WordEntity(
            id = 171513, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_special_cargo", transliteration = "pikuakh mishkal",
            original = "פִּקּוּחַ מִשְׁקָל", translation = "весовой контроль",
            definition = "בְּדִיקָה בַּדֶּרֶךְ שֶׁל מִשְׁקָל הַמַּשָּׂא לְמְנֹעַ עֲמִיסַת יֶתֶר.",
            definitionNative = "Проверка на дороге, не превышен ли допустимый вес груза.",
            example = "בְּתַחֲנַת פִּקּוּחַ מִשְׁקָל עָצְרוּ אוֹתָנוּ לִבְדִיקָה.",
            exampleNative = "На посту פִּקּוּחַ מִשְׁקָל нас остановили для проверки.",
         fillInBlankExclusions = listOf(171511L, 171512L, 171514L, 171515L)),
        WordEntity(
            id = 171514, setId = 1715, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "driver_special_cargo", transliteration = "masa yekar erekh",
            original = "מַשָּׂא יְקַר עֵרֶךְ", translation = "ценный груз",
            definition = "מִטְעָן יָקָר מְאוֹד שֶׁדּוֹרֵשׁ לִוּוּי מְיֻחָד וּבִטָּחוֹן מוּגְבָּר.",
            definitionNative = "Дорогой товар, который сопровождают охрана и усиленная безопасность.",
            example = "מַשָּׂא יְקַר עֵרֶךְ נוֹסַע תָּמִיד עִם שְׁנֵי נְהָגִים.",
            exampleNative = "מַשָּׂא יְקַר עֵרֶךְ всегда едет с двумя водителями.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 171515, setId = 1715, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "driver_special_cargo", transliteration = "mit'an bilti shagir",
            original = "מַטְעָן בִּלְתִּי שָׁגִיר", translation = "нестандартный груз",
            definition = "מִטְעָן שֶׁאֵינוֹ נִכְנָס בִּגְדָלִים רְגִילִים — אָרֹךְ, גָּבוֹהַּ אוֹ כָּבֵד מְאוֹד.",
            definitionNative = "Груз, не вписывающийся в типовые габариты по длине, высоте или весу.",
            example = "מַטְעָן בִּלְתִּי שָׁגִיר נוֹסַע רַק בַּלַּיְלָה עִם לִוּוּי.",
            exampleNative = "מַטְעָן בִּלְתִּי שָׁגִיר ездит только ночью с сопровождением.",
         fillInBlankExclusions = listOf(171511L, 171512L, 171513L, 171514L)),

        // ── driver_special_vehicle (5) — спецтехника, составы ──
        WordEntity(
            id = 171516, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_special_vehicle", transliteration = "rekhev tseruf",
            original = "רֶכֶב צֵרוּף", translation = "автопоезд, седельный тягач",
            definition = "מַשְׁאִית עִם נִגְרֶרֶת אֲרֻכָּה הַמְחַבֶּרֶת אֵלֶיהָ בְּצַוָּאר.",
            definitionNative = "Тягач с длинным прицепом, соединённым через седельное устройство.",
            example = "רֶכֶב צֵרוּף תּוֹפֵס שְׁתֵּי מְכוֹנִיּוֹת בִּמְקוֹם חֲנָיָה.",
            exampleNative = "רֶכֶב צֵרוּף занимает в плане парковки две машины.",
         fillInBlankExclusions = listOf(171511L, 171517L, 171518L, 171519L, 171520L)),
        WordEntity(
            id = 171517, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_special_vehicle", transliteration = "manof al masa'it",
            original = "מָנוֹף עַל מַשָּׂאִית", translation = "манипулятор-кран на грузовике",
            definition = "זְרוֹעַ הִידְרָאוּלִית מֻרְכֶּבֶת עַל הָרֶכֶב לְהַעֲמָסָה וּפְרִיקָה עַצְמִית.",
            definitionNative = "Гидравлическая стрела на машине для самопогрузки и разгрузки.",
            example = "מָנוֹף עַל מַשָּׂאִית הוֹרִיד אֶת הַתֵּבוֹת מִבְּלִי לְהַזְעִיק טַרְקְטוֹר.",
            exampleNative = "מָנוֹף עַל מַשָּׂאִית снял ящики без помощи погрузчика.",
         fillInBlankExclusions = listOf(171516L, 171518L, 171519L, 171520L)),
        WordEntity(
            id = 171518, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_special_vehicle", transliteration = "asfalt-ma'aravel",
            original = "אַסְפַלְט-מַעֲרָבֵל", translation = "автобетоносмеситель, миксер",
            definition = "מַשְׁאִית עִם תֹּף סוֹבֵב הַמְעַרְבֵּל בֶּטוֹן בַּדֶּרֶךְ לָאֲתָר.",
            definitionNative = "Машина с вращающимся барабаном, перемешивающим бетон в пути.",
            example = "אַסְפַלְט-מַעֲרָבֵל הִגִּיעַ לָאֲתָר בְּדִיּוּק לְפִי הַזְּמַן.",
            exampleNative = "אַסְפַלְט-מַעֲרָבֵל подъехал на стройку точно по графику.",
         fillInBlankExclusions = listOf(171516L, 171517L, 171519L, 171520L)),
        WordEntity(
            id = 171519, setId = 1715, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "driver_special_vehicle", transliteration = "mash'it tender",
            original = "מַשְׁאִית טֶנְדֶּר", translation = "самосвал",
            definition = "רֶכֶב כָּבֵד עִם אַרְגָּז שֶׁמִּתְהַפֵּךְ לְפַנּוֹת חֹמֶר בְּבַת אַחַת.",
            definitionNative = "Тяжёлая машина с откидным кузовом для разом высыпать сыпучее.",
            example = "מַשְׁאִית טֶנְדֶּר פִּזְּרָה חָצָץ עַל הַכְּבִישׁ הֶחָדָשׁ.",
            exampleNative = "מַשְׁאִית טֶנְדֶּר высыпала щебень на новый участок шоссе.",
         fillInBlankExclusions = listOf(171516L, 171517L, 171518L, 171520L)),
        WordEntity(
            id = 171520, setId = 1715, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "driver_special_vehicle", transliteration = "manof hidrauli",
            original = "מָנוֹף הִידְרָאוּלִי", translation = "гидравлический подъёмник",
            definition = "מַעֲרֶכֶת הֲרָמָה הַפּוֹעֶלֶת בְּלַחַץ שֶׁמֶן וּמְרִימָה מַשָּׂא כָּבֵד.",
            definitionNative = "Подъёмное устройство на масляном давлении, поднимающее тяжёлый груз.",
            example = "מָנוֹף הִידְרָאוּלִי הֵרִים שָׁלֹשׁ טוֹנּוֹת בְּלִי קֹשִׁי.",
            exampleNative = "מָנוֹף הִידְרָאוּלִי поднял три тонны без напряжения.",
         fillInBlankExclusions = listOf(171516L, 171517L, 171518L, 171519L)),

        // ── driver_legal_pro (5) — юридические тонкости профессии ──
        WordEntity(
            id = 171521, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_legal_pro", transliteration = "akhrayut ezrakhit miktsoit",
            original = "אַחְרָיוּת אֶזְרָחִית מִקְצוֹעִית", translation = "профессиональная гражданская ответственность",
            definition = "חוֹבָה לְפַצּוֹת לָקוֹחַ עַל נֶזֶק שֶׁנִּגְרַם בִּמְהֲלַךְ הָעֲבוֹדָה.",
            definitionNative = "Обязанность возместить заказчику ущерб, нанесённый при работе.",
            example = "אַחְרָיוּת אֶזְרָחִית מִקְצוֹעִית מְכֻסָּה בְּפוֹלִיסָה נִפְרֶדֶת.",
            exampleNative = "אַחְרָיוּת אֶזְרָחִית מִקְצוֹעִית покрывается отдельным полисом.",
         fillInBlankExclusions = listOf(171522L, 171523L, 171524L, 171525L)),
        WordEntity(
            id = 171522, setId = 1715, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "driver_legal_pro", transliteration = "shlilat rishyon",
            original = "שְׁלִילַת רִשְׁיוֹן", translation = "лишение прав",
            definition = "סַנְקְצְיָה שִׁפּוּטִית הַמּוֹנַעַת מֵאָדָם לִנְהֹג זְמַן מָה.",
            definitionNative = "Судебная мера, временно запрещающая человеку садиться за руль.",
            example = "שְׁלִילַת רִשְׁיוֹן לַחֲצִי שָׁנָה הִכְבִּידָה עַל פַּרְנָסָתוֹ.",
            exampleNative = "שְׁלִילַת רִשְׁיוֹן на полгода ударила по его заработку.",
         fillInBlankExclusions = listOf(171521L, 171523L, 171524L, 171525L)),
        WordEntity(
            id = 171523, setId = 1715, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "driver_legal_pro", transliteration = "bokhen nehiga",
            original = "בּוֹחֵן נְהִיגָה", translation = "экзаменатор по вождению",
            definition = "פָּקִיד מֻסְמָךְ הַמַּעֲרִיךְ אֶת הַנֶּהָג בְּמִבְחָן הַמַּעֲשִׂי בַּכְּבִישׁ.",
            definitionNative = "Уполномоченный сотрудник, оценивающий ученика на практическом экзамене.",
            example = "הַבּוֹחֵן נְהִיגָה רָשַׁם הֶעָרוֹת עַל כָּל פְּנִיָּה.",
            exampleNative = "בּוֹחֵן נְהִיגָה делал пометки на каждом повороте.",
         fillInBlankExclusions = listOf(171521L, 171522L, 171524L, 171525L)),
        WordEntity(
            id = 171524, setId = 1715, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "driver_legal_pro", transliteration = "kefel bituakh",
            original = "כְּפֶל בִּטּוּחַ", translation = "двойное страхование",
            definition = "מַצָּב שֶׁשְּׁתֵּי פּוֹלִיסוֹת מְכַסּוֹת אוֹתוֹ סִכּוּן עַל אוֹתוֹ הָרֶכֶב.",
            definitionNative = "Когда два полиса покрывают один и тот же риск на одну машину.",
            example = "כְּפֶל בִּטּוּחַ מַסְבִּיךְ אֶת הַתְּבִיעָה אַחֲרֵי הַתְּאוּנָה.",
            exampleNative = "כְּפֶל בִּטּוּחַ усложняет выплату после ДТП.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 171525, setId = 1715, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "driver_legal_pro", transliteration = "khoze ha'asaka",
            original = "חוֹזֶה הַעֲסָקָה", translation = "трудовой контракт водителя",
            definition = "מִסְמָךְ הַקּוֹבֵעַ שָׂכָר, שָׁעוֹת וּזְכֻיּוֹת בֵּין הַנֶּהָג לַחֶבְרָה.",
            definitionNative = "Документ о зарплате, часах и правах между водителем и компанией.",
            example = "חוֹזֶה הַעֲסָקָה נֶחְתַּם רַק אַחֲרֵי שְׁלֹשָׁה חֳדָשֵׁי נִסָּיוֹן.",
            exampleNative = "חוֹזֶה הַעֲסָקָה подписали лишь после трёх месяцев испытательного срока.",
         fillInBlankExclusions = listOf(171521L, 171522L, 171523L, 171524L)),
    )
}
