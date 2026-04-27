package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Бюрократия и документы", уровень L5 (носитель языка).
 *
 * Set 1811: «Бюрократия и документы» — носитель языка (EPIC + LEGENDARY).
 *           Верховный суд и БАГАЦ, апелляционные процедуры, конституционные
 *           основы, государственный контроль, продвинутая правовая терминология.
 *
 * Аудитория — русскоязычные юристы, журналисты-правоведы, аспиранты
 * правовых факультетов, чиновники высокого ранга в Израиле. Лексика
 * реальная, та, что встречается в израильских юридических журналах,
 * решениях БАГАЦа и в комментариях к Основным законам Израиля.
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   bureau_high_court — верховная судебная инстанция:
 *     Верховный суд, прецедентное решение, БАГАЦ, последняя инстанция,
 *     судебная компетенция
 *   bureau_appeals — апелляционные процедуры:
 *     отказ in limine, разрешение на апелляцию, повторное слушание,
 *     приостановка исполнения, преюдиция
 *   bureau_constitution — конституционные основы:
 *     Основной закон, оговорка о преодолении, вечная статья,
 *     защита прав, конституционное право
 *   bureau_state_audit — государственный контроль:
 *     Госконтролёр, следственная комиссия, регуляторный регламент,
 *     контрольный отчёт, игнорирование выводов
 *   bureau_top_legal — продвинутая правовая терминология:
 *     доктрина ничтожности, парламентский иммунитет, типовой договор,
 *     приказ совершить действие, муниципальный устав
 *
 * Word IDs: setId × 100 + position (181101..181125).
 *
 * Не пересекается со словами в L1-L4 наборах темы «Бюрократия и документы»
 * (1807-1810, параллельная разработка), а также с темами «Право» (1703,
 * 1063, 1064, 1089, 1195, 1278, 1279, 1495, 1496, 1537) и «Политика» (1707,
 * 1069, 1119, 1177, 1190, 1204, 1275-1277, 1493-1494, 1528, 1545). Несколько
 * core-терминов (חוֹק יְסוֹד, חֻקָּה, סַמְכוּת שִׁפּוּטִית, עִרְעוּר) уже
 * встречаются в темах «Право»/«Алия и Израиль»/«Политика» — здесь они
 * представлены либо синонимичной фразой, либо в составе более продвинутого
 * термина (פִּסְקַת הִתְגַּבְּרוּת, הַחְזָרָה לְעַרְכָּאָה קַמָּא и т.п.).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них
 * отключён, пока LLM-pipeline не пройдёт по набору и не проставит
 * fillInBlankExclusions (см. docs/claude/fill-in-blank-pipeline.md).
 */
