package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Эмоции и чувства (level 1, основы / A1-A2).
 *
 * Set 360: «Эмоции и чувства» — базовые эмоции, простые состояния и физические
 * проявления для повседневных разговоров (COMMON / UNCOMMON, 13 + 12).
 *
 * Тема «Эмоции и чувства» — отдельная от «Психологии» (бытовая лексика
 * чувств, не научные термины). Чтобы сохранить уникальность относительно
 * существующих psychology-сетов (28, 35, 36, 45, 64, 71, 81), слова из
 * set 28 («Психология: Чувства и эмоции») заменены на бытовые синонимы:
 *   - excited → cheerful         - bored → fine
 *   - proud → pleased            - surprised → amazed
 *   - angry → mad                - nervous → shocked
 *   - scared → afraid            - worried → annoyed
 *
 * Также избегаем пересечений с set 361 (Эмоции и чувства L2):
 * eager, shy, upset уже взяты там — поэтому в L1 заменены на
 * cheerful, fine, annoyed соответственно.
 *
 * Cross-topic дубли допустимы по политике проекта (см. word-sets.md):
 *   - happy/joy/sad/tired/calm/smile/laugh/cry/feel/mood/heart встречаются
 *     в Psychology L1 (set 334), но это другая тема — не запрет.
 *   - tired также в set 12 (Медицина), heart в HealthFitnessL1L2L3 — разные темы.
 *   - afraid в set 266 (Повседневная жизнь) — разные темы.
 *   - fine как существительное «штраф» в set 220 (Право) — другая часть речи и тема.
 *
 * Распределение редкости: 13 COMMON + 12 UNCOMMON — два смежных уровня (A1+A2).
 *
 * SemanticGroups (5 × 5):
 *   emotions_basic_positive  — happy, joy, glad, cheerful, pleased
 *   emotions_basic_negative  — sad, mad, afraid, annoyed, tired
 *   emotions_basic_states    — calm, fine, amazed, confused, shocked
 *   emotions_basic_actions   — smile, laugh, cry, frown, sigh
 *   emotions_basic_express   — feel, mood, heart, tear, hug
 *
 * Все слова имеют isFillInBlankSafe = false по запросу — точечные
 * exclusions подберёт LLM-pipeline после фиксации сета.
 *
 * Word IDs: 36001..36025 (setId × 100 + position).
 */
