package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1904 (he-ru).
 * Журналист: цифровая журналистика и fact-checking (L4 / RARE + EPIC).
 *
 * Зеркало en-ru set 471. Точечное расширение темы «Журналист»
 * (в he-ru тема называется «Журналист», без формы «Журналистика»).
 * Подтема — современные практики цифровой журналистики 2020-х:
 *   fact-checking (проверка источников, первичный/вторичный источник,
 *     поправка, ретракция),
 *   дезинформация (мис-информация, фейк-репорт, deepfake, conspiracy,
 *     manipulated media),
 *   digital-форматы (longform, newsletter, native ad, paywall, clickbait),
 *   профлексика (dateline, lede, scoop, op-ed, investigative),
 *   workflow (OSINT, beat reporter, wire service, cross-check, data
 *     journalism).
 *
 * Исключены как дубли с существующими he-ru сетами темы «Журналист»
 * (Batch59, 60, 73, 91) и шире:
 *   - אִימּוּת עֻבְדוֹת (fact-checking) — Batch59 → заменено на саму концепцию
 *     verification через אִימוּת מָקוֹר + структуру источников.
 *   - הַפְרָכָה (debunk) — Batch46 → заменено на הִתַּקְּנוּת (correction) и
 *     חֲזָרָה מִפִּרְסוּם (retraction) — более точная редакционная лексика.
 *   - תַּעֲמוּלָה (propaganda) — Batch48/49 → заменено на יְדִיעַת כָּזָב
 *     и תּוֹכֶן שׁוּטָה.
 *   - פּוֹדְקָאסְט — Batch73 → заменено на עַלּוֹן דִּיגִיטָלִי (newsletter).
 *   - אֶמְבַּרְגוֹ — Batch73 → заменено на שׁוֹרַת תַּאֲרִיךְ (dateline).
 *   - חֲתִימָה (signature) — Batch62, LawL1, UrbanLifeL1 → byline ушёл,
 *     взяли פֶּתִיחַת כַּתָּבָה (lede).
 *   - מֵידָע כּוֹזֵב (disinformation) — семантический дубль Batch59
 *     דֶּזִינְפוֹרְמַצְיָה → заменено на יְדִיעַת כָּזָב.
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   RARE — 10 слов (B2, общепонятная профлексика журналиста, знакомая
 *          любому, кто читал про медиа: misinfo, deepfake, clickbait,
 *          longform, scoop, op-ed, investigative, beat reporter).
 *   EPIC — 15 слов (C1, профессиональная лексика fact-checker'а и
 *          цифрового редактора: primary/secondary source, retraction,
 *          manipulated media, conspiracy, native ad, paywall, dateline,
 *          lede, OSINT, wire service, cross-check, data journalism).
 *
 * Пять семантических подгрупп:
 *   journalism_fact_checking   — 5 слов: проверка фактов и источников
 *   journalism_disinformation  — 5 слов: дезинформация и манипуляции
 *   journalism_digital_formats — 5 слов: цифровые форматы публикации
 *   journalism_pro_lexicon     — 5 слов: профлексика репортёра
 *   journalism_workflow        — 5 слов: рабочий процесс цифровой редакции
 *
 * Word IDs: 190401..190425 (setId × 100 + position).
 */
object WordDataHebrewJournalismDigital {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1904, languagePair = "he-ru", orderIndex = 1904,
            name = "Журналист",
            description = "Fact-checking и цифровая журналистика: проверка источников (אִימוּת מָקוֹר, מָקוֹר רִאשׁוֹנִי), дезинформация (זִיּוּף עָמוֹק, יְדִיעַת כָּזָב), форматы (כַּתָּבָה אֲרוּכָה, חוֹמַת תַּשְׁלוּם)",
            topic = "Журналист",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: journalism_fact_checking (5 words) ─────────────────────────

