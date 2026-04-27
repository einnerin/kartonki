package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Эмоции и чувства (level 3, углублённый).
 *
 * Set 362: «Эмоции и чувства: углублённый» — B2/C1-лексика тонких эмоциональных
 * состояний: тревожность, ностальгия, амбивалентные чувства, гордость и стыд,
 * субтильные оттенки переживаний.
 *
 * Распределение редкости: 13 RARE + 12 EPIC — два смежных уровня шкалы (B2→C1).
 *
 * Дополняет уже существующие L1 (set 360) и L2 (set 361) той же темы
 * «Эмоции и чувства» (создаются параллельно). Не пересекается с темой
 * «Психология» (set 28, 35, 36, 45, 53, 64, 70, 71, 81, 215, 334).
 *
 * Слова из этого сета не дублируют ни «Психология», ни L1/L2 «Эмоции и чувства»
 * (проверено grep по `original = "..."`). Кросс-темные пересечения с другими
 * темами (Повседневная жизнь, Философия) допустимы по политике проекта.
 *
 * SemanticGroups (5 × 5):
 *   emotions_anxiety       — trepidation, dread, apprehension, unease, jitters
 *   emotions_nostalgia     — homesickness, yearning, sentimental, wistful, reminisce
 *   emotions_pride_shame   — pride, humiliation, dignity, vanity, mortified
 *   emotions_complex       — bittersweet, ambivalent, conflicted, torn, inner peace
 *   emotions_subtle        — awe, contentment, serenity, restless, fidgety
 *
 * Все слова помечены `isFillInBlankSafe = false` — эмоции легко взаимозаменяемы
 * в произвольных контекстах, FILL_IN_BLANK pipeline покроет позже.
 *
 * Word IDs: 36201..36225 (setId × 100 + position).
 */
