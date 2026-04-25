package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Психология (level 1, основы / A1).
 *
 * Set 334: «Психология: основы» — базовая лексика про чувства, настроение
 * и мысли для повседневных разговоров (COMMON / UNCOMMON, преобладает COMMON).
 *
 * Дополняет уже существующие сеты темы «Психология» в en-ru:
 *   - Set 28, 35, 36 (WordDataEnglish.kt)         — L2 базовые эмоции/рост/отношения.
 *   - Set 45, 52, 53, 54 (WordDataEnglish.kt)     — L3 поведение/черты/процессы/риски.
 *   - Set 64, 71 (WordDataEnglish.kt)             — L4 опыт и ценности.
 *   - Set 81 (WordDataEnglish.kt)                 — L5 описание ума и характера.
 *   - Set 215 (WordDataEnglishExpanded.kt)        — L2 терминология психологии.
 *
 * Слова из этого сета не пересекаются ни с одним из 11 уже существующих
 * en-ru сетов темы «Психология» (проверено grep по `original = "..."`).
 * Cross-topic дубли с set 2 (verbs), 6 (adjectives), 12 (health), 236 (politics),
 * 266/267 (everyday life), 276 (greetings) — допустимы по политике проекта:
 * одно слово в разных темах не запрещено.
 *
 * SemanticGroups (5 × 5):
 *   psychology_emotions_positive  — happy, joy, hope, peace, calm
 *   psychology_emotions_negative  — sad, fear, hate, tired, cry
 *   psychology_processes          — think, dream, remember, forget, feel
 *   psychology_concepts           — mind, heart, soul, mood, smile
 *   psychology_actions            — laugh, want, need, like, love
 *
 * Word IDs: 33401..33425 (setId × 100 + position).
 */
