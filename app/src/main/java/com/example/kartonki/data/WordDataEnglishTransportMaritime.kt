package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 467.
 * Транспорт: морской и водный транспорт (L3 / UNCOMMON + RARE).
 *
 * Расширение темы «Транспорт». Дополняет существующие сеты:
 *   - 19         (L1) — базовые виды транспорта (WordDataEnglish).
 *   - 228, 229   (L2-L4) — авиация, ж/д, морская терминология (WordDataEnglishTransport2).
 *   - 252        (L5) — устаревшие экипажи, парусники, ж/д (WordDataEnglishTransportL5).
 *
 * Подтема — морской и водный транспорт: суда, части корабля, порт и
 * инфраструктура, навигация и плавание. НЕ авиация, НЕ авто, НЕ ж/д.
 *
 * Четыре семантические группы:
 *   transport_maritime_vessels   — freighter, tanker, yacht, sailboat,
 *                                  tugboat, kayak, catamaran
 *   transport_maritime_parts     — hull, stern, mast, sail, propeller, porthole
 *   transport_maritime_port      — dock, wharf, lighthouse, marina, shipyard, buoy
 *   transport_maritime_navigation — navigation, knot, mooring, fleet,
 *                                   nautical, maritime
 *
 * Исключены из набора кандидатов (уже есть в других сетах):
 *   - schooner (252), barge, ferry, bow, rudder, keel, bridge, gangway,
 *     helm, harbor, pier, quay, anchor, voyage, tide, current, wake, berth,
 *     draft, buoyancy, deck, aboard, cargo, crew, captain, sailor,
 *     starboard, stem.
 *
 * Word IDs: 46701..46725 (setId × 100 + position).
 */
object WordDataEnglishTransportMaritime {

    val sets = listOf(
        WordSetEntity(
            id = 467,
            name = "Транспорт",
            description = "Морской и водный транспорт: суда, части корабля, порт, навигация (freighter, hull, marina, mooring)",
            languagePair = "en-ru",
            orderIndex = 467,
            topic = "Транспорт",
            level = 3,
        ),
    )

