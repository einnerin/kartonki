package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1903 (he-ru).
 * Работа и карьера: удалёнка, фриланс и agile (L3 / UNCOMMON + RARE).
 *
 * Зеркало en-ru set 470. Точечное расширение темы «Работа и карьера».
 * Подтема — современные практики IT/digital-работы 2020-х:
 *   удалёнка и формат рабочего места (work from home, distributed,
 *     digital nomad, coworking, time zone, async communication),
 *   фриланс и контракты (freelancer, contractor, hourly rate,
 *     side hustle, scope creep),
 *   agile / scrum (backlog, kanban, MVP, iteration, agile),
 *   культура и баланс (overwork, work-life balance, onboarding-replacement,
 *     offboarding, flexible hours),
 *   результат и оплата (deliverable, checkpoint, invoice, deep work).
 *
 * Исключены как дубли с существующими he-ru сетами:
 *   - עֲבוֹדָה מֵרָחוֹק (remote work) — Batch60 → заменено на עֲבוֹדָה מִן הַבַּיִת.
 *   - עֲבוֹדָה הִיבְּרִידִית (hybrid) — WorkV2 → заменено на חֶבְרָה מְבוּזֶּרֶת.
 *   - שְׁחִיקָה (burnout) — HealthFitnessL1L2L3 → заменено на עֲבוֹדַת יֶתֶר.
 *   - חֲנִיכָה (onboarding) — BarberL5, BaristaL5 → заменено на קְלִיטָה.
 *   - אֶבֶן דֶּרֶךְ (milestone) — WorkV2 → заменено на תַּחֲנַת בִּקּוֹרֶת.
 *   - סְפְּרִינְט (HightechL2), סְקְרָאם (PmL2), רֶטְרוֹסְפֶּקְטִיבָה (EntertainmentL4) —
 *     ядро agile уже распределено по другим сетам IT-тем.
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   UNCOMMON — 12 слов (общепонятная лексика удалёнки и фриланса для любого,
 *              кто работал в IT/digital: work-from-home, freelancer, hourly,
 *              flex hours, kanban, iteration, MVP, invoice).
 *   RARE     — 13 слов (профлексика remote-first culture: distributed,
 *              digital nomad, coworking, async, scope creep, backlog, agile,
 *              work-life balance, offboarding, deliverable, checkpoint,
 *              deep work).
 *
 * Пять семантических подгрупп:
 *   work_remote_setup       — 5 слов: удалёнка и место работы
 *   work_remote_freelance   — 5 слов: фриланс-контракты
 *   work_remote_agile       — 5 слов: agile / scrum / kanban
 *   work_remote_culture     — 5 слов: культура и баланс
 *   work_remote_deliverables — 5 слов: результаты и оплата
 *
 * Word IDs: 190301..190325 (setId × 100 + position).
 */
object WordDataHebrewWorkRemote {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1903, languagePair = "he-ru", orderIndex = 1903,
            name = "Работа и карьера",
            description = "Удалёнка, фриланс и agile: формат работы (עֲבוֹדָה מִן הַבַּיִת, נַוָּד דִּיגִיטָלִי), контракты (פְרִילַנְסֵר, תַּעֲרִיף שָׁעָה), процессы (בֶּקְלוֹג, אִיטֶרַצְיָה, אַגַ׳יִיל)",
            topic = "Работа и карьера",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: work_remote_setup (5 words) ────────────────────────────────

        WordEntity(id = 190301, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲבוֹדָה מִן הַבַּיִת",
            translation = "работа из дома",
            definition = "פוֹרְמָט שֶׁבּוֹ הָעוֹבֵד יוֹשֵׁב בְּדִירָתוֹ וּמְבַצֵּעַ אֶת מְשִׂימוֹתָיו דֶּרֶךְ הָאִינְטֶרְנֵט.",
            definitionNative = "Формат, где сотрудник сидит у себя дома и выполняет задачи через интернет.",
            example = "הִיא עָבְרָה לְעֲבוֹדָה מִן הַבַּיִת אַחֲרֵי הוֹלֶדֶת בְּנָהּ.",
            exampleNative = "Она перешла на עֲבוֹדָה מִן הַבַּיִת после рождения сына.",
            pos = "phrase", semanticGroup = "work_remote_setup", fillInBlankExclusions = listOf(190302L, 190303L, 190304L, 190305L)),

