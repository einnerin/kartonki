package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Городская жизнь и услуги (level 4, профессиональный).
 *
 * Set 368: «Городская жизнь и услуги» — профессиональная лексика
 * (бюрократия, городское планирование, civic services, базовое право,
 * муниципальная инфраструктура).
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY — два смежных уровня шкалы.
 *
 * Тема намеренно отделена от темы «Город» (sets 287–291): здесь — административный,
 * процедурный и сервисный слой городской жизни (бумаги, слушания, ордера на пандус),
 * а не пространственная морфология.
 *
 * Слова setId=368 не пересекаются ни с одним из существующих сетов «Город» (288–291),
 * «Право» (220–221) или «Политика» (236–237, 330–331) — проверено grep.
 *
 * SemanticGroups (5 × 5):
 *   city_bureaucracy        — application form, processing time, supporting documents,
 *                             eligibility criteria, expiration date
 *   city_planning           — floor area ratio, master plan, urban renewal,
 *                             mixed-use development, density bonus
 *   city_civic_services     — civic duty, voter registration, town hall meeting,
 *                             public hearing, freedom of information
 *   city_legal_basics       — power of attorney, notarized copy, sworn statement,
 *                             legal standing, statute of limitations
 *   city_infrastructure     — public works, water main, fiber rollout,
 *                             accessibility ramp, road resurfacing
 *
 * Word IDs: 36801..36825 (setId × 100 + position).
 *
 * Все 25 слов помечены isFillInBlankSafe = false: примеры из бюрократическо-
 * административной лексики неизбежно содержат generic-конструкции типа
 * «You must submit a ___» / «Please bring a ___», где в пропуск встаёт
 * любой из соседей. fillInBlankExclusions заполняется pipeline-ом после фиксации.
 */
