package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Развлечения и досуг (level 2, продвинутый, gaming-focus).
 *
 * Set 459: «Развлечения и досуг» — продвинутые (L2, UNCOMMON+RARE):
 *          видеоигры и геймерская культура — жанры, gameplay-термины,
 *          киберспорт, экономика игр, фан-сленг.
 *
 * Это 6-й сет темы (расширение). L1-L5 уже покрыты сетами 351-353, 358, 359.
 * Этот сет идёт параллельно 352 на L2, но фокусируется именно на видеоиграх и
 * геймерской культуре, тогда как 352 — широкий L2 (жанры экрана, события,
 * стриминг, фан-мета). Все 25 слов проверены grep'ом против всей базы и
 * против существующих gaming-терминов в сетах 249 (Технологии), 351-353,
 * 358, 359, 454 (Internet Platforms).
 *
 * Cross-topic совпадения отсутствуют — все 25 слов уникальны для базы.
 *
 * Распределение редкости: 12 UNCOMMON + 13 RARE (2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   entertainment_gaming_genres      — MOBA, FPS, MMORPG, open-world, free-to-play
 *   entertainment_gaming_play        — joystick, walkthrough, skin, lag, ping
 *   entertainment_gaming_competitive — ranked, casual, PvP, guild, OP
 *   entertainment_gaming_culture     — noob, nerf, buff, easter egg, Let's Play
 *   entertainment_gaming_economy     — DLC, gacha, loot box, pay-to-win, crossplay
 *
 * Word IDs: setId × 100 + position (45901..45925).
 */
object WordDataEnglishEntertainmentGaming {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 459, languagePair = "en-ru", orderIndex = 459,
            name = "Развлечения и досуг",
            description = "Видеоигры и геймерская культура: жанры, gameplay, киберспорт, фан-сленг",
            topic = "Развлечения и досуг", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 459 — Развлечения и досуг: видеоигры (L2, UNCOMMON+RARE)     ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── entertainment_gaming_genres (5) ───────────────────────────────

        WordEntity(id = 45901, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "MOBA", transliteration = "[ˈmoʊbə]", translation = "МОБА (онлайн-арена)",
            definition = "An online battle arena where two teams of five fight on a fixed map.",
            definitionNative = "Онлайн-арена, где две команды по пять человек сражаются на фиксированной карте.",
            example = "Dota and League are the two giants of the MOBA scene worldwide.",
            exampleNative = "Dota и League — два гиганта мировой MOBA-сцены.",
            pos = "noun", semanticGroup = "entertainment_gaming_genres", fillInBlankExclusions = listOf(45902L, 45903L)),

        WordEntity(id = 45902, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "FPS", transliteration = "[ˌɛf piː ˈɛs]", translation = "шутер от первого лица",
            definition = "A shooter genre where the player sees the action through their character's eyes.",
            definitionNative = "Жанр шутеров, где игрок смотрит на бой глазами своего персонажа.",
            example = "He grew up on classic FPS titles like Quake and Counter-Strike.",
            exampleNative = "Он вырос на классических FPS вроде Quake и Counter-Strike.",
            pos = "noun", semanticGroup = "entertainment_gaming_genres", fillInBlankExclusions = listOf(45901L, 45903L)),

        WordEntity(id = 45903, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "MMORPG", transliteration = "[ˌɛm ɛm oʊ ɑr piː ˈʤiː]", translation = "массовая ролевая онлайн-игра",
            definition = "A huge online role-playing world shared by thousands of players at once.",
            definitionNative = "Огромный ролевой онлайн-мир, в котором одновременно играют тысячи людей.",
            example = "World of Warcraft remains the most famous MMORPG ever made.",
            exampleNative = "World of Warcraft остаётся самой известной MMORPG в истории.",
            pos = "noun", semanticGroup = "entertainment_gaming_genres", fillInBlankExclusions = listOf(45901L, 45902L)),

        WordEntity(id = 45904, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "open-world", transliteration = "[ˈoʊpən ˌwɜːrld]", translation = "открытый мир (тип игры)",
            definition = "A game style where you roam a huge map freely instead of following corridors.",
            definitionNative = "Тип игр, где можно свободно бродить по огромной карте, а не идти по коридорам.",
            example = "The new open-world title gives you two hundred hours of side quests.",
            exampleNative = "Новый open-world-проект дарит двести часов побочных заданий.",
            pos = "adjective", semanticGroup = "entertainment_gaming_genres", fillInBlankExclusions = listOf(45905L)),

        WordEntity(id = 45905, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "free-to-play", transliteration = "[ˌfri tə ˈpleɪ]", translation = "условно-бесплатная (модель)",
            definition = "A model where the title costs nothing to start but sells extras inside.",
            definitionNative = "Модель, где старт игры бесплатный, но внутри продают дополнительные вещи.",
            example = "Fortnite became huge thanks to its smart free-to-play model.",
            exampleNative = "Fortnite стал огромным благодаря умной free-to-play модели.",
            pos = "adjective", semanticGroup = "entertainment_gaming_genres", fillInBlankExclusions = listOf(45904L)),

        // ── entertainment_gaming_play (5) ─────────────────────────────────

        WordEntity(id = 45906, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "joystick", transliteration = "[ˈʤɔɪˌstɪk]", translation = "джойстик (рычажный манипулятор)",
            definition = "A vertical lever you tilt with your hand to steer planes or arcade ships.",
            definitionNative = "Вертикальный рычаг, который наклоняют рукой, чтобы управлять самолётом или кораблём.",
            example = "Old arcade machines came with a heavy red joystick on the front panel.",
            exampleNative = "Старые аркадные автоматы шли с тяжёлым красным joystick на панели.",
            pos = "noun", semanticGroup = "entertainment_gaming_play", fillInBlankExclusions = listOf(45907L, 45908L, 45909L, 45910L)),

        WordEntity(id = 45907, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "walkthrough", transliteration = "[ˈwɔːkˌθruː]", translation = "гайд по прохождению",
            definition = "A step-by-step guide that shows how to finish every part of a title.",
            definitionNative = "Пошаговое руководство, показывающее, как пройти каждую часть игры.",
            example = "He looked up a walkthrough after being stuck on the same boss for hours.",
            exampleNative = "Он полез в walkthrough, застряв на одном боссе на несколько часов.",
            pos = "noun", semanticGroup = "entertainment_gaming_play", fillInBlankExclusions = listOf(45906L, 45908L, 45909L, 45910L)),

        WordEntity(id = 45908, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "skin", transliteration = "[skɪn]", translation = "скин (косметический внешний вид)",
            definition = "A new outfit or paint job for your character that changes only how it looks.",
            definitionNative = "Новый наряд или окраска персонажа, меняющие лишь его внешний вид.",
            example = "She spent ten dollars on a glowing dragon skin for her favourite hero.",
            exampleNative = "Она потратила десять долларов на светящийся skin дракона для любимого героя.",
            pos = "noun", semanticGroup = "entertainment_gaming_play", fillInBlankExclusions = listOf(45906L, 45907L, 45909L, 45910L)),

        WordEntity(id = 45909, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "lag", transliteration = "[læɡ]", translation = "лаг (задержка из-за плохой связи)",
            definition = "A slow delay between your action and what shows on the screen during play.",
            definitionNative = "Медленная задержка между твоим действием и тем, что появляется на экране.",
            example = "Bad lag turned every shot into a guess on his old internet line.",
            exampleNative = "Сильный lag превращал каждый выстрел в догадку на его старой линии.",
            pos = "noun", semanticGroup = "entertainment_gaming_play", fillInBlankExclusions = listOf(45906L, 45907L, 45908L, 45910L)),

        WordEntity(id = 45910, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "ping", transliteration = "[pɪŋ]", translation = "пинг (время отклика сервера)",
            definition = "A number in milliseconds that shows how fast your signal reaches the server.",
            definitionNative = "Число в миллисекундах, показывающее, как быстро сигнал доходит до сервера.",
            example = "A low ping under thirty is a must for serious shooter players.",
            exampleNative = "Низкий ping ниже тридцати — обязателен для серьёзных шутер-игроков.",
            pos = "noun", semanticGroup = "entertainment_gaming_play", fillInBlankExclusions = listOf(45906L, 45907L, 45908L, 45909L)),

        // ── entertainment_gaming_competitive (5) ──────────────────────────

        WordEntity(id = 45911, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "ranked", transliteration = "[ræŋkt]", translation = "рейтинговый (режим)",
            definition = "A game mode where every match changes your place on a public ladder.",
            definitionNative = "Режим, где каждый матч меняет твоё место в публичной таблице.",
            example = "He plays only ranked matches because casual queues feel boring to him.",
            exampleNative = "Он играет только ranked матчи, потому что обычные очереди ему скучны.",
            pos = "adjective", semanticGroup = "entertainment_gaming_competitive", fillInBlankExclusions = listOf(45915L)),

        WordEntity(id = 45912, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "casual", transliteration = "[ˈkæʒuəl]", translation = "казуальный (без серьёзной нагрузки)",
            definition = "A relaxed mode or player who plays for fun without chasing top results.",
            definitionNative = "Расслабленный режим или игрок, играющий ради удовольствия без гонки за топом.",
            example = "Her sister is a casual gamer who picks up the pad once a week.",
            exampleNative = "Её сестра — casual игрок, берущий геймпад раз в неделю.",
            pos = "adjective", semanticGroup = "entertainment_gaming_competitive", fillInBlankExclusions = listOf(45911L)),

        WordEntity(id = 45913, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "PvP", transliteration = "[ˌpiː viː ˈpiː]", translation = "ПвП (игрок против игрока)",
            definition = "A mode where humans fight other humans rather than computer foes.",
            definitionNative = "Режим, в котором люди сражаются с другими людьми, а не с компьютером.",
            example = "He prefers tense PvP duels to peaceful crafting and farming.",
            exampleNative = "Он предпочитает напряжённые PvP-дуэли мирному крафту и фарму.",
            pos = "noun", semanticGroup = "entertainment_gaming_competitive", fillInBlankExclusions = listOf(45914L)),

        WordEntity(id = 45914, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "guild", transliteration = "[ɡɪld]", translation = "гильдия (постоянная команда игроков)",
            definition = "A long-term group of players who join forces to share goals and rewards.",
            definitionNative = "Постоянная группа игроков, объединившихся ради общих целей и наград.",
            example = "Their guild meets every Friday for a coordinated boss attempt.",
            exampleNative = "Их guild собирается каждую пятницу на согласованную попытку убить босса.",
            pos = "noun", semanticGroup = "entertainment_gaming_competitive", fillInBlankExclusions = listOf(45913L)),

        WordEntity(id = 45915, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "OP", transliteration = "[ˌoʊ ˈpiː]", translation = "имбовый (overpowered, слишком сильный)",
            definition = "Slang for a hero or weapon so strong it makes the match feel unfair.",
            definitionNative = "Сленг про героя или оружие настолько сильное, что матч кажется нечестным.",
            example = "Players begged the studio to fix that OP sniper rifle for months.",
            exampleNative = "Игроки месяцами умоляли студию пофиксить эту OP снайперку.",
            pos = "adjective", semanticGroup = "entertainment_gaming_competitive", fillInBlankExclusions = listOf(45911L, 45912L)),

        // ── entertainment_gaming_culture (5) ──────────────────────────────

        WordEntity(id = 45916, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "noob", transliteration = "[nuːb]", translation = "нуб (неопытный игрок)",
            definition = "A slang term for a newcomer who hasn't yet learned the basic moves.",
            definitionNative = "Сленговое слово для новичка, ещё не освоившего базовые приёмы игры.",
            example = "Don't laugh at him — every veteran was once a clueless noob.",
            exampleNative = "Не смейся над ним — любой ветеран когда-то был растерянным noob.",
            pos = "noun", semanticGroup = "entertainment_gaming_culture", fillInBlankExclusions = listOf(45919L, 45920L)),

        WordEntity(id = 45917, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "nerf", transliteration = "[nɜːrf]", translation = "ослабить (понизить силу патчем)",
            definition = "To weaken a hero or weapon in a patch so it stops dominating matches.",
            definitionNative = "Понизить силу героя или оружия патчем, чтобы они перестали доминировать.",
            example = "Devs had to nerf the magic staff after one weekend of complaints.",
            exampleNative = "Разработчикам пришлось nerf магический посох после выходных жалоб.",
            pos = "verb", semanticGroup = "entertainment_gaming_culture", fillInBlankExclusions = listOf(45918L)),

        WordEntity(id = 45918, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "buff", transliteration = "[bʌf]", translation = "усилить (повысить силу патчем)",
            definition = "To make a hero or weapon stronger in a patch so people start picking it.",
            definitionNative = "Сделать героя или оружие сильнее патчем, чтобы их снова начали брать.",
            example = "The patch will buff the forgotten healer back into the meta.",
            exampleNative = "Патч должен buff забытого хилера обратно в мету.",
            pos = "verb", semanticGroup = "entertainment_gaming_culture", fillInBlankExclusions = listOf(45917L)),

        WordEntity(id = 45919, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "easter egg", transliteration = "[ˈiːstər ɛɡ]", translation = "пасхалка (скрытая отсылка)",
            definition = "A secret joke or hidden reference quietly tucked inside a title for sharp fans.",
            definitionNative = "Секретная шутка или скрытая отсылка, тихо спрятанная в игре для внимательных.",
            example = "Sharp players found an easter egg pointing to the studio's first arcade hit.",
            exampleNative = "Внимательные игроки нашли easter egg, отсылающий к первому хиту студии.",
            pos = "noun", semanticGroup = "entertainment_gaming_culture"),

        WordEntity(id = 45920, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "Let's Play", transliteration = "[lɛts pleɪ]", translation = "лет'с плей (запись прохождения с комментарием)",
            definition = "A recorded video of someone playing through a title while talking about it.",
            definitionNative = "Записанное видео, где автор проходит игру и параллельно её комментирует.",
            example = "His funny Let's Play series turned a forgotten indie into a hit.",
            exampleNative = "Его смешная Let's Play серия превратила забытое инди в хит.",
            pos = "noun", semanticGroup = "entertainment_gaming_culture", fillInBlankExclusions = listOf(45916L, 45919L)),

        // ── entertainment_gaming_economy (5) ──────────────────────────────

        WordEntity(id = 45921, setId = 459, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "DLC", transliteration = "[ˌdiː ɛl ˈsiː]", translation = "DLC (платное дополнение)",
            definition = "A paid add-on with new missions, maps or items for an existing title.",
            definitionNative = "Платное дополнение с новыми миссиями, картами или предметами для уже изданной игры.",
            example = "Two more chapters of story will arrive in next month's DLC.",
            exampleNative = "Ещё две главы сюжета выйдут в DLC в следующем месяце.",
            pos = "noun", semanticGroup = "entertainment_gaming_economy", fillInBlankExclusions = listOf(45922L, 45923L, 45925L)),

        WordEntity(id = 45922, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "gacha", transliteration = "[ˈɡɑːʧə]", translation = "гача (рандомная выдача за валюту)",
            definition = "A system where you spend money for a random pull at heroes or items.",
            definitionNative = "Система, в которой за деньги получают случайного героя или предмет.",
            example = "Mobile gacha titles can drain wallets faster than a casino slot.",
            exampleNative = "Мобильные gacha-проекты опустошают кошельки быстрее казино-слота.",
            pos = "noun", semanticGroup = "entertainment_gaming_economy", fillInBlankExclusions = listOf(45921L, 45923L, 45925L)),

        WordEntity(id = 45923, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "loot box", transliteration = "[luːt bɒks]", translation = "лутбокс (рандомный набор внутри игры)",
            definition = "A sealed in-game crate that drops random items when you pay or earn it.",
            definitionNative = "Запечатанный игровой ящик, выдающий случайные предметы за плату или активность.",
            example = "Many countries now treat each loot box like a small form of gambling.",
            exampleNative = "Многие страны теперь приравнивают loot box к мелкой азартной игре.",
            pos = "noun", semanticGroup = "entertainment_gaming_economy", fillInBlankExclusions = listOf(45921L, 45922L, 45925L)),

        WordEntity(id = 45924, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "pay-to-win", transliteration = "[ˌpeɪ tə ˈwɪn]", translation = "пэй-ту-вин (победа за деньги)",
            definition = "A design where spending real money clearly gives a player an unfair edge.",
            definitionNative = "Дизайн, в котором траты реальных денег явно дают игроку нечестное преимущество.",
            example = "Fans dropped the title fast once it slid into pay-to-win territory.",
            exampleNative = "Фанаты быстро бросили проект, как только он скатился в pay-to-win.",
            pos = "adjective", semanticGroup = "entertainment_gaming_economy"),

        WordEntity(id = 45925, setId = 459, languagePair = "en-ru", rarity = "RARE",
            original = "crossplay", transliteration = "[ˈkrɒsˌpleɪ]", translation = "кроссплей (игра между платформами)",
            definition = "A feature that lets people on different platforms share the same online match.",
            definitionNative = "Возможность, позволяющая людям с разных платформ играть в одном онлайн-матче.",
            example = "Crossplay lets her fight her console-only friends from a gaming PC.",
            exampleNative = "Crossplay позволяет ей сражаться против друзей с приставок прямо с PC.",
            pos = "noun", semanticGroup = "entertainment_gaming_economy", fillInBlankExclusions = listOf(45921L, 45922L, 45923L)),
    )
}
