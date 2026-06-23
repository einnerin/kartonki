package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1911 (he-ru).
 * Лингвистика: морфология иврита — корни, биньянимы, мишкали (L3 / RARE + EPIC).
 *
 * Уникальный для he-ru ракурс: словарь морфологии семитского языка, который
 * нужен изучающим иврит на уровне выше базового. НЕ общая теория языка,
 * НЕ фонология/семантика/дискурс — конкретно система биньянимов, корней,
 * именных моделей и слабых корней.
 *
 * Существующие лингвистические сеты на he-ru:
 *   - Batch24, Batch43 — общая лингвистика (фонема, морфема, билингвизм)
 *   - Batch48, Batch87 (set 1533) — фонетика, морфология, прагматика (L2)
 *   - Immigrant10/11/15/16 — терминология для изучающих иврит
 *
 * Исключены 8 кандидатов из-за дублей в лингвистическом контексте:
 *   - שֹׁרֶשׁ (корень слова) — set 1533 + Immigrant16
 *   - מִשְׁקָל (модель / биньян) — set 1533
 *   - הַטָּיָה (спряжение / склонение) — set 1533
 *   - גִּזְרָה (омоним — крой в Batch49) — set 1272; чтобы не плодить
 *     омонимы original'а, исключено
 *   - שֵׁם פְּעוּלָה (отглагольное существительное) — set 1533
 *   - בִּנְיָן (как часть речи — омоним «здание» в Architecture/Immigrant)
 *   - עָבָר / זְמַן עָבָר — set 1533 (זְמַן עָבָר)
 *   - עָתִיד / זְמַן עָתִיד — set 1533 (זְמַן עָתִיד)
 *
 * Заменители подобраны точечно под морфологический фокус:
 *   - В basics вместо шореш/мишкаль/гизра/hатая взяты префикс,
 *     суффикс, аффикс и частица — структурные единицы морфологии.
 *   - В tenses вместо עָבָר/עָתִיד основная нагрузка на формы:
 *     инфинитив (שֵׁם הַפֹּעַל), причастие (בֵּינוֹנִי), повелит.,
 *     настоящее. Прошедшее / будущее в Batch87 уже покрыты.
 *   - В models вместо שֵׁם פְּעוּלָה — местоимение и наречие
 *     как замыкающие части речи морфологии.
 *
 * Распределение редкости (validate_rarity_spread: 2 смежных уровня):
 *   RARE — 12 слов (B2): часто употребимая морфологическая
 *     лексика, изучается в школьном дикдуке и базовом ульпан-Бет.
 *   EPIC — 13 слов (C1): продвинутая академическая терминология
 *     (биньянимы-пассивы, weak roots, абстрактные модели имени).
 *
 * Пять семантических подгрупп (validate_group_sizes):
 *   lang_morph_basics — 5 слов: спряжение, приставка, суффикс,
 *     аффикс, частица (структурные единицы морфологии)
 *   lang_morph_binyanim — 7 слов: семь биньянимов (פָּעַל-הִתְפַּעֵל)
 *   lang_morph_tenses — 4 слова: настоящее, повелит., инфинитив, причастие
 *   lang_morph_weak_roots — 4 слова: целые + три типа слабых корней
 *   lang_morph_models — 5 слов: прилагательное, абстракт. сущ.,
 *     смихут, наречие, личное местоимение
 *
 * Word IDs: 191101..191125 (setId × 100 + position).
 */
object WordDataHebrewLinguisticsBinyanim {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1911, languagePair = "he-ru", orderIndex = 1911,
            name = "Лингвистика",
            description = "Морфология иврита: биньянимы פָּעַל-הִתְפַּעֵל, נָחֵי פ\"א, צוּרַת סְמִיכוּת, שֵׁם מוּפְשָׁט.",
            topic = "Лингвистика",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: lang_morph_basics (5 words) ────────────────────────────────

        WordEntity(id = 191101, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "נְטִיָּה",
            translation = "спряжение (глагола в иврите)",
            definition = "צוּרוֹת הַפֹּעַל לְפִי גּוּף, מִין, מִסְפָּר וּזְמַן בְּתוֹךְ אוֹתוֹ בִּנְיָן: כָּתַבְתִּי, כָּתַבְתָּ, כָּתְבָה.",
            definitionNative = "Формы глагола по лицу, роду, числу и времени в одной породе: כָּתַבְתִּי, כָּתַבְתָּ, כָּתְבָה.",
            example = "הַתַּלְמִיד שִׁנֵּן אֶת הַנְּטִיָּה הַשְּׁלֵמָה שֶׁל הַפֹּעַל.",
            exampleNative = "Ученик зазубрил полную נְטִיָּה этого глагола.",
            pos = "noun", semanticGroup = "lang_morph_basics"),