object WordDataHebrewBureauL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1811, languagePair = "he-ru", orderIndex = 1811,
            name = "Бюрократия и документы",
            description = "Носитель: верховный суд, апелляции, конституция, госконтроль",
            topic = "Бюрократия и документы", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1811 — Бюрократия и документы: носитель языка (L5, EPIC+LEGENDARY)
        // 5 групп × 5 слов: high_court, appeals, constitution, state_audit, top_legal
        // ══════════════════════════════════════════════════════════════════════

        // ── bureau_high_court (5) — верховная судебная инстанция ──
        WordEntity(
            id = 181101, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_high_court", transliteration = "бэйт hа-мишпат hа-эльйон",
            original = "בֵּית הַמִּשְׁפָּט הָעֶלְיוֹן", translation = "Верховный суд",
            definition = "הָעַרְכָּאָה הַגְּבוֹהָה בְּיוֹתֵר בְּיִשְׂרָאֵל לְעֶרְעוּרִים וְלִשְׁאֵלוֹת חוּקָּה.",
            definitionNative = "Высшая судебная инстанция Израиля по апелляциям и конституционным вопросам.",
            example = "בֵּית הַמִּשְׁפָּט הָעֶלְיוֹן קִבֵּעַ הֲלָכָה חֲדָשָׁה בָּעִנְיָן.",
            exampleNative = "בֵּית הַמִּשְׁפָּט הָעֶלְיוֹן установил новый прецедент по делу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181102, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_high_court", transliteration = "hахлата такдимит",
            original = "הַחְלָטָה תַּקְדִּימִית", translation = "прецедентное решение",
            definition = "פְּסַק דִּין שֶׁמְּשַׁמֵּשׁ דֻּגְמָה מְחַיֶּבֶת לְבָתֵּי מִשְׁפָּט בִּתְיֵקִים דּוֹמִים.",
            definitionNative = "Решение, ставшее обязательным образцом для нижестоящих судов в схожих делах.",
            example = "הַהַחְלָטָה תַּקְדִּימִית שִׁנְּתָה אֶת גִּבּוּשׁ הַזְּכֻיּוֹת בִּמְקוֹם הָעֲבוֹדָה.",
            exampleNative = "הַחְלָטָה תַּקְדִּימִית изменила понимание прав на рабочем месте.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181103, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "bureau_high_court", transliteration = "багац",
            original = "בַּג\"ץ", translation = "БАГАЦ (Высший суд справедливости)",
            definition = "כִּנּוּי לְבֵית הַמִּשְׁפָּט הָעֶלְיוֹן כְּשֶׁדָּן בַּעֲתִירוֹת נֶגֶד רָשׁוּיוֹת הַשִּׁלְטוֹן.",
            definitionNative = "Так зовут Верховный суд, когда тот рассматривает иски против органов власти.",
            example = "עוֹתְרִים פָּנוּ לַבַּג\"ץ נֶגֶד הַחְלָטַת הַשַּׂר.",
            exampleNative = "Истцы обратились в בַּג\"ץ против решения министра.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181104, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_high_court", transliteration = "арка'а ахарона",
            original = "עַרְכָּאָה אַחֲרוֹנָה", translation = "последняя инстанция",
            definition = "בֵּית הַדִּין הָאַחֲרוֹן שֶׁאֶפְשָׁר לִפְנוֹת אֵלָיו לִפְנֵי שֶׁהַתַּיק נִסְגָּר סוֹפִית.",
            definitionNative = "Последняя судебная инстанция, куда можно обратиться до окончательного закрытия дела.",
            example = "הָעוֹתֵר הִגִּיעַ לְעַרְכָּאָה אַחֲרוֹנָה אַחֲרֵי שָׁנִים שֶׁל הִתְדַּיְּנוּת.",
            exampleNative = "Истец дошёл до עַרְכָּאָה אַחֲרוֹנָה после многих лет тяжб.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181105, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_high_court", transliteration = "самхут шипутит",
            original = "סַמְכוּת שִׁפּוּטִית", translation = "судебная компетенция",
            definition = "הַזְּכוּת הַחוּקִית שֶׁל בֵּית מִשְׁפָּט מְסֻיָּם לָדוּן בְּסוּג מְסֻיָּם שֶׁל תְּיֵקִים.",
            definitionNative = "Право конкретного суда рассматривать определённый круг дел по закону.",
            example = "הַסַּמְכוּת הַשִּׁפּוּטִית בָּעִנְיָן הַזֶּה שַׁיֶּכֶת לְבֵית הַדִּין לַעֲבוֹדָה.",
            exampleNative = "סַמְכוּת שִׁפּוּטִית по этому делу принадлежит трудовому трибуналу.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_appeals (5) — апелляционные процедуры ──
        WordEntity(
            id = 181106, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_appeals", transliteration = "дхия аль hа-саф",
            original = "דְּחִיָּה עַל הַסַּף", translation = "отказ in limine (без рассмотрения)",
            definition = "סִילּוּק תְּבִיעָה כְּבָר בִּתְחִלָּתָהּ בְּלִי לִבְחוֹן אוֹתָהּ לְגֻפָּהּ שֶׁל הַטַּעֲנָה.",
            definitionNative = "Отклонение иска в самом начале без проверки его по существу.",
            example = "הַשּׁוֹפֵט הוֹרָה עַל דְּחִיָּה עַל הַסַּף בְּשֶׁל הֶעְדֵּר עִילָּה.",
            exampleNative = "Судья постановил דְּחִיָּה עַל הַסַּף ввиду отсутствия основания.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181107, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_appeals", transliteration = "бакашат ршут леар'эа",
            original = "בַּקָּשַׁת רְשׁוּת לְעַרֵּעַ", translation = "ходатайство о разрешении на апелляцию",
            definition = "פְּנִיָּה רִשְׁמִית לְבֵית מִשְׁפָּט גָּבוֹהַּ יוֹתֵר כְּדֵי לְקַבֵּל הֶיתֵּר לִפְתֹּחַ הֲלִיךְ.",
            definitionNative = "Официальная просьба к вышестоящему суду разрешить открыть апелляционное производство.",
            example = "עוֹרֵךְ הַדִּין הִגִּישׁ בַּקָּשַׁת רְשׁוּת לְעַרֵּעַ לְבֵית הַמִּשְׁפָּט הָעֶלְיוֹן.",
            exampleNative = "Адвокат подал בַּקָּשַׁת רְשׁוּת לְעַרֵּעַ в Верховный суд.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181108, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_appeals", transliteration = "диюн носаф",
            original = "דִּיּוּן נוֹסָף", translation = "повторное слушание (расширенным составом)",
            definition = "הֲלִיךְ נָדִיר שֶׁבּוֹ הֶרְכֵּב מוּרְחָב שָׁב לִשְׁפֹּט תַּיק שֶׁכְּבָר נֶחְתַּם.",
            definitionNative = "Редкая процедура, когда расширенный состав судей пересматривает уже закрытое дело.",
            example = "הַנָּשִׂיא אִשֵּׁר דִּיּוּן נוֹסָף בִּגְלַל חֲשִׁיבוּת הַשְּׁאֵלָה.",
            exampleNative = "Председатель утвердил דִּיּוּן נוֹסָף ввиду важности правового вопроса.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181109, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_appeals", transliteration = "ацират бицуа",
            original = "עֲצִירַת בִּצּוּעַ", translation = "приостановка исполнения (решения)",
            definition = "צַו זְמַנִּי הַמַּשְׁהֶה אֶת הוֹצָאַת פְּסַק הַדִּין לַפֹּעַל עַד הַכְרָעַת הָעֶרְעוּר.",
            definitionNative = "Временный приказ, что замораживает приведение решения в исполнение до итога апелляции.",
            example = "הַשּׁוֹפֵט נָתַן עֲצִירַת בִּצּוּעַ עַד שֶׁיּוּכְרַע הָעֶרְעוּר.",
            exampleNative = "Судья дал עֲצִירַת בִּצּוּעַ до решения по апелляции.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181110, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_appeals", transliteration = "маасэ бэйт дин",
            original = "מַעֲשֵׂה בֵּית דִּין", translation = "преюдиция (res judicata)",
            definition = "כְּלָל שֶׁלֹּא דָנִים שׁוּב בְּעִנְיָן שֶׁכְּבָר הֻכְרַע סוֹפִית עַל יְדֵי הַשּׁוֹפֵט.",
            definitionNative = "Правило, что нельзя заново судить дело, уже окончательно разрешённое судьёй.",
            example = "הַתְּבִיעָה נִדְחֲתָה בִּגְלַל מַעֲשֵׂה בֵּית דִּין מִתַּיק קוֹדֵם.",
            exampleNative = "Иск отклонили из-за מַעֲשֵׂה בֵּית דִּין по предыдущему делу.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_constitution (5) — конституционные основы ──
        WordEntity(
            id = 181111, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_constitution", transliteration = "хок йесод",
            original = "חוֹק יְסוֹד", translation = "Основной закон",
            definition = "חוֹק בַּעַל מַעֲמָד עַל-חוּקִּי הַמְּעַצֵּב אֶת מָבְנֵה הַשִּׁלְטוֹן וְזַכֻיּוֹת הָאָדָם.",
            definitionNative = "Закон высшего ранга, что задаёт устройство власти и права человека в стране.",
            example = "חוֹק יְסוֹד מַגֵּן עַל כְּבוֹד הָאָדָם וְעַל חֵרוּתוֹ הַבָּסִיסִית.",
            exampleNative = "חוֹק יְסוֹד защищает достоинство человека и его свободу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181112, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_constitution", transliteration = "пискат hитгабрут",
            original = "פִּסְקַת הִתְגַּבְּרוּת", translation = "оговорка о преодолении (override clause)",
            definition = "סְעִיף הַמְּאַפְשֵׁר לְכְּנֶסֶת לְחוֹקֵק חוֹק לַמְרוֹת פְּסִילָתוֹ עַל יְדֵי בֵּית הַמִּשְׁפָּט.",
            definitionNative = "Статья, что разрешает Кнессету принять закон вопреки его отмене Верховным судом.",
            example = "הַוִּיכּוּחַ עַל פִּסְקַת הִתְגַּבְּרוּת פִּלֵּג אֶת הַחֶבְרָה הַיִּשְׂרְאֵלִית.",
            exampleNative = "Спор о פִּסְקַת הִתְגַּבְּרוּת расколол израильское общество.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181113, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_constitution", transliteration = "сэиф ницхи",
            original = "סְעִיף נִצְחִי", translation = "вечная статья (неизменяемая)",
            definition = "פִּסְקָה בַּחוֹק שֶׁאִי אֶפְשָׁר לְשַׁנּוֹת אוֹתָהּ גַּם בְּרֹב גָּדוֹל מְאוֹד שֶׁל מְחוֹקְקִים.",
            definitionNative = "Статья закона, что нельзя изменить даже очень большим большинством голосов в парламенте.",
            example = "הַחֻקָּה הַגֶּרְמָנִית כּוֹלֶלֶת סְעִיף נִצְחִי עַל כְּבוֹד הָאָדָם.",
            exampleNative = "Германская конституция содержит סְעִיף נִצְחִי о достоинстве человека.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181114, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_constitution", transliteration = "hагнат зхуйот",
            original = "הֲגָנַת זְכֻיּוֹת", translation = "защита прав (фундаментальных)",
            definition = "מִנְגָּנוֹן מִשְׁפָּטִי הַשּׁוֹמֵר עַל חֵרוּת הַפְּרָט מִפְּגִיעָה שֶׁל הָרָשׁוּת אוֹ אַחֵר.",
            definitionNative = "Юридический механизм, что охраняет свободу человека от посягательств власти или другого.",
            example = "הֲגָנַת זְכֻיּוֹת הִיא יְסוֹד מֶרְכָּזִי שֶׁל הַשִּׁיטָה הַדֵּמוֹקְרָטִית.",
            exampleNative = "הֲגָנַת זְכֻיּוֹת — центральная основа демократической системы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181115, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_constitution", transliteration = "мишпат хукати",
            original = "מִשְׁפָּט חֻקָּתִי", translation = "конституционное право (отрасль)",
            definition = "עָנָף שֶׁל הַמִּשְׁפָּט הָעוֹסֵק בְּמָבְנֵה הַשִּׁלְטוֹן וּבִיחֲסֵי הָרָשׁוּיוֹת זוֹ לָזוֹ.",
            definitionNative = "Отрасль права, что изучает устройство власти и взаимоотношения её ветвей.",
            example = "הִיא מְלַמֶּדֶת מִשְׁפָּט חֻקָּתִי בְּאוּנִיבֶרְסִיטָה הָעִבְרִית.",
            exampleNative = "Она преподаёт מִשְׁפָּט חֻקָּתִי в Еврейском университете.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_state_audit (5) — государственный контроль ──
        WordEntity(
            id = 181116, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_state_audit", transliteration = "мевакер hа-мдина",
            original = "מְבַקֵּר הַמְּדִינָה", translation = "Государственный контролёр Израиля",
            definition = "פָּקִיד עַצְמָאִי הַבּוֹדֵק אֵיךְ גּוּפֵי הַשִּׁלְטוֹן מִתְנַהֲלִים וּמְפַרְסֵם דּוּחוֹת.",
            definitionNative = "Независимое должностное лицо, что проверяет работу госорганов и публикует отчёты.",
            example = "מְבַקֵּר הַמְּדִינָה חָשַׂף לִיקּוּיִים חֲמוּרִים בְּמִשְׂרַד הַתַּחְבּוּרָה.",
            exampleNative = "מְבַקֵּר הַמְּדִינָה вскрыл серьёзные нарушения в министерстве транспорта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181117, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_state_audit", transliteration = "ваадат хакира",
            original = "וַעֲדַת חֲקִירָה", translation = "следственная комиссия (государственная)",
            definition = "צֶוֶת רִשְׁמִי שֶׁמּוֹקָם כְּדֵי לִבְדּוֹק אֵרוּעַ חָמוּר וּלְהַמְלִיץ עַל אַחְרָיוּת.",
            definitionNative = "Официальный коллектив, созданный для разбора серьёзного происшествия и оценки ответственности.",
            example = "וַעֲדַת חֲקִירָה מַמְלַכְתִּית הוּקְמָה אַחֲרֵי הָאָסוֹן בְּמֵירוֹן.",
            exampleNative = "После трагедии в Мероне создали государственную וַעֲדַת חֲקִירָה.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181118, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_state_audit", transliteration = "нohель асдара",
            original = "נוֹהֵל אַסְדָּרָה", translation = "регуляторный регламент",
            definition = "מִסְמָךְ פְּנִימִי שֶׁל מִשְׂרָד מֶמְשַׁלְתִּי הַקּוֹבֵעַ אֵיךְ הַתַּהֲלִיךְ צָרִיךְ לִקְרוֹת.",
            definitionNative = "Внутренний документ ведомства, что задаёт, как должна идти процедура.",
            example = "הַנּוֹהֵל אַסְדָּרָה הַחָדָשׁ קוֹבֵעַ זְמַנֵּי תְּגוּבָה לְבַקָּשׁוֹת הַצִּבּוּר.",
            exampleNative = "Новый נוֹהֵל אַסְדָּרָה задаёт сроки ответа на обращения граждан.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181119, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_state_audit", transliteration = "дуах бикорет",
            original = "דּוּחַ בִּקֹּרֶת", translation = "контрольный отчёт (аудиторский)",
            definition = "מִסְמָךְ פּוּמְבִּי הַמְּתָאֵר מַמְצָאִים שֶׁל בְּדִיקָה רִשְׁמִית עַל גּוּף שִׁלְטוֹנִי.",
            definitionNative = "Открытый документ, описывающий выводы официальной проверки органа власти.",
            example = "דּוּחַ בִּקֹּרֶת חָמוּר חָשַׂף בִּזְבּוּז כְּסָפִים בָּעִירִיָּה.",
            exampleNative = "Жёсткий דּוּחַ בִּקֹּרֶת вскрыл растрату средств в мэрии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181120, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_state_audit", transliteration = "hит'алмут ми-мамца'им",
            original = "הִתְעַלְּמוּת מִמַּמְצָאִים", translation = "игнорирование выводов (контролёра)",
            definition = "כְּשֶׁרָשׁוּת לֹא מַתְקֶנֶת לִיקּוּיִים שֶׁדּוּחַ רִשְׁמִי הִצְבִּיעַ עֲלֵיהֶם.",
            definitionNative = "Когда ведомство не исправляет нарушения, на которые указал официальный отчёт.",
            example = "הִתְעַלְּמוּת מִמַּמְצָאִים שֶׁל הַמְּבַקֵּר עוֹרֶרֶת כַּעַס צִבּוּרִי גָּדוֹל.",
            exampleNative = "הִתְעַלְּמוּת מִמַּמְצָאִים контролёра вызывает большое возмущение публики.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_top_legal (5) — продвинутая правовая терминология ──
        WordEntity(
            id = 181121, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_top_legal", transliteration = "доктринат битлут",
            original = "דּוֹקְטְרִינַת בִּטְלוּת", translation = "доктрина ничтожности",
            definition = "תּוֹרָה מִשְׁפָּטִית הַקּוֹבַעַת מָתַי פְּעוּלָה שִׁלְטוֹנִית נֶחְשֶׁבֶת חַסְרַת תֹּקֶף מִלְּכַתְּחִילָה.",
            definitionNative = "Учение, что определяет, когда властное действие изначально лишено силы.",
            example = "הַשּׁוֹפֵט יִישֵּׂם דּוֹקְטְרִינַת בִּטְלוּת עַל הַמִּכְרָז הַפָּגוּם.",
            exampleNative = "Судья применит דּוֹקְטְרִינַת בִּטְלוּת к порочному тендеру.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181122, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_top_legal", transliteration = "хасинут парламентарит",
            original = "חֲסִינוּת פַּרְלָמֶנְטָרִית", translation = "парламентский иммунитет",
            definition = "הֲגָנָה מִשְׁפָּטִית מְיֻחֶדֶת לְחֶבְרֵי כְּנֶסֶת מִפְּנֵי תְּבִיעוֹת בִּגְלַל פְּעִילוּתָם הַצִּבּוּרִית.",
            definitionNative = "Особая защита депутатов от исков и преследований за их публичную деятельность.",
            example = "הוּא נִיצֵּל חֲסִינוּת פַּרְלָמֶנְטָרִית כְּדֵי לְהָגֵן עַל הַצְהָרוֹתָיו.",
            exampleNative = "Он использовал חֲסִינוּת פַּרְלָמֶנְטָרִית, чтобы прикрыть свои заявления.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181123, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_top_legal", transliteration = "хозэ ахид",
            original = "חוֹזֶה אָחִיד", translation = "типовой договор (присоединения)",
            definition = "טֹפֶס מוּכָן מֵרֹאשׁ שֶׁחֶבְרָה גְּדוֹלָה מַצִּיגָה לַלָּקוֹחַ בְּלִי אֶפְשָׁרוּת לְשַׁנּוֹת אוֹתוֹ.",
            definitionNative = "Бланк, заранее заготовленный фирмой и предлагаемый клиенту без права изменить условия.",
            example = "הַחוֹזֶה אָחִיד שֶׁל הַבַּנְק נִבְדַּק עַל יְדֵי בֵּית הַדִּין הַמְּיֻחָד.",
            exampleNative = "חוֹזֶה אָחִיד банка проверил особый трибунал.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181124, setId = 1811, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_top_legal", transliteration = "цав асэ",
            original = "צַו עֲשֵׂה", translation = "приказ совершить действие",
            definition = "הוֹרָאָה שִׁפּוּטִית הַמְּחַיֶּבֶת אָדָם אוֹ רָשׁוּת לַעֲשׂוֹת מַעֲשֶׂה מְסֻיָּם וּפָעִיל.",
            definitionNative = "Судебное предписание, что обязывает лицо или орган совершить конкретное активное действие.",
            example = "בֵּית הַמִּשְׁפָּט הוֹצִיא צַו עֲשֵׂה לִפְנוֹת אֶת הַמִּתְקָן הַסָּגוּר.",
            exampleNative = "Суд издал צַו עֲשֵׂה об освобождении закрытого помещения.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181125, setId = 1811, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_top_legal", transliteration = "такнон ирони",
            original = "תַּקָּנוֹן עִירוֹנִי", translation = "муниципальный устав (подзаконный)",
            definition = "אֹסֶף כְּלָלִים מְקוֹמִיִּים שֶׁמּוֹעֶצֶת הָעִיר חוֹקֶקֶת לְהַסְדָּרַת הַחַיִּים בָּעִיר.",
            definitionNative = "Свод местных правил, что городской совет принимает для упорядочивания жизни в городе.",
            example = "הַתַּקָּנוֹן עִירוֹנִי אוֹסֵר רַעַשׁ בִּשְׁעוֹת הַמְּנוּחָה הַצְּהָרַיִם.",
            exampleNative = "תַּקָּנוֹן עִירוֹנִי запрещает шум в обеденные часы тишины.",
            isFillInBlankSafe = false,
        ),
    )
}
