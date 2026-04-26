package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "AI и ML", уровень 4 (профессиональный).
 *
 * Set 1756: «AI и ML» — профессиональный L4 (EPIC + LEGENDARY).
 * Узкоспециальная лексика продакшен-ML: пайплайн моделей, мониторинг
 * качества, LLM-стек, продвинутые техники (fine-tuning, RAG, vector DB)
 * и оценка моделей.
 *
 * Целевая аудитория — русскоязычные репатрианты в Израиле, работающие
 * ML-инженерами, дата-сайентистами, MLOps-инженерами в израильских
 * стартапах. Лексика двуязычная: иврит + множество английских
 * заимствований (פַּייפְּלַיין, מוֹדֵל סֵרְוִינְג, דָּאטָה דְּרִיפְט, פְּרוֹמְפְּט,
 * פַיין-טְיוּנִינְג, וֶקְטוֹר דֵּי-בִּי) — так реально говорят на ML-митингах.
 *
 * Распределение редкостей:
 *   13 EPIC + 12 LEGENDARY (без выхода за 2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   aiml_pipeline    — feature store, model registry, model serving, batch/online inference
 *   aiml_monitoring  — data drift, model decay, ground truth lag, observability, prediction logging
 *   aiml_llm         — LLM, prompt, prompt engineering, system prompt, few-shot
 *   aiml_advanced    — fine-tuning, RAG, vector DB, embedding model, semantic search
 *   aiml_evaluation  — precision, recall, F1, AUC ROC, A/B test моделей
 *
 * Word IDs: setId × 100 + position (175601..175625).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewAiMlL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1756, languagePair = "he-ru", orderIndex = 1756,
            name = "AI и ML",
            description = "Продакшен ML: пайплайн, мониторинг, fine-tuning, RAG, vector DB",
            topic = "AI и ML", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1756 — AI и ML: профессиональный (L4, EPIC + LEGENDARY)
        // 5 групп × 5 слов: pipeline, monitoring, llm, advanced, evaluation
        // ══════════════════════════════════════════════════════════════════════

        // ── aiml_pipeline (5) — пайплайн модели от данных до инференса ──
        WordEntity(
            id = 175601, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_pipeline", transliteration = "makhsan ficherim",
            original = "מַחְסַן פִיצֶ׳רִים", translation = "feature store",
            definition = "מַאֲגָר מֶרְכָּזִי שֶׁבּוֹ שׁוֹמְרִים מַשְׁתָּנִים מוּכָנִים לְאִמּוּן וְלִשְׁלִיפָה בְּזְמַן אֱמֶת.",
            definitionNative = "Центральное хранилище — там лежат готовые признаки для обучения и быстрой выдачи онлайн.",
            example = "מַחְסַן פִיצֶ׳רִים בְּפֵיסְט הוֹרִיד אֶת זְמַן הַהֲכָנָה שֶׁל מוֹדֵלִים חֲדָשִׁים.",
            exampleNative = "מַחְסַן פִיצֶ׳רִים на Feast снизил время подготовки новых моделей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175602, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_pipeline", transliteration = "model registri",
            original = "מוֹדֵל רֵגִ'יסְטְרִי", translation = "model registry",
            definition = "סִפְרִיָּה מְסֻדֶּרֶת שֶׁל גִּרְסָאוֹת אַחֲרֵי אִמּוּן עִם מֶטָדָאטָה וּמֵידַע עַל בִּיצּוּעִים.",
            definitionNative = "Упорядоченная библиотека версий после обучения — с метаданными и сведениями о качестве.",
            example = "מוֹדֵל רֵגִ'יסְטְרִי בִּמְלוֹפְלוֹאוּ שׁוֹמֵר כָּל גִּרְסָה עִם תָּגִית.",
            exampleNative = "מוֹדֵל רֵגִ'יסְטְרִי в MLflow хранит каждую версию с тегом.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175603, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_pipeline", transliteration = "model serving",
            original = "מוֹדֵל סֵרְוִינְג", translation = "model serving",
            definition = "הַעֲמָדַת מוֹדֵל מְאֻמָּן מֵאֲחוֹרֵי אֵיי-פִּי-אַיי כְּדֵי שֶׁאַפְלִיקַצְיוֹת יוּכְלוּ לִשְׁלוֹחַ בַּקָּשׁוֹת.",
            definitionNative = "Поднятие обученной модели за API — чтобы приложения могли отправлять запросы.",
            example = "מוֹדֵל סֵרְוִינְג עַל קוּבֶּרְנֶטֶס מַחְזִיק עוֹמֶס שֶׁל אֶלֶף בַּקָּשׁוֹת בְּשְׁנִיָּה.",
            exampleNative = "מוֹדֵל סֵרְוִינְג на Kubernetes держит нагрузку в тысячу запросов в секунду.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175604, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_pipeline", transliteration = "inference batch",
            original = "אִינְפֶרֶנְס בָּאצ'", translation = "batch inference",
            definition = "הַרָצַת תַּחֲזִיּוֹת עַל קְבוּצָה גְּדוֹלָה שֶׁל רְשׁוּמוֹת בְּבַת אַחַת, בְּדֶרֶךְ כְּלָל בַּלַּיְלָה.",
            definitionNative = "Прогон предсказаний по большой пачке записей сразу — обычно ночью или вне пиков.",
            example = "אִינְפֶרֶנְס בָּאצ' עַל מִילְיוֹן לְקוֹחוֹת הִסְתַּיֵּם בְּתוֹךְ שְׁתֵּי שָׁעוֹת.",
            exampleNative = "אִינְפֶרֶנְס בָּאצ' на миллион клиентов завершился за два часа.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175605, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_pipeline", transliteration = "inference onlain",
            original = "אִינְפֶרֶנְס אוֹנְלַיין", translation = "online inference",
            definition = "תַּחֲזִית מִיָּדִית עַל בַּקָּשָׁה אַחַת, בְּדֶרֶךְ כְּלָל בְּפָחוֹת מִמֵּאָה מִילִישְׁנִיּוֹת.",
            definitionNative = "Мгновенное предсказание на один запрос — обычно меньше ста миллисекунд.",
            example = "אִינְפֶרֶנְס אוֹנְלַיין הִשְׁתַּלֵּב בְּמָסַךְ הַתַּשְׁלוּם וּמַזְהֶה הוֹנָאוֹת מִיָּד.",
            exampleNative = "אִינְפֶרֶנְס אוֹנְלַיין встроен в экран оплаты — ловит мошенничество мгновенно.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_monitoring (5) — наблюдение за моделями в продакшене ──
        WordEntity(
            id = 175606, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_monitoring", transliteration = "data drift",
            original = "דָּאטָה דְּרִיפְט", translation = "data drift",
            definition = "שִׁנּוּי הַדְרָגָתִי בְּהִתְפַּלְּגוּת הַקְּלַטִים שֶׁמַּגִּיעִים לַמּוֹדֵל לְעֻמַּת מַה שֶּׁרָאָה בְּאִמּוּן.",
            definitionNative = "Постепенный сдвиг распределения входов модели по сравнению с тем, что было на обучении.",
            example = "דָּאטָה דְּרִיפְט אַחֲרֵי הַשִּׁנּוּי הָעוֹנָתִי הוֹרִיד אֶת הַדִּיּוּק בִּשְׁנֵי אָחוּז.",
            exampleNative = "דָּאטָה דְּרִיפְט после сезонного сдвига уронил точность на два процента.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175607, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_monitoring", transliteration = "deikhat model",
            original = "דְּעִיכַת מוֹדֵל", translation = "model decay",
            definition = "יְרִידָה אִטִּית בְּאֵיכוּת תַּחֲזִיּוֹת לְאוֹרֶךְ זְמַן בִּגְלַל שִׁנּוּיִים בָּעוֹלָם הָאֲמִתִּי.",
            definitionNative = "Медленное падение качества предсказаний со временем — потому что мир снаружи меняется.",
            example = "דְּעִיכַת מוֹדֵל אִלְּצָה אוֹתָנוּ לְאַמֵּן מֵחָדָשׁ אַחַת לְחֹדֶשׁ.",
            exampleNative = "דְּעִיכַת מוֹדֵל заставила переучивать раз в месяц.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175608, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_monitoring", transliteration = "pigur tofa-a",
            original = "פִּיגוּר תּוֹצָאָה", translation = "ground truth lag",
            definition = "פֶּרֶק הַזְּמַן בֵּין רֶגַע הַתַּחֲזִית לְבֵין רֶגַע שֶׁבּוֹ יוֹדְעִים מַה בֶּאֱמֶת קָרָה.",
            definitionNative = "Промежуток между моментом предсказания и моментом, когда станет известен реальный исход.",
            example = "פִּיגוּר תּוֹצָאָה שֶׁל שְׁלוֹשִׁים יוֹם מַקְשֶׁה לְהָרִיץ הַעֲרָכָה שְׁבוּעִית.",
            exampleNative = "פִּיגוּר תּוֹצָאָה в тридцать дней мешает запускать недельную оценку.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175609, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_monitoring", transliteration = "nitsfeyut",
            original = "נִצְפֵּיּוּת", translation = "observability (наблюдаемость)",
            definition = "הַיְּכֹלֶת לַעֲקֹב אַחַר הִתְנַהֲגוּת הַמּוֹדֵל בַּשֶּׁטַח דֶּרֶךְ לוֹגִים, מַטְרִיקוֹת וּתְצוּגוֹת.",
            definitionNative = "Возможность следить за поведением модели в проде — через логи, метрики и графики.",
            example = "נִצְפֵּיּוּת חַלָּשָׁה הִקְשְׁתָה לְאַתֵּר אֶת הַסִּבָּה לִירִידָה בָּאֵיכוּת.",
            exampleNative = "Слабая נִצְפֵּיּוּת мешала найти причину падения качества.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175610, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_monitoring", transliteration = "tiud takhaziyot",
            original = "תִּעוּד תַּחֲזִיּוֹת", translation = "prediction logging",
            definition = "שְׁמִירָה שֶׁל כָּל בַּקָּשָׁה וְהַתְּשׁוּבָה שֶׁל הַמּוֹדֵל לְצֹרֶךְ נִתּוּחַ וּבְדִיקָה אַחַר כָּךְ.",
            definitionNative = "Сохранение каждого запроса и ответа модели — для последующего анализа и проверки.",
            example = "תִּעוּד תַּחֲזִיּוֹת בַּסְּנוֹפְלֵייק עָזַר לְמַצוֹא רַעַשׁ בִּקְלַט הַמּוֹדֵל.",
            exampleNative = "תִּעוּד תַּחֲזִיּוֹת в Snowflake помог найти шум во входе модели.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_llm (5) — большие языковые модели и работа с промптами ──
        WordEntity(
            id = 175611, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_llm", transliteration = "el-el-em",
            original = "אֶל-אֶל-אֶם", translation = "LLM (большая языковая модель)",
            definition = "מוֹדֵל עָנָק שֶׁאֻמַּן עַל טֶקְסְט מֵרֹב הָאִינְטֶרְנֶט וְיוֹדֵעַ לְהָבִין וְלִכְתֹּב שָׂפָה טִבְעִית.",
            definitionNative = "Огромная сеть, обученная на тексте интернета — понимает и пишет естественный язык.",
            example = "אֶל-אֶל-אֶם מַתְאִים לְמַשִּׂימוֹת סִכּוּם, סִיוּעַ בִּכְתִיבָה וְצַ׳אטְבּוֹטִים.",
            exampleNative = "אֶל-אֶל-אֶם подходит для саммаризации, помощи в письме и чат-ботов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175612, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_llm", transliteration = "prompt",
            original = "פְּרוֹמְפְּט", translation = "промпт (запрос к LLM)",
            definition = "הַטֶּקְסְט שֶׁמַּכְנִיסִים לַמּוֹדֵל כְּדֵי לְכַוֵּן אוֹתוֹ לְמַטָּלָה אוֹ לְסִגְנוֹן תְּשׁוּבָה.",
            definitionNative = "Текст, который кладут в модель — чтобы навести её на задачу или нужный стиль ответа.",
            example = "פְּרוֹמְפְּט קָצָר וּמְדֻיָּק נָתַן תּוֹצָאוֹת טוֹבוֹת יוֹתֵר מִטֶּקְסְט אָרֹךְ.",
            exampleNative = "Короткий и точный פְּרוֹמְפְּט дал лучший результат, чем длинный текст.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175613, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_llm", transliteration = "prompt injiniring",
            original = "פְּרוֹמְפְּט אִינְגִ'ינִירִינְג", translation = "prompt engineering",
            definition = "מְלָאכָה שֶׁל נִיסּוּחַ הוֹרָאוֹת לְמוֹדֵל כְּדֵי לְהוֹצִיא מִמֶּנּוּ אֶת הַתּוֹצָאָה הַטּוֹבָה בְּיוֹתֵר.",
            definitionNative = "Ремесло формулировки указаний для модели — чтобы выжать из неё лучший результат.",
            example = "פְּרוֹמְפְּט אִינְגִ'ינִירִינְג הָפַךְ לְמִקְצוֹעַ נִפְרָד בְּחֶבְרוֹת הַבִּינָה הַמְּלָאכוּתִית.",
            exampleNative = "פְּרוֹמְפְּט אִינְגִ'ינִירִינְג стал отдельной профессией в AI-компаниях.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175614, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_llm", transliteration = "sistem prompt",
            original = "סִיסְטֶם פְּרוֹמְפְּט", translation = "системный промпт",
            definition = "הוֹרָאָה קְבוּעָה שֶׁמּוֹסֶרֶת לַמּוֹדֵל אֵיךְ לְהִתְנַהֵג עוֹד לִפְנֵי שֶׁהַמִּשְׁתַּמֵּשׁ כּוֹתֵב מַשֶּׁהוּ.",
            definitionNative = "Постоянное указание модели — как себя вести, ещё до того как пользователь напишет.",
            example = "סִיסְטֶם פְּרוֹמְפְּט הִגְדִּיר אֶת הַטּוֹן הָרִשְׁמִי שֶׁל הָעוֹזֵר הַחָדָשׁ.",
            exampleNative = "סִיסְטֶם פְּרוֹמְפְּט задал формальный тон нового ассистента.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175615, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_llm", transliteration = "fyu-shot",
            original = "פְיוּ-שׁוֹט", translation = "few-shot (несколько примеров в промпте)",
            definition = "שִׁיטָה שֶׁבָּהּ נוֹתְנִים לַמּוֹדֵל שְׁנַיִם עַד חֲמִשָּׁה דֻּגְמָאוֹת מוּכָנוֹת לִפְנֵי הַשְּׁאֵלָה הָאֲמִתִּית.",
            definitionNative = "Приём: дают модели от двух до пяти готовых примеров перед настоящим вопросом.",
            example = "פְיוּ-שׁוֹט הֵבִיא קְפִיצָה גְּדוֹלָה בְּדִיּוּק שֶׁל מַשִּׂימוֹת סִוּוּג.",
            exampleNative = "פְיוּ-שׁוֹט дал большой скачок точности на задачах классификации.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_advanced (5) — продвинутые техники: fine-tuning, RAG, vectors ──
        WordEntity(
            id = 175616, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_advanced", transliteration = "fain-tyuning",
            original = "פַיין-טְיוּנִינְג", translation = "fine-tuning (тонкая донастройка)",
            definition = "אִמּוּן נוֹסָף וְקָצָר שֶׁל מוֹדֵל מוּכָן עַל דָּאטָה צְרָה כְּדֵי לְהַתְאִים אוֹתוֹ לְשִׂיחָה סְפֵצִיפִית.",
            definitionNative = "Короткая дообучение готовой модели на узких данных — чтобы заточить под конкретную задачу.",
            example = "פַיין-טְיוּנִינְג עַל מִסְמְכֵי הַחֶבְרָה הִקְפִּיץ אֶת הָאֵיכוּת בְּמַטָּלוֹת פְּנִימִיּוֹת.",
            exampleNative = "פַיין-טְיוּנִינְג на корпоративных документах поднял качество на внутренних задачах.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175617, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_advanced", transliteration = "ar-ei-ji",
            original = "אַר-אֵיי-גִ'י", translation = "RAG (retrieval-augmented generation)",
            definition = "שִׁיטָה שֶׁבָּהּ הַמּוֹדֵל מְחַפֵּשׂ קֶטַע רֶלֶוַונְטִי בְּמָאֲגָר וּמַשְׁתַּמֵּשׁ בּוֹ לִפְנֵי שֶׁעוֹנֶה.",
            definitionNative = "Подход: модель ищет нужный кусок в хранилище и опирается на него прежде чем отвечать.",
            example = "אַר-אֵיי-גִ'י עִם מִסְמְכֵי הַתְּמִיכָה הִקְטִין הֲזָיוֹת בִּשְׁמוֹנִים אָחוּז.",
            exampleNative = "אַר-אֵיי-גִ'י с документами поддержки снизил галлюцинации на восемьдесят процентов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175618, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_advanced", transliteration = "vektor di-bi",
            original = "וֶקְטוֹר דֵּי-בִּי", translation = "vector database",
            definition = "מָאֲגָר מְיֻחָד שֶׁשּׁוֹמֵר וֶקְטוֹרִים מְסֻפָּרִים וּמוֹצֵא דּוֹמִים לָהֶם בִּמְהִירוּת גְּדוֹלָה.",
            definitionNative = "Особое хранилище числовых векторов — быстро находит близкие к запросу.",
            example = "וֶקְטוֹר דֵּי-בִּי בְּפָּיינְקוֹן מַחֲזִיק מִילְיוֹנֵי קִטְעֵי טֶקְסְט עַם חִפּוּשׂ זָרִיז.",
            exampleNative = "וֶקְטוֹר דֵּי-בִּי в Pinecone держит миллионы кусков текста с быстрым поиском.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175619, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_advanced", transliteration = "model embedding",
            original = "מוֹדֵל אֶמְבֶּדִינְג", translation = "embedding model",
            definition = "רֶשֶׁת שֶׁמַּמִּירָה מִשְׁפָּט אוֹ תְּמוּנָה לְוֶקְטוֹר מְסֻפָּר שֶׁמַּעֲבִיר אֶת הַמַּשְׁמָעוּת שֶׁלּוֹ.",
            definitionNative = "Сеть, превращающая фразу или картинку в числовой вектор, отражающий её смысл.",
            example = "מוֹדֵל אֶמְבֶּדִינְג שֶׁל אוֹפֶּן-אֵיי-אַי מְשַׁמֵּשׁ אוֹתָנוּ לְחִפּוּשׂ פְּנִימִי.",
            exampleNative = "מוֹדֵל אֶמְבֶּדִינְג от OpenAI используется у нас для внутреннего поиска.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175620, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_advanced", transliteration = "khipus semanti",
            original = "חִפּוּשׂ סֵמַנְטִי", translation = "семантический поиск",
            definition = "חִפּוּשׂ לְפִי מַשְׁמָעוּת וְלֹא לְפִי מִילִּים זֵהוֹת — מוֹצֵא תְּשׁוּבָה גַּם בְּנִיסּוּחַ אַחֵר.",
            definitionNative = "Поиск по смыслу, а не по совпадению слов — найдёт ответ даже в другой формулировке.",
            example = "חִפּוּשׂ סֵמַנְטִי בְּבָסִיס יָדַע מְשִׁיב נְכוֹנָה גַּם בִּשְׁאֵלוֹת לֹא שִׁגְרָתִיּוֹת.",
            exampleNative = "חִפּוּשׂ סֵמַנְטִי по базе знаний отвечает верно даже на нестандартные вопросы.",
            isFillInBlankSafe = false,
        ),

        // ── aiml_evaluation (5) — оценка качества моделей ──
        WordEntity(
            id = 175621, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_evaluation", transliteration = "presizn",
            original = "פְּרֵסִיזְ'ן", translation = "precision (точность)",
            definition = "מַדָּד שֶׁבּוֹדֵק כַּמָּה מִתּוֹךְ הַחִיּוּבִים שֶׁהַמּוֹדֵל הוֹצִיא הָיוּ בֶּאֱמֶת נְכוֹנִים.",
            definitionNative = "Метрика — какая доля положительных ответов модели оказалась действительно верной.",
            example = "פְּרֵסִיזְ'ן גָּבוֹהַּ חָשׁוּב כְּשֶׁאַזְעָקַת שֶׁקֶר עוֹלָה הַרְבֵּה כֶּסֶף.",
            exampleNative = "Высокий פְּרֵסִיזְ'ן важен — когда ложная тревога стоит много денег.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175622, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_evaluation", transliteration = "rikol",
            original = "רִיקוֹל", translation = "recall (полнота)",
            definition = "מַדָּד שֶׁבּוֹדֵק כַּמָּה מִתּוֹךְ הַמִּקְרִים הַחִיּוּבִיִּים בָּאֱמֶת נִתְפְּסוּ עַל יְדֵי הַמּוֹדֵל.",
            definitionNative = "Метрика — какую долю реально положительных случаев модель успела поймать.",
            example = "רִיקוֹל גָּבוֹהַּ קְרִיטִי בְּמוֹדֵל גִּלּוּי גִּדּוּלִים סַרְטָנִיִּים.",
            exampleNative = "Высокий רִיקוֹל критичен в модели обнаружения опухолей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175623, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_evaluation", transliteration = "ef-van",
            original = "אֵף-וָואן", translation = "F1 (мера F1)",
            definition = "מִסְפָּר אֶחָד שֶׁמְּשַׁקְלֵל בְּיַחַד דִּיּוּק וְכִיסּוּי כְּדֵי לְהַשְׁווֹת בֵּין מוֹדֵלִים.",
            definitionNative = "Одно число — сводит вместе точность и полноту, чтобы сравнивать модели.",
            example = "אֵף-וָואן מָדַד אֵיךְ הַגִּרְסָה הַחֲדָשָׁה עוֹלָה עַל הַיְּשָׁנָה.",
            exampleNative = "אֵף-וָואן измерил, насколько новая версия лучше старой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175624, setId = 1756, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "aiml_evaluation", transliteration = "ei-yu-si rok",
            original = "אֵיי-יוּ-סִי רוֹק", translation = "AUC ROC",
            definition = "מַדָּד אֶחָד בֵּין אֶפֶס לְאֶחָד שֶׁמַּרְאֶה כַּמָּה טוֹב הַמּוֹדֵל מַפְרִיד בֵּין שְׁתֵּי קְבוּצוֹת.",
            definitionNative = "Одно число от нуля до единицы — насколько модель умеет разделять два класса.",
            example = "אֵיי-יוּ-סִי רוֹק שֶׁל תִּשְׁעִים אָחוּז נֶחְשָׁב מְצֻיָּן בְּסִוּוּג בִּינָרִי.",
            exampleNative = "אֵיי-יוּ-סִי רוֹק девяносто процентов считается отличным в бинарной классификации.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175625, setId = 1756, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_evaluation", transliteration = "ei-bi test modelim",
            original = "אֵיי-בִּי טֶסְט מוֹדֵלִים", translation = "A/B-тест моделей",
            definition = "הַשְׁוָאָה חַיָּה בֵּין שְׁתֵּי גִּרְסָאוֹת רֶשֶׁת עַל מִשְׁתַּמְּשִׁים אֲמִתִּיִּים בְּחֶלְקֵי תְּנוּעָה שָׁוִים.",
            definitionNative = "Живое сравнение двух версий сети на реальных юзерах в равных долях трафика.",
            example = "אֵיי-בִּי טֶסְט מוֹדֵלִים נִמְשַׁךְ שְׁבוּעַיִם וְהֶחְלִיט אֵיזוֹ גִּרְסָה תֵּצֵא לְכֻלָּם.",
            exampleNative = "אֵיי-בִּי טֶסְט מוֹדֵלִים шёл две недели — выбрал, какая версия пойдёт всем.",
            isFillInBlankSafe = false,
        ),
    )
}
