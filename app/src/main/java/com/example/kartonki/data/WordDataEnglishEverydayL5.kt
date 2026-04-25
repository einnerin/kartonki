package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Повседневная жизнь (level 5, носитель языка).
 *
 * Set 329: «Повседневная жизнь: носитель языка» — архаичная и поэтическая
 * лексика повседневности: устаревшие глаголы, литературные прилагательные,
 * редкие заимствованные концепции и архаизмы (C2+).
 *
 * Распределение редкости: 22 LEGENDARY + 3 EPIC — два смежных уровня шкалы.
 *
 * Дополняет уже существующие сеты темы «Повседневная жизнь»:
 *   - Set 25  (WordDataEnglish.kt)         — L2 UNCOMMON (привычки, расписание).
 *   - Set 256 (WordDataEnglishBatch5.kt)   — L2 COMMON/UNCOMMON (распорядок дня).
 *   - Set 265 (WordDataEnglishBatch8.kt)   — L1 COMMON/UNCOMMON (месяцы, сезоны, погода).
 *   - Set 327 (WordDataEnglishEverydayL3.kt) — L3 UNCOMMON/RARE (тонкая бытовая лексика).
 *   - Set 328 (параллельно) — L4 RARE/EPIC (более «земная» C1-лексика быта).
 *
 * Слова setId=329 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   everyday_archaic_wandering — gallivant, perambulate, peregrinate, wend, meander
 *   everyday_archaic_repose    — repose, slumber, drowse, reverie, torpor
 *   everyday_archaic_moods     — languid, listless, rueful, melancholic, dour
 *   everyday_borrowed_concepts — ennui, weltschmerz, schadenfreude, sangfroid, savoir-faire
 *   everyday_archaic_quirks    — cantankerous, doddery, dotty, twee, finicky
 *
 * Word IDs: 32901..32925 (setId × 100 + position).
 */
