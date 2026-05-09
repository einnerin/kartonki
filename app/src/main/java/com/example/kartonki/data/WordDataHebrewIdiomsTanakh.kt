package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Идиомы и поговорки иврита", level 3 (B2/C1).
 * Один сет × 25 слов. setId = 1893. 6-й набор темы Идиомы (после L1-L5).
 *
 *  - 13 RARE + 12 EPIC. Танахические выражения, перешедшие из библейского
 *    текста в современный иврит — речь, газеты, литература, политика.
 *  - 5 семантических групп по 5 слов:
 *      idioms_tanakh_virtues_character — добродетели и образ человека
 *      idioms_tanakh_destiny_time      — судьба, время, поколения
 *      idioms_tanakh_creation_world    — мир, творение, природа
 *      idioms_tanakh_morality_judgment — мораль, осуждение, миссия
 *      idioms_tanakh_speech_wisdom     — речь, мудрость, благословения
 *  - Все pos = "phrase".
 *  - Никудим везде, включая саму идиому в `original` — это библейская лексика.
 *  - `transliteration` — кириллицей вся фраза целиком.
 *  - В `example` целевая идиома verbatim в форме, совпадающей с original
 *    (без префиксов שֶׁ-, ב-, ל-).
 *  - `exampleNative` — русская калька с самой идиомой в иврите внутри.
 *
 *  Все 25 фраз проверены grep'ом по `original = "..."` против всех существующих
 *  he-ru сетов 2026-05-09. Точных дублей нет. Существующие в L4/L5 танахические
 *  идиомы (אֶבֶן יְסוֹד, אֶבֶן רֹאשָׁה, בָּשָׂר מִבְּשָׂרוֹ, בְּצֶלֶם אֱלֹהִים,
 *  נֵר לְרַגְלִי, רוֹאֶה אֶת הַנּוֹלָד, קוֹל קוֹרֵא בַּמִּדְבָּר, נוֹשֵׂא אֶת הַדֶּגֶל,
 *  סוֹף מַעֲשֶׂה בְּמַחֲשָׁבָה תְּחִלָּה, אֵין חָדָשׁ תַּחַת הַשֶּׁמֶשׁ, עַל בְּלִימָה,
 *  בְּעֵרֶב יוֹמוֹ, מִבְּשָׂרִי אֶחֱזֶה) сюда не включаются, чтобы не плодить дубли.
 */
