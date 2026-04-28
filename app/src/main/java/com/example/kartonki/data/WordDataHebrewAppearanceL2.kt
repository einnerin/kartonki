package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Внешность и тело", level 2 (A2-B1).
 * Один сет × 25 слов. setId = 1823.
 *
 *  - 18 UNCOMMON + 7 RARE (2 смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      appearance_hairstyles      — причёски (хвост, чёлка, кудри, грива, стрижка-«ёжик»)
 *      appearance_expressions     — мимика (ухмылка, гримаса, прищур, подмигивание, нахмуренный взгляд)
 *      appearance_build_extra     — телосложение (коренастый, пухленький, жилистый, дюжий, болезненный)
 *      appearance_face_extra      — детали лица (ямочка, висок, затылок, румянец, скула)
 *      appearance_skin_marks_extra — отметины (татуировка, пирсинг, родинка, родимое пятно, веснушка)
 *  - Никудим везде. fillInBlankExclusions / isFillInBlankSafe не выставлены —
 *    заполнятся через FILL_IN_BLANK pipeline (см. `docs/claude/fill-in-blank-pipeline.md`).
 *  - Параллельный сет en-ru — 381 «Внешность и тело» (level 2). В he-ru
 *    подобраны эквиваленты тех же продвинутых концепций.
 *  - Дублей с set 1822 (L1) нет: проверены 25 слов L1.
 *  - Cross-topic совпадения (избегнуты):
 *      - זָקָן/זִיפִים/פֵּאוֹת/שָׂפָם — заняты в Barber (1736-1738) и Психологии (1141);
 *      - שָׁמֵן/רָזֶה/עָבֶה — заняты в Психологии (1141) и Иммигранте (1173);
 *      - שֵׂיבָה/תַּלְתַּלִּים/תַּסְפֹּרֶת — заняты в Barber и Batch9;
 *      - קְרִיצָה — занято в Batch27 (как глагол).
 *      Подобраны другие, незанятые ивритские слова.
 */
object WordDataHebrewAppearanceL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1823, languagePair = "he-ru", orderIndex = 1823,
            name = "Внешность и тело",
            description = "Причёски, мимика, телосложение и детали лица",
            topic = "Внешность и тело", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── appearance_hairstyles (5) ────────────────────────────────────
        WordEntity(
            id = 182301, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_hairstyles",
            original = "קוּקוּ", translation = "хвост (причёска)",
            transliteration = "куку",
            definition = "אֲסוּפַּת שֵׂעָר שֶׁקּוֹשְׁרִים מֵאָחוֹר עִם גּוּמִיָּה.",
            definitionNative = "Собранные сзади волосы, перехваченные резинкой.",
            example = "הִיא אָסְפָה אֶת הַשֵּׂעָר לְקוּקוּ לִפְנֵי הָאִמּוּן.",
            exampleNative = "Перед тренировкой она собрала волосы в קוּקוּ.",
        ),
        WordEntity(
            id = 182302, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_hairstyles",
            original = "פוֹנִי", translation = "чёлка",
            transliteration = "пони",
            definition = "שֵׂעָר קָצָר שֶׁיּוֹרֵד מֵהַחֵלֶק הַקִּדְמִי שֶׁל הָרֹאשׁ עַל הַמֶּצַח.",
            definitionNative = "Короткие волосы спереди, спадающие на лоб.",
            example = "הִיא הִסְתַּפְּרָה וְעַכְשָׁו יֵשׁ לָהּ פוֹנִי יָשָׁר.",
            exampleNative = "Она подстриглась — теперь у неё ровная פוֹנִי.",
         fillInBlankExclusions = listOf(182301L, 182303L, 182304L, 182305L)),
        WordEntity(
            id = 182303, setId = 1823, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_hairstyles",
            original = "בַּלּוֹרִית", translation = "чуб, хохол волос",
            transliteration = "балорит",
            definition = "צְרוֹר שֵׂעָר עֶלְיוֹן עַל הַמֶּצַח שֶׁבּוֹלֵט מֵרֹאשׁ הַתִּסְפֹּרֶת.",
            definitionNative = "Прядь волос на самой макушке надо лбом — выделяется в стрижке.",
            example = "הַיֶּלֶד הִשְׁאִיר בַּלּוֹרִית אֲרֻכָּה וְגִלַּח אֶת הַצְּדָדִים.",
            exampleNative = "Мальчик отрастил длинную בַּלּוֹרִית, а бока обрил.",
         fillInBlankExclusions = listOf(182301L, 182302L, 182304L, 182305L)),
        WordEntity(
            id = 182304, setId = 1823, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_hairstyles",
            original = "רַעְמָה", translation = "грива (густые волосы)",
            transliteration = "раама",
            definition = "שֵׂעָר עָבֶה וְגָדוֹל מְאוֹד שֶׁמַּקִּיף אֶת הָרֹאשׁ — כְּמוֹ שֶׁל אַרְיֵה.",
            definitionNative = "Очень густые и пышные волосы вокруг головы — как у льва.",
            example = "הָרוֹקֵר עָלָה לַבָּמָה עִם רַעְמָה שְׁחֹרָה וּפְרוּעָה.",
            exampleNative = "Рокер вышел на сцену с чёрной растрёпанной רַעְמָה.",
         fillInBlankExclusions = listOf(182301L, 182302L, 182303L, 182305L)),
        WordEntity(
            id = 182305, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_hairstyles",
            original = "קַרַחַת", translation = "лысина, плешь",
            transliteration = "карахат",
            definition = "אֵזוֹר בָּרֹאשׁ שֶׁבּוֹ אֵין שֵׂעָר — בְּדֶרֶךְ כְּלָל אֵצֶל גְּבָרִים מְבֻגָּרִים.",
            definitionNative = "Участок на голове без волос — обычно у пожилых мужчин.",
            example = "סַבָּא מַחְבִּיא אֶת הַקַּרַחַת מִתַּחַת לְכוֹבַע מַצְחִיָּה.",
            exampleNative = "Дедушка прячет קַרַחַת под бейсболкой.",
        ),

        // ─── appearance_expressions (5) ───────────────────────────────────
        WordEntity(
            id = 182306, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_expressions",
            original = "הַעֲוָיָה", translation = "гримаса",
            transliteration = "хаавая",
            definition = "תְּנוּעָה לֹא רְגִילָה שֶׁל הַפָּנִים שֶׁמַּרְאָה רֶגֶשׁ חָזָק אוֹ גֹּעַל.",
            definitionNative = "Необычное выражение лица, передающее сильное чувство или отвращение.",
            example = "הוּא עָשָׂה הַעֲוָיָה כְּשֶׁטָּעַם אֶת הַמָּרָק הַחָמוּץ.",
            exampleNative = "Попробовав кислый суп, он состроил הַעֲוָיָה.",
         fillInBlankExclusions = listOf(182307L, 182308L, 182309L, 182310L)),
        WordEntity(
            id = 182307, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_expressions",
            original = "גִּיחוּךְ", translation = "ухмылка, насмешливая улыбка",
            transliteration = "гихух",
            definition = "חִיּוּךְ קָטָן וּמְזַלְזֵל שֶׁמַּרְאֶה לַעַג אוֹ שְׁבִיעוּת רָצוֹן עַצְמִית.",
            definitionNative = "Лёгкая презрительная улыбка — выражает насмешку или самодовольство.",
            example = "אַחֲרֵי הַנִּצָּחוֹן הוּא הִסְתַּכֵּל עָלַי עִם גִּיחוּךְ קָטָן.",
            exampleNative = "После победы он посмотрел на меня с лёгким גִּיחוּךְ.",
        ),
        WordEntity(
            id = 182308, setId = 1823, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_expressions",
            original = "זְעָפָה", translation = "хмурый взгляд",
            transliteration = "зеафа",
            definition = "מַבָּט כּוֹעֵס שֶׁל מִי שֶׁמְּכַוֵּץ אֶת הַגַּבּוֹת וְאֶת הַמֶּצַח.",
            definitionNative = "Сердитый взгляд того, кто сводит брови и морщит лоб.",
            example = "הַמּוֹרֶה נָתַן לַתַּלְמִידִים הָרַעֲשָׁנִים זְעָפָה אֲרֻכָּה.",
            exampleNative = "Учитель долго смотрел на шумных учеников с זְעָפָה.",
         fillInBlankExclusions = listOf(182306L, 182307L, 182309L, 182310L)),
        WordEntity(
            id = 182309, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_expressions",
            original = "מִצְמוּץ", translation = "подмигивание, моргание",
            transliteration = "мицмуц",
            definition = "סְגִירָה וּפְתִיחָה מְהִירָה שֶׁל הָעַיִן — לְעִתִּים סִימָן יְדִידוּתִי.",
            definitionNative = "Быстрое закрывание и открывание глаза — иногда дружеский знак.",
            example = "סַבָּא נָתַן לִי מִצְמוּץ קָטָן כְּשֶׁאַף אֶחָד לֹא הִסְתַּכֵּל.",
            exampleNative = "Дедушка тихо подарил мне מִצְמוּץ, пока никто не смотрел.",
         fillInBlankExclusions = listOf(182306L, 182307L, 182308L, 182310L)),
        WordEntity(
            id = 182310, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_expressions",
            original = "מַבָּט", translation = "взгляд",
            transliteration = "мабат",
            definition = "פְּעֻלָּה שֶׁל הִסְתַּכְּלוּת — הַדֶּרֶךְ שֶׁבָּהּ אָדָם רוֹאֶה אוֹ בּוֹחֵן מַשֶּׁהוּ.",
            definitionNative = "Действие смотрения — то, как человек глядит или изучает что-либо.",
            example = "הִיא שָׁלְחָה אֵלָיו מַבָּט קַר מֵעֵבֶר לַשֻּׁלְחָן.",
            exampleNative = "Она бросила в него холодный מַבָּט через стол.",
         fillInBlankExclusions = listOf(182306L, 182307L, 182308L, 182309L)),

        // ─── appearance_build_extra (5) ───────────────────────────────────
        WordEntity(
            id = 182311, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "appearance_build_extra",
            original = "חָסוֹן", translation = "крепкий, дюжий",
            transliteration = "хасон",
            definition = "מִי שֶׁבָּנוּי גָּדוֹל וְכָבֵד וְנִרְאֶה חָזָק וְעָמִיד.",
            definitionNative = "Крупно сложённый и тяжёлый — выглядит крепким и выносливым.",
            example = "שׁוֹמֵר חָסוֹן עָמַד בִּשְׁתִיקָה לְיַד הַכְּנִיסָה לַמּוֹעֲדוֹן.",
            exampleNative = "У входа в клуб молча стоял חָסוֹן охранник.",
         fillInBlankExclusions = listOf(182312L, 182313L, 182314L, 182315L)),
        WordEntity(
            id = 182312, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "appearance_build_extra",
            original = "מוּצָק", translation = "плотный, коренастый",
            transliteration = "муцак",
            definition = "מִי שֶׁגּוּפוֹ נָמוּךְ וּצָפוּף, רָחָב וְחָזָק לְמַרְאֶה.",
            definitionNative = "Тот, кто невысок и плотно сбит — широкий и крепкий на вид.",
            example = "הָאִכָּר הַמּוּצָק הֵרִים שַׂק כָּבֵד בְּיָד אַחַת.",
            exampleNative = "מוּצָק фермер поднял тяжёлый мешок одной рукой.",
        ),
        WordEntity(
            id = 182313, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "appearance_build_extra",
            original = "תְּפוּחַ", translation = "пухленький",
            transliteration = "тафуах",
            definition = "מִי שֶׁמְּעַט מַשְׁמִין בְּצוּרָה רַכָּה וּמְתוּקָה — לִפְעָמִים עַל יְלָדִים.",
            definitionNative = "Слегка полный — мягко и мило, иногда о маленьких детях.",
            example = "הַתִּינוֹק הַתָּפוּחַ צָחַק וְהֵנִיף אֶת הַיָּדַיִם הַקְּטַנּוֹת.",
            exampleNative = "תְּפוּחַ малыш засмеялся и замахал ручками.",
        ),
        WordEntity(
            id = 182314, setId = 1823, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_build_extra",
            original = "כָּחוּשׁ", translation = "тощий, костлявый",
            transliteration = "кахуш",
            definition = "מִי שֶׁרָזֶה מִדַּי וְנִרְאֶה חַלָּשׁ — כְּאִלּוּ רוֹאִים אֶת הָעֲצָמוֹת.",
            definitionNative = "Слишком худой и хилый на вид — будто видны кости.",
            example = "חָתוּל רְחוֹב כָּחוּשׁ הִתְקָרֵב לַשֻּׁלְחָן וְחִכָּה לְפֵרוּרִים.",
            exampleNative = "כָּחוּשׁ уличный кот подошёл к столу и ждал крошек.",
        ),
        WordEntity(
            id = 182315, setId = 1823, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_build_extra",
            original = "חוֹלָנִי", translation = "болезненный, хилый на вид",
            transliteration = "холани",
            definition = "מִי שֶׁנִּרְאֶה חַלָּשׁ וְלֹא בָּרִיא — חִוֵּר וְעָיֵף בְּלִי הֶפְסֵק.",
            definitionNative = "Тот, кто выглядит слабым и нездоровым — бледный и постоянно усталый.",
            example = "אַחֲרֵי שָׁבוּעַ בְּלִי שֵׁנָה הוּא נִרְאָה חוֹלָנִי וְעָיֵף.",
            exampleNative = "После недели без сна он выглядел חוֹלָנִי и измученным.",
         fillInBlankExclusions = listOf(182311L, 182312L, 182313L, 182314L)),

        // ─── appearance_face_extra (5) ────────────────────────────────────
        WordEntity(
            id = 182316, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_face_extra",
            original = "גּוּמָה", translation = "ямочка (на щеке/подбородке)",
            transliteration = "гума",
            definition = "שְׁקַע קָטָן וְעָגוֹל בַּלֶּחִי אוֹ בַּסַּנְטֵר שֶׁמּוֹפִיעַ בְּעִקָּר עִם חִיּוּךְ.",
            definitionNative = "Маленькая круглая впадинка на щеке или подбородке — обычно появляется при улыбке.",
            example = "כְּשֶׁהוּא צוֹחֵק מוֹפִיעָה גּוּמָה חֲמוּדָה בַּלֶּחִי הַיְּמָנִית.",
            exampleNative = "Когда он смеётся, на правой щеке появляется милая גּוּמָה.",
         fillInBlankExclusions = listOf(182317L, 182318L, 182319L, 182320L, 182323L)),
        WordEntity(
            id = 182317, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_face_extra",
            original = "רַקָּה", translation = "висок",
            transliteration = "рака",
            definition = "אֵזוֹר רַךְ בְּצַד הָרֹאשׁ בֵּין הָעַיִן וְהָאֹזֶן.",
            definitionNative = "Мягкий участок сбоку головы — между глазом и ухом.",
            example = "הוּא לִחֵץ עַל הָרַקָּה בְּגַלַּל כְּאֵב רֹאשׁ חָזָק.",
            exampleNative = "Он надавил на רַקָּה из-за сильной головной боли.",
         fillInBlankExclusions = listOf(182316L, 182318L, 182319L, 182320L)),
        WordEntity(
            id = 182318, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_face_extra",
            original = "עֹרֶף", translation = "затылок",
            transliteration = "ореф",
            definition = "הַחֵלֶק הָאֲחוֹרִי שֶׁל הָרֹאשׁ — מִתַּחַת לַשֵּׂעָר וּמֵעַל לַצַּוָּאר.",
            definitionNative = "Задняя часть головы — под волосами и над шеей.",
            example = "הוּא הִרְגִּישׁ טִפַּת גֶּשֶׁם קָרָה נוֹפֶלֶת עַל הָעֹרֶף.",
            exampleNative = "Он почувствовал, как холодная капля дождя упала на עֹרֶף.",
         fillInBlankExclusions = listOf(182316L, 182317L, 182319L, 182320L)),
        WordEntity(
            id = 182319, setId = 1823, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_face_extra",
            original = "סֹמֶק", translation = "румянец",
            transliteration = "сомэк",
            definition = "צֶבַע אָדֹם רַךְ עַל הַלְּחָיַיִם — מֵרֹב בּוּשָׁה, שִׂמְחָה אוֹ קֹר.",
            definitionNative = "Мягкий красноватый оттенок на щеках — от смущения, радости или холода.",
            example = "סֹמֶק קַל עָלָה בִּפְנֵי הַיַּלְדָּה כְּשֶׁשִּׁבְּחוּ אוֹתָהּ.",
            exampleNative = "Когда девочку похвалили, у неё на лице проступил лёгкий סֹמֶק.",
         fillInBlankExclusions = listOf(182316L, 182317L, 182318L, 182320L, 182325L)),
        WordEntity(
            id = 182320, setId = 1823, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_face_extra",
            original = "עֶצֶם הַלֶּחִי", translation = "скула",
            transliteration = "эцем а-лехи",
            definition = "הָעֶצֶם הַבּוֹלֶטֶת מִתַּחַת לָעַיִן שֶׁמְּעַצֶּבֶת אֶת צוּרַת הַפָּנִים.",
            definitionNative = "Выступающая кость под глазом — формирует овал лица.",
            example = "לַדּוּגְמָנִית יֵשׁ עֶצֶם הַלֶּחִי גְּבוֹהָה וּבוֹלֶטֶת.",
            exampleNative = "У модели высокая выступающая עֶצֶם הַלֶּחִי.",
         fillInBlankExclusions = listOf(182316L, 182317L, 182318L, 182319L)),

        // ─── appearance_skin_marks_extra (5) ──────────────────────────────
        WordEntity(
            id = 182321, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_skin_marks_extra",
            original = "קַעְקַע", translation = "татуировка",
            transliteration = "каака",
            definition = "צִיּוּר אוֹ מִלָּה שֶׁמַּכְנִיסִים לְתוֹךְ הָעוֹר בְּדְיוֹ — נִשְׁאָר לְכָל הַחַיִּים.",
            definitionNative = "Рисунок или слово, нанесённые чернилами под кожу — на всю жизнь.",
            example = "הִיא עָשְׂתָה קַעְקַע קָטָן שֶׁל כּוֹכָב עַל פֶּרֶק הַיָּד.",
            exampleNative = "Она сделала маленькую קַעְקַע в виде звезды на запястье.",
         fillInBlankExclusions = listOf(182322L, 182323L, 182324L, 182325L)),
        WordEntity(
            id = 182322, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_skin_marks_extra",
            original = "פִּירְסִינְג", translation = "пирсинг",
            transliteration = "пирсинг",
            definition = "חוֹר קָטָן בָּעוֹר שֶׁמַּכְנִיסִים אֵלָיו טַבַּעַת אוֹ תַּכְשִׁיט קָטָן.",
            definitionNative = "Маленькое отверстие в коже — туда вставляют колечко или мелкое украшение.",
            example = "אִמּוֹ כָּעֲסָה עַל הַפִּירְסִינְג הֶחָדָשׁ בַּגַּבָּה שֶׁלּוֹ.",
            exampleNative = "Мама рассердилась на новый פִּירְסִינְג у него в брови.",
         fillInBlankExclusions = listOf(182321L, 182323L, 182324L, 182325L)),
        WordEntity(
            id = 182323, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_skin_marks_extra",
            original = "שֻׁמָּה", translation = "родинка",
            transliteration = "шума",
            definition = "נְקֻדָּה חוּמָה אוֹ שְׁחֹרָה קְטַנָּה עַל הָעוֹר שֶׁאָדָם נוֹלָד אִתָּהּ אוֹ צוֹמֵחַ.",
            definitionNative = "Маленькая коричневая или чёрная точка на коже — врождённая или появляется со временем.",
            example = "יֵשׁ לוֹ שֻׁמָּה קְטַנָּה לְיַד הַשָּׂפָה שֶׁמַּזְכִּירָה כּוֹכָב.",
            exampleNative = "У него возле губы маленькая שֻׁמָּה — похожа на звёздочку.",
         fillInBlankExclusions = listOf(182316L, 182321L, 182322L, 182324L, 182325L)),
        WordEntity(
            id = 182324, setId = 1823, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "appearance_skin_marks_extra",
            original = "כֶּתֶם לֵדָה", translation = "родимое пятно",
            transliteration = "кэтэм лэда",
            definition = "סִימָן צִבְעוֹנִי עַל הָעוֹר שֶׁיֵּשׁ לְאָדָם מֵרֶגַע הוּלַּדְתּוֹ.",
            definitionNative = "Цветной знак на коже, который есть у человека с самого рождения.",
            example = "יֵשׁ לָהּ כֶּתֶם לֵדָה זָעִיר בְּצוּרַת לֵב עַל הַכָּתֵף.",
            exampleNative = "У неё на плече крошечное כֶּתֶם לֵדָה в форме сердечка.",
         fillInBlankExclusions = listOf(182321L, 182322L, 182323L, 182325L)),
        WordEntity(
            id = 182325, setId = 1823, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_skin_marks_extra",
            original = "נֶמֶשׁ", translation = "веснушка",
            transliteration = "нэмэш",
            definition = "נְקֻדָּה חוּמָה קַלָּה וּקְטַנָּה עַל הָעוֹר — מוֹפִיעָה בְּעִקָּר בַּשֶּׁמֶשׁ.",
            definitionNative = "Светло-коричневая мелкая точка на коже — особенно заметна на солнце.",
            example = "בַּקַּיִץ מוֹפִיעִים לָהּ נֶמֶשׁ עַל הָאַף וְהַלְּחָיַיִם.",
            exampleNative = "Летом у неё на носу и щеках появляется נֶמֶשׁ.",
        ),
    )
}
