package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Финансы (level 5, носитель языка).
 *
 * Set 344: «Финансы» — высокая финансовая лексика: деривативы, корпоративные
 * действия, концепции платёжеспособности, архаика биржевой жизни (C2+).
 *
 * Распределение редкости: 18 LEGENDARY + 7 EPIC — два смежных уровня шкалы;
 * LEGENDARY преобладает (level 5 = носитель/архаика).
 *
 * Дополняет уже существующие сеты темы «Финансы»:
 *   - Set 24  (WordDataEnglish.kt)         — L2 UNCOMMON, базовый бизнес.
 *   - Set 26  (WordDataEnglish.kt)         — L2 UNCOMMON, экономика и налоги.
 *   - Set 46  (WordDataEnglish.kt)         — L3 RARE, бизнес-стратегия.
 *   - Set 61  (WordDataEnglish.kt)         — L4 EPIC, корпоративные термины
 *     (merger, acquisition, dividend, audit, fiduciary, yield, arbitrage и т. д.).
 *   - Set 214 (WordDataEnglishExpanded.kt) — L3 RARE, отчётность
 *     (futures, debenture, hedging, mezzanine finance, valuation и т. д.).
 *   - Set 251 (WordDataEnglishBatch3.kt)   — L2 UNCOMMON, банковская лексика.
 *
 * Параллельно создаётся L1 (343) — базовая бытовая финансовая лексика
 * (money, cash, salary, debt, account, bank, card …); в L5 эта лексика
 * сознательно не используется.
 *
 * Слова setId=344 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   finance_derivatives        — derivative, swap, warrant, tranche, fungible
 *   finance_corporate_actions  — spinoff, recapitalization, underwrite, covenant, moratorium
 *   finance_risk_metrics       — liquidity, solvency, volatility, drawdown, indemnity
 *   finance_archaic            — usury, bullion, specie, scrip, escrow
 *   finance_markets            — bear market, bull market, hedge fund, blue-chip, bourse
 *
 * Word IDs: 34401..34425 (setId × 100 + position).
 */
