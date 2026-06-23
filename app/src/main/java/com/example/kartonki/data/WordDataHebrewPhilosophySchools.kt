package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1901 (he-ru).
 * Философия: школы и направления (L4 / RARE + EPIC).
 *
 * Зеркало en-ru set 469. Расширение темы «Философия».
 * Подтема — конкретные философские школы и -измы:
 *   античные школы (cynicism, platonism, neo-platonism, scholasticism, peripateticism),
 *   континентальные направления XIX-XX вв. (perspectivism, fatalism,
 *     transcendentalism, marxism, freudianism),
 *   аналитика и эпистемология (positivism, scientism, instrumentalism,
 *     conventionalism, fallibilism),
 *   метафизика (monism, panpsychism, vitalism, naturalism, teleology),
 *   этические школы (deontology, virtue ethics, asceticism,
 *     consequentialism, communitarianism).
 *
 * Исключены как дубли (по переводу) с существующих he-ru сетов «Философия»
 * (1017 L3, 1092 L2, 1228 L4, 1292 L5) и смежных тем:
 *   stoicism (1228, 1092), epicureanism (1228), skepticism (1092),
 *   nihilism, absurdism, hermeneutics (1092), existentialism, phenomenology (1017),
 *   materialism, idealism, dualism (1228, 1017), utilitarianism, hedonism (1092),
 *   pragmatism, rationalism, empiricism (1017, 1092), holism (1228),
 *   postmodernism (ArchL4, Cinema), solipsism (Cinema), structuralism (Literature),
 *   functionalism (Batch21), realism, nominalism (1228), kantianism (1228),
 *   hegelianism (1228), relativism (1228), determinism (1228), reductionism (1228).
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   RARE — 9 слов  (cynicism, platonism, fatalism, marxism, positivism,
 *                   monism, naturalism, deontology, virtue ethics).
 *   EPIC — 16 слов (neo-platonism, scholasticism, peripateticism, perspectivism,
 *                   transcendentalism, freudianism, scientism, instrumentalism,
 *                   conventionalism, fallibilism, panpsychism, vitalism,
 *                   teleology, asceticism, consequentialism, communitarianism).
 *
 * Пять семантических групп по 5 слов:
 *   philo_school_ancient          — античные школы
 *   philo_school_continental      — направления XIX-XX вв.
 *   philo_school_analytic_epistem — аналитика и эпистемология
 *   philo_school_metaphysics      — онтологические позиции
 *   philo_school_ethics           — этические доктрины
 *
 * Word IDs: 190101..190125 (setId × 100 + position).
 */
object WordDataHebrewPhilosophySchools {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1901, languagePair = "he-ru", orderIndex = 1901,
            name = "Философия",
            description = "Школы и направления: античные течения, метафизика, этика (אַפְלָטוֹנִיזְם, מוֹנִיזְם, דֵאוֹנְטוֹלוֹגְיָה, אֶתִיקַת מִידּוֹת)",
            topic = "Философия",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: philo_school_ancient (5 words) ─────────────────────────────

        WordEntity(id = 190101, setId = 1901, languagePair = "he-ru", rarity = "RARE",
            original = "צִינִיזְם",
            translation = "кинизм",
            definition = "אַסְכּוֹלָה עַתִּיקָה שֶׁל דִּיּוֹגֵנֵס שֶׁדָּחֲתָה עוֹשֶׁר וּמוֹסְכָּמוֹת לְטוֹבַת חַיִּים פְּשׁוּטִים לְפִי הַטֶּבַע.",
            definitionNative = "Античная школа Диогена, отвергавшая богатство и условности ради простой жизни по природе.",
            example = "דִּיּוֹגֵנֵס גִּלֵּם צִינִיזְם — חַי בְּחָבִית וְלַעַג לְאָלֶכְּסַנְדֶּר.",
            exampleNative = "Диоген воплощал צִינִיזְם — жил в бочке и насмехался над Александром.",
            pos = "noun", semanticGroup = "philo_school_ancient", fillInBlankExclusions = listOf(190102L, 190103L, 190104L, 190105L)),

