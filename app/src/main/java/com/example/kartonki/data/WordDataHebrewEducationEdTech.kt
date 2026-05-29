package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1902 (he-ru).
 * Образование: онлайн-обучение и EdTech (L4 / RARE + EPIC).
 *
 * Зеркало en-ru set 472. Расширение темы «Образование».
 * Подтема — современная цифровая педагогика 2020-х:
 *   онлайн-форматы (MOOC, асинхронное, синхронное, blended, hybrid),
 *   инструменты EdTech (LMS, virtual classroom, breakout room,
 *     screen share, captioning),
 *   современные методики (flipped classroom, gamification, adaptive,
 *     inquiry-based, Socratic method),
 *   проектная и оценочная педагогика (self-paced, cohort-based,
 *     andragogy, digital whiteboard, polling),
 *   контент и сертификация (OER, digital badge, learning path,
 *     microcredential, digital literacy).
 *
 * Исключены как дубли с существующими he-ru сетами:
 *   - וֶבִּינַר (вебинар) — Batch53.
 *   - מִיקְרוֹ-לְמִידָה (микрообучение) — Batch68.
 *   - הַסְמָכָה (сертификат/certificate) — Barber, Barista, Plumber, WorkV2 и др.
 *   - פִּיגּוּן (scaffolding в обучении языку) — Batch24.
 *   - לְמִידָה מְבֻסֶּסֶת פְּרוֹיֶקְטִים (проектное обучение) — SchoolL3, SchoolL4.
 *   - הוֹרָאָה מְבֻדֶּלֶת / הוֹרָאָה מְדֻיֶּרֶת (дифференциация) — SchoolL3, SchoolL4.
 *   - שִׁיטַת מוֹנְטֶסּוֹרִי (Монтессори) — SchoolL3, SchoolL4.
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   RARE — 13 слов (отраслевой стандарт онлайн-обучения, узнаваем большинством
 *          практиков EdTech).
 *   EPIC — 12 слов (профлексика методиста: cohort-based, scaffolding-замены,
 *          adaptive, формативное, OER, microcredential, digital literacy).
 *
 * Пять семантических подгрупп (по 5 слов):
 *   edu_edtech_formats    — онлайн-форматы курсов
 *   edu_edtech_tools      — инструменты виртуального класса
 *   edu_edtech_methods    — современные методики преподавания
 *   edu_edtech_pedagogy   — проектная и оценочная педагогика
 *   edu_edtech_content    — контент и сертификация
 *
 * Word IDs: 190201..190225 (setId × 100 + position).
 */
object WordDataHebrewEducationEdTech {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1902, languagePair = "he-ru", orderIndex = 1902,
            name = "Образование",
            description = "Онлайн-обучение и EdTech: форматы (קוּרְס מָקוּוָן, לְמִידָה מְשׁוּלֶּבֶת), инструменты (מַעֲרֶכֶת לְנִיהוּל לְמִידָה, כִּתָּה וִירְטוּאָלִית), методики (כִּתָּה הָפוּכָה, גֵיימִיפִיקַצְיָה)",
            topic = "Образование",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: edu_edtech_formats (5 words) ───────────────────────────────

        WordEntity(id = 190201, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "קוּרְס מָקוּוָן הֲמוֹנִי",
            translation = "массовый открытый онлайн-курс (MOOC)",
            definition = "קוּרְס דִּיגִיטָלִי הַפָּתוּחַ לְכָל אָדָם בָּרֶשֶׁת, לְרוֹב חִינָּם, עִם אַלְפֵי לוֹמְדִים בְּמַחֲזוֹר אֶחָד.",
            definitionNative = "Цифровой курс, открытый каждому в сети, чаще бесплатный, с тысячами слушателей одного потока.",
            example = "קוּרְסֵרָה הִשִּׁיקָה קוּרְס מָקוּוָן הֲמוֹנִי בִּלְמִידַת מְכוֹנָה.",
            exampleNative = "Coursera запустил קוּרְס מָקוּוָן הֲמוֹנִי по машинному обучению.",
            pos = "phrase", semanticGroup = "edu_edtech_formats", fillInBlankExclusions = listOf(190202L, 190203L, 190204L, 190205L)),

