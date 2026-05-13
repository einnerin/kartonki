package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 468.
 * Финансы: рынки капитала и инвестиции (L4 / RARE + EPIC).
 *
 * Расширение темы «Финансы». Дополняет существующие сеты:
 *   - 24, 46, 61, 214 (общая бизнес/финансовая лексика).
 *   - 251        — банковская розничная лексика.
 *   - 343 (L1)   — деньги, монеты, простые операции.
 *   - 344 (L5)   — продвинутая академическая финтерминология.
 *
 * Подтема — финансовые рынки, ценные бумаги и инвестиции:
 *   инструменты (treasury bond, ETF, futures contract, commodity),
 *   события и действия (IPO, short selling, margin call),
 *   участники (broker, trader, regulator, market maker),
 *   метрики (P/E ratio, beta, dividend yield, spread),
 *   стратегии (asset allocation, portfolio diversification, risk premium).
 *
 * НЕ банковская розничная лексика (251), НЕ общая бизнес-лексика (24, 46),
 * НЕ продвинутые финансовые феномены (344: liquidity, volatility, swap...).
 *
 * Пять семантических групп:
 *   finance_markets_instruments  — treasury bond, mutual fund, ETF,
 *                                  futures contract, commodity, securities,
 *                                  call option, put option
 *   finance_markets_events       — IPO, short selling, speculation,
 *                                  margin call, prospectus
 *   finance_markets_participants — broker, trader, regulator, market maker
 *   finance_markets_metrics      — spread, dividend yield, P/E ratio,
 *                                  beta, market capitalization
 *   finance_markets_strategy     — asset allocation,
 *                                  portfolio diversification, risk premium
 *
 * Исключены из набора кандидатов (уже есть в других сетах):
 *   - stock, bond, share, equity, debenture (24, 46, 36, FinanceL5);
 *   - derivative, warrant, swap, tranche, hedge fund, bear market,
 *     bull market, liquidity, volatility, solvency, drawdown,
 *     contango, backwardation, bullion, recapitalization,
 *     underwrite, underwriter, moral hazard, fungibility (FinanceL5, 243);
 *   - leverage, valuation, hedging, capital gain, futures,
 *     portfolio, yield, arbitrage, dividend (46, 61, 214);
 *   - hedge, speculate (47 — communication verbs).
 *
 * Word IDs: 46801..46825 (setId × 100 + position).
 */
object WordDataEnglishFinanceMarkets {

    val sets = listOf(
        WordSetEntity(
            id = 468,
            name = "Финансы",
            description = "Рынки капитала и инвестиции: акции и облигации, опционы, биржевые игроки, метрики (IPO, ETF, broker, P/E ratio)",
            languagePair = "en-ru",
            orderIndex = 468,
            topic = "Финансы",
            level = 4,
        ),
    )

