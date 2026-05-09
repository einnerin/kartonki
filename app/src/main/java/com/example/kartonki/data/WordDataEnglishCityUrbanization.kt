package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 460.
 * Город: Районы и урбанизация (L3 / RARE + EPIC).
 *
 * Седьмой набор темы «Город». Дополняет:
 *   - 277 (L1) — заведения и улицы
 *   - 288 (L2) — общественные пространства, транспорт
 *   - 289 (L3) — муниципальные службы, планирование
 *   - 290 (L4) — урбанистика, градостроительство
 *   - 291 (L5) — теория города, антропология
 *   - 299 (L3 #2) — городской пейзаж, жильё, улицы
 *
 * Фокус — типы районов (slum, ghetto, barrio, inner city) и городская
 * иерархия / urban planning vocabulary (CBD, primate city, NIMBY/YIMBY,
 * anchor tenant, infill).
 */
object WordDataEnglishCityUrbanization {

    val sets = listOf(
        WordSetEntity(
            id = 460,
            name = "Город",
            description = "Типы районов и урбанизация: slum, gentrifier, NIMBY, CBD",
            languagePair = "en-ru",
            orderIndex = 460,
            topic = "Город",
            level = 3,
        ),
    )

    val words = listOf(

        // ── city_urbanization_districts (типы районов) ─────────────────────────
        WordEntity(
            id = 46001, original = "slum", transliteration = "[slʌm]", translation = "трущоба",
            definition = "A poor, run-down city area where people live in cramped, unsafe homes.",
            definitionNative = "Бедный, обветшалый район города, где люди живут в тесных и опасных жилищах.",
            example = "Half a million people live in this slum on the city's edge.",
            exampleNative = "Полмиллиона человек живут в этом slum на окраине города.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_districts",
         fillInBlankExclusions = listOf(46002L, 46003L, 46004L, 46005L, 46006L)),
        WordEntity(
            id = 46002, original = "ghetto", transliteration = "[ˈɡetoʊ]", translation = "гетто",
            definition = "A district where one ethnic or social group is forced to live apart from others.",
            definitionNative = "Район, в котором одна этническая или социальная группа вынуждена жить отдельно.",
            example = "She grew up in the Jewish ghetto of pre-war Warsaw.",
            exampleNative = "Она выросла в еврейском ghetto довоенной Варшавы.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_districts",
         fillInBlankExclusions = listOf(46001L, 46003L, 46004L, 46005L, 46006L)),
        WordEntity(
            id = 46003, original = "barrio", transliteration = "[ˈbɑːrioʊ]", translation = "латиноамериканский квартал",
            definition = "A Spanish-speaking neighborhood in a US city, usually with strong cultural ties.",
            definitionNative = "Испаноязычный квартал в американском городе с сильными культурными корнями.",
            example = "He opened a small bakery in the East LA barrio.",
            exampleNative = "Он открыл маленькую пекарню в barrio восточного Лос-Анджелеса.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_districts",
         fillInBlankExclusions = listOf(46001L, 46002L, 46004L, 46005L, 46006L)),
        WordEntity(
            id = 46004, original = "inner city", transliteration = "[ˈɪnər ˈsɪti]", translation = "центральные кварталы (бедные)",
            definition = "The older central part of a big city, often with poverty and aging buildings.",
            definitionNative = "Старая центральная часть крупного города — часто с бедностью и ветхими домами.",
            example = "Many inner city schools struggle with funding cuts every year.",
            exampleNative = "Многие inner city школы каждый год борются с сокращением бюджета.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_districts",
         fillInBlankExclusions = listOf(46001L, 46002L, 46003L, 46005L, 46006L)),
        WordEntity(
            id = 46005, original = "urban core", transliteration = "[ˈɜːrbən kɔːr]", translation = "ядро города",
            definition = "The dense central area of a city where jobs and shops are packed together.",
            definitionNative = "Плотная центральная часть города, где сосредоточены рабочие места и магазины.",
            example = "The new tram line links the suburbs straight to the urban core.",
            exampleNative = "Новая трамвайная линия связывает пригороды напрямую с urban core.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_districts",
         fillInBlankExclusions = listOf(46001L, 46002L, 46003L, 46004L, 46006L)),
        WordEntity(
            id = 46006, original = "borough", transliteration = "[ˈbʌroʊ]", translation = "административный округ (города)",
            definition = "A self-governing town or one of the five major divisions of New York City.",
            definitionNative = "Самоуправляемый городок или один из пяти округов Нью-Йорка.",
            example = "Brooklyn is the most populated borough in New York.",
            exampleNative = "Бруклин — самый населённый borough Нью-Йорка.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_districts",
         fillInBlankExclusions = listOf(46001L, 46002L, 46003L, 46004L, 46005L)),

        // ── city_urbanization_housing (жильё и его модели) ─────────────────────
        WordEntity(
            id = 46007, original = "council estate", transliteration = "[ˈkaʊnsəl ɪˈsteɪt]", translation = "социальное жильё (брит.)",
            definition = "A group of cheap homes built and rented out by the local government in Britain.",
            definitionNative = "Группа дешёвых жилищ, построенных и сдаваемых местной властью в Британии.",
            example = "He grew up on a rough council estate in south London.",
            exampleNative = "Он рос в неблагополучном council estate на юге Лондона.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_housing",
         fillInBlankExclusions = listOf(46008L, 46009L)),
        WordEntity(
            id = 46008, original = "housing project", transliteration = "[ˈhaʊzɪŋ ˈprɑːdʒekt]", translation = "социальное жильё (амер.)",
            definition = "An American group of low-rent flats funded by the government for poor families.",
            definitionNative = "Американский комплекс дешёвых квартир, финансируемых государством для бедных семей.",
            example = "The kids from the housing project play basketball every afternoon.",
            exampleNative = "Дети из housing project каждый день играют в баскетбол.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_housing",
         fillInBlankExclusions = listOf(46007L, 46009L)),
        WordEntity(
            id = 46009, original = "garden city", transliteration = "[ˈɡɑːrdən ˈsɪti]", translation = "город-сад",
            definition = "A planned town with lots of green space, designed to mix country and town life.",
            definitionNative = "Спланированный городок с обилием зелени, сочетающий деревенскую и городскую жизнь.",
            example = "Letchworth was the world's first garden city, built in 1903.",
            exampleNative = "Лечворт — первый в мире garden city, построенный в 1903 году.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_housing",
         fillInBlankExclusions = listOf(46007L, 46008L)),

        // ── city_urbanization_satellite (пригороды и отдельные поселения) ─────
        WordEntity(
            id = 46010, original = "satellite town", transliteration = "[ˈsætəlaɪt taʊn]", translation = "город-спутник",
            definition = "A smaller town near a big city, depending on it for jobs and services.",
            definitionNative = "Меньший городок рядом с крупным центром, зависящий от него по работе и услугам.",
            example = "Reading is a satellite town just west of London.",
            exampleNative = "Рединг — satellite town к западу от Лондона.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_satellite",
         fillInBlankExclusions = listOf(46011L, 46012L, 46013L)),
        WordEntity(
            id = 46011, original = "bedroom community", transliteration = "[ˈbedruːm kəˈmjuːnəti]", translation = "спальный пригород",
            definition = "A quiet town outside a big city where most adults sleep but work elsewhere.",
            definitionNative = "Тихий городок у крупного центра, откуда взрослые ездят на работу в другое место.",
            example = "Our village has become a bedroom community for the capital.",
            exampleNative = "Наша деревня превратилась в bedroom community для столицы.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_satellite",
         fillInBlankExclusions = listOf(46010L, 46012L, 46013L)),
        WordEntity(
            id = 46012, original = "ghost town", transliteration = "[ɡoʊst taʊn]", translation = "город-призрак (брошенный)",
            definition = "A place once full of people but now almost empty, often after the mines closed.",
            definitionNative = "Место, когда-то полное жителей, а теперь почти пустое — часто после закрытия шахт.",
            example = "Bodie became a ghost town when the gold ran out in the 1880s.",
            exampleNative = "Боди стал ghost town, когда в 1880-х закончилось золото.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_satellite",
         fillInBlankExclusions = listOf(46010L, 46011L, 46013L)),
        WordEntity(
            id = 46013, original = "boomtown", transliteration = "[ˈbuːmtaʊn]", translation = "процветающий новый город",
            definition = "A small place that suddenly grows fast because of oil, gold, or new industry.",
            definitionNative = "Небольшое место, которое внезапно быстро растёт из-за нефти, золота или новой отрасли.",
            example = "Williston turned into a boomtown during the oil rush.",
            exampleNative = "Уиллистон превратился в boomtown во время нефтяного бума.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_satellite",
         fillInBlankExclusions = listOf(46010L, 46011L, 46012L)),

        // ── city_urbanization_growth (динамика и доступность) ──────────────────
        WordEntity(
            id = 46014, original = "gentrifier", transliteration = "[ˈdʒentrɪfaɪər]", translation = "обновитель района (вытесняет бедных)",
            definition = "A wealthier newcomer whose arrival pushes long-time poorer residents out of an area.",
            definitionNative = "Более богатый новосёл, чьё появление вытесняет давних небогатых жителей квартала.",
            example = "Every gentrifier on this block raises the rent for old tenants.",
            exampleNative = "Каждый gentrifier на этом квартале поднимает аренду для старых жильцов.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_growth",
         fillInBlankExclusions = listOf(46015L, 46016L)),
        WordEntity(
            id = 46015, original = "food desert", transliteration = "[fuːd ˈdezərt]", translation = "район без доступа к свежей еде",
            definition = "A poor area with no nearby shops selling fresh fruit, vegetables, or healthy meals.",
            definitionNative = "Бедный квартал без ближайших магазинов со свежими фруктами, овощами и здоровой едой.",
            example = "This whole neighborhood is a food desert with only one corner shop.",
            exampleNative = "Весь этот район — настоящий food desert с одним угловым ларьком.",
            rarity = "RARE", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_growth",
         fillInBlankExclusions = listOf(46014L, 46016L)),
        WordEntity(
            id = 46016, original = "bikeability", transliteration = "[ˌbaɪkəˈbɪləti]", translation = "велосипедная доступность",
            definition = "How safe and easy it is to get around a town on two wheels.",
            definitionNative = "Насколько безопасно и удобно перемещаться по городу на двух колёсах.",
            example = "Copenhagen scores top marks for bikeability worldwide.",
            exampleNative = "Копенгаген получает высшие оценки по bikeability в мире.",
            rarity = "EPIC", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_growth",
         fillInBlankExclusions = listOf(46014L, 46015L)),

        // ── city_urbanization_hierarchy (иерархия городов) ─────────────────────
        WordEntity(
            id = 46017, original = "central business district", transliteration = "[ˈsentrəl ˈbɪznəs ˈdɪstrɪkt]", translation = "деловой центр (CBD)",
            definition = "The dense downtown zone with banks, offices, and tall corporate towers.",
            definitionNative = "Плотная городская зона с банками, офисами и высокими корпоративными башнями.",
            example = "The traffic jams in the central business district begin at six.",
            exampleNative = "Пробки в central business district начинаются в шесть утра.",
            rarity = "EPIC", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_hierarchy",
         fillInBlankExclusions = listOf(46018L, 46019L, 46020L)),
        WordEntity(
            id = 46018, original = "primate city", transliteration = "[ˈpraɪmət ˈsɪti]", translation = "доминирующий город страны",
            definition = "The leading city of a country that dwarfs every other place in size and power.",
            definitionNative = "Главный город страны, в разы крупнее и сильнее всех остальных населённых пунктов.",
            example = "Bangkok is the classic primate city of Thailand.",
            exampleNative = "Бангкок — классический primate city Таиланда.",
            rarity = "EPIC", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_hierarchy",
         fillInBlankExclusions = listOf(46017L, 46019L, 46020L)),
        WordEntity(
            id = 46019, original = "global city", transliteration = "[ˈɡloʊbəl ˈsɪti]", translation = "глобальный город (центр мировых процессов)",
            definition = "A major hub like London or Tokyo where world finance and culture meet.",
            definitionNative = "Крупный узел вроде Лондона или Токио, где сходятся мировые финансы и культура.",
            example = "London ranks as a top global city alongside New York.",
            exampleNative = "Лондон входит в число ведущих global city наравне с Нью-Йорком.",
            rarity = "EPIC", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_hierarchy",
         fillInBlankExclusions = listOf(46017L, 46018L, 46020L)),
        WordEntity(
            id = 46020, original = "superblock", transliteration = "[ˈsuːpərblɑːk]", translation = "суперблок (квартал без сквозных машин)",
            definition = "A large city block where through traffic is blocked and people walk freely.",
            definitionNative = "Крупный квартал, в котором закрыто сквозное движение, и люди ходят свободно.",
            example = "Each superblock in Barcelona turned a car street into a playground.",
            exampleNative = "Каждый superblock в Барселоне превратил автодорогу в детскую площадку.",
            rarity = "EPIC", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_hierarchy",
         fillInBlankExclusions = listOf(46017L, 46018L, 46019L)),

        // ── city_urbanization_planning (политика и инструменты) ────────────────
        WordEntity(
            id = 46021, original = "NIMBY", transliteration = "[ˈnɪmbi]", translation = "противник застройки рядом с собой",
            definition = "A resident who welcomes new buildings in theory but fights them next door.",
            definitionNative = "Житель, который в теории «за» новое строительство, но яростно против рядом с домом.",
            example = "Every loud NIMBY at the meeting fought against the new shelter.",
            exampleNative = "Каждый громкий NIMBY на собрании выступал против нового приюта.",
            rarity = "EPIC", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_planning",
         fillInBlankExclusions = listOf(46022L, 46023L, 46024L, 46025L)),
        WordEntity(
            id = 46022, original = "YIMBY", transliteration = "[ˈjɪmbi]", translation = "сторонник застройки рядом с собой",
            definition = "An activist who pushes for more housing to be built in their own neighborhood.",
            definitionNative = "Активист, выступающий за рост числа жилых домов в собственном квартале.",
            example = "A young YIMBY marched downtown demanding denser housing rules.",
            exampleNative = "Молодой YIMBY прошёл маршем, требуя плотных правил застройки.",
            rarity = "EPIC", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_planning",
         fillInBlankExclusions = listOf(46021L, 46023L, 46024L, 46025L)),
        WordEntity(
            id = 46023, original = "anchor tenant", transliteration = "[ˈæŋkər ˈtenənt]", translation = "якорный арендатор",
            definition = "A big well-known shop in a mall whose presence pulls in many smaller stores.",
            definitionNative = "Крупный известный магазин в моле, чьё присутствие привлекает много маленьких лавок.",
            example = "The mall lost half its visitors when its anchor tenant left.",
            exampleNative = "Мол потерял половину посетителей, когда оттуда ушёл anchor tenant.",
            rarity = "EPIC", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_planning",
         fillInBlankExclusions = listOf(46021L, 46022L, 46024L, 46025L)),
        WordEntity(
            id = 46024, original = "infill", transliteration = "[ˈɪnfɪl]", translation = "застройка пустырей в городе",
            definition = "Building new homes on empty lots between existing ones, instead of on green fields.",
            definitionNative = "Возведение новых домов на пустых участках между старыми, вместо зелёных полей.",
            example = "City planners now favor infill over endless suburban sprawl.",
            exampleNative = "Планировщики теперь предпочитают infill бесконечному пригородному разрастанию.",
            rarity = "EPIC", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_planning",
         fillInBlankExclusions = listOf(46021L, 46022L, 46023L, 46025L)),
        WordEntity(
            id = 46025, original = "ribbon development", transliteration = "[ˈrɪbən dɪˈveləpmənt]", translation = "застройка вдоль дороги",
            definition = "A long, thin line of houses built only along a main road, with empty land behind.",
            definitionNative = "Длинная узкая полоса домов вдоль главной дороги, с пустой землёй позади.",
            example = "Planners hate ribbon development because it eats up the countryside.",
            exampleNative = "Планировщики не любят ribbon development — он поглощает сельскую местность.",
            rarity = "EPIC", setId = 460, languagePair = "en-ru", pos = "noun",
            semanticGroup = "city_urbanization_planning",
         fillInBlankExclusions = listOf(46021L, 46022L, 46023L, 46024L)),
    )
}
