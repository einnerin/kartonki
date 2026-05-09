package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English football vocabulary — extension of the «Спорт» topic, level 2.
 * Set 450 (en-ru). Covers football positions, set pieces, offences, competitions, gear/fans.
 * Rarity: UNCOMMON + RARE (two adjacent tiers, A2..B2).
 * Word IDs follow formula setId*100+pos → 45001..45025.
 *
 * Не пересекается со словами из set 17, 210, 253, 278, 308, 315, 316 — общие термины спорта
 * там, тут — узкая лексика именно про футбол (правила, позиции, лиги).
 */
object WordDataEnglishSportsFootball {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 450, languagePair = "en-ru", orderIndex = 450,
            name = "Спорт",
            description = "Футбол: правила, позиции и лиги",
            topic = "Спорт",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: sport_football_positions (5 words) ───────────────────────

        WordEntity(id = 45001, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "midfielder", translation = "полузащитник",
            definition = "A player who works in the middle of the pitch, linking attack and defence.",
            definitionNative = "Игрок, работающий в центре поля — связывает оборону и атаку.",
            example = "Their midfielder controlled the pace of the whole match.",
            exampleNative = "Их midfielder задавал ритм всему матчу.",
            transliteration = "[ˈmɪdˌfildər]",
            pos = "noun", semanticGroup = "sport_football_positions", fillInBlankExclusions = listOf(45002L, 45003L, 45004L, 45005L)),

        WordEntity(id = 45002, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "winger", translation = "вингер / крайний нападающий",
            definition = "A fast attacker who plays close to the side of the pitch.",
            definitionNative = "Быстрый атакующий игрок, действующий у самой бровки поля.",
            example = "The young winger flew past two defenders down the line.",
            exampleNative = "Молодой winger обыграл двоих по краю и навесил в штрафную.",
            transliteration = "[ˈwɪŋər]",
            pos = "noun", semanticGroup = "sport_football_positions", fillInBlankExclusions = listOf(45001L, 45003L, 45004L, 45005L)),

        WordEntity(id = 45003, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "centre forward", translation = "центральный нападающий",
            definition = "The main attacker who plays in the middle near the opponent's goal.",
            definitionNative = "Главный атакующий по центру, играющий ближе всех к чужим воротам.",
            example = "Their centre forward scored on a header from a cross.",
            exampleNative = "Опытный centre forward замкнул прострел головой.",
            transliteration = "[ˈsɛntər ˈfɔrwərd]",
            pos = "phrase", semanticGroup = "sport_football_positions", fillInBlankExclusions = listOf(45001L, 45002L, 45004L, 45005L)),

        WordEntity(id = 45004, setId = 450, languagePair = "en-ru", rarity = "RARE",
            original = "centre back", translation = "центральный защитник",
            definition = "A defender who plays in the middle and protects the area near the keeper.",
            definitionNative = "Защитник в центре обороны — прикрывает зону перед своим вратарём.",
            example = "Our tall centre back won every ball in the air.",
            exampleNative = "Наш centre back выигрывал верховые единоборства весь матч.",
            transliteration = "[ˈsɛntər bæk]",
            pos = "phrase", semanticGroup = "sport_football_positions", fillInBlankExclusions = listOf(45001L, 45002L, 45003L, 45005L)),

        WordEntity(id = 45005, setId = 450, languagePair = "en-ru", rarity = "RARE",
            original = "playmaker", translation = "плеймейкер / разыгрывающий",
            definition = "A creative player whose passes set up chances for teammates to score.",
            definitionNative = "Креативный игрок, чьи передачи создают моменты для партнёров.",
            example = "Their playmaker delivered three brilliant assists in one half.",
            exampleNative = "Главный playmaker команды отдал три голевые передачи за тайм.",
            transliteration = "[ˈpleɪˌmeɪkər]",
            pos = "noun", semanticGroup = "sport_football_positions", fillInBlankExclusions = listOf(45001L, 45002L, 45003L, 45004L)),

        // ── Group: sport_football_set_pieces (5 words) ──────────────────────

