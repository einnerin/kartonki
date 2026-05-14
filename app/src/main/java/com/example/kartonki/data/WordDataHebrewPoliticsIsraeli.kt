package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1909 (he-ru).
 * Политика: израильская политическая система (L3 / UNCOMMON + RARE).
 *
 * Точечное расширение темы «Политика» в he-ru — рядом с существующими сетами
 * 1069 (L2, базовая лексика), 1275/1276/1277 (L3-L5, идеологии и теория),
 * 1707 (L1, основы). Фокус — на конкретные институты, партии, выборы,
 * фракции и процессы Государства Израиль. Особо полезно репатриантам,
 * которые читают новости и хотят разобраться, кто такой Багац, что такое
 * אַחוּז חֲסִימָה и почему распускают Кнессет.
 *
 * Не пересекается со словами в существующих he-ru сетах темы «Политика»:
 *   - בְּחִירוֹת, כְּנֶסֶת, שַׂר, מֶמְשָׁלָה, מִפְלָגָה, נָשִׂיא,
 *     רֹאשׁ הַמֶּמְשָׁלָה, חָבֵר כְּנֶסֶת, אוֹפּוֹזִיצְיָה, קוֹאַלִיצְיָה,
 *     הַצְבָּעָה, מַנְדָּט, סִיעָה, וַעֲדָה, דֵּמוֹקְרָטְיָה, פּוֹלִיטִיקָה
 *     и др. — всё уже в 1069/1707, поэтому здесь берём более узкое:
 *     названия конкретных партий, конкретных комиссий, конкретные этапы
 *     избирательного цикла, конкретные ветви власти.
 *   - בֵּית הַמִּשְׁפָּט הָעֶלְיוֹן уже в BureauL5 → заменён на בָּג"ץ
 *     (Высший суд справедливости — узкая ипостась того же органа).
 *   - מְבַקֵּר הַמְּדִינָה уже в BureauL5 → не включён.
 *   - מֶרְכָּז (центр) — общее слово, есть в Transport → используется
 *     только в значении «политический центр» внутри examples, но не
 *     как original.
 *
 * Подача — нейтральная, учебниковая (как в курсе гражданства):
 *   - Партии описаны структурно (правоцентристская / лейбористская /
 *     ультраортодоксальная сефардская и т. д.), без оценок.
 *   - Институты — функция, состав, число членов.
 *   - Процессы — что и когда происходит, без обвинений.
 *
 * Распределение редкости (2 смежных уровня, валидатор validate_rarity_spread):
 *   UNCOMMON — 12 слов (A2-B1, регулярно встречающиеся в новостных
 *     заголовках): партии (6), большая часть выборного цикла (4),
 *     отставка, опрос.
 *   RARE — 13 слов (B2, требуют знакомства со структурой государства):
 *     ветви власти, юр.советник, спикер Кнессета, БАГАЦ, проходной
 *     барьер, коалиционное соглашение, комиссии, формирование/роспуск
 *     правительства, переходное правительство, вотум недоверия.
 *
 * Пять семантических подгрупп:
 *   politics_il_institutions — 5 слов: БАГАЦ, исп./зак. власть,
 *     юр.советник правительства, спикер Кнессета
 *   politics_il_parties — 6 слов: Ликуд, Партия труда, Йеш Атид, ШАС,
 *     Яhадут ха-Тора, Государственный лагерь
 *   politics_il_elections — 5 слов: проходной барьер, бюллетень, урна,
 *     день выборов, предвыборный опрос
 *   politics_il_coalition — 4 слова: коалиц.соглашение, оппоз.фракции,
 *     комиссия по обороне, фин.комиссия
 *   politics_il_processes — 5 слов: формирование правительства, роспуск
 *     Кнессета, вотум недоверия, отставка, переходное правительство
 *
 * Word IDs: 190901..190925 (setId × 100 + position).
 */
