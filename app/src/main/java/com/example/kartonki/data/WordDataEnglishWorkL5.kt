package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Работа и карьера (level 5, носитель языка).
 *
 * Set 339: «Работа и карьера: носитель языка» — высокая лексика трудовых
 * отношений: организационная теория, корпоративная архаика, идиоматика (C2+).
 *
 * Распределение редкости: 20 LEGENDARY + 5 EPIC — два смежных уровня шкалы,
 * с преобладанием LEGENDARY.
 *
 * Дополняет уже существующие сеты темы «Работа и карьера»:
 *   - Set 280 (WordDataEnglishBatch12.kt) — L1 распространённые профессии.
 *   - Set 203 (WordDataEnglishExpanded.kt) — L2 профессии и специальности.
 *   - Set 255 (WordDataEnglishBatch4.kt)   — L2 поиск работы и интервью.
 *   - Set 243 (WordDataEnglishExpanded.kt) — L4 редкие специализированные профессии.
 *   - Set 69  (WordDataEnglish.kt)         — L4 управление и организация.
 *   - Set 338 (параллельный L3)            — B2 onboard/KPI/peer/stakeholder и т. д.
 *
 * Слова setId=339 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   work_org_theory          — meritocracy, cronyism, sinecure, oligarchy, plutocracy
 *   work_archaic_roles       — apprentice, journeyman, indenture, guildsman, factotum
 *   work_corporate_speak     — synergy, monetize, scalable, kaizen, groupthink
 *   work_career_concepts     — tenure, attrition, sabbatical, stipend, retainer
 *   work_idioms_concepts     — amanuensis, magnate, tycoon, doyen, emolument
 *
 * Word IDs: 33901..33925 (setId × 100 + position).
 */