        WordEntity(id = 190102, setId = 1901, languagePair = "he-ru", rarity = "RARE",
            original = "אַפְלָטוֹנִיזְם",
            translation = "платонизм",
            definition = "מָסֹרֶת אַפְּלָטוֹן שֶׁמַּחְזִיקָה כִּי הַצּוּרוֹת הַמֻּפְשָׁטוֹת מַמָּשִׁיּוֹת יוֹתֵר מֵהָעוֹלָם הַחָמְרִי הַמִּשְׁתַּנֶּה.",
            definitionNative = "Традиция Платона, утверждающая, что абстрактные формы реальнее изменчивого материального мира.",
            example = "מָתֵמָטִיקַאִי שֶׁאוֹמֵר שֶׁמִּסְפָּרִים קַיָּמִים בִּפְנֵי עַצְמָם נִכְנַס לְאַפְלָטוֹנִיזְם.",
            exampleNative = "Математик, говорящий, что числа существуют сами по себе, впадает в אַפְלָטוֹנִיזְם.",
            pos = "noun", semanticGroup = "philo_school_ancient", fillInBlankExclusions = listOf(190101L, 190103L, 190104L, 190105L)),

        WordEntity(id = 190103, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "נֵאוֹ־אַפְלָטוֹנִיזְם",
            translation = "неоплатонизм",
            definition = "זֶרֶם מְאֻחָר שֶׁל פְּלוֹטִינוּס שֶׁתֵּאֵר הִתְפַּשְּׁטוּת הַמְּצִיאוּת מִתּוֹךְ עִקָּר אֶחָד וְעֶלְיוֹן — הָאֶחָד.",
            definitionNative = "Позднее течение Плотина: вся реальность исходит из единого высшего начала — Единого.",
            example = "פְּלוֹטִינוּס הִשְׁפִּיעַ עַל הַתֵּאוֹלוֹגְיָה הַנּוֹצְרִית דֶּרֶךְ נֵאוֹ־אַפְלָטוֹנִיזְם.",
            exampleNative = "Плотин повлиял на христианскую теологию через נֵאוֹ־אַפְלָטוֹנִיזְם.",
            pos = "noun", semanticGroup = "philo_school_ancient", fillInBlankExclusions = listOf(190101L, 190102L, 190104L, 190105L)),

        WordEntity(id = 190104, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "סְכוֹלַסְטִיקָה",
            translation = "схоластика",
            definition = "שִׁיטָה יְמֵי־בֵּינַיְמִית שֶׁל תּוֹמָאס אַקְוִינַס: לְשַׁלֵּב אֱמוּנָה דָּתִית עִם הִגָּיוֹן אֲרִיסְטוֹטֵלִי.",
            definitionNative = "Средневековый метод Фомы Аквинского: совмещать религиозную веру с аристотелевской логикой.",
            example = "סְכוֹלַסְטִיקָה שָׁלְטָה בָּאוּנִיבֶרְסִיטָאוֹת אֵירוֹפָּה עַד הַתְּקוּפָה הַחֲדָשָׁה.",
            exampleNative = "סְכוֹלַסְטִיקָה господствовала в европейских университетах до Нового времени.",
            pos = "noun", semanticGroup = "philo_school_ancient", fillInBlankExclusions = listOf(190101L, 190102L, 190103L, 190105L)),

        WordEntity(id = 190105, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "פֵּרִיפַּטֶטִיזְם",
            translation = "перипатетизм",
            definition = "אַסְכּוֹלָה שֶׁל אָרִיסְטוֹ שֶׁלִּמְּדָה תַּצְפִּית עַל הַטֶּבַע, לוֹגִיקָה וּמִיוּן הַמַּדָּעִים.",
            definitionNative = "Школа Аристотеля: наблюдение природы, логика и классификация наук.",
            example = "אָרִיסְטוֹ הִקִּים אֶת פֵּרִיפַּטֶטִיזְם בַּלִּיקֵיוֹן וְלִמֵּד תּוֹךְ הִלּוּךְ עִם תַּלְמִידָיו.",
            exampleNative = "Аристотель основал פֵּרִיפַּטֶטִיזְם в Ликее и учил, прогуливаясь с учениками.",
            pos = "noun", semanticGroup = "philo_school_ancient", fillInBlankExclusions = listOf(190101L, 190102L, 190103L, 190104L)),

        // ── Group: philo_school_continental (5 words) ─────────────────────────

