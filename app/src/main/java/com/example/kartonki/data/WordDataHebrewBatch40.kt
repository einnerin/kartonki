package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch40 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(id = 1209, languagePair = "he-ru", orderIndex = 1209,
            name = "Психология",
            description = "Память, внимание, мышление, искажения",
            topic = "Психология",
            level = 3),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1208: Социология ───────────────────────────────────────────

        // RARE (B2),

        // EPIC (C1),

        // ── Set 1209: Психология (память, внимание, мышление, искажения) ──

        WordEntity(
            id = 120901, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_reasoning", transliteration = "heska",
            original = "הֶסְקָה", translation = "вывод / умозаключение",
            definition = "מַסְקָנָה הִגָּיוֹנִית מִתּוֹךְ נְתוּנִים אוֹ עוּבְדוֹת קַיָּמוֹת.",
            definitionNative = "Логический итог рассуждения по имеющимся данным или фактам.",
            example = "הוּא הִגִּיעַ לְהֶסְקָה שֶׁהָאֲחָיוֹת לֹא הִקְשִׁיבוּ.",
            exampleNative = "Он пришёл к הֶסְקָה, что сёстры его не слушали.",
         fillInBlankExclusions = listOf(120906L, 120907L, 120910L)),
        WordEntity(
            id = 120902, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_attention_memory", transliteration = "tsumat lev",
            original = "תְּשׂוּמַת לֵב", translation = "внимание",
            definition = "מִיקּוּד הַמַּחֲשָׁבָה בִּגְרוּי מְסֻיָּם תּוֹךְ הִתְעַלְּמוּת מֵאֲחֵרִים.",
            definitionNative = "Сосредоточение мысли на одном раздражителе при отсечении других.",
            example = "הַיֶּלֶד הִקְדִּישׁ תְּשׂוּמַת לֵב לַסִּפּוּר שֶׁל הַמּוֹרָה.",
            exampleNative = "Мальчик уделил תְּשׂוּמַת לֵב рассказу учительницы.",
         fillInBlankExclusions = listOf(120909L, 120913L, 120916L, 120923L)),
        WordEntity(
            id = 120903, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_cognition", transliteration = "hakhlala",
            original = "הַכְלָלָה", translation = "обобщение / генерализация",
            definition = "מַעֲבָר מִמִּקְרֶה יָחִיד לִכְלָל רָחָב יוֹתֵר עַל סְמַךְ הַדִּמְיוֹן.",
            definitionNative = "Переход от частного случая к более широкому правилу по сходству.",
            example = "מְסֻכָּן לַעֲשׂוֹת הַכְלָלָה עַל בְּסִיס דֻּגְמָה אַחַת בִּלְבַד.",
            exampleNative = "Опасно делать הַכְלָלָה на основе одного-единственного примера.",
         fillInBlankExclusions = listOf(120904L, 120905L, 120908L, 120925L)),
        WordEntity(
            id = 120904, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_cognition", transliteration = "ibud meida",
            original = "עִיבּוּד מֵידָע", translation = "обработка информации",
            definition = "פְּעִילוּת הַמֹּחַ הַמַּמִּירָה גְּרוּיִים לִידִיעָה מְאֻרְגֶּנֶת.",
            definitionNative = "Работа мозга, превращающая внешние сигналы в упорядоченное знание.",
            example = "עִיבּוּד מֵידָע מָהִיר עוֹזֵר לַתַּלְמִיד לְהָבִין שִׁיעוּר חָדָשׁ.",
            exampleNative = "Быстрая עִיבּוּד מֵידָע помогает ученику понимать новый урок.",
         fillInBlankExclusions = listOf(120903L, 120905L, 120908L, 120925L)),
        WordEntity(
            id = 120905, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_cognition", transliteration = "khshiva analitit",
            original = "חִשִּׁיבָה אַנַלִיטִית", translation = "аналитическое мышление",
            definition = "פֵּרוּק בְּעָיָה לְחֵלָקִים קְטַנִּים וּבְדִיקָתָם בָּזֶה אַחַר זֶה.",
            definitionNative = "Разбор задачи на маленькие части и их пошаговое изучение.",
            example = "חִשִּׁיבָה אַנַלִיטִית עוֹזֶרֶת לִמְהַנְדֵּס לִמְצֹא תַּקָּלָה בַּמַּעֲרֶכֶת.",
            exampleNative = "חִשִּׁיבָה אַנַלִיטִית помогает инженеру найти неполадку в системе.",
         fillInBlankExclusions = listOf(120903L, 120904L, 120908L, 120925L)),
        WordEntity(
            id = 120906, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_reasoning", transliteration = "shiput",
            original = "שִׁיפּוּט", translation = "суждение / оценка",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ הָאָדָם קוֹבֵעַ אִם דָּבָר נָכוֹן, טוֹב אוֹ רָאוּי.",
            definitionNative = "Процесс, в котором человек решает, что верно, хорошо или уместно.",
            example = "הַשּׁוֹפֵט גִּלָּה שִׁיפּוּט זָהִיר וְהָגוּן בַּדִּיּוּן הַקָּשֶׁה.",
            exampleNative = "Судья проявил осторожный и честный שִׁיפּוּט в трудном слушании.",
         fillInBlankExclusions = listOf(120901L, 120907L, 120910L)),
        WordEntity(
            id = 120907, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_reasoning", transliteration = "heyristika",
            original = "הֵיְרִיסְטִיקָה", translation = "эвристика",
            definition = "כְּלַל אֶצְבַּע מָהִיר לְקַבָּלַת הַחְלָטוֹת בְּלִי בְּדִיקָה מְלֵאָה.",
            definitionNative = "Быстрое практическое правило для решений без полной проверки.",
            example = "הֵיְרִיסְטִיקָה נוֹחָה אַךְ עֲלוּלָה לְהוֹבִיל לְטָעוּיוֹת חוֹזְרוֹת.",
            exampleNative = "הֵיְרִיסְטִיקָה удобна, но способна вести к повторяющимся ошибкам.",
         fillInBlankExclusions = listOf(120901L, 120906L, 120910L)),
        WordEntity(
            id = 120908, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_cognition", transliteration = "schema mentali",
            original = "סְכֵמָה מֶנְטָלִית", translation = "ментальная схема",
            definition = "מִבְנֶה פְּנִימִי הַמְּאַרְגֵּן יְדִיעוֹת עַל עוֹלָם, אֲנָשִׁים אוֹ מַצָּבִים.",
            definitionNative = "Внутренняя структура, упорядочивающая знания о мире, людях или ситуациях.",
            example = "סְכֵמָה מֶנְטָלִית שֶׁל מִסְעָדָה מְכִינָה אוֹתָנוּ לְהַזְמָנַת אֹכֶל.",
            exampleNative = "סְכֵמָה מֶנְטָלִית ресторана готовит нас к заказу еды.",
         fillInBlankExclusions = listOf(120903L, 120904L, 120905L, 120925L)),
        WordEntity(
            id = 120909, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_attention_memory", transliteration = "shikha",
            original = "שִׁכְחָה", translation = "забывание",
            definition = "אִבּוּד הַיְכֹלֶת לִשְׁלֹף מֵידָע שֶׁנִּלְמַד אוֹ נֶחְוָה בֶּעָבָר.",
            definitionNative = "Утрата способности извлечь то, что было выучено или пережито.",
            example = "שִׁכְחָה שֶׁל שֵׁם חָדָשׁ קוֹרֵית לְכֻלָּנוּ מִדֵּי פַּעַם.",
            exampleNative = "שִׁכְחָה нового имени случается со всеми время от времени.",
         fillInBlankExclusions = listOf(120902L, 120913L, 120916L, 120923L)),
        WordEntity(
            id = 120910, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_reasoning", transliteration = "intuitziya",
            original = "אִינְטוּאִיצְיָה", translation = "интуиция",
            definition = "תְּחוּשָׁה פְּנִימִית הַמּוֹבִילָה לְהַחְלָטָה בְּלִי הֶסְבֵּר הִגָּיוֹנִי.",
            definitionNative = "Внутреннее чутьё, ведущее к решению без логического объяснения.",
            example = "הָאֵם סָמְכָה עַל אִינְטוּאִיצְיָה כְּשֶׁבָּחֲרָה אֵיךְ לְהַרְגִּיעַ אוֹתוֹ.",
            exampleNative = "Мать положилась на אִינְטוּאִיצְיָה, выбирая, как его успокоить.",
         fillInBlankExclusions = listOf(120901L, 120906L, 120907L)),
        WordEntity(
            id = 120911, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_emotions", transliteration = "kharda",
            original = "חָרְדָה", translation = "тревога",
            definition = "תְּחוּשָׁה כְּבֵדָה שֶׁל פַּחַד וּמְתַח לִקְרַאת מַשֶּׁהוּ עָתִיד וּלְלֹא וַדָּאוּת.",
            definitionNative = "Тяжёлое чувство страха и напряжения перед чем-то будущим и неясным.",
            example = "לִפְנֵי הַבְּחִינָה תָּקְפָה אוֹתוֹ חָרְדָה כְּבֵדָה מְאוֹד.",
            exampleNative = "Перед экзаменом его охватила сильная חָרְדָה.",
         fillInBlankExclusions = listOf(120912L, 120915L)),
        WordEntity(
            id = 120912, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_emotions", transliteration = "deka'on",
            original = "דֵּיכָּאוֹן", translation = "депрессия",
            definition = "מַצָּב מִתְמַשֵּׁךְ שֶׁל עַצְבוּת, חֹסֶר אֵנֶרְגְּיָה וְאַבְדָן עִנְיָן בַּחַיִּים.",
            definitionNative = "Стойкое состояние грусти, упадка сил и потери интереса к жизни.",
            example = "אַחֲרֵי הָאֲבֵדָה הִיא נָפְלָה לְדֵיכָּאוֹן וּפָנְתָה לִפְסִיכוֹלוֹג.",
            exampleNative = "После потери она впала в דֵּיכָּאוֹן и обратилась к психологу.",
        ),
        WordEntity(
            id = 120913, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_attention_memory", transliteration = "heragel",
            original = "הֵרָגֵל", translation = "привыкание; габитуация",
            definition = "יְרִידָה בִּתְגוּבָה לִגְרוּי שֶׁחוֹזֵר עַל עַצְמוֹ שׁוּב וָשׁוּב.",
            definitionNative = "Снижение реакции на сигнал, повторяющийся снова и снова.",
            example = "הֵרָגֵל לַרַעַשׁ שֶׁל הָרְחוֹב הוֹפִיעַ אַחֲרֵי שָׁבוּעַ בַּדִּירָה.",
            exampleNative = "הֵרָגֵל к шуму улицы появился через неделю в квартире.",
         fillInBlankExclusions = listOf(120902L, 120909L, 120916L, 120923L)),
        WordEntity(
            id = 120914, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_traits", transliteration = "koakh ratzon",
            original = "כּוֹחַ רָצוֹן", translation = "сила воли",
            definition = "הַיְכֹלֶת לְהַתְמִיד בִּמְשִׂימָה לַמְרוֹת פִּתּוּיִים אוֹ קְשָׁיִים.",
            definitionNative = "Способность держаться задачи, несмотря на соблазны или трудности.",
            example = "צָרִיךְ כּוֹחַ רָצוֹן רַב כְּדֵי לְהַפְסִיק לְעַשֵּׁן לָעַד.",
            exampleNative = "Нужна большая כּוֹחַ רָצוֹן, чтобы навсегда бросить курить.",
         fillInBlankExclusions = listOf(120917L, 120921L, 120924L)),
        WordEntity(
            id = 120915, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_emotions", transliteration = "metikut",
            original = "מְתִיחוּת", translation = "напряжение; стресс",
            definition = "תְּחוּשָׁה גּוּפָנִית וְנַפְשִׁית שֶׁל לַחַץ לִפְנֵי אֵרוּעַ קָשֶׁה.",
            definitionNative = "Телесное и душевное чувство сжатия перед трудным событием.",
            example = "הַמְּתִיחוּת בָּאוּלָם גָּבְרָה רֶגַע לִפְנֵי הוֹדָעַת הַתּוֹצָאוֹת.",
            exampleNative = "מְתִיחוּת в зале нарастала за миг до объявления итогов.",
        ),
        WordEntity(
            id = 120916, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_attention_memory", transliteration = "moda'ut mele'a",
            original = "מוֹדָעוּת מֶלֵאָה", translation = "осознанность; майндфулнесс",
            definition = "תְּשׂוּמַת לֵב עֲרָנִית לָרֶגַע הַזֶּה בְּלִי שִׁיפּוּט וּבְלִי הַסָּחָה.",
            definitionNative = "Бодрое внимание к настоящему мгновению без оценок и отвлечений.",
            example = "תְּרַגֵּל מוֹדָעוּת מֶלֵאָה חָמֵשׁ דַּקּוֹת בַּבֹּקֶר לִפְנֵי הָעֲבוֹדָה.",
            exampleNative = "Практикуй מוֹדָעוּת מֶלֵאָה по пять минут утром до работы.",
         fillInBlankExclusions = listOf(120902L, 120909L, 120913L, 120923L)),
        WordEntity(
            id = 120917, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_traits", transliteration = "optimiyut",
            original = "אוֹפְּטִימִיּוּת", translation = "оптимизм",
            definition = "נְטִיָּה לִרְאוֹת אֶת הַצַּד הַטּוֹב וּלְצַפּוֹת לְתוֹצָאוֹת חִיּוּבִיּוֹת.",
            definitionNative = "Склонность видеть хорошую сторону и ждать благоприятных исходов.",
            example = "הָאוֹפְּטִימִיּוּת שֶׁלָּהּ עָזְרָה לַצֶּוֶת לַעֲבֹר אֶת הַחֹדֶשׁ הַקָּשֶׁה.",
            exampleNative = "Её אוֹפְּטִימִיּוּת помогла команде пережить трудный месяц.",
         fillInBlankExclusions = listOf(120914L, 120921L, 120924L)),
        WordEntity(
            id = 120918, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_therapy", transliteration = "menganon hagana",
            original = "מֶנְגָּנוֹן הֲגָנָה", translation = "защитный механизм",
            definition = "פְּעֻלָּה לֹא מוּדַעַת שֶׁל הַנֶּפֶשׁ לְהַקְטִין כְּאֵב פְּנִימִי וּמַתָּח.",
            definitionNative = "Бессознательное действие психики ради уменьшения внутренней боли и тревоги.",
            example = "הַכְחָשָׁה הִיא מֶנְגָּנוֹן הֲגָנָה נָפוֹץ מוּל בְּשׂוֹרָה רָעָה.",
            exampleNative = "Отрицание — частый מֶנְגָּנוֹן הֲגָנָה в ответ на дурную весть.",
         fillInBlankExclusions = listOf(120919L, 120920L, 120922L)),
        WordEntity(
            id = 120919, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_therapy", transliteration = "khizuk khiyuvi",
            original = "חִיזּוּק חִיּוּבִי", translation = "позитивное подкрепление",
            definition = "מַתַּן גְּמוּל נָעִים מִיָּד אַחֲרֵי הִתְנַהֲגוּת רְצוּיָה כְּדֵי לְעוֹדֵד חֲזָרָה.",
            definitionNative = "Приятная награда сразу после желаемого поведения, чтобы оно повторялось.",
            example = "חִיזּוּק חִיּוּבִי כְּמוֹ שֶׁבַח עוֹזֵר לְיֶלֶד לִלְמֹד מָהִיר יוֹתֵר.",
            exampleNative = "חִיזּוּק חִיּוּבִי, как похвала, помогает ребёнку учиться быстрее.",
         fillInBlankExclusions = listOf(120918L, 120920L, 120922L)),
        WordEntity(
            id = 120920, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_therapy", transliteration = "asotziatziya khofshit",
            original = "אֶסוֹצְיָאצְיָה חוֹפְשִׁית", translation = "свободные ассоциации",
            definition = "טֶכְנִיקָה שֶׁבָּהּ הַמְטֻפָּל אוֹמֵר כָּל מַחֲשָׁבָה הַעוֹלָה בְּלִי סִנּוּן.",
            definitionNative = "Приём, при котором клиент говорит каждую возникшую мысль без отбора.",
            example = "פְּרוֹיְד הִשְׁתַּמֵּשׁ בְּאֶסוֹצְיָאצְיָה חוֹפְשִׁית כְּדֵי לַחְשֹׂף קוֹנְפְלִיקְטִים סְמוּיִים.",
            exampleNative = "Фрейд использовал אֶסוֹצְיָאצְיָה חוֹפְשִׁית, чтобы вскрывать скрытые конфликты.",
         fillInBlankExclusions = listOf(120918L, 120919L, 120922L)),
        WordEntity(
            id = 120921, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_traits", transliteration = "empatya",
            original = "אֶמְפַּתְיָה", translation = "эмпатия",
            definition = "הַיְכֹלֶת לְהַרְגִּישׁ וְלָבִין מַה שֶּׁעוֹבֵר עַל אָדָם אַחֵר.",
            definitionNative = "Способность чувствовать и понимать переживания другого человека.",
            example = "הָאָחוֹת גִּלְּתָה אֶמְפַּתְיָה רַבָּה כְּלַפֵּי הַחוֹלֶה הַבּוֹדֵד.",
            exampleNative = "Медсестра проявила большую אֶמְפַּתְיָה к одинокому больному.",
         fillInBlankExclusions = listOf(120914L, 120917L, 120924L)),
        WordEntity(
            id = 120922, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_therapy", transliteration = "geshtal't",
            original = "גֶּשְׁטַלְט", translation = "гештальт",
            definition = "תַּפִיסָה שֶׁל שָׁלֵם הַגָּדוֹל מִסְּכוּם הַחֲלָקִים שֶׁבּוֹ.",
            definitionNative = "Восприятие целого, которое больше суммы своих частей.",
            example = "טִפּוּל גֶּשְׁטַלְט מַדְגִּישׁ אֶת הָרֶגַע הַזֶּה וְלֹא אֶת הֶעָבָר.",
            exampleNative = "Терапия גֶּשְׁטַלְט делает упор на «здесь и сейчас», а не на прошлое.",
         fillInBlankExclusions = listOf(120918L, 120919L, 120920L)),
        WordEntity(
            id = 120923, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_attention_memory", transliteration = "hasakhat da'at",
            original = "הַסָּחַת דַּעַת", translation = "отвлечение внимания",
            definition = "מַעֲבָר לֹא רְצוּי שֶׁל הַמַּחֲשָׁבָה מִמְּשִׂימָה לִגְרוּי צְדָדִי.",
            definitionNative = "Невольный сдвиг мысли с задачи на постороннее раздражение.",
            example = "הַסָּחַת דַּעַת קְצָרָה גָּרְמָה לוֹ לְהַחְמִיץ אֶת הַתַּחֲנָה.",
            exampleNative = "Короткое הַסָּחַת דַּעַת заставило его пропустить нужную остановку.",
         fillInBlankExclusions = listOf(120902L, 120909L, 120913L, 120916L)),
        WordEntity(
            id = 120924, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_traits", transliteration = "kafyatiut",
            original = "כַּפְיָתִיּוּת", translation = "компульсивность",
            definition = "נְטִיָּה לַחֲזֹר עַל פְּעֻלּוֹת בְּלִי יְכֹלֶת לְהַפְסִיק אוֹתָן.",
            definitionNative = "Склонность повторять одни и те же действия, не умея остановиться.",
            example = "כַּפְיָתִיּוּת שֶׁל שְׁטִיפַת יָדַיִם תְּכוּפָה מַפְרִיעָה לוֹ בָּעֲבוֹדָה.",
            exampleNative = "כַּפְיָתִיּוּת с частым мытьём рук мешает ему на работе.",
         fillInBlankExclusions = listOf(120914L, 120917L, 120921L)),
        WordEntity(
            id = 120925, setId = 1209, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "psych_cognition", transliteration = "kognitziya hevratit",
            original = "קוֹגְנִיצְיָה חֶבְרָתִית", translation = "социальная когниция",
            definition = "הָאֹפֶן שֶׁבּוֹ אֲנָשִׁים מְפָרְשִׁים, זוֹכְרִים וְשׁוֹפְטִים זֶה אֶת זֶה.",
            definitionNative = "Способ, которым люди трактуют, запоминают и оценивают друг друга.",
            example = "קוֹגְנִיצְיָה חֶבְרָתִית לְקוּיָה גּוֹרֶמֶת לְאִי הֲבָנוֹת בָּעֲבוֹדָה הַיּוֹמְיוֹמִית.",
            exampleNative = "Слабая קוֹגְנִיצְיָה חֶבְרָתִית порождает недопонимания в обычной работе.",
         fillInBlankExclusions = listOf(120903L, 120904L, 120905L, 120908L)),

        // ── Set 1210: Нейронаука ───────────────────────────────────────────

        // EPIC (C1),

        // RARE (B2),

        // EPIC (C1),

        // ── Set 1211: Генетика ─────────────────────────────────────────────

        // EPIC (C1),

        // RARE (B2),

        // EPIC (C1),
    )
}