        WordEntity(id = 190401, setId = 1904, languagePair = "he-ru", rarity = "RARE",
            original = "אִימוּת מָקוֹר",
            translation = "верификация источника",
            definition = "תַּהֲלִיךְ בְּדִיקָה שֶׁמְּוַדֵּא כִּי הָאָדָם אוֹ הַמִּסְמָךְ קַיָּימִים וּמְהֵימָנִים.",
            definitionNative = "Процесс проверки, что человек или документ реально существуют и заслуживают доверия.",
            example = "אִימוּת מָקוֹר זִהָה תְּמוּנָה יְשָׁנָה מִשִּׁישִּׁים וְשֵׁשׁ.",
            exampleNative = "אִימוּת מָקוֹר опознал старое фото шестьдесят шестого года.",
            transliteration = "имут макор",
            pos = "phrase", semanticGroup = "journalism_fact_checking", fillInBlankExclusions = listOf(190402L, 190403L, 190405L, 190424L)),

        WordEntity(id = 190402, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "מָקוֹר רִאשׁוֹנִי",
            translation = "первичный источник",
            definition = "אָדָם אוֹ מִסְמָךְ שֶׁהָיָה נוֹכַח בָּאֵירוּעַ אוֹ יָצָר אוֹתוֹ — בְּלִי תִּוּוּךְ.",
            definitionNative = "Человек или документ, бывший на самом событии или создавший его — без посредников.",
            example = "הַתַּחְקִיר נִשְׁעַן עַל מָקוֹר רִאשׁוֹנִי שֶׁעָבַד בַּמִּשְׂרָד.",
            exampleNative = "Расследование опиралось на מָקוֹר רִאשׁוֹנִי из самого министерства.",
            transliteration = "макор ришони",
            pos = "phrase", semanticGroup = "journalism_fact_checking", fillInBlankExclusions = listOf(190401L, 190403L, 190405L)),

        WordEntity(id = 190403, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "מָקוֹר מִשְׁנִי",
            translation = "вторичный источник",
            definition = "אָדָם אוֹ טֶקְסְט שֶׁמְּסַפֵּר עַל הָאֵירוּעַ מִכְּלִי שֵׁנִי, לֹא מִתּוֹךְ חֲוָיָה יְשִׁירָה.",
            definitionNative = "Человек или текст, рассказывающий о событии с чужих слов, не из личного опыта.",
            example = "סֵפֶר הִיסְטוֹרְיָה הוּא מָקוֹר מִשְׁנִי שֶׁמְּסַכֵּם תְּעוּדוֹת רַבּוֹת.",
            exampleNative = "Учебник истории — это מָקוֹר מִשְׁנִי, обобщающий много документов.",
            transliteration = "макор мишни",
            pos = "phrase", semanticGroup = "journalism_fact_checking", fillInBlankExclusions = listOf(190401L, 190402L, 190405L)),

        WordEntity(id = 190404, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "הִתַּקְּנוּת",
            translation = "поправка к публикации",
            definition = "פִּסְקָה קְצָרָה שֶׁנּוֹסֶפֶת לְכַתָּבָה כְּדֵי לְתַקֵּן טָעוּת עוּבְדָתִית שֶׁהִתְגַּלְּתָה.",
            definitionNative = "Короткий абзац, который добавляют к статье, чтобы исправить найденную фактическую ошибку.",
            example = "הָעוֹרֵךְ פִּרְסֵם הִתַּקְּנוּת קְצָרָה בְּתַחְתִּית הַמַּאֲמָר.",
            exampleNative = "Редактор опубликовал короткую הִתַּקְּנוּת внизу статьи.",
            transliteration = "hитакнут",
            pos = "noun", semanticGroup = "journalism_fact_checking", fillInBlankExclusions = listOf(190405L)),

        WordEntity(id = 190405, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "חֲזָרָה מִפִּרְסוּם",
            translation = "отзыв публикации",
            definition = "צַעַד חָרִיף שֶׁבּוֹ הָעִתּוֹן מוֹחֵק כַּתָּבָה שְׁלֵמָה בִּגְלַל טָעוּת חֲמוּרָה.",
            definitionNative = "Резкий шаг, когда газета удаляет всю статью целиком из-за серьёзной ошибки.",
            example = "חֲזָרָה מִפִּרְסוּם נִדְרְשָׁה אַחֲרֵי שֶׁהַתְּמוּנָה הִתְבָּרְרָה מְזֻיֶּפֶת.",
            exampleNative = "חֲזָרָה מִפִּרְסוּם понадобилась, когда фото оказалось подделкой.",
            transliteration = "хазара ми-пирсум",
            pos = "phrase", semanticGroup = "journalism_fact_checking", fillInBlankExclusions = listOf(190401L, 190402L, 190403L, 190404L)),

