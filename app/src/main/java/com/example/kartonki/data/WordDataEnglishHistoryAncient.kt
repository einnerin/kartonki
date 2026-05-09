package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — История (level 3, древние цивилизации).
 *
 * Set 455: «История» — углублённый уровень, фокус на древних цивилизациях:
 * Шумер, Египет, Греция, Рим, Майя/Ацтеки, Персия. Лексика про эпохи,
 * артефакты, государственные институты, повседневную жизнь древнего мира.
 * Распределение редкости: 15 RARE + 10 EPIC.
 *
 * Дополняет уже существующие сеты темы «История»:
 *   - Set 31  (WordDataEnglish.kt)          — L2 UNCOMMON (ancient, century, empire…).
 *   - Set 217 (WordDataEnglishExpanded.kt)  — L3 UNCOMMON/RARE (crusade, reformation…).
 *   - Set 306 (WordDataEnglishHistory2.kt)  — L1 COMMON/UNCOMMON (king, queen, castle…).
 *   - Set 312 (WordDataEnglishHistoryL4.kt) — L4 EPIC/LEGENDARY (historiography, ziggurat…).
 *   - Set 313 (WordDataEnglishHistoryL5.kt) — L5 LEGENDARY (merovingian, jacquerie…).
 *
 * Слова setId=455 не пересекаются ни с одним из перечисленных setId (проверено grep).
 *
 * SemanticGroups:
 *   history_ancient_egypt        — pharaoh, hieroglyph, papyrus, obelisk, mummy
 *   history_ancient_mesopotamia  — cuneiform, scribe, satrap
 *   history_ancient_greece       — polis, agora, hoplite, oracle
 *   history_ancient_rome         — aqueduct, gladiator, centurion, senator, legion, emperor
 *   history_ancient_americas     — conquistador, pyramid, codex
 *   history_ancient_objects      — chariot, citadel, amphora, antiquity
 *
 * Word IDs: 45501..45525 (setId × 100 + position).
 */
