package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Городская жизнь и услуги (level 1, базовый).
 *
 * Set 365: «Городская жизнь и услуги: основы» — самая простая бытовая лексика
 * для ориентации в городе и обращения за услугами (A1, COMMON-доминантный сет).
 *
 * Распределение редкости: 13 COMMON + 12 UNCOMMON — два смежных уровня шкалы.
 *
 * Тема «Городская жизнь и услуги» новая для en-ru — same-topic дублей быть не может.
 * Кросс-топиковые пересечения с темами «Транспорт» (set 19), «Финансы» (343)
 * и «Шоппинг» (348-350) проверены и устранены: заведомо «городские» термины
 * (clerk, complaint, opening hours, business card, appointment, enter) выбраны
 * вместо receipt/queue/cashier/return из шоппинга.
 *
 * SemanticGroups (5 × 5):
 *   city_basic_places   — bank, post office, pharmacy, supermarket, library
 *   city_basic_streets  — street, sidewalk, traffic light, bus stop, crosswalk
 *   city_basic_services — clerk, complaint, opening hours, business card, appointment
 *   city_basic_navigate — address, sign, map, direction, corner
 *   city_basic_actions  — pay, ask, wait, find, enter
 *
 * Word IDs: 36501..36525 (setId × 100 + position).
 *
 * isFillInBlankSafe = false для всех слов: набор полностью бытовой,
 * пропуск часто получается слишком общим («I went to the ___»);
 * квалифицировать через runtime-pipeline FILL_IN_BLANK exclusions
 * можно после фиксации содержимого набора.
 */
