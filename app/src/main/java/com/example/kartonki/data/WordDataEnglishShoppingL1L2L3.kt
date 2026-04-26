package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Шоппинг и покупки (новая тема, levels 1–3).
 *
 * Sets:
 *   - 348 (L1, COMMON+UNCOMMON) — базовая лексика магазинов и оплаты.
 *   - 349 (L2, UNCOMMON+RARE)   — продвинутая: бренды, скидки, гарантии, онлайн-заказы.
 *   - 350 (L3, RARE+EPIC)       — углублённая: маркетинг, лояльность, поведенческая
 *                                  экономика покупок.
 *
 * Тема «Шоппинг и покупки» новая — same-topic дублей быть не может. Кросс-топиковые
 * пересечения с темой «Дом и быт» (sets 16/200/240) допустимы по политике 2026-04-20.
 *
 * SemanticGroups (5 × 5 × 3):
 *   348 shopping_places, shopping_money, shopping_items, shopping_offers,
 *       shopping_people_actions
 *   349 shopping_offers_l2, shopping_logistics, shopping_returns,
 *       shopping_packaging, shopping_retail
 *   350 shopping_marketing, shopping_behavior, shopping_pricing,
 *       shopping_subscription, shopping_strategy
 *
 * Word IDs: setId * 100 + position (34801..34825, 34901..34925, 35001..35025).
 */
