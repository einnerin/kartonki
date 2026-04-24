package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Транспорт, Level 5 (носитель/архаика).
 * Set 317 — старинные кареты, парусные суда XVIII–XIX вв.,
 * исторические железнодорожные термины и архаичные части корабля.
 *
 * Rarity strategy: pure LEGENDARY (C2+) — все 25 слов либо исторические,
 * либо узкоспециализированные термины, которые носитель встречает разве
 * что в Patrick O'Brian, у Конрада или в музеях.
 *
 * Не пересекается с уже существующими сетами Транспорт:
 *   set 19  (L1 базовые: bus, train, car, ferry…)
 *   set 228 (L2 базовая транспортная лексика)
 *   set 229 (L3 логистика: cargo, freight, manifest…)
 *   set 252 (L2 аэропорт: gate, runway, boarding pass…)
 *   set 309 (L4 профессиональный: fuselage, keel, pantograph,
 *           viaduct, embankment, abutment, turnout…)
 *
 * SemanticGroups (5 × 5 = optimum 3-8):
 *   transport_archaic_carriages    — brougham, barouche, landau, phaeton, cabriolet
 *   transport_horse_drawn_light    — hansom, surrey, gig, sulky, droshky
 *   transport_archaic_sail         — schooner, clipper, galleon, brigantine, barque
 *   transport_archaic_rail         — wagonway, footplate, funicular, handcar, trestle
 *   transport_ship_parts_archaic   — mizzenmast, bowsprit, forecastle, binnacle, capstan
 *
 * Word IDs: 31701..31725 (setId × 100 + position).
 * NOT ALL_EXCLUSIVE — слова можно встретить в разных колодах.
 */
