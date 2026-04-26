package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "QA и тестирование", L1 «Основы» (COMMON+UNCOMMON).
 *
 * Set 1771: «QA и тестирование» — основы L1:
 *           самые базовые слова тестировщика — что проверяют, как нажимают,
 *           что находят, как описывают, с кем работают.
 *
 * Целевая аудитория — русскоязычный новичок в QA, который только-только
 * пришёл в команду израильского хайтека и должен понимать, о чём речь
 * на стендапе и в баг-репортах. Лексика — повседневная: иврит для
 * базовых понятий + редкие заимствования (טֶסְטֶר, מְתַכְנֵת) там, где так
 * реально говорят в офисах.
 *
 * Распределение редкостей: 13 COMMON + 12 UNCOMMON.
 *
 * SemanticGroups (5 × 5):
 *   qa_basics       — общая лексика: проблема, сбой, проверка, система, кнопка
 *   qa_actions      — базовые действия: нажать, открыть, закрыть, заполнить, отправить
 *   qa_findings     — что находит тестировщик: не работает, ошибочный
 *                     результат, вылет, зависание, медленно
 *   qa_report       — поля баг-репорта: описание, скриншот, шаги, ожидание, итог
 *   qa_team_basic   — команда: тестировщик, программист, менеджер, команда, задача
 *
 * Word IDs: setId × 100 + position (177101..177125).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewQaL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1771, languagePair = "he-ru", orderIndex = 1771,
            name = "QA и тестирование",
            description = "Базовая лексика тестировщика: ошибки, проверки, отчёты, экраны",
            topic = "QA и тестирование", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1771 — QA и тестирование: основы (L1, COMMON+UNCOMMON)
        // 5 групп × 5 слов: basics, actions, findings, report, team_basic
        // ══════════════════════════════════════════════════════════════════════

        // ── qa_basics (5) — общая лексика тестирования ──
        WordEntity(
            id = 177101, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "qa_basics", transliteration = "ba'aya",
            original = "בְּעָיָה", translation = "проблема",
            definition = "מַשֶּׁהוּ שֶׁלֹּא בְּסֵדֶר וְצָרִיךְ לְטַפֵּל בּוֹ — בַּמּוּצָר אוֹ בַּחַיִּים.",
            definitionNative = "Что-то не так — нужно разобраться: в продукте или в жизни.",
            example = "מָצָאתִי בְּעָיָה קְטַנָּה בַּדַּף הָרָאשִׁי שֶׁל הָאַתָר.",
            exampleNative = "Я нашёл небольшую בְּעָיָה на главной странице сайта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177102, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_basics", transliteration = "takala",
            original = "תַּקָּלָה", translation = "сбой",
            definition = "רֶגַע שֶׁבּוֹ הַמַּעֲרֶכֶת מַפְסִיקָה לַעֲבוֹד נָכוֹן בְּלִי שֶׁמִּישֶׁהוּ צִפָּה לְכָךְ.",
            definitionNative = "Момент, когда система перестаёт работать как надо — внезапно для всех.",
            example = "תַּקָּלָה בַּשָּׂרָת הִפִּילָה אֶת הַשֵּׁרוּת לַחֲצִי שָׁעָה הַבֹּקֶר.",
            exampleNative = "תַּקָּלָה на сервере положила сервис на полчаса с утра.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177103, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "qa_basics", transliteration = "bdika",
            original = "בְּדִיקָה", translation = "проверка",
            definition = "פְּעֻלָּה שֶׁל מִי שֶׁמַּסְתַּכֵּל בִּדְבַר־מָה כְּדֵי לָדַעַת אִם הַכֹּל בְּסֵדֶר.",
            definitionNative = "Действие — кто-то смотрит на что-то, чтобы понять, всё ли в порядке.",
            example = "כָּל בְּדִיקָה שֶׁלִּי לוֹקַחַת בְּעֵרֶךְ עֶשֶׂר דַּקּוֹת בַּטֶּלֶפוֹן.",
            exampleNative = "Каждая моя בְּדִיקָה занимает примерно десять минут на телефоне.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177104, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_basics", transliteration = "ma'arekhet",
            original = "מַעֲרֶכֶת", translation = "система",
            definition = "אוֹסֶף שֶׁל חֲלָקִים שֶׁעוֹבְדִים יַחַד — לְמָשָׁל אַתָר, שָׂרָת וּמָסַד נְתוּנִים.",
            definitionNative = "Набор частей, что работают вместе — например, сайт, сервер и база данных.",
            example = "כָּל מַעֲרֶכֶת חֲדָשָׁה דּוֹרֶשֶׁת בְּדִיקָה יְסוֹדִית לִפְנֵי הַשִׁחְרוּר.",
            exampleNative = "Любая новая מַעֲרֶכֶת требует тщательной проверки до релиза.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177105, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "qa_basics", transliteration = "kaftor",
            original = "כַּפְתּוֹר", translation = "кнопка",
            definition = "אֵיזוֹר קָטָן עַל הַמָּסָךְ שֶׁכּוֹתֵב טֶקְסְט וְמְקַבֵּל לְחִיצָה מִמִּישֶׁהוּ.",
            definitionNative = "Маленькая зона на экране — там написан текст, по ней щёлкают.",
            example = "הַכַּפְתּוֹר הַכָּתֹם בָּרֹאשׁ שׁוֹלֵחַ אֶת הַטֹּפֶס מִיָּד לַשָּׂרָת.",
            exampleNative = "Оранжевый כַּפְתּוֹר сверху сразу шлёт форму на сервер.",
            isFillInBlankSafe = false,
        ),

        // ── qa_actions (5) — базовые действия пользователя ──
        WordEntity(
            id = 177106, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "qa_actions", transliteration = "lilkhots",
            original = "לִלְחֹץ", translation = "нажать",
            definition = "לָגַעַת בְּאֶצְבַּע אוֹ בַּעַכְבָּר עַל מַשֶּׁהוּ קָטָן עַל הַמָּסָךְ.",
            definitionNative = "Тронуть пальцем или мышкой что-то маленькое на экране.",
            example = "צָרִיךְ לִלְחֹץ פַּעֲמַיִם עַל הַתְּמוּנָה כְּדֵי לְהַגְדִּיל אוֹתָהּ.",
            exampleNative = "Нужно לִלְחֹץ дважды на картинку, чтобы её увеличить.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177107, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "qa_actions", transliteration = "liftoakh",
            original = "לִפְתֹּחַ", translation = "открыть",
            definition = "לְהַגִּיעַ לַתֹּכֶן שֶׁהָיָה סָגוּר — דַּף בָּרֶשֶׁת, חַלּוֹן אוֹ קֹבֶץ.",
            definitionNative = "Добраться до содержимого, что было закрыто — страница в сети, окно или файл.",
            example = "נִסִּיתִי לִפְתֹּחַ אֶת הַקֹּבֶץ אֲבָל הַתּוֹכְנָה לֹא הִגִּיבָה.",
            exampleNative = "Я попробовал לִפְתֹּחַ файл, но программа не реагировала.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177108, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "qa_actions", transliteration = "lisgor",
            original = "לִסְגֹּר", translation = "закрыть",
            definition = "לְהַפְסִיק לְהַצִּיג חַלּוֹן אוֹ דַּף וּלְפַנּוֹת מָקוֹם עַל הַמָּסָךְ.",
            definitionNative = "Перестать показывать окно или вкладку — освободить место на экране.",
            example = "הַמַּעֲרֶכֶת בִּקְּשָׁה לִסְגֹּר אֶת כָּל הַחַלּוֹנוֹת לִפְנֵי הָעִדְכּוּן.",
            exampleNative = "Система попросила לִסְגֹּר все окна перед обновлением.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177109, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "qa_actions", transliteration = "lemale",
            original = "לְמַלֵּא", translation = "заполнить",
            definition = "לִכְתֹּב טֶקְסְט בְּכָל הַשָּׂדוֹת שֶׁל טֹפֶס לִפְנֵי שֶׁשּׁוֹלְחִים אוֹתוֹ.",
            definitionNative = "Написать текст во всех полях формы — перед тем как её отправить.",
            example = "צָרִיךְ לְמַלֵּא שֵׁם וְכַתֹּבֶת לִפְנֵי שֶׁאֶפְשָׁר לְהִתְקַדֵּם.",
            exampleNative = "Надо לְמַלֵּא имя и адрес — без этого не продвинуться.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177110, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "qa_actions", transliteration = "lishloakh",
            original = "לִשְׁלֹחַ", translation = "отправить",
            definition = "לְהַעֲבִיר טֹפֶס אוֹ הוֹדָעָה מֵהַמָּסָךְ שֶׁלִּי לַמְּקַבֵּל בָּרֶשֶׁת.",
            definitionNative = "Передать форму или сообщение со своего экрана получателю по сети.",
            example = "אָסוּר לִשְׁלֹחַ אֶת הַטֹּפֶס לִפְנֵי שֶׁכָּל הַשָּׂדוֹת מְלֵאִים.",
            exampleNative = "Нельзя לִשְׁלֹחַ форму, пока не все поля заполнены.",
            isFillInBlankSafe = false,
        ),

        // ── qa_findings (5) — что находит тестировщик ──
        WordEntity(
            id = 177111, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "qa_findings", transliteration = "lo oved",
            original = "לֹא עוֹבֵד", translation = "не работает",
            definition = "מַצָּב שֶׁל מַכְשִׁיר אוֹ שֵׁרוּת שֶׁאֵינוֹ מַגִּיב לַפְּעֻלּוֹת שֶׁל הַמִּשְׁתַּמֵּשׁ.",
            definitionNative = "Состояние устройства или сервиса — не отзывается на действия пользователя.",
            example = "הַחִפּוּשׂ בָּאַתָר לֹא עוֹבֵד מֵהַבֹּקֶר וְלָקוֹחוֹת מִתְלוֹנְנִים.",
            exampleNative = "Поиск на сайте לֹא עוֹבֵד с утра — клиенты жалуются.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177112, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_findings", transliteration = "totsa'a lo nekhona",
            original = "תּוֹצָאָה לֹא נְכוֹנָה", translation = "ошибочный результат",
            definition = "תְּשׁוּבָה שֶׁל הַתּוֹכְנָה שֶׁשּׁוֹנָה מִמָּה שֶׁצָּרִיךְ לְפִי הַחִשּׁוּב הַנָּכוֹן.",
            definitionNative = "Ответ программы — отличается от того, что должно быть по верному расчёту.",
            example = "הָאַתָר הֶחְזִיר תּוֹצָאָה לֹא נְכוֹנָה לַחִבּוּר שֶׁל שְׁנֵי מִסְפָּרִים.",
            exampleNative = "Сайт выдал תּוֹצָאָה לֹא נְכוֹנָה на сложение двух чисел.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177113, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_findings", transliteration = "krisa",
            original = "קְרִיסָה", translation = "вылет",
            definition = "סִיוּם פִּתְאוֹמִי שֶׁל תּוֹכְנָה — הַמָּסָךְ נֶעֱלָם וְהַכֹּל נִסְגַּר בְּלִי אַזְהָרָה.",
            definitionNative = "Внезапный конец программы — экран исчезает, всё закрывается без предупреждения.",
            example = "אַחֲרֵי קְרִיסָה הַטֶּלֶפוֹן הִתְחִיל מֵחָדָשׁ וְאִבַּדְתִּי אֶת הַטֹּפֶס.",
            exampleNative = "После קְרִיסָה телефон перезапустился — и я потерял форму.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177114, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_findings", transliteration = "tki'a",
            original = "תְּקִיעָה", translation = "зависание",
            definition = "מַצָּב שֶׁל תּוֹכְנָה שֶׁמַּפְסִיקָה לְהָגִיב אֲבָל לֹא נִסְגֶּרֶת — הַמָּסָךְ קָפוּא.",
            definitionNative = "Программа перестала отвечать, но не закрылась — экран будто заморожен.",
            example = "הַתְּקִיעָה שֶׁל הָאַפְּלִיקַצְיָה גָּרְמָה לִי לְהַתְחִיל אֶת הַטֶּלֶפוֹן.",
            exampleNative = "תְּקִיעָה приложения заставила меня перезагрузить телефон.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177115, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "qa_findings", transliteration = "iti",
            original = "אִטִּי", translation = "медленный",
            definition = "כָּזֶה שֶׁלּוֹקֵחַ זְמַן רַב יוֹתֵר מִמָּה שֶׁצָּרִיךְ — לֹא זָרִיז וְלֹא חָלָק.",
            definitionNative = "Такой, что занимает больше времени, чем нужно — без живости, без плавности.",
            example = "הָאַתָר אִטִּי בָּעַרְבּוּ וְכִמְעַט אַף לָקוֹחַ לֹא מַצְלִיחַ לְשַׁלֵּם.",
            exampleNative = "Сайт אִטִּי вечером — почти ни один клиент не успевает оплатить.",
            isFillInBlankSafe = false,
        ),

        // ── qa_report (5) — поля баг-репорта ──
        WordEntity(
            id = 177116, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_report", transliteration = "te'ur",
            original = "תֵּאוּר", translation = "описание",
            definition = "טֶקְסְט קָצָר שֶׁמְּסַפֵּר אֵיךְ נִרְאֶה דָּבָר־מָה אוֹ אֵיךְ הִתְרַחֵשׁ אֵרוּעַ.",
            definitionNative = "Короткий текст — рассказывает, как что-то выглядит или как произошёл случай.",
            example = "כָּתַבְתִּי תֵּאוּר קָצָר שֶׁל מָה שֶׁקָּרָה לִפְנֵי שֶׁהַטֶּלֶפוֹן נִכְבָּה.",
            exampleNative = "Я написал короткое תֵּאוּר того, что произошло перед выключением телефона.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177117, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_report", transliteration = "tsilum masakh",
            original = "צִילּוּם מָסָךְ", translation = "скриншот",
            definition = "תְּמוּנָה שֶׁשּׁוֹמֶרֶת אֶת מָה שֶׁרוֹאִים עַל הַטֶּלֶפוֹן אוֹ עַל הַמַּחְשֵׁב כָּרֶגַע.",
            definitionNative = "Картинка — сохраняет то, что видно на телефоне или компьютере прямо сейчас.",
            example = "צֵירַפְתִּי צִילּוּם מָסָךְ שֶׁל הַשְּׁגִיאָה לַהוֹדָעָה לַמְּפַתֵּחַ.",
            exampleNative = "Я приложил צִילּוּם מָסָךְ ошибки к сообщению разработчику.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177118, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "qa_report", transliteration = "shlavim",
            original = "שְׁלָבִים", translation = "шаги",
            definition = "סִדְרַת פְּעֻלּוֹת קְטַנּוֹת שֶׁעוֹשִׂים אַחַת אַחֲרֵי הַשְּׁנִיָּה עַד הַסּוֹף.",
            definitionNative = "Череда мелких действий — выполняют одно за другим до самого конца.",
            example = "רָשַׁמְתִּי בַּדּוּ\"חַ אֶת הַשְּׁלָבִים שֶׁגָּרְמוּ לַשְּׁגִיאָה בַּדַּף.",
            exampleNative = "Я записал в отчёт שְׁלָבִים, что привели к ошибке на странице.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177119, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_report", transliteration = "tsipiya",
            original = "צִפִּיָּה", translation = "ожидание (что должно было быть)",
            definition = "מָה שֶׁצָּרִיךְ הָיָה לִקְרוֹת לְפִי הַתָּכְנִית לִפְנֵי שֶׁמַּתְחִילִים אֶת הַבְּדִיקָה.",
            definitionNative = "Что должно было случиться по плану — до того как начали проверку.",
            example = "הַצִּפִּיָּה הָיְתָה שֶׁהַטֹּפֶס יִשְׁמֹר אוֹתוֹ אֲבָל הוּא נֶעֱלַם לְגַמְרֵי.",
            exampleNative = "צִפִּיָּה — что форма сохранит данные, но они исчезли совсем.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177120, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "qa_report", transliteration = "sikum",
            original = "סִכּוּם", translation = "итог",
            definition = "מִשְׁפָּט אֶחָד אוֹ שְׁנַיִם שֶׁמְּקַבְּצִים אֶת הָעִקָּר מִדּוּחַ אָרֹךְ.",
            definitionNative = "Одно-два предложения — собирают главное из длинного отчёта.",
            example = "בַּסִּיכּוּם רָשַׁמְתִּי שֶׁמּוּצָאוּ שָׁלוֹשׁ בְּעָיוֹת חֲדָשׁוֹת בַּגִּרְסָה.",
            exampleNative = "В סִכּוּם я отметил, что в версии нашли три новые проблемы.",
            isFillInBlankSafe = false,
        ),

        // ── qa_team_basic (5) — кто рядом по работе ──
        WordEntity(
            id = 177121, setId = 1771, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "qa_team_basic", transliteration = "tester",
            original = "טֶסְטֶר", translation = "тестировщик",
            definition = "אִישׁ הַמִּקְצוֹעַ שֶׁמְּחַפֵּשׂ בְּעָיוֹת בַּמּוּצָר לִפְנֵי שֶׁמַּגִּיעַ לַלָּקוֹחַ.",
            definitionNative = "Профессионал — ищет проблемы в продукте до того, как тот дойдёт до клиента.",
            example = "כָּל טֶסְטֶר חָדָשׁ לוֹמֵד שָׁבוּעַ אֵיךְ הַמַּעֲרֶכֶת בְּנוּיָה.",
            exampleNative = "Каждый новый טֶסְטֶר неделю учит, как устроена система.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177122, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "qa_team_basic", transliteration = "metakhnet",
            original = "מְתַכְנֵת", translation = "программист",
            definition = "אִישׁ הַמִּקְצוֹעַ שֶׁכּוֹתֵב לַמַּחְשֵׁב הוֹרָאוֹת בְּשָׂפָה מְיֻחֶדֶת.",
            definitionNative = "Профессионал — пишет машине инструкции на специальном языке.",
            example = "מְתַכְנֵת מִנִּיסָּיוֹן תִּקֵּן אֶת הַשְּׁגִיאָה תּוֹךְ עֶשְׂרִים דַּקּוֹת.",
            exampleNative = "Опытный מְתַכְנֵת исправил ошибку всего за двадцать минут.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177123, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "qa_team_basic", transliteration = "menahel",
            original = "מְנַהֵל", translation = "руководитель",
            definition = "אָדָם שֶׁמַּחְלִיט מָה הַצֶּוֶות יַעֲשֶׂה הַיּוֹם וְעוֹזֵר כְּשֶׁמִּישֶׁהוּ נִתְקָע.",
            definitionNative = "Человек, что решает, чем команда займётся сегодня — и помогает, если кто-то застрял.",
            example = "הַמְּנַהֵל בִּקֵּשׁ מִמֶּנִּי לִשְׁלֹחַ דּוּ\"חַ עַד סוֹף הַיּוֹם.",
            exampleNative = "מְנַהֵל попросил меня прислать отчёт до конца дня.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177124, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "qa_team_basic", transliteration = "tsevet",
            original = "צֶוֶות", translation = "команда",
            definition = "קְבוּצַת אֲנָשִׁים שֶׁעוֹבְדִים יַחַד עַל אוֹתוֹ מוּצָר וּמְדַבְּרִים כָּל יוֹם.",
            definitionNative = "Группа людей — работают вместе над одним продуктом, говорят каждый день.",
            example = "הַצֶּוֶות שֶׁלָּנוּ נִפְגָּשׁ כָּל בֹּקֶר בְּתֵשַׁע לְעֶשֶׂר דַּקּוֹת.",
            exampleNative = "Наш צֶוֶות встречается каждое утро в девять на десять минут.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177125, setId = 1771, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "qa_team_basic", transliteration = "mesima",
            original = "מְשִׂימָה", translation = "задача",
            definition = "פְּרִיט עֲבוֹדָה אֶחָד שֶׁמּוֹסְרִים לָאָדָם — עִם תַּאֲרִיךְ סִיוּם וְמִי אַחְרַאי.",
            definitionNative = "Один кусок работы — выдают человеку с дедлайном и ответственным.",
            example = "קִבַּלְתִּי מְשִׂימָה חֲדָשָׁה לִבְדֹּק אֶת דַּף הַתַּשְׁלוּם בָּעֶרֶב.",
            exampleNative = "Мне досталась новая מְשִׂימָה — проверить страницу оплаты вечером.",
            isFillInBlankSafe = false,
        ),
    )
}
