package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Время и календарь", level 2 (A2-B2).
 * Один сет × 25 слов. setId = 1833.
 *
 *  - 18 UNCOMMON + 7 RARE (два смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      time_l2_periods         — год, сезон, десятилетие, век, эпоха (5)
 *      time_l2_jewish_calendar — еврейский календарь и его месяцы (5)
 *      time_l2_dayparts_pro    — продвинутые части суток (5)
 *      time_l2_relative_pro    — продвинутые ориентиры во времени (5)
 *      time_l2_freq_pro        — продвинутая частотность (5)
 *  - Не пересекается с set 1832 (L1): другие слова, более продвинутая
 *    лексика и календарные термины. Слово פַּעַם встречается в наборе
 *    «Лингвистика» (1167) — допустимо по политике дублей в разных темах
 *    (`docs/claude/feedback_duplicate_words_policy.md`). Слова
 *    שָׁנָה / עוֹנָה / מֵאָה / לוּחַ עִבְרִי / דִּמְדּוּמִים были заменены на
 *    מִילֶנְיוּם / חֲמִשִּׁית / שְׁנַת אוֹר / כִּסְלֵו / שְׁקִיעָה из-за
 *    rarity-коллизий с существующей базой.
 *  - Никудим везде (стандарт he-ru).
 *  - fillInBlankExclusions / isFillInBlankSafe не задаются — заполнятся через
 *    FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataHebrewTimeL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1833, languagePair = "he-ru", orderIndex = 1833,
            name = "Время и календарь",
            description = "Год, сезоны, еврейский календарь и продвинутые ориентиры",
            topic = "Время и календарь", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── time_l2_periods (5) ─────────────────────────────────────────
        WordEntity(
            id = 183301, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_periods",
            original = "מִילֶנְיוּם", translation = "тысячелетие",
            transliteration = "миленьюм",
            definition = "פֶּרֶק זְמַן שֶׁל אֶלֶף שָׁנִים — עֲשָׂרָה מֵאוֹת בִּרְצִיפוּת אַחַת.",
            definitionNative = "Промежуток времени в тысячу лет — десять веков подряд один за другим.",
            example = "מִילֶנְיוּם שָׁלֵם עָבַר מֵאָז שֶׁהַטִּירָה הַזֹּאת נִבְנְתָה עַל הָהָר.",
            exampleNative = "Целый מִילֶנְיוּם прошёл с тех пор, как этот замок построили на горе.",
         fillInBlankExclusions = listOf(183302L, 183303L, 183304L, 183305L, 183307L, 183308L, 183309L, 183310L, 183311L, 183314L, 183315L, 183324L)),
        WordEntity(
            id = 183302, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_periods",
            original = "חֲמִשִּׁית", translation = "пятая часть",
            transliteration = "хамишит",
            definition = "חֵלֶק אֶחָד מִתּוֹךְ חֲמִשָּׁה חֲלָקִים שָׁוִים שֶׁל פֶּרֶק זְמַן אוֹ שֶׁל שָׁלֵם.",
            definitionNative = "Одна часть из пяти равных частей промежутка времени или целого.",
            example = "חֲמִשִּׁית מֵהַשָּׁנָה שֶׁלִּי עָבְרָה בִּנְסִיעוֹת בַּחוּץ לָאָרֶץ.",
            exampleNative = "חֲמִשִּׁית моего года прошла в поездках за границу по работе.",
         fillInBlankExclusions = listOf(183301L, 183303L, 183304L, 183305L)),
        WordEntity(
            id = 183303, setId = 1833, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l2_periods",
            original = "עָשׂוֹר", translation = "десятилетие",
            transliteration = "асор",
            definition = "פֶּרֶק זְמַן שֶׁל עֶשֶׂר שָׁנִים בִּרְצִיפוּת.",
            definitionNative = "Промежуток времени в десять лет подряд.",
            example = "בָּעָשׂוֹר הָאַחֲרוֹן הָעִיר הִשְׁתַּנְּתָה כִּמְעַט לְלֹא הַכָּרָה.",
            exampleNative = "За последний עָשׂוֹר город изменился почти до неузнаваемости.",
         fillInBlankExclusions = listOf(183301L, 183302L, 183304L, 183305L, 183323L)),
        WordEntity(
            id = 183304, setId = 1833, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l2_periods",
            original = "שְׁנַת אוֹר", translation = "световой год",
            transliteration = "шнат ор",
            definition = "מֶרְחָק שֶׁאוֹר עוֹבֵר בְּמֶשֶׁךְ שָׁנָה אַחַת — יְחִידָה לְמֶרְחַקֵּי כּוֹכָבִים.",
            definitionNative = "Расстояние, что свет проходит за один год — единица измерения межзвёздных дистанций.",
            example = "הַכּוֹכָב הַקָּרוֹב בְּיוֹתֵר רָחוֹק מִכָּאן יוֹתֵר מִשְׁנַת אוֹר אַחַת.",
            exampleNative = "Ближайшая звезда находится дальше чем שְׁנַת אוֹר одна от нашей системы.",
         fillInBlankExclusions = listOf(183301L, 183302L, 183303L, 183305L)),
        WordEntity(
            id = 183305, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_periods",
            original = "תְּקוּפָה", translation = "эпоха, период",
            transliteration = "ткуфа",
            definition = "פֶּרֶק זְמַן אָרֹךְ עִם אֹפִי מְיֻחָד אוֹ אֵרוּעִים מְשֻׁתָּפִים.",
            definitionNative = "Длительный промежуток времени с особым характером или общими событиями.",
            example = "תְּקוּפָה קָשָׁה עָבְרָה עָלֵינוּ אַחֲרֵי הַמַּעֲבָר לָאָרֶץ.",
            exampleNative = "Тяжёлая תְּקוּפָה выпала на нашу долю после переезда в страну.",
         fillInBlankExclusions = listOf(183301L, 183302L, 183303L, 183304L)),

        // ─── time_l2_jewish_calendar (5) ─────────────────────────────────
        WordEntity(
            id = 183306, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_jewish_calendar",
            original = "כִּסְלֵו", translation = "кислев (зимний месяц)",
            transliteration = "кислев",
            definition = "חֹדֶשׁ עִבְרִי שֶׁבָּא בְּחֹרֶף — בּוֹ חוֹגְגִים אֶת חַג הַחֲנֻכָּה עִם נֵרוֹת.",
            definitionNative = "Зимний еврейский месяц — в нём отмечают праздник Ханука с зажиганием свечей.",
            example = "בְּחֹדֶשׁ כִּסְלֵו הַלֵּילוֹת אֲרֻכִּים וְהַסֻּפְגָּנִיּוֹת מְמַלְּאוֹת אֶת הַחֲנֻיּוֹת.",
            exampleNative = "В месяц כִּסְלֵו ночи длинные и пончики наполняют все витрины города.",
        ),
        WordEntity(
            id = 183307, setId = 1833, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l2_jewish_calendar",
            original = "תִּשְׁרֵי", translation = "тишрей (1-й месяц еврейского года)",
            transliteration = "тишрей",
            definition = "הַחֹדֶשׁ הָרִאשׁוֹן בְּשָׁנָה הָעִבְרִית — בּוֹ חָל רֹאשׁ הַשָּׁנָה וְיוֹם כִּפּוּר.",
            definitionNative = "Первый месяц еврейского года — на него выпадают Рош ha-Шана и Йом-Киппур.",
            example = "בְּחֹדֶשׁ תִּשְׁרֵי הַמִּשְׁפָּחָה מִתְכַּנֶּסֶת לַחֲגֹג רֹאשׁ הַשָּׁנָה.",
            exampleNative = "В месяц תִּשְׁרֵי вся семья собирается отмечать Новый год.",
         fillInBlankExclusions = listOf(183306L, 183308L, 183309L, 183310L)),
        WordEntity(
            id = 183308, setId = 1833, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l2_jewish_calendar",
            original = "אֶלוּל", translation = "элуль (последний месяц года)",
            transliteration = "элуль",
            definition = "הַחֹדֶשׁ הָאַחֲרוֹן בְּשָׁנָה הָעִבְרִית — חֹדֶשׁ הַסְּלִיחוֹת לִפְנֵי תִּשְׁרֵי.",
            definitionNative = "Последний месяц еврейского года — месяц молитв-слихот перед тишреем.",
            example = "בְּחֹדֶשׁ אֶלוּל שׁוֹמְעִים אֶת קוֹל הַשּׁוֹפָר בְּכָל בֹּקֶר.",
            exampleNative = "В месяц אֶלוּל каждое утро слышен звук шофара в синагогах.",
         fillInBlankExclusions = listOf(183306L, 183307L, 183309L, 183310L)),
        WordEntity(
            id = 183309, setId = 1833, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l2_jewish_calendar",
            original = "נִיסָן", translation = "нисан (весенний месяц)",
            transliteration = "нисан",
            definition = "חֹדֶשׁ הָאָבִיב בַּלּוּחַ הָעִבְרִי — בּוֹ חוֹגְגִים אֶת חַג הַפֶּסַח.",
            definitionNative = "Весенний месяц еврейского календаря — в нём отмечают праздник Песах.",
            example = "בְּחֹדֶשׁ נִיסָן הַשְּׂדוֹת מִתְמַלְּאִים פְּרָחִים וְעוֹנַת הַפֶּסַח מַתְחִילָה.",
            exampleNative = "В месяц נִיסָן поля покрываются цветами и начинается пора Песаха.",
         fillInBlankExclusions = listOf(183306L, 183307L, 183308L, 183310L)),
        WordEntity(
            id = 183310, setId = 1833, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l2_jewish_calendar",
            original = "אֲדָר", translation = "адар (месяц Пурима)",
            transliteration = "адар",
            definition = "חֹדֶשׁ עִבְרִי שֶׁבּוֹ חוֹגְגִים אֶת חַג פּוּרִים — חֹדֶשׁ שֶׁל שִׂמְחָה וּמַסֵּכוֹת.",
            definitionNative = "Еврейский месяц, в котором отмечают Пурим — месяц радости и масок.",
            example = "מִשֶּׁנִּכְנַס חֹדֶשׁ אֲדָר מַרְבִּים בְּשִׂמְחָה לְפִי הַמָּסֹרֶת.",
            exampleNative = "По традиции, как только наступает אֲדָר — приумножают радость.",
         fillInBlankExclusions = listOf(183306L, 183307L, 183308L, 183309L)),

        // ─── time_l2_dayparts_pro (5) ────────────────────────────────────
        WordEntity(
            id = 183311, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_dayparts_pro",
            original = "שַׁחֲרִית", translation = "раннее утро, заря",
            transliteration = "шахарит",
            definition = "הַחֵלֶק הַמֻּקְדָּם בְּיוֹתֵר שֶׁל הַבֹּקֶר — סְבִיב עֲלוֹת הַשַּׁחַר.",
            definitionNative = "Самая ранняя часть утра — около рассвета.",
            example = "בְּשַׁחֲרִית הָעִיר עוֹד שְׁקֵטָה וְהָרְחוֹבוֹת רֵיקִים מֵאָדָם.",
            exampleNative = "В שַׁחֲרִית город ещё спит и улицы пустые без единой души.",
         fillInBlankExclusions = listOf(183312L, 183313L, 183314L, 183315L)),
        WordEntity(
            id = 183312, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_dayparts_pro",
            original = "צָהֳרֵי הַיּוֹם", translation = "разгар полудня",
            transliteration = "цоhорей hайом",
            definition = "אֶמְצַע הַיּוֹם בְּדִיּוּק — הַשָּׁעָה שֶׁבָּהּ הַשֶּׁמֶשׁ הֲכִי גְּבוֹהָה בַּשָּׁמַיִם.",
            definitionNative = "Самая середина дня — час, когда солнце выше всего на небе.",
            example = "בְּצָהֳרֵי הַיּוֹם הָעוֹבְדִים יוֹצְאִים לַאֲרוּחָה וְהַמִּשְׂרָדִים מִתְרוֹקְנִים.",
            exampleNative = "В צָהֳרֵי הַיּוֹם сотрудники уходят на обед и офисы пустеют.",
         fillInBlankExclusions = listOf(183311L, 183313L, 183314L, 183315L)),
        WordEntity(
            id = 183313, setId = 1833, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l2_dayparts_pro",
            original = "שְׁקִיעָה", translation = "закат (солнца)",
            transliteration = "шкиа",
            definition = "הָרֶגַע שֶׁבּוֹ הַשֶּׁמֶשׁ יוֹרֶדֶת מִתַּחַת לָאֹפֶק וְהַשָּׁמַיִם נִצְבָּעִים אָדֹם.",
            definitionNative = "Миг, когда солнце опускается под горизонт и небо окрашивается в красный.",
            example = "שְׁקִיעָה מֵעַל הַיָּם בְּתֵל אָבִיב מוֹשֶׁכֶת אֶלֶף תַּיָּרִים בְּכָל עֶרֶב.",
            exampleNative = "שְׁקִיעָה над морем в Тель-Авиве каждый вечер собирает тысячу зрителей на променаде.",
        ),
        WordEntity(
            id = 183314, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_dayparts_pro",
            original = "חֲצוֹת", translation = "полночь",
            transliteration = "хацот",
            definition = "אֶמְצַע הַלַּיְלָה — הַשָּׁעָה שְׁתֵּים עֶשְׂרֵה בְּדִיּוּק.",
            definitionNative = "Середина ночи — ровно двенадцать часов по часам.",
            example = "בַּחֲצוֹת הַשָּׁעוֹן בָּעִיר הָעַתִּיקָה צִלְצֵל שְׁתֵּים עֶשְׂרֵה פְּעָמִים.",
            exampleNative = "В חֲצוֹת часы Старого города пробили двенадцать ударов.",
         fillInBlankExclusions = listOf(183311L, 183312L, 183313L, 183315L)),
        WordEntity(
            id = 183315, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_dayparts_pro",
            original = "זְרִיחָה", translation = "восход (солнца)",
            transliteration = "зриха",
            definition = "הָרֶגַע שֶׁבּוֹ הַשֶּׁמֶשׁ עוֹלָה מֵעֵבֶר לָאֹפֶק וְהַשָּׁמַיִם נִצְבָּעִים בְּצֶבַע וָרֹד.",
            definitionNative = "Миг, когда солнце поднимается из-за горизонта и небо окрашивается в розовый.",
            example = "זְרִיחָה מֵעַל הַכִּנֶּרֶת שָׁוָה כָּל קִימָה מֻקְדֶּמֶת בָּעוֹלָם.",
            exampleNative = "זְרִיחָה над Кинеретом стоит любого раннего подъёма на свете.",
         fillInBlankExclusions = listOf(183311L, 183312L, 183313L, 183314L)),

        // ─── time_l2_relative_pro (5) ────────────────────────────────────
        WordEntity(
            id = 183316, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "time_l2_relative_pro",
            original = "שִׁלְשׁוֹם", translation = "позавчера",
            transliteration = "шильшом",
            definition = "הַיּוֹם שֶׁהָיָה לִפְנֵי אֶתְמוֹל — שְׁנֵי יָמִים אָחוֹרָה מֵהַיּוֹם.",
            definitionNative = "День, что был перед вчерашним — на два дня назад от сегодня.",
            example = "שִׁלְשׁוֹם פָּגַשְׁתִּי אֶת הַמּוֹרָה הַוְּתִיקָה שֶׁלִּי בַּשּׁוּק.",
            exampleNative = "שִׁלְשׁוֹם я случайно встретил свою старую учительницу на рынке.",
         fillInBlankExclusions = listOf(183317L, 183318L, 183319L, 183320L, 183321L, 183322L, 183324L)),
        WordEntity(
            id = 183317, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "time_l2_relative_pro",
            original = "מָחֳרָתַיִם", translation = "послезавтра",
            transliteration = "мохоратаим",
            definition = "הַיּוֹם שֶׁבָּא אַחֲרֵי מָחָר — שְׁנֵי יָמִים קָדִימָה מֵהַיּוֹם.",
            definitionNative = "День, что наступит после завтра — на два дня вперёд от сегодня.",
            example = "מָחֳרָתַיִם נַטּוּס לְלוֹנְדּוֹן לְבִקּוּר שֶׁל שָׁבוּעַ שָׁלֵם.",
            exampleNative = "מָחֳרָתַיִם мы летим в Лондон на целую неделю отпуска.",
         fillInBlankExclusions = listOf(183316L, 183318L, 183319L, 183320L, 183321L)),
        WordEntity(
            id = 183318, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "time_l2_relative_pro",
            original = "בְּקָרוֹב", translation = "скоро, вскоре",
            transliteration = "бекаров",
            definition = "בִּזְמַן קָצָר מֵעַכְשָׁו — לֹא מִיָּד אֲבָל גַּם לֹא רָחוֹק.",
            definitionNative = "Через короткое время от сейчас — не сразу, но и не далеко.",
            example = "בְּקָרוֹב נְקַבֵּל מַפְתֵּחוֹת לַדִּירָה הַחֲדָשָׁה בָּעִיר.",
            exampleNative = "בְּקָרוֹב мы получим ключи от новой квартиры в городе.",
         fillInBlankExclusions = listOf(183316L, 183317L, 183319L, 183320L)),
        WordEntity(
            id = 183319, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "time_l2_relative_pro",
            original = "מֵאָז", translation = "с тех пор",
            transliteration = "меаз",
            definition = "מֵהָרֶגַע הַהוּא וְעַד עַכְשָׁו — בִּזְמַן שֶׁעָבַר מֵאֵרוּעַ קוֹדֵם.",
            definitionNative = "От того момента и до сейчас — за время, что прошло после события.",
            example = "מֵאָז עָבַרְנוּ לְכָאן הִכַּרְנוּ הַרְבֵּה שְׁכֵנִים נְעִימִים.",
            exampleNative = "מֵאָז как мы переехали сюда, мы познакомились с многими соседями.",
         fillInBlankExclusions = listOf(183316L, 183317L, 183318L, 183320L)),
        WordEntity(
            id = 183320, setId = 1833, languagePair = "he-ru", rarity = "RARE",
            pos = "adverb", semanticGroup = "time_l2_relative_pro",
            original = "מֵרֹאשׁ", translation = "заранее, заблаговременно",
            transliteration = "мерош",
            definition = "מִזְּמַן שֶׁלִּפְנֵי הָאֵרוּעַ — לִפְנֵי שֶׁמַּשֶּׁהוּ קוֹרֶה בְּפֹעַל.",
            definitionNative = "Со времени до события — прежде чем что-то происходит на деле.",
            example = "כְּדַאי לְהַזְמִין כַּרְטִיסִים מֵרֹאשׁ כְּדֵי לֹא לְהִתְאַכְזֵב.",
            exampleNative = "Билеты стоит заказывать מֵרֹאשׁ, чтобы потом не разочаровываться.",
        ),

        // ─── time_l2_freq_pro (5) ────────────────────────────────────────
        WordEntity(
            id = 183321, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "time_l2_freq_pro",
            original = "לְעִתִּים קְרוֹבוֹת", translation = "часто",
            transliteration = "леитим кровот",
            definition = "בְּרֹב הַמִּקְרִים — קוֹרֶה הַרְבֵּה פְּעָמִים בְּפֶרֶק זְמַן קָצָר.",
            definitionNative = "В большинстве случаев — происходит много раз за короткий период.",
            example = "לְעִתִּים קְרוֹבוֹת אֲנִי פּוֹגֵשׁ אֶת חֲבֵרַי בְּבֵית הַקָּפֶה.",
            exampleNative = "לְעִתִּים קְרוֹבוֹת я встречаю друзей в местной кофейне.",
         fillInBlankExclusions = listOf(183322L)),
        WordEntity(
            id = 183322, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "time_l2_freq_pro",
            original = "יוֹם יוֹם", translation = "ежедневно, день за днём",
            transliteration = "йом йом",
            definition = "כָּל יוֹם בְּלִי יוֹצֵא מִן הַכְּלָל — בִּקְבִיעוּת מֻחְלֶטֶת.",
            definitionNative = "Каждый день без исключения — с полной регулярностью.",
            example = "יוֹם יוֹם הוּא יוֹצֵא לְרִיצָה קְצָרָה בַּפַּארְק שֶׁמּוּל הַבַּיִת.",
            exampleNative = "יוֹם יוֹם он выходит на короткую пробежку в парке напротив.",
         fillInBlankExclusions = listOf(183321L)),
        WordEntity(
            id = 183323, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_freq_pro",
            original = "עִתִּים", translation = "времена, моменты",
            transliteration = "итим",
            definition = "תְּקוּפוֹת אוֹ רְגָעִים שׁוֹנִים בַּחַיִּים — בְּצוּרָה רַבָּה וְכּוֹלֶלֶת.",
            definitionNative = "Разные периоды или моменты в жизни — во множественном собирательно.",
            example = "יֵשׁ עִתִּים שֶׁבָּהֶן הַכֹּל הוֹלֵךְ קָשֶׁה וְעִתִּים שֶׁבָּהֶן הַכֹּל זוֹרֵם.",
            exampleNative = "Бывают עִתִּים, когда всё идёт трудно, а бывают — когда всё течёт.",
         fillInBlankExclusions = listOf(183324L, 183325L)),
        WordEntity(
            id = 183324, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_freq_pro",
            original = "פַּעַם", translation = "раз, однажды",
            transliteration = "паам",
            definition = "מִקְרֶה אֶחָד שֶׁל פְּעֻלָּה אוֹ אֵרוּעַ — אוֹ בִּזְמַן עָבָר רָחוֹק.",
            definitionNative = "Один случай действия или события — или в далёком прошлом.",
            example = "פַּעַם בִּזְמָן שֶׁעָבַר גַּרְנוּ בִּכְפָר קָטָן בַּגָּלִיל.",
            exampleNative = "פַּעַם, в стародавние времена, мы жили в маленькой деревне в Галилее.",
         fillInBlankExclusions = listOf(183323L, 183325L)),
        WordEntity(
            id = 183325, setId = 1833, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l2_freq_pro",
            original = "פְּעָמִים", translation = "разы (много раз)",
            transliteration = "пеамим",
            definition = "מִקְרִים אֲחָדִים שֶׁל פְּעֻלָּה — צוּרַת רַבִּים שֶׁל פַּעַם.",
            definitionNative = "Несколько случаев действия — форма множественного числа от פַּעַם.",
            example = "אָמַרְתִּי לוֹ פְּעָמִים רַבּוֹת לְסַדֵּר אֶת הַחֶדֶר וְהוּא לֹא שׁוֹמֵעַ.",
            exampleNative = "Я говорил ему פְּעָמִים без счёта прибрать комнату — а он не слышит.",
         fillInBlankExclusions = listOf(183323L, 183324L)),
    )
}