        WordEntity(id = 190302, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "חֶבְרָה מְבוּזֶּרֶת",
            translation = "распределённая компания",
            definition = "אִרְגּוּן שֶׁאֵין לוֹ מִשְׂרָד מֶרְכָּזִי וְעוֹבְדָיו פְּרוּסִים בְּעָרִים וּמְדִינוֹת שׁוֹנוֹת.",
            definitionNative = "Организация без центрального офиса: сотрудники разбросаны по разным городам и странам.",
            example = "GitLab הִיא חֶבְרָה מְבוּזֶּרֶת עִם אַלְפֵי עוֹבְדִים בְּשִׁשִּׁים מְדִינוֹת.",
            exampleNative = "GitLab — חֶבְרָה מְבוּזֶּרֶת с тысячами сотрудников в шестидесяти странах.",
            pos = "phrase", semanticGroup = "work_remote_setup", fillInBlankExclusions = listOf(190301L, 190303L, 190304L, 190305L)),

        WordEntity(id = 190303, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "נַוָּד דִּיגִיטָלִי",
            translation = "цифровой кочевник",
            definition = "אִישׁ מִקְצוֹעַ שֶׁעוֹבֵד עִם מַחְשֵׁב נַיָּד וְעוֹבֵר בֵּין מְדִינוֹת תּוֹךְ כְּדֵי שִׁמּוּשׁ בְּוִיזָה מְיוּחֶדֶת.",
            definitionNative = "Специалист, работающий с ноутбуком и кочующий между странами по специальной визе.",
            example = "כְּנַוָּד דִּיגִיטָלִי הוּא עוֹבֵד חֹדֶשׁ בְּלִיסְבּוֹן וְחֹדֶשׁ בְּצִ׳יאַנְג מַאי.",
            exampleNative = "Как נַוָּד דִּיגִיטָלִי он работает месяц в Лиссабоне и месяц в Чианг-Мае.",
            pos = "phrase", semanticGroup = "work_remote_setup", fillInBlankExclusions = listOf(190301L, 190302L, 190304L, 190305L)),

        WordEntity(id = 190304, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "מֶרְחָב עֲבוֹדָה מְשׁוּתָּף",
            translation = "коворкинг",
            definition = "מָקוֹם בִּתְשׁלוּם שָׁעָתִי אוֹ חוֹדְשִׁי שֶׁבּוֹ פְרִילַנְסֵרִים וְצְוָתוֹת קְטַנִּים יוֹשְׁבִים יַחַד.",
            definitionNative = "Место с почасовой или месячной оплатой, где фрилансеры и маленькие команды сидят рядом.",
            example = "WeWork פָּתְחָה מֶרְחָב עֲבוֹדָה מְשׁוּתָּף בַּקּוֹמָה הָעֶשְׂרִים.",
            exampleNative = "WeWork открыл מֶרְחָב עֲבוֹדָה מְשׁוּתָּף на двадцатом этаже.",
            pos = "phrase", semanticGroup = "work_remote_setup", fillInBlankExclusions = listOf(190301L, 190302L, 190303L, 190305L)),

        WordEntity(id = 190305, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֵזוֹר זְמַן",
            translation = "часовой пояс",
            definition = "אַחַת מֵרְצוּעוֹת הַכַּדּוּר שֶׁבָּהּ הַשָּׁעוֹן מַרְאֶה אוֹתָהּ שָׁעָה בְּכָל הָעָרִים.",
            definitionNative = "Одна из полос земного шара, где часы показывают одно и то же время во всех городах.",
            example = "פָּגִישַׁת הַצֶּוֶת מְתֻאֶמֶת לְאֵזוֹר זְמַן שֶׁל קַלִיפוֹרְנְיָה.",
            exampleNative = "Встреча команды назначена по אֵזוֹר זְמַן Калифорнии.",
            pos = "phrase", semanticGroup = "work_remote_setup", fillInBlankExclusions = listOf(190301L, 190302L, 190303L, 190304L)),

