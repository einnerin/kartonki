package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — «Городская жизнь и услуги», level 2 (продвинутый базовый).
 *
 * Set 366: терминалы, посылки, рецепты, билеты, парковка — бытовые услуги
 * в городской среде. Дополняет L1 (set 365), даёт продвинутую лексику для
 * самостоятельного решения городских задач.
 *
 * Распределение редкости: 13 UNCOMMON + 12 RARE — два смежных уровня шкалы.
 *
 * SemanticGroups (5 × 5):
 *   city_money          — банкомат, снятие, пополнение, номер счёта, обменник
 *   city_post           — трекинг, окно доставки, наклейка возврата, ПВЗ, отправка
 *   city_pharmacy       — обезболивающее, без рецепта, капли, повтор, листок
 *   city_transport_pay  — проездной, разовый, месячный, штраф, сезонный
 *   city_parking        — паркомат, разрешение, штраф-талон, платная, эвакуатор
 *
 * Не пересекается с L1 (365), Финансы (343/251/214/61), Шоппинг (364/...),
 * Транспорт (228/229) — дубли проверены grep по `original`.
 *
 * isFillInBlankSafe = false для всех 25 слов: тематически близкие соседи
 * по подгруппе создают неоднозначные пропуски (paid parking ↔ parking permit,
 * tracking number ↔ delivery slot и т.д.).
 *
 * Word IDs: 36601..36625 (setId × 100 + position).
 */
