package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Кофейня и работа баристой" (level 4).
 *
 * Set 1796: «Кофейня и работа баристой» — профессиональный (L4, EPIC+LEGENDARY):
 *           спешелти, латте-арт, обжарка, профайлинг, конкурсы.
 *
 * Тема согласована с L1-L3 (1739-1741), здесь — углублённая профессиональная
 * лексика бариста-чемпионатов и продвинутой переработки. Слова не пересекаются
 * с предыдущими сетами темы (1739-1741).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   barista_specialty          — спешелти / обработка / редкие сорта
 *   barista_latte_art          — продвинутые латте-арт техники
 *   barista_roasting           — обжарка: фазы, химия, профайлинг
 *   barista_brewing_advanced   — заварочные методы high-end
 *   barista_competition        — чемпионаты, оценка, авторские подачи
 *
 * Word IDs: setId × 100 + position (179601..179625).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewBaristaL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1796, languagePair = "he-ru", orderIndex = 1796,
            name = "Кофейня и работа баристой",
            description = "Профессиональный бариста: спешелти, латте-арт, обжарка, профайлинг, конкурсы",
            topic = "Кофейня и работа баристой", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1796 — Кофейня и работа баристой: профессиональный (L4, EPIC+LEGENDARY, C1-C2)
        // 5 групп × 5 слов: specialty, latte_art, roasting, brewing_advanced, competition
        // ══════════════════════════════════════════════════════════════════════

        // ── barista_specialty (5) — спешелти, обработка, редкие сорта ──
        WordEntity(
            id = 179601, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_specialty", transliteration = "teruar",
            original = "טֵרוּאָר", translation = "терруар",
            definition = "תְּכוּנוֹת קַרְקַע, אַקְלִים וְגֹבַהּ הַטְּבוּעוֹת בַּטַּעַם שֶׁל זַן מִמָּקוֹם מְסֻיָּם.",
            definitionNative = "Свойства почвы, климата и высоты, отпечатанные во вкусе сорта с конкретного места.",
            example = "הַטֵּרוּאָר שֶׁל הַזַּן הַזֶּה מַזְכִּיר אֲדָמַת הָרֵי גְּוָאטֶמָלָה.",
            exampleNative = "טֵרוּאָר этого сорта напоминает почву гор Гватемалы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179602, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_specialty", transliteration = "ibud rachuts",
            original = "עִבּוּד רָחוּץ", translation = "мытая обработка",
            definition = "שִׁיטַת הֲסָרַת הַבְּשָׂרִית מֵהַזֶּרַע בְּמַיִם זוֹרְמִים לִפְנֵי הַיִּבּוּשׁ.",
            definitionNative = "Способ снятия мякоти с косточки в проточной воде до начала просушки.",
            example = "עִבּוּד רָחוּץ נוֹתֵן כּוֹס נְקִיָּה וְחַמְצִיצוּת בְּהִירָה.",
            exampleNative = "עִבּוּד רָחוּץ даёт чистую чашку и яркую кислинку.",
         fillInBlankExclusions = listOf(179603L, 179605L)),
        WordEntity(
            id = 179603, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_specialty", transliteration = "honey",
            original = "הוֹנִי", translation = "хани (медовая обработка)",
            definition = "דֶּרֶךְ בֵּינַיִם שֶׁמַּשְׁאִירָה רֹב הַסּוּכָּר עַל הַזֶּרַע בִּזְמַן הַיִּבּוּשׁ.",
            definitionNative = "Промежуточный путь, оставляющий часть сахара на косточке во время просушки.",
            example = "הוֹנִי קוֹסְטָה רִיקָאי הִפְתִּיעַ אוֹתָנוּ בִּמְתִיקוּת שֶׁל דְּבַשׁ.",
            exampleNative = "הוֹנִי из Коста-Рики удивил нас сладостью настоящего мёда.",
         fillInBlankExclusions = listOf(179601L, 179602L, 179604L)),
        WordEntity(
            id = 179604, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_specialty", transliteration = "geisha",
            original = "גֵּישָׁה", translation = "гейша (сорт)",
            definition = "זַן יָקָר בַּעַל אֲרוֹמָה פִּרְחוֹנִית מְעוּדֶנֶת מִכַּפְרֵי הָרֵי פָּנָמָה.",
            definitionNative = "Дорогой сорт с тонким цветочным букетом из горных деревень Панамы.",
            example = "גֵּישָׁה זוֹכָה בִּמְעוֹדִים בְּכָל מִשְׁחֲקֵי טְעִימָה גְּדוֹלִים.",
            exampleNative = "גֵּישָׁה берёт медали на всех больших турнирах дегустаторов.",
         fillInBlankExclusions = listOf(179601L, 179603L)),
        WordEntity(
            id = 179605, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barista_specialty", transliteration = "mikro-lot",
            original = "מִיקְרוֹ־לוֹט", translation = "микро-лот",
            definition = "מָנָה זְעִירָה מֵחֶלְקָה אַחַת בְּחַוָּה אַחַת בְּעוֹנָה אַחַת בִּלְבָד.",
            definitionNative = "Крошечная партия с одного участка одной фермы за один сезон сбора.",
            example = "קָנִיתִי מִיקְרוֹ־לוֹט מִקֶּנְיָה בִּשְׁלוֹשִׁים שְׁקָלִים לְכָל מֵאָה גְּרַם.",
            exampleNative = "Я взял מִיקְרוֹ־לוֹט из Кении по тридцать шекелей за сто грамм.",
         fillInBlankExclusions = listOf(179602L)),

        // ── barista_latte_art (5) — продвинутые техники латте-арт ──
        WordEntity(
            id = 179606, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_latte_art", transliteration = "barbur",
            original = "בַּרְבּוּר", translation = "лебедь (узор)",
            definition = "צִיּוּר עֲדִין בְּצוּרַת עוֹף מַיִם עִם צַוָּאר וְכָנָף עַל הַכּוֹס.",
            definitionNative = "Изящный рисунок водной птицы с шеей и крылом наверху чашки.",
            example = "הוּא צִיֵּר בַּרְבּוּר עַל הַכּוֹס בְּתוֹךְ עֲשָׂרָה שְׁנִיוֹת.",
            exampleNative = "Он нарисовал בַּרְבּוּר на бокале за десять секунд.",
         fillInBlankExclusions = listOf(179609L)),
        WordEntity(
            id = 179607, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_latte_art", transliteration = "ketsef mikro",
            original = "קֶצֶף מִיקְרוֹ", translation = "микропенка",
            definition = "בּוּעוֹת זְעִירוֹת אֲחִידוֹת שֶׁנּוֹתְנוֹת מִרְקָם חֲלַק כְּמוֹ צֶבַע.",
            definitionNative = "Мелкие однородные пузырьки, дающие гладкую фактуру как у краски.",
            example = "בְּלִי קֶצֶף מִיקְרוֹ אִי אֶפְשָׁר לְצַיֵּר דְּגָמִים מְדֻיָּקִים.",
            exampleNative = "Без קֶצֶף מִיקְרוֹ нельзя нарисовать аккуратные узоры.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179608, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_latte_art", transliteration = "yetsika chofshit",
            original = "יְצִיקָה חוֹפְשִׁית", translation = "свободная заливка (без шаблона)",
            definition = "צִיּוּר שֶׁל דְּגַם בְּלִי תּוֹסֶפֶת — רַק תְּנוּעַת הַיָּד וְהַזֶּרֶם הַלָּבָן.",
            definitionNative = "Узор без добавок — только движение руки и струя белой массы.",
            example = "יְצִיקָה חוֹפְשִׁית מַרְאָה אֶת אֵיכוּת הָעֲבוֹדָה שֶׁל הַמְּכִין.",
            exampleNative = "יְצִיקָה חוֹפְשִׁית выдаёт уровень мастера сразу.",
         fillInBlankExclusions = listOf(179607L, 179609L, 179610L)),
        WordEntity(
            id = 179609, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_latte_art", transliteration = "etching",
            original = "אֶצְ׳ינְג", translation = "этчинг (дорисовка)",
            definition = "תּוֹסֶפֶת קַוִּים דַּקִּים בְּקֵיסָם דַּק עַל הַקֶּצֶף לְפֵרוּט שֶׁל הַתְּמוּנָה.",
            definitionNative = "Дорисовка тонких линий зубочисткой по пенке для уточнения картинки.",
            example = "אֶצְ׳ינְג עוֹזֵר לְהוֹסִיף פְּרָטִים קְטַנִּים אַחֲרֵי הַשְּׁפִיכָה.",
            exampleNative = "אֶצְ׳ינְג помогает добавить мелкие детали после заливки.",
         fillInBlankExclusions = listOf(179606L, 179608L)),
        WordEntity(
            id = 179610, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barista_latte_art", transliteration = "shichvot meshulavot",
            original = "שִׁכְבוֹת מְשׁוּלָבוֹת", translation = "комбинированный узор",
            definition = "הֶרְכֵּב שֶׁל כַּמָּה דְּגָמִים זֶה מֵעַל זֶה לִיצִירָה אַחַת מֻרְכֶּבֶת.",
            definitionNative = "Соединение нескольких рисунков один поверх другого в одну сложную композицию.",
            example = "שִׁכְבוֹת מְשׁוּלָבוֹת דּוֹרְשׁוֹת שֶׁקֶט וְיָד יַצִּיבָה לְגַמְרֵי.",
            exampleNative = "שִׁכְבוֹת מְשׁוּלָבוֹת требуют тишины и совершенно ровной руки.",
         fillInBlankExclusions = listOf(179607L, 179608L)),

        // ── barista_roasting (5) — обжарка: фазы, химия, профайлинг ──
        WordEntity(
            id = 179611, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_roasting", transliteration = "pitsuach rishon",
            original = "פִּצּוּחַ רִאשׁוֹן", translation = "первый крэк",
            definition = "רֶגַע נַקִּישָׁה רִאשׁוֹנָה בַּגַּרְעִין שֶׁמְּסַמֵּן יְצִיאָה לִדְרָגוֹת בְּהִירוֹת.",
            definitionNative = "Момент первого щелчка зерна, означающий выход на светлые степени обжарки.",
            example = "פִּצּוּחַ רִאשׁוֹן מַתְחִיל אֶת הַשְּׁלָב הַטָּעִים בַּתַּהֲלִיךְ.",
            exampleNative = "פִּצּוּחַ רִאשׁוֹן открывает самый вкусный отрезок процесса.",
         fillInBlankExclusions = listOf(179612L, 179613L, 179614L, 179615L)),
        WordEntity(
            id = 179612, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_roasting", transliteration = "zman pituach",
            original = "זְמַן פִּתּוּחַ", translation = "время развития",
            definition = "הַשֶּׁבַע אַחֲרֵי הַנַּקִּישָׁה הָרִאשׁוֹנָה שֶׁבּוֹ נִבְנֶה הַטַּעַם הַסּוֹפִי.",
            definitionNative = "Отрезок после первого щелчка, в котором достраивается итоговый вкус.",
            example = "זְמַן פִּתּוּחַ אָרֹךְ נוֹתֵן גּוּף עָבֶה וּמְתִיקוּת עֲמֻקָּה.",
            exampleNative = "Долгое זְמַן פִּתּוּחַ даёт густое тело и глубокую сладость.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179613, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barista_roasting", transliteration = "tguvat mayar",
            original = "תְּגוּבַת מַיָאר", translation = "реакция Майяра",
            definition = "תַּהֲלִיךְ כִּימִי שֶׁל סוּכָּרִים וְחֶלְבּוֹנִים — נוֹתֵן צֶבַע חוּם וְרֵיחַ קָלוּי.",
            definitionNative = "Химический процесс сахаров и белков — даёт коричневый цвет и жареный аромат.",
            example = "תְּגוּבַת מַיָאר שׁוֹלֶטֶת בָּאֲרוֹמוֹת שֶׁל קָלוּי וְקַרָמֶל.",
            exampleNative = "תְּגוּבַת מַיָאר царит в ароматах жжёного и карамели.",
         fillInBlankExclusions = listOf(179611L, 179612L, 179614L, 179615L)),
        WordEntity(
            id = 179614, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barista_roasting", transliteration = "shichrur gazim",
            original = "שִׁחְרוּר גַּזִּים", translation = "дегассинг",
            definition = "יְצִיאַת אַוִּיר מֵהַזֶּרַע בְּשָׁבוּעַ הָרִאשׁוֹן לִפְנֵי הַשִּׁמּוּשׁ הַטּוֹב.",
            definitionNative = "Выход воздуха из косточки в первую неделю до годного использования.",
            example = "אַחֲרֵי שִׁחְרוּר גַּזִּים הַטַּעַם נִפְתָּח וּמַתְמַתֵּק בָּאַף.",
            exampleNative = "После שִׁחְרוּר גַּזִּים вкус раскрывается и сластит в носу.",
         fillInBlankExclusions = listOf(179611L, 179612L, 179613L, 179615L)),
        WordEntity(
            id = 179615, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_roasting", transliteration = "perek yibush",
            original = "פֶּרֶק יִבּוּשׁ", translation = "фаза сушки (зерна)",
            definition = "פֶּרֶק רִאשׁוֹן בַּקַּלְיָה שֶׁבּוֹ יוֹצֵא הָרֹב שֶׁל הַלֶּחָה מֵהַזֶּרַע.",
            definitionNative = "Первый период обжарки, в котором уходит большая часть влаги из косточки.",
            example = "בְּפֶרֶק יִבּוּשׁ הַחֹם נִשְׁאָר נָמוּךְ וְהַזֶּרַע מַחֲלִיף צֶבַע.",
            exampleNative = "В פֶּרֶק יִבּוּשׁ жар держится низким, и зерно меняет цвет.",
            isFillInBlankSafe = false,
        ),

        // ── barista_brewing_advanced (5) — продвинутая заварка ──
        WordEntity(
            id = 179616, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_brewing_advanced", transliteration = "vi shishim",
            original = "וִי שִׁשִּׁים", translation = "V60 (воронка)",
            definition = "מַסְנֵן יָדָנִי בְּצוּרַת חֵרוּט עִם חֲרִיצִים שֶׁמְּכַוְּנִים אֶת זְרִימַת הַמַּיִם.",
            definitionNative = "Ручная воронка-конус с рёбрами, направляющими ход воды через слой засыпки.",
            example = "אֲנִי מְכִין וִי שִׁשִּׁים בְּכָל בֹּקֶר לִפְנֵי הָעֲבוֹדָה.",
            exampleNative = "Я готовлю וִי שִׁשִּׁים каждое утро перед сменой.",
         fillInBlankExclusions = listOf(179617L, 179618L, 179619L)),
        WordEntity(
            id = 179617, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_brewing_advanced", transliteration = "aeropress",
            original = "אֶרוֹפְּרֶס", translation = "аэропресс",
            definition = "מַכְשִׁיר נִשְׁלָף שֶׁל לַחַץ אֲוִיר יְדָנִי לְמָנָה אַחַת חֲזָקָה וּמְהִירָה.",
            definitionNative = "Ручной поршневой прибор с нажимом воздуха на одну быструю крепкую порцию.",
            example = "אֶרוֹפְּרֶס נוֹחַ מְאוֹד לְטִיסָה אוֹ לְטִיוּל בָּהָרִים.",
            exampleNative = "אֶרוֹפְּרֶס удобен для самолёта или похода в горы.",
         fillInBlankExclusions = listOf(179616L, 179618L, 179619L, 179620L)),
        WordEntity(
            id = 179618, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_brewing_advanced", transliteration = "kemeks",
            original = "קֶמֶקְס", translation = "кемекс",
            definition = "בַּקְבּוּק זְכוּכִית עִם צַוָּאר וְעוֹר מֻדְבָּק לְכוֹס סִינוּן אִיטִית וְצְלוּלָה.",
            definitionNative = "Стеклянный сосуд с горлом и кожаной стяжкой для медленной чистой фильтрации.",
            example = "קֶמֶקְס שָׁבוּר אוֹסֵף אֶצְלִי אָבָק בַּמַּדָּף מֵאָז הַמַּעֲבָר.",
            exampleNative = "Сломанный קֶמֶקְס пылится у меня на полке после переезда.",
         fillInBlankExclusions = listOf(179616L, 179617L, 179619L, 179620L)),
        WordEntity(
            id = 179619, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_brewing_advanced", transliteration = "pur-over",
            original = "פּוּר־אוֹבֶר", translation = "пуровер",
            definition = "שִׁיטָה אִיטִית שֶׁל שְׁפִיכַת מַיִם בְּיָד עַל אָבָק בְּמַסְנֵן נְיָר.",
            definitionNative = "Медленный способ ручного пролива воды по засыпке через бумажный фильтр.",
            example = "פּוּר־אוֹבֶר מַרְגִּישׁ כְּמוֹ טֶקֶס שָׁקֵט שֶׁל סוֹף הַשָּׁבוּעַ.",
            exampleNative = "פּוּר־אוֹבֶר ощущается как тихий ритуал выходного дня.",
         fillInBlankExclusions = listOf(179616L, 179617L, 179618L)),
        WordEntity(
            id = 179620, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_brewing_advanced", transliteration = "harvayat batsek",
            original = "הַרְוָיַת בָּצֵק", translation = "блум (первое смачивание)",
            definition = "שֶׁפֶךְ קָטָן רִאשׁוֹן שֶׁמַּפְרִישׁ אַוִּיר מֵהַטַּחֲנָה לִפְנֵי הַשֶּׁפֶךְ הָעִקָּרִי.",
            definitionNative = "Маленькая первая струя — выпускает воздух из помола до главного пролива.",
            example = "הַרְוָיַת בָּצֵק חֲזָקָה — סִימָן שֶׁהַזֶּרַע טָרִי לְגַמְרֵי.",
            exampleNative = "Сильная הַרְוָיַת בָּצֵק — знак свежести зерна.",
         fillInBlankExclusions = listOf(179617L, 179618L)),

        // ── barista_competition (5) — чемпионаты, оценка, авторские подачи ──
        WordEntity(
            id = 179621, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_competition", transliteration = "alifut barista",
            original = "אֲלִיפוּת בָּרִיסְטָה", translation = "чемпионат бариста",
            definition = "אֵרוּעַ אַרְצִי אוֹ עוֹלָמִי שֶׁבּוֹ מִקְצוֹעָנִים נִלְחָמִים עַל הַתֹּאַר.",
            definitionNative = "Национальное или мировое событие, где специалисты борются за лидерский титул.",
            example = "אֲלִיפוּת בָּרִיסְטָה הַשְּׁנָתִית תִּתְקַיֵּם בְּתֵל אָבִיב הַשָּׁנָה.",
            exampleNative = "אֲלִיפוּת בָּרִיסְטָה этого года пройдёт в Тель-Авиве.",
         fillInBlankExclusions = listOf(179622L, 179623L, 179624L)),
        WordEntity(
            id = 179622, setId = 1796, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_competition", transliteration = "amadat hatsaga",
            original = "עֲמָדַת הַצָּגָה", translation = "демо-станция",
            definition = "שֻׁלְחָן עֲבוֹדָה רִשְׁמִי שֶׁבּוֹ הַמִּתְמוֹדֵד מַכִין מָנוֹת לִפְנֵי הַקָּהָל.",
            definitionNative = "Официальный рабочий стол, на котором участник готовит порции перед публикой.",
            example = "עַל עֲמָדַת הַצָּגָה יֵשׁ שָׁעוֹן עוֹצֵר וּשְׁלוֹשָׁה כֵּלִים זְהָבִים.",
            exampleNative = "На עֲמָדַת הַצָּגָה лежат секундомер и три золотых сосуда.",
         fillInBlankExclusions = listOf(179621L, 179623L, 179624L)),
        WordEntity(
            id = 179623, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barista_competition", transliteration = "gilayon shiput",
            original = "גִּלָּיוֹן שִׁפּוּט", translation = "судейский лист",
            definition = "דַּף רִשְׁמִי שֶׁבּוֹ הַשּׁוֹפֵט מְצַיֵּן צִיּוּן לְכָל פָּרָט שֶׁל הַמָּנָה.",
            definitionNative = "Официальный бланк, где судья выставляет балл за каждую деталь подачи.",
            example = "גִּלָּיוֹן שִׁפּוּט מָלֵא מַחֲזִיר אוֹתִי לְעֻבְדּוֹת קַרְקַע מְדֻיָּקוֹת.",
            exampleNative = "Полный גִּלָּיוֹן שִׁפּוּט возвращает к точным фактам подачи.",
         fillInBlankExclusions = listOf(179621L, 179622L, 179624L)),
        WordEntity(
            id = 179624, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barista_competition", transliteration = "gvia hatoea",
            original = "גְּבִיעַ הַטּוֹעֵם", translation = "кубок дегустатора",
            definition = "תַּחֲרוּת זִהוּי זַנִּים בְּעִיווְרוֹן בִּזְמַן קָצוּב מוּל שָׁעוֹן עוֹצֵר.",
            definitionNative = "Состязание на угадывание сорта вслепую за фиксированное время на секундомер.",
            example = "גְּבִיעַ הַטּוֹעֵם דּוֹרֵשׁ אַף עֲדִין וְזִכָּרוֹן חַד מְאוֹד.",
            exampleNative = "גְּבִיעַ הַטּוֹעֵם требует тонкого носа и острой памяти.",
         fillInBlankExclusions = listOf(179621L, 179622L, 179623L)),
        WordEntity(
            id = 179625, setId = 1796, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barista_competition", transliteration = "signatura",
            original = "סִיגְנָטוּרָה", translation = "сигнатур (авторский напиток)",
            definition = "מַשְׁקֶה אִישִׁי שֶׁל הַמִּתְמוֹדֵד עִם תּוֹסְפוֹת שֶׁל פֵּרוֹת אוֹ תַּבְלִינִים.",
            definitionNative = "Авторская подача участника с добавками из ягод, фруктов или специй.",
            example = "הַסִּיגְנָטוּרָה שֶׁלִּי כּוֹלֶלֶת בָּזִיל קָר וּטְלוֹאָת לִימוֹן.",
            exampleNative = "הַסִּיגְנָטוּרָה моя содержит холодный базилик и лимонную капельку.",
            isFillInBlankSafe = false,
        ),
    )
}
