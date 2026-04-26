package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Клининг, level 4 (1 set, 25 слов).
 * Профессиональный регистр руководителя клининг-компании: специализированное
 * оборудование, профессиональная химия, договорные процессы с заказчиками,
 * международные стандарты качества, бизнес-операции.
 *
 * Set 1716:
 *   1716 (level 4, EPIC + LEGENDARY) — лексика руководителя клининговой
 *   компании: спецоборудование, химия, договоры, стандарты, операционка.
 *
 * Не пересекается с уже существующими сетами темы «Клининг»:
 *   1388 L1 (основы: уборка, инвентарь, базовые задачи),
 *   1389 L2 (моющие средства, поверхности, техника уборки),
 *   1390 L3 (промышленная уборка, дезинфекция, нормативы),
 *   1391 L5 (управление службой, SLA, KPI, бенчмаркинг),
 *   1392 L5 (устойчивая уборка, экосертификация, нанотехнологии),
 *   1562 L2 (общая профессиональная уборка: пылесос, перчатки, тележка).
 *
 * Распределение редкостей: 10 EPIC + 15 LEGENDARY (2 смежных уровня).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewCleaningL4 {

    val sets = listOf(
        WordSetEntity(
            id = 1716, languagePair = "he-ru", orderIndex = 216,
            name = "Уборка и работа клинером",
            description = "Руководитель компании: спецоборудование, химия, договоры, стандарты",
            topic = "Уборка и работа клинером", level = 4,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1716 — Клининг: профессиональный регистр (EPIC + LEGENDARY, C1–C2)
        // 5 групп × 5 слов: pro_equipment, pro_chemistry, contracts, pro_standards,
        //                   business_ops
        // ══════════════════════════════════════════════════════════════════════

        // ── cleaning_pro_equipment (5 EPIC) — профессиональное оборудование ──
        WordEntity(
            id = 171601, setId = 1716, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cleaning_pro_equipment", transliteration = "otoskraber",
            original = "אוֹטוֹסְקְרָבֶּר", translation = "поломоечная машина (автоскраббер)",
            definition = "מְכוֹנָה מִכְנִית הַשׁוֹטֶפֶת וְשׁוֹאֶבֶת מַיִם מֵרִצְפָּה גְּדוֹלָה.",
            definitionNative = "Самоходная машина, что моет и сразу всасывает воду с большого пола.",
            example = "הַמְּפַעֵל הִפְעִיל אֶת הָאוֹטוֹסְקְרָבֶּר בְּמַחְסַן הַלּוֹגִיסְטִיקָה.",
            exampleNative = "Оператор запустил אוֹטוֹסְקְרָבֶּר на логистическом складе.",
         fillInBlankExclusions = listOf(171602L, 171603L, 171604L, 171605L)),
        WordEntity(
            id = 171602, setId = 1716, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cleaning_pro_equipment", transliteration = "polisher orbitali",
            original = "פּוֹלִישֵׁר אוֹרְבִּיטָלִי", translation = "орбитальный полировщик",
            definition = "מְכוֹנָה לְהַבְרָקָה שֶׁל מִשְׁטָחִים בְּתְנוּעָה סִיבוּבִית כְּפוּלָה.",
            definitionNative = "Машина для блеска поверхностей, работающая двойным круговым ходом.",
            example = "הַטֶּכְנַאי נָקָה אֶת הַשַּׁיִשׁ בְּפּוֹלִישֵׁר אוֹרְבִּיטָלִי.",
            exampleNative = "Техник навёл блеск на мраморе с помощью פּוֹלִישֵׁר אוֹרְבִּיטָלִי.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(171601L, 171603L, 171604L, 171605L, 171606L, 171607L, 171608L, 171609L)),
        WordEntity(
            id = 171603, setId = 1716, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cleaning_pro_equipment", transliteration = "makhshir extraktsiya",
            original = "מַכְשִׁיר אֶקְסְטְרַקְצְיָה", translation = "экстракторная машина (для ковров)",
            definition = "כְּלִי מִקְצוֹעִי הַשׁוֹאֵב נוֹזֵל וְלִכְלוּךְ עָמֹק מִתּוֹךְ שָׁטִיחַ אוֹ רִפּוּד.",
            definitionNative = "Профессиональный аппарат, что вытягивает влагу и грязь изнутри ковра или обивки.",
            example = "הַטֶּכְנַאי הִשְׁתַּמֵּשׁ בַּמַּכְשִׁיר אֶקְסְטְרַקְצְיָה לְשָׁטִיחֵי הַמִּשְׂרָד.",
            exampleNative = "Техник применил מַכְשִׁיר אֶקְסְטְרַקְצְיָה для офисных ковров.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 171604, setId = 1716, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cleaning_pro_equipment", transliteration = "mazik koli",
            original = "מַזִּיק קוֹלִי", translation = "ультразвуковой очиститель",
            definition = "מַכְשִׁיר הַשּׁוֹלֵחַ גַּלִּים בְּתָדֶר גָּבוֹהַ לְהוֹרָדַת לִכְלוּךְ דַּקִּיק.",
            definitionNative = "Прибор, испускающий высокочастотные волны, чтобы снимать тонкую грязь.",
            example = "הַתַּכְשִׁיטָן נִקָּה שַׁרְשֶׁרֶת בְּמַזִּיק קוֹלִי שֶׁל חֶבְרַת הַנִּקָּיוֹן.",
            exampleNative = "Ювелир чистил цепочку с помощью מַזִּיק קוֹלִי клининг-компании.",
         fillInBlankExclusions = listOf(171602L, 171603L, 171605L)),
        WordEntity(
            id = 171605, setId = 1716, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cleaning_pro_equipment", transliteration = "shoev ta'asiyati",
            original = "שׁוֹאֵב תַּעֲשִׂיָּתִי", translation = "промышленный пылесос (для влажной/сухой уборки)",
            definition = "מַכְשִׁיר חָזָק שֶׁאוֹסֵף נוֹזְלִים וּפְסֹלֶת יָבֵשׁ בִּמְקוֹם עֲבוֹדָה גָּדוֹל.",
            definitionNative = "Мощный аппарат для сбора жидкости и сухого мусора в крупном цеху.",
            example = "אַחֲרֵי שִׁפּוּץ הִפְעִילוּ שׁוֹאֵב תַּעֲשִׂיָּתִי לְמֶשֶׁךְ שָׁעָה.",
            exampleNative = "После ремонта запустили שׁוֹאֵב תַּעֲשִׂיָּתִי на час.",
         fillInBlankExclusions = listOf(171601L, 171602L, 171603L, 171604L)),

        // ── cleaning_pro_chemistry (5 EPIC) — профессиональная химия ──
        WordEntity(
            id = 171606, setId = 1716, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cleaning_pro_chemistry", transliteration = "mefig ktamim enzimati",
            original = "מְפִיג כְּתָמִים אֶנְזִימָטִי", translation = "энзимный пятновыводитель",
            definition = "תַּכְשִׁיר עַל בָּסִיס חֶלְבּוֹנִים הַמְפָרֵק לִכְלוּךְ אוֹרְגָּנִי.",
            definitionNative = "Средство на основе белков, что разлагает органическую грязь.",
            example = "הָעוֹבֵד פִּזֵּר מְפִיג כְּתָמִים אֶנְזִימָטִי עַל הַשָּׁטִיחַ.",
            exampleNative = "Сотрудник нанёс מְפִיג כְּתָמִים אֶנְזִימָטִי на ковёр.",
         fillInBlankExclusions = listOf(171607L, 171608L, 171609L, 171610L)),
        WordEntity(
            id = 171607, setId = 1716, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cleaning_pro_chemistry", transliteration = "khomer nikuy alkali",
            original = "חוֹמֶר נִקּוּי אַלְקָלִי", translation = "щелочное чистящее средство",
            definition = "תַּכְשִׁיר בָּזִיסִי בִּ-pH גָּבוֹהַ הַמְסַלֵּק שׁוּמָן וּלִכְלוּךְ כָּבֵד.",
            definitionNative = "Базовое средство с высоким pH, что снимает жир и тяжёлую грязь.",
            example = "הַטֶּכְנַאי דִּלֵּל חוֹמֶר נִקּוּי אַלְקָלִי לְפִי הוֹרָאוֹת הַיַּצְרָן.",
            exampleNative = "Техник развёл חוֹמֶר נִקּוּי אַלְקָלִי по инструкции производителя.",
         fillInBlankExclusions = listOf(171606L, 171608L, 171609L, 171610L)),
        WordEntity(
            id = 171608, setId = 1716, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cleaning_pro_chemistry", transliteration = "tamisat she'am",
            original = "תַּמִּיסַת שֶׁעַם", translation = "раствор против известкового налёта",
            definition = "נוֹזֵל חָמוּץ הַמֵּסִיר שִׁכְבוֹת אֶבֶן מִקַּו הַמַּיִם וּמִבֶּרֶזִים.",
            definitionNative = "Кислая жидкость, что снимает каменные отложения с кранов и линий воды.",
            example = "בַּמִּקְלַחַת הַצִּבּוּרִית מָרְחוּ תַּמִּיסַת שֶׁעַם פַּעַם בְּשָׁבוּעַ.",
            exampleNative = "В общественном душе наносят תַּמִּיסַת שֶׁעַם раз в неделю.",
         fillInBlankExclusions = listOf(171606L, 171607L, 171609L, 171610L)),
        WordEntity(
            id = 171609, setId = 1716, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cleaning_pro_chemistry", transliteration = "mashlit shumanim",
            original = "מַשְׁלִיט שׁוּמָנִים", translation = "обезжириватель (промышленный)",
            definition = "תַּכְשִׁיר חָזָק לִפְעוּלָה עַל מִטְבָּחֵי תַּעֲשִׂיָּה וְלַחֲדַר מָנוֹעַ.",
            definitionNative = "Сильное средство для промышленных кухонь и моторных отсеков.",
            example = "הַשֶׁף בִּקֵּשׁ לְהוֹסִיף מַשְׁלִיט שׁוּמָנִים לְמַסִּיר הַגְּרִיל.",
            exampleNative = "Шеф попросил добавить מַשְׁלִיט שׁוּמָנִים при чистке гриля.",
         fillInBlankExclusions = listOf(171606L, 171607L, 171608L, 171610L)),
        WordEntity(
            id = 171610, setId = 1716, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cleaning_pro_chemistry", transliteration = "hasarat grafiti",
            original = "הָסָרַת גְּרָפִיטִי", translation = "удаление граффити (специальная химия)",
            definition = "פְּעוּלָה מִקְצוֹעִית לְמְחִיקַת צִיּוּרֵי רַסָּסִים מִמִּשְׁטְחֵי בִּנְיָן.",
            definitionNative = "Профессиональная обработка для стирания краски-аэрозоля со стен.",
            example = "הָעִירִיָּה הִזְמִינָה הָסָרַת גְּרָפִיטִי מִכּוֹתֶל הַסֵּפֶר.",
            exampleNative = "Муниципалитет заказал הָסָרַת גְּרָפִיטִי со стены библиотеки.",
         fillInBlankExclusions = listOf(171606L, 171607L, 171608L, 171609L)),

        // ── cleaning_contracts (5 LEGENDARY) — договорные процессы ──
        WordEntity(
            id = 171611, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_contracts", transliteration = "heskem retsifut sherut",
            original = "הֶסְכֵּם רְצִיפוּת שֵׁרוּת", translation = "соглашение о непрерывности обслуживания",
            definition = "מִסְמָךְ הַמַּבְטִיחַ שֶׁהַשֵּׁרוּת לֹא יִפָּסֵק גַּם בְּעֵת תַּקָּלָה אוֹ חֲלִיפָה שֶׁל קַבְלָן.",
            definitionNative = "Документ, гарантирующий, что услуга не прервётся при сбое или замене подрядчика.",
            example = "הַחוֹזֶה כָּלַל הֶסְכֵּם רְצִיפוּת שֵׁרוּת לְמֶשֶׁךְ שָׁלוֹשׁ שָׁנִים.",
            exampleNative = "Контракт включал הֶסְכֵּם רְצִיפוּת שֵׁרוּת сроком на три года.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(171612L, 171613L, 171614L, 171615L, 171617L, 171621L, 171622L, 171625L)),
        WordEntity(
            id = 171612, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_contracts", transliteration = "mikhraz sherutei nikuy",
            original = "מִכְרַז שֵׁרוּתֵי נִקּוּי", translation = "тендер на клининговые услуги",
            definition = "תַּהֲלִיךְ פּוּמְבִּי בּוֹ חֲבָרוֹת מַגִּישׁוֹת הַצָּעוֹת לְזָכִיָּה בְּחוֹזֶה נִקּוּי.",
            definitionNative = "Открытая процедура, в которой компании подают заявки на контракт по уборке.",
            example = "הַמִּשְׂרָד פִּרְסֵם מִכְרַז שֵׁרוּתֵי נִקּוּי לִשְׁלוֹשׁ קוֹמוֹת.",
            exampleNative = "Министерство объявило מִכְרַז שֵׁרוּתֵי נִקּוּי на три этажа.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(171611L, 171613L, 171614L, 171615L, 171621L, 171622L, 171624L, 171625L)),
        WordEntity(
            id = 171613, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_contracts", transliteration = "se'if i-takharut",
            original = "סְעִיף אִי-תַּחֲרוּת", translation = "пункт о неконкуренции (в договоре)",
            definition = "תְּנַאי הַמּוֹנֵעַ מֵעוֹבֵד אוֹ קַבְּלָן לִפְנוֹת לִקְלִיֶּנְט הַלָּקוֹחַ.",
            definitionNative = "Условие, запрещающее работнику или подрядчику переходить к клиенту заказчика.",
            example = "הַחוֹזֶה כָּלַל סְעִיף אִי-תַּחֲרוּת לְשָׁנָתַיִם נוֹסָפוֹת.",
            exampleNative = "Договор содержал סְעִיף אִי-תַּחֲרוּת ещё на два года.",
         fillInBlankExclusions = listOf(171611L, 171612L, 171614L, 171615L, 171617L, 171621L, 171622L)),
        WordEntity(
            id = 171614, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_contracts", transliteration = "luakh zmanei bitsua",
            original = "לוּחַ זְמַנֵּי בִּצּוּעַ", translation = "график исполнения работ",
            definition = "טַבְלַת תַּאֲרִיכִים הַקּוֹבַעַת מָתַי כָּל מְשִׁימַת נִקּוּי תְּבֻצַּע.",
            definitionNative = "Таблица дат, что определяет, когда выполнят каждую задачу по уборке.",
            example = "מְנַהֵל הָאוֹבְּיֶקְט אִשֵּׁר אֶת לוּחַ זְמַנֵּי בִּצּוּעַ לְשָׁבוּעַ הַבָּא.",
            exampleNative = "Управляющий объекта утвердил לוּחַ זְמַנֵּי בִּצּוּעַ на следующую неделю.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 171615, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_contracts", transliteration = "se'if knasot",
            original = "סְעִיף קְנָסוֹת", translation = "пункт о штрафных санкциях",
            definition = "תְּנַאי הַקּוֹבֵעַ סְכוּם תַּשְׁלוּם עִם אִחוּר אוֹ אִי-עֲמִידָה בְּתֶקֶן.",
            definitionNative = "Условие, что фиксирует сумму выплаты при задержке или отступлении от стандарта.",
            example = "הַלָּקוֹחַ דָּרַשׁ סְעִיף קְנָסוֹת בְּמִקְרֵה אִחוּר.",
            exampleNative = "Заказчик потребовал סְעִיף קְנָסוֹת на случай задержки.",
         fillInBlankExclusions = listOf(171611L, 171612L, 171613L, 171614L, 171625L)),

        // ── cleaning_pro_standards (5 LEGENDARY) — профессиональные стандарты ──
        WordEntity(
            id = 171616, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_pro_standards", transliteration = "tiknei eichut ostraliyim",
            original = "תִּקְנֵי אִיכוּת אוֹסְטְרָלִיִּים", translation = "австралийские стандарты качества (AS/NZS)",
            definition = "אֹסֶף תִּקְנוֹת אִיכוּת מוּכָּרִים בִּמְדִינוֹת אוֹסְטְרַלְיָה וְנִיו זִילַנְד.",
            definitionNative = "Свод признанных норм качества, действующих в Австралии и Новой Зеландии.",
            example = "הַחֶבְרָה הִתְחַיְּבָה לַעֲבֹד לְפִי תִּקְנֵי אִיכוּת אוֹסְטְרָלִיִּים.",
            exampleNative = "Компания обязалась работать по תִּקְנֵי אִיכוּת אוֹסְטְרָלִיִּים.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(171614L, 171617L, 171618L, 171619L, 171620L, 171621L, 171622L, 171624L, 171625L)),
        WordEntity(
            id = 171617, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_pro_standards", transliteration = "hasmakhat operator",
            original = "הַסְמָכַת אוֹפֶרָטוֹר", translation = "аттестация оператора (на технике)",
            definition = "תְּעוּדָה רִשְׁמִית הַמַּכְשִׁירָה אִישׁ צֶוֶת לְהַפְעִיל מְכוֹנָה כְּבֵדָה.",
            definitionNative = "Официальный документ, разрешающий сотруднику управлять тяжёлой машиной.",
            example = "כָּל מְפַעֵל קִבֵּל הַסְמָכַת אוֹפֶרָטוֹר לִפְנֵי תְּחִילַּת הָעֲבוֹדָה.",
            exampleNative = "Каждый оператор получил הַסְמָכַת אוֹפֶרָטוֹר до начала работы.",
         fillInBlankExclusions = listOf(171616L, 171618L, 171619L, 171620L)),
        WordEntity(
            id = 171618, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_pro_standards", transliteration = "teken BICSc",
            original = "תֶּקֶן BICSc", translation = "стандарт BICSc (британский институт клининга)",
            definition = "מַעֲרֶכֶת תְּקָנוֹת מִקְצוֹעִיָּה שֶׁל הַמּוֹסָד הַבְּרִיטִי לְעוֹבְדֵי נִקּוּי.",
            definitionNative = "Профессиональный свод правил британского института уборщиков.",
            example = "הַמַּדְרִיךְ הִתְבַּסֵּס עַל תֶּקֶן BICSc לַהֲכָנַת הַצֶּוֶת.",
            exampleNative = "Тренер опирался на תֶּקֶן BICSc при подготовке команды.",
         fillInBlankExclusions = listOf(171616L, 171617L, 171619L, 171620L)),
        WordEntity(
            id = 171619, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_pro_standards", transliteration = "teken EN 13549",
            original = "תֶּקֶן EN 13549", translation = "европейский стандарт EN 13549 (методы оценки уборки)",
            definition = "תֶּקֶן אֵירוֹפִּי הַקּוֹבֵעַ שִׁיטוֹת לִמְדִידַת אֵיכוּת תּוֹצְאוֹת נִקּוּי.",
            definitionNative = "Европейская норма, что задаёт методы измерения качества результатов уборки.",
            example = "הַמַּזְמִין דָּרַשׁ דּוֹחַ לְפִי תֶּקֶן EN 13549.",
            exampleNative = "Заказчик потребовал отчёт по תֶּקֶן EN 13549.",
         fillInBlankExclusions = listOf(171616L, 171617L, 171618L, 171620L)),
        WordEntity(
            id = 171620, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_pro_standards", transliteration = "tag GS-37 shel grin sil",
            original = "תָּג GS-37 שֶׁל גְּרִין סִיל", translation = "сертификат GS-37 от Green Seal (эко)",
            definition = "תְּעוּדָה אֶקוֹלוֹגִית אֲמֶרִיקָאִית לַמּוּצְרֵי נִקּוּי בְּטוּחֵי סְבִיבָה.",
            definitionNative = "Американский экосертификат для безопасных для среды чистящих продуктов.",
            example = "הַחֶבְרָה רוֹכֶשֶׁת רַק חוֹמָרִים עִם תָּג GS-37 שֶׁל גְּרִין סִיל.",
            exampleNative = "Компания закупает только средства с תָּג GS-37 שֶׁל גְּרִין סִיל.",
         fillInBlankExclusions = listOf(171616L, 171617L, 171618L, 171619L)),

        // ── cleaning_business_ops (5 LEGENDARY) — бизнес-операции ──
        WordEntity(
            id = 171621, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_business_ops", transliteration = "tamkhur lefi meter ravua",
            original = "תַּמְחוּר לְפִי מֶטֶר רָבוּעַ", translation = "тарификация по квадратному метру",
            definition = "שִׁיטַת חִישּׁוּב מְחִיר לְפִי שֶׁטַח הָרִצְפָּה הַטָּעוּן נִקּוּי.",
            definitionNative = "Метод расчёта цены по площади пола, требующего уборки.",
            example = "הַהַצָּעָה כָּלְלָה תַּמְחוּר לְפִי מֶטֶר רָבוּעַ עַל כָּל הַקּוֹמָה.",
            exampleNative = "Предложение содержало תַּמְחוּר לְפִי מֶטֶר רָבוּעַ за весь этаж.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 171622, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_business_ops", transliteration = "model manui khodshi",
            original = "מוֹדֵל מָנוּי חָדְשִׁי", translation = "модель подписки (ежемесячная)",
            definition = "סִדּוּר תַּשְׁלוּם קָבוּעַ בּוֹ הַלָּקוֹחַ מְשַׁלֵּם סְכוּם זֵהֶה כָּל חֹדֶשׁ.",
            definitionNative = "Постоянная схема оплаты, при которой клиент платит одинаковую сумму каждый месяц.",
            example = "הַחֶבְרָה עָבְרָה לְמוֹדֵל מָנוּי חָדְשִׁי בְּחוֹזֵי לָקוֹחוֹת מַפְתֵּחַ.",
            exampleNative = "Компания перешла на מוֹדֵל מָנוּי חָדְשִׁי с ключевыми клиентами.",
         fillInBlankExclusions = listOf(171621L, 171623L, 171624L, 171625L)),
        WordEntity(
            id = 171623, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_business_ops", transliteration = "portfolio lakokhot",
            original = "פּוֹרְטְפוֹלְיוֹ לָקוֹחוֹת", translation = "портфолио клиентов (для тендера)",
            definition = "אֹסֶף הִישֵּׂגֵי עָבָר עִם לְקוֹחוֹת שׁוֹנִים לְהוֹכָחַת מִקְצוֹעִיּוּת.",
            definitionNative = "Подборка прежних достижений с разными заказчиками для подтверждения уровня.",
            example = "מְנַהֵל הַמְּכִירוֹת שָׁלַח פּוֹרְטְפוֹלְיוֹ לָקוֹחוֹת לַמַּזְמִין.",
            exampleNative = "Менеджер по продажам отправил פּוֹרְטְפוֹלְיוֹ לָקוֹחוֹת заказчику.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(171611L, 171614L, 171616L, 171618L, 171619L, 171620L, 171621L, 171622L, 171624L, 171625L)),
        WordEntity(
            id = 171624, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_business_ops", transliteration = "toranut mishmarot",
            original = "תּוֹרָנוּת מִשְׁמָרוֹת", translation = "сменный график персонала",
            definition = "סִדּוּר חִלּוּפֵי עוֹבְדִים לְפִי שָׁעוֹת בּוֹקֶר, צָהֳרַיִם וְלַיְלָה.",
            definitionNative = "Расписание сменных бригад на утренние, дневные и ночные часы.",
            example = "מְנַהֶלֶת הַצֶּוֶת עִדְכְּנָה תּוֹרָנוּת מִשְׁמָרוֹת לְסוֹף הַשָּׁבוּעַ.",
            exampleNative = "Управляющая бригадой обновила תּוֹרָנוּת מִשְׁמָרוֹת на выходные.",
         fillInBlankExclusions = listOf(171614L, 171621L, 171622L, 171623L, 171625L)),
        WordEntity(
            id = 171625, setId = 1716, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "cleaning_business_ops", transliteration = "omed avoda lefi sha'a",
            original = "אוֹמֶד עֲבוֹדָה לְפִי שָׁעָה", translation = "почасовая оценка трудозатрат",
            definition = "חִישּׁוּב מָסְפַּר שְׁעוֹת אָדָם הַנִּדְרָשׁ לְהַשְׁלָמַת מְשִׁימָה מֻגְדֶּרֶת.",
            definitionNative = "Подсчёт количества человеко-часов, нужных для выполнения заданной задачи.",
            example = "הַטֶּכְנוֹלוֹג הִכִּין אוֹמֶד עֲבוֹדָה לְפִי שָׁעָה לַחוֹזֶה הַחָדָשׁ.",
            exampleNative = "Технолог подготовил אוֹמֶד עֲבוֹדָה לְפִי שָׁעָה для нового контракта.",
         fillInBlankExclusions = listOf(171614L, 171621L, 171622L, 171623L, 171624L)),
    )
}
