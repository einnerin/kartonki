package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Интернет и соцсети (L4, RARE+EPIC).
 *
 * Set 393: «Интернет и соцсети» — профессиональный.
 *          Сетевые протоколы (HTTPS, TLS, DNS, CDN, API gateway), профильная
 *          безопасность (spear-phishing, sandbox escape, exfiltration, hashing,
 *          cipher suite), работа с данными (telemetry pipeline, anonymization,
 *          aggregation, cookie consent, data minimization), регулирование (GDPR,
 *          takedown notice, content policy, right to erasure, safe harbor) и
 *          продвинутый бизнес-маркетинг (LTV, CAC, retention curve, attribution
 *          model, stickiness) — лексика B2-C1, какой пользуются инженеры,
 *          юристы и продакты в IT.
 *
 * Тема «Интернет и соцсети» — продолжение L1 (set 390), L2 (set 391), L3 (set 392).
 * Все 25 слов проверены grep'ом по `original = "..."` против WordDataEnglish*.kt:
 *   - HTTPS, TLS, DNS, CDN, "API gateway"     — отсутствуют
 *   - "spear-phishing", "sandbox escape"      — отсутствуют (sandbox занят, но фраза свободна)
 *   - exfiltration, "cipher suite", hashing   — отсутствуют
 *   - "telemetry pipeline", anonymization, aggregation, "cookie consent",
 *     "data minimization" — отсутствуют (telemetry есть в TechL5, "cookie" есть в food
 *     наборе, но составные фразы "telemetry pipeline" и "cookie consent" уникальны)
 *   - GDPR, "takedown notice", "content policy", "right to erasure", "safe harbor" —
 *     отсутствуют (takedown один в L2, "takedown notice" — отдельная лексема)
 *   - LTV, CAC, "retention curve", "attribution model", stickiness — отсутствуют
 *
 * Т.к. одиночные слова "telemetry", "takedown", "retention", "attribution", "sandbox",
 * "consent", "policy" заняты в других сетах, в L4 используются составные термины
 * ("telemetry pipeline", "takedown notice", "retention curve", "attribution model",
 * "sandbox escape", "cookie consent", "content policy"), которые в базе ещё нет.
 *
 * Распределение редкости: 17 EPIC + 8 RARE — два смежных уровня (B2 + C1).
 *
 * SemanticGroups (5 × 5):
 *   internet_l4_protocols       — HTTPS, TLS, DNS, CDN, "API gateway"
 *   internet_l4_security_pro    — "spear-phishing", "sandbox escape", exfiltration,
 *                                 hashing, "cipher suite"
 *   internet_l4_data            — "telemetry pipeline", anonymization, aggregation,
 *                                 "cookie consent", "data minimization"
 *   internet_l4_governance      — GDPR, "takedown notice", "content policy",
 *                                 "right to erasure", "safe harbor"
 *   internet_l4_business_pro    — LTV, CAC, "retention curve", "attribution model",
 *                                 stickiness
 *
 * Word IDs: setId × 100 + position (39301..39325).
 *
 * fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь (defaults в
 * WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно после wave;
 * если поставить их заранее, pipeline пропустит запись (известный баг).
 */
object WordDataEnglishInternetL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 393,
            languagePair = "en-ru",
            orderIndex = 393,
            name = "Интернет и соцсети",
            description = "Протоколы, безопасность профи, данные и регулирование",
            topic = "Интернет и соцсети",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 393 — Интернет и соцсети: профессиональный (L4, RARE+EPIC)   ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── internet_l4_protocols (5) ─────────────────────────────────────

        WordEntity(id = 39301, setId = 393, languagePair = "en-ru", rarity = "RARE",
            original = "HTTPS", transliteration = "[ˌeɪʧ ti ti pi ˈɛs]", translation = "защищённый веб-протокол",
            definition = "The web rule that scrambles pages between you and the site so spies can't read them.",
            definitionNative = "Веб-правило, что зашифровывает страницы между тобой и сайтом, чтобы шпионы не могли прочитать.",
            example = "Modern browsers warn users when a login form is not served over HTTPS.",
            exampleNative = "Современные браузеры предупреждают, когда форма входа отдаётся не по HTTPS.",
            pos = "noun", semanticGroup = "internet_l4_protocols", fillInBlankExclusions = listOf(39302L, 39303L, 39304L, 39305L)),

        WordEntity(id = 39302, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "TLS", transliteration = "[ˌti ɛl ˈɛs]", translation = "протокол шифрования соединения",
            definition = "The protocol that builds the secret tunnel under HTTPS, hiding the bytes from outsiders.",
            definitionNative = "Протокол, что строит тайный туннель под HTTPS и прячет байты от чужих глаз.",
            example = "The server admin renewed the TLS certificate before it expired.",
            exampleNative = "Админ сервера обновил TLS сертификат, прежде чем тот истёк.",
            pos = "noun", semanticGroup = "internet_l4_protocols", fillInBlankExclusions = listOf(39301L, 39303L, 39304L, 39305L)),

        WordEntity(id = 39303, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "DNS", transliteration = "[ˌdi ɛn ˈɛs]", translation = "система доменных имён",
            definition = "The phonebook of the internet that turns site names like example.com into numbers.",
            definitionNative = "Телефонная книга интернета, что превращает имена сайтов вроде example.com в числа.",
            example = "When DNS goes down, half the web suddenly looks unreachable.",
            exampleNative = "Когда DNS падает, половина веба внезапно кажется недоступной.",
            pos = "noun", semanticGroup = "internet_l4_protocols", fillInBlankExclusions = listOf(39301L, 39302L, 39304L, 39305L)),

        WordEntity(id = 39304, setId = 393, languagePair = "en-ru", rarity = "RARE",
            original = "CDN", transliteration = "[ˌsi di ˈɛn]", translation = "сеть доставки контента",
            definition = "A worldwide cluster of servers that keeps copies of files near every user for speed.",
            definitionNative = "Всемирная связка серверов, что держит копии файлов рядом с каждым пользователем для скорости.",
            example = "Streaming platforms rely on a CDN to push video close to viewers.",
            exampleNative = "Стриминговые платформы полагаются на CDN, чтобы поднести видео ближе к зрителям.",
            pos = "noun", semanticGroup = "internet_l4_protocols", fillInBlankExclusions = listOf(39301L, 39302L, 39303L)),

        WordEntity(id = 39305, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "API gateway", transliteration = "[ˌeɪ pi ˈaɪ ˈɡeɪtˌweɪ]", translation = "шлюз программных интерфейсов",
            definition = "The single front door that routes app requests to the right back-end service inside.",
            definitionNative = "Единая входная дверь, что направляет запросы приложения в нужную внутреннюю службу.",
            example = "Every mobile request first hits the API gateway before reaching microservices.",
            exampleNative = "Каждый мобильный запрос сначала попадает в API gateway, а уже потом — в микросервисы.",
            pos = "noun", semanticGroup = "internet_l4_protocols", fillInBlankExclusions = listOf(39301L, 39302L, 39303L, 39304L)),

        // ── internet_l4_security_pro (5) ──────────────────────────────────

        WordEntity(id = 39306, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "spear-phishing", transliteration = "[ˈspɪr ˈfɪʃɪŋ]", translation = "целевой фишинг",
            definition = "A precise scam letter aimed at one named person, often a boss, with custom bait.",
            definitionNative = "Точное обманное письмо, нацеленное на одного человека по имени, часто на босса, с подстроенной приманкой.",
            example = "The CEO fell for a spear-phishing email pretending to come from the lawyer.",
            exampleNative = "Гендиректор попался на spear-phishing письмо, что притворялось письмом от юриста.",
            pos = "noun", semanticGroup = "internet_l4_security_pro", fillInBlankExclusions = listOf(39307L, 39309L, 39310L)),

        WordEntity(id = 39307, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "sandbox escape", transliteration = "[ˈsændˌbɑks ɪˈskeɪp]", translation = "побег из изолированной среды",
            definition = "When malicious code breaks out of a safe walled-off area and reaches the real system.",
            definitionNative = "Когда вредоносный код вырывается из безопасной отгороженной зоны и добирается до настоящей системы.",
            example = "The browser bug allowed a sandbox escape that scared every security team.",
            exampleNative = "Брешь в браузере позволила sandbox escape, чем напугала каждую команду безопасности.",
            pos = "noun", semanticGroup = "internet_l4_security_pro", fillInBlankExclusions = listOf(39306L, 39309L, 39310L)),

        WordEntity(id = 39308, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "exfiltration", transliteration = "[ˌɛksfɪlˈtreɪʃən]", translation = "вывод данных (украденных)",
            definition = "The quiet, slow theft of files out of a network — like smuggling boxes past the guards.",
            definitionNative = "Тихая медленная кража файлов наружу из сети — как контрабанда коробок мимо охраны.",
            example = "Forensics traced the exfiltration to a single laptop in the marketing office.",
            exampleNative = "Криминалисты проследили exfiltration до одного ноутбука в отделе маркетинга.",
            pos = "noun", semanticGroup = "internet_l4_security_pro", fillInBlankExclusions = listOf(39306L, 39307L, 39309L, 39310L)),

        WordEntity(id = 39309, setId = 393, languagePair = "en-ru", rarity = "RARE",
            original = "hashing", transliteration = "[ˈhæʃɪŋ]", translation = "хеширование",
            definition = "Turning a password into a fixed scramble of letters that can't be turned back into the original.",
            definitionNative = "Превращение пароля в постоянную мешанину букв, которую нельзя обратить в исходную форму.",
            example = "Modern systems store only the hashing result, never the raw password.",
            exampleNative = "Современные системы хранят только результат hashing, но не сам пароль.",
            pos = "noun", semanticGroup = "internet_l4_security_pro", fillInBlankExclusions = listOf(39306L, 39307L, 39308L, 39310L)),

        WordEntity(id = 39310, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "cipher suite", transliteration = "[ˈsaɪfər swit]", translation = "набор криптоалгоритмов",
            definition = "The chosen recipe of mixing rules a server uses to scramble traffic with each visitor.",
            definitionNative = "Выбранный рецепт правил перемешивания, которым сервер шифрует трафик с каждым посетителем.",
            example = "The audit flagged an outdated cipher suite still enabled on the gateway.",
            exampleNative = "Аудит отметил устаревший cipher suite, всё ещё включённый на шлюзе.",
            pos = "noun", semanticGroup = "internet_l4_security_pro", fillInBlankExclusions = listOf(39306L, 39307L, 39308L, 39309L)),

        // ── internet_l4_data (5) ──────────────────────────────────────────

        WordEntity(id = 39311, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "telemetry pipeline", transliteration = "[təˈlɛmətri ˈpaɪpˌlaɪn]", translation = "конвейер телеметрии",
            definition = "The chain of tools that gathers raw signals from apps, cleans them, and stores for analysis.",
            definitionNative = "Цепочка инструментов, что собирает сырые сигналы из приложений, чистит и складывает для разбора.",
            example = "A broken telemetry pipeline left the team blind to a brewing crash.",
            exampleNative = "Сломанный telemetry pipeline оставил команду слепой к назревающему сбою.",
            pos = "noun", semanticGroup = "internet_l4_data", fillInBlankExclusions = listOf(39312L, 39313L, 39314L, 39315L)),

        WordEntity(id = 39312, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "anonymization", transliteration = "[əˌnɑnəməˈzeɪʃən]", translation = "обезличивание данных",
            definition = "The careful stripping of names and clues from data so no person can be identified later.",
            definitionNative = "Бережное удаление имён и зацепок из данных, чтобы потом никого нельзя было опознать.",
            example = "The hospital published research data only after full anonymization of patients.",
            exampleNative = "Больница опубликовала данные исследования только после полной anonymization пациентов.",
            pos = "noun", semanticGroup = "internet_l4_data", fillInBlankExclusions = listOf(39311L, 39313L, 39314L, 39315L)),

        WordEntity(id = 39313, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "aggregation", transliteration = "[ˌæɡrəˈɡeɪʃən]", translation = "агрегация (данных)",
            definition = "The lumping of many records into rough totals so individual rows fade from view.",
            definitionNative = "Сваливание многих записей в общие итоги, чтобы отдельные строки скрылись из виду.",
            example = "Daily aggregation of clicks lets the dashboard show neat weekly trends.",
            exampleNative = "Ежедневная aggregation кликов позволяет панели рисовать аккуратные недельные тренды.",
            pos = "noun", semanticGroup = "internet_l4_data", fillInBlankExclusions = listOf(39309L, 39311L, 39312L, 39314L, 39315L)),

        WordEntity(id = 39314, setId = 393, languagePair = "en-ru", rarity = "RARE",
            original = "cookie consent", transliteration = "[ˈkʊki kənˈsɛnt]", translation = "согласие на cookies",
            definition = "The pop-up banner asking visitors to allow or refuse trackers before the site loads more.",
            definitionNative = "Всплывающий баннер, что просит посетителей разрешить или отказать трекерам, прежде чем сайт догрузится.",
            example = "A clean cookie consent banner builds trust with European visitors.",
            exampleNative = "Аккуратный баннер cookie consent укрепляет доверие у европейских посетителей.",
            pos = "noun", semanticGroup = "internet_l4_data", fillInBlankExclusions = listOf(39311L, 39312L, 39313L, 39315L, 39316L)),

        WordEntity(id = 39315, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "data minimization", transliteration = "[ˈdætə ˌmɪnəməˈzeɪʃən]", translation = "минимизация данных",
            definition = "The discipline of asking users for only the few fields the service truly needs.",
            definitionNative = "Дисциплина просить у пользователя лишь те немногие поля, что сервису по-настоящему нужны.",
            example = "The privacy team enforced strict data minimization across every signup form.",
            exampleNative = "Команда приватности продавила жёсткую data minimization по всем формам регистрации.",
            pos = "noun", semanticGroup = "internet_l4_data", fillInBlankExclusions = listOf(39311L, 39312L, 39313L, 39314L, 39316L)),

        // ── internet_l4_governance (5) ────────────────────────────────────

        WordEntity(id = 39316, setId = 393, languagePair = "en-ru", rarity = "RARE",
            original = "GDPR", transliteration = "[ˌʤi di pi ˈɑr]", translation = "европейский закон о защите данных",
            definition = "The strict European law from 2018 that hands users firm power over their personal data.",
            definitionNative = "Строгий европейский закон от 2018 года, что даёт пользователям твёрдую власть над их личными данными.",
            example = "Every European startup studies GDPR before launching a single landing page.",
            exampleNative = "Каждый европейский стартап изучает GDPR прежде, чем запустит хоть одну посадочную страницу.",
            pos = "noun", semanticGroup = "internet_l4_governance", fillInBlankExclusions = listOf(39314L, 39315L, 39317L, 39318L, 39319L, 39320L)),

        WordEntity(id = 39317, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "takedown notice", transliteration = "[ˈteɪkˌdaʊn ˈnoʊtəs]", translation = "требование удалить контент",
            definition = "A formal letter demanding a platform pull a post or video that breaks the rules or copyright.",
            definitionNative = "Формальное письмо, что требует площадку снять пост или видео, нарушающее правила или авторское право.",
            example = "The studio fired off a takedown notice within hours of the leak.",
            exampleNative = "Студия выпустила takedown notice уже через несколько часов после утечки.",
            pos = "noun", semanticGroup = "internet_l4_governance", fillInBlankExclusions = listOf(39316L, 39318L, 39319L, 39320L)),

        WordEntity(id = 39318, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "content policy", transliteration = "[ˈkɑntɛnt ˈpɑləsi]", translation = "правила публикации контента",
            definition = "The platform's written rules saying what posts are welcome and what will be removed.",
            definitionNative = "Письменные правила площадки, что говорят, какие посты в порядке, а какие будут удалены.",
            example = "The new content policy bans deepfake images of private people.",
            exampleNative = "Новая content policy запрещает дипфейки изображений частных людей.",
            pos = "noun", semanticGroup = "internet_l4_governance", fillInBlankExclusions = listOf(39316L, 39317L, 39319L, 39320L)),

        WordEntity(id = 39319, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "right to erasure", transliteration = "[raɪt tu ɪˈreɪʒər]", translation = "право на удаление данных",
            definition = "A user's legal power to demand a company wipe all stored details about them.",
            definitionNative = "Юридическая власть пользователя требовать, чтобы компания стёрла все хранимые сведения о нём.",
            example = "She invoked her right to erasure and the bank deleted her old loan file.",
            exampleNative = "Она сослалась на right to erasure, и банк удалил её старое кредитное досье.",
            pos = "noun", semanticGroup = "internet_l4_governance", fillInBlankExclusions = listOf(39316L, 39317L, 39318L, 39320L)),

        WordEntity(id = 39320, setId = 393, languagePair = "en-ru", rarity = "RARE",
            original = "safe harbor", transliteration = "[seɪf ˈhɑrbər]", translation = "правовая защита от ответственности",
            definition = "A legal shield that frees a platform from blame for what its users post if it follows rules.",
            definitionNative = "Правовой щит, что освобождает площадку от вины за посты её пользователей, если она держится правил.",
            example = "The forum kept its safe harbor by removing illegal links promptly.",
            exampleNative = "Форум удержал свой safe harbor, оперативно убирая незаконные ссылки.",
            pos = "noun", semanticGroup = "internet_l4_governance", fillInBlankExclusions = listOf(39316L, 39317L, 39318L, 39319L)),

        // ── internet_l4_business_pro (5) ──────────────────────────────────

        WordEntity(id = 39321, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "LTV", transliteration = "[ˌɛl ti ˈvi]", translation = "пожизненная ценность клиента",
            definition = "The total money a single user is expected to bring during the whole time they stay.",
            definitionNative = "Совокупные деньги, что один пользователь, как ждут, принесёт за всё время, пока остаётся.",
            example = "Subscription apps obsessively track LTV by signup cohort.",
            exampleNative = "Подписочные приложения одержимо отслеживают LTV по когортам регистрации.",
            pos = "noun", semanticGroup = "internet_l4_business_pro", fillInBlankExclusions = listOf(39322L, 39323L, 39324L, 39325L)),

        WordEntity(id = 39322, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "CAC", transliteration = "[ˌsi eɪ ˈsi]", translation = "стоимость привлечения клиента",
            definition = "How much money the company must spend on ads and sales to win one new paying user.",
            definitionNative = "Сколько денег компания должна потратить на рекламу и продажи, чтобы заполучить одного нового платящего пользователя.",
            example = "Rising CAC forced the startup to rethink its ad budget.",
            exampleNative = "Растущий CAC заставил стартап переосмыслить рекламный бюджет.",
            pos = "noun", semanticGroup = "internet_l4_business_pro", fillInBlankExclusions = listOf(39321L, 39323L, 39324L, 39325L)),

        WordEntity(id = 39323, setId = 393, languagePair = "en-ru", rarity = "EPIC",
            original = "retention curve", transliteration = "[rɪˈtɛnʃən kɜrv]", translation = "кривая удержания",
            definition = "The chart showing what share of new users still come back after a day, week, and month.",
            definitionNative = "График, что показывает, какая доля новых пользователей ещё возвращается через день, неделю и месяц.",
            example = "A flat retention curve is the dream of every product manager.",
            exampleNative = "Плоская retention curve — мечта каждого продакт-менеджера.",
            pos = "noun", semanticGroup = "internet_l4_business_pro", fillInBlankExclusions = listOf(39321L, 39322L, 39324L, 39325L)),

        WordEntity(id = 39324, setId = 393, languagePair = "en-ru", rarity = "RARE",
            original = "attribution model", transliteration = "[ˌætrɪˈbjuʃən ˈmɑdəl]", translation = "модель атрибуции",
            definition = "The math rule that decides which ad gets the credit when many touched the user before they paid.",
            definitionNative = "Математическое правило, что решает, какой рекламе отдать заслугу, когда пользователя коснулись многие до оплаты.",
            example = "Switching the attribution model halved the credit going to last-click ads.",
            exampleNative = "Смена attribution model вдвое урезала заслугу, что доставалась рекламе последнего клика.",
            pos = "noun", semanticGroup = "internet_l4_business_pro", fillInBlankExclusions = listOf(39321L, 39322L, 39323L, 39325L)),

        WordEntity(id = 39325, setId = 393, languagePair = "en-ru", rarity = "RARE",
            original = "stickiness", transliteration = "[ˈstɪkinəs]", translation = "залипаемость продукта",
            definition = "How tightly an app glues users to itself — measured by daily over monthly active users.",
            definitionNative = "Насколько крепко приложение приклеивает к себе пользователей — мерится дневной активностью к месячной.",
            example = "Social apps with high stickiness see users open them many times a day.",
            exampleNative = "Соцсети с высокой stickiness видят, как пользователи открывают их много раз в день.",
            pos = "noun", semanticGroup = "internet_l4_business_pro", fillInBlankExclusions = listOf(39321L, 39322L, 39323L, 39324L)),
    )
}
