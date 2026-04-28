package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Внешность и тело", level 5 (носитель / Танах + поэтика).
 * Один сет × 25 слов. setId = 1826.
 *
 *  - 18 LEGENDARY + 7 EPIC (2 смежных уровня — C1/C2+).
 *  - 5 семантических групп по 5 слов:
 *      appearance_l5_biblical          — Танахические образы тела
 *                                        (зрачок-«איש העין», чресла, бедра-ירך,
 *                                        нутро-קרב, плечо-שכם)
 *      appearance_l5_poetic_face       — поэтика лица (литературный нос-חוטם,
 *                                        ланита-לחי, облик-מראה, благообразие-תאר,
 *                                        сияние-זיו פנים)
 *      appearance_l5_archaic_body      — архаика тела (стан-גו, портрет-דיוקן,
 *                                        хребет-שדרה, длани-כפות ידים, утроба-רחם)
 *      appearance_l5_aesthetic_advanced — высокая эстетика (грация-חן, благолепие-הדר,
 *                                        величие-הוד, красота-יפי, изящество-עדינות)
 *      appearance_l5_descriptive_high  — литературные описания (благородный-אצילי,
 *                                        царственный-מלכותי, величавый-נהדר,
 *                                        сгорбленный-שחוח, изможденный-מרוט)
 *  - Никудим везде. fillInBlankExclusions / isFillInBlankSafe не выставлены —
 *    заполнятся через FILL_IN_BLANK pipeline (см. `docs/claude/fill-in-blank-pipeline.md`).
 *  - Параллельный сет en-ru — 384 «Внешность и тело» (level 5, литературные эпитеты:
 *    mien, countenance, alabaster, saturnine, willowy и т.д.). В he-ru подобраны
 *    эквиваленты Танахического и литературного регистра.
 *  - Дублей с set 1822 (L1), 1823 (L2), 1824 (L3) нет — проверены 75 слов.
 *  - Параллельный L4 (1825) ориентирован на EPIC+RARE — анатомия специалистов,
 *    бьюти-индустрия. L5 умышленно отстраивается в сторону Танаха и литературы.
 *  - Cross-topic совпадения (допустимо политикой дублей — разные topic'и):
 *      - בָּשָׂר занят в Everyday как «мясо» — здесь не используется (взамен חלצים/קרב/ירך).
 *      - חָזֶה занято в Medicine как «грудь» — здесь не используется.
 *      - שָׂפָה занято в Linguistics/Medicine — здесь не используется.
 *      - רַעֲנָן занято в Weather (свежий) — здесь не используется.
 *      - גָּבוֹהַּ/יָפֶה базовые — здесь не используются (взяты אצילי/מלכותי/נהדר).
 *      - דְּמוּת занято в Immigrant как «образ персонажа» — взамен דְּיוֹקָן (портрет/лик).
 */
object WordDataHebrewAppearanceL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1826, languagePair = "he-ru", orderIndex = 1826,
            name = "Внешность и тело",
            description = "Танахические образы тела, поэтика и архаика внешности",
            topic = "Внешность и тело", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── appearance_l5_biblical (5) — Танахические образы тела ────────
        WordEntity(
            id = 182601, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "appearance_l5_biblical",
            original = "אִישׁוֹן הָעַיִן", translation = "зрачок (зеница ока)",
            transliteration = "ишон hа-айин",
            definition = "הַנְּקֻדָּה הַשְּׁחֹרָה בְּמֶרְכַּז הָעַיִן — בִּלְשׁוֹן הַמִּקְרָא דָּבָר יָקָר וְשָׁמוּר.",
            definitionNative = "Чёрная точка в центре глаза — на языке Писания символ самого дорогого и хранимого.",
            example = "הַנָּבִיא אָמַר שֶׁהַצַּדִּיק שָׁמוּר כְּאִישׁוֹן הָעַיִן שֶׁל הָאֵל.",
            exampleNative = "Пророк сказал: праведник хранится как אִישׁוֹן הָעַיִן у Творца.",
        ),
        WordEntity(
            id = 182602, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_biblical",
            original = "חֲלָצַיִם", translation = "чресла, поясница",
            transliteration = "халацаим",
            definition = "אֵזוֹר הַמָּתְנַיִם וְהָאֲגָן בִּלְשׁוֹן הַמִּקְרָא — מָקוֹם שֶׁל כֹּחַ וְשׁוֹשֶׁלֶת.",
            definitionNative = "Область поясницы и таза в библейском слоге — место силы и продолжения рода.",
            example = "בָּרֲכוּ אֶת הַזָּקֵן וְאָמְרוּ שֶׁיּוֹצְאֵי חֲלָצָיו יִרְבּוּ.",
            exampleNative = "Старца благословили — да умножатся вышедшие из его חֲלָצַיִם.",
        ),
        WordEntity(
            id = 182603, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_biblical",
            original = "יָרֵךְ", translation = "бедро (библ.)",
            transliteration = "ярэх",
            definition = "הַחֵלֶק הָעֶלְיוֹן שֶׁל הָרֶגֶל בִּלְשׁוֹן הַמִּקְרָא — סֶמֶל לִשְׁבוּעָה וּלְמוֹצָא.",
            definitionNative = "Верхняя часть ноги в языке Танаха — символ клятвы и происхождения.",
            example = "הָעֶבֶד שָׂם אֶת יָדוֹ תַּחַת יֶרֶךְ אֲדוֹנָיו וְנִשְׁבַּע אֱמוּנִים.",
            exampleNative = "Раб положил руку под יָרֵךְ господина и поклялся в верности.",
        ),
        WordEntity(
            id = 182604, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_biblical",
            original = "קֶרֶב", translation = "нутро, недра тела",
            transliteration = "кэрэв",
            definition = "פְּנִים הַגּוּף בִּלְשׁוֹן הַמִּקְרָא — מָקוֹם שֶׁל רֶגֶשׁ פְּנִימִי וְלֵב.",
            definitionNative = "Внутренность тела на библейском языке — обиталище глубоких чувств и сердца.",
            example = "הַמְּשׁוֹרֵר זָעַק שֶׁרוּחוֹ נִשְׁבְּרָה בְּקֶרֶב לִבּוֹ.",
            exampleNative = "Поэт возопил, что дух его сокрушился в קֶרֶב сердца.",
         fillInBlankExclusions = listOf(182602L, 182603L, 182605L)),
        WordEntity(
            id = 182605, setId = 1826, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_l5_biblical",
            original = "שֶׁכֶם", translation = "плечо (библ.)",
            transliteration = "шэхэм",
            definition = "הָאֵזוֹר שֶׁבֵּין הַצַּוָּאר וְהַזְּרוֹעַ בִּלְשׁוֹן הַמִּקְרָא — סֶמֶל שֶׁל נְשִׂיאָה בְּעוֹל.",
            definitionNative = "Область между шеей и рукой в библейском слоге — символ ноши и ответственности.",
            example = "הוּא נָשָׂא אֶת הַסַּל עַל שֶׁכֶם אֶחָד כָּל הַדֶּרֶךְ עַד הַבְּאֵר.",
            exampleNative = "Он нёс корзину на одном שֶׁכֶם всю дорогу до колодца.",
         fillInBlankExclusions = listOf(182602L, 182603L, 182604L)),

        // ─── appearance_l5_poetic_face (5) — поэтика лица ─────────────────
        WordEntity(
            id = 182606, setId = 1826, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_l5_poetic_face",
            original = "חוֹטֶם", translation = "нос (литер.)",
            transliteration = "хотэм",
            definition = "מִלָּה סִפְרוּתִית גְּבוֹהָה לָאַף — נְפוֹצָה בִּשְׁפַת שִׁירָה וּפְרוֹזָה יָשָׁן.",
            definitionNative = "Литературное возвышенное слово для носа — встречается в стихах и старой прозе.",
            example = "הַמְּשׁוֹרֵר תֵּאֵר אֶת חוֹטְמָהּ הָעֲדִין שֶׁל הַגְּבִירָה הַזְּקֵנָה.",
            exampleNative = "Поэт описал тонкий חוֹטֶם пожилой госпожи.",
        ),
        WordEntity(
            id = 182607, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_poetic_face",
            original = "לֶחִי", translation = "ланита (поэт.)",
            transliteration = "лэхи",
            definition = "הַחֵלֶק הַצְּדָדִי שֶׁל הַפָּנִים בְּלָשׁוֹן שִׁירִית — בְּעִקָּר עַל אִשָּׁה צְעִירָה.",
            definitionNative = "Боковая часть лица в поэтическом слоге — обычно о юной деве.",
            example = "דִּמְעָה שְׁקוּפָה זָלְגָה עַל לֶחְיָהּ הַחִוֶּרֶת בִּדְמָמָה.",
            exampleNative = "Прозрачная слеза скатилась по бледной לֶחִי её в полной тишине.",
        ),
        WordEntity(
            id = 182608, setId = 1826, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_l5_poetic_face",
            original = "מַרְאֶה", translation = "облик, наружность",
            transliteration = "маръэ",
            definition = "הַצּוּרָה הַחִיצוֹנִית שֶׁל אָדָם בְּלָשׁוֹן גְּבוֹהָה — אֵיךְ הוּא נִרְאֶה לָעֵינַיִם.",
            definitionNative = "Внешний вид человека в высоком слоге — то, как он являет себя взгляду.",
            example = "הָיָה לוֹ מַרְאֶה אֲצִילִי שֶׁהִזְכִּיר נְסִיכֵי דּוֹרוֹת קוֹדְמִים.",
            exampleNative = "У него был благородный מַרְאֶה — напоминал князей былых веков.",
         fillInBlankExclusions = listOf(182606L, 182607L, 182609L, 182610L, 182611L, 182612L, 182616L, 182617L, 182618L, 182619L)),
        WordEntity(
            id = 182609, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_poetic_face",
            original = "תֹּאַר", translation = "благообразие, стать",
            transliteration = "тоар",
            definition = "צוּרָה יָפָה וְנֶהְדֶּרֶת שֶׁל פָּנִים אוֹ גּוּף — לְשׁוֹן מִקְרָאִית גְּבוֹהָה.",
            definitionNative = "Прекрасная и величавая форма лица или тела — высокий библейский слог.",
            example = "הַסּוֹפֵר כָּתַב שֶׁלַּצְּעִירָה הָיָה תֹּאַר נָדִיר וִיפַת מַרְאֶה.",
            exampleNative = "Писатель отметил: у девушки был редкий תֹּאַר и прекрасный облик.",
         fillInBlankExclusions = listOf(182606L, 182607L, 182610L, 182616L, 182617L, 182618L, 182619L, 182620L)),
        WordEntity(
            id = 182610, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "appearance_l5_poetic_face",
            original = "זִיו פָּנִים", translation = "сияние лица",
            transliteration = "зив паним",
            definition = "אוֹר פְּנִימִי שֶׁמּוֹפִיעַ עַל פְּנֵי אָדָם מֵרֹב שִׂמְחָה אוֹ קְדֻשָּׁה.",
            definitionNative = "Внутренний свет, что проявляется на лице человека от великой радости или святости.",
            example = "כְּשֶׁיָּצָא הַחָתָן מֵהַחֻפָּה הָיָה לוֹ זִיו פָּנִים מְיֻחָד.",
            exampleNative = "Когда жених вышел из-под хупы, у него был особый זִיו פָּנִים.",
         fillInBlankExclusions = listOf(182608L, 182609L, 182612L, 182616L, 182617L, 182618L, 182619L)),

        // ─── appearance_l5_archaic_body (5) — архаика тела и образа ───────
        WordEntity(
            id = 182611, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_archaic_body",
            original = "גֵּו", translation = "стан, торс (поэт.)",
            transliteration = "гэв",
            definition = "פֶּלֶג גּוּף עֶלְיוֹן בְּלָשׁוֹן שִׁירִית — חֵלֶק שֶׁבֵּין הַצַּוָּאר וְהַמָּתְנַיִם.",
            definitionNative = "Верхняя часть тела в поэтическом слоге — между шеей и поясницей.",
            example = "הַחַיָּל הַזָּקֵן זָקַף אֶת גֵּוו בְּגַאֲוָה לִפְנֵי הַטֶּקֶס.",
            exampleNative = "Старый воин гордо выпрямил גֵּו перед началом церемонии.",
        ),
        WordEntity(
            id = 182612, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_archaic_body",
            original = "דְּיוֹקָן", translation = "лик, портретный образ",
            transliteration = "дйокан",
            definition = "צוּרַת פְּנֵי אָדָם כְּפִי שֶׁהִיא מְצֻיֶּרֶת אוֹ נִזְכֶּרֶת — לְשׁוֹן סִפְרוּתִית.",
            definitionNative = "Лицо человека, каким оно запечатлено или вспоминается — литературное слово.",
            example = "הַצַּיָּר הִשְׁאִיר אַחֲרָיו דְּיוֹקָן מַרְשִׁים שֶׁל אִמּוֹ הַזְּקֵנָה.",
            exampleNative = "Художник оставил после себя впечатляющий דְּיוֹקָן своей старой матери.",
         fillInBlankExclusions = listOf(182608L, 182609L, 182610L, 182611L, 182613L, 182615L, 182616L, 182617L, 182618L, 182619L)),
        WordEntity(
            id = 182613, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_archaic_body",
            original = "שִׁדְרָה", translation = "хребет, костяк (поэт.)",
            transliteration = "шидра",
            definition = "עַמּוּד הַחֻלְיוֹת בִּלְשׁוֹן גְּבוֹהָה — סֶמֶל לְכֹחַ פְּנִימִי וִיצִיבוּת אִישִׁית.",
            definitionNative = "Позвоночный столб в высоком слоге — символ внутренней крепости и стойкости духа.",
            example = "הַמַּנְהִיג עָמַד מוּל הָאוֹיֵב עִם שִׁדְרָה זְקוּפָה וּמַבָּט בּוֹטֵחַ.",
            exampleNative = "Вождь стоял пред врагом с прямой שִׁדְרָה и уверенным взором.",
         fillInBlankExclusions = listOf(182611L, 182612L, 182615L)),
        WordEntity(
            id = 182614, setId = 1826, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "appearance_l5_archaic_body",
            original = "כַּפּוֹת יָדַיִם", translation = "длани, ладони",
            transliteration = "капот ядаим",
            definition = "פַּסֵּי הַיָּד הַפְּנִימִיִּים בְּלָשׁוֹן גְּבוֹהָה — בָּהֶם נוֹשְׂאִים אוֹ פּוֹשְׁטִים בִּתְפִלָּה.",
            definitionNative = "Внутренние плоскости рук в высоком слоге — их простирают в молитве или подношении.",
            example = "הַזָּקֵן פָּשַׁט אֶת כַּפּוֹת יָדָיו לַשָּׁמַיִם בְּתַחֲנוּן חֲרִישִׁי.",
            exampleNative = "Старец воздел כַּפּוֹת יָדַיִם к небу в тихой мольбе.",
        ),
        WordEntity(
            id = 182615, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_archaic_body",
            original = "רֶחֶם", translation = "утроба (библ.)",
            transliteration = "рэхэм",
            definition = "אֵיבָר פְּנִימִי שֶׁל הָאִשָּׁה בִּלְשׁוֹן הַמִּקְרָא — מָקוֹם הַהֵרָיוֹן וְסֶמֶל שֶׁל רַחֲמִים.",
            definitionNative = "Внутренний орган женщины в библейском слоге — место зачатия и символ милосердия.",
            example = "הַכָּתוּב מְלַמֵּד שֶׁהָאֵל זָכַר אֶת חַנָּה וּפָתַח אֶת רַחְמָהּ.",
            exampleNative = "Писание учит: Господь вспомнил Хану и отверз её רֶחֶם.",
        ),

        // ─── appearance_l5_aesthetic_advanced (5) — высокая эстетика ──────
        WordEntity(
            id = 182616, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_aesthetic_advanced",
            original = "חֵן", translation = "грация, прелесть",
            transliteration = "хэн",
            definition = "אֵיכוּת חִיצוֹנִית שֶׁמּוֹשֶׁכֶת אֶת הַלֵּב — יֹפִי עָדִין שֶׁאֵינוֹ נִתָּן לְהַסְבָּרָה.",
            definitionNative = "Внешнее качество, что притягивает сердце — нежная красота, которой не подобрать словам.",
            example = "הָיָה בָּהּ חֵן רַב שֶׁשָּׁבָה אֲפִלּוּ אֶת לֵב הַזָּרִים.",
            exampleNative = "Был в ней редкий חֵן — он покорял даже сердца чужестранцев.",
         fillInBlankExclusions = listOf(182609L, 182610L, 182617L, 182618L, 182619L, 182620L)),
        WordEntity(
            id = 182617, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_aesthetic_advanced",
            original = "הָדָר", translation = "благолепие, великолепие",
            transliteration = "hадар",
            definition = "יֹפִי מְפֹאָר וְכָבוֹד חִיצוֹנִי — נֶחֱזֶה בְּמַרְאֵה אִישׁ אוֹ בִּגְלִימָתוֹ.",
            definitionNative = "Пышная красота и внешнее достоинство — видны в облике человека или в его одеянии.",
            example = "הַכֹּהֵן הַגָּדוֹל לָבַשׁ אֶת בִּגְדֵי הַהָדָר לִקְרַאת הֶחָג.",
            exampleNative = "Первосвященник облачился в одеяния הָדָר пред наступлением праздника.",
         fillInBlankExclusions = listOf(182616L, 182618L, 182619L, 182620L)),
        WordEntity(
            id = 182618, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "appearance_l5_aesthetic_advanced",
            original = "הוֹד", translation = "величие, величавость",
            transliteration = "hод",
            definition = "זֹהַר פְּנִימִי שֶׁמְּקַרְצֵף עַל פְּנֵי אָדָם וּמַרְאֵהוּ — לְשׁוֹן מִקְרָאִית.",
            definitionNative = "Внутреннее сияние, что озаряет лицо и весь облик человека — слог Танаха.",
            example = "הַמֶּלֶךְ הַזָּקֵן יָשַׁב עַל כִּסְאוֹ בְּהוֹד וּבְשַׁלְוָה.",
            exampleNative = "Старый царь восседал на престоле в הוֹד и безмятежности.",
         fillInBlankExclusions = listOf(182616L, 182617L, 182619L, 182620L)),
        WordEntity(
            id = 182619, setId = 1826, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_l5_aesthetic_advanced",
            original = "יֹפִי", translation = "красота (литер.)",
            transliteration = "йофи",
            definition = "אֵיכוּת שֶׁמַּעֲנִיקָה הֲנָאָה לָעַיִן — בְּלָשׁוֹן סִפְרוּתִית גְּבוֹהָה.",
            definitionNative = "Качество, что доставляет наслаждение взгляду — в высоком литературном слоге.",
            example = "הַצַּיָּר חִפֵּשׂ אֶת הַיֹּפִי הַטָּהוֹר שֶׁל הָאוֹר עַל הַיָּם.",
            exampleNative = "Художник искал чистый יֹפִי света на поверхности моря.",
        ),
        WordEntity(
            id = 182620, setId = 1826, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_l5_aesthetic_advanced",
            original = "עֲדִינוּת", translation = "изящество, утончённость",
            transliteration = "адинут",
            definition = "תְּכוּנָה שֶׁל רַכּוּת וְעִדּוּן — מוּרְגֶּשֶׁת בִּתְנוּעוֹת, בְּהַבָּעָה וּבִקְוֵי הַגּוּף.",
            definitionNative = "Качество мягкости и тонкости — слышится в движениях, выражении и линиях тела.",
            example = "הָרַקְדָּנִית נָעָה בָּעֲדִינוּת שֶׁל פֶּרַח שֶׁמִּתְפַּתֵּחַ בָּאוֹר.",
            exampleNative = "Танцовщица двигалась с עֲדִינוּת — словно цветок, раскрывающийся на свету.",
         fillInBlankExclusions = listOf(182616L, 182617L, 182618L, 182619L)),

        // ─── appearance_l5_descriptive_high (5) — литер. описания ─────────
        WordEntity(
            id = 182621, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "appearance_l5_descriptive_high",
            original = "אֲצִילִי", translation = "благородный (на вид)",
            transliteration = "ацили",
            definition = "בַּעַל מַרְאֶה מְכֻבָּד וְעָדִין — מַזְכִּיר אֲנָשִׁים מִמַּעֲמָד גָּבוֹהַּ.",
            definitionNative = "С почтенным и тонким обликом — напоминает людей высокого сословия.",
            example = "לַזָּקֵן הָיָה פַּרְצוּף אֲצִילִי וְשֵׂיבָה לְבָנָה כַּשֶּׁלֶג.",
            exampleNative = "У старца был אֲצִילִי лик и седина, белая как снег.",
         fillInBlankExclusions = listOf(182622L, 182623L, 182624L, 182625L)),
        WordEntity(
            id = 182622, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "appearance_l5_descriptive_high",
            original = "מַלְכוּתִי", translation = "царственный",
            transliteration = "мальхути",
            definition = "בַּעַל מַרְאֶה גָּדוֹל וְכָבוֹד — כְּמוֹ שֶׁל מֶלֶךְ אוֹ מַלְכָּה בְּהוֹפָעָה רִשְׁמִית.",
            definitionNative = "С обликом торжественным и величественным — как у царя или царицы на парадном выходе.",
            example = "הִיא נִכְנְסָה לָאוּלָם בִּצְעָדִים מַלְכוּתִיִּים וּבִשְׁמָלָה אֲרֻכָּה.",
            exampleNative = "Она вошла в зал מַלְכוּתִי шагом и в длинном платье.",
         fillInBlankExclusions = listOf(182621L, 182623L, 182624L, 182625L)),
        WordEntity(
            id = 182623, setId = 1826, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "appearance_l5_descriptive_high",
            original = "נֶהְדָּר", translation = "величавый, статный",
            transliteration = "нэhдар",
            definition = "בַּעַל מַרְאֶה מַרְשִׁים וִיפֵה — מוֹשֵׁךְ אֶת הָעַיִן בְּגֹדֶל וּבְכָבוֹד.",
            definitionNative = "С впечатляющим и красивым обликом — притягивает взгляд величием и достоинством.",
            example = "עַל הַבָּמָה עָמַד גֶּבֶר נֶהְדָּר בִּמְעִיל פַּרְוָה אָרֹךְ.",
            exampleNative = "На сцене стоял נֶהְדָּר мужчина в длинном меховом плаще.",
         fillInBlankExclusions = listOf(182621L, 182622L, 182624L, 182625L)),
        WordEntity(
            id = 182624, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "appearance_l5_descriptive_high",
            original = "שָׁחוּחַ", translation = "сгорбленный, поникший",
            transliteration = "шахуах",
            definition = "כָּפוּף קָדִימָה מֵרֹב צַעַר אוֹ מִשָּׁנִים — לְשׁוֹן סִפְרוּתִית גְּבוֹהָה.",
            definitionNative = "Согнутый вперёд от тяжести скорби или прожитых лет — высокий литературный слог.",
            example = "הָאַלְמָנָה הַזְּקֵנָה הָלְכָה שָׁחוּחָה לְבֵית הַקְּבָרוֹת בַּגֶּשֶׁם.",
            exampleNative = "Старая вдова шла שָׁחוּחָה к кладбищу под дождём.",
        ),
        WordEntity(
            id = 182625, setId = 1826, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "appearance_l5_descriptive_high",
            original = "מָרוּט", translation = "изможденный, измождённый",
            transliteration = "марут",
            definition = "מְעַט שֵׂעָר וּפָנִים שְׁדוּפוֹת — לְאַחַר מַחֲלָה אֲרֻכָּה אוֹ סֵבֶל מִתְמַשֵּׁךְ.",
            definitionNative = "Поредевшие волосы и иссушенное лицо — после долгой болезни или непрерывных страданий.",
            example = "הוּא חָזַר מֵהַחֲזִית מָרוּט וְכָחוּשׁ אֲבָל בְּחַיִּים.",
            exampleNative = "Он вернулся с фронта מָרוּט и измождённый, но живой.",
         fillInBlankExclusions = listOf(182621L, 182622L, 182623L, 182624L)),
    )
}
