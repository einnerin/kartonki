package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Фразовые глаголы (L5, EPIC+LEGENDARY).
 *
 * Set 414: «Фразовые глаголы» — уровень носителя.
 *          Phrasal verbs уровня C2: архаичные, литературные, юридические,
 *          формальные регистры, эмоционально-возвышенная речь.
 *          Финальная ступень линейки L1 (410) – L2 (411) – L3 (412) – L4 (413).
 *          На этом уровне фразовые глаголы практически не встречаются
 *          в повседневной речи — они живут в поэзии, классической прозе,
 *          юридических документах и высоком стиле: abide by (= соблюдать
 *          закон), hark back (= восходить, отсылать к прошлому),
 *          languish in (= томиться в).
 *
 * Phrasal verbs остаются отдельным классом от:
 *   • обычных verbs (run, eat, sleep — одно слово)
 *   • idioms (kill two birds with one stone — образное выражение)
 *
 * Распределение редкости: 8 EPIC + 17 LEGENDARY.
 * EPIC — фразовые глаголы C1, формальные но всё ещё встречаемые в
 * академических текстах (adhere to, wind down, expound upon, embark upon,
 * elaborate on, marvel at, happen upon, stumble upon). LEGENDARY — C2+:
 * архаичная и литературная лексика (abide by, hark back, hew down,
 * wend along, give over, betake yourself, accede to, abound in,
 * infringe upon, divest of, pine for, mourn over, languish in, exult in,
 * prevail upon, light upon, dwell upon).
 *
 * ⚠️ Коллизии при подготовке (проверено grep'ом по `original = "..."`):
 *   все 25 phrasal verbs L5 свободны — пересечений с L1 (410), L2 (411),
 *   L3 (412), L4 (413) и прочими тематическими наборами не обнаружено.
 *   Близкие синонимы happen upon / stumble upon / light upon оставлены
 *   все три как канонические литературные phrasal verbs (chance upon
 *   уехал в L4); они различаются регистром: happen upon — нейтрально-
 *   литературное, stumble upon — частотный книжный, light upon —
 *   высокая поэзия.
 *
 * SemanticGroups (5 × 5):
 *   phrasal_l5_archaic_literary — abide by, hark back, hew down, wend along, give over
 *   phrasal_l5_formal_register  — adhere to, abound in, infringe upon, accede to, betake yourself
 *   phrasal_l5_legal_business   — wind down, divest of, expound upon, embark upon, elaborate on
 *   phrasal_l5_emotional_high   — pine for, mourn over, languish in, exult in, marvel at
 *   phrasal_l5_obscure          — happen upon, stumble upon, light upon, prevail upon, dwell upon
 *
 * Word IDs: setId × 100 + position (41401..41425).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions пустые — заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishPhrasalVerbsL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 414,
            languagePair = "en-ru",
            orderIndex = 414,
            name = "Фразовые глаголы",
            description = "Архаичные, литературные, юридические и эмоционально-возвышенные фразовые глаголы для уровня носителя",
            topic = "Фразовые глаголы",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 414 — Фразовые глаголы: уровень носителя (L5, EPIC+LEGENDARY)   ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── phrasal_l5_archaic_literary (5) ────────────────────────────────

        WordEntity(id = 41401, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "abide by", transliteration = "[əˈbaɪd baɪ]", translation = "соблюдать (закон, правило)",
            definition = "To accept and act according to a rule, law or decision, even reluctantly.",
            definitionNative = "Принимать правило, закон или решение и действовать в согласии с ним — даже неохотно.",
            example = "Every member of the order must abide by the ancient code without question.",
            exampleNative = "Каждый член ордена обязан abide by древний устав без вопросов.",
            pos = "phrase", semanticGroup = "phrasal_l5_archaic_literary", fillInBlankExclusions = listOf(41402L, 41403L, 41404L, 41405L, 41406L)),

        WordEntity(id = 41402, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hark back", transliteration = "[hɑrk bæk]", translation = "восходить (к прошлому), напоминать о былом",
            definition = "To remind one of something from the past or to return to an earlier subject.",
            definitionNative = "Напомнить о чём-то из прошлого или вернуться в разговоре к более ранней теме.",
            example = "These wooden ships hark back to the golden age of sail.",
            exampleNative = "Эти деревянные корабли hark back к золотому веку парусов.",
            pos = "phrase", semanticGroup = "phrasal_l5_archaic_literary", fillInBlankExclusions = listOf(41401L, 41403L, 41404L, 41405L)),

        WordEntity(id = 41403, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hew down", transliteration = "[hju daʊn]", translation = "срубить, повергнуть (топором, мечом)",
            definition = "To cut something, especially a tree, down with heavy blows of an axe or sword.",
            definitionNative = "Свалить большое дерево или сразить врага мощными ударами клинка.",
            example = "The men were told to hew down the old oak.",
            exampleNative = "Дровосеки hew down вековой дуб, простоявший столетия.",
            pos = "phrase", semanticGroup = "phrasal_l5_archaic_literary", fillInBlankExclusions = listOf(41401L, 41402L, 41404L, 41405L)),

        WordEntity(id = 41404, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "wend along", transliteration = "[wɛnd əˈlɔŋ]", translation = "брести, неспешно следовать (своим путём)",
            definition = "To travel slowly and steadily along a path, especially in a winding manner.",
            definitionNative = "Двигаться медленно и неспешно по пути — обычно извилистому.",
            example = "The pilgrims wend along the dusty road towards the distant cathedral.",
            exampleNative = "Паломники wend along по пыльной дороге к далёкому собору.",
            pos = "phrase", semanticGroup = "phrasal_l5_archaic_literary", fillInBlankExclusions = listOf(41401L, 41402L, 41403L, 41405L)),

        WordEntity(id = 41405, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "give over", transliteration = "[ɡɪv ˈoʊvər]", translation = "оставить, прекратить (заниматься чем-то)",
            definition = "To stop doing something or to surrender oneself to a particular feeling or activity.",
            definitionNative = "Прекратить какое-то занятие или предаться определённому чувству или делу.",
            example = "Give over your foolish dreams of glory and return to your duty.",
            exampleNative = "Give over свои глупые мечты о славе и вернись к долгу.",
            pos = "phrase", semanticGroup = "phrasal_l5_archaic_literary", fillInBlankExclusions = listOf(41401L, 41402L, 41403L, 41404L)),

        // ── phrasal_l5_formal_register (5) ─────────────────────────────────

        WordEntity(id = 41406, setId = 414, languagePair = "en-ru", rarity = "EPIC",
            original = "adhere to", transliteration = "[ədˈhɪr tu]", translation = "придерживаться, неуклонно соблюдать",
            definition = "To behave according to a rule, agreement or belief without changing it.",
            definitionNative = "Действовать в строгом соответствии с правилом, соглашением или убеждением.",
            example = "All researchers must adhere to the strict ethical guidelines of the institute.",
            exampleNative = "Все исследователи обязаны adhere to строгим этическим нормам института.",
            pos = "phrase", semanticGroup = "phrasal_l5_formal_register", fillInBlankExclusions = listOf(41401L, 41407L, 41408L, 41409L, 41410L, 41413L, 41415L, 41425L)),

        WordEntity(id = 41407, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "abound in", transliteration = "[əˈbaʊnd ɪn]", translation = "изобиловать, быть полным (чем-то)",
            definition = "To exist in great numbers or amounts in a particular place or text.",
            definitionNative = "Иметься в очень большом количестве в каком-то месте или тексте.",
            example = "The ancient manuscript abound in references to forgotten kingdoms.",
            exampleNative = "Древняя рукопись abound in отсылками к забытым царствам.",
            pos = "phrase", semanticGroup = "phrasal_l5_formal_register", fillInBlankExclusions = listOf(41406L, 41408L, 41409L, 41410L, 41413L, 41415L, 41425L)),

        WordEntity(id = 41408, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "infringe upon", transliteration = "[ɪnˈfrɪnʤ əˈpɑn]", translation = "посягать на, нарушать (право)",
            definition = "To act in a way that limits or violates someone's right or freedom.",
            definitionNative = "Действовать так, чтобы ограничить или нарушить чьё-то право или свободу.",
            example = "The new law must not infringe upon the freedoms guaranteed by the constitution.",
            exampleNative = "Новый закон не должен infringe upon свободы, гарантированные конституцией.",
            pos = "phrase", semanticGroup = "phrasal_l5_formal_register", fillInBlankExclusions = listOf(41406L, 41407L, 41409L, 41410L)),

        WordEntity(id = 41409, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "accede to", transliteration = "[əkˈsid tu]", translation = "согласиться (на просьбу), уступить",
            definition = "To agree to a request or demand, especially after consideration in a formal setting.",
            definitionNative = "Принять чужое требование — обычно после раздумий в формальной обстановке.",
            example = "The council refused to accede to the ambassador's demands.",
            exampleNative = "После долгих переговоров совет accede to требованиям посла.",
            pos = "phrase", semanticGroup = "phrasal_l5_formal_register", fillInBlankExclusions = listOf(41401L, 41406L, 41407L, 41408L, 41410L, 41413L, 41415L, 41420L, 41425L)),

        WordEntity(id = 41410, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "betake yourself", transliteration = "[bɪˈteɪk jɔrˈsɛlf]", translation = "отправиться, удалиться (куда-то)",
            definition = "To go to a particular place, especially formally or in old-fashioned literary style.",
            definitionNative = "Пойти в какое-то место — слово книжное, из старинного литературного стиля.",
            example = "I shall betake yourself to the library and seek the answer in the old volumes.",
            exampleNative = "Я betake yourself в библиотеку и поищу ответ в старых томах.",
            pos = "phrase", semanticGroup = "phrasal_l5_formal_register", fillInBlankExclusions = listOf(41406L, 41407L, 41408L, 41409L)),

        // ── phrasal_l5_legal_business (5) ──────────────────────────────────

        WordEntity(id = 41411, setId = 414, languagePair = "en-ru", rarity = "EPIC",
            original = "wind down", transliteration = "[waɪnd daʊn]", translation = "сворачивать (бизнес, операцию)",
            definition = "To gradually reduce the activity of a business or project until it ends.",
            definitionNative = "Постепенно сокращать деятельность бизнеса или проекта до полного завершения.",
            example = "The board has decided to wind down the European division by year's end.",
            exampleNative = "Совет директоров решил wind down европейское подразделение к концу года.",
            pos = "phrase", semanticGroup = "phrasal_l5_legal_business", fillInBlankExclusions = listOf(41405L, 41412L, 41413L, 41414L, 41415L)),

        WordEntity(id = 41412, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "divest of", transliteration = "[daɪˈvɛst ʌv]", translation = "освободиться от (актива, обязательства)",
            definition = "To formally remove or sell off an asset, holding or right, especially in legal contexts.",
            definitionNative = "Официально снять или продать актив, долю или право — особенно в юридическом контексте.",
            example = "The court ordered the corporation to divest of its competing subsidiary.",
            exampleNative = "Суд обязал корпорацию divest of конкурирующую дочернюю компанию.",
            pos = "phrase", semanticGroup = "phrasal_l5_legal_business", fillInBlankExclusions = listOf(41405L, 41411L, 41413L, 41414L, 41415L)),

        WordEntity(id = 41413, setId = 414, languagePair = "en-ru", rarity = "EPIC",
            original = "expound upon", transliteration = "[ɪkˈspaʊnd əˈpɑn]", translation = "подробно излагать, разъяснять",
            definition = "To explain or describe a topic in detail, especially in a formal or scholarly way.",
            definitionNative = "Подробно объяснить или описать тему — обычно формально или в учёном стиле.",
            example = "The professor will expound upon the theory in next week's lecture.",
            exampleNative = "Профессор будет expound upon эту теорию на лекции на следующей неделе.",
            pos = "phrase", semanticGroup = "phrasal_l5_legal_business", fillInBlankExclusions = listOf(41401L, 41406L, 41409L, 41411L, 41412L, 41414L, 41415L, 41420L, 41425L)),

        WordEntity(id = 41414, setId = 414, languagePair = "en-ru", rarity = "EPIC",
            original = "embark upon", transliteration = "[ɪmˈbɑrk əˈpɑn]", translation = "приступить (к большому делу)",
            definition = "To begin a long, important or difficult enterprise, project or journey.",
            definitionNative = "Начать долгое, важное или трудное предприятие, проект или путешествие.",
            example = "The firm is about to embark upon its most ambitious expansion in a decade.",
            exampleNative = "Фирма собирается embark upon свою самую амбициозную экспансию за десятилетие.",
            pos = "phrase", semanticGroup = "phrasal_l5_legal_business", fillInBlankExclusions = listOf(41406L, 41411L, 41412L, 41413L, 41415L, 41419L, 41420L, 41425L)),

        WordEntity(id = 41415, setId = 414, languagePair = "en-ru", rarity = "EPIC",
            original = "elaborate on", transliteration = "[ɪˈlæbəˌreɪt ɑn]", translation = "развить мысль, детализировать",
            definition = "To give more details or further information about something already mentioned.",
            definitionNative = "Сообщить больше подробностей или информации о том, что уже упомянуто.",
            example = "Could you elaborate on the proposed changes to the contract?",
            exampleNative = "Не могли бы вы elaborate on предлагаемые изменения в контракте?",
            pos = "phrase", semanticGroup = "phrasal_l5_legal_business", fillInBlankExclusions = listOf(41401L, 41405L, 41406L, 41409L, 41411L, 41412L, 41413L, 41414L, 41425L)),

        // ── phrasal_l5_emotional_high (5) ──────────────────────────────────

        WordEntity(id = 41416, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "pine for", transliteration = "[paɪn fɔr]", translation = "тосковать, томиться по",
            definition = "To miss someone or something deeply and to long for their return or presence.",
            definitionNative = "Глубоко скучать по кому-то или чему-то и страстно желать их возвращения.",
            example = "Exiles often pine for the homeland they have lost.",
            exampleNative = "Изгнанный принц всё ещё pine for родину, потерянную в юности.",
            pos = "phrase", semanticGroup = "phrasal_l5_emotional_high", fillInBlankExclusions = listOf(41417L, 41418L, 41419L, 41420L, 41425L)),

        WordEntity(id = 41417, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mourn over", transliteration = "[mɔrn ˈoʊvər]", translation = "оплакивать, скорбеть о",
            definition = "To feel and express deep sorrow over a loss, especially of a person or an era.",
            definitionNative = "Испытывать и выражать глубокую скорбь по утрате — обычно человека или эпохи.",
            example = "For years she would mourn over the friends taken by the great plague.",
            exampleNative = "Многие годы она будет mourn over друзей, унесённых великой чумой.",
            pos = "phrase", semanticGroup = "phrasal_l5_emotional_high", fillInBlankExclusions = listOf(41416L, 41418L, 41419L, 41420L, 41425L)),

        WordEntity(id = 41418, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "languish in", transliteration = "[ˈlæŋɡwɪʃ ɪn]", translation = "томиться, чахнуть в",
            definition = "To exist in an unpleasant or weakening state for a long time without hope.",
            definitionNative = "Долго пребывать в тяжёлом или ослабляющем состоянии без надежды.",
            example = "The dissident was made to languish in a forgotten cell for many years.",
            exampleNative = "Диссидента заставили languish in забытой камере долгие годы.",
            pos = "phrase", semanticGroup = "phrasal_l5_emotional_high", fillInBlankExclusions = listOf(41416L, 41417L, 41419L, 41420L)),

        WordEntity(id = 41419, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "exult in", transliteration = "[ɪɡˈzʌlt ɪn]", translation = "ликовать, торжествовать (по поводу)",
            definition = "To show great joy and triumph over a victory, achievement or another's defeat.",
            definitionNative = "Показывать великую радость и торжество по поводу победы или поражения другого.",
            example = "The conqueror would exult in every battle won upon the open field.",
            exampleNative = "Завоеватель будет exult in каждой победе, одержанной в открытом поле.",
            pos = "phrase", semanticGroup = "phrasal_l5_emotional_high", fillInBlankExclusions = listOf(41413L, 41415L, 41416L, 41417L, 41418L, 41420L, 41425L)),

        WordEntity(id = 41420, setId = 414, languagePair = "en-ru", rarity = "EPIC",
            original = "marvel at", transliteration = "[ˈmɑrvəl æt]", translation = "восхищаться, дивиться (чему-то)",
            definition = "To feel great surprise and admiration when looking at something extraordinary.",
            definitionNative = "Испытывать сильное удивление и восхищение, глядя на нечто исключительное.",
            example = "Visitors still marvel at the craftsmanship of these ancient mosaics.",
            exampleNative = "Посетители до сих пор marvel at мастерству этих древних мозаик.",
            pos = "phrase", semanticGroup = "phrasal_l5_emotional_high", fillInBlankExclusions = listOf(41413L, 41415L, 41416L, 41417L, 41418L, 41419L, 41421L, 41422L, 41423L, 41425L)),

        // ── phrasal_l5_obscure (5) ─────────────────────────────────────────

        WordEntity(id = 41421, setId = 414, languagePair = "en-ru", rarity = "EPIC",
            original = "happen upon", transliteration = "[ˈhæpən əˈpɑn]", translation = "случайно наткнуться, обнаружить",
            definition = "To find someone or something by chance, without searching for them.",
            definitionNative = "Наткнуться на кого-то или что-то случайно, не ища их специально.",
            example = "Wandering through the archives, I happen upon a letter signed by the queen herself.",
            exampleNative = "Бродя по архивам, я happen upon письмо, подписанное самой королевой.",
            pos = "phrase", semanticGroup = "phrasal_l5_obscure", fillInBlankExclusions = listOf(41416L, 41417L, 41419L, 41420L, 41422L, 41423L, 41424L, 41425L)),

        WordEntity(id = 41422, setId = 414, languagePair = "en-ru", rarity = "EPIC",
            original = "stumble upon", transliteration = "[ˈstʌmbəl əˈpɑn]", translation = "наткнуться, неожиданно найти",
            definition = "To discover something unexpectedly while doing or looking for something else.",
            definitionNative = "Неожиданно обнаружить что-то, занимаясь или ища совсем другое.",
            example = "The historians stumble upon a chest of forgotten letters in the cellar.",
            exampleNative = "Историки stumble upon сундук с забытыми письмами в подвале.",
            pos = "phrase", semanticGroup = "phrasal_l5_obscure", fillInBlankExclusions = listOf(41413L, 41415L, 41416L, 41417L, 41419L, 41420L, 41421L, 41423L, 41424L, 41425L)),

        WordEntity(id = 41423, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "light upon", transliteration = "[laɪt əˈpɑn]", translation = "набрести (на идею, находку)",
            definition = "To discover or think of something suddenly and as if by chance, in a literary way.",
            definitionNative = "Внезапно, словно случайно, обнаружить что-то или прийти к мысли — в литературном стиле.",
            example = "Poets sometimes light upon the perfect phrase by chance.",
            exampleNative = "Наконец она light upon ту самую фразу, что даёт стихотворению смысл.",
            pos = "phrase", semanticGroup = "phrasal_l5_obscure", fillInBlankExclusions = listOf(41401L, 41406L, 41413L, 41415L, 41419L, 41420L, 41421L, 41422L, 41424L, 41425L)),

        WordEntity(id = 41424, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "prevail upon", transliteration = "[priˈveɪl əˈpɑn]", translation = "уговорить, склонить (формально)",
            definition = "To successfully persuade someone to do something, often after careful argument.",
            definitionNative = "Успешно убедить кого-то сделать что-то — часто после взвешенных доводов.",
            example = "The elders finally prevail upon the young king to sign the truce.",
            exampleNative = "Старейшинам наконец удалось prevail upon юного короля подписать перемирие.",
            pos = "phrase", semanticGroup = "phrasal_l5_obscure", fillInBlankExclusions = listOf(41421L, 41422L, 41423L, 41425L)),

        WordEntity(id = 41425, setId = 414, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dwell upon", transliteration = "[dwɛl əˈpɑn]", translation = "задерживаться мыслью, размышлять о",
            definition = "To think, speak or write about something for a long time, often in painful detail.",
            definitionNative = "Долго думать, говорить или писать о чём-то — часто с болезненной подробностью.",
            example = "There is no use to dwell upon mistakes that cannot now be undone.",
            exampleNative = "Бессмысленно dwell upon ошибки, которые уже не исправить.",
            pos = "phrase", semanticGroup = "phrasal_l5_obscure", fillInBlankExclusions = listOf(41406L, 41413L, 41415L, 41416L, 41417L, 41418L, 41420L, 41421L, 41422L, 41423L, 41424L)),
    )
}
