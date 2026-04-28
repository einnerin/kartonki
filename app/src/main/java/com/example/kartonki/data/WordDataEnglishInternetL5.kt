package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Интернет и соцсети (L5, EPIC+LEGENDARY).
 *
 * Set 394: «Интернет и соцсети» — носитель/архаика индустрии/философия/
 *          продвинутая культура. Архаика индустрии (BBS, USENET, Geocities,
 *          dial-up, webring), философия сети (cyberspace, panopticon,
 *          surveillance capitalism, attention economy, technosphere),
 *          продвинутая безопасность (cypherpunk, end-to-end, threat model,
 *          onion routing, air gap), продвинутая культура (Web3, metaverse,
 *          posthuman, parasocial, hyperreality), литературные описания
 *          (digerati, neo-Luddite, algorithmic, datafication, platformization).
 *
 * Тема «Интернет и соцсети» — продолжение L1 (set 390), L2 (set 391),
 * L3 (set 392). L4 (set 393) — соседний уровень (B2-C1), создаётся в той
 * же волне параллельным агентом. Чтобы избежать дублей с L4, этот сет
 * строго придерживается LEGENDARY-уровня — устаревшие термины индустрии,
 * философские категории, литературные описания, — а не базовые
 * технические термины.
 *
 * Все 25 слов этого сета не пересекаются ни с одним существующим английским
 * словом в базе (проверено grep по `original = "..."`). В частности обойдены
 * уже занятые слова: blockchain, steganography, cryptography, zero-day, VPN,
 * honeypot (set 235/247 Expanded), encryption (set 39), zeitgeist (set 77),
 * surveillance (set 69), technocracy (Expanded), hyperlink (set 51), sandbox
 * (Expanded/EntertainmentL1L2L3), deplatforming (set 392 InternetL3).
 *
 * Распределение редкости: 18 LEGENDARY + 7 EPIC — два смежных уровня (C1 + C2+).
 *
 * SemanticGroups (5 × 5):
 *   internet_l5_archaic_tech         — BBS, USENET, Geocities, dial-up, webring
 *   internet_l5_philosophy           — cyberspace, panopticon, surveillance capitalism, attention economy, technosphere
 *   internet_l5_advanced_security    — cypherpunk, end-to-end, threat model, onion routing, air gap
 *   internet_l5_culture_advanced     — Web3, metaverse, posthuman, parasocial, hyperreality
 *   internet_l5_descriptive          — digerati, neo-Luddite, algorithmic, datafication, platformization
 *
 * Word IDs: setId × 100 + position (39401..39425).
 *
 * fillInBlankExclusions / isFillInBlankSafe — НЕ задаются здесь. Заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave (известный баг:
 * если выставить заранее, pipeline пропустит запись).
 */