object WordDataEnglishCityLifeL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 365, languagePair = "en-ru", orderIndex = 365,
            name = "Городская жизнь и услуги",
            description = "Базовая лексика: банк, почта, аптека, остановка, простые услуги",
            topic = "Городская жизнь и услуги", level = 1),
    )

    val words: List<WordEntity> = listOf(

        // ═══════════════════════════════════════════════════════════════════
        // Set 365 — L1, COMMON + UNCOMMON
        // ═══════════════════════════════════════════════════════════════════

        // ── city_basic_places (5) ─────────────────────────────────────────

        WordEntity(id = 36501, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "bank", transliteration = "[bæŋk]", translation = "банк",
            definition = "A building where people keep their money safely and take some out.",
            definitionNative = "Здание, куда люди приносят деньги, чтобы хранить, и где их потом снимают.",
            example = "She walked into the bank to deposit her first paycheck.",
            exampleNative = "Она зашла в bank, чтобы положить свою первую зарплату.",
            pos = "noun", semanticGroup = "city_basic_places", isFillInBlankSafe = false),

        WordEntity(id = 36502, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "post office", transliteration = "[poʊst ˈɔfɪs]", translation = "почта",
            definition = "A place where you send letters and parcels to other towns.",
            definitionNative = "Место, откуда отправляют письма и посылки в другие города.",
            example = "He stopped by the post office to send a parcel to his sister.",
            exampleNative = "Он заглянул в post office, чтобы отправить посылку сестре.",
            pos = "noun", semanticGroup = "city_basic_places", isFillInBlankSafe = false),

        WordEntity(id = 36503, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "pharmacy", transliteration = "[ˈfɑrməsi]", translation = "аптека",
            definition = "A shop where you can get medicine and pills if you feel sick.",
            definitionNative = "Магазин, где продают лекарства и таблетки, если человек заболел.",
            example = "There is a small pharmacy on the corner that opens until midnight.",
            exampleNative = "На углу есть маленькая pharmacy, которая работает до полуночи.",
            pos = "noun", semanticGroup = "city_basic_places", isFillInBlankSafe = false),

        WordEntity(id = 36504, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "supermarket", transliteration = "[ˈsupərˌmɑrkɪt]", translation = "супермаркет",
            definition = "A big self-service shop with food, drinks and household goods.",
            definitionNative = "Большой магазин самообслуживания с едой, напитками и бытовыми товарами.",
            example = "We do our weekly shopping at the supermarket every Saturday morning.",
            exampleNative = "Каждое субботнее утро мы делаем недельные закупки в supermarket.",
            pos = "noun", semanticGroup = "city_basic_places", isFillInBlankSafe = false),

        WordEntity(id = 36505, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "library", transliteration = "[ˈlaɪˌbrɛri]", translation = "библиотека",
            definition = "A quiet place where you borrow books for free and read at tables.",
            definitionNative = "Тихое место, где бесплатно берут книги и читают за столами.",
            example = "The children spent the rainy afternoon reading at the public library.",
            exampleNative = "Дети провели дождливый день за чтением в городской library.",
            pos = "noun", semanticGroup = "city_basic_places", isFillInBlankSafe = false),

        // ── city_basic_streets (5) ────────────────────────────────────────

        WordEntity(id = 36506, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "street", transliteration = "[strit]", translation = "улица",
            definition = "A long path between buildings where cars drive and people walk.",
            definitionNative = "Длинная полоса между домами, где едут машины и идут люди.",
            example = "Their flat is on a quiet street with old chestnut trees.",
            exampleNative = "Их квартира на тихой street со старыми каштанами.",
            pos = "noun", semanticGroup = "city_basic_streets", isFillInBlankSafe = false),

        WordEntity(id = 36507, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "sidewalk", transliteration = "[ˈsaɪdˌwɔk]", translation = "тротуар",
            definition = "The narrow paved strip beside the road where people walk.",
            definitionNative = "Узкая мощёная полоса вдоль дороги, по которой ходят пешеходы.",
            example = "She tripped on a loose tile on the sidewalk near the cafe.",
            exampleNative = "Она споткнулась о шатающуюся плитку на sidewalk у кафе.",
            pos = "noun", semanticGroup = "city_basic_streets", isFillInBlankSafe = false),

        WordEntity(id = 36508, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "traffic light", transliteration = "[ˈtræfɪk laɪt]", translation = "светофор",
            definition = "A box with red, yellow and green lamps that tells cars when to go.",
            definitionNative = "Коробка с красной, жёлтой и зелёной лампами — она говорит машинам, когда ехать.",
            example = "Turn left at the second traffic light and you will see the post office.",
            exampleNative = "На втором traffic light поверни налево, и увидишь почту.",
            pos = "noun", semanticGroup = "city_basic_streets", isFillInBlankSafe = false),

        WordEntity(id = 36509, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "bus stop", transliteration = "[bəs stɑp]", translation = "автобусная остановка",
            definition = "A small spot on the street where buses pick up passengers.",
            definitionNative = "Небольшое место на улице, где автобусы забирают пассажиров.",
            example = "An old man was reading a newspaper at the bus stop.",
            exampleNative = "Пожилой мужчина читал газету на bus stop.",
            pos = "noun", semanticGroup = "city_basic_streets", isFillInBlankSafe = false),

        WordEntity(id = 36510, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "crosswalk", transliteration = "[ˈkrɔsˌwɔk]", translation = "пешеходный переход",
            definition = "White stripes on the road where people walk safely from one side to the other.",
            definitionNative = "Белые полосы на дороге, по которым безопасно идут с одной стороны на другую.",
            example = "The kids waited at the crosswalk until the green man appeared.",
            exampleNative = "Дети ждали на crosswalk, пока появится зелёный человечек.",
            pos = "noun", semanticGroup = "city_basic_streets", isFillInBlankSafe = false),

        // ── city_basic_services (5) ───────────────────────────────────────

        WordEntity(id = 36511, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "clerk", transliteration = "[klɜrk]", translation = "служащий (за стойкой)",
            definition = "A person sitting behind a counter who helps you with documents.",
            definitionNative = "Человек за стойкой, который помогает оформить документы или ответить на вопрос.",
            example = "The friendly clerk explained how to fill out the paper form.",
            exampleNative = "Любезный clerk объяснил, как заполнить бумажную форму.",
            pos = "noun", semanticGroup = "city_basic_services", isFillInBlankSafe = false),

        WordEntity(id = 36512, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "complaint", transliteration = "[kəmˈpleɪnt]", translation = "жалоба",
            definition = "What you say or write when something was bad and you want it fixed.",
            definitionNative = "То, что говорят или пишут, когда что-то было плохо и нужно это исправить.",
            example = "She filed a polite complaint about the broken elevator in the building.",
            exampleNative = "Она подала вежливый complaint про сломанный лифт в здании.",
            pos = "noun", semanticGroup = "city_basic_services", isFillInBlankSafe = false),

        WordEntity(id = 36513, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "opening hours", transliteration = "[ˈoʊpənɪŋ ˈaʊrz]", translation = "часы работы",
            definition = "The times during the day when a place lets visitors come in.",
            definitionNative = "Время в течение дня, когда заведение пускает посетителей.",
            example = "Check the opening hours before you walk all the way there.",
            exampleNative = "Проверь opening hours, прежде чем тащиться туда пешком.",
            pos = "noun", semanticGroup = "city_basic_services", isFillInBlankSafe = false),

        WordEntity(id = 36514, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "business card", transliteration = "[ˈbɪznəs kɑrd]", translation = "визитная карточка",
            definition = "A small paper rectangle with someone's name and phone number on it.",
            definitionNative = "Небольшой бумажный прямоугольник с именем и телефоном человека.",
            example = "He pulled a business card from his wallet and handed it over.",
            exampleNative = "Он достал business card из кошелька и передал её.",
            pos = "noun", semanticGroup = "city_basic_services", isFillInBlankSafe = false),

        WordEntity(id = 36515, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "appointment", transliteration = "[əˈpɔɪntmənt]", translation = "приём (по записи)",
            definition = "A fixed time when a doctor or office agrees to meet with you.",
            definitionNative = "Назначенное время, когда врач или контора готовы тебя принять.",
            example = "I have an appointment with the dentist tomorrow at three.",
            exampleNative = "У меня appointment у стоматолога завтра в три.",
            pos = "noun", semanticGroup = "city_basic_services", isFillInBlankSafe = false),

        // ── city_basic_navigate (5) ───────────────────────────────────────

        WordEntity(id = 36516, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "address", transliteration = "[ˈæˌdrɛs]", translation = "адрес",
            definition = "The name of the street and house number where someone lives.",
            definitionNative = "Название улицы и номер дома, где кто-то живёт.",
            example = "Please write your home address on the back of the form.",
            exampleNative = "Напиши, пожалуйста, свой домашний address на обратной стороне бланка.",
            pos = "noun", semanticGroup = "city_basic_navigate", isFillInBlankSafe = false),

        WordEntity(id = 36517, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "sign", transliteration = "[saɪn]", translation = "вывеска / знак",
            definition = "A board with letters or pictures that tells you what a place is.",
            definitionNative = "Табличка с буквами или картинками, которая сообщает, что это за место.",
            example = "A bright sign above the door said the cafe was open.",
            exampleNative = "Яркий sign над дверью сообщал, что кафе открыто.",
            pos = "noun", semanticGroup = "city_basic_navigate", isFillInBlankSafe = false),

        WordEntity(id = 36518, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "map", transliteration = "[mæp]", translation = "карта (города)",
            definition = "A flat drawing of streets that helps you find the way somewhere.",
            definitionNative = "Плоский рисунок улиц, по которому находят дорогу куда-то.",
            example = "She unfolded a paper map of the old town to find the museum.",
            exampleNative = "Она развернула бумажный map старого города, чтобы найти музей.",
            pos = "noun", semanticGroup = "city_basic_navigate", isFillInBlankSafe = false),

        WordEntity(id = 36519, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "direction", transliteration = "[dəˈrɛkʃən]", translation = "направление",
            definition = "The way you should go — left, right, up, down or which side.",
            definitionNative = "Сторона, куда нужно идти — налево, направо, вверх, вниз.",
            example = "She asked a stranger for the direction to the train station.",
            exampleNative = "Она спросила у прохожего direction до вокзала.",
            pos = "noun", semanticGroup = "city_basic_navigate", isFillInBlankSafe = false),

        WordEntity(id = 36520, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "corner", transliteration = "[ˈkɔrnər]", translation = "угол (улицы)",
            definition = "The point where two streets meet and you can turn either way.",
            definitionNative = "Точка, где встречаются две улицы и можно повернуть в одну из сторон.",
            example = "The bakery is right on the corner of Park and Maple Street.",
            exampleNative = "Пекарня прямо на corner Парк и Кленовой улицы.",
            pos = "noun", semanticGroup = "city_basic_navigate", isFillInBlankSafe = false),

        // ── city_basic_actions (5) ────────────────────────────────────────

        WordEntity(id = 36521, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "pay", transliteration = "[peɪ]", translation = "платить",
            definition = "To give money in exchange for a thing or a service.",
            definitionNative = "Отдать деньги в обмен на вещь или услугу.",
            example = "You can pay at the counter near the front door.",
            exampleNative = "Можно pay у стойки возле входной двери.",
            pos = "verb", semanticGroup = "city_basic_actions", isFillInBlankSafe = false),

        WordEntity(id = 36522, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "ask", transliteration = "[æsk]", translation = "спрашивать, просить",
            definition = "To say words to someone because you want an answer or some help.",
            definitionNative = "Сказать кому-то слова, чтобы получить ответ или какую-то помощь.",
            example = "If you are lost, ask a kind stranger for directions.",
            exampleNative = "Если ты заблудился, ask у доброго прохожего, куда идти.",
            pos = "verb", semanticGroup = "city_basic_actions", isFillInBlankSafe = false),

        WordEntity(id = 36523, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "wait", transliteration = "[weɪt]", translation = "ждать",
            definition = "To stay in one place until something happens or someone comes.",
            definitionNative = "Оставаться на одном месте, пока что-то не случится или кто-то не придёт.",
            example = "Please wait here while I check if the doctor is free.",
            exampleNative = "Пожалуйста, wait здесь, пока я узнаю, свободен ли врач.",
            pos = "verb", semanticGroup = "city_basic_actions", isFillInBlankSafe = false),

        WordEntity(id = 36524, setId = 365, languagePair = "en-ru", rarity = "COMMON",
            original = "find", transliteration = "[faɪnd]", translation = "найти",
            definition = "To see or get something you were looking for.",
            definitionNative = "Увидеть или получить то, что искал.",
            example = "It took us an hour to find the small museum on the back street.",
            exampleNative = "Мы целый час пытались find маленький музей на заднем переулке.",
            pos = "verb", semanticGroup = "city_basic_actions", isFillInBlankSafe = false),

        WordEntity(id = 36525, setId = 365, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "enter", transliteration = "[ˈɛntər]", translation = "входить (в здание)",
            definition = "To walk inside a building, room or other closed place.",
            definitionNative = "Пройти внутрь здания, комнаты или другого закрытого места.",
            example = "Visitors must enter the museum through the main glass doors.",
            exampleNative = "Посетители должны enter в музей через главные стеклянные двери.",
            pos = "verb", semanticGroup = "city_basic_actions", isFillInBlankSafe = false),
    )
}
