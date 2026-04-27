package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Дети и школа в Израиле" (level 4).
 *
 * Set 1815: «Дети и школа в Израиле» — профессиональный (L4, EPIC+LEGENDARY):
 *           педагогика, специальное образование, оценивание, родительский
 *           комитет и волонтёрство, экскурсии и мероприятия.
 *
 * Тема согласована с L2 (1813); здесь — углублённая профессиональная лексика
 * педагогов, методистов и активных родителей. Слова не пересекаются с L2
 * по `original` (правила позволяют разные сеты темы делить родственные шорешим).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   school_special_ed   — спецобразование: логопед, психолог-консультант, диагностика
 *   school_pedagogy     — педагогические подходы: Монтессори, дифференциация, проекты
 *   school_assessment   — оценивание и аттестация: багрут, психометри, табель, профиль
 *   school_parents      — родительский комитет, волонтёрство, координация
 *   school_events       — педсовет, церемонии, экскурсии, лагеря, олимпиады
 *
 * Word IDs: setId × 100 + position (181501..181525).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewSchoolL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1815, languagePair = "he-ru", orderIndex = 1815,
            name = "Дети и школа в Израиле",
            description = "Профессиональный: педагогика, методики обучения, специальное образование, воспитательная работа",
            topic = "Дети и школа в Израиле", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1815 — Дети и школа в Израиле: профессиональный (L4, EPIC+LEGENDARY)
        // 5 групп × 5 слов: special_ed, pedagogy, assessment, parents, events
        // ══════════════════════════════════════════════════════════════════════

        // ── school_special_ed (5) — спецобразование, диагностика, инклюзия ──
        WordEntity(
            id = 181501, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "school_special_ed", transliteration = "klinai tikshoret",
            original = "קְלִינַאי תִּקְשׁוֹרֶת", translation = "логопед",
            definition = "אִישׁ מִקְצוֹעַ שֶׁמְּטַפֵּל בִּקְשָׁיֵי דִּבּוּר, בְּלִיעָה וְקוֹל אֵצֶל יְלָדִים.",
            definitionNative = "Специалист, который лечит у детей трудности речи, глотания и звукопроизводства.",
            example = "אֵצֶל קְלִינַאי תִּקְשׁוֹרֶת הַיֶּלֶד יִלְמַד לְבַטֵּא רֵישׁ.",
            exampleNative = "У логопед — קְלִינַאי תִּקְשׁוֹרֶת — ребёнок учится произносить букву рейш правильно.",
         fillInBlankExclusions = listOf(181502L, 181505L)),
        WordEntity(
            id = 181502, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_special_ed", transliteration = "yoetz khinukhi",
            original = "יוֹעֵץ חִינוּכִי", translation = "школьный консультант",
            definition = "מוֹרֶה מְיֻמָּן שֶׁעוֹזֵר לִתְלָמִידִים בְּמַשְׁבֵּר רִגְשִׁי אוֹ קֹשִׁי לִמּוּדִי.",
            definitionNative = "Опытный педагог, помогающий ученикам в эмоциональном кризисе или учебных трудностях.",
            example = "אֲנִי קוֹבֵעַ פְּגִישָׁה עִם יוֹעֵץ חִינוּכִי בְּמַהֲלַךְ הַשָּׁבוּעַ.",
            exampleNative = "Я записываю встречу со школьный консультант — יוֹעֵץ חִינוּכִי — на этой неделе.",
         fillInBlankExclusions = listOf(181501L, 181505L, 181518L)),
        WordEntity(
            id = 181503, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_special_ed", transliteration = "dislektsia",
            original = "דִּיסְלֶקְצְיָה", translation = "дислексия",
            definition = "לֵקוּת לְמִידָה שֶׁבָּהּ הַיֶּלֶד מִתְקַשֶּׁה לְקַשֵּׁר אוֹתִיּוֹת לְמִלִּים שְׁלֵמוֹת.",
            definitionNative = "Особенность развития, при которой ребёнку трудно складывать буквы в целые слова.",
            example = "הַמּוֹרָה שָׂמָה לֵב לְ דִּיסְלֶקְצְיָה בְּכִתָּה ב.",
            exampleNative = "Учительница заметила дислексия во втором классе — теперь его ведёт спецкоманда.",
         fillInBlankExclusions = listOf(181504L)),
        WordEntity(
            id = 181504, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_special_ed", transliteration = "saya'at",
            original = "סַיַּעַת", translation = "помощница (для ребёнка с особыми нуждами)",
            definition = "אִשָּׁה שֶׁמְּלַוָּה תַּלְמִיד בִּמְהַלַךְ הַיּוֹם וְעוֹזֶרֶת לוֹ בְּמַשִׂימוֹת.",
            definitionNative = "Женщина, которая сопровождает ученика весь день и помогает справляться с заданиями.",
            example = "הַ סַיַּעַת יוֹשֶׁבֶת לְיַד הַיֶּלֶד בְּכָל הַשִּׁעוּרִים שֶׁלּוֹ.",
            exampleNative = "помощница (для ребёнка с особыми нуждами) сидит рядом с ним на каждом уроке.",
         fillInBlankExclusions = listOf(181503L)),
        WordEntity(
            id = 181505, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "school_special_ed", transliteration = "ivkhun didakti",
            original = "אִבְחוּן דִּידַקְטִי", translation = "дидактическая диагностика",
            definition = "בְּדִיקָה רִשְׁמִית שֶׁמְּגַלָּה לֵקוּיוֹת לְמִידָה וּמַתְאֶרֶת אוֹתָן לִמְסַיְּעִים.",
            definitionNative = "Официальное обследование, выявляющее особенности развития ребёнка для команды педагогов.",
            example = "אַחֲרֵי הָ אִבְחוּן דִּידַקְטִי קִבַּלְנוּ הַתְאָמוֹת בִּבְחִינוֹת.",
            exampleNative = "После дидактическая диагностика дали послабления на экзаменах — это меняет всё.",
         fillInBlankExclusions = listOf(181501L, 181502L)),

        // ── school_pedagogy (5) — педагогические подходы ──
        WordEntity(
            id = 181506, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "school_pedagogy", transliteration = "shitat montessori",
            original = "שִׁיטַת מוֹנְטֶסּוֹרִי", translation = "метод Монтессори",
            definition = "גִּשָּׁה לְפִתּוּחַ עַצְמָאוּת בִּילָדִים דֶּרֶךְ חוֹמְרֵי לְמִידָה אִישִׁיִּים.",
            definitionNative = "Подход к воспитанию самостоятельности через индивидуальные учебные материалы.",
            example = "הַ שִׁיטַת מוֹנְטֶסּוֹרִי דּוֹרֶשֶׁת מוֹרִים מְאֻמָּנִים בְּקֹשִׁי.",
            exampleNative = "метод Монтессори требует особой подготовки педагогов — иначе теряется суть подхода.",
         fillInBlankExclusions = listOf(181507L, 181508L, 181509L)),
        WordEntity(
            id = 181507, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_pedagogy", transliteration = "horaa mevudelet",
            original = "הוֹרָאָה מְבֻדֶּלֶת", translation = "дифференцированное обучение",
            definition = "סִגְנוֹן עֲבוֹדָה שֶׁבּוֹ הַמּוֹרָה נוֹתֶנֶת מְשִׂימוֹת שׁוֹנוֹת לְפִי רָמַת תַּלְמִיד.",
            definitionNative = "Стиль работы, при котором учитель даёт разные задания по уровню каждого ученика.",
            example = "בְּשִׁעוּר מָתֵמָטִיקָה אֲנִי מַפְעִילָה הוֹרָאָה מְבֻדֶּלֶת בְּשָׁלוֹשׁ קְבוּצוֹת.",
            exampleNative = "На уроке математики я веду дифференцированное обучение в трёх группах разом.",
         fillInBlankExclusions = listOf(181506L, 181508L, 181509L)),
        WordEntity(
            id = 181508, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "school_pedagogy", transliteration = "lemida mevusset proyektim",
            original = "לְמִידָה מְבֻסֶּסֶת פְּרוֹיֶקְטִים", translation = "проектное обучение",
            definition = "שִׁיטָה שֶׁבָּהּ תַּלְמִידִים חוֹקְרִים שְׁאֵלָה אֲמִתִּית וּמַצִּיגִים תּוֹצָאָה.",
            definitionNative = "Метод, в котором ученики исследуют живой вопрос и потом представляют итог классу.",
            example = "הַ לְמִידָה מְבֻסֶּסֶת פְּרוֹיֶקְטִים מַחֲלִיפָה הַשָּׁנָה אֶת הַמִּבְחָנִים.",
            exampleNative = "проектное обучение в этом году заменяет контрольные — ученики защищают исследования.",
         fillInBlankExclusions = listOf(181506L, 181507L, 181509L)),
        WordEntity(
            id = 181509, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_pedagogy", transliteration = "shiur frontali",
            original = "שִׁעוּר פְרוֹנְטָלִי", translation = "фронтальный урок",
            definition = "מִבְנֶה שִׁעוּר רָגִיל שֶׁבּוֹ הַמּוֹרָה מַסְבִּירָה לַכִּתָּה כֻּלָּהּ מֵהַלּוּחַ.",
            definitionNative = "Привычная форма урока, где учитель объясняет всему классу с доски.",
            example = "אַחֲרֵי שִׁעוּר פְרוֹנְטָלִי הַתַּלְמִידִים עוֹבְדִים בִּזְוּגוֹת.",
            exampleNative = "После фронтальный урок ученики работают в парах — так лучше усваивается материал.",
         fillInBlankExclusions = listOf(181506L, 181507L, 181508L)),
        WordEntity(
            id = 181510, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_pedagogy", transliteration = "hatamot",
            original = "הַתְאָמוֹת", translation = "учебные адаптации (послабления)",
            definition = "שִׁנּוּיִים בִּבְחִינָה אוֹ בְּתַהֲלִיךְ הַלְּמִידָה לְפִי צְרָכָיו שֶׁל תַּלְמִיד.",
            definitionNative = "Изменения в экзамене или ходе учёбы под индивидуальные нужды конкретного ученика.",
            example = "הוּא מְקַבֵּל הַתְאָמוֹת שֶׁל זְמַן נוֹסָף וּקְרִיאַת שְׁאֵלוֹת בְּקוֹל.",
            exampleNative = "Ему дают учебные адаптации (послабления) — лишнее время и чтение задания вслух.",
        ),

        // ── school_assessment (5) — оценивание и аттестация ──
        WordEntity(
            id = 181511, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "school_assessment", transliteration = "bkhinat matkonet",
            original = "בְּחִינַת מַתְכּוֹנֶת", translation = "пробный экзамен (к багруту)",
            definition = "מִבְחָן הֲכָנָה רִשְׁמִי שֶׁמְּדַמֶּה אֶת תְּנָאֵי הַמִּבְחָן הָאֲמִתִּי בַּכִּתָּה.",
            definitionNative = "Подготовительный официальный экзамен, имитирующий условия настоящего испытания.",
            example = "הַ בְּחִינַת מַתְכּוֹנֶת מִתְקַיֶּמֶת חֹדֶשׁ לִפְנֵי הַמּוֹעֵד הָרִשְׁמִי.",
            exampleNative = "пробный экзамен (к багруту) идёт за месяц до основной сессии.",
         fillInBlankExclusions = listOf(181514L, 181515L)),
        WordEntity(
            id = 181512, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_assessment", transliteration = "psikhometri",
            original = "פְּסִיכוֹמֶטְרִי", translation = "психометрический экзамен",
            definition = "מִבְחָן כַּמּוּתִי וּמִלּוּלִי שֶׁמַּכְרִיעַ קַבָּלָה לְלִימּוּדִים אֲקָדֵמָאִיִּים.",
            definitionNative = "Тест математического и вербального мышления — решает приём на академическое отделение.",
            example = "הוּא נִרְשַׁם לְקוּרְס פְּסִיכוֹמֶטְרִי בְּסוֹף הַשָּׁנָה.",
            exampleNative = "Он записался на курс психометрический экзамен — в конце года сдавать.",
         fillInBlankExclusions = listOf(181513L)),
        WordEntity(
            id = 181513, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_assessment", transliteration = "teuda",
            original = "תְּעוּדָה", translation = "табель / свидетельство",
            definition = "דַּף רִשְׁמִי בְּסוֹף סֶמֶסְטֶר עִם צִיּוּנֵי כָּל הַמִּקְצוֹעוֹת.",
            definitionNative = "Официальный лист в конце семестра с отметками по каждому предмету.",
            example = "הַ תְּעוּדָה הָרִאשׁוֹנָה שֶׁל הַשָּׁנָה הִגִּיעָה בְּחֲנֻכָּה.",
            exampleNative = "Первый табель / свидетельство в году вручили перед Ханукой — родителей зовут на встречу.",
         fillInBlankExclusions = listOf(181512L)),
        WordEntity(
            id = 181514, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_assessment", transliteration = "tsiyun shnati",
            original = "צִיּוּן שְׁנָתִי", translation = "годовая оценка",
            definition = "מִסְפָּר סוֹפִי שֶׁמְּסַכֵּם אֶת הִישֵּׂגֵי הַתַּלְמִיד בְּמִקְצוֹעַ.",
            definitionNative = "Итоговое число, обобщающее достижения ученика по предмету за весь учебный год.",
            example = "הַ צִיּוּן שְׁנָתִי מַגְדִּיר אִם הַתַּלְמִיד עוֹבֵר לַכִּתָּה הַבָּאָה.",
            exampleNative = "годовая оценка определяет, переходит ли ученик в следующий класс — главное число года.",
         fillInBlankExclusions = listOf(181511L, 181513L, 181515L)),
        WordEntity(
            id = 181515, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "school_assessment", transliteration = "maslul magma",
            original = "מַסְלוּל מָגְמָה", translation = "профильный поток (специализация)",
            definition = "כִּוּוּן לִמּוּדִי בַּתִּיכוֹן עִם דָּגֵשׁ עַל מִקְצוֹעוֹת מוּגְבָּרִים בְּתָחוּם אֶחָד.",
            definitionNative = "Учебная линия в старшей школе с упором на углублённые предметы одной области.",
            example = "בָּחַרְתִּי מַסְלוּל מָגְמָה שֶׁל בִּיוֹלוֹגְיָה וְכִימְיָה.",
            exampleNative = "Я выбрала профильный поток (специализация) с биологией и химией — мечтаю в медицину.",
         fillInBlankExclusions = listOf(181511L, 181514L)),

        // ── school_parents (5) — родительский комитет, волонтёрство ──
        WordEntity(
            id = 181516, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "school_parents", transliteration = "yoshev rosh havaad",
            original = "יוֹשֵׁב־רֹאשׁ הַוַּעַד", translation = "председатель комитета",
            definition = "הַהוֹרֶה שֶׁמּוֹבִיל אֶת קְבוּצַת הַהוֹרִים וּמְתַאֵם בֵּינָם לְבֵין בֵּית הַסֵּפֶר.",
            definitionNative = "Родитель, который ведёт группу родителей и согласует её действия со школой.",
            example = "הַ יוֹשֵׁב־רֹאשׁ הַוַּעַד שׁוֹלֵחַ סִכּוּם פְּגִישָׁה כָּל חֹדֶשׁ.",
            exampleNative = "председатель комитета каждый месяц рассылает протокол встречи всем родителям класса.",
         fillInBlankExclusions = listOf(181517L, 181518L, 181519L, 181520L)),
        WordEntity(
            id = 181517, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_parents", transliteration = "ezrat kehila",
            original = "עֶזְרַת קְהִלָּה", translation = "общинная помощь школе",
            definition = "תְּרוּמָה לֹא־כַסְפִּית לַכִּתָּה — לִוּוּי טִיּוּל, סִיּוּעַ בְּחַג אוֹ בְּהַצָּגָה.",
            definitionNative = "Безденежный вклад в класс — сопровождение поездки, помощь на празднике или спектакле.",
            example = "כָּל הַשָּׁנָה הִתְקַיְּמָה עֶזְרַת קְהִלָּה רְצוּפָה בִּפְעִילוּיּוֹת בֵּית הַסֵּפֶר.",
            exampleNative = "Весь год шла непрерывная общинная помощь школе на её мероприятиях.",
         fillInBlankExclusions = listOf(181516L, 181518L, 181519L, 181520L)),
        WordEntity(
            id = 181518, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_parents", transliteration = "rakaz shikhva",
            original = "רַכָּז שְׁכָבָה", translation = "координатор параллели",
            definition = "מוֹרֶה שֶׁמְּתַאֵם בֵּין כָּל הַכִּתּוֹת שֶׁל אוֹתָהּ שִׁכְבַת גִּיל בְּבֵית הַסֵּפֶר.",
            definitionNative = "Учитель, согласующий работу всех классов одного возраста параллели в школе.",
            example = "הַ רַכָּז שְׁכָבָה אוֹסֵף אֶת מַחְנְכוֹת ז עַל פִּגּוּשׁ בְּיוֹם רֹאשׁוֹן.",
            exampleNative = "координатор параллели собирает классруков седьмых на встречу в воскресенье.",
         fillInBlankExclusions = listOf(181516L, 181517L, 181519L, 181520L)),
        WordEntity(
            id = 181519, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "school_parents", transliteration = "mekhuyavut ishit",
            original = "מְחֻיָּבוּת אִישִׁית", translation = "социальная нагрузка ученика",
            definition = "שָׁעוֹת תְּרוּמָה לַקְּהִילָה שֶׁכָּל תַּלְמִיד תִּיכוֹן חַיָּב לְבַצֵּעַ לְבַגְרוּת.",
            definitionNative = "Часы общественной работы, которые каждый старшеклассник обязан выполнить ради аттестата.",
            example = "הוּא הִשְׁלִים אֶת הַ מְחֻיָּבוּת אִישִׁית בְּבֵית הַזִּקְנָה הַשְּׁכוּנָתִי.",
            exampleNative = "Он отработал социальная нагрузка ученика в районном доме престарелых.",
         fillInBlankExclusions = listOf(181516L, 181517L, 181518L, 181520L)),
        WordEntity(
            id = 181520, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_parents", transliteration = "forum horim",
            original = "פּוֹרוּם הוֹרִים", translation = "родительский форум (онлайн)",
            definition = "קְבוּצָה דִּיגִיטָלִית שֶׁל הוֹרִים שֶׁמּוֹדִיעִים זֶה לָזֶה עַל הַכִּתָּה.",
            definitionNative = "Цифровая группа родителей — обмениваются новостями о том, что происходит в классе.",
            example = "הַ פּוֹרוּם הוֹרִים שֶׁל הַכִּתָּה דּוֹלֵק עַד מְאֻחָר בַּלַּיְלָה.",
            exampleNative = "Классный родительский форум (онлайн) гудит до глубокой ночи — обсуждают всё подряд.",
         fillInBlankExclusions = listOf(181516L, 181517L, 181518L, 181519L)),

        // ── school_events (5) — педсовет, церемонии, экскурсии, лагеря ──
        WordEntity(
            id = 181521, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_events", transliteration = "yeshivat tsevet",
            original = "יְשִׁיבַת צֶוֶת", translation = "педсовет (заседание команды)",
            definition = "מִפְגָּשׁ שָׁבוּעִי שֶׁל הַמּוֹרִים לַדָּבָר עַל תַּלְמִידִים וְעַל תְּכוּנוֹת לִמּוּד.",
            definitionNative = "Еженедельная встреча учителей — обсуждают учеников и планируют учебные программы.",
            example = "בְּ יְשִׁיבַת צֶוֶת הָאַחֲרוֹנָה הֶחְלַטְנוּ עַל מַסָּע לְיֵרוּשָׁלַיִם.",
            exampleNative = "На последнем педсовет (заседание команды) решили устроить поездку в Иерусалим.",
         fillInBlankExclusions = listOf(181522L, 181523L)),
        WordEntity(
            id = 181522, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_events", transliteration = "tekes siyum",
            original = "טֶקֶס סִיוּם", translation = "выпускная церемония",
            definition = "אֵרוּעַ חֲגִיגִי בְּסוֹף שָׁנָה — נוֹתְנִים תְּעוּדוֹת וּמְבָרְכִים בּוֹגְרִים.",
            definitionNative = "Торжественное событие в конце года — вручают аттестаты и поздравляют выпускников.",
            example = "בַּ טֶקֶס סִיוּם הַהוֹרִים מְצַלְּמִים אֶת הַיְּלָדִים בְּכֻלָּן.",
            exampleNative = "На выпускная церемония родители снимают детей всё подряд — момент важный.",
         fillInBlankExclusions = listOf(181521L, 181523L)),
        WordEntity(
            id = 181523, setId = 1815, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_events", transliteration = "tiyul beit sefer",
            original = "טִיּוּל בֵּית סֵפֶר", translation = "школьная экскурсия",
            definition = "יוֹם בְּחוּץ עִם הַכִּתָּה לַטֶּבַע אוֹ לְמוּזֵיאוֹן בִּלְוִית הַמּוֹרָה.",
            definitionNative = "День класса вне стен — выезд на природу или в музей с учителем.",
            example = "הַ טִיּוּל בֵּית סֵפֶר עוֹבֵר הַחֹדֶשׁ בְּשָׁמוּרַת עֵין גֶּדִי.",
            exampleNative = "школьная экскурсия в этом месяце пройдёт в заповеднике Эйн-Геди — давно ждали.",
         fillInBlankExclusions = listOf(181521L, 181522L)),
        WordEntity(
            id = 181524, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_events", transliteration = "kaytana",
            original = "קַיְטָנָה", translation = "каникулярный лагерь",
            definition = "מִסְגֶּרֶת יוֹמִית בְּחֻפְשַׁת קַיִץ עִם פָּעוֹלוֹת, מִשְׂחָקִים וְטִיּוּלִים לִילָדִים.",
            definitionNative = "Дневная программа в летние каникулы — занятия, игры и поездки для младших школьников.",
            example = "רָשַׁמְתִּי אֶת הַתְּאוֹמִים לְ קַיְטָנָה שֶׁל אַתְלֵטִיקָה.",
            exampleNative = "Я записал близнецов в каникулярный лагерь по лёгкой атлетике на три недели.",
         fillInBlankExclusions = listOf(181525L)),
        WordEntity(
            id = 181525, setId = 1815, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "school_events", transliteration = "khidon",
            original = "חִידוֹן", translation = "школьная олимпиада-викторина",
            definition = "תַּחֲרוּת יְדִיעוֹת בֵּין כִּתּוֹת עִם שְׁאֵלוֹת מָתֵמָטִיקָה אוֹ תָּנָ״ךְ.",
            definitionNative = "Состязание знаний между классами или школами — задают вопросы по математике или ТАНАХу.",
            example = "הַ חִידוֹן הַשְּׁכוּנָתִי יִתְקַיֵּם בְּמַתְנָ״ס בְּיוֹם חֲמִישִׁי.",
            exampleNative = "Районная школьная олимпиада-викторина пройдёт в матнасе в четверг вечером.",
         fillInBlankExclusions = listOf(181524L)),
    )
}
