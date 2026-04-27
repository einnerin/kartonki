package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Сантехника и работа сантехником", L5 «Носитель языка»
 * (EPIC+LEGENDARY).
 *
 * Set 1801: «Сантехника и работа сантехником» — носитель языка L5:
 *           Управление и нормы — проектирование систем, нормативы, тендеры,
 *           бизнес сантехника.
 *
 * Целевая аудитория — русскоязычные мастера и владельцы сантехнических
 * компаний в Израиле, готовящиеся к сертификации, тендерам и работе по
 * נֹהֲלֵי תקן ישראלי 1205. Лексика — «бумажная» сторона профессии:
 * проектные документы, лицензирование, расценки, страхование, охрана труда.
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   plumber_design     — проектирование: схема разводки, расчёт сечения,
 *                        планировка, нормативная нагрузка, чертёж
 *   plumber_standards  — нормативы: ТI 1205, проф. сертификация, форма 4,
 *                        технадзор, гарантия работ
 *   plumber_business   — бизнес: счёт, смета, тендер, договор подряда, аванс
 *   plumber_specialty  — специальные: газ, скрытая разводка, гелиосистема,
 *                        очистные, реконструкция инфраструктуры
 *   plumber_safety     — безопасность: правила, СИЗ, страхование, оценка
 *                        рисков, аварийный протокол
 *
 * Word IDs: setId × 100 + position (180101..180125).
 *
 * Пересечения с другими наборами темы — проверены:
 *   - PlumberL1L2L3 (1742-1744): צִנּוֹר, בֶּרֶז, אַסְלָה, כִּיּוֹר, אַמְבַּטְיָה,
 *     מִקְלַחַת, מַיִם, זַרְנוּק, דֶּלֶף, סְתִימָה, תִּקּוּן, אֶטֶם, שְׁרַבְרָב,
 *     הַזְמָנָה, מְחִיר, חֶשְׁבּוֹן, אַחְרָיוּת, סִיפוֹן, פִיטִינְג, פּוֹמְפָּה,
 *     הַתְקָנָה, פֵּרוּק, בְּדִיקָה, אִבְחוּן, מַד מַיִם, דּוּד חִמּוּם, הַסָּקָה,
 *     בִּיּוּב, מַעֲרֶכֶת נִקּוּז, אַסְפָּקַת מַיִם, תֵּקֶן בְּנִיָּה, תְּעוּדַת
 *     שְׁרַבְרָב, עֵסֶק עַצְמָאִי, רִישׁוּי. В этом сете не повторяются.
 *   - PlumberL4 (1800, параллельная разработка): пересечения исключены —
 *     L4 покрывает оперативный профессиональный лексикон (бригада, наряд,
 *     планёрка, выезд по гарантии), L5 — стратегический управленческий слой.
 *
 * Кросс-тематические дубли (другая тема — допускается, см.
 * docs/claude/feedback_duplicate_words_policy.md):
 *   - הַסְמָכָה מִקְצוֹעִית — Batch64 (Ресторан), WorkV2 (Работа): другие темы.
 *   - מִכְרָז — Immigrant13 (Риэлтор): другая тема.
 *   - דּוּד שֶׁמֶשׁ — Immigrant2: другая тема.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewPlumberL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1801, languagePair = "he-ru", orderIndex = 1801,
            name = "Сантехника и работа сантехником",
            description = "Управление и нормы: проектирование систем, нормативы, тендеры, бизнес сантехника",
            topic = "Сантехника и работа сантехником", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1801 — Сантехника и работа сантехником: носитель языка (L5, EPIC+LEGENDARY)
        // 5 групп × 5 слов: design, standards, business, specialty, safety
        // 13 EPIC + 12 LEGENDARY
        // ══════════════════════════════════════════════════════════════════════

        // ── plumber_design (5) — проектирование сантехнических систем ──
        WordEntity(
            id = 180101, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_design", transliteration = "tikhnun hidrauli",
            original = "תִּכְנוּן הִידְרָאוּלִי", translation = "гидравлический проект",
            definition = "שָׁלָב הַמַּחְשָׁבָה הַמֻּקְדָּם — לִפְנֵי הַחֲפִירָה כְּבָר יוֹדְעִים מָה יֵלֵךְ אֵיפֹה.",
            definitionNative = "Этап замысла — до копки уже знают, что и куда пойдёт.",
            example = "תִּכְנוּן הִידְרָאוּלִי לְבִנְיָן בֶּן שֵׁשׁ קוֹמוֹת לוֹקֵחַ חֹדֶשׁ עֲבוֹדָה.",
            exampleNative = "תִּכְנוּן הִידְרָאוּלִי для шестиэтажки занимает месяц работы.",
         fillInBlankExclusions = listOf(180102L, 180103L, 180104L, 180105L)),
        WordEntity(
            id = 180102, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_design", transliteration = "skhemat zrima",
            original = "סְכֵמַת זְרִימָה", translation = "схема разводки",
            definition = "שִׂרְטוּט שֶׁמַּרְאֶה לְאָן הוֹלְכִים הַמַּיִם וְלָאָן חוֹזְרִים בְּכָל קוֹמָה.",
            definitionNative = "Чертёж, показывающий, куда вода идёт и откуда возвращается на каждом этаже.",
            example = "מָסַרְתִּי לַקַּבְּלָן סְכֵמַת זְרִימָה מְדֻיֶּקֶת לִפְנֵי הַיְצִיקָה.",
            exampleNative = "Я передал подрядчику точную סְכֵמַת זְרִימָה до заливки бетона.",
         fillInBlankExclusions = listOf(180101L, 180103L, 180104L, 180105L, 180112L)),
        WordEntity(
            id = 180103, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_design", transliteration = "haamasa maksimalit",
            original = "הַעֲמָסָה מַקְסִימָלִית", translation = "максимальная (нормативная) нагрузка",
            definition = "כַּמָּה מַיִם הַקַּו עוֹמֵד בְּשִׂיא הַשִּׁמּוּשׁ — לְמָשָׁל בַּבֹּקֶר בְּכָל הַדִּירוֹת.",
            definitionNative = "Сколько воды линия выдерживает на пике — например, утром во всех квартирах сразу.",
            example = "חִשַּׁבְתִּי הַעֲמָסָה מַקְסִימָלִית לִפְנֵי שֶׁבָּחַרְתִּי קֹטֶר רָאשִׁי.",
            exampleNative = "Я рассчитал הַעֲמָסָה מַקְסִימָלִית до выбора главного диаметра.",
         fillInBlankExclusions = listOf(180101L, 180102L, 180104L, 180105L)),
        WordEntity(
            id = 180104, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_design", transliteration = "kviat koter",
            original = "קְבִיעַת קֹטֶר", translation = "определение диаметра (трубы)",
            definition = "בְּחִירָה שֶׁל רֹחַב פְּנִימִי שֶׁל הַקַּו לְפִי כַּמּוּת הַמַּיִם הַצְּפוּיָה.",
            definitionNative = "Выбор внутренней ширины линии по ожидаемому объёму воды.",
            example = "קְבִיעַת קֹטֶר נִכְשְׁלָה וְהַלַּחַץ נָפַל בַּקּוֹמָה הָעֶלְיוֹנָה.",
            exampleNative = "קְבִיעַת קֹטֶר оказалась ошибочной, и на верхнем этаже упало давление.",
         fillInBlankExclusions = listOf(180101L, 180102L, 180103L, 180105L)),
        WordEntity(
            id = 180105, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_design", transliteration = "sirtut adrikhali",
            original = "שִׂרְטוּט אַדְרִיכָלִי", translation = "архитектурный чертёж",
            definition = "מִסְמָךְ מְקֻצָּע שֶׁמַּרְאֶה אֶת חַדְרֵי הָרַחְצָה בְּמִדּוֹת מְדֻיָּקוֹת לְמִילִימֶטֶר.",
            definitionNative = "Профессиональный документ, показывающий помещения с точностью до миллиметра.",
            example = "שִׂרְטוּט אַדְרִיכָלִי הִגִּיעַ מֵהַסְּטוּדְיוֹ בְּקֹבֶץ פִי-דִי-אֵף.",
            exampleNative = "שִׂרְטוּט אַדְרִיכָלִי пришёл из студии PDF-файлом.",
         fillInBlankExclusions = listOf(180101L, 180102L, 180103L, 180104L)),

        // ── plumber_standards (5) — нормативы и сертификация в Израиле ──
        WordEntity(
            id = 180106, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_standards", transliteration = "teken yisreeli 1205",
            original = "תֶּקֶן יִשְׂרְאֵלִי 1205", translation = "израильский стандарт 1205",
            definition = "מִסְמָךְ הַחוֹבָה שֶׁקּוֹבֵעַ דְּרִישׁוֹת לַעֲבוֹדוֹת מַיִם בִּבְנִיָּה בִּמְדִינָה.",
            definitionNative = "Обязательный документ с требованиями к водопроводным работам в стране.",
            example = "כָּל הַהַתְקָנָה תּוֹאֶמֶת תֶּקֶן יִשְׂרְאֵלִי 1205 וְעָבְרָה בְּדִיקָה.",
            exampleNative = "Весь монтаж соответствует תֶּקֶן יִשְׂרְאֵלִי 1205 и прошёл проверку.",
         fillInBlankExclusions = listOf(180107L, 180108L, 180109L, 180110L)),
        WordEntity(
            id = 180107, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_standards", transliteration = "hasmakha miktsoit",
            original = "הַסְמָכָה מִקְצוֹעִית", translation = "профессиональная сертификация",
            definition = "אִשּׁוּר רִשְׁמִי שֶׁאוּמָן עָבַר לִמּוּדִים וּבְחִינוֹת שֶׁל הַמְּדִינָה.",
            definitionNative = "Официальное подтверждение, что мастер прошёл учёбу и государственные экзамены.",
            example = "הַסְמָכָה מִקְצוֹעִית בְּתֹקֶף הִיא תְּנַאי לְכָל מִכְרָז צִבּוּרִי.",
            exampleNative = "Действующая הַסְמָכָה מִקְצוֹעִית — условие для любого госконкурса.",
         fillInBlankExclusions = listOf(180106L, 180108L, 180109L, 180110L)),
        WordEntity(
            id = 180108, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_standards", transliteration = "tofes 4",
            original = "טֹפֶס 4", translation = "форма 4 (акт ввода в эксплуатацию)",
            definition = "אִשּׁוּר אַחֲרוֹן מֵעִירִיָּה שֶׁמַּתִּיר לְהִתְחִיל לָגוּר בַּדִּירָה הַחֲדָשָׁה.",
            definitionNative = "Финальное разрешение мэрии заселяться в новую квартиру.",
            example = "בְּלִי טֹפֶס 4 חֶבְרַת הַחַשְׁמַל לֹא תְחַבֵּר אוֹתָנוּ לָרֶשֶׁת.",
            exampleNative = "Без טֹפֶס 4 электрокомпания нас к сети не подключит.",
         fillInBlankExclusions = listOf(180106L, 180107L, 180109L, 180110L)),
        WordEntity(
            id = 180109, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_standards", transliteration = "pikuakh handasi",
            original = "פִּקּוּחַ הַנְדָּסִי", translation = "технический надзор",
            definition = "מַעֲקָב שֶׁל מְהַנְדֵּס עַל הָעֲבוֹדָה כְּדֵי לִתְפֹּס טָעוּת בִּזְמַן אֲמִתִּי.",
            definitionNative = "Контроль инженера за работой ради поимки ошибки прямо по ходу.",
            example = "פִּקּוּחַ הַנְדָּסִי גִּלָּה סְטִיָּה וְעָצַר אֶת הַיְצִיקָה.",
            exampleNative = "פִּקּוּחַ הַנְדָּסִי выявил отклонение и остановил заливку.",
         fillInBlankExclusions = listOf(180106L, 180107L, 180108L, 180110L)),
        WordEntity(
            id = 180110, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_standards", transliteration = "ktav hitkhayvut",
            original = "כֶּתֶב הִתְחַיְּבוּת", translation = "гарантийное обязательство",
            definition = "מִסְמָךְ חָתוּם שֶׁבּוֹ הַקַּבְּלָן מַבְטִיחַ לְתַקֵּן בְּחִנָּם בְּתוֹךְ זְמַן יָדוּעַ.",
            definitionNative = "Подписанный документ, в котором подрядчик обещает чинить бесплатно в известный срок.",
            example = "מָסַרְתִּי לַלָּקוֹחַ כֶּתֶב הִתְחַיְּבוּת לְשֶׁבַע שָׁנִים.",
            exampleNative = "Я выдал клиенту כֶּתֶב הִתְחַיְּבוּת на семь лет.",
         fillInBlankExclusions = listOf(180106L, 180107L, 180108L, 180109L)),

        // ── plumber_business (5) — бумажная сторона бизнеса ──
        WordEntity(
            id = 180111, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_business", transliteration = "drishat tashlum",
            original = "דְּרִישַׁת תַּשְׁלוּם", translation = "счёт-фактура заказчику",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁשּׁוֹלְחִים אַחֲרֵי הָעֲבוֹדָה כְּדֵי לְקַבֵּל אֶת הַכֶּסֶף.",
            definitionNative = "Официальный документ, отправляемый после работы, чтобы получить деньги.",
            example = "דְּרִישַׁת תַּשְׁלוּם הוֹצֵאתִי בַּסּוֹף הַחֹדֶשׁ עִם פֵּרוּט מָלֵא.",
            exampleNative = "דְּרִישַׁת תַּשְׁלוּם я выписал в конце месяца с полной расшифровкой.",
         fillInBlankExclusions = listOf(180112L, 180113L, 180114L, 180115L)),
        WordEntity(
            id = 180112, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_business", transliteration = "haatsaat mekhirim",
            original = "הַצָּעַת מְחִירִים", translation = "смета (предложение цен)",
            definition = "פֵּרוּט מַה יַעֲשׂוּ וְכַמָּה זֶה יַעֲלֶה — לִפְנֵי שֶׁהַלָּקוֹחַ מֵסְכִּים.",
            definitionNative = "Расшифровка, что сделают и сколько стоит — до того как клиент согласится.",
            example = "הַצָּעַת מְחִירִים שָׁלַחְתִּי בְּמֵיל בּוֹ בַּיּוֹם.",
            exampleNative = "הַצָּעַת מְחִירִים я отправил по мейлу в тот же день.",
         fillInBlankExclusions = listOf(180102L, 180110L, 180111L, 180113L, 180114L, 180115L)),
        WordEntity(
            id = 180113, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_business", transliteration = "ketav kamuyot",
            original = "כֶּתֶב כַּמּוּיוֹת", translation = "ведомость объёмов работ",
            definition = "מִסְמָךְ מְפֹרָט שֶׁמְּפַרֵט כָּל פְּעֻלָּה וְכָל חֹמֶר עִם מְחִירִים בִּמְכָרַז.",
            definitionNative = "Подробный документ — каждое действие и каждый материал с ценами для тендера.",
            example = "כֶּתֶב כַּמּוּיוֹת מְדוּיָק מַצִּיל אוֹתָנוּ מֵוִיכּוּחִים עַל מְחִירִים בְּהַמְשֵׁךְ.",
            exampleNative = "Точный כֶּתֶב כַּמּוּיוֹת спасает нас от споров о ценах позже.",
         fillInBlankExclusions = listOf(180110L, 180111L, 180112L, 180114L, 180115L)),
        WordEntity(
            id = 180114, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_business", transliteration = "khoze kablanut",
            original = "חוֹזֵה קַבְּלָנוּת", translation = "договор подряда",
            definition = "הֶסְכֵּם חָתוּם בֵּין בַּעַל הַבַּיִת לְבַעַל מִקְצוֹעַ עַל עֲבוֹדָה תְּמוּרַת תַּשְׁלוּם.",
            definitionNative = "Подписанное соглашение между владельцем и мастером о работе за плату.",
            example = "חוֹזֵה קַבְּלָנוּת חָתוּם נוֹתֵן הֲגָנָה לִשְׁנֵי הַצְּדָדִים.",
            exampleNative = "Подписанный חוֹזֵה קַבְּלָנוּת защищает обе стороны.",
         fillInBlankExclusions = listOf(180110L, 180111L, 180112L, 180113L, 180115L)),
        WordEntity(
            id = 180115, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_business", transliteration = "mikdama al khomarim",
            original = "מִקְדָּמָה עַל חוֹמְרִים", translation = "аванс за материалы",
            definition = "תַּשְׁלוּם רִאשׁוֹנִי שֶׁלּוֹקְחִים לְפָנִים לִקְנוֹת אֶת הַסְּחוֹרָה לִפְרוֹיֶקְט.",
            definitionNative = "Первая выплата вперёд — на покупку материалов для проекта.",
            example = "מִקְדָּמָה עַל חוֹמְרִים מְקֻבֶּלֶת בָּעֵסֶק וְעוֹמֶדֶת עַל שְׁלִישׁ.",
            exampleNative = "מִקְדָּמָה עַל חוֹמְרִים принята в отрасли и составляет треть.",
         fillInBlankExclusions = listOf(180111L, 180112L, 180113L, 180114L)),

        // ── plumber_specialty (5) — специальные направления сантехники ──
        WordEntity(
            id = 180116, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_specialty", transliteration = "khibur gaz",
            original = "חִבּוּר גָּז", translation = "газовое подключение",
            definition = "עֲבוֹדָה מִיֻחֶדֶת עִם דֶּלֶק בִּטִיחוּתִי הַטָּעוּן רִשָּׁיוֹן נִפְרָד מֵהַמְּדִינָה.",
            definitionNative = "Особая работа с топливом, требующая отдельного государственного разрешения.",
            example = "חִבּוּר גָּז לְכִירָה חֲדָשָׁה בִּצַּעְתִּי בְּהַשְׁגָּחַת מְפַקֵּחַ.",
            exampleNative = "חִבּוּר גָּז к новой плите я провёл под наблюдением инспектора.",
         fillInBlankExclusions = listOf(180117L, 180118L, 180119L, 180120L)),
        WordEntity(
            id = 180117, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_specialty", transliteration = "tsinrur nistar",
            original = "צִנְרוּר נִסְתָּר", translation = "скрытая разводка",
            definition = "הַעֲבָרַת קַוִּים בְּתוֹךְ הַקִּירוֹת אוֹ הָרִצְפָּה — לֹא רוֹאִים אוֹתָם בַּחֶדֶר.",
            definitionNative = "Прокладка линий внутри стен или пола — в комнате их не видно.",
            example = "צִנְרוּר נִסְתָּר דּוֹרֵשׁ דִּיּוּק רַב — אֵין לְתַקֵּן אַחֲרֵי הַצְּבִיעָה.",
            exampleNative = "צִנְרוּר נִסְתָּר требует точности — после покраски уже не починить.",
         fillInBlankExclusions = listOf(180116L, 180118L, 180119L, 180120L)),
        WordEntity(
            id = 180118, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_specialty", transliteration = "makhalif khom",
            original = "מַחֲלִיף חוֹם", translation = "теплообменник (косвенный нагрев)",
            definition = "מַתְקָן שֶׁמַּעֲבִיר חֹם בֵּין שְׁתֵּי מַעֲרָכוֹת מַיִם בְּלִי שֶׁיִּתְעָרְבוּ.",
            definitionNative = "Установка, передающая тепло между двумя контурами воды без их смешивания.",
            example = "מַחֲלִיף חוֹם מְבוֹדֵד אֶת מַיִם הַשְּׁתִיָּה מִמַּעֲרֶכֶת הַחִמּוּם.",
            exampleNative = "מַחֲלִיף חוֹם изолирует питьевую воду от системы отопления.",
         fillInBlankExclusions = listOf(180116L, 180117L, 180119L, 180120L)),
        WordEntity(
            id = 180119, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_specialty", transliteration = "maarekhet tihur shofkhin",
            original = "מַעֲרֶכֶת טִהוּר שׁוֹפְכִין", translation = "очистные сооружения",
            definition = "מִתְקָן שֶׁמְּקַבֵּל מַיִם מְלֻכְלָכִים מֵהָעִיר וּמַחְזִיר אוֹתָם נְקִיִּים לַטֶּבַע.",
            definitionNative = "Установка, принимающая грязные стоки города и возвращающая их чистыми в природу.",
            example = "מַעֲרֶכֶת טִהוּר שׁוֹפְכִין שִׁדְרוּג גָּדוֹל בִּרְבָעוֹן הַקָּרוֹב.",
            exampleNative = "מַעֲרֶכֶת טִהוּר שׁוֹפְכִין ждёт большая модернизация в ближайшем квартале.",
         fillInBlankExclusions = listOf(180116L, 180117L, 180118L, 180120L)),
        WordEntity(
            id = 180120, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_specialty", transliteration = "shikum tashtit mayim",
            original = "שִׁקּוּם תַּשְׁתִּית מַיִם", translation = "реконструкция водной инфраструктуры",
            definition = "הַחְלָפָה כּוֹלֶלֶת שֶׁל קַוִּים יְשָׁנִים בְּשָׁכוּנָה אוֹ בְּבִנְיָן וָתִיק.",
            definitionNative = "Полная замена старых линий в районе или старом здании.",
            example = "שִׁקּוּם תַּשְׁתִּית מַיִם בִּשְׁכוּנָה הַוָּתִיקָה נִמְשַׁךְ שָׁנָה תְּמִימָה.",
            exampleNative = "שִׁקּוּם תַּשְׁתִּית מַיִם в старом квартале длился целый год.",
         fillInBlankExclusions = listOf(180116L, 180117L, 180118L, 180119L)),

        // ── plumber_safety (5) — охрана труда и риски ──
        WordEntity(
            id = 180121, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_safety", transliteration = "klalei btikhut",
            original = "כְּלָלֵי בְּטִיחוּת", translation = "правила охраны труда (техника безопасности)",
            definition = "רְשִׁימַת הַנְחָיוֹת לְהָגֵן עַל הָעוֹבֵד מִפְּגִיעוֹת בִּזְמַן הָעֲבוֹדָה.",
            definitionNative = "Список инструкций, защищающих работника от травм во время работы.",
            example = "כְּלָלֵי בְּטִיחוּת אֲנִי תּוֹלֶה עַל הַקִּיר בְּכָל אֲתַר חָדָשׁ.",
            exampleNative = "כְּלָלֵי בְּטִיחוּת я вешаю на стену на каждом новом объекте.",
         fillInBlankExclusions = listOf(180122L, 180123L, 180124L, 180125L)),
        WordEntity(
            id = 180122, setId = 1801, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "plumber_safety", transliteration = "tsiyud magen ishi",
            original = "צִיּוּד מָגֵן אִישִׁי", translation = "средства индивидуальной защиты (СИЗ)",
            definition = "חֲפָצִים שֶׁלּוֹבְשִׁים — קַסְדָּה, כְּפָפוֹת, מִשְׁקָפַיִם — לִפְנֵי כְּנִיסָה לָאֲתָר.",
            definitionNative = "Вещи, которые надевают — каска, перчатки, очки — перед входом на объект.",
            example = "בְּלִי צִיּוּד מָגֵן אִישִׁי הַמְּפַקֵּחַ פָּשׁוּט סָגַר אוֹתִי בַּחוּץ.",
            exampleNative = "Без צִיּוּד מָגֵן אִישִׁי инспектор просто закрыл мне вход.",
         fillInBlankExclusions = listOf(180121L, 180123L, 180124L, 180125L)),
        WordEntity(
            id = 180123, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_safety", transliteration = "kisuy nezakim",
            original = "כִּסּוּי נְזָקִים", translation = "страховое покрытие ущерба",
            definition = "הַסְכֵּם עִם חֶבְרָה שֶׁמַּחֲזִירָה כֶּסֶף אִם פָּרַץ נֵזֶק לַשָּׁכֵן בִּגְלַל הָעֲבוֹדָה.",
            definitionNative = "Соглашение с компанией, возмещающее убыток соседу при аварии из-за работы.",
            example = "כִּסּוּי נְזָקִים שֶׁל הַחֶבְרָה שִׁלֵּם לִשְׁכֵנֵינוּ עֲשֶׂרֶת אֲלָפִים שֶׁקֶל.",
            exampleNative = "כִּסּוּי נְזָקִים компании выплатил соседям десять тысяч шекелей.",
         fillInBlankExclusions = listOf(180121L, 180122L, 180124L, 180125L)),
        WordEntity(
            id = 180124, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_safety", transliteration = "nituakh sikunim",
            original = "נִתּוּחַ סִכּוּנִים", translation = "оценка рисков",
            definition = "מַחְשָׁבָה שִׁיטָתִית לִפְנֵי הַתְחָלָה — מַה יָכוֹל לְהִשְׁתַּבֵּשׁ וּמַה נַעֲשֶׂה אָז.",
            definitionNative = "Системное обдумывание до старта — что может пойти не так и что мы тогда сделаем.",
            example = "נִתּוּחַ סִכּוּנִים גִּלָּה אֶפְשָׁרוּת שֶׁל הֶצֶּף בַּחֲנִיָּה.",
            exampleNative = "נִתּוּחַ סִכּוּנִים выявил вероятность затопления в подземном паркинге.",
         fillInBlankExclusions = listOf(180109L, 180121L, 180122L, 180123L, 180125L)),
        WordEntity(
            id = 180125, setId = 1801, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "plumber_safety", transliteration = "nohal kherum",
            original = "נֹהַל חֵרוּם", translation = "аварийный протокол",
            definition = "סֵדֶר פְּעֻלּוֹת קָבוּעַ מֵרֹאשׁ — מָה עוֹשִׂים אִם פָּרַץ אָסוֹן בָּאֲתָר.",
            definitionNative = "Заранее установленный порядок действий — что делать при ЧП на объекте.",
            example = "נֹהַל חֵרוּם כָּתוּב בְּקֹבֶץ נָגִישׁ לְכָל חֲבֵרֵי הַצֶּוֶת.",
            exampleNative = "נֹהַל חֵרוּם записан в файле, доступном всему составу бригады.",
         fillInBlankExclusions = listOf(180121L, 180122L, 180123L, 180124L)),
    )
}