        // ── Group: journalism_disinformation (5 words) ────────────────────────

        WordEntity(id = 190406, setId = 1904, languagePair = "he-ru", rarity = "RARE",
            original = "מֵידָע מוּטְעֶה",
            translation = "мисинформация",
            definition = "יְדִיעָה לֹא נְכוֹנָה שֶׁמְּפִיצִים אוֹתָהּ בְּתֹם לֵב, בְּלִי כַּוָּנָה לְהַזִּיק.",
            definitionNative = "Неверная новость, которую распространяют от чистого сердца, без злого умысла.",
            example = "מֵידָע מוּטְעֶה עַל הַחִסּוּן הִתְפַּשֵּׁט בִּקְבוּצוֹת אִמָּהוֹת.",
            exampleNative = "מֵידָע מוּטְעֶה о прививке разлетелся по чатам мам.",
            transliteration = "мэйда мутъе",
            pos = "phrase", semanticGroup = "journalism_disinformation", fillInBlankExclusions = listOf(190407L, 190408L, 190409L, 190410L)),

        WordEntity(id = 190407, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "יְדִיעַת כָּזָב",
            translation = "ложный репортаж",
            definition = "פִּרְסוּם שֶׁנִּכְתָּב בְּכַוָּנָה לְהַטְעוֹת אֶת הַקּוֹרֵא לְמַטָּרָה פּוֹלִיטִית אוֹ מִסְחָרִית.",
            definitionNative = "Публикация, написанная с намерением ввести читателя в заблуждение ради политики или денег.",
            example = "יְדִיעַת כָּזָב עַל הַמּוּעֲמָד הוּפְצָה לִפְנֵי הַבְּחִירוֹת.",
            exampleNative = "יְדִיעַת כָּזָב о кандидате разошлась перед выборами.",
            transliteration = "йедиат казав",
            pos = "phrase", semanticGroup = "journalism_disinformation", fillInBlankExclusions = listOf(190406L, 190408L, 190409L, 190410L)),

        WordEntity(id = 190408, setId = 1904, languagePair = "he-ru", rarity = "RARE",
            original = "זִיּוּף עָמוֹק",
            translation = "дипфейк",
            definition = "סִרְטוֹן מְזֻיָּף שֶׁנּוֹצָר עַל יְדֵי בִּינָה מְלָאכוּתִית וּמַרְאֶה אָדָם אוֹמֵר דְּבָרִים שֶׁלֹּא אָמַר.",
            definitionNative = "Поддельное видео, созданное ИИ: человек говорит на нём то, чего на самом деле не произносил.",
            example = "זִיּוּף עָמוֹק שֶׁל הָרֹאשׁ מֶמְשָׁלָה הִטְעָה מִלְיוֹן צוֹפִים.",
            exampleNative = "זִיּוּף עָמוֹק премьера обманул миллион зрителей.",
            transliteration = "зийуф амок",
            pos = "phrase", semanticGroup = "journalism_disinformation", fillInBlankExclusions = listOf(190406L, 190407L, 190409L, 190410L)),

        WordEntity(id = 190409, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "תּוֹכֶן שׁוּטָה",
            translation = "манипулированный контент",
            definition = "תְּמוּנָה אוֹ סִרְטוֹן שֶׁעָבַר עֲרִיכָה עָרְמוּמִית כְּדֵי לְשַׁנּוֹת אֶת הַמַּשְׁמָעוּת הַמְּקוֹרִית.",
            definitionNative = "Картинка или видео, прошедшее лукавую правку, чтобы изменить исходный смысл.",
            example = "הָאֲתָר הִסִּיר תּוֹכֶן שׁוּטָה אַחֲרֵי תְּלוּנַת קוֹרְאִים.",
            exampleNative = "Сайт убрал תּוֹכֶן שׁוּטָה после жалобы читателей.",
            transliteration = "тохэн шута",
            pos = "phrase", semanticGroup = "journalism_disinformation", fillInBlankExclusions = listOf(190406L, 190407L, 190408L, 190410L, 190413L)),