object WordDataHebrewPoliticsIsraeli {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1909, languagePair = "he-ru", orderIndex = 1909,
            name = "Политика",
            description = "Израильская политсистема: בָּג\"ץ, לִיכוּד, שַׁ\"ס, אַחוּז חֲסִימָה, אִי-אֵמוּן, פִּזּוּר הַכְּנֶסֶת.",
            topic = "Политика",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: politics_il_institutions (5 words) ─────────────────────────

        WordEntity(id = 190901, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "בָּג\"ץ",
            translation = "Багац; Высший суд справедливости",
            definition = "כִּנּוּי לְבֵית הַמִּשְׁפָּט הַזֶּה כְּשֶׁהוּא דָּן בְּעַתִּירוֹת נֶגֶד רָשׁוּיוֹת הַמְּדִינָה.",
            definitionNative = "Прозвание Верховного суда, когда он разбирает иски против органов власти.",
            example = "הָאַגֻדָּה הִגִּישָׁה עַתִּירָה לְבָג\"ץ עַל הֶחְלָטַת הַשַּׂר.",
            exampleNative = "Объединение подало петицию в בָּג\"ץ против решения министра.",
            transliteration = "багац",
            pos = "noun", semanticGroup = "politics_il_institutions"),

        WordEntity(id = 190902, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "הָרְשׁוּת הַמְּבַצַּעַת",
            translation = "исполнительная власть",
            definition = "זְרוֹעַ הַשִּׁלְטוֹן שֶׁמּוֹצִיאָה לְפֹעַל אֶת הַחֻקִּים — מֶמְשָׁלָה וּמִשְׂרָדֶיהָ.",
            definitionNative = "Ветвь власти, которая воплощает законы в жизнь — правительство и его ведомства.",
            example = "הָרְשׁוּת הַמְּבַצַּעַת אֲחֲרָאִית עַל הַתַּקְצִיב הַשּׁוֹטֵף.",
            exampleNative = "הָרְשׁוּת הַמְּבַצַּעַת отвечает за текущий бюджет.",
            transliteration = "hа-ршут hа-мевацаат",
            pos = "phrase", semanticGroup = "politics_il_institutions", fillInBlankExclusions = listOf(190903L, 190904L, 190905L)),

        WordEntity(id = 190903, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "הָרְשׁוּת הַמְּחוֹקֶקֶת",
            translation = "законодательная власть",
            definition = "זְרוֹעַ הַשִּׁלְטוֹן שֶׁמְּחוֹקֶקֶת חֻקִּים — בְּיִשְׂרָאֵל זוֹ הַכְּנֶסֶת בַּת 120 הַחֲבָרִים.",
            definitionNative = "Ветвь власти, что издаёт законы; в Израиле это Кнессет из 120 членов.",
            example = "הָרְשׁוּת הַמְּחוֹקֶקֶת אִשְּׁרָה אֶת הַתִּקּוּן לְחֹק יְסוֹד.",
            exampleNative = "הָרְשׁוּת הַמְּחוֹקֶקֶת утвердила поправку к Основному закону.",
            transliteration = "hа-ршут hа-мехокекет",
            pos = "phrase", semanticGroup = "politics_il_institutions", fillInBlankExclusions = listOf(190902L, 190904L, 190905L)),

        WordEntity(id = 190904, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "הַיּוֹעֵץ הַמִּשְׁפָּטִי",
            translation = "юридический советник правительства",
            definition = "פָּקִיד בָּכִיר שֶׁמְּיַעֵץ לַמֶּמְשָׁלָה בְּשְׁאֵלוֹת חֹק וּמְיַצֵּג אֶת הַמְּדִינָה בְּבֵית הַמִּשְׁפָּט.",
            definitionNative = "Высокий чиновник, что консультирует правительство по правовым вопросам и представляет страну в суде.",
            example = "הַיּוֹעֵץ הַמִּשְׁפָּטִי הִתְנַגֵּד לְהַצָּעַת הַחֹק הַחֲדָשָׁה.",
            exampleNative = "הַיּוֹעֵץ הַמִּשְׁפָּטִי возразил против нового законопроекта.",
            transliteration = "hа-йоэц hа-мишпати",
            pos = "phrase", semanticGroup = "politics_il_institutions", fillInBlankExclusions = listOf(190902L, 190903L, 190905L)),