        WordEntity(id = 191102, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "תְּחִילִּית",
            translation = "приставка / префикс",
            definition = "אוֹת אוֹ מוֹסָף שֶׁמִּתְחַבֵּר לִתְחִילַּת מִילָּה וּמְשַׁנֶּה אֶת מַשְׁמָעוּתָהּ, לְמָשָׁל ה' הַיְדִיעָה.",
            definitionNative = "Буква или аффикс, что присоединяется к началу слова и меняет смысл, например ה' определённости.",
            example = "הַתְּחִילִּית מ' מַצְבִּיעָה לְעִתִּים עַל שֵׁם פְּעוּלָה.",
            exampleNative = "תְּחִילִּית מ' часто указывает на отглагольное существительное.",
            pos = "noun", semanticGroup = "lang_morph_basics", fillInBlankExclusions = listOf(191101L, 191103L, 191104L, 191105L)),

        WordEntity(id = 191103, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "סִיוֹמֶת",
            translation = "суффикс / окончание",
            definition = "מוֹסָף שֶׁנֶּצְמָד לְסוֹף הַמִּילָּה וּמְסַמֵּן גּוּף, מִין, מִסְפַּר אוֹ קִנְיָן.",
            definitionNative = "Аффикс, что добавляется к концу слова и обозначает лицо, род, число или принадлежность.",
            example = "הַסִּיוֹמֶת -וֹת מְצַיֶּנֶת רַבּוֹת בִּשְׁמוֹת עֶצֶם נְקֵבָה.",
            exampleNative = "סִיוֹמֶת -וֹת обозначает множественное число женского рода у существительных.",
            pos = "noun", semanticGroup = "lang_morph_basics"),

        WordEntity(id = 191104, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "מוּסָפִית",
            translation = "аффикс (общий термин)",
            definition = "מוֹרְפֵמָה צְמוּדָה שֶׁמִּתְחַבֶּרֶת לַשֹּׁרֶשׁ אוֹ לַמִּילָּה — תְּחִילִּית, תּוֹכִית אוֹ סִיוֹמֶת.",
            definitionNative = "Связанная морфема, что присоединяется к корню или слову — префикс, инфикс или суффикс.",
            example = "כָּל מוּסָפִית בַּמִּילָּה תּוֹרֶמֶת מַשְׁמָעוּת דִּקְדּוּקִית קוֹנְקְרֶטִית.",
            exampleNative = "Каждый מוּסָפִית в слове вносит конкретный грамматический смысл.",
            pos = "noun", semanticGroup = "lang_morph_basics", fillInBlankExclusions = listOf(191101L, 191102L, 191103L, 191105L)),

        WordEntity(id = 191105, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "מִילִּית",
            translation = "частица (служебное слово)",
            definition = "מִילָּה קְצָרָה לְלֹא נְטִיָּה שֶׁמְּשָׁרֶתֶת תַּפְקִיד דִּקְדּוּקִי, כְּגוֹן אֶת, גַּם, רַק.",
            definitionNative = "Короткое неизменяемое слово, что выполняет грамматическую функцию, например אֶת, גַּם, רַק.",
            example = "הַמִּילִּית אֶת מְסַמֶּנֶת מֻשָּׂא יָשִׁיר מְיֻדָּע.",
            exampleNative = "מִילִּית אֶת маркирует определённое прямое дополнение.",
            pos = "noun", semanticGroup = "lang_morph_basics"),

        // ── Group: lang_morph_binyanim (7 words) ──────────────────────────────

        WordEntity(id = 191106, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "פָּעַל",
            translation = "пааль (קַל — простая активная порода)",
            definition = "בִּנְיָן בָּסִיסִי שֶׁמַּבִּיעַ פְּעֻלָּה פְּשׁוּטָה: כַּתָּב, אָמַר, רָץ.",
            definitionNative = "Базовая порода, что выражает простое действие: כָּתַב, אָמַר, רָץ.",
            example = "רוֹב פְּעָלִים שִׁמּוּשִׁיִּים בָּעִבְרִית שַׁיָּכִים לְבִנְיַן פָּעַל.",
            exampleNative = "Большинство ходовых глаголов иврита относятся к породе פָּעַל.",
            pos = "noun", semanticGroup = "lang_morph_binyanim", fillInBlankExclusions = listOf(191108L, 191110L)),