object WordDataHebrewIdiomsTanakh {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1893, languagePair = "he-ru", orderIndex = 1893,
            name = "Идиомы и поговорки иврита",
            description = "Танахические выражения в современной речи",
            topic = "Идиомы и поговорки иврита", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── idioms_tanakh_virtues_character (5) ─────────────────────────
        WordEntity(
            id = 189301, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_virtues_character",
            original = "אֵשֶׁת חַיִל", translation = "доблестная жена (достойная женщина)",
            transliteration = "эшет хаиль",
            definition = "אִשָּׁה חֲכָמָה וּמְסוּרָה — דְּמוּת מוֹפֵת מִסֵּפֶר מִשְׁלֵי.",
            definitionNative = "Мудрая и преданная женщина — образ из книги Притч (31:10). Дословно: «жена доблести».",
            example = "סָבָתִי הָיְתָה אֵשֶׁת חַיִל אֲמִיתִּית בְּכָל הַחַיִּים שֶׁלָּהּ.",
            exampleNative = "Бабушка была настоящей אֵשֶׁת חַיִל — всю жизнь."
        , fillInBlankExclusions = listOf(189302L, 189303L, 189304L, 189305L)),
        WordEntity(
            id = 189302, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_virtues_character",
            original = "אִישׁ צַדִּיק", translation = "праведник (праведный человек)",
            transliteration = "иш цадик",
            definition = "אָדָם בַּעַל מוּסָר עָמֹק וְיֹשֶׁר פְּנִימִי — מוֹפֵת לִסְבִיבָתוֹ.",
            definitionNative = "Человек глубоко нравственный и внутренне честный — образец для окружения. Дословно: «человек праведный».",
            example = "כֻּלָּם בַּשְּׁכוּנָה כִּבְּדוּ אוֹתוֹ כְּאִישׁ צַדִּיק שֶׁל הַדּוֹר.",
            exampleNative = "Весь район уважал его как אִישׁ צַדִּיק своего времени."
        , fillInBlankExclusions = listOf(189301L, 189303L, 189304L, 189305L)),
        WordEntity(
            id = 189303, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_virtues_character",
            original = "בְּכָל לְבָבְךָ", translation = "всем сердцем (всей душой)",
            transliteration = "бэ-холь левавха",
            definition = "בִּמְסִירוּת מְלֵאָה וּבְלִי הִסּוּס — מִדִּבְרֵי הַשְּׁמַע בִּדְבָרִים.",
            definitionNative = "С полной самоотдачей и без колебаний — из текста Шма (Втор 6:5). Дословно: «всем сердцем твоим».",
            example = "הוּא נִכְנַס לַמִּשִּׂימָה הַחֲדָשָׁה בְּכָל לְבָבְךָ וְלֹא שָׁמַר עַל עַצְמוֹ.",
            exampleNative = "Он взялся за новое дело בְּכָל לְבָבְךָ — себя не жалея."
        ),
        WordEntity(
            id = 189304, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_virtues_character",
            original = "לֵב חָדָשׁ", translation = "обновлённое сердце (внутреннее перерождение)",
            transliteration = "лев хадаш",
            definition = "שִׁנּוּי פְּנִימִי עָמֹק שֶׁמַּתְחִיל גִּישָׁה אֲחֶרֶת לַחַיִּים — נְבוּאַת יְחֶזְקֵאל.",
            definitionNative = "Глубокая внутренняя перемена, начало иного отношения к жизни — пророчество Иезекииля (36:26). Дословно: «новое сердце».",
            example = "אַחֲרֵי הַמַּחֲלָה הוּא חָזַר עִם לֵב חָדָשׁ לְגַמְרֵי לָעֲבוֹדָה.",
            exampleNative = "После болезни он вернулся к работе с לֵב חָדָשׁ — совсем другим."
        ),
        WordEntity(
            id = 189305, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_virtues_character",
            original = "כְּלֵי קֹדֶשׁ", translation = "служители (люди, посвящённые делу)",
            transliteration = "клей кодеш",
            definition = "אֲנָשִׁים שֶׁמְּשָׁרְתִים מַשֶּׁהוּ נֶעֱלָה — דָּת, מַדָּע, אָמָּנוּת.",
            definitionNative = "Люди, посвятившие себя высокой цели — религии, науке, искусству. Дословно: «священные сосуды».",
            example = "מוֹרִים וּרְבִיעִים נֶחְשָׁבִים כְּלֵי קֹדֶשׁ שֶׁל הַתַּרְבּוּת הָעִבְרִית.",
            exampleNative = "Учителя и врачи — это כְּלֵי קֹדֶשׁ нашей культуры."
        ),