        WordEntity(id = 190202, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "לְמִידָה אַ־סִינְכְרוֹנִית",
            translation = "асинхронное обучение",
            definition = "פוֹרְמָט שֶׁבּוֹ הַתַּלְמִיד צוֹפֶה בִּשְׁעוּרִים מֻקְלָטִים בַּזְּמַן הַנּוֹחַ לוֹ, לְלֹא מַפְגָּשׁ חַי.",
            definitionNative = "Формат, в котором ученик смотрит записанные занятия в удобное время, без живой встречи.",
            example = "לְמִידָה אַ־סִינְכְרוֹנִית מַתְאִימָה לְעוֹבְדִים בְּמִשְׁמָרוֹת מִתְחַלְּפוֹת.",
            exampleNative = "לְמִידָה אַ־סִינְכְרוֹנִית подходит работающим в сменных графиках.",
            pos = "phrase", semanticGroup = "edu_edtech_formats", fillInBlankExclusions = listOf(190201L, 190203L, 190204L, 190205L)),

        WordEntity(id = 190203, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "לְמִידָה סִינְכְרוֹנִית",
            translation = "синхронное обучение",
            definition = "פוֹרְמָט שֶׁבּוֹ הַמּוֹרֶה וְהַתַּלְמִידִים נִפְגָּשִׁים בְּזְמַן אֱמֶת בְּוִידֵאוֹ אוֹ בְּכִתָּה.",
            definitionNative = "Формат, в котором преподаватель и ученики встречаются в реальном времени по видео или очно.",
            example = "לְמִידָה סִינְכְרוֹנִית דּוֹרֶשֶׁת אִינְטֶרְנֵט יַצִּיב וּמַצְלֵמָה פְּעִילָה.",
            exampleNative = "לְמִידָה סִינְכְרוֹנִית требует стабильного интернета и рабочей камеры.",
            pos = "phrase", semanticGroup = "edu_edtech_formats", fillInBlankExclusions = listOf(190201L, 190202L, 190204L, 190205L)),

        WordEntity(id = 190204, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "לְמִידָה מְשׁוּלֶּבֶת",
            translation = "смешанное обучение (blended)",
            definition = "קוּרְס שֶׁמְּשַׁלֵּב מִפְגָּשִׁים פְרוֹנְטָלִיִּים עִם מְשִׂימוֹת אוֹנְלַיְן בְּאוֹתָהּ תְּקוּפָה.",
            definitionNative = "Курс, соединяющий очные встречи и онлайн-задания в одну программу.",
            example = "הָאוּנִיבֶרְסִיטָה הִשְׁאִירָה לְמִידָה מְשׁוּלֶּבֶת לְמַחֲצִית הַסֶּמִינָרִים.",
            exampleNative = "Университет оставил לְמִידָה מְשׁוּלֶּבֶת для половины семинаров.",
            pos = "phrase", semanticGroup = "edu_edtech_formats", fillInBlankExclusions = listOf(190201L, 190202L, 190203L, 190205L)),

        WordEntity(id = 190205, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "לְמִידָה הִיבְּרִידִית",
            translation = "гибридное обучение",
            definition = "מַפְגָּשׁ אֶחָד שֶׁבּוֹ חֵלֶק מֵהַכִּתָּה יוֹשֶׁב בַּחֶדֶר וְחֵלֶק מִתְחַבֵּר מֵרָחוֹק בּוֹ־זְמַנִּית.",
            definitionNative = "Одно занятие, где часть класса сидит в комнате, а часть подключается удалённо одновременно.",
            example = "מַצְלֵמָה רְחָבַת זָוִית הִכְרִיחָה אֶת לְמִידָה הִיבְּרִידִית לִפְעֹל חָלָק.",
            exampleNative = "Широкоугольная камера позволила לְמִידָה הִיבְּרִידִית работать гладко.",
            pos = "phrase", semanticGroup = "edu_edtech_formats", fillInBlankExclusions = listOf(190201L, 190202L, 190203L, 190204L)),