        WordEntity(id = 191107, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "נִפְעַל",
            translation = "нифъаль (пассив / возвратный от пааль)",
            definition = "בִּנְיָן שֶׁמַּבִּיעַ סָבִיל אוֹ פְּעֻלָּה חוֹזֶרֶת מוּל פָּעַל: נִכְתַּב, נִפְגַּשׁ.",
            definitionNative = "Порода, что выражает пассив или возвратность от פָּעַל: נִכְתַּב, נִפְגַּשׁ.",
            example = "הַסֵּפֶר נִכְתַּב בְּבִנְיַן נִפְעַל — צוּרָה סְבִילָה.",
            exampleNative = "Этот глагол стоит в בִּנְיַן נִפְעַל — страдательная форма.",
            pos = "noun", semanticGroup = "lang_morph_binyanim", fillInBlankExclusions = listOf(191109L, 191111L)),

        WordEntity(id = 191108, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "פִּעֵל",
            translation = "пиэль (интенсивная активная порода)",
            definition = "בִּנְיָן שֶׁמַּחֲזֵק אוֹ מְשַׁנֶּה אֶת מַשְׁמָעוּת הַשֹּׁרֶשׁ: דִּבֵּר, לִמֵּד, סִפֵּר.",
            definitionNative = "Порода, что усиливает или меняет смысл корня: דִּבֵּר, לִמֵּד, סִפֵּר.",
            example = "בִּנְיַן פִּעֵל מַתְאִים לִפְעֻלּוֹת אִינְטֶנְסִיבִיּוֹת אוֹ חֲזָרָתִיּוֹת.",
            exampleNative = "Порода פִּעֵל подходит для интенсивных или многократных действий.",
            pos = "noun", semanticGroup = "lang_morph_binyanim", fillInBlankExclusions = listOf(191106L, 191110L)),

        WordEntity(id = 191109, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "פֻּעַל",
            translation = "пуаль (пассив от пиэль)",
            definition = "בִּנְיָן סָבִיל הַמַּקְבִּיל לְפִעֵל: דֻּבַּר, לֻמַּד, סֻפַּר — בְּעִקָּר בִּלְשׁוֹן הַסִּפְרוּת.",
            definitionNative = "Страдательная порода-пара к активному биньяну: דֻּבַּר, לֻמַּד, סֻפַּר — преимущественно в литературном языке.",
            example = "צוּרוֹת בִּנְיָן פֻּעַל נְדִירוֹת בְּעִבְרִית מְדֻבֶּרֶת.",
            exampleNative = "Формы בִּנְיַן פֻּעַל редки в разговорном иврите.",
            pos = "noun", semanticGroup = "lang_morph_binyanim", fillInBlankExclusions = listOf(191107L, 191111L)),

        WordEntity(id = 191110, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "הִפְעִיל",
            translation = "hифъиль (каузативная активная порода)",
            definition = "בִּנְיָן שֶׁמַּבִּיעַ גְּרִימָה — לִגְרֹם לְמִישֶׁהוּ לַעֲשׂוֹת: הִכְתִּיב, הִרְקִיד, הִכְנִיס.",
            definitionNative = "Порода, что выражает каузатив — заставить кого-то сделать: הִכְתִּיב, הִרְקִיד, הִכְנִיס.",
            example = "הַמּוֹרָה הִשְׁתַּמְּשָׁה בְּבִנְיַן הִפְעִיל כְּדֵי לְהַסְבִּיר אֶת הַגְּרִימָה.",
            exampleNative = "Учительница использовала בִּנְיַן הִפְעִיל, чтобы объяснить каузатив.",
            pos = "noun", semanticGroup = "lang_morph_binyanim", fillInBlankExclusions = listOf(191106L, 191108L)),

        WordEntity(id = 191111, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "הֻפְעַל",
            translation = "hуфъаль (пассив от hифъиль)",
            definition = "בִּנְיָן סָבִיל הַמַּקְבִּיל לְהִפְעִיל: הֻכְתַּב, הֻרְקַד, הֻכְנַס.",
            definitionNative = "Страдательная порода-пара к הִפְעִיל: הֻכְתַּב, הֻרְקַד, הֻכְנַס.",
            example = "הַתַּלְמִיד הִתְבַּלְבֵּל בֵּין הֻפְעַל לְפֻעַל בַּמִּבְחָן.",
            exampleNative = "Ученик перепутал הֻפְעַל с פֻּעַל на контрольной.",
            pos = "noun", semanticGroup = "lang_morph_binyanim", fillInBlankExclusions = listOf(191107L, 191109L)),