        WordEntity(id = 190410, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "תַּאֲחִיזוֹת קֶשֶׁר",
            translation = "конспирологическая теория",
            definition = "סִפּוּר שֶׁמְּסַבֵּר אֵירוּעַ כְּתוֹצָאָה שֶׁל מְזִמָּה סוֹדִית שֶׁל קְבוּצָה רַבַּת עוֹצְמָה.",
            definitionNative = "Рассказ, объясняющий событие тайным заговором могущественной группы.",
            example = "תַּאֲחִיזוֹת קֶשֶׁר עַל הַיָּרֵחַ עֲדַיִן חַיּוֹת בָּרֶשֶׁת.",
            exampleNative = "תַּאֲחִיזוֹת קֶשֶׁר о Луне до сих пор живут в сети.",
            transliteration = "таахизот кэшэр",
            pos = "phrase", semanticGroup = "journalism_disinformation", fillInBlankExclusions = listOf(190406L, 190407L, 190408L, 190409L)),

        // ── Group: journalism_digital_formats (5 words) ───────────────────────

        WordEntity(id = 190411, setId = 1904, languagePair = "he-ru", rarity = "RARE",
            original = "כַּתָּבָה אֲרוּכָה",
            translation = "лонгрид",
            definition = "פּוֹרְמָט שֶׁל סִפּוּר מַעֲמִיק עִם תְּמוּנוֹת וּגְרָפִיקָה, שֶׁאוֹרְכוֹ אַלְפֵי מִילִּים.",
            definitionNative = "Формат глубокого рассказа с фото и графикой, длиной в тысячи слов.",
            example = "הִיא קָרְאָה כַּתָּבָה אֲרוּכָה עַל מִשְׁפַּחַת רוֹמָנוֹב כָּל הַלַּיְלָה.",
            exampleNative = "Она читала כַּתָּבָה אֲרוּכָה о семье Романовых всю ночь.",
            transliteration = "катава арука",
            pos = "phrase", semanticGroup = "journalism_digital_formats", fillInBlankExclusions = listOf(190412L, 190413L, 190414L, 190415L)),

        WordEntity(id = 190412, setId = 1904, languagePair = "he-ru", rarity = "RARE",
            original = "עַלּוֹן דִּיגִיטָלִי",
            translation = "цифровая рассылка",
            definition = "מִכְתָּב קָבוּעַ שֶׁמַּגִּיעַ לַתֵּבָה שֶׁל הַמִּנּוּי וּמְכִיל סְקִירָה אוֹ טוּר אִישִׁי.",
            definitionNative = "Регулярное письмо, приходящее подписчику в ящик, с обзором или авторской колонкой.",
            example = "הוּא מַפְעִיל עַלּוֹן דִּיגִיטָלִי שָׁבוּעִי עִם שְׁלוֹשִׁים אֶלֶף מַנּוּיִים.",
            exampleNative = "Он ведёт еженедельный עַלּוֹן דִּיגִיטָלִי с тридцатью тысячами подписчиков.",
            transliteration = "алон дигитали",
            pos = "phrase", semanticGroup = "journalism_digital_formats", fillInBlankExclusions = listOf(190411L, 190413L, 190414L, 190415L)),

        WordEntity(id = 190413, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "פִּרְסוֹמֶת יְלִידָה",
            translation = "нативная реклама",
            definition = "מוֹדָעָה שֶׁמְּחֻפֶּשֶׂת לְכַתָּבָה רְגִילָה וְמַסְוָה אֶת אוֹפְיָהּ הַשִּׁוּוּקִי.",
            definitionNative = "Объявление, замаскированное под обычную статью и прячущее рекламный характер.",
            example = "סִימּוּן «בְּחָסוּת» מַבְדִּיל פִּרְסוֹמֶת יְלִידָה מִכַּתָּבָה אֲמִתִּית.",
            exampleNative = "Пометка «на правах» отличает פִּרְסוֹמֶת יְלִידָה от настоящей статьи.",
            transliteration = "пирсомэт йэлида",
            pos = "phrase", semanticGroup = "journalism_digital_formats", fillInBlankExclusions = listOf(190411L, 190412L, 190414L, 190415L)),

