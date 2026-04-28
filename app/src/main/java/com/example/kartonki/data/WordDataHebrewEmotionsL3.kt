package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Эмоции и чувства", level 3 (B2-C1).
 * Один сет × 25 слов. setId = 1829.
 *
 *  - 18 RARE + 7 EPIC (два смежных уровня B2 + C1).
 *  - 5 семантических групп по 5 слов:
 *      emotions_l3_subtle        — тонкие эмоции (тоска, презрение, восторг, отвращение, смятение)
 *      emotions_l3_psychology    — психологические термины (сопереживание, бесчувственность, эйфория, тревожность, подавленность)
 *      emotions_l3_verbs_subtle  — продвинутые глаголы (терзаться, сострадать, негодовать, восхищаться, унывать)
 *      emotions_l3_descriptive   — продвинутые описания (восторженный, угрюмый, замкнутый, пылкий, ранимый)
 *      emotions_l3_relations     — отношенческие чувства (привязанность, симпатия, неприязнь, восхищение, зависть)
 *  - Углублённая лексика по теме «Эмоции и чувства» на иврите —
 *    тонкие/литературные/психологические эмоции уровня B2-C1.
 *    Никудим везде (стандарт he-ru).
 *  - Все 25 слов проверены grep'ом по `original = "..."` против всех
 *    WordDataHebrew*.kt файлов и не пересекаются с set 1827 (L1) и
 *    тематически близкими наборами (1016 «Психология», 1141 «Внешность
 *    и тело»). Замены из-за дублей и L2-границы:
 *      • вместо אֶמְפַּתְיָה ("эмпатия") — הִזְדַּהוּת, потому что
 *        אֶמְפַּתְיָה занята в Batch40 и Batch71 в значении эмпатии.
 *      • вместо דִּכָּאוֹן ("депрессия") — דַּכְדּוּךְ ("подавленность"),
 *        потому что דִּכָּאוֹן занят в Batch71 (тема «Психология»).
 *      • вместо חֲרָדָה / חַרְדָּה ("тревога") — חַרְדָּתִיּוּת
 *        ("тревожность" как черта/состояние), потому что обе формы
 *        занятых в set 1016 и Batch71 + Batch39 в значении «тревога».
 *      • вместо מְבוּכָה ("замешательство") — מָבוֹךְ ("смятение"),
 *        потому что מְבוּכָה занята в set 1016.
 *      • вместо קִנְאָה ("зависть/ревность") — צָרוּת עַיִן ("зависть",
 *        литературное), чтобы не пересекаться с L2 (повседневная
 *        ревность ожидается там).
 *      • вместо לוֹהֵט ("пылкий") — חָמוּם, потому что לוֹהֵט занят в
 *        WordDataHebrewWeatherL2 в значении «палящий».
 *      • вместо אָבֵל ("скорбящий") — мы вообще ушли от темы траура,
 *        т.к. она пересекается с Batch50 и достойна отдельного сета.
 *  - fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь;
 *    FILL_IN_BLANK pipeline инжектит их централизованно после wave.
 */
