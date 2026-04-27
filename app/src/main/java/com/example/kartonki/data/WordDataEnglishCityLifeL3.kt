package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Городская жизнь и услуги (level 3, углублённый).
 *
 * Set 367: «Городская жизнь и услуги: углублённая лексика».
 * Бытовые услуги современного города: жильё в аренду/ипотека, доставка
 * товаров, работа поликлиники, дорожные нарушения и штрафы, коммунальные
 * счета и провайдеры (B2 — RARE/EPIC).
 *
 * Распределение редкости: 13 RARE + 12 EPIC — два смежных уровня шкалы.
 *
 * Тема «Городская жизнь и услуги» — новая, отдельная от темы «Город» (улицы,
 * заведения, инфраструктура — set 277/288/289/290/291/299). Здесь акцент
 * именно на сервисах и взаимодействии горожанина со службами.
 *
 * Соседние сеты темы (создаются параллельно):
 *   - Set 365 (CityLifeL1) — L1 базовая лексика.
 *   - Set 366 (CityLifeL2) — L2 продвинутая лексика.
 *
 * Слова setId=367 не пересекаются с уже существующими сетами (Финансы,
 * Медицина, Шоппинг, Город, Право) — проверено grep по составным фразам.
 *
 * SemanticGroups (5 × 5):
 *   city_housing       — mortgage, rent agreement, security deposit, landlord, lease term
 *   city_delivery      — same-day delivery, doorstep, pick-up point, signature required, missed delivery
 *   city_clinic        — clinic, primary care, walk-in, referral letter, co-pay
 *   city_traffic_law   — speeding ticket, points on license, parking violation, traffic camera, court summons
 *   city_utilities     — utility bill, water meter, electricity tariff, internet provider, garbage collection
 *
 * Word IDs: 36701..36725 (setId × 100 + position).
 *
 * Все слова помечены isFillInBlankSafe = false: примеры содержат
 * многословные термины с дефисами/пробелами, форма в example может
 * не совпасть буква-в-букву с original — пусть pipeline сначала
 * проанализирует и решит, какие действительно safe.
 */