        // ── Group: work_remote_freelance (5 words) ────────────────────────────

        WordEntity(id = 190306, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְרִילַנְסֵר",
            translation = "фрилансер",
            definition = "אִישׁ שֶׁעוֹבֵד עַל פְּרוֹיֶקְטִים זְמַנִּיִּים לְכַמָּה לְקוֹחוֹת בְּמַקְבִּיל, בְּלִי מַעֲבִיד קָבוּעַ.",
            definitionNative = "Человек, работающий над временными проектами сразу на нескольких клиентов, без постоянного работодателя.",
            example = "כִּפְרִילַנְסֵר הִיא מַעֲצֶבֶת לוֹגוֹ לִשְׁלוֹשָׁה סְטָארְט־אַפִּים.",
            exampleNative = "Как פְרִילַנְסֵר она рисует логотипы трём стартапам.",
            pos = "noun", semanticGroup = "work_remote_freelance"),

        WordEntity(id = 190307, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "קַבְּלָן עַצְמָאִי",
            translation = "независимый подрядчик",
            definition = "אִישׁ מִקְצוֹעַ שֶׁחָתוּם עַל הֶסְכֵּם שֵׁרוּתִים מוּל חֶבְרָה, מַנְפִּיק חֶשְׁבּוֹנִיוֹת וּמְשַׁלֵּם מַס בְּעַצְמוֹ.",
            definitionNative = "Специалист, заключивший с компанией договор услуг: выставляет счета и сам платит налоги.",
            example = "הַחֶבְרָה הֶעֱסִיקָה אוֹתוֹ כְּקַבְּלָן עַצְמָאִי וְלֹא כְּשָׂכִיר.",
            exampleNative = "Компания наняла его как קַבְּלָן עַצְמָאִי, а не как штатного.",
            pos = "phrase", semanticGroup = "work_remote_freelance", fillInBlankExclusions = listOf(190308L, 190309L, 190310L)),

        WordEntity(id = 190308, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּעֲרִיף שָׁעָתִי",
            translation = "почасовая ставка",
            definition = "סְכוּם הַכֶּסֶף שֶׁבַּעַל הַמִּקְצוֹעַ גּוֹבֶה עַל כָּל שִׁשִּׁים דַּקּוֹת שֶׁל עֲבוֹדָה.",
            definitionNative = "Сумма, которую специалист берёт за каждые шестьдесят минут работы.",
            example = "הוּא הֶעֱלָה אֶת תַּעֲרִיף שָׁעָתִי לַחֲמִישִּׁים דּוֹלָר אַחֲרֵי שָׁנָה.",
            exampleNative = "Он поднял תַּעֲרִיף שָׁעָתִי до пятидесяти долларов через год.",
            pos = "phrase", semanticGroup = "work_remote_freelance", fillInBlankExclusions = listOf(190307L, 190309L, 190310L)),

        WordEntity(id = 190309, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "ג׳וֹב צְדָדִי",
            translation = "подработка",
            definition = "עִסּוּק קָטָן בְּהַכְנָסָה נוֹסֶפֶת לְצַד מִשְׂרָה רִאשִׁית, לְרוֹב בִּשְׁעוֹת הָעֶרֶב.",
            definitionNative = "Маленькое занятие ради дополнительного дохода рядом с основной работой, обычно по вечерам.",
            example = "כְּג׳וֹב צְדָדִי הִיא כּוֹתֶבֶת בְּלוֹג עַל קוֹסְמֵטִיקָה.",
            exampleNative = "Как ג׳וֹב צְדָדִי она ведёт блог о косметике.",
            pos = "phrase", semanticGroup = "work_remote_freelance", fillInBlankExclusions = listOf(190307L, 190308L, 190310L)),

