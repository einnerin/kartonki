package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 470.
 * Работа и карьера: удалёнка, фриланс и agile (L3 / UNCOMMON + RARE).
 *
 * Расширение темы «Работа и карьера». Дополняет существующие сеты:
 *   - 22, 41    — базовая офисная лексика (job, office, career, deadline, overtime).
 *   - 69        — корпоративная иерархия (hierarchy, bureaucracy, workflow, induction).
 *   - 203, 243  — профессии (chef, plumber, prosecutor, actuary).
 *   - 255       — поиск работы и HR (CV, applicant, recruiter, probation, onboarding).
 *   - 260       — деловая переписка (subject line, follow-up, memo).
 *   - 338 (L3)  — углублённая лексика (onboard, mentor, telecommute, retainer, backlog,
 *                 milestone, sabbatical, kickoff, micromanager).
 *   - 339 (L5)  — редкая корпоративная лексика (sinecure, doyen, factotum).
 *
 * Подтема — современные практики цифровой работы (середина 2020-х):
 *   удалёнка и гибрид (remote work, hybrid, digital nomad, co-working, time zone),
 *   фриланс и gig economy (freelance, contractor, hourly rate, side hustle,
 *     scope creep, gig economy),
 *   agile / scrum-практики (kanban, scrum, MVP, demo, async),
 *   культура и баланс (work-life balance, deep work, flexible hours, offboarding,
 *     productivity hack),
 *   распределённые команды и форматы (focus block, output-driven,
 *     decentralized team, all-hands).
 *
 * НЕ дубли с другими en-ru сетами (проверено grep по всем WordDataEnglish*.kt):
 *   telecommute, backlog, milestone, onboard, retainer (все в 338),
 *   onboarding (255), agile/standup/deliverable (422 Бизнес — namespace бизнеса,
 *   а не remote-work), invoice (214 Финансы), portfolio (61 — инвестпортфель),
 *   burnout (354 — выгорание), iteration (303 — итерация дизайна),
 *   sprint (210/346 — бег), retrospective (358 — ретроспектива в кино),
 *   gig (317 — концерт музыкальный) — взято gig economy как отдельное phrase.
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   UNCOMMON — 11 слов (вошедшие в мейнстрим к 2026: remote work, hybrid,
 *              freelance, contractor, time zone, work-life balance, deep work,
 *              flexible hours, demo, scrum, MVP).
 *   RARE     — 14 слов (отраслевой жаргон: digital nomad, co-working, async,
 *              kanban, hourly rate, side hustle, scope creep, gig economy,
 *              offboarding, productivity hack, focus block, output-driven,
 *              decentralized team, all-hands).
 *
 * Пять семантических подгрупп:
 *   work_remote_setup        — формат и инфраструктура удалёнки (5 слов)
 *   work_remote_freelance    — фриланс и подработка (6 слов)
 *   work_remote_agile        — agile/scrum практики (5 слов)
 *   work_remote_culture      — культура труда и баланс (5 слов)
 *   work_remote_deliverables — распределённые команды и форматы работы (4 слова)
 *
 * Word IDs: 47001..47025 (setId × 100 + position).
 */
