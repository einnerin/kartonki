package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Идиомы и устойчивые выражения (L5, LEGENDARY+EPIC).
 *
 * Set 409: «Идиомы и устойчивые выражения» — носительский / литературный
 *          уровень. Финальный сет темы (после L1 = 405, L2 = 406,
 *          L3 = 407, L4 = 408). Здесь — латинские крылатые выражения,
 *          вошедшие в английский высокий регистр (carpe diem, sine qua non,
 *          quid pro quo и т.д.), литературные классические идиомы
 *          (gild the lily, hoist by your own petard — Шекспир, the die
 *          is cast — Цезарь), пословицы (birds of a feather, a stitch in
 *          time saves nine), отсылки к классическому миру (sword of
 *          Damocles, achilles' heel, gordian knot, pyrrhic victory) и
 *          формулы классического регистра (ad hominem, ipso facto,
 *          modus operandi). Эти выражения встречаются в качественной
 *          прозе, юридическом и академическом дискурсе и эрудированной
 *          речи — их понимание = метка C2.
 *
 * Распределение редкости: 17 LEGENDARY (C2) + 8 EPIC (C1).
 * Это два смежных уровня — правило разброса соблюдено. COMMON-слов
 * в идиомах не бывает по определению (см. комментарий к L1).
 *
 * Дублей с L1-L3 нет — все 25 фраз новые. Cross-topic пересечения:
 *   - "ad hominem" уже есть в set 87 (Философия / logic_fallacies)
 *   - "ipso facto" уже есть в set 298 (Право / law_latin_formulas_evidence)
 * Это разные темы — по политике дублей (см. feedback_duplicate_words_policy)
 * допустимо.
 *
 * SemanticGroups (5 × 5):
 *   idioms_l5_latin_archaic       — carpe diem, sine qua non, ad nauseam,
 *                                   mea culpa, status quo
 *   idioms_l5_literary_archaic    — gild the lily, hoist by your own
 *                                   petard, the die is cast, the proof
 *                                   is in the pudding, a man of straw
 *   idioms_l5_proverbial          — birds of a feather flock together,
 *                                   a stitch in time saves nine, fortune
 *                                   favors the bold, every cloud has a
 *                                   silver lining, where there's smoke
 *                                   there's fire
 *   idioms_l5_advanced_idiomatic  — pyrrhic victory, throw down the
 *                                   gauntlet, sword of Damocles,
 *                                   achilles' heel, gordian knot
 *   idioms_l5_classical_register  — quid pro quo, ad hominem, vox populi,
 *                                   ipso facto, modus operandi
 *
 * Word IDs: setId × 100 + position (40901..40925).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions пустые — заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishIdiomsL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 409,
            languagePair = "en-ru",
            orderIndex = 409,
            name = "Идиомы и устойчивые выражения",
            description = "Латинские, литературные и пословичные идиомы высокого регистра",
            topic = "Идиомы и устойчивые выражения",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 409 — Идиомы: носительский уровень (L5, LEGENDARY+EPIC)      ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── idioms_l5_latin_archaic (5) ───────────────────────────────────

        WordEntity(id = 40901, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "carpe diem", transliteration = "[ˈkɑrpeɪ ˈdiɛm]", translation = "лови момент / живи настоящим",
            definition = "A call to seize the present moment and not to delay enjoying life.",
            definitionNative = "Призыв ловить момент и не откладывать радость жизни. Латинская фраза Горация — дословно «срывай день».",
            example = "His motto was carpe diem — he never postponed an adventure.",
            exampleNative = "Его девизом было carpe diem — он никогда не откладывал приключения.",
            pos = "phrase", semanticGroup = "idioms_l5_latin_archaic",  fillInBlankExclusions = listOf(40902L, 40903L, 40904L, 40905L, 40913L)),

        WordEntity(id = 40902, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sine qua non", transliteration = "[ˌsɪneɪ kwɑ ˈnoʊn]", translation = "обязательное условие (≈ без чего нельзя)",
            definition = "An essential condition without which something cannot exist or succeed.",
            definitionNative = "Обязательное условие, без которого что-то не может существовать или удаться. Латынь — дословно «без чего не».",
            example = "Trust is the sine qua non of any lasting partnership.",
            exampleNative = "Доверие — это sine qua non любого прочного партнёрства.",
            pos = "phrase", semanticGroup = "idioms_l5_latin_archaic",  fillInBlankExclusions = listOf(40901L, 40903L, 40904L, 40905L)),

        WordEntity(id = 40903, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ad nauseam", transliteration = "[æd ˈnɔziəm]", translation = "до тошноты / без конца",
            definition = "Repeated or continued so often that it becomes annoying or sickening.",
            definitionNative = "Повторяемое или продолжаемое так часто, что вызывает раздражение или тошноту. Латынь — дословно «до тошноты».",
            example = "He repeated the same complaint ad nauseam at every meeting.",
            exampleNative = "Он повторял одну и ту же жалобу ad nauseam на каждом совещании.",
            pos = "phrase", semanticGroup = "idioms_l5_latin_archaic",  fillInBlankExclusions = listOf(40901L, 40902L, 40904L, 40905L)),

        WordEntity(id = 40904, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mea culpa", transliteration = "[ˌmeɪə ˈkʊlpə]", translation = "моя вина (формальное признание)",
            definition = "A formal admission that one is personally responsible for a mistake.",
            definitionNative = "Формальное признание собственной ответственности за ошибку. Латынь из католической молитвы — «моя вина».",
            example = "The CEO issued a public mea culpa for the company's missteps.",
            exampleNative = "Директор публично произнёс mea culpa за промахи компании.",
            pos = "phrase", semanticGroup = "idioms_l5_latin_archaic",  fillInBlankExclusions = listOf(40901L, 40902L, 40903L, 40905L)),

        WordEntity(id = 40905, setId = 409, languagePair = "en-ru", rarity = "EPIC",
            original = "status quo", transliteration = "[ˈsteɪtəs kwoʊ]", translation = "статус-кво / нынешнее положение",
            definition = "The existing state of affairs, especially in social or political matters.",
            definitionNative = "Существующее положение дел, особенно в общественных или политических вопросах. Латынь — дословно «положение, в котором».",
            example = "The new minister has no intention of changing the status quo.",
            exampleNative = "Новый министр не намерен менять status quo.",
            pos = "phrase", semanticGroup = "idioms_l5_latin_archaic",  fillInBlankExclusions = listOf(40901L, 40902L, 40903L, 40904L, 40925L)),

        // ── idioms_l5_literary_archaic (5) ────────────────────────────────

        WordEntity(id = 40906, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gild the lily", transliteration = "[ɡɪld ðə ˈlɪli]", translation = "переусердствовать с украшениями (≈ масло масляное)",
            definition = "To add unnecessary decoration to something already beautiful or fine.",
            definitionNative = "Добавлять ненужные украшения к чему-то и без того прекрасному. Шекспировский оборот — дословно «золотить лилию».",
            example = "The dress is perfect — adding diamonds would be to gild the lily.",
            exampleNative = "Платье и так идеально — добавлять бриллианты значит gild the lily.",
            pos = "phrase", semanticGroup = "idioms_l5_literary_archaic",  fillInBlankExclusions = listOf(40907L, 40908L, 40909L, 40910L)),

        WordEntity(id = 40907, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hoist by your own petard", transliteration = "[hɔɪst baɪ jər oʊn pəˈtɑrd]", translation = "попасться в собственную ловушку",
            definition = "Harmed by the very plan or device with which you intended to harm others.",
            definitionNative = "Пойман в ловушку, что приготовил для других. «Petard» — старая бомба, которая сама поднимала.",
            example = "Time will hoist by your own petard the blackmailer who leaked those letters.",
            exampleNative = "Шантажист оказался hoist by his own petard, когда его письма утекли.",
            pos = "phrase", semanticGroup = "idioms_l5_literary_archaic",  fillInBlankExclusions = listOf(40906L, 40908L, 40909L, 40910L)),

        WordEntity(id = 40908, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "the die is cast", transliteration = "[ðə daɪ ɪz kæst]", translation = "жребий брошен (≈ пути назад нет)",
            definition = "An irreversible decision has been made and events must now run their course.",
            definitionNative = "Принято необратимое решение, и события должны идти своим чередом. Слова Цезаря на Рубиконе — дословно «кость брошена».",
            example = "We've sent the resignation letter — the die is cast.",
            exampleNative = "Мы отправили заявление об уходе — the die is cast.",
            pos = "phrase", semanticGroup = "idioms_l5_literary_archaic",  fillInBlankExclusions = listOf(40906L, 40907L, 40909L, 40910L, 40913L)),

        WordEntity(id = 40909, setId = 409, languagePair = "en-ru", rarity = "EPIC",
            original = "the proof is in the pudding", transliteration = "[ðə pruf ɪz ɪn ðə ˈpʊdɪŋ]", translation = "всё проверяется на практике",
            definition = "The real value or quality of something can only be judged by trying it.",
            definitionNative = "Истинное качество видно только после проверки. Шекспировская формула.",
            example = "The new method sounds promising, but the proof is in the pudding.",
            exampleNative = "Новый метод звучит многообещающе, но the proof is in the pudding.",
            pos = "phrase", semanticGroup = "idioms_l5_literary_archaic",  fillInBlankExclusions = listOf(40906L, 40907L, 40908L, 40910L)),

        WordEntity(id = 40910, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "a man of straw", transliteration = "[ə mæn əv strɔ]", translation = "соломенное чучело (≈ слабый/мнимый соперник)",
            definition = "A person without substance or real power, often a weak imaginary opponent.",
            definitionNative = "Человек без сущности или реальной силы, часто слабый воображаемый противник. Дословно — «человек из соломы».",
            example = "His critics turned out to be a man of straw — they had no real argument.",
            exampleNative = "Его критики оказались a man of straw — настоящих аргументов у них не было.",
            pos = "phrase", semanticGroup = "idioms_l5_literary_archaic",  fillInBlankExclusions = listOf(40906L, 40907L, 40908L, 40909L)),

        // ── idioms_l5_proverbial (5) ──────────────────────────────────────

        WordEntity(id = 40911, setId = 409, languagePair = "en-ru", rarity = "EPIC",
            original = "birds of a feather flock together", transliteration = "[bɜrdz əv ə ˈfɛðər flɑk təˈɡɛðər]", translation = "рыбак рыбака видит издалека",
            definition = "People with similar tastes or characters tend to spend time together.",
            definitionNative = "Люди схожих взглядов обычно держатся вместе. Дословно — «птицы одного пера летают вместе».",
            example = "Both love jazz and chess — birds of a feather flock together.",
            exampleNative = "Оба обожают джаз и шахматы — birds of a feather flock together.",
            pos = "phrase", semanticGroup = "idioms_l5_proverbial",  fillInBlankExclusions = listOf(40912L, 40913L, 40914L, 40915L)),

        WordEntity(id = 40912, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "a stitch in time saves nine", transliteration = "[ə stɪʧ ɪn taɪm seɪvz naɪn]", translation = "вовремя сделанное малое избавляет от большого",
            definition = "A small action taken early can prevent much bigger problems later.",
            definitionNative = "Малое усилие вовремя предотвращает большие проблемы. Один стежок экономит девять.",
            example = "Fix the leak today — a stitch in time saves nine.",
            exampleNative = "Почини протечку сегодня — a stitch in time saves nine.",
            pos = "phrase", semanticGroup = "idioms_l5_proverbial",  fillInBlankExclusions = listOf(40901L, 40911L, 40913L, 40914L, 40915L)),

        WordEntity(id = 40913, setId = 409, languagePair = "en-ru", rarity = "EPIC",
            original = "fortune favors the bold", transliteration = "[ˈfɔrʧən ˈfeɪvərz ðə boʊld]", translation = "смелым сопутствует удача",
            definition = "People who take risks are more likely to achieve great success.",
            definitionNative = "Тем, кто рискует, чаще сопутствует большой успех. Латинская пословица «audentes fortuna iuvat» в английском переводе.",
            example = "She quit her stable job to start her own firm — fortune favors the bold.",
            exampleNative = "Она оставила стабильную работу ради своей фирмы — fortune favors the bold.",
            pos = "phrase", semanticGroup = "idioms_l5_proverbial",  fillInBlankExclusions = listOf(40901L, 40908L, 40911L, 40912L, 40914L, 40915L)),

        WordEntity(id = 40914, setId = 409, languagePair = "en-ru", rarity = "EPIC",
            original = "every cloud has a silver lining", transliteration = "[ˈɛvri klaʊd hæz ə ˈsɪlvər ˈlaɪnɪŋ]", translation = "нет худа без добра",
            definition = "Every difficult or sad situation has some positive aspect to it.",
            definitionNative = "В любой беде есть положительная сторона. Дословно — «у каждой тучи серебряная подкладка».",
            example = "Losing the contract was hard, but every cloud has a silver lining.",
            exampleNative = "Потеря контракта далась тяжело, но every cloud has a silver lining.",
            pos = "phrase", semanticGroup = "idioms_l5_proverbial",  fillInBlankExclusions = listOf(40911L, 40912L, 40913L, 40915L)),

        WordEntity(id = 40915, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "where there's smoke there's fire", transliteration = "[wɛr ðɛrz smoʊk ðɛrz ˈfaɪər]", translation = "нет дыма без огня",
            definition = "If there are rumours about something, there is probably some truth in them.",
            definitionNative = "Если о чём-то ходят слухи, в них, вероятно, есть доля правды. Английская пословица — дословно «где дым, там огонь».",
            example = "The board denies the merger, but where there's smoke there's fire.",
            exampleNative = "Совет директоров отрицает слияние, но where there's smoke there's fire.",
            pos = "phrase", semanticGroup = "idioms_l5_proverbial",  fillInBlankExclusions = listOf(40911L, 40912L, 40913L, 40914L)),

        // ── idioms_l5_advanced_idiomatic (5) ──────────────────────────────

        WordEntity(id = 40916, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "pyrrhic victory", transliteration = "[ˈpɪrɪk ˈvɪktəri]", translation = "пиррова победа",
            definition = "A success that is gained at such great cost that it is hardly worth it.",
            definitionNative = "Успех, достигнутый такой высокой ценой, что вряд ли оправдан. По имени царя Пирра, чьи победы над Римом обескровили его армию.",
            example = "Winning the lawsuit was a pyrrhic victory — the legal fees ruined them.",
            exampleNative = "Выигрыш в суде стал pyrrhic victory — судебные издержки их разорили.",
            pos = "phrase", semanticGroup = "idioms_l5_advanced_idiomatic",  fillInBlankExclusions = listOf(40917L, 40918L, 40920L)),

        WordEntity(id = 40917, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "throw down the gauntlet", transliteration = "[θroʊ daʊn ðə ˈɡɔntlət]", translation = "бросить вызов",
            definition = "To openly challenge someone to a fight, contest or argument.",
            definitionNative = "Открыто вызвать кого-то на бой, соревнование или спор. Из рыцарской традиции — дословно «бросить латную перчатку».",
            example = "By publishing the manifesto, he meant to throw down the gauntlet to the establishment.",
            exampleNative = "Опубликовав манифест, он throw down the gauntlet истеблишменту.",
            pos = "phrase", semanticGroup = "idioms_l5_advanced_idiomatic",  fillInBlankExclusions = listOf(40916L, 40918L, 40919L, 40920L)),

        WordEntity(id = 40918, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sword of Damocles", transliteration = "[sɔrd əv ˈdæməkliz]", translation = "дамоклов меч",
            definition = "A constant threat or danger that hangs over someone in a position of power.",
            definitionNative = "Постоянная угроза или опасность, висящая над тем, кто находится у власти. Из античной притчи о Дамокле и Дионисии.",
            example = "The threat of an audit hung over him like a sword of Damocles.",
            exampleNative = "Угроза проверки висела над ним, как sword of Damocles.",
            pos = "phrase", semanticGroup = "idioms_l5_advanced_idiomatic",  fillInBlankExclusions = listOf(40916L, 40917L, 40920L)),

        WordEntity(id = 40919, setId = 409, languagePair = "en-ru", rarity = "EPIC",
            original = "achilles' heel", transliteration = "[əˈkɪliz hil]", translation = "ахиллесова пята / уязвимое место",
            definition = "A small but serious weakness in an otherwise strong person or system.",
            definitionNative = "Маленькая, но серьёзная слабость в иначе сильном человеке или системе. По мифу об Ахилле — дословно «пята Ахилла».",
            example = "His temper was the achilles' heel of an otherwise great career.",
            exampleNative = "Вспыльчивость стала achilles' heel его в остальном блестящей карьеры.",
            pos = "phrase", semanticGroup = "idioms_l5_advanced_idiomatic",  fillInBlankExclusions = listOf(40916L, 40917L, 40918L, 40920L)),

        WordEntity(id = 40920, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gordian knot", transliteration = "[ˈɡɔrdiən nɑt]", translation = "гордиев узел (≈ запутанная задача)",
            definition = "An extremely difficult problem that is solved only by a bold, unexpected action.",
            definitionNative = "Чрезвычайно сложная задача, решаемая лишь смелым нестандартным действием. По легенде об Александре Македонском, разрубившем узел.",
            example = "Tax law in this country is a true gordian knot.",
            exampleNative = "Налоговое право в этой стране — настоящий gordian knot.",
            pos = "phrase", semanticGroup = "idioms_l5_advanced_idiomatic",  fillInBlankExclusions = listOf(40916L, 40917L, 40918L, 40919L)),

        // ── idioms_l5_classical_register (5) ──────────────────────────────

        WordEntity(id = 40921, setId = 409, languagePair = "en-ru", rarity = "EPIC",
            original = "quid pro quo", transliteration = "[ˌkwɪd proʊ ˈkwoʊ]", translation = "услуга за услугу",
            definition = "A favour or advantage given in return for something of similar value.",
            definitionNative = "Услуга или преимущество, предоставленное в обмен на нечто равноценное. Латынь — дословно «то за это».",
            example = "He offered information as a quid pro quo for protection.",
            exampleNative = "Он предложил информацию как quid pro quo за защиту.",
            pos = "phrase", semanticGroup = "idioms_l5_classical_register",  fillInBlankExclusions = listOf(40923L, 40925L)),

        WordEntity(id = 40922, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cui bono", transliteration = "[kuˈi ˈboʊnoʊ]", translation = "кому выгодно (юр. латынь)",
            definition = "A question asked to find who benefits from an action and may be the cause.",
            definitionNative = "Вопрос «кому выгодно», помогающий найти возможного виновника. Латынь — «во благо кому».",
            example = "When investigating the leak, ask cui bono before accusing anyone.",
            exampleNative = "При расследовании утечки сначала задай cui bono, потом обвиняй.",
            pos = "phrase", semanticGroup = "idioms_l5_classical_register"),

        WordEntity(id = 40923, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "vox populi", transliteration = "[ˌvɑks ˈpɑpjəlaɪ]", translation = "глас народа / общественное мнение",
            definition = "The opinion or voice of ordinary people, especially as a force in politics.",
            definitionNative = "Мнение или голос обычных людей, особенно как сила в политике. Латынь — дословно «голос народа».",
            example = "The newspaper's editorial claimed to speak for vox populi.",
            exampleNative = "Передовица газеты утверждала, что выражает vox populi.",
            pos = "phrase", semanticGroup = "idioms_l5_classical_register",  fillInBlankExclusions = listOf(40921L, 40922L, 40924L, 40925L)),

        WordEntity(id = 40924, setId = 409, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "in absentia", transliteration = "[ɪn æbˈsɛnʃə]", translation = "заочно / в отсутствие",
            definition = "Done while the person involved is not physically present.",
            definitionNative = "В отсутствие самого человека — заочно, без него. Латынь — дословно «в отсутствии».",
            example = "He was tried in absentia after fleeing the country before the verdict.",
            exampleNative = "Его судили in absentia после того, как он покинул страну.",
            pos = "phrase", semanticGroup = "idioms_l5_classical_register"),

        WordEntity(id = 40925, setId = 409, languagePair = "en-ru", rarity = "EPIC",
            original = "modus operandi", transliteration = "[ˈmoʊdəs ˌɑpəˈrændi]", translation = "образ действий / почерк",
            definition = "A characteristic way in which a person or group habitually performs tasks.",
            definitionNative = "Привычный способ действия. Латынь — буквально «образ действия».",
            example = "Quiet entry through the back window is the burglar's usual modus operandi.",
            exampleNative = "Тихий вход через заднее окно — обычный modus operandi этого взломщика.",
            pos = "phrase", semanticGroup = "idioms_l5_classical_register",  fillInBlankExclusions = listOf(40905L, 40921L, 40922L, 40923L, 40924L)),
    )
}
