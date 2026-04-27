package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — Салон красоты и работа парикмахером, level 4 (профессиональный).
 *
 * Set:
 *   - 1798 (L4, EPIC + LEGENDARY) — лексика для опытного мастера-колориста и
 *                                   стилиста: теория цвета, продвинутые техники
 *                                   окрашивания, химия волоса, профессиональные
 *                                   процедуры коррекции, подиумный стайлинг.
 *
 * Тема «Салон красоты и работа парикмахером» уже представлена сетами 1736–1738
 * (L1–L3). В L4 ни одно слово не повторяется по `original` с тремя младшими
 * сетами и не использует общих шорешей — заимствования (балаяж, омбре,
 * кератин, керамика и т. п.) исключены.
 *
 * SemanticGroups (5 × 5):
 *   barber_color              — теория и тональный круг
 *   barber_advanced_techniques — продвинутые техники окрашивания
 *   barber_dyeing             — профессиональное окрашивание
 *   barber_chemistry          — структура и химия волоса
 *   barber_styling            — оформление, термозащита, подиум
 *
 * Word IDs: setId * 100 + position (179801..179825).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewBarberL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1798, languagePair = "he-ru", orderIndex = 1798,
            name = "Салон красоты и работа парикмахером",
            description = "Профессиональный парикмахер: колористика, продвинутые техники, окрашивание, химия волос",
            topic = "Салон красоты и работа парикмахером", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1798 — L4, EPIC + LEGENDARY
        // ══════════════════════════════════════════════════════════════════════

        // ── barber_color (5) ──────────────────────────────────────────────────
        WordEntity(
            id = 179801, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_color", transliteration = "масак тонали",
            original = "מַשַׁק טוֹנָלִי", translation = "тональная палитра",
            definition = "מַעֲרֶכֶת מְסֻדֶּרֶת שֶׁל גְּוָנִים מִן הַחַם לַקַּר עַל מַעְגָּל אֶחָד.",
            definitionNative = "Упорядоченный набор оттенков от тёплых к холодным на одном круге.",
            example = "הַקּוֹלוֹרִיסְטִית פָּתְחָה מַשַׁק טוֹנָלִי מוּל הַלָּקוֹחָה.",
            exampleNative = "Колорист открыла מַשַׁק טוֹנָלִי перед клиенткой.",
        ),
        WordEntity(
            id = 179802, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_color", transliteration = "андэртон",
            original = "אַנְדֶּרְטוֹן", translation = "подтон",
            definition = "צֶבַע מִתַּחַת לְפָנֵי הַשֶּׁטַח שֶׁמַּטֶּה אֶת הַתּוֹצָאָה לְחַם אוֹ קַר.",
            definitionNative = "Скрытый под поверхностью тон, склоняющий результат к тёплому или холодному.",
            example = "הָאַנְדֶּרְטוֹן הַזָּהֻבִּי שֶׁלָּהּ דּוֹרֵשׁ בָּסִיס נֵיטְרָלִי.",
            exampleNative = "Её золотистый אַנְדֶּרְטוֹן требует нейтральной базы.",
         fillInBlankExclusions = listOf(179803L, 179804L, 179805L)),
        WordEntity(
            id = 179803, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_color", transliteration = "корэктор",
            original = "קוֹרֶקְטוֹר", translation = "корректор оттенка",
            definition = "תַּכְשִׁיר מְרֻכָּז שֶׁמְּבַטֵּל גְּוָנִים לֹא רְצוּיִים בַּתּוֹצָאָה.",
            definitionNative = "Концентрированное средство, гасящее нежелательные оттенки в результате.",
            example = "טִיפַּת קוֹרֶקְטוֹר יָרֹק בִּטְּלָה אֶת הָאֲדַמְדַּם.",
            exampleNative = "Капля зелёного קוֹרֶקְטוֹר убрала рыжину.",
         fillInBlankExclusions = listOf(179802L, 179804L, 179805L)),
        WordEntity(
            id = 179804, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_color", transliteration = "мэланин",
            original = "מֶלָנִין", translation = "меланин",
            definition = "חֹמֶר טִבְעִי שֶׁקּוֹבֵעַ אֶת הַגָּוֶן הַמְּקוֹרִי שֶׁל הַקּוֹצוֹת.",
            definitionNative = "Природное вещество, задающее естественный тон каждой пряди.",
            example = "כַּמּוּת הַמֶּלָנִין יוֹרֶדֶת עִם הַשָּׁנִים אֶצְלוֹ.",
            exampleNative = "Количество מֶלָנִין с годами у него снижается.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179805, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_color", transliteration = "нусха",
            original = "נֻסְחָה", translation = "формула окрашивания",
            definition = "תַּעֲרֹבֶת מְדֻיֶּקֶת שֶׁל מוּצָרִים וְיַחֲסִים לְהַשָּׂגַת תּוֹצָאָה רְצוּיָה.",
            definitionNative = "Точная смесь продуктов и пропорций ради нужного результата.",
            example = "הַנֻּסְחָה רְשׁוּמָה בַּכַּרְטִיס הָאִישִׁי שֶׁל הַלָּקוֹחָה.",
            exampleNative = "נֻסְחָה записана в личной карточке клиентки.",
            isFillInBlankSafe = false,
        ),

        // ── barber_advanced_techniques (5) ────────────────────────────────────
        WordEntity(
            id = 179806, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_advanced_techniques", transliteration = "бэйбилайтс",
            original = "בֵּייבִּילַיְיטְס", translation = "бэбилайтс",
            definition = "טֶכְנִיקָה דַּקָּה מְאֹד הַמְּחַקָּה הַבְהָרַת שֶׁמֶשׁ אֶצְלָם בַּיַּלְדוּת.",
            definitionNative = "Очень тонкая техника, имитирующая выгорание под солнцем как в детстве.",
            example = "בֵּייבִּילַיְיטְס מַתְאִים לַשֵּׂעָר הַבָּהִיר הַטִּבְעִי שֶׁלָּהּ.",
            exampleNative = "בֵּייבִּילַיְיטְס подходят её естественно русым волосам.",
         fillInBlankExclusions = listOf(179807L, 179808L, 179809L, 179810L)),
        WordEntity(
            id = 179807, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_advanced_techniques", transliteration = "контуринг",
            original = "קוֹנְטוּרִינְג", translation = "контуринг (волос)",
            definition = "צְלָלִית כֵּהָה וְהַבְהָרָה בַּמְּקוֹמוֹת הַנְּכוֹנִים לְעִיצּוּב הַפָּנִים.",
            definitionNative = "Тёмная тень и осветление в нужных местах ради корректировки овала лица.",
            example = "קוֹנְטוּרִינְג מַסְתִּיר לֶחָיַיִם רְחָבוֹת בְּלִי אִיפּוּר.",
            exampleNative = "קוֹנְטוּרִינְג скрывает широкие скулы без макияжа.",
         fillInBlankExclusions = listOf(179806L, 179808L, 179809L, 179810L)),
        WordEntity(
            id = 179808, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_advanced_techniques", transliteration = "фойль-яаж",
            original = "פוֹאִיל-יָאז'", translation = "фольгаж",
            definition = "שִׁילּוּב שֶׁל מְשִׁיחָה חָפְשִׁית עִם יְרִיעוֹת מַתֶּכֶת לְבִידּוּד.",
            definitionNative = "Сочетание свободной кисти с металлическими листами для изоляции.",
            example = "פוֹאִיל-יָאז' מַגְבִּיר אֶת הַחֲדוּת בְּלִי לְוַתֵּר עַל רֹךְ.",
            exampleNative = "פוֹאִיל-יָאז' усиливает чёткость без потери мягкости.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179809, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_advanced_techniques", transliteration = "глосинг",
            original = "גְּלוֹסִינְג", translation = "глоссинг",
            definition = "טִיפּוּל מַבְרִיק הַמּוֹסִיף שִׁכְבָה סְמִיכָה שֶׁל זוֹהַר וּלְטִיפוּת.",
            definitionNative = "Блестящая процедура, добавляющая густой слой сияния и гладкости.",
            example = "אַחֲרֵי גְּלוֹסִינְג הַתְּמוּנָה בָּאוּר נִרְאֵית כְּמוֹ זְכוּכִית.",
            exampleNative = "После גְּלוֹסִינְג фотография на свету выглядит как стекло.",
         fillInBlankExclusions = listOf(179806L, 179807L, 179808L, 179810L)),
        WordEntity(
            id = 179810, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_advanced_techniques", transliteration = "дастинг",
            original = "דַּסְטִינְג", translation = "дастинг",
            definition = "טֶכְנִיקָה שֶׁל חֲתִיכָה נְקוּדָתִית בַּקְּצָווֹת לְהַסָּרַת פְּסֹלֶת.",
            definitionNative = "Точечная подрезка кончиков для удаления повреждённого края.",
            example = "דַּסְטִינְג חָדְשִׁי שׁוֹמֵר עַל הַתַּסְפֹּרֶת בְּלִי לְקַצֵּר אֹרֶךְ.",
            exampleNative = "Ежемесячный דַּסְטִינְג держит форму без потери длины.",
         fillInBlankExclusions = listOf(179806L, 179807L, 179808L, 179809L)),

        // ── barber_dyeing (5) ─────────────────────────────────────────────────
        WordEntity(
            id = 179811, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_dyeing", transliteration = "noazel mefa'el",
            original = "נוֹזֵל מְפַעֵל", translation = "активатор окрашивания",
            definition = "מַרְכִּיב שֶׁעוֹזֵר לַצֶּבַע לְהִכָּנֵס עָמוֹק לְתוֹךְ הַסִּיב וּלְהֵיתָבֵת.",
            definitionNative = "Компонент, помогающий краске глубже зайти в волокно и закрепиться.",
            example = "נוֹזֵל מְפַעֵל חָזָק מַתְאִים רַק לְצֶבַע מַשְׁמָעוּתִי וּמַעֲמִיק.",
            exampleNative = "Сильный נוֹזֵל מְפַעֵל подходит только для глубокого окрашивания.",
         fillInBlankExclusions = listOf(179813L, 179814L, 179815L)),
        WordEntity(
            id = 179812, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_dyeing", transliteration = "нэгиат шорэш",
            original = "נְגִיעַת שֹׁרֶשׁ", translation = "подкрашивание корней",
            definition = "טִיפּוּל קָצָר שֶׁמְּחַדֵּשׁ אֶת הַגָּוֶן בִּשְׁנֵי הַסַּנְטִימֶטְרִים הַתַּחְתּוֹנִים.",
            definitionNative = "Короткая процедура, обновляющая тон в нижних двух сантиметрах прядей.",
            example = "נְגִיעַת שֹׁרֶשׁ אֶחָת לְשִׁשָּׁה שָׁבוּעוֹת מַסְפִּיקָה לָהּ.",
            exampleNative = "Одной נְגִיעַת שֹׁרֶשׁ раз в шесть недель ей хватает.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179813, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_dyeing", transliteration = "дhия",
            original = "דְּהִיָּה", translation = "выцветание",
            definition = "אִבּוּד הַדְרָגָתִי שֶׁל הַחֹזֶק בַּגָּוֶן בְּגִין שֶׁמֶשׁ אוֹ שְׁטִיפוֹת.",
            definitionNative = "Постепенная потеря густоты тона из-за солнца или частых смываний.",
            example = "הַדְּהִיָּה בָּאֲדֻמָּה מַתְחִילָה כְּבָר אַחֲרֵי שְׁבוּעַיִם.",
            exampleNative = "דְּהִיָּה на красном начинается уже через две недели.",
         fillInBlankExclusions = listOf(179811L, 179814L, 179815L)),
        WordEntity(
            id = 179814, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_dyeing", transliteration = "кэhуй",
            original = "כֵּהוּי", translation = "затемнение тона",
            definition = "הַעֲמָקַת הַגָּוֶן בְּמִסְפַּר רָמוֹת בְּעֶזְרַת תַּכְשִׁירִים בְּלִי הַבְהָרָה.",
            definitionNative = "Углубление тона на несколько уровней средствами без осветления.",
            example = "הַכֵּהוּי הַחֲדָשׁ נוֹתֵן עֹמֶק בְּלִי לִפְגֹּעַ בַּקּוֹצָה.",
            exampleNative = "Новый כֵּהוּי даёт глубину без вреда для пряди.",
         fillInBlankExclusions = listOf(179811L, 179813L, 179815L)),
        WordEntity(
            id = 179815, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_dyeing", transliteration = "минун",
            original = "מִינוּן", translation = "дозировка",
            definition = "מִדַּת הַחֹמֶר הַמְּדֻיֶּקֶת לְפִי מִשְׁקַל הַשֵּׂעָר וְעָבְיוֹ.",
            definitionNative = "Точное количество средства по весу волос и их толщине.",
            example = "מִינוּן לֹא נָכוֹן יָבִיא לְכִתְמֵי צֶבַע בְּלִי הַסְוָאָה.",
            exampleNative = "Неверный מִינוּן приведёт к открытым пятнам без растушёвки.",
         fillInBlankExclusions = listOf(179811L, 179813L, 179814L)),

        // ── barber_chemistry (5) ──────────────────────────────────────────────
        WordEntity(
            id = 179816, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_chemistry", transliteration = "кутикула",
            original = "קוּטִיקוּלָה", translation = "кутикула",
            definition = "שִׁכְבָה חִיצוֹנִית שֶׁל קַשְׂקַשִּׂים זְעִירִים הַמְּגֵנָּה עַל הַקּוֹצָה.",
            definitionNative = "Внешний слой крошечных чешуек, защищающий каждую прядь снаружи.",
            example = "הַקּוּטִיקוּלָה נִפְתַּחַת בַּחֹם וְנִסְגֶּרֶת בַּקֹּר.",
            exampleNative = "קוּטִיקוּלָה раскрывается в тепле и закрывается в холоде.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179817, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_chemistry", transliteration = "кэшэр дисульфиди",
            original = "קֶשֶׁר דִּיסוּלְפִידִי", translation = "дисульфидная связь",
            definition = "גֶּשֶׁר חָזָק בֵּין שְׁתֵּי מוֹלֶקוּלוֹת שֶׁקּוֹבֵעַ אֶת צוּרַת הַקּוֹצָה.",
            definitionNative = "Прочный мостик между двумя молекулами, задающий форму каждой пряди.",
            example = "קֶשֶׁר דִּיסוּלְפִידִי נִשְׁבָּר בַּחֻמְצָה וְנִבְנֶה מֵחָדָשׁ אַחֲרֵי שְׁטִיפָה.",
            exampleNative = "קֶשֶׁר דִּיסוּלְפִידִי рвётся в кислоте и выстраивается заново после смывания.",
         fillInBlankExclusions = listOf(179819L)),
        WordEntity(
            id = 179818, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_chemistry", transliteration = "эластиют",
            original = "אֱלַסְטִיוּת", translation = "эластичность",
            definition = "יְכֹלֶת הַקּוֹצָה לְהִמָּתַח וְלַחֲזֹר לִמְקוֹמָהּ בְּלִי לְהִשָּׁבֵר.",
            definitionNative = "Способность пряди растянуться и вернуться на место без разрыва.",
            example = "אֱלַסְטִיוּת חַלָּשָׁה רוֹמֶזֶת עַל קוֹצוֹת פָּגוּעוֹת מֵעֹמֶק.",
            exampleNative = "Слабая אֱלַסְטִיוּת указывает на повреждение прядей изнутри.",
         fillInBlankExclusions = listOf(179816L, 179820L)),
        WordEntity(
            id = 179819, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_chemistry", transliteration = "пэ-hэй балянс",
            original = "pH-בָּלָנְס", translation = "pH-баланс",
            definition = "מַצָּב יַצִּיב בֵּין חוּמָץ וּבֵין בָּסִיס בְּתוֹךְ הַשִּׁכְבָה הַחִיצוֹנִית.",
            definitionNative = "Устойчивое равновесие между кислым и щелочным во внешнем слое.",
            example = "pH-בָּלָנְס נָכוֹן שׁוֹמֵר עַל בְּרִיאוּת הָעוֹר וְהַקּוֹצָה.",
            exampleNative = "Правильный pH-בָּלָנְס хранит здоровье кожи и пряди.",
         fillInBlankExclusions = listOf(179817L)),
        WordEntity(
            id = 179820, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_chemistry", transliteration = "амидут",
            original = "עֲמִידוּת", translation = "стойкость",
            definition = "מִידַת הַזְּמַן שֶׁתּוֹצָאָה שׁוֹרֶדֶת בְּלִי לְאַבֵּד מֵהַחֲדוּת.",
            definitionNative = "Срок, в течение которого результат сохраняется без потери чёткости.",
            example = "הָעֲמִידוּת שֶׁל הַתַּכְשִׁיר הַזֶּה מַגִּיעָה לִשְׁמוֹנָה שָׁבוּעוֹת.",
            exampleNative = "עֲמִידוּת этого средства доходит до восьми недель.",
         fillInBlankExclusions = listOf(179816L, 179818L)),

        // ── barber_styling (5) ────────────────────────────────────────────────
        WordEntity(
            id = 179821, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_styling", transliteration = "hагана тэрмит",
            original = "הֲגָנָה תֶּרְמִית", translation = "термозащита",
            definition = "תַּכְשִׁיר שֶׁמַּקִּיף אֶת הַקּוֹצָה בִּשְׁכָבָה דַּקָּה לִפְנֵי שִׁמּוּשׁ בְּמַכְשִׁירִים חַמִּים.",
            definitionNative = "Средство, обволакивающее прядь тонким слоем перед горячими приборами.",
            example = "הֲגָנָה תֶּרְמִית חוֹסֶכֶת נֵזֶק בַּשִּׁמּוּשׁ הַיּוֹמְיוֹמִי.",
            exampleNative = "הֲגָנָה תֶּרְמִית бережёт от ущерба при ежедневном уходе.",
         fillInBlankExclusions = listOf(179824L, 179825L)),
        WordEntity(
            id = 179822, setId = 1798, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_styling", transliteration = "идуй",
            original = "אִידּוּי", translation = "паровое оформление",
            definition = "עִיצּוּב בְּעֶזְרַת אֵד חַם הַחוֹדֵר אֶל פְּנִים הַקּוֹצָה.",
            definitionNative = "Оформление при помощи горячего пара, проникающего внутрь пряди.",
            example = "הָאִידּוּי הַחֲדָשׁ עוֹשֶׂה תַּלְתַּלִּים רְחָבִים וְרַכִּים.",
            exampleNative = "Новый אִידּוּי делает локоны крупными и мягкими.",
         fillInBlankExclusions = listOf(179823L)),
        WordEntity(
            id = 179823, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_styling", transliteration = "тэкстура",
            original = "טֶקְסְטוּרָה", translation = "текстура (волос)",
            definition = "תְּחוּשַׁת הַמַּגָּע וְהַמַּרְאֶה — חָלָק, גַּס, מְעֻגָּל אוֹ דַּק.",
            definitionNative = "Ощущение на ощупь и вид — гладкое, грубое, округлое или тонкое.",
            example = "הַטֶּקְסְטוּרָה הַטִּבְעִית שֶׁלָּהּ דּוֹמָה לְמֶשִׁי קַל.",
            exampleNative = "Природная טֶקְסְטוּרָה у неё похожа на лёгкий шёлк.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179824, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_styling", transliteration = "тисрокэт маслуль",
            original = "תִּסְרֹקֶת מַסְלוּל", translation = "подиумная причёска",
            definition = "עִיצּוּב נוֹעָז וּמֻגְזָם לְצֹרֶךְ צִילּוּם אוֹ הוֹפָעַת אָפְנָה.",
            definitionNative = "Дерзкое и преувеличенное оформление ради съёмки или модного показа.",
            example = "תִּסְרֹקֶת מַסְלוּל לוֹקַחַת שָׁעָתַיִם וּמַעְמָד שֶׁל שְׁלוֹשָׁה אֻמָּנִים.",
            exampleNative = "תִּסְרֹקֶת מַסְלוּל занимает два часа и работу трёх ассистентов.",
         fillInBlankExclusions = listOf(179821L, 179825L)),
        WordEntity(
            id = 179825, setId = 1798, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_styling", transliteration = "рош дэгэм",
            original = "רֹאשׁ דֶּגֶם", translation = "голова-манекен",
            definition = "מַעֲרֶכֶת אִימוּן עִם פָּנִים מְלָאכוּתִיוֹת וְקוֹצוֹת לְתַרְגּוּל טֶכְנִיקוֹת.",
            definitionNative = "Тренировочная конструкция с искусственным лицом и прядями для отработки приёмов.",
            example = "כָּל לִמּוּד מַתְחִיל בְּרֹאשׁ דֶּגֶם וְלֹא בְּלָקוֹחַ אֲמִיתִּי.",
            exampleNative = "Любое обучение начинается с רֹאשׁ דֶּגֶם, а не с живого клиента.",
         fillInBlankExclusions = listOf(179821L, 179824L)),
    )
}