object WordDataEnglishTransportL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 317,
            name = "Транспорт",
            description = "Архаичный транспорт и специализированные термины",
            orderIndex = 137,
            languagePair = "en-ru",
            topic = "Транспорт",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Архаичные кареты (4-колёсные) ──────────────────────────────────
        WordEntity(id = 31701, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "brougham", transliteration = "[ˈbruːəm]", translation = "брум (закрытая карета)",
            definition = "A small closed four-wheeled coach for one horse, common in Victorian London.",
            definitionNative = "Небольшая закрытая четырёхколёсная коляска на одну лошадь — викторианский Лондон.",
            example = "A polished black brougham waited outside the duke's townhouse.",
            exampleNative = "Сверкающий чёрный brougham ждал у крыльца особняка герцога.",
            pos = "noun", semanticGroup = "transport_archaic_carriages",
            fillInBlankExclusions = listOf(31702L, 31703L, 31704L, 31705L)),

        WordEntity(id = 31702, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "barouche", transliteration = "[bəˈruːʃ]", translation = "баруш (лёгкая открытая коляска)",
            definition = "An elegant open four-wheeled coach with a folding hood at the back.",
            definitionNative = "Изящный открытый четырёхколёсный экипаж с откидным верхом сзади.",
            example = "Lady Catherine arrived at the ball in a bright yellow barouche.",
            exampleNative = "Леди Кэтрин прибыла на бал в ярко-жёлтом barouche.",
            pos = "noun", semanticGroup = "transport_archaic_carriages",
            fillInBlankExclusions = listOf(31701L, 31703L, 31704L, 31705L)),

        WordEntity(id = 31703, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "landau", transliteration = "[ˈlændɔː]", translation = "ландо (карета с двумя верхами)",
            definition = "A grand four-wheeled coach with two folding tops that meet in the middle.",
            definitionNative = "Парадная четырёхколёсная коляска с двумя складными верхами, сходящимися посередине.",
            example = "The royal landau rolled slowly through the cheering crowd today.",
            exampleNative = "Королевский landau медленно катил сквозь толпу зевак.",
            pos = "noun", semanticGroup = "transport_archaic_carriages",
            fillInBlankExclusions = listOf(31701L, 31702L, 31704L, 31705L)),

        WordEntity(id = 31704, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "phaeton", transliteration = "[ˈfeɪtən]", translation = "фаэтон (открытая коляска)",
            definition = "A light open four-wheeled carriage favoured by sporting young men of fashion.",
            definitionNative = "Лёгкий открытый четырёхколёсный экипаж — любимец молодых щёголей-наездников.",
            example = "Reckless dandies raced their phaeton along the dusty country lane.",
            exampleNative = "Беспечные щёголи гнали phaeton по пыльной просёлочной дороге.",
            pos = "noun", semanticGroup = "transport_archaic_carriages",
            fillInBlankExclusions = listOf(31701L, 31702L, 31703L, 31705L)),

        WordEntity(id = 31705, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cabriolet", transliteration = "[ˌkæbrɪəˈleɪ]", translation = "кабриолет (двухколёсная коляска)",
            definition = "A light two-wheeled hooded carriage drawn by a single horse, popular before motor cars.",
            definitionNative = "Лёгкий двухколёсный экипаж с откидным верхом и одной лошадью, ходовой до моторных времён.",
            example = "He hailed a cabriolet to whisk her away from the rainy square.",
            exampleNative = "Он подозвал cabriolet, чтобы увезти её с мокрой от дождя площади.",
            pos = "noun", semanticGroup = "transport_archaic_carriages",
            fillInBlankExclusions = listOf(31701L, 31702L, 31703L, 31704L)),

        // ── Лёгкие конные экипажи / наёмные ────────────────────────────────
        WordEntity(id = 31706, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hansom", transliteration = "[ˈhænsəm]", translation = "хэнсом (двухколёсный кэб)",
            definition = "A two-wheeled cab where the driver sits up high behind the passengers.",
            definitionNative = "Двухколёсный наёмный экипаж — кучер сидит высоко позади седоков.",
            example = "Sherlock Holmes leapt into a passing hansom and shouted the address.",
            exampleNative = "Шерлок Холмс впрыгнул в проходящий hansom и выкрикнул адрес.",
            pos = "noun", semanticGroup = "transport_horse_drawn_light",
            fillInBlankExclusions = listOf(31707L, 31708L, 31709L, 31710L)),

        WordEntity(id = 31707, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "surrey", transliteration = "[ˈsʌri]", translation = "сюрри (коляска с балдахином)",
            definition = "A four-wheeled American carriage with two seats and a fringed canopy on top.",
            definitionNative = "Американская четырёхколёсная коляска с двумя сиденьями и тентом с бахромой.",
            example = "The farmer hitched his pony to the old surrey for Sunday outings.",
            exampleNative = "Фермер запрягал пони в старый surrey по воскресеньям.",
            pos = "noun", semanticGroup = "transport_horse_drawn_light",
            fillInBlankExclusions = listOf(31706L, 31708L, 31709L, 31710L)),

        WordEntity(id = 31708, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gig", transliteration = "[ɡɪɡ]", translation = "гиг (лёгкая двуколка)",
            definition = "A simple two-wheeled vehicle pulled by one horse, seating just one or two people.",
            definitionNative = "Простая двухколёсная повозка на одну лошадь, рассчитанная на одного-двух седоков.",
            example = "Mr. Bennet drove his daughters to town in a battered country gig.",
            exampleNative = "Мистер Беннет вёз дочерей в город в потрёпанном деревенском gig.",
            pos = "noun", semanticGroup = "transport_horse_drawn_light",
            fillInBlankExclusions = listOf(31706L, 31707L, 31709L, 31710L)),

        WordEntity(id = 31709, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sulky", transliteration = "[ˈsʌlki]", translation = "сулки (рысистая беговая двуколка)",
            definition = "A very light two-wheeled racing cart for one driver in harness racing.",
            definitionNative = "Крайне лёгкая двухколёсная беговая повозка на одного — для рысистых бегов.",
            example = "The trotter flew round the track pulling a featherlight sulky.",
            exampleNative = "Рысак летел по дорожке, влача за собой почти невесомый sulky.",
            pos = "noun", semanticGroup = "transport_horse_drawn_light",
            fillInBlankExclusions = listOf(31706L, 31707L, 31708L, 31710L)),

        WordEntity(id = 31710, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "droshky", transliteration = "[ˈdrɒʃki]", translation = "дрожки (русская повозка)",
            definition = "A low Russian open carriage on which riders sit astride a long bench.",
            definitionNative = "Низкая русская открытая повозка — седоки сидят верхом на длинной лавке.",
            example = "A muddy droshky rattled past us on the way to the dacha.",
            exampleNative = "Грязный droshky прогрохотал мимо нас по дороге к даче.",
            pos = "noun", semanticGroup = "transport_horse_drawn_light",
            fillInBlankExclusions = listOf(31706L, 31707L, 31708L, 31709L)),

        // ── Архаичные парусные суда ────────────────────────────────────────
        WordEntity(id = 31711, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "schooner", transliteration = "[ˈskuːnər]", translation = "шхуна",
            definition = "A sailing vessel with two or more masts and fore-and-aft rigged sails.",
            definitionNative = "Парусное судно с двумя или более мачтами и косыми парусами.",
            example = "A weather-beaten schooner limped into the harbour at dawn.",
            exampleNative = "Потрёпанная штормом schooner еле дотянула до гавани к рассвету.",
            pos = "noun", semanticGroup = "transport_archaic_sail",
            fillInBlankExclusions = listOf(31712L, 31713L, 31714L, 31715L)),

        WordEntity(id = 31712, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "clipper", transliteration = "[ˈklɪpər]", translation = "клипер (быстроходный парусник)",
            definition = "A tall, very fast sailing ship of the nineteenth century, used for tea and wool runs.",
            definitionNative = "Высокий стремительный парусник XIX века — гонял чай и шерсть из колоний.",
            example = "The proud old clipper held the speed record from China for years.",
            exampleNative = "Гордый старый clipper годами держал рекорд скорости из Китая.",
            pos = "noun", semanticGroup = "transport_archaic_sail",
            fillInBlankExclusions = listOf(31711L, 31713L, 31714L, 31715L)),

        WordEntity(id = 31713, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "galleon", transliteration = "[ˈɡæliən]", translation = "галеон",
            definition = "A heavy three-masted Spanish sailing warship used to carry treasure from the New World.",
            definitionNative = "Тяжёлый трёхмачтовый испанский военный парусник — возил серебро из Нового Света.",
            example = "Pirates lay in wait for any Spanish galleon laden with silver.",
            exampleNative = "Пираты караулили испанский galleon, гружённый серебром.",
            pos = "noun", semanticGroup = "transport_archaic_sail",
            fillInBlankExclusions = listOf(31711L, 31712L, 31714L, 31715L)),

        WordEntity(id = 31714, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "brigantine", transliteration = "[ˈbrɪɡəntiːn]", translation = "бригантина",
            definition = "A two-masted vessel with one mast carrying square sails and the other fore-and-aft rigged.",
            definitionNative = "Двухмачтовое судно — на одной мачте прямые паруса, на другой косые.",
            example = "A black brigantine slipped quietly through the night-time mist.",
            exampleNative = "Чёрная brigantine бесшумно скользила в ночном тумане.",
            pos = "noun", semanticGroup = "transport_archaic_sail",
            fillInBlankExclusions = listOf(31711L, 31712L, 31713L, 31715L)),

        WordEntity(id = 31715, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "barque", transliteration = "[bɑːk]", translation = "барк (трёхмачтовый парусник)",
            definition = "A three-masted ship whose rear mast carries only fore-and-aft sails.",
            definitionNative = "Трёхмачтовый парусник — на задней мачте только косые паруса.",
            example = "Conrad sailed as second mate aboard a coal-carrying Australian barque.",
            exampleNative = "Конрад ходил вторым помощником на австралийском угольном barque.",
            pos = "noun", semanticGroup = "transport_archaic_sail",
            fillInBlankExclusions = listOf(31711L, 31712L, 31713L, 31714L)),

        // ── Старая железная дорога ─────────────────────────────────────────
        WordEntity(id = 31716, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "wagonway", transliteration = "[ˈwæɡənweɪ]", translation = "вагонетная дорога (предтеча ж/д)",
            definition = "An early track of wooden or iron rails for horse-drawn coal carts in the mines.",
            definitionNative = "Ранний путь из деревянных или железных рельсов — лошади тянули по нему углевозки.",
            example = "Coal miners rolled their carts along a creaking wooden wagonway.",
            exampleNative = "Углекопы катили вагонетки по скрипучему деревянному wagonway.",
            pos = "noun", semanticGroup = "transport_archaic_rail",
            fillInBlankExclusions = listOf(31717L, 31718L, 31719L, 31720L)),

        WordEntity(id = 31717, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "footplate", transliteration = "[ˈfʊtpleɪt]", translation = "площадка машиниста (паровоза)",
            definition = "The small open platform at the rear of a steam engine where driver and fireman stand.",
            definitionNative = "Небольшая открытая площадка в хвосте паровоза, где стоят машинист и кочегар.",
            example = "Soot covered the driver's hands and face on the swaying footplate.",
            exampleNative = "Машинист стоял весь в саже на качающейся footplate.",
            pos = "noun", semanticGroup = "transport_archaic_rail",
            fillInBlankExclusions = listOf(31716L, 31718L, 31719L, 31720L)),

        WordEntity(id = 31718, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "funicular", transliteration = "[fjuːˈnɪkjələr]", translation = "фуникулёр (канатная ж/д)",
            definition = "A steep mountain railway where two cars on a cable balance each other on the slope.",
            definitionNative = "Крутая горная дорога: два вагончика на тросе уравновешивают друг друга на склоне.",
            example = "Tourists crowded the rickety funicular up the side of Mount Vesuvius.",
            exampleNative = "Туристы набились в скрипучий funicular на склоне Везувия.",
            pos = "noun", semanticGroup = "transport_archaic_rail",
            fillInBlankExclusions = listOf(31716L, 31717L, 31719L, 31720L)),

        WordEntity(id = 31719, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "handcar", transliteration = "[ˈhændkɑːr]", translation = "ручная дрезина",
            definition = "A small flat railway car powered by pumping a long lever up and down by hand.",
            definitionNative = "Маленькая плоская повозка по рельсам — едет, пока качаешь рычаг руками вверх-вниз.",
            example = "Two workers pumped the handcar slowly along the deserted branch line.",
            exampleNative = "Двое путейцев медленно качали handcar по заброшенной ветке.",
            pos = "noun", semanticGroup = "transport_archaic_rail",
            fillInBlankExclusions = listOf(31716L, 31717L, 31718L, 31720L)),

        WordEntity(id = 31720, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "trestle", transliteration = "[ˈtresəl]", translation = "трестель (деревянный ж/д мост)",
            definition = "A skeleton bridge of wooden frames that carries a railway over a gully or stream.",
            definitionNative = "Сквозной деревянный мост из решётчатых опор — несёт ж/д через овраг или ручей.",
            example = "The old timber trestle groaned under the weight of the freight train.",
            exampleNative = "Старый деревянный trestle стонал под весом товарного состава.",
            pos = "noun", semanticGroup = "transport_archaic_rail",
            fillInBlankExclusions = listOf(31716L, 31717L, 31718L, 31719L)),

        // ── Архаичные части парусника ──────────────────────────────────────
        WordEntity(id = 31721, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mizzenmast", transliteration = "[ˈmɪzənmɑːst]", translation = "бизань-мачта",
            definition = "The third and shortest mast at the back of a three-masted sailing ship.",
            definitionNative = "Третья и самая короткая мачта в корме трёхмачтового парусника.",
            example = "A stray cannonball clipped the mizzenmast clean off at the deck.",
            exampleNative = "Шальное ядро срезало mizzenmast вровень с палубой.",
            pos = "noun", semanticGroup = "transport_ship_parts_archaic",
            fillInBlankExclusions = listOf(31722L, 31723L, 31724L, 31725L)),

        WordEntity(id = 31722, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bowsprit", transliteration = "[ˈbaʊsprɪt]", translation = "бушприт",
            definition = "A long pole sticking out forward from the front of a sailing ship to hold extra sails.",
            definitionNative = "Длинный шест, торчащий вперёд из носа парусника — на нём держат носовые паруса.",
            example = "A figurehead of a roaring lion stared out beneath the bowsprit.",
            exampleNative = "Под bowsprit вглядывалась вперёд фигура рычащего льва.",
            pos = "noun", semanticGroup = "transport_ship_parts_archaic",
            fillInBlankExclusions = listOf(31721L, 31723L, 31724L, 31725L)),

        WordEntity(id = 31723, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "forecastle", transliteration = "[ˈfoʊksəl]", translation = "полубак (нос корабля)",
            definition = "The raised deck at the front of a sailing ship where ordinary sailors sleep and eat.",
            definitionNative = "Приподнятая палуба в носу парусника — там спят и едят простые матросы.",
            example = "The crew gathered on the forecastle to listen to the captain's orders.",
            exampleNative = "Команда собралась на forecastle послушать приказы капитана.",
            pos = "noun", semanticGroup = "transport_ship_parts_archaic",
            fillInBlankExclusions = listOf(31721L, 31722L, 31724L, 31725L)),

        WordEntity(id = 31724, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "binnacle", transliteration = "[ˈbɪnəkəl]", translation = "нактоуз (компасный шкаф)",
            definition = "A wooden case near the helm of a ship that holds the magnetic compass.",
            definitionNative = "Деревянный шкафчик у штурвала, в котором стоит магнитный компас.",
            example = "The helmsman glanced at the binnacle to keep the heading true.",
            exampleNative = "Рулевой косился на binnacle, чтобы держать курс ровно.",
            pos = "noun", semanticGroup = "transport_ship_parts_archaic",
            fillInBlankExclusions = listOf(31721L, 31722L, 31723L, 31725L)),

        WordEntity(id = 31725, setId = 317, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "capstan", transliteration = "[ˈkæpstən]", translation = "шпиль (барабан для подъёма якоря)",
            definition = "A vertical drum on deck that sailors push around to haul up the heavy anchor.",
            definitionNative = "Вертикальный барабан на палубе — матросы ходят вокруг и тянут якорь наверх.",
            example = "Eight sailors leaned hard on the capstan to raise the dripping anchor.",
            exampleNative = "Восемь моряков навалились на capstan, поднимая мокрый якорь.",
            pos = "noun", semanticGroup = "transport_ship_parts_archaic",
            fillInBlankExclusions = listOf(31721L, 31722L, 31723L, 31724L)),
    )
}
