package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Продуктовый менеджмент", L2 «Продвинутый» (UNCOMMON+RARE).
 *
 * Set 1778: «Продуктовый менеджмент» — продвинутый L2:
 *           процессы (agile/scrum/kanban), требования (PRD lite, edge case, criteria,
 *           mock-up, sketch), релизы (release notes, changelog, versioning, beta),
 *           ретро (lessons, action items, follow-up, blockers), коммуникация
 *           (stand-up, sync, email update, all-hands, screenshot).
 *
 * Целевая аудитория — русскоязычные джуниор/мидл PM в израильских компаниях.
 * Лексика — иврит + множество английских заимствований (אֶג׳ַייל, סְקְרָאם,
 * מוֹקאַפּ, רִילִיס נוֹטְס, סְטֶנְדְאַפּ, אוֹל-הֶנְדְּס) — как реально говорят
 * в офисах Тель-Авива и Герцлии.
 *
 * Распределение редкостей: 13 UNCOMMON + 12 RARE.
 *
 * Намеренная дифференциация от соседних сетов:
 *   • Хайтек L2 (1746): уже занимает СПРИНТ, ДЕЙЛИ, РЕТРО, PR, мерж, дифф,
 *     тикет, edge case (אֶג'-קֵייס), деплой, роллбек, хотфикс, чейнджлог,
 *     стейджинг, синк, статус. Здесь — PM-перспектива тех же процессов:
 *     методология (agile/scrum), доска (kanban), требования (PRD-стиль),
 *     релиз с PM-углом, ретро через action items, коммуникация по результатам.
 *   • PM L3 (1765): PRD, беклог, user story, planning, prioritization, persona,
 *     interview, jobs to be done. Здесь — другие концепции уровня L2.
 *   • PM L4 (1766): vision, mission, OKR, P&L, growth, monetization, RICE,
 *     MoSCoW. Здесь — операционный PM, не стратегический.
 *
 * SemanticGroups (5 × 5):
 *   pm_processes      — agile, scrum, kanban-доска, апдейт, координация
 *   pm_requirements   — пользовательское требование, edge case, acceptance criteria, мокап, скетч
 *   pm_release        — релиз продукта, release notes, changelog, versioning, бета
 *   pm_retro          — итоги цикла, lessons learned, action item, follow-up, blockers
 *   pm_communication  — стендап, sync встреча, email-апдейт, all-hands презентация, скриншот
 *
 * Word IDs: setId × 100 + position (177801..177825).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewPmL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1778, languagePair = "he-ru", orderIndex = 1778,
            name = "Продуктовый менеджмент",
            description = "Продвинутый базовый: процессы, требования, релизы, ретро, коммуникация",
            topic = "Продуктовый менеджмент", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1778 — Продуктовый менеджмент: продвинутый (L2, UNCOMMON+RARE)
        // 5 групп × 5 слов: processes, requirements, release, retro, communication
        // ══════════════════════════════════════════════════════════════════════

        // ── pm_processes (5) — методология и процессы ──
        WordEntity(
            id = 177801, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_processes", transliteration = "ejail",
            original = "אֶג׳ַייל", translation = "agile (методология)",
            definition = "גִּישָׁה לַעֲבוֹדָה שֶׁל קְבוּצוֹת קְטַנּוֹת — לְמַסֵּר תּוֹצָר חֶלְקִי בְּתֵדִירוּת גְּבוֹהָה.",
            definitionNative = "Подход к работе маленьких команд — выдавать частичный результат с высокой частотой.",
            example = "הַחֶבְרָה עָבְרָה לְשִׁיטַת אֶג׳ַייל וְהַמְּהִירוּת שֶׁל הַצְּוָתִים גָּדְלָה.",
            exampleNative = "Компания перешла на методику אֶג׳ַייל, и скорость команд выросла.",
         fillInBlankExclusions = listOf(177802L, 177803L, 177804L, 177805L)),
        WordEntity(
            id = 177802, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_processes", transliteration = "skraam",
            original = "סְקְרָאם", translation = "scrum (фреймворк)",
            definition = "מָסְגֶּרֶת מְסֻדֶּרֶת שֶׁמְּחַלֶּקֶת עֲבוֹדָה לְמַחְזוֹרִים קְצוּבִים עִם פְּגִישׁוֹת קְבוּעוֹת.",
            definitionNative = "Упорядоченная рамка — делит работу на короткие циклы с фиксированными встречами.",
            example = "צֶוֶות הַמּוּצָר אִמֵּץ סְקְרָאם בִּגְלַל הַצֹּרֶךְ בְּצָפִיּוּת לַשּׁוּתָפִים.",
            exampleNative = "Продуктовая команда взяла סְקְרָאם из-за нужды в предсказуемости для смежников.",
         fillInBlankExclusions = listOf(177801L, 177803L, 177804L, 177805L)),
        WordEntity(
            id = 177803, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_processes", transliteration = "luakh kanban",
            original = "לוּחַ קַנְבָּן", translation = "канбан-доска",
            definition = "שֶׁטַח חָזוּתִי עִם טוּרִים — כָּל מַטְלָה עוֹבֶרֶת מִשְּׂמֹאל לְיָמִין לְפִי שָׁלָב הָעֲבוֹדָה.",
            definitionNative = "Визуальная плоскость со столбцами — задача движется слева направо по этапам работы.",
            example = "לוּחַ קַנְבָּן בַּפְּרוֹיֶקְט הֶרְאָה שֶׁשְּׁתַיִם מַטְלוֹת תְּקוּעוֹת אֵצֶל הַטֶסְטֵר.",
            exampleNative = "לוּחַ קַנְבָּן в проекте показал, что две задачи застряли у тестировщика.",
         fillInBlankExclusions = listOf(177801L, 177802L, 177804L, 177805L)),
        WordEntity(
            id = 177804, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_processes", transliteration = "apdeit",
            original = "אַפְדֵּייט", translation = "апдейт (статус-апдейт)",
            definition = "הוֹדָעָה קְצָרָה לַשּׁוּתָפִים עַל הִתְקַדְּמוּת — מָה נַעֲשָׂה וּמָה נִשְׁאַר.",
            definitionNative = "Короткое сообщение смежникам о ходе дел — что сделано и что осталось.",
            example = "כָּתַבְתִּי אַפְדֵּייט שְׁבוּעִי בָּעֲרוּץ שֶׁל הַצֶּוֶות בְּסְלַאק.",
            exampleNative = "Я написал еженедельный אַפְדֵּייט в командном канале Slack.",
         fillInBlankExclusions = listOf(177801L, 177802L, 177803L, 177805L)),
        WordEntity(
            id = 177805, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_processes", transliteration = "koordinatsya",
            original = "קוֹאוֹרְדִּינַצְיָה", translation = "координация",
            definition = "סִדּוּר זְמַנִּים וּמְשִׂימוֹת בֵּין שְׁנֵי צְוָתִים אוֹ יוֹתֵר כְּדֵי שֶׁכֻּלָּם יִתְקַדְּמוּ יַחַד.",
            definitionNative = "Согласование сроков и задач между двумя или более командами — чтобы все шли вместе.",
            example = "קוֹאוֹרְדִּינַצְיָה בֵּין הַפִּתּוּחַ לַשִּׁוּוּק חָסְכָה לָנוּ שָׁבוּעַ שָׁלֵם.",
            exampleNative = "קוֹאוֹרְדִּינַצְיָה между разработкой и маркетингом сэкономила нам целую неделю.",
         fillInBlankExclusions = listOf(177801L, 177802L, 177803L, 177804L)),

        // ── pm_requirements (5) — требования и спецификация фичи ──
        WordEntity(
            id = 177806, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_requirements", transliteration = "drisha mishtamesh",
            original = "דְּרִישַׁת מִשְׁתַּמֵּשׁ", translation = "пользовательское требование",
            definition = "תֵּאוּר מָה הַקָּהָל רוֹצֶה לַעֲשׂוֹת בַּמּוּצָר — לֹא אֵיךְ הַמְּהַנְדֵּס יְבַצֵּעַ אֶת זֶה.",
            definitionNative = "Описание того, что аудитория хочет делать в продукте — не как инженер это построит.",
            example = "דְּרִישַׁת מִשְׁתַּמֵּשׁ בָּהִירָה חוֹסֶכֶת לְפָחוֹת עֲשָׂרָה יָמִים שֶׁל בִּלְבּוּל בָּצֶוֶות.",
            exampleNative = "Чёткая דְּרִישַׁת מִשְׁתַּמֵּשׁ экономит минимум десять дней путаницы в команде.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177807, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_requirements", transliteration = "mikre katse",
            original = "מִקְרֵה קָצֶה", translation = "пограничный случай",
            definition = "תַּרְחִישׁ נָדִיר עִם נְתוּנִים קִיצוֹנִיִּים שֶׁעָלוּל לִשְׁבֹּר אֶת הַפִיצֶ׳ר אִם לֹא חָשְׁבוּ עָלָיו.",
            definitionNative = "Редкий сценарий с экстремальными данными — может сломать фичу, если о нём не подумали.",
            example = "מִקְרֵה קָצֶה שֶׁל לָקוֹחַ בְּלִי שֵׁם פְּרָטִי גָּרַם לְקְרִיסָה בַּטּוֹפֶס.",
            exampleNative = "מִקְרֵה קָצֶה клиента без имени привёл к падению формы.",
         fillInBlankExclusions = listOf(177806L, 177808L, 177809L, 177810L)),
        WordEntity(
            id = 177808, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_requirements", transliteration = "kriteryon kabala",
            original = "קְרִיטֶרְיוֹן קַבָּלָה", translation = "критерий приёмки (acceptance criteria)",
            definition = "תְּנַאי בָּהִיר שֶׁעַל פִּיו הַטֶסְטֵר מַחְלִיט אִם הַפִיצֶ׳ר עָבַד אוֹ עוֹד דּוֹרֵשׁ עֲבוֹדָה.",
            definitionNative = "Чёткое условие — по нему тестировщик решает, зашла ли фича или ещё требует работы.",
            example = "קְרִיטֶרְיוֹן קַבָּלָה הָיָה שֶׁהַטֹּפֶס יִשָּׁמֵר תּוֹךְ שְׁתֵּי שְׁנִיּוֹת.",
            exampleNative = "קְרִיטֶרְיוֹן קַבָּלָה был — форма сохраняется не дольше двух секунд.",
         fillInBlankExclusions = listOf(177806L, 177807L, 177809L, 177810L)),
        WordEntity(
            id = 177809, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_requirements", transliteration = "mokap",
            original = "מוֹקאַפּ", translation = "мокап (макет интерфейса)",
            definition = "צִיּוּר מְפֹרָט שֶׁל מָסָךְ עֲתִידִי — מַרְאֶה אֵיךְ פִיצֶ׳ר יִרְאֶה לִפְנֵי שֶׁמְּהַנְדְּסִים בּוֹנִים.",
            definitionNative = "Подробный рисунок будущего экрана — показывает, как фича будет выглядеть до сборки.",
            example = "אִשַּׁרְתִּי אֶת הַמּוֹקאַפּ אַחֲרֵי שְׁתֵּי סִבּוּבֵי הֶעָרוֹת מֵהָעִיצּוּב.",
            exampleNative = "Я утвердил מוֹקאַפּ после двух раундов замечаний от дизайна.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177810, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_requirements", transliteration = "skitsa",
            original = "סְקִיצָּה", translation = "скетч (эскиз)",
            definition = "צִיּוּר גַּס בְּעִפָּרוֹן עַל נְיָר — רַעְיוֹן רִאשׁוֹנִי לִפְנֵי שֶׁעוֹבְרִים לְמַסַּךְ דִּיגִיטָלִי.",
            definitionNative = "Грубый карандашный набросок на бумаге — первая идея до перехода на цифровой экран.",
            example = "צִיַּרְתִּי סְקִיצָּה בַּפְּגִישָׁה וְהַמְּעַצֵּב הָפַךְ אוֹתָהּ לְמָסָךְ נָקִי.",
            exampleNative = "Я нарисовал סְקִיצָּה на встрече, и дизайнер превратил её в чистый экран.",
         fillInBlankExclusions = listOf(177806L, 177807L, 177808L, 177809L)),

        // ── pm_release (5) — релизы и версии ──
        WordEntity(
            id = 177811, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_release", transliteration = "shihrur mutsar",
            original = "שִׁחְרוּר מוּצָר", translation = "релиз продукта",
            definition = "פְּתִיחָה רִשְׁמִית שֶׁל פִיצֶ׳ר חָדָשׁ אוֹ גִּרְסָה שְׁלֵמָה לְכָל הַקָּהָל בָּעוֹלָם.",
            definitionNative = "Официальное открытие новой фичи или целой версии всей аудитории в мире.",
            example = "שִׁחְרוּר מוּצָר לְשׁוּק יַפָּן נִדְחָה בִּגְלַל בְּעָיוֹת תַּרְגוּם.",
            exampleNative = "שִׁחְרוּר מוּצָר на рынок Японии перенесли из-за проблем с переводом.",
         fillInBlankExclusions = listOf(177812L, 177813L, 177814L, 177815L)),
        WordEntity(
            id = 177812, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_release", transliteration = "rilis nots",
            original = "רִילִיס נוֹטְס", translation = "release notes",
            definition = "טֶקְסְט קָצָר לַקָּהָל שֶׁמְּסַפֵּר מָה חָדָשׁ בַּגִּרְסָה — מָה נוֹסַף, מָה תֻּקַּן וּמָה הִשְׁתַּפֵּר.",
            definitionNative = "Короткий текст для аудитории — что нового в версии: что добавили, что починили, что улучшилось.",
            example = "כָּתַבְתִּי רִילִיס נוֹטְס בִּשְׁפָה פְּשׁוּטָה כְּדֵי שֶׁכָּל לָקוֹחַ יָבִין.",
            exampleNative = "Я написал רִילִיס נוֹטְס простым языком, чтобы любой клиент понял.",
         fillInBlankExclusions = listOf(177811L, 177813L, 177814L, 177815L)),
        WordEntity(
            id = 177813, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_release", transliteration = "yoman shinuyim",
            original = "יוֹמַן שִׁנּוּיִים", translation = "журнал изменений (changelog)",
            definition = "מִסְמָךְ פְּנִימִי טֶכְנִי שֶׁמְּפָרֵט שׁוּרָה אַחַר שׁוּרָה כָּל תִּקּוּן בֵּין גִּרְסָה לְגִרְסָה.",
            definitionNative = "Внутренний технический документ — построчно перечисляет каждую правку между версиями.",
            example = "יוֹמַן שִׁנּוּיִים שֶׁל הָרֹבַע הִכִּיל מֵאָה וּשְׁלוֹשִׁים שׁוּרוֹת.",
            exampleNative = "יוֹמַן שִׁנּוּיִים за квартал содержал сто тридцать строк.",
         fillInBlankExclusions = listOf(177811L, 177812L, 177814L, 177815L)),
        WordEntity(
            id = 177814, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_release", transliteration = "nihul girsaot",
            original = "נִהוּל גִּרְסָאוֹת", translation = "управление версиями (versioning)",
            definition = "שִׁיטָה לְמִסְפּוּר וּלְשִׁמּוּר שֶׁל מַהֲדוּרוֹת מוּצָר — כְּדֵי שֶׁתָּמִיד יָדוּעַ אֵיזוֹ עוֹבֶדֶת אֵצֶל מִי.",
            definitionNative = "Способ нумерации и хранения сборок продукта — чтобы всегда знать, какая работает у кого.",
            example = "נִהוּל גִּרְסָאוֹת מְסֻדָּר עָזַר לָנוּ לִתְפֹּס אֶת מָקוֹר הַתַּקָּלָה תּוֹךְ דַּקּוֹת.",
            exampleNative = "Упорядоченное נִהוּל גִּרְסָאוֹת помогло найти источник сбоя за минуты.",
         fillInBlankExclusions = listOf(177811L, 177812L, 177813L, 177815L)),
        WordEntity(
            id = 177815, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_release", transliteration = "beta",
            original = "בֵּטָה", translation = "бета (версия)",
            definition = "מַהֲדוּרָה כִּמְעַט-מוּכָנָה שֶׁמַּגִּיעָה רַק לִקְבוּצָה צְמוּדָה לְפִי הַזְמָנָה — לִפְנֵי שִׁחְרוּר רָשְׁמִי.",
            definitionNative = "Почти готовая сборка — попадает только к узкой группе по приглашению, до официального выпуска.",
            example = "מֵאָה לָקוֹחוֹת קִבְּלוּ גִּישָׁה לְבֵּטָה וְשָׁלְחוּ הֲמוֹן הֶעָרוֹת.",
            exampleNative = "Сто клиентов получили доступ к בֵּטָה и прислали кучу замечаний.",
         fillInBlankExclusions = listOf(177811L, 177812L, 177813L, 177814L)),

        // ── pm_retro (5) — ретроспектива и закрытие цикла ──
        WordEntity(
            id = 177816, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_retro", transliteration = "sikum proyekt",
            original = "סִיכּוּם פְּרוֹיֶקְט", translation = "подведение итогов проекта",
            definition = "מִפְגָּשׁ בְּסוֹף הַשָּׁלָב שֶׁבּוֹ הַצֶּוֶות מַעֲרִיךְ אֶת הַתּוֹצָאוֹת מוּל מָה שֶׁהִבְטִיחַ.",
            definitionNative = "Встреча в конце этапа — команда сравнивает результаты с тем, что обещала.",
            example = "סִיכּוּם פְּרוֹיֶקְט גִּלָּה שֶׁהַזְּמַן חָרַג אֲבָל הַתּוֹצָר עָנָה עַל הַצָּפִיּוֹת.",
            exampleNative = "סִיכּוּם פְּרוֹיֶקְט показал — сроки сдвинулись, но результат оправдал ожидания.",
         fillInBlankExclusions = listOf(177817L, 177818L, 177819L, 177820L)),
        WordEntity(
            id = 177817, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_retro", transliteration = "lekakhim",
            original = "לֶקָחִים", translation = "извлечённые уроки (lessons learned)",
            definition = "תּוֹבָנוֹת מַעֲשִׂיּוֹת מֵעֲבוֹדָה שֶׁעָבְרָה — מָה כְּדַאי לַחֲזֹר עָלָיו וּמָה לֹא לַעֲשׂוֹת שׁוּב.",
            definitionNative = "Практические выводы из прошлой работы — что повторить, а что больше не делать.",
            example = "לֶקָחִים מֵהַשִּׁחְרוּר הָאַחֲרוֹן נִכְתְּבוּ לִתְעוּד פְּנִימִי מְשֻׁתָּף.",
            exampleNative = "לֶקָחִים с последнего релиза записали в общую внутреннюю документацию.",
         fillInBlankExclusions = listOf(177816L, 177818L, 177819L, 177820L)),
        WordEntity(
            id = 177818, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_retro", transliteration = "prit peula",
            original = "פְּרִיט פְּעֻלָּה", translation = "action item",
            definition = "מַטָּלָה קוֹנְקְרֶטִית עִם שֵׁם אַחְרַאי וְתַאֲרִיךְ סִיּוּם — תּוֹצָאָה יְשִׁירָה שֶׁל פְּגִישָׁה.",
            definitionNative = "Конкретное дело с именем ответственного и сроком — прямой результат встречи.",
            example = "כָּל פְּרִיט פְּעֻלָּה מֵהַסִּיכּוּם הוּקְצָה לְאָדָם בָּהִיר וּלְזְמַן יָדוּעַ.",
            exampleNative = "Каждый פְּרִיט פְּעֻלָּה из итогов закрепили за конкретным человеком и сроком.",
         fillInBlankExclusions = listOf(177816L, 177817L, 177819L, 177820L)),
        WordEntity(
            id = 177819, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_retro", transliteration = "follo-ap",
            original = "פוֹלוֹ-אַפּ", translation = "follow-up",
            definition = "בְּדִיקָה חוֹזֶרֶת לְאַחַר זְמַן — לִוְדֵא שֶׁמַּטָּלָה שֶׁהֻחְלְטָה עָלֶיהָ בֶּאֱמֶת בֻּצְּעָה.",
            definitionNative = "Повторная проверка через время — убедиться, что задача, о которой договорились, реально сделана.",
            example = "שָׁלַחְתִּי פוֹלוֹ-אַפּ בְּמֵייל אַחֲרֵי שָׁבוּעַ לְכָל הַשּׁוּתָפִים בַּפְּגִישָׁה.",
            exampleNative = "Я отправил פוֹלוֹ-אַפּ письмом через неделю всем участникам встречи.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177820, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_retro", transliteration = "khasimot",
            original = "חֲסִימוֹת", translation = "блокеры (препятствия)",
            definition = "גוֹרְמִים חִיצוֹנִיִּים שֶׁעוֹצְרִים מַטָּלָה — הַמְתָּנָה לְאִישּׁוּר, גִּישׁוֹת חֲסֵרוֹת אוֹ צְוָתִים אֲחֵרִים.",
            definitionNative = "Внешние причины, из-за которых задача стоит — ожидание согласования, отсутствие доступа или другие команды.",
            example = "הִצְבַּעְתִּי עַל שָׁלוֹשׁ חֲסִימוֹת בַּסִּיכּוּם וְהַמְּנַהֵל הִתְחַיֵּב לְפַתֵּר עַד מָחָר.",
            exampleNative = "Я указал на три חֲסִימוֹת в итогах — руководитель пообещал решить до завтра.",
         fillInBlankExclusions = listOf(177816L, 177817L, 177818L, 177819L)),

        // ── pm_communication (5) — коммуникация в команде и со смежниками ──
        WordEntity(
            id = 177821, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_communication", transliteration = "stendap",
            original = "סְטֶנְדְאַפּ", translation = "стендап (короткая стоячая встреча)",
            definition = "מִפְגָּשׁ קָצָר בַּעֲמִידָה שֶׁל רֶבַע שָׁעָה — כָּל אֶחָד מְסַפֵּר בִּשְׁתֵּי מִשְׁפָּטִים מָה הוּא עוֹשֶׂה.",
            definitionNative = "Короткая встреча стоя на четверть часа — каждый в двух предложениях говорит, чем занят.",
            example = "סְטֶנְדְאַפּ בְּתֵשַׁע בַּבֹּקֶר נִמְשָׁךְ שְׁמוֹנֶה דַּקּוֹת בִּלְבַד הַיּוֹם.",
            exampleNative = "סְטֶנְדְאַפּ в девять утра занял сегодня всего восемь минут.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177822, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_communication", transliteration = "pgishat teum",
            original = "פְּגִישַׁת תֵּאוּם", translation = "координационная встреча",
            definition = "פְּגִישָׁה בֵּין שְׁנֵי צְוָתִים שֶׁמַּצְלִיבָה תָּכְנִיּוֹת לִפְנֵי שֶׁכָּל אֶחָד מַתְחִיל לִבְנוֹת.",
            definitionNative = "Встреча двух команд — сводят планы вместе, прежде чем каждая начнёт строить.",
            example = "פְּגִישַׁת תֵּאוּם עִם הַטֵּק לִיד גָּמְרָה שָׁלוֹשׁ מַחְלוֹקוֹת בְּחֲצִי שָׁעָה.",
            exampleNative = "פְּגִישַׁת תֵּאוּם с тимлидом закрыла три спорных вопроса за полчаса.",
         fillInBlankExclusions = listOf(177821L, 177823L, 177824L, 177825L)),
        WordEntity(
            id = 177823, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_communication", transliteration = "doar idkun",
            original = "דּוֹאַר עִדְכּוּן", translation = "email-апдейт (письмо с обновлением)",
            definition = "מֵייל מְסֻדָּר לַשּׁוּתָפִים — תַּקְצִיר הִתְקַדְּמוּת וְהַחְלָטוֹת מֵהַשָּׁבוּעַ הָאַחֲרוֹן.",
            definitionNative = "Упорядоченное письмо смежникам — сводка прогресса и решений за прошедшую неделю.",
            example = "דּוֹאַר עִדְכּוּן יוֹצֵא בְּכָל יוֹם חֲמִישִׁי לְכָל מְנַהֲלֵי הַחֶבְרָה.",
            exampleNative = "דּוֹאַר עִדְכּוּן уходит каждый четверг всем менеджерам компании.",
         fillInBlankExclusions = listOf(177821L, 177822L, 177824L, 177825L)),
        WordEntity(
            id = 177824, setId = 1778, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "pm_communication", transliteration = "hatsagat ol-hends",
            original = "הַצָּגַת אוֹל-הֶנְדְּס", translation = "all-hands презентация",
            definition = "מַצָּגָה לְכָל הָעוֹבְדִים בַּחֶבְרָה בְּבַת אַחַת — בְּדֶרֶךְ כְּלָל פַּעַם בָּרֹבַע.",
            definitionNative = "Выступление перед всеми сотрудниками сразу — обычно раз в квартал.",
            example = "הַצָּגַת אוֹל-הֶנְדְּס שֶׁל הַפִיצֶ׳ר הָרִאשׁוֹן שֶׁלִּי לָקְחָה שְׁלוֹשִׁים דַּקּוֹת.",
            exampleNative = "הַצָּגַת אוֹל-הֶנְדְּס моей первой фичи заняла тридцать минут.",
         fillInBlankExclusions = listOf(177821L, 177822L, 177823L, 177825L)),
        WordEntity(
            id = 177825, setId = 1778, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pm_communication", transliteration = "tsilum masakh",
            original = "צִילּוּם מָסָךְ", translation = "скриншот",
            definition = "תְּמוּנָה דִּיגִיטָלִית שֶׁל מָה שֶׁמּוֹפִיעַ בָּרֶגַע עַל הַתֶּצוּגָה — נוֹחָה לְהַסְבִּיר בְּלִי מִלִּים.",
            definitionNative = "Цифровая картинка того, что сейчас на дисплее — удобно объяснить без слов.",
            example = "שָׁלַחְתִּי צִילּוּם מָסָךְ שֶׁל הַשְּׁגִיאָה לְעָרוּץ הַצֶּוֶות בְּסְלַאק.",
            exampleNative = "Я отправил צִילּוּם מָסָךְ ошибки в командный канал Slack.",
            isFillInBlankSafe = false,
        ),
    )
}