object WordDataEnglishHistoryAncient {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 455, name = "История",
            description = "Древние цивилизации: Шумер, Египет, Греция, Рим",
            languagePair = "en-ru",
            orderIndex = 454,
            topic = "История", level = 3),
    )

    val words: List<WordEntity> = listOf(

        // ── history_ancient_egypt (5) ─────────────────────────────────────

        WordEntity(id = 45501, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "pharaoh", transliteration = "[ˈfɛroʊ]", translation = "фараон",
            definition = "The supreme ruler of ancient Egypt, worshipped as a living god on earth.",
            definitionNative = "Верховный правитель древнего Египта, почитаемый как живое божество.",
            example = "A young pharaoh ordered a vast new temple beside the river Nile.",
            exampleNative = "Молодой pharaoh велел построить огромный новый храм у Нила.",
            pos = "noun", semanticGroup = "history_ancient_egypt", fillInBlankExclusions = listOf(45502L, 45503L, 45504L, 45505L)),

        WordEntity(id = 45502, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "hieroglyph", transliteration = "[ˈhaɪrəˌɡlɪf]", translation = "иероглиф",
            definition = "A picture-symbol used in old Egyptian writing — owls, hands, suns and stars.",
            definitionNative = "Знак-картинка из старой египетской письменности — совы, ладони, солнца, звёзды.",
            example = "Each hieroglyph on the wall stood for a sound or a whole word.",
            exampleNative = "Каждый hieroglyph на стене обозначал звук или целое слово.",
            pos = "noun", semanticGroup = "history_ancient_egypt", fillInBlankExclusions = listOf(45501L, 45503L, 45504L, 45505L)),

        WordEntity(id = 45503, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "papyrus", transliteration = "[pəˈpaɪrəs]", translation = "папирус",
            definition = "A thin sheet made from river reeds, used for writing in the old Nile valley.",
            definitionNative = "Тонкий лист из речного тростника — на нём писали в долине Нила в древности.",
            example = "The priest unrolled a long papyrus and began to read aloud.",
            exampleNative = "Жрец развернул длинный papyrus и начал читать вслух.",
            pos = "noun", semanticGroup = "history_ancient_egypt", fillInBlankExclusions = listOf(45501L, 45502L, 45504L, 45505L)),

        WordEntity(id = 45504, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "obelisk", transliteration = "[ˈɑbəlɪsk]", translation = "обелиск",
            definition = "A tall four-sided stone pillar that narrows to a pyramid-shaped tip on top.",
            definitionNative = "Высокий четырёхгранный каменный столб, сужающийся к пирамидальной вершине.",
            example = "A red granite obelisk towered above the dusty market square.",
            exampleNative = "Красный гранитный obelisk возвышался над пыльной рыночной площадью.",
            pos = "noun", semanticGroup = "history_ancient_egypt", fillInBlankExclusions = listOf(45501L, 45502L, 45503L, 45505L)),

        WordEntity(id = 45505, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "mummy", transliteration = "[ˈmʌmi]", translation = "мумия",
            definition = "A dried preserved body wrapped in long strips of cloth for the afterlife.",
            definitionNative = "Высушенное и сохранённое тело, обмотанное длинными полосами ткани для загробной жизни.",
            example = "A painted mummy lay inside the heavy stone coffin for centuries.",
            exampleNative = "Расписная mummy лежала внутри тяжёлого каменного гроба много веков.",
            pos = "noun", semanticGroup = "history_ancient_egypt", fillInBlankExclusions = listOf(45501L, 45502L, 45503L, 45504L)),

        // ── history_ancient_mesopotamia (3) ───────────────────────────────

        WordEntity(id = 45506, setId = 455, languagePair = "en-ru", rarity = "EPIC",
            original = "cuneiform", transliteration = "[kjuˈniəˌfɔrm]", translation = "клинопись",
            definition = "An old wedge-shaped script pressed into wet clay tablets in Mesopotamia.",
            definitionNative = "Древнее клинообразное письмо, выдавленное на сырых глиняных табличках Двуречья.",
            example = "The teacher showed her students a tablet covered in tiny cuneiform marks.",
            exampleNative = "Учительница показала ученикам табличку, покрытую мелкими cuneiform знаками.",
            pos = "noun", semanticGroup = "history_ancient_mesopotamia", fillInBlankExclusions = listOf(45507L, 45508L)),

        WordEntity(id = 45507, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "scribe", transliteration = "[skraɪb]", translation = "писец",
            definition = "A person trained to copy texts and keep records in palaces and temples.",
            definitionNative = "Человек, обученный переписывать тексты и вести записи во дворцах и храмах.",
            example = "Every royal scribe sat cross-legged with a reed pen on his knee.",
            exampleNative = "Каждый царский scribe сидел скрестив ноги, с тростниковым пером на колене.",
            pos = "noun", semanticGroup = "history_ancient_mesopotamia", fillInBlankExclusions = listOf(45506L, 45508L)),

        WordEntity(id = 45508, setId = 455, languagePair = "en-ru", rarity = "EPIC",
            original = "satrap", transliteration = "[ˈsætræp]", translation = "сатрап",
            definition = "A Persian governor who ruled a province in the name of the great king.",
            definitionNative = "Персидский наместник, правивший провинцией от имени великого царя.",
            example = "The satrap collected silver tribute from every village in his province.",
            exampleNative = "Satrap собирал серебряную дань с каждой деревни своей провинции.",
            pos = "noun", semanticGroup = "history_ancient_mesopotamia", fillInBlankExclusions = listOf(45506L, 45507L)),

        // ── history_ancient_greece (4) ────────────────────────────────────

        WordEntity(id = 45509, setId = 455, languagePair = "en-ru", rarity = "EPIC",
            original = "polis", transliteration = "[ˈpɑlɪs]", translation = "полис (город-государство)",
            definition = "An old Greek city that ran its own laws, courts and army as one community.",
            definitionNative = "Древнегреческий город со своими законами, судами и войском — единая община.",
            example = "Each polis trained its own citizens to fight in close ranks of spears.",
            exampleNative = "Каждый polis обучал своих граждан биться плотными рядами с копьями.",
            pos = "noun", semanticGroup = "history_ancient_greece", fillInBlankExclusions = listOf(45510L, 45511L, 45512L)),

        WordEntity(id = 45510, setId = 455, languagePair = "en-ru", rarity = "EPIC",
            original = "agora", transliteration = "[ˈæɡərə]", translation = "агора (рыночная площадь)",
            definition = "The open public square of a Greek town — for trade, talk and assembly.",
            definitionNative = "Открытая общественная площадь греческого города — для торговли, бесед и собраний.",
            example = "Philosophers loved to debate in the agora under the morning sun.",
            exampleNative = "Философы любили спорить на agora под утренним солнцем.",
            pos = "noun", semanticGroup = "history_ancient_greece", fillInBlankExclusions = listOf(45509L, 45511L, 45512L)),

        WordEntity(id = 45511, setId = 455, languagePair = "en-ru", rarity = "EPIC",
            original = "hoplite", transliteration = "[ˈhɑplaɪt]", translation = "гоплит (греческий пехотинец)",
            definition = "A heavy-armed Greek foot soldier who fought in tight rows with shield and spear.",
            definitionNative = "Тяжеловооружённый греческий пехотинец, бившийся плотным строем со щитом и копьём.",
            example = "Every hoplite wore a bronze helmet and carried a round wooden shield.",
            exampleNative = "Каждый hoplite носил бронзовый шлем и круглый деревянный щит.",
            pos = "noun", semanticGroup = "history_ancient_greece", fillInBlankExclusions = listOf(45509L, 45510L, 45512L)),

        WordEntity(id = 45512, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "oracle", transliteration = "[ˈɔrəkəl]", translation = "оракул",
            definition = "A holy place where a priestess gave puzzling answers from the gods themselves.",
            definitionNative = "Святое место, где жрица передавала загадочные ответы от самих богов.",
            example = "Kings travelled for weeks to ask the oracle about future wars.",
            exampleNative = "Цари неделями ехали, чтобы спросить oracle о грядущих войнах.",
            pos = "noun", semanticGroup = "history_ancient_greece", fillInBlankExclusions = listOf(45509L, 45510L, 45511L)),

        // ── history_ancient_rome (6) ──────────────────────────────────────

        WordEntity(id = 45513, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "aqueduct", transliteration = "[ˈækwəˌdʌkt]", translation = "акведук",
            definition = "A long stone channel on tall arches that carried fresh water into a city.",
            definitionNative = "Длинный каменный жёлоб на высоких арках, по которому в город шла свежая вода.",
            example = "A Roman aqueduct still spans the valley after almost two thousand years.",
            exampleNative = "Римский aqueduct до сих пор перекинут через долину почти два тысячелетия.",
            pos = "noun", semanticGroup = "history_ancient_rome", fillInBlankExclusions = listOf(45514L, 45515L, 45516L, 45517L, 45518L)),

        WordEntity(id = 45514, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "gladiator", transliteration = "[ˈɡlædiˌeɪtər]", translation = "гладиатор",
            definition = "A Roman fighter trained to entertain crowds with deadly arena combat.",
            definitionNative = "Римский боец, обученный развлекать толпу смертельными поединками на арене.",
            example = "The crowd roared as the gladiator raised his bloody sword in triumph.",
            exampleNative = "Толпа ревела, когда gladiator поднял свой окровавленный меч в победе.",
            pos = "noun", semanticGroup = "history_ancient_rome", fillInBlankExclusions = listOf(45513L, 45515L, 45516L, 45517L, 45518L)),

        WordEntity(id = 45515, setId = 455, languagePair = "en-ru", rarity = "EPIC",
            original = "centurion", transliteration = "[sɛnˈtjʊriən]", translation = "центурион",
            definition = "A Roman officer in command of about a hundred foot soldiers in a legion.",
            definitionNative = "Римский офицер, который командовал примерно сотней пехотинцев в легионе.",
            example = "A scarred centurion barked orders along the dusty marching column.",
            exampleNative = "Centurion со шрамом отдавал приказы вдоль пыльной маршевой колонны.",
            pos = "noun", semanticGroup = "history_ancient_rome", fillInBlankExclusions = listOf(45513L, 45514L, 45516L, 45517L, 45518L)),

        WordEntity(id = 45516, setId = 455, languagePair = "en-ru", rarity = "EPIC",
            original = "senator", transliteration = "[ˈsɛnətər]", translation = "сенатор",
            definition = "A member of the old Roman council who debated laws and foreign policy.",
            definitionNative = "Член древнего римского совета, обсуждавший законы и внешнюю политику.",
            example = "An ageing senator rose in his white robe to address the chamber.",
            exampleNative = "Пожилой senator встал в своей белой тоге, чтобы обратиться к залу.",
            pos = "noun", semanticGroup = "history_ancient_rome", fillInBlankExclusions = listOf(45513L, 45514L, 45515L, 45517L, 45518L)),

        WordEntity(id = 45517, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "legion", transliteration = "[ˈliʤən]", translation = "легион",
            definition = "A large Roman army unit of several thousand foot soldiers under one eagle.",
            definitionNative = "Крупное соединение римской армии — несколько тысяч пехотинцев под одним орлом.",
            example = "An entire legion marched north through the rainy German forests.",
            exampleNative = "Целый legion двигался на север через дождливые германские леса.",
            pos = "noun", semanticGroup = "history_ancient_rome", fillInBlankExclusions = listOf(45513L, 45514L, 45515L, 45516L, 45518L)),

        WordEntity(id = 45518, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "emperor", transliteration = "[ˈɛmpərər]", translation = "император",
            definition = "The supreme ruler of a vast realm of many peoples and conquered lands.",
            definitionNative = "Верховный правитель огромной державы из многих народов и завоёванных земель.",
            example = "The new emperor rode into the city on a tall white horse.",
            exampleNative = "Новый emperor въехал в город на высоком белом коне.",
            pos = "noun", semanticGroup = "history_ancient_rome", fillInBlankExclusions = listOf(45513L, 45514L, 45515L, 45516L, 45517L)),

        // ── history_ancient_americas (3) ──────────────────────────────────

        WordEntity(id = 45519, setId = 455, languagePair = "en-ru", rarity = "EPIC",
            original = "conquistador", transliteration = "[kɑnˈkistəˌdɔr]", translation = "конкистадор",
            definition = "A Spanish soldier-adventurer who seized native lands of the New World.",
            definitionNative = "Испанский воин-авантюрист, захватывавший индейские земли Нового Света.",
            example = "An armoured conquistador stepped onto the sand with a sword in hand.",
            exampleNative = "Conquistador в доспехах ступил на песок с мечом в руке.",
            pos = "noun", semanticGroup = "history_ancient_americas", fillInBlankExclusions = listOf(45520L, 45521L)),

        WordEntity(id = 45520, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "pyramid", transliteration = "[ˈpɪrəmɪd]", translation = "пирамида",
            definition = "A huge stone monument with four sloping sides meeting at a single point.",
            definitionNative = "Огромный каменный монумент с четырьмя наклонными гранями, сходящимися в одной точке.",
            example = "A steep stone pyramid rose above the green Mexican jungle.",
            exampleNative = "Крутая каменная pyramid возвышалась над зелёными мексиканскими джунглями.",
            pos = "noun", semanticGroup = "history_ancient_americas", fillInBlankExclusions = listOf(45519L, 45521L)),

        WordEntity(id = 45521, setId = 455, languagePair = "en-ru", rarity = "EPIC",
            original = "codex", transliteration = "[ˈkoʊdɛks]", translation = "кодекс (древняя рукопись)",
            definition = "An old hand-painted book with picture-signs — for example a Maya almanac.",
            definitionNative = "Старинная рукописная книга с рисуночными знаками — например, альманах майя.",
            example = "A surviving Maya codex tells of stars, gods and the rainy season.",
            exampleNative = "Уцелевший Maya codex рассказывает о звёздах, богах и сезоне дождей.",
            pos = "noun", semanticGroup = "history_ancient_americas", fillInBlankExclusions = listOf(45519L, 45520L)),

        // ── history_ancient_objects (4) ───────────────────────────────────

        WordEntity(id = 45522, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "chariot", transliteration = "[ˈʧɛriət]", translation = "колесница",
            definition = "A two-wheeled cart pulled by horses, ridden in old battles and royal parades.",
            definitionNative = "Двухколёсная повозка на конной тяге — для древних битв и царских шествий.",
            example = "A golden chariot raced ahead of the army across the plain.",
            exampleNative = "Золотая chariot мчалась впереди войска по равнине.",
            pos = "noun", semanticGroup = "history_ancient_objects", fillInBlankExclusions = listOf(45523L, 45524L, 45525L)),

        WordEntity(id = 45523, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "citadel", transliteration = "[ˈsɪtədəl]", translation = "цитадель",
            definition = "A strong fortress on high ground inside a city — its last line of defence.",
            definitionNative = "Мощная крепость на возвышении внутри города — последний рубеж обороны.",
            example = "The citizens fled inside the citadel as enemy ships appeared.",
            exampleNative = "Горожане укрылись в citadel, когда показались вражеские корабли.",
            pos = "noun", semanticGroup = "history_ancient_objects", fillInBlankExclusions = listOf(45522L, 45524L, 45525L)),

        WordEntity(id = 45524, setId = 455, languagePair = "en-ru", rarity = "EPIC",
            original = "amphora", transliteration = "[ˈæmfərə]", translation = "амфора",
            definition = "A tall clay jar with two handles, used in old Mediterranean lands for wine and oil.",
            definitionNative = "Высокий глиняный сосуд с двумя ручками — на старом Средиземноморье для вина и масла.",
            example = "Divers found a Greek amphora deep beneath the warm blue sea.",
            exampleNative = "Ныряльщики нашли греческую amphora глубоко под тёплым синим морем.",
            pos = "noun", semanticGroup = "history_ancient_objects", fillInBlankExclusions = listOf(45522L, 45523L, 45525L)),

        WordEntity(id = 45525, setId = 455, languagePair = "en-ru", rarity = "RARE",
            original = "antiquity", transliteration = "[ænˈtɪkwəti]", translation = "античность / древность",
            definition = "The far-off age of Greece and Rome, before the Middle Ages began in Europe.",
            definitionNative = "Далёкая эпоха Греции и Рима — до того, как в Европе начались Средние века.",
            example = "Many ideas of antiquity returned to Europe through translated Arab books.",
            exampleNative = "Многие идеи antiquity вернулись в Европу через переведённые арабские книги.",
            pos = "noun", semanticGroup = "history_ancient_objects", fillInBlankExclusions = listOf(45522L, 45523L, 45524L)),
    )
}
