package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1896 (he-ru).
 * Природа и экология: геология, горные породы и минералы (L3 / RARE + EPIC).
 *
 * Расширение темы «Природа и экология». Зеркало en-ru set 463 (геология).
 * Актуально для Израиля: пустыня Негев, Махтеш Рамон, Эйлатские горы,
 * Мёртвое море и его соляные образования.
 *
 * Пять семантических групп:
 *   nature_geology_rocks      — гранит, базальт, мел, песчаник, сланец, обсидиан, мергель, пемза
 *   nature_geology_minerals   — кварц, пирит, кальцит, аметист, агат, сера, полевой шпат
 *   nature_geology_processes  — магма, лава, осадок, разлом, кратер
 *   nature_geology_landforms  — кора, мантия, рудная жила
 *   nature_geology_mining     — карьер, окаменелость
 *
 * Из шорт-листа исключены дубли:
 *   - אֶבֶן גִּיר (известняк) — Batch54 → заменено на גִּיר (мел/известь)
 *   - שֶׁבֶר      (разлом/перелом) — Batch70 + MedicineV2 → заменено на בְּקִיעַ (трещина-разлом)
 *   - מַעֲטֶפֶת   (обёртка/мантия) — Shopping → заменено на מַעֲטֶפֶת הָאֲדָמָה (мантия Земли)
 *
 * Word IDs: 189601..189625 (setId × 100 + position).
 */
object WordDataHebrewNatureGeology {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1896, languagePair = "he-ru", orderIndex = 1896,
            name = "Природа и экология",
            description = "Геология и минералы: גְּרָנִיט, קְוַרְץ, מַגְמָה, מַכְתֵּשׁ, מְאוּבָּן",
            topic = "Природа и экология",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: nature_geology_rocks (8 words) ─────────────────────────────

        WordEntity(id = 189601, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "גְּרָנִיט",
            translation = "гранит",
            definition = "סֶלַע מַגְמָתִי קָשֶׁה וְגַרְעִינִי מִקְוַרְץ וּפֶלְדְּשַׁפַּט, נָפוֹץ בָּהָרִים וּבְמִשְׁטְחֵי מִטְבָּח.",
            definitionNative = "Твёрдая зернистая магматическая порода из кварца и полевого шпата; встречается в горах и на кухонных столешницах.",
            example = "אֵילַת יוֹשֶׁבֶת עַל הָרֵי גְּרָנִיט אֲדֻמִּים בְּגִיל מֵאוֹת מִילְיוֹנֵי שָׁנָה.",
            exampleNative = "Эйлат стоит на красных горах גְּרָנִיט возрастом в сотни миллионов лет.",
            pos = "noun", semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(189602L, 189603L, 189604L, 189605L, 189606L, 189607L, 189608L)),

        WordEntity(id = 189602, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "בַּזֶלֶת",
            translation = "базальт",
            definition = "סֶלַע וֻלְקָנִי כֵּהֶה הַנּוֹצָר כַּאֲשֶׁר לָבָה דַּקָּה מִתְקָרֶרֶת בִּמְהִירוּת עַל פְּנֵי הָאֲדָמָה.",
            definitionNative = "Тёмная вулканическая порода: образуется, когда жидкая лава быстро остывает на поверхности Земли.",
            example = "רָמַת הַגּוֹלָן מְכֻסָּה שְׁכָבוֹת עָבוֹת שֶׁל בַּזֶלֶת שֶׁחוֹרָה מֵהֶעָבָר הַוֻּלְקָנִי שֶׁלָּהּ.",
            exampleNative = "Голанские высоты покрыты толстыми чёрными слоями בַּזֶלֶת — наследие их вулканического прошлого.",
            pos = "noun", semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(189601L, 189603L, 189604L, 189605L, 189606L, 189607L, 189608L)),

        WordEntity(id = 189603, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "גִּיר",
            translation = "мел, известь",
            definition = "סֶלֶע רַךְ לָבָן מִשְּׁאֵרִיּוֹת קְלִפּוֹת שֶׁל יְצוּרֵי יָם זְעִירִים, מַשְׁאִיר סִימָן עַל לוּחַ.",
            definitionNative = "Мягкая белая порода из остатков раковин мелких морских организмов; оставляет след на доске.",
            example = "הָרֵי יְהוּדָה בְּנוּיִים בְּעִקַּר מִגִּיר שֶׁנּוֹצָר עַל קַרְקָעִית יָם קַדְמוֹן.",
            exampleNative = "Иудейские горы сложены в основном из גִּיר, образовавшегося на дне древнего моря.",
            pos = "noun", semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(189601L, 189602L, 189605L, 189606L, 189607L, 189608L)),

