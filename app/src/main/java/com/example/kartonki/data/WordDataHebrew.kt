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

        // ── Уровень 1 (★) ──────────────────────────────────────────────────────

        // 1-A ── Иврит: Приветствия и семья ───────────────────────────────────
        // COMMON×12 / UNCOMMON×9 = 21
        DeckSeed(
            name = "Иврит: Приветствия и семья",
            level = 1,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×12
                "שָׁלוֹם", "תּוֹדָה", "בְּבַקָּשָׁה", "כֵּן",
                "לֹא", "סְלִיחָה", "בֹּקֶר", "עֶרֶב",
                "מִשְׁפָּחָה", "אָב", "אֵם", "בֵּן",
                // UNCOMMON ×9
                "דּוֹד", "דּוֹדָה", "בַּעַל", "אִשָּׁה",
                "זָקֵן", "צָעִיר", "מִסְעָדָה", "שׁוּק",
                "בֵּית חוֹלִים",
            ),
        ),

        // 1-B ── Иврит: Дом и еда ─────────────────────────────────────────────
        // COMMON×12 / UNCOMMON×9 = 21
        DeckSeed(
            name = "Иврит: Дом и еда",
            level = 1,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×12
                "אֹכֶל", "מַיִם", "לֶחֶם", "חָלָב",
                "בֵּיצָה", "קָפֶה", "תֵּה", "בַּיִת",
                "כִּסֵּא", "שׁוּלְחָן", "דֶּלֶת", "חַלּוֹן",
                // UNCOMMON ×9
                "חֶדֶר", "מִטְבָּח", "מִיטָּה", "מַקְלַחַת",
                "מֶלַח", "סֻכָּר", "מִיץ", "סַלָּט", "מְרַק",
            ),
        ),

        // ── Уровень 2 (★★) ─────────────────────────────────────────────────────

        // 2-A ── Иврит: Базовые технологии ────────────────────────────────────
        // COMMON×10 / UNCOMMON×6 / RARE×5 = 21
        DeckSeed(
            name = "Иврит: Базовые технологии",
            level = 2,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×10
                "מַחְשֵׁב", "טֶלֶפוֹן", "טַבְלֶט", "אַפְלִיקַצְיָה",
                "אַתָּר", "חִיפּוּשׁ", "אִינְטֶרְנֶט", "קוֹבֶץ",
                "תִּיקִיָּה", "שְׁמִירָה",
                // UNCOMMON ×6
                "מַדְפֶּסֶת", "דַּפְדְּפָן", "סִיסְמָה", "קִישׁוּר",
                "הוֹרָדָה", "עֵדְכּוּן",
                // RARE ×5
                "רֶשֶׁת", "שֶׁרֶת", "מַמְשָׁק", "הַצְפָּנָה",
                "פְּרוֹטוֹקוֹל",
            ),
        ),

        // 2-B ── Иврит: Город и транспорт ─────────────────────────────────────
        // COMMON×10 / UNCOMMON×6 / RARE×5 = 21
        DeckSeed(
            name = "Иврит: Город и транспорт",
            level = 2,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×10
                "אוֹטוֹבּוּס", "מְכוֹנִית", "רַכֶּבֶת", "מוֹנִית",
                "עִיר", "רְחוֹב", "כְּבִישׁ", "תַּחֲנָה",
                "פַּרְק", "נָהָר",
                // UNCOMMON ×6
                "מָלוֹן", "מוּזֵיאוֹן", "מֶטְרוֹ", "גֶּשֶׁר",
                "חֲנָיָה", "נְמַל תְּעוּפָה",
                // RARE ×5
                "תִּסְכּוּל", "נְחִישׁוּת", "זָהוּת", "נֶאֱמָנוּת",
                "חֶמְלָה",
            ),
        ),

        // ── Уровень 3 (★★★) ────────────────────────────────────────────────────

        // 3-A ── Иврит: Кино и искусство ──────────────────────────────────────
        // COMMON×8 / UNCOMMON×6 / RARE×4 / EPIC×2 / LEGENDARY×1 = 21
        DeckSeed(
            name = "Иврит: Кино и искусство",
            level = 3,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×8
                "סֶרֶט", "שַׂחְקָן", "קוֹמֶדְיָה", "דְּרָמָה",
                "שֶׁמֶשׁ", "גֶּשֶׁם", "רוּחַ", "יָם",
                // UNCOMMON ×6
                "אוּלָם קוֹלְנוֹעַ", "סִינֶמָה", "תֵּיאַטְרוֹן", "מְצֻיָּן",
                "בְּהַצְלָחָה", "שְׁכוּנָה",
                // RARE ×4
                "בַּמָּאי", "תַּסְרִיט", "עֲלִילָה", "אָנִימַצְיָה",
                // EPIC ×2
                "עֲדָשָׁה", "עֲרִיכָה",
                // LEGENDARY ×1
                "אֶפִּיסְטֶמֶה",
            ),
        ),

        // 3-B ── Иврит: Работа и эмоции ───────────────────────────────────────
        // COMMON×8 / UNCOMMON×6 / RARE×4 / EPIC×2 / LEGENDARY×1 = 21
        DeckSeed(
            name = "Иврит: Работа и эмоции",
            level = 3,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×8
                "מִשְׂרָד", "עֶצֶב", "כַּעַס", "פַּחַד",
                "שִׂמְחָה", "זְמַן", "יֶלֶד", "יַלְדָּה",
                // UNCOMMON ×6
                "אַהֲבָה", "אֹמֶץ לֵב", "עֲנָוָה", "סַבְלָנוּת",
                "אַחְרָיוּת", "יְצִירָתִיּוּת",
                // RARE ×4
                "הִסְתַּגְּלוּתִיּוּת", "גְּעַגּוּעַ", "הַפְתָּעָה", "כֹּחַ",
                // EPIC ×2
                "חֵרוּת", "מַהוּת",
                // LEGENDARY ×1
                "טֶלֶאוֹלוֹגְיָה",
            ),
        ),

        // ── Уровень 4 (★★★★) ───────────────────────────────────────────────────

        // 4-A ── Иврит: Компьютерные игры ─────────────────────────────────────
        // COMMON×4 / UNCOMMON×7 / RARE×6 / EPIC×3 / LEGENDARY×1 = 21
        DeckSeed(
            name = "Иврит: Компьютерные игры",
            level = 4,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×4
                "מִשְׂחָק", "חַיִּים", "אוֹיֵב", "נְקֻדּוֹת",
                // UNCOMMON ×7
                "נֶשֶׁק", "מִשִׁימָה", "דֶּמוּת", "רָמָה",
                "קְרָב", "בּוֹס", "שְׁמִירַת מִשְׂחָק",
                // RARE ×6
                "אוֹצָר", "פֶּגַע", "מַגֵּן", "הִתְגַּנְּבוּת",
                "יְכוֹלֶת", "כֶּלֶא",
                // EPIC ×3
                "הִישָּׂגִים", "אִסְטְרָטֶגְיָה", "הַדְמָיָה",
                // LEGENDARY ×1
                "אֶמֶרְגֶנְטִי",
            ),
        ),

        // 4-B ── Иврит: Технологии и безопасность ─────────────────────────────
        // COMMON×4 / UNCOMMON×7 / RARE×6 / EPIC×3 / LEGENDARY×1 = 21
        DeckSeed(
            name = "Иврит: Технологии и безопасность",
            level = 4,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // COMMON ×4
                "מַחְשֵׁב", "טֶלֶפוֹן", "אַתָּר", "אִינְטֶרְנֶט",
                // UNCOMMON ×7
                "מַדְפֶּסֶת", "דַּפְדְּפָן", "סִיסְמָה", "קִישׁוּר",
                "הוֹרָדָה", "הַעֲלָאָה", "עֵדְכּוּן",
                // RARE ×6
                "חוֹמַת אֵשׁ", "בָּסִיס נְתוּנִים", "בִּטָּחוֹן מַחְשֵׁב",
                "רֶשֶׁת עֲצַבִּים", "אוֹפְּטִימִיזַצְיָה", "מַכָּל",
                // EPIC ×3
                "לִמּוּד מְכוֹנָה", "בִּינָה מְלָאכוּתִית", "מִבְנֵה נְתוּנִים",
                // LEGENDARY ×1
                "אוֹנְטוֹלוֹגְיָה",
            ),
        ),

        // ── Уровень 5 (★★★★★) ──────────────────────────────────────────────────

        // 5-A ── Иврит: Карьера и рынок труда ────────────────────────────────
        // UNCOMMON×6 / RARE×8 / EPIC×5 / LEGENDARY×2 = 21
        DeckSeed(
            name = "Иврит: Карьера и рынок труда",
            level = 5,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // UNCOMMON ×6
                "עֲבוֹדָה", "מִשְׂכֹּרֶת", "מַנְהֵל", "קַרְיֶרָה",
                "שׁוּק הָעֲבוֹדָה", "מַעֲסִיק",
                // RARE ×8
                "קִידּוּם מִקְצוֹעִי", "עוֹבֵד עַצְמָאִי", "פִּיטּוּרִים",
                "חֻפְשַׁת לֵדָה", "תָּכְנִית עֲבוֹדָה", "הַפְתָּעָה",
                "גְּעַגּוּעַ", "כֹּחַ",
                // EPIC ×5
                "הִישָּׂגִים", "אִסְטְרָטֶגְיָה", "הַדְמָיָה",
                "מֵיכְלָן", "מַחְשׁוֹב עֲנָנִי",
                // LEGENDARY ×2
                "פָּרָדִיגְמָה", "סוֹלִיפְּסִיזְם",
            ),
        ),

        // 5-B ── Иврит: Продвинутое программирование ──────────────────────────
        // UNCOMMON×6 / RARE×8 / EPIC×5 / LEGENDARY×2 = 21
        DeckSeed(
            name = "Иврит: Продвинутое программирование",
            level = 5,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // UNCOMMON ×6
                "שְׁגִיאָה", "אַלְגּוֹרִיתְם", "תַּהֲלִיךְ", "מַחְלָקָה",
                "אוֹבְּיֶקְט", "מֶתוֹדָה",
                // RARE ×8
                "פָּרָמֶטֶר", "סִפְרִיָּה", "מַמְשָׁק", "יְרוּשָׁה",
                "חֲרִיגָה", "מַאֲגָר", "פְּרִיסָה", "זִיכָּרוֹן",
                // EPIC ×5
                "רְקוּרְסִיָּה", "מַהְדֵּר", "מַסְגֶּרֶת עֲבוֹדָה",
                "מִיקְרוֹ-שֵׁרוּת", "מַטְמוֹן",
                // LEGENDARY ×2
                "אֶפִּיסְטֶמֶה", "דִּיאָלֶקְטִיקָה",
            ),
        ),

        // ── Уровень 6 (★×6) ────────────────────────────────────────────────────

        // 6-A ── Иврит: Кибербезопасность и ИИ ───────────────────────────────
        // UNCOMMON×3 / RARE×8 / EPIC×7 / LEGENDARY×3 = 21
        DeckSeed(
            name = "Иврит: Кибербезопасность и ИИ",
            level = 6,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // UNCOMMON ×3
                "שְׁגִיאָה", "אַלְגּוֹרִיתְם", "תַּהֲלִיךְ",
                // RARE ×8
                "חוֹמַת אֵשׁ", "בִּטָּחוֹן מַחְשֵׁב", "תוֹכְנַת זְדוֹן",
                "רֶשֶׁת עֲצַבִּים", "בָּסִיס נְתוּנִים", "אוֹפְּטִימִיזַצְיָה",
                "נִפּוּי שְׁגִיאוֹת", "מַמְשָׁק",
                // EPIC ×7
                "רְקוּרְסִיָּה", "מַהְדֵּר", "מַסְגֶּרֶת עֲבוֹדָה",
                "מִיקְרוֹ-שֵׁרוּת", "מְכוֹנָה וִירְטוּאָלִית",
                "אִינְטֶגְרַצְיָה רְצִיפָה", "אִרְגּוּן מֵחָדָשׁ",
                // LEGENDARY ×3
                "אֶפִּיסְטֶמֶה", "דִּיאָלֶקְטִיקָה", "הֶרְמֶנֶאוּטִיקָה",
            ),
        ),

        // 6-B ── Иврит: Философия и наука ─────────────────────────────────────
        // UNCOMMON×3 / RARE×8 / EPIC×7 / LEGENDARY×3 = 21
        DeckSeed(
            name = "Иврит: Философия и наука",
            level = 6,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // UNCOMMON ×3
                "עֲבוֹדָה", "מִשְׂכֹּרֶת", "מַנְהֵל",
                // RARE ×8
                "תִּסְכּוּל", "נְחִישׁוּת", "זָהוּת", "נֶאֱמָנוּת",
                "חֶמְלָה", "הִסְתַּגְּלוּתִיּוּת", "לָקוֹחַ", "מַכָּל",
                // EPIC ×7
                "לִמּוּד מְכוֹנָה", "בִּינָה מְלָאכוּתִית", "מִבְנֵה נְתוּנִים",
                "חֵרוּת", "מַהוּת", "סִיבָּתִיּוּת", "שְׁלִילַת הָעַצְמִי",
                // LEGENDARY ×3
                "פֶנוֹמֶנוֹלוֹגְיָה", "אַקְסִיוֹלוֹגְיָה", "פְּרַגְמָטִיקָה",
            ),
        ),

        // ── Уровень 7 (★×7) ────────────────────────────────────────────────────

        // 7-A ── Иврит: Политика и общество ───────────────────────────────────
        // RARE×6 / EPIC×10 / LEGENDARY×5 = 21
        DeckSeed(
            name = "Иврит: Политика и общество",
            level = 7,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // RARE ×6
                "פָּרָמֶטֶר", "סִפְרִיָּה", "נִפּוּי שְׁגִיאוֹת",
                "פְּרוֹטוֹקוֹל", "זִיכָּרוֹן", "לָקוֹחַ",
                // EPIC ×10
                "אֶפִּידֶמִיּוֹלוֹגִיָּה", "גֶּנֶטִיקָה", "מֶמְשָׁל עַצְמִי",
                "פַּרְלָמֶנְטָרִיזְם", "חֻקָּה", "דּוֹקְטְרִינָה צְבָאִית",
                "הִישָּׂגִים", "אִסְטְרָטֶגְיָה", "הַדְמָיָה", "פּוֹרְטְפוֹלְיוֹ",
                // LEGENDARY ×5
                "קוֹגְנִיטִיבִיזְם", "נְקֻדַּת אֵין-חֲזָרָה",
                "פּוֹסְטְמוֹדֶרְנִיזְם", "קוֹנְטְרַפּוּנְקְט",
                "סִינֵמָה-וֵרִיטֶה",
            ),
        ),

        // 7-B ── Иврит: Исследования и академия ──────────────────────────────
        // RARE×6 / EPIC×10 / LEGENDARY×5 = 21
        DeckSeed(
            name = "Иврит: Исследования и академия",
            level = 7,
            languagePair = "he-ru",
            wordOriginals = listOf(
                // RARE ×6
                "יְרוּשָׁה", "חֲרִיגָה", "מַאֲגָר",
                "פְּרִיסָה", "וִירְטוּאַלִיזַצְיָה", "מַמְשָׁק",
                // EPIC ×10
                "רְקוּרְסִיָּה", "מַטְמוֹן", "מְכוֹנָה וִירְטוּאָלִית",
                "אִינְטֶגְרַצְיָה רְצִיפָה", "מַחְשׁוֹב עֲנָנִי",
                "חֵרוּת", "מַהוּת", "סִיבָּתִיּוּת",
                "שְׁלִילַת הָעַצְמִי", "מִיקְרוֹ-שֵׁרוּת",
                // LEGENDARY ×5
                "אֶפִּיסְטֶמֶה", "טֶלֶאוֹלוֹגְיָה",
                "אוֹנְטוֹלוֹגְיָה", "אַקְסִיוֹלוֹגְיָה",
                "פְּרַגְמָטִיקָה",
            ),
        ),
    )
}