        // ─── idioms_tanakh_destiny_time (5) ──────────────────────────────
        WordEntity(
            id = 189306, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_destiny_time",
            original = "עֵת לַעֲשׂוֹת", translation = "пришло время действовать",
            transliteration = "эт лаасот",
            definition = "הִגִּיעַ הָרֶגַע לַעֲבֹר מִמַּחֲשָׁבָה לִפְעֻלָּה — שָׁעַת מִבְחָן.",
            definitionNative = "Настал момент перейти от размышлений к делу — час испытания. Из псалма 119:126.",
            example = "אַחֲרֵי שָׁנִים שֶׁל וִכּוּחִים — עֵת לַעֲשׂוֹת וּלְהַחְלִיט.",
            exampleNative = "После лет дискуссий — עֵת לַעֲשׂוֹת, надо решать."
        , fillInBlankExclusions = listOf(189307L, 189308L, 189309L, 189310L)),
        WordEntity(
            id = 189307, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_destiny_time",
            original = "כְּהֶרֶף עַיִן", translation = "в мгновение ока (моментально)",
            transliteration = "кэ-hэрэф аин",
            definition = "מַשֶּׁהוּ קוֹרֶה בִּמְהִירוּת קִיצוֹנִית — בִּזְמַן קָצָר מְאֹד.",
            definitionNative = "Что-то происходит с предельной быстротой — за очень короткое время. Дословно: «как взмах века».",
            example = "הַסּוֹפָה בָּאָה כְּהֶרֶף עַיִן וְשִׁבְּרָה אֶת כָּל הָעֵצִים.",
            exampleNative = "Буря налетела כְּהֶרֶף עַיִן и поломала все деревья."
        , fillInBlankExclusions = listOf(189306L, 189308L, 189309L, 189310L)),
        WordEntity(
            id = 189308, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_destiny_time",
            original = "מִדּוֹר לְדוֹר", translation = "из поколения в поколение",
            transliteration = "ми-дор ле-дор",
            definition = "עוֹבֵר בְּיֻרְשָׁה דֶּרֶךְ הַמִּשְׁפָּחָה לְאֹרֶךְ זְמַן רַב.",
            definitionNative = "Передаётся по наследству через семью на протяжении долгого времени. Из языка Псалмов и Пятикнижия.",
            example = "הַסִּפּוּר הַזֶּה עוֹבֵר אֶצְלֵנוּ מִדּוֹר לְדוֹר כְּבָר מֵאָה שָׁנָה.",
            exampleNative = "Эту историю передают у нас מִדּוֹר לְדוֹר уже сто лет."
        , fillInBlankExclusions = listOf(189306L, 189307L, 189309L, 189310L)),
        WordEntity(
            id = 189309, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_destiny_time",
            original = "יָמִים יָמִימָה", translation = "изо дня в день (постоянно, лит.)",
            transliteration = "ямим ямима",
            definition = "מַשֶּׁהוּ קוֹרֶה בְּהֶמְשֵׁכִיוּת — שִׁמּוּשׁ סִפְרוּתִי גָּבוֹהַּ.",
            definitionNative = "Что-то происходит непрерывно, изо дня в день — высокий литературный регистр (Суд 11:40, Иер).",
            example = "הוּא הָיָה יוֹשֵׁב בַּסִּפְרִיָּה יָמִים יָמִימָה וְכוֹתֵב.",
            exampleNative = "Он сидел в библиотеке יָמִים יָמִימָה и писал."
        , fillInBlankExclusions = listOf(189306L, 189307L, 189308L, 189310L)),
        WordEntity(
            id = 189310, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_destiny_time",
            original = "בְּרֹב יָמִים", translation = "по прошествии многих дней (с годами)",
            transliteration = "бэ-ров ямим",
            definition = "כַּעֲבוֹר זְמַן רַב — אַחֲרֵי שֶׁחָלְפוּ הַרְבֵּה שָׁנִים מֵאָז הַתְּחָלָה.",
            definitionNative = "Спустя продолжительное время — после того как прошло много лет с начала. Дословно: «во множестве дней».",
            example = "בְּרֹב יָמִים הָאֲגָדָה הַזֹּאת הָפְכָה לְמַסֹּרֶת אֲמִתִּית.",
            exampleNative = "בְּרֹב יָמִים эта легенда стала настоящим преданием."
        , fillInBlankExclusions = listOf(189306L, 189307L, 189308L, 189309L)),