        WordEntity(id = 189604, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "חוֹל אֶבֶן",
            translation = "песчаник",
            definition = "סֶלֶע מִשְׁקָעִי מִגַּרְגְּרֵי חוֹל מְלֻכָּדִים, מוֹפִיעַ בְּצֶבַע אָדֹם אוֹ צָהֹב בַּמִּדְבָּר.",
            definitionNative = "Осадочная порода из спрессованных песчинок; в пустыне встречается красного или жёлтого цвета.",
            example = "הָעַמּוּדִים הָאֲדֻמִּים שֶׁל פֶּטְרָה גְּלוּפִים יָשִׁיר בְּתוֹךְ חוֹל אֶבֶן עַתִּיק.",
            exampleNative = "Красные колонны Петры вырезаны прямо в древнем חוֹל אֶבֶן.",
            pos = "phrase", semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(189601L, 189602L, 189603L, 189605L, 189606L, 189607L, 189608L)),

        WordEntity(id = 189605, setId = 1896, languagePair = "he-ru", rarity = "EPIC",
            original = "צַפְחָה",
            translation = "сланец",
            definition = "סֶלֶע מִשְׁקָעִי דַּק שִׁכְבָתִי הַנִּשְׁבָּר לְלוּחוֹת שְׁטוּחִים, שִׁמֵּשׁ פַּעַם לְכִסּוּי גַּגּוֹת.",
            definitionNative = "Тонкослоистая осадочная порода, раскалывающаяся на плоские плитки; когда-то служила для покрытия крыш.",
            example = "מִתַּחַת לַגַּג הָעַתִּיק חָשַׂף הָאַרְכֵיאוֹלוֹג רִצְפַּת צַפְחָה מֵהַתְּקוּפָה הָרוֹמִית.",
            exampleNative = "Под старой крышей археолог обнаружил пол из צַפְחָה ещё римской эпохи.",
            pos = "noun", semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(189601L, 189602L, 189603L, 189604L, 189606L, 189607L, 189608L)),

        WordEntity(id = 189606, setId = 1896, languagePair = "he-ru", rarity = "EPIC",
            original = "אוֹבְּסִידְיָאן",
            translation = "обсидиан",
            definition = "זְכוּכִית טִבְעִית שְׁחוֹרָה הַנּוֹצֶרֶת כַּאֲשֶׁר לָבָה צְמִיגָה מִתְקָרֶרֶת מַהֵר וְלֹא מַסְפִּיקָה לְהִתְגַּבֵּשׁ.",
            definitionNative = "Чёрное природное стекло; образуется, когда вязкая лава остывает быстро и не успевает закристаллизоваться.",
            example = "בְּנֵי הָאָדָם הַקַּדְמוֹנִים לִטְּשׁוּ אוֹבְּסִידְיָאן לְסַכִּינִים חַדּוֹת בְּמֻחְלָט.",
            exampleNative = "Древние люди обтачивали אוֹבְּסִידְיָאן в исключительно острые ножи.",
            pos = "noun", semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(189601L, 189602L, 189603L, 189605L, 189607L, 189608L, 189609L, 189614L)),

        WordEntity(id = 189607, setId = 1896, languagePair = "he-ru", rarity = "EPIC",
            original = "כַּלְקָר",
            translation = "мергель",
            definition = "סֶלֶע רַךְ הַמֹּעֳרָב מִגִּיר וְחָרְסִית, נֶחְשָׂף לְעִתִּים קְרוֹבוֹת בְּמִדְרוֹנֵי הָרֵי הַנֶּגֶב.",
            definitionNative = "Мягкая порода — смесь известковых частиц и глины; часто обнажается на склонах гор Негева.",
            example = "הַשְּׁכָבוֹת הָאֲפֹרוֹת שֶׁל כַּלְקָר מִתְפּוֹרְרוֹת מְהֵרָה תַּחַת גִּשְׁמֵי הַחֹרֶף.",
            exampleNative = "Серые слои כַּלְקָר быстро крошатся под зимними дождями.",
            pos = "noun", semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(189601L, 189602L, 189603L, 189604L, 189605L, 189606L, 189608L)),

