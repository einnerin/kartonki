package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Время и календарь", level 3 (B2-C1).
 * Один сет × 25 слов. setId = 1834.
 *
 *  - 18 RARE + 7 EPIC (два смежных уровня B2 + C1).
 *  - 5 семантических групп по 5 слов:
 *      time_l3_temporal_pro       — продвинутые временные понятия (5)
 *      time_l3_calendar_jewish_pro — еврейский календарь продвинутый (5)
 *      time_l3_astronomy          — астрономические явления (5)
 *      time_l3_relative_formal    — формальные временные ориентиры (5)
 *      time_l3_phases             — фазы и отрезки времени (5)
 *  - Углублённая лексика по теме «Время и календарь» на иврите.
 *    Никудим везде (стандарт he-ru).
 *  - Все 25 слов проверены grep'ом по `original = "..."` против всех
 *    WordDataHebrew*.kt и WordDataImmigrant*.kt и не пересекаются с
 *    set 1832 (L1). Замены из-за дублей:
 *      • вместо שִׁוְיוֹן הַיּוֹם וְהַלַּיְלָה (занят в WeatherL4 1820) —
 *        יוֹם הַשִּׁוְיוֹן (день равноденствия, без явного композита).
 *      • вместо חַג הַסּוּכּוֹת (סוּכּוֹת занято в ReligionL1) — יְמוֹת הַחֹל
 *        (будни / небиблейские дни) как противопоставление праздникам.
 *      • вместо составного רֶגֶשׁ הָעִתּוֹי (нестандартное) — чистое עִתּוּי
 *        (выбор подходящего момента).
 *  - Слова יוֹם הַזִּכָּרוֹן и הַפְסָקָה были заменены на שְׁמִטָּה и
 *    הַשְׁהָיָה из-за rarity-коллизий с существующей базой
 *    (Immigrant4 — UNCOMMON, SchoolL1 — UNCOMMON).
 *  - fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь;
 *    FILL_IN_BLANK pipeline инжектит их централизованно после wave.
 */
