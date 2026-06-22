package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Дети и школа в Израиле (he-ru), уровень 2 — продвинутый базовый: ган, цаhарон,
 * родительские собрания, кружки. setId = 1813. Параллельно — L1 (1812).
 *
 * Подтемы (5×5):
 *   - school_kindergarten   — детсад: גַּן יְלָדִים, גַּן חוֹבָה, גַּנֶּנֶת, פָּעוֹטוֹן, מַעוֹן יוֹם
 *   - school_after_school   — после школы: צַהֲרוֹן, חוּג עַל יְסוֹדִי, מַטְפֶלֶת, חוּג מְחֻיָּב, מָסַע סִיוּם
 *   - school_meetings       — встречи: אֲסֵפַת הוֹרִים, וַעַד הוֹרִים, פְּגִישָׁה אִישִׁית, מַחְבֶּרֶת תִּקְשׁוֹרֶת, יוֹם הוֹרִים
 *   - school_activities     — кружки: חוּג צִיּוּר, חוּג שָׂחְמָט, חוּג סְפּוֹרְט, חוּג רוֹבּוֹטִיקָה, מַקְהֵלָה
 *   - school_routine        — режим: בִּקּוּר אִישִׁי, נוֹכְחוּת, חִיסּוּר, אִחוּר, פֶּסֶק זְמַן
 *
 * Rarity: 13 UNCOMMON + 12 RARE (разброс 2 смежных, OK для L2).
 *
 * Все слова помечены isFillInBlankSafe=false до прохождения FILL_IN_BLANK
 * pipeline (см. docs/claude/fill-in-blank-pipeline.md).
 */
