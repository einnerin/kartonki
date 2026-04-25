package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Еда и кулинария (level 5, носитель языка).
 *
 * Set 320: «Еда и кулинария: носитель языка» — высокая гастрономия:
 * винодельческая лексика, дегустационная терминология, концепты haute cuisine,
 * редкие описательные прилагательные и литературные глаголы поглощения пищи.
 *
 * Распределение редкости: 22 LEGENDARY + 3 EPIC — два смежных уровня шкалы.
 *
 * Дополняет уже существующие сеты темы «Еда и кулинария»:
 *   - Set 262 (WordDataEnglishBatch7.kt)    — L1 COMMON/UNCOMMON, фрукты и ягоды.
 *   - Set 230 (WordDataEnglishExpanded.kt)  — L2, базовая кулинарная лексика.
 *   - Set 231 (WordDataEnglishExpanded.kt)  — L3, гастрономия (часть EPIC).
 *   - Set 319 (WordDataEnglishFoodL4.kt)    — L4 RARE/EPIC, техники готовки.
 *
 * L5 берёт более «литературную» зону темы: не техники готовки (это L4),
 * а культуру еды — вино, дегустация, гастрономические концепты, поэтика вкуса.
 *
 * SemanticGroups (5 × 5):
 *   food_oenology       — sommelier, terroir, decanter, varietal, tannin
 *   food_tasting        — palate, mouthfeel, finish, sapid, gustatory
 *   food_haute_cuisine  — degustation, prix-fixe, foie-gras, nouvelle, gastronomique
 *   food_descriptive    — ambrosial, palatable, succulent, piquant, unctuous
 *   food_literary_verbs — masticate, savour, imbibe, regale, sup
 *
 * Word IDs: 32001..32025 (setId × 100 + position).
 */