        WordEntity(id = 190310, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "זְחִילַת הֶיקֵף",
            translation = "расползание задач",
            definition = "תּוֹסֶפֶת הַדְרָגָתִית שֶׁל דְּרִישׁוֹת לַפְּרוֹיֶקְט בְּלִי לְעַדְכֵּן לוּחַ הַזְמַנִּים אוֹ הַתַּשְׁלוּם.",
            definitionNative = "Постепенное наращивание требований к проекту без правки сроков и оплаты.",
            example = "זְחִילַת הֶיקֵף דָּחֲפָה אֶת הָאֲסַפְקָה בִּשְׁלוֹשָׁה שָׁבוּעוֹת.",
            exampleNative = "זְחִילַת הֶיקֵף отодвинула сдачу на три недели.",
            pos = "phrase", semanticGroup = "work_remote_freelance", fillInBlankExclusions = listOf(190307L, 190308L, 190309L)),

        // ── Group: work_remote_agile (5 words) ────────────────────────────────

        WordEntity(id = 190311, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "בֶּקְלוֹג",
            translation = "беклог (список задач)",
            definition = "רְשִׁימָה מְסוּדֶּרֶת שֶׁל מְשִׂימוֹת עֲתִידִיוֹת לַפְּרוֹיֶקְט, בְּסֵדֶר חֲשִׁיבוּת יוֹרֵד.",
            definitionNative = "Упорядоченный список будущих задач проекта в порядке убывания важности.",
            example = "הַצֶּוֶת עָבַר עַל הַבֶּקְלוֹג כָּל בֹּקֶר שֵׁנִי.",
            exampleNative = "Команда разбирала בֶּקְלוֹג каждое утро понедельника.",
            pos = "noun", semanticGroup = "work_remote_agile", fillInBlankExclusions = listOf(190312L, 190313L, 190314L, 190315L)),

        WordEntity(id = 190312, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קַנְבָּן",
            translation = "канбан",
            definition = "לוּחַ עִם עַמּוּדוֹת «לַעֲשׂוֹת», «בְּעֲבוֹדָה» וּ«גָּמוּר», שֶׁמַּרְאֶה לְכָל הַצֶּוֶת אֵיפֹה כָּל מְשִׂימָה.",
            definitionNative = "Доска со столбцами «сделать», «в работе» и «готово», показывающая команде статус каждой задачи.",
            example = "הַצֶּוֶת מַחֲזִיק קַנְבָּן עַל קִיר הַחֶדֶר וּמְזִיז פֶּתֶק כָּל יוֹם.",
            exampleNative = "Команда держит קַנְבָּן на стене комнаты и двигает стикер каждый день.",
            pos = "noun", semanticGroup = "work_remote_agile", fillInBlankExclusions = listOf(190311L, 190313L, 190314L, 190315L)),

        WordEntity(id = 190313, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "MVP",
            translation = "минимально жизнеспособный продукт",
            definition = "גִּרְסַת מוּצָר רָזָה שֶׁמְּכִילָה רַק אֶת הַפִיצֵ'רִים הַהֶכְרֵחִיִּים לִבְדִיקַת רַעְיוֹן בַּשּׁוּק.",
            definitionNative = "Худая версия продукта, содержащая только функции, нужные для проверки идеи на рынке.",
            example = "הֵם הִשִּׁיקוּ MVP בְּתוֹךְ שִׁשָּׁה שָׁבוּעוֹת לִפְנֵי הַגִּיּוּס.",
            exampleNative = "Они выпустили MVP за шесть недель до сбора инвестиций.",
            pos = "noun", semanticGroup = "work_remote_agile", fillInBlankExclusions = listOf(190311L, 190312L, 190314L, 190315L)),