        // ── Group: edu_edtech_tools (5 words) ─────────────────────────────────

        WordEntity(id = 190206, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "מַעֲרֶכֶת לְנִיהוּל לְמִידָה",
            translation = "система управления обучением (LMS)",
            definition = "פְּלָטְפוֹרְמָה שֶׁבָּהּ מוֹרִים מַעֲלִים מְשִׂימוֹת, צִיּוּנִים וְחוֹמְרִים שֶׁל הַקּוּרְס כֻּלּוֹ.",
            definitionNative = "Платформа, где преподаватели публикуют задания, оценки и материалы всего курса.",
            example = "בֵּית הַסֵּפֶר עָבַר מ־Moodle ל־Canvas בְּגִלּוּי מַעֲרֶכֶת לְנִיהוּל לְמִידָה.",
            exampleNative = "Школа перешла с Moodle на Canvas, обновив מַעֲרֶכֶת לְנִיהוּל לְמִידָה.",
            pos = "phrase", semanticGroup = "edu_edtech_tools", fillInBlankExclusions = listOf(190207L, 190208L, 190209L, 190210L)),

        WordEntity(id = 190207, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "כִּתָּה וִירְטוּאָלִית",
            translation = "виртуальный класс",
            definition = "חֲדַר וִידֵאוֹ חַי שֶׁבּוֹ מוֹרֶה וְתַלְמִידִים נִפְגָּשִׁים אוֹנְלַיְן בִּמְקוֹם כִּתָּה אֲמִתִּית.",
            definitionNative = "Видеокомната в прямом эфире: учитель и ученики встречаются онлайн вместо настоящего класса.",
            example = "כִּתָּה וִירְטוּאָלִית נִפְתְּחָה בְּדִיּוּק בְּתֵשַׁע בַּבֹּקֶר.",
            exampleNative = "כִּתָּה וִירְטוּאָלִית открылась ровно в девять утра.",
            pos = "phrase", semanticGroup = "edu_edtech_tools", fillInBlankExclusions = listOf(190206L, 190208L, 190209L, 190210L)),

        WordEntity(id = 190208, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "חֲדַר פְּרִיצָה",
            translation = "сессионный зал (Zoom)",
            definition = "תַּת־חֶדֶר וִידֵאוֹ קָטָן וּפְרָטִי שֶׁבּוֹ קְבוּצָה מִן הַכִּתָּה עוֹבֶדֶת יַחַד כַּמָּה דַּקּוֹת.",
            definitionNative = "Маленькая отдельная видеокомната, где группа класса работает вместе несколько минут.",
            example = "הִיא שָׁלְחָה כָּל קְבוּצָה לְחֲדַר פְּרִיצָה לְעֶשֶׂר דַּקּוֹת.",
            exampleNative = "Она отправила каждую группу в חֲדַר פְּרִיצָה на десять минут.",
            pos = "phrase", semanticGroup = "edu_edtech_tools", fillInBlankExclusions = listOf(190206L, 190207L, 190209L, 190210L)),

        WordEntity(id = 190209, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "שִׁתּוּף מָסָךְ",
            translation = "демонстрация экрана",
            definition = "פִיצֵ'ר בְּכְלִי וִידֵאוֹ שֶׁמַּרְאֶה לְכָל הַמִּשְׁתַּתְּפִים אֶת מָסַךְ הַמַּצִּיג בִּזְמַן אֱמֶת.",
            definitionNative = "Функция в видеосвязи: показывает всем участникам экран докладчика в реальном времени.",
            example = "שִׁתּוּף מָסָךְ עָזַר לְצַיֵּג אֶת הַקּוֹד שׁוּרָה אַחַר שׁוּרָה.",
            exampleNative = "שִׁתּוּף מָסָךְ помог показать код строка за строкой.",
            pos = "phrase", semanticGroup = "edu_edtech_tools"),

