package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Погода и климат (L2, UNCOMMON+RARE).
 *
 * Set 376: «Погода и климат» — продвинутый уровень.
 *          Туман, гроза, прогноз, описания неба и атмосферные явления
 *          уровня A2-B2 (UNCOMMON+RARE). Не пересекается с L1 (set 375)
 *          и старыми наборами по погоде (sets 21, 226, 227).
 *
 * Распределение редкости: 18 UNCOMMON + 7 RARE — два смежных уровня (A2-B1 + B2).
 *
 * SemanticGroups (5 × 5):
 *   weather_l2_sky_appearance — gloomy, hazy, misty, dismal, leaden
 *   weather_l2_precipitation  — downfall, cloudburst, raindrops, deluge, torrent
 *   weather_l2_temp_feel      — balmy, brisk, sweltering, nippy, sultry
 *   weather_l2_atmosphere     — warmth, dampness, moisture, whirlwind, whiteout
 *   weather_l2_meteo          — forecaster, outlook, tropical, temperate, wintry
 *
 * Word IDs: setId × 100 + position (37601..37625).
 *
 * fillInBlankExclusions / isFillInBlankSafe не задаются — заполнятся через
 * FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishWeatherL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 376,
            languagePair = "en-ru",
            orderIndex = 376,
            name = "Погода и климат",
            description = "Туман, гроза, прогноз и описание неба",
            topic = "Погода и климат",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 376 — Погода и климат: продвинутый (L2, UNCOMMON+RARE)       ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── weather_l2_sky_appearance (5) ─────────────────────────────────

        WordEntity(id = 37601, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "gloomy", transliteration = "[ˈɡluːmi]", translation = "пасмурный, угрюмый",
            definition = "Dark and a bit sad — like a sky covered with thick grey clouds.",
            definitionNative = "Тёмный и немного унылый — как небо, затянутое плотными серыми тучами.",
            example = "The morning was so gloomy that we kept the lights on.",
            exampleNative = "Утро было таким gloomy, что мы не выключали свет.",
            pos = "adjective", semanticGroup = "weather_l2_sky_appearance", fillInBlankExclusions = listOf(37602L, 37603L, 37604L, 37605L)),

        WordEntity(id = 37602, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hazy", transliteration = "[ˈheɪzi]", translation = "затуманенный, в дымке",
            definition = "Slightly blurred by light fog or dust — when the sun looks pale.",
            definitionNative = "Слегка размытый лёгкой дымкой или пылью — когда солнце кажется бледным.",
            example = "The mountains looked hazy in the heat of the afternoon.",
            exampleNative = "Горы казались hazy в полуденном зное.",
            pos = "adjective", semanticGroup = "weather_l2_sky_appearance", fillInBlankExclusions = listOf(37601L, 37603L, 37604L, 37605L, 37623L)),

        WordEntity(id = 37603, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "misty", transliteration = "[ˈmɪsti]", translation = "туманный (лёгкий туман)",
            definition = "Filled with thin floating water drops — soft and slightly wet to walk through.",
            definitionNative = "Полный тонких висящих капель — мягко и чуть влажно идти сквозь него.",
            example = "Early autumn mornings are often misty in our valley.",
            exampleNative = "Ранние осенние утра у нас в долине часто misty.",
            pos = "adjective", semanticGroup = "weather_l2_sky_appearance", fillInBlankExclusions = listOf(37601L, 37602L, 37604L, 37605L, 37612L, 37614L, 37625L)),

        WordEntity(id = 37604, setId = 376, languagePair = "en-ru", rarity = "RARE",
            original = "dismal", transliteration = "[ˈdɪzməl]", translation = "беспросветный, унылый",
            definition = "Looking joyless and grey — when the sky promises rain for days.",
            definitionNative = "Безрадостный и серый на вид — когда небо обещает дожди на много дней.",
            example = "We faced another dismal week of cold autumn rain.",
            exampleNative = "Нас ждала ещё одна dismal неделя холодных осенних дождей.",
            pos = "adjective", semanticGroup = "weather_l2_sky_appearance", fillInBlankExclusions = listOf(37601L, 37602L, 37603L, 37605L, 37625L)),

        WordEntity(id = 37605, setId = 376, languagePair = "en-ru", rarity = "RARE",
            original = "leaden", transliteration = "[ˈlɛdən]", translation = "свинцовый (о небе)",
            definition = "Dull grey and heavy — like a sheet of metal stretched across the sky.",
            definitionNative = "Тусклый, серый и тяжёлый — будто лист металла растянут по небу.",
            example = "A leaden sky hung over the city all afternoon.",
            exampleNative = "Над городом весь день висело leaden небо.",
            pos = "adjective", semanticGroup = "weather_l2_sky_appearance", fillInBlankExclusions = listOf(37601L, 37602L, 37603L, 37604L, 37615L, 37623L, 37625L)),

        // ── weather_l2_precipitation (5) ──────────────────────────────────

        WordEntity(id = 37606, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "downfall", transliteration = "[ˈdaʊnˌfɔl]", translation = "сильный ливень/снегопад",
            definition = "A sudden strong fall of water or snow from the sky.",
            definitionNative = "Внезапный сильный поток воды или снега с неба.",
            example = "A heavy downfall washed the dust off the streets.",
            exampleNative = "Сильный downfall смыл пыль с улиц.",
            pos = "noun", semanticGroup = "weather_l2_precipitation", fillInBlankExclusions = listOf(37607L, 37608L, 37609L, 37610L)),

        WordEntity(id = 37607, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cloudburst", transliteration = "[ˈklaʊdˌbərst]", translation = "ливень (внезапный)",
            definition = "A short violent rain that comes out of nowhere and soaks everything.",
            definitionNative = "Короткий яростный дождь, который налетает из ниоткуда и промачивает всё подряд.",
            example = "We got caught in a sudden cloudburst on our way home.",
            exampleNative = "На пути домой мы попали под внезапный cloudburst.",
            pos = "noun", semanticGroup = "weather_l2_precipitation", fillInBlankExclusions = listOf(37606L, 37608L, 37609L, 37610L, 37619L, 37620L)),

        WordEntity(id = 37608, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "raindrops", transliteration = "[ˈreɪnˌdrɑps]", translation = "капли дождя",
            definition = "Small round bits of falling water that hit the ground or roof.",
            definitionNative = "Маленькие круглые порции падающей воды, которые стучат по земле или крыше.",
            example = "Big raindrops started to tap on the kitchen window.",
            exampleNative = "Крупные raindrops застучали по кухонному окну.",
            pos = "noun", semanticGroup = "weather_l2_precipitation", fillInBlankExclusions = listOf(37606L, 37607L, 37609L, 37610L)),

        WordEntity(id = 37609, setId = 376, languagePair = "en-ru", rarity = "RARE",
            original = "deluge", transliteration = "[ˈdɛljuʤ]", translation = "потоп, ливень",
            definition = "A huge amount of water falling at once — strong enough to flood streets.",
            definitionNative = "Огромное количество воды, что обрушивается разом — хватает, чтобы затопить улицы.",
            example = "The deluge flooded our basement in just half an hour.",
            exampleNative = "Этот deluge за полчаса затопил нам подвал.",
            pos = "noun", semanticGroup = "weather_l2_precipitation", fillInBlankExclusions = listOf(37606L, 37607L, 37608L, 37610L)),

        WordEntity(id = 37610, setId = 376, languagePair = "en-ru", rarity = "RARE",
            original = "torrent", transliteration = "[ˈtɔrənt]", translation = "стремительный поток",
            definition = "A fast strong rush of water — in a storm or down a hillside.",
            definitionNative = "Быстрая мощная река воды — в бурю или с горного склона вниз.",
            example = "A torrent of rain rushed along the narrow alley.",
            exampleNative = "По узкой улочке мчался torrent дождевой воды.",
            pos = "noun", semanticGroup = "weather_l2_precipitation", fillInBlankExclusions = listOf(37606L, 37607L, 37608L, 37609L)),

        // ── weather_l2_temp_feel (5) ──────────────────────────────────────

        WordEntity(id = 37611, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "balmy", transliteration = "[ˈbɑːmi]", translation = "мягкий и тёплый (о погоде)",
            definition = "Pleasant and gentle in the air — like a soft summer evening by the sea.",
            definitionNative = "Приятный и нежный в воздухе — как ласковый летний вечер у моря.",
            example = "We had a balmy evening on the terrace with cold lemonade.",
            exampleNative = "У нас был balmy вечер на террасе с холодным лимонадом.",
            pos = "adjective", semanticGroup = "weather_l2_temp_feel", fillInBlankExclusions = listOf(37601L, 37602L, 37603L, 37604L, 37605L, 37612L, 37613L, 37614L, 37615L, 37623L, 37624L)),

        WordEntity(id = 37612, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "brisk", transliteration = "[brɪsk]", translation = "бодрящий, свежий",
            definition = "Cool and fresh in a way that makes you walk faster and feel awake.",
            definitionNative = "Холодок такой, что хочется идти быстрее и чувствовать себя живее.",
            example = "A brisk wind blew across the harbour at dawn.",
            exampleNative = "На рассвете над гаванью дул brisk ветер.",
            pos = "adjective", semanticGroup = "weather_l2_temp_feel", fillInBlankExclusions = listOf(37604L, 37611L, 37613L, 37614L, 37615L, 37623L, 37625L)),

        WordEntity(id = 37613, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sweltering", transliteration = "[ˈswɛltərɪŋ]", translation = "знойный, изнуряюще жаркий",
            definition = "Uncomfortably hot — when you sweat the moment you step outside.",
            definitionNative = "Невыносимо жаркий — когда потеешь в ту же секунду, как вышел на улицу.",
            example = "The kitchen felt sweltering with three pots boiling at once.",
            exampleNative = "На кухне было sweltering — кипели сразу три кастрюли.",
            pos = "adjective", semanticGroup = "weather_l2_temp_feel", fillInBlankExclusions = listOf(37601L, 37602L, 37603L, 37611L, 37612L, 37614L, 37615L, 37623L)),

        WordEntity(id = 37614, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "nippy", transliteration = "[ˈnɪpi]", translation = "холодноватый, зябкий",
            definition = "Cold enough to bite the cheeks — but not freezing yet.",
            definitionNative = "Холодок такой, что щиплет щёки — но до настоящего мороза ещё далеко.",
            example = "It's a bit nippy — better grab your scarf.",
            exampleNative = "Сегодня nippy — лучше захвати шарф.",
            pos = "adjective", semanticGroup = "weather_l2_temp_feel", fillInBlankExclusions = listOf(37611L, 37612L, 37613L, 37615L, 37625L)),

        WordEntity(id = 37615, setId = 376, languagePair = "en-ru", rarity = "RARE",
            original = "sultry", transliteration = "[ˈsʌltri]", translation = "знойный и душный",
            definition = "Hot, still and damp — when the air feels heavy on your skin.",
            definitionNative = "Жаркий, неподвижный и влажный — когда воздух тяжело давит на кожу.",
            example = "It was a sultry July night without a single breeze.",
            exampleNative = "Стояла sultry июльская ночь без единого дуновения.",
            pos = "adjective", semanticGroup = "weather_l2_temp_feel", fillInBlankExclusions = listOf(37601L, 37602L, 37603L, 37604L, 37605L, 37611L, 37612L, 37613L, 37614L, 37623L, 37624L)),

        // ── weather_l2_atmosphere (5) ─────────────────────────────────────

        WordEntity(id = 37616, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "warmth", transliteration = "[wɔrmθ]", translation = "тепло (ощущение)",
            definition = "The pleasant feeling of mild heat — from the sun, a fire or a hug.",
            definitionNative = "Приятное ощущение мягкого жара — от солнца, костра или объятий.",
            example = "I felt the warmth of the sun on my back as I walked.",
            exampleNative = "Я чувствовал warmth солнца на спине, пока шёл.",
            pos = "noun", semanticGroup = "weather_l2_atmosphere", fillInBlankExclusions = listOf(37617L, 37618L, 37619L, 37620L)),

        WordEntity(id = 37617, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "dampness", transliteration = "[ˈdæmpnəs]", translation = "сырость",
            definition = "A slightly wet feeling in the air, walls or clothes — never quite dry.",
            definitionNative = "Чуть влажное ощущение в воздухе, стенах или одежде — будто ничто не просыхает.",
            example = "There was a chilly dampness in the old stone basement.",
            exampleNative = "В старом каменном подвале стояла промозглая dampness.",
            pos = "noun", semanticGroup = "weather_l2_atmosphere", fillInBlankExclusions = listOf(37616L, 37618L, 37619L, 37620L)),

        WordEntity(id = 37618, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "moisture", transliteration = "[ˈmɔɪsʧər]", translation = "влага",
            definition = "Tiny bits of water held in the air, soil or a piece of fabric.",
            definitionNative = "Крошечные частички воды в воздухе, почве или ткани.",
            example = "Plants need moisture in the soil to grow well.",
            exampleNative = "Растениям нужна moisture в почве, чтобы хорошо расти.",
            pos = "noun", semanticGroup = "weather_l2_atmosphere", fillInBlankExclusions = listOf(37616L, 37617L, 37619L, 37620L)),

        WordEntity(id = 37619, setId = 376, languagePair = "en-ru", rarity = "RARE",
            original = "whirlwind", transliteration = "[ˈwɜːrlˌwɪnd]", translation = "вихрь, смерч",
            definition = "A spinning column of air that sweeps up dust, leaves and small things.",
            definitionNative = "Закрученная воздушная труба — поднимает пыль, листья и мелкие предметы.",
            example = "A small whirlwind tossed the leaves around the yard.",
            exampleNative = "Маленький whirlwind закружил листья по двору.",
            pos = "noun", semanticGroup = "weather_l2_atmosphere", fillInBlankExclusions = listOf(37616L, 37617L, 37618L, 37620L)),

        WordEntity(id = 37620, setId = 376, languagePair = "en-ru", rarity = "RARE",
            original = "whiteout", transliteration = "[ˈwaɪtˌaʊt]", translation = "снежная мгла (без видимости)",
            definition = "A moment in heavy snow when nothing can be seen — only blinding white.",
            definitionNative = "Миг сильной метели, когда ничего не видно — лишь слепящая белизна вокруг.",
            example = "Drivers stopped on the highway during a sudden whiteout.",
            exampleNative = "Водители встали на трассе в момент внезапного whiteout.",
            pos = "noun", semanticGroup = "weather_l2_atmosphere", fillInBlankExclusions = listOf(37606L, 37607L, 37609L, 37610L, 37616L, 37617L, 37618L, 37619L)),

        // ── weather_l2_meteo (5) ──────────────────────────────────────────

        WordEntity(id = 37621, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "forecaster", transliteration = "[ˈfɔrˌkæstər]", translation = "метеоролог (на ТВ/радио)",
            definition = "The person on TV or radio who tells you what the weather will be.",
            definitionNative = "Человек на ТВ или радио, который рассказывает, какая ожидается погода.",
            example = "The forecaster promised sunshine for the whole weekend.",
            exampleNative = "Forecaster обещал солнечные дни на все выходные.",
            pos = "noun", semanticGroup = "weather_l2_meteo", fillInBlankExclusions = listOf(37622L)),

        WordEntity(id = 37622, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "outlook", transliteration = "[ˈaʊtˌlʊk]", translation = "прогноз, перспектива",
            definition = "A short summary of what is likely to happen with the weather soon.",
            definitionNative = "Короткая сводка о том, что вероятно произойдёт с погодой в ближайшее время.",
            example = "The outlook for next week shows mild and dry days.",
            exampleNative = "Outlook на следующую неделю обещает мягкие сухие дни.",
            pos = "noun", semanticGroup = "weather_l2_meteo", fillInBlankExclusions = listOf(37621L)),

        WordEntity(id = 37623, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tropical", transliteration = "[ˈtrɑpɪkəl]", translation = "тропический",
            definition = "Belonging to hot wet regions near the equator — palms, jungles, parrots.",
            definitionNative = "Относящийся к жарким влажным краям у экватора — пальмы, джунгли, попугаи.",
            example = "We stepped off the plane into thick tropical air.",
            exampleNative = "Мы сошли с самолёта прямо в густой tropical воздух.",
            pos = "adjective", semanticGroup = "weather_l2_meteo", fillInBlankExclusions = listOf(37601L, 37602L, 37603L, 37605L, 37613L, 37615L, 37624L, 37625L)),

        WordEntity(id = 37624, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "temperate", transliteration = "[ˈtɛmpərɪt]", translation = "умеренный (о климате)",
            definition = "Mild — never very hot or very cold, with four clear seasons.",
            definitionNative = "Мягкий — без сильной жары и сильных морозов, с четырьмя ясными сезонами.",
            example = "England has a temperate climate with rain all year round.",
            exampleNative = "В Англии temperate климат с дождями круглый год.",
            pos = "adjective", semanticGroup = "weather_l2_meteo", fillInBlankExclusions = listOf(37604L, 37613L, 37615L, 37623L, 37625L)),

        WordEntity(id = 37625, setId = 376, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wintry", transliteration = "[ˈwɪntri]", translation = "морозный (как в декабре)",
            definition = "Cold and grey, with frost on the ground and snow possible at any moment.",
            definitionNative = "Похожий на декабрь — холодный, серый, и, может быть, со снегом в воздухе.",
            example = "We woke up to a wintry morning with frost on the grass.",
            exampleNative = "Мы проснулись wintry утром, с инеем на траве.",
            pos = "adjective", semanticGroup = "weather_l2_meteo", fillInBlankExclusions = listOf(37601L, 37602L, 37603L, 37604L, 37605L, 37612L, 37614L, 37623L, 37624L)),
    )
}
