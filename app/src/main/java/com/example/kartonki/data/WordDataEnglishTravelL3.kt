package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Путешествия (level 3, углублённый / B2).
 *
 * Set 335: «Путешествия: углублённый» — бронирование, особенности маршрутов,
 * опыт путешественника. Лексика B2 для свободного общения о поездках.
 *
 * Распределение редкости: 22 RARE + 3 UNCOMMON — два смежных уровня шкалы,
 * с преобладанием RARE.
 *
 * Дополняет уже существующие сеты темы «Путешествия»:
 *   - Set 20  (WordDataEnglish.kt)        — L1 COMMON/UNCOMMON, основы.
 *   - Set 40  (WordDataEnglish.kt)        — L2 UNCOMMON, планирование и бронирование.
 *   - Set 261 (WordDataEnglishBatch6.kt)  — L2 COMMON/UNCOMMON, активный отдых на природе.
 *
 * Словарные пересечения с set 20/40/261/252 проверены grep — ни одно слово не повторяется.
 * Самые редкие литературные слова (peregrination, sojourn, peripatetic) оставлены для L4/L5.
 *
 * SemanticGroups (5 × 5):
 *   travel_planning       — booking, round-trip, one-way, off-season, peak season
 *   travel_documents      — declaration, consulate, travel insurance, landing card, roaming
 *   travel_routes         — bypass, shortcut, expedition, voyage, getaway
 *   travel_accommodation  — lodging, guesthouse, upgrade, all-inclusive, self-catering
 *   travel_experience     — scenic, breathtaking, memorable, trekker, nomad
 *
 * Word IDs: 33501..33525 (setId × 100 + position).
 */