        WordEntity(id = 190314, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִיטֶרַצְיָה",
            translation = "итерация",
            definition = "מַחֲזוֹר עֲבוֹדָה קָצָר עִם מַטָּרָה, גִּרְסָה חֲדָשָׁה וּמְשׁוֹב לִקְרַאת הַסִּבּוּב הַבָּא.",
            definitionNative = "Короткий рабочий цикл с целью, новой версией и обратной связью к следующему кругу.",
            example = "כָּל אִיטֶרַצְיָה אָרְכָה שְׁבוּעַיִם וְהִסְתַּיְּמָה בְּהַדגָּמָה לַלָּקוֹחַ.",
            exampleNative = "Каждая אִיטֶרַצְיָה длилась две недели и заканчивалась показом клиенту.",
            pos = "noun", semanticGroup = "work_remote_agile", fillInBlankExclusions = listOf(190311L, 190312L, 190313L, 190315L)),

        WordEntity(id = 190315, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "אַגַ׳יִיל",
            translation = "agile (гибкая методология)",
            definition = "גִּישַׁת פִּתּוּחַ בְּמַחֲזוֹרִים קְצָרִים, שֶׁמַּעֲדִיפָה לָקוֹחַ עַל הֶסְכֵּם וּמְהִירוּת עַל תַּכְנוּן רָחָב.",
            definitionNative = "Подход к разработке короткими циклами: клиент важнее договора, скорость важнее громадного плана.",
            example = "הַחֶבְרָה אִמְּצָה אַגַ׳יִיל וְזָנְחָה אֶת מִסְמַךְ הַדְּרִישׁוֹת שֶׁל אֲלָפַיִם עַמּוּדִים.",
            exampleNative = "Компания приняла אַגַ׳יִיל и забросила требование в две тысячи страниц.",
            pos = "noun", semanticGroup = "work_remote_agile", fillInBlankExclusions = listOf(190311L, 190312L, 190313L, 190314L)),

        // ── Group: work_remote_culture (5 words) ──────────────────────────────

        WordEntity(id = 190316, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "תִּקְשׁוֹרֶת אַ־סִינְכְרוֹנִית",
            translation = "асинхронная коммуникация",
            definition = "סִגְנוֹן הִתְכַּתְּבוּת שֶׁבּוֹ הָעוֹבְדִים עוֹנִים בַּזְּמַן הַנּוֹחַ לָהֶם, וְלֹא מִיָּד.",
            definitionNative = "Стиль переписки, где сотрудники отвечают в удобное им время, а не сразу.",
            example = "תִּקְשׁוֹרֶת אַ־סִינְכְרוֹנִית הִצִּילָה אֶת הַצֶּוֶת מִפְּגִישׁוֹת מְיוּתָּרוֹת.",
            exampleNative = "תִּקְשׁוֹרֶת אַ־סִינְכְרוֹנִית избавила команду от лишних совещаний.",
            pos = "phrase", semanticGroup = "work_remote_culture", fillInBlankExclusions = listOf(190317L, 190318L, 190320L)),

        WordEntity(id = 190317, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲבוֹדַת יֶתֶר",
            translation = "переработка",
            definition = "מַצָּב שֶׁבּוֹ הָעוֹבֵד מַשְׁקִיעַ שָׁעוֹת רַבּוֹת מֵעַל הַנּוֹרְמָה וּמַגִּיעַ לְעֲיֵפוּת חֲמוּרָה.",
            definitionNative = "Состояние, когда сотрудник вкладывает много часов сверх нормы и доходит до сильной усталости.",
            example = "עֲבוֹדַת יֶתֶר שֶׁל שִׁשָּׁה חֳדָשִׁים פָּגְעָה לָהּ בָּשֵּׁנָה.",
            exampleNative = "עֲבוֹדַת יֶתֶר длиной полгода испортила ей сон.",
            pos = "phrase", semanticGroup = "work_remote_culture", fillInBlankExclusions = listOf(190316L, 190318L, 190320L)),

