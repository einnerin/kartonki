package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Развлечения и досуг (level 4, профессиональный).
 *
 * Set 358: «Развлечения и досуг» — профессиональный (L4, EPIC + LEGENDARY):
 *          производство, фестивали, gaming-индустрия, streaming, креативные индустрии.
 *
 * Слова не повторяются с Entertainment L1L2L3 (351, 352, 353): заменены
 * speedrun → microtransaction, indie game → battle pass, binge-watch → simulcast,
 * чтобы исключить пересечения с уже существующими сетами темы.
 *
 * Cross-topic совпадения (допустимо — разные темы):
 *   - premiere (cinema, set 206) и foley (cinema, set 245) встречаются как
 *     отдельные слова; здесь идут многословные термины «world premiere» и
 *     «foley artist», что само по себе уникально и относится к теме
 *     «Развлечения», а не «Культура и искусство».
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY (спред 1, на границе L4-L5).
 *
 * SemanticGroups (5 × 5):
 *   entertainment_production   — production company, executive producer, location scouting, post-production, sound design
 *   entertainment_festivals    — film festival, world premiere, official selection, retrospective, audience award
 *   entertainment_gaming       — esports tournament, battle pass, microtransaction, downloadable content, season pass
 *   entertainment_streaming    — streaming platform, original series, watch party, simulcast, viewership rating
 *   entertainment_creative     — script doctor, location manager, casting director, foley artist, intimacy coordinator
 *
 * Word IDs: setId × 100 + position (35801..35825).
 *
 * isFillInBlankSafe = false — все слова многословные термины, в FILL_IN_BLANK
 * пропуск создаётся механической заменой и для двусловных терминов «protekает»
 * либо неоднозначен. Pipeline позже подберёт exclusions и при необходимости
 * флипнет флаг в Phase 3.
 */