        WordEntity(id = 190210, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "כְּתוּבִיוֹת אוֹטוֹמָטִיוֹת",
            translation = "автоматические субтитры",
            definition = "טֶקְסְט חַי מִתַּחַת לַוִּידֵאוֹ הַמַּרְאֶה מַה שֶּׁהַמַּרְצֶה אָמַר, נוֹצָר מִזִּהוּי דִּבּוּר.",
            definitionNative = "Бегущий текст под видео, показывающий слова лектора, создаётся распознаванием речи.",
            example = "כְּתוּבִיוֹת אוֹטוֹמָטִיוֹת עָזְרוּ לְסְטוּדֶנְט חֵרֵשׁ לַעֲקֹב אַחַר הַהַרְצָאָה.",
            exampleNative = "כְּתוּבִיוֹת אוֹטוֹמָטִיוֹת помогли глухому студенту следить за лекцией.",
            pos = "phrase", semanticGroup = "edu_edtech_tools", fillInBlankExclusions = listOf(190206L, 190207L, 190208L, 190209L)),

        // ── Group: edu_edtech_methods (5 words) ───────────────────────────────

        WordEntity(id = 190211, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "כִּתָּה הָפוּכָה",
            translation = "перевёрнутый класс",
            definition = "גִּישָׁה שֶׁבָּהּ הַתַּלְמִידִים צוֹפִים בְּהַרְצָאָה בַּבַּיִת וּמְנַצְּלִים אֶת זְמַן הַכִּתָּה לְתַרְגִּילִים עִם הַמּוֹרֶה.",
            definitionNative = "Подход: дома смотрят лекцию, а в классе делают упражнения с учителем.",
            example = "בְּכִתָּה הָפוּכָה הַיְּלָדִים צוֹפִים בִּשְׁבָרִים לִפְנֵי שִׁעוּר.",
            exampleNative = "В כִּתָּה הָפוּכָה дети смотрят про дроби перед уроком.",
            pos = "phrase", semanticGroup = "edu_edtech_methods"),

        WordEntity(id = 190212, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "גֵיימִיפִיקַצְיָה",
            translation = "геймификация",
            definition = "הוֹסָפַת אֶלֶמֶנְטֵי מִשְׂחָק — נְקֻדּוֹת, רָמוֹת, תָּגִים — לַשִּׁעוּרִים כְּדֵי לִשְׁמֹר עַל מְעוּרָבוּת.",
            definitionNative = "Добавление в уроки игровых элементов — очков, уровней, значков — для удержания вовлечённости.",
            example = "גֵיימִיפִיקַצְיָה שֶׁל דוּאוֹלִינְגוֹ מַחְזִיקָה מִשְׁתַּמְּשִׁים פְּעִילִים בְּכָל יוֹם.",
            exampleNative = "גֵיימִיפִיקַצְיָה Duolingo удерживает пользователей активными каждый день.",
            pos = "noun", semanticGroup = "edu_edtech_methods"),

        WordEntity(id = 190213, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "לְמִידָה אַדַּפְּטִיבִית",
            translation = "адаптивное обучение",
            definition = "תּוֹכְנָה שֶׁבּוֹחֶרֶת אֶת הַתַּרְגִּיל הַבָּא לְפִי דִּיּוּק הַתְּשׁוּבוֹת הַקּוֹדְמוֹת שֶׁל הַתַּלְמִיד.",
            definitionNative = "Программа подбирает следующее упражнение по точности предыдущих ответов ученика.",
            example = "לְמִידָה אַדַּפְּטִיבִית הֶחְזִירָה אוֹתוֹ לְשְׁבָרִים כְּשֶׁאַלְגֶּבְּרָה נֶחְלְשָׁה.",
            exampleNative = "לְמִידָה אַדַּפְּטִיבִית вернула его к дробям, когда алгебра просела.",
            pos = "phrase", semanticGroup = "edu_edtech_methods", fillInBlankExclusions = listOf(190211L, 190214L, 190215L)),

