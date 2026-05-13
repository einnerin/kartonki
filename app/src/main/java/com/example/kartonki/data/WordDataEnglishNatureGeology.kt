package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 463.
 * Природа и экология: геология — горные породы, минералы и процессы Земли
 * (L3 / RARE + EPIC).
 *
 * Расширение темы «Природа и экология». Дополняет:
 *   - 1, 11, 21        (L1) — животные, страны, погода.
 *   - 29, 34, 226, 232 (L2) — экология, окружающий мир, погода, ландшафты.
 *   - 49, 213, 227, 233 (L3) — климат, природная среда, метеорология, экопроцессы.
 *   - 234              (L4) — биомы, охрана, инвазивные виды.
 *   - 235              (L5) — поэтическая и редкая природная лексика.
 *
 * Подтема — геология Земли: какие бывают горные породы, что такое минералы,
 * как двигается кора и какие процессы её формируют. Пять семантических групп:
 *   nature_geology_rocks      — granite, basalt, limestone, sandstone, slate, pumice, shale, schist
 *   nature_geology_minerals   — quartz, mica, amethyst, jade, pyrite, sulfur
 *   nature_geology_processes  — lava, weathering, stratum, mantle, crust
 *   nature_geology_landforms  — outcrop, bedrock, fissure
 *   nature_geology_mining     — fossil, ore, tremor
 *
 * Дубли magma/fault/geyser/tectonic заняты setId=234 (geography);
 * marble — setId 154, obsidian — setId 220 (history ancient),
 * conglomerate — setId 213+, sediment — setId 213, vein — setId 462 (анатомия),
 * volcano/crater — setId 121, erosion — setId 49, earthquake — setId 29,
 * mineral — setId 37. Всё это исключено.
 *
 * Word IDs: 46301..46325 (setId × 100 + position).
 */
object WordDataEnglishNatureGeology {

    val sets = listOf(
        WordSetEntity(
            id = 463,
            name = "Природа и экология",
            description = "Геология, горные породы и минералы: granite, quartz, lava, fossil",
            languagePair = "en-ru",
            orderIndex = 463,
            topic = "Природа и экология",
            level = 3,
        ),
    )