object WordDataEnglishFoodL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 320, name = "Еда и кулинария",
            description = "Высокая гастрономия: винодельческие термины, дегустационная лексика, экзотика",
            languagePair = "en-ru",
            topic = "Еда и кулинария", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── food_oenology (5) ─────────────────────────────────────────────

        WordEntity(id = 32001, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sommelier", transliteration = "[ˌsɑməlˈjeɪ]", translation = "сомелье (мастер по винам)",
            definition = "A trained restaurant expert who picks wines to match each dish.",
            definitionNative = "Ресторанный знаток, подбирающий вино под каждое блюдо.",
            example = "The sommelier suggested a crisp white to go with our grilled fish.",
            exampleNative = "Sommelier предложил свежее белое к нашей рыбе на гриле.",
            pos = "noun", semanticGroup = "food_oenology", fillInBlankExclusions = listOf(32002L, 32003L, 32004L, 32005L)),

        WordEntity(id = 32002, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "terroir", transliteration = "[tɛˈrwɑr]", translation = "терруар (характер места произрастания)",
            definition = "The unique flavour a wine takes from its soil, climate and slope.",
            definitionNative = "Уникальный вкус, который вино берёт от почвы, климата и склона.",
            example = "The vineyard's chalky terroir gave the bottle a flinty mineral edge.",
            exampleNative = "Меловой terroir виноградника придал бутылке кремнистый минеральный край.",
            pos = "noun", semanticGroup = "food_oenology", fillInBlankExclusions = listOf(32001L, 32003L, 32004L, 32005L)),

        WordEntity(id = 32003, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "decanter", transliteration = "[dɪˈkæntər]", translation = "декантер (графин для вина)",
            definition = "A wide glass vessel into which old wine is poured to breathe.",
            definitionNative = "Широкий стеклянный сосуд, куда переливают старое вино, чтобы оно подышало.",
            example = "He poured the dusty old red into a crystal decanter before dinner.",
            exampleNative = "Он перелил пыльное старое красное в хрустальный decanter перед ужином.",
            pos = "noun", semanticGroup = "food_oenology", fillInBlankExclusions = listOf(32001L, 32002L, 32004L, 32005L)),

        WordEntity(id = 32004, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "varietal", transliteration = "[vəˈraɪətəl]", translation = "сортовое вино (из одного сорта винограда)",
            definition = "A bottle made mostly from a single grape kind, named after that grape.",
            definitionNative = "Бутылка в основном из одного сорта винограда, названная по нему.",
            example = "This varietal is pure pinot noir from a small French estate.",
            exampleNative = "Этот varietal — чистое пино-нуар с маленького французского поместья.",
            pos = "noun", semanticGroup = "food_oenology", fillInBlankExclusions = listOf(32001L, 32002L, 32003L, 32005L)),

        WordEntity(id = 32005, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tannin", transliteration = "[ˈtænɪn]", translation = "танин (вяжущее вещество в вине)",
            definition = "A bitter compound from grape skins that dries the mouth in red wine.",
            definitionNative = "Горькое вещество из кожицы винограда, сушащее рот в красном вине.",
            example = "Young Cabernet has firm tannin that softens after a few years.",
            exampleNative = "Молодой каберне имеет плотный tannin, смягчающийся за несколько лет.",
            pos = "noun", semanticGroup = "food_oenology", fillInBlankExclusions = listOf(32001L, 32002L, 32003L, 32004L, 32007L, 32008L)),

        // ── food_tasting (5) ──────────────────────────────────────────────

        WordEntity(id = 32006, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "palate", transliteration = "[ˈpælət]", translation = "вкусовое чутьё / нёбо",
            definition = "The trained sense of taste a person uses to judge fine food and drink.",
            definitionNative = "Развитое чувство вкуса, которым судят о тонкой еде и напитках.",
            example = "Years of training gave the chef a palate for the rarest spices.",
            exampleNative = "Годы тренировки дали повару palate для редчайших специй.",
            pos = "noun", semanticGroup = "food_tasting", fillInBlankExclusions = listOf(32007L, 32008L)),

        WordEntity(id = 32007, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mouthfeel", transliteration = "[ˈmaʊθˌfil]", translation = "ощущение во рту (текстура напитка/еды)",
            definition = "The bodily texture a drink or dish makes when it touches the tongue.",
            definitionNative = "Телесная текстура напитка или блюда при соприкосновении с языком.",
            example = "The aged stout had a velvety mouthfeel that lingered for ages.",
            exampleNative = "У выдержанного стаута был бархатный mouthfeel, тянувшийся долго.",
            pos = "noun", semanticGroup = "food_tasting", fillInBlankExclusions = listOf(32006L, 32008L)),

        WordEntity(id = 32008, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "finish", transliteration = "[ˈfɪnɪʃ]", translation = "послевкусие (вина, виски)",
            definition = "The taste left in the mouth after swallowing a sip of wine or whisky.",
            definitionNative = "Вкус, оставшийся во рту после глотка вина или виски.",
            example = "The single malt had a smoky finish that lasted half a minute.",
            exampleNative = "У односолодового был дымный finish, державшийся полминуты.",
            pos = "noun", semanticGroup = "food_tasting", fillInBlankExclusions = listOf(32006L, 32007L)),

        WordEntity(id = 32009, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sapid", transliteration = "[ˈsæpɪd]", translation = "вкусный, насыщенный по вкусу",
            definition = "Having a strong, pleasant flavour — the kind that wakes up the tongue.",
            definitionNative = "Имеющий яркий приятный вкус — такой, что пробуждает язык.",
            example = "The aged cheese was sapid and sharp on the very first bite.",
            exampleNative = "Выдержанный сыр был sapid и острый с самого первого укуса.",
            pos = "adjective", semanticGroup = "food_tasting", fillInBlankExclusions = listOf(32010L, 32016L, 32017L, 32019L, 32020L)),

        WordEntity(id = 32010, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gustatory", transliteration = "[ˈɡəstəˌtɔri]", translation = "вкусовой (относящийся к ощущению вкуса)",
            definition = "Relating to the sense of taste — what the tongue notices in food.",
            definitionNative = "Относящийся к чувству вкуса — что язык замечает в еде.",
            example = "Her tasting notes describe each gustatory layer of the chocolate.",
            exampleNative = "Её заметки описывают каждый gustatory слой шоколада.",
            pos = "adjective", semanticGroup = "food_tasting", fillInBlankExclusions = listOf(32009L, 32019L, 32020L)),

        // ── food_haute_cuisine (5) ────────────────────────────────────────

        WordEntity(id = 32011, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "degustation", transliteration = "[ˌdɛɡəˈsteɪʃən]", translation = "дегустация (многоблюдная)",
            definition = "A long tasting menu of many small courses, picked by the chef.",
            definitionNative = "Длинное меню из множества маленьких блюд, выбранных шеф-поваром.",
            example = "Their twelve-course degustation lasted nearly four hours that evening.",
            exampleNative = "Их degustation из двенадцати блюд длилась почти четыре часа.",
            pos = "noun", semanticGroup = "food_haute_cuisine", fillInBlankExclusions = listOf(32012L, 32013L)),

        WordEntity(id = 32012, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "prix-fixe", transliteration = "[ˌpriˈfɪks]", translation = "комплексный обед по фиксированной цене",
            definition = "A restaurant meal of fixed courses at one set price for everyone.",
            definitionNative = "Ресторанный обед из фиксированных блюд по одной цене для всех.",
            example = "The bistro offers a prix-fixe of three courses for thirty euros.",
            exampleNative = "Бистро предлагает prix-fixe из трёх блюд за тридцать евро.",
            pos = "noun", semanticGroup = "food_haute_cuisine", fillInBlankExclusions = listOf(32011L, 32013L)),

        WordEntity(id = 32013, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "foie-gras", transliteration = "[ˌfwɑˈɡrɑ]", translation = "фуа-гра (паштет из утиной/гусиной печени)",
            definition = "A rich French dish of fattened goose or duck liver, soft as butter.",
            definitionNative = "Богатое французское блюдо из откормленной утиной или гусиной печени.",
            example = "A thin slice of foie-gras melted on the warm toasted brioche.",
            exampleNative = "Тонкий ломтик foie-gras таял на тёплой поджаренной булочке.",
            pos = "noun", semanticGroup = "food_haute_cuisine", fillInBlankExclusions = listOf(32011L, 32012L)),

        WordEntity(id = 32014, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "nouvelle", transliteration = "[nuˈvɛl]", translation = "новая (о французской кухне 1970-х)",
            definition = "A French style of cooking with light sauces and tiny artful portions.",
            definitionNative = "Французский стиль готовки с лёгкими соусами и маленькими изящными порциями.",
            example = "The chef trained in nouvelle cooking under a Paris master in the eighties.",
            exampleNative = "Шеф учился nouvelle готовке у парижского мастера в восьмидесятых.",
            pos = "adjective", semanticGroup = "food_haute_cuisine", fillInBlankExclusions = listOf(32015L)),

        WordEntity(id = 32015, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gastronomique", transliteration = "[ˌɡæstrənəˈmik]", translation = "гастрономический (изысканный, об ужине)",
            definition = "Of an extra-fine dining tradition built around long luxurious meals.",
            definitionNative = "Из традиции изысканного питания вокруг долгих роскошных трапез.",
            example = "Lyon is famous for its gastronomique restaurants and old bouchons.",
            exampleNative = "Лион славится своими gastronomique ресторанами и старыми бушонами.",
            pos = "adjective", semanticGroup = "food_haute_cuisine", fillInBlankExclusions = listOf(32014L)),

        // ── food_descriptive (5) ──────────────────────────────────────────

        WordEntity(id = 32016, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ambrosial", transliteration = "[æmˈbroʊziəl]", translation = "божественный на вкус",
            definition = "Tasting so fine it seems made for the gods — pure pleasure on the tongue.",
            definitionNative = "На вкус столь изысканный, словно для богов — чистое блаженство на языке.",
            example = "The aroma of fresh truffle was ambrosial across the whole dining room.",
            exampleNative = "Аромат свежего трюфеля был ambrosial по всему обеденному залу.",
            pos = "adjective", semanticGroup = "food_descriptive", fillInBlankExclusions = listOf(32017L, 32018L, 32019L, 32020L)),

        WordEntity(id = 32017, setId = 320, languagePair = "en-ru", rarity = "EPIC",
            original = "palatable", transliteration = "[ˈpælətəbəl]", translation = "приятный на вкус",
            definition = "Pleasant enough to eat — not amazing, but the tongue does not protest.",
            definitionNative = "Приятный для еды — не восхитительный, но язык не протестует.",
            example = "Hospital meals are bland but mostly palatable after a long surgery.",
            exampleNative = "Больничная еда пресна, но в основном palatable после долгой операции.",
            pos = "adjective", semanticGroup = "food_descriptive", fillInBlankExclusions = listOf(32016L, 32018L, 32019L, 32020L)),

        WordEntity(id = 32018, setId = 320, languagePair = "en-ru", rarity = "EPIC",
            original = "succulent", transliteration = "[ˈsəkjələnt]", translation = "сочный (об мясе/плоде)",
            definition = "Full of tasty juices that burst out at the very first bite.",
            definitionNative = "Полный вкусного сока, брызжущего при самом первом укусе.",
            example = "She carved off a slice of succulent roast lamb for our guest.",
            exampleNative = "Она отрезала кусок succulent жареной баранины для гостя.",
            pos = "adjective", semanticGroup = "food_descriptive", fillInBlankExclusions = listOf(32009L, 32016L, 32017L, 32019L, 32020L)),

        WordEntity(id = 32019, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "piquant", transliteration = "[ˈpikənt]", translation = "пикантный (с приятной остротой)",
            definition = "Pleasantly sharp — when a little chilli or vinegar wakes up the dish.",
            definitionNative = "Приятно острый — когда чуточка перца или уксуса будит блюдо.",
            example = "The chef finished the soup with a piquant dash of smoked paprika.",
            exampleNative = "Шеф довершил суп piquant щепоткой копчёной паприки.",
            pos = "adjective", semanticGroup = "food_descriptive", fillInBlankExclusions = listOf(32017L, 32018L)),

        WordEntity(id = 32020, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "unctuous", transliteration = "[ˈəŋktʃuəs]", translation = "маслянистый, обволакивающий (на вкус)",
            definition = "Smooth and oily on the tongue — the way melted butter or lard feels.",
            definitionNative = "Гладкий и жирноватый на языке — будто растопленное сливочное масло.",
            example = "The unctuous gravy coated each potato like a glossy brown blanket.",
            exampleNative = "Unctuous подливка покрывала каждую картофелину блестящим коричневым одеялом.",
            pos = "adjective", semanticGroup = "food_descriptive", fillInBlankExclusions = listOf(32009L, 32016L, 32017L, 32018L, 32019L)),

        // ── food_literary_verbs (5) ───────────────────────────────────────

        WordEntity(id = 32021, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "masticate", transliteration = "[ˈmæstəˌkeɪt]", translation = "тщательно жевать",
            definition = "To chew food carefully and thoroughly before it goes down the throat.",
            definitionNative = "Тщательно пережёвывать пищу, прежде чем она пойдёт в горло.",
            example = "Doctors advise patients to masticate every bite at least twenty times.",
            exampleNative = "Врачи советуют пациентам masticate каждый кусок не менее двадцати раз.",
            pos = "verb", semanticGroup = "food_literary_verbs", fillInBlankExclusions = listOf(32022L, 32023L, 32024L, 32025L)),

        WordEntity(id = 32022, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "savour", transliteration = "[ˈseɪvər]", translation = "смаковать (есть с удовольствием)",
            definition = "To eat or drink slowly, soaking up every bit of pleasure from a flavour.",
            definitionNative = "Есть или пить медленно, впитывая каждую крупицу удовольствия от вкуса.",
            example = "He likes to savour the first sip of coffee on the quiet porch.",
            exampleNative = "Он любит savour первый глоток кофе на тихом крыльце.",
            pos = "verb", semanticGroup = "food_literary_verbs", fillInBlankExclusions = listOf(32021L, 32023L, 32024L, 32025L)),

        WordEntity(id = 32023, setId = 320, languagePair = "en-ru", rarity = "EPIC",
            original = "imbibe", transliteration = "[ɪmˈbaɪb]", translation = "пить, поглощать жидкость (литер.)",
            definition = "To drink something — usually wine or another grown-up beverage.",
            definitionNative = "Употреблять напиток — обычно вино или другой взрослый алкоголь.",
            example = "The guests began to imbibe vintage port after the long dinner.",
            exampleNative = "Гости начали imbibe старинный портвейн после долгого ужина.",
            pos = "verb", semanticGroup = "food_literary_verbs", fillInBlankExclusions = listOf(32021L, 32022L, 32024L, 32025L)),

        WordEntity(id = 32024, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "regale", transliteration = "[rɪˈɡeɪl]", translation = "потчевать, угощать (на широкую ногу)",
            definition = "To feed guests lavishly — heaps of fine food and drink at the table.",
            definitionNative = "Кормить гостей с размахом — горы изысканной еды и питья на столе.",
            example = "The host loved to regale visitors with oysters and chilled champagne.",
            exampleNative = "Хозяин любил regale гостей устрицами и охлаждённым шампанским.",
            pos = "verb", semanticGroup = "food_literary_verbs", fillInBlankExclusions = listOf(32021L, 32022L, 32023L, 32025L)),

        WordEntity(id = 32025, setId = 320, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sup", transliteration = "[səp]", translation = "ужинать (книжн.); прихлёбывать",
            definition = "To take small spoonfuls of broth or to share an old-style evening meal.",
            definitionNative = "Понемногу втягивать бульон или делить старомодный вечерний приём пищи.",
            example = "The tired travellers paused at an inn to sup hot beef broth.",
            exampleNative = "Усталые путники остановились на постоялом дворе sup горячий говяжий бульон.",
            pos = "verb", semanticGroup = "food_literary_verbs", fillInBlankExclusions = listOf(32021L, 32022L, 32023L, 32024L)),
    )
}