        WordEntity(id = 190414, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "חוֹמַת תַּשְׁלוּם",
            translation = "пэйвол",
            definition = "מַחְסוֹם בָּאֲתָר שֶׁחוֹסֵם אֶת הַתֹּכֶן עַד שֶׁהַקּוֹרֵא נִרְשָׁם וּמְשַׁלֵּם.",
            definitionNative = "Барьер на сайте, закрывающий материал до тех пор, пока читатель не подпишется и не заплатит.",
            example = "חוֹמַת תַּשְׁלוּם נִפְתְּחָה אַחֲרֵי שְׁלוֹשׁ כַּתָּבוֹת בְּחִנָּם.",
            exampleNative = "חוֹמַת תַּשְׁלוּם включилась после трёх бесплатных статей.",
            transliteration = "хомат ташлум",
            pos = "phrase", semanticGroup = "journalism_digital_formats", fillInBlankExclusions = listOf(190411L, 190412L, 190413L, 190415L)),

        WordEntity(id = 190415, setId = 1904, languagePair = "he-ru", rarity = "RARE",
            original = "כּוֹתֶרֶת פִּתָּיוֹן",
            translation = "кликбейтный заголовок",
            definition = "שׁוּרָה רוֹמֶזֶת שֶׁמַּבְטִיחָה גִּלּוּי מַרְעִיד וְלֹא מְקַיֶּמֶת אֶת הַהַבְטָחָה בְּתוֹךְ הַטֶּקְסְט.",
            definitionNative = "Намекающая строчка, обещающая сногсшибательное открытие и не сдерживающая обещание в тексте.",
            example = "כּוֹתֶרֶת פִּתָּיוֹן הִכְנִיסָה אֶלֶף קְלִיקִים בְּשָׁעָה אַחַת.",
            exampleNative = "כּוֹתֶרֶת פִּתָּיוֹן принесла тысячу кликов за один час.",
            transliteration = "котэрэт питайон",
            pos = "phrase", semanticGroup = "journalism_digital_formats", fillInBlankExclusions = listOf(190411L, 190412L, 190413L, 190414L, 190418L)),

        // ── Group: journalism_pro_lexicon (5 words) ───────────────────────────

        WordEntity(id = 190416, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "שׁוֹרַת תַּאֲרִיךְ",
            translation = "датлайн (место и день)",
            definition = "שׁוּרָה קְצָרָה בְּרֹאשׁ הַכַּתָּבָה שֶׁמּוֹסֶרֶת מֵאֵיפֹה וּמֵאֵיזֶה יוֹם הַדִּוּוּחַ.",
            definitionNative = "Короткая строчка в начале статьи, сообщающая, откуда и какого числа сделан репортаж.",
            example = "שׁוֹרַת תַּאֲרִיךְ אָמְרָה «יְרוּשָׁלַיִם, יוֹם שֵׁנִי».",
            exampleNative = "שׁוֹרַת תַּאֲרִיךְ гласила «Иерусалим, понедельник».",
            transliteration = "шурат тарих",
            pos = "phrase", semanticGroup = "journalism_pro_lexicon"),

        WordEntity(id = 190417, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "פֶּתִיחַת כַּתָּבָה",
            translation = "лид (вступительный абзац)",
            definition = "פִּסְקָה רִאשׁוֹנָה שֶׁמּוֹשֶׁכֶת אֶת הַקּוֹרֵא וּמְסַכֶּמֶת אֶת עִיקַּר הַסִּפּוּר בְּמִשְׁפָּטִים סְפוּרִים.",
            definitionNative = "Первый абзац, цепляющий читателя и излагающий суть истории в нескольких предложениях.",
            example = "פֶּתִיחַת כַּתָּבָה חַדָּה הֶחְזִיקָה אֶת הַקּוֹרֵא עַד הַסּוֹף.",
            exampleNative = "Острая פֶּתִיחַת כַּתָּבָה удержала читателя до конца.",
            transliteration = "птихат катава",
            pos = "phrase", semanticGroup = "journalism_pro_lexicon", fillInBlankExclusions = listOf(190416L, 190419L, 190420L)),

