package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Идиомы и устойчивые выражения (L1, UNCOMMON+RARE).
 *
 * Set 405: «Идиомы и устойчивые выражения» — основы.
 *          Базовые англоязычные идиомы уровня B1-B2: фразы, у которых
 *          смысл не складывается из значений отдельных слов. Это первый
 *          сет совершенно новой темы в репо — идиомы как класс лексики
 *          никогда раньше не выделялись отдельным набором.
 *
 * ⚠️ Идиомы по определению редко бывают COMMON по объективному CEFR —
 * даже самые «детские» piece of cake и break a leg это уже B1+, потому
 * что требуют понимания переносного смысла. Поэтому на L1 этой темы
 * COMMON-слов нет: 17 UNCOMMON (B1) + 8 RARE (B2). Это два смежных
 * уровня, правило разброса соблюдено.
 *
 * Дублей с существующими английскими наборами нет — идиомы как
 * многословные phrase-формы в базе раньше не встречались, проверено
 * grep'ом по `original = "..."` для всех 25 фраз. Базовая лексика типа
 * «leg», «cake», «boat», «road» живёт в других сетах как отдельные
 * существительные — наши же фразы — это самостоятельные единицы.
 *
 * Распределение редкости: 17 UNCOMMON (B1) + 8 RARE (B2).
 *
 * SemanticGroups (5 × 5):
 *   idioms_l1_money         — cost an arm and a leg, break the bank,
 *                             pay through the nose, on a tight budget,
 *                             foot the bill
 *   idioms_l1_emotions      — over the moon, on cloud nine, down in
 *                             the dumps, get cold feet, butterflies
 *                             in the stomach
 *   idioms_l1_communication — beat around the bush, cut to the chase,
 *                             spill the beans, on the same page,
 *                             hit the nail on the head
 *   idioms_l1_situations    — piece of cake, in hot water, kill two
 *                             birds with one stone, miss the boat,
 *                             under the weather
 *   idioms_l1_actions       — call it a day, hit the road, break a leg,
 *                             pull yourself together, bite the bullet
 *
 * Word IDs: setId × 100 + position (40501..40525).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions пустые — заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishIdiomsL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 405,
            languagePair = "en-ru",
            orderIndex = 405,
            name = "Идиомы и устойчивые выражения",
            description = "Идиомы о деньгах, эмоциях, общении, ситуациях и действиях",
            topic = "Идиомы и устойчивые выражения",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 405 — Идиомы: основы (L1, UNCOMMON+RARE)                     ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── idioms_l1_money (5) ───────────────────────────────────────────

        WordEntity(id = 40501, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cost an arm and a leg", transliteration = "[kɔst ən ɑrm ənd ə lɛɡ]", translation = "стоить очень дорого (≈ «как чугунный мост»)",
            definition = "If something costs an arm and a leg, it is very expensive.",
            definitionNative = "Если что-то «стоит руки и ноги», значит, оно очень дорогое. Дословно — «стоить руку и ногу».",
            example = "A new iPhone can cost an arm and a leg these days.",
            exampleNative = "Новый айфон сейчас может cost an arm and a leg.",
            pos = "phrase", semanticGroup = "idioms_l1_money", fillInBlankExclusions = listOf(40502L, 40503L, 40504L, 40505L)),

        WordEntity(id = 40502, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "break the bank", transliteration = "[breɪk ðə bæŋk]", translation = "разорить (≈ пробить дыру в бюджете)",
            definition = "To use up all your money or cost more than you can afford.",
            definitionNative = "Потратить все деньги или стоить больше, чем можешь себе позволить. Дословно — «сломать банк».",
            example = "Don't worry, a small gift won't break the bank.",
            exampleNative = "Не переживай, маленький подарок не break the bank.",
            pos = "phrase", semanticGroup = "idioms_l1_money", fillInBlankExclusions = listOf(40501L, 40503L, 40504L, 40505L)),

        WordEntity(id = 40503, setId = 405, languagePair = "en-ru", rarity = "RARE",
            original = "pay through the nose", transliteration = "[peɪ θru ðə noʊz]", translation = "платить втридорога",
            definition = "To pay much more for something than it is really worth.",
            definitionNative = "Платить намного больше, чем что-то реально стоит. Дословно — «платить через нос».",
            example = "We had to pay through the nose for tickets at the last minute.",
            exampleNative = "Нам пришлось pay through the nose за билеты в последний момент.",
            pos = "phrase", semanticGroup = "idioms_l1_money", fillInBlankExclusions = listOf(40501L, 40502L, 40504L, 40505L)),

        WordEntity(id = 40504, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "on a tight budget", transliteration = "[ɑn ə taɪt ˈbʌʤɪt]", translation = "при ограниченном бюджете",
            definition = "Having very little money to spend, so you have to be careful.",
            definitionNative = "Иметь очень мало денег, поэтому приходится быть осторожным. Дословно — «на тугом/тесном бюджете».",
            example = "We're on a tight budget this month, so no eating out.",
            exampleNative = "В этом месяце мы on a tight budget, так что никаких ресторанов.",
            pos = "phrase", semanticGroup = "idioms_l1_money", fillInBlankExclusions = listOf(40501L, 40502L, 40503L, 40505L)),

        WordEntity(id = 40505, setId = 405, languagePair = "en-ru", rarity = "RARE",
            original = "foot the bill", transliteration = "[fʊt ðə bɪl]", translation = "оплатить счёт (≈ раскошелиться)",
            definition = "To pay for something, especially a large or shared cost.",
            definitionNative = "Заплатить за что-то, особенно крупное или общее. Дословно — «подножить счёт».",
            example = "Her parents agreed to foot the bill for the whole wedding.",
            exampleNative = "Её родители согласились foot the bill за всю свадьбу.",
            pos = "phrase", semanticGroup = "idioms_l1_money", fillInBlankExclusions = listOf(40501L, 40502L, 40503L, 40504L)),

        // ── idioms_l1_emotions (5) ────────────────────────────────────────

        WordEntity(id = 40506, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "over the moon", transliteration = "[ˈoʊvər ðə mun]", translation = "на седьмом небе от счастья",
            definition = "Extremely happy and excited about something.",
            definitionNative = "Очень счастливый и взволнованный по какому-то поводу. Дословно — «над луной».",
            example = "She was over the moon when she got the job.",
            exampleNative = "Она была over the moon, когда получила работу.",
            pos = "phrase", semanticGroup = "idioms_l1_emotions", fillInBlankExclusions = listOf(40504L, 40507L, 40508L, 40509L, 40510L, 40517L, 40520L)),

        WordEntity(id = 40507, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "on cloud nine", transliteration = "[ɑn klaʊd naɪn]", translation = "на седьмом небе (≈ в полном восторге)",
            definition = "Feeling extremely happy, as if you are floating on a cloud.",
            definitionNative = "Чувствовать себя очень счастливым, как будто паришь на облаке. Дословно — «на облаке номер девять».",
            example = "Ever since the baby was born, he's been on cloud nine.",
            exampleNative = "С тех пор как родился малыш, он on cloud nine.",
            pos = "phrase", semanticGroup = "idioms_l1_emotions", fillInBlankExclusions = listOf(40504L, 40506L, 40508L, 40509L, 40510L, 40514L, 40517L, 40520L)),

        WordEntity(id = 40508, setId = 405, languagePair = "en-ru", rarity = "RARE",
            original = "down in the dumps", transliteration = "[daʊn ɪn ðə dʌmps]", translation = "в подавленном настроении",
            definition = "Feeling sad, low and without energy for a while.",
            definitionNative = "Чувствовать грусть и подавленность какое-то время. Дословно — «внизу на свалках».",
            example = "He's been down in the dumps since his cat died last week.",
            exampleNative = "Он down in the dumps с тех пор, как на прошлой неделе умер его кот.",
            pos = "phrase", semanticGroup = "idioms_l1_emotions", fillInBlankExclusions = listOf(40504L, 40506L, 40507L, 40509L, 40510L, 40514L, 40517L, 40520L)),

        WordEntity(id = 40509, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "get cold feet", transliteration = "[ɡɛt koʊld fit]", translation = "струсить в последний момент",
            definition = "To suddenly feel afraid to do something you had planned.",
            definitionNative = "Вдруг испугаться сделать то, что планировал. Дословно — «получить холодные ноги».",
            example = "Don't get cold feet right before the wedding ceremony.",
            exampleNative = "Не вздумай get cold feet прямо перед свадебной церемонией.",
            pos = "phrase", semanticGroup = "idioms_l1_emotions", fillInBlankExclusions = listOf(40502L, 40503L, 40505L, 40506L, 40507L, 40508L, 40510L, 40511L, 40512L, 40513L, 40515L, 40518L, 40519L, 40521L, 40522L, 40525L)),

        WordEntity(id = 40510, setId = 405, languagePair = "en-ru", rarity = "RARE",
            original = "butterflies in the stomach", transliteration = "[ˈbʌtərˌflaɪz ɪn ðə ˈstʌmək]", translation = "мандраж (≈ «бабочки в животе»)",
            definition = "A nervous, fluttery feeling in your belly before something important.",
            definitionNative = "Нервное, трепетное чувство в животе перед чем-то важным. Дословно — «бабочки в животе».",
            example = "I always get butterflies in the stomach before a big exam.",
            exampleNative = "У меня всегда butterflies in the stomach перед серьёзным экзаменом.",
            pos = "phrase", semanticGroup = "idioms_l1_emotions", fillInBlankExclusions = listOf(40506L, 40507L, 40508L, 40509L, 40514L, 40517L, 40520L)),

        // ── idioms_l1_communication (5) ───────────────────────────────────

        WordEntity(id = 40511, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "beat around the bush", transliteration = "[bit əˈraʊnd ðə bʊʃ]", translation = "ходить вокруг да около",
            definition = "To talk for a long time without saying what you really mean.",
            definitionNative = "Долго говорить, не переходя к сути. Дословно — «бить вокруг куста».",
            example = "Please don't beat around the bush, just tell me the truth.",
            exampleNative = "Пожалуйста, не надо beat around the bush, скажи мне правду.",
            pos = "phrase", semanticGroup = "idioms_l1_communication", fillInBlankExclusions = listOf(40509L, 40512L, 40513L, 40514L, 40515L, 40521L, 40522L, 40525L)),

        WordEntity(id = 40512, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cut to the chase", transliteration = "[kʌt tu ðə ʧeɪs]", translation = "перейти к сути",
            definition = "To skip the unimportant parts and talk about what really matters.",
            definitionNative = "Пропустить неважное и перейти к главному. Дословно — «перерезать к погоне» (из старого Голливуда).",
            example = "Let me cut to the chase — we can't afford this trip.",
            exampleNative = "Я cut to the chase — мы не можем позволить себе эту поездку.",
            pos = "phrase", semanticGroup = "idioms_l1_communication", fillInBlankExclusions = listOf(40511L, 40513L, 40514L, 40515L, 40525L)),

        WordEntity(id = 40513, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "spill the beans", transliteration = "[spɪl ðə binz]", translation = "проболтаться",
            definition = "To tell a secret, often by accident.",
            definitionNative = "Выдать секрет, часто случайно. Дословно — «рассыпать бобы».",
            example = "Don't spill the beans about the surprise party!",
            exampleNative = "Не spill the beans про сюрприз-вечеринку!",
            pos = "phrase", semanticGroup = "idioms_l1_communication", fillInBlankExclusions = listOf(40509L, 40511L, 40512L, 40514L, 40515L)),

        WordEntity(id = 40514, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "on the same page", transliteration = "[ɑn ðə seɪm peɪʤ]", translation = "понимать друг друга / быть в одной волне",
            definition = "Agreeing with someone or sharing the same understanding.",
            definitionNative = "Соглашаться с кем-то или одинаково что-то понимать. Дословно — «на одной странице».",
            example = "Before we start, let's make sure we're on the same page.",
            exampleNative = "Прежде чем начать, давай убедимся, что мы on the same page.",
            pos = "phrase", semanticGroup = "idioms_l1_communication", fillInBlankExclusions = listOf(40504L, 40511L, 40512L, 40513L, 40515L)),

        WordEntity(id = 40515, setId = 405, languagePair = "en-ru", rarity = "RARE",
            original = "hit the nail on the head", transliteration = "[hɪt ðə neɪl ɑn ðə hɛd]", translation = "попасть в точку",
            definition = "To say or do exactly the right thing about a situation.",
            definitionNative = "Сказать или сделать ровно то, что нужно в ситуации. Дословно — «ударить по гвоздю в шляпку».",
            example = "You hit the nail on the head — that's exactly the problem.",
            exampleNative = "Ты hit the nail on the head — это именно та проблема.",
            pos = "phrase", semanticGroup = "idioms_l1_communication", fillInBlankExclusions = listOf(40502L, 40503L, 40505L, 40509L, 40511L, 40512L, 40513L, 40514L, 40519L)),

        // ── idioms_l1_situations (5) ──────────────────────────────────────

        WordEntity(id = 40516, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "piece of cake", transliteration = "[pis əv keɪk]", translation = "проще простого",
            definition = "Something that is very easy to do.",
            definitionNative = "Что-то, что делать очень легко. Дословно — «кусок торта».",
            example = "The math test was a piece of cake for her.",
            exampleNative = "Контрольная по математике была для неё piece of cake.",
            pos = "phrase", semanticGroup = "idioms_l1_situations", fillInBlankExclusions = listOf(40518L, 40519L)),

        WordEntity(id = 40517, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "in hot water", transliteration = "[ɪn hɑt ˈwɔtər]", translation = "в неприятном положении",
            definition = "In trouble, especially because of something you did wrong.",
            definitionNative = "В неприятностях, особенно из-за своей вины. Дословно — «в горячей воде».",
            example = "He's in hot water with his boss for missing the deadline.",
            exampleNative = "Он in hot water с начальником за то, что сорвал дедлайн.",
            pos = "phrase", semanticGroup = "idioms_l1_situations", fillInBlankExclusions = listOf(40508L, 40516L, 40518L, 40519L, 40520L)),

        WordEntity(id = 40518, setId = 405, languagePair = "en-ru", rarity = "RARE",
            original = "kill two birds with one stone", transliteration = "[kɪl tu bɜrdz wɪð wʌn stoʊn]", translation = "убить двух зайцев одним выстрелом",
            definition = "To solve two problems with a single action.",
            definitionNative = "Решить две задачи одним действием. Дословно — «убить двух птиц одним камнем».",
            example = "By cycling to work, I kill two birds with one stone — exercise and commute.",
            exampleNative = "Ездя на работу на велосипеде, я kill two birds with one stone — спорт и дорога.",
            pos = "phrase", semanticGroup = "idioms_l1_situations", fillInBlankExclusions = listOf(40516L, 40517L, 40519L, 40520L)),

        WordEntity(id = 40519, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "miss the boat", transliteration = "[mɪs ðə boʊt]", translation = "упустить шанс",
            definition = "To lose a chance to do something because you were too slow.",
            definitionNative = "Упустить возможность из-за того, что был слишком медлительным. Дословно — «пропустить лодку».",
            example = "If you don't apply today, you'll miss the boat on this scholarship.",
            exampleNative = "Если не подашь заявку сегодня, ты miss the boat на эту стипендию.",
            pos = "phrase", semanticGroup = "idioms_l1_situations", fillInBlankExclusions = listOf(40509L, 40516L, 40517L, 40518L, 40520L)),

        WordEntity(id = 40520, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "under the weather", transliteration = "[ˈʌndər ðə ˈwɛðər]", translation = "приболел / неважно себя чувствую",
            definition = "Feeling slightly ill or not very well.",
            definitionNative = "Чувствовать лёгкое недомогание или быть не в форме. Дословно — «под погодой».",
            example = "I'm a bit under the weather today, so I'll stay home.",
            exampleNative = "Я сегодня немного under the weather, так что останусь дома.",
            pos = "phrase", semanticGroup = "idioms_l1_situations", fillInBlankExclusions = listOf(40508L, 40516L, 40517L, 40518L, 40519L)),

        // ── idioms_l1_actions (5) ─────────────────────────────────────────

        WordEntity(id = 40521, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "call it a day", transliteration = "[kɔl ɪt ə deɪ]", translation = "закончить на сегодня",
            definition = "To stop working on something for the rest of the day.",
            definitionNative = "Прекратить заниматься чем-то на сегодня. Дословно — «назвать это днём».",
            example = "I'm tired — let's call it a day and finish tomorrow.",
            exampleNative = "Я устал — давай call it a day и закончим завтра.",
            pos = "phrase", semanticGroup = "idioms_l1_actions", fillInBlankExclusions = listOf(40522L, 40523L, 40524L, 40525L)),

        WordEntity(id = 40522, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hit the road", transliteration = "[hɪt ðə roʊd]", translation = "отправиться в путь",
            definition = "To leave a place and start a journey.",
            definitionNative = "Уйти откуда-то и отправиться в путь. Дословно — «ударить по дороге».",
            example = "It's getting late — we should hit the road soon.",
            exampleNative = "Уже поздно — нам пора hit the road.",
            pos = "phrase", semanticGroup = "idioms_l1_actions", fillInBlankExclusions = listOf(40512L, 40521L, 40523L, 40524L, 40525L)),

        WordEntity(id = 40523, setId = 405, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "break a leg", transliteration = "[breɪk ə lɛɡ]", translation = "ни пуха ни пера (актёрское пожелание удачи)",
            definition = "A theatre way to wish someone good luck before a performance.",
            definitionNative = "Театральный способ пожелать удачи перед выступлением. Дословно — «сломай ногу» (суеверие: прямое пожелание удачи приносит беду).",
            example = "Break a leg out there — you've practised so much!",
            exampleNative = "Break a leg на сцене — ты так много репетировал!",
            pos = "phrase", semanticGroup = "idioms_l1_actions", fillInBlankExclusions = listOf(40515L, 40521L, 40522L, 40524L, 40525L)),

        WordEntity(id = 40524, setId = 405, languagePair = "en-ru", rarity = "RARE",
            original = "pull yourself together", transliteration = "[pʊl jərˈsɛlf təˈɡɛðər]", translation = "взять себя в руки",
            definition = "To control your emotions and start behaving normally again.",
            definitionNative = "Совладать с эмоциями и снова вести себя нормально. Дословно — «стянуть себя вместе».",
            example = "Pull yourself together — crying won't fix the problem.",
            exampleNative = "Pull yourself together — слёзы проблему не решат.",
            pos = "phrase", semanticGroup = "idioms_l1_actions", fillInBlankExclusions = listOf(40512L, 40521L, 40522L, 40523L, 40525L)),

        WordEntity(id = 40525, setId = 405, languagePair = "en-ru", rarity = "RARE",
            original = "bite the bullet", transliteration = "[baɪt ðə ˈbʊlɪt]", translation = "стиснуть зубы и сделать",
            definition = "To accept something hard or painful that you cannot avoid.",
            definitionNative = "Принять трудное или неприятное, чего нельзя избежать. Дословно — «закусить пулю» (раньше так делали при операциях без наркоза).",
            example = "I had to bite the bullet and tell him the bad news.",
            exampleNative = "Мне пришлось bite the bullet и сообщить ему плохие новости.",
            pos = "phrase", semanticGroup = "idioms_l1_actions", fillInBlankExclusions = listOf(40512L, 40513L, 40521L, 40522L, 40523L, 40524L)),
    )
}
