package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Погода и климат", level 4 (B2-C1).
 * Один сет × 25 слов. setId = 1820.
 *
 *  - 17 EPIC + 8 RARE (два смежных уровня C1 + B2, EPIC доминирует на L4).
 *  - 5 семантических групп по 5 слов:
 *      weather_l4_phenomena_advanced — продвинутые погодные явления (5)
 *      weather_l4_climate_science    — климатологическая наука (5)
 *      weather_l4_extreme_events     — экстремальные события (5)
 *      weather_l4_seasonal_pro       — сезонные термины (5)
 *      weather_l4_descriptive_high   — высокая описательная лексика (5)
 *  - Профессиональная лексика по «Погоде и климату» на иврите.
 *    Никудим везде (стандарт he-ru).
 *  - Все 25 слов проверены grep'ом по `original = "..."` против всех
 *    WordDataHebrew*.kt и не пересекаются с set 1817 (L1), 1818 (L2),
 *    1819 (L3), AchievementRewards и тематическими батчами.
 *    Замены из-за дублей:
 *      • вместо בָּרָק/רַעַם (в Achievement и More) — אֲבוּקַת בָּרָק
 *        (молниевый разряд) и רֹעַם (грохот, словарная форма).
 *      • вместо סוֹעֵר/שׁוֹטֵף (в Achievement) — мультиязычные синонимы
 *        и описательные пары.
 *      • вместо תְּכֵלֶת/בָּהִיר (в Batch33/27) — אַזּוּרִי (книжно-лазурный)
 *        и נִשְׂגָּב (величественный).
 *      • вместо שָׁרָב (Immigrant4) — חֲמַת שָׁרָב (волна жары) как
 *        составное и сезонное.
 *  - fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь;
 *    FILL_IN_BLANK pipeline инжектит их централизованно после wave.
 */
