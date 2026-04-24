package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — История (level 4).
 *
 * Set 312: «История» — профессиональная историография: источники,
 * методология, археология (L4 / EPIC+LEGENDARY).
 *
 * Дополняет уже существующие сеты этой темы:
 *   - Set 31  (WordDataEnglish.kt)          — L2 UNCOMMON (ancient, century, empire…).
 *   - Set 217 (WordDataEnglishExpanded.kt)  — L2-L3 UNCOMMON/RARE (crusade, reformation…).
 *   - Set 306 (WordDataEnglishHistory2.kt)  — L1 COMMON/UNCOMMON (king, queen, castle…).
 *
 * Слова этого сета не пересекаются ни с одним из перечисленных setId.
 */
object WordDataEnglishHistoryL4 {

    val sets = listOf(
        WordSetEntity(
            id = 312, name = "История",
            description = "Профессиональная историография: источники, методология, археология",
            languagePair = "en-ru",
            orderIndex = 132,
            topic = "История", level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ── history_historiography (5) ────────────────────────────────────

        WordEntity(id = 31201, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "historiography", transliteration = "[hɪˌstɔriˈɑɡrəfi]", translation = "историография",
            definition = "The academic study of how historians research, interpret and write about the past.",
            definitionNative = "Научное изучение того, как учёные исследуют и описывают прошлое.",
            example = "Modern historiography often questions the neutrality of older chronicles.",
            exampleNative = "Современная historiography часто ставит под сомнение беспристрастность старых хроник.",
            pos = "noun", semanticGroup = "history_historiography", fillInBlankExclusions = listOf(31202L, 31203L, 31205L, 31209L)),

        WordEntity(id = 31202, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "provenance", transliteration = "[ˈprɑvənəns]", translation = "происхождение (артефакта)",
            definition = "The documented history of an object, showing where it was found and who owned it.",
            definitionNative = "Задокументированная история предмета — где найден и в чьих руках побывал.",
            example = "The museum refused the vase until its provenance was verified.",
            exampleNative = "Музей не принимал вазу, пока не подтвердилось её provenance.",
            pos = "noun", semanticGroup = "history_historiography", fillInBlankExclusions = listOf(31201L, 31203L, 31205L)),

        WordEntity(id = 31203, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "antiquarian", transliteration = "[ˌæntɪˈkwɛriən]", translation = "антиквар / знаток древностей",
            definition = "A scholar or collector devoted to old books, coins and relics of the distant past.",
            definitionNative = "Учёный или собиратель, увлечённый старыми книгами, монетами и реликвиями.",
            example = "An old antiquarian catalogued each coin by the emperor who issued it.",
            exampleNative = "Старый antiquarian описал каждую монету по имени выпустившего её императора.",
            pos = "noun", semanticGroup = "history_historiography", fillInBlankExclusions = listOf(31201L, 31202L, 31205L)),

        WordEntity(id = 31204, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "apocryphal", transliteration = "[əˈpɑkrəfəl]", translation = "недостоверный / сомнительный",
            definition = "Said to be real but probably invented — a dubious tale with no solid proof.",
            definitionNative = "То, что выдают за истину, но проверить нельзя — без твёрдых доказательств.",
            example = "The speech attributed to Caesar is widely considered apocryphal.",
            exampleNative = "Речь, приписываемая Цезарю, считается apocryphal.",
            pos = "adjective", semanticGroup = "history_historiography"),

        WordEntity(id = 31205, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "attestation", transliteration = "[ˌætɛˈsteɪʃən]", translation = "свидетельство (источника)",
            definition = "A written proof in old documents that a name, event or practice really existed.",
            definitionNative = "Письменное подтверждение в старых документах, что имя или событие — не выдумка.",
            example = "The earliest attestation of this city appears in a Hittite clay tablet.",
            exampleNative = "Самое раннее attestation этого города встречается в хеттской глиняной табличке.",
            pos = "noun", semanticGroup = "history_historiography", fillInBlankExclusions = listOf(31201L, 31202L, 31203L, 31207L)),

        // ── history_archaeology (6) ───────────────────────────────────────

        WordEntity(id = 31206, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "stratigraphy", transliteration = "[strəˈtɪɡrəfi]", translation = "стратиграфия",
            definition = "Reading the layers of soil at a dig site to tell which objects are older.",
            definitionNative = "Чтение слоёв почвы на раскопе — чтобы понять, какие находки старше.",
            example = "Careful stratigraphy showed that the pottery predates the stone wall.",
            exampleNative = "Тщательная stratigraphy показала, что керамика старше каменной стены.",
            pos = "noun", semanticGroup = "history_archaeology", fillInBlankExclusions = listOf(31207L, 31208L, 31209L, 31210L, 31211L)),

        WordEntity(id = 31207, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "excavation", transliteration = "[ˌɛkskəˈveɪʃən]", translation = "раскопки",
            definition = "The careful digging of a site to uncover buried buildings, tools or graves.",
            definitionNative = "Аккуратное вскрытие земли, чтобы добраться до древних построек или могил.",
            example = "The excavation lasted three summers before the first coin appeared.",
            exampleNative = "Excavation длилась три лета, прежде чем нашлась первая монета.",
            pos = "noun", semanticGroup = "history_archaeology", fillInBlankExclusions = listOf(31206L, 31208L, 31209L, 31210L, 31211L)),

        WordEntity(id = 31208, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "radiocarbon", transliteration = "[ˌreɪdioʊˈkɑrbən]", translation = "радиоуглеродный метод",
            definition = "A laboratory technique that measures decay in old organic matter to tell its age.",
            definitionNative = "Лабораторный метод — по распаду в старой органике узнают её возраст.",
            example = "A radiocarbon test placed the wooden beam around 600 BC.",
            exampleNative = "Тест radiocarbon отнёс деревянную балку примерно к 600 году до н.э.",
            pos = "noun", semanticGroup = "history_archaeology", fillInBlankExclusions = listOf(31206L, 31209L, 31210L)),

        WordEntity(id = 31209, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "palaeography", transliteration = "[ˌpæliˈɑɡrəfi]", translation = "палеография",
            definition = "The study of old handwriting — how scribes shaped letters in past centuries.",
            definitionNative = "Изучение старинного почерка — как писцы выводили буквы в разные века.",
            example = "Expert palaeography dated the manuscript to the twelfth century.",
            exampleNative = "Профессиональная palaeography отнесла рукопись к XII веку.",
            pos = "noun", semanticGroup = "history_archaeology", fillInBlankExclusions = listOf(31206L, 31207L, 31208L, 31210L, 31211L)),

        WordEntity(id = 31210, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "potsherd", transliteration = "[ˈpɑtʃɜːrd]", translation = "черепок / осколок керамики",
            definition = "A broken piece of old pottery found in the ground during a dig.",
            definitionNative = "Осколок древней глиняной посуды — находят в земле во время раскопок.",
            example = "A single painted potsherd revealed the trade routes of the village.",
            exampleNative = "Один расписной potsherd раскрыл торговые пути этой деревни.",
            pos = "noun", semanticGroup = "history_archaeology", fillInBlankExclusions = listOf(31206L, 31207L, 31208L, 31209L, 31211L, 31214L)),

        WordEntity(id = 31211, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "obsidian", transliteration = "[əbˈsɪdiən]", translation = "обсидиан",
            definition = "A dark volcanic glass the ancients chipped into sharp knives and arrowheads.",
            definitionNative = "Тёмное вулканическое стекло — из него древние делали острые ножи и наконечники.",
            example = "The tribe traded obsidian across hundreds of miles for salt.",
            exampleNative = "Племя обменивало obsidian на соль на сотни миль вокруг.",
            pos = "noun", semanticGroup = "history_archaeology", fillInBlankExclusions = listOf(31206L, 31207L, 31208L, 31209L, 31210L)),

        // ── history_monuments (4) ─────────────────────────────────────────

        WordEntity(id = 31212, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tumulus", transliteration = "[ˈtjuːmjələs]", translation = "курган",
            definition = "A round earthen mound raised over a grave of a chief or warrior in olden days.",
            definitionNative = "Округлый земляной холм над могилой вождя или воина в древности.",
            example = "The iron sword was buried deep inside the royal tumulus.",
            exampleNative = "Железный меч был погребён глубоко внутри царского tumulus.",
            pos = "noun", semanticGroup = "history_monuments", fillInBlankExclusions = listOf(31213L, 31214L, 31215L)),

        WordEntity(id = 31213, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "necropolis", transliteration = "[nəˈkrɑpəlɪs]", translation = "некрополь",
            definition = "A large burial ground beside an ancient city — a whole city of tombs.",
            definitionNative = "Обширное кладбище у древнего города — целый город усыпальниц.",
            example = "The Etruscan necropolis covers the hillside outside the old walls.",
            exampleNative = "Этрусский necropolis покрывает склон холма за старыми стенами.",
            pos = "noun", semanticGroup = "history_monuments", fillInBlankExclusions = listOf(31212L, 31214L, 31215L)),

        WordEntity(id = 31214, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "sarcophagus", transliteration = "[sɑrˈkɑfəɡəs]", translation = "саркофаг",
            definition = "A heavy stone coffin, often carved with scenes, used for a ruler or noble.",
            definitionNative = "Тяжёлый каменный гроб с резьбой — для правителя или знатного лица.",
            example = "The painted sarcophagus held a pharaoh of the nineteenth dynasty.",
            exampleNative = "Расписанный sarcophagus хранил фараона девятнадцатой династии.",
            pos = "noun", semanticGroup = "history_monuments", fillInBlankExclusions = listOf(31212L, 31213L, 31215L)),

        WordEntity(id = 31215, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ziggurat", transliteration = "[ˈzɪɡʊræt]", translation = "зиккурат",
            definition = "A stepped pyramid temple of ancient Mesopotamia, climbed on wide terraces.",
            definitionNative = "Ступенчатая храмовая пирамида древнего Двуречья с широкими террасами.",
            example = "The Sumerian ziggurat once towered above the mud-brick houses.",
            exampleNative = "Шумерский ziggurat когда-то возвышался над глинобитными домами.",
            pos = "noun", semanticGroup = "history_monuments", fillInBlankExclusions = listOf(31212L, 31213L, 31214L)),

        // ── history_ancient_civs (6) ──────────────────────────────────────

        WordEntity(id = 31216, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Akkadian", transliteration = "[əˈkeɪdiən]", translation = "аккадский",
            definition = "Belonging to the first Mesopotamian empire — people, language or cuneiform script.",
            definitionNative = "Относящийся к первой месопотамской державе — народ, язык или клинопись.",
            example = "The tablet bears an Akkadian hymn to the goddess Ishtar.",
            exampleNative = "Табличка содержит Akkadian гимн богине Иштар.",
            pos = "adjective", semanticGroup = "history_ancient_civs", fillInBlankExclusions = listOf(31204L)),

        WordEntity(id = 31217, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Hittite", transliteration = "[ˈhɪtaɪt]", translation = "хеттский",
            definition = "Belonging to an ancient people who ruled Anatolia with iron weapons and chariots.",
            definitionNative = "Принадлежащий древнему народу, правившему Анатолией с железом и колесницами.",
            example = "The Hittite treaty with Egypt is the oldest one we can read.",
            exampleNative = "Hittite договор с Египтом — самый древний, что мы умеем прочесть.",
            pos = "adjective", semanticGroup = "history_ancient_civs", fillInBlankExclusions = listOf(31216L, 31218L, 31219L, 31220L, 31221L)),

        WordEntity(id = 31218, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Sumerian", transliteration = "[suˈmɛriən]", translation = "шумерский",
            definition = "Belonging to the first city-builders of south Mesopotamia — inventors of writing.",
            definitionNative = "Относящийся к первым градостроителям юга Двуречья — изобретателям письма.",
            example = "A Sumerian scribe kept track of every jar of beer.",
            exampleNative = "Sumerian писец учитывал каждый кувшин пива на складе.",
            pos = "adjective", semanticGroup = "history_ancient_civs", fillInBlankExclusions = listOf(31217L, 31219L, 31220L, 31221L)),

        WordEntity(id = 31219, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "Phoenician", transliteration = "[fəˈniʃən]", translation = "финикийский",
            definition = "Belonging to a seafaring Mediterranean people who spread the alphabet across coasts.",
            definitionNative = "Принадлежащий морскому средиземноморскому народу, разнёсшему алфавит по берегам.",
            example = "The Phoenician merchants traded purple dye from cedar ports.",
            exampleNative = "Phoenician купцы торговали пурпурной краской из кедровых портов.",
            pos = "adjective", semanticGroup = "history_ancient_civs", fillInBlankExclusions = listOf(31216L, 31217L, 31218L, 31220L, 31221L)),

        WordEntity(id = 31220, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "Byzantine", transliteration = "[ˈbɪzənˌtin]", translation = "византийский",
            definition = "Belonging to the eastern half of the Roman empire, centred on Constantinople.",
            definitionNative = "Относящийся к восточной части Римской империи со столицей в Константинополе.",
            example = "A gold Byzantine coin passed from merchant to merchant for decades.",
            exampleNative = "Золотая Byzantine монета десятилетиями переходила из рук в руки.",
            pos = "adjective", semanticGroup = "history_ancient_civs", fillInBlankExclusions = listOf(31216L, 31217L, 31218L, 31219L, 31221L)),

        WordEntity(id = 31221, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "protohistoric", transliteration = "[ˌproʊtoʊhɪˈstɔrɪk]", translation = "протоисторический",
            definition = "From the shadowy period just before true writing — known only from neighbours.",
            definitionNative = "Из смутного периода перед настоящей письменностью — известного лишь от соседей.",
            example = "The protohistoric tribes of the Danube left only burial goods behind.",
            exampleNative = "Protohistoric племена Дуная оставили после себя только могильный инвентарь.",
            pos = "adjective", semanticGroup = "history_ancient_civs", fillInBlankExclusions = listOf(31216L, 31217L, 31218L, 31219L, 31220L)),

        // ── history_polity_high (4) ───────────────────────────────────────

        WordEntity(id = 31222, setId = 312, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "suzerainty", transliteration = "[ˈsuːzərənti]", translation = "сюзеренитет",
            definition = "The rule of one state over another which keeps internal affairs but owes tribute.",
            definitionNative = "Власть одного государства над другим — с данью, но с внутренней самостоятельностью.",
            example = "For centuries Serbia lived under Ottoman suzerainty.",
            exampleNative = "На протяжении веков Сербия жила под османским suzerainty.",
            pos = "noun", semanticGroup = "history_polity_high", fillInBlankExclusions = listOf(31223L, 31224L, 31225L)),

        WordEntity(id = 31223, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "interregnum", transliteration = "[ˌɪntərˈrɛɡnəm]", translation = "междуцарствие",
            definition = "A gap between two reigns — when the throne is empty and disputes flare up.",
            definitionNative = "Промежуток между двумя правлениями — престол пуст, а споры закипают.",
            example = "The interregnum after the childless king lasted almost three years.",
            exampleNative = "Interregnum после бездетного короля длился почти три года.",
            pos = "noun", semanticGroup = "history_polity_high", fillInBlankExclusions = listOf(31222L, 31224L, 31225L)),

        WordEntity(id = 31224, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "abdication", transliteration = "[ˌæbdɪˈkeɪʃən]", translation = "отречение (от престола)",
            definition = "The formal act of stepping down from the throne and giving up royal power.",
            definitionNative = "Официальный шаг — покинуть престол и отказаться от царской власти.",
            example = "The king's abdication shocked the capital and divided the court.",
            exampleNative = "Abdication короля потрясло столицу и расколело двор.",
            pos = "noun", semanticGroup = "history_polity_high", fillInBlankExclusions = listOf(31222L, 31223L, 31225L)),

        WordEntity(id = 31225, setId = 312, languagePair = "en-ru", rarity = "EPIC",
            original = "hegemony", transliteration = "[hɪˈʤɛməni]", translation = "гегемония",
            definition = "The dominance of one state over its neighbours — usually without formal conquest.",
            definitionNative = "Господство одного государства над соседями — обычно без прямого захвата.",
            example = "Athenian hegemony over the Aegean ended with the long Peloponnesian war.",
            exampleNative = "Афинская hegemony над Эгейским морем пала в долгой Пелопоннесской войне.",
            pos = "noun", semanticGroup = "history_polity_high", fillInBlankExclusions = listOf(31222L, 31223L, 31224L)),
    )
}