object WordDataEnglishTravelL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 335, name = "Путешествия",
            description = "Углублённая лексика путешествий: бронирование, особенности маршрутов, опыт путешественника",
            languagePair = "en-ru",
            topic = "Путешествия", level = 3),
    )

    val words: List<WordEntity> = listOf(

        // ── travel_planning (5) ───────────────────────────────────────────

        WordEntity(id = 33501, setId = 335, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "booking", transliteration = "[ˈbʊkɪŋ]", translation = "бронь / запись на услугу",
            definition = "An arrangement made in advance for a hotel room, table or seat.",
            definitionNative = "Заранее оформленная договорённость на номер, столик или место.",
            example = "I made a booking for two nights at a small hotel near the beach.",
            exampleNative = "Я оформил booking на две ночи в маленьком отеле у пляжа.",
            pos = "noun", semanticGroup = "travel_planning", fillInBlankExclusions = listOf(33505L, 33515L)),

        WordEntity(id = 33502, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "round-trip", transliteration = "[ˌraʊnd ˈtrɪp]", translation = "туда-обратно (билет / поездка)",
            definition = "Going to a place and coming back to where you started — both ways.",
            definitionNative = "Поездка до пункта и возвращение домой — оба направления вместе.",
            example = "A round-trip ticket to Lisbon was cheaper than buying two separate flights.",
            exampleNative = "Билет round-trip до Лиссабона вышел дешевле двух отдельных перелётов.",
            pos = "adjective", semanticGroup = "travel_planning"),

        WordEntity(id = 33503, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "one-way", transliteration = "[ˌwʌn ˈweɪ]", translation = "в одну сторону (билет / маршрут)",
            definition = "Going only to a place, with no return part included in the ticket.",
            definitionNative = "Только до пункта назначения — без обратной части в билете.",
            example = "She bought a one-way ticket to Berlin and decided to stay for years.",
            exampleNative = "Она купила one-way билет в Берлин и осталась там на годы.",
            pos = "adjective", semanticGroup = "travel_planning", fillInBlankExclusions = listOf(33502L)),

        WordEntity(id = 33504, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "off-season", transliteration = "[ˌɔf ˈsizən]", translation = "несезон (тихое время для туризма)",
            definition = "The quiet time of year when few tourists come — prices and crowds drop.",
            definitionNative = "Тихое время года, когда туристов мало — цены и толпы падают.",
            example = "We visited Venice in the off-season and barely saw another tourist.",
            exampleNative = "Мы приехали в Венецию в off-season и почти не встретили туристов.",
            pos = "noun", semanticGroup = "travel_planning", fillInBlankExclusions = listOf(33501L, 33505L)),

        WordEntity(id = 33505, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "peak season", transliteration = "[pik ˈsizən]", translation = "высокий сезон (наплыв туристов)",
            definition = "The busy time when crowds arrive and prices rise — usually summer or holidays.",
            definitionNative = "Самое шумное время с толпами и высокими ценами — обычно лето или праздники.",
            example = "Hotels in Greece double their rates during the peak season.",
            exampleNative = "Отели в Греции удваивают цены в peak season.",
            pos = "noun", semanticGroup = "travel_planning", fillInBlankExclusions = listOf(33501L, 33504L)),

        // ── travel_documents (5) ──────────────────────────────────────────

        WordEntity(id = 33506, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "declaration", transliteration = "[ˌdɛkləˈreɪʃən]", translation = "декларация (таможенная)",
            definition = "A written list of items you carry — shown to officers at the border.",
            definitionNative = "Письменный перечень провозимых вещей — показывают офицеру на границе.",
            example = "He filled out a declaration for the antique watch in his suitcase.",
            exampleNative = "Он заполнил declaration на старинные часы у себя в чемодане.",
            pos = "noun", semanticGroup = "travel_documents", fillInBlankExclusions = listOf(33507L, 33508L, 33509L, 33510L)),

        WordEntity(id = 33507, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "consulate", transliteration = "[ˈkɑnsələt]", translation = "консульство",
            definition = "A foreign country's office abroad that helps its citizens with papers.",
            definitionNative = "Зарубежное представительство страны, помогающее своим гражданам с документами.",
            example = "I went to the French consulate to renew my expired passport.",
            exampleNative = "Я сходил во французский consulate за обновлением просроченного паспорта.",
            pos = "noun", semanticGroup = "travel_documents", fillInBlankExclusions = listOf(33506L, 33508L, 33509L, 33510L)),

        WordEntity(id = 33508, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "travel insurance", transliteration = "[ˈtrævəl ɪnˈʃʊrəns]", translation = "страховка для путешествий",
            definition = "A paid plan that covers medical bills or lost bags during a trip abroad.",
            definitionNative = "Оплаченный полис, покрывающий медицину или утерю сумок в зарубежной поездке.",
            example = "Good travel insurance saved us when my husband broke his leg in Spain.",
            exampleNative = "Хорошая travel insurance выручила нас, когда муж сломал ногу в Испании.",
            pos = "noun", semanticGroup = "travel_documents", fillInBlankExclusions = listOf(33506L, 33507L, 33509L, 33510L)),

        WordEntity(id = 33509, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "landing card", transliteration = "[ˈlændɪŋ kɑrd]", translation = "миграционная карта (на прилёте)",
            definition = "A small form a foreign visitor fills out before passing through immigration.",
            definitionNative = "Небольшой бланк, который иностранный гость заполняет перед пограничным контролем.",
            example = "The flight attendant handed me a landing card to fill out before arrival.",
            exampleNative = "Стюардесса дала мне landing card для заполнения до прилёта.",
            pos = "noun", semanticGroup = "travel_documents", fillInBlankExclusions = listOf(33506L, 33507L, 33508L, 33510L)),

        WordEntity(id = 33510, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "roaming", transliteration = "[ˈroʊmɪŋ]", translation = "роуминг (мобильная связь за границей)",
            definition = "Using your phone on a foreign network — extra charges often apply.",
            definitionNative = "Использование телефона в чужой сети — обычно с дополнительной платой.",
            example = "I switched off roaming to avoid a huge bill while abroad.",
            exampleNative = "Я выключил roaming, чтобы не получить огромный счёт за границей.",
            pos = "noun", semanticGroup = "travel_documents", fillInBlankExclusions = listOf(33506L, 33507L, 33508L, 33509L)),

        // ── travel_routes (5) ─────────────────────────────────────────────

        WordEntity(id = 33511, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "bypass", transliteration = "[ˈbaɪˌpæs]", translation = "объездная дорога / путь в обход города",
            definition = "A road that lets traffic go around a town instead of through it.",
            definitionNative = "Дорога, по которой машины обходят город, не въезжая в его центр.",
            example = "We took the bypass to avoid the slow traffic in the old town.",
            exampleNative = "Мы поехали по bypass, чтобы не стоять в пробках старого города.",
            pos = "noun", semanticGroup = "travel_routes", fillInBlankExclusions = listOf(33512L, 33513L, 33514L, 33515L)),

        WordEntity(id = 33512, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "shortcut", transliteration = "[ˈʃɔrtˌkʌt]", translation = "короткий путь",
            definition = "A quicker way that saves time — through a back street or hidden path.",
            definitionNative = "Более быстрый путь, экономящий время — через переулок или скрытую тропу.",
            example = "Our local guide showed us a shortcut to the old market square.",
            exampleNative = "Местный гид показал нам shortcut до старой рыночной площади.",
            pos = "noun", semanticGroup = "travel_routes", fillInBlankExclusions = listOf(33511L, 33514L, 33515L)),

        WordEntity(id = 33513, setId = 335, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "expedition", transliteration = "[ˌɛkspəˈdɪʃən]", translation = "экспедиция (организованный поход)",
            definition = "An organised trip to a far or wild place for research, climbing or exploring.",
            definitionNative = "Организованный поход в дальнее или дикое место для науки, восхождения или открытий.",
            example = "Their expedition to the Amazon lasted six gruelling weeks.",
            exampleNative = "Их expedition в Амазонию длилась изнурительные шесть недель.",
            pos = "noun", semanticGroup = "travel_routes", fillInBlankExclusions = listOf(33511L, 33512L, 33514L, 33515L)),

        WordEntity(id = 33514, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "voyage", transliteration = "[ˈvɔɪɪʤ]", translation = "плавание / долгое морское путешествие",
            definition = "A long trip by ship or sea — across oceans or between distant ports.",
            definitionNative = "Долгая поездка на корабле или по морю — через океаны или меж дальними портами.",
            example = "Their voyage across the Atlantic took twelve days in rough weather.",
            exampleNative = "Их voyage через Атлантику длилось двенадцать дней в шторм.",
            pos = "noun", semanticGroup = "travel_routes", fillInBlankExclusions = listOf(33511L, 33512L, 33513L, 33515L)),

        WordEntity(id = 33515, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "getaway", transliteration = "[ˈɡɛtəˌweɪ]", translation = "вылазка / короткий отдых",
            definition = "A short break away from daily life — a weekend by the sea or hills.",
            definitionNative = "Короткий побег от рутины — выходные у моря или в горах.",
            example = "We need a quiet getaway after these stressful months at work.",
            exampleNative = "Нам нужен тихий getaway после этих месяцев стресса на работе.",
            pos = "noun", semanticGroup = "travel_routes", fillInBlankExclusions = listOf(33511L, 33512L, 33513L, 33514L)),

        // ── travel_accommodation (5) ──────────────────────────────────────

        WordEntity(id = 33516, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "lodging", transliteration = "[ˈlɑʤɪŋ]", translation = "ночлег / временное жильё",
            definition = "A temporary place to sleep during a trip — could be a room or a cabin.",
            definitionNative = "Временное место для сна в поездке — комната или избушка.",
            example = "We found cheap lodging near the train station for the weekend.",
            exampleNative = "Мы нашли дешёвый lodging возле вокзала на выходные.",
            pos = "noun", semanticGroup = "travel_accommodation", fillInBlankExclusions = listOf(33517L, 33518L)),

        WordEntity(id = 33517, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "guesthouse", transliteration = "[ˈɡɛstˌhaʊs]", translation = "пансион / небольшой семейный отель",
            definition = "A small private home where the owner rents out rooms to visitors.",
            definitionNative = "Маленький частный дом, где хозяин сдаёт комнаты приезжим.",
            example = "The owner of the guesthouse cooked breakfast for us every morning.",
            exampleNative = "Хозяин guesthouse каждое утро готовил нам завтрак.",
            pos = "noun", semanticGroup = "travel_accommodation", fillInBlankExclusions = listOf(33516L, 33518L)),

        WordEntity(id = 33518, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "upgrade", transliteration = "[ˈʌpˌɡreɪd]", translation = "повышение класса (номера, билета)",
            definition = "A free move to a better room or seat — usually given as a small gift.",
            definitionNative = "Бесплатный перевод в номер или кресло получше — обычно как маленький подарок.",
            example = "The clerk gave us a free upgrade to a sea-view room.",
            exampleNative = "Администратор подарил нам upgrade до номера с видом на море.",
            pos = "noun", semanticGroup = "travel_accommodation", fillInBlankExclusions = listOf(33516L, 33517L)),

        WordEntity(id = 33519, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "all-inclusive", transliteration = "[ˌɔl ɪnˈklusɪv]", translation = "всё включено (тип отдыха)",
            definition = "A holiday plan where meals, drinks and activities are paid for in advance.",
            definitionNative = "Тип отдыха, где еда, напитки и развлечения уже оплачены заранее.",
            example = "Our all-inclusive resort had unlimited buffets and three swimming pools.",
            exampleNative = "Наш all-inclusive курорт предлагал шведский стол без ограничений и три бассейна.",
            pos = "adjective", semanticGroup = "travel_accommodation", fillInBlankExclusions = listOf(33520L, 33521L)),

        WordEntity(id = 33520, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "self-catering", transliteration = "[ˌsɛlf ˈkeɪtərɪŋ]", translation = "с самостоятельной готовкой (без питания от отеля)",
            definition = "Renting a place with a kitchen where guests cook their own meals.",
            definitionNative = "Аренда жилья с кухней, где гости сами себе готовят еду.",
            example = "We rented a self-catering cottage to save money on restaurants.",
            exampleNative = "Мы сняли self-catering коттедж, чтобы сэкономить на ресторанах.",
            pos = "adjective", semanticGroup = "travel_accommodation"),

        // ── travel_experience (5) ─────────────────────────────────────────

        WordEntity(id = 33521, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "scenic", transliteration = "[ˈsinɪk]", translation = "живописный (вид, маршрут)",
            definition = "Showing wide, beautiful views — usually mountains, lakes or coastline.",
            definitionNative = "Открывающий широкие красивые виды — горы, озёра или берег моря.",
            example = "We chose the scenic route along the cliffs instead of the highway.",
            exampleNative = "Мы выбрали scenic маршрут вдоль скал вместо автострады.",
            pos = "adjective", semanticGroup = "travel_experience", fillInBlankExclusions = listOf(33522L, 33523L)),

        WordEntity(id = 33522, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "breathtaking", transliteration = "[ˈbrɛθˌteɪkɪŋ]", translation = "захватывающий дух (вид, пейзаж)",
            definition = "So beautiful or huge that you forget to draw air for a moment.",
            definitionNative = "Настолько красивый или огромный, что на миг забываешь дышать.",
            example = "The view from the cliff at sunset was simply breathtaking.",
            exampleNative = "Вид с обрыва на закате был просто breathtaking.",
            pos = "adjective", semanticGroup = "travel_experience", fillInBlankExclusions = listOf(33521L, 33523L)),

        WordEntity(id = 33523, setId = 335, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "memorable", transliteration = "[ˈmɛmərəbəl]", translation = "запоминающийся / незабываемый",
            definition = "Worth keeping in mind for years — leaves a strong feeling behind.",
            definitionNative = "Стоящий долгой памяти — оставляет сильное чувство после себя.",
            example = "Watching the sunrise from the temple was the most memorable moment.",
            exampleNative = "Закат с храма был самым memorable моментом поездки.",
            pos = "adjective", semanticGroup = "travel_experience", fillInBlankExclusions = listOf(33521L, 33522L)),

        WordEntity(id = 33524, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "trekker", transliteration = "[ˈtrɛkər]", translation = "путешественник в дальний пеший поход",
            definition = "A person on a long, hard journey on foot through wild country.",
            definitionNative = "Человек в долгом тяжёлом пешем походе по дикой местности.",
            example = "A tired trekker stopped at our camp to ask for fresh water.",
            exampleNative = "Уставший trekker зашёл к нам в лагерь попросить свежей воды.",
            pos = "noun", semanticGroup = "travel_experience", fillInBlankExclusions = listOf(33525L)),

        WordEntity(id = 33525, setId = 335, languagePair = "en-ru", rarity = "RARE",
            original = "nomad", transliteration = "[ˈnoʊˌmæd]", translation = "кочевник / странник без постоянного дома",
            definition = "A person who lives moving from place to place — no fixed home anywhere.",
            definitionNative = "Человек, живущий переездами с места на место — без постоянного дома.",
            example = "He works online and lives like a digital nomad across Asia.",
            exampleNative = "Он работает онлайн и живёт как цифровой nomad по всей Азии.",
            pos = "noun", semanticGroup = "travel_experience", fillInBlankExclusions = listOf(33524L)),
    )
}
