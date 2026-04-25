package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Повседневная жизнь (level 3, углублённый).
 *
 * Set 327: «Повседневная жизнь: углублённый» — B2-лексика быта:
 * бытовые глаголы с эмоциональным оттенком, тонкие описания состояний,
 * носительские concept'ы и разговорные дескрипторы.
 *
 * Распределение редкости: 7 UNCOMMON + 18 RARE — два смежных уровня шкалы (B1→B2).
 *
 * Дополняет уже существующие сеты темы «Повседневная жизнь»:
 *   - Set 25  (WordDataEnglish.kt)         — L2 UNCOMMON (привычки, расписание).
 *   - Set 256 (WordDataEnglishBatch5.kt)   — L2 COMMON/UNCOMMON (распорядок дня).
 *   - Set 265 (WordDataEnglishBatch8.kt)   — L1 COMMON/UNCOMMON (месяцы, сезоны, погода).
 *
 * Слова setId=327 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   everyday_actions       — linger, dawdle, fidget, slouch, fumble
 *   everyday_emotions      — grumpy, nostalgic, restless, sheepish, smug
 *   everyday_descriptions  — tedious, dreary, mundane, sluggish, cosy
 *   everyday_concepts      — leftover, knack, hassle, quirk, hunch
 *   everyday_movement      — mingle, hover, browse, stroll, tinker
 *
 * Word IDs: 32701..32725 (setId × 100 + position).
 */