    val words = listOf(

        // ── nature_geology_rocks (горные породы) ──────────────────────────────
        WordEntity(
            id = 46301, original = "granite", transliteration = "[ˈɡrænɪt]", translation = "гранит",
            definition = "A hard, coarse-grained rock formed from cooled magma, often used for kitchen counters and monuments.",
            definitionNative = "Твёрдая крупнозернистая порода из остывшей магмы: часто идёт на кухонные столешницы и памятники.",
            example = "The kitchen counter is made of polished granite, which is why it feels so cool to the touch.",
            exampleNative = "Кухонная столешница сделана из полированного granite — потому и кажется такой холодной на ощупь.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(46302L, 46303L, 46304L, 46305L, 46306L, 46307L, 46308L)),
        WordEntity(
            id = 46302, original = "basalt", transliteration = "[bəˈsɔːlt]", translation = "базальт",
            definition = "A dark, dense volcanic rock that forms when lava cools quickly on the surface.",
            definitionNative = "Тёмная плотная вулканическая порода: образуется, когда лава быстро застывает на поверхности.",
            example = "Most of the ocean floor is paved with thick layers of basalt.",
            exampleNative = "Большая часть океанского дна покрыта толстыми слоями basalt.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(46301L, 46303L, 46304L, 46305L, 46306L, 46307L, 46308L)),
        WordEntity(
            id = 46303, original = "limestone", transliteration = "[ˈlaɪmstoʊn]", translation = "известняк",
            definition = "A pale rock made mostly of compressed shells and skeletons, easily carved and used for buildings.",
            definitionNative = "Светлая порода из спрессованных ракушек и скелетов: легко режется и идёт на строительство.",
            example = "The cathedral walls are built from blocks of soft yellow limestone.",
            exampleNative = "Стены собора сложены из блоков мягкого жёлтого limestone.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(46301L, 46302L, 46304L, 46305L, 46306L, 46307L, 46308L)),
        WordEntity(
            id = 46304, original = "sandstone", transliteration = "[ˈsændstoʊn]", translation = "песчаник",
            definition = "A rock made of sand grains cemented together, usually red, yellow or brown in colour.",
            definitionNative = "Порода из песчинок, склеенных между собой: обычно красного, жёлтого или бурого цвета.",
            example = "The red sandstone cliffs of Utah glow orange in the evening light.",
            exampleNative = "Красные обрывы sandstone в Юте светятся оранжевым в вечернем свете.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(46301L, 46302L, 46303L, 46305L, 46306L, 46307L, 46308L)),
        WordEntity(
            id = 46305, original = "slate", transliteration = "[sleɪt]", translation = "сланец (кровельный)",
            definition = "A dark grey rock that splits into flat thin sheets, traditionally used for roof tiles and chalkboards.",
            definitionNative = "Тёмно-серая порода, легко колющаяся на тонкие плоские пластины: шла на кровлю и школьные доски.",
            example = "The old farmhouse still has its original slate roof from the 1800s.",
            exampleNative = "У старого фермерского дома до сих пор крыша из исходного slate XIX века.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(46301L, 46302L, 46303L, 46304L, 46306L, 46307L, 46308L)),
        WordEntity(
            id = 46306, original = "pumice", transliteration = "[ˈpʌmɪs]", translation = "пемза",
            definition = "A very light, frothy volcanic rock full of tiny holes, light enough to float on water.",
            definitionNative = "Очень лёгкая пористая вулканическая порода с массой мелких пузырьков: даже плавает в воде.",
            example = "She rubbed the rough skin on her heels with a pumice stone after the bath.",
            exampleNative = "После ванны она потёрла грубую кожу на пятках камнем pumice.",
            rarity = "EPIC", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(46301L, 46302L, 46303L, 46304L, 46305L, 46307L, 46308L)),
        WordEntity(
            id = 46307, original = "shale", transliteration = "[ʃeɪl]", translation = "сланец (глинистый)",
            definition = "A soft layered rock formed from packed mud, which often holds oil and gas in tiny pores.",
            definitionNative = "Мягкая слоистая порода из спрессованной глины: в её мелких порах часто находятся нефть и газ.",
            example = "Drilling deep into the shale finally let the United States produce its own oil and gas.",
            exampleNative = "Глубокое бурение в shale наконец позволило США добывать собственные нефть и газ.",
            rarity = "EPIC", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(46301L, 46302L, 46303L, 46304L, 46305L, 46306L, 46308L)),
        WordEntity(
            id = 46308, original = "schist", transliteration = "[ʃɪst]", translation = "сланец (кристаллический)",
            definition = "A shiny rock with wavy bands of crystals, formed when other rocks are squeezed and heated deep underground.",
            definitionNative = "Блестящая порода с волнистыми полосами кристаллов: получается, когда другие породы сдавливают и нагревают глубоко в земле.",
            example = "The hiking trail cuts through old grey schist polished smooth by glaciers.",
            exampleNative = "Тропа прорезает древний серый schist, отполированный ледниками до блеска.",
            rarity = "EPIC", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(46301L, 46302L, 46303L, 46304L, 46305L, 46306L, 46307L)),

        // ── nature_geology_minerals (минералы и кристаллы) ────────────────────
        WordEntity(
            id = 46309, original = "quartz", transliteration = "[kwɔːrts]", translation = "кварц",
            definition = "A hard, glassy mineral made of silicon and oxygen — the main ingredient of sand and many watch crystals.",
            definitionNative = "Твёрдый стекловидный минерал из кремния и кислорода: основа песка и кристаллов в наручных часах.",
            example = "A tiny quartz crystal inside the watch keeps it accurate to the second.",
            exampleNative = "Крошечный кристалл quartz внутри часов держит точность до секунды.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(46310L, 46311L, 46312L, 46313L, 46314L)),
        WordEntity(
            id = 46310, original = "mica", transliteration = "[ˈmaɪkə]", translation = "слюда",
            definition = "A shiny mineral that splits into very thin transparent sheets and used to be set in stove doors.",
            definitionNative = "Блестящий минерал, расслаивающийся на очень тонкие прозрачные листочки: раньше им закрывали окошки печей.",
            example = "Tiny flakes of mica in the granite catch the sunlight and sparkle.",
            exampleNative = "Крошечные чешуйки mica в граните ловят солнце и поблёскивают.",
            rarity = "EPIC", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(46309L, 46311L, 46312L, 46313L, 46314L)),
        WordEntity(
            id = 46311, original = "amethyst", transliteration = "[ˈæməθɪst]", translation = "аметист",
            definition = "A purple gemstone variety of quartz, often used in rings and jewellery.",
            definitionNative = "Фиолетовая разновидность кварца — драгоценный камень, часто идёт в кольца и украшения.",
            example = "Her grandmother left her a silver ring with a large purple amethyst.",
            exampleNative = "Бабушка оставила ей серебряное кольцо с крупным фиолетовым amethyst.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(46309L, 46310L, 46312L, 46313L, 46314L)),
        WordEntity(
            id = 46312, original = "jade", transliteration = "[dʒeɪd]", translation = "нефрит / жадеит",
            definition = "A tough green stone that has been carved into pendants, figurines and tools for thousands of years in China.",
            definitionNative = "Прочный зелёный камень: в Китае тысячи лет режут из него подвески, фигурки и инструменты.",
            example = "She wore a small jade pendant her father had brought back from Shanghai.",
            exampleNative = "Она носила маленькую подвеску из jade, которую отец привёз из Шанхая.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(46309L, 46310L, 46311L, 46313L, 46314L)),
        WordEntity(
            id = 46313, original = "pyrite", transliteration = "[ˈpaɪraɪt]", translation = "пирит",
            definition = "A shiny brass-yellow mineral made of iron and sulfur, often mistaken for gold by beginners.",
            definitionNative = "Блестящий латунно-жёлтый минерал из железа и серы: новички часто принимают его за золото.",
            example = "The miners laughed when the rookie thought he had struck gold — it was just pyrite.",
            exampleNative = "Шахтёры смеялись, когда новичок решил, что нашёл золото — это был всего лишь pyrite.",
            rarity = "EPIC", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(46309L, 46310L, 46311L, 46312L, 46314L)),
        WordEntity(
            id = 46314, original = "sulfur", transliteration = "[ˈsʌlfər]", translation = "сера",
            definition = "A bright yellow element that smells like rotten eggs when burned and gathers around volcanoes.",
            definitionNative = "Ярко-жёлтый элемент, который пахнет тухлыми яйцами при горении и скапливается у вулканов.",
            example = "The hot spring smelled strongly of sulfur and made our eyes water.",
            exampleNative = "От горячего источника сильно пахло sulfur, и от запаха слезились глаза.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(46309L, 46310L, 46311L, 46312L, 46313L)),

        // ── nature_geology_processes (процессы и слои Земли) ──────────────────
        WordEntity(
            id = 46315, original = "lava", transliteration = "[ˈlɑːvə]", translation = "лава",
            definition = "The hot melted rock that flows out of a volcano and slowly cools into solid stone.",
            definitionNative = "Раскалённая расплавленная порода: вытекает из вулкана и медленно остывает, превращаясь в твёрдый камень.",
            example = "Bright orange lava poured down the mountainside, swallowing trees on its way.",
            exampleNative = "Ярко-оранжевая lava стекала по склону горы, поглощая деревья на пути.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_processes", fillInBlankExclusions = listOf(46316L, 46317L, 46318L, 46319L)),
        WordEntity(
            id = 46316, original = "weathering", transliteration = "[ˈweðərɪŋ]", translation = "выветривание",
            definition = "The slow breakdown of rocks at the surface caused by rain, frost, wind and temperature changes.",
            definitionNative = "Медленное разрушение пород на поверхности: его вызывают дождь, мороз, ветер и перепады температур.",
            example = "Centuries of weathering have rounded the once-sharp peaks of these old mountains.",
            exampleNative = "Века weathering сгладили когда-то острые вершины этих древних гор.",
            rarity = "EPIC", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_processes", fillInBlankExclusions = listOf(46315L, 46317L, 46318L, 46319L)),
        WordEntity(
            id = 46317, original = "stratum", transliteration = "[ˈstreɪtəm]", translation = "пласт / слой (геол.)",
            definition = "A single horizontal layer of rock or earth, often seen as a coloured band in a cliff face.",
            definitionNative = "Один горизонтальный слой породы или почвы: часто виден цветной полосой на обрыве скалы.",
            example = "A thin black stratum in the cliff marks the layer of ash from an ancient eruption.",
            exampleNative = "Тонкий чёрный stratum в обрыве отмечает слой пепла от древнего извержения.",
            rarity = "EPIC", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_processes", fillInBlankExclusions = listOf(46315L, 46316L, 46318L, 46319L)),
        WordEntity(
            id = 46318, original = "mantle", transliteration = "[ˈmæntəl]", translation = "мантия (Земли)",
            definition = "The thick hot layer inside the Earth between the thin outer shell and the deep iron core.",
            definitionNative = "Толстый горячий слой внутри Земли: между тонкой наружной оболочкой и глубоким железным ядром.",
            example = "Heat rising from the mantle is what slowly drives the continents apart.",
            exampleNative = "Тепло, поднимающееся из mantle, медленно растаскивает континенты в стороны.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_processes", fillInBlankExclusions = listOf(46315L, 46316L, 46317L, 46319L)),
        WordEntity(
            id = 46319, original = "crust", transliteration = "[krʌst]", translation = "земная кора",
            definition = "The thin outer shell of the Earth that we stand on, made of solid rock and broken into huge plates.",
            definitionNative = "Тонкая наружная оболочка Земли, на которой мы стоим: твёрдые породы, разбитые на огромные плиты.",
            example = "The earthquake happened where two plates of the Earth's crust grind against each other.",
            exampleNative = "Землетрясение произошло там, где две плиты земной crust трутся друг о друга.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_processes", fillInBlankExclusions = listOf(46315L, 46316L, 46317L, 46318L)),

        // ── nature_geology_landforms (формы рельефа и трещины) ────────────────
        WordEntity(
            id = 46320, original = "outcrop", transliteration = "[ˈaʊtkrɒp]", translation = "обнажение породы",
            definition = "A patch of bedrock that pokes up through the soil and is visible on the surface.",
            definitionNative = "Кусок коренной породы, торчащий сквозь почву и видный на поверхности.",
            example = "The geology students gathered around a rocky outcrop to study its layers.",
            exampleNative = "Студенты-геологи собрались вокруг скалистого outcrop, чтобы изучить его слои.",
            rarity = "EPIC", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_landforms", fillInBlankExclusions = listOf(46321L, 46322L)),
        WordEntity(
            id = 46321, original = "bedrock", transliteration = "[ˈbedrɒk]", translation = "коренная порода",
            definition = "The solid layer of rock that lies underneath the soil and loose stones.",
            definitionNative = "Твёрдый слой породы, лежащий под почвой и осыпью мелких камней.",
            example = "The builders had to dig three metres down before they hit solid bedrock.",
            exampleNative = "Строителям пришлось копать три метра вниз, пока они не упёрлись в твёрдый bedrock.",
            rarity = "EPIC", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_landforms", fillInBlankExclusions = listOf(46320L, 46322L)),
        WordEntity(
            id = 46322, original = "fissure", transliteration = "[ˈfɪʃər]", translation = "трещина / расщелина",
            definition = "A long narrow crack in rock or in the ground, often from pressure or an earthquake.",
            definitionNative = "Длинная узкая трещина в породе или в земле: часто от давления или землетрясения.",
            example = "Smoke and steam hissed out of a wide fissure near the volcano's base.",
            exampleNative = "Дым и пар с шипением вырывались из широкой fissure у подножия вулкана.",
            rarity = "EPIC", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_landforms", fillInBlankExclusions = listOf(46320L, 46321L)),

        // ── nature_geology_mining (полевая лексика геолога) ───────────────────
        WordEntity(
            id = 46323, original = "fossil", transliteration = "[ˈfɒsəl]", translation = "ископаемое / окаменелость",
            definition = "The preserved shape or remains of a plant or animal that lived millions of years ago, turned to stone.",
            definitionNative = "Сохранившийся отпечаток или останки растения или животного, жившего миллионы лет назад, превратившиеся в камень.",
            example = "On the beach she found a small fossil of a curled ammonite shell.",
            exampleNative = "На пляже она нашла маленький fossil — свёрнутую раковину аммонита.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_mining", fillInBlankExclusions = listOf(46324L, 46325L)),
        WordEntity(
            id = 46324, original = "ore", transliteration = "[ɔːr]", translation = "руда",
            definition = "Rock or earth from which a useful metal like iron, copper or gold can be taken out.",
            definitionNative = "Порода или земля, из которой можно извлечь полезный металл: железо, медь или золото.",
            example = "Trucks haul iron ore out of the open pit twenty-four hours a day.",
            exampleNative = "Грузовики круглые сутки вывозят железную ore из открытого карьера.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_mining", fillInBlankExclusions = listOf(46323L, 46325L)),
        WordEntity(
            id = 46325, original = "tremor", transliteration = "[ˈtremər]", translation = "подземный толчок",
            definition = "A small shaking of the ground, weaker than a full earthquake but enough to feel.",
            definitionNative = "Лёгкое сотрясение земли: слабее полноценного землетрясения, но уже ощутимо.",
            example = "A small tremor rattled the dishes on the shelf for a few seconds.",
            exampleNative = "Небольшой tremor пару секунд тряс посуду на полке.",
            rarity = "RARE", setId = 463, languagePair = "en-ru", pos = "noun",
            semanticGroup = "nature_geology_mining", fillInBlankExclusions = listOf(46323L, 46324L)),
    )
}