object WordDataEnglishFinanceL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 344, name = "Финансы",
            description = "Высокая финансовая лексика: деривативы, корпоративные финансы, архаика биржевой жизни",
            languagePair = "en-ru",
            topic = "Финансы", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── finance_derivatives (5) ───────────────────────────────────────

        WordEntity(id = 34401, setId = 344, languagePair = "en-ru", rarity = "EPIC",
            original = "derivative", transliteration = "[dɪˈrɪvətɪv]", translation = "производный финансовый инструмент",
            definition = "A contract whose price depends on the value of another asset.",
            definitionNative = "Контракт, цена которого зависит от стоимости другого актива.",
            example = "The bank traded a complex derivative tied to oil prices last quarter.",
            exampleNative = "Банк торговал сложный derivative, привязанный к ценам на нефть.",
            pos = "noun", semanticGroup = "finance_derivatives", fillInBlankExclusions = listOf(34402L, 34403L, 34404L)),

        WordEntity(id = 34402, setId = 344, languagePair = "en-ru", rarity = "EPIC",
            original = "swap", transliteration = "[swɑp]", translation = "своп (обмен платежами)",
            definition = "A deal where two parties exchange streams of payments — fixed for floating, say.",
            definitionNative = "Сделка, где стороны обменивают потоки платежей — фиксированный на плавающий.",
            example = "Two banks signed a currency swap to manage their foreign loan exposure.",
            exampleNative = "Два банка подписали валютный swap для управления валютным риском.",
            pos = "noun", semanticGroup = "finance_derivatives", fillInBlankExclusions = listOf(34401L, 34403L, 34404L)),

        WordEntity(id = 34403, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "warrant", transliteration = "[ˈwɔrənt]", translation = "варрант (право купить акцию)",
            definition = "A long-dated right to buy company shares at a fixed price in the future.",
            definitionNative = "Долгосрочное право купить акции компании по фиксированной цене позже.",
            example = "Each bond came with a warrant letting holders buy stock at a discount.",
            exampleNative = "К каждой облигации прилагался warrant на покупку акций со скидкой.",
            pos = "noun", semanticGroup = "finance_derivatives", fillInBlankExclusions = listOf(34401L, 34402L, 34404L)),

        WordEntity(id = 34404, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tranche", transliteration = "[trɑnʃ]", translation = "транш (часть выпуска долга)",
            definition = "A portion of a loan or bond issue offered at different risk and return.",
            definitionNative = "Доля кредита или выпуска облигаций, отличающаяся риском и доходностью.",
            example = "The senior tranche carried lower yield but priority in repayment.",
            exampleNative = "Старший tranche нёс меньший доход, но первенство при выплате.",
            pos = "noun", semanticGroup = "finance_derivatives", fillInBlankExclusions = listOf(34401L, 34402L, 34403L)),

        WordEntity(id = 34405, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "fungible", transliteration = "[ˈfʌnʤəbəl]", translation = "взаимозаменяемый (актив)",
            definition = "Such that any unit equals any other — like one dollar to another dollar.",
            definitionNative = "Такой, что любая единица равна другой — как один доллар другому.",
            example = "Gold bars are fungible because each ounce trades for the same price.",
            exampleNative = "Золотые слитки fungible, потому что унция стоит одинаково везде.",
            pos = "adjective", semanticGroup = "finance_derivatives"),

        // ── finance_corporate_actions (5) ─────────────────────────────────

        WordEntity(id = 34406, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "spinoff", transliteration = "[ˈspɪnˌɔf]", translation = "выделение дочерней компании",
            definition = "When a parent company separates a unit into a new independent firm.",
            definitionNative = "Когда материнская фирма выделяет подразделение в отдельную независимую фирму.",
            example = "The retail spinoff began trading on the exchange under its own ticker.",
            exampleNative = "Розничный spinoff начал торговаться на бирже под своим тикером.",
            pos = "noun", semanticGroup = "finance_corporate_actions", fillInBlankExclusions = listOf(34407L, 34409L, 34410L)),

        WordEntity(id = 34407, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "recapitalization", transliteration = "[ˌrikæpɪtəlɪˈzeɪʃən]", translation = "реструктуризация капитала",
            definition = "A reshuffle of a firm's debt and equity to fix its balance sheet.",
            definitionNative = "Перестройка соотношения долга и доли в фирме для оздоровления баланса.",
            example = "The airline announced a recapitalization to replace expensive bonds with new ones.",
            exampleNative = "Авиакомпания объявила recapitalization, чтобы заменить дорогие облигации.",
            pos = "noun", semanticGroup = "finance_corporate_actions", fillInBlankExclusions = listOf(34402L, 34406L, 34409L, 34410L)),

        WordEntity(id = 34408, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "underwrite", transliteration = "[ˌʌndərˈraɪt]", translation = "выступать гарантом размещения",
            definition = "To guarantee the sale of a new issue of shares or bonds for a fee.",
            definitionNative = "Гарантировать размещение нового выпуска акций или облигаций за вознаграждение.",
            example = "Three banks agreed to underwrite the largest public offering of the year.",
            exampleNative = "Три банка согласились underwrite крупнейшее размещение года.",
            pos = "verb", semanticGroup = "finance_corporate_actions"),

        WordEntity(id = 34409, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "covenant", transliteration = "[ˈkʌvənənt]", translation = "ковенант (условие в кредитном договоре)",
            definition = "A binding promise in a loan deal — break it and the lender can recall the money.",
            definitionNative = "Обязательное условие в договоре займа: нарушишь — заимодавец отзовёт деньги.",
            example = "The bond covenant forbids the firm from paying any extra dividend this year.",
            exampleNative = "Облигационный covenant запрещает фирме платить лишний дивиденд в этом году.",
            pos = "noun", semanticGroup = "finance_corporate_actions", fillInBlankExclusions = listOf(34406L, 34407L, 34410L)),

        WordEntity(id = 34410, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "moratorium", transliteration = "[ˌmɔrəˈtɔriəm]", translation = "мораторий (временная отсрочка)",
            definition = "An official pause on payments or activity — usually during a crisis.",
            definitionNative = "Официальная пауза в платежах или деятельности — обычно во время кризиса.",
            example = "The government declared a moratorium on foreign debt repayments for six months.",
            exampleNative = "Правительство объявило moratorium на выплаты внешнего долга на полгода.",
            pos = "noun", semanticGroup = "finance_corporate_actions", fillInBlankExclusions = listOf(34406L, 34407L, 34409L)),

        // ── finance_risk_metrics (5) ──────────────────────────────────────

        WordEntity(id = 34411, setId = 344, languagePair = "en-ru", rarity = "EPIC",
            original = "liquidity", transliteration = "[lɪˈkwɪdɪti]", translation = "ликвидность (готовая денежность актива)",
            definition = "How easily an asset can be turned into cash without losing value.",
            definitionNative = "Как легко актив превратить в деньги, не потеряв в стоимости.",
            example = "The crisis exposed how poor the bank's liquidity really was.",
            exampleNative = "Кризис показал, насколько слаба была liquidity банка на деле.",
            pos = "noun", semanticGroup = "finance_risk_metrics", fillInBlankExclusions = listOf(34412L, 34413L, 34414L, 34415L)),

        WordEntity(id = 34412, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "solvency", transliteration = "[ˈsɑlvənsi]", translation = "платёжеспособность",
            definition = "The ability of a firm to meet its long-term debts as they fall due.",
            definitionNative = "Способность фирмы погашать долгосрочные долги по мере наступления срока.",
            example = "Auditors raised serious doubts about the firm's solvency after the loss.",
            exampleNative = "Аудиторы серьёзно усомнились в solvency фирмы после убытка.",
            pos = "noun", semanticGroup = "finance_risk_metrics", fillInBlankExclusions = listOf(34411L, 34413L, 34414L, 34415L)),

        WordEntity(id = 34413, setId = 344, languagePair = "en-ru", rarity = "EPIC",
            original = "volatility", transliteration = "[ˌvɑləˈtɪlɪti]", translation = "волатильность (изменчивость цены)",
            definition = "How sharply the price of an asset jumps up and down over time.",
            definitionNative = "Насколько резко цена актива скачет вверх и вниз со временем.",
            example = "Oil price volatility forced the airline to hedge its fuel costs.",
            exampleNative = "Сильная volatility цены нефти заставила авиакомпанию хеджировать топливо.",
            pos = "noun", semanticGroup = "finance_risk_metrics", fillInBlankExclusions = listOf(34411L, 34412L, 34414L, 34415L)),

        WordEntity(id = 34414, setId = 344, languagePair = "en-ru", rarity = "EPIC",
            original = "drawdown", transliteration = "[ˈdrɔˌdaʊn]", translation = "просадка (падение от пика)",
            definition = "The drop in a fund's value from its peak before a new high is reached.",
            definitionNative = "Падение стоимости фонда от пика до того, как достигнут новый максимум.",
            example = "The hedge fund suffered a thirty-percent drawdown during the spring crash.",
            exampleNative = "Хедж-фонд понёс drawdown в тридцать процентов во время весеннего обвала.",
            pos = "noun", semanticGroup = "finance_risk_metrics", fillInBlankExclusions = listOf(34411L, 34412L, 34413L, 34415L)),

        WordEntity(id = 34415, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "indemnity", transliteration = "[ɪnˈdɛmnɪti]", translation = "возмещение убытков (по договору)",
            definition = "A promise to pay for someone else's loss if a stated event happens.",
            definitionNative = "Обещание оплатить чужой убыток, если случится оговорённое событие.",
            example = "The contract required full indemnity for any harm caused by the agent.",
            exampleNative = "Договор требовал полное indemnity за любой вред, причинённый агентом.",
            pos = "noun", semanticGroup = "finance_risk_metrics", fillInBlankExclusions = listOf(34411L, 34412L, 34413L, 34414L)),

        // ── finance_archaic (5) ───────────────────────────────────────────

        WordEntity(id = 34416, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "usury", transliteration = "[ˈjuʒəri]", translation = "ростовщичество (грабительский процент)",
            definition = "The old sin of lending money at a cruelly high rate of return.",
            definitionNative = "Старинный грех — давать в долг под жестоко высокий процент.",
            example = "Medieval church law harshly condemned usury on Christian borrowers.",
            exampleNative = "Средневековое церковное право сурово осуждало usury с христиан.",
            pos = "noun", semanticGroup = "finance_archaic", fillInBlankExclusions = listOf(34417L, 34418L, 34419L, 34420L)),

        WordEntity(id = 34417, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bullion", transliteration = "[ˈbʊljən]", translation = "слитковое золото или серебро",
            definition = "Pure gold or silver in heavy bars, valued by weight rather than by stamp.",
            definitionNative = "Чистое золото или серебро в тяжёлых слитках, ценимое по весу, а не штампу.",
            example = "The vault held tons of bullion stacked under armed guard for decades.",
            exampleNative = "В хранилище лежали тонны bullion под вооружённой охраной десятки лет.",
            pos = "noun", semanticGroup = "finance_archaic", fillInBlankExclusions = listOf(34416L, 34418L, 34419L, 34420L)),

        WordEntity(id = 34418, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "specie", transliteration = "[ˈspiʃi]", translation = "звонкая монета (металлические деньги)",
            definition = "Hard money — coins of real metal — as opposed to paper notes.",
            definitionNative = "Твёрдые деньги — монеты из настоящего металла, в отличие от бумажных купюр.",
            example = "Travelers in old times carried specie hidden in money belts.",
            exampleNative = "В старые времена путники носили specie, спрятанное в поясах с деньгами.",
            pos = "noun", semanticGroup = "finance_archaic", fillInBlankExclusions = listOf(34416L, 34417L, 34419L, 34420L)),

        WordEntity(id = 34419, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "scrip", transliteration = "[skrɪp]", translation = "скрип (заменитель денег)",
            definition = "A paper certificate used in place of real money, often by a company or town.",
            definitionNative = "Бумажный сертификат вместо настоящих денег, часто от компании или городка.",
            example = "The mining town paid wages in scrip redeemable only at the company store.",
            exampleNative = "Шахтёрский городок платил жалование в scrip, годном лишь в магазине фирмы.",
            pos = "noun", semanticGroup = "finance_archaic", fillInBlankExclusions = listOf(34416L, 34417L, 34418L, 34420L)),

        WordEntity(id = 34420, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "escrow", transliteration = "[ˈɛskroʊ]", translation = "эскроу (условный счёт у посредника)",
            definition = "Money held by a neutral third party until the deal's terms are met.",
            definitionNative = "Деньги у нейтрального посредника до выполнения условий сделки.",
            example = "The buyer placed the down payment in escrow until the title was clear.",
            exampleNative = "Покупатель положил аванс в escrow, пока не очистится право собственности.",
            pos = "noun", semanticGroup = "finance_archaic", fillInBlankExclusions = listOf(34416L, 34417L, 34418L, 34419L)),

        // ── finance_markets (5) ───────────────────────────────────────────

        WordEntity(id = 34421, setId = 344, languagePair = "en-ru", rarity = "EPIC",
            original = "bear market", transliteration = "[bɛr ˈmɑrkɪt]", translation = "медвежий рынок (длительное падение)",
            definition = "A long stretch of falling prices on the stock exchange — gloom and selling.",
            definitionNative = "Долгий период падения цен на бирже — уныние и распродажи.",
            example = "Pension savings shrank as the bear market dragged on for two years.",
            exampleNative = "Пенсионные накопления таяли, пока bear market тянулся два года подряд.",
            pos = "noun", semanticGroup = "finance_markets", fillInBlankExclusions = listOf(34422L, 34423L, 34425L)),

        WordEntity(id = 34422, setId = 344, languagePair = "en-ru", rarity = "EPIC",
            original = "bull market", transliteration = "[bʊl ˈmɑrkɪt]", translation = "бычий рынок (длительный рост)",
            definition = "A long stretch of rising prices on the stock exchange — optimism and buying.",
            definitionNative = "Долгий период роста цен на бирже — оптимизм и активные покупки.",
            example = "Young investors had only ever seen a bull market until that crash.",
            exampleNative = "Молодые инвесторы видели только bull market — до того самого обвала.",
            pos = "noun", semanticGroup = "finance_markets", fillInBlankExclusions = listOf(34421L, 34423L, 34425L)),

        WordEntity(id = 34423, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hedge fund", transliteration = "[hɛʤ fʌnd]", translation = "хедж-фонд (агрессивный инвестфонд)",
            definition = "A private pool of money that uses bold strategies to chase high returns.",
            definitionNative = "Частный фонд, применяющий смелые стратегии ради высокой доходности.",
            example = "The hedge fund made a billion shorting the overheated property market.",
            exampleNative = "Hedge fund заработал миллиард, играя против перегретого рынка жилья.",
            pos = "noun", semanticGroup = "finance_markets", fillInBlankExclusions = listOf(34421L, 34422L, 34425L)),

        WordEntity(id = 34424, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "blue-chip", transliteration = "[ˈblu ʧɪp]", translation = "первоклассный (об акциях надёжных компаний)",
            definition = "Said of shares in big, steady companies trusted by careful investors.",
            definitionNative = "О акциях крупных, устойчивых компаний, которым доверяют осторожные инвесторы.",
            example = "Her grandmother bought blue-chip shares and never sold a single one.",
            exampleNative = "Её бабушка покупала blue-chip акции и не продала ни одной.",
            pos = "adjective", semanticGroup = "finance_markets", fillInBlankExclusions = listOf(34405L)),

        WordEntity(id = 34425, setId = 344, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bourse", transliteration = "[bʊrs]", translation = "биржа (европейская фондовая)",
            definition = "An old word for a stock exchange, used today mainly for European ones.",
            definitionNative = "Старинное название площадки для торговли ценными бумагами — чаще в Европе.",
            example = "Shares of the wine company first listed on the Paris bourse last spring.",
            exampleNative = "Акции винной компании впервые вышли на парижский bourse прошлой весной.",
            pos = "noun", semanticGroup = "finance_markets", fillInBlankExclusions = listOf(34421L, 34422L, 34423L)),
    )
}