        WordEntity(id = 190106, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "פֶּרְסְפֶּקְטִיבִיזְם",
            translation = "перспективизм",
            definition = "תְּפִיסַת נִיטְשֶׁה: כָּל אֱמֶת מְעֻצֶּבֶת לְפִי הַזָּוִית וְהָאִינְטֶרֶסִים שֶׁל הַצּוֹפֶה בָּהּ.",
            definitionNative = "Идея Ницше: всякая истина определена углом зрения и интересами того, кто на неё смотрит.",
            example = "דֶּרֶךְ פֶּרְסְפֶּקְטִיבִיזְם טָעַן נִיטְשֶׁה שֶׁאֵין עֻבְדּוֹת טְהוֹרוֹת, רַק קְרִיאוֹת.",
            exampleNative = "Через פֶּרְסְפֶּקְטִיבִיזְם Ницше доказывал: нет чистых фактов, только прочтения.",
            pos = "noun", semanticGroup = "philo_school_continental", fillInBlankExclusions = listOf(190107L, 190108L, 190109L, 190110L)),

        WordEntity(id = 190107, setId = 1901, languagePair = "he-ru", rarity = "RARE",
            original = "פָטָלִיזְם",
            translation = "фатализм",
            definition = "אֱמוּנָה שֶׁכָּל מָה שֶּׁקּוֹרֶה נִקְבָּע מֵרֹאשׁ וּמַאֲמַצֵּי הָאָדָם אֵינָם יְכוֹלִים לְשַׁנּוֹת זֹאת.",
            definitionNative = "Убеждение, что всё происходящее предрешено и человеческие усилия не могут это изменить.",
            example = "סִפְרוּת רוּסִית סְפוּגָה פָטָלִיזְם — מִדּוּאֵל פּוּשְׁקִין עַד קְרָבוֹת טוֹלְסְטוֹי.",
            exampleNative = "Русская литература пропитана פָטָלִיזְם — от дуэлей Пушкина до битв Толстого.",
            pos = "noun", semanticGroup = "philo_school_continental", fillInBlankExclusions = listOf(190106L, 190108L, 190109L, 190110L)),

        WordEntity(id = 190108, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "טְרַנְסְצֶנְדֶנְטָלִיזְם",
            translation = "трансцендентализм",
            definition = "תְּנוּעָה אָמֵרִיקָאִית שֶׁל אֶמֶרְסוֹן וְתוֹרוֹ: חִפּוּשׂ אֱמֶת בַּטֶּבַע וּבָאִינְטוּאִיצְיָה.",
            definitionNative = "Американское движение Эмерсона и Торо: поиск истины в природе и интуиции.",
            example = "תוֹרוֹ פָּרַשׁ לְוַולְדֵּן כְּדֵי לְתַרְגֵּל טְרַנְסְצֶנְדֶנְטָלִיזְם בְּיַעַר.",
            exampleNative = "Торо удалился к Уолдену, чтобы практиковать טְרַנְסְצֶנְדֶנְטָלִיזְם в лесу.",
            pos = "noun", semanticGroup = "philo_school_continental", fillInBlankExclusions = listOf(190106L, 190107L, 190109L, 190110L)),

        WordEntity(id = 190109, setId = 1901, languagePair = "he-ru", rarity = "RARE",
            original = "מַרְקְסִיזְם",
            translation = "марксизм",
            definition = "תּוֹרָה שֶׁל מַרְקְס: הִסְטוֹרְיָה מֻסְבֶּרֶת בְּמַאֲבַק מַעֲמָדוֹת עַל אֶמְצָעֵי הַיִּצּוּר וְהַתְּנָאִים הַחָמְרִיִּים.",
            definitionNative = "Учение Маркса: история объясняется борьбой классов за средства производства и материальные условия.",
            example = "מַרְקְסִיזְם הִשְׁפִּיעַ עַל גַּלֵּי הַמַּהְפֵּכוֹת בַּמֵּאָה הָעֶשְׂרִים בְּכָל יַבֶּשֶׁת.",
            exampleNative = "מַרְקְסִיזְם повлиял на волны революций XX века на каждом континенте.",
            pos = "noun", semanticGroup = "philo_school_continental", fillInBlankExclusions = listOf(190106L, 190107L, 190108L, 190110L)),

