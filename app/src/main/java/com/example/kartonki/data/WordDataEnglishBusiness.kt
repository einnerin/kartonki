package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary: «Бизнес и предпринимательство», уровни L1-L5 (5 sets, 125 words).
 *
 * Тема покрывает менеджмент, продажи, маркетинг, контракты, корпоративную
 * стратегию, M&A и продвинутую экономическую лексику. Сознательно не пересекается
 * с темами «Финансы» (личные деньги, банкинг) и «Работа и карьера» (резюме,
 * собеседование, рабочий день).
 *
 *   Set 420 — L1 (COMMON+UNCOMMON):  основы — компания, клиент, продажи
 *   Set 421 — L2 (UNCOMMON+RARE):    маркетинг, прибыль, заказы, склад
 *   Set 422 — L3 (RARE+EPIC):        стратегия, стартапы, agile, метрики
 *   Set 423 — L4 (EPIC+LEGENDARY):   M&A, корпоративная этика, юр. оговорки
 *   Set 424 — L5 (LEGENDARY):        экономика для носителя — арбитраж, рынок
 */
object WordDataEnglishBusiness {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 420,
            languagePair = "en-ru",
            orderIndex = 420,
            name = "Бизнес и предпринимательство",
            description = "Основы: компания, клиент, продажи",
            topic = "Бизнес и предпринимательство",
            level = 1,
        ),
        WordSetEntity(
            id = 421,
            languagePair = "en-ru",
            orderIndex = 421,
            name = "Бизнес и предпринимательство",
            description = "Маркетинг, заказы, склад, прибыль",
            topic = "Бизнес и предпринимательство",
            level = 2,
        ),
        WordSetEntity(
            id = 422,
            languagePair = "en-ru",
            orderIndex = 422,
            name = "Бизнес и предпринимательство",
            description = "Стратегия, стартапы, метрики, agile",
            topic = "Бизнес и предпринимательство",
            level = 3,
        ),
        WordSetEntity(
            id = 423,
            languagePair = "en-ru",
            orderIndex = 423,
            name = "Бизнес и предпринимательство",
            description = "Слияния, поглощения и корпоративная этика",
            topic = "Бизнес и предпринимательство",
            level = 4,
        ),
        WordSetEntity(
            id = 424,
            languagePair = "en-ru",
            orderIndex = 424,
            name = "Бизнес и предпринимательство",
            description = "Экономическая лексика для носителей",
            topic = "Бизнес и предпринимательство",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 420 — L1: основы бизнеса (COMMON+UNCOMMON)                   ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── business_people (5) ───────────────────────────────────────────

        WordEntity(id = 42001, setId = 420, languagePair = "en-ru", rarity = "COMMON",
            original = "worker", transliteration = "[ˈwɜːrkər]", translation = "работник",
            definition = "Someone who does a paid job at a company or factory.",
            definitionNative = "Тот, кто получает зарплату за дело в фирме или на заводе.",
            example = "Every worker at the bakery starts the shift before sunrise.",
            exampleNative = "Каждый worker в пекарне выходит на смену до рассвета.",
            pos = "noun", semanticGroup = "business_people", fillInBlankExclusions = listOf(42002L, 42003L, 42004L, 42005L, 42007L, 42008L, 42009L)),

        WordEntity(id = 42002, setId = 420, languagePair = "en-ru", rarity = "COMMON",
            original = "owner", transliteration = "[ˈoʊnər]", translation = "владелец",
            definition = "The person who possesses a shop, company or piece of property.",
            definitionNative = "Тот, кому принадлежит магазин, фирма или какая-то вещь.",
            example = "The owner of the cafe greets every regular customer by name.",
            exampleNative = "Owner кафе здоровается с каждым постоянным клиентом по имени.",
            pos = "noun", semanticGroup = "business_people", fillInBlankExclusions = listOf(42001L, 42003L, 42004L, 42005L, 42007L, 42008L, 42009L)),

        WordEntity(id = 42003, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "employer", transliteration = "[ɪmˈplɔɪər]", translation = "работодатель",
            definition = "A person or company that pays others to do a job.",
            definitionNative = "Человек или фирма, что платит другим за выполнение дела.",
            example = "My employer covers half of the cost of public transport.",
            exampleNative = "Мой employer оплачивает половину стоимости проезда.",
            pos = "noun", semanticGroup = "business_people", fillInBlankExclusions = listOf(42001L, 42002L, 42004L, 42005L, 42007L, 42008L, 42009L)),

        WordEntity(id = 42004, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "employee", transliteration = "[ɪmˈplɔɪiː]", translation = "сотрудник",
            definition = "Someone hired to do paid tasks for a firm or shop.",
            definitionNative = "Тот, кого наняли в фирму или магазин за плату.",
            example = "Every employee gets two weeks of paid holiday each year.",
            exampleNative = "Каждый employee получает две недели оплачиваемого отпуска в году.",
            pos = "noun", semanticGroup = "business_people", fillInBlankExclusions = listOf(42001L, 42002L, 42003L, 42005L, 42007L, 42008L, 42009L)),

        WordEntity(id = 42005, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "co-worker", transliteration = "[ˈkoʊˌwɜːrkər]", translation = "коллега",
            definition = "Another person you do your daily job alongside.",
            definitionNative = "Тот, с кем ты вместе делаешь свою работу каждый день.",
            example = "My co-worker brought homemade cookies for everyone today.",
            exampleNative = "Мой co-worker принёс домашнее печенье для всех сегодня.",
            pos = "noun", semanticGroup = "business_people", fillInBlankExclusions = listOf(42001L, 42002L, 42003L, 42004L, 42007L, 42008L, 42009L)),

        // ── business_roles_sales (4) ──────────────────────────────────────

        WordEntity(id = 42006, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "shopper", transliteration = "[ˈʃɑːpər]", translation = "покупатель",
            definition = "A person walking through stores to look for things to buy.",
            definitionNative = "Тот, кто ходит по магазинам и смотрит, что приобрести.",
            example = "Every shopper got a free chocolate at the entrance today.",
            exampleNative = "Каждый shopper получил бесплатный шоколад у входа сегодня.",
            pos = "noun", semanticGroup = "business_roles_sales", fillInBlankExclusions = listOf(42001L, 42002L, 42004L, 42005L, 42007L, 42008L, 42009L)),

        WordEntity(id = 42007, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "salesperson", transliteration = "[ˈseɪlzpɜːrsən]", translation = "продавец-консультант",
            definition = "Someone whose paid task is helping people choose and pay for goods.",
            definitionNative = "Тот, чьё дело — помочь людям выбрать товар и оплатить его.",
            example = "A friendly salesperson showed me three jackets in my size.",
            exampleNative = "Дружелюбный salesperson показал мне три куртки моего размера.",
            pos = "noun", semanticGroup = "business_roles_sales", fillInBlankExclusions = listOf(42001L, 42005L, 42006L, 42008L, 42009L)),

        WordEntity(id = 42008, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sales clerk", transliteration = "[ˈseɪlz klɜːrk]", translation = "продавец-кассир",
            definition = "A staff member who serves people behind the counter at a store.",
            definitionNative = "Сотрудник за прилавком, который обслуживает людей в магазине.",
            example = "The sales clerk at the bookstore wrapped my gift very neatly.",
            exampleNative = "Sales clerk в книжном красиво упаковал мой подарок.",
            pos = "noun", semanticGroup = "business_roles_sales", fillInBlankExclusions = listOf(42001L, 42002L, 42006L, 42007L, 42009L)),

        WordEntity(id = 42009, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "new hire", transliteration = "[njuː ˈhaɪər]", translation = "новый сотрудник",
            definition = "A person who has just joined a team and is learning the routine.",
            definitionNative = "Тот, кто только пришёл в команду и осваивает привычные дела.",
            example = "Our new hire learns the menu faster than I expected.",
            exampleNative = "Наш new hire запоминает меню быстрее, чем я ожидал.",
            pos = "noun", semanticGroup = "business_roles_sales", fillInBlankExclusions = listOf(42001L, 42006L, 42007L, 42008L)),

        // ── business_company_basics (5) ───────────────────────────────────

        WordEntity(id = 42010, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "firm", transliteration = "[fɜːrm]", translation = "фирма",
            definition = "A business of any size, often offering services or making products.",
            definitionNative = "Дело любого размера: оказывает услуги или производит товары.",
            example = "Her firm has only six people but ships orders worldwide.",
            exampleNative = "В её firm всего шесть человек, но они отправляют заказы по всему миру.",
            pos = "noun", semanticGroup = "business_company_basics", fillInBlankExclusions = listOf(42012L, 42014L)),

        WordEntity(id = 42011, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "small business", transliteration = "[smɔːl ˈbɪznɪs]", translation = "малое предприятие",
            definition = "A modest local enterprise, usually run by an owner with a few staff.",
            definitionNative = "Скромное местное дело — хозяин и пара помощников рядом.",
            example = "Mom runs a small business that sells homemade cheese online.",
            exampleNative = "Мама держит small business — продаёт домашний сыр через интернет.",
            pos = "phrase", semanticGroup = "business_company_basics", fillInBlankExclusions = listOf(42013L)),

        WordEntity(id = 42012, setId = 420, languagePair = "en-ru", rarity = "COMMON",
            original = "factory", transliteration = "[ˈfæktəri]", translation = "завод",
            definition = "A large building where machines and people make goods in big numbers.",
            definitionNative = "Большое здание, где машины и люди делают товары в больших количествах.",
            example = "His grandfather worked at a car factory for forty years.",
            exampleNative = "Его дед сорок лет проработал на автомобильном factory.",
            pos = "noun", semanticGroup = "business_company_basics", fillInBlankExclusions = listOf(42010L, 42014L)),

        WordEntity(id = 42013, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "chain store", transliteration = "[tʃeɪn stɔːr]", translation = "сетевой магазин",
            definition = "One of many similar shops with the same name across many cities.",
            definitionNative = "Один из множества похожих магазинов под одним именем в разных городах.",
            example = "Every chain store in the country sells exactly the same brands.",
            exampleNative = "Каждый chain store в стране продаёт ровно те же марки.",
            pos = "phrase", semanticGroup = "business_company_basics", fillInBlankExclusions = listOf(42011L)),

        WordEntity(id = 42014, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "storefront", transliteration = "[ˈstɔːrfrʌnt]", translation = "витрина магазина",
            definition = "The front side of a shop facing the street, with windows and the door.",
            definitionNative = "Передняя стена лавки, что смотрит на улицу — с окнами и дверью.",
            example = "Their bright storefront on Main Street draws tourists every weekend.",
            exampleNative = "Их яркий storefront на главной улице каждые выходные привлекает туристов.",
            pos = "noun", semanticGroup = "business_company_basics", fillInBlankExclusions = listOf(42010L, 42012L)),

        // ── business_goods_services (3) ───────────────────────────────────

        WordEntity(id = 42015, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "goods", transliteration = "[ɡʊdz]", translation = "товар, продукция",
            definition = "Physical things made or grown to be sold to people.",
            definitionNative = "Вещи, которые делают или выращивают, чтобы продать людям.",
            example = "All the goods on this shelf come from local farms.",
            exampleNative = "Все goods на этой полке — с местных ферм.",
            pos = "noun", semanticGroup = "business_goods_services", fillInBlankExclusions = listOf(42016L)),

        WordEntity(id = 42016, setId = 420, languagePair = "en-ru", rarity = "COMMON",
            original = "service", transliteration = "[ˈsɜːrvɪs]", translation = "услуга",
            definition = "Help, work or care that someone provides for others, often for money.",
            definitionNative = "Помощь, дело или забота, что один оказывает другим, часто за плату.",
            example = "Their cleaning service comes once a week and does the windows.",
            exampleNative = "Их service по уборке приходит раз в неделю и моет окна.",
            pos = "noun", semanticGroup = "business_goods_services", fillInBlankExclusions = listOf(42015L)),

        WordEntity(id = 42017, setId = 420, languagePair = "en-ru", rarity = "COMMON",
            original = "deliver", transliteration = "[dɪˈlɪvər]", translation = "доставлять",
            definition = "To bring something to a person at the right place.",
            definitionNative = "Привезти что-то человеку прямо туда, куда нужно.",
            example = "We deliver hot pizza to your door in under thirty minutes.",
            exampleNative = "Мы deliver горячую пиццу к двери меньше чем за тридцать минут.",
            pos = "verb", semanticGroup = "business_goods_services"),

        // ── business_workspace (4) ────────────────────────────────────────

        WordEntity(id = 42018, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "storeroom", transliteration = "[ˈstɔːruːm]", translation = "подсобка",
            definition = "A small back room used to keep extra goods, boxes or tools.",
            definitionNative = "Маленькая задняя комната — там держат запас, коробки и инструменты.",
            example = "Could you fetch a fresh box of napkins from the storeroom?",
            exampleNative = "Можешь принести свежую коробку салфеток из storeroom?",
            pos = "noun", semanticGroup = "business_workspace"),

        WordEntity(id = 42019, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "help desk", transliteration = "[hɛlp dɛsk]", translation = "стойка поддержки",
            definition = "A counter or phone line where people answer questions and fix problems.",
            definitionNative = "Стойка или телефон, где отвечают на вопросы и помогают с проблемой.",
            example = "Call the help desk if your office printer stops working.",
            exampleNative = "Звони на help desk, если офисный принтер перестал работать.",
            pos = "phrase", semanticGroup = "business_workspace", fillInBlankExclusions = listOf(42020L, 42021L)),

        WordEntity(id = 42020, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "to-do list", transliteration = "[tə ˈduː lɪst]", translation = "список дел",
            definition = "A short note of tasks you want to finish during the day.",
            definitionNative = "Короткая запись того, что хочешь успеть за день.",
            example = "I cross items off my to-do list as I finish them.",
            exampleNative = "Я вычёркиваю пункты из to-do list по мере того, как заканчиваю.",
            pos = "phrase", semanticGroup = "business_workspace", fillInBlankExclusions = listOf(42019L, 42021L)),

        WordEntity(id = 42021, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "business card", transliteration = "[ˈbɪznɪs kɑːrd]", translation = "визитка",
            definition = "A small paper rectangle with a person's name, role and contact details.",
            definitionNative = "Маленький бумажный прямоугольник: имя, должность и контакты.",
            example = "He handed me a business card right after we shook hands.",
            exampleNative = "Он протянул мне business card сразу после рукопожатия.",
            pos = "phrase", semanticGroup = "business_workspace", fillInBlankExclusions = listOf(42019L, 42020L)),

        // ── business_schedule (3) ─────────────────────────────────────────

        WordEntity(id = 42022, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "work week", transliteration = "[wɜːrk wiːk]", translation = "рабочая неделя",
            definition = "The days from Monday to Friday when most people work.",
            definitionNative = "Дни с понедельника по пятницу, когда большинство людей трудятся.",
            example = "My work week ends with a quiet coffee on Friday afternoon.",
            exampleNative = "Мой work week заканчивается тихим кофе в пятницу днём.",
            pos = "phrase", semanticGroup = "business_schedule", fillInBlankExclusions = listOf(42023L, 42024L)),

        WordEntity(id = 42023, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "day off", transliteration = "[deɪ ɔːf]", translation = "выходной",
            definition = "A day when you don't have to go to your job.",
            definitionNative = "Сутки, когда не нужно идти на службу.",
            example = "I took a day off to visit my grandmother in the village.",
            exampleNative = "Я взял day off, чтобы съездить к бабушке в деревню.",
            pos = "phrase", semanticGroup = "business_schedule", fillInBlankExclusions = listOf(42022L, 42024L)),

        WordEntity(id = 42024, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "business trip", transliteration = "[ˈbɪznɪs trɪp]", translation = "командировка",
            definition = "A short journey to another city, paid by your firm for work reasons.",
            definitionNative = "Короткая поездка в другой город от фирмы по рабочему делу.",
            example = "She flies to London tomorrow on a quick business trip.",
            exampleNative = "Завтра она летит в Лондон на короткую business trip.",
            pos = "phrase", semanticGroup = "business_schedule", fillInBlankExclusions = listOf(42022L, 42023L)),

        WordEntity(id = 42025, setId = 420, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sales pitch", transliteration = "[ˈseɪlz pɪtʃ]", translation = "торговая речь",
            definition = "A short talk meant to convince someone to buy a product.",
            definitionNative = "Короткая речь, чтобы уговорить человека приобрести товар.",
            example = "His sales pitch was so warm that we bought two pillows.",
            exampleNative = "Его sales pitch был таким тёплым, что мы взяли две подушки.",
            pos = "phrase", semanticGroup = "business_roles_sales"),

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 421 — L2: маркетинг, прибыль, склад (UNCOMMON+RARE)          ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── business_marketing (5) ────────────────────────────────────────

        WordEntity(id = 42101, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "marketing", transliteration = "[ˈmɑːrkɪtɪŋ]", translation = "маркетинг",
            definition = "The work of telling people about a product so they want to buy it.",
            definitionNative = "Дело, чтобы рассказать людям о товаре и им захотелось его купить.",
            example = "Their marketing focuses on social media and short funny videos.",
            exampleNative = "Их marketing держится на соцсетях и коротких смешных роликах.",
            pos = "noun", semanticGroup = "business_marketing", fillInBlankExclusions = listOf(42102L, 42103L, 42104L, 42105L)),

        WordEntity(id = 42102, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "advertising", transliteration = "[ˈædvərˌtaɪzɪŋ]", translation = "реклама",
            definition = "Public messages on TV, online or on streets that promote goods.",
            definitionNative = "Публичные сообщения по ТВ, в сети или на улице — продвигают товар.",
            example = "Online advertising now brings in more revenue than print does.",
            exampleNative = "Сейчас онлайн-advertising приносит больше дохода, чем бумажная.",
            pos = "noun", semanticGroup = "business_marketing", fillInBlankExclusions = listOf(42101L, 42103L, 42104L, 42105L)),

        WordEntity(id = 42103, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "endorsement", transliteration = "[ɪnˈdɔːrsmənt]", translation = "рекомендация",
            definition = "Public approval of a product, often by a famous person.",
            definitionNative = "Публичная поддержка товара, часто со стороны известного человека.",
            example = "A celebrity endorsement helped the small skincare brand take off.",
            exampleNative = "Знаменитый endorsement помог небольшой марке косметики взлететь.",
            pos = "noun", semanticGroup = "business_marketing", fillInBlankExclusions = listOf(42101L, 42102L, 42104L, 42105L)),

        WordEntity(id = 42104, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "testimonial", transliteration = "[ˌtɛstɪˈmoʊniəl]", translation = "отзыв клиента",
            definition = "A short written or spoken note where a customer praises something.",
            definitionNative = "Короткая запись или речь, где клиент хвалит что-то.",
            example = "Her testimonial about the yoga app appears on the home page.",
            exampleNative = "Её testimonial о приложении для йоги висит на главной странице.",
            pos = "noun", semanticGroup = "business_marketing", fillInBlankExclusions = listOf(42101L, 42102L, 42103L, 42105L)),

        WordEntity(id = 42105, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "referral", transliteration = "[rɪˈfɜːrəl]", translation = "рекомендация знакомого",
            definition = "When one customer suggests a shop or service to a friend.",
            definitionNative = "Когда один клиент советует другу какой-то магазин или услугу.",
            example = "Most of our new clients come through a friendly referral.",
            exampleNative = "Большинство наших новых клиентов приходят через тёплый referral.",
            pos = "noun", semanticGroup = "business_marketing", fillInBlankExclusions = listOf(42101L, 42102L, 42103L, 42104L)),

        // ── business_finance_basics (4) ───────────────────────────────────

        WordEntity(id = 42106, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "expense", transliteration = "[ɪkˈspɛns]", translation = "расход",
            definition = "Money spent on something needed to keep the business running.",
            definitionNative = "Деньги, что ушли на что-то нужное для работы дела.",
            example = "Rent is by far our largest monthly expense at the cafe.",
            exampleNative = "Аренда — самый крупный ежемесячный expense в кафе.",
            pos = "noun", semanticGroup = "business_finance_basics", fillInBlankExclusions = listOf(42107L, 42108L)),

        WordEntity(id = 42107, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "payroll", transliteration = "[ˈpeɪroʊl]", translation = "ведомость зарплат",
            definition = "The full list of staff and the wages a firm pays them.",
            definitionNative = "Полный список сотрудников и сумм, что выдают им за труд.",
            example = "The owner runs payroll on the last Friday of every month.",
            exampleNative = "Владелец закрывает payroll в последнюю пятницу каждого месяца.",
            pos = "noun", semanticGroup = "business_finance_basics", fillInBlankExclusions = listOf(42106L, 42108L)),

        WordEntity(id = 42108, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "break-even", transliteration = "[ˈbreɪk ˌiːvən]", translation = "точка безубыточности",
            definition = "The point where money earned equals money spent — no profit, no loss.",
            definitionNative = "Точка, где доход равен расходу: ни плюса, ни минуса.",
            example = "Our cafe reached break-even in just under eight months.",
            exampleNative = "Наше кафе вышло на break-even чуть меньше чем за восемь месяцев.",
            pos = "noun", semanticGroup = "business_finance_basics", fillInBlankExclusions = listOf(42106L, 42107L)),

        WordEntity(id = 42109, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "bottom line", transliteration = "[ˈbɒtəm laɪn]", translation = "итоговая прибыль",
            definition = "The final amount of money a firm earns after every cost is paid.",
            definitionNative = "Сумма дохода фирмы после того, как все расходы оплачены.",
            example = "Higher rent has hurt the bottom line of small bookstores.",
            exampleNative = "Высокая аренда бьёт по bottom line маленьких книжных лавок.",
            pos = "phrase", semanticGroup = "business_finance_basics"),

        // ── business_sales_tactics (5) ────────────────────────────────────

        WordEntity(id = 42110, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sales", transliteration = "[seɪlz]", translation = "продажи",
            definition = "The activity of selling things and the income it brings in.",
            definitionNative = "Дело торговли и поступления, что от неё приходят.",
            example = "Online sales tripled after we started shipping for free.",
            exampleNative = "Онлайн-sales выросли втрое после введения бесплатной доставки.",
            pos = "noun", semanticGroup = "business_sales_tactics"),

        WordEntity(id = 42111, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sales rep", transliteration = "[ˈseɪlz rɛp]", translation = "торговый представитель",
            definition = "Someone who travels to clients and shows products on behalf of a firm.",
            definitionNative = "Тот, кто ездит к клиентам и показывает товары от имени фирмы.",
            example = "Our sales rep visits twenty pharmacies every single week.",
            exampleNative = "Наш sales rep объезжает двадцать аптек каждую неделю.",
            pos = "phrase", semanticGroup = "business_sales_tactics", fillInBlankExclusions = listOf(42114L)),

        WordEntity(id = 42112, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "foot traffic", transliteration = "[fʊt ˈtræfɪk]", translation = "поток посетителей",
            definition = "The flow of people walking past or into a shop on a given day.",
            definitionNative = "Поток людей, что проходят мимо или заходят в лавку за день.",
            example = "Heavy rain cut foot traffic in the city centre by half.",
            exampleNative = "Сильный дождь срезал foot traffic в центре города вдвое.",
            pos = "phrase", semanticGroup = "business_sales_tactics", fillInBlankExclusions = listOf(42111L, 42113L, 42114L)),

        WordEntity(id = 42113, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "pop-up shop", transliteration = "[ˈpɒp ʌp ʃɒp]", translation = "временный магазин",
            definition = "A short-term shop that opens for a few weeks and then disappears.",
            definitionNative = "Лавка на короткое время — открылась на пару недель и пропала.",
            example = "A holiday pop-up shop sold candles next to the train station.",
            exampleNative = "Праздничный pop-up shop продавал свечи рядом с вокзалом.",
            pos = "phrase", semanticGroup = "business_sales_tactics", fillInBlankExclusions = listOf(42111L, 42112L, 42114L)),

        WordEntity(id = 42114, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "flash sale", transliteration = "[flæʃ seɪl]", translation = "молниеносная распродажа",
            definition = "A short, sudden price drop that lasts just a few hours.",
            definitionNative = "Короткое внезапное падение цен — всего на пару часов.",
            example = "The bookstore runs a flash sale every Tuesday after lunch.",
            exampleNative = "Книжный делает flash sale каждый вторник после обеда.",
            pos = "phrase", semanticGroup = "business_sales_tactics", fillInBlankExclusions = listOf(42111L)),

        // ── business_targets (3) ──────────────────────────────────────────

        WordEntity(id = 42115, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "target", transliteration = "[ˈtɑːrɡɪt]", translation = "цель (показатель)",
            definition = "A number a team aims to reach by the end of a period.",
            definitionNative = "Число, к которому команда стремится к концу срока.",
            example = "We hit our quarterly target two weeks ahead of schedule.",
            exampleNative = "Мы взяли свой квартальный target на две недели раньше срока.",
            pos = "noun", semanticGroup = "business_targets", fillInBlankExclusions = listOf(42116L, 42117L)),

        WordEntity(id = 42116, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mission", transliteration = "[ˈmɪʃən]", translation = "миссия",
            definition = "An important purpose a firm holds dear and tells the world about.",
            definitionNative = "Важное назначение, что фирма ценит и о котором говорит миру.",
            example = "Their company mission is to make healthy food affordable to everyone.",
            exampleNative = "Mission их компании — сделать здоровую еду доступной каждому.",
            pos = "noun", semanticGroup = "business_targets", fillInBlankExclusions = listOf(42115L, 42117L)),

        WordEntity(id = 42117, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "deliverable", transliteration = "[dɪˈlɪvərəbl]", translation = "результат к сдаче",
            definition = "A finished piece of work that a team owes a client by a date.",
            definitionNative = "Готовая часть труда, что команда должна сдать клиенту к сроку.",
            example = "The first deliverable for the website is due on Monday.",
            exampleNative = "Первый deliverable по сайту нужно сдать в понедельник.",
            pos = "noun", semanticGroup = "business_targets", fillInBlankExclusions = listOf(42115L, 42116L)),

        // ── business_planning (2) ─────────────────────────────────────────

        WordEntity(id = 42118, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "quarterly", transliteration = "[ˈkwɔːrtərli]", translation = "ежеквартальный",
            definition = "Happening once every three months, like a season of the year.",
            definitionNative = "То, что бывает раз в три месяца — как сезон года.",
            example = "Our team holds a quarterly review every three months on Friday.",
            exampleNative = "Наша команда проводит quarterly разбор каждые три месяца в пятницу.",
            pos = "adjective", semanticGroup = "business_planning"),

        WordEntity(id = 42119, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "follow-up", transliteration = "[ˈfɒloʊ ʌp]", translation = "повторное обращение",
            definition = "A second contact after a first meeting or message, to check on things.",
            definitionNative = "Второй контакт после встречи или письма — узнать, как идут дела.",
            example = "I sent a polite follow-up a week after my first email.",
            exampleNative = "Я отправил вежливый follow-up через неделю после первого письма.",
            pos = "noun", semanticGroup = "business_planning"),

        // ── business_logistics (4) ────────────────────────────────────────

        WordEntity(id = 42120, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "warehouse", transliteration = "[ˈwɛərhaʊs]", translation = "склад",
            definition = "A huge building used to keep boxes of goods before shipping them.",
            definitionNative = "Огромное здание, где держат коробки с товаром до отправки.",
            example = "Our warehouse near the port stores tea bound for Europe.",
            exampleNative = "Наш warehouse у порта хранит чай, что идёт в Европу.",
            pos = "noun", semanticGroup = "business_logistics", fillInBlankExclusions = listOf(42123L)),

        WordEntity(id = 42121, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "restock", transliteration = "[riːˈstɒk]", translation = "пополнить запасы",
            definition = "Add new copies of a product after the shelves run empty.",
            definitionNative = "Поставить новые копии товара после того, как полки опустели.",
            example = "We restock the bread shelves twice every single morning.",
            exampleNative = "Мы restock хлебные полки дважды каждое утро.",
            pos = "verb", semanticGroup = "business_logistics"),

        WordEntity(id = 42122, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "bulk order", transliteration = "[bʌlk ˈɔːrdər]", translation = "оптовый заказ",
            definition = "A large purchase of many items at once, usually at a lower price.",
            definitionNative = "Большая покупка многих штук разом, обычно по сниженной цене.",
            example = "The school placed a bulk order of pencils for the new year.",
            exampleNative = "Школа сделала bulk order карандашей к новому учебному году.",
            pos = "phrase", semanticGroup = "business_logistics"),

        WordEntity(id = 42123, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "exchange", transliteration = "[ɪksˈtʃeɪndʒ]", translation = "обмен товара",
            definition = "When a shop swaps an item for another after the customer asks.",
            definitionNative = "Когда лавка меняет одну вещь на другую по просьбе клиента.",
            example = "She came in for a quick exchange — wrong shoe size.",
            exampleNative = "Она зашла на быстрый exchange — не тот размер обуви.",
            pos = "noun", semanticGroup = "business_logistics", fillInBlankExclusions = listOf(42120L)),

        // ── business_clients (2) ──────────────────────────────────────────

        WordEntity(id = 42124, setId = 421, languagePair = "en-ru", rarity = "RARE",
            original = "client base", transliteration = "[ˈklaɪənt beɪs]", translation = "клиентская база",
            definition = "The full group of people who regularly buy from a firm.",
            definitionNative = "Вся группа людей, что регулярно покупает у фирмы.",
            example = "Our client base grew steadily after the radio interview aired.",
            exampleNative = "Наш client base рос ровно после выхода интервью на радио.",
            pos = "phrase", semanticGroup = "business_clients", fillInBlankExclusions = listOf(42125L)),

        WordEntity(id = 42125, setId = 421, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "gift wrap", transliteration = "[ɡɪft ræp]", translation = "подарочная упаковка",
            definition = "A free or paid service that wraps your purchase in pretty paper.",
            definitionNative = "Услуга — бесплатная или платная — оборачивает покупку красивой бумагой.",
            example = "She added gift wrap at checkout for her mother's present.",
            exampleNative = "Она добавила gift wrap на кассе для маминого подарка.",
            pos = "phrase", semanticGroup = "business_clients", fillInBlankExclusions = listOf(42124L)),

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 422 — L3: стратегия, стартапы, agile (RARE+EPIC)             ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── business_strategy_advanced (5) ────────────────────────────────

        WordEntity(id = 42201, setId = 422, languagePair = "en-ru", rarity = "RARE",
            original = "segmentation", transliteration = "[ˌsɛɡmənˈteɪʃən]", translation = "сегментация рынка",
            definition = "Splitting buyers into groups by age, taste or income to serve them better.",
            definitionNative = "Деление покупателей на группы по возрасту, вкусу или доходу, чтобы лучше им служить.",
            example = "Better segmentation helped the brand reach quiet introvert readers.",
            exampleNative = "Удачная segmentation помогла марке достучаться до тихих читателей-интровертов.",
            pos = "noun", semanticGroup = "business_strategy_advanced", fillInBlankExclusions = listOf(42202L, 42204L, 42205L)),

        WordEntity(id = 42202, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "moat", transliteration = "[moʊt]", translation = "защитный ров",
            definition = "A lasting edge that keeps rivals from copying your business.",
            definitionNative = "Стойкое преимущество, что мешает соперникам скопировать дело.",
            example = "Apple's design talent is the moat around its premium prices.",
            exampleNative = "Дизайнерский талант Apple — это moat вокруг её высоких цен.",
            pos = "noun", semanticGroup = "business_strategy_advanced", fillInBlankExclusions = listOf(42201L, 42204L, 42205L)),

        WordEntity(id = 42203, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "network effect", transliteration = "[ˈnɛtwɜːrk ɪˈfɛkt]", translation = "сетевой эффект",
            definition = "When a service grows more useful as more people start using it.",
            definitionNative = "Когда сервис делается полезнее по мере того, как им пользуются всё больше людей.",
            example = "Social apps live or die on the strength of their network effect.",
            exampleNative = "Соцсети живут или гибнут от силы своего network effect.",
            pos = "phrase", semanticGroup = "business_strategy_advanced"),

        WordEntity(id = 42204, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "flywheel", transliteration = "[ˈflaɪwiːl]", translation = "маховик роста",
            definition = "A loop where small wins keep adding speed to a business over time.",
            definitionNative = "Петля, где мелкие победы постепенно разгоняют дело.",
            example = "Amazon's flywheel turns lower prices into higher traffic and back again.",
            exampleNative = "Flywheel Amazon превращает низкие цены в больший поток и обратно.",
            pos = "noun", semanticGroup = "business_strategy_advanced", fillInBlankExclusions = listOf(42201L, 42202L, 42205L)),

        WordEntity(id = 42205, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "disruption", transliteration = "[dɪsˈrʌpʃən]", translation = "подрыв рынка",
            definition = "When a fresh idea pushes old leaders out of a market quickly.",
            definitionNative = "Когда свежая мысль быстро вытесняет старых вождей с рынка.",
            example = "The e-bike caused real disruption in the urban delivery market.",
            exampleNative = "Электровелосипед вызвал настоящий disruption на городской доставке.",
            pos = "noun", semanticGroup = "business_strategy_advanced", fillInBlankExclusions = listOf(42201L, 42202L, 42204L)),

        // ── business_metrics (4) ──────────────────────────────────────────

        WordEntity(id = 42206, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "KPI", transliteration = "[ˌkeɪ piː ˈaɪ]", translation = "ключевой показатель",
            definition = "A simple number a team watches to know if work is going well.",
            definitionNative = "Простое число, по которому команда видит, хорошо ли идёт работа.",
            example = "Average wait time is the most important KPI in our cafe.",
            exampleNative = "Среднее время ожидания — главный KPI в нашем кафе.",
            pos = "noun", semanticGroup = "business_metrics", fillInBlankExclusions = listOf(42207L, 42209L)),

        WordEntity(id = 42207, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "ROI", transliteration = "[ˌɑːr oʊ ˈaɪ]", translation = "окупаемость вложений",
            definition = "How much money you earn back compared with what you spent.",
            definitionNative = "Сколько денег возвращается по сравнению с тем, что потрачено.",
            example = "The new oven gave us a great ROI within six months.",
            exampleNative = "Новая печь дала нам отличный ROI за полгода.",
            pos = "noun", semanticGroup = "business_metrics", fillInBlankExclusions = listOf(42206L, 42209L)),

        WordEntity(id = 42208, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "churn rate", transliteration = "[tʃɜːrn reɪt]", translation = "доля ушедших клиентов",
            definition = "The share of customers who quit a service during a set period.",
            definitionNative = "Доля клиентов, что уходят из сервиса за выбранный срок.",
            example = "A high churn rate hides growth that looks healthy from afar.",
            exampleNative = "Высокий churn rate прячет рост, что издали смотрится здоровым.",
            pos = "phrase", semanticGroup = "business_metrics"),

        WordEntity(id = 42209, setId = 422, languagePair = "en-ru", rarity = "RARE",
            original = "valuation", transliteration = "[ˌvæljuˈeɪʃən]", translation = "оценка стоимости",
            definition = "The price a firm is judged to be worth at a given moment.",
            definitionNative = "Цена, в какую оценивают дело в выбранный момент.",
            example = "The startup's valuation jumped after the deal with Microsoft.",
            exampleNative = "Valuation стартапа подскочила после сделки с Microsoft.",
            pos = "noun", semanticGroup = "business_metrics", fillInBlankExclusions = listOf(42206L, 42207L)),

        // ── business_startup (6) ──────────────────────────────────────────

        WordEntity(id = 42210, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "burn rate", transliteration = "[bɜːrn reɪt]", translation = "темп расходов",
            definition = "How fast a young firm uses up its cash month after month.",
            definitionNative = "Как быстро молодое дело тратит свои деньги месяц за месяцем.",
            example = "Their burn rate doubled after they hired ten engineers in spring.",
            exampleNative = "Их burn rate удвоился после найма десяти инженеров весной.",
            pos = "phrase", semanticGroup = "business_startup", fillInBlankExclusions = listOf(42211L)),

        WordEntity(id = 42211, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "seed round", transliteration = "[siːd raʊnd]", translation = "посевной раунд",
            definition = "The first small batch of money a young company raises from outsiders.",
            definitionNative = "Первая небольшая порция денег, что молодое дело берёт у сторонних людей.",
            example = "They closed a tiny seed round of half a million dollars.",
            exampleNative = "Они закрыли маленький seed round в полмиллиона долларов.",
            pos = "phrase", semanticGroup = "business_startup", fillInBlankExclusions = listOf(42210L)),

        WordEntity(id = 42212, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "crowdfunding", transliteration = "[ˈkraʊdˌfʌndɪŋ]", translation = "сбор средств в сети",
            definition = "Asking many strangers online to chip in a little for a project.",
            definitionNative = "Просить много незнакомцев в сети скинуться понемногу на проект.",
            example = "The board game was funded by crowdfunding from forty thousand fans.",
            exampleNative = "Настольная игра вышла благодаря crowdfunding от сорока тысяч поклонников.",
            pos = "noun", semanticGroup = "business_startup", fillInBlankExclusions = listOf(42215L)),

        WordEntity(id = 42213, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "bootstrap", transliteration = "[ˈbuːtstræp]", translation = "развивать без вложений",
            definition = "Build a young company using only its own income, no outside money.",
            definitionNative = "Растить молодое дело только на своих доходах, без сторонних денег.",
            example = "She chose to bootstrap her bakery rather than chase outside cash.",
            exampleNative = "Она решила bootstrap пекарню, а не гнаться за сторонними деньгами.",
            pos = "verb", semanticGroup = "business_startup", fillInBlankExclusions = listOf(42214L)),

        WordEntity(id = 42214, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "pivot", transliteration = "[ˈpɪvət]", translation = "сменить курс",
            definition = "Suddenly change a young company's main idea after lessons from users.",
            definitionNative = "Резко сменить главную мысль молодого дела после уроков от пользователей.",
            example = "We had to pivot when nobody bought the original gadget.",
            exampleNative = "Нам пришлось pivot, когда оригинальный гаджет никто не покупал.",
            pos = "verb", semanticGroup = "business_startup", fillInBlankExclusions = listOf(42213L)),

        WordEntity(id = 42215, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "unicorn", transliteration = "[ˈjuːnɪkɔːrn]", translation = "стартап-гигант",
            definition = "A young firm whose value passes one billion dollars on paper.",
            definitionNative = "Молодое дело, чья оценка переваливает за миллиард долларов на бумаге.",
            example = "The chat app became a unicorn just three years after launch.",
            exampleNative = "Чат-приложение стало unicorn всего через три года после запуска.",
            pos = "noun", semanticGroup = "business_startup", fillInBlankExclusions = listOf(42212L)),

        // ── business_strategy_terms (3) ───────────────────────────────────

        WordEntity(id = 42216, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "go-to-market", transliteration = "[ˌɡoʊ tə ˈmɑːrkɪt]", translation = "выход на рынок",
            definition = "The plan a firm uses to bring a new product to its first buyers.",
            definitionNative = "План, по которому фирма выводит новый товар к первым покупателям.",
            example = "Their go-to-market plan starts with three flagship cities in Europe.",
            exampleNative = "Их go-to-market план стартует с трёх флагманских городов Европы.",
            pos = "adjective", semanticGroup = "business_strategy_terms"),

        WordEntity(id = 42217, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "accelerator", transliteration = "[əkˈsɛləreɪtər]", translation = "акселератор стартапов",
            definition = "A program that helps young firms grow fast with money, advice and contacts.",
            definitionNative = "Программа, что быстро поднимает молодые дела деньгами, советами и связями.",
            example = "The accelerator picks twelve teams every spring from a thousand applicants.",
            exampleNative = "Этот accelerator берёт двенадцать команд каждую весну из тысячи заявок.",
            pos = "noun", semanticGroup = "business_strategy_terms", fillInBlankExclusions = listOf(42218L)),

        WordEntity(id = 42218, setId = 422, languagePair = "en-ru", rarity = "RARE",
            original = "takeover", transliteration = "[ˈteɪkˌoʊvər]", translation = "поглощение",
            definition = "When one firm gets full control of another by buying it out.",
            definitionNative = "Когда одно дело получает полный контроль над другим, выкупая его.",
            example = "The bank takeover triggered worry among workers in the branches.",
            exampleNative = "Банковский takeover вызвал тревогу у работников отделений.",
            pos = "noun", semanticGroup = "business_strategy_terms", fillInBlankExclusions = listOf(42217L)),

        // ── business_agile (4) ────────────────────────────────────────────

        WordEntity(id = 42219, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "agile", transliteration = "[ˈædʒaɪl]", translation = "гибкая методология",
            definition = "A way of working in short cycles with frequent feedback from users.",
            definitionNative = "Подход к делу короткими отрезками с частым отзывом от пользователей.",
            example = "Our team went agile and now ships an update every two weeks.",
            exampleNative = "Наша команда перешла на agile и теперь выпускает версию раз в две недели.",
            pos = "adjective", semanticGroup = "business_agile"),

        WordEntity(id = 42220, setId = 422, languagePair = "en-ru", rarity = "RARE",
            original = "backlog", transliteration = "[ˈbæklɔːɡ]", translation = "очередь задач",
            definition = "A queue of pending tasks that the team will tackle in order.",
            definitionNative = "Очередь незаконченных задач, что команда возьмёт по порядку.",
            example = "The backlog grew to two hundred items before the spring cleanup.",
            exampleNative = "Backlog разросся до двухсот пунктов перед весенней чисткой.",
            pos = "noun", semanticGroup = "business_agile", fillInBlankExclusions = listOf(42221L, 42222L)),

        WordEntity(id = 42221, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "standup", transliteration = "[ˈstændʌp]", translation = "ежедневная летучка",
            definition = "A brief daily meeting where each teammate shares progress and blockers.",
            definitionNative = "Короткая встреча каждый день — каждый рассказывает о прогрессе и помехах.",
            example = "Our morning standup never lasts more than fifteen minutes total.",
            exampleNative = "Наш утренний standup никогда не длится дольше пятнадцати минут.",
            pos = "noun", semanticGroup = "business_agile", fillInBlankExclusions = listOf(42220L, 42222L)),

        WordEntity(id = 42222, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "roadmap", transliteration = "[ˈroʊdmæp]", translation = "дорожная карта",
            definition = "A long-term plan that shows what a firm will ship and when.",
            definitionNative = "Долгий план, что и когда фирма будет выпускать.",
            example = "Our public roadmap shows three big features coming this autumn.",
            exampleNative = "Наш публичный roadmap обещает три крупные новинки к осени.",
            pos = "noun", semanticGroup = "business_agile", fillInBlankExclusions = listOf(42220L, 42221L)),

        // ── business_legal_basics (3) ─────────────────────────────────────

        WordEntity(id = 42223, setId = 422, languagePair = "en-ru", rarity = "RARE",
            original = "proprietary", transliteration = "[prəˈpraɪəˌtɛri]", translation = "запатентованный",
            definition = "Owned by one firm and not free for others to copy or sell.",
            definitionNative = "То, что принадлежит одной фирме и закрыто для копий других.",
            example = "Their proprietary recipe has stayed secret for over eighty years.",
            exampleNative = "Их proprietary рецепт остаётся тайной больше восьмидесяти лет.",
            pos = "adjective", semanticGroup = "business_legal_basics"),

        WordEntity(id = 42224, setId = 422, languagePair = "en-ru", rarity = "EPIC",
            original = "escalation", transliteration = "[ˌɛskəˈleɪʃən]", translation = "передача наверх",
            definition = "Sending a hard problem from junior staff up to senior managers.",
            definitionNative = "Передача трудной задачи от младших сотрудников к старшим начальникам.",
            example = "Difficult complaints need quick escalation to the duty manager.",
            exampleNative = "Сложные жалобы требуют быстрой escalation дежурному менеджеру.",
            pos = "noun", semanticGroup = "business_legal_basics"),

        WordEntity(id = 42225, setId = 422, languagePair = "en-ru", rarity = "RARE",
            original = "red tape", transliteration = "[rɛd teɪp]", translation = "бюрократические препоны",
            definition = "Slow, formal rules that make a simple task take far too long.",
            definitionNative = "Медленные правила, из-за которых простое дело тянется без меры долго.",
            example = "Permits for street kiosks involve a mountain of red tape.",
            exampleNative = "Разрешение на уличный киоск — это гора red tape.",
            pos = "phrase", semanticGroup = "business_legal_basics"),

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 423 — L4: M&A, корпоративная этика (EPIC+LEGENDARY)          ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── business_ma (5) ───────────────────────────────────────────────

        WordEntity(id = 42301, setId = 423, languagePair = "en-ru", rarity = "EPIC",
            original = "synergy", transliteration = "[ˈsɪnərdʒi]", translation = "синергия",
            definition = "When two firms together earn more than they would apart.",
            definitionNative = "Когда два дела вместе зарабатывают больше, чем порознь.",
            example = "The merger promised a synergy that never quite arrived in practice.",
            exampleNative = "Слияние сулило synergy, что так и не пришла на деле.",
            pos = "noun", semanticGroup = "business_ma", fillInBlankExclusions = listOf(42302L, 42303L, 42305L)),

        WordEntity(id = 42302, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "conglomerate", transliteration = "[kənˈɡlɒmərɪt]", translation = "конгломерат",
            definition = "A giant corporation that owns many unrelated firms in one group.",
            definitionNative = "Огромная корпорация — у неё много не связанных дел в одной группе.",
            example = "The conglomerate owns a bank, a tea brand and a film studio.",
            exampleNative = "Этот conglomerate владеет банком, чайной маркой и киностудией.",
            pos = "noun", semanticGroup = "business_ma", fillInBlankExclusions = listOf(42301L, 42303L, 42305L)),

        WordEntity(id = 42303, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "divestiture", transliteration = "[daɪˈvɛstɪtʃər]", translation = "продажа подразделения",
            definition = "Selling off part of a firm so the rest can focus more clearly.",
            definitionNative = "Продажа куска дела — остальная часть тогда сосредоточится яснее.",
            example = "The bank's divestiture of its insurance arm pleased the shareholders.",
            exampleNative = "Divestiture страхового крыла банка порадовало акционеров.",
            pos = "noun", semanticGroup = "business_ma", fillInBlankExclusions = listOf(42301L, 42302L, 42305L)),

        WordEntity(id = 42304, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hostile takeover", transliteration = "[ˈhɒstaɪl ˈteɪkˌoʊvər]", translation = "недружественное поглощение",
            definition = "Buying control of a firm against the wishes of its leaders.",
            definitionNative = "Захват контроля над делом наперекор воле его руководителей.",
            example = "The board fought off a hostile takeover with a clever defence.",
            exampleNative = "Совет отбил hostile takeover с помощью хитрой защиты.",
            pos = "phrase", semanticGroup = "business_ma"),

        WordEntity(id = 42305, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dissolution", transliteration = "[ˌdɪsəˈluːʃən]", translation = "роспуск компании",
            definition = "The official end of a firm, where the legal entity is closed for good.",
            definitionNative = "Официальный конец дела — юридическое лицо закрывают навсегда.",
            example = "After years of losses, the dissolution of the firm seemed inevitable.",
            exampleNative = "После лет убытков dissolution фирмы казалось неизбежным.",
            pos = "noun", semanticGroup = "business_ma", fillInBlankExclusions = listOf(42301L, 42302L, 42303L)),

        // ── business_market_structure (4) ─────────────────────────────────

        WordEntity(id = 42306, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "oligopoly", transliteration = "[ˌɒlɪˈɡɒpəli]", translation = "олигополия",
            definition = "A market where only a few large sellers control most of the trade.",
            definitionNative = "Рынок, где лишь несколько крупных продавцов держат большую часть торга.",
            example = "Three firms form a clear oligopoly in the local mobile market.",
            exampleNative = "Три фирмы образуют ясную oligopoly на местном мобильном рынке.",
            pos = "noun", semanticGroup = "business_market_structure"),

        WordEntity(id = 42307, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "monopolistic", transliteration = "[məˌnɒpəˈlɪstɪk]", translation = "монополистический",
            definition = "Behaving as if one seller controlled the whole market alone.",
            definitionNative = "Ведущий себя так, будто один продавец один владеет всем рынком.",
            example = "Regulators fined the firm for clearly monopolistic pricing on routes.",
            exampleNative = "Регуляторы оштрафовали фирму за откровенно monopolistic цены на маршрутах.",
            pos = "adjective", semanticGroup = "business_market_structure", fillInBlankExclusions = listOf(42308L)),

        WordEntity(id = 42308, setId = 423, languagePair = "en-ru", rarity = "EPIC",
            original = "antitrust", transliteration = "[ˌæntiˈtrʌst]", translation = "антимонопольный",
            definition = "Aimed at stopping a single firm from holding too much market power.",
            definitionNative = "Нацеленный на то, чтобы одна фирма не держала чрезмерной власти на рынке.",
            example = "The government opened an antitrust case against the search giant.",
            exampleNative = "Правительство открыло antitrust дело против поискового гиганта.",
            pos = "adjective", semanticGroup = "business_market_structure"),

        WordEntity(id = 42309, setId = 423, languagePair = "en-ru", rarity = "EPIC",
            original = "trade secret", transliteration = "[treɪd ˈsiːkrɪt]", translation = "коммерческая тайна",
            definition = "Hidden know-how a firm guards because rivals would copy it eagerly.",
            definitionNative = "Скрытое умение, что фирма стережёт — соперники бы охотно его скопировали.",
            example = "The chef's spice mix is a closely guarded trade secret.",
            exampleNative = "Смесь специй у повара — это тщательно охраняемый trade secret.",
            pos = "phrase", semanticGroup = "business_market_structure"),

        // ── business_corp_finance (5) ─────────────────────────────────────

        WordEntity(id = 42310, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "amortization", transliteration = "[əˌmɔːrtəˈzeɪʃən]", translation = "амортизация",
            definition = "Spreading the cost of a long-lasting asset across many years on paper.",
            definitionNative = "Раскладка стоимости долговечной вещи на много лет на бумаге.",
            example = "Annual amortization slowly trims the value of the new factory.",
            exampleNative = "Ежегодная amortization медленно урезает стоимость нового завода.",
            pos = "noun", semanticGroup = "business_corp_finance", fillInBlankExclusions = listOf(42311L, 42312L, 42313L)),

        WordEntity(id = 42311, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "goodwill", transliteration = "[ˈɡʊdwɪl]", translation = "деловая репутация",
            definition = "The unseen value of a brand and customer trust beyond physical things.",
            definitionNative = "Незримая ценность марки и доверия клиентов сверх вещественных активов.",
            example = "Most of the deal price reflected goodwill rather than equipment.",
            exampleNative = "Большую часть цены сделки составлял goodwill, а не оборудование.",
            pos = "noun", semanticGroup = "business_corp_finance", fillInBlankExclusions = listOf(42310L, 42312L, 42313L)),

        WordEntity(id = 42312, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "solvency", transliteration = "[ˈsɒlvənsi]", translation = "платёжеспособность",
            definition = "The ability of a firm to pay its long-term debts when they fall due.",
            definitionNative = "Способность фирмы платить по долгосрочным долгам в срок.",
            example = "Auditors raised serious concerns about the airline's long-term solvency.",
            exampleNative = "Аудиторы выразили серьёзные сомнения в долгосрочной solvency авиакомпании.",
            pos = "noun", semanticGroup = "business_corp_finance", fillInBlankExclusions = listOf(42310L, 42311L, 42313L)),

        WordEntity(id = 42313, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "underwriting", transliteration = "[ˈʌndərˌraɪtɪŋ]", translation = "андеррайтинг",
            definition = "When a bank takes on the risk of a new bond or share issue.",
            definitionNative = "Когда банк берёт на себя риск выпуска новых облигаций или акций.",
            example = "The bank earned millions from underwriting the famous airline's debut.",
            exampleNative = "Банк заработал миллионы на underwriting дебютного выпуска авиакомпании.",
            pos = "noun", semanticGroup = "business_corp_finance", fillInBlankExclusions = listOf(42310L, 42311L, 42312L)),

        WordEntity(id = 42314, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "intangible asset", transliteration = "[ɪnˈtændʒəbl ˈæsɛt]", translation = "нематериальный актив",
            definition = "A valuable thing you cannot touch — a brand, a patent or a licence.",
            definitionNative = "Ценность, что нельзя потрогать — марка, патент или лицензия.",
            example = "Their main intangible asset is the brand built over forty years.",
            exampleNative = "Их главный intangible asset — марка, выстроенная за сорок лет.",
            pos = "phrase", semanticGroup = "business_corp_finance"),

        // ── business_legal_advanced (5) ───────────────────────────────────

        WordEntity(id = 42315, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "indemnity", transliteration = "[ɪnˈdɛmnɪti]", translation = "возмещение убытков",
            definition = "A promise by one party to cover another's losses if trouble strikes.",
            definitionNative = "Обещание одной стороны покрыть потери другой, если случится беда.",
            example = "The contract included full indemnity against any tax surprises.",
            exampleNative = "Договор включал полную indemnity на случай налоговых сюрпризов.",
            pos = "noun", semanticGroup = "business_legal_advanced", fillInBlankExclusions = listOf(42316L, 42317L, 42318L)),

        WordEntity(id = 42316, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "covenant", transliteration = "[ˈkʌvənənt]", translation = "договорное обязательство",
            definition = "A binding promise written into a loan or partnership deal.",
            definitionNative = "Обещание, имеющее силу, вписанное в займ или соглашение партнёров.",
            example = "The covenant forbids opening any new branch within thirty kilometres.",
            exampleNative = "Этот covenant запрещает открывать новые филиалы в радиусе тридцати километров.",
            pos = "noun", semanticGroup = "business_legal_advanced", fillInBlankExclusions = listOf(42315L, 42317L, 42318L)),

        WordEntity(id = 42317, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "encumbrance", transliteration = "[ɪnˈkʌmbrəns]", translation = "обременение",
            definition = "A claim or burden tied to a property that limits its free use.",
            definitionNative = "Право или нагрузка на имущество, что ограничивает его свободное распоряжение.",
            example = "A small mortgage encumbrance still sits on the family's vineyard.",
            exampleNative = "Маленькое ипотечное encumbrance до сих пор висит на семейном винограднике.",
            pos = "noun", semanticGroup = "business_legal_advanced", fillInBlankExclusions = listOf(42315L, 42316L, 42318L)),

        WordEntity(id = 42318, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "escrow", transliteration = "[ˈɛskroʊ]", translation = "условное депонирование",
            definition = "A neutral hold of money or papers until both sides finish a deal.",
            definitionNative = "Беспристрастное хранение денег или бумаг, пока обе стороны не закончат сделку.",
            example = "The buyer placed the full sum in escrow until repairs finished.",
            exampleNative = "Покупатель положил всю сумму в escrow до окончания ремонта.",
            pos = "noun", semanticGroup = "business_legal_advanced", fillInBlankExclusions = listOf(42315L, 42316L, 42317L)),

        WordEntity(id = 42319, setId = 423, languagePair = "en-ru", rarity = "EPIC",
            original = "non-compete", transliteration = "[ˌnɒn kəmˈpiːt]", translation = "запрет на конкуренцию",
            definition = "A clause that bars an ex-employee from joining a rival for a while.",
            definitionNative = "Условие, что не пускает бывшего сотрудника к сопернику на какой-то срок.",
            example = "Her non-compete kept her out of the industry for a year.",
            exampleNative = "Её non-compete не пускал её в отрасль целый год.",
            pos = "phrase", semanticGroup = "business_legal_advanced"),

        // ── business_governance (3) ───────────────────────────────────────

        WordEntity(id = 42320, setId = 423, languagePair = "en-ru", rarity = "EPIC",
            original = "proxy", transliteration = "[ˈprɒksi]", translation = "доверенное лицо",
            definition = "A person allowed to vote at a meeting on behalf of someone else.",
            definitionNative = "Тот, кому позволено голосовать на собрании за другого человека.",
            example = "She voted by proxy because illness kept her at home.",
            exampleNative = "Она голосовала через proxy, потому что болезнь держала её дома.",
            pos = "noun", semanticGroup = "business_governance", fillInBlankExclusions = listOf(42321L)),

        WordEntity(id = 42321, setId = 423, languagePair = "en-ru", rarity = "EPIC",
            original = "boilerplate", transliteration = "[ˈbɔɪlərpleɪt]", translation = "стандартные формулировки",
            definition = "Standard wording reused in many contracts with little change.",
            definitionNative = "Стандартный текст, что переходит из договора в договор почти без правок.",
            example = "Lawyers replaced the old boilerplate with friendlier modern language.",
            exampleNative = "Юристы заменили старый boilerplate на более дружелюбный современный язык.",
            pos = "noun", semanticGroup = "business_governance", fillInBlankExclusions = listOf(42320L)),

        WordEntity(id = 42322, setId = 423, languagePair = "en-ru", rarity = "EPIC",
            original = "white-collar", transliteration = "[ˌwaɪt ˈkɒlər]", translation = "офисный (труд)",
            definition = "Linked to office jobs done at a desk rather than physical labour.",
            definitionNative = "Связанный с конторской работой за столом, а не с тяжёлым ручным трудом.",
            example = "The neighbourhood is full of white-collar parents working in finance.",
            exampleNative = "Район полон white-collar родителей, что трудятся в финансах.",
            pos = "adjective", semanticGroup = "business_governance"),

        // ── business_ethics (3) ───────────────────────────────────────────

        WordEntity(id = 42323, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "golden parachute", transliteration = "[ˈɡoʊldən ˈpærəʃuːt]", translation = "золотой парашют",
            definition = "A huge payout a top boss receives if the firm is sold or fires them.",
            definitionNative = "Крупная выплата начальнику, если фирму продали или его уволили.",
            example = "The chief left with a golden parachute worth twenty million dollars.",
            exampleNative = "Шеф ушёл с golden parachute в двадцать миллионов долларов.",
            pos = "phrase", semanticGroup = "business_ethics", fillInBlankExclusions = listOf(42324L)),

        WordEntity(id = 42324, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "poison pill", transliteration = "[ˈpɔɪzən pɪl]", translation = "ядовитая пилюля",
            definition = "A trick a board uses to make its firm uglier to a hostile buyer.",
            definitionNative = "Уловка совета, чтобы её дело стало менее привлекательным для враждебного покупателя.",
            example = "The board adopted a poison pill to scare off the foreign bidder.",
            exampleNative = "Совет принял poison pill, чтобы отпугнуть зарубежного претендента.",
            pos = "phrase", semanticGroup = "business_ethics", fillInBlankExclusions = listOf(42323L)),

        WordEntity(id = 42325, setId = 423, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "clawback", transliteration = "[ˈklɔːbæk]", translation = "возврат премии",
            definition = "Taking back a bonus already paid when later misconduct comes to light.",
            definitionNative = "Возврат уже выданной премии, если позже обнаружили нарушение.",
            example = "The new clawback rule lets the board reclaim past bonuses freely.",
            exampleNative = "Новое clawback правило позволяет совету спокойно вернуть прошлые премии.",
            pos = "noun", semanticGroup = "business_ethics"),

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 424 — L5: лексика для носителей (LEGENDARY)                  ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── business_market_advanced (5) ──────────────────────────────────

        WordEntity(id = 42401, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "monopsony", transliteration = "[məˈnɒpsəni]", translation = "монопсония",
            definition = "A market where only one buyer faces many competing sellers.",
            definitionNative = "Рынок, где лишь один покупатель против многих соперничающих продавцов.",
            example = "The army acts as a monopsony in the market for tanks.",
            exampleNative = "Армия выступает как monopsony на рынке танков.",
            pos = "noun", semanticGroup = "business_market_advanced", fillInBlankExclusions = listOf(42402L, 42404L)),

        WordEntity(id = 42402, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "duopoly", transliteration = "[djuːˈɒpəli]", translation = "дуополия",
            definition = "A market where exactly two big firms split nearly all the trade.",
            definitionNative = "Рынок, где ровно две большие фирмы делят почти весь оборот.",
            example = "The phone market in our country is a near duopoly.",
            exampleNative = "Телефонный рынок у нас в стране — это почти duopoly.",
            pos = "noun", semanticGroup = "business_market_advanced", fillInBlankExclusions = listOf(42401L, 42403L, 42404L)),

        WordEntity(id = 42403, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "oligopsony", transliteration = "[ˌɒlɪˈɡɒpsəni]", translation = "олигопсония",
            definition = "A market where only a handful of buyers face many sellers.",
            definitionNative = "Рынок, где только горстка покупателей напротив многих продавцов.",
            example = "Coffee farmers face an oligopsony of three giant roasting firms.",
            exampleNative = "Кофейные фермеры стоят перед oligopsony трёх гигантских обжарщиков.",
            pos = "noun", semanticGroup = "business_market_advanced"),

        WordEntity(id = 42404, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "fungibility", transliteration = "[ˌfʌndʒɪˈbɪlɪti]", translation = "взаимозаменяемость",
            definition = "The trait of one unit being fully swappable for another of the same kind.",
            definitionNative = "Свойство одной единицы быть полностью заменимой на другую того же рода.",
            example = "The fungibility of gold makes it ideal as a global reserve.",
            exampleNative = "Fungibility золота делает его идеальным мировым резервом.",
            pos = "noun", semanticGroup = "business_market_advanced", fillInBlankExclusions = listOf(42401L, 42402L, 42403L)),

        WordEntity(id = 42405, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "moral hazard", transliteration = "[ˈmɔːrəl ˈhæzərd]", translation = "моральный риск",
            definition = "When a shielded party takes greater risks because someone else pays for losses.",
            definitionNative = "Когда защищённая сторона смелее рискует, ведь убытки ляжет на чужие плечи.",
            example = "Bailouts create a moral hazard that haunts every future crisis.",
            exampleNative = "Спасательные пакеты создают moral hazard, что отзывается в каждом следующем кризисе.",
            pos = "phrase", semanticGroup = "business_market_advanced"),

        // ── business_econ_theory (5) ──────────────────────────────────────

        WordEntity(id = 42406, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "stagflation", transliteration = "[stæɡˈfleɪʃən]", translation = "стагфляция",
            definition = "A painful mix of rising prices and a sluggish, struggling economy.",
            definitionNative = "Болезненная смесь растущих цен и вялой, буксующей экономики.",
            example = "Many young economists have never lived through a real stagflation.",
            exampleNative = "Многие молодые экономисты никогда не жили при настоящей stagflation.",
            pos = "noun", semanticGroup = "business_econ_theory", fillInBlankExclusions = listOf(42409L, 42410L)),

        WordEntity(id = 42407, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "adverse selection", transliteration = "[ˈædvɜːrs sɪˈlɛkʃən]", translation = "неблагоприятный отбор",
            definition = "When the riskiest people are most eager to sign up for an offer.",
            definitionNative = "Когда самые рискованные люди охотнее всего откликаются на предложение.",
            example = "Adverse selection makes cheap insurance for sick patients hard to price.",
            exampleNative = "Adverse selection делает дешёвую страховку для больных трудной для расчёта.",
            pos = "phrase", semanticGroup = "business_econ_theory", fillInBlankExclusions = listOf(42408L)),

        WordEntity(id = 42408, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "agency cost", transliteration = "[ˈeɪdʒənsi kɒst]", translation = "агентские издержки",
            definition = "Losses caused when hired managers chase their own gains, not the owner's.",
            definitionNative = "Потери, что возникают, когда нанятые управляющие гонятся за своей выгодой, а не хозяйской.",
            example = "Lavish executive perks are a classic example of agency cost.",
            exampleNative = "Щедрые льготы начальникам — классический пример agency cost.",
            pos = "phrase", semanticGroup = "business_econ_theory", fillInBlankExclusions = listOf(42407L)),

        WordEntity(id = 42409, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "rentier", transliteration = "[ˈrɒntiˌeɪ]", translation = "рантье",
            definition = "A person who lives off income from property, bonds or investments.",
            definitionNative = "Тот, кто живёт на доход с имущества, облигаций или вложений.",
            example = "The novel describes a faded rentier on the Riviera coast.",
            exampleNative = "Роман описывает увядшего rentier на побережье Ривьеры.",
            pos = "noun", semanticGroup = "business_econ_theory", fillInBlankExclusions = listOf(42406L, 42410L)),

        WordEntity(id = 42410, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "seigniorage", transliteration = "[ˈseɪnjərɪdʒ]", translation = "доход эмитента",
            definition = "The gain a state earns from issuing money worth more than its cost.",
            definitionNative = "Выгода государства от выпуска денег, ценность которых выше затрат.",
            example = "Seigniorage from the dollar quietly funds part of the federal budget.",
            exampleNative = "Seigniorage с доллара тихо подпитывает часть федерального бюджета.",
            pos = "noun", semanticGroup = "business_econ_theory", fillInBlankExclusions = listOf(42406L, 42409L)),

        // ── business_policy (5) ───────────────────────────────────────────

        WordEntity(id = 42411, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dirigisme", transliteration = "[diˌriːˈʒiːzəm]", translation = "дирижизм",
            definition = "A style where the state guides the economy with a heavy hand.",
            definitionNative = "Подход, где государство ведёт экономику тяжёлой рукой.",
            example = "Post-war France leaned strongly toward dirigisme until the eighties.",
            exampleNative = "Послевоенная Франция сильно тяготела к dirigisme до восьмидесятых.",
            pos = "noun", semanticGroup = "business_policy", fillInBlankExclusions = listOf(42412L, 42413L, 42414L, 42415L)),

        WordEntity(id = 42412, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "autarky", transliteration = "[ˈɔːtɑːrki]", translation = "автаркия",
            definition = "When a country tries to make every needed thing inside its own borders.",
            definitionNative = "Когда страна пробует делать всё нужное внутри своих границ.",
            example = "Full autarky is a fantasy in a deeply connected modern world.",
            exampleNative = "Полная autarky — это мечта в тесно связанном современном мире.",
            pos = "noun", semanticGroup = "business_policy", fillInBlankExclusions = listOf(42411L, 42413L, 42415L)),

        WordEntity(id = 42413, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mercantilism", transliteration = "[ˈmɜːrkəntɪˌlɪzəm]", translation = "меркантилизм",
            definition = "An old idea where a country builds wealth by selling abroad and buying little.",
            definitionNative = "Старый взгляд: страна богатеет, много продавая за рубеж и мало ввозя.",
            example = "European mercantilism shaped much of seventeenth-century overseas trade.",
            exampleNative = "Европейский mercantilism определил большую часть заморской торговли семнадцатого века.",
            pos = "noun", semanticGroup = "business_policy", fillInBlankExclusions = listOf(42411L, 42412L, 42415L)),

        WordEntity(id = 42414, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "laissez-faire", transliteration = "[ˌlɛseɪ ˈfɛər]", translation = "невмешательство",
            definition = "A view that the state should hardly meddle in markets at all.",
            definitionNative = "Взгляд: государство должно почти не вмешиваться в рынки.",
            example = "Strict laissez-faire allowed factories to grow without serious safety rules.",
            exampleNative = "Строгий laissez-faire позволил заводам расти без серьёзных правил безопасности.",
            pos = "phrase", semanticGroup = "business_policy", fillInBlankExclusions = listOf(42411L, 42415L)),

        WordEntity(id = 42415, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "protectionism", transliteration = "[prəˈtɛkʃəˌnɪzəm]", translation = "протекционизм",
            definition = "Shielding home producers with high import tariffs and tight border rules.",
            definitionNative = "Защита домашних производителей высокими ввозными пошлинами и строгими границами.",
            example = "A wave of protectionism slowly slowed cross-border trade after the crisis.",
            exampleNative = "Волна protectionism потихоньку замедлила торговлю между странами после кризиса.",
            pos = "noun", semanticGroup = "business_policy", fillInBlankExclusions = listOf(42411L, 42412L, 42413L, 42414L)),

        // ── business_finance_advanced (5) ─────────────────────────────────

        WordEntity(id = 42416, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hypothecation", transliteration = "[haɪˌpɒθɪˈkeɪʃən]", translation = "залог имущества",
            definition = "Pledging property as security for a loan while keeping daily use of it.",
            definitionNative = "Передача имущества в обеспечение займа с правом обычного пользования им.",
            example = "Hypothecation lets a captain mortgage the ship without leaving harbour.",
            exampleNative = "Hypothecation позволяет капитану заложить судно, не покидая гавани.",
            pos = "noun", semanticGroup = "business_finance_advanced", fillInBlankExclusions = listOf(42417L, 42418L, 42419L, 42420L)),

        WordEntity(id = 42417, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tranche", transliteration = "[trɑːnʃ]", translation = "транш",
            definition = "One slice of a loan or bond release, given out separately from the rest.",
            definitionNative = "Один кусок займа или выпуска облигаций, что выдают отдельно от остальных.",
            example = "The first tranche of the bailout arrived earlier than expected.",
            exampleNative = "Первый tranche помощи пришёл раньше ожидаемого срока.",
            pos = "noun", semanticGroup = "business_finance_advanced", fillInBlankExclusions = listOf(42416L, 42418L, 42419L, 42420L)),

        WordEntity(id = 42418, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "contango", transliteration = "[kənˈtæŋɡoʊ]", translation = "контанго",
            definition = "When the future price of a good sits above its current spot price.",
            definitionNative = "Когда будущая цена товара выше его нынешней наличной цены.",
            example = "Oil markets entered contango as buyers feared a long-running glut.",
            exampleNative = "Нефтяные рынки вошли в contango, когда покупатели стали бояться долгого избытка.",
            pos = "noun", semanticGroup = "business_finance_advanced", fillInBlankExclusions = listOf(42416L, 42417L, 42419L, 42420L)),

        WordEntity(id = 42419, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "backwardation", transliteration = "[ˌbækwərˈdeɪʃən]", translation = "бэквордация",
            definition = "When the future price of a good sits below its current spot price.",
            definitionNative = "Когда будущая цена товара ниже его нынешней наличной цены.",
            example = "Sharp backwardation signals that buyers want copper urgently right now.",
            exampleNative = "Резкая backwardation подсказывает, что покупателям медь срочно нужна сейчас.",
            pos = "noun", semanticGroup = "business_finance_advanced", fillInBlankExclusions = listOf(42416L, 42417L, 42418L, 42420L)),

        WordEntity(id = 42420, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "greenmail", transliteration = "[ˈɡriːnmeɪl]", translation = "гринмейл",
            definition = "Buying many shares to scare a board into buying them back at a higher price.",
            definitionNative = "Скупка крупной доли акций, чтобы напугать совет и продать их обратно дороже.",
            example = "Old corporate raiders earned millions through skilful greenmail in the eighties.",
            exampleNative = "Старые корпоративные рейдеры зарабатывали миллионы умелым greenmail в восьмидесятые.",
            pos = "noun", semanticGroup = "business_finance_advanced", fillInBlankExclusions = listOf(42416L, 42417L, 42418L, 42419L)),

        // ── business_culture (5) ──────────────────────────────────────────

        WordEntity(id = 42421, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "zaibatsu", transliteration = "[zaɪˈbɑːtsuː]", translation = "дзайбацу",
            definition = "An old Japanese family-led empire of banks, shipyards and trading houses.",
            definitionNative = "Старая японская империя семейного склада: банки, верфи и торговые дома.",
            example = "Mitsui was once the most powerful zaibatsu in pre-war Japan.",
            exampleNative = "Мицуи когда-то был самым могучим zaibatsu в довоенной Японии.",
            pos = "noun", semanticGroup = "business_culture", fillInBlankExclusions = listOf(42422L, 42423L, 42424L)),

        WordEntity(id = 42422, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "chaebol", transliteration = "[ˈtʃeɪbɒl]", translation = "чеболь",
            definition = "A South Korean family-led conglomerate with deep ties to many industries.",
            definitionNative = "Южнокорейская семейная корпорация, тесно связанная со многими отраслями.",
            example = "Samsung is the most famous chaebol in modern Korean industry.",
            exampleNative = "Samsung — самый известный chaebol современной корейской промышленности.",
            pos = "noun", semanticGroup = "business_culture", fillInBlankExclusions = listOf(42421L, 42423L, 42424L)),

        WordEntity(id = 42423, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "keiretsu", transliteration = "[keɪˈrɛtsuː]", translation = "кэйрэцу",
            definition = "A loose Japanese network of firms held together by shares and shared banks.",
            definitionNative = "Свободный японский союз фирм, скреплённый акциями и общими банками.",
            example = "A modern keiretsu still binds Toyota to its many parts suppliers.",
            exampleNative = "Современный keiretsu всё ещё связывает Toyota с многими поставщиками.",
            pos = "noun", semanticGroup = "business_culture", fillInBlankExclusions = listOf(42421L, 42422L, 42424L)),

        WordEntity(id = 42424, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bricolage", transliteration = "[ˌbriːkəˈlɑːʒ]", translation = "бриколаж",
            definition = "Building something useful from whatever odd materials happen to be at hand.",
            definitionNative = "Создание чего-то полезного из тех случайных материалов, что под рукой.",
            example = "The early prototype was a charming bricolage of paper and wood.",
            exampleNative = "Ранний прототип был очаровательным bricolage из бумаги и дерева.",
            pos = "noun", semanticGroup = "business_culture", fillInBlankExclusions = listOf(42421L, 42422L, 42423L)),

        WordEntity(id = 42425, setId = 424, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "crony capitalism", transliteration = "[ˈkroʊni ˈkæpɪtəˌlɪzəm]", translation = "кумовской капитализм",
            definition = "An economy where success leans on close ties between bosses and officials.",
            definitionNative = "Хозяйство, где успех держится на тесных связях между начальством и чиновниками.",
            example = "Reformers blamed crony capitalism for the deep stagnation of the regions.",
            exampleNative = "Реформаторы винили crony capitalism в глубоком застое в регионах.",
            pos = "phrase", semanticGroup = "business_culture"),

    )
}
