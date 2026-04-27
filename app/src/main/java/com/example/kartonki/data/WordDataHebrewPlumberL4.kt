package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Сантехника и работа сантехником, level 4 (1 set, 25 words).
 *
 * Set 1800 (level 4, EPIC + LEGENDARY) — профессиональный сантехник:
 * гидравлика, диагностика, новые материалы, отопление, водоподготовка.
 *
 * Тема «Сантехника и работа сантехником» продолжает 1742-1744 (L1-L3).
 * Слова с L1-L3 не пересекаются (cross-проверено grep'ом). Однокоренные
 * с L1-L3 (אֶטֶם / דֶּבֶק / מַשְׁאֵבָה / דּוּד / סִילִיקוֹן) допустимы между
 * разными наборами одной темы — правило про однокоренные применяется
 * только внутри одного набора.
 *
 * Распределение редкостей:
 *   1800: 13 EPIC + 12 LEGENDARY
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewPlumberL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1800, languagePair = "he-ru", orderIndex = 1800,
            name = "Сантехника и работа сантехником",
            description = "Профессиональный сантехник: гидравлика, диагностика, новые материалы, отопление",
            topic = "Сантехника и работа сантехником", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1800 — Сантехника: профессиональный (EPIC + LEGENDARY, C1-C2)
        // 5 групп × 5 слов: plumber_hydraulics, plumber_diagnostics,
        //                   plumber_materials, plumber_heating,
        //                   plumber_water_treatment
        // 13 EPIC + 12 LEGENDARY (2 смежных уровня)
        // ══════════════════════════════════════════════════════════════════════

        // ── plumber_hydraulics (5) — гидравлика и поведение потока ──
        WordEntity(
            id = 180001, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_hydraulics", transliteration = "lakhats hidrostati",
            original = "לַחַץ הִידְרוֹסְטָטִי", translation = "гидростатическое давление",
            definition = "כֹּחַ שֶׁמַּפְעִיל נוֹזֵל בְּמַצָּב מְנוּחָה עַל דָּפְנוֹת הַמֵּיכַל אוֹ הַצִּנּוֹר.",
            definitionNative = "Сила, с которой жидкость в покое давит на стенки сосуда или трубы.",
            example = "לַחַץ הִידְרוֹסְטָטִי גָּדֵל עִם הָעֹמֶק שֶׁל הַמֵּיכַל.",
            exampleNative = "לַחַץ הִידְרוֹסְטָטִי растёт с увеличением глубины ёмкости.",
         fillInBlankExclusions = listOf(180003L, 180004L, 180005L)),
        WordEntity(
            id = 180002, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "plumber_hydraulics", transliteration = "sfika",
            original = "סְפִיקָה", translation = "расход (объём воды в единицу времени)",
            definition = "כַּמּוּת נוֹזֵל הָעוֹבֶרֶת דֶּרֶךְ צִנּוֹר בִּזְמַן נָתוּן, לְמָשָׁל לִיטְרִים בְּדַקָּה.",
            definitionNative = "Объём жидкости через трубу за время, например литры в минуту.",
            example = "הַסְּפִיקָה יָרְדָה בִּגְלַל שִׁכְבַת מִשְׁקָע פְּנִימִית.",
            exampleNative = "סְפִיקָה упала из-за слоя отложений внутри.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180003, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_hydraulics", transliteration = "makat lakhats",
            original = "מַכַּת לַחַץ", translation = "гидроудар",
            definition = "גַּל פִּתְאוֹמִי שֶׁל לַחַץ הַנּוֹצָר כְּשֶׁעוֹצְרִים זְרִימָה מְהִירָה בְּבַת אַחַת.",
            definitionNative = "Резкая волна давления, возникающая при внезапной остановке быстрого потока.",
            example = "מַכַּת לַחַץ פִּצְּחָה אֶת הַחִבּוּר הַחַלָּשׁ בַּקִּיר.",
            exampleNative = "מַכַּת לַחַץ разорвала слабое соединение внутри стены.",
         fillInBlankExclusions = listOf(180001L, 180004L, 180005L)),
        WordEntity(
            id = 180004, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_hydraulics", transliteration = "ibud omek",
            original = "אִבּוּד עֹמֶק", translation = "потеря напора",
            definition = "יְרִידָה בְּלַחַץ לְאֹרֶךְ הַמַּעֲרֶכֶת בִּגְלַל חִכּוּךְ אוֹ פִּתּוּלִים שֶׁל הַצִּנּוֹר.",
            definitionNative = "Снижение давления вдоль системы из-за трения или изгибов трубы.",
            example = "אִבּוּד עֹמֶק גָּדוֹל מַשְׁאִיר אֶת הַקּוֹמָה הָעֶלְיוֹנָה בְּלִי לַחַץ.",
            exampleNative = "Большой אִבּוּד עֹמֶק оставляет верхний этаж без напора.",
         fillInBlankExclusions = listOf(180001L, 180003L, 180005L)),
        WordEntity(
            id = 180005, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_hydraulics", transliteration = "shastom bitakhon",
            original = "שַׁסְתּוֹם בִּטְחוֹן", translation = "предохранительный клапан",
            definition = "שַׁסְתּוֹם הַנִּפְתָּח לְבַד כְּשֶׁהַלַּחַץ עוֹלֶה מֵעַל לַסַּף הַבָּטוּחַ.",
            definitionNative = "Клапан, открывающийся сам, когда давление превышает безопасный порог.",
            example = "שַׁסְתּוֹם בִּטְחוֹן הִצִּיל אֶת הַדּוּד מֵהִתְפּוֹצְצוּת.",
            exampleNative = "שַׁסְתּוֹם בִּטְחוֹן спас бойлер от разрыва.",
         fillInBlankExclusions = listOf(180001L, 180003L, 180004L, 180007L)),

        // ── plumber_diagnostics (5) — приборы и методы диагностики ──
        WordEntity(
            id = 180006, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_diagnostics", transliteration = "matsleima termit",
            original = "מַצְלֵמָה תֶּרְמִית", translation = "тепловизор",
            definition = "מַצְלֵמָה הַמַּצִּיגָה הֶבְדֵּלֵי חֹם בְּצֶבַע וּמְגַלָּה אֵזוֹר רָטוּב מֵאֲחוֹרֵי קִיר.",
            definitionNative = "Камера, показывающая разницу температур цветом и видящая сырость за стеной.",
            example = "מַצְלֵמָה תֶּרְמִית גִּלְּתָה דֶּלֶף נִסְתָּר בַּקִּיר.",
            exampleNative = "מַצְלֵמָה תֶּרְמִית нашла скрытую утечку в стене.",
         fillInBlankExclusions = listOf(180007L, 180008L, 180009L, 180010L)),
        WordEntity(
            id = 180007, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_diagnostics", transliteration = "mad lakhats",
            original = "מַד לַחַץ", translation = "манометр",
            definition = "מַכְשִׁיר עִם מָחוֹג הַמּוֹדֵד אֶת עָצְמַת הַלַּחַץ בְּתוֹךְ הַמַּעֲרֶכֶת.",
            definitionNative = "Прибор со стрелкой, измеряющий силу давления внутри системы.",
            example = "הַמַּד לַחַץ מַרְאֶה שִׁשָּׁה בָּאר בְּקַו הַחַם.",
            exampleNative = "מַד לַחַץ показывает шесть бар на горячей линии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180008, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_diagnostics", transliteration = "du\"akh tekhni",
            original = "דּוּ\"ח טֶכְנִי", translation = "технический отчёт",
            definition = "מִסְמָךְ כָּתוּב הַמְסַכֵּם מִמְצָאִים עִם תְּמוּנוֹת וְהַמְלָצוֹת.",
            definitionNative = "Письменный документ с выводами проверки, снимками и рекомендациями.",
            example = "דּוּ\"ח טֶכְנִי מְפֹרָט נִשְׁלַח לַלָּקוֹחַ לְמָחֳרָת הַבִּקּוּר.",
            exampleNative = "Подробный דּוּ\"ח טֶכְנִי отправили клиенту на следующий день.",
         fillInBlankExclusions = listOf(180006L, 180007L, 180009L, 180010L)),
        WordEntity(
            id = 180009, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_diagnostics", transliteration = "itur delef",
            original = "אִתּוּר דֶּלֶף", translation = "локализация утечки",
            definition = "פְּעֻלָּה לִמְצֹא אֶת הַמָּקוֹם הַמְדֻיָּק שֶׁבּוֹ מַיִם בּוֹרְחִים הַחוּצָה.",
            definitionNative = "Поиск точного места, откуда вода уходит наружу из системы.",
            example = "אִתּוּר דֶּלֶף עִם גַּז מְכֻוָּן לוֹקֵחַ פַּחוֹת מִשָּׁעָה.",
            exampleNative = "אִתּוּר דֶּלֶף направленным газом занимает меньше часа.",
         fillInBlankExclusions = listOf(180006L, 180007L, 180008L, 180010L)),
        WordEntity(
            id = 180010, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_diagnostics", transliteration = "bdika akustit",
            original = "בְּדִיקָה אַקוּסְטִית", translation = "акустическая диагностика",
            definition = "שִׁטָּה לְזִהוּי דֶּלֶף לְפִי רַעַשׁ זְרִימָה דֶּרֶךְ מִיקְרוֹפוֹן רָגִישׁ.",
            definitionNative = "Метод выявления утечки по шуму потока через чувствительный микрофон.",
            example = "בְּדִיקָה אַקוּסְטִית אִתְּרָה דֶּלֶף תַּחַת הָרִצְפָּה.",
            exampleNative = "בְּדִיקָה אַקוּסְטִית нашла утечку прямо под полом.",
         fillInBlankExclusions = listOf(180006L, 180007L, 180008L, 180009L)),

        // ── plumber_materials (5) — современные материалы и герметики ──
        WordEntity(
            id = 180011, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_materials", transliteration = "tsinor PEX",
            original = "צִנּוֹר פִּי-אֶקְס", translation = "труба PEX (сшитый полиэтилен)",
            definition = "צִנּוֹר פְּלַסְטִי גָּמִישׁ הָעוֹמֵד בְּמַיִם חַמִּים וּבְלַחַץ גָּבוֹהַּ.",
            definitionNative = "Гибкая пластиковая труба для горячей воды и высокого давления.",
            example = "צִנּוֹר פִּי-אֶקְס מַחְלִיף נְחֹשֶׁת בְּהִתְקָנָה חֲדָשָׁה.",
            exampleNative = "צִנּוֹר פִּי-אֶקְס заменяет медь на новых установках.",
         fillInBlankExclusions = listOf(180012L, 180013L, 180014L, 180015L)),
        WordEntity(
            id = 180012, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_materials", transliteration = "zavit plada",
            original = "זָוִית פְּלָדָה", translation = "стальной угольник (90°)",
            definition = "חֵלֶק קָצָר בְּצוּרַת זָוִית יְשָׁרָה הַמְּחַבֵּר שְׁנֵי צִנּוֹרוֹת בְּפִנָּה שֶׁל קִיר.",
            definitionNative = "Короткая деталь в форме прямого угла, соединяющая две трубы в углу стены.",
            example = "זָוִית פְּלָדָה הִתְקַנּוּ אַחֲרֵי הַשַּׁסְתּוֹם הָרָאשִׁי.",
            exampleNative = "זָוִית פְּלָדָה поставили сразу после главного клапана.",
         fillInBlankExclusions = listOf(180005L, 180007L, 180011L, 180013L, 180014L, 180015L)),
        WordEntity(
            id = 180013, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_materials", transliteration = "makhsanit keramit",
            original = "מַחֲסָנִית קֶרָמִית", translation = "керамический картридж (для смесителя)",
            definition = "חֵלֶק פְּנִימִי בְּתוֹךְ בֶּרֶז הָאַחְרָאִי לְעִרְבּוּב מַיִם וְקֵל לְהַחְלָפָה.",
            definitionNative = "Внутренняя деталь крана, отвечающая за смешивание воды и легко заменяемая.",
            example = "הַמַּחֲסָנִית הַקֶּרָמִית הִתְבַּלְּתָה אַחֲרֵי שֶׁבַע שָׁנִים.",
            exampleNative = "מַחֲסָנִית קֶרָמִית изношена после семи лет работы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180014, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_materials", transliteration = "etem silikon",
            original = "אֶטֶם סִילִיקוֹן", translation = "силиконовое уплотнение",
            definition = "טַבַּעַת רַכָּה הַחוֹסֶמֶת מַעֲבָר מַיִם בֵּין שְׁנֵי חֲלָקִים מְחֻבָּרִים.",
            definitionNative = "Мягкое кольцо, перекрывающее проход воды между двумя соединёнными частями.",
            example = "אֶטֶם סִילִיקוֹן יַחֲזִיק יוֹתֵר זְמַן מֵאֶטֶם גּוּמִי רָגִיל.",
            exampleNative = "אֶטֶם סִילִיקוֹן прослужит дольше обычной резиновой прокладки.",
         fillInBlankExclusions = listOf(180011L, 180012L, 180013L, 180015L)),
        WordEntity(
            id = 180015, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_materials", transliteration = "devek epoxi",
            original = "דֶּבֶק אֶפּוֹקְסִי", translation = "эпоксидный клей",
            definition = "חֹמֶר דּוּ-רְכִיבִי הַמַּדְבִּיק מַתֶּכֶת אוֹ פְּלַסְטִיק וְעוֹמֵד בְּמַיִם חַמִּים.",
            definitionNative = "Двухкомпонентный состав, склеивающий металл или пластик и не боящийся горячей воды.",
            example = "דֶּבֶק אֶפּוֹקְסִי סָתַם נֶקֶב קָטָן בָּאַסְלָה.",
            exampleNative = "דֶּבֶק אֶפּוֹקְסִי заделал маленькую дырку в унитазе.",
         fillInBlankExclusions = listOf(180011L, 180012L, 180013L, 180014L)),

        // ── plumber_heating (5) — отопление: компоненты профессионального уровня ──
        WordEntity(
            id = 180016, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_heating", transliteration = "nozel haavarat khom",
            original = "נוֹזֵל הַעֲבָרַת חֹם", translation = "теплоноситель",
            definition = "נוֹזֵל מְיֻחָד הַזּוֹרֵם בַּמַּעֲרֶכֶת וּמַעֲבִיר חֹם מִמְּקוֹם לִמְקוֹם.",
            definitionNative = "Жидкость в системе, переносящая тепло от источника к нагревателю.",
            example = "נוֹזֵל הַעֲבָרַת חֹם בְּגִילְיקוֹל מוֹנֵעַ הִקַּפְאוּת בַּחֹרֶף.",
            exampleNative = "נוֹזֵל הַעֲבָרַת חֹם на гликоле не даёт замёрзнуть зимой.",
         fillInBlankExclusions = listOf(180017L, 180018L, 180019L, 180020L)),
        WordEntity(
            id = 180017, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_heating", transliteration = "dud akif",
            original = "דּוּד עֲקִיף", translation = "бойлер косвенного нагрева",
            definition = "מֵיכַל הַמִּתְחַמֵּם דֶּרֶךְ סְלִיל פְּנִימִי מִמַּעֲרֶכֶת חִמּוּם נִפְרֶדֶת.",
            definitionNative = "Бак воды, нагреваемый через внутренний змеевик от отдельного контура.",
            example = "דּוּד עֲקִיף עוֹבֵד עִם מַעֲרֶכֶת הַשֶּׁמֶשׁ וְעִם הַגַּז.",
            exampleNative = "דּוּד עֲקִיף работает и от солнечной системы, и от газа.",
         fillInBlankExclusions = listOf(180016L, 180018L, 180019L, 180020L)),
        WordEntity(
            id = 180018, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_heating", transliteration = "rosh termostati",
            original = "רֹאשׁ תֶּרְמוֹסְטָטִי", translation = "термостатическая голова (на радиатор)",
            definition = "כַּפְתּוֹר חָכָם עַל רַדְיָאטוֹר הַמְּכַוֵּן זְרִימָה לְפִי חֹם רָצוּי בַּחֶדֶר.",
            definitionNative = "Умная ручка на радиаторе, регулирующая поток по нужной температуре.",
            example = "רֹאשׁ תֶּרְמוֹסְטָטִי שָׁמַר עַל עֶשְׂרִים מַעֲלוֹת לְכָל הַלַּיְלָה.",
            exampleNative = "רֹאשׁ תֶּרְמוֹסְטָטִי держал двадцать градусов всю ночь.",
         fillInBlankExclusions = listOf(180016L, 180017L, 180019L, 180020L)),
        WordEntity(
            id = 180019, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_heating", transliteration = "radiator aluminyum",
            original = "רַדְיָאטוֹר אַלוּמִינְיוּם", translation = "алюминиевый радиатор",
            definition = "גּוּף חִמּוּם קַל מִמַּתֶּכֶת זוֹלָה הַמַּעֲבִיר חֹם מַהֵר אֶל הָאֲוִיר בַּחֶדֶר.",
            definitionNative = "Лёгкий нагревательный прибор из дешёвого металла, быстро отдающий тепло воздуху в комнате.",
            example = "רַדְיָאטוֹר אַלוּמִינְיוּם מִתְחַמֵּם בְּעֶשֶׂר דַּקּוֹת בִּלְבַד.",
            exampleNative = "רַדְיָאטוֹר אַלוּמִינְיוּם прогревается всего за десять минут.",
         fillInBlankExclusions = listOf(180016L, 180017L, 180018L, 180020L)),
        WordEntity(
            id = 180020, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_heating", transliteration = "mash'evat khom",
            original = "מַשְׁאֵבַת חֹם", translation = "тепловой насос",
            definition = "מַתְקָן הַמּוֹצִיא חֹם מִן הָאֲוִיר אוֹ הָאֲדָמָה וּמַזִּין בּוֹ אֶת הַבַּיִת.",
            definitionNative = "Установка, забирающая тепло из воздуха или земли и питающая им дом.",
            example = "מַשְׁאֵבַת חֹם חוֹסֶכֶת חֲצִי מֵחֶשְׁבּוֹן הַחַשְׁמַל בַּחֹרֶף.",
            exampleNative = "מַשְׁאֵבַת חֹם экономит половину счёта за электричество зимой.",
         fillInBlankExclusions = listOf(180016L, 180017L, 180018L, 180019L)),

        // ── plumber_water_treatment (5) — водоподготовка и фильтрация ──
        WordEntity(
            id = 180021, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_water_treatment", transliteration = "osmoza hafukha",
            original = "אוֹסְמוֹזָה הֲפוּכָה", translation = "обратный осмос",
            definition = "שִׁטַּת סִנּוּן הַדּוֹחֶפֶת מַיִם דֶּרֶךְ קְרוּם דַּקִּיק וּמַשְׁאִירָה רַק מוֹלֶקוּלוֹת.",
            definitionNative = "Метод фильтрации: вода продавливается через мембрану, остаются чистые молекулы.",
            example = "אוֹסְמוֹזָה הֲפוּכָה הוֹצִיאָה אֲפִלּוּ אֶת הַמֶּלַח מֵהַמַּיִם.",
            exampleNative = "אוֹסְמוֹזָה הֲפוּכָה убрала из воды даже соль.",
         fillInBlankExclusions = listOf(180022L, 180023L, 180024L, 180025L)),
        WordEntity(
            id = 180022, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_water_treatment", transliteration = "mesanen mayim",
            original = "מְסַנֵּן מַיִם", translation = "водяной фильтр",
            definition = "מַתְקָן עִם רֹאשׁ מַחֲלִיף הַסּוֹפֵג חוֹל וּכְלוֹר לִפְנֵי הַכְּנִיסָה לַבַּיִת.",
            definitionNative = "Устройство со сменным картриджем, улавливающее песок и хлор перед входом в дом.",
            example = "מְסַנֵּן מַיִם הִתְקַנּוּ עַל הַקַּו הָרָאשִׁי בַּחֲנִיָּה.",
            exampleNative = "מְסַנֵּן מַיִם поставили на главную линию в гараже.",
         fillInBlankExclusions = listOf(180005L, 180007L, 180021L, 180023L, 180024L, 180025L)),
        WordEntity(
            id = 180023, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_water_treatment", transliteration = "merakekh mayim",
            original = "מְרַכֵּךְ מַיִם", translation = "умягчитель воды",
            definition = "מַתְקָן הַמּוֹרִיד מִינֵרָלִים קָשִׁים וּמוֹנֵעַ מִשְׁקָע לָבָן בַּמַּעֲרֶכֶת.",
            definitionNative = "Установка, убирающая жёсткие минералы и не дающая копиться налёту.",
            example = "מְרַכֵּךְ מַיִם הֶאֱרִיךְ אֶת חַיֵּי הַדּוּד פִּי שְׁנַיִם.",
            exampleNative = "מְרַכֵּךְ מַיִם удлинил срок службы бойлера вдвое.",
         fillInBlankExclusions = listOf(180021L, 180022L, 180024L, 180025L)),
        WordEntity(
            id = 180024, setId = 1800, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_water_treatment", transliteration = "maagar mayim khamim",
            original = "מַאֲגַר מַיִם חַמִּים", translation = "накопитель горячей воды",
            definition = "מֵיכַל גָּדוֹל הַשּׁוֹמֵר עַל זְרִימָה חַמָּה מוּכָנָה לִשְׁעַת בִּקּוּשׁ.",
            definitionNative = "Большой бак с готовым запасом тепла на час пиковой нагрузки.",
            example = "מַאֲגַר מַיִם חַמִּים מַסְפִּיק לִשְׁלֹשָׁה אַמְבַּטְיוֹת בָּרֶצֶף.",
            exampleNative = "מַאֲגַר מַיִם חַמִּים хватает на три ванны подряд.",
         fillInBlankExclusions = listOf(180017L, 180021L, 180022L, 180023L, 180025L)),
        WordEntity(
            id = 180025, setId = 1800, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_water_treatment", transliteration = "maarekhet ultra-sinun",
            original = "מַעֲרֶכֶת אוּלְטְרָה-סִינּוּן", translation = "система ультрафильтрации",
            definition = "מִתְקָן עִם קְרוּם דַּקִּיק שֶׁעוֹצֵר חַיְדַּקִּים וְוִירוּסִים בְּלִי לְהוֹסִיף חֹמֶר.",
            definitionNative = "Устройство с тонкой мембраной, задерживающей бактерии и вирусы без добавления реагентов.",
            example = "מַעֲרֶכֶת אוּלְטְרָה-סִינּוּן מַתְאִימָה לְבַיִת בְּכַפָר רָחוֹק.",
            exampleNative = "מַעֲרֶכֶת אוּלְטְרָה-סִינּוּן подходит для дома в дальней деревне.",
         fillInBlankExclusions = listOf(180021L, 180022L, 180023L, 180024L)),
    )
}
