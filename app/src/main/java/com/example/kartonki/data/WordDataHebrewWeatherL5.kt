package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — Погода и климат (L5, LEGENDARY+EPIC).
 *
 * Set 1821: «Погода и климат» — носитель/архаика.
 *           Танахические образы погоды, поэтика неба и сумерек,
 *           литературные и архаические описания стихий, продвинутая
 *           климатология (палеоклимат, биом, термоклин, пермафрост).
 *
 * Тема «Погода и климат» — продолжение L1 (1817), L2 (1818), L3 (1819).
 * L4 (1820) — соседний уровень (B2-C1), создаётся в той же волне.
 *
 * Все 25 слов проверены grep'ом по `original = "..."` против всех
 * he-ru сетов. В частности обойдены уже занятые в этой теме слова:
 *   - L2: עֲרָפֶל, אוֹבֶךְ, מַבּוּל, שִׁטָּפוֹן, עוֹפֶרֶת,
 *         טוֹרְנָדוֹ, מְעַרְבֹּלֶת, לוֹהֵט, הֶבֶל, לַהַט;
 *   - L3: צִיקְלוֹן, אַנְטִיצִיקְלוֹן, חֲזִית קָרָה,
 *         מַסַּת אֲוִיר, מַחֲנִיק, מְעִיק, סַגְרִירִי, מַבּוּלִי;
 *   - смежная тема "Природа" (1056): טַל, כְּפוֹר, אֵד, סְעָרָה.
 *
 * Распределение редкости: 18 LEGENDARY + 7 EPIC — два смежных уровня
 * C2+ (LEGENDARY доминирует) + C1 (EPIC).
 *
 * SemanticGroups (5 × 5):
 *   weather_l5_biblical          — Танахические образы погоды:
 *     בְּרֵאשִׁית-стиль (бездна, твердь небесная, ниспадение вод,
 *     роса небесная, четыре ветра)
 *   weather_l5_poetic_sky        — поэтика неба и сумерек:
 *     שַׁחַר/דִּמְדּוּמִים, рассвет/закат, сияние, заоблачные дали
 *   weather_l5_atmospheric_high  — высокая лексика атмосферы:
 *     слои атмосферы, аэрозоль, пары, разрежённость, дымка-морок
 *   weather_l5_climatology_advanced — продвинутая климатология:
 *     палеоклимат, антропогенный, биом, термоклин, пермафрост
 *   weather_l5_descriptive_literary — литературные эпитеты погоды:
 *     свирепый, исступлённый, безмолвный, иссушающий,
 *     оцепенелый/леденящий
 *
 * Word IDs: setId × 100 + position (182101..182125).
 *
 * fillInBlankExclusions / isFillInBlankSafe — НЕ задаются здесь.
 * Заполнятся через FILL_IN_BLANK pipeline централизованно после
 * полировки набора.
 */
