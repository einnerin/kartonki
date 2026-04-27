package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "AI и ML", L2 «Продвинутый» (UNCOMMON+RARE).
 *
 * Set 1787: «AI и ML» — продвинутый L2:
 *           Лексика обычного пользователя AI-помощников (ChatGPT, Claude, Gemini):
 *           prompt-инженерия, типовые задачи, проверка ответов, риски и ответственность.
 *
 * Тема ориентирована на офисного работника / студента / журналиста, который пользуется
 * AI-чатами в повседневной работе и хочет говорить об этом на иврите. Лексика
 * смешанная: иврит + английские заимствования (פְּרוֹמְפְּט, פַקְט-צֶ'קִינְג,
 * פְּלָגְיָאט) — так реально говорят в израильских офисах в 2026 году.
 *
 * Распределение редкостей: 13 UNCOMMON + 12 RARE.
 *
 * SemanticGroups (5 × 5):
 *   aiml_user_prompts        — формулировка подсказки: точность, контекст, пример, тон, длина
 *   aiml_user_workflows      — типовые задачи: черновик письма, идея, конспект, перевод, код
 *   aiml_user_verification   — проверка ответа: факт-чекинг, источник, цитирование, повтор
 *   aiml_user_risks          — риски: устаревшие знания, выдумка, плагиат, авторство, утечка
 *   aiml_user_responsibility — ответственность: этика, подпись, согласие, политика, правила
 *
 * Word IDs: setId × 100 + position (178701..178725).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewAiMlL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1787, languagePair = "he-ru", orderIndex = 1787,
            name = "AI и ML",
            description = "Продвинутый базовый: prompt-инженерия, использование, проверка, риски",
            topic = "AI и ML", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1787 — AI и ML: продвинутый (L2, UNCOMMON+RARE)
        // 5 групп × 5 слов: prompts, workflows, verification, risks, responsibility
        // ══════════════════════════════════════════════════════════════════════

        // ── aiml_user_prompts (5) — как формулировать подсказку ──
        WordEntity(
            id = 178701, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_prompts", transliteration = "hanchaya meduyeket",
            original = "הַנְחָיָה מְדֻיֶּקֶת", translation = "точная подсказка",
            definition = "נִיסּוּחַ בָּהִיר וְצַר שֶׁמַּסְבִּיר לַמּוֹדֵל בְּדִיּוּק מָה רוֹצִים לְקַבֵּל בַּתְּשׁוּבָה.",
            definitionNative = "Чёткая узкая формулировка — модели объясняют ровно, какой результат хотят.",
            example = "כָּתַבְתִּי הַנְחָיָה מְדֻיֶּקֶת עִם דּוּגְמָה וְהַתּוֹצָאָה הָיְתָה שִׁימּוּשִׁית.",
            exampleNative = "Я написал הַנְחָיָה מְדֻיֶּקֶת с примером, и результат оказался полезным.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178702, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_prompts", transliteration = "reka",
            original = "רֶקַע", translation = "контекст в подсказке",
            definition = "מֵידָע מַקְדִּים שֶׁמּוֹסְרִים לַמּוֹדֵל כְּדֵי שֶׁיָּבִין בְּאֵיזֶה מַצָּב מְדֻבָּר.",
            definitionNative = "Вводные сведения — модель понимает, в какой ситуации она работает.",
            example = "בְּלִי רֶקַע עַל קֵהַל הַיַּעַד הַסִּגְנוֹן יֵצֵא רִשְׁמִי מִדַּי לְלָקוֹחוֹת צְעִירִים.",
            exampleNative = "Без רֶקַע о целевой аудитории стиль выйдет слишком формальным для молодых клиентов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178703, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_prompts", transliteration = "dugma mancha",
            original = "דֻּגְמָה מַנְחָה", translation = "пример в подсказке (few-shot)",
            definition = "מַעֲשֶׂה אֶחָד אוֹ שְׁנַיִם שֶׁמַּרְאִים לַמּוֹדֵל אֵיךְ הַתּוֹצָאָה הַטּוֹבָה צְרִיכָה לְהֵרָאוֹת.",
            definitionNative = "Один-два готовых случая — показывают модели, как должен выглядеть удачный результат.",
            example = "הוֹסַפְתִּי דֻּגְמָה מַנְחָה אַחַת וְהַסִּגְנוֹן שֶׁל כָּל הַתְּשׁוּבוֹת הִשְׁתַּפֵּר.",
            exampleNative = "Я добавил одну דֻּגְמָה מַנְחָה — и стиль всех ответов улучшился.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178704, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_prompts", transliteration = "ton hatshuva",
            original = "טוֹן הַתְּשׁוּבָה", translation = "тон ответа",
            definition = "הַסִּגְנוֹן הָרָגְשִׁי שֶׁל הַטֶּקְסְט — רְצִינִי, חֲבֵרִי, מַצְחִיק אוֹ מַקְצוֹעִי.",
            definitionNative = "Эмоциональная окраска текста — серьёзная, дружеская, шутливая или деловая.",
            example = "בִּקַּשְׁתִּי טוֹן הַתְּשׁוּבָה חַם וְלֹא רִשְׁמִי בְּמִכְתָּב לִקְלִיֶּנְט וָתִיק.",
            exampleNative = "Я попросил тёплый, неофициальный טוֹן הַתְּשׁוּבָה для письма давнему клиенту.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178705, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_prompts", transliteration = "orekh hatshuva",
            original = "אֹרֶךְ הַתְּשׁוּבָה", translation = "длина ответа",
            definition = "כַּמָּה מִילִּים אוֹ פִּסְקָאוֹת רוֹצִים בַּתּוֹצָאָה — שׁוּרָה אַחַת, פִּסְקָה אוֹ מַסָּה אֲרֻוכָּה.",
            definitionNative = "Сколько слов или абзацев хотят в результате — строка, абзац или длинный текст.",
            example = "כָּתַבְתִּי שֶׁאֹרֶךְ הַתְּשׁוּבָה לֹא יַעֲבוֹר חָמֵשׁ שׁוּרוֹת לִקְבָלוֹת מְהִירוֹת.",
            exampleNative = "Я указал, что אֹרֶךְ הַתְּשׁוּבָה не превысит пяти строк — для быстрых сводок.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_user_workflows (5) — типовые задачи пользователя ──
        WordEntity(
            id = 178706, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_workflows", transliteration = "tyuta shel mikhtav",
            original = "טְיוּטָה שֶׁל מִכְתָּב", translation = "черновик письма",
            definition = "גִּרְסָה רִאשׁוֹנָה שֶׁל הוֹדָעָה אוֹ אִי-מֵייל שֶׁאַחֲרֶיהָ עוֹרְכִים וּמַתְאִימִים אִישִׁית.",
            definitionNative = "Первая версия сообщения или письма — потом её правят и подгоняют под себя.",
            example = "בִּיקַּשְׁתִּי מֵהַצַּ'אט טְיוּטָה שֶׁל מִכְתָּב לַמְּנַהֵל וְעָרַכְתִּי אוֹתָהּ בְּעַצְמִי.",
            exampleNative = "Я попросил у чата טְיוּטָה שֶׁל מִכְתָּב для начальника, потом отредактировал сам.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178707, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_workflows", transliteration = "haflakat raayonot",
            original = "הַפְלָקַת רַעְיוֹנוֹת", translation = "идея проекта (брейншторм)",
            definition = "סֶשֵׁן יְצִירָתִי שֶׁל הַעֲלָאַת אֶפְשָׁרֻיּוֹת לִפְנֵי בְּחִירַת כִּוּוּן אֶחָד מַתְאִים.",
            definitionNative = "Творческая сессия — вбрасывают варианты, потом выбирают одно подходящее направление.",
            example = "עָשִׂינוּ הַפְלָקַת רַעְיוֹנוֹת לִשְׁמוֹת שֶׁל הַסְּטָארְטָאפ עִם עֶזְרַת הָעוֹזֵר.",
            exampleNative = "Мы провели הַפְלָקַת רַעְיוֹנוֹת для названий стартапа с помощью ассистента.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178708, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_workflows", transliteration = "siykum pgisha",
            original = "סִיכּוּם פְּגִישָׁה", translation = "конспект встречи",
            definition = "תַּקְצִיר כָּתוּב שֶׁל הַנְּקֻדּוֹת הַחֲשׁוּבוֹת וְהַהַחְלָטוֹת שֶׁעָלוּ בְּמַהֲלַךְ הַשִּׂיחָה.",
            definitionNative = "Письменная сводка — главные пункты и решения, прозвучавшие в ходе разговора.",
            example = "הֶעֱלֵיתִי הַקְלָטָה וְקִבַּלְתִּי סִיכּוּם פְּגִישָׁה מְסֻדָּר תּוֹךְ דַּקָּה.",
            exampleNative = "Я загрузил запись и за минуту получил аккуратный סִיכּוּם פְּגִישָׁה.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178709, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_workflows", transliteration = "tirgum tekst",
            original = "תִּרְגוּם טֶקְסְט", translation = "перевод текста",
            definition = "הַעֲבָרַת מִילִּים מִשָּׂפָה אַחַת לְאַחֶרֶת תּוֹךְ שְׁמִירָה עַל הַמַּשְׁמָעוּת וְהַסִּגְנוֹן.",
            definitionNative = "Передача слов с одного языка на другой — со смыслом и стилем оригинала.",
            example = "בִּיקַּשְׁתִּי תִּרְגוּם טֶקְסְט מֵרוּסִית לְאַנְגְּלִית לְמִצְגָּת שֶׁל הַלָּקוֹחַ.",
            exampleNative = "Я заказал תִּרְגוּם טֶקְסְט с русского на английский для презентации клиенту.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178710, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_workflows", transliteration = "ktzat kod",
            original = "קְטַע קוֹד", translation = "программный код (фрагмент)",
            definition = "חֲתִיכָה קְצָרָה שֶׁל פְּקֻדּוֹת מַחְשֵׁב שֶׁמְּבַצַּעַת מְשִׂימָה אַחַת מֻגְדֶּרֶת.",
            definitionNative = "Короткий блок машинных команд — выполняет одну заранее очерченную задачу.",
            example = "הַצַּ'אט סִפֵּק קְטַע קוֹד בְּפַייתוֹן שֶׁפָּתַר אֶת הַתַּקָּלָה תּוֹךְ דַּקּוֹת.",
            exampleNative = "Чат выдал קְטַע קוֹד на Python, который решил сбой за несколько минут.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_user_verification (5) — проверка ответа модели ──
        WordEntity(
            id = 178711, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_verification", transliteration = "bdikat tshuva",
            original = "בְּדִיקַת תְּשׁוּבָה", translation = "проверка ответа",
            definition = "מַעֲבָר עַל מָה שֶׁכָּתַב הָעוֹזֵר וְוִידּוּא שֶׁהַמֵּידָע אֲמִתִּי וּמַתְאִים לַשְּׁאֵלָה.",
            definitionNative = "Просмотр того, что написал ассистент — убеждаются, что данные верны и по теме.",
            example = "תָּמִיד עוֹרֵךְ בְּדִיקַת תְּשׁוּבָה לִפְנֵי שֶׁמַּעֲבִיר חוֹמֶר לַמְּנַהֵל הַיָּשִׁיר.",
            exampleNative = "Я всегда делаю בְּדִיקַת תְּשׁוּבָה, прежде чем отправить материал прямому начальнику.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178712, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_verification", transliteration = "fakt-cheking",
            original = "פַקְט-צֶ'קִינְג", translation = "факт-чекинг",
            definition = "תַּהֲלִיךְ שֶׁל אִישּׁוּר עֻבְדּוֹת מוּל מְקוֹרוֹת אֲמִינִים לִפְנֵי שֶׁמְּפַרְסְמִים אוֹתָן.",
            definitionNative = "Сверка фактов с надёжными источниками — до того, как их публикуют.",
            example = "בְּלִי פַקְט-צֶ'קִינְג קַל לְהָפִיץ נְתוּנִים שְׁגוּיִים שֶׁפְּגוּ בְּמוֹנִיטִין.",
            exampleNative = "Без פַקְט-צֶ'קִינְג легко разнести ошибочные данные, бьющие по репутации.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178713, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_verification", transliteration = "mekor neetman",
            original = "מָקוֹר נֶאֱמָן", translation = "источник данных (надёжный)",
            definition = "אֲתָר אוֹ מַסְמָךְ שֶׁאֶפְשָׁר לִסְמוֹךְ עַל הַמֵּידָע שֶׁבּוֹ — אוּנִיבֶרְסִיטָה, סוֹכְנוּת אוֹ עִתּוֹן רְצִינִי.",
            definitionNative = "Сайт или документ, чьим данным можно доверять — университет, агентство или серьёзная газета.",
            example = "אִמַּתְתִּי אֶת הַסְּטָטִיסְטִיקָה דֶּרֶךְ מָקוֹר נֶאֱמָן שֶׁל הַלִּשְׁכָּה הַמֶּרְכָּזִית.",
            exampleNative = "Я сверил статистику через מָקוֹר נֶאֱמָן центрального бюро.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178714, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_verification", transliteration = "tzitut",
            original = "צִיטוּט", translation = "цитирование (с указанием источника)",
            definition = "הַעְתָּקָה מְדֻיֶּקֶת שֶׁל מִשְׁפָּט מִכָּתוּב אַחֵר עִם צִיוּן הַמְּחַבֵּר וְהַמָּקוֹם.",
            definitionNative = "Точное приведение фразы из чужого текста — с указанием автора и источника.",
            example = "הוֹסַפְתִּי צִיטוּט מְדֻיָּק לַמַּאֲמָר כְּדֵי לְהָגֵן עַל הַטֵּיעוּן הַמֶּרְכָּזִי.",
            exampleNative = "Я добавил аккуратный צִיטוּט в статью — чтобы подкрепить главный довод.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178715, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_verification", transliteration = "haryatza chozeret",
            original = "הָרָצָה חוֹזֶרֶת", translation = "повтор запроса",
            definition = "שְׁלִיחָה שֶׁל אוֹתָהּ הַנְחָיָה שׁוּב כְּדֵי לִרְאוֹת אִם הָעוֹזֵר נוֹתֵן תְּשׁוּבָה דּוֹמָה.",
            definitionNative = "Повторная отправка той же подсказки — чтобы увидеть, выдаст ли ассистент похожий результат.",
            example = "אַחֲרֵי הָרָצָה חוֹזֶרֶת קִבַּלְתִּי שָׁלוֹשׁ נֻסָּחוֹת שׁוֹנוֹת לְאוֹתָהּ הַשְּׁאֵלָה.",
            exampleNative = "После הָרָצָה חוֹזֶרֶת я получил три разные формулировки на один и тот же запрос.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_user_risks (5) — типовые риски использования ──
        WordEntity(
            id = 178716, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_risks", transliteration = "yeda meyushan",
            original = "יֶדַע מְיֻשָּׁן", translation = "устаревшие знания модели",
            definition = "מֵידָע יָשָׁן שֶׁהָעוֹזֵר לָמַד מִזְּמַן וְלֹא מַכִּיר אֶת הָאַקְטוּאַלְיוֹת הַחֲדָשׁוֹת.",
            definitionNative = "Старые сведения, которыми обучен ассистент — он не в курсе свежих новостей.",
            example = "יֶדַע מְיֻשָּׁן שֶׁל הַמּוֹדֵל הוֹבִיל לִתְשׁוּבָה לֹא נְכוֹנָה עַל מַחִיר הַדּוֹלָר.",
            exampleNative = "יֶדַע מְיֻשָּׁן модели привёл к неверному ответу о курсе доллара.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178717, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_risks", transliteration = "tshuva mumtzeet",
            original = "תְּשׁוּבָה מֻמְצֵאת", translation = "выдуманный ответ",
            definition = "פְּרָטִים שֶׁהָעוֹזֵר הִמְצִיא בְּעַצְמוֹ — נִשְׁמָעִים אֲמִינִים אֲבָל לֹא קַיָּמִים בַּמְּצִיאוּת.",
            definitionNative = "Подробности, которые ассистент сам сочинил — звучат правдоподобно, но в реальности их нет.",
            example = "הוּא צִיטֵּט מַחְקָר שֶׁלֹא קַיָּם — תְּשׁוּבָה מֻמְצֵאת קְלָסִית שֶׁל מוֹדֵל.",
            exampleNative = "Он сослался на несуществующее исследование — классическая תְּשׁוּבָה מֻמְצֵאת модели.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178718, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_risks", transliteration = "plagyat",
            original = "פְּלָגְיָאט", translation = "плагиат",
            definition = "שִׁימּוּשׁ בְּטֶקְסְט שֶׁל מִישֶׁהוּ אַחֵר וְהַצָּגָתוֹ כְּאִילּוּ הוּא יְצִירָה מְקוֹרִית שֶׁלָּכֶם.",
            definitionNative = "Использование чужого текста, выданного за собственное оригинальное произведение.",
            example = "הָרְצָאָה שֶׁל הַסְּטוּדֶנְט נִפְסְלָה בִּגְלַל פְּלָגְיָאט מֵאַתְרֵי אִינְטֶרְנֶט.",
            exampleNative = "Лекция студента не зачтена из-за פְּלָגְיָאט с интернет-ресурсов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178719, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_risks", transliteration = "hafarat zkhuyot yotzrim",
            original = "הֲפָרַת זְכוּיוֹת יוֹצְרִים", translation = "нарушение авторских прав",
            definition = "שִׁימּוּשׁ בְּתוֹכֶן מוּגָן בְּלִי רְשׁוּת מֵהַבַּעַל הַחֻקִּי שֶׁל הַיְּצִירָה.",
            definitionNative = "Использование защищённого материала без разрешения законного владельца произведения.",
            example = "הַתְּמוּנָה שֶׁהוֹרַד הָעוֹזֵר גָּרְמָה לַהֲפָרַת זְכוּיוֹת יוֹצְרִים שֶׁל צַלָּם מַקְצוֹעִי.",
            exampleNative = "Картинка, скачанная ассистентом, повлекла הֲפָרַת זְכוּיוֹת יוֹצְרִים профессионального фотографа.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178720, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_risks", transliteration = "dlifat data",
            original = "דְּלִיפַת דָּאטָה", translation = "утечка данных в чат",
            definition = "מָצָב שֶׁבּוֹ מֵידָע סוֹדִי עוֹלֶה לְשֵׁרוּת חִיצוֹנִי וְעָלוּל לְהֵחָשֵׂף לַאֲחֵרִים.",
            definitionNative = "Когда секретные сведения уходят на сторонний сервис — могут стать видны посторонним.",
            example = "הַחֶבְרָה אָסְרָה לְהַדְבִּיק קוֹד פְּנִימִי כְּדֵי לִמְנֹעַ דְּלִיפַת דָּאטָה.",
            exampleNative = "Компания запретила вставлять внутренний код, чтобы предотвратить דְּלִיפַת דָּאטָה.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_user_responsibility (5) — ответственное использование ──
        WordEntity(
            id = 178721, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_responsibility", transliteration = "shimush eti",
            original = "שִׁימּוּשׁ אֶתִי", translation = "этичное использование",
            definition = "הַפְעָלָה שֶׁל הַכְּלִי בְּדֶרֶךְ שֶׁלֹּא פּוֹגַעַת בַּאֲנָשִׁים אַחֵרִים וּמַתְאִימָה לְעֶרְכֵי הַחֶבְרָה.",
            definitionNative = "Применение инструмента так, чтобы не вредить людям и не противоречить ценностям общества.",
            example = "הַחֶבְרָה הִקְפִּידָה עַל שִׁימּוּשׁ אֶתִי שֶׁל בִּינָה מְלָאכוּתִית בִּמְכִירוֹת.",
            exampleNative = "Компания соблюдала שִׁימּוּשׁ אֶתִי искусственного интеллекта в продажах.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178722, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_responsibility", transliteration = "akhrayut ishit",
            original = "אַחְרָיוּת אִישִׁית", translation = "личная подпись текста (ответственность)",
            definition = "הַהִתְחַיְּבוּת שֶׁל הַכּוֹתֵב לְאַשֵּׁר שֶׁהַתֹּכֶן נְכוֹן וְלִקַּח אַחְרָיוּת עַל מָה שֶׁפֻּרְסַם.",
            definitionNative = "Обязательство автора подтвердить — содержание верно, и он отвечает за публикуемое.",
            example = "אַחְרָיוּת אִישִׁית עַל הַטֶּקְסְט נִשְׁאֶרֶת אֵצֶל הַכּוֹתֵב גַּם בְּשִׁימּוּשׁ בְּעוֹזֵר חָכָם.",
            exampleNative = "אַחְרָיוּת אִישִׁית за текст остаётся на авторе — даже если он пользовался умным ассистентом.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178723, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_user_responsibility", transliteration = "haskamat amit",
            original = "הַסְכָּמַת עָמִית", translation = "согласие коллеги",
            definition = "אִישּׁוּר מֵאָדָם אַחֵר שֶׁמַּסְכִּים שֶׁיִּשְׁתַּמְּשׁוּ בַּמֵּידָע שֶׁלּוֹ אוֹ בִּתְמוּנָתוֹ.",
            definitionNative = "Подтверждение от другого человека — он согласен, что используют его данные или фото.",
            example = "בְּלִי הַסְכָּמַת עָמִית אָסוּר לְהַדְבִּיק אֶת קוֹרוֹת הַחַיִּים שֶׁלּוֹ לַצַּ'אט.",
            exampleNative = "Без הַסְכָּמַת עָמִית нельзя вставлять его резюме в чат.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178724, setId = 1787, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "aiml_user_responsibility", transliteration = "klalim etiyim",
            original = "כְּלָלִים אֶתִיִּים", translation = "этические правила (для AI)",
            definition = "כְּלָלִים פְּנִימִיִּים שֶׁמַּגְדִּירִים מָה מֻתָּר וּמָה אָסוּר בְּשִׁימּוּשׁ בְּכַלִּים חֲכָמִים.",
            definitionNative = "Внутренние правила — что можно и что нельзя при использовании умных инструментов.",
            example = "כְּלָלִים אֶתִיִּים אוֹסְרִים לְהַעֲלוֹת קְבָצִים שֶׁל לָקוֹחוֹת לַמּוֹדֵל הַחִיצוֹנִי.",
            exampleNative = "כְּלָלִים אֶתִיִּים запрещают загружать файлы клиентов во внешнюю модель.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178725, setId = 1787, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_user_responsibility", transliteration = "klalim ptukhim",
            original = "כְּלָלִים פְּתוּחִים", translation = "открытые правила (transparency)",
            definition = "הַצָּגָה גְּלוּיָה לַמִּשְׁתַּמְּשִׁים מָתַי וְאֵיךְ נֶעֱזָרִים בְּעוֹזֵר חָכָם בִּתְהָלִיךְ הַשֵּׁרוּת.",
            definitionNative = "Открытое объяснение пользователям — когда и как в процесс обслуживания включают умного ассистента.",
            example = "הַבַּנְק פִּרְסֵם כְּלָלִים פְּתוּחִים עַל שִׁימּוּשׁ בִּינָה מְלָאכוּתִית.",
            exampleNative = "Банк опубликовал כְּלָלִים פְּתוּחִים об использовании искусственного интеллекта.",
            isFillInBlankSafe = false,
        ),
    )
}
