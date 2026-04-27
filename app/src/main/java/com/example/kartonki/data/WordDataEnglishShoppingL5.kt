package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Шоппинг и покупки (level 5, носитель языка).
 *
 * Set 357: «Шоппинг и покупки» — экспертная лексика на стыке маркетинга,
 * потребительского права и международной торговли: brand equity, consumer
 * protection, behavioral economics, business strategy, global trade.
 * (L5 / EPIC + LEGENDARY).
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY — два смежных уровня шкалы,
 * EPIC преобладает (узкоспециальная терминология бизнес-стратегии и права).
 *
 * Дополняет уже существующие сеты темы «Шоппинг и покупки»:
 *   - Set 348 (WordDataEnglishShoppingL1L2L3.kt) — L1, COMMON+UNCOMMON, базовая
 *                                                 лексика магазинов и оплаты.
 *   - Set 349 (WordDataEnglishShoppingL1L2L3.kt) — L2, UNCOMMON+RARE, бренды,
 *                                                 скидки, гарантии, онлайн-заказы.
 *   - Set 350 (WordDataEnglishShoppingL1L2L3.kt) — L3, RARE+EPIC, маркетинг,
 *                                                 лояльность, поведенческая экономика.
 *   - Set 356 (WordDataEnglishShoppingL4.kt)     — L4, RARE+EPIC, идёт параллельно.
 *
 * Слова setId=357 не пересекаются с setId=348/349/350. Кросс-топиковые
 * пересечения (consumer/equity/bias/cognitive/tariff/embargo с "Бизнес/
 * Политика/Право/Наука") допустимы по политике 2026-04-20.
 *
 * Все original — многословные термины (кроме `tariff`, `embargo`, `salience`,
 * `disintermediation`), что естественно для C2-уровня деловой лексики.
 *
 * isFillInBlankSafe = false — многословные термины часто дают form mismatch
 * или generic example; пометка снимает их с рассмотрения в FILL_IN_BLANK
 * до отдельного pipeline-прохода.
 *
 * SemanticGroups (5 × 5):
 *   shopping_brand_equity     — brand equity, share of voice, halo effect, top-of-mind, salience
 *   shopping_consumer_law     — consumer protection act, liability waiver, statutory right, recall notice, class action
 *   shopping_marketing_psych  — cognitive bias, loss aversion, social proof, reciprocity rule, choice paralysis
 *   shopping_strategy         — competitive positioning, blue ocean strategy, vertical integration, disintermediation, dynamic pricing
 *   shopping_global_trade     — tariff, customs duty, harmonized code, free trade agreement, embargo
 *
 * Word IDs: 35701..35725 (setId × 100 + position).
 */
object WordDataEnglishShoppingL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 357, name = "Шоппинг и покупки",
            description = "Уровень носителя: business strategy, consumer law, marketing psychology, brand equity",
            languagePair = "en-ru",
            topic = "Шоппинг и покупки", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── shopping_brand_equity (5) ─────────────────────────────────────

        WordEntity(id = 35701, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "brand equity", transliteration = "[brænd ˈɛkwəti]", translation = "капитал бренда",
            definition = "The extra value a familiar name adds to an otherwise plain product.",
            definitionNative = "Дополнительная ценность, которую узнаваемое имя добавляет обычному товару.",
            example = "Decades of careful advertising built the company's massive brand equity.",
            exampleNative = "Десятилетия аккуратной рекламы построили огромный brand equity компании.",
            pos = "noun", semanticGroup = "shopping_brand_equity",
            isFillInBlankSafe = false),

        WordEntity(id = 35702, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "share of voice", transliteration = "[ʃɛr əv vɔɪs]", translation = "доля голоса (доля рекламного шума)",
            definition = "How loud one company sounds compared to rivals across all media channels.",
            definitionNative = "Насколько громко одна фирма звучит на фоне конкурентов во всех каналах.",
            example = "Their summer campaign doubled the agency's share of voice on television.",
            exampleNative = "Летняя кампания удвоила share of voice агентства на телевидении.",
            pos = "noun", semanticGroup = "shopping_brand_equity",
            isFillInBlankSafe = false),

        WordEntity(id = 35703, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "halo effect", transliteration = "[ˈheɪloʊ ɪˈfɛkt]", translation = "эффект ореола (одно достоинство красит всё)",
            definition = "When one good trait makes shoppers assume everything else is also great.",
            definitionNative = "Когда одно хорошее качество заставляет покупателей думать, что и всё остальное хорошо.",
            example = "A famous chef on the box creates a strong halo effect for the cereal.",
            exampleNative = "Известный шеф на коробке создаёт сильный halo effect для хлопьев.",
            pos = "noun", semanticGroup = "shopping_brand_equity",
            isFillInBlankSafe = false),

        WordEntity(id = 35704, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "top-of-mind", transliteration = "[tɑp əv maɪnd]", translation = "сразу всплывающий в памяти (о бренде)",
            definition = "The label a buyer instantly says when asked about a whole product category.",
            definitionNative = "Марка, которую покупатель мгновенно называет, услышав название категории товаров.",
            example = "For soft drinks, that red logo remains the top-of-mind choice worldwide.",
            exampleNative = "В газировке тот красный логотип остаётся top-of-mind выбором по всему миру.",
            pos = "adjective", semanticGroup = "shopping_brand_equity",
            isFillInBlankSafe = false),

        WordEntity(id = 35705, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "salience", transliteration = "[ˈseɪliəns]", translation = "заметность (бренда в памяти покупателя)",
            definition = "How easily a label pops into a shopper's head at the moment of choice.",
            definitionNative = "Насколько легко имя всплывает в голове покупателя в момент выбора.",
            example = "Bright packaging boosts the salience of a snack on a crowded shelf.",
            exampleNative = "Яркая упаковка поднимает salience снэка на переполненной полке.",
            pos = "noun", semanticGroup = "shopping_brand_equity",
            isFillInBlankSafe = false),

        // ── shopping_consumer_law (5) ─────────────────────────────────────

        WordEntity(id = 35706, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "consumer protection act", transliteration = "[kənˈsumər prəˈtɛkʃən ækt]", translation = "закон о защите прав потребителей",
            definition = "A national law shielding ordinary buyers from unfair sellers and faulty goods.",
            definitionNative = "Государственный закон, защищающий обычных покупателей от нечестных продавцов.",
            example = "He cited the consumer protection act when the dealer refused to refund.",
            exampleNative = "Он сослался на consumer protection act, когда дилер отказал в возврате.",
            pos = "noun", semanticGroup = "shopping_consumer_law",
            isFillInBlankSafe = false),

        WordEntity(id = 35707, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "liability waiver", transliteration = "[ˌlaɪəˈbɪlɪti ˈweɪvər]", translation = "отказ от ответственности",
            definition = "A signed paper saying the seller will not pay if something goes wrong.",
            definitionNative = "Подписанная бумага, что продавец не платит, если что-то пойдёт не так.",
            example = "Skydiving schools always make students sign a strict liability waiver.",
            exampleNative = "Школы парашютного спорта всегда дают курсантам подписать жёсткий liability waiver.",
            pos = "noun", semanticGroup = "shopping_consumer_law",
            isFillInBlankSafe = false),

        WordEntity(id = 35708, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "statutory right", transliteration = "[ˈstæʧəˌtɔri raɪt]", translation = "законное право (потребителя по закону)",
            definition = "A protection given to every buyer by the state — no shop can take it away.",
            definitionNative = "Защита, данная каждому покупателю государством — её не отменит ни один магазин.",
            example = "Returning a faulty kettle is a statutory right in most European countries.",
            exampleNative = "Возврат бракованного чайника — statutory right в большинстве стран Европы.",
            pos = "noun", semanticGroup = "shopping_consumer_law",
            isFillInBlankSafe = false),

        WordEntity(id = 35709, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "recall notice", transliteration = "[ˈriˌkɔl ˈnoʊtɪs]", translation = "уведомление об отзыве (товара)",
            definition = "An official message asking buyers to return a dangerous item to the maker.",
            definitionNative = "Официальное сообщение, просящее покупателей вернуть опасную вещь производителю.",
            example = "A fresh recall notice covered every car sold last spring.",
            exampleNative = "Свежий recall notice охватил все машины, проданные прошлой весной.",
            pos = "noun", semanticGroup = "shopping_consumer_law",
            isFillInBlankSafe = false),

        WordEntity(id = 35710, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "cooling-off period", transliteration = "[ˈkuːlɪŋ ɒf ˈpɪərɪəd]", translation = "период отказа от покупки",
            definition = "A few days after the order when a buyer can cancel and get a full refund.",
            definitionNative = "Несколько дней после покупки, когда покупатель ещё может отменить заказ.",
            example = "By law a fourteen-day cooling-off period covers most online orders here.",
            exampleNative = "По закону четырнадцатидневный cooling-off period распространяется на большинство онлайн-заказов.",
            pos = "noun", semanticGroup = "shopping_consumer_law",
            isFillInBlankSafe = false),

        // ── shopping_marketing_psych (5) ──────────────────────────────────

        WordEntity(id = 35711, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "framing effect", transliteration = "[ˈfreɪmɪŋ ɪˈfɛkt]", translation = "эффект подачи (формулировки)",
            definition = "How wording of the same offer pushes the buyer toward a different choice.",
            definitionNative = "Как формулировка одного и того же предложения подталкивает покупателя к иному выбору.",
            example = "\"Ninety percent fat-free\" sells better — a textbook framing effect.",
            exampleNative = "«Девяносто процентов без жира» продаётся лучше — хрестоматийный framing effect.",
            pos = "noun", semanticGroup = "shopping_marketing_psych",
            isFillInBlankSafe = false),

        WordEntity(id = 35712, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "loss aversion", transliteration = "[lɔs əˈvərʒən]", translation = "неприятие потерь",
            definition = "The urge to keep what you have rather than risk it for an equal gain.",
            definitionNative = "Стремление сохранить имеющееся, а не рискнуть им ради равной по размеру прибыли.",
            example = "Free-trial offers exploit loss aversion once shoppers feel ownership.",
            exampleNative = "Бесплатные пробные периоды используют loss aversion, когда покупатель уже привык.",
            pos = "noun", semanticGroup = "shopping_marketing_psych",
            isFillInBlankSafe = false),

        WordEntity(id = 35713, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "social proof", transliteration = "[ˈsoʊʃəl pruf]", translation = "социальное доказательство",
            definition = "A signal that many other people already chose this thing — so it must be good.",
            definitionNative = "Сигнал, что многие другие уже выбрали эту вещь — значит, она хорошая.",
            example = "Five-star reviews provide the social proof that turns visitors into buyers.",
            exampleNative = "Пятизвёздные отзывы дают social proof, превращающий посетителей в покупателей.",
            pos = "noun", semanticGroup = "shopping_marketing_psych",
            isFillInBlankSafe = false),

        WordEntity(id = 35714, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "reciprocity rule", transliteration = "[ˌrɛsəˈprɑsɪti rul]", translation = "правило взаимности",
            definition = "A social habit where a small free favour pushes people to give back.",
            definitionNative = "Социальная привычка: маленькая бесплатная услуга подталкивает людей отплатить.",
            example = "Free chocolate by the bill exploits the reciprocity rule for bigger tips.",
            exampleNative = "Бесплатный шоколад к счёту использует reciprocity rule ради больших чаевых.",
            pos = "noun", semanticGroup = "shopping_marketing_psych",
            isFillInBlankSafe = false),

        WordEntity(id = 35715, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "choice paralysis", transliteration = "[ʧɔɪs pəˈræləsɪs]", translation = "паралич выбора",
            definition = "When too many options on a shelf freeze the buyer and no purchase happens.",
            definitionNative = "Когда слишком много вариантов на полке замораживают покупателя — он не берёт ничего.",
            example = "A wall of forty jam jars is a textbook case of choice paralysis.",
            exampleNative = "Стена из сорока банок варенья — учебный choice paralysis.",
            pos = "noun", semanticGroup = "shopping_marketing_psych",
            isFillInBlankSafe = false),

        // ── shopping_strategy (5) ─────────────────────────────────────────

        WordEntity(id = 35716, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "competitive positioning", transliteration = "[kəmˈpɛtɪtɪv pəˈzɪʃənɪŋ]", translation = "конкурентное позиционирование",
            definition = "The unique slot a firm picks in a buyer's mind versus the rest of the field.",
            definitionNative = "Уникальное место, которое фирма занимает в голове покупателя на фоне соперников.",
            example = "Their competitive positioning rests on speed, never on the lowest price.",
            exampleNative = "Их competitive positioning держится на скорости, а не на самой низкой цене.",
            pos = "noun", semanticGroup = "shopping_strategy",
            isFillInBlankSafe = false),

        WordEntity(id = 35717, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "blue ocean strategy", transliteration = "[blu ˈoʊʃən ˈstrætəʤi]", translation = "стратегия голубого океана (новый рынок без конкуренции)",
            definition = "Carving out a fresh empty market where no rivals are fighting yet.",
            definitionNative = "Создать свежий пустой рынок, где соперники ещё не дерутся за покупателей.",
            example = "Cirque du Soleil's blue ocean strategy invented theatre without animals.",
            exampleNative = "Blue ocean strategy Cirque du Soleil изобрела цирк-театр без животных.",
            pos = "noun", semanticGroup = "shopping_strategy",
            isFillInBlankSafe = false),

        WordEntity(id = 35718, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "vertical integration", transliteration = "[ˈvərtɪkəl ˌɪntəˈgreɪʃən]", translation = "вертикальная интеграция (контроль всей цепочки)",
            definition = "When one company owns every step from raw material to finished store sale.",
            definitionNative = "Когда одна фирма владеет каждым шагом от сырья до продажи в магазине.",
            example = "Their vertical integration gives them full control over coffee from farm to cup.",
            exampleNative = "Их vertical integration даёт полный контроль над кофе от фермы до чашки.",
            pos = "noun", semanticGroup = "shopping_strategy",
            isFillInBlankSafe = false),

        WordEntity(id = 35719, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "disintermediation", transliteration = "[dɪsˌɪntərˌmidiˈeɪʃən]", translation = "отказ от посредников (прямые продажи)",
            definition = "Cutting out middlemen so the maker reaches the final shopper directly.",
            definitionNative = "Убрать посредников, чтобы производитель добирался до конечного покупателя напрямую.",
            example = "Online platforms drove disintermediation across the entire travel industry.",
            exampleNative = "Онлайн-площадки запустили disintermediation во всей туристической отрасли.",
            pos = "noun", semanticGroup = "shopping_strategy",
            isFillInBlankSafe = false),

        WordEntity(id = 35720, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "dynamic pricing", transliteration = "[daɪˈnæmɪk ˈpraɪsɪŋ]", translation = "динамическое ценообразование",
            definition = "A system where the cost shifts hour by hour based on demand and stock.",
            definitionNative = "Система, где стоимость меняется час за часом в зависимости от спроса и запасов.",
            example = "Airlines use dynamic pricing to push fares up close to departure day.",
            exampleNative = "Авиакомпании используют dynamic pricing, чтобы поднять тарифы у даты вылета.",
            pos = "noun", semanticGroup = "shopping_strategy",
            isFillInBlankSafe = false),

        // ── shopping_global_trade (5) ─────────────────────────────────────

        WordEntity(id = 35721, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "import quota", transliteration = "[ˈɪmpɔːrt ˈkwoʊtə]", translation = "квота на импорт",
            definition = "A legal cap on how much of a foreign product can enter a country yearly.",
            definitionNative = "Ограничение на количество иностранного товара, которое страна впускает за год.",
            example = "An import quota on cheap textiles protects small local sewing workshops.",
            exampleNative = "Import quota на дешёвый текстиль защищает мелкие местные швейные мастерские.",
            pos = "noun", semanticGroup = "shopping_global_trade",
            isFillInBlankSafe = false),

        WordEntity(id = 35722, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "customs duty", transliteration = "[ˈkəstəmz ˈduti]", translation = "таможенная пошлина",
            definition = "Money the government takes when a parcel from abroad crosses the border.",
            definitionNative = "Деньги, которые государство берёт, когда посылка из-за рубежа пересекает границу.",
            example = "A heavy customs duty was added to the camera shipped from Japan.",
            exampleNative = "К камере, отправленной из Японии, добавили большой customs duty.",
            pos = "noun", semanticGroup = "shopping_global_trade",
            isFillInBlankSafe = false),

        WordEntity(id = 35723, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "harmonized code", transliteration = "[ˈhɑrməˌnaɪzd koʊd]", translation = "гармонизированный код (международная классификация товаров)",
            definition = "A worldwide number that tells customs exactly what kind of goods are inside.",
            definitionNative = "Всемирный номер, точно говорящий таможне, какой именно товар внутри коробки.",
            example = "Each box needs a harmonized code on the export paperwork.",
            exampleNative = "Каждой коробке нужен harmonized code в экспортных бумагах.",
            pos = "noun", semanticGroup = "shopping_global_trade",
            isFillInBlankSafe = false),

        WordEntity(id = 35724, setId = 357, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "free trade agreement", transliteration = "[fri treɪd əˈgrimənt]", translation = "соглашение о свободной торговле",
            definition = "A pact between two countries to drop most taxes on goods crossing borders.",
            definitionNative = "Договор двух стран, отменяющий большинство налогов на товары между ними.",
            example = "The free trade agreement made olive oil from Spain much cheaper here.",
            exampleNative = "Free trade agreement сделало оливковое масло из Испании здесь намного дешевле.",
            pos = "noun", semanticGroup = "shopping_global_trade",
            isFillInBlankSafe = false),

        WordEntity(id = 35725, setId = 357, languagePair = "en-ru", rarity = "EPIC",
            original = "embargo", transliteration = "[ɛmˈbɑrgoʊ]", translation = "эмбарго (запрет на торговлю)",
            definition = "A government ban on trading certain goods with another country.",
            definitionNative = "Государственный запрет торговать определёнными товарами с другой страной.",
            example = "The embargo stopped luxury watches from reaching local shop windows.",
            exampleNative = "Embargo прекратило поступление дорогих часов на местные витрины.",
            pos = "noun", semanticGroup = "shopping_global_trade",
            isFillInBlankSafe = false),
    )
}
