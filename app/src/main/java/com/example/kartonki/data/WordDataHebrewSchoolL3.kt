package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Дети и школа в Израиле", L3 «Углублённый»
 * (RARE+EPIC).
 *
 * Set 1814: «Дети и школа в Израиле» — углублённый L3:
 *           учебные предметы старших классов, экзамены и багрут, школьные
 *           экскурсии и проекты, аттестация и табели, средняя/старшая школа.
 *
 * Целевая аудитория — русскоязычные родители школьников 7–12 классов и
 * сами подростки, разбирающиеся с системой среднего образования в Израиле:
 * структура חטיבה+תיכון, מגמות, бюрократия багрута, школьные путешествия и
 * мероприятия, табели и аттестаты.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC (2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   school_subjects     — учебные предметы: математика, английский,
 *                         история, естественные науки, география
 *   school_exams        — экзамены и оценивание: бохан, бхина, мивхан
 *                         багрут, циюн багрут, мехцит
 *   school_excursions   — экскурсии и проекты: школьный поход, выпускное
 *                         путешествие, дни плавания, внешкольная
 *                         мастерская, педагогическое новшество
 *   school_certificates — аттестация и табели: годовой табель, аттестат
 *                         зрелости, свидетельство об окончании, ведомость
 *                         оценок, справка о посещении
 *   school_secondary    — средняя/старшая школа: хативат бейнаим, тихон,
 *                         астрономия в тихоне, мегамат лимудим, юоэц
 *                         хинухи
 *
 * Word IDs: setId × 100 + position (181401..181425).
 *
 * Пересечения с другими наборами:
 *   - SchoolL1 (1812) и SchoolL2 (1813, параллельная разработка) — базовая
 *     школьная лексика. Здесь — углублённый слой про среднее/старшее
 *     звено, экзамены и аттестацию.
 *   - Education-сеты (1121 «Цвета и формы», 1027 «Запись, уроки, кружки»,
 *     1448, 1449, 1450) — общая лексика образования. Тема нового сета
 *     специфична для израильской школьной системы.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewSchoolL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1814, languagePair = "he-ru", orderIndex = 1814,
            name = "Дети и школа в Израиле",
            description = "Углублённый: предметы, экзамены, экскурсии, аттестация",
            topic = "Дети и школа в Израиле", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1814 — Дети и школа в Израиле: углублённый (L3, RARE+EPIC)
        // 5 групп × 5 слов: subjects, exams, excursions, certificates, secondary
        // 13 RARE + 12 EPIC
        // ══════════════════════════════════════════════════════════════════════

        // ── school_subjects (5) — учебные предметы ──
        WordEntity(
            id = 181401, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "school_subjects", transliteration = "matematika",
            original = "מָתֵמָטִיקָה", translation = "математика",
            definition = "מִקְצוֹעַ בֵּית-סֵפֶר עַל מִסְפָּרִים, צוּרוֹת וּפִתְרוֹן תַּרְגִּילִים.",
            definitionNative = "Школьный предмет про числа, фигуры и решение задач.",
            example = "הַמּוֹרָה לְמָתֵמָטִיקָה הִסְבִּירָה אֵיךְ פּוֹתְרִים מִשְׁוָאוֹת.",
            exampleNative = "Учительница по מָתֵמָטִיקָה объяснила, как решать уравнения.",
         fillInBlankExclusions = listOf(181402L, 181403L, 181404L, 181405L)),
        WordEntity(
            id = 181402, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "school_subjects", transliteration = "anglit",
            original = "אַנְגְלִית", translation = "английский язык",
            definition = "מִקְצוֹעַ הַחוֹבָה הָעִקָּרִי לְשָׂפָה זָרָה בְּבָתֵּי הַסֵּפֶר.",
            definitionNative = "Главный обязательный предмет по иностранному языку в школах.",
            example = "הַתַּלְמִידִים לוֹמְדִים אַנְגְלִית מִכִּתָּה ג' וְעַד סוֹף הַתִּיכוֹן.",
            exampleNative = "Ученики учат אַנְגְלִית с третьего класса до конца старшей школы.",
         fillInBlankExclusions = listOf(181401L, 181403L, 181404L, 181405L)),
        WordEntity(
            id = 181403, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "school_subjects", transliteration = "historya",
            original = "הִיסְטוֹרְיָה", translation = "история",
            definition = "מִקְצוֹעַ הַלּוֹמֵד עַל אֵרוּעֵי עָבָר שֶׁל עַמִּים וּמְדִינוֹת.",
            definitionNative = "Предмет о событиях прошлого народов и государств.",
            example = "בְּשִׁעוּר הִיסְטוֹרְיָה דִּבַּרְנוּ עַל מִלְחֶמֶת הָעַצְמָאוּת.",
            exampleNative = "На уроке הִיסְטוֹרְיָה мы говорили о Войне за независимость.",
         fillInBlankExclusions = listOf(181401L, 181402L, 181404L, 181405L)),
        WordEntity(
            id = 181404, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "school_subjects", transliteration = "madaim",
            original = "מַדָּעִים", translation = "естественные науки",
            definition = "מִקְצוֹעַ מְשֻׁלָּב עִם פִיסִיקָה, כִימְיָה וּבִיוֹלוֹגְיָה לִילָדִים.",
            definitionNative = "Совмещённый предмет с физикой, химией и биологией для младших.",
            example = "בְּשִׁעוּר מַדָּעִים בָּנִינוּ הַיּוֹם דֶּגֶם שֶׁל הַר גַּעַשׁ.",
            exampleNative = "На уроке מַדָּעִים мы сегодня собрали модель вулкана.",
         fillInBlankExclusions = listOf(181401L, 181402L, 181403L, 181405L)),
        WordEntity(
            id = 181405, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "school_subjects", transliteration = "geografya",
            original = "גֵּאוֹגְרַפְיָה", translation = "география",
            definition = "מִקְצוֹעַ עַל מַפּוֹת, אַקְלִים וְחַיֵּי בְּנֵי-אָדָם בְּאֲזוֹרִים שׁוֹנִים.",
            definitionNative = "Предмет про карты, климат и жизнь людей в разных регионах.",
            example = "מוֹרֵה הַגֵּאוֹגְרַפְיָה הֵבִיא אַטְלָס חָדָשׁ לְכָל כִּתָּה.",
            exampleNative = "Учитель גֵּאוֹגְרַפְיָה принёс в каждый класс новый атлас.",
         fillInBlankExclusions = listOf(181401L, 181402L, 181403L, 181404L)),

        // ── school_exams (5) — экзамены и оценивание ──
        WordEntity(
            id = 181406, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "school_exams", transliteration = "bokhan",
            original = "בּוֹחַן", translation = "контрольная работа",
            definition = "מִבְחָן קָצָר בְּנוֹשֵׂא אֶחָד שֶׁמּוֹרֶה נוֹתֵן לְלֹא אַזְהָרָה רַבָּה.",
            definitionNative = "Короткая проверка по одной теме, которую учитель даёт почти без предупреждения.",
            example = "הַמּוֹרָה הוֹדִיעָה עַל בּוֹחַן פִּתְאוֹמִי בְּלֹא הֲכָנָה מֻקְדֶּמֶת.",
            exampleNative = "Учительница объявила внезапный בּוֹחַן без подготовки.",
         fillInBlankExclusions = listOf(181407L, 181410L)),
        WordEntity(
            id = 181407, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "school_exams", transliteration = "bkhina",
            original = "בְּחִינָה", translation = "экзамен",
            definition = "מִבְחָן רִשְׁמִי וְאָרֹךְ עַל חֹמֶר שֶׁל פֶּרֶק שָׁלֵם אוֹ סֶמֶסְטֶר.",
            definitionNative = "Официальная и долгая проверка по материалу целой главы или семестра.",
            example = "הַתַּלְמִידִים נִכְנְסוּ לַכִּתָּה לִפְנֵי הַבְּחִינָה בְּשֶׁקֶט מֻחְלָט.",
            exampleNative = "Ученики вошли в класс перед בְּחִינָה в полной тишине.",
         fillInBlankExclusions = listOf(181406L, 181410L)),
        WordEntity(
            id = 181408, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_exams", transliteration = "mivkhan bagrut",
            original = "מִבְחָן בָּגְרוּת", translation = "экзамен на аттестат зрелости",
            definition = "בְּחִינָה אַרְצִית בְּסוֹף הַתִּיכוֹן הַקּוֹבַעַת זְכָאוּת לְתְעוּדַת סִיּוּם.",
            definitionNative = "Государственный экзамен в конце старшей школы, дающий право на аттестат.",
            example = "מִבְחָן בָּגְרוּת בְּמָתֵמָטִיקָה נֶעֱרָךְ בְּשֶׁקֶט מַתָּן בְּכָל הָאָרֶץ.",
            exampleNative = "מִבְחָן בָּגְרוּת по математике проводят в один день по всей стране.",
         fillInBlankExclusions = listOf(181409L, 181423L)),
        WordEntity(
            id = 181409, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_exams", transliteration = "tziyun bagrut",
            original = "צִיּוּן בָּגְרוּת", translation = "балл багрута",
            definition = "הַצִּיּוּן הַסּוֹפִי בְּמִקְצוֹעַ אַחֲרֵי שִׁקְלוּל הַמִּבְחָן וְהַצִּיּוּן הַשְּׁנָתִי.",
            definitionNative = "Итоговая оценка по предмету после взвешивания экзамена и годового балла.",
            example = "צִיּוּן בָּגְרוּת גָּבוֹהַ בְּפִיסִיקָה פָּתַח לוֹ דֶּרֶךְ לָאוּנִיבֶרְסִיטָה.",
            exampleNative = "Высокий צִיּוּן בָּגְרוּת по физике открыл ему дорогу в университет.",
         fillInBlankExclusions = listOf(181408L)),
        WordEntity(
            id = 181410, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "school_exams", transliteration = "makhatzit",
            original = "מַחְצִית", translation = "полугодие",
            definition = "חֵצִי שֶׁל שְׁנַת הַלִּמּוּדִים, אַחֲרָיו מְקַבְּלִים תְּעוּדָה בֵּינַיִם.",
            definitionNative = "Половина учебного года, после которой выдают промежуточный табель.",
            example = "בְּסוֹף הַמַּחְצִית הָרִאשׁוֹנָה הוֹרַי הִגִּיעוּ לְשִׂיחַת הוֹרִים.",
            exampleNative = "В конце первой מַחְצִית мои родители пришли на родительское собрание.",
            isFillInBlankSafe = false,
        ),

        // ── school_excursions (5) — экскурсии, поездки и проекты ──
        WordEntity(
            id = 181411, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "school_excursions", transliteration = "tiyul beit-sifri",
            original = "טִיּוּל בֵּית-סִפְרִי", translation = "школьная экскурсия",
            definition = "יוֹם יְצִיאָה מְאֻרְגָּן שֶׁל כִּתָּה עִם מוֹרִים לְאֲתָר חוּצוֹת אוֹ מוּזֵיאוֹן.",
            definitionNative = "Организованный выездной день класса с учителями на природу или в музей.",
            example = "בַּשָּׁבוּעַ שֶׁעָבַר יָצָאנוּ לְטִיּוּל בֵּית-סִפְרִי לַגָּלִיל הַתַּחְתּוֹן.",
            exampleNative = "На прошлой неделе мы выехали на טִיּוּל בֵּית-סִפְרִי в Нижнюю Галилею.",
         fillInBlankExclusions = listOf(181412L, 181413L, 181414L, 181415L)),
        WordEntity(
            id = 181412, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_excursions", transliteration = "masa siyum",
            original = "מַסַּע סִיוּם", translation = "выпускное путешествие",
            definition = "טִיּוּל אָרֹךְ שֶׁל שָׁלֹשׁ עַד חָמֵשׁ יָמִים בְּסוֹף שִׁכְבַת לִמּוּדִים.",
            definitionNative = "Длинный поход на три–пять дней в конце выпускного потока.",
            example = "מַסַּע סִיוּם שֶׁל י\"ב עוֹבֵר בְּשׁוֹרַת מַסְלוּלִים בַּמִּדְבָּר.",
            exampleNative = "מַסַּע סִיוּם двенадцатого класса проходит цепью маршрутов в пустыне.",
         fillInBlankExclusions = listOf(181411L, 181413L, 181414L, 181415L)),
        WordEntity(
            id = 181413, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_excursions", transliteration = "yemei shayit",
            original = "יְמֵי שַׁיִט", translation = "дни плавания",
            definition = "תְּכוּנָה חוּצוֹת שֶׁל שַׁיִט עַל סִירָה אוֹ אֳנִיָּה לְכִתּוֹת בְּחוֹף.",
            definitionNative = "Внешкольная программа с плаванием на лодке или корабле для классов на побережье.",
            example = "יְמֵי שַׁיִט הָפְכוּ לְמַסּוֹרֶת בַּתִּיכוֹן הַיַּמִּי שֶׁלָּנוּ.",
            exampleNative = "יְמֵי שַׁיִט стали традицией в нашей морской школе.",
         fillInBlankExclusions = listOf(181411L, 181412L, 181414L, 181415L)),
        WordEntity(
            id = 181414, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_excursions", transliteration = "sadna khuts-sifrit",
            original = "סַדְנָה חוּץ-סִפְרִית", translation = "внешкольная мастерская",
            definition = "פְּעִילוּת לִמּוּדִית מַעֲשִׂית מִחוּץ לִכְתָלֵי הַמּוֹסָד עַל יְדֵי גּוּף חִיצוֹנִי.",
            definitionNative = "Практическое занятие за стенами учреждения, проводимое внешним организатором.",
            example = "הַשִּׁכְבָה יָצְאָה לְסַדְנָה חוּץ-סִפְרִית עַל מַעְבָּדָה רוֹבּוֹטִית.",
            exampleNative = "Поток выехал на סַדְנָה חוּץ-סִפְרִית по робототехнической лаборатории.",
         fillInBlankExclusions = listOf(181411L, 181412L, 181413L, 181415L)),
        WordEntity(
            id = 181415, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_excursions", transliteration = "khidush pedagogi",
            original = "חִדּוּשׁ פֶּדָגוֹגִי", translation = "педагогическое новшество",
            definition = "שִׁיטָה אוֹ פְּרוֹיֶקְט יְצִירָתִי שֶׁמּוֹרֶה מַכְנִיס לַכִּתָּה כְּדֵי לְעוֹרֵר עִנְיָן.",
            definitionNative = "Творческий метод или проект, который учитель вносит в класс, чтобы зажечь интерес.",
            example = "הַמּוֹרָה הִכְנִיסָה חִדּוּשׁ פֶּדָגוֹגִי שֶׁל מִשְׂחָקֵי תַּפְקִידִים.",
            exampleNative = "Учительница ввела חִדּוּשׁ פֶּדָגוֹגִי с ролевыми играми.",
         fillInBlankExclusions = listOf(181411L, 181412L, 181413L, 181414L)),

        // ── school_certificates (5) — аттестация и табели ──
        WordEntity(
            id = 181416, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "school_certificates", transliteration = "teuda shnatit",
            original = "תְּעוּדָה שְׁנָתִית", translation = "годовой табель",
            definition = "מִסְמָךְ סוֹף שָׁנָה עִם הַצִּיּוּנִים שֶׁל הַתַּלְמִיד בְּכָל הַמִּקְצוֹעוֹת.",
            definitionNative = "Документ конца года с оценками ученика по всем предметам.",
            example = "הַיֶּלֶד הֵבִיא הַבַּיְתָה תְּעוּדָה שְׁנָתִית עִם צִיּוּנִים גְּבוֹהִים מְאוֹד.",
            exampleNative = "Ребёнок принёс домой תְּעוּדָה שְׁנָתִית с очень высокими оценками.",
         fillInBlankExclusions = listOf(181417L, 181418L, 181419L, 181420L)),
        WordEntity(
            id = 181417, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_certificates", transliteration = "teudat bagrut",
            original = "תְּעוּדַת בָּגְרוּת", translation = "аттестат зрелости",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁל סוֹף תִּיכוֹן הַמְּאַשֵּׁר זְכָאוּת לִלְמֹד בָּאוּנִיבֶרְסִיטָה.",
            definitionNative = "Официальный документ конца старшей школы, подтверждающий право учиться в университете.",
            example = "תְּעוּדַת בָּגְרוּת מְלֵאָה הִיא תְּנַאי לִרְשׁוּת לַתֹּאַר הָרִאשׁוֹן.",
            exampleNative = "Полный תְּעוּדַת בָּגְרוּת — условие допуска к бакалавриату.",
         fillInBlankExclusions = listOf(181416L, 181418L, 181419L, 181420L)),
        WordEntity(
            id = 181418, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "school_certificates", transliteration = "teudat siyum",
            original = "תְּעוּדַת סִיּוּם", translation = "свидетельство об окончании",
            definition = "מִסְמָךְ הַמְּאַשֵּׁר שֶׁהַתַּלְמִיד גָּמַר שָׁלָב לִמּוּדִים מְסֻיָּם בְּהַצְלָחָה.",
            definitionNative = "Документ, что ученик успешно закончил определённый этап учёбы.",
            example = "בְּטֶקֶס הַסִּיּוּם חִלְּקוּ לְכָל בּוֹגֵר תְּעוּדַת סִיּוּם וְפֶרַח.",
            exampleNative = "На церемонии каждому выпускнику вручили תְּעוּדַת סִיּוּם и цветок.",
         fillInBlankExclusions = listOf(181416L, 181417L, 181419L, 181420L)),
        WordEntity(
            id = 181419, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_certificates", transliteration = "gilyon tziyunim",
            original = "גִּלְיוֹן צִיּוּנִים", translation = "ведомость оценок",
            definition = "טֹפֶס מְפֹרָט שֶׁל כָּל הַצִּיּוּנִים שֶׁל תַּלְמִיד עַל פְּנֵי כַּמָּה שָׁנִים.",
            definitionNative = "Подробный бланк всех оценок ученика за несколько лет.",
            example = "הָאוּנִיבֶרְסִיטָה דָּרְשָׁה גִּלְיוֹן צִיּוּנִים מְקוֹרִי לָרִשּׁוּם.",
            exampleNative = "Университет потребовал оригинальный גִּלְיוֹן צִיּוּנִים при записи.",
         fillInBlankExclusions = listOf(181416L, 181417L, 181418L, 181420L)),
        WordEntity(
            id = 181420, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_certificates", transliteration = "ishur nokhekhut",
            original = "אִישּׁוּר נוֹכְחוּת", translation = "справка о посещении",
            definition = "מִסְמָךְ קָצָר מִבֵּית הַסֵּפֶר הַמְּאַשֵּׁר שֶׁהַיֶּלֶד מַגִּיעַ סָדִיר לַשִּׁעוּרִים.",
            definitionNative = "Краткая бумага из школы, подтверждающая, что ребёнок ходит на уроки регулярно.",
            example = "הַמַּזְכִּירָה הִדְפִּיסָה אִישּׁוּר נוֹכְחוּת לַבִּטּוּחַ הַלְּאֻמִּי.",
            exampleNative = "Секретарша распечатала אִישּׁוּר נוֹכְחוּת для Битуах Леуми.",
         fillInBlankExclusions = listOf(181416L, 181417L, 181418L, 181419L)),

        // ── school_secondary (5) — средняя и старшая школа ──
        WordEntity(
            id = 181421, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "school_secondary", transliteration = "khativat beinaim",
            original = "חֲטִיבַת בֵּינַיִם", translation = "средняя школа",
            definition = "שָׁלָב בֵּינַיִם בֵּין יְסוֹדִי לְתִיכוֹן, כּוֹלֵל כִּתּוֹת שְׁבִיעִית עַד תְּשִׁיעִית.",
            definitionNative = "Промежуточная ступень между начальной и старшей, охватывает 7–9 классы.",
            example = "בְּנִי עוֹבֵר לַחֲטִיבַת בֵּינַיִם בְּסוֹף הַשָּׁנָה הַזֹּאת.",
            exampleNative = "Мой сын переходит в חֲטִיבַת בֵּינַיִם в конце этого года.",
         fillInBlankExclusions = listOf(181422L, 181423L, 181424L, 181425L)),
        WordEntity(
            id = 181422, setId = 1814, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "school_secondary", transliteration = "tikhon",
            original = "תִּיכוֹן", translation = "старшая школа",
            definition = "שָׁלָב הַלִּמּוּדִים הָאַחֲרוֹן בְּבֵית סֵפֶר, מִכִּתָּה י' עַד י\"ב.",
            definitionNative = "Последняя школьная ступень, с десятого по двенадцатый класс.",
            example = "בַּתִּיכוֹן הַתַּלְמִידִים בּוֹחֲרִים מִקְצוֹעוֹת מֻגְבָּרִים לַבָּגְרוּת.",
            exampleNative = "В תִּיכוֹן ученики выбирают профильные предметы для багрута.",
        ),
        WordEntity(
            id = 181423, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_secondary", transliteration = "astronomya tikhonit",
            original = "אַסְטְרוֹנוֹמְיָה תִּיכוֹנִית", translation = "астрономия в тихоне",
            definition = "מִקְצוֹעַ מֻגְבָּר חוֹקֵר כּוֹכָבִים וּמַעֲרֶכֶת הַשֶּׁמֶשׁ בְּבֵית הַסֵּפֶר הָעֶלְיוֹן.",
            definitionNative = "Профильный предмет о звёздах и Солнечной системе в старшей школе.",
            example = "אַסְטְרוֹנוֹמְיָה תִּיכוֹנִית הִיא בְּחִירָה נְדִירָה לְתַלְמִידִים.",
            exampleNative = "אַסְטְרוֹנוֹמְיָה תִּיכוֹנִית — редкий выбор среди учеников.",
         fillInBlankExclusions = listOf(181421L, 181424L, 181425L)),
        WordEntity(
            id = 181424, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_secondary", transliteration = "megamat limudim",
            original = "מְגַמַּת לִימּוּדִים", translation = "профильное направление",
            definition = "אֲשׁוּל לִמּוּדִים מֻגְבָּר בְּתַחוּם אֶחָד שֶׁתַּלְמִיד בּוֹחֵר בַּתִּיכוֹן.",
            definitionNative = "Углублённый учебный кластер по одной области, выбираемый в старшей школе.",
            example = "אֲחוֹתִי בָּחֲרָה בִּמְגַמַּת לִימּוּדִים בְּפִיסִיקָה וּמַחְשְׁבִים.",
            exampleNative = "Сестра выбрала מְגַמַּת לִימּוּדִים по физике и информатике.",
         fillInBlankExclusions = listOf(181421L, 181423L, 181425L)),
        WordEntity(
            id = 181425, setId = 1814, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "school_secondary", transliteration = "yoetz khinukhi",
            original = "יוֹעֵץ חִינּוּכִי", translation = "педагогический советник",
            definition = "אִישׁ צֶוֶת בֵּית סֵפֶר שֶׁתּוֹמֵךְ בַּתַּלְמִידִים בִּקְשִׁי לִמּוּדִי אוֹ אִישִׁי.",
            definitionNative = "Школьный сотрудник, который поддерживает учеников в учебных или личных трудностях.",
            example = "יוֹעֵץ חִינּוּכִי הִזְמִין אֶת הַהוֹרִים לְשִׂיחָה עַל הַהִתְקַדְּמוּת.",
            exampleNative = "יוֹעֵץ חִינּוּכִי пригласил родителей на беседу о прогрессе.",
         fillInBlankExclusions = listOf(181421L, 181423L, 181424L)),
    )
}