    val words = listOf(

        // ── finance_markets_instruments (инструменты рынка) ──────────────────
        WordEntity(
            id = 46801, original = "treasury bond", transliteration = "[ˈtrɛʒəri bɑːnd]", translation = "казначейская облигация",
            definition = "A long-term debt note issued by the government to finance public spending — paid back with interest.",
            definitionNative = "Долгосрочное долговое обязательство государства для финансирования бюджета — возвращается с процентами.",
            example = "Pension funds load up on treasury bond holdings whenever they need very safe income.",
            exampleNative = "Пенсионные фонды набирают treasury bond, когда нужен совсем безопасный поток дохода.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(46802L, 46803L, 46804L, 46805L, 46806L, 46807L, 46808L)),
        WordEntity(
            id = 46802, original = "mutual fund", transliteration = "[ˈmjuːtʃuəl fʌnd]", translation = "паевой инвестфонд",
            definition = "A pool of money from many people, run by a manager who buys a mix of shares and bonds.",
            definitionNative = "Объединённые деньги многих людей под управлением менеджера, покупающего набор акций и облигаций.",
            example = "Her father parked his savings in a low-fee mutual fund and barely glanced at it for years.",
            exampleNative = "Отец положил сбережения в дешёвый mutual fund и почти не заглядывал туда годами.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(46801L, 46803L, 46804L, 46805L, 46806L, 46807L, 46808L)),
        WordEntity(
            id = 46803, original = "ETF", transliteration = "[ˌiː tiː ˈɛf]", translation = "биржевой фонд",
            definition = "A basket of assets traded on an exchange like a single share, often tracking an index.",
            definitionNative = "Корзина активов, торгуемая на бирже как одна бумага; часто повторяет состав индекса.",
            example = "Most beginners start with a broad-market ETF and add individual picks only after gaining experience.",
            exampleNative = "Большинство новичков начинают с широкорыночного ETF и берут отдельные бумаги только потом.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(46801L, 46802L, 46804L, 46805L, 46806L, 46807L, 46808L)),
        WordEntity(
            id = 46804, original = "futures contract", transliteration = "[ˈfjuːtʃərz ˈkɒntrækt]", translation = "фьючерсный контракт",
            definition = "An agreement to buy or sell an asset at a fixed price on a set date later.",
            definitionNative = "Соглашение купить или продать актив по заранее оговорённой цене в назначенный день в будущем.",
            example = "Wheat farmers lock in prices through a futures contract before they even plant the spring crop.",
            exampleNative = "Фермеры фиксируют цены через futures contract ещё до того, как посадят весенний урожай.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(46801L, 46802L, 46803L, 46805L, 46806L, 46807L, 46808L)),
        WordEntity(
            id = 46805, original = "commodity", transliteration = "[kəˈmɒdɪti]", translation = "сырьевой товар",
            definition = "A raw or basic good like oil, gold or grain that is bought and sold in bulk worldwide.",
            definitionNative = "Сырьё или базовое благо вроде нефти, золота или зерна — продаётся оптом на мировых рынках.",
            example = "When tensions rise in the Gulf, every commodity tied to energy spikes within minutes of the news.",
            exampleNative = "При обострении в Заливе каждый commodity, связанный с энергией, прыгает в цене за минуты после новостей.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(46801L, 46802L, 46803L, 46804L, 46806L, 46807L, 46808L)),
        WordEntity(
            id = 46806, original = "securities", transliteration = "[sɪˈkjʊərɪtiz]", translation = "ценные бумаги",
            definition = "Tradable financial papers like shares or bonds that prove ownership or a right to be paid.",
            definitionNative = "Торгуемые финансовые документы (акции, облигации), удостоверяющие владение или право на платёж.",
            example = "The bank holds millions in client securities and reports every position to the regulator.",
            exampleNative = "Банк держит миллионы клиентских securities и отчитывается о каждой позиции регулятору.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(46801L, 46802L, 46803L, 46804L, 46805L, 46807L, 46808L)),
        WordEntity(
            id = 46807, original = "call option", transliteration = "[kɔːl ˈɒpʃən]", translation = "опцион на покупку",
            definition = "A paid right, but no duty, to buy an asset at a set price before a chosen date.",
            definitionNative = "Платное право, без обязанности, купить актив по заранее оговорённой цене до выбранной даты.",
            example = "He bought a cheap call option on Tesla and made a small fortune when the stock rallied.",
            exampleNative = "Он купил дешёвый call option на Tesla и заработал небольшое состояние, когда акция взлетела.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(46801L, 46802L, 46803L, 46804L, 46805L, 46806L, 46808L)),
        WordEntity(
            id = 46808, original = "put option", transliteration = "[pʊt ˈɒpʃən]", translation = "опцион на продажу",
            definition = "A paid right to sell an asset at a fixed price before a chosen date — protects against falls.",
            definitionNative = "Платное право продать актив по заранее оговорённой цене до выбранной даты; защищает от падения.",
            example = "Funds bought a put option on the index as cheap insurance against a sudden market drop.",
            exampleNative = "Фонды купили put option на индекс как дешёвую страховку от внезапного обвала рынка.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(46801L, 46802L, 46803L, 46804L, 46805L, 46806L, 46807L)),

        // ── finance_markets_events (события и действия на рынке) ─────────────
        WordEntity(
            id = 46809, original = "IPO", transliteration = "[ˌaɪ piː ˈoʊ]", translation = "первичное размещение акций",
            definition = "The first time a private company sells its shares to the public on an exchange.",
            definitionNative = "Первая продажа акций частной компании широкой публике через биржу.",
            example = "After the IPO the founders woke up as paper billionaires and the staff finally cashed out.",
            exampleNative = "После IPO основатели проснулись бумажными миллиардерами, а сотрудники наконец-то обналичили опционы.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(46810L, 46811L, 46812L, 46813L)),
        WordEntity(
            id = 46810, original = "short selling", transliteration = "[ʃɔːrt ˈsɛlɪŋ]", translation = "короткая продажа",
            definition = "Borrowing an asset, selling it now, and buying it back later — profitable only if the price falls.",
            definitionNative = "Заём актива, его немедленная продажа и обратный выкуп позже — выгодно только при падении цены.",
            example = "Hedge funds made fortunes through short selling in 2008 while ordinary investors lost their savings.",
            exampleNative = "Хедж-фонды заработали состояния через short selling в 2008-м, пока обычные инвесторы теряли сбережения.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(46809L, 46811L, 46812L, 46813L)),
        WordEntity(
            id = 46811, original = "margin call", transliteration = "[ˈmɑːrdʒɪn kɔːl]", translation = "требование пополнить счёт",
            definition = "An urgent demand from a broker to add money fast, or have your borrowed position closed.",
            definitionNative = "Срочное требование от брокера быстро довнести деньги, иначе позиция на заёмные средства закроется.",
            example = "By Friday afternoon the trader faced a brutal margin call and had to dump his best stocks.",
            exampleNative = "К пятнице трейдер получил жёсткий margin call и был вынужден сбросить лучшие свои акции.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(46809L, 46810L, 46812L, 46813L)),
        WordEntity(
            id = 46812, original = "prospectus", transliteration = "[prəˈspɛktəs]", translation = "проспект эмиссии",
            definition = "An official paper that tells investors what a new offering does, who runs it, and what could go wrong.",
            definitionNative = "Официальный документ, объясняющий инвесторам суть нового выпуска, состав управляющих и возможные риски.",
            example = "She read the entire prospectus twice and still felt the wording hid more than it revealed.",
            exampleNative = "Она прочитала весь prospectus дважды и всё равно чувствовала, что текст скрывает больше, чем раскрывает.",
            rarity = "EPIC", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(46809L, 46810L, 46811L, 46813L)),
        WordEntity(
            id = 46813, original = "speculation", transliteration = "[ˌspɛkjuˈleɪʃən]", translation = "спекуляция (биржевая)",
            definition = "Quick, risky buying and selling aimed at fast gains from price swings rather than long-term value.",
            definitionNative = "Быстрая рискованная купля-продажа ради скорой прибыли от колебаний цен, а не от долгого роста стоимости.",
            example = "Pure speculation drives most crypto rallies, and that is exactly why the crashes hit so hard.",
            exampleNative = "Чистая speculation двигает большинство криптовалютных взлётов, и именно поэтому обвалы бьют так сильно.",
            rarity = "EPIC", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(46809L, 46810L, 46811L, 46812L)),

        // ── finance_markets_participants (участники рынка) ───────────────────
        WordEntity(
            id = 46814, original = "broker", transliteration = "[ˈbroʊkər]", translation = "брокер",
            definition = "A licensed middleman who places orders to buy or sell securities on behalf of a client.",
            definitionNative = "Лицензированный посредник, размещающий заявки на покупку или продажу ценных бумаг от имени клиента.",
            example = "Her broker called at six in the morning with a hot tip she immediately decided to ignore.",
            exampleNative = "Её broker позвонил в шесть утра с горячей наводкой, которую она сразу решила проигнорировать.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_participants", fillInBlankExclusions = listOf(46815L, 46816L, 46817L)),
        WordEntity(
            id = 46815, original = "trader", transliteration = "[ˈtreɪdər]", translation = "трейдер",
            definition = "A person who buys and sells assets for a living, often dozens of times in a single day.",
            definitionNative = "Человек, для которого купля-продажа активов — работа, часто десятки сделок в течение одного дня.",
            example = "A burnt-out trader from Goldman quit at thirty-two and opened a quiet bakery in Vermont.",
            exampleNative = "Выгоревший trader из Goldman уволился в тридцать два и открыл тихую пекарню в Вермонте.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_participants", fillInBlankExclusions = listOf(46814L, 46816L, 46817L)),
        WordEntity(
            id = 46816, original = "regulator", transliteration = "[ˈrɛɡjəleɪtər]", translation = "регулятор",
            definition = "A government body that writes rules for the markets and punishes firms that break them.",
            definitionNative = "Государственный орган, пишущий правила работы рынков и наказывающий фирмы за их нарушение.",
            example = "The regulator fined the firm two billion dollars after years of inflated quarterly reports came out.",
            exampleNative = "Regulator оштрафовал фирму на два миллиарда долларов после раскрытия многолетних завышенных квартальных отчётов.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_participants", fillInBlankExclusions = listOf(46814L, 46815L, 46817L)),
        WordEntity(
            id = 46817, original = "market maker", transliteration = "[ˈmɑːrkɪt ˈmeɪkər]", translation = "маркет-мейкер",
            definition = "A firm that always quotes both a buy and a sell price, keeping trading smooth even in quiet hours.",
            definitionNative = "Фирма, всегда выставляющая встречные цены на покупку и продажу — обеспечивает плавную торговлю.",
            example = "Without a serious market maker, the spreads on small-cap shares would balloon to ten percent.",
            exampleNative = "Без серьёзного market maker спреды на акции малых компаний раздувались бы до десяти процентов.",
            rarity = "EPIC", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_participants", fillInBlankExclusions = listOf(46814L, 46815L, 46816L)),

        // ── finance_markets_metrics (метрики и аналитика) ────────────────────
        WordEntity(
            id = 46818, original = "spread", transliteration = "[sprɛd]", translation = "спред",
            definition = "The gap between the highest price buyers offer and the lowest price sellers ask for.",
            definitionNative = "Разрыв между самой высокой ценой покупателей и самой низкой ценой продавцов.",
            example = "On thin markets the spread can swallow your profit before the position is even fully opened.",
            exampleNative = "На неликвидных рынках spread может съесть прибыль ещё до полного открытия позиции.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_metrics", fillInBlankExclusions = listOf(46819L, 46820L, 46821L, 46822L)),
        WordEntity(
            id = 46819, original = "dividend yield", transliteration = "[ˈdɪvɪdɛnd jiːld]", translation = "дивидендная доходность",
            definition = "Yearly cash payment from a share divided by its current price, shown as a percent.",
            definitionNative = "Годовая выплата по акции, делённая на её текущую цену, выраженная в процентах.",
            example = "Utility shares attract retirees because a steady dividend yield beats almost any bank deposit.",
            exampleNative = "Акции коммунальных компаний привлекают пенсионеров: стабильный dividend yield обыгрывает почти любой банковский вклад.",
            rarity = "RARE", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_metrics", fillInBlankExclusions = listOf(46818L, 46820L, 46821L, 46822L)),
        WordEntity(
            id = 46820, original = "P/E ratio", transliteration = "[ˌpiː ˈiː ˈreɪʃioʊ]", translation = "коэффициент цена/прибыль",
            definition = "Share price divided by yearly earnings per share — shows how much investors pay for one dollar of profit.",
            definitionNative = "Цена акции, делённая на её годовой доход; показывает, сколько платят за доллар заработка компании.",
            example = "Tech darlings often trade at a P/E ratio of fifty, while old industrials hover around twelve.",
            exampleNative = "Любимцы техсектора часто торгуются с P/E ratio в пятьдесят, а старые промышленники — около двенадцати.",
            rarity = "EPIC", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_metrics", fillInBlankExclusions = listOf(46818L, 46819L, 46821L, 46822L)),
        WordEntity(
            id = 46821, original = "beta", transliteration = "[ˈbeɪtə]", translation = "коэффициент бета",
            definition = "A number showing how much a share moves compared to the wider market — above one means more swings.",
            definitionNative = "Число, показывающее, насколько акция колеблется относительно широкого рынка; больше единицы — сильнее.",
            example = "Tech stocks carry a high beta, shooting up in good years and crashing in bad ones.",
            exampleNative = "У техакций высокая beta — они стреляют в хорошие годы и проваливаются в плохие.",
            rarity = "EPIC", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_metrics", fillInBlankExclusions = listOf(46818L, 46819L, 46820L, 46822L)),
        WordEntity(
            id = 46822, original = "market capitalization", transliteration = "[ˈmɑːrkɪt ˌkæpɪtəlaɪˈzeɪʃən]", translation = "рыночная капитализация",
            definition = "The total dollar value of all shares of a company that are out in the public market.",
            definitionNative = "Совокупная долларовая стоимость всех акций компании, находящихся в свободном обращении.",
            example = "Apple's market capitalization passed three trillion dollars and briefly topped the GDP of France.",
            exampleNative = "Market capitalization Apple перевалила за три триллиона и ненадолго превзошла ВВП Франции.",
            rarity = "EPIC", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_metrics", fillInBlankExclusions = listOf(46818L, 46819L, 46820L, 46821L)),

        // ── finance_markets_strategy (стратегия портфеля) ────────────────────
        WordEntity(
            id = 46823, original = "asset allocation", transliteration = "[ˈæsɛt ˌæləˈkeɪʃən]", translation = "распределение активов",
            definition = "Splitting your money between shares, bonds and cash to match the level of risk you can stomach.",
            definitionNative = "Деление денег между акциями, облигациями и наличными согласно уровню риска, который вы готовы нести.",
            example = "A sensible asset allocation for a sixty-year-old leans heavily on bonds and keeps shares modest.",
            exampleNative = "Разумный asset allocation для шестидесятилетнего сильно опирается на облигации и держит акции скромно.",
            rarity = "EPIC", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_strategy", fillInBlankExclusions = listOf(46824L, 46825L)),
        WordEntity(
            id = 46824, original = "portfolio diversification", transliteration = "[pɔːrtˈfoʊlioʊ daɪˌvɜːrsɪfɪˈkeɪʃən]", translation = "диверсификация портфеля",
            definition = "Spreading your money across many unrelated assets so that one bad bet cannot wipe everything out.",
            definitionNative = "Распределение денег по множеству несвязанных активов — чтобы одна неудачная ставка не уничтожила всё.",
            example = "Proper portfolio diversification saved her retirement when two favourite stocks went bust.",
            exampleNative = "Грамотная portfolio diversification спасла её пенсию, когда две любимые акции обанкротились.",
            rarity = "EPIC", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_strategy", fillInBlankExclusions = listOf(46823L, 46825L)),
        WordEntity(
            id = 46825, original = "risk premium", transliteration = "[rɪsk ˈpriːmiəm]", translation = "премия за риск",
            definition = "The extra return investors demand for owning a risky asset over a safe one like a government bond.",
            definitionNative = "Дополнительная доходность, которую инвесторы требуют за рисковый актив сверх безопасного, например государственной облигации.",
            example = "The risk premium on emerging markets shrank for years and then exploded again during the war.",
            exampleNative = "Risk premium на развивающиеся рынки годами сжимался, а затем снова взорвался во время войны.",
            rarity = "EPIC", setId = 468, languagePair = "en-ru", pos = "noun",
            semanticGroup = "finance_markets_strategy", fillInBlankExclusions = listOf(46823L, 46824L)),
    )
}