        WordEntity(id = 190110, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "פְרוֹיְדִיזְם",
            translation = "фрейдизм",
            definition = "גִּישָׁה שֶׁל פְרוֹיְד: הִתְנַהֲגוּת בּוֹגְרִים מֻנְעֶת בְּעִיקָר מִדְּחָפִים לֹא־מוּדָעִים וּמִתְּסַבְּכֵי יַלְדוּת.",
            definitionNative = "Подход Фрейда: поведение взрослого движимо в основном бессознательными влечениями и детскими комплексами.",
            example = "מְבַקְּרִים אוֹמְרִים שֶׁפְרוֹיְדִיזְם מַסְבִּיר הַכֹּל וְלָכֵן לֹא נִתַּן לְהַפְרָכָה.",
            exampleNative = "Критики говорят, что פְרוֹיְדִיזְם объясняет всё и потому неопровержим.",
            pos = "noun", semanticGroup = "philo_school_continental", fillInBlankExclusions = listOf(190106L, 190107L, 190108L, 190109L)),

        // ── Group: philo_school_analytic_epistem (5 words) ────────────────────

        WordEntity(id = 190111, setId = 1901, languagePair = "he-ru", rarity = "RARE",
            original = "פּוֹזִיטִיבִיזְם",
            translation = "позитивизм",
            definition = "תְּפִיסָה שֶׁל קוֹנְט: יֶדַע אֲמִתִּי מַגִּיעַ רַק מִתַּצְפִּית וְנִסּוּי, וְלֹא מֵהִשְׁעָרוֹת מֶטָפִיסִיוֹת.",
            definitionNative = "Идея Конта: настоящее знание идёт только от наблюдения и опыта, а не от метафизических догадок.",
            example = "קוֹנְט הִצִּיעַ פּוֹזִיטִיבִיזְם כְּתַחֲלִיף לִתְאוֹלוֹגְיָה בְּהַסְבָּרַת הָעוֹלָם.",
            exampleNative = "Конт предложил פּוֹזִיטִיבִיזְם как замену теологии в объяснении мира.",
            pos = "noun", semanticGroup = "philo_school_analytic_epistem", fillInBlankExclusions = listOf(190112L, 190113L, 190114L, 190115L)),

        WordEntity(id = 190112, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "סַיֶנְטִיזְם",
            translation = "сциентизм",
            definition = "עֶמְדָּה שֶׁשִּׁיטוֹת מַדָּעֵי הַטֶּבַע הֵן הַדֶּרֶךְ הַיְחִידָה לְהַשִּׂיג יֶדַע אֲמִתִּי עַל כָּל דָּבָר חָשׁוּב.",
            definitionNative = "Позиция, что методы естественных наук — единственный путь к настоящему знанию о чём-либо важном.",
            example = "סַם הָרִיס מֻאֲשָׁם בְּסַיֶנְטִיזְם — כְּאִלּוּ מַדָּע פּוֹתֵר שְׁאֵלוֹת מוּסָר.",
            exampleNative = "Сэма Харриса обвиняют в סַיֶנְטִיזְם — будто наука решает вопросы морали.",
            pos = "noun", semanticGroup = "philo_school_analytic_epistem", fillInBlankExclusions = listOf(190111L, 190113L, 190114L, 190115L)),

        WordEntity(id = 190113, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "אִינְסְטְרוּמֶנְטָלִיזְם",
            translation = "инструментализм",
            definition = "גִּישַׁת דְּיוּאִי: רַעְיוֹנוֹת הֵם כְּלִי לְפִתְרוֹן בְּעָיוֹת, וְשׁוֹוֵיהֶם נִמְדָּד בְּתוֹעַלָּתָם הַמַּעֲשִׂית.",
            definitionNative = "Подход Дьюи: идеи — инструмент для решения задач, их ценность измеряется практической пользой.",
            example = "דְּיוּאִי הִצִּיעַ אִינְסְטְרוּמֶנְטָלִיזְם כְּדַרְכּוֹ לְחַבֵּר חִנּוּךְ לְחַיֵּי יוֹם־יוֹם.",
            exampleNative = "Дьюи предложил אִינְסְטְרוּמֶנְטָלִיזְם, чтобы связать школу с повседневной жизнью.",
            pos = "noun", semanticGroup = "philo_school_analytic_epistem", fillInBlankExclusions = listOf(190111L, 190112L, 190114L, 190115L)),