        WordEntity(id = 190214, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "לְמִידָה מְבוֹסֶּסֶת חֲקִירָה",
            translation = "исследовательское обучение",
            definition = "שִׁיטָה שֶׁבָּהּ הַמּוֹרֶה מַצִּיג שְׁאֵלָה פְּתוּחָה וְהַכִּתָּה מְחַפֶּשֶׂת רְאָיוֹת וּמְנַסְּחָה תְּשׁוּבָה.",
            definitionNative = "Метод: учитель задаёт открытый вопрос, а класс собирает доказательства и формулирует ответ.",
            example = "לְמִידָה מְבוֹסֶּסֶת חֲקִירָה הָפְכָה אֶת הַשִּׁעוּר לְדִיּוּן עַל בְּטִיחוּת.",
            exampleNative = "לְמִידָה מְבוֹסֶּסֶת חֲקִירָה превратила урок в дискуссию о безопасности.",
            pos = "phrase", semanticGroup = "edu_edtech_methods", fillInBlankExclusions = listOf(190211L, 190213L, 190215L)),

        WordEntity(id = 190215, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "שִׁיטַת סוֹקְרָטֶס",
            translation = "сократический метод",
            definition = "סִדְרַת שְׁאֵלוֹת מַנְחוֹת שֶׁבְּעֶזְרָתָן הַמּוֹרֶה מוֹבִיל אֶת הַתַּלְמִיד לְגַלּוֹת אֶת הַתְּשׁוּבָה בְּעַצְמוֹ.",
            definitionNative = "Серия наводящих вопросов: учитель ведёт ученика к самостоятельному открытию ответа.",
            example = "שִׁיטַת סוֹקְרָטֶס שִׁמְּשָׁה בְּפַקוּלְטוֹת הַמִּשְׁפָּטִים בְּהַרְוַארְד.",
            exampleNative = "שִׁיטַת סוֹקְרָטֶס используется на юрфаках Гарварда.",
            pos = "phrase", semanticGroup = "edu_edtech_methods", fillInBlankExclusions = listOf(190211L, 190213L, 190214L)),

        // ── Group: edu_edtech_pedagogy (5 words) ──────────────────────────────

        WordEntity(id = 190216, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "לְמִידָה עַצְמָאִית",
            translation = "обучение в своём темпе",
            definition = "פוֹרְמָט קוּרְס שֶׁבּוֹ כָּל לוֹמֵד מַחְלִיט מָתַי לְהַתְחִיל, בְּאֵיזֶה קֶצֶב לִלְמֹד וּמָתַי לְסַיֵּם.",
            definitionNative = "Формат курса, где каждый ученик сам решает, когда начать, как быстро идти и когда закончить.",
            example = "לְמִידָה עַצְמָאִית בְּפַיְתוֹן אִפְשְׁרָה לָהּ לִלְמֹד בַּהַפְסָקוֹת.",
            exampleNative = "לְמִידָה עַצְמָאִית по Python позволила ей учиться в перерывах.",
            pos = "phrase", semanticGroup = "edu_edtech_pedagogy", fillInBlankExclusions = listOf(190217L, 190219L, 190220L)),

        WordEntity(id = 190217, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "לְמִידָה בְּקוֹהוֹרְטָה",
            translation = "когортное обучение",
            definition = "קוּרְס אוֹנְלַיְן שֶׁבּוֹ הַסְּטוּדֶנְטִים מַתְחִילִים וּמְסַיְּמִים יַחַד עִם דֶּדְלַיְן שְׁבוּעִי וְקְבוּצַת שִׂיחָה.",
            definitionNative = "Онлайн-курс, где студенты стартуют и заканчивают вместе, с недельным дедлайном и групповым чатом.",
            example = "לְמִידָה בְּקוֹהוֹרְטָה יְקָרָה פִּי עֲשָׂרָה מ־MOOC אֲבָל שׁוֹמֶרֶת לוֹמְדִים.",
            exampleNative = "לְמִידָה בְּקוֹהוֹרְטָה в десять раз дороже MOOC, но удерживает учеников.",
            pos = "phrase", semanticGroup = "edu_edtech_pedagogy", fillInBlankExclusions = listOf(190216L, 190219L, 190220L)),

