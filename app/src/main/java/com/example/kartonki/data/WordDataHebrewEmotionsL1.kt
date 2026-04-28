package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Эмоции и чувства", level 1 (A1-A2).
 * Один сет × 25 слов. setId = 1827.
 *
 *  - 18 COMMON + 7 UNCOMMON (2 смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      emotions_basic_feel       — базовые эмоции-существительные (5)
 *      emotions_basic_react      — мимика и физические реакции (5)
 *      emotions_basic_verbs      — глаголы чувств (5)
 *      emotions_basic_adj        — оценочные прилагательные состояния (5)
 *      emotions_basic_intensity  — интенсификаторы (5)
 *  - Базовая повседневная лексика про чувства на иврите.
 *    Никудим везде (стандарт he-ru).
 *  - Несколько фундаментальных оригиналов (שִׂמְחָה, עֶצֶב, כַּעַס,
 *    פַּחַד, אַהֲבָה, לִבְכּוֹת) пересекаются с set 1016 «Психология»
 *    и set 1200 «Лингвистика» — формально это другие темы, дубли в
 *    разных темах допустимы по политике
 *    (`docs/claude/feedback_duplicate_words_policy.md`). Без них
 *    L1 «Эмоции и чувства» неполноценен — это самые базовые слова
 *    A1-A2, которые обязаны быть в первом уровне темы.
 *  - Словарь сделан намеренно бытовым (не научно-психологическим),
 *    чтобы не пересекаться с темой «Психология» по смыслу.
 */
object WordDataHebrewEmotionsL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1827, languagePair = "he-ru", orderIndex = 1827,
            name = "Эмоции и чувства",
            description = "Базовые чувства, мимика и слова о настроении",
            topic = "Эмоции и чувства", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── emotions_basic_feel (5) ─────────────────────────────────────
        WordEntity(
            id = 182701, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "emotions_basic_feel",
            original = "שִׂמְחָה", translation = "радость",
            transliteration = "симха",
            definition = "תְּחוּשָׁה חַמָּה וּבְהִירָה כְּשֶׁמַשֶּׁהוּ טוֹב קוֹרֶה לָנוּ.",
            definitionNative = "Тёплое и светлое чувство, когда происходит что-то хорошее.",
            example = "הַשִּׂמְחָה שֶׁל הַיְלָדִים מִלְּאָה אֶת כָּל הַחֶדֶר.",
            exampleNative = "שִׂמְחָה детей наполнила всю комнату до краёв.",
        ),
        WordEntity(
            id = 182702, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "emotions_basic_feel",
            original = "עֶצֶב", translation = "грусть",
            transliteration = "эцев",
            definition = "תְּחוּשָׁה כְּבֵדָה בִּפְנִים כְּשֶׁמַשֶּׁהוּ עָצוּב קוֹרֶה אוֹ נִגְמַר.",
            definitionNative = "Тяжёлое чувство внутри, когда случается или заканчивается что-то печальное.",
            example = "הָעֶצֶב שֶׁלּוֹ הָיָה גָּדוֹל אַחֲרֵי הַפְּרֵדָה מֵהַחֲבֵרִים.",
            exampleNative = "עֶצֶב был большой после расставания со старыми друзьями.",
         fillInBlankExclusions = listOf(182701L, 182703L, 182704L, 182705L)),
        WordEntity(
            id = 182703, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "emotions_basic_feel",
            original = "כַּעַס", translation = "злость",
            transliteration = "каас",
            definition = "תְּחוּשָׁה חֲזָקָה כְּשֶׁמִּישֶׁהוּ עוֹשֶׂה לָנוּ מַשֶּׁהוּ לֹא הוֹגֵן.",
            definitionNative = "Сильное чувство, когда кто-то поступает с нами несправедливо.",
            example = "הַכַּעַס שֶׁלִּי עָבַר אַחֲרֵי שִׂיחָה אֲרֻכָּה עִם אַבָּא.",
            exampleNative = "כַּעַס у меня прошёл после долгого разговора с папой.",
         fillInBlankExclusions = listOf(182701L, 182702L, 182704L, 182705L)),
        WordEntity(
            id = 182704, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "emotions_basic_feel",
            original = "פַּחַד", translation = "страх",
            transliteration = "пахад",
            definition = "תְּחוּשָׁה לֹא נְעִימָה כְּשֶׁאָנוּ חוֹשְׁבִים שֶׁמַּשֶּׁהוּ רַע יִקְרֶה.",
            definitionNative = "Неприятное чувство, когда мы думаем, что случится что-то плохое.",
            example = "הַפַּחַד מִכְּלָבִים גְּדוֹלִים נִשְׁאַר אִתִּי מֵאָז יַלְדוּת.",
            exampleNative = "פַּחַד перед большими собаками остался со мной с самого детства.",
         fillInBlankExclusions = listOf(182701L, 182702L, 182703L, 182705L)),
        WordEntity(
            id = 182705, setId = 1827, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emotions_basic_feel",
            original = "אַהֲבָה", translation = "любовь",
            transliteration = "ахава",
            definition = "תְּחוּשָׁה חַמָּה וַעֲמֻקָּה כְּלַפֵּי בֶּן מִשְׁפָּחָה אוֹ חָבֵר קָרוֹב.",
            definitionNative = "Тёплое и глубокое чувство к близкому человеку или родному.",
            example = "הָאַהֲבָה בֵּין סָבְתָא לְנֶכְדָה נִרְאֲתָה בְּכָל מַבָּט.",
            exampleNative = "אַהֲבָה между бабушкой и внучкой была видна в каждом взгляде.",
         fillInBlankExclusions = listOf(182701L, 182702L, 182703L, 182704L)),

        // ─── emotions_basic_react (5) ────────────────────────────────────
        WordEntity(
            id = 182706, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "emotions_basic_react",
            original = "לִבְכּוֹת", translation = "плакать",
            transliteration = "ливкот",
            definition = "לְהוֹרִיד דְּמָעוֹת מֵהָעֵינַיִים כְּשֶׁעָצוּב אוֹ כּוֹאֵב מְאוֹד.",
            definitionNative = "Ронять слёзы из глаз, когда грустно или очень больно.",
            example = "הַיֶּלֶד הִתְחִיל לִבְכּוֹת כְּשֶׁאִבֵּד אֶת הַבַּלּוֹן בָּרוּחַ.",
            exampleNative = "Малыш стал לִבְכּוֹת, когда упустил воздушный шарик на ветру.",
         fillInBlankExclusions = listOf(182707L, 182708L, 182709L, 182710L, 182713L)),
        WordEntity(
            id = 182707, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "emotions_basic_react",
            original = "לִצְחוֹק", translation = "смеяться",
            transliteration = "лицхок",
            definition = "לְהוֹצִיא קוֹלוֹת שְׂמֵחִים מֵהַפֶּה כְּשֶׁמַשֶּׁהוּ מַצְחִיק אוֹתָנוּ.",
            definitionNative = "Издавать весёлые звуки голосом, когда что-то нас смешит.",
            example = "כֻּלָּם הִתְחִילוּ לִצְחוֹק מֵהַבְּדִיחָה שֶׁל הַסַּבָּא.",
            exampleNative = "Все начали לִצְחוֹק над дедушкиной шуткой за столом.",
         fillInBlankExclusions = listOf(182706L, 182708L, 182709L, 182710L)),
        WordEntity(
            id = 182708, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "emotions_basic_react",
            original = "לְחַיֵּךְ", translation = "улыбаться",
            transliteration = "лехайех",
            definition = "לְהָרִים אֶת זָוִיּוֹת הַפֶּה לְהַרְאוֹת שֶׁטּוֹב לָנוּ אוֹ נָעִים.",
            definitionNative = "Поднять уголки рта, чтобы показать, что нам хорошо или приятно.",
            example = "הִיא הִתְחִילָה לְחַיֵּךְ כְּשֶׁרָאֲתָה אֶת הַחָתוּל הַקָּטָן.",
            exampleNative = "Она стала לְחַיֵּךְ, когда увидела маленького котёнка у двери.",
        ),
        WordEntity(
            id = 182709, setId = 1827, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "emotions_basic_react",
            original = "לִרְעֹד", translation = "дрожать",
            transliteration = "лиръод",
            definition = "לָזוּז קְצָת בְּלִי שְׁלִיטָה מֵרֹב פַּחַד, קֹר אוֹ הִתְרַגְּשׁוּת.",
            definitionNative = "Слегка трястись помимо воли — от страха, холода или волнения.",
            example = "הַיָּדַיִם שֶׁלָּהּ הִתְחִילוּ לִרְעֹד לִפְנֵי הַמִּבְחָן.",
            exampleNative = "Её ладони стали לִרְעֹד прямо перед самым экзаменом.",
         fillInBlankExclusions = listOf(182706L, 182707L, 182708L, 182710L)),
        WordEntity(
            id = 182710, setId = 1827, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "emotions_basic_react",
            original = "לְהַסְמִיק", translation = "краснеть (от смущения)",
            transliteration = "леhасмик",
            definition = "לְקַבֵּל פָּנִים אֲדֻמּוֹת מֵרֹב מְבוּכָה אוֹ הִתְרַגְּשׁוּת פִּתְאוֹמִית.",
            definitionNative = "Стать с красным лицом от смущения или внезапного волнения.",
            example = "הוּא הִתְחִיל לְהַסְמִיק כְּשֶׁכֻּלָּם הִסְתַּכְּלוּ עָלָיו.",
            exampleNative = "Он стал לְהַסְמִיק, когда все вдруг повернулись и посмотрели на него.",
         fillInBlankExclusions = listOf(182706L, 182707L, 182708L, 182709L, 182713L)),

        // ─── emotions_basic_verbs (5) ────────────────────────────────────
        WordEntity(
            id = 182711, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "emotions_basic_verbs",
            original = "לֶאֱהֹב", translation = "любить",
            transliteration = "леэhов",
            definition = "לְהַרְגִּישׁ חִבָּה חֲזָקָה לְמִישֶׁהוּ אוֹ לְמַשֶּׁהוּ קָרוֹב לַלֵּב.",
            definitionNative = "Чувствовать сильную привязанность к близкому человеку или к чему-то дорогому.",
            example = "אֲנִי מַמָּשׁ אוֹהֵב לֶאֱהֹב אֶת הַמִּשְׁפָּחָה שֶׁלִּי בְּכָל יוֹם.",
            exampleNative = "Я по-настоящему умею לֶאֱהֹב свою семью каждый божий день.",
         fillInBlankExclusions = listOf(182708L, 182712L, 182713L, 182714L, 182715L)),
        WordEntity(
            id = 182712, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "emotions_basic_verbs",
            original = "לִשְׂנוֹא", translation = "ненавидеть",
            transliteration = "лисно",
            definition = "לְהַרְגִּישׁ שִׂנְאָה חֲזָקָה לְמִישֶׁהוּ אוֹ לְמַשֶּׁהוּ לֹא נָעִים.",
            definitionNative = "Испытывать сильную неприязнь к кому-то или к чему-то очень неприятному.",
            example = "אֲנִי לִשְׂנוֹא לְחַכּוֹת בְּתוֹר אָרֹךְ בָּרוֹפֵא.",
            exampleNative = "Я могу לִשְׂנוֹא долгое ожидание в очереди у врача.",
         fillInBlankExclusions = listOf(182711L, 182713L, 182714L, 182715L)),
        WordEntity(
            id = 182713, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "emotions_basic_verbs",
            original = "לְפַחֵד", translation = "бояться",
            transliteration = "лефахэд",
            definition = "לְהַרְגִּישׁ פַּחַד מִפְּנֵי דָּבָר שֶׁעָלוּל לִקְרוֹת אוֹ לְהַזִּיק.",
            definitionNative = "Испытывать страх перед чем-то, что может случиться или навредить.",
            example = "הִיא הִתְחִילָה לְפַחֵד מֵחֹשֶׁךְ אַחֲרֵי הַסֶּרֶט.",
            exampleNative = "Она стала לְפַחֵד темноты сразу после того страшного фильма.",
         fillInBlankExclusions = listOf(182706L, 182709L, 182711L, 182712L, 182714L, 182715L)),
        WordEntity(
            id = 182714, setId = 1827, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "emotions_basic_verbs",
            original = "לְקַוּוֹת", translation = "надеяться",
            transliteration = "лекавот",
            definition = "לְחַכּוֹת בִּפְנִים שֶׁמַשֶּׁהוּ טוֹב בֶּאֱמֶת יִקְרֶה בְּקָרוֹב.",
            definitionNative = "Ждать в душе, что что-то по-настоящему хорошее скоро произойдёт.",
            example = "אֲנַחְנוּ מַמְשִׁיכִים לְקַוּוֹת שֶׁהַמִּכְתָּב יַגִּיעַ הַשָּׁבוּעַ.",
            exampleNative = "Мы продолжаем לְקַוּוֹת, что письмо придёт уже на этой неделе.",
         fillInBlankExclusions = listOf(182711L, 182712L, 182713L, 182715L)),
        WordEntity(
            id = 182715, setId = 1827, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "emotions_basic_verbs",
            original = "לְהִתְגַּעְגֵּעַ", translation = "скучать (по кому-то)",
            transliteration = "леhитгаагэа",
            definition = "לְהַרְגִּישׁ חֶסְרוֹן שֶׁל אָדָם אוֹ מָקוֹם שֶׁאֵינָם אִתָּנוּ עַכְשָׁו.",
            definitionNative = "Чувствовать нехватку человека или места, которых сейчас рядом нет.",
            example = "הִתְחַלְתִּי לְהִתְגַּעְגֵּעַ לַסַּבְתָּא כְּבָר בַּיּוֹם הָרִאשׁוֹן.",
            exampleNative = "Я стал לְהִתְגַּעְגֵּעַ к бабушке уже в первый день вдали от дома.",
        ),

        // ─── emotions_basic_adj (5) ──────────────────────────────────────
        WordEntity(
            id = 182716, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "emotions_basic_adj",
            original = "שָׂמֵחַ", translation = "счастливый / радостный",
            transliteration = "самэах",
            definition = "מִי שֶׁמַּרְגִּישׁ שִׂמְחָה — מְחַיֵּךְ הַרְבֵּה וּמְדַבֵּר בְּעַלִּיזוּת.",
            definitionNative = "Тот, кто чувствует радость — много улыбается и говорит весело.",
            example = "הַסַּבָּא הָיָה שָׂמֵחַ בְּכָל חַג שֶׁהַנְּכָדִים בָּאוּ.",
            exampleNative = "Дедушка был שָׂמֵחַ каждый раз, когда внуки приезжали на праздник.",
        ),
        WordEntity(
            id = 182717, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "emotions_basic_adj",
            original = "עָצוּב", translation = "грустный",
            transliteration = "ацув",
            definition = "מִי שֶׁמַּרְגִּישׁ עֶצֶב — בּוֹכֶה בְּשֶׁקֶט אוֹ מְדַבֵּר בְּקוֹל נָמוּךְ.",
            definitionNative = "Тот, кто чувствует грусть — тихо плачет или говорит совсем негромко.",
            example = "הוּא נִרְאָה עָצוּב כָּל הַשָּׁבוּעַ אַחֲרֵי שֶׁהֶחָתוּל בָּרַח.",
            exampleNative = "Он выглядел עָצוּב всю неделю после того, как кот пропал из дома.",
         fillInBlankExclusions = listOf(182716L, 182718L, 182719L, 182720L)),
        WordEntity(
            id = 182718, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "emotions_basic_adj",
            original = "כּוֹעֵס", translation = "сердитый",
            transliteration = "коэс",
            definition = "מִי שֶׁמַּרְגִּישׁ כַּעַס — מְדַבֵּר חָזָק וּפָנָיו אֲדֻמּוֹת.",
            definitionNative = "Тот, кто чувствует злость — говорит громко, лицо у него красное.",
            example = "אַבָּא הָיָה כּוֹעֵס כְּשֶׁהוּא רָאָה אֶת הַחֶדֶר שֶׁלִּי.",
            exampleNative = "Папа был כּוֹעֵס, когда зашёл и увидел мою комнату вверх дном.",
         fillInBlankExclusions = listOf(182716L, 182717L, 182719L, 182720L)),
        WordEntity(
            id = 182719, setId = 1827, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "emotions_basic_adj",
            original = "מְפֻחָד", translation = "испуганный",
            transliteration = "мефухад",
            definition = "מִי שֶׁמַּרְגִּישׁ פַּחַד חָזָק — רוֹעֵד וְלֹא יוֹדֵעַ מַה לַעֲשׂוֹת.",
            definitionNative = "Тот, кто чувствует сильный страх — дрожит и не знает, что делать.",
            example = "הַכֶּלֶב הִתְחַבֵּא מְפֻחָד מִתַּחַת לַסַּפָּה בִּזְמַן הָרַעַם.",
            exampleNative = "Пёсик прятался מְפֻחָד под диваном всё то время, пока гремел гром.",
         fillInBlankExclusions = listOf(182716L, 182717L, 182718L, 182720L)),
        WordEntity(
            id = 182720, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "emotions_basic_adj",
            original = "רָגוּעַ", translation = "спокойный",
            transliteration = "рагуа",
            definition = "מִי שֶׁאֵין לוֹ דְּאָגוֹת — נוֹשֵׁם לְאַט וּמְדַבֵּר בְּשֶׁקֶט.",
            definitionNative = "Тот, у кого нет тревог — медленно дышит и спокойно говорит.",
            example = "הוּא נִשְׁאָר רָגוּעַ אֲפִלּוּ בִּזְמַן הַסַּעֲרָה הַחֲזָקָה.",
            exampleNative = "Он оставался רָגוּעַ даже во время самой сильной бури за окном.",
        ),

        // ─── emotions_basic_intensity (5) ────────────────────────────────
        WordEntity(
            id = 182721, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "adverb", semanticGroup = "emotions_basic_intensity",
            original = "מְאוֹד", translation = "очень",
            transliteration = "меод",
            definition = "מִלָּה שֶׁמַּגְדִּילָה אֶת הַתֵּאוּר — כְּמוֹ שָׂמֵחַ אוֹ עָיֵף הַרְבֵּה.",
            definitionNative = "Слово, что усиливает описание — например, «очень рад» или «очень устал».",
            example = "הָיִיתִי מְאוֹד שָׂמֵחַ לִפְגֹּשׁ אוֹתָךְ אֶתְמוֹל בָּעֶרֶב.",
            exampleNative = "Я был מְאוֹד рад встретить тебя вчера вечером в парке.",
         fillInBlankExclusions = listOf(182722L, 182723L, 182724L, 182725L)),
        WordEntity(
            id = 182722, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "adverb", semanticGroup = "emotions_basic_intensity",
            original = "קְצָת", translation = "немного",
            transliteration = "кцат",
            definition = "מִלָּה שֶׁמַּקְטִינָה אֶת הַתֵּאוּר — לֹא הַרְבֵּה, רַק חֵלֶק קָטָן.",
            definitionNative = "Слово, что ослабляет описание — не сильно, лишь чуть-чуть.",
            example = "אֲנִי קְצָת עָצוּב הַיּוֹם אֲבָל זֶה יַעֲבֹר.",
            exampleNative = "Мне сегодня קְצָת грустно, но это обязательно пройдёт.",
         fillInBlankExclusions = listOf(182721L, 182723L, 182724L, 182725L)),
        WordEntity(
            id = 182723, setId = 1827, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "emotions_basic_intensity",
            original = "נוֹרָא", translation = "ужасно",
            transliteration = "нора",
            definition = "מִלָּה שֶׁמַּגְדִּילָה תֵּאוּר שְׁלִילִי — בְּעֹצֶם רַע אוֹ כָּבֵד מְאוֹד.",
            definitionNative = "Слово, усиливающее негативное описание — действительно плохо или очень тяжело.",
            example = "הָיָה לִי נוֹרָא קַר בָּרְחוֹב בְּלִי הַמְּעִיל.",
            exampleNative = "Мне было נוֹרָא холодно на улице без тёплой куртки.",
         fillInBlankExclusions = listOf(182721L, 182722L, 182724L, 182725L)),
        WordEntity(
            id = 182724, setId = 1827, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "emotions_basic_intensity",
            original = "מַמָּשׁ", translation = "по-настоящему / прямо",
            transliteration = "мамаш",
            definition = "מִלָּה שֶׁמַּדְגִּישָׁה — בֶּאֱמֶת, בְּלִי הַגְזָמָה וּבְלִי הִתְחַכְּמוּת.",
            definitionNative = "Слово-усилитель — по-честному, без преувеличения и без шуток.",
            example = "הַסֵּפֶר הַזֶּה מַמָּשׁ הִרְגִּישׁ אוֹתִי טוֹב יוֹתֵר.",
            exampleNative = "Эта книга מַמָּשׁ помогла мне почувствовать себя гораздо лучше.",
        ),
        WordEntity(
            id = 182725, setId = 1827, languagePair = "he-ru", rarity = "COMMON",
            pos = "adverb", semanticGroup = "emotions_basic_intensity",
            original = "בִּכְלָל לֹא", translation = "совсем не",
            transliteration = "бихлаль ло",
            definition = "צֵרוּף שֶׁשּׁוֹלֵל לְגַמְרֵי — אֲפִלּוּ לֹא חֵלֶק קָטָן וְלֹא לְרֶגַע.",
            definitionNative = "Сочетание, что отрицает полностью — ни капельки и ни на минуту.",
            example = "אֲנִי בִּכְלָל לֹא כּוֹעֵס עָלֶיךָ עַל הָאִחוּר.",
            exampleNative = "Я בִּכְלָל לֹא злюсь на тебя из-за этого опоздания.",
         fillInBlankExclusions = listOf(182721L, 182722L, 182723L, 182724L)),
    )
}
