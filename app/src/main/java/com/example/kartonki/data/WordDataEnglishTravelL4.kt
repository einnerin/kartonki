package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Путешествия (level 4, профессиональный).
 *
 * Set 336: «Путешествия» — профессиональная лексика туриндустрии:
 * персонал высокого сервиса, типы маршрутов, описания мест,
 * процессы изменения курса и нюансы гостиничного сервиса (C1).
 *
 * Распределение редкости: 16 EPIC + 9 RARE — два смежных уровня
 * шкалы, преобладает EPIC.
 *
 * Дополняет уже существующие сеты темы «Путешествия»:
 *   - Set 20  (WordDataEnglish.kt)        — L1 COMMON (hotel, passport, tour…).
 *   - Set 40  (WordDataEnglish.kt)        — L2 UNCOMMON (itinerary, layover, baggage…).
 *   - Set 261 (WordDataEnglishBatch6.kt)  — L2 COMMON/UNCOMMON (camping, hiking…).
 *   - Set 335 (L3) и Set 337 (L5) — параллельные уровни той же темы.
 *
 * Слова setId=336 не пересекаются ни с одним из перечисленных setId
 * (проверено grep по всем файлам data/).
 *
 * SemanticGroups (5 × 5):
 *   travel_industry_staff      — concierge, chauffeur, valet, bellhop, hospitality
 *   travel_journey_types       — safari, caravan, passage, peregrination, escapade
 *   travel_scenic_descriptors  — secluded, panoramic, quaint, idyllic, bucolic
 *   travel_route_changes       — reroute, divert, veer, decamp, abscond
 *   travel_luxury_amenities    — gratuity, suite, en-suite, boutique, pampering
 *
 * Word IDs: 33601..33625 (setId × 100 + position).
 */