object WordDataEnglishShoppingL1L2L3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 348, name = "Шоппинг и покупки",
            description = "Базовая лексика про магазины, покупки и оплату для повседневных разговоров",
            languagePair = "en-ru",
            topic = "Шоппинг и покупки", level = 1),
        WordSetEntity(
            id = 349, name = "Шоппинг и покупки",
            description = "Продвинутая лексика шоппинга: бренды, скидки, гарантии, онлайн-заказы",
            languagePair = "en-ru",
            topic = "Шоппинг и покупки", level = 2),
        WordSetEntity(
            id = 350, name = "Шоппинг и покупки",
            description = "Углублённая лексика потребления: маркетинг, лояльность, поведенческая экономика покупок",
            languagePair = "en-ru",
            topic = "Шоппинг и покупки", level = 3),
    )

    val words: List<WordEntity> = listOf(

        // ═══════════════════════════════════════════════════════════════════
        // Set 348 — L1, COMMON + UNCOMMON
        // ═══════════════════════════════════════════════════════════════════

        // ── shopping_places (5) ───────────────────────────────────────────

        WordEntity(id = 34801, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "shop", transliteration = "[ʃɑp]", translation = "магазин (небольшой)",
            definition = "A small place where people pay for things they want to take home.",
            definitionNative = "Небольшое место, где люди платят за вещи, которые хотят забрать домой.",
            example = "There is a tiny corner shop just across the street from my house.",
            exampleNative = "Прямо напротив моего дома есть маленький угловой shop.",
            pos = "noun", semanticGroup = "shopping_places", fillInBlankExclusions = listOf(34802L, 34803L, 34804L, 34805L)),

        WordEntity(id = 34802, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "store", transliteration = "[stɔr]", translation = "магазин (крупный)",
            definition = "A large place that sells many kinds of goods on big shelves.",
            definitionNative = "Большое место, где на крупных полках продаётся много разных товаров.",
            example = "She works at a huge store that sells almost everything.",
            exampleNative = "Она работает в огромном store, где продаётся почти всё.",
            pos = "noun", semanticGroup = "shopping_places", fillInBlankExclusions = listOf(34801L, 34803L, 34804L, 34805L)),

        WordEntity(id = 34803, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mall", transliteration = "[mɔl]", translation = "торговый центр",
            definition = "A huge building with many small stores joined by indoor walkways.",
            definitionNative = "Огромное здание, где много небольших магазинов соединено крытыми проходами.",
            example = "We met our friends near the fountain inside the mall.",
            exampleNative = "Мы встретились с друзьями у фонтана внутри mall.",
            pos = "noun", semanticGroup = "shopping_places", fillInBlankExclusions = listOf(34801L, 34802L, 34804L, 34805L)),

        WordEntity(id = 34804, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "market", transliteration = "[ˈmɑrkɪt]", translation = "рынок",
            definition = "An open place outside where many sellers offer fresh food and goods.",
            definitionNative = "Открытое место на улице, где много продавцов предлагают свежую еду и товары.",
            example = "Every Sunday morning we visit the local market for fresh fruit.",
            exampleNative = "Каждое воскресенье утром мы ходим на местный market за свежими фруктами.",
            pos = "noun", semanticGroup = "shopping_places", fillInBlankExclusions = listOf(34801L, 34802L, 34803L, 34805L)),

        WordEntity(id = 34805, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "queue", transliteration = "[kju]", translation = "очередь",
            definition = "A line of people waiting one behind the other for their turn.",
            definitionNative = "Ряд людей, ждущих один за другим, чтобы попасть к окошку.",
            example = "We stood in a long queue outside the new bakery on Main Street.",
            exampleNative = "Мы стояли в длинной queue у новой пекарни на главной улице.",
            pos = "noun", semanticGroup = "shopping_places", fillInBlankExclusions = listOf(34801L, 34802L, 34803L, 34804L)),

        // ── shopping_money (5) ────────────────────────────────────────────

        WordEntity(id = 34806, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "price", transliteration = "[praɪs]", translation = "цена",
            definition = "The number of dollars or rubles you must give to get something.",
            definitionNative = "Сколько долларов или рублей нужно отдать, чтобы получить вещь.",
            example = "The price on this jacket is too high for my small budget.",
            exampleNative = "Price на этой куртке слишком высокая для моего маленького бюджета.",
            pos = "noun", semanticGroup = "shopping_money", fillInBlankExclusions = listOf(34807L, 34808L, 34809L, 34810L)),

        WordEntity(id = 34807, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "money", transliteration = "[ˈməni]", translation = "деньги",
            definition = "Coins and paper notes that people give and take when they buy things.",
            definitionNative = "Монеты и бумажные купюры, которыми люди обмениваются, когда что-то покупают.",
            example = "I keep some money for emergencies in a small wooden box.",
            exampleNative = "Я держу немного money на крайний случай в маленькой деревянной коробке.",
            pos = "noun", semanticGroup = "shopping_money", fillInBlankExclusions = listOf(34806L, 34808L, 34809L, 34810L)),

        WordEntity(id = 34808, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "cash", transliteration = "[kæʃ]", translation = "наличные",
            definition = "Real coins and paper notes you carry, not a plastic payment thing.",
            definitionNative = "Настоящие монеты и бумажные купюры, которые носишь с собой, а не пластик.",
            example = "The street vendor only takes cash, no plastic at all.",
            exampleNative = "Уличный продавец берёт только cash, никакого пластика.",
            pos = "noun", semanticGroup = "shopping_money", fillInBlankExclusions = listOf(34806L, 34807L, 34809L, 34810L)),

        WordEntity(id = 34809, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "card", transliteration = "[kɑrd]", translation = "карта (банковская)",
            definition = "A small plastic rectangle from your bank that pays at the till.",
            definitionNative = "Маленький пластиковый прямоугольник из банка, которым платишь у кассы.",
            example = "She tapped her card on the reader and walked out with the bag.",
            exampleNative = "Она приложила card к терминалу и вышла с пакетом.",
            pos = "noun", semanticGroup = "shopping_money", fillInBlankExclusions = listOf(34806L, 34807L, 34808L, 34810L, 34813L)),

        WordEntity(id = 34810, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "change", transliteration = "[ʧeɪnʤ]", translation = "сдача",
            definition = "The smaller money the seller gives back when you hand over too much.",
            definitionNative = "Меньшие деньги, которые продавец возвращает, если ты дал больше нужного.",
            example = "The cashier gave me my change in two crumpled bills and a coin.",
            exampleNative = "Кассир выдал мне change двумя мятыми купюрами и монеткой.",
            pos = "noun", semanticGroup = "shopping_money", fillInBlankExclusions = listOf(34806L, 34807L, 34808L, 34809L)),

        // ── shopping_items (5) ────────────────────────────────────────────

        WordEntity(id = 34811, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "bag", transliteration = "[bæɡ]", translation = "сумка / пакет (для покупок)",
            definition = "A soft container with handles you carry your shopping home in.",
            definitionNative = "Мягкая ёмкость с ручками, в которой несёшь покупки домой.",
            example = "Could you put the bread in a separate bag, please?",
            exampleNative = "Положите, пожалуйста, хлеб в отдельный bag.",
            pos = "noun", semanticGroup = "shopping_items", fillInBlankExclusions = listOf(34812L, 34813L, 34814L, 34815L)),

        WordEntity(id = 34812, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cart", transliteration = "[kɑrt]", translation = "тележка (для покупок)",
            definition = "A wheeled metal basket you push around the supermarket aisles.",
            definitionNative = "Металлическая корзина на колёсиках, которую катают по супермаркету.",
            example = "He filled the cart with juice, bread and a big bag of rice.",
            exampleNative = "Он наполнил cart соком, хлебом и большим пакетом риса.",
            pos = "noun", semanticGroup = "shopping_items", fillInBlankExclusions = listOf(34813L, 34814L, 34815L)),

        WordEntity(id = 34813, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wallet", transliteration = "[ˈwɑlət]", translation = "кошелёк",
            definition = "A small flat folder for paper notes, plastic cards and family photos.",
            definitionNative = "Маленькая плоская папка для купюр, пластиковых карт и семейных фотографий.",
            example = "He left his wallet on the kitchen table by mistake this morning.",
            exampleNative = "Он по ошибке оставил wallet на кухонном столе сегодня утром.",
            pos = "noun", semanticGroup = "shopping_items", fillInBlankExclusions = listOf(34807L, 34808L, 34809L, 34810L, 34811L, 34812L, 34814L, 34815L, 34820L, 34825L)),

        WordEntity(id = 34814, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "receipt", transliteration = "[rɪˈsit]", translation = "чек (документ о покупке)",
            definition = "A small paper slip from the till that lists what you just paid for.",
            definitionNative = "Маленькая бумажка от кассы со списком того, за что ты только что заплатил.",
            example = "Please keep the receipt in case you want to return it later.",
            exampleNative = "Сохрани, пожалуйста, receipt на случай, если захочешь вернуть.",
            pos = "noun", semanticGroup = "shopping_items", fillInBlankExclusions = listOf(34809L, 34810L, 34811L, 34812L, 34813L, 34815L, 34820L, 34825L)),

        WordEntity(id = 34815, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "item", transliteration = "[ˈaɪtəm]", translation = "товар (одна штука)",
            definition = "One single thing among many on a shelf or list.",
            definitionNative = "Одна отдельная вещь среди многих на полке или в списке.",
            example = "There is a small green item missing from your delivery box.",
            exampleNative = "В твоей коробке доставки нет одного маленького зелёного item.",
            pos = "noun", semanticGroup = "shopping_items", fillInBlankExclusions = listOf(34809L, 34811L, 34812L, 34813L, 34814L, 34820L)),

        // ── shopping_offers (5) ───────────────────────────────────────────

        WordEntity(id = 34816, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "cheap", transliteration = "[ʧip]", translation = "дешёвый",
            definition = "Costing only a small amount of money — easy on your pocket.",
            definitionNative = "Стоящий совсем немного денег — не бьёт по кошельку.",
            example = "This little restaurant has very cheap and tasty noodles for lunch.",
            exampleNative = "В этом маленьком ресторане очень cheap и вкусная лапша на обед.",
            pos = "adjective", semanticGroup = "shopping_offers", fillInBlankExclusions = listOf(34817L)),

        WordEntity(id = 34817, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "expensive", transliteration = "[ɪkˈspɛnsɪv]", translation = "дорогой",
            definition = "Costing a lot — you have to think twice before paying for it.",
            definitionNative = "Стоящий много — приходится дважды подумать, прежде чем заплатить.",
            example = "That little necklace was very expensive but she loved it instantly.",
            exampleNative = "То маленькое ожерелье было очень expensive, но ей сразу понравилось.",
            pos = "adjective", semanticGroup = "shopping_offers", fillInBlankExclusions = listOf(34816L)),

        WordEntity(id = 34818, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "sale", transliteration = "[seɪl]", translation = "распродажа",
            definition = "A short period when shops drop their prices to attract more buyers.",
            definitionNative = "Короткое время, когда магазины снижают цены, чтобы привлечь больше людей.",
            example = "I bought these warm boots during a winter sale last year.",
            exampleNative = "Я купил эти тёплые сапоги на зимней sale в прошлом году.",
            pos = "noun", semanticGroup = "shopping_offers", fillInBlankExclusions = listOf(34819L, 34820L)),

        WordEntity(id = 34819, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "deal", transliteration = "[dil]", translation = "выгодная покупка",
            definition = "A purchase where you pay much less than the usual amount asked.",
            definitionNative = "Покупка, где ты платишь намного меньше, чем обычно просят.",
            example = "She got a great deal on a leather jacket last weekend.",
            exampleNative = "На прошлых выходных она поймала отличный deal на кожаную куртку.",
            pos = "noun", semanticGroup = "shopping_offers", fillInBlankExclusions = listOf(34806L, 34818L, 34820L)),

        WordEntity(id = 34820, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "gift", transliteration = "[ɡɪft]", translation = "подарок",
            definition = "Something you choose for another person to make them happy on a special day.",
            definitionNative = "Вещь, которую выбираешь другому человеку, чтобы порадовать в особый день.",
            example = "She wrapped the gift in shiny gold paper with a red ribbon.",
            exampleNative = "Она завернула gift в блестящую золотую бумагу с красной лентой.",
            pos = "noun", semanticGroup = "shopping_offers", fillInBlankExclusions = listOf(34815L, 34818L, 34819L)),

        // ── shopping_people_actions (5) ───────────────────────────────────

        WordEntity(id = 34821, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "buy", transliteration = "[baɪ]", translation = "купить",
            definition = "To get something by paying money for it at a shop or online.",
            definitionNative = "Получить вещь, отдав за неё деньги в магазине или через интернет.",
            example = "I want to buy a new pair of running shoes this weekend.",
            exampleNative = "Я хочу buy новую пару кроссовок на этих выходных.",
            pos = "verb", semanticGroup = "shopping_people_actions", fillInBlankExclusions = listOf(34822L)),

        WordEntity(id = 34822, setId = 348, languagePair = "en-ru", rarity = "COMMON",
            original = "sell", transliteration = "[sɛl]", translation = "продавать",
            definition = "To give something to another person in exchange for their money.",
            definitionNative = "Отдать вещь другому человеку в обмен на его деньги.",
            example = "They sell fresh strawberries on the corner near the old church.",
            exampleNative = "Они sell свежую клубнику на углу возле старой церкви.",
            pos = "verb", semanticGroup = "shopping_people_actions", fillInBlankExclusions = listOf(34821L)),

        WordEntity(id = 34823, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "customer", transliteration = "[ˈkəstəmər]", translation = "покупатель, клиент",
            definition = "A person who walks into a shop to spend money on things.",
            definitionNative = "Человек, который заходит в магазин, чтобы потратить деньги на вещи.",
            example = "A polite customer asked the cashier for a paper bag instead of plastic.",
            exampleNative = "Вежливый customer попросил кассира бумажный пакет, а не пластиковый.",
            pos = "noun", semanticGroup = "shopping_people_actions", fillInBlankExclusions = listOf(34824L, 34825L)),

        WordEntity(id = 34824, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "brand", transliteration = "[brænd]", translation = "марка, бренд",
            definition = "The name and logo a company puts on its goods so people remember.",
            definitionNative = "Имя и логотип фирмы на товаре, чтобы люди их запомнили и узнавали.",
            example = "She refuses to wear any brand she has not heard of before.",
            exampleNative = "Она отказывается носить любой brand, о котором раньше не слышала.",
            pos = "noun", semanticGroup = "shopping_people_actions", fillInBlankExclusions = listOf(34815L, 34823L, 34825L)),

        WordEntity(id = 34825, setId = 348, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "bill", transliteration = "[bɪl]", translation = "счёт (за услугу)",
            definition = "A small paper that tells you how much you must pay for a service.",
            definitionNative = "Маленькая бумажка, где написано, сколько ты должен заплатить за услугу.",
            example = "Could you bring us the bill, please? We are in a hurry.",
            exampleNative = "Принесите нам, пожалуйста, bill. Мы спешим.",
            pos = "noun", semanticGroup = "shopping_people_actions", fillInBlankExclusions = listOf(34810L, 34814L, 34823L, 34824L)),

        // ═══════════════════════════════════════════════════════════════════
        // Set 349 — L2, UNCOMMON + RARE
        // ═══════════════════════════════════════════════════════════════════

        // ── shopping_offers_l2 (5) ────────────────────────────────────────

        WordEntity(id = 34901, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "discount", transliteration = "[ˈdɪskaʊnt]", translation = "скидка",
            definition = "A drop in the asking price, often shown as a percent off.",
            definitionNative = "Снижение запрошенной цены, обычно показанное как процент от стоимости.",
            example = "Members of the loyalty club enjoy a small discount on every purchase.",
            exampleNative = "Члены клуба лояльности получают небольшую discount на каждую покупку.",
            pos = "noun", semanticGroup = "shopping_offers_l2", fillInBlankExclusions = listOf(34902L, 34903L, 34904L, 34911L)),

        WordEntity(id = 34902, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "voucher", transliteration = "[ˈvaʊʧər]", translation = "ваучер, талон",
            definition = "A printed paper or code that you swap for free goods or a price cut.",
            definitionNative = "Бумажка или код, который меняют на бесплатные товары или снижение цены.",
            example = "She used a birthday voucher to get free coffee at the new cafe.",
            exampleNative = "Она использовала именинный voucher, чтобы получить бесплатный кофе в новом кафе.",
            pos = "noun", semanticGroup = "shopping_offers_l2", fillInBlankExclusions = listOf(34901L, 34903L, 34904L)),

        WordEntity(id = 34903, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "bargain", transliteration = "[ˈbɑrɡɪn]", translation = "выгодное приобретение",
            definition = "Something you got for far less money than its true value.",
            definitionNative = "То, что досталось тебе за намного меньшие деньги, чем настоящая стоимость.",
            example = "That used bicycle was a real bargain at only fifty dollars.",
            exampleNative = "Тот подержанный велосипед оказался настоящим bargain всего за пятьдесят долларов.",
            pos = "noun", semanticGroup = "shopping_offers_l2", fillInBlankExclusions = listOf(34901L, 34902L, 34904L)),

        WordEntity(id = 34904, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "outlet", transliteration = "[ˈaʊˌtlɛt]", translation = "аутлет (магазин со скидками)",
            definition = "A shop where last-season clothes from big brands are sold cheaper.",
            definitionNative = "Магазин, где одежду прошлого сезона известных марок продают дешевле.",
            example = "We drove to the outlet on the edge of town for sneakers.",
            exampleNative = "Мы поехали в outlet на окраине города за кроссовками.",
            pos = "noun", semanticGroup = "shopping_offers_l2", fillInBlankExclusions = listOf(34901L, 34902L, 34903L, 34923L)),

        WordEntity(id = 34905, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "vintage", transliteration = "[ˈvɪntɪʤ]", translation = "винтажный (старинный, ценный)",
            definition = "Old but still stylish — usually from a famous decade of the past.",
            definitionNative = "Старый, но по-прежнему модный — обычно из известного десятилетия прошлого.",
            example = "She wore a beautiful vintage dress from the nineteen-sixties.",
            exampleNative = "Она надела красивое vintage платье из шестидесятых годов.",
            pos = "adjective", semanticGroup = "shopping_offers_l2", fillInBlankExclusions = listOf(34920L)),

        // ── shopping_logistics (5) ────────────────────────────────────────

        WordEntity(id = 34906, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "online", transliteration = "[ˈɔnˌlaɪn]", translation = "онлайн (через интернет)",
            definition = "Done through the internet instead of in a real shop or office.",
            definitionNative = "Сделанный через интернет, а не в настоящем магазине или офисе.",
            example = "She buys most of her clothes online to save time.",
            exampleNative = "Большую часть одежды она покупает online, чтобы сэкономить время.",
            pos = "adjective", semanticGroup = "shopping_logistics", fillInBlankExclusions = listOf(34920L, 34922L)),

        WordEntity(id = 34907, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "order", transliteration = "[ˈɔrdər]", translation = "заказ (выбранный набор товаров)",
            definition = "A list of goods a customer asks a shop to send to them.",
            definitionNative = "Список товаров, которые клиент просит магазин ему прислать.",
            example = "Your order will arrive at the door by Friday afternoon.",
            exampleNative = "Ваш order прибудет к двери к вечеру пятницы.",
            pos = "noun", semanticGroup = "shopping_logistics", fillInBlankExclusions = listOf(34902L, 34908L, 34909L, 34910L, 34912L, 34919L)),

        WordEntity(id = 34908, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "delivery", transliteration = "[dɪˈlɪvəri]", translation = "доставка",
            definition = "The act of bringing goods from the seller right to your door.",
            definitionNative = "Привоз товаров от продавца прямо к твоей входной двери.",
            example = "The free delivery option is only available on orders above thirty dollars.",
            exampleNative = "Бесплатная delivery работает только на заказы свыше тридцати долларов.",
            pos = "noun", semanticGroup = "shopping_logistics", fillInBlankExclusions = listOf(34907L, 34909L, 34910L, 34912L, 34913L, 34914L, 34919L)),

        WordEntity(id = 34909, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "shipping", transliteration = "[ˈʃɪpɪŋ]", translation = "отправка, пересылка",
            definition = "Moving goods from a warehouse to a buyer in another city or country.",
            definitionNative = "Перевозка товаров со склада к покупателю в другом городе или стране.",
            example = "International shipping usually takes two extra weeks.",
            exampleNative = "Международная shipping обычно занимает дополнительные две недели.",
            pos = "noun", semanticGroup = "shopping_logistics", fillInBlankExclusions = listOf(34907L, 34908L, 34910L, 34911L, 34912L, 34914L, 34919L)),

        WordEntity(id = 34910, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "parcel", transliteration = "[ˈpɑrsəl]", translation = "посылка",
            definition = "A small box wrapped for the post — full of things sent to one person.",
            definitionNative = "Маленькая коробка, упакованная для почты, с вещами для одного человека.",
            example = "A heavy parcel arrived for me from my grandmother in the village.",
            exampleNative = "Мне пришёл тяжёлый parcel от бабушки из деревни.",
            pos = "noun", semanticGroup = "shopping_logistics", fillInBlankExclusions = listOf(34907L, 34908L, 34909L, 34914L, 34919L)),

        // ── shopping_returns (5) ──────────────────────────────────────────

        WordEntity(id = 34911, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "refund", transliteration = "[ˈriˌfənd]", translation = "возврат (денег)",
            definition = "Money the shop pays you back when you bring an unwanted item.",
            definitionNative = "Деньги, которые магазин отдаёт тебе обратно, если приносишь ненужную вещь.",
            example = "I got a full refund after the shoes broke in only a week.",
            exampleNative = "Мне дали полный refund после того, как ботинки сломались за неделю.",
            pos = "noun", semanticGroup = "shopping_returns", fillInBlankExclusions = listOf(34901L, 34912L, 34913L, 34915L)),

        WordEntity(id = 34912, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "exchange", transliteration = "[ɪksˈʧeɪnʤ]", translation = "обмен (товара)",
            definition = "Swapping a bought item for another size, colour or model from the shop.",
            definitionNative = "Замена купленной вещи на другой размер, цвет или модель в магазине.",
            example = "They allowed an easy exchange because the dress was the wrong size.",
            exampleNative = "Они разрешили лёгкий exchange, потому что платье было не того размера.",
            pos = "noun", semanticGroup = "shopping_returns", fillInBlankExclusions = listOf(34911L, 34913L, 34915L)),

        WordEntity(id = 34913, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "warranty", transliteration = "[ˈwɔrənti]", translation = "гарантия (на товар)",
            definition = "A written promise that the maker will fix the thing if it breaks soon.",
            definitionNative = "Письменное обещание производителя починить вещь, если она быстро сломается.",
            example = "The laptop comes with a two-year warranty against any factory defect.",
            exampleNative = "Ноутбук идёт с двухлетней warranty от любого заводского брака.",
            pos = "noun", semanticGroup = "shopping_returns", fillInBlankExclusions = listOf(34911L, 34912L, 34914L, 34915L)),

        WordEntity(id = 34914, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "return", transliteration = "[rɪˈtərn]", translation = "вернуть (товар в магазин)",
            definition = "To bring an unwanted item back to the shop and get money back.",
            definitionNative = "Принести ненужную вещь обратно в магазин и получить деньги назад.",
            example = "You can return any item within thirty days with the original tag.",
            exampleNative = "Любой товар можно return в течение тридцати дней с оригинальной биркой.",
            pos = "verb", semanticGroup = "shopping_returns", fillInBlankExclusions = listOf(34911L, 34912L)),

        WordEntity(id = 34915, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "checkout", transliteration = "[ˈʧɛˌkaʊt]", translation = "касса / оформление заказа",
            definition = "The desk or web page where you finally pay for everything you chose.",
            definitionNative = "Стол или веб-страница, где ты в итоге платишь за всё выбранное.",
            example = "She added one more item at the checkout before paying.",
            exampleNative = "На checkout она добавила ещё одну позицию перед оплатой.",
            pos = "noun", semanticGroup = "shopping_returns", fillInBlankExclusions = listOf(34904L, 34911L, 34912L, 34913L, 34916L, 34923L)),

        // ── shopping_packaging (5) ────────────────────────────────────────

        WordEntity(id = 34916, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cashier", transliteration = "[kæˈʃɪr]", translation = "кассир",
            definition = "The worker behind the counter who takes your money and prints the slip.",
            definitionNative = "Работник за стойкой, который берёт деньги и распечатывает чек.",
            example = "A young cashier smiled and quickly scanned all the items.",
            exampleNative = "Молодая cashier улыбнулась и быстро отсканировала все товары.",
            pos = "noun", semanticGroup = "shopping_packaging", fillInBlankExclusions = listOf(34917L, 34918L, 34919L)),

        WordEntity(id = 34917, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "label", transliteration = "[ˈleɪbəl]", translation = "ярлык, этикетка",
            definition = "A small tag stuck on goods that shows the name, size or price.",
            definitionNative = "Маленькая бирка на товаре, где написано название, размер или цена.",
            example = "The label on the back of the shirt explains how to wash it.",
            exampleNative = "Label на спине рубашки объясняет, как её стирать.",
            pos = "noun", semanticGroup = "shopping_packaging", fillInBlankExclusions = listOf(34916L, 34918L, 34919L)),

        WordEntity(id = 34918, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "barcode", transliteration = "[ˈbɑrkoʊd]", translation = "штрих-код",
            definition = "Black stripes on a sticker that a scanner reads for the item's price.",
            definitionNative = "Чёрные полоски на наклейке, по которым сканер узнаёт цену товара.",
            example = "The cashier waved every barcode under the red laser at the till.",
            exampleNative = "Кассир провела каждый barcode под красным лучом у кассы.",
            pos = "noun", semanticGroup = "shopping_packaging", fillInBlankExclusions = listOf(34902L, 34910L, 34917L, 34919L)),

        WordEntity(id = 34919, setId = 349, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "package", transliteration = "[ˈpækɪʤ]", translation = "упаковка / коробка с товаром",
            definition = "A wrapped box that protects something from the warehouse to your door.",
            definitionNative = "Завёрнутая коробка, защищающая вещь по пути со склада к твоей двери.",
            example = "She tore open the cardboard package and pulled out a tiny phone.",
            exampleNative = "Она разорвала картонный package и достала крошечный телефон.",
            pos = "noun", semanticGroup = "shopping_packaging", fillInBlankExclusions = listOf(34908L, 34910L, 34916L, 34917L, 34918L)),

        WordEntity(id = 34920, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "second-hand", transliteration = "[ˈsɛkəndˌhænd]", translation = "подержанный, бывший в употреблении",
            definition = "Already owned and used by someone else before being sold again.",
            definitionNative = "Уже принадлежавший и использовавшийся кем-то другим до повторной продажи.",
            example = "He found a great second-hand book in the small charity shop.",
            exampleNative = "Он нашёл отличную second-hand книгу в небольшом благотворительном магазине.",
            pos = "adjective", semanticGroup = "shopping_packaging", fillInBlankExclusions = listOf(34905L)),

        // ── shopping_retail (5) ───────────────────────────────────────────

        WordEntity(id = 34921, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "retail", transliteration = "[ˈriˌteɪl]", translation = "розничная торговля",
            definition = "Selling goods one item at a time to ordinary people, not in bulk.",
            definitionNative = "Продажа товаров по одной штуке обычным людям, не оптом.",
            example = "Many former teachers move into retail because the hours fit family life.",
            exampleNative = "Многие бывшие учителя уходят в retail, потому что часы удобны для семьи.",
            pos = "noun", semanticGroup = "shopping_retail", fillInBlankExclusions = listOf(34908L, 34909L, 34922L, 34923L)),

        WordEntity(id = 34922, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "wholesale", transliteration = "[ˈhoʊlˌseɪl]", translation = "оптовый",
            definition = "Sold in very large amounts to shops, not to single buyers.",
            definitionNative = "Продаваемый в очень больших количествах магазинам, а не одиночным покупателям.",
            example = "He runs a wholesale fruit business near the river port.",
            exampleNative = "Он держит wholesale фруктовый бизнес возле речного порта.",
            pos = "adjective", semanticGroup = "shopping_retail", fillInBlankExclusions = listOf(34921L)),

        WordEntity(id = 34923, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "boutique", transliteration = "[buˈtik]", translation = "бутик (небольшой стильный магазин)",
            definition = "A small fashionable shop with carefully chosen clothes or gifts.",
            definitionNative = "Маленький модный магазин с тщательно подобранной одеждой или подарками.",
            example = "Her aunt owns a tiny boutique on a quiet street in Paris.",
            exampleNative = "Её тётя владеет крохотным boutique на тихой улочке в Париже.",
            pos = "noun", semanticGroup = "shopping_retail", fillInBlankExclusions = listOf(34904L, 34921L)),

        WordEntity(id = 34924, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "browse", transliteration = "[braʊz]", translation = "разглядывать (товары без цели)",
            definition = "To look around a shop or website without planning to buy anything.",
            definitionNative = "Просто осматривать магазин или сайт без намерения что-то покупать.",
            example = "I just wanted to browse for ten minutes before lunch with my friend.",
            exampleNative = "Я просто хотел browse минут десять перед обедом с другом.",
            pos = "verb", semanticGroup = "shopping_retail", fillInBlankExclusions = listOf(34914L, 34925L)),

        WordEntity(id = 34925, setId = 349, languagePair = "en-ru", rarity = "RARE",
            original = "haggle", transliteration = "[ˈhæɡəl]", translation = "торговаться (о цене)",
            definition = "To argue politely with the seller, hoping he will lower the price.",
            definitionNative = "Вежливо спорить с продавцом в надежде, что он снизит цену.",
            example = "Tourists love to haggle in the colourful old market of Marrakesh.",
            exampleNative = "Туристы любят haggle на цветном старом рынке Марракеша.",
            pos = "verb", semanticGroup = "shopping_retail", fillInBlankExclusions = listOf(34924L)),

        // ═══════════════════════════════════════════════════════════════════
        // Set 350 — L3, RARE + EPIC
        // ═══════════════════════════════════════════════════════════════════

        // ── shopping_marketing (5) ────────────────────────────────────────

        WordEntity(id = 35001, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "loyalty", transliteration = "[ˈlɔɪəlti]", translation = "лояльность (приверженность бренду)",
            definition = "A buyer's habit of choosing one brand again and again over the years.",
            definitionNative = "Привычка покупателя выбирать одну марку снова и снова годами.",
            example = "Building real customer loyalty takes far more than a flashy ad campaign.",
            exampleNative = "Построить настоящую loyalty клиентов — гораздо больше, чем яркая рекламная кампания.",
            pos = "noun", semanticGroup = "shopping_marketing", fillInBlankExclusions = listOf(35002L, 35003L)),

        WordEntity(id = 35002, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "retention", transliteration = "[rɪˈtɛnʃən]", translation = "удержание (клиентов)",
            definition = "Keeping the same buyers coming back instead of finding new ones.",
            definitionNative = "Сохранять прежних покупателей возвращающимися, а не искать новых.",
            example = "The marketing team focused on retention rather than chasing fresh leads.",
            exampleNative = "Команда маркетинга сосредоточилась на retention, а не на новых лидах.",
            pos = "noun", semanticGroup = "shopping_marketing", fillInBlankExclusions = listOf(35001L, 35003L)),

        WordEntity(id = 35003, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "conversion", transliteration = "[kənˈvərʒən]", translation = "конверсия (посетителей в покупателей)",
            definition = "The share of visitors who actually pay, out of everyone who looked.",
            definitionNative = "Доля посетителей, которые на самом деле платят, из всех заглянувших.",
            example = "A clearer button at the top doubled the website's conversion overnight.",
            exampleNative = "Более понятная кнопка наверху удвоила conversion сайта за одну ночь.",
            pos = "noun", semanticGroup = "shopping_marketing", fillInBlankExclusions = listOf(35001L, 35002L)),

        WordEntity(id = 35004, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "upsell", transliteration = "[ˈəpˌsɛl]", translation = "апселл (продажа более дорогой версии)",
            definition = "Convincing a buyer to choose a fancier, pricier version of the same thing.",
            definitionNative = "Убедить покупателя выбрать более модную, дорогую версию той же вещи.",
            example = "The waiter tried to upsell us a bigger steak with truffle sauce.",
            exampleNative = "Официант попытался upsell нам стейк побольше с трюфельным соусом.",
            pos = "verb", semanticGroup = "shopping_marketing", fillInBlankExclusions = listOf(35005L)),

        WordEntity(id = 35005, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "cross-sell", transliteration = "[ˈkrɔsˌsɛl]", translation = "кросс-селл (продажа сопутствующего товара)",
            definition = "Offering a related extra item alongside what the buyer already chose.",
            definitionNative = "Предложить дополнительный товар рядом с тем, что покупатель уже выбрал.",
            example = "Online stores cross-sell phone cases right next to every new model.",
            exampleNative = "Интернет-магазины cross-sell чехлы для телефонов рядом с каждой новой моделью.",
            pos = "verb", semanticGroup = "shopping_marketing", fillInBlankExclusions = listOf(35004L)),

        // ── shopping_behavior (5) ─────────────────────────────────────────

        WordEntity(id = 35006, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "impulse-buy", transliteration = "[ˈɪmpəls baɪ]", translation = "импульсивная покупка",
            definition = "Grabbing a thing on a sudden whim with zero prior planning.",
            definitionNative = "Хватать вещь по внезапному порыву без предварительного плана.",
            example = "Those bright sweets near the till are designed for an impulse-buy.",
            exampleNative = "Те яркие конфеты у кассы сделаны для impulse-buy.",
            pos = "noun", semanticGroup = "shopping_behavior", fillInBlankExclusions = listOf(35004L)),

        WordEntity(id = 35007, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "window-shopping", transliteration = "[ˈwɪndoʊ ˌʃɑpɪŋ]", translation = "разглядывание витрин (без покупок)",
            definition = "Strolling past shop displays just to look, never paying for anything.",
            definitionNative = "Прогулка вдоль витрин ради разглядывания, без оплаты чего-либо.",
            example = "On rainy afternoons she enjoys window-shopping along the historic main street.",
            exampleNative = "В дождливые дни она любит window-shopping по исторической главной улице.",
            pos = "noun", semanticGroup = "shopping_behavior", fillInBlankExclusions = listOf(35006L)),

        WordEntity(id = 35008, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "splurge", transliteration = "[splərʤ]", translation = "потратить много (на удовольствие)",
            definition = "To spend lots of money quickly on a treat, often without regret afterwards.",
            definitionNative = "Быстро спустить кучу денег на удовольствие, часто без сожаления после этого.",
            example = "After her promotion she decided to splurge on a fancy dinner.",
            exampleNative = "После повышения она решила splurge на роскошный ужин.",
            pos = "verb", semanticGroup = "shopping_behavior"),

        WordEntity(id = 35009, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "frugal", transliteration = "[ˈfruɡəl]", translation = "бережливый (склонный экономить)",
            definition = "Careful with money — choosing simple options to keep costs low.",
            definitionNative = "Аккуратный с деньгами — выбирающий простые варианты, чтобы тратить меньше.",
            example = "Her frugal grandmother saved coupons for years before retiring.",
            exampleNative = "Её frugal бабушка годами собирала купоны до выхода на пенсию.",
            pos = "adjective", semanticGroup = "shopping_behavior", fillInBlankExclusions = listOf(35010L)),

        WordEntity(id = 35010, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "thrifty", transliteration = "[ˈθrɪfti]", translation = "экономный (умеющий растягивать деньги)",
            definition = "Skilled at making a small budget cover everything you really need.",
            definitionNative = "Умеющий растянуть маленький бюджет на всё, что действительно нужно.",
            example = "A thrifty cook can feed a big family on very few dollars.",
            exampleNative = "Thrifty повар может накормить большую семью на очень малые деньги.",
            pos = "adjective", semanticGroup = "shopping_behavior", fillInBlankExclusions = listOf(35009L)),

        // ── shopping_pricing (5) ──────────────────────────────────────────

        WordEntity(id = 35011, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "markup", transliteration = "[ˈmɑrˌkəp]", translation = "наценка (надбавка к себестоимости)",
            definition = "The extra cash a shop adds on top of what an item really cost them.",
            definitionNative = "Дополнительные деньги, которые магазин добавляет к настоящей стоимости товара.",
            example = "Designer eyeglasses often carry an enormous markup over the lens cost.",
            exampleNative = "Дизайнерские очки часто несут огромный markup над стоимостью линз.",
            pos = "noun", semanticGroup = "shopping_pricing", fillInBlankExclusions = listOf(35012L, 35013L, 35014L, 35015L)),

        WordEntity(id = 35012, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "markdown", transliteration = "[ˈmɑrkˌdaʊn]", translation = "уценка (понижение цены)",
            definition = "A cut in the asking price to clear out goods that are not selling.",
            definitionNative = "Снижение запрошенной цены, чтобы распродать товар, который плохо берут.",
            example = "A heavy markdown moved every winter coat off the shelves by March.",
            exampleNative = "Большая markdown к марту убрала с полок все зимние пальто.",
            pos = "noun", semanticGroup = "shopping_pricing", fillInBlankExclusions = listOf(35011L, 35013L, 35015L)),

        WordEntity(id = 35013, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "scarcity", transliteration = "[ˈskɛrsɪti]", translation = "дефицит (нехватка как маркетинговый приём)",
            definition = "A feeling that only a few are left, used to push buyers to act fast.",
            definitionNative = "Ощущение, что осталось очень мало, чтобы заставить покупателей действовать быстро.",
            example = "Artificial scarcity drives buyers wild during a flash sale event.",
            exampleNative = "Искусственный scarcity сводит покупателей с ума во время краткой распродажи.",
            pos = "noun", semanticGroup = "shopping_pricing", fillInBlankExclusions = listOf(35011L, 35012L, 35015L)),

        WordEntity(id = 35014, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "premium", transliteration = "[ˈprimiəm]", translation = "премиальный (высшего класса)",
            definition = "A quality level above the usual one, sold at a much higher price.",
            definitionNative = "Уровень качества выше обычного, который продают по гораздо более высокой цене.",
            example = "A premium subscription unlocks features the free version simply lacks.",
            exampleNative = "Premium подписка открывает возможности, которых просто нет в бесплатной версии.",
            pos = "adjective", semanticGroup = "shopping_pricing", fillInBlankExclusions = listOf(35015L, 35016L)),

        WordEntity(id = 35015, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "luxury", transliteration = "[ˈləkʃəri]", translation = "роскошь (предмет высокого класса)",
            definition = "An expensive treat — pleasant but not at all needed for daily life.",
            definitionNative = "Дорогое удовольствие — приятное, но совсем не нужное для повседневной жизни.",
            example = "Owning a yacht is the kind of luxury few can afford.",
            exampleNative = "Иметь яхту — такая luxury, какую могут позволить немногие.",
            pos = "noun", semanticGroup = "shopping_pricing", fillInBlankExclusions = listOf(35011L, 35012L, 35013L)),

        // ── shopping_subscription (5) ─────────────────────────────────────

        WordEntity(id = 35016, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "recurring", transliteration = "[rɪˈkərɪŋ]", translation = "повторяющийся (регулярный платёж)",
            definition = "Happening again and again at fixed times, like every month.",
            definitionNative = "Происходящий снова и снова в установленные сроки, например каждый месяц.",
            example = "A recurring fee leaves your account on the first day of each month.",
            exampleNative = "Recurring платёж уходит со счёта первого числа каждого месяца.",
            pos = "adjective", semanticGroup = "shopping_subscription", fillInBlankExclusions = listOf(35014L, 35015L)),

        WordEntity(id = 35017, setId = 350, languagePair = "en-ru", rarity = "RARE",
            original = "subscription", transliteration = "[səbˈskrɪpʃən]", translation = "подписка (на услугу)",
            definition = "An ongoing deal that gives you a service while you pay monthly fees.",
            definitionNative = "Длящееся соглашение, дающее услугу, пока ты платишь ежемесячные взносы.",
            example = "He cancelled his streaming subscription after watching only one show.",
            exampleNative = "Он отменил свою стриминговую subscription после просмотра всего одного шоу.",
            pos = "noun", semanticGroup = "shopping_subscription", fillInBlankExclusions = listOf(35018L, 35019L, 35020L)),

        WordEntity(id = 35018, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "fulfillment", transliteration = "[fʊlˈfɪlmənt]", translation = "выполнение заказа (логистика)",
            definition = "All the steps from picking goods at a warehouse to delivering them.",
            definitionNative = "Все шаги от сбора товаров на складе до их доставки покупателю.",
            example = "Their fulfillment center near the airport ships parcels worldwide every day.",
            exampleNative = "Их fulfillment центр у аэропорта каждый день отправляет посылки по всему миру.",
            pos = "noun", semanticGroup = "shopping_subscription", fillInBlankExclusions = listOf(35017L, 35019L, 35020L, 35021L)),

        WordEntity(id = 35019, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "drop-shipping", transliteration = "[ˈdrɑp ˌʃɪpɪŋ]", translation = "дропшиппинг (продажа без склада)",
            definition = "A model where the shop never holds stock — the maker mails it out.",
            definitionNative = "Модель, при которой магазин не держит склада — отправкой занимается производитель.",
            example = "He runs a small drop-shipping store from his bedroom desk.",
            exampleNative = "Он ведёт маленький drop-shipping магазин со стола в спальне.",
            pos = "noun", semanticGroup = "shopping_subscription", fillInBlankExclusions = listOf(35017L, 35018L, 35020L, 35021L)),

        WordEntity(id = 35020, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "click-and-collect", transliteration = "[klɪk ænd kəˈlɛkt]", translation = "забрать заказ из магазина (после онлайн-оплаты)",
            definition = "Pay online and pick up the goods later at a chosen physical shop.",
            definitionNative = "Оплатить онлайн и позже забрать товар в выбранном физическом магазине.",
            example = "Many parents prefer click-and-collect to avoid long queues at the till.",
            exampleNative = "Многие родители предпочитают click-and-collect, чтобы не стоять в очередях.",
            pos = "noun", semanticGroup = "shopping_subscription", fillInBlankExclusions = listOf(35017L, 35018L, 35019L)),

        // ── shopping_strategy (5) ─────────────────────────────────────────

        WordEntity(id = 35021, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "omnichannel", transliteration = "[ˈɑmniˌʧænəl]", translation = "омниканальный (продажи через все каналы)",
            definition = "Selling through web, app and shop together, so the buyer feels one journey.",
            definitionNative = "Продажа через сайт, приложение и магазин вместе, так что покупатель чувствует один путь.",
            example = "An omnichannel approach lets a buyer start online and finish in store.",
            exampleNative = "Omnichannel подход позволяет покупателю начать онлайн и закончить в магазине.",
            pos = "adjective", semanticGroup = "shopping_strategy", fillInBlankExclusions = listOf(35004L)),

        WordEntity(id = 35022, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "point-of-sale", transliteration = "[pɔɪnt əv seɪl]", translation = "точка продажи (место оплаты)",
            definition = "The exact spot inside a shop where the buyer hands over the money.",
            definitionNative = "Конкретное место внутри магазина, где покупатель отдаёт деньги.",
            example = "A small chocolate display by the point-of-sale boosts last-minute orders.",
            exampleNative = "Маленькая витрина шоколада возле point-of-sale увеличивает заказы в последний момент.",
            pos = "noun", semanticGroup = "shopping_strategy", fillInBlankExclusions = listOf(35023L, 35024L, 35025L)),

        WordEntity(id = 35023, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "foot-traffic", transliteration = "[fʊt ˈtræfɪk]", translation = "посещаемость (поток людей)",
            definition = "How many living souls walk past or into a shop in a given time.",
            definitionNative = "Сколько живых людей проходит мимо магазина или заходит внутрь за время.",
            example = "Heavy rain cut foot-traffic in the old downtown shopping street.",
            exampleNative = "Сильный дождь снизил foot-traffic на старой центральной торговой улице.",
            pos = "noun", semanticGroup = "shopping_strategy", fillInBlankExclusions = listOf(35022L, 35024L, 35025L)),

        WordEntity(id = 35024, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "customer-journey", transliteration = "[ˈkəstəmər ˈʤərni]", translation = "путь клиента (от знакомства до покупки)",
            definition = "Every step a buyer takes from first hearing about a brand to the purchase.",
            definitionNative = "Все шаги покупателя от первого знакомства с маркой до покупки.",
            example = "Mapping the customer-journey helped them spot two confusing checkout pages.",
            exampleNative = "Карта customer-journey помогла им найти две запутанные страницы оплаты.",
            pos = "noun", semanticGroup = "shopping_strategy", fillInBlankExclusions = listOf(35002L, 35003L, 35017L, 35018L, 35022L, 35023L, 35025L)),

        WordEntity(id = 35025, setId = 350, languagePair = "en-ru", rarity = "EPIC",
            original = "price-elasticity", transliteration = "[praɪs ɪˌlæˈstɪsɪti]", translation = "эластичность цены (чувствительность спроса)",
            definition = "How sharply demand drops or rises when a seller changes the price.",
            definitionNative = "Насколько резко спрос падает или растёт, когда продавец меняет цену.",
            example = "Coffee shows low price-elasticity — fans drink it even when costs rise.",
            exampleNative = "У кофе низкая price-elasticity — поклонники пьют, даже если стоимость растёт.",
            pos = "noun", semanticGroup = "shopping_strategy", fillInBlankExclusions = listOf(35022L, 35023L, 35024L)),
    )
}