object WordDataEnglishWorkRemote {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 470,
            name = "Работа и карьера",
            description = "Удалёнка, фриланс и agile: современные практики цифровой работы (remote work, freelance, scrum, work-life balance)",
            languagePair = "en-ru",
            orderIndex = 470,
            topic = "Работа и карьера",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── work_remote_setup (формат и инфраструктура удалёнки) ──────────────
        WordEntity(
            id = 47001, original = "remote work", transliteration = "[rɪˈmoʊt wɜːrk]", translation = "удалённая работа",
            definition = "An arrangement where employees do their job from home or anywhere outside the company office.",
            definitionNative = "Формат, при котором сотрудник работает из дома или из любой точки вне офиса компании.",
            example = "After the pandemic our company kept remote work as the default option for engineers.",
            exampleNative = "После пандемии компания оставила remote work как опцию по умолчанию для инженеров.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_setup", fillInBlankExclusions = listOf(47002L, 47003L, 47005L, 47019L)),
        WordEntity(
            id = 47002, original = "hybrid", transliteration = "[ˈhaɪbrɪd]", translation = "гибридный (формат работы)",
            definition = "Work model that mixes office days and remote days in one week.",
            definitionNative = "Модель работы, сочетающая дни в офисе и дни удалёнки в одной неделе.",
            example = "Our hybrid policy requires two days in the office on Tuesday and Thursday.",
            exampleNative = "Наша hybrid-политика требует двух офисных дней — вторник и четверг.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "adjective",
            semanticGroup = "work_remote_setup", fillInBlankExclusions = listOf(47020L)),
        WordEntity(
            id = 47003, original = "digital nomad", transliteration = "[ˈdɪdʒɪtəl ˈnoʊmæd]", translation = "цифровой кочевник",
            definition = "Someone who earns money online while travelling and changing countries every few months.",
            definitionNative = "Человек, зарабатывающий онлайн и меняющий страны каждые несколько месяцев.",
            example = "She works as a digital nomad and posts from a different beach café every Monday.",
            exampleNative = "Она работает как digital nomad и каждый понедельник пишет из нового пляжного кафе.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_setup", fillInBlankExclusions = listOf(47001L, 47005L, 47006L, 47007L)),
        WordEntity(
            id = 47004, original = "co-working", transliteration = "[ˌkoʊˈwɜːrkɪŋ]", translation = "коворкинг",
            definition = "Shared office space rented by freelancers and small teams who otherwise work alone.",
            definitionNative = "Общее офисное пространство, арендуемое фрилансерами и небольшими командами.",
            example = "Lisbon has a dozen co-working spaces full of designers escaping the home distractions.",
            exampleNative = "В Лиссабоне десяток co-working-пространств, забитых дизайнерами, бегущими от домашних отвлечений.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "noun",
            semanticGroup = "work_remote_setup"),
        WordEntity(
            id = 47005, original = "time zone", transliteration = "[ˈtaɪm zoʊn]", translation = "часовой пояс",
            definition = "Geographic region that follows one standard time and that distributed teams must juggle.",
            definitionNative = "Географическая зона с одним стандартным временем — головная боль распределённых команд.",
            example = "With three engineers in Berlin and two in San Francisco we live across nine time zone hours.",
            exampleNative = "С тремя инженерами в Берлине и двумя в Сан-Франциско мы живём через девять часов time zone.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_setup", fillInBlankExclusions = listOf(47001L, 47003L)),