        WordEntity(id = 190905, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "יוֹשֵׁב רֹאשׁ הַכְּנֶסֶת",
            translation = "спикер Кнессета",
            definition = "חָבֵר כְּנֶסֶת שֶׁמְּנַהֵל אֶת הַיְּשִׁיבוֹת בָּאוּלָם וְשׁוֹמֵר עַל סְדָרֵי הַדִּיּוּן.",
            definitionNative = "Депутат, что ведёт заседания в зале и следит за порядком обсуждений.",
            example = "יוֹשֵׁב רֹאשׁ הַכְּנֶסֶת קָבַע אֶת סְדַר הַיּוֹם לַשָּׁבוּעַ.",
            exampleNative = "יוֹשֵׁב רֹאשׁ הַכְּנֶסֶת определил повестку на неделю.",
            transliteration = "йошэв рош hа-кнэсет",
            pos = "phrase", semanticGroup = "politics_il_institutions", fillInBlankExclusions = listOf(190902L, 190903L, 190904L)),

        // ── Group: politics_il_parties (6 words) ──────────────────────────────

        WordEntity(id = 190906, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "לִיכוּד",
            translation = "Ликуд",
            definition = "מִפְלָגָה יְמָנִית מֶרְכָּזִית שֶׁהֻקְמָה ב-1973 וְשׁוֹלֶטֶת בִּתְקוּפוֹת רַבּוֹת.",
            definitionNative = "Правоцентристская партия, основанная в 1973 году и часто стоявшая у власти.",
            example = "לִיכוּד זָכָה בְּרֹב הַמַּנְדָּטִים בַּסְּבָב הָאַחֲרוֹן.",
            exampleNative = "לִיכוּד получил большинство мандатов в последнем туре.",
            transliteration = "ликуд",
            pos = "noun", semanticGroup = "politics_il_parties", fillInBlankExclusions = listOf(190908L, 190909L, 190911L)),

        WordEntity(id = 190907, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִפְלֶגֶת הָעֲבוֹדָה",
            translation = "Партия труда; Авода",
            definition = "מִפְלָגָה סוֹצְיָאל-דֵּמוֹקְרָטִית וָתִיקָה, יוֹרֶשֶׁת מַפַּא\"י וּמְיַסְּדֵי הַמְּדִינָה.",
            definitionNative = "Старейшая социал-демократическая партия, преемница МАПАЙ и отцов-основателей государства.",
            example = "מִפְלֶגֶת הָעֲבוֹדָה אִבְּדָה מַנְדָּטִים בַּעֲשׂוֹר הָאַחֲרוֹן.",
            exampleNative = "מִפְלֶגֶת הָעֲבוֹדָה потеряла мандаты за последнее десятилетие.",
            transliteration = "мифлэгэт hа-авода",
            pos = "phrase", semanticGroup = "politics_il_parties", fillInBlankExclusions = listOf(190908L, 190909L, 190910L, 190911L)),

        WordEntity(id = 190908, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יֵשׁ עָתִיד",
            translation = "Йеш Атид",
            definition = "מִפְלָגַת מֶרְכָּז חִילוֹנִית שֶׁהֻקְמָה בְּ-2012 וּמְכֻוֶּנֶת לְמַעֲמַד הַבֵּינַיִם.",
            definitionNative = "Светская центристская партия, основанная в 2012 году и обращённая к среднему классу.",
            example = "יֵשׁ עָתִיד הוֹבִיל אֶת הָאוֹפּוֹזִיצְיָה בַּכְּנֶסֶת הַקּוֹדֶמֶת.",
            exampleNative = "יֵשׁ עָתִיד возглавлял оппозицию в прошлом созыве Кнессета.",
            transliteration = "йэш атид",
            pos = "phrase", semanticGroup = "politics_il_parties", fillInBlankExclusions = listOf(190906L, 190907L, 190910L, 190911L)),