        WordEntity(id = 189608, setId = 1896, languagePair = "he-ru", rarity = "EPIC",
            original = "פּוּמִיס",
            translation = "пемза",
            definition = "סֶלֶע וֻלְקָנִי קַל מָלֵא בּוּעוֹת אֲוִיר, צָף עַל פְּנֵי הַמַּיִם וְשׁוֹחֵק עוֹר יָבֵשׁ.",
            definitionNative = "Лёгкая вулканическая порода, полная пузырьков воздуха; плавает на воде и стирает сухую кожу.",
            example = "בַּחֲנוּת הַטֶּבַע מָכְרוּ אֶבֶן פּוּמִיס לְהַחֲלָקַת עָקֵב.",
            exampleNative = "В магазине натуральных средств продавался камень פּוּמִיס для шлифовки пятки.",
            pos = "noun", semanticGroup = "nature_geology_rocks", fillInBlankExclusions = listOf(189601L, 189602L, 189603L, 189605L, 189606L, 189607L)),

        // ── Group: nature_geology_minerals (7 words) ──────────────────────────

        WordEntity(id = 189609, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "קְוַרְץ",
            translation = "кварц",
            definition = "מִינֶרָל קָשֶׁה וּשְׁקוּף מְאוֹד נָפוֹץ בַּקְּלִפָּה, מוֹפִיעַ כְּגַבִּישִׁים בְּשֶׁל הָאַרְכֵיאוֹלוֹגִים.",
            definitionNative = "Очень твёрдый прозрачный минерал, один из самых распространённых в коре; встречается в виде шестигранных кристаллов.",
            example = "בַּחוֹלוֹת חוֹף נְתַנְיָה רוֹב הַגַּרְגְּרִים הַזְּעִירִים הֵם בְּעֶצֶם קְוַרְץ.",
            exampleNative = "В песке пляжа Нетании большинство мелких крупинок — это на самом деле קְוַרְץ.",
            pos = "noun", semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(189610L, 189611L, 189612L, 189613L, 189614L, 189615L)),

        WordEntity(id = 189610, setId = 1896, languagePair = "he-ru", rarity = "EPIC",
            original = "פֶּלְדְּשַׁפַּט",
            translation = "полевой шпат",
            definition = "מִשְׁפַּחַת מִינֶרָלִים הָאוֹרֶזֶת אֶת רֹב סִלְעֵי כַּדּוּר הָאָרֶץ, מַזְהִירָה בַּגְּרָנִיט הַחָתוּךְ.",
            definitionNative = "Семейство минералов, составляющее большинство пород Земли; матово блестит в полированном граните.",
            example = "תַּחַת הַזְּכוּכִית הַמַּגְדֶּלֶת הַמּוֹרָה הֶרְאֲתָה גַּבִּישִׁים וְרֻדִּים שֶׁל פֶּלְדְּשַׁפַּט.",
            exampleNative = "Под лупой учительница показала розовые кристаллы פֶּלְדְּשַׁפַּט.",
            pos = "noun", semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(189609L, 189611L, 189612L, 189613L, 189614L, 189615L)),

        WordEntity(id = 189611, setId = 1896, languagePair = "he-ru", rarity = "EPIC",
            original = "קָלְצִיט",
            translation = "кальцит",
            definition = "מִינֶרָל לָבָן אוֹ צָלוּל, רָכִיב עִקָּרִי שֶׁל גִּיר וְשַׁיִשׁ, מַגִּיב לְחֻמְצָה בִּרְתִיחָה.",
            definitionNative = "Белый или прозрачный минерал, основной компонент известняка и мрамора; вскипает при контакте с кислотой.",
            example = "טִפּוֹת חוֹמֶץ עַל קָלְצִיט מַתְחִילוֹת לְבַעְבֵּעַ כִּמְעַט מִיָּד.",
            exampleNative = "Капли уксуса на קָלְצִיט почти сразу начинают пузыриться.",
            pos = "noun", semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(189609L, 189610L, 189612L, 189613L, 189614L, 189615L)),