        WordEntity(id = 190218, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "אַנְדְּרָגוֹגְיָה",
            translation = "андрагогика",
            definition = "תְּחוּם הַחִינּוּךְ הָעוֹסֵק בְּשִׁיטוֹת לִמּוּד מְבוּגָּרִים, בְּשׁוֹנֶה מִפֶּדָגוֹגְיָה שֶׁל יְלָדִים.",
            definitionNative = "Раздел педагогики, изучающий методы обучения взрослых, в отличие от детской педагогики.",
            example = "אַנְדְּרָגוֹגְיָה מַדְגִּישָׁה אֶת נִסְיוֹן הַחַיִּים שֶׁל הַלּוֹמֵד הַמְּבוּגָּר.",
            exampleNative = "אַנְדְּרָגוֹגְיָה подчёркивает жизненный опыт взрослого ученика.",
            pos = "noun", semanticGroup = "edu_edtech_pedagogy"),

        WordEntity(id = 190219, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "לוּחַ דִּיגִיטָלִי שִׁתּוּפִי",
            translation = "интерактивная цифровая доска",
            definition = "מָסָךְ דִּיגִיטָלִי מְשֻׁתָּף שֶׁעָלָיו מוֹרֶה וְתַלְמִידִים מְצַיְּרִים, כּוֹתְבִים וּמְדַבְּקִים פֶּתֶק יַחַד.",
            definitionNative = "Общий цифровой экран, где учитель и ученики одновременно рисуют, пишут и клеят заметки.",
            example = "הִיא שִׂרְטְטָה תָּא עַל לוּחַ דִּיגִיטָלִי שִׁתּוּפִי בְּמִירוֹ.",
            exampleNative = "Она набросала клетку на לוּחַ דִּיגִיטָלִי שִׁתּוּפִי в Miro.",
            pos = "phrase", semanticGroup = "edu_edtech_pedagogy", fillInBlankExclusions = listOf(190216L, 190217L, 190220L)),

        WordEntity(id = 190220, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "סֶקֶר חַי",
            translation = "опрос в реальном времени (polling)",
            definition = "כְּלִי בְּפְלָטְפוֹרְמַת לְמִידָה שֶׁמַּצִּיג שְׁאֵלָה וּמְקַבֵּל תְּשׁוּבוֹת מִכָּל הַתַּלְמִידִים בְּשְׁנִיּוֹת.",
            definitionNative = "Инструмент в платформе обучения: задаёт вопрос и получает ответы всего класса за секунды.",
            example = "סֶקֶר חַי גִּלָּה שֶׁמַּחֲצִית הַכִּתָּה לֹא הֵבִינָה אֶת הַכְּלָל.",
            exampleNative = "סֶקֶר חַי показал, что половина класса не поняла правило.",
            pos = "phrase", semanticGroup = "edu_edtech_pedagogy", fillInBlankExclusions = listOf(190216L, 190217L, 190219L)),

        // ── Group: edu_edtech_content (5 words) ───────────────────────────────

        WordEntity(id = 190221, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "מַשְׁאַבֵי חִינּוּךְ פְּתוּחִים",
            translation = "открытые образовательные ресурсы (OER)",
            definition = "חוֹמְרֵי הוֹרָאָה בְּרִישָׁיוֹן הַמַּתִּיר לְכָל אָדָם לְהַעְתִּיק, לְשַׁנּוֹת וְלַעֲשׂוֹת בָּהֶם שִׁמּוּשׁ חִינָּם.",
            definitionNative = "Учебные материалы под лицензией, позволяющей любому копировать, изменять и повторно использовать их бесплатно.",
            example = "הַמִּכְלָלָה הֶחְלִיפָה סֵפֶר יָקָר בְּמַשְׁאַבֵי חִינּוּךְ פְּתוּחִים.",
            exampleNative = "Колледж заменил дорогой учебник на מַשְׁאַבֵי חִינּוּךְ פְּתוּחִים.",
            pos = "phrase", semanticGroup = "edu_edtech_content", fillInBlankExclusions = listOf(190222L, 190223L, 190224L, 190225L)),

