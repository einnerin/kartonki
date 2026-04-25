package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Дом и быт (level 5, носитель языка).
 *
 * Set 318: «Дом и быт: носитель языка» — утончённый и литературный лексикон
 * бытовой жизни: атмосфера старого дома, антиквариат, домашние традиции,
 * прислуга и предметы дореволюционного интерьера (C1-C2+).
 *
 * Распределение редкости: 18 LEGENDARY + 7 EPIC — два смежных уровня шкалы.
 *
 * Дополняет уже существующие сеты темы «Дом и быт»:
 *   - Set 13, 16  (WordDataEnglish.kt)            — L1 COMMON.
 *   - Set 200, 201, 204, 208, 240, 241, 244, 246  (WordDataEnglishExpanded.kt)
 *     — L1-L4 COMMON/UNCOMMON/RARE/EPIC.
 *   - Set 270, 271 (WordDataEnglishBatch9/10.kt)  — L1 COMMON.
 *
 * Слова setId=318 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   home_furnishings    — settle, valance, antimacassar, ottoman, chiffonier
 *   home_rooms          — scullery, larder, parlour, withdrawing room, vestibule
 *   home_architecture   — panelling, sconce, mantelpiece, escutcheon, anteroom
 *   home_servants       — chatelaine, scullion, chambermaid, butler, footman
 *   home_atmosphere     — samovar, decanter, tureen, chinoiserie, hearthside
 *
 * Word IDs: 31801..31825 (setId × 100 + position).
 */
