package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Внешность и тело", level 1 (A1-A2).
 * Один сет × 25 слов. setId = 1822.
 *
 *  - 18 COMMON + 7 UNCOMMON (2 смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      body_main_parts        — главные части тела (голова, рука, нога, тело, живот)
 *      body_face_parts        — части лица (нос, рот, ухо, зуб, лоб)
 *      body_limbs             — конечности и суставы (палец, плечо, спина, колено, локоть)
 *      appearance_age         — возрастные описания (молодой, старый, младенец, подросток, взрослый)
 *      appearance_features    — внешние черты (длинный, короткий, улыбка, шея, подбородок)
 *  - Никудим везде. isFillInBlankSafe=false на старте для слов с риском
 *    неоднозначного blank'а — после полировки и FIB pipeline безопасные
 *    переведутся в safe.
 *  - Слова темы «Психология» (сет 1141, description "Внешность, характер
 *    и черты лица") и темы «Медицина» (1600+) не дублируются в этом сете —
 *    выбраны другие, незанятые ивритские слова про тело и описание.
 *  - תִּינוֹק, צָעִיר, זָקֵן пересекаются с темой «Семья» (сет 1005),
 *    אָרֹךְ/קָצָר с темой «Лингвистика» (сет 1199) — допустимо политикой
 *    дублей: разные topic'и (см. feedback_duplicate_words_policy).
 */
object WordDataHebrewAppearanceL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1822, languagePair = "he-ru", orderIndex = 1822,
            name = "Внешность и тело",
            description = "Части тела и базовое описание человека",
            topic = "Внешность и тело", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── body_main_parts (5) ──────────────────────────────────────────
        WordEntity(
            id = 182201, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_main_parts",
            original = "רֹאשׁ", translation = "голова",
            transliteration = "рош",
            definition = "הַחֵלֶק הָעֶלְיוֹן שֶׁל הַגּוּף שֶׁבּוֹ נִמְצָאִים הַמֹּחַ וְהַפָּנִים.",
            definitionNative = "Верхняя часть тела человека — там находятся мозг и лицо.",
            example = "כּוֹאֵב לִי הָרֹאשׁ אַחֲרֵי יוֹם אָרֹךְ בַּמִּשְׂרָד.",
            exampleNative = "У меня болит רֹאשׁ после долгого дня в офисе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 182202, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_main_parts",
            original = "יָד", translation = "рука / кисть",
            transliteration = "яд",
            definition = "חֵלֶק שֶׁל הַגּוּף שֶׁבּוֹ אֶצְבָּעוֹת — בּוֹ אוֹחֲזִים וְכוֹתְבִים.",
            definitionNative = "Часть тела с пальцами — ею держат предметы и пишут.",
            example = "הוּא נָתַן לִי אֶת הַסֵּפֶר עִם יָד אַחַת.",
            exampleNative = "Он передал мне книгу одной יָד.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(182201L, 182203L, 182204L, 182205L, 182208L, 182209L, 182211L, 182212L, 182214L)),
        WordEntity(
            id = 182203, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_main_parts",
            original = "רֶגֶל", translation = "нога",
            transliteration = "рэгэль",
            definition = "חֵלֶק שֶׁל הַגּוּף שֶׁעָלָיו עוֹמְדִים וְהוֹלְכִים.",
            definitionNative = "Часть тела, на которой стоят и с помощью которой ходят.",
            example = "אַחֲרֵי הָרִיצָה כּוֹאֶבֶת לִי רֶגֶל אַחַת.",
            exampleNative = "После пробежки у меня болит одна רֶגֶל.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(182201L, 182202L, 182204L, 182205L, 182208L, 182209L, 182211L, 182212L, 182214L)),
        WordEntity(
            id = 182204, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_main_parts",
            original = "גּוּף", translation = "тело",
            transliteration = "гуф",
            definition = "כֹּל הַחֲלָקִים שֶׁל הָאָדָם יַחַד — מֵהָרֹאשׁ וְעַד הָרַגְלַיִם.",
            definitionNative = "Все части человека вместе — от головы до ступней.",
            example = "אַחֲרֵי הָאִמּוּן כֹּל הַגּוּף שֶׁלִּי עָיֵף.",
            exampleNative = "После тренировки всё моё גּוּף устало.",
         fillInBlankExclusions = listOf(182201L, 182202L, 182203L, 182205L)),
        WordEntity(
            id = 182205, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_main_parts",
            original = "בֶּטֶן", translation = "живот",
            transliteration = "бэтэн",
            definition = "חֵלֶק קִדְמִי שֶׁל הַגּוּף בֵּין הֶחָזֶה וְהָאֲגָן — בּוֹ הָאֹכֶל מִתְעַכֵּל.",
            definitionNative = "Передняя часть тела между грудью и тазом — там переваривается еда.",
            example = "אָכַלְתִּי יוֹתֵר מִדַּי וְעַכְשָׁו כּוֹאֶבֶת לִי הַבֶּטֶן.",
            exampleNative = "Я съел слишком много, и теперь у меня болит בֶּטֶן.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(182201L, 182202L, 182203L, 182204L, 182208L, 182209L, 182211L, 182212L, 182214L)),

        // ─── body_face_parts (5) ──────────────────────────────────────────
        WordEntity(
            id = 182206, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_face_parts",
            original = "אַף", translation = "нос",
            transliteration = "аф",
            definition = "אֵבָר בָּאֶמְצַע הַפָּנִים — דֶּרֶךְ שֶׁבָּהּ נוֹשְׁמִים וּמֵרִיחִים.",
            definitionNative = "Орган в центре лица — через него дышат и улавливают запахи.",
            example = "יֵשׁ לִי נַזֶּלֶת וְהָאַף שֶׁלִּי סָתוּם.",
            exampleNative = "У меня насморк, и мой אַף заложен.",
         fillInBlankExclusions = listOf(182207L, 182208L, 182209L, 182210L)),
        WordEntity(
            id = 182207, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_face_parts",
            original = "פֶּה", translation = "рот",
            transliteration = "пэ",
            definition = "פֶּתַח בַּפָּנִים שֶׁדַּרְכּוֹ אוֹכְלִים וּמְדַבְּרִים.",
            definitionNative = "Отверстие на лице, через которое едят и говорят.",
            example = "הוּא פָּתַח אֶת הַפֶּה כְּדֵי לוֹמַר מַשֶּׁהוּ.",
            exampleNative = "Он открыл פֶּה, чтобы что-то сказать.",
         fillInBlankExclusions = listOf(182206L, 182208L, 182209L, 182210L)),
        WordEntity(
            id = 182208, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_face_parts",
            original = "אֹזֶן", translation = "ухо",
            transliteration = "озэн",
            definition = "אֵבָר בְּצַד הָרֹאשׁ שֶׁבּוֹ שׁוֹמְעִים קוֹלוֹת וּמוּזִיקָה.",
            definitionNative = "Орган сбоку головы, которым слышат звуки и музыку.",
            example = "הַתִּינוֹק נִרְדַּם עִם הָאֹזֶן עַל הַכָּרִית.",
            exampleNative = "Малыш заснул, прижавшись אֹזֶן к подушке.",
         fillInBlankExclusions = listOf(182206L, 182207L, 182209L, 182210L)),
        WordEntity(
            id = 182209, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_face_parts",
            original = "שֵׁן", translation = "зуб",
            transliteration = "шэн",
            definition = "עֶצֶם לְבָנָה קְטַנָּה בַּפֶּה — בָּהּ לוֹעֲסִים אֶת הָאֹכֶל.",
            definitionNative = "Маленькая белая косточка во рту, которой пережёвывают пищу.",
            example = "לַתִּינוֹק יָצְאָה הַשֵּׁן הָרִאשׁוֹנָה הַשָּׁבוּעַ.",
            exampleNative = "У малыша на этой неделе вылезла первая שֵׁן.",
         fillInBlankExclusions = listOf(182206L, 182207L, 182208L, 182210L)),
        WordEntity(
            id = 182210, setId = 1822, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "body_face_parts",
            original = "מֶצַח", translation = "лоб",
            transliteration = "мэцах",
            definition = "חֵלֶק חָלָק שֶׁל הַפָּנִים מֵעַל הָעֵינַיִם וְעַד שֹׁרֶשׁ הַשֵּׂעָר.",
            definitionNative = "Гладкая часть лица над глазами — до самой линии волос.",
            example = "אִמָּא נָתְנָה לִי נְשִׁיקָה עַל הַמֶּצַח לִפְנֵי הַשֵּׁנָה.",
            exampleNative = "Мама поцеловала меня в מֶצַח перед сном.",
         fillInBlankExclusions = listOf(182206L, 182207L, 182208L, 182209L)),

        // ─── body_limbs (5) ───────────────────────────────────────────────
        WordEntity(
            id = 182211, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_limbs",
            original = "אֶצְבַּע", translation = "палец",
            transliteration = "эцба",
            definition = "אֶחָד מֵחֲמֵשֶׁת הַחֲלָקִים הַדַּקִּים בִּקְצֵה הַיָּד אוֹ הָרֶגֶל.",
            definitionNative = "Одна из пяти тонких подвижных частей на конце руки или ноги.",
            example = "חָתַכְתִּי אֶת הָאֶצְבַּע בַּסַּכִּין בַּמִּטְבָּח.",
            exampleNative = "Я порезал אֶצְבַּע ножом на кухне.",
         fillInBlankExclusions = listOf(182212L, 182213L, 182214L, 182215L)),
        WordEntity(
            id = 182212, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_limbs",
            original = "כָּתֵף", translation = "плечо",
            transliteration = "катэф",
            definition = "חֵלֶק עֶלְיוֹן שֶׁל הַגּוּף שֶׁבּוֹ הַזְּרוֹעַ מִתְחַבֶּרֶת לַגּוּף.",
            definitionNative = "Верхняя часть тела, где рука соединяется с туловищем.",
            example = "שַׂמְתִּי אֶת הַתִּיק עַל הַכָּתֵף וְיָצָאתִי.",
            exampleNative = "Я повесил рюкзак на כָּתֵף и вышел из дома.",
         fillInBlankExclusions = listOf(182211L, 182213L, 182214L, 182215L)),
        WordEntity(
            id = 182213, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "body_limbs",
            original = "גַּב", translation = "спина",
            transliteration = "гав",
            definition = "הַחֵלֶק הָאֲחוֹרִי שֶׁל הַגּוּף — בֵּין הַכְּתֵפַיִם וְהָאֲגָן.",
            definitionNative = "Задняя часть тела между плечами и тазом.",
            example = "אַחֲרֵי הַמַּחְשֵׁב כֹּל הַיּוֹם כּוֹאֵב לִי הַגַּב.",
            exampleNative = "После целого дня за компьютером у меня болит גַּב.",
         fillInBlankExclusions = listOf(182211L, 182212L, 182214L, 182215L)),
        WordEntity(
            id = 182214, setId = 1822, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "body_limbs",
            original = "בֶּרֶךְ", translation = "колено",
            transliteration = "бэрэх",
            definition = "מָקוֹם בְּאֶמְצַע הָרֶגֶל שֶׁמִּתְכּוֹפֵף כְּשֶׁיּוֹשְׁבִים אוֹ רָצִים.",
            definitionNative = "Сустав в середине ноги — сгибается, когда садятся или бегут.",
            example = "נָפַלְתִּי בָּרְחוֹב וְפָצַעְתִּי אֶת הַבֶּרֶךְ.",
            exampleNative = "Я упал на улице и разбил בֶּרֶךְ.",
         fillInBlankExclusions = listOf(182211L, 182212L, 182213L, 182215L)),
        WordEntity(
            id = 182215, setId = 1822, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "body_limbs",
            original = "מַרְפֵּק", translation = "локоть",
            transliteration = "марпэк",
            definition = "מָקוֹם בְּאֶמְצַע הַיָּד שֶׁמִּתְכּוֹפֵף כְּשֶׁמְּרִימִים אוֹ אוֹחֲזִים.",
            definitionNative = "Сустав посередине руки — сгибается, когда что-то поднимают или держат.",
            example = "הוּא נִשְׁעַן עַל הַמַּרְפֵּק וְקָרָא עִתּוֹן.",
            exampleNative = "Он опёрся на מַרְפֵּק и читал газету.",
         fillInBlankExclusions = listOf(182211L, 182212L, 182213L, 182214L)),

        // ─── appearance_age (5) ───────────────────────────────────────────
        WordEntity(
            id = 182216, setId = 1822, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "appearance_age",
            original = "צָעִיר", translation = "молодой",
            transliteration = "цаир",
            definition = "מִי שֶׁנּוֹלַד לֹא מִזְּמַן — בִּתְחִילַּת הַחַיִּים אוֹ סָבִיב גִּיל הַנְּעוּרִים.",
            definitionNative = "Тот, кто родился недавно — в начале жизни или около юности.",
            example = "הָרוֹפֵא הֶחָדָשׁ צָעִיר מְאוֹד אֲבָל מְקַצּוֹעִי.",
            exampleNative = "Новый врач совсем צָעִיר, но очень профессиональный.",
         fillInBlankExclusions = listOf(182217L, 182220L)),
        WordEntity(
            id = 182217, setId = 1822, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "appearance_age",
            original = "זָקֵן", translation = "пожилой / старый",
            transliteration = "закэн",
            definition = "מִי שֶׁחַי שָׁנִים רַבּוֹת וְכֹחוֹתָיו פּוֹחֲתִים עִם הַזְּמַן.",
            definitionNative = "Тот, кто прожил много лет, и силы его убавились со временем.",
            example = "אִישׁ זָקֵן יָשַׁב לְבַד עַל הַסַּפְסָל בַּגַּן.",
            exampleNative = "זָקֵן мужчина сидел один на скамейке в парке.",
         fillInBlankExclusions = listOf(182216L, 182220L)),
        WordEntity(
            id = 182218, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "appearance_age",
            original = "תִּינוֹק", translation = "младенец",
            transliteration = "тинок",
            definition = "יֶלֶד קָטָן מְאוֹד שֶׁעֲדַיִן לֹא לוֹמֵד לְדַבֵּר אוֹ לָלֶכֶת.",
            definitionNative = "Совсем маленький ребёнок, который ещё не говорит и не ходит.",
            example = "הַתִּינוֹק יָשֵׁן בָּעֲגָלָה לְיַד הַחַלּוֹן.",
            exampleNative = "תִּינוֹק спит в коляске у самого окна.",
         fillInBlankExclusions = listOf(182219L)),
        WordEntity(
            id = 182219, setId = 1822, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_age",
            original = "נַעַר", translation = "подросток",
            transliteration = "наар",
            definition = "צָעִיר בְּגִיל בֵּין יַלְדוּת לְבַגְרוּת — בְּדֶרֶךְ כְּלָל בֵּית סֵפֶר תִּיכוֹן.",
            definitionNative = "Юный человек между детством и взрослостью — обычно школьник старших классов.",
            example = "הַנַּעַר עוֹזֵר לְאִמּוֹ לִשְׂאֹת אֶת הַסַּלִּים.",
            exampleNative = "נַעַר помогает маме нести продуктовые сумки.",
         fillInBlankExclusions = listOf(182218L, 182220L)),
        WordEntity(
            id = 182220, setId = 1822, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_age",
            original = "מְבֻגָּר", translation = "взрослый",
            transliteration = "мэвугар",
            definition = "אָדָם שֶׁכְּבָר אֵינוֹ יֶלֶד — עוֹבֵד וְאַחְרָאִי לְעַצְמוֹ.",
            definitionNative = "Человек, который уже не ребёнок — работает и отвечает за себя.",
            example = "כֹּל מְבֻגָּר מְשַׁלֵּם מִסִּים פַּעַם בְּשָׁנָה.",
            exampleNative = "Каждый מְבֻגָּר раз в год платит налоги.",
         fillInBlankExclusions = listOf(182216L, 182217L, 182219L)),

        // ─── appearance_features (5) ──────────────────────────────────────
        WordEntity(
            id = 182221, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "appearance_features",
            original = "אָרֹךְ", translation = "длинный",
            transliteration = "арох",
            definition = "מַשֶּׁהוּ שֶׁמִּתְמַשֵּׁךְ לְמֶרְחָק גָּדוֹל מִקָּצֶה אֶל קָצֶה.",
            definitionNative = "Тот или то, что протянулось далеко от одного края до другого.",
            example = "יֵשׁ לָהּ שֵׂעָר אָרֹךְ עַד הַמָּתְנַיִם.",
            exampleNative = "У неё אָרֹךְ волосы — до самой талии.",
         fillInBlankExclusions = listOf(182222L)),
        WordEntity(
            id = 182222, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "appearance_features",
            original = "קָצָר", translation = "короткий",
            transliteration = "кацар",
            definition = "מַשֶּׁהוּ עִם אֹרֶךְ קָטָן — לֹא מִתְמַשֵּׁךְ הַרְבֵּה לְצַד אֶחָד.",
            definitionNative = "То, что небольшой длины — не тянется далеко в одну сторону.",
            example = "הוּא הִסְתַּפֵּר וְעַכְשָׁו הַשֵּׂעָר שֶׁלּוֹ קָצָר.",
            exampleNative = "Он подстригся, и теперь его волосы קָצָר.",
         fillInBlankExclusions = listOf(182221L)),
        WordEntity(
            id = 182223, setId = 1822, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "appearance_features",
            original = "חִיּוּךְ", translation = "улыбка",
            transliteration = "хиюх",
            definition = "תְּנוּעָה שֶׁל הַשְּׂפָתַיִם כְּלַפֵּי מַעְלָה — סִימָן שֶׁל שִׂמְחָה.",
            definitionNative = "Движение губ вверх — знак радости или удовольствия.",
            example = "הַיֶּלֶד הִסְתַּכֵּל עָלַי עִם חִיּוּךְ גָּדוֹל.",
            exampleNative = "Мальчик посмотрел на меня с большим חִיּוּךְ.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 182224, setId = 1822, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_features",
            original = "צַוָּאר", translation = "шея",
            transliteration = "цавар",
            definition = "חֵלֶק שֶׁל הַגּוּף שֶׁמְּחַבֵּר אֶת הָרֹאשׁ אֶל הַכְּתֵפַיִם.",
            definitionNative = "Часть тела, которая соединяет голову с плечами.",
            example = "הִיא עָנְדָה שַׁרְשֶׁרֶת זָהָב עַל הַצַּוָּאר.",
            exampleNative = "Она надела на צַוָּאר золотую цепочку.",
         fillInBlankExclusions = listOf(182225L)),
        WordEntity(
            id = 182225, setId = 1822, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_features",
            original = "סַנְטֵר", translation = "подбородок",
            transliteration = "сантэр",
            definition = "חֵלֶק תַּחְתּוֹן שֶׁל הַפָּנִים מִתַּחַת לַפֶּה.",
            definitionNative = "Нижняя часть лица, которая находится под ртом.",
            example = "יֵשׁ לוֹ צַלֶּקֶת קְטַנָּה עַל הַסַּנְטֵר מֵהַיַּלְדוּת.",
            exampleNative = "У него на סַנְטֵר маленький шрам с самого детства.",
         fillInBlankExclusions = listOf(182224L)),
    )
}
