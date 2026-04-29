package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Кино и сериалы (L3, RARE+EPIC).
 *
 * Set 397: «Кино и сериалы» — углублённый.
 *          Техники съёмки профи, нарративные приёмы, авторское кино, продвинутые
 *          жанры и язык кинокритики уровня B2-C1. Лексика рецензий, фестивальных
 *          обзоров и серьёзных статей о киноязыке.
 *
 * Тема — продолжение L1 (set 395) и L2 (set 396, создаётся параллельно).
 * L1 покрывает базовую лексику A1-A2 (flick, horror, fantasy, sci-fi, actress,
 * villain, series, rating, remake, dubbed). L2 — повседневные понятия B1.
 * L3 строго придерживается B2/C1 — терминология кинопроизводства и критики.
 *
 * Все 25 слов этого сета не пересекаются с уже существующими английскими
 * словами в базе (проверено grep'ом по `original = "..."`). Обойдены, в
 * частности: montage, cinematography, tracking shot, auteur, mise-en-scène,
 * chiaroscuro (set 245/239/Batch15/EntertainmentL5), foreshadowing, subplot,
 * denouement, foil, diegesis, fourth wall, in medias res, mockumentary,
 * antihero, fandom, binge-watch, finale, prequel, sequel, cliffhanger,
 * spoiler, framing — все они уже есть в других наборах.
 *
 * Распределение редкости: 18 RARE + 7 EPIC — два смежных уровня (B2 + C1).
 *
 * SemanticGroups (5 × 5):
 *   cinema_l3_techniques_pro    — jump cut, dolly shot, crane shot, deep focus, smash cut
 *   cinema_l3_narrative         — red herring, exposition, character arc, subtext, MacGuffin
 *   cinema_l3_industry_pro      — ensemble cast, indie, art-house, B-movie, biopic
 *   cinema_l3_genres_advanced   — neo-noir, found-footage, body horror, kitchen-sink drama, slow cinema
 *   cinema_l3_critique          — cinephile, panning, accolade, breakthrough role, critical darling
 *
 * Word IDs: setId × 100 + position (39701..39725).
 *
 * fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь (defaults в
 * WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно после wave;
 * если поставить их заранее, pipeline пропустит запись (известный баг).
 */
object WordDataEnglishCinemaL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 397,
            languagePair = "en-ru",
            orderIndex = 397,
            name = "Кино и сериалы",
            description = "Техники съёмки, нарратив, авторское кино и критика",
            topic = "Кино и сериалы",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 397 — Кино и сериалы: углублённый (L3, RARE+EPIC)            ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── cinema_l3_techniques_pro (5) ──────────────────────────────────

        WordEntity(id = 39701, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "jump cut", transliteration = "[ʤʌmp kʌt]", translation = "джамп-кат (резкий монтажный скачок)",
            definition = "An abrupt edit between two shots of the same scene that makes the action seem to jump.",
            definitionNative = "Резкий стык двух кадров одной сцены, при котором действие будто перескакивает.",
            example = "Godard's nervy jump cut shocked audiences who were used to invisible editing.",
            exampleNative = "Нервный jump cut Годара шокировал зрителей, привыкших к невидимому монтажу.",
            pos = "noun", semanticGroup = "cinema_l3_techniques_pro", fillInBlankExclusions = listOf(39702L, 39703L, 39704L, 39705L, 39717L)),

        WordEntity(id = 39702, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "dolly shot", transliteration = "[ˈdɑli ʃɑt]", translation = "проезд камеры на тележке",
            definition = "A shot in which the camera glides smoothly forward or back on a wheeled platform.",
            definitionNative = "Кадр, в котором камера плавно едет вперёд или назад на колёсной платформе.",
            example = "The slow dolly shot toward the dinner table built unbearable tension.",
            exampleNative = "Медленный dolly shot в сторону обеденного стола создавал невыносимое напряжение.",
            pos = "noun", semanticGroup = "cinema_l3_techniques_pro", fillInBlankExclusions = listOf(39701L, 39703L, 39704L, 39705L)),

        WordEntity(id = 39703, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "crane shot", transliteration = "[kreɪn ʃɑt]", translation = "съёмка с операторского крана",
            definition = "A shot taken from a long mechanical arm that swings the camera high above the action.",
            definitionNative = "Кадр, снятый с длинной механической стрелы, которая поднимает камеру высоко над действием.",
            example = "The film opens with a sweeping crane shot over the rooftops of Paris.",
            exampleNative = "Фильм открывается размашистым crane shot над крышами Парижа.",
            pos = "noun", semanticGroup = "cinema_l3_techniques_pro", fillInBlankExclusions = listOf(39701L, 39702L, 39704L, 39705L)),

        WordEntity(id = 39704, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "deep focus", transliteration = "[dip ˈfoʊkəs]", translation = "глубокая резкость",
            definition = "A way of shooting in which the foreground and the far background stay equally sharp.",
            definitionNative = "Способ съёмки, при котором передний и дальний планы одинаково резкие.",
            example = "Welles used deep focus so the audience could read every face in the room.",
            exampleNative = "Уэллс использовал deep focus, чтобы зритель мог разглядеть каждое лицо в комнате.",
            pos = "noun", semanticGroup = "cinema_l3_techniques_pro", fillInBlankExclusions = listOf(39701L, 39702L, 39703L, 39705L)),

        WordEntity(id = 39705, setId = 397, languagePair = "en-ru", rarity = "EPIC",
            original = "smash cut", transliteration = "[smæʃ kʌt]", translation = "резкий контрастный монтажный стык",
            definition = "A jarring edit that slams from one mood or scene straight into a very different one.",
            definitionNative = "Резкий монтажный стык, который рывком переключает с одного настроения или сцены на совсем другое.",
            example = "A tender lullaby ended in a smash cut to a roaring battlefield.",
            exampleNative = "Нежная колыбельная обрывалась через smash cut на ревущее поле боя.",
            pos = "noun", semanticGroup = "cinema_l3_techniques_pro", fillInBlankExclusions = listOf(39701L, 39702L, 39703L, 39704L)),

        // ── cinema_l3_narrative (5) ───────────────────────────────────────

        WordEntity(id = 39706, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "red herring", transliteration = "[rɛd ˈhɛrɪŋ]", translation = "отвлекающий ложный след в сюжете",
            definition = "A false clue that the writer plants to send the audience guessing in the wrong direction.",
            definitionNative = "Ложная подсказка, которую автор подбрасывает, чтобы зритель шёл по неверному следу.",
            example = "The mysterious neighbour turned out to be a clever red herring.",
            exampleNative = "Загадочный сосед оказался ловким red herring.",
            pos = "noun", semanticGroup = "cinema_l3_narrative", fillInBlankExclusions = listOf(39707L, 39708L, 39709L, 39710L)),

        WordEntity(id = 39707, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "exposition", transliteration = "[ˌɛkspəˈzɪʃən]", translation = "экспозиция (введение в сюжет)",
            definition = "The opening passages that explain who the characters are and how the world works.",
            definitionNative = "Начальные эпизоды, объясняющие, кто герои и как устроен их мир.",
            example = "The clumsy exposition forced two friends to recite each other's biographies.",
            exampleNative = "Неуклюжая exposition заставляла двух друзей пересказывать биографии друг друга.",
            pos = "noun", semanticGroup = "cinema_l3_narrative", fillInBlankExclusions = listOf(39706L, 39708L, 39709L, 39710L)),

        WordEntity(id = 39708, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "character arc", transliteration = "[ˈkɛrɪktər ɑrk]", translation = "арка персонажа",
            definition = "The path along which a hero's beliefs or behaviour change from start to finish.",
            definitionNative = "Путь, по которому убеждения или поведение героя меняются от начала истории к финалу.",
            example = "Her character arc takes a shy waitress to a fearless detective.",
            exampleNative = "Её character arc ведёт застенчивую официантку к бесстрашному детективу.",
            pos = "noun", semanticGroup = "cinema_l3_narrative", fillInBlankExclusions = listOf(39706L, 39707L, 39709L, 39710L, 39724L)),

        WordEntity(id = 39709, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "subtext", transliteration = "[ˈsʌbˌtɛkst]", translation = "подтекст",
            definition = "The unspoken meaning hiding under the lines a character actually says aloud.",
            definitionNative = "Невысказанный смысл, скрытый под репликами, которые персонаж произносит вслух.",
            example = "The polite dinner conversation was thick with romantic subtext.",
            exampleNative = "Вежливая беседа за ужином была насыщена романтическим subtext.",
            pos = "noun", semanticGroup = "cinema_l3_narrative", fillInBlankExclusions = listOf(39706L, 39707L, 39708L, 39710L)),

        WordEntity(id = 39710, setId = 397, languagePair = "en-ru", rarity = "EPIC",
            original = "MacGuffin", transliteration = "[məˈɡʌfɪn]", translation = "макгаффин (предмет-двигатель сюжета)",
            definition = "An object the heroes desperately chase, even though its real nature barely matters.",
            definitionNative = "Предмет, за которым герои отчаянно гонятся, хотя его настоящая суть почти не важна.",
            example = "The glowing briefcase is a classic Hitchcockian MacGuffin.",
            exampleNative = "Светящийся чемоданчик — классический хичкоковский MacGuffin.",
            pos = "noun", semanticGroup = "cinema_l3_narrative", fillInBlankExclusions = listOf(39706L, 39707L, 39708L, 39709L)),

        // ── cinema_l3_industry_pro (5) ────────────────────────────────────

        WordEntity(id = 39711, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "ensemble cast", transliteration = "[ɑnˈsɑmbəl kæst]", translation = "ансамблевый актёрский состав",
            definition = "A group of leading actors who share the screen instead of one star carrying the film.",
            definitionNative = "Группа ведущих актёров, которые делят экран поровну, вместо того чтобы фильм держался на одной звезде.",
            example = "The heist movie's ensemble cast gave every thief a memorable scene.",
            exampleNative = "ensemble cast в фильме об ограблении подарил каждому вору запоминающуюся сцену.",
            pos = "noun", semanticGroup = "cinema_l3_industry_pro", fillInBlankExclusions = listOf(39712L, 39713L, 39714L, 39715L)),

        WordEntity(id = 39712, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "indie", transliteration = "[ˈɪndi]", translation = "независимое кино / инди",
            definition = "A film made outside the big studios on a small budget and with creative freedom.",
            definitionNative = "Фильм, снятый вне больших студий, на маленький бюджет и с творческой свободой.",
            example = "Her quiet indie about two sisters won the festival's top award.",
            exampleNative = "Её тихое indie про двух сестёр получило главный приз фестиваля.",
            pos = "noun", semanticGroup = "cinema_l3_industry_pro", fillInBlankExclusions = listOf(39711L, 39713L, 39714L, 39715L, 39716L, 39719L)),

        WordEntity(id = 39713, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "art-house", transliteration = "[ɑrt haʊs]", translation = "арт-хаус (авторское кино)",
            definition = "Serious, experimental cinema aimed at thoughtful viewers rather than wide audiences.",
            definitionNative = "Серьёзное, экспериментальное кино, рассчитанное на вдумчивого зрителя, а не на массовую публику.",
            example = "The little art-house theatre downtown shows nothing but festival films.",
            exampleNative = "Маленький art-house в центре крутит только фестивальные фильмы.",
            pos = "noun", semanticGroup = "cinema_l3_industry_pro", fillInBlankExclusions = listOf(39711L, 39712L, 39714L, 39715L)),

        WordEntity(id = 39714, setId = 397, languagePair = "en-ru", rarity = "EPIC",
            original = "B-movie", transliteration = "[bi ˈmuvi]", translation = "малобюджетный фильм категории «Б»",
            definition = "A cheap, fast-made film once shown as the second feature on a double bill.",
            definitionNative = "Дешёвый, наскоро снятый фильм, который раньше показывали вторым на двойном сеансе.",
            example = "The director cut his teeth on a 1970s B-movie about killer ants.",
            exampleNative = "Режиссёр набил руку на B-movie семидесятых про муравьёв-убийц.",
            pos = "noun", semanticGroup = "cinema_l3_industry_pro", fillInBlankExclusions = listOf(39711L, 39712L, 39713L, 39715L, 39716L, 39718L)),

        WordEntity(id = 39715, setId = 397, languagePair = "en-ru", rarity = "EPIC",
            original = "biopic", transliteration = "[ˈbaɪoʊˌpɪk]", translation = "байопик (фильм-биография)",
            definition = "A dramatic film that tells the life story of a real, often famous person.",
            definitionNative = "Игровой фильм, рассказывающий историю жизни реального, часто известного человека.",
            example = "The biopic about the jazz pioneer earned three Oscar nominations.",
            exampleNative = "biopic о пионере джаза получил три номинации на «Оскар».",
            pos = "noun", semanticGroup = "cinema_l3_industry_pro", fillInBlankExclusions = listOf(39711L, 39712L, 39713L, 39714L, 39716L, 39719L)),

        // ── cinema_l3_genres_advanced (5) ─────────────────────────────────

        WordEntity(id = 39716, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "neo-noir", transliteration = "[ˌnioʊ ˈnwɑr]", translation = "нео-нуар",
            definition = "A modern film in the cynical, shadowy style of 1940s detective movies.",
            definitionNative = "Современный фильм в циничной, теневой манере детективов сороковых годов.",
            example = "The rainy LA neo-noir borrowed every trick from Chandler.",
            exampleNative = "Дождливый лос-анджелесский neo-noir заимствовал все приёмы у Чандлера.",
            pos = "noun", semanticGroup = "cinema_l3_genres_advanced", fillInBlankExclusions = listOf(39712L, 39713L, 39714L, 39718L, 39719L, 39720L)),

        WordEntity(id = 39717, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "found-footage", transliteration = "[faʊnd ˈfʊtəʤ]", translation = "псевдодокументальная съёмка от первого лица",
            definition = "A style that pretends the film is real recordings discovered after the events.",
            definitionNative = "Стиль, при котором фильм выдают за настоящие записи, найденные уже после событий.",
            example = "The found-footage horror was shot entirely on shaky home cameras.",
            exampleNative = "found-footage хоррор сняли целиком на трясущиеся домашние камеры.",
            pos = "adjective", semanticGroup = "cinema_l3_genres_advanced", fillInBlankExclusions = listOf(39712L, 39713L, 39714L)),

        WordEntity(id = 39718, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "body horror", transliteration = "[ˈbɑdi ˈhɔrər]", translation = "телесный хоррор",
            definition = "A horror genre built on disgusting changes happening to the human body.",
            definitionNative = "Жанр ужасов, построенный на отвратительных изменениях, происходящих с человеческим телом.",
            example = "Cronenberg practically invented modern body horror.",
            exampleNative = "Кроненберг практически изобрёл современный body horror.",
            pos = "noun", semanticGroup = "cinema_l3_genres_advanced", fillInBlankExclusions = listOf(39701L, 39712L, 39713L, 39714L, 39715L, 39716L, 39717L, 39719L, 39720L)),

        WordEntity(id = 39719, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "kitchen-sink drama", transliteration = "[ˈkɪʧən sɪŋk ˈdrɑmə]", translation = "бытовая социальная драма",
            definition = "A British style of drama showing the gritty daily life of working-class families.",
            definitionNative = "Британский тип драмы, показывающий грубую повседневную жизнь рабочих семей.",
            example = "The kitchen-sink drama unfolds entirely in a tiny council flat.",
            exampleNative = "kitchen-sink drama разворачивается целиком в крошечной муниципальной квартире.",
            pos = "noun", semanticGroup = "cinema_l3_genres_advanced", fillInBlankExclusions = listOf(39712L, 39713L, 39714L, 39715L, 39716L, 39718L, 39720L)),

        WordEntity(id = 39720, setId = 397, languagePair = "en-ru", rarity = "EPIC",
            original = "slow cinema", transliteration = "[sloʊ ˈsɪnəmə]", translation = "медленное кино",
            definition = "A patient style that lingers on long, quiet shots and asks the viewer to wait.",
            definitionNative = "Терпеливый стиль, который задерживается на длинных тихих кадрах и просит зрителя ждать.",
            example = "Tarr's slow cinema demands attention many viewers can't give it.",
            exampleNative = "slow cinema Тарра требует внимания, которое не каждый зритель готов отдать.",
            pos = "noun", semanticGroup = "cinema_l3_genres_advanced", fillInBlankExclusions = listOf(39712L, 39713L, 39714L, 39715L, 39716L, 39718L, 39719L)),

        // ── cinema_l3_critique (5) ────────────────────────────────────────

        WordEntity(id = 39721, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "cinephile", transliteration = "[ˈsɪnəfaɪl]", translation = "киноман",
            definition = "A person who loves cinema deeply and watches films with serious attention.",
            definitionNative = "Человек, глубоко влюблённый в кино и смотрящий фильмы с серьёзным вниманием.",
            example = "Every cinephile in town turned up for the Bergman retrospective.",
            exampleNative = "Каждый cinephile города пришёл на ретроспективу Бергмана.",
            pos = "noun", semanticGroup = "cinema_l3_critique", fillInBlankExclusions = listOf(39722L, 39723L, 39724L, 39725L)),

        WordEntity(id = 39722, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "panning", transliteration = "[ˈpænɪŋ]", translation = "разгромная критика",
            definition = "A harsh public dismissal of a film by reviewers who almost universally dislike it.",
            definitionNative = "Жёсткое публичное осуждение фильма критиками, которые почти все его не приняли.",
            example = "Despite the critics' panning, the film found a loyal cult audience.",
            exampleNative = "Несмотря на panning от критиков, фильм нашёл преданную культовую аудиторию.",
            pos = "noun", semanticGroup = "cinema_l3_critique", fillInBlankExclusions = listOf(39721L, 39723L, 39724L, 39725L)),

        WordEntity(id = 39723, setId = 397, languagePair = "en-ru", rarity = "RARE",
            original = "accolade", transliteration = "[ˈækəˌleɪd]", translation = "почётная награда / похвала",
            definition = "A high public honour or strong praise given for outstanding work.",
            definitionNative = "Высокая публичная награда или сильная похвала за выдающуюся работу.",
            example = "The lifetime achievement accolade brought the old director to tears.",
            exampleNative = "accolade за вклад в кино довела старого режиссёра до слёз.",
            pos = "noun", semanticGroup = "cinema_l3_critique", fillInBlankExclusions = listOf(39721L, 39722L, 39724L, 39725L)),

        WordEntity(id = 39724, setId = 397, languagePair = "en-ru", rarity = "EPIC",
            original = "breakthrough role", transliteration = "[ˈbreɪkˌθru roʊl]", translation = "прорывная роль",
            definition = "The performance that finally turns a little-known actor into a recognised name.",
            definitionNative = "Роль, которая наконец превращает малоизвестного актёра в узнаваемое имя.",
            example = "That gritty thriller became her undeniable breakthrough role.",
            exampleNative = "Тот жёсткий триллер стал её бесспорной breakthrough role.",
            pos = "noun", semanticGroup = "cinema_l3_critique", fillInBlankExclusions = listOf(39721L, 39722L, 39723L, 39725L)),

        WordEntity(id = 39725, setId = 397, languagePair = "en-ru", rarity = "EPIC",
            original = "critical darling", transliteration = "[ˈkrɪtɪkəl ˈdɑrlɪŋ]", translation = "любимец критиков",
            definition = "A film or actor that reviewers adore even when wider audiences stay away.",
            definitionNative = "Фильм или актёр, которого обожают критики, даже когда широкая публика остаётся равнодушной.",
            example = "The quiet drama was a critical darling but barely sold tickets.",
            exampleNative = "Тихая драма стала critical darling, но почти не собирала кассу.",
            pos = "noun", semanticGroup = "cinema_l3_critique", fillInBlankExclusions = listOf(39714L, 39715L, 39716L, 39719L, 39721L, 39722L, 39724L)),
    )
}
