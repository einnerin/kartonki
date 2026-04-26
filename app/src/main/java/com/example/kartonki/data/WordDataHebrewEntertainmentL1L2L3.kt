package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Развлечения и досуг" (levels 1-3).
 *
 * Set 1733: «Развлечения и досуг» — основы (L1, COMMON+UNCOMMON):
 *           игры, кино, праздники, детские забавы, шутки.
 * Set 1734: «Развлечения и досуг» — продвинутые (L2, UNCOMMON+RARE):
 *           жанры, события, гейминг, стриминг, фан-культура.
 * Set 1735: «Развлечения и досуг» — углублённые (L3, RARE+EPIC):
 *           продакшн, киноязык, гейм-дизайн, индустрия и фандом.
 *
 * Слова не пересекаются с темой «Культура и искусство» в иврите
 * (наборы 1071, 1072, 1076, 1184, 1185, 1186, 1704). Cross-topic
 * совпадения с другими темами (Технологии, Лингвистика, Семья, Город,
 * Транспорт и т. д.) допустимы по правилу проекта.
 *
 * Распределение редкостей:
 *   Set 1733: 15 COMMON + 10 UNCOMMON.
 *   Set 1734: 16 UNCOMMON + 9 RARE.
 *   Set 1735: 15 RARE + 10 EPIC.
 *
 * SemanticGroups (5 × 5 в каждом сете):
 *   Set 1733:
 *     entertainment_party_social   — мסיба, пиqник, ḥагига, мифгаш, ораḥ
 *     entertainment_humor_fun      — кеф, бдиḥа, цхок, кесем, hумор
 *     entertainment_kids_outdoor   — нaднеда, маглеша, болинг, афифон, ḥацар-мишḥаким
 *     entertainment_games_indoor   — цаацуа, ḥида, пазль, шаḥмат, дамка
 *     entertainment_show_event     — серет, тиюль, hацага, таḥбив, прас
 *   Set 1734:
 *     entertainment_screen_genres  — комедия, драма, аниме, мотḥан, hемшех
 *     entertainment_offline_events — фестиваль, пэйнтбол, хадар-бриḥа, караоке, косплей
 *     entertainment_gaming_gear    — геймер, консола, шалет, hесег, мультиплейер
 *     entertainment_streaming      — стриминг, плейлист, шидур-ḥай, трейлер, hакрана
 *     entertainment_fan_meta       — спойлер, билуй, фандом, глитч, фанфик
 *   Set 1735:
 *     entertainment_storytelling   — протагонист, антагонист, анти-гибор, тфнит-алилит, ремиза
 *     entertainment_film_craft     — пасколь, цилум-окев, рега-мабhиль, мизансцена, лаhит-купати
 *     entertainment_game_design    — сэндбокс, мисхак-ацмаи, рогалайк, платформер, спидран
 *     entertainment_production     — шоураннер, бнийат-олам, канон, hафакат-серет, гмар-она
 *     entertainment_fan_culture    — мокументари, бейцат-песах, эспорт, эстетика, соḥеф
 *
 * Word IDs: setId × 100 + position (173301..173325, 173401..173425, 173501..173525).
 */
