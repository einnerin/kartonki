package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Время и календарь", level 4 (B2-C1).
 * Один сет × 25 слов. setId = 1835.
 *
 *  - 17 EPIC + 8 RARE (два смежных уровня C1 + B2, EPIC доминирует на L4).
 *  - 5 семантических групп по 5 слов:
 *      time_l4_chronology_pro       — продвинутая хронология (5)
 *      time_l4_jewish_calendar_pro  — еврейский календарь профи (5)
 *      time_l4_temporal_phenomena   — астрономические явления (5)
 *      time_l4_relative_formal      — формальные временные ориентиры (5)
 *      time_l4_phases_pro           — продвинутые фазы и длительности (5)
 *  - Профессиональная и формальная лексика по теме «Время и календарь»
 *    на иврите. Никудим везде (стандарт he-ru).
 *  - Все 25 слов проверены grep'ом по `original = "..."` против всех
 *    WordDataHebrew*.kt и не пересекаются с set 1832 (L1), 1833 (L2),
 *    1834 (L3), AchievementRewards и тематическими батчами.
 *    Замены из-за дублей:
 *      • вместо הַקְדָּמָה זְמַן (הַקְדָּמָה занято в Achievement999928) —
 *        סִינְכְּרוּן и כְּרוֹנוֹמֶטֶר как чисто хронологические термины.
 *      • вместо רֶגַע מַכְרִיעַ (TimeL3 183405) — הַתָּמָדָה
 *        (постоянство) для группы phases_pro.
 *      • вместо הֵנָה וָהֵנָה / מֵרֵאשִׁית — בְּעוֹד מוֹעֵד / לְמִן
 *        как формальные ориентиры с менее литературной окраской.
 *  - fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь;
 *    FILL_IN_BLANK pipeline инжектит их централизованно после wave.
 */