        WordEntity(id = 190318, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "אִיזּוּן בַּיִת-עֲבוֹדָה",
            translation = "баланс «работа — личное»",
            definition = "חֲלוּקַת זְמַן וְכוֹחוֹת בֵּין הַמִּקְצוֹעַ לְבֵין הַמִּשְׁפָּחָה, חֲבֵרִים וְתַחְבִּיבִים.",
            definitionNative = "Деление времени и сил между профессией и семьёй, друзьями, хобби.",
            example = "הִיא בִּקְּשָׁה מִשְׂרָה חֶלְקִית כְּדֵי לְשַׁמֵּר אִיזּוּן בַּיִת-עֲבוֹדָה.",
            exampleNative = "Она попросила полставки ради אִיזּוּן בַּיִת-עֲבוֹדָה.",
            pos = "phrase", semanticGroup = "work_remote_culture", fillInBlankExclusions = listOf(190316L, 190317L, 190320L)),

        WordEntity(id = 190319, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְלִיטָה",
            translation = "приём нового сотрудника",
            definition = "תַּהֲלִיךְ שֶׁל יָמִים אוֹ שָׁבוּעוֹת רִאשׁוֹנִים שֶׁבּוֹ הָעוֹבֵד הֶחָדָשׁ מְקַבֵּל גִּישָׁה, חוֹתֵם וְלוֹמֵד אֶת הַתַּפְקִיד.",
            definitionNative = "Процесс первых дней или недель: новичок получает доступы, подписывает бумаги и осваивает роль.",
            example = "הַקְּלִיטָה שֶׁל הַמְּפַתֵּחַ הֶחָדָשׁ אָרְכָה שְׁבוּעַיִם וְעָבְרָה חָלָק.",
            exampleNative = "קְלִיטָה нового разработчика заняла две недели и прошла гладко.",
            pos = "noun", semanticGroup = "work_remote_culture"),

        WordEntity(id = 190320, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "פְּרֵדָה אִרְגּוּנִית",
            translation = "оффбординг",
            definition = "תַּהֲלִיךְ סִיּוּם מְסוּדָּר שֶׁל עוֹבֵד עוֹזֵב: הַחֲזָרַת צִיּוּד, סְגִירַת גִּישׁוֹת וּפְגִישַׁת מַשְׁוֵב.",
            definitionNative = "Упорядоченное завершение работы увольняющегося: возврат техники, закрытие доступов и итоговая встреча.",
            example = "פְּרֵדָה אִרְגּוּנִית כָּלְלָה הַחֲזָרַת מַחְשֵׁב נַיָּד וּמַשְׁוֵב גָּלוּי.",
            exampleNative = "פְּרֵדָה אִרְגּוּנִית включала возврат ноутбука и открытую обратную связь.",
            pos = "phrase", semanticGroup = "work_remote_culture", fillInBlankExclusions = listOf(190316L, 190317L, 190318L)),

        // ── Group: work_remote_deliverables (5 words) ─────────────────────────

        WordEntity(id = 190321, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שְׁעוֹת גְּמִישׁוֹת",
            translation = "гибкий график",
            definition = "מָבְנֶה יוֹם שֶׁבּוֹ הָעוֹבֵד בּוֹחֵר בְּעַצְמוֹ מָתַי לְהַתְחִיל וּמָתַי לְסַיֵּם, וּבִלְבַד שֶׁמְּסַיֵּם אֶת הַמְּשִׂימוֹת.",
            definitionNative = "Устройство дня, где сотрудник сам выбирает, когда начать и закончить, лишь бы закрыл задачи.",
            example = "שְׁעוֹת גְּמִישׁוֹת מַתִּירוֹת לוֹ לְהָבִיא אֶת הַיֶּלֶד לַגַּן.",
            exampleNative = "שְׁעוֹת גְּמִישׁוֹת позволяют ему отводить ребёнка в сад.",
            pos = "phrase", semanticGroup = "work_remote_deliverables", fillInBlankExclusions = listOf(190323L, 190325L)),

