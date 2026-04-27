package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Дети и школа в Израиле", уровень L5 (носитель языка).
 *
 * Set 1816: «Дети и школа в Израиле» — носитель языка (EPIC + LEGENDARY).
 *           Образовательная политика Израиля (Министерство образования,
 *           реформы), академический иврит и научные тезисы, педагогические
 *           методики и течения, аккредитация и стандарты экзаменов,
 *           школьная администрация и инфраструктура.
 *
 * Аудитория — русскоязычные родители-олим, готовящие детей к багруту;
 * учителя в системе מַמְלַכְתִּי; авторы курсов и методисты; родительские
 * представители на уровне ועד הורים ארצי. Лексика реальная, та, что
 * звучит на конференциях Минобраза, в академических работах и в
 * протоколах педсоветов.
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   school_policy_he       — образовательная политика Израиля:
 *     Минобразование, реформа Дов'рот, единый тариф,
 *     общенациональный родкомитет, обязательное образование
 *   school_academic_lex    — академический иврит:
 *     тезис исследования, гипотеза, библиография, методология,
 *     рецензированная статья
 *   school_pedagogy        — педагогические течения и методики:
 *     Монтессори, дифференцированное обучение, проектное обучение,
 *     эмоциональное воспитание, инклюзивное образование
 *   school_assessment      — аккредитация и стандарты:
 *     багрут, мейцав, психометрический тест, аккредитация,
 *     внешняя оценка
 *   school_admin_infra     — администрация и инфраструктура:
 *     директор школы, школьный кампус, педагогический совет,
 *     инспекция, классный руководитель (старшая ступень)
 *
 * Word IDs: setId × 100 + position (181601..181625).
 *
 * Пересечения с другими наборами темы:
 *   - L2 (1813) содержит ган, цаhарон, родсобрание, кружки, режим дня —
 *     базовый бытовой слой школы. Здесь — академический и стратегический
 *     слой над ним: политика, методики, экзамены, администрация.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них
 * отключён, пока LLM-pipeline не пройдёт по набору и не проставит
 * fillInBlankExclusions.
 */
