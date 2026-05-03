package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Идиомы и поговорки иврита", level 2 (B1-B2).
 * Один сет × 25 слов. setId = 1848. Продолжение L1 1847.
 *
 *  - 17 UNCOMMON + 8 RARE.
 *  - 5 семантических групп по 5 слов:
 *      idioms_l2_emotions       — чувства (легко/тяжело на сердце, на седьмом небе и т.д.)
 *      idioms_l2_work_money     — работа и деньги (грязная работа, мелочь, состояние, концы с концами)
 *      idioms_l2_speech         — речь (повышать голос, говорить со стеной, болтать, заткнуть рот)
 *      idioms_l2_situations     — ситуации (паршивое положение, бредятина, колесо поворачивается)
 *      idioms_l2_attitudes      — отношение (не повредит, всё равно, забить себе гол, проглотить лягушку)
 *  - Все pos = "phrase".
 *  - Никудим везде, включая саму идиому в `original`.
 *  - `transliteration` — кириллицей вся фраза целиком.
 *  - В `example` целевая идиома стоит verbatim в форме совпадающей с `original`
 *    (важно для иврита: инфинитив остаётся инфинитивом; избегаем שֶׁ-/בְּ-/לְ- перед
 *    original, чтобы не нарушать дагеш и form_match).
 *  - `exampleNative` — русская калька с самой идиомой В ИВРИТЕ внутри.
 *
 *  Замены из исходного плана (нерабочие/нестандартные → реальные привычные идиомы):
 *      - הַלֵּב יוֹצֵא מַיִם           → לֵב נִשְׁבָּר ("разбитое сердце")
 *      - מַחֲבֵק אֶת הָעוֹלָם          → עַל הָעֲנָנִים ("на седьмом небе" — реальное)
 *      - בְּצֶבַע הַכֶּסֶף              → עוֹלֶה הוֹן ("стоит состояние")
 *      - לְהָרִים אֶת הַתֵּל            → כֶּסֶף עוֹשֶׂה כֶּסֶף ("деньги к деньгам")
 *      - בַּמָּסוּף שֶׁל הַחֹדֶשׁ        → לִגְמֹר אֶת הַחֹדֶשׁ ("свести концы с концами")
 *      - מִתְחָרֵץ עַל הַטֹּעַם          → מוֹצִיא דִּבָּה ("распускать слухи")
 *      - מִדַּבֵּר חֲצָאֵי דְּבָרִים     → מְדַבֵּר אֶל הַקִּיר ("говорить со стеной")
 *      - מִתְעַסֵּק עִם הַסּוּסִים       → לְקַשְׁקֵשׁ בַּקּוּמְקוּם ("молоть языком, нести чушь" — современный сленг)
 *      - יוֹצֵא מִדַּעְתּוֹ (планировался в речь) → перенесён в emotions
 *        (= "вне себя от чувства"), а в speech добавлено סוֹתֵם אֶת הַפֶּה
 *      - מַצָּב לֹא טוֹב                → מַצָּב בִּיש ("паршивое положение" — идиоматичнее)
 *      - חֵרֵשׁ וְעִוֵּר                → שָׁבוּר וְרָצוּץ ("разбит и подавлен")
 *      - גַּלְגַּל הוֹפֵךְ              → הַגַּלְגַּל מִתְהַפֵּךְ (правильная форма этой идиомы)
 *      - שָׂם זַיִן                     → לֹא אִכְפַּת לוֹ ("ему всё равно" — без сленга;
 *                                          שָׂם זַיִן уже в L1)
 *      - נוֹפֵל בָּעֵצִים               → מַכְנִיס לְעַצְמוֹ גּוֹל ("забивать себе гол" — реальное современное)
 *      - חוֹתֵם בִּדְמוֹ                → בּוֹלֵעַ אֶת הַצְּפַרְדֵּעַ ("проглотить лягушку = смириться с неприятным")
 *
 *  Дублей `original` с L1 (1847) и другими he-ru сетами по точной фразе нет
 *  (проверено grep'ом 2026-04-29). Отдельные слова (לֵב, כֶּסֶף, קוֹל) встречаются
 *  как обычные существительные в других темах — здесь это устойчивые фразы целиком,
 *  что является политикой допустимости дублей.
 */
object WordDataHebrewIdiomsL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1848, languagePair = "he-ru", orderIndex = 1848,
            name = "Идиомы и поговорки иврита",
            description = "Расширенный набор израильских идиом — чувства, работа, речь, ситуации",
            topic = "Идиомы и поговорки иврита", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── idioms_l2_emotions (5) ──────────────────────────────────────
        WordEntity(
            id = 184801, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_emotions",
            original = "קַל עַל הַלֵּב", translation = "легко на сердце (на душе)",
            transliteration = "каль аль hа-лев",
            definition = "הַרְגָּשָׁה שֶׁל רְגִיעָה וְשִׂמְחָה — בְּלִי דְּאָגוֹת אוֹ עֹמֶס נַפְשִׁי.",
            definitionNative = "Чувство покоя и радости — без забот и душевной тяжести. Дословно: «легко на сердце».",
            example = "אַחֲרֵי הַשִּׂיחָה הַזֹּאת קַל עַל הַלֵּב וַאֲנִי יָכוֹל לִישֹׁן.",
            exampleNative = "После этого разговора קַל עַל הַלֵּב, и я наконец могу спать."
        , fillInBlankExclusions = listOf(184802L, 184803L, 184804L, 184805L)),
        WordEntity(
            id = 184802, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_emotions",
            original = "כָּבֵד עַל הַלֵּב", translation = "тяжело на сердце",
            transliteration = "кавед аль hа-лев",
            definition = "הַרְגָּשָׁה שֶׁל עֶצֶב אוֹ דְּאָגָה גְּדוֹלָה שֶׁלֹּא עוֹזֶבֶת.",
            definitionNative = "Чувство грусти или большой тревоги, которое не отпускает. Дословно: «тяжело на сердце».",
            example = "מֵאָז שֶׁעָזַב אוֹתָהּ כָּבֵד עַל הַלֵּב כָּל הַזְּמַן.",
            exampleNative = "С тех пор как он ушёл, ей כָּבֵד עַל הַלֵּב всё время."
        , fillInBlankExclusions = listOf(184801L, 184803L, 184804L, 184805L, 184820L)),
        WordEntity(
            id = 184803, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_emotions",
            original = "עַל הָעֲנָנִים", translation = "на седьмом небе (от счастья)",
            transliteration = "аль hа-ананим",
            definition = "מַרְגִּישׁ אֹשֶׁר עָצוּם — שָׂמֵחַ עַד שֶׁכִּמְעַט מְרַחֵף בָּאֲוִיר.",
            definitionNative = "Испытывает огромное счастье — рад до того, что почти парит в воздухе. Дословно: «на облаках».",
            example = "מֵאָז שֶׁהִיא קִבְּלָה אֶת הָעֲבוֹדָה הִיא עַל הָעֲנָנִים.",
            exampleNative = "С тех пор как она получила эту работу, она עַל הָעֲנָנִים."
        , fillInBlankExclusions = listOf(184801L, 184802L, 184804L, 184805L)),
        WordEntity(
            id = 184804, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_emotions",
            original = "לֵב נִשְׁבָּר", translation = "разбитое сердце",
            transliteration = "лев нишбар",
            definition = "כְּאֵב רִגְשִׁי עָמֹק אַחֲרֵי אַכְזָבָה גְּדוֹלָה — לְרֹב בְּאַהֲבָה.",
            definitionNative = "Глубокая эмоциональная боль после большого разочарования — обычно в любви. Дословно: «разбитое сердце».",
            example = "הִיא חָזְרָה הַבַּיְתָה עִם לֵב נִשְׁבָּר אַחֲרֵי הַפְּרֵדָה.",
            exampleNative = "Она вернулась домой с לֵב נִשְׁבָּר после расставания."
        , fillInBlankExclusions = listOf(184801L, 184802L, 184803L, 184805L)),
        WordEntity(
            id = 184805, setId = 1848, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l2_emotions",
            original = "יוֹצֵא מִדַּעְתּוֹ", translation = "сходит с ума (от чувства)",
            transliteration = "йоце ми-даато",
            definition = "מְאַבֵּד שְׁלִיטָה רִגְשִׁית — מֵרֹב כַּעַס, אַהֲבָה אוֹ הִתְרַגְּשׁוּת.",
            definitionNative = "Теряет эмоциональный контроль — от злости, любви или волнения. Дословно: «выходит из своего разума».",
            example = "הוּא יוֹצֵא מִדַּעְתּוֹ כְּשֶׁהוּא רוֹאֶה אוֹתָהּ צוֹחֶקֶת עִם אַחֵר.",
            exampleNative = "Он יוֹצֵא מִדַּעְתּוֹ, когда видит, как она смеётся с другим."
        ),

        // ─── idioms_l2_work_money (5) ────────────────────────────────────
        WordEntity(
            id = 184806, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_work_money",
            original = "עֲבוֹדָה שְׁחוֹרָה", translation = "грязная/тяжёлая работа",
            transliteration = "авода шхора",
            definition = "עֲבוֹדָה פִיזִית קָשָׁה אוֹ לֹא נְעִימָה שֶׁאַף אֶחָד לֹא רוֹצֶה לַעֲשׂוֹת.",
            definitionNative = "Тяжёлая физическая или неприятная работа, которую никто не хочет делать. Дословно: «чёрная работа».",
            example = "כָּל הַחַיִּים הוּא עָשָׂה עֲבוֹדָה שְׁחוֹרָה כְּדֵי לְפַרְנֵס מִשְׁפָּחָה.",
            exampleNative = "Всю жизнь он делал עֲבוֹדָה שְׁחוֹרָה, чтобы кормить семью."
        , fillInBlankExclusions = listOf(184807L, 184808L, 184809L, 184810L)),
        WordEntity(
            id = 184807, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_work_money",
            original = "כֶּסֶף קָטָן", translation = "мелочь (незначительная сумма)",
            transliteration = "кесеф катан",
            definition = "סְכוּם קָטָן וְלֹא חָשׁוּב — לֹא שַׁוֵּה הַתִּעֲסַקוּת.",
            definitionNative = "Маленькая и неважная сумма — не стоит хлопот. Дословно: «маленькие деньги».",
            example = "בִּשְׁבִילוֹ אֶלֶף שֶׁקֶל זֶה כֶּסֶף קָטָן וְהוּא לֹא סוֹפֵר אוֹתוֹ.",
            exampleNative = "Для него тысяча шекелей — это כֶּסֶף קָטָן, он на такое не смотрит."
        , fillInBlankExclusions = listOf(184806L, 184808L, 184809L, 184810L)),
        WordEntity(
            id = 184808, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_work_money",
            original = "עוֹלֶה הוֹן", translation = "стоит состояние (очень дорого)",
            transliteration = "оле hон",
            definition = "מַשֶּׁהוּ יָקָר מְאֹד — הַמְּחִיר שֶׁלּוֹ עָצוּם וְקָשֶׁה לְשַׁלֵּם.",
            definitionNative = "Что-то очень дорогое — цена огромная и платить сложно. Дословно: «стоит состояние».",
            example = "הַחֲתֻנָּה בְּתֵל אָבִיב עוֹלֶה הוֹן וְלֹא כָּל אֶחָד מַרְשֶׁה לְעַצְמוֹ.",
            exampleNative = "Свадьба в Тель-Авиве עוֹלֶה הוֹן — не каждый может себе позволить."
        , fillInBlankExclusions = listOf(184806L, 184807L, 184809L, 184810L)),
        WordEntity(
            id = 184809, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_work_money",
            original = "לִגְמֹר אֶת הַחֹדֶשׁ", translation = "свести концы с концами",
            transliteration = "лигмор эт hа-ходеш",
            definition = "בְּקֹשִׁי לְהַסְפִּיק לְשַׁלֵּם עַל כָּל הַהוֹצָאוֹת עַד מַשְׂכֹּרֶת הַבָּאָה.",
            definitionNative = "С трудом успевать оплатить все расходы до следующей зарплаты. Дословно: «закончить месяц».",
            example = "עִם שְׂכַר דִּירָה כָּזֶה קָשֶׁה מְאֹד לִגְמֹר אֶת הַחֹדֶשׁ.",
            exampleNative = "С такой арендой очень трудно לִגְמֹר אֶת הַחֹדֶשׁ."
        ),
        WordEntity(
            id = 184810, setId = 1848, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l2_work_money",
            original = "כֶּסֶף עוֹשֶׂה כֶּסֶף", translation = "деньги к деньгам",
            transliteration = "кесеф осе кесеф",
            definition = "מִי שֶׁכְּבָר עָשִׁיר מַרְוִיחַ עוֹד יוֹתֵר בְּקַלּוּת — הַהוֹן מוֹשֵׁךְ הוֹן.",
            definitionNative = "Кто уже богат — зарабатывает ещё больше с лёгкостью; капитал притягивает капитал. Дословно: «деньги делают деньги».",
            example = "כֶּסֶף עוֹשֶׂה כֶּסֶף, וְלָכֵן הָעֲשִׁירִים מַמְשִׁיכִים לְהִתְעַשֵּׁר.",
            exampleNative = "כֶּסֶף עוֹשֶׂה כֶּסֶף — поэтому богатые продолжают богатеть."
        , fillInBlankExclusions = listOf(184806L, 184807L, 184808L, 184809L)),

        // ─── idioms_l2_speech (5) ────────────────────────────────────────
        WordEntity(
            id = 184811, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_speech",
            original = "מֵרִים אֶת הַקּוֹל", translation = "повышает голос",
            transliteration = "мерим эт hа-коль",
            definition = "מַתְחִיל לְדַבֵּר בְּקוֹל רָם — לְרֹב מִתּוֹךְ כַּעַס אוֹ הִתְרַגְּשׁוּת.",
            definitionNative = "Начинает говорить громко — чаще всего от злости или волнения. Дословно: «поднимает голос».",
            example = "הוּא תָּמִיד מֵרִים אֶת הַקּוֹל כְּשֶׁהוּא כּוֹעֵס עָלַי.",
            exampleNative = "Он всегда מֵרִים אֶת הַקּוֹל, когда злится на меня."
        , fillInBlankExclusions = listOf(184812L, 184813L, 184814L, 184815L)),
        WordEntity(
            id = 184812, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_speech",
            original = "מְדַבֵּר אֶל הַקִּיר", translation = "говорит со стеной (его не слышат)",
            transliteration = "мэдабер эль hа-кир",
            definition = "מְנַסֶּה לְהַסְבִּיר אֲבָל אַף אֶחָד לֹא מַקְשִׁיב — בְּלִי תּוֹעֶלֶת.",
            definitionNative = "Пытается объяснить, но никто не слушает — впустую. Дословно: «говорит к стене».",
            example = "כְּשֶׁאֲנִי מְבַקֵּשׁ מֵהַיְּלָדִים לְסַדֵּר זֶה כְּמוֹ מְדַבֵּר אֶל הַקִּיר.",
            exampleNative = "Когда я прошу детей убраться, это как מְדַבֵּר אֶל הַקִּיר."
        , fillInBlankExclusions = listOf(184811L, 184813L, 184814L, 184815L)),
        WordEntity(
            id = 184813, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_speech",
            original = "לְקַשְׁקֵשׁ בַּקּוּמְקוּם", translation = "молоть языком (нести чушь)",
            transliteration = "лекашкеш ба-кумкум",
            definition = "לְדַבֵּר הַרְבֵּה בְּלִי תֹּכֶן רְצִינִי — לְפַטְפֵּט סְתָם.",
            definitionNative = "Много говорить без серьёзного содержания — пустая болтовня. Дословно: «греметь в чайнике».",
            example = "אֵין לוֹ מָה לוֹמַר וְהוּא רַק מַמְשִׁיךְ לְקַשְׁקֵשׁ בַּקּוּמְקוּם.",
            exampleNative = "Сказать ему нечего, он просто продолжает לְקַשְׁקֵשׁ בַּקּוּמְקוּם."
        , fillInBlankExclusions = listOf(184811L, 184812L, 184814L, 184815L)),
        WordEntity(
            id = 184814, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_speech",
            original = "מוֹצִיא דִּבָּה", translation = "распускает слухи (клевещет)",
            transliteration = "моци диба",
            definition = "מְסַפֵּר עַל מִישֶׁהוּ דְּבָרִים רָעִים — לְעִתִּים קְרוֹבוֹת לֹא נְכוֹנִים.",
            definitionNative = "Рассказывает о ком-то плохое — часто неправдивое. Дословно: «выносит дурную славу».",
            example = "אָסוּר מוֹצִיא דִּבָּה עַל חָבֵר בְּלִי לִבְדֹּק עֻבְדּוֹת.",
            exampleNative = "Нельзя מוֹצִיא דִּבָּה на товарища, не проверив фактов."
        , fillInBlankExclusions = listOf(184811L, 184812L, 184813L, 184815L)),
        WordEntity(
            id = 184815, setId = 1848, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l2_speech",
            original = "סוֹתֵם אֶת הַפֶּה", translation = "затыкает рот (заставляет молчать)",
            transliteration = "сотем эт hа-пэ",
            definition = "מַשְׁתִּיק מִישֶׁהוּ בְּכֹחַ — לֹא נוֹתֵן לוֹ לְהַמְשִׁיךְ לְדַבֵּר.",
            definitionNative = "Силой заставляет кого-то замолчать — не даёт продолжать говорить. Дословно: «закрывает рот».",
            example = "הוּא תָּמִיד סוֹתֵם אֶת הַפֶּה לְכָל מִי שֶׁמְּבַקֵּר אוֹתוֹ.",
            exampleNative = "Он всегда סוֹתֵם אֶת הַפֶּה каждому, кто его критикует."
        , fillInBlankExclusions = listOf(184811L, 184812L, 184813L, 184814L)),

        // ─── idioms_l2_situations (5) ────────────────────────────────────
        WordEntity(
            id = 184816, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_situations",
            original = "מַצָּב בִּיש", translation = "паршивое положение (плохо дело)",
            transliteration = "мацав биш",
            definition = "מַצָּב לֹא נָעִים וְקָשֶׁה — קָשֶׁה לְמְצֹא פִּתְרוֹן וְהַכֹּל מִסְתַּבֵּךְ.",
            definitionNative = "Неприятное и тяжёлое положение — сложно найти выход, всё запутано. Дословно: «дрянное положение».",
            example = "בְּלִי עֲבוֹדָה וְעִם הַלְוָאָה זֶה מַצָּב בִּיש מְאֹד.",
            exampleNative = "Без работы и с кредитом это очень מַצָּב בִּיש."
        , fillInBlankExclusions = listOf(184817L, 184818L, 184819L, 184820L)),
        WordEntity(
            id = 184817, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_situations",
            original = "מַשֶּׁהוּ הַזוּי", translation = "что-то нереальное (бредятина)",
            transliteration = "машеhу hазуй",
            definition = "מַשֶּׁהוּ מוּזָר וּמוּפְרָךְ — קָשֶׁה לְהַאֲמִין שֶׁזֶּה בֶּאֱמֶת קוֹרֶה.",
            definitionNative = "Нечто странное и абсурдное — трудно поверить, что это реально происходит. Современный сленг.",
            example = "הַסִּפּוּר שֶׁהוּא מְסַפֵּר זֶה מַשֶּׁהוּ הַזוּי לְגַמְרֵי.",
            exampleNative = "История, которую он рассказывает — это מַשֶּׁהוּ הַזוּי, абсолютная бредятина."
        , fillInBlankExclusions = listOf(184816L, 184818L, 184819L, 184820L)),
        WordEntity(
            id = 184818, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_situations",
            original = "מַשֶּׁהוּ אַחֵר", translation = "нечто особенное (другой уровень)",
            transliteration = "машеhу ахер",
            definition = "מַשֶּׁהוּ הַרְבֵּה יוֹתֵר טוֹב מֵהָרָגִיל — בִּרְמָה שׁוֹנָה לְגַמְרֵי.",
            definitionNative = "Нечто гораздо лучше обычного — совсем другого уровня. Используется как комплимент. Дословно: «нечто другое».",
            example = "הָאֹכֶל בַּמִּסְעָדָה הַזֹּאת זֶה מַשֶּׁהוּ אַחֵר לְגַמְרֵי.",
            exampleNative = "Еда в этом ресторане — это מַשֶּׁהוּ אַחֵר, совсем другой уровень."
        , fillInBlankExclusions = listOf(184816L, 184817L, 184819L, 184820L)),
        WordEntity(
            id = 184819, setId = 1848, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l2_situations",
            original = "הַגַּלְגַּל מִתְהַפֵּךְ", translation = "колесо поворачивается (всё меняется)",
            transliteration = "hа-гальгаль митhапех",
            definition = "הַמַּצָּב מִשְׁתַּנֶּה — מִי שֶׁהָיָה לְמַעְלָה יָרַד, וּמִי שֶׁהָיָה לְמַטָּה עוֹלֶה.",
            definitionNative = "Положение меняется — кто был наверху, опустился, а кто был внизу — поднимается. Дословно: «колесо переворачивается».",
            example = "אַל תִּתְיָאֵשׁ — הַגַּלְגַּל מִתְהַפֵּךְ וְהַכֹּל יִשְׁתַּנֶּה.",
            exampleNative = "Не отчаивайся — הַגַּלְגַּל מִתְהַפֵּךְ, всё ещё изменится."
        ),
        WordEntity(
            id = 184820, setId = 1848, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l2_situations",
            original = "שָׁבוּר וְרָצוּץ", translation = "разбит и подавлен",
            transliteration = "шавур ве-рацуц",
            definition = "מַרְגִּישׁ עָיֵף לְגַמְרֵי וּמְדֻכָּא — בְּלִי כֹּחַ לְהַמְשִׁיךְ.",
            definitionNative = "Чувствует себя совершенно измотанным и подавленным — без сил продолжать. Дословно: «сломан и раздавлен».",
            example = "אַחֲרֵי הַטִּיּוּל הָאָרֹךְ הוּא חָזַר שָׁבוּר וְרָצוּץ.",
            exampleNative = "После долгого похода он вернулся שָׁבוּר וְרָצוּץ."
        , fillInBlankExclusions = listOf(184802L, 184816L, 184817L, 184818L, 184819L)),

        // ─── idioms_l2_attitudes (5) ─────────────────────────────────────
        WordEntity(
            id = 184821, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_attitudes",
            original = "לֹא מַזִּיק לוֹ", translation = "ему не повредит (ничего страшного)",
            transliteration = "ло мазик ло",
            definition = "מַשֶּׁהוּ קָשֶׁה אוֹ לֹא נָעִים שֶׁדַּוְקָא יְכוֹלָה לְהוֹעִיל לוֹ — חִנּוּכִית.",
            definitionNative = "Что-то тяжёлое или неприятное, что на самом деле может пойти ему на пользу — поучительно. Дословно: «не повредит ему».",
            example = "שֶׁיַּעֲבֹד קְצָת קָשֶׁה — לֹא מַזִּיק לוֹ לְהַרְגִּישׁ אֶת הַחַיִּים.",
            exampleNative = "Пусть поработает потяжелее — לֹא מַזִּיק לוֹ почувствовать жизнь."
        ),
        WordEntity(
            id = 184822, setId = 1848, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l2_attitudes",
            original = "לֹא אִכְפַּת לוֹ", translation = "ему всё равно (плевать)",
            transliteration = "ло ихпат ло",
            definition = "לֹא מְעַנְיֵן אוֹתוֹ — אֵין לוֹ עֶמְדָּה בְּעִנְיָן וְהוּא לֹא רוֹצֶה לְהִתְעַסֵּק.",
            definitionNative = "Ему неинтересно — у него нет позиции по вопросу и он не хочет с этим связываться. Дословно: «ему не важно».",
            example = "אָמַרְתִּי לוֹ אֲבָל לֹא אִכְפַּת לוֹ בִּכְלָל מָה שֶׁאֲנִי חוֹשֵׁב.",
            exampleNative = "Я ему сказал, но לֹא אִכְפַּת לוֹ совершенно, что я думаю."
        ),
        WordEntity(
            id = 184823, setId = 1848, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l2_attitudes",
            original = "מַכְנִיס לְעַצְמוֹ גּוֹל", translation = "забивает себе гол (делает себе хуже)",
            transliteration = "махнис ле-ацмо гол",
            definition = "פּוֹעֵל נֶגֶד הָאִינְטֵרֵסִים שֶׁל עַצְמוֹ — גּוֹרֵם לְעַצְמוֹ נֵזֶק בְּלִי כַּוָּנָה.",
            definitionNative = "Действует против собственных интересов — наносит себе вред без умысла. Дословно: «забивает себе гол».",
            example = "כְּשֶׁהוּא שִׁקֵּר לַבּוֹס הוּא מַכְנִיס לְעַצְמוֹ גּוֹל בָּרוּר.",
            exampleNative = "Соврав начальнику, он מַכְנִיס לְעַצְמוֹ גּוֹל — явно сам себе во вред."
        , fillInBlankExclusions = listOf(184821L, 184822L, 184824L, 184825L)),
        WordEntity(
            id = 184824, setId = 1848, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l2_attitudes",
            original = "בּוֹלֵעַ אֶת הַצְּפַרְדֵּעַ", translation = "глотает лягушку (смиряется с неприятным)",
            transliteration = "болеа эт hа-цфардеа",
            definition = "מְקַבֵּל מַשֶּׁהוּ קָשֶׁה וְלֹא נָעִים בְּשֶׁקֶט — בְּלִי בְּרֵרָה.",
            definitionNative = "Принимает что-то тяжёлое и неприятное молча — за неимением выбора. Дословно: «глотает лягушку».",
            example = "לִפְעָמִים בָּעֲבוֹדָה צָרִיךְ פָּשׁוּט בּוֹלֵעַ אֶת הַצְּפַרְדֵּעַ.",
            exampleNative = "Иногда на работе нужно просто בּוֹלֵעַ אֶת הַצְּפַרְדֵּעַ."
        ),
        WordEntity(
            id = 184825, setId = 1848, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l2_attitudes",
            original = "יוֹצֵא בְּשֵׁן וָעַיִן", translation = "выходит еле живым (едва уцелел)",
            transliteration = "йоце бэ-шен ва-аин",
            definition = "מַצְלִיחַ לִשְׂרֹד מַצָּב קָשֶׁה — אֲבָל בְּקֹשִׁי וְעִם נְזָקִים.",
            definitionNative = "Ему удаётся пережить тяжёлую ситуацию — но с трудом и потерями. Дословно: «выходит с зубом и глазом» (по-библейски).",
            example = "מִתְּאוּנַת הַדְּרָכִים הוּא יוֹצֵא בְּשֵׁן וָעַיִן — אֲבָל חַי.",
            exampleNative = "Из аварии он יוֹצֵא בְּשֵׁן וָעַיִן — но живой."
        , fillInBlankExclusions = listOf(184821L, 184822L, 184823L, 184824L)),
    )
}
