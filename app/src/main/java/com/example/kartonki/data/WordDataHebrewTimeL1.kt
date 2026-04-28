package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Время и календарь", level 1 (A1-A2).
 * Один сет × 25 слов. setId = 1832.
 *
 *  - 18 COMMON + 7 UNCOMMON (2 смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      time_l1_units      — единицы времени (5)
 *      time_l1_weekdays   — дни недели и выходные (5)
 *      time_l1_dayparts   — части суток (5)
 *      time_l1_relative   — временные ориентиры (5)
 *      time_l1_freq       — частотность и периодичность (5)
 *  - Базовая повседневная лексика про время на иврите.
 *    Никудим везде (стандарт he-ru).
 *  - Несколько фундаментальных оригиналов (יוֹם, שָׁעָה, שַׁבָּת,
 *    יוֹם רִאשׁוֹן/שֵׁנִי/שִׁשִּׁי, בֹּקֶר, עֶרֶב, לַיְלָה, הַיּוֹם,
 *    סוֹף שָׁבוּעַ, שָׁנָה) пересекаются с set 1167 «Лингвистика»,
 *    set 1004 «Приветствия», set 1610-1611 «Алия и Израиль»,
 *    set 1057 «Религия и иудаизм», set 1167 «Лингвистика»,
 *    set 1752 «Собеседования», set 1750 «Школа», set 1740 «Работа» —
 *    формально это другие темы, дубли в разных темах допустимы по
 *    политике (`docs/claude/feedback_duplicate_words_policy.md`).
 *    Без них L1 «Время и календарь» неполноценен — это самые
 *    базовые слова A1-A2, без которых тема пустая.
 */
object WordDataHebrewTimeL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1832, languagePair = "he-ru", orderIndex = 1832,
            name = "Время и календарь",
            description = "Часы, дни недели, части суток и базовые ориентиры",
            topic = "Время и календарь", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── time_l1_units (5) ───────────────────────────────────────────
        WordEntity(
            id = 183201, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_units",
            original = "שָׁעָה", translation = "час",
            transliteration = "шаа",
            definition = "יְחִידַת זְמַן שֶׁמְּכִילָה שִׁשִּׁים דַּקּוֹת בְּדִיּוּק.",
            definitionNative = "Единица времени, что содержит ровно шестьдесят минут.",
            example = "הַפְּגִישָׁה אָרְכָה שָׁעָה אַחַת בְּדִיּוּק.",
            exampleNative = "Встреча длилась ровно одну שָׁעָה без единой минуты сверху.",
         fillInBlankExclusions = listOf(183202L, 183203L, 183204L, 183205L)),
        WordEntity(
            id = 183202, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_units",
            original = "דַּקָּה", translation = "минута",
            transliteration = "дака",
            definition = "יְחִידַת זְמַן קְצָרָה — שִׁשִּׁים שְׁנִיּוֹת בְּסַךְ הַכֹּל.",
            definitionNative = "Короткая единица времени — всего шестьдесят секунд.",
            example = "תֵּן לִי דַּקָּה אַחַת לְסַיֵּם אֶת הַשִּׂיחָה.",
            exampleNative = "Дай мне ещё одну דַּקָּה, чтобы закончить разговор по телефону.",
         fillInBlankExclusions = listOf(183201L, 183203L, 183204L, 183205L)),
        WordEntity(
            id = 183203, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_units",
            original = "יוֹם", translation = "день",
            transliteration = "йом",
            definition = "פֶּרֶק זְמַן שֶׁל עֶשְׂרִים וְאַרְבַּע שָׁעוֹת מִבֹּקֶר עַד בֹּקֶר.",
            definitionNative = "Промежуток времени в двадцать четыре часа от утра до утра.",
            example = "כָּל יוֹם אֲנִי קָם בְּשֶׁבַע וְשׁוֹתֶה קָפֶה.",
            exampleNative = "Каждый יוֹם я встаю в семь и выпиваю чашку кофе.",
         fillInBlankExclusions = listOf(183201L, 183202L, 183204L, 183205L, 183206L, 183207L, 183208L, 183209L, 183210L, 183211L)),
        WordEntity(
            id = 183204, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_units",
            original = "שָׁבוּעַ", translation = "неделя",
            transliteration = "шавуа",
            definition = "פֶּרֶק זְמַן שֶׁל שִׁבְעָה יָמִים בִּרְצִיפוּת אֶחָד אַחֲרֵי הַשֵּׁנִי.",
            definitionNative = "Промежуток времени в семь дней подряд один за другим.",
            example = "הַפְּרוֹיֶקְט יִקַּח עוֹד שָׁבוּעַ שָׁלֵם לְהַשְׁלִים.",
            exampleNative = "Проект займёт ещё целую שָׁבוּעַ до полного завершения работы.",
        ),
        WordEntity(
            id = 183205, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_units",
            original = "חֹדֶשׁ", translation = "месяц",
            transliteration = "ходэш",
            definition = "פֶּרֶק זְמַן שֶׁל כִּשְׁלוֹשִׁים יָמִים — חֵלֶק מִשָּׁנָה.",
            definitionNative = "Промежуток времени около тридцати дней — часть года.",
            example = "אֲנַחְנוּ גָּרִים פֹּה כְּבָר חֹדֶשׁ אֶחָד וָחֵצִי.",
            exampleNative = "Мы живём здесь уже целый חֹדֶשׁ с половиной без перерыва.",
        ),

        // ─── time_l1_weekdays (5) ────────────────────────────────────────
        WordEntity(
            id = 183206, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_weekdays",
            original = "יוֹם רִאשׁוֹן", translation = "воскресенье",
            transliteration = "йом ришон",
            definition = "הַיּוֹם הָרִאשׁוֹן בִּשְׁבוּעַ הָעִבְרִי — תְּחִילַת שָׁבוּעַ הָעֲבוֹדָה בְּיִשְׂרָאֵל.",
            definitionNative = "Первый день еврейской недели — начало рабочей недели в Израиле.",
            example = "בְּיוֹם רִאשׁוֹן אֲנִי חוֹזֵר לָעֲבוֹדָה אַחֲרֵי הַסּוֹף שָׁבוּעַ.",
            exampleNative = "В יוֹם רִאשׁוֹן я возвращаюсь на работу после выходных дней.",
         fillInBlankExclusions = listOf(183207L, 183208L, 183209L, 183210L)),
        WordEntity(
            id = 183207, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_weekdays",
            original = "יוֹם שֵׁנִי", translation = "понедельник",
            transliteration = "йом шени",
            definition = "הַיּוֹם הַשֵּׁנִי בִּשְׁבוּעַ — בָּא אַחֲרֵי יוֹם רִאשׁוֹן.",
            definitionNative = "Второй день недели — идёт сразу после воскресенья.",
            example = "בְּיוֹם שֵׁנִי יֵשׁ לִי שִׁעוּר עִבְרִית בָּעֶרֶב.",
            exampleNative = "В יוֹם שֵׁנִי у меня вечером урок иврита в ульпане.",
         fillInBlankExclusions = listOf(183206L, 183208L, 183209L, 183210L)),
        WordEntity(
            id = 183208, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_weekdays",
            original = "יוֹם שִׁשִּׁי", translation = "пятница",
            transliteration = "йом шиши",
            definition = "הַיּוֹם הַשִּׁשִּׁי בַּשָּׁבוּעַ — יוֹם קָצָר לִפְנֵי שַׁבָּת.",
            definitionNative = "Шестой день недели — короткий день перед субботой.",
            example = "בְּיוֹם שִׁשִּׁי כֻּלָּם קוֹנִים אֹכֶל לְשַׁבָּת בַּשּׁוּק.",
            exampleNative = "В יוֹם שִׁשִּׁי все покупают еду к шабату на рынке.",
         fillInBlankExclusions = listOf(183206L, 183207L, 183210L)),
        WordEntity(
            id = 183209, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_weekdays",
            original = "שַׁבָּת", translation = "суббота",
            transliteration = "шабат",
            definition = "הַיּוֹם הַשְּׁבִיעִי בַּשָּׁבוּעַ — יוֹם מְנוּחָה בְּיִשְׂרָאֵל.",
            definitionNative = "Седьмой день недели — день отдыха в Израиле.",
            example = "בְּשַׁבָּת הַחֲנֻיּוֹת סְגוּרוֹת וְהָאוֹטוֹבּוּסִים לֹא נוֹסְעִים.",
            exampleNative = "В שַׁבָּת магазины закрыты и автобусы не ходят по городу.",
         fillInBlankExclusions = listOf(183206L, 183207L, 183208L, 183210L)),
        WordEntity(
            id = 183210, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_weekdays",
            original = "סוֹף שָׁבוּעַ", translation = "выходные",
            transliteration = "соф шавуа",
            definition = "יוֹם שִׁשִּׁי וְשַׁבָּת יַחַד — שְׁנֵי יָמִים שֶׁל מְנוּחָה מֵעֲבוֹדָה.",
            definitionNative = "Пятница и суббота вместе — два дня отдыха от работы.",
            example = "כָּל סוֹף שָׁבוּעַ אֲנַחְנוּ נוֹסְעִים לְהוֹרִים בָּעִיר.",
            exampleNative = "Каждые סוֹף שָׁבוּעַ мы ездим к родителям в соседний город.",
        ),

        // ─── time_l1_dayparts (5) ────────────────────────────────────────
        WordEntity(
            id = 183211, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_dayparts",
            original = "בֹּקֶר", translation = "утро",
            transliteration = "бокер",
            definition = "הַחֵלֶק הָרִאשׁוֹן שֶׁל הַיּוֹם — מֵעֲלוֹת הַשַּׁחַר עַד צָהֳרַיִם.",
            definitionNative = "Первая часть дня — от рассвета до полудня.",
            example = "בְּכָל בֹּקֶר אֲנִי שׁוֹתֶה תֵּה חַם עִם דְּבַשׁ.",
            exampleNative = "Каждое בֹּקֶר я пью горячий чай с натуральным мёдом из банки.",
         fillInBlankExclusions = listOf(183203L, 183204L, 183205L, 183206L, 183207L, 183208L, 183209L, 183210L, 183212L, 183213L, 183214L, 183215L)),
        WordEntity(
            id = 183212, setId = 1832, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l1_dayparts",
            original = "צָהֳרַיִם", translation = "полдень",
            transliteration = "цоhораим",
            definition = "אֶמְצַע הַיּוֹם — בְּעֵרֶךְ סְבִיב הַשָּׁעָה שְׁתֵּים עֶשְׂרֵה.",
            definitionNative = "Середина дня — примерно около двенадцати часов.",
            example = "בַּצָּהֳרַיִם הַשֶּׁמֶשׁ הֲכִי חֲזָקָה וְחַם בַּחוּץ.",
            exampleNative = "В צָהֳרַיִם солнце сильнее всего и на улице очень жарко.",
        ),
        WordEntity(
            id = 183213, setId = 1832, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "time_l1_dayparts",
            original = "אַחַר הַצָּהֳרַיִם", translation = "после полудня",
            transliteration = "ахар hацоhораим",
            definition = "הַחֵלֶק שֶׁל הַיּוֹם בֵּין צָהֳרַיִם וּבֵין עֶרֶב.",
            definitionNative = "Часть дня между полуднем и вечером.",
            example = "אַחַר הַצָּהֳרַיִם הַיְלָדִים חוֹזְרִים מִבֵּית הַסֵּפֶר הַבַּיְתָה.",
            exampleNative = "אַחַר הַצָּהֳרַיִם дети возвращаются из школы домой пешком.",
         fillInBlankExclusions = listOf(183211L, 183212L, 183214L, 183215L, 183217L, 183218L, 183219L, 183220L)),
        WordEntity(
            id = 183214, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_dayparts",
            original = "עֶרֶב", translation = "вечер",
            transliteration = "эрев",
            definition = "הַחֵלֶק שֶׁל הַיּוֹם אַחֲרֵי שְׁקִיעַת הַשֶּׁמֶשׁ וְלִפְנֵי הַלַּיְלָה.",
            definitionNative = "Часть дня после захода солнца и перед ночью.",
            example = "בָּעֶרֶב כָּל הַמִּשְׁפָּחָה יוֹשֶׁבֶת לֶאֱכֹל אֲרוּחָה חַמָּה.",
            exampleNative = "В עֶרֶב вся семья садится за стол есть горячий ужин.",
         fillInBlankExclusions = listOf(183211L, 183212L, 183213L, 183215L)),
        WordEntity(
            id = 183215, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "time_l1_dayparts",
            original = "לַיְלָה", translation = "ночь",
            transliteration = "лайла",
            definition = "הַחֵלֶק הַחָשׁוּךְ שֶׁל הַיּוֹם — זְמַן שֶׁבּוֹ אֲנָשִׁים יְשֵׁנִים.",
            definitionNative = "Тёмная часть суток — время, когда люди обычно спят.",
            example = "בַּלַּיְלָה הָרְחוֹב שָׁקֵט וְהַכּוֹכָבִים נִרְאִים בַּשָּׁמַיִם.",
            exampleNative = "В לַיְלָה улица тихая и звёзды хорошо видны на небе.",
        ),

        // ─── time_l1_relative (5) ────────────────────────────────────────
        WordEntity(
            id = 183216, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "adverb", semanticGroup = "time_l1_relative",
            original = "אֶתְמוֹל", translation = "вчера",
            transliteration = "этмоль",
            definition = "הַיּוֹם שֶׁהָיָה לִפְנֵי הַיּוֹם — יוֹם אֶחָד אָחוֹרָה.",
            definitionNative = "День, что был перед сегодняшним — на один день назад.",
            example = "אֶתְמוֹל הָיִיתִי בַּשּׁוּק וּקְנִיתִי יְרָקוֹת טְרִיִּים.",
            exampleNative = "אֶתְמוֹל я был на рынке и купил свежих овощей к ужину.",
         fillInBlankExclusions = listOf(183217L, 183218L, 183219L, 183220L)),
        WordEntity(
            id = 183217, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "adverb", semanticGroup = "time_l1_relative",
            original = "הַיּוֹם", translation = "сегодня",
            transliteration = "hайом",
            definition = "הַיּוֹם הַזֶּה — הַיּוֹם שֶׁאֲנַחְנוּ נִמְצָאִים בּוֹ עַכְשָׁו.",
            definitionNative = "Этот день — день, в котором мы находимся прямо сейчас.",
            example = "הַיּוֹם יֵשׁ לִי הַרְבֵּה עֲבוֹדָה בַּמִּשְׂרָד.",
            exampleNative = "הַיּוֹם у меня очень много работы в офисе с самого утра.",
         fillInBlankExclusions = listOf(183216L, 183218L, 183219L, 183220L)),
        WordEntity(
            id = 183218, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "adverb", semanticGroup = "time_l1_relative",
            original = "מָחָר", translation = "завтра",
            transliteration = "махар",
            definition = "הַיּוֹם שֶׁבָּא אַחֲרֵי הַיּוֹם — יוֹם אֶחָד קָדִימָה.",
            definitionNative = "День, что наступит после сегодняшнего — на один день вперёд.",
            example = "מָחָר אֲנַחְנוּ נוֹסְעִים לַיָּם עִם הַיְלָדִים.",
            exampleNative = "מָחָר мы едем на море вместе с детьми на целый день.",
         fillInBlankExclusions = listOf(183216L, 183217L, 183219L, 183220L)),
        WordEntity(
            id = 183219, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "adverb", semanticGroup = "time_l1_relative",
            original = "עַכְשָׁו", translation = "сейчас",
            transliteration = "ахшав",
            definition = "בָּרֶגַע הַזֶּה — בִּזְמַן שֶׁאֲנַחְנוּ מְדַבְּרִים אוֹ פּוֹעֲלִים.",
            definitionNative = "В этот миг — во время, когда мы говорим или действуем.",
            example = "עַכְשָׁו אֲנִי לֹא יָכוֹל לְדַבֵּר, אֲנִי בַּעֲבוֹדָה.",
            exampleNative = "עַכְשָׁו я не могу разговаривать, я нахожусь на работе.",
         fillInBlankExclusions = listOf(183216L, 183217L, 183218L, 183220L)),
        WordEntity(
            id = 183220, setId = 1832, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "time_l1_relative",
            original = "אַחַר כָּךְ", translation = "потом",
            transliteration = "ахар ках",
            definition = "אַחֲרֵי זֶה — בִּזְמַן מְאֻחָר יוֹתֵר, אֲבָל לֹא מִיָּד.",
            definitionNative = "После этого — в более позднее время, но не сразу.",
            example = "קוֹדֶם נֹאכַל אֲרוּחַת עֶרֶב, וְאַחַר כָּךְ נֵצֵא לְטַיֵּל.",
            exampleNative = "Сначала поужинаем, а אַחַר כָּךְ выйдем погулять по парку.",
        ),

        // ─── time_l1_freq (5) ────────────────────────────────────────────
        WordEntity(
            id = 183221, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "adverb", semanticGroup = "time_l1_freq",
            original = "תָּמִיד", translation = "всегда",
            transliteration = "тамид",
            definition = "בְּכָל פַּעַם וּבְכָל זְמַן — בְּלִי יוֹצֵא מִן הַכְּלָל.",
            definitionNative = "Каждый раз и в любое время — без единого исключения.",
            example = "אִמָּא שֶׁלִּי תָּמִיד מְכִינָה אֲרוּחַת בֹּקֶר חַמָּה.",
            exampleNative = "Моя мама תָּמִיד готовит горячий завтрак для всей семьи.",
         fillInBlankExclusions = listOf(183222L, 183223L, 183224L, 183225L)),
        WordEntity(
            id = 183222, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "adverb", semanticGroup = "time_l1_freq",
            original = "לִפְעָמִים", translation = "иногда",
            transliteration = "лифъамим",
            definition = "מִדֵּי פַּעַם — לֹא תָּמִיד וְלֹא לְעִתִּים קְרוֹבוֹת.",
            definitionNative = "Время от времени — не всегда и не очень часто.",
            example = "לִפְעָמִים אֲנִי הוֹלֵךְ לַחוֹף בִּזְמַן הַסּוֹף שָׁבוּעַ.",
            exampleNative = "לִפְעָמִים я хожу на пляж по выходным с приятелями.",
         fillInBlankExclusions = listOf(183221L, 183223L, 183224L, 183225L)),
        WordEntity(
            id = 183223, setId = 1832, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "time_l1_freq",
            original = "לְעִתִּים נְדִירוֹת", translation = "редко",
            transliteration = "леитим недирот",
            definition = "כִּמְעַט אַף פַּעַם לֹא — רַק בִּמְקֵרִים מְעַטִּים מְאוֹד.",
            definitionNative = "Почти никогда — лишь в очень немногих случаях.",
            example = "לְעִתִּים נְדִירוֹת יוֹרֵד שֶׁלֶג בְּאֵזוֹר הַמֶּרְכָּז.",
            exampleNative = "לְעִתִּים נְדִירוֹת выпадает снег в центральном районе страны.",
         fillInBlankExclusions = listOf(183221L, 183222L, 183224L, 183225L)),
        WordEntity(
            id = 183224, setId = 1832, languagePair = "he-ru", rarity = "COMMON",
            pos = "adverb", semanticGroup = "time_l1_freq",
            original = "אַף פַּעַם", translation = "никогда",
            transliteration = "аф паам",
            definition = "בְּאַף פַּעַם וּבְאַף זְמַן — אַף לֹא בִּמְקֶרֶה אֶחָד.",
            definitionNative = "Ни в один момент и ни в одно время — даже в одном случае.",
            example = "אֲנִי אַף פַּעַם לֹא הָיִיתִי בִּירוּשָׁלַיִם הָעַתִּיקָה.",
            exampleNative = "Я אַף פַּעַם не был в старой части Иерусалима с экскурсией.",
         fillInBlankExclusions = listOf(183221L, 183222L, 183223L, 183225L)),
        WordEntity(
            id = 183225, setId = 1832, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "time_l1_freq",
            original = "בְּדֶרֶךְ כְּלָל", translation = "обычно",
            transliteration = "бедерех клаль",
            definition = "בְּרֹב הַמִּקְרִים — כָּךְ קוֹרֶה בְּדֶרֶךְ קְבוּעָה וְרְגִילָה.",
            definitionNative = "В большинстве случаев — так бывает обычно и привычно.",
            example = "בְּדֶרֶךְ כְּלָל אֲנִי הוֹלֵךְ לִישׁוֹן בְּסָבִיב אַחַת עֶשְׂרֵה.",
            exampleNative = "בְּדֶרֶךְ כְּלָל я ложусь спать примерно в одиннадцать вечера.",
         fillInBlankExclusions = listOf(183221L, 183222L, 183223L, 183224L)),
    )
}