        WordEntity(id = 45006, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "corner kick", translation = "угловой удар",
            definition = "A kick taken from the corner flag after the defending team puts the ball out.",
            definitionNative = "Удар от углового флажка — после того, как защита выбила мяч за свою линию.",
            example = "They scored from a perfect corner kick in the first half.",
            exampleNative = "Точный corner kick принёс гол в первом тайме.",
            transliteration = "[ˈkɔrnər kɪk]",
            pos = "phrase", semanticGroup = "sport_football_set_pieces", fillInBlankExclusions = listOf(45007L, 45008L, 45009L, 45010L)),

        WordEntity(id = 45007, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "free kick", translation = "штрафной удар",
            definition = "A kick given to a team after the other side breaks the rules.",
            definitionNative = "Удар, который команда получает после нарушения соперника.",
            example = "He curled the free kick over the wall and into the net.",
            exampleNative = "Он закрутил free kick через стенку прямо в угол ворот.",
            transliteration = "[fri kɪk]",
            pos = "phrase", semanticGroup = "sport_football_set_pieces", fillInBlankExclusions = listOf(45006L)),

        WordEntity(id = 45008, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "throw-in", translation = "вбрасывание из аута",
            definition = "When a player throws the ball back in after it crosses the side line.",
            definitionNative = "Введение мяча в игру руками после того, как он покинул боковую линию.",
            example = "The long throw-in caused panic in the penalty area.",
            exampleNative = "Дальний throw-in устроил суматоху перед чужими воротами.",
            transliteration = "[ˈθroʊ ɪn]",
            pos = "noun", semanticGroup = "sport_football_set_pieces", fillInBlankExclusions = listOf(45006L, 45007L, 45009L, 45010L)),

        WordEntity(id = 45009, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "header", translation = "удар головой",
            definition = "A shot or pass made by striking the ball with the upper skull.",
            definitionNative = "Удар или передача мяча лбом, чаще всего после навеса в штрафную.",
            example = "Her late header sent the team into the final.",
            exampleNative = "Её header на последних минутах вывел команду в финал.",
            transliteration = "[ˈhɛdər]",
            pos = "noun", semanticGroup = "sport_football_set_pieces", fillInBlankExclusions = listOf(45006L, 45007L, 45008L, 45010L)),

        WordEntity(id = 45010, setId = 450, languagePair = "en-ru", rarity = "RARE",
            original = "volley", translation = "удар с лёта",
            definition = "A hit on the ball before it touches the ground after a pass or cross.",
            definitionNative = "Удар по мячу с воздуха, пока он ещё не коснулся газона.",
            example = "His perfect volley flew straight into the top corner.",
            exampleNative = "Его чистый volley влетел прямо в девятку.",
            transliteration = "[ˈvɑli]",
            pos = "noun", semanticGroup = "sport_football_set_pieces", fillInBlankExclusions = listOf(45006L, 45007L, 45008L, 45009L)),

        // ── Group: sport_football_offences (5 words) ────────────────────────

        WordEntity(id = 45011, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tackle", translation = "отбор мяча в подкате",
            definition = "An attempt to take the ball from an opponent by sliding feet first.",
            definitionNative = "Попытка отобрать мяч у соперника, выставив ногу или скользя по газону.",
            example = "His clean tackle stopped the attack at the last moment.",
            exampleNative = "Чистый tackle остановил атаку у самой штрафной.",
            transliteration = "[ˈtækəl]",
            pos = "noun", semanticGroup = "sport_football_offences", fillInBlankExclusions = listOf(45009L, 45014L, 45015L)),

        WordEntity(id = 45012, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "yellow card", translation = "жёлтая карточка",
            definition = "A warning the referee shows a player for serious foul play.",
            definitionNative = "Предупреждение от арбитра за грубую или умышленную игру.",
            example = "The captain received a yellow card for a late challenge.",
            exampleNative = "Капитан получил yellow card за опоздавший подкат.",
            transliteration = "[ˈjɛloʊ kɑrd]",
            pos = "phrase", semanticGroup = "sport_football_offences", fillInBlankExclusions = listOf(45013L)),

