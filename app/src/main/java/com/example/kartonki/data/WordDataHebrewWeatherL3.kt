package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Погода и климат", level 3 (B2-C1).
 * Один сет × 25 слов. setId = 1819.
 *
 *  - 18 RARE + 7 EPIC (два смежных уровня B2 + C1).
 *  - 5 семантических групп по 5 слов:
 *      weather_l3_meteorology — метеорология и приборы (5)
 *      weather_l3_systems     — атмосферные системы и циклоны (5)
 *      weather_l3_climate     — климатические зоны (5)
 *      weather_l3_processes   — физические процессы погоды (5)
 *      weather_l3_severity    — описания тяжёлой/мрачной погоды (5)
 *  - Углублённая лексика по теме «Погода и климат» на иврите.
 *    Никудим везде (стандарт he-ru).
 *  - Все 25 слов проверены grep'ом по `original = "..."` против всех
 *    WordDataHebrew*.kt файлов и не пересекаются с set 1817 (L1) и
 *    другими тематически близкими наборами. Замены из-за дублей:
 *      • вместо שׁוֹטֵף ("проливной") — מַבּוּלִי, потому что שׁוֹטֵף
 *        занят в AchievementRewards в смысле "беглый/fluent".
 *      • вместо קוֹדֵר/סוֹעֵר — סַגְרִירִי, потому что первые два заняты
 *        в AchievementRewards.
 *      • вместо לְאַדּוֹת — לְהִתְאַדּוֹת (рефлексивная форма правильнее
 *        для метеорологии; לְאַדּוֹת занята в кулинарном Batch64).
 *  - fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь;
 *    FILL_IN_BLANK pipeline инжектит их централизованно после wave.
 */