object WordDataHebrewWeatherL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1820, languagePair = "he-ru", orderIndex = 1820,
            name = "Погода и климат",
            description = "Климатология, экстремальные явления и сезонная терминология",
            topic = "Погода и климат", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── weather_l4_phenomena_advanced (5) ───────────────────────────
        WordEntity(
            id = 182001, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l4_phenomena_advanced",
            original = "הִילָּה", translation = "гало (вокруг солнца или луны)",
            transliteration = "hila",
            definition = "טַבַּעַת אוֹר עֲגֻלָּה סְבִיב הַשֶּׁמֶשׁ אוֹ הַיָּרֵחַ הַנּוֹצֶרֶת בִּגְלַל גְּבִישֵׁי קֶרַח גְּבוֹהִים.",
            definitionNative = "Круглое световое кольцо вокруг солнца или луны, что рисуют ледяные кристаллы высоко в небе.",
            example = "הִילָּה כְּסוּפָה סָבְבָה אֶת הַיָּרֵחַ לִפְנֵי שֶׁהִתְקַלְקֵל הַמֶּזֶג.",
            exampleNative = "Серебристая הִילָּה окружила луну незадолго до того, как испортилась погода.",
         fillInBlankExclusions = listOf(182002L, 182003L)),
        WordEntity(
            id = 182002, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l4_phenomena_advanced",
            original = "פַּרְהֶלְיוֹן", translation = "ложное солнце (паргелий)",
            transliteration = "паргельон",
            definition = "כֶּתֶם אוֹר בָּהִיר לְצַד הַשֶּׁמֶשׁ שֶׁנּוֹצָר עַל יְדֵי גְּבִישֵׁי קֶרַח שְׁטוּחִים.",
            definitionNative = "Яркое световое пятно сбоку от солнца, что создают плоские ледяные кристаллы.",
            example = "מְטַיְּלֵי הָאַנְטַרְקְטִיקָה צִלְּמוּ פַּרְהֶלְיוֹן בָּהִיר עַל הַשֶּׁלֶג.",
            exampleNative = "Полярники сфотографировали яркий פַּרְהֶלְיוֹן над снежной равниной.",
         fillInBlankExclusions = listOf(182001L, 182003L)),
        WordEntity(
            id = 182003, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l4_phenomena_advanced",
            original = "מִקְסָם", translation = "мираж",
            transliteration = "миксам",
            definition = "תְּמוּנַת רְאִי שֶׁנִּרְאֵית בַּמִּדְבָּר בִּגְלַל שִׁכְבוֹת אֲוִיר חַם בִּטְמְפֶּרָטוּרוֹת שׁוֹנוֹת.",
            definitionNative = "Зрительный обман, что виден в пустыне из-за слоёв воздуха разной температуры.",
            example = "הַנָּהָג רָאָה מִקְסָם שֶׁל מַיִם עַל הַכְּבִישׁ הַלּוֹהֵט.",
            exampleNative = "Водитель увидел מִקְסָם воды посреди раскалённой дороги.",
         fillInBlankExclusions = listOf(182001L, 182002L)),
        WordEntity(
            id = 182004, setId = 1820, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "weather_l4_phenomena_advanced",
            original = "סוּפַת אָבָק", translation = "пыльная буря",
            transliteration = "суфат авак",
            definition = "רוּחַ חֲזָקָה שֶׁמְּרִימָה עֲנָנֵי אָבָק עֲצוּמִים וּמַחְשִׁיכָה אֶת הָאוֹפֶק.",
            definitionNative = "Сильный ветер, что поднимает огромные облака пыли и помрачает горизонт.",
            example = "סוּפַת אָבָק הִשְׁתִּיקָה אֶת הַנְּמַל בְּאֵילַת לְכָל הַיּוֹם.",
            exampleNative = "סוּפַת אָבָק обездвижила порт в Эйлате на целый день.",
         fillInBlankExclusions = listOf(182005L, 182013L)),
        WordEntity(
            id = 182005, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "weather_l4_phenomena_advanced",
            original = "אֲבוּקַת בָּרָק", translation = "молниевый разряд",
            transliteration = "авукат барак",
            definition = "פֶּרֶץ אוֹר חַשְׁמַלִּי קָצָר וְעָצוּם בֵּין עָנָן לָאָרֶץ אוֹ בֵּין עֲנָנִים.",
            definitionNative = "Короткая мощная электрическая вспышка между тучей и землёй или меж тучами.",
            example = "אֲבוּקַת בָּרָק יְחִידָה הֵאִירָה אֶת הַשָּׁמַיִם וְקָרְעָה אֶת הַשֶּׁקֶט.",
            exampleNative = "Одиночный אֲבוּקַת בָּרָק осветил небо и расколол тишину.",
         fillInBlankExclusions = listOf(182004L)),

        // ─── weather_l4_climate_science (5) ──────────────────────────────
        WordEntity(
            id = 182006, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l4_climate_science",
            original = "אִיזוֹבָּרָה", translation = "изобара",
            transliteration = "изобара",
            definition = "קַו עַל מַפַּת מֶזֶג שֶׁמְּחַבֵּר נְקֻדּוֹת בַּעֲלוֹת אוֹתוֹ לַחַץ אֲוִיר.",
            definitionNative = "Линия на синоптической карте, соединяющая точки с одинаковым давлением воздуха.",
            example = "אִיזוֹבָּרָה צְפוּפָה מְצַיֶּנֶת רוּחַ חֲזָקָה בָּאֵזוֹר.",
            exampleNative = "Густая אִיזוֹבָּרָה указывает на сильный ветер в данной зоне.",
         fillInBlankExclusions = listOf(182007L, 182008L, 182010L)),
        WordEntity(
            id = 182007, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l4_climate_science",
            original = "אִיזוֹתֶרְמָה", translation = "изотерма",
            transliteration = "изотерма",
            definition = "קַו עַל מַפַּת אַקְלִים שֶׁמְּחַבֵּר נְקֻדּוֹת בַּעֲלוֹת אוֹתָהּ טֶמְפֶּרָטוּרָה מְמֻצַּעַת.",
            definitionNative = "Линия на климатической карте, соединяющая точки с одинаковой средней температурой.",
            example = "הָאִיזוֹתֶרְמָה שֶׁל יוּלִי עוֹבֶרֶת מַמָּשׁ דֶּרֶךְ הָעֵמֶק שֶׁלָּנוּ.",
            exampleNative = "Июльская אִיזוֹתֶרְמָה проходит прямо через нашу долину.",
         fillInBlankExclusions = listOf(182006L, 182008L, 182010L)),
        WordEntity(
            id = 182008, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l4_climate_science",
            original = "הַסָּעָה", translation = "адвекция (горизонтальный перенос)",
            transliteration = "haса'a",
            definition = "תַּהֲלִיךְ שֶׁל הַעֲבָרַת חֹם אוֹ לַחוּת בְּאוֹפֶן אֳפָקִי דֶּרֶךְ זְרָם רוּחַ יַצִּיב.",
            definitionNative = "Процесс переноса тепла или влаги по горизонтали ровным потоком ветра.",
            example = "הַסָּעָה שֶׁל אֲוִיר חַם מִדָּרוֹם הִמַּסָּה אֶת הַשֶּׁלֶג בְּלַיְלָה אֶחָד.",
            exampleNative = "הַסָּעָה тёплого воздуха с юга растопила снег за одну ночь.",
         fillInBlankExclusions = listOf(182006L, 182007L, 182010L)),
        WordEntity(
            id = 182009, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "weather_l4_climate_science",
            original = "הִיפּוּךְ טֶמְפֶּרָטוּרָה", translation = "температурная инверсия",
            transliteration = "hipух температура",
            definition = "מַצָּב לֹא רָגִיל שֶׁבּוֹ אֲוִיר חַם נִמְצָא מֵעַל אֲוִיר קַר וְלֹא הָפוּךְ.",
            definitionNative = "Необычное состояние, когда тёплый воздух лежит над холодным, а не наоборот.",
            example = "הִיפּוּךְ טֶמְפֶּרָטוּרָה כָּלָא אֶת זִהוּם הָאֲוִיר מֵעַל הָעִיר.",
            exampleNative = "הִיפּוּךְ טֶמְפֶּרָטוּרָה запер смог над городом на несколько дней.",
        ),
        WordEntity(
            id = 182010, setId = 1820, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l4_climate_science",
            original = "אַקְלִימוֹלוֹגְיָה", translation = "климатология",
            transliteration = "аклимология",
            definition = "תְּחוּם הַמַּדָּע שֶׁחוֹקֵר אֶת הָאַקְלִים, מְגַמּוֹתָיו וְשִׁנּוּיָיו לְאֹרֶךְ זְמַן רַב.",
            definitionNative = "Раздел науки, что изучает климат, его тенденции и изменения в долгом времени.",
            example = "סְטוּדֶנְטִים שֶׁל אַקְלִימוֹלוֹגְיָה מְנַתְּחִים נְתוּנִים שֶׁל מֵאוֹת שָׁנִים.",
            exampleNative = "Студенты אַקְלִימוֹלוֹגְיָה анализируют данные за сотни лет.",
         fillInBlankExclusions = listOf(182006L, 182007L, 182008L)),

        // ─── weather_l4_extreme_events (5) ───────────────────────────────
        WordEntity(
            id = 182011, setId = 1820, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l4_extreme_events",
            original = "הוּרִיקָן", translation = "ураган",
            transliteration = "хурикан",
            definition = "סוּפָה טְרוֹפִּית עֲנָקִית עִם רוּחוֹת שֶׁל מֵאַת קִילוֹמֶטֶר לְשָׁעָה וִיוֹתֵר.",
            definitionNative = "Огромная тропическая буря с ветрами в сотню километров в час и больше.",
            example = "הוּרִיקָן שָׁטַף אֶת חוֹף פְלוֹרִידָה וְהִשְׁאִיר חֻרְבָּן אַחֲרָיו.",
            exampleNative = "הוּרִיקָן пронёсся по побережью Флориды и оставил за собой разруху.",
         fillInBlankExclusions = listOf(182012L, 182014L, 182015L, 182018L)),
        WordEntity(
            id = 182012, setId = 1820, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l4_extreme_events",
            original = "טַיְפוּן", translation = "тайфун",
            transliteration = "тайфун",
            definition = "סוּפָה טְרוֹפִּית עֲצוּמָה בָּאוֹקְיָנוֹס הַשָּׁקֵט שֶׁמַּכָּה בְּדָרוֹם-מִזְרָח אַסְיָה.",
            definitionNative = "Огромная тропическая буря в Тихом океане, что бьёт по Юго-Восточной Азии.",
            example = "הַטַּיְפוּן הִשְׁבִּית אֶת נְמַל יוֹקוֹהָמָה לִשְׁלוֹשָׁה יָמִים.",
            exampleNative = "טַיְפוּן парализовал порт Иокогамы на три дня.",
        ),
        WordEntity(
            id = 182013, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "weather_l4_extreme_events",
            original = "סוּפַת שֶׁלֶג", translation = "снежная буря, метель",
            transliteration = "суфат шелег",
            definition = "סוּפָה חֲזָקָה שֶׁל רוּחוֹת קָרוֹת וּשְׁלָגִים שֶׁמַּפְחִיתָה אֶת הָרְאוּת לְכִמְעַט אֶפֶס.",
            definitionNative = "Сильная буря из ледяных ветров и снега, что почти полностью гасит видимость.",
            example = "סוּפַת שֶׁלֶג כָּבְדָה כָּבְשָׁה אֶת חֶרְמוֹן וְסָגְרָה אֶת הָאֲתָר.",
            exampleNative = "Тяжёлая סוּפַת שֶׁלֶג накрыла Хермон и закрыла курорт.",
         fillInBlankExclusions = listOf(182004L)),
        WordEntity(
            id = 182014, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l4_extreme_events",
            original = "מַעֲרְבֹּלֶת", translation = "вихрь, водоворот воздуха",
            transliteration = "маарволет",
            definition = "סִיבוּב חָזָק שֶׁל אֲוִיר אוֹ מַיִם בִּמְהִירוּת רַבָּה סְבִיב צִיר אֶחָד.",
            definitionNative = "Сильное стремительное вращение воздуха или воды вокруг одной оси.",
            example = "מַעֲרְבֹּלֶת שֶׁל עָלִים וַעֲפָרִית עָבְרָה דֶּרֶךְ הַחָצֵר.",
            exampleNative = "מַעֲרְבֹּלֶת из листьев и пыли пронеслась через двор.",
         fillInBlankExclusions = listOf(182011L, 182012L, 182015L)),
        WordEntity(
            id = 182015, setId = 1820, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l4_extreme_events",
            original = "רֹעַם", translation = "грохот, раскат грома",
            transliteration = "роам",
            definition = "צְלִיל חָזָק וְעָמֹק שֶׁמַּגִּיעַ אַחֲרֵי בָּרָק וְנִשְׁמָע מֵעַל מֶרְחָק רַב.",
            definitionNative = "Мощный глубокий звук, что приходит после молнии и слышен на большом расстоянии.",
            example = "רֹעַם כָּבֵד נִשְׁמַע מֵעַל הָהָרִים כָּל הַלַּיְלָה.",
            exampleNative = "Тяжёлый רֹעַם гремел над горами всю ночь напролёт.",
         fillInBlankExclusions = listOf(182011L, 182012L, 182014L)),

        // ─── weather_l4_seasonal_pro (5) ─────────────────────────────────
        WordEntity(
            id = 182016, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l4_seasonal_pro",
            original = "הֶפֵּךְ הַחַמָּה", translation = "солнцестояние",
            transliteration = "hэфэх hа-хама",
            definition = "הַיּוֹם הָאָרֹךְ אוֹ הַקָּצָר בְּיוֹתֵר בַּשָּׁנָה כְּשֶׁהַשֶּׁמֶשׁ עוֹמֶדֶת בִּקְצֵה מַסְלוּלָהּ.",
            definitionNative = "Самый длинный или короткий день в году, когда солнце стоит на пределе своего пути.",
            example = "בְּהֶפֵּךְ הַחַמָּה בִּדְצֶמְבֶּר הַחֹשֶׁךְ יוֹרֵד כְּבָר אַחֲרֵי אַרְבַּע.",
            exampleNative = "В декабрьское הֶפֵּךְ הַחַמָּה темнеет уже после четырёх часов дня.",
         fillInBlankExclusions = listOf(182018L)),
        WordEntity(
            id = 182017, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "weather_l4_seasonal_pro",
            original = "שִׁוְיוֹן הַיּוֹם וְהַלַּיְלָה", translation = "равноденствие",
            transliteration = "шивйон hа-йом ве-hа-лайла",
            definition = "יוֹם פַּעֲמַיִם בַּשָּׁנָה שֶׁבּוֹ אֹרֶךְ הַיּוֹם שָׁוֶה בְּדִיּוּק לְאֹרֶךְ הַלַּיְלָה.",
            definitionNative = "День два раза в году, когда длительность дня в точности равна длительности ночи.",
            example = "שִׁוְיוֹן הַיּוֹם וְהַלַּיְלָה שֶׁל הָאָבִיב חָל בְּסוֹף מַרְץ.",
            exampleNative = "Весеннее שִׁוְיוֹן הַיּוֹם וְהַלַּיְלָה выпадает на конец марта.",
         fillInBlankExclusions = listOf(182019L, 182020L)),
        WordEntity(
            id = 182018, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l4_seasonal_pro",
            original = "מוּנְסוֹן", translation = "муссон",
            transliteration = "мунсон",
            definition = "רוּחַ עוֹנָתִית שֶׁמְּחַלֶּפֶת אֶת כִּוּוּנָהּ וּמְבִיאָה גְּשָׁמִים עֲצוּמִים לְדָרוֹם אַסְיָה.",
            definitionNative = "Сезонный ветер, что меняет направление и приносит мощные дожди в Южную Азию.",
            example = "הַמוּנְסוֹן הַהֹדִי הִתְחִיל הַשָּׁנָה שָׁבוּעַ מֻקְדָּם.",
            exampleNative = "В этом году индийский מוּנְסוֹן начался на неделю раньше срока.",
         fillInBlankExclusions = listOf(182011L, 182012L, 182016L)),
        WordEntity(
            id = 182019, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "weather_l4_seasonal_pro",
            original = "רוּחַ פַּסָּט", translation = "пассат",
            transliteration = "руах пасат",
            definition = "רוּחַ קְבוּעָה שֶׁנּוֹשֶׁבֶת מִצַּד אֶחָד בָּאֵזוֹרִים הַטְּרוֹפִּיִּים שָׁנָה שְׁלֵמָה.",
            definitionNative = "Постоянный ветер, что дует с одной стороны в тропических широтах круглый год.",
            example = "סִירוֹת מִפְרָשׂ הִשְׁתַּמְּשׁוּ בְּ רוּחַ פַּסָּט לַחֲצוֹת אֶת הָאַטְלַנְטִי.",
            exampleNative = "Парусники использовали רוּחַ פַּסָּט, чтобы пересечь Атлантику.",
         fillInBlankExclusions = listOf(182017L, 182020L)),
        WordEntity(
            id = 182020, setId = 1820, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "weather_l4_seasonal_pro",
            original = "חֲמַת שָׁרָב", translation = "волна жары",
            transliteration = "хамат шарав",
            definition = "תְּקוּפָה אֲרֻכָּה שֶׁל יָמִים חַמִּים בִּמְיֻחָד הַגְּבוֹהִים בְּהַרְבֵּה מֵהַמְּמֻצָּע הָעוֹנָתִי.",
            definitionNative = "Длительный период особенно жарких дней, температура которых сильно выше сезонной средней.",
            example = "חֲמַת שָׁרָב כְּבֵדָה הִשְׁתַּלְּטָה עַל הָאָרֶץ לִשְׁבוּעַיִם.",
            exampleNative = "Тяжёлая חֲמַת שָׁרָב держала страну две недели подряд.",
         fillInBlankExclusions = listOf(182017L, 182019L)),

        // ─── weather_l4_descriptive_high (5) ─────────────────────────────
        WordEntity(
            id = 182021, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "weather_l4_descriptive_high",
            original = "אַזּוּרִי", translation = "лазурный (книжн.)",
            transliteration = "азури",
            definition = "כָּחֹל בָּהִיר וְעָמֹק כְּמוֹ צֶבַע יָם פָּתוּחַ בְּיוֹם נְעִים — בִּלְשׁוֹן סִפְרוּתִית.",
            definitionNative = "Глубокий ясный синий, как цвет открытого моря в погожий день — слово книжное.",
            example = "הַשָּׁמַיִם הִתְפַּשְּׁטוּ אַזּוּרִיִּים מֵעַל הַחוֹף הַשָּׁקֵט.",
            exampleNative = "Небеса распростёрлись אַזּוּרִי над тихим побережьем.",
         fillInBlankExclusions = listOf(182022L, 182023L, 182024L, 182025L)),
        WordEntity(
            id = 182022, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "weather_l4_descriptive_high",
            original = "מָעֻרְפָּל", translation = "мглистый",
            transliteration = "меурпаль",
            definition = "מְכֻסֶּה בְּעֲרָפֶל קַל אוֹ בְּאוֹב שֶׁמְּטַשְׁטֵשׁ אֶת קַוֵּי הָאוֹפֶק.",
            definitionNative = "Покрытый лёгким туманом или дымкой, что стирает контуры горизонта.",
            example = "בֹּקֶר מָעֻרְפָּל שָׁכַן עַל הַגְּבָעוֹת מִסָּבִיב לִיֵרוּשָׁלַיִם.",
            exampleNative = "מָעֻרְפָּל утро лежало на холмах вокруг Иерусалима.",
         fillInBlankExclusions = listOf(182021L, 182023L, 182024L, 182025L)),
        WordEntity(
            id = 182023, setId = 1820, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "weather_l4_descriptive_high",
            original = "רוֹעֵם", translation = "грозовой, гремящий",
            transliteration = "роэм",
            definition = "מָלֵא רַעַם עָז וְקוֹלוֹת חֲזָקִים — עַל שָׁמַיִם, סוּפָה אוֹ עָנָן.",
            definitionNative = "Полный мощных раскатов и громовых звуков — о небе, грозе или туче.",
            example = "שָׁמַיִם רוֹעֲמִים נִפְתְּחוּ פִּתְאוֹם מֵעַל הַכִּפָּר.",
            exampleNative = "רוֹעֵם небосвод внезапно раскрылся над посёлком.",
        ),
        WordEntity(
            id = 182024, setId = 1820, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l4_descriptive_high",
            original = "נִשְׂגָּב", translation = "величественный, безбрежный (о пейзаже)",
            transliteration = "нисгав",
            definition = "גָּדוֹל וְעָצוּם בְּאוֹפֶן שֶׁמְּעוֹרֵר יִרְאַת כָּבוֹד — עַל נוֹף, שָׁמַיִם אוֹ סוּפָה.",
            definitionNative = "Огромный и грандиозный так, что вызывает благоговение — о пейзаже, небе или буре.",
            example = "מַרְאֶה נִשְׂגָּב שֶׁל סוּפָה הִתְקָרֵב מֵהַיָּם.",
            exampleNative = "נִשְׂגָּב облик грозы приближался со стороны моря.",
         fillInBlankExclusions = listOf(182021L, 182022L, 182023L, 182025L)),
        WordEntity(
            id = 182025, setId = 1820, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l4_descriptive_high",
            original = "מְקַדֵּר", translation = "хмурый, мрачный (о погоде, книжн.)",
            transliteration = "мекадэр",
            definition = "שֶׁעוֹשֶׂה אֶת הָאֲוִיר אוֹ הַשָּׁמַיִם אֲפוֹרִים וְעַצְבָנִיִּים — עַל מֶזֶג כָּבֵד.",
            definitionNative = "Делающий воздух или небо серыми и тоскливыми — о тяжёлой погоде.",
            example = "מֶזֶג מְקַדֵּר עוֹטֵף אֶת הָעִיר זֶה שָׁבוּעַ.",
            exampleNative = "מְקַדֵּר настрой неба окутывает город уже неделю.",
         fillInBlankExclusions = listOf(182021L, 182022L, 182023L, 182024L)),
    )
}
