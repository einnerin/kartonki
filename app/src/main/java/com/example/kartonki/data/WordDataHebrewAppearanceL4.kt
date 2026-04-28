package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Внешность и тело", L4 «Профессиональный»
 * (EPIC + RARE).
 *
 * Set 1825: «Внешность и тело» — профессиональный L4:
 *           Косметология, эстетическая медицина, типология телосложения,
 *           тонкая анатомия лица и опорно-двигательной системы, состояния
 *           кожи. Регистр — beauty industry + базовая дерматология.
 *
 * Целевая аудитория — русскоязычные репатрианты, работающие в косметологии,
 * эстетической медицине, фитнесе, либо просто разбирающиеся со своей
 * внешностью на профессиональном уровне (визиты к косметологу, дерматологу,
 * пластическому хирургу).
 *
 * Параллельные сеты той же темы:
 *   - 1822 (L1): רֹאשׁ, יָד, רֶגֶל, גּוּף, בֶּטֶן, אַף, פֶּה, אֹזֶן, שֵׁן,
 *     מֶצַח, אֶצְבַּע, כָּתֵף, גַּב, בֶּרֶךְ, מַרְפֵּק, צָעִיר, זָקֵן, תִּינוֹק,
 *     נַעַר, מְבֻגָּר, אָרֹךְ, קָצָר, חִיּוּךְ, צַוָּאר, סַנְטֵר.
 *   - 1823 (L2): קוּקוּ, פוֹנִי, בַּלּוֹרִית, רַעְמָה, קַרַחַת, הַעֲוָיָה,
 *     גִּיחוּךְ, זְעָפָה, מִצְמוּץ, מַבָּט, חָסוֹן, מוּצָק, תְּפוּחַ, כָּחוּשׁ,
 *     חוֹלָנִי, גּוּמָה, רַקָּה, עֹרֶף, סֹמֶק, עֶצֶם הַלֶּחִי, קַעְקַע, פִּירְסִינְג,
 *     שֻׁמָּה, כֶּתֶם לֵדָה, נֶמֶשׁ.
 *   - 1824 (L3): שֹׁרֶשׁ הַשֵּׂעָר, תְּנוּךְ, עַפְעַף, נְחִיר, גַּבָּה,
 *     עֶצֶם הַבְּרִיחַ, פֶּרֶק הָאֶצְבַּע, חֻלְיָה, לֶסֶת, שְׁרִיר דּוּ-רָאשִׁי,
 *     שָׁעוֹן חוֹל, אַתְלֵטִי, זְעִירָה, תָּמִיר, חֲטוּבָה, מְנֻמָּשׁ, פִּצְעוֹנִים,
 *     שָׁזוּף, זֵיתִי, סְמוּק, מְטֻפָּח, פָּרוּעַ, מְסֻדָּר, מֻזְנָח, הָדוּר.
 *
 * L4-фокус (профессиональный, бьюти-медицинский):
 *   профессиональная анатомия (хрящ, сухожилие, диафрагма, надкостница,
 *   связка), продвинутые черты лица (носогубная складка, межбровная зона,
 *   нижнее веко, височная область, подглазничный круг), пропорции и
 *   соматотипы (эктоморф/мезоморф/эндоморф, обхват талии, симметрия),
 *   текстуры и состояния кожи (упругая/дряблая/чувствительная/обезвоженная/
 *   гиперпигментация), продвинутая ухоженность (нюдовый макияж, маникюр,
 *   броу-арт, лоск, лифтинг).
 *
 * Распределение редкостей: 17 EPIC + 8 RARE — два смежных уровня C1/B2,
 * EPIC доминирует. RARE — слова более широко известные русскоязычному
 * пользователю (хрящ, сухожилие, мезоморф, обхват талии, упругая,
 * чувствительная, маникюр, нюдовый макияж); EPIC — узкоспециальные
 * термины косметологии и анатомии (надкостница, связка, диафрагма,
 * носогубная складка, обезвоженная, гиперпигментация, лифтинг).
 *
 * SemanticGroups (5 × 5):
 *   appearance_anatomy_pro       — סְחוּס (хрящ), גִּיד (сухожилие),
 *                                   סַרְעֶפֶת (диафрагма), קְרוּם הָעֶצֶם
 *                                   (надкостница), נְצָב (связка)
 *   appearance_face_advanced     — קֶמֶט נָזוֹ-לָבְּיָאלִי (носогубная складка),
 *                                   בֵּין הַגַּבּוֹת (межбровье), עַפְעַף תַּחְתּוֹן
 *                                   (нижнее веко), אֵזוֹר רַקָּתִי (височная зона),
 *                                   עִגּוּל תַּת-עֵינִי (подглазничный круг)
 *   appearance_body_proportions  — אֵקְטוֹמוֹרְף (эктоморф), מֵזוֹמוֹרְף
 *                                   (мезоморф), אֵנְדוֹמוֹרְף (эндоморф),
 *                                   הֶיקֵּף מָתְנַיִם (обхват талии),
 *                                   סִימֶטְרְיַת פָּנִים (симметрия лица)
 *   appearance_skin_textures     — אֵלַסְטִית (упругая), רוֹפֶפֶת (дряблая),
 *                                   רְגִישָׁה (чувствительная), מְיֻבֶּשֶׁת
 *                                   (обезвоженная), הִיפֶּרְפִּיגְמֶנְטַצְיָה
 *                                   (гиперпигментация)
 *   appearance_grooming_advanced — אִיפּוּר טִבְעִי (нюдовый макияж),
 *                                   מָנִיקוּר (маникюр), עִצּוּב גַּבּוֹת
 *                                   (броу-арт), הַבְרָקָה (лоск),
 *                                   מְתִיחַת פָּנִים (лифтинг)
 *
 * Word IDs: setId × 100 + position (182501..182525).
 *
 * Пересечения с другими наборами:
 *   - HealthFitnessL1L2L3 содержит גִּיד (сухожилие), פַסְצְיָה (фасция),
 *     אֲחוּז שֻׁמָּן (процент жира), הֶקֵּף מָתְנַיִם (обхват талии). Тема
 *     «Здоровье и фитнес» отлична от «Внешность и тело» — пересечение по
 *     паре единиц допустимо политикой дублей (см.
 *     docs/claude/feedback_duplicate_words_policy.md). Здесь использовано
 *     הֶיקֵּף מָתְנַיִם (вариант написания через קֵף), без хей-определения,
 *     ради акцента на пропорции, а не на фитнес-метрику.
 *   - BarberL1L2L3 — про парикмахерское дело (волосы, окрашивание).
 *     Пересечений по original нет.
 *   - MedicineV2 (1601-1606) — медицина в общем (части тела, болезни).
 *     Пересечений с этим сетом нет.
 *
 * isFillInBlankSafe / fillInBlankExclusions — не задаём; FILL_IN_BLANK
 * pipeline (см. `docs/claude/fill-in-blank-pipeline.md`) заполнит
 * exclusion-списки автоматически после прохода LLM.
 */
