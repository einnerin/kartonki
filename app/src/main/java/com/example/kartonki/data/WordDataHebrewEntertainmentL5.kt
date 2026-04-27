package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — Развлечения и досуг (level 5, носитель языка).
 *
 * Set 1795: «Развлечения и досуг» — носитель языка (L5, EPIC + LEGENDARY):
 *           теория автора, кинокритика, философия искусства, индустрия и
 *           продвинутые жанры.
 *
 * Слова не повторяются и не имеют общих шорошим с Hebrew Entertainment
 * L1L2L3 (1733, 1734, 1735) и L4 (1794). Проверки grep'ом по корням:
 *   - L1L2L3 содержит מיזנסצנה / מוקומנטרי / אסתטיקה — здесь они исключены
 *     или заменены далёкими по корню синонимами.
 *   - bkr (מבקר): только одно слово в наборе (kinokritika).
 *   - 'mn ('emun): только в hash'ayat i-emun.
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY (спред 1, на границе L5).
 *
 * SemanticGroups (5 × 5):
 *   entertainment_theory          — теория автора, эффект Кулешова, диегетический
 *                                   звук, четвёртая стена, лейтмотив
 *   entertainment_criticism       — кинокритик, лонгрид, ретроспективный анализ,
 *                                   семиотическое прочтение, поэтика повествования
 *   entertainment_philosophy      — художественное переживание, приостановка
 *                                   неверия, катарсис, возвышенное, тотальное
 *                                   произведение
 *   entertainment_economics       — бокс-офис, роялти, побочные доходы,
 *                                   синдикация, окупаемость инвестиций
 *   entertainment_advanced_genres — магический реализм, экспрессионизм, странная
 *                                   фантастика, сериал-антология, дизельпанк
 *
 * Word IDs: setId × 100 + position (179501..179525).
 *
 * isFillInBlankSafe = false — все слова многословные термины или абстрактные
 * понятия философского/индустриального уровня. В FILL_IN_BLANK пропуск
 * создаётся механической заменой и для двусловных терминов «протекает» либо
 * становится неоднозначным. Pipeline позже подберёт exclusions и при
 * необходимости флипнет флаг в Phase 3.
 */
