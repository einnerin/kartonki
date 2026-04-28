package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Эмоции и чувства", level 4 (B2-C1).
 * Один сет × 25 слов. setId = 1830.
 *
 *  - 17 EPIC + 8 RARE (два смежных уровня C1 + B2, EPIC доминирует на L4).
 *  - 5 семантических групп по 5 слов:
 *      emotions_l4_psychological     — психологические термины (5)
 *      emotions_l4_complex_states    — сложные эмоциональные состояния (5)
 *      emotions_l4_verbs_pro         — продвинутые глаголы переживания (5)
 *      emotions_l4_descriptive_pro   — продвинутые описания характера (5)
 *      emotions_l4_relations_pro     — отношенческие термины (5)
 *  - Профессиональная лексика «Эмоции и чувства» на иврите.
 *    Никудим везде (стандарт he-ru).
 *  - Все 25 слов проверены grep'ом по `original = "..."` против всех
 *    WordDataHebrew*.kt и не пересекаются с set 1827 (L1), 1828 (L2),
 *    1829 (L3), а также с тематическими наборами 1016 (Психология),
 *    1141 (Внешность/характер), 1209 (Психология) и общими батчами.
 *    Замены из-за дублей:
 *      • вместо הַשְׁלָכָה (в Batch71 — проекция) — הַטָּלַת רֶגֶשׁ
 *        (буквально «бросание чувства», описательный термин).
 *      • вместо רֶגְרֶסְיָה (в AiMlL3 / Batch61) — נְסִיגָה רִגְשִׁית
 *        (эмоциональный откат, описательная пара).
 *      • вместо קָתַרְזִיס (в EntertainmentL5) — טִהוּר רֶגֶשׁ
 *        (очищение чувств, классический ивритский эквивалент).
 *      • вместо לְהִתְגַּעְגֵּעַ (в EmotionsL1) и לִכְסֹף (в L5) —
 *        לִשְׁתּוֹקֵק (страстно желать, томиться).
 *      • вместо לְהַעֲרִיץ (в EmotionsL3) — לִרְעֹד מִיִרְאָה
 *        (трепетать в благоговении, составное).
 *      • вместо אֲדִישׁוּת / אַטִימוּת (в L2/L3) — אַפַּתְיָה
 *        (апатия как профессиональный термин-заимствование).
 *      • вместо הִזְדַּהוּת (в L3) — חֶמְלָה (сострадание/милосердие)
 *        как реляционный термин уровня C1.
 *  - fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь;
 *    FILL_IN_BLANK pipeline инжектит их централизованно после wave.
 */