        // ── work_remote_freelance (фриланс и подработка) ──────────────────────
        WordEntity(
            id = 47006, original = "freelance", transliteration = "[ˈfriːlæns]", translation = "фриланс; работать на себя",
            definition = "To take separate paid projects from different clients instead of one full-time job.",
            definitionNative = "Брать отдельные оплачиваемые проекты у разных клиентов вместо одной постоянной работы.",
            example = "She quit the agency to freelance for tech startups and doubled her income in a year.",
            exampleNative = "Она ушла из агентства, чтобы freelance на техностартапы, и за год удвоила доход.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "verb",
            semanticGroup = "work_remote_freelance"),
        WordEntity(
            id = 47007, original = "contractor", transliteration = "[ˈkɒntræktər]", translation = "контрактор; внештатник",
            definition = "Outside specialist hired for a fixed project who is not on the company's payroll.",
            definitionNative = "Внешний специалист, нанятый под конкретный проект и не оформленный в штат.",
            example = "We brought in a contractor to rebuild the checkout flow before Black Friday.",
            exampleNative = "Мы взяли contractor, чтобы переделать оформление заказа до Чёрной пятницы.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "noun",
            semanticGroup = "work_remote_freelance", fillInBlankExclusions = listOf(47003L)),
        WordEntity(
            id = 47008, original = "hourly rate", transliteration = "[ˈaʊərli reɪt]", translation = "почасовая ставка",
            definition = "Amount of money a freelancer or contractor charges for one hour of their work.",
            definitionNative = "Сумма, которую фрилансер или контрактор берёт за один час работы.",
            example = "After two years of senior projects he finally pushed his hourly rate up to ninety dollars.",
            exampleNative = "После двух лет senior-проектов он наконец поднял свою hourly rate до девяноста долларов.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_freelance", fillInBlankExclusions = listOf(47009L, 47010L, 47011L)),
        WordEntity(
            id = 47009, original = "side hustle", transliteration = "[ˈsaɪd ˈhʌsəl]", translation = "подработка; пет-проект на деньги",
            definition = "Extra paid activity someone runs in evenings or weekends alongside their main job.",
            definitionNative = "Дополнительная оплачиваемая деятельность по вечерам и выходным помимо основной работы.",
            example = "His side hustle selling 3D-printed miniatures on Etsy now earns more than his day job.",
            exampleNative = "Его side hustle с продажей напечатанных миниатюр на Etsy приносит больше, чем основная работа.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_freelance", fillInBlankExclusions = listOf(47008L, 47010L, 47011L)),
        WordEntity(
            id = 47010, original = "scope creep", transliteration = "[skoʊp kriːp]", translation = "расползание задачи",
            definition = "Gradual growth of a project's requirements beyond what was originally agreed and paid for.",
            definitionNative = "Постепенное разрастание требований проекта за рамки изначально согласованного и оплаченного.",
            example = "The client kept adding small tweaks until the scope creep doubled the original timeline.",
            exampleNative = "Клиент добавлял мелкие правки, пока scope creep не удвоил изначальные сроки.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_freelance", fillInBlankExclusions = listOf(47008L, 47009L, 47011L)),
        WordEntity(
            id = 47011, original = "gig economy", transliteration = "[ɡɪɡ ɪˈkɒnəmi]", translation = "гиг-экономика",
            definition = "Labour market dominated by short-term contracts and freelance jobs rather than steady employment.",
            definitionNative = "Рынок труда, где преобладают краткосрочные контракты и фриланс вместо постоянной занятости.",
            example = "Uber drivers and DoorDash couriers are the visible face of the gig economy.",
            exampleNative = "Водители Uber и курьеры DoorDash — видимое лицо gig economy.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_freelance", fillInBlankExclusions = listOf(47008L, 47009L, 47010L)),

