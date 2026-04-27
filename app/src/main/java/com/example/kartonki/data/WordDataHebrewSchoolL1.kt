package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Дети и школа в Израиле", level 1 (A1-A2).
 * Один сет × 25 слов. setId = 1812.
 *
 *  - 13 COMMON + 12 UNCOMMON (2 смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      kids_school_basic_people    — люди в школе (5)
 *      kids_school_basic_school    — здание и распорядок школы (5)
 *      kids_school_basic_supplies  — школьные принадлежности (5)
 *      kids_school_basic_actions   — учебные действия-глаголы (5)
 *      kids_school_basic_grades    — уроки, оценки, расписание (5)
 *  - Все слова — базовая школьная лексика для семей с детьми
 *    в израильской системе. Никудим везде. isFillInBlankSafe=false
 *    на старте — после полировки и pipeline безопасные слова будут
 *    переведены в safe.
 *  - Темы образования взрослых ("Образование": сеты 1031, 1269-1271;
 *    "Учитель": 1403-1412) — это другие topic, пересечения original
 *    допустимы по политике дублей.
 */
object WordDataHebrewSchoolL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1812, languagePair = "he-ru", orderIndex = 1812,
            name = "Дети и школа в Израиле",
            description = "Базовая лексика: ребёнок, школа, учитель, класс, домашка",
            topic = "Дети и школа в Израиле", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── kids_school_basic_people (5) ─────────────────────────────────
        WordEntity(
            id = 181201, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_people",
            original = "יֶלֶד", translation = "ребёнок / мальчик",
            transliteration = "йелед",
            definition = "אָדָם צָעִיר מְאוֹד שֶׁעוֹד לֹא הִגִּיעַ לְגִיל הַבַּגְרוּת.",
            definitionNative = "Маленький человек, который ещё не вырос — ходит в сад или школу.",
            example = "הַיֶּלֶד רָץ עִם הַתִּיק שֶׁלּוֹ אֶל בֵּית הַסֵּפֶר.",
            exampleNative = "Этот יֶלֶד бежит с рюкзаком прямо в школу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181202, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_people",
            original = "יַלְדָּה", translation = "девочка",
            transliteration = "ялда",
            definition = "אָדָם נְקֵבָה צָעִיר מְאוֹד שֶׁעוֹד לוֹמֵד בְּבֵית הַסֵּפֶר אוֹ בַּגַּן.",
            definitionNative = "Маленький человек женского пола — ходит в садик или начальную школу.",
            example = "הַיַּלְדָּה צִיְּרָה פֶּרַח בָּרֹד עַל הַדַּף הַחָדָשׁ.",
            exampleNative = "Эта יַלְדָּה нарисовала розовый цветок на чистом листке.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181203, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_people",
            original = "מוֹרֶה", translation = "учитель",
            transliteration = "морэ",
            definition = "גֶּבֶר שֶׁמַּסְבִּיר חוֹמֶר לִילָדִים בְּבֵית הַסֵּפֶר.",
            definitionNative = "Мужчина, который объясняет материал детям в школе.",
            example = "הַמּוֹרֶה כָּתַב אֶת הַתַּרְגִּיל הַחָדָשׁ עַל הַלּוּחַ.",
            exampleNative = "מוֹרֶה написал новое задание на доске.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181204, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_people",
            original = "מוֹרָה", translation = "учительница",
            transliteration = "мора",
            definition = "אִשָּׁה שֶׁמַּסְבִּירָה חוֹמֶר לִילָדִים בַּכִּתָּה.",
            definitionNative = "Женщина, которая ведёт уроки и объясняет материал в классе.",
            example = "הַמּוֹרָה הִקְרִיאָה סִיפּוּר קָצָר לִפְנֵי הַהַפְסָקָה.",
            exampleNative = "מוֹרָה прочитала короткий рассказ перед самой переменой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181205, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_people",
            original = "תַּלְמִיד", translation = "ученик",
            transliteration = "талмид",
            definition = "יֶלֶד שֶׁלּוֹמֵד בְּבֵית הַסֵּפֶר וּמַקְשִׁיב לַמּוֹרֶה.",
            definitionNative = "Тот, кто ходит на уроки и слушает объяснения преподавателя.",
            example = "כָּל תַּלְמִיד בַּכִּתָּה הֵבִיא מַחְבֶּרֶת חֲדָשָׁה.",
            exampleNative = "Каждый תַּלְמִיד в классе принёс новую тетрадь.",
         fillInBlankExclusions = listOf(181201L, 181202L, 181203L, 181204L)),

        // ─── kids_school_basic_school (5) ─────────────────────────────────
        WordEntity(
            id = 181206, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_school",
            original = "בֵּית סֵפֶר", translation = "школа",
            transliteration = "бэйт-сэфэр",
            definition = "מָקוֹם שֶׁבּוֹ יְלָדִים לוֹמְדִים קְרִיאָה, חֶשְׁבּוֹן וְעוֹד מִקְצוֹעוֹת.",
            definitionNative = "Здание, куда дети ходят учиться чтению, счёту и другим предметам.",
            example = "בֵּית סֵפֶר חָדָשׁ נִפְתַּח קָרוֹב לַשְּׁכוּנָה שֶׁלָּנוּ.",
            exampleNative = "Новый בֵּית סֵפֶר открылся совсем рядом с нашим домом.",
         fillInBlankExclusions = listOf(181207L, 181208L, 181209L, 181210L)),
        WordEntity(
            id = 181207, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_school",
            original = "כִּתָּה", translation = "класс",
            transliteration = "кита",
            definition = "חֶדֶר עִם שֻׁלְחָנוֹת שֶׁבּוֹ יוֹשְׁבִים יְלָדִים בַּשִּׁעוּר.",
            definitionNative = "Комната со столами, где дети сидят на уроке.",
            example = "הַכִּתָּה שֶׁלִּי גְּדוֹלָה וּמוּאֶרֶת בְּשֶׁמֶשׁ.",
            exampleNative = "Моя כִּתָּה большая и солнечная по утрам.",
         fillInBlankExclusions = listOf(181206L, 181208L, 181209L, 181210L)),
        WordEntity(
            id = 181208, setId = 1812, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "kids_school_basic_school",
            original = "חֲצַר בֵּית הַסֵּפֶר", translation = "школьный двор",
            transliteration = "хацар бэйт-hа-сэфэр",
            definition = "שֶׁטַח פָּתוּחַ לְיַד בֵּית הַסֵּפֶר שֶׁבּוֹ יְלָדִים מְשַׂחֲקִים בַּהַפְסָקָה.",
            definitionNative = "Открытое место рядом со школой, где дети играют на перемене.",
            example = "כָּל הַיְלָדִים יָצְאוּ לַחֲצַר בֵּית הַסֵּפֶר עִם הַכַּדּוּר.",
            exampleNative = "Все ребята выскочили в חֲצַר בֵּית הַסֵּפֶר с большим мячом.",
         fillInBlankExclusions = listOf(181206L, 181207L, 181209L, 181210L)),
        WordEntity(
            id = 181209, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_school",
            original = "פַּעֲמוֹן", translation = "звонок (школьный)",
            transliteration = "паамон",
            definition = "צְלִיל קוֹלָנִי שֶׁמּוֹדִיעַ עַל תְּחִילַּת אוֹ סוֹף הַשִּׁעוּר.",
            definitionNative = "Громкий звуковой сигнал, который сообщает о начале или конце урока.",
            example = "הַפַּעֲמוֹן צִלְצֵל וְהַיְּלָדִים רָצוּ לַכִּתָּה.",
            exampleNative = "פַּעֲמוֹן зазвенел, и дети помчались обратно в класс.",
         fillInBlankExclusions = listOf(181206L, 181208L, 181210L)),
        WordEntity(
            id = 181210, setId = 1812, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "kids_school_basic_school",
            original = "הַפְסָקָה", translation = "перемена / перерыв",
            transliteration = "hафсака",
            definition = "זְמַן קָצָר בֵּין הַשִּׁעוּרִים שֶׁבּוֹ אוֹכְלִים וּמְשַׂחֲקִים.",
            definitionNative = "Короткое время между уроками, когда едят и играют во дворе.",
            example = "בַּהַפְסָקָה אָכַלְתִּי כָּרִיךְ עִם גְּבִינָה צְהֻבָּה.",
            exampleNative = "На הַפְסָקָה я съел бутерброд с жёлтым сыром.",
         fillInBlankExclusions = listOf(181206L, 181207L, 181208L, 181209L)),

        // ─── kids_school_basic_supplies (5) ───────────────────────────────
        WordEntity(
            id = 181211, setId = 1812, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "kids_school_basic_supplies",
            original = "תִּיק", translation = "рюкзак / портфель",
            transliteration = "тик",
            definition = "כְּלִי בַּד אוֹ עוֹר שֶׁנּוֹשְׂאִים עַל הַגַּב עִם סְפָרִים וּמַחְבָּרוֹת.",
            definitionNative = "Сумка, которую носят за спиной с книгами и тетрадями.",
            example = "שַׂמְתִּי בַּתִּיק קֻפְסַת אֹכֶל וּבַקְבּוּק מַיִם.",
            exampleNative = "Я положил в תִּיק коробочку с обедом и бутылку воды.",
         fillInBlankExclusions = listOf(181212L, 181213L, 181214L, 181215L)),
        WordEntity(
            id = 181212, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_supplies",
            original = "סֵפֶר", translation = "книга / учебник",
            transliteration = "сэфэр",
            definition = "אֹסֶף דַּפִּים כְּרוּכִים יַחַד עִם סִיפּוּר אוֹ חוֹמֶר לִלְמִידָה.",
            definitionNative = "Сшитые вместе листы со связным текстом или материалом для изучения.",
            example = "פָּתַחְתִּי סֵפֶר חָדָשׁ וְהִתְחַלְתִּי לִקְרֹא.",
            exampleNative = "Я открыл новый סֵפֶר и начал читать.",
         fillInBlankExclusions = listOf(181211L, 181213L, 181214L, 181215L)),
        WordEntity(
            id = 181213, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_supplies",
            original = "מַחְבֶּרֶת", translation = "тетрадь",
            transliteration = "махбэрэт",
            definition = "חוֹבֶרֶת שֶׁל דַּפִּים רֵיקִים שֶׁבָּהּ כּוֹתְבִים שִׁעוּרִים וְתַרְגִּילִים.",
            definitionNative = "Книжечка с пустыми листами, в которой записывают задания и упражнения.",
            example = "כָּתַבְתִּי בַּמַּחְבֶּרֶת אֶת הַתַּשׁוּבָה הַנְּכוֹנָה.",
            exampleNative = "Я записал в מַחְבֶּרֶת правильный ответ.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181214, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_supplies",
            original = "עִפָּרוֹן", translation = "карандаш",
            transliteration = "ипарон",
            definition = "מַקֵּל עֵץ דַּקִּיק עִם פֶּחָם בְּתוֹכוֹ שֶׁמְּצַיְּרִים אוֹ כּוֹתְבִים בּוֹ.",
            definitionNative = "Тонкая деревянная палочка с грифелем внутри — ей рисуют или пишут.",
            example = "הָעִפָּרוֹן שֶׁלִּי נִשְׁבַּר וְלָקַחְתִּי אַחֵר מֵהַתִּיק.",
            exampleNative = "Мой עִפָּרוֹן сломался, и я достал из рюкзака другой.",
         fillInBlankExclusions = listOf(181212L, 181213L, 181215L)),
        WordEntity(
            id = 181215, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_supplies",
            original = "צֶבַע", translation = "цвет / краска",
            transliteration = "цэва",
            definition = "מַה שֶּׁעֵינַיִם רוֹאוֹת — אָדֹם, כָּחוֹל אוֹ יָרוֹק עַל דַּף אוֹ עֶצֶם.",
            definitionNative = "То, что глаза видят на листе или предмете — например, красный или синий.",
            example = "בָּחַרְתִּי צֶבַע יָרוֹק לְצַיֵּר אֶת הַדֶּשֶׁא.",
            exampleNative = "Я выбрал зелёный צֶבַע, чтобы нарисовать траву.",
         fillInBlankExclusions = listOf(181211L, 181212L, 181213L, 181214L)),

        // ─── kids_school_basic_actions (5) ────────────────────────────────
        WordEntity(
            id = 181216, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "kids_school_basic_actions",
            original = "לִלְמֹד", translation = "учиться / изучать",
            transliteration = "лильмод",
            definition = "לְקַבֵּל יְדָע חָדָשׁ עַל יְדֵי הַקְשָׁבָה, קְרִיאָה וְתַרְגּוּל.",
            definitionNative = "Получать новые знания через слушание, чтение и упражнения.",
            example = "אֲנִי אוֹהֵב לִלְמֹד שָׂפוֹת חֲדָשׁוֹת בָּעֶרֶב.",
            exampleNative = "Мне нравится לִלְמֹד новые языки по вечерам.",
         fillInBlankExclusions = listOf(181217L, 181218L, 181219L, 181220L)),
        WordEntity(
            id = 181217, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "kids_school_basic_actions",
            original = "לִכְתֹּב", translation = "писать",
            transliteration = "лихтов",
            definition = "לִיצֹר אוֹתִיּוֹת אוֹ מִלִּים עַל דַּף בְּעִפָּרוֹן אוֹ בְּעֵט.",
            definitionNative = "Изображать буквы или слова на листе с помощью карандаша или ручки.",
            example = "הַיְלָדִים לוֹמְדִים לִכְתֹּב אֶת שְׁמָם בְּכִתָּה א'.",
            exampleNative = "Дети учатся לִכְתֹּב своё имя ещё в первом классе.",
         fillInBlankExclusions = listOf(181216L, 181218L, 181219L, 181220L)),
        WordEntity(
            id = 181218, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "kids_school_basic_actions",
            original = "לִקְרֹא", translation = "читать",
            transliteration = "ликро",
            definition = "לְהָבִין אוֹתִיּוֹת וּמִלִּים שֶׁכְּתוּבוֹת עַל דַּף אוֹ בְּסֵפֶר.",
            definitionNative = "Понимать буквы и слова, написанные на странице или в книге.",
            example = "אֲנִי אוֹהֵב לִקְרֹא לִפְנֵי הַשֵּׁנָה.",
            exampleNative = "Я люблю לִקְרֹא перед самым сном.",
         fillInBlankExclusions = listOf(181216L, 181217L, 181219L, 181220L)),
        WordEntity(
            id = 181219, setId = 1812, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "kids_school_basic_actions",
            original = "לְצַיֵּר", translation = "рисовать",
            transliteration = "лецаер",
            definition = "לִיצֹר תְּמוּנָה עַל דַּף בְּעֶזְרַת עִפָּרוֹן, צֶבַע אוֹ מִכְחוֹל.",
            definitionNative = "Создавать изображение на бумаге карандашом, краской или кистью.",
            example = "הַבַּת שֶׁלִּי אוֹהֶבֶת לְצַיֵּר חַיּוֹת קְטַנּוֹת בָּעֶרֶב.",
            exampleNative = "Моя дочка любит לְצַיֵּר по вечерам маленьких зверушек.",
         fillInBlankExclusions = listOf(181216L, 181217L, 181218L, 181220L)),
        WordEntity(
            id = 181220, setId = 1812, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "kids_school_basic_actions",
            original = "לְשַׂחֵק", translation = "играть",
            transliteration = "лесахэк",
            definition = "לַעֲסֹק בְּמִשְׂחָק כְּדֵי לֵיהָנוֹת — לְבַד אוֹ עִם חֲבֵרִים.",
            definitionNative = "Заниматься игрой ради удовольствия — одному или с друзьями.",
            example = "הַיְלָדִים יוֹצְאִים לְשַׂחֵק בַּחֲצֵר אַחֲרֵי הַשִּׁעוּרִים.",
            exampleNative = "Ребята выходят לְשַׂחֵק во двор сразу после уроков.",
         fillInBlankExclusions = listOf(181216L, 181217L, 181218L, 181219L)),

        // ─── kids_school_basic_grades (5) ─────────────────────────────────
        WordEntity(
            id = 181221, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_grades",
            original = "שִׁעוּר", translation = "урок",
            transliteration = "шиур",
            definition = "פֶּרֶק זְמַן בְּבֵית הַסֵּפֶר שֶׁבּוֹ הַמּוֹרֶה מַסְבִּיר חוֹמֶר חָדָשׁ.",
            definitionNative = "Промежуток времени в школе, когда преподаватель объясняет новый материал.",
            example = "הַשִּׁעוּר הָרִאשׁוֹן הַיּוֹם הוּא חֶשְׁבּוֹן.",
            exampleNative = "Первый שִׁעוּר сегодня — это математика.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181222, setId = 1812, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "kids_school_basic_grades",
            original = "שִׁעוּרֵי בַּיִת", translation = "домашнее задание",
            transliteration = "шиурэй байт",
            definition = "תַּרְגִּילִים שֶׁהַתַּלְמִיד עוֹשֶׂה בַּבַּיִת אַחֲרֵי בֵּית הַסֵּפֶר.",
            definitionNative = "Упражнения, которые ребёнок делает дома после школы.",
            example = "סִיַּמְתִּי אֶת שִׁעוּרֵי הַבַּיִת לִפְנֵי אֲרוּחַת הָעֶרֶב.",
            exampleNative = "Я сделал שִׁעוּרֵי בַּיִת ещё до ужина.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181223, setId = 1812, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "kids_school_basic_grades",
            original = "מִבְחָן", translation = "контрольная / экзамен",
            transliteration = "мивхан",
            definition = "בְּדִיקָה כְּתוּבָה שֶׁבּוֹדֶקֶת מַה הַתַּלְמִיד יוֹדֵעַ.",
            definitionNative = "Письменная проверка, которая показывает, что ребёнок знает.",
            example = "מָחָר יֵשׁ לָנוּ מִבְחָן בָּהִיסְטוֹרְיָה.",
            exampleNative = "Завтра у нас מִבְחָן по истории древнего мира.",
         fillInBlankExclusions = listOf(181221L, 181222L, 181224L, 181225L)),
        WordEntity(
            id = 181224, setId = 1812, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "kids_school_basic_grades",
            original = "צִיּוּן", translation = "оценка (балл)",
            transliteration = "цийун",
            definition = "מִסְפָּר שֶׁמַּרְאֶה כַּמָּה טוֹב הַתַּלְמִיד עָנָה בַּבְּדִיקָה.",
            definitionNative = "Число, которое показывает, насколько хорошо ребёнок ответил на проверке.",
            example = "קִיבַּלְתִּי צִיּוּן גָּבוֹהַּ בַּמִּבְחָן הָאַחֲרוֹן.",
            exampleNative = "Я получил высокий צִיּוּן за последнюю контрольную работу.",
         fillInBlankExclusions = listOf(181221L, 181222L, 181223L, 181225L)),
        WordEntity(
            id = 181225, setId = 1812, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "kids_school_basic_grades",
            original = "סוֹף שָׁבוּעַ", translation = "выходные",
            transliteration = "соф шавуа",
            definition = "יָמִים שִׁשִּׁי וְשַׁבָּת — בָּהֶם אֵין לִימּוּדִים וְאֵין עֲבוֹדָה.",
            definitionNative = "Пятница и суббота — дни, когда нет уроков и нет работы.",
            example = "בְּסוֹף שָׁבוּעַ נָסַעְנוּ עִם הַמִּשְׁפָּחָה לַיָּם.",
            exampleNative = "В סוֹף שָׁבוּעַ мы поехали всей семьёй на море.",
            isFillInBlankSafe = false,
        ),
    )
}
