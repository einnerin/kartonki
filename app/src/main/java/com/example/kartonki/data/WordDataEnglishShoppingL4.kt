package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Шоппинг и покупки (L4, профессиональный уровень).
 *
 * Set:
 *   - 356 (L4, EPIC + LEGENDARY) — углублённая профессиональная лексика:
 *       e-commerce, supply chain, retail analytics, потребительское поведение,
 *       премиум-сегмент.
 *
 * Тема «Шоппинг и покупки» уже представлена сетами 348 (L1), 349 (L2), 350 (L3).
 * В этом сете слова более узкоспециализированные — термины из retail,
 * e-commerce и поведенческой экономики.
 *
 * Кросс-топиковые пересечения (politика «между темами разрешено»):
 *   - "procurement" есть в setId=61 (Финансы)
 *   - "planogram" есть в setId=240 (Дом и быт)
 *   - "distributor" есть в setId=240 (Дом и быт)
 *   - "bespoke" есть в setId=223 (Одежда)
 * Внутри темы «Шоппинг и покупки» все original'ы уникальны.
 *
 * SemanticGroups (5 × 5):
 *   shopping_ecommerce        — e-commerce-механики
 *   shopping_supply_chain     — снабжение и склады
 *   shopping_retail_analytics — аналитика розницы
 *   shopping_consumer_behavior — поведение покупателя
 *   shopping_premium          — премиум-сегмент
 *
 * Word IDs: setId * 100 + position (35601..35625).
 *
 * isFillInBlankSafe = false для всех 25 слов: многие термины — многословные
 * фразы (checkout-funnel, customer-lifetime-value, click-and-collect-style),
 * где FILL_IN_BLANK pipeline ещё не размечен. Будет переведено в safe после
 * Phase 3 FILL_IN_BLANK exclusions.
 */