        WordEntity(id = 189612, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "אַמֶתִיסְט",
            translation = "аметист",
            definition = "גַּרְסָה סְגֻלָּה שֶׁל קְוַרְץ, מְשַׁמֶּשֶׁת אֶבֶן חֵן מְחֻבֶּבֶת לְתַכְשִׁיטִים וּלְקִשּׁוּטֵי מִזְבֵּחַ.",
            definitionNative = "Фиолетовая разновидность кварца; популярный самоцвет для украшений и алтарных декораций.",
            example = "סָבָתִי קִבְּלָה אֲרִיגַת אַמֶתִיסְט סָגֹל בַּחֲתֻנָּתָהּ.",
            exampleNative = "Моя бабушка получила на свадьбу подвеску из фиолетового אַמֶתִיסְט.",
            pos = "noun", semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(189609L, 189610L, 189611L, 189613L, 189614L, 189615L)),

        WordEntity(id = 189613, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "אַגָט",
            translation = "агат",
            definition = "אֶבֶן חֵן מִשְׁכָבוֹת קְוַרְץ צִבְעוֹנִיּוֹת, מַרְאָה דְּגָמִים בְּצוּרַת רְצוּעוֹת קוֹנְצֶנְטְרִיּוֹת.",
            definitionNative = "Самоцвет из слоистых разновидностей кварца; показывает узор в виде концентрических полос.",
            example = "בִּמְעָרָה לְיַד הַכִּנֶּרֶת מָצָא הַטַּיָּל גַּלְעִינֵי אַגָט קְטַנִּים בֵּין הָאֲבָנִים.",
            exampleNative = "В пещере у Кинерета турист нашёл маленькие ядра אַגָט среди камней.",
            pos = "noun", semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(189609L, 189610L, 189611L, 189612L, 189614L, 189615L)),

        WordEntity(id = 189614, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "פִּירִיט",
            translation = "пирит",
            definition = "מִינֶרָל מַתַּכְתִּי צָהֹב הַדּוֹמֶה לְמַטְבְּעוֹת זָהָב, כִּנּוּהוּ פַּעַם «זְהַב הַשּׁוֹטִים».",
            definitionNative = "Жёлтый минерал с металлическим блеском, похож на золотые монеты; когда-то прозван «золотом дураков».",
            example = "הַכּוֹרֶה הִתְלַהֵב לְרֶגַע, אַךְ הָיָה זֶה רַק פִּירִיט וְלֹא זָהָב אֲמִתִּי.",
            exampleNative = "Шахтёр на миг обрадовался, но это был всего лишь פִּירִיט, а не настоящее золото.",
            pos = "noun", semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(189609L, 189610L, 189611L, 189612L, 189613L, 189615L)),

        WordEntity(id = 189615, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "גּוֹפְרִית",
            translation = "сера",
            definition = "יְסוֹד צָהֹב בּוֹהֵק בַּעַל רֵיחַ בֵּיצִים סְרוּחוֹת, נִמְצָא לְיַד מַעְיְנוֹת חַמִּים וְהָרֵי גַּעַשׁ.",
            definitionNative = "Ярко-жёлтый элемент с запахом тухлых яиц; встречается у горячих источников и вулканов.",
            example = "סְבִיב הַמַּעְיָנוֹת הַחַמִּים שֶׁל חַמַּת גָּדֵר הָאֲוִיר רָווּי רֵיחַ גּוֹפְרִית.",
            exampleNative = "Вокруг горячих источников Хамат-Гадера воздух пропитан запахом גּוֹפְרִית.",
            pos = "noun", semanticGroup = "nature_geology_minerals", fillInBlankExclusions = listOf(189609L, 189610L, 189611L, 189612L, 189613L, 189614L)),

        // ── Group: nature_geology_processes (5 words) ─────────────────────────

        WordEntity(id = 189616, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "מַגְמָה",
            translation = "магма",
            definition = "סֶלַע מֻתָּךְ וְלוֹהֵט הַזּוֹרֵם לְאַט עָמוֹק מִתַּחַת לִקְלִפַּת כַּדּוּר הָאָרֶץ.",
            definitionNative = "Расплавленная раскалённая порода, медленно текущая глубоко под поверхностью Земли.",
            example = "בַּמַּעֲבָדָה הִקְרִינוּ סֶרֶט שֶׁמַּרְאֶה אֵיךְ מַגְמָה עוֹלָה לְעֵבֶר לוֹעַ הַר הַגַּעַשׁ.",
            exampleNative = "В лаборатории показали фильм, как מַגְמָה поднимается к жерлу вулкана.",
            pos = "noun", semanticGroup = "nature_geology_processes", fillInBlankExclusions = listOf(189617L, 189618L, 189619L, 189620L)),

