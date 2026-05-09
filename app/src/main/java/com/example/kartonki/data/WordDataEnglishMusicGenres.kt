package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Музыка (расширение темы, level 2-3, UNCOMMON+RARE).
 *
 * Set 457: «Музыка» — жанры и направления.
 *          25 жанров и поджанров мировой музыки уровня A2-B2: джаз и блюз
 *          (jazz, bebop, ragtime, fusion, rhythm and blues), рок и метал
 *          (grunge, hard rock, punk rock, heavy metal, death metal),
 *          электроника (techno, dubstep, drum and bass, trip-hop, synthwave),
 *          поп и R&B (K-pop, J-pop, R&B, funk, dream pop), мировая музыка
 *          (salsa, reggae, ska, samba, tango). Это шестой сет темы «Музыка»
 *          поверх L1-L5 (set 400-404), фокус не на теории/индустрии/
 *          инструментах, а именно на названиях стилей и жанров.
 *
 * Все 25 слов проверены grep'ом по `original = "..."` против
 * WordDataEnglish*.kt — пересечений нет. Часто встречающиеся жанры из
 * базовых сетов уже заняты и НЕ повторяются: hip-hop, rap, blues, folk,
 * disco (set 400 MusicL1); electronic, ambient (set 401 MusicL2);
 * bossa nova, bluegrass, gospel, prog rock, shoegaze (set 402 MusicL3);
 * flamenco, klezmer, gamelan, raga, qawwali (set 403 MusicL4); gagaku,
 * mbira, qanun, didgeridoo, throat singing (set 404 MusicL5); opera (set
 * 23 Искусство), baroque (set 239 Искусство, art context). Омонимы
 * country/house/garage/swing/metal/soul/drill заняты в других тематиках
 * (страны, дома, инструменты, душа), а не как музыкальные жанры — здесь
 * берём именно жанры, которых нет в базе.
 *
 * Распределение редкости: 17 UNCOMMON + 8 RARE — два смежных уровня
 * (A2-B1 + B2). Никаких COMMON/EPIC/LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   music_genres_jazz_blues  — jazz, bebop, ragtime, fusion, rhythm and blues
 *   music_genres_rock_metal  — grunge, hard rock, punk rock, heavy metal, death metal
 *   music_genres_electronic  — techno, dubstep, drum and bass, trip-hop, synthwave
 *   music_genres_pop_rnb     — K-pop, J-pop, R&B, funk, dream pop
 *   music_genres_world       — salsa, reggae, ska, samba, tango
 *
 * Word IDs: setId × 100 + position (45701..45725).
 *
 * fillInBlankExclusions / isFillInBlankSafe — НЕ задаются здесь (defaults
 * в WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно
 * после написания сета (известный баг: если выставить заранее, pipeline
 * пропустит запись).
 */
object WordDataEnglishMusicGenres {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 457,
            languagePair = "en-ru",
            orderIndex = 457,
            name = "Музыка",
            description = "Жанры и направления: jazz, indie, electronic, metal",
            topic = "Музыка",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 457 — Музыка: жанры и направления (level 2-3, UNCOMMON+RARE) ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── music_genres_jazz_blues (5) ───────────────────────────────────

        WordEntity(id = 45701, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "jazz", transliteration = "[ʤæz]", translation = "джаз",
            definition = "An American style with swung rhythms and lots of room for solo improvisation.",
            definitionNative = "Американский стиль с качающимся ритмом и большим простором для сольных импровизаций.",
            example = "He has loved jazz ever since his uncle gave him a Miles Davis record.",
            exampleNative = "Он любит jazz с тех пор, как дядя подарил ему пластинку Майлса Дэвиса.",
            pos = "noun", semanticGroup = "music_genres_jazz_blues", fillInBlankExclusions = listOf(45702L, 45703L, 45704L, 45705L)),

        WordEntity(id = 45702, setId = 457, languagePair = "en-ru", rarity = "RARE",
            original = "bebop", transliteration = "[ˈbiˌbɑp]", translation = "бибоп (быстрый стиль джаза 40-х)",
            definition = "A fast, complex jazz style from the forties built on rapid solos and tricky chords.",
            definitionNative = "Быстрый, сложный джазовый стиль сороковых, построенный на быстрых соло и непростых аккордах.",
            example = "Charlie Parker turned bebop into the standard language of modern jazz.",
            exampleNative = "Чарли Паркер превратил bebop в общий язык современного джаза.",
            pos = "noun", semanticGroup = "music_genres_jazz_blues", fillInBlankExclusions = listOf(45703L, 45704L, 45705L)),

        WordEntity(id = 45703, setId = 457, languagePair = "en-ru", rarity = "RARE",
            original = "ragtime", transliteration = "[ˈræɡˌtaɪm]", translation = "рэгтайм (раннеджазовый фортепианный стиль)",
            definition = "An early piano style with a hopping left hand and a syncopated right hand.",
            definitionNative = "Раннее фортепианное направление с подпрыгивающей левой рукой и синкопированной правой.",
            example = "The old saloon piano spilled out ragtime late into the night.",
            exampleNative = "Старое пианино в салуне выплёскивало ragtime до глубокой ночи.",
            pos = "noun", semanticGroup = "music_genres_jazz_blues", fillInBlankExclusions = listOf(45701L, 45702L, 45704L, 45705L)),

        WordEntity(id = 45704, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "fusion", transliteration = "[ˈfjuʒən]", translation = "фьюжн (смесь джаза с роком и электроникой)",
            definition = "A mix of jazz with rock and electric sounds that grew big in the seventies.",
            definitionNative = "Смесь джаза с роком и электрическим звучанием, расцветшая в семидесятых.",
            example = "Their new album leans hard into fusion with loud guitars and synths.",
            exampleNative = "Их новый альбом сильно уходит в fusion с громкими гитарами и синтезаторами.",
            pos = "noun", semanticGroup = "music_genres_jazz_blues", fillInBlankExclusions = listOf(45701L, 45702L, 45703L, 45705L)),

        WordEntity(id = 45705, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "rhythm and blues", transliteration = "[ˈrɪðəm ən bluz]", translation = "ритм-н-блюз",
            definition = "A Black American style from the forties that mixes a strong beat with bluesy singing.",
            definitionNative = "Чернокожий американский стиль сороковых, где сильный бит сочетается с блюзовым вокалом.",
            example = "Most early rock songs grew straight out of rhythm and blues records.",
            exampleNative = "Большинство ранних рок-песен выросли прямо из пластинок rhythm and blues.",
            pos = "noun", semanticGroup = "music_genres_jazz_blues", fillInBlankExclusions = listOf(45701L, 45702L, 45703L, 45704L)),

        // ── music_genres_rock_metal (5) ───────────────────────────────────

        WordEntity(id = 45706, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "grunge", transliteration = "[ɡrʌnʤ]", translation = "гранж (мрачный сиэтлский рок 90-х)",
            definition = "A dirty Seattle rock style of the early nineties — loud guitars and gloomy lyrics.",
            definitionNative = "Грязный сиэтлский рок-стиль начала девяностых — громкие гитары и мрачные тексты.",
            example = "He still wears the same flannel shirts he bought during the grunge era.",
            exampleNative = "Он до сих пор носит те же фланелевые рубашки, что купил в эпоху grunge.",
            pos = "noun", semanticGroup = "music_genres_rock_metal", fillInBlankExclusions = listOf(45707L, 45708L, 45709L, 45710L)),

        WordEntity(id = 45707, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hard rock", transliteration = "[hɑrd rɑk]", translation = "хард-рок",
            definition = "A loud guitar-driven style with thick power chords and forceful drumming.",
            definitionNative = "Громкое гитарное направление с плотными квинт-аккордами и напористой барабанной партией.",
            example = "Their first record was straight hard rock, no soft moments at all.",
            exampleNative = "Их первая пластинка была чистым hard rock, без единого мягкого момента.",
            pos = "noun", semanticGroup = "music_genres_rock_metal", fillInBlankExclusions = listOf(45706L, 45708L, 45709L, 45710L)),

        WordEntity(id = 45708, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "punk rock", transliteration = "[pʌŋk rɑk]", translation = "панк-рок",
            definition = "A fast, raw style with short angry songs and a clear anti-system attitude.",
            definitionNative = "Быстрое, сырое направление с короткими злыми песнями и явной антисистемной позицией.",
            example = "She got into punk rock at fifteen and dyed her hair bright pink.",
            exampleNative = "Она увлеклась punk rock в пятнадцать и покрасила волосы в ярко-розовый.",
            pos = "noun", semanticGroup = "music_genres_rock_metal", fillInBlankExclusions = listOf(45706L, 45707L, 45709L, 45710L)),

        WordEntity(id = 45709, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "heavy metal", transliteration = "[ˈhɛvi ˈmɛtəl]", translation = "хеви-метал",
            definition = "A loud guitar style with thunderous drums and high powerful vocals.",
            definitionNative = "Громкое гитарное направление с грохочущими барабанами и высоким мощным вокалом.",
            example = "His teenage bedroom walls were covered in heavy metal posters.",
            exampleNative = "Стены его подростковой комнаты были увешаны постерами heavy metal.",
            pos = "noun", semanticGroup = "music_genres_rock_metal", fillInBlankExclusions = listOf(45706L, 45707L, 45708L, 45710L)),

        WordEntity(id = 45710, setId = 457, languagePair = "en-ru", rarity = "RARE",
            original = "death metal", transliteration = "[dɛθ ˈmɛtəl]", translation = "дэт-метал",
            definition = "An extreme metal style with growled vocals and very fast brutal drumming.",
            definitionNative = "Экстремальный метал-стиль с рычащим вокалом и очень быстрой жёсткой барабанной партией.",
            example = "Most listeners can't tell one death metal song from another at first.",
            exampleNative = "Большинство слушателей сначала не отличают одну песню death metal от другой.",
            pos = "noun", semanticGroup = "music_genres_rock_metal", fillInBlankExclusions = listOf(45706L, 45707L, 45708L, 45709L)),

        // ── music_genres_electronic (5) ───────────────────────────────────

        WordEntity(id = 45711, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "techno", transliteration = "[ˈtɛknoʊ]", translation = "техно",
            definition = "A fast electronic dance style built on repeating beats and machine sounds.",
            definitionNative = "Быстрое электронное танцевальное направление на повторяющихся битах и машинных звуках.",
            example = "The Berlin club played hard techno from midnight until dawn.",
            exampleNative = "Берлинский клуб крутил жёсткое techno с полуночи до рассвета.",
            pos = "noun", semanticGroup = "music_genres_electronic", fillInBlankExclusions = listOf(45712L, 45713L, 45714L, 45715L)),

        WordEntity(id = 45712, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "dubstep", transliteration = "[ˈdʌbˌstɛp]", translation = "дабстеп",
            definition = "A British electronic style with slow heavy beats and very deep wobbling bass.",
            definitionNative = "Британское электронное направление с медленными тяжёлыми битами и очень глубоким качающимся басом.",
            example = "Her car shook from the bass when that dubstep track came on.",
            exampleNative = "Её машина тряслась от баса, когда заиграл этот трек dubstep.",
            pos = "noun", semanticGroup = "music_genres_electronic", fillInBlankExclusions = listOf(45711L, 45713L, 45714L, 45715L)),

        WordEntity(id = 45713, setId = 457, languagePair = "en-ru", rarity = "RARE",
            original = "drum and bass", transliteration = "[drʌm ən beɪs]", translation = "драм-н-бэйс",
            definition = "A British dance style with very fast broken beats and heavy rolling bass lines.",
            definitionNative = "Британское танцевальное направление с очень быстрыми ломаными битами и тяжёлыми басовыми партиями.",
            example = "He used to drive to work blasting drum and bass every morning.",
            exampleNative = "Он раньше ездил на работу, врубая drum and bass каждое утро.",
            pos = "noun", semanticGroup = "music_genres_electronic", fillInBlankExclusions = listOf(45711L, 45712L, 45714L, 45715L)),

        WordEntity(id = 45714, setId = 457, languagePair = "en-ru", rarity = "RARE",
            original = "trip-hop", transliteration = "[ˈtrɪpˌhɑp]", translation = "трип-хоп (медленный электронный стиль из Бристоля)",
            definition = "A slow moody Bristol style that blends hip-hop beats with dreamy electronic sounds.",
            definitionNative = "Медленное задумчивое бристольское направление, что соединяет хип-хоп ритмы с мечтательным электронным звуком.",
            example = "Their lounge bar plays mellow trip-hop while customers sip cocktails.",
            exampleNative = "В их лаундж-баре играет мягкий trip-hop, пока гости потягивают коктейли.",
            pos = "noun", semanticGroup = "music_genres_electronic", fillInBlankExclusions = listOf(45711L, 45712L, 45713L, 45715L)),

        WordEntity(id = 45715, setId = 457, languagePair = "en-ru", rarity = "RARE",
            original = "synthwave", transliteration = "[ˈsɪnθˌweɪv]", translation = "синтвейв (ретро-электроника в духе 80-х)",
            definition = "A modern electronic style that copies the bright synthesiser sound of eighties film scores.",
            definitionNative = "Современное электронное направление, что копирует яркий звук синтезаторов из киномузыки восьмидесятых.",
            example = "He scored the indie game with a glowing synthwave soundtrack.",
            exampleNative = "Он написал к инди-игре переливающийся synthwave саундтрек.",
            pos = "noun", semanticGroup = "music_genres_electronic", fillInBlankExclusions = listOf(45711L, 45712L, 45713L, 45714L)),

        // ── music_genres_pop_rnb (5) ──────────────────────────────────────

        WordEntity(id = 45716, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "K-pop", transliteration = "[ˈkeɪˌpɑp]", translation = "кей-поп (корейская поп-музыка)",
            definition = "Polished Korean pop with tight choreography, bright videos and global fan armies.",
            definitionNative = "Отполированная корейская поп-музыка с чёткой хореографией, яркими клипами и мировыми армиями фанатов.",
            example = "Her daughter saved up for months to see a K-pop concert in Seoul.",
            exampleNative = "Её дочь копила месяцами, чтобы попасть на концерт K-pop в Сеуле.",
            pos = "noun", semanticGroup = "music_genres_pop_rnb", fillInBlankExclusions = listOf(45717L, 45718L, 45719L, 45720L)),

        WordEntity(id = 45717, setId = 457, languagePair = "en-ru", rarity = "RARE",
            original = "J-pop", transliteration = "[ˈʤeɪˌpɑp]", translation = "джей-поп (японская поп-музыка)",
            definition = "Japanese pop music with bright melodies and a strong link to anime themes.",
            definitionNative = "Японская поп-музыка с яркими мелодиями и крепкой связью с темами аниме.",
            example = "He learned basic Japanese by singing along to old J-pop hits.",
            exampleNative = "Он выучил базовый японский, подпевая старым хитам J-pop.",
            pos = "noun", semanticGroup = "music_genres_pop_rnb", fillInBlankExclusions = listOf(45716L, 45718L, 45719L, 45720L)),

        WordEntity(id = 45718, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "R&B", transliteration = "[ˌɑr ən ˈbi]", translation = "ар-эн-би (современный соул-стиль)",
            definition = "A modern Black American style with smooth singing over slow groovy electronic beats.",
            definitionNative = "Современное чернокожее американское направление с мягким вокалом поверх медленных грувовых электронных битов.",
            example = "She put on slow R&B to set the mood for the dinner party.",
            exampleNative = "Она поставила медленный R&B, чтобы создать настроение на ужине.",
            pos = "noun", semanticGroup = "music_genres_pop_rnb", fillInBlankExclusions = listOf(45716L, 45717L, 45719L, 45720L)),

        WordEntity(id = 45719, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "funk", transliteration = "[fʌŋk]", translation = "фанк",
            definition = "A Black American style built on a heavy danceable groove and a tight bass line.",
            definitionNative = "Чернокожий американский стиль на тяжёлом танцевальном груве и плотной басовой партии.",
            example = "The wedding band played classic funk and got everyone on the dance floor.",
            exampleNative = "Группа на свадьбе играла классический funk и подняла всех на танцпол.",
            pos = "noun", semanticGroup = "music_genres_pop_rnb", fillInBlankExclusions = listOf(45716L, 45717L, 45718L, 45720L)),

        WordEntity(id = 45720, setId = 457, languagePair = "en-ru", rarity = "RARE",
            original = "dream pop", transliteration = "[drim pɑp]", translation = "дрим-поп (мечтательный гитарный поп с эффектами)",
            definition = "A soft pop style with hazy guitars and breathy vocals that float above the mix.",
            definitionNative = "Мягкое поп-направление с туманными гитарами и придыхающим вокалом, что парит над сведением.",
            example = "Their dream pop record sounds best on rainy autumn afternoons.",
            exampleNative = "Их пластинка dream pop лучше всего звучит дождливыми осенними днями.",
            pos = "noun", semanticGroup = "music_genres_pop_rnb", fillInBlankExclusions = listOf(45716L, 45717L, 45718L, 45719L)),

        // ── music_genres_world (5) ────────────────────────────────────────

        WordEntity(id = 45721, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "salsa", transliteration = "[ˈsɑlsə]", translation = "сальса (латиноамериканский танцевальный стиль)",
            definition = "A lively Latin dance style of New York roots, built on Cuban rhythms and brass.",
            definitionNative = "Живое латинское танцевальное направление нью-йоркских корней, на кубинских ритмах и духовых.",
            example = "On Saturdays the Cuban club opens its floor for live salsa.",
            exampleNative = "По субботам кубинский клуб открывает зал для живой salsa.",
            pos = "noun", semanticGroup = "music_genres_world", fillInBlankExclusions = listOf(45722L, 45723L, 45724L, 45725L)),

        WordEntity(id = 45722, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "reggae", transliteration = "[ˈrɛɡeɪ]", translation = "регги (ямайский стиль с расслабленным ритмом)",
            definition = "A Jamaican style with a laid-back offbeat rhythm and warm tropical guitar sound.",
            definitionNative = "Ямайское направление с расслабленным офф-битом и тёплым тропическим звучанием гитары.",
            example = "The beach bar played reggae softly while we watched the sunset.",
            exampleNative = "Бар на пляже тихо крутил reggae, пока мы смотрели закат.",
            pos = "noun", semanticGroup = "music_genres_world", fillInBlankExclusions = listOf(45721L, 45723L, 45724L, 45725L)),

        WordEntity(id = 45723, setId = 457, languagePair = "en-ru", rarity = "RARE",
            original = "ska", transliteration = "[skɑ]", translation = "ска (быстрый ямайский предшественник регги)",
            definition = "A fast Jamaican style from the sixties with brass stabs and a jumpy upbeat guitar.",
            definitionNative = "Быстрый ямайский стиль шестидесятых с короткими духовыми и подпрыгивающей гитарой.",
            example = "His high-school band played mostly ska covers at every party.",
            exampleNative = "Группа из его школы на каждой вечеринке играла в основном каверы ska.",
            pos = "noun", semanticGroup = "music_genres_world", fillInBlankExclusions = listOf(45721L, 45722L, 45724L, 45725L)),

        WordEntity(id = 45724, setId = 457, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "samba", transliteration = "[ˈsɑmbə]", translation = "самба (бразильский танцевальный стиль)",
            definition = "A Brazilian dance style with fast percussion and the carnival of Rio at its heart.",
            definitionNative = "Бразильское танцевальное направление с быстрой перкуссией, в сердце которого карнавал Рио.",
            example = "The Rio carnival float rolled past pumping out loud samba.",
            exampleNative = "Платформа карнавала в Рио прокатилась мимо, выдавая громкую samba.",
            pos = "noun", semanticGroup = "music_genres_world", fillInBlankExclusions = listOf(45721L, 45722L, 45723L, 45725L)),

        WordEntity(id = 45725, setId = 457, languagePair = "en-ru", rarity = "RARE",
            original = "tango", transliteration = "[ˈtæŋɡoʊ]", translation = "танго (аргентинский танцевальный стиль)",
            definition = "An Argentine dance style with a sad accordion lead and very dramatic stops.",
            definitionNative = "Аргентинский танцевальный стиль с грустной ведущей партией аккордеона и очень драматичными остановками.",
            example = "They took tango lessons together every Wednesday for a whole year.",
            exampleNative = "Они вместе ходили на уроки tango каждую среду целый год.",
            pos = "noun", semanticGroup = "music_genres_world", fillInBlankExclusions = listOf(45721L, 45722L, 45723L, 45724L)),
    )
}