object WordDataEnglishCityLifeL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 367,
            languagePair = "en-ru",
            orderIndex = 367,
            name = "Городская жизнь и услуги",
            description = "Углублённый: ипотека, доставка, поликлиника, штрафы, ЖКХ",
            topic = "Городская жизнь и услуги",
            level = 3),
    )

    val words: List<WordEntity> = listOf(

        // ── city_housing (5) ──────────────────────────────────────────────

        WordEntity(id = 36701, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "home loan", transliteration = "[hoʊm loʊn]", translation = "ссуда на покупку жилья",
            definition = "A long-term bank loan used to buy a house, paid back month by month.",
            definitionNative = "Долгий банковский займ на покупку дома, выплачиваемый помесячно.",
            example = "They took out a thirty-year home loan to buy their first apartment.",
            exampleNative = "Они взяли тридцатилетний home loan, чтобы купить первую квартиру.",
            pos = "noun", semanticGroup = "city_housing", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36702L, 36703L, 36705L)),

        WordEntity(id = 36702, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "rent agreement", transliteration = "[rɛnt əˈɡriːmənt]", translation = "договор аренды",
            definition = "A signed paper that sets the rules between the owner and the person renting.",
            definitionNative = "Подписанная бумага с правилами между владельцем и снимающим жильё.",
            example = "Read the rent agreement carefully before you sign anything.",
            exampleNative = "Внимательно прочитай rent agreement, прежде чем что-либо подписывать.",
            pos = "noun", semanticGroup = "city_housing", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36701L, 36703L, 36704L, 36705L)),

        WordEntity(id = 36703, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "security deposit", transliteration = "[sɪˈkjʊrəti dɪˈpɑzɪt]", translation = "залог за квартиру",
            definition = "Money paid up front to cover damage if the renter breaks something.",
            definitionNative = "Деньги вперёд на случай, если съёмщик что-то сломает в квартире.",
            example = "She lost half her security deposit because of the stained carpet.",
            exampleNative = "Она потеряла половину security deposit из-за пятен на ковре.",
            pos = "noun", semanticGroup = "city_housing", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36701L, 36702L, 36705L)),

        WordEntity(id = 36704, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "landlord", transliteration = "[ˈlændˌlɔrd]", translation = "арендодатель / владелец жилья",
            definition = "The owner of a flat or house who lets other people live there for money.",
            definitionNative = "Владелец квартиры или дома, пускающий жильцов за плату.",
            example = "Our landlord raised the rent twice in a single year.",
            exampleNative = "Наш landlord поднимал плату дважды за один год.",
            pos = "noun", semanticGroup = "city_housing", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36702L)),

        WordEntity(id = 36705, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "lease term", transliteration = "[liːs tɜrm]", translation = "срок аренды",
            definition = "The length of time agreed in the contract for renting a place.",
            definitionNative = "Длина срока в договоре, на который снимается жильё.",
            example = "The lease term ends in June, so we must decide whether to renew.",
            exampleNative = "Lease term заканчивается в июне, нужно решить — продлевать или нет.",
            pos = "noun", semanticGroup = "city_housing", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36701L, 36702L, 36703L)),

        // ── city_delivery (5) ─────────────────────────────────────────────

        WordEntity(id = 36706, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "same-day delivery", transliteration = "[seɪm deɪ dɪˈlɪvəri]", translation = "доставка в день заказа",
            definition = "A service that brings the order to your address before the day ends.",
            definitionNative = "Услуга, при которой заказ привозят на адрес до конца того же дня.",
            example = "The bookstore offers same-day delivery within the city center.",
            exampleNative = "Книжный предлагает same-day delivery в пределах центра города.",
            pos = "noun", semanticGroup = "city_delivery", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36707L, 36708L, 36710L)),

        WordEntity(id = 36707, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "doorstep", transliteration = "[ˈdɔrˌstɛp]", translation = "порог (у входной двери)",
            definition = "The flat stone or step right outside the front door of a home.",
            definitionNative = "Плоский камень или ступенька прямо снаружи входной двери дома.",
            example = "The courier left the parcel on the doorstep without ringing the bell.",
            exampleNative = "Курьер оставил посылку на doorstep, не позвонив в звонок.",
            pos = "noun", semanticGroup = "city_delivery", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36708L)),

        WordEntity(id = 36708, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "pick-up point", transliteration = "[ˈpɪk ʌp pɔɪnt]", translation = "пункт выдачи (заказа)",
            definition = "A nearby place where customers go to collect their parcels themselves.",
            definitionNative = "Близкое место, куда покупатели сами приходят забрать посылки.",
            example = "I chose a pick-up point near the metro instead of home delivery.",
            exampleNative = "Я выбрал pick-up point у метро вместо доставки на дом.",
            pos = "noun", semanticGroup = "city_delivery", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36706L, 36707L, 36710L)),

        WordEntity(id = 36709, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "signature required", transliteration = "[ˈsɪɡnəʧər rɪˈkwaɪrd]", translation = "требуется подпись (при получении)",
            definition = "A note saying the courier must get your name on paper before handing over.",
            definitionNative = "Пометка: курьер должен взять вашу роспись на бумаге перед передачей.",
            example = "The package is signature required, so someone must be home today.",
            exampleNative = "Посылка signature required, поэтому кто-то должен быть дома.",
            pos = "phrase", semanticGroup = "city_delivery", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36710L)),

        WordEntity(id = 36710, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "missed delivery", transliteration = "[mɪst dɪˈlɪvəri]", translation = "неудачная доставка",
            definition = "A try by the courier that fails because no one was at the address.",
            definitionNative = "Попытка курьера, не удавшаяся, потому что никого не было по адресу.",
            example = "After the missed delivery, I rescheduled the package for Saturday morning.",
            exampleNative = "После missed delivery я перенёс посылку на утро субботы.",
            pos = "noun", semanticGroup = "city_delivery", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36706L, 36708L, 36709L)),

        // ── city_clinic (5) ───────────────────────────────────────────────

        WordEntity(id = 36711, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "clinic", transliteration = "[ˈklɪnɪk]", translation = "поликлиника / медицинский центр",
            definition = "A small health centre where people see a doctor without staying overnight.",
            definitionNative = "Небольшой медцентр, куда приходят к врачу без ночёвки в больнице.",
            example = "The clinic on the corner is open until eight every weekday evening.",
            exampleNative = "Clinic на углу работает до восьми по будням вечером.",
            pos = "noun", semanticGroup = "city_clinic", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36712L)),

        WordEntity(id = 36712, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "primary care", transliteration = "[ˈpraɪˌmɛri kɛr]", translation = "первичная медицинская помощь",
            definition = "The first level of medical service — your local doctor for everyday issues.",
            definitionNative = "Первый уровень медицинской помощи — местный врач для повседневных проблем.",
            example = "Most colds and headaches are handled at the primary care office.",
            exampleNative = "Простуду и головную боль лечат в кабинете primary care.",
            pos = "noun", semanticGroup = "city_clinic", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36711L, 36713L, 36714L, 36715L)),

        WordEntity(id = 36713, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "walk-in", transliteration = "[ˈwɔk ɪn]", translation = "приём без записи",
            definition = "A visit where you arrive without an appointment and wait in line.",
            definitionNative = "Посещение без записи, когда приходишь и ждёшь в очереди.",
            example = "The walk-in option saved me when I caught a sudden fever on Sunday.",
            exampleNative = "Walk-in выручил меня, когда я внезапно слёг с температурой в воскресенье.",
            pos = "noun", semanticGroup = "city_clinic", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36712L, 36714L)),

        WordEntity(id = 36714, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "referral letter", transliteration = "[rɪˈfɜrəl ˈlɛtər]", translation = "направление к специалисту",
            definition = "A short note from one doctor that sends you to another, more specialized one.",
            definitionNative = "Короткая записка от одного врача, отправляющая тебя к другому, более узкому.",
            example = "Without a referral letter, the cardiologist won't see you next week.",
            exampleNative = "Без referral letter кардиолог не примет тебя на следующей неделе.",
            pos = "noun", semanticGroup = "city_clinic", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36712L, 36713L, 36715L)),

        WordEntity(id = 36715, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "co-pay", transliteration = "[ˈkoʊ peɪ]", translation = "доплата пациента (по страховке)",
            definition = "A small fixed sum the patient pays at each visit, with insurance covering the rest.",
            definitionNative = "Маленькая фиксированная сумма от пациента за визит, остальное платит страховка.",
            example = "My insurance plan has a twenty-dollar co-pay for any specialist visit.",
            exampleNative = "В моей страховке co-pay двадцать долларов за визит к специалисту.",
            pos = "noun", semanticGroup = "city_clinic", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36712L, 36714L)),

        // ── city_traffic_law (5) ──────────────────────────────────────────

        WordEntity(id = 36716, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "speeding ticket", transliteration = "[ˈspidɪŋ ˈtɪkɪt]", translation = "штраф за превышение скорости",
            definition = "An official fine given to a driver who drove faster than allowed.",
            definitionNative = "Официальный штраф водителю, ехавшему быстрее, чем разрешено.",
            example = "He got a speeding ticket on the highway near the airport last night.",
            exampleNative = "Он получил speeding ticket на шоссе у аэропорта прошлой ночью.",
            pos = "noun", semanticGroup = "city_traffic_law", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36717L, 36718L, 36719L, 36720L)),

        WordEntity(id = 36717, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "points on license", transliteration = "[pɔɪnts ɑn ˈlaɪsəns]", translation = "штрафные баллы (на водительских правах)",
            definition = "Marks added to a driver's record after a traffic offence; too many means a ban.",
            definitionNative = "Отметки на учёте водителя за нарушения; много отметок — лишение прав.",
            example = "Two more points on license and he'll lose the right to drive.",
            exampleNative = "Ещё два points on license — и он лишится права водить.",
            pos = "phrase", semanticGroup = "city_traffic_law", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36716L, 36718L)),

        WordEntity(id = 36718, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "parking violation", transliteration = "[ˈpɑrkɪŋ ˌvaɪəˈleɪʃən]", translation = "нарушение правил парковки",
            definition = "Leaving the car where it's not allowed, like blocking a driveway or fire lane.",
            definitionNative = "Оставленная машина там, где нельзя — например, на въезде или у пожарной полосы.",
            example = "She found a parking violation slip tucked under her windshield wiper.",
            exampleNative = "Она нашла бумажку о parking violation под щёткой стеклоочистителя.",
            pos = "noun", semanticGroup = "city_traffic_law", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36716L, 36717L, 36719L, 36720L)),

        WordEntity(id = 36719, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "traffic camera", transliteration = "[ˈtræfɪk ˈkæmərə]", translation = "дорожная камера (фиксирующая нарушения)",
            definition = "A device on the road that takes photos of cars breaking driving rules.",
            definitionNative = "Прибор на дороге, делающий снимки машин, нарушающих правила движения.",
            example = "A traffic camera caught him running the red light on Main Street.",
            exampleNative = "Traffic camera засняла, как он проехал на красный на главной улице.",
            pos = "noun", semanticGroup = "city_traffic_law", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36716L, 36718L, 36720L)),

        WordEntity(id = 36720, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "court summons", transliteration = "[kɔrt ˈsʌmənz]", translation = "повестка в суд",
            definition = "An official paper ordering a person to appear before a judge on a set day.",
            definitionNative = "Официальная бумага, обязывающая прийти к судье в назначенный день.",
            example = "After ignoring the fine, he received a court summons in the post.",
            exampleNative = "После игнорирования штрафа он получил court summons по почте.",
            pos = "noun", semanticGroup = "city_traffic_law", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36716L, 36717L, 36718L)),

        // ── city_utilities (5) ────────────────────────────────────────────

        WordEntity(id = 36721, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "utility bill", transliteration = "[juˈtɪləti bɪl]", translation = "счёт за коммунальные услуги",
            definition = "A monthly paper showing how much you owe for water, gas or power.",
            definitionNative = "Ежемесячная бумага, сколько ты должен заплатить за воду, газ или свет.",
            example = "The utility bill jumped sharply after the freezing winter month.",
            exampleNative = "Utility bill резко вырос после морозного зимнего месяца.",
            pos = "noun", semanticGroup = "city_utilities", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36722L, 36723L, 36725L)),

        WordEntity(id = 36722, setId = 367, languagePair = "en-ru", rarity = "RARE",
            original = "water meter", transliteration = "[ˈwɔtər ˈmitər]", translation = "счётчик воды",
            definition = "A small device that measures how much water flows into your home.",
            definitionNative = "Маленький прибор, измеряющий, сколько воды поступает в твоё жильё.",
            example = "The plumber checked the water meter before sealing the new pipe.",
            exampleNative = "Сантехник проверил water meter перед опечатыванием новой трубы.",
            pos = "noun", semanticGroup = "city_utilities", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36721L, 36723L, 36725L)),

        WordEntity(id = 36723, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "electricity tariff", transliteration = "[ɪˌlɛkˈtrɪsəti ˈtɛrəf]", translation = "тариф на электроэнергию",
            definition = "The price per unit of power that the company charges its household clients.",
            definitionNative = "Цена за единицу электричества, которую компания берёт с домохозяйств.",
            example = "The new electricity tariff applies to all flats from January first.",
            exampleNative = "Новый electricity tariff действует для всех квартир с первого января.",
            pos = "noun", semanticGroup = "city_utilities", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36721L, 36722L, 36724L, 36725L)),

        WordEntity(id = 36724, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "internet provider", transliteration = "[ˈɪntərˌnɛt prəˈvaɪdər]", translation = "интернет-провайдер",
            definition = "A company that sells the connection that brings the web into your flat.",
            definitionNative = "Компания, продающая подключение, по которому интернет приходит в квартиру.",
            example = "We switched our internet provider after months of slow evening speeds.",
            exampleNative = "Мы сменили internet provider после месяцев медленной скорости по вечерам.",
            pos = "noun", semanticGroup = "city_utilities", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36723L, 36725L)),

        WordEntity(id = 36725, setId = 367, languagePair = "en-ru", rarity = "EPIC",
            original = "garbage collection", transliteration = "[ˈɡɑrbəʤ kəˈlɛkʃən]", translation = "вывоз мусора",
            definition = "The city service that takes away rubbish from streets and yards each week.",
            definitionNative = "Городская служба, увозящая мусор с улиц и дворов каждую неделю.",
            example = "Garbage collection in our district happens every Tuesday before sunrise.",
            exampleNative = "Garbage collection в нашем районе бывает каждый вторник до рассвета.",
            pos = "noun", semanticGroup = "city_utilities", isFillInBlankSafe = false,
            fillInBlankExclusions = listOf(36721L, 36723L, 36724L)),
    )
}