    val words = listOf(

        // ── transport_maritime_vessels (типы судов и плавсредств) ─────────────
        WordEntity(
            id = 46701, original = "freighter", transliteration = "[ˈfreɪtər]", translation = "грузовое судно",
            definition = "A large ship built to carry boxes, containers and bulk goods across seas, not passengers.",
            definitionNative = "Большое судно для перевозки контейнеров и насыпных грузов через моря, без пассажиров.",
            example = "A rusty freighter from Panama unloaded its containers at the south terminal all morning.",
            exampleNative = "Ржавый freighter из Панамы всё утро разгружал свои контейнеры на южном терминале.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(46702L, 46703L, 46704L, 46705L, 46706L, 46707L)),
        WordEntity(
            id = 46702, original = "tanker", transliteration = "[ˈtæŋkər]", translation = "танкер",
            definition = "A ship with huge sealed compartments that carry oil, gas or chemicals across oceans.",
            definitionNative = "Судно с большими герметичными отсеками, перевозящее нефть, газ или химикаты через океан.",
            example = "A loaded tanker headed for Rotterdam slipped past the lighthouse just before dawn.",
            exampleNative = "Загруженный tanker, идущий в Роттердам, прошёл маяк перед самым рассветом.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(46701L, 46703L, 46704L, 46705L, 46706L, 46707L)),
        WordEntity(
            id = 46703, original = "yacht", transliteration = "[jɑːt]", translation = "яхта",
            definition = "A slim, smartly built boat used for racing or for leisure trips along the coast.",
            definitionNative = "Изящное, тщательно построенное судно для гонок или прогулок вдоль побережья.",
            example = "A white yacht with red sails crossed the bay just as the sun touched the water.",
            exampleNative = "Белая yacht с красными парусами пересекла залив, едва солнце коснулось воды.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(46701L, 46702L, 46704L, 46705L, 46706L, 46707L)),
        WordEntity(
            id = 46704, original = "sailboat", transliteration = "[ˈseɪlboʊt]", translation = "парусная лодка",
            definition = "A small craft driven across the water by wind caught in cloth stretched on a tall pole.",
            definitionNative = "Небольшое судно, идущее по воде за счёт ветра, пойманного полотном на высокой мачте.",
            example = "We rented a tiny sailboat for the weekend and learned the ropes from a patient instructor.",
            exampleNative = "Мы взяли крохотный sailboat на выходные и учились азам у терпеливого инструктора.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(46701L, 46702L, 46703L, 46705L, 46706L, 46707L)),
        WordEntity(
            id = 46705, original = "tugboat", transliteration = "[ˈtʌɡboʊt]", translation = "буксир",
            definition = "A small, very powerful boat that pushes or pulls large ships through tight harbours.",
            definitionNative = "Маленькое, но очень мощное судно, толкающее или тянущее крупные корабли в тесной гавани.",
            example = "A small tugboat nudged the giant container ship into its berth before the tide turned.",
            exampleNative = "Маленький tugboat подталкивал огромный контейнеровоз к стоянке, пока вода не пошла на убыль.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(46701L, 46702L, 46703L, 46704L, 46706L, 46707L)),
        WordEntity(
            id = 46706, original = "kayak", transliteration = "[ˈkaɪæk]", translation = "каяк",
            definition = "A narrow one-person boat with a closed top that you push along using a double paddle.",
            definitionNative = "Узкая одноместная лодка с закрытым верхом, которую двигают двухлопастным веслом.",
            example = "She slipped her kayak between the rocks and reached the hidden cove before sunset.",
            exampleNative = "Она провела свой kayak между камнями и добралась до укромной бухты до заката.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(46701L, 46702L, 46703L, 46704L, 46705L, 46707L)),
        WordEntity(
            id = 46707, original = "catamaran", transliteration = "[ˌkætəməˈræn]", translation = "катамаран",
            definition = "A boat resting on two slim parallel bodies joined by a deck — fast, stable, hard to flip.",
            definitionNative = "Судно на двух узких параллельных корпусах, соединённых палубой — быстрое, устойчивое, почти не переворачивается.",
            example = "Tourists boarded the catamaran at noon for a three-hour trip along the cliffs.",
            exampleNative = "Туристы поднялись на catamaran в полдень для трёхчасовой прогулки вдоль скал.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(46701L, 46702L, 46703L, 46704L, 46705L, 46706L)),

        // ── transport_maritime_parts (части корабля) ──────────────────────────
        WordEntity(
            id = 46708, original = "hull", transliteration = "[hʌl]", translation = "корпус судна",
            definition = "The main body of a ship — the curved shell that sits in the water and holds everything else.",
            definitionNative = "Главная часть лодки или корабля — изогнутая оболочка, сидящая в воде и держащая всё остальное.",
            example = "Workers scraped barnacles off the hull while the ship rested in dry dock for a week.",
            exampleNative = "Рабочие соскребали ракушки с hull, пока корабль стоял в сухом доке всю неделю.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_parts", fillInBlankExclusions = listOf(46709L, 46710L, 46711L, 46712L, 46713L)),
        WordEntity(
            id = 46709, original = "stern", transliteration = "[stɜːrn]", translation = "корма",
            definition = "The back part of a ship, opposite the pointed front, where the rudder and engines usually sit.",
            definitionNative = "Задняя часть судна, противоположная острому носу; там обычно установлены руль и двигатели.",
            example = "He stood at the stern and watched the long white trail fade into the open sea.",
            exampleNative = "Он стоял на stern и смотрел, как длинный белый след тает в открытом море.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_parts", fillInBlankExclusions = listOf(46708L, 46710L, 46711L, 46712L, 46713L)),
        WordEntity(
            id = 46710, original = "mast", transliteration = "[mæst]", translation = "мачта",
            definition = "A tall vertical pole rising from a ship's deck to carry sails, antennas or flags.",
            definitionNative = "Высокий вертикальный столб, поднимающийся с палубы судна и несущий паруса, антенны или флаги.",
            example = "Lightning struck the tallest mast in the storm and snapped it clean in half.",
            exampleNative = "Молния ударила в самый высокий mast в шторм и переломила его пополам.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_parts", fillInBlankExclusions = listOf(46708L, 46709L, 46711L, 46712L, 46713L)),
        WordEntity(
            id = 46711, original = "sail", transliteration = "[seɪl]", translation = "парус",
            definition = "A large sheet of strong cloth, tied to a tall pole, that catches the wind to push a boat.",
            definitionNative = "Большое полотно из прочной ткани, привязанное к высокому столбу, ловящее ветер для движения лодки.",
            example = "The crew hoisted the main sail and the boat leapt forward into the open bay.",
            exampleNative = "Команда подняла главный sail, и лодка рванулась вперёд в открытый залив.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_parts", fillInBlankExclusions = listOf(46708L, 46709L, 46710L, 46712L, 46713L)),
        WordEntity(
            id = 46712, original = "propeller", transliteration = "[prəˈpelər]", translation = "гребной винт",
            definition = "A set of angled blades that spin underwater to push a boat or submarine forward.",
            definitionNative = "Набор наклонных лопастей, вращающихся под водой и толкающих судно или подлодку вперёд.",
            example = "A drifting rope tangled the propeller and the boat sat helpless until divers freed it.",
            exampleNative = "Дрейфующая верёвка намотала propeller, и лодка стояла беспомощной, пока ныряльщики её не освободили.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_parts", fillInBlankExclusions = listOf(46708L, 46709L, 46710L, 46711L, 46713L)),
        WordEntity(
            id = 46713, original = "porthole", transliteration = "[ˈpɔːrthoʊl]", translation = "иллюминатор",
            definition = "A small round window in the side of a ship that lets in light but keeps out heavy waves.",
            definitionNative = "Маленькое круглое окно в борту судна — пропускает свет, но не пускает внутрь сильные волны.",
            example = "Through the porthole he watched seabirds swoop low over the grey morning water.",
            exampleNative = "Сквозь porthole он смотрел, как морские птицы низко скользят над серой утренней водой.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_parts", fillInBlankExclusions = listOf(46708L, 46709L, 46710L, 46711L, 46712L)),

        // ── transport_maritime_port (порт и инфраструктура) ──────────────────
        WordEntity(
            id = 46714, original = "dock", transliteration = "[dɑːk]", translation = "причал",
            definition = "A built-up edge of water where ships pull alongside so people and cargo can move on or off.",
            definitionNative = "Оборудованный край воды, к которому подходят суда для посадки людей и перегрузки товаров.",
            example = "Crates of fish moved from boats to the dock under a swarm of hungry gulls.",
            exampleNative = "Ящики с рыбой переходили с лодок на dock под тучей голодных чаек.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_port", fillInBlankExclusions = listOf(46715L, 46716L, 46717L, 46718L, 46719L)),
        WordEntity(
            id = 46715, original = "wharf", transliteration = "[wɔːrf]", translation = "пристань",
            definition = "A long flat platform along the shore where ships tie up to load and unload goods.",
            definitionNative = "Длинная плоская площадка у берега, где суда швартуются для погрузки и разгрузки товаров.",
            example = "Old fishermen still mend their nets on the wharf every morning before the boats leave.",
            exampleNative = "Старые рыбаки до сих пор чинят сети на wharf каждое утро перед выходом лодок.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_port", fillInBlankExclusions = listOf(46714L, 46716L, 46717L, 46718L, 46719L)),
        WordEntity(
            id = 46716, original = "lighthouse", transliteration = "[ˈlaɪthaʊs]", translation = "маяк",
            definition = "A tall tower on the coast with a strong revolving lamp that warns ships of rocks at night.",
            definitionNative = "Высокая башня у берега с сильной вращающейся лампой, предупреждающей суда о скалах ночью.",
            example = "The old lighthouse on the cliff has guided ships safely past these rocks for two centuries.",
            exampleNative = "Старый lighthouse на утёсе уже два века уводит суда от этих скал.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_port", fillInBlankExclusions = listOf(46714L, 46715L, 46717L, 46718L, 46719L)),
        WordEntity(
            id = 46717, original = "marina", transliteration = "[məˈriːnə]", translation = "марина",
            definition = "A small, sheltered harbour built mostly for yachts and other private leisure boats.",
            definitionNative = "Маленькая защищённая гавань, построенная в основном для яхт и других частных прогулочных лодок.",
            example = "On Saturday the marina is full of people scrubbing decks and polishing brass fittings.",
            exampleNative = "В субботу marina полна людей, которые драят палубы и натирают латунные детали.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_port", fillInBlankExclusions = listOf(46714L, 46715L, 46716L, 46718L, 46719L)),
        WordEntity(
            id = 46718, original = "shipyard", transliteration = "[ˈʃɪpjɑːrd]", translation = "верфь",
            definition = "A big industrial site by deep water where new vessels are built and old ones repaired.",
            definitionNative = "Крупная промышленная площадка у глубокой воды, где строят новые суда и ремонтируют старые.",
            example = "His grandfather welded steel plates at the Belfast shipyard for nearly forty years.",
            exampleNative = "Его дед варил стальные листы на белфастской shipyard почти сорок лет.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_port", fillInBlankExclusions = listOf(46714L, 46715L, 46716L, 46717L, 46719L)),
        WordEntity(
            id = 46719, original = "buoy", transliteration = "[ˈbuːi]", translation = "буй",
            definition = "A floating marker fixed in place to warn boats of shallow water or mark a safe channel.",
            definitionNative = "Плавучий маркер, закреплённый на месте; предупреждает лодки о мелководье или отмечает безопасный проход.",
            example = "A red buoy bobbed near the rocks, marking the line that small craft must not cross.",
            exampleNative = "Красный buoy качался возле скал, отмечая линию, за которую мелким судам нельзя.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_port", fillInBlankExclusions = listOf(46714L, 46715L, 46716L, 46717L, 46718L)),

        // ── transport_maritime_navigation (навигация и плавание) ──────────────
        WordEntity(
            id = 46720, original = "navigation", transliteration = "[ˌnævɪˈɡeɪʃən]", translation = "навигация",
            definition = "The skill of plotting a safe route at sea using charts, instruments, stars or satellites.",
            definitionNative = "Умение прокладывать безопасный путь в море по картам, приборам, звёздам или спутникам.",
            example = "Modern navigation relies on satellites, but every captain still learns the old paper charts.",
            exampleNative = "Современная navigation опирается на спутники, но каждый капитан всё ещё учит старые бумажные карты.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_navigation", fillInBlankExclusions = listOf(46721L, 46722L, 46723L)),
        WordEntity(
            id = 46721, original = "knot", transliteration = "[nɑːt]", translation = "узел (скорость)",
            definition = "A sea unit of speed equal to one nautical mile per hour, used by ships and aircraft.",
            definitionNative = "Морская единица скорости, равная одной морской миле в час; используется судами и самолётами.",
            example = "The freighter held a steady twelve knot pace all night across the calm dark water.",
            exampleNative = "Грузовоз держал ровный темп двенадцать knot всю ночь по спокойной тёмной воде.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_navigation", fillInBlankExclusions = listOf(46720L, 46722L, 46723L)),
        WordEntity(
            id = 46722, original = "mooring", transliteration = "[ˈmʊrɪŋ]", translation = "стоянка на швартовых",
            definition = "A fixed spot in a harbour where a boat is tied to a ring, post or heavy underwater weight.",
            definitionNative = "Закреплённое место в гавани, где лодку привязывают к кольцу, столбу или тяжёлому подводному грузу.",
            example = "He paid for a winter mooring near the breakwater so storms could not drag the boat away.",
            exampleNative = "Он оплатил зимнюю mooring у волнолома, чтобы штормы не утащили лодку.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_navigation", fillInBlankExclusions = listOf(46714L, 46717L, 46720L, 46721L, 46723L)),
        WordEntity(
            id = 46723, original = "fleet", transliteration = "[fliːt]", translation = "флот",
            definition = "A group of ships that travel and operate together — for trade, fishing or naval power.",
            definitionNative = "Группа судов, действующих и идущих вместе — для торговли, рыболовства или военных задач.",
            example = "The fishing fleet left harbour before dawn and spread out across the cold grey bay.",
            exampleNative = "Рыболовецкий fleet вышел из гавани до рассвета и рассыпался по холодному серому заливу.",
            rarity = "UNCOMMON", setId = 467, languagePair = "en-ru", pos = "noun",
            semanticGroup = "transport_maritime_navigation", fillInBlankExclusions = listOf(46720L, 46721L, 46722L)),
        WordEntity(
            id = 46724, original = "nautical", transliteration = "[ˈnɔːtɪkəl]", translation = "морской",
            definition = "Tied to ships, sailing and life at sea — used for distance, charts, terms and traditions.",
            definitionNative = "Связанный с судами, парусным делом и жизнью в море — про расстояния, карты, термины и традиции.",
            example = "He bought a nautical chart of the strait and traced a safe route around the reefs.",
            exampleNative = "Он купил nautical карту пролива и наметил безопасный путь вокруг рифов.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "adjective",
            semanticGroup = "transport_maritime_navigation", fillInBlankExclusions = listOf(46725L)),
        WordEntity(
            id = 46725, original = "maritime", transliteration = "[ˈmærɪtaɪm]", translation = "морской (отрасль)",
            definition = "Tied to the sea as a place of work and law — shipping, ports, coastlines and the navy.",
            definitionNative = "Связанный с морем как сферой работы и права — судоходство, порты, побережья и военный флот.",
            example = "International maritime law governs every cargo crossing the line between two countries' waters.",
            exampleNative = "Международное maritime право регулирует каждый груз, пересекающий границу между водами двух стран.",
            rarity = "RARE", setId = 467, languagePair = "en-ru", pos = "adjective",
            semanticGroup = "transport_maritime_navigation", fillInBlankExclusions = listOf(46724L)),
    )
}
