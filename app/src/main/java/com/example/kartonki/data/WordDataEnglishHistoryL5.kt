package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — История (level 5, носитель языка).
 *
 * Set 313: «История: носитель языка» — академическая историография,
 * редкая терминология и архаика (C2+).
 *
 * Распределение редкости: 23 LEGENDARY + 2 EPIC — два смежных уровня шкалы.
 *
 * Дополняет уже существующие сеты темы «История»:
 *   - Set 31  (WordDataEnglish.kt)         — L2 UNCOMMON.
 *   - Set 217 (WordDataEnglishExpanded.kt) — L2-L3 UNCOMMON/RARE.
 *   - Set 306 (WordDataEnglishHistory2.kt) — L1 COMMON/UNCOMMON.
 *
 * Слова setId=313 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   history_archaic_periods    — merovingian, antonine, flavian, ottonian, carolingian
 *   history_archaic_terms      — jacquerie, manumission, simony, attainder, regicide
 *   history_dignitaries        — exarchate, margrave, seneschal, condottiere, antipope
 *   history_documents          — cartulary, capitulary, bulla, concordat, interdict
 *   history_historiography     — hagiography, prosopography, epigraphy, diplomatics, annalistic
 *
 * Word IDs: 31301..31325 (setId × 100 + position).
 */