        WordEntity(id = 191112, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "הִתְפַּעֵל",
            translation = "hитпаэль (возвратная интенсивная порода)",
            definition = "בִּנְיָן שֶׁמַּבִּיעַ פְּעֻלָּה חוֹזֶרֶת עַל עַצְמוֹ: הִתְלַבֵּשׁ, הִתְקַלֵּחַ, הִתְפַּלֵּל.",
            definitionNative = "Порода, что выражает действие, направленное на себя: הִתְלַבֵּשׁ, הִתְקַלֵּחַ, הִתְפַּלֵּל.",
            example = "בִּנְיָן הִתְפַּעֵל נָפוֹץ בִּפְעֻלּוֹת שֶׁל טִיפּוּל אִישִׁי.",
            exampleNative = "בִּנְיַן הִתְפַּעֵל част в глаголах ухода за собой.",
            pos = "noun", semanticGroup = "lang_morph_binyanim", fillInBlankExclusions = listOf(191106L, 191107L, 191108L, 191109L, 191110L, 191111L)),

        // ── Group: lang_morph_tenses (4 words) ────────────────────────────────

        WordEntity(id = 191113, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "הוֹוֶה",
            translation = "настоящее время",
            definition = "צוּרַת פֹּעַל הַמַּבִּיעָה פְּעֻלָּה בִּזְמַן הַדִּבּוּר, וְזֵהָה לְצוּרַת הַבֵּינוֹנִי.",
            definitionNative = "Форма глагола, что выражает действие в момент речи, совпадает с причастием.",
            example = "בְּעִבְרִית צוּרַת הַהוֹוֶה מְשַׁמֶּשֶׁת גַּם כְּשֵׁם תֹּאַר.",
            exampleNative = "В иврите форма הוֹוֶה служит и как причастие, и как прилагательное.",
            pos = "noun", semanticGroup = "lang_morph_tenses", fillInBlankExclusions = listOf(191114L, 191116L)),

        WordEntity(id = 191114, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "צִוּוּי",
            translation = "повелительное наклонение",
            definition = "צוּרַת פֹּעַל הַמַּבִּיעָה פְּקֻדָּה אוֹ בַּקָּשָׁה: כְּתֹב, שֵׁב, לֵךְ.",
            definitionNative = "Форма глагола, что выражает приказ или просьбу: כְּתֹב, שֵׁב, לֵךְ.",
            example = "בִּלְשׁוֹן הַדִּבּוּר הַצִּוּוּי מוּחְלָף לְעִתִּים בְּעָתִיד.",
            exampleNative = "В разговорной речи צִוּוּי часто заменяется будущим временем.",
            pos = "noun", semanticGroup = "lang_morph_tenses"),

        WordEntity(id = 191115, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "שֵׁם הַפֹּעַל",
            translation = "инфинитив (неопределённая форма)",
            definition = "צוּרַת הַמָּקוֹר שֶׁל הַפֹּעַל הַמַּתְחִילָה בִּ-לְ: לִכְתֹּב, לְדַבֵּר, לְהַסְבִּיר.",
            definitionNative = "Исходная форма глагола, что начинается с לְ-: לִכְתֹּב, לְדַבֵּר, לְהַסְבִּיר.",
            example = "שֵׁם הַפֹּעַל בָּא לְרֹב אַחֲרֵי פֹּעַל מוֹדָאלִי כְּמוֹ ״רוֹצֶה״.",
            exampleNative = "שֵׁם הַפֹּעַל обычно идёт после модального глагола вроде «хочу».",
            pos = "phrase", semanticGroup = "lang_morph_tenses"),

        WordEntity(id = 191116, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "בֵּינוֹנִי",
            translation = "причастие (форма наст. времени)",
            definition = "צוּרַת פֹּעַל שֶׁמְּתָאֶרֶת פּוֹעֵל הַפְּעֻלָּה וּמְשַׁמֶּשֶׁת גַּם לְהוֹוֶה: כּוֹתֵב, מְדַבֵּר.",
            definitionNative = "Форма глагола, что описывает деятеля и служит настоящим временем: כּוֹתֵב, מְדַבֵּר.",
            example = "הַבֵּינוֹנִי בָּעִבְרִית נוֹטֶה לְמִין, לְמִסְפָּר וּלְזִכָּרוֹן.",
            exampleNative = "בֵּינוֹנִי в иврите изменяется по роду и числу.",
            pos = "noun", semanticGroup = "lang_morph_tenses", fillInBlankExclusions = listOf(191113L, 191114L)),

