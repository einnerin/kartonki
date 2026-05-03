package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Идиомы и устойчивые выражения (L3, RARE+UNCOMMON).
 *
 * Set 407: «Идиомы и устойчивые выражения» — углублённый уровень.
 *          Продолжение L1 (set 405) и L2 (set 406). Идиомы более
 *          сложного регистра — деловые, идиомы про проблемы и
 *          конфликты, изменения, правду и ложь, упорство. Эти
 *          выражения уже редко встречаются в учебниках общего курса —
 *          они ближе к нативному словарю и медиа-языку.
 *
 * Распределение редкости: 18 RARE (B2) + 7 UNCOMMON (B1+).
 * Это два смежных уровня — правило разброса соблюдено. COMMON-слов
 * в идиомах не бывает по определению (см. комментарий к L1).
 *
 * Дублей с L1 (set 405) нет — все 25 фраз новые. Также проверено
 * grep'ом по `original = "..."` для всех 25 фраз — в других сетах
 * en-ru эти многословные идиомы отсутствуют.
 *
 * SemanticGroups (5 × 5):
 *   idioms_l3_business    — cut corners, the ball is in your court,
 *                           run a tight ship, get down to brass tacks,
 *                           in the long run
 *   idioms_l3_problems    — open a can of worms, a wild goose chase,
 *                           between a rock and a hard place, smell a rat,
 *                           blow things out of proportion
 *   idioms_l3_change      — turn over a new leaf, jump on the bandwagon,
 *                           fall through the cracks, bury the hatchet,
 *                           light at the end of the tunnel
 *   idioms_l3_truth_lies  — the writing on the wall, take with a pinch
 *                           of salt, see through a ruse, cry wolf,
 *                           throw smoke and mirrors
 *   idioms_l3_persistence — keep your nose to the grindstone, go the
 *                           extra mile, against all odds, dig your heels
 *                           in, weather the storm
 *
 * Word IDs: setId × 100 + position (40701..40725).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions пустые — заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishIdiomsL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 407,
            languagePair = "en-ru",
            orderIndex = 407,
            name = "Идиомы и устойчивые выражения",
            description = "Идиомы о бизнесе, проблемах, переменах, правде/лжи и упорстве",
            topic = "Идиомы и устойчивые выражения",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 407 — Идиомы: углублённый уровень (L3, RARE+UNCOMMON)        ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── idioms_l3_business (5) ────────────────────────────────────────

        WordEntity(id = 40701, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "cut corners", transliteration = "[kʌt ˈkɔrnərz]", translation = "халтурить (≈ делать тяп-ляп ради экономии)",
            definition = "To do something in the easiest, cheapest or quickest way, often lowering quality.",
            definitionNative = "Сделать что-то самым простым, дешёвым или быстрым способом, часто в ущерб качеству. Дословно — «срезать углы».",
            example = "If you cut corners on the foundation, the whole house will suffer.",
            exampleNative = "Если cut corners на фундаменте, пострадает весь дом.",
            pos = "phrase", semanticGroup = "idioms_l3_business", fillInBlankExclusions = listOf(40702L, 40703L, 40704L, 40705L)),

        WordEntity(id = 40702, setId = 407, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "the ball is in your court", transliteration = "[ðə bɔl ɪz ɪn jər kɔrt]", translation = "теперь твой ход (≈ решение за тобой)",
            definition = "It is now your turn to make a decision or take the next step.",
            definitionNative = "Теперь твоя очередь принять решение или сделать следующий шаг. Дословно — «мяч на твоей стороне корта».",
            example = "I've made my offer — the ball is in your court now.",
            exampleNative = "Я сделал своё предложение — the ball is in your court.",
            pos = "phrase", semanticGroup = "idioms_l3_business", fillInBlankExclusions = listOf(40701L, 40703L, 40704L, 40705L)),

        WordEntity(id = 40703, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "run a tight ship", transliteration = "[rʌn ə taɪt ʃɪp]", translation = "держать всё в строгом порядке",
            definition = "To manage a team or organisation strictly and very efficiently.",
            definitionNative = "Управлять командой или организацией строго и очень эффективно. Дословно — «вести крепко свинченный корабль».",
            example = "The new manager likes to run a tight ship — no one is ever late.",
            exampleNative = "Новый менеджер любит run a tight ship — никто никогда не опаздывает.",
            pos = "phrase", semanticGroup = "idioms_l3_business", fillInBlankExclusions = listOf(40701L, 40702L, 40704L, 40705L)),

        WordEntity(id = 40704, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "get down to brass tacks", transliteration = "[ɡɛt daʊn tu bræs tæks]", translation = "перейти к делу / к сути",
            definition = "To start dealing with the most important practical details of a matter.",
            definitionNative = "Перейти к сути и важным деталям. Дословно — «спуститься к латунным гвоздикам».",
            example = "Enough chitchat — let's get down to brass tacks and discuss the price.",
            exampleNative = "Хватит болтовни — давайте get down to brass tacks и обсудим цену.",
            pos = "phrase", semanticGroup = "idioms_l3_business", fillInBlankExclusions = listOf(40701L, 40702L, 40703L, 40705L)),

        WordEntity(id = 40705, setId = 407, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "in the long run", transliteration = "[ɪn ðə lɔŋ rʌn]", translation = "в долгосрочной перспективе",
            definition = "Over a long period of time, when the final result becomes clear.",
            definitionNative = "За долгий промежуток времени, когда виден итоговый результат. Дословно — «на длинной дистанции».",
            example = "Buying quality shoes is cheaper in the long run than replacing cheap ones.",
            exampleNative = "Покупать качественную обувь дешевле in the long run, чем менять дешёвую.",
            pos = "phrase", semanticGroup = "idioms_l3_business", fillInBlankExclusions = listOf(40701L, 40702L, 40703L, 40704L)),

        // ── idioms_l3_problems (5) ────────────────────────────────────────

        WordEntity(id = 40706, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "open a can of worms", transliteration = "[ˈoʊpən ə kæn əv wɜrmz]", translation = "затронуть болезненную тему (≈ ящик Пандоры)",
            definition = "To start dealing with something that creates many new, complicated problems.",
            definitionNative = "Начать разбираться с чем-то, что порождает множество новых сложных проблем. Дословно — «открыть банку с червями».",
            example = "Don't open a can of worms by asking about his ex-wife at dinner.",
            exampleNative = "Не надо open a can of worms — не спрашивай про его бывшую жену за ужином.",
            pos = "phrase", semanticGroup = "idioms_l3_problems", fillInBlankExclusions = listOf(40707L, 40708L, 40709L, 40710L)),

        WordEntity(id = 40707, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "a wild goose chase", transliteration = "[ə waɪld ɡus ʧeɪs]", translation = "бесполезная погоня / напрасные хлопоты",
            definition = "A long, useless search or effort that leads nowhere.",
            definitionNative = "Долгий бесполезный поиск или усилия, ведущие в никуда. Дословно — «погоня за дикой гусыней».",
            example = "The whole investigation turned out to be a wild goose chase.",
            exampleNative = "Всё расследование оказалось a wild goose chase.",
            pos = "phrase", semanticGroup = "idioms_l3_problems", fillInBlankExclusions = listOf(40706L, 40708L, 40709L, 40710L)),

        WordEntity(id = 40708, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "between a rock and a hard place", transliteration = "[bɪˈtwin ə rɑk ənd ə hɑrd pleɪs]", translation = "меж двух огней",
            definition = "Forced to choose between two equally bad or difficult options.",
            definitionNative = "Вынужденный выбирать между двумя одинаково плохими или трудными вариантами. Дословно — «между скалой и твёрдым местом».",
            example = "I'm between a rock and a hard place — both job offers have big drawbacks.",
            exampleNative = "Я between a rock and a hard place — у обоих предложений работы есть серьёзные минусы.",
            pos = "phrase", semanticGroup = "idioms_l3_problems", fillInBlankExclusions = listOf(40706L, 40707L, 40709L, 40710L)),

        WordEntity(id = 40709, setId = 407, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "smell a rat", transliteration = "[smɛl ə ræt]", translation = "чуять подвох",
            definition = "To suspect that something dishonest or wrong is happening.",
            definitionNative = "Подозревать, что происходит что-то нечестное или неправильное. Дословно — «чуять крысу».",
            example = "When he changed the story three times, I started to smell a rat.",
            exampleNative = "Когда он менял версию трижды, я начал smell a rat.",
            pos = "phrase", semanticGroup = "idioms_l3_problems", fillInBlankExclusions = listOf(40706L, 40707L, 40708L, 40710L)),

        WordEntity(id = 40710, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "blow things out of proportion", transliteration = "[bloʊ θɪŋz aʊt əv prəˈpɔrʃən]", translation = "раздувать из мухи слона",
            definition = "To make something seem much more serious or important than it really is.",
            definitionNative = "Преувеличивать серьёзность или важность чего-то по сравнению с реальностью. Дословно — «раздуть вещи вне пропорции».",
            example = "It was just a small mistake — don't blow things out of proportion.",
            exampleNative = "Это была всего лишь мелкая ошибка — не надо blow things out of proportion.",
            pos = "phrase", semanticGroup = "idioms_l3_problems", fillInBlankExclusions = listOf(40706L, 40707L, 40708L, 40709L)),

        // ── idioms_l3_change (5) ──────────────────────────────────────────

        WordEntity(id = 40711, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "turn over a new leaf", transliteration = "[tɜrn ˈoʊvər ə nu lif]", translation = "начать с чистого листа",
            definition = "To change your behaviour and start to live in a better, more positive way.",
            definitionNative = "Изменить поведение и начать жить лучше, позитивнее. Дословно — «перевернуть новый лист» (страницу книги).",
            example = "After the illness he decided to turn over a new leaf and quit smoking.",
            exampleNative = "После болезни он решил turn over a new leaf и бросил курить.",
            pos = "phrase", semanticGroup = "idioms_l3_change", fillInBlankExclusions = listOf(40712L, 40713L, 40714L, 40715L)),

        WordEntity(id = 40712, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "jump on the bandwagon", transliteration = "[ʤʌmp ɑn ðə ˈbændˌwæɡən]", translation = "примкнуть к модному течению",
            definition = "To join a popular activity or trend just because many other people are doing it.",
            definitionNative = "Примкнуть к модному тренду за компанию. Дословно — «запрыгнуть на оркестровый фургон».",
            example = "Once the show became a hit, every brand wanted to jump on the bandwagon.",
            exampleNative = "Как только шоу стало хитом, все бренды захотели jump on the bandwagon.",
            pos = "phrase", semanticGroup = "idioms_l3_change", fillInBlankExclusions = listOf(40711L, 40713L, 40714L, 40715L)),

        WordEntity(id = 40713, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "fall through the cracks", transliteration = "[fɔl θru ðə kræks]", translation = "проскочить незамеченным (≈ выпасть из системы)",
            definition = "To be missed or forgotten, especially by a system that should have noticed it.",
            definitionNative = "Быть упущенным или забытым, особенно системой, которая должна была заметить. Дословно — «провалиться сквозь щели».",
            example = "Some students fall through the cracks if no one tracks their progress.",
            exampleNative = "Некоторые ученики fall through the cracks, если никто не следит за их прогрессом.",
            pos = "phrase", semanticGroup = "idioms_l3_change", fillInBlankExclusions = listOf(40711L, 40712L, 40714L, 40715L)),

        WordEntity(id = 40714, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "bury the hatchet", transliteration = "[ˈbɛri ðə ˈhæʧɪt]", translation = "помириться (≈ зарыть топор войны)",
            definition = "To agree to forget a quarrel and become friendly again with someone.",
            definitionNative = "Согласиться забыть ссору и снова стать с кем-то дружественным. Дословно — «зарыть топорик» (обряд индейцев в знак мира).",
            example = "After years of arguing, the brothers finally agreed to bury the hatchet.",
            exampleNative = "После многих лет ссор братья наконец согласились bury the hatchet.",
            pos = "phrase", semanticGroup = "idioms_l3_change", fillInBlankExclusions = listOf(40711L, 40712L, 40713L, 40715L)),

        WordEntity(id = 40715, setId = 407, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "light at the end of the tunnel", transliteration = "[laɪt æt ðə ɛnd əv ðə ˈtʌnəl]", translation = "свет в конце тоннеля",
            definition = "Signs that a long, difficult situation is finally close to ending well.",
            definitionNative = "Признаки того, что долгая трудная ситуация наконец близка к хорошему концу. Дословно — «свет в конце тоннеля».",
            example = "After months of treatment, she finally sees light at the end of the tunnel.",
            exampleNative = "После месяцев лечения она наконец видит light at the end of the tunnel.",
            pos = "phrase", semanticGroup = "idioms_l3_change", fillInBlankExclusions = listOf(40711L, 40712L, 40713L, 40714L)),

        // ── idioms_l3_truth_lies (5) ──────────────────────────────────────

        WordEntity(id = 40716, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "the writing on the wall", transliteration = "[ðə ˈraɪtɪŋ ɑn ðə wɔl]", translation = "очевидные предвестники беды",
            definition = "Clear signs that something bad or a failure is going to happen soon.",
            definitionNative = "Очевидные признаки скорого провала. Дословно — «надпись на стене» (книга Даниила).",
            example = "When sales dropped for six months, the writing on the wall was clear.",
            exampleNative = "Когда продажи падали полгода, the writing on the wall было очевидно.",
            pos = "phrase", semanticGroup = "idioms_l3_truth_lies", fillInBlankExclusions = listOf(40717L, 40718L, 40719L, 40720L)),

        WordEntity(id = 40717, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "take with a pinch of salt", transliteration = "[teɪk wɪð ə pɪnʧ əv sɔlt]", translation = "относиться скептически",
            definition = "To accept something but with some doubt about whether it is fully true.",
            definitionNative = "Принять что-то, но с долей сомнения в полной правдивости. Дословно — «принять со щепоткой соли».",
            example = "You should take with a pinch of salt his stories about the war.",
            exampleNative = "Его истории о войне стоит take with a pinch of salt.",
            pos = "phrase", semanticGroup = "idioms_l3_truth_lies", fillInBlankExclusions = listOf(40716L, 40718L, 40719L, 40720L)),

        WordEntity(id = 40718, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "see through a ruse", transliteration = "[si θru ə ruz]", translation = "раскусить уловку",
            definition = "To recognise a trick or deception and not be fooled by it.",
            definitionNative = "Распознать хитрость или обман и не поддаться. Дословно — «видеть сквозь уловку».",
            example = "She was quick to see through a ruse aimed at borrowing money again.",
            exampleNative = "Она умела быстро see through a ruse, цель которой — снова занять денег.",
            pos = "phrase", semanticGroup = "idioms_l3_truth_lies", fillInBlankExclusions = listOf(40716L, 40717L, 40719L, 40720L)),

        WordEntity(id = 40719, setId = 407, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cry wolf", transliteration = "[kraɪ wʊlf]", translation = "поднимать ложную тревогу",
            definition = "To raise a false alarm so often that real warnings are no longer believed.",
            definitionNative = "Поднимать ложную тревогу так часто, что настоящим предупреждениям больше не верят. Дословно — «кричать «волк!»» (басня Эзопа).",
            example = "Don't cry wolf — people will stop believing your real warnings.",
            exampleNative = "Не надо cry wolf — настоящим тревогам тогда никто не поверит.",
            pos = "phrase", semanticGroup = "idioms_l3_truth_lies", fillInBlankExclusions = listOf(40716L, 40717L, 40718L, 40720L)),

        WordEntity(id = 40720, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "throw smoke and mirrors", transliteration = "[θroʊ smoʊk ənd ˈmɪrərz]", translation = "пускать пыль в глаза",
            definition = "To use clever but deceptive talk or visuals to hide the truth from people.",
            definitionNative = "Скрывать правду ловкими отвлекающими манёврами. Дословно — «дым и зеркала» (как у фокусников).",
            example = "The politician likes to throw smoke and mirrors instead of answering.",
            exampleNative = "Политик любит throw smoke and mirrors вместо прямого ответа.",
            pos = "phrase", semanticGroup = "idioms_l3_truth_lies", fillInBlankExclusions = listOf(40716L, 40717L, 40718L, 40719L)),

        // ── idioms_l3_persistence (5) ─────────────────────────────────────

        WordEntity(id = 40721, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "keep your nose to the grindstone", transliteration = "[kip jər noʊz tu ðə ˈɡraɪndˌstoʊn]", translation = "вкалывать без передышки",
            definition = "To work hard and continuously for a long time without taking breaks.",
            definitionNative = "Работать упорно и непрерывно долгое время без перерывов. Дословно — «держать нос у точильного камня».",
            example = "If you keep your nose to the grindstone, you'll finish the thesis by June.",
            exampleNative = "Если будешь keep your nose to the grindstone, закончишь диплом к июню.",
            pos = "phrase", semanticGroup = "idioms_l3_persistence", fillInBlankExclusions = listOf(40722L, 40723L, 40724L, 40725L)),

        WordEntity(id = 40722, setId = 407, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "go the extra mile", transliteration = "[ɡoʊ ði ˈɛkstrə maɪl]", translation = "сделать больше, чем нужно",
            definition = "To do more than is expected or required to achieve a great result.",
            definitionNative = "Сделать больше ожидаемого или требуемого ради отличного результата. Дословно — «пройти лишнюю милю».",
            example = "Our team is ready to go the extra mile for important clients.",
            exampleNative = "Наша команда готова go the extra mile ради важных клиентов.",
            pos = "phrase", semanticGroup = "idioms_l3_persistence", fillInBlankExclusions = listOf(40721L, 40723L, 40724L, 40725L)),

        WordEntity(id = 40723, setId = 407, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "against all odds", transliteration = "[əˈɡɛnst ɔl ɑdz]", translation = "вопреки всему",
            definition = "Despite very low chances of success or many serious obstacles.",
            definitionNative = "Несмотря на очень малые шансы на успех или множество серьёзных препятствий. Дословно — «против всех шансов».",
            example = "The small team finished the project on time against all odds.",
            exampleNative = "Маленькая команда сдала проект в срок against all odds.",
            pos = "phrase", semanticGroup = "idioms_l3_persistence", fillInBlankExclusions = listOf(40721L, 40722L, 40724L, 40725L)),

        WordEntity(id = 40724, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "dig your heels in", transliteration = "[dɪɡ jər hilz ɪn]", translation = "упереться (≈ ни шагу назад)",
            definition = "To refuse firmly to change your mind or do what others want.",
            definitionNative = "Твёрдо отказаться менять мнение или делать то, что хотят другие. Дословно — «упереться каблуками».",
            example = "Just dig your heels in and refuse to sign that unfair contract.",
            exampleNative = "Просто dig your heels in и откажись подписывать этот несправедливый контракт.",
            pos = "phrase", semanticGroup = "idioms_l3_persistence", fillInBlankExclusions = listOf(40721L, 40722L, 40723L, 40725L)),

        WordEntity(id = 40725, setId = 407, languagePair = "en-ru", rarity = "RARE",
            original = "weather the storm", transliteration = "[ˈwɛðər ðə stɔrm]", translation = "пережить бурю / выстоять",
            definition = "To survive a difficult period and come out of it without major damage.",
            definitionNative = "Пережить трудный период и выйти из него без серьёзного ущерба. Дословно — «перенести шторм» (морской термин).",
            example = "The small business managed to weather the storm of the recession.",
            exampleNative = "Малому бизнесу удалось weather the storm рецессии.",
            pos = "phrase", semanticGroup = "idioms_l3_persistence", fillInBlankExclusions = listOf(40721L, 40722L, 40723L, 40724L)),
    )
}
