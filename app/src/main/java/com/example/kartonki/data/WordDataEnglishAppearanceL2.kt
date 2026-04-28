package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Внешность и тело (L2, продвинутый / A2-B1).
 *
 * Set 381: «Внешность и тело» — стрижки, мимика, фигура и черты.
 *          Более тонкая лексика: типы причёсок, выражения лица,
 *          телосложение и осанка, тонкие черты лица и отметины.
 *
 * Параллельный сет того же топика — set 380 «Внешность и тело» (level 1, основы).
 * L1 уже занял: cheek, chin, forehead, eyebrow, eyelash, blonde, curly,
 * bald, beard, ponytail, freckle, wrinkle, mole, dimple, sunburn,
 * slim, plump, skinny, muscular, slender, lips, teeth, palm, ankle, toe.
 * В L2 повтора нет (проверено grep'ом по `original`).
 *
 * Cross-topic совпадения (избегнуты):
 *   - frown — занят в EmotionsL1 (как глагол «хмуриться», pos=verb).
 *   - posture — занят в Sport/HealthFitness.
 *   - scar — занят в first_aid.
 *   - slouch — занят в EverydayL3.
 *   - nod — занят в Batch11.
 *   - pale — занят в colours (set 5).
 *
 * Распределение редкости: 18 UNCOMMON + 7 RARE — два смежных уровня A2/B1.
 *
 * SemanticGroups (5 × 5):
 *   appearance_hairstyles      — bun, braid, fringe, sideburns, stubble
 *   appearance_expressions     — grin, smirk, scowl, glare, wink
 *   appearance_build_extra     — burly, stocky, chubby, scrawny, brawny
 *   appearance_face_extra      — whisker, nape, blush, cleft, gap
 *   appearance_skin_marks_extra — tattoo, piercing, crease, birthmark, wart
 *
 * Замены при ревалидации (set 382 параллельно занял часть кандидатов):
 *   lanky→burly, cheekbone→whisker, jawline→nape, complexion→blush,
 *   earlobe→gap, blemish→wart.
 *
 * Word IDs: setId × 100 + position (38101..38125).
 *
 * fillInBlankExclusions / isFillInBlankSafe не выставлены — заполнятся
 * через FILL_IN_BLANK pipeline (см. `docs/claude/fill-in-blank-pipeline.md`).
 */
object WordDataEnglishAppearanceL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 381,
            languagePair = "en-ru",
            orderIndex = 381,
            name = "Внешность и тело",
            description = "Стрижки, мимика, фигура и черты",
            topic = "Внешность и тело",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 381 — Внешность и тело: стрижки, мимика, фигура (L2)         ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── appearance_hairstyles (5) ─────────────────────────────────────

        WordEntity(id = 38101, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "bun", transliteration = "[bʌn]", translation = "пучок (причёска)",
            definition = "Hair gathered into a small round shape on the head.",
            definitionNative = "Волосы, собранные в маленький круглый узел на голове.",
            example = "She twisted her hair into a neat bun for the interview.",
            exampleNative = "Перед собеседованием она закрутила волосы в аккуратный bun.",
            pos = "noun", semanticGroup = "appearance_hairstyles", fillInBlankExclusions = listOf(38102L, 38103L, 38104L, 38105L)),

        WordEntity(id = 38102, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "braid", transliteration = "[breɪd]", translation = "коса",
            definition = "Three strands of hair woven over and under each other.",
            definitionNative = "Три пряди волос, переплетённые между собой.",
            example = "Her grandma made her a long braid every morning before school.",
            exampleNative = "Бабушка каждое утро заплетала ей длинную braid перед школой.",
            pos = "noun", semanticGroup = "appearance_hairstyles", fillInBlankExclusions = listOf(38101L, 38103L, 38104L, 38105L)),

        WordEntity(id = 38103, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "fringe", transliteration = "[frɪnʤ]", translation = "чёлка",
            definition = "Short hair cut to hang down over the forehead.",
            definitionNative = "Короткие волосы, спадающие на лоб.",
            example = "She got a short fringe at the salon and loved the new look.",
            exampleNative = "В салоне ей сделали короткую fringe — новый образ ей понравился.",
            pos = "noun", semanticGroup = "appearance_hairstyles", fillInBlankExclusions = listOf(38101L, 38102L, 38104L, 38105L)),

        WordEntity(id = 38104, setId = 381, languagePair = "en-ru", rarity = "RARE",
            original = "sideburns", transliteration = "[ˈsaɪdˌbɜːrnz]", translation = "бакенбарды",
            definition = "Strips of hair on the sides of a man's face, in front of the ears.",
            definitionNative = "Полоски волос по бокам мужского лица — перед ушами.",
            example = "His thick sideburns gave him a classic 70s rock look.",
            exampleNative = "Густые sideburns придавали ему классический рокерский вид 70-х.",
            pos = "noun", semanticGroup = "appearance_hairstyles", fillInBlankExclusions = listOf(38101L, 38102L, 38103L, 38105L)),

        WordEntity(id = 38105, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "stubble", transliteration = "[ˈstʌbəl]", translation = "щетина",
            definition = "Very short hair on a man's face, a few days after shaving.",
            definitionNative = "Очень короткие волосы на мужском лице — через пару дней после бритья.",
            example = "He scratched the rough stubble on his chin and yawned.",
            exampleNative = "Он почесал жёсткую stubble на подбородке и зевнул.",
            pos = "noun", semanticGroup = "appearance_hairstyles", fillInBlankExclusions = listOf(38101L, 38102L, 38103L, 38104L, 38116L)),

        // ── appearance_expressions (5) ────────────────────────────────────

        WordEntity(id = 38106, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "grin", transliteration = "[ɡrɪn]", translation = "ухмылка, широкая улыбка",
            definition = "A wide happy smile that shows the teeth.",
            definitionNative = "Широкая радостная улыбка, при которой видны зубы.",
            example = "He had a huge grin on his face when he saw the cake.",
            exampleNative = "На его лице сияла огромная grin, когда он увидел торт.",
            pos = "noun", semanticGroup = "appearance_expressions", fillInBlankExclusions = listOf(38107L, 38108L, 38109L, 38110L, 38118L)),

        WordEntity(id = 38107, setId = 381, languagePair = "en-ru", rarity = "RARE",
            original = "smirk", transliteration = "[smɜːrk]", translation = "самодовольная ухмылка",
            definition = "A small smile that looks pleased with itself or slightly mocking.",
            definitionNative = "Лёгкая улыбка с оттенком самодовольства или насмешки.",
            example = "She gave him a quiet smirk after winning the chess match.",
            exampleNative = "Выиграв партию в шахматы, она тихо подарила ему smirk.",
            pos = "noun", semanticGroup = "appearance_expressions", fillInBlankExclusions = listOf(38106L, 38108L, 38109L, 38110L)),

        WordEntity(id = 38108, setId = 381, languagePair = "en-ru", rarity = "RARE",
            original = "scowl", transliteration = "[skaʊl]", translation = "сердитый взгляд",
            definition = "An angry face with the brows pulled tight together.",
            definitionNative = "Сердитое лицо со сведёнными вместе бровями.",
            example = "The old man gave the noisy kids a deep scowl from the porch.",
            exampleNative = "Старик с крыльца бросил шумным детям мрачный scowl.",
            pos = "noun", semanticGroup = "appearance_expressions", fillInBlankExclusions = listOf(38106L, 38107L, 38109L, 38110L)),

        WordEntity(id = 38109, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "glare", transliteration = "[ɡlɛər]", translation = "пристальный сердитый взгляд",
            definition = "A long hard look that shows anger or strong feelings.",
            definitionNative = "Долгий тяжёлый взгляд — выражает злость или сильное чувство.",
            example = "She shot him a furious glare across the dinner table.",
            exampleNative = "Через обеденный стол она метнула в него яростный glare.",
            pos = "noun", semanticGroup = "appearance_expressions", fillInBlankExclusions = listOf(38106L, 38107L, 38108L, 38110L)),

        WordEntity(id = 38110, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wink", transliteration = "[wɪŋk]", translation = "подмигивание",
            definition = "A quick close of one eye — usually a friendly or playful sign.",
            definitionNative = "Быстрое закрытие одного глаза — обычно дружеский или игривый знак.",
            example = "Grandpa gave me a sly wink when nobody else was looking.",
            exampleNative = "Дедушка хитро подарил мне wink, пока никто не смотрел.",
            pos = "noun", semanticGroup = "appearance_expressions", fillInBlankExclusions = listOf(38106L, 38107L, 38108L, 38109L)),

        // ── appearance_build_extra (5) ────────────────────────────────────

        WordEntity(id = 38111, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "burly", transliteration = "[ˈbɜːrli]", translation = "дюжий, плотный",
            definition = "Big and heavy in the body, looking rough and strong.",
            definitionNative = "Большой и тяжёлый телом — выглядит грубовато и крепко.",
            example = "A burly guard stood quietly by the entrance to the club.",
            exampleNative = "У входа в клуб тихо стоял burly охранник.",
            pos = "adjective", semanticGroup = "appearance_build_extra", fillInBlankExclusions = listOf(38112L, 38113L, 38114L, 38115L)),

        WordEntity(id = 38112, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "stocky", transliteration = "[ˈstɒki]", translation = "коренастый",
            definition = "Short and solid, with a wide strong-looking body.",
            definitionNative = "Невысокий и плотный — с широким, крепким на вид телом.",
            example = "The stocky farmer lifted the heavy sack of grain with one arm.",
            exampleNative = "Stocky фермер поднял тяжёлый мешок зерна одной рукой.",
            pos = "adjective", semanticGroup = "appearance_build_extra", fillInBlankExclusions = listOf(38111L, 38113L, 38114L, 38115L)),

        WordEntity(id = 38113, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "chubby", transliteration = "[ˈʧʌbi]", translation = "пухленький",
            definition = "Slightly fat in a soft, cute way — often said about kids or babies.",
            definitionNative = "Немного пухлый — мягко и мило, часто о детях или малышах.",
            example = "The chubby baby clapped his tiny hands and laughed loudly.",
            exampleNative = "Chubby малыш хлопал крошечными ладошками и громко смеялся.",
            pos = "adjective", semanticGroup = "appearance_build_extra", fillInBlankExclusions = listOf(38111L, 38112L, 38114L, 38115L)),

        WordEntity(id = 38114, setId = 381, languagePair = "en-ru", rarity = "RARE",
            original = "scrawny", transliteration = "[ˈskrɔːni]", translation = "тощий, костлявый",
            definition = "Unpleasantly thin and weak-looking — like you can see the bones.",
            definitionNative = "Неприятно худой и хилый на вид — будто видны все кости.",
            example = "A scrawny stray cat wandered into our garden looking for food.",
            exampleNative = "К нам в сад забрёл scrawny бродячий кот в поисках еды.",
            pos = "adjective", semanticGroup = "appearance_build_extra", fillInBlankExclusions = listOf(38111L, 38112L, 38113L, 38115L)),

        WordEntity(id = 38115, setId = 381, languagePair = "en-ru", rarity = "RARE",
            original = "brawny", transliteration = "[ˈbrɔːni]", translation = "крепкий, мускулистый",
            definition = "Big and strong in the body — with thick arms and broad shoulders.",
            definitionNative = "Большой и сильный телом — с толстыми руками и широкими плечами.",
            example = "Two brawny movers carried the old piano up the narrow stairs.",
            exampleNative = "Два brawny грузчика подняли старое пианино по узкой лестнице.",
            pos = "adjective", semanticGroup = "appearance_build_extra", fillInBlankExclusions = listOf(38111L, 38112L, 38113L, 38114L)),

        // ── appearance_face_extra (5) ─────────────────────────────────────

        WordEntity(id = 38116, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "whisker", transliteration = "[ˈwɪskər]", translation = "волосок (на лице)",
            definition = "A single hair on the face of a man — like one short hair of stubble.",
            definitionNative = "Одна короткая щетинка на лице у мужчины — будто отдельный обрубок бороды.",
            example = "He felt a stray whisker poking out near his upper lip.",
            exampleNative = "Он почувствовал, как над губой торчит одинокий whisker.",
            pos = "noun", semanticGroup = "appearance_face_extra", fillInBlankExclusions = listOf(38117L, 38118L, 38119L, 38120L)),

        WordEntity(id = 38117, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "nape", transliteration = "[neɪp]", translation = "затылок (нижняя часть шеи)",
            definition = "The back side of the neck, just below the head.",
            definitionNative = "Задняя сторона шеи — прямо под головой.",
            example = "She felt a cold drop of rain land on her nape.",
            exampleNative = "Она почувствовала, как холодная капля дождя упала ей на nape.",
            pos = "noun", semanticGroup = "appearance_face_extra", fillInBlankExclusions = listOf(38116L, 38118L, 38119L, 38120L)),

        WordEntity(id = 38118, setId = 381, languagePair = "en-ru", rarity = "RARE",
            original = "blush", transliteration = "[blʌʃ]", translation = "румянец",
            definition = "A soft pink colour on the cheeks from cold, joy or shame.",
            definitionNative = "Мягкий розовый оттенок на щеках — от холода, радости или стыда.",
            example = "A faint blush spread across her face when he said hello.",
            exampleNative = "Слабый blush разлился по её лицу, когда он поздоровался.",
            pos = "noun", semanticGroup = "appearance_face_extra", fillInBlankExclusions = listOf(38106L, 38107L, 38116L, 38117L, 38119L, 38120L)),

        WordEntity(id = 38119, setId = 381, languagePair = "en-ru", rarity = "RARE",
            original = "cleft", transliteration = "[klɛft]", translation = "ямочка (на подбородке)",
            definition = "A small dent in the middle of the chin — common in some families.",
            definitionNative = "Небольшая выемка посередине подбородка — у некоторых семей бывает.",
            example = "His son inherited the same charming cleft on his chin.",
            exampleNative = "Его сын унаследовал такую же очаровательную cleft на подбородке.",
            pos = "noun", semanticGroup = "appearance_face_extra", fillInBlankExclusions = listOf(38116L, 38117L, 38118L, 38120L, 38124L)),

        WordEntity(id = 38120, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "gap", transliteration = "[ɡæp]", translation = "щель, промежуток",
            definition = "A small open space — for example, between two front teeth.",
            definitionNative = "Маленькое открытое пространство — например, между передними зубами.",
            example = "The little boy has a cute gap between his two front teeth.",
            exampleNative = "У маленького мальчика милая gap между двумя передними зубами.",
            pos = "noun", semanticGroup = "appearance_face_extra", fillInBlankExclusions = listOf(38116L, 38117L, 38118L, 38119L)),

        // ── appearance_skin_marks_extra (5) ───────────────────────────────

        WordEntity(id = 38121, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tattoo", transliteration = "[təˈtuː]", translation = "татуировка",
            definition = "A picture or word inked into the skin so it stays for life.",
            definitionNative = "Рисунок или слово, нанесённые чернилами под кожу — на всю жизнь.",
            example = "She got a small tattoo of a star on her wrist.",
            exampleNative = "Она сделала маленькое tattoo в виде звезды на запястье.",
            pos = "noun", semanticGroup = "appearance_skin_marks_extra", fillInBlankExclusions = listOf(38122L, 38123L, 38124L, 38125L)),

        WordEntity(id = 38122, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "piercing", transliteration = "[ˈpɪərsɪŋ]", translation = "пирсинг",
            definition = "A small hole in the body for wearing rings or studs.",
            definitionNative = "Маленькое отверстие в теле — для колечек или маленьких украшений.",
            example = "His mother was upset about the new piercing in his eyebrow.",
            exampleNative = "Мать была расстроена новым piercing в его брови.",
            pos = "noun", semanticGroup = "appearance_skin_marks_extra", fillInBlankExclusions = listOf(38121L, 38123L, 38124L, 38125L)),

        WordEntity(id = 38123, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "crease", transliteration = "[kriːs]", translation = "складка, морщинка",
            definition = "A line on the skin where it folds — like at the corners of the eyes.",
            definitionNative = "Линия на коже в месте сгиба — например, в уголках глаз.",
            example = "A small crease appeared by his eye every time he smiled.",
            exampleNative = "Каждый раз, когда он улыбался, у глаза появлялась маленькая crease.",
            pos = "noun", semanticGroup = "appearance_skin_marks_extra", fillInBlankExclusions = listOf(38121L, 38122L, 38124L, 38125L)),

        WordEntity(id = 38124, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "birthmark", transliteration = "[ˈbɜːrθˌmɑːrk]", translation = "родимое пятно",
            definition = "A coloured spot on the skin that a person has from the day they are born.",
            definitionNative = "Цветное пятно на коже — есть у человека с самого рождения.",
            example = "She has a tiny heart-shaped birthmark on her right shoulder.",
            exampleNative = "У неё на правом плече крошечное birthmark в форме сердца.",
            pos = "noun", semanticGroup = "appearance_skin_marks_extra", fillInBlankExclusions = listOf(38121L, 38122L, 38123L, 38125L)),

        WordEntity(id = 38125, setId = 381, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wart", transliteration = "[wɔːrt]", translation = "бородавка",
            definition = "A small hard rough lump on the skin, often on hands or fingers.",
            definitionNative = "Маленький твёрдый шершавый бугорок на коже — часто на руках или пальцах.",
            example = "He had a tiny wart on his thumb that the doctor froze off.",
            exampleNative = "У него на большом пальце была крошечная wart, и врач её заморозил.",
            pos = "noun", semanticGroup = "appearance_skin_marks_extra", fillInBlankExclusions = listOf(38121L, 38122L, 38123L, 38124L)),
    )
}
