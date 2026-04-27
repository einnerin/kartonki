package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Праздники и традиции (L2, UNCOMMON+RARE).
 *
 * Set 371: «Праздники и традиции» — продвинутый базовый.
 *          Украшения, поздравительные открытки, ритуалы и церемонии,
 *          подготовка мероприятия, праздничная еда.
 *
 * Слова не пересекаются с темами «Развлечения и досуг» (en-ru: 351, 352, 353)
 * и «Еда и кулинария» (en-ru: 10, 11, 12). Параллельно создаётся L1 (set 370,
 * topic = "Праздники и традиции"); из этого набора слова сюда не дублируются.
 *
 * Cross-topic совпадения с «Культура и искусство» (set 202: invitation,
 * anniversary, banner, centrepiece; set 242: garland, ceremony, ritual)
 * допустимы — это разные темы и semanticGroup-префиксы (`celebrations`
 * vs. `holidays_*`).
 *
 * Распределение редкости: 13 UNCOMMON + 12 RARE.
 *
 * SemanticGroups (5 × 5):
 *   holidays_decoration   — decoration, garland, banner, fairy lights, centerpiece
 *   holidays_cards        — greeting card, postcard, e-card, signature, message
 *   holidays_ceremony     — ceremony, ritual, vow, anniversary, milestone
 *   holidays_preparation  — guest list, invitation, RSVP, venue, catering
 *   holidays_festive_food — feast, holiday meal, dessert, leftovers, potluck
 *
 * Word IDs: setId × 100 + position (37101..37125).
 *
 * isFillInBlankSafe = false на всех словах (требование ТЗ).
 * fillInBlankExclusions пустые — заполнятся через FILL_IN_BLANK pipeline.
 */
