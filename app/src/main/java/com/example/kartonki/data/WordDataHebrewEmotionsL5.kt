package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — Эмоции и чувства (L5, LEGENDARY+EPIC).
 *
 * Set 1831: «Эмоции и чувства» — носитель/архаика/литературный регистр.
 *           Танахические образы чувств, поэтика страстей и тоски,
 *           философские категории души, архаичные глаголы переживания
 *           и высокая литературная лексика описания внутренних состояний.
 *
 * Тема «Эмоции и чувства» — продолжение L1 (1827), L2 (1828), L3 (1829).
 * L4 (1830) — соседний уровень (B2-C1), создаётся в той же волне
 * параллельным агентом и будет использовать психологическую лексику.
 * Этот L5 строго придерживается библейско-литературного регистра,
 * чтобы избежать пересечений с психологическим L4.
 *
 * Все 25 слов проверены grep'ом по `original = "..."` против всех
 * he-ru сетов. Замены из-за дублей и регистра:
 *   - вместо דּוֹד ("любимый" в Песни песней) — оставлен только אַהֲבָה
 *     уже в L1, т.к. דּוֹד занят в WordDataHebrewEveryday в значении «дядя»;
 *     в L5 любовная страсть закрыта через תְּשׁוּקָה и חוֹלַת אַהֲבָה.
 *   - вместо אֲצִילִי ("благородный") — נֶאֱצָל ("возвышенный, лучшийший
 *     из лучших"), т.к. אֲצִילִי занят в WordDataHebrewAppearanceL5.
 *   - вместо הוֹד ("величие") — שִׂגָּב ("высота духа"), т.к. הוֹד
 *     занят в WordDataHebrewAppearanceL5.
 *   - вместо הִתְפַּעֲלוּת ("восторг") — תְּרוּעָה (танахический ликующий
 *     возглас), т.к. הִתְפַּעֲלוּת занят в L3 (1829).
 *   - вместо חֲרָדָה ("тревога") — חֲרָדָה קְיוּמִית ("экзистенциальная
 *     тревога") как составной термин, т.к. однословная חֲרָדָה занята
 *     в Batch71 и set 1016.
 *   - вместо לֶהָבָה ("пламя страсти") — שַׁלְהֶבֶת (поэтич. вариант),
 *     т.к. לֶהָבָה занят в Batch92.
 *
 * Распределение редкости: 18 LEGENDARY + 7 EPIC — два смежных уровня
 * C2+ (LEGENDARY доминирует) + C1 (EPIC).
 *
 * SemanticGroups (5 × 5):
 *   emotions_l5_biblical          — Танахические образы чувств:
 *     страх Б-жий, скорбь-траур, ликование, ярость, преисподняя души
 *   emotions_l5_poetic            — поэтика страстей и тоски:
 *     томление, упоение, страсть, любовный недуг, отчаяние литер.
 *   emotions_l5_philosophical     — философские категории души:
 *     экзистенциальная тревога, муки совести, духовный подъём,
 *     прозрение, душевный покой
 *   emotions_l5_archaic_verbs     — архаичные глаголы переживания:
 *     взалкать, восхотеть, возрыдать, оплакивать, утешаться
 *   emotions_l5_descriptive_high  — высокая литературная лексика:
 *     возвышенный душой, благоговеющий, безутешный, окрылённый,
 *     изнывающий
 *
 * Word IDs: setId × 100 + position (183101..183125).
 *
 * fillInBlankExclusions / isFillInBlankSafe — НЕ задаются здесь.
 * Заполнятся через FILL_IN_BLANK pipeline централизованно после
 * полировки набора.
 */
object WordDataHebrewEmotionsL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1831,
            languagePair = "he-ru",
            orderIndex = 1831,
            name = "Эмоции и чувства",
            description = "Танахические образы, поэтика чувств и литературные категории",
            topic = "Эмоции и чувства",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 1831 — Эмоции и чувства: носитель/архаика (L5, LEG+EPIC)    ║
        // ║ 18 LEGENDARY + 7 EPIC, 5 групп × 5 слов                         ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── emotions_l5_biblical (5) — Танахические образы чувств ─────────

        WordEntity(
            id = 183101, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_biblical",
            original = "יִרְאָה", translation = "благоговение, страх Б-жий (Танах)",
            transliteration = "ир'а",
            definition = "תְּחוּשַׁת קֹדֶשׁ עֲמֻקָּה הַמְעֹרֶבֶת בְּחִיל וּבִכְנִיעָה לִפְנֵי דָּבָר עֶלְיוֹן.",
            definitionNative = "Глубокое священное чувство, в котором смешаны трепет и преклонение перед высшим.",
            example = "הַמְּשׁוֹרֵר תֵּאֵר אֶת יִרְאַת הָרוֹם שֶׁאָחֲזָה בּוֹ מוּל הַהָרִים.",
            exampleNative = "Поэт описывал יִרְאָה вышнюю, что охватила его перед лицом гор.",
        ),

        WordEntity(
            id = 183102, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_biblical",
            original = "אֵבֶל", translation = "скорбь, траур (Танах)",
            transliteration = "эвель",
            definition = "מַצָּב נַפְשִׁי שֶׁל אֵבֶל כָּבֵד עַל מֵת אוֹ עַל אָבְדָן עָצוּם — מֻשָּׂג מִקְרָאִי.",
            definitionNative = "Душевное состояние тяжкой скорби о покойном или о великой утрате — библейское понятие.",
            example = "אֵבֶל כָּבֵד יָרַד עַל הַמִּשְׁפָּחָה לְאַחַר הַבְּשׂוֹרָה הַמָּרָה.",
            exampleNative = "אֵבֶל тяжкий пал на семью после горестной вести.",
         fillInBlankExclusions = listOf(183101L, 183103L, 183104L, 183105L)),

        WordEntity(
            id = 183103, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_biblical",
            original = "תְּרוּעָה", translation = "ликование, трубный возглас (Танах)",
            transliteration = "теруа",
            definition = "קוֹל שִׂמְחָה גָּדוֹל הַבּוֹקֵעַ מִן הַלֵּב — בְּעִקָּר בִּקְרִיאוֹת מִקְדָּשׁ אוֹ מִלְחָמָה.",
            definitionNative = "Громкий клич радости, что вырывается из сердца — особенно в храмовых или военных возгласах.",
            example = "תְּרוּעָה גְּדוֹלָה עָלְתָה בָּעָם כְּשֶׁשָּׁבוּ הַלּוֹחֲמִים מִן הַקְּרָב.",
            exampleNative = "תְּרוּעָה великая поднялась в народе, когда воины вернулись с битвы.",
         fillInBlankExclusions = listOf(183101L, 183102L, 183104L, 183105L, 183106L, 183108L)),

        WordEntity(
            id = 183104, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_biblical",
            original = "חֵמָה", translation = "ярость, пылающий гнев (Танах)",
            transliteration = "хэма",
            definition = "כַּעַס יוֹקֵד וְעָצוּם הַמּוֹפִיעַ בִּלְשׁוֹן הַנְּבִיאִים — חַם וּבוֹעֵר כְּאֵשׁ.",
            definitionNative = "Огненный, исполинский гнев, что является в речи пророков — горячий и пылающий, как пламя.",
            example = "חֵמַת הַנָּבִיא נִשְׁפְּכָה עַל רָאשֵׁי הָעָם הַסּוֹרֵר.",
            exampleNative = "חֵמָה пророка излилась на головы строптивого народа.",
        ),

        WordEntity(
            id = 183105, setId = 1831, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l5_biblical",
            original = "שְׁאוֹל", translation = "преисподняя души, бездна отчаяния (Танах)",
            transliteration = "шеоль",
            definition = "תַּחְתִּיּוֹת הַנֶּפֶשׁ — דִּמּוּי מִקְרָאִי לִתְהוֹם פְּנִימִית וּלְיֵאוּשׁ קָדוֹשׁ.",
            definitionNative = "Низины души — библейский образ внутренней бездны и беспросветного отчаяния.",
            example = "מִשְּׁאוֹל לִבּוֹ קָרָא הַמְּשׁוֹרֵר לְעֶזְרָה.",
            exampleNative = "Из שְׁאוֹל своего сердца поэт взывал о помощи.",
        ),

        // ── emotions_l5_poetic (5) — поэтика страстей и тоски ─────────────

        WordEntity(
            id = 183106, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_poetic",
            original = "כְּמִיהָה", translation = "томление, поэтическая тоска",
            transliteration = "кмиhа",
            definition = "גַּעְגּוּעַ עָמֹק וְשַׁלְוָתִי לְמַשֶּׁהוּ רָחוֹק שֶׁאֵין דֶּרֶךְ לְהַשִּׂיגוֹ — מִלָּה שִׁירִית.",
            definitionNative = "Глубокое умиротворённое стремление к чему-то далёкому, чего невозможно достичь — поэтическое слово.",
            example = "כְּמִיהָה לְאַרְצוֹת רְחוֹקוֹת מִלְּאָה אֶת לֵב הַנּוֹדֵד הַזָּקֵן.",
            exampleNative = "כְּמִיהָה к далёким землям наполняла сердце старого скитальца.",
         fillInBlankExclusions = listOf(183107L, 183108L, 183109L, 183110L)),

        WordEntity(
            id = 183107, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_poetic",
            original = "שִׁכָּרוֹן", translation = "упоение, опьянение чувством (поэт.)",
            transliteration = "шикарон",
            definition = "מַצָּב שֶׁל הִתְמַסְּרוּת מֻחְלֶטֶת לְרֶגֶשׁ עָז — אַהֲבָה, יְצִירָה אוֹ נִצָּחוֹן.",
            definitionNative = "Состояние полной самоотдачи всепоглощающему чувству — любви, творчеству или победе.",
            example = "שִׁכְרוֹן הַנִּצָּחוֹן הִשְׁכִּיחַ מִמֶּנּוּ אֶת מְחִיר הַקְּרָב.",
            exampleNative = "שִׁכָּרוֹן победы заставило его забыть о цене битвы.",
        ),

        WordEntity(
            id = 183108, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_poetic",
            original = "תְּשׁוּקָה", translation = "страсть, неуёмное влечение (поэт.)",
            transliteration = "тшука",
            definition = "מְשִׁיכָה עַזָּה וּבוֹעֶרֶת הַמְכַלָּה אֶת הַנֶּפֶשׁ — מִלָּה מִקְרָאִית מִשִּׁיר הַשִּׁירִים.",
            definitionNative = "Жгучее жадное влечение, испепеляющее душу — слово библейское, из Песни песней.",
            example = "תְּשׁוּקָתוֹ אֵלֶיהָ בָּעֲרָה כְּאֵשׁ שֶׁאֵין לְכַבּוֹתָהּ.",
            exampleNative = "תְּשׁוּקָה к ней пылала в нём, как огонь, которого не угасить.",
        ),

        WordEntity(
            id = 183109, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_poetic",
            original = "חוֹלַת אַהֲבָה", translation = "недужная любовью (Песнь песней)",
            transliteration = "холат аhава",
            definition = "מִי שֶׁאַהֲבָתָהּ עָזָה כָּל כָּךְ עַד שֶׁהִיא חָשָׁה כְּחוֹלָה — צֵרוּף מִשִּׁיר הַשִּׁירִים.",
            definitionNative = "Та, чья любовь столь сильна, что ощущается как болезнь — выражение из Песни песней.",
            example = "\"חוֹלַת אַהֲבָה אָנִי\" — כָּכָה אָמְרָה הַנַּעֲרָה אֶל בְּנוֹת יְרוּשָׁלָיִם.",
            exampleNative = "«חוֹלַת אַהֲבָה я» — так молвила дева дочерям иерусалимским.",
         fillInBlankExclusions = listOf(183106L, 183107L, 183108L, 183110L)),

        WordEntity(
            id = 183110, setId = 1831, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l5_poetic",
            original = "שַׁלְהֶבֶת", translation = "пламя страсти (поэт.)",
            transliteration = "шальhэвэт",
            definition = "אֵשׁ פְּנִימִית בּוֹעֶרֶת בַּלֵּב — דִּמּוּי שִׁירִי לְרֶגֶשׁ שֶׁאֵין דֶּרֶךְ לְהַסְתִּירוֹ.",
            definitionNative = "Внутренний огонь, пылающий в сердце — поэтический образ для чувства, что нельзя сокрыть.",
            example = "שַׁלְהֶבֶת אַהֲבָתוֹ נִדְלְקָה מֵחָדָשׁ עִם כָּל מַבָּט שֶׁלָּהּ.",
            exampleNative = "שַׁלְהֶבֶת его любви разгоралась заново при каждом её взгляде.",
         fillInBlankExclusions = listOf(183106L, 183107L, 183108L, 183109L)),

        // ── emotions_l5_philosophical (5) — философские категории души ───

        WordEntity(
            id = 183111, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_philosophical",
            original = "חֲרָדָה קְיוּמִית", translation = "экзистенциальная тревога",
            transliteration = "харада киюмит",
            definition = "אֵימָה פִילוֹסוֹפִית מֵעַצֶם הַהֲוָיָה — תְּחוּשַׁת אֵין־אוֹנִים מוּל סוֹפִיּוּת הַחַיִּים.",
            definitionNative = "Философский ужас от самого факта бытия — чувство беспомощности перед конечностью жизни.",
            example = "חֲרָדָה קְיוּמִית תָּקְפָה אוֹתוֹ לְיַד מִטַּת אָבִיו הַגּוֹסֵס.",
            exampleNative = "חֲרָדָה קְיוּמִית настигла его у одра умирающего отца.",
         fillInBlankExclusions = listOf(183112L, 183113L, 183114L, 183115L)),

        WordEntity(
            id = 183112, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_philosophical",
            original = "יִסּוּרֵי מַצְפּוּן", translation = "муки совести (книжн.)",
            transliteration = "исурэй мацпун",
            definition = "כְּאֵב נַפְשִׁי כָּבֵד עַל מַעֲשֶׂה רַע אוֹ עַל מַחְדָּל מוּסָרִי — מֻשָּׂג סִפְרוּתִי.",
            definitionNative = "Тяжкая душевная боль за дурной поступок или нравственное упущение — литературное понятие.",
            example = "יִסּוּרֵי מַצְפּוּן רָדְפוּ אוֹתוֹ לֵילוֹת רַבִּים אַחֲרֵי הַבְּגִידָה.",
            exampleNative = "יִסּוּרֵי מַצְפּוּן преследовали его много ночей после предательства.",
         fillInBlankExclusions = listOf(183111L, 183113L, 183114L, 183115L)),

        WordEntity(
            id = 183113, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "emotions_l5_philosophical",
            original = "הִתְעַלּוּת", translation = "духовный подъём, возвышение (книжн.)",
            transliteration = "hит'алут",
            definition = "מַצָּב שֶׁבּוֹ הָרוּחַ מִתְרוֹמֶמֶת מֵעַל הַיּוֹמְיוֹם וּמַגִּיעָה לְשִׂיא פְּנִימִי.",
            definitionNative = "Состояние, в котором дух возвышается над повседневностью и достигает внутренней вершины.",
            example = "הִתְעַלּוּת רוּחָנִית אֲחָזָה אוֹתוֹ בְּעֵת הַתְּפִלָּה לִפְנֵי הַשַּׁחַר.",
            exampleNative = "הִתְעַלּוּת духовная охватила его во время предрассветной молитвы.",
         fillInBlankExclusions = listOf(183111L, 183112L, 183114L, 183115L)),

        WordEntity(
            id = 183114, setId = 1831, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l5_philosophical",
            original = "הִתְפַּכְּחוּת", translation = "прозрение, отрезвление (книжн.)",
            transliteration = "hитпакхут",
            definition = "תַּהֲלִיךְ פְּנִימִי שֶׁבּוֹ אָדָם מַכִּיר בְּאֱמֶת מָרָה אַחֲרֵי שָׁנִים שֶׁל הַשְׁלָיָה.",
            definitionNative = "Внутренний процесс, в котором человек сознаёт горькую истину после многих лет самообмана.",
            example = "הִתְפַּכְּחוּתוֹ הַקָּשָׁה הִשְׁאִירָה אוֹתוֹ עַם שְׂרִידֵי אֱמוּנָה דַּקִּים.",
            exampleNative = "הִתְפַּכְּחוּת его горькое оставило ему лишь тонкие остатки веры.",
        ),

        WordEntity(
            id = 183115, setId = 1831, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l5_philosophical",
            original = "שַׁלְוַת נֶפֶשׁ", translation = "душевный покой (книжн.)",
            transliteration = "шальват нэфэш",
            definition = "מַצָּב שֶׁל אִזּוּן פְּנִימִי שָׁלֵם שֶׁבּוֹ שׁוֹם רֶגֶשׁ אֵינוֹ מַפֵּר אֶת הַסֵּדֶר הַפְּנִימִי.",
            definitionNative = "Состояние полного внутреннего равновесия, в котором никакое чувство не нарушает порядка души.",
            example = "רַק בִּשְׁנוֹתָיו הַמְּאֻחָרוֹת מָצָא הָרַב שַׁלְוַת נֶפֶשׁ אֲמִתִּית.",
            exampleNative = "Только в поздние годы рав обрёл подлинное שַׁלְוַת נֶפֶשׁ.",
        ),

        // ── emotions_l5_archaic_verbs (5) — архаичные глаголы ─────────────

        WordEntity(
            id = 183116, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "verb", semanticGroup = "emotions_l5_archaic_verbs",
            original = "לִכְסֹף", translation = "взалкать, страстно желать (поэт.)",
            transliteration = "лихсоф",
            definition = "לְהִתְגַּעְגֵּעַ בְּכָל הַנֶּפֶשׁ אֶל מַשֶּׁהוּ נַעֲלֶה אוֹ רָחוֹק — פֹּעַל שִׁירִי.",
            definitionNative = "Тосковать всей душой о чём-то возвышенном или далёком — поэтический глагол.",
            example = "נַפְשׁוֹ כָּסְפָה לְאֶרֶץ אֲבוֹתָיו כָּל יְמֵי הַגָּלוּת.",
            exampleNative = "Душа его כָּסְפָה по земле отцов все дни изгнания.",
        ),

        WordEntity(
            id = 183117, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "verb", semanticGroup = "emotions_l5_archaic_verbs",
            original = "לַחְמֹד", translation = "вожделеть, страстно возжелать (Танах)",
            transliteration = "лахмод",
            definition = "לִרְצוֹת בְּעֹצֶם רַב מַשֶּׁהוּ שֶׁלֹּא לְךָ — פֹּעַל מִקְרָאִי מֵעֶשֶׂרֶת הַדִּבְּרוֹת.",
            definitionNative = "Желать с великой силой того, что тебе не принадлежит — библейский глагол из Десяти Заповедей.",
            example = "\"לֹא תַחְמֹד\" — צִוּוּי שֶׁמְּדַבֵּר עַל יֵצֶר הַלֵּב.",
            exampleNative = "«לֹא תַחְמֹד» — заповедь, что говорит о вожделении сердца.",
        ),

        WordEntity(
            id = 183118, setId = 1831, languagePair = "he-ru", rarity = "EPIC",
            pos = "verb", semanticGroup = "emotions_l5_archaic_verbs",
            original = "לְקוֹנֵן", translation = "слагать плач, оплакивать (книжн.)",
            transliteration = "леконен",
            definition = "לוֹמַר דִּבְרֵי אֵבֶל שִׁירִיִּים עַל מֵת אוֹ עַל אָבְדָן גָּדוֹל — מֻשָּׂג מִקְרָאִי.",
            definitionNative = "Произносить поэтические слова скорби об усопшем или о великой утрате — библейское понятие.",
            example = "הַנָּבִיא יְשַׁעְיָהוּ קוֹנֵן עַל חֻרְבַּן הָעִיר בְּקוֹל גָּדוֹל.",
            exampleNative = "Пророк Исаия קוֹנֵן о разрушении города в полный голос.",
        ),

        WordEntity(
            id = 183119, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "verb", semanticGroup = "emotions_l5_archaic_verbs",
            original = "לְהֵאָנֵק", translation = "стенать, тяжко вздыхать (книжн.)",
            transliteration = "леhэанэк",
            definition = "לְהוֹצִיא קוֹלוֹת כְּאֵב פְּנִימִיִּים עֲמֻקִּים — פֹּעַל סִפְרוּתִי וּמִקְרָאִי.",
            definitionNative = "Издавать глубокие звуки внутренней боли — литературный и библейский глагол.",
            example = "הַזָּקֵן נֶאֱנַק בְּלִבּוֹ עַל מַר גּוֹרָלוֹ.",
            exampleNative = "Старец נֶאֱנַק в сердце своём о горькой судьбе.",
        ),

        WordEntity(
            id = 183120, setId = 1831, languagePair = "he-ru", rarity = "EPIC",
            pos = "verb", semanticGroup = "emotions_l5_archaic_verbs",
            original = "לְהִתְנַחֵם", translation = "утешаться (книжн.)",
            transliteration = "леhитнахэм",
            definition = "לִמְצֹא נֶחָמָה פְּנִימִית אַחֲרֵי אָבְדָן אוֹ צַעַר — פֹּעַל בְּרֶגֶשׁ נִשְׂגָּב.",
            definitionNative = "Обретать внутреннее утешение после утраты или горя — глагол высокого регистра.",
            example = "אַחֲרֵי שָׁנִים שֶׁל אֵבֶל הִתְנַחֵם הָאַלְמָן בְּזִכְרוֹן הַחֶסֶד שֶׁבֵּינֵיהֶם.",
            exampleNative = "После многих лет скорби вдовец הִתְנַחֵם памятью о благодати, что была меж ними.",
        ),

        // ── emotions_l5_descriptive_high (5) — высокая литературная лексика

        WordEntity(
            id = 183121, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "emotions_l5_descriptive_high",
            original = "נֶאֱצָל", translation = "возвышенный душой, благородный (книжн.)",
            transliteration = "нээцаль",
            definition = "מִי שֶׁנַּפְשׁוֹ עַל הַסַּף הָעֶלְיוֹן שֶׁל מַעֲלוֹת מוּסָרִיּוֹת וְרוּחָנִיּוֹת — מִלָּה סִפְרוּתִית.",
            definitionNative = "Тот, чья душа на высшей ступени нравственных и духовных достоинств — литературное слово.",
            example = "לְמוֹרוֹ הַזָּקֵן הָיוּ פָּנִים נֶאֱצָלִים שֶׁל אִישׁ קָדוֹשׁ.",
            exampleNative = "У старого учителя был נֶאֱצָל облик праведника.",
         fillInBlankExclusions = listOf(183122L, 183123L, 183124L, 183125L)),

        WordEntity(
            id = 183122, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "emotions_l5_descriptive_high",
            original = "מָלֵא יִרְאָה", translation = "благоговеющий, исполненный трепета (книжн.)",
            transliteration = "малэ ир'а",
            definition = "מִי שֶׁכָּל יֵשׁוּתוֹ נְכוּחָה לִפְנֵי דָּבָר רָם — בִּתְפִלָּה, בְּטֶבַע אוֹ בְּמַחֲשָׁבָה.",
            definitionNative = "Тот, чьё всё существо склоняется перед чем-то возвышенным — в молитве, в природе или в мысли.",
            example = "מָלֵא יִרְאָה עָמַד הַצַּלָּם מוּל הַזְּרִיחָה הָרִאשׁוֹנָה שֶׁל הַשָּׁנָה.",
            exampleNative = "מָלֵא יִרְאָה стоял фотограф перед первым рассветом года.",
         fillInBlankExclusions = listOf(183121L, 183123L, 183124L, 183125L)),

        WordEntity(
            id = 183123, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "emotions_l5_descriptive_high",
            original = "חֲסַר נֶחָמָה", translation = "безутешный (книжн.)",
            transliteration = "хасар нэхама",
            definition = "מִי שֶׁאֵין דֶּרֶךְ לְהָקֵל אֶת צַעֲרוֹ אוֹ אֶת אֶבְלוֹ — בִּטּוּי סִפְרוּתִי כָּבֵד.",
            definitionNative = "Тот, чьё горе или скорбь не утолить никаким средством — тяжёлое литературное выражение.",
            example = "הָאֵם נִשְׁאֲרָה חֲסֶרֶת נֶחָמָה לְאַחַר אָבְדָן בְּנָהּ הַיָּחִיד.",
            exampleNative = "Мать осталась חֲסֶרֶת נֶחָמָה после потери единственного сына.",
        ),

        WordEntity(
            id = 183124, setId = 1831, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "emotions_l5_descriptive_high",
            original = "מְרוֹמָם", translation = "окрылённый, душою воспарённый (книжн.)",
            transliteration = "меромам",
            definition = "מִי שֶׁרוּחוֹ הוּרְמָה מֵעַל הַיּוֹמְיוֹם בִּזְכוּת רֶגֶשׁ עָז שֶׁל שִׂמְחָה אוֹ אַהֲבָה.",
            definitionNative = "Тот, чей дух поднят над повседневностью благодаря сильному чувству радости или любви.",
            example = "הַמְּשׁוֹרֵר חָזַר מִן הַמַּסָּע מְרוֹמָם וּמָלֵא הַשְׁרָאָה.",
            exampleNative = "Поэт вернулся из странствия מְרוֹמָם и преисполненный вдохновения.",
         fillInBlankExclusions = listOf(183121L, 183122L, 183123L, 183125L)),

        WordEntity(
            id = 183125, setId = 1831, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "emotions_l5_descriptive_high",
            original = "כְּמֵהַ", translation = "изнывающий, тоскующий (книжн.)",
            transliteration = "кмэhа",
            definition = "מִי שֶׁלִּבּוֹ כָּלֶה אַחֲרֵי דָּבָר רָחוֹק שֶׁאֵין בְּיָדוֹ לְהַשִּׂיגוֹ — מִלָּה שִׁירִית.",
            definitionNative = "Тот, чьё сердце изнывает по чему-то далёкому, чего не достичь — поэтическое слово.",
            example = "כְּמֵהַ לְקוֹל הַיַּם, חָזַר הַסּוֹפֵר הַזָּקֵן אֶל בֵּית יַלְדוּתוֹ.",
            exampleNative = "כְּמֵהַ услышать шум моря, старый писатель вернулся в дом детства.",
        ),
    )
}