object WordDataEnglishTravelL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 336, name = "Путешествия",
            description = "Профессиональная лексика туризма: типы туров, гостиничный сервис, специальные маршруты",
            languagePair = "en-ru",
            orderIndex = 146,
            topic = "Путешествия", level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ── travel_industry_staff (5) ─────────────────────────────────────

        WordEntity(id = 33601, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "concierge", transliteration = "[ˌkɑnsiˈɛrʒ]", translation = "консьерж (в гостинице)",
            definition = "A hotel worker who books tours, taxis and tables for the guests.",
            definitionNative = "Сотрудник отеля, который бронирует туры, такси и столики для гостей.",
            example = "The concierge arranged a private boat tour for our last evening.",
            exampleNative = "Concierge организовал нам частную лодочную прогулку на последний вечер.",
            pos = "noun", semanticGroup = "travel_industry_staff",
            fillInBlankExclusions = listOf(33602L, 33603L, 33604L, 33605L)),

        WordEntity(id = 33602, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "chauffeur", transliteration = "[ʃoʊˈfɜr]", translation = "личный шофёр",
            definition = "A person hired to drive a wealthy traveller's private car.",
            definitionNative = "Нанятый водитель, который возит состоятельного путешественника на личной машине.",
            example = "A chauffeur in a dark suit met us at the small private airport.",
            exampleNative = "Chauffeur в тёмном костюме встретил нас в маленьком частном аэропорту.",
            pos = "noun", semanticGroup = "travel_industry_staff",
            fillInBlankExclusions = listOf(33601L, 33603L, 33604L, 33605L)),

        WordEntity(id = 33603, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "valet", transliteration = "[væˈleɪ]", translation = "гостиничный парковщик; камердинер",
            definition = "A staff member who parks the guests' cars at a hotel entrance.",
            definitionNative = "Сотрудник, который паркует машины гостей у входа в гостиницу.",
            example = "The valet drove our rental down to the underground garage.",
            exampleNative = "Valet отогнал нашу прокатную машину в подземный гараж.",
            pos = "noun", semanticGroup = "travel_industry_staff",
            fillInBlankExclusions = listOf(33601L, 33602L, 33604L, 33605L)),

        WordEntity(id = 33604, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "bellhop", transliteration = "[ˈbɛlˌhɑp]", translation = "коридорный (носильщик в отеле)",
            definition = "A young porter in a uniform who carries luggage to hotel rooms.",
            definitionNative = "Молодой работник в униформе, который доставляет багаж гостей до номера.",
            example = "A bellhop wheeled our heavy cases up to the seventh floor.",
            exampleNative = "Bellhop отвёз наши тяжёлые чемоданы на седьмой этаж.",
            pos = "noun", semanticGroup = "travel_industry_staff",
            fillInBlankExclusions = listOf(33601L, 33602L, 33603L, 33605L)),

        WordEntity(id = 33605, setId = 336, languagePair = "en-ru", rarity = "RARE",
            original = "hospitality", transliteration = "[ˌhɑspɪˈtælɪti]", translation = "гостеприимство (как индустрия)",
            definition = "The whole industry of hotels, resorts and welcoming paying guests.",
            definitionNative = "Целая отрасль отелей, курортов и обслуживания приезжающих платных гостей.",
            example = "She studied hospitality at college and now runs a small boutique hotel.",
            exampleNative = "Она училась на hospitality в колледже и держит маленький бутик-отель.",
            pos = "noun", semanticGroup = "travel_industry_staff",
            fillInBlankExclusions = listOf(33601L, 33602L, 33603L, 33604L)),

        // ── travel_journey_types (5) ──────────────────────────────────────

        WordEntity(id = 33606, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "safari", transliteration = "[səˈfɑri]", translation = "сафари (поездка к диким животным)",
            definition = "An organised trip to watch wild animals, usually in the African plains.",
            definitionNative = "Организованная поездка ради наблюдения за дикими зверями, обычно в Африке.",
            example = "Their week on safari brought close views of lions and giraffes.",
            exampleNative = "Их неделя на safari подарила близкие виды львов и жирафов.",
            pos = "noun", semanticGroup = "travel_journey_types",
            fillInBlankExclusions = listOf(33607L, 33608L, 33609L, 33610L)),

        WordEntity(id = 33607, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "caravan", transliteration = "[ˈkærəvæn]", translation = "караван (группа путников через пустыню)",
            definition = "A long line of travellers, camels or carts crossing wild ground together.",
            definitionNative = "Длинная вереница путников, верблюдов или повозок, идущая через дикие места.",
            example = "A salt caravan crossed the dunes for nine slow days at walking pace.",
            exampleNative = "Соляной caravan шёл через дюны девять медленных дней пешим шагом.",
            pos = "noun", semanticGroup = "travel_journey_types",
            fillInBlankExclusions = listOf(33606L, 33608L, 33609L, 33610L)),

        WordEntity(id = 33608, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "passage", transliteration = "[ˈpæsɪʤ]", translation = "морской переход (длительный рейс)",
            definition = "A long journey by sea from one port to another distant one.",
            definitionNative = "Длительный путь по морю из одного порта в другой дальний порт.",
            example = "The Atlantic passage in winter took the ship over twenty rough days.",
            exampleNative = "Атлантический passage зимой занял у корабля больше двадцати штормовых дней.",
            pos = "noun", semanticGroup = "travel_journey_types",
            fillInBlankExclusions = listOf(33606L, 33607L, 33609L, 33610L)),

        WordEntity(id = 33609, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "peregrination", transliteration = "[ˌpɛrəɡrəˈneɪʃən]", translation = "длительные странствия (книжное)",
            definition = "A long, wandering journey through many places — a literary, formal word.",
            definitionNative = "Долгое блуждающее путешествие через множество мест — слово книжного стиля.",
            example = "Her European peregrination filled three thick notebooks with sketches.",
            exampleNative = "Её европейская peregrination наполнила три толстых блокнота зарисовками.",
            pos = "noun", semanticGroup = "travel_journey_types",
            fillInBlankExclusions = listOf(33606L, 33607L, 33608L, 33610L)),

        WordEntity(id = 33610, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "escapade", transliteration = "[ˈɛskəˌpeɪd]", translation = "авантюра, рискованная выходка",
            definition = "A wild, risky little adventure done for excitement, often half-secret.",
            definitionNative = "Дикое и рискованное маленькое приключение ради азарта, нередко полутайное.",
            example = "Their summer escapade through the islands made the papers back home.",
            exampleNative = "Их летний escapade по островам попал в газеты у них дома.",
            pos = "noun", semanticGroup = "travel_journey_types",
            fillInBlankExclusions = listOf(33606L, 33607L, 33608L, 33609L)),

        // ── travel_scenic_descriptors (5) ─────────────────────────────────

        WordEntity(id = 33611, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "secluded", transliteration = "[sɪˈkludɪd]", translation = "уединённый, укромный",
            definition = "Quiet and hidden away — far from crowds, traffic and bright lights.",
            definitionNative = "Тихий и спрятанный — вдали от толп, шумных дорог и яркого света.",
            example = "The lodge sat on a secluded bay with no other building in sight.",
            exampleNative = "Лодж стоял в secluded бухте, где не виднелось ни одного другого строения.",
            pos = "adjective", semanticGroup = "travel_scenic_descriptors",
            fillInBlankExclusions = listOf(33612L, 33613L, 33614L, 33615L)),

        WordEntity(id = 33612, setId = 336, languagePair = "en-ru", rarity = "RARE",
            original = "panoramic", transliteration = "[ˌpænəˈræmɪk]", translation = "панорамный (вид на много километров)",
            definition = "Stretching wide on every side — a long, open view far into the distance.",
            definitionNative = "Раскрывающийся вширь на все стороны — длинный открытый вид вдаль.",
            example = "Our top-floor room had a panoramic view across the harbour at sunset.",
            exampleNative = "Из нашего верхнего номера открывался panoramic вид на гавань в закат.",
            pos = "adjective", semanticGroup = "travel_scenic_descriptors",
            fillInBlankExclusions = listOf(33611L, 33613L, 33614L, 33615L)),

        WordEntity(id = 33613, setId = 336, languagePair = "en-ru", rarity = "RARE",
            original = "quaint", transliteration = "[kweɪnt]", translation = "очаровательно старомодный",
            definition = "Pleasing in an old-fashioned, slightly unusual way — like a fairy-tale street.",
            definitionNative = "Приятный в старомодной, чуть необычной манере — словно сказочная улочка.",
            example = "A quaint stone bridge crossed the stream beside the bakery.",
            exampleNative = "Quaint каменный мостик пересекал ручей возле пекарни.",
            pos = "adjective", semanticGroup = "travel_scenic_descriptors",
            fillInBlankExclusions = listOf(33611L, 33612L, 33614L, 33615L)),

        WordEntity(id = 33614, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "idyllic", transliteration = "[aɪˈdɪlɪk]", translation = "идиллический, безмятежно прекрасный",
            definition = "Peaceful and perfectly lovely — like a calm scene in an old painting.",
            definitionNative = "Спокойный и совершенно прелестный — словно тихая сцена со старой картины.",
            example = "An idyllic afternoon by the lake passed without a single phone signal.",
            exampleNative = "Idyllic полдень у озера прошёл без единого сигнала телефонной сети.",
            pos = "adjective", semanticGroup = "travel_scenic_descriptors",
            fillInBlankExclusions = listOf(33611L, 33612L, 33613L, 33615L)),

        WordEntity(id = 33615, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "bucolic", transliteration = "[bjuˈkɑlɪk]", translation = "пасторальный, сельский (буколический)",
            definition = "Belonging to peaceful country life — fields, sheep, slow rivers, old farms.",
            definitionNative = "Связанный с тихой деревенской жизнью — поля, овцы, медленные реки, старые фермы.",
            example = "The cottage stood in a bucolic valley dotted with grazing sheep.",
            exampleNative = "Коттедж стоял в bucolic долине, усыпанной пасущимися овцами.",
            pos = "adjective", semanticGroup = "travel_scenic_descriptors",
            fillInBlankExclusions = listOf(33611L, 33612L, 33613L, 33614L)),

        // ── travel_route_changes (5) ──────────────────────────────────────

        WordEntity(id = 33616, setId = 336, languagePair = "en-ru", rarity = "RARE",
            original = "reroute", transliteration = "[riˈrut]", translation = "перенаправлять (рейс или маршрут)",
            definition = "To change a planned path so that travellers go a different way.",
            definitionNative = "Изменить запланированный путь, чтобы путешественники поехали другой дорогой.",
            example = "The airline had to reroute the flight around the gathering storm.",
            exampleNative = "Авиакомпании пришлось reroute рейс в обход надвигающейся бури.",
            pos = "verb", semanticGroup = "travel_route_changes",
            fillInBlankExclusions = listOf(33617L, 33618L, 33619L, 33620L)),

        WordEntity(id = 33617, setId = 336, languagePair = "en-ru", rarity = "RARE",
            original = "divert", transliteration = "[daɪˈvərt]", translation = "отклонять с курса (рейс/судно)",
            definition = "To make a flight or ship leave its planned line and go elsewhere.",
            definitionNative = "Заставить рейс или судно сойти с запланированной линии и идти иначе.",
            example = "Bad fog forced the pilots to divert the plane to a quiet inland airport.",
            exampleNative = "Густой туман заставил пилотов divert самолёт на тихий аэропорт в глубине страны.",
            pos = "verb", semanticGroup = "travel_route_changes",
            fillInBlankExclusions = listOf(33616L, 33618L, 33619L, 33620L)),

        WordEntity(id = 33618, setId = 336, languagePair = "en-ru", rarity = "RARE",
            original = "veer", transliteration = "[vɪr]", translation = "резко свернуть в сторону",
            definition = "To turn sharply away from a straight line, often without warning.",
            definitionNative = "Резко отвернуть от прямой линии, нередко без предупреждения.",
            example = "The driver had to veer onto the shoulder to dodge the fallen branch.",
            exampleNative = "Водителю пришлось veer на обочину, чтобы объехать упавшую ветку.",
            pos = "verb", semanticGroup = "travel_route_changes",
            fillInBlankExclusions = listOf(33616L, 33617L, 33619L, 33620L)),

        WordEntity(id = 33619, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "decamp", transliteration = "[diˈkæmp]", translation = "сниматься с места, спешно уезжать",
            definition = "To leave a place quickly — usually picking up gear and slipping away.",
            definitionNative = "Быстро покинуть место — обычно собрав вещи и тихо уйдя.",
            example = "We had to decamp before dawn when the river started to flood.",
            exampleNative = "Нам пришлось decamp ещё до рассвета, когда река начала разливаться.",
            pos = "verb", semanticGroup = "travel_route_changes",
            fillInBlankExclusions = listOf(33616L, 33617L, 33618L, 33620L)),

        WordEntity(id = 33620, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "abscond", transliteration = "[æbˈskɑnd]", translation = "тайно скрываться (с чем-либо)",
            definition = "To run away in secret, often after taking money or breaking a rule.",
            definitionNative = "Тайно бежать, нередко прихватив деньги или нарушив правила.",
            example = "A guest tried to abscond from the hotel without paying his bill.",
            exampleNative = "Один гость попытался abscond из отеля, не оплатив счёт.",
            pos = "verb", semanticGroup = "travel_route_changes",
            fillInBlankExclusions = listOf(33616L, 33617L, 33618L, 33619L)),

        // ── travel_luxury_amenities (5) ───────────────────────────────────

        WordEntity(id = 33621, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "gratuity", transliteration = "[ɡrəˈtuəti]", translation = "чаевые (формальное); надбавка за обслуживание",
            definition = "A formal extra payment for good service, often added to a hotel bill.",
            definitionNative = "Официальная доплата за хорошее обслуживание, нередко включаемая в счёт отеля.",
            example = "The bill already included a ten percent gratuity for the staff.",
            exampleNative = "В счёт уже была включена десятипроцентная gratuity для персонала.",
            pos = "noun", semanticGroup = "travel_luxury_amenities",
            fillInBlankExclusions = listOf(33622L, 33623L, 33624L, 33625L)),

        WordEntity(id = 33622, setId = 336, languagePair = "en-ru", rarity = "RARE",
            original = "suite", transliteration = "[swit]", translation = "номер-люкс из нескольких комнат",
            definition = "A set of joined hotel rooms — usually a sitting room plus bedrooms.",
            definitionNative = "Связанные между собой номера в отеле — обычно гостиная плюс спальни.",
            example = "They booked a corner suite with a wide balcony over the sea.",
            exampleNative = "Они забронировали угловой suite с широким балконом над морем.",
            pos = "noun", semanticGroup = "travel_luxury_amenities",
            fillInBlankExclusions = listOf(33621L, 33623L, 33624L, 33625L)),

        WordEntity(id = 33623, setId = 336, languagePair = "en-ru", rarity = "EPIC",
            original = "en-suite", transliteration = "[ɑn ˈswit]", translation = "с собственной ванной (о номере)",
            definition = "Said of a hotel room that has its own bathroom inside, not shared.",
            definitionNative = "О номере в отеле, у которого внутри собственная ванная, без общего пользования.",
            example = "Every double room is en-suite with a deep bath and rainfall shower.",
            exampleNative = "Каждый двухместный номер en-suite с глубокой ванной и тропическим душем.",
            pos = "adjective", semanticGroup = "travel_luxury_amenities",
            fillInBlankExclusions = listOf(33621L, 33622L, 33624L, 33625L)),

        WordEntity(id = 33624, setId = 336, languagePair = "en-ru", rarity = "RARE",
            original = "boutique", transliteration = "[buˈtik]", translation = "бутик-отель (маленький стильный)",
            definition = "A small, stylish hotel with personal service and an unusual design.",
            definitionNative = "Маленькая стильная гостиница с личным обслуживанием и необычным дизайном.",
            example = "We chose a boutique hotel with only twelve rooms above an old courtyard.",
            exampleNative = "Мы выбрали boutique отель всего на двенадцать номеров над старым двориком.",
            pos = "adjective", semanticGroup = "travel_luxury_amenities",
            fillInBlankExclusions = listOf(33621L, 33622L, 33623L, 33625L)),

        WordEntity(id = 33625, setId = 336, languagePair = "en-ru", rarity = "RARE",
            original = "pampering", transliteration = "[ˈpæmpərɪŋ]", translation = "балование, нежная забота (в спа/отеле)",
            definition = "Treating a guest with extra care and tiny luxuries — massages, sweets, robes.",
            definitionNative = "Обращение с гостем с особой заботой и маленькими роскошами — массаж, сладости, халаты.",
            example = "The spa weekend was three days of pure pampering for tired parents.",
            exampleNative = "Уикенд в спа стал тремя днями чистого pampering для уставших родителей.",
            pos = "noun", semanticGroup = "travel_luxury_amenities",
            fillInBlankExclusions = listOf(33621L, 33622L, 33623L, 33624L)),
    )
}