object WordDataHebrewSchoolL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1816,
            languagePair = "he-ru",
            orderIndex = 1816,
            name = "Дети и школа в Израиле",
            description = "Уровень носителя: академический иврит, образовательная политика, реформы системы образования",
            topic = "Дети и школа в Израиле",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1816 — Дети и школа в Израиле: носитель языка (L5, EPIC+LEGENDARY)
        // 5 групп × 5 слов: policy_he, academic_lex, pedagogy,
        //                   assessment, admin_infra
        // ══════════════════════════════════════════════════════════════════════

        // ── school_policy_he (5) — образовательная политика Израиля ──
        WordEntity(
            id = 181601, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_policy_he", transliteration = "misrád hakhinúkh",
            original = "מִשְׂרַד הַחִנּוּךְ", translation = "Министерство образования",
            definition = "מוֹסָד מֶמְשַׁלְתִּי שֶׁקּוֹבֵעַ אֶת מַדִּינִיּוּת הַלִּמּוּדִים בְּכָל בָּתֵּי הַסֵּפֶר.",
            definitionNative = "Государственный орган, который задаёт правила учёбы для всех школ страны.",
            example = "מִשְׂרַד הַחִנּוּךְ פִּרְסֵם הַנְחָיוֹת חֲדָשׁוֹת לִקְרַאת הַשָּׁנָה.",
            exampleNative = "Министерство образования выпустило новые указания к учебному году.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181602, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_policy_he", transliteration = "réformat dovrát",
            original = "רֵפוֹרְמַת דּוֹבְרָת", translation = "реформа Доврат",
            definition = "תָּכְנִית לְשִׁנּוּי מַעֲרֶכֶת הַחִנּוּךְ שֶׁהֻצְעָה בִּשְׁנַת אַלְפַּיִם וְאַרְבַּע.",
            definitionNative = "План перестройки израильской системы школ, предложенный в две тысячи четвёртом году.",
            example = "רֵפוֹרְמַת דּוֹבְרָת הִצִּיעָה לְקַצֵּר אֶת מִסְפַּר הַתַּלְמִידִים בַּכִּתָּה.",
            exampleNative = "Реформа Доврат предлагала уменьшить число учеников в классе.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181603, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_policy_he", transliteration = "khinúkh khová",
            original = "חִנּוּךְ חוֹבָה", translation = "обязательное образование",
            definition = "חוֹק שֶׁמְּחַיֵּב כָּל יֶלֶד בְּגִיל מְסֻיָּם לְהַגִּיעַ לְמוֹסַד לִמּוּדִים.",
            definitionNative = "Закон, по которому каждый ребёнок определённого возраста должен ходить в учебное заведение.",
            example = "חִנּוּךְ חוֹבָה בְּיִשְׂרָאֵל מַתְחִיל מִגִּיל שָׁלוֹשׁ.",
            exampleNative = "Обязательное образование в Израиле начинается с трёх лет.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181604, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_policy_he", transliteration = "vá'ad horím artsí",
            original = "וַעַד הוֹרִים אַרְצִי", translation = "общенациональный родительский комитет",
            definition = "גּוּף שֶׁמְּיַצֵּג הוֹרִים בְּכָל הַמְּדִינָה מוּל מִשְׂרַד הַחִנּוּךְ וְהַכְּנֶסֶת.",
            definitionNative = "Орган, который представляет родителей всей страны перед министерством и парламентом.",
            example = "וַעַד הוֹרִים אַרְצִי הִתְנַגֵּד לִשְׁבִיתַת הַמּוֹרִים הַשָּׁבוּעַ.",
            exampleNative = "Общенациональный родительский комитет выступил против забастовки учителей на этой неделе.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181605, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_policy_he", transliteration = "ta'aríf akhíd",
            original = "תַּעֲרִיף אָחִיד", translation = "единый тариф родительских платежей",
            definition = "טַבְלָה רִשְׁמִית שֶׁל סְכוּמִים שֶׁמּוּתָּר לְבֵית סֵפֶר לִגְבּוֹת מֵהוֹרִים בַּשָּׁנָה.",
            definitionNative = "Официальная таблица сумм, которые школа имеет право брать с родителей за год.",
            example = "תַּעֲרִיף אָחִיד מַגְבִּיל אֶת תַּשְׁלוּמֵי הַהוֹרִים לַטִּיּוּלִים הַשְּׁנָתִיִּים.",
            exampleNative = "Единый тариф родительских платежей ограничивает оплату годовых поездок.",
            isFillInBlankSafe = false),

        // ── school_academic_lex (5) — академический иврит ──
        WordEntity(
            id = 181606, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_academic_lex", transliteration = "tezát mekhkár",
            original = "תֵּזַת מֶחְקָר", translation = "тезис исследования",
            definition = "רַעֲיוֹן מֶרְכָּזִי שֶׁעֲבוֹדָה אֲקָדֵמִית בָּאָה לְהוֹכִיחַ אוֹ לְבַסֵּס בִּרְאָיוֹת.",
            definitionNative = "Главная мысль, которую научная работа берётся доказать или подкрепить фактами.",
            example = "הַסְטוּדֶנְט הִצִּיג תֵּזַת מֶחְקָר חֲדָשָׁה בִּפְנֵי וַעֲדַת הַשִּׁפּוּט.",
            exampleNative = "Студент представил новый тезис исследования перед комиссией.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181607, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_academic_lex", transliteration = "hashará mada'ít",
            original = "הַשְׁעָרָה מַדָּעִית", translation = "научная гипотеза",
            definition = "נִחוּשׁ מְבֻסָּס שֶׁחוֹקֵר מַצִּיעַ לִפְנֵי שֶׁהוּא בּוֹדֵק אוֹתוֹ בַּמַּעֲבָדָה.",
            definitionNative = "Обоснованная догадка, которую исследователь выдвигает до проверки в лаборатории.",
            example = "הוּא בָּחַן אֶת הַהַשְׁעָרָה מַדָּעִית עִם מָאתַיִם מִשְׁתַּתְּפִים.",
            exampleNative = "Он проверил научную гипотезу с двумя сотнями участников.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181608, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_academic_lex", transliteration = "biblyográfya",
            original = "בִּיבְּלִיוֹגְרַפְיָה", translation = "библиография",
            definition = "רְשִׁימָה מְסֻדֶּרֶת שֶׁל מָקוֹרוֹת שֶׁעֲלֵיהֶם נִשְׁעֶנֶת עֲבוֹדָה אֲקָדֵמִית.",
            definitionNative = "Упорядоченный список источников, на которые опирается научная работа.",
            example = "הַמְּנַחֶה דָּרַשׁ לְהַרְחִיב אֶת הַבִּיבְּלִיוֹגְרַפְיָה לִפְנֵי הַגָּשָׁה.",
            exampleNative = "Научный руководитель потребовал расширить библиографию перед сдачей работы.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181609, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_academic_lex", transliteration = "metodológya",
            original = "מֶתוֹדוֹלוֹגְיָה", translation = "методология исследования",
            definition = "פֵּרוּט שֶׁל הַדֶּרֶךְ שֶׁבָּהּ נֶאֱסָפִים נְתוּנִים וְנִבְדָּקוֹת הַשְׁעָרוֹת בְּמֶחְקָר.",
            definitionNative = "Описание того, как в работе собирают данные и проверяют выдвинутые предположения.",
            example = "הַמֶּתוֹדוֹלוֹגְיָה שֶׁל הָעֲבוֹדָה כּוֹלֶלֶת רֵאֲיוֹנוֹת עֹמֶק.",
            exampleNative = "Методология исследования включает глубинные интервью.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181610, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_academic_lex", transliteration = "ma'amár shafút",
            original = "מַאֲמָר שָׁפוּט", translation = "рецензированная статья",
            definition = "כְּתָבָה אֲקָדֵמִית שֶׁעָבְרָה בְּדִיקָה שֶׁל מֻמְחִים אֲנוֹנִימִיִּים לִפְנֵי פִּרְסוּם.",
            definitionNative = "Научная публикация, которую перед выходом проверили анонимные эксперты в той же области.",
            example = "מַאֲמָר שָׁפוּט נֶחְשָׁב לְמָקוֹר אָמִין בְּעוֹלָם הָאַקָדֶמְיָה.",
            exampleNative = "Рецензированная статья считается надёжным источником в академическом мире.",
            isFillInBlankSafe = false),

        // ── school_pedagogy (5) — педагогические течения и методики ──
        WordEntity(
            id = 181611, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_pedagogy", transliteration = "shitát montessóri",
            original = "שִׁיטַת מוֹנְטֶסוֹרִי", translation = "методика Монтессори",
            definition = "גִּישָׁה שֶׁבָּהּ הַיֶּלֶד בּוֹחֵר בְּעַצְמוֹ פְּעִילוּת וְלוֹמֵד דֶּרֶךְ חָמָרִים מוּחָשִׁיִּים.",
            definitionNative = "Подход, при котором ребёнок сам выбирает занятие и учится через осязаемые материалы.",
            example = "שִׁיטַת מוֹנְטֶסוֹרִי מַדְגִּישָׁה עַצְמָאוּת שֶׁל הַיֶּלֶד מִגִּיל צָעִיר.",
            exampleNative = "Методика Монтессори ставит на самостоятельность ребёнка с раннего возраста.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181612, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_pedagogy", transliteration = "horaá meduyéret",
            original = "הוֹרָאָה מְדֻיֶּרֶת", translation = "дифференцированное обучение",
            definition = "סִגְנוֹן לִמּוּד שֶׁבּוֹ הַמּוֹרֶה מַתְאִים מְשִׂימוֹת לִכְשָׁרִים שׁוֹנִים בְּתוֹךְ אוֹתָהּ כִּתָּה.",
            definitionNative = "Стиль работы, при котором учитель подбирает задания под разный уровень детей в одном классе.",
            example = "הוֹרָאָה מְדֻיֶּרֶת מַצְלִיחָה לְעַזֵּר גַּם לְחַלָּשִׁים וְגַם לְמַצְטַיְּנִים.",
            exampleNative = "Дифференцированное обучение помогает и слабым, и сильным ученикам.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181613, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_pedagogy", transliteration = "limúd mevussás-proyékt",
            original = "לִמּוּד מְבֻסַּס פְּרוֹיֶקְט", translation = "проектное обучение",
            definition = "שִׁיטָה שֶׁבָּהּ תַּלְמִידִים חוֹקְרִים שְׁאֵלָה אֲמִתִּית לְאֹרֶךְ שָׁבוּעוֹת בִּמְקוֹם רַק לִשְׁמֹעַ שִׁעוּר.",
            definitionNative = "Подход, при котором ученики неделями копают настоящий вопрос вместо обычного слушания уроков.",
            example = "לִמּוּד מְבֻסַּס פְּרוֹיֶקְט מַחְלִיף מִבְחָנִים בְּהַצָּגַת חֲקִירָה לַכִּתָּה.",
            exampleNative = "Проектное обучение заменяет контрольные защитой исследования перед классом.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181614, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_pedagogy", transliteration = "khinúkh rigshí",
            original = "חִנּוּךְ רִגְשִׁי", translation = "эмоциональное воспитание",
            definition = "תְּחוּם שֶׁמְּלַמֵּד יְלָדִים לְזַהוֹת רְגָשׁוֹת שֶׁל עַצְמָם וְשֶׁל אֲחֵרִים וּלְהָגִיב נָכוֹן.",
            definitionNative = "Направление, которое учит детей распознавать чувства — свои и чужие — и грамотно на них откликаться.",
            example = "בֵּית הַסֵּפֶר הִכְנִיס תָּכְנִית שֶׁל חִנּוּךְ רִגְשִׁי לְכָל הַשְּׁכָבוֹת.",
            exampleNative = "Школа ввела программу эмоционального воспитания на всех ступенях.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181615, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_pedagogy", transliteration = "shilúv",
            original = "שִׁלּוּב", translation = "инклюзия (учеников с особыми нуждами)",
            definition = "כְּשֶׁתַּלְמִיד עִם צְרָכִים מְיֻחָדִים לוֹמֵד יַחַד עִם כֻּלָּם בַּכִּתָּה הָרְגִילָה.",
            definitionNative = "Когда ученик с особыми потребностями учится со всеми вместе в обычном классе.",
            example = "שִׁלּוּב שֶׁל יְלָדִים עִם אוֹטִיזְם דּוֹרֵשׁ סַיָּעַת אִישִׁית בַּכִּתָּה.",
            exampleNative = "Инклюзия детей с аутизмом требует личного помощника в классе.",
            isFillInBlankSafe = false),

        // ── school_assessment (5) — аккредитация и стандарты ──
        WordEntity(
            id = 181616, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_assessment", transliteration = "bagrút",
            original = "בַּגְרוּת", translation = "аттестат зрелости",
            definition = "תְּעוּדָה רִשְׁמִית שֶׁמַּקְבְּלִים בְּסוֹף הַתִּיכוֹן אַחֲרֵי שִׁשָּׁה אוֹ שִׁבְעָה מִבְחָנִים.",
            definitionNative = "Официальный документ в конце старшей школы — после шести-семи государственных экзаменов.",
            example = "בִּלְעֲדֵי בַּגְרוּת מָלֵא קָשֶׁה לְהִתְקַבֵּל לְאוּנִיבֶרְסִיטָה בְּיִשְׂרָאֵל.",
            exampleNative = "Без полного аттестата зрелости трудно поступить в израильский университет.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181617, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_assessment", transliteration = "meytsáv",
            original = "מֵיצָב", translation = "стандартизированный школьный тест (мейцав)",
            definition = "מַעֲרֶכֶת בְּדִיקוֹת חִיצוֹנִיּוֹת שֶׁל מִשְׂרַד הַחִנּוּךְ לְמַדִּידַת רָמָה שֶׁל בָּתֵּי סֵפֶר.",
            definitionNative = "Внешние замеры от министерства, по которым сравнивают школы между собой по уровню.",
            example = "תּוֹצְאוֹת מֵיצָב פֻּרְסְמוּ הַשָּׁבוּעַ וְעוֹרְרוּ דִּיוּן צִבּוּרִי.",
            exampleNative = "Результаты мейцава вышли на этой неделе и вызвали бурную дискуссию.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181618, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_assessment", transliteration = "mivkhán psikhométri",
            original = "מִבְחָן פְּסִיכוֹמֶטְרִי", translation = "психометрический тест",
            definition = "מַעֲרֶכֶת שְׁאֵלוֹת שֶׁבּוֹדֶקֶת חֲשִׁיבָה כַּמּוּתִית, מִלּוּלִית וְאַנְגְּלִית לִקְרַאת אוּנִיבֶרְסִיטָה.",
            definitionNative = "Серия заданий по числам, словам и английскому — для поступления в университет.",
            example = "הִיא נִרְשְׁמָה לְקוּרְס הֲכָנָה לִפְנֵי הַמִּבְחָן פְּסִיכוֹמֶטְרִי.",
            exampleNative = "Она записалась на курс подготовки перед психометрическим тестом.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181619, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_assessment", transliteration = "haaraká khitsonít",
            original = "הַעֲרָכָה חִיצוֹנִית", translation = "внешняя оценка",
            definition = "בְּדִיקָה שֶׁעוֹרֵךְ מוּמְחֶה מִבַּחוּץ כְּדֵי לִבְחֹן אֶת אֵיכוּת הַלִּמּוּדִים בְּבֵית סֵפֶר.",
            definitionNative = "Проверка, которую проводит специалист со стороны — чтобы оценить качество учёбы в школе.",
            example = "הַעֲרָכָה חִיצוֹנִית מָצְאָה פְּעָרִים בְּהוֹרָאַת מָתֵמָטִיקָה.",
            exampleNative = "Внешняя оценка нашла пробелы в преподавании математики.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181620, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "school_assessment", transliteration = "hasmakhá akadémit",
            original = "הַסְמָכָה אֲקָדֶמִית", translation = "академическое утверждение",
            definition = "אִישּׁוּר רִשְׁמִי שֶׁמּוֹסָד יָכוֹל לְהַעֲנִיק תְּאָרִים בְּעוֹלָם הַלִּמּוּדִים הַגְּבוֹהִים.",
            definitionNative = "Официальное подтверждение, что заведение вправе присваивать степени в высшей школе.",
            example = "הַמִּכְלָלָה קִבְּלָה הַסְמָכָה אֲקָדֶמִית רַק אַחֲרֵי שָׁלוֹשׁ שְׁנוֹת בְּדִיקָה.",
            exampleNative = "Колледж получил академическое утверждение только после трёх лет проверок.",
            isFillInBlankSafe = false),

        // ── school_admin_infra (5) — администрация и инфраструктура ──
        WordEntity(
            id = 181621, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_admin_infra", transliteration = "menahél bet-séfer",
            original = "מְנַהֵל בֵּית סֵפֶר", translation = "директор школы",
            definition = "אִישׁ שֶׁאַחְרַאי עַל כָּל הַמַּעֲרֶכֶת — מוֹרִים, תַּלְמִידִים, תַּקְצִיב וְקֶשֶׁר עִם הוֹרִים.",
            definitionNative = "Тот, кто отвечает за всё — учителей, учеников, бюджет и связь с родителями.",
            example = "מְנַהֵל בֵּית סֵפֶר חָדָשׁ נִכְנָס לְתַפְקִיד בְּסֶפְּטֶמְבֶּר.",
            exampleNative = "Новый директор школы вступил в должность в сентябре.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181622, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_admin_infra", transliteration = "kámpus khinukhí",
            original = "קַמְפּוּס חִנּוּכִי", translation = "образовательный кампус",
            definition = "מִתְחָם רָחָב שֶׁמְּאַחֵד מִסְפַּר בָּתֵּי סֵפֶר וּמִתְקְנֵי סְפּוֹרְט תַּחַת נִיהוּל אֶחָד.",
            definitionNative = "Большая территория, которая собирает несколько школ и спортсооружений под общим управлением.",
            example = "הָעִירִיָּה בּוֹנָה קַמְפּוּס חִנּוּכִי חָדָשׁ בִּשְׁכוּנַת הַצָּפוֹן.",
            exampleNative = "Мэрия строит новый образовательный кампус в северном районе.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181623, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_admin_infra", transliteration = "moétset hamorím",
            original = "מוֹעֶצֶת הַמּוֹרִים", translation = "педагогический совет",
            definition = "כְּנֶס שֶׁל כָּל הַמּוֹרִים בְּבֵית סֵפֶר לְהַחְלָטוֹת עַל תַּלְמִידִים, צִיּוּנִים וּמַעֲבָרִים.",
            definitionNative = "Сбор всех учителей школы — решают по ученикам, оценкам и переводам в следующий класс.",
            example = "מוֹעֶצֶת הַמּוֹרִים הִתְכַּנְּסָה לִדְיוּן עַל הַתַּלְמִיד הַחָדָשׁ.",
            exampleNative = "Педагогический совет собрался для разговора о новом ученике.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181624, setId = 1816, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_admin_infra", transliteration = "pikúakh meshrád",
            original = "פִּקּוּחַ מִשְׂרָדִי", translation = "школьная инспекция (министерская)",
            definition = "גּוּף שֶׁל מִשְׂרַד הַחִנּוּךְ שֶׁבּוֹדֵק אֶת רָמַת הַהוֹרָאָה וְקִיּוּם הַתָּכְנִית בְּבָתֵּי סֵפֶר.",
            definitionNative = "Подразделение министерства, которое следит за уровнем преподавания и выполнением программы.",
            example = "פִּקּוּחַ מִשְׂרָדִי הִגִּיעַ בְּהַפְתָּעָה לְשִׁעוּר הִיסְטוֹרְיָה.",
            exampleNative = "Школьная инспекция нагрянула без предупреждения на урок истории.",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181625, setId = 1816, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_admin_infra", transliteration = "rakáz shikhvá",
            original = "רַכָּז שִׁכְבָה", translation = "координатор параллели",
            definition = "מוֹרֶה שֶׁאַחְרַאי עַל כָּל הַכִּתּוֹת בְּאוֹתוֹ גִיל וּמְתַאֵם בֵּין הַמְּחַנְּכוֹת שֶׁלָּהֶן.",
            definitionNative = "Учитель, который отвечает за все классы одного возраста и согласует работу их классных руководителей.",
            example = "רַכָּז שִׁכְבָה אִרְגֵּן יוֹם עִיּוּן מְשֻׁתָּף לְכָל הַכִּתּוֹת הַשְּׁבִיעִיּוֹת.",
            exampleNative = "Координатор параллели устроил общий день занятий для всех седьмых классов.",
            isFillInBlankSafe = false),
    )
}
