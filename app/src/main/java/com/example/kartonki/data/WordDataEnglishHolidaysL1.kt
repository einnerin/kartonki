package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Праздники и традиции (L1, COMMON+UNCOMMON).
 *
 * Set 370: «Праздники и традиции» — основы.
 *          Дни рождения, подарки, поздравления, гости и совместные действия
 *          на праздниках.
 *
 * Не пересекается с темами «Семья» (set 8: family/friend/parent…),
 * «Еда и кулинария» (set 9: cake), «Развлечения и досуг» (set 351-353:
 * party, friend) — слова из этих сетов исключены по требованию.
 *
 * Не пересекается со смежными уровнями той же темы:
 *   - Set 371 L2 (decoration, garland, ceremony, invitation, feast…),
 *   - Set 372 L3 (Christmas, Halloween, wedding, toast, fireworks…),
 *   - Set 373 L4 (Diwali, ritual, harvest festival, public holiday…),
 *   - Set 374 L5 (liminality, communitas, Yom Kippur, Holi…).
 *
 * Cross-topic совпадения допустимы и встречаются:
 *   - candle, balloon, confetti, wrapping, ribbon → set 202 «Культура и
 *     искусство» (semanticGroup `celebrations`).
 *   - applause → set 321 «Культура и искусство».
 *   - bow («бант») → set 275 «Одежда».
 *   - sing, dance → set 267, 202 (разные темы).
 *   - invite, clap → set 277 «Лингвистика».
 *   - birthday → set 265 «Повседневная жизнь».
 *   - host, guest, gift, surprise → различные темы (Шоппинг, Игры).
 *
 * Распределение редкости: 13 COMMON + 12 UNCOMMON — два смежных уровня.
 *
 * SemanticGroups (5 × 5):
 *   holidays_basic_birthday   — birthday, candle, balloon, confetti, streamer
 *   holidays_basic_gifts      — gift, surprise, wrapping, ribbon, bow
 *   holidays_basic_greetings  — congratulations, wishes, cheers, hooray, applause
 *   holidays_basic_gathering  — guest, host, family meal, get-together, celebration
 *   holidays_basic_actions    — invite, decorate, sing, dance, clap
 *
 * Word IDs: setId × 100 + position (37001..37025).
 *
 * isFillInBlankSafe = false на всех словах (требование ТЗ).
 * fillInBlankExclusions пустые — заполнятся через FILL_IN_BLANK pipeline.
 */