object WordDataEnglishHolidaysL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 371,
            languagePair = "en-ru",
            orderIndex = 371,
            name = "Праздники и традиции",
            description = "Продвинутый базовый: украшения, открытки, церемонии, подготовка",
            topic = "Праздники и традиции",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 371 — Праздники и традиции: продвинутый (L2, UNCOMMON+RARE)  ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── holidays_decoration (5) ───────────────────────────────────────

        WordEntity(id = 37101, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "decoration", transliteration = "[ˌdɛkəˈreɪʃən]", translation = "украшение (для праздника)",
            definition = "A pretty thing you put up to make a place look festive.",
            definitionNative = "Красивая вещь, которую вешают, чтобы место выглядело празднично.",
            example = "She hung a paper decoration on every door before the party.",
            exampleNative = "Она повесила бумажную decoration на каждую дверь перед вечеринкой.",
            pos = "noun", semanticGroup = "holidays_decoration", fillInBlankExclusions = listOf(37102L, 37103L, 37104L, 37105L)),

        WordEntity(id = 37102, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "garland", transliteration = "[ˈgɑrlənd]", translation = "гирлянда (из листьев или цветов)",
            definition = "A long string of leaves, flowers or paper hung as ornament.",
            definitionNative = "Длинная нить из листьев, цветов или бумаги, которую вешают для украшения.",
            example = "We draped a green garland along the staircase for Christmas.",
            exampleNative = "Мы повесили зелёную garland вдоль лестницы на Рождество.",
            pos = "noun", semanticGroup = "holidays_decoration", fillInBlankExclusions = listOf(37101L, 37103L, 37104L, 37105L)),

        WordEntity(id = 37103, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "banner", transliteration = "[ˈbænər]", translation = "транспарант / праздничная растяжка",
            definition = "A long piece of cloth or paper with words, hung above guests.",
            definitionNative = "Длинный кусок ткани или бумаги с надписью, который вешают над гостями.",
            example = "A bright banner above the table read \"Happy Birthday, Mom\".",
            exampleNative = "Яркий banner над столом гласил «С днём рождения, мама».",
            pos = "noun", semanticGroup = "holidays_decoration", fillInBlankExclusions = listOf(37101L, 37102L, 37104L, 37105L, 37106L, 37110L)),

        WordEntity(id = 37104, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "fairy lights", transliteration = "[ˈfɛri laɪts]", translation = "светодиодная гирлянда (огоньки)",
            definition = "Tiny bulbs on a thin wire, used to add a warm glow indoors.",
            definitionNative = "Крошечные лампочки на тонком проводе, дающие тёплый свет в комнате.",
            example = "We wrapped fairy lights around the window for a cozy evening.",
            exampleNative = "Мы обмотали fairy lights вокруг окна для уютного вечера.",
            pos = "noun", semanticGroup = "holidays_decoration", fillInBlankExclusions = listOf(37101L, 37102L, 37103L, 37105L)),

        WordEntity(id = 37105, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "centerpiece", transliteration = "[ˈsɛntərˌpis]", translation = "центральное украшение стола",
            definition = "The main decorative item placed in the middle of a dinner table.",
            definitionNative = "Главный декоративный предмет, который ставят в центр обеденного стола.",
            example = "A bowl of red roses served as the centerpiece for the wedding dinner.",
            exampleNative = "Чаша с красными розами стала centerpiece свадебного ужина.",
            pos = "noun", semanticGroup = "holidays_decoration", fillInBlankExclusions = listOf(37101L, 37102L, 37103L, 37104L)),

        // ── holidays_cards (5) ────────────────────────────────────────────

        WordEntity(id = 37106, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "greeting card", transliteration = "[ˈgritɪŋ kɑrd]", translation = "поздравительная открытка",
            definition = "A folded paper with kind words sent to mark a special day.",
            definitionNative = "Сложенная бумажка с тёплыми словами, которую дарят на особый день.",
            example = "I bought a funny greeting card for grandma's eightieth birthday.",
            exampleNative = "Я купил смешную greeting card на восьмидесятилетие бабушки.",
            pos = "noun", semanticGroup = "holidays_cards", fillInBlankExclusions = listOf(37107L, 37108L, 37109L, 37110L)),

        WordEntity(id = 37107, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "postcard", transliteration = "[ˈpoʊstˌkɑrd]", translation = "почтовая открытка",
            definition = "A small flat card with a picture, sent through the mail without an envelope.",
            definitionNative = "Маленькая плоская карточка с картинкой — её шлют почтой без конверта.",
            example = "She sent me a postcard from Paris with the Eiffel Tower on it.",
            exampleNative = "Она прислала мне postcard из Парижа с Эйфелевой башней.",
            pos = "noun", semanticGroup = "holidays_cards", fillInBlankExclusions = listOf(37106L, 37109L, 37110L)),

        WordEntity(id = 37108, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "e-card", transliteration = "[ˈi kɑrd]", translation = "электронная открытка",
            definition = "A digital greeting sent by email, often with music or a moving picture.",
            definitionNative = "Цифровое поздравление по почте, часто с музыкой или анимацией.",
            example = "Mom got an e-card from her old colleague on her name day.",
            exampleNative = "Мама получила e-card от старой коллеги на именины.",
            pos = "noun", semanticGroup = "holidays_cards", fillInBlankExclusions = listOf(37117L)),

        WordEntity(id = 37109, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "signature", transliteration = "[ˈsɪgnəʧər]", translation = "подпись (от руки)",
            definition = "Your name written by hand at the end of a note or document.",
            definitionNative = "Имя, написанное от руки в конце записки или документа.",
            example = "Every guest left a warm signature inside the wedding album.",
            exampleNative = "Каждый гость оставил тёплую signature в свадебном альбоме.",
            pos = "noun", semanticGroup = "holidays_cards", fillInBlankExclusions = listOf(37106L, 37107L, 37108L, 37110L)),

        WordEntity(id = 37110, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "message", transliteration = "[ˈmɛsɪʤ]", translation = "поздравительное сообщение",
            definition = "A short written or spoken note sent to wish someone well.",
            definitionNative = "Короткая записка или речь с добрыми пожеланиями для кого-то.",
            example = "Dad wrote a heartfelt message inside my graduation card.",
            exampleNative = "Папа написал тёплый message в моей выпускной открытке.",
            pos = "noun", semanticGroup = "holidays_cards", fillInBlankExclusions = listOf(37106L, 37107L, 37108L, 37109L)),

        // ── holidays_ceremony (5) ─────────────────────────────────────────

        WordEntity(id = 37111, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "ceremony", transliteration = "[ˈsɛrəˌmoʊni]", translation = "церемония",
            definition = "A formal event with set steps that mark something important.",
            definitionNative = "Официальное событие с заданным порядком, отмечающее важный момент.",
            example = "The wedding ceremony took place under an old oak tree.",
            exampleNative = "Свадебная ceremony прошла под старым дубом.",
            pos = "noun", semanticGroup = "holidays_ceremony", fillInBlankExclusions = listOf(37112L, 37113L, 37114L, 37115L)),

        WordEntity(id = 37112, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "ritual", transliteration = "[ˈrɪʧuəl]", translation = "обряд / ритуал",
            definition = "A set of actions repeated the same way at every special event.",
            definitionNative = "Набор действий, повторяемых одинаково на каждом особом событии.",
            example = "Lighting the first candle is a family ritual on every holiday.",
            exampleNative = "Зажечь первую свечу — семейный ritual на каждый праздник.",
            pos = "noun", semanticGroup = "holidays_ceremony", fillInBlankExclusions = listOf(37111L, 37113L, 37114L, 37115L)),

        WordEntity(id = 37113, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "vow", transliteration = "[vaʊ]", translation = "клятва (на церемонии)",
            definition = "A serious promise spoken aloud, often during a wedding.",
            definitionNative = "Серьёзное обещание, произносимое вслух, часто на свадьбе.",
            example = "The bride read her vow with tears in her eyes.",
            exampleNative = "Невеста читала свою vow со слезами на глазах.",
            pos = "noun", semanticGroup = "holidays_ceremony", fillInBlankExclusions = listOf(37110L, 37111L, 37112L, 37114L, 37115L)),

        WordEntity(id = 37114, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "anniversary", transliteration = "[ˌænəˈvərsəri]", translation = "годовщина",
            definition = "The same date each year that marks a past event in your life.",
            definitionNative = "Та же дата каждый год, отмечающая прошедшее событие в твоей жизни.",
            example = "My parents went to a small restaurant on their tenth anniversary.",
            exampleNative = "Родители сходили в небольшой ресторан на свою десятую anniversary.",
            pos = "noun", semanticGroup = "holidays_ceremony", fillInBlankExclusions = listOf(37111L, 37112L, 37113L, 37115L)),

        WordEntity(id = 37115, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "milestone", transliteration = "[ˈmaɪlˌstoʊn]", translation = "важная веха в жизни",
            definition = "A big point in life worth celebrating — like turning eighteen or fifty.",
            definitionNative = "Крупная точка в жизни, достойная праздника — например, восемнадцать или пятьдесят.",
            example = "Her fiftieth birthday felt like a real milestone for the whole family.",
            exampleNative = "Её пятидесятилетие стало настоящим milestone для всей семьи.",
            pos = "noun", semanticGroup = "holidays_ceremony", fillInBlankExclusions = listOf(37111L, 37112L, 37113L, 37114L)),

        // ── holidays_preparation (5) ──────────────────────────────────────

        WordEntity(id = 37116, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "guest list", transliteration = "[gɛst lɪst]", translation = "список приглашённых",
            definition = "A written list of people you plan to invite to your event.",
            definitionNative = "Письменный перечень людей, которых ты планируешь позвать на мероприятие.",
            example = "We finished the guest list two months before the wedding.",
            exampleNative = "Мы закончили guest list за два месяца до свадьбы.",
            pos = "noun", semanticGroup = "holidays_preparation", fillInBlankExclusions = listOf(37117L, 37118L, 37119L, 37120L)),

        WordEntity(id = 37117, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "invitation", transliteration = "[ˌɪnvɪˈteɪʃən]", translation = "приглашение (на мероприятие)",
            definition = "A polite written or spoken request asking someone to come.",
            definitionNative = "Вежливая письменная или устная просьба прийти на событие.",
            example = "I received an invitation to my cousin's housewarming next Sunday.",
            exampleNative = "Я получил invitation на новоселье к двоюродному брату в воскресенье.",
            pos = "noun", semanticGroup = "holidays_preparation", fillInBlankExclusions = listOf(37108L)),

        WordEntity(id = 37118, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "RSVP", transliteration = "[ˌɑr ɛs vi ˈpi]", translation = "просьба подтвердить присутствие",
            definition = "A short reply asking guests to say if they will come or not.",
            definitionNative = "Короткий запрос, просящий гостей сообщить, придут они или нет.",
            example = "Please send your RSVP by next Friday so we can plan seating.",
            exampleNative = "Пришлите свой RSVP до следующей пятницы, чтобы мы спланировали места.",
            pos = "noun", semanticGroup = "holidays_preparation", fillInBlankExclusions = listOf(37108L, 37110L, 37116L, 37117L, 37119L, 37120L)),

        WordEntity(id = 37119, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "venue", transliteration = "[ˈvɛnju]", translation = "место проведения",
            definition = "The hall, garden or building where an event takes place.",
            definitionNative = "Зал, сад или здание, где проходит мероприятие.",
            example = "We booked a small garden venue for the engagement party.",
            exampleNative = "Мы забронировали небольшое садовое venue для помолвки.",
            pos = "noun", semanticGroup = "holidays_preparation", fillInBlankExclusions = listOf(37116L, 37117L, 37118L, 37120L)),

        WordEntity(id = 37120, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "catering", transliteration = "[ˈkeɪtərɪŋ]", translation = "выездное обслуживание (еда на праздник)",
            definition = "A service that brings cooked food and waiters to your event.",
            definitionNative = "Услуга, привозящая готовую еду и официантов на твоё мероприятие.",
            example = "We hired a small family company for the catering at the reception.",
            exampleNative = "Мы наняли небольшую семейную фирму для catering на банкете.",
            pos = "noun", semanticGroup = "holidays_preparation", fillInBlankExclusions = listOf(37111L, 37116L, 37117L, 37118L, 37119L, 37121L, 37122L)),

        // ── holidays_festive_food (5) ─────────────────────────────────────

        WordEntity(id = 37121, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "feast", transliteration = "[fist]", translation = "пир / обильное застолье",
            definition = "A big special meal with lots of food shared by many people.",
            definitionNative = "Большое особое застолье с обилием еды, которое разделяют многие.",
            example = "Grandma cooked a real feast for the whole family on New Year's Eve.",
            exampleNative = "Бабушка приготовила настоящий feast для всей семьи в новогодний вечер.",
            pos = "noun", semanticGroup = "holidays_festive_food", fillInBlankExclusions = listOf(37122L, 37123L, 37124L, 37125L)),

        WordEntity(id = 37122, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "holiday meal", transliteration = "[ˈhɑləˌdeɪ mil]", translation = "праздничная трапеза",
            definition = "A special set of dishes cooked once a year for a particular feast day.",
            definitionNative = "Особый набор блюд, который готовят раз в год к конкретному празднику.",
            example = "Roast turkey is the classic holiday meal in many American homes.",
            exampleNative = "Жареная индейка — классический holiday meal во многих американских семьях.",
            pos = "noun", semanticGroup = "holidays_festive_food", fillInBlankExclusions = listOf(37121L, 37123L, 37124L, 37125L)),

        WordEntity(id = 37123, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "confection", transliteration = "[kənˈfɛkʃən]", translation = "кондитерское изделие",
            definition = "A small sweet treat made by a baker — like a chocolate, candy or fancy pastry.",
            definitionNative = "Маленькое сладкое лакомство от кондитера — шоколадка, конфета или пирожное.",
            example = "She placed a tiny pink confection on every guest's plate at the wedding.",
            exampleNative = "Она положила крошечный розовый confection на каждую гостевую тарелку.",
            pos = "noun", semanticGroup = "holidays_festive_food", fillInBlankExclusions = listOf(37105L, 37121L, 37122L, 37124L, 37125L)),

        WordEntity(id = 37124, setId = 371, languagePair = "en-ru", rarity = "RARE",
            original = "leftovers", transliteration = "[ˈlɛftˌoʊvərz]", translation = "остатки еды (с праздника)",
            definition = "Food that stays on the table after everyone has finished eating.",
            definitionNative = "Еда, которая остаётся на столе после того, как все доели.",
            example = "We packed the leftovers into small boxes for our guests to take home.",
            exampleNative = "Мы разложили leftovers по контейнерам, чтобы гости забрали домой.",
            pos = "noun", semanticGroup = "holidays_festive_food", fillInBlankExclusions = listOf(37121L, 37122L, 37123L, 37125L)),

        WordEntity(id = 37125, setId = 371, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "potluck", transliteration = "[ˈpɑtˌlək]", translation = "застолье «кто что принесёт»",
            definition = "A meal where every guest brings one dish to share with the others.",
            definitionNative = "Застолье, на которое каждый гость приносит одно блюдо, чтобы разделить с другими.",
            example = "Our office held a potluck on Friday and everyone brought a dish.",
            exampleNative = "В офисе устроили potluck в пятницу, и каждый принёс блюдо.",
            pos = "noun", semanticGroup = "holidays_festive_food", fillInBlankExclusions = listOf(37111L, 37121L, 37122L, 37123L, 37124L)),
    )
}