        WordEntity(id = 189617, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "לָבָה",
            translation = "лава",
            definition = "סֶלַע מֻתָּךְ הַזּוֹרֵם עַל פְּנֵי הַשֶּׁטַח אַחֲרֵי הִתְפָּרְצוּת שֶׁל הַר גַּעַשׁ.",
            definitionNative = "Расплавленная порода, текущая по поверхности после извержения вулкана.",
            example = "בְּהָוָואִי הַתַּיָּרִים צוֹפִים מֵרָחוֹק בְּלָבָה כְּתֻמָּה שֶׁמַּגִּיעָה אֶל הַיָּם.",
            exampleNative = "На Гавайях туристы издали наблюдают, как оранжевая לָבָה достигает моря.",
            pos = "noun", semanticGroup = "nature_geology_processes", fillInBlankExclusions = listOf(189616L, 189618L, 189619L, 189620L)),

        WordEntity(id = 189618, setId = 1896, languagePair = "he-ru", rarity = "EPIC",
            original = "מִשְׁקָע",
            translation = "осадок (геол.)",
            definition = "חֹמֶר שֶׁשּׁוֹקֵעַ אַט אַט עַל קַרְקָעִית יָם אוֹ אֲגַם וּמִצְטַבֵּר לִשְׁכָבוֹת.",
            definitionNative = "Вещество, медленно опускающееся на дно моря или озера и накапливающееся слоями.",
            example = "קַרְקָעִית יָם הַמֶּלַח מְכֻסָּה מִשְׁקָע שֶׁל מֶלַח וּמִינֶרָלִים בְּעֹמֶק שֶׁל מֶטְרִים.",
            exampleNative = "Дно Мёртвого моря покрыто מִשְׁקָע из соли и минералов на глубину в несколько метров.",
            pos = "noun", semanticGroup = "nature_geology_processes", fillInBlankExclusions = listOf(189616L, 189617L, 189619L, 189620L)),

        WordEntity(id = 189619, setId = 1896, languagePair = "he-ru", rarity = "EPIC",
            original = "בְּקִיעַ",
            translation = "разлом (тектонический)",
            definition = "סֶדֶק אָרֹךְ בַּקְּלִפָּה שֶׁאֲרָצוֹת לְאֹרֶךְ שְׁנֵי צְדָדָיו זָזוֹת זוֹ מוּל זוֹ.",
            definitionNative = "Длинная трещина в коре, вдоль которой участки земли по обе стороны смещаются друг относительно друга.",
            example = "בְּקִיעַ סוּרְיָה–אַפְרִיקָה עוֹבֵר בְּדִיּוּק לְאֹרֶךְ עֵמֶק הַיַּרְדֵּן.",
            exampleNative = "בְּקִיעַ Сирийско-Африканский проходит ровно вдоль Иорданской долины.",
            pos = "noun", semanticGroup = "nature_geology_processes"),

        WordEntity(id = 189620, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "מַכְתֵּשׁ",
            translation = "кратер (эрозионный/вулканический)",
            definition = "שְׁקַעֲרוּרִית גְּדוֹלָה בָּאֲדָמָה שֶׁנּוֹצְרָה עַל יְדֵי הִתְפָּרְצוּת, פְּגִיעַת מֶטֵאוֹר אוֹ שְׁחִיקָה.",
            definitionNative = "Большая впадина в земле, возникшая от извержения, удара метеорита или эрозии.",
            example = "מַכְתֵּשׁ רָמוֹן הוּא הַמַּכְתֵּשׁ הָאֲרֹזִיוֹנִי הַגָּדוֹל בְּיוֹתֵר בָּעוֹלָם.",
            exampleNative = "מַכְתֵּשׁ Рамон — крупнейший в мире эрозионный кратер.",
            pos = "noun", semanticGroup = "nature_geology_processes"),

        // ── Group: nature_geology_landforms (3 words) ─────────────────────────