object WordDataHebrewEntertainmentL1L2L3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1733, languagePair = "he-ru", orderIndex = 1733,
            name = "Развлечения и досуг",
            description = "Базовая лексика про игры, кино и хобби для повседневных разговоров",
            topic = "Развлечения и досуг", level = 1,
        ),
        WordSetEntity(
            id = 1734, languagePair = "he-ru", orderIndex = 1734,
            name = "Развлечения и досуг",
            description = "Продвинутая лексика развлечений: жанры, события, гейминг, стриминг",
            topic = "Развлечения и досуг", level = 2,
        ),
        WordSetEntity(
            id = 1735, languagePair = "he-ru", orderIndex = 1735,
            name = "Развлечения и досуг",
            description = "Углублённая лексика индустрии: продакшн, киноязык, гейм-дизайн, ивенты",
            topic = "Развлечения и досуг", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1733 — Развлечения и досуг: основы (L1, COMMON + UNCOMMON, A1–A2)
        // 5 групп × 5 слов: party_social, humor_fun, kids_outdoor, games_indoor, show_event
        // ══════════════════════════════════════════════════════════════════════

        // ── entertainment_party_social (5) — встречи и торжества ──
        WordEntity(
            id = 173301, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_party_social", transliteration = "mesiba",
            original = "מְסִבָּה", translation = "вечеринка",
            definition = "אֵרוּעַ עָלִיז שֶׁל אֲנָשִׁים בְּבַיִת אוֹ בְּגַן עִם אֹכֶל וּמוּסִיקָה.",
            definitionNative = "Весёлое сборище людей дома или в саду с едой и музыкой.",
            example = "מְסִבָּה גְּדוֹלָה הָיְתָה אֶצְלֵנוּ בַּיוֹם שִׁשִּׁי בָּעֶרֶב.",
            exampleNative = "Большая מְסִבָּה была у нас в пятницу вечером.",
         fillInBlankExclusions = listOf(173302L, 173303L, 173304L, 173305L)),
        WordEntity(
            id = 173302, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_party_social", transliteration = "piknik",
            original = "פִּיקְנִיק", translation = "пикник",
            definition = "אֲרוּחָה עַל שְׁמִיכָה בַּטֶּבַע, בְּגַן אוֹ עַל הַחוֹף.",
            definitionNative = "Еда на коврике на природе, в парке или на пляже.",
            example = "עָשִׂינוּ פִּיקְנִיק עִם הַיְּלָדִים בַּגַּן הָעִירוֹנִי.",
            exampleNative = "Мы устроили פִּיקְנִיק с детьми в городском парке.",
         fillInBlankExclusions = listOf(173301L, 173303L, 173304L, 173305L)),
        WordEntity(
            id = 173303, setId = 1733, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_party_social", transliteration = "khagiga",
            original = "חֲגִיגָה", translation = "торжество",
            definition = "אֵרוּעַ שִׂמְחָה גָּדוֹל לְכָל הַמִּשְׁפָּחָה אוֹ הַקְּהִלָּה.",
            definitionNative = "Большое радостное событие для семьи или общины.",
            example = "חֲגִיגָה גְּדוֹלָה הָיְתָה לִכְבוֹד יוֹם הַהֻלֶּדֶת שֶׁל סָבָא.",
            exampleNative = "Большая חֲגִיגָה прошла в честь дня рождения дедушки.",
         fillInBlankExclusions = listOf(173301L, 173302L, 173304L, 173305L)),
        WordEntity(
            id = 173304, setId = 1733, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_party_social", transliteration = "mifgash",
            original = "מִפְגָּשׁ", translation = "встреча",
            definition = "אֵרוּעַ קָצָר בֵּין שְׁנֵי אֲנָשִׁים אוֹ קְבוּצָה לְשֵׁם שִׂיחָה.",
            definitionNative = "Короткое свидание двух человек или группы ради общения.",
            example = "קָבַעְנוּ מִפְגָּשׁ בְּבֵית קָפֶה לְיַד הַתַּחֲנָה.",
            exampleNative = "Мы назначили מִפְגָּשׁ в кафе у автостанции.",
        ),
        WordEntity(
            id = 173305, setId = 1733, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_party_social", transliteration = "oreakh",
            original = "אוֹרֵחַ", translation = "гость",
            definition = "אָדָם שֶׁמִּישֶׁהוּ הִזְמִין לְבֵיתוֹ אוֹ לְאֵרוּעַ.",
            definitionNative = "Человек, которого пригласили в дом или на праздник.",
            example = "כָּל אוֹרֵחַ קִבֵּל מַתָּנָה קְטַנָּה בִּכְנִיסָה.",
            exampleNative = "Каждый אוֹרֵחַ получал на входе маленький подарок.",
        ),

        // ── entertainment_humor_fun (5) — смех и юмор ──
        WordEntity(
            id = 173306, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_humor_fun", transliteration = "kef",
            original = "כֵּיף", translation = "кайф",
            definition = "תְּחוּשַׁת הֲנָאָה גְּדוֹלָה כְּשֶׁעוֹשִׂים מַשֶּׁהוּ אָהוּב.",
            definitionNative = "Чувство большого удовольствия от любимого занятия.",
            example = "הָיָה לָנוּ כֵּיף עִם הַחֲבֵרִים עַל שְׂפַת הַיָּם.",
            exampleNative = "Был полный כֵּיף с друзьями на берегу моря.",
         fillInBlankExclusions = listOf(173307L, 173308L, 173309L, 173310L)),
        WordEntity(
            id = 173307, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_humor_fun", transliteration = "bdikha",
            original = "בְּדִיחָה", translation = "анекдот",
            definition = "סִפּוּר קָצָר וּמַצְחִיק שֶׁמְּסַפְּרִים כְּדֵי לְהַצְחִיק חֲבֵרִים.",
            definitionNative = "Короткая смешная история, чтобы рассмешить друзей.",
            example = "סָבָא סִפֵּר בְּדִיחָה יְשָׁנָה וְכֻלָּם צָחֲקוּ.",
            exampleNative = "Дедушка рассказал старую בְּדִיחָה — и все засмеялись.",
         fillInBlankExclusions = listOf(173306L, 173308L, 173309L, 173310L)),
        WordEntity(
            id = 173308, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_humor_fun", transliteration = "tskhok",
            original = "צְחוֹק", translation = "смех",
            definition = "תְּגוּבָה קוֹלָנִית לְמַשֶּׁהוּ מַצְחִיק אוֹ מְהַנֶּה.",
            definitionNative = "Громкая реакция тела на что-то весёлое или приятное.",
            example = "הַצְּחוֹק מִן הַסָּלוֹן נִשְׁמַע גַּם בָּרְחוֹב.",
            exampleNative = "צְחוֹק из гостиной было слышно даже на улице.",
        ),
        WordEntity(
            id = 173309, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_humor_fun", transliteration = "kesem",
            original = "קֶסֶם", translation = "магия",
            definition = "מוֹפָע שֶׁל לוּלְיָנוּת יָדַיִם הַמַּפְתִּיעַ אֶת הַצּוֹפִים.",
            definitionNative = "Представление с фокусами рук, удивляющее зрителей.",
            example = "הַיֶּלֶד הִתְלַהֵב מִכָּל קֶסֶם שֶׁל הַקּוֹסֵם.",
            exampleNative = "Ребёнок восторгался каждым קֶסֶם фокусника.",
         fillInBlankExclusions = listOf(173306L, 173307L, 173308L, 173310L)),
        WordEntity(
            id = 173310, setId = 1733, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_humor_fun", transliteration = "humor",
            original = "הוּמוֹר", translation = "юмор",
            definition = "יְכֹלֶת לְהַבְחִין בְּצַד הַמְּבַדֵּחַ שֶׁל מַצָּבִים בַּחַיִּים.",
            definitionNative = "Способность видеть забавную сторону жизненных ситуаций.",
            example = "יֵשׁ לָהּ הוּמוֹר נֶהְדָּר וְהַחֲבֵרוֹת אוֹהֲבוֹת אוֹתָהּ.",
            exampleNative = "У неё прекрасный הוּמוֹר, и подруги её обожают.",
         fillInBlankExclusions = listOf(173306L, 173307L, 173308L, 173309L)),

        // ── entertainment_kids_outdoor (5) — детские забавы во дворе ──
        WordEntity(
            id = 173311, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_kids_outdoor", transliteration = "nadneda",
            original = "נַדְנֵדָה", translation = "качели",
            definition = "מִתְקָן עֵץ אוֹ מַתֶּכֶת שֶׁבּוֹ הַיֶּלֶד נָע קָדִימָה וְאָחוֹרָה לִהֲנָאָה.",
            definitionNative = "Снаряд, на котором ребёнок движется вперёд и назад ради удовольствия.",
            example = "הַיַּלְדָּה רָכְבָה עַל הַנַּדְנֵדָה הַגְּבוֹהָה כָּל הַבֹּקֶר.",
            exampleNative = "Девочка прокаталась на высокой נַדְנֵדָה всё утро.",
        ),
        WordEntity(
            id = 173312, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_kids_outdoor", transliteration = "maglesha",
            original = "מַגְלֵשָׁה", translation = "горка",
            definition = "מִתְקָן מָשׁוּפָּע שֶׁעָלָיו יְלָדִים גּוֹלְשִׁים מִלְמַעְלָה לְמַטָּה.",
            definitionNative = "Наклонный снаряд, по которому дети съезжают сверху вниз.",
            example = "הָאָח הַקָּטָן צָעַק מִשִּׂמְחָה עַל הַמַּגְלֵשָׁה.",
            exampleNative = "Младший брат кричал от радости на מַגְלֵשָׁה.",
        ),
        WordEntity(
            id = 173313, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_kids_outdoor", transliteration = "boling",
            original = "בּוֹלִינְג", translation = "боулинг",
            definition = "מִשְׂחָק שֶׁבּוֹ מַפִּילִים פִּינִים בְּעֶזְרַת כַּדּוּר כָּבֵד.",
            definitionNative = "Игра, где тяжёлым шаром сбивают деревянные кегли.",
            example = "הַחֲבֵרִים הָלְכוּ לְשַׂחֵק בּוֹלִינְג לִפְנֵי אֲרוּחַת עֶרֶב.",
            exampleNative = "Друзья пошли играть в בּוֹלִינְג перед ужином.",
         fillInBlankExclusions = listOf(173311L, 173312L, 173314L)),
        WordEntity(
            id = 173314, setId = 1733, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_kids_outdoor", transliteration = "afifon",
            original = "עֲפִיפוֹן", translation = "воздушный змей",
            definition = "מִתְקָן מִנְּיָר וְעֵץ הַמּוּטָס בָּאֲוִיר בְּעֶזְרַת חוּט אָרֹךְ.",
            definitionNative = "Лёгкая конструкция из бумаги и щепок, что летит на длинной нитке.",
            example = "הָאָב לִמֵּד אֶת הַבֵּן לְהָטִיס עֲפִיפוֹן עַל הַחוֹף.",
            exampleNative = "Отец учил сына запускать עֲפִיפוֹן на пляже.",
         fillInBlankExclusions = listOf(173311L, 173312L, 173313L)),
        WordEntity(
            id = 173315, setId = 1733, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "entertainment_kids_outdoor", transliteration = "khatsar miskhakim",
            original = "חֲצַר מִשְׂחָקִים", translation = "детская площадка",
            definition = "אֵזוֹר פָּתוּחַ עִם מִתְקָנִים שׁוֹנִים שֶׁבּוֹ הַיְּלָדִים מְשַׂחֲקִים.",
            definitionNative = "Открытая зона со снарядами, где малыши проводят время.",
            example = "כָּל אַחַר הַצָּהֳרַיִם הוּא לוֹקֵחַ אוֹתָם לַחֲצַר מִשְׂחָקִים.",
            exampleNative = "Каждый день после обеда он водит их на חֲצַר מִשְׂחָקִים.",
        ),

        // ── entertainment_games_indoor (5) — настольные и комнатные игры ──
        WordEntity(
            id = 173316, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_games_indoor", transliteration = "tsa'atsua",
            original = "צַעֲצוּעַ", translation = "игрушка",
            definition = "חֵפֶץ קָטָן וּמַצְחִיק שֶׁיֶּלֶד מְשַׂחֵק בּוֹ בַּבַּיִת.",
            definitionNative = "Маленький забавный предмет, с которым ребёнок играет дома.",
            example = "כָּל בֹּקֶר הוּא בּוֹחֵר צַעֲצוּעַ אַחֵר מֵהָאֲרוֹן.",
            exampleNative = "Каждое утро он выбирает другой צַעֲצוּעַ из шкафа.",
        ),
        WordEntity(
            id = 173317, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_games_indoor", transliteration = "khida",
            original = "חִידָה", translation = "загадка",
            definition = "שְׁאֵלָה קָשָׁה שֶׁדּוֹרֶשֶׁת מַחֲשָׁבָה כְּדֵי לִמְצוֹא תְּשׁוּבָה.",
            definitionNative = "Трудный вопрос, требующий смекалки, чтобы найти ответ.",
            example = "הַסַּבְתָּא שָׁאֲלָה אוֹתָנוּ חִידָה יְשָׁנָה עַל אֳרוּז.",
            exampleNative = "Бабушка задала нам старинную חִידָה про рис.",
         fillInBlankExclusions = listOf(173316L, 173318L, 173319L, 173320L)),
        WordEntity(
            id = 173318, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_games_indoor", transliteration = "puzzle",
            original = "פָּאזֶל", translation = "пазл",
            definition = "מִשְׂחָק שֶׁל חֲתִיכוֹת קְטַנּוֹת שֶׁמְּחַבְּרִים לִתְמוּנָה אַחַת.",
            definitionNative = "Игра из мелких кусочков, которые складывают в одну картинку.",
            example = "כָּל הַמִּשְׁפָּחָה הִשְׁלִימָה פָּאזֶל גָּדוֹל בָּעֶרֶב הַגָּשׁוּם.",
            exampleNative = "Вся семья собрала большой פָּאזֶל дождливым вечером.",
         fillInBlankExclusions = listOf(173316L, 173317L, 173319L, 173320L)),
        WordEntity(
            id = 173319, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_games_indoor", transliteration = "shakhmat",
            original = "שַׁחְמַט", translation = "шахматы",
            definition = "מִשְׂחַק לוּחַ שֶׁל שִׁשִּׁים וְאַרְבָּעָה מִשְׁבְּצוֹת בֵּין שְׁנֵי שַׂחְקָנִים.",
            definitionNative = "Игра на доске из 64 клеток между двумя соперниками.",
            example = "סָבָא לִמֵּד אוֹתִי לְשַׂחֵק שַׁחְמַט בְּגִיל שֶׁבַע.",
            exampleNative = "Дедушка научил меня играть в שַׁחְמַט в семь лет.",
         fillInBlankExclusions = listOf(173316L, 173317L, 173318L, 173320L)),
        WordEntity(
            id = 173320, setId = 1733, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_games_indoor", transliteration = "damka",
            original = "דַּמְקָה", translation = "шашки",
            definition = "מִשְׂחַק לוּחַ פָּשׁוּט יוֹתֵר שֶׁבּוֹ אוֹכְלִים אֶת הַחֲיָלִים שֶׁל הַיָּרִיב.",
            definitionNative = "Простая настольная игра, где едят фишки соперника по диагонали.",
            example = "הוּא הִפְסִיד בְּדַמְקָה לַסַּבְתָּא שָׁלוֹשׁ פְּעָמִים בָּרֶצַף.",
            exampleNative = "Он трижды подряд проиграл бабушке в דַּמְקָה.",
        ),

        // ── entertainment_show_event (5) — кино, выходы, призы ──
        WordEntity(
            id = 173321, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_show_event", transliteration = "seret",
            original = "סֶרֶט", translation = "фильм",
            definition = "יְצִירָה שֶׁל תְּמוּנוֹת נָעוֹת עִם עֲלִילָה לְצוֹפִים בְּקוֹלְנוֹעַ.",
            definitionNative = "Произведение из движущихся картин с сюжетом для зрителей кинотеатра.",
            example = "רָאִינוּ סֶרֶט יָפֶה מְאֹד בְּשַׁבָּת בַּבֹּקֶר.",
            exampleNative = "Мы посмотрели очень красивый סֶרֶט в субботу утром.",
         fillInBlankExclusions = listOf(173322L, 173323L, 173324L, 173325L)),
        WordEntity(
            id = 173322, setId = 1733, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "entertainment_show_event", transliteration = "tiyul",
            original = "טִיּוּל", translation = "прогулка",
            definition = "הֲלִיכָה אֲרֻכָּה לִשְׁעוֹת אֲחָדוֹת בַּטֶּבַע אוֹ בָּעִיר לִהֲנָאָה.",
            definitionNative = "Долгая ходьба несколько часов на природе или по городу ради удовольствия.",
            example = "עָשִׂינוּ טִיּוּל אָרֹךְ בְּהָרֵי הַגָּלִיל בְּסוֹף הַשָּׁבוּעַ.",
            exampleNative = "Мы устроили долгий טִיּוּל по галилейским холмам в выходные.",
         fillInBlankExclusions = listOf(173321L, 173323L, 173324L, 173325L)),
        WordEntity(
            id = 173323, setId = 1733, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_show_event", transliteration = "hatsaga",
            original = "הַצָּגָה", translation = "спектакль",
            definition = "מוֹפָע שֶׁל שַׂחְקָנִים עַל בָּמָה לִפְנֵי קָהָל בְּתֵיאַטְרוֹן.",
            definitionNative = "Представление актёров на сцене перед публикой в театре.",
            example = "הַסַּבְתָּא לָקְחָה אוֹתִי לְהַצָּגָה לִילָדִים בְּתֵיאַטְרוֹן הָעִירוֹנִי.",
            exampleNative = "Бабушка повела меня на детскую הַצָּגָה в городской театр.",
         fillInBlankExclusions = listOf(173321L, 173322L, 173324L, 173325L)),
        WordEntity(
            id = 173324, setId = 1733, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_show_event", transliteration = "takhbiv",
            original = "תַּחְבִּיב", translation = "хобби",
            definition = "פְּעֻלָּה אֲהוּבָה שֶׁעוֹשִׂים בִּזְמַן פָּנוּי בְּלִי תַּשְׁלוּם.",
            definitionNative = "Любимое занятие в свободное время не ради денег.",
            example = "צִיּוּר הוּא הַתַּחְבִּיב הָאָהוּב עָלֶיהָ בָּעֶרֶב.",
            exampleNative = "Рисование — её любимый תַּחְבִּיב по вечерам.",
         fillInBlankExclusions = listOf(173321L, 173322L, 173323L, 173325L)),
        WordEntity(
            id = 173325, setId = 1733, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_show_event", transliteration = "pras",
            original = "פְּרָס", translation = "приз",
            definition = "מַתָּנָה אוֹ כֶּסֶף שֶׁמְּקַבֵּל הַמְּנַצֵּחַ בִּתְחָרוּת אוֹ הַגְרָלָה.",
            definitionNative = "Подарок или деньги, что получает победитель состязания или розыгрыша.",
            example = "הַזּוֹכֶה בַּחִידוֹן קִבֵּל פְּרָס נָאֶה מִן הָרַדְיוֹ.",
            exampleNative = "Победитель викторины получил красивый פְּרָס от радиостанции.",
         fillInBlankExclusions = listOf(173321L, 173322L, 173323L, 173324L)),

        // ══════════════════════════════════════════════════════════════════════
        // Set 1734 — Развлечения и досуг: продвинутые (L2, UNCOMMON+RARE, A2–B1)
        // 5 групп × 5 слов: screen_genres, offline_events, gaming_gear, streaming, fan_meta
        // ══════════════════════════════════════════════════════════════════════

        // ── entertainment_screen_genres (5) — жанры экрана ──
        WordEntity(
            id = 173401, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_screen_genres", transliteration = "komedya",
            original = "קוֹמֶדְיָה", translation = "комедия",
            definition = "סוּג שֶׁל יְצִירָה הַמַּצְחִיק אֶת הַקָּהָל בִּסְצֵנוֹת קַלּוֹת וּדְמוּיוֹת.",
            definitionNative = "Жанр, рассмешивающий зрителей лёгкими сценами и забавными героями.",
            example = "הִיא אוֹהֶבֶת לִרְאוֹת קוֹמֶדְיָה אַחֲרֵי יוֹם עֲבוֹדָה קָשֶׁה.",
            exampleNative = "Она любит смотреть קוֹמֶדְיָה после тяжёлого рабочего дня.",
         fillInBlankExclusions = listOf(173402L, 173403L, 173404L, 173405L)),
        WordEntity(
            id = 173402, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_screen_genres", transliteration = "drama",
            original = "דְּרָמָה", translation = "драма",
            definition = "סוּג שֶׁל יְצִירָה רְצִינִית עִם רְגָשׁוֹת חֲזָקִים וְקוֹנְפְלִיקְט.",
            definitionNative = "Серьёзный жанр с сильными чувствами и душевным конфликтом.",
            example = "הַסֶּרֶט הוּא דְּרָמָה צָרְפָתִית עַל מִשְׁפָּחָה מְפוֹרֶקֶת.",
            exampleNative = "Этот фильм — французская דְּרָמָה о распадающейся семье.",
         fillInBlankExclusions = listOf(173401L, 173403L, 173404L, 173405L)),
        WordEntity(
            id = 173403, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_screen_genres", transliteration = "anime",
            original = "אָנִימֶה", translation = "аниме",
            definition = "סִגְנוֹן יַפָּנִי שֶׁל סְרָטֵי צִיּוּר עִם דְּמוּיוֹת בַּעֲלוֹת עֵינַיִם גְּדוֹלוֹת.",
            definitionNative = "Японская рисованная стилистика с большеглазыми персонажами.",
            example = "הַבֵּן שֶׁלִּי מְשׂוּגָע עַל אָנִימֶה כְּבָר חֲמֵשׁ שָׁנִים.",
            exampleNative = "Мой сын помешан на אָנִימֶה уже пять лет.",
         fillInBlankExclusions = listOf(173401L, 173402L, 173404L, 173405L)),
        WordEntity(
            id = 173404, setId = 1734, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_screen_genres", transliteration = "motkhan",
            original = "מוֹתְחָן", translation = "триллер",
            definition = "סוּג שֶׁל סֶרֶט מוֹתֵחַ הַשּׁוֹמֵר עַל הַצּוֹפֶה בְּמַתָּח עַד הַסּוֹף.",
            definitionNative = "Жанр напряжённого фильма, держащего зрителя в саспенсе до развязки.",
            example = "הַמּוֹתְחָן הָאַחֲרוֹן שֶׁלּוֹ זָכָה בְּפְרָסִים רַבִּים בְּקַאן.",
            exampleNative = "Его новый מוֹתְחָן получил много призов в Каннах.",
        ),
        WordEntity(
            id = 173405, setId = 1734, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_screen_genres", transliteration = "hemshekh",
            original = "הֶמְשֵׁךְ", translation = "сиквел",
            definition = "סֶרֶט אוֹ סִפֶר הַמְּמַשֵּׁךְ אֶת הָעֲלִילָה שֶׁל יְצִירָה קוֹדֶמֶת.",
            definitionNative = "Фильм или книга, продолжающие сюжет уже знакомого произведения.",
            example = "הֶמְשֵׁךְ שֶׁל הַסִּדְרָה הִתְפַּרְסֵם בְּסוֹף הַשָּׁנָה.",
            exampleNative = "הֶמְשֵׁךְ сериала вышел в конце года.",
        ),

        // ── entertainment_offline_events (5) — оффлайн-события ──
        WordEntity(
            id = 173406, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_offline_events", transliteration = "festival",
            original = "פֶסְטִיבָל", translation = "фестиваль",
            definition = "אֵרוּעַ גָּדוֹל שֶׁל יָמִים אֲחָדִים עִם הוֹפָעוֹת אוֹ סְרָטִים.",
            definitionNative = "Большое событие, длящееся несколько дней, с выступлениями или фильмами.",
            example = "פֶסְטִיבָל הַסְּרָטִים בִּירוּשָׁלַיִם נִפְתַּח שָׁבוּעַ הַבָּא.",
            exampleNative = "פֶסְטִיבָל фильмов в Иерусалиме открывается на следующей неделе.",
         fillInBlankExclusions = listOf(173407L, 173409L, 173410L)),
        WordEntity(
            id = 173407, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_offline_events", transliteration = "paintball",
            original = "פֵּינְטְבּוֹל", translation = "пейнтбол",
            definition = "מִשְׂחָק קְבוּצָתִי שֶׁל יְרִיּוֹת בְּכַדּוּרֵי צֶבַע בַּיַעַר אוֹ בַּמִגְרָשׁ.",
            definitionNative = "Командная игра со стрельбой шариками с краской в лесу или на полигоне.",
            example = "חָגַגְנוּ אֶת יוֹם הַהֻלֶּדֶת שֶׁלּוֹ בְּפֵּינְטְבּוֹל בַּיַעַר.",
            exampleNative = "Мы отметили его день рождения в פֵּינְטְבּוֹל посреди леса.",
         fillInBlankExclusions = listOf(173406L, 173409L, 173410L)),
        WordEntity(
            id = 173408, setId = 1734, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "entertainment_offline_events", transliteration = "khadar bricha",
            original = "חֲדַר בְּרִיחָה", translation = "квест-комната",
            definition = "אַטְרַקְצְיָה שֶׁבָּהּ קְבוּצָה פּוֹתֶרֶת חִידוֹת כְּדֵי לָצֵאת מֵחֶדֶר נָעוּל.",
            definitionNative = "Развлечение, где команда решает головоломки, чтобы выйти из запертой комнаты.",
            example = "הִזְמַנּוּ חֲדַר בְּרִיחָה עִם נוֹשֵׂא שֶׁל מַעֲבָדַת מַדָּעָן.",
            exampleNative = "Мы заказали חֲדַר בְּרִיחָה на тему лаборатории учёного.",
        ),
        WordEntity(
            id = 173409, setId = 1734, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_offline_events", transliteration = "karaoke",
            original = "קָרָאוֹקֶה", translation = "караоке",
            definition = "בִּלּוּי שֶׁבּוֹ אוֹרְחִים שָׁרִים שִׁירִים מֻכָּרִים מֵעַל מָסָךְ עִם מִלִּים.",
            definitionNative = "Развлечение, где гости поют известные песни по экрану с текстом.",
            example = "אַחֲרֵי הָאֲרוּחָה כֻּלָּם שָׁרוּ קָרָאוֹקֶה עַד חֲצוֹת.",
            exampleNative = "После ужина все пели קָרָאוֹקֶה до полуночи.",
         fillInBlankExclusions = listOf(173406L, 173407L, 173410L)),
        WordEntity(
            id = 173410, setId = 1734, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_offline_events", transliteration = "kosplei",
            original = "קוֹסְפְּלֵיי", translation = "косплей",
            definition = "תַּחְבִּיב שֶׁל הִתְחַפְּשׂוּת לִדְמוּיוֹת מֵסְּרָטִים, מִשְׂחָקִים אוֹ מָאנְגָה.",
            definitionNative = "Хобби переодеваться в персонажей фильмов, игр или манги.",
            example = "הִיא הִשְׁקִיעָה חֳדָשִׁים בְּתִפְרֹת תִּלְבּוֹשֶׁת לְקוֹסְפְּלֵיי.",
            exampleNative = "Она потратила месяцы, чтобы сшить костюм для קוֹסְפְּלֵיי.",
         fillInBlankExclusions = listOf(173406L, 173407L, 173409L)),

        // ── entertainment_gaming_gear (5) — гейминг и инвентарь ──
        WordEntity(
            id = 173411, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_gaming_gear", transliteration = "gamer",
            original = "גֵּיימֶר", translation = "геймер",
            definition = "אָדָם שֶׁמְּבַלֶּה הַרְבֵּה זְמַן בְּמִשְׂחֲקֵי וִידֵאוֹ מַחְשֵׁב.",
            definitionNative = "Человек, проводящий много часов за компьютерными видеоиграми.",
            example = "הוּא גֵּיימֶר רְצִינִי שֶׁמַּשְׁתַּתֵּף בִּטוּרְנִירִים בְּכָל סוֹף שָׁבוּעַ.",
            exampleNative = "Он серьёзный גֵּיימֶר и каждые выходные участвует в турнирах.",
         fillInBlankExclusions = listOf(173412L, 173413L, 173414L, 173415L)),
        WordEntity(
            id = 173412, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_gaming_gear", transliteration = "konsola",
            original = "קוֹנְסוֹלָה", translation = "консоль",
            definition = "מַכְשִׁיר שֶׁל מִשְׂחָקִים הַמְּחֻבָּר לִטֵּלֵוִיזְיָה בִּמְקוֹם מַחְשֵׁב.",
            definitionNative = "Игровое устройство, что подключают к телевизору вместо компьютера.",
            example = "הָאַחְיָן קִבֵּל קוֹנְסוֹלָה חֲדָשָׁה לְיוֹם הַהֻלֶּדֶת שֶׁלּוֹ.",
            exampleNative = "Племянник получил новую קוֹנְסוֹלָה на день рождения.",
         fillInBlankExclusions = listOf(173411L, 173413L, 173414L, 173415L)),
        WordEntity(
            id = 173413, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_gaming_gear", transliteration = "shalat",
            original = "שַׁלָּט", translation = "контроллер",
            definition = "מַכְשִׁיר עִם כַּפְתּוֹרִים שֶׁבּוֹ הַשַּׂחְקָן שׁוֹלֵט בַּדְּמוּת בַּמִּשְׂחָק.",
            definitionNative = "Устройство с кнопками, которым геймер управляет персонажем игры.",
            example = "הַשַּׁלָּט שֶׁלִּי הִתְפַּלְקֵל אַחֲרֵי שָׁעָה אֲרוּכָּה שֶׁל מִשְׂחָק.",
            exampleNative = "Мой שַׁלָּט развалился после долгого часа игры.",
        ),
        WordEntity(
            id = 173414, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_gaming_gear", transliteration = "hesseg",
            original = "הֶשֵּׂג", translation = "достижение",
            definition = "סִימָן דִּיגִיטָלִי שֶׁמַּעֲנִיק הַמִּשְׂחָק עַל מַשִּׂימָה קָשָׁה שֶׁהֻשְׁלְמָה.",
            definitionNative = "Цифровая отметка, что игра выдаёт за выполненное трудное задание.",
            example = "הוּא הִתְפָּאֵר בַּהֶשֵּׂג הַנָּדִיר שֶׁבּוֹ זָכָה רַק אֶחוּז קָטָן.",
            exampleNative = "Он хвастался редким הֶשֵּׂג, что получили лишь единицы.",
         fillInBlankExclusions = listOf(173411L, 173412L, 173413L, 173415L)),
        WordEntity(
            id = 173415, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_gaming_gear", transliteration = "multipleyer",
            original = "מוּלְטִיפְּלֵייֶר", translation = "мультиплеер",
            definition = "מַצָּב שֶׁל מִשְׂחָק שֶׁבּוֹ אֲנָשִׁים אֲחָדִים מְשַׂחֲקִים יַחַד דֶּרֶךְ הָרֶשֶׁת.",
            definitionNative = "Режим, где несколько игроков соревнуются вместе через интернет.",
            example = "מוּלְטִיפְּלֵייֶר שֶׁל הַמִּשְׂחָק הַזֶּה עוֹבֵד מְצֻיָּן עַל הַסֶּרְבֶר.",
            exampleNative = "מוּלְטִיפְּלֵייֶר этой игры отлично работает на сервере.",
         fillInBlankExclusions = listOf(173411L, 173412L, 173413L, 173414L)),

        // ── entertainment_streaming (5) — стриминг и потоковое ──
        WordEntity(
            id = 173416, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_streaming", transliteration = "streaming",
            original = "סְטְרִימִינְג", translation = "стриминг",
            definition = "צְפִיָּה אוֹ הַאֲזָנָה דֶּרֶךְ הָרֶשֶׁת בְּלִי לְהוֹרִיד אֶת הַקֹּבֶץ.",
            definitionNative = "Просмотр или прослушивание через сеть без скачивания файла.",
            example = "סְטְרִימִינְג שֶׁל מוּסִיקָה הֶחֱלִיף אֵצֶלָּהּ אֶת הַתַּקְלִיטִים.",
            exampleNative = "סְטְרִימִינְג музыки заменил у неё пластинки.",
         fillInBlankExclusions = listOf(173417L, 173419L, 173420L)),
        WordEntity(
            id = 173417, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_streaming", transliteration = "playlist",
            original = "פְּלֵייְלִיסְט", translation = "плейлист",
            definition = "רְשִׁימָה שֶׁל שִׁירִים בְּסֵדֶר מְסֻיָּם לִשְׁמִיעָה רְצוּפָה.",
            definitionNative = "Список песен в определённом порядке для непрерывного прослушивания.",
            example = "הִכְנַתִּי פְּלֵייְלִיסְט מְיֻחָד לַטִּיּוּל בָּרֶכֶב הַחֲדָשׁ.",
            exampleNative = "Я составил особый פְּלֵייְלִיסְט в дорогу на новой машине.",
         fillInBlankExclusions = listOf(173416L, 173419L, 173420L)),
        WordEntity(
            id = 173418, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "entertainment_streaming", transliteration = "shidur khai",
            original = "שִׁדּוּר חַי", translation = "прямой эфир",
            definition = "הַעֲבָרָה שֶׁל אֵרוּעַ בָּרֶגַע שֶׁבּוֹ הוּא קוֹרֶה בְּלִי עִכּוּב.",
            definitionNative = "Передача события в момент, когда оно происходит, без задержки.",
            example = "הַמַּשְׁחָק עָבַר בְּשִׁדּוּר חַי לְכָל הָעוֹלָם.",
            exampleNative = "Матч транслировали в שִׁדּוּר חַי на весь мир.",
        ),
        WordEntity(
            id = 173419, setId = 1734, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_streaming", transliteration = "trailer",
            original = "טְרֵיילֶר", translation = "трейлер",
            definition = "קֶטַע קָצָר שֶׁל סֶרֶט שֶׁמַּצִּיגִים לִפְנֵי הַיְצִיאָה כְּדֵי לְעַנְיֵן.",
            definitionNative = "Короткий ролик фильма, что показывают до выхода для интриги.",
            example = "הַטְּרֵיילֶר זָרַע סְקָרָנוּת אֲבָל הִסְתִּיר אֶת הַסּוֹף.",
            exampleNative = "טְרֵיילֶר разжёг любопытство, но не выдал концовку.",
        ),
        WordEntity(
            id = 173420, setId = 1734, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_streaming", transliteration = "hakrana",
            original = "הַקְרָנָה", translation = "показ (фильма)",
            definition = "הַצָּגַת סֶרֶט עַל מָסָךְ גָּדוֹל בְּקוֹלְנוֹעַ אוֹ בְּפֶסְטִיבָל.",
            definitionNative = "Демонстрация фильма на большом экране в кинотеатре или на фестивале.",
            example = "הַקְרָנָה שֶׁל הַסֶּרֶט הָרִאשׁוֹן הִתְקַיְּמָה בְּתֵל אָבִיב.",
            exampleNative = "הַקְרָנָה первого фильма прошла в Тель-Авиве.",
         fillInBlankExclusions = listOf(173416L, 173417L, 173419L)),

        // ── entertainment_fan_meta (5) — фан-культура и сетевой жаргон ──
        WordEntity(
            id = 173421, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_fan_meta", transliteration = "spoiler",
            original = "סְפּוֹיְלֶר", translation = "спойлер",
            definition = "גִּלּוּי שֶׁל פְּרָט חָשׁוּב מֵהַעֲלִילָה לְמִי שֶׁעוֹד לֹא רָאָה.",
            definitionNative = "Раскрытие важной детали сюжета тому, кто ещё не смотрел.",
            example = "אַל תְּסַפֵּר לִי סְפּוֹיְלֶר מֵהַפֶּרֶק הָאַחֲרוֹן בְּבַקָּשָׁה.",
            exampleNative = "Не рассказывай мне סְפּוֹיְלֶר из последней серии, прошу.",
         fillInBlankExclusions = listOf(173422L, 173423L, 173424L, 173425L)),
        WordEntity(
            id = 173422, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_fan_meta", transliteration = "biluy",
            original = "בִּלּוּי", translation = "досуг",
            definition = "פְּעֻלָּה מְהַנָּה בִּזְמַן פָּנוּי כְּמוֹ בָּר, סֶרֶט אוֹ קוֹנְצֶרְט.",
            definitionNative = "Приятное времяпрепровождение в свободные часы — бар, кино, концерт.",
            example = "לְבִלּוּי בָּעֶרֶב בָּחַרְנוּ בָּר חָדָשׁ עַל הַחוֹף.",
            exampleNative = "Для בִּלּוּי вечером выбрали новый бар на берегу.",
        ),
        WordEntity(
            id = 173423, setId = 1734, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "entertainment_fan_meta", transliteration = "fandom",
            original = "פֶנְדּוֹם", translation = "фандом",
            definition = "קְהִלָּה שֶׁל מַעֲרִיצִים שֶׁל סֶרֶט, סִדְרָה אוֹ סוֹפֵר.",
            definitionNative = "Сообщество поклонников фильма, сериала или писателя.",
            example = "הַפֶּנְדּוֹם שֶׁל הַסִּדְרָה הִקִּים אֲתַר עִם תְּמוּנוֹת וּסְקִירוֹת.",
            exampleNative = "פֶנְדּוֹם сериала создал сайт со снимками и обзорами.",
        ),
        WordEntity(
            id = 173424, setId = 1734, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_fan_meta", transliteration = "glitch",
            original = "גְּלִיטְשׁ", translation = "глитч",
            definition = "תַּקָּלָה קְטַנָּה בַּמִּשְׂחָק שֶׁמַּפִּיקָה אֶפֶקְט מַצְחִיק אוֹ מוּזָר.",
            definitionNative = "Мелкий сбой в игре, дающий смешной или странный эффект на экране.",
            example = "גְּלִיטְשׁ נָדִיר שֶׁל הַתְּמוּנָה הָפַךְ לְצְחוֹק כְּלָלִי בָּרֶשֶׁת.",
            exampleNative = "Редкий גְּלִיטְשׁ стал общим смехом во всём интернете.",
        ),
        WordEntity(
            id = 173425, setId = 1734, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_fan_meta", transliteration = "fanfik",
            original = "פֶנְפִיק", translation = "фанфик",
            definition = "סִפֶר שֶׁל מַעֲרִיץ עַל גִּבּוֹרִים מִיְצִירָה קְיָמֶת וְלֹא מִשֶּׁלּוֹ.",
            definitionNative = "Текст поклонника о персонажах чужого произведения, не его собственного.",
            example = "הִיא כָּתְבָה פֶנְפִיק רוֹמַנְטִי עַל הַדְּמֻיּוֹת הָאֲהוּבוֹת.",
            exampleNative = "Она написала романтический פֶנְפִיק про любимых героев.",
         fillInBlankExclusions = listOf(173421L, 173422L, 173423L, 173424L)),

        // ══════════════════════════════════════════════════════════════════════
        // Set 1735 — Развлечения и досуг: углублённые (L3, RARE+EPIC, B2–C1)
        // 5 групп × 5 слов: storytelling, film_craft, game_design, production, fan_culture
        // ══════════════════════════════════════════════════════════════════════

        // ── entertainment_storytelling (5) — нарратив и герои ──
        WordEntity(
            id = 173501, setId = 1735, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_storytelling", transliteration = "protagonist",
            original = "פְּרוֹטָגוֹנִיסְט", translation = "протагонист",
            definition = "הַדְּמוּת הָרָאשִׁית שֶׁמַּמְרִיצָה אֶת הָעֲלִילָה מִתְּחִלָּה לַסּוֹף.",
            definitionNative = "Главное действующее лицо, движущее сюжет от завязки до финала.",
            example = "הַפְּרוֹטָגוֹנִיסְט שֶׁל הַסֶּרֶט הִתְמוֹדֵד עִם דִּילֶמָה מוּסָרִית קָשָׁה.",
            exampleNative = "פְּרוֹטָגוֹנִיסְט фильма столкнулся с тяжёлой моральной дилеммой.",
         fillInBlankExclusions = listOf(173502L, 173505L)),
        WordEntity(
            id = 173502, setId = 1735, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_storytelling", transliteration = "antagonist",
            original = "אַנְטָגוֹנִיסְט", translation = "антагонист",
            definition = "הַדְּמוּת שֶׁמִּתְנַגֶּדֶת לַגִּבּוֹר וּמְעִכֶּבֶת אוֹתוֹ בְּהַשָּׂגַת מַטְּרָתוֹ.",
            definitionNative = "Персонаж, противостоящий герою и мешающий ему достичь цели.",
            example = "הָאַנְטָגוֹנִיסְט הַזֶּה מְעוּמָּק וְלֹא רַק רַע סְתָם.",
            exampleNative = "Этот אַנְטָגוֹנִיסְט глубокий, а не просто плоский злодей.",
         fillInBlankExclusions = listOf(173501L, 173505L)),
        WordEntity(
            id = 173503, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "entertainment_storytelling", transliteration = "anti gibor",
            original = "אַנְטִי-גִּבּוֹר", translation = "антигерой",
            definition = "דְּמוּת רָאשִׁית שֶׁל יְצִירָה הַחֲסֵרָה אֶת הַתְּכוּנוֹת הַקְּלָסִיּוֹת שֶׁל גִּבּוֹר.",
            definitionNative = "Главный герой произведения без классических добродетельных качеств.",
            example = "הָאַנְטִי-גִּבּוֹר שֶׁבַּסִּדְרָה הוּא רוֹפֵא שֶׁמְּמוֹכֵר סַם אָסוּר.",
            exampleNative = "אַנְטִי-גִּבּוֹר сериала — врач, торгующий запрещённым веществом.",
         fillInBlankExclusions = listOf(173504L)),
        WordEntity(
            id = 173504, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "entertainment_storytelling", transliteration = "tfanit alilatit",
            original = "תַּפְנִית עֲלִילָתִית", translation = "поворот сюжета",
            definition = "שִׁנּוּי פִּתְאוֹמִי בָּעֲלִילָה שֶׁמַּפְתִּיעַ אֶת הַצּוֹפֶה אוֹ הַקּוֹרֵא.",
            definitionNative = "Внезапный сдвиг истории, неожиданный для зрителя или читателя.",
            example = "בַּפֶּרֶק הָאַחֲרוֹן הָיְתָה תַּפְנִית עֲלִילָתִית מְהַמֶּמֶת לְגַמְרֵי.",
            exampleNative = "В последней серии случилась ошеломляющая תַּפְנִית עֲלִילָתִית.",
         fillInBlankExclusions = listOf(173503L)),
        WordEntity(
            id = 173505, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_storytelling", transliteration = "remiza",
            original = "רְמִיזָה", translation = "намёк (нарратив)",
            definition = "סִימָן עָדִין מֻקְדָּם שֶׁמַּכְשִׁיר אֶת הַקָּהָל לִקְרֹאת תַּפְנִית עֲתִידִית.",
            definitionNative = "Тонкий ранний знак, что готовит публику к будущему повороту истории.",
            example = "הַבַּמַּאי שָׁתַל רְמִיזָה כְּבָר בַּדַּקָּה הַשְּׁלִישִׁית שֶׁל הַסֶּרֶט.",
            exampleNative = "Режиссёр заложил רְמִיזָה уже на третьей минуте фильма.",
         fillInBlankExclusions = listOf(173501L, 173502L)),

        // ── entertainment_film_craft (5) — кинематография ──
        WordEntity(
            id = 173506, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_film_craft", transliteration = "paskol",
            original = "פַּסְקוֹל", translation = "саундтрек",
            definition = "אֹסֶף הַמַּנְגִּינוֹת וְהָרַעֲשִׁים שֶׁמְּלַוִּים אֶת הַתְּמוּנָה בַּסֶּרֶט.",
            definitionNative = "Подбор мелодий и шумов, что сопровождают изображение по ходу фильма.",
            example = "הַפַּסְקוֹל הָעוֹצֵר שֶׁל הַסֶּרֶט נִשְׁאַר בְּזִכְרוֹנִי שָׁנִים.",
            exampleNative = "Захватывающий פַּסְקוֹל фильма остался в моей памяти на годы.",
         fillInBlankExclusions = listOf(173509L)),
        WordEntity(
            id = 173507, setId = 1735, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_film_craft", transliteration = "tsilum okev",
            original = "צִילוּם עוֹקֵב", translation = "следящий кадр",
            definition = "צְלִיחָה אֲרֻכָּה שֶׁל הַמַּצְלֵמָה אַחֲרֵי הַדְּמוּת בְּלִי חִתּוּכִים.",
            definitionNative = "Длинный кадр без склеек, где камера движется вслед за героем.",
            example = "צִילוּם עוֹקֵב שֶׁל שָׁלוֹשׁ דַּקּוֹת פּוֹתֵחַ אֶת הַסֶּרֶט.",
            exampleNative = "Трёхминутный צִילוּם עוֹקֵב открывает картину.",
         fillInBlankExclusions = listOf(173508L, 173510L)),
        WordEntity(
            id = 173508, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "entertainment_film_craft", transliteration = "rega mavhil",
            original = "רֶגַע מַבְהִיל", translation = "скример",
            definition = "אֶפֶקְט פִּתְאוֹמִי שֶׁל קוֹל וְתְמוּנָה הַמְּפַחֵד אֶת הַצּוֹפֶה.",
            definitionNative = "Внезапный звуко-визуальный эффект, что пугает зрителя.",
            example = "רֶגַע מַבְהִיל בָּאֶמְצַע הִקְפִּיץ אוֹתָנוּ מֵהַכִּסְּאוֹת.",
            exampleNative = "רֶגַע מַבְהִיל посередине подкинул нас с кресел.",
         fillInBlankExclusions = listOf(173507L, 173510L)),
        WordEntity(
            id = 173509, setId = 1735, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_film_craft", transliteration = "mizansena",
            original = "מִיזַנְסְצֶנָה", translation = "мизансцена",
            definition = "סִדּוּר הַדְּמֻיּוֹת וְהַחֲפָצִים בְּתוֹךְ הַפְּרֵיים שֶׁל הַסְּצֵנָה.",
            definitionNative = "Размещение фигур и предметов внутри кадра одной сцены.",
            example = "הַמִּיזַנְסְצֶנָה הַצְּפוּפָה הִדְגִּישָׁה אֶת הַמְּתִיחוּת בֵּין הָעוֹבְדִים.",
            exampleNative = "Тесная מִיזַנְסְצֶנָה подчеркнула напряжение между сотрудниками.",
        ),
        WordEntity(
            id = 173510, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "entertainment_film_craft", transliteration = "lahit kupati",
            original = "לַהִיט קוּפָּתִי", translation = "блокбастер",
            definition = "סֶרֶט שֶׁמַּכְנִיס סְכוּמֵי עָתֵק בַּקֻּפָּה וּמוֹשֵׁךְ קָהָל עָצוּם.",
            definitionNative = "Фильм, что собирает гигантскую кассу и привлекает огромную аудиторию.",
            example = "הַסֶּרֶט הָפַךְ לְלַהִיט קוּפָּתִי בְּסוֹף שָׁבוּעַ הַפְּתִיחָה.",
            exampleNative = "Фильм стал לַהִיט קוּפָּתִי уже в первые выходные.",
         fillInBlankExclusions = listOf(173507L, 173508L)),

        // ── entertainment_game_design (5) — гейм-дизайн ──
        WordEntity(
            id = 173511, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_game_design", transliteration = "sandbox",
            original = "סֶנְדְּבּוֹקְס", translation = "песочница (игр.)",
            definition = "סוּג שֶׁל מִשְׂחָק שֶׁמַּעֲנִיק לַשַּׂחְקָן חֹפֶשׁ פְּעֻלָּה רָחָב בָּעוֹלָם.",
            definitionNative = "Жанр игры, где у игрока широкая свобода действий внутри мира.",
            example = "סֶנְדְּבּוֹקְס בְּלִי מְטָרוֹת קְבוּעוֹת מַתְאִים לְשַׂחְקָנִים יְצִירָתִיִּים.",
            exampleNative = "סֶנְדְּבּוֹקְס без жёстких целей подходит творческим игрокам.",
         fillInBlankExclusions = listOf(173513L, 173514L, 173515L)),
        WordEntity(
            id = 173512, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "entertainment_game_design", transliteration = "miskhak atsmai",
            original = "מִשְׂחָק עַצְמָאִי", translation = "инди-игра",
            definition = "מִשְׂחָק שֶׁפֻּתַּח בְּלִי תְּמִיכַת חֶבְרָה גְּדוֹלָה אוֹ מַמּוֹנִים.",
            definitionNative = "Игра, разработанная без поддержки крупной студии или больших денег.",
            example = "הַמִּשְׂחָק הָעַצְמָאִי הַזֶּה זָכָה לְבִיקֹּרֶת מֻפְלָאָה.",
            exampleNative = "Эта מִשְׂחָק עַצְמָאִי получила восторженные рецензии.",
        ),
        WordEntity(
            id = 173513, setId = 1735, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_game_design", transliteration = "rogalaik",
            original = "רוֹגָלַייק", translation = "рогалик",
            definition = "סוּג שֶׁל מִשְׂחָק עִם מַפּוֹת אַקְרָאִיּוֹת וּמָוֶת קָבוּעַ שֶׁל הַדְּמוּת.",
            definitionNative = "Жанр со случайными уровнями и окончательной гибелью персонажа.",
            example = "רוֹגָלַייק קָשֶׁה עָלוּל לְהַסִּיר עֲשָׂרוֹת שָׁעוֹת בְּלִי הִתְקַדְּמוּת.",
            exampleNative = "Тяжёлый רוֹגָלַייק может съесть десятки часов без прогресса.",
         fillInBlankExclusions = listOf(173511L, 173514L, 173515L)),
        WordEntity(
            id = 173514, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_game_design", transliteration = "platformer",
            original = "פְּלַטְפוֹרְמֶר", translation = "платформер",
            definition = "מִשְׂחָק שֶׁבּוֹ קוֹפְצִים בֵּין מַדְרֵגוֹת וּקְפִיצוֹת לְהַשְׁלִים שָׁלָב.",
            definitionNative = "Игра с прыжками между уступами и островами для прохождения уровня.",
            example = "פְּלַטְפוֹרְמֶר קְלָסִי עִם דְּמֻיּוֹת מְצֻיָּרוֹת חָזַר לְאוֹפְנָה.",
            exampleNative = "Классический פְּלַטְפוֹרְמֶר с рисованными героями вернулся в моду.",
         fillInBlankExclusions = listOf(173511L, 173513L, 173515L)),
        WordEntity(
            id = 173515, setId = 1735, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_game_design", transliteration = "speedran",
            original = "סְפִּידְרָאן", translation = "спидран",
            definition = "נִסָּיוֹן לִגְמוֹר מִשְׂחָק בִּזְמַן הַקָּצָר בְּיוֹתֵר אֶפְשָׁרִי תּוֹךְ נִצּוּל בָּגִּים.",
            definitionNative = "Попытка пройти игру за минимальное время, используя баги и хаки.",
            example = "הַסְּפִּידְרָאן שֶׁל הַשִּׂיא הָעוֹלָמִי אָרַךְ פָּחוֹת מֵחֲצִי שָׁעָה.",
            exampleNative = "Мировой סְפִּידְרָאן занял меньше получаса.",
        ),

        // ── entertainment_production (5) — продакшн и индустрия ──
        WordEntity(
            id = 173516, setId = 1735, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_production", transliteration = "shoraner",
            original = "שׁוֹרַנֶּר", translation = "шоураннер",
            definition = "הַמְּפַקֵּחַ הָרָאשִׁי עַל סִדְרָה שֶׁאַחְרָאִי לַעֲלִילָה וְלַצְּוֶת כֻּלּוֹ.",
            definitionNative = "Главный руководитель сериала, ведущий и сюжет, и всю съёмочную команду.",
            example = "הַשּׁוֹרַנֶּר הִתְעַקֵּשׁ עַל סוֹף עָצוּב לַעֲלִילָה לַמְרוֹת הַלְּחָצִים.",
            exampleNative = "שׁוֹרַנֶּר настоял на грустном финале вопреки давлению студии.",
        ),
        WordEntity(
            id = 173517, setId = 1735, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_production", transliteration = "bniyat olam",
            original = "בְּנִיַּת עוֹלָם", translation = "ворлдбилдинг",
            definition = "תַּהֲלִיךְ הַמְצָאָה שֶׁל יְקוּם בָּדוּי עִם חוּקִים, גֵּאוֹגְרַפְיָה וְהִיסְטוֹרְיָה.",
            definitionNative = "Создание выдуманной вселенной с законами, географией и историей.",
            example = "בְּנִיַּת עוֹלָם מְפֹרֶטֶת לוֹקַחַת לַסּוֹפֵר שָׁנִים שֶׁל עֲבוֹדָה.",
            exampleNative = "Глубокая בְּנִיַּת עוֹלָם отнимает у писателя годы работы.",
         fillInBlankExclusions = listOf(173519L, 173520L)),
        WordEntity(
            id = 173518, setId = 1735, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_production", transliteration = "kanon",
            original = "קָאנוֹן", translation = "канон (фандом)",
            definition = "מַעֲרֶכֶת הָעֻבְדּוֹת הָרִשְׁמִיּוֹת מִתּוֹךְ הַיְצִירָה שֶׁאַסוּר לִסְתוֹר.",
            definitionNative = "Совокупность официальных фактов произведения, которые нельзя нарушать.",
            example = "הַסֵּפֶר הַשִּׁבִיעִי הוֹסִיף לַקָּאנוֹן פְּרָטִים חֲשׁוּבִים עַל סָבָתָהּ.",
            exampleNative = "Седьмая книга добавила в קָאנוֹן важные подробности о бабушке.",
        ),
        WordEntity(
            id = 173519, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "entertainment_production", transliteration = "hafakat seret",
            original = "הֲפָקַת סֶרֶט", translation = "кинопроизводство",
            definition = "כָּל הַשְּׁלָבִים שֶׁל הָכָנַת סֶרֶט מֵהַתַּסְרִיט וְעַד יְצִיאָתוֹ לְקוֹלְנוֹעַ.",
            definitionNative = "Все этапы создания фильма от сценария до выхода в прокат.",
            example = "הֲפָקַת סֶרֶט בִּינְלְאֻמִּית כָּזוֹ דּוֹרֶשֶׁת תַּקְצִיב שֶׁל מִילְיוֹנִים.",
            exampleNative = "Такая международная הֲפָקַת סֶרֶט требует бюджет в миллионы.",
         fillInBlankExclusions = listOf(173517L, 173520L)),
        WordEntity(
            id = 173520, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "entertainment_production", transliteration = "gmar ona",
            original = "גְּמַר עוֹנָה", translation = "финал сезона",
            definition = "הַפֶּרֶק הָאַחֲרוֹן בָּעוֹנָה שֶׁמַּשְׁאִיר שְׁאֵלוֹת לַעוֹנָה הַבָּאָה.",
            definitionNative = "Последний эпизод сезона, оставляющий вопросы для следующего цикла.",
            example = "הַגְּמַר עוֹנָה הִתְקִיף אֶת הַצּוֹפִים בְּקְלִיפְהֵנְגֶר חַד.",
            exampleNative = "גְּמַר עוֹנָה ударил по зрителям резким клиффхэнгером.",
         fillInBlankExclusions = listOf(173517L, 173519L)),

        // ── entertainment_fan_culture (5) — фан-культура продвинутая ──
        WordEntity(
            id = 173521, setId = 1735, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_fan_culture", transliteration = "mokumentari",
            original = "מוֹקוּמֶנְטָרִי", translation = "мокьюментари",
            definition = "סוּג שֶׁל סֶרֶט בָּדוּי שֶׁמְּחַקֶּה אֶת הַסִּגְנוֹן שֶׁל סֶרֶט תִּיעוּדִי אֲמִתִּי.",
            definitionNative = "Вид игрового кино, что подражает стилю настоящего документального фильма.",
            example = "הַמּוֹקוּמֶנְטָרִי הַזֶּה גָּרַם לִי לַחֲשׁוֹב שֶׁכֻּלּוֹ אֲמִתִּי.",
            exampleNative = "מוֹקוּמֶנְטָרִי заставил меня поверить, будто всё взаправду.",
        ),
        WordEntity(
            id = 173522, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "entertainment_fan_culture", transliteration = "beytsat pesakh",
            original = "בֵּיצַת פֶּסַח", translation = "пасхалка",
            definition = "סוֹד סָמוּי בַּסֶּרֶט אוֹ בַּמִּשְׂחָק שֶׁרַק חוֹבְבִים נֶחֱנָּכִים מוֹצְאִים.",
            definitionNative = "Скрытая отсылка в фильме или игре, что находят лишь посвящённые фанаты.",
            example = "בְּכָל פֶּרֶק הַסַּדְרָנִים מַסְתִּירִים בֵּיצַת פֶּסַח חֲדָשָׁה.",
            exampleNative = "В каждой серии создатели прячут новую בֵּיצַת פֶּסַח.",
        ),
        WordEntity(
            id = 173523, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_fan_culture", transliteration = "esport",
            original = "אֶסְפּוֹרְט", translation = "киберспорт",
            definition = "תְּחָרוּת מִקְצוֹעִית שֶׁל מִשְׂחֲקֵי וִידֵאוֹ בִּפְנֵי קָהָל וְעַל פְּרָסִים גְּדוֹלִים.",
            definitionNative = "Профессиональный турнир по видеоиграм перед публикой и на крупные призы.",
            example = "טוּרְנִיר אֶסְפּוֹרְט בַּסֶּטָדִיוֹן הַגָּדוֹל מִלֵּא אֶת כָּל הַמּוֹשָׁבִים.",
            exampleNative = "Турнир אֶסְפּוֹרְט на большом стадионе занял все места.",
         fillInBlankExclusions = listOf(173521L, 173524L)),
        WordEntity(
            id = 173524, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "entertainment_fan_culture", transliteration = "estetika",
            original = "אֶסְתֵטִיקָה", translation = "эстетика",
            definition = "סִגְנוֹן חֲזוּתִי מְגוּבָּשׁ שֶׁל סֶרֶט אוֹ סִדְרָה הַיּוֹצֵר רֹשֶׁם אֶחָד.",
            definitionNative = "Цельный визуальный стиль фильма или сериала, дающий единое впечатление.",
            example = "הָאֶסְתֵטִיקָה שֶׁל שְׁנוֹת הַשְּׁמוֹנִים חוֹזֶרֶת חָזָק לְבִדּוּר עַכְשָׁוִי.",
            exampleNative = "אֶסְתֵטִיקָה восьмидесятых мощно возвращается в современные шоу.",
         fillInBlankExclusions = listOf(173521L, 173523L)),
        WordEntity(
            id = 173525, setId = 1735, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "entertainment_fan_culture", transliteration = "sokhef",
            original = "סוֹחֵף", translation = "захватывающий",
            definition = "כָּזֶה שֶׁמּוֹשֵׁךְ אֶת הַצּוֹפֶה כֻּלּוֹ לְתוֹךְ הָעוֹלָם הַבָּדוּי.",
            definitionNative = "Такой, что увлекает зрителя целиком в выдуманный мир.",
            example = "הַסֶּרֶט הָיָה כָּל כָּךְ סוֹחֵף שֶׁשָּׁכַחְתִּי לֶאֱכֹל פּוֹפְקוֹרְן.",
            exampleNative = "Фильм оказался так סוֹחֵף, что я забыл про попкорн.",
        ),
    )
}