        WordEntity(id = 190909, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שַׁ\"ס",
            translation = "ШАС",
            definition = "מִפְלָגָה חֲרֵדִית סְפָרַדִּית שֶׁמְּיַצֶּגֶת אֶת הַצִּבּוּר הַמִּזְרָחִי הַדָּתִי.",
            definitionNative = "Ультраортодоксальная сефардская партия, что представляет восточный религиозный электорат.",
            example = "שַׁ\"ס נִכְנְסָה לַקּוֹאַלִיצְיָה תְּמוּרַת מִשְׂרַד הַדָּתוֹת.",
            exampleNative = "שַׁ\"ס вошёл в коалицию в обмен на министерство по делам религий.",
            transliteration = "шас",
            pos = "noun", semanticGroup = "politics_il_parties", fillInBlankExclusions = listOf(190906L, 190907L, 190910L)),

        WordEntity(id = 190910, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יַהֲדוּת הַתּוֹרָה",
            translation = "Яhадут hа-Тора; Объединённый иудаизм Торы",
            definition = "מִפְלָגָה חֲרֵדִית אַשְׁכְּנַזִּית שֶׁמְּאַחֶדֶת אֶת אֲגֻדַּת יִשְׂרָאֵל וְדֶגֶל הַתּוֹרָה.",
            definitionNative = "Ашкеназская ультраортодоксальная партия, объединяющая Агудат Исраэль и Дэгэль hа-Тора.",
            example = "יַהֲדוּת הַתּוֹרָה דּוֹרֶשֶׁת תַּקְצִיב לַחֲרֵדִים בְּכָל מַשָּׂא וּמַתָּן קוֹאַלִיצְיוֹנִי.",
            exampleNative = "יַהֲדוּת הַתּוֹרָה требует бюджет харедим на каждых коалиционных переговорах.",
            transliteration = "яhадут hа-тора",
            pos = "phrase", semanticGroup = "politics_il_parties", fillInBlankExclusions = listOf(190907L, 190908L, 190909L, 190911L)),

        WordEntity(id = 190911, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַמַּחֲנֶה הַמַּמְלַכְתִּי",
            translation = "Государственный лагерь",
            definition = "אִיחוּד מִפְלָגוֹת מֶרְכָּז שֶׁהֻקַם בְּ-2022 וְכָלַל גַּם רָאשֵׁי בִּטָּחוֹן לְשֶׁעָבַר.",
            definitionNative = "Центристский партийный союз, образованный в 2022 году и включивший бывших силовиков.",
            example = "הַמַּחֲנֶה הַמַּמְלַכְתִּי הִשִּׂיג שְׁנֵים עָשָׂר מַנְדָּטִים בַּבְּחִירוֹת.",
            exampleNative = "הַמַּחֲנֶה הַמַּמְלַכְתִּי получил двенадцать мандатов на выборах.",
            transliteration = "hа-маханэ hа-мамлахти",
            pos = "phrase", semanticGroup = "politics_il_parties", fillInBlankExclusions = listOf(190906L, 190907L, 190908L, 190910L)),

        // ── Group: politics_il_elections (5 words) ────────────────────────────

        WordEntity(id = 190912, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "אַחוּז חֲסִימָה",
            translation = "электоральный (проходной) барьер",
            definition = "מִינִימוּם קוֹלוֹת שֶׁמִּפְלָגָה צְרִיכָה לְקַבֵּל כְּדֵי לְהִכָּנֵס לַכְּנֶסֶת — כַּיּוֹם 3.25%.",
            definitionNative = "Минимум голосов, что должна получить партия для входа в Кнессет; сейчас 3,25%.",
            example = "הָרְשִׁימָה הַקְּטַנָּה לֹא עָבְרָה אֶת אַחוּז חֲסִימָה וְנֶעֶלְמָה.",
            exampleNative = "Маленький список не преодолел אַחוּז חֲסִימָה и сошёл со сцены.",
            transliteration = "ахуз хасима",
            pos = "phrase", semanticGroup = "politics_il_elections", fillInBlankExclusions = listOf(190913L, 190915L, 190916L)),

