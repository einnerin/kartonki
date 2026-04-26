package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Мобильная разработка", L1 «Основы» (COMMON+UNCOMMON).
 *
 * Set 1783: «Мобильная разработка» — основы L1:
 *           устройство, приложение, базовый UI, простые жесты, установка/магазин.
 *
 * Тема — для русскоязычного репатрианта, который только начинает разбираться,
 * как объяснить на иврите свои отношения с телефоном: где у него экран, что
 * за иконка на главном экране, как нажать на кнопку и куда тыкать пальцем.
 * Это базовая бытовая лексика мобильника, ещё до программирования —
 * в L3 (1769) уже идут платформы и стек, в L4 (1770) — производительность
 * и дистрибуция. L1 целенаправленно остаётся на уровне обычного юзера.
 *
 * Лексика — смесь иврита и реальных английских заимствований, которые
 * звучат в живой речи (סְמַארְטְפוֹן, אַיְקוֹן, סְלַיידֶר, סְוַייפּ,
 * הוֹם סְקְרִין, קְלִיק כָּפוּל) — НЕ ивритизированные кальки.
 *
 * Распределение редкостей:
 *   Set 1783: 13 COMMON + 12 UNCOMMON.
 *
 * SemanticGroups (5 × 5):
 *   mobile_basic_device      — устройство и аппаратная часть: телефон,
 *                              смартфон, экран, аккумулятор, зарядка
 *   mobile_basic_app         — приложение и его места на телефоне: иконка,
 *                              обои, главный экран, ярлык
 *   mobile_basic_ui_simple   — простые элементы интерфейса: кнопка, поле
 *                              ввода, меню, переключатель, ползунок
 *   mobile_basic_actions     — базовые жесты: тап, свайп, долгое нажатие,
 *                              щипок (pinch), двойной клик
 *   mobile_basic_install     — управление приложениями: установка, обновление,
 *                              удаление, разрешения, магазин приложений
 *
 * Word IDs: setId × 100 + position (178301..178325).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewMobileL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1783, languagePair = "he-ru", orderIndex = 1783,
            name = "Мобильная разработка",
            description = "Базовая лексика: телефон, экран, приложение, кнопки, иконки",
            topic = "Мобильная разработка", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1783 — Мобильная разработка: основы (L1, COMMON+UNCOMMON, A1-A2)
        // 5 групп × 5 слов: device, app, ui_simple, actions, install
        // ══════════════════════════════════════════════════════════════════════

        // ── mobile_basic_device (5) — устройство и аппаратная часть ──
        WordEntity(
            id = 178301, setId = 1783, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "mobile_basic_device", transliteration = "telefon",
            original = "טֶלֶפוֹן", translation = "телефон",
            definition = "מַכְשִׁיר קָטָן בַּיָּד שֶׁבּוֹ מְדַבְּרִים, כּוֹתְבִים וְקוֹרְאִים חֲדָשׁוֹת.",
            definitionNative = "Маленькое устройство в руке, в нём говорят, пишут и читают новости.",
            example = "שָׁכַחְתִּי אֶת הַטֶּלֶפוֹן בַּמֹּנִית כְּשֶׁחָזַרְתִּי הַבַּיְתָה.",
            exampleNative = "Я забыл טֶלֶפוֹן в такси, когда возвращался домой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178302, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_device", transliteration = "smartfon",
            original = "סְמַארְטְפוֹן", translation = "смартфон",
            definition = "טֶלֶפוֹן חָכָם עִם מָסָךְ גָּדוֹל שֶׁמַּרִיץ תּוֹכְנוֹת רַבּוֹת וּמִתְחַבֵּר לָרֶשֶׁת.",
            definitionNative = "Умный телефон с большим дисплеем, что запускает много программ и выходит в сеть.",
            example = "קָנִיתִי סְמַארְטְפוֹן חָדָשׁ עִם מַצְלֵמָה טוֹבָה לַטִּיּוּל.",
            exampleNative = "Я купил новый סְמַארְטְפוֹן с хорошей камерой для поездки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178303, setId = 1783, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "mobile_basic_device", transliteration = "masakh",
            original = "מָסָךְ", translation = "экран",
            definition = "לוּחַ זְכוּכִית בְּחֶלְקוֹ הַקִּדְמִי שֶׁל הַמַּכְשִׁיר — שָׁם רוֹאִים תְּמוּנוֹת וְטֶקְסְט.",
            definitionNative = "Стеклянная панель на лицевой стороне устройства — там видно картинки и текст.",
            example = "הַמָּסָךְ שֶׁל הַטֶּלֶפוֹן נִשְׁבַּר אַחֲרֵי שֶׁנָּפַל עַל הָרִצְפָּה.",
            exampleNative = "מָסָךְ телефона разбился после того, как он упал на пол.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178304, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_device", transliteration = "solela",
            original = "סוֹלְלָה", translation = "аккумулятор",
            definition = "חֲתִיכָה קְטַנָּה בְּתוֹךְ הַמַּכְשִׁיר שֶׁאוֹגֶרֶת חַשְׁמַל וְנוֹתֶנֶת לוֹ לִפְעוֹל בְּלִי כַּבְל.",
            definitionNative = "Маленькая штука внутри устройства — копит электричество и даёт работать без провода.",
            example = "הַסּוֹלְלָה נִגְמְרָה לִי בְּאֶמְצַע שִׂיחָה חֲשׁוּבָה עִם אִמָּא.",
            exampleNative = "סוֹלְלָה села у меня посреди важного разговора с мамой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178305, setId = 1783, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "mobile_basic_device", transliteration = "mat'en",
            original = "מַטְעֵן", translation = "зарядное устройство",
            definition = "כַּבְל וּתוֹסֶפֶת לַקִּיר שֶׁמְּמַלְּאִים אֶת הַסּוֹלְלָה כְּשֶׁהִיא נֶחְלֶשֶׁת.",
            definitionNative = "Кабель и насадка в розетку — они наполняют батарею, когда та слабеет.",
            example = "שָׁכַחְתִּי אֶת הַמַּטְעֵן בְּמָלוֹן וְעַכְשָׁו אֲנִי בְּלִי טֶלֶפוֹן.",
            exampleNative = "Я забыл מַטְעֵן в гостинице и теперь без телефона.",
            isFillInBlankSafe = false,
        ),

        // ── mobile_basic_app (5) — приложение и его места на телефоне ──
        WordEntity(
            id = 178306, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_app", transliteration = "aplikatsya",
            original = "אַפְּלִיקַצְיָה", translation = "приложение",
            definition = "תּוֹכְנָה קְטַנָּה לַטֶּלֶפוֹן שֶׁעוֹשָׂה דָּבָר אֶחָד טוֹב — מַפָּה, מוּזִיקָה אוֹ הוֹדָעוֹת.",
            definitionNative = "Маленькая программа в телефоне для одного дела — карты, музыка или сообщения.",
            example = "הוֹרַדְתִּי אַפְּלִיקַצְיָה חֲדָשָׁה לְמַעֲקָב אַחֲרֵי הוֹצָאוֹת.",
            exampleNative = "Я скачал новое אַפְּלִיקַצְיָה для отслеживания расходов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178307, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_app", transliteration = "aikon",
            original = "אַיְקוֹן", translation = "иконка",
            definition = "צִיּוּר קָטָן וְצִבְעוֹנִי שֶׁמַּפְעִיל אֶת הַתּוֹכְנָה כְּשֶׁנּוֹגְעִים בּוֹ.",
            definitionNative = "Маленький цветной рисунок — запускает программу, когда по нему касаются.",
            example = "סִידַּרְתִּי אֶת כָּל הָאַיְקוֹן בְּסֵדֶר חָדָשׁ לְפִי צֶבַע.",
            exampleNative = "Я разложил все אַיְקוֹן по новому порядку — по цвету.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178308, setId = 1783, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "mobile_basic_app", transliteration = "tapet",
            original = "טַפֵּט", translation = "обои (заставка)",
            definition = "תְּמוּנַת רֶקַע שֶׁרוֹאִים מֵאֲחוֹרֵי הָאַיְקוֹנִים כְּשֶׁפּוֹתְחִים אֶת הַטֶּלֶפוֹן.",
            definitionNative = "Фоновая картинка — её видно за иконками, когда открываешь телефон.",
            example = "הֶחְלַפְתִּי טַפֵּט לִתְמוּנָה שֶׁל הַיְּלָדִים בַּחוֹף.",
            exampleNative = "Я поменял טַפֵּט на снимок детей на пляже.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178309, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_app", transliteration = "hom skrin",
            original = "הוֹם סְקְרִין", translation = "главный экран",
            definition = "הַדַּף הָרִאשׁוֹן שֶׁנִּפְתָּח אַחֲרֵי לְחִיצָה עַל כַּפְתּוֹר הַבַּיִת אוֹ פְּתִיחַת הַטֶּלֶפוֹן.",
            definitionNative = "Первая страница — открывается после кнопки «домой» или разблокировки телефона.",
            example = "שַׂמְתִּי בַּהוֹם סְקְרִין רַק שָׁלוֹשׁ אַפְּלִיקַצְיוֹת חֲשׁוּבוֹת.",
            exampleNative = "Я оставил на הוֹם סְקְרִין только три важных приложения.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178310, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_app", transliteration = "kitsur derekh",
            original = "קִיצּוּר דֶּרֶךְ", translation = "ярлык",
            definition = "אַיְקוֹן שֶׁמּוֹבִיל יָשִׁיר לְפֻנְקְצְיָה אוֹ דַּף בְּלִי לַעֲבוֹר דֶּרֶךְ הַתַּפְרִיט הָרָאשִׁי.",
            definitionNative = "Иконка, ведущая прямо к функции или странице — без захода в общее меню.",
            example = "יָצַרְתִּי קִיצּוּר דֶּרֶךְ לַשִּׂיחָה עִם אִשְׁתִּי עַל הַמָּסָךְ.",
            exampleNative = "Я создал קִיצּוּר דֶּרֶךְ для звонка жене прямо на дисплей.",
            isFillInBlankSafe = false,
        ),

        // ── mobile_basic_ui_simple (5) — простые элементы интерфейса ──
        WordEntity(
            id = 178311, setId = 1783, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "mobile_basic_ui_simple", transliteration = "kaftor",
            original = "כַּפְתּוֹר", translation = "кнопка",
            definition = "אֵזוֹר קָטָן עַל הַמָּסָךְ שֶׁעוֹשֶׂה פְּעֻלָּה אַחַת כְּשֶׁנּוֹגְעִים בּוֹ.",
            definitionNative = "Маленький участок на дисплее — выполняет одно действие, когда по нему касаются.",
            example = "לָחַצְתִּי בִּטְעוּת עַל הַכַּפְתּוֹר הָאָדֹם שֶׁל מְחִיקַת הַחֶשְׁבּוֹן.",
            exampleNative = "Я случайно нажал на красный כַּפְתּוֹר удаления аккаунта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178312, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_ui_simple", transliteration = "sde tekst",
            original = "שְׂדֵה טֶקְסְט", translation = "поле ввода",
            definition = "מָקוֹם בַּטֹּפֶס שֶׁבּוֹ מַקְלִידִים שֵׁם, סִיסְמָה אוֹ הוֹדָעָה לְפִי בַּקָּשַׁת הַתּוֹכְנָה.",
            definitionNative = "Место в форме — туда печатают имя, пароль или сообщение по запросу программы.",
            example = "הַשְּׂדֵה טֶקְסְט שֶׁל הַסִּיסְמָה לֹא אִפְשֵׁר לִי לִכְתוֹב יוֹתֵר מִשֵּׁשׁ אוֹתִיּוֹת.",
            exampleNative = "שְׂדֵה טֶקְסְט пароля не дал мне написать больше шести букв.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178313, setId = 1783, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "mobile_basic_ui_simple", transliteration = "tafrit",
            original = "תַּפְרִיט", translation = "меню",
            definition = "רְשִׁימָה שֶׁל אֶפְשָׁרֻיּוֹת שֶׁנִּפְתַּחַת מִכַּפְתּוֹר וּמַצִּיעָה לִבְחוֹר פְּעֻלָּה אַחַת.",
            definitionNative = "Список вариантов — раскрывается с кнопки и предлагает выбрать одно действие.",
            example = "פָּתַחְתִּי אֶת הַתַּפְרִיט וּבָחַרְתִּי בְּהוֹסָפַת חֶשְׁבּוֹן שֵׁנִי.",
            exampleNative = "Я открыл תַּפְרִיט и выбрал добавление второго аккаунта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178314, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_ui_simple", transliteration = "meteg",
            original = "מֶתֶג", translation = "переключатель",
            definition = "אֵזוֹר קָטָן שֶׁזָּז יָמִינָה אוֹ שְׂמֹאלָה — מַדְלִיק אוֹ מְכַבֶּה תְּכוּנָה.",
            definitionNative = "Маленький бегунок ходит вправо-влево — включает или выключает свойство.",
            example = "כִּבִּיתִי אֶת הַמֶּתֶג שֶׁל הַהוֹדָעוֹת בַּלַּיְלָה לִפְנֵי הַשֵּׁנָה.",
            exampleNative = "Я выключил מֶתֶג уведомлений на ночь перед сном.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178315, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_ui_simple", transliteration = "slayder",
            original = "סְלַיידֶר", translation = "ползунок",
            definition = "פַּס דַּק עִם נְקֻדָּה שֶׁמּוֹשְׁכִים בָּאֶצְבַּע כְּדֵי לְהַגְדִּיל אוֹ לְהַקְטִין עֵרֶךְ.",
            definitionNative = "Тонкая полоска с точкой — её тянут пальцем, чтобы увеличить или уменьшить значение.",
            example = "מָשַׁכְתִּי אֶת הַסְּלַיידֶר שֶׁל הַבְּהִירוּת לַמַּקְסִימוּם בַּשֶּׁמֶשׁ.",
            exampleNative = "Я потянул סְלַיידֶר яркости на максимум — на солнце.",
            isFillInBlankSafe = false,
        ),

        // ── mobile_basic_actions (5) — базовые жесты ──
        WordEntity(
            id = 178316, setId = 1783, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "mobile_basic_actions", transliteration = "negi'a",
            original = "נְגִיעָה", translation = "тап (нажатие на экран)",
            definition = "מַגָּע קָצָר שֶׁל אֶצְבַּע אַחַת בַּמָּסָךְ — הַפְּעֻלָּה הָרָגִילָה לִפְתִיחַת תּוֹכְנָה.",
            definitionNative = "Короткий контакт одного пальца с дисплеем — обычное действие для запуска программы.",
            example = "נְגִיעָה אַחַת בָּאַיְקוֹן פּוֹתַחַת אֶת הַתּוֹכְנָה תּוֹךְ שְׁנִיָּה.",
            exampleNative = "Одна נְגִיעָה по иконке открывает программу за секунду.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178317, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_actions", transliteration = "swaip",
            original = "סְוַייפּ", translation = "свайп",
            definition = "תְּנוּעַת אֶצְבַּע מָהִירָה לְצַד מְסֻיָּם בַּמָּסָךְ — לְמַעֲבָר בֵּין דַּפִּים אוֹ הוֹדָעוֹת.",
            definitionNative = "Быстрое движение пальцем в одну сторону по дисплею — для смены страниц или сообщений.",
            example = "עָשִׂיתִי סְוַייפּ לִשְׂמֹאל וּמָחַקְתִּי בִּטְעוּת הוֹדָעָה חֲשׁוּבָה.",
            exampleNative = "Я сделал סְוַייפּ влево и случайно стёр важное сообщение.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178318, setId = 1783, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "mobile_basic_actions", transliteration = "lekhitsa arukha",
            original = "לְחִיצָה אֲרֻכָּה", translation = "долгое нажатие",
            definition = "הַחְזָקָה שֶׁל הָאֶצְבַּע עַל הַמָּסָךְ כַּמָּה שְׁנִיּוֹת כְּדֵי לִפְתֹּחַ אֶפְשָׁרֻיּוֹת נוֹסָפוֹת.",
            definitionNative = "Удержание пальца на дисплее несколько секунд — открывает дополнительные опции.",
            example = "לְחִיצָה אֲרֻכָּה עַל הָאַיְקוֹן הִרְאֲתָה לִי אֶת תַּפְרִיט הַמְּחִיקָה.",
            exampleNative = "לְחִיצָה אֲרֻכָּה по иконке показала мне меню удаления.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178319, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_actions", transliteration = "tsvita",
            original = "צְבִיטָה", translation = "щипок (pinch — увеличение/уменьшение)",
            definition = "תְּנוּעָה שֶׁל שְׁתֵּי אֶצְבָּעוֹת — מִתְקָרְבוֹת אוֹ מִתְרַחֲקוֹת — לְשִׁנּוּי גֹּדֶל הַתְּמוּנָה.",
            definitionNative = "Движение двух пальцев — сходятся или расходятся — для смены размера картинки.",
            example = "צְבִיטָה עַל הַמַּפָּה הִגְדִּילָה אֶת הָרְחוֹב שֶׁחִפַּשְׂתִּי.",
            exampleNative = "צְבִיטָה по карте увеличила улицу, которую я искал.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178320, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "mobile_basic_actions", transliteration = "klik kaful",
            original = "קְלִיק כָּפוּל", translation = "двойной клик",
            definition = "שְׁתֵּי נְגִיעוֹת מְהִירוֹת זוֹ אַחַר זוֹ בְּאוֹתוֹ מָקוֹם — לְהַגְדָּלָה אוֹ סִימּוּן לַייק.",
            definitionNative = "Два быстрых касания подряд по одному месту — для приближения или отметки лайком.",
            example = "קְלִיק כָּפוּל עַל הַתְּמוּנָה בָּאִינְסְטָגְרָם נָתַן לְחָבֵר לֵב אָדֹם.",
            exampleNative = "קְלִיק כָּפוּל по фото в Инстаграме поставил другу красное сердечко.",
            isFillInBlankSafe = false,
        ),

        // ── mobile_basic_install (5) — управление приложениями ──
        WordEntity(
            id = 178321, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_install", transliteration = "hatkana",
            original = "הַתְקָנָה", translation = "установка",
            definition = "תַּהֲלִיךְ הַעֲתָקָה שֶׁל תּוֹכְנָה חֲדָשָׁה לַטֶּלֶפוֹן כְּדֵי שֶׁאֶפְשָׁר יִהְיֶה לִפְתֹּחַ אוֹתָהּ.",
            definitionNative = "Процесс копирования новой программы в телефон — чтобы её можно было запустить.",
            example = "הַהַתְקָנָה לָקְחָה לִי כִּמְעַט עֶשֶׂר דַּקּוֹת בִּגְלַל אִינְטֶרְנֶט אִטִּי.",
            exampleNative = "הַתְקָנָה заняла у меня почти десять минут — медленный интернет.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178322, setId = 1783, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "mobile_basic_install", transliteration = "idkun",
            original = "עִדְכּוּן", translation = "обновление",
            definition = "גִּרְסָה חֲדָשָׁה יוֹתֵר שֶׁמַּחְלִיפָה אֶת הַיְּשָׁנָה — מוֹסִיפָה תְּכוּנוֹת וּמְתַקֶּנֶת בְּעָיוֹת.",
            definitionNative = "Более новая версия — заменяет старую, добавляет фичи и чинит проблемы.",
            example = "הוֹרַדְתִּי עִדְכּוּן גָּדוֹל בַּלַּיְלָה כְּדֵי לֹא לְהַפְרִיעַ לָעֲבוֹדָה.",
            exampleNative = "Я скачал большое עִדְכּוּן ночью — чтобы не мешать работе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178323, setId = 1783, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "mobile_basic_install", transliteration = "hasara",
            original = "הֲסָרָה", translation = "удаление",
            definition = "הוֹצָאָה שֶׁל תּוֹכְנָה מֵהַטֶּלֶפוֹן בְּצוּרָה מְלֵאָה — הָאַיְקוֹן וְהַקְּבָצִים נֶעֱלָמִים יַחַד.",
            definitionNative = "Полный вывод программы из телефона — иконка и файлы исчезают вместе.",
            example = "הֶחְלַטְתִּי עַל הֲסָרָה שֶׁל מִשְׂחָקִים יְשָׁנִים כְּדֵי לְפַנּוֹת מָקוֹם.",
            exampleNative = "Я решился на הֲסָרָה старых игр — чтобы освободить место.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178324, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_basic_install", transliteration = "harshaot",
            original = "הַרְשָׁאוֹת", translation = "разрешения",
            definition = "אִישׁוּרִים שֶׁהַתּוֹכְנָה מְבַקֶּשֶׁת מֵהַמִּשְׁתַּמֵּשׁ — לְמַצְלֵמָה, מִיקְרוֹפוֹן אוֹ מִיקּוּם.",
            definitionNative = "Согласия, что программа просит у пользователя — на камеру, микрофон или местоположение.",
            example = "סֵרַבְתִּי לָתֵת הַרְשָׁאוֹת לְמִיקְרוֹפוֹן בְּמִשְׂחָק לִילָדִים קָטָן.",
            exampleNative = "Я отказал в הַרְשָׁאוֹת на микрофон в маленькой детской игре.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178325, setId = 1783, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "mobile_basic_install", transliteration = "khanut tokhnot",
            original = "חֲנוּת תּוֹכְנוֹת", translation = "магазин приложений",
            definition = "מָקוֹם דִּיגִיטָלִי שֶׁבּוֹ מוֹרִידִים אוֹ קוֹנִים תּוֹכְנוֹת רִשְׁמִיּוֹת לַטֶּלֶפוֹן.",
            definitionNative = "Цифровое место — там скачивают или покупают официальные программы для телефона.",
            example = "חִפַּשְׂתִּי בַּחֲנוּת תּוֹכְנוֹת מַשֶּׁהוּ לִלְמִידַת עִבְרִית בָּאוֹטוֹבּוּס.",
            exampleNative = "Я искал в חֲנוּת תּוֹכְנוֹת что-то для изучения иврита в автобусе.",
            isFillInBlankSafe = false,
        ),
    )
}