        WordEntity(id = 190114, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "קוֹנְוֶנְצְיוֹנָלִיזְם",
            translation = "конвенционализм",
            definition = "עֶמְדַּת פּוּאַנְקָרֶה: אַקְסְיוֹמוֹת מַדָּעִיּוֹת הֵן הֶסְכֵּמִים נוֹחִים שֶׁל הַקְּהִילָה, וְלֹא הִתְגַּלּוּת שֶׁל אֱמֶת.",
            definitionNative = "Позиция Пуанкаре: научные аксиомы — это удобные договорённости сообщества, а не открытие истины.",
            example = "קוֹנְוֶנְצְיוֹנָלִיזְם מַתִּיר לְכַמָּה גֵּאוֹמֶטְרְיוֹת לִחְיוֹת בְּמַקְבִּיל.",
            exampleNative = "קוֹנְוֶנְצְיוֹנָלִיזְם позволяет разным геометриям существовать параллельно.",
            pos = "noun", semanticGroup = "philo_school_analytic_epistem", fillInBlankExclusions = listOf(190111L, 190112L, 190113L, 190115L)),

        WordEntity(id = 190115, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "פַלִיבִּילִיזְם",
            translation = "фаллибилизм",
            definition = "תְּפִיסַת פֵּירְס: כָּל יֶדַע אֱנוֹשִׁי טָעוּן בְּדִיקָה וְעָלוּל לְהִתְבָּרֵר כְּטָעוּת בְּהֶמְשֵׁךְ הַמֶּחְקָר.",
            definitionNative = "Идея Пирса: всякое человеческое знание подлежит проверке и может оказаться ошибочным.",
            example = "פַלִיבִּילִיזְם הוֹפֵךְ אֶת הַמַּדָּע לְתַהֲלִיךְ פָּתוּחַ שֶׁל תִּקּוּן עַצְמִי.",
            exampleNative = "פַלִיבִּילִיזְם превращает науку в открытый процесс самоисправления.",
            pos = "noun", semanticGroup = "philo_school_analytic_epistem", fillInBlankExclusions = listOf(190111L, 190112L, 190113L, 190114L)),

        // ── Group: philo_school_metaphysics (5 words) ─────────────────────────

        WordEntity(id = 190116, setId = 1901, languagePair = "he-ru", rarity = "RARE",
            original = "מוֹנִיזְם",
            translation = "монизм",
            definition = "עֶמְדָּה שֶׁהָעוֹלָם בָּנוּי מִיְּסוֹד אֶחָד בִּלְבָד — בֵּין אִם רוּחַ, חֹמֶר אוֹ דְּבַר־מָה אַחֵר.",
            definitionNative = "Позиция, что мир состоит из одного начала — будь то дух, материя или нечто иное.",
            example = "סְפִּינוֹזָה הֵגֵן עַל מוֹנִיזְם שֶׁבּוֹ אֱלֹהִים וְהַטֶּבַע הֵם אוֹתוֹ דָּבָר.",
            exampleNative = "Спиноза защищал מוֹנִיזְם, в котором Бог и природа — одно и то же.",
            pos = "noun", semanticGroup = "philo_school_metaphysics", fillInBlankExclusions = listOf(190117L, 190118L, 190119L, 190120L)),

        WordEntity(id = 190117, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "פַּן־פְּסִיכִיזְם",
            translation = "панпсихизм",
            definition = "הַטְּעָנָה שֶׁתּוֹדָעָה הִיא תְּכוּנָה יְסוֹדִית שֶׁל כָּל הַחֹמֶר, וְלֹא רַק שֶׁל מוֹחוֹת.",
            definitionNative = "Утверждение, что сознание — базовое свойство всей материи, а не только мозгов.",
            example = "סְטְרוֹסוֹן הֶחֱיָה אֶת פַּן־פְּסִיכִיזְם בְּכָךְ שֶׁאֲפִילוּ אֶלֶקְטְרוֹן יֵשׁ לוֹ פְּנִים.",
            exampleNative = "Стросон оживил פַּן־פְּסִיכִיזְם, утверждая, что даже у электрона есть внутреннее.",
            pos = "noun", semanticGroup = "philo_school_metaphysics", fillInBlankExclusions = listOf(190116L, 190118L, 190119L, 190120L)),

