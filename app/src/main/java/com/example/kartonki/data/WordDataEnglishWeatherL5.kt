package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Погода и климат (L5, EPIC+LEGENDARY).
 *
 * Set 379: «Погода и климат» — носитель/архаика.
 *          Литературная и поэтическая лексика погоды: региональные ветра,
 *          архаичные сезонные прилагательные, поэтика света и сумерек,
 *          книжная зима, образные явления атмосферы (C1-C2+).
 *
 * Тема «Погода и климат» — продолжение L1 (set 375), L2 (set 376), L3 (set 377).
 * L4 (set 378) — соседний уровень (B2-C1), создаётся в той же волне.
 * Старые погодные наборы (sets 21, 226, 227) — занимают base lexicon.
 *
 * Все 25 слов этого сета не пересекаются ни с одним существующим английским
 * словом в базе (проверено grep по `original = "..."`). В частности обойдены
 * уже занятые архаичные/поэт. слова: zephyr, mistral, foehn, harmattan,
 * chinook (set 333 NatureL5); aurora, halo, alpenglow, petrichor, mirage
 * (set 333); sirocco, tempest (set 226); doldrums (EverydayL4); solstice,
 * equinox (set 216); drought (set 49); gust, squall (sets 226/227).
 *
 * Распределение редкости: 18 LEGENDARY + 7 EPIC — два смежных уровня (C1 + C2+).
 *
 * SemanticGroups (5 × 5):
 *   weather_l5_winds_archaic     — bora, khamsin, simoom, levanter, etesian
 *   weather_l5_seasons_archaic   — brumal, hyemal, estival, vernal, autumnal
 *   weather_l5_light_dusk        — crepuscular, gloaming, lambent, empyrean, firmament
 *   weather_l5_winter_archaic    — hoarfrost, rime, gelid, hyperborean, fimbulwinter
 *   weather_l5_atmosphere_poetic — susurrus, gossamer, thunderhead, tempestuous, maelstrom
 *
 * Word IDs: setId × 100 + position (37901..37925).
 *
 * fillInBlankExclusions / isFillInBlankSafe — НЕ задаются здесь. Заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave (известный баг:
 * если выставить заранее, pipeline пропустит запись).
 */