object WordDataHebrewEmotionsL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1829, languagePair = "he-ru", orderIndex = 1829,
            name = "Эмоции и чувства",
            description = "Тонкие переживания, психологические термины и оттенки чувств",
            topic = "Эмоции и чувства", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── emotions_l3_subtle (5) ──────────────────────────────────────
        WordEntity(
            id = 182901, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l3_subtle",
            original = "תּוּגָה", translation = "тоска",
            transliteration = "туга",
            definition = "תְּחוּשַׁת עֶצֶב שְׁקֵטָה וַעֲמֻקָּה שֶׁנִּשְׁאֶרֶת בַּלֵּב לְאֹרֶךְ זְמַן.",
            definitionNative = "Тихое и глубокое чувство печали, что задерживается в сердце надолго.",
            example = "תּוּגָה דַּקָּה לִוְּתָה אוֹתָהּ בְּכָל הַצְּעָדָה לְיַד הַיָּם.",
            exampleNative = "Тонкая תּוּגָה сопровождала её всю прогулку у моря.",
         fillInBlankExclusions = listOf(182902L, 182903L, 182904L, 182905L, 182906L, 182909L, 182921L, 182922L, 182923L, 182924L)),
        WordEntity(
            id = 182902, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l3_subtle",
            original = "בּוּז", translation = "презрение",
            transliteration = "буз",
            definition = "יַחַס שֶׁל זִלְזוּל עָמֹק לְמִישֶׁהוּ שֶׁנִּתְפָּס כְּנָחוּת אוֹ פָּגוּם.",
            definitionNative = "Глубокое пренебрежительное отношение к тому, кого считают низким или испорченным.",
            example = "הוּא לֹא הִסְתִּיר אֶת הַבּוּז שֶׁלּוֹ כְּלַפֵּי הַשַּׁקְרָנִים.",
            exampleNative = "Он не скрывал своего בּוּז по отношению к лжецам.",
         fillInBlankExclusions = listOf(182901L, 182903L, 182904L, 182905L, 182906L, 182907L, 182921L, 182922L, 182923L, 182924L)),
        WordEntity(
            id = 182903, setId = 1829, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l3_subtle",
            original = "הִתְפַּעֲלוּת", translation = "восторг",
            transliteration = "hитпаалут",
            definition = "תְּחוּשָׁה חֲזָקָה שֶׁל הִתְלַהֲבוּת מוּל מַשֶּׁהוּ יָפֶה אוֹ מַרְשִׁים בִּמְיֻחָד.",
            definitionNative = "Сильное чувство воодушевления перед чем-то особенно красивым или впечатляющим.",
            example = "הַהִתְפַּעֲלוּת שֶׁלָּהּ מֵהַשְּׁקִיעָה הָיְתָה כֵּנָה וְיַלְדוּתִית.",
            exampleNative = "Её הִתְפַּעֲלוּת от заката была искренней и почти детской.",
         fillInBlankExclusions = listOf(182901L, 182902L, 182904L, 182905L, 182908L)),
        WordEntity(
            id = 182904, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l3_subtle",
            original = "סְלִידָה", translation = "отвращение",
            transliteration = "слида",
            definition = "תְּחוּשָׁה חֲזָקָה שֶׁל דְּחִיָּה — הָרָצוֹן לְהִתְרַחֵק מִדָּבָר דּוֹחֶה.",
            definitionNative = "Сильное чувство отторжения — желание отдалиться от чего-то противного.",
            example = "סְלִידָה עֲמֻקָּה עָלְתָה בּוֹ לְמַרְאֵה הַשֶּׁקֶר הַבּוֹטֶה.",
            exampleNative = "Глубокая סְלִידָה поднялась в нём при виде наглой лжи.",
         fillInBlankExclusions = listOf(182901L, 182902L, 182903L, 182905L, 182909L, 182923L)),
        WordEntity(
            id = 182905, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l3_subtle",
            original = "מָבוֹךְ", translation = "смятение",
            transliteration = "мавох",
            definition = "מַצָּב נַפְשִׁי שֶׁל בִּלְבּוּל וְחֹסֶר וַדָּאוּת בֵּין רְגָשׁוֹת מְנֻגָּדִים.",
            definitionNative = "Душевное состояние замешательства и неопределённости между противоречивыми чувствами.",
            example = "אַחֲרֵי הַשִּׂיחָה הוּא נִשְׁאַר בְּמָבוֹךְ פְּנִימִי שָׁעוֹת אֲרֻכּוֹת.",
            exampleNative = "После разговора он часами оставался во внутреннем מָבוֹךְ.",
        ),

        // ─── emotions_l3_psychology (5) ──────────────────────────────────
        WordEntity(
            id = 182906, setId = 1829, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l3_psychology",
            original = "הִזְדַּהוּת", translation = "сопереживание / эмпатия",
            transliteration = "hиздаhут",
            definition = "הַיְכֹלֶת לְהַרְגִּישׁ אֶת הָרְגָשׁוֹת שֶׁל הָאַחֵר כְּאִלּוּ הֵם שֶׁלָּנוּ.",
            definitionNative = "Способность чувствовать эмоции другого человека так, словно они наши собственные.",
            example = "הַהִזְדַּהוּת שֶׁל הַמְּטַפֶּלֶת עִם הַמְּטֻפָּלִים הָיְתָה הַסּוֹד שֶׁל עֲבוֹדָתָהּ.",
            exampleNative = "הִזְדַּהוּת психотерапевта со своими пациентами — секрет её работы.",
         fillInBlankExclusions = listOf(182907L, 182908L, 182909L, 182910L)),
        WordEntity(
            id = 182907, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l3_psychology",
            original = "אַטִימוּת", translation = "бесчувственность, эмоциональная нечуткость",
            transliteration = "атимут",
            definition = "מַצָּב שֶׁבּוֹ אָדָם אֵינוֹ מַגִּיב לִכְאֵב אוֹ לְרִגְשׁוֹת שֶׁל הַזּוּלַת וְנִשְׁאָר קַר וְסָגוּר.",
            definitionNative = "Состояние, при котором человек не откликается на чужую боль или чувства и остаётся холодным и закрытым.",
            example = "הָאַטִימוּת שֶׁלּוֹ כְּלַפֵּי סִבְלָם שֶׁל אֲחֵרִים הִדְהִימָה אֶת כָּל הַצֶּוֶת.",
            exampleNative = "Его אַטִימוּת к страданиям окружающих поразила всю команду.",
         fillInBlankExclusions = listOf(182901L, 182903L, 182904L, 182906L, 182908L, 182909L, 182910L, 182922L, 182923L, 182924L)),
        WordEntity(
            id = 182908, setId = 1829, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l3_psychology",
            original = "אֵיפוֹרְיָה", translation = "эйфория",
            transliteration = "эйфорья",
            definition = "מַצָּב שֶׁל שִׂמְחָה קִיצוֹנִית וְהִתְרוֹמְמוּת רוּחַ שֶׁאֵינָהּ תָּמִיד מִתְאִימָה לַמַּצָּב.",
            definitionNative = "Состояние крайней радости и подъёма духа, не всегда соответствующее реальности.",
            example = "הוּא חַי בְּאֵיפוֹרְיָה שָׁבוּעַ שָׁלֵם אַחֲרֵי הַזְּכִיָּה הַגְּדוֹלָה.",
            exampleNative = "Он жил в אֵיפוֹרְיָה целую неделю после большого выигрыша.",
         fillInBlankExclusions = listOf(182901L, 182903L, 182905L, 182906L, 182907L, 182909L, 182910L)),
        WordEntity(
            id = 182909, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l3_psychology",
            original = "חַרְדָּתִיּוּת", translation = "тревожность",
            transliteration = "хардатиют",
            definition = "נְטִיָּה קְבוּעָה לְהַרְגִּישׁ חֲשָׁשׁוֹת וּדְאָגוֹת בְּלִי סִבָּה בָּרוּרָה.",
            definitionNative = "Постоянная склонность испытывать опасения и беспокойство без явной причины.",
            example = "הַחַרְדָּתִיּוּת שֶׁלּוֹ הִקְשְׁתָה עָלָיו לִישֹׁן בַּלֵּילוֹת.",
            exampleNative = "Его חַרְדָּתִיּוּת мешала ему спать по ночам.",
         fillInBlankExclusions = listOf(182901L, 182903L, 182906L, 182907L, 182908L, 182910L, 182921L, 182923L)),
        WordEntity(
            id = 182910, setId = 1829, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l3_psychology",
            original = "דַּכְדּוּךְ", translation = "подавленность",
            transliteration = "дахдух",
            definition = "מַצַּב רוּחַ נָמוּךְ שֶׁמִּתְאַפְיֵן בַּעֲצַבּוּת וַחֻסֶר אֵנֶרְגִיָּה.",
            definitionNative = "Сниженное настроение, что отличается грустью и нехваткой энергии.",
            example = "דַּכְדּוּךְ סְתָוִי תָּפַס אוֹתוֹ עִם הַגְּשָׁמִים הָרִאשׁוֹנִים.",
            exampleNative = "Осенний דַּכְדּוּךְ накрыл его с первыми дождями.",
        ),

        // ─── emotions_l3_verbs_subtle (5) ────────────────────────────────
        WordEntity(
            id = 182911, setId = 1829, languagePair = "he-ru", rarity = "EPIC",
            pos = "verb", semanticGroup = "emotions_l3_verbs_subtle",
            original = "לְהִתְעַנּוֹת", translation = "терзаться / мучиться",
            transliteration = "леhитъанот",
            definition = "לִסְבֹּל סֵבֶל פְּנִימִי מִתְמַשֵּׁךְ בִּגְלַל מַחֲשָׁבוֹת אוֹ רְגָשׁוֹת קָשִׁים.",
            definitionNative = "Терпеть длительные внутренние страдания из-за тяжёлых мыслей или чувств.",
            example = "הוּא הִמְשִׁיךְ לְהִתְעַנּוֹת בִּגְלַל הַהַחְלָטָה שֶׁקִּבֵּל בַּצָּעִיר.",
            exampleNative = "Он продолжал לְהִתְעַנּוֹת из-за решения, что принял в молодости.",
         fillInBlankExclusions = listOf(182912L, 182913L, 182914L, 182915L)),
        WordEntity(
            id = 182912, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "emotions_l3_verbs_subtle",
            original = "לְהִשְׁתַּתֵּף בַּצַּעַר", translation = "сострадать / соболезновать",
            transliteration = "леhиштатэф ба-цаар",
            definition = "לְבַטֵּא הִזְדַּהוּת עִם הַכְּאֵב שֶׁל אַחֵר וּלְחַלֵּק אִתּוֹ אֶת מַעֲמָסַת הָעֵצֶב.",
            definitionNative = "Выражать сопереживание чужой боли и разделять с человеком тяжесть печали.",
            example = "כָּל הַשְּׁכוּנָה בָּאָה לְהִשְׁתַּתֵּף בַּצַּעַר שֶׁל הַמִּשְׁפָּחָה הָאֲבֵלָה.",
            exampleNative = "Весь район пришёл לְהִשְׁתַּתֵּף בַּצַּעַר семьи в трауре.",
         fillInBlankExclusions = listOf(182911L, 182913L, 182914L, 182915L)),
        WordEntity(
            id = 182913, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "emotions_l3_verbs_subtle",
            original = "לְזַעֵם", translation = "негодовать / гневаться",
            transliteration = "лезаэм",
            definition = "לְהַרְגִּישׁ כַּעַס חָזָק וּמַר עַל מַעֲשֶׂה לֹא הוֹגֵן אוֹ עַוְלָה.",
            definitionNative = "Испытывать сильный и горький гнев на несправедливый поступок или обиду.",
            example = "הָעִתּוֹנוּת הִמְשִׁיכָה לְזַעֵם עַל הַשְׁחִיתוּת בַּמֶּמְשָׁלָה.",
            exampleNative = "Пресса продолжала לְזַעֵם против коррупции в правительстве.",
         fillInBlankExclusions = listOf(182911L, 182912L, 182914L, 182915L)),
        WordEntity(
            id = 182914, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "emotions_l3_verbs_subtle",
            original = "לְהַעֲרִיץ", translation = "восхищаться / преклоняться",
            transliteration = "леhаариц",
            definition = "לְכַבֵּד מִישֶׁהוּ עַד מְאוֹד וּלְהִתְרַשֵּׁם מִתְּכוּנוֹתָיו אוֹ הִשְׂגֵּיו.",
            definitionNative = "Очень сильно уважать кого-то и впечатляться его качествами или достижениями.",
            example = "הוּא נָהַג לְהַעֲרִיץ אֶת הַמּוֹרֶה לְסִפְרוּת מֵיְמֵי הַתִּיכוֹן.",
            exampleNative = "Он привык לְהַעֲרִיץ учителя литературы ещё со школьных лет.",
         fillInBlankExclusions = listOf(182911L, 182912L, 182913L, 182915L)),
        WordEntity(
            id = 182915, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "emotions_l3_verbs_subtle",
            original = "לְהִתְיָאֵשׁ", translation = "отчаиваться / унывать",
            transliteration = "леhитъяэш",
            definition = "לְאַבֵּד תִּקְוָה וְלְהַפְסִיק לְהַאֲמִין שֶׁמַּשֶּׁהוּ טוֹב יִקְרֶה.",
            definitionNative = "Терять надежду и переставать верить, что случится что-то хорошее.",
            example = "אַל תִּתְיָאֵשׁ — עֲדַיִן יֵשׁ סִכּוּי לְשַׁפֵּר אֶת הַמַּצָּב.",
            exampleNative = "Не спеши לְהִתְיָאֵשׁ — ещё есть шанс улучшить положение.",
        ),

        // ─── emotions_l3_descriptive (5) ─────────────────────────────────
        WordEntity(
            id = 182916, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "emotions_l3_descriptive",
            original = "נִלְהָב", translation = "восторженный / увлечённый",
            transliteration = "нилhав",
            definition = "מִי שֶׁמַּרְגִּישׁ הִתְלַהֲבוּת חֲזָקָה וּמְעוֹרָב כֻּלּוֹ בְּמַשֶּׁהוּ שֶׁהוּא אוֹהֵב.",
            definitionNative = "Тот, кто чувствует сильное воодушевление и весь поглощён тем, что любит.",
            example = "הוּא חָזַר נִלְהָב מֵהַקּוֹנְצֶרְט וְלֹא הִפְסִיק לְדַבֵּר עָלָיו.",
            exampleNative = "Он вернулся с концерта נִלְהָב и не переставал говорить о нём.",
         fillInBlankExclusions = listOf(182917L, 182918L, 182919L, 182920L)),
        WordEntity(
            id = 182917, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "emotions_l3_descriptive",
            original = "זָעוּף", translation = "угрюмый / хмурый",
            transliteration = "заъуф",
            definition = "מִי שֶׁפָּנָיו קוֹדְרוֹת וּמַרְאֶה תָּמִיד מַצַּב רוּחַ קַשֶּׁה וְלֹא נָעִים.",
            definitionNative = "Тот, у кого мрачное лицо и постоянно тяжёлое, неприветливое настроение.",
            example = "הַשְּׁכֵן הַזָּעוּף לֹא הֵשִׁיב אַף פַּעַם לִשְׁלוֹם.",
            exampleNative = "זָעוּף сосед никогда не отвечал на приветствие.",
        ),
        WordEntity(
            id = 182918, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "emotions_l3_descriptive",
            original = "מָסוּגָר", translation = "замкнутый",
            transliteration = "масугар",
            definition = "מִי שֶׁשּׁוֹמֵר אֶת רְגָשׁוֹתָיו בִּפְנִים וְלֹא מְשַׁתֵּף אֲחֵרִים בָּהֶם.",
            definitionNative = "Тот, кто хранит свои чувства внутри и не делится ими с окружающими.",
            example = "מֵאָז הַמַּשְׁבֵּר הוּא הָפַךְ לְמָסוּגָר וְשָׁקֵט מְאוֹד.",
            exampleNative = "После кризиса он стал מָסוּגָר и очень молчаливым.",
         fillInBlankExclusions = listOf(182916L, 182917L, 182919L, 182920L)),
        WordEntity(
            id = 182919, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "emotions_l3_descriptive",
            original = "חָמוּם", translation = "пылкий / страстный",
            transliteration = "хамум",
            definition = "מִי שֶׁמַּגִּיב בִּרְגָשׁוֹת חֲזָקִים וּבְלַהַט, לִפְעָמִים יוֹתֵר מִדַּי.",
            definitionNative = "Тот, кто реагирует сильными эмоциями и страстью, иногда даже чрезмерно.",
            example = "הוּא נוֹאֵם חָמוּם שֶׁמְּשַׁכְנֵעַ אֶת הַקָּהָל בִּמְהֵרָה.",
            exampleNative = "Он חָמוּם оратор, что быстро убеждает публику.",
         fillInBlankExclusions = listOf(182916L, 182917L, 182918L, 182920L)),
        WordEntity(
            id = 182920, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "emotions_l3_descriptive",
            original = "פָּגִיעַ", translation = "ранимый / уязвимый",
            transliteration = "пагиа",
            definition = "מִי שֶׁנִּפְגָּע בְּקַלּוּת מִמִּלִּים אוֹ מִמַּעֲשִׂים שֶׁל אֲחֵרִים.",
            definitionNative = "Тот, кто легко обижается от слов или поступков других людей.",
            example = "יְלָדִים פָּגִיעִים זְקוּקִים לְהָגָנָה מְיֻחֶדֶת מֵהַסְּבִיבָה.",
            exampleNative = "פָּגִיעַ детям нужна особая защита со стороны окружения.",
        ),

        // ─── emotions_l3_relations (5) ───────────────────────────────────
        WordEntity(
            id = 182921, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l3_relations",
            original = "חִבָּה", translation = "привязанность",
            transliteration = "хиба",
            definition = "רֶגֶשׁ חַם וְשָׁקֵט שֶׁל קִרְבָה לְמִישֶׁהוּ קָרוֹב, פָּחוֹת חָזָק מֵאַהֲבָה.",
            definitionNative = "Тёплое и тихое чувство близости к близкому человеку, менее сильное, чем любовь.",
            example = "הַחִבָּה שֶׁלּוֹ לַסַּבָּא הִתְבַּטְּאָה בִּבִּקּוּרִים כָּל יוֹם שִׁישִׁי.",
            exampleNative = "Его חִבָּה к деду выражалась в визитах каждую пятницу.",
         fillInBlankExclusions = listOf(182901L, 182922L, 182923L, 182924L, 182925L)),
        WordEntity(
            id = 182922, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l3_relations",
            original = "אַהֲדָה", translation = "симпатия",
            transliteration = "аhада",
            definition = "יַחַס חִיּוּבִי וְתוֹמֵךְ כְּלַפֵּי אָדָם אוֹ רַעְיוֹן בְּלִי קִרְבָה אִישִׁית מַמָּשִׁית.",
            definitionNative = "Положительное и поддерживающее отношение к человеку или идее без особой личной близости.",
            example = "הַקָּהָל גִּלָּה אַהֲדָה רַבָּה לַמּוּעֲמָדָה הַצְּעִירָה.",
            exampleNative = "Публика проявила большую אַהֲדָה к молодой кандидатке.",
         fillInBlankExclusions = listOf(182907L, 182921L, 182923L, 182924L, 182925L)),
        WordEntity(
            id = 182923, setId = 1829, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l3_relations",
            original = "טִינָה", translation = "затаённая обида / неприязнь",
            transliteration = "тина",
            definition = "כַּעַס שָׁקֵט וּמַתְמַשֵּׁךְ שֶׁאָדָם נוֹשֵׂא בַּלֵּב כְּלַפֵּי מִישֶׁהוּ שֶׁפָּגַע בּוֹ.",
            definitionNative = "Тихий долгий гнев, который человек носит в сердце против того, кто его обидел.",
            example = "הַטִּינָה בֵּין הָאַחִים נִמְשְׁכָה שָׁנִים אַחֲרֵי וִכּוּחַ עַל הַיְרֻשָּׁה.",
            exampleNative = "טִינָה между братьями длилась годами после спора о наследстве.",
        ),
        WordEntity(
            id = 182924, setId = 1829, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l3_relations",
            original = "הַעֲרָצָה", translation = "восхищение / преклонение",
            transliteration = "hааратца",
            definition = "יַחַס שֶׁל כָּבוֹד עָמֹק וְהוֹקָרָה גְּדוֹלָה כְּלַפֵּי אָדָם נֶעֱרָץ.",
            definitionNative = "Отношение глубокого уважения и большого почтения к восхваляемому человеку.",
            example = "הַהַעֲרָצָה שֶׁל הַתַּלְמִידִים לַמּוֹרָה גָּדְלָה מִשָּׁנָה לְשָׁנָה.",
            exampleNative = "הַעֲרָצָה учеников к учительнице росла из года в год.",
         fillInBlankExclusions = listOf(182901L, 182904L, 182907L, 182921L, 182922L, 182923L, 182925L)),
        WordEntity(
            id = 182925, setId = 1829, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l3_relations",
            original = "צָרוּת עַיִן", translation = "зависть",
            transliteration = "царут аин",
            definition = "רֶגֶשׁ שְׁלִילִי כְּלַפֵּי הַצְלָחָה אוֹ רְכוּשׁ שֶׁל אַחֵר וְהָרָצוֹן שֶׁלֹּא יִהְיוּ לוֹ.",
            definitionNative = "Негативное чувство к чужому успеху или имуществу и желание, чтобы их не было у другого.",
            example = "הוּא לֹא הִצְלִיחַ לְהַסְתִּיר אֶת צָרוּת הָעַיִן בַּמַּכּוֹנִית הַחֲדָשָׁה שֶׁל הַשָּׁכֵן.",
            exampleNative = "Он не сумел скрыть צָרוּת עַיִן при виде новой машины соседа.",
        ),
    )
}