object WordDataEnglishCityLifeL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 368,
            languagePair = "en-ru",
            orderIndex = 368,
            name = "Городская жизнь и услуги",
            description = "Профессиональный: бюрократия, городское планирование, civic services",
            topic = "Городская жизнь и услуги",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── city_bureaucracy (5) ──────────────────────────────────────────

        WordEntity(id = 36801, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "application form", transliteration = "[ˌæpləˈkeɪʃən fɔːrm]", translation = "анкета / бланк заявления",
            definition = "An official paper you fill in to ask for a permit, job or grant.",
            definitionNative = "Бумажный или онлайн бланк, что заполняют, прося разрешение, работу или грант.",
            example = "She filled in the application form for a new driver's license.",
            exampleNative = "Она заполнила application form на новые водительские права.",
            pos = "noun", semanticGroup = "city_bureaucracy", isFillInBlankSafe = false),

        WordEntity(id = 36802, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "processing time", transliteration = "[ˈprɑːsesɪŋ taɪm]", translation = "срок рассмотрения",
            definition = "The number of days an office needs to handle your paper request.",
            definitionNative = "Сколько дней ведомству нужно, чтобы обработать поданную бумагу.",
            example = "The standard processing time for a passport is six business weeks.",
            exampleNative = "Стандартный processing time паспорта — около шести рабочих недель.",
            pos = "noun", semanticGroup = "city_bureaucracy", isFillInBlankSafe = false),

        WordEntity(id = 36803, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "supporting documents", transliteration = "[səˈpɔːrtɪŋ ˈdɑːkjəmənts]", translation = "подтверждающие документы",
            definition = "Extra papers — bills, IDs, letters — that prove what your form claims.",
            definitionNative = "Доп. бумаги: счета, справки, письма, что доказывают сказанное в анкете.",
            example = "Please bring all supporting documents to the consulate appointment.",
            exampleNative = "В консульство принесите все supporting documents к приёму.",
            pos = "noun", semanticGroup = "city_bureaucracy", isFillInBlankSafe = false),

        WordEntity(id = 36804, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "eligibility criteria", transliteration = "[ˌelɪdʒəˈbɪləti kraɪˈtɪriə]", translation = "критерии соответствия",
            definition = "The list of rules a person must meet to qualify for a benefit.",
            definitionNative = "Список условий, которым нужно соответствовать, чтобы получить льготу.",
            example = "Check the eligibility criteria before you spend hours on the form.",
            exampleNative = "Сверьтесь с eligibility criteria, прежде чем мучиться с анкетой.",
            pos = "noun", semanticGroup = "city_bureaucracy", isFillInBlankSafe = false),

        WordEntity(id = 36805, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "expiration date", transliteration = "[ˌekspəˈreɪʃən deɪt]", translation = "срок действия (до даты)",
            definition = "The day after which a card, permit or paper no longer works.",
            definitionNative = "Дата, после которой документ или карта перестают что-либо значить.",
            example = "The clerk noticed the expiration date on my old residency card.",
            exampleNative = "Чиновник заметил expiration date на моём старом виде на жительство.",
            pos = "noun", semanticGroup = "city_bureaucracy", isFillInBlankSafe = false),

        // ── city_planning (5) ─────────────────────────────────────────────

        WordEntity(id = 36806, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "floor area ratio", transliteration = "[flɔːr ˈeriə ˈreɪʃoʊ]", translation = "коэффициент застройки (FAR)",
            definition = "A number that limits how much building can sit on a plot of land.",
            definitionNative = "Число, ограничивающее, сколько квадратных метров можно построить на участке.",
            example = "The new tower exceeds the legal floor area ratio for this district.",
            exampleNative = "Новая башня превышает разрешённый floor area ratio для квартала.",
            pos = "noun", semanticGroup = "city_planning", isFillInBlankSafe = false),

        WordEntity(id = 36807, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "master plan", transliteration = "[ˈmæstər plæn]", translation = "генеральный план",
            definition = "A long-term map showing how a town will grow over twenty years.",
            definitionNative = "Долгосрочная карта, показывающая, как город будет расти лет двадцать.",
            example = "The new master plan promises greener squares and fewer parking lots.",
            exampleNative = "Новый master plan обещает зелёные площади и меньше парковок.",
            pos = "noun", semanticGroup = "city_planning", isFillInBlankSafe = false),

        WordEntity(id = 36808, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "urban renewal", transliteration = "[ˈɜːrbən rɪˈnuːəl]", translation = "реновация района",
            definition = "A big city programme to tear down old blocks and build new ones.",
            definitionNative = "Программа властей: снести старые кварталы и поставить на их месте новые.",
            example = "Decades of urban renewal erased the old port neighborhoods completely.",
            exampleNative = "Годы urban renewal стёрли с лица земли старые портовые кварталы.",
            pos = "noun", semanticGroup = "city_planning", isFillInBlankSafe = false),

        WordEntity(id = 36809, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mixed-use development", transliteration = "[ˌmɪkstˈjuːs dɪˈveləpmənt]", translation = "комплексная застройка (жильё + услуги)",
            definition = "A project that puts homes, shops and offices together in one area.",
            definitionNative = "Проект, что объединяет жильё, магазины и офисы в едином квартале.",
            example = "The new mixed-use development will host shops, flats and a small theatre.",
            exampleNative = "В mixed-use development откроются магазины, квартиры и небольшой театр.",
            pos = "noun", semanticGroup = "city_planning", isFillInBlankSafe = false),

        WordEntity(id = 36810, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "density bonus", transliteration = "[ˈdensəti ˈboʊnəs]", translation = "бонус плотности (за соц. жильё)",
            definition = "Permission to build taller in exchange for cheap homes or green space.",
            definitionNative = "Разрешение строить выше в обмен на доступное жильё или сквер.",
            example = "The builder got a density bonus by adding affordable flats below.",
            exampleNative = "Застройщик получил density bonus, добавив доступные квартиры внизу.",
            pos = "noun", semanticGroup = "city_planning", isFillInBlankSafe = false),

        // ── city_civic_services (5) ───────────────────────────────────────

        WordEntity(id = 36811, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "civic duty", transliteration = "[ˈsɪvɪk ˈduːti]", translation = "гражданский долг",
            definition = "The unpaid jobs every citizen owes — voting, jury service, paying tax.",
            definitionNative = "Бесплатные обязанности гражданина: голосовать, идти в присяжные, платить налог.",
            example = "Voting in elections is the simplest civic duty of any adult resident.",
            exampleNative = "Голосовать на выборах — простейший civic duty взрослого жителя.",
            pos = "noun", semanticGroup = "city_civic_services", isFillInBlankSafe = false),

        WordEntity(id = 36812, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "voter registration", transliteration = "[ˈvoʊtər ˌredʒɪˈstreɪʃən]", translation = "регистрация избирателя",
            definition = "Putting your name on the official list so you can cast a ballot.",
            definitionNative = "Внести имя в официальный список, чтобы получить право бросить бюллетень.",
            example = "Voter registration closes ten days before the next election day.",
            exampleNative = "Voter registration закрывается за десять дней до выборов.",
            pos = "noun", semanticGroup = "city_civic_services", isFillInBlankSafe = false),

        WordEntity(id = 36813, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "town hall meeting", transliteration = "[ˈtaʊn hɔːl ˈmiːtɪŋ]", translation = "встреча мэрии с горожанами",
            definition = "An open gathering where locals talk directly with their elected leaders.",
            definitionNative = "Открытая встреча, где жители напрямую говорят со своими избранными.",
            example = "The mayor faced angry residents at last night's town hall meeting.",
            exampleNative = "Мэр встретил гнев жителей на вчерашнем town hall meeting.",
            pos = "noun", semanticGroup = "city_civic_services", isFillInBlankSafe = false),

        WordEntity(id = 36814, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "public hearing", transliteration = "[ˈpʌblɪk ˈhɪrɪŋ]", translation = "публичные слушания",
            definition = "A legal session where any resident can speak before a decision is made.",
            definitionNative = "Юр. заседание, где любой житель может выступить до принятия решения.",
            example = "Neighbors lined up at the public hearing to oppose the new highway.",
            exampleNative = "Соседи выстроились на public hearing — все против новой трассы.",
            pos = "noun", semanticGroup = "city_civic_services", isFillInBlankSafe = false),

        WordEntity(id = 36815, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "freedom of information", transliteration = "[ˈfriːdəm əv ˌɪnfərˈmeɪʃən]", translation = "свобода доступа к информации",
            definition = "The legal right of any person to ask for and get government records.",
            definitionNative = "Право любого гражданина запросить и получить документы из госорганов.",
            example = "Reporters used freedom of information laws to expose hidden contracts.",
            exampleNative = "Журналисты через freedom of information вскрыли секретные контракты.",
            pos = "noun", semanticGroup = "city_civic_services", isFillInBlankSafe = false),

        // ── city_legal_basics (5) ─────────────────────────────────────────

        WordEntity(id = 36816, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "power of attorney", transliteration = "[ˈpaʊər əv əˈtɜːrni]", translation = "доверенность",
            definition = "A signed paper letting one person act on the legal behalf of another.",
            definitionNative = "Подписанная бумага, что позволяет одному человеку действовать за другого.",
            example = "She signed a power of attorney so her son could sell the house.",
            exampleNative = "Она подписала power of attorney, чтобы сын мог продать дом.",
            pos = "noun", semanticGroup = "city_legal_basics", isFillInBlankSafe = false),

        WordEntity(id = 36817, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "notarized copy", transliteration = "[ˈnoʊtəraɪzd ˈkɑːpi]", translation = "нотариально заверенная копия",
            definition = "A duplicate paper stamped by an officer to prove it matches the original.",
            definitionNative = "Дубликат, заверенный печатью, что подтверждает совпадение с оригиналом.",
            example = "The bank required a notarized copy of the marriage certificate today.",
            exampleNative = "Банк потребовал notarized copy свидетельства о браке сегодня.",
            pos = "noun", semanticGroup = "city_legal_basics", isFillInBlankSafe = false),

        WordEntity(id = 36818, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sworn statement", transliteration = "[swɔːrn ˈsteɪtmənt]", translation = "письменное показание под присягой",
            definition = "A signed paper where you promise the words inside are fully true.",
            definitionNative = "Подписанная бумага, где человек клянётся в полной правдивости сказанного.",
            example = "The judge accepted the sworn statement instead of a courtroom appearance.",
            exampleNative = "Судья принял sworn statement вместо личной явки в зал суда.",
            pos = "noun", semanticGroup = "city_legal_basics", isFillInBlankSafe = false),

        WordEntity(id = 36819, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "legal standing", transliteration = "[ˈliːɡəl ˈstændɪŋ]", translation = "процессуальная правоспособность",
            definition = "The right of a person or group to bring a complaint before a court.",
            definitionNative = "Право человека или группы подать иск и быть услышанным в суде.",
            example = "The court ruled the neighbors had legal standing to challenge the permit.",
            exampleNative = "Суд решил: у соседей есть legal standing, чтобы оспорить ордер.",
            pos = "noun", semanticGroup = "city_legal_basics", isFillInBlankSafe = false),

        WordEntity(id = 36820, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "statute of limitations", transliteration = "[ˈstætʃuːt əv ˌlɪməˈteɪʃənz]", translation = "срок исковой давности",
            definition = "The deadline after which a complaint can no longer be filed in court.",
            definitionNative = "Крайний срок, после которого иск уже нельзя подать в суд.",
            example = "The fraud claim was dismissed under the statute of limitations rule.",
            exampleNative = "Иск о мошенничестве отклонили по statute of limitations.",
            pos = "noun", semanticGroup = "city_legal_basics", isFillInBlankSafe = false),

        // ── city_infrastructure (5) ───────────────────────────────────────

        WordEntity(id = 36821, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "public works", transliteration = "[ˈpʌblɪk wɜːrks]", translation = "общественные работы (городские)",
            definition = "City projects like roads, sewers and bridges paid from the budget.",
            definitionNative = "Городские проекты — дороги, мосты, канализация — оплаченные из бюджета.",
            example = "Heavy rain delayed the public works on our muddy main avenue.",
            exampleNative = "Сильный дождь задержал public works на нашей размытой улице.",
            pos = "noun", semanticGroup = "city_infrastructure", isFillInBlankSafe = false),

        WordEntity(id = 36822, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "water main", transliteration = "[ˈwɔːtər meɪn]", translation = "магистральная водопроводная труба",
            definition = "The big underground pipe that brings clean water to a whole street.",
            definitionNative = "Большая подземная труба, что несёт чистую воду на целую улицу.",
            example = "A burst water main flooded the corner shop just before midnight.",
            exampleNative = "Прорыв water main залил угловой магазин прямо перед полуночью.",
            pos = "noun", semanticGroup = "city_infrastructure", isFillInBlankSafe = false),

        WordEntity(id = 36823, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "fiber rollout", transliteration = "[ˈfaɪbər ˈroʊlaʊt]", translation = "прокладка оптоволокна",
            definition = "The work of laying fast internet cables street by street across town.",
            definitionNative = "Прокладка кабелей быстрого интернета улица за улицей по всему городу.",
            example = "The fiber rollout reached our village only after years of waiting.",
            exampleNative = "Fiber rollout добрался до нашего посёлка лишь после долгих лет.",
            pos = "noun", semanticGroup = "city_infrastructure", isFillInBlankSafe = false),

        WordEntity(id = 36824, setId = 368, languagePair = "en-ru", rarity = "EPIC",
            original = "accessibility ramp", transliteration = "[əkˌsesəˈbɪləti ræmp]", translation = "пандус для маломобильных",
            definition = "A gentle slope built for wheelchairs and prams next to the steps.",
            definitionNative = "Пологий съезд рядом с лестницей — для колясок и инвалидов.",
            example = "The new library finally has an accessibility ramp by the side door.",
            exampleNative = "В новой библиотеке наконец есть accessibility ramp у бокового входа.",
            pos = "noun", semanticGroup = "city_infrastructure", isFillInBlankSafe = false),

        WordEntity(id = 36825, setId = 368, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "road resurfacing", transliteration = "[roʊd ˌriːˈsɜːrfəsɪŋ]", translation = "обновление дорожного покрытия",
            definition = "Laying a fresh top layer of asphalt over a tired old street.",
            definitionNative = "Укладка свежего слоя асфальта поверх изношенной старой дороги.",
            example = "Road resurfacing on our block kept us awake for three full nights.",
            exampleNative = "Road resurfacing у нас во дворе не давал спать три ночи подряд.",
            pos = "noun", semanticGroup = "city_infrastructure", isFillInBlankSafe = false),
    )
}