        // ── work_remote_agile (agile/scrum практики) ──────────────────────────
        WordEntity(
            id = 47012, original = "scrum", transliteration = "[skrʌm]", translation = "скрам (методология)",
            definition = "Agile framework where teams deliver software in short cycles guided by a few fixed roles.",
            definitionNative = "Agile-методика, где команды поставляют продукт короткими циклами с несколькими фиксированными ролями.",
            example = "Our scrum team plans every other Monday and ships a working build at the end of the cycle.",
            exampleNative = "Наша scrum-команда планирует через понедельник и в конце цикла выкатывает рабочий билд.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "noun",
            semanticGroup = "work_remote_agile", fillInBlankExclusions = listOf(47013L, 47014L, 47015L)),
        WordEntity(
            id = 47013, original = "kanban", transliteration = "[ˈkænbæn]", translation = "канбан",
            definition = "Visual workflow method where tasks move across columns like To Do, Doing and Done.",
            definitionNative = "Визуальный метод работы, при котором задачи движутся по колонкам типа To Do, Doing, Done.",
            example = "We switched to kanban so engineers could pull the next task instead of waiting for sprint planning.",
            exampleNative = "Мы перешли на kanban, чтобы инженеры брали следующую задачу, а не ждали планирования спринта.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "noun",
            semanticGroup = "work_remote_agile", fillInBlankExclusions = listOf(47012L, 47014L, 47015L, 47016L)),
        WordEntity(
            id = 47014, original = "MVP", transliteration = "[ˌɛm viː ˈpiː]", translation = "MVP (минимально жизнеспособный продукт)",
            definition = "Smallest version of a product that has enough features to test the idea with real users.",
            definitionNative = "Самая простая версия продукта с минимумом функций, достаточным для проверки идеи на реальных пользователях.",
            example = "We shipped the MVP in six weeks with just login and one chart — enough for early feedback.",
            exampleNative = "Мы выпустили MVP за шесть недель — только логин и один график; для ранних отзывов достаточно.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "noun",
            semanticGroup = "work_remote_agile", fillInBlankExclusions = listOf(47012L, 47013L, 47015L)),
        WordEntity(
            id = 47015, original = "demo", transliteration = "[ˈdɛmoʊ]", translation = "демо; показ результата",
            definition = "Short presentation at the end of a sprint where the team shows what they built.",
            definitionNative = "Короткая презентация в конце спринта, где команда показывает, что сделала.",
            example = "Friday's demo went well — the new dashboard impressed the head of product.",
            exampleNative = "Пятничное demo прошло хорошо: новый дашборд впечатлил главу продукта.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "noun",
            semanticGroup = "work_remote_agile", fillInBlankExclusions = listOf(47012L, 47013L, 47014L, 47025L)),
        WordEntity(
            id = 47016, original = "async", transliteration = "[ˈeɪsɪŋk]", translation = "асинхронный (формат общения)",
            definition = "Communication style where people answer in their own time instead of in a live meeting.",
            definitionNative = "Стиль общения, при котором отвечают в удобное время, а не на живой встрече.",
            example = "Our distributed team runs almost everything async through long Slack threads and Loom videos.",
            exampleNative = "Наша распределённая команда почти всё делает async — длинными ветками в Slack и видео в Loom.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "adjective",
            semanticGroup = "work_remote_agile"),