        WordEntity(id = 190118, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "וִיטָלִיזְם",
            translation = "витализм",
            definition = "תּוֹרָה שֶׁבֶּרְגְסוֹן הִחְיָה: בַּיְצוּרִים הַחַיִּים פּוֹעֵל יְסוֹד מְיֻחָד שֶׁאֵינוֹ מִסְתַּכֵּם בְּפִיזִיקָה וְכִימְיָה.",
            definitionNative = "Учение, оживлённое Бергсоном: в живом действует особое начало, не сводимое к физике и химии.",
            example = "וִיטָלִיזְם נָסוֹג כְּשֶׁבְּיוֹלוֹגְיָה מוֹלֵקוּלָרִית הִסְבִּירָה הַעֲבָרַת מֵידָע גֵּנֵטִי.",
            exampleNative = "וִיטָלִיזְם отступил, когда молекулярная биология объяснила передачу генетической информации.",
            pos = "noun", semanticGroup = "philo_school_metaphysics", fillInBlankExclusions = listOf(190116L, 190117L, 190119L, 190120L)),

        WordEntity(id = 190119, setId = 1901, languagePair = "he-ru", rarity = "RARE",
            original = "נָטוּרָלִיזְם",
            translation = "натурализм (филос.)",
            definition = "עֶמְדָּה שֶׁהָעוֹלָם מַסְבִּיר אֶת עַצְמוֹ — אֵין צֹרֶךְ בְּכֹחוֹת עַל־טִבְעִיִּים אוֹ בֵּית־דִּין רוּחָנִי.",
            definitionNative = "Позиция, что мир объясняет себя сам — нет нужды в сверхъестественных силах или духовной инстанции.",
            example = "קְוַוִיְן דָּחַף נָטוּרָלִיזְם שֶׁבּוֹ פִּילוֹסוֹפְיָה רְצוּפָה עִם מַדָּעִי הַטֶּבַע.",
            exampleNative = "Куайн продвигал נָטוּרָלִיזְם, в котором философия едина с естественными науками.",
            pos = "noun", semanticGroup = "philo_school_metaphysics", fillInBlankExclusions = listOf(190116L, 190117L, 190118L, 190120L)),

        WordEntity(id = 190120, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "תֶּלֵיאוֹלוֹגְיָה",
            translation = "телеология",
            definition = "תְּפִיסָה שֶׁאָרִיסְטוֹ פִּתֵּחַ: כָּל יֵשׁוּת בַּטֶּבַע פּוֹעֶלֶת לִקְרַאת מַטָּרָה פְּנִימִית.",
            definitionNative = "Идея Аристотеля: каждая сущность в природе действует ради внутренней цели.",
            example = "בְּיוֹלוֹגְיָה מוֹדֶרְנִית מוֹחֶקֶת תֶּלֵיאוֹלוֹגְיָה מִתּוֹךְ אֵבוֹלוּצְיָה עִוֶּרֶת.",
            exampleNative = "Современная биология выбрасывает תֶּלֵיאוֹלוֹגְיָה ради слепой эволюции.",
            pos = "noun", semanticGroup = "philo_school_metaphysics", fillInBlankExclusions = listOf(190116L, 190117L, 190118L, 190119L)),

        // ── Group: philo_school_ethics (5 words) ──────────────────────────────

        WordEntity(id = 190121, setId = 1901, languagePair = "he-ru", rarity = "RARE",
            original = "דֵאוֹנְטוֹלוֹגְיָה",
            translation = "деонтология",
            definition = "גִּישָׁה שֶׁל קַנְט: מַעֲשֶׂה הוּא צוֹדֵק לְפִי הַחוֹבָה שֶׁמְּכַוֶּנֶת אוֹתוֹ, וְלֹא לְפִי תּוֹצְאוֹתָיו.",
            definitionNative = "Подход Канта: поступок справедлив по правилу долга, направляющему его, а не по последствиям.",
            example = "דֵאוֹנְטוֹלוֹגְיָה אוֹסֶרֶת לְשַׁקֵּר גַּם כְּשֶׁשֶּׁקֶר קָטָן יָכוֹל לְהַצִּיל חַיִּים.",
            exampleNative = "דֵאוֹנְטוֹלוֹגְיָה запрещает лгать, даже когда маленькая ложь может спасти жизнь.",
            pos = "noun", semanticGroup = "philo_school_ethics", fillInBlankExclusions = listOf(190123L, 190124L, 190125L)),