        WordEntity(id = 190418, setId = 1904, languagePair = "he-ru", rarity = "RARE",
            original = "סְקוּפ",
            translation = "сенсационный эксклюзив",
            definition = "סִפּוּר שֶׁעִתּוֹן אֶחָד פִּרְסֵם רִאשׁוֹן, לִפְנֵי הַמִּתְחָרִים, וְהָפַךְ שִׂיחַת הַיּוֹם.",
            definitionNative = "История, которую одна газета опубликовала первой, раньше конкурентов, и сделала темой дня.",
            example = "הַתַּחְקִירָן הִשִּׂיג סְקוּפ עַל שֹׁחַד בְּעִירִיָּה.",
            exampleNative = "Расследователь добыл סְקוּפ о взятках в мэрии.",
            transliteration = "скуп",
            pos = "noun", semanticGroup = "journalism_pro_lexicon"),

        WordEntity(id = 190419, setId = 1904, languagePair = "he-ru", rarity = "RARE",
            original = "טוּר דֵּעוֹת",
            translation = "колонка мнений (op-ed)",
            definition = "מַאֲמָר אִישִׁי שֶׁבּוֹ הַכּוֹתֵב מַבִּיעַ עֶמְדָּה גְּלוּיָה עַל סוּגְיָה עַכְשָׁוִית.",
            definitionNative = "Авторская статья, в которой пишущий открыто высказывает позицию по злободневному вопросу.",
            example = "טוּר דֵּעוֹת חָרִיף שֶׁל הַסּוֹפֶרֶת עוֹרֵר וִכּוּחַ בָּרֶשֶׁת.",
            exampleNative = "Резкая טוּר דֵּעוֹת писательницы вызвала спор в сети.",
            transliteration = "тур дэот",
            pos = "phrase", semanticGroup = "journalism_pro_lexicon", fillInBlankExclusions = listOf(190416L, 190417L, 190420L)),

        WordEntity(id = 190420, setId = 1904, languagePair = "he-ru", rarity = "RARE",
            original = "עִתּוֹנָאוּת חוֹקֶרֶת",
            translation = "расследовательская журналистика",
            definition = "סוּג עֲבוֹדָה שֶׁדּוֹרֵשׁ חֳדָשִׁים שֶׁל אִסּוּף מִסְמָכִים וְעֵדִים כְּדֵי לַחֲשֹׂף עֲוָלָה.",
            definitionNative = "Работа, требующая месяцев сбора документов и свидетелей, чтобы вскрыть несправедливость.",
            example = "עִתּוֹנָאוּת חוֹקֶרֶת חָשְׂפָה אֶת הַפָּרָשָׁה לִפְנֵי הַפְּרַקְלִיטוּת.",
            exampleNative = "עִתּוֹנָאוּת חוֹקֶרֶת раскрыла дело раньше прокуратуры.",
            transliteration = "итонаут хокэрэт",
            pos = "phrase", semanticGroup = "journalism_pro_lexicon", fillInBlankExclusions = listOf(190416L, 190417L, 190419L, 190425L)),

        // ── Group: journalism_workflow (5 words) ──────────────────────────────

        WordEntity(id = 190421, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "מוֹדִיעִין מְקוֹרוֹת פְּתוּחִים",
            translation = "OSINT",
            definition = "שִׁיטָה שֶׁאוֹסֶפֶת רְמָזִים מִתְּמוּנוֹת רֶשֶׁת, מַפּוֹת וְרֶגֶשׁ צִבּוּרִי גְּלוּיִים לְכָל אֶחָד.",
            definitionNative = "Метод, собирающий улики из сетевых фото, карт и публичных постов, доступных каждому.",
            example = "מוֹדִיעִין מְקוֹרוֹת פְּתוּחִים אִתֵּר טַנְק לְפִי צֵל וְשֶׁמֶשׁ.",
            exampleNative = "מוֹדִיעִין מְקוֹרוֹת פְּתוּחִים нашёл танк по тени и солнцу.",
            transliteration = "модиин мэкорот птухим",
            pos = "phrase", semanticGroup = "journalism_workflow", fillInBlankExclusions = listOf(190422L, 190423L, 190424L, 190425L)),