object WordDataEnglishPsychologyL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 334, name = "Психология",
            description = "Базовая лексика про чувства, настроение и мысли для повседневных разговоров",
            languagePair = "en-ru",
            topic = "Психология", level = 1),
    )

    val words: List<WordEntity> = listOf(

        // ── psychology_emotions_positive (5) ──────────────────────────────

        WordEntity(id = 33401, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "happy", transliteration = "[ˈhæpi]", translation = "счастливый",
            definition = "Feeling good inside — like when you eat your favourite cake.",
            definitionNative = "Когда внутри тепло и хорошо — как от любимого пирожного.",
            example = "She was happy to see her best friend at the door.",
            exampleNative = "Она была happy, когда увидела лучшую подругу на пороге.",
            pos = "adjective", semanticGroup = "psychology_emotions_positive", fillInBlankExclusions = listOf(33405L, 33406L)),

        WordEntity(id = 33402, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "joy", transliteration = "[ʤɔɪ]", translation = "радость",
            definition = "A bright happy feeling — like jumping up when you win a game.",
            definitionNative = "Светлое весёлое чувство — когда хочется прыгать от победы.",
            example = "The children shouted with joy when they saw the puppy.",
            exampleNative = "Дети закричали от joy, увидев маленького щенка.",
            pos = "noun", semanticGroup = "psychology_emotions_positive", fillInBlankExclusions = listOf(33403L, 33404L, 33407L, 33417L)),

        WordEntity(id = 33403, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "hope", transliteration = "[hoʊp]", translation = "надежда",
            definition = "The feeling that something good can still happen — even after a bad day.",
            definitionNative = "Чувство, что хорошее ещё впереди — даже после неудачного дня.",
            example = "She still has hope that her brother will call tonight.",
            exampleNative = "У неё ещё есть hope, что брат позвонит вечером.",
            pos = "noun", semanticGroup = "psychology_emotions_positive", fillInBlankExclusions = listOf(33402L, 33404L, 33407L)),

        WordEntity(id = 33404, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "peace", transliteration = "[pis]", translation = "покой",
            definition = "A quiet calm feeling — no noise, no fight, no worry inside.",
            definitionNative = "Тихое внутреннее состояние — ни шума, ни ссоры, ни тревоги.",
            example = "I feel peace when I sit by the lake in the morning.",
            exampleNative = "У озера утром я чувствую глубокий peace в душе.",
            pos = "noun", semanticGroup = "psychology_emotions_positive", fillInBlankExclusions = listOf(33402L, 33403L, 33407L)),

        WordEntity(id = 33405, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "calm", transliteration = "[kɑm]", translation = "спокойный",
            definition = "Not worried or upset — breathing slowly, speaking softly.",
            definitionNative = "Без тревоги — дышит ровно, говорит мягко, не суетится.",
            example = "Try to stay calm and tell me what really happened.",
            exampleNative = "Постарайся быть calm и расскажи, что на самом деле случилось.",
            pos = "adjective", semanticGroup = "psychology_emotions_positive", fillInBlankExclusions = listOf(33401L, 33406L)),

        // ── psychology_emotions_negative (5) ──────────────────────────────

        WordEntity(id = 33406, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "sad", transliteration = "[sæd]", translation = "грустный",
            definition = "Feeling bad inside — like when a friend has to leave for a long time.",
            definitionNative = "Когда внутри плохо — как при долгом расставании с другом.",
            example = "He looked sad after he heard the bad news.",
            exampleNative = "Он выглядел sad, когда услышал плохие новости.",
            pos = "adjective", semanticGroup = "psychology_emotions_negative", fillInBlankExclusions = listOf(33401L, 33405L, 33409L)),

        WordEntity(id = 33407, setId = 334, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "fear", transliteration = "[fɪr]", translation = "страх",
            definition = "The feeling you get when something bad might hurt you — your heart beats fast.",
            definitionNative = "Чувство, когда что-то плохое может ранить — сердце стучит быстро.",
            example = "Her fear of the dark made her sleep with a small light on.",
            exampleNative = "Её fear темноты заставлял её спать с включённым ночником.",
            pos = "noun", semanticGroup = "psychology_emotions_negative", fillInBlankExclusions = listOf(33408L)),

        WordEntity(id = 33408, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "hate", transliteration = "[heɪt]", translation = "ненавидеть",
            definition = "To not like something at all — like rotten food or a cruel joke.",
            definitionNative = "Совсем не любить что-то — как испорченную еду или злую шутку.",
            example = "I hate cold soup but I love hot tea on rainy days.",
            exampleNative = "Я hate холодный суп, но обожаю горячий чай в дождь.",
            pos = "verb", semanticGroup = "psychology_emotions_negative", fillInBlankExclusions = listOf(33410L, 33422L, 33423L, 33424L)),

        WordEntity(id = 33409, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "tired", transliteration = "[taɪərd]", translation = "усталый",
            definition = "Wanting to rest — your body and head feel heavy after a long day.",
            definitionNative = "Хочется отдохнуть — тело и голова тяжёлые после долгого дня.",
            example = "She was too tired to cook and ordered pizza instead.",
            exampleNative = "Она была слишком tired, чтобы готовить, и заказала пиццу.",
            pos = "adjective", semanticGroup = "psychology_emotions_negative", fillInBlankExclusions = listOf(33401L, 33406L)),

        WordEntity(id = 33410, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "cry", transliteration = "[kraɪ]", translation = "плакать",
            definition = "To let tears fall from your eyes when you feel hurt or very sad.",
            definitionNative = "Ронять слёзы из глаз, когда обидно, больно или очень грустно.",
            example = "The little boy began to cry when he dropped his ice cream.",
            exampleNative = "Малыш начал cry, когда уронил мороженое на землю.",
            pos = "verb", semanticGroup = "psychology_emotions_negative", fillInBlankExclusions = listOf(33408L, 33411L, 33420L, 33421L)),

        // ── psychology_processes (5) ──────────────────────────────────────

        WordEntity(id = 33411, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "think", transliteration = "[θɪŋk]", translation = "думать",
            definition = "To use your head to make ideas — about a question, a plan or a person.",
            definitionNative = "Работать головой, складывая идеи — о задаче, плане или человеке.",
            example = "Let me think for a minute before I give you my answer.",
            exampleNative = "Дай мне think минутку, прежде чем я отвечу.",
            pos = "verb", semanticGroup = "psychology_processes", fillInBlankExclusions = listOf(33410L, 33412L, 33413L, 33414L, 33415L, 33420L, 33421L)),

        WordEntity(id = 33412, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "dream", transliteration = "[drim]", translation = "мечтать",
            definition = "To picture happy things in your head — at night in sleep or in the day.",
            definitionNative = "Рисовать в голове хорошее — во сне ночью или днём наяву.",
            example = "She likes to dream about travelling around the world someday.",
            exampleNative = "Ей нравится dream о путешествии вокруг света когда-нибудь.",
            pos = "verb", semanticGroup = "psychology_processes", fillInBlankExclusions = listOf(33411L, 33413L, 33414L, 33415L, 33421L)),

        WordEntity(id = 33413, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "remember", transliteration = "[rɪˈmɛmbər]", translation = "помнить",
            definition = "To keep something in your head — a face, a date or an old song.",
            definitionNative = "Хранить в голове — лицо, дату или старую песню.",
            example = "I still remember the first day I went to school.",
            exampleNative = "Я до сих пор remember свой первый день в школе.",
            pos = "verb", semanticGroup = "psychology_processes", fillInBlankExclusions = listOf(33408L, 33411L, 33412L, 33414L, 33415L, 33424L, 33425L)),

        WordEntity(id = 33414, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "forget", transliteration = "[fərˈɡɛt]", translation = "забывать",
            definition = "To lose something from your head — like a name or where you put your keys.",
            definitionNative = "Потерять что-то из головы — имя или место, куда положил ключи.",
            example = "Don't forget to lock the door before you leave the house.",
            exampleNative = "Не забудь forget — запри дверь перед уходом из дома.",
            pos = "verb", semanticGroup = "psychology_processes", fillInBlankExclusions = listOf(33411L, 33412L, 33413L, 33415L, 33423L)),

        WordEntity(id = 33415, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "feel", transliteration = "[fil]", translation = "чувствовать",
            definition = "To know something inside — joy, pain, cold or that a friend is sad.",
            definitionNative = "Знать что-то внутри — радость, боль, холод или грусть друга.",
            example = "I feel happy when my whole family sits at the table together.",
            exampleNative = "Я feel радость, когда вся семья садится за стол вместе.",
            pos = "verb", semanticGroup = "psychology_processes", fillInBlankExclusions = listOf(33411L, 33412L, 33413L, 33414L)),

        // ── psychology_concepts (5) ───────────────────────────────────────

        WordEntity(id = 33416, setId = 334, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mind", transliteration = "[maɪnd]", translation = "разум",
            definition = "The part of you that thinks and remembers — where ideas live.",
            definitionNative = "Часть тебя, которая думает и помнит — там живут идеи.",
            example = "A quiet walk helps me clear my mind after a long day.",
            exampleNative = "Тихая прогулка помогает мне очистить mind после долгого дня.",
            pos = "noun", semanticGroup = "psychology_concepts", fillInBlankExclusions = listOf(33417L, 33418L, 33419L)),

        WordEntity(id = 33417, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "heart", transliteration = "[hɑrt]", translation = "сердце",
            definition = "The place inside you where love and warm feelings live.",
            definitionNative = "Место внутри тебя, где живут любовь и тёплые чувства.",
            example = "Her warm heart helped many lonely children find a home.",
            exampleNative = "Её доброе heart помогло многим одиноким детям найти дом.",
            pos = "noun", semanticGroup = "psychology_concepts", fillInBlankExclusions = listOf(33416L, 33418L, 33419L)),

        WordEntity(id = 33418, setId = 334, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "soul", transliteration = "[soʊl]", translation = "душа",
            definition = "The deepest part of you — what makes you really you, not just your body.",
            definitionNative = "Самое глубокое в тебе — что делает тебя тобой, а не просто телом.",
            example = "Her grandmother had a kind soul that everyone in the village loved.",
            exampleNative = "У её бабушки была добрая soul, которую любила вся деревня.",
            pos = "noun", semanticGroup = "psychology_concepts", fillInBlankExclusions = listOf(33416L, 33417L, 33419L)),

        WordEntity(id = 33419, setId = 334, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mood", transliteration = "[mud]", translation = "настроение",
            definition = "How you feel right now — happy, sad, angry or just so-so.",
            definitionNative = "Как ты себя чувствуешь сейчас — весело, грустно, сердито или средне.",
            example = "He was in a great mood after passing all his exams.",
            exampleNative = "У него было прекрасное mood после сдачи всех экзаменов.",
            pos = "noun", semanticGroup = "psychology_concepts", fillInBlankExclusions = listOf(33416L, 33417L, 33418L)),

        WordEntity(id = 33420, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "smile", transliteration = "[smaɪl]", translation = "улыбаться",
            definition = "To turn up the corners of your mouth to show good feelings.",
            definitionNative = "Поднять уголки рта — показать, что тебе хорошо или приятно.",
            example = "The baby will smile every time she sees her mother.",
            exampleNative = "Малышка smile каждый раз, когда видит маму рядом.",
            pos = "verb", semanticGroup = "psychology_concepts", fillInBlankExclusions = listOf(33410L, 33421L)),

        // ── psychology_actions (5) ────────────────────────────────────────

        WordEntity(id = 33421, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "laugh", transliteration = "[læf]", translation = "смеяться",
            definition = "To make happy sounds with your voice when something is very funny.",
            definitionNative = "Издавать весёлые звуки голосом, когда что-то очень забавно.",
            example = "We laugh together every time we watch that old comedy.",
            exampleNative = "Мы вместе laugh каждый раз, когда смотрим эту старую комедию.",
            pos = "verb", semanticGroup = "psychology_actions", fillInBlankExclusions = listOf(33410L, 33411L, 33412L, 33413L, 33420L, 33422L, 33423L, 33424L, 33425L)),

        WordEntity(id = 33422, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "want", transliteration = "[wɔnt]", translation = "хотеть",
            definition = "To wish for something — like a toy, a cookie or a hug from your mum.",
            definitionNative = "Желать чего-то — игрушку, печенье или обнимашку от мамы.",
            example = "I want a glass of cold water after that long run.",
            exampleNative = "Я want стакан холодной воды после такой долгой пробежки.",
            pos = "verb", semanticGroup = "psychology_actions", fillInBlankExclusions = listOf(33421L, 33423L, 33424L, 33425L)),

        WordEntity(id = 33423, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "need", transliteration = "[nid]", translation = "нуждаться",
            definition = "To not be able to live well without something — like food, sleep or a friend.",
            definitionNative = "Не мочь нормально жить без чего-то — еды, сна или друга.",
            example = "Plants need water and sunlight to grow tall and strong.",
            exampleNative = "Растения need в воде и солнце, чтобы расти высокими.",
            pos = "verb", semanticGroup = "psychology_actions", fillInBlankExclusions = listOf(33421L, 33422L, 33424L, 33425L)),

        WordEntity(id = 33424, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "like", transliteration = "[laɪk]", translation = "нравиться",
            definition = "To find something nice or pleasant — but not as strong as love.",
            definitionNative = "Находить что-то милым или приятным — но слабее, чем любить.",
            example = "I like apples but I love sweet ripe peaches.",
            exampleNative = "Мне like яблоки, но я обожаю сладкие персики.",
            pos = "verb", semanticGroup = "psychology_actions", fillInBlankExclusions = listOf(33408L, 33421L, 33422L, 33423L)),

        WordEntity(id = 33425, setId = 334, languagePair = "en-ru", rarity = "COMMON",
            original = "love", transliteration = "[lʌv]", translation = "любить",
            definition = "To care a lot about someone or something — your family, your home, your dog.",
            definitionNative = "Очень дорожить кем-то или чем-то — семьёй, домом, собакой.",
            example = "I love my grandmother and visit her every weekend.",
            exampleNative = "Я love свою бабушку и навещаю её каждые выходные.",
            pos = "verb", semanticGroup = "psychology_actions", fillInBlankExclusions = listOf(33408L, 33413L, 33421L, 33422L, 33423L, 33424L)),
    )
}
