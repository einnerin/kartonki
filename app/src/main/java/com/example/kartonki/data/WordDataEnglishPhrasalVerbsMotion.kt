package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Фразовые глаголы (Motion, UNCOMMON+RARE).
 *
 * Set 451: «Фразовые глаголы» — расширение темы (level 2). Это шестой
 *          сет в линейке Phrasal Verbs (продолжение L1=410, L2=411,
 *          L3=412, L4=413, L5=414). Узкий фокус — phrasal verbs
 *          движения: уход/прибытие, перемещение на транспорте,
 *          краткие визиты, ориентация в пространстве, темп и скорость.
 *
 * В отличие от L1-L5 (которые покрывают разные функциональные темы —
 * рутина, бизнес, эмоции, литературный регистр), этот сет полностью
 * посвящён физическому перемещению в пространстве.
 *
 * Phrasal verbs остаются отдельным классом от:
 *   • обычных verbs (run, walk, drive — одно слово)
 *   • idioms (kill two birds with one stone — образное выражение)
 *
 * Распределение редкости: 13 UNCOMMON (A2-B1) + 12 RARE (B2). Самые
 * частотные базовые движения (set off, come over, turn around, take off,
 * get off, run away, walk off, pull over, drive around, pass through,
 * stop by, drop in, cross over) — UNCOMMON. Менее частотные или с
 * метафорическим оттенком (head back, slip out, pop in, swing by,
 * double back, back away, step back, wander off, breeze past, plough
 * through, rush out, stroll along) — RARE.
 *
 * ⚠️ Коллизии при подготовке (проверено grep'ом по `original = "..."`):
 *   все 25 phrasal verbs Motion свободны — пересечений с L1 (410),
 *   L2 (411), L3 (412), L4 (413), L5 (414) и прочими сетами не
 *   обнаружено. Изначально рассматривались "go away", "come back",
 *   "drop by", "get on", "go through" — все заняты в L1-L3, потому
 *   заменены на семантически близкие свободные ("set off", "head
 *   back", "drop in"/"pop in", "get off", "pass through").
 *
 * SemanticGroups (5 × 5):
 *   phrasal_motion_arrival_departure — set off, head back, run away, walk off, slip out
 *   phrasal_motion_vehicles          — pull over, drive around, pass through, take off, get off
 *   phrasal_motion_visit             — pop in, swing by, stop by, come over, drop in
 *   phrasal_motion_orientation       — turn around, double back, cross over, back away, step back
 *   phrasal_motion_speed_pace        — wander off, breeze past, plough through, rush out, stroll along
 *
 * Word IDs: setId × 100 + position (45101..45125).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions заполнятся через
 * FILL_IN_BLANK pipeline после черновика.
 */
object WordDataEnglishPhrasalVerbsMotion {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 451,
            languagePair = "en-ru",
            orderIndex = 451,
            name = "Фразовые глаголы",
            description = "Фразовые глаголы движения: уход, транспорт, визиты, ориентация и темп",
            topic = "Фразовые глаголы",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 451 — Фразовые глаголы: движение (UNCOMMON+RARE)                ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── phrasal_motion_arrival_departure (5) ───────────────────────────

        WordEntity(id = 45101, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "set off", transliteration = "[sɛt ɔf]", translation = "отправиться (в путь)",
            definition = "To start a journey or trip towards a planned destination.",
            definitionNative = "Начать поездку или путь к намеченному месту назначения.",
            example = "We need to set off early to avoid the morning traffic.",
            exampleNative = "Нам нужно set off пораньше, чтобы избежать утренних пробок.",
            pos = "phrase", semanticGroup = "phrasal_motion_arrival_departure", fillInBlankExclusions = listOf(45102L, 45103L, 45104L, 45105L, 45109L, 45124L)),

        WordEntity(id = 45102, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "head back", transliteration = "[hɛd bæk]", translation = "двинуться обратно",
            definition = "To start travelling towards the place you came from.",
            definitionNative = "Двинуться в направлении того места, откуда пришёл.",
            example = "It's getting dark — we should head back to the camp now.",
            exampleNative = "Темнеет — нам стоит head back в лагерь прямо сейчас.",
            pos = "phrase", semanticGroup = "phrasal_motion_arrival_departure", fillInBlankExclusions = listOf(45101L, 45103L, 45104L, 45105L, 45116L, 45117L, 45124L)),

        WordEntity(id = 45103, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "run away", transliteration = "[rʌn əˈweɪ]", translation = "сбежать, убежать",
            definition = "To escape from a place by running, often in a hurry or in fear.",
            definitionNative = "Покинуть место бегом — часто торопясь или из страха.",
            example = "Wild deer usually run away when people approach.",
            exampleNative = "Испуганный олень run away, едва нас заметив.",
            pos = "phrase", semanticGroup = "phrasal_motion_arrival_departure", fillInBlankExclusions = listOf(45101L, 45102L, 45104L, 45105L, 45109L, 45116L, 45117L, 45119L, 45120L, 45121L, 45124L)),

        WordEntity(id = 45104, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "walk off", transliteration = "[wɔk ɔf]", translation = "уйти прочь (пешком, в раздражении)",
            definition = "To leave a place on foot, often suddenly because you are upset or angry.",
            definitionNative = "Уйти откуда-то пешком — часто резко, в обиде или раздражении.",
            example = "Don't just walk off without saying goodbye.",
            exampleNative = "Она просто walk off, ни с кем не попрощавшись.",
            pos = "phrase", semanticGroup = "phrasal_motion_arrival_departure", fillInBlankExclusions = listOf(45101L, 45102L, 45103L, 45105L, 45109L, 45124L)),

        WordEntity(id = 45105, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "slip out", transliteration = "[slɪp aʊt]", translation = "выскользнуть, тихо уйти",
            definition = "To leave a place quietly so that other people do not notice.",
            definitionNative = "Незаметно покинуть помещение так, чтобы окружающие не обратили внимания.",
            example = "I'll slip out during the break and grab some coffee.",
            exampleNative = "Я slip out на перерыве и схвачу немного кофе.",
            pos = "phrase", semanticGroup = "phrasal_motion_arrival_departure", fillInBlankExclusions = listOf(45101L, 45102L, 45103L, 45104L, 45109L, 45111L, 45124L)),

        // ── phrasal_motion_vehicles (5) ────────────────────────────────────

        WordEntity(id = 45106, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "pull over", transliteration = "[pʊl ˈoʊvər]", translation = "съехать на обочину, остановить машину",
            definition = "To move a vehicle to the side of the road and stop there.",
            definitionNative = "Отвести машину к краю дороги и остановиться там.",
            example = "The driver had to pull over because of the heavy fog.",
            exampleNative = "Водителю пришлось pull over из-за густого тумана.",
            pos = "phrase", semanticGroup = "phrasal_motion_vehicles", fillInBlankExclusions = listOf(45107L, 45108L, 45109L, 45110L, 45117L, 45120L)),

        WordEntity(id = 45107, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "drive around", transliteration = "[draɪv əˈraʊnd]", translation = "кататься, ездить (без цели)",
            definition = "To travel by car through an area without a fixed destination.",
            definitionNative = "Передвигаться на машине по местности без определённой цели.",
            example = "We like to drive around the old town on quiet evenings.",
            exampleNative = "Мы любим drive around по старому городу тихими вечерами.",
            pos = "phrase", semanticGroup = "phrasal_motion_vehicles", fillInBlankExclusions = listOf(45106L, 45108L, 45109L, 45110L, 45125L)),

        WordEntity(id = 45108, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "pass through", transliteration = "[pæs θru]", translation = "проезжать через, проходить через",
            definition = "To travel through a place on the way to somewhere else.",
            definitionNative = "Проехать или пройти через какое-то место по пути куда-то ещё.",
            example = "Fast trains often pass through small villages without stopping.",
            exampleNative = "Поезд pass through несколько мелких деревень до того, как добраться до города.",
            pos = "phrase", semanticGroup = "phrasal_motion_vehicles", fillInBlankExclusions = listOf(45106L, 45107L, 45109L, 45110L)),

        WordEntity(id = 45109, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "take off", transliteration = "[teɪk ɔf]", translation = "взлетать (о самолёте)",
            definition = "When a plane leaves the ground and starts flying upward.",
            definitionNative = "Когда самолёт отрывается от земли и начинает подниматься в воздух.",
            example = "Our plane will take off in about twenty minutes.",
            exampleNative = "Наш самолёт take off примерно через двадцать минут.",
            pos = "phrase", semanticGroup = "phrasal_motion_vehicles", fillInBlankExclusions = listOf(45101L, 45106L, 45107L, 45108L, 45110L)),

        WordEntity(id = 45110, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "get off", transliteration = "[ɡɛt ɔf]", translation = "сойти, выйти (из транспорта)",
            definition = "To leave a bus, train or plane after a journey.",
            definitionNative = "Покинуть автобус, поезд или самолёт после поездки.",
            example = "We should get off at the next stop near the museum.",
            exampleNative = "Нам нужно get off на следующей остановке у музея.",
            pos = "phrase", semanticGroup = "phrasal_motion_vehicles", fillInBlankExclusions = listOf(45106L, 45107L, 45108L, 45109L, 45112L, 45113L, 45116L)),

        // ── phrasal_motion_visit (5) ───────────────────────────────────────

        WordEntity(id = 45111, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "pop in", transliteration = "[pɑp ɪn]", translation = "забежать (на минутку)",
            definition = "To enter a place for a very short visit, usually casually.",
            definitionNative = "Зайти куда-то совсем ненадолго, обычно по пути.",
            example = "I'll just pop in to say hello and then run home.",
            exampleNative = "Я только pop in поздороваться и сразу побегу домой.",
            pos = "phrase", semanticGroup = "phrasal_motion_visit", fillInBlankExclusions = listOf(45105L, 45112L, 45113L, 45114L, 45115L)),

        WordEntity(id = 45112, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "swing by", transliteration = "[swɪŋ baɪ]", translation = "заскочить (по пути)",
            definition = "To stop at a place briefly while travelling somewhere else.",
            definitionNative = "Кратко остановиться в каком-то месте по пути куда-то ещё.",
            example = "Can you swing by the bakery and pick up some bread?",
            exampleNative = "Можешь swing by пекарню и взять хлеба?",
            pos = "phrase", semanticGroup = "phrasal_motion_visit", fillInBlankExclusions = listOf(45111L, 45113L, 45114L, 45115L)),

        WordEntity(id = 45113, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "stop by", transliteration = "[stɑp baɪ]", translation = "заглянуть, заехать ненадолго",
            definition = "To visit a place for a short time, often without staying long.",
            definitionNative = "Посетить место на короткое время, не задерживаясь надолго.",
            example = "Feel free to stop by my office whenever you have questions.",
            exampleNative = "Можешь stop by ко мне в кабинет, когда возникнут вопросы.",
            pos = "phrase", semanticGroup = "phrasal_motion_visit", fillInBlankExclusions = listOf(45111L, 45112L, 45114L, 45115L)),

        WordEntity(id = 45114, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "come over", transliteration = "[kʌm ˈoʊvər]", translation = "прийти в гости",
            definition = "To visit someone at their home, usually for a friendly reason.",
            definitionNative = "Прийти к кому-то домой — обычно по дружескому поводу.",
            example = "Why don't you come over for dinner this Saturday?",
            exampleNative = "Почему бы тебе не come over к нам на ужин в субботу?",
            pos = "phrase", semanticGroup = "phrasal_motion_visit", fillInBlankExclusions = listOf(45111L, 45112L, 45113L, 45115L)),

        WordEntity(id = 45115, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "drop in", transliteration = "[drɑp ɪn]", translation = "заглянуть без предупреждения",
            definition = "To visit someone unexpectedly without arranging it in advance.",
            definitionNative = "Зайти к кому-то неожиданно, не договариваясь заранее.",
            example = "My uncle likes to drop in on us every Sunday afternoon.",
            exampleNative = "Дядя любит drop in к нам каждое воскресенье днём.",
            pos = "phrase", semanticGroup = "phrasal_motion_visit", fillInBlankExclusions = listOf(45111L, 45112L, 45113L, 45114L)),

        // ── phrasal_motion_orientation (5) ─────────────────────────────────

        WordEntity(id = 45116, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "turn around", transliteration = "[tɜrn əˈraʊnd]", translation = "развернуться, повернуться кругом",
            definition = "To move your body or a vehicle so that you face the opposite direction.",
            definitionNative = "Повернуть тело или машину так, чтобы оказаться лицом в обратную сторону.",
            example = "Please turn around so I can see the back of the dress.",
            exampleNative = "Пожалуйста, turn around — хочу увидеть платье сзади.",
            pos = "phrase", semanticGroup = "phrasal_motion_orientation", fillInBlankExclusions = listOf(45117L, 45118L, 45119L, 45120L)),

        WordEntity(id = 45117, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "double back", transliteration = "[ˈdʌbəl bæk]", translation = "вернуться по своим следам",
            definition = "To return along the same path you have just travelled.",
            definitionNative = "Пойти обратно по той же дороге, по которой только что шёл.",
            example = "We had to double back when we realised we'd missed the turn.",
            exampleNative = "Нам пришлось double back, когда поняли, что пропустили поворот.",
            pos = "phrase", semanticGroup = "phrasal_motion_orientation", fillInBlankExclusions = listOf(45102L, 45116L, 45118L, 45119L, 45120L)),

        WordEntity(id = 45118, setId = 451, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cross over", transliteration = "[krɔs ˈoʊvər]", translation = "перейти на другую сторону",
            definition = "To move from one side of a road, river or border to the other.",
            definitionNative = "Перейти с одной стороны дороги, реки или границы на другую.",
            example = "Let's cross over to the sunny side of the street.",
            exampleNative = "Давай cross over на солнечную сторону улицы.",
            pos = "phrase", semanticGroup = "phrasal_motion_orientation", fillInBlankExclusions = listOf(45116L, 45117L, 45119L, 45120L)),

        WordEntity(id = 45119, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "back away", transliteration = "[bæk əˈweɪ]", translation = "пятиться, медленно отступать",
            definition = "To move slowly backwards because you are afraid or want to avoid something.",
            definitionNative = "Медленно двигаться задом — от страха или желая чего-то избежать.",
            example = "You should back away slowly from an angry dog.",
            exampleNative = "Он back away от злой собаки очень медленно.",
            pos = "phrase", semanticGroup = "phrasal_motion_orientation", fillInBlankExclusions = listOf(45116L, 45117L, 45118L, 45120L, 45121L)),

        WordEntity(id = 45120, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "step back", transliteration = "[stɛp bæk]", translation = "отступить на шаг, отойти назад",
            definition = "To move one pace backwards, especially to give space or get a better view.",
            definitionNative = "Отойти на одну позицию назад — обычно чтобы освободить место или лучше рассмотреть.",
            example = "Please step back and let the doctors do their job.",
            exampleNative = "Пожалуйста, step back и дайте врачам делать свою работу.",
            pos = "phrase", semanticGroup = "phrasal_motion_orientation", fillInBlankExclusions = listOf(45116L, 45117L, 45118L, 45119L)),

        // ── phrasal_motion_speed_pace (5) ──────────────────────────────────

        WordEntity(id = 45121, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "wander off", transliteration = "[ˈwɑndər ɔf]", translation = "забрести, уйти куда-то (бесцельно)",
            definition = "To move away slowly from a place without a clear plan or aim.",
            definitionNative = "Медленно отойти куда-то без определённого плана или цели.",
            example = "Small children sometimes wander off at a busy fair.",
            exampleNative = "Малыш wander off от родителей на ярмарке.",
            pos = "phrase", semanticGroup = "phrasal_motion_speed_pace", fillInBlankExclusions = listOf(45103L, 45104L, 45105L, 45119L, 45122L, 45123L, 45124L, 45125L)),

        WordEntity(id = 45122, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "breeze past", transliteration = "[briz pæst]", translation = "пронестись мимо (легко, быстро)",
            definition = "To move past someone or something quickly and effortlessly.",
            definitionNative = "Быстро и без видимых усилий пройти или проехать мимо кого-то.",
            example = "Strong runners can breeze past tired opponents near the finish.",
            exampleNative = "Молодой бегун breeze past старших спортсменов у самого финиша.",
            pos = "phrase", semanticGroup = "phrasal_motion_speed_pace", fillInBlankExclusions = listOf(45121L, 45123L, 45124L, 45125L)),

        WordEntity(id = 45123, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "plough through", transliteration = "[plaʊ θru]", translation = "продираться, пробиваться через",
            definition = "To force a way forward through a crowd, snow or other heavy obstacle.",
            definitionNative = "Силой пробиваться вперёд через толпу, снег или другую тяжёлую преграду.",
            example = "Heavy trucks can plough through deep snow on mountain roads.",
            exampleNative = "Грузовик plough through глубокий снег на горной дороге.",
            pos = "phrase", semanticGroup = "phrasal_motion_speed_pace", fillInBlankExclusions = listOf(45107L, 45108L, 45121L, 45122L, 45124L, 45125L)),

        WordEntity(id = 45124, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "rush out", transliteration = "[rʌʃ aʊt]", translation = "выскочить, выбежать наружу",
            definition = "To leave a place very quickly, often because of an emergency.",
            definitionNative = "Очень быстро покинуть место — часто из-за срочной ситуации.",
            example = "Everyone rush out of the building when the alarm went off.",
            exampleNative = "Все rush out из здания, когда сработала сигнализация.",
            pos = "phrase", semanticGroup = "phrasal_motion_speed_pace", fillInBlankExclusions = listOf(45101L, 45103L, 45104L, 45105L, 45121L, 45122L, 45123L, 45125L)),

        WordEntity(id = 45125, setId = 451, languagePair = "en-ru", rarity = "RARE",
            original = "stroll along", transliteration = "[stroʊl əˈlɔŋ]", translation = "прогуливаться, идти неспешно",
            definition = "To walk slowly and calmly, just enjoying the surroundings.",
            definitionNative = "Идти медленно и спокойно, просто наслаждаясь окружающей обстановкой.",
            example = "We love to stroll along the river on warm spring evenings.",
            exampleNative = "Мы любим stroll along по реке тёплыми весенними вечерами.",
            pos = "phrase", semanticGroup = "phrasal_motion_speed_pace", fillInBlankExclusions = listOf(45107L, 45108L, 45121L, 45122L, 45123L, 45124L)),
    )
}
