package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Собеседования" (job interviews, особенно для хайтека).
 *
 * Set 1750: «Собеседования» — углублённый L3 (UNCOMMON+RARE):
 *           подготовка и базовые этапы. Резюме, рекрутер, первый звонок, опыт, мотивация.
 * Set 1751: «Собеседования» — профессиональный L4 (RARE+EPIC):
 *           технические этапы и переговоры. Coding challenge, system design,
 *           offer, equity, salary negotiation.
 *
 * Тема ориентирована на русскоязычных репатриантов в Израиле, ищущих работу
 * в хайтеке. Лексика смешанная: иврит + множество английских заимствований
 * (סְקְרִינִינְג, קוֹדִינְג, אוֹפֶר, פַייט и т.д.) — так реально говорят на собеседованиях.
 *
 * Кросс-тематические пересечения с «Работа и карьера» (WordDataHebrewWorkV2.kt)
 * допустимы по правилу: дубли `original` между РАЗНЫМИ темами разрешены.
 * Здесь намеренно выбрана более узкая, специализированная лексика интервью
 * в хайтеке (LinkedIn, take-home, RSU и пр.), которая там не покрыта.
 *
 * Распределение редкостей:
 *   Set 1750: 13 UNCOMMON + 12 RARE.
 *   Set 1751: 13 RARE + 12 EPIC.
 *
 * SemanticGroups (5 × 5 в каждом сете):
 *   Set 1750:
 *     interview_resume     — резюме, сопроводит. письмо, портфолио, профиль LinkedIn, фото
 *     interview_recruiter  — рекрутер, HR, скрининг, агентство, хедхантер
 *     interview_first_call — первый звонок, знакомство, ожидаемая зарплата, локация, формат
 *     interview_experience — опыт работы, должность, образование, диплом, навыки
 *     interview_motivation — мотивация, ожидания, сильные стороны, слабые стороны, причина ухода
 *   Set 1751:
 *     interview_tech       — coding challenge, take-home, system design, pair programming, whiteboard
 *     interview_behavioral — behavioral, soft skills, fit, leadership, teamwork
 *     interview_offer      — оффер, контр-оффер, дедлайн, базовая зарплата, общий пакет
 *     interview_equity     — equity, RSU, options, signing bonus, vesting
 *     interview_negotiation — переговоры, контрпредложение, retention, walk-away, релокация
 *
 * Word IDs: setId × 100 + position (175001..175025, 175101..175125).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewInterview {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1750, languagePair = "he-ru", orderIndex = 1750,
            name = "Собеседования",
            description = "Подготовка и базовые этапы: резюме, рекрутер, первый звонок, опыт, мотивация",
            topic = "Собеседования", level = 3,
        ),
        WordSetEntity(
            id = 1751, languagePair = "he-ru", orderIndex = 1751,
            name = "Собеседования",
            description = "Технические этапы и переговоры: coding challenge, system design, оффер, equity, зарплата",
            topic = "Собеседования", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1750 — Собеседования: углублённый (L3, UNCOMMON+RARE)
        // 5 групп × 5 слов: resume, recruiter, first_call, experience, motivation
        // ══════════════════════════════════════════════════════════════════════

        // ── interview_resume (5) — материалы кандидата ──
        WordEntity(
            id = 175001, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_resume", transliteration = "korot khayim",
            original = "קוֹרוֹת חַיִּים", translation = "резюме (CV)",
            definition = "מִסְמָךְ קָצָר עִם פְּרָטֵי לִימּוּדִים וּמְקוֹמוֹת הָעֲבוֹדָה לִשְׁלֹחַ לַחֶבְרָה.",
            definitionNative = "Короткий документ с учёбой и местами работы для отправки в компанию.",
            example = "שָׁלַחְתִּי קוֹרוֹת חַיִּים לַחֲמִישָּׁה סְטַרְטְאַפִּים בְּתֵל אָבִיב.",
            exampleNative = "Я отправил קוֹרוֹת חַיִּים в пять стартапов в Тель-Авиве.",
         fillInBlankExclusions = listOf(175002L, 175003L, 175004L, 175005L)),
        WordEntity(
            id = 175002, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_resume", transliteration = "mikhtav melave",
            original = "מִכְתָּב מְלַוֶּה", translation = "сопроводительное письмо",
            definition = "טֶקְסְט קָצָר שֶׁנִּשְׁלַח עִם הַקּוֹרוֹת חַיִּים וּמַסְבִּיר לָמָּה אַתָּה מַתְאִים.",
            definitionNative = "Короткий текст к резюме — объясняет, почему именно ты подходишь.",
            example = "כָּתַבְתִּי מִכְתָּב מְלַוֶּה אִישִׁי לְכָל מִשְׂרָה בְּנִפְרָד.",
            exampleNative = "Я написал отдельное מִכְתָּב מְלַוֶּה к каждой вакансии.",
         fillInBlankExclusions = listOf(175001L, 175003L, 175004L, 175005L)),
        WordEntity(
            id = 175003, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_resume", transliteration = "portfolyo",
            original = "פּוֹרְטְפוֹלְיוֹ", translation = "портфолио",
            definition = "אֹסֶף עֲבוֹדוֹת לְשֶׁעָבַר שֶׁמַּרְאֶה אֶת הַסְּגֻנּוֹן וְהָרָמָה הַמִּקְצוֹעִית.",
            definitionNative = "Сборник прежних работ — показывает твой стиль и профессиональный уровень.",
            example = "הַמְּעַצֶּבֶת הֵבִיאָה פּוֹרְטְפוֹלְיוֹ דִּיגִיטָלִי עִם שִׁישִּׁים פְּרוֹיֶקְטִים.",
            exampleNative = "Дизайнерша принесла цифровое פּוֹרְטְפוֹלְיוֹ из шестидесяти проектов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175004, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_resume", transliteration = "profil linkdin",
            original = "פְּרוֹפִיל לִינְקְדְאִין", translation = "профиль LinkedIn",
            definition = "דַּף אִישִׁי בָּרֶשֶׁת הַמִּקְצוֹעִית שֶׁמַּגְיֵיסִים סוֹרְקִים לְאִתּוּר מֻעֳמָדִים.",
            definitionNative = "Личная страница в профсети, через которую рекрутеры ищут кандидатов.",
            example = "עִדְכַּנְתִּי אֶת פְּרוֹפִיל לִינְקְדְאִין לִפְנֵי שֶׁהִתְחַלְתִּי לְחַפֵּשׂ עֲבוֹדָה.",
            exampleNative = "Я обновил פְּרוֹפִיל לִינְקְדְאִין перед тем как начал искать работу.",
         fillInBlankExclusions = listOf(175001L, 175002L, 175003L, 175005L)),
        WordEntity(
            id = 175005, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_resume", transliteration = "tmunat profil",
            original = "תְּמוּנַת פְּרוֹפִיל", translation = "фото в профиле",
            definition = "צִילּוּם רִשְׁמִי שֶׁל פָּנִים בַּחֶלֶק הָעֶלְיוֹן שֶׁל הַדַּף הַמִּקְצוֹעִי.",
            definitionNative = "Официальный портретный снимок в верхней части профессиональной страницы.",
            example = "תְּמוּנַת פְּרוֹפִיל מַקְצוֹעִית מַעֲלָה אֶת הַסִּכּוּי לְקַבֵּל פְּנִיָּה מִמְּגַיֵּיס.",
            exampleNative = "Профессиональная תְּמוּנַת פְּרוֹפִיל увеличивает шанс получить обращение от рекрутера.",
         fillInBlankExclusions = listOf(175001L, 175002L, 175003L, 175004L)),

        // ── interview_recruiter (5) — те, кто ищет кандидатов ──
        WordEntity(
            id = 175006, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_recruiter", transliteration = "megayes",
            original = "מְגַיֵּיס", translation = "рекрутер",
            definition = "אִישׁ שֶׁמְּחַפֵּשׂ אַנָשִׁים מַתְאִימִים לְמִשְׂרוֹת בְּחֶבְרוֹת שׁוֹנוֹת.",
            definitionNative = "Человек, который ищет подходящих людей на вакансии в разных компаниях.",
            example = "הַמְּגַיֵּיס הִתְקַשֵּׁר אֵלַי יוֹם אַחַר שֶׁשָּׁלַחְתִּי אֶת הַקּוֹרוֹת חַיִּים.",
            exampleNative = "מְגַיֵּיס позвонил мне через день после того как я отправил резюме.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175007, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_recruiter", transliteration = "eich-ar",
            original = "אֵייץ׳-אַר", translation = "HR-специалист",
            definition = "עוֹבֵד מַחְלֶקֶת מַשְׁאַבֵּי אֱנוֹשׁ שֶׁמְּטַפֵּל בִּקְלִיטַת עוֹבְדִים וּתְנָאִים.",
            definitionNative = "Сотрудник отдела кадров — работает с приёмом людей и условиями труда.",
            example = "אֵייץ׳-אַר זִימֵּן אוֹתִי לִשְׁלִישִׁי הַבָּא בִּתְשַׁע בַּבֹּקֶר.",
            exampleNative = "אֵייץ׳-אַר пригласил меня на следующий вторник к девяти утра.",
         fillInBlankExclusions = listOf(175006L, 175008L, 175009L, 175010L)),
        WordEntity(
            id = 175008, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_recruiter", transliteration = "skrining",
            original = "סְקְרִינִינְג", translation = "скрининг (предварительный отсев)",
            definition = "שָׁלָב רִאשׁוֹנִי שֶׁל סִינּוּן מֻעֳמָדִים לְפִי קוֹרוֹת חַיִּים וְשִׂיחָה קְצָרָה.",
            definitionNative = "Первый этап отсева кандидатов: смотрят CV и проводят короткую беседу.",
            example = "אַחֲרֵי הַסְּקְרִינִינְג קִבַּלְתִּי הַזְמָנָה לְשִׂיחָה טֶכְנִית.",
            exampleNative = "После סְקְרִינִינְג я получил приглашение на технический разговор.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175009, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_recruiter", transliteration = "sokhnut hashama",
            original = "סוֹכְנוּת הַשָּׂמָה", translation = "кадровое агентство",
            definition = "חֶבְרָה חִיצוֹנִית שֶׁמְּחַבֶּרֶת בֵּין מֻעֳמָדִים לְבֵין מַעֲסִיקִים תְּמוּרַת עֲמָלָה.",
            definitionNative = "Внешняя фирма-посредник между кандидатом и работодателем за комиссию.",
            example = "סוֹכְנוּת הַשָּׂמָה מַצְלִיחָה לִמְצוֹא הַתְאָמוֹת מַהֵר יוֹתֵר מֵחֶבְרָה לְבַד.",
            exampleNative = "סוֹכְנוּת הַשָּׂמָה находит совпадения быстрее, чем компания сама.",
         fillInBlankExclusions = listOf(175006L, 175007L, 175008L, 175010L)),
        WordEntity(
            id = 175010, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_recruiter", transliteration = "tsayad rashim",
            original = "צַיָּד רָאשִׁים", translation = "хедхантер",
            definition = "מְגַיֵּיס בָּכִיר שֶׁמְּחַפֵּשׂ בְּכִירִים בְּתַפְקִידֵי מַפְתֵּחַ בְּשׁוּק סָגוּר.",
            definitionNative = "Старший рекрутер: ищет топов на ключевые роли в закрытом рынке.",
            example = "צַיָּד רָאשִׁים פָּנָה אֵלַי בְּלִינְקְדְאִין עִם הַצָּעָה דִּיסְקְרֵטִית.",
            exampleNative = "צַיָּד רָאשִׁים связался со мной в LinkedIn с конфиденциальным предложением.",
         fillInBlankExclusions = listOf(175006L, 175007L, 175008L, 175009L)),

        // ── interview_first_call (5) — первый звонок и базовые вопросы ──
        WordEntity(
            id = 175011, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_first_call", transliteration = "sikhat heikherut",
            original = "שִׂיחַת הֶכֵּרוּת", translation = "ознакомительный звонок",
            definition = "שִׂיחָה רִאשׁוֹנָה בְּלִי טֶכְנִיקָה שֶׁמְּטַפֶּסֶת אֶת הָרֶקַע וְהָרָצוֹן שֶׁל הַמֻּעֳמָד.",
            definitionNative = "Первый разговор без техники — узнают фон и желание кандидата.",
            example = "שִׂיחַת הֶכֵּרוּת נִמְשְׁכָה רַק עֶשְׂרִים דַּקּוֹת בַּזּוּם.",
            exampleNative = "שִׂיחַת הֶכֵּרוּת длилась всего двадцать минут в Зуме.",
         fillInBlankExclusions = listOf(175008L, 175012L, 175013L, 175014L, 175015L)),
        WordEntity(
            id = 175012, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_first_call", transliteration = "tsipiyot sakhar",
            original = "צִפִּיּוֹת שָׂכָר", translation = "ожидания по зарплате",
            definition = "סְכוּם שֶׁהַמֻּעֳמָד מַזְכִּיר כְּשֶׁשּׁוֹאֲלִים אוֹתוֹ עַל גֹּדֶל הַמַּשְׂכֹּרֶת הָרָצוּי.",
            definitionNative = "Сумма, которую кандидат называет, когда спрашивают о желаемой зарплате.",
            example = "כְּשֶׁשָּׁאֲלוּ עַל צִפִּיּוֹת שָׂכָר, נָקַבְתִּי טְוָוח רָחָב.",
            exampleNative = "Когда спросили про צִפִּיּוֹת שָׂכָר, я назвал широкий диапазон.",
         fillInBlankExclusions = listOf(175011L, 175013L, 175014L, 175015L)),
        WordEntity(
            id = 175013, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_first_call", transliteration = "format he'asaka",
            original = "פוֹרְמָט הַעֲסָקָה", translation = "формат занятости",
            definition = "אֹפֶן הָעֲבוֹדָה שֶׁל הַמִּשְׂרָה: מָלֵא, חֶלְקִי, פְרִילַנְס אוֹ קַבְּלָנִי.",
            definitionNative = "Тип занятости: полный день, частичная, фриланс или подряд.",
            example = "הַחֶבְרָה הֶעֱדִיפָה פוֹרְמָט הַעֲסָקָה מָלֵא בִּלְבַד, לֹא פְרִילַנְס.",
            exampleNative = "Компания предпочитала только פוֹרְמָט הַעֲסָקָה на полный день, без фриланса.",
         fillInBlankExclusions = listOf(175011L, 175012L, 175014L, 175015L)),
        WordEntity(
            id = 175014, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_first_call", transliteration = "mikum hamisrad",
            original = "מִיקּוּם הַמִּשְׂרָד", translation = "локация офиса",
            definition = "הַכְּתֹבֶת הַפִיסִית שֶׁל הַחֶבְרָה שֶׁבָּהּ הָעוֹבֵד מַגִּיעַ פִיסִית.",
            definitionNative = "Физический адрес фирмы, куда сотрудник приходит лично.",
            example = "מִיקּוּם הַמִּשְׂרָד בְּהֶרְצְלִיָּה לֹא נוֹחַ לִי בְּלִי רֶכֶב.",
            exampleNative = "מִיקּוּם הַמִּשְׂרָד в Герцлии мне неудобен без машины.",
         fillInBlankExclusions = listOf(175011L, 175012L, 175013L, 175015L)),
        WordEntity(
            id = 175015, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_first_call", transliteration = "havtakhat khazara",
            original = "הַבְטָחַת חֲזָרָה", translation = "обещание перезвонить",
            definition = "אֲמִירָה שֶׁל הַמְּגַיֵּיס בְּסוֹף שִׂיחָה שֶׁתִּתְקַבֵּל תְּשׁוּבָה תּוֹךְ זְמַן מֻגְדָּר.",
            definitionNative = "Слова рекрутера в конце звонка: ответ придёт в названный срок.",
            example = "קִבַּלְתִּי הַבְטָחַת חֲזָרָה תּוֹךְ שָׁבוּעַ אֲבָל לֹא הִתְקַשְּׁרוּ.",
            exampleNative = "Я получил הַבְטָחַת חֲזָרָה в течение недели — но не позвонили.",
         fillInBlankExclusions = listOf(175011L, 175012L, 175013L, 175014L)),

        // ── interview_experience (5) — опыт, образование, навыки ──
        WordEntity(
            id = 175016, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_experience", transliteration = "vetek miktso'i",
            original = "וֶתֶק מִקְצוֹעִי", translation = "профессиональный стаж",
            definition = "מִסְפַּר הַשָּׁנִים שֶׁאָדָם עוֹבֵד בִּתְחוּם מְסֻיָּם מֵאָז סוֹף הַלִּימּוּדִים.",
            definitionNative = "Сколько лет человек работает в одной сфере с конца учёбы.",
            example = "הִיא בִּקְשָׁה מַשְׂכֹּרֶת גְּבוֹהָה בִּגְלַל וֶתֶק מִקְצוֹעִי שֶׁל שְׁנֵים עָשָׂר שָׁנָה.",
            exampleNative = "Она запросила высокую зарплату из-за וֶתֶק מִקְצוֹעִי в двенадцать лет.",
         fillInBlankExclusions = listOf(175017L, 175018L, 175019L, 175020L)),
        WordEntity(
            id = 175017, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_experience", transliteration = "tafkid kodem",
            original = "תַּפְקִיד קוֹדֵם", translation = "предыдущая должность",
            definition = "הַמִּשְׂרָה שֶׁבָּהּ הַמֻּעֳמָד עָבַד לִפְנֵי שֶׁעָזַב לְחַפֵּשׂ מַשֶּׁהוּ חָדָשׁ.",
            definitionNative = "Должность, на которой кандидат был до того, как ушёл искать новую.",
            example = "סִפַּרְתִּי בִּפְרוֹטְרוֹט עַל תַּפְקִיד קוֹדֵם בְּחֶבְרַת בִּטּוּחַ.",
            exampleNative = "Я подробно рассказал про תַּפְקִיד קוֹדֵם в страховой фирме.",
         fillInBlankExclusions = listOf(175016L, 175018L, 175019L, 175020L)),
        WordEntity(
            id = 175018, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_experience", transliteration = "to'ar rishon",
            original = "תֹּאַר רִאשׁוֹן", translation = "степень бакалавра",
            definition = "הַתְּעוּדָה הָאַקָדֵמִית הָרִאשׁוֹנָה אַחֲרֵי שָׁלוֹשׁ-אַרְבַּע שָׁנוֹת לִימּוּד בְּמוֹסָד.",
            definitionNative = "Первая академическая бумага — после трёх-четырёх лет учёбы в вузе.",
            example = "סִיַּמְתִּי תֹּאַר רִאשׁוֹן בְּמַדְעֵי הַמַּחְשֵׁב בָּאוּנִיבֶרְסִיטָה הָעִבְרִית.",
            exampleNative = "Я закончил תֹּאַר רִאשׁוֹן по computer science в Еврейском университете.",
         fillInBlankExclusions = listOf(175016L, 175017L, 175019L, 175020L)),
        WordEntity(
            id = 175019, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_experience", transliteration = "te'udat siyum",
            original = "תְּעוּדַת סִיּוּם", translation = "диплом об окончании",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁמַּעֲנִיק הַמּוֹסָד אַחֲרֵי שֶׁכָּל הַחוֹבוֹת הָאֵקָדֵמִיוֹת בּוּצְּעוּ.",
            definitionNative = "Официальная бумага вуза после того, как все академические долги закрыты.",
            example = "צְרִיכִים סְרִיקָה שֶׁל תְּעוּדַת סִיּוּם לִבְדִיקַת רֶקַע מֵהַחֶבְרָה.",
            exampleNative = "Нужен скан תְּעוּדַת סִיּוּם для проверки бэкграунда от компании.",
         fillInBlankExclusions = listOf(175016L, 175017L, 175018L, 175020L)),
        WordEntity(
            id = 175020, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_experience", transliteration = "stak teknologi",
            original = "סְטָאק טֶכְנוֹלוֹגִי", translation = "технологический стек",
            definition = "אֹסֶף שָׂפוֹת תִּכְנוּת וְכֵלִים שֶׁעוֹבֵד שׁוֹלֵט בָּהֶם בְּעֲבוֹדָה הַיּוֹמְיוֹמִית.",
            definitionNative = "Набор языков программирования и инструментов, которыми инженер владеет каждый день.",
            example = "הִצַּגְתִּי אֶת הַסְּטָאק טֶכְנוֹלוֹגִי שֶׁלִּי: רִיאֵקְט, נוֹד וּפּוֹסְטְגְּרֶס.",
            exampleNative = "Я показал свой סְטָאק טֶכְנוֹלוֹגִי: React, Node и Postgres.",
            isFillInBlankSafe = false,
        ),

        // ── interview_motivation (5) — мотивация и сильные стороны ──
        WordEntity(
            id = 175021, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_motivation", transliteration = "motivatsya pnimit",
            original = "מוֹטִיבַצְיָה פְּנִימִית", translation = "внутренняя мотивация",
            definition = "הַסִּבָּה הָאֲמִיתִּית שֶׁמַּנִּיעָה אָדָם לַעֲבוֹד, לֹא כֶּסֶף וְלֹא לַחַץ חִיצוֹנִי.",
            definitionNative = "Настоящая причина, что движет человеком — не деньги и не давление снаружи.",
            example = "הַשּׁוֹאֵל בִּקֵּשׁ לְהָבִין מָה הַמּוֹטִיבַצְיָה פְּנִימִית שֶׁלִּי לְהַחְלִיף תַּפְקִיד.",
            exampleNative = "Спрашивающий хотел понять, что у меня за מוֹטִיבַצְיָה פְּנִימִית — поменять должность.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175022, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_motivation", transliteration = "tsedadim khazakim",
            original = "צְדָדִים חֲזָקִים", translation = "сильные стороны",
            definition = "הַתְּכוּנוֹת שֶׁבָּהֶן אַתָּה הֲכִי טוֹב — מַה שֶּׁאַתָּה מַצְלִיחַ בּוֹ לְלֹא מַאֲמָץ.",
            definitionNative = "Качества, в которых ты лучше всего — то, что выходит без усилий.",
            example = "אַחַד הַצְּדָדִים חֲזָקִים שֶׁלִּי הוּא דִּבּוּר מוּל קָהָל גָּדוֹל.",
            exampleNative = "Одна из моих צְדָדִים חֲזָקִים — это речь перед большой аудиторией.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175023, setId = 1750, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_motivation", transliteration = "nekudot le-shipur",
            original = "נְקֻדּוֹת לְשִׁפּוּר", translation = "слабые стороны (зоны роста)",
            definition = "תְּחוּמִים שֶׁאַתָּה פָּחוֹת חָזָק בָּהֶם וְעוֹבֵד עֲלֵיהֶם בִּמְכֻוָּן.",
            definitionNative = "Сферы, в которых ты слабее, и над которыми работаешь сознательно.",
            example = "הִזְכַּרְתִּי נְקֻדּוֹת לְשִׁפּוּר בְּלִי לְהַסְתִּיר חֻלְשׁוֹת אֲמִיתִּיוֹת.",
            exampleNative = "Я упомянул נְקֻדּוֹת לְשִׁפּוּר, не скрывая настоящие слабые места.",
         fillInBlankExclusions = listOf(175021L, 175022L, 175024L, 175025L)),
        WordEntity(
            id = 175024, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_motivation", transliteration = "siba la-azuva",
            original = "סִבָּה לַעֲזִיבָה", translation = "причина ухода",
            definition = "הַהֶסְבֵּר שֶׁל מֻעֳמָד מַדּוּעַ הוּא עוֹזֵב אֶת הַמָּקוֹם שֶׁבּוֹ הוּא עוֹבֵד עַכְשָׁיו.",
            definitionNative = "Объяснение кандидата — почему он уходит с нынешнего места работы.",
            example = "סִבָּה לַעֲזִיבָה הַטֶּבֶעִית הָיְתָה רָצוֹן לִתְחוּם חָדָשׁ.",
            exampleNative = "Естественная סִבָּה לַעֲזִיבָה — желание сменить сферу.",
         fillInBlankExclusions = listOf(175021L, 175022L, 175023L, 175025L)),
        WordEntity(
            id = 175025, setId = 1750, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_motivation", transliteration = "she'elot la-mera'ayen",
            original = "שְׁאֵלוֹת לַמְּרַאֲיֵין", translation = "вопросы к интервьюеру",
            definition = "מָה שֶׁמֻעֳמָד שׁוֹאֵל בַּסּוֹף עַל הַחֶבְרָה כְּדֵי לְהַרְאוֹת עִנְיָן רְצִינִי.",
            definitionNative = "То, что кандидат спрашивает в конце о фирме — чтобы показать настоящий интерес.",
            example = "הֵכַנְתִּי שָׁלוֹשׁ שְׁאֵלוֹת לַמְּרַאֲיֵין מֵרֹאשׁ עַל תַּרְבּוּת הַצֶּוֶות.",
            exampleNative = "Я заранее подготовил три שְׁאֵלוֹת לַמְּרַאֲיֵין про культуру команды.",
         fillInBlankExclusions = listOf(175021L, 175022L, 175023L, 175024L)),

        // ══════════════════════════════════════════════════════════════════════
        // Set 1751 — Собеседования: профессиональный (L4, RARE+EPIC)
        // 5 групп × 5 слов: tech, behavioral, offer, equity, negotiation
        // ══════════════════════════════════════════════════════════════════════

        // ── interview_tech (5) — технические этапы интервью ──
        WordEntity(
            id = 175101, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_tech", transliteration = "koding chalenj",
            original = "קוֹדִינְג צֶ׳אלֶנְג׳", translation = "coding challenge",
            definition = "מְשִׂימַת תִּכְנוּת בְּזְמַן קָצוּב שֶׁפּוֹתְרִים מוּל הַמְּרַאֲיֵין כְּדֵי לְהַרְאוֹת חֲשִׁיבָה.",
            definitionNative = "Задача на код в ограниченное время — решают при интервьюере для проверки мышления.",
            example = "קוֹדִינְג צֶ׳אלֶנְג׳ הָיָה אַלְגוֹרִיתְם גְּרָפִים בַּפְּלַטְפוֹרְמָה הַחִיצוֹנִית.",
            exampleNative = "קוֹדִינְג צֶ׳אלֶנְג׳ оказался алгоритмом на графах на внешней платформе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175102, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_tech", transliteration = "hom asayinment",
            original = "הוֹם אַסַיְינְמֶנְט", translation = "take-home assignment",
            definition = "מְשִׂימָה גְּדוֹלָה שֶׁעוֹשִׂים בַּבַּיִת בְּכַמָּה יָמִים בְּלִי הַשְׁגָּחָה שֶׁל מְרַאֲיֵין.",
            definitionNative = "Большое задание дома на пару дней — без надзора интервьюера.",
            example = "הִשְׁקַעְתִּי שִׁישָּׁה לֵילוֹת בַּהוֹם אַסַיְינְמֶנְט שֶׁל הַסְּטַרְטְאַפּ.",
            exampleNative = "Я вложил шесть вечеров в הוֹם אַסַיְינְמֶנְט от стартапа.",
         fillInBlankExclusions = listOf(175101L, 175103L, 175104L, 175105L)),
        WordEntity(
            id = 175103, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_tech", transliteration = "system dizayn",
            original = "סִיסְטֶם דִּיזַיְין", translation = "system design",
            definition = "סוּג רֵאָיוֹן שֶׁבּוֹ דָּנִים אֶיךְ בּוֹנִים מַעֲרֶכֶת גְּדוֹלָה מֵהַתְחָלָה עַל לוּחַ.",
            definitionNative = "Тип интервью: обсуждают, как с нуля построить большую систему — на доске.",
            example = "סִיסְטֶם דִּיזַיְין דָּרַשׁ לְפָרֵט מַאֲגָר מֵידָע, קֶשֶׁ וְתוֹר הוֹדָעוֹת.",
            exampleNative = "סִיסְטֶם דִּיזַיְין потребовал расписать БД, кэш и очередь сообщений.",
         fillInBlankExclusions = listOf(175101L, 175102L, 175104L, 175105L)),
        WordEntity(
            id = 175104, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_tech", transliteration = "per programing",
            original = "פֶּר פְּרוֹגְרָמִינְג", translation = "pair programming",
            definition = "פוֹרְמָט שֶׁל קְצָת זוּג — מְרַאֲיֵין וּמֻעֳמָד כּוֹתְבִים בְּיַחַד עַל אוֹתוֹ עוֹרֵךְ.",
            definitionNative = "Формат «в паре»: интервьюер и кандидат пишут вместе в одном редакторе.",
            example = "פֶּר פְּרוֹגְרָמִינְג עָזַר לְהַרְאוֹת אֵיךְ אֲנִי שׁוֹאֵל וּמְקַבֵּל הֲצָעוֹת.",
            exampleNative = "פֶּר פְּרוֹגְרָמִינְג помог показать, как я задаю вопросы и принимаю предложения.",
         fillInBlankExclusions = listOf(175101L, 175102L, 175103L, 175105L)),
        WordEntity(
            id = 175105, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_tech", transliteration = "vaitbord",
            original = "וַיְיטְבּוֹרְד", translation = "whiteboard (доска)",
            definition = "לוּחַ מָחִיק לָבָן שֶׁעָלָיו הַמֻּעֳמָד כּוֹתֵב קוֹד אוֹ דְּיַאגְרָמָה לִפְנֵי הַשּׁוֹאֵל.",
            definitionNative = "Белая маркерная доска — кандидат пишет на ней код или схему перед интервьюером.",
            example = "וַיְיטְבּוֹרְד הָיָה מָלֵא בִּדְיָאגְרָמוֹת בְּסוֹף הַשִּׂיחָה.",
            exampleNative = "וַיְיטְבּוֹרְד была покрыта диаграммами в конце разговора.",
         fillInBlankExclusions = listOf(175101L, 175102L, 175103L, 175104L)),

        // ── interview_behavioral (5) — поведенческие интервью ──
        WordEntity(
            id = 175106, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_behavioral", transliteration = "ra'ayon hitnahaguti",
            original = "רֵאָיוֹן הִתְנַהֲגוּתִי", translation = "поведенческое интервью",
            definition = "רֵאָיוֹן שֶׁל סִיפּוּרִים עַל מַצָּבֵי עֲבָר אֲמִיתִּיִּים בִּמְקוֹם שְׁאֵלוֹת תֵּיאוֹרֶטִיּוֹת.",
            definitionNative = "Интервью на историях из реального прошлого — вместо теоретических вопросов.",
            example = "רֵאָיוֹן הִתְנַהֲגוּתִי שָׁאַל עַל קוֹנְפְלִיקְט עִם עָמִית בְּפְרוֹיֶקְט קַשֶׁה.",
            exampleNative = "רֵאָיוֹן הִתְנַהֲגוּתִי спрашивал про конфликт с коллегой в трудном проекте.",
         fillInBlankExclusions = listOf(175107L, 175108L, 175109L, 175110L)),
        WordEntity(
            id = 175107, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_behavioral", transliteration = "soft skils",
            original = "סוֹפְט סְקִילְס", translation = "soft skills",
            definition = "כִּשּׁוּרִים בֵּינְאִישִׁיִּים כְּמוֹ תִּקְשׁוֹרֶת, הַקְשָׁבָה וְעֲבוֹדַת צֶוֶות, לֹא טֶכְנִיּוֹת.",
            definitionNative = "Межличностные качества — общение, слушание, командная работа, не технические.",
            example = "מְנַהֲלִים מַעֲדִיפִים סוֹפְט סְקִילְס חֲזָקִים עַל פְּנֵי בְּכִיר טֶכְנִי לְבַד.",
            exampleNative = "Менеджеры предпочитают сильные סוֹפְט סְקִילְס, а не только технического сеньора.",
         fillInBlankExclusions = listOf(175106L, 175108L, 175109L, 175110L)),
        WordEntity(
            id = 175108, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_behavioral", transliteration = "fit tarbuti",
            original = "פִיט תַּרְבּוּתִי", translation = "культурное соответствие (fit)",
            definition = "הַתְאָמָה שֶׁל הָאָדָם לַסְּגַנּוֹן וְלָעֲרָכִים שֶׁל הַחֶבְרָה הַסְּפֵצִיפִית.",
            definitionNative = "Совпадение человека со стилем и ценностями конкретной фирмы.",
            example = "סִינְּנוּ אוֹתִי בִּגְלַל פִיט תַּרְבּוּתִי, לֹא בִּגְלַל הַיְּכוֹלוֹת הַטֶּכְנִיּוֹת.",
            exampleNative = "Меня отсеяли из-за פִיט תַּרְבּוּתִי, а не из-за технических умений.",
         fillInBlankExclusions = listOf(175106L, 175107L, 175109L, 175110L)),
        WordEntity(
            id = 175109, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_behavioral", transliteration = "manhigut",
            original = "מַנְהִיגוּת", translation = "лидерство",
            definition = "יְכוֹלֶת לְהַנְחוֹת אַחֵרִים לְעֵבֶר מַטָּרָה מְשֻׁתֶּפֶת בְּלִי לְהַפְעִיל כֹּחַ.",
            definitionNative = "Умение вести других к общей цели, не применяя силу.",
            example = "הוּא הִצִּיג מַנְהִיגוּת בְּסִיפּוּר עַל הַצָּלַת פְּרוֹיֶקְט בִּמְשַׁבֵּר.",
            exampleNative = "Он показал מַנְהִיגוּת в истории спасения проекта в кризисе.",
         fillInBlankExclusions = listOf(175106L, 175107L, 175108L, 175110L)),
        WordEntity(
            id = 175110, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_behavioral", transliteration = "shituf pe'ula",
            original = "שִׁתּוּף פְּעֻלָּה", translation = "коллаборация (teamwork)",
            definition = "עֲבוֹדָה מְשֻׁתֶּפֶת שֶׁל מַסְפַּר אֲנָשִׁים לְמַטָּרָה אַחַת בְּלִי לְהִתְחָרוֹת זֶה בָּזֶה.",
            definitionNative = "Совместная работа нескольких людей к одной цели — без соперничества внутри.",
            example = "הֵבַנְתִּי שֶׁשִּׁתּוּף פְּעֻלָּה חָשׁוּב שָׁם יוֹתֵר מִיֵּשֵׁג אִישִׁי.",
            exampleNative = "Я понял, что שִׁתּוּף פְּעֻלָּה там важнее личного достижения.",
            isFillInBlankSafe = false,
        ),

        // ── interview_offer (5) — оффер и его компоненты ──
        WordEntity(
            id = 175111, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_offer", transliteration = "ofer",
            original = "אוֹפֶר", translation = "оффер",
            definition = "הַצָּעַת עֲבוֹדָה רִשְׁמִית בִּכְתָב עִם תַּפְקִיד, מַשְׂכֹּרֶת וּתְנָאִים נִלְוִים.",
            definitionNative = "Письменное предложение работы — должность, оплата и сопутствующие условия.",
            example = "קִבַּלְתִּי אוֹפֶר טוֹב מֵאֲרְבָּעָה רְאָיוֹנוֹת בְּסַךְ הַכֹּל.",
            exampleNative = "Я получил хороший אוֹפֶר после в общей сложности четырёх собеседований.",
         fillInBlankExclusions = listOf(175112L, 175113L, 175114L, 175115L)),
        WordEntity(
            id = 175112, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_offer", transliteration = "kaunter",
            original = "קַאוּנְטֶר", translation = "контр-оффер (counter)",
            definition = "תְּגוּבָה מְשֻׁפֶּרֶת שֶׁמַּעֲסִיק נוֹכְחִי שׁוֹלֵחַ כְּדֵי לִשְׁמֹר עַל עוֹבֵד שֶׁעוֹזֵב.",
            definitionNative = "Улучшенный ответ от текущего работодателя — чтоб удержать уходящего.",
            example = "הַבּוֹס שֶׁלִּי שָׁלַח קַאוּנְטֶר יוֹם אַחֲרֵי שֶׁהוֹדַעְתִּי עַל פְּרִישָׁה.",
            exampleNative = "Мой босс прислал קַאוּנְטֶר на следующий день после моего предупреждения об уходе.",
         fillInBlankExclusions = listOf(175111L, 175113L, 175114L, 175115L, 175122L)),
        WordEntity(
            id = 175113, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_offer", transliteration = "moed teshuva",
            original = "מוֹעֵד תְּשׁוּבָה", translation = "дедлайн на ответ",
            definition = "הַתַּאֲרִיךְ הָאַחֲרוֹן שֶׁבּוֹ מֻעֳמָד צָרִיךְ לְהַחְלִיט אִם הוּא חוֹתֵם עַל הַהַצָּעָה.",
            definitionNative = "Последняя дата, к которой кандидат должен решить — подписывает ли он.",
            example = "מוֹעֵד תְּשׁוּבָה הָיָה קָצָר מִדַּי וּבִקַּשְׁתִּי הַאֲרָכָה.",
            exampleNative = "מוֹעֵד תְּשׁוּבָה был слишком короткий — я попросил продление.",
         fillInBlankExclusions = listOf(175111L, 175112L, 175114L, 175115L)),
        WordEntity(
            id = 175114, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_offer", transliteration = "sakhar basis",
            original = "שָׂכָר בָּסִיס", translation = "базовая зарплата",
            definition = "הַסְּכוּם הַחָדְשִׁי הַקָּבוּעַ שֶׁעוֹבֵד מְקַבֵּל בְּלִי בּוֹנוּסִים אוֹ אוֹפְצְיוֹת.",
            definitionNative = "Постоянная месячная сумма для сотрудника — без бонусов и опционов.",
            example = "שָׂכָר בָּסִיס הָיָה גָּבוֹהַּ אֲבָל הַמַּסְלוּל הָאַרֻוךְ דַּל יוֹתֵר.",
            exampleNative = "שָׂכָר בָּסִיס оказался высоким, но долгосрочный путь — слабее.",
         fillInBlankExclusions = listOf(175111L, 175112L, 175113L, 175115L)),
        WordEntity(
            id = 175115, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_offer", transliteration = "khaviya kollelet",
            original = "חֲבִילָה כּוֹלֶלֶת", translation = "общий пакет (total compensation)",
            definition = "סַךְ כָּל הָרְכִיבִים — מַשְׂכֹּרֶת, בּוֹנוּס, מְנָיוֹת וְהַטָּבוֹת — שָׁנָה אַחַת.",
            definitionNative = "Сумма всех компонентов: оклад, бонус, акции и льготы — за один год.",
            example = "חֲבִילָה כּוֹלֶלֶת בְּגוּגַל מִתְקָרֶבֶת לַחֲצִי מִילְיוֹן שֶׁקֶל לַשָּׁנָה.",
            exampleNative = "חֲבִילָה כּוֹלֶלֶת в Google приближается к полумиллиону шекелей в год.",
         fillInBlankExclusions = listOf(175111L, 175112L, 175113L, 175114L)),

        // ── interview_equity (5) — акции и долгосрочные компоненты ──
        WordEntity(
            id = 175116, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_equity", transliteration = "ekviti",
            original = "אֶקְוִוִיטִי", translation = "equity (доля)",
            definition = "חֵלֶק מֵהַבַּעֲלוּת שֶׁל הַחֶבְרָה שֶׁעוֹבֵד מְקַבֵּל בְּתוֹסֶפֶת לַמַּשְׂכֹּרֶת.",
            definitionNative = "Часть владения фирмой, которую сотрудник получает в дополнение к зарплате.",
            example = "אֶקְוִוִיטִי בִּסְטַרְטְאַפּ מֻקְדָּם שָׁוֶה הַרְבֵּה אוֹ כְּלוּם.",
            exampleNative = "אֶקְוִוִיטִי в раннем стартапе стоит много или ничего.",
         fillInBlankExclusions = listOf(175117L, 175118L, 175119L, 175120L)),
        WordEntity(
            id = 175117, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_equity", transliteration = "ar-es-yu",
            original = "אַר-אֶס-יוּ", translation = "RSU (restricted stock units)",
            definition = "מְנָיוֹת מוּגְבָּלוֹת שֶׁעוֹבֵד מְקַבֵּל בִּסְטָאדִיוֹם לְפִי לוּחַ זְמַנִּים שֶׁל הַחֶבְרָה.",
            definitionNative = "Ограниченные акции, которые приходят сотруднику постепенно по графику фирмы.",
            example = "אַר-אֶס-יוּ אֵצֶל מֵטָא הִתְפַּצְּלוּ עַל אַרְבַּע שָׁנִים בְּדִיוּק.",
            exampleNative = "אַר-אֶס-יוּ в Meta поделили ровно на четыре года.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175118, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_equity", transliteration = "optsiyot",
            original = "אוֹפְּצְיוֹת", translation = "опционы",
            definition = "זְכוּת לִקְנוֹת מְנָיוֹת בְּמְחִיר נָמוּךְ קָבוּעַ אַחֲרֵי תְּקוּפָה שֶׁל עֲבוֹדָה.",
            definitionNative = "Право купить акции по фиксированной низкой цене — после периода работы.",
            example = "אוֹפְּצְיוֹת שֶׁלִּי יִהְיוּ שָׁווֹת רַק אִם הַחֶבְרָה תַּצְלִיחַ לְהַנְפִּיק.",
            exampleNative = "Мои אוֹפְּצְיוֹת будут чего-то стоить, только если фирма выйдет на IPO.",
         fillInBlankExclusions = listOf(175116L, 175117L, 175119L, 175120L)),
        WordEntity(
            id = 175119, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_equity", transliteration = "sayning bonus",
            original = "סַיְינִינְג בּוֹנוּס", translation = "signing bonus",
            definition = "סְכוּם חָד-פַּעֲמִי שֶׁמְקַבֵּל עוֹבֵד מִיָּד עִם חֲתִימָתוֹ עַל הַחוֹזֶה הַחָדָשׁ.",
            definitionNative = "Разовая сумма сотруднику сразу при подписании нового договора.",
            example = "סַיְינִינְג בּוֹנוּס שֶׁל חֲמִישִּׁים אֶלֶף שֶׁקֶל פִּצָּה אוֹתִי עַל הַמַּעֲבָר.",
            exampleNative = "סַיְינִינְג בּוֹנוּס в пятьдесят тысяч шекелей компенсировал мне переход.",
         fillInBlankExclusions = listOf(175116L, 175117L, 175118L, 175120L)),
        WordEntity(
            id = 175120, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_equity", transliteration = "vesting",
            original = "וֶסְטִינְג", translation = "вестинг (период созревания акций)",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ מְנָיוֹת אוֹ אוֹפְּצְיוֹת נַעֲשׂוֹת שֶׁל הָעוֹבֵד בְּהַדְרָגָה לְאוֹרֶךְ שָׁנִים.",
            definitionNative = "Процесс, когда акции или опционы достаются сотруднику постепенно за годы.",
            example = "וֶסְטִינְג סְטַנְדַּרְטִי הוּא אַרְבַּע שָׁנִים עִם שָׁנָה רִאשׁוֹנָה חוֹסֶמֶת.",
            exampleNative = "Стандартный וֶסְטִינְג — это четыре года с блокированным первым годом.",
         fillInBlankExclusions = listOf(175116L, 175117L, 175118L, 175119L)),

        // ── interview_negotiation (5) — переговоры и финал ──
        WordEntity(
            id = 175121, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_negotiation", transliteration = "masa u-matan",
            original = "מַשָּׂא וּמַתָּן", translation = "переговоры",
            definition = "שִׂיחָה הֲדָדִית שֶׁבָּהּ שְׁנֵי הַצְּדָדִים מְנַסִּים לְהַשִּׂיג תְּנָאִים טוֹבִים יוֹתֵר.",
            definitionNative = "Двусторонняя беседа, в которой стороны пытаются добиться лучших условий.",
            example = "מַשָּׂא וּמַתָּן עַל הַחֲבִילָה הִתְמַשֵּׁךְ שָׁבוּעַ שָׁלֵם.",
            exampleNative = "מַשָּׂא וּמַתָּן о пакете растянулся на целую неделю.",
         fillInBlankExclusions = listOf(175122L, 175123L, 175124L, 175125L)),
        WordEntity(
            id = 175122, setId = 1751, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "interview_negotiation", transliteration = "hatsa'a-shkenged",
            original = "הַצָּעָה שֶׁכְּנֶגֶד", translation = "встречное предложение",
            definition = "תְּגוּבָה שֶׁל מֻעֳמָד עַל הַהַצָּעָה הָרִאשׁוֹנִית עִם תְּנָאִים אֲחֵרִים אוֹ שׂוֹנִים.",
            definitionNative = "Ответ кандидата на исходное предложение — с другими или изменёнными условиями.",
            example = "הַצָּעָה שֶׁכְּנֶגֶד שֶׁלִּי הִכְנִיסָה עוֹד שָׁבוּעַ חֻפְשָׁה לַהַסְכֵּם.",
            exampleNative = "Моя הַצָּעָה שֶׁכְּנֶגֶד добавила в соглашение ещё одну неделю отпуска.",
         fillInBlankExclusions = listOf(175112L, 175121L, 175123L, 175124L, 175125L)),
        WordEntity(
            id = 175123, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_negotiation", transliteration = "ritenshen",
            original = "רִיטֶנְשֶׁן", translation = "retention (удержание сотрудника)",
            definition = "מַאֲמַץ שֶׁל הַחֶבְרָה לִשְׁמֹר עוֹבֵד טוֹב בְּעֵת הַזְמָנָה לְמָקוֹם אַחֵר.",
            definitionNative = "Усилия фирмы — удержать ценного сотрудника, когда его зовут в другое место.",
            example = "מְדִינוֹת רִיטֶנְשֶׁן בַּחֶבְרָה כּוֹלְלוֹת בּוֹנוּסִים שְׁנָתִיִּים גְּדוֹלִים.",
            exampleNative = "Политика רִיטֶנְשֶׁן в фирме включает большие ежегодные бонусы.",
         fillInBlankExclusions = listOf(175121L, 175122L, 175124L, 175125L)),
        WordEntity(
            id = 175124, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_negotiation", transliteration = "nekudat prisha",
            original = "נְקֻדַּת פְּרִישָׁה", translation = "точка отказа (walk-away)",
            definition = "סְכוּם אוֹ תְּנַאי שֶׁמִתַּחַת לָהֶם הַמֻּעֳמָד מַחְלִיט מִכָּתְחִילָה לֹא לַחְתֹּם.",
            definitionNative = "Сумма или условие, ниже которого кандидат заранее решает не подписывать.",
            example = "קָבַעְתִּי לְעַצְמִי נְקֻדַּת פְּרִישָׁה בְּרוּרָה לִפְנֵי שֶׁדִּבַּרְתִּי עִם הַחֶבְרָה.",
            exampleNative = "Я установил себе чёткую נְקֻדַּת פְּרִישָׁה ещё до разговора с фирмой.",
         fillInBlankExclusions = listOf(175121L, 175122L, 175123L, 175125L)),
        WordEntity(
            id = 175125, setId = 1751, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_negotiation", transliteration = "havtakhat ha'avara",
            original = "הַבְטָחַת הַעֲבָרָה", translation = "релокационный пакет",
            definition = "אֹסֶף הַטָּבוֹת לְעוֹבֵד שֶׁעוֹבֵר לְעִיר אַחֶרֶת אוֹ לִמְדִינָה אַחֶרֶת בִּגְלַל הַתַּפְקִיד.",
            definitionNative = "Набор льгот сотруднику при переезде в другой город или страну ради должности.",
            example = "הַבְטָחַת הַעֲבָרָה כִּסְּתָה דִּירָה זְמַנִּית וּטִיסוֹת לַמִּשְׁפָּחָה.",
            exampleNative = "הַבְטָחַת הַעֲבָרָה покрыла временное жильё и перелёты для семьи.",
         fillInBlankExclusions = listOf(175121L, 175122L, 175123L, 175124L)),
    )
}