object WordDataEnglishCityLifeL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 366,
            languagePair = "en-ru",
            orderIndex = 366,
            name = "Городская жизнь и услуги",
            description = "Продвинутый базовый: терминалы, посылки, рецепты, билеты, парковка",
            topic = "Городская жизнь и услуги",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── city_money (5) ────────────────────────────────────────────────

        WordEntity(id = 36601, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cashpoint", transliteration = "[ˈkæʃˌpɔɪnt]", translation = "банкомат (BrE)",
            definition = "A wall machine in Britain that hands out money from your bank.",
            definitionNative = "Машина в стене на улице Британии, выдающая наличные с твоего счёта.",
            example = "I'll grab some money from the cashpoint near the station.",
            exampleNative = "Сниму деньги в cashpoint возле вокзала.",
            pos = "noun", semanticGroup = "city_money", fillInBlankExclusions = listOf(36602L, 36603L, 36604L, 36605L)),

        WordEntity(id = 36602, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "withdrawal", transliteration = "[wɪðˈdrɔːəl]", translation = "снятие наличных",
            definition = "Taking your own cash out of a bank account.",
            definitionNative = "Получение собственных денег со счёта в банке.",
            example = "There's a small fee for every withdrawal at this machine.",
            exampleNative = "За каждое withdrawal в этом банкомате берут небольшую комиссию.",
            pos = "noun", semanticGroup = "city_money", fillInBlankExclusions = listOf(36601L, 36603L, 36604L, 36605L, 36614L)),

        WordEntity(id = 36603, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "top-up", transliteration = "[ˈtɒp ʌp]", translation = "пополнение (карты, счёта)",
            definition = "Adding more money or credit to a card or phone.",
            definitionNative = "Добавление денег или средств на карту, телефон или счёт.",
            example = "She bought a ten-pound top-up for her travel card.",
            exampleNative = "Она купила top-up на десять фунтов для своей карты.",
            pos = "noun", semanticGroup = "city_money", fillInBlankExclusions = listOf(36601L, 36602L, 36604L, 36605L, 36614L)),

        WordEntity(id = 36604, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "account number", transliteration = "[əˈkaʊnt ˈnʌmbər]", translation = "номер счёта",
            definition = "A long string of digits that identifies your bank place.",
            definitionNative = "Длинная цифровая строка, по которой банк находит твои деньги.",
            example = "Please write the account number on the back of the cheque.",
            exampleNative = "Напишите account number на обратной стороне чека.",
            pos = "noun", semanticGroup = "city_money", fillInBlankExclusions = listOf(36601L, 36602L, 36603L, 36605L, 36606L)),

        WordEntity(id = 36605, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "bureau de change", transliteration = "[bjʊˌroʊ də ˈʃɒnʒ]", translation = "обменный пункт",
            definition = "A small shop where travellers swap one country's money for another.",
            definitionNative = "Маленькая контора, где путешественники меняют деньги одной страны на другие.",
            example = "We changed our pounds at a tiny bureau de change near the airport.",
            exampleNative = "Мы поменяли фунты в маленьком bureau de change у аэропорта.",
            pos = "noun", semanticGroup = "city_money", fillInBlankExclusions = listOf(36601L, 36602L, 36603L, 36604L)),

        // ── city_post (5) ─────────────────────────────────────────────────

        WordEntity(id = 36606, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tracking number", transliteration = "[ˈtrækɪŋ ˈnʌmbər]", translation = "номер отслеживания",
            definition = "A code that lets you watch a package travel from sender to door.",
            definitionNative = "Код, по которому видно путь посылки от отправителя до двери.",
            example = "She typed the tracking number into the website to check progress.",
            exampleNative = "Она ввела tracking number на сайте, чтобы проверить путь посылки.",
            pos = "noun", semanticGroup = "city_post", fillInBlankExclusions = listOf(36604L, 36607L, 36608L, 36609L, 36610L)),

        WordEntity(id = 36607, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "delivery slot", transliteration = "[dɪˈlɪvəri slɒt]", translation = "временное окно доставки",
            definition = "A two-hour window when the courier promises to bring your package.",
            definitionNative = "Двухчасовой промежуток, когда курьер обещает привезти твою посылку.",
            example = "I picked an evening delivery slot so someone would be home.",
            exampleNative = "Я выбрал вечернее delivery slot, чтобы кто-то был дома.",
            pos = "noun", semanticGroup = "city_post", fillInBlankExclusions = listOf(36606L, 36608L, 36609L, 36610L)),

        WordEntity(id = 36608, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "return label", transliteration = "[rɪˈtɜːrn ˈleɪbəl]", translation = "наклейка для возврата",
            definition = "A printed sticker you put on a parcel to send it back to the seller.",
            definitionNative = "Печатная наклейка на посылку, чтобы отправить её обратно продавцу.",
            example = "The shoes didn't fit, so I stuck the return label on the box.",
            exampleNative = "Туфли не подошли, и я наклеил return label на коробку.",
            pos = "noun", semanticGroup = "city_post", fillInBlankExclusions = listOf(36606L, 36607L, 36609L, 36610L)),

        WordEntity(id = 36609, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "pickup point", transliteration = "[ˈpɪkʌp pɔɪnt]", translation = "пункт выдачи",
            definition = "A nearby shop where parcels wait until you collect them.",
            definitionNative = "Ближайший магазин, где посылки ждут, пока ты их заберёшь.",
            example = "My new shoes are waiting at the pickup point on Main Street.",
            exampleNative = "Мои новые туфли ждут в pickup point на Мэйн-стрит.",
            pos = "noun", semanticGroup = "city_post", fillInBlankExclusions = listOf(36601L, 36605L, 36606L, 36607L, 36608L, 36610L)),

        WordEntity(id = 36610, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "postage", transliteration = "[ˈpoʊstɪdʒ]", translation = "стоимость пересылки",
            definition = "The money charged for sending a letter or package by mail.",
            definitionNative = "Деньги, которые платят за отправку письма или коробки по почте.",
            example = "The postage to Australia was higher than the gift itself.",
            exampleNative = "Postage в Австралию оказался дороже, чем сам подарок.",
            pos = "noun", semanticGroup = "city_post", fillInBlankExclusions = listOf(36606L, 36607L, 36608L, 36609L)),

        // ── city_pharmacy (5) ─────────────────────────────────────────────

        WordEntity(id = 36611, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "painkiller", transliteration = "[ˈpeɪnˌkɪlər]", translation = "обезболивающее",
            definition = "A pill or syrup that takes away aches in your head, back or teeth.",
            definitionNative = "Таблетка или сироп, убирающий боль в голове, спине или зубах.",
            example = "She took a painkiller and lay down for half an hour.",
            exampleNative = "Она приняла painkiller и легла на полчаса.",
            pos = "noun", semanticGroup = "city_pharmacy", fillInBlankExclusions = listOf(36614L, 36615L)),

        WordEntity(id = 36612, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "over-the-counter", transliteration = "[ˌoʊvər ðə ˈkaʊntər]", translation = "без рецепта (о лекарстве)",
            definition = "Sold freely in a chemist — no doctor's note needed.",
            definitionNative = "Продаётся свободно в аптеке — справка от врача не нужна.",
            example = "These tablets are over-the-counter, so anyone can buy them.",
            exampleNative = "Эти таблетки over-the-counter, их может купить любой.",
            pos = "adjective", semanticGroup = "city_pharmacy"),

        WordEntity(id = 36613, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "eye drops", transliteration = "[aɪ drɒps]", translation = "глазные капли",
            definition = "A small bottle of liquid you squeeze into red or tired eyes.",
            definitionNative = "Маленький флакон жидкости, который капают в красные или уставшие глаза.",
            example = "The chemist suggested some eye drops for my dry eyes.",
            exampleNative = "Аптекарь предложил eye drops от сухости глаз.",
            pos = "noun", semanticGroup = "city_pharmacy", fillInBlankExclusions = listOf(36611L, 36614L, 36615L)),

        WordEntity(id = 36614, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "refill", transliteration = "[ˈriːfɪl]", translation = "повторное получение лекарства по рецепту",
            definition = "Picking up the same medicine again when your bottle runs out.",
            definitionNative = "Повторное получение того же лекарства в аптеке, когда флакон кончился.",
            example = "I called the chemist to ask for a refill of my heart pills.",
            exampleNative = "Я позвонил в аптеку и попросил refill для своих сердечных таблеток.",
            pos = "noun", semanticGroup = "city_pharmacy", fillInBlankExclusions = listOf(36603L, 36611L, 36615L)),

        WordEntity(id = 36615, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "leaflet", transliteration = "[ˈliːflət]", translation = "листок-вкладыш (в упаковке лекарства)",
            definition = "A small folded paper inside a medicine box explaining how to take it.",
            definitionNative = "Сложенная бумажка внутри упаковки лекарства с указаниями, как принимать.",
            example = "Read the leaflet carefully before you take the tablets.",
            exampleNative = "Внимательно прочти leaflet перед тем, как принимать таблетки.",
            pos = "noun", semanticGroup = "city_pharmacy", fillInBlankExclusions = listOf(36611L, 36613L, 36614L)),

        // ── city_transport_pay (5) ────────────────────────────────────────

        WordEntity(id = 36616, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "travel pass", transliteration = "[ˈtrævəl pæs]", translation = "проездной",
            definition = "A card that lets you ride buses or trains many times for one price.",
            definitionNative = "Карта, дающая много поездок на автобусах или поездах за одну цену.",
            example = "My travel pass covers buses and the underground all week.",
            exampleNative = "Мой travel pass покрывает автобусы и метро всю неделю.",
            pos = "noun", semanticGroup = "city_transport_pay", fillInBlankExclusions = listOf(36617L, 36618L, 36619L, 36620L)),

        WordEntity(id = 36617, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "single ticket", transliteration = "[ˈsɪŋɡəl ˈtɪkɪt]", translation = "разовый билет",
            definition = "A small paper good for just one ride from A to B.",
            definitionNative = "Маленькая бумажка на одну поездку из пункта А в пункт Б.",
            example = "A single ticket to the airport is cheaper before nine in the morning.",
            exampleNative = "Single ticket до аэропорта дешевле до девяти утра.",
            pos = "noun", semanticGroup = "city_transport_pay", fillInBlankExclusions = listOf(36616L, 36618L, 36619L, 36620L)),

        WordEntity(id = 36618, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "monthly card", transliteration = "[ˈmʌnθli kɑːrd]", translation = "месячный проездной",
            definition = "A card that gives free rides for thirty days after you buy it.",
            definitionNative = "Карта, дающая бесплатные поездки тридцать дней с момента покупки.",
            example = "I always buy a monthly card on the first of every month.",
            exampleNative = "Я всегда покупаю monthly card первого числа каждого месяца.",
            pos = "noun", semanticGroup = "city_transport_pay", fillInBlankExclusions = listOf(36616L, 36617L, 36619L, 36620L, 36622L)),

        WordEntity(id = 36619, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "fine", transliteration = "[faɪn]", translation = "штраф (за безбилетный проезд)",
            definition = "Money you must pay as punishment for breaking a small rule.",
            definitionNative = "Деньги, которые надо отдать как наказание за маленькое нарушение.",
            example = "Riding without a ticket can get you a fifty-pound fine.",
            exampleNative = "Поездка без билета может стоить fine в пятьдесят фунтов.",
            pos = "noun", semanticGroup = "city_transport_pay", fillInBlankExclusions = listOf(36616L, 36617L, 36618L, 36620L, 36623L)),

        WordEntity(id = 36620, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "season ticket", transliteration = "[ˈsiːzən ˈtɪkɪt]", translation = "сезонный абонемент (на проезд)",
            definition = "A long pass for daily travel — usually three months or a year.",
            definitionNative = "Долгий абонемент для ежедневного проезда — обычно на три месяца или год.",
            example = "Commuters save a lot by buying a yearly season ticket.",
            exampleNative = "Те, кто ездит каждый день, экономят, покупая годовой season ticket.",
            pos = "noun", semanticGroup = "city_transport_pay", fillInBlankExclusions = listOf(36616L, 36617L, 36618L, 36619L, 36622L)),

        // ── city_parking (5) ──────────────────────────────────────────────

        WordEntity(id = 36621, setId = 366, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "parking meter", transliteration = "[ˈpɑːrkɪŋ ˈmiːtər]", translation = "паркомат",
            definition = "A small post by the kerb where drivers feed coins for a few hours.",
            definitionNative = "Столбик у тротуара, куда водители кидают монеты на несколько часов.",
            example = "He fed two pounds into the parking meter and ran to the bank.",
            exampleNative = "Он бросил два фунта в parking meter и побежал в банк.",
            pos = "noun", semanticGroup = "city_parking", fillInBlankExclusions = listOf(36622L, 36623L, 36624L, 36625L)),

        WordEntity(id = 36622, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "parking permit", transliteration = "[ˈpɑːrkɪŋ ˈpɜːrmɪt]", translation = "разрешение на парковку",
            definition = "A printed pass letting you leave a car on a special street.",
            definitionNative = "Печатное разрешение, позволяющее оставлять машину на особой улице.",
            example = "Residents need a parking permit to leave cars on this street.",
            exampleNative = "Жильцам нужен parking permit, чтобы оставлять машины на этой улице.",
            pos = "noun", semanticGroup = "city_parking", fillInBlankExclusions = listOf(36621L, 36623L, 36624L, 36625L)),

        WordEntity(id = 36623, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "parking ticket", transliteration = "[ˈpɑːrkɪŋ ˈtɪkɪt]", translation = "штраф-талон за парковку",
            definition = "A yellow paper a warden sticks on your windscreen — and you pay.",
            definitionNative = "Жёлтая бумажка, которую инспектор лепит на лобовое стекло, — нужно платить.",
            example = "She got a parking ticket because the meter ran out.",
            exampleNative = "Она получила parking ticket, потому что время на паркомате кончилось.",
            pos = "noun", semanticGroup = "city_parking", fillInBlankExclusions = listOf(36619L, 36621L, 36622L, 36624L, 36625L)),

        WordEntity(id = 36624, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "paid parking", transliteration = "[peɪd ˈpɑːrkɪŋ]", translation = "платная стоянка",
            definition = "An area where leaving a car costs money for every hour you stay.",
            definitionNative = "Место, где за каждый час стоянки машины надо платить.",
            example = "Most streets in the centre are paid parking after eight in the morning.",
            exampleNative = "Большинство улиц в центре — paid parking после восьми утра.",
            pos = "noun", semanticGroup = "city_parking", fillInBlankExclusions = listOf(36621L, 36622L, 36623L, 36625L)),

        WordEntity(id = 36625, setId = 366, languagePair = "en-ru", rarity = "RARE",
            original = "tow truck", transliteration = "[toʊ trʌk]", translation = "эвакуатор",
            definition = "A heavy lorry that pulls broken or wrongly parked cars away.",
            definitionNative = "Тяжёлый грузовик, увозящий сломанные или неправильно оставленные машины.",
            example = "A tow truck arrived ten minutes after she called for help.",
            exampleNative = "Tow truck приехал через десять минут после её звонка.",
            pos = "noun", semanticGroup = "city_parking", fillInBlankExclusions = listOf(36621L, 36622L, 36623L, 36624L)),
    )
}
