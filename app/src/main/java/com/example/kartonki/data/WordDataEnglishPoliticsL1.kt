package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Политика (level 1, основы / A1).
 *
 * Set 330: «Политика: основы» — базовая лексика про власть, страны, людей,
 * выступления, войну и мир для повседневных разговоров (COMMON / UNCOMMON,
 * преобладает COMMON).
 *
 * Дополняет уже существующие сеты темы «Политика» в en-ru:
 *   - Set 38, 48, 56, 57, 58, 65, 67, 75 (WordDataEnglish.kt) — L2-L4.
 *   - Set 236 (WordDataEnglishExpanded.kt) — L2 базовая лексика.
 *   - Set 237 (WordDataEnglishExpanded.kt) — L3 системы и термины.
 *   - Set 331 (parallel session)            — L5 (создаётся параллельно).
 *
 * Слова из этого сета не пересекаются ни с одним из 10 уже существующих
 * en-ru сетов темы «Политика» (проверено grep по `original = "..."`).
 * Cross-topic дубли с set 11 (geography), 31 (history), 22 (work) и пр. —
 * допустимы по политике проекта: одно слово в разных темах не запрещено.
 *
 * SemanticGroups (5 × 5):
 *   politics_country     — country, capital, flag, nation, border
 *   politics_people      — chief, mayor, queen, public, ambassador
 *   politics_actions     — support, march, speech, meeting, agreement
 *   politics_concepts    — rule, news, unity, kingdom, republic
 *   politics_war_peace   — war, army, soldier, weapon, embassy
 *
 * Word IDs: 33001..33025 (setId × 100 + position).
 */