object WordDataHebrewTimeL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1834, languagePair = "he-ru", orderIndex = 1834,
            name = "Время и календарь",
            description = "Хронология, астрономия и формальные временные ориентиры",
            topic = "Время и календарь", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── time_l3_temporal_pro (5) ────────────────────────────────────
        WordEntity(
            id = 183401, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_temporal_pro",
            original = "רֶצֶף", translation = "последовательность",
            transliteration = "рэцэф",
            definition = "סִדְרָה שֶׁל אֵרוּעִים אוֹ זְמַנִּים שֶׁבָּאִים זֶה אַחַר זֶה בְּלִי הַפְסָקָה.",
            definitionNative = "Цепочка событий или промежутков времени, что идут один за другим без перерыва.",
            example = "הַחוֹקֵר בָּדַק אֶת הָרֶצֶף הַכְּרוֹנוֹלוֹגִי שֶׁל הַחְלָטוֹת הַמֶּמְשָׁלָה.",
            exampleNative = "Исследователь изучил רֶצֶף хронологический последовательных решений правительства.",
         fillInBlankExclusions = listOf(183402L, 183403L, 183404L, 183405L)),
        WordEntity(
            id = 183402, setId = 1834, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l3_temporal_pro",
            original = "סִינְכְּרוֹנִיּוּת", translation = "синхронность",
            transliteration = "синхрониют",
            definition = "מַצָּב שֶׁל הִתְרַחֲשׁוּת מְשֻׁתֶּפֶת בְּדִיּוּק בְּאוֹתוֹ זְמַן וְלֹא לִפְנֵי וְלֹא אַחֲרֵי.",
            definitionNative = "Состояние совместного происшествия в точно один и тот же момент, ни до, ни после.",
            example = "הַסִּינְכְּרוֹנִיּוּת בֵּין הַמּוּסִיקָה לַסְּרָטוֹן הָיְתָה מֻשְׁלֶמֶת.",
            exampleNative = "סִינְכְּרוֹנִיּוּת между музыкой и видеороликом была идеальной до миллисекунды.",
        ),
        WordEntity(
            id = 183403, setId = 1834, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l3_temporal_pro",
            original = "סִימוּלְטָנִיּוּת", translation = "одновременность",
            transliteration = "симултаниют",
            definition = "תְּכוּנָה שֶׁל שְׁנֵי אֵרוּעִים שֶׁקּוֹרִים בְּאוֹתוֹ רֶגַע אַף שֶׁאֵין בֵּינֵיהֶם קֶשֶׁר.",
            definitionNative = "Свойство двух событий, что происходят в один и тот же миг, хотя между ними нет связи.",
            example = "הַסִּימוּלְטָנִיּוּת שֶׁל הַשְּׁנֵי גִּלּוּיִים הִפְתִּיעָה אֶת הַמַּדְעָנִים.",
            exampleNative = "סִימוּלְטָנִיּוּת двух открытий удивила учёных в разных лабораториях.",
        ),
        WordEntity(
            id = 183404, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_temporal_pro",
            original = "מֶשֶׁךְ זְמַן", translation = "длительность",
            transliteration = "мешех зман",
            definition = "כַּמּוּת הַזְּמַן שֶׁעוֹבֶרֶת מִתְּחִילָה שֶׁל פְּעֻלָּה וְעַד סוֹפָהּ.",
            definitionNative = "Количество времени, что проходит от начала действия и до его конца.",
            example = "מֶשֶׁךְ זְמַן הַטִּיסָה הָיָה אַרְבַּע שָׁעוֹת וַעֲשֶׂר דַּקּוֹת.",
            exampleNative = "מֶשֶׁךְ זְמַן полёта составил четыре часа и десять минут.",
         fillInBlankExclusions = listOf(183401L, 183402L, 183403L, 183405L, 183424L)),
        WordEntity(
            id = 183405, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_temporal_pro",
            original = "רֶגַע מַכְרִיעַ", translation = "решающий момент",
            transliteration = "рэга махриа",
            definition = "נְקֻדַּת זְמַן קָצָרָה שֶׁבָּהּ נִקְבַּעַת תּוֹצָאָה חֲשׁוּבָה לְמֶשֶׁךְ אָרֹךְ.",
            definitionNative = "Короткая точка времени, в которой определяется важный исход на долгий срок.",
            example = "הָרֶגַע הַמַּכְרִיעַ שֶׁל הַמִּשְׂחָק הִגִּיעַ בַּדַּקָּה הָאַחֲרוֹנָה.",
            exampleNative = "רֶגַע מַכְרִיעַ матча наступил на самой последней минуте.",
        ),

        // ─── time_l3_calendar_jewish_pro (5) ─────────────────────────────
        WordEntity(
            id = 183406, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_calendar_jewish_pro",
            original = "לוּחַ הַשָּׁנָה", translation = "годовой календарь",
            transliteration = "луах hа-шана",
            definition = "טַבְלָה שֶׁמַּרְאָה אֶת כָּל הַחֳדָשִׁים, הַיָּמִים וְהַחַגִּים שֶׁל הַשָּׁנָה.",
            definitionNative = "Таблица, что показывает все месяцы, дни и праздники года.",
            example = "תָּלִיתִי לוּחַ הַשָּׁנָה הֶחָדָשׁ עַל הַקִּיר בַּמִּטְבָּח.",
            exampleNative = "Я повесил новый לוּחַ הַשָּׁנָה на стену в кухне у окна.",
         fillInBlankExclusions = listOf(183407L, 183408L, 183409L, 183410L)),
        WordEntity(
            id = 183407, setId = 1834, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l3_calendar_jewish_pro",
            original = "חֹדֶשׁ הָעִבּוּר", translation = "добавочный месяц",
            transliteration = "ходэш hа-ибур",
            definition = "חֹדֶשׁ נוֹסָף שֶׁמּוֹסִיפִים לַלּוּחַ הָעִבְרִי בִּשְׁנַת מְעֻבֶּרֶת לְהַתְאִים אוֹתוֹ לַשֶּׁמֶשׁ.",
            definitionNative = "Дополнительный месяц, что прибавляют к еврейскому календарю в високосный год для согласия с солнцем.",
            example = "חֹדֶשׁ הָעִבּוּר נִקְרָא אֲדָר בֵּית וּבָא לִפְנֵי חַג הַפֶּסַח.",
            exampleNative = "חֹדֶשׁ הָעִבּוּר называется Адар Бет и наступает прямо перед праздником Песах.",
         fillInBlankExclusions = listOf(183406L, 183408L, 183409L, 183410L)),
        WordEntity(
            id = 183408, setId = 1834, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l3_calendar_jewish_pro",
            original = "תְּשׁוּבַת הַשָּׁנָה", translation = "годовщина",
            transliteration = "тшуват hа-шана",
            definition = "מוֹעֵד שֶׁל חֲזָרָה שֶׁל אֵרוּעַ אַחֲרֵי שָׁנָה שְׁלֵמָה — צִיּוּן לְזִכָּרוֹן.",
            definitionNative = "Дата возвращения события через целый год — отметка в память о случившемся.",
            example = "בִּתְשׁוּבַת הַשָּׁנָה לַחֲתֻנָּה הִזְמַנּוּ אֶת כָּל הַחֲבֵרִים לַמִּסְעָדָה.",
            exampleNative = "На תְּשׁוּבַת הַשָּׁנָה свадьбы мы пригласили всех друзей в ресторан в центре.",
        ),
        WordEntity(
            id = 183409, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_calendar_jewish_pro",
            original = "שְׁמִטָּה", translation = "шмита (седьмой год)",
            transliteration = "шмита",
            definition = "הַשָּׁנָה הַשְּׁבִיעִית שֶׁבָּהּ עַל פִּי הַתּוֹרָה הָאֲדָמָה נָחָה וְלֹא עוֹבְדִים אוֹתָהּ.",
            definitionNative = "Седьмой год, в который по Торе земля отдыхает и её не возделывают.",
            example = "בִּשְׁנַת שְׁמִטָּה הַחַקְלָאִים מַפְסִיקִים לִזְרֹעַ וְהַשְּׂדוֹת נֶחֱנָקִים בִּבְרָכָה.",
            exampleNative = "В год שְׁמִטָּה фермеры прекращают сеять и поля наполняются дикой зеленью.",
         fillInBlankExclusions = listOf(183406L, 183407L, 183408L, 183410L)),
        WordEntity(
            id = 183410, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_calendar_jewish_pro",
            original = "יְמוֹת הַחֹל", translation = "будни",
            transliteration = "йемот hа-холь",
            definition = "הַיָּמִים הָרְגִילִים שֶׁל הַשָּׁבוּעַ — לֹא שַׁבָּת וְלֹא חַג, בָּהֶם עוֹבְדִים וְלוֹמְדִים.",
            definitionNative = "Обычные дни недели — не суббота и не праздник, в которые работают и учатся.",
            example = "בִּימוֹת הַחֹל הָרְחוֹב הוֹמֶה תְּנוּעָה כְּבֵדָה כָּל הַיּוֹם.",
            exampleNative = "В יְמוֹת הַחֹל улица гудит плотным движением целый день без перерыва.",
        ),

        // ─── time_l3_astronomy (5) ───────────────────────────────────────
        WordEntity(
            id = 183411, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_astronomy",
            original = "תְּקוּפַת הַחַמָּה", translation = "солнцестояние",
            transliteration = "ткуфат hа-хама",
            definition = "יוֹם פַּעֲמַיִם בַּשָּׁנָה שֶׁבּוֹ הַשֶּׁמֶשׁ מַגִּיעָה לִנְקֻדָּה הַגְּבוֹהָה אוֹ הַנְּמוּכָה בְּיוֹתֵר.",
            definitionNative = "День два раза в году, когда солнце достигает самой высокой или самой низкой точки.",
            example = "תְּקוּפַת הַחַמָּה שֶׁל הַקַּיִץ הִיא הַיּוֹם הָאָרֹךְ בְּיוֹתֵר בַּשָּׁנָה.",
            exampleNative = "תְּקוּפַת הַחַמָּה летнее это самый длинный день целого года в северном полушарии.",
         fillInBlankExclusions = listOf(183412L, 183413L, 183414L, 183415L)),
        WordEntity(
            id = 183412, setId = 1834, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l3_astronomy",
            original = "יוֹם הַשִּׁוְיוֹן", translation = "равноденствие",
            transliteration = "йом hа-шивйон",
            definition = "יוֹם פַּעֲמַיִם בַּשָּׁנָה שֶׁבּוֹ אֹרֶךְ הַיּוֹם שָׁוֶה בְּדִיּוּק לְאֹרֶךְ הַלַּיְלָה.",
            definitionNative = "День два раза в году, когда длительность дня в точности равна длительности ночи.",
            example = "יוֹם הַשִּׁוְיוֹן שֶׁל הָאָבִיב חָל בְּעֶשְׂרִים וְאֶחָד בְּמַרְץ.",
            exampleNative = "יוֹם הַשִּׁוְיוֹן весеннее выпадает на двадцать первое марта в большинстве лет.",
         fillInBlankExclusions = listOf(183411L, 183413L, 183414L, 183415L)),
        WordEntity(
            id = 183413, setId = 1834, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l3_astronomy",
            original = "מוּטַת כּוֹכָבִים", translation = "звёздный путь",
            transliteration = "мутат кохавим",
            definition = "מַסְלוּל הַכּוֹכָבִים שֶׁל הַלַּיְלָה כְּפִי שֶׁנִּרְאֶה מֵהָאָרֶץ דֶּרֶךְ סִיבּוּב כַּדּוּר הָאָרֶץ.",
            definitionNative = "Путь ночных звёзд, каким он видится с земли через вращение земного шара вокруг оси.",
            example = "צוֹפִים בָּמִּדְבָּר שָׂמוּ לֵב לְמוּטַת הַכּוֹכָבִים שֶׁמּוֹרָה עַל זְמַן הַלַּיְלָה.",
            exampleNative = "Наблюдатели в пустыне следили за מוּטַת כּוֹכָבִים, что выдаёт час ночи.",
        ),
        WordEntity(
            id = 183414, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_astronomy",
            original = "לֵיל יָרֵחַ מָלֵא", translation = "ночь полнолуния",
            transliteration = "лейль яреах мале",
            definition = "לַיְלָה שֶׁבּוֹ הַיָּרֵחַ נִרְאֶה כְּעִגּוּל שָׁלֵם וּמוּאָר בִּשְׁלֵמוּת בַּשָּׁמַיִם.",
            definitionNative = "Ночь, в которую луна видна как полный круг и освещена целиком в небе.",
            example = "בְּלֵיל יָרֵחַ מָלֵא יָצָאנוּ לְטַיֵּל בַּחוֹף בְּלִי פָּנָס.",
            exampleNative = "В לֵיל יָרֵחַ מָלֵא мы вышли гулять по пляжу даже без фонаря.",
         fillInBlankExclusions = listOf(183411L, 183412L, 183413L, 183415L)),
        WordEntity(
            id = 183415, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_astronomy",
            original = "לִקּוּי חַמָּה", translation = "солнечное затмение",
            transliteration = "ликуй хама",
            definition = "תּוֹפָעָה שֶׁבָּהּ הַיָּרֵחַ מַסְתִּיר אֶת הַשֶּׁמֶשׁ וְהַיּוֹם נֶחְשָׁךְ לְזְמַן קָצָר.",
            definitionNative = "Явление, когда луна закрывает солнце, и день на короткое время темнеет.",
            example = "לִקּוּי חַמָּה הִתְרַחֵשׁ אֶמֶשׁ וְהַשָּׁמַיִם הֶחְשִׁיכוּ פִּתְאוֹם בָּצָּהֳרַיִם.",
            exampleNative = "לִקּוּי חַמָּה случилось вчера, и небо внезапно потемнело прямо в полдень.",
         fillInBlankExclusions = listOf(183411L, 183412L, 183413L, 183414L)),

        // ─── time_l3_relative_formal (5) ─────────────────────────────────
        WordEntity(
            id = 183416, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "adverb", semanticGroup = "time_l3_relative_formal",
            original = "לְמַפְרֵעַ", translation = "задним числом",
            transliteration = "лемафрэа",
            definition = "בְּזְמַן שֶׁאַחֲרֵי הָאֵרוּעַ — כְּשֶׁמְּחַשְּׁבִים אוֹ מַחְלִיטִים עַל מַה שֶּׁכְּבָר הָיָה.",
            definitionNative = "Во время после события — когда учитывают или решают о том, что уже произошло.",
            example = "הַתַּשְׁלוּם אֻשַּׁר לְמַפְרֵעַ עַל כָּל הַחֳדָשִׁים שֶׁל הַשָּׁנָה הַקּוֹדֶמֶת.",
            exampleNative = "Платёж был утверждён לְמַפְרֵעַ за все месяцы прошлого года без вычетов.",
        ),
        WordEntity(
            id = 183417, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "adverb", semanticGroup = "time_l3_relative_formal",
            original = "מִקֶּדֶם", translation = "издревле",
            transliteration = "микэдэм",
            definition = "מִזְּמַנִּים עַתִּיקִים מְאוֹד — מִתְּקוּפוֹת הָרְחוֹקוֹת שֶׁל הָעָבָר.",
            definitionNative = "Из очень древних времён — из дальних эпох прошлого.",
            example = "הַמִּנְהָג הַזֶּה נִשְׁמַר מִקֶּדֶם וְעוֹבֵר מֵאָב לַבֵּן.",
            exampleNative = "Этот обычай хранится מִקֶּדֶם и передаётся от отца к сыну в каждой семье.",
         fillInBlankExclusions = listOf(183416L, 183418L, 183419L, 183420L)),
        WordEntity(
            id = 183418, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "adverb", semanticGroup = "time_l3_relative_formal",
            original = "לְהַבָּא", translation = "впредь",
            transliteration = "леhаба",
            definition = "מֵעַתָּה וְקָדִימָה — בְּכָל הַזְּמַנִּים שֶׁיָּבוֹאוּ אַחֲרֵי הָרֶגַע הַזֶּה.",
            definitionNative = "Отныне и далее — во все времена, что наступят после этого момента.",
            example = "לְהַבָּא נְעַדְכֵּן אוֹתְךָ עַל כָּל שִׁנּוּי בָּאֲרָעוֹת.",
            exampleNative = "לְהַבָּא мы будем сообщать тебе о каждом изменении в графике.",
         fillInBlankExclusions = listOf(183416L, 183417L, 183419L, 183420L)),
        WordEntity(
            id = 183419, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "adverb", semanticGroup = "time_l3_relative_formal",
            original = "לְעֵת עַתָּה", translation = "пока что",
            transliteration = "леэт ата",
            definition = "בָּרֶגַע הַזֶּה וְעַד עֵת אַחֶרֶת — מַצָּב זְמַנִּי שֶׁיִּשְׁתַּנֶּה אַחֲרֵי כֵן.",
            definitionNative = "В этот миг и до иного срока — временное положение, что изменится позже.",
            example = "לְעֵת עַתָּה אֲנַחְנוּ נִשְׁאָרִים בַּדִּירָה הַזֹּאת וְלֹא עוֹבְרִים.",
            exampleNative = "לְעֵת עַתָּה мы остаёмся в этой квартире и не переезжаем в другую.",
         fillInBlankExclusions = listOf(183416L, 183417L, 183418L, 183420L)),
        WordEntity(
            id = 183420, setId = 1834, languagePair = "he-ru", rarity = "EPIC",
            pos = "adverb", semanticGroup = "time_l3_relative_formal",
            original = "מֵאָז וּמִקֶּדֶם", translation = "испокон веков",
            transliteration = "меаз у-микэдэм",
            definition = "מִתְּחִילָה שֶׁל הַזְּמַן וְעַד הַיּוֹם — בְּכָל הַדּוֹרוֹת בְּלִי הַפְסָקָה.",
            definitionNative = "С самого начала времён и до сегодня — во всех поколениях без перерыва.",
            example = "הַשֵּׁבֶט גָּר לְיַד הַנָּהָר מֵאָז וּמִקֶּדֶם וְלֹא עָזַב מֵעוֹלָם.",
            exampleNative = "Племя живёт у реки מֵאָז וּמִקֶּדֶם и не покидало её никогда.",
         fillInBlankExclusions = listOf(183416L, 183417L, 183418L, 183419L)),

        // ─── time_l3_phases (5) ──────────────────────────────────────────
        WordEntity(
            id = 183421, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_phases",
            original = "הַשְׁהָיָה", translation = "отсрочка, пауза",
            transliteration = "hашhая",
            definition = "דְּחִיָּה מְכֻוֶּנֶת שֶׁל פְּעֻלָּה אוֹ אֵרוּעַ — עֲצִירָה זְמַנִּית לִפְנֵי שֶׁמַּמְשִׁיכִים.",
            definitionNative = "Намеренное откладывание действия или события — временная остановка перед продолжением.",
            example = "הַשְׁהָיָה קְצָרָה שֶׁל הַפְּגִישָׁה אִפְשְׁרָה לַצְּדָדִים לְהִתְיַעֵץ בֵּינֵיהֶם.",
            exampleNative = "Короткая הַשְׁהָיָה встречи позволила сторонам посовещаться между собой в кулуарах.",
         fillInBlankExclusions = listOf(183422L, 183423L, 183424L, 183425L)),
        WordEntity(
            id = 183422, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_phases",
            original = "הֲפוּגָה", translation = "передышка",
            transliteration = "hафуга",
            definition = "זְמַן קָצָר שֶׁל הֲקָלָה בְּאֶמְצַע מַאֲבָק אוֹ עָבוֹדָה קָשָׁה — לִפְנֵי שֶׁמַּמְשִׁיכִים.",
            definitionNative = "Короткое время облегчения посреди борьбы или тяжёлой работы — прежде чем продолжить.",
            example = "הַחַיָּלִים נִצְּלוּ אֶת הַהֲפוּגָה בַּלְּחִימָה לִשְׁתּוֹת מַיִם וְלָנוּחַ.",
            exampleNative = "Солдаты использовали הֲפוּגָה в боях, чтобы попить воды и отдохнуть.",
         fillInBlankExclusions = listOf(183421L, 183423L, 183424L, 183425L)),
        WordEntity(
            id = 183423, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_phases",
            original = "מוֹעֵד", translation = "назначенный срок",
            transliteration = "моэд",
            definition = "תַּאֲרִיךְ אוֹ זְמַן קָבוּעַ מֵרֹאשׁ שֶׁבּוֹ צָרִיךְ לִקְרוֹת אֵרוּעַ אוֹ לְהַשְׁלִים מְשִׂימָה.",
            definitionNative = "Дата или время, заранее установленные, в которые должно произойти событие или завершиться задача.",
            example = "הַמּוֹעֵד הָאַחֲרוֹן לְהַגָּשַׁת הַטֹּפֶס הוּא יוֹם רִאשׁוֹן הַבָּא.",
            exampleNative = "מוֹעֵד крайний для подачи бланка — следующее воскресенье вечером.",
        ),
        WordEntity(
            id = 183424, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_phases",
            original = "פֶּרֶק זְמַן", translation = "отрезок времени",
            transliteration = "пэрэк зман",
            definition = "מִקְטָע מֻגְדָּר שֶׁל זְמַן בֵּין שְׁתֵּי נְקֻדּוֹת — תְּחִילָה וְסוֹף בְּרוּרִים.",
            definitionNative = "Очерченный участок времени между двумя точками — с ясными началом и концом.",
            example = "בְּפֶרֶק זְמַן שֶׁל חֳדָשַׁיִם הִשְׁלַמְנוּ אֶת כָּל שִׁפּוּצֵי הַבַּיִת.",
            exampleNative = "За פֶּרֶק זְמַן в два месяца мы завершили весь ремонт в доме.",
        ),
        WordEntity(
            id = 183425, setId = 1834, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l3_phases",
            original = "עִתּוּי", translation = "выбор момента",
            transliteration = "итуй",
            definition = "בְּחִירָה מְדֻיֶּקֶת שֶׁל הָרֶגַע הַנָּכוֹן לְבַצֵּעַ פְּעֻלָּה — לֹא מֻקְדָּם וְלֹא מְאֻחָר.",
            definitionNative = "Точный выбор подходящего момента для совершения действия — не рано и не поздно.",
            example = "הָעִתּוּי שֶׁל הַהוֹדָעָה הַזֹּאת הָיָה רַע וְהוֹרִיד אֶת הַמְּנָיוֹת.",
            exampleNative = "עִתּוּי этого сообщения было плохим и обрушило акции на бирже.",
         fillInBlankExclusions = listOf(183421L, 183422L, 183423L, 183424L)),
    )
}