        // ─── idioms_tanakh_creation_world (5) ────────────────────────────
        WordEntity(
            id = 189311, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_creation_world",
            original = "תֹּהוּ וָבֹהוּ", translation = "хаос (полная неразбериха)",
            transliteration = "тоhу ва-воhу",
            definition = "מַצָּב שֶׁל בִּלְבּוּל מֻחְלָט וְאִי-סֵדֶר גָּמוּר — מִתְּחִלַּת סֵפֶר בְּרֵאשִׁית.",
            definitionNative = "Состояние полного беспорядка и хаоса — из начала книги Бытия (1:2). Дословно: «безвидно и пусто».",
            example = "אַחֲרֵי הַמְּסִבָּה הַחֶדֶר הָיָה תֹּהוּ וָבֹהוּ אֲמִתִּי.",
            exampleNative = "После вечеринки в комнате был настоящий תֹּהוּ וָבֹהוּ."
        ),
        WordEntity(
            id = 189312, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_creation_world",
            original = "אֶרֶץ זָבַת חָלָב וּדְבַשׁ",
            translation = "земля, где течёт молоко и мёд (благодатный край)",
            transliteration = "эрец завать халав у-дваш",
            definition = "מָקוֹם פּוֹרֶה וְעָשִׁיר בְּטֶבַע — תֵּאוּר אֶרֶץ יִשְׂרָאֵל בַּתּוֹרָה.",
            definitionNative = "Плодородное и природно богатое место — описание Земли Израиля в Торе (Исх 3:8). Дословно: «земля, текущая молоком и мёдом».",
            example = "תֵּל אָבִיב הָיְתָה בְּעֵינָיו אֶרֶץ זָבַת חָלָב וּדְבַשׁ אֲמִתִּית.",
            exampleNative = "Тель-Авив был для него настоящей אֶרֶץ זָבַת חָלָב וּדְבַשׁ."
        ),
        WordEntity(
            id = 189313, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_creation_world",
            original = "כְּחוֹל הַיָּם", translation = "как песок морской (бесчисленно)",
            transliteration = "кэ-холь hа-ям",
            definition = "כַּמּוּת עֲצוּמָה שֶׁאִי אֶפְשָׁר לִסְפֹּר — דִּימּוּי קָבוּעַ בַּתַּנַ\"ךְ.",
            definitionNative = "Огромное количество, которое невозможно сосчитать — постоянное сравнение в Танахе. Дословно: «как песок морской».",
            example = "הָיוּ שָׁם אֲנָשִׁים כְּחוֹל הַיָּם — אִי אֶפְשָׁר הָיָה לִסְפֹּר.",
            exampleNative = "Людей там было כְּחוֹל הַיָּם — пересчитать невозможно."
        , fillInBlankExclusions = listOf(189311L, 189312L, 189314L, 189315L)),
        WordEntity(
            id = 189314, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_creation_world",
            original = "עֵץ הַחַיִּים", translation = "древо жизни (источник, основа)",
            transliteration = "эц hа-хаим",
            definition = "מַשֶּׁהוּ שֶׁמַּקְנֶה כֹּחַ וּמַשְׁמָעוּת לַחַיִּים — מֵטַפוֹרָה מֵגַן עֵדֶן.",
            definitionNative = "То, что даёт жизни силу и смысл — метафора из райского сада (Быт 2:9). Дословно: «древо жизни».",
            example = "הַתּוֹרָה הִיא עֵץ הַחַיִּים בִּשְׁבִיל הַעַם הַיְּהוּדִי לְכָל הַזְּמַנִּים.",
            exampleNative = "Тора — это עֵץ הַחַיִּים для еврейского народа во все времена."
        , fillInBlankExclusions = listOf(189311L, 189312L, 189313L, 189315L)),
        WordEntity(
            id = 189315, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_creation_world",
            original = "עֵץ הַדַּעַת", translation = "древо познания (соблазн знания)",
            transliteration = "эц hа-даат",
            definition = "סֵמֶל לִידִיעָה אֲסוּרָה אוֹ מְסֻכֶּנֶת — מֵטַפוֹרָה מִסִּפּוּר אָדָם וְחַוָּה.",
            definitionNative = "Символ запретного или опасного знания — метафора из истории Адама и Евы (Быт 2:17). Дословно: «древо познания».",
            example = "הָאִינְטֶרְנֶט הוּא עֵץ הַדַּעַת שֶׁל הַדּוֹר הַצָּעִיר.",
            exampleNative = "Интернет — это עֵץ הַדַּעַת нынешнего молодого поколения."
        , fillInBlankExclusions = listOf(189311L, 189312L, 189313L, 189314L)),