        WordEntity(id = 189621, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "קֵרוּם",
            translation = "земная кора",
            definition = "הַשִּׁכְבָה הַחִיצוֹנִית הַקָּשָׁה וְהַדַּקָּה שֶׁל כַּדּוּר הָאָרֶץ, עָלֶיהָ נִמְצָאִים יַבָּשׁוֹת וְיַמִּים.",
            definitionNative = "Внешний твёрдый и тонкий слой Земли; на нём расположены континенты и моря.",
            example = "הָרְעִידוֹת בַּצָּפוֹן נִגְרְמוּ בְּעִקְבוֹת תְּזוּזוֹת אִטִּיוֹת בַּקֵּרוּם.",
            exampleNative = "Подземные толчки на севере вызваны медленными подвижками в קֵרוּם.",
            pos = "noun", semanticGroup = "nature_geology_landforms"),

        WordEntity(id = 189622, setId = 1896, languagePair = "he-ru", rarity = "EPIC",
            original = "מַעֲטֶפֶת הָאֲדָמָה",
            translation = "мантия Земли",
            definition = "הַשִּׁכְבָה הָעֲבָה שֶׁמִּתַּחַת לַקֵּרוּם וּמֵעַל לַגַּרְעִין, בָּהּ זוֹרֵם סֶלַע חַם וּצְמִיגִי.",
            definitionNative = "Толстый слой между корой и ядром Земли; в нём течёт горячая вязкая порода.",
            example = "זְרָמִים בְּמַעֲטֶפֶת הָאֲדָמָה מְזִיזִים יַבָּשׁוֹת.",
            exampleNative = "Потоки в מַעֲטֶפֶת הָאֲדָמָה смещают континенты.",
            pos = "phrase", semanticGroup = "nature_geology_landforms", fillInBlankExclusions = listOf(189623L)),

        WordEntity(id = 189623, setId = 1896, languagePair = "he-ru", rarity = "EPIC",
            original = "עוֹרֵק עַפְרָה",
            translation = "рудная жила",
            definition = "סֶדֶק בַּסֶּלַע הַמְּמֻלָּא מַתָּכוֹת אוֹ מִינֶרָלִים יְקָרִים שֶׁשָּׁקְעוּ מִתּוֹךְ נוֹזֵל חַם.",
            definitionNative = "Трещина в породе, заполненная металлом или ценным минералом, осевшим из горячего раствора.",
            example = "כּוֹרֵי הַתִּימְנָע גִּלּוּ עוֹרֵק עַפְרָה עָשִׁיר בְּנְחֹשֶׁת לִפְנֵי שָׁלֹשֶׁת אֲלָפִים שָׁנָה.",
            exampleNative = "Горняки в долине Тимна обнаружили עוֹרֵק עַפְרָה, богатую медью, три тысячи лет назад.",
            pos = "phrase", semanticGroup = "nature_geology_landforms", fillInBlankExclusions = listOf(189622L)),

        // ── Group: nature_geology_mining (2 words) ────────────────────────────

        WordEntity(id = 189624, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "מַחְצָב",
            translation = "карьер",
            definition = "מָקוֹם פָּתוּחַ בַּקַּרְקַע שֶׁבּוֹ חוֹצְבִים אֲבָנִים אוֹ מִינֶרָלִים מִקִּירוֹת הַסֶּלַע.",
            definitionNative = "Открытое место в земле, где из стенок породы добывают камни или минералы.",
            example = "לֹא רָחוֹק מִמּוֹדִיעִין יֵשׁ מַחְצָב גָּדוֹל שֶׁמְּסַפֵּק חָצָץ לְכָל הָאֵזוֹר.",
            exampleNative = "Недалеко от Модиина есть большой מַחְצָב, который снабжает щебнем весь район.",
            pos = "noun", semanticGroup = "nature_geology_mining", fillInBlankExclusions = listOf(189625L)),

        WordEntity(id = 189625, setId = 1896, languagePair = "he-ru", rarity = "RARE",
            original = "מְאוּבָּן",
            translation = "окаменелость",
            definition = "שָׂרִיד שֶׁל יְצוּר חַי קַדְמוֹן שֶׁנִּשְׁמַר בְּסֶלַע מִשְׁקָעִי וְהָפַךְ עִם הַזְּמַן לְאֶבֶן.",
            definitionNative = "Остаток древнего живого существа, сохранившийся в осадочной породе и со временем ставший камнем.",
            example = "בְּמַכְתֵּשׁ רָמוֹן מָצְאוּ מְאוּבָּן שֶׁל קוֹנְכִיָּה יַמִּית.",
            exampleNative = "В кратере Рамон нашли מְאוּבָּן морской раковины.",
            pos = "noun", semanticGroup = "nature_geology_mining", fillInBlankExclusions = listOf(189624L)),
    )
}