        WordEntity(id = 190322, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "תּוֹצָר",
            translation = "результат работы (deliverable)",
            definition = "פְּרִי קוֹנְקְרֶטִי שֶׁל הָעֲבוֹדָה — קֹבֶץ, דּוּחַ אוֹ פִיצֵ'ר — שֶׁמַּעֲבִירִים לַלָּקוֹחַ עַל פִּי הֶסְכֵּם.",
            definitionNative = "Конкретный продукт работы — файл, отчёт или функция — который сдают клиенту по договору.",
            example = "הִיא מָסְרָה אֶת הַתּוֹצָר הָאַחֲרוֹן יוֹם לִפְנֵי הַדֶּדְלַיְן.",
            exampleNative = "Она сдала последний תּוֹצָר за день до дедлайна.",
            pos = "noun", semanticGroup = "work_remote_deliverables", fillInBlankExclusions = listOf(190324L)),

        WordEntity(id = 190323, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "תַּחֲנַת בִּקּוֹרֶת",
            translation = "контрольная точка",
            definition = "תַּאֲרִיךְ קָבוּעַ בְּלוּחַ הַזְּמַנִּים שֶׁבּוֹ הַצֶּוֶת בּוֹדֵק אֶת הַהִתְקַדְּמוּת לִפְנֵי שֶׁמַּמְשִׁיךְ.",
            definitionNative = "Заданная дата в графике, на которой команда проверяет ход дел до движения дальше.",
            example = "תַּחֲנַת בִּקּוֹרֶת בַּחֲצִי הַדֶּרֶךְ חָשְׂפָה בַּעֲיָה בָּעִיצּוּב.",
            exampleNative = "תַּחֲנַת בִּקּוֹרֶת на середине пути выявила проблему в дизайне.",
            pos = "phrase", semanticGroup = "work_remote_deliverables", fillInBlankExclusions = listOf(190321L, 190325L)),

        WordEntity(id = 190324, setId = 1903, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֵשְׁבּוֹנִית",
            translation = "счёт-фактура",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁבַּעַל הַמִּקְצוֹעַ שׁוֹלֵחַ לַלָּקוֹחַ עִם פֵּרוּט הַשֵּׁרוּת וְהַסְּכוּם לְתַשְׁלוּם.",
            definitionNative = "Официальный документ, который специалист шлёт клиенту с описанием услуги и суммой к оплате.",
            example = "הוּא הִנְפִּיק חֵשְׁבּוֹנִית עַל שְׁלוֹשִׁים שָׁעוֹת בְּסוֹף הַחֹדֶשׁ.",
            exampleNative = "Он выписал חֵשְׁבּוֹנִית на тридцать часов в конце месяца.",
            pos = "noun", semanticGroup = "work_remote_deliverables", fillInBlankExclusions = listOf(190322L)),

        WordEntity(id = 190325, setId = 1903, languagePair = "he-ru", rarity = "RARE",
            original = "עֲבוֹדָה עֲמוּקָה",
            translation = "глубокая работа (deep work)",
            definition = "פֶּרֶק זְמַן רָצוּף שֶׁל רִכּוּז חָזָק בְּמְשִׂימָה אַחַת, בְּלִי הוֹדָעוֹת וּבְלִי הַסָּחוֹת.",
            definitionNative = "Непрерывный отрезок сильной концентрации на одной задаче, без уведомлений и отвлечений.",
            example = "בֹּקֶר שֶׁל עֲבוֹדָה עֲמוּקָה נָתַן לוֹ שְׁתֵּי פִיצֵ'רִים גְּמוּרוֹת.",
            exampleNative = "Утро עֲבוֹדָה עֲמוּקָה дало ему две готовые функции.",
            pos = "phrase", semanticGroup = "work_remote_deliverables", fillInBlankExclusions = listOf(190321L, 190323L)),
    )
}
