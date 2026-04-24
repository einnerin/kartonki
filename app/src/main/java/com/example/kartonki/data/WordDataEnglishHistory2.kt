package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — История (level 1).
 *
 * Set 306: «История» — основы: эпохи, короли, войны, даты (L1 / COMMON+UNCOMMON).
 *
 * Дополняет уже существующие сеты этой темы:
 *   - Set 31  (WordDataEnglish.kt)          — L2 UNCOMMON (ancient, century, empire…).
 *   - Set 217 (WordDataEnglishExpanded.kt)  — L2-L3 UNCOMMON/RARE (crusade, reformation…).
 *
 * Слова этого сета не пересекаются ни с setId=31, ни с setId=217.
 */
object WordDataEnglishHistory2 {

    val sets = listOf(
        WordSetEntity(
            id = 306, name = "История",
            description = "Основы: эпохи, короли, войны, даты",
            languagePair = "en-ru",
            orderIndex = 126,
            topic = "История", level = 1),
    )

    val words: List<WordEntity> = listOf(

        // ── history_rulers (5) ────────────────────────────────────────────

        WordEntity(id = 30601, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "king", transliteration = "[kɪŋ]", translation = "король",
            definition = "The male ruler of a country, usually born into a royal family.",
            definitionNative = "Мужчина, стоящий во главе страны — обычно по наследству от отца.",
            example = "The young king led his men into a fierce battle.",
            exampleNative = "Молодой king повёл своих воинов в жестокую битву.",
            pos = "noun", semanticGroup = "history_rulers",
            fillInBlankExclusions = listOf(30602L, 30603L, 30604L, 30605L)),

        WordEntity(id = 30602, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "queen", transliteration = "[kwin]", translation = "королева",
            definition = "The female head of a royal family, or the wife of a ruling monarch.",
            definitionNative = "Главная дама царского рода — либо правит сама, либо замужем за монархом.",
            example = "The queen wore a long white dress and a gold crown.",
            exampleNative = "Queen шла в длинном белом платье и золотой короне.",
            pos = "noun", semanticGroup = "history_rulers",
            fillInBlankExclusions = listOf(30601L, 30603L, 30604L, 30605L)),

        WordEntity(id = 30603, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "prince", transliteration = "[prɪns]", translation = "принц",
            definition = "The son of a royal couple — often a future heir to the throne.",
            definitionNative = "Сын царственной четы — часто будущий наследник престола.",
            example = "The young prince was learning to ride a horse.",
            exampleNative = "Юный prince учился ездить на коне во дворе замка.",
            pos = "noun", semanticGroup = "history_rulers",
            fillInBlankExclusions = listOf(30601L, 30602L, 30604L, 30605L)),

        WordEntity(id = 30604, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "throne", transliteration = "[θroʊn]", translation = "трон",
            definition = "The ceremonial chair where a monarch sits during grand events.",
            definitionNative = "Пышное кресло, на котором монарх восседает во время торжеств.",
            example = "A jewelled throne stood at the far end of the hall.",
            exampleNative = "В дальнем конце зала возвышался украшенный камнями throne.",
            pos = "noun", semanticGroup = "history_rulers",
            fillInBlankExclusions = listOf(30601L, 30602L, 30603L, 30605L)),

        WordEntity(id = 30605, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "noble", transliteration = "[ˈnoʊbəl]", translation = "дворянин",
            definition = "A person of high birth — a lord, count or other titled aristocrat.",
            definitionNative = "Человек знатного рода — лорд, граф или иной титулованный аристократ.",
            example = "Every noble was invited to the royal wedding.",
            exampleNative = "Каждый noble был приглашён на королевскую свадьбу.",
            pos = "noun", semanticGroup = "history_rulers",
            fillInBlankExclusions = listOf(30601L, 30602L, 30603L, 30604L)),

        // ── history_warriors (5) ──────────────────────────────────────────

        WordEntity(id = 30606, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "knight", transliteration = "[naɪt]", translation = "рыцарь",
            definition = "A mounted warrior of the Middle Ages wearing heavy metal armour.",
            definitionNative = "Средневековый воин на коне в тяжёлых железных доспехах.",
            example = "The brave knight raised his shield against the arrows.",
            exampleNative = "Отважный knight поднял щит, закрываясь от стрел.",
            pos = "noun", semanticGroup = "history_warriors",
            fillInBlankExclusions = listOf(30607L, 30608L, 30609L, 30610L)),

        WordEntity(id = 30607, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "sword", transliteration = "[sɔrd]", translation = "меч",
            definition = "A long sharp metal weapon with a handle, used in close combat.",
            definitionNative = "Длинное острое оружие с рукоятью — для ближнего боя.",
            example = "He drew his sword and stepped forward bravely.",
            exampleNative = "Он вытащил sword из ножен и храбро шагнул вперёд.",
            pos = "noun", semanticGroup = "history_warriors",
            fillInBlankExclusions = listOf(30606L, 30608L, 30609L, 30610L)),

        WordEntity(id = 30608, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "army", transliteration = "[ˈɑrmi]", translation = "армия",
            definition = "A large organised group of fighters serving a country.",
            definitionNative = "Большая организованная сила бойцов, служащих своей стране.",
            example = "A huge army was marching across the open plain.",
            exampleNative = "Огромная army шагала по открытой равнине под знамёнами.",
            pos = "noun", semanticGroup = "history_warriors",
            fillInBlankExclusions = listOf(30606L, 30607L, 30609L, 30610L)),

        WordEntity(id = 30609, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "hero", transliteration = "[ˈhɪroʊ]", translation = "герой",
            definition = "A brave person admired for great deeds, often in tales of old.",
            definitionNative = "Храбрый человек, прославленный подвигами — часто в старых сказаниях.",
            example = "The whole town welcomed the returning hero with flowers.",
            exampleNative = "Весь город встречал вернувшегося hero цветами и криками.",
            pos = "noun", semanticGroup = "history_warriors",
            fillInBlankExclusions = listOf(30606L, 30607L, 30608L, 30610L)),

        WordEntity(id = 30610, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "soldier", transliteration = "[ˈsoʊlʤər]", translation = "солдат",
            definition = "A person who serves in the ranks of an army and fights in wars.",
            definitionNative = "Человек в военной форме, идущий в бой в составе армии.",
            example = "An old soldier told us stories by the fire.",
            exampleNative = "Старый soldier рассказывал нам истории у костра.",
            pos = "noun", semanticGroup = "history_warriors",
            fillInBlankExclusions = listOf(30606L, 30607L, 30608L, 30609L)),

        // ── history_events (5) ────────────────────────────────────────────

        WordEntity(id = 30611, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "win", transliteration = "[wɪn]", translation = "побеждать",
            definition = "To come out on top in a fight, race or contest.",
            definitionNative = "Выйти первым из боя, гонки или соревнования — обойти всех.",
            example = "Our side hoped to win the long war at last.",
            exampleNative = "Наши надеялись win эту долгую войну наконец.",
            pos = "verb", semanticGroup = "history_events",
            fillInBlankExclusions = listOf(30612L, 30613L)),

        WordEntity(id = 30612, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "die", transliteration = "[daɪ]", translation = "погибать",
            definition = "To lose your life — for example on a field of battle.",
            definitionNative = "Лишиться жизни — например, на поле боя во время войны.",
            example = "Many brave men would die before the war ended.",
            exampleNative = "Многим храбрым мужчинам предстояло die до конца войны.",
            pos = "verb", semanticGroup = "history_events",
            fillInBlankExclusions = listOf(30611L, 30613L)),

        WordEntity(id = 30613, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "fight", transliteration = "[faɪt]", translation = "сражаться",
            definition = "To take part in armed combat against an enemy.",
            definitionNative = "Участвовать в вооружённом бою против врага — с мечом или ружьём.",
            example = "Young men were called to fight for their homeland.",
            exampleNative = "Молодых мужчин позвали fight за свою родину.",
            pos = "verb", semanticGroup = "history_events",
            fillInBlankExclusions = listOf(30611L, 30612L)),

        WordEntity(id = 30614, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "victory", transliteration = "[ˈvɪktəri]", translation = "победа",
            definition = "The act of coming out on top in a struggle or contest.",
            definitionNative = "Успешный исход борьбы или состязания — когда одна сторона берёт верх.",
            example = "A great victory was celebrated in every town and village.",
            exampleNative = "Великую victory отмечали в каждом городе и селе.",
            pos = "noun", semanticGroup = "history_events",
            fillInBlankExclusions = listOf(30615L)),

        WordEntity(id = 30615, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "defeat", transliteration = "[dɪˈfit]", translation = "поражение",
            definition = "The state of losing a battle, match or argument.",
            definitionNative = "Итог, при котором сторона проигрывает бой, матч или спор.",
            example = "The army suffered a heavy defeat on that cold morning.",
            exampleNative = "Армия понесла тяжёлое defeat тем холодным утром.",
            pos = "noun", semanticGroup = "history_events",
            fillInBlankExclusions = listOf(30614L)),

        // ── history_artifacts (5) ─────────────────────────────────────────

        WordEntity(id = 30616, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "castle", transliteration = "[ˈkæsəl]", translation = "замок",
            definition = "A strong stone building from the past, with high walls and towers.",
            definitionNative = "Крепкое каменное строение прошлых веков — с высокими стенами и башнями.",
            example = "An old castle stood on the hill above our village.",
            exampleNative = "Старый castle возвышался на холме над нашей деревней.",
            pos = "noun", semanticGroup = "history_artifacts",
            fillInBlankExclusions = listOf(30617L, 30618L, 30619L, 30620L)),

        WordEntity(id = 30617, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "flag", transliteration = "[flæɡ]", translation = "флаг",
            definition = "A piece of cloth with colours or symbols of a country or army.",
            definitionNative = "Кусок ткани с цветами или знаками страны либо войска — на высоком древке.",
            example = "Soldiers raised the flag above the captured tower.",
            exampleNative = "Воины подняли flag над захваченной башней.",
            pos = "noun", semanticGroup = "history_artifacts",
            fillInBlankExclusions = listOf(30616L, 30618L, 30619L, 30620L)),

        WordEntity(id = 30618, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "crown", transliteration = "[kraʊn]", translation = "корона",
            definition = "A fancy gold headpiece with jewels, worn by kings and queens.",
            definitionNative = "Парадный золотой головной убор с камнями — для царствующих особ.",
            example = "A heavy gold crown rested on the old king's head.",
            exampleNative = "Тяжёлая золотая crown покоилась на голове старого короля.",
            pos = "noun", semanticGroup = "history_artifacts",
            fillInBlankExclusions = listOf(30616L, 30617L, 30619L, 30620L)),

        WordEntity(id = 30619, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "date", transliteration = "[deɪt]", translation = "дата",
            definition = "The exact day, month and year when something happened.",
            definitionNative = "Точный день, месяц и год, когда случилось какое-то событие.",
            example = "Nobody could remember the exact date of the battle.",
            exampleNative = "Никто не мог вспомнить точную date этой битвы.",
            pos = "noun", semanticGroup = "history_artifacts",
            fillInBlankExclusions = listOf(30616L, 30617L, 30618L, 30620L)),

        WordEntity(id = 30620, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "past", transliteration = "[pæst]", translation = "прошлое",
            definition = "The time before now — events that have already happened.",
            definitionNative = "Время до нынешнего дня — всё, что уже случилось и ушло.",
            example = "Historians dig through the past to understand us better.",
            exampleNative = "Историки копаются в past, чтобы лучше понять нас самих.",
            pos = "noun", semanticGroup = "history_artifacts",
            fillInBlankExclusions = listOf(30616L, 30617L, 30618L, 30619L)),

        // ── history_society (5) ───────────────────────────────────────────

        WordEntity(id = 30621, setId = 306, languagePair = "en-ru", rarity = "COMMON",
            original = "old", transliteration = "[oʊld]", translation = "древний",
            definition = "From a time long ago — a very ancient thing or person.",
            definitionNative = "Из далёких времён — очень старый предмет или человек.",
            example = "We found an old scroll hidden behind the wall.",
            exampleNative = "За стеной мы нашли old свиток, спрятанный много веков назад.",
            pos = "adjective", semanticGroup = "history_society"),

        WordEntity(id = 30622, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "law", transliteration = "[lɔ]", translation = "закон",
            definition = "An official rule set by a ruler or parliament for all to follow.",
            definitionNative = "Официальное предписание, которое устанавливает власть для всех граждан.",
            example = "A new law forbade hunting deer in the royal forest.",
            exampleNative = "Новый law запретил охотиться на оленей в королевском лесу.",
            pos = "noun", semanticGroup = "history_society",
            fillInBlankExclusions = listOf(30623L, 30624L, 30625L)),

        WordEntity(id = 30623, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "peace", transliteration = "[pis]", translation = "мир",
            definition = "A state without war — calm between countries or peoples.",
            definitionNative = "Состояние без войны — спокойные отношения между странами или народами.",
            example = "Both sides finally agreed to sign a lasting peace.",
            exampleNative = "Обе стороны наконец договорились подписать длительный peace.",
            pos = "noun", semanticGroup = "history_society",
            fillInBlankExclusions = listOf(30622L, 30625L)),

        WordEntity(id = 30624, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "rule", transliteration = "[rul]", translation = "править",
            definition = "To be the leader of a country and make decisions for its people.",
            definitionNative = "Стоять у власти страны и принимать решения за её народ.",
            example = "Kings used to rule this land for many centuries.",
            exampleNative = "Короли когда-то долгие века rule этой землёй.",
            pos = "verb", semanticGroup = "history_society", fillInBlankExclusions = listOf(30611L)),

        WordEntity(id = 30625, setId = 306, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "slave", transliteration = "[sleɪv]", translation = "раб",
            definition = "A person forced to work for another without freedom or pay.",
            definitionNative = "Человек, которого заставляют трудиться на хозяина без свободы и платы.",
            example = "No slave was allowed to leave the master's lands.",
            exampleNative = "Ни один slave не мог покинуть владения хозяина.",
            pos = "noun", semanticGroup = "history_society",
            fillInBlankExclusions = listOf(30622L, 30623L)),
    )
}
