package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "AI и ML", L1 «Основы» (COMMON+UNCOMMON).
 *
 * Set 1786: «AI и ML» — основы L1: то, с чем сталкивается обычный пользователь
 *           ChatGPT/Siri/Алексы — без технических ML-терминов. Базовые понятия,
 *           популярные инструменты, простые действия с ассистентом, взгляд
 *           пользователя на качество ответа и базовые опасения по безопасности.
 *
 * Аудитория — русскоязычные репатрианты в Израиле, которые впервые сталкиваются
 * с AI-инструментами в быту: пишут промпт в ChatGPT, просят Сири позвонить,
 * читают рекомендации в YouTube, обсуждают приватность данных. Лексика — реальная
 * смесь иврита и английских заимствований, как реально говорят в обычной речи.
 *
 * Распределение редкостей: 13 COMMON + 12 UNCOMMON.
 *
 * SemanticGroups (5 × 5):
 *   aiml_basic_concepts    — базовые понятия: ИИ, умная система, алгоритм,
 *                            обучение, мозг компьютера
 *   aiml_basic_tools       — популярные инструменты: ChatGPT, голосовой
 *                            помощник, переводчик, рекомендации, поиск
 *   aiml_basic_actions     — простые действия с ИИ: задать вопрос, получить
 *                            ответ, проверить факт, создать картинку,
 *                            продолжить разговор
 *   aiml_basic_user_view   — взгляд пользователя: подсказка, ошибка, точность,
 *                            креативность, ограничение
 *   aiml_basic_safety      — безопасность: данные, доверие, контроль,
 *                            ответственность, приватность
 *
 * Word IDs: setId × 100 + position (178601..178625).
 *
 * Пересечения с AiMlL3-L5 (1755-1757) сознательно избегаем: те сеты дают узкую
 * технику ML (модель, датасет, эпоха, RAG, ML-исследователь), а L1 — речь
 * рядового юзера AI-инструмента.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewAiMlL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1786, languagePair = "he-ru", orderIndex = 1786,
            name = "AI и ML",
            description = "Базовая лексика AI: умные системы, ChatGPT, ассистенты, безопасность ИИ",
            topic = "AI и ML", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1786 — AI и ML: основы (L1, COMMON+UNCOMMON, A1-B1)
        // 5 групп × 5 слов: concepts, tools, actions, user_view, safety
        // ══════════════════════════════════════════════════════════════════════

        // ── aiml_basic_concepts (5) — базовые понятия ──
        WordEntity(
            id = 178601, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "aiml_basic_concepts", transliteration = "makhshev khakham",
            original = "מַחְשֵׁב חָכָם", translation = "умный компьютер (общий термин для AI)",
            definition = "תּוֹכְנָה שֶׁעוֹנָה לְשָׂפָה רְגִילָה וְעוֹזֶרֶת בִּמְשִׂימוֹת יוֹם-יוֹם.",
            definitionNative = "Программа, понимающая обычный язык и помогающая в повседневных задачах.",
            example = "מַחְשֵׁב חָכָם עוֹזֵר לִי לִכְתֹּב מַכְתָּבִים בָּעֲבוֹדָה.",
            exampleNative = "מַחְשֵׁב חָכָם помогает мне писать письма на работе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178602, setId = 1786, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_basic_concepts", transliteration = "ma'arekhet khakhama",
            original = "מַעֲרֶכֶת חֲכָמָה", translation = "умная система",
            definition = "תּוֹכְנָה שֶׁמַּחְלִיטָה לְבַד אֵיךְ לַעֲזֹר לָאָדָם בְּכָל מַצָּב.",
            definitionNative = "Программа, что сама решает, как помочь человеку в любой ситуации.",
            example = "מַעֲרֶכֶת חֲכָמָה בַּמְּכוֹנִית מַזְהִירָה אוֹתִי מִפְּנֵי הוֹלְכֵי רֶגֶל.",
            exampleNative = "מַעֲרֶכֶת חֲכָמָה в машине предупреждает меня о пешеходах.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178603, setId = 1786, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_basic_concepts", transliteration = "algoritm",
            original = "אַלְגוֹרִיתְם", translation = "алгоритм",
            definition = "סִדְרָה שֶׁל צְעָדִים שֶׁעַל פִּיהֶם הַתּוֹכְנָה מְקַבֶּלֶת הַחְלָטָה.",
            definitionNative = "Последовательность шагов, по которой программа принимает решение.",
            example = "הָאַלְגוֹרִיתְם שֶׁל יוּטְיוּב יוֹדֵעַ אֵיזֶה סִרְטוֹן אוֹהַב.",
            exampleNative = "אַלְגוֹרִיתְם YouTube знает, какое видео мне нравится.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178604, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "aiml_basic_concepts", transliteration = "lemida",
            original = "לְמִידָה", translation = "обучение",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ הַתּוֹכְנָה מַכִּירָה דְּפוּסִים מִתּוֹךְ הַרְבֵּה דֻּגְמָאוֹת.",
            definitionNative = "Процесс, в котором программа узнаёт закономерности из множества примеров.",
            example = "לְמִידָה שֶׁל הָעוֹזֵר נִמְשֶׁכֶת חֳדָשִׁים אֲרֻכִּים.",
            exampleNative = "לְמִידָה ассистента занимает долгие месяцы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178605, setId = 1786, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "aiml_basic_concepts", transliteration = "moakh ha-makhshev",
            original = "מֹחַ הַמַּחְשֵׁב", translation = "мозг компьютера",
            definition = "הַחֵלֶק שֶׁמְּעַבֵּד מֵידָע וְקוֹבֵעַ אֵיךְ יַעֲנֶה הַמַּכְשִׁיר.",
            definitionNative = "Часть, что обрабатывает информацию и определяет ответ устройства.",
            example = "מֹחַ הַמַּחְשֵׁב עוֹבֵד מַהֵר יוֹתֵר מֵאָדָם בְּחִישּׁוּבִים.",
            exampleNative = "מֹחַ הַמַּחְשֵׁב считает быстрее человека.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_basic_tools (5) — популярные инструменты ──
        WordEntity(
            id = 178606, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "aiml_basic_tools", transliteration = "chat-ji-pi-ti",
            original = "צָ'אט-גִ'י-פִּי-טִי", translation = "ChatGPT",
            definition = "צַ'אט פּוֹפּוּלָרִי שֶׁל אוֹפֶּן-אֵיי-אַי שֶׁעוֹנֶה עַל כָּל שְׁאֵלָה בִּכְתָב.",
            definitionNative = "Популярный чат от OpenAI — отвечает в письменной форме на любой вопрос.",
            example = "בִּקַּשְׁתִּי מִ-צָ'אט-גִ'י-פִּי-טִי לְסַכֵּם לִי אֶת הַסֶּרֶט.",
            exampleNative = "Я попросил צָ'אט-גִ'י-פִּי-טִי сделать саммари фильма.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178607, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "aiml_basic_tools", transliteration = "ozer koli",
            original = "עוֹזֵר קוֹלִי", translation = "голосовой помощник",
            definition = "תּוֹכְנָה בַּטֶּלֶפוֹן שֶׁשּׁוֹמַעַת בַּקָּשָׁה בְּפֶה וְעוֹנָה בְּקוֹל.",
            definitionNative = "Программа в телефоне — слышит просьбу голосом и отвечает голосом.",
            example = "אֲנִי מְבַקֵּשׁ מֵהָעוֹזֵר קוֹלִי לְהִתְקַשֵּׁר לְאַבָּא.",
            exampleNative = "Я прошу עוֹזֵר קוֹלִי позвонить отцу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178608, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "aiml_basic_tools", transliteration = "metargem",
            original = "מְתַרְגֵּם", translation = "переводчик",
            definition = "כְּלִי בָּרֶשֶׁת שֶׁמַּעֲבִיר טֶקְסְט מִשָּׂפָה אַחַת לְשָׂפָה אַחֶרֶת.",
            definitionNative = "Сетевой инструмент — переносит текст с одного языка на другой.",
            example = "הַמְּתַרְגֵּם תִּרְגֵּם לִי תַּפְרִיט שָׁלֵם בָּמִּסְעָדָה הָאִיטַלְקִית.",
            exampleNative = "מְתַרְגֵּם перевёл мне меню в итальянском ресторане.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178609, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "aiml_basic_tools", transliteration = "hamlatsot",
            original = "הַמְלָצוֹת", translation = "рекомендации",
            definition = "הַצָּעוֹת שֶׁל סִרְטוֹנִים אוֹ מוּצָרִים שֶׁמֻּתְאָמוֹת לְמָה שֶׁאַתָּה אוֹהֵב.",
            definitionNative = "Подборки видео или товаров — подобраны под то, что тебе нравится.",
            example = "הַהַמְלָצוֹת בְּנֶטְפְלִיקְס תָּמִיד מַתְאִימוֹת לִי יוֹתֵר מִדַּי.",
            exampleNative = "הַמְלָצוֹת в Netflix всегда подходят мне даже слишком.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178610, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "aiml_basic_tools", transliteration = "khipush",
            original = "חִיפּוּשׂ", translation = "поиск",
            definition = "מְצִיאַת תְּשׁוּבָה בָּרֶשֶׁת לְפִי מִלִּים שֶׁאַתָּה מַקְלִיד בָּמִּסְגֶּרֶת.",
            definitionNative = "Нахождение ответа в сети по словам, которые ты набираешь в окошке.",
            example = "חִיפּוּשׂ קָצָר בְּגוּגְל פָּתַר לִי אֶת הַשְּׁאֵלָה תּוֹךְ דַּקָּה.",
            exampleNative = "Короткий חִיפּוּשׂ в Google решил мой вопрос за минуту.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_basic_actions (5) — простые действия с ИИ ──
        WordEntity(
            id = 178611, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "aiml_basic_actions", transliteration = "lish'ol she'ela",
            original = "לִשְׁאֹל שְׁאֵלָה", translation = "задать вопрос",
            definition = "לְהַקְלִיד אוֹ לוֹמַר מַשֶּׁהוּ שֶׁאַתָּה רוֹצֶה לָדַעַת מִן הַתּוֹכְנָה.",
            definitionNative = "Набрать или произнести то, что ты хочешь узнать у программы.",
            example = "אַתָּה יָכוֹל לִשְׁאֹל שְׁאֵלָה בְּכָל שָׂפָה כִּמְעַט.",
            exampleNative = "Ты можешь לִשְׁאֹל שְׁאֵלָה почти на любом языке.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178612, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "aiml_basic_actions", transliteration = "lekabel tshuva",
            original = "לְקַבֵּל תְּשׁוּבָה", translation = "получить ответ",
            definition = "לִרְאוֹת עַל הַמָּסָךְ אוֹ לִשְׁמֹעַ מָה שֶׁהַתּוֹכְנָה הֵבִינָה וְעָנְתָה.",
            definitionNative = "Увидеть на экране или услышать то, что программа поняла и сказала.",
            example = "לְקַבֵּל תְּשׁוּבָה מָהִירָה הוּא הַיִּתְרוֹן הַגָּדוֹל בִּצְ'אטים אֵלֶּה.",
            exampleNative = "לְקַבֵּל תְּשׁוּבָה быстро — большое преимущество таких чатов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178613, setId = 1786, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "aiml_basic_actions", transliteration = "livdok uvda",
            original = "לִבְדֹּק עוּבְדָה", translation = "проверить факт",
            definition = "לִרְאוֹת בְּמָקוֹר רְצִינִי אִם מָה שֶׁהַתּוֹכְנָה אָמְרָה אֲמִתִּי.",
            definitionNative = "Заглянуть в серьёзный источник — правда ли то, что сказала программа.",
            example = "כְּדַאי לִבְדֹּק עוּבְדָה לִפְנֵי שֶׁמְּצַטְּטִים אֶת הַצַּ'אט.",
            exampleNative = "Стоит לִבְדֹּק עוּבְדָה прежде чем цитировать чат.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178614, setId = 1786, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "aiml_basic_actions", transliteration = "lehafik tmuna",
            original = "לְהַפִיק תְּמוּנָה", translation = "создать картинку",
            definition = "לְבַקֵּשׁ מֵהַתּוֹכְנָה לְצַיֵּר צִיּוּר חָדָשׁ לְפִי הַתֵּאוּר שֶׁלְּךָ.",
            definitionNative = "Попросить программу нарисовать новый рисунок по твоему описанию.",
            example = "נִסִּיתִי לְהַפִיק תְּמוּנָה שֶׁל חָתוּל אַסְטְרוֹנָאוּט עַל הַיָּרֵחַ.",
            exampleNative = "Я пробовал לְהַפִיק תְּמוּנָה кота-астронавта на Луне.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178615, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "aiml_basic_actions", transliteration = "lehamshikh sikha",
            original = "לְהַמְשִׁיךְ שִׂיחָה", translation = "продолжить разговор",
            definition = "לִכְתֹּב הוֹדָעָה נוֹסֶפֶת בְּאוֹתוֹ הַחַלּוֹן בְּלִי לִפְתֹּחַ צַ'אט חָדָשׁ.",
            definitionNative = "Написать ещё одно сообщение в том же окне — без открытия нового чата.",
            example = "אֶפְשָׁר לְהַמְשִׁיךְ שִׂיחָה גַּם אַחֲרֵי שָׁבוּעַ אוֹ חֳדָשַׁיִם.",
            exampleNative = "Можно לְהַמְשִׁיךְ שִׂיחָה даже спустя неделю или два месяца.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_basic_user_view (5) — взгляд пользователя ──
        WordEntity(
            id = 178616, setId = 1786, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_basic_user_view", transliteration = "remez",
            original = "רֶמֶז", translation = "подсказка",
            definition = "מִשְׁפָּט קָצָר שֶׁאַתָּה נוֹתֵן כְּדֵי לְכַוֵּן אֶת הַתּוֹכְנָה לְמָה אַתָּה רוֹצֶה.",
            definitionNative = "Короткая фраза от тебя — чтобы навести программу на нужный тебе результат.",
            example = "רֶמֶז קָטָן וּמְדֻיָּק נוֹתֵן בְּדֶרֶךְ כְּלָל תּוֹצָאָה טוֹבָה יוֹתֵר.",
            exampleNative = "Короткий и точный רֶמֶז обычно даёт результат лучше.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178617, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "aiml_basic_user_view", transliteration = "shgia",
            original = "שְׁגִיאָה", translation = "ошибка",
            definition = "תְּשׁוּבָה לֹא נְכוֹנָה שֶׁהַתּוֹכְנָה נוֹתֶנֶת בְּלִי לָדַעַת שֶׁהִיא טוֹעָה.",
            definitionNative = "Неправильный ответ программы — она даже не знает, что промахнулась.",
            example = "שָׂמְתִּי לֵב לִשְׁגִיאָה גְּדוֹלָה בִּתְשׁוּבַת הַצַּ'אט הַבֹּקֶר.",
            exampleNative = "Я заметил большую שְׁגִיאָה в ответе чата сегодня утром.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178618, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "aiml_basic_user_view", transliteration = "diyuk",
            original = "דִּיּוּק", translation = "точность",
            definition = "כַּמָּה הַתְּשׁוּבָה מַתְאִימָה לָאֱמֶת וְלִשְׁאֵלָה שֶׁשָּׁאַלְתָּ.",
            definitionNative = "Насколько ответ соответствует правде и тому, что ты спросил.",
            example = "הַדִּיּוּק שֶׁל הָעוֹזֵר עָלָה הַרְבֵּה בַּגִּרְסָה הָאַחֲרוֹנָה.",
            exampleNative = "דִּיּוּק ассистента сильно вырос в свежей версии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178619, setId = 1786, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_basic_user_view", transliteration = "yetsiratiyut",
            original = "יְצִירָתִיוּת", translation = "креативность",
            definition = "יְכֹלֶת לְהַצִּיעַ רַעֲיוֹנוֹת חֲדָשִׁים וְלֹא צְפוּיִים — לְשִׁיר, לְצִיוּר אוֹ לְסִפּוּר.",
            definitionNative = "Способность выдавать новые и неожиданные идеи — для песни, рисунка или рассказа.",
            example = "יְצִירָתִיוּת שֶׁל הַצַּ'אט הִפְתִּיעָה אוֹתִי בִּכְתִיבַת שִׁיר חֲתוּנָה.",
            exampleNative = "יְצִירָתִיוּת чата удивила меня — он написал свадебную песню.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178620, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "aiml_basic_user_view", transliteration = "magbala",
            original = "מַגְבָּלָה", translation = "ограничение",
            definition = "גְּבוּל שֶׁהַתּוֹכְנָה לֹא יְכוֹלָה אוֹ לֹא מֻרְשֵׁית לַעֲבֹר אוֹתוֹ.",
            definitionNative = "Граница, которую программа не может или не вправе перешагнуть.",
            example = "יֵשׁ מַגְבָּלָה עַל אֹרֶךְ הַטֶּקְסְט שֶׁהָעוֹזֵר מְקַבֵּל בְּבַת אַחַת.",
            exampleNative = "Есть מַגְבָּלָה на длину текста, которую ассистент берёт сразу.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_basic_safety (5) — безопасность и приватность ──
        WordEntity(
            id = 178621, setId = 1786, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "aiml_basic_safety", transliteration = "avtakhat meida",
            original = "אַבְטָחַת מֵידַע", translation = "безопасность данных",
            definition = "שְׁמִירָה עַל פְּרָטִים שֶׁל מִשְׁתַּמֵּשׁ מִפְּנֵי גְּנֵבָה אוֹ דְּלִיפָה לָרֶשֶׁת.",
            definitionNative = "Защита сведений о пользователе от кражи или утечки в сеть.",
            example = "אַבְטָחַת מֵידַע חֲזָקָה חֲשׁוּבָה בְּצַ'אט שֶׁל בַּנְק אוֹ קֻפַּת חוֹלִים.",
            exampleNative = "Сильная אַבְטָחַת מֵידַע важна в чате банка или больничной кассы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178622, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "aiml_basic_safety", transliteration = "emun",
            original = "אֵמוּן", translation = "доверие",
            definition = "תְּחוּשָׁה שֶׁאֶפְשָׁר לִסְמֹךְ עַל הַתְּשׁוּבָה גַּם בְּעִנְיָנִים חֲשׁוּבִים.",
            definitionNative = "Чувство — на ответ можно положиться даже в важных делах.",
            example = "אֵין לִי עֲדַיִן אֵמוּן בָּעוֹזֵר בְּשֶׁל בְּרִיאוּת הַיְּלָדִים שֶׁלִּי.",
            exampleNative = "У меня пока нет אֵמוּן к ассистенту в делах здоровья детей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178623, setId = 1786, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "aiml_basic_safety", transliteration = "shlita enoshit",
            original = "שְׁלִיטָה אֱנוֹשִׁית", translation = "контроль человека (над AI)",
            definition = "מַצָּב שֶׁבּוֹ אָדָם תָּמִיד יָכוֹל לַעֲצוֹר אֶת הַתּוֹכְנָה אוֹ לְשַׁנּוֹת אוֹתָהּ.",
            definitionNative = "Состояние, когда человек всегда может остановить программу или поправить её.",
            example = "בְּלִי שְׁלִיטָה אֱנוֹשִׁית, מַעֲרֶכֶת חֲזָקָה יְכוֹלָה לִטְעוֹת קָשֶׁה.",
            exampleNative = "Без שְׁלִיטָה אֱנוֹשִׁית сильная система может крепко промахнуться.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178624, setId = 1786, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aiml_basic_safety", transliteration = "akhrayut",
            original = "אַחֲרָיוּת", translation = "ответственность",
            definition = "חוֹבָה לְהַסְבִּיר וּלְשַׁלֵּם אִם תְּשׁוּבָה אוֹטוֹמָטִית גָּרְמָה לְנֶזֶק.",
            definitionNative = "Обязанность объяснить и заплатить, если автоматический ответ принёс вред.",
            example = "אַחֲרָיוּת עַל פְּגִיעָה רְפוּאִית נוֹפֶלֶת עַל הָרוֹפֵא, לֹא עַל הַצַּ'אט.",
            exampleNative = "אַחֲרָיוּת за врачебный вред лежит на враче, а не на чате.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178625, setId = 1786, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "aiml_basic_safety", transliteration = "privatiyut",
            original = "פְּרָטִיוּת", translation = "приватность",
            definition = "זְכוּת לִשְׁמֹר עַל סוֹדוֹת אִישִׁיִּים מִפְּנֵי חֶבְרוֹת וּמַעֲרָכוֹת זָרוֹת.",
            definitionNative = "Право скрыть личные тайны от чужих фирм и систем.",
            example = "אֲנִי לֹא מַכְנִיס שֵׁמוֹת שֶׁל יְלָדִים לַצַּ'אט בִּגְלַל פְּרָטִיוּת.",
            exampleNative = "Я не пишу имена детей в чат — из-за פְּרָטִיוּת.",
            isFillInBlankSafe = false,
        ),
    )
}