object WordDataEnglishInternetL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 394,
            languagePair = "en-ru",
            orderIndex = 394,
            name = "Интернет и соцсети",
            description = "Архаика индустрии, философия и продвинутая культура сети",
            topic = "Интернет и соцсети",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 394 — Интернет и соцсети: носитель/архаика (L5, EPIC+LEGENDARY) ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── internet_l5_archaic_tech (5) ──────────────────────────────────

        WordEntity(id = 39401, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "BBS",
            transliteration = "[ˌbi bi ˈɛs]",
            translation = "BBS, электронная доска объявлений (арх.)",
            definition = "An old dial-in board where users posted messages and traded files before the web.",
            definitionNative = "Старая дозвонная доска, где пользователи писали сообщения и обменивались файлами до веба.",
            example = "He recalled running a BBS from his bedroom in the late eighties.",
            exampleNative = "Он вспоминал, как держал BBS из своей спальни в конце восьмидесятых.",
            pos = "noun", semanticGroup = "internet_l5_archaic_tech", fillInBlankExclusions = listOf(39403L, 39404L, 39405L)),

        WordEntity(id = 39402, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "USENET",
            transliteration = "[ˈjuzˌnɛt]",
            translation = "USENET, ранняя сеть групп новостей (арх.)",
            definition = "A worldwide system of discussion newsgroups that thrived long before social media existed.",
            definitionNative = "Всемирная система обсуждательных групп новостей, расцвет которой пришёлся задолго до соцсетей.",
            example = "The flame wars on USENET shaped the manners of every later forum.",
            exampleNative = "Перепалки на USENET задали тон всем последующим форумам.",
            pos = "noun", semanticGroup = "internet_l5_archaic_tech", fillInBlankExclusions = listOf(39401L, 39403L, 39404L, 39405L)),

        WordEntity(id = 39403, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Geocities",
            transliteration = "[ˌʤioʊˈsɪtiz]",
            translation = "Geocities, ранний хостинг персональных страниц (арх.)",
            definition = "A nineties hosting service where amateurs built bright cluttered home pages by hand.",
            definitionNative = "Хостинг девяностых, где любители вручную верстали яркие пёстрые домашние страницы.",
            example = "Her first poems lived on a pink Geocities page with animated stars.",
            exampleNative = "Её первые стихи жили на розовой странице Geocities с анимированными звёздами.",
            pos = "noun", semanticGroup = "internet_l5_archaic_tech", fillInBlankExclusions = listOf(39401L, 39402L, 39404L, 39405L)),

        WordEntity(id = 39404, setId = 394, languagePair = "en-ru", rarity = "EPIC",
            original = "dial-up",
            transliteration = "[ˈdaɪəl ʌp]",
            translation = "коммутируемое соединение, дозвонная связь (арх.)",
            definition = "An old way of joining the network through a phone line and a screeching modem.",
            definitionNative = "Старый способ выхода в сеть по телефонной линии через скрипящий модем.",
            example = "On dial-up a single photograph could load for a full minute.",
            exampleNative = "На dial-up одна фотография могла грузиться целую минуту.",
            pos = "noun", semanticGroup = "internet_l5_archaic_tech", fillInBlankExclusions = listOf(39401L, 39402L, 39403L, 39405L)),

        WordEntity(id = 39405, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "webring",
            transliteration = "[ˈwɛbˌrɪŋ]",
            translation = "веб-кольцо (арх. способ связывания тематических сайтов)",
            definition = "An old chain of related amateur sites linked one to the next in a circular loop.",
            definitionNative = "Старая цепочка родственных любительских сайтов, связанных по кругу один с другим.",
            example = "Their tiny fan site joined a Star Trek webring of forty pages.",
            exampleNative = "Их крохотный фанатский сайт вступил в webring о Star Trek из сорока страниц.",
            pos = "noun", semanticGroup = "internet_l5_archaic_tech", fillInBlankExclusions = listOf(39401L, 39402L, 39403L, 39404L)),

        // ── internet_l5_philosophy (5) ────────────────────────────────────

        WordEntity(id = 39406, setId = 394, languagePair = "en-ru", rarity = "EPIC",
            original = "cyberspace",
            transliteration = "[ˈsaɪbərˌspeɪs]",
            translation = "киберпространство (филос.)",
            definition = "The imagined non-physical realm in which digital communication and identity unfold.",
            definitionNative = "Воображаемая нефизическая область, где разворачиваются цифровое общение и личность.",
            example = "The novel pictured cyberspace as a glittering city of pure data.",
            exampleNative = "Роман изображал cyberspace как сияющий город из чистых данных.",
            pos = "noun", semanticGroup = "internet_l5_philosophy", fillInBlankExclusions = listOf(39407L, 39408L, 39409L, 39410L, 39416L, 39417L, 39420L)),

        WordEntity(id = 39407, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "panopticon",
            transliteration = "[pəˈnɑptɪkən]",
            translation = "паноптикум, тотальная слежка (филос.)",
            definition = "A figure for total observation in which everyone may be watched without ever knowing.",
            definitionNative = "Образ тотального наблюдения, при котором за каждым могут смотреть, а он того не ведает.",
            example = "Critics likened the platform's logs to a digital panopticon.",
            exampleNative = "Критики уподобляли журналы платформы цифровому panopticon.",
            pos = "noun", semanticGroup = "internet_l5_philosophy", fillInBlankExclusions = listOf(39406L, 39408L, 39409L, 39410L, 39420L)),

        WordEntity(id = 39408, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "surveillance capitalism",
            transliteration = "[sərˈveɪləns ˈkæpɪtəˌlɪzəm]",
            translation = "капитализм наблюдения (филос.)",
            definition = "An economic order that turns private behaviour into raw material for prediction and profit.",
            definitionNative = "Хозяйственный уклад, превращающий частное поведение в сырьё для прогнозов и прибыли.",
            example = "Her book traced the rise of surveillance capitalism through Silicon Valley.",
            exampleNative = "Её книга прослеживала восхождение surveillance capitalism через Кремниевую долину.",
            pos = "noun", semanticGroup = "internet_l5_philosophy", fillInBlankExclusions = listOf(39406L, 39407L, 39409L, 39410L, 39411L, 39414L, 39416L, 39417L, 39420L, 39424L, 39425L)),

        WordEntity(id = 39409, setId = 394, languagePair = "en-ru", rarity = "EPIC",
            original = "attention economy",
            transliteration = "[əˈtɛnʃən ɪˈkɑnəmi]",
            translation = "экономика внимания (филос.)",
            definition = "A system in which scarce human attention itself is harvested, priced, and sold.",
            definitionNative = "Уклад, в котором сама дефицитная человеческая внимательность собирается, оценивается и продаётся.",
            example = "In the attention economy every notification is a tiny extraction of value.",
            exampleNative = "В attention economy каждое уведомление — крохотная выемка стоимости.",
            pos = "noun", semanticGroup = "internet_l5_philosophy", fillInBlankExclusions = listOf(39406L, 39407L, 39408L, 39410L, 39417L, 39425L)),

        WordEntity(id = 39410, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "technosphere",
            transliteration = "[ˈtɛknoʊˌsfɪr]",
            translation = "техносфера (филос.)",
            definition = "The whole human-built technical layer wrapping the planet — wires, satellites, code, machines.",
            definitionNative = "Весь рукотворный технический пласт, оплетающий планету: провода, спутники, код, машины.",
            example = "He argued that the technosphere now rivals the biosphere in mass and reach.",
            exampleNative = "Он доказывал, что technosphere ныне соперничает с биосферой по массе и охвату.",
            pos = "noun", semanticGroup = "internet_l5_philosophy", fillInBlankExclusions = listOf(39406L, 39407L, 39408L, 39409L, 39417L, 39424L, 39425L)),

        // ── internet_l5_advanced_security (5) ─────────────────────────────

        WordEntity(id = 39411, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cypherpunk",
            transliteration = "[ˈsaɪfərˌpʌŋk]",
            translation = "сайферпанк (защитник приватности через криптографию)",
            definition = "A member of the movement that defends privacy by writing and spreading strong cryptography.",
            definitionNative = "Сторонник движения, отстаивающего приватность через написание и распространение крепкой криптографии.",
            example = "The early cypherpunk mailing list dreamt of money beyond the reach of any state.",
            exampleNative = "Ранний список рассылки cypherpunk мечтал о деньгах вне досягаемости любой державы.",
            pos = "noun", semanticGroup = "internet_l5_advanced_security", fillInBlankExclusions = listOf(39413L, 39414L, 39415L, 39416L)),

        WordEntity(id = 39412, setId = 394, languagePair = "en-ru", rarity = "EPIC",
            original = "end-to-end",
            transliteration = "[ˈɛnd tu ˈɛnd]",
            translation = "сквозной (о шифровании от отправителя до адресата)",
            definition = "Of an exchange that stays sealed from sender to receiver — the carrier itself cannot read it.",
            definitionNative = "О передаче, запечатанной от отправителя до получателя — даже сам носитель её не прочтёт.",
            example = "The dissidents trusted only end-to-end messengers on their phones.",
            exampleNative = "Диссиденты доверяли в телефонах только end-to-end мессенджерам.",
            pos = "adjective", semanticGroup = "internet_l5_advanced_security", fillInBlankExclusions = listOf(39411L, 39414L, 39416L)),

        WordEntity(id = 39413, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "threat model",
            transliteration = "[θrɛt ˈmɑdəl]",
            translation = "модель угроз (продв. безопасность)",
            definition = "A formal map of who might attack a system, by what means, and what they could win.",
            definitionNative = "Формальная карта того, кто может напасть на систему, какими средствами и что выиграет.",
            example = "Their threat model assumed a hostile state actor with unlimited time.",
            exampleNative = "Их threat model полагала противником враждебное государство с неограниченным временем.",
            pos = "noun", semanticGroup = "internet_l5_advanced_security", fillInBlankExclusions = listOf(39411L, 39414L, 39415L)),

        WordEntity(id = 39414, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "onion routing",
            transliteration = "[ˈʌnjən ˈrutɪŋ]",
            translation = "луковая маршрутизация (анонимизация трафика слоями)",
            definition = "A way of hiding traffic by wrapping it in layers, each peeled off only by the next relay.",
            definitionNative = "Способ скрывать трафик, упаковывая его слоями, которые снимает по одному каждый следующий узел.",
            example = "Activists used onion routing to write posts under a hostile regime.",
            exampleNative = "Активисты применяли onion routing, чтобы писать посты под враждебным режимом.",
            pos = "noun", semanticGroup = "internet_l5_advanced_security", fillInBlankExclusions = listOf(39402L, 39411L, 39413L, 39415L, 39416L)),

        WordEntity(id = 39415, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "air gap",
            transliteration = "[ɛr ɡæp]",
            translation = "воздушный зазор (физическая изоляция от сети)",
            definition = "A physical separation between a sensitive machine and any network — no cable, no wireless.",
            definitionNative = "Физический разрыв между чувствительной машиной и любой сетью — ни кабеля, ни беспроводки.",
            example = "The signing key sat on a laptop kept behind a strict air gap.",
            exampleNative = "Подписной ключ хранился на ноутбуке за строгим air gap.",
            pos = "noun", semanticGroup = "internet_l5_advanced_security", fillInBlankExclusions = listOf(39411L, 39413L, 39414L)),

        // ── internet_l5_culture_advanced (5) ──────────────────────────────

        WordEntity(id = 39416, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Web3",
            transliteration = "[wɛb θri]",
            translation = "Web3 (концепция децентрализованного веба на блокчейне)",
            definition = "A proposed third era of the web built on distributed ledgers and ownership of digital assets.",
            definitionNative = "Предлагаемая третья эра веба, опирающаяся на распределённые реестры и владение цифровыми активами.",
            example = "The conference talks were nearly all about Web3 and digital ownership.",
            exampleNative = "Доклады на конференции почти все были про Web3 и цифровое владение.",
            pos = "noun", semanticGroup = "internet_l5_culture_advanced", fillInBlankExclusions = listOf(39406L, 39411L, 39417L, 39420L, 39424L, 39425L)),

        WordEntity(id = 39417, setId = 394, languagePair = "en-ru", rarity = "EPIC",
            original = "metaverse",
            transliteration = "[ˈmɛtəˌvərs]",
            translation = "метавселенная (продв. виртуальная среда)",
            definition = "A persistent shared virtual world in which users live, work, and trade through avatars.",
            definitionNative = "Постоянный общий виртуальный мир, где пользователи живут, трудятся и торгуют через аватары.",
            example = "The architect built a glass tower for a client inside the metaverse.",
            exampleNative = "Архитектор возвёл стеклянную башню для заказчика внутри metaverse.",
            pos = "noun", semanticGroup = "internet_l5_culture_advanced", fillInBlankExclusions = listOf(39410L, 39416L, 39420L)),

        WordEntity(id = 39418, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "posthuman",
            transliteration = "[poʊstˈhjumən]",
            translation = "постчеловеческий (за пределами привычной природы человека)",
            definition = "Of a stage of life beyond ordinary human limits — fused with code, prosthetics, or networks.",
            definitionNative = "О ступени жизни за обычными человеческими пределами — слитой с кодом, протезами или сетями.",
            example = "The essay imagined a posthuman self stitched together from cloud and flesh.",
            exampleNative = "Эссе рисовало posthuman «я», сшитое из облака и плоти.",
            pos = "adjective", semanticGroup = "internet_l5_culture_advanced", fillInBlankExclusions = listOf(39419L)),

        WordEntity(id = 39419, setId = 394, languagePair = "en-ru", rarity = "EPIC",
            original = "parasocial",
            transliteration = "[ˌpærəˈsoʊʃəl]",
            translation = "парасоциальный (о односторонней привязанности к публичной фигуре)",
            definition = "Of a one-sided bond a viewer forms with a distant figure who never knows the viewer at all.",
            definitionNative = "Об односторонней привязанности зрителя к далёкой фигуре, которая о зрителе и не подозревает.",
            example = "Her parasocial attachment to the streamer rivalled any real friendship.",
            exampleNative = "Её parasocial привязанность к стримеру не уступала живой дружбе.",
            pos = "adjective", semanticGroup = "internet_l5_culture_advanced", fillInBlankExclusions = listOf(39418L, 39423L)),

        WordEntity(id = 39420, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hyperreality",
            transliteration = "[ˌhaɪpərriˈæləti]",
            translation = "гиперреальность (филос.: симулякр ярче подлинного)",
            definition = "A condition where copies and simulations feel more vivid and true than the originals they mimic.",
            definitionNative = "Состояние, при котором копии и симуляции кажутся живее и истиннее своих подражаемых первообразов.",
            example = "The theme park offered a polished hyperreality of an old French village.",
            exampleNative = "Парк аттракционов предлагал отполированную hyperreality старой французской деревни.",
            pos = "noun", semanticGroup = "internet_l5_culture_advanced", fillInBlankExclusions = listOf(39416L, 39417L)),

        // ── internet_l5_descriptive (5) ───────────────────────────────────

        WordEntity(id = 39421, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "digerati",
            transliteration = "[ˌdɪʤəˈrɑti]",
            translation = "дигерати, цифровая элита (книжн.)",
            definition = "The small set of people held to be wise and influential about all things digital.",
            definitionNative = "Узкий круг людей, которых считают мудрыми и влиятельными во всём цифровом.",
            example = "The conference drew the New York digerati for three loud days.",
            exampleNative = "Конференция собрала нью-йоркских digerati на три шумных дня.",
            pos = "noun", semanticGroup = "internet_l5_descriptive", fillInBlankExclusions = listOf(39422L, 39424L, 39425L)),

        WordEntity(id = 39422, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "neo-Luddite",
            transliteration = "[ˌnioʊ ˈlʌˌdaɪt]",
            translation = "нео-луддит (противник новых технологий)",
            definition = "A modern critic who refuses or resists new technology on social or moral grounds.",
            definitionNative = "Современный критик, отвергающий или ограничивающий новые технологии по общественным или нравственным мотивам.",
            example = "His neo-Luddite cousin had thrown out every smart device in the house.",
            exampleNative = "Его neo-Luddite двоюродный брат повыкидывал все умные устройства из дома.",
            pos = "noun", semanticGroup = "internet_l5_descriptive", fillInBlankExclusions = listOf(39411L, 39421L, 39424L, 39425L)),

        WordEntity(id = 39423, setId = 394, languagePair = "en-ru", rarity = "EPIC",
            original = "algorithmic",
            transliteration = "[ˌælɡəˈrɪðmɪk]",
            translation = "алгоритмический (управляемый алгоритмом)",
            definition = "Run or shaped by algorithms — chosen, ranked, or filtered by code rather than by people.",
            definitionNative = "Управляемый или формируемый алгоритмами — отобранный, ранжированный или отсеянный кодом, а не людьми.",
            example = "An algorithmic feed quietly decided what every commuter saw that morning.",
            exampleNative = "Algorithmic лента тихо решала, что увидит тем утром каждый пассажир.",
            pos = "adjective", semanticGroup = "internet_l5_descriptive", fillInBlankExclusions = listOf(39409L)),

        WordEntity(id = 39424, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "datafication",
            transliteration = "[ˌdeɪtəfɪˈkeɪʃən]",
            translation = "датафикация (превращение всего в данные)",
            definition = "The turning of every act, mood, and motion into measured data ready to be stored and sold.",
            definitionNative = "Превращение каждого действия, настроения и движения в измеренные данные, готовые к хранению и продаже.",
            example = "The book warned of a creeping datafication of family life itself.",
            exampleNative = "Книга предупреждала о ползучей datafication самой семейной жизни.",
            pos = "noun", semanticGroup = "internet_l5_descriptive", fillInBlankExclusions = listOf(39406L, 39407L, 39409L, 39410L, 39416L, 39417L, 39420L, 39421L, 39422L, 39425L)),

        WordEntity(id = 39425, setId = 394, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "platformization",
            transliteration = "[ˌplætfɔrməˈzeɪʃən]",
            translation = "платформизация (поглощение жизни цифровыми платформами)",
            definition = "The slow takeover of public life by a few giant digital platforms that mediate everything.",
            definitionNative = "Медленный захват общественной жизни немногими гигантскими цифровыми платформами, посредничающими во всём.",
            example = "Scholars charted the platformization of news, taxis, and even hospitals.",
            exampleNative = "Учёные картировали platformization новостей, такси и даже больниц.",
            pos = "noun", semanticGroup = "internet_l5_descriptive", fillInBlankExclusions = listOf(39407L, 39408L, 39409L, 39410L, 39416L, 39417L, 39420L, 39421L, 39422L, 39424L)),
    )
}