object WordDataEnglishEmotionsL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 360, name = "Эмоции и чувства",
            description = "Базовые эмоции: радость, грусть, гнев, страх, простые состояния",
            languagePair = "en-ru",
            orderIndex = 360,
            topic = "Эмоции и чувства", level = 1),
    )

    val words: List<WordEntity> = listOf(

        // ── emotions_basic_positive (5) ───────────────────────────────────

        WordEntity(id = 36001, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "happy", transliteration = "[ˈhæpi]", translation = "счастливый",
            definition = "Feeling good inside — like when you eat your favourite cake.",
            definitionNative = "Когда внутри тепло и хорошо — как от любимого пирожного.",
            example = "She was happy to see her best friend at the door.",
            exampleNative = "Она была happy, когда увидела лучшую подругу на пороге.",
            pos = "adjective", semanticGroup = "emotions_basic_positive",
            isFillInBlankSafe = false),

        WordEntity(id = 36002, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "joy", transliteration = "[ʤɔɪ]", translation = "радость",
            definition = "A bright happy feeling — like jumping up when you win a game.",
            definitionNative = "Светлое весёлое чувство — когда хочется прыгать от победы.",
            example = "The children shouted with joy when they saw the puppy.",
            exampleNative = "Дети закричали от joy, увидев маленького щенка.",
            pos = "noun", semanticGroup = "emotions_basic_positive",
            isFillInBlankSafe = false),

        WordEntity(id = 36003, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "glad", transliteration = "[glæd]", translation = "рад",
            definition = "Pleased that something good has happened — usually for a moment.",
            definitionNative = "Доволен тем, что случилось хорошее — обычно мимолётно.",
            example = "I'm so glad you came to my birthday party tonight.",
            exampleNative = "Я так glad, что ты пришёл ко мне на день рождения.",
            pos = "adjective", semanticGroup = "emotions_basic_positive",
            isFillInBlankSafe = false),

        WordEntity(id = 36004, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cheerful", transliteration = "[ˈʧɪrfəl]", translation = "весёлый",
            definition = "Bright and full of fun — humming a tune, smiling at strangers.",
            definitionNative = "Светлый и полный веселья — напевает мелодию, улыбается прохожим.",
            example = "The cheerful waiter made everyone smile during dinner.",
            exampleNative = "cheerful официант смешил каждого гостя за ужином.",
            pos = "adjective", semanticGroup = "emotions_basic_positive",
            isFillInBlankSafe = false),

        WordEntity(id = 36005, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "pleased", transliteration = "[plizd]", translation = "довольный",
            definition = "Quietly happy because something turned out well — like a good grade.",
            definitionNative = "Тихо счастлив тем, что всё хорошо сложилось — например, отличная оценка.",
            example = "The teacher was pleased with the way she answered the question.",
            exampleNative = "Учительница была pleased тем, как девочка ответила на вопрос.",
            pos = "adjective", semanticGroup = "emotions_basic_positive",
            isFillInBlankSafe = false),

        // ── emotions_basic_negative (5) ───────────────────────────────────

        WordEntity(id = 36006, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "sad", transliteration = "[sæd]", translation = "грустный",
            definition = "Feeling bad inside — like when a friend has to leave for a long time.",
            definitionNative = "Когда внутри плохо — как при долгом расставании с другом.",
            example = "He looked sad after he heard the bad news.",
            exampleNative = "Он выглядел sad, когда услышал плохие новости.",
            pos = "adjective", semanticGroup = "emotions_basic_negative",
            isFillInBlankSafe = false),

        WordEntity(id = 36007, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mad", transliteration = "[mæd]", translation = "сердитый",
            definition = "Strongly upset at someone — like when a friend breaks a promise.",
            definitionNative = "Сильно недоволен кем-то — как когда друг нарушает обещание.",
            example = "Dad was mad at me for losing the house keys again.",
            exampleNative = "Папа был mad на меня за то, что я снова потерял ключи.",
            pos = "adjective", semanticGroup = "emotions_basic_negative",
            isFillInBlankSafe = false),

        WordEntity(id = 36008, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "afraid", transliteration = "[əˈfreɪd]", translation = "испуганный",
            definition = "Filled with fear — like a child who hears a loud noise at night.",
            definitionNative = "Полон страха — как ребёнок, который слышит громкий звук ночью.",
            example = "The little boy was afraid of the dog next door.",
            exampleNative = "Малыш был afraid соседского пса за забором.",
            pos = "adjective", semanticGroup = "emotions_basic_negative",
            isFillInBlankSafe = false),

        WordEntity(id = 36009, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "annoyed", transliteration = "[əˈnɔɪd]", translation = "раздражённый",
            definition = "Bothered by something small but persistent — a buzzing fly or a noisy neighbour.",
            definitionNative = "Задет чем-то мелким, но настойчивым — мухой или шумным соседом.",
            example = "She got annoyed when the kids kept knocking on her door.",
            exampleNative = "Она была annoyed, когда дети снова и снова стучались в дверь.",
            pos = "adjective", semanticGroup = "emotions_basic_negative",
            isFillInBlankSafe = false),

        WordEntity(id = 36010, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "tired", transliteration = "[taɪərd]", translation = "усталый",
            definition = "Wanting to rest — your body and head feel heavy after a long day.",
            definitionNative = "Хочется отдохнуть — тело и голова тяжёлые после долгого дня.",
            example = "She was too tired to cook and ordered pizza instead.",
            exampleNative = "Она была слишком tired, чтобы готовить, и заказала пиццу.",
            pos = "adjective", semanticGroup = "emotions_basic_negative",
            isFillInBlankSafe = false),

        // ── emotions_basic_states (5) ─────────────────────────────────────

        WordEntity(id = 36011, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "calm", transliteration = "[kɑm]", translation = "спокойный",
            definition = "Not worried or upset — breathing slowly, speaking softly.",
            definitionNative = "Без тревоги — дышит ровно, говорит мягко, не суетится.",
            example = "Try to stay calm and tell me what really happened.",
            exampleNative = "Постарайся быть calm и расскажи, что на самом деле случилось.",
            pos = "adjective", semanticGroup = "emotions_basic_states",
            isFillInBlankSafe = false),

        WordEntity(id = 36012, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "fine", transliteration = "[faɪn]", translation = "в порядке",
            definition = "Doing alright inside — no big trouble, no big joy, just steady.",
            definitionNative = "Внутри нормально — ни большой беды, ни сильной радости, просто ровно.",
            example = "Don't worry about me — I'm fine after a good night's sleep.",
            exampleNative = "Не волнуйся обо мне — я fine после хорошего ночного сна.",
            pos = "adjective", semanticGroup = "emotions_basic_states",
            isFillInBlankSafe = false),

        WordEntity(id = 36013, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "amazed", transliteration = "[əˈmeɪzd]", translation = "поражённый",
            definition = "Filled with wonder by something hard to believe — a magic trick or huge view.",
            definitionNative = "Полон удивления чем-то невероятным — фокусом или огромным видом.",
            example = "We were amazed by the fireworks above the harbour last night.",
            exampleNative = "Мы были amazed салютом над гаванью прошлой ночью.",
            pos = "adjective", semanticGroup = "emotions_basic_states",
            isFillInBlankSafe = false),

        WordEntity(id = 36014, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "confused", transliteration = "[kənˈfjuzd]", translation = "растерянный",
            definition = "Not sure what is going on — like reading a map upside down.",
            definitionNative = "Не понимает, что происходит — как при чтении карты вверх ногами.",
            example = "He looked confused when the teacher changed the rules halfway.",
            exampleNative = "Он выглядел confused, когда учитель сменил правила посреди игры.",
            pos = "adjective", semanticGroup = "emotions_basic_states",
            isFillInBlankSafe = false),

        WordEntity(id = 36015, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "shocked", transliteration = "[ʃɑkt]", translation = "потрясённый",
            definition = "Hit hard inside by very bad or strange news — speechless for a moment.",
            definitionNative = "Ошарашен очень плохим или странным известием — молчит несколько секунд.",
            example = "She was shocked to hear that her old school had burned down.",
            exampleNative = "Она была shocked, услышав, что её старая школа сгорела.",
            pos = "adjective", semanticGroup = "emotions_basic_states",
            isFillInBlankSafe = false),

        // ── emotions_basic_actions (5) ────────────────────────────────────

        WordEntity(id = 36016, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "smile", transliteration = "[smaɪl]", translation = "улыбаться",
            definition = "To turn up the corners of your mouth to show good feelings.",
            definitionNative = "Поднять уголки рта — показать, что тебе хорошо или приятно.",
            example = "The baby will smile every time she sees her mother.",
            exampleNative = "Малышка smile каждый раз, когда видит маму рядом.",
            pos = "verb", semanticGroup = "emotions_basic_actions",
            isFillInBlankSafe = false),

        WordEntity(id = 36017, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "laugh", transliteration = "[læf]", translation = "смеяться",
            definition = "To make happy sounds with your voice when something is very funny.",
            definitionNative = "Издавать весёлые звуки голосом, когда что-то очень забавно.",
            example = "We laugh together every time we watch that old comedy.",
            exampleNative = "Мы вместе laugh каждый раз, когда смотрим эту старую комедию.",
            pos = "verb", semanticGroup = "emotions_basic_actions",
            isFillInBlankSafe = false),

        WordEntity(id = 36018, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "cry", transliteration = "[kraɪ]", translation = "плакать",
            definition = "To let tears fall from your eyes when you feel hurt or very sad.",
            definitionNative = "Ронять слёзы из глаз, когда обидно, больно или очень грустно.",
            example = "The little boy began to cry when he dropped his ice cream.",
            exampleNative = "Малыш начал cry, когда уронил мороженое на землю.",
            pos = "verb", semanticGroup = "emotions_basic_actions",
            isFillInBlankSafe = false),

        WordEntity(id = 36019, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "frown", transliteration = "[fraʊn]", translation = "хмуриться",
            definition = "To pull your eyebrows down to show you are upset or thinking hard.",
            definitionNative = "Опустить брови — показать недовольство или сильное раздумье.",
            example = "Grandpa began to frown when he heard the loud music next door.",
            exampleNative = "Дедушка стал frown, услышав громкую музыку у соседей.",
            pos = "verb", semanticGroup = "emotions_basic_actions",
            isFillInBlankSafe = false),

        WordEntity(id = 36020, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sigh", transliteration = "[saɪ]", translation = "вздыхать",
            definition = "To let out a long slow breath when you feel tired, sad or relieved.",
            definitionNative = "Выпустить долгий медленный выдох — от усталости, грусти или облегчения.",
            example = "She let out a sigh as she sat down after a long shift.",
            exampleNative = "Она издала sigh, садясь после долгой смены.",
            pos = "verb", semanticGroup = "emotions_basic_actions",
            isFillInBlankSafe = false),

        // ── emotions_basic_express (5) ────────────────────────────────────

        WordEntity(id = 36021, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "feel", transliteration = "[fil]", translation = "чувствовать",
            definition = "To know something inside — joy, pain, cold or that a friend is sad.",
            definitionNative = "Знать что-то внутри — радость, боль, холод или грусть друга.",
            example = "I feel happy when my whole family sits at the table together.",
            exampleNative = "Я feel радость, когда вся семья садится за стол вместе.",
            pos = "verb", semanticGroup = "emotions_basic_express",
            isFillInBlankSafe = false),

        WordEntity(id = 36022, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mood", transliteration = "[mud]", translation = "настроение",
            definition = "How you feel right now — happy, sad, angry or just so-so.",
            definitionNative = "Как ты себя чувствуешь сейчас — весело, грустно, сердито или средне.",
            example = "He was in a great mood after passing all his exams.",
            exampleNative = "У него было прекрасное mood после сдачи всех экзаменов.",
            pos = "noun", semanticGroup = "emotions_basic_express",
            isFillInBlankSafe = false),

        WordEntity(id = 36023, setId = 360, languagePair = "en-ru", rarity = "COMMON",
            original = "heart", transliteration = "[hɑrt]", translation = "сердце",
            definition = "The place inside you where love and warm feelings live.",
            definitionNative = "Место внутри тебя, где живут любовь и тёплые чувства.",
            example = "Her warm heart helped many lonely children find a home.",
            exampleNative = "Её доброе heart помогло многим одиноким детям найти дом.",
            pos = "noun", semanticGroup = "emotions_basic_express",
            isFillInBlankSafe = false),

        WordEntity(id = 36024, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tear", transliteration = "[tɪr]", translation = "слеза",
            definition = "A drop of water from your eye when you are very sad or very moved.",
            definitionNative = "Капля влаги из глаза, когда очень грустно или очень тронут.",
            example = "A single tear rolled down her cheek as she read the letter.",
            exampleNative = "Одинокая tear скатилась по её щеке, пока она читала письмо.",
            pos = "noun", semanticGroup = "emotions_basic_express",
            isFillInBlankSafe = false),

        WordEntity(id = 36025, setId = 360, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hug", transliteration = "[hʌg]", translation = "обнимать",
            definition = "To wrap your arms around someone to show love or comfort.",
            definitionNative = "Обхватить кого-то руками — показать любовь или поддержать.",
            example = "She ran to hug her brother at the airport gate.",
            exampleNative = "Она побежала hug брата у выхода в аэропорту.",
            pos = "verb", semanticGroup = "emotions_basic_express",
            isFillInBlankSafe = false),
    )
}