        WordEntity(id = 190222, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "תָּג דִּיגִיטָלִי",
            translation = "цифровой бейдж (достижение)",
            definition = "סֶמֶל אוֹנְלַיְן בַּפְּרוֹפִיל הַמּוֹכִיחַ שֶׁהַלּוֹמֵד סִיֵּם קוּרְס אוֹ רָכַשׁ מְיוּמָנוּת.",
            definitionNative = "Онлайн-значок в профиле, подтверждающий, что ученик завершил курс или освоил навык.",
            example = "הִיא הִדְבִּיקָה תָּג דִּיגִיטָלִי שֶׁל גוּגֵל לַפְּרוֹפִיל בְּלִינְקְדְאִין.",
            exampleNative = "Она прикрепила תָּג דִּיגִיטָלִי от Google к профилю LinkedIn.",
            pos = "phrase", semanticGroup = "edu_edtech_content", fillInBlankExclusions = listOf(190221L, 190223L, 190224L, 190225L)),

        WordEntity(id = 190223, setId = 1902, languagePair = "he-ru", rarity = "RARE",
            original = "נְתִיב לְמִידָה",
            translation = "учебная траектория",
            definition = "סֵדֶר מְתֻכְנָן שֶׁל קוּרְסִים אוֹ נוֹשְׂאִים שֶׁמּוֹבִיל אֶת הַלּוֹמֵד מֵרָמַת פְּתִיחָה עַד מַטָּרָה בְּרוּרָה.",
            definitionNative = "Запланированный порядок курсов или тем, ведущий ученика от стартового уровня к чёткой цели.",
            example = "לִינְקְדְאִין הִצִּיעַ נְתִיב לְמִידָה שֶׁל שִׁשָּׁה קוּרְסִים לְמְנַהֵל מוּצָר.",
            exampleNative = "LinkedIn предложил נְתִיב לְמִידָה из шести курсов до менеджера продукта.",
            pos = "phrase", semanticGroup = "edu_edtech_content", fillInBlankExclusions = listOf(190221L, 190222L, 190224L, 190225L)),

        WordEntity(id = 190224, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "הַסְמָכַת מִיקְרוֹ",
            translation = "микросертификат",
            definition = "תְּעוּדָה רִשְׁמִית קְצָרָה שֶׁמּוֹכִיחָה מְיוּמָנוּת אַחַת צָרָה, קְטַנָּה הַרְבֵּה יוֹתֵר מִדִּיפְּלוֹמָה.",
            definitionNative = "Короткая формальная квалификация, подтверждающая один узкий навык, гораздо меньше полного диплома.",
            example = "הַסְמָכַת מִיקְרוֹ בְּ־SQL הֵבִיאָה לָהּ שָׁלוֹשׁ שִׂיחוֹת מִמְּגַיְּסִים.",
            exampleNative = "הַסְמָכַת מִיקְרוֹ по SQL принёс ей три звонка от рекрутёров.",
            pos = "phrase", semanticGroup = "edu_edtech_content"),

        WordEntity(id = 190225, setId = 1902, languagePair = "he-ru", rarity = "EPIC",
            original = "אוֹרְיָנוּת דִּיגִיטָלִית",
            translation = "цифровая грамотность",
            definition = "מְיוּמָנוּת לִמְצֹא, לְהַעֲרִיךְ וְלִיצֹר תּוֹכֶן בַּרֶשֶׁת בְּצוּרָה בְּטוּחָה וּבִיקּוּרְתִּית.",
            definitionNative = "Умение находить, оценивать и создавать контент в сети безопасно и критически.",
            example = "תָּכְנִית הַלִּימּוּדִים הוֹסִיפָה אוֹרְיָנוּת דִּיגִיטָלִית מִכִּתָּה ז.",
            exampleNative = "Учебная программа добавила אוֹרְיָנוּת דִּיגִיטָלִית с 7-го класса.",
            pos = "phrase", semanticGroup = "edu_edtech_content", fillInBlankExclusions = listOf(190221L, 190222L, 190223L, 190224L)),
    )
}
