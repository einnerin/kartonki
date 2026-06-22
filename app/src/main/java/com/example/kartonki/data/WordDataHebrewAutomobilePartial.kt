package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Автомобиль (he-ru), 2 PARTIAL sets (levels 1 and 4).
 *
 * Set 1712 (level 1, 15 COMMON + 10 UNCOMMON):
 *   основы — части машины, базовая лексика водителя.
 *   6 групп: actions, signals, interior, exterior, climate, controls.
 *
 * Set 1713 (level 4, 10 EPIC + 15 LEGENDARY):
 *   профессиональный — диагностика, ремонт, специализированные узлы.
 *   5 групп: engine_internals, cooling, fuel_oil_exhaust, brakes_chassis, sensors_meters.
 *
 * Не пересекается со словами из существующих сетов темы «Автомобиль»:
 * 1178 (Immigrant12 — UNCOMMON), 1379 (Batch64 L2 — UNCOMMON+RARE),
 * 1380 (Batch65 L3 — RARE+EPIC), 1381 (Batch65 L5 — EPIC+LEGENDARY),
 * 1382 (Batch65 L5 — LEGENDARY).
 */
object WordDataHebrewAutomobilePartial {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1712, languagePair = "he-ru", orderIndex = 1712,
            name = "Гараж и работа автомехаником",
            description = "Управление машиной: салон, кузов, базовые приборы и сигналы",
            topic = "Гараж и работа автомехаником", level = 1,
        ),
        WordSetEntity(
            id = 1713, languagePair = "he-ru", orderIndex = 1713,
            name = "Гараж и работа автомехаником",
            description = "Диагностика, ремонт, узлы двигателя и тормозной системы",
            topic = "Гараж и работа автомехаником", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1712 — Автомобиль: основы (level=1, COMMON + UNCOMMON)
        // 6 групп: driving_actions, signals_alerts, interior_seats,
        //          body_exterior, climate, dashboard_controls
        // ══════════════════════════════════════════════════════════════════════

        // ── auto_driving_actions (5) — глаголы вождения ──
        WordEntity(
            id = 171201, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "auto_driving_actions",
            original = "לְתַדְלֵק", translation = "заправлять",
            definition = "לְמַלֵּא אֶת מִיכַל הָרֶכֶב בְּבֶּנְזִין אוֹ סולר בַּתַּחֲנָה.",
            definitionNative = "Залить горючее в бак на станции — обычно бензин или дизель.",
            example = "אֲנִי צָרִיךְ לְתַדְלֵק אֶת הָרֶכֶב לִפְנֵי הַנְּסִיעָה.",
            exampleNative = "Мне надо לְתַדְלֵק машину перед дальней поездкой.",
         fillInBlankExclusions = listOf(171202L, 171203L, 171204L, 171205L)),
        WordEntity(
            id = 171202, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "auto_driving_actions",
            original = "לִנְסֹעַ", translation = "ехать",
            definition = "לְהִתְקַדֵּם בִּכְלֵי תַּחְבּוּרָה מִמָּקוֹם אֶחָד לְמָקוֹם אַחֵר.",
            definitionNative = "Перемещаться на машине, поезде или автобусе от точки до точки.",
            example = "הֶחְלַטְנוּ לִנְסֹעַ לַיָּם בְּשַׁבָּת בבוקר.",
            exampleNative = "Мы решили לִנְסֹעַ к морю в субботу утром.",
        ),
        WordEntity(
            id = 171203, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "auto_driving_actions",
            original = "לְהָאֵט", translation = "замедляться",
            definition = "לְהַפְחִית מְהִירוּת לִפְנֵי סיבוב, אוֹֹר אדום אוֹ מִכְשׁוֹל בַּכְּבִישׁ.",
            definitionNative = "Уменьшать скорость — перед поворотом, светофором или препятствием.",
            example = "צָרִיךְ לְהָאֵט בַּכְּנִיסָה לַכְּפָר.",
            exampleNative = "Надо לְהָאֵט при въезде в деревню.",
         fillInBlankExclusions = listOf(171201L, 171202L, 171204L, 171205L)),
        WordEntity(
            id = 171204, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "auto_driving_actions",
            original = "לְהַחְנוֹת", translation = "парковать",
            definition = "לְהַעֲמִיד אֶת הָרֶכֶב בְּמָקוֹם מוגדר וְכָבוּי לִזְמַן מָה.",
            definitionNative = "Оставить машину в выделенном месте с заглушённым мотором.",
            example = "קָשֶׁה לְהַחְנוֹת ליד הַשּׁוּק בִּשְׁעוֹת העומס.",
            exampleNative = "Трудно לְהַחְנוֹת возле рынка в часы пик.",
         fillInBlankExclusions = listOf(171201L, 171202L, 171203L, 171205L)),
        WordEntity(
            id = 171205, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "auto_driving_actions",
            original = "לְעַקֵּף", translation = "обгонять",
            definition = "לעבור רֶכֶב אַחֵר מִשְּׂמֹאל ולחזור לִנְתִיב לְפָנָיו.",
            definitionNative = "Объехать переднюю машину слева и вернуться в свой ряд.",
            example = "אָסוּר לְעַקֵּף בְּקַו לָבָן רָצוּף.",
            exampleNative = "Запрещено לְעַקֵּף через сплошную белую линию.",
         fillInBlankExclusions = listOf(171201L, 171202L, 171203L, 171204L)),

        // ── auto_signals_alerts (4) — звуковые и световые сигналы ──
        WordEntity(
            id = 171206, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "auto_signals_alerts",
            original = "צוֹפָר", translation = "клаксон",
            definition = "הֶתְקֵן קוֹלָנִי שֶׁלּוֹחֲצִים עָלָיו כְּדֵי לְהַזְהִיר נַהָג אַחֵר.",
            definitionNative = "Громкое устройство на руле, которое подаёт предупреждающий звук.",
            example = "הוּא לָחַץ עַל הצוֹפָר בְּאַגְרֵסִיבִיּוּת.",
            exampleNative = "Он раздражённо ударил по צוֹפָר в пробке.",
        ),
        WordEntity(
            id = 171207, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "auto_signals_alerts",
            original = "אִתּוּת", translation = "поворотник",
            definition = "אוֹר צהוב מְהַבְהֵב הַמַּרְאֶה לְאֵיזֶה כיוון הַנַּהָג עוֹמֵד לִפְנוֹת.",
            definitionNative = "Мигающий жёлтый огонь, который показывает направление поворота.",
            example = "תָּמִיד צָרִיךְ אִתּוּת לִפְנֵי שינוי נתיב.",
            exampleNative = "Перед сменой полосы всегда нужен אִתּוּת.",
         fillInBlankExclusions = listOf(171206L, 171209L)),
        WordEntity(
            id = 171208, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_signals_alerts",
            original = "אַזְעָקַת רֶכֶב", translation = "автосигнализация",
            definition = "מַעֲרֶכֶת קוֹלָנִית שמופעלת כְּשֶׁמִּישֶׁהוּ מְנַסֶּה לפרוץ לַמְּכוֹנִית.",
            definitionNative = "Система, которая громко срабатывает при попытке вскрыть машину.",
            example = "אַזְעָקַת רֶכֶב צָרְחָה כָּל הַלַּיְלָה בָּרְחוֹב.",
            exampleNative = "אַזְעָקַת רֶכֶב орала во дворе всю ночь.",
         fillInBlankExclusions = listOf(171209L)),
        WordEntity(
            id = 171209, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "auto_signals_alerts",
            original = "סִירֶנָה", translation = "сирена",
            definition = "צְלִיל חָזָק וְחוֹזֵר שֶׁל רֶכֶב חירום הַקּוֹרֵא לִפְנוֹת מֵהַדֶּרֶךְ.",
            definitionNative = "Громкий повторяющийся вой машины спасателей или полиции.",
            example = "סִירֶנָה שֶׁל אַמְבּוּלַנְס שָׁמְעָה אֶת כָּל הרובע.",
            exampleNative = "סִירֶנָה скорой была слышна на весь квартал.",
         fillInBlankExclusions = listOf(171206L, 171207L)),

        // ── auto_interior_seats (4) — места и отсеки для людей ──
        WordEntity(
            id = 171210, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "auto_interior_seats",
            original = "מוֹשַׁב נֶהָג", translation = "водительское сиденье",
            definition = "הַמָּקוֹם שֶׁבּוֹ יוֹשֵׁב מִי שֶׁמּוֹבִיל אֶת הָרֶכֶב, מוּל הַהֶגֶה.",
            definitionNative = "Место за рулём, где сидит человек, ведущий машину.",
            example = "יְלָדִים אֲסוּרִים עַל מוֹשַׁב נֶהָג.",
            exampleNative = "Детям нельзя на מוֹשַׁב נֶהָג.",
         fillInBlankExclusions = listOf(171211L, 171212L, 171213L, 171215L)),
        WordEntity(
            id = 171211, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "auto_interior_seats",
            original = "מוֹשָׁב אֲחוֹרִי", translation = "заднее сиденье",
            definition = "סַפְסָל מֵאָחוֹר לְכַמָּה אֲנָשִׁים, מֵאָחוֹרי הכיסאות הַקִּדְמִיִּים.",
            definitionNative = "Скамья сзади, рассчитанная на нескольких пассажиров.",
            example = "הַיְּלָדִים נִרְדְּמוּ עַל מוֹשָׁב אֲחוֹרִי.",
            exampleNative = "Дети уснули на מוֹשָׁב אֲחוֹרִי по дороге домой.",
         fillInBlankExclusions = listOf(171210L, 171212L, 171213L)),
        WordEntity(
            id = 171212, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_interior_seats",
            original = "מוֹשַׁב יֶלֶד", translation = "детское автокресло",
            definition = "כיסא מיוחד עִם רְצוּעוֹת שֶׁמַּחְזִיק תִּינוֹק אוֹ פָּעוֹט בְּבִטְחָה.",
            definitionNative = "Кресло с ремнями, держащее малыша безопасно во время поездки.",
            example = "החוק מחייב מוֹשַׁב יֶלֶד עַד גִּיל שְׁמוֹנֶה.",
            exampleNative = "Закон требует מוֹשַׁב יֶלֶד до восьми лет.",
         fillInBlankExclusions = listOf(171210L, 171211L, 171213L)),
        WordEntity(
            id = 171213, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_interior_seats",
            original = "תָּא נֶהָג", translation = "кабина водителя",
            definition = "הֶחָלָל הַקִּדְמִי שֶׁל הָרֶכֶב שֶׁבּוֹ יוֹשֵׁב מִי שֶׁמּוֹבִיל אוֹתוֹ.",
            definitionNative = "Передний отсек, где находится тот, кто управляет машиной.",
            example = "הַמַּרְאָה הָרָאשִׁית תְּלוּיָה מֵעַל תָּא נֶהָג.",
            exampleNative = "Главное зеркало висит над תָּא נֶהָג.",
         fillInBlankExclusions = listOf(171210L, 171211L, 171212L)),

        // ── auto_body_exterior (5) — кузовные элементы снаружи ──
        WordEntity(
            id = 171214, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "auto_body_exterior",
            original = "מָגֵן רוּחַ", translation = "лобовое стекло",
            definition = "הַחַלּוֹן הַגָּדוֹל מִקָּדִימָה דַּרְכּוֹ הַנַּהָג רואה אֶת הַכְּבִישׁ.",
            definitionNative = "Большое переднее окно, через которое водитель смотрит на дорогу.",
            example = "אֶבֶן עָפָה וְנִסְדָּק מָגֵן רוּחַ.",
            exampleNative = "Камень ударил, и треснуло מָגֵן רוּחַ.",
        ),
        WordEntity(
            id = 171215, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "auto_body_exterior",
            original = "גַּגּוֹן", translation = "багажник на крыше",
            definition = "קופסה אוֹ מתלה מֵעַל הָרֶכֶב לְהוֹבָלַת מִטְעָן נוֹסָף.",
            definitionNative = "Короб или стойка сверху для груза, который не влез в салон.",
            example = "קָשַׁרְנוּ אֶת האופניים עַל הגַּגּוֹן.",
            exampleNative = "Велосипеды привязали наверх к גַּגּוֹן.",
        ),
        WordEntity(
            id = 171216, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "auto_body_exterior",
            original = "גַּלְגַּל חִילוּפִי", translation = "запасное колесо",
            definition = "צָמִיג נוֹסָף שֶׁנּוֹשְׂאִים בְּתוֹךְ הָרֶכֶב לְמִקְרֵה תֶּקֶר בַּדֶּרֶךְ.",
            definitionNative = "Дополнительная шина в багажнике на случай прокола в пути.",
            example = "תָּמִיד יֵשׁ גַּלְגַּל חִילוּפִי בְּתָא הַמִּטְעָן.",
            exampleNative = "В багажнике всегда лежит גַּלְגַּל חִילוּפִי на крайний случай.",
         fillInBlankExclusions = listOf(171214L, 171217L, 171218L)),
        WordEntity(
            id = 171217, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_body_exterior",
            original = "מָגֵן בּוֹץ", translation = "брызговик",
            definition = "לוּחַ גָּמִישׁ מֵאֲחוֹרֵי הַגַּלְגַּל שֶׁמּוֹנֵעַ הַתָּזַת רֶפֶשׁ עַל מְכוֹנִיּוֹת אֲחֵרוֹת.",
            definitionNative = "Гибкая пластина за колесом, не дающая грязи лететь на других.",
            example = "מָגֵן בּוֹץ נִשְׁבַּר אַחֲרֵי הַגֶּשֶׁם הַכָּבֵד.",
            exampleNative = "מָגֵן בּוֹץ оторвался после сильного дождя.",
         fillInBlankExclusions = listOf(171207L, 171214L, 171215L, 171216L, 171218L, 171219L, 171221L)),
        WordEntity(
            id = 171218, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_body_exterior",
            original = "מִכְסֵה מָנוֹעַ", translation = "капот",
            definition = "הַלּוּחַ שֶׁמְּכַסֶּה אֶת הַחֵלֶק הַקִּדְמִי שֶׁל הָרֶכֶב מֵעַל הַמָּנוֹעַ.",
            definitionNative = "Крышка спереди, под которой скрыт двигатель машины.",
            example = "הוּא פָּתַח אֶת מִכְסֵה מָנוֹעַ לבדוק אֶת הַשֶּׁמֶן.",
            exampleNative = "Он открыл מִכְסֵה מָנוֹעַ, чтобы проверить уровень масла.",
        ),

        // ── auto_climate (3) — климат и вентиляция ──
        WordEntity(
            id = 171219, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "auto_climate",
            original = "מַזְגָן", translation = "кондиционер",
            definition = "מַעֲרֶכֶת שֶׁמְּקָרֶרֶת אֶת האוויר בְּתוֹךְ הָרֶכֶב בַּקַּיִץ הַחַם.",
            definitionNative = "Прибор, охлаждающий воздух внутри машины жарким летом.",
            example = "המַזְגָן בָּרֶכֶב הִתְקַלְקֵל בְּאֶמְצַע אוֹגוּסְט.",
            exampleNative = "מַזְגָן в машине сломался прямо в середине августа.",
        ),
        WordEntity(
            id = 171220, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_climate",
            original = "פִּתְחֵי אֲוִיר", translation = "воздуховоды",
            definition = "החורים בַּלּוּחַ שֶׁמֵּהֶם יוֹצֵא אוֹויר קַר אוֹ חַם פְּנִימָה.",
            definitionNative = "Отверстия в панели, откуда дует тёплый или холодный поток.",
            example = "סוֹבַבְתִּי אֶת פִּתְחֵי אֲוִיר לכיוון הַפָּנִים.",
            exampleNative = "Я повернул פִּתְחֵי אֲוִיר прямо в лицо.",
        ),
        WordEntity(
            id = 171221, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "auto_climate",
            original = "אִוְרוּר", translation = "вентиляция",
            definition = "הַחְלָפַת אוֹויר בַּמְּכוֹנִית כְּדֵי שֶׁלֹּא יִהְיֶה מַחֲנָק אוֹ רֵיחַ.",
            definitionNative = "Обмен воздуха в салоне, чтобы не было душно или запахов.",
            example = "אִוְרוּר טוֹב מוֹנֵעַ עֲרָפֶל עַל הַשִּׁמְשָׁה.",
            exampleNative = "Хороший אִוְרוּר спасает от запотевания стёкол зимой.",
         fillInBlankExclusions = listOf(171219L)),

        // ── auto_dashboard_controls (4) — приборы и педали ──
        WordEntity(
            id = 171222, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "auto_dashboard_controls",
            original = "מַד מְהִירוּת", translation = "спидометр",
            definition = "הַשָּׁעוֹן שֶׁמַּרְאֶה לַנַּהָג כַּמָּה קִילוֹמֶטְרִים לְשָׁעָה הוּא נוֹסֵעַ.",
            definitionNative = "Прибор, показывающий, как быстро идёт машина в данный момент.",
            example = "מַד מְהִירוּת הֶרְאָה מֵאָה וְעֶשְׂרִים בִּכְבִישׁ הַחוֹף.",
            exampleNative = "מַד מְהִירוּת показал сто двадцать на приморской трассе.",
         fillInBlankExclusions = listOf(171223L, 171225L)),
        WordEntity(
            id = 171223, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_dashboard_controls",
            original = "מַד דֶּלֶק", translation = "указатель уровня топлива",
            definition = "הַסֵּמֶל בְּלוּחַ שֶׁמַּרְאֶה כַּמָּה בֶּנְזִין נִשְׁאַר בְּמִיכַל.",
            definitionNative = "Шкала на панели, показывающая остаток горючего в баке.",
            example = "מַד דֶּלֶק כְּבָר עַל שְׂרִיטָה אדומה.",
            exampleNative = "מַד דֶּלֶק уже стоит на красной риске.",
         fillInBlankExclusions = listOf(171222L, 171225L)),
        WordEntity(
            id = 171224, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "auto_dashboard_controls",
            original = "דַּוְשָׁה", translation = "педаль",
            definition = "כַּפְתּוֹר גָּדוֹל בָּרֶגֶל שֶׁלּוֹחֲצִים עָלָיו כְּדֵי לְהָאִיץ אוֹ לבלום.",
            definitionNative = "Большая ножная кнопка для разгона или остановки машины.",
            example = "הוּא לָחַץ עַל הדַּוְשָׁה עַד הָרִצְפָּה.",
            exampleNative = "Он вдавил דַּוְשָׁה в пол на пустом шоссе.",
        ),
        WordEntity(
            id = 171225, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_dashboard_controls",
            original = "בְּלֵם חֵרוּם", translation = "аварийный тормоз",
            definition = "יָדִית מיוחדת שֶׁמּוֹשְׁכִים בָּהּ כְּדֵי לעצור מִיָּד בְּמִקְרֶה שֶׁל סַכָּנָה.",
            definitionNative = "Рычаг или кнопка для немедленной остановки в опасной ситуации.",
            example = "הִיא מָשְׁכָה אֶת בְּלֵם חֵרוּם בָּרֶגַע הָאַחֲרוֹן.",
            exampleNative = "Она дёрнула בְּלֵם חֵרוּם в самый последний момент.",
         fillInBlankExclusions = listOf(171222L, 171223L)),

        // ══════════════════════════════════════════════════════════════════════
        // Set 1713 — Автомобиль: профессиональный (level=4, EPIC + LEGENDARY)
        // 5 групп: engine_internals, cooling_system, fuel_oil_exhaust,
        //          brakes_chassis, sensors_meters
        // ══════════════════════════════════════════════════════════════════════

        // ── auto_engine_internals (6) — внутренние узлы двигателя ──
        WordEntity(
            id = 171301, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_engine_internals",
            original = "אַטָם רֹאשׁ", translation = "прокладка ГБЦ",
            definition = "אָטַם דַּקִּיק בֵּין רֹאשׁ הציליינדרים לְגוּשׁ הַמָּנוֹעַ, מוֹנֵעַ דְּלִיפַת לַחַץ.",
            definitionNative = "Тонкий уплотнитель между головкой блока и его корпусом.",
            example = "אַטָם רֹאשׁ נִשְׂרַף בִּגְלַל הִתְחַמְּמוּת יֶתֶר.",
            exampleNative = "אַטָם רֹאשׁ прогорела из-за сильного перегрева.",
        ),
        WordEntity(
            id = 171302, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_engine_internals",
            original = "טַבַּעַת בּוֹכְנָה", translation = "поршневое кольцо",
            definition = "חישוק דַּק שֶׁמַּקִּיף אֶת הבוכנה וְשׁוֹמֵר עַל אֲטִימוּת בְּתוֹךְ הציליינדר.",
            definitionNative = "Узкий обруч на поршне, удерживающий герметичность внутри цилиндра.",
            example = "טַבַּעַת בּוֹכְנָה שְׁחוּקָה גּוֹרֶמֶת לְעַשֵּׁן כחול.",
            exampleNative = "Стёртое טַבַּעַת בּוֹכְנָה вызывает синий выхлоп.",
         fillInBlankExclusions = listOf(171301L, 171303L, 171304L, 171305L)),
        WordEntity(
            id = 171303, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_engine_internals",
            original = "גַּל פִּתִיחָה", translation = "распределительный вал",
            definition = "צִיר מִסְתּוֹבֵב שֶׁפּוֹתֵחַ וְסוֹגֵר אֶת הַשַּׁסְתּוֹמִים בַּזְּמַן הַנָּכוֹן.",
            definitionNative = "Вращающаяся ось, которая в нужный миг открывает клапаны.",
            example = "גַּל פִּתִיחָה מִפְּלַסְטִיק מִתְכַּלֶּה אַחֲרֵי מאתיים אֶלֶף.",
            exampleNative = "Пластиковый גַּל פִּתִיחָה изнашивается после двухсот тысяч.",
         fillInBlankExclusions = listOf(171301L, 171302L, 171304L, 171305L)),
        WordEntity(
            id = 171304, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_engine_internals",
            original = "תֻּמְכוֹת מְנוֹעַ", translation = "опоры двигателя",
            definition = "כָּרִיּוֹת גּוּמִי שֶׁמַּחְזִיקוֹת אֶת הַמָּנוֹעַ וּבוֹלְעוֹת רְעִידוֹת מֵהַדֶּרֶךְ.",
            definitionNative = "Резиновые подушки, на которых держится мотор и гасятся вибрации.",
            example = "תֻּמְכוֹת מְנוֹעַ סְדוּקוֹת מַעֲבִירוֹת זַעֲזוּעַ לָרִצְפָּה.",
            exampleNative = "Треснувшие תֻּמְכוֹת מְנוֹעַ передают тряску на пол кузова.",
        ),
        WordEntity(
            id = 171305, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_engine_internals",
            original = "סְלִיל הַצָּתָה", translation = "катушка зажигания",
            definition = "רְכִיב חַשְׁמַלִּי שֶׁמְּחַזֵּק אֶת הַמֶּתַח כְּדֵי ליצור נִיצוֹץ בְּמַצַּת.",
            definitionNative = "Электрический узел, повышающий напряжение для искры на свече.",
            example = "סְלִיל הַצָּתָה כשל וְהַהַתְנָעָה נִכְשְׁלָה בקור.",
            exampleNative = "סְלִיל הַצָּתָה вышла из строя — мотор не завёлся утром.",
         fillInBlankExclusions = listOf(171301L, 171302L, 171303L, 171304L, 171306L, 171312L)),
        WordEntity(
            id = 171306, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "auto_engine_internals",
            original = "סוֹלֵנוֹאִיד", translation = "соленоид",
            definition = "סלילון חַשְׁמַלִּי שֶׁמּוֹשֵׁךְ גַּרְעִין מַתֶּכֶת וּפוֹתֵחַ שַׁסְתּוֹמִים אוֹ מַצְמְדִים.",
            definitionNative = "Электромагнитная катушка, тянущая шток для срабатывания клапанов.",
            example = "סוֹלֵנוֹאִיד שֶׁל מַתְנֵעַ נִתְקַע וְלֹא מְשַׁחְרֵר.",
            exampleNative = "סוֹלֵנוֹאִיד стартера заклинил и не отпускает шестерню.",
        ),

        // ── auto_cooling_system (5) — охлаждение ──
        WordEntity(
            id = 171307, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_cooling_system",
            original = "מַשְׁאֵבַת מַיִם", translation = "водяной насос",
            definition = "הֶתְקֵן שֶׁמַּזְרִים אֶת נוֹזֵל הקירור דֶּרֶךְ גּוּשׁ הַמָּנוֹעַ והרדיאטור.",
            definitionNative = "Узел, гоняющий охлаждающую жидкость через мотор и радиатор.",
            example = "מַשְׁאֵבַת מַיִם דּוֹלֶפֶת וְיוֹצֶרֶת שְׁלוּלִית מִתַּחַת.",
            exampleNative = "מַשְׁאֵבַת מַיִם течёт и оставляет лужу под мотором.",
         fillInBlankExclusions = listOf(171308L, 171309L, 171310L, 171312L)),
        WordEntity(
            id = 171308, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_cooling_system",
            original = "מַעֲבִיר חֹם", translation = "теплообменник",
            definition = "הֶתְקֵן שֶׁמַּעֲבִיר חום מִנּוֹזֵל אֶחָד לְאַחֵר בְּלִי לְעַרְבֵּב בֵּינֵיהֶם.",
            definitionNative = "Узел, передающий тепло из одной жидкости в другую без смешения.",
            example = "מַעֲבִיר חֹם שֶׁל תיבת ההילוכים נִסְתַּם בְּלִכְלוּךְ.",
            exampleNative = "מַעֲבִיר חֹם коробки забился отложениями за годы.",
         fillInBlankExclusions = listOf(171307L, 171309L, 171310L)),
        WordEntity(
            id = 171309, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_cooling_system",
            original = "מַעֲגַל קֵרוּר", translation = "контур охлаждения",
            definition = "מַעֲרֶכֶת סְגוּרָה שֶׁל צינורות וְנוֹזֵל שֶׁשּׁוֹמֶרֶת עַל טֶמְפֵּרָטוּרַת הַמָּנוֹעַ.",
            definitionNative = "Замкнутая сеть труб с жидкостью, поддерживающая температуру мотора.",
            example = "מַעֲגָל קֵרוּר איבד לַחַץ אַחֲרֵי הַקִּילוֹמֶטֶר הָאַחֲרוֹן.",
            exampleNative = "מַעֲגַל קֵרוּר потерял давление на последних километрах.",
         fillInBlankExclusions = listOf(171307L, 171308L, 171310L)),
        WordEntity(
            id = 171310, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_cooling_system",
            original = "צִינּוֹר רַדְיָאטוֹר", translation = "патрубок радиатора",
            definition = "צינור גָּמִישׁ שֶׁמְּחַבֵּר אֶת גּוּשׁ הַמָּנוֹעַ לְמַצְנֵן וְנוֹשֵׂא נוֹזֵל חַם.",
            definitionNative = "Гибкая трубка между мотором и радиатором с горячей жидкостью.",
            example = "צִינּוֹר רַדְיָאטוֹר הִתְפּוֹצֵץ בְּאֶמְצַע הַכְּבִישׁ.",
            exampleNative = "צִינּוֹר רַדְיָאטוֹר лопнул прямо посреди трассы.",
         fillInBlankExclusions = listOf(171307L, 171308L, 171309L)),
        WordEntity(
            id = 171311, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "auto_cooling_system",
            original = "טֶרְמוֹסְטָט", translation = "термостат",
            definition = "שַׁסְתּוֹם אוֹטוֹמָטִי שפותח זְרִימַת נוֹזֵל בָּרֶגַע שֶׁהַמָּנוֹעַ מִתְחַמֵּם.",
            definitionNative = "Клапан, открывающий поток жидкости при нагреве мотора.",
            example = "טֶרְמוֹסְטָט תָּקוּעַ גּוֹרֵם לְהִתְחַמְּמוּת מְהִירָה.",
            exampleNative = "Заклинивший טֶרְמוֹסְטָט вызывает быстрый перегрев двигателя.",
         fillInBlankExclusions = listOf(171307L)),

        // ── auto_fuel_oil_exhaust (4) — топливо, масло и выхлоп ──
        WordEntity(
            id = 171312, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_fuel_oil_exhaust",
            original = "מַשְׁאֵבַת דֶּלֶק", translation = "топливный насос",
            definition = "אַבְזָר חַשְׁמַלִּי שֶׁמַּעֲבִיר בֶּנְזִין מֵהַמֵּיכָל אֶל הַמָּנוֹעַ בְּלַחַץ קָבוּעַ.",
            definitionNative = "Электронасос, гонящий горючее из бака к мотору под напором.",
            example = "מַשְׁאֵבַת דֶּלֶק רָעֲשָׁה וּפָסְקָה לעבוד.",
            exampleNative = "מַשְׁאֵבַת דֶּלֶק загудела и встала на середине шоссе.",
         fillInBlankExclusions = listOf(171307L, 171313L, 171314L, 171315L)),
        WordEntity(
            id = 171313, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_fuel_oil_exhaust",
            original = "כַּיּוּל מַזְרֵקִים", translation = "калибровка форсунок",
            definition = "כיוון מדויק שֶׁל פִּתְחֵי הַזְרָקַת הַדֶּלֶק לְפִי מְפָרֵט יַצְרָן.",
            definitionNative = "Точная настройка струй впрыска под параметры производителя.",
            example = "כַּיּוּל מַזְרֵקִים נַעֲשָׂה בְּמַכְשִׁיר אִבְחוּן מִתְקַדֵּם.",
            exampleNative = "כַּיּוּל מַזְרֵקִים делают на современном диагностическом стенде.",
         fillInBlankExclusions = listOf(171312L, 171314L, 171315L, 171319L, 171320L)),
        WordEntity(
            id = 171314, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_fuel_oil_exhaust",
            original = "מַעֲרֶכֶת פְּלִיטָה", translation = "выпускная система",
            definition = "סדרת צינורות וּמְמִירִים שֶׁמְּסַלְּקִים אֶת גָּזֵי הַשְּׂרֵפָה הַחוּצָה.",
            definitionNative = "Связка труб и катализаторов, выводящая горелые газы наружу.",
            example = "מַעֲרֶכֶת פְּלִיטָה חֲלוּדָה שׁוֹרֶקֶת בְּכָל סיבוב.",
            exampleNative = "Ржавая מַעֲרֶכֶת פְּלִיטָה свистит на каждом повороте.",
         fillInBlankExclusions = listOf(171312L, 171313L, 171315L)),
        WordEntity(
            id = 171315, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_fuel_oil_exhaust",
            original = "הַחְלָפַת שֶׁמֶן", translation = "замена масла",
            definition = "פעולת תַּחְזוּקָה שֶׁבָּהּ מוֹצִיאִים שֶׁמֶן יָשָׁן וּמַכְנִיסִים חָדָשׁ למנוע.",
            definitionNative = "Регламентная работа: старая жидкость сливается, новая заливается.",
            example = "הַחְלָפַת שֶׁמֶן מומלצת כָּל עֲשֶׂרֶת אֲלָפִים קִילוֹמֶטֶר.",
            exampleNative = "הַחְלָפַת שֶׁמֶן рекомендуется каждые десять тысяч километров.",
         fillInBlankExclusions = listOf(171312L, 171313L, 171314L, 171319L, 171320L)),

        // ── auto_brakes_chassis (5) — тормоза и шасси ──
        WordEntity(
            id = 171316, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_brakes_chassis",
            original = "מַעֲצוֹר דִּיסְק", translation = "дисковый тормоз",
            definition = "צַלַּחַת מַתֶּכֶת מִסְתּוֹבֶבֶת שֶׁכָּרִיּוֹת לוֹחֲצוֹת עָלֶיהָ כְּדֵי לעצור גַּלְגַּל.",
            definitionNative = "Вращающаяся стальная пластина, которую сжимают колодки для остановки.",
            example = "מַעֲצוֹר דִּיסְק הִתְעַקֵּם וְרָעַד בִּנְהִיגָה.",
            exampleNative = "מַעֲצוֹר דִּיסְק повело, и руль вибрирует при торможении.",
         fillInBlankExclusions = listOf(171317L, 171318L, 171319L, 171320L)),
        WordEntity(
            id = 171317, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_brakes_chassis",
            original = "כָּרִיוֹת בְּלָמִים", translation = "тормозные колодки",
            definition = "חֶלְקֵי חיכוך מוחלפים שֶׁלּוֹחֲצִים עַל הַדִּיסְק אוֹ התוף לַעֲצִירָה.",
            definitionNative = "Сменные фрикционные элементы, прижимающие диск или барабан.",
            example = "כָּרִיוֹת בְּלָמִים שְׁחוּקוֹת יוֹצְרוֹת חֲרִיקָה גְּבוֹהָה.",
            exampleNative = "Стёртые כָּרִיוֹת בְּלָמִים визжат высоким металлическим звуком.",
         fillInBlankExclusions = listOf(171316L, 171319L, 171320L)),
        WordEntity(
            id = 171318, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "auto_brakes_chassis",
            original = "סֶרֶן", translation = "ось, мост",
            definition = "מוֹט עָבֶה שֶׁמְּחַבֵּר שְׁנֵי גַּלְגַּלִּים וּמַחֲזִיק עֲלֵיהֶם אֶת מִשְׁקַל הָרֶכֶב.",
            definitionNative = "Толстый стержень, соединяющий два колеса и несущий вес машины.",
            example = "סֶרֶן אֲחוֹרִי הִתְעַקֵּם בִּתְאוּנָה.",
            exampleNative = "סֶרֶן заднего моста повело при ударе в столб.",
         fillInBlankExclusions = listOf(171316L)),
        WordEntity(
            id = 171319, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_brakes_chassis",
            original = "אִיזּוּן גַּלְגַּלִּים", translation = "балансировка колёс",
            definition = "הַתְאָמַת מִשְׁקָל סְבִיב הַצְּמִיג כְּדֵי שֶׁהַנְּהִיגָה לֹא תִּרְעַד בִּמְהִירוּת.",
            definitionNative = "Подгонка веса по ободу шины, чтобы руль не дрожал на скорости.",
            example = "אִיזּוּן גַּלְגַּלִּים נַעֲשֶׂה אַחֲרֵי כָּל הַחְלָפָה.",
            exampleNative = "אִיזּוּן גַּלְגַּלִּים делают после каждой замены покрышек.",
         fillInBlankExclusions = listOf(171315L, 171316L, 171317L, 171320L)),
        WordEntity(
            id = 171320, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_brakes_chassis",
            original = "כַּוְונוּן זְוִיּוֹת", translation = "развал-схождение",
            definition = "קְבִיעָה מדויקת שֶׁל כיוון הַגַּלְגַּלִּים יַחֲסִית לַכְּבִישׁ וּלְצִיר.",
            definitionNative = "Точная настройка наклона колёс относительно дороги и оси.",
            example = "כַּוְונוּן זְוִיּוֹת מַאֲרִיךְ חַיֵּי צְמִיגִים.",
            exampleNative = "כַּוְונוּן זְוִיּוֹת продлевает жизнь шинам в полтора раза.",
         fillInBlankExclusions = listOf(171316L, 171317L, 171319L)),

        // ── auto_sensors_meters (5) — датчики и приборы диагностики ──
        WordEntity(
            id = 171321, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_sensors_meters",
            original = "מַחְשֵׁב מְנוֹעַ", translation = "блок управления двигателем",
            definition = "מַחְשֵׁב קָטָן שֶׁאוֹסֵף נְתוּנִים וּמַחֲלִיט אֵיךְ לְהַפְעִיל אֶת הַמָּנוֹעַ.",
            definitionNative = "Электронный модуль, управляющий впрыском, искрой и расходом мотора.",
            example = "מַחְשֵׁב מְנוֹעַ שָׁלַח קוֹד שְׁגִיאָה לַמּוּסָךְ.",
            exampleNative = "מַחְשֵׁב מְנוֹעַ отдал код ошибки на диагностику.",
        ),
        WordEntity(
            id = 171322, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_sensors_meters",
            original = "חַיְשַׁן חַמְצָן", translation = "лямбда-зонд",
            definition = "רְכִיב שֶׁמּוֹדֵד גַּזִּים אַחֲרֵי הַשְּׂרֵפָה ומדווח עַל אֵיכוּת התערובת.",
            definitionNative = "Датчик, замеряющий состав выхлопа и точность смеси топлива.",
            example = "חַיְשַׁן חַמְצָן זָקֵן הִגְדִּיל אֶת צְרִיכַת הַדֶּלֶק.",
            exampleNative = "Старый חַיְשַׁן חַמְצָן заметно увеличил расход бензина.",
         fillInBlankExclusions = listOf(171321L, 171323L, 171324L, 171325L)),
        WordEntity(
            id = 171323, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_sensors_meters",
            original = "חַיְשַׁן זְרִימָה", translation = "расходомер воздуха",
            definition = "הֶתְקֵן שֶׁמּוֹדֵד כַּמּוּת אוויר שֶׁנִּשְׁאֶבֶת אֶל הַמָּנוֹעַ בְּכָל שנייה.",
            definitionNative = "Прибор, отслеживающий объём всасываемого мотором воздуха.",
            example = "חַיְשַׁן זְרִימָה מלוכלך הָפַךְ נְסִיעָה חַלָּשָׁה לְרוֹעֶדֶת.",
            exampleNative = "Грязный חַיְשַׁן זְרִימָה превратил езду в дёрганую и слабую.",
         fillInBlankExclusions = listOf(171321L, 171322L, 171324L, 171325L)),
        WordEntity(
            id = 171324, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_sensors_meters",
            original = "מַד לַחַץ שֶׁמֶן", translation = "датчик давления масла",
            definition = "אַבְזָר שֶׁדּוֹרֵשׁ הַפְסָקָה מיידית אִם הסיכה בַּמָּנוֹעַ נוֹפֶלֶת.",
            definitionNative = "Прибор, требующий немедленно встать, если смазка падает в моторе.",
            example = "מַד לַחַץ שֶׁמֶן הִבְהֵב אדום בעלייה תְּלוּלָה.",
            exampleNative = "מַד לַחַץ שֶׁמֶן мигнул красным на крутом подъёме.",
         fillInBlankExclusions = listOf(171321L, 171322L, 171323L, 171325L)),
        WordEntity(
            id = 171325, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_sensors_meters",
            original = "מַד סִיבּוּבִים", translation = "тахометр",
            definition = "הַשָּׁעוֹן בְּלוּחַ שֶׁמַּרְאֶה כַּמָּה פְּעָמִים הַמָּנוֹעַ מִסְתּוֹבֵב בְּדַקָּה.",
            definitionNative = "Прибор, показывающий, сколько оборотов мотор делает в минуту.",
            example = "מַד סִיבּוּבִים זינק עַד הַקַּו האדום.",
            exampleNative = "מַד סִיבּוּבִים подскочил до самой красной зоны.",
         fillInBlankExclusions = listOf(171321L, 171322L, 171323L, 171324L)),
    )
}
