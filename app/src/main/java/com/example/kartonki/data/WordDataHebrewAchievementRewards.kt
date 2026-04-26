package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity

/**
 * Hebrew (he-ru) achievement-only reward words.
 *
 * Parallel set to [WordDataEnglishExpanded.achievementRewardWords] — same
 * conceptual rewards mapped to the same achievements (FIRST_LESSON, EXPERT,
 * STREAK_5/STREAK_7, COLLECTOR, LEGEND, DILIGENT, FIRST_FIGHT, FIRST_WIN,
 * STREAK_5, POLYGLOT and the 30 long-term EXCLUSIVE_LEGENDARY achievements).
 *
 * All words have setId = 0 — they belong to no thematic set and are reserved
 * exclusively for achievement rewards. They never appear in starter packs or
 * card boosters.
 *
 * IDs 24990..25029 — 10 EPIC starter rewards + 30 LEGENDARY exclusive rewards.
 *
 * Stylistic notes (per docs/claude/quality_standards_*):
 *  • transliteration in Cyrillic;
 *  • Hebrew vowels (nikud) only on the target word in `example`;
 *  • target word stays in the same form as `original` inside `example`;
 *  • definitions ≤ 16 words / ≤ 90 chars, one sentence, no cognates;
 *  • examples ≤ 12 words / ≤ 80 chars (he-ru limit).
 */
object WordDataHebrewAchievementRewards {