        WordEntity(id = 190122, setId = 1901, languagePair = "he-ru", rarity = "RARE",
            original = "אֶתִיקַת מִידּוֹת",
            translation = "этика добродетели",
            definition = "גִּישַׁת אָרִיסְטוֹ: הַשְּׁאֵלָה אֵינָהּ לְאֵיזֶה כְּלָל לְצַיֵּת, אֶלָּא אֵיזֶה טִיפּוּס שֶׁל אָדָם לִהְיוֹת.",
            definitionNative = "Подход Аристотеля: вопрос не «какому правилу следовать», а «каким человеком становиться».",
            example = "מָקְאִינְטַייר הֶחֱיָה אֶת אֶתִיקַת מִידּוֹת בַּסֵּפֶר «אַחֲרֵי הַסְּגֻלָּה».",
            exampleNative = "Макинтайр оживил אֶתִיקַת מִידּוֹת в книге «После добродетели».",
            pos = "phrase", semanticGroup = "philo_school_ethics"),

        WordEntity(id = 190123, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "אַסְקֶטִיזְם",
            translation = "аскетизм",
            definition = "אֹרַח חַיִּים שֶׁמְּוַתֵּר עַל נוֹחוּת גּוּפָנִית וַהֲנָאָה כְּדֵי לְהַשִּׂיג מַטָּרוֹת רוּחָנִיּוֹת אוֹ מוּסָרִיּוֹת.",
            definitionNative = "Образ жизни, отказывающийся от телесного комфорта и наслаждения ради духовных или нравственных целей.",
            example = "נְזִירִים שֶׁל יְמֵי הַבֵּינַיִם תִּרְגְּלוּ אַסְקֶטִיזְם חָמוּר וְיָשְׁנוּ עַל אֶבֶן.",
            exampleNative = "Средневековые монахи практиковали суровый אַסְקֶטִיזְם и спали на камне.",
            pos = "noun", semanticGroup = "philo_school_ethics", fillInBlankExclusions = listOf(190121L, 190124L, 190125L)),

        WordEntity(id = 190124, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "קוֹנְסֵקְוֶנְצִיאָלִיזְם",
            translation = "консеквенциализм",
            definition = "תְּפִיסָה מוּסָרִית שֶׁשּׁוֹפֶטֶת מַעֲשִׂים רַק לְפִי תּוֹצְאוֹתֵיהֶם, וְלֹא לְפִי כַּוָּנָה אוֹ כְּלָל.",
            definitionNative = "Нравственная позиция: поступок оценивается только по последствиям, а не по намерению или правилу.",
            example = "קוֹנְסֵקְוֶנְצִיאָלִיזְם חָמוּר יָכוֹל לְהַצְדִּיק שֶׁקֶר קָטָן שֶׁמַּצִּיל חַיִּים.",
            exampleNative = "Строгий קוֹנְסֵקְוֶנְצִיאָלִיזְם может оправдать маленькую ложь, спасающую жизнь.",
            pos = "noun", semanticGroup = "philo_school_ethics", fillInBlankExclusions = listOf(190121L, 190123L, 190125L)),

        WordEntity(id = 190125, setId = 1901, languagePair = "he-ru", rarity = "EPIC",
            original = "קוֹמוּנִיטָרִיזְם",
            translation = "коммунитаризм",
            definition = "זֶרֶם שֶׁל סַנְדֵּל וּמָקְאִינְטַייר: הָאָדָם מְעֻצָּב בִּקְהִילָה, וְעֶרְכֵי הַקְּהִילָה קוֹדְמִים לִזְכוּת הַפְּרָט.",
            definitionNative = "Течение Сэндела и Макинтайра: человек формируется общиной, и её ценности предшествуют праву индивида.",
            example = "סַנְדֵּל הִשְׁתַּמֵּשׁ בְּקוֹמוּנִיטָרִיזְם כְּדֵי לְבַקֵּר אֶת הַלִּיבֵּרָלִיזְם שֶׁל רוֹלְז.",
            exampleNative = "Сэндел использовал קוֹמוּנִיטָרִיזְם, чтобы критиковать либерализм Ролза.",
            pos = "noun", semanticGroup = "philo_school_ethics", fillInBlankExclusions = listOf(190121L, 190123L, 190124L)),
    )
}