        WordEntity(id = 190913, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פֶּתֶק הַצְבָּעָה",
            translation = "избирательный бюллетень",
            definition = "פִּסַּת נְיָר עִם אוֹתִיּוֹת הָרְשִׁימָה שֶׁמַּכְנִיסִים לַמַּעֲטָפָה בְּמַעֲמַד הַבְּחִירוֹת.",
            definitionNative = "Листок с буквенным кодом списка, что кладут в конверт в момент голосования.",
            example = "הוּא בָּחַר אֶת פֶּתֶק הַהַצְבָּעָה וְסָגַר אֶת הַמַּעֲטָפָה.",
            exampleNative = "Он выбрал פֶּתֶק הַצְבָּעָה и заклеил конверт.",
            transliteration = "пэтэк hацбаа",
            pos = "phrase", semanticGroup = "politics_il_elections"),

        WordEntity(id = 190914, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קַלְפִּי",
            translation = "урна для голосования",
            definition = "תֵּבָה סְגוּרָה שֶׁמְּשַׁמֶּשֶׁת לְאִסּוּף מַעֲטָפוֹת בְּזְמַן הַבְּחִירוֹת.",
            definitionNative = "Закрытый ящик, куда складывают конверты в день выборов.",
            example = "הִיא עָמְדָה בַּתּוֹר וְהִשְׁלִיכָה אֶת הַמַּעֲטָפָה לַקַּלְפִּי.",
            exampleNative = "Она простояла в очереди и опустила конверт в קַלְפִּי.",
            transliteration = "кальпи",
            pos = "noun", semanticGroup = "politics_il_elections"),

        WordEntity(id = 190915, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יוֹם הַבְּחִירוֹת",
            translation = "день выборов",
            definition = "יוֹם שְׁבָתוֹן רִשְׁמִי שֶׁבּוֹ כָּל הַקַּלְפִּיוֹת פְּתוּחוֹת וְהָאֶזְרָחִים מַצְבִּיעִים.",
            definitionNative = "Официальный выходной, когда все участки открыты и граждане голосуют.",
            example = "יוֹם הַבְּחִירוֹת נִקְבַּע לְיוֹם שְׁלִישִׁי בְּרֹב הָעֲשׂוֹרִים.",
            exampleNative = "יוֹם הַבְּחִירוֹת назначают на вторник в большинстве десятилетий.",
            transliteration = "йом hа-бхирот",
            pos = "phrase", semanticGroup = "politics_il_elections", fillInBlankExclusions = listOf(190912L, 190913L, 190916L)),

        WordEntity(id = 190916, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְקַר בְּחִירוֹת",
            translation = "предвыборный опрос",
            definition = "מֶחְקָר דַּעַת קָהָל שֶׁמּוֹדֵד אֵיךְ אֶזְרָחִים עוֹמְדִים לְהַצְבִּיעַ לִפְנֵי יוֹם הַבְּחִירוֹת.",
            definitionNative = "Опрос мнений, что меряет, как граждане собираются голосовать накануне выборов.",
            example = "סְקַר בְּחִירוֹת חָדָשׁ מֶצְבִּיעַ עַל גִּדּוּל קַל בְּמֶרְכָּז.",
            exampleNative = "Новый סְקַר בְּחִירוֹת показывает небольшой рост у центристов.",
            transliteration = "скар бхирот",
            pos = "phrase", semanticGroup = "politics_il_elections", fillInBlankExclusions = listOf(190912L, 190913L, 190915L)),

        // ── Group: politics_il_coalition (4 words) ────────────────────────────

        WordEntity(id = 190917, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "הַסְכֵּם קוֹאָלִיצְיוֹנִי",
            translation = "коалиционное соглашение",
            definition = "מִסְמָךְ כָּתוּב שֶׁמַּגְדִּיר אֶת תְּנָאֵי הַשֻּׁתָּפוּת בֵּין מִפְלָגוֹת הַמֶּמְשָׁלָה.",
            definitionNative = "Письменный документ, что закрепляет условия партнёрства между правящими партиями.",
            example = "הַסְכֵּם קוֹאָלִיצְיוֹנִי כּוֹלֵל הַתְחַיְּבוּת לְתַקְצִיב הַחִנּוּךְ הַחֲרֵדִי.",
            exampleNative = "הַסְכֵּם קוֹאָלִיצְיוֹנִי включает обязательство финансировать религиозное образование.",
            transliteration = "hэскэм коалицйони",
            pos = "phrase", semanticGroup = "politics_il_coalition", fillInBlankExclusions = listOf(190918L, 190919L, 190920L)),

