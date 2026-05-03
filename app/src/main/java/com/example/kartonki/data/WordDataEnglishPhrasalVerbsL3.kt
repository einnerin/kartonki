package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Фразовые глаголы (L3, UNCOMMON+RARE).
 *
 * Set 412: «Phrasal Verbs» — углублённый уровень.
 *          Phrasal verbs уровня B2: бизнес-лексика, сложные действия,
 *          социальная динамика, принятие решений и описание исходов.
 *          Продолжение L1 (set 410, A2-B1) и L2 (set 411, B1-B2).
 *          На этом уровне у фразовых лексем смысл почти всегда
 *          идиоматичен и не выводится из значения частей: bring about
 *          (= вызвать перемену), pan out (= обернуться, сложиться),
 *          stick up for (= вступиться за).
 *
 * Phrasal verbs остаются отдельным классом от:
 *   • обычных verbs (run, eat, sleep — одно слово)
 *   • idioms (kill two birds with one stone — образное выражение)
 *
 * Распределение редкости: 7 UNCOMMON + 18 RARE.
 * UNCOMMON — фразовые глаголы, которые встречаются в речи B1-B2
 * почти ежедневно (work out, get over, go ahead, turn out, stick with,
 * go through, carry out). RARE — менее частотные или с более узким
 * деловым/абстрактным смыслом.
 *
 * ⚠️ Коллизии при подготовке (проверено grep'ом по `original = "..."`):
 *   все 25 phrasal verbs L3 свободны — пересечений с L1 (set 410),
 *   с Batch и с прочими тематическими наборами не обнаружено.
 *
 * SemanticGroups (5 × 5):
 *   phrasal_l3_business         — bring about, carry out, follow up, factor in, weigh up
 *   phrasal_l3_complex_actions  — bring up, work out, go through, brush off, knock out
 *   phrasal_l3_social_dynamics  — fall apart, get over, lash out, walk out on, stick up for
 *   phrasal_l3_decisions        — back out, settle for, talk into, go ahead, stick with
 *   phrasal_l3_outcomes         — turn out, come about, pan out, fall through, come around
 *
 * Word IDs: setId × 100 + position (41201..41225).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions пустые — заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishPhrasalVerbsL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 412,
            languagePair = "en-ru",
            orderIndex = 412,
            name = "Phrasal Verbs",
            description = "Фразовые глаголы для бизнеса, сложных действий, социальных конфликтов, решений и исходов",
            topic = "Phrasal Verbs",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 412 — Phrasal Verbs: углублённый (L3, UNCOMMON+RARE)         ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── phrasal_l3_business (5) ────────────────────────────────────────

        WordEntity(id = 41201, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "bring about", transliteration = "[brɪŋ əˈbaʊt]", translation = "вызвать (перемены), повлечь",
            definition = "To make something happen, especially a change or a result.",
            definitionNative = "Сделать так, чтобы что-то произошло — обычно перемена или результат.",
            example = "The new manager hopes to bring about real change in the company.",
            exampleNative = "Новый руководитель надеется bring about реальные перемены в компании.",
            pos = "phrase", semanticGroup = "phrasal_l3_business", fillInBlankExclusions = listOf(41202L, 41203L, 41204L, 41205L)),

        WordEntity(id = 41202, setId = 412, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "carry out", transliteration = "[ˈkæri aʊt]", translation = "выполнять, проводить",
            definition = "To do or complete a task, plan or order that has been given.",
            definitionNative = "Выполнить или завершить поставленную задачу, план или поручение.",
            example = "The team will carry out the safety check tomorrow morning.",
            exampleNative = "Команда будет carry out проверку безопасности завтра утром.",
            pos = "phrase", semanticGroup = "phrasal_l3_business", fillInBlankExclusions = listOf(41201L, 41203L, 41204L, 41205L, 41208L)),

        WordEntity(id = 41203, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "follow up", transliteration = "[ˈfɑloʊ ʌp]", translation = "довести до конца, проконтролировать",
            definition = "To take further action after an earlier step in order to keep things moving.",
            definitionNative = "Предпринять дополнительные действия после более раннего шага, чтобы довести дело.",
            example = "I'll follow up with the client by email later this week.",
            exampleNative = "Я follow up с клиентом по почте позже на этой неделе.",
            pos = "phrase", semanticGroup = "phrasal_l3_business", fillInBlankExclusions = listOf(41201L, 41202L, 41204L, 41205L, 41219L, 41220L)),

        WordEntity(id = 41204, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "factor in", transliteration = "[ˈfæktər ɪn]", translation = "учитывать (при расчёте)",
            definition = "To include a particular thing when making a decision or calculation.",
            definitionNative = "Включить какой-то фактор в решение или расчёт.",
            example = "Don't forget to factor in the cost of shipping when comparing prices.",
            exampleNative = "Не забудь factor in стоимость доставки при сравнении цен.",
            pos = "phrase", semanticGroup = "phrasal_l3_business", fillInBlankExclusions = listOf(41201L, 41202L, 41203L, 41205L, 41206L, 41207L)),

        WordEntity(id = 41205, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "weigh up", transliteration = "[weɪ ʌp]", translation = "взвешивать (за и против)",
            definition = "To carefully consider the good and bad points of something before deciding.",
            definitionNative = "Тщательно обдумать плюсы и минусы чего-то перед принятием решения.",
            example = "We need to weigh up the risks before signing the contract.",
            exampleNative = "Нам нужно weigh up риски до подписания контракта.",
            pos = "phrase", semanticGroup = "phrasal_l3_business", fillInBlankExclusions = listOf(41201L, 41202L, 41203L, 41204L, 41206L, 41207L, 41208L)),

        // ── phrasal_l3_complex_actions (5) ─────────────────────────────────

        WordEntity(id = 41206, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "bring up", transliteration = "[brɪŋ ʌp]", translation = "поднять (тему), упомянуть",
            definition = "To start talking about a subject in a discussion.",
            definitionNative = "Начать говорить о какой-то теме в разговоре.",
            example = "Please don't bring up the salary issue during the dinner.",
            exampleNative = "Пожалуйста, не bring up вопрос зарплаты за ужином.",
            pos = "phrase", semanticGroup = "phrasal_l3_complex_actions", fillInBlankExclusions = listOf(41204L, 41207L, 41208L, 41209L, 41210L)),

        WordEntity(id = 41207, setId = 412, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "work out", transliteration = "[wɜrk aʊt]", translation = "разобраться, найти решение",
            definition = "To find a solution to a problem by thinking about it carefully.",
            definitionNative = "Найти решение проблемы, тщательно её обдумав.",
            example = "I can't work out why the printer keeps jamming.",
            exampleNative = "Я не могу work out, почему принтер постоянно заедает.",
            pos = "phrase", semanticGroup = "phrasal_l3_complex_actions", fillInBlankExclusions = listOf(41206L, 41208L, 41209L, 41210L)),

        WordEntity(id = 41208, setId = 412, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "go through", transliteration = "[ɡoʊ θru]", translation = "пройти через, перенести",
            definition = "To experience a difficult or unpleasant situation.",
            definitionNative = "Пройти через трудную или неприятную ситуацию.",
            example = "She had to go through a long recovery after the surgery.",
            exampleNative = "Ей пришлось go through долгое восстановление после операции.",
            pos = "phrase", semanticGroup = "phrasal_l3_complex_actions", fillInBlankExclusions = listOf(41206L, 41207L, 41209L, 41210L)),

        WordEntity(id = 41209, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "brush off", transliteration = "[brʌʃ ɔf]", translation = "отмахнуться (от критики, проблемы)",
            definition = "To refuse to listen to someone or to ignore criticism easily.",
            definitionNative = "Отказаться слушать кого-то или с лёгкостью проигнорировать критику.",
            example = "He tried to brush off the bad reviews as jealousy from rivals.",
            exampleNative = "Он попытался brush off плохие отзывы, объяснив их завистью соперников.",
            pos = "phrase", semanticGroup = "phrasal_l3_complex_actions", fillInBlankExclusions = listOf(41206L, 41207L, 41208L, 41210L)),

        WordEntity(id = 41210, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "knock out", transliteration = "[nɑk aʊt]", translation = "вырубить, нокаутировать",
            definition = "To hit someone so hard that they lose consciousness.",
            definitionNative = "Ударить кого-то так сильно, что он теряет сознание.",
            example = "The boxer managed to knock out his opponent in the second round.",
            exampleNative = "Боксёру удалось knock out соперника во втором раунде.",
            pos = "phrase", semanticGroup = "phrasal_l3_complex_actions", fillInBlankExclusions = listOf(41206L, 41207L, 41208L, 41209L)),

        // ── phrasal_l3_social_dynamics (5) ─────────────────────────────────

        WordEntity(id = 41211, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "fall apart", transliteration = "[fɔl əˈpɑrt]", translation = "разваливаться (об отношениях, плане)",
            definition = "To break into pieces or to stop working as a whole.",
            definitionNative = "Распасться на части или перестать работать как единое целое.",
            example = "Their marriage started to fall apart after the move.",
            exampleNative = "Их брак начал fall apart после переезда.",
            pos = "phrase", semanticGroup = "phrasal_l3_social_dynamics", fillInBlankExclusions = listOf(41212L, 41213L, 41214L, 41215L)),

        WordEntity(id = 41212, setId = 412, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "get over", transliteration = "[ɡɛt ˈoʊvər]", translation = "пережить, оправиться",
            definition = "To stop feeling upset or unwell after a problem or illness.",
            definitionNative = "Перестать переживать или болеть после проблемы или болезни.",
            example = "It took her months to get over the breakup.",
            exampleNative = "Ей понадобились месяцы, чтобы get over расставание.",
            pos = "phrase", semanticGroup = "phrasal_l3_social_dynamics", fillInBlankExclusions = listOf(41208L, 41211L, 41213L, 41214L, 41215L)),

        WordEntity(id = 41213, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "lash out", transliteration = "[læʃ aʊt]", translation = "наброситься (словами или физически)",
            definition = "To suddenly attack someone with angry words or hits.",
            definitionNative = "Внезапно напасть на кого-то — словесно или физически.",
            example = "Tired and stressed, he lash out at his colleagues over a small mistake.",
            exampleNative = "Усталый и в стрессе, он lash out на коллег из-за мелкой ошибки.",
            pos = "phrase", semanticGroup = "phrasal_l3_social_dynamics", fillInBlankExclusions = listOf(41211L, 41212L, 41214L, 41215L)),

        WordEntity(id = 41214, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "walk out on", transliteration = "[wɔk aʊt ɑn]", translation = "бросить (партнёра, семью)",
            definition = "To suddenly leave a partner, family or commitment, refusing to come back.",
            definitionNative = "Внезапно бросить партнёра, семью или обязательство и не возвращаться.",
            example = "He walk out on his family without saying a single word.",
            exampleNative = "Он walk out on свою семью, не сказав ни слова.",
            pos = "phrase", semanticGroup = "phrasal_l3_social_dynamics", fillInBlankExclusions = listOf(41211L, 41212L, 41213L, 41215L)),

        WordEntity(id = 41215, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "stick up for", transliteration = "[stɪk ʌp fɔr]", translation = "вступиться за, защитить",
            definition = "To defend someone who is being criticized or attacked unfairly.",
            definitionNative = "Защитить того, кого несправедливо критикуют или нападают.",
            example = "You always stick up for me when others doubt my work.",
            exampleNative = "Спасибо, что решил stick up for меня на встрече.",
            pos = "phrase", semanticGroup = "phrasal_l3_social_dynamics", fillInBlankExclusions = listOf(41211L, 41212L, 41213L, 41214L, 41220L)),

        // ── phrasal_l3_decisions (5) ───────────────────────────────────────

        WordEntity(id = 41216, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "back out", transliteration = "[bæk aʊt]", translation = "пойти на попятную, отказаться",
            definition = "To decide not to do something that you had agreed to do.",
            definitionNative = "Решить не делать того, на что раньше согласился.",
            example = "He back out of the deal at the very last moment.",
            exampleNative = "Он back out из сделки в самый последний момент.",
            pos = "phrase", semanticGroup = "phrasal_l3_decisions", fillInBlankExclusions = listOf(41217L, 41218L, 41219L, 41220L)),

        WordEntity(id = 41217, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "settle for", transliteration = "[ˈsɛtl fɔr]", translation = "удовольствоваться, согласиться (на меньшее)",
            definition = "To accept something that is not exactly what you wanted but is enough.",
            definitionNative = "Принять то, что не совсем хотел, но чего достаточно.",
            example = "I wanted a corner office, but I had to settle for a small desk by the window.",
            exampleNative = "Я хотел угловой кабинет, но пришлось settle for столиком у окна.",
            pos = "phrase", semanticGroup = "phrasal_l3_decisions", fillInBlankExclusions = listOf(41216L, 41218L, 41219L, 41220L)),

        WordEntity(id = 41218, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "talk into", transliteration = "[tɔk ˈɪntu]", translation = "уговорить, убедить",
            definition = "To persuade someone to do something they were unsure about.",
            definitionNative = "Убедить кого-то сделать то, в чём он сомневался.",
            example = "She talk into me joining the gym with her.",
            exampleNative = "Она talk into меня, чтобы я записался в зал вместе с ней.",
            pos = "phrase", semanticGroup = "phrasal_l3_decisions", fillInBlankExclusions = listOf(41216L, 41217L, 41219L, 41220L)),

        WordEntity(id = 41219, setId = 412, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "go ahead", transliteration = "[ɡoʊ əˈhɛd]", translation = "приступить, действовать",
            definition = "To start doing something or to get permission to begin.",
            definitionNative = "Начать что-то делать или получить разрешение приступить.",
            example = "The boss said we can go ahead with the new project.",
            exampleNative = "Начальник сказал, что мы можем go ahead с новым проектом.",
            pos = "phrase", semanticGroup = "phrasal_l3_decisions", fillInBlankExclusions = listOf(41203L, 41216L, 41217L, 41218L, 41220L)),

        WordEntity(id = 41220, setId = 412, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "stick with", transliteration = "[stɪk wɪð]", translation = "придерживаться (выбора, плана)",
            definition = "To continue with a choice, plan or method instead of changing it.",
            definitionNative = "Продолжать следовать выбору, плану или методу, не меняя их.",
            example = "Let's stick with the original plan — it has worked before.",
            exampleNative = "Давайте stick with первоначальный план — он уже срабатывал.",
            pos = "phrase", semanticGroup = "phrasal_l3_decisions", fillInBlankExclusions = listOf(41202L, 41203L, 41207L, 41216L, 41217L, 41218L, 41219L)),

        // ── phrasal_l3_outcomes (5) ────────────────────────────────────────

        WordEntity(id = 41221, setId = 412, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "turn out", transliteration = "[tɜrn aʊt]", translation = "оказаться, обернуться",
            definition = "To happen in a particular way or have a particular result in the end.",
            definitionNative = "Произойти определённым образом или дать определённый результат в итоге.",
            example = "The party turn out to be much more fun than we expected.",
            exampleNative = "Вечеринка turn out гораздо веселее, чем мы ожидали.",
            pos = "phrase", semanticGroup = "phrasal_l3_outcomes", fillInBlankExclusions = listOf(41222L, 41223L, 41224L, 41225L)),

        WordEntity(id = 41222, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "come about", transliteration = "[kʌm əˈbaʊt]", translation = "случиться, произойти",
            definition = "To happen, often by chance or for a reason that is not clear.",
            definitionNative = "Произойти — часто случайно или по неочевидной причине.",
            example = "How did this confusion come about in the first place?",
            exampleNative = "Как вообще come about эта путаница?",
            pos = "phrase", semanticGroup = "phrasal_l3_outcomes", fillInBlankExclusions = listOf(41221L, 41223L, 41224L, 41225L)),

        WordEntity(id = 41223, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "pan out", transliteration = "[pæn aʊt]", translation = "сложиться, выйти (об исходе)",
            definition = "To develop in a successful or expected way over time.",
            definitionNative = "Развиться со временем удачно или так, как ожидалось.",
            example = "Let's see how the negotiations pan out before celebrating.",
            exampleNative = "Посмотрим, как pan out переговоры, прежде чем праздновать.",
            pos = "phrase", semanticGroup = "phrasal_l3_outcomes", fillInBlankExclusions = listOf(41207L, 41221L, 41222L, 41224L, 41225L)),

        WordEntity(id = 41224, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "fall through", transliteration = "[fɔl θru]", translation = "сорваться, провалиться (о плане)",
            definition = "To fail to happen or to be completed as planned.",
            definitionNative = "Не состояться или не завершиться так, как было задумано.",
            example = "Our holiday plans fall through after the airline cancelled the flight.",
            exampleNative = "Наши планы на отпуск fall through после того, как авиакомпания отменила рейс.",
            pos = "phrase", semanticGroup = "phrasal_l3_outcomes", fillInBlankExclusions = listOf(41221L, 41222L, 41223L, 41225L)),

        WordEntity(id = 41225, setId = 412, languagePair = "en-ru", rarity = "RARE",
            original = "come around", transliteration = "[kʌm əˈraʊnd]", translation = "согласиться (передумав), смириться",
            definition = "To change your opinion and start agreeing with someone after thinking about it.",
            definitionNative = "Изменить мнение и начать соглашаться с кем-то, обдумав вопрос.",
            example = "She didn't like the idea at first, but she'll come around eventually.",
            exampleNative = "Сначала ей идея не нравилась, но в итоге она come around.",
            pos = "phrase", semanticGroup = "phrasal_l3_outcomes", fillInBlankExclusions = listOf(41221L, 41222L, 41223L, 41224L)),
    )
}
