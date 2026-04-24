package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English sports vocabulary — level 4 (professional).
 * Set 315 (en-ru). Covers match analytics, refereeing, professional training and statistics.
 * Rarity: EPIC + LEGENDARY (two adjacent tiers, C1+).
 * Word IDs follow formula setId*100+pos → 31501..31525.
 */
object WordDataEnglishSportsL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 315, languagePair = "en-ru", orderIndex = 135,
            name = "Спорт",
            description = "Профессиональный спорт: анализ, статистика, судейство",
            topic = "Спорт",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: sports_officiating (6 words) ─────────────────────────────

        WordEntity(id = 31501, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "umpire", translation = "арбитр (теннис/бейсбол)",
            definition = "An official in tennis or baseball who decides if a play is legal.",
            definitionNative = "Главный судья на теннисном или бейсбольном матче — решает спорные моменты.",
            example = "The umpire ruled the ball was out by a couple of inches.",
            exampleNative = "Опытный umpire быстро разрешил спор о попадании мяча.",
            transliteration = "[ˈʌmpaɪər]",
            pos = "noun", semanticGroup = "sports_officiating", fillInBlankExclusions = listOf(31502L, 31503L, 31506L)),

        WordEntity(id = 31502, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "linesman", translation = "боковой судья",
            definition = "An assistant who watches a side line and signals with a flag.",
            definitionNative = "Помощник главного судьи, который следит за боковой линией с флажком.",
            example = "The linesman raised his flag for an offside position.",
            exampleNative = "Внимательный linesman заметил, что мяч вышел за линию.",
            transliteration = "[ˈlaɪnzmən]",
            pos = "noun", semanticGroup = "sports_officiating", fillInBlankExclusions = listOf(31501L, 31503L, 31505L)),

        WordEntity(id = 31503, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "VAR", translation = "видеопомощь арбитру",
            definition = "Video technology that helps a head official review close calls.",
            definitionNative = "Технология видеопросмотра, которая помогает пересмотреть спорные эпизоды.",
            example = "The goal was allowed only after a long VAR check.",
            exampleNative = "После долгой проверки VAR гол всё же засчитали.",
            transliteration = "[vi eɪ ˈɑr]",
            pos = "noun", semanticGroup = "sports_officiating", fillInBlankExclusions = listOf(31501L, 31502L)),

        WordEntity(id = 31504, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "referee crew", translation = "судейская бригада",
            definition = "The full group of officials working together on one match.",
            definitionNative = "Вся группа судей, которая вместе обслуживает один матч.",
            example = "A full referee crew arrived at the stadium two hours early.",
            exampleNative = "Опытная referee crew обслуживала финальный матч турнира.",
            transliteration = "[ˌrɛfəˈri kru]",
            pos = "phrase", semanticGroup = "sports_officiating", fillInBlankExclusions = listOf(31505L, 31506L)),

        WordEntity(id = 31505, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "assistant referee", translation = "помощник арбитра",
            definition = "A side official in football who watches offsides and touchlines.",
            definitionNative = "Боковой судья в футболе — отвечает за офсайды и линии поля.",
            example = "The assistant referee flagged the striker as offside.",
            exampleNative = "Внимательный assistant referee заметил офсайд в решающий момент.",
            transliteration = "[əˈsɪstənt ˌrɛfəˈri]",
            pos = "phrase", semanticGroup = "sports_officiating", fillInBlankExclusions = listOf(31501L, 31502L, 31504L, 31506L)),

        WordEntity(id = 31506, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "fourth official", translation = "четвёртый арбитр / резервный судья",
            definition = "The reserve judge at the sideline who tracks subs and stoppage time.",
            definitionNative = "Запасной у бровки — следит за заменами и добавленным временем.",
            example = "The fourth official held up the board showing six added minutes.",
            exampleNative = "У бровки fourth official поднял табло с номерами замен.",
            transliteration = "[fɔrθ əˈfɪʃəl]",
            pos = "phrase", semanticGroup = "sports_officiating", fillInBlankExclusions = listOf(31504L, 31505L)),

        // ── Group: sports_statistics (7 words) ──────────────────────────────

        WordEntity(id = 31507, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "per-game", translation = "в среднем за матч",
            definition = "A number worked out as an average for a single contest.",
            definitionNative = "Показатель, пересчитанный как среднее значение на одну встречу.",
            example = "She averages twenty points per-game this season.",
            exampleNative = "Форвард набирает почти двадцать очков per-game в этом сезоне.",
            transliteration = "[pɜr ɡeɪm]",
            pos = "adjective", semanticGroup = "sports_statistics"),

        WordEntity(id = 31508, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "efficiency rating", translation = "рейтинг эффективности",
            definition = "A single number that sums up how useful a player is on the court.",
            definitionNative = "Один показатель, который объединяет всю полезность игрока на площадке.",
            example = "His efficiency rating leads the entire league this month.",
            exampleNative = "Свежий efficiency rating ставит защитника выше всех в лиге.",
            transliteration = "[ɪˈfɪʃənsi ˈreɪtɪŋ]",
            pos = "phrase", semanticGroup = "sports_statistics", fillInBlankExclusions = listOf(31510L, 31511L, 31512L, 31513L)),

        WordEntity(id = 31509, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "xG", translation = "ожидаемые голы",
            definition = "A football metric that estimates the chance of scoring from a shot.",
            definitionNative = "Футбольный показатель: оценивает, насколько вероятен гол с конкретного удара.",
            example = "The team's xG was higher, but they lost the match anyway.",
            exampleNative = "По xG наши создали больше моментов, но проиграли по счёту.",
            transliteration = "[ˌɛks ˈʤi]",
            pos = "noun", semanticGroup = "sports_statistics", fillInBlankExclusions = listOf(31508L, 31511L)),

        WordEntity(id = 31510, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "stat line", translation = "строка статистики",
            definition = "A short list of numbers showing what a player did during a match.",
            definitionNative = "Короткая сводка чисел — что именно сделал игрок за одну встречу.",
            example = "His stat line last night was almost a triple-double.",
            exampleNative = "Впечатляющая stat line: тридцать очков и десять передач за матч.",
            transliteration = "[stæt laɪn]",
            pos = "phrase", semanticGroup = "sports_statistics", fillInBlankExclusions = listOf(31508L, 31511L, 31512L, 31513L)),

        WordEntity(id = 31511, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "possession rate", translation = "процент владения мячом",
            definition = "The share of time one team keeps the ball during play.",
            definitionNative = "Доля времени матча, в которую мяч находится у одной из команд.",
            example = "Our possession rate was sixty-five percent in the first half.",
            exampleNative = "Высокий possession rate не помог нам создать опасных моментов.",
            transliteration = "[pəˈzɛʃən reɪt]",
            pos = "phrase", semanticGroup = "sports_statistics", fillInBlankExclusions = listOf(31508L, 31510L, 31512L, 31513L)),

        WordEntity(id = 31512, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "turnover ratio", translation = "соотношение потерь",
            definition = "A number that compares useful passes to balls lost to the other team.",
            definitionNative = "Показатель, сравнивающий полезные передачи с потерями мяча сопернику.",
            example = "Her turnover ratio was the best on the whole team.",
            exampleNative = "У разыгрывающего отличный turnover ratio за весь сезон.",
            transliteration = "[ˈtɜrnˌoʊvər ˈreɪʃioʊ]",
            pos = "phrase", semanticGroup = "sports_statistics", fillInBlankExclusions = listOf(31508L, 31510L, 31511L, 31513L)),

        WordEntity(id = 31513, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "shot on target", translation = "удар в створ ворот",
            definition = "A kick or throw aimed so it would score if the keeper missed.",
            definitionNative = "Удар точно в рамку ворот — забил бы, если бы не вратарь.",
            example = "His only shot on target hit the post and bounced out.",
            exampleNative = "Единственный shot on target за весь матч попал в штангу.",
            transliteration = "[ʃɑt ɑn ˈtɑrɡət]",
            pos = "phrase", semanticGroup = "sports_statistics", fillInBlankExclusions = listOf(31508L, 31510L, 31511L, 31512L)),

        // ── Group: sports_match_analysis (6 words) ──────────────────────────

        WordEntity(id = 31514, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "possession", translation = "владение мячом",
            definition = "The state of having the ball and controlling the play.",
            definitionNative = "Состояние, когда мяч у твоей команды и она ведёт игру.",
            example = "Keep possession and wait for the defenders to tire.",
            exampleNative = "Долгое possession измотало защитников соперника к концу тайма.",
            transliteration = "[pəˈzɛʃən]",
            pos = "noun", semanticGroup = "sports_match_analysis", fillInBlankExclusions = listOf(31515L, 31517L)),

        WordEntity(id = 31515, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "pressing", translation = "высокий прессинг",
            definition = "Chasing the other team hard to win the ball back quickly.",
            definitionNative = "Активное давление на соперника, чтобы быстро отобрать мяч.",
            example = "Their aggressive pressing forced three mistakes in ten minutes.",
            exampleNative = "Тяжёлый pressing помог отобрать мяч у самой штрафной.",
            transliteration = "[ˈprɛsɪŋ]",
            pos = "noun", semanticGroup = "sports_match_analysis", fillInBlankExclusions = listOf(31514L, 31517L)),

        WordEntity(id = 31516, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "set piece", translation = "стандартное положение",
            definition = "A planned play after a stoppage, like a corner or a free kick.",
            definitionNative = "Разыгранный заранее эпизод после остановки — угловой, штрафной и т.п.",
            example = "They scored from a clever set piece just before halftime.",
            exampleNative = "Красивый set piece принёс нам гол с углового удара.",
            transliteration = "[sɛt pis]",
            pos = "phrase", semanticGroup = "sports_match_analysis", fillInBlankExclusions = listOf(31517L, 31518L, 31519L)),

        WordEntity(id = 31517, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "breakaway", translation = "выход один на один",
            definition = "A fast solo run past defenders straight at the keeper.",
            definitionNative = "Быстрый проход игрока мимо защитников прямо на вратаря.",
            example = "Her breakaway ended with a brilliant goal in the corner.",
            exampleNative = "Молниеносный breakaway закончился голом в дальний угол.",
            transliteration = "[ˈbreɪkəˌweɪ]",
            pos = "noun", semanticGroup = "sports_match_analysis", fillInBlankExclusions = listOf(31514L, 31515L)),

        WordEntity(id = 31518, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "stoppage time", translation = "добавленное время",
            definition = "Extra minutes added at the end because of pauses in the match.",
            definitionNative = "Дополнительные минуты в конце тайма — компенсация за остановки.",
            example = "The winner came deep into stoppage time last night.",
            exampleNative = "Победный гол в stoppage time вывел команду в плей-офф.",
            transliteration = "[ˈstɑpɪʤ taɪm]",
            pos = "phrase", semanticGroup = "sports_match_analysis", fillInBlankExclusions = listOf(31516L, 31519L)),

        WordEntity(id = 31519, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "clean sheet", translation = "сухой матч вратаря",
            definition = "A match where one team does not let the other team score.",
            definitionNative = "Матч, в котором вратарь и защита не пропустили ни одного гола.",
            example = "Our keeper kept his fifth clean sheet of the month.",
            exampleNative = "Пятый clean sheet подряд — отличный результат вратаря.",
            transliteration = "[klin ʃit]",
            pos = "phrase", semanticGroup = "sports_match_analysis", fillInBlankExclusions = listOf(31516L, 31518L)),

        // ── Group: sports_pro_training (6 words) ────────────────────────────

        WordEntity(id = 31520, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "periodization", translation = "периодизация тренировок",
            definition = "A long plan that splits the year into phases with different goals.",
            definitionNative = "Долгосрочный план: год делится на фазы с разными задачами тренировки.",
            example = "Good periodization helps athletes peak right at the main event.",
            exampleNative = "Грамотная periodization подводит атлета к пику на главный старт.",
            transliteration = "[ˌpɪriədəˈzeɪʃən]",
            pos = "noun", semanticGroup = "sports_pro_training", fillInBlankExclusions = listOf(31521L, 31522L, 31523L, 31525L)),

        WordEntity(id = 31521, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "plyometrics", translation = "плиометрика",
            definition = "Jumping drills that make muscles react fast and powerfully.",
            definitionNative = "Прыжковые упражнения, которые учат мышцы работать быстро и взрывно.",
            example = "His coach added plyometrics to build explosive power.",
            exampleNative = "Интенсивный plyometrics развивает взрывную силу ног.",
            transliteration = "[ˌplaɪəˈmɛtrɪks]",
            pos = "noun", semanticGroup = "sports_pro_training", fillInBlankExclusions = listOf(31520L, 31522L, 31523L, 31525L)),

        WordEntity(id = 31522, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "proprioception", translation = "проприоцепция / чувство тела",
            definition = "Your body's sense of where its own parts are in space.",
            definitionNative = "Внутреннее ощущение, где находятся твои руки, ноги и корпус.",
            example = "Balance drills sharpen proprioception after a long injury.",
            exampleNative = "После травмы колена тренируем proprioception на подушке.",
            transliteration = "[ˌproʊpriəˈsɛpʃən]",
            pos = "noun", semanticGroup = "sports_pro_training", fillInBlankExclusions = listOf(31520L, 31521L, 31523L, 31525L)),

        WordEntity(id = 31523, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hypertrophy", translation = "гипертрофия мышц",
            definition = "The growth of muscle size caused by the right kind of training.",
            definitionNative = "Рост объёма мышечных волокон от правильной силовой работы.",
            example = "The program targets hypertrophy with high-rep weight sessions.",
            exampleNative = "Эта программа на hypertrophy строится на многоповторных подходах.",
            transliteration = "[haɪˈpɜrtrəfi]",
            pos = "noun", semanticGroup = "sports_pro_training", fillInBlankExclusions = listOf(31520L, 31521L, 31522L, 31525L)),

        WordEntity(id = 31524, setId = 315, languagePair = "en-ru", rarity = "EPIC",
            original = "VO2 max", translation = "максимальное потребление кислорода",
            definition = "The top amount of air your body can use during hard effort.",
            definitionNative = "Максимум кислорода, который организм способен усвоить при нагрузке.",
            example = "Interval runs slowly raised his VO2 max over six weeks.",
            exampleNative = "Показатель VO2 max вырос после двух месяцев интервальных тренировок.",
            transliteration = "[ˌvi oʊ ˈtu mæks]",
            pos = "phrase", semanticGroup = "sports_pro_training"),

        WordEntity(id = 31525, setId = 315, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "deload", translation = "разгрузочная неделя",
            definition = "A lighter training week so the body can recover before pushing again.",
            definitionNative = "Лёгкая неделя в плане — телу даётся восстановиться перед новым рывком.",
            example = "Every fourth week is a deload to prevent overtraining.",
            exampleNative = "Каждую четвёртую неделю атлет уходит в deload.",
            transliteration = "[diˈloʊd]",
            pos = "noun", semanticGroup = "sports_pro_training", fillInBlankExclusions = listOf(31520L, 31521L, 31522L, 31523L)),
    )
}