object WordDataEnglishHistoryL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 313, name = "История",
            description = "Академическая историография: редкая терминология и архаика",
            languagePair = "en-ru",
            orderIndex = 133,
            topic = "История", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── history_archaic_periods (5) ───────────────────────────────────

        WordEntity(id = 31301, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "merovingian", transliteration = "[ˌmɛrəˈvɪnʤiən]", translation = "меровингский (династия первых франкских королей)",
            definition = "Of the long-haired Frankish kings who ruled before Charlemagne's family rose.",
            definitionNative = "Связанный с длинноволосыми франкскими королями до прихода рода Карла Великого.",
            example = "A merovingian queen donated rich lands to a small monastery near Paris.",
            exampleNative = "Merovingian королева подарила богатые земли маленькому монастырю под Парижем.",
            pos = "adjective", semanticGroup = "history_archaic_periods",
            fillInBlankExclusions = listOf(31302L, 31303L, 31304L, 31305L)),

        WordEntity(id = 31302, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "antonine", transliteration = "[ˈæntəˌnaɪn]", translation = "антонинский (период римских императоров)",
            definition = "Belonging to the Roman age of five wise emperors — a peak of empire.",
            definitionNative = "Связанный с эпохой пяти мудрых римских императоров — расцвет державы.",
            example = "The antonine plague struck the empire at its prosperous height.",
            exampleNative = "Страшная antonine эпидемия ударила по империи на пике расцвета.",
            pos = "adjective", semanticGroup = "history_archaic_periods",
            fillInBlankExclusions = listOf(31301L, 31303L, 31304L, 31305L)),

        WordEntity(id = 31303, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "flavian", transliteration = "[ˈfleɪviən]", translation = "флавианский (династия Веспасиана)",
            definition = "Linked to the family of Vespasian and Titus — first century rulers of Rome.",
            definitionNative = "Связанный с родом Веспасиана и Тита — императоров Рима в первом веке.",
            example = "The flavian dynasty began the Colosseum after the civil wars ended.",
            exampleNative = "Flavian династия начала строить Колизей после гражданских войн.",
            pos = "adjective", semanticGroup = "history_archaic_periods",
            fillInBlankExclusions = listOf(31301L, 31302L, 31304L, 31305L)),

        WordEntity(id = 31304, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ottonian", transliteration = "[ɔˈtoʊniən]", translation = "оттоновский (династия германских королей)",
            definition = "Tied to a tenth-century German royal family that revived the western empire.",
            definitionNative = "Связанный с немецким королевским родом X века, возродившим западную империю.",
            example = "The ottonian renaissance gathered scholars around the German court.",
            exampleNative = "Ottonian возрождение собрало учёных при немецком дворе X века.",
            pos = "adjective", semanticGroup = "history_archaic_periods",
            fillInBlankExclusions = listOf(31301L, 31302L, 31303L, 31305L)),

        WordEntity(id = 31305, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "carolingian", transliteration = "[ˌkærəˈlɪnʤiən]", translation = "каролингский (династия Карла Великого)",
            definition = "Of the line of Charlemagne — the Frankish kings who ruled most of Europe.",
            definitionNative = "Из рода Карла Великого — франкских королей, правивших большей частью Европы.",
            example = "Latin manuscripts thrived under carolingian patronage in monasteries.",
            exampleNative = "Латинские рукописи расцвели при carolingian покровительстве в монастырях.",
            pos = "adjective", semanticGroup = "history_archaic_periods",
            fillInBlankExclusions = listOf(31301L, 31302L, 31303L, 31304L)),

        // ── history_archaic_terms (5) ─────────────────────────────────────

        WordEntity(id = 31306, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "jacquerie", transliteration = "[ʒækˈri]", translation = "жакерия (крестьянский бунт)",
            definition = "A peasant uprising against feudal lords — fields and manors set ablaze.",
            definitionNative = "Крестьянское восстание против сеньоров — поля и усадьбы в огне.",
            example = "Hunger and harsh taxes triggered the jacquerie of fourteen-fifty-eight.",
            exampleNative = "Голод и налоги породили jacquerie тысяча четыреста пятьдесят восьмого года.",
            pos = "noun", semanticGroup = "history_archaic_terms",
            fillInBlankExclusions = listOf(31307L, 31308L, 31309L, 31310L)),

        WordEntity(id = 31307, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "manumission", transliteration = "[ˌmænjʊˈmɪʃən]", translation = "манумиссия (освобождение раба)",
            definition = "The legal release of a slave by the master — a written act of freedom.",
            definitionNative = "Юридическое освобождение раба хозяином — оформленный документом акт свободы.",
            example = "Roman law allowed manumission as a reward for years of loyal service.",
            exampleNative = "Римское право допускало manumission в награду за годы преданной службы.",
            pos = "noun", semanticGroup = "history_archaic_terms",
            fillInBlankExclusions = listOf(31306L, 31308L, 31309L, 31310L)),

        WordEntity(id = 31308, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "simony", transliteration = "[ˈsaɪməni]", translation = "симония (продажа церковных должностей)",
            definition = "The sin of buying or selling sacred offices — bishop's seats traded for gold.",
            definitionNative = "Грех покупки или продажи церковных постов — кафедры менялись на золото.",
            example = "Reformers in Rome thundered against simony at the Lateran council.",
            exampleNative = "Реформаторы в Риме громили simony на Латеранском соборе.",
            pos = "noun", semanticGroup = "history_archaic_terms",
            fillInBlankExclusions = listOf(31306L, 31307L, 31309L, 31310L)),

        WordEntity(id = 31309, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "attainder", transliteration = "[əˈteɪndər]", translation = "лишение прав состояния (по приговору)",
            definition = "An old law stripping a convicted traitor of name, lands and noble title.",
            definitionNative = "Старинная кара: осуждённого за измену лишали имени, земель и титула.",
            example = "Parliament passed an attainder against the rebel earl in spring.",
            exampleNative = "Парламент издал attainder против мятежного графа той весной.",
            pos = "noun", semanticGroup = "history_archaic_terms",
            fillInBlankExclusions = listOf(31306L, 31307L, 31308L, 31310L)),

        WordEntity(id = 31310, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "regicide", transliteration = "[ˈrɛʤəˌsaɪd]", translation = "цареубийство",
            definition = "The killing of a reigning king — a crime that shook every old kingdom.",
            definitionNative = "Убийство правящего короля — преступление, потрясавшее старые королевства.",
            example = "The judges who signed the regicide were hunted across Europe for decades.",
            exampleNative = "Судей, подписавших regicide, преследовали по всей Европе десятки лет.",
            pos = "noun", semanticGroup = "history_archaic_terms",
            fillInBlankExclusions = listOf(31306L, 31307L, 31308L, 31309L)),

        // ── history_dignitaries (5) ───────────────────────────────────────

        WordEntity(id = 31311, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "exarchate", transliteration = "[ɛɡˈzɑrkeɪt]", translation = "экзархат (византийская провинция)",
            definition = "A distant Byzantine province ruled by a viceroy on behalf of the emperor.",
            definitionNative = "Дальняя провинция Византии, которой от имени императора правил наместник.",
            example = "Ravenna held out as a Byzantine exarchate long after Italy fell.",
            exampleNative = "Равенна держалась как византийский exarchate долго после падения Италии.",
            pos = "noun", semanticGroup = "history_dignitaries",
            fillInBlankExclusions = listOf(31312L, 31313L, 31314L, 31315L)),

        WordEntity(id = 31312, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "margrave", transliteration = "[ˈmɑrɡreɪv]", translation = "маркграф (правитель пограничной марки)",
            definition = "A medieval lord set to guard a dangerous border province of the empire.",
            definitionNative = "Средневековый владыка, поставленный охранять опасную пограничную провинцию.",
            example = "The margrave defended the eastern frontier against the wild Slavic tribes.",
            exampleNative = "Margrave защищал восточную границу от диких славянских племён.",
            pos = "noun", semanticGroup = "history_dignitaries",
            fillInBlankExclusions = listOf(31311L, 31313L, 31314L, 31315L)),

        WordEntity(id = 31313, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "seneschal", transliteration = "[ˈsɛnəʃəl]", translation = "сенешаль (управляющий двором)",
            definition = "A medieval steward who ran the household and lands of a great lord.",
            definitionNative = "Средневековый управляющий, ведавший хозяйством и землями знатного господина.",
            example = "The royal seneschal kept order in the court while the king campaigned.",
            exampleNative = "Королевский seneschal держал двор в порядке, пока король воевал.",
            pos = "noun", semanticGroup = "history_dignitaries",
            fillInBlankExclusions = listOf(31311L, 31312L, 31314L, 31315L)),

        WordEntity(id = 31314, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "condottiere", transliteration = "[ˌkɑndəˈtjɛri]", translation = "кондотьер (наёмный военачальник)",
            definition = "An Italian mercenary captain who hired out his troops to warring cities.",
            definitionNative = "Итальянский наёмный командир, продававший свои отряды враждующим городам.",
            example = "A famous condottiere served Milan one summer and Venice the next.",
            exampleNative = "Знаменитый condottiere служил Милану летом и Венеции год спустя.",
            pos = "noun", semanticGroup = "history_dignitaries",
            fillInBlankExclusions = listOf(31311L, 31312L, 31313L, 31315L)),

        WordEntity(id = 31315, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "antipope", transliteration = "[ˈæntiˌpoʊp]", translation = "антипапа (соперничающий папа)",
            definition = "A rival claimant to the papal throne, opposed by another pope at the same time.",
            definitionNative = "Соперничающий претендент на папский трон, противостоящий другому папе одновременно.",
            example = "The Avignon antipope split Western Christendom for nearly forty years.",
            exampleNative = "Авиньонский antipope расколол западное христианство почти на сорок лет.",
            pos = "noun", semanticGroup = "history_dignitaries",
            fillInBlankExclusions = listOf(31311L, 31312L, 31313L, 31314L)),

        // ── history_documents (5) ─────────────────────────────────────────

        WordEntity(id = 31316, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cartulary", transliteration = "[ˈkɑrtjəˌlɛri]", translation = "картулярий (сборник грамот)",
            definition = "A bound collection of land charters copied for safekeeping in a monastery.",
            definitionNative = "Сшитый сборник земельных грамот, переписанных для хранения в монастыре.",
            example = "The abbey cartulary preserved gifts of land going back four centuries.",
            exampleNative = "Монастырский cartulary сохранил земельные дары четырёхвековой давности.",
            pos = "noun", semanticGroup = "history_documents",
            fillInBlankExclusions = listOf(31317L, 31318L, 31319L, 31320L)),

        WordEntity(id = 31317, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "capitulary", transliteration = "[kəˈpɪtjəˌlɛri]", translation = "капитулярий (королевский указ Каролингов)",
            definition = "A royal decree of the Frankish kings, divided into numbered chapters.",
            definitionNative = "Королевский указ франкских правителей, разделённый на нумерованные главы.",
            example = "Charlemagne's famous capitulary set rules for both clergy and laity.",
            exampleNative = "Знаменитый capitulary Карла Великого упорядочил клир и мирян.",
            pos = "noun", semanticGroup = "history_documents",
            fillInBlankExclusions = listOf(31316L, 31318L, 31319L, 31320L)),

        WordEntity(id = 31318, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bulla", transliteration = "[ˈbʊlə]", translation = "булла (папская грамота)",
            definition = "A solemn papal letter sealed with a heavy lead disc on a silk cord.",
            definitionNative = "Торжественная папская грамота со свинцовой печатью на шёлковом шнуре.",
            example = "The pope issued a stern bulla against the rebellious German princes.",
            exampleNative = "Папа издал строгую bulla против непокорных немецких князей.",
            pos = "noun", semanticGroup = "history_documents",
            fillInBlankExclusions = listOf(31316L, 31317L, 31319L, 31320L)),

        WordEntity(id = 31319, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "concordat", transliteration = "[kənˈkɔrdæt]", translation = "конкордат (договор Святого престола и государства)",
            definition = "A formal treaty between the pope and a state about church matters.",
            definitionNative = "Официальный договор между папой и государством о делах церкви.",
            example = "Napoleon signed a concordat with Rome to restore the Catholic faith.",
            exampleNative = "Наполеон подписал concordat с Римом, чтобы вернуть католическую веру.",
            pos = "noun", semanticGroup = "history_documents",
            fillInBlankExclusions = listOf(31316L, 31317L, 31318L, 31320L)),

        WordEntity(id = 31320, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "interdict", transliteration = "[ˈɪntərˌdɪkt]", translation = "интердикт (церковный запрет)",
            definition = "A papal ban that suspends most sacraments across an entire kingdom.",
            definitionNative = "Папский запрет, приостанавливавший большинство таинств на территории королевства.",
            example = "Rome placed England under interdict during the quarrel with King John.",
            exampleNative = "Рим наложил interdict на Англию во время ссоры с королём Иоанном.",
            pos = "noun", semanticGroup = "history_documents",
            fillInBlankExclusions = listOf(31316L, 31317L, 31318L, 31319L)),

        // ── history_historiography (5) ────────────────────────────────────

        WordEntity(id = 31321, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hagiography", transliteration = "[ˌhæɡiˈɑɡrəfi]", translation = "агиография (жития святых)",
            definition = "The writing of saints' lives — pious biographies full of miracles and trials.",
            definitionNative = "Жанр житий святых — благочестивые жизнеописания с чудесами и испытаниями.",
            example = "Medieval hagiography mixed historical fact with moral parable.",
            exampleNative = "Средневековая hagiography смешивала исторический факт с поучительной притчей.",
            pos = "noun", semanticGroup = "history_historiography",
            fillInBlankExclusions = listOf(31322L, 31323L, 31324L)),

        WordEntity(id = 31322, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "prosopography", transliteration = "[ˌprɑsəˈpɑɡrəfi]", translation = "просопография (коллективное жизнеописание)",
            definition = "Scholarly study of a group through the lives of all its known members.",
            definitionNative = "Научное изучение группы через биографии всех её известных участников.",
            example = "Roman senatorial prosopography reveals dense networks of marriage and power.",
            exampleNative = "Сенатская prosopography Рима раскрывает плотные узы браков и власти.",
            pos = "noun", semanticGroup = "history_historiography",
            fillInBlankExclusions = listOf(31321L, 31323L, 31324L)),

        WordEntity(id = 31323, setId = 313, languagePair = "en-ru", rarity = "EPIC",
            original = "epigraphy", transliteration = "[ɪˈpɪɡrəfi]", translation = "эпиграфика (изучение надписей)",
            definition = "The scholarly study of inscriptions cut into stone, bronze or temple walls.",
            definitionNative = "Научное изучение надписей, высеченных в камне, бронзе или на стенах храмов.",
            example = "Greek epigraphy let researchers read the names on a marble pillar.",
            exampleNative = "Греческая epigraphy позволила прочесть имена на мраморной колонне.",
            pos = "noun", semanticGroup = "history_historiography",
            fillInBlankExclusions = listOf(31321L, 31322L, 31324L)),

        WordEntity(id = 31324, setId = 313, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "diplomatics", transliteration = "[ˌdɪpləˈmætɪks]", translation = "дипломатика (наука о грамотах)",
            definition = "The scholarly art of judging whether old charters and seals are genuine.",
            definitionNative = "Учёное искусство определять подлинность старых грамот и печатей.",
            example = "Modern diplomatics exposed the forged donation as an eighth-century fake.",
            exampleNative = "Современная diplomatics разоблачила подложный дар как фальшивку VIII века.",
            pos = "noun", semanticGroup = "history_historiography",
            fillInBlankExclusions = listOf(31321L, 31322L, 31323L)),

        WordEntity(id = 31325, setId = 313, languagePair = "en-ru", rarity = "EPIC",
            original = "annalistic", transliteration = "[ˌænəˈlɪstɪk]", translation = "анналистический (стиль летописания по годам)",
            definition = "Written year by year as bare events — no analysis, just dates and deeds.",
            definitionNative = "Записанный по годам как сухие события — без анализа, только даты и поступки.",
            example = "Early monastic chronicles followed an annalistic format without commentary.",
            exampleNative = "Ранние монастырские летописи держались annalistic формата без комментария.",
            pos = "adjective", semanticGroup = "history_historiography"),
    )
}