        WordEntity(id = 45013, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "red card", translation = "красная карточка",
            definition = "A signal from the referee that sends a player off the pitch for the rest of the match.",
            definitionNative = "Сигнал арбитра, удаляющий игрока с поля до конца встречи.",
            example = "He picked up a red card and left the team with ten men.",
            exampleNative = "Он схватил red card, и команда осталась вдесятером.",
            transliteration = "[rɛd kɑrd]",
            pos = "phrase", semanticGroup = "sport_football_offences", fillInBlankExclusions = listOf(45012L)),

        WordEntity(id = 45014, setId = 450, languagePair = "en-ru", rarity = "RARE",
            original = "handball", translation = "игра рукой",
            definition = "A foul where an outfield player touches the ball with the arm or hand.",
            definitionNative = "Нарушение, когда полевой игрок касается мяча рукой или предплечьем.",
            example = "The referee blew the whistle for a clear handball in the box.",
            exampleNative = "Арбитр свистнул за очевидный handball в штрафной.",
            transliteration = "[ˈhændˌbɔl]",
            pos = "noun", semanticGroup = "sport_football_offences", fillInBlankExclusions = listOf(45007L, 45011L, 45015L)),

        WordEntity(id = 45015, setId = 450, languagePair = "en-ru", rarity = "RARE",
            original = "hat-trick", translation = "хет-трик (три гола)",
            definition = "When one player scores three times in a single match.",
            definitionNative = "Когда один игрок забивает три мяча за один матч.",
            example = "She completed her hat-trick in the final minute of the game.",
            exampleNative = "Она оформила hat-trick на последней минуте встречи.",
            transliteration = "[ˈhætˌtrɪk]",
            pos = "noun", semanticGroup = "sport_football_offences", fillInBlankExclusions = listOf(45011L, 45014L)),

        // ── Group: sport_football_competitions (5 words) ────────────────────

        WordEntity(id = 45016, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "derby", translation = "дерби (матч соседних клубов)",
            definition = "A heated match between two teams from the same city or area.",
            definitionNative = "Жаркий матч между командами из одного города или соседних районов.",
            example = "The local derby always sells out the stadium.",
            exampleNative = "Местный derby всегда собирает полный стадион.",
            transliteration = "[ˈdɜrbi]",
            pos = "noun", semanticGroup = "sport_football_competitions", fillInBlankExclusions = listOf(45020L)),

        WordEntity(id = 45017, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "Premier League", translation = "Премьер-лига (Англия)",
            definition = "The top English football league, where the strongest clubs play each year.",
            definitionNative = "Высший английский футбольный дивизион — там играют сильнейшие клубы страны.",
            example = "His goal helped the team stay in the Premier League.",
            exampleNative = "Его гол помог клубу удержаться в Premier League.",
            transliteration = "[prɪˈmɪr liɡ]",
            pos = "phrase", semanticGroup = "sport_football_competitions", fillInBlankExclusions = listOf(45018L, 45019L)),

        WordEntity(id = 45018, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "Champions League", translation = "Лига чемпионов",
            definition = "A European tournament where the best clubs from each country compete.",
            definitionNative = "Европейский турнир, в котором играют лучшие клубы каждой страны.",
            example = "The club reached the Champions League quarter-finals this spring.",
            exampleNative = "Клуб дошёл до четвертьфинала Champions League этой весной.",
            transliteration = "[ˈʧæmpiənz liɡ]",
            pos = "phrase", semanticGroup = "sport_football_competitions", fillInBlankExclusions = listOf(45017L, 45019L)),

        WordEntity(id = 45019, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "World Cup", translation = "чемпионат мира (по футболу)",
            definition = "The biggest football contest, where national teams play every four years.",
            definitionNative = "Крупнейший футбольный турнир сборных, проходит раз в четыре года.",
            example = "Argentina won the last World Cup in a dramatic final.",
            exampleNative = "Аргентина выиграла прошлый World Cup в драматичном финале.",
            transliteration = "[wɜrld kʌp]",
            pos = "phrase", semanticGroup = "sport_football_competitions", fillInBlankExclusions = listOf(45017L, 45018L)),

