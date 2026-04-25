package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Set 1707 — «Политика», уровень 1 (single set, 25 words).
 *
 * 15 COMMON + 10 UNCOMMON. Базовая политическая лексика для репатриантов и
 * начинающих: государство, органы власти, выборы, формы правления, общество.
 *
 * Не пересекается со словами в существующих he-ru сетах темы «Политика»
 * (1069, 1119, 1177, 1190, 1204, 1275, 1276, 1277, 1493, 1494, 1528, 1545):
 * базовые מֶמְשָׁלָה, נָשִׂיא, רֹאשׁ הַמֶּמְשָׁלָה, שַׂר, כְּנֶסֶת, בְּחִירוֹת,
 * הַצְבָּעָה, חָבֵר כְּנֶסֶת, מְדִינָה, מִפְלָגָה, פּוֹלִיטִיקָה, שִׁלְטוֹן
 * уже покрыты — вместо них даём атрибуты государства, формы правления и
 * чуть более продвинутые понятия из той же бытовой сферы.
 */
object WordDataHebrewPoliticsL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1707, languagePair = "he-ru", orderIndex = 207,
            name = "Политика",
            description = "Базовая политическая лексика: правительство, выборы, министр",
            topic = "Политика", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── 1707: Политика (level 1, COMMON+UNCOMMON) ─────────────────────

        // — politics_state (5): COMMON חוֹק, אֶזְרָח, דֶּגֶל; UNCOMMON אֵזְרָחוּת, הִמְנוֹן —
        WordEntity(
            id = 170701, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_state", transliteration = "khok",
            original = "חוֹק", translation = "закон",
            definition = "כְּלָל רִשְׁמִי שֶׁהַמְּדִינָה מְחַיֶּבֶת אֶת כָּל הַתּוֹשָׁבִים לְקַיֵּם.",
            definitionNative = "Официальное правило, которое государство обязывает соблюдать всех жителей.",
            example = "כָּל אֶזְרָח חַיָּב לְקַיֵּם אֶת חוֹק הַמְּדִינָה.",
            exampleNative = "Каждый житель обязан соблюдать חוֹק страны.",
         fillInBlankExclusions = listOf(170703L, 170704L, 170705L, 170707L, 170709L)),
        WordEntity(
            id = 170702, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_state", transliteration = "ezrakh",
            original = "אֶזְרָח", translation = "гражданин",
            definition = "אָדָם שֶׁשַּׁיָּךְ רִשְׁמִית לִמְדִינָה וְיֵשׁ לוֹ זְכֻיּוֹת וְחוֹבוֹת.",
            definitionNative = "Человек, который официально принадлежит стране и имеет права и обязанности.",
            example = "כָּל אֶזְרָח מֵעַל גִּיל שְׁמוֹנֶה־עֶשְׂרֵה רַשַּׁאי לְהַצְבִּיעַ.",
            exampleNative = "Каждый אֶזְרָח старше восемнадцати имеет право голосовать.",
            fillInBlankExclusions = listOf(170703L, 170704L, 170705L),
        ),
        WordEntity(
            id = 170703, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_state", transliteration = "degel",
            original = "דֶּגֶל", translation = "флаг (государственный)",
            definition = "פִּסַּת בַּד עִם סֵמֶל הַמְּדִינָה הַמּוּנָפֶת בְּטֶקֶס רִשְׁמִי.",
            definitionNative = "Кусок ткани с гербом страны, что поднимают на официальной церемонии.",
            example = "הַדֶּגֶל הָיָה תָּלוּי בְּכָל בִּנְיַן צִבּוּרִי בְּיוֹם הָעַצְמָאוּת.",
            exampleNative = "דֶּגֶל висел на каждом общественном здании в День независимости.",
            fillInBlankExclusions = listOf(170701L, 170702L, 170705L),
        ),
        WordEntity(
            id = 170704, setId = 1707, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "politics_state", transliteration = "ezrakhut",
            original = "אֵזְרָחוּת", translation = "гражданство",
            definition = "מַעֲמָד רִשְׁמִי שֶׁל הִשְׁתַּיְּכוּת לִמְדִינָה עִם זְכֻיּוֹת מְלֵאוֹת.",
            definitionNative = "Официальное положение принадлежности к стране с полным набором прав.",
            example = "הוּא קִבֵּל אֵזְרָחוּת יִשְׂרְאֵלִית מִיָּד עִם הַנְּחִיתָה.",
            exampleNative = "Он получил אֵזְרָחוּת Израиля сразу после посадки.",
            fillInBlankExclusions = listOf(170701L, 170702L, 170705L),
        ),
        WordEntity(
            id = 170705, setId = 1707, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "politics_state", transliteration = "himnon",
            original = "הִמְנוֹן", translation = "гимн (государственный)",
            definition = "שִׁיר רִשְׁמִי שֶׁל מְדִינָה הַמּוּשַׁר בְּטֶקֶס לְאֻמִּי.",
            definitionNative = "Официальная песня страны, которую исполняют на национальной церемонии.",
            example = "הַתַּלְמִידִים שָׁרוּ אֶת הַהִמְנוֹן בְּטֶקֶס פְּתִיחַת הַשָּׁנָה.",
            exampleNative = "Школьники пели הִמְנוֹן на церемонии открытия учебного года.",
            fillInBlankExclusions = listOf(170701L, 170702L, 170703L),
        ),

        // — politics_government (5): COMMON מִשְׂרָד, חֻקָּה, מַס; UNCOMMON תַּקְצִיב, וֵטוֹ —
        WordEntity(
            id = 170706, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_government", transliteration = "misrad",
            original = "מִשְׂרָד", translation = "министерство; ведомство",
            definition = "גּוּף מֶמְשַׁלְתִּי הָאַחְרַאִי עַל תְּחוּם מְסֻיָּם כְּמוֹ חִנּוּךְ אוֹ בְּרִיאוּת.",
            definitionNative = "Государственный орган, отвечающий за определённую сферу — образование или здравоохранение.",
            example = "הִיא הִגִּישָׁה אֶת הַטֹּפֶס בַּמִּשְׂרָד הַסָּמוּךְ לִמְקוֹם הָעֲבוֹדָה.",
            exampleNative = "Она подала бланк в מִשְׂרָד рядом с работой.",
            fillInBlankExclusions = listOf(170707L, 170708L),
        ),
        WordEntity(
            id = 170707, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_government", transliteration = "khuka",
            original = "חֻקָּה", translation = "конституция",
            definition = "מִסְמָךְ עֶלְיוֹן שֶׁקּוֹבֵעַ אֶת הַכְּלָלִים הַבְּסִיסִיִּים שֶׁל מְדִינָה וְזַכֻיּוֹת תּוֹשָׁבִים.",
            definitionNative = "Высший документ, что задаёт основные правила государства и права жителей.",
            example = "הַחֻקָּה מַגִּינָה עַל חֹפֶשׁ הַדִּיבּוּר וְהַתְּנוּעָה.",
            exampleNative = "חֻקָּה защищает свободу слова и передвижения.",
            fillInBlankExclusions = listOf(170706L, 170708L),
        ),
        WordEntity(
            id = 170708, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_government", transliteration = "mas",
            original = "מַס", translation = "налог",
            definition = "תַּשְׁלוּם חוּקִּי שֶׁתּוֹשָׁבִים מַעֲבִירִים לַמְּדִינָה לְמִמּוּן שֵׁרוּתִים צִבּוּרִיִּים.",
            definitionNative = "Законная выплата, что жители перечисляют государству на финансирование общественных служб.",
            example = "הוּא שִׁלֵּם אֶת הַמַּס שֶׁלּוֹ בַּזְּמַן בְּכָל שָׁנָה.",
            exampleNative = "Он каждый год платил свой מַס вовремя.",
            fillInBlankExclusions = listOf(170706L, 170707L),
        ),
        WordEntity(
            id = 170709, setId = 1707, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "politics_government", transliteration = "taktsiv",
            original = "תַּקְצִיב", translation = "бюджет (государственный)",
            definition = "תָּכְנִית כַּסְפִּית שָׁנָתִית שֶׁל הַמְּדִינָה לְהוֹצָאוֹת וְהַכְנָסוֹת.",
            definitionNative = "Годовой денежный план государства по расходам и доходам.",
            example = "הַשָּׂרִים אִשְּׁרוּ אֶת הַתַּקְצִיב הַחָדָשׁ בְּסוֹף הַקַּיִץ.",
            exampleNative = "Министры утвердили новый תַּקְצִיב в конце лета.",
            fillInBlankExclusions = listOf(170706L, 170710L),
        ),
        WordEntity(
            id = 170710, setId = 1707, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "politics_government", transliteration = "veto",
            original = "וֵטוֹ", translation = "вето; запрет",
            definition = "סַמְכוּת רִשְׁמִית לִדְחוֹת הַחְלָטָה אוֹ לַעֲצוֹר חוֹק לִפְנֵי הַחַתִּימָה.",
            definitionNative = "Официальное полномочие отклонить решение или остановить закон до подписания.",
            example = "הַנָּשִׂיא הִטִּיל וֵטוֹ עַל הַחוֹק שֶׁעָבַר בָּעֶרֶב.",
            exampleNative = "Президент наложил וֵטוֹ на закон, что прошёл вечером.",
            fillInBlankExclusions = listOf(170706L, 170709L),
        ),

        // — politics_elections (5): COMMON מוֹעֲמָד, בְּעַד, נֶגֶד; UNCOMMON רֶפֶרֶנְדּוּם, נְאֻם —
        WordEntity(
            id = 170711, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_elections", transliteration = "moamad",
            original = "מוֹעֲמָד", translation = "кандидат",
            definition = "אָדָם שֶׁמַּצִּיעַ אֶת עַצְמוֹ לְתַפְקִיד צִבּוּרִי וּמְבַקֵּשׁ קוֹלוֹת.",
            definitionNative = "Тот, кто предлагает себя на общественную должность и просит голоса.",
            example = "הַמּוֹעֲמָד הַצָּעִיר הִגִּיעַ לְכָל פְּגִישַׁת שְׁכוּנָה.",
            exampleNative = "Молодой מוֹעֲמָד приходил на каждую встречу района.",
            fillInBlankExclusions = listOf(170714L, 170715L),
        ),
        WordEntity(
            id = 170712, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "preposition", semanticGroup = "politics_elections", transliteration = "be'ad",
            original = "בְּעַד", translation = "за (в поддержку)",
            definition = "מִלָּה הַמְּצַיֶּנֶת תְּמִיכָה בְּהַצָּעָה אוֹ בְּמוֹעֲמָד בְּזְמַן הַצְבָּעָה.",
            definitionNative = "Слово, что обозначает поддержку предложения или кандидата при голосовании.",
            example = "רֹב הַחֲבֵרִים הִצְבִּיעוּ בְּעַד הַהַצָּעָה הַחֲדָשָׁה.",
            exampleNative = "Большинство членов проголосовало בְּעַד нового предложения.",
            fillInBlankExclusions = listOf(170713L),
        ),
        WordEntity(
            id = 170713, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "preposition", semanticGroup = "politics_elections", transliteration = "neged",
            original = "נֶגֶד", translation = "против",
            definition = "מִלָּה הַמְּצַיֶּנֶת הִתְנַגְּדוּת לְהַצָּעָה אוֹ לְמוֹעֲמָד בְּזְמַן הַצְבָּעָה.",
            definitionNative = "Слово, что обозначает несогласие с предложением или кандидатом при голосовании.",
            example = "שְׁלוֹשָׁה חֲבֵרִים הִצְבִּיעוּ נֶגֶד הַתָּכְנִית הַחֲדָשָׁה.",
            exampleNative = "Трое членов проголосовали נֶגֶד нового плана.",
            fillInBlankExclusions = listOf(170712L),
        ),
        WordEntity(
            id = 170714, setId = 1707, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "politics_elections", transliteration = "referendum",
            original = "רֶפֶרֶנְדּוּם", translation = "референдум",
            definition = "הַצְבָּעָה כְּלָלִית שֶׁל כָּל הָאֶזְרָחִים עַל שְׁאֵלָה אַחַת חֲשׁוּבָה.",
            definitionNative = "Общее голосование всех граждан по одному важному вопросу.",
            example = "הָעָם נִקְרָא לְרֶפֶרֶנְדּוּם עַל שִׁנּוּי הַחֻקָּה.",
            exampleNative = "Народ позвали на רֶפֶרֶנְדּוּם по поводу изменения конституции.",
            fillInBlankExclusions = listOf(170711L, 170715L),
        ),
        WordEntity(
            id = 170715, setId = 1707, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "politics_elections", transliteration = "ne'um",
            original = "נְאֻם", translation = "речь; выступление",
            definition = "דִּבּוּר רִשְׁמִי בְּפָנֵי קָהָל בְּנוֹשֵׂא צִבּוּרִי אוֹ פּוֹלִיטִי.",
            definitionNative = "Официальное обращение перед публикой по общественной или политической теме.",
            example = "הַמּוֹעֲמָד נָשָׂא נְאֻם אָרֹךְ לִפְנֵי תּוֹמְכָיו בָּעִיר.",
            exampleNative = "Кандидат произнёс долгий נְאֻם перед сторонниками в городе.",
            fillInBlankExclusions = listOf(170711L, 170714L),
        ),

        // — politics_systems (5): COMMON דְּמוֹקְרַטְיָה, רֶפּוּבְּלִיקָה, פַּרְלָמֶנְט; UNCOMMON פֶּדֶרַצְיָה, מַהְפֵּכָה —
        WordEntity(
            id = 170716, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_systems", transliteration = "demokratya",
            original = "דְּמוֹקְרַטְיָה", translation = "демократия",
            definition = "שִׁיטַת מִמְשָׁל שֶׁבָּהּ הָעָם בּוֹחֵר אֶת מַנְהִיגָיו בִּבְחִירוֹת חֻפְשִׁיּוֹת.",
            definitionNative = "Система правления, в которой народ выбирает руководителей на свободных выборах.",
            example = "הַחֻקָּה מַגִּינָה עַל הַדְּמוֹקְרַטְיָה וְעַל זְכוּת הַהַצְבָּעָה.",
            exampleNative = "Конституция защищает דְּמוֹקְרַטְיָה и право голосовать.",
            fillInBlankExclusions = listOf(170717L, 170719L),
        ),
        WordEntity(
            id = 170717, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_systems", transliteration = "republika",
            original = "רֶפּוּבְּלִיקָה", translation = "республика",
            definition = "מְדִינָה שֶׁבָּהּ הָעָם בּוֹחֵר אֶת רֹאשׁ הַמְּדִינָה לִתְקוּפָה קְבוּעָה.",
            definitionNative = "Государство, в котором народ выбирает главу страны на установленный срок.",
            example = "הַמְּדִינָה הַזּוֹ הִיא רֶפּוּבְּלִיקָה עִם נָשִׂיא וְרֹאשׁ מֶמְשָׁלָה.",
            exampleNative = "Эта страна — רֶפּוּבְּלִיקָה с президентом и премьер-министром.",
            fillInBlankExclusions = listOf(170716L, 170719L),
        ),
        WordEntity(
            id = 170718, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_systems", transliteration = "parlament",
            original = "פַּרְלָמֶנְט", translation = "парламент",
            definition = "בֵּית מְחוֹקְקִים נִבְחָר הַמּוֹשְׁבֵי אֶת הַחֻקִּים שֶׁל הַמְּדִינָה.",
            definitionNative = "Выборный законодательный орган, что принимает законы государства.",
            example = "הַפַּרְלָמֶנְט אִשֵּׁר אֶת הַחוֹק בְּרֹב גָּדוֹל.",
            exampleNative = "פַּרְלָמֶנְט утвердил закон большим перевесом.",
            fillInBlankExclusions = listOf(170716L, 170717L, 170719L),
        ),
        WordEntity(
            id = 170719, setId = 1707, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "politics_systems", transliteration = "federatsya",
            original = "פֶּדֶרַצְיָה", translation = "федерация",
            definition = "אִיחוּד שֶׁל מְדִינוֹת אוֹ אֲזוֹרִים תַּחַת מִמְשָׁל מַרְכָּזִי וְחוֹק מְשֻׁתָּף.",
            definitionNative = "Союз государств или регионов под центральным правлением и общим законом.",
            example = "הַפֶּדֶרַצְיָה כּוֹלֶלֶת חֲמִשִּׁים מְדִינוֹת תַּחַת חֻקָּה אַחַת.",
            exampleNative = "פֶּדֶרַצְיָה включает пятьдесят штатов под единой конституцией.",
            fillInBlankExclusions = listOf(170716L, 170717L, 170720L),
        ),
        WordEntity(
            id = 170720, setId = 1707, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "politics_systems", transliteration = "mahapekha",
            original = "מַהְפֵּכָה", translation = "революция",
            definition = "שִׁנּוּי גָּדוֹל וּפָתְאוֹמִי שֶׁל הַשִּׁלְטוֹן אוֹ הַמִּשְׁטָר בִּמְדִינָה.",
            definitionNative = "Большая и резкая смена власти или режима в стране.",
            example = "אַחֲרֵי הַמַּהְפֵּכָה כָּל הָעֶרֶךְ הַפּוֹלִיטִי הִשְׁתַּנָּה.",
            exampleNative = "После מַהְפֵּכָה вся политическая система сменилась.",
            fillInBlankExclusions = listOf(170716L, 170719L),
        ),

        // — politics_society (5): COMMON מוֹלֶדֶת, לְאֹם, תּוֹשָׁב; UNCOMMON מִיעוּט, כְּהוּנָּה —
        WordEntity(
            id = 170721, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_society", transliteration = "moledet",
            original = "מוֹלֶדֶת", translation = "родина",
            definition = "הָאֶרֶץ שֶׁבָּהּ אָדָם נוֹלַד וּמַרְגִּישׁ קֶשֶׁר עָמֹק וְלֵאֻמִּי.",
            definitionNative = "Страна, где человек появился на свет и ощущает глубокую национальную связь.",
            example = "הוּא חָזַר לַמּוֹלֶדֶת אַחֲרֵי שָׁנִים בַּחוּץ לָאָרֶץ.",
            exampleNative = "Он вернулся на מוֹלֶדֶת после долгих лет за границей.",
            fillInBlankExclusions = listOf(170722L, 170723L),
        ),
        WordEntity(
            id = 170722, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_society", transliteration = "le'om",
            original = "לְאֹם", translation = "нация; народность",
            definition = "קְבוּצָה גְּדוֹלָה שֶׁל אֲנָשִׁים עִם שָׂפָה, הִיסְטוֹרְיָה וּתְרְבּוּת מְשֻׁתָּפוֹת.",
            definitionNative = "Большая группа людей с общим языком, историей и культурой.",
            example = "הַמְּדִינָה הִיא בַּיִת לְלְאֹם אֶחָד עִקָּרִי.",
            exampleNative = "Страна — дом для одного основного לְאֹם.",
            fillInBlankExclusions = listOf(170721L, 170723L),
        ),
        WordEntity(
            id = 170723, setId = 1707, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "politics_society", transliteration = "toshav",
            original = "תּוֹשָׁב", translation = "житель; резидент",
            definition = "אָדָם שֶׁגָּר בְּאוֹפֶן קָבוּעַ בִּמְדִינָה אוֹ בְּעִיר מְסֻיֶּמֶת.",
            definitionNative = "Тот, кто на постоянной основе живёт в государстве или конкретном городе.",
            example = "כָּל תּוֹשָׁב הָעִיר זַכַּאי לִשְׁתּוֹת מַיִם נְקִיִּים.",
            exampleNative = "Каждый תּוֹשָׁב города имеет право пить чистую воду.",
            fillInBlankExclusions = listOf(170721L, 170722L),
        ),
        WordEntity(
            id = 170724, setId = 1707, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "politics_society", transliteration = "miut",
            original = "מִיעוּט", translation = "меньшинство",
            definition = "קְבוּצָה קְטַנָּה יוֹתֵר שֶׁל אֲנָשִׁים בְּתוֹךְ אֻכְלוּסִיָּה גְּדוֹלָה יוֹתֵר.",
            definitionNative = "Меньшая группа людей внутри большего населения.",
            example = "הַחוֹק מַגִּין עַל זְכֻיּוֹת הַמִּיעוּט בְּכָל אֵזוֹר.",
            exampleNative = "Закон защищает права מִיעוּט в любом районе.",
            fillInBlankExclusions = listOf(170722L, 170725L),
        ),
        WordEntity(
            id = 170725, setId = 1707, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "politics_society", transliteration = "kehuna",
            original = "כְּהוּנָּה", translation = "срок полномочий; каденция",
            definition = "תְּקוּפָה רִשְׁמִית שֶׁבָּהּ נִבְחָר מְמַלֵּא תַּפְקִיד צִבּוּרִי לִפְנֵי בְּחִירוֹת חֲדָשׁוֹת.",
            definitionNative = "Официальный срок, в течение которого избранный занимает общественную должность до новых выборов.",
            example = "הַכְּהוּנָּה שֶׁל הַנָּשִׂיא נִמְשֶׁכֶת שֶׁבַע שָׁנִים.",
            exampleNative = "כְּהוּנָּה президента длится семь лет.",
            fillInBlankExclusions = listOf(170721L, 170724L),
        ),
    )
}