object WordDataHebrewSchoolL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1813,
            languagePair = "he-ru",
            orderIndex = 1813,
            name = "Дети и школа в Израиле",
            description = "Продвинутый базовый: ган, цаhарон, родсобрание, кружки",
            topic = "Дети и школа в Израиле",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── school_kindergarten (5) ─────────────────────────────────────────

        WordEntity(
            id = 181301, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גַּן יְלָדִים",
            translation = "детский сад",
            definition = "מָקוֹם שֶׁבּוֹ שׁוֹהִים יְלָדִים קְטַנִּים בבוקר עִם מְטַפֶּלֶת וּמְשַׂחֲקִים.",
            definitionNative = "Место, куда родители отводят маленьких детей днём — с играми и присмотром.",
            example = "אֲנַחְנוּ רוֹשְׁמִים אֶת הַבֵּן שֶׁלָּנוּ ל גַּן יְלָדִים בַּשְּׁכוּנָה.",
            exampleNative = "Мы записываем сына в детский сад в нашем районе.",
            pos = "noun",
            semanticGroup = "school_kindergarten", fillInBlankExclusions = listOf(181302L, 181303L, 181304L, 181305L, 181306L)),

        WordEntity(
            id = 181302, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גַּן חוֹבָה",
            translation = "обязательная подготовительная группа",
            definition = "הַשָּׁנָה לִפְנֵי כיתה א שֶׁבָּהּ הַיְּלָדִים לוֹמְדִים וּמִתְכּוֹנְנִים לְבֵית הַסֵּפֶר.",
            definitionNative = "Год перед первым классом — дети учатся и готовятся к школе.",
            example = "הַבַּת שֶׁלִּי עוֹבֶרֶת הַשָּׁנָה ל גַּן חוֹבָה.",
            exampleNative = "Моя дочь в этом году идёт в обязательную подготовительную группу.",
            pos = "noun",
            semanticGroup = "school_kindergarten", fillInBlankExclusions = listOf(181301L, 181303L, 181304L, 181305L)),

        WordEntity(
            id = 181303, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גַּנֶּנֶת",
            translation = "воспитательница в детсаду",
            definition = "אישה שֶׁעוֹבֶדֶת עִם יְלָדִים קְטַנִּים וּמְלַמֶּדֶת אוֹתָם לְשַׂחֵק וללמוד.",
            definitionNative = "Женщина, которая работает с малышами — учит играть и общаться.",
            example = "ה גַּנֶּנֶת קוֹרֵאת סיפור לִילָדִים בבוקר.",
            exampleNative = "Воспитательница читает детям книжку по утрам.",
            pos = "noun",
            semanticGroup = "school_kindergarten", fillInBlankExclusions = listOf(181301L, 181302L, 181304L, 181305L, 181308L)),

        WordEntity(
            id = 181304, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "פָּעוֹטוֹן",
            translation = "ясли (для самых маленьких)",
            definition = "מָקוֹם לְתִינוֹקוֹת וּפָעוֹטוֹת עַד גִּיל שָׁלוֹשׁ שֶׁעוֹבְדִים שָׁם הוֹרֵיהֶם.",
            definitionNative = "Группа для малышей до трёх лет, пока их родители на работе.",
            example = "הַפָּעוֹט שֶׁלָּנוּ הוֹלֵךְ כָּל בוקר ל פָּעוֹטוֹן.",
            exampleNative = "Наш малыш каждое утро идёт в ясли.",
            pos = "noun",
            semanticGroup = "school_kindergarten", fillInBlankExclusions = listOf(181301L, 181302L, 181303L, 181305L, 181306L)),

        WordEntity(
            id = 181305, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "מַעוֹן יוֹם",
            translation = "ясли-сад при минтруде",
            definition = "מִסְגֶּרֶת לְתִינוֹקוֹת וּפָעוֹטוֹת בפיקוח הַמְּדִינָה עִם סִבְסוּד לְהוֹרִים עוֹבְדִים.",
            definitionNative = "Дневная группа для малышей под надзором государства, со скидкой работающим.",
            example = "קיבלנו סִבְסוּד עֲבוּר מַעוֹן יוֹם שֶׁל הַבַּת שֶׁלנו.",
            exampleNative = "Нам дали скидку на ясли-сад для дочери.",
            pos = "noun",
            semanticGroup = "school_kindergarten", fillInBlankExclusions = listOf(181301L, 181302L, 181303L, 181304L, 181306L)),

        // ── school_after_school (5) ─────────────────────────────────────────

        WordEntity(
            id = 181306, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צַהֲרוֹן",
            translation = "продлёнка",
            definition = "מִסְגֶּרֶת אַחֲרֵי שְׁעוֹת הלימודים שֶׁבָּהּ הַיְּלָדִים אוֹכְלִים וּמְכִינִים שיעורים.",
            definitionNative = "Группа после уроков — дети обедают и делают домашку под присмотром.",
            example = "הַיֶּלֶד שֶׁלָּנוּ נִשְׁאַר ב צַהֲרוֹן עַד אַרְבַּע אַחַר הצהריים.",
            exampleNative = "Наш ребёнок остаётся в продлёнке до четырёх часов.",
            pos = "noun",
            semanticGroup = "school_after_school", fillInBlankExclusions = listOf(181307L, 181308L, 181309L, 181310L)),

        WordEntity(
            id = 181307, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חוּג עַל יְסוֹדִי",
            translation = "факультатив сверх базы",
            definition = "פְּעִילוּת נוֹסֶפֶת אַחֲרֵי הלימודים שֶׁאֵינָהּ חֵלֶק מִתָּכְנִית הלימודים הָרְגִילָה.",
            definitionNative = "Дополнительное занятие после уроков — за рамками обязательной программы.",
            example = "הוּא רָשׁוּם ל חוּג עַל יְסוֹדִי שֶׁל מתמטיקה בְּיוֹם שֶׁלישי.",
            exampleNative = "Он ходит на факультатив сверх базы по математике по вторникам.",
            pos = "noun",
            semanticGroup = "school_after_school", fillInBlankExclusions = listOf(181306L, 181308L, 181309L, 181310L, 181316L, 181318L, 181319L, 181320L)),

        WordEntity(
            id = 181308, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְטַפֶּלֶת",
            translation = "няня",
            definition = "אִשָּׁה שֶׁשּׁוֹמֶרֶת עַל יְלָדִים קְטַנִּים וְדוֹאֶגֶת לָהֶם בַּגַּן אוֹ בַּבַּיִת.",
            definitionNative = "Женщина, которая сидит с детьми дома или забирает их из садика.",
            example = "ה מְטַפֶּלֶת אוֹסֶפֶת אֶת הַיְּלָדִים מֵהַגַּן בְּאַרְבַּע.",
            exampleNative = "Няня забирает детей из сада в четыре часа.",
            pos = "noun",
            semanticGroup = "school_after_school", fillInBlankExclusions = listOf(181303L, 181306L, 181307L, 181309L, 181310L)),

        WordEntity(
            id = 181309, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "חוּג מְחֻיָּב",
            translation = "обязательная секция",
            definition = "פְּעִילוּת אַחַר הצהריים שֶׁכָּל תַּלְמִיד בכיתה חייב לְהִשְׁתַּתֵּף בָּהּ.",
            definitionNative = "Послеурочное занятие, на которое обязан ходить каждый ученик класса.",
            example = "הַשָּׁנָה יֵשׁ לְכָל הכיתה חוּג מְחֻיָּב שֶׁל סְפּוֹרְט.",
            exampleNative = "В этом году у всего класса обязательная секция по спорту.",
            pos = "noun",
            semanticGroup = "school_after_school", fillInBlankExclusions = listOf(181306L, 181307L, 181308L, 181310L)),

        WordEntity(
            id = 181310, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "מָסַע סִיוּם",
            translation = "выпускной поход",
            definition = "טִיּוּל ארוך שֶׁל תַּלְמִידִים בְּסוֹף הַשָּׁנָה לרגל סִיּוּם שֶׁל שֶׁלב לימודים.",
            definitionNative = "Долгая поездка класса в конце года — по случаю окончания этапа учёбы.",
            example = "הכיתה יוֹצֵאת ל מַסַּע סִיוּם בַּצָּפוֹן בַּשָּׁבוּעַ הַבָּא.",
            exampleNative = "Класс едет в выпускной поход на север на следующей неделе.",
            pos = "noun",
            semanticGroup = "school_after_school", fillInBlankExclusions = listOf(181306L, 181307L, 181308L, 181309L)),

        // ── school_meetings (5) ─────────────────────────────────────────────

        WordEntity(
            id = 181311, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֲסֵפַת הוֹרִים",
            translation = "родительское собрание",
            definition = "מִפְגָּשׁ שֶׁל מְחַנֶּכֶת עִם כָּל הַהוֹרִים בכיתה לְעִדְכּוּן עַל הִתְקַדְּמוּת הַתַּלְמִידִים.",
            definitionNative = "Встреча учительницы со всеми родителями класса — об успехах детей.",
            example = "ה אֲסֵפַת הוֹרִים תתקיים בְּיוֹם רְבִיעִי בערב.",
            exampleNative = "Родительское собрание пройдёт в среду вечером.",
            pos = "noun",
            semanticGroup = "school_meetings", fillInBlankExclusions = listOf(181312L, 181313L, 181314L, 181315L)),

        WordEntity(
            id = 181312, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "וַעַד הוֹרִים",
            translation = "родительский комитет",
            definition = "קְבוּצָה נִבְחֶרֶת שֶׁל הוֹרִים שֶׁעוֹזֶרֶת לכיתה וּמְאַרְגֶּנֶת אירועים וּפְעִילוּיוֹת.",
            definitionNative = "Выбранная группа родителей — помогает классу и устраивает мероприятия.",
            example = "ה וַעַד הוֹרִים מְאַרְגֵּן מסיבת סוֹף שָׁנָה לכיתה.",
            exampleNative = "Родительский комитет организует праздник в конце года.",
            pos = "noun",
            semanticGroup = "school_meetings", fillInBlankExclusions = listOf(181311L, 181313L, 181314L, 181315L)),

        WordEntity(
            id = 181313, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּגִישָׁה אִישִׁית",
            translation = "личная встреча с учителем",
            definition = "שִׂיחָה פְּרָטִית שֶׁל הוֹרִים עִם הַמְּחַנֶּכֶת לְדַבֵּר עַל תַּלְמִיד אֶחָד בִּלְבַד.",
            definitionNative = "Частный разговор родителей с учительницей — только об одном ученике.",
            example = "קָבַעְתִּי פְּגִישָׁה אִישִׁית עִם הַמְּחַנֶּכֶת עַל הַצִּיּוּנִים.",
            exampleNative = "Я записался на личную встречу с учителем — поговорить об оценках.",
            pos = "noun",
            semanticGroup = "school_meetings", fillInBlankExclusions = listOf(181311L, 181312L, 181314L, 181315L)),

        WordEntity(
            id = 181314, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "מַחְבֶּרֶת תִּקְשׁוֹרֶת",
            translation = "дневник связи с родителями",
            definition = "מַחְבֶּרֶת קְטַנָּה שֶׁעוֹבֶרֶת בֵּין הַבַּיִת לכיתה עִם הוֹדָעוֹת יוֹמִיּוֹת בֵּין צַד לצַד.",
            definitionNative = "Тетрадка, которая курсирует между домом и классом — с записками каждый день.",
            example = "הַמְּחַנֶּכֶת רָשְׁמָה הֶעָרָה ב מַחְבֶּרֶת תִּקְשׁוֹרֶת אֶתְמוֹל.",
            exampleNative = "Учительница вчера оставила запись в дневнике связи с родителями.",
            pos = "noun",
            semanticGroup = "school_meetings", fillInBlankExclusions = listOf(181311L, 181312L, 181313L, 181315L)),

        WordEntity(
            id = 181315, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "יוֹם הוֹרִים",
            translation = "день открытых дверей в школе",
            definition = "יוֹם שֶׁבּוֹ הַהוֹרִים מַגִּיעִים לְבֵית הַסֵּפֶר לִרְאוֹת אֶת הכיתה ולפגוש מוֹרִים.",
            definitionNative = "День, когда родители приходят в школу — увидеть класс и поговорить с учителями.",
            example = "ה יוֹם הוֹרִים מתקיים פַּעַם בסמסטר אַחַר הצהריים.",
            exampleNative = "День открытых дверей в школе бывает раз в семестр после обеда.",
            pos = "noun",
            semanticGroup = "school_meetings", fillInBlankExclusions = listOf(181311L, 181312L, 181313L, 181314L)),

        // ── school_activities (5) ───────────────────────────────────────────

        WordEntity(
            id = 181316, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חוּג צִיּוּר",
            translation = "кружок рисования",
            definition = "פְּעִילוּת אַחֲרֵי הלימודים שֶׁבָּהּ הַיְּלָדִים מציירים בִּצְבָעִים וְלוֹמְדִים אומנות.",
            definitionNative = "Занятие после уроков — дети рисуют красками и учатся искусству.",
            example = "הַיַּלְדָּה שֶׁלִּי הוֹלֶכֶת ל חוּג צִיּוּר פעמיים בְּשָׁבוּעַ.",
            exampleNative = "Моя дочь ходит на кружок рисования два раза в неделю.",
            pos = "noun",
            semanticGroup = "school_activities", fillInBlankExclusions = listOf(181317L, 181318L, 181319L, 181320L)),

        WordEntity(
            id = 181317, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַקְהֵלָה",
            translation = "хор (детский)",
            definition = "קְבוּצָה שֶׁל תַּלְמִידִים שֶׁשָּׁרִים יַחַד בליווי מורה לְמוּזִיקָה וּמוֹפִיעִים באירועים.",
            definitionNative = "Группа учеников — поют вместе с учителем музыки и выступают на праздниках.",
            example = "הוּא הִצְטָרֵף ל מַקְהֵלָה שֶׁל בֵּית הַסֵּפֶר הַשָּׁנָה.",
            exampleNative = "Он в этом году пришёл в מַקְהֵלָה школы.",
            pos = "noun",
            semanticGroup = "school_activities", fillInBlankExclusions = listOf(181316L, 181318L, 181319L, 181320L)),

        WordEntity(
            id = 181318, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "חוּג שָׂחְמָט",
            translation = "шахматный кружок",
            definition = "מִפְגָּשׁ שְׁבוּעִי שֶׁבּוֹ יְלָדִים לוֹמְדִים לְשַׂחֵק עַל לוּחַ עִם כֵּלִים שחורים וּלְבָנִים.",
            definitionNative = "Еженедельная встреча — дети учатся играть на доске с чёрными и белыми фигурами.",
            example = "הַבֵּן שֶׁלִּי זָכָה בְּטוּרְנִיר שֶׁל חוּג שָׂחְמָט בַּשָּׁבוּעַ שֶׁעָבַר.",
            exampleNative = "Мой сын на прошлой неделе выиграл турнир шахматного кружка.",
            pos = "noun",
            semanticGroup = "school_activities", fillInBlankExclusions = listOf(181316L, 181317L, 181319L, 181320L)),

        WordEntity(
            id = 181319, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חוּג סְפּוֹרְט",
            translation = "спортивная секция",
            definition = "פְּעִילוּת גּוּפָנִית קְבוּצָתִית שֶׁבָּהּ הַיְּלָדִים מִתְאַמְּנִים עִם מְאַמֵּן פעִם אוֹ פעמיים בְּשָׁבוּעַ.",
            definitionNative = "Командные занятия — дети тренируются с тренером раз или два в неделю.",
            example = "אֲנַחְנוּ מַסִּיעִים אוֹתוֹ ל חוּג סְפּוֹרְט אַחֲרֵי הלימודים.",
            exampleNative = "Мы возим его на спортивную секцию после уроков.",
            pos = "noun",
            semanticGroup = "school_activities", fillInBlankExclusions = listOf(181316L, 181317L, 181318L, 181320L)),

        WordEntity(
            id = 181320, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "חוּג רוֹבּוֹטִיקָה",
            translation = "кружок робототехники",
            definition = "פְּעִילוּת שֶׁבָּהּ יְלָדִים בּוֹנִים מְכוֹנוֹת קְטַנּוֹת מְחַלְּקִים וּמְתַכְנְתִים אוֹתָן בְּמַחְשֵׁב.",
            definitionNative = "Занятие, где дети собирают маленькие машинки из деталей и программируют их.",
            example = "הוּא בָּנָה רוֹבּוֹט עִם גַּלְגַּלִּים ב חוּג רוֹבּוֹטִיקָה.",
            exampleNative = "Он собрал робота на колёсах в кружке робототехники.",
            pos = "noun",
            semanticGroup = "school_activities", fillInBlankExclusions = listOf(181316L, 181317L, 181318L, 181319L)),

        // ── school_routine (5) ──────────────────────────────────────────────

        WordEntity(
            id = 181321, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "בִּקּוּר אִישִׁי",
            translation = "посещаемость (личная отметка)",
            definition = "סימון מִי הִגִּיעַ לכיתה בְּיוֹם נָתוּן בְּכָל שיעור עַל יְדֵי מְחַנֵּךְ.",
            definitionNative = "Отметка, кто пришёл в класс в этот день — по каждому уроку учителем.",
            example = "הַמּוֹרֶה רוֹשֵׁם בִּקּוּר אִישִׁי בתחילת כָּל שיעור.",
            exampleNative = "Учитель отмечает посещаемость в начале каждого урока.",
            pos = "noun",
            semanticGroup = "school_routine", fillInBlankExclusions = listOf(181322L, 181323L, 181324L, 181325L)),

        WordEntity(
            id = 181322, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נוֹכְחוּת",
            translation = "присутствие на уроках",
            definition = "כַּמָּה יָמִים תַּלְמִיד הָיָה בְּבֵית הַסֵּפֶר בְּמֶשֶׁךְ תְּקוּפָה וְלֹא נֶעְדָּר.",
            definitionNative = "Сколько дней ученик был в школе за период и не пропускал.",
            example = "בַּתְּעוּדָה כָּתוּב שֶׂה נוֹכְחוּת שֶׁלּוֹ בְּסֵדֶר גָּמוּר.",
            exampleNative = "В табеле написано, что присутствие на уроках у него в порядке.",
            pos = "noun",
            semanticGroup = "school_routine", fillInBlankExclusions = listOf(181321L, 181323L, 181324L, 181325L)),

        WordEntity(
            id = 181323, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "חִיסּוּר",
            translation = "пропуск занятия",
            definition = "יוֹם אוֹֹ שיעור שֶׁתַּלְמִיד לֹא הָיָה בּוֹ בְּלִי אישור אוֹֹ עִם אישור מֵהַהוֹרִים.",
            definitionNative = "День или урок, когда ученика не было — со справкой или без неё.",
            example = "הַמְּחַנֶּכֶת ביקשה הֶסְבֵּר עַל ה חִיסּוּר שֶׁל אֶתְמוֹל.",
            exampleNative = "Учительница попросила объяснение пропуска занятия за вчера.",
            pos = "noun",
            semanticGroup = "school_routine", fillInBlankExclusions = listOf(181321L, 181322L, 181324L, 181325L)),

        WordEntity(
            id = 181324, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִחוּר",
            translation = "опоздание",
            definition = "כְּשֶׁתַּלְמִיד מַגִּיעַ לכיתה אַחֲרֵי שהשיעור כְּבָר הִתְחִיל בַּזְּמַן.",
            definitionNative = "Когда ученик приходит в класс уже после начала урока.",
            example = "הַמּוֹרֶה כָּעֲסָה עַל ה אִחוּר שֶׁל חֲצִי שָׁעָה הבוקר.",
            exampleNative = "Учительница рассердилась за опоздание на полчаса утром.",
            pos = "noun",
            semanticGroup = "school_routine", fillInBlankExclusions = listOf(181321L, 181322L, 181323L, 181325L)),

        WordEntity(
            id = 181325, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "פֶּסֶק זְמַן",
            translation = "перерыв (между уроками)",
            definition = "זְמַן קָצָר בֵּין שיעורים שֶׁבּוֹ הַיְּלָדִים יוֹצְאִים לֶחָצֵר אוֹכְלִים וּמְשַׂחֲקִים.",
            definitionNative = "Короткое время между уроками — дети выходят во двор, едят и играют.",
            example = "ב פֶּסֶק זְמַן הַיְּלָדִים אוֹכְלִים כָּרִיךְ וְרָצִים בֶּחָצֵר.",
            exampleNative = "В перерыв дети едят бутерброд и бегают по двору.",
            pos = "noun",
            semanticGroup = "school_routine", fillInBlankExclusions = listOf(181321L, 181322L, 181323L, 181324L)),
    )
}
