package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Погода и климат (L4, RARE+EPIC).
 *
 * Set 378: «Погода и климат» — профессиональный.
 *          Атмосферная физика, слои атмосферы, мезомасштабные системы,
 *          научные параметры (vorticity, albedo, dewpoint), оптические
 *          явления (parhelion) — лексика уровня B2-C1, какой пользуются
 *          синоптики, физики атмосферы и продвинутые любители погоды.
 *
 * Тема «Погода и климат» — продолжение L1 (set 375), L2 (set 376), L3 (set 377).
 * Все 25 слов проверены на отсутствие в наборах 21, 226, 227, 248, 375, 376, 377
 * и других файлах WordData*.kt (grep по `original = "..."`). В частности обойдены
 * troposphere, isobar, isotherm, anemometer, hygrometer, derecho, virga, sublimation,
 * meteorology, anticyclone, microburst, vortex, thermocline, cyclogenesis — все они
 * уже есть в существующих наборах.
 *
 * Распределение редкости: 17 EPIC + 8 RARE — два смежных уровня (B2 + C1).
 *
 * SemanticGroups (5 × 5):
 *   weather_l4_atmosphere_layers — stratosphere, mesosphere, thermosphere, ionosphere, tropopause
 *   weather_l4_cloud_types       — cumulonimbus, mammatus, lenticular, stratus, cirrus
 *   weather_l4_severe_systems    — supercell, mesocyclone, occlusion, microclimate, downdraft
 *   weather_l4_meteo_metrics     — vorticity, isohyet, insolation, dewpoint, albedo
 *   weather_l4_processes_optics  — ablation, parhelion, advection, graupel, convection
 *
 * Word IDs: setId × 100 + position (37801..37825).
 *
 * fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь (defaults в
 * WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно после wave;
 * если поставить их заранее, pipeline пропустит запись (известный баг).
 */
object WordDataEnglishWeatherL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 378,
            languagePair = "en-ru",
            orderIndex = 378,
            name = "Погода и климат",
            description = "Атмосферная физика и научная метеорология",
            topic = "Погода и климат",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 378 — Погода и климат: профессиональный (L4, RARE+EPIC)      ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── weather_l4_atmosphere_layers (5) ──────────────────────────────

        WordEntity(id = 37801, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "stratosphere", transliteration = "[ˈstrætəˌsfɪr]", translation = "стратосфера",
            definition = "The calm dry layer of air above weather, where airliners cruise.",
            definitionNative = "Спокойный сухой слой воздуха над погодой — там идут на крейсере лайнеры.",
            example = "The plane climbed into the stratosphere to avoid turbulence.",
            exampleNative = "Самолёт поднялся в stratosphere, чтобы обойти болтанку.",
            pos = "noun", semanticGroup = "weather_l4_atmosphere_layers", fillInBlankExclusions = listOf(37802L, 37803L, 37804L, 37805L)),

        WordEntity(id = 37802, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "mesosphere", transliteration = "[ˈmɛzəˌsfɪr]", translation = "мезосфера",
            definition = "A cold middle layer of air where most meteors burn out as bright streaks.",
            definitionNative = "Холодный средний слой воздуха, где сгорают метеоры, оставляя яркие следы.",
            example = "Most shooting stars vanish inside the mesosphere.",
            exampleNative = "Большинство падающих звёзд гаснут внутри mesosphere.",
            pos = "noun", semanticGroup = "weather_l4_atmosphere_layers", fillInBlankExclusions = listOf(37801L, 37803L, 37804L, 37805L)),

        WordEntity(id = 37803, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "thermosphere", transliteration = "[ˈθɜːrməˌsfɪr]", translation = "термосфера",
            definition = "A hot upper layer where the sun heats thin gas to thousands of degrees.",
            definitionNative = "Горячий верхний слой, где солнце разогревает редкий газ до тысяч градусов.",
            example = "The space station orbits inside the thermosphere.",
            exampleNative = "Космическая станция летает по орбите внутри thermosphere.",
            pos = "noun", semanticGroup = "weather_l4_atmosphere_layers", fillInBlankExclusions = listOf(37801L, 37802L, 37804L, 37805L)),

        WordEntity(id = 37804, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "ionosphere", transliteration = "[aɪˈɑnəˌsfɪr]", translation = "ионосфера",
            definition = "An electrified high zone of air that reflects radio signals back to Earth.",
            definitionNative = "Наэлектризованная высокая область воздуха, что отражает радиосигналы обратно к Земле.",
            example = "Short-wave radio bounces off the ionosphere at night.",
            exampleNative = "Коротковолновое радио отражается от ionosphere по ночам.",
            pos = "noun", semanticGroup = "weather_l4_atmosphere_layers", fillInBlankExclusions = listOf(37801L, 37802L, 37803L, 37805L)),

        WordEntity(id = 37805, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "tropopause", transliteration = "[ˈtroʊpəˌpɔːz]", translation = "тропопауза",
            definition = "The thin border that separates the weather layer from the calm one above.",
            definitionNative = "Тонкая граница, что отделяет слой погоды от спокойного слоя над ним.",
            example = "Storm tops often flatten out right at the tropopause.",
            exampleNative = "Вершины гроз часто сплющиваются прямо у tropopause.",
            pos = "noun", semanticGroup = "weather_l4_atmosphere_layers", fillInBlankExclusions = listOf(37801L, 37802L, 37803L, 37804L)),

        // ── weather_l4_cloud_types (5) ────────────────────────────────────

        WordEntity(id = 37806, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "cumulonimbus", transliteration = "[ˌkjuːmjələˈnɪmbəs]", translation = "кучево-дождевое облако",
            definition = "A towering thunder cloud shaped like an anvil that brings hail and lightning.",
            definitionNative = "Башенная грозовая туча в форме наковальни — приносит град и молнии.",
            example = "A huge cumulonimbus loomed over the prairie at dusk.",
            exampleNative = "Огромный cumulonimbus навис над прерией в сумерках.",
            pos = "noun", semanticGroup = "weather_l4_cloud_types", fillInBlankExclusions = listOf(37807L, 37809L, 37810L, 37811L, 37812L)),

        WordEntity(id = 37807, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "mammatus", transliteration = "[məˈmeɪtəs]", translation = "вымеобразные облака",
            definition = "Strange round pouches that hang under the bottom of a thunder cloud.",
            definitionNative = "Странные круглые мешочки, что свисают из-под брюха грозовой тучи.",
            example = "Photographers love to shoot mammatus after a thunderstorm.",
            exampleNative = "Фотографы обожают снимать mammatus после грозы.",
            pos = "noun", semanticGroup = "weather_l4_cloud_types", fillInBlankExclusions = listOf(37806L, 37808L, 37809L, 37810L)),

        WordEntity(id = 37808, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "lenticular", transliteration = "[lɛnˈtɪkjələr]", translation = "линзовидный (об облаке)",
            definition = "Shaped like a smooth flying saucer — said of strange clouds over mountains.",
            definitionNative = "В форме гладкой летающей тарелки — о странных облаках над горами.",
            example = "A lenticular cloud sat above the peak for hours.",
            exampleNative = "Lenticular облако часами висело над вершиной.",
            pos = "adjective", semanticGroup = "weather_l4_cloud_types", fillInBlankExclusions = listOf(37806L, 37807L, 37809L, 37810L)),

        WordEntity(id = 37809, setId = 378, languagePair = "en-ru", rarity = "RARE",
            original = "stratus", transliteration = "[ˈstreɪtəs]", translation = "слоистые облака",
            definition = "A flat grey blanket of cloud that hangs low and brings drizzle.",
            definitionNative = "Плоское серое одеяло из облаков — висит низко и сеет морось.",
            example = "A heavy stratus covered the city all morning.",
            exampleNative = "Густой stratus накрыл город всё утро.",
            pos = "noun", semanticGroup = "weather_l4_cloud_types", fillInBlankExclusions = listOf(37806L, 37807L, 37810L)),

        WordEntity(id = 37810, setId = 378, languagePair = "en-ru", rarity = "RARE",
            original = "cirrus", transliteration = "[ˈsɪrəs]", translation = "перистые облака",
            definition = "Thin wispy strands of ice crystals very high in a clear blue sky.",
            definitionNative = "Тонкие пряди из ледяных кристаллов очень высоко в ясном голубом небе.",
            example = "Delicate cirrus streaked the sky before the front arrived.",
            exampleNative = "Тонкий cirrus расчертил небо перед приходом фронта.",
            pos = "noun", semanticGroup = "weather_l4_cloud_types", fillInBlankExclusions = listOf(37806L, 37807L, 37808L, 37809L)),

        // ── weather_l4_severe_systems (5) ─────────────────────────────────

        WordEntity(id = 37811, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "supercell", transliteration = "[ˈsuːpərˌsɛl]", translation = "суперъячейка",
            definition = "A long-lived rotating thunderstorm that can spin off the worst tornadoes.",
            definitionNative = "Долгоживущая вращающаяся гроза — порождает самые страшные торнадо.",
            example = "Chasers tracked a violent supercell across western Kansas.",
            exampleNative = "Охотники за бурями преследовали жестокий supercell по западному Канзасу.",
            pos = "noun", semanticGroup = "weather_l4_severe_systems", fillInBlankExclusions = listOf(37806L, 37812L, 37813L, 37814L, 37815L)),

        WordEntity(id = 37812, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "mesocyclone", transliteration = "[ˌmɛzoʊˈsaɪˌkloʊn]", translation = "мезоциклон",
            definition = "A rotating column of rising air inside a severe storm — the heart of a tornado.",
            definitionNative = "Вращающийся столб поднимающегося воздуха внутри сильной грозы — сердце торнадо.",
            example = "Radar detected a mesocyclone embedded in the storm.",
            exampleNative = "Радар обнаружил mesocyclone внутри грозы.",
            pos = "noun", semanticGroup = "weather_l4_severe_systems", fillInBlankExclusions = listOf(37806L, 37811L, 37814L, 37815L)),

        WordEntity(id = 37813, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "occlusion", transliteration = "[əˈkluːʒən]", translation = "окклюзия (фронта)",
            definition = "What happens when a fast cold front catches up and lifts a slower warm one.",
            definitionNative = "То, что происходит, когда быстрый холодный фронт догоняет тёплый и поднимает его.",
            example = "The storm weakened as occlusion cut off its warm air supply.",
            exampleNative = "Гроза ослабла, когда occlusion отрезала ей подток тёплого воздуха.",
            pos = "noun", semanticGroup = "weather_l4_severe_systems", fillInBlankExclusions = listOf(37811L, 37812L, 37814L, 37815L)),

        WordEntity(id = 37814, setId = 378, languagePair = "en-ru", rarity = "RARE",
            original = "microclimate", transliteration = "[ˈmaɪkroʊˌklaɪmət]", translation = "микроклимат",
            definition = "The unique weather of a small spot — like a sheltered courtyard or hillside.",
            definitionNative = "Своя неповторимая погода в маленьком пятачке — внутренний дворик или склон холма.",
            example = "The vineyard has its own warm microclimate near the river.",
            exampleNative = "У виноградника свой тёплый microclimate у реки.",
            pos = "noun", semanticGroup = "weather_l4_severe_systems", fillInBlankExclusions = listOf(37811L, 37812L, 37813L, 37815L)),

        WordEntity(id = 37815, setId = 378, languagePair = "en-ru", rarity = "RARE",
            original = "downdraft", transliteration = "[ˈdaʊnˌdræft]", translation = "нисходящий поток",
            definition = "A column of cool air sinking fast out of a cloud during a storm.",
            definitionNative = "Столб прохладного воздуха, что быстро падает вниз из облака во время грозы.",
            example = "A sharp downdraft slammed dust against the windows.",
            exampleNative = "Резкий downdraft швырнул пыль в окна.",
            pos = "noun", semanticGroup = "weather_l4_severe_systems", fillInBlankExclusions = listOf(37811L, 37812L, 37813L, 37814L)),

        // ── weather_l4_meteo_metrics (5) ──────────────────────────────────

        WordEntity(id = 37816, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "vorticity", transliteration = "[vɔrˈtɪsəti]", translation = "завихрённость",
            definition = "A measure of how strongly air spins around a vertical axis at one spot.",
            definitionNative = "Мера того, как сильно воздух крутится вокруг вертикальной оси в одной точке.",
            example = "Forecasters watched a sharp spike in vorticity over the plains.",
            exampleNative = "Синоптики следили за резким скачком vorticity над равнинами.",
            pos = "noun", semanticGroup = "weather_l4_meteo_metrics", fillInBlankExclusions = listOf(37817L, 37818L, 37819L, 37820L, 37823L, 37825L)),

        WordEntity(id = 37817, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "isohyet", transliteration = "[ˌaɪsoʊˈhaɪət]", translation = "изогиета",
            definition = "A line on a map joining places that get the same amount of yearly rain.",
            definitionNative = "Линия на карте, что соединяет места с одинаковой суммой дождя за год.",
            example = "The map showed a clear isohyet around the wet coastal hills.",
            exampleNative = "Карта показывала чёткую isohyet вокруг влажных прибрежных холмов.",
            pos = "noun", semanticGroup = "weather_l4_meteo_metrics", fillInBlankExclusions = listOf(37816L, 37818L, 37819L, 37820L)),

        WordEntity(id = 37818, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "insolation", transliteration = "[ˌɪnsəˈleɪʃən]", translation = "инсоляция",
            definition = "How much energy from the sun reaches a piece of ground in a given time.",
            definitionNative = "Сколько энергии от солнца попадает на участок земли за отрезок времени.",
            example = "Engineers measured insolation before placing the solar panels.",
            exampleNative = "Инженеры замерили insolation, прежде чем ставить солнечные панели.",
            pos = "noun", semanticGroup = "weather_l4_meteo_metrics", fillInBlankExclusions = listOf(37816L, 37817L, 37819L, 37820L)),

        WordEntity(id = 37819, setId = 378, languagePair = "en-ru", rarity = "RARE",
            original = "dewpoint", transliteration = "[ˈduːˌpɔɪnt]", translation = "точка росы",
            definition = "The temperature at which damp air must cool for water drops to form.",
            definitionNative = "Температура, до которой нужно остудить влажный воздух, чтобы выпали капли воды.",
            example = "A high dewpoint made the August night feel sticky.",
            exampleNative = "Высокая dewpoint делала августовскую ночь липкой.",
            pos = "noun", semanticGroup = "weather_l4_meteo_metrics", fillInBlankExclusions = listOf(37816L, 37817L, 37818L, 37820L)),

        WordEntity(id = 37820, setId = 378, languagePair = "en-ru", rarity = "RARE",
            original = "albedo", transliteration = "[ælˈbiːdoʊ]", translation = "альбедо",
            definition = "How much of the sun's light a surface bounces back instead of soaking up.",
            definitionNative = "Сколько солнечного света поверхность отбрасывает обратно, а не впитывает.",
            example = "Fresh snow has a very high albedo and reflects most light.",
            exampleNative = "У свежего снега очень высокая albedo, он отражает почти весь свет.",
            pos = "noun", semanticGroup = "weather_l4_meteo_metrics", fillInBlankExclusions = listOf(37816L, 37817L, 37818L, 37819L)),

        // ── weather_l4_processes_optics (5) ───────────────────────────────

        WordEntity(id = 37821, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "ablation", transliteration = "[əˈbleɪʃən]", translation = "абляция",
            definition = "The slow loss of a glacier's mass through melting and breaking off into the sea.",
            definitionNative = "Медленная потеря массы ледника — через таяние и откалывание кусков в море.",
            example = "Warm summers speed up ablation on the alpine glacier.",
            exampleNative = "Тёплое лето ускоряет ablation альпийского ледника.",
            pos = "noun", semanticGroup = "weather_l4_processes_optics", fillInBlankExclusions = listOf(37822L, 37823L, 37824L, 37825L)),

        WordEntity(id = 37822, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "parhelion", transliteration = "[pɑrˈhiːliən]", translation = "ложное солнце",
            definition = "A bright spot of light next to the sun, made by ice crystals high in the sky.",
            definitionNative = "Яркое световое пятно рядом с солнцем — его рисуют ледяные кристаллы высоко в небе.",
            example = "A brilliant parhelion glowed beside the winter sun.",
            exampleNative = "Яркий parhelion сиял рядом с зимним солнцем.",
            pos = "noun", semanticGroup = "weather_l4_processes_optics", fillInBlankExclusions = listOf(37821L, 37823L, 37824L, 37825L)),

        WordEntity(id = 37823, setId = 378, languagePair = "en-ru", rarity = "EPIC",
            original = "advection", transliteration = "[ædˈvɛkʃən]", translation = "адвекция",
            definition = "The sideways movement of warmth or moisture by a steady horizontal flow of air.",
            definitionNative = "Боковой перенос тепла или влаги ровным горизонтальным потоком воздуха.",
            example = "Warm advection from the south thawed the snow overnight.",
            exampleNative = "Тёплая advection с юга растопила снег за ночь.",
            pos = "noun", semanticGroup = "weather_l4_processes_optics", fillInBlankExclusions = listOf(37821L, 37822L, 37824L, 37825L)),

        WordEntity(id = 37824, setId = 378, languagePair = "en-ru", rarity = "RARE",
            original = "graupel", transliteration = "[ˈɡraʊpəl]", translation = "снежная крупа",
            definition = "Soft white pellets of frozen water that fall like tiny styrofoam beads.",
            definitionNative = "Мягкие белые шарики замёрзшей воды — падают как крошечные пенопластовые бусины.",
            example = "Light graupel bounced off the windshield on the mountain pass.",
            exampleNative = "Лёгкая graupel отскакивала от лобового стекла на горном перевале.",
            pos = "noun", semanticGroup = "weather_l4_processes_optics", fillInBlankExclusions = listOf(37821L, 37822L, 37823L, 37825L)),

        WordEntity(id = 37825, setId = 378, languagePair = "en-ru", rarity = "RARE",
            original = "convection", transliteration = "[kənˈvɛkʃən]", translation = "конвекция",
            definition = "The lifting of warm air upward — the engine behind summer thunderstorms.",
            definitionNative = "Подъём тёплого воздуха вверх — двигатель летних гроз.",
            example = "Strong afternoon convection built tall storm clouds quickly.",
            exampleNative = "Сильная дневная convection быстро строила высокие грозовые тучи.",
            pos = "noun", semanticGroup = "weather_l4_processes_optics", fillInBlankExclusions = listOf(37821L, 37822L, 37823L, 37824L)),
    )
}