object WordDataHebrewEntertainmentL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1795, languagePair = "he-ru", orderIndex = 1795,
            name = "Развлечения и досуг",
            description = "Уровень носителя: теория, критика, философия искусства, индустрия",
            topic = "Развлечения и досуг", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 1795 — Развлечения и досуг: носитель языка (L5, EPIC+LEG)    ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── entertainment_theory (5) — теория автора и киноязык ───────────

        WordEntity(id = 179501, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_theory", transliteration = "torat ha-mehaber",
            original = "תּוֹרַת הַמְּחַבֵּר", translation = "теория автора (auteur theory)",
            definition = "גִּישָׁה בִּקֹּרֶת שֶׁרוֹאָה בַּבַּמַּאי אֶת הַקּוֹל הַיּוֹצֵר הַמֶּרְכָּזִי שֶׁל הַסֶּרֶט.",
            definitionNative = "Подход, видящий в режиссёре главный творческий голос фильма, как у писателя.",
            example = "תּוֹרַת הַמְּחַבֵּר הִשְׁפִּיעָה עָמֹק עַל בִּקֹּרֶת הַקּוֹלְנוֹעַ הַצָּרְפָתִית.",
            exampleNative = "תּוֹרַת הַמְּחַבֵּר глубоко повлияла на французскую кинокритику.", fillInBlankExclusions = listOf(179502L, 179503L, 179504L)),

        WordEntity(id = 179502, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_theory", transliteration = "efekt kuleshov",
            original = "אֶפֶּקְט קוּלֶשׁוֹב", translation = "эффект Кулешова",
            definition = "תּוֹפָעָה שֶׁבָּהּ הַצּוֹפֶה מַעֲנִיק מַשְׁמָעוּת לִדְמוּת לְפִי שׁוֹט סָמוּךְ.",
            definitionNative = "Явление, при котором смысл лица героя задаётся соседним по монтажу кадром.",
            example = "מוֹרֵי קוֹלְנוֹעַ מַדְגִּימִים אֶפֶּקְט קוּלֶשׁוֹב כְּדֵי לְלַמֵּד עֲרִיכָה.",
            exampleNative = "Преподаватели кино показывают אֶפֶּקְט קוּלֶשׁוֹב, чтобы объяснить монтаж.", fillInBlankExclusions = listOf(179501L, 179503L, 179504L)),

        WordEntity(id = 179503, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_theory", transliteration = "tslil diegeti",
            original = "צְלִיל דִּיֵגֶטִי", translation = "диегетический звук",
            definition = "קוֹל שֶׁמִּקּוֹרוֹ נִמְצָא בְּתוֹךְ הָעוֹלָם שֶׁל הַסִּפּוּר וְהַדְּמֻיּוֹת שׁוֹמְעוֹת אוֹתוֹ.",
            definitionNative = "Звук, источник которого находится внутри мира истории и слышен героям.",
            example = "צְלִיל דִּיֵגֶטִי שֶׁל רַדְיוֹ בָּרֶכֶב מַעֲגִין אֶת הַסְּצֵנָה.",
            exampleNative = "צְלִיל דִּיֵגֶטִי автомобильного радио заземляет сцену в реальности.", fillInBlankExclusions = listOf(179501L, 179502L, 179504L)),

        WordEntity(id = 179504, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_theory", transliteration = "kir revii",
            original = "קִיר רְבִיעִי", translation = "четвёртая стена",
            definition = "מַחְסוֹם מְדֻמְיָן בֵּין הַדְּמֻיּוֹת לַקָּהָל שֶׁשְּׁבִירָתוֹ פּוֹנָה יָשִׁיר אֵלָיו.",
            definitionNative = "Воображаемый барьер между героями и публикой, прорыв которого — обращение к ней.",
            example = "הַסִּדְרָה שׁוֹבֶרֶת אֶת הַקִּיר הָרְבִיעִי וּפוֹנָה יָשִׁיר לַצּוֹפֶה.",
            exampleNative = "Сериал ломает קִיר רְבִיעִי и обращается напрямую к зрителю.",
            isFillInBlankSafe = false),

        WordEntity(id = 179505, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_theory", transliteration = "leitmotiv",
            original = "לֵיטְמוֹטִיב", translation = "лейтмотив",
            definition = "מוֹטִיב חוֹזֵר — מַנְגִּינָה אוֹ דִּמּוּי — שֶׁמִּתְקַשֵּׁר לִדְמוּת אוֹ לְרַעְיוֹן.",
            definitionNative = "Повторяющийся мотив — мелодия или образ, — связанный с героем или идеей.",
            example = "לְכָל גִּבּוֹר בַּסַּאגָה יֵשׁ לֵיטְמוֹטִיב מוּסִיקָלִי מִשֶּׁלּוֹ.",
            exampleNative = "У каждого героя саги есть свой музыкальный לֵיטְמוֹטִיב."),

        // ── entertainment_criticism (5) — кинокритика и анализ ────────────

        WordEntity(id = 179506, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_criticism", transliteration = "mevaker kolnoa",
            original = "מְבַקֵּר קוֹלְנוֹעַ", translation = "кинокритик",
            definition = "אִישׁ מִקְצוֹעַ שֶׁכּוֹתֵב הַעֲרָכוֹת מְעֻמָּקוֹת עַל סְרָטִים בָּעִתּוֹנוּת.",
            definitionNative = "Профессионал, что пишет глубокие разборы фильмов в прессе или онлайн.",
            example = "מְבַקֵּר קוֹלְנוֹעַ וָתִיק קָבַע שֶׁזֶּה הַסֶּרֶט הֲכִי טוֹב הַשָּׁנָה.",
            exampleNative = "Опытный מְבַקֵּר קוֹלְנוֹעַ объявил это лучшей картиной года.",
            isFillInBlankSafe = false),

        WordEntity(id = 179507, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_criticism", transliteration = "katava arukah",
            original = "כַּתָּבָה אֲרֻכָּה", translation = "лонгрид (длинная статья)",
            definition = "טֶקְסְט עִתּוֹנָאִי מַעֲמִיק שֶׁעוֹלֶה עַל אַלְפֵי מִלִּים וְחוֹקֵר נוֹשֵׂא לְעֹמֶק.",
            definitionNative = "Подробный журналистский текст на тысячи слов, что глубоко исследует тему.",
            example = "הַמַּגָּזִין פִּרְסֵם כַּתָּבָה אֲרֻכָּה עַל הַמְּחַבֵּר הַסּוֹדִי שֶׁל הַסִּדְרָה.",
            exampleNative = "Журнал опубликовал כַּתָּבָה אֲרֻכָּה о тайном авторе сериала.", fillInBlankExclusions = listOf(179506L, 179508L, 179509L, 179510L)),

        WordEntity(id = 179508, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_criticism", transliteration = "nituakh retrospektivi",
            original = "נִתּוּחַ רֶטְרוֹסְפֶּקְטִיבִי", translation = "ретроспективный анализ",
            definition = "הִתְבּוֹנְנוּת בִּיצִירָה שָׁנִים אַחֲרֵי יְצִיאָתָהּ — בְּהֶקְשֵׁר שֶׁל זְמַנָּהּ.",
            definitionNative = "Взгляд на произведение спустя годы после выхода, в свете его эпохи.",
            example = "נִתּוּחַ רֶטְרוֹסְפֶּקְטִיבִי חָשַׂף שִׁכְבוֹת חֲדָשׁוֹת בַּסֶּרֶט הַיָּשָׁן.",
            exampleNative = "נִתּוּחַ רֶטְרוֹסְפֶּקְטִיבִי вскрыл новые слои в старой картине.", fillInBlankExclusions = listOf(179506L, 179507L, 179509L, 179510L)),

        WordEntity(id = 179509, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_criticism", transliteration = "kri'ah semyotit",
            original = "קְרִיאָה סֶמְיוֹטִית", translation = "семиотическое прочтение",
            definition = "פֵּרוּשׁ יְצִירָה דַּרְכֵי הַסְּמָלִים וְהַסִּימָנִים שֶׁבָּהּ — וְלֹא הָעֲלִילָה לְבַד.",
            definitionNative = "Толкование произведения через знаки и символы, а не только через сюжет.",
            example = "קְרִיאָה סֶמְיוֹטִית שֶׁל הַסֵּרֶט מְגַלָּה רְבָדִים שֶׁל מַשְׁמָעוּת תַּת-מוּדָעַת.",
            exampleNative = "קְרִיאָה סֶמְיוֹטִית картины открывает пласты бессознательных значений.", fillInBlankExclusions = listOf(179506L, 179507L, 179508L, 179510L)),

        WordEntity(id = 179510, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_criticism", transliteration = "poetika shel sippur",
            original = "פּוֹאֶטִיקָה שֶׁל סִפּוּר", translation = "поэтика повествования",
            definition = "חֵקֶר עֶקְרוֹנוֹת הַבְּנִיָּה הָאָמָנוּתִית שֶׁל יְצִירָה סִפּוּרִית.",
            definitionNative = "Изучение принципов художественного построения нарративного произведения.",
            example = "פּוֹאֶטִיקָה שֶׁל סִפּוּר מְלַמֶּדֶת אֶת הַתַּלְמִיד לְפָרֵק טֶקְסְט סָבוּךְ.",
            exampleNative = "פּוֹאֶטִיקָה שֶׁל סִפּוּר учит студента разбирать сложный текст.", fillInBlankExclusions = listOf(179506L, 179507L, 179508L, 179509L)),

        // ── entertainment_philosophy (5) — философия искусства ────────────

        WordEntity(id = 179511, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_philosophy", transliteration = "khavaya omanutit",
            original = "חֲוָיָה אָמָנוּתִית", translation = "художественное переживание",
            definition = "מַצָּב נַפְשִׁי מְיֻחָד שֶׁמִּתְעוֹרֵר בְּקָהָל בִּזְמַן מִפְגָּשׁ עִם יְצִירָה.",
            definitionNative = "Особое душевное состояние, что возникает у публики при встрече с произведением.",
            example = "הַסֶּרֶט הָעֲנוּג חוֹלֵל חֲוָיָה אָמָנוּתִית עֲמוּקָה בְּכָל הָאוּלָם.",
            exampleNative = "Тонкий фильм пробудил глубокую חֲוָיָה אָמָנוּתִית во всём зале.", fillInBlankExclusions = listOf(179512L, 179513L, 179515L)),

        WordEntity(id = 179512, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_philosophy", transliteration = "hash'ayat i-emun",
            original = "הַשְׁעָיַת אִי-אֱמוּן", translation = "приостановка неверия",
            definition = "נְכוֹנוּת הַצּוֹפֶה לְהִתְעַלֵּם זְמַנִּית מֵאִי-סְבִירוּת כְּדֵי לֵהָנוֹת מֵהַסִּפּוּר.",
            definitionNative = "Готовность зрителя на время забыть о неправдоподобии ради вовлечения в историю.",
            example = "בְּלִי הַשְׁעָיַת אִי-אֱמוּן אִי אֶפְשָׁר לֵהָנוֹת מִסֵּרֶט פַנְטָסְיָה.",
            exampleNative = "Без הַשְׁעָיַת אִי-אֱמוּן невозможно получать удовольствие от фэнтези.", fillInBlankExclusions = listOf(179511L, 179515L)),

        WordEntity(id = 179513, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_philosophy", transliteration = "katarzis",
            original = "קָתַרְזִיס", translation = "катарсис",
            definition = "הִזְדַּכְּכוּת רִגְשִׁית שֶׁל הַקָּהָל אַחֲרֵי טְרָגֶדְיָה — שִׁחְרוּר פְּנִימִי.",
            definitionNative = "Эмоциональное очищение публики после трагедии — внутреннее освобождение.",
            example = "הַסּוֹף הַמַּרְעִיד שֶׁל הַסֶּרֶט הִשִּׁיג קָתַרְזִיס אֲמִתִּי.",
            exampleNative = "Пронзительный финал фильма дал зрителю настоящий קָתַרְזִיס.", fillInBlankExclusions = listOf(179511L, 179514L)),

        WordEntity(id = 179514, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "entertainment_philosophy", transliteration = "ha-nisgav",
            original = "הַנִּשְׂגָּב", translation = "возвышенное (категория эстетики)",
            definition = "תְּחוּשַׁת רוֹמְמוּת מְעוֹרֶבֶת בְּחַרְדָה מוּל יְצִירָה רַבַּת עָצְמָה.",
            definitionNative = "Чувство восторга, смешанного с трепетом, перед произведением огромной мощи.",
            example = "הַסְּצֵנָה הָרַחֲבָה שֶׁל הַיָּם מַעֲבֶרֶת אֶת הַנִּשְׂגָּב לַצּוֹפֶה.",
            exampleNative = "Раскинувшаяся сцена моря передаёт הַנִּשְׂגָּב зрителю.", fillInBlankExclusions = listOf(179513L)),

        WordEntity(id = 179515, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_philosophy", transliteration = "yetzira kolelet",
            original = "יְצִירָה כּוֹלֶלֶת", translation = "тотальное произведение (Gesamtkunstwerk)",
            definition = "חִבּוּר שֶׁל מוּסִיקָה, תְּמוּנָה, טֶקְסְט וְתְנוּעָה לְכְלִי בִּטּוּי אָמָנוּתִי אֶחָד.",
            definitionNative = "Сплав музыки, образа, текста и движения в единое художественное высказывание.",
            example = "וָגְנֶר חָלַם עַל יְצִירָה כּוֹלֶלֶת שֶׁתְּאַחֵד אֶת כָּל הָאָמָנוּיוֹת.",
            exampleNative = "Вагнер мечтал о יְצִירָה כּוֹלֶלֶת, что объединит все искусства разом.", fillInBlankExclusions = listOf(179511L, 179512L)),

        // ── entertainment_economics (5) — экономика индустрии ─────────────

        WordEntity(id = 179516, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_economics", transliteration = "boks ofis",
            original = "בּוֹקְס אוֹפִיס", translation = "бокс-офис (касса проката)",
            definition = "סְכוּם הַכֶּסֶף שֶׁסֵּרֶט מַכְנִיס מִכַּרְטִיסִים בְּבָתֵּי הַקּוֹלְנוֹעַ.",
            definitionNative = "Сумма, которую фильм собирает с продажи билетов в кинотеатрах по миру.",
            example = "הַסֶּרֶט שָׁבַר אֶת שִׂיא הַבּוֹקְס אוֹפִיס בְּסוֹף שָׁבוּעַ הַפְּתִיחָה.",
            exampleNative = "Фильм побил рекорд בּוֹקְס אוֹפִיס в первый же уикенд показа.", fillInBlankExclusions = listOf(179518L, 179520L)),

        WordEntity(id = 179517, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "entertainment_economics", transliteration = "tamlugim",
            original = "תַּמְלוּגִים", translation = "роялти / авторские отчисления",
            definition = "תַּשְׁלוּם תְּקוּפָתִי לְיוֹצֵר עַל כָּל שִׁמּוּשׁ בִּיצִירָתוֹ עַל יְדֵי אַחֵר.",
            definitionNative = "Регулярная плата автору за каждое использование его произведения другим.",
            example = "הַזַּמָּר חַי בַּשָּׁנִים הָאַחֲרוֹנוֹת מִתַּמְלוּגִים שֶׁל לַהִיט יָשָׁן.",
            exampleNative = "Певец последние годы живёт на תַּמְלוּגִים от старого хита.", fillInBlankExclusions = listOf(179518L, 179519L)),

        WordEntity(id = 179518, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_economics", transliteration = "hakhnasot nilvot",
            original = "הַכְנָסוֹת נִלְווֹת", translation = "побочные доходы (мерч, лицензии)",
            definition = "כֶּסֶף שֶׁמֵּגִיעַ מִמְכִירַת מוּצָרִים נִלְוִים — חֻלְצוֹת, צַעֲצוּעִים, רִשּׁוּיוֹת.",
            definitionNative = "Выручка от продажи побочных товаров — футболок, игрушек, лицензионных прав.",
            example = "הַכְנָסוֹת נִלְווֹת מֵהַסֵּרֶט עָבְרוּ אֶת רֵוַח הַקֻּפָּה עַצְמָהּ.",
            exampleNative = "הַכְנָסוֹת נִלְווֹת от франшизы превзошли прибыль самого проката.", fillInBlankExclusions = listOf(179516L, 179517L, 179519L, 179520L)),

        WordEntity(id = 179519, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "entertainment_economics", transliteration = "sindikatsya",
            original = "סִינְדִיקַצְיָה", translation = "синдикация (продажа сериала каналам)",
            definition = "מְכִירָה חוֹזֶרֶת שֶׁל סִדְרָה לְעֶרֶב רַב שֶׁל עֲרוּצִים אַחֲרֵי שִׁדּוּרָהּ הָרִאשׁוֹן.",
            definitionNative = "Перепродажа сериала множеству каналов после первого эфира на главной сети.",
            example = "סִינְדִיקַצְיָה שֶׁל הַסִּטְקוֹם מַזְרִימָה רֶוַח עוֹד עָשׂוֹר אַחֲרֵי הַסּוֹף.",
            exampleNative = "סִינְדִיקַצְיָה ситкома приносит прибыль ещё десятилетие после финала.", fillInBlankExclusions = listOf(179517L, 179518L)),

        WordEntity(id = 179520, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_economics", transliteration = "hekhzer hashka'ah",
            original = "הֶחְזֵר הַשְׁקָעָה", translation = "окупаемость / возврат инвестиций",
            definition = "יַחַס בֵּין הַכְנָסַת הַסֶּרֶט לְבֵין הַסְּכוּם שֶׁהֻצַּא עַל הֲפָקָתוֹ וְשִׁוּוּקוֹ.",
            definitionNative = "Соотношение сборов фильма к сумме, потраченной на его создание и продвижение.",
            example = "הֶחְזֵר הַשְׁקָעָה שֶׁל הַסֶּרֶט הָעַצְמָאִי הִפְתִּיעַ אֶת הַסְּטוּדְיוֹ הַגָּדוֹל.",
            exampleNative = "הֶחְזֵר הַשְׁקָעָה независимой картины удивил большую студию.", fillInBlankExclusions = listOf(179516L, 179518L)),

        // ── entertainment_advanced_genres (5) — продвинутые жанры ─────────

        WordEntity(id = 179521, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_advanced_genres", transliteration = "realizm magi",
            original = "רֵיאָלִיזְם מָאגִי", translation = "магический реализм",
            definition = "סִגְנוֹן שֶׁבּוֹ פְּלָאִים מְשׁוּלָּבִים בְּחַיֵּי יוֹם-יוֹם בְּלִי שֶׁאִישׁ יִתְפַּלֵּא.",
            definitionNative = "Стиль, где чудеса вплетены в обыденную жизнь, и никто им не удивляется.",
            example = "רֵיאָלִיזְם מָאגִי אָפְיָנִי לִיצִירוֹתָיו שֶׁל גַּבְּרִיאֵל גַּרְסִיָּה מַארְקֶס.",
            exampleNative = "רֵיאָלִיזְם מָאגִי характерен для прозы Габриэля Гарсиа Маркеса.", fillInBlankExclusions = listOf(179522L, 179523L, 179524L)),

        WordEntity(id = 179522, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_advanced_genres", transliteration = "neo nuar",
            original = "נֵיאוֹ-נוּאַר", translation = "нео-нуар (жанр)",
            definition = "פִּיתּוּחַ מוֹדֶרְנִי שֶׁל סִרְטֵי פֶּשַׁע אֲפֵלִים — צֵל כָּבֵד, גִּבּוֹר מִתְלַבֵּט, עוֹלָם לֹא וַדָּאִי.",
            definitionNative = "Современная версия мрачных фильмов о преступлениях — тяжёлые тени, противоречивый герой, неясный мир.",
            example = "נֵיאוֹ-נוּאַר אָמֵרִיקָאִי שֶׁל שְׁנוֹת הַשִּׁבְעִים בָּעַט בְּסוֹד הָאָבוֹת הַמּוֹסְדִיִּים.",
            exampleNative = "Американский נֵיאוֹ-נוּאַר семидесятых ударил по тайне отцов-основателей.", fillInBlankExclusions = listOf(179521L, 179523L, 179524L)),

        WordEntity(id = 179523, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_advanced_genres", transliteration = "bidyon muzar",
            original = "בִּדְיוֹן מוּזָר", translation = "странная фантастика (weird fiction)",
            definition = "סִפְרוּת שֶׁל אֵימָה אֶקְזִיסְטֶנְצְיָאלִית מוּל יְצוּרִים שֶׁאֵינָם מוּבָנִים לָאָדָם.",
            definitionNative = "Литература экзистенциального ужаса перед сущностями вне человеческого понимания.",
            example = "לַבְקְרַפְט נֶחְשָׁב לְאַבִי הַבִּדְיוֹן הַמּוּזָר הַמּוֹדֶרְנִי.",
            exampleNative = "Лавкрафт считается отцом современного בִּדְיוֹן מוּזָר.",
            isFillInBlankSafe = false),

        WordEntity(id = 179524, setId = 1795, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_advanced_genres", transliteration = "sidrah antologit",
            original = "סִדְרָה אַנְתוֹלוֹגִית", translation = "сериал-антология",
            definition = "פוֹרְמָט שֶׁבּוֹ כָּל עוֹנָה אוֹ פֶּרֶק מְסַפֵּר סִפּוּר עַצְמָאִי עִם דְּמֻיּוֹת חֲדָשׁוֹת.",
            definitionNative = "Формат, где каждый сезон или эпизод — самостоятельная история с новыми героями.",
            example = "הַסִּדְרָה הָאַנְתוֹלוֹגִית מַחֲלִיפָה אֶת כָּל הַדְּמֻיּוֹת בֵּין הָעוֹנוֹת.",
            exampleNative = "סִדְרָה אַנְתוֹלוֹגִית меняет весь актёрский состав между сезонами.",
            isFillInBlankSafe = false),

        WordEntity(id = 179525, setId = 1795, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "entertainment_advanced_genres", transliteration = "dizel-pank",
            original = "דִיזֶל-פַּאנְק", translation = "дизельпанк (ретрофутуризм межвоенной эпохи)",
            definition = "דְּמוּי-עַתִּיד שֶׁמְּעַצֵּב מְכוֹנוֹת כְּבֵדוֹת בְּרוּחַ שְׁנוֹת הַשְּׁלוֹשִׁים וְהָאַרְבָּעִים.",
            definitionNative = "Образ будущего с тяжёлыми машинами в духе тридцатых и сороковых годов.",
            example = "הַמִּשְׂחָק הַחָדָשׁ מְעַצֵּב עוֹלָם בְּסִגְנוֹן דִיזֶל-פַּאנְק עָצוּב וּמְעֻשָּׁן.",
            exampleNative = "Новая игра рисует мрачный закопчённый мир в стиле דִיזֶל-פַּאנְק."),

    )
}