object WordDataEnglishHomeL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 318, name = "Дом и быт",
            description = "Утончённый и литературный лексикон бытовой жизни: атмосфера, антиквариат, домашние традиции",
            languagePair = "en-ru",
            orderIndex = 138,
            topic = "Дом и быт", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── home_furnishings (5) ───────────────────────────────────────────

        WordEntity(id = 31801, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "settle", transliteration = "[ˈsɛtəl]", translation = "старинная скамья со спинкой и подлокотниками",
            definition = "A long wooden bench with a high back and arms — a fixture of old country kitchens.",
            definitionNative = "Длинная деревянная лавка с высокой спинкой и боковинами — деталь старых деревенских кухонь.",
            example = "Grandfather dozed on the oak settle by the kitchen fire all afternoon.",
            exampleNative = "Дед дремал на дубовой settle у кухонного очага весь день.",
            pos = "noun", semanticGroup = "home_furnishings", fillInBlankExclusions = listOf(31802L, 31803L, 31804L, 31805L)),

        WordEntity(id = 31802, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "valance", transliteration = "[ˈvæləns]", translation = "тканевый подзор для кровати или окна",
            definition = "A short fabric drape that hides the frame of a bed or the rod of a curtain.",
            definitionNative = "Короткая декоративная драпировка, прикрывающая раму кровати или карниз окна.",
            example = "Mother sewed a lace valance for the four-poster in the guest room.",
            exampleNative = "Мама сшила кружевной valance для кровати с балдахином в гостевой.",
            pos = "noun", semanticGroup = "home_furnishings", fillInBlankExclusions = listOf(31801L, 31803L, 31804L, 31805L)),

        WordEntity(id = 31803, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "antimacassar", transliteration = "[ˌæntiməˈkæsər]", translation = "накидка на спинку кресла от помады для волос",
            definition = "A small cloth pinned to a chair back to keep hair oil from staining the fabric.",
            definitionNative = "Маленькая ткань на спинке кресла, защищающая обивку от помады для волос.",
            example = "Aunt Edith embroidered a fresh antimacassar for every armchair in the parlour.",
            exampleNative = "Тётя Эдит вышила новый antimacassar для каждого кресла в гостиной.",
            pos = "noun", semanticGroup = "home_furnishings", fillInBlankExclusions = listOf(31801L, 31802L, 31804L, 31805L)),

        WordEntity(id = 31804, setId = 318, languagePair = "en-ru", rarity = "EPIC",
            original = "ottoman", transliteration = "[ˈɑtəmən]", translation = "оттоманка (мягкий пуф без спинки)",
            definition = "A padded low seat without back or arms — used as a footrest or extra perch.",
            definitionNative = "Мягкое низкое сиденье без спинки и подлокотников — служит подставкой для ног.",
            example = "She kicked off her slippers and propped her feet on the velvet ottoman.",
            exampleNative = "Она сбросила тапочки и закинула ноги на бархатный ottoman.",
            pos = "noun", semanticGroup = "home_furnishings", fillInBlankExclusions = listOf(31801L, 31802L, 31803L, 31805L)),

        WordEntity(id = 31805, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "chiffonier", transliteration = "[ˌʃɪfəˈnɪr]", translation = "высокий узкий комод с ящиками",
            definition = "A tall narrow chest of drawers — fashionable for a lady's bedroom in older times.",
            definitionNative = "Высокий и узкий комод с ящиками — модный предмет в дамской спальне старых времён.",
            example = "Her wedding linens lay folded inside the rosewood chiffonier for decades.",
            exampleNative = "Свадебное бельё лежало сложенным в палисандровом chiffonier долгие годы.",
            pos = "noun", semanticGroup = "home_furnishings", fillInBlankExclusions = listOf(31801L, 31802L, 31803L, 31804L)),

        // ── home_rooms (5) ─────────────────────────────────────────────────

        WordEntity(id = 31806, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "scullery", transliteration = "[ˈskʌləri]", translation = "судомойня (чулан при кухне)",
            definition = "A small back room beside the kitchen for washing dishes and rough chores.",
            definitionNative = "Маленькая комната рядом с кухней — для мытья посуды и грязной работы.",
            example = "The maid scrubbed copper pans in the dim scullery from dawn till dusk.",
            exampleNative = "Служанка драила медные кастрюли в полутёмной scullery с утра до вечера.",
            pos = "noun", semanticGroup = "home_rooms", fillInBlankExclusions = listOf(31807L, 31808L, 31809L, 31810L, 31815L)),

        WordEntity(id = 31807, setId = 318, languagePair = "en-ru", rarity = "EPIC",
            original = "larder", transliteration = "[ˈlɑrdər]", translation = "кладовая для провизии",
            definition = "A cool cupboard or small room where meat, butter and supplies are kept.",
            definitionNative = "Прохладный шкаф или комнатка, где хранят мясо, масло и припасы.",
            example = "Hams hung from hooks in the cold stone larder beside the cellar door.",
            exampleNative = "Окорока висели на крюках в холодной каменной larder у дверей погреба.",
            pos = "noun", semanticGroup = "home_rooms", fillInBlankExclusions = listOf(31806L, 31808L, 31809L, 31810L, 31815L)),

        WordEntity(id = 31808, setId = 318, languagePair = "en-ru", rarity = "EPIC",
            original = "parlour", transliteration = "[ˈpɑrlər]", translation = "малая гостиная (для приёма гостей)",
            definition = "The best front room of an old house — kept tidy for guests and Sunday tea.",
            definitionNative = "Лучшая передняя комната в старом доме — для гостей и воскресного чая.",
            example = "Visitors waited in the formal parlour while the housekeeper fetched cake.",
            exampleNative = "Посетители ждали в парадном parlour, пока экономка несла торт.",
            pos = "noun", semanticGroup = "home_rooms", fillInBlankExclusions = listOf(31806L, 31807L, 31809L, 31810L, 31815L)),

        WordEntity(id = 31809, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "withdrawing room", transliteration = "[wɪðˈdrɔɪŋ rum]", translation = "дамская гостиная (куда уходят дамы после ужина)",
            definition = "A room into which the ladies retired after dinner, leaving the men to port.",
            definitionNative = "Комната, куда дамы уходили после ужина, оставив мужчин с портвейном.",
            example = "The countess led her guests to the withdrawing room for coffee and cards.",
            exampleNative = "Графиня повела гостей в withdrawing room на кофе и карты.",
            pos = "noun", semanticGroup = "home_rooms", fillInBlankExclusions = listOf(31806L, 31807L, 31808L, 31810L, 31815L, 31825L)),

        WordEntity(id = 31810, setId = 318, languagePair = "en-ru", rarity = "EPIC",
            original = "vestibule", transliteration = "[ˈvɛstəˌbjul]", translation = "вестибюль (входной зал)",
            definition = "A small enclosed entrance space between the front door and the rest of the house.",
            definitionNative = "Небольшое закрытое пространство между входной дверью и остальным домом.",
            example = "Wet umbrellas dripped quietly in the marble vestibule of the old hotel.",
            exampleNative = "Мокрые зонты тихо капали в мраморный vestibule старого отеля.",
            pos = "noun", semanticGroup = "home_rooms", fillInBlankExclusions = listOf(31806L, 31807L, 31808L, 31809L, 31815L)),

        // ── home_architecture (5) ──────────────────────────────────────────

        WordEntity(id = 31811, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "panelling", transliteration = "[ˈpænəlɪŋ]", translation = "деревянная обшивка стен",
            definition = "Wooden boards fitted to a wall as decoration — often dark oak in old halls.",
            definitionNative = "Деревянные доски на стене как украшение — часто тёмный дуб в старых залах.",
            example = "The library walls were lined with carved oak panelling from the Tudor era.",
            exampleNative = "Стены библиотеки были покрыты резной дубовой panelling эпохи Тюдоров.",
            pos = "noun", semanticGroup = "home_architecture", fillInBlankExclusions = listOf(31812L, 31813L, 31814L, 31815L)),

        WordEntity(id = 31812, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sconce", transliteration = "[skɑns]", translation = "настенный канделябр",
            definition = "A bracket fixed to a wall holding a candle or a lamp — common before electric lights.",
            definitionNative = "Кронштейн на стене, держащий свечу или лампу — обычен до прихода электричества.",
            example = "Brass sconce flickered along the corridor, throwing shadows on the portraits.",
            exampleNative = "Латунный sconce мерцал вдоль коридора, бросая тени на портреты.",
            pos = "noun", semanticGroup = "home_architecture", fillInBlankExclusions = listOf(31811L, 31813L, 31814L, 31815L)),

        WordEntity(id = 31813, setId = 318, languagePair = "en-ru", rarity = "EPIC",
            original = "mantelpiece", transliteration = "[ˈmæntəlˌpis]", translation = "каминная полка",
            definition = "The shelf above a fireplace — where the clock and family photographs stand.",
            definitionNative = "Полка над камином — на ней стоят часы и семейные фотографии.",
            example = "A bronze clock ticked softly on the mantelpiece above the dying fire.",
            exampleNative = "Бронзовые часы тихо тикали на mantelpiece над угасающим огнём.",
            pos = "noun", semanticGroup = "home_architecture", fillInBlankExclusions = listOf(31811L, 31812L, 31814L, 31815L)),

        WordEntity(id = 31814, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "escutcheon", transliteration = "[ɪˈskʌtʃən]", translation = "декоративная накладка вокруг замочной скважины",
            definition = "A small ornamental plate fixed around a keyhole or door handle for protection.",
            definitionNative = "Маленькая декоративная пластина вокруг замочной скважины или ручки двери.",
            example = "A polished brass escutcheon framed the keyhole of the heavy front door.",
            exampleNative = "Полированный латунный escutcheon обрамлял скважину тяжёлой парадной двери.",
            pos = "noun", semanticGroup = "home_architecture", fillInBlankExclusions = listOf(31811L, 31812L, 31813L, 31815L)),

        WordEntity(id = 31815, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "anteroom", transliteration = "[ˈæntiˌrum]", translation = "приёмная (комнатка перед главной)",
            definition = "A small room leading into a larger one — where visitors waited to be received.",
            definitionNative = "Маленькая комната, ведущая в бо́льшую — где посетители ждали приёма.",
            example = "Petitioners shivered in the cold anteroom for hours before seeing the duke.",
            exampleNative = "Просители мёрзли в холодной anteroom часами, пока не примет герцог.",
            pos = "noun", semanticGroup = "home_architecture", fillInBlankExclusions = listOf(31808L, 31809L, 31810L, 31811L, 31812L, 31813L, 31814L)),

        // ── home_servants (5) ──────────────────────────────────────────────

        WordEntity(id = 31816, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "chatelaine", transliteration = "[ˈʃætəˌleɪn]", translation = "хозяйка большого дома (с ключами на поясе)",
            definition = "The mistress of a great house, who carried the household keys at her belt.",
            definitionNative = "Госпожа большого дома, носившая связку ключей от хозяйства на поясе.",
            example = "As chatelaine of the manor, she rose at dawn to inspect every room.",
            exampleNative = "Как chatelaine поместья, она вставала на рассвете и обходила каждую комнату.",
            pos = "noun", semanticGroup = "home_servants", fillInBlankExclusions = listOf(31817L, 31818L, 31819L, 31820L)),

        WordEntity(id = 31817, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "scullion", transliteration = "[ˈskʌljən]", translation = "кухонный мальчик (мывший посуду)",
            definition = "The lowest kitchen helper in an old household — washed pots and ran errands.",
            definitionNative = "Самый младший помощник на кухне старого дома — мыл котлы и бегал по поручениям.",
            example = "The ragged scullion slept on a straw pallet behind the bread oven.",
            exampleNative = "Оборванный scullion спал на соломенном тюфяке за хлебной печью.",
            pos = "noun", semanticGroup = "home_servants", fillInBlankExclusions = listOf(31816L, 31818L, 31819L, 31820L)),

        WordEntity(id = 31818, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "chambermaid", transliteration = "[ˈtʃeɪmbərˌmeɪd]", translation = "горничная (убирающая спальни)",
            definition = "A female servant who tidied the bedrooms and lit the morning fires.",
            definitionNative = "Служанка, убиравшая спальни и разжигавшая утром огонь в каминах.",
            example = "The young chambermaid carried fresh linen up the back stairs at sunrise.",
            exampleNative = "Молодая chambermaid несла свежее бельё по чёрной лестнице на рассвете.",
            pos = "noun", semanticGroup = "home_servants", fillInBlankExclusions = listOf(31816L, 31817L, 31819L, 31820L)),

        WordEntity(id = 31819, setId = 318, languagePair = "en-ru", rarity = "EPIC",
            original = "butler", transliteration = "[ˈbʌtlər]", translation = "дворецкий",
            definition = "The chief male servant of a wealthy house, in charge of the wine and dining.",
            definitionNative = "Главный мужской слуга в богатом доме, ведавший вином и столом.",
            example = "The butler announced each guest in a grave voice from the doorway.",
            exampleNative = "Butler торжественным голосом объявлял каждого гостя от входа.",
            pos = "noun", semanticGroup = "home_servants", fillInBlankExclusions = listOf(31816L, 31817L, 31818L, 31820L)),

        WordEntity(id = 31820, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "footman", transliteration = "[ˈfʊtmən]", translation = "лакей в ливрее",
            definition = "A liveried male servant who waited at table and stood by the carriage door.",
            definitionNative = "Слуга в ливрее, прислуживавший за столом и встречавший экипаж у дверей.",
            example = "A powdered footman opened the carriage door for the dowager countess.",
            exampleNative = "Напудренный footman открыл дверцу кареты для вдовствующей графини.",
            pos = "noun", semanticGroup = "home_servants", fillInBlankExclusions = listOf(31816L, 31817L, 31818L, 31819L)),

        // ── home_atmosphere (5) ────────────────────────────────────────────

        WordEntity(id = 31821, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "samovar", transliteration = "[ˈsæməˌvɑr]", translation = "самовар (русский латунный сосуд для чая)",
            definition = "A heated metal urn with a tap, used in old Russian homes to brew strong tea.",
            definitionNative = "Нагреваемый металлический сосуд с краном — в нём в русских домах заваривали крепкий чай.",
            example = "The brass samovar hissed gently on the table all through the long evening.",
            exampleNative = "Латунный samovar тихо шипел на столе весь долгий вечер.",
            pos = "noun", semanticGroup = "home_atmosphere", fillInBlankExclusions = listOf(31822L, 31823L, 31824L, 31825L)),

        WordEntity(id = 31822, setId = 318, languagePair = "en-ru", rarity = "EPIC",
            original = "decanter", transliteration = "[dɪˈkæntər]", translation = "графин для вина",
            definition = "A glass vessel into which wine is poured from the bottle to breathe before serving.",
            definitionNative = "Стеклянный сосуд, в который переливают вино из бутылки, чтобы оно подышало.",
            example = "He filled the crystal decanter with claret and set it beside the candles.",
            exampleNative = "Он наполнил хрустальный decanter бордо и поставил рядом со свечами.",
            pos = "noun", semanticGroup = "home_atmosphere", fillInBlankExclusions = listOf(31821L, 31823L, 31824L, 31825L)),

        WordEntity(id = 31823, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tureen", transliteration = "[təˈrin]", translation = "супница (с крышкой, для сервировки)",
            definition = "A deep covered dish from which soup or stew is served at the dinner table.",
            definitionNative = "Глубокое блюдо с крышкой, из которого подают суп или рагу за обеденным столом.",
            example = "Steam rose from the porcelain tureen as it was carried to the table.",
            exampleNative = "Пар поднимался от фарфоровой tureen, когда её несли к столу.",
            pos = "noun", semanticGroup = "home_atmosphere", fillInBlankExclusions = listOf(31821L, 31822L, 31824L, 31825L)),

        WordEntity(id = 31824, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "chinoiserie", transliteration = "[ʃɪnˈwɑzəri]", translation = "шинуазри (европейский декор в восточном стиле)",
            definition = "A European decorative style imitating Chinese motifs — pagodas, dragons and willow.",
            definitionNative = "Европейский декор, подражающий китайским мотивам — пагоды, драконы, ивы.",
            example = "Painted chinoiserie panels covered the walls of the elegant drawing room.",
            exampleNative = "Расписные панели chinoiserie покрывали стены изящной гостиной.",
            pos = "noun", semanticGroup = "home_atmosphere", fillInBlankExclusions = listOf(31821L, 31822L, 31823L, 31825L)),

        WordEntity(id = 31825, setId = 318, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hearthside", transliteration = "[ˈhɑrθˌsaɪd]", translation = "место у домашнего очага",
            definition = "The cosy spot beside the fireplace — where families gathered on cold evenings.",
            definitionNative = "Уютное место рядом с камином — где семья собиралась холодными вечерами.",
            example = "Children listened to grandmother's stories at the hearthside every winter.",
            exampleNative = "Дети слушали бабушкины сказки у hearthside каждой зимой.",
            pos = "noun", semanticGroup = "home_atmosphere", fillInBlankExclusions = listOf(31821L, 31822L, 31823L, 31824L)),
    )
}
