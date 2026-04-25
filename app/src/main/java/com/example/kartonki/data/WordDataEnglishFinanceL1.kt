package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Финансы (level 1, базовый/детский).
 *
 * Set 343: «Финансы: основы» — самая простая денежная лексика
 * для бытовых ситуаций (A1, COMMON-доминантный сет).
 *
 * Распределение редкости: 13 COMMON + 12 UNCOMMON — два смежных уровня шкалы.
 *
 * Дополняет уже существующие сеты темы «Финансы»:
 *   - Set 251 (WordDataEnglishBatch3.kt)    — L2 банковская повседневная лексика.
 *   - Set 214 (WordDataEnglishExpanded.kt)  — L3 бизнес и экономика.
 *   - Set 61  (WordDataEnglish.kt)          — L4 деловая лексика.
 *
 * Слова setId=343 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   finance_money_types  — coin, banknote, dollar, ruble, cent
 *   finance_actions      — save, lend, owe, donate, inherit
 *   finance_concepts     — credit, payment, wealth, rich, poor
 *   finance_people       — banker, teller, cashier, buyer, seller
 *   finance_everyday     — credit card, piggy bank, gift card, exchange rate, purchase
 *
 * Word IDs: 34301..34325 (setId × 100 + position).
 */
object WordDataEnglishFinanceL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 343, name = "Финансы",
            description = "Базовая лексика про деньги, покупки и счета для повседневных разговоров",
            languagePair = "en-ru",
            topic = "Финансы", level = 1),
    )

    val words: List<WordEntity> = listOf(

        // ── finance_money_types (5) ───────────────────────────────────────

        WordEntity(id = 34301, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "coin", transliteration = "[kɔɪn]", translation = "монета",
            definition = "A small round piece of metal used as money in shops.",
            definitionNative = "Маленький круглый кусочек металла, который используют как деньги в магазинах.",
            example = "She dropped a shiny coin into the wishing well.",
            exampleNative = "Она бросила блестящую coin в фонтан желаний.",
            pos = "noun", semanticGroup = "finance_money_types",
            fillInBlankExclusions = listOf(34302L, 34303L, 34304L, 34305L)),

        WordEntity(id = 34302, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "banknote", transliteration = "[ˈbæŋkˌnoʊt]", translation = "банкнота, бумажные деньги",
            definition = "A piece of paper money you keep in your wallet.",
            definitionNative = "Бумажные деньги, которые лежат в кошельке.",
            example = "He handed the cashier a crisp twenty-dollar banknote.",
            exampleNative = "Он протянул кассиру свежую banknote в двадцать долларов.",
            pos = "noun", semanticGroup = "finance_money_types",
            fillInBlankExclusions = listOf(34301L, 34303L, 34304L, 34305L)),

        WordEntity(id = 34303, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "dollar", transliteration = "[ˈdɑlər]", translation = "доллар",
            definition = "The main money used in the United States and some other countries.",
            definitionNative = "Главные деньги США и некоторых других стран.",
            example = "A small bottle of water costs only one dollar at this shop.",
            exampleNative = "Маленькая бутылка воды стоит всего один dollar в этом магазине.",
            pos = "noun", semanticGroup = "finance_money_types",
            fillInBlankExclusions = listOf(34301L, 34302L, 34304L, 34305L)),

        WordEntity(id = 34304, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "ruble", transliteration = "[ˈrubəl]", translation = "рубль",
            definition = "The main money used in Russia and a few neighbouring countries.",
            definitionNative = "Главные деньги России и нескольких соседних стран.",
            example = "A loaf of bread costs about one ruble in the village shop.",
            exampleNative = "Буханка хлеба стоит примерно один ruble в сельском магазине.",
            pos = "noun", semanticGroup = "finance_money_types",
            fillInBlankExclusions = listOf(34301L, 34302L, 34303L, 34305L)),

        WordEntity(id = 34305, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "cent", transliteration = "[sɛnt]", translation = "цент",
            definition = "A small unit of money — one hundred make a dollar or a euro.",
            definitionNative = "Маленькая денежная единица — сто штук образуют доллар или евро.",
            example = "The candy at this shop costs only one cent each.",
            exampleNative = "Конфетка в этом магазине стоит всего один cent.",
            pos = "noun", semanticGroup = "finance_money_types",
            fillInBlankExclusions = listOf(34301L, 34302L, 34303L, 34304L)),

        // ── finance_actions (5) ───────────────────────────────────────────

        WordEntity(id = 34306, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "save", transliteration = "[seɪv]", translation = "копить, откладывать (деньги)",
            definition = "To put money aside instead of spending it now.",
            definitionNative = "Откладывать деньги, а не тратить их сразу.",
            example = "I want to save some money every month for a long holiday.",
            exampleNative = "Я хочу save немного денег каждый месяц на долгий отпуск.",
            pos = "verb", semanticGroup = "finance_actions",
            fillInBlankExclusions = listOf(34307L, 34308L, 34309L, 34310L)),

        WordEntity(id = 34307, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "lend", transliteration = "[lɛnd]", translation = "одалживать (давать в долг)",
            definition = "To give something to someone for a while, expecting them to give it back.",
            definitionNative = "Дать что-то на время, ожидая, что человек вернёт это позже.",
            example = "Could you lend me ten dollars until tomorrow?",
            exampleNative = "Можешь lend мне десять долларов до завтра?",
            pos = "verb", semanticGroup = "finance_actions",
            fillInBlankExclusions = listOf(34306L, 34308L, 34309L, 34310L)),

        WordEntity(id = 34308, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "owe", transliteration = "[oʊ]", translation = "быть должным (деньги)",
            definition = "To need to give money back to someone who helped you.",
            definitionNative = "Нужно вернуть кому-то деньги, которые он тебе дал.",
            example = "I still owe my brother thirty dollars from last week.",
            exampleNative = "Я всё ещё owe брату тридцать долларов с прошлой недели.",
            pos = "verb", semanticGroup = "finance_actions",
            fillInBlankExclusions = listOf(34306L, 34307L, 34309L, 34310L)),

        WordEntity(id = 34309, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "donate", transliteration = "[ˈdoʊneɪt]", translation = "жертвовать, дарить (на благое дело)",
            definition = "To give money or things to help people in need.",
            definitionNative = "Отдать деньги или вещи, чтобы помочь нуждающимся.",
            example = "Many families donate old clothes to the local shelter.",
            exampleNative = "Много семей donate старую одежду в местный приют.",
            pos = "verb", semanticGroup = "finance_actions",
            fillInBlankExclusions = listOf(34306L, 34307L, 34308L, 34310L)),

        WordEntity(id = 34310, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "inherit", transliteration = "[ɪnˈhɛrɪt]", translation = "получать в наследство",
            definition = "To get money or things from someone after they die.",
            definitionNative = "Получить деньги или вещи от человека после его смерти.",
            example = "He hopes to inherit the family farm from his elderly father.",
            exampleNative = "Он надеется inherit семейную ферму от своего пожилого отца.",
            pos = "verb", semanticGroup = "finance_actions",
            fillInBlankExclusions = listOf(34306L, 34307L, 34308L, 34309L)),

        // ── finance_concepts (5) ──────────────────────────────────────────

        WordEntity(id = 34311, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "credit", transliteration = "[ˈkrɛdɪt]", translation = "кредит (взятые в долг деньги)",
            definition = "Money a bank lets you use now and pay back later.",
            definitionNative = "Деньги, которые банк даёт сейчас, а вернуть нужно позже.",
            example = "He bought a new fridge on credit and pays a little each month.",
            exampleNative = "Он купил новый холодильник в credit и платит понемногу каждый месяц.",
            pos = "noun", semanticGroup = "finance_concepts",
            fillInBlankExclusions = listOf(34312L, 34313L, 34314L, 34315L)),

        WordEntity(id = 34312, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "payment", transliteration = "[ˈpeɪmənt]", translation = "платёж, оплата",
            definition = "An amount of money you give for something you bought.",
            definitionNative = "Сумма денег, которую отдают за купленную вещь или услугу.",
            example = "The first payment for the car is due next Friday.",
            exampleNative = "Первый payment за машину нужно сделать в следующую пятницу.",
            pos = "noun", semanticGroup = "finance_concepts",
            fillInBlankExclusions = listOf(34311L, 34313L, 34314L, 34315L)),

        WordEntity(id = 34313, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wealth", transliteration = "[wɛlθ]", translation = "богатство, благосостояние",
            definition = "A large amount of money and valuable things that someone has.",
            definitionNative = "Большое количество денег и ценных вещей у человека.",
            example = "The family built their wealth slowly over many years of hard work.",
            exampleNative = "Семья построила своё wealth медленно за долгие годы упорного труда.",
            pos = "noun", semanticGroup = "finance_concepts",
            fillInBlankExclusions = listOf(34311L, 34312L, 34314L, 34315L)),

        WordEntity(id = 34314, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "rich", transliteration = "[rɪʧ]", translation = "богатый",
            definition = "Having a lot of money and nice things.",
            definitionNative = "У кого много денег и хороших вещей.",
            example = "Her uncle is rich and lives in a very big house by the sea.",
            exampleNative = "Её дядя rich и живёт в очень большом доме у моря.",
            pos = "adjective", semanticGroup = "finance_concepts",
            fillInBlankExclusions = listOf(34311L, 34312L, 34313L, 34315L)),

        WordEntity(id = 34315, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "poor", transliteration = "[pʊr]", translation = "бедный",
            definition = "Having very little money and few things.",
            definitionNative = "У кого очень мало денег и совсем немного вещей.",
            example = "The poor old man had only one warm coat for the winter.",
            exampleNative = "У poor старика была только одна тёплая куртка на зиму.",
            pos = "adjective", semanticGroup = "finance_concepts",
            fillInBlankExclusions = listOf(34311L, 34312L, 34313L, 34314L)),

        // ── finance_people (5) ────────────────────────────────────────────

        WordEntity(id = 34316, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "banker", transliteration = "[ˈbæŋkər]", translation = "банкир",
            definition = "A person whose job is running a bank or working with money there.",
            definitionNative = "Человек, чья работа — управлять банком или работать с деньгами в банке.",
            example = "The banker explained the loan terms in simple words to the young couple.",
            exampleNative = "Banker объяснил условия кредита простыми словами молодой паре.",
            pos = "noun", semanticGroup = "finance_people",
            fillInBlankExclusions = listOf(34317L, 34318L, 34319L, 34320L)),

        WordEntity(id = 34317, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "teller", transliteration = "[ˈtɛlər]", translation = "кассир в банке, банковский служащий",
            definition = "The bank worker behind the counter who takes and gives out cash.",
            definitionNative = "Работник банка за стойкой, который принимает и выдаёт наличные.",
            example = "The teller counted the bills twice before handing them to me.",
            exampleNative = "Teller дважды пересчитал купюры, прежде чем передать их мне.",
            pos = "noun", semanticGroup = "finance_people",
            fillInBlankExclusions = listOf(34316L, 34318L, 34319L, 34320L)),

        WordEntity(id = 34318, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "cashier", transliteration = "[kæˈʃɪr]", translation = "кассир (в магазине)",
            definition = "The person at the till in a shop who takes your money.",
            definitionNative = "Человек на кассе в магазине, который принимает у тебя деньги.",
            example = "The friendly cashier smiled and gave back my change.",
            exampleNative = "Приветливый cashier улыбнулся и отдал мне сдачу.",
            pos = "noun", semanticGroup = "finance_people",
            fillInBlankExclusions = listOf(34316L, 34317L, 34319L, 34320L)),

        WordEntity(id = 34319, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "buyer", transliteration = "[ˈbaɪər]", translation = "покупатель",
            definition = "A person who pays to get something from a seller.",
            definitionNative = "Человек, который платит и получает что-то от продавца.",
            example = "The buyer agreed on the price and shook hands with the farmer.",
            exampleNative = "Buyer согласился с ценой и пожал руку фермеру.",
            pos = "noun", semanticGroup = "finance_people",
            fillInBlankExclusions = listOf(34316L, 34317L, 34318L, 34320L)),

        WordEntity(id = 34320, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "seller", transliteration = "[ˈsɛlər]", translation = "продавец",
            definition = "A person who offers something for money.",
            definitionNative = "Человек, который предлагает что-то за деньги.",
            example = "The seller showed us three cars before we picked one.",
            exampleNative = "Seller показал нам три машины, прежде чем мы выбрали одну.",
            pos = "noun", semanticGroup = "finance_people",
            fillInBlankExclusions = listOf(34316L, 34317L, 34318L, 34319L)),

        // ── finance_everyday (5) ──────────────────────────────────────────

        WordEntity(id = 34321, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "credit card", transliteration = "[ˈkrɛdɪt kɑrd]", translation = "кредитная карта",
            definition = "A small plastic card you use to pay now and the bank covers it for a while.",
            definitionNative = "Маленькая пластиковая карта: платишь сейчас, а банк покрывает на время.",
            example = "He paid for the dinner with his credit card and tipped in cash.",
            exampleNative = "Он оплатил ужин credit card, а чаевые оставил наличными.",
            pos = "noun", semanticGroup = "finance_everyday",
            fillInBlankExclusions = listOf(34322L, 34323L, 34324L, 34325L)),

        WordEntity(id = 34322, setId = 343, languagePair = "en-ru", rarity = "COMMON",
            original = "piggy bank", transliteration = "[ˈpɪɡi bæŋk]", translation = "копилка (детская)",
            definition = "A small box, often shaped like a pig, where children drop coins.",
            definitionNative = "Маленькая ёмкость, часто в форме свинки, куда дети бросают монетки.",
            example = "The little girl shook her piggy bank to count the coins inside.",
            exampleNative = "Маленькая девочка потрясла свою piggy bank, чтобы пересчитать монеты внутри.",
            pos = "noun", semanticGroup = "finance_everyday",
            fillInBlankExclusions = listOf(34321L, 34323L, 34324L, 34325L)),

        WordEntity(id = 34323, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "gift card", transliteration = "[ɡɪft kɑrd]", translation = "подарочная карта",
            definition = "A card with money on it that you give as a present to spend in a shop.",
            definitionNative = "Карта с деньгами на ней: её дарят, чтобы человек потратил их в магазине.",
            example = "She gave her nephew a gift card for his favourite bookshop.",
            exampleNative = "Она подарила племяннику gift card в его любимый книжный магазин.",
            pos = "noun", semanticGroup = "finance_everyday",
            fillInBlankExclusions = listOf(34321L, 34322L, 34324L, 34325L)),

        WordEntity(id = 34324, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "exchange rate", transliteration = "[ɪksˈʧeɪnʤ reɪt]", translation = "курс обмена валют",
            definition = "How much of one country's money you get for another country's money.",
            definitionNative = "Сколько денег одной страны дают за деньги другой страны.",
            example = "The exchange rate was good, so she changed her money at the airport.",
            exampleNative = "Exchange rate был хороший, поэтому она поменяла деньги в аэропорту.",
            pos = "noun", semanticGroup = "finance_everyday",
            fillInBlankExclusions = listOf(34321L, 34322L, 34323L, 34325L)),

        WordEntity(id = 34325, setId = 343, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "purchase", transliteration = "[ˈpɜrʧəs]", translation = "покупка (приобретённый товар)",
            definition = "A thing that someone has paid money to get.",
            definitionNative = "Вещь, за которую человек заплатил деньги, чтобы получить.",
            example = "She showed her friend the new purchase from the weekend market.",
            exampleNative = "Она показала подруге новую purchase с воскресного рынка.",
            pos = "noun", semanticGroup = "finance_everyday",
            fillInBlankExclusions = listOf(34321L, 34322L, 34323L, 34324L)),
    )
}