object WordDataHebrewWeatherL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1819, languagePair = "he-ru", orderIndex = 1819,
            name = "Погода и климат",
            description = "Метеорология, циклоны и климатические зоны",
            topic = "Погода и климат", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── weather_l3_meteorology (5) ──────────────────────────────────
        WordEntity(
            id = 181901, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l3_meteorology",
            original = "מֶטֵאוֹרוֹלוֹג", translation = "синоптик",
            transliteration = "метеоролог",
            definition = "מַדְעָן שֶׁחוֹקֵר אֶת הָאֲוִיר וְחוֹזֶה מַה יִּקְרֶה בַּשָּׁמַיִם.",
            definitionNative = "Учёный, который изучает воздух и предсказывает, что будет на небе.",
            example = "הַמֶּטֵאוֹרוֹלוֹג הִזְהִיר מִגֶּשֶׁם כָּבֵד בְּסוֹף הַשָּׁבוּעַ.",
            exampleNative = "מֶטֵאוֹרוֹלוֹג предупредил о сильных дождях к выходным.",
        ),
        WordEntity(
            id = 181902, setId = 1819, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "weather_l3_meteorology",
            original = "סִינוֹפְּטִי", translation = "синоптический",
            transliteration = "синопти",
            definition = "מַרְאֶה אֶת תְּמוּנַת הָאֲוִיר עַל שֶׁטַח רָחָב בְּרֶגַע אֶחָד.",
            definitionNative = "Показывающий целиком картину воздуха над большой территорией в один миг.",
            example = "הַמַּפָּה הַסִּינוֹפְּטִית הֶרְאֲתָה שֶׁפֶל עָמֹק מֵעַל הַיָּם.",
            exampleNative = "סִינוֹפְּטִי карта показывала глубокий минимум над морем.",
        ),
        WordEntity(
            id = 181903, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l3_meteorology",
            original = "בָּרוֹמֶטֶר", translation = "барометр",
            transliteration = "барометер",
            definition = "מַכְשִׁיר שֶׁמּוֹדֵד אֶת לַחַץ הָאֲוִיר וְעוֹזֵר לָדַעַת אִם יָבוֹא גֶּשֶׁם.",
            definitionNative = "Прибор, который мерит давление воздуха и помогает узнать, будет ли дождь.",
            example = "הַבָּרוֹמֶטֶר עַל הַקִּיר יָרַד מֵהַבֹּקֶר וְהוֹדִיעַ עַל סוּפָה.",
            exampleNative = "בָּרוֹמֶטֶר на стене падал с утра и предвещал бурю.",
         fillInBlankExclusions = listOf(181901L, 181904L, 181905L)),
        WordEntity(
            id = 181904, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l3_meteorology",
            original = "מַסַּת אֲוִיר", translation = "воздушная масса",
            transliteration = "масат авир",
            definition = "גּוּשׁ עָצוּם שֶׁל אֲוִיר עִם אוֹתָהּ טֶמְפֶּרָטוּרָה וְלַחוּת בְּכָל שְׁטָחוֹ.",
            definitionNative = "Огромное тело воздуха с одинаковой температурой и влажностью на всём протяжении.",
            example = "מַסַּת אֲוִיר קָרָה מִצָּפוֹן הִגִּיעָה אֶל הָאָרֶץ בַּלַּיְלָה.",
            exampleNative = "Холодная מַסַּת אֲוִיר с севера дошла до страны ночью.",
         fillInBlankExclusions = listOf(181901L, 181903L, 181905L)),
        WordEntity(
            id = 181905, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l3_meteorology",
            original = "אַזְהָרָה מֶטֵאוֹרוֹלוֹגִית", translation = "штормовое предупреждение",
            transliteration = "азхара метеорологит",
            definition = "הוֹדָעָה רִשְׁמִית עַל מֶזֶג אֲוִיר חָמוּר שֶׁמַּגִּיעַ אֶל אֵזוֹר מְסֻיָּם.",
            definitionNative = "Официальное сообщение о суровой погоде, которая идёт в данный регион.",
            example = "הַשֵּׁרוּת פִּרְסֵם אַזְהָרָה מֶטֵאוֹרוֹלוֹגִית עַל הֲצָפוֹת בַּדָּרוֹם.",
            exampleNative = "Служба выпустила אַזְהָרָה מֶטֵאוֹרוֹלוֹגִית о наводнениях на юге.",
         fillInBlankExclusions = listOf(181901L, 181903L, 181904L)),

        // ─── weather_l3_systems (5) ──────────────────────────────────────
        WordEntity(
            id = 181906, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l3_systems",
            original = "חֲזִית קָרָה", translation = "холодный фронт",
            transliteration = "хазит кара",
            definition = "הַגְּבוּל בֵּין אֲוִיר חַם לַאֲוִיר קַר שֶׁבּוֹ הַמֶּזֶג מִשְׁתַּנֶּה מְהֵרָה.",
            definitionNative = "Граница между тёплым и холодным воздухом, где погода меняется быстро.",
            example = "חֲזִית קָרָה עָבְרָה מֵעַל הָאָרֶץ וְהוֹרִידָה אֶת הַטֶּמְפֶּרָטוּרָה.",
            exampleNative = "חֲזִית קָרָה прошла над страной и сбила температуру.",
         fillInBlankExclusions = listOf(181904L, 181907L, 181908L, 181909L, 181910L)),
        WordEntity(
            id = 181907, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l3_systems",
            original = "צִיקְלוֹן", translation = "циклон",
            transliteration = "циклон",
            definition = "מַעֲרֶכֶת שֶׁל לַחַץ נָמוּךְ בָּהּ הָאֲוִיר מִסְתּוֹבֵב וּמֵבִיא גֶּשֶׁם וְרוּחַ.",
            definitionNative = "Система низкого давления, в которой воздух кружит и приносит дождь и ветер.",
            example = "צִיקְלוֹן גָּדוֹל הִתְקָרֵב לְחוֹף הַיָּם וְכֻלָּם נִכְנְסוּ הַבַּיְתָה.",
            exampleNative = "Большой צִיקְלוֹן приближался к побережью, и все ушли по домам.",
         fillInBlankExclusions = listOf(181906L, 181908L, 181909L, 181910L)),
        WordEntity(
            id = 181908, setId = 1819, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l3_systems",
            original = "אַנְטִיצִיקְלוֹן", translation = "антициклон",
            transliteration = "антициклон",
            definition = "מַעֲרֶכֶת שֶׁל לַחַץ גָּבוֹהַּ שֶׁמְּבִיאָה שָׁמַיִם בְּהִירִים וּמֶזֶג יַצִּיב.",
            definitionNative = "Система высокого давления, что приносит ясное небо и устойчивую погоду.",
            example = "אַנְטִיצִיקְלוֹן יַצִּיב שָׁלַט בְּכָל הָאֵזוֹר שָׁבוּעַ שָׁלֵם.",
            exampleNative = "Устойчивый אַנְטִיצִיקְלוֹן удерживал всю область целую неделю.",
         fillInBlankExclusions = listOf(181906L, 181907L, 181909L, 181910L)),
        WordEntity(
            id = 181909, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l3_systems",
            original = "מַשַּׁב רוּחַ", translation = "порыв ветра",
            transliteration = "машав руах",
            definition = "תְּנוּעָה חֲזָקָה וּקְצָרָה שֶׁל אֲוִיר שֶׁמַּפִּילָה כּוֹבָעִים וּמַעֲנָפִים.",
            definitionNative = "Сильное короткое движение воздуха, что срывает шапки и ветви.",
            example = "מַשַּׁב רוּחַ פִּתְאוֹמִי הִפִּיל עָצִיץ מֵהַמִּרְפֶּסֶת.",
            exampleNative = "Внезапный מַשַּׁב רוּחַ сбросил горшок с балкона.",
        ),
        WordEntity(
            id = 181910, setId = 1819, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l3_systems",
            original = "טוּרְבּוּלֶנְצְיָה", translation = "турбулентность",
            transliteration = "турбуленция",
            definition = "תְּנוּעָה לֹא יַצִּיבָה שֶׁל אֲוִיר שֶׁמְּטַלְטֶלֶת מְטוֹסִים וּזְרָמִים.",
            definitionNative = "Беспорядочное движение воздуха, которое трясёт самолёты и потоки.",
            example = "הַטַּיָּס הִזְהִיר עַל טוּרְבּוּלֶנְצְיָה צְפוּיָה מֵעַל הָהָרִים.",
            exampleNative = "Пилот предупредил об ожидаемой טוּרְבּוּלֶנְצְיָה над горами.",
         fillInBlankExclusions = listOf(181904L, 181906L, 181907L, 181908L, 181909L)),

        // ─── weather_l3_climate (5) ──────────────────────────────────────
        WordEntity(
            id = 181911, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l3_climate",
            original = "טְרוֹפִּי", translation = "тропический",
            transliteration = "тропи",
            definition = "שֶׁל אֵזוֹר חַם וְלַח לְיַד קַו הַמַּשְׁוֶה עִם גְּשָׁמִים תְּכוּפִים.",
            definitionNative = "О жарком и влажном поясе у экватора с частыми дождями.",
            example = "בְּיַעַר טְרוֹפִּי גֶּשֶׁם יוֹרֵד כִּמְעַט כָּל יוֹם אַחַר הַצָּהֳרַיִם.",
            exampleNative = "В טְרוֹפִּי лесу дождь идёт почти каждый день после полудня.",
         fillInBlankExclusions = listOf(181912L, 181913L, 181914L, 181915L)),
        WordEntity(
            id = 181912, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l3_climate",
            original = "מָתוּן", translation = "умеренный",
            transliteration = "матун",
            definition = "לֹא חַם מִדַּי וְלֹא קַר מִדַּי — אֹפְיָנִי לְאֵזוֹרִים בֵּין הַטְּרוֹפִּים לַקֹּטֶב.",
            definitionNative = "Ни слишком жаркий, ни слишком холодный — типичный между тропиками и полюсом.",
            example = "אַקְלִים מָתוּן בְּצָרְפַת מַתִּיר לְגַדֵּל יְרָקוֹת בְּכָל הַשָּׁנָה.",
            exampleNative = "מָתוּן климат во Франции позволяет выращивать овощи круглый год.",
         fillInBlankExclusions = listOf(181911L, 181913L, 181914L, 181915L)),
        WordEntity(
            id = 181913, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l3_climate",
            original = "אַרְקְטִי", translation = "арктический",
            transliteration = "аркти",
            definition = "שֶׁל אֵזוֹר קַר מְאוֹד בִּקְצֵה הַצָּפוֹן שֶׁמְּכֻסֶּה בְּקֶרַח כָּל הַשָּׁנָה.",
            definitionNative = "О очень холодной зоне на крайнем севере, что покрыта льдом круглый год.",
            example = "מַסַּת אֲוִיר אַרְקְטִי הוֹרִידָה אֶת הַטֶּמְפֶּרָטוּרָה לְמִינוּס עֶשְׂרִים.",
            exampleNative = "אַרְקְטִי воздушная масса опустила температуру до минус двадцати.",
         fillInBlankExclusions = listOf(181911L, 181912L, 181914L, 181915L)),
        WordEntity(
            id = 181914, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l3_climate",
            original = "מִדְבָּרִי", translation = "пустынный",
            transliteration = "мидбари",
            definition = "שֶׁל אֵזוֹר יָבֵשׁ מְאוֹד עִם מְעַט גֶּשֶׁם וְשִׁנּוּיֵי טֶמְפֶּרָטוּרָה גְּדוֹלִים.",
            definitionNative = "О очень сухой зоне с малым количеством дождя и большими перепадами температур.",
            example = "אַקְלִים מִדְבָּרִי בָּעֲרָבָה דּוֹרֵשׁ הַשְׁקָיָה כְּבֵדָה.",
            exampleNative = "מִדְבָּרִי климат в Араве требует обильного полива.",
         fillInBlankExclusions = listOf(181911L, 181912L, 181913L, 181915L)),
        WordEntity(
            id = 181915, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l3_climate",
            original = "תַּת-טְרוֹפִּי", translation = "субтропический",
            transliteration = "тат-тропи",
            definition = "שֶׁל אֵזוֹר חַם מִיָּד מִחוּץ לַחֲגוֹרָה הַחַמָּה בְּיוֹתֵר — כְּמוֹ דְּרוֹם סְפָרַד.",
            definitionNative = "О тёплом поясе сразу за самым жарким — например, юг Испании.",
            example = "בְּפְלוֹרִידָה אַקְלִים תַּת-טְרוֹפִּי עִם חוֹרְפִים נְעִימִים.",
            exampleNative = "Во Флориде תַּת-טְרוֹפִּי климат с мягкими зимами.",
         fillInBlankExclusions = listOf(181911L, 181912L, 181913L, 181914L)),

        // ─── weather_l3_processes (5) ────────────────────────────────────
        WordEntity(
            id = 181916, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "weather_l3_processes",
            original = "לְהִתְאַדּוֹת", translation = "испаряться",
            transliteration = "леитъадот",
            definition = "לַעֲבֹר מִנּוֹזֵל לְאֵד בִּגְלַל חֹם — כְּמוֹ שְׁלוּלִית שֶׁנֶּעֱלֶמֶת בַּשֶּׁמֶשׁ.",
            definitionNative = "Превращаться из жидкости в пар из-за тепла — как лужа исчезает на солнце.",
            example = "הַמַּיִם מֵהַשְּׁלוּלִית הִתְחִילוּ לְהִתְאַדּוֹת אַחֲרֵי שֶׁיָּצְאָה הַשֶּׁמֶשׁ.",
            exampleNative = "Вода из лужи начала לְהִתְאַדּוֹת после того, как вышло солнце.",
         fillInBlankExclusions = listOf(181917L, 181918L, 181919L, 181920L)),
        WordEntity(
            id = 181917, setId = 1819, languagePair = "he-ru", rarity = "EPIC",
            pos = "verb", semanticGroup = "weather_l3_processes",
            original = "לְהִתְעַבּוֹת", translation = "конденсироваться",
            transliteration = "леитъабот",
            definition = "לַעֲבֹר מֵאֵד לְנוֹזֵל בִּגְלַל קֹר — כְּמוֹ טִיפּוֹת שֶׁנּוֹצְרוֹת עַל חַלּוֹן קַר.",
            definitionNative = "Превращаться из пара в жидкость из-за холода — как капли на холодном стекле.",
            example = "אֵדֵי הַמַּיִם הִתְחִילוּ לְהִתְעַבּוֹת עַל הַחַלּוֹן הַקַּר.",
            exampleNative = "Водяные пары начали לְהִתְעַבּוֹת на холодном окне.",
         fillInBlankExclusions = listOf(181916L, 181918L, 181919L, 181920L)),
        WordEntity(
            id = 181918, setId = 1819, languagePair = "he-ru", rarity = "EPIC",
            pos = "verb", semanticGroup = "weather_l3_processes",
            original = "לְהִתְפַּזֵּר", translation = "рассеиваться",
            transliteration = "леитпазер",
            definition = "לֵיעָלֵם לְאַט וּלְהִתְפָּרֵק — כְּמוֹ עֲרָפֶל כְּשֶׁהַשֶּׁמֶשׁ מְחַמֶּמֶת אֶת הָאֲדָמָה.",
            definitionNative = "Медленно угасать и распадаться — как туман, когда солнце прогревает землю.",
            example = "הָעֲרָפֶל הִתְחִיל לְהִתְפַּזֵּר לְקַרְאַת עֶשֶׂר בַּבֹּקֶר.",
            exampleNative = "Туман начал לְהִתְפַּזֵּר ближе к десяти утра.",
         fillInBlankExclusions = listOf(181916L, 181917L, 181919L, 181920L)),
        WordEntity(
            id = 181919, setId = 1819, languagePair = "he-ru", rarity = "EPIC",
            pos = "verb", semanticGroup = "weather_l3_processes",
            original = "לִשְׁכֹּךְ", translation = "стихать",
            transliteration = "лишкох",
            definition = "לְהֵיעָשׂוֹת שָׁקֵט יוֹתֵר וְחַלָּשׁ יוֹתֵר אַחֲרֵי הָיָה חָזָק — עַל רוּחַ אוֹ גֶּשֶׁם.",
            definitionNative = "Становиться тише и слабее после того как было сильным — о ветре или дожде.",
            example = "הָרוּחַ הִתְחִילָה לִשְׁכֹּךְ כְּשֶׁהַסּוּפָה זָזָה מִזְרָחָה.",
            exampleNative = "Ветер начал לִשְׁכֹּךְ, когда буря двинулась на восток.",
        ),
        WordEntity(
            id = 181920, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "weather_l3_processes",
            original = "לְהַצִּיף", translation = "затоплять",
            transliteration = "лехациф",
            definition = "לְכַסּוֹת שֶׁטַח בְּמַיִם רַבִּים — כְּשֶׁגֶּשֶׁם חָזָק מַעֲבִיר אֶת גְּדוֹת הַנַּחַל.",
            definitionNative = "Покрывать местность большим количеством воды — когда сильный дождь выходит из берегов.",
            example = "מָטָר כָּבֵד הִצְלִיחַ לְהַצִּיף אֶת כְּבִישׁ הָעִיר תּוֹךְ שָׁעָה.",
            exampleNative = "Сильный ливень сумел לְהַצִּיף городскую дорогу за час.",
         fillInBlankExclusions = listOf(181916L, 181917L, 181918L, 181919L)),

        // ─── weather_l3_severity (5) ─────────────────────────────────────
        WordEntity(
            id = 181921, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l3_severity",
            original = "כָּבֵד", translation = "сильный (о дожде)",
            transliteration = "кавэд",
            definition = "שֶׁיּוֹרֵד בְּכַמּוּת גְּדוֹלָה וְחָזָק — עַל גֶּשֶׁם, מָטָר אוֹ עֲרָפֶל.",
            definitionNative = "Льющий обильно и сильно — о дожде, ливне или тумане.",
            example = "גֶּשֶׁם כָּבֵד יָרַד כָּל הַלַּיְלָה וְלֹא נָתַן לִישׁוֹן.",
            exampleNative = "כָּבֵד дождь шёл всю ночь и не давал уснуть.",
         fillInBlankExclusions = listOf(181911L, 181922L, 181923L, 181924L, 181925L)),
        WordEntity(
            id = 181922, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l3_severity",
            original = "מַחֲנִיק", translation = "удушающий",
            transliteration = "маханик",
            definition = "כָּל כָּךְ חַם וְכָבֵד שֶׁקָּשֶׁה לִנְשֹׁם וּמַזִּיעִים גַּם בִּצֵל.",
            definitionNative = "Настолько жаркий и тяжёлый, что трудно дышать и потеешь даже в тени.",
            example = "אֲוִיר מַחֲנִיק עָמַד מֵעַל הָעִיר וְאַף אֶחָד לֹא יָצָא הַחוּצָה.",
            exampleNative = "מַחֲנִיק воздух стоял над городом, и никто не выходил наружу.",
         fillInBlankExclusions = listOf(181911L, 181913L, 181914L, 181915L, 181921L, 181923L, 181924L, 181925L)),
        WordEntity(
            id = 181923, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l3_severity",
            original = "מְעִיק", translation = "гнетущий",
            transliteration = "меик",
            definition = "כָּבֵד וְלוֹחֵץ בְּצוּרָה לֹא נְעִימָה — עַל מֶזֶג שֶׁמַּעֲצִיב וּמַעֲיֵף.",
            definitionNative = "Тяжёлый и давящий неприятным образом — о погоде, что навевает тоску и усталость.",
            example = "חֹם מְעִיק שָׁכַן בָּעִיר כָּל אַחַר הַצָּהֳרַיִם.",
            exampleNative = "מְעִיק жар лежал на городе весь послеполуденный час.",
         fillInBlankExclusions = listOf(181911L, 181914L, 181915L, 181921L, 181922L, 181924L, 181925L)),
        WordEntity(
            id = 181924, setId = 1819, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l3_severity",
            original = "סַגְרִירִי", translation = "ненастный",
            transliteration = "сагрири",
            definition = "קַר, רָטוֹב וְלֹא נָעִים בַּחוּץ — עִם רוּחַ וְגֶשֶׁם בְּיַחַד.",
            definitionNative = "Холодный, мокрый и неприятный за окном — с ветром и дождём вместе.",
            example = "הַמִּשְׂחָק נִדְחָה בִּגְלַל מֶזֶג אֲוִיר סַגְרִירִי.",
            exampleNative = "Матч перенесли из-за סַגְרִירִי погоды.",
         fillInBlankExclusions = listOf(181921L, 181922L, 181923L, 181925L)),
        WordEntity(
            id = 181925, setId = 1819, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "weather_l3_severity",
            original = "מַבּוּלִי", translation = "проливной",
            transliteration = "мабули",
            definition = "יוֹרֵד בְּכַמּוּת עֲצוּמָה כְּמוֹ מַבּוּל — מַצִּיף רְחוֹבוֹת וְשָׂדוֹת בִּמְהִירוּת.",
            definitionNative = "Льющий в огромных количествах, как потоп — быстро затапливает улицы и поля.",
            example = "גֶּשֶׁם מַבּוּלִי שָׁטַף מְכוֹנִיּוֹת מִכְּבִישׁ הָהָר.",
            exampleNative = "מַבּוּלִי дождь смыл машины с горной дороги.",
         fillInBlankExclusions = listOf(181911L, 181914L, 181915L, 181921L, 181922L, 181923L, 181924L)),
    )
}
