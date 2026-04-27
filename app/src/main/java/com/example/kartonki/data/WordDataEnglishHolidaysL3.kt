package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Праздники и традиции (level 3, углублённый / B2).
 *
 * Set 372: «Праздники и традиции: углублённый» — конкретные праздники
 * (Рождество, Хэллоуин, Пасха, Благодарение, день рождения), обряды и
 * жизненные вехи (свадьба, выпускной, baby shower, новоселье),
 * традиционные обычаи (тост, фейерверк, парад, семейная встреча).
 *
 * Распределение редкости: 13 RARE + 12 EPIC — два смежных уровня (B2→C1).
 *
 * Дополняет существующие сеты темы «Праздники и традиции»:
 *   - Set 370 (WordDataEnglishHolidaysL1.kt) — L1 COMMON/UNCOMMON (параллельная разработка).
 *   - Set 371 (WordDataEnglishHolidaysL2.kt) — L2 UNCOMMON/RARE (параллельная разработка).
 *
 * Слова выбраны так, чтобы не пересекаться со всем corpus'ом по теме
 * (parade/toast/fireworks/costume/wedding/graduation/reunion есть в других
 * темах — set 202 «Культура и искусство», set 285 «Семья» — но это разные
 * темы, политика проекта это разрешает).
 *
 * SemanticGroups (5 × 5):
 *   holidays_christmas   — Christmas, Christmas Eve, mistletoe, carol, advent
 *   holidays_halloween   — Halloween, costume, jack-o'-lantern, trick-or-treat, haunted house
 *   holidays_seasonal    — Easter, Thanksgiving, New Year's Eve, Valentine's Day, Independence Day
 *   holidays_milestones  — wedding, graduation, baby shower, retirement party, housewarming
 *   holidays_traditions  — toast, fireworks, parade, family reunion, white elephant gift
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 *
 * Word IDs: 37201..37225 (setId × 100 + position).
 */