        // ─── idioms_tanakh_morality_judgment (5) ─────────────────────────
        WordEntity(
            id = 189316, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_morality_judgment",
            original = "הֲבֵל הֲבָלִים", translation = "суета сует (бессмыслица)",
            transliteration = "hэвель hавалим",
            definition = "תֵּאוּר חַיִּים אוֹ מַעֲשֶׂה חַסְרֵי תַּכְלִית וְעֶרֶךְ — פְּתִיחַת קֹהֶלֶת.",
            definitionNative = "Описание жизни или дела как лишённых смысла и ценности — открывает книгу Экклезиаста (1:2). Дословно: «суета сует».",
            example = "הוּא טוֹעֵן שֶׁכָּל הַתְּחָרוּת עַל הַכֶּסֶף הִיא הֲבֵל הֲבָלִים.",
            exampleNative = "Он считает, что вся гонка за деньгами — это הֲבֵל הֲבָלִים."
        , fillInBlankExclusions = listOf(189317L, 189318L, 189319L, 189320L)),
        WordEntity(
            id = 189317, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_morality_judgment",
            original = "אֵין נָבִיא בְּעִירוֹ", translation = "нет пророка в своём отечестве",
            transliteration = "эйн нави бэ-иро",
            definition = "אֲנָשִׁים מְזַלְזְלִים בִּמְצֻיָּן שֶׁבָּא מֵהַסְּבִיבָה הַקְּרוֹבָה שֶׁלָּהֶם.",
            definitionNative = "Люди не ценят выдающегося человека из ближнего окружения — концепт из Танаха и Талмуда.",
            example = "הוּא הִצְלִיחַ בְּחוּל אַחֲרֵי שֶׁבָּאָרֶץ אֵין נָבִיא בְּעִירוֹ.",
            exampleNative = "Он добился успеха за границей — אֵין נָבִיא בְּעִירוֹ."
        ),
        WordEntity(
            id = 189318, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_morality_judgment",
            original = "אוֹר לַגּוֹיִם", translation = "свет народам (нравственный пример)",
            transliteration = "ор ла-гойим",
            definition = "מוֹפֵת מוּסָרִי אוֹ תַּרְבּוּתִי לְאֻמּוֹת אֲחֵרוֹת — צִיטוּט מִישַׁעְיָהוּ.",
            definitionNative = "Нравственный или культурный образец для других народов — цитата из Исайи (49:6). Дословно: «свет народам».",
            example = "הוּא חָלַם שֶׁיִּשְׂרָאֵל תִּהְיֶה אוֹר לַגּוֹיִם בִּזְכוּת הַחָכְמָה שֶׁלָּהּ.",
            exampleNative = "Он мечтал, чтобы Израиль стал אוֹר לַגּוֹיִם своей мудростью."
        , fillInBlankExclusions = listOf(189316L, 189317L, 189319L, 189320L)),
        WordEntity(
            id = 189319, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_morality_judgment",
            original = "מַעֲשֵׂה שָׂטָן", translation = "козни лукавого (роковое стечение)",
            transliteration = "маасэ сатан",
            definition = "מַשֶּׁהוּ רַע שֶׁקּוֹרֶה כְּאִלּוּ בְּכַוָּנָה זֵדוֹנִית — מַזָּל בִּישׁ קִיצוֹנִי.",
            definitionNative = "Плохое событие, словно произошедшее со злым умыслом — крайне дурное стечение. Дословно: «дело сатаны».",
            example = "הָרֶכֶב הִתְקַלְקֵל יוֹם לִפְנֵי הַחֲתֻנָּה — מַעֲשֵׂה שָׂטָן מַמָּשׁ.",
            exampleNative = "Машина сломалась за день до свадьбы — מַעֲשֵׂה שָׂטָן, не иначе."
        , fillInBlankExclusions = listOf(189316L, 189317L, 189318L, 189320L)),
        WordEntity(
            id = 189320, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_morality_judgment",
            original = "עַל קִדּוּשׁ הַשֵּׁם", translation = "во имя высшей идеи (за принципы)",
            transliteration = "аль кидуш hа-шем",
            definition = "לְמַעַן עִקָּרוֹן עֶלְיוֹן — מוּכָן לְהַקְרִיב אֶת עַצְמוֹ לְמַעַן הָאֱמוּנָה.",
            definitionNative = "Ради высшего принципа — готовность пожертвовать собой во имя веры. Талмудический термин.",
            example = "הוּא הִקְרִיב אֶת הַקַּרְיֶרָה עַל קִדּוּשׁ הַשֵּׁם וְלֹא הִתְחָרֵט.",
            exampleNative = "Он пожертвовал карьерой עַל קִדּוּשׁ הַשֵּׁם — и не пожалел."
        , fillInBlankExclusions = listOf(189316L, 189317L, 189318L, 189319L)),