object WordDataEnglishEverydayL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 329, name = "Повседневная жизнь",
            description = "Архаичная и поэтическая лексика повседневности: устаревшие слова, идиомы носителя, литературные обороты",
            languagePair = "en-ru",
            topic = "Повседневная жизнь", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── everyday_archaic_wandering (5) ────────────────────────────────

        WordEntity(id = 32901, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gallivant", transliteration = "[ˈɡæləvænt]", translation = "шляться (праздно, ради развлечений)",
            definition = "To go around having fun in many places — without any serious purpose.",
            definitionNative = "Бродить по разным местам ради удовольствия — без всякой серьёзной цели.",
            example = "She'd rather gallivant around Europe than settle down at home.",
            exampleNative = "Она лучше будет gallivant по Европе, чем осядет дома.",
            pos = "verb", semanticGroup = "everyday_archaic_wandering", fillInBlankExclusions = listOf(32902L, 32903L, 32904L, 32905L)),

        WordEntity(id = 32902, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "perambulate", transliteration = "[pəˈræmbjəleɪt]", translation = "прогуливаться (важно, степенно)",
            definition = "To walk about slowly and with dignity — like a gentleman in a park.",
            definitionNative = "Расхаживать неспешно и с достоинством — как джентльмен в парке.",
            example = "The old don would perambulate the cloister every afternoon.",
            exampleNative = "Старик-дон любил perambulate по двору колледжа каждый день.",
            pos = "verb", semanticGroup = "everyday_archaic_wandering", fillInBlankExclusions = listOf(32901L, 32903L, 32904L, 32905L)),

        WordEntity(id = 32903, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "peregrinate", transliteration = "[ˈpɛrəɡrəneɪt]", translation = "странствовать (по дальним краям)",
            definition = "To travel from place to place — usually far and for a long time.",
            definitionNative = "Путешествовать из края в край — обычно далеко и долго.",
            example = "He hoped to peregrinate through Persia after finishing his studies.",
            exampleNative = "После учёбы он мечтал peregrinate по Персии целое лето.",
            pos = "verb", semanticGroup = "everyday_archaic_wandering", fillInBlankExclusions = listOf(32901L, 32902L, 32904L, 32905L)),

        WordEntity(id = 32904, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "wend", transliteration = "[wɛnd]", translation = "держать путь, направляться (старин.)",
            definition = "To go on your way slowly — old word for moving toward a place.",
            definitionNative = "Двигаться к цели не спеша — старинное слово для пути куда-то.",
            example = "We must wend our way home before the storm reaches the village.",
            exampleNative = "Надо wend домой, пока буря не дошла до деревни.",
            pos = "verb", semanticGroup = "everyday_archaic_wandering", fillInBlankExclusions = listOf(32901L, 32902L, 32903L, 32905L)),

        WordEntity(id = 32905, setId = 329, languagePair = "en-ru", rarity = "EPIC",
            original = "meander", transliteration = "[miˈændər]", translation = "блуждать, петлять (без цели)",
            definition = "To move along a winding path — slowly and without any clear plan.",
            definitionNative = "Двигаться по извилистой тропе — неторопливо и без чёткого плана.",
            example = "We let the kids meander through the old market for an hour.",
            exampleNative = "Мы дали детям meander по старому рынку целый час.",
            pos = "verb", semanticGroup = "everyday_archaic_wandering", fillInBlankExclusions = listOf(32901L, 32902L, 32903L, 32904L)),

        // ── everyday_archaic_repose (5) ───────────────────────────────────

        WordEntity(id = 32906, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "repose", transliteration = "[rɪˈpoʊz]", translation = "покой, отдых (поэтич.)",
            definition = "A calm state of resting body and mind — like quiet evening hours.",
            definitionNative = "Тихое состояние, когда тело и ум расслаблены — как вечерние часы.",
            example = "The cat found her repose in a sunlit corner of the porch.",
            exampleNative = "Кошка нашла свой repose в солнечном уголке веранды.",
            pos = "noun", semanticGroup = "everyday_archaic_repose", fillInBlankExclusions = listOf(32907L, 32909L, 32910L)),

        WordEntity(id = 32907, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "slumber", transliteration = "[ˈslʌmbər]", translation = "дремота, безмятежный сон",
            definition = "A peaceful, gentle sleep — the kind babies have under a warm blanket.",
            definitionNative = "Мирный, нежный сон — какой бывает у младенцев под тёплым одеялом.",
            example = "A deep slumber fell on the village after the long harvest.",
            exampleNative = "Глубокий slumber окутал деревню после долгой жатвы.",
            pos = "noun", semanticGroup = "everyday_archaic_repose", fillInBlankExclusions = listOf(32906L, 32909L, 32910L, 32916L, 32917L)),

        WordEntity(id = 32908, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "drowse", transliteration = "[draʊz]", translation = "клевать носом, пребывать в полусне",
            definition = "To sit half asleep — eyes drifting closed, head nodding gently.",
            definitionNative = "Сидеть в полусне — глаза слипаются, голова мягко клонится вниз.",
            example = "Granny would drowse by the fire after her afternoon tea.",
            exampleNative = "Бабушка любила drowse у камина после послеобеденного чая.",
            pos = "verb", semanticGroup = "everyday_archaic_repose"),

        WordEntity(id = 32909, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "reverie", transliteration = "[ˈrɛvəri]", translation = "мечтание, задумчивость",
            definition = "A pleasant daydream — your mind drifts off and forgets the world.",
            definitionNative = "Приятный поток грёз — мысли уплывают и забывают окружающий мир.",
            example = "A loud horn pulled him from his reverie at the bus stop.",
            exampleNative = "Громкий гудок вырвал его из reverie на автобусной остановке.",
            pos = "noun", semanticGroup = "everyday_archaic_repose", fillInBlankExclusions = listOf(32906L, 32907L, 32910L, 32916L, 32917L)),

        WordEntity(id = 32910, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "torpor", transliteration = "[ˈtɔːrpər]", translation = "оцепенение, апатичная сонливость",
            definition = "A heavy, dreamy stillness — body and mind too sluggish to stir.",
            definitionNative = "Тяжёлая, дремотная неподвижность — тело и ум слишком инертны.",
            example = "Summer heat brought a sweet torpor over the whole house.",
            exampleNative = "Летний зной навёл сладкий torpor на весь дом.",
            pos = "noun", semanticGroup = "everyday_archaic_repose", fillInBlankExclusions = listOf(32906L, 32907L, 32909L, 32916L)),

        // ── everyday_archaic_moods (5) ────────────────────────────────────

        WordEntity(id = 32911, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "languid", transliteration = "[ˈlæŋɡwɪd]", translation = "томный, нега-вялый",
            definition = "Soft and slow — moving without energy, like in a long warm afternoon.",
            definitionNative = "Мягкий и неторопливый — без энергии, как в долгий тёплый день.",
            example = "She gave a languid wave from the hammock under the trees.",
            exampleNative = "Она вяло, languid махнула рукой из гамака под деревьями.",
            pos = "adjective", semanticGroup = "everyday_archaic_moods", fillInBlankExclusions = listOf(32912L, 32913L, 32914L, 32915L, 32922L, 32923L)),

        WordEntity(id = 32912, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "listless", transliteration = "[ˈlɪstləs]", translation = "апатичный, безучастный",
            definition = "Without interest or energy — nothing seems worth doing today.",
            definitionNative = "Без интереса и сил — ничто не кажется достойным внимания.",
            example = "The boy seemed listless after a week of grey rainy weather.",
            exampleNative = "Мальчик выглядел listless после недели серых дождей.",
            pos = "adjective", semanticGroup = "everyday_archaic_moods", fillInBlankExclusions = listOf(32911L, 32913L, 32914L, 32915L, 32921L, 32923L)),

        WordEntity(id = 32913, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "rueful", transliteration = "[ˈruːfəl]", translation = "сокрушённый, грустно-сожалеющий",
            definition = "Showing soft regret — half-smiling at one's own mistake or loss.",
            definitionNative = "С виду полный мягкого сожаления — улыбается своему промаху или беде.",
            example = "He gave a rueful chuckle when his cake collapsed in the oven.",
            exampleNative = "Он издал rueful смешок, когда его торт осел прямо в духовке.",
            pos = "adjective", semanticGroup = "everyday_archaic_moods", fillInBlankExclusions = listOf(32911L, 32912L, 32914L, 32915L, 32921L, 32922L, 32923L, 32924L)),

        WordEntity(id = 32914, setId = 329, languagePair = "en-ru", rarity = "EPIC",
            original = "melancholic", transliteration = "[mɛlənˈkɒlɪk]", translation = "меланхоличный (грустно-задумчивый)",
            definition = "Filled with a soft, deep sadness — like an autumn evening alone.",
            definitionNative = "Наполненный мягкой, глубокой печалью — как осенний вечер в одиночестве.",
            example = "He has a melancholic streak that only old jazz seems to soothe.",
            exampleNative = "В нём есть melancholic нотка — её смягчает лишь старый джаз.",
            pos = "adjective", semanticGroup = "everyday_archaic_moods", fillInBlankExclusions = listOf(32911L, 32912L, 32913L, 32915L, 32921L, 32923L, 32924L, 32925L)),

        WordEntity(id = 32915, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dour", transliteration = "[dʊr]", translation = "хмурый, суровый (молчаливо)",
            definition = "Stern and silent — face set hard, no warmth in voice or look.",
            definitionNative = "Мрачный и молчаливый — лицо каменное, без тепла в голосе и взгляде.",
            example = "The dour gatekeeper barely nodded as we walked into the courtyard.",
            exampleNative = "Dour привратник едва кивнул, когда мы вошли во двор.",
            pos = "adjective", semanticGroup = "everyday_archaic_moods", fillInBlankExclusions = listOf(32911L, 32912L, 32913L, 32914L, 32921L, 32922L, 32923L, 32924L, 32925L)),

        // ── everyday_borrowed_concepts (5) ────────────────────────────────

        WordEntity(id = 32916, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ennui", transliteration = "[ɑnˈwiː]", translation = "томительная скука (бытийная)",
            definition = "A deep, weary boredom with everything — life feels grey and pointless.",
            definitionNative = "Глубокая, усталая пресыщенность всем — жизнь кажется серой и пустой.",
            example = "A heavy ennui settled on the family during the long winter months.",
            exampleNative = "Тяжёлое ennui поселилось в семье в долгие зимние месяцы.",
            pos = "noun", semanticGroup = "everyday_borrowed_concepts", fillInBlankExclusions = listOf(32906L, 32907L, 32909L, 32910L, 32917L, 32918L, 32919L, 32920L)),

        WordEntity(id = 32917, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "weltschmerz", transliteration = "[ˈvɛltʃmɛrts]", translation = "мировая скорбь (тоска по идеалу)",
            definition = "A sorrow at how the world falls short of what one dreamed it could be.",
            definitionNative = "Печаль от того, как мир не соответствует мечтам о нём.",
            example = "The young poet's letters were soaked in weltschmerz and longing.",
            exampleNative = "Письма юного поэта были пропитаны weltschmerz и тоской.",
            pos = "noun", semanticGroup = "everyday_borrowed_concepts", fillInBlankExclusions = listOf(32909L, 32916L, 32918L, 32919L, 32920L)),

        WordEntity(id = 32918, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "schadenfreude", transliteration = "[ˈʃɑdənfrɔɪdə]", translation = "злорадство (тихая радость беде другого)",
            definition = "A quiet pleasure at another person's small misfortune — half-hidden, half-shameful.",
            definitionNative = "Тихая радость от чужой беды — наполовину скрытая, наполовину стыдная.",
            example = "I felt a flicker of schadenfreude when his loud car broke down.",
            exampleNative = "Я ощутил вспышку schadenfreude, когда его шумная машина заглохла.",
            pos = "noun", semanticGroup = "everyday_borrowed_concepts", fillInBlankExclusions = listOf(32916L, 32917L, 32919L, 32920L)),

        WordEntity(id = 32919, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sangfroid", transliteration = "[sɑŋˈfrwɑ]", translation = "хладнокровие (изящное)",
            definition = "Cool steadiness in danger — calm hands and a calm voice when others panic.",
            definitionNative = "Спокойная выдержка перед опасностью — твёрдые руки, ровный голос.",
            example = "He answered the rude reporter with admirable sangfroid.",
            exampleNative = "Он ответил грубому журналисту с изумительным sangfroid.",
            pos = "noun", semanticGroup = "everyday_borrowed_concepts", fillInBlankExclusions = listOf(32906L, 32916L, 32917L, 32918L, 32920L)),

        WordEntity(id = 32920, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "savoir-faire", transliteration = "[ˌsævwɑrˈfɛr]", translation = "светская сноровка, умение себя держать",
            definition = "An easy skill at handling tricky social moments without any awkwardness.",
            definitionNative = "Лёгкое умение справляться со сложными светскими моментами без неловкости.",
            example = "Her savoir-faire saved the dinner when two guests argued at the table.",
            exampleNative = "Её savoir-faire спас ужин, когда двое гостей поссорились за столом.",
            pos = "noun", semanticGroup = "everyday_borrowed_concepts", fillInBlankExclusions = listOf(32916L, 32917L, 32918L, 32919L)),

        // ── everyday_archaic_quirks (5) ───────────────────────────────────

        WordEntity(id = 32921, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cantankerous", transliteration = "[kænˈtæŋkərəs]", translation = "сварливый, склочный",
            definition = "Always ready to argue and complain — hard to please and quick to scold.",
            definitionNative = "Всегда готовый спорить и жаловаться — трудно угодить, легко получить выговор.",
            example = "The cantankerous old man chased the kids off his lawn every morning.",
            exampleNative = "Cantankerous старик каждое утро гонял детей со своей лужайки.",
            pos = "adjective", semanticGroup = "everyday_archaic_quirks", fillInBlankExclusions = listOf(32913L, 32915L, 32922L, 32923L, 32924L, 32925L)),

        WordEntity(id = 32922, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "doddery", transliteration = "[ˈdɒdəri]", translation = "немощный, дряхлый (от старости)",
            definition = "Weak and shaky from old age — slow on the feet, hands not quite steady.",
            definitionNative = "Слабый и нетвёрдый от старости — медленный, руки уже не так послушны.",
            example = "A doddery uncle shuffled in with a cane and a wide smile.",
            exampleNative = "Doddery дядюшка вошёл, опираясь на трость, с широкой улыбкой.",
            pos = "adjective", semanticGroup = "everyday_archaic_quirks", fillInBlankExclusions = listOf(32911L, 32913L, 32914L, 32921L, 32923L, 32924L, 32925L)),

        WordEntity(id = 32923, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dotty", transliteration = "[ˈdɒti]", translation = "чудаковатый, слегка не в себе",
            definition = "A bit cracked in the head — harmless, fond of odd ideas and habits.",
            definitionNative = "Слегка помешанный, безобидный — с чудными идеями и привычками.",
            example = "Aunt Mabel went a little dotty after her husband passed away.",
            exampleNative = "Тётушка Мэйбл стала немного dotty после смерти мужа.",
            pos = "adjective", semanticGroup = "everyday_archaic_quirks", fillInBlankExclusions = listOf(32911L, 32912L, 32913L, 32914L, 32915L, 32921L, 32922L, 32924L, 32925L)),

        WordEntity(id = 32924, setId = 329, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "twee", transliteration = "[twiː]", translation = "приторно-милый, слащавый",
            definition = "Cute in a way that tries too hard — pink ribbons and tiny porcelain cats.",
            definitionNative = "Милый чересчур — розовые ленточки и фарфоровые котята всюду.",
            example = "The cafe was a bit twee for me — bunting on every wall.",
            exampleNative = "Кафе показалось мне слишком twee — флажки на каждой стене.",
            pos = "adjective", semanticGroup = "everyday_archaic_quirks", fillInBlankExclusions = listOf(32921L, 32922L, 32923L, 32925L)),

        WordEntity(id = 32925, setId = 329, languagePair = "en-ru", rarity = "EPIC",
            original = "finicky", transliteration = "[ˈfɪnɪki]", translation = "привередливый, разборчивый",
            definition = "Hard to please about small details — even the spoon must be just right.",
            definitionNative = "Трудно угодить в мелочах — даже ложка должна быть строго своя.",
            example = "My nephew is so finicky about food that only plain rice will do.",
            exampleNative = "Племянник так finicky в еде, что согласен лишь на простой рис.",
            pos = "adjective", semanticGroup = "everyday_archaic_quirks", fillInBlankExclusions = listOf(32912L, 32915L, 32921L, 32922L, 32923L, 32924L)),
    )
}
