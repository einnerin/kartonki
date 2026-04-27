package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Эмоции и чувства (level 2, продвинутый / A2-B1).
 *
 * Set 361: «Эмоции и чувства» — социальные и средние состояния:
 * смущение, благодарность, надежда, разочарование, поддержка близких.
 * Распределение редкости: 13 UNCOMMON + 12 RARE (спред 2, как требует level 2).
 *
 * Параллельный сет того же топика — set 360 «Эмоции и чувства» (level 1, основы).
 * Темы «Психология» (set 28, 35, 36, 45, 52, 53, 54, 64, 71, 81, 215, 334) —
 * другие темы en-ru, слова не пересекаются (проверено grep'ом по `original`).
 *
 * SemanticGroups (5 × 5):
 *   emotions_social      — awkward, shy, envy, insecure, isolated
 *   emotions_gratitude   — thankful, kindness, considerate, generosity, appreciative
 *   emotions_hope        — eager, wish, expectation, anticipation, longing
 *   emotions_disappoint  — upset, regret, disheartened, let down, remorse
 *   emotions_relations   — care, sympathy, soothe, reassure, uplift
 *
 * Word IDs: 36101..36125 (setId × 100 + position).
 *
 * Все слова помечены `isFillInBlankSafe = false` — exclusions добавит pipeline
 * после фиксации сета (см. `docs/claude/fill-in-blank-pipeline.md`).
 */
object WordDataEnglishEmotionsL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 361, languagePair = "en-ru", orderIndex = 361,
            name = "Эмоции и чувства",
            description = "Социальные и средние состояния: смущение, благодарность, надежда, разочарование",
            topic = "Эмоции и чувства", level = 2),
    )

    val words: List<WordEntity> = listOf(

        // ── emotions_social (5) ───────────────────────────────────────────

        WordEntity(id = 36101, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "awkward", transliteration = "[ˈɔːkwərd]", translation = "неловкий",
            definition = "Feeling uneasy in a social moment — like spilling coffee on a stranger.",
            definitionNative = "Чувство неудобства в общении — как пролить кофе на незнакомца.",
            example = "There was an awkward silence after his joke fell flat.",
            exampleNative = "После его неудачной шутки повисла awkward тишина.",
            pos = "adjective", semanticGroup = "emotions_social", fillInBlankExclusions = listOf(36104L, 36105L, 36110L, 36111L, 36116L)),

        WordEntity(id = 36102, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "shy", transliteration = "[ʃaɪ]", translation = "застенчивый",
            definition = "Quiet around new people — afraid to speak up or stand out in a group.",
            definitionNative = "Тихий с новыми людьми — боится заговорить или выделиться.",
            example = "He felt shy when his teacher asked him to read aloud.",
            exampleNative = "Он чувствовал себя shy, когда учитель попросил его читать вслух.",
            pos = "adjective", semanticGroup = "emotions_social", fillInBlankExclusions = listOf(36101L, 36104L, 36105L, 36116L, 36118L)),

        WordEntity(id = 36103, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "envy", transliteration = "[ˈɛnvi]", translation = "зависть",
            definition = "A sour feeling when someone else has what you wish you had.",
            definitionNative = "Кислое чувство, когда у другого есть то, чего хочется тебе.",
            example = "She felt a bit of envy when her friend got the new job.",
            exampleNative = "Она ощутила лёгкую envy, когда подруга получила новую работу.",
            pos = "noun", semanticGroup = "emotions_social", fillInBlankExclusions = listOf(36117L, 36120L, 36122L)),

        WordEntity(id = 36104, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "insecure", transliteration = "[ˌɪnsɪˈkjʊr]", translation = "неуверенный в себе",
            definition = "Doubting yourself — afraid you are not good or smart enough.",
            definitionNative = "Сомневающийся в себе — боится, что недостаточно хорош или умён.",
            example = "She felt insecure about her accent when speaking in meetings.",
            exampleNative = "Она чувствовала себя insecure из-за акцента на совещаниях.",
            pos = "adjective", semanticGroup = "emotions_social", fillInBlankExclusions = listOf(36101L, 36102L, 36105L, 36116L, 36118L)),

        WordEntity(id = 36105, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "isolated", transliteration = "[ˈaɪsəleɪtɪd]", translation = "изолированный",
            definition = "Cut off from others — no friends nearby, no one to share the day with.",
            definitionNative = "Отрезанный от других — рядом нет друзей, не с кем поделиться днём.",
            example = "After moving abroad he felt isolated in his small apartment.",
            exampleNative = "Переехав за границу, он чувствовал себя isolated в маленькой квартире.",
            pos = "adjective", semanticGroup = "emotions_social", fillInBlankExclusions = listOf(36101L, 36102L, 36104L, 36116L, 36118L)),

        // ── emotions_gratitude (5) ────────────────────────────────────────

        WordEntity(id = 36106, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "thankful", transliteration = "[ˈθæŋkfəl]", translation = "благодарный",
            definition = "Glad and warm inside because someone helped you or treated you well.",
            definitionNative = "Радостный и тёплый внутри — кто-то помог или был добр к тебе.",
            example = "I am thankful for the warm meal after such a cold day.",
            exampleNative = "Я thankful за горячую еду после такого холодного дня.",
            pos = "adjective", semanticGroup = "emotions_gratitude", fillInBlankExclusions = listOf(36108L, 36110L)),

        WordEntity(id = 36107, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "kindness", transliteration = "[ˈkaɪndnəs]", translation = "доброта",
            definition = "Being warm and helpful to others — small acts that make someone's day better.",
            definitionNative = "Тепло и помощь другим — мелочи, которые делают чей-то день лучше.",
            example = "Her kindness to the lost child touched everyone in the shop.",
            exampleNative = "Её kindness к потерявшемуся ребёнку тронула всех в магазине.",
            pos = "noun", semanticGroup = "emotions_gratitude", fillInBlankExclusions = listOf(36109L)),

        WordEntity(id = 36108, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "considerate", transliteration = "[kənˈsɪdərət]", translation = "внимательный к другим",
            definition = "Thinking about other people's feelings before you speak or act.",
            definitionNative = "Думает о чувствах других, прежде чем сказать или сделать.",
            example = "It was considerate of him to bring soup when she was sick.",
            exampleNative = "Было considerate с его стороны принести суп, когда она болела.",
            pos = "adjective", semanticGroup = "emotions_gratitude", fillInBlankExclusions = listOf(36106L, 36110L)),

        WordEntity(id = 36109, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "generosity", transliteration = "[ˌʤɛnəˈrɑsəti]", translation = "щедрость",
            definition = "Willingness to give — time, money or help — without expecting anything back.",
            definitionNative = "Готовность отдавать — время, деньги, помощь — ничего не ожидая взамен.",
            example = "His generosity surprised the whole village after the flood.",
            exampleNative = "Его generosity поразила всю деревню после наводнения.",
            pos = "noun", semanticGroup = "emotions_gratitude", fillInBlankExclusions = listOf(36107L)),

        WordEntity(id = 36110, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "appreciative", transliteration = "[əˈpriʃətɪv]", translation = "признательный",
            definition = "Showing that you value what someone did — through words, smiles or a thank you note.",
            definitionNative = "Показывает, что ценит сделанное — словами, улыбкой или запиской.",
            example = "The teacher was appreciative of the small gift from her students.",
            exampleNative = "Учительница была appreciative за маленький подарок от учеников.",
            pos = "adjective", semanticGroup = "emotions_gratitude", fillInBlankExclusions = listOf(36106L, 36108L)),

        // ── emotions_hope (5) ─────────────────────────────────────────────

        WordEntity(id = 36111, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "eager", transliteration = "[ˈigər]", translation = "горящий желанием",
            definition = "Excited and ready — can hardly wait for something good to happen.",
            definitionNative = "Возбуждён и готов — едва может дождаться чего-то хорошего.",
            example = "The kids were eager to open their presents on the morning.",
            exampleNative = "Дети были eager поскорее открыть подарки утром.",
            pos = "adjective", semanticGroup = "emotions_hope"),

        WordEntity(id = 36112, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wish", transliteration = "[wɪʃ]", translation = "желать",
            definition = "To want something to come true — even if it seems unlikely right now.",
            definitionNative = "Хотеть, чтобы что-то сбылось — даже если это кажется маловероятным.",
            example = "I wish my brother could visit us for the holidays this year.",
            exampleNative = "Я wish, чтобы брат мог приехать к нам на праздники в этом году.",
            pos = "verb", semanticGroup = "emotions_hope"),

        WordEntity(id = 36113, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "expectation", transliteration = "[ˌɛkspɛkˈteɪʃən]", translation = "ожидание",
            definition = "A picture in your head of how something will turn out later.",
            definitionNative = "Картинка в голове о том, как что-то сложится — работа, поездка, встреча.",
            example = "Her expectation of the new film was higher than the film itself.",
            exampleNative = "Её expectation от нового фильма было выше, чем сам фильм.",
            pos = "noun", semanticGroup = "emotions_hope", fillInBlankExclusions = listOf(36114L, 36115L)),

        WordEntity(id = 36114, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "anticipation", transliteration = "[ænˌtɪsəˈpeɪʃən]", translation = "предвкушение",
            definition = "A pleasant tingle of waiting — counting the hours until something fun arrives.",
            definitionNative = "Приятное покалывание от ожидания — считаешь часы до чего-то весёлого.",
            example = "The children watched the clock with anticipation before the trip.",
            exampleNative = "Дети смотрели на часы с anticipation перед поездкой.",
            pos = "noun", semanticGroup = "emotions_hope", fillInBlankExclusions = listOf(36113L, 36115L)),

        WordEntity(id = 36115, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "longing", transliteration = "[ˈlɔŋɪŋ]", translation = "томление",
            definition = "A deep soft ache for someone or somewhere far away — home, a person, the sea.",
            definitionNative = "Тихая глубокая тоска по кому-то или чему-то далёкому — дому, человеку, морю.",
            example = "She felt a longing for her grandmother's old village every spring.",
            exampleNative = "Она ощущала longing по бабушкиной старой деревне каждую весну.",
            pos = "noun", semanticGroup = "emotions_hope"),

        // ── emotions_disappoint (5) ───────────────────────────────────────

        WordEntity(id = 36116, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "upset", transliteration = "[ʌpˈsɛt]", translation = "расстроенный",
            definition = "Feeling bad after something wrong happened — your voice may even shake a little.",
            definitionNative = "Плохо себя чувствуешь после неудачи — голос может даже дрогнуть.",
            example = "She was upset after losing her favourite scarf on the train.",
            exampleNative = "Она была upset, потеряв любимый шарф в поезде.",
            pos = "adjective", semanticGroup = "emotions_disappoint", fillInBlankExclusions = listOf(36101L, 36104L, 36118L)),

        WordEntity(id = 36117, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "regret", transliteration = "[rɪˈɡrɛt]", translation = "сожаление",
            definition = "A heavy feeling about a past choice you wish you had made differently.",
            definitionNative = "Тяжёлое чувство о прошлом выборе, который хотелось бы изменить.",
            example = "He spoke with deep regret about the words he had said.",
            exampleNative = "Он говорил с глубоким regret о сказанных тогда словах.",
            pos = "noun", semanticGroup = "emotions_disappoint", fillInBlankExclusions = listOf(36120L, 36122L)),

        WordEntity(id = 36118, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "disheartened", transliteration = "[dɪsˈhɑrtənd]", translation = "упавший духом",
            definition = "Losing your inner spark after a setback — energy gone, hope dimmed.",
            definitionNative = "Потерял внутренний огонь после неудачи — нет сил, надежда тускла.",
            example = "He felt disheartened after the third rejection from a publisher.",
            exampleNative = "Он чувствовал себя disheartened после третьего отказа издателя.",
            pos = "adjective", semanticGroup = "emotions_disappoint", fillInBlankExclusions = listOf(36101L, 36104L, 36116L)),

        WordEntity(id = 36119, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "let down", transliteration = "[lɛt daʊn]", translation = "подвести / разочаровать",
            definition = "To break a promise or hope — leaving someone sad because you did not show up.",
            definitionNative = "Нарушить обещание или надежду — оставить человека грустным.",
            example = "Don't let down your team during the most important game.",
            exampleNative = "Не let down свою команду в самой важной игре.",
            pos = "phrase", semanticGroup = "emotions_disappoint"),

        WordEntity(id = 36120, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "remorse", transliteration = "[rɪˈmɔrs]", translation = "раскаяние",
            definition = "A sharp painful sorrow for something bad you did — and a wish to fix it.",
            definitionNative = "Острая боль за что-то плохое, что сделал — и желание это исправить.",
            example = "He showed real remorse and wrote a long apology letter.",
            exampleNative = "Он проявил настоящее remorse и написал длинное письмо с извинениями.",
            pos = "noun", semanticGroup = "emotions_disappoint", fillInBlankExclusions = listOf(36117L)),

        // ── emotions_relations (5) ────────────────────────────────────────

        WordEntity(id = 36121, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "care", transliteration = "[kɛr]", translation = "заботиться",
            definition = "To watch over someone with warmth — make sure they are safe, fed, well.",
            definitionNative = "С теплом следить за кем-то — чтобы был в безопасности, сыт, здоров.",
            example = "She will care for her grandmother every weekend after work.",
            exampleNative = "Она будет care о бабушке каждые выходные после работы.",
            pos = "verb", semanticGroup = "emotions_relations", fillInBlankExclusions = listOf(36123L, 36124L, 36125L)),

        WordEntity(id = 36122, setId = 361, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sympathy", transliteration = "[ˈsɪmpəθi]", translation = "сочувствие",
            definition = "A soft feeling for another person's pain — sharing it from a distance.",
            definitionNative = "Мягкое чувство к чужой боли — разделять её на расстоянии.",
            example = "I felt sympathy for the family who lost their home in the fire.",
            exampleNative = "Я почувствовал sympathy к семье, потерявшей дом в пожаре.",
            pos = "noun", semanticGroup = "emotions_relations", fillInBlankExclusions = listOf(36103L, 36117L, 36120L)),

        WordEntity(id = 36123, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "soothe", transliteration = "[suð]", translation = "успокаивать",
            definition = "To make pain or fear softer — with a calm voice or a gentle touch.",
            definitionNative = "Смягчить боль или страх — спокойным голосом, чаем или мягкой рукой.",
            example = "The mother began to soothe her crying baby with a quiet song.",
            exampleNative = "Мама начала soothe плачущего малыша тихой песенкой.",
            pos = "verb", semanticGroup = "emotions_relations", fillInBlankExclusions = listOf(36121L, 36124L, 36125L)),

        WordEntity(id = 36124, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "reassure", transliteration = "[ˌriəˈʃʊr]", translation = "ободрять",
            definition = "To tell someone things will be okay — taking their worry away with calm words.",
            definitionNative = "Сказать, что всё будет хорошо — спокойными словами снять тревогу.",
            example = "The doctor tried to reassure the nervous patient before the test.",
            exampleNative = "Врач пытался reassure нервного пациента перед анализом.",
            pos = "verb", semanticGroup = "emotions_relations", fillInBlankExclusions = listOf(36121L, 36123L, 36125L)),

        WordEntity(id = 36125, setId = 361, languagePair = "en-ru", rarity = "RARE",
            original = "uplift", transliteration = "[ˌʌpˈlɪft]", translation = "поднимать дух",
            definition = "To lift someone's spirits — bring a small bit of light to a dark mood.",
            definitionNative = "Приподнять настроение — внести немного света в мрачное состояние.",
            example = "Her warm letter helped uplift his mood after a hard week.",
            exampleNative = "Её тёплое письмо помогло uplift его настроение после трудной недели.",
            pos = "verb", semanticGroup = "emotions_relations", fillInBlankExclusions = listOf(36121L, 36123L, 36124L)),
    )
}
