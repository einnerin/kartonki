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
            transliteration = "gan yeladim",
            translation = "детский сад",
            definition = "מקום שבו שוהים ילדים קטנים בבוקר עם מטפלת ומשחקים",
            definitionNative = "Место, куда родители отводят маленьких детей днём — с играми и присмотром.",
            example = "אנחנו רושמים את הבן שלנו ל גַּן יְלָדִים בשכונה",
            exampleNative = "Мы записываем сына в детский сад в нашем районе.",
            pos = "noun",
            semanticGroup = "school_kindergarten",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181302, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גַּן חוֹבָה",
            transliteration = "gan khova",
            translation = "обязательная подготовительная группа",
            definition = "השנה לפני כיתה א שבה הילדים לומדים ומתכוננים לבית הספר",
            definitionNative = "Год перед первым классом — дети учатся и готовятся к школе.",
            example = "הבת שלי עוברת השנה ל גַּן חוֹבָה",
            exampleNative = "Моя дочь в этом году идёт в обязательную подготовительную группу.",
            pos = "noun",
            semanticGroup = "school_kindergarten",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181303, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גַּנֶּנֶת",
            transliteration = "ganenet",
            translation = "воспитательница в детсаду",
            definition = "אישה שעובדת עם ילדים קטנים ומלמדת אותם לשחק וללמוד",
            definitionNative = "Женщина, которая работает с малышами — учит играть и общаться.",
            example = "ה גַּנֶּנֶת קוראת סיפור לילדים בבוקר",
            exampleNative = "Воспитательница читает детям книжку по утрам.",
            pos = "noun",
            semanticGroup = "school_kindergarten",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181304, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "פָּעוֹטוֹן",
            transliteration = "pa'oton",
            translation = "ясли (для самых маленьких)",
            definition = "מקום לתינוקות ופעוטות עד גיל שלוש שעובדים שם הוריהם",
            definitionNative = "Группа для малышей до трёх лет, пока их родители на работе.",
            example = "הפעוט שלנו הולך כל בוקר ל פָּעוֹטוֹן",
            exampleNative = "Наш малыш каждое утро идёт в ясли.",
            pos = "noun",
            semanticGroup = "school_kindergarten",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181305, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "מַעוֹן יוֹם",
            transliteration = "ma'on yom",
            translation = "ясли-сад при минтруде",
            definition = "מסגרת לתינוקות ופעוטות בפיקוח המדינה עם סבסוד להורים עובדים",
            definitionNative = "Дневная группа для малышей под надзором государства, со скидкой работающим.",
            example = "קיבלנו סבסוד עבור מַעוֹן יוֹם של הבת שלנו",
            exampleNative = "Нам дали скидку на ясли-сад для дочери.",
            pos = "noun",
            semanticGroup = "school_kindergarten",
            isFillInBlankSafe = false),

        // ── school_after_school (5) ─────────────────────────────────────────

        WordEntity(
            id = 181306, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צַהֲרוֹן",
            transliteration = "tsaharon",
            translation = "продлёнка",
            definition = "מסגרת אחרי שעות הלימודים שבה הילדים אוכלים ומכינים שיעורים",
            definitionNative = "Группа после уроков — дети обедают и делают домашку под присмотром.",
            example = "הילד שלנו נשאר ב צַהֲרוֹן עד ארבע אחר הצהריים",
            exampleNative = "Наш ребёнок остаётся в продлёнке до четырёх часов.",
            pos = "noun",
            semanticGroup = "school_after_school",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181307, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חוּג עַל יְסוֹדִי",
            transliteration = "khug al yesodi",
            translation = "факультатив сверх базы",
            definition = "פעילות נוספת אחרי הלימודים שאינה חלק מתכנית הלימודים הרגילה",
            definitionNative = "Дополнительное занятие после уроков — за рамками обязательной программы.",
            example = "הוא רשום ל חוּג עַל יְסוֹדִי של מתמטיקה ביום שלישי",
            exampleNative = "Он ходит на факультатив сверх базы по математике по вторникам.",
            pos = "noun",
            semanticGroup = "school_after_school",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181308, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַטְפֶלֶת",
            transliteration = "metapelet",
            translation = "няня",
            definition = "אישה שמטפלת בילדים בבית או אוספת אותם מהמסגרת אחר הצהריים",
            definitionNative = "Женщина, которая сидит с детьми дома или забирает их из садика.",
            example = "ה מַטְפֶלֶת אוספת את הילדים מהגן בארבע",
            exampleNative = "Няня забирает детей из сада в четыре часа.",
            pos = "noun",
            semanticGroup = "school_after_school",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181309, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "חוּג מְחֻיָּב",
            transliteration = "khug mekhuyav",
            translation = "обязательная секция",
            definition = "פעילות אחר הצהריים שכל תלמיד בכיתה חייב להשתתף בה",
            definitionNative = "Послеурочное занятие, на которое обязан ходить каждый ученик класса.",
            example = "השנה יש לכל הכיתה חוּג מְחֻיָּב של ספורט",
            exampleNative = "В этом году у всего класса обязательная секция по спорту.",
            pos = "noun",
            semanticGroup = "school_after_school",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181310, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "מָסַע סִיוּם",
            transliteration = "masa siyum",
            translation = "выпускной поход",
            definition = "טיול ארוך של תלמידים בסוף השנה לרגל סיום של שלב לימודים",
            definitionNative = "Долгая поездка класса в конце года — по случаю окончания этапа учёбы.",
            example = "הכיתה יוצאת ל מָסַע סִיוּם בצפון בשבוע הבא",
            exampleNative = "Класс едет в выпускной поход на север на следующей неделе.",
            pos = "noun",
            semanticGroup = "school_after_school",
            isFillInBlankSafe = false),

        // ── school_meetings (5) ─────────────────────────────────────────────

        WordEntity(
            id = 181311, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֲסֵפַת הוֹרִים",
            transliteration = "asefat horim",
            translation = "родительское собрание",
            definition = "מפגש של מחנכת עם כל ההורים בכיתה לעדכון על התקדמות התלמידים",
            definitionNative = "Встреча учительницы со всеми родителями класса — об успехах детей.",
            example = "ה אֲסֵפַת הוֹרִים תתקיים ביום רביעי בערב",
            exampleNative = "Родительское собрание пройдёт в среду вечером.",
            pos = "noun",
            semanticGroup = "school_meetings",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181312, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "וַעַד הוֹרִים",
            transliteration = "va'ad horim",
            translation = "родительский комитет",
            definition = "קבוצה נבחרת של הורים שעוזרת לכיתה ומארגנת אירועים ופעילויות",
            definitionNative = "Выбранная группа родителей — помогает классу и устраивает мероприятия.",
            example = "ה וַעַד הוֹרִים מארגן מסיבת סוף שנה לכיתה",
            exampleNative = "Родительский комитет организует праздник в конце года.",
            pos = "noun",
            semanticGroup = "school_meetings",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181313, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּגִישָׁה אִישִׁית",
            transliteration = "pgisha ishit",
            translation = "личная встреча с учителем",
            definition = "שיחה פרטית של הורים עם המחנכת לדבר על תלמיד אחד בלבד",
            definitionNative = "Частный разговор родителей с учительницей — только об одном ученике.",
            example = "קבעתי פְּגִישָׁה אִישִׁית עם המחנכת על הציונים",
            exampleNative = "Я записался на личную встречу с учителем — поговорить об оценках.",
            pos = "noun",
            semanticGroup = "school_meetings",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181314, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "מַחְבֶּרֶת תִּקְשׁוֹרֶת",
            transliteration = "makhberet tikshoret",
            translation = "дневник связи с родителями",
            definition = "מחברת קטנה שעוברת בין הבית לכיתה עם הודעות יומיות בין צד לצד",
            definitionNative = "Тетрадка, которая курсирует между домом и классом — с записками каждый день.",
            example = "המחנכת רשמה הערה ב מַחְבֶּרֶת תִּקְשׁוֹרֶת אתמול",
            exampleNative = "Учительница вчера оставила запись в дневнике связи с родителями.",
            pos = "noun",
            semanticGroup = "school_meetings",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181315, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "יוֹם הוֹרִים",
            transliteration = "yom horim",
            translation = "день открытых дверей в школе",
            definition = "יום שבו ההורים מגיעים לבית הספר לראות את הכיתה ולפגוש מורים",
            definitionNative = "День, когда родители приходят в школу — увидеть класс и поговорить с учителями.",
            example = "ה יוֹם הוֹרִים מתקיים פעם בסמסטר אחר הצהריים",
            exampleNative = "День открытых дверей в школе бывает раз в семестр после обеда.",
            pos = "noun",
            semanticGroup = "school_meetings",
            isFillInBlankSafe = false),

        // ── school_activities (5) ───────────────────────────────────────────

        WordEntity(
            id = 181316, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חוּג צִיּוּר",
            transliteration = "khug tsiyur",
            translation = "кружок рисования",
            definition = "פעילות אחרי הלימודים שבה הילדים מציירים בצבעים ולומדים אומנות",
            definitionNative = "Занятие после уроков — дети рисуют красками и учатся искусству.",
            example = "הילדה שלי הולכת ל חוּג צִיּוּר פעמיים בשבוע",
            exampleNative = "Моя дочь ходит на кружок рисования два раза в неделю.",
            pos = "noun",
            semanticGroup = "school_activities",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181317, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַקְהֵלָה",
            transliteration = "makhela",
            translation = "хор (детский)",
            definition = "קבוצה של תלמידים ששרים יחד בליווי מורה למוזיקה ומופיעים באירועים",
            definitionNative = "Группа учеников — поют вместе с учителем музыки и выступают на праздниках.",
            example = "הוא הצטרף ל מַקְהֵלָה של בית הספר השנה",
            exampleNative = "Он в этом году пришёл в хор школы.",
            pos = "noun",
            semanticGroup = "school_activities",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181318, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "חוּג שָׂחְמָט",
            transliteration = "khug sakhmat",
            translation = "шахматный кружок",
            definition = "מפגש שבועי שבו ילדים לומדים לשחק על לוח עם כלים שחורים ולבנים",
            definitionNative = "Еженедельная встреча — дети учатся играть на доске с чёрными и белыми фигурами.",
            example = "הבן שלי זכה בטורניר של חוּג שָׂחְמָט בשבוע שעבר",
            exampleNative = "Мой сын на прошлой неделе выиграл турнир шахматного кружка.",
            pos = "noun",
            semanticGroup = "school_activities",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181319, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חוּג סְפּוֹרְט",
            transliteration = "khug sport",
            translation = "спортивная секция",
            definition = "פעילות גופנית קבוצתית שבה הילדים מתאמנים עם מאמן פעם או פעמיים בשבוע",
            definitionNative = "Командные занятия — дети тренируются с тренером раз или два в неделю.",
            example = "אנחנו מסיעים אותו ל חוּג סְפּוֹרְט אחרי הלימודים",
            exampleNative = "Мы возим его на спортивную секцию после уроков.",
            pos = "noun",
            semanticGroup = "school_activities",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181320, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "חוּג רוֹבּוֹטִיקָה",
            transliteration = "khug robotika",
            translation = "кружок робототехники",
            definition = "פעילות שבה ילדים בונים מכונות קטנות מחלקים ומתכנתים אותן במחשב",
            definitionNative = "Занятие, где дети собирают маленькие машинки из деталей и программируют их.",
            example = "הוא בנה רובוט עם גלגלים ב חוּג רוֹבּוֹטִיקָה",
            exampleNative = "Он собрал робота на колёсах в кружке робототехники.",
            pos = "noun",
            semanticGroup = "school_activities",
            isFillInBlankSafe = false),

        // ── school_routine (5) ──────────────────────────────────────────────

        WordEntity(
            id = 181321, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "בִּקּוּר אִישִׁי",
            transliteration = "bikur ishi",
            translation = "посещаемость (личная отметка)",
            definition = "סימון מי הגיע לכיתה ביום נתון בכל שיעור על ידי מחנך",
            definitionNative = "Отметка, кто пришёл в класс в этот день — по каждому уроку учителем.",
            example = "המורה רושם בִּקּוּר אִישִׁי בתחילת כל שיעור",
            exampleNative = "Учитель отмечает посещаемость в начале каждого урока.",
            pos = "noun",
            semanticGroup = "school_routine",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181322, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נוֹכְחוּת",
            transliteration = "nokhakhut",
            translation = "присутствие на уроках",
            definition = "כמה ימים תלמיד היה בבית הספר במשך תקופה ולא נעדר",
            definitionNative = "Сколько дней ученик был в школе за период и не пропускал.",
            example = "בתעודה כתוב שה נוֹכְחוּת שלו בסדר גמור",
            exampleNative = "В табеле написано, что присутствие на уроках у него в порядке.",
            pos = "noun",
            semanticGroup = "school_routine",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181323, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "חִיסּוּר",
            transliteration = "khisur",
            translation = "пропуск занятия",
            definition = "יום או שיעור שתלמיד לא היה בו בלי אישור או עם אישור מההורים",
            definitionNative = "День или урок, когда ученика не было — со справкой или без неё.",
            example = "המחנכת ביקשה הסבר על ה חִיסּוּר של אתמול",
            exampleNative = "Учительница попросила объяснение пропуска занятия за вчера.",
            pos = "noun",
            semanticGroup = "school_routine",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181324, setId = 1813, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִחוּר",
            transliteration = "ikhur",
            translation = "опоздание",
            definition = "כשתלמיד מגיע לכיתה אחרי שהשיעור כבר התחיל בזמן",
            definitionNative = "Когда ученик приходит в класс уже после начала урока.",
            example = "המורה כעסה על ה אִחוּר של חצי שעה הבוקר",
            exampleNative = "Учительница рассердилась за опоздание на полчаса утром.",
            pos = "noun",
            semanticGroup = "school_routine",
            isFillInBlankSafe = false),

        WordEntity(
            id = 181325, setId = 1813, languagePair = "he-ru", rarity = "RARE",
            original = "פֶּסֶק זְמַן",
            transliteration = "pesek zman",
            translation = "перерыв (между уроками)",
            definition = "זמן קצר בין שיעורים שבו הילדים יוצאים לחצר אוכלים ומשחקים",
            definitionNative = "Короткое время между уроками — дети выходят во двор, едят и играют.",
            example = "ב פֶּסֶק זְמַן הילדים אוכלים כריך ורצים בחצר",
            exampleNative = "В перерыв дети едят бутерброд и бегают по двору.",
            pos = "noun",
            semanticGroup = "school_routine",
            isFillInBlankSafe = false),
    )
}