        WordEntity(id = 45020, setId = 450, languagePair = "en-ru", rarity = "RARE",
            original = "relegation", translation = "вылет в низший дивизион",
            definition = "When a club is moved down to a weaker league after a bad season.",
            definitionNative = "Перевод клуба в более слабый дивизион из-за плохого сезона.",
            example = "A late goal saved them from relegation by one point.",
            exampleNative = "Поздний гол спас клуб от relegation на одно очко.",
            transliteration = "[ˌrɛləˈɡeɪʃən]",
            pos = "noun", semanticGroup = "sport_football_competitions", fillInBlankExclusions = listOf(45016L)),

        // ── Group: sport_football_gear_fans (5 words) ───────────────────────

        WordEntity(id = 45021, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "kit", translation = "форма команды",
            definition = "The full set of clothes a team wears for a match — shirt, shorts, socks.",
            definitionNative = "Комплект одежды команды на матч — футболка, шорты и гетры.",
            example = "The new home kit went on sale before the season started.",
            exampleNative = "Новый домашний kit поступил в продажу перед стартом сезона.",
            transliteration = "[kɪt]",
            pos = "noun", semanticGroup = "sport_football_gear_fans", fillInBlankExclusions = listOf(45022L, 45023L, 45024L, 45025L)),

        WordEntity(id = 45022, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "jersey", translation = "майка / футболка игрока",
            definition = "The shirt with a number that a player wears during a match.",
            definitionNative = "Футболка с номером, в которой игрок выходит на матч.",
            example = "He pulled the new jersey over his head before kick-off.",
            exampleNative = "Он надел новую jersey перед самым стартом матча.",
            transliteration = "[ˈʤɜrzi]",
            pos = "noun", semanticGroup = "sport_football_gear_fans", fillInBlankExclusions = listOf(45021L, 45023L, 45024L, 45025L)),

        WordEntity(id = 45023, setId = 450, languagePair = "en-ru", rarity = "RARE",
            original = "cleats", translation = "бутсы (с шипами)",
            definition = "Special shoes with studs on the bottom that grip the grass.",
            definitionNative = "Специальная обувь с шипами на подошве — цепляется за траву.",
            example = "He bought new cleats for the rainy season.",
            exampleNative = "Он купил новые cleats на дождливый сезон.",
            transliteration = "[klits]",
            pos = "noun", semanticGroup = "sport_football_gear_fans", fillInBlankExclusions = listOf(45021L, 45022L, 45024L, 45025L)),

        WordEntity(id = 45024, setId = 450, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "supporters", translation = "болельщики клуба",
            definition = "The loyal fans who follow a club to every game and cheer it on.",
            definitionNative = "Преданные фанаты клуба — ездят на каждый матч и поддерживают команду.",
            example = "Travelling supporters filled the entire away stand.",
            exampleNative = "Гостевые supporters заполнили всю выездную трибуну.",
            transliteration = "[səˈpɔrtərz]",
            pos = "noun", semanticGroup = "sport_football_gear_fans", fillInBlankExclusions = listOf(45021L, 45022L, 45023L, 45025L)),

        WordEntity(id = 45025, setId = 450, languagePair = "en-ru", rarity = "RARE",
            original = "matchday", translation = "игровой день",
            definition = "The day a club plays — special for fans, players and the whole city.",
            definitionNative = "День матча клуба — особенный для болельщиков, игроков и города.",
            example = "On matchday, traffic near the stadium gets crazy.",
            exampleNative = "В matchday движение возле стадиона встаёт намертво.",
            transliteration = "[ˈmæʧˌdeɪ]",
            pos = "noun", semanticGroup = "sport_football_gear_fans", fillInBlankExclusions = listOf(45021L, 45022L, 45023L, 45024L)),
    )
}