object WordDataEnglishEverydayL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 327, name = "Повседневная жизнь",
            description = "Углублённая лексика быта: тонкие действия, эмоциональные оттенки, разговорные обороты",
            languagePair = "en-ru",
            topic = "Повседневная жизнь", level = 3),
    )

    val words: List<WordEntity> = listOf(

        // ── everyday_actions (5) ─────────────────────────────────────────

        WordEntity(id = 32701, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "linger", transliteration = "[ˈlɪŋɡər]", translation = "задерживаться, медлить",
            definition = "To stay somewhere a little longer than needed — out of pleasure or hesitation.",
            definitionNative = "Остаться где-то чуть дольше нужного — из удовольствия или сомнения.",
            example = "We tend to linger over coffee on lazy Sunday mornings.",
            exampleNative = "В выходные мы любим linger за чашкой кофе на кухне.",
            pos = "verb", semanticGroup = "everyday_actions", fillInBlankExclusions = listOf(32702L, 32703L, 32704L, 32705L, 32721L)),

        WordEntity(id = 32702, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "dawdle", transliteration = "[ˈdɔːdəl]", translation = "копаться, мешкать",
            definition = "To move or do something slowly, wasting time on the way.",
            definitionNative = "Двигаться или делать что-то лениво и медленно, теряя время впустую.",
            example = "Don't dawdle on the way to school — the bus leaves at eight.",
            exampleNative = "Не нужно dawdle по дороге в школу — автобус ждать не будет.",
            pos = "verb", semanticGroup = "everyday_actions", fillInBlankExclusions = listOf(32701L, 32703L, 32704L, 32705L, 32724L)),

        WordEntity(id = 32703, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "fidget", transliteration = "[ˈfɪdʒɪt]", translation = "ёрзать, теребить",
            definition = "To make small restless movements with hands or body when bored.",
            definitionNative = "Совершать мелкие беспокойные движения руками или телом от скуки.",
            example = "He began to fidget with a pen during the long meeting.",
            exampleNative = "От скуки он стал fidget ручкой на затянувшемся совещании.",
            pos = "verb", semanticGroup = "everyday_actions", fillInBlankExclusions = listOf(32701L, 32702L, 32704L, 32705L, 32725L)),

        WordEntity(id = 32704, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "slouch", transliteration = "[slaʊtʃ]", translation = "сутулиться, развалиться",
            definition = "To stand or sit with rounded shoulders and a curved back.",
            definitionNative = "Стоять или сидеть с округлёнными плечами и согнутой спиной.",
            example = "Try not to slouch when you sit at your desk all day.",
            exampleNative = "Старайся не slouch, когда работаешь за столом весь день.",
            pos = "verb", semanticGroup = "everyday_actions", fillInBlankExclusions = listOf(32701L, 32702L, 32703L, 32705L)),

        WordEntity(id = 32705, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "fumble", transliteration = "[ˈfʌmbəl]", translation = "неловко возиться, шарить",
            definition = "To handle something clumsily — usually because hands are cold or nervous.",
            definitionNative = "Неуклюже что-то перебирать руками — от холода или волнения.",
            example = "She had to fumble in her bag for the house keys.",
            exampleNative = "Ей пришлось fumble в сумке в поисках ключей от квартиры.",
            pos = "verb", semanticGroup = "everyday_actions", fillInBlankExclusions = listOf(32701L, 32702L, 32703L, 32704L, 32723L)),

        // ── everyday_emotions (5) ────────────────────────────────────────

        WordEntity(id = 32706, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "grumpy", transliteration = "[ˈɡrʌmpi]", translation = "ворчливый, угрюмый",
            definition = "Easily annoyed and short-tempered — usually for no clear reason.",
            definitionNative = "Легко раздражающийся и резкий — обычно без видимой причины.",
            example = "Dad gets grumpy if he hasn't had his morning coffee yet.",
            exampleNative = "Папа становится grumpy, пока не выпьет утренний кофе.",
            pos = "adjective", semanticGroup = "everyday_emotions", fillInBlankExclusions = listOf(32707L, 32708L, 32709L, 32710L, 32714L)),

        WordEntity(id = 32707, setId = 327, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "nostalgic", transliteration = "[nɒˈstældʒɪk]", translation = "ностальгический",
            definition = "Filled with a soft, sad longing for happy moments from the past.",
            definitionNative = "Полный мягкой грустной тоски по счастливым мгновениям из прошлого.",
            example = "Old songs from the nineties make me feel nostalgic about school.",
            exampleNative = "Старые песни девяностых вызывают nostalgic чувства о школе.",
            pos = "adjective", semanticGroup = "everyday_emotions", fillInBlankExclusions = listOf(32706L, 32708L, 32709L, 32710L)),

        WordEntity(id = 32708, setId = 327, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "restless", transliteration = "[ˈrestləs]", translation = "беспокойный, неугомонный",
            definition = "Unable to relax or stay still — full of nervous energy you can't release.",
            definitionNative = "Не способный расслабиться или сидеть на месте — полный нервной энергии.",
            example = "The children were restless after sitting in the car for six hours.",
            exampleNative = "Дети стали restless, просидев в машине шесть часов подряд.",
            pos = "adjective", semanticGroup = "everyday_emotions", fillInBlankExclusions = listOf(32706L, 32707L, 32709L, 32710L, 32714L)),

        WordEntity(id = 32709, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "sheepish", transliteration = "[ˈʃiːpɪʃ]", translation = "сконфуженный, смущённый",
            definition = "Looking embarrassed because you have done something silly or wrong.",
            definitionNative = "С виноватым видом — из-за глупого или нелепого поступка.",
            example = "He gave a sheepish smile after spilling juice all over the floor.",
            exampleNative = "Он улыбнулся sheepish, разлив сок по всему полу.",
            pos = "adjective", semanticGroup = "everyday_emotions", fillInBlankExclusions = listOf(32706L, 32707L, 32708L, 32710L)),

        WordEntity(id = 32710, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "smug", transliteration = "[smʌɡ]", translation = "самодовольный",
            definition = "Too pleased with yourself in a way that annoys other people.",
            definitionNative = "Излишне довольный собой так, что это раздражает окружающих.",
            example = "Stop looking so smug just because you guessed the answer first.",
            exampleNative = "Перестань быть таким smug — ты просто угадал первым.",
            pos = "adjective", semanticGroup = "everyday_emotions", fillInBlankExclusions = listOf(32706L, 32707L, 32708L, 32709L)),

        // ── everyday_descriptions (5) ────────────────────────────────────

        WordEntity(id = 32711, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "tedious", transliteration = "[ˈtiːdiəs]", translation = "нудный, утомительный",
            definition = "Boring and slow because it goes on too long without any change.",
            definitionNative = "Скучный и тягучий — слишком долгий и однообразный, без перемен.",
            example = "Filling out tax forms is the most tedious part of every spring.",
            exampleNative = "Заполнять налоговые формы — самая tedious часть весны.",
            pos = "adjective", semanticGroup = "everyday_descriptions", fillInBlankExclusions = listOf(32712L, 32713L, 32714L, 32715L)),

        WordEntity(id = 32712, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "dreary", transliteration = "[ˈdrɪəri]", translation = "унылый, безрадостный",
            definition = "Dull, grey and a little sad — like a rainy day with no sunlight.",
            definitionNative = "Тоскливый, серый и немного печальный — как дождливый день без солнца.",
            example = "November in Saint Petersburg can feel dreary without enough daylight.",
            exampleNative = "Ноябрь в Питере бывает dreary из-за нехватки дневного света.",
            pos = "adjective", semanticGroup = "everyday_descriptions", fillInBlankExclusions = listOf(32711L, 32713L, 32714L, 32715L)),

        WordEntity(id = 32713, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "mundane", transliteration = "[mʌnˈdeɪn]", translation = "будничный, прозаичный",
            definition = "Ordinary and dull — about everyday things, not exciting or special.",
            definitionNative = "Обыкновенный и пресный — о повседневных вещах, без яркости или особости.",
            example = "Even the most mundane chores feel lighter with good music on.",
            exampleNative = "Даже самые mundane дела идут легче под хорошую музыку.",
            pos = "adjective", semanticGroup = "everyday_descriptions", fillInBlankExclusions = listOf(32711L, 32712L, 32714L, 32715L)),

        WordEntity(id = 32714, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "sluggish", transliteration = "[ˈslʌɡɪʃ]", translation = "вялый, заторможенный",
            definition = "Moving or thinking slowly — without the usual energy or speed.",
            definitionNative = "Двигающийся или соображающий медленно — без обычной энергии и темпа.",
            example = "I always feel sluggish on Monday mornings before any coffee.",
            exampleNative = "Утром в понедельник я всегда sluggish, пока не выпью кофе.",
            pos = "adjective", semanticGroup = "everyday_descriptions", fillInBlankExclusions = listOf(32706L, 32708L, 32711L, 32712L, 32713L, 32715L)),

        WordEntity(id = 32715, setId = 327, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cosy", transliteration = "[ˈkəʊzi]", translation = "уютный",
            definition = "Warm, soft and pleasant — like a small room with blankets and candles.",
            definitionNative = "Тёплый, мягкий и приятный — как маленькая комната с пледом и свечами.",
            example = "We curled up in a cosy corner of the cafe with two big mugs.",
            exampleNative = "Мы устроились в cosy уголке кафе с двумя большими кружками.",
            pos = "adjective", semanticGroup = "everyday_descriptions", fillInBlankExclusions = listOf(32711L, 32712L, 32713L, 32714L)),

        // ── everyday_concepts (5) ────────────────────────────────────────

        WordEntity(id = 32716, setId = 327, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "leftover", transliteration = "[ˈleftˌəʊvər]", translation = "остаток еды (с прошлого приёма)",
            definition = "Food not eaten at a meal that you keep for the next day.",
            definitionNative = "Еда, не съеденная за трапезой, которую оставили на следующий день.",
            example = "I packed the leftover from dinner for tomorrow's lunch.",
            exampleNative = "Я упаковал leftover с ужина в контейнер на завтрашний обед.",
            pos = "noun", semanticGroup = "everyday_concepts", fillInBlankExclusions = listOf(32717L, 32718L, 32719L, 32720L)),

        WordEntity(id = 32717, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "knack", transliteration = "[næk]", translation = "сноровка, особое умение",
            definition = "A natural talent for doing something well — without much training.",
            definitionNative = "Природное умение делать что-то хорошо — без особой подготовки.",
            example = "She has a real knack for making strangers feel welcome.",
            exampleNative = "У неё есть настоящий knack располагать к себе незнакомцев.",
            pos = "noun", semanticGroup = "everyday_concepts", fillInBlankExclusions = listOf(32716L, 32718L, 32719L, 32720L)),

        WordEntity(id = 32718, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "hassle", transliteration = "[ˈhæsəl]", translation = "морока, хлопоты",
            definition = "An annoying task that takes much more effort than it should.",
            definitionNative = "Раздражающее дело, требующее куда больше усилий, чем должно бы.",
            example = "Returning the broken kettle was such a hassle — three trips to the shop.",
            exampleNative = "Вернуть сломанный чайник было такой hassle — три визита в магазин.",
            pos = "noun", semanticGroup = "everyday_concepts", fillInBlankExclusions = listOf(32716L, 32717L, 32719L, 32720L)),

        WordEntity(id = 32719, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "quirk", transliteration = "[kwɜːrk]", translation = "причуда, странность",
            definition = "An odd little habit or feature that makes someone unique.",
            definitionNative = "Маленькая забавная привычка или черта, делающая человека особенным.",
            example = "One quirk of my grandmother is always humming while she cooks.",
            exampleNative = "Одна quirk моей бабушки — мурлыкать себе под нос за готовкой.",
            pos = "noun", semanticGroup = "everyday_concepts", fillInBlankExclusions = listOf(32716L, 32717L, 32718L, 32720L)),

        WordEntity(id = 32720, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "hunch", transliteration = "[hʌntʃ]", translation = "предчувствие, догадка",
            definition = "A feeling that something is true even without clear proof.",
            definitionNative = "Ощущение, что что-то верно, даже без ясных доказательств.",
            example = "I have a hunch that he forgot about our plans tonight.",
            exampleNative = "У меня hunch, что он забыл о наших планах на сегодня.",
            pos = "noun", semanticGroup = "everyday_concepts", fillInBlankExclusions = listOf(32716L, 32717L, 32718L, 32719L)),

        // ── everyday_movement (5) ────────────────────────────────────────

        WordEntity(id = 32721, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "mingle", transliteration = "[ˈmɪŋɡəl]", translation = "общаться (на вечеринке), смешиваться",
            definition = "To move around at a party and chat briefly with many people.",
            definitionNative = "Ходить по вечеринке и коротко болтать со многими гостями.",
            example = "Try to mingle with the other guests instead of hiding in the corner.",
            exampleNative = "Постарайся mingle с гостями, а не отсиживаться в углу.",
            pos = "verb", semanticGroup = "everyday_movement", fillInBlankExclusions = listOf(32701L, 32722L, 32723L, 32724L, 32725L)),

        WordEntity(id = 32722, setId = 327, languagePair = "en-ru", rarity = "RARE",
            original = "hover", transliteration = "[ˈhɒvər]", translation = "топтаться рядом, нависать",
            definition = "To stay close to someone in a way that feels watchful or anxious.",
            definitionNative = "Держаться возле кого-то — настороженно или беспокойно следя.",
            example = "Stop trying to hover over me while I'm cooking dinner.",
            exampleNative = "Перестань hover у меня над душой, пока я готовлю ужин.",
            pos = "verb", semanticGroup = "everyday_movement", fillInBlankExclusions = listOf(32701L, 32721L, 32723L, 32724L, 32725L)),

        WordEntity(id = 32723, setId = 327, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "browse", transliteration = "[braʊz]", translation = "разглядывать (без цели)",
            definition = "To look around a shop or website without planning to buy anything.",
            definitionNative = "Бродить по магазину или сайту без намерения что-то купить.",
            example = "I love to browse second-hand shops on rainy weekends.",
            exampleNative = "В дождливые выходные я люблю browse по комиссионкам.",
            pos = "verb", semanticGroup = "everyday_movement", fillInBlankExclusions = listOf(32721L, 32722L, 32724L, 32725L)),

        WordEntity(id = 32724, setId = 327, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "stroll", transliteration = "[strəʊl]", translation = "прогуливаться неспешно",
            definition = "To walk slowly and calmly for pleasure, not in a hurry.",
            definitionNative = "Идти медленно и спокойно ради удовольствия, никуда не торопясь.",
            example = "Couples like to stroll along the river after dinner.",
            exampleNative = "Парам нравится stroll вдоль реки после ужина.",
            pos = "verb", semanticGroup = "everyday_movement", fillInBlankExclusions = listOf(32701L, 32702L, 32721L, 32722L, 32723L, 32725L)),

        WordEntity(id = 32725, setId = 327, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tinker", transliteration = "[ˈtɪŋkər]", translation = "возиться с (чинить, налаживать)",
            definition = "To make small adjustments to a machine or object — often for fun.",
            definitionNative = "Подкручивать и подлаживать механизм или вещь — часто ради удовольствия.",
            example = "Grandpa likes to tinker with old radios in the garage.",
            exampleNative = "Дед любит tinker со старыми радиоприёмниками в гараже.",
            pos = "verb", semanticGroup = "everyday_movement", fillInBlankExclusions = listOf(32703L, 32705L, 32721L, 32722L, 32723L, 32724L)),
    )
}