        // ── work_remote_culture (культура труда и баланс) ─────────────────────
        WordEntity(
            id = 47017, original = "work-life balance", transliteration = "[ˈwɜːrk laɪf ˈbæləns]", translation = "баланс работы и личной жизни",
            definition = "Healthy split between hours spent on the job and time left for family, hobbies and rest.",
            definitionNative = "Здоровое соотношение между часами работы и временем на семью, хобби и отдых.",
            example = "After moving to a four-day week she finally has the work-life balance she wanted for years.",
            exampleNative = "Перейдя на четырёхдневку, она наконец получила work-life balance, о котором мечтала годами.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_culture", fillInBlankExclusions = listOf(47018L, 47019L, 47021L)),
        WordEntity(
            id = 47018, original = "deep work", transliteration = "[diːp wɜːrk]", translation = "глубокая работа",
            definition = "Long block of focused effort on one hard task without notifications or meetings.",
            definitionNative = "Долгий промежуток сосредоточенной работы над одной сложной задачей без уведомлений и встреч.",
            example = "Cal Newport popularised deep work as the only way to make progress on writing or coding.",
            exampleNative = "Кэл Ньюпорт сделал deep work популярным — как единственный способ продвигаться в письме и коде.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_culture", fillInBlankExclusions = listOf(47017L, 47019L, 47021L)),
        WordEntity(
            id = 47019, original = "flexible hours", transliteration = "[ˈflɛksəbəl ˈaʊərz]", translation = "гибкий график",
            definition = "Arrangement where staff choose when to start and end the day instead of fixed nine-to-five.",
            definitionNative = "Договорённость, при которой сотрудник сам выбирает начало и конец дня, а не работает с девяти до пяти.",
            example = "Flexible hours let parents drop their kids at school and start coding around ten.",
            exampleNative = "Flexible hours позволяют родителям отвозить детей в школу и садиться за код к десяти.",
            rarity = "UNCOMMON", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_culture", fillInBlankExclusions = listOf(47017L, 47018L, 47021L)),
        WordEntity(
            id = 47020, original = "offboarding", transliteration = "[ˌɒfˈbɔːrdɪŋ]", translation = "офбординг; вывод сотрудника",
            definition = "Process of closing access, returning gear and handing over tasks when an employee leaves.",
            definitionNative = "Процесс закрытия доступов, возврата техники и передачи задач при уходе сотрудника.",
            example = "Smooth offboarding kept the old engineer on friendly terms — and he later returned as a contractor.",
            exampleNative = "Аккуратный offboarding оставил инженера в хороших отношениях — и потом он вернулся как контрактор.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "noun",
            semanticGroup = "work_remote_culture"),
        WordEntity(
            id = 47021, original = "productivity hack", transliteration = "[ˌprɒdʌkˈtɪvɪti hæk]", translation = "лайфхак продуктивности",
            definition = "Small trick or habit that helps a person get more done in less time.",
            definitionNative = "Маленький приём или привычка, помогающие сделать больше за меньшее время.",
            example = "Her favourite productivity hack is checking email only twice a day at fixed slots.",
            exampleNative = "Её любимый productivity hack — проверять почту лишь дважды в день в фиксированные слоты.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_culture", fillInBlankExclusions = listOf(47017L, 47018L, 47019L)),

        // ── work_remote_deliverables (распределённые команды и форматы) ───────
        WordEntity(
            id = 47022, original = "focus block", transliteration = "[ˈfoʊkəs blɒk]", translation = "слот фокус-работы",
            definition = "Calendar slot reserved for one task with notifications off and no meetings allowed.",
            definitionNative = "Зарезервированный слот в календаре под одну задачу — без уведомлений и без встреч.",
            example = "I keep a two-hour focus block every morning so the bug fixes actually happen.",
            exampleNative = "Я держу двухчасовой focus block каждое утро, чтобы баги действительно чинились.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_deliverables", fillInBlankExclusions = listOf(47024L)),
        WordEntity(
            id = 47023, original = "output-driven", transliteration = "[ˈaʊtpʊt ˈdrɪvən]", translation = "ориентированный на результат",
            definition = "Work culture that measures employees by what they produce, not by hours they sit at the desk.",
            definitionNative = "Культура труда, оценивающая сотрудников по результату, а не по часам, проведённым за столом.",
            example = "GitLab is famously output-driven — nobody tracks who logs in at what time.",
            exampleNative = "GitLab знаменит как output-driven компания — никто не следит, кто во сколько подключается.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "adjective",
            semanticGroup = "work_remote_deliverables"),
        WordEntity(
            id = 47024, original = "decentralized team", transliteration = "[diːˈsɛntrəlaɪzd tiːm]", translation = "распределённая (децентрализованная) команда",
            definition = "Group of co-workers spread across many cities or countries with no single main office.",
            definitionNative = "Группа коллег, разбросанных по разным городам и странам без единого главного офиса.",
            example = "Automattic runs a decentralized team of two thousand people on six continents.",
            exampleNative = "Automattic управляет decentralized team из двух тысяч человек на шести континентах.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "work_remote_deliverables", fillInBlankExclusions = listOf(47022L)),
        WordEntity(
            id = 47025, original = "all-hands", transliteration = "[ˌɔːl ˈhændz]", translation = "общее собрание (все сотрудники)",
            definition = "Company-wide meeting where every employee joins to hear updates from leadership.",
            definitionNative = "Общекорпоративная встреча, на которую подключается каждый сотрудник, чтобы услышать новости от руководства.",
            example = "The CEO announced the new pricing model at last Thursday's all-hands over Zoom.",
            exampleNative = "Гендиректор объявил новую модель цен на all-hands в прошлый четверг в Zoom.",
            rarity = "RARE", setId = 470, languagePair = "en-ru", pos = "noun",
            semanticGroup = "work_remote_deliverables"),
    )
}