    fun achievementRewardWords(): List<WordEntity> = listOf(

        // ── STARTER REWARDS (EPIC) ─────────────────────────────────────────────
        // FIRST_LESSON — paradigm → דֶּגֶם (образец, шаблон)
        WordEntity(id = 999900, original = "דֶּגֶם", transliteration = "дегем", translation = "образец / шаблон / парадигма", rarity = "EPIC", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "צוּרָה רִאשׁוֹנָה שֶׁעַל פִּיהָ מַעֲתִיקִים אוֹ בּוֹנִים דְּבָרִים נוֹסָפִים.",
            example = "הַחוֹקֵר הִצִּיג דֶּגֶם חָדָשׁ לְהָבִין אֶת הַתּוֹפָעָה.",
            definitionNative = "Первая форма, по которой потом копируют или строят похожее.",
            exampleNative = "Учёный представил новый דֶּגֶם для понимания этого явления."),
        // EXPERT — accomplish → לְהַשִּׂיג (достигать, добиваться)
        WordEntity(id = 999901, original = "לְהַשִּׂיג", transliteration = "леhасиг", translation = "достигать / добиваться", rarity = "EPIC", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לְהַגִּיעַ אֶל מַטָּרָה אַחֲרֵי מַאֲמָץ אוֹ עֲבוֹדָה אֲרֻכָּה.",
            example = "הִיא עָבְדָה קָשֶׁה כְּדֵי לְהַשִּׂיג אֶת הַחֲלוֹם שֶׁלָּהּ.",
            definitionNative = "Дойти до цели после усилий или долгой работы.",
            exampleNative = "Она много работала, чтобы לְהַשִּׂיג свою мечту."),
        // STREAK_5 / STREAK_7 — consistent → עִקְבִי (последовательный, постоянный)
        WordEntity(id = 999902, original = "עִקְבִי", transliteration = "иквИ", translation = "последовательный / постоянный", rarity = "EPIC", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁפּוֹעֵל בְּאוֹתָהּ דֶּרֶךְ שׁוּב וָשׁוּב — לֹא מִשְׁתַּנֶּה.",
            example = "תַּלְמִיד עִקְבִי מַצְלִיחַ יוֹתֵר מִכִּשְׁרוֹן בּוֹדֵד.",
            definitionNative = "Тот, кто действует одинаково раз за разом — не меняется.",
            exampleNative = "עִקְבִי ученик добивается большего, чем разовый талант."),
        // COLLECTOR — dedicate → לְהַקְדִּישׁ (посвящать, уделять)
        WordEntity(id = 999903, original = "לְהַקְדִּישׁ", transliteration = "леhакдиш", translation = "посвящать / уделять (время, силы)", rarity = "EPIC", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לָתֵת זְמַן אוֹ כֹּחַ לְמַטָּרָה אַחַת לְלֹא חֲרָטָה.",
            example = "הוּא בָּחַר לְהַקְדִּישׁ שָׁנִים לְאִסּוּף קְלָפִים נְדִירִים.",
            definitionNative = "Отдать время или силы одной цели и не жалеть об этом.",
            exampleNative = "Он решил לְהַקְדִּישׁ годы коллекционированию редких карточек."),
        // LEGEND — excel → לְהִצְטַיֵּין (выделяться, преуспевать)
        WordEntity(id = 999904, original = "לְהִצְטַיֵּין", transliteration = "леhицтайен", translation = "преуспевать / выделяться", rarity = "EPIC", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לִהְיוֹת טוֹב בְּהַרְבֵּה מֵהָאֲחֵרִים בְּתְחוּם מְסֻיָּם.",
            example = "הוּא יָדַע לְהִצְטַיֵּין בִּמְתֵמַטִיקָה כְּבָר בְּכִתָּה ב.",
            definitionNative = "Быть намного лучше других в каком-то деле.",
            exampleNative = "Он умел לְהִצְטַיֵּין по математике уже во втором классе."),
        // DILIGENT — inference → מַסְקָנָה (вывод, умозаключение)
        WordEntity(id = 999905, original = "מַסְקָנָה", transliteration = "масканА", translation = "вывод / умозаключение", rarity = "EPIC", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "מַחְשָׁבָה הֶגְיוֹנִית הַנּוֹבַעַת מִתּוֹךְ עֻבְדּוֹת אוֹ נְתוּנִים.",
            example = "מִכָּל מָה שֶׁשָּׁמַעְתִּי הִגַּעְתִּי לְמַסְקָנָה בְּרוּרָה.",
            definitionNative = "Логическая мысль, вытекающая из фактов или данных.",
            exampleNative = "Из всего услышанного я пришёл к ясной מַסְקָנָה."),
        // FIRST_FIGHT — conjecture → הַשְׁעָרָה (гипотеза, предположение)
        WordEntity(id = 999906, original = "הַשְׁעָרָה", transliteration = "hашъарА", translation = "гипотеза / предположение", rarity = "EPIC", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "מַחְשָׁבָה לֹא וַדָּאִית עַל מָה שֶׁאוּלַי קָרָה אוֹ יִקְרֶה.",
            example = "בְּלִי הוֹכָחָה זוֹ רַק הַשְׁעָרָה וְלֹא עֻבְדָּה.",
            definitionNative = "Неуверенная мысль о том, что возможно случилось или произойдёт.",
            exampleNative = "Без доказательств это лишь הַשְׁעָרָה, а не факт."),
        // FIRST_WIN — refute → לְהַפְרִיךְ (опровергать)
        WordEntity(id = 999907, original = "לְהַפְרִיךְ", transliteration = "леhафрих", translation = "опровергать", rarity = "EPIC", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לְהַרְאוֹת בְּעֶזְרַת רְאָיוֹת שֶׁטַּעֲנָה אֵינָהּ נְכוֹנָה.",
            example = "הַחוֹקֵר הִצְלִיחַ לְהַפְרִיךְ אֶת הַתֵּאוֹרְיָה הַיְּשָׁנָה.",
            definitionNative = "С помощью доказательств показать, что утверждение неверно.",
            exampleNative = "Учёному удалось לְהַפְרִיךְ старую теорию."),
        // STREAK_5 — elucidate → לְבָאֵר (разъяснять)
        WordEntity(id = 999908, original = "לְבָאֵר", transliteration = "леваэр", translation = "разъяснять", rarity = "EPIC", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לוֹמַר בְּמִלִּים פְּשׁוּטוֹת מָה בְּדִיּוּק כָּתוּב אוֹ קָרָה.",
            example = "הַמּוֹרָה נִסְתָה לְבָאֵר אֶת הַכְּלָל בְּדֻגְמָה קָלָה.",
            definitionNative = "Сказать простыми словами, что именно написано или произошло.",
            exampleNative = "Учительница пыталась לְבָאֵר правило на простом примере."),
        // POLYGLOT — fluent → שׁוֹטֵף (свободно владеющий, беглый)
        WordEntity(id = 999909, original = "שׁוֹטֵף", transliteration = "шотеф", translation = "свободно владеющий / беглый", rarity = "EPIC", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "שֶׁזּוֹרֵם בְּלִי הַפְסָקָה — דִּבּוּר שֶׁעוֹבֵד כְּמוֹ שֶׁל מְקוֹמִי.",
            example = "אַחֲרֵי שָׁנָה בָּאוּלְפָּן הוּא דִּבֵּר עִבְרִית שׁוֹטֵף.",
            definitionNative = "Текущий без остановок — речь как у местного жителя.",
            exampleNative = "После года в ульпане он говорил שׁוֹטֵף на иврите."),

        // ── EXCLUSIVE LEGENDARY REWARDS ────────────────────────────────────────
        // DOMINATOR — diaphanous → שָׁקוּף (прозрачный)
        WordEntity(id = 999910, original = "שָׁקוּף", transliteration = "шакуф", translation = "прозрачный", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁאֶפְשָׁר לִרְאוֹת מַה יֵשׁ מֵאֲחוֹרָיו, כְּמוֹ זְכוּכִית.",
            example = "הַחַלּוֹן שָׁקוּף וְהַשֶּׁמֶשׁ נִכְנֶסֶת בְּלִי הַפְרָעָה.",
            definitionNative = "Такой, через который видно то, что за ним — как через стекло.",
            exampleNative = "Окно שָׁקוּף, и солнце входит беспрепятственно."),
        // NIGHT_OWL — lugubrious → קוֹדֵר (мрачный, угрюмый)
        WordEntity(id = 999911, original = "קוֹדֵר", transliteration = "кодер", translation = "мрачный / угрюмый", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "מָלֵא עֶצֶב וְכֹבֶד — בְּלִי אוֹר וּבְלִי תִּקְוָה.",
            example = "הוּא יָשַׁב בְּפִנָּה עִם מַבָּט קוֹדֵר וְלֹא דִּבֵּר.",
            definitionNative = "Полный печали и тяжести — без света и без надежды.",
            exampleNative = "Он сидел в углу с קוֹדֵר взглядом и молчал."),
        // PERFECTIONIST — obstreperous → סוֹעֵר (бурный, буйный)
        WordEntity(id = 999912, original = "סוֹעֵר", transliteration = "соэр", translation = "бурный / буйный", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "מָלֵא תְּנוּעָה חֲזָקָה וְרַעַשׁ — לֹא שָׁקֵט בְּשׁוּם פָּנִים.",
            example = "הָיְתָה אֲסֵפָה סוֹעֵר עִם צְעָקוֹת מִכָּל הַצְּדָדִים.",
            definitionNative = "Полный сильного движения и шума — совсем не тихий.",
            exampleNative = "Было סוֹעֵר собрание с криками со всех сторон."),
        // DEEP_LEARNER — abstruse → סָבוּךְ (запутанный, трудный)
        WordEntity(id = 999913, original = "סָבוּךְ", transliteration = "савух", translation = "запутанный / сложный для понимания", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁקָּשֶׁה לְהָבִין אוֹתוֹ — מָלֵא חוּטִים וּפְרָטִים.",
            example = "הַסִּפּוּר הַזֶּה סָבוּךְ מִדַּי בִּשְׁבִיל יֶלֶד קָטָן.",
            definitionNative = "Такой, что трудно понять — полон деталей и поворотов.",
            exampleNative = "Эта история слишком סָבוּךְ для маленького ребёнка."),
        // VETERAN — meretricious → רַאֲוָתָנִי (показной, мишурный)
        WordEntity(id = 999914, original = "רַאֲוָתָנִי", transliteration = "раавтанИ", translation = "показной / мишурный", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁמַּרְאֶה רַק לְרֹשֶׁם חִיצוֹנִי, בְּלִי תֹּכֶן אֲמִתִּי בִּפְנִים.",
            example = "הַטֶּקֶס הָיָה רַאֲוָתָנִי וְלֹא נָגַע לְאַף אֶחָד.",
            definitionNative = "Такой, что показывает только внешний эффект — без содержания внутри.",
            exampleNative = "Церемония была רַאֲוָתָנִי и никого не тронула."),
        // CENTURION — pellucid → צָלוּל (ясный, чистый, кристальный)
        WordEntity(id = 999915, original = "צָלוּל", transliteration = "цалуль", translation = "ясный / кристально чистый", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "בָּהִיר וְנָקִי לְגַמְרֵי — בְּלִי עִרְפּוּל וּבְלִי לִכְלוּךְ.",
            example = "מֵי הַנַּחַל הָיוּ צָלוּל וְרָאִינוּ אֶת הָאֲבָנִים.",
            definitionNative = "Совсем светлый и чистый — без мути и без грязи.",
            exampleNative = "Вода в ручье была צָלוּל, и были видны камни."),
        // DRAW_MASTER — platitudinous → שִׁגְרָתִי (рутинный, банальный)
        WordEntity(id = 999916, original = "שִׁגְרָתִי", transliteration = "шигратИ", translation = "рутинный / банальный", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "רָגִיל וּמֻכָּר עַד כְּדֵי שִׁעֲמוּם — בְּלִי שׁוּם דָּבָר חָדָשׁ.",
            example = "הַנְּאוּם הָיָה שִׁגְרָתִי וְכֻלָּם פִּהֲקוּ בְּשֶׁקֶט.",
            definitionNative = "Привычный и знакомый до скуки — без чего-то нового.",
            exampleNative = "Речь была שִׁגְרָתִי, и все тихо зевали."),
        // MONDAY_SCHOLAR — recondite → כָּמוּס (скрытый, сокровенный)
        WordEntity(id = 999917, original = "כָּמוּס", transliteration = "камус", translation = "скрытый / сокровенный", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "סָגוּר עָמֹק בִּפְנִים וְלֹא גָּלוּי לְעֵינֵי הַזָּרִים.",
            example = "לְכָל אָדָם יֵשׁ רָצוֹן כָּמוּס שֶׁאֵינוֹ מְסַפֵּר עָלָיו.",
            definitionNative = "Закрытый глубоко внутри и не виден чужим глазам.",
            exampleNative = "У каждого человека есть כָּמוּס желание, о котором он не говорит."),
        // GOLDEN_SHOT — stentorian → רַעַם (гром, громоподобный)
        WordEntity(id = 999918, original = "רַעַם", transliteration = "раам", translation = "гром / громовой раскат", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "קוֹל חָזָק וְעָמֹק שֶׁמֵּילֵא אֶת הַשָּׁמַיִם אַחֲרֵי בָּרָק.",
            example = "פִּתְאֹם נִשְׁמַע רַעַם וְהַיְּלָדִים בָּרְחוּ הַבַּיְתָה.",
            definitionNative = "Сильный и глубокий звук, заполняющий небо после молнии.",
            exampleNative = "Внезапно раздался רַעַם, и дети убежали домой."),
        // WEEKLY_GRIND — ineffaceable → בִּלְתִּי-נִמְחָק (нестираемый, неизгладимый)
        WordEntity(id = 999919, original = "בִּלְתִּי-נִמְחָק", transliteration = "бильти-нимхак", translation = "неизгладимый / нестираемый", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁאִי-אֶפְשָׁר לְהַסִּיר אוֹתוֹ — נִשְׁאָר לָנֶצַח.",
            example = "הַמּוֹרֶה הִשְׁאִיר רֹשֶׁם בִּלְתִּי-נִמְחָק עַל הַתַּלְמִידִים.",
            definitionNative = "Такой, что нельзя удалить — остаётся навсегда.",
            exampleNative = "Учитель оставил בִּלְתִּי-נִמְחָק след в учениках."),
        // WHITE_FLAG — sempiternal → נִצְחִי (вечный)
        WordEntity(id = 999920, original = "נִצְחִי", transliteration = "ницхИ", translation = "вечный", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁאֵין לוֹ סוֹף בַּזְּמַן — נִשְׁאָר תָּמִיד וּלְעוֹלָם.",
            example = "הָאַהֲבָה בֵּינֵיהֶם נִרְאֲתָה לָהֶם נִצְחִי וּבְלִי גְּבוּל.",
            definitionNative = "Такой, у которого нет конца во времени — остаётся всегда.",
            exampleNative = "Любовь между ними казалась им נִצְחִי и без границ."),
        // EXPLORER — desideratum → צֹרֶךְ (потребность, нужда)
        WordEntity(id = 999921, original = "צֹרֶךְ", transliteration = "цорех", translation = "насущная потребность / нужда", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "מַשֶּׁהוּ שֶׁאָדָם חַיָּב לְקַבֵּל אוֹ לַעֲשׂוֹת — בְּלִי זֶה לֹא יִתְקַיֵּם.",
            example = "מַיִם נְקִיִּים הֵם צֹרֶךְ בְּסִיסִי לְכָל בַּיִת.",
            definitionNative = "То, что человеку обязательно нужно получить или сделать — без этого не выжить.",
            exampleNative = "Чистая вода — базовый צֹרֶךְ для каждого дома."),
        // MARATHON — synecdoche → דִּמּוּי (сравнение, образ; ближайший аналог)
        WordEntity(id = 999922, original = "דִּמּוּי", transliteration = "димУй", translation = "сравнение / образ (фигура речи)", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "צוּרַת לָשׁוֹן שֶׁמְּתָאֶרֶת דָּבָר אֶחָד דֶּרֶךְ דָּבָר אַחֵר דּוֹמֶה.",
            example = "הַמְּשׁוֹרֵר הִשְׁתַּמֵּשׁ בְּדִמּוּי יָפֶה כְּדֵי לְתָאֵר אֶת הַיָּם.",
            definitionNative = "Оборот речи, описывающий одно через другое похожее.",
            exampleNative = "Поэт использовал красивый דִּמּוּי, чтобы описать море."),
        // RUSTY — solipsism → סוֹלִיפְּסִיזְם (солипсизм, философский термин)
        WordEntity(id = 999923, original = "סוֹלִיפְּסִיזְם", transliteration = "солипсизм", translation = "солипсизм", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "תְּפִיסָה שֶׁלְּפִיהָ רַק הָ\"אֲנִי\" שֶׁל הָאָדָם בָּטוּחַ — כָּל הַיֶּתֶר אוּלַי דִּמְיוֹן.",
            example = "הַסְּטוּדֶנְט גִּלָּה בַּקּוּרְס מַהוּ סוֹלִיפְּסִיזְם בָּפִילוֹסוֹפְיָה.",
            definitionNative = "Взгляд: только собственное «я» точно существует — остальное может быть иллюзией.",
            exampleNative = "Студент узнал на курсе, что такое סוֹלִיפְּסִיזְם в философии."),
        // LONG_WORD — perspicacious → חַד-עַיִן (зоркий, проницательный)
        WordEntity(id = 999924, original = "חַד-עַיִן", transliteration = "хад-аин", translation = "проницательный / зоркий", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁשָּׂם לֵב לִפְרָטִים קְטַנִּים וּמֵבִין מַהֵר מָה קוֹרֶה.",
            example = "הַבַּלָּשׁ הָיָה חַד-עַיִן וְזִהָה אֶת הַסִּימָנִים בְּשֵׁנִיּוֹת.",
            definitionNative = "Тот, кто замечает мелочи и быстро понимает суть.",
            exampleNative = "Сыщик был חַד-עַיִן и за секунды распознал улики."),
        // (palimpsest reserved as 25015) — palimpsest → פָּלִימְפְּסֶסְט
        WordEntity(id = 999925, original = "פָּלִימְפְּסֶסְט", transliteration = "палимпсест", translation = "палимпсест (рукопись поверх стёртой)", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "כְּתָב יָד עַתִּיק שֶׁעָלָיו מָחֲקוּ טֶקְסְט קוֹדֵם וְכָתְבוּ עָלָיו חָדָשׁ.",
            example = "הַחוֹקְרִים גִּלּוּ פָּלִימְפְּסֶסְט עִם שִׁכְבוֹת כְּתִיבָה רַבּוֹת.",
            definitionNative = "Древняя рукопись, где поверх стёртого старого текста написан новый.",
            exampleNative = "Учёные нашли פָּלִימְפְּסֶסְט с несколькими слоями письма."),
        // solipsistic → אֲנִי-מֶרְכָּזִי (эгоцентричный, я-центричный)
        WordEntity(id = 999926, original = "אֲנִי-מֶרְכָּזִי", transliteration = "ани-мерказИ", translation = "эгоцентричный / солипсистский", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁשָּׂם אֶת עַצְמוֹ בַּמֶּרְכָּז וּמִתְעַלֵּם מֵהָאֲחֵרִים סְבִיבוֹ.",
            example = "מַבָּטוֹ אֲנִי-מֶרְכָּזִי עַל הָעוֹלָם הִרְחִיק מִמֶּנּוּ חֲבֵרִים.",
            definitionNative = "Такой, кто ставит себя в центр и не замечает других вокруг.",
            exampleNative = "Его אֲנִי-מֶרְכָּזִי взгляд на мир оттолкнул друзей."),
        // intertextuality → בֵּין-טֶקְסְטוּאָלִיּוּת
        WordEntity(id = 999927, original = "בֵּין-טֶקְסְטוּאָלִיּוּת", transliteration = "бейн-текстуалийут", translation = "интертекстуальность", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "קְשָׁרִים שֶׁל יְצִירָה אַחַת לִיצִירוֹת אֲחֵרוֹת — בְּצִיטוּט אוֹ בְּרֶמֶז.",
            example = "הַשִּׁיר מָלֵא בֵּין-טֶקְסְטוּאָלִיּוּת לְכִתְבֵי הַמִּקְרָא.",
            definitionNative = "Связи одного произведения с другими — через цитаты или намёки.",
            exampleNative = "Стихотворение полно בֵּין-טֶקְסְטוּאָלִיּוּת с библейскими текстами."),
        // prolepsis → הַקְדָּמָה (предвосхищение)
        WordEntity(id = 999928, original = "הַקְדָּמָה", transliteration = "hакдамА", translation = "предвосхищение / упреждение", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "מַעֲשֶׂה שֶׁעוֹשִׂים מֵרֹאשׁ — לִפְנֵי שֶׁבָּא הָרֶגַע הַמַּתְאִים.",
            example = "הַסּוֹפֵר הִכְנִיס הַקְדָּמָה לִרְמֹז עַל הַסּוֹף הַטְּרָגִי.",
            definitionNative = "Действие наперёд — до того, как настал нужный момент.",
            exampleNative = "Автор вставил הַקְדָּמָה, намекая на трагический финал."),
        // insouciant → אָדִישׁ (безразличный, беззаботный)
        WordEntity(id = 999929, original = "אָדִישׁ", transliteration = "адИш", translation = "безразличный / беззаботный", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁלֹּא אִכְפַּת לוֹ — לֹא שָׂמֵחַ וְלֹא עָצוּב מִמָּה שֶׁקּוֹרֶה.",
            example = "הוּא נִשְׁאָר אָדִישׁ גַּם כַּאֲשֶׁר כֻּלָּם הִתְרַגְּשׁוּ.",
            definitionNative = "Такой, кому всё равно — не радуется и не печалится от происходящего.",
            exampleNative = "Он остался אָדִישׁ, даже когда все вокруг волновались."),
        // magniloquent → מְלִיצִי (высокопарный, цветистый)
        WordEntity(id = 999930, original = "מְלִיצִי", transliteration = "мелицИ", translation = "высокопарный / цветистый", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁמִּשְׁתַּמֵּשׁ בְּמִלִּים גְּבוֹהוֹת וּמְקֻשָּׁטוֹת בִּמְקוֹם פְּשׁוּטוֹת.",
            example = "הַסִּגְנוֹן הַמְּלִיצִי שֶׁל הַמִּכְתָּב הִרְחִיק אֶת הַקּוֹרְאִים.",
            definitionNative = "Такой, кто использует громкие и нарядные слова вместо простых.",
            exampleNative = "מְלִיצִי стиль письма оттолкнул читателей."),
        // pusillanimous → פַּחְדָן (трусливый)
        WordEntity(id = 999931, original = "פַּחְדָן", transliteration = "пахдАн", translation = "трусливый / малодушный", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "adjective", semanticGroup = "achievement_reward",
            definition = "כָּזֶה שֶׁמִּתְיָרֵא מַהֵר וְלֹא מֵעֵז לַעֲשׂוֹת דְּבָרִים קָשִׁים.",
            example = "הוּא הָיָה פַּחְדָן מִדַּי כְּדֵי לוֹמַר אֶת הָאֱמֶת בָּפָּנִים.",
            definitionNative = "Тот, кто быстро пугается и не решается на трудное.",
            exampleNative = "Он был слишком פַּחְדָן, чтобы сказать правду в лицо."),
        // ossify → לְהִתְאַבֵּן (окостенеть, костенеть)
        WordEntity(id = 999932, original = "לְהִתְאַבֵּן", transliteration = "леhит'абен", translation = "окостеневать / коснеть", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לְהַפֹּךְ קָשֶׁה וְלֹא גָּמִישׁ — לֹא לְהִשְׁתַּנּוֹת יוֹתֵר.",
            example = "הָרַעְיוֹנוֹת שֶׁלּוֹ הִתְחִילוּ לְהִתְאַבֵּן עִם הַשָּׁנִים.",
            definitionNative = "Стать твёрдым и негибким — больше не меняться.",
            exampleNative = "Его взгляды начали לְהִתְאַבֵּן с годами."),
        // precipitate → לְהָחִישׁ (ускорять, поторопить наступление)
        WordEntity(id = 999933, original = "לְהָחִישׁ", transliteration = "леhахиш", translation = "ускорять / приближать наступление", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לִגְרֹם לְמַשֶּׁהוּ לִקְרוֹת מַהֵר יוֹתֵר מִמָּה שֶׁתַּכְנֵן הַטֶּבַע.",
            example = "הַחֲלָטָתוֹ הַפְּזִיזָה לְהָחִישׁ אֶת הַמַּשְׁבֵּר עַל הַחֶבְרָה.",
            definitionNative = "Заставить что-то случиться раньше, чем шло бы само.",
            exampleNative = "Его поспешное решение לְהָחִישׁ кризис в компании."),
        // attrite → לְכַלּוֹת (изнашивать, истощать)
        WordEntity(id = 999934, original = "לְכַלּוֹת", transliteration = "лехалот", translation = "изнашивать / истощать", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לִגְרֹם לְמַשֶּׁהוּ לְהֵעָלֵם לְאַט-לְאַט עַל יְדֵי שִׁמּוּשׁ אוֹ זְמַן.",
            example = "הַמִּלְחָמָה הָאֲרֻכָּה הִתְחִילָה לְכַלּוֹת אֶת כֹּחַ הַצָּבָא.",
            definitionNative = "Заставить что-то постепенно исчезать от использования или времени.",
            exampleNative = "Затяжная война начала לְכַלּוֹת силы армии."),
        // reify → לְמַמֵּשׁ (овеществить, реализовать)
        WordEntity(id = 999935, original = "לְמַמֵּשׁ", transliteration = "лемамеш", translation = "овеществить / воплотить", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לְהַפֹּךְ רַעְיוֹן מֻפְשָׁט לְדָבָר מַמָּשִׁי שֶׁאֶפְשָׁר לִרְאוֹת.",
            example = "הַחֶבְרָה הִצְלִיחָה לְמַמֵּשׁ אֶת הַחֲזוֹן שֶׁל הַמְּיַסֵּד.",
            definitionNative = "Превратить отвлечённую идею в нечто видимое и реальное.",
            exampleNative = "Компании удалось לְמַמֵּשׁ замысел основателя."),
        // ramify → לְהִסְתַּעֵף (разветвляться)
        WordEntity(id = 999936, original = "לְהִסְתַּעֵף", transliteration = "леhистаэф", translation = "разветвляться", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לְהִתְפַּצֵּל לְכַמָּה כִּוּוּנִים — כְּמוֹ עֲנָפִים שֶׁל עֵץ.",
            example = "הַשִּׂיחָה הִתְחִילָה לְהִסְתַּעֵף לְנוֹשְׂאִים בִּלְתִּי קְשׁוּרִים.",
            definitionNative = "Разделиться на несколько направлений — как ветви дерева.",
            exampleNative = "Разговор начал לְהִסְתַּעֵף на не связанные между собой темы."),
        // efflorescence → פְּרִיחָה (расцвет, цветение)
        WordEntity(id = 999937, original = "פְּרִיחָה", transliteration = "прихА", translation = "расцвет / пышное цветение", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "noun", semanticGroup = "achievement_reward",
            definition = "תְּקוּפָה שֶׁל גִּדּוּל יָפֶה וּמָלֵא — גַּם בַּטֶּבַע וְגַם בַּתַּרְבּוּת.",
            example = "הַתְּקוּפָה שֶׁאַחֲרֵי הַמִּלְחָמָה הָיְתָה פְּרִיחָה אֳמָנוּתִית.",
            definitionNative = "Период красивого и полного роста — в природе или в культуре.",
            exampleNative = "Послевоенное время стало פְּרִיחָה искусств."),
        // metastasise → לְהִתְפַּשֵּׁט (распространяться, разрастаться)
        WordEntity(id = 999938, original = "לְהִתְפַּשֵּׁט", transliteration = "леhитпашет", translation = "распространяться / разрастаться", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לַעֲבֹר מִמָּקוֹם אֶחָד לְעוֹד וְעוֹד מְקוֹמוֹת — בְּלִי לִבְלֹם.",
            example = "הַשְּׁמוּעָה הִתְחִילָה לְהִתְפַּשֵּׁט בְּכָל הַשְּׁכוּנָה תּוֹךְ שָׁעָה.",
            definitionNative = "Перейти из одного места в новые и новые — без остановки.",
            exampleNative = "Слух начал לְהִתְפַּשֵּׁט по всему району за час."),
        // fructify → לְהַפְרוֹת (приносить плоды, оплодотворять идеей)
        WordEntity(id = 999939, original = "לְהַפְרוֹת", transliteration = "леhафрот", translation = "приносить плоды / оплодотворять идеей", rarity = "LEGENDARY", setId = 0, languagePair = "he-ru", pos = "verb", semanticGroup = "achievement_reward",
            definition = "לִתֵן לְמַשֶּׁהוּ כֹּחַ צְמִיחָה — לִגְרֹם לוֹ לָתֵת תּוֹצָאָה טוֹבָה.",
            example = "הַחִבּוּר בֵּין שְׁתֵּי הַחֲבָרוֹת יָכוֹל לְהַפְרוֹת אֶת הָעֲבוֹדָה.",
            definitionNative = "Дать чему-то силу роста — чтобы получился хороший результат.",
            exampleNative = "Союз двух фирм может לְהַפְרוֹת работу обеих."),
    )
}