object WordDataHebrewEmotionsL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1830, languagePair = "he-ru", orderIndex = 1830,
            name = "Эмоции и чувства",
            description = "Психологические термины, сложные состояния и оттенки переживаний",
            topic = "Эмоции и чувства", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── emotions_l4_psychological (5) ───────────────────────────────
        WordEntity(
            id = 183001, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l4_psychological",
            original = "אַמְבִּיוָלֶנְטִיּוּת", translation = "амбивалентность",
            transliteration = "амбивалентиют",
            definition = "מַצָּב נַפְשִׁי שֶׁל שְׁתֵּי תְּחוּשׁוֹת הָפוּכוֹת כְּלַפֵּי אוֹתוֹ אָדָם אוֹ נוֹשֵׂא בְּאוֹתוֹ זְמַן.",
            definitionNative = "Душевное состояние, при котором человек питает два противоположных чувства к одному объекту одновременно.",
            example = "הַמְטֻפֶּלֶת תֵּאֲרָה אַמְבִּיוָלֶנְטִיּוּת עֲמֻקָּה כְּלַפֵּי אִמָּהּ הַזְּקֵנָה.",
            exampleNative = "Клиентка описала глубокую אַמְבִּיוָלֶנְטִיּוּת по отношению к своей пожилой матери.",
         fillInBlankExclusions = listOf(183002L, 183009L, 183021L, 183022L, 183023L, 183024L, 183025L)),
        WordEntity(
            id = 183002, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l4_psychological",
            original = "דִּיסוֹצְיָאצְיָה", translation = "диссоциация",
            transliteration = "дисоциация",
            definition = "נִתּוּק זְמַנִּי בֵּין הַמַּחֲשָׁבָה, הָרֶגֶשׁ וְהַזִּכָּרוֹן כִּתְגוּבָה לְמַצָּב קָשֶׁה.",
            definitionNative = "Временный разрыв связи между мыслью, чувством и памятью как реакция на тяжёлое переживание.",
            example = "אַחֲרֵי הַתְּאוּנָה הוּא חָוָה דִּיסוֹצְיָאצְיָה קַלָּה לִשְׁעָתַיִם.",
            exampleNative = "После аварии он пережил лёгкую דִּיסוֹצְיָאצְיָה на пару часов.",
         fillInBlankExclusions = listOf(183001L, 183006L, 183007L, 183008L, 183009L, 183010L)),
        WordEntity(
            id = 183003, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "emotions_l4_psychological",
            original = "הַטָּלַת רֶגֶשׁ", translation = "проекция (психол.)",
            transliteration = "hатaлат регеш",
            definition = "מַעֲשֶׂה לֹא מוּדָע שֶׁל הַעֲבָרַת רֶגֶשׁ פְּנִימִי לֹא רָצוּי עַל אָדָם אַחֵר.",
            definitionNative = "Бессознательный приём, при котором собственное нежелательное чувство приписывается другому человеку.",
            example = "הַכַּעַס שֶׁלּוֹ עַל הַחָבֵר הָיָה בְּעֶצֶם הַטָּלַת רֶגֶשׁ מִתּוֹךְ עַצְמוֹ.",
            exampleNative = "Его злость на друга на деле была הַטָּלַת רֶגֶשׁ из глубины самого себя.",
        ),
        WordEntity(
            id = 183004, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "emotions_l4_psychological",
            original = "נְסִיגָה רִגְשִׁית", translation = "регрессия (психол.)",
            transliteration = "несига ригшит",
            definition = "חֲזָרָה לֹא מוּדַעַת לְהִתְנַהֲגוּת אוֹ רֶגֶשׁ שֶׁל גִּיל צָעִיר יוֹתֵר תַּחַת לַחַץ.",
            definitionNative = "Бессознательный возврат к поведению или чувству более раннего возраста под давлением.",
            example = "בְּמַשְׁבֵּר הוּא גִּלָּה נְסִיגָה רִגְשִׁית וְדִבֵּר כְּמוֹ יֶלֶד קָטָן.",
            exampleNative = "В кризисе он показал נְסִיגָה רִגְשִׁית и заговорил, как маленький ребёнок.",
         fillInBlankExclusions = listOf(183003L, 183005L, 183009L)),
        WordEntity(
            id = 183005, setId = 1830, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "emotions_l4_psychological",
            original = "טִהוּר רֶגֶשׁ", translation = "катарсис, очищение чувств",
            transliteration = "тиhур регеш",
            definition = "שִׁחְרוּר נַפְשִׁי עָמֹק שֶׁמַּגִּיעַ אַחֲרֵי בִּטּוּי גָּלוּי שֶׁל רֶגֶשׁ עָצוּר.",
            definitionNative = "Глубокое душевное освобождение, что приходит после открытого выплеска подавленного чувства.",
            example = "הַהַצָּגָה הַטְּרָגִית הֵבִיאָה אֶת הַקָּהָל לְטִהוּר רֶגֶשׁ אֲמִתִּי.",
            exampleNative = "Трагический спектакль привёл публику к настоящему טִהוּר רֶגֶשׁ.",
        ),

        // ─── emotions_l4_complex_states (5) ──────────────────────────────
        WordEntity(
            id = 183006, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l4_complex_states",
            original = "מֶלַנְכוֹלְיָה", translation = "меланхолия",
            transliteration = "меланхолия",
            definition = "עַצְבוּת חֲרִישִׁית וְעֲמֻקָּה שֶׁמְּלַוָּה אָדָם זְמַן רַב בְּלִי סִבָּה בְּרוּרָה.",
            definitionNative = "Тихая глубокая печаль, что сопровождает человека долгое время без явной причины.",
            example = "הַסְּתָו עוֹרֵר בּוֹ מֶלַנְכוֹלְיָה שֶׁל יָמִים שֶׁעָבְרוּ.",
            exampleNative = "Осень пробуждала в нём מֶלַנְכוֹלְיָה по ушедшим дням.",
         fillInBlankExclusions = listOf(183007L, 183008L, 183009L, 183010L)),
        WordEntity(
            id = 183007, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l4_complex_states",
            original = "נוֹסְטַלְגְּיָה", translation = "ностальгия",
            transliteration = "ностальгия",
            definition = "כְּמִיהָה רַכָּה וְכּוֹאֶבֶת לְתְקוּפָה אוֹ לְמָקוֹם שֶׁאֵינָם עוֹד.",
            definitionNative = "Мягкое и щемящее томление по поре или месту, которых уже нет.",
            example = "מַרְאֵה הַבַּיִת הַיָּשָׁן הִצִּיף אוֹתוֹ בְּנוֹסְטַלְגְּיָה מְתוּקָה.",
            exampleNative = "Вид старого дома захлестнул его сладкой נוֹסְטַלְגְּיָה.",
         fillInBlankExclusions = listOf(183006L, 183008L, 183009L, 183010L)),
        WordEntity(
            id = 183008, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l4_complex_states",
            original = "אֶקְסְטָזָה", translation = "экстаз",
            transliteration = "экстаза",
            definition = "מַצָּב שֶׁל שִׂמְחָה גְּבוֹהָה בְּיוֹתֵר שֶׁבּוֹ הָאָדָם כִּמְעַט יוֹצֵא מִדַּעְתּוֹ.",
            definitionNative = "Состояние крайне высокой радости, при котором человек почти теряет рассудок.",
            example = "הַמּוּסִיקָאִית הִגִּיעָה לְאֶקְסְטָזָה בִּשְׁעַת הַנְּגִינָה הָאַחֲרוֹנָה.",
            exampleNative = "Музыкантша достигла אֶקְסְטָזָה во время последнего соло.",
         fillInBlankExclusions = listOf(183005L, 183006L, 183007L, 183009L, 183010L)),
        WordEntity(
            id = 183009, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l4_complex_states",
            original = "אַפַּתְיָה", translation = "апатия (проф.)",
            transliteration = "апатия",
            definition = "אֹבֶד מִתְמַשֵּׁךְ שֶׁל עִנְיָן, מֶרֶץ וְרֶגֶשׁ כְּלַפֵּי כָּל סְבִיבַת הָאָדָם.",
            definitionNative = "Длительная утрата интереса, сил и чувств по отношению ко всему окружающему.",
            example = "אַחֲרֵי שָׁבוּעוֹת שֶׁל מַחֲלָה הוּא שָׁקַע בְּאַפַּתְיָה כְּבֵדָה.",
            exampleNative = "После недель болезни он погрузился в тяжёлую אַפַּתְיָה.",
         fillInBlankExclusions = listOf(183006L, 183007L, 183008L, 183010L)),
        WordEntity(
            id = 183010, setId = 1830, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l4_complex_states",
            original = "מַנְיָה", translation = "мания (психол.)",
            transliteration = "мания",
            definition = "מַצָּב שֶׁל הִתְרוֹמְמוּת רוּחַ קִיצוֹנִית עִם פְּעִילוּת מֻגְזֶמֶת וּמְעַט שֵׁנָה.",
            definitionNative = "Состояние крайнего душевного подъёма с избыточной активностью и малым сном.",
            example = "בְּתוֹךְ מַנְיָה הוּא קָנָה שָׁלוֹשׁ מְכוֹנִיוֹת בְּשָׁבוּעַ אֶחָד.",
            exampleNative = "В разгар מַנְיָה он купил три машины за одну неделю.",
         fillInBlankExclusions = listOf(183006L, 183007L, 183008L, 183009L)),

        // ─── emotions_l4_verbs_pro (5) ───────────────────────────────────
        WordEntity(
            id = 183011, setId = 1830, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "emotions_l4_verbs_pro",
            original = "לִסְבֹּל", translation = "страдать",
            transliteration = "лисболь",
            definition = "לָשֵׂאת כְּאֵב נַפְשִׁי אוֹ גוּפָנִי כָּבֵד לְאֹרֶךְ זְמַן רַב.",
            definitionNative = "Долгое время нести тяжёлую душевную или телесную боль.",
            example = "הוּא סָבַל בְּשֶׁקֶט שָׁנִים רַבּוֹת בְּלִי לְסַפֵּר לְאִישׁ.",
            exampleNative = "Он сабаль в тишине долгие годы, не говоря никому.",
        ),
        WordEntity(
            id = 183012, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "verb", semanticGroup = "emotions_l4_verbs_pro",
            original = "לַעֲלֹז", translation = "ликовать (книжн.)",
            transliteration = "лаалоз",
            definition = "לְהַבִּיעַ שִׂמְחָה גְּבוֹהָה וְגָדוֹלָה בְּקוֹל וּבִתְנוּעָה — בְּלָשׁוֹן סִפְרוּתִית.",
            definitionNative = "Громко и движениями выражать большую и высокую радость — слово книжное.",
            example = "הָעָם עָלַז לְקוֹל הַבְּשׂוֹרָה עַל סִיּוּם הַמִּלְחָמָה.",
            exampleNative = "Народ алаз на весть об окончании войны.",
        ),
        WordEntity(
            id = 183013, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "verb", semanticGroup = "emotions_l4_verbs_pro",
            original = "לִשְׁתּוֹקֵק", translation = "страстно желать, томиться",
            transliteration = "лиштокек",
            definition = "לִרְצוֹת מַשֶּׁהוּ בְּעָצְמָה רַבָּה וּלְהַרְגִּישׁ אוֹתוֹ חָסֵר עַד כְּדֵי כְּאֵב פְּנִימִי.",
            definitionNative = "С огромной силой хотеть чего-то и ощущать его нехватку до внутренней боли.",
            example = "הִיא הִשְׁתּוֹקְקָה לַחֲזֹר הַבַּיְתָה אַחֲרֵי שָׁנִים שֶׁל נְדוּדִים בְּחוּץ לָאָרֶץ.",
            exampleNative = "После лет скитаний за границей она hиштокека вернуться домой.",
        ),
        WordEntity(
            id = 183014, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "verb", semanticGroup = "emotions_l4_verbs_pro",
            original = "לְהִתְלַהֵב", translation = "упоённо увлекаться, воспламеняться",
            transliteration = "леhитлаhэв",
            definition = "לְהִמָּלֵא הִתְרַגְּשׁוּת חַמָּה וְעַזָּה כְּלַפֵּי רַעְיוֹן אוֹ אָדָם בְּצוּרָה גְּלוּיָה.",
            definitionNative = "Открыто наполняться горячим и сильным воодушевлением к идее или человеку.",
            example = "הוּא נוֹטֶה לְהִתְלַהֵב מִכָּל סֶרֶט חָדָשׁ שֶׁהוּא רוֹאֶה.",
            exampleNative = "Он склонен לְהִתְלַהֵב от каждого нового фильма, что смотрит.",
         fillInBlankExclusions = listOf(183011L, 183012L, 183013L)),
        WordEntity(
            id = 183015, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "emotions_l4_verbs_pro",
            original = "לִרְעֹד מִיִרְאָה", translation = "благоговеть, трепетать в благоговении",
            transliteration = "лир'од ми-йир'а",
            definition = "לְהַרְגִּישׁ כָּבוֹד עָמֹק וְחֲרָדָה קַלָּה כְּלַפֵּי דָּבָר נִשְׂגָּב אוֹ קָדוֹשׁ.",
            definitionNative = "Чувствовать глубокое уважение и лёгкий трепет перед чем-то возвышенным или святым.",
            example = "הַמְבַקְּרִים רָעֲדוּ מִיִרְאָה בְּתוֹךְ הַכֹּתֶל הָעַתִּיק.",
            exampleNative = "Посетители לִרְעֹד מִיִרְאָה внутри древнего храма.",
        ),

        // ─── emotions_l4_descriptive_pro (5) ─────────────────────────────
        WordEntity(
            id = 183016, setId = 1830, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "emotions_l4_descriptive_pro",
            original = "קַר-רוּחַ", translation = "хладнокровный",
            transliteration = "кар-руах",
            definition = "שׁוֹמֵר עַל שַׁלְוָה וְשִׁקּוּל דַּעַת גַּם בְּמַצָּבִים מַפְחִידִים אוֹ מְלַחֲצִים.",
            definitionNative = "Сохраняющий спокойствие и трезвый разум даже в пугающих или давящих обстоятельствах.",
            example = "הַטַּיָּס הַקַּר-רוּחַ הִנְחִית אֶת הַמָּטוֹס לְלֹא מָנוֹעַ.",
            exampleNative = "Лётчик קַר-רוּחַ посадил самолёт без работающего двигателя.",
        ),
        WordEntity(
            id = 183017, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "emotions_l4_descriptive_pro",
            original = "אֶקְסְצֶנְטְרִי", translation = "эксцентричный",
            transliteration = "эксцентри",
            definition = "מִתְנַהֵג, לוֹבֵשׁ אוֹ חוֹשֵׁב בְּצוּרָה לֹא רְגִילָה שֶׁבּוֹלֶטֶת בָּרְאוּת לַסְּבִיבָה.",
            definitionNative = "Действующий, одевающийся или мыслящий необычно так, что заметно отличается от окружения.",
            example = "הָאָמָּן הָאֶקְסְצֶנְטְרִי בָּא לַטֶּקֶס בְּמֵעִיל אָרֹם וּכְפָפוֹת לְבָנוֹת.",
            exampleNative = "Художник אֶקְסְצֶנְטְרִי пришёл на церемонию в красном пальто и белых перчатках.",
         fillInBlankExclusions = listOf(183016L, 183018L, 183019L, 183020L)),
        WordEntity(
            id = 183018, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "emotions_l4_descriptive_pro",
            original = "אִימְפּוּלְסִיבִי", translation = "импульсивный",
            transliteration = "импульсиви",
            definition = "פּוֹעֵל לְפִי דַּחַף רִגְעִי בְּלִי לַחֲשֹׁב עַל תּוֹצָאוֹת אוֹ סִכּוּנִים.",
            definitionNative = "Действующий по сиюминутному порыву без обдумывания последствий или рисков.",
            example = "אוֹפִי אִימְפּוּלְסִיבִי גָּרַם לוֹ לַעֲזֹב אֶת הָעֲבוֹדָה בְּיוֹם אֶחָד.",
            exampleNative = "אִימְפּוּלְסִיבִי нрав заставил его уволиться за один день.",
         fillInBlankExclusions = listOf(183016L, 183017L, 183019L, 183020L)),
        WordEntity(
            id = 183019, setId = 1830, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "emotions_l4_descriptive_pro",
            original = "רֶפְלֶקְסִיבִי", translation = "рефлексивный, склонный к самоанализу",
            transliteration = "рефлексиви",
            definition = "נוֹטֶה לִבְחֹן אֶת מַחֲשְׁבוֹתָיו וּמַעֲשָׂיו בְּעוֹמֶק וּבְזָהִירוּת.",
            definitionNative = "Склонный глубоко и осторожно проверять собственные мысли и поступки.",
            example = "סִגְנוֹן רֶפְלֶקְסִיבִי שֶׁל הַמְנַחֶה עָזַר לִקְבוּצָה לְהַעֲמִיק.",
            exampleNative = "רֶפְלֶקְסִיבִי стиль ведущего помог группе углубить разговор.",
         fillInBlankExclusions = listOf(183016L, 183017L, 183018L, 183020L)),
        WordEntity(
            id = 183020, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "emotions_l4_descriptive_pro",
            original = "דּוּ-עֶרְכִּי", translation = "амбивалентный",
            transliteration = "ду-эрки",
            definition = "מַחֲזִיק שְׁתֵּי גִּישׁוֹת רִגְשִׁיּוֹת הָפוּכוֹת כְּלַפֵּי אוֹתוֹ נוֹשֵׂא בְּעֵת וּבְעוֹנָה אַחַת.",
            definitionNative = "Держащий два противоположных эмоциональных подхода к одному предмету в одно и то же время.",
            example = "הַיַּחַס הַדּוּ-עֶרְכִּי שֶׁלָּהּ לַהוֹרִים הִדְהִים אֶת הַמְּטַפֶּלֶת.",
            exampleNative = "Её דּוּ-עֶרְכִּי отношение к родителям поразило терапевта.",
         fillInBlankExclusions = listOf(183016L, 183017L, 183018L, 183019L)),

        // ─── emotions_l4_relations_pro (5) ───────────────────────────────
        WordEntity(
            id = 183021, setId = 1830, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l4_relations_pro",
            original = "מְסִירוּת", translation = "преданность",
            transliteration = "месирут",
            definition = "נֶאֱמָנוּת מְלֵאָה וְעַזָּה כְּלַפֵּי אָדָם, רַעְיוֹן אוֹ עִנְיָן לְאֹרֶךְ זְמַן רַב.",
            definitionNative = "Полная и крепкая верность по отношению к человеку, идее или делу долгое время.",
            example = "הַמְּסִירוּת שֶׁלָּהּ לַתַּלְמִידִים הִפְכָה אוֹתָהּ לְמוֹרָה אֲהוּבָה.",
            exampleNative = "Её מְסִירוּת ученикам сделала её любимой учительницей.",
        ),
        WordEntity(
            id = 183022, setId = 1830, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l4_relations_pro",
            original = "דְּחִיָּה", translation = "неприязнь, отторжение (проф.)",
            transliteration = "дхия",
            definition = "תְּגוּבָה רִגְשִׁית שֶׁל הַרְחָקַת אָדָם אוֹ רַעְיוֹן בְּלִי רָצוֹן בְּקֵרוּב.",
            definitionNative = "Эмоциональная реакция отдаления человека или идеи без желания сблизиться.",
            example = "הַיֶּלֶד הִרְגִּישׁ דְּחִיָּה כְּלַפֵּי אִישׁ הַזָּר בַּפַּרְק.",
            exampleNative = "Мальчик ощутил דְּחִיָּה к незнакомцу в парке.",
         fillInBlankExclusions = listOf(183001L, 183009L, 183021L, 183023L, 183024L, 183025L)),
        WordEntity(
            id = 183023, setId = 1830, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l4_relations_pro",
            original = "חֶמְלָה", translation = "сострадание, эмпатия (проф.)",
            transliteration = "хемла",
            definition = "רֶגֶשׁ עָמֹק שֶׁל הִשְׁתַּתְּפוּת בְּסֵבֶל הַזּוּלַת וְרָצוֹן לְהָקֵל עָלָיו.",
            definitionNative = "Глубокое чувство участия в чужом страдании и желания облегчить его.",
            example = "אֲחָיוֹת בָּטִפּוּל הַפַּלִיאָטִיבִי מְבַטְּאוֹת חֶמְלָה רַבָּה כָּל יוֹם.",
            exampleNative = "Сёстры паллиативного отделения каждый день проявляют большую חֶמְלָה.",
         fillInBlankExclusions = listOf(183021L, 183022L, 183024L, 183025L)),
        WordEntity(
            id = 183024, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l4_relations_pro",
            original = "אַנְטִיפַּתְיָה", translation = "антипатия",
            transliteration = "антипатия",
            definition = "תְּחוּשַׁת רֹעַ-לֵב סְמוּיָה כְּלַפֵּי אָדָם בְּלִי סִבָּה בְּרוּרָה אוֹ הִכַּרוּת קְרוֹבָה.",
            definitionNative = "Скрытое чувство недоброжелательности к человеку без явной причины или близкого знакомства.",
            example = "אַנְטִיפַּתְיָה הַדָּדִית שָׂרְרָה בֵּינֵיהֶם מֵהַיּוֹם הָרִאשׁוֹן.",
            exampleNative = "Взаимная אַנְטִיפַּתְיָה царила меж ними с первого дня.",
         fillInBlankExclusions = listOf(183001L, 183021L, 183022L, 183023L, 183025L)),
        WordEntity(
            id = 183025, setId = 1830, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "emotions_l4_relations_pro",
            original = "הִתְמַסְּרוּת", translation = "обожание, самоотдача",
            transliteration = "hитмасрут",
            definition = "מְסִירָה מְלֵאָה שֶׁל עַצְמוֹ וְזְמַנּוֹ לְאָדָם, מַטָּרָה אוֹ אָמָּנוּת בְּלִי שִׁיּוּר.",
            definitionNative = "Полная отдача себя и своего времени человеку, цели или искусству без остатка.",
            example = "הַהִתְמַסְּרוּת שֶׁלּוֹ לַמּוּסִיקָה הִדְהִימָה אֶת מוֹרָיו בַּקוֹנְסֶרְבָטוֹרְיוֹן.",
            exampleNative = "Его הִתְמַסְּרוּת музыке поразила учителей в консерватории.",
         fillInBlankExclusions = listOf(183001L, 183021L, 183022L, 183023L, 183024L)),
    )
}