        WordEntity(id = 190422, setId = 1904, languagePair = "he-ru", rarity = "RARE",
            original = "כְּתָב נֵגֶד",
            translation = "профильный репортёр",
            definition = "עִתּוֹנַאי שֶׁמִּתְמַחֶה בְּשָׂדֶה צַר אֶחָד וּמַכִּיר אִישִׁית אֶת כָּל הַשַּׂחְקָנִים שָׁם.",
            definitionNative = "Журналист, специализирующийся на одной узкой области и знающий лично всех её игроков.",
            example = "הוּא כְּתָב נֵגֶד לְבִּטָּחוֹן וּמַגִּיעַ לְכָל מְסִיבַּת עִתּוֹנָאִים.",
            exampleNative = "Он — כְּתָב נֵגֶד по обороне и бывает на каждом брифинге.",
            transliteration = "ктав нэгэд",
            pos = "phrase", semanticGroup = "journalism_workflow", fillInBlankExclusions = listOf(190421L, 190423L, 190424L, 190425L)),

        WordEntity(id = 190423, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "כְּתַב צָבִיר",
            translation = "корреспондент агентства",
            definition = "כּוֹתֵב שֶׁעוֹבֵד בְּסוֹכְנוּת חֲדָשׁוֹת בֵּינְלְאוּמִית וּמַסְפִּיק חָמְרִים לְמֵאוֹת עִתּוֹנִים.",
            definitionNative = "Репортёр международного информагентства, поставляющий материалы сотням газет.",
            example = "כְּתַב צָבִיר שִׁדֵּר אֶת הַיְּדִיעָה לְ-AP חֲצִי שָׁעָה אַחֲרֵי הַפִּגּוּעַ.",
            exampleNative = "כְּתַב צָבִיר передал новость в AP через полчаса после теракта.",
            transliteration = "ктав цавир",
            pos = "phrase", semanticGroup = "journalism_workflow", fillInBlankExclusions = listOf(190421L, 190422L, 190424L, 190425L)),

        WordEntity(id = 190424, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "בְּדִיקָה צוֹלֶבֶת",
            translation = "перекрёстная сверка",
            definition = "שִׁיטָה שֶׁמּוֹדֶדֶת אוֹתָהּ עוּבְדָּה מוּל שְׁנֵי מְקוֹרוֹת בִּלְתִּי תְּלוּיִים לְפָחוֹת.",
            definitionNative = "Метод, который проверяет один и тот же факт по двум независимым источникам минимум.",
            example = "בְּדִיקָה צוֹלֶבֶת פָּסְלָה אֶת הַסִּפּוּר עַל הַשַּׂר אַחֲרֵי שָׁעָה.",
            exampleNative = "בְּדִיקָה צוֹלֶבֶת забраковала рассказ про министра за час.",
            transliteration = "бдика цолэвэт",
            pos = "phrase", semanticGroup = "journalism_workflow", fillInBlankExclusions = listOf(190401L, 190421L, 190422L, 190423L, 190425L)),

        WordEntity(id = 190425, setId = 1904, languagePair = "he-ru", rarity = "EPIC",
            original = "עִתּוֹנָאוּת נְתוּנִים",
            translation = "журналистика данных",
            definition = "כִּוּוּן עֲבוֹדָה שֶׁמְּחַלֵּץ סִפּוּרִים מִטַּבְלָאוֹת, מַאֲגָרֵי מֵידָע וּגְרָפִים סְטָטִיסְטִיִּים.",
            definitionNative = "Направление работы, добывающее истории из таблиц, баз данных и статистических графиков.",
            example = "עִתּוֹנָאוּת נְתוּנִים גִּלְּתָה מַגָּמָה בְּפַעֲרֵי שָׂכָר בְּצָפוֹן הָאָרֶץ.",
            exampleNative = "עִתּוֹנָאוּת נְתוּנִים нашла тренд в разнице зарплат на севере страны.",
            transliteration = "итонаут нэтуним",
            pos = "phrase", semanticGroup = "journalism_workflow", fillInBlankExclusions = listOf(190420L, 190421L, 190422L, 190423L, 190424L)),
    )
}