        WordEntity(id = 190918, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "סִיעוֹת הָאוֹפּוֹזִיצְיָה",
            translation = "оппозиционные фракции",
            definition = "קְבוּצוֹת חֲבָרֵי הַכְּנֶסֶת שֶׁאֵינָן חֵלֶק מֵהַקּוֹאַלִיצְיָה הַשּׁוֹלֶטֶת.",
            definitionNative = "Группы депутатов, что не входят в правящую коалицию.",
            example = "סִיעוֹת הָאוֹפּוֹזִיצְיָה דָּרְשׁוּ דִּיּוּן דָּחוּף עַל הַתַּקְצִיב.",
            exampleNative = "סִיעוֹת הָאוֹפּוֹזִיצְיָה потребовали срочного обсуждения бюджета.",
            transliteration = "сиот hа-опозицья",
            pos = "phrase", semanticGroup = "politics_il_coalition", fillInBlankExclusions = listOf(190917L, 190919L, 190920L)),

        WordEntity(id = 190919, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "וַעֲדַת הַחוּץ וְהַבִּטָּחוֹן",
            translation = "комиссия по иностранным делам и обороне",
            definition = "וַעֲדַת כְּנֶסֶת רָגִישָׁה שֶׁדָּנָה בִּעִנְיָנֵי בִּטָּחוֹן וְיַחֲסֵי חוּץ בְּחֶדֶר סָגוּר.",
            definitionNative = "Закрытая парламентская комиссия, что обсуждает вопросы обороны и внешних связей.",
            example = "וַעֲדַת הַחוּץ וְהַבִּטָּחוֹן זִמְּנָה אֶת רֹאשׁ הַמּוֹסָד לְעֵדוּת.",
            exampleNative = "וַעֲדַת הַחוּץ וְהַבִּטָּחוֹן вызвала главу Моссада дать показания.",
            transliteration = "ваадат hа-хуц вэ-hа-битахон",
            pos = "phrase", semanticGroup = "politics_il_coalition", fillInBlankExclusions = listOf(190917L, 190918L, 190920L)),

        WordEntity(id = 190920, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "וַעֲדַת הַכַּסְפִּים",
            translation = "финансовая комиссия (Кнессета)",
            definition = "וַעֲדַת כְּנֶסֶת שֶׁמְּאַשֶּׁרֶת תַּקְצִיבִים וְהַעֲבָרוֹת כְּסָפִים בֵּין מִשְׂרָדִים.",
            definitionNative = "Парламентская комиссия, что утверждает бюджеты и переброску средств между ведомствами.",
            example = "וַעֲדַת הַכַּסְפִּים אִשְּׁרָה הַעֲבָרָה לְמִשְׂרַד הָרְוָחָה.",
            exampleNative = "וַעֲדַת הַכַּסְפִּים утвердила перевод в министерство соцобеспечения.",
            transliteration = "ваадат hа-ксафим",
            pos = "phrase", semanticGroup = "politics_il_coalition", fillInBlankExclusions = listOf(190917L, 190918L, 190919L)),

        // ── Group: politics_il_processes (5 words) ────────────────────────────

        WordEntity(id = 190921, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "הַקָּמַת מֶמְשָׁלָה",
            translation = "формирование правительства",
            definition = "תַּהֲלִיךְ בּוֹ הַנָּשִׂיא מַטִּיל מַנְדָּט וְהַנָּבְחָר אוֹסֵף שֻׁתָּפוֹת לְרֹב בַּכְּנֶסֶת.",
            definitionNative = "Процесс, в котором президент даёт поручение, а назначенный собирает партнёров до парламентского большинства.",
            example = "הַקָּמַת הַמֶּמְשָׁלָה לָקְחָה כִּמְעַט שִׁשָּׁה שָׁבוּעוֹת.",
            exampleNative = "הַקָּמַת מֶמְשָׁלָה заняла почти шесть недель.",
            transliteration = "hакамат мэмшала",
            pos = "phrase", semanticGroup = "politics_il_processes"),

