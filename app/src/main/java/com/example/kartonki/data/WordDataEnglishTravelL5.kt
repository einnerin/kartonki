package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Путешествия (level 5, носитель языка).
 *
 * Set 337: «Путешествия: носитель языка» — литературная и архаичная
 * лексика странствий: высокие глаголы пути, типы странников, старинные
 * средства передвижения и редкие географические концепции (C2+).
 *
 * Распределение редкости: 23 LEGENDARY + 2 EPIC — два смежных уровня шкалы.
 *
 * Дополняет уже существующие сеты темы «Путешествия»:
 *   - Set 20  (WordDataEnglish.kt)            — L1 COMMON/UNCOMMON (туризм, поездки).
 *   - Set 261 (WordDataEnglishBatch6.kt)      — L2 COMMON/UNCOMMON (кемпинг, поход).
 *   - Set 335 (WordDataEnglishTravelL3.kt)    — L3 RARE (углублённая туристическая лексика).
 *   - Set 336 (WordDataEnglishTravelL4.kt)    — L4 RARE/EPIC (туриндустрия, сервис, литературные обороты).
 *
 * Слова setId=337 не пересекаются ни с одним из этих наборов и не
 * дублируют L5-Повседневная (set 329, где уже взяты `peregrinate, wend,
 * meander, gallivant`) — здесь использованы другие корни.
 *
 * SemanticGroups (5 × 5):
 *   travel_journeying_acts    — traverse, errantry, hegira, junket, circumnavigation
 *   travel_wanderers          — wayfaring, peripatetic, itinerant, vagabond, gadabout
 *   travel_old_conveyance     — caravanserai, postilion, equipage, palanquin, dromedary
 *   travel_far_lands          — hinterland, antipodes, badlands, environs, vicinage
 *   travel_old_dwellings      — hostelry, wayside, byway, posada, tarry
 *
 * Word IDs: 33701..33725 (setId × 100 + position).
 */
