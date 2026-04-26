package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrew {

    // ── Sets ──────────────────────────────────────────────────────────────────
    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(id = 1001, name = "Технологии", description = "Базовая компьютерная лексика", orderIndex = 0, languagePair = "he-ru",
            topic = "Технологии",
            level = 1),
    )

    val words: List<WordEntity> get() = set1()

    // ── Set 101 — Basic Computer & Internet (A1/A2) ───────────────────────────
    private fun set1() = listOf(
        WordEntity(id = 100101, original = "מַחְשֵׁב", transliteration = "makhshev", translation = "компьютер",
            definition = "מכשיר אלקטרוני לעיבוד ואחסון מידע.",
            definitionNative = "Электронное устройство для хранения и обработки данных.",
            example = "מַחְשֵׁב מהיר יכול לעבד מיליוני פעולות בשנייה.",
            exampleNative = "Я каждый день работаю за מַחְשֵׁב.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware", fillInBlankExclusions = listOf(100102L, 100103L, 100104L, 100105L, 100113L, 100122L, 100123L)),
        WordEntity(id = 100102, original = "עַכְבָּר", transliteration = "akhbar", translation = "мышь (компьютерная)",
            definition = "התקן קלט שמזיזים על משטח לשליטה בסמן המסך.",
            definitionNative = "Устройство ввода, которое двигают по поверхности для управления курсором.",
            example = "עַכְבָּר אלחוטי נוח לשימוש על שולחן.",
            exampleNative = "Нажми левой кнопкой עַכְבָּר, чтобы выбрать файл.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware", fillInBlankExclusions = listOf(100101L, 100103L, 100104L, 100105L, 100122L, 100123L)),
        WordEntity(id = 100103, original = "מַקְלֶדֶת", transliteration = "makledet", translation = "клавиатура",
            definition = "התקן קלט עם מקשי אותיות, מספרים ופקודות.",
            definitionNative = "Устройство ввода с клавишами букв, цифр и команд.",
            example = "מַקְלֶדֶת מכנית יקרה אך נוחה מאוד.",
            exampleNative = "Я печатаю на מַקְלֶדֶת очень быстро.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware", fillInBlankExclusions = listOf(100101L, 100102L, 100104L, 100105L, 100122L, 100123L)),
        WordEntity(id = 100104, original = "מָסָךְ", transliteration = "masakh", translation = "экран, монитор",
            definition = "תצוגה המציגה את תמונת המחשב או הטלפון.",
            definitionNative = "Дисплей, на котором отображается изображение компьютера или телефона.",
            example = "מָסָךְ גדול עוזר בעבודה עם מסמכים.",
            exampleNative = "מָסָךְ этого ноутбука очень яркий.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware"),
        WordEntity(id = 100105, original = "מַדְפֶּסֶת", transliteration = "madpeset", translation = "принтер",
            definition = "מכשיר המדפיס טקסט ותמונות מהמחשב על נייר.",
            definitionNative = "Устройство, которое переносит текст или изображения с компьютера на бумагу.",
            example = "מַדְפֶּסֶת לייזר מדפיסה עשרים דפים בדקה.",
            exampleNative = "Распечатай документ на מַדְפֶּסֶת в офисе.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware", fillInBlankExclusions = listOf(100101L, 100102L, 100103L, 100104L, 100122L, 100123L)),
        WordEntity(id = 100106, original = "קוֹבֶץ", transliteration = "kovets", translation = "файл",
            definition = "אוסף נתונים בעל שם, שמור במחשב.",
            definitionNative = "Именованный набор данных, хранящийся на компьютере.",
            example = "קוֹבֶץ גדול לוקח זמן רב לפתיחה.",
            exampleNative = "Открой этот קוֹבֶץ в текстовом редакторе.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files", fillInBlankExclusions = listOf(100107L, 100108L, 100109L, 100110L, 100111L, 100112L, 100113L, 100114L, 100116L)),
        WordEntity(id = 100107, original = "תִּיקִיָּה", transliteration = "tikiya", translation = "папка",
            definition = "מיכל במערכת הקבצים לאחסון וארגון קבצים.",
            definitionNative = "Контейнер в файловой системе для организации и хранения файлов.",
            example = "תִּיקִיָּה חדשה נוצרה בשולחן העבודה.",
            exampleNative = "Сохрани все фото в одну תִּיקִיָּה.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files", fillInBlankExclusions = listOf(100106L, 100108L, 100109L, 100110L, 100111L, 100117L, 100118L, 100124L)),
        WordEntity(id = 100108, original = "שְׁמִירָה", transliteration = "shmirah", translation = "сохранение",
            definition = "כתיבת נתונים לדיסק כדי לשמור שינויים.",
            definitionNative = "Запись данных на диск, чтобы не потерять изменения.",
            example = "שְׁמִירָה אוטומטית מגנה על העבודה שלך.",
            exampleNative = "Не забудь сделать שְׁמִירָה документа перед закрытием.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files", fillInBlankExclusions = listOf(100106L, 100107L, 100109L, 100110L, 100111L, 100115L, 100118L)),
        WordEntity(id = 100109, original = "מְחִיקָה", transliteration = "mekhika", translation = "удаление",
            definition = "הסרת קובץ או נתונים מהמכשיר.",
            definitionNative = "Стирание файла или данных с устройства.",
            example = "מְחִיקָה של קובץ שגוי גרמה לבעיה.",
            exampleNative = "После מְחִיקָה файл переходит в корзину.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files", fillInBlankExclusions = listOf(100106L, 100107L, 100108L, 100110L, 100111L, 100117L, 100118L)),
        WordEntity(id = 100110, original = "הַעְתָּקָה", transliteration = "ha'ataka", translation = "копирование",
            definition = "יצירת עותק מדויק של קובץ או טקסט.",
            definitionNative = "Создание точной копии файла или текста.",
            example = "הַעְתָּקָה של הקובץ אורכת כמה שניות.",
            exampleNative = "Сделай הַעְתָּקָה этого документа на всякий случай.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files", fillInBlankExclusions = listOf(100106L, 100107L, 100108L, 100109L, 100111L, 100117L, 100118L)),
        WordEntity(id = 100111, original = "הַדְבָּקָה", transliteration = "hadbaka", translation = "вставка",
            definition = "הנחת טקסט או קובץ שהועתק במיקום חדש.",
            definitionNative = "Размещение скопированного текста или файла в новом месте.",
            example = "הַדְבָּקָה של הטקסט בוצעה בהצלחה.",
            exampleNative = "Скопируй текст и сделай הַדְבָּקָה в новый документ.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files", fillInBlankExclusions = listOf(100106L, 100107L, 100108L, 100109L, 100110L, 100117L, 100118L)),
        WordEntity(id = 100112, original = "אַתָּר", transliteration = "atar", translation = "сайт, веб-сайт",
            definition = "אוסף דפי אינטרנט בעלי כתובת משותפת.",
            definitionNative = "Набор веб-страниц с общим адресом в интернете.",
            example = "אַתָּר חדש נפתח להרשמה השבוע.",
            exampleNative = "Найди информацию на официальном אַתָּר компании.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet", fillInBlankExclusions = listOf(100113L, 100114L, 100115L, 100116L, 100117L, 100118L, 100124L, 100125L)),
        WordEntity(id = 100113, original = "דַּפְדְּפָן", transliteration = "dafdefan", translation = "браузер",
            definition = "תוכנה לגלישה וצפייה באתרי אינטרנט.",
            definitionNative = "Программа для просмотра сайтов в интернете.",
            example = "דַּפְדְּפָן מהיר חוסך זמן בגלישה.",
            exampleNative = "Открой דַּפְדְּפָן и перейди на нужную страницу.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet", fillInBlankExclusions = listOf(100101L, 100112L, 100114L, 100115L, 100116L, 100117L, 100118L, 100119L, 100122L, 100123L, 100124L, 100125L)),
        WordEntity(id = 100114, original = "דּוֹאַר אֶלֶקְטְרוֹנִי", transliteration = "do'ar elektronit", translation = "электронная почта",
            definition = "מערכת לשליחה וקבלה של הודעות דרך האינטרנט.",
            definitionNative = "Система отправки и получения сообщений через интернет.",
            example = "דּוֹאַר אֶלֶקְטְרוֹנִי הגיע מהמנהל עם מסמך.",
            exampleNative = "Отправь мне документ по דּוֹאַר אֶלֶקְטְרוֹנִי.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet", fillInBlankExclusions = listOf(100106L, 100112L, 100113L, 100115L, 100116L, 100117L, 100118L, 100120L, 100124L, 100125L)),
        WordEntity(id = 100115, original = "סִיסְמָה", transliteration = "sismah", translation = "пароль",
            definition = "קוד סודי לגישה לחשבון או למכשיר.",
            definitionNative = "Секретная комбинация символов для доступа к аккаунту или устройству.",
            example = "סִיסְמָה חזקה מגנה על החשבון שלך.",
            exampleNative = "Никому не говори свою סִיסְמָה от почты.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet", fillInBlankExclusions = listOf(100112L, 100113L, 100114L, 100116L, 100117L, 100118L, 100124L, 100125L)),
        WordEntity(id = 100116, original = "קִישׁוּר", transliteration = "kishur", translation = "ссылка, гиперссылка",
            definition = "טקסט לחיץ או תמונה המובילים לדף אחר.",
            definitionNative = "Кликабельный текст или изображение, ведущее на другую страницу.",
            example = "קִישׁוּר שבור לא מוביל לשום מקום.",
            exampleNative = "Перейди по этому קִישׁוּר, чтобы скачать файл.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet", fillInBlankExclusions = listOf(100112L, 100113L, 100114L, 100115L, 100117L, 100118L, 100124L, 100125L)),
        WordEntity(id = 100117, original = "הוֹרָדָה", transliteration = "horadah", translation = "скачивание, загрузка",
            definition = "העברת קובץ מהאינטרנט אל המכשיר שלך.",
            definitionNative = "Перенос файла с интернета на ваше устройство.",
            example = "הוֹרָדָה של הקובץ הושלמה בהצלחה.",
            exampleNative = "הוֹרָדָה этого фильма займёт несколько минут.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet", fillInBlankExclusions = listOf(100108L, 100109L, 100110L, 100111L, 100112L, 100113L, 100114L, 100115L, 100116L, 100118L, 100124L, 100125L)),
        WordEntity(id = 100118, original = "הַעֲלָאָה", transliteration = "ha'ala'ah", translation = "загрузка на сервер",
            definition = "העברת קובץ מהמכשיר שלך אל האינטרנט או השרת.",
            definitionNative = "Перенос файла с вашего устройства в интернет или на сервер.",
            example = "הַעֲלָאָה של תמונות לוקחת זמן רב.",
            exampleNative = "Сделай הַעֲלָאָה фотографии в облако.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet", fillInBlankExclusions = listOf(100108L, 100109L, 100110L, 100111L, 100112L, 100113L, 100114L, 100115L, 100116L, 100117L, 100124L, 100125L)),
        WordEntity(id = 100119, original = "חִיפּוּשׁ", transliteration = "khipush", translation = "поиск",
            definition = "מציאת מידע באמצעות שאילתה.",
            definitionNative = "Процесс нахождения информации или файла с помощью запроса.",
            example = "חִיפּוּשׁ מהיר מצא את הקובץ הנכון.",
            exampleNative = "Введи слово в строку חִיפּוּשׁ и нажми Enter.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "actions"),
        WordEntity(id = 100120, original = "עֵדְכּוּן", transliteration = "idkun", translation = "обновление",
            definition = "התקנת גרסה חדשה של תוכנה או מערכת הפעלה.",
            definitionNative = "Установка новой версии программы или операционной системы.",
            example = "עֵדְכּוּן חדש זמין להורדה היום.",
            exampleNative = "Сделай עֵדְכּוּן приложения, чтобы исправить ошибки.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "actions", fillInBlankExclusions = listOf(100106L, 100113L, 100116L, 100119L, 100121L)),
        WordEntity(id = 100121, original = "לְחִיצָה", transliteration = "lekhitsa", translation = "клик, нажатие",
            definition = "לחיצה על כפתור עכבר או מסך מגע לבחירת פריט.",
            definitionNative = "Нажатие кнопки мыши или тачскрина для выбора или активации элемента.",
            example = "לְחִיצָה כפולה על הסמל פותחת את התוכנה.",
            exampleNative = "Одна לְחִיצָה на иконку откроет программу.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "actions", fillInBlankExclusions = listOf(100119L, 100120L)),
        WordEntity(id = 100122, original = "טֶלֶפוֹן", transliteration = "telefon", translation = "телефон, смартфон",
            definition = "מכשיר נייד לשיחות, הודעות וגלישה באינטרנט.",
            definitionNative = "Мобильное устройство для звонков, сообщений и доступа в интернет.",
            example = "טֶלֶפוֹן חכם מחובר לאינטרנט תמיד.",
            exampleNative = "Я всегда держу טֶלֶפוֹן при себе.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware", fillInBlankExclusions = listOf(100101L, 100102L, 100103L, 100104L, 100105L, 100113L, 100123L)),
        WordEntity(id = 100123, original = "טַבְלֶט", transliteration = "tablet", translation = "планшет",
            definition = "מחשב נייד עם מסך מגע ללא מקלדת נפרדת.",
            definitionNative = "Мобильный компьютер с сенсорным экраном без отдельной клавиатуры.",
            example = "טַבְלֶט קל לנשיאה ונוח לקריאה.",
            exampleNative = "Дети смотрят мультфильмы на טַבְלֶט.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware", fillInBlankExclusions = listOf(100101L, 100102L, 100103L, 100104L, 100105L, 100122L)),
        WordEntity(id = 100124, original = "אַפְלִיקַצְיָה", transliteration = "aplikatsya", translation = "приложение",
            definition = "תוכנה המותקנת על טלפון, טאבלט או מחשב.",
            definitionNative = "Программа, установленная на телефон, планшет или компьютер.",
            example = "אַפְלִיקַצְיָה חדשה פורסמה בחנות היישומים.",
            exampleNative = "Скачай эту אַפְלִיקַצְיָה — она бесплатная.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet", fillInBlankExclusions = listOf(100112L, 100113L, 100114L, 100115L, 100116L, 100117L, 100118L, 100125L)),
        WordEntity(id = 100125, original = "וִירוּס", transliteration = "virus", translation = "вирус (компьютерный)",
            definition = "תוכנה זדונית שמדביקה מכשיר ועלולה להשמיד נתונים.",
            definitionNative = "Вредоносная программа, которая заражает устройство и может уничтожать данные.",
            example = "וִירוּס מסוכן הדביק את המחשב.",
            exampleNative = "Установи антивирус, чтобы защититься от וִירוּס.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet", fillInBlankExclusions = listOf(100106L, 100112L, 100113L, 100114L, 100115L, 100116L, 100117L, 100118L, 100120L, 100124L)),
    )

    // ── Pre-built Decks (he-ru only — en-ru decks live in WordDataEnglish) ────────
    // See DeckSeed.kt for the data class. WordRegistry.allPrebuiltDecks aggregates all languages.

    val prebuiltDecks: List<DeckSeed> = listOf(

        // Семья (Lvl 1) — Co12 / Un9 = 21
        DeckSeed(
            name = "Семья",
            level = 1,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×12
                "מִשְׁפָּחָה", "אָב", "אֵם", "בֵּן",
                "בַּת", "אָח", "אָחוֹת", "סָבָא",
                "סָבְתָּא", "יֶלֶד", "יַלְדָּה", "תִּינוֹק",
                // UNCOMMON ×9
                "טַבַּעַת נִשּׂוּאִין", "שֶׁבַע בְּרָכוֹת", "קְטוּבָּה", "זוּגִיּוּת",
                "נִשּׂוּאִין", "עֵדִים", "הִתְגָּרְשׁוּת", "נְכָדִים",
                "חוּפָּה",
            ),
        ),

        // Дом и быт (Lvl 1) — Co12 / Un9 = 21
        DeckSeed(
            name = "Дом и быт",
            level = 1,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×12
                "קַנְיוֹן", "מִדָּה", "חֶדֶר הַלְבָּשָׁה", "מוֹדָה",
                "תָּוִית מְחִיר", "שְׁכֵנָה", "דַּיָּר", "לוּחַ מוֹדָעוֹת",
                "פַּח אַשְׁפָּה", "רַעַשׁ", "גֶּדֶר", "פַּעֲמוֹן",
                // UNCOMMON ×9
                "קַמְעוֹנַאי", "קוּפּוֹן", "הַחְזָרַת מוּצָר", "הֶחְזֵר כֶּסֶף",
                "אַקְסֶסוֹרִי", "חֲנוּת יָד שְׁנִיָּה", "קוֹלֵב", "מִבְצַע סוֹף עוֹנָה",
                "עֹנָה",
            ),
        ),

        // Еда и кулинария (Lvl 2) — Co10 / Un6 / Ra5 = 21
        DeckSeed(
            name = "Еда и кулинария",
            level = 2,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×10
                "תַּפְרִיט", "מֶלְצָר", "שְׁנִיצֶל", "מִשְׁקֶה",
                "אֲרוּחָה", "צַלַּחַת", "חוּמּוּס", "פָּלָאפֶל",
                "מַחְבָּת", "סִיר",
                // UNCOMMON ×6
                "מָנָה רִאשׁוֹנָה", "מָנָה עִיקָרִית", "קִינּוּחַ", "חֲלָבִי",
                "בָּשָׂרִי", "שֶׁמֶן זֵית",
                // RARE ×5
                "צִמְחוֹנִי", "כְּבִישָׁה", "בָּלִישָׁה", "הַקְצָפָה",
                "בְּלִילָה",
            ),
        ),

        // Город (Lvl 2) — Co10 / Un6 / Ra5 = 21
        DeckSeed(
            name = "Город",
            level = 2,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×10
                "רְחוֹב", "צֹמֶת", "מִדְרָכָה", "אוֹטוֹבּוּס",
                "מוֹנִית", "אוֹפַנַּיִם", "כְּבִישׁ", "גֶּשֶׁר",
                "תַּחֲנָה", "חֲנוּת",
                // UNCOMMON ×6
                "מַעֲבַר חֲצִיָּה", "בּוּלְוַאר", "שֶׁלֶט", "כִּכָּר",
                "מוֹעֲדוֹן", "כְּנֵסִיָּה",
                // RARE ×5
                "מִחְזּוּר עִירוֹנִי", "פָּרִיפֶּרְיָה", "שְׁטָחִים פְּתוּחִים", "הִתְחַדְּשׁוּת עִירוֹנִית",
                "עִיר מְעוֹרֶבֶת",
            ),
        ),

        // Спорт (Lvl 3) — Co8 / Un6 / Ra4 / Ep2 / Le1 = 21
        DeckSeed(
            name = "Спорт",
            level = 3,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×8
                "כַּדּוּרֶגֶל", "מְתִיחָה", "רִיצָה", "מַכּוֹן כּוֹשֵׁר",
                "כַּדּוּרְסָל", "יוֹגָה", "מֵרוֹץ", "גוֹלֶף",
                // UNCOMMON ×6
                "הִתְאַמְּנוּת", "מְאַמֵּן", "מַשְׁקֹלֶת", "קֵירוּר",
                "שְׂרִירִים", "תַּחֲרוּת",
                // RARE ×4
                "פֶּנַלְטִי", "הַדְּחָקָה", "רוּגְבִּי", "אַלּוּפוּת",
                // EPIC ×2
                "חוֹזֶה שַׂחְקָן", "נִהוּל סְפּוֹרְט",
                // LEGENDARY ×1
                "סוֹצְיוֹלוֹגְיָה שֶׁל הַסְּפּוֹרְט",
            ),
        ),

        // Право и закон (Lvl 3) — Co8 / Un6 / Ra4 / Ep2 / Le1 = 21
        DeckSeed(
            name = "Право и закон",
            level = 3,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×8
                "עוֹרֵךְ דִּין", "בֵּית מִשְׁפָּט", "שׁוֹפֵט", "חוֹק",
                "הַגָּנָה", "אִשּׁוּם", "תְּעוּדַת זֶהוּת", "מִסְמָךְ",
                // UNCOMMON ×6
                "פְּרַקְלִיט", "סָנֵגוֹר", "תְּבִיעָה", "נִיהוּל תִּיק",
                "תִּיק בֵּית מִשְׁפָּט", "עֵד הָגָנָה",
                // RARE ×4
                "פְּשִׁיטַת רֶגֶל", "דִּין חוּקְתִּי", "קְבִיעַת עֻבְדוֹת", "הַחְלָטַת בֵּית מִשְׁפָּט",
                // EPIC ×2
                "עֵד מוּמְחֶה", "נֶאֱמָן",
                // LEGENDARY ×1
                "הֶרְמֶנֵיוּטִיקָה מִשְׁפָּטִית",
            ),
        ),

        // Технологии (Lvl 4) — Co4 / Un7 / Ra6 / Ep3 / Le1 = 21
        DeckSeed(
            name = "Технологии",
            level = 4,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×4
                "מַחְשֵׁב", "עַכְבָּר", "מַקְלֶדֶת", "מָסָךְ",
                // UNCOMMON ×7
                "מַדְפֶּסֶת", "מְחִיקָה", "הַעְתָּקָה", "הַדְבָּקָה",
                "דַּפְדְּפָן", "סִיסְמָה", "קִישׁוּר",
                // RARE ×6
                "חוֹמַת אֵשׁ", "בִּטָּחוֹן מַחְשֵׁב", "תוֹכְנַת זְדוֹן", "בָּסִיס נְתוּנִים",
                "רֶשֶׁת עֲצַבִּים", "אוֹפְּטִימִיזַצְיָה",
                // EPIC ×3
                "הַצְפָּנָה סִימֶטְרִית", "אוֹתֶנְטִיקַצְיָה", "אִישּׁוּר דִּיגִיטַלִי",
                // LEGENDARY ×1
                "הִנְגָּשׁוּת דִּיגִיטָלִית",
            ),
        ),

        // Транспорт (Lvl 4) — Co4 / Un7 / Ra6 / Ep3 / Le1 = 21
        DeckSeed(
            name = "Транспорт",
            level = 4,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×4
                "אוֹטוֹבּוּס", "מְכוֹנִית", "מוֹנִית", "מִינִיבּוּס",
                // UNCOMMON ×7
                "דְּמֵי נְסִיעָה", "קַבָּלָה", "מַטְבֵּעַ", "עֹדֶף",
                "הֲנָחָה", "תַּחֲנַת רַכֶּבֶת", "תַּחֲנַת אוֹטוֹבּוּס",
                // RARE ×6
                "הַמְרָאָה", "טִיסָה", "יְצִיאָה", "כַּרְטִיס עֲלִיָּה",
                "טֶרְמִינָל", "נְחִיתָה",
                // EPIC ×3
                "לוֹגִיסְטִיקָה", "שַׁרְשֶׁרֶת אַסְפָּקָה מַחְסָן", "תִּכְנוּן הוֹבָלָה",
                // LEGENDARY ×1
                "סוֹצְיוֹלוֹגְיָה שֶׁל הַתַּחְבּוּרָה",
            ),
        ),

        // Работа и карьера (Lvl 5) — Un6 / Ra8 / Ep5 / Le2 = 21
        DeckSeed(
            name = "Работа и карьера",
            level = 5,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // UNCOMMON ×6
                "קוֹרוֹת חַיִּים", "מִכְתַּב כִּסּוּי", "תִּיק עֲבוֹדוֹת", "טֹפֶס מוּעֲמָדוּת",
                "מוֹדָעַת דְּרוּשִׁים", "מוּעֲמָד",
                // RARE ×8
                "הַעֲלָאָה בְּדַרְגָּה", "מַסְלוּל הִתְקַדְּמוּת", "מַעֲבָר פָּנִימִי", "תַּפְקִיד רֹאשׁ צֶוֶות",
                "בּוֹנוּס שְׁנָתִי", "אוֹפְצִיּוֹת", "הַכָּרָה רִשְׁמִית", "שְׁחִיקָה תַּעֲסוּקָתִית",
                // EPIC ×5
                "סְטַרְטְאַפּ בִּשְׁלָב מֻקְדָּם", "מַשְׁקִיעַ מְזַמֵּן", "קֶרֶן הוֹן סִיכּוּן", "מְיַסֵּד שׁוּתָף",
                "חֶבְרַת חַד־קֶרֶן",
                // LEGENDARY ×2
                "כּוֹחַ עֲבוֹדָה", "שׁוּק הֲעֲבוֹדָה",
            ),
        ),

        // Магазин и продажи (Lvl 5) — Un6 / Ra8 / Ep5 / Le2 = 21
        DeckSeed(
            name = "Магазин и продажи",
            level = 5,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // UNCOMMON ×6
                "עֶגְלַת קְנִיּוֹת", "שָׁעוֹת פְּתִיחָה", "מִשְׁלוֹחַ", "קוּפּוֹן",
                "מֶכֶר", "שֵׁרוּת לָקוֹחוֹת",
                // RARE ×8
                "רֶוַח גּוּלְמִי", "שׁוּלֵי רֶוַח", "עוֹנָתִיּוּת", "מַחְזוֹר מְכִירוֹת",
                "מַקֵּף מוּצָרִים", "תַּחֲרוּת מְחִירִים", "הֲנָחַת כַּמּוּת", "תְּנַאֵי תַּשְׁלוּם",
                // EPIC ×5
                "נִהוּל קַטֶגוֹרְיָה", "פְּלַנוֹגְרָמָה", "נַתַּח שׁוּק", "מָדַד הַמְרָה",
                "יְחִידַת שְׁמִירַת מְלַאי",
                // LEGENDARY ×2
                "הַתְאָמַת מְחִירִים לְשׁוּק", "אֶסְטְרַטֶגְיַת תַּמְחוּר",
            ),
        ),

        // Психология (Lvl 6) — Un3 / Ra8 / Ep7 / Le3 = 21
        DeckSeed(
            name = "Психология",
            level = 6,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // UNCOMMON ×3
                "אַהֲבָה", "אֹמֶץ לֵב", "עֲנָוָה",
                // RARE ×8
                "טִיפּוּל נַפְשִׁי", "תְּמִיכָה רִגְשִׁית", "הֶעְדֵּר שֵׁנָה", "חֻסֶן נַפְשִׁי",
                "גְּבוּלוֹת אִישִׁיִּים", "שַׁחְרוּר רִגְשִׁי", "מֶרְחָב בָּטוּחַ", "מִינְדְפוּלְנֶס",
                // EPIC ×7
                "נוֹרוֹזָה", "פוֹבְּיָה", "סְכִיזוֹפְרֵנְיָה", "הִתְמַכְּרוּת",
                "נַרְקִיסִיזְם", "דִּיסוֹצִיַּאצְיָה", "אוֹבְסֶסְיָה",
                // LEGENDARY ×3
                "פֶּנוֹמֶנוֹלוֹגְיָה שֶׁל הַנֶּפֶשׁ", "אָרְכֵטִיפּ יוּנְגִיאָנִי", "אוֹנְטוֹלוֹגְיָה שֶׁל הָעֶצְמִי",
            ),
        ),

        // Природа и экология (Lvl 6) — Un3 / Ra8 / Ep7 / Le3 = 21
        DeckSeed(
            name = "Природа и экология",
            level = 6,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // UNCOMMON ×3
                "חַמְסִין", "בָּרָד", "גַּל חוֹם",
                // RARE ×8
                "אֵקוֹסִיסְטֶם", "בִּיוֹמְגַּוּוָן", "טַבַּעַת פְּלַסְטִיק", "רְמַת פְּחָמָן דּוּ-חַמְצָנִי",
                "מַהֲלַךְ נֶטוֹ אֶפֶס", "טְבִיעַת רֶגֶל אֶקוֹלוֹגִית", "מִגְוּוֹן בִּיוֹלוֹגִי", "שִׁיקּוּם סְבִיבָתִי",
                // EPIC ×7
                "שַׁכְבַת אוֹזוֹן", "בִּיוֹסְפֵרָה", "פַּחְמֵן", "יִעוּר מֵחָדָשׁ",
                "אֵנֶרְגְּיָה גֵּאוֹתֶרְמִית", "מִיחְזוּר מַיִם", "טֶכְנוֹלוֹגְיָה יְרוּקָּה",
                // LEGENDARY ×3
                "אֵתִיקָה אֵקוֹלוֹגִית", "זְכוּיוֹת הַטֶּבַע", "צֶדֶק סְבִיבָתִי",
            ),
        ),

        // Философия (Lvl 7) — Ra6 / Ep10 / Le5 = 21
        DeckSeed(
            name = "Философия",
            level = 7,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // RARE ×6
                "שִׁוְיוֹן", "צֶדֶק", "יְדִיעַת מָקוֹם", "טֶבַע הָאָדָם",
                "רֶלָטִיבִיזְם", "פֶּנוֹמֶנוֹלוֹגְיָה",
                // EPIC ×10
                "דֶּטֶרְמִינִיזְם", "אִינְדֶּטֶרְמִינִיזְם", "רֶדוּקְצְיוֹנִיזְם", "הוֹלִיזְם",
                "פִּיזִיקַלִיזְם", "פְּרַגְמָטִיזְם", "נוֹמִינַלִיזְם", "רֵאַלִיזְם",
                "פִּילוֹסוֹפְיָה אַנַלִיטִית", "פִּילוֹסוֹפְיָה שֶׁל הַמַּדָּע",
                // LEGENDARY ×5
                "מֶטָ-פִּילוֹסוֹפְיָה", "פִּילוֹסוֹפְיָה קּוֹנְטִינֶנְטָלִית", "תֵּיאוֹרְיָה קְרִיטִית", "פּוֹסְטְ-מוֹדֶרְנִיזְם",
                "תֵּיאוֹרְיַת הַצֶּדֶק",
            ),
        ),

        // Алия и Израиль (Lvl 7) — Ra6 / Ep10 / Le5 = 21
        DeckSeed(
            name = "Алия и Израиль",
            level = 7,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // RARE ×6
                "בֵּית מִשְׁפָּט עֶלְיוֹן", "חֲבֵר כְּנֶסֶת", "וְעָדָה", "רֹאשׁ מֶמְשָׁלָה",
                "שָׂר", "קוֹאָלִיצְיָה",
                // EPIC ×10
                "הַכְרָזַת הָעַצְמָאוּת", "כ״ט בְּנוֹבֶמְבֶּר", "מְגִלַּת הָעַצְמָאוּת", "מִלְחֶמֶת שֵׁשֶׁת הַיָּמִים",
                "מִלְחֶמֶת יוֹם הַכִּפּוּרִים", "גָּלוּת", "אִינְתִיפָאדָה", "דָּוִד בֶּן-גּוּרְיוֹן",
                "גּוֹלְדָה מֵאִיר", "תֵּאוֹדוֹר הֶרְצֶל",
                // LEGENDARY ×5
                "הֲלָכָה", "תְּפוּצוֹת", "שְׁטֶעטְל", "יְשִׁיבָה",
                "תַּלְמוּד",
            ),
        ),

    )
}