object WordDataEnglishShoppingL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 356, name = "Шоппинг и покупки",
            description = "Углублённый: e-commerce, supply chain, retail analytics, потребительское поведение",
            languagePair = "en-ru",
            topic = "Шоппинг и покупки", level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ═══════════════════════════════════════════════════════════════════
        // Set 356 — L4, EPIC + LEGENDARY
        // ═══════════════════════════════════════════════════════════════════

        // ── shopping_ecommerce (5) ────────────────────────────────────────

        WordEntity(id = 35601, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "checkout-funnel", transliteration = "[ˈʧɛˌkaʊt ˈfənəl]", translation = "воронка оформления заказа",
            definition = "The narrowing path of pages a buyer goes through before paying online.",
            definitionNative = "Сужающийся путь страниц, через который покупатель идёт перед онлайн-оплатой.",
            example = "Each extra field in the checkout-funnel pushes more buyers to leave silently.",
            exampleNative = "Каждое лишнее поле в checkout-funnel заставляет больше покупателей молча уйти.",
            pos = "noun", semanticGroup = "shopping_ecommerce", fillInBlankExclusions = listOf(35602L, 35603L, 35604L, 35605L)),

        WordEntity(id = 35602, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "abandoned-cart", transliteration = "[əˈbændənd kɑrt]", translation = "брошенная корзина",
            definition = "A digital basket the visitor filled but left without paying anything.",
            definitionNative = "Цифровая корзина, которую посетитель наполнил, но ушёл, ничего не оплатив.",
            example = "Reminder emails about an abandoned-cart often bring shy buyers back to finish.",
            exampleNative = "Письма-напоминания об abandoned-cart часто возвращают робких покупателей.",
            pos = "noun", semanticGroup = "shopping_ecommerce", fillInBlankExclusions = listOf(35605L)),

        WordEntity(id = 35603, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "conversion-rate", transliteration = "[kənˈvərʒən reɪt]", translation = "коэффициент конверсии",
            definition = "The percent of visitors who actually pay, out of everyone who came.",
            definitionNative = "Процент посетителей, которые реально платят, из всех зашедших на сайт.",
            example = "A redesigned product page lifted the conversion-rate by nearly two percent.",
            exampleNative = "Переделанная страница товара подняла conversion-rate почти на два процента.",
            pos = "noun", semanticGroup = "shopping_ecommerce", fillInBlankExclusions = listOf(35601L, 35602L, 35604L, 35605L, 35607L, 35612L, 35614L)),

        WordEntity(id = 35604, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "fulfillment-center", transliteration = "[fʊlˈfɪlmənt ˈsɛntər]", translation = "склад-распределитель (логистический центр)",
            definition = "A huge warehouse where staff pick, pack and ship online orders all day.",
            definitionNative = "Огромный склад, где работники целый день собирают, пакуют и отправляют онлайн-заказы.",
            example = "Their new fulfillment-center near the airport ships parcels across the country.",
            exampleNative = "Их новый fulfillment-center у аэропорта отправляет посылки по всей стране.",
            pos = "noun", semanticGroup = "shopping_ecommerce", fillInBlankExclusions = listOf(35601L, 35602L, 35603L, 35605L, 35606L)),

        WordEntity(id = 35605, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "e-commerce-platform", transliteration = "[i ˈkɑmərs ˈplætˌfɔrm]", translation = "платформа электронной коммерции",
            definition = "Software that lets a business build a web shop and sell to anyone online.",
            definitionNative = "Программа, позволяющая бизнесу построить веб-магазин и продавать любому через интернет.",
            example = "Small brands often launch on a ready e-commerce-platform to skip costly coding.",
            exampleNative = "Маленькие марки часто стартуют на готовой e-commerce-platform, минуя дорогую разработку.",
            pos = "noun", semanticGroup = "shopping_ecommerce", fillInBlankExclusions = listOf(35601L, 35602L, 35603L, 35604L)),

        // ── shopping_supply_chain (5) ─────────────────────────────────────

        WordEntity(id = 35606, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "distributor", transliteration = "[dɪˈstrɪbjətər]", translation = "дистрибьютор (оптовый посредник)",
            definition = "A middle company that buys big from a maker and resells to many shops.",
            definitionNative = "Компания-посредник, которая закупает большое у производителя и перепродаёт магазинам.",
            example = "Their main distributor handles every shop east of the river.",
            exampleNative = "Их главный distributor обслуживает все магазины восточнее реки.",
            pos = "noun", semanticGroup = "shopping_supply_chain", fillInBlankExclusions = listOf(35604L, 35607L, 35609L, 35610L)),

        WordEntity(id = 35607, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "inventory-turnover", transliteration = "[ˈɪnvənˌtɔri ˈtərˌnoʊvər]", translation = "оборачиваемость запасов",
            definition = "How many times a shop fully sells and replaces its stock each year.",
            definitionNative = "Сколько раз магазин полностью продаёт и пополняет свой склад за год.",
            example = "A high inventory-turnover means fresh stock and almost no expired items.",
            exampleNative = "Высокий inventory-turnover означает свежий товар и почти без просрочки.",
            pos = "noun", semanticGroup = "shopping_supply_chain", fillInBlankExclusions = listOf(35606L, 35609L, 35610L)),

        WordEntity(id = 35608, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "just-in-time", transliteration = "[ʤəst ɪn taɪm]", translation = "точно в срок (поставка под спрос)",
            definition = "A model where supplies arrive only when needed, with no warehouse pile.",
            definitionNative = "Модель, при которой поставки приходят только под спрос, без склада на запас.",
            example = "Toyota popularised the just-in-time approach across the global car industry.",
            exampleNative = "Toyota популяризировала just-in-time подход во всей мировой автопромышленности.",
            pos = "adjective", semanticGroup = "shopping_supply_chain"),

        WordEntity(id = 35609, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "backorder", transliteration = "[ˈbækˌɔrdər]", translation = "заказ на товар нет в наличии",
            definition = "A purchase placed for a sold-out item that the shop will mail later.",
            definitionNative = "Заказ на закончившийся товар, который магазин пришлёт позже.",
            example = "The popular console is on backorder until the next factory shipment arrives.",
            exampleNative = "Популярная приставка идёт по backorder до следующей заводской партии.",
            pos = "noun", semanticGroup = "shopping_supply_chain", fillInBlankExclusions = listOf(35606L, 35607L, 35610L)),

        WordEntity(id = 35610, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "procurement", transliteration = "[proʊˈkjʊrmənt]", translation = "закупки (корпоративные)",
            definition = "The whole work of finding suppliers and buying goods for a big company.",
            definitionNative = "Вся работа по поиску поставщиков и закупке товаров для большой компании.",
            example = "The procurement team negotiated a yearly deal with three major suppliers.",
            exampleNative = "Команда procurement выбила годовой контракт с тремя крупными поставщиками.",
            pos = "noun", semanticGroup = "shopping_supply_chain", fillInBlankExclusions = listOf(35606L, 35607L, 35609L)),

        // ── shopping_retail_analytics (5) ─────────────────────────────────

        WordEntity(id = 35611, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "basket-analysis", transliteration = "[ˈbæskət əˈnæləsɪs]", translation = "анализ покупательской корзины",
            definition = "Studying which goods people put together in one shopping run.",
            definitionNative = "Изучение того, какие товары люди кладут вместе за одну покупку.",
            example = "A simple basket-analysis showed bread and butter walk out together every time.",
            exampleNative = "Простой basket-analysis показал, что хлеб и масло уходят вместе каждый раз.",
            pos = "noun", semanticGroup = "shopping_retail_analytics", fillInBlankExclusions = listOf(35612L, 35613L, 35614L, 35615L)),

        WordEntity(id = 35612, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "customer-lifetime-value", transliteration = "[ˈkəstəmər ˈlaɪfˌtaɪm ˈvælju]", translation = "пожизненная ценность клиента",
            definition = "The total cash one buyer is expected to leave at a brand over the years.",
            definitionNative = "Общая сумма, которую один покупатель оставит у бренда за все годы.",
            example = "Loyal subscribers raise the average customer-lifetime-value by a wide margin.",
            exampleNative = "Лояльные подписчики сильно повышают средний customer-lifetime-value.",
            pos = "noun", semanticGroup = "shopping_retail_analytics", fillInBlankExclusions = listOf(35603L, 35607L, 35611L, 35613L, 35614L, 35615L)),

        WordEntity(id = 35613, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "shrinkage rate", transliteration = "[ˈʃrɪŋkɪdʒ reɪt]", translation = "уровень потерь (магазина)",
            definition = "Share of stock lost to theft, damage or paperwork errors over a period.",
            definitionNative = "Доля товара, потерянного из-за краж, порчи или ошибок учёта за период.",
            example = "Cameras at the entry cut shrinkage rate by almost a third last year.",
            exampleNative = "Камеры на входе сократили shrinkage rate почти на треть за прошлый год.",
            pos = "noun", semanticGroup = "shopping_retail_analytics", fillInBlankExclusions = listOf(35611L, 35612L, 35614L, 35615L)),

        WordEntity(id = 35614, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dwell-time", transliteration = "[dwɛl taɪm]", translation = "время пребывания (в магазине, у товара)",
            definition = "How long a shopper lingers in front of a product or display.",
            definitionNative = "Сколько покупатель задерживается перед товаром или витриной.",
            example = "Long dwell-time near the cheese counter hinted at confused choices.",
            exampleNative = "Долгий dwell-time у сырной витрины намекал на растерянность покупателей.",
            pos = "noun", semanticGroup = "shopping_retail_analytics", fillInBlankExclusions = listOf(35611L, 35612L, 35613L, 35615L)),

        WordEntity(id = 35615, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "heat-map", transliteration = "[hit mæp]", translation = "тепловая карта (зон активности покупателей)",
            definition = "A coloured picture of a shop floor that shows the busiest spots in red.",
            definitionNative = "Цветной план магазина, на котором самые посещаемые места отмечены красным.",
            example = "The heat-map proved that almost no one walked into the back corner.",
            exampleNative = "Heat-map доказала, что в дальний угол почти никто не заходит.",
            pos = "noun", semanticGroup = "shopping_retail_analytics", fillInBlankExclusions = listOf(35611L, 35612L, 35613L, 35614L)),

        // ── shopping_consumer_behavior (5) ────────────────────────────────

        WordEntity(id = 35616, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "impulse-buying", transliteration = "[ˈɪmpəls ˈbaɪɪŋ]", translation = "импульсивное потребление",
            definition = "The habit of grabbing things on a sudden whim with no real plan.",
            definitionNative = "Привычка хватать вещи по внезапному порыву без настоящего плана.",
            example = "Bright displays at the till encourage impulse-buying among tired shoppers.",
            exampleNative = "Яркие витрины у кассы поощряют impulse-buying у уставших покупателей.",
            pos = "noun", semanticGroup = "shopping_consumer_behavior", fillInBlankExclusions = listOf(35617L, 35618L, 35619L, 35620L)),

        WordEntity(id = 35617, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "brand-loyalty", transliteration = "[brænd ˈlɔɪəlti]", translation = "приверженность бренду",
            definition = "A buyer's lasting habit of choosing one maker over all the rivals.",
            definitionNative = "Стойкая привычка покупателя выбирать одного производителя вместо соперников.",
            example = "Strong brand-loyalty lets some sneaker makers raise prices without losing fans.",
            exampleNative = "Сильная brand-loyalty позволяет некоторым кроссовочным маркам поднимать цены без потери фанатов.",
            pos = "noun", semanticGroup = "shopping_consumer_behavior", fillInBlankExclusions = listOf(35616L, 35618L, 35619L, 35620L)),

        WordEntity(id = 35618, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "anchor-pricing", transliteration = "[ˈæŋkər ˈpraɪsɪŋ]", translation = "якорное ценообразование",
            definition = "Showing a high number first so the real price feels like a bargain.",
            definitionNative = "Сначала показать высокую сумму, чтобы реальная цена казалась выгодной.",
            example = "The crossed-out tag is classic anchor-pricing — your eye sees the saving instantly.",
            exampleNative = "Зачёркнутый ценник — классический anchor-pricing: глаз сразу видит экономию.",
            pos = "noun", semanticGroup = "shopping_consumer_behavior", fillInBlankExclusions = listOf(35616L, 35617L, 35619L, 35620L)),

        WordEntity(id = 35619, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "decoy-effect", transliteration = "[ˈdiˌkɔɪ ɪˈfɛkt]", translation = "эффект приманки (третий невыгодный вариант)",
            definition = "A trick where a useless third option pushes you toward a chosen pricier one.",
            definitionNative = "Приём, когда бесполезный третий вариант подталкивает тебя к нужному дорогому.",
            example = "The medium popcorn is just the decoy-effect making the large feel smart.",
            exampleNative = "Средний попкорн — просто decoy-effect, чтобы большой казался разумным.",
            pos = "noun", semanticGroup = "shopping_consumer_behavior", fillInBlankExclusions = listOf(35616L, 35617L, 35618L, 35620L)),

        WordEntity(id = 35620, setId = 356, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bandwagon-effect", transliteration = "[ˈbændˌwæɡən ɪˈfɛkt]", translation = "эффект толпы (покупка за компанию)",
            definition = "The pull people feel toward something just because everyone else is choosing it.",
            definitionNative = "Тяга людей к чему-то только потому, что все остальные тоже это выбирают.",
            example = "The bandwagon-effect explains why a hot phone sells out in a single weekend.",
            exampleNative = "Bandwagon-effect объясняет, почему модный телефон сметают за одни выходные.",
            pos = "noun", semanticGroup = "shopping_consumer_behavior", fillInBlankExclusions = listOf(35616L, 35617L, 35618L, 35619L)),

        // ── shopping_premium (5) ──────────────────────────────────────────

        WordEntity(id = 35621, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "luxury-good", transliteration = "[ˈləkʃəri ɡʊd]", translation = "предмет роскоши",
            definition = "A pricey thing chosen for status and pleasure rather than daily need.",
            definitionNative = "Дорогая вещь, выбранная ради статуса и удовольствия, а не повседневной нужды.",
            example = "A handcrafted Swiss watch is the kind of luxury-good that lasts generations.",
            exampleNative = "Швейцарские часы ручной работы — тот luxury-good, что переживает поколения.",
            pos = "noun", semanticGroup = "shopping_premium", fillInBlankExclusions = listOf(35622L, 35623L, 35625L)),

        WordEntity(id = 35622, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "designer-label", transliteration = "[dɪˈzaɪnər ˈleɪbəl]", translation = "дизайнерская марка (известного модельера)",
            definition = "A famous fashion name signed by a single creative author behind every piece.",
            definitionNative = "Известное модное имя, за которым стоит один автор каждой вещи коллекции.",
            example = "She saved for months to buy one bag from a Parisian designer-label.",
            exampleNative = "Она копила месяцами, чтобы купить одну сумку парижского designer-label.",
            pos = "noun", semanticGroup = "shopping_premium", fillInBlankExclusions = listOf(35621L, 35623L, 35625L)),

        WordEntity(id = 35623, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "limited-edition", transliteration = "[ˈlɪmətəd ɪˈdɪʃən]", translation = "ограниченная серия",
            definition = "A small batch of items made only once, after which no more are produced.",
            definitionNative = "Маленькая партия вещей, выпущенная единожды, после чего их больше не делают.",
            example = "Collectors fought online for the limited-edition sneaker drop on Friday.",
            exampleNative = "Коллекционеры дрались онлайн за пятничный дроп limited-edition кроссовок.",
            pos = "noun", semanticGroup = "shopping_premium", fillInBlankExclusions = listOf(35621L, 35622L, 35625L)),

        WordEntity(id = 35624, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "bespoke", transliteration = "[bɪˈspoʊk]", translation = "сшитый на заказ (по индивидуальной мерке)",
            definition = "Made one-off for a single client, exactly to their measurements and taste.",
            definitionNative = "Сделанный единично для одного клиента, ровно по его меркам и вкусу.",
            example = "His bespoke suit was hand-stitched over four weeks in a London tailor shop.",
            exampleNative = "Его bespoke костюм шили вручную четыре недели в лондонской мастерской.",
            pos = "adjective", semanticGroup = "shopping_premium"),

        WordEntity(id = 35625, setId = 356, languagePair = "en-ru", rarity = "EPIC",
            original = "concierge-service", transliteration = "[kɑnsiˈɛrʒ ˈsərvəs]", translation = "консьерж-сервис (персональное обслуживание)",
            definition = "Personal staff who arrange anything a wealthy client asks, around the clock.",
            definitionNative = "Личные сотрудники, которые круглосуточно устроят любую просьбу состоятельного клиента.",
            example = "Their concierge-service can book opera seats and a private chef in minutes.",
            exampleNative = "Их concierge-service за минуты бронирует места в опере и частного повара.",
            pos = "noun", semanticGroup = "shopping_premium", fillInBlankExclusions = listOf(35621L, 35622L, 35623L)),
    )
}
