package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Фразовые глаголы (L4, RARE+EPIC).
 *
 * Set 413: «Фразовые глаголы» — профессиональный уровень.
 *          Phrasal verbs уровня C1: продвинутый бизнес-регистр,
 *          сложные эмоциональные оттенки, тонкие действия в социальном
 *          контексте, преодоление препятствий и более книжные/высокие
 *          по регистру лексемы (touch upon, brood over, pore over).
 *          Продолжение L1 (set 410, A2-B1), L2 (set 411, B1-B2)
 *          и L3 (set 412, B2). На этом уровне у фразовых глаголов
 *          смысл не выводится из частей вообще: pencil in (= вписать
 *          предварительно), churn out (= штамповать массово),
 *          chance upon (= наткнуться случайно), set forth (= изложить).
 *
 * Phrasal verbs остаются отдельным классом от:
 *   • обычных verbs (run, eat, sleep — одно слово)
 *   • idioms (kill two birds with one stone — образное выражение)
 *
 * Распределение редкости: 8 RARE + 17 EPIC.
 * RARE — phrasal verbs C1, которые ещё встречаются в продвинутой
 * деловой и разговорной речи (chip in, pitch in, back down, drop off,
 * pull off, weigh in, square up, simmer down). EPIC — лексемы с узким
 * специализированным смыслом или высоким письменным регистром.
 *
 * ⚠️ Коллизии при подготовке (проверено grep'ом по `original = "..."`):
 *   все 25 phrasal verbs L4 свободны — пересечений с L1 (410), L2 (411),
 *   L3 (412), Batch'ами и прочими тематическими наборами не обнаружено.
 *
 * SemanticGroups (5 × 5):
 *   phrasal_l4_advanced_business   — pencil in, drum up, hash out, churn out, pull off
 *   phrasal_l4_complex_emotions    — well up, choke up, swing back, simmer down, pin away
 *   phrasal_l4_subtle_actions      — chip in, pitch in, weigh in, gloss over, square up
 *   phrasal_l4_obstacles           — back down, bow out, drop off, drift off, pass over
 *   phrasal_l4_high_register       — touch upon, brood over, pore over, chance upon, set forth
 *
 * Word IDs: setId × 100 + position (41301..41325).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions пустые — заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishPhrasalVerbsL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 413,
            languagePair = "en-ru",
            orderIndex = 413,
            name = "Фразовые глаголы",
            description = "Фразовые глаголы для продвинутого бизнеса, тонких эмоций, незаметных действий, преодоления препятствий и высокого регистра",
            topic = "Фразовые глаголы",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 413 — Фразовые глаголы: профессиональный (L4, RARE+EPIC)        ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── phrasal_l4_advanced_business (5) ───────────────────────────────

        WordEntity(id = 41301, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "pencil in", transliteration = "[ˈpɛnsəl ɪn]", translation = "записать предварительно (в график)",
            definition = "To arrange a meeting or event tentatively, knowing it might still change.",
            definitionNative = "Предварительно назначить встречу или событие, понимая, что план ещё может поменяться.",
            example = "Let's pencil in the review for next Thursday and confirm later.",
            exampleNative = "Давай pencil in обзор на следующий четверг, а позже подтвердим.",
            pos = "phrase", semanticGroup = "phrasal_l4_advanced_business", fillInBlankExclusions = listOf(41302L, 41303L, 41304L, 41305L, 41314L, 41320L, 41321L, 41322L, 41323L, 41324L)),

        WordEntity(id = 41302, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "drum up", transliteration = "[drʌm ʌp]", translation = "раздобыть, привлечь (поддержку, бизнес)",
            definition = "To get support, interest or business through active effort.",
            definitionNative = "Активными усилиями добиться поддержки, интереса или клиентов.",
            example = "We need to drum up new clients before the quarter ends.",
            exampleNative = "Нам нужно drum up новых клиентов до конца квартала.",
            pos = "phrase", semanticGroup = "phrasal_l4_advanced_business", fillInBlankExclusions = listOf(41301L, 41303L, 41304L, 41305L, 41320L, 41324L)),

        WordEntity(id = 41303, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "hash out", transliteration = "[hæʃ aʊt]", translation = "обсудить детально (до решения)",
            definition = "To discuss something thoroughly until you reach an agreement on the details.",
            definitionNative = "Подробно обсуждать что-то, пока не договоришься по всем деталям.",
            example = "The team spent three hours trying to hash out the contract terms.",
            exampleNative = "Команда три часа пыталась hash out условия контракта.",
            pos = "phrase", semanticGroup = "phrasal_l4_advanced_business", fillInBlankExclusions = listOf(41301L, 41302L, 41304L, 41305L, 41314L, 41320L, 41321L, 41323L, 41325L)),

        WordEntity(id = 41304, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "churn out", transliteration = "[tʃɜrn aʊt]", translation = "штамповать, выдавать массово",
            definition = "To produce something in large amounts quickly, often without much care.",
            definitionNative = "Быстро производить что-то в большом количестве, часто без особой тщательности.",
            example = "The studio used to churn out three movies a year regardless of quality.",
            exampleNative = "Студия раньше churn out по три фильма в год независимо от качества.",
            pos = "phrase", semanticGroup = "phrasal_l4_advanced_business", fillInBlankExclusions = listOf(41301L, 41302L, 41303L, 41305L, 41323L)),

        WordEntity(id = 41305, setId = 413, languagePair = "en-ru", rarity = "RARE",
            original = "pull off", transliteration = "[pʊl ɔf]", translation = "провернуть, успешно осуществить",
            definition = "To succeed at doing something difficult or unexpected.",
            definitionNative = "Успешно сделать что-то сложное или неожиданное.",
            example = "I can't believe she managed to pull off such a complex deal alone.",
            exampleNative = "Не могу поверить, что ей удалось pull off такую сложную сделку в одиночку.",
            pos = "phrase", semanticGroup = "phrasal_l4_advanced_business", fillInBlankExclusions = listOf(41301L, 41302L, 41303L, 41304L, 41314L, 41320L, 41323L, 41325L)),

        // ── phrasal_l4_complex_emotions (5) ────────────────────────────────

        WordEntity(id = 41306, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "well up", transliteration = "[wɛl ʌp]", translation = "наворачиваться (о слезах), подкатывать",
            definition = "When tears or strong feelings rise inside someone almost involuntarily.",
            definitionNative = "Когда слёзы или сильные чувства поднимаются внутри почти непроизвольно.",
            example = "Tears began to well up in his eyes during the farewell speech.",
            exampleNative = "Слёзы начали well up в его глазах во время прощальной речи.",
            pos = "phrase", semanticGroup = "phrasal_l4_complex_emotions", fillInBlankExclusions = listOf(41307L, 41308L, 41309L, 41310L)),

        WordEntity(id = 41307, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "choke up", transliteration = "[tʃoʊk ʌp]", translation = "застрять в горле (от чувств), захлёбываться",
            definition = "To become unable to speak clearly because of strong emotion.",
            definitionNative = "Стать неспособным говорить внятно из-за сильных чувств.",
            example = "She started to choke up when she thanked her late grandmother.",
            exampleNative = "Она начала choke up, когда благодарила покойную бабушку.",
            pos = "phrase", semanticGroup = "phrasal_l4_complex_emotions", fillInBlankExclusions = listOf(41306L, 41308L, 41309L, 41310L, 41317L, 41319L)),

        WordEntity(id = 41308, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "swing back", transliteration = "[swɪŋ bæk]", translation = "качнуться обратно (о настроении)",
            definition = "When mood, opinion or feeling returns to its previous state after a change.",
            definitionNative = "Когда настроение, мнение или чувство возвращается к прежнему состоянию после перемены.",
            example = "His mood will swing back to normal once the deadline passes.",
            exampleNative = "Его настроение swing back к нормальному, как только дедлайн пройдёт.",
            pos = "phrase", semanticGroup = "phrasal_l4_complex_emotions", fillInBlankExclusions = listOf(41306L, 41307L, 41309L, 41310L)),

        WordEntity(id = 41309, setId = 413, languagePair = "en-ru", rarity = "RARE",
            original = "simmer down", transliteration = "[ˈsɪmər daʊn]", translation = "успокоиться (после кипения)",
            definition = "To gradually become calm again after being angry or excited.",
            definitionNative = "Постепенно успокаиваться после злости или возбуждения.",
            example = "Give him a few minutes to simmer down before you talk to him.",
            exampleNative = "Дай ему пару минут simmer down, прежде чем заводить разговор.",
            pos = "phrase", semanticGroup = "phrasal_l4_complex_emotions", fillInBlankExclusions = listOf(41306L, 41307L, 41308L, 41310L, 41316L)),

        WordEntity(id = 41310, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "pin away", transliteration = "[pɪn əˈweɪ]", translation = "томиться, чахнуть (от тоски)",
            definition = "To suffer slowly because of longing or grief that does not go away.",
            definitionNative = "Медленно страдать от тоски или горя, которые не проходят.",
            example = "Don't pin away for a love that will never return.",
            exampleNative = "Он годами pin away по любви, которая уже не вернётся.",
            pos = "phrase", semanticGroup = "phrasal_l4_complex_emotions", fillInBlankExclusions = listOf(41306L, 41307L, 41308L, 41309L)),

        // ── phrasal_l4_subtle_actions (5) ──────────────────────────────────

        WordEntity(id = 41311, setId = 413, languagePair = "en-ru", rarity = "RARE",
            original = "chip in", transliteration = "[tʃɪp ɪn]", translation = "скинуться, внести лепту",
            definition = "To contribute money or effort along with others to a shared cause.",
            definitionNative = "Внести деньги или усилия вместе с другими в общее дело.",
            example = "Let's all chip in to buy the boss a gift.",
            exampleNative = "Все в офисе chip in, чтобы купить начальнику подарок на выход на пенсию.",
            pos = "phrase", semanticGroup = "phrasal_l4_subtle_actions", fillInBlankExclusions = listOf(41312L, 41313L, 41314L, 41315L)),

        WordEntity(id = 41312, setId = 413, languagePair = "en-ru", rarity = "RARE",
            original = "pitch in", transliteration = "[pɪtʃ ɪn]", translation = "включиться (в общую работу)",
            definition = "To start helping with a task that other people are already doing.",
            definitionNative = "Начать помогать в задаче, которой уже занимаются другие.",
            example = "If everyone helps pitch in, we can finish by lunch.",
            exampleNative = "Если все pitch in, мы закончим этот отчёт к обеду.",
            pos = "phrase", semanticGroup = "phrasal_l4_subtle_actions", fillInBlankExclusions = listOf(41311L, 41313L, 41314L, 41315L)),

        WordEntity(id = 41313, setId = 413, languagePair = "en-ru", rarity = "RARE",
            original = "weigh in", transliteration = "[weɪ ɪn]", translation = "высказаться (в дискуссии), вмешаться",
            definition = "To join a discussion by giving your opinion, especially with authority.",
            definitionNative = "Присоединиться к обсуждению, высказав своё мнение — особенно весомо.",
            example = "The CEO should weigh in on this design debate soon.",
            exampleNative = "Гендиректор наконец weigh in в споре о дизайне сегодня утром.",
            pos = "phrase", semanticGroup = "phrasal_l4_subtle_actions", fillInBlankExclusions = listOf(41311L, 41312L, 41314L, 41315L, 41316L)),

        WordEntity(id = 41314, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "gloss over", transliteration = "[ɡlɔs ˈoʊvər]", translation = "замять, обойти (неудобную тему)",
            definition = "To avoid talking about something unpleasant by mentioning it only briefly.",
            definitionNative = "Избежать обсуждения неприятной темы, упомянув её лишь мельком.",
            example = "The report tried to gloss over the major losses of the past year.",
            exampleNative = "Отчёт попытался gloss over крупные убытки прошлого года.",
            pos = "phrase", semanticGroup = "phrasal_l4_subtle_actions", fillInBlankExclusions = listOf(41303L, 41311L, 41312L, 41313L, 41315L, 41320L, 41321L, 41322L, 41323L, 41325L)),

        WordEntity(id = 41315, setId = 413, languagePair = "en-ru", rarity = "RARE",
            original = "square up", transliteration = "[skwɛr ʌp]", translation = "рассчитаться, уладить счёты",
            definition = "To settle a debt or finish something that needs to be put right.",
            definitionNative = "Расплатиться по долгу или закрыть то, что нужно поставить на место.",
            example = "I'll square up with you for dinner once I get to the bank.",
            exampleNative = "Я square up с тобой за ужин, как только доберусь до банка.",
            pos = "phrase", semanticGroup = "phrasal_l4_subtle_actions", fillInBlankExclusions = listOf(41311L, 41312L, 41313L, 41314L)),

        // ── phrasal_l4_obstacles (5) ───────────────────────────────────────

        WordEntity(id = 41316, setId = 413, languagePair = "en-ru", rarity = "RARE",
            original = "back down", transliteration = "[bæk daʊn]", translation = "отступить (от позиции, спора)",
            definition = "To stop demanding or insisting on something during an argument or conflict.",
            definitionNative = "Перестать настаивать на чём-то в споре или конфликте.",
            example = "He refused to back down even when the evidence was against him.",
            exampleNative = "Он отказался back down, даже когда улики были против него.",
            pos = "phrase", semanticGroup = "phrasal_l4_obstacles", fillInBlankExclusions = listOf(41309L, 41311L, 41312L, 41313L, 41315L, 41317L, 41318L, 41319L, 41320L)),

        WordEntity(id = 41317, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "bow out", transliteration = "[baʊ aʊt]", translation = "уйти достойно, откланяться",
            definition = "To stop taking part in something, often gracefully or with dignity.",
            definitionNative = "Прекратить участие в чём-то — часто красиво и с достоинством.",
            example = "After thirty years on stage, the actress decided to bow out.",
            exampleNative = "После тридцати лет на сцене актриса решила bow out.",
            pos = "phrase", semanticGroup = "phrasal_l4_obstacles", fillInBlankExclusions = listOf(41316L, 41318L, 41319L, 41320L)),

        WordEntity(id = 41318, setId = 413, languagePair = "en-ru", rarity = "RARE",
            original = "drop off", transliteration = "[drɑp ɔf]", translation = "снижаться, ослабевать",
            definition = "To become less in number, level or intensity over a period of time.",
            definitionNative = "Уменьшаться по количеству, уровню или силе со временем.",
            example = "Sales tend to drop off sharply after the holiday season ends.",
            exampleNative = "Продажи обычно резко drop off после окончания праздничного сезона.",
            pos = "phrase", semanticGroup = "phrasal_l4_obstacles", fillInBlankExclusions = listOf(41308L, 41309L, 41316L, 41317L, 41319L, 41320L)),

        WordEntity(id = 41319, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "drift off", transliteration = "[drɪft ɔf]", translation = "задремать, погрузиться в сон",
            definition = "To gradually fall asleep, especially without intending to.",
            definitionNative = "Постепенно засыпать — обычно непроизвольно.",
            example = "I often drift off during long, boring lectures.",
            exampleNative = "Я старался слушать лекцию, но через десять минут drift off.",
            pos = "phrase", semanticGroup = "phrasal_l4_obstacles", fillInBlankExclusions = listOf(41316L, 41317L, 41318L, 41320L)),

        WordEntity(id = 41320, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "pass over", transliteration = "[pæs ˈoʊvər]", translation = "обойти (при повышении), пропустить",
            definition = "To ignore someone for a promotion or chance and choose another person instead.",
            definitionNative = "Не учесть кого-то при повышении или возможности и выбрать другого.",
            example = "Managers shouldn't pass over loyal staff for promotion.",
            exampleNative = "Ей было обидно, когда руководство снова pass over её на ведущую роль.",
            pos = "phrase", semanticGroup = "phrasal_l4_obstacles", fillInBlankExclusions = listOf(41301L, 41316L, 41317L, 41318L, 41319L)),

        // ── phrasal_l4_high_register (5) ───────────────────────────────────

        WordEntity(id = 41321, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "touch upon", transliteration = "[tʌtʃ əˈpɑn]", translation = "затронуть (тему вскользь)",
            definition = "To briefly mention or refer to a subject in writing or in speech.",
            definitionNative = "Коротко упомянуть или сослаться на тему в письме или речи.",
            example = "The author only seems to touch upon the political background.",
            exampleNative = "Автор лишь touch upon политический фон эпохи.",
            pos = "phrase", semanticGroup = "phrasal_l4_high_register", fillInBlankExclusions = listOf(41303L, 41314L, 41320L, 41322L, 41323L, 41324L, 41325L)),

        WordEntity(id = 41322, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "brood over", transliteration = "[brud ˈoʊvər]", translation = "изводиться, размышлять мрачно",
            definition = "To think anxiously or unhappily about something for a long time.",
            definitionNative = "Долго и тревожно или мрачно думать о чём-то.",
            example = "Don't brood over a single mistake for so long.",
            exampleNative = "Хватит brood over одну ошибку — двигайся дальше с работой.",
            pos = "phrase", semanticGroup = "phrasal_l4_high_register", fillInBlankExclusions = listOf(41303L, 41314L, 41320L, 41321L, 41323L, 41324L, 41325L)),

        WordEntity(id = 41323, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "pore over", transliteration = "[pɔr ˈoʊvər]", translation = "штудировать, корпеть над",
            definition = "To study a text or document with great care and attention.",
            definitionNative = "Изучать текст или документ с большим вниманием и тщательностью.",
            example = "Lawyers must pore over every line of a contract.",
            exampleNative = "Она весь вечер pore over старые контракты.",
            pos = "phrase", semanticGroup = "phrasal_l4_high_register", fillInBlankExclusions = listOf(41303L, 41314L, 41320L, 41321L, 41322L, 41324L, 41325L)),

        WordEntity(id = 41324, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "chance upon", transliteration = "[tʃæns əˈpɑn]", translation = "наткнуться (случайно)",
            definition = "To find or meet someone or something completely by chance.",
            definitionNative = "Найти или встретить кого-то или что-то совершенно случайно.",
            example = "You might chance upon an old letter in the attic.",
            exampleNative = "Я chance upon старое письмо от отца на чердаке.",
            pos = "phrase", semanticGroup = "phrasal_l4_high_register", fillInBlankExclusions = listOf(41314L, 41320L, 41321L, 41322L, 41323L, 41325L)),

        WordEntity(id = 41325, setId = 413, languagePair = "en-ru", rarity = "EPIC",
            original = "set forth", transliteration = "[sɛt fɔrθ]", translation = "изложить (формально), представить",
            definition = "To present, explain or describe ideas formally, especially in writing.",
            definitionNative = "Формально представить, объяснить или описать идеи — обычно письменно.",
            example = "The treaty set forth the rules for trade between the two nations.",
            exampleNative = "Договор set forth правила торговли между двумя странами.",
            pos = "phrase", semanticGroup = "phrasal_l4_high_register", fillInBlankExclusions = listOf(41303L, 41304L, 41314L, 41320L, 41321L, 41322L, 41323L, 41324L)),
    )
}