object WordDataEnglishWorkL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 339, name = "Работа и карьера",
            description = "Высокая лексика трудовых отношений: организационная теория, корпоративная архаика, идиоматика",
            languagePair = "en-ru",
            topic = "Работа и карьера", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── work_org_theory (5) ───────────────────────────────────────────

        WordEntity(id = 33901, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "meritocracy", transliteration = "[ˌmɛrɪˈtɑkrəsi]", translation = "меритократия (власть достойных)",
            definition = "A system where the ablest people rise on merit, not on birth or wealth.",
            definitionNative = "Строй, где самые способные поднимаются по таланту, а не по рождению или богатству.",
            example = "The firm prides itself on a strict meritocracy where promotions follow performance.",
            exampleNative = "Фирма гордится строгой meritocracy, где повышения следуют за результатом.",
            pos = "noun", semanticGroup = "work_org_theory",
            fillInBlankExclusions = listOf(33902L, 33903L, 33904L, 33905L)),

        WordEntity(id = 33902, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cronyism", transliteration = "[ˈkroʊniɪzəm]", translation = "кумовство по знакомству (продвижение друзей)",
            definition = "The practice of giving good jobs to friends rather than to qualified candidates.",
            definitionNative = "Практика раздавать хорошие должности приятелям, а не подходящим кандидатам.",
            example = "The audit exposed deep cronyism in the awarding of public contracts.",
            exampleNative = "Аудит вскрыл глубокий cronyism при раздаче государственных подрядов.",
            pos = "noun", semanticGroup = "work_org_theory",
            fillInBlankExclusions = listOf(33901L, 33903L, 33904L, 33905L)),

        WordEntity(id = 33903, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sinecure", transliteration = "[ˈsaɪnɪˌkjʊr]", translation = "синекура (оплачиваемая должность без обязанностей)",
            definition = "A well-paid position that demands little real work from its holder.",
            definitionNative = "Хорошо оплачиваемая должность, требующая от занимающего её мало настоящей работы.",
            example = "The minister rewarded loyal supporters with a comfortable sinecure at the embassy.",
            exampleNative = "Министр наградил верных сторонников уютной sinecure в посольстве.",
            pos = "noun", semanticGroup = "work_org_theory",
            fillInBlankExclusions = listOf(33901L, 33902L, 33904L, 33905L)),

        WordEntity(id = 33904, setId = 339, languagePair = "en-ru", rarity = "EPIC",
            original = "oligarchy", transliteration = "[ˈɑləˌɡɑrki]", translation = "олигархия (власть узкой верхушки)",
            definition = "Control of an organisation by a small inner circle of powerful people.",
            definitionNative = "Власть в организации, сосредоточенная в руках узкого круга влиятельных людей.",
            example = "A tight oligarchy of senior partners decided every major hiring at the firm.",
            exampleNative = "Тесная oligarchy старших партнёров решала каждое крупное назначение в фирме.",
            pos = "noun", semanticGroup = "work_org_theory",
            fillInBlankExclusions = listOf(33901L, 33902L, 33903L, 33905L)),

        WordEntity(id = 33905, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "plutocracy", transliteration = "[pluˈtɑkrəsi]", translation = "плутократия (власть богачей)",
            definition = "A system in which the wealthy hold all the real power inside an institution.",
            definitionNative = "Строй, при котором всё реальное влияние внутри института принадлежит богачам.",
            example = "Critics accused the board of running the company as a private plutocracy.",
            exampleNative = "Критики обвинили совет в том, что компанией правит частная plutocracy.",
            pos = "noun", semanticGroup = "work_org_theory",
            fillInBlankExclusions = listOf(33901L, 33902L, 33903L, 33904L)),

        // ── work_archaic_roles (5) ────────────────────────────────────────

        WordEntity(id = 33906, setId = 339, languagePair = "en-ru", rarity = "EPIC",
            original = "apprentice", transliteration = "[əˈprɛntɪs]", translation = "ученик ремесленника",
            definition = "A young learner bound to a master to study a trade for several years.",
            definitionNative = "Молодой ученик, связанный с мастером договором, чтобы учиться ремеслу годами.",
            example = "The blacksmith took on a quiet apprentice from the next village that spring.",
            exampleNative = "Кузнец взял тихого apprentice из соседней деревни той весной.",
            pos = "noun", semanticGroup = "work_archaic_roles",
            fillInBlankExclusions = listOf(33907L, 33908L, 33909L, 33910L)),

        WordEntity(id = 33907, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "journeyman", transliteration = "[ˈʤərniˌmæn]", translation = "подмастерье (наёмный мастер после ученичества)",
            definition = "A trained craftsman who works for daily wages but has not yet become a master.",
            definitionNative = "Обученный ремесленник, работающий за подённую плату, но ещё не ставший мастером.",
            example = "After seven years of training he finally became a journeyman in the carpenters' guild.",
            exampleNative = "После семи лет обучения он наконец стал journeyman в плотницкой гильдии.",
            pos = "noun", semanticGroup = "work_archaic_roles",
            fillInBlankExclusions = listOf(33906L, 33908L, 33909L, 33910L)),

        WordEntity(id = 33908, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "indenture", transliteration = "[ɪnˈdɛnʧər]", translation = "кабальный контракт ученика на годы",
            definition = "An old binding contract that tied a learner to a master for fixed years of service.",
            definitionNative = "Старинный обязывающий договор, связывавший учащегося с хозяином на годы службы.",
            example = "The boy signed a seven-year indenture with the printer of the small town.",
            exampleNative = "Мальчик подписал семилетний indenture с печатником маленького городка.",
            pos = "noun", semanticGroup = "work_archaic_roles",
            fillInBlankExclusions = listOf(33906L, 33907L, 33909L, 33910L)),

        WordEntity(id = 33909, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "guildsman", transliteration = "[ˈɡɪldzmən]", translation = "член ремесленной гильдии",
            definition = "A sworn member of a medieval craft brotherhood that ruled prices and standards.",
            definitionNative = "Присяжный член средневекового ремесленного братства, диктовавшего цены и качество.",
            example = "Only a sworn guildsman could legally sell finished cloth in the city market.",
            exampleNative = "Только присяжный guildsman имел право торговать готовым сукном на городском рынке.",
            pos = "noun", semanticGroup = "work_archaic_roles",
            fillInBlankExclusions = listOf(33906L, 33907L, 33908L, 33910L)),

        WordEntity(id = 33910, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "factotum", transliteration = "[fækˈtoʊtəm]", translation = "доверенный слуга на все руки",
            definition = "A trusted servant who handles every kind of small task for a powerful man.",
            definitionNative = "Доверенный слуга, выполняющий всякие мелкие поручения важного господина.",
            example = "The old senator relied on a discreet factotum to manage his daily affairs.",
            exampleNative = "Старый сенатор полагался на скромного factotum в повседневных делах.",
            pos = "noun", semanticGroup = "work_archaic_roles",
            fillInBlankExclusions = listOf(33906L, 33907L, 33908L, 33909L)),

        // ── work_corporate_speak (5) ──────────────────────────────────────

        WordEntity(id = 33911, setId = 339, languagePair = "en-ru", rarity = "EPIC",
            original = "synergy", transliteration = "[ˈsɪnərʤi]", translation = "синергия (сложение усилий)",
            definition = "The extra effect achieved when two teams work jointly and gain more than apart.",
            definitionNative = "Усиленный эффект от совместной работы двух команд, превышающий их сумму по отдельности.",
            example = "The merger promised real synergy between the design and engineering departments.",
            exampleNative = "Слияние обещало настоящую synergy между дизайном и инженерным отделом.",
            pos = "noun", semanticGroup = "work_corporate_speak",
            fillInBlankExclusions = listOf(33912L, 33913L, 33914L, 33915L)),

        WordEntity(id = 33912, setId = 339, languagePair = "en-ru", rarity = "EPIC",
            original = "monetize", transliteration = "[ˈmɑnəˌtaɪz]", translation = "монетизировать (превращать в источник дохода)",
            definition = "To find a way to earn steady money from something that did not pay before.",
            definitionNative = "Найти способ получать устойчивый доход из того, что раньше не приносило денег.",
            example = "The startup struggled for years to monetize its huge but free user base.",
            exampleNative = "Стартап годами пытался monetize свою огромную, но бесплатную аудиторию.",
            pos = "verb", semanticGroup = "work_corporate_speak",
            fillInBlankExclusions = listOf(33911L, 33913L, 33914L, 33915L)),

        WordEntity(id = 33913, setId = 339, languagePair = "en-ru", rarity = "EPIC",
            original = "scalable", transliteration = "[ˈskeɪləbəl]", translation = "масштабируемый (готовый к росту)",
            definition = "Able to grow many times in size without losing speed or quality of work.",
            definitionNative = "Способный многократно расти в объёме без потери скорости или качества работы.",
            example = "Investors only fund scalable businesses that can serve a million users tomorrow.",
            exampleNative = "Инвесторы вкладываются только в scalable бизнес, готовый завтра обслужить миллион клиентов.",
            pos = "adjective", semanticGroup = "work_corporate_speak",
            fillInBlankExclusions = listOf(33911L, 33912L, 33914L, 33915L)),

        WordEntity(id = 33914, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "kaizen", transliteration = "[ˈkaɪzən]", translation = "кайдзэн (постоянное улучшение мелкими шагами)",
            definition = "A Japanese workplace philosophy of constant small improvements made by everyone.",
            definitionNative = "Японская производственная философия постоянных мелких улучшений силами каждого.",
            example = "The Toyota plant applied kaizen to cut wasted motion on the long assembly line.",
            exampleNative = "Завод Тойоты применил kaizen, чтобы убрать лишние движения на длинном конвейере.",
            pos = "noun", semanticGroup = "work_corporate_speak",
            fillInBlankExclusions = listOf(33911L, 33912L, 33913L, 33915L)),

        WordEntity(id = 33915, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "groupthink", transliteration = "[ˈɡrupˌθɪŋk]", translation = "групповое мышление (подавление инакомыслия)",
            definition = "A team mistake where members agree too easily and stop questioning bad ideas.",
            definitionNative = "Командная ошибка, когда участники слишком легко соглашаются и перестают спорить.",
            example = "Senior engineers warned that groupthink in the war room had killed open debate.",
            exampleNative = "Старшие инженеры предупреждали, что groupthink в штабе убило открытое обсуждение.",
            pos = "noun", semanticGroup = "work_corporate_speak",
            fillInBlankExclusions = listOf(33911L, 33912L, 33913L, 33914L)),

        // ── work_career_concepts (5) ──────────────────────────────────────

        WordEntity(id = 33916, setId = 339, languagePair = "en-ru", rarity = "EPIC",
            original = "tenure", transliteration = "[ˈtɛnjər]", translation = "бессрочная штатная должность (особ. преподавателя)",
            definition = "A guaranteed permanent post that protects a senior worker from sudden firing.",
            definitionNative = "Гарантированная постоянная должность, защищающая опытного работника от внезапного увольнения.",
            example = "The professor finally won tenure after a long decade of careful research.",
            exampleNative = "Профессор наконец получил tenure после долгого десятилетия аккуратных исследований.",
            pos = "noun", semanticGroup = "work_career_concepts",
            fillInBlankExclusions = listOf(33917L, 33918L, 33919L, 33920L)),

        WordEntity(id = 33917, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "patronage", transliteration = "[ˈpætrənɪʤ]", translation = "покровительство (поддержка влиятельной персоны)",
            definition = "Powerful support that opens doors to jobs, contracts or favourable posts.",
            definitionNative = "Поддержка влиятельной персоны, открывающая двери к должностям и выгодным контрактам.",
            example = "Without the duke's patronage the young architect would never have built a single chapel.",
            exampleNative = "Без patronage герцога юный архитектор не построил бы ни одной часовни.",
            pos = "noun", semanticGroup = "work_career_concepts",
            fillInBlankExclusions = listOf(33916L, 33918L, 33919L, 33920L)),

        WordEntity(id = 33918, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "perquisite", transliteration = "[ˈpɜrkwɪzɪt]", translation = "привилегия должности (особая льгота)",
            definition = "An extra benefit that comes with a high post — a car, club access, fine lunches.",
            definitionNative = "Дополнительная льгота высокой должности — машина, клуб, обеды за счёт фирмы.",
            example = "A chauffeured car was a quiet perquisite of every senior post in the bank.",
            exampleNative = "Машина с водителем была тихим perquisite каждого старшего поста в банке.",
            pos = "noun", semanticGroup = "work_career_concepts",
            fillInBlankExclusions = listOf(33916L, 33917L, 33919L, 33920L)),

        WordEntity(id = 33919, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "stipend", transliteration = "[ˈstaɪpɛnd]", translation = "регулярная выплата (стипендия, скромное жалованье)",
            definition = "A modest fixed sum paid out at set times to a student, fellow or junior cleric.",
            definitionNative = "Скромная фиксированная сумма, выплачиваемая через равные промежутки студенту или младшему сотруднику.",
            example = "The doctoral fellow lived frugally on a modest monthly stipend from the institute.",
            exampleNative = "Аспирант скромно жил на ежемесячный stipend от института.",
            pos = "noun", semanticGroup = "work_career_concepts",
            fillInBlankExclusions = listOf(33916L, 33917L, 33918L, 33920L)),

        WordEntity(id = 33920, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "honorarium", transliteration = "[ˌɑnəˈrɛriəm]", translation = "почётный гонорар (за разовое выступление или эссе)",
            definition = "A modest token payment given for a single talk, paper or short consultation.",
            definitionNative = "Скромная символическая плата за разовую лекцию, статью или короткую консультацию.",
            example = "She gave the keynote address for a small honorarium and a bouquet of roses.",
            exampleNative = "Она прочла главный доклад за скромный honorarium и букет роз.",
            pos = "noun", semanticGroup = "work_career_concepts",
            fillInBlankExclusions = listOf(33916L, 33917L, 33918L, 33919L)),

        // ── work_idioms_concepts (5) ──────────────────────────────────────

        WordEntity(id = 33921, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "amanuensis", transliteration = "[əˌmænjuˈɛnsɪs]", translation = "личный секретарь-переписчик",
            definition = "A devoted assistant who writes down the words of a great scholar or author.",
            definitionNative = "Преданный помощник, записывающий слова крупного учёного или писателя.",
            example = "The blind poet dictated his last verses to a patient amanuensis at dusk.",
            exampleNative = "Слепой поэт надиктовал последние стихи терпеливому amanuensis в сумерках.",
            pos = "noun", semanticGroup = "work_idioms_concepts",
            fillInBlankExclusions = listOf(33922L, 33923L, 33924L, 33925L)),

        WordEntity(id = 33922, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "magnate", transliteration = "[ˈmæɡˌneɪt]", translation = "магнат (влиятельный делец крупного капитала)",
            definition = "A rich and powerful man who controls a whole branch of trade or industry.",
            definitionNative = "Богатый и влиятельный человек, контролирующий целую отрасль торговли или промышленности.",
            example = "The shipping magnate owned half the docks along the cold northern coast.",
            exampleNative = "Судоходный magnate владел половиной причалов на холодном северном побережье.",
            pos = "noun", semanticGroup = "work_idioms_concepts",
            fillInBlankExclusions = listOf(33921L, 33923L, 33924L, 33925L)),

        WordEntity(id = 33923, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tycoon", transliteration = "[taɪˈkun]", translation = "воротила / промышленный король",
            definition = "An enormously rich businessman who built up a private empire by force of will.",
            definitionNative = "Невероятно богатый делец, построивший частную империю силой характера.",
            example = "A railway tycoon bought the old newspaper and quietly redirected its editorials.",
            exampleNative = "Железнодорожный tycoon скупил старую газету и тихо развернул её редакционную линию.",
            pos = "noun", semanticGroup = "work_idioms_concepts",
            fillInBlankExclusions = listOf(33921L, 33922L, 33924L, 33925L)),

        WordEntity(id = 33924, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "doyen", transliteration = "[ˈdɔɪən]", translation = "старейшина профессии (признанный авторитет)",
            definition = "The oldest and most respected member of a learned trade or scholarly field.",
            definitionNative = "Старейший и наиболее почитаемый член учёного цеха или научной области.",
            example = "The grand old doyen of theatre critics still wrote a column every other Sunday.",
            exampleNative = "Седой doyen театральной критики всё ещё писал колонку через воскресенье.",
            pos = "noun", semanticGroup = "work_idioms_concepts",
            fillInBlankExclusions = listOf(33921L, 33922L, 33923L, 33925L)),

        WordEntity(id = 33925, setId = 339, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "emolument", transliteration = "[ɪˈmɑljəmənt]", translation = "должностное жалованье (формальное)",
            definition = "A formal payment or perk that goes with a public office, beyond the basic salary.",
            definitionNative = "Формальная выплата или привилегия, прилагающаяся к должности сверх основного оклада.",
            example = "The constitution forbids any foreign emolument from being accepted by the president.",
            exampleNative = "Конституция запрещает президенту принимать любой иностранный emolument.",
            pos = "noun", semanticGroup = "work_idioms_concepts",
            fillInBlankExclusions = listOf(33921L, 33922L, 33923L, 33924L)),
    )
}