        // ─── idioms_tanakh_speech_wisdom (5) ─────────────────────────────
        WordEntity(
            id = 189321, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_speech_wisdom",
            original = "טוֹב שֵׁם מִשֶּׁמֶן טוֹב",
            translation = "доброе имя дороже благовония (репутация важнее)",
            transliteration = "тов шем ми-шемен тов",
            definition = "מוֹנִיטִין אַמִּיץ חָשׁוּב יוֹתֵר מֵרְכוּשׁ יָקָר — מִשְׁפַּט קֹהֶלֶת.",
            definitionNative = "Прочная репутация важнее любого богатства — изречение из Экклезиаста (7:1). Дословно: «имя доброе лучше масла доброго».",
            example = "טוֹב שֵׁם מִשֶּׁמֶן טוֹב — לָכֵן הוּא לֹא מַסְכִּים לַעֲסָקִים מַחְשִׁידִים.",
            exampleNative = "טוֹב שֵׁם מִשֶּׁמֶן טוֹב — поэтому он не идёт на сомнительные сделки."
        , fillInBlankExclusions = listOf(189322L, 189323L, 189324L, 189325L)),
        WordEntity(
            id = 189322, setId = 1893, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_tanakh_speech_wisdom",
            original = "אַשְׁרֵי הָאִישׁ", translation = "блажен муж (счастлив тот, кто)",
            transliteration = "ашрей hа-иш",
            definition = "פְּתִיחָה לִתְהִלָּה לְאָדָם הוֹלֵךְ בְּדֶרֶךְ נְכוֹנָה — מִתְּהִלִּים פֶּרֶק א.",
            definitionNative = "Зачин для похвалы человеку, идущему верным путём — из псалма 1:1. Дословно: «счастлив человек, который…».",
            example = "אַשְׁרֵי הָאִישׁ שֶׁמּוֹצֵא עֲבוֹדָה אֲהוּבָה וּמְשַׁלֶּמֶת.",
            exampleNative = "אַשְׁרֵי הָאִישׁ, что нашёл любимую и оплачиваемую работу."
        ),
        WordEntity(
            id = 189323, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_speech_wisdom",
            original = "פֵּשֶׁר הַדָּבָר", translation = "суть дела (истинный смысл)",
            transliteration = "пешер hа-давар",
            definition = "הַמַּשְׁמָעוּת הָעֲמֻקָּה וְהַנְּכוֹנָה שֶׁל מַצָּב אוֹ מִקְרֶה — מֵהַסֵּפֶר קֹהֶלֶת.",
            definitionNative = "Глубокий и подлинный смысл ситуации или события — выражение из Экклезиаста (8:1). Дословно: «толкование дела».",
            example = "רַק אַחֲרֵי שָׁעוֹת שֶׁל בִּדִּיקָה הֵבַנּוּ אֶת פֵּשֶׁר הַדָּבָר.",
            exampleNative = "Только после часов проверки мы поняли פֵּשֶׁר הַדָּבָר."
        , fillInBlankExclusions = listOf(189321L, 189322L, 189324L, 189325L)),
        WordEntity(
            id = 189324, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_speech_wisdom",
            original = "סְעוּדַת מִצְוָה", translation = "праздничная трапеза (по торжественному поводу)",
            transliteration = "сэуда́т мицва",
            definition = "אֲרוּחָה חֲגִיגִית הַקְּשׁוּרָה לְמַעֲמָד דָּתִי אוֹ מִשְׁפַּחְתִּי חָשׁוּב.",
            definitionNative = "Торжественный обед, связанный с религиозным или семейным событием. Концепт из Талмуда. Дословно: «трапеза заповеди».",
            example = "אַחֲרֵי הַבְּרִית הַמִּשְׁפָּחָה עָרְכָה סְעוּדַת מִצְוָה גְּדוֹלָה לְכֻלָּם.",
            exampleNative = "После брит-милы семья устроила большую סְעוּדַת מִצְוָה для всех."
        , fillInBlankExclusions = listOf(189321L, 189322L, 189323L, 189325L)),
        WordEntity(
            id = 189325, setId = 1893, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "idioms_tanakh_speech_wisdom",
            original = "שֶׁבַח וָהוֹדָיָה", translation = "хвала и благодарение",
            transliteration = "шевах вэ-hодая",
            definition = "בִּטּוּי שֶׁל הַכָּרַת תּוֹדָה עֲמֻקָּה לְכֹחַ עֶלְיוֹן — נֻסְחָה לִיטוּרְגִית.",
            definitionNative = "Выражение глубокой признательности высшим силам — литургическая формула. Дословно: «хвала и благодарность».",
            example = "כֻּלָּם נֶעֶמְדוּ לִשְׁעָה שֶׁל שֶׁבַח וָהוֹדָיָה אַחֲרֵי הַנֵּס.",
            exampleNative = "Все встали на час שֶׁבַח וָהוֹדָיָה после случившегося чуда."
        , fillInBlankExclusions = listOf(189321L, 189322L, 189323L, 189324L)),
    )
}