        // ── Group: lang_morph_weak_roots (4 words) ────────────────────────────

        WordEntity(id = 191117, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "שְׁלֵמִים",
            translation = "целые (сильные) корни",
            definition = "גִּזְרָה שֶׁבָּהּ שְׁלוֹשׁ אוֹתִיּוֹת הַשֹּׁרֶשׁ נִשְׁמָרוֹת בְּכָל הַנְּטִיּוֹת: כָּתַב, שָׁמַר.",
            definitionNative = "Группа, в которой все три согласные корня сохраняются во всех формах: כָּתַב, שָׁמַר.",
            example = "פְּעָלִים מִגִּזְרַת הַשְּׁלֵמִים נֶחֱשָׁבִים לְקַלִּים בְּלִמּוּד.",
            exampleNative = "Глаголы группы שְׁלֵמִים считаются простыми для изучения.",
            pos = "noun", semanticGroup = "lang_morph_weak_roots", fillInBlankExclusions = listOf(191118L, 191119L, 191120L)),

        WordEntity(id = 191118, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "נָחֵי פ״א",
            translation = "корни со слабой первой согласной",
            definition = "גִּזְרָה שֶׁבָּהּ הָאַוֹת הָרִאַשׁוֹנָה שֶׁל הַשֹּׁרֶשׁ נוֹחָה — נ, י אַוֹ אַ — וְנֶעֱלֶמֶת בִּנְטִיָּה.",
            definitionNative = "Группа, в которой первая согласная корня слабая — נ, י или א — и исчезает в спряжении.",
            example = "הַשֹּׁרֶשׁ נ.פ.ל מִגִּזְרַת נָחֵי פ״א — בְּעָתִיד יִפֹּל.",
            exampleNative = "Корень נ.פ.ל относится к נָחֵי פ״א — в будущем יִפֹּל.",
            pos = "phrase", semanticGroup = "lang_morph_weak_roots", fillInBlankExclusions = listOf(191117L, 191119L, 191120L)),

        WordEntity(id = 191119, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "נָחֵי ע״ו",
            translation = "корни со слабой средней согласной",
            definition = "גִּזְרָה שֶׁבָּהּ הָאוֹת הָאֶמְצָעִית הִיא ו אוֹ י, וְלָכֵן הַשֹּׁרֶשׁ נִרְאֶה דּוּ-עִצּוּרִי: קָם, רָץ.",
            definitionNative = "Группа, в которой средняя буква — ו или י, поэтому корень выглядит двусогласным: קָם, רָץ.",
            example = "פְּעָלִים מִגִּזְרַת נָחֵי ע״ו נִלְמָדִים בְּאוּלְפַּן בֵּית.",
            exampleNative = "Глаголы נָחֵי ע״ו проходят на ульпан-Бет.",
            pos = "phrase", semanticGroup = "lang_morph_weak_roots", fillInBlankExclusions = listOf(191117L, 191118L, 191120L)),

        WordEntity(id = 191120, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "נָחֵי ל״ה",
            translation = "корни со слабой последней согласной",
            definition = "גִּזְרָה שֶׁבָּהּ הָאוֹת הַשְּׁלִישִׁית הָיְתָה ה אוֹ י וְנֶעֱלֶמֶת בִּנְטִיָּה: בָּנָה, קָנָה, רָאָה.",
            definitionNative = "Группа, в которой третья согласная была ה или י и исчезает в спряжении: בָּנָה, קָנָה, רָאָה.",
            example = "בְּגִזְרַת נָחֵי ל״ה הַסּוֹף שֶׁל הַפֹּעַל מִתְחַלֵּף בִּנְטִיָּה.",
            exampleNative = "В группе נָחֵי ל״ה конец глагола меняется при спряжении.",
            pos = "phrase", semanticGroup = "lang_morph_weak_roots", fillInBlankExclusions = listOf(191117L, 191118L, 191119L)),

        // ── Group: lang_morph_models (5 words) ────────────────────────────────