object WordDataEnglishTravelL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 337, name = "Путешествия",
            description = "Литературная и архаичная лексика путешествий: романтика странствий, географические редкости, поэтические образы",
            languagePair = "en-ru",
            topic = "Путешествия", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── travel_journeying_acts (5) ────────────────────────────────────

        WordEntity(id = 33701, setId = 337, languagePair = "en-ru", rarity = "EPIC",
            original = "traverse", transliteration = "[trəˈvɜːrs]", translation = "пересекать, преодолевать (пространство)",
            definition = "To move across a wide land or area — usually with effort and time.",
            definitionNative = "Двигаться через обширную область — обычно с трудом и неспешно.",
            example = "The caravan would traverse the burning desert by night to spare the camels.",
            exampleNative = "Караван будет traverse раскалённую пустыню ночью, чтобы поберечь верблюдов.",
            pos = "verb", semanticGroup = "travel_journeying_acts",
            fillInBlankExclusions = listOf(33702L, 33703L, 33704L, 33705L)),

        WordEntity(id = 33702, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "errantry", transliteration = "[ˈerəntri]", translation = "странствование (рыцарское, в поисках славы)",
            definition = "Old life of a knight roaming the world looking for noble deeds to do.",
            definitionNative = "Старая жизнь рыцаря, скитающегося по миру в поисках благородных дел.",
            example = "Don Quixote took up errantry with a tilted helmet and a thin horse.",
            exampleNative = "Дон Кихот пустился в errantry с кривым шлемом и тощей лошадью.",
            pos = "noun", semanticGroup = "travel_journeying_acts",
            fillInBlankExclusions = listOf(33701L, 33703L, 33704L, 33705L)),

        WordEntity(id = 33703, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hegira", transliteration = "[hɪˈdʒaɪrə]", translation = "хиджра, исход (в дальние края)",
            definition = "A long flight away from one's home to a safer or holier place.",
            definitionNative = "Долгий уход из родного места в более безопасный или святой край.",
            example = "Their hegira from the famine-struck plains lasted nearly six months.",
            exampleNative = "Их hegira с голодающих равнин длилась почти полгода.",
            pos = "noun", semanticGroup = "travel_journeying_acts",
            fillInBlankExclusions = listOf(33701L, 33702L, 33704L, 33705L)),

        WordEntity(id = 33704, setId = 337, languagePair = "en-ru", rarity = "EPIC",
            original = "junket", transliteration = "[ˈdʒʌŋkɪt]", translation = "увеселительная поездка (часто за чужой счёт)",
            definition = "A pleasure trip — often paid for by someone else, like a sponsor.",
            definitionNative = "Развлекательная поездка — часто оплаченная другим, например спонсором.",
            example = "The mayor went on a junket to a sunny island and called it research.",
            exampleNative = "Мэр отправился в junket на солнечный остров, назвав это командировкой.",
            pos = "noun", semanticGroup = "travel_journeying_acts",
            fillInBlankExclusions = listOf(33701L, 33702L, 33703L, 33705L)),

        WordEntity(id = 33705, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "circumnavigation", transliteration = "[ˌsɜːrkəmnævɪˈɡeɪʃən]", translation = "кругосветное плавание",
            definition = "Sailing all the way around the entire globe and back to the start.",
            definitionNative = "Морской путь вокруг всего земного шара с возвращением в точку отправления.",
            example = "Magellan's crew finished the first circumnavigation in fifteen-twenty-two.",
            exampleNative = "Команда Магеллана завершила первую circumnavigation в тысяча пятьсот двадцать втором.",
            pos = "noun", semanticGroup = "travel_journeying_acts",
            fillInBlankExclusions = listOf(33701L, 33702L, 33703L, 33704L)),

        // ── travel_wanderers (5) ──────────────────────────────────────────

        WordEntity(id = 33706, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "wayfaring", transliteration = "[ˈweɪˌfeərɪŋ]", translation = "странствующий (пешком, по дорогам)",
            definition = "Travelling on foot from one place to another — old word for road life.",
            definitionNative = "Идущий пешком из края в край — старое слово о жизни на пути.",
            example = "A wayfaring stranger asked the farmer for a bowl of warm soup.",
            exampleNative = "Wayfaring чужак попросил у фермера миску горячего супа.",
            pos = "adjective", semanticGroup = "travel_wanderers",
            fillInBlankExclusions = listOf(33707L, 33708L, 33709L, 33710L)),

        WordEntity(id = 33707, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "peripatetic", transliteration = "[ˌperɪpəˈtetɪk]", translation = "переходящий с места на место (по работе)",
            definition = "Moving often from one town to another for work — never settled long.",
            definitionNative = "Часто переезжающий из города в город по работе — нигде не оседающий.",
            example = "A peripatetic violin teacher visited four schools across the county.",
            exampleNative = "Peripatetic учитель скрипки объезжал четыре школы по всему графству.",
            pos = "adjective", semanticGroup = "travel_wanderers",
            fillInBlankExclusions = listOf(33706L, 33708L, 33709L, 33710L)),

        WordEntity(id = 33708, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "itinerant", transliteration = "[aɪˈtɪnərənt]", translation = "странствующий (бродячий рабочий, торговец)",
            definition = "Moving around for work — like an old preacher or a roving tinker.",
            definitionNative = "Перемещающийся ради заработка — как старый проповедник или бродячий лудильщик.",
            example = "An itinerant judge rode the circuit, holding court in three small towns.",
            exampleNative = "Itinerant судья объезжал округу, ведя заседания в трёх маленьких городках.",
            pos = "adjective", semanticGroup = "travel_wanderers",
            fillInBlankExclusions = listOf(33706L, 33707L, 33709L, 33710L)),

        WordEntity(id = 33709, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "vagabond", transliteration = "[ˈvæɡəbɒnd]", translation = "бродяга (романтический, без дома)",
            definition = "A person who roams from place to place with no fixed home or trade.",
            definitionNative = "Человек, скитающийся по миру без постоянного дома и ремесла.",
            example = "The old vagabond slept under bridges and sang for coins each evening.",
            exampleNative = "Старый vagabond ночевал под мостами и пел за монеты каждый вечер.",
            pos = "noun", semanticGroup = "travel_wanderers",
            fillInBlankExclusions = listOf(33706L, 33707L, 33708L, 33710L)),

        WordEntity(id = 33710, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gadabout", transliteration = "[ˈɡædəbaʊt]", translation = "праздный путешественник, любитель мотаться",
            definition = "A person who keeps going to many places just for fun — restless and idle.",
            definitionNative = "Человек, без устали мотающийся по разным местам ради развлечений.",
            example = "Aunt Pearl was a famous gadabout — never home two weeks in a row.",
            exampleNative = "Тётя Перл слыла знатной gadabout — дома не сидела и пары недель.",
            pos = "noun", semanticGroup = "travel_wanderers",
            fillInBlankExclusions = listOf(33706L, 33707L, 33708L, 33709L)),

        // ── travel_old_conveyance (5) ─────────────────────────────────────

        WordEntity(id = 33711, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "caravanserai", transliteration = "[ˌkærəˈvænsəraɪ]", translation = "караван-сарай (постоялый двор для караванов)",
            definition = "An old walled inn on the silk road where merchants and camels rested.",
            definitionNative = "Старинный обнесённый стенами двор на шёлковом пути для купцов и верблюдов.",
            example = "The travellers reached a caravanserai at dusk and watered their tired beasts.",
            exampleNative = "Путники достигли caravanserai на закате и напоили усталых животных.",
            pos = "noun", semanticGroup = "travel_old_conveyance",
            fillInBlankExclusions = listOf(33712L, 33713L, 33714L, 33715L)),

        WordEntity(id = 33712, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "postilion", transliteration = "[poʊˈstɪljən]", translation = "форейтор (всадник на передней лошади упряжки)",
            definition = "A rider on the front horse of a coach — guides the team along the road.",
            definitionNative = "Всадник на передней лошади кареты — направляет упряжку по дороге.",
            example = "The postilion blew a sharp note on his horn as the gates swung open.",
            exampleNative = "Postilion протрубил в свой рожок, когда ворота распахнулись.",
            pos = "noun", semanticGroup = "travel_old_conveyance",
            fillInBlankExclusions = listOf(33711L, 33713L, 33714L, 33715L)),

        WordEntity(id = 33713, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "equipage", transliteration = "[ˈekwɪpɪdʒ]", translation = "выезд (карета с лошадьми и слугами)",
            definition = "An old grand turn-out for travel — coach, horses and serving men together.",
            definitionNative = "Старинный пышный набор для дороги — карета, лошади и сопровождающая прислуга.",
            example = "The countess arrived in a fine equipage with two footmen at the back.",
            exampleNative = "Графиня прибыла в роскошном equipage с двумя лакеями на запятках.",
            pos = "noun", semanticGroup = "travel_old_conveyance",
            fillInBlankExclusions = listOf(33711L, 33712L, 33714L, 33715L)),

        WordEntity(id = 33714, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "palanquin", transliteration = "[ˌpælənˈkiːn]", translation = "паланкин (носилки с креслом)",
            definition = "A covered chair for one person, carried on poles by four bearers.",
            definitionNative = "Закрытое кресло на двух шестах, которое несут четыре носильщика.",
            example = "The princess was carried through the bazaar in a silk-curtained palanquin.",
            exampleNative = "Принцессу несли через базар в palanquin с шёлковыми занавесями.",
            pos = "noun", semanticGroup = "travel_old_conveyance",
            fillInBlankExclusions = listOf(33711L, 33712L, 33713L, 33715L)),

        WordEntity(id = 33715, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dromedary", transliteration = "[ˈdrɒmədəri]", translation = "дромадер, одногорбый верблюд",
            definition = "A tall single-humped beast of the hot deserts — long-legged and swift.",
            definitionNative = "Высокое животное жарких пустынь с одним горбом — длинноногое и быстрое.",
            example = "A lone dromedary trotted ahead of the caravan across the dunes.",
            exampleNative = "Одинокий dromedary бежал впереди каравана по дюнам.",
            pos = "noun", semanticGroup = "travel_old_conveyance",
            fillInBlankExclusions = listOf(33711L, 33712L, 33713L, 33714L)),

        // ── travel_far_lands (5) ──────────────────────────────────────────

        WordEntity(id = 33716, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hinterland", transliteration = "[ˈhɪntərlænd]", translation = "глубинка, отдалённые внутренние земли",
            definition = "The remote inland regions far from the coast or main cities — wild and quiet.",
            definitionNative = "Дальние внутренние области вдали от побережья и городов — глухие и тихие.",
            example = "Beyond the port lay a vast hinterland of forests and silent farms.",
            exampleNative = "За портом простиралась обширная hinterland лесов и тихих ферм.",
            pos = "noun", semanticGroup = "travel_far_lands",
            fillInBlankExclusions = listOf(33717L, 33718L, 33719L, 33720L)),

        WordEntity(id = 33717, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "antipodes", transliteration = "[ænˈtɪpədiːz]", translation = "антиподы, противоположный край земли",
            definition = "The lands lying directly opposite on the globe — the far side of the world.",
            definitionNative = "Земли, лежащие на противоположной точке земного шара — другой конец мира.",
            example = "Sailing from London to the antipodes once took half a year or more.",
            exampleNative = "Плавание из Лондона до antipodes когда-то занимало полгода или больше.",
            pos = "noun", semanticGroup = "travel_far_lands",
            fillInBlankExclusions = listOf(33716L, 33718L, 33719L, 33720L)),

        WordEntity(id = 33718, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "badlands", transliteration = "[ˈbædlændz]", translation = "бэдленды, бесплодная изрезанная местность",
            definition = "A bare, broken landscape of dry gullies and steep clay ridges — hard to cross.",
            definitionNative = "Голая, изрезанная местность из сухих оврагов и крутых глиняных гребней.",
            example = "Their wagon trail wound for days through the rust-red badlands of Dakota.",
            exampleNative = "Их повозка много дней петляла по ржаво-красным badlands Дакоты.",
            pos = "noun", semanticGroup = "travel_far_lands",
            fillInBlankExclusions = listOf(33716L, 33717L, 33719L, 33720L)),

        WordEntity(id = 33719, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "environs", transliteration = "[ɪnˈvaɪrənz]", translation = "окрестности (вокруг города или места)",
            definition = "The area around a town or place — the lands and roads just outside it.",
            definitionNative = "Местность вокруг города или иного места — земли и дороги сразу за его границей.",
            example = "We spent two days exploring the quiet environs of the old abbey.",
            exampleNative = "Мы провели два дня, исследуя тихие environs старого аббатства.",
            pos = "noun", semanticGroup = "travel_far_lands",
            fillInBlankExclusions = listOf(33716L, 33717L, 33718L, 33720L)),

        WordEntity(id = 33720, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "vicinage", transliteration = "[ˈvɪsɪnɪdʒ]", translation = "ближняя округа, соседство (архаич.)",
            definition = "The nearby area around a place — old word for the close neighbourhood.",
            definitionNative = "Близлежащая местность вокруг точки — старинное слово для ближнего района.",
            example = "No reliable inn could be found within the immediate vicinage of the manor.",
            exampleNative = "Ни одного надёжного трактира не нашлось в ближайшем vicinage поместья.",
            pos = "noun", semanticGroup = "travel_far_lands",
            fillInBlankExclusions = listOf(33716L, 33717L, 33718L, 33719L)),

        // ── travel_old_dwellings (5) ──────────────────────────────────────

        WordEntity(id = 33721, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hostelry", transliteration = "[ˈhɒstəlri]", translation = "старинная гостиница, постоялый двор",
            definition = "An old roadside inn — a place to eat, drink and sleep on a long road.",
            definitionNative = "Старинный придорожный приют — поесть, выпить и переночевать в долгом пути.",
            example = "A welcoming hostelry stood at the crossroads with a swinging painted sign.",
            exampleNative = "Гостеприимная hostelry стояла на перекрёстке с раскачивающейся вывеской.",
            pos = "noun", semanticGroup = "travel_old_dwellings",
            fillInBlankExclusions = listOf(33722L, 33723L, 33724L, 33725L)),

        WordEntity(id = 33722, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "wayside", transliteration = "[ˈweɪsaɪd]", translation = "обочина дороги (как место остановки)",
            definition = "The strip of grass and trees beside a road — a spot to rest or eat.",
            definitionNative = "Полоса травы и деревьев у дороги — место передохнуть или поесть.",
            example = "They stopped at the wayside to share bread and a flask of cool water.",
            exampleNative = "Они остановились у wayside, чтобы поделить хлеб и фляжку прохладной воды.",
            pos = "noun", semanticGroup = "travel_old_dwellings",
            fillInBlankExclusions = listOf(33721L, 33723L, 33724L, 33725L)),

        WordEntity(id = 33723, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "byway", transliteration = "[ˈbaɪweɪ]", translation = "глухая дорога, окольный путь",
            definition = "A small, quiet road away from the main route — used by locals only.",
            definitionNative = "Малая, тихая дорога в стороне от главного пути — её знают лишь местные.",
            example = "A dusty byway led them to a hidden village among the hills.",
            exampleNative = "Пыльная byway привела их в скрытую деревеньку среди холмов.",
            pos = "noun", semanticGroup = "travel_old_dwellings",
            fillInBlankExclusions = listOf(33721L, 33722L, 33724L, 33725L)),

        WordEntity(id = 33724, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "posada", transliteration = "[poʊˈsɑːdə]", translation = "посада (испанский постоялый двор)",
            definition = "A small Spanish inn for travellers — simple rooms, wine and a hot meal.",
            definitionNative = "Маленький испанский приют для путников — простые комнаты, вино, горячая еда.",
            example = "The pilgrims spent the night at a quiet posada outside the cathedral town.",
            exampleNative = "Паломники переночевали в тихой posada за соборным городком.",
            pos = "noun", semanticGroup = "travel_old_dwellings",
            fillInBlankExclusions = listOf(33721L, 33722L, 33723L, 33725L)),

        WordEntity(id = 33725, setId = 337, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tarry", transliteration = "[ˈtæri]", translation = "задержаться, медлить в пути (архаич.)",
            definition = "To linger somewhere on the road — staying longer than one had planned.",
            definitionNative = "Засиживаться где-то в пути — оставаться дольше, чем собирался.",
            example = "Do not tarry at the bridge — the storm clouds are gathering fast.",
            exampleNative = "Не tarry у моста — грозовые тучи быстро собираются.",
            pos = "verb", semanticGroup = "travel_old_dwellings",
            fillInBlankExclusions = listOf(33721L, 33722L, 33723L, 33724L)),
    )
}
