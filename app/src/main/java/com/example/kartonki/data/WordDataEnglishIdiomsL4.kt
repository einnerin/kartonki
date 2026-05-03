package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Идиомы и устойчивые выражения (L4, EPIC+RARE).
 *
 * Set 408: «Идиомы и устойчивые выражения» — профессиональный уровень.
 *          Продолжение L1 (set 405), L2 (set 406) и L3 (set 407).
 *          Идиомы продвинутого регистра — сложные эмоциональные
 *          состояния, стратегическое поведение, социальная динамика,
 *          тонкая коммуникация и оценка последствий. Эти выражения
 *          встречаются в качественной прессе, литературе и речи
 *          образованных носителей.
 *
 * Распределение редкости: 17 EPIC (C1) + 8 RARE (B2). Это два смежных
 * уровня — правило разброса соблюдено.
 *
 * Дублей с L1/L2/L3 нет — все 25 фраз новые. Проверено grep'ом по
 * `original = "..."` для всех ключевых идиом. Заметка: "off the cuff"
 * (вместо "take it with a grain of salt") — последний пересекался с
 * "take with a pinch of salt" из L3 (синоним → нельзя). Заменили на
 * "not mince words" в группе communication_advanced.
 *
 * SemanticGroups (5 × 5):
 *   idioms_l4_complex_emotions      — pour your heart out, wear your
 *                                     heart on your sleeve, beside
 *                                     yourself, head over heels,
 *                                     fish out of water
 *   idioms_l4_strategic             — play your cards right, hedge
 *                                     your bets, burn your bridges,
 *                                     leave no stone unturned, throw
 *                                     caution to the wind
 *   idioms_l4_social_dynamics       — the elephant in the room,
 *                                     preaching to the choir, devil's
 *                                     advocate, sour grapes, ivory
 *                                     tower
 *   idioms_l4_communication_advanced — read between the lines, hit
 *                                     below the belt, on the tip of
 *                                     my tongue, off the cuff, not
 *                                     mince words
 *   idioms_l4_outcomes              — backfire spectacularly, come
 *                                     full circle, blow up in your
 *                                     face, set in stone, water under
 *                                     the bridge
 *
 * Word IDs: setId × 100 + position (40801..40825).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions пустые — заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishIdiomsL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 408,
            languagePair = "en-ru",
            orderIndex = 408,
            name = "Идиомы и устойчивые выражения",
            description = "Идиомы о сложных эмоциях, стратегии, социальной динамике, тонкой коммуникации и последствиях",
            topic = "Идиомы и устойчивые выражения",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 408 — Идиомы: профессиональный уровень (L4, EPIC+RARE)       ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── idioms_l4_complex_emotions (5) ────────────────────────────────

        WordEntity(id = 40801, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "pour your heart out", transliteration = "[pɔr jər hɑrt aʊt]", translation = "излить душу",
            definition = "To tell someone all your deepest feelings and private worries openly.",
            definitionNative = "Открыто рассказать кому-то о глубоких чувствах и тревогах. Дословно — «вылить сердце наружу».",
            example = "She finally decided to pour your heart out to her therapist after years of silence.",
            exampleNative = "Она наконец решилась pour your heart out перед психотерапевтом после многих лет молчания.",
            pos = "phrase", semanticGroup = "idioms_l4_complex_emotions", fillInBlankExclusions = listOf(40802L, 40803L, 40804L, 40805L, 40820L)),

        WordEntity(id = 40802, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "wear your heart on your sleeve", transliteration = "[wɛr jər hɑrt ɑn jər sliv]", translation = "не скрывать чувств",
            definition = "To show your emotions openly so that everyone can easily see them.",
            definitionNative = "Открыто показывать эмоции так, что их легко заметить. Дословно — «носить сердце на рукаве».",
            example = "If you wear your heart on your sleeve, everyone instantly knows how you feel.",
            exampleNative = "Если wear your heart on your sleeve, окружающие сразу видят, что ты чувствуешь.",
            pos = "phrase", semanticGroup = "idioms_l4_complex_emotions", fillInBlankExclusions = listOf(40801L, 40803L, 40804L, 40805L)),

        WordEntity(id = 40803, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "beside yourself", transliteration = "[bɪˈsaɪd jərˈsɛlf]", translation = "вне себя (от эмоций)",
            definition = "Extremely upset, worried or excited so that you can hardly control yourself.",
            definitionNative = "Крайне расстроенный, встревоженный или взволнованный — почти не владеет собой. Дословно — «рядом с самим собой».",
            example = "She was beside yourself with worry when the child didn't come home.",
            exampleNative = "Она была beside yourself от тревоги, когда ребёнок не вернулся домой.",
            pos = "phrase", semanticGroup = "idioms_l4_complex_emotions", fillInBlankExclusions = listOf(40801L, 40802L, 40804L, 40805L)),

        WordEntity(id = 40804, setId = 408, languagePair = "en-ru", rarity = "RARE",
            original = "head over heels", transliteration = "[hɛd ˈoʊvər hilz]", translation = "по уши (влюблён)",
            definition = "Completely and deeply in love with someone in an excited, almost helpless way.",
            definitionNative = "Полностью и глубоко влюблённый — взволнованно, почти беспомощно. Дословно — «голова над пятками» (кувырком).",
            example = "After only a month, he was head over heels in love with her.",
            exampleNative = "Уже через месяц он был head over heels в неё влюблён.",
            pos = "phrase", semanticGroup = "idioms_l4_complex_emotions", fillInBlankExclusions = listOf(40801L, 40802L, 40803L, 40805L)),

        WordEntity(id = 40805, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "fish out of water", transliteration = "[fɪʃ aʊt əv ˈwɔtər]", translation = "не в своей тарелке",
            definition = "A person who feels uncomfortable because of being in an unfamiliar situation.",
            definitionNative = "Человек, которому неуютно в непривычной обстановке. Дословно — «рыба вне воды».",
            example = "At the formal dinner, he felt like a fish out of water in his old jeans.",
            exampleNative = "На официальном ужине он чувствовал себя как fish out of water в старых джинсах.",
            pos = "phrase", semanticGroup = "idioms_l4_complex_emotions", fillInBlankExclusions = listOf(40801L, 40802L, 40803L, 40804L)),

        // ── idioms_l4_strategic (5) ───────────────────────────────────────

        WordEntity(id = 40806, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "play your cards right", transliteration = "[pleɪ jər kɑrdz raɪt]", translation = "разыграть свои карты с умом",
            definition = "To act in a clever way that gives you the best chance of success.",
            definitionNative = "Действовать умно — так, чтобы получить максимум шансов на успех. Дословно — «правильно разыграть свои карты».",
            example = "If you play your cards right, you could be promoted by the end of the year.",
            exampleNative = "Если play your cards right, к концу года тебя могут повысить.",
            pos = "phrase", semanticGroup = "idioms_l4_strategic", fillInBlankExclusions = listOf(40807L, 40808L, 40809L, 40810L)),

        WordEntity(id = 40807, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "hedge your bets", transliteration = "[hɛʤ jər bɛts]", translation = "подстраховаться (≈ не класть всё на одну карту)",
            definition = "To reduce risk by supporting more than one possible outcome at the same time.",
            definitionNative = "Уменьшить риск, делая ставку сразу на несколько возможных исходов. Дословно — «огородить свои ставки».",
            example = "Smart investors hedge your bets by spreading money across different assets.",
            exampleNative = "Умные инвесторы hedge your bets, распределяя деньги по разным активам.",
            pos = "phrase", semanticGroup = "idioms_l4_strategic", fillInBlankExclusions = listOf(40806L, 40808L, 40809L, 40810L)),

        WordEntity(id = 40808, setId = 408, languagePair = "en-ru", rarity = "RARE",
            original = "burn your bridges", transliteration = "[bɜrn jər ˈbrɪʤəz]", translation = "сжечь мосты",
            definition = "To destroy your relationships or options so that returning becomes impossible.",
            definitionNative = "Разрушить отношения или варианты, делая возврат невозможным. Дословно — «сжечь свои мосты».",
            example = "Don't burn your bridges with that company — you might need them later.",
            exampleNative = "Не стоит burn your bridges с этой компанией — она может ещё понадобиться.",
            pos = "phrase", semanticGroup = "idioms_l4_strategic", fillInBlankExclusions = listOf(40806L, 40807L, 40809L, 40810L)),

        WordEntity(id = 40809, setId = 408, languagePair = "en-ru", rarity = "RARE",
            original = "leave no stone unturned", transliteration = "[liv noʊ stoʊn ˌʌnˈtɜrnd]", translation = "перевернуть всё вверх дном",
            definition = "To search or try in every possible way to find or achieve something.",
            definitionNative = "Искать всеми возможными способами. Дословно — «не оставить ни одного камня неперевёрнутым».",
            example = "The detective promised to leave no stone unturned in the search for the truth.",
            exampleNative = "Детектив обещал leave no stone unturned в поисках правды.",
            pos = "phrase", semanticGroup = "idioms_l4_strategic", fillInBlankExclusions = listOf(40806L, 40807L, 40808L, 40810L)),

        WordEntity(id = 40810, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "throw caution to the wind", transliteration = "[θroʊ ˈkɔʃən tu ðə wɪnd]", translation = "забыть об осторожности",
            definition = "To act boldly without worrying about possible danger or bad consequences.",
            definitionNative = "Действовать смело, не думая о возможной опасности или последствиях. Дословно — «бросить осторожность по ветру».",
            example = "She decided to throw caution to the wind and start a business with her last savings.",
            exampleNative = "Она решила throw caution to the wind и открыть бизнес на последние сбережения.",
            pos = "phrase", semanticGroup = "idioms_l4_strategic", fillInBlankExclusions = listOf(40806L, 40807L, 40808L, 40809L)),

        // ── idioms_l4_social_dynamics (5) ─────────────────────────────────

        WordEntity(id = 40811, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "the elephant in the room", transliteration = "[ði ˈɛləfənt ɪn ðə rum]", translation = "очевидное, о чём все молчат",
            definition = "An obvious problem that everyone notices but nobody wants to talk about.",
            definitionNative = "Очевидная проблема, которую все замечают, но обсуждать не хотят. Дословно — «слон в комнате».",
            example = "Let's address the elephant in the room — the budget cuts everyone is afraid of.",
            exampleNative = "Давайте обсудим the elephant in the room — сокращения бюджета, которых все боятся.",
            pos = "phrase", semanticGroup = "idioms_l4_social_dynamics", fillInBlankExclusions = listOf(40812L, 40813L, 40814L, 40815L)),

        WordEntity(id = 40812, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "preaching to the choir", transliteration = "[ˈpriʧɪŋ tu ðə kwaɪər]", translation = "ломиться в открытую дверь",
            definition = "To argue for an idea in front of people who already strongly agree with it.",
            definitionNative = "Доказывать идею тем, кто уже с ней полностью согласен. Дословно — «проповедовать хору».",
            example = "Telling vegetarians that meat is unhealthy is just preaching to the choir.",
            exampleNative = "Говорить вегетарианцам, что мясо вредно — это preaching to the choir.",
            pos = "phrase", semanticGroup = "idioms_l4_social_dynamics", fillInBlankExclusions = listOf(40811L, 40813L, 40814L, 40815L)),

        WordEntity(id = 40813, setId = 408, languagePair = "en-ru", rarity = "RARE",
            original = "devil's advocate", transliteration = "[ˈdɛvəlz ˈædvəkət]", translation = "адвокат дьявола (спорящий ради спора)",
            definition = "Someone who argues against an idea only to test how strong the arguments are.",
            definitionNative = "Тот, кто спорит с идеей лишь для того, чтобы проверить силу аргументов. Дословно — «адвокат дьявола».",
            example = "Let me play devil's advocate — what if the market drops next year?",
            exampleNative = "Дай я выступлю как devil's advocate — а если рынок упадёт в следующем году?",
            pos = "phrase", semanticGroup = "idioms_l4_social_dynamics", fillInBlankExclusions = listOf(40811L, 40812L, 40814L, 40815L)),

        WordEntity(id = 40814, setId = 408, languagePair = "en-ru", rarity = "RARE",
            original = "sour grapes", transliteration = "[ˈsaʊər ɡreɪps]", translation = "зелен виноград (≈ обесценивание недоступного)",
            definition = "Pretending that something you cannot have is not really worth having.",
            definitionNative = "Делать вид, что недоступное на самом деле и не нужно. Дословно — «кислый виноград» (басня Эзопа).",
            example = "His criticism of the prize is just sour grapes — he wanted to win it himself.",
            exampleNative = "Его критика приза — просто sour grapes: он сам хотел его получить.",
            pos = "phrase", semanticGroup = "idioms_l4_social_dynamics", fillInBlankExclusions = listOf(40811L, 40812L, 40813L, 40815L, 40825L)),

        WordEntity(id = 40815, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "ivory tower", transliteration = "[ˈaɪvəri ˈtaʊər]", translation = "башня из слоновой кости (≈ оторван от жизни)",
            definition = "A place or attitude where someone is separated from real, ordinary problems.",
            definitionNative = "Место или позиция, где человек оторван от обычных, реальных проблем. Дословно — «башня из слоновой кости».",
            example = "Critics say the professor lives in an ivory tower far from real life.",
            exampleNative = "Критики говорят, что профессор живёт в ivory tower вдали от реальной жизни.",
            pos = "phrase", semanticGroup = "idioms_l4_social_dynamics"),

        // ── idioms_l4_communication_advanced (5) ──────────────────────────

        WordEntity(id = 40816, setId = 408, languagePair = "en-ru", rarity = "RARE",
            original = "read between the lines", transliteration = "[rid bɪˈtwin ðə laɪnz]", translation = "читать между строк",
            definition = "To understand the hidden meaning behind what someone actually says or writes.",
            definitionNative = "Понимать скрытый смысл за тем, что человек говорит или пишет. Дословно — «читать между строк».",
            example = "If you read between the lines, his polite letter is actually a refusal.",
            exampleNative = "Если read between the lines, его вежливое письмо — на самом деле отказ.",
            pos = "phrase", semanticGroup = "idioms_l4_communication_advanced", fillInBlankExclusions = listOf(40817L, 40818L, 40819L, 40820L)),

        WordEntity(id = 40817, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "hit below the belt", transliteration = "[hɪt bɪˈloʊ ðə bɛlt]", translation = "ударить ниже пояса",
            definition = "To say or do something that is unfair and hurts another person deeply.",
            definitionNative = "Сказать или сделать нечто нечестное и больное. Дословно — «удар ниже пояса» (запрещён в боксе).",
            example = "His sarcastic remark about her past was meant to hit below the belt.",
            exampleNative = "Его язвительный намёк на её прошлое — это попытка hit below the belt.",
            pos = "phrase", semanticGroup = "idioms_l4_communication_advanced", fillInBlankExclusions = listOf(40816L, 40818L, 40819L, 40820L, 40821L, 40823L)),

        WordEntity(id = 40818, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "on the tip of my tongue", transliteration = "[ɑn ðə tɪp əv maɪ tʌŋ]", translation = "вертится на языке",
            definition = "Almost remembered but not quite recalled at the moment of speaking.",
            definitionNative = "Почти вспомнил, но именно сейчас никак не получается. Дословно — «на кончике языка».",
            example = "Her name is on the tip of my tongue — give me a second to remember.",
            exampleNative = "Её имя on the tip of my tongue — дай мне секунду вспомнить.",
            pos = "phrase", semanticGroup = "idioms_l4_communication_advanced", fillInBlankExclusions = listOf(40816L, 40817L, 40819L, 40820L)),

        WordEntity(id = 40819, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "off the cuff", transliteration = "[ɔf ðə kʌf]", translation = "экспромтом / без подготовки",
            definition = "Said or done without any planning, just immediately and spontaneously.",
            definitionNative = "Сказано или сделано без подготовки, спонтанно. Дословно — «с манжеты» (раньше записывали заметки прямо на манжете).",
            example = "His off the cuff remarks at the meeting caused a small scandal.",
            exampleNative = "Его off the cuff комментарии на встрече вызвали небольшой скандал.",
            pos = "phrase", semanticGroup = "idioms_l4_communication_advanced", fillInBlankExclusions = listOf(40816L, 40817L, 40818L, 40820L, 40824L)),

        WordEntity(id = 40820, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "not mince words", transliteration = "[nɑt mɪns wɜrdz]", translation = "не выбирать выражений",
            definition = "To say what you think very directly, even when the truth might be harsh.",
            definitionNative = "Говорить прямо, даже если правда жестока. Дословно — «не рубить слова на мелкие кусочки».",
            example = "The doctor did not mince words about the seriousness of my condition.",
            exampleNative = "Врач not mince words о серьёзности моего состояния.",
            pos = "phrase", semanticGroup = "idioms_l4_communication_advanced", fillInBlankExclusions = listOf(40816L, 40817L, 40818L, 40819L)),

        // ── idioms_l4_outcomes (5) ────────────────────────────────────────

        WordEntity(id = 40821, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "backfire spectacularly", transliteration = "[ˈbækˌfaɪər spɛkˈtækjələrli]", translation = "обернуться громким провалом",
            definition = "To produce a result that is the very opposite of what was hoped for.",
            definitionNative = "Дать результат, прямо противоположный ожидаемому. Дословно — «зрелищно выстрелить назад».",
            example = "Such a risky tactic could backfire spectacularly if the press finds out.",
            exampleNative = "Такая рискованная тактика может backfire spectacularly, если узнает пресса.",
            pos = "phrase", semanticGroup = "idioms_l4_outcomes", fillInBlankExclusions = listOf(40822L, 40823L, 40824L, 40825L)),

        WordEntity(id = 40822, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "come full circle", transliteration = "[kʌm fʊl ˈsɜrkəl]", translation = "вернуться к исходной точке",
            definition = "To return to the same situation or state where things originally began.",
            definitionNative = "Вернуться в то же положение, с которого всё начиналось. Дословно — «совершить полный круг».",
            example = "After ten years abroad, his career has come full circle back to his hometown.",
            exampleNative = "После десяти лет за границей его карьера come full circle — вернулась в родной город.",
            pos = "phrase", semanticGroup = "idioms_l4_outcomes", fillInBlankExclusions = listOf(40821L, 40823L, 40824L, 40825L)),

        WordEntity(id = 40823, setId = 408, languagePair = "en-ru", rarity = "EPIC",
            original = "blow up in your face", transliteration = "[bloʊ ʌp ɪn jər feɪs]", translation = "взорваться прямо в руках (≈ дать обратный эффект)",
            definition = "When a plan goes wrong suddenly and causes serious trouble for the planner.",
            definitionNative = "Когда план внезапно срывается и сильно вредит самому автору. Дословно — «взорваться в лицо».",
            example = "Risky shortcuts can easily blow up in your face when the deadline arrives.",
            exampleNative = "Рискованные срезанные углы легко могут blow up in your face к дедлайну.",
            pos = "phrase", semanticGroup = "idioms_l4_outcomes", fillInBlankExclusions = listOf(40821L, 40822L, 40824L, 40825L)),

        WordEntity(id = 40824, setId = 408, languagePair = "en-ru", rarity = "RARE",
            original = "set in stone", transliteration = "[sɛt ɪn stoʊn]", translation = "высечено в камне (≈ окончательно)",
            definition = "Fixed, official and impossible to change later under normal circumstances.",
            definitionNative = "Зафиксированный, официальный и неизменный в обычных условиях. Дословно — «высеченный в камне».",
            example = "The schedule isn't set in stone — we can move the meeting if needed.",
            exampleNative = "Расписание не set in stone — мы можем перенести встречу при необходимости.",
            pos = "phrase", semanticGroup = "idioms_l4_outcomes", fillInBlankExclusions = listOf(40821L, 40822L, 40823L, 40825L)),

        WordEntity(id = 40825, setId = 408, languagePair = "en-ru", rarity = "RARE",
            original = "water under the bridge", transliteration = "[ˈwɔtər ˈʌndər ðə brɪʤ]", translation = "дело прошлое (≈ что было, то прошло)",
            definition = "A past unpleasant event that is now over and should not affect the present.",
            definitionNative = "Прошлая неприятность, которая уже позади и не влияет на настоящее. Дословно — «вода под мостом».",
            example = "Our old quarrel is water under the bridge — let's just focus on the project.",
            exampleNative = "Наша старая ссора — water under the bridge, сосредоточимся на проекте.",
            pos = "phrase", semanticGroup = "idioms_l4_outcomes", fillInBlankExclusions = listOf(40811L, 40821L, 40822L, 40823L, 40824L)),
    )
}