        WordEntity(id = 191121, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "שֵׁם תֹּאַר",
            translation = "имя прилагательное",
            definition = "מִילָּה שֶׁמְּתָאֶרֶת תְּכוּנָה שֶׁל שֵׁם עֶצֶם וְנוֹטָה אַחֲרָיו: גָּדוֹל, יָפֶה, חָכָם.",
            definitionNative = "Слово, что описывает признак существительного и согласуется с ним: גָּדוֹל, יָפֶה, חָכָם.",
            example = "שֵׁם תֹּאַר בָּא תָּמִיד אַחֲרֵי שֵׁם הָעֶצֶם בָּעִבְרִית.",
            exampleNative = "שֵׁם תֹּאַר всегда идёт после существительного в иврите.",
            pos = "phrase", semanticGroup = "lang_morph_models", fillInBlankExclusions = listOf(191122L, 191124L)),

        WordEntity(id = 191122, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "שֵׁם מוּפְשָׁט",
            translation = "абстрактное существительное",
            definition = "שֵׁם עֶצֶם הַמְּתָאֵר מֻשָּׂג, רֶגֶשׁ אוֹ תְּכוּנָה לְלֹא קִיּוּם פִיזִי: חֵרוּת, אַהֲבָה, חָכְמָה.",
            definitionNative = "Существительное, что обозначает понятие, чувство или качество без физической формы: חֵרוּת, אַהֲבָה, חָכְמָה.",
            example = "ה' הַיְדִיעָה לִפְנֵי שֵׁם מוּפְשָׁט נוֹתֶנֶת לוֹ גָּוֶן כְּלָלִי.",
            exampleNative = "Артикль ה' перед שֵׁם מוּפְשָׁט придаёт ему обобщающий оттенок.",
            pos = "phrase", semanticGroup = "lang_morph_models", fillInBlankExclusions = listOf(191121L, 191124L)),

        WordEntity(id = 191123, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "צוּרַת סְמִיכוּת",
            translation = "сопряжённое состояние (смихут)",
            definition = "צֵרוּף שֶׁל שְׁנֵי שְׁמוֹת עֶצֶם הַמַּבִּיעַ קִנְיָן: בֵּית סֵפֶר, מַחְבֶּרֶת הַתַּלְמִיד.",
            definitionNative = "Сочетание двух существительных, что выражает принадлежность: בֵּית סֵפֶר, מַחְבֶּרֶת הַתַּלְמִיד.",
            example = "בְּצוּרַת סְמִיכוּת הַשֵּׁם הָרִאשׁוֹן מְאַבֵּד ה' הַיְדִיעָה.",
            exampleNative = "В צוּרַת סְמִיכוּת первое слово теряет артикль ה'.",
            pos = "phrase", semanticGroup = "lang_morph_models", fillInBlankExclusions = listOf(191121L, 191122L, 191124L, 191125L)),

        WordEntity(id = 191124, setId = 1911, languagePair = "he-ru", rarity = "EPIC",
            original = "תֹּאַר הַפֹּעַל",
            translation = "наречие",
            definition = "מִילָּה שֶׁמְּתָאֶרֶת אֵיךְ, מָתַי אוֹ אֵיפֹה מִתְבַּצַּעַת הַפְּעֻלָּה: מַהֵר, אֶתְמוֹל, כָּאן.",
            definitionNative = "Слово, что описывает, как, когда или где совершается действие: מַהֵר, אֶתְמוֹל, כָּאן.",
            example = "תֹּאַר הַפֹּעַל ״מַהֵר״ מְשַׁנֶּה אֶת אֹפֶן הָרִיצָה.",
            exampleNative = "תֹּאַר הַפֹּעַל «מַהֵר» меняет образ действия.",
            pos = "phrase", semanticGroup = "lang_morph_models", fillInBlankExclusions = listOf(191121L, 191122L)),

        WordEntity(id = 191125, setId = 1911, languagePair = "he-ru", rarity = "RARE",
            original = "כִּנּוּי גּוּף",
            translation = "личное местоимение",
            definition = "מִילָּה שֶׁמַּחֲלִיפָה שֵׁם עֶצֶם וּמְצַיֶּנֶת גּוּף: אֲנִי, אַתָּה, הִיא, אֲנַחְנוּ.",
            definitionNative = "Слово, что заменяет существительное и указывает на лицо: אֲנִי, אַתָּה, הִיא, אֲנַחְנוּ.",
            example = "בָּעִבְרִית כִּנּוּי גּוּף מוּשְׁמָט לְעִתִּים בְּעָבָר וּבְעָתִיד.",
            exampleNative = "В иврите כִּנּוּי גּוּף часто опускается в прошедшем и будущем.",
            pos = "phrase", semanticGroup = "lang_morph_models", fillInBlankExclusions = listOf(191121L, 191122L, 191123L, 191124L)),
    )
}