object WordDataHebrewWeatherL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1821,
            languagePair = "he-ru",
            orderIndex = 1821,
            name = "Погода и климат",
            description = "Танахические образы, поэтика неба и архаичная погода",
            topic = "Погода и климат",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 1821 — Погода и климат: носитель/архаика (L5, LEG+EPIC)     ║
        // ║ 18 LEGENDARY + 7 EPIC, 5 групп × 5 слов                         ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── weather_l5_biblical (5) — Танахические образы ─────────────────

        WordEntity(
            id = 182101, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_biblical",
            original = "תְּהוֹם", translation = "бездна, водная пучина (Танах)",
            transliteration = "теhом",
            definition = "מַעֲמַקֵּי הַמַּיִם הָעַתִּיקִים שֶׁמְּדֻבָּר עֲלֵיהֶם בְּסִפּוּר הַבְּרִיאָה.",
            definitionNative = "Древние водные глубины, о которых говорится в рассказе о сотворении мира.",
            example = "סוּפַת הַחוֹרֶף נִרְאֲתָה כְּאִלּוּ הַתְּהוֹם פּוֹתַחַת אֶת פִּיהָ.",
            exampleNative = "Зимняя буря выглядела так, словно תְּהוֹם разверзается под нами.",
         fillInBlankExclusions = listOf(182102L, 182103L, 182104L, 182105L)),

        WordEntity(
            id = 182102, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_biblical",
            original = "רְקִיעַ", translation = "твердь небесная (Танах)",
            transliteration = "ракиа",
            definition = "מִשְׁטָח מוּצָק שֶׁבְּסֵפֶר בְּרֵאשִׁית מַפְרִיד בֵּין מַיִם עֶלְיוֹנִים לְתַחְתּוֹנִים.",
            definitionNative = "Твёрдый свод, который в Книге Бытия отделяет верхние воды от нижних.",
            example = "הַשִּׁירָה הַעַתִּיקָה דִּבְּרָה עַל גֶּשֶׁם הַיּוֹרֵד מִן הָרְקִיעַ.",
            exampleNative = "Древняя поэзия говорила о дожде, что нисходит с רְקִיעַ.",
        ),

        WordEntity(
            id = 182103, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_biblical",
            original = "אֲרֻבּוֹת הַשָּׁמַיִם", translation = "хляби небесные (Танах)",
            transliteration = "арубот hа-шамаим",
            definition = "פִּתְחֵי הַמָּרוֹם שֶׁמֵּהֶם, לְפִי סִפּוּר הַמַּבּוּל, נִשְׁפְּכוּ הַמַּיִם עַל הָאָרֶץ.",
            definitionNative = "Небесные затворы, из которых, по рассказу о потопе, излились воды на землю.",
            example = "כְּשֶׁיָּרַד הַמָּטָר אָמְרָה הַזְּקֵנָה שֶׁאֲרֻבּוֹת הַשָּׁמַיִם נִפְתְּחוּ.",
            exampleNative = "Когда хлынул ливень, старуха молвила: אֲרֻבּוֹת הַשָּׁמַיִם отверзлись.",
         fillInBlankExclusions = listOf(182101L, 182102L, 182104L, 182105L)),

        WordEntity(
            id = 182104, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_biblical",
            original = "טַל שָׁמַיִם", translation = "роса небесная (Танах)",
            transliteration = "таль шамаим",
            definition = "טִפּוֹת הַלַּיְלָה הַנּוֹפְלוֹת מִמְּרוֹמִים — סֵמֶל בְּרָכָה בַּמִּקְרָא וּבַתְּפִלּוֹת.",
            definitionNative = "Ночные капли, ниспадающие свыше — символ благословения в Писании и молитвах.",
            example = "הַמְּשׁוֹרֵר בִּקֵּשׁ שֶׁיֵּרֵד טַל שָׁמַיִם עַל אֲדָמַת אֲבוֹתָיו.",
            exampleNative = "Поэт молил, чтобы טַל שָׁמַיִם сошла на землю отцов.",
         fillInBlankExclusions = listOf(182101L, 182102L, 182103L, 182105L, 182110L)),

        WordEntity(
            id = 182105, setId = 1821, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l5_biblical",
            original = "אַרְבַּע רוּחוֹת", translation = "четыре ветра (стороны света, поэт.)",
            transliteration = "арба рухот",
            definition = "כִּנּוּי תַּנָּ\"כִי לְכִוּוּנֵי הָעוֹלָם — מִזְרָח, מַעֲרָב, צָפוֹן וְדָרוֹם יַחַד.",
            definitionNative = "Танахическое обозначение сторон света — восток, запад, север и юг разом.",
            example = "הַנָּבִיא קָרָא לִקְבֹּץ אֶת הָעָם מֵאַרְבַּע רוּחוֹת הָעוֹלָם.",
            exampleNative = "Пророк взывал собрать народ от אַרְבַּע רוּחוֹת этого мира.",
         fillInBlankExclusions = listOf(182101L, 182102L, 182103L, 182104L)),

        // ── weather_l5_poetic_sky (5) — поэтика неба и сумерек ────────────

        WordEntity(
            id = 182106, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_poetic_sky",
            original = "שַׁחַר", translation = "заря, рассветный час (поэт.)",
            transliteration = "шахар",
            definition = "הָאוֹר הָרִאשׁוֹן שֶׁמּוֹפִיעַ בְּמִזְרָח לִפְנֵי שֶׁהַשֶּׁמֶשׁ עוֹלָה — מִלָּה שִׁירִית.",
            definitionNative = "Первый свет, что появляется на востоке прежде восхода солнца — поэтичное слово.",
            example = "כּוֹכְבֵי הַשַּׁחַר נִדְלְקוּ עַל הַשָּׁמַיִם הַצְּלוּלִים.",
            exampleNative = "Звёзды שַׁחַר разгорелись на прозрачном предутреннем небе.",
        ),

        WordEntity(
            id = 182107, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_poetic_sky",
            original = "דִּמְדּוּמִים", translation = "сумерки (книжн./поэт.)",
            transliteration = "димдумим",
            definition = "אוֹר חַלָּשׁ וּמְהֻסֶּה שֶׁל זְמַן הַמַּעֲבָר בֵּין יוֹם לְלַיְלָה אוֹ לְהֶפֶךְ.",
            definitionNative = "Тусклый затаённый свет в час перехода между днём и ночью или наоборот.",
            example = "בְּדִמְדּוּמֵי הָעֶרֶב הַנְּחָלִים נִרְאוּ כִּפְסֵי כֶּסֶף.",
            exampleNative = "В вечерних דִּמְדּוּמִים ручьи казались серебряными лентами.",
        ),

        WordEntity(
            id = 182108, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_poetic_sky",
            original = "זִיו", translation = "сияние, светлый блеск (поэт.)",
            transliteration = "зив",
            definition = "אוֹר רַךְ וּמַזְהִיר הַנּוֹפֵל מִלְמַעְלָה עַל פְּנֵי הַטֶּבַע — בְּעִקָּר בַּשִּׁירָה.",
            definitionNative = "Мягкое лучистое свечение, что нисходит сверху на природу — главным образом в поэзии.",
            example = "זִיו הַחַמָּה הִכְהָה אֶת הַצְּבָעִים שֶׁל הַשָּׂדוֹת.",
            exampleNative = "זִיו солнца приглушил все краски полей.",
         fillInBlankExclusions = listOf(182106L, 182107L, 182109L, 182110L)),

        WordEntity(
            id = 182109, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_poetic_sky",
            original = "מְרוֹמִים", translation = "горние дали, выси небесные (поэт.)",
            transliteration = "меромим",
            definition = "פִּסְגוֹת הַשָּׁמַיִם הָרְחוֹקוֹת — בִּטּוּי שִׁירִי לַמֶּרְחָב הַגָּבוֹהַּ מֵעַל הָעֲנָנִים.",
            definitionNative = "Далёкие вершины небес — поэтическое выражение для пространства над облаками.",
            example = "הָעַיִט שָׁט בַּמְּרוֹמִים מֵעַל הַמִּדְבָּר הֵרֵם.",
            exampleNative = "Орёл парил в מְרוֹמִים над безмолвной пустыней.",
        ),

        WordEntity(
            id = 182110, setId = 1821, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l5_poetic_sky",
            original = "אֹפֶל", translation = "мрак, кромешная тьма (книжн.)",
            transliteration = "офель",
            definition = "חֹשֶׁךְ עָבֶה וּמַעֲבִיר תְּחוּשַׁת אֵימָה — בְּעִקָּר לִפְנֵי סוּפָה אוֹ בְּלַיְלָה חַסַר יָרֵחַ.",
            definitionNative = "Густая жуткая тьма — особенно перед бурей или в безлунную ночь.",
            example = "אֹפֶל יָרַד עַל הַעֵמֶק לִפְנֵי הָרַעַם הָרִאשׁוֹן.",
            exampleNative = "אֹפֶל опустился на долину прежде первого раската грома.",
         fillInBlankExclusions = listOf(182104L, 182106L, 182107L, 182108L, 182109L)),

        // ── weather_l5_atmospheric_high (5) — высокая лексика атмосферы ──

        WordEntity(
            id = 182111, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_atmospheric_high",
            original = "טְרוֹפּוֹסְפֵרָה", translation = "тропосфера",
            transliteration = "тропосфэра",
            definition = "הַשִּׁכְבָה הַתַּחְתִּית שֶׁל הָאַטְמוֹסְפֵרָה שֶׁבָּהּ מִתְרַחֲשִׁים רֹב מְזָגֵי הָאֲוִיר.",
            definitionNative = "Нижний слой атмосферы, в котором происходит большинство погодных явлений.",
            example = "מַסּוֹת אֲוִיר נִפְגָּשׁוֹת בַּטְרוֹפּוֹסְפֵרָה וְיוֹצְרוֹת חֲזִיתוֹת.",
            exampleNative = "Воздушные массы встречаются в טְרוֹפּוֹסְפֵרָה и образуют атмосферные фронты.",
         fillInBlankExclusions = listOf(182112L, 182113L, 182114L, 182115L)),

        WordEntity(
            id = 182112, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_atmospheric_high",
            original = "סְטְרָטוֹסְפֵרָה", translation = "стратосфера",
            transliteration = "стратосфэра",
            definition = "שִׁכְבָה גְּבוֹהָה שֶׁמֵּעַל הַטְרוֹפּוֹסְפֵרָה — שָׁם נִמְצֵאת שִׁכְבַת הָאוֹזוֹן.",
            definitionNative = "Высокий слой над тропосферой — там расположен озоновый слой.",
            example = "מְטוֹסֵי סִיּוּר טָסִים בַּסְטְרָטוֹסְפֵרָה רָחוֹק מֵעַל הַעֲנָנִים.",
            exampleNative = "Разведывательные самолёты летают в סְטְרָטוֹסְפֵרָה далеко над тучами.",
         fillInBlankExclusions = listOf(182111L, 182113L, 182114L, 182115L)),

        WordEntity(
            id = 182113, setId = 1821, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l5_atmospheric_high",
            original = "אֵרוֹסוֹל", translation = "аэрозоль (взвесь в воздухе)",
            transliteration = "эросоль",
            definition = "תַּעֲרֹבֶת שֶׁל חֶלְקִיקִים זְעִירִים מוּצָקִים אוֹ נוֹזְלִיִּים הַתְּלוּיִים בָּאֲוִיר.",
            definitionNative = "Смесь мельчайших твёрдых или жидких частиц, что висят в воздухе.",
            example = "פְּלִיטוֹת תַּעֲשִׂיָּה מַעֲלוֹת רִכּוּז שֶׁל אֵרוֹסוֹל בָּעִיר.",
            exampleNative = "Промышленные выбросы повышают концентрацию אֵרוֹסוֹל в городском воздухе.",
         fillInBlankExclusions = listOf(182111L, 182112L, 182114L, 182115L)),

        WordEntity(
            id = 182114, setId = 1821, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l5_atmospheric_high",
            original = "אֵדֵי מַיִם", translation = "водяные пары (научн.)",
            transliteration = "эдэй маим",
            definition = "מַיִם בְּמַצָּב גָּזִי הַמְּפֻזָּרִים בָּאֲוִיר וְקוֹבְעִים אֶת רָמַת הַלַּחוּת.",
            definitionNative = "Вода в газообразном состоянии, рассеянная в воздухе и определяющая уровень влажности.",
            example = "כַּמּוּת אֵדֵי מַיִם בָּאֲוִיר עוֹלָה לִפְנֵי הִתְעַבּוּת הָעֲנָנִים.",
            exampleNative = "Количество אֵדֵי מַיִם в воздухе растёт перед конденсацией облаков.",
         fillInBlankExclusions = listOf(182111L, 182112L, 182113L, 182115L)),

        WordEntity(
            id = 182115, setId = 1821, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l5_atmospheric_high",
            original = "דְּלִילוּת אֲוִיר", translation = "разрежённость воздуха (выс. лексика)",
            transliteration = "длилут авир",
            definition = "מַצָּב שֶׁבּוֹ מִסְפַּר חֶלְקִיקֵי הָאֲוִיר בִּיחִידַת נֶפַח קָטָן — בְּעִקָּר בְּגַבְהֵי הַרִים.",
            definitionNative = "Состояние, при котором плотность частиц воздуха в единице объёма мала — характерно для горных высот.",
            example = "דְּלִילוּת אֲוִיר בַּפִּסְגָּה הִקְשְׁתָה עַל הַמְטַיְּלִים לִנְשֹׁם.",
            exampleNative = "דְּלִילוּת אֲוִיר на вершине затрудняла туристам дыхание.",
         fillInBlankExclusions = listOf(182111L, 182112L, 182113L, 182114L)),

        // ── weather_l5_climatology_advanced (5) — продвинутая климатология ─

        WordEntity(
            id = 182116, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_climatology_advanced",
            original = "פָּלֵאוֹאַקְלִים", translation = "палеоклимат",
            transliteration = "палэоаклим",
            definition = "אַקְלִים שֶׁל תְּקוּפוֹת גֵּאוֹלוֹגִיּוֹת קְדוּמוֹת שֶׁמְּשַׁחְזְרִים מִקַּרְחוֹנִים וּמִשְּׁכָבוֹת סֶלַע.",
            definitionNative = "Климат древних геологических эпох, который восстанавливают по льдам и осадочным породам.",
            example = "חוֹקְרִים מְשַׁחְזְרִים אֶת הַפָּלֵאוֹאַקְלִים מִקַּרְחוֹנֵי גְּרֵינְלַנְד.",
            exampleNative = "Учёные восстанавливают פָּלֵאוֹאַקְלִים по ледникам Гренландии.",
         fillInBlankExclusions = listOf(182118L, 182119L, 182120L)),

        WordEntity(
            id = 182117, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "weather_l5_climatology_advanced",
            original = "אַנְתְרוֹפּוֹגֶנִי", translation = "антропогенный",
            transliteration = "антропогени",
            definition = "שֶׁמְּקוֹרוֹ בִּפְעִילוּת בְּנֵי אָדָם — בְּעִקָּר עַל שִׁנּוּיֵי אַקְלִים וְזִהוּם.",
            definitionNative = "Имеющий причиной человеческую деятельность — особенно в контексте изменения климата и загрязнения.",
            example = "הָאוֹתוֹת הָאַנְתְרוֹפּוֹגֶנִיִּים שֶׁל הַהִתְחַמְּמוּת מֻכָּרִים בְּמָאוֹת מַחְקָרִים.",
            exampleNative = "אַנְתְרוֹפּוֹגֶנִי след глобального потепления зафиксирован в сотнях исследований.",
        ),

        WordEntity(
            id = 182118, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_climatology_advanced",
            original = "בִּיוֹם", translation = "биом (крупная экосистема)",
            transliteration = "биом",
            definition = "אֵזוֹר רָחָב בְּכַדּוּר הָאָרֶץ עִם אַקְלִים וְצִמְחִיָּה אָפְיָנִית — כְּמוֹ סָוַנָּה אוֹ טַיְגָה.",
            definitionNative = "Обширная зона на Земле с характерным климатом и растительностью — например, саванна или тайга.",
            example = "הַבִּיוֹם שֶׁל הַטַּיְגָה מְכַסֶּה אֶת רֹב הַחֵלֶק הַצָּפוֹנִי שֶׁל סִיבִּיר.",
            exampleNative = "בִּיוֹם тайги покрывает большую часть северной Сибири.",
         fillInBlankExclusions = listOf(182116L, 182119L, 182120L)),

        WordEntity(
            id = 182119, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "weather_l5_climatology_advanced",
            original = "תֶּרְמוֹקְלִין", translation = "термоклин (слой резкого перепада температуры)",
            transliteration = "термоклин",
            definition = "שִׁכְבָה שֶׁל מַיִם בָּאוֹקְיָנוֹס שֶׁבָּהּ הַטֶּמְפֶּרָטוּרָה צוֹנַחַת בִּמְהִירוּת עִם הָעֹמֶק.",
            definitionNative = "Слой океанической воды, в котором температура резко падает с увеличением глубины.",
            example = "הַתֶּרְמוֹקְלִין מַשְׁפִּיעַ עַל זְרָמִים יָמִיִּים וְעַל אַקְלִים מָקוֹמִי.",
            exampleNative = "תֶּרְמוֹקְלִין влияет на морские течения и местный климат.",
         fillInBlankExclusions = listOf(182116L, 182118L, 182120L)),

        WordEntity(
            id = 182120, setId = 1821, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "weather_l5_climatology_advanced",
            original = "קַרְקַע קֶפֶא", translation = "вечная мерзлота, пермафрост",
            transliteration = "карка кэфэ",
            definition = "אֲדָמָה שֶׁנִּשְׁאֶרֶת קְפוּאָה לְעֹמֶק רַב לְאֹרֶךְ שָׁנִים אַחְרֵי שָׁנִים בְּקָטְבֵי כַּדּוּר הָאָרֶץ.",
            definitionNative = "Грунт, что остаётся промёрзшим на большую глубину годами и десятилетиями в полярных областях планеты.",
            example = "הַפְשָׁרַת קַרְקַע קֶפֶא מְשַׁחְרֶרֶת מֵתָאן לָאֲוִיר.",
            exampleNative = "Таяние קַרְקַע קֶפֶא высвобождает метан в атмосферу.",
         fillInBlankExclusions = listOf(182116L, 182118L, 182119L)),

        // ── weather_l5_descriptive_literary (5) — литературные эпитеты ───

        WordEntity(
            id = 182121, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "weather_l5_descriptive_literary",
            original = "זוֹעֵף", translation = "свирепый, неистовый (о буре)",
            transliteration = "зоэф",
            definition = "מַתְקִיף בְּכֹחַ אַכְזָרִי וְלֹא מְרֻסָּן — לָרֹב עַל סוּפָה אוֹ עַל יָם.",
            definitionNative = "Тот, что обрушивается с лютой силой без удержу — обычно о буре или о море.",
            example = "יָם זוֹעֵף הִכְרִיחַ אֶת הַסְּפִינוֹת לַחֲזֹר אֶל הַנָּמָל.",
            exampleNative = "זוֹעֵף море заставило корабли вернуться в порт.",
         fillInBlankExclusions = listOf(182122L, 182123L, 182124L, 182125L)),

        WordEntity(
            id = 182122, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "weather_l5_descriptive_literary",
            original = "מְשֻׁלְהָב", translation = "исступлённый, разъярённый (о стихии)",
            transliteration = "мешульhав",
            definition = "כְּשֶׁכֹּחַ הַטֶּבַע נִדְלָק לְעֵרָנוּת קִיצוֹנִית — רוּחוֹת מְיַלְּלוֹת וְגַלִּים שׁוֹבְרִים כֹּל.",
            definitionNative = "Когда сила природы воспаляется до крайности — ветры воют, а волны крушат всё.",
            example = "סוּפָה מְשֻׁלְהֶבֶת תָּקְפָה אֶת חוֹף הַיָּם וְהִשְׁאִירָה הֲרֵסוּת.",
            exampleNative = "מְשֻׁלְהֶבֶת буря обрушилась на побережье и оставила руины.",
        ),

        WordEntity(
            id = 182123, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "weather_l5_descriptive_literary",
            original = "דּוֹמֵם", translation = "безмолвный, оцепенелый (о тумане, штиле)",
            transliteration = "домэм",
            definition = "שָׁקֵט לְלֹא קוֹל וּלְלֹא תְּנוּעָה — לָרֹב עַל עֲרָפֶל סָמִיךְ אוֹ עַל מַיִם נָחִים.",
            definitionNative = "Тихий без звука и без движения — обычно о густом тумане или замершей воде.",
            example = "עֲרָפֶל דּוֹמֵם כִּסָּה אֶת הָעֵמֶק לִפְנֵי הַזְּרִיחָה.",
            exampleNative = "דּוֹמֵם туман укрыл долину перед самым восходом.",
         fillInBlankExclusions = listOf(182121L, 182122L, 182124L, 182125L)),

        WordEntity(
            id = 182124, setId = 1821, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "weather_l5_descriptive_literary",
            original = "מְצַמֵּת", translation = "иссушающий, испепеляющий (о зное)",
            transliteration = "мецамэт",
            definition = "שֶׁמַּחֲרִיב כָּל לַחוּת וְכָל חַיִּים בְּמַגַּע אַחַד — עַל חֹם מִדְבָּרִי קִיצוֹנִי.",
            definitionNative = "Тот, что одним прикосновением губит всякую влагу и всякую жизнь — об экстремальном пустынном зное.",
            example = "חֹם מְצַמֵּת רִחֵף מֵעַל הַמִּדְבָּר וְשָׂרַף אֶת הַשִּׂיחִים.",
            exampleNative = "מְצַמֵּת зной висел над пустыней и выжигал кустарник дотла.",
         fillInBlankExclusions = listOf(182121L, 182122L, 182123L, 182125L)),

        WordEntity(
            id = 182125, setId = 1821, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "weather_l5_descriptive_literary",
            original = "מְצַמְרֵר", translation = "леденящий, пробирающий (о холоде)",
            transliteration = "мецамрэр",
            definition = "שֶׁמַּעֲבִיר רֶטֶט בָּעוֹר וְחוֹדֵר אֶל הָעֲצָמוֹת — עַל קֹר חַד אוֹ עַל רוּחַ פִּתְאוֹמִית.",
            definitionNative = "Тот, что прокатывает дрожь по коже и проникает до самых костей — о резком холоде или внезапном ветре.",
            example = "רוּחַ מְצַמְרֶרֶת נָשְׁבָה מִן הַיָּם וְהִקְפִּיאָה אֶת הָאֶצְבָּעוֹת.",
            exampleNative = "מְצַמְרֶרֶת ветер с моря заморозил пальцы в один миг.",
        ),
    )
}
