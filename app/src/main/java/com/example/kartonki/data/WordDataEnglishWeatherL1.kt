package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Погода и климат (L1, COMMON+UNCOMMON).
 *
 * Set 375: «Погода и климат» — основы.
 *          Базовая бытовая лексика про погоду: солнце, снег, дождь, мороз,
 *          гроза, прогноз и связанные ощущения.
 *
 * Тема «Погода и климат» — отдельная от старой темы «Природа и экология»
 * (set 21 «Погодные явления», sets 226/227 weather subgroups). Все 25 слов
 * этого сета не пересекаются с уже существующими английскими словами в базе
 * (проверено grep'ом по `original = "..."`). Cross-topic совпадения по смыслу
 * (например, COMMON sunny/cloudy в set 21) допустимы по политике дублей.
 *
 * Распределение редкости: 18 COMMON + 7 UNCOMMON — два смежных уровня (A1 + A2).
 *
 * SemanticGroups (5 × 5):
 *   weather_l1_sun       — sunshine, sunlight, sunrise, sunset, clear
 *   weather_l1_winter    — snowflake, snowfall, snowman, icicle, icy
 *   weather_l1_temp_feel — crisp, muggy, scorching, frosty, chill
 *   weather_l1_actions   — shine, melt, freeze, windy, rainy
 *   weather_l1_storms    — thunderstorm, snowstorm, rainfall, hurricane, raincoat
 *
 * Word IDs: setId × 100 + position (37501..37525).
 *
 * isFillInBlankSafe = false на всех словах. fillInBlankExclusions пустые —
 * заполнятся через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishWeatherL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 375,
            languagePair = "en-ru",
            orderIndex = 375,
            name = "Погода и климат",
            description = "Солнце, дождь, снег и базовая погода",
            topic = "Погода и климат",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 375 — Погода и климат: основы (L1, COMMON+UNCOMMON)          ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── weather_l1_sun (5) ────────────────────────────────────────────

        WordEntity(id = 37501, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "sunshine", transliteration = "[ˈsənˌʃaɪn]", translation = "солнечный свет",
            definition = "Bright warm light coming from the sky on a clear day.",
            definitionNative = "Тёплое яркое сияние с неба в ясный день — без облаков.",
            example = "We had breakfast in the garden full of sunshine.",
            exampleNative = "Мы завтракали в саду, залитом sunshine.",
            pos = "noun", semanticGroup = "weather_l1_sun",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37502L, 37503L, 37504L)),

        WordEntity(id = 37502, setId = 375, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sunlight", transliteration = "[ˈsənˌlaɪt]", translation = "солнечные лучи",
            definition = "The light of our nearest star reaching the ground or a room.",
            definitionNative = "Свет ближайшей звезды, доходящий до земли или попадающий в комнату.",
            example = "A beam of sunlight fell across the kitchen table.",
            exampleNative = "Луч sunlight упал на кухонный стол.",
            pos = "noun", semanticGroup = "weather_l1_sun",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37501L, 37503L, 37504L)),

        WordEntity(id = 37503, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "sunrise", transliteration = "[ˈsənˌraɪz]", translation = "восход",
            definition = "The moment in the morning when the sky first lights up.",
            definitionNative = "Утро, когда небо впервые светлеет и над горизонтом появляется яркий диск.",
            example = "We climbed the hill to watch the sunrise over the sea.",
            exampleNative = "Мы поднялись на холм, чтобы увидеть sunrise над морем.",
            pos = "noun", semanticGroup = "weather_l1_sun",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37501L, 37502L, 37504L, 37521L, 37522L, 37524L)),

        WordEntity(id = 37504, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "sunset", transliteration = "[ˈsənˌsɛt]", translation = "закат",
            definition = "The evening moment when the sky turns orange and the day ends.",
            definitionNative = "Вечер, когда небо становится оранжевым и дневное светило прячется.",
            example = "The whole beach turned pink at sunset yesterday.",
            exampleNative = "Весь пляж стал розовым во время sunset.",
            pos = "noun", semanticGroup = "weather_l1_sun",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37501L, 37502L, 37503L)),

        WordEntity(id = 37505, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "clear", transliteration = "[klɪr]", translation = "ясный",
            definition = "Without clouds and easy to see through — like a calm summer sky.",
            definitionNative = "Без облаков, насквозь прозрачный — как небо в спокойный летний день.",
            example = "The night was clear and full of stars.",
            exampleNative = "Ночь была clear и полная звёзд.",
            pos = "adjective", semanticGroup = "weather_l1_sun",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37510L, 37511L, 37512L, 37514L, 37519L)),

        // ── weather_l1_winter (5) ─────────────────────────────────────────

        WordEntity(id = 37506, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "snowflake", transliteration = "[ˈsnoʊˌfleɪk]", translation = "снежинка",
            definition = "One tiny soft white star of frozen water that floats down.",
            definitionNative = "Маленькая мягкая белая звёздочка из замёрзшей воды, плавно падает с неба.",
            example = "A single snowflake landed on her woollen mitten.",
            exampleNative = "Одна snowflake опустилась ей на варежку.",
            pos = "noun", semanticGroup = "weather_l1_winter",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37507L, 37508L, 37509L)),

        WordEntity(id = 37507, setId = 375, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "snowfall", transliteration = "[ˈsnoʊˌfɔl]", translation = "снегопад",
            definition = "A long quiet time when white flakes keep coming down from the sky.",
            definitionNative = "Долгое тихое время, когда белые хлопья без конца сыпятся с неба.",
            example = "The first heavy snowfall covered the whole village overnight.",
            exampleNative = "Первый сильный snowfall укрыл всю деревню за ночь.",
            pos = "noun", semanticGroup = "weather_l1_winter",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37506L, 37508L, 37509L, 37522L)),

        WordEntity(id = 37508, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "snowman", transliteration = "[ˈsnoʊˌmæn]", translation = "снеговик",
            definition = "A funny figure that kids build out of three big white balls in winter.",
            definitionNative = "Весёлая фигура, которую дети лепят зимой из трёх больших белых шаров.",
            example = "The kids built a tall snowman with a carrot nose.",
            exampleNative = "Дети слепили высокого snowman с морковкой вместо носа.",
            pos = "noun", semanticGroup = "weather_l1_winter",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37506L, 37507L, 37509L)),

        WordEntity(id = 37509, setId = 375, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "icicle", transliteration = "[ˈaɪsɪkəl]", translation = "сосулька",
            definition = "A long pointed piece of frozen water hanging from a roof in winter.",
            definitionNative = "Длинная острая стекляшка из замёрзшей воды, свисает с крыши зимой.",
            example = "A long icicle hung from the edge of our roof.",
            exampleNative = "С края нашей крыши свисала длинная icicle.",
            pos = "noun", semanticGroup = "weather_l1_winter",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37506L, 37507L, 37508L)),

        WordEntity(id = 37510, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "icy", transliteration = "[ˈaɪsi]", translation = "ледяной",
            definition = "Covered with a thin slippery layer of frozen water.",
            definitionNative = "Покрытый тонким скользким слоем замёрзшей воды.",
            example = "Be careful — the steps are very icy this morning.",
            exampleNative = "Осторожно — ступеньки сегодня очень icy.",
            pos = "adjective", semanticGroup = "weather_l1_winter",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37514L)),

        // ── weather_l1_temp_feel (5) ──────────────────────────────────────

        WordEntity(id = 37511, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "crisp", transliteration = "[krɪsp]", translation = "свежий и прохладный",
            definition = "About air: cool, fresh and pleasant — like a bright autumn morning.",
            definitionNative = "О воздухе: прохладный, свежий и бодрящий — как ясное осеннее утро.",
            example = "The air felt crisp on our walk through the forest.",
            exampleNative = "Воздух был crisp, когда мы гуляли по лесу.",
            pos = "adjective", semanticGroup = "weather_l1_temp_feel",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37505L, 37510L, 37512L, 37513L, 37514L)),

        WordEntity(id = 37512, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "muggy", transliteration = "[ˈməɡi]", translation = "душный",
            definition = "Warm and damp in a way that makes it hard to breathe.",
            definitionNative = "Тёплый и сыроватый — так что трудно дышать и хочется открыть окно.",
            example = "It was so muggy that nobody could sleep that night.",
            exampleNative = "Было так muggy, что никто не мог заснуть в ту ночь.",
            pos = "adjective", semanticGroup = "weather_l1_temp_feel",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37510L, 37511L, 37513L, 37514L, 37519L, 37520L)),

        WordEntity(id = 37513, setId = 375, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "scorching", transliteration = "[ˈskɔrʧɪŋ]", translation = "обжигающе жаркий",
            definition = "Burning hot — so warm that the road feels like an oven.",
            definitionNative = "Раскалённый до боли — настолько, что асфальт кажется горящей плитой.",
            example = "The sand was scorching at noon — we ran back to the water.",
            exampleNative = "В полдень песок был scorching — мы побежали к воде.",
            pos = "adjective", semanticGroup = "weather_l1_temp_feel",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37511L, 37512L, 37514L)),

        WordEntity(id = 37514, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "frosty", transliteration = "[ˈfrɔsti]", translation = "морозный",
            definition = "Very cold — when grass and roofs turn white before sunrise.",
            definitionNative = "Очень холодный — когда трава и крыши до рассвета покрываются белым налётом.",
            example = "We breathed out steam on that frosty winter morning.",
            exampleNative = "Изо рта шёл пар тем frosty зимним утром.",
            pos = "adjective", semanticGroup = "weather_l1_temp_feel",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37505L, 37510L, 37511L, 37512L, 37513L, 37519L, 37520L)),

        WordEntity(id = 37515, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "chill", transliteration = "[ʧɪl]", translation = "прохлада",
            definition = "A light unpleasant cold in the air — enough for a jacket.",
            definitionNative = "Лёгкий неприятный холод в воздухе — достаточный, чтобы накинуть куртку.",
            example = "There was a sharp chill in the early morning air.",
            exampleNative = "Ранним утром в воздухе чувствовался резкий chill.",
            pos = "noun", semanticGroup = "weather_l1_temp_feel",
            isFillInBlankSafe = true),

        // ── weather_l1_actions (5) ────────────────────────────────────────

        WordEntity(id = 37516, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "shine", transliteration = "[ʃaɪn]", translation = "светить",
            definition = "Give off bright light — like the sun, a star or a lamp.",
            definitionNative = "Испускать яркие лучи — как делает наше дневное небесное тело или лампа.",
            example = "The sun will shine all afternoon, the forecast says.",
            exampleNative = "Солнце будет shine весь день, обещает прогноз.",
            pos = "verb", semanticGroup = "weather_l1_actions",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37517L, 37518L)),

        WordEntity(id = 37517, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "melt", transliteration = "[mɛlt]", translation = "таять",
            definition = "Turn from solid to liquid because of warmth — like ice or butter.",
            definitionNative = "Превращаться из твёрдого в жидкое от тепла — как лёд или масло на сковородке.",
            example = "The snow began to melt as the afternoon got warmer.",
            exampleNative = "Снег начал melt, когда после полудня потеплело.",
            pos = "verb", semanticGroup = "weather_l1_actions",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37516L, 37518L)),

        WordEntity(id = 37518, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "freeze", transliteration = "[friz]", translation = "замерзать",
            definition = "Turn into ice when the temperature drops below zero degrees.",
            definitionNative = "Превращаться в лёд, когда температура опускается ниже нуля градусов.",
            example = "The pond will freeze before the end of the week.",
            exampleNative = "Пруд успеет freeze до конца недели.",
            pos = "verb", semanticGroup = "weather_l1_actions",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37516L, 37517L)),

        WordEntity(id = 37519, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "windy", transliteration = "[ˈwɪndi]", translation = "ветреный",
            definition = "With lots of moving air — when leaves and hats fly around.",
            definitionNative = "С сильным потоком воздуха — когда листья и шапки разлетаются.",
            example = "It was too windy for a picnic on the open hill.",
            exampleNative = "Было слишком windy для пикника на открытом холме.",
            pos = "adjective", semanticGroup = "weather_l1_actions",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37510L, 37512L, 37513L, 37514L, 37520L)),

        WordEntity(id = 37520, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "rainy", transliteration = "[ˈreɪni]", translation = "дождливый",
            definition = "With water falling from the clouds for a long time.",
            definitionNative = "Когда с туч долго льётся вода — гулять не хочется без зонта.",
            example = "We stayed inside on that grey rainy afternoon.",
            exampleNative = "Мы остались дома в тот серый rainy день.",
            pos = "adjective", semanticGroup = "weather_l1_actions",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37510L, 37512L, 37514L, 37519L)),

        // ── weather_l1_storms (5) ─────────────────────────────────────────

        WordEntity(id = 37521, setId = 375, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "thunderstorm", transliteration = "[ˈθəndərˌstɔrm]", translation = "гроза",
            definition = "Bad weather with loud rumbles, bright flashes and heavy water from the sky.",
            definitionNative = "Ненастье с громкими раскатами, яркими вспышками и сильным потоком воды с неба.",
            example = "A loud thunderstorm woke the whole family at midnight.",
            exampleNative = "Громкая thunderstorm разбудила всю семью в полночь.",
            pos = "noun", semanticGroup = "weather_l1_storms",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37522L, 37523L, 37524L, 37525L)),

        WordEntity(id = 37522, setId = 375, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "snowstorm", transliteration = "[ˈsnoʊˌstɔrm]", translation = "снежная буря",
            definition = "A wild winter wind that throws white flakes in every direction.",
            definitionNative = "Дикий зимний ветер, который швыряет белые хлопья во все стороны.",
            example = "Schools closed because of the heavy snowstorm last Monday.",
            exampleNative = "Школы закрыли из-за сильной snowstorm в прошлый понедельник.",
            pos = "noun", semanticGroup = "weather_l1_storms",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37507L, 37521L, 37523L, 37524L, 37525L)),

        WordEntity(id = 37523, setId = 375, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "rainfall", transliteration = "[ˈreɪnˌfɔl]", translation = "осадки",
            definition = "The amount of water that drops from the sky over an area.",
            definitionNative = "Количество воды, что выпадает с неба на какой-то участок земли.",
            example = "We had heavy rainfall every evening last week.",
            exampleNative = "На прошлой неделе каждый вечер был сильный rainfall.",
            pos = "noun", semanticGroup = "weather_l1_storms",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37507L, 37521L, 37522L, 37524L, 37525L)),

        WordEntity(id = 37524, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "hurricane", transliteration = "[ˈhərəˌkeɪn]", translation = "ураган",
            definition = "A huge dangerous wind that spins and tears off roofs and trees.",
            definitionNative = "Огромный опасный вихрь — крутится и срывает крыши и деревья на своём пути.",
            example = "The hurricane destroyed many houses near the coast.",
            exampleNative = "Hurricane разрушил много домов на побережье.",
            pos = "noun", semanticGroup = "weather_l1_storms",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37521L, 37522L, 37523L, 37525L)),

        WordEntity(id = 37525, setId = 375, languagePair = "en-ru", rarity = "COMMON",
            original = "raincoat", transliteration = "[ˈreɪnˌkoʊt]", translation = "плащ-дождевик",
            definition = "A long jacket of waterproof cloth that keeps you dry outside.",
            definitionNative = "Длинная куртка из непромокаемой ткани — в ней не намокаешь под ливнем.",
            example = "Don't forget your yellow raincoat — the sky looks dark.",
            exampleNative = "Не забудь свой жёлтый raincoat — небо темнеет.",
            pos = "noun", semanticGroup = "weather_l1_storms",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(37521L, 37522L, 37523L, 37524L)),
    )
}
