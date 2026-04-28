package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Эмоции и чувства", level 2 (A2-B2).
 * Один сет × 25 слов. setId = 1828.
 *
 *  - 18 UNCOMMON + 7 RARE (два смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      emotions_l2_complex         — сложные эмоции (удивление, гордость, стыд, фрустрация, вина) (5)
 *      emotions_l2_social          — социальные чувства (ревность, дружба, благодарность, забота, равнодушие) (5)
 *      emotions_l2_verbs_complex   — продвинутые глаголы чувств (волноваться, обижаться, радоваться, переживать, успокаивать) (5)
 *      emotions_l2_states          — эмоциональные состояния (уверенность, тревожный, уют, спокойствие, стресс) (5)
 *      emotions_l2_intensifiers    — продвинутые интенсификаторы (особенно, едва, частично, в основном, крайне) (5)
 *  - Не пересекается с set 1827 (L1): другая лексика, более продвинутая семантика.
 *  - Никудим везде (стандарт he-ru).
 *  - fillInBlankExclusions / isFillInBlankSafe не задаются — заполнятся через
 *    FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataHebrewEmotionsL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1828, languagePair = "he-ru", orderIndex = 1828,
            name = "Эмоции и чувства",
            description = "Сложные эмоции, социальные чувства и состояния",
            topic = "Эмоции и чувства", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── emotions_l2_complex (5) ─────────────────────────────────────
        WordEntity(
            id = 182801, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emotions_l2_complex",
            original = "הַפְתָּעָה", translation = "удивление, неожиданность",
            transliteration = "афтаа",
            definition = "תְּחוּשָׁה שֶׁמַּרְגִּישִׁים כַּאֲשֶׁר קוֹרֶה דָּבָר לֹא צָפוּי וְהַלֵּב קוֹפֵץ לְרֶגַע.",
            definitionNative = "Чувство, которое возникает, когда происходит что-то неожиданное и сердце на миг ёкает.",
            example = "הָיְתָה לִי הַפְתָּעָה גְּדוֹלָה כְּשֶׁכֻּלָּם הִגִּיעוּ לְיוֹם הַהֻלֶּדֶת.",
            exampleNative = "Меня ждала большая הַפְתָּעָה, когда все собрались на день рождения.",
         fillInBlankExclusions = listOf(182802L, 182803L, 182804L, 182805L, 182808L)),
        WordEntity(
            id = 182802, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emotions_l2_complex",
            original = "גַּאֲוָה", translation = "гордость",
            transliteration = "гаава",
            definition = "תְּחוּשַׁת סִפּוּק חַם כְּשֶׁמִּישֶׁהוּ קָרוֹב מַצְלִיחַ אוֹ כְּשֶׁמַּשִּׂיגִים מַטָּרָה חֲשׁוּבָה.",
            definitionNative = "Тёплое чувство удовлетворения, когда близкий добивается успеха или достигнута важная цель.",
            example = "אִמָּא שֶׁלִּי הִבִּיטָה בִּי בְּגַאֲוָה כְּשֶׁעָלִיתִי לַבַּמָּה.",
            exampleNative = "Мама смотрела на меня с גַּאֲוָה, когда я поднялся на сцену.",
        ),
        WordEntity(
            id = 182803, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emotions_l2_complex",
            original = "בּוּשָׁה", translation = "стыд",
            transliteration = "буша",
            definition = "תְּחוּשָׁה לֹא נְעִימָה שֶׁבָּאָה כְּשֶׁעוֹשִׂים מַשֶּׁהוּ לֹא נָכוֹן וְכֻלָּם רוֹאִים.",
            definitionNative = "Неприятное чувство, которое возникает, когда сделал что-то не так, и все это видят.",
            example = "הוּא הִרְגִּישׁ בּוּשָׁה גְּדוֹלָה אַחֲרֵי שֶׁשָּׁכַח אֶת הַשֵּׁם שֶׁל הַמּוֹרָה.",
            exampleNative = "Его охватила сильная בּוּשָׁה, когда он забыл имя учительницы.",
         fillInBlankExclusions = listOf(182801L, 182802L, 182804L, 182805L, 182820L)),
        WordEntity(
            id = 182804, setId = 1828, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l2_complex",
            original = "תִּסְכּוּל", translation = "фрустрация, досада",
            transliteration = "тискуль",
            definition = "תְּחוּשָׁה כְּבֵדָה שֶׁל אִי-נַחַת כְּשֶׁמְּנַסִּים שׁוּב וְשׁוּב וְלֹא מַצְלִיחִים.",
            definitionNative = "Тяжёлое чувство недовольства, когда пытаешься снова и снова, но ничего не выходит.",
            example = "הוּא לֹא הִסְתִּיר אֶת הַתִּסְכּוּל אַחֲרֵי שֶׁהַתָּכְנִית קָרְסָה בַּפַּעַם הַשְּׁלִישִׁית.",
            exampleNative = "Он не скрывал תִּסְכּוּל после того, как программа упала в третий раз.",
         fillInBlankExclusions = listOf(182801L, 182802L, 182803L, 182805L, 182810L, 182819L, 182820L)),
        WordEntity(
            id = 182805, setId = 1828, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l2_complex",
            original = "חֲרָטָה", translation = "раскаяние, сожаление",
            transliteration = "харата",
            definition = "תְּחוּשָׁה כּוֹאֶבֶת שֶׁמַּרְגִּישִׁים אַחֲרֵי מַעֲשֶׂה שֶׁהָיִינוּ רוֹצִים לֹא לַעֲשׂוֹת.",
            definitionNative = "Болезненное чувство после поступка, который мы предпочли бы не совершать.",
            example = "חֲרָטָה שְׁקֵטָה לֹא נָתְנָה לוֹ לְהֵרָדֵם כָּל הַלַּיְלָה.",
            exampleNative = "Тихая חֲרָטָה не давала ему уснуть всю ночь.",
         fillInBlankExclusions = listOf(182801L, 182802L, 182803L, 182804L, 182806L, 182820L)),

        // ─── emotions_l2_social (5) ──────────────────────────────────────
        WordEntity(
            id = 182806, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emotions_l2_social",
            original = "קִנְאָה", translation = "ревность, зависть",
            transliteration = "кинъа",
            definition = "תְּחוּשָׁה לֹא נְעִימָה כְּשֶׁרוֹצִים מַה שֶּׁיֵּשׁ לְמִישֶׁהוּ אַחֵר אוֹ פּוֹחֲדִים לְאַבֵּד אָהוּב.",
            definitionNative = "Неприятное чувство, когда хочешь то, что есть у другого, или боишься потерять любимого.",
            example = "הוּא הִרְגִּישׁ קִנְאָה כְּשֶׁרָאָה אֶת הָאָח שֶׁלּוֹ מְקַבֵּל אֶת הַתַּפְקִיד הָרָאשִׁי.",
            exampleNative = "Его кольнула קִנְאָה, когда он увидел, что главную роль получил его брат.",
         fillInBlankExclusions = listOf(182801L, 182802L, 182804L, 182807L, 182808L, 182809L, 182810L)),
        WordEntity(
            id = 182807, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emotions_l2_social",
            original = "חֲבֵרוּת", translation = "дружба",
            transliteration = "хаверут",
            definition = "קֶשֶׁר חַם וְקָרוֹב בֵּין אֲנָשִׁים שֶׁמַּכִּירִים זֶה אֶת זֶה הֵיטֵב וְעוֹזְרִים זֶה לָזֶה.",
            definitionNative = "Тёплая близкая связь между людьми, которые хорошо друг друга знают и помогают.",
            example = "הַחֲבֵרוּת בֵּינֵיהֶם הִתְחִילָה עוֹד בַּגַּן וְנִשְׁאֲרָה לְכָל הַחַיִּים.",
            exampleNative = "חֲבֵרוּת между ними началась ещё в детском саду и осталась на всю жизнь.",
         fillInBlankExclusions = listOf(182806L, 182808L, 182809L, 182810L)),
        WordEntity(
            id = 182808, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emotions_l2_social",
            original = "הַכָּרַת תּוֹדָה", translation = "благодарность",
            transliteration = "акарат тода",
            definition = "תְּחוּשָׁה חַמָּה כְּלַפֵּי מִישֶׁהוּ שֶׁעָזַר אוֹ עָשָׂה דָּבָר טוֹב לְמַעֲנְךָ.",
            definitionNative = "Тёплое чувство к тому, кто помог тебе или сделал что-то хорошее.",
            example = "כָּתַבְתִּי לָהּ מִכְתָּב שֶׁל הַכָּרַת תּוֹדָה אַחֲרֵי כָּל מַה שֶּׁעָשְׂתָה.",
            exampleNative = "Я написал ей письмо с הַכָּרַת תּוֹדָה за всё, что она сделала.",
         fillInBlankExclusions = listOf(182806L, 182807L, 182809L, 182810L)),
        WordEntity(
            id = 182809, setId = 1828, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l2_social",
            original = "אִכְפַּתִּיּוּת", translation = "неравнодушие, заботливость",
            transliteration = "ихпатиют",
            definition = "תְּכוּנָה שֶׁל אָדָם שֶׁבֶּאֱמֶת חוֹשֵׁב עַל אֲחֵרִים וְלֹא נִשְׁאָר אָדִישׁ לַסֵּבֶל שֶׁלָּהֶם.",
            definitionNative = "Качество человека, который искренне думает о других и не остаётся равнодушным к их боли.",
            example = "הָאִכְפַּתִּיּוּת שֶׁל הַשְּׁכֵנָה הָפְכָה אוֹתָהּ לְאַנְקוֹר שֶׁל הַבִּנְיָן.",
            exampleNative = "אִכְפַּתִּיּוּת соседки сделала её опорой всего дома.",
         fillInBlankExclusions = listOf(182806L, 182807L, 182808L, 182810L)),
        WordEntity(
            id = 182810, setId = 1828, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l2_social",
            original = "אֲדִישׁוּת", translation = "равнодушие, безразличие",
            transliteration = "адишут",
            definition = "מַצָּב שֶׁבּוֹ לְאָדָם לֹא אִכְפַּת מִמַּה שֶּׁקּוֹרֶה לַסְּבִיבָה אוֹ לַאֲנָשִׁים סְבִיבוֹ.",
            definitionNative = "Состояние, когда человеку безразлично всё, что происходит вокруг или с другими.",
            example = "הָאֲדִישׁוּת שֶׁל הָעוֹבְרִים-וְשָׁבִים פָּגְעָה בָּהּ יוֹתֵר מֵהַנְּפִילָה עַצְמָהּ.",
            exampleNative = "אֲדִישׁוּת прохожих ранила её сильнее самого падения.",
         fillInBlankExclusions = listOf(182806L, 182807L, 182808L, 182809L)),

        // ─── emotions_l2_verbs_complex (5) ───────────────────────────────
        WordEntity(
            id = 182811, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "emotions_l2_verbs_complex",
            original = "לִדְאֹג", translation = "беспокоиться, волноваться (за кого-то)",
            transliteration = "лидъог",
            definition = "לַחְשֹׁב הַרְבֵּה עַל מִישֶׁהוּ אוֹ עַל מַשֶּׁהוּ וּלְפַחֵד שֶׁיִּקְרֶה לוֹ דָּבָר רַע.",
            definitionNative = "Много думать о ком-то или чём-то и бояться, что с ним случится плохое.",
            example = "אִמָּא הִתְקַשְּׁרָה כִּי הִתְחִילָה לִדְאֹג שֶׁעֲדַיִן לֹא חָזַרְתִּי הַבַּיְתָה.",
            exampleNative = "Мама позвонила, потому что начала לִדְאֹג, что я ещё не вернулся.",
         fillInBlankExclusions = listOf(182812L, 182813L, 182814L, 182815L)),
        WordEntity(
            id = 182812, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "emotions_l2_verbs_complex",
            original = "לְהֵעָלֵב", translation = "обижаться",
            transliteration = "леэалев",
            definition = "לְהַרְגִּישׁ פָּגוּעַ בְּלֵב אַחֲרֵי שֶׁמִּישֶׁהוּ אָמַר אוֹ עָשָׂה דָּבָר שֶׁכּוֹאֵב.",
            definitionNative = "Чувствовать ранение в сердце после того, как кто-то сказал или сделал больно.",
            example = "הוּא נוֹטֶה לְהֵעָלֵב מִכָּל הֶעָרָה קְטַנָּה שֶׁל הַמְנַהֵל.",
            exampleNative = "Он склонен לְהֵעָלֵב от любой мелкой реплики начальника.",
         fillInBlankExclusions = listOf(182811L, 182813L, 182814L, 182815L)),
        WordEntity(
            id = 182813, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "emotions_l2_verbs_complex",
            original = "לִשְׂמֹחַ", translation = "радоваться",
            transliteration = "лисмоах",
            definition = "לְהַרְגִּישׁ אֹשֶׁר וְקַלּוּת בַּלֵּב כְּשֶׁקּוֹרֶה דָּבָר טוֹב לָנוּ אוֹ לִקְרוֹבֵינוּ.",
            definitionNative = "Чувствовать счастье и лёгкость в сердце, когда хорошее случается с нами или близкими.",
            example = "הִתְקַשַּׁרְתִּי לְבַשֵּׂר לָהּ וְהֵבַנְתִּי שֶׁהִיא יוֹדַעַת לִשְׂמֹחַ בְּכָל הַלֵּב.",
            exampleNative = "Я позвонил сообщить и понял, что она умеет לִשְׂמֹחַ от всего сердца.",
        ),
        WordEntity(
            id = 182814, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "emotions_l2_verbs_complex",
            original = "לְהִתְרַגֵּשׁ", translation = "волноваться (эмоционально), быть взволнованным",
            transliteration = "леитрагеш",
            definition = "לְהַרְגִּישׁ גַּל חָזָק שֶׁל רֶגֶשׁ — אֹשֶׁר אוֹ הִתְרַגְּשׁוּת — לִפְנֵי דָּבָר חָשׁוּב.",
            definitionNative = "Чувствовать сильную эмоциональную волну — счастье или трепет — перед чем-то важным.",
            example = "סָבְתָא נָהֲגָה לְהִתְרַגֵּשׁ עַד דְּמָעוֹת בְּכָל יוֹם הֻלֶּדֶת שֶׁל הַנְּכָדִים.",
            exampleNative = "Бабушка любила לְהִתְרַגֵּשׁ до слёз на каждом дне рождения внуков.",
        ),
        WordEntity(
            id = 182815, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "emotions_l2_verbs_complex",
            original = "לְהַרְגִּיעַ", translation = "успокаивать",
            transliteration = "леаргиа",
            definition = "לַעֲזֹר לְמִישֶׁהוּ לְהֵרָגַע — בְּמִלִּים, נְגִיעָה אוֹ נוֹכְחוּת שְׁקֵטָה.",
            definitionNative = "Помочь кому-то успокоиться — словами, прикосновением или тихим присутствием.",
            example = "אַבָּא נִסָּה לְהַרְגִּיעַ אֶת הַתִּינוֹק בִּשְׁעוֹת הַלַּיְלָה הַקְּטַנּוֹת.",
            exampleNative = "Папа пытался לְהַרְגִּיעַ малыша глубокой ночью.",
        ),

        // ─── emotions_l2_states (5) ──────────────────────────────────────
        WordEntity(
            id = 182816, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emotions_l2_states",
            original = "בִּטָּחוֹן עַצְמִי", translation = "уверенность в себе",
            transliteration = "битахон ацми",
            definition = "אֱמוּנָה פְּנִימִית בִּיכֹלֶת שֶׁלְּךָ לְהִתְמוֹדֵד עִם דְּבָרִים וּלְהַצְלִיחַ.",
            definitionNative = "Внутренняя вера в свою способность справиться с делами и добиться успеха.",
            example = "הַשִּׁעוּרִים הוֹסִיפוּ לָהּ הַרְבֵּה בִּטָּחוֹן עַצְמִי לִפְנֵי הָרֵאָיוֹן.",
            exampleNative = "Уроки добавили ей בִּטָּחוֹן עַצְמִי перед собеседованием.",
         fillInBlankExclusions = listOf(182818L, 182819L, 182820L)),
        WordEntity(
            id = 182817, setId = 1828, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "emotions_l2_states",
            original = "חַרְדָּתִי", translation = "тревожный (по характеру)",
            transliteration = "хардати",
            definition = "תֵּאוּר אָדָם שֶׁנּוֹטֶה לִדְאֹג מִכָּל דָּבָר וּלְצַפּוֹת מֵרֹאשׁ לִתְוֹצָאוֹת רָעוֹת.",
            definitionNative = "Описание человека, склонного беспокоиться о любой мелочи и заранее ждать худшего.",
            example = "הוּא טִיפּוּס חַרְדָּתִי וְתָמִיד בּוֹדֵק שָׁלוֹשׁ פְּעָמִים שֶׁהַדֶּלֶת נְעוּלָה.",
            exampleNative = "Он по природе חַרְדָּתִי и всегда трижды проверяет, заперта ли дверь.",
        ),
        WordEntity(
            id = 182818, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emotions_l2_states",
            original = "נֹחוּת", translation = "уют, душевный комфорт",
            transliteration = "нохут",
            definition = "תְּחוּשָׁה נְעִימָה שֶׁל קַלּוּת בַּגּוּף וּבַלֵּב כְּשֶׁכָּל הַסְּבִיבָה תּוֹמֶכֶת בְּךָ.",
            definitionNative = "Приятное чувство лёгкости в теле и сердце, когда вокруг всё располагает.",
            example = "הַשְּׂמִיכָה הַחַמָּה וְהַסֵּפֶר יָצְרוּ נֹחוּת מֻשְׁלֶמֶת בְּעֶרֶב חֹרֶף.",
            exampleNative = "Тёплый плед и книга создали идеальный נֹחוּת зимним вечером.",
         fillInBlankExclusions = listOf(182816L, 182819L, 182820L)),
        WordEntity(
            id = 182819, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emotions_l2_states",
            original = "רֹגַע", translation = "спокойствие, умиротворение",
            transliteration = "рога",
            definition = "מַצָּב שָׁקֵט שֶׁל הַנֶּפֶשׁ — בְּלִי לַחַץ, בְּלִי דְּאָגָה וּבְלִי רַעַשׁ פְּנִימִי.",
            definitionNative = "Тихое состояние души — без давления, тревоги и внутреннего шума.",
            example = "אַחֲרֵי הַטִּיּוּל לְיַד הַנַּחַל הִרְגַּשְׁתִּי רֹגַע שֶׁלֹּא יָדַעְתִּי שָׁבוּעוֹת.",
            exampleNative = "После прогулки у ручья я ощутил רֹגַע, какого не было неделями.",
         fillInBlankExclusions = listOf(182808L, 182816L, 182818L, 182820L)),
        WordEntity(
            id = 182820, setId = 1828, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "emotions_l2_states",
            original = "עָקָה", translation = "гнёт, душевная тяжесть (книжн.)",
            transliteration = "ака",
            definition = "מַצָּב נַפְשִׁי כָּבֵד וְלוֹחֵץ — מִלָּה סִפְרוּתִית לִתְחוּשַׁת מֶתַח כְּרוֹנִי.",
            definitionNative = "Тяжёлое гнетущее душевное состояние — книжное слово для хронической напряжённости.",
            example = "עָקָה כְּבֵדָה הִקִּיפָה אוֹתוֹ לִפְנֵי כָּל יְצִיאָה לְבַמָּה.",
            exampleNative = "Тяжёлая עָקָה охватывала его перед каждым выходом на сцену.",
         fillInBlankExclusions = listOf(182803L, 182805L, 182816L, 182818L, 182819L)),

        // ─── emotions_l2_intensifiers (5) ────────────────────────────────
        WordEntity(
            id = 182821, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "emotions_l2_intensifiers",
            original = "בִּמְיֻחָד", translation = "особенно, в особенности",
            transliteration = "бимъюхад",
            definition = "מִלָּה שֶׁמַּדְגִּישָׁה דָּבָר אֶחָד מִתּוֹךְ קְבוּצָה — בּוֹלֵט יוֹתֵר מֵהָאֲחֵרִים.",
            definitionNative = "Слово, что выделяет одно из группы — выделяющееся сильнее других.",
            example = "אֲנִי אוֹהֵב פֵּרוֹת, וּבִמְיֻחָד אֲנִי אוֹהֵב מַנְגוֹ בָּשֵׁל.",
            exampleNative = "Я люблю фрукты, и בִּמְיֻחָד люблю спелое манго.",
        ),
        WordEntity(
            id = 182822, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "emotions_l2_intensifiers",
            original = "בְּקֹשִׁי", translation = "едва, с трудом",
            transliteration = "бекоши",
            definition = "מִלָּה שֶׁאוֹמֶרֶת שֶׁדָּבָר קָרָה רַק בְּקֹשִׁי גָּדוֹל אוֹ כִּמְעַט לֹא קָרָה.",
            definitionNative = "Слово, что говорит — нечто случилось только с большим трудом или почти не случилось.",
            example = "הָיִיתִי כָּל-כָּךְ עָיֵף שֶׁבְּקֹשִׁי שָׁמַעְתִּי מַה שֶּׁאָמְרוּ לִי בַּטֶּלֶפוֹן.",
            exampleNative = "Я так устал, что בְּקֹשִׁי слышал, что мне говорили по телефону.",
         fillInBlankExclusions = listOf(182821L, 182823L, 182824L, 182825L)),
        WordEntity(
            id = 182823, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "emotions_l2_intensifiers",
            original = "חֶלְקִית", translation = "частично",
            transliteration = "хелькит",
            definition = "מִלָּה שֶׁאוֹמֶרֶת שֶׁדָּבָר קָרָה רַק לְחֵלֶק מֵהַדָּבָר וְלֹא לְכֻלּוֹ.",
            definitionNative = "Слово, что говорит — что-то произошло только с частью предмета, а не целиком.",
            example = "הַתָּכְנִית הִצְלִיחָה רַק חֶלְקִית — חֲצִי מֵהַמַּטָּרוֹת נִשְׁאֲרוּ פְּתוּחוֹת.",
            exampleNative = "План удался только חֶלְקִית — половина задач осталась открытой.",
         fillInBlankExclusions = listOf(182821L, 182822L, 182824L, 182825L)),
        WordEntity(
            id = 182824, setId = 1828, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adverb", semanticGroup = "emotions_l2_intensifiers",
            original = "בְּעִקָּר", translation = "в основном, главным образом",
            transliteration = "беикар",
            definition = "מִלָּה שֶׁמַּדְגִּישָׁה אֶת הַחֵלֶק הַגָּדוֹל וְהַחָשׁוּב בְּיוֹתֵר מִדָּבָר כָּלְשֶׁהוּ.",
            definitionNative = "Слово, что выделяет наибольшую и важнейшую часть чего-либо.",
            example = "בַּקַּיִץ אֲנַחְנוּ אוֹכְלִים בְּעִקָּר יְרָקוֹת וּפֵרוֹת קָרִים.",
            exampleNative = "Летом мы בְּעִקָּר едим овощи и холодные фрукты.",
         fillInBlankExclusions = listOf(182821L, 182822L, 182823L, 182825L)),
        WordEntity(
            id = 182825, setId = 1828, languagePair = "he-ru", rarity = "RARE",
            pos = "adverb", semanticGroup = "emotions_l2_intensifiers",
            original = "עַד מְאוֹד", translation = "крайне, в высшей степени",
            transliteration = "ад меод",
            definition = "צֵרוּף סִפְרוּתִי שֶׁמְּחַזֵּק תֵּאוּר עַד הַקָּצֶה — חָזָק יוֹתֵר מִ\"מְאוֹד\" רָגִיל.",
            definitionNative = "Книжное сочетание, что усиливает признак до предела — сильнее обычного «מְאוֹד».",
            example = "הַסִּפּוּר שֶׁלָּהּ הָיָה מְרַגֵּשׁ עַד מְאוֹד וְהִשְׁאִיר אֶת כֻּלָּם דּוֹמְמִים.",
            exampleNative = "Её рассказ был трогательным עַד מְאוֹד и оставил всех безмолвными.",
         fillInBlankExclusions = listOf(182821L, 182822L, 182823L, 182824L)),
    )
}