object WordDataEnglishEmotionsL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 362, name = "Эмоции и чувства",
            description = "Углублённый: тонкие нюансы, ностальгия, амбивалентность, тревожность",
            languagePair = "en-ru",
            topic = "Эмоции и чувства", level = 3),
    )

    val words: List<WordEntity> = listOf(

        // ── emotions_anxiety (5) ─────────────────────────────────────────

        WordEntity(id = 36201, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "trepidation", transliteration = "[ˌtrɛpɪˈdeɪʃən]", translation = "трепет, боязливое волнение",
            definition = "A nervous fluttering feeling before something difficult or unknown.",
            definitionNative = "Внутренняя дрожь перед чем-то трудным или незнакомым впереди.",
            example = "She opened the letter with trepidation, expecting bad news.",
            exampleNative = "Она открыла письмо с trepidation, ожидая плохих новостей.",
            pos = "noun", semanticGroup = "emotions_anxiety", isFillInBlankSafe = false),

        WordEntity(id = 36202, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "dread", transliteration = "[drɛd]", translation = "ужас, страх перед чем-то",
            definition = "A heavy fear about something you know is coming — like an exam or surgery.",
            definitionNative = "Тяжёлое предчувствие плохого впереди — например, перед экзаменом или операцией.",
            example = "He felt a quiet dread every Sunday evening before the work week.",
            exampleNative = "Он чувствовал тихий dread каждое воскресенье перед рабочей неделей.",
            pos = "noun", semanticGroup = "emotions_anxiety", isFillInBlankSafe = false),

        WordEntity(id = 36203, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "apprehension", transliteration = "[ˌæprɪˈhɛnʃən]", translation = "опасение, тревожное предчувствие",
            definition = "A worried feeling that something might go wrong soon.",
            definitionNative = "Беспокойное ожидание, что вскоре может случиться неприятное.",
            example = "There was apprehension in her voice as she answered the phone.",
            exampleNative = "В её голосе слышалось apprehension, когда она ответила на звонок.",
            pos = "noun", semanticGroup = "emotions_anxiety", isFillInBlankSafe = false),

        WordEntity(id = 36204, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "unease", transliteration = "[ʌnˈiːz]", translation = "беспокойство, тревожность",
            definition = "A vague feeling that something is wrong, though you can't say what.",
            definitionNative = "Смутное чувство, что что-то не так, хотя непонятно, что именно.",
            example = "A growing unease filled the room as the meeting dragged on.",
            exampleNative = "В комнате нарастало unease, пока встреча затягивалась.",
            pos = "noun", semanticGroup = "emotions_anxiety", isFillInBlankSafe = false),

        WordEntity(id = 36205, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "jitters", transliteration = "[ˈdʒɪtərz]", translation = "мандраж, нервная дрожь",
            definition = "Shaky nervous feelings before a big moment — like a wedding or a flight.",
            definitionNative = "Тряска внутри перед важным событием — свадьбой, перелётом, выступлением.",
            example = "He had the jitters minutes before walking onto the stage.",
            exampleNative = "Его охватили jitters за минуты до выхода на сцену.",
            pos = "noun", semanticGroup = "emotions_anxiety", isFillInBlankSafe = false),

        // ── emotions_nostalgia (5) ────────────────────────────────────────

        WordEntity(id = 36206, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "homesickness", transliteration = "[ˈhoʊmsɪknəs]", translation = "тоска по дому",
            definition = "A sad longing for the place where you grew up or once lived.",
            definitionNative = "Грустное томление по родному месту, где вырос или жил раньше.",
            example = "Her homesickness grew stronger every winter she spent abroad.",
            exampleNative = "Её homesickness усиливалась с каждой зимой, проведённой за границей.",
            pos = "noun", semanticGroup = "emotions_nostalgia", isFillInBlankSafe = false),

        WordEntity(id = 36207, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "yearning", transliteration = "[ˈjɜːrnɪŋ]", translation = "томление, страстное желание",
            definition = "A deep aching wish for someone or something you can't easily reach.",
            definitionNative = "Глубокое щемящее влечение к кому-то или чему-то трудно достижимому.",
            example = "His letters were full of yearning for the woman he had left.",
            exampleNative = "Его письма были полны yearning по женщине, которую он оставил.",
            pos = "noun", semanticGroup = "emotions_nostalgia", isFillInBlankSafe = false),

        WordEntity(id = 36208, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "sentimental", transliteration = "[ˌsɛntɪˈmɛntəl]", translation = "сентиментальный",
            definition = "Easily moved by tender memories — old photos, songs, or family stories.",
            definitionNative = "Легко трогаемый тёплыми воспоминаниями — фото, песнями, семейными историями.",
            example = "Grandma gets sentimental whenever she sees her wedding album.",
            exampleNative = "Бабушка становится sentimental, как только видит свой свадебный альбом.",
            pos = "adjective", semanticGroup = "emotions_nostalgia", isFillInBlankSafe = false),

        WordEntity(id = 36209, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "wistful", transliteration = "[ˈwɪstfəl]", translation = "грустно-задумчивый",
            definition = "Quietly sad while thinking about something gone or out of reach.",
            definitionNative = "Тихо-печальный от мыслей о чём-то ушедшем или недостижимом.",
            example = "She gave a wistful glance at the empty playground from her childhood.",
            exampleNative = "Она бросила wistful взгляд на пустую детскую площадку.",
            pos = "adjective", semanticGroup = "emotions_nostalgia", isFillInBlankSafe = false),

        WordEntity(id = 36210, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "reminisce", transliteration = "[ˌrɛmɪˈnɪs]", translation = "предаваться воспоминаниям",
            definition = "To talk warmly about happy times from long ago.",
            definitionNative = "С теплом обсуждать счастливые моменты давно прошедшего времени.",
            example = "Old friends love to reminisce about their student years over wine.",
            exampleNative = "Старые друзья любят reminisce о студенческих годах за бокалом вина.",
            pos = "verb", semanticGroup = "emotions_nostalgia", isFillInBlankSafe = false),

        // ── emotions_pride_shame (5) ──────────────────────────────────────

        WordEntity(id = 36211, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "pride", transliteration = "[praɪd]", translation = "гордость",
            definition = "A warm feeling of pleasure when you or your family did something good.",
            definitionNative = "Тёплое чувство удовлетворения от своих или близких достижений.",
            example = "She watched her son graduate with pride shining in her eyes.",
            exampleNative = "Она смотрела, как сын получает диплом, с pride в глазах.",
            pos = "noun", semanticGroup = "emotions_pride_shame", isFillInBlankSafe = false),

        WordEntity(id = 36212, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "humiliation", transliteration = "[hjuːˌmɪliˈeɪʃən]", translation = "унижение",
            definition = "A burning shame from being made to look small in front of others.",
            definitionNative = "Жгучий стыд от того, что тебя выставили жалким перед другими.",
            example = "He still remembered the humiliation of falling on stage that night.",
            exampleNative = "Он до сих пор помнил humiliation от падения на сцене.",
            pos = "noun", semanticGroup = "emotions_pride_shame", isFillInBlankSafe = false),

        WordEntity(id = 36213, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "dignity", transliteration = "[ˈdɪɡnəti]", translation = "достоинство",
            definition = "A calm, self-respecting way of carrying yourself even in hard moments.",
            definitionNative = "Спокойная самоуважительная манера держаться даже в трудные минуты.",
            example = "She left the room with quiet dignity after the harsh words.",
            exampleNative = "Она вышла из комнаты с тихим dignity после резких слов.",
            pos = "noun", semanticGroup = "emotions_pride_shame", isFillInBlankSafe = false),

        WordEntity(id = 36214, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "vanity", transliteration = "[ˈvænəti]", translation = "тщеславие",
            definition = "Too much love for one's looks or success — wanting others to admire you.",
            definitionNative = "Чрезмерная любовь к своей внешности или успеху, желание восхищения.",
            example = "His vanity made him check the mirror at every café window.",
            exampleNative = "Vanity заставляла его проверять отражение в каждой витрине кафе.",
            pos = "noun", semanticGroup = "emotions_pride_shame", isFillInBlankSafe = false),

        WordEntity(id = 36215, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "mortified", transliteration = "[ˈmɔːrtɪfaɪd]", translation = "сгорающий со стыда",
            definition = "So embarrassed you wish you could disappear into the ground.",
            definitionNative = "Так смущён, что хочется провалиться сквозь землю на месте.",
            example = "She was mortified when her father told that joke at the dinner.",
            exampleNative = "Она была mortified, когда отец рассказал ту шутку на ужине.",
            pos = "adjective", semanticGroup = "emotions_pride_shame", isFillInBlankSafe = false),

        // ── emotions_complex (5) ──────────────────────────────────────────

        WordEntity(id = 36216, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "bittersweet", transliteration = "[ˌbɪtərˈswiːt]", translation = "горько-сладкий",
            definition = "Mixing happiness and sadness at once — like a graduation or a farewell.",
            definitionNative = "Смесь радости и грусти одновременно — как выпускной или прощание.",
            example = "Her last day at the school felt bittersweet for everyone.",
            exampleNative = "Её последний день в школе был bittersweet для всех вокруг.",
            pos = "adjective", semanticGroup = "emotions_complex", isFillInBlankSafe = false),

        WordEntity(id = 36217, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "ambivalent", transliteration = "[æmˈbɪvələnt]", translation = "испытывающий противоречивые чувства",
            definition = "Pulled both ways at once — wanting and not wanting the same thing.",
            definitionNative = "Тянет в обе стороны сразу — одновременно хочется и не хочется.",
            example = "He felt ambivalent about the new job offer all weekend long.",
            exampleNative = "Он был ambivalent насчёт нового предложения о работе все выходные.",
            pos = "adjective", semanticGroup = "emotions_complex", isFillInBlankSafe = false),

        WordEntity(id = 36218, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "conflicted", transliteration = "[kənˈflɪktɪd]", translation = "испытывающий внутренний конфликт",
            definition = "Stuck between two opposite choices that both feel partly right.",
            definitionNative = "Застрявший между двумя выборами, каждый из которых отчасти правильный.",
            example = "She felt conflicted about telling her best friend the truth.",
            exampleNative = "Она была conflicted, говорить ли подруге всю правду.",
            pos = "adjective", semanticGroup = "emotions_complex", isFillInBlankSafe = false),

        WordEntity(id = 36219, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "torn", transliteration = "[tɔːrn]", translation = "разрывающийся между двумя вариантами",
            definition = "Painfully unable to choose — your heart pulls you in two directions.",
            definitionNative = "Болезненно не можешь выбрать — сердце тянет в две стороны.",
            example = "He was torn between staying with his family and chasing the dream.",
            exampleNative = "Он был torn между семьёй и погоней за мечтой.",
            pos = "adjective", semanticGroup = "emotions_complex", isFillInBlankSafe = false),

        WordEntity(id = 36220, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "inner peace", transliteration = "[ˈɪnər piːs]", translation = "внутренний покой",
            definition = "A deep calm inside, holding firm no matter the chaos outside.",
            definitionNative = "Устойчивое равновесие ума, которое не рушится даже в шторм снаружи.",
            example = "After years of meditation she finally found inner peace.",
            exampleNative = "После лет медитации она наконец обрела inner peace.",
            pos = "phrase", semanticGroup = "emotions_complex", isFillInBlankSafe = false),

        // ── emotions_subtle (5) ───────────────────────────────────────────

        WordEntity(id = 36221, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "awe", transliteration = "[ɔː]", translation = "благоговение, восторг",
            definition = "A breath-stopping wonder before something huge — mountains, the sea, a great song.",
            definitionNative = "Захватывающее восхищение перед огромным — горами, морем, великой песней.",
            example = "The children stood in awe before the giant blue whale skeleton.",
            exampleNative = "Дети стояли в awe перед огромным скелетом синего кита.",
            pos = "noun", semanticGroup = "emotions_subtle", isFillInBlankSafe = false),

        WordEntity(id = 36222, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "contentment", transliteration = "[kənˈtɛntmənt]", translation = "удовлетворённость",
            definition = "A quiet sense that life is enough right now — nothing more is needed.",
            definitionNative = "Тихое ощущение, что жизни сейчас хватает — большего не нужно.",
            example = "He sighed with contentment as the warm bread came out of the oven.",
            exampleNative = "Он вздохнул с contentment, когда тёплый хлеб вышел из печи.",
            pos = "noun", semanticGroup = "emotions_subtle", isFillInBlankSafe = false),

        WordEntity(id = 36223, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "serenity", transliteration = "[səˈrɛnəti]", translation = "безмятежность",
            definition = "Deep stillness in the soul — like a lake on a windless morning.",
            definitionNative = "Глубокая тишина в душе — как озеро в безветренное утро.",
            example = "The garden gave her a rare moment of serenity that afternoon.",
            exampleNative = "Сад дал ей редкое мгновение serenity в тот полдень.",
            pos = "noun", semanticGroup = "emotions_subtle", isFillInBlankSafe = false),

        WordEntity(id = 36224, setId = 362, languagePair = "en-ru", rarity = "RARE",
            original = "restless", transliteration = "[ˈrɛstləs]", translation = "беспокойный, неугомонный",
            definition = "Unable to sit still or relax — full of nervous energy with no outlet.",
            definitionNative = "Не способен усидеть на месте — полон нервной энергии без выхода.",
            example = "He grew restless after three days stuck inside the small flat.",
            exampleNative = "Он стал restless после трёх дней в маленькой квартире.",
            pos = "adjective", semanticGroup = "emotions_subtle", isFillInBlankSafe = false),

        WordEntity(id = 36225, setId = 362, languagePair = "en-ru", rarity = "EPIC",
            original = "fidgety", transliteration = "[ˈfɪdʒɪti]", translation = "ёрзающий, непоседливый",
            definition = "Making small nervous movements — tapping, shifting, twisting hands.",
            definitionNative = "Совершающий мелкие нервные движения — постукивает, дёргается, крутит руки.",
            example = "The fidgety student tapped his pen all through the long lecture.",
            exampleNative = "Fidgety студент стучал ручкой всю долгую лекцию.",
            pos = "adjective", semanticGroup = "emotions_subtle", isFillInBlankSafe = false),
    )
}
