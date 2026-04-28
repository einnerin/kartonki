package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Погода и климат (L3, RARE+EPIC).
 *
 * Set 377: «Погода и климат» — углублённый.
 *          Метеорология базовая, фронты и циклоны, климатические зоны,
 *          погодные процессы и описания ненастий уровня B2.
 *
 * Тема «Погода и климат» — продолжение L1 (set 375). L2 (set 376) и старые
 * sets 226/227 покрывают соседние темы; все 25 слов этого сета не
 * пересекаются с уже существующими английскими словами в базе (проверено
 * grep'ом по `original = "..."`). В частности обойдены: atmosphere, barometer,
 * condensation, evaporation, precipitation, cyclone, tornado, monsoon, arid,
 * tropical?, drizzle (verb), gust — все эти слова уже есть в наборах 21/55/
 * 226/227.
 *
 * Распределение редкости: 18 RARE + 7 EPIC — два смежных уровня (B2 + C1).
 *
 * SemanticGroups (5 × 5):
 *   weather_l3_meteorology — meteorologist, synoptic, altimeter, airmass, advisory
 *   weather_l3_systems     — front, jet stream, wind shear, downburst, squall line
 *   weather_l3_climate     — mediterranean, arctic, polar, equatorial, subtropical
 *   weather_l3_processes   — pour, dissipate, subside, loom, engulf
 *   weather_l3_severity    — torrential, clement, bracing, oppressive, inclement
 *
 * Word IDs: setId × 100 + position (37701..37725).
 *
 * fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь (defaults в
 * WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно после wave;
 * если поставить их заранее, pipeline пропустит запись (известный баг).
 */
object WordDataEnglishWeatherL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 377,
            languagePair = "en-ru",
            orderIndex = 377,
            name = "Погода и климат",
            description = "Метеорология, циклоны и климатические зоны",
            topic = "Погода и климат",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 377 — Погода и климат: углублённый (L3, RARE+EPIC)           ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── weather_l3_meteorology (5) ────────────────────────────────────

        WordEntity(id = 37701, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "meteorologist", transliteration = "[ˌmitiərˈɑləʤɪst]", translation = "синоптик",
            definition = "A scientist who studies the air and predicts what the sky will do.",
            definitionNative = "Учёный, который изучает воздух и предсказывает, что произойдёт на небе.",
            example = "The meteorologist warned of heavy rain by the weekend.",
            exampleNative = "Meteorologist предупредил о сильных дождях к выходным.",
            pos = "noun", semanticGroup = "weather_l3_meteorology", fillInBlankExclusions = listOf(37703L, 37704L, 37705L)),

        WordEntity(id = 37702, setId = 377, languagePair = "en-ru", rarity = "EPIC",
            original = "synoptic", transliteration = "[sɪˈnɑptɪk]", translation = "синоптический",
            definition = "Showing the whole picture of the air over a wide area at one moment.",
            definitionNative = "Показывающий целиком картину воздуха над большой территорией в один миг.",
            example = "The synoptic chart showed a deep low over the Atlantic.",
            exampleNative = "Synoptic карта показывала глубокий минимум над Атлантикой.",
            pos = "adjective", semanticGroup = "weather_l3_meteorology"),

        WordEntity(id = 37703, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "altimeter", transliteration = "[ˌæltɪˈmitər]", translation = "высотомер",
            definition = "A device that tells a pilot or hiker how high above the ground they are.",
            definitionNative = "Прибор, показывающий пилоту или туристу, насколько он поднялся над землёй.",
            example = "The pilot checked the altimeter before starting the descent.",
            exampleNative = "Пилот сверился с altimeter перед началом снижения.",
            pos = "noun", semanticGroup = "weather_l3_meteorology", fillInBlankExclusions = listOf(37701L, 37704L, 37705L)),

        WordEntity(id = 37704, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "airmass", transliteration = "[ˈɛrˌmæs]", translation = "воздушная масса",
            definition = "A huge body of air with the same warmth and wetness throughout.",
            definitionNative = "Огромное тело воздуха с одинаковой теплотой и влагой на всём протяжении.",
            example = "A cold airmass from the Arctic moved south last night.",
            exampleNative = "Холодный airmass из Арктики ночью двинулся на юг.",
            pos = "noun", semanticGroup = "weather_l3_meteorology", fillInBlankExclusions = listOf(37701L, 37703L, 37705L, 37706L)),

        WordEntity(id = 37705, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "advisory", transliteration = "[ədˈvaɪzəri]", translation = "штормовое предупреждение",
            definition = "An official warning about rough weather coming to an area.",
            definitionNative = "Официальное предупреждение о ненастье, которое идёт в данную местность.",
            example = "The agency issued a flood advisory for the whole valley.",
            exampleNative = "Агентство выпустило advisory о наводнении на всю долину.",
            pos = "noun", semanticGroup = "weather_l3_meteorology", fillInBlankExclusions = listOf(37701L, 37703L, 37704L)),

        // ── weather_l3_systems (5) ────────────────────────────────────────

        WordEntity(id = 37706, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "front", transliteration = "[frənt]", translation = "атмосферный фронт",
            definition = "The line where warm air meets cold air and the sky often changes.",
            definitionNative = "Граница, где тёплый воздух встречается с холодным и небо часто меняется.",
            example = "A cold front will reach the coast by tomorrow morning.",
            exampleNative = "Холодный front достигнет побережья к утру.",
            pos = "noun", semanticGroup = "weather_l3_systems", fillInBlankExclusions = listOf(37704L, 37707L, 37708L, 37709L, 37710L)),

        WordEntity(id = 37707, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "jet stream", transliteration = "[ʤɛt strim]", translation = "струйное течение",
            definition = "A narrow river of fast wind very high up that planes often ride.",
            definitionNative = "Узкая река быстрого ветра высоко в небе, по которой часто летят самолёты.",
            example = "The plane caught the jet stream and arrived an hour early.",
            exampleNative = "Самолёт поймал jet stream и прилетел на час раньше.",
            pos = "noun", semanticGroup = "weather_l3_systems", fillInBlankExclusions = listOf(37706L, 37708L, 37709L, 37710L)),

        WordEntity(id = 37708, setId = 377, languagePair = "en-ru", rarity = "EPIC",
            original = "wind shear", transliteration = "[wɪnd ʃɪr]", translation = "ветровой сдвиг",
            definition = "A sudden change in the speed or direction of moving air over a short distance.",
            definitionNative = "Резкое изменение скорости или направления потока воздуха на коротком отрезке.",
            example = "The pilot reported strong wind shear during the landing.",
            exampleNative = "Пилот сообщил о сильном wind shear при посадке.",
            pos = "noun", semanticGroup = "weather_l3_systems", fillInBlankExclusions = listOf(37706L, 37707L, 37709L, 37710L)),

        WordEntity(id = 37709, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "downburst", transliteration = "[ˈdaʊnˌbərst]", translation = "нисходящий шквал",
            definition = "A strong rush of air falling out of a storm cloud and hitting the ground.",
            definitionNative = "Сильный поток воздуха, рушащийся из грозовой тучи и бьющий о землю.",
            example = "A sudden downburst tore branches off the old oak.",
            exampleNative = "Внезапный downburst оторвал ветви от старого дуба.",
            pos = "noun", semanticGroup = "weather_l3_systems", fillInBlankExclusions = listOf(37706L, 37707L, 37708L, 37710L)),

        WordEntity(id = 37710, setId = 377, languagePair = "en-ru", rarity = "EPIC",
            original = "squall line", transliteration = "[skwɔl laɪn]", translation = "линия шквалов",
            definition = "A long row of fierce thunderstorms that moves together across an area.",
            definitionNative = "Длинная цепочка яростных гроз, которая движется вместе над территорией.",
            example = "A squall line raced across the plains, knocking down trees.",
            exampleNative = "Squall line пронеслась по равнинам, ломая деревья.",
            pos = "noun", semanticGroup = "weather_l3_systems", fillInBlankExclusions = listOf(37706L, 37707L, 37708L, 37709L)),

        // ── weather_l3_climate (5) ────────────────────────────────────────

        WordEntity(id = 37711, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "mediterranean", transliteration = "[ˌmɛdətəˈreɪniən]", translation = "средиземноморский",
            definition = "Of the climate near the inland sea between Europe and Africa.",
            definitionNative = "О климате у внутреннего моря между Европой и Африкой.",
            example = "The hills enjoy a mild mediterranean climate.",
            exampleNative = "На холмах царит мягкий mediterranean климат.",
            pos = "adjective", semanticGroup = "weather_l3_climate", fillInBlankExclusions = listOf(37712L, 37713L, 37714L, 37715L)),

        WordEntity(id = 37712, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "arctic", transliteration = "[ˈɑrktɪk]", translation = "арктический",
            definition = "Of the very cold zone near the top of the world, full of ice.",
            definitionNative = "О очень холодной зоне у верхушки мира, полной льда и снега.",
            example = "Arctic winds chilled the whole northern coast.",
            exampleNative = "Arctic ветры выстудили всё северное побережье.",
            pos = "adjective", semanticGroup = "weather_l3_climate", fillInBlankExclusions = listOf(37711L, 37713L, 37714L, 37715L)),

        WordEntity(id = 37713, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "polar", transliteration = "[ˈpoʊlər]", translation = "полярный",
            definition = "Of the icy zones at the very top and bottom of the Earth.",
            definitionNative = "Относящийся к ледяным зонам на самом верху и снизу планеты.",
            example = "Polar bears live on the frozen sea around the North Pole.",
            exampleNative = "Polar медведи живут на льдинах вокруг Северного полюса.",
            pos = "adjective", semanticGroup = "weather_l3_climate", fillInBlankExclusions = listOf(37711L, 37712L, 37714L, 37715L)),

        WordEntity(id = 37714, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "equatorial", transliteration = "[ˌɛkwəˈtɔriəl]", translation = "экваториальный",
            definition = "Of the hot wet belt around the middle line that splits the Earth.",
            definitionNative = "Относящийся к жаркому влажному поясу вдоль срединной линии планеты.",
            example = "Heavy rain fell daily in the equatorial forest.",
            exampleNative = "Сильный дождь шёл каждый день в equatorial лесу.",
            pos = "adjective", semanticGroup = "weather_l3_climate", fillInBlankExclusions = listOf(37711L, 37712L, 37713L, 37715L)),

        WordEntity(id = 37715, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "subtropical", transliteration = "[ˌsəbˈtrɑpɪkəl]", translation = "субтропический",
            definition = "Of the warm zone just outside the hottest belt — like southern Spain.",
            definitionNative = "О тёплом поясе сразу за самым жарким — как юг Испании.",
            example = "Florida has a subtropical climate with mild winters.",
            exampleNative = "Во Флориде subtropical климат с мягкими зимами.",
            pos = "adjective", semanticGroup = "weather_l3_climate", fillInBlankExclusions = listOf(37711L, 37713L)),

        // ── weather_l3_processes (5) ──────────────────────────────────────

        WordEntity(id = 37716, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "pour", transliteration = "[pɔr]", translation = "лить как из ведра",
            definition = "Rain so hard that streets quickly fill with water.",
            definitionNative = "Идти настолько сильно, что улицы быстро наполняются водой.",
            example = "It started to pour just as we left the house.",
            exampleNative = "Дождь начал pour, как только мы вышли из дома.",
            pos = "verb", semanticGroup = "weather_l3_processes", fillInBlankExclusions = listOf(37717L, 37718L, 37719L, 37720L)),

        WordEntity(id = 37717, setId = 377, languagePair = "en-ru", rarity = "EPIC",
            original = "dissipate", transliteration = "[ˈdɪsəˌpeɪt]", translation = "рассеиваться",
            definition = "Slowly fade and break apart — like fog when the sun warms the ground.",
            definitionNative = "Медленно угасать и распадаться — как туман, когда солнце прогревает землю.",
            example = "The morning fog began to dissipate by ten o'clock.",
            exampleNative = "Утренний туман начал dissipate к десяти часам.",
            pos = "verb", semanticGroup = "weather_l3_processes", fillInBlankExclusions = listOf(37716L, 37718L, 37719L, 37720L)),

        WordEntity(id = 37718, setId = 377, languagePair = "en-ru", rarity = "EPIC",
            original = "subside", transliteration = "[səbˈsaɪd]", translation = "стихать",
            definition = "Become quieter and weaker after being strong — about wind, rain or noise.",
            definitionNative = "Становиться тише и слабее после сильного — о ветре, дожде или шуме.",
            example = "The wind began to subside as the storm moved east.",
            exampleNative = "Ветер начал subside, когда буря двинулась на восток.",
            pos = "verb", semanticGroup = "weather_l3_processes", fillInBlankExclusions = listOf(37716L, 37717L, 37719L, 37720L)),

        WordEntity(id = 37719, setId = 377, languagePair = "en-ru", rarity = "EPIC",
            original = "loom", transliteration = "[lum]", translation = "нависать (о туче)",
            definition = "Appear large and dark in a worrying way — like a black cloud nearby.",
            definitionNative = "Тревожно проступать большим и тёмным — как чёрная туча неподалёку.",
            example = "Dark clouds began to loom over the harbour.",
            exampleNative = "Тёмные тучи начали loom над гаванью.",
            pos = "verb", semanticGroup = "weather_l3_processes", fillInBlankExclusions = listOf(37716L, 37717L, 37718L, 37720L)),

        WordEntity(id = 37720, setId = 377, languagePair = "en-ru", rarity = "EPIC",
            original = "engulf", transliteration = "[ɛnˈgəlf]", translation = "поглощать",
            definition = "Cover something completely and suddenly — like fog swallowing a town.",
            definitionNative = "Полностью и внезапно покрывать собой — как туман, проглатывающий город.",
            example = "Thick fog began to engulf the entire valley.",
            exampleNative = "Густой туман начал engulf всю долину.",
            pos = "verb", semanticGroup = "weather_l3_processes", fillInBlankExclusions = listOf(37716L, 37717L, 37718L, 37719L)),

        // ── weather_l3_severity (5) ───────────────────────────────────────

        WordEntity(id = 37721, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "torrential", transliteration = "[tɔˈrɛnʃəl]", translation = "проливной",
            definition = "Falling in huge amounts very quickly — said of rain that floods streets.",
            definitionNative = "Льющийся в огромных количествах и очень быстро — о ливне, что топит улицы.",
            example = "Torrential rain washed cars off the mountain road.",
            exampleNative = "Torrential дождь смыл машины с горной дороги.",
            pos = "adjective", semanticGroup = "weather_l3_severity", fillInBlankExclusions = listOf(37722L, 37723L, 37724L, 37725L)),

        WordEntity(id = 37722, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "clement", transliteration = "[ˈklɛmənt]", translation = "благоприятный (о погоде)",
            definition = "Pleasantly mild outside — without harsh wind, rain or cold.",
            definitionNative = "Приятно мягкий за окном — без резкого ветра, дождя или мороза.",
            example = "The hike was easy thanks to the clement weather.",
            exampleNative = "Поход прошёл легко благодаря clement погоде.",
            pos = "adjective", semanticGroup = "weather_l3_severity", fillInBlankExclusions = listOf(37721L, 37723L, 37724L, 37725L)),

        WordEntity(id = 37723, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "bracing", transliteration = "[ˈbreɪsɪŋ]", translation = "бодрящий и свежий",
            definition = "Cool and fresh in a way that wakes you up — like sea air in spring.",
            definitionNative = "Прохладный и свежий так, что взбадривает — как морской воздух весной.",
            example = "We took a bracing walk along the cliffs after lunch.",
            exampleNative = "После обеда мы пошли на bracing прогулку вдоль скал.",
            pos = "adjective", semanticGroup = "weather_l3_severity", fillInBlankExclusions = listOf(37721L, 37722L)),

        WordEntity(id = 37724, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "oppressive", transliteration = "[əˈprɛsɪv]", translation = "удушающе жаркий",
            definition = "So hot and heavy in the air that breathing feels difficult.",
            definitionNative = "Настолько тяжёлый и жаркий, что становится трудно дышать.",
            example = "The oppressive heat kept everyone indoors all afternoon.",
            exampleNative = "Oppressive жара держала всех в помещении весь день.",
            pos = "adjective", semanticGroup = "weather_l3_severity", fillInBlankExclusions = listOf(37714L, 37715L, 37721L, 37722L, 37723L, 37725L)),

        WordEntity(id = 37725, setId = 377, languagePair = "en-ru", rarity = "RARE",
            original = "inclement", transliteration = "[ɪnˈklɛmənt]", translation = "ненастный",
            definition = "Rough and unpleasant outside — with cold wind, rain or snow at once.",
            definitionNative = "Суровый и неприятный за окном — с холодным ветром, дождём или снегом разом.",
            example = "The match was postponed due to inclement weather.",
            exampleNative = "Матч перенесли из-за inclement погоды.",
            pos = "adjective", semanticGroup = "weather_l3_severity", fillInBlankExclusions = listOf(37712L, 37721L, 37722L, 37723L, 37724L)),
    )
}