object WordDataEnglishEntertainmentL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 358, languagePair = "en-ru", orderIndex = 358,
            name = "Развлечения и досуг",
            description = "Углублённый: производство, фестивали, gaming-индустрия, streaming, креативные индустрии",
            topic = "Развлечения и досуг", level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 358 — Развлечения и досуг: профессиональный (L4, EPIC+LEG)   ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── entertainment_production (5) ──────────────────────────────────

        WordEntity(id = 35801, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "production company", transliteration = "[prəˈdʌkʃən ˈkʌmpəni]",
            translation = "продюсерская / производственная компания",
            definition = "A firm that funds, organises and oversees the making of films or shows.",
            definitionNative = "Фирма, которая финансирует, организует и контролирует съёмки фильмов или сериалов.",
            example = "Her small production company shot the documentary in just six weeks.",
            exampleNative = "Её небольшая production company сняла документалку всего за шесть недель.",
            pos = "noun", semanticGroup = "entertainment_production", fillInBlankExclusions = listOf(35802L, 35803L, 35804L, 35805L)),

        WordEntity(id = 35802, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "executive producer", transliteration = "[ɪɡˈzɛkjətɪv prəˈdusər]",
            translation = "исполнительный продюсер",
            definition = "The senior figure who secures financing and supervises an entire project.",
            definitionNative = "Старший человек, обеспечивающий финансирование и курирующий весь проект.",
            example = "The executive producer flew in to oversee the final cut last week.",
            exampleNative = "Executive producer прилетел проконтролировать финальный монтаж на прошлой неделе.",
            pos = "noun", semanticGroup = "entertainment_production", fillInBlankExclusions = listOf(35801L, 35803L, 35804L, 35805L)),

        WordEntity(id = 35803, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "location scouting", transliteration = "[loʊˈkeɪʃən ˈskaʊtɪŋ]",
            translation = "поиск натурных площадок",
            definition = "The job of finding real places where a film or show can be shot.",
            definitionNative = "Работа по поиску реальных мест, где можно снимать фильм или сериал.",
            example = "They spent two months on location scouting across rural Iceland.",
            exampleNative = "Они потратили два месяца на location scouting по сельской Исландии.",
            pos = "noun", semanticGroup = "entertainment_production", fillInBlankExclusions = listOf(35801L, 35802L, 35804L, 35805L)),

        WordEntity(id = 35804, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "post-production", transliteration = "[poʊst prəˈdʌkʃən]",
            translation = "постпродакшн (этап после съёмок)",
            definition = "Everything done to a film after shooting — editing, colour, music and effects.",
            definitionNative = "Всё, что делают с фильмом после съёмок — монтаж, цвет, музыка, эффекты.",
            example = "The team is still in post-production and the trailer drops next month.",
            exampleNative = "Команда ещё в post-production, а трейлер выйдет в следующем месяце.",
            pos = "noun", semanticGroup = "entertainment_production", fillInBlankExclusions = listOf(35801L, 35802L, 35803L, 35805L)),

        WordEntity(id = 35805, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sound design", transliteration = "[saʊnd dɪˈzaɪn]",
            translation = "саунд-дизайн (создание звукового полотна)",
            definition = "The craft of building all the noises and atmosphere a film or game needs.",
            definitionNative = "Искусство создания всех шумов и атмосферы, нужных фильму или игре.",
            example = "The eerie sound design made the cabin feel haunted from the start.",
            exampleNative = "Жуткий sound design делал хижину зловещей с первой минуты.",
            pos = "noun", semanticGroup = "entertainment_production", fillInBlankExclusions = listOf(35801L, 35802L, 35803L, 35804L)),

        // ── entertainment_festivals (5) ───────────────────────────────────

        WordEntity(id = 35806, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "film festival", transliteration = "[fɪlm ˈfɛstɪvəl]",
            translation = "кинофестиваль",
            definition = "A multi-day event where many new movies are shown and judged.",
            definitionNative = "Многодневное событие, где показывают и судят множество новых фильмов.",
            example = "Her debut feature won the top prize at a small European film festival.",
            exampleNative = "Её дебют взял главный приз на небольшом европейском film festival.",
            pos = "noun", semanticGroup = "entertainment_festivals", fillInBlankExclusions = listOf(35807L, 35808L, 35809L, 35810L)),

        WordEntity(id = 35807, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "world premiere", transliteration = "[wɜrld prɛˈmɪr]",
            translation = "мировая премьера",
            definition = "The very first public screening of a film anywhere on the globe.",
            definitionNative = "Самый первый публичный показ фильма где-либо в мире.",
            example = "The world premiere was held in Cannes with the cast on the red carpet.",
            exampleNative = "World premiere прошла в Каннах с актёрами на красной дорожке.",
            pos = "noun", semanticGroup = "entertainment_festivals", fillInBlankExclusions = listOf(35806L, 35808L, 35809L, 35810L)),

        WordEntity(id = 35808, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "official selection", transliteration = "[əˈfɪʃəl səˈlɛkʃən]",
            translation = "официальная программа (фестиваля)",
            definition = "The list of works picked by judges to compete inside the main programme.",
            definitionNative = "Список работ, выбранных жюри для участия в основной конкурсной программе.",
            example = "Their short made the official selection at three international fests this year.",
            exampleNative = "Их короткометражка попала в official selection трёх международных фестов в этом году.",
            pos = "noun", semanticGroup = "entertainment_festivals", fillInBlankExclusions = listOf(35806L, 35807L, 35809L, 35810L)),

        WordEntity(id = 35809, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "retrospective", transliteration = "[ˌrɛtrəˈspɛktɪv]",
            translation = "ретроспектива (показ старых работ автора)",
            definition = "A festival programme that revisits an artist's older works in one place.",
            definitionNative = "Программа фестиваля, собирающая в одном месте ранние работы автора.",
            example = "The festival opened with a retrospective of the late director's early films.",
            exampleNative = "Фестиваль открыла retrospective ранних фильмов покойного режиссёра.",
            pos = "noun", semanticGroup = "entertainment_festivals", fillInBlankExclusions = listOf(35806L, 35807L)),

        WordEntity(id = 35810, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "audience award", transliteration = "[ˈɔdiəns əˈwɔrd]",
            translation = "приз зрительских симпатий",
            definition = "A festival prize chosen by viewers' votes rather than by a jury.",
            definitionNative = "Приз фестиваля, выбираемый голосованием зрителей, а не жюри.",
            example = "The crowd-pleasing comedy walked away with the audience award on closing night.",
            exampleNative = "Народная комедия унесла audience award в закрывающий вечер фестиваля.",
            pos = "noun", semanticGroup = "entertainment_festivals", fillInBlankExclusions = listOf(35806L, 35807L, 35808L, 35809L)),

        // ── entertainment_gaming (5) ──────────────────────────────────────

        WordEntity(id = 35811, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "esports tournament", transliteration = "[ˈiːˌspɔrts ˈtʊrnəmənt]",
            translation = "киберспортивный турнир",
            definition = "A pro contest where teams or solo players fight for big cash prizes.",
            definitionNative = "Профессиональное соревнование, где команды или соло-игроки сражаются за крупные призовые.",
            example = "He flew to Seoul for an esports tournament with a million-dollar pool.",
            exampleNative = "Он полетел в Сеул на esports tournament с миллионным призовым фондом.",
            pos = "noun", semanticGroup = "entertainment_gaming"),

        WordEntity(id = 35812, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "battle pass", transliteration = "[ˈbætəl pæs]",
            translation = "боевой пропуск (сезонная подписка с наградами)",
            definition = "A paid track of seasonal rewards you unlock by playing daily missions.",
            definitionNative = "Платный трек сезонных наград, которые открываются за выполнение ежедневных задач.",
            example = "He bought the new battle pass to unlock the legendary skin set.",
            exampleNative = "Он купил новый battle pass, чтобы открыть легендарный набор скинов.",
            pos = "noun", semanticGroup = "entertainment_gaming", fillInBlankExclusions = listOf(35811L, 35813L, 35814L, 35815L)),

        WordEntity(id = 35813, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "microtransaction", transliteration = "[ˌmaɪkroʊtrænˈzækʃən]",
            translation = "микроплатёж (мелкая внутриигровая покупка)",
            definition = "A tiny in-app payment for cosmetics, currency or extra perks inside a title.",
            definitionNative = "Маленький платёж внутри приложения за косметику, валюту или мелкие бонусы.",
            example = "Critics blast the studio for hiding gear behind another microtransaction.",
            exampleNative = "Критики ругают студию за то, что снаряжение спрятано за очередной microtransaction.",
            pos = "noun", semanticGroup = "entertainment_gaming", fillInBlankExclusions = listOf(35811L, 35812L, 35814L, 35815L)),

        WordEntity(id = 35814, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "downloadable content", transliteration = "[ˌdaʊnˈloʊdəbəl ˈkɑntɛnt]",
            translation = "загружаемый контент / DLC",
            definition = "Extra missions, maps or items added to a game after the main release.",
            definitionNative = "Дополнительные миссии, карты или предметы, добавленные к игре после основного релиза.",
            example = "The new downloadable content adds a snowy island and three boss fights.",
            exampleNative = "Новый downloadable content добавляет снежный остров и три битвы с боссами.",
            pos = "noun", semanticGroup = "entertainment_gaming", fillInBlankExclusions = listOf(35811L, 35812L, 35813L, 35815L)),

        WordEntity(id = 35815, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "season pass", transliteration = "[ˈsizən pæs]",
            translation = "сезонный пропуск (доступ ко всем DLC сезона)",
            definition = "A bundle ticket that unlocks every planned add-on for one game year.",
            definitionNative = "Пакетный пропуск, открывающий все запланированные дополнения за один игровой год.",
            example = "Loyal fans grabbed the season pass on day one to skip the queue.",
            exampleNative = "Преданные фанаты взяли season pass в первый же день, чтобы не ждать.",
            pos = "noun", semanticGroup = "entertainment_gaming", fillInBlankExclusions = listOf(35811L, 35812L, 35813L, 35814L)),

        // ── entertainment_streaming (5) ───────────────────────────────────

        WordEntity(id = 35816, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "streaming platform", transliteration = "[ˈstrimɪŋ ˈplætˌfɔrm]",
            translation = "стриминговый сервис (платформа)",
            definition = "An online service that delivers films and shows on demand to viewers.",
            definitionNative = "Онлайн-сервис, который доставляет фильмы и сериалы зрителям по запросу.",
            example = "The major streaming platform paid huge sums for exclusive sci-fi rights.",
            exampleNative = "Крупная streaming platform заплатила огромные суммы за эксклюзивные научно-фантастические права.",
            pos = "noun", semanticGroup = "entertainment_streaming", fillInBlankExclusions = listOf(35801L, 35817L, 35818L, 35819L, 35820L)),

        WordEntity(id = 35817, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "original series", transliteration = "[əˈrɪʤənəl ˈsɪriz]",
            translation = "оригинальный сериал (платформы)",
            definition = "A show made and owned by a streaming service rather than licensed in.",
            definitionNative = "Сериал, который снят и принадлежит стриминговому сервису, а не куплен у студии.",
            example = "Her original series was renewed for two more seasons after one weekend.",
            exampleNative = "Её original series продлили ещё на два сезона уже после первых выходных.",
            pos = "noun", semanticGroup = "entertainment_streaming", fillInBlankExclusions = listOf(35816L, 35818L, 35819L, 35820L)),

        WordEntity(id = 35818, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "watch party", transliteration = "[wɑʧ ˈpɑrti]",
            translation = "совместный онлайн-просмотр",
            definition = "An online session where friends view the same show together over chat.",
            definitionNative = "Онлайн-сеанс, где друзья одновременно смотрят одно шоу и переписываются в чате.",
            example = "We hosted a watch party for the finale and chatted through every twist.",
            exampleNative = "Мы устроили watch party на финал и обсуждали в чате каждый поворот.",
            pos = "noun", semanticGroup = "entertainment_streaming", fillInBlankExclusions = listOf(35816L, 35819L, 35820L)),

        WordEntity(id = 35819, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "simulcast", transliteration = "[ˈsaɪməlˌkæst]",
            translation = "симулкаст (одновременный показ на нескольких рынках)",
            definition = "A broadcast aired in many regions or platforms at exactly the same hour.",
            definitionNative = "Трансляция, идущая в разных регионах или платформах в один и тот же час.",
            example = "The new anime gets a global simulcast minutes after the Tokyo airing.",
            exampleNative = "Новое аниме идёт на глобальный simulcast через минуты после показа в Токио.",
            pos = "noun", semanticGroup = "entertainment_streaming", fillInBlankExclusions = listOf(35807L, 35816L, 35817L, 35818L, 35820L)),

        WordEntity(id = 35820, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "viewership rating", transliteration = "[ˈvjuərʃɪp ˈreɪtɪŋ]",
            translation = "рейтинг просмотров",
            definition = "A number that shows how many people tuned in to a programme or stream.",
            definitionNative = "Число, показывающее, сколько людей подключились к программе или трансляции.",
            example = "The drama beat every rival in the weekly viewership rating chart.",
            exampleNative = "Драма обошла всех соперников в недельной таблице viewership rating.",
            pos = "noun", semanticGroup = "entertainment_streaming", fillInBlankExclusions = listOf(35816L, 35817L, 35818L, 35819L)),

        // ── entertainment_creative (5) ────────────────────────────────────

        WordEntity(id = 35821, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "script doctor", transliteration = "[skrɪpt ˈdɑktər]",
            translation = "скрипт-доктор (правит чужие сценарии)",
            definition = "A hired writer who quietly fixes weak scenes in another author's draft.",
            definitionNative = "Нанятый сценарист, тихо чинящий слабые сцены в чужом черновике.",
            example = "The studio paid a script doctor to sharpen the second-act plot.",
            exampleNative = "Студия заплатила script doctor, чтобы тот заострил сюжет во втором акте.",
            pos = "noun", semanticGroup = "entertainment_creative", fillInBlankExclusions = listOf(35822L, 35823L, 35824L)),

        WordEntity(id = 35822, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "location manager", transliteration = "[loʊˈkeɪʃən ˈmænəʤər]",
            translation = "менеджер натурных площадок",
            definition = "The crew member who arranges permits and access for every shooting site.",
            definitionNative = "Член группы, оформляющий разрешения и доступ для каждой съёмочной площадки.",
            example = "Their location manager negotiated to close a busy bridge for one night.",
            exampleNative = "Их location manager договорился закрыть оживлённый мост на одну ночь.",
            pos = "noun", semanticGroup = "entertainment_creative", fillInBlankExclusions = listOf(35802L, 35821L, 35823L, 35824L, 35825L)),

        WordEntity(id = 35823, setId = 358, languagePair = "en-ru", rarity = "EPIC",
            original = "casting director", transliteration = "[ˈkæstɪŋ dɪˈrɛktər]",
            translation = "директор по кастингу",
            definition = "The pro who finds and chooses actors to play each role in a project.",
            definitionNative = "Специалист, который находит и подбирает актёров на каждую роль в проекте.",
            example = "A sharp casting director can quietly save a film from poor performances.",
            exampleNative = "Толковый casting director способен тихо спасти фильм от слабой игры.",
            pos = "noun", semanticGroup = "entertainment_creative", fillInBlankExclusions = listOf(35821L, 35822L, 35824L, 35825L)),

        WordEntity(id = 35824, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "foley artist", transliteration = "[ˈfoʊli ˈɑrtɪst]",
            translation = "фоли-артист (создаёт бытовые звуки на студии)",
            definition = "A specialist who recreates everyday noises by hand for a film's audio track.",
            definitionNative = "Специалист, вручную воссоздающий бытовые звуки для звуковой дорожки фильма.",
            example = "The foley artist crunched lettuce to mimic boots walking through wet snow.",
            exampleNative = "Foley artist хрустел салатом, имитируя шаги ботинок по мокрому снегу.",
            pos = "noun", semanticGroup = "entertainment_creative", fillInBlankExclusions = listOf(35821L, 35822L, 35823L, 35825L)),

        WordEntity(id = 35825, setId = 358, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "intimacy coordinator", transliteration = "[ˈɪntəməsi koʊˈɔrdəˌneɪtər]",
            translation = "координатор интимных сцен",
            definition = "An on-set pro who keeps actors safe and comfortable during sensitive scenes.",
            definitionNative = "Специалист на площадке, оберегающий актёров и их комфорт в чувствительных сценах.",
            example = "An intimacy coordinator now joins almost every major shoot from day one.",
            exampleNative = "Intimacy coordinator теперь присутствует почти на каждой крупной съёмке с первого дня.",
            pos = "noun", semanticGroup = "entertainment_creative", fillInBlankExclusions = listOf(35802L)),
    )
}