object WordDataEnglishHolidaysL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 370,
            languagePair = "en-ru",
            orderIndex = 370,
            name = "Праздники и традиции",
            description = "Базовая лексика: дни рождения, подарки, поздравления, праздничный стол",
            topic = "Праздники и традиции",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 370 — Праздники и традиции: основы (L1, COMMON+UNCOMMON)     ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── holidays_basic_birthday (5) ───────────────────────────────────

        WordEntity(id = 37001, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "birthday", transliteration = "[ˈbərθˌdeɪ]", translation = "день рождения",
            definition = "The yearly date when people mark another year of someone's life.",
            definitionNative = "Праздник в честь того, что человек прожил ещё один год.",
            example = "My little sister had a birthday last week and turned six.",
            exampleNative = "У младшей сестры на прошлой неделе был birthday — ей исполнилось шесть.",
            pos = "noun", semanticGroup = "holidays_basic_birthday",
            isFillInBlankSafe = false),

        WordEntity(id = 37002, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "candle", transliteration = "[ˈkændəl]", translation = "свеча",
            definition = "A small wax stick with a string inside that gives a tiny flame.",
            definitionNative = "Маленькая восковая палочка с фитилём внутри, дающая огонёк.",
            example = "She lit a small candle on top of the chocolate cupcake.",
            exampleNative = "Она зажгла маленькую candle на шоколадном кексе.",
            pos = "noun", semanticGroup = "holidays_basic_birthday",
            isFillInBlankSafe = false),

        WordEntity(id = 37003, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "balloon", transliteration = "[bəˈlun]", translation = "воздушный шарик",
            definition = "A thin rubber bag filled with gas — usually round and bright.",
            definitionNative = "Тонкий резиновый мешочек, надутый газом или дыханием — круглый и яркий.",
            example = "The kids tied a red balloon to every chair at the table.",
            exampleNative = "Дети привязали красный balloon к каждому стулу у стола.",
            pos = "noun", semanticGroup = "holidays_basic_birthday",
            isFillInBlankSafe = false),

        WordEntity(id = 37004, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "confetti", transliteration = "[kənˈfɛti]", translation = "конфетти",
            definition = "Tiny pieces of coloured paper that people throw up in the air.",
            definitionNative = "Маленькие кусочки цветной бумаги, которые подбрасывают в воздух.",
            example = "Bright confetti fell on us as the music started playing.",
            exampleNative = "Яркое confetti посыпалось на нас, когда зазвучала музыка.",
            pos = "noun", semanticGroup = "holidays_basic_birthday",
            isFillInBlankSafe = false),

        WordEntity(id = 37005, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "streamer", transliteration = "[ˈstrimər]", translation = "серпантин",
            definition = "A long thin strip of coloured paper hung up or thrown for fun.",
            definitionNative = "Длинная тонкая полоска цветной бумаги — её вешают или бросают для веселья.",
            example = "Pink and gold streamer hung from the ceiling above the dance floor.",
            exampleNative = "Розовый и золотой streamer свисал с потолка над танцполом.",
            pos = "noun", semanticGroup = "holidays_basic_birthday",
            isFillInBlankSafe = false),

        // ── holidays_basic_gifts (5) ──────────────────────────────────────

        WordEntity(id = 37006, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "gift", transliteration = "[ɡɪft]", translation = "подарок",
            definition = "Something nice given to a person from the heart, not for money.",
            definitionNative = "Что-то приятное, что один человек передаёт другому от чистого сердца.",
            example = "Grandma brought a small gift for every child in the room.",
            exampleNative = "Бабушка принесла маленький gift для каждого ребёнка в комнате.",
            pos = "noun", semanticGroup = "holidays_basic_gifts",
            isFillInBlankSafe = false),

        WordEntity(id = 37007, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "surprise", transliteration = "[sərˈpraɪz]", translation = "сюрприз",
            definition = "Something unexpected that makes a person feel happy or amazed.",
            definitionNative = "Что-то неожиданное, отчего человек чувствует радость или изумление.",
            example = "We hid behind the door and shouted \"Surprise!\" when she came in.",
            exampleNative = "Мы спрятались за дверью и крикнули \"Surprise!\", когда она вошла.",
            pos = "noun", semanticGroup = "holidays_basic_gifts",
            isFillInBlankSafe = false),

        WordEntity(id = 37008, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wrapping", transliteration = "[ˈræpɪŋ]", translation = "упаковочная бумага",
            definition = "A pretty cover around a present that hides what is inside.",
            definitionNative = "Красивый слой вокруг подарка — он скрывает то, что внутри.",
            example = "The kids tore the shiny wrapping off their boxes in seconds.",
            exampleNative = "Дети за секунды разорвали блестящую wrapping на своих коробках.",
            pos = "noun", semanticGroup = "holidays_basic_gifts",
            isFillInBlankSafe = false),

        WordEntity(id = 37009, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "ribbon", transliteration = "[ˈrɪbən]", translation = "лента",
            definition = "A long thin piece of cloth used to tie or decorate gifts.",
            definitionNative = "Длинная тонкая полоска ткани — ею завязывают и украшают подарки.",
            example = "She tied a red ribbon around the small wooden jewellery box.",
            exampleNative = "Она завязала красную ribbon вокруг маленькой деревянной шкатулки.",
            pos = "noun", semanticGroup = "holidays_basic_gifts",
            isFillInBlankSafe = false),

        WordEntity(id = 37010, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "bow", transliteration = "[boʊ]", translation = "бант",
            definition = "A pretty knot with two loops, often on top of a present.",
            definitionNative = "Красивый узел с двумя петлями — часто его делают сверху подарка.",
            example = "He stuck a big silver bow on top of the wrapped box.",
            exampleNative = "Он прилепил большой серебряный bow на завёрнутую коробку.",
            pos = "noun", semanticGroup = "holidays_basic_gifts",
            isFillInBlankSafe = false),

        // ── holidays_basic_greetings (5) ──────────────────────────────────

        WordEntity(id = 37011, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "congratulations", transliteration = "[kənˌɡræʧəˈleɪʃənz]", translation = "поздравления",
            definition = "Warm words you say when someone has good news or a success.",
            definitionNative = "Тёплые слова, когда у человека хорошая новость или достижение.",
            example = "Big congratulations on your new job — we're proud of you!",
            exampleNative = "Большие congratulations с новой работой — мы гордимся тобой!",
            pos = "interjection", semanticGroup = "holidays_basic_greetings",
            isFillInBlankSafe = false),

        WordEntity(id = 37012, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wishes", transliteration = "[ˈwɪʃɪz]", translation = "пожелания",
            definition = "Kind words about good things you hope will come to someone.",
            definitionNative = "Добрые слова о хорошем, что человек, по-твоему, должен получить.",
            example = "Please send my warmest wishes to your parents on their anniversary.",
            exampleNative = "Передай мои самые тёплые wishes твоим родителям на годовщину.",
            pos = "noun", semanticGroup = "holidays_basic_greetings",
            isFillInBlankSafe = false),

        WordEntity(id = 37013, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "cheers", transliteration = "[ʧɪrz]", translation = "будем здоровы! (за столом)",
            definition = "What people shout while clinking glasses before drinking together.",
            definitionNative = "То, что кричат, чокаясь бокалами, прежде чем выпить вместе.",
            example = "We raised our glasses and shouted \"Cheers!\" before the meal began.",
            exampleNative = "Мы подняли бокалы и крикнули \"Cheers!\" перед началом ужина.",
            pos = "interjection", semanticGroup = "holidays_basic_greetings",
            isFillInBlankSafe = false),

        WordEntity(id = 37014, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hooray", transliteration = "[hʊˈreɪ]", translation = "ура!",
            definition = "A loud happy shout when something great or fun has happened.",
            definitionNative = "Громкий радостный возглас, когда случилось что-то отличное или весёлое.",
            example = "The kids shouted hooray when they saw the huge cake on the table.",
            exampleNative = "Дети закричали hooray, увидев огромный торт на столе.",
            pos = "interjection", semanticGroup = "holidays_basic_greetings",
            isFillInBlankSafe = false),

        WordEntity(id = 37015, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "applause", transliteration = "[əˈplɔz]", translation = "аплодисменты",
            definition = "The loud sound of many hands hitting together to show you liked it.",
            definitionNative = "Громкий звук, когда много рук бьют друг о друга в знак одобрения.",
            example = "Loud applause filled the room after grandfather's short speech.",
            exampleNative = "Громкие applause заполнили комнату после короткой речи дедушки.",
            pos = "noun", semanticGroup = "holidays_basic_greetings",
            isFillInBlankSafe = false),

        // ── holidays_basic_gathering (5) ──────────────────────────────────

        WordEntity(id = 37016, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "guest", transliteration = "[ɡɛst]", translation = "гость",
            definition = "A person who comes to visit your home for a meal or event.",
            definitionNative = "Человек, который пришёл к тебе домой на ужин или мероприятие.",
            example = "Every guest at the table received a small bag of sweets.",
            exampleNative = "Каждый guest за столом получил маленький мешочек со сладостями.",
            pos = "noun", semanticGroup = "holidays_basic_gathering",
            isFillInBlankSafe = false),

        WordEntity(id = 37017, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "host", transliteration = "[hoʊst]", translation = "хозяин (принимающий гостей)",
            definition = "The person who invites others home and looks after them there.",
            definitionNative = "Человек, который зовёт других к себе домой и заботится о них.",
            example = "As the host, my dad poured wine for every adult at dinner.",
            exampleNative = "Как host, папа разлил вино каждому взрослому за ужином.",
            pos = "noun", semanticGroup = "holidays_basic_gathering",
            isFillInBlankSafe = false),

        WordEntity(id = 37018, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "family meal", transliteration = "[ˈfæməli mil]", translation = "семейный ужин",
            definition = "A time when everyone at home sits together and eats one big meal.",
            definitionNative = "Время, когда все домашние садятся вместе и едят за общим столом.",
            example = "Every Sunday we have a long family meal at grandma's place.",
            exampleNative = "Каждое воскресенье у бабушки у нас долгий family meal.",
            pos = "noun", semanticGroup = "holidays_basic_gathering",
            isFillInBlankSafe = false),

        WordEntity(id = 37019, setId = 370, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "get-together", transliteration = "[ˈɡɛtəˌɡɛðər]", translation = "посиделки",
            definition = "A small friendly meeting at someone's home with food and chat.",
            definitionNative = "Небольшая дружеская встреча у кого-то дома с едой и разговорами.",
            example = "We're having a quiet get-together at my place this Saturday evening.",
            exampleNative = "В субботу у меня дома будет тихий get-together.",
            pos = "noun", semanticGroup = "holidays_basic_gathering",
            isFillInBlankSafe = false),

        WordEntity(id = 37020, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "celebration", transliteration = "[ˌsɛləˈbreɪʃən]", translation = "торжество",
            definition = "A happy event held to mark something special, like a birthday.",
            definitionNative = "Радостное событие в честь чего-то особенного — например, дня рождения.",
            example = "The whole street came to the celebration of my grandparents' golden anniversary.",
            exampleNative = "Вся улица пришла на celebration золотой годовщины моих бабушки и дедушки.",
            pos = "noun", semanticGroup = "holidays_basic_gathering",
            isFillInBlankSafe = false),

        // ── holidays_basic_actions (5) ────────────────────────────────────

        WordEntity(id = 37021, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "invite", transliteration = "[ɪnˈvaɪt]", translation = "приглашать",
            definition = "Ask someone in a friendly way to come to a meal or event.",
            definitionNative = "Дружелюбно позвать человека на ужин, праздник или другое событие.",
            example = "I want to invite my whole class to my tenth birthday party.",
            exampleNative = "Я хочу invite весь свой класс на десятый день рождения.",
            pos = "verb", semanticGroup = "holidays_basic_actions",
            isFillInBlankSafe = false),

        WordEntity(id = 37022, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "decorate", transliteration = "[ˈdɛkəˌreɪt]", translation = "украшать",
            definition = "Add pretty things to a room so it looks more festive and bright.",
            definitionNative = "Добавлять в комнату красивые вещи, чтобы стало нарядно и ярко.",
            example = "We will decorate the living room before the guests arrive tonight.",
            exampleNative = "Мы будем decorate гостиную до того, как вечером придут гости.",
            pos = "verb", semanticGroup = "holidays_basic_actions",
            isFillInBlankSafe = false),

        WordEntity(id = 37023, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "sing", transliteration = "[sɪŋ]", translation = "петь",
            definition = "Make music with your voice — alone, in a choir or with friends.",
            definitionNative = "Делать голосом музыку — одному, в хоре или вместе с друзьями.",
            example = "We always sing the same old song before blowing out the candles.",
            exampleNative = "Мы всегда sing одну и ту же старую песню перед тем, как задуть свечи.",
            pos = "verb", semanticGroup = "holidays_basic_actions",
            isFillInBlankSafe = false),

        WordEntity(id = 37024, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "dance", transliteration = "[dæns]", translation = "танцевать",
            definition = "Move your body to music in a fun or graceful way.",
            definitionNative = "Двигать телом под музыку — весело или изящно.",
            example = "Grandpa started to dance with grandma right after the toast.",
            exampleNative = "Дедушка начал dance с бабушкой сразу после тоста.",
            pos = "verb", semanticGroup = "holidays_basic_actions",
            isFillInBlankSafe = false),

        WordEntity(id = 37025, setId = 370, languagePair = "en-ru", rarity = "COMMON",
            original = "clap", transliteration = "[klæp]", translation = "хлопать в ладоши",
            definition = "Hit your hands together over and over to show you liked something.",
            definitionNative = "Бить рукой об руку много раз — в знак того, что очень понравилось.",
            example = "Everyone began to clap when the little boy finished his song.",
            exampleNative = "Все стали clap, когда маленький мальчик закончил свою песню.",
            pos = "verb", semanticGroup = "holidays_basic_actions",
            isFillInBlankSafe = false),
    )
}