        WordEntity(id = 190922, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "פִּזּוּר הַכְּנֶסֶת",
            translation = "роспуск Кнессета",
            definition = "סִיּוּם מֻקְדָּם שֶׁל הַכְּנֶסֶת שֶׁמַּחְזִיר אֶת הָאֶזְרָחִים לְקַלְפִּיּוֹת לִפְנֵי תּוֹם הַכַּהֲנָה.",
            definitionNative = "Досрочное прекращение Кнессета, что возвращает граждан к урнам до конца срока.",
            example = "פִּזּוּר הַכְּנֶסֶת אֻשַּׁר אַחֲרֵי מַשְׁבֵּר תַּקְצִיבִי.",
            exampleNative = "פִּזּוּר הַכְּנֶסֶת был утверждён после бюджетного кризиса.",
            transliteration = "пизур hа-кнэсет",
            pos = "phrase", semanticGroup = "politics_il_processes", fillInBlankExclusions = listOf(190921L, 190925L)),

        WordEntity(id = 190923, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "אִי-אֵמוּן",
            translation = "вотум недоверия",
            definition = "הַצְבָּעַת כְּנֶסֶת שֶׁמְּכַוֶּנֶת לְהַפִּיל אֶת הַמֶּמְשָׁלָה אִם תַּעֲבֹר בְּרֹב.",
            definitionNative = "Голосование Кнессета, что должно свалить правительство, если пройдёт большинством.",
            example = "הַצָּעַת אִי-אֵמוּן נִדְחְתָה בְּשֵׁשִׁים וְאַחַת קוֹלוֹת.",
            exampleNative = "Предложение אִי-אֵמוּן было отклонено шестьюдесятью одним голосом.",
            transliteration = "и-эмун",
            pos = "noun", semanticGroup = "politics_il_processes", fillInBlankExclusions = listOf(190924L)),

        WordEntity(id = 190924, setId = 1909, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הִתְפַּטְּרוּת",
            translation = "отставка",
            definition = "הוֹדָעָה רִשְׁמִית שֶׁל נִבְחָר עַל עֲזִיבָה מְרָצוֹן שֶׁל הַתַּפְקִיד הַצִּבּוּרִי.",
            definitionNative = "Официальное заявление избранного о добровольном уходе с государственной должности.",
            example = "הוּא הוֹדִיעַ עַל הִתְפַּטְּרוּת בִּמְסִבַּת עִתּוֹנָאִים קְצָרָה.",
            exampleNative = "Он объявил הִתְפַּטְּרוּת на короткой пресс-конференции.",
            transliteration = "hитпатрут",
            pos = "noun", semanticGroup = "politics_il_processes", fillInBlankExclusions = listOf(190923L)),

        WordEntity(id = 190925, setId = 1909, languagePair = "he-ru", rarity = "RARE",
            original = "מֶמְשֶׁלֶת מַעֲבָר",
            translation = "переходное правительство",
            definition = "מֶמְשָׁלָה מְצֻמְצֶמֶת בִּסַמְכוּיּוֹת שֶׁפּוֹעֶלֶת בֵּין פִּזּוּר כְּנֶסֶת לְהַשְׁבָּעַת חֲדָשָׁה.",
            definitionNative = "Правительство с урезанными полномочиями, что работает между роспуском Кнессета и приведением нового к присяге.",
            example = "מֶמְשֶׁלֶת מַעֲבָר אֵינָהּ יְכוֹלָה לְמַנּוֹת שׁוֹפְטִים חֲדָשִׁים.",
            exampleNative = "מֶמְשֶׁלֶת מַעֲבָר не вправе назначать новых судей.",
            transliteration = "мэмшэлэт маавар",
            pos = "phrase", semanticGroup = "politics_il_processes", fillInBlankExclusions = listOf(190921L, 190922L)),
    )
}
