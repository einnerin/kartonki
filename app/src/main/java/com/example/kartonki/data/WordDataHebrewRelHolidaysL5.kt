package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — Религия и праздники L5 (set 1711).
 * 25 слов уровня C2+: академический религиоведческий дискурс о праздниках и обрядах —
 * литургиология, антропология ритуала, история литургии, реконструкция обрядов,
 * талмудический календарный дискурс, символизм и поэтика праздников.
 *
 * Дубли с темами «Религия и праздники» (1109, 1119, 1162, 1198, 1305, 1512, 1513, 1710)
 * и «Религия» (1053, 1070, 1071, 1282, 1283, 1284) проверены grep'ом — пересечений нет.
 *
 * Распределение: 20 LEGENDARY + 5 EPIC (2 смежных уровня по rarity).
 *
 * 5 семантических групп по 5 слов («опасные близнецы» внутри каждой):
 *  - religion_liturgy_studies      — литургиология как наука
 *  - religion_ritual_anthropology  — антропология ритуала
 *  - religion_calendar_studies     — научный дискурс о календаре
 *  - religion_aggadic_studies      — агадистика и гомилетика
 *  - religion_festival_symbolism   — типология и поэтика праздников
 */
object WordDataHebrewRelHolidaysL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1711, languagePair = "he-ru", orderIndex = 211,
            name = "Религия и праздники",
            description = "Академический религиоведческий дискурс о праздниках и обрядах",
            topic = "Религия и праздники", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ════════════════════════════════════════════════════════════════════
        // Set 1711 — Религия и праздники L5: академическая литургиология
        // 5 групп × 5 слов; 5 EPIC + 20 LEGENDARY
        // ════════════════════════════════════════════════════════════════════

        // ── religion_liturgy_studies (5 — 1 EPIC + 4 LEGENDARY) ──
        WordEntity(
            id = 171101, setId = 1711, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "religion_liturgy_studies", transliteration = "liturgya",
            original = "לִיטוּרְגְיָה", translation = "литургия (богослужебный чин)",
            definition = "מַעֲרֶכֶת קְבוּעָה שֶׁל תְּפִלּוֹת וּקְרִיאוֹת בִּזְמַן עֲבוֹדַת אֱלֹהִים בַּצִּבּוּר.",
            definitionNative = "Устойчивый порядок молитв и чтений, сопровождающих общественное богослужение.",
            example = "חוֹקְרֵי הַלִּיטוּרְגְיָה מַשְׁווִים נֻסְחָאוֹת מִתְּקוּפוֹת שׁוֹנוֹת.",
            exampleNative = "Исследователи сравнивают тексты לִיטוּרְגְיָה из разных эпох.",
        ),
        WordEntity(
            id = 171102, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "religion_liturgy_studies", transliteration = "teologya liturgit",
            original = "תֵּיאוֹלוֹגְיָה לִיטוּרְגִית", translation = "литургическая теология",
            definition = "עִיּוּן שִׁיטָתִי בְּמַשְׁמְעוּת אֱמוּנִית שֶׁל סֵדֶר עֲבוֹדַת הַצִּבּוּר.",
            definitionNative = "Систематическое осмысление вероучительного смысла, заложенного в чин общественной службы.",
            example = "תֵּיאוֹלוֹגְיָה לִיטוּרְגִית מְפָרֶשֶׁת אֶת מַשְׁמְעוּת בִּרְכוֹת הַשַּׁחַר.",
            exampleNative = "תֵּיאוֹלוֹגְיָה לִיטוּרְגִית раскрывает смысл утренних благословений.",
         fillInBlankExclusions = listOf(171103L, 171104L, 171105L)),
        WordEntity(
            id = 171103, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "religion_liturgy_studies", transliteration = "historya liturgit",
            original = "הִיסְטוֹרְיָה לִיטוּרְגִית", translation = "история литургии",
            definition = "עִיּוּן בְּהִתְהַוּוּת סִדְרֵי תְּפִלָּה לְאֹרֶךְ מֵאוֹת הַשָּׁנִים שֶׁל גָּלוּת וְקִבּוּץ.",
            definitionNative = "Изучение того, как складывались чины молитвы на протяжении веков скитаний и собирания.",
            example = "הִיסְטוֹרְיָה לִיטוּרְגִית מַרְאָה אֶת מָקוֹר הַפִּיּוּטִים הָעַתִּיקִים.",
            exampleNative = "הִיסְטוֹרְיָה לִיטוּרְגִית раскрывает корни древнейших гимнов.",
         fillInBlankExclusions = listOf(171102L, 171104L, 171105L)),
        WordEntity(
            id = 171104, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "religion_liturgy_studies", transliteration = "filologya liturgit",
            original = "פִּילוֹלוֹגְיָה לִיטוּרְגִית", translation = "литургическая филология",
            definition = "עִיּוּן בִּלְשׁוֹן הַתְּפִלָּה וּבִתְבָנוֹת הַטֶּקְסְט שֶׁל סִדּוּרִים עַתִּיקִים.",
            definitionNative = "Изучение языка молитвы и текстуальных особенностей древних молитвенников.",
            example = "פִּילוֹלוֹגְיָה לִיטוּרְגִית חוֹשֶׂפֶת שִׁכְבוֹת לְשׁוֹן בְּסִדּוּר עַתִּיק.",
            exampleNative = "פִּילוֹלוֹגְיָה לִיטוּרְגִית обнажает языковые слои в древнем молитвеннике.",
         fillInBlankExclusions = listOf(171102L, 171103L, 171105L)),
        WordEntity(
            id = 171105, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "religion_liturgy_studies", transliteration = "protoliturgya",
            original = "פְּרוֹטוֹלִיטוּרְגְיָה", translation = "протолитургия (древнейшие формы богослужения)",
            definition = "צוּרוֹת קְדוּמוֹת שֶׁל עֲבוֹדַת הַצִּבּוּר טֶרֶם הִתְקַבְּעוּ נֻסְחָאוֹת מְקוּבָּלוֹת.",
            definitionNative = "Древнейшие формы общественного богослужения до закрепления привычных нам канонов.",
            example = "פְּרוֹטוֹלִיטוּרְגְיָה מְשׁוּחְזֶרֶת מִכִּתְבֵי קֻמְרָאן וּבָתֵּי כְּנֶסֶת קְדוּמִים.",
            exampleNative = "פְּרוֹטוֹלִיטוּרְגְיָה восстанавливается по кумранским свиткам и древним синагогам.",
         fillInBlankExclusions = listOf(171102L, 171103L, 171104L)),

        // ── religion_ritual_anthropology (5 — 1 EPIC + 4 LEGENDARY) ──
        WordEntity(
            id = 171106, setId = 1711, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "religion_ritual_anthropology", transliteration = "pulkhan",
            original = "פּוּלְחָן", translation = "культ (религиозная обрядовая система)",
            definition = "מַעֲרֶכֶת מַאֲזֶרֶת שֶׁל מַעֲשִׂים מְקוּדָּשִׁים סְבִיב דְּמוּת אוֹ אִידֵיאָה אֱלֹהִית.",
            definitionNative = "Связная система священнодействий, выстроенная вокруг божества или сакральной идеи.",
            example = "אַנְתְּרוֹפּוֹלוֹגִים מַשְׁווִים פּוּלְחָן יְהוּדִי לְזֶה שֶׁל עַמֵּי קֶדֶם.",
            exampleNative = "Антропологи сопоставляют еврейский פּוּלְחָן с обычаями древних народов.",
         fillInBlankExclusions = listOf(171108L, 171109L, 171110L)),
        WordEntity(
            id = 171107, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "religion_ritual_anthropology", transliteration = "ma'avar tiksi",
            original = "מַעֲבָר טִקְסִי", translation = "обряд перехода (rite de passage)",
            definition = "טֶקֶס הַמְּלַוֶּה מַעֲבָר חַיִּים — לֵדָה, בַּגְרוּת, נִשּׂוּאִין אוֹ פְּטִירָה.",
            definitionNative = "Церемония, сопровождающая жизненный рубеж — рождение, взросление, брак или смерть.",
            example = "בְּרִית מִילָה הִיא מַעֲבָר טִקְסִי קָלָאסִי בַּמָּסֹרֶת הַיְּהוּדִית.",
            exampleNative = "Брит-мила — классический מַעֲבָר טִקְסִי еврейской традиции.",
        ),
        WordEntity(
            id = 171108, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_ritual_anthropology", transliteration = "initsiatsya",
            original = "אִינִיצִיאַצְיָה", translation = "инициация (ритуал посвящения)",
            definition = "טֶקֶס שֶׁבּוֹ הַמִּשְׁתַּתֵּף נִכְנָס לִקְבוּצָה מְקוּדֶשֶׁת אוֹ לְמַעֲמָד חָדָשׁ.",
            definitionNative = "Церемония, через которую участник входит в новый сакральный статус или круг.",
            example = "אִינִיצִיאַצְיָה שֶׁל בַּר מִצְוָה מְצַיֶּנֶת אֶת הַכְּנִיסָה לְעוֹל הַמִּצְווֹת.",
            exampleNative = "אִינִיצִיאַצְיָה бар-мицвы знаменует вход в круг религиозных обязанностей.",
         fillInBlankExclusions = listOf(171106L, 171109L, 171110L)),
        WordEntity(
            id = 171109, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_ritual_anthropology", transliteration = "sinkretizm",
            original = "סִינְקְרֵטִיזְם", translation = "синкретизм (слияние религиозных традиций)",
            definition = "שִׁלּוּב שִׁכְבוֹת שֶׁל מָסֹרוֹת שׁוֹנוֹת בְּתוֹךְ טֶקֶס מְקוּדָּשׁ אֶחָד.",
            definitionNative = "Сплетение разных религиозных слоёв внутри одной священной церемонии.",
            example = "מִנְהֲגֵי תַּשְׁלִיךְ נֶחְקָרִים כְּסִינְקְרֵטִיזְם שֶׁל מוֹטִיבִים קְדוּמִים.",
            exampleNative = "Обряд ташлих изучают как סִינְקְרֵטִיזְם древних мотивов разных культур.",
         fillInBlankExclusions = listOf(171106L, 171108L, 171110L)),
        WordEntity(
            id = 171110, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_ritual_anthropology", transliteration = "praksis",
            original = "פְּרַקְסִיס", translation = "праксис (ритуальная практика)",
            definition = "מִמַּד הַמַּעֲשֶׂה הַטֶּקְסִי עַצְמוֹ — לְהַבְדִּיל מִדּוֹקְטְרִינָה אוֹ אֱמוּנָה.",
            definitionNative = "Сторона деятельная, телесная — в отличие от учения и веры на словах.",
            example = "אַנְתְּרוֹפּוֹלוֹגִים מְבַכְּרִים מֶחְקַר פְּרַקְסִיס עַל פְּנֵי הַצְהָרוֹת אֱמוּנָה.",
            exampleNative = "Антропологи предпочитают изучать פְּרַקְסִיס, а не словесные исповедания веры.",
         fillInBlankExclusions = listOf(171106L, 171108L, 171109L)),

        // ── religion_calendar_studies (5 — 1 EPIC + 4 LEGENDARY) ──
        WordEntity(
            id = 171111, setId = 1711, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "religion_calendar_studies", transliteration = "moadim",
            original = "מוֹעֲדִים", translation = "моадим (религиозные праздничные дни)",
            definition = "יָמִים מְקוּדָּשִׁים הַקְּבוּעִים לוּחַ הַשָּׁנָה הַיְּהוּדִי וּלְעֶצֶם הַזְּמַן הַקָּדוֹשׁ.",
            definitionNative = "Священные даты, на которых строится весь сакральный годовой цикл народа.",
            example = "מֶחְקָר הַמּוֹעֲדִים בּוֹחֵן אֶת הִתְפַּתְּחוּת הַלּוּחַ הַתַּלְמוּדִי.",
            exampleNative = "Изучение מוֹעֲדִים прослеживает развитие талмудического календаря.",
        ),
        WordEntity(
            id = 171112, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_calendar_studies", transliteration = "kronologya",
            original = "כְּרוֹנוֹלוֹגְיָה", translation = "хронология (научное упорядочение времени)",
            definition = "מַעֲרֶכֶת אֲקָדֵמִית שֶׁל סִדּוּר אֵרוּעִים וּתְקוּפוֹת לְפִי רֶצֶף הַזְּמַן.",
            definitionNative = "Научный способ упорядочивания событий и эпох по их последовательности во времени.",
            example = "הַתַּלְמוּד דָּן בִּכְרוֹנוֹלוֹגְיָה שֶׁל יְצִירַת הָעוֹלָם.",
            exampleNative = "Талмуд обсуждает כְּרוֹנוֹלוֹגְיָה сотворения мира по годам.",
        ),
        WordEntity(
            id = 171113, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_calendar_studies", transliteration = "periodizatsya",
            original = "פֵּרִיוֹדִיזַצְיָה", translation = "периодизация (разбиение времени на эпохи)",
            definition = "חֲלוּקָה אֲקָדֵמִית שֶׁל זְמַן רָצוּף לִתְקוּפוֹת בַּעֲלוֹת מַאֲפְיָנִים מְשׁוּתָּפִים.",
            definitionNative = "Научное разбиение непрерывного времени на эпохи с общими признаками.",
            example = "פֵּרִיוֹדִיזַצְיָה שֶׁל הַחַגִּים מַבְחִינָה בֵּין מִקְרָאִי לְמִשְׁנָאִי.",
            exampleNative = "פֵּרִיוֹדִיזַצְיָה праздников разделяет библейский и мишнаитский слои.",
         fillInBlankExclusions = listOf(171111L, 171112L, 171115L)),
        WordEntity(
            id = 171114, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "religion_calendar_studies", transliteration = "luakh ivri",
            original = "לוּחַ עִבְרִי", translation = "еврейский календарь (как объект изучения)",
            definition = "מַעֲרֶכֶת לוּחַ יָרֵחַ-שֶׁמֶשׁ הַקּוֹבַעַת אֶת זְמַנֵּי הַחַגִּים בַּמָּסֹרֶת.",
            definitionNative = "Лунно-солнечная система счисления, определяющая даты праздников в традиции.",
            example = "מֶחְקַר לוּחַ עִבְרִי דּוֹרֵשׁ יְדִיעָה בְּאַסְטְרוֹנוֹמְיָה קְדוּמָה.",
            exampleNative = "Изучение לוּחַ עִבְרִי требует знания древней астрономии.",
        ),
        WordEntity(
            id = 171115, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_calendar_studies", transliteration = "efemeriyut",
            original = "אֶפֵמֵרִיוֹת", translation = "эфемеридность (астрономические таблицы и расчёты)",
            definition = "טַבְלָאוֹת חִישׁוּב שֶׁל מְקוֹמוֹת כּוֹכָבִים, שִׁמְּשׁוּ לִקְבִיעַת הַלּוּחַ הַקָּדוּם.",
            definitionNative = "Таблицы расчёта движения светил, использовавшиеся для определения древнего календаря.",
            example = "טַבְלוֹת אֶפֵמֵרִיוֹת מַסְבִּירוֹת אֶת קְבִיעַת רֹאשׁ חֹדֶשׁ עַל פִּי הָרְאִיָּה.",
            exampleNative = "Таблицы אֶפֵמֵרִיוֹת показывают, как объявлялся новомесячный отсчёт по виду луны.",
         fillInBlankExclusions = listOf(171111L, 171112L, 171113L)),

        // ── religion_aggadic_studies (5 — 1 EPIC + 4 LEGENDARY) ──
        WordEntity(
            id = 171116, setId = 1711, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "religion_aggadic_studies", transliteration = "egzegeza",
            original = "אֶגְזֶגֵזָה", translation = "экзегеза (научное толкование сакрального текста)",
            definition = "מַעֲשֶׂה שִׁיטָתִי שֶׁל פֵּרוּשׁ הַטֶּקְסְט הַקָּדוֹשׁ בִּכְלֵי הַחֵקֶר הָאֲקָדֵמִי.",
            definitionNative = "Систематическое разъяснение священного текста инструментами научного анализа.",
            example = "אֶגְזֶגֵזָה מוֹדֶרְנִית מְשַׁלֶּבֶת הִיסְטוֹרְיָה, לְשׁוֹן וְסִפְרוּת הַשְׁוָאָתִית.",
            exampleNative = "Современная אֶגְזֶגֵזָה соединяет историю, лингвистику и сравнительную литературу.",
         fillInBlankExclusions = listOf(171117L, 171118L, 171119L)),
        WordEntity(
            id = 171117, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_aggadic_studies", transliteration = "agadistika",
            original = "אַגָדִיסְטִיקָה", translation = "агадистика (наука об агадическом наследии)",
            definition = "תְּחוּם אֲקָדֵמִי הַחוֹקֵר אֶת סִפּוּרֵי חַזַ\"ל וּמַשְׁמְעוּתָם הַסִּפְרוּתִית.",
            definitionNative = "Научная дисциплина, изучающая повествовательное наследие мудрецов и его смысл.",
            example = "אַגָדִיסְטִיקָה מַשְׁווֶה גִּרְסָאוֹת שֶׁל סִיפּוּרֵי הַתַּלְמוּד הַבַּבְלִי וְהַיְרוּשַׁלְמִי.",
            exampleNative = "אַגָדִיסְטִיקָה сличает версии преданий вавилонского и иерусалимского сводов.",
         fillInBlankExclusions = listOf(171116L, 171118L, 171119L)),
        WordEntity(
            id = 171118, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_aggadic_studies", transliteration = "homiletika",
            original = "הוֹמִילֵטִיקָה", translation = "гомилетика (теория религиозной проповеди)",
            definition = "תּוֹרַת הַדְּרָשָׁה הַפּוּמְבִּית, הַחוֹקֶרֶת מִבְנֶה וּתְכָנִים שֶׁל פְּנִיָּה לַקָּהָל.",
            definitionNative = "Учение о публичной проповеди — её строении, темах и обращении к слушателям.",
            example = "הוֹמִילֵטִיקָה יְהוּדִית פּוֹרַחַת בִּתְקוּפַת הַגְּאוֹנִים וְהָרִאשׁוֹנִים.",
            exampleNative = "Еврейская הוֹמִילֵטִיקָה расцветает в эпоху гаонов и ришоним.",
         fillInBlankExclusions = listOf(171116L, 171117L, 171119L)),
        WordEntity(
            id = 171119, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_aggadic_studies", transliteration = "hagiografya",
            original = "הַגִּיוֹגְרַפְיָה", translation = "агиография (жития праведников)",
            definition = "סוּגָה סִפְרוּתִית הַמְּתָאֶרֶת חַיֵּי צַדִּיקִים וְנִיסָּם בַּמָּסֹרֶת הַדָּתִית.",
            definitionNative = "Литературный жанр, описывающий жития подвижников и совершённые ими чудеса.",
            example = "הַגִּיוֹגְרַפְיָה חֲסִידִית מְשַׁמֶּרֶת אֶת זִכְרוֹן הָרַבִּיִּים הַקְּדוּמִים.",
            exampleNative = "Хасидская הַגִּיוֹגְרַפְיָה сохраняет память о ранних цадиках движения.",
         fillInBlankExclusions = listOf(171116L, 171117L, 171118L)),
        WordEntity(
            id = 171120, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "religion_aggadic_studies", transliteration = "midrash agada",
            original = "מִדְרַשׁ אַגָּדָה", translation = "мидраш агада (наративный мидраш)",
            definition = "סוּג שֶׁל פֵּרוּשׁ סִפּוּרִי הַמַּרְחִיב פְּסוּקֵי תּוֹרָה דֶּרֶךְ דִּמְיוֹן יוֹצֵר.",
            definitionNative = "Тип повествовательного толкования, расширяющий стих Писания живым воображением.",
            example = "מִדְרַשׁ אַגָּדָה מוֹסִיף פְּרָטִים סִפּוּרִיִּים לִקְמוּצֵי הַתּוֹרָה.",
            exampleNative = "מִדְרַשׁ אַגָּדָה дополняет лаконичные стихи Писания живыми деталями.",
        ),

        // ── religion_festival_symbolism (5 — 1 EPIC + 4 LEGENDARY) ──
        WordEntity(
            id = 171121, setId = 1711, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "religion_festival_symbolism", transliteration = "semyotika",
            original = "סֶמְיוֹטִיקָה", translation = "семиотика (наука о знаках и смыслах)",
            definition = "תְּחוּם מֶחְקָר הַבּוֹחֵן אֵיךְ סְמָלִים יוֹצְרִים מַשְׁמְעוּת בְּטֶקֶס וּבְשָׂפָה.",
            definitionNative = "Дисциплина, изучающая, как знаки порождают смысл в обряде и языке.",
            example = "סֶמְיוֹטִיקָה שֶׁל הַסֵּדֶר חוֹקֶרֶת אֶת מַעֲמַד הַמַּצָּה וְהַמָּרוֹר.",
            exampleNative = "סֶמְיוֹטִיקָה седера разбирает роль мацы и горьких трав.",
         fillInBlankExclusions = listOf(171122L, 171123L, 171124L)),
        WordEntity(
            id = 171122, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_festival_symbolism", transliteration = "ikonografya",
            original = "אִיקוֹנוֹגְרַפְיָה", translation = "иконография (изучение визуальной символики)",
            definition = "מֶחְקָר שִׁיטָתִי שֶׁל מוֹטִיבִים וִויזוּאָלִיִּים בְּאָמָּנוּת מְקוּדֶשֶׁת.",
            definitionNative = "Систематическое исследование зрительных мотивов священного искусства.",
            example = "אִיקוֹנוֹגְרַפְיָה שֶׁל פָּסוּקֵי מְגִלּוֹת מַרְאָה הַשְׁפָּעוֹת בִּיזַנְטִיוֹת.",
            exampleNative = "אִיקוֹנוֹגְרַפְיָה иллюстрированных свитков выдаёт византийское влияние.",
         fillInBlankExclusions = listOf(171121L, 171123L, 171124L)),
        WordEntity(
            id = 171123, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_festival_symbolism", transliteration = "tipologya",
            original = "טִיפּוֹלוֹגְיָה", translation = "типология (классификация по типам)",
            definition = "שִׁיטָה מַחֲקָרִית הַמְחַלֶּקֶת תּוֹפָעוֹת לְקוֹלוֹת מְשׁוּתָּפֵי תְּכוּנוֹת יְסוֹד.",
            definitionNative = "Метод, делящий явления на классы по основным общим признакам.",
            example = "טִיפּוֹלוֹגְיָה שֶׁל חַגִּים מַבְחִינָה בֵּין צַעֲדֵי תְּשׁוּבָה לְשִׂמְחָה.",
            exampleNative = "טִיפּוֹלוֹגְיָה праздников разделяет дни покаяния и дни ликования.",
         fillInBlankExclusions = listOf(171121L, 171122L, 171124L)),
        WordEntity(
            id = 171124, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "religion_festival_symbolism", transliteration = "arkhetip",
            original = "אַרְכֵיטִיפּ", translation = "архетип (первообраз в коллективной памяти)",
            definition = "דְּמוּת יְסוֹד שֶׁחוֹזֶרֶת בִּסְפָרוֹת וּבְפוּלְחָנִים שֶׁל תַּרְבּוּיוֹת רַבּוֹת.",
            definitionNative = "Первообраз, повторяющийся в литературе и обрядах множества разных культур.",
            example = "אַרְכֵיטִיפּ הַגֵּרוּשׁ וְהַשִּׁיבָה מַנְחֶה אֶת לוּחַ הַחַגִּים הַיְּהוּדִי.",
            exampleNative = "אַרְכֵיטִיפּ изгнания и возвращения пронизывает весь годовой цикл праздников.",
        ),
        WordEntity(
            id = 171125, setId = 1711, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "religion_festival_symbolism", transliteration = "poetika liturgit",
            original = "פּוֹאֶטִיקָה לִיטוּרְגִית", translation = "литургическая поэтика",
            definition = "מַעֲרֶכֶת אֶמְצָעִים סִפְרוּתִיִּים שֶׁל פִּיּוּטֵי הַחַגִּים — חֲרוּז, מִשְׁקָל, רֶמֶז.",
            definitionNative = "Поэтические приёмы праздничных гимнов — рифма, размер, образный намёк.",
            example = "פּוֹאֶטִיקָה לִיטוּרְגִית שֶׁל הַקַּלִּיר נִלְמֶדֶת בָּאוּנִיבֶרְסִיטָאוֹת בָּעוֹלָם.",
            exampleNative = "פּוֹאֶטִיקָה לִיטוּרְגִית раби Калира преподают в университетах по всему миру.",
        ),
    )
}