object WordDataEnglishWeatherL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 379,
            languagePair = "en-ru",
            orderIndex = 379,
            name = "Погода и климат",
            description = "Литературная и архаичная погодная лексика",
            topic = "Погода и климат",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 379 — Погода и климат: носитель/архаика (L5, EPIC+LEGENDARY) ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── weather_l5_winds_archaic (5) ──────────────────────────────────

        WordEntity(id = 37901, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bora",
            transliteration = "[ˈbɔrə]",
            translation = "бора (холодный нисходящий ветер Адриатики)",
            definition = "A fierce cold wind that rushes down from the mountains to the Adriatic coast.",
            definitionNative = "Свирепый холодный поток воздуха, что срывается с гор к Адриатике.",
            example = "A violent bora swept the harbour and tore tiles off the roofs.",
            exampleNative = "Яростный bora пронёсся по гавани и срывал черепицу с крыш.",
            pos = "noun", semanticGroup = "weather_l5_winds_archaic", fillInBlankExclusions = listOf(37902L, 37903L, 37904L, 37905L, 37925L)),

        WordEntity(id = 37902, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "khamsin",
            transliteration = "[xæmˈsiːn]",
            translation = "хамсин (жаркий сухой ветер Северной Африки)",
            definition = "A hot dry desert blast that blows out of Egypt for many days each spring.",
            definitionNative = "Знойный сухой пустынный поток, дующий из Египта помногу дней каждой весной.",
            example = "A scorching khamsin filled the air with fine reddish sand.",
            exampleNative = "Раскалённый khamsin наполнил воздух мелким красноватым песком.",
            pos = "noun", semanticGroup = "weather_l5_winds_archaic", fillInBlankExclusions = listOf(37901L, 37903L, 37904L, 37905L)),

        WordEntity(id = 37903, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "simoom",
            transliteration = "[sɪˈmum]",
            translation = "самум (раскалённая пыльная буря)",
            definition = "A burning sand-laden gale of the Sahara and Arabian deserts, choking and blinding.",
            definitionNative = "Пылающая песчаная буря Сахары и Аравии — душит и слепит идущего.",
            example = "A sudden simoom buried our caravan in scalding dust.",
            exampleNative = "Внезапный simoom похоронил наш караван в обжигающей пыли.",
            pos = "noun", semanticGroup = "weather_l5_winds_archaic", fillInBlankExclusions = listOf(37901L, 37902L, 37904L, 37905L)),

        WordEntity(id = 37904, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "levanter",
            transliteration = "[ləˈvæntər]",
            translation = "леванте (восточный ветер Средиземноморья)",
            definition = "A strong easterly that blows across the Strait of Gibraltar and the western Mediterranean.",
            definitionNative = "Сильный восточный поток через Гибралтарский пролив и западное Средиземноморье.",
            example = "A steady levanter held the fishing fleet in port for three days.",
            exampleNative = "Упорный levanter держал рыбацкий флот в порту три дня.",
            pos = "noun", semanticGroup = "weather_l5_winds_archaic", fillInBlankExclusions = listOf(37901L, 37902L, 37903L, 37905L)),

        WordEntity(id = 37905, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "etesian",
            transliteration = "[ɪˈtiʒən]",
            translation = "этезии (северный летний ветер Эгейского моря)",
            definition = "A dry northerly that blows over the Aegean Sea every summer.",
            definitionNative = "Сухой северный поток, дующий над Эгейским морем каждое лето.",
            example = "Sailors waited for the etesian to fill the canvas at noon.",
            exampleNative = "Моряки ждали, когда etesian наполнит парус в полдень.",
            pos = "noun", semanticGroup = "weather_l5_winds_archaic", fillInBlankExclusions = listOf(37901L, 37902L, 37903L, 37904L)),

        // ── weather_l5_seasons_archaic (5) ────────────────────────────────

        WordEntity(id = 37906, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "brumal",
            transliteration = "[ˈbruːməl]",
            translation = "зимний (поэтич./арх.)",
            definition = "Belonging to the cold dark season — a literary word for what comes after autumn.",
            definitionNative = "Относящийся к холодному тёмному времени года — книжное слово об этой поре.",
            example = "A brumal silence lay upon the snowy graveyard.",
            exampleNative = "Brumal тишина лежала над заснеженным погостом.",
            pos = "adjective", semanticGroup = "weather_l5_seasons_archaic", fillInBlankExclusions = listOf(37907L, 37909L, 37911L, 37918L, 37919L)),

        WordEntity(id = 37907, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hyemal",
            transliteration = "[ˈhaɪəməl]",
            translation = "относящийся к холодному сезону (книжн.)",
            definition = "Of the cold months — a rare literary synonym used by poets and naturalists.",
            definitionNative = "О холодных месяцах — редкое книжное слово, любимое поэтами и натуралистами.",
            example = "The diary described the hyemal stillness of the frozen lake.",
            exampleNative = "Дневник описывал hyemal неподвижность замёрзшего озера.",
            pos = "adjective", semanticGroup = "weather_l5_seasons_archaic", fillInBlankExclusions = listOf(37906L, 37908L, 37909L, 37910L, 37911L, 37918L, 37919L)),

        WordEntity(id = 37908, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "estival",
            transliteration = "[ˈɛstɪvəl]",
            translation = "летний (поэтич./книжн.)",
            definition = "Of the warmest part of the year — a literary word for hot bright months.",
            definitionNative = "О самой тёплой части года — книжное слово для жарких ясных месяцев.",
            example = "The poet praised the estival glow on the river.",
            exampleNative = "Поэт воспевал estival сияние на реке.",
            pos = "adjective", semanticGroup = "weather_l5_seasons_archaic", fillInBlankExclusions = listOf(37906L, 37907L, 37909L, 37910L, 37911L, 37913L, 37919L)),

        WordEntity(id = 37909, setId = 379, languagePair = "en-ru", rarity = "EPIC",
            original = "vernal",
            transliteration = "[ˈvɜrnəl]",
            translation = "весенний (книжн.)",
            definition = "Of the season when buds open and birds return — a literary word.",
            definitionNative = "О времени года, когда раскрываются почки и возвращаются птицы — книжное слово.",
            example = "A vernal breeze stirred the catkins along the riverbank.",
            exampleNative = "Vernal ветерок шевелил серёжки вдоль берега реки.",
            pos = "adjective", semanticGroup = "weather_l5_seasons_archaic", fillInBlankExclusions = listOf(37906L, 37907L, 37911L, 37918L, 37919L)),

        WordEntity(id = 37910, setId = 379, languagePair = "en-ru", rarity = "EPIC",
            original = "autumnal",
            transliteration = "[ɔˈtʌmnəl]",
            translation = "осенний (книжн./поэт.)",
            definition = "Of the season of falling leaves and shorter days — a literary word.",
            definitionNative = "О поре падающей листвы и коротких дней — книжное слово.",
            example = "An autumnal mist lingered above the orchard until midday.",
            exampleNative = "Autumnal дымка висела над садом до полудня.",
            pos = "adjective", semanticGroup = "weather_l5_seasons_archaic", fillInBlankExclusions = listOf(37908L)),

        // ── weather_l5_light_dusk (5) ─────────────────────────────────────

        WordEntity(id = 37911, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "crepuscular",
            transliteration = "[krɪˈpʌskjələr]",
            translation = "сумеречный (книжн.)",
            definition = "Of the dim light at dawn or just before night — neither bright nor dark.",
            definitionNative = "О тусклом свете зари или мига перед ночью — не ярком и не тёмном.",
            example = "Bats began their crepuscular flight above the still pond.",
            exampleNative = "Летучие мыши начали свой crepuscular полёт над тихим прудом.",
            pos = "adjective", semanticGroup = "weather_l5_light_dusk", fillInBlankExclusions = listOf(37908L, 37909L, 37910L, 37913L)),

        WordEntity(id = 37912, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gloaming",
            transliteration = "[ˈɡloʊmɪŋ]",
            translation = "сумерки (поэт.)",
            definition = "The soft hour after sunset when colours fade — a poetic word for early dusk.",
            definitionNative = "Тихий час после заката, когда краски тают — поэтичное слово об этой поре.",
            example = "Lanterns flickered along the path in the autumn gloaming.",
            exampleNative = "Фонари мерцали вдоль тропы в осеннем gloaming.",
            pos = "noun", semanticGroup = "weather_l5_light_dusk", fillInBlankExclusions = listOf(37914L, 37915L)),

        WordEntity(id = 37913, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "lambent",
            transliteration = "[ˈlæmbənt]",
            translation = "мерцающий, играющий (о пламени или свете)",
            definition = "Glowing with a soft flickering radiance — like firelight on a cold wall.",
            definitionNative = "Светящийся мягким трепетным сиянием — как отблеск огня на холодной стене.",
            example = "A lambent moonlight played on the surface of the loch.",
            exampleNative = "Lambent лунный отблеск играл на поверхности озера.",
            pos = "adjective", semanticGroup = "weather_l5_light_dusk", fillInBlankExclusions = listOf(37906L, 37907L, 37909L, 37911L, 37918L, 37919L)),

        WordEntity(id = 37914, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "empyrean",
            transliteration = "[ˌɛmpɪˈriːən]",
            translation = "горние небеса (поэт.)",
            definition = "The highest reaches of the sky — a literary word for the heavens above the clouds.",
            definitionNative = "Самые высокие пределы неба — книжное слово о небесах над облаками.",
            example = "The spire seemed to pierce the empyrean at dawn.",
            exampleNative = "Шпиль, казалось, прокалывал empyrean на заре.",
            pos = "noun", semanticGroup = "weather_l5_light_dusk", fillInBlankExclusions = listOf(37912L, 37915L, 37922L, 37923L)),

        WordEntity(id = 37915, setId = 379, languagePair = "en-ru", rarity = "EPIC",
            original = "firmament",
            transliteration = "[ˈfɜrməmənt]",
            translation = "небесный свод (поэт.)",
            definition = "The vault of the sky as it appears overhead — a grand literary word for it.",
            definitionNative = "Свод неба так, как он видится сверху — торжественное книжное слово об этом.",
            example = "Stars blazed across the icy firmament above the steppe.",
            exampleNative = "Звёзды пылали по ледяному firmament над степью.",
            pos = "noun", semanticGroup = "weather_l5_light_dusk", fillInBlankExclusions = listOf(37912L, 37914L)),

        // ── weather_l5_winter_archaic (5) ─────────────────────────────────

        WordEntity(id = 37916, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hoarfrost",
            transliteration = "[ˈhɔrˌfrɔst]",
            translation = "иней (книжн., белый игольчатый)",
            definition = "A coating of tiny white needles that forms on cold surfaces during clear winter nights.",
            definitionNative = "Покров из крошечных белых иголочек на холодных поверхностях ясной зимней ночью.",
            example = "Hoarfrost glittered along every branch and railing at dawn.",
            exampleNative = "Hoarfrost блестел на каждой ветке и перилах на рассвете.",
            pos = "noun", semanticGroup = "weather_l5_winter_archaic", fillInBlankExclusions = listOf(37917L, 37920L, 37922L)),

        WordEntity(id = 37917, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "rime",
            transliteration = "[raɪm]",
            translation = "изморозь (густой белый налёт)",
            definition = "A thick white deposit left by freezing fog as it touches grass and twigs.",
            definitionNative = "Густой белый налёт, что остаётся от замерзающего тумана на траве и ветках.",
            example = "Heavy rime coated the rigging of the trawler that morning.",
            exampleNative = "Тяжёлый rime покрыл такелаж траулера тем утром.",
            pos = "noun", semanticGroup = "weather_l5_winter_archaic", fillInBlankExclusions = listOf(37916L, 37920L)),

        WordEntity(id = 37918, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gelid",
            transliteration = "[ˈʤɛlɪd]",
            translation = "ледяной (книжн., пронизывающе холодный)",
            definition = "Bitterly cold — a literary word used to describe air, water, or a lifeless gaze.",
            definitionNative = "Лютейше холодный — книжное слово о воздухе, воде или безжизненном взгляде.",
            example = "A gelid wind cut through every layer of his coat.",
            exampleNative = "Gelid ветер пробивал каждый слой его пальто.",
            pos = "adjective", semanticGroup = "weather_l5_winter_archaic", fillInBlankExclusions = listOf(37906L, 37907L, 37919L, 37924L)),

        WordEntity(id = 37919, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hyperborean",
            transliteration = "[ˌhaɪpərˈbɔriən]",
            translation = "крайне северный, гиперборейский",
            definition = "Of the lands far beyond the north wind — extremely cold and remote.",
            definitionNative = "О землях далеко за северным потоком воздуха — крайне холодных и далёких.",
            example = "He returned with tales of hyperborean wastes and silver auroras.",
            exampleNative = "Он вернулся с рассказами о hyperborean пустошах и серебряных сияниях.",
            pos = "adjective", semanticGroup = "weather_l5_winter_archaic", fillInBlankExclusions = listOf(37906L, 37907L, 37911L, 37918L, 37924L)),

        WordEntity(id = 37920, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "fimbulwinter",
            transliteration = "[ˈfɪmbəlˌwɪntər]",
            translation = "фимбульвинтер (миф. великая зима)",
            definition = "The mythic three-year frost foretold in Norse legend before the end of the world.",
            definitionNative = "Мифический трёхлетний мороз из норвежских преданий — перед концом мира.",
            example = "The saga foretold a fimbulwinter that would freeze every river.",
            exampleNative = "Сага предрекала fimbulwinter, что заморозит все реки.",
            pos = "noun", semanticGroup = "weather_l5_winter_archaic", fillInBlankExclusions = listOf(37916L, 37917L)),

        // ── weather_l5_atmosphere_poetic (5) ──────────────────────────────

        WordEntity(id = 37921, setId = 379, languagePair = "en-ru", rarity = "EPIC",
            original = "susurrus",
            transliteration = "[suˈsʌrəs]",
            translation = "шелест, шёпот (ветра, листвы)",
            definition = "A soft murmuring sound — like leaves stirring or distant water on a still night.",
            definitionNative = "Тихий бормочущий звук — как шевелится листва или плещет вода в тихую ночь.",
            example = "A faint susurrus moved through the pines at midnight.",
            exampleNative = "Лёгкий susurrus прошёл сквозь сосны в полночь.",
            pos = "noun", semanticGroup = "weather_l5_atmosphere_poetic", fillInBlankExclusions = listOf(37901L, 37904L, 37922L, 37923L, 37925L)),

        WordEntity(id = 37922, setId = 379, languagePair = "en-ru", rarity = "EPIC",
            original = "gossamer",
            transliteration = "[ˈɡɑsəmər]",
            translation = "паутинка / нечто тончайшее",
            definition = "Thin floating spider threads carried on autumn air, used for anything delicate and weightless.",
            definitionNative = "Тонкие плывущие нити паука в осеннем воздухе — образ всего нежного и невесомого.",
            example = "A web of gossamer caught the morning sun on the meadow.",
            exampleNative = "Сеть из gossamer ловила утреннее солнце на лугу.",
            pos = "noun", semanticGroup = "weather_l5_atmosphere_poetic", fillInBlankExclusions = listOf(37916L, 37917L, 37921L, 37923L, 37925L)),

        WordEntity(id = 37923, setId = 379, languagePair = "en-ru", rarity = "EPIC",
            original = "thunderhead",
            transliteration = "[ˈθʌndərˌhɛd]",
            translation = "грозовая туча (высокая, кучевая)",
            definition = "A tall rounded cloud rising like a tower before a violent summer storm.",
            definitionNative = "Высокое округлое облако, что поднимается башней перед яростной летней бурей.",
            example = "A dark thunderhead built up swiftly above the prairie.",
            exampleNative = "Тёмный thunderhead быстро рос над прерией.",
            pos = "noun", semanticGroup = "weather_l5_atmosphere_poetic", fillInBlankExclusions = listOf(37902L, 37903L, 37904L, 37921L, 37922L, 37925L)),

        WordEntity(id = 37924, setId = 379, languagePair = "en-ru", rarity = "EPIC",
            original = "tempestuous",
            transliteration = "[tɛmˈpɛsʧuəs]",
            translation = "бурный, неистовый (о погоде или нраве)",
            definition = "Wildly stormy — full of howling wind, lashing rain and crashing waves.",
            definitionNative = "Дико ненастный — полный воющего ветра, хлещущего дождя и рушащихся волн.",
            example = "The fleet sheltered in the cove on that tempestuous night.",
            exampleNative = "Флот укрылся в бухте той tempestuous ночью.",
            pos = "adjective", semanticGroup = "weather_l5_atmosphere_poetic", fillInBlankExclusions = listOf(37906L, 37907L, 37910L, 37918L, 37919L)),

        WordEntity(id = 37925, setId = 379, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "maelstrom",
            transliteration = "[ˈmeɪlstrəm]",
            translation = "мальстрём, неистовая стихия (поэт.)",
            definition = "A huge spinning rush of water — used for any wild storm that pulls everything in.",
            definitionNative = "Огромный крутящийся поток воды — образ любой дикой стихии, что всё затягивает.",
            example = "Sailors feared the maelstrom that churned beyond the headland.",
            exampleNative = "Моряки страшились maelstrom, что бурлил за мысом.",
            pos = "noun", semanticGroup = "weather_l5_atmosphere_poetic", fillInBlankExclusions = listOf(37901L, 37904L, 37905L, 37921L, 37922L, 37923L)),
    )
}
