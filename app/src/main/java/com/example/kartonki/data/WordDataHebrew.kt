package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrew {

    // ── Sets ──────────────────────────────────────────────────────────────────
    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(id = 1001, name = "Технологии: основы", description = "Базовая компьютерная лексика", orderIndex = 0, languagePair = "he-ru",
            topic = "Технологии",
            level = 1),
        WordSetEntity(id = 1002, name = "Технологии: продвинутый",     description = "Термины программирования",          orderIndex = 1, languagePair = "he-ru",
            topic = "Технологии",
            level = 2),
        WordSetEntity(id = 1003, name = "Технологии: профессиональный",          description = "Продвинутая терминология",        orderIndex = 2, languagePair = "he-ru",
            topic = "Технологии",
            level = 4),
    )

    val words: List<WordEntity> get() = set1() + set2() + set3()

    // ── Set 101 — Basic Computer & Internet (A1/A2) ───────────────────────────
    private fun set1() = listOf(
        WordEntity(id = 100101, original = "מַחְשֵׁב", transliteration = "makhshev", translation = "компьютер",
            definition = "מכשיר אלקטרוני לעיבוד ואחסון מידע.",
            definitionNative = "Электронное устройство для хранения и обработки данных.",
            example = "מַחְשֵׁב מהיר יכול לעבד מיליוני פעולות בשנייה.",
            exampleNative = "Я каждый день работаю за מַחְשֵׁב.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware"),
        WordEntity(id = 100102, original = "עַכְבָּר", transliteration = "akhbar", translation = "мышь (компьютерная)",
            definition = "התקן קלט שמזיזים על משטח לשליטה בסמן המסך.",
            definitionNative = "Устройство ввода, которое двигают по поверхности для управления курсором.",
            example = "עַכְבָּר אלחוטי נוח לשימוש על שולחן.",
            exampleNative = "Нажми левой кнопкой עַכְבָּר, чтобы выбрать файл.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware"),
        WordEntity(id = 100103, original = "מַקְלֶדֶת", transliteration = "makledet", translation = "клавиатура",
            definition = "התקן קלט עם מקשי אותיות, מספרים ופקודות.",
            definitionNative = "Устройство ввода с клавишами букв, цифр и команд.",
            example = "מַקְלֶדֶת מכנית יקרה אך נוחה מאוד.",
            exampleNative = "Я печатаю на מַקְלֶדֶת очень быстро.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware"),
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
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware"),
        WordEntity(id = 100106, original = "קוֹבֶץ", transliteration = "kovets", translation = "файл",
            definition = "אוסף נתונים בעל שם, שמור במחשב.",
            definitionNative = "Именованный набор данных, хранящийся на компьютере.",
            example = "קוֹבֶץ גדול לוקח זמן רב לפתיחה.",
            exampleNative = "Открой этот קוֹבֶץ в текстовом редакторе.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files"),
        WordEntity(id = 100107, original = "תִּיקִיָּה", transliteration = "tikiya", translation = "папка",
            definition = "מיכל במערכת הקבצים לאחסון וארגון קבצים.",
            definitionNative = "Контейнер в файловой системе для организации и хранения файлов.",
            example = "תִּיקִיָּה חדשה נוצרה בשולחן העבודה.",
            exampleNative = "Сохрани все фото в одну תִּיקִיָּה.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files"),
        WordEntity(id = 100108, original = "שְׁמִירָה", transliteration = "shmirah", translation = "сохранение",
            definition = "כתיבת נתונים לדיסק כדי לשמור שינויים.",
            definitionNative = "Запись данных на диск, чтобы не потерять изменения.",
            example = "שְׁמִירָה אוטומטית מגנה על העבודה שלך.",
            exampleNative = "Не забудь сделать שְׁמִירָה документа перед закрытием.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files"),
        WordEntity(id = 100109, original = "מְחִיקָה", transliteration = "mekhika", translation = "удаление",
            definition = "הסרת קובץ או נתונים מהמכשיר.",
            definitionNative = "Стирание файла или данных с устройства.",
            example = "מְחִיקָה של קובץ שגוי גרמה לבעיה.",
            exampleNative = "После מְחִיקָה файл переходит в корзину.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files"),
        WordEntity(id = 100110, original = "הַעְתָּקָה", transliteration = "ha'ataka", translation = "копирование",
            definition = "יצירת עותק מדויק של קובץ או טקסט.",
            definitionNative = "Создание точной копии файла или текста.",
            example = "הַעְתָּקָה של הקובץ אורכת כמה שניות.",
            exampleNative = "Сделай הַעְתָּקָה этого документа на всякий случай.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files"),
        WordEntity(id = 100111, original = "הַדְבָּקָה", transliteration = "hadbaka", translation = "вставка",
            definition = "הנחת טקסט או קובץ שהועתק במיקום חדש.",
            definitionNative = "Размещение скопированного текста или файла в новом месте.",
            example = "הַדְבָּקָה של הטקסט בוצעה בהצלחה.",
            exampleNative = "Скопируй текст и сделай הַדְבָּקָה в новый документ.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "files"),
        WordEntity(id = 100112, original = "אַתָּר", transliteration = "atar", translation = "сайт, веб-сайт",
            definition = "אוסף דפי אינטרנט בעלי כתובת משותפת.",
            definitionNative = "Набор веб-страниц с общим адресом в интернете.",
            example = "אַתָּר חדש נפתח להרשמה השבוע.",
            exampleNative = "Найди информацию на официальном אַתָּר компании.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet"),
        WordEntity(id = 100113, original = "דַּפְדְּפָן", transliteration = "dafdefan", translation = "браузер",
            definition = "תוכנה לגלישה וצפייה באתרי אינטרנט.",
            definitionNative = "Программа для просмотра сайтов в интернете.",
            example = "דַּפְדְּפָן מהיר חוסך זמן בגלישה.",
            exampleNative = "Открой דַּפְדְּפָן и перейди на нужную страницу.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet"),
        WordEntity(id = 100114, original = "דּוֹאַר אֶלֶקְטְרוֹנִי", transliteration = "do'ar elektronit", translation = "электронная почта",
            definition = "מערכת לשליחה וקבלה של הודעות דרך האינטרנט.",
            definitionNative = "Система отправки и получения сообщений через интернет.",
            example = "דּוֹאַר אֶלֶקְטְרוֹנִי הגיע מהמנהל עם מסמך.",
            exampleNative = "Отправь мне документ по דּוֹאַר אֶלֶקְטְרוֹנִי.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet"),
        WordEntity(id = 100115, original = "סִיסְמָה", transliteration = "sismah", translation = "пароль",
            definition = "קוד סודי לגישה לחשבון או למכשיר.",
            definitionNative = "Секретная комбинация символов для доступа к аккаунту или устройству.",
            example = "סִיסְמָה חזקה מגנה על החשבון שלך.",
            exampleNative = "Никому не говори свою סִיסְמָה от почты.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet"),
        WordEntity(id = 100116, original = "קִישׁוּר", transliteration = "kishur", translation = "ссылка, гиперссылка",
            definition = "טקסט לחיץ או תמונה המובילים לדף אחר.",
            definitionNative = "Кликабельный текст или изображение, ведущее на другую страницу.",
            example = "קִישׁוּר שבור לא מוביל לשום מקום.",
            exampleNative = "Перейди по этому קִישׁוּר, чтобы скачать файл.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet"),
        WordEntity(id = 100117, original = "הוֹרָדָה", transliteration = "horadah", translation = "скачивание, загрузка",
            definition = "העברת קובץ מהאינטרנט אל המכשיר שלך.",
            definitionNative = "Перенос файла с интернета на ваше устройство.",
            example = "הוֹרָדָה של הקובץ הושלמה בהצלחה.",
            exampleNative = "הוֹרָדָה этого фильма займёт несколько минут.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet"),
        WordEntity(id = 100118, original = "הַעֲלָאָה", transliteration = "ha'ala'ah", translation = "загрузка на сервер",
            definition = "העברת קובץ מהמכשיר שלך אל האינטרנט או השרת.",
            definitionNative = "Перенос файла с вашего устройства в интернет или на сервер.",
            example = "הַעֲלָאָה של תמונות לוקחת זמן רב.",
            exampleNative = "Сделай הַעֲלָאָה фотографии в облако.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet"),
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
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "actions"),
        WordEntity(id = 100121, original = "לְחִיצָה", transliteration = "lekhitsa", translation = "клик, нажатие",
            definition = "לחיצה על כפתור עכבר או מסך מגע לבחירת פריט.",
            definitionNative = "Нажатие кнопки мыши или тачскрина для выбора или активации элемента.",
            example = "לְחִיצָה כפולה על הסמל פותחת את התוכנה.",
            exampleNative = "Одна לְחִיצָה на иконку откроет программу.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "actions"),
        WordEntity(id = 100122, original = "טֶלֶפוֹן", transliteration = "telefon", translation = "телефон, смартфон",
            definition = "מכשיר נייד לשיחות, הודעות וגלישה באינטרנט.",
            definitionNative = "Мобильное устройство для звонков, сообщений и доступа в интернет.",
            example = "טֶלֶפוֹן חכם מחובר לאינטרנט תמיד.",
            exampleNative = "Я всегда держу טֶלֶפוֹן при себе.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware"),
        WordEntity(id = 100123, original = "טַבְלֶט", transliteration = "tablet", translation = "планшет",
            definition = "מחשב נייד עם מסך מגע ללא מקלדת נפרדת.",
            definitionNative = "Мобильный компьютер с сенсорным экраном без отдельной клавиатуры.",
            example = "טַבְלֶט קל לנשיאה ונוח לקריאה.",
            exampleNative = "Дети смотрят мультфильмы на טַבְלֶט.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "hardware"),
        WordEntity(id = 100124, original = "אַפְלִיקַצְיָה", transliteration = "aplikatsya", translation = "приложение",
            definition = "תוכנה המותקנת על טלפון, טאבלט או מחשב.",
            definitionNative = "Программа, установленная на телефон, планшет или компьютер.",
            example = "אַפְלִיקַצְיָה חדשה פורסמה בחנות היישומים.",
            exampleNative = "Скачай эту אַפְלִיקַצְיָה — она бесплатная.",
            rarity = "COMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet"),
        WordEntity(id = 100125, original = "וִירוּס", transliteration = "virus", translation = "вирус (компьютерный)",
            definition = "תוכנה זדונית שמדביקה מכשיר ועלולה להשמיד נתונים.",
            definitionNative = "Вредоносная программа, которая заражает устройство и может уничтожать данные.",
            example = "וִירוּס מסוכן הדביק את המחשב.",
            exampleNative = "Установи антивирус, чтобы защититься от וִירוּס.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1001, pos = "noun", semanticGroup = "internet"),
    )

    // ── Set 102 — Programming Terms (B1) ─────────────────────────────────────
    private fun set2() = listOf(
        WordEntity(id = 100201, original = "זֶרֶם נְתוּנִים", transliteration = "zerem netunim", translation = "поток данных",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002),
        WordEntity(id = 100202, original = "מַחְשׁוֹב עָנָן", transliteration = "makhshuv anan", translation = "облачные вычисления",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002),
        WordEntity(id = 100203, original = "אֶנְקַפְּסוּלַצְיָה", transliteration = "enkapsulatsiya", translation = "инкапсуляция",
            rarity = "RARE", languagePair = "he-ru", setId = 1002),
        WordEntity(id = 100204, original = "מַעֲרָךְ", transliteration = "ma'arakh", translation = "массив",
            definition = "אוסף ערכים בסדר הנגיש לפי אינדקס.",
            definitionNative = "Упорядоченная коллекция элементов, доступных по индексу.",
            example = "מַעֲרָךְ מאחסן אוסף של ערכים בסדר.",
            exampleNative = "Оценки студентов хранятся в מַעֲרָךְ.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "data_types"),
        WordEntity(id = 100205, original = "תְּנַאי", transliteration = "tnai", translation = "условие",
            definition = "ביטוי לוגי הנבדק בתוכנית לבחירת מסלול ביצוע.",
            definitionNative = "Логическое выражение, которое проверяется для выбора пути выполнения.",
            example = "תְּנַאי בודק אם הגיל גדול משמונה עשר.",
            exampleNative = "Программа проверяет תְּנַאי: если пользователь старше 18 лет.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "control_flow"),
        WordEntity(id = 100206, original = "מֶנְגְּנוֹן", transliteration = "mengnaon", translation = "механизм; движок",
            definition = "רכיב מופשט האחראי על לוגיקה פנימית של מערכת.",
            definitionNative = "Абстрактный компонент, отвечающий за внутреннюю логику системы.",
            example = "מֶנְגְּנוֹן הפיזיקה מחשב כוחות ותנועה.",
            exampleNative = "מֶנְגְּנוֹן физики рассчитывает силы и движение.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "oop"),
        WordEntity(id = 100207, original = "אוֹבְּיֶקְט", transliteration = "ob'yekt", translation = "объект",
            definition = "מופע של מחלקה בעל נתונים ושיטות משלו.",
            definitionNative = "Конкретный экземпляр класса, обладающий своими данными и методами.",
            example = "אוֹבְּיֶקְט הוא מופע של מחלקה.",
            exampleNative = "Система создаёт новый אוֹבְּיֶקְט для каждого игрока.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "oop"),
        WordEntity(id = 100208, original = "מֶתוֹדָה", transliteration = "metoda", translation = "метод",
            definition = "פונקציה השייכת למחלקה ומגדירה את פעולות האובייקט.",
            definitionNative = "Функция, принадлежащая классу и описывающая действия объекта.",
            example = "מֶתוֹדָה מגדירה את ההתנהגות של אובייקט.",
            exampleNative = "У объекта Карточка есть מֶתוֹדָה для отображения редкости.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "oop"),
        WordEntity(id = 100209, original = "פָּרָמֶטֶר", transliteration = "parametr", translation = "параметр",
            definition = "משתנה בחתימת פונקציה לקבלת נתונים מהקורא.",
            definitionNative = "Переменная в сигнатуре функции для получения входных данных при вызове.",
            example = "פָּרָמֶטֶר מעביר מידע לתוך הפונקציה.",
            exampleNative = "Функция принимает פָּרָמֶטֶר — имя пользователя.",
            rarity = "RARE", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "basics"),
        WordEntity(id = 100210, original = "סִפְרִיָּה", transliteration = "sifriya", translation = "библиотека",
            definition = "אוסף קוד מוכן לשימוש חוזר הניתן לחיבור לתוכנית.",
            definitionNative = "Готовый набор кода, который можно подключить к программе для повторного использования.",
            example = "סִפְרִיָּה חיצונית מספקת קוד מוכן לשימוש.",
            exampleNative = "Для анимации мы подключили стороннюю סִפְרִיָּה.",
            rarity = "RARE", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "basics"),
        WordEntity(id = 100211, original = "מַסַּד נְתוּנִים", transliteration = "masad netunim", translation = "база данных",
            definition = "מאגר מידע מובנה לניהול ושאילתת נתונים.",
            definitionNative = "Организованное хранилище структурированной информации для управления запросами.",
            example = "מַסַּד נְתוּנִים שומר מידע בצורה מסודרת.",
            exampleNative = "Прогресс изучения хранится в מַסַּד נְתוּנִים.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "data_types"),
        WordEntity(id = 100212, original = "שְׁאֵלָתָה", transliteration = "she'ilta", translation = "запрос",
            definition = "פקודה למסד נתונים לאחזור, הוספה, עדכון או מחיקת נתונים.",
            definitionNative = "Команда к базе данных на выборку, вставку, обновление или удаление данных.",
            example = "שְׁאֵלָתָה מחזירה נתונים ממסד הנתונים.",
            exampleNative = "Приложение отправляет שְׁאֵלָתָה для поиска слов.",
            rarity = "RARE", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "data_types"),
        WordEntity(id = 100213, original = "שְׁגִיאָה", transliteration = "shgi'a", translation = "ошибка",
            definition = "תקלה בריצת התוכנית — תחבירית, לוגית או בזמן ריצה.",
            definitionNative = "Нарушение в работе программы — синтаксическое, логическое или времени выполнения.",
            example = "שְׁגִיאָה עצרה את ריצת התוכנית.",
            exampleNative = "Консоль вывела שְׁגִיאָה: переменная не инициализирована.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "debugging"),
        WordEntity(id = 100214, original = "נִפּוּי שְׁגִיאוֹת", transliteration = "nipuy shgi'ot", translation = "отладка",
            definition = "תהליך איתור, ניתוח ותיקון שגיאות בקוד התוכנה.",
            definitionNative = "Процесс поиска, анализа и исправления ошибок в программном коде.",
            example = "נִפּוּי שְׁגִיאוֹת מוצא ומתקן בעיות בקוד.",
            exampleNative = "Разработчик потратил час на נִפּוּי שְׁגִיאוֹת.",
            rarity = "RARE", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "debugging"),
        WordEntity(id = 100215, original = "פּוֹלִי-מוֹרְפִיזְם", transliteration = "poli-morfizm", translation = "полиморфизм",
            rarity = "RARE", languagePair = "he-ru", setId = 1002),
        WordEntity(id = 100216, original = "מַחְרוֹזֶת", transliteration = "makhrozet", translation = "строка (тип данных)",
            definition = "סוג נתונים המייצג רצף תווים בתוך מרכאות.",
            definitionNative = "Тип данных, представляющий последовательность символов в кавычках.",
            example = "מַחְרוֹזֶת מכילה טקסט בתוך מרכאות.",
            exampleNative = "Имя игрока хранится как מַחְרוֹזֶת, а не число.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "data_types"),
        WordEntity(id = 100217, original = "מִסְפָּר שָׁלֵם", transliteration = "mispar shalem", translation = "целое число",
            definition = "סוג נתונים למספרים שלמים ללא חלק עשרוני.",
            definitionNative = "Тип данных для хранения целых чисел без дробной части.",
            example = "מִסְפָּר שָׁלֵם אינו כולל חלקים עשרוניים.",
            exampleNative = "Счёт в PvP хранится как מִסְפָּר שָׁלֵם.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "data_types"),
        WordEntity(id = 100218, original = "בּוּלֵיאָנִי", transliteration = "buli'ani", translation = "булев тип",
            definition = "סוג נתונים המקבל רק ערך נכון (true) או לא נכון (false).",
            definitionNative = "Тип данных, принимающий только значение истина (true) или ложь (false).",
            example = "בּוּלֵיאָנִי מקבל ערך של נכון או לא נכון.",
            exampleNative = "Флаг правильного ответа хранится в בּוּלֵיאָנִי.",
            rarity = "RARE", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "data_types"),
        WordEntity(id = 100219, original = "מַמְשָׁק", transliteration = "mimshak", translation = "интерфейс",
            definition = "חוזה המגדיר שיטות שמחלקה חייבת לממש בתכנות מונחה-עצמים.",
            definitionNative = "Контракт в ООП, описывающий набор методов, которые обязан реализовать класс.",
            example = "מַמְשָׁק מגדיר חוזה בין מחלקות בתוכנית.",
            exampleNative = "Все репозитории реализуют один и тот же מַמְשָׁק.",
            rarity = "RARE", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "oop"),
        WordEntity(id = 100220, original = "יְרוּשָׁה", transliteration = "yerusha", translation = "наследование",
            definition = "מנגנון שבו מחלקה מקבלת מאפיינים ושיטות ממחלקת הורה.",
            definitionNative = "Механизм ООП, при котором класс перенимает свойства и методы родительского класса.",
            example = "יְרוּשָׁה מאפשרת למחלקה לקבל שיטות מהורה.",
            exampleNative = "Класс EpicCard использует יְרוּשָׁה от базового класса.",
            rarity = "RARE", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "oop"),
        WordEntity(id = 100221, original = "חֲרִיגָה", transliteration = "khariga", translation = "исключение",
            definition = "אירוע המשבש את ריצת התוכנית ומטופל בבלוק try/catch.",
            definitionNative = "Событие, нарушающее нормальный ход программы и обрабатываемое блоком try/catch.",
            example = "חֲרִיגָה זורקת שגיאה כאשר המסד אינו זמין.",
            exampleNative = "Программа выбрасывает חֲרִיגָה, если база недоступна.",
            rarity = "RARE", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "debugging"),
        WordEntity(id = 100222, original = "הַחְזָרָה", transliteration = "hakhazara", translation = "возврат значения",
            definition = "פקודה המסיימת פונקציה ומעבירה את התוצאה לקוד הקורא.",
            definitionNative = "Инструкция, завершающая функцию и передающая результат вызывающему коду.",
            example = "הַחְזָרָה מסיימת את הפונקציה ומחזירה ערך.",
            exampleNative = "В конце функции стоит הַחְזָרָה итогового числа баллов.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "basics"),
        WordEntity(id = 100223, original = "יִיבּוּא", transliteration = "yivua", translation = "импорт",
            definition = "הוראה המחברת מודול חיצוני או ספריה לקובץ הנוכחי.",
            definitionNative = "Директива, подключающая внешний модуль или библиотеку к текущему файлу.",
            example = "יִיבּוּא של ספריה מתבצע בראש הקובץ.",
            exampleNative = "В начале файла стоит יִיבּוּא необходимых библиотек.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "basics"),
        WordEntity(id = 100224, original = "הֶעָרָה", transliteration = "he'ara", translation = "комментарий",
            definition = "טקסט בקוד שהמהדר מתעלם ממנו, המסביר את הלוגיקה.",
            definitionNative = "Текст в коде, игнорируемый компилятором и поясняющий логику для разработчиков.",
            example = "הֶעָרָה מסבירה את הלוגיקה של הקוד.",
            exampleNative = "Разработчик оставил הֶעָרָה рядом со сложной функцией.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "basics"),
        WordEntity(id = 100225, original = "גִּרְסָה", transliteration = "garsa", translation = "версия",
            definition = "מהדורה ממוספרת של תוכנה המשקפת את מצבה בזמן נתון.",
            definitionNative = "Пронумерованный выпуск программного обеспечения, отражающий его состояние на момент разработки.",
            example = "גִּרְסָה חדשה של האפליקציה פורסמה.",
            exampleNative = "Команда выпустила новую גִּרְסָה приложения.",
            rarity = "UNCOMMON", languagePair = "he-ru", setId = 1002, pos = "noun", semanticGroup = "basics"),
    )

    // ── Set 103 — Advanced Computer Science (B2/C1) ───────────────────────────
    private fun set3() = listOf(
        WordEntity(id = 100301, original = "מֶטְרִיקוֹת", transliteration = "metrikkot", translation = "метрики / показатели производительности",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003),
        WordEntity(id = 100302, original = "רְקוּרְסִיָּה", transliteration = "rekursiya", translation = "рекурсия",
            definition = "טכניקה שבה פונקציה קוראת לעצמה לפתרון בעיה.",
            definitionNative = "Техника программирования, при которой функция вызывает сама себя.",
            example = "רְקוּרְסִיָּה שימושית לעיבוד מבני עץ.",
            exampleNative = "Обход дерева реализован через רְקוּרְסִיָּה.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "cs_theory"),
        WordEntity(id = 100303, original = "מַהְדֵּר", transliteration = "mahder", translation = "компилятор",
            definition = "תוכנה המתרגמת קוד מקור לקוד מכונה.",
            definitionNative = "Программа, переводящая исходный код на языке высокого уровня в машинный код.",
            example = "מַהְדֵּר הופך קוד מקור לקוד מכונה.",
            exampleNative = "После установки нового מַהְדֵּר сборка стала быстрее.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "cs_theory"),
        WordEntity(id = 100304, original = "אִינְטֶגְרַצְיָה", transliteration = "integratsya", translation = "интеграция (систем)",
            definition = "תהליך חיבור מערכות ורכיבים שונים לכלל מכלול עובד.",
            definitionNative = "Процесс объединения различных систем и компонентов в единое работающее целое.",
            example = "אִינְטֶגְרַצְיָה בין השירותים מאפשרת שיתוף נתונים.",
            exampleNative = "אִינְטֶגְרַצְיָה между сервисами позволяет обмениваться данными.",
            rarity = "RARE", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "cs_theory"),
        WordEntity(id = 100305, original = "הַצְפָּנָה", transliteration = "hatspana", translation = "шифрование",
            definition = "תהליך קריפטוגרפי להפיכת טקסט גלוי לבלתי קריא.",
            definitionNative = "Криптографический процесс преобразования открытого текста в нечитаемый вид.",
            example = "הַצְפָּנָה מגנה על נתונים רגישים.",
            exampleNative = "Пароли хранятся после обработки алгоритмом הַצְפָּנָה.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "security"),
        WordEntity(id = 100306, original = "אִימּוּת", transliteration = "imut", translation = "аутентификация",
            definition = "תהליך אימות זהות משתמש או מערכת.",
            definitionNative = "Процесс проверки подлинности пользователя или системы.",
            example = "אִימּוּת בשני שלבים מגביר את האבטחה.",
            exampleNative = "Без прохождения אִימּוּת пользователь не войдёт в систему.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "security"),
        WordEntity(id = 100307, original = "מַסְגֶּרֶת עֲבוֹדָה", transliteration = "masgeret avoda", translation = "фреймворк",
            definition = "פלטפורמה עם קוד מוכן וסכמות לפיתוח אפליקציות.",
            definitionNative = "Платформа с готовым кодом и соглашениями для разработки приложений.",
            example = "מַסְגֶּרֶת עֲבוֹדָה מאיצה את פיתוח האפליקציה.",
            exampleNative = "Приложение написано с использованием מַסְגֶּרֶת עֲבוֹדָה Jetpack.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "architecture"),
        WordEntity(id = 100308, original = "מַאֲגָר", transliteration = "ma'agar", translation = "репозиторий",
            definition = "מאגר קוד מקור עם היסטוריית שינויים וענפים.",
            definitionNative = "Хранилище исходного кода проекта с историей всех изменений и ветками.",
            example = "מַאֲגָר מאחסן את היסטוריית השינויים בקוד.",
            exampleNative = "Новый разработчик склонировал מַאֲגָר проекта с GitHub.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "architecture"),
        WordEntity(id = 100309, original = "פְּרִיסָה", transliteration = "prisa", translation = "развёртывание",
            definition = "העברת תוכנה מסביבת פיתוח לסביבת ייצור.",
            definitionNative = "Процесс перемещения готового ПО из среды разработки в рабочую среду.",
            example = "פְּרִיסָה אוטומטית חוסכת זמן לצוות הפיתוח.",
            exampleNative = "CI/CD запустило автоматическую פְּרִיסָה новой версии.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "architecture"),
        WordEntity(id = 100310, original = "מַכָּל", transliteration = "makal", translation = "контейнер",
            definition = "סביבת ריצה מבודדת הכוללת אפליקציה עם כל יחסי התלות.",
            definitionNative = "Изолированная среда выполнения, объединяющая приложение со всеми зависимостями.",
            example = "מַכָּל מבודד את סביבת הריצה של האפליקציה.",
            exampleNative = "Каждый микросервис упакован в отдельный מַכָּל Docker.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "infrastructure"),
        WordEntity(id = 100311, original = "מִיקְרוֹ-שֵׁרוּת", transliteration = "mikro-sherut", translation = "микросервис",
            definition = "שירות קטן ועצמאי במערכת מבוזרת המבצע תפקיד אחד.",
            definitionNative = "Небольшой независимый сервис в распределённой архитектуре, выполняющий одну функцию.",
            example = "מִיקְרוֹ-שֵׁרוּת קטן ועצמאי מקל על התחזוקה.",
            exampleNative = "Переход на מִיקְרוֹ-שֵׁרוּת позволил деплоить компоненты отдельно.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "infrastructure"),
        WordEntity(id = 100312, original = "וִירְטוּאַלִיזַצְיָה", transliteration = "virtualizatsya", translation = "виртуализация",
            definition = "טכנולוגיה המאפשרת הפעלת מספר מערכות הפעלה על שרת פיזי אחד.",
            definitionNative = "Технология, позволяющая запускать несколько ОС на одном физическом сервере.",
            example = "וִירְטוּאַלִיזַצְיָה מאפשרת ניצול יעיל יותר של משאבי החומרה.",
            exampleNative = "וִירְטוּאַלִיזַצְיָה позволяет эффективнее использовать аппаратные ресурсы.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "infrastructure"),
        WordEntity(id = 100313, original = "חוּט", transliteration = "khut", translation = "поток (thread)",
            definition = "יחידת ביצוע קטנה בתוך תהליך המשתף זיכרון עם חוטים אחרים.",
            definitionNative = "Наименьшая единица выполнения внутри процесса, разделяющая память с другими потоками.",
            example = "חוּט חדש נוצר לכל בקשה נכנסת.",
            exampleNative = "Сервер создаёт отдельный חוּט для каждого запроса.",
            rarity = "RARE", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "memory"),
        WordEntity(id = 100314, original = "אוֹרְכֵסְטְרַצְיָה", transliteration = "orkestratsia", translation = "оркестрация (контейнеров/сервисов)",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003),
        WordEntity(id = 100315, original = "זִיכָּרוֹן", transliteration = "zikharon", translation = "память",
            definition = "משאב חומרה לאחסון נתונים והוראות לגישה מהירה.",
            definitionNative = "Аппаратный ресурс компьютера для хранения данных и инструкций.",
            example = "זִיכָּרוֹן מהיר משפר את ביצועי התוכנה.",
            exampleNative = "Утечка זִיכָּרוֹן привела к аварийному завершению.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "memory"),
        WordEntity(id = 100316, original = "מַטְמוֹן", transliteration = "matmon", translation = "кэш",
            definition = "אחסון ביניים מהיר לנתונים נגישים לצורך האצת גישה.",
            definitionNative = "Быстрое промежуточное хранилище для часто запрашиваемых данных.",
            example = "מַטְמוֹן שומר נתונים לטעינה מהירה.",
            exampleNative = "Благодаря מַטְמוֹן запросы выполняются быстрее.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "memory"),
        WordEntity(id = 100317, original = "פְּרוֹטוֹקוֹל", transliteration = "protokol", translation = "протокол",
            definition = "כללים ופורמטים לתקשורת בין שני מחשבים ברשת.",
            definitionNative = "Набор правил и форматов для обмена данными между участниками сети.",
            example = "פְּרוֹטוֹקוֹל HTTPS מצפין את תעבורת הרשת.",
            exampleNative = "Браузер общается с сервером по פְּרוֹטוֹקוֹל HTTPS.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "infrastructure"),
        WordEntity(id = 100318, original = "רֶשֶׁת", transliteration = "reshet", translation = "сеть",
            definition = "אוסף מכשירים מחוברים לתקשורת והעברת נתונים.",
            definitionNative = "Совокупность соединённых устройств для передачи данных между ними.",
            example = "רֶשֶׁת מאפשרת שיתוף קבצים בין מחשבים.",
            exampleNative = "Администратор настроил внутреннюю רֶשֶׁת компании.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "infrastructure"),
        WordEntity(id = 100319, original = "שֶׁרֶת", transliteration = "sheret", translation = "сервер",
            definition = "מחשב או תוכנה המספקים שירותים ללקוחות ברשת.",
            definitionNative = "Компьютер или программа, предоставляющие сервисы клиентам в сети.",
            example = "שֶׁרֶת עונה על בקשות לקוח ברשת.",
            exampleNative = "После перегрузки שֶׁרֶת время ответа выросло.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "infrastructure"),
        WordEntity(id = 100320, original = "לָקוֹחַ", transliteration = "lakoakh", translation = "клиент",
            definition = "תוכנה או מכשיר השולחים בקשות לשרת ומקבלים תשובות.",
            definitionNative = "Программа или устройство, которое отправляет запросы серверу и получает ответы.",
            example = "לָקוֹחַ שולח בקשה לשרת ומקבל תשובה.",
            exampleNative = "Мобильное приложение выступает в роли לָקוֹחַ.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "infrastructure"),
        WordEntity(id = 100321, original = "מְכוֹנָה וִירְטוּאָלִית", transliteration = "mekhona virtualit", translation = "виртуальная машина",
            definition = "אמולציה תוכנתית של מחשב הרצה על חומרה פיזית.",
            definitionNative = "Программная эмуляция компьютерной системы, работающая на физическом оборудовании.",
            example = "מְכוֹנָה וִירְטוּאָלִית רצה על חומרה פיזית.",
            exampleNative = "Разработчик тестировал приложение в מְכוֹנָה וִירְטוּאָלִית.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "infrastructure"),
                WordEntity(id = 100322, original = "מַנְחֵה", transliteration = "[manˈxe]", translation = "оркестратор (система управления контейнерами)", rarity = "EPIC", setId = 1003, languagePair = "he-ru", pos = "noun", semanticGroup = "tech_advanced",
            definition = "a system that automates the deployment and management of containerised applications",
            example = "Kubernetes is the most widely used orchestrator for containerised workloads.",
            definitionNative = "Система, автоматизирующая развёртывание и управление контейнеризованными приложениями.",
            exampleNative = "Kubernetes — наиболее широко используемый manhe для контейнеризованных рабочих нагрузок."),
        WordEntity(id = 100323, original = "אִרְגּוּן מֵחָדָשׁ", transliteration = "irgun mekhadash", translation = "рефакторинг",
            definition = "שיפור מבנה הקוד ללא שינוי ההתנהגות החיצונית.",
            definitionNative = "Улучшение внутренней структуры кода без изменения его внешнего поведения.",
            example = "אִרְגּוּן מֵחָדָשׁ שיפר את מבנה הקוד.",
            exampleNative = "После אִרְגּוּן מֵחָדָשׁ функция стала вдвое короче.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "architecture"),
                WordEntity(id = 100324, original = "יְתִירוּת", transliteration = "[jetiˈrut]", translation = "избыточность; дублирование (для надёжности)", rarity = "EPIC", setId = 1003, languagePair = "he-ru", pos = "noun", semanticGroup = "tech_advanced",
            definition = "the duplication of critical system components to ensure continued operation if one fails",
            example = "Built-in redundancy ensures the service stays online even if one server goes down.",
            definitionNative = "Дублирование критических компонентов системы для обеспечения работы при отказе одного из них.",
            exampleNative = "Встроенная yetirut гарантирует, что сервис остаётся онлайн, даже если один сервер выходит из строя."),
        WordEntity(id = 100325, original = "בְּדִיקוֹת", transliteration = "bdikot", translation = "тестирование",
            definition = "תהליך בדיקת קוד כדי לאתר שגיאות ולוודא תפקוד תקין.",
            definitionNative = "Процесс проверки кода для обнаружения ошибок и подтверждения корректной работы.",
            example = "בְּדִיקוֹת אוטומטיות חוסכות זמן ומונעות רגרסיות.",
            exampleNative = "Автоматические בְּדִיקוֹת экономят время и предотвращают регрессии.",
            rarity = "EPIC", languagePair = "he-ru", setId = 1003, pos = "noun", semanticGroup = "architecture"),
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