object WordDataHebrewTimeL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1835, languagePair = "he-ru", orderIndex = 1835,
            name = "Время и календарь",
            description = "Хронология, еврейский календарь профи и темпоральные явления",
            topic = "Время и календарь", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── time_l4_chronology_pro (5) ──────────────────────────────────
        WordEntity(
            id = 183501, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l4_chronology_pro",
            original = "אֲנַכְרוֹנִיזְם", translation = "анахронизм",
            transliteration = "анахронизм",
            definition = "טָעוּת שֶׁל סִדּוּר זְמַנִּים — שִׁבּוּץ דָּבָר בִּתְקוּפָה שֶׁאֵינָהּ שַׁיֶּכֶת לוֹ.",
            definitionNative = "Ошибка временной расстановки — помещение чего-то в эпоху, которой оно не принадлежит.",
            example = "הַסָּרֶט נִכְשַׁל בִּגְלַל אֲנַכְרוֹנִיזְם בּוֹלֵט בְּלִבּוּשׁ הַדְּמֻיּוֹת.",
            exampleNative = "Фильм провалился из-за заметного אֲנַכְרוֹנִיזְם в одежде персонажей.",
         fillInBlankExclusions = listOf(183503L, 183504L, 183505L)),
        WordEntity(
            id = 183502, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "time_l4_chronology_pro",
            original = "רֶטְרוֹסְפֶּקְטִיבִי", translation = "ретроспективный",
            transliteration = "ретроспективи",
            definition = "מִתְיַחֵס לְהִסְתַּכְּלוּת אֲחוֹרָה עַל אֵרוּעִים אוֹ תְּקוּפוֹת שֶׁכְּבָר עָבְרוּ.",
            definitionNative = "Относящийся к взгляду назад на события или периоды, что уже прошли.",
            example = "הוּא נָתַן הַרְצָאָה רֶטְרוֹסְפֶּקְטִיבִית עַל עֶשֶׂר שְׁנוֹת מֶחְקָרוֹ בָּאוּנִיבֶרְסִיטָה.",
            exampleNative = "Он прочитал רֶטְרוֹסְפֶּקְטִיבִי доклад о десяти годах своих исследований.",
        ),
        WordEntity(
            id = 183503, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l4_chronology_pro",
            original = "פּוֹסְט-מוֹרְטֶם", translation = "разбор после события (постмортем)",
            transliteration = "пост-мортем",
            definition = "נִתּוּחַ מֻקְפָּד שֶׁל פְּרוֹיֶקְט אוֹ אֵרוּעַ אַחֲרֵי שֶׁכְּבָר נִגְמַר — לְלִמּוּד מִשְׁגִיאוֹת.",
            definitionNative = "Тщательный разбор проекта или события после его завершения — для извлечения уроков.",
            example = "צוות הַפְּרוֹיֶקְט עָרַךְ פּוֹסְט-מוֹרְטֶם מֻקְפָּד לְהָבִין אֵיךְ הִתְעַכְּבוּ הַלּוּחוֹת.",
            exampleNative = "Команда устроила פּוֹסְט-מוֹרְטֶם, чтобы понять, как сместились графики.",
         fillInBlankExclusions = listOf(183501L, 183504L, 183505L)),
        WordEntity(
            id = 183504, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l4_chronology_pro",
            original = "סִינְכְּרוּן", translation = "синхронизация",
            transliteration = "синхрун",
            definition = "פְּעֻלָּה שֶׁל הַתְאָמָה מְדֻיֶּקֶת שֶׁל זְמַן בֵּין מַעֲרָכוֹת אוֹ פְּעֻלּוֹת שׁוֹנוֹת.",
            definitionNative = "Действие точного согласования времени между разными системами или процессами.",
            example = "הַסִּינְכְּרוּן בֵּין שְׁעוֹנֵי הַשְּׂרָתִים נַעֲשָׂה אוֹטוֹמָטִית בְּכָל לַיְלָה.",
            exampleNative = "סִינְכְּרוּן между серверными часами выполняется автоматически каждую ночь.",
        ),
        WordEntity(
            id = 183505, setId = 1835, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l4_chronology_pro",
            original = "כְּרוֹנוֹמֶטֶר", translation = "хронометр",
            transliteration = "хронометэр",
            definition = "מַכְשִׁיר מְדִידַת זְמַן מְדֻיָּק בְּיוֹתֵר — בְּשִׁמּוּשׁ בְּסַפָּנוּת וּמַחְקָר מַדָּעִי.",
            definitionNative = "Прибор для самого точного измерения времени — применяется в мореходстве и научных исследованиях.",
            example = "הַסַּפָּן בָּדַק אֶת קְרִיאַת הַכְּרוֹנוֹמֶטֶר לִפְנֵי כָּל חִשּׁוּב נִוּוּטִי.",
            exampleNative = "Капитан сверял показания כְּרוֹנוֹמֶטֶר перед каждым навигационным расчётом.",
         fillInBlankExclusions = listOf(183501L, 183503L, 183504L)),

        // ─── time_l4_jewish_calendar_pro (5) ─────────────────────────────
        WordEntity(
            id = 183506, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "time_l4_jewish_calendar_pro",
            original = "סְפִירַת הָעוֹמֶר", translation = "счёт омера",
            transliteration = "сфират hа-омер",
            definition = "תְּקוּפָה שֶׁל אַרְבָּעִים וְתִשְׁעָה יָמִים בֵּין פֶּסַח לְשָׁבוּעוֹת שֶׁבָּהּ סוֹפְרִים יוֹם יוֹם.",
            definitionNative = "Промежуток в сорок девять дней между Песахом и Шавуот, когда отсчитывают каждый день.",
            example = "בִּתְקוּפַת סְפִירַת הָעוֹמֶר נִמְנָעִים מִתִּסְרֹקֶת וּמִשִּׂמְחוֹת גְּדוֹלוֹת.",
            exampleNative = "В период סְפִירַת הָעוֹמֶר воздерживаются от стрижек и больших торжеств.",
         fillInBlankExclusions = listOf(183507L, 183508L, 183509L, 183510L)),
        WordEntity(
            id = 183507, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "time_l4_jewish_calendar_pro",
            original = "חַג שָׁבוּעוֹת", translation = "праздник Шавуот",
            transliteration = "хаг шавуот",
            definition = "חַג יְהוּדִי שֶׁבּוֹ מְצַיְּנִים אֶת מַתַּן תּוֹרָה — חָל חֲמִשִּׁים יוֹם אַחֲרֵי הַפֶּסַח.",
            definitionNative = "Еврейский праздник, в который отмечают дарование Торы — наступает через пятьдесят дней после Песаха.",
            example = "בְּחַג שָׁבוּעוֹת נוֹהֲגִים לֶאֱכֹל מַאַכְלֵי חָלָב וְלִקְרֹא אֶת מְגִלַּת רוּת.",
            exampleNative = "В חַג שָׁבוּעוֹת принято есть молочные блюда и читать свиток Рут.",
         fillInBlankExclusions = listOf(183506L, 183508L, 183509L, 183510L)),
        WordEntity(
            id = 183508, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "time_l4_jewish_calendar_pro",
            original = "יָמִים נוֹרָאִים", translation = "Дни трепета",
            transliteration = "ямим нораим",
            definition = "עֲשֶׂרֶת הַיָּמִים שֶׁבֵּין רֹאשׁ הַשָּׁנָה לְיוֹם כִּפּוּר — תְּקוּפַת מִשְׁפָּט וּתְשׁוּבָה.",
            definitionNative = "Десять дней между Рош ha-Шана и Йом-Киппур — период суда и покаяния.",
            example = "בִּימֵי יָמִים נוֹרָאִים בָּתֵּי הַכְּנֶסֶת מְלֵאִים מִתְפַּלְלִים מֵהַבֹּקֶר.",
            exampleNative = "В יָמִים נוֹרָאִים синагоги полны молящихся уже с самого утра.",
         fillInBlankExclusions = listOf(183506L, 183507L, 183509L, 183510L)),
        WordEntity(
            id = 183509, setId = 1835, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "time_l4_jewish_calendar_pro",
            original = "חוֹל הַמּוֹעֵד", translation = "будни праздника",
            transliteration = "холь hа-моэд",
            definition = "הַיָּמִים הָאֶמְצָעִיִּים שֶׁל פֶּסַח אוֹ סֻכּוֹת — בֵּין הַיּוֹם הָרִאשׁוֹן לָאַחֲרוֹן.",
            definitionNative = "Промежуточные дни Песаха или Суккот — между первым и последним днём праздника.",
            example = "בְּחוֹל הַמּוֹעֵד הַמִּשְׁפָּחוֹת יוֹצְאוֹת לְטִיּוּלִים וּלְמוּזֵיאוֹנִים.",
            exampleNative = "В חוֹל הַמּוֹעֵד семьи выходят на прогулки и едут по музеям страны.",
         fillInBlankExclusions = listOf(183506L, 183507L, 183508L, 183510L)),
        WordEntity(
            id = 183510, setId = 1835, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "time_l4_jewish_calendar_pro",
            original = "רֹאשׁ חֹדֶשׁ", translation = "новомесячье (рош-ходеш)",
            transliteration = "рош ходэш",
            definition = "הַיּוֹם הָרִאשׁוֹן שֶׁל חֹדֶשׁ עִבְרִי — מוֹעֵד קָטָן עִם תְּפִלּוֹת מְיֻחָדוֹת.",
            definitionNative = "Первый день еврейского месяца — малый праздник с особыми молитвами.",
            example = "בְּרֹאשׁ חֹדֶשׁ קוֹרְאִים בַּתּוֹרָה וּמְבָרְכִים אֶת הַחֹדֶשׁ הַחָדָשׁ.",
            exampleNative = "В רֹאשׁ חֹדֶשׁ читают Тору и благословляют новый месяц.",
        ),

        // ─── time_l4_temporal_phenomena (5) ──────────────────────────────
        WordEntity(
            id = 183511, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l4_temporal_phenomena",
            original = "אַקְוִינוֹקְס", translation = "равноденствие (астрономический термин)",
            transliteration = "аквинокс",
            definition = "אַחַד מִשְּׁנֵי יְמֵי הַשָּׁנָה שֶׁבָּהֶם הַשֶּׁמֶשׁ חוֹצָה אֶת קַו הַמַּשְׁוֶה הַשָּׁמֵימִי.",
            definitionNative = "Один из двух дней года, когда солнце пересекает небесный экватор.",
            example = "אַקְוִינוֹקְס הַסְּתָו הִפְעִיל אֶת חַגִּיגוֹת הַקָּצִיר בְּעַמִּים עַתִּיקִים.",
            exampleNative = "Осенний אַקְוִינוֹקְס открывал праздники урожая у древних народов.",
         fillInBlankExclusions = listOf(183512L, 183513L, 183515L)),
        WordEntity(
            id = 183512, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l4_temporal_phenomena",
            original = "פֶּרִיהֶלְיוֹן", translation = "перигелий",
            transliteration = "перигельон",
            definition = "הַנְּקֻדָּה בִּמְסִלַּת כּוֹכָב הַקְּרוֹבָה בְּיוֹתֵר לַשֶּׁמֶשׁ — מוֹעֵד אַסְטְרוֹנוֹמִי קָבוּעַ.",
            definitionNative = "Точка орбиты планеты, ближайшая к солнцу — фиксированный астрономический момент.",
            example = "כַּדּוּר הָאָרֶץ עוֹבֵר בִּפֶּרִיהֶלְיוֹן בִּתְחִילַת יָנוּאָר מִדֵּי שָׁנָה.",
            exampleNative = "Земля проходит פֶּרִיהֶלְיוֹן в начале января каждый год.",
         fillInBlankExclusions = listOf(183511L, 183513L, 183515L)),
        WordEntity(
            id = 183513, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l4_temporal_phenomena",
            original = "אַפֶּהֶלְיוֹן", translation = "афелий",
            transliteration = "апэhельон",
            definition = "הַנְּקֻדָּה בִּמְסִלַּת כּוֹכָב הָרְחוֹקָה בְּיוֹתֵר מֵהַשֶּׁמֶשׁ — נְקֻדַּת זְמַן הָפוּכָה לְפֶּרִיהֶלְיוֹן.",
            definitionNative = "Точка орбиты планеты, наиболее далёкая от солнца — момент, противоположный перигелию.",
            example = "בְּאַפֶּהֶלְיוֹן בְּיוּלִי כַּדּוּר הָאָרֶץ נִמְצָא בַּמֶּרְחָק הַגָּדוֹל בְּיוֹתֵר.",
            exampleNative = "В אַפֶּהֶלְיוֹן в июле земля находится на наибольшем расстоянии от светила.",
         fillInBlankExclusions = listOf(183511L, 183512L, 183515L)),
        WordEntity(
            id = 183514, setId = 1835, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "time_l4_temporal_phenomena",
            original = "סִידֶרִיָּה", translation = "сидерический (звёздный, о периоде)",
            transliteration = "сидэрия",
            definition = "מִתְיַחֵס לִתְקוּפַת זְמַן הַנִּמְדֶּדֶת לְפִי הַכּוֹכָבִים הָרְחוֹקִים וְלֹא לְפִי הַשֶּׁמֶשׁ.",
            definitionNative = "Относящийся к промежутку времени, что измеряется по дальним звёздам, а не по солнцу.",
            example = "תְּקוּפָה סִידֶרִיָּה שֶׁל הַיָּרֵחַ קְצָרָה מֵהַתְּקוּפָה הַסִינוֹדִית בִּשְׁנֵי יָמִים.",
            exampleNative = "סִידֶרִיָּה лунный цикл короче синодического на двое суток.",
        ),
        WordEntity(
            id = 183515, setId = 1835, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "time_l4_temporal_phenomena",
            original = "מַחְזוֹרִיּוּת", translation = "цикличность",
            transliteration = "махзорьют",
            definition = "תְּכוּנָה שֶׁל חֲזָרָה קְבוּעָה עַל אוֹתָהּ תּוֹפָעָה אַחַר פֶּרֶק זְמַן יַצִּיב.",
            definitionNative = "Свойство постоянного возвращения одного и того же явления через стабильный промежуток.",
            example = "מַחְזוֹרִיּוּת שֶׁל גַּאוּת וָשֵׁפֶל בַּיָּם תְּלוּיָה בִּתְנוּעַת הַיָּרֵחַ.",
            exampleNative = "מַחְזוֹרִיּוּת морских приливов и отливов зависит от движения луны.",
         fillInBlankExclusions = listOf(183511L, 183512L, 183513L, 183522L)),

        // ─── time_l4_relative_formal (5) ─────────────────────────────────
        WordEntity(
            id = 183516, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "preposition", semanticGroup = "time_l4_relative_formal",
            original = "בְּטֶרֶם", translation = "прежде, до того как (книжн.)",
            transliteration = "бетэрэм",
            definition = "לִפְנֵי שֶׁמַּשֶּׁהוּ קוֹרֶה — מִלָּה סִפְרוּתִית בִּמְשׁוּמָּשָׁה בִּלְשׁוֹן רִשְׁמִית.",
            definitionNative = "До того, как что-то произойдёт — литературное слово книжной речи.",
            example = "בְּטֶרֶם נַחְלִיט עַל הַחוֹזֶה כְּדַאי לְהִתְיַעֵץ עִם עוֹרֵךְ הַדִּין.",
            exampleNative = "בְּטֶרֶם решать насчёт договора, стоит проконсультироваться с юристом.",
         fillInBlankExclusions = listOf(183520L)),
        WordEntity(
            id = 183517, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "adverb", semanticGroup = "time_l4_relative_formal",
            original = "בְּעִתָּהּ", translation = "в свой срок, в положенное время",
            transliteration = "беитаh",
            definition = "בִּזְמַן הַנָּכוֹן וְהָרָאוּי שֶׁנִּקְבַּע מֵרֹאשׁ — לֹא מֻקְדָּם וְלֹא מְאֻחָר.",
            definitionNative = "В подобающее и правильное время, что было определено заранее — не рано и не поздно.",
            example = "כָּל פְּרִי מַבְשִׁיל בְּעִתָּהּ — אֵין טַעַם לְמַהֵר אֶת הַטֶּבַע.",
            exampleNative = "Каждый плод созревает בְּעִתָּהּ — нет смысла торопить природу.",
        ),
        WordEntity(
            id = 183518, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "time_l4_relative_formal",
            original = "בְּעוֹד מוֹעֵד", translation = "заблаговременно, пока есть время",
            transliteration = "беод моэд",
            definition = "לִפְנֵי שֶׁכְּבָר מְאֻחָר — בִּזְמַן שֶׁעוֹד נִתָּן לְפְעוֹל וּלְתַקֵּן.",
            definitionNative = "Прежде чем уже поздно — во время, когда ещё можно действовать и поправлять.",
            example = "כְּדַאי לְהוֹדִיעַ עַל הַתַּקָּלָה בְּעוֹד מוֹעֵד וְלֹא אַחֲרֵי הַפַּגִישָׁה.",
            exampleNative = "Сообщить о неполадке стоит בְּעוֹד מוֹעֵד, а не уже после совещания.",
         fillInBlankExclusions = listOf(183525L)),
        WordEntity(
            id = 183519, setId = 1835, languagePair = "he-ru", rarity = "RARE",
            pos = "adverb", semanticGroup = "time_l4_relative_formal",
            original = "אֵי-פַּעַם", translation = "когда-либо, когда-нибудь",
            transliteration = "эй-паам",
            definition = "בְּזְמַן כָּלשֶׁהוּ בֶּעָבָר אוֹ בֶּעָתִיד — בְּלִי לִקְבֹּעַ נְקֻדָּה מְדֻיֶּקֶת.",
            definitionNative = "В какое-то время в прошлом или будущем — без указания точной точки.",
            example = "הַאִם הָיִיתָ אֵי-פַּעַם בִּצְפוֹן הָאָרֶץ בִּתְקוּפַת הַחֹרֶף?",
            exampleNative = "Бывал ли ты אֵי-פַּעַם на севере страны зимой?",
         fillInBlankExclusions = listOf(183517L)),
        WordEntity(
            id = 183520, setId = 1835, languagePair = "he-ru", rarity = "RARE",
            pos = "preposition", semanticGroup = "time_l4_relative_formal",
            original = "לְמִן", translation = "начиная с (формально)",
            transliteration = "лемин",
            definition = "מֵהַנְּקֻדָּה הַזֹּאת בַּזְּמַן וָהָלְאָה — צוּרָה רִשְׁמִית סִפְרוּתִית.",
            definitionNative = "От этой точки во времени и далее — официальная литературная форма.",
            example = "לְמִן הַחֲתִימָה עַל הַחוֹזֶה הַחֶבְרָה אַחְרָאִית עַל הַתַּשְׁלוּמִים.",
            exampleNative = "לְמִן подписания договора фирма отвечает за платежи.",
         fillInBlankExclusions = listOf(183516L)),

        // ─── time_l4_phases_pro (5) ──────────────────────────────────────
        WordEntity(
            id = 183521, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l4_phases_pro",
            original = "נֶצַח", translation = "вечность",
            transliteration = "нэцах",
            definition = "זְמַן בְּלִי קֵץ וּבְלִי תְּחִילָה — מֻשָּׂג שֶׁל קִיּוּם תְּמִידִי לְלֹא הַפְסָקָה.",
            definitionNative = "Время без конца и без начала — понятие постоянного существования без перерыва.",
            example = "הָאַהֲבָה הַזֹּאת תַּחֲזִיק נֶצַח, אֲבָל לֹא תָּמִיד בְּאוֹתָהּ צוּרָה.",
            exampleNative = "Эта любовь продлится נֶצַח — но не всегда в одной и той же форме.",
         fillInBlankExclusions = listOf(183522L, 183523L, 183524L)),
        WordEntity(
            id = 183522, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l4_phases_pro",
            original = "חֲלוֹפִיּוּת", translation = "преходящесть",
            transliteration = "халофиют",
            definition = "תְּכוּנָה שֶׁל דָּבָר שֶׁעוֹבֵר וְחוֹלֵף בִּמְהִירוּת וְאֵינוֹ נִשְׁאָר לִזְמַן רַב.",
            definitionNative = "Свойство того, что быстро уходит и проходит, не оставаясь надолго.",
            example = "מְשׁוֹרְרֵי הַזֵּן כָּתְבוּ הַרְבֵּה עַל חֲלוֹפִיּוּת הַיֹּפִי שֶׁל הַפְּרִיחָה.",
            exampleNative = "Дзенские поэты много писали о חֲלוֹפִיּוּת красоты цветения сакуры.",
         fillInBlankExclusions = listOf(183515L, 183521L, 183523L, 183524L)),
        WordEntity(
            id = 183523, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l4_phases_pro",
            original = "אֱפֶמֶרִיּוּת", translation = "эфемерность",
            transliteration = "эфэмэриют",
            definition = "אֹפִי שֶׁל קִיּוּם קָצָר בְּיוֹתֵר — שֶׁל יוֹם אוֹ שָׁעוֹת מְעַטּוֹת בִּלְבַד.",
            definitionNative = "Свойство крайне короткого существования — длиной в день или несколько часов.",
            example = "אֱפֶמֶרִיּוּת שֶׁל הַסְּטוֹרִי בָּרֶשֶׁת הוֹפֶכֶת אוֹתוֹ לְכַלִּי שִׁוּוּק יָעִיל.",
            exampleNative = "אֱפֶמֶרִיּוּת сторис в сети превращает её в эффективный маркетинговый инструмент.",
         fillInBlankExclusions = listOf(183515L, 183521L, 183522L, 183524L)),
        WordEntity(
            id = 183524, setId = 1835, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l4_phases_pro",
            original = "הַתָּמָדָה", translation = "постоянство, упорство во времени",
            transliteration = "hатмада",
            definition = "תְּכוּנָה שֶׁל הַחְזָקָה רְצוּפָה בִּפְעֻלָּה אוֹ בְּמַצָּב לְאֹרֶךְ זְמַן רַב לְלֹא וִתּוּר.",
            definitionNative = "Свойство непрерывного удержания действия или состояния в течение долгого времени без сдачи.",
            example = "הַתָּמָדָה בְּאִמּוּנִים הִיא הַסּוֹד שֶׁל כָּל הִשֵּׂג סְפּוֹרְטִיבִי גָּדוֹל.",
            exampleNative = "הַתָּמָדָה в тренировках — это секрет любого крупного спортивного достижения.",
         fillInBlankExclusions = listOf(183521L, 183522L, 183523L)),
        WordEntity(
            id = 183525, setId = 1835, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "time_l4_phases_pro",
            original = "בִּן רֶגַע", translation = "мгновенно, в одночасье",
            transliteration = "бин рэга",
            definition = "תּוֹךְ זְמַן קָצָר בְּיוֹתֵר — מַשֶּׁהוּ שֶׁקּוֹרֶה בְּלִי הִתְרָאָה וּבְלִי שְׁהוּת.",
            definitionNative = "За самое короткое время — что-то, что происходит без предупреждения и без задержки.",
            example = "הַשְּׁמוּעָה הִתְפַּשְּׁטָה בִּן רֶגַע בְּכָל מַחְלְקוֹת הַמִּשְׂרָד.",
            exampleNative = "Слух разлетелся בִּן רֶגַע по всем отделам офиса.",
        ),
    )
}