object WordDataEnglishHolidaysL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 372, languagePair = "en-ru", orderIndex = 372,
            name = "Праздники и традиции",
            description = "Углублённый: конкретные праздники, обряды, обычаи, юбилеи",
            topic = "Праздники и традиции", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── holidays_christmas (5) — Рождество и сопутствующие реалии ──────

        WordEntity(id = 37201, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "Christmas", transliteration = "[ˈkrɪsməs]", translation = "Рождество",
            definition = "The big winter celebration on December 25 with a tree, gifts and family dinner.",
            definitionNative = "Большой зимний праздник 25 декабря — с ёлкой, подарками и семейным ужином.",
            example = "We always spend Christmas at my grandmother's old country house.",
            exampleNative = "Christmas мы всегда встречаем в старом загородном доме бабушки.",
            pos = "noun", semanticGroup = "holidays_christmas",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37202L, 37203L, 37204L, 37205L, 37206L, 37211L, 37212L, 37213L, 37214L, 37215L)),

        WordEntity(id = 37202, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "Christmas Eve", transliteration = "[ˈkrɪsməs iv]", translation = "сочельник",
            definition = "The evening before December 25 — when families gather and children wait for gifts.",
            definitionNative = "Вечер перед 25 декабря — родные собираются, дети ждут подарков.",
            example = "On Christmas Eve we light candles and read stories to the kids.",
            exampleNative = "В Christmas Eve мы зажигаем свечи и читаем детям сказки.",
            pos = "noun", semanticGroup = "holidays_christmas",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37201L, 37203L, 37204L, 37205L, 37206L, 37211L, 37212L, 37213L, 37214L, 37215L)),

        WordEntity(id = 37203, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "mistletoe", transliteration = "[ˈmɪsəlˌtoʊ]", translation = "омела",
            definition = "A green plant with white berries hung at doorways — couples kiss under it.",
            definitionNative = "Зелёное растение с белыми ягодами над дверью — под ним по обычаю целуются.",
            example = "He kissed her under the mistletoe at the office holiday party.",
            exampleNative = "Он поцеловал её под mistletoe прямо на офисной вечеринке.",
            pos = "noun", semanticGroup = "holidays_christmas", fillInBlankExclusions = listOf(37201L, 37202L, 37204L, 37205L)),

        WordEntity(id = 37204, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "carol", transliteration = "[ˈkærəl]", translation = "рождественская песня",
            definition = "A cheerful song people sing in groups around the time of December 25.",
            definitionNative = "Радостная песня — её хором поют под Рождество, ходя от дома к дому.",
            example = "A small choir sang every carol we knew in the snowy square.",
            exampleNative = "Маленький хор спел в снежной площади каждый carol, что мы знали.",
            pos = "noun", semanticGroup = "holidays_christmas", fillInBlankExclusions = listOf(37201L, 37202L, 37203L, 37205L)),

        WordEntity(id = 37205, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "advent", transliteration = "[ˈædˌvɛnt]", translation = "адвент (предрождественский период)",
            definition = "The four weeks before December 25 — kids open one tiny door each morning.",
            definitionNative = "Четыре недели перед 25 декабря — дети открывают по дверце каждое утро.",
            example = "She bought a chocolate advent calendar for each grandchild this year.",
            exampleNative = "Она купила шоколадный advent-календарь каждому внуку в этом году.",
            pos = "noun", semanticGroup = "holidays_christmas", fillInBlankExclusions = listOf(37201L, 37202L, 37203L, 37204L, 37206L, 37211L)),

        // ── holidays_halloween (5) — Хэллоуин и его атрибуты ───────────────

        WordEntity(id = 37206, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "Halloween", transliteration = "[ˌhæloʊˈin]", translation = "Хэллоуин",
            definition = "An autumn evening on October 31 with spooky costumes and pumpkin decorations.",
            definitionNative = "Осенний вечер 31 октября — со страшными костюмами и тыквенным декором.",
            example = "On Halloween the whole street fills with kids in clever costumes.",
            exampleNative = "В Halloween вся улица наполняется детьми в придумках и костюмах.",
            pos = "noun", semanticGroup = "holidays_halloween",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37201L, 37202L, 37207L, 37208L, 37210L, 37211L, 37212L, 37213L, 37214L, 37215L)),

        WordEntity(id = 37207, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "disguise", transliteration = "[dɪsˈɡaɪz]", translation = "маскарадный наряд",
            definition = "Clothes or a mask worn to hide who you are — for fun or as a prank.",
            definitionNative = "Одежда или маска, скрывающая, кто ты, — для забавы или розыгрыша.",
            example = "My son wore a pirate disguise to the school Halloween parade.",
            exampleNative = "Сын надел пиратский disguise на школьный парад в Хэллоуин.",
            pos = "noun", semanticGroup = "holidays_halloween", fillInBlankExclusions = listOf(37208L, 37210L)),

        WordEntity(id = 37208, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "jack-o'-lantern", transliteration = "[ˈʤækəˌlæntərn]", translation = "тыква-фонарь",
            definition = "A pumpkin with a scary face cut into it — lit by a candle on October 31.",
            definitionNative = "Тыква с вырезанной страшной рожицей — внутри свеча, ставят 31 октября.",
            example = "We carved a glowing jack-o'-lantern and put it on the front porch.",
            exampleNative = "Мы вырезали светящийся jack-o'-lantern и поставили на крыльцо.",
            pos = "noun", semanticGroup = "holidays_halloween", fillInBlankExclusions = listOf(37206L, 37207L, 37210L)),

        WordEntity(id = 37209, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "trick-or-treat", transliteration = "[ˈtrɪk ɔr trit]", translation = "сладость или гадость",
            definition = "What children shout at the door on October 31 to get sweets from neighbours.",
            definitionNative = "Возглас детей у двери 31 октября — чтобы соседи дали сладостей.",
            example = "Kids in masks shouted trick-or-treat and held out their plastic pumpkins.",
            exampleNative = "Дети в масках кричали trick-or-treat и протягивали пластиковые тыквы.",
            pos = "phrase", semanticGroup = "holidays_halloween"),

        WordEntity(id = 37210, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "haunted house", transliteration = "[ˈhɔntəd haʊs]", translation = "дом с привидениями",
            definition = "A spooky place — real or pretend — where people scream and laugh together.",
            definitionNative = "Жуткое место — настоящее или игрушечное — где визжат и смеются вместе.",
            example = "The kids dared each other to enter the haunted house at the fair.",
            exampleNative = "Дети подзадоривали друг друга войти в haunted house на ярмарке.",
            pos = "noun", semanticGroup = "holidays_halloween", fillInBlankExclusions = listOf(37206L, 37207L, 37208L, 37223L)),

        // ── holidays_seasonal (5) — Сезонные праздники ─────────────────────

        WordEntity(id = 37211, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "Easter", transliteration = "[ˈistər]", translation = "Пасха",
            definition = "A spring holiday with painted eggs, chocolate bunnies and baskets for children.",
            definitionNative = "Весенний праздник — с крашеными яйцами, шоколадными зайцами и корзинками.",
            example = "We hide chocolate eggs in the garden for Easter every spring.",
            exampleNative = "Каждой весной на Easter мы прячем в саду шоколадные яйца.",
            pos = "noun", semanticGroup = "holidays_seasonal", fillInBlankExclusions = listOf(37212L, 37213L, 37214L, 37215L)),

        WordEntity(id = 37212, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "Thanksgiving", transliteration = "[ˈθæŋksˌgɪvɪŋ]", translation = "День благодарения",
            definition = "An American autumn feast with turkey, pie and a big family dinner table.",
            definitionNative = "Американский осенний пир — с индейкой, пирогом и большим семейным столом.",
            example = "We fly to Boston every Thanksgiving to see my wife's parents.",
            exampleNative = "На Thanksgiving мы летим в Бостон к родителям жены.",
            pos = "noun", semanticGroup = "holidays_seasonal", fillInBlankExclusions = listOf(37201L, 37202L, 37206L, 37211L, 37213L, 37214L, 37215L)),

        WordEntity(id = 37213, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "New Year's Eve", transliteration = "[nu ˈjɪrz iv]", translation = "канун Нового года",
            definition = "The party night on December 31 — people count down and clink glasses.",
            definitionNative = "Праздничная ночь 31 декабря — отсчитывают секунды и чокаются бокалами.",
            example = "On New Year's Eve we watched the fireworks from our balcony together.",
            exampleNative = "В New Year's Eve мы вместе смотрели салют с нашего балкона.",
            pos = "noun", semanticGroup = "holidays_seasonal", fillInBlankExclusions = listOf(37201L, 37202L, 37206L, 37211L, 37212L, 37214L, 37215L)),

        WordEntity(id = 37214, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "Valentine's Day", transliteration = "[ˈvæləntaɪnz deɪ]", translation = "День святого Валентина",
            definition = "A February day for couples — people give cards, roses and chocolate hearts.",
            definitionNative = "Февральский день для влюблённых — открытки, розы и шоколадные сердечки.",
            example = "He surprised her with red roses on Valentine's Day after work.",
            exampleNative = "На Valentine's Day он удивил её красными розами после работы.",
            pos = "noun", semanticGroup = "holidays_seasonal", fillInBlankExclusions = listOf(37201L, 37202L, 37206L, 37211L, 37212L, 37213L, 37215L)),

        WordEntity(id = 37215, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "Independence Day", transliteration = "[ˌɪndɪˈpɛndəns deɪ]", translation = "День независимости",
            definition = "The summer holiday on July 4 — Americans celebrate with parades and fireworks.",
            definitionNative = "Летний праздник 4 июля — американцы отмечают парадами и фейерверками.",
            example = "We grilled burgers in the park on Independence Day with the neighbours.",
            exampleNative = "На Independence Day мы жарили бургеры в парке с соседями.",
            pos = "noun", semanticGroup = "holidays_seasonal", fillInBlankExclusions = listOf(37201L, 37202L, 37206L, 37211L, 37212L, 37213L, 37214L)),

        // ── holidays_milestones (5) — Жизненные вехи и торжества ───────────

        WordEntity(id = 37216, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "wedding", transliteration = "[ˈwedɪŋ]", translation = "свадьба",
            definition = "The day a couple promises to share their lives — with rings, vows and guests.",
            definitionNative = "День, когда двое обещают делить жизнь — с кольцами, клятвами и гостями.",
            example = "My sister's wedding was held in a small chapel by the lake.",
            exampleNative = "Wedding моей сестры прошла в маленькой часовне у озера.",
            pos = "noun", semanticGroup = "holidays_milestones", fillInBlankExclusions = listOf(37217L, 37218L, 37219L, 37220L)),

        WordEntity(id = 37217, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "commencement", transliteration = "[kəˈmɛnsmənt]", translation = "торжественный выпускной",
            definition = "The formal ceremony at the end of college — graduates walk on stage in robes.",
            definitionNative = "Торжественная церемония в конце колледжа — выпускники в мантиях идут по сцене.",
            example = "Her parents flew across the country for her college commencement.",
            exampleNative = "На её commencement в колледже родители прилетели через всю страну.",
            pos = "noun", semanticGroup = "holidays_milestones", fillInBlankExclusions = listOf(37216L, 37218L, 37219L, 37220L)),

        WordEntity(id = 37218, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "baby shower", transliteration = "[ˈbeɪbi ˈʃaʊər]", translation = "вечеринка перед рождением ребёнка",
            definition = "A party before a baby is born — friends bring small gifts for the new parents.",
            definitionNative = "Вечеринка до рождения малыша — подруги дарят будущим родителям мелочи.",
            example = "Her best friends threw a lovely baby shower last Saturday afternoon.",
            exampleNative = "Подруги устроили милый baby shower в субботу днём.",
            pos = "noun", semanticGroup = "holidays_milestones", fillInBlankExclusions = listOf(37216L, 37217L, 37219L, 37220L, 37224L)),

        WordEntity(id = 37219, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "retirement party", transliteration = "[rɪˈtaɪrmənt ˈpɑrti]", translation = "проводы на пенсию",
            definition = "The office goodbye for someone leaving work for good — with cake and speeches.",
            definitionNative = "Офисное прощание с тем, кто уходит на покой — с тортом и речами.",
            example = "The whole company came to my dad's retirement party on Friday evening.",
            exampleNative = "В пятницу вечером на retirement party отца пришла вся компания.",
            pos = "noun", semanticGroup = "holidays_milestones", fillInBlankExclusions = listOf(37216L, 37217L, 37218L, 37220L)),

        WordEntity(id = 37220, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "housewarming", transliteration = "[ˈhaʊsˌwɔrmɪŋ]", translation = "новоселье",
            definition = "A friendly party in a brand-new home — guests bring plants, wine or kitchen things.",
            definitionNative = "Дружеский приём в только что купленном доме — приносят цветы, вино, кухню.",
            example = "We invited the whole street to our housewarming last Sunday afternoon.",
            exampleNative = "На housewarming мы позвали в воскресенье всю улицу.",
            pos = "noun", semanticGroup = "holidays_milestones", fillInBlankExclusions = listOf(37216L, 37217L, 37218L, 37219L, 37224L)),

        // ── holidays_traditions (5) — Традиционные обычаи и обряды ─────────

        WordEntity(id = 37221, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "salutation", transliteration = "[ˌsæljəˈteɪʃən]", translation = "приветственное слово",
            definition = "A warm spoken greeting at the start of a speech or letter to honour someone.",
            definitionNative = "Тёплое словесное приветствие в начале речи или письма в чью-то честь.",
            example = "Her grandfather gave a touching salutation at the wedding dinner.",
            exampleNative = "Дед произнёс трогательную salutation за свадебным ужином.",
            pos = "noun", semanticGroup = "holidays_traditions", fillInBlankExclusions = listOf(37222L, 37223L, 37224L, 37225L)),

        WordEntity(id = 37222, setId = 372, languagePair = "en-ru", rarity = "RARE",
            original = "pyrotechnics", transliteration = "[ˌpaɪrəˈtɛknɪks]", translation = "пиротехника",
            definition = "Loud colourful explosives set off at night for shows and big celebrations.",
            definitionNative = "Шумные цветные взрывы, что устраивают ночью для шоу и больших торжеств.",
            example = "We watched the pyrotechnics from the rooftop until almost midnight.",
            exampleNative = "Мы смотрели pyrotechnics с крыши почти до полуночи.",
            pos = "noun", semanticGroup = "holidays_traditions", fillInBlankExclusions = listOf(37221L, 37223L, 37224L, 37225L)),

        WordEntity(id = 37223, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "parade", transliteration = "[pəˈreɪd]", translation = "парад",
            definition = "A long line of people, bands and floats moving slowly through city streets.",
            definitionNative = "Длинная вереница людей, оркестров и платформ — медленно идёт по улицам.",
            example = "The Thanksgiving parade goes right past my aunt's apartment window.",
            exampleNative = "Parade на День благодарения идёт прямо мимо окон тёти.",
            pos = "noun", semanticGroup = "holidays_traditions", fillInBlankExclusions = listOf(37221L, 37222L, 37224L, 37225L)),

        WordEntity(id = 37224, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "family reunion", transliteration = "[ˈfæməli riˈjunjən]", translation = "семейное воссоединение",
            definition = "A big gathering of relatives — cousins, aunts and uncles seen once a year.",
            definitionNative = "Большое собрание родни — кузены, тёти и дяди видятся раз в год.",
            example = "Every August we host a family reunion at the lake house upstate.",
            exampleNative = "В каждом августе мы устраиваем family reunion в загородном доме.",
            pos = "noun", semanticGroup = "holidays_traditions",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37216L, 37218L, 37219L, 37220L, 37221L, 37222L, 37223L, 37225L)),

        WordEntity(id = 37225, setId = 372, languagePair = "en-ru", rarity = "EPIC",
            original = "white elephant gift", transliteration = "[waɪt ˈɛləfənt gɪft]", translation = "шуточный подарок (white elephant)",
            definition = "A funny or silly present for an office swap game — guests laugh and trade them.",
            definitionNative = "Забавный или нелепый подарок в офисной игре — гости смеются и меняются.",
            example = "I brought a singing fish as my white elephant gift this year.",
            exampleNative = "В этом году я принёс поющую рыбу как white elephant gift.",
            pos = "noun", semanticGroup = "holidays_traditions", fillInBlankExclusions = listOf(37221L, 37222L, 37223L, 37224L)),
    )
}