object WordDataHebrewAppearanceL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1825, languagePair = "he-ru", orderIndex = 1825,
            name = "Внешность и тело",
            description = "Профессиональная анатомия, пропорции и косметология",
            topic = "Внешность и тело", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1825 — Внешность и тело: профессиональный (L4, EPIC+RARE)
        // 5 групп × 5 слов: anatomy_pro, face_advanced, body_proportions,
        // skin_textures, grooming_advanced.
        // 17 EPIC + 8 RARE.
        // ══════════════════════════════════════════════════════════════════════

        // ── appearance_anatomy_pro (5) ────────────────────────────────────
        WordEntity(
            id = 182501, setId = 1825, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_anatomy_pro",
            original = "סְחוּס", translation = "хрящ",
            transliteration = "схус",
            definition = "רִקְמָה גְּמִישָׁה וְחָזָקָה שֶׁמְּכַסָּה אֶת קְצוֹת הָעֲצָמוֹת בַּמִּפְרָקִים.",
            definitionNative = "Гибкая упругая ткань, покрывающая концы костей в суставах.",
            example = "אַחֲרֵי הַתְּאוּנָה הָרוֹפֵא גִּלָּה נֵזֶק בַּסְּחוּס שֶׁל הַבֶּרֶךְ.",
            exampleNative = "После аварии врач обнаружил повреждение סְחוּס в колене.",
        ),
        WordEntity(
            id = 182502, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_anatomy_pro",
            original = "גִּיד", translation = "сухожилие",
            transliteration = "гид",
            definition = "סִיב לָבָן וְקָשֶׁה שֶׁמְּחַבֵּר אֶת הַשְּׁרִיר אֶל הָעֶצֶם.",
            definitionNative = "Белый плотный тяж, соединяющий мышцу с костью.",
            example = "הַסְפּוֹרְטַאי קָרַע אֶת הַגִּיד שֶׁל אֲכִילֶס בָּאִמּוּן.",
            exampleNative = "Спортсмен порвал ахиллов גִּיד на тренировке.",
         fillInBlankExclusions = listOf(182501L, 182503L, 182505L)),
        WordEntity(
            id = 182503, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_anatomy_pro",
            original = "סַרְעֶפֶת", translation = "диафрагма",
            transliteration = "сарэфэт",
            definition = "שְׁרִיר רָחָב בְּצוּרַת כִּפָּה בֵּין הֶחָזֶה לַבֶּטֶן — שׁוֹלֵט בַּנְּשִׁימָה.",
            definitionNative = "Широкая куполообразная мышца между грудью и животом — управляет дыханием.",
            example = "מוֹרָה לְשִׁירָה לִמְּדָה אוֹתִי לִנְשׁוֹם דֶּרֶךְ הַסַּרְעֶפֶת.",
            exampleNative = "Преподаватель вокала научил меня дышать через סַרְעֶפֶת.",
        ),
        WordEntity(
            id = 182504, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "appearance_anatomy_pro",
            original = "קְרוּם הָעֶצֶם", translation = "надкостница",
            transliteration = "крум hа-эцэм",
            definition = "שִׁכְבָה דַּקָּה וְעֲשִׁירָה בְּעֲצַבִּים שֶׁעוֹטֶפֶת אֶת הָעֶצֶם מִבַּחוּץ.",
            definitionNative = "Тонкий слой, богатый нервами, что покрывает кость снаружи.",
            example = "מַכָּה חֲזָקָה בָּשּׁוֹק פּוֹגַעַת קֹדֶם בִּקְרוּם הָעֶצֶם.",
            exampleNative = "Сильный удар по голени бьёт прежде всего по קְרוּם הָעֶצֶם.",
        ),
        WordEntity(
            id = 182505, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_anatomy_pro",
            original = "נְצָב", translation = "связка",
            transliteration = "нэцав",
            definition = "סִיב חָזָק שֶׁמְּחַבֵּר עֶצֶם לָעֶצֶם וְשׁוֹמֵר עַל הַמִּפְרָק יַצִּיב.",
            definitionNative = "Прочный тяж, соединяющий кость с костью и удерживающий сустав.",
            example = "הַשַּׂחְקָן נִקְרַע נְצָב צוֹלֵב וְעוֹבֵר נִתּוּחַ בַּשָּׁבוּעַ הַבָּא.",
            exampleNative = "Игрок порвал крестообразную נְצָב и идёт на операцию на следующей неделе.",
         fillInBlankExclusions = listOf(182501L, 182502L, 182503L)),

        // ── appearance_face_advanced (5) ──────────────────────────────────
        WordEntity(
            id = 182506, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "appearance_face_advanced",
            original = "קֶמֶט נָזוֹ-לָבְּיָאלִי", translation = "носогубная складка",
            transliteration = "кэмэт назо-лабьяли",
            definition = "קַו עָמֹק שֶׁנִּמְתָּח מִכְּנַף הָאַף עַד זָוִית הַפֶּה — מִתְעַמֵּק עִם הַגִּיל.",
            definitionNative = "Глубокая линия от крыла носа к углу рта — углубляется с возрастом.",
            example = "הַקּוֹסְמֶטִיקָאִית מְמַלֵּאת אֶת הַקֶּמֶט הַנָּזוֹ-לָבְּיָאלִי בְּחוּמְצָה הִיאַלוּרוֹנִית.",
            exampleNative = "Косметолог заполняет קֶמֶט נָזוֹ-לָבְּיָאלִי гиалуроновой кислотой.",
        ),
        WordEntity(
            id = 182507, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "appearance_face_advanced",
            original = "בֵּין הַגַּבּוֹת", translation = "межбровная зона",
            transliteration = "бэйн hа-габот",
            definition = "אֵזוֹר קָטָן שֶׁל עוֹר מֵעַל הָאַף — בֵּין שְׁתֵּי הַגַּבּוֹת.",
            definitionNative = "Маленький участок кожи над носом — между двумя бровями.",
            example = "הִיא הִזְרִיקָה בּוֹטוֹקְס בֵּין הַגַּבּוֹת לְמַחְלִיק קְמָטִים.",
            exampleNative = "Она ввела ботокс в בֵּין הַגַּבּוֹת для разглаживания морщин.",
         fillInBlankExclusions = listOf(182506L, 182508L, 182509L, 182510L)),
        WordEntity(
            id = 182508, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "appearance_face_advanced",
            original = "עַפְעַף תַּחְתּוֹן", translation = "нижнее веко",
            transliteration = "афаф тахтон",
            definition = "קָפֶל הָעוֹר מִתַּחַת לָעַיִן — עָדִין מְאוֹד וְנוֹטֶה לַנְפִיחוּת.",
            definitionNative = "Складка кожи под глазом — очень тонкая и склонна к припухлости.",
            example = "הַקּוֹסְמֶטִיקָאִית הִמְלִיצָה לִי קְרֵם מְיֻחָד לְעַפְעַף הַתַּחְתּוֹן.",
            exampleNative = "Косметолог посоветовала мне специальный крем для עַפְעַף תַּחְתּוֹן.",
        ),
        WordEntity(
            id = 182509, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "appearance_face_advanced",
            original = "אֵזוֹר רַקָּתִי", translation = "височная область",
            transliteration = "эзор ракати",
            definition = "חֵלֶק שֶׁל הַפָּנִים מִצַּד הַמֵּצַח עַד לִתְחִילַּת הַשֵּׂעָר.",
            definitionNative = "Часть лица сбоку от лба до самой линии волос.",
            example = "עִם הַגִּיל הָאֵזוֹר הָרַקָּתִי מַתְחִיל לְהִשְׁתַּקֵּעַ פְּנִימָה.",
            exampleNative = "С возрастом אֵזוֹר רַקָּתִי начинает западать внутрь.",
        ),
        WordEntity(
            id = 182510, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "appearance_face_advanced",
            original = "עִגּוּל תַּת-עֵינִי", translation = "подглазничный круг",
            transliteration = "игуль тат-эйни",
            definition = "צֶלַח כֵּהֶה אוֹ נָפוּחַ מִתַּחַת לָעַיִן — מִתְעַצֵּם בְּחֹסֶר שֵׁנָה.",
            definitionNative = "Тёмная или припухлая зона под глазом — усиливается при недосыпе.",
            example = "אַחֲרֵי הַטִּיסָה הָעִגּוּל הַתַּת-עֵינִי הָיָה כָּחֹל וְעָמֹק.",
            exampleNative = "После перелёта עִגּוּל תַּת-עֵינִי стал синим и глубоким.",
        ),

        // ── appearance_body_proportions (5) ───────────────────────────────
        WordEntity(
            id = 182511, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_body_proportions",
            original = "אֵקְטוֹמוֹרְף", translation = "эктоморф",
            transliteration = "эктоморф",
            definition = "טִיפּוּס מִבְנֶה רָזֶה וְגָבוֹהַּ מִטֶּבַע — מִתְקַשֶּׁה לִצְבּוֹר מָסַּת שְׁרִירִים.",
            definitionNative = "Тип сложения худой и вытянутый от природы — с трудом набирает мышечную массу.",
            example = "הוּא אֵקְטוֹמוֹרְף קְלָאסִי — אוֹכֵל הַרְבֵּה וְלֹא מַשְׁמִין.",
            exampleNative = "Он классический אֵקְטוֹמוֹרְף — много ест и не толстеет.",
         fillInBlankExclusions = listOf(182512L, 182513L)),
        WordEntity(
            id = 182512, setId = 1825, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_body_proportions",
            original = "מֵזוֹמוֹרְף", translation = "мезоморф",
            transliteration = "мэзоморф",
            definition = "טִיפּוּס מִבְנֶה שְׁרִירִי וְאַתְלֵטִי מִטֶּבַע — מָסָּה גְּדוֹלָה וְשֻׁמָּן נָמוּךְ.",
            definitionNative = "Тип сложения мускулистый и атлетический от природы — большая масса и мало жира.",
            example = "מַאַמֵּן אָמַר שֶׁאֲנִי מֵזוֹמוֹרְף וְאֶבְנֶה שְׁרִירִים מַהֵר.",
            exampleNative = "Тренер сказал, что я מֵזוֹמוֹרְף и быстро наберу мышцы.",
         fillInBlankExclusions = listOf(182511L, 182513L)),
        WordEntity(
            id = 182513, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_body_proportions",
            original = "אֵנְדוֹמוֹרְף", translation = "эндоморф",
            transliteration = "эндоморф",
            definition = "טִיפּוּס מִבְנֶה רַךְ וְעָגוֹל מִטֶּבַע — צוֹבֵר שֻׁמָּן בְּקַלּוּת.",
            definitionNative = "Тип сложения мягкий и округлый от природы — легко набирает жир.",
            example = "כְאֵנְדוֹמוֹרְף הוּא צָרִיךְ דִּיאֵטָה דַּלַּת פַּחְמֵימוֹת.",
            exampleNative = "Как אֵנְדוֹמוֹרְף, ему нужна низкоуглеводная диета.",
         fillInBlankExclusions = listOf(182511L, 182512L)),
        WordEntity(
            id = 182514, setId = 1825, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "appearance_body_proportions",
            original = "הֶיקֵּף מָתְנַיִם", translation = "обхват талии",
            transliteration = "hэйкэф мотнаим",
            definition = "מִדַּת אֹרֶךְ סְבִיב הַחֵלֶק הַצַּר בְּיוֹתֵר שֶׁל הַגֵּו — מַדָּד מַפְתֵּחַ לִבְרִיאוּת.",
            definitionNative = "Длина по самой узкой части туловища — ключевой показатель здоровья.",
            example = "הָרוֹפֵא מָדַד אֶת הֶיקֵּף הַמָּתְנַיִם וְהוּא תָּקִין.",
            exampleNative = "Врач измерил הֶיקֵּף מָתְנַיִם, и он в норме.",
        ),
        WordEntity(
            id = 182515, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "appearance_body_proportions",
            original = "סִימֶטְרְיַת פָּנִים", translation = "симметрия лица",
            transliteration = "симэтриат паним",
            definition = "מִדַּת הַדִּמְיוֹן בֵּין הַחֵלֶק הַיְמָנִי וְהַשְּׂמָאלִי שֶׁל הַפָּנִים.",
            definitionNative = "Степень соответствия правой и левой половины лица друг другу.",
            example = "סִימֶטְרְיַת הַפָּנִים שֶׁלָּהּ נֶחְשֶׁבֶת מֻשְׁלֶמֶת בִּצִלּוּמִים.",
            exampleNative = "סִימֶטְרְיַת פָּנִים её считается идеальной на снимках.",
        ),

        // ── appearance_skin_textures (5) ──────────────────────────────────
        WordEntity(
            id = 182516, setId = 1825, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_skin_textures",
            original = "אֵלַסְטִית", translation = "упругая (о коже)",
            transliteration = "эластит",
            definition = "עוֹר שֶׁחוֹזֵר מַהֵר לְצוּרָתוֹ אַחֲרֵי לְחִיצָה — סִימָן שֶׁל קוֹלָגֵן בָּרִיא.",
            definitionNative = "Кожа, что быстро возвращается к форме после нажатия — признак здорового коллагена.",
            example = "בְּגִיל עֶשְׂרִים הָעוֹר עֲדַיִן אֵלַסְטִית וְלוּקַחַת מַהֵר נְזָקִים.",
            exampleNative = "В двадцать лет кожа ещё אֵלַסְטִית и быстро восстанавливается.",
         fillInBlankExclusions = listOf(182517L, 182518L, 182519L)),
        WordEntity(
            id = 182517, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "appearance_skin_textures",
            original = "רוֹפֶפֶת", translation = "дряблая (о коже)",
            transliteration = "рофэфэт",
            definition = "עוֹר שֶׁאִבֵּד אֶת הַחֹזֶק וְנִתְלֶה לְמַטָּה — אוֹפְיָנִי לְגִיל מְבֻגָּר.",
            definitionNative = "Кожа, потерявшая упругость и провисающая вниз — типично для зрелого возраста.",
            example = "הָעוֹר עַל הַזְּרוֹעוֹת הוֹפֵךְ רוֹפֶפֶת אַחֲרֵי הָרְזִיָּה הַמְּהִירָה.",
            exampleNative = "Кожа на руках становится רוֹפֶפֶת после быстрого похудения.",
         fillInBlankExclusions = listOf(182516L, 182518L, 182519L)),
        WordEntity(
            id = 182518, setId = 1825, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_skin_textures",
            original = "רְגִישָׁה", translation = "чувствительная (о коже)",
            transliteration = "рэгиша",
            definition = "עוֹר שֶׁמַּגִּיב בְּגֵרוּי לְקוֹסְמֶטִיקָה, חוֹם וְלַחַץ.",
            definitionNative = "Кожа, реагирующая раздражением на косметику, тепло и давление.",
            example = "הָעוֹר שֶׁלָּהּ רְגִישָׁה וְהִיא קוֹנָה רַק קוֹסְמֶטִיקָה הִיפּוֹאָלֶרְגֶנִית.",
            exampleNative = "Её кожа רְגִישָׁה, и она покупает только гипоаллергенную косметику.",
         fillInBlankExclusions = listOf(182516L, 182517L, 182519L)),
        WordEntity(
            id = 182519, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "appearance_skin_textures",
            original = "מְיֻבֶּשֶׁת", translation = "обезвоженная (о коже)",
            transliteration = "мэюбэшэт",
            definition = "עוֹר שֶׁחָסֵר לוֹ מַיִם בִּפְנִים — מַרְגִּישׁ מָתוּחַ וְקֵהֶה גַּם אִם שַׁמְנוּנִי.",
            definitionNative = "Кожа, испытывающая нехватку воды внутри — натянутая и тусклая, даже если жирная.",
            example = "אַחֲרֵי הַטִּיסָה הָאֲרֻכָּה הָעוֹר שֶׁלִּי מְיֻבֶּשֶׁת לְגַמְרֵי.",
            exampleNative = "После долгого перелёта моя кожа полностью מְיֻבֶּשֶׁת.",
         fillInBlankExclusions = listOf(182516L, 182517L, 182518L)),
        WordEntity(
            id = 182520, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_skin_textures",
            original = "הִיפֶּרְפִּיגְמֶנְטַצְיָה", translation = "гиперпигментация",
            transliteration = "hипэрпигмэнтация",
            definition = "כְּתָמִים כֵּהִים עַל הָעוֹר מִיֶּתֶר מֵלָנִין — אַחֲרֵי שֶׁמֶשׁ אוֹ הֵרָיוֹן.",
            definitionNative = "Тёмные пятна на коже из-за избытка меланина — после солнца или беременности.",
            example = "הִיפֶּרְפִּיגְמֶנְטַצְיָה אַחֲרֵי הַקַּיִץ דּוֹרֶשֶׁת טִפּוּלֵי לֵיזֶר.",
            exampleNative = "הִיפֶּרְפִּיגְמֶנְטַצְיָה после лета требует лазерных процедур.",
        ),

        // ── appearance_grooming_advanced (5) ──────────────────────────────
        WordEntity(
            id = 182521, setId = 1825, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "appearance_grooming_advanced",
            original = "אִיפּוּר טִבְעִי", translation = "нюдовый макияж",
            transliteration = "ипур тивъи",
            definition = "אִיפּוּר עָדִין שֶׁמַּדְגִּישׁ אֶת הַפָּנִים בְּלִי לְהֵרָאוֹת מָלָא.",
            definitionNative = "Лёгкий макияж, что подчёркивает лицо, но не выглядит наляпанным.",
            example = "לָרֵאַיוֹן הַחֲשׁוּב הִיא בָּחֲרָה אִיפּוּר טִבְעִי וּמַטָּעֵם.",
            exampleNative = "На важное собеседование она выбрала אִיפּוּר טִבְעִי и со вкусом.",
         fillInBlankExclusions = listOf(182522L, 182523L, 182525L)),
        WordEntity(
            id = 182522, setId = 1825, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_grooming_advanced",
            original = "מָנִיקוּר", translation = "маникюр",
            transliteration = "маникур",
            definition = "טִפּוּל מְקַצּוֹעִי שֶׁל צִפָּרְנֵי הַיָּדַיִם — הַחְלָקָה, צֶבַע, צוּרָה.",
            definitionNative = "Профессиональная обработка ногтей рук — выравнивание, цвет, форма.",
            example = "הִיא הוֹלֶכֶת לְמָנִיקוּר פַּעַם בִּשְׁלֹשָׁה שָׁבוּעוֹת בְּדִיּוּק.",
            exampleNative = "Она ходит на מָנִיקוּר ровно раз в три недели.",
         fillInBlankExclusions = listOf(182524L)),
        WordEntity(
            id = 182523, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "appearance_grooming_advanced",
            original = "עִצּוּב גַּבּוֹת", translation = "оформление бровей / броу-арт",
            transliteration = "ицув габот",
            definition = "טִפּוּל מְקַצּוֹעִי שֶׁל הַגַּבּוֹת — מְרִיטָה, צְבִיעָה וְעִצּוּב צוּרָה.",
            definitionNative = "Профессиональная работа с бровями — выщипывание, окраска и придание формы.",
            example = "אַחֲרֵי עִצּוּב גַּבּוֹת בַּסָּלוֹן הַפָּנִים נִרְאוֹת אַחֶרֶת לְגַמְרֵי.",
            exampleNative = "После עִצּוּב גַּבּוֹת в салоне лицо выглядит совсем иначе.",
         fillInBlankExclusions = listOf(182521L, 182524L, 182525L)),
        WordEntity(
            id = 182524, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_grooming_advanced",
            original = "הַבְרָקָה", translation = "лоск, блеск",
            transliteration = "hаврака",
            definition = "תּוֹסֶפֶת בֹּהַק וְזֹהַר לָעוֹר אוֹ לַשֵּׂעָר אַחֲרֵי טִפּוּל קוֹסְמֶטִי.",
            definitionNative = "Добавление сияния и блеска коже или волосам после косметической процедуры.",
            example = "אַחֲרֵי טִפּוּל הַפָּנִים הָיְתָה לָעוֹר הַבְרָקָה בְּרִיאָה.",
            exampleNative = "После уходовой процедуры у кожи появилась здоровая הַבְרָקָה.",
         fillInBlankExclusions = listOf(182522L)),
        WordEntity(
            id = 182525, setId = 1825, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "appearance_grooming_advanced",
            original = "מְתִיחַת פָּנִים", translation = "подтяжка лица, лифтинг",
            transliteration = "мтихат паним",
            definition = "טִפּוּל אֶסְתֵּטִי שֶׁמַּחֲזִיר אֶת הָעוֹר לִמְתִיחוּת — נִתּוּחִי אוֹ לֹא-נִתּוּחִי.",
            definitionNative = "Эстетическая процедура, возвращающая коже натянутость — хирургическая или нет.",
            example = "הַסֶלֶבְּ עָבְרָה מְתִיחַת פָּנִים לִפְנֵי הָאֵרוּעַ הַגָּדוֹל.",
            exampleNative = "Селебрити прошла מְתִיחַת פָּנִים перед большим мероприятием.",
         fillInBlankExclusions = listOf(182521L, 182522L, 182523L, 182524L)),
    )
}
