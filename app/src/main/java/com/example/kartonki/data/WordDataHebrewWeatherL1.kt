package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Погода и климат", level 1 (A1-A2).
 * Один сет × 25 слов. setId = 1817.
 *
 *  - 17 COMMON + 8 UNCOMMON (2 смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      weather_basic_sky      — небо и небесные тела (5)
 *      weather_basic_precip   — дождь и осадки (5)
 *      weather_basic_temp     — температура и тепло/холод (5)
 *      weather_basic_adj      — описательные прилагательные погоды (5)
 *      weather_basic_actions  — погодные глаголы (5)
 *  - Базовая повседневная лексика про погоду на иврите.
 *    Никудим везде (стандарт he-ru).
 *  - Несколько фундаментальных оригиналов (שֶׁמֶשׁ, גֶּשֶׁם, חַם)
 *    пересекаются с set 1011 "Природа и экология" — формально это
 *    другая тема, дубли в разных темах допустимы по политике
 *    (`docs/claude/feedback_duplicate_words_policy.md`).
 *    Без них L1 "Погода и климат" неполноценен.
 *  - isFillInBlankSafe=false на старте — после полировки и FIB pipeline
 *    безопасные слова будут переведены в safe.
 */
object WordDataHebrewWeatherL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1817, languagePair = "he-ru", orderIndex = 1817,
            name = "Погода и климат",
            description = "Солнце, дождь, снег и базовая погода",
            topic = "Погода и климат", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── weather_basic_sky (5) ───────────────────────────────────────
        WordEntity(
            id = 181701, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "weather_basic_sky",
            original = "שָׁמַיִם", translation = "небо",
            transliteration = "шамаим",
            definition = "הַשֶּׁטַח הַכָּחוֹל מֵעַל לָנוּ שֶׁבּוֹ נִרְאוֹת חַמָּה, יָרֵחַ וְכוֹכָבִים.",
            definitionNative = "Голубой свод над нами, где видны солнце, луна и звёзды.",
            example = "הַשָּׁמַיִם הָיוּ כְּחוּלִים לְגַמְרֵי הַבֹּקֶר.",
            exampleNative = "Сегодня утром שָׁמַיִם были совершенно безоблачно-голубые.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181702, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "weather_basic_sky",
            original = "שֶׁמֶשׁ", translation = "солнце",
            transliteration = "шемеш",
            definition = "הַכּוֹכָב הַגָּדוֹל וְהַחַם שֶׁמֵּאִיר אֶת הָאָרֶץ בַּיּוֹם.",
            definitionNative = "Большое горячее светило, что освещает Землю днём.",
            example = "הַשֶּׁמֶשׁ זָרְחָה בַּחֲלוֹן הַחֶדֶר שֶׁלִּי.",
            exampleNative = "שֶׁמֶשׁ заглянуло в окно моей комнаты с самого утра.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181703, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "weather_basic_sky",
            original = "כּוֹכָב", translation = "звезда",
            transliteration = "кохав",
            definition = "נְקֻדַּת אוֹר רְחוֹקָה שֶׁנִּרְאֵית בַּלַּיְלָה הַבָּהִיר.",
            definitionNative = "Далёкая светящаяся точка, что видна в небе ясной ночью.",
            example = "רָאִיתִי כּוֹכָב נוֹפֵל מֵעַל הַיָּם בַּלַּיְלָה.",
            exampleNative = "Я увидел падающий כּוֹכָב над морем поздним вечером.",
         fillInBlankExclusions = listOf(181701L, 181702L, 181704L, 181705L)),
        WordEntity(
            id = 181704, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "weather_basic_sky",
            original = "יָרֵחַ", translation = "луна",
            transliteration = "ярэах",
            definition = "הַגּוּף הָעָגֹל שֶׁמֵּאִיר אֶת הַלַּיְלָה וּמַחֲלִיף צוּרָה כָּל חֹדֶשׁ.",
            definitionNative = "Округлое светило ночного неба, меняющее форму каждый месяц.",
            example = "הַיָּרֵחַ הָיָה מָלֵא וְעָגֹל מֵעַל הָהָר.",
            exampleNative = "יָרֵחַ был полным и круглым прямо над горой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181705, setId = 1817, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_basic_sky",
            original = "אַקְלִים", translation = "климат",
            transliteration = "аклим",
            definition = "אֹפִי הַמֶּזֶג הַשָּׁכִיחַ בְּאֵזוֹר מְסֻיָּם לְאֹרֶךְ שָׁנִים.",
            definitionNative = "Типичная погода в каком-то регионе на протяжении многих лет.",
            example = "הָאַקְלִים בְּיִשְׂרָאֵל יָבֵשׁ בַּקַּיִץ וְגָשׁוּם בַּחֹרֶף.",
            exampleNative = "אַקְלִים в Израиле сухой летом и дождливый зимой.",
         fillInBlankExclusions = listOf(181701L, 181702L, 181703L, 181704L)),

        // ─── weather_basic_precip (5) ────────────────────────────────────
        WordEntity(
            id = 181706, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "weather_basic_precip",
            original = "גֶּשֶׁם", translation = "дождь",
            transliteration = "гешем",
            definition = "מַיִם שֶׁנּוֹפְלִים מֵהַשָּׁמַיִם בְּטִפּוֹת קְטַנּוֹת.",
            definitionNative = "Вода, что падает с неба маленькими каплями.",
            example = "הַגֶּשֶׁם הִתְחִיל פִּתְאֹם וְכֻלָּם רָצוּ הַבַּיְתָה.",
            exampleNative = "גֶּשֶׁם начался внезапно, и все побежали по домам.",
         fillInBlankExclusions = listOf(181707L, 181708L, 181709L)),
        WordEntity(
            id = 181707, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "weather_basic_precip",
            original = "טִיפָּה", translation = "капля",
            transliteration = "типа",
            definition = "כַּמּוּת קְטַנְטַנָּה מְאוֹד שֶׁל נוֹזֵל בְּצוּרָה עֲגֻלָּה.",
            definitionNative = "Очень маленький круглый кусочек жидкости — например, воды или молока.",
            example = "טִיפָּה שֶׁל גֶּשֶׁם נָפְלָה עַל הַמַּחְבֶּרֶת שֶׁלִּי.",
            exampleNative = "Маленькая טִיפָּה дождя упала прямо мне на тетрадь.",
         fillInBlankExclusions = listOf(181708L, 181709L)),
        WordEntity(
            id = 181708, setId = 1817, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_basic_precip",
            original = "מָטָר", translation = "ливень",
            transliteration = "матар",
            definition = "גֶּשֶׁם חָזָק מְאוֹד שֶׁיּוֹרֵד בְּכַמּוּת גְּדוֹלָה לִזְמַן קָצָר.",
            definitionNative = "Очень сильный дождь, что льёт стеной короткое время.",
            example = "מָטָר כָּבֵד שָׁטַף אֶת הָרְחוֹבוֹת שֶׁל תֵּל אָבִיב.",
            exampleNative = "Сильный מָטָר залил все улицы Тель-Авива в считаные минуты.",
         fillInBlankExclusions = listOf(181706L, 181707L, 181709L)),
        WordEntity(
            id = 181709, setId = 1817, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_basic_precip",
            original = "טִפְטוּף", translation = "морось / накрапывание",
            transliteration = "тифтуф",
            definition = "גֶּשֶׁם חַלָּשׁ מְאוֹד שֶׁבּוֹ נוֹפְלוֹת טִיפּוֹת בְּקֶצֶב אִיטִי.",
            definitionNative = "Очень слабый дождик, при котором капли падают редко и медленно.",
            example = "הַטִּפְטוּף נִמְשָׁךְ כָּל הַבֹּקֶר בְּלִי לְהִתְחַזֵּק.",
            exampleNative = "טִפְטוּף моросил всё утро, так и не превращаясь в ливень.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181710, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "weather_basic_precip",
            original = "רָטוֹב", translation = "мокрый",
            transliteration = "ратов",
            definition = "מְכֻסֶּה בְּמַיִם אוֹ בְּנוֹזֵל אַחֵר אַחֲרֵי גֶּשֶׁם אוֹ מִקְלַחַת.",
            definitionNative = "Покрытый водой или другой жидкостью — после дождя или душа.",
            example = "הַתִּיק שֶׁלִּי רָטוֹב לְגַמְרֵי אַחֲרֵי הַטִּיוּל בַּגֶּשֶׁם.",
            exampleNative = "Мой рюкзак совсем רָטוֹב после прогулки под ливнем.",
         fillInBlankExclusions = listOf(181719L, 181720L)),

        // ─── weather_basic_temp (5) ──────────────────────────────────────
        WordEntity(
            id = 181711, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "weather_basic_temp",
            original = "חַם", translation = "жарко / горячий",
            transliteration = "хам",
            definition = "כְּשֶׁהַטֶּמְפֶּרָטוּרָה גְּבוֹהָה — קָשֶׁה לִנְשֹׁם וְרוֹצִים מַיִם קָרִים.",
            definitionNative = "Когда температура высокая — трудно дышать и хочется холодной воды.",
            example = "הַיּוֹם חַם מְאוֹד בַּחוּץ, אַל תֵּצֵא בְּלִי כּוֹבַע.",
            exampleNative = "Сегодня очень חַם на улице — не выходи без головного убора.",
         fillInBlankExclusions = listOf(181710L, 181716L, 181717L, 181718L, 181719L, 181720L)),
        WordEntity(
            id = 181712, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "weather_basic_temp",
            original = "קֹר", translation = "холод",
            transliteration = "кор",
            definition = "תְּחוּשָׁה שֶׁל טֶמְפֶּרָטוּרָה נְמוּכָה שֶׁגּוֹרֶמֶת לָנוּ לִרְעֹד.",
            definitionNative = "Ощущение низкой температуры — от него хочется поёжиться и закутаться.",
            example = "הַקֹּר בַּלַּיְלָה לֹא נָתַן לִי לְהֵרָדֵם בְּלִי שְׂמִיכָה.",
            exampleNative = "Ночной קֹר не давал мне уснуть без плотного одеяла.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181713, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "weather_basic_temp",
            original = "אֲוִיר", translation = "воздух",
            transliteration = "авир",
            definition = "מַה שֶּׁאָנוּ נוֹשְׁמִים — בְּלִי צֶבַע, בְּלִי רֵיחַ וּבְלִי טַעַם.",
            definitionNative = "То, чем мы дышим — без цвета, без запаха и без вкуса.",
            example = "הָאֲוִיר עַל הָהָר הַזֶּה צַח וּמְרַעֲנֵן.",
            exampleNative = "אֲוִיר на этой горе чистый и очень бодрящий.",
         fillInBlankExclusions = listOf(181712L, 181714L, 181715L)),
        WordEntity(
            id = 181714, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "weather_basic_temp",
            original = "מַעֲלוֹת", translation = "градусы",
            transliteration = "маалот",
            definition = "יְחִידוֹת שֶׁבָּהֶן מוֹדְדִים כַּמָּה חַם אוֹ קַר בָּאֲוִיר אוֹ בַּמַּיִם.",
            definitionNative = "Единицы, которыми меряют, насколько тепло или холодно в воздухе или воде.",
            example = "הַיּוֹם בַּחוּץ שְׁלוֹשִׁים וַחֲמֵשׁ מַעֲלוֹת בְּצֵל.",
            exampleNative = "Сегодня на улице тридцать пять מַעֲלוֹת в тени.",
         fillInBlankExclusions = listOf(181712L, 181713L, 181715L)),
        WordEntity(
            id = 181715, setId = 1817, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_basic_temp",
            original = "חָמְסִין", translation = "хамсин (сухой жаркий ветер)",
            transliteration = "хамсин",
            definition = "יָמִים שֶׁל אֲוִיר יָבֵשׁ וְלוֹהֵט שֶׁמַּגִּיעַ מֵהַמִּדְבָּר וּמְעִיף אָבָק.",
            definitionNative = "Дни жаркого сухого ветра из пустыни — тяжело дышать и кругом пыль.",
            example = "בַּחָמְסִין סוֹגְרִים אֶת כָּל הַחַלּוֹנוֹת בַּבַּיִת.",
            exampleNative = "Во время חָמְסִין все окна в квартире держат закрытыми.",
         fillInBlankExclusions = listOf(181712L, 181713L, 181714L)),

        // ─── weather_basic_adj (5) ───────────────────────────────────────
        WordEntity(
            id = 181716, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "weather_basic_adj",
            original = "שִׁמְשִׁי", translation = "солнечный",
            transliteration = "шимши",
            definition = "כְּשֶׁאוֹר חַם וּבָהִיר נוֹפֵל מִלְמַעְלָה וְאֵין כִּמְעַט עֲנָנִים.",
            definitionNative = "Когда тёплый яркий свет льётся сверху и облаков почти нет.",
            example = "יוֹם שִׁמְשִׁי וְנָעִים מוּשְׁלָם לְפִיקְנִיק בַּפַּארְק.",
            exampleNative = "Тёплый שִׁמְשִׁי день — идеально для пикника в парке.",
         fillInBlankExclusions = listOf(181711L, 181717L, 181718L, 181719L, 181720L)),
        WordEntity(
            id = 181717, setId = 1817, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "weather_basic_adj",
            original = "גָּשׁוּם", translation = "дождливый",
            transliteration = "гашум",
            definition = "כְּשֶׁמַּיִם נוֹפְלִים מִלְמַעְלָה כִּמְעַט בְּלִי הַפְסָקָה לְאֹרֶךְ הַיּוֹם.",
            definitionNative = "Когда вода с неба льётся почти без перерыва весь день напролёт.",
            example = "סוֹף שָׁבוּעַ גָּשׁוּם וְקַר נִשְׁאַרְנוּ בַּבַּיִת עִם סְפָרִים.",
            exampleNative = "В גָּשׁוּם прохладные выходные мы остались дома с книгами.",
         fillInBlankExclusions = listOf(181710L, 181716L, 181718L, 181719L, 181720L)),
        WordEntity(
            id = 181718, setId = 1817, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "weather_basic_adj",
            original = "מְעֻנָּן", translation = "облачный / пасмурный",
            transliteration = "меунан",
            definition = "כְּשֶׁעֲנָנִים אֲפֹרִים מְכַסִּים אֶת הַשָּׁמַיִם וְאֵין אוֹר חָזָק.",
            definitionNative = "Когда серые тучи затягивают небо и яркого света почти нет.",
            example = "בֹּקֶר מְעֻנָּן וְקַר הִתְחִיל בְּכוֹס תֵּה חַם.",
            exampleNative = "Прохладное מְעֻנָּן утро началось с чашки горячего чая.",
         fillInBlankExclusions = listOf(181710L, 181716L, 181717L, 181719L, 181720L)),
        WordEntity(
            id = 181719, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "weather_basic_adj",
            original = "יָבֵשׁ", translation = "сухой",
            transliteration = "явэш",
            definition = "כְּשֶׁאֵין מַיִם וְאֵין לַחוּת — לֹא אַחֲרֵי גֶּשֶׁם וְלֹא אַחֲרֵי שְׁטִיפָה.",
            definitionNative = "Когда нет воды и нет влаги — например, после долгой засухи.",
            example = "הָאֲדָמָה הָיְתָה יָבֵשׁ אַחֲרֵי שְׁבוּעוֹת בְּלִי גֶּשֶׁם.",
            exampleNative = "Земля стала יָבֵשׁ после многих недель без единого дождя.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181720, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "weather_basic_adj",
            original = "לַח", translation = "влажный",
            transliteration = "лах",
            definition = "כְּשֶׁיֵּשׁ הַרְבֵּה אֵדֵי מַיִם בָּאֲוִיר וְקָצָת מַזִּיעִים גַּם בִּצֵל.",
            definitionNative = "Когда в воздухе много водяных паров и потеешь даже в тени.",
            example = "אֲוִיר לַח וְכָבֵד מַקְשֶׁה לְהֵרָדֵם בַּלַּיְלָה.",
            exampleNative = "лַח тяжёлый воздух мешает уснуть до самого утра.",
         fillInBlankExclusions = listOf(181710L, 181711L, 181716L, 181717L, 181718L, 181719L)),

        // ─── weather_basic_actions (5) ───────────────────────────────────
        WordEntity(
            id = 181721, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "weather_basic_actions",
            original = "לִנְשֹׁב", translation = "дуть (о ветре)",
            transliteration = "линшов",
            definition = "כְּשֶׁאֲוִיר זָז בְּכֹחַ וּמַזִּיז עָלִים, שְׂעָרוֹת וְדַפִּים.",
            definitionNative = "Когда воздух движется с силой и шевелит листву, волосы или бумаги.",
            example = "אַחֲרֵי הַצָּהֳרַיִם הִתְחִילָה לִנְשֹׁב רוּחַ קָרָה מֵהַיָּם.",
            exampleNative = "После полудня с моря начал לִנְשֹׁב холодный ветер.",
         fillInBlankExclusions = listOf(181722L, 181723L, 181724L, 181725L)),
        WordEntity(
            id = 181722, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "weather_basic_actions",
            original = "לִקְפֹּא", translation = "замерзать",
            transliteration = "ликпо",
            definition = "לְהָפֹךְ לְמוּצָק בִּגְלַל קֹר חָזָק — כְּמוֹ מַיִם שֶׁהוֹפְכִים לְקֶרַח.",
            definitionNative = "Стать твёрдым из-за сильного холода — как вода превращается в лёд.",
            example = "בַּלַּיְלָה הַבְּרֵכָה הִתְחִילָה לִקְפֹּא מִלְמַעְלָה.",
            exampleNative = "Ночью пруд начал לִקְפֹּא с самой поверхности.",
         fillInBlankExclusions = listOf(181721L, 181723L, 181724L, 181725L)),
        WordEntity(
            id = 181723, setId = 1817, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "weather_basic_actions",
            original = "לְהַזִּיעַ", translation = "потеть",
            transliteration = "лехазиа",
            definition = "לְהוֹצִיא טִיפּוֹת מַיִם מֵהָעוֹר כְּשֶׁחַם אוֹ מִתְעַמְּלִים.",
            definitionNative = "Выделять капельки воды на коже от жары или от физической нагрузки.",
            example = "הִתְחַלְתִּי לְהַזִּיעַ מִיָּד אַחֲרֵי שֶׁיָּצָאתִי לַשֶּׁמֶשׁ.",
            exampleNative = "Я начал לְהַזִּיעַ сразу же, как вышел на солнцепёк.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181724, setId = 1817, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "weather_basic_actions",
            original = "לְקָרֵר", translation = "охлаждать",
            transliteration = "лекарэр",
            definition = "לְהוֹרִיד אֶת הַטֶּמְפֶּרָטוּרָה שֶׁל מַשֶּׁהוּ — אֲוִיר, שְׁתִיָּה אוֹ אֹכֶל.",
            definitionNative = "Понижать температуру чего-то — воздуха, напитка или еды.",
            example = "הַמַּזְגָן עָזַר לְקָרֵר אֶת הַחֶדֶר תּוֹךְ דַּקּוֹת.",
            exampleNative = "Кондиционер помог לְקָרֵר комнату всего за пару минут.",
         fillInBlankExclusions = listOf(181721L, 181722L, 181723L, 181725L)),
        WordEntity(
            id = 181725, setId = 1817, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "weather_basic_actions",
            original = "לְהַמֵּס", translation = "растапливать (лёд, снег)",
            transliteration = "лехамэс",
            definition = "לְהָפֹךְ מוּצָק לְנוֹזֵל בְּעֶזְרַת חֹם — כְּמוֹ קֶרַח אוֹ שׁוֹקוֹלָד.",
            definitionNative = "Превращать твёрдое в жидкое с помощью тепла — например, лёд или шоколад.",
            example = "הַשֶּׁמֶשׁ הִתְחִילָה לְהַמֵּס אֶת הַשֶּׁלֶג עַל הַגַּג.",
            exampleNative = "Солнце начало לְהַמֵּס снег прямо на крыше.",
         fillInBlankExclusions = listOf(181721L, 181722L, 181723L, 181724L)),
    )
}
