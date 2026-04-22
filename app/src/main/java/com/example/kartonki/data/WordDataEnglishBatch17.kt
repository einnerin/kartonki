package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — batch 17.
 * Set 299: Город: углублённый 2 (L3 / RARE-centered).
 *
 * Тема — элементы городского пейзажа, типы жилья и улиц.
 * Дополняет setId 289 (urban planning / infrastructure / governance),
 * который покрывает "Город: углублённый" с другой стороны.
 */
object WordDataEnglishBatch17 {

    val sets = listOf(
        WordSetEntity(id = 299, name = "Город: углублённый 2",
            description = "Элементы городского пейзажа, жильё и улицы",
            languagePair = "en-ru", orderIndex = 299,
            topic = "Город", level = 3),
    )

    val words = listOf(

        // ── Set 299 — Город: углублённый 2 (RARE-центрированный: UNCOMMON + RARE) ─

        WordEntity(id = 29901, original = "neighborhood", transliteration = "[ˈneɪbərhʊd]", translation = "район, окрестности",
            definition = "The area around your home, with the streets and people you know.",
            definitionNative = "Пространство вокруг дома: знакомые улицы, лавки и соседи.",
            example = "The whole neighborhood came out to watch the parade.",
            exampleNative = "Весь neighborhood вышел смотреть парад.",
            rarity = "UNCOMMON", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "urban_area"),

        WordEntity(id = 29902, original = "plaza", transliteration = "[ˈplɑːzə]", translation = "городская площадь",
            definition = "An open paved area in a town, often with shops or fountains.",
            definitionNative = "Открытая мощёная зона в центре, обычно с магазинами и фонтанами.",
            example = "The old town's plaza is full of cafés and statues.",
            exampleNative = "На главной plaza было многолюдно в тот вечер.",
            rarity = "UNCOMMON", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "public_space", isFillInBlankSafe = false),

        WordEntity(id = 29903, original = "footpath", transliteration = "[ˈfʊtpæθ]", translation = "пешеходная дорожка",
            definition = "A narrow walking route made just for people, not for cars.",
            definitionNative = "Узкая тропинка в парке или между улицами — только для людей.",
            example = "A muddy footpath winds around the lake behind the village.",
            exampleNative = "Грязный footpath вился вокруг озера за деревней.",
            rarity = "UNCOMMON", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "street_type", isFillInBlankSafe = false),

        WordEntity(id = 29904, original = "rooftop", transliteration = "[ˈruːftɒp]", translation = "крыша здания",
            definition = "The surface crowning a building, where some cities put gardens or bars.",
            definitionNative = "Верхняя плоскость дома — порой превращённая в сад, бар или террасу.",
            example = "The hotel's rooftop bar has the best view in town.",
            exampleNative = "Rooftop-бар отеля — лучший вид в городе.",
            rarity = "UNCOMMON", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "building_exterior", isFillInBlankSafe = false),

        WordEntity(id = 29905, original = "quarter", transliteration = "[ˈkwɔːrtər]", translation = "квартал (городской)",
            definition = "A city district with its own style, shaped by history or local trade.",
            definitionNative = "Часть города со своим характером — по истории, ремеслу или жителям.",
            example = "We got lost in Paris's Latin Quarter last night.",
            exampleNative = "Мы заблудились в Латинском quarter Парижа.",
            rarity = "UNCOMMON", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "urban_area", isFillInBlankSafe = false),

        WordEntity(id = 29906, original = "signpost", transliteration = "[ˈsaɪnpoʊst]", translation = "указатель",
            definition = "A tall board with arrows telling you where places are around town.",
            definitionNative = "Высокий щит со стрелками, показывающий направления к объектам.",
            example = "The rusty signpost at the crossroads had faded arrows.",
            exampleNative = "Ржавый signpost на перекрёстке с выцветшими стрелками.",
            rarity = "UNCOMMON", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "street_fixture", isFillInBlankSafe = false),

        WordEntity(id = 29907, original = "lawn", transliteration = "[lɔːn]", translation = "газон",
            definition = "A patch of short grass in front of a house or in a park.",
            definitionNative = "Ровный участок подстриженной травы у дома или в парке.",
            example = "His front lawn is the greenest on our street.",
            exampleNative = "Его передний lawn — самый зелёный на улице.",
            rarity = "UNCOMMON", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "urban_greenery", isFillInBlankSafe = false),

        WordEntity(id = 29908, original = "tenement", transliteration = "[ˈtenəmənt]", translation = "доходный дом",
            definition = "An old city building split into many small, cheap flats.",
            definitionNative = "Старое городское здание, разделённое на множество дешёвых квартир.",
            example = "The tenement had six flights of stairs and no lift.",
            exampleNative = "В tenement было шесть пролётов лестницы и ни одного лифта.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "housing_type", isFillInBlankSafe = false),

        WordEntity(id = 29909, original = "townhouse", transliteration = "[ˈtaʊnhaʊs]", translation = "таунхаус",
            definition = "A narrow multi-floor dwelling joined to its neighbours by shared walls.",
            definitionNative = "Узкое многоэтажное жильё, сцепленное с соседями общими стенами.",
            example = "A row of brick townhouses lines the whole street.",
            exampleNative = "Ряд кирпичных townhouse тянется вдоль всей улицы.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "housing_type", isFillInBlankSafe = false),

        WordEntity(id = 29910, original = "duplex", transliteration = "[ˈduːpleks]", translation = "дуплекс, двухквартирный дом",
            definition = "A building split into two separate flats, one above or next to the other.",
            definitionNative = "Здание из двух независимых жилищ — друг над другом или рядом.",
            example = "They rent the upper half of a duplex near the school.",
            exampleNative = "Они снимают верхний этаж duplex у школы.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "housing_type", isFillInBlankSafe = false),

        WordEntity(id = 29911, original = "bungalow", transliteration = "[ˈbʌŋɡəloʊ]", translation = "бунгало",
            definition = "A small one-story house, often with a wide porch and a sloping roof.",
            definitionNative = "Небольшой одноэтажный дом с широким крыльцом и скатной крышей.",
            example = "A thatched bungalow by the lake was our summer home.",
            exampleNative = "Соломенный bungalow у озера был нашим летним домом.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "housing_type", isFillInBlankSafe = false),

        WordEntity(id = 29912, original = "arcade", transliteration = "[ɑːrˈkeɪd]", translation = "пассаж, крытая галерея",
            definition = "A covered passage lined with shops, held up by a row of arches.",
            definitionNative = "Застеклённый проход с магазинами по сторонам, опирающийся на ряд арок.",
            example = "A glass-roofed arcade connects the two shopping streets.",
            exampleNative = "Стеклянный arcade соединяет две торговые улицы.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "public_space", isFillInBlankSafe = false),

        WordEntity(id = 29913, original = "cobblestone", transliteration = "[ˈkɒbəlstoʊn]", translation = "брусчатка, булыжник",
            definition = "A rounded, hand-size rock used to pave old streets and squares.",
            definitionNative = "Округлый камень с кулак, которым мостили старые улицы и площади.",
            example = "Walking on cobblestones in heels is nearly impossible.",
            exampleNative = "Ходить по cobblestone на каблуках — настоящая мука.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "street_fixture", isFillInBlankSafe = false),

        WordEntity(id = 29914, original = "awning", transliteration = "[ˈɔːnɪŋ]", translation = "навес, тент (над входом)",
            definition = "A sloping cover above a window or door to block sun and rain.",
            definitionNative = "Косой козырёк над окном или дверью — защищает от солнца и дождя.",
            example = "The striped awning over the bakery kept the sun off our table.",
            exampleNative = "Полосатый awning над пекарней защищал нас от солнца.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "building_exterior", isFillInBlankSafe = false),

        WordEntity(id = 29915, original = "bollard", transliteration = "[ˈbɒlərd]", translation = "защитный столбик",
            definition = "A short, thick post that stops cars from entering a pedestrian zone.",
            definitionNative = "Низкая толстая тумба на пути машин, охраняющая пешеходную зону.",
            example = "Cars can't cross here — there are bollards on the path.",
            exampleNative = "Машины не проедут — тут bollard прямо на пути.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "street_fixture", isFillInBlankSafe = false),

        WordEntity(id = 29916, original = "curb", transliteration = "[kɜːrb]", translation = "бордюр (амер.)",
            definition = "The raised edge between the road and where people walk.",
            definitionNative = "Приподнятый край между проезжей частью и тротуаром.",
            example = "She tripped over the curb and scraped her knee badly.",
            exampleNative = "Она споткнулась о curb и сильно ободрала колено.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "street_fixture", isFillInBlankSafe = false),

        WordEntity(id = 29917, original = "manhole", transliteration = "[ˈmænhoʊl]", translation = "канализационный люк",
            definition = "A round covered opening in the street leading down to pipes below.",
            definitionNative = "Круглое закрытое отверстие в асфальте, ведущее к подземным трубам.",
            example = "Steam rose from the open manhole in the middle of the street.",
            exampleNative = "Пар поднимался из открытого manhole посреди улицы.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "street_fixture", isFillInBlankSafe = false),

        WordEntity(id = 29918, original = "stoop", transliteration = "[stuːp]", translation = "крыльцо (NYC-стиля)",
            definition = "A short flight of steps leading up to a city home's front door.",
            definitionNative = "Несколько ступенек у входа в городской дом — характерно для Нью-Йорка.",
            example = "Brooklyn neighbours gather on the stoop with cold drinks.",
            exampleNative = "Соседи в Бруклине собираются на stoop с прохладительными напитками.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "building_exterior", isFillInBlankSafe = false),

        WordEntity(id = 29919, original = "quay", transliteration = "[kiː]", translation = "набережная, причал",
            definition = "A solid wall along water where boats stop to load and unload.",
            definitionNative = "Прочная стена вдоль воды, к которой швартуются суда.",
            example = "Seagulls screamed over the quay as the ferry docked.",
            exampleNative = "Чайки кричали над quay, пока паром швартовался.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "public_space", isFillInBlankSafe = false),

        WordEntity(id = 29920, original = "lamppost", transliteration = "[ˈlæmppoʊst]", translation = "фонарный столб",
            definition = "A tall metal pole holding a street light above the pavement.",
            definitionNative = "Высокая металлическая опора с уличным светильником сверху.",
            example = "The drunk man leaned against the lamppost and sang softly.",
            exampleNative = "Пьяный мужчина прислонился к lamppost и тихо пел.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "street_fixture", isFillInBlankSafe = false),

        WordEntity(id = 29921, original = "mews", transliteration = "[mjuːz]", translation = "мьюс (быв. конюшенный ряд)",
            definition = "A quiet row of small homes built where old London stables once stood.",
            definitionNative = "Тихая улочка с маленькими жилищами в Лондоне на месте старых стойл.",
            example = "They bought a cosy flat in a Chelsea mews last year.",
            exampleNative = "Они купили уютную квартиру в челсийском mews в прошлом году.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "urban_area", isFillInBlankSafe = false),

        WordEntity(id = 29922, original = "pergola", transliteration = "[ˈpɜːrɡələ]", translation = "пергола",
            definition = "A wooden frame over a garden path, often covered by climbing plants.",
            definitionNative = "Деревянный каркас над садовой дорожкой, обвитый вьющимися растениями.",
            example = "We ate dinner under the wooden pergola every summer night.",
            exampleNative = "Мы ужинали под деревянной pergola каждый летний вечер.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "urban_greenery", isFillInBlankSafe = false),

        WordEntity(id = 29923, original = "eaves", transliteration = "[iːvz]", translation = "свесы крыши",
            definition = "The lower edge of a roof that sticks out beyond the wall.",
            definitionNative = "Нижний край кровли, выступающий за внешнюю стену дома.",
            example = "Birds often build nests under the eaves in spring.",
            exampleNative = "Весной птицы часто вьют гнёзда под eaves.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "building_exterior", isFillInBlankSafe = false),

        WordEntity(id = 29924, original = "cul-de-sac", transliteration = "[ˈkʌl də sæk]", translation = "тупик (улица)",
            definition = "A dead-end street where cars must turn around to leave.",
            definitionNative = "Проезд с глухим концом — машины разворачиваются и едут обратно.",
            example = "Our cul-de-sac has only five houses and no through traffic.",
            exampleNative = "В нашем cul-de-sac всего пять домов и никакого сквозного движения.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "street_type", isFillInBlankSafe = false),

        WordEntity(id = 29925, original = "alleyway", transliteration = "[ˈæliweɪ]", translation = "узкий переулок",
            definition = "A narrow passage between two rows of buildings, often damp and dim.",
            definitionNative = "Тесный проход между двумя рядами зданий — часто сырой и тёмный.",
            example = "Delivery trucks use the narrow alleyway behind the shops.",
            exampleNative = "Курьеры пользуются узким alleyway за магазинами.",
            rarity = "RARE", setId = 299, languagePair = "en-ru", pos = "noun", semanticGroup = "street_type", isFillInBlankSafe = false),
    )
}