object WordDataEnglishPoliticsL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 330, name = "Политика",
            description = "Базовая лексика про власть, выборы и страны для повседневных разговоров",
            languagePair = "en-ru",
            orderIndex = 145,
            topic = "Политика", level = 1),
    )

    val words: List<WordEntity> = listOf(

        // ── politics_country (5) ─────────────────────────────────────────

        WordEntity(id = 33001, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "country", transliteration = "[ˈkəntri]", translation = "страна",
            definition = "A large area of land with its own people, leaders and laws.",
            definitionNative = "Большая земля со своими жителями, правителями и законами.",
            example = "She grew up in a small country in Eastern Europe.",
            exampleNative = "Она выросла в небольшой country на востоке Европы.",
            pos = "noun", semanticGroup = "politics_country", fillInBlankExclusions = listOf(33002L, 33003L, 33004L, 33005L, 33019L, 33020L)),

        WordEntity(id = 33002, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "capital", transliteration = "[ˈkæpɪtəl]", translation = "столица",
            definition = "The main city of a land — where the leaders and parliament sit.",
            definitionNative = "Главный город страны — там сидят правители и парламент.",
            example = "Tokyo is the capital of Japan and its biggest city.",
            exampleNative = "Токио — это capital Японии и её крупнейший город.",
            pos = "noun", semanticGroup = "politics_country", fillInBlankExclusions = listOf(33001L, 33003L, 33004L, 33005L)),

        WordEntity(id = 33003, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "flag", transliteration = "[flæɡ]", translation = "флаг",
            definition = "A coloured cloth on a pole — the symbol of a land or a team.",
            definitionNative = "Цветная ткань на палке — знак страны или команды.",
            example = "Children waved a small flag at the parade.",
            exampleNative = "Дети махали маленьким flag на параде.",
            pos = "noun", semanticGroup = "politics_country", fillInBlankExclusions = listOf(33001L, 33002L, 33004L, 33005L)),

        WordEntity(id = 33004, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "nation", transliteration = "[ˈneɪʃən]", translation = "нация",
            definition = "A whole people who share one land, language and history together.",
            definitionNative = "Все жители одной земли с общим языком и историей.",
            example = "The president spoke to the nation on television.",
            exampleNative = "Президент обратился к nation по телевидению.",
            pos = "noun", semanticGroup = "politics_country", fillInBlankExclusions = listOf(33001L, 33002L, 33003L, 33005L, 33009L, 33022L)),

        WordEntity(id = 33005, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "border", transliteration = "[ˈbɔrdər]", translation = "граница",
            definition = "The line where one land ends and another one starts.",
            definitionNative = "Линия, где кончается одна земля и начинается другая.",
            example = "Soldiers checked our papers at the border with Poland.",
            exampleNative = "Солдаты проверили наши документы на border с Польшей.",
            pos = "noun", semanticGroup = "politics_country", fillInBlankExclusions = listOf(33001L, 33002L, 33003L, 33004L)),

        // ── politics_people (5) ──────────────────────────────────────────

        WordEntity(id = 33006, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "chief", transliteration = "[ʧif]", translation = "вождь",
            definition = "The top person of a group — the one who decides the most.",
            definitionNative = "Самый старший человек в группе — тот, кто решает больше всех.",
            example = "The chief of the tribe welcomed the foreign guests.",
            exampleNative = "Chief племени тепло встретил иностранных гостей.",
            pos = "noun", semanticGroup = "politics_people", fillInBlankExclusions = listOf(33007L, 33008L, 33009L, 33010L)),

        WordEntity(id = 33007, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "mayor", transliteration = "[ˈmeɪər]", translation = "мэр",
            definition = "The top person of a city — chosen by the people to run their town.",
            definitionNative = "Самый старший человек в городе — его выбирают жители управлять городом.",
            example = "The mayor opened the new park on Sunday morning.",
            exampleNative = "Mayor открыл новый парк в воскресенье утром.",
            pos = "noun", semanticGroup = "politics_people", fillInBlankExclusions = listOf(33006L, 33008L, 33009L, 33010L)),

        WordEntity(id = 33008, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "queen", transliteration = "[kwin]", translation = "королева",
            definition = "A woman who rules a land, or the wife of a ruling monarch.",
            definitionNative = "Женщина, правящая страной, или жена правящего монарха.",
            example = "The queen waved to the crowd from the palace balcony.",
            exampleNative = "Queen помахала толпе с балкона дворца.",
            pos = "noun", semanticGroup = "politics_people", fillInBlankExclusions = listOf(33006L, 33007L, 33009L, 33010L)),

        WordEntity(id = 33009, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "public", transliteration = "[ˈpəblɪk]", translation = "общественность",
            definition = "All the ordinary people of a country, taken together as a whole.",
            definitionNative = "Все обычные люди страны, взятые вместе как одно целое.",
            example = "The public was angry about the new tax on petrol.",
            exampleNative = "Public возмутилась новым налогом на бензин.",
            pos = "noun", semanticGroup = "politics_people", fillInBlankExclusions = listOf(33001L, 33004L, 33006L, 33007L, 33008L, 33010L)),

        WordEntity(id = 33010, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "ambassador", transliteration = "[æmˈbæsədər]", translation = "посол",
            definition = "A senior person sent abroad to speak for their country's leader.",
            definitionNative = "Высокий чин, посланный за границу говорить от имени своих властей.",
            example = "The new ambassador arrived in London last week.",
            exampleNative = "Новый ambassador прибыл в Лондон на прошлой неделе.",
            pos = "noun", semanticGroup = "politics_people", fillInBlankExclusions = listOf(33006L, 33007L, 33008L, 33009L, 33023L)),

        // ── politics_actions (5) ─────────────────────────────────────────

        WordEntity(id = 33011, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "support", transliteration = "[səˈpɔrt]", translation = "поддерживать",
            definition = "To stand on someone's side and help them with words, money or work.",
            definitionNative = "Быть на чьей-то стороне и помогать словом, деньгами или работой.",
            example = "Many young people support the green party in the city.",
            exampleNative = "Многие молодые люди support партию зелёных в городе.",
            pos = "verb", semanticGroup = "politics_actions"),

        WordEntity(id = 33012, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "march", transliteration = "[mɑrʧ]", translation = "марш",
            definition = "A large walk through the streets — to show what a crowd thinks.",
            definitionNative = "Большой проход толпой по улицам — показать, что думает народ.",
            example = "Thousands joined the peace march in the city centre.",
            exampleNative = "Тысячи людей вышли на мирный march в центр города.",
            pos = "noun", semanticGroup = "politics_actions", fillInBlankExclusions = listOf(33013L, 33014L, 33015L)),

        WordEntity(id = 33013, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "speech", transliteration = "[spiʧ]", translation = "речь",
            definition = "A long talk given in front of a crowd — usually planned in advance.",
            definitionNative = "Долгий разговор перед толпой — обычно подготовленный заранее.",
            example = "The president gave a long speech about the future.",
            exampleNative = "Президент произнёс длинную speech о будущем.",
            pos = "noun", semanticGroup = "politics_actions", fillInBlankExclusions = listOf(33012L, 33014L, 33015L)),

        WordEntity(id = 33014, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "meeting", transliteration = "[ˈmitɪŋ]", translation = "собрание",
            definition = "When several people sit together to talk and decide things.",
            definitionNative = "Когда несколько человек садятся вместе обсудить и решить дела.",
            example = "The leaders had a long meeting about the new bill.",
            exampleNative = "Руководители провели долгое meeting о новом законопроекте.",
            pos = "noun", semanticGroup = "politics_actions", fillInBlankExclusions = listOf(33012L, 33013L, 33015L)),

        WordEntity(id = 33015, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "agreement", transliteration = "[əˈɡrimənt]", translation = "соглашение",
            definition = "When two sides shake hands and promise the same thing in writing.",
            definitionNative = "Когда две стороны жмут руки и письменно обещают одно и то же.",
            example = "The two countries signed an agreement to stop the fighting.",
            exampleNative = "Две страны подписали agreement, чтобы остановить бои.",
            pos = "noun", semanticGroup = "politics_actions"),

        // ── politics_concepts (5) ────────────────────────────────────────

        WordEntity(id = 33016, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "rule", transliteration = "[rul]", translation = "правило",
            definition = "A line that tells people what they may or may not do.",
            definitionNative = "Линия, которая говорит людям, что можно и что нельзя делать.",
            example = "The first rule of the road is to drive on the right.",
            exampleNative = "Первое rule дороги — езди справа.",
            pos = "noun", semanticGroup = "politics_concepts", fillInBlankExclusions = listOf(33017L, 33018L, 33019L, 33020L)),

        WordEntity(id = 33017, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "news", transliteration = "[nuz]", translation = "новости",
            definition = "Reports about what just happened — on TV, radio or in a paper.",
            definitionNative = "Сообщения о том, что только что случилось — по ТВ, радио или в газете.",
            example = "I watch the news every morning while drinking coffee.",
            exampleNative = "Я смотрю news каждое утро за чашкой кофе.",
            pos = "noun", semanticGroup = "politics_concepts", fillInBlankExclusions = listOf(33016L, 33018L, 33019L, 33020L)),

        WordEntity(id = 33018, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "unity", transliteration = "[ˈjunɪti]", translation = "единство",
            definition = "When many different people stand together as one big team.",
            definitionNative = "Когда много разных людей стоят вместе как одна большая команда.",
            example = "The leader called for unity after the disputed result.",
            exampleNative = "Лидер призвал к unity после спорных результатов.",
            pos = "noun", semanticGroup = "politics_concepts", fillInBlankExclusions = listOf(33011L, 33016L, 33017L, 33019L, 33020L, 33021L)),

        WordEntity(id = 33019, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "kingdom", transliteration = "[ˈkɪŋdəm]", translation = "королевство",
            definition = "A country ruled by a king or queen, often passed down by birth.",
            definitionNative = "Страна, которой правит король или королева, часто по наследству.",
            example = "The old kingdom stretched from the sea to the mountains.",
            exampleNative = "Старое kingdom простиралось от моря до гор.",
            pos = "noun", semanticGroup = "politics_concepts", fillInBlankExclusions = listOf(33001L, 33004L, 33005L, 33016L, 33017L, 33018L, 33020L)),

        WordEntity(id = 33020, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "republic", transliteration = "[riˈpəblɪk]", translation = "республика",
            definition = "A country with no king — its head is chosen by the people.",
            definitionNative = "Страна без короля — её главу выбирает народ.",
            example = "France became a republic after a great revolution.",
            exampleNative = "Франция стала republic после великой революции.",
            pos = "noun", semanticGroup = "politics_concepts", fillInBlankExclusions = listOf(33001L, 33004L, 33016L, 33017L, 33019L)),

        // ── politics_war_peace (5) ───────────────────────────────────────

        WordEntity(id = 33021, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "war", transliteration = "[wɔr]", translation = "война",
            definition = "A long, bloody fight between two countries with armies and guns.",
            definitionNative = "Долгая кровавая борьба двух стран с армиями и оружием.",
            example = "Their grandfather fought in the great war of nineteen-forty.",
            exampleNative = "Их дед воевал в великой war сорокового года.",
            pos = "noun", semanticGroup = "politics_war_peace", fillInBlankExclusions = listOf(33012L, 33022L, 33023L, 33024L, 33025L)),

        WordEntity(id = 33022, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "army", transliteration = "[ˈɑrmi]", translation = "армия",
            definition = "All the soldiers who fight on land for a country in a war.",
            definitionNative = "Все солдаты, которые воюют за свою страну на суше.",
            example = "He joined the army at the age of eighteen.",
            exampleNative = "Он пошёл в army в восемнадцать лет.",
            pos = "noun", semanticGroup = "politics_war_peace", fillInBlankExclusions = listOf(33012L, 33021L, 33023L, 33024L, 33025L)),

        WordEntity(id = 33023, setId = 330, languagePair = "en-ru", rarity = "COMMON",
            original = "soldier", transliteration = "[ˈsoʊlʤər]", translation = "солдат",
            definition = "A man or woman in uniform who fights for their country.",
            definitionNative = "Мужчина или женщина в форме, воюющие за свою страну.",
            example = "A young soldier guarded the gate at the border.",
            exampleNative = "Молодой soldier охранял ворота на границе.",
            pos = "noun", semanticGroup = "politics_war_peace", fillInBlankExclusions = listOf(33006L, 33021L, 33022L, 33024L, 33025L)),

        WordEntity(id = 33024, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "weapon", transliteration = "[ˈwɛpən]", translation = "оружие",
            definition = "A tool made for hurting people — like a gun, knife or bomb.",
            definitionNative = "Орудие, сделанное для нанесения вреда людям — пушка, нож или бомба.",
            example = "Police found a hidden weapon under the seat of the car.",
            exampleNative = "Полиция нашла спрятанный weapon под сиденьем машины.",
            pos = "noun", semanticGroup = "politics_war_peace", fillInBlankExclusions = listOf(33003L, 33021L, 33022L, 33023L, 33025L)),

        WordEntity(id = 33025, setId = 330, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "embassy", transliteration = "[ˈɛmbəsi]", translation = "посольство",
            definition = "An official house of one country inside another's capital.",
            definitionNative = "Официальный дом одной страны внутри столицы другой.",
            example = "She went to the embassy to ask for a new passport.",
            exampleNative = "Она пошла в embassy просить новый паспорт.",
            pos = "noun", semanticGroup = "politics_war_peace", fillInBlankExclusions = listOf(33005L, 33021L, 33022L, 33023L, 33024L)),
    )
}
