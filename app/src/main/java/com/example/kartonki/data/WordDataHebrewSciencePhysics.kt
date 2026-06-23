package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1897 (he-ru).
 * Наука: физика — механика, энергия, электричество, оптика, термодинамика
 * (L3 / UNCOMMON + RARE).
 *
 * Расширение темы «Наука». Зеркало en-ru set 465 (физика).
 * Дополняет существующий he-ru сет 1708 (наука L1, базовая лабораторная
 * лексика) и не пересекается с ним по `original`.
 *
 * Пять семантических групп:
 *   science_physics_mechanics    — תְּאוּצָה, תְּנוּפָה, הִתְמַדָּה, חִיכּוּךְ, טוֹרְק
 *   science_physics_energy       — אֶנֶרְגִיָּה קִינֶטִית/פּוֹטֶנְצְיָאלִית, נְצִילוּת, צְפִיפוּת, מוֹמֶנְט
 *   science_physics_electricity  — מוֹלִיךְ, מַבְדֵּד, מַגְנֵטִיוּת, מַטְעָן, אֵלֶקְטְרוֹמַגְנֵט
 *   science_physics_optics_waves — אוֹרֶךְ גַּל, שְׁבִירָה, עֲדָשָׁה, סְפֶּקְטְרוּם, תְּהוּדָה
 *   science_physics_thermo       — אֶנְטְרוֹפְּיָה, הוֹלָכָה, קַרְקוּב, צְמִיגוּת, הִתְאַדּוּת
 *
 * Из шорт-листа исключены дубли (15 слов):
 *   - מָסָה        (масса) — Literature
 *   - כּוֹחַ        (сила) — Batch43, Batch70
 *   - חוֹם         (тепло) — Batch67, Batch68
 *   - טֶמְפֶּרָטוּרָה (температура) — More
 *   - אוֹר         (свет) — Everyday, ScienceL1
 *   - לַחַץ        (давление) — Batch71
 *   - מְהִירוּת    (скорость) — Batch64, IsraeliTransportL2
 *   - עֲבוֹדָה     (работа) — Batch72, InterviewL1, WorkV2
 *   - הֶסְפֵּק     (мощность) — Batch67
 *   - הִתְנַגְּדוּת (сопротивление эл.) — Batch47
 *   - מַעְגָּל      (цепь/контур) — Batch67, Batch70
 *   - פוֹטוֹן       (фотон) — Space
 *   - הֶחְזֵר       (отражение) — ShoppingL1L2L3
 *   - מֶתַח        (напряжение) — Batch50
 *   - זֶרֶם         (ток) — Batch67
 *
 * Word IDs: 189701..189725 (setId × 100 + position).
 */
object WordDataHebrewSciencePhysics {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1897, languagePair = "he-ru", orderIndex = 1897,
            name = "Наука",
            description = "Физика: механика, электричество, оптика и термодинамика — תְּאוּצָה, מַגְנֵטִיוּת, שְׁבִירָה, הוֹלָכָה",
            topic = "Наука",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: science_physics_mechanics (5 words) ────────────────────────

        WordEntity(id = 189701, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "תְּאוּצָה",
            translation = "ускорение",
            definition = "קֶצֶב הַשִּׁנּוּי שֶׁל מְהִירוּת גּוּף לְאֹרֶךְ זְמַן, בְּכָל כִּוּוּן שֶׁבּוֹ הוּא נָע.",
            definitionNative = "Скорость изменения быстроты тела со временем — в любом направлении его движения.",
            example = "הָרֶכֶב הַחַשְׁמַלִּי לוֹחֵץ אוֹתְךָ לַמּוֹשָׁב בִּזְכוּת הַתְּאוּצָה הָעוֹצֶמְתִית שֶׁלּוֹ.",
            exampleNative = "Электромобиль вжимает в кресло благодаря своей мощной תְּאוּצָה.",
            pos = "noun", semanticGroup = "science_physics_mechanics", fillInBlankExclusions = listOf(189702L, 189703L, 189704L, 189705L)),

        WordEntity(id = 189702, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "תְּנוּפָה",
            translation = "импульс (количество движения)",
            definition = "מַאֲגַר הַתְּנוּעָה שֶׁל גּוּף, שָׁוֶה לְמַסָּתוֹ כְּפוּלָה בִּמְהִירוּתוֹ.",
            definitionNative = "Запас движения тела — произведение его массы на быстроту перемещения.",
            example = "הַמַּשָּׂאִית הִמְשִׁיכָה לְהִתְגַּלְגֵּל בִּגְלַל תְּנוּפָה גְּדוֹלָה מִדַּי לִבְלִימָה.",
            exampleNative = "Грузовик ещё катился: его תְּנוּפָה была слишком велика для резкого торможения.",
            pos = "noun", semanticGroup = "science_physics_mechanics", fillInBlankExclusions = listOf(189701L, 189703L, 189704L, 189705L)),

        WordEntity(id = 189703, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "הִתְמַדָּה",
            translation = "инерция",
            definition = "נְטִיָּתוֹ הַטִּבְעִית שֶׁל גּוּף לְהַמְשִׁיךְ בְּמַצָּבוֹ הַנּוֹכְחִי עַד שֶׁמַּשֶּׁהוּ דּוֹחֵף אוֹתוֹ אַחֶרֶת.",
            definitionNative = "Природное свойство тела сохранять текущее состояние движения или покоя, пока что-то его не толкнёт.",
            example = "הַנּוֹסְעִים נִזְרָקִים קָדִימָה כִּי הַהִתְמָדָּה דּוֹחֶפֶת אוֹתָם אַחֲרֵי בְּלִימָה.",
            exampleNative = "Пассажиров кидает вперёд: הִתְמַדָּה толкает их и после резкой остановки.",
            pos = "noun", semanticGroup = "science_physics_mechanics", fillInBlankExclusions = listOf(189701L, 189702L, 189704L, 189705L)),

        WordEntity(id = 189704, setId = 1897, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חִיכּוּךְ",
            translation = "трение",
            definition = "הִתְנַגְּדוּת שֶׁמַּפִּיקִים מִשְׁטָחִים בְּמַגָּע כְּשֶׁאֶחָד מְנַסֶּה לְהַחְלִיק עַל הַשֵּׁנִי.",
            definitionNative = "Сопротивление, которое создают соприкасающиеся поверхности, когда одна скользит по другой.",
            example = "סְקַיֶּרִים מוֹשְׁחִים אֶת הַסְּקִי בְּשַׁעֲוָה כְּדֵי לְצַמְצֵם חִיכּוּךְ עִם הַשֶּׁלֶג.",
            exampleNative = "Лыжники натирают лыжи мазью, чтобы уменьшить חִיכּוּךְ со снегом.",
            pos = "noun", semanticGroup = "science_physics_mechanics"),

        WordEntity(id = 189705, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "טוֹרְק",
            translation = "момент силы / крутящий момент",
            definition = "הַדְּחִיפָה הַסִּבּוּבִית שֶׁכּוֹחַ מַפְעִיל עַל גּוּף סְבִיב צִיר, כְּמוֹ הִדּוּק בֹּרֶג בְּעֶזְרַת מַפְתֵּחַ.",
            definitionNative = "Поворачивающее воздействие силы на тело вокруг оси — как при затягивании болта ключом.",
            example = "נַהָגֵי מַשָּׂאִיּוֹת מַעֲדִיפִים דִּיזֶל בִּזְכוּת טוֹרְק נָמוּךְ שֶׁמּוֹשֵׁךְ בָּהָר.",
            exampleNative = "Дальнобойщики любят дизель за низкооборотный טוֹרְק, тянущий груз в гору.",
            pos = "noun", semanticGroup = "science_physics_mechanics", fillInBlankExclusions = listOf(189701L, 189702L, 189703L, 189704L)),

        // ── Group: science_physics_energy (5 words) ───────────────────────────

        WordEntity(id = 189706, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "אֶנֶרְגִיָּה קִינֶטִית",
            translation = "кинетическая энергия",
            definition = "מַאֲגַר הַתְּנוּעָה שֶׁל גּוּף; כָּל שֶׁהוּא מָהִיר אוֹ כָּבֵד יוֹתֵר, הַמַּאֲגָר גָּדוֹל יוֹתֵר.",
            definitionNative = "Запас движения у тела: чем быстрее или тяжелее оно перемещается, тем этот запас больше.",
            example = "פַּטִּישׁ נוֹפֵל הוֹפֵךְ גֹּבַהּ לְאֵנֶרְגִּיָּה קִינֶטִית וְתוֹקֵעַ מַסְמֵר.",
            exampleNative = "Падающий молоток превращает высоту в אֶנֶרְגִיָּה קִינֶטִית и забивает гвоздь.",
            pos = "phrase", semanticGroup = "science_physics_energy", fillInBlankExclusions = listOf(189707L)),

        WordEntity(id = 189707, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "אֶנֶרְגִיָּה פּוֹטֶנְצְיָאלִית",
            translation = "потенциальная энергия",
            definition = "הַמַּאֲגָר הַסָּמוּי שֶׁגּוּף שׁוֹמֵר בִּגְלַל מְקוֹמוֹ אוֹ צוּרָתוֹ, וּמוּכָן לַעֲבֹר לִתְנוּעָה כְּשֶׁמְּשַׁחְרְרִים אוֹתוֹ.",
            definitionNative = "Скрытый запас, который тело хранит из-за своего положения или формы; готов перейти в движение при отпускании.",
            example = "קֶשֶׁת מְתוּחָה אוֹגֶרֶת אֶנֶרְגִיָּה פּוֹטֶנְצְיָאלִית וּמְשַׁחְרֶרֶת בַּיְּרִיָּה.",
            exampleNative = "Натянутый лук хранит אֶנֶרְגִיָּה פּוֹטֶנְצְיָאלִית и отдаёт её при выстреле.",
            pos = "phrase", semanticGroup = "science_physics_energy", fillInBlankExclusions = listOf(189706L)),

        WordEntity(id = 189708, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "נְצִילוּת",
            translation = "коэффициент полезного действия",
            definition = "הַחֵלֶק מִכַּמּוּת הָאֵנֶרְגִיָּה שֶׁמּוּשְׁקַעַת וְחוֹזֵר כְּתוֹצָאָה שִׁמּוּשִׁית; הַשְּׁאָר אוֹבֵד כְּחֹם אוֹ רַעַשׁ.",
            definitionNative = "Доля вложенной энергии, возвращающаяся полезным результатом; остальное уходит на тепло или шум.",
            example = "נוּרוֹת לֶד מְנַצְּחוֹת בִּנְצִילוּת: רֹב הַחַשְׁמַל הוֹפֵךְ לְאוֹר.",
            exampleNative = "Светодиодные лампы выигрывают по נְצִילוּת: почти весь ток идёт в свет.",
            pos = "noun", semanticGroup = "science_physics_energy", fillInBlankExclusions = listOf(189709L, 189710L)),

        WordEntity(id = 189709, setId = 1897, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צְפִיפוּת",
            translation = "плотность",
            definition = "כַּמּוּת הַחֹמֶר שֶׁדְּחוּסָה בְּתוֹךְ יְחִידַת נֶפַח אֶחָד שֶׁל גּוּף.",
            definitionNative = "Количество вещества, упакованного в одну единицу объёма тела.",
            example = "עוֹפֶרֶת שׁוֹקַעַת בְּמַיִם כִּי הַצְּפִיפוּת שֶׁלָּהּ גְּבוֹהָה מִשֶּׁל הַנּוֹזֵל.",
            exampleNative = "Свинец тонет в воде: его צְפִיפוּת намного выше, чем у воды.",
            pos = "noun", semanticGroup = "science_physics_energy"),

        WordEntity(id = 189710, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "מוֹמֶנְט",
            translation = "момент (физ.)",
            definition = "מוּשָׂג פִיסִיקָלִי הַמּוֹדֵד אֶת הַשְׁפָּעַת כּוֹחַ אוֹ תְּנוּעָה סְבִיב צִיר אוֹ נְקֻדָּה.",
            definitionNative = "Физическая величина, измеряющая воздействие силы или движения относительно оси или точки.",
            example = "הַמַּהַנְדֵּס חִשֵּׁב אֶת הַמּוֹמֶנְט שֶׁל הַמָּנּוֹף לִקְבִיעַת אֹרֶךְ הַזְּרוֹעַ.",
            exampleNative = "Инженер посчитал מוֹמֶנְט крана, чтобы решить, какой длины делать стрелу.",
            pos = "noun", semanticGroup = "science_physics_energy"),

        // ── Group: science_physics_electricity (5 words) ──────────────────────

        WordEntity(id = 189711, setId = 1897, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹלִיךְ",
            translation = "проводник (электрический)",
            definition = "חֹמֶר שֶׁמַּעֲבִיר זֶרֶם חַשְׁמַלִּי בְּקַלּוּת, כְּמוֹ נְחֹשֶׁת אוֹ אָלוּמִינְיוּם.",
            definitionNative = "Материал, легко пропускающий электрический ток; например, медь или алюминий.",
            example = "הַחַשְׁמַלַּאי בָּחַר חוּט נְחֹשֶׁת עָבֶה כִּי הוּא מוֹלִיךְ מְצוּיָן לְבַיִת.",
            exampleNative = "Электрик выбрал толстую медную жилу — она отличный מוֹלִיךְ для домашней проводки.",
            pos = "noun", semanticGroup = "science_physics_electricity"),

        WordEntity(id = 189712, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "מַבְדֵּד",
            translation = "изолятор",
            definition = "חֹמֶר שֶׁכִּמְעַט אֵינוֹ מַעֲבִיר זֶרֶם אוֹ חֹם, מְשַׁמֵּשׁ לַחֲסוֹם אוֹתָם בְּמָקוֹם שֶׁצָּרִיךְ.",
            definitionNative = "Материал, почти не пропускающий ток или тепло; используется, чтобы блокировать их там, где надо.",
            example = "כְּפָפוֹת גּוּמִי הֵן מַבְדֵּד טוֹב וּמְגִנּוֹת עַל הַחַשְׁמַלַּאי מִפְּנֵי זֶרֶם.",
            exampleNative = "Резиновые перчатки — хороший מַבְדֵּד; защищают электрика от тока.",
            pos = "noun", semanticGroup = "science_physics_electricity", fillInBlankExclusions = listOf(189711L, 189713L, 189714L, 189715L)),

        WordEntity(id = 189713, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "מַגְנֵטִיּוּת",
            translation = "магнетизм",
            definition = "הַמְּשִׁיכָה אוֹ הַדְּחִיָּה שֶׁמַּפִּיקִים חֳמָרִים מְסֻיָּמִים וּמִטְעָנִים נָעִים עַל בַּרְזֶל, נִיקֶל וְזֶה עַל זֶה.",
            definitionNative = "Притяжение или отталкивание, которое некоторые материалы и движущиеся заряды создают на железе, никеле и друг на друге.",
            example = "כּוֹנְנֵי דִּיסְק שׁוֹמְרִים נְתוּנִים בְּאֵזוֹרֵי מַגְנֵטִיּוּת זְעִירִים עַל פְּלָטָה.",
            exampleNative = "Жёсткие диски хранят данные в крошечных участках מַגְנֵטִיּוּת на пластине.",
            pos = "noun", semanticGroup = "science_physics_electricity", fillInBlankExclusions = listOf(189711L, 189712L, 189714L, 189715L)),

        WordEntity(id = 189714, setId = 1897, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַטְעָן",
            translation = "заряд (электрический)",
            definition = "תְּכוּנָה בְּסִיסִית שֶׁל חַלֲקִיקִים גּוֹרֶמֶת לָהֶם לִמְשֹׁךְ אוֹ לִדְחוֹת זֶה אֶת זֶה דֶּרֶךְ שְׂדוֹת חַשְׁמַל.",
            definitionNative = "Базовое свойство частиц, заставляющее их притягиваться или отталкиваться через электрические поля.",
            example = "כְּשֶׁמּוֹרִידִים סְוֶדֶר צַמְרִי, הַשֵּׂעָר עוֹמֵד בִּגְלַל מַטְעָן סְטָטִי.",
            exampleNative = "Снимешь шерстяной свитер — волосы дыбом из-за статического מַטְעָן.",
            pos = "noun", semanticGroup = "science_physics_electricity", fillInBlankExclusions = listOf(189711L, 189712L, 189713L, 189715L)),

        WordEntity(id = 189715, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "אֵלֶקְטְרוֹמַגְנֵט",
            translation = "электромагнит",
            definition = "סְלִיל חוּט שֶׁדֶּרֶךְ זֶרֶם חַשְׁמַלִּי הוֹפֵךְ לְמַגְנֵט חָזָק, וְכָבֶה כְּשֶׁמְּנַתְּקִים אֶת הַזֶּרֶם.",
            definitionNative = "Катушка из провода: при прохождении тока становится сильным магнитом и «отключается», когда ток снят.",
            example = "בַּמִּגְרָשׁ הַגְּרוּטָאוֹת אֵלֶקְטְרוֹמַגְנֵט עֲנָק מֵרִים גּוּפֵי רֶכֶב יְשָׁנִים בְּקַלּוּת.",
            exampleNative = "На свалке металлолома гигантский אֵלֶקְטְרוֹמַגְנֵט легко поднимает кузова старых машин.",
            pos = "noun", semanticGroup = "science_physics_electricity", fillInBlankExclusions = listOf(189711L, 189712L, 189713L, 189714L)),

        // ── Group: science_physics_optics_waves (5 words) ─────────────────────

        WordEntity(id = 189716, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹרֶךְ גַּל",
            translation = "длина волны",
            definition = "הַמֶּרְחָק בֵּין שְׁנֵי גַּלִּים סְמוּכִים, מוֹדֵד אֶת צֶבַע הָאוֹר אוֹ גֹּבַהּ הַצְּלִיל.",
            definitionNative = "Расстояние между двумя соседними гребнями волны; определяет цвет света или высоту звука.",
            example = "אוֹרֶךְ גַּל קָצָר יוֹתֵר נִרְאֶה לָעַיִן כְּצֶבַע סָגֹל אוֹ כָּחֹל.",
            exampleNative = "Более короткая אוֹרֶךְ גַּל кажется глазу фиолетовым или синим.",
            pos = "phrase", semanticGroup = "science_physics_optics_waves"),

        WordEntity(id = 189717, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "שְׁבִירָה",
            translation = "преломление (света)",
            definition = "הִתְכּוֹפְפוּת קֶרֶן אוֹר כְּשֶׁהִיא עוֹבֶרֶת אֶל תּוֹךְ אֶמְצַע שֶׁבּוֹ הִיא נָעָה בִּמְהִירוּת אַחֶרֶת.",
            definitionNative = "Изгиб луча света при переходе в среду, где он движется с иной скоростью.",
            example = "קַשִּׁית בְּכוֹס מַיִם נִרְאֵית שְׁבוּרָה עַל פְּנֵי הַמַּיִם בִּגְלַל הַשְּׁבִירָה שֶׁל הָאוֹר.",
            exampleNative = "Соломинка в стакане воды кажется надломленной у поверхности из-за שְׁבִירָה света.",
            pos = "noun", semanticGroup = "science_physics_optics_waves"),

        WordEntity(id = 189718, setId = 1897, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲדָשָׁה",
            translation = "линза",
            definition = "חֲתִיכַת זְכוּכִית אוֹ פְּלַסְטִיק קְמוּרָה הַמַּסִּיטָה קַרְנֵי אוֹר וְיוֹצֶרֶת מֵהֶן תְּמוּנָה חַדָּה.",
            definitionNative = "Изогнутый кусок стекла или пластика, отклоняющий лучи света и собирающий из них чёткое изображение.",
            example = "עֲדָשָׁה מְשֻׁרֶטֶת מְטַשְׁטֶשֶׁת כָּל תְּמוּנָה, גַּם עִם חַיֶּשֶׁן מְעֻלֶּה.",
            exampleNative = "Поцарапанная עֲדָשָׁה размывает кадр даже при отличном сенсоре.",
            pos = "noun", semanticGroup = "science_physics_optics_waves", fillInBlankExclusions = listOf(189717L, 189719L, 189720L)),

        WordEntity(id = 189719, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "סְפֶּקְטְרוּם",
            translation = "спектр",
            definition = "טְוָח שֶׁל גַּלִּים אוֹ צְבָעִים הַסּוֹדְרִים זֶה לְצַד זֶה לְפִי אֹרֶךְ גַּל אוֹ תֶּדֶר.",
            definitionNative = "Диапазон волн или цветов, расположенных подряд по длине волны или частоте.",
            example = "הַקֶּשֶׁת בֶּעָנָן מַרְאָה אֶת כָּל הַסְּפֶּקְטְרוּם הַנִּרְאֶה, מֵאָדֹם עַד סָגֹל.",
            exampleNative = "Радуга в облаке показывает весь видимый סְפֶּקְטְרוּם — от красного до фиолетового.",
            pos = "noun", semanticGroup = "science_physics_optics_waves"),

        WordEntity(id = 189720, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "תְּהוּדָה",
            translation = "резонанс",
            definition = "תּוֹפָעָה שֶׁבָּהּ גּוּף מַתְחִיל לִתְנוֹעֵעַ חָזָק כְּשֶׁכּוֹחַ חִיצוֹנִי דּוֹחֵף אוֹתוֹ בַּתֶּדֶר הַטִּבְעִי שֶׁלּוֹ.",
            definitionNative = "Явление, при котором тело начинает сильно колебаться, когда внешняя сила толкает его на его же собственной частоте.",
            example = "הַזַּמֶּרֶת שָׁבְרָה כּוֹס יַיִן בִּזְכוּת תְּהוּדָה בֵּין קוֹלָהּ לַכּוֹס.",
            exampleNative = "Певица разбила бокал благодаря תְּהוּדָה между её голосом и стеклом.",
            pos = "noun", semanticGroup = "science_physics_optics_waves", fillInBlankExclusions = listOf(189717L, 189718L, 189719L)),

        // ── Group: science_physics_thermo (5 words) ───────────────────────────

        WordEntity(id = 189721, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "אֶנְטְרוֹפְּיָה",
            translation = "энтропия",
            definition = "מוּשָׂג הַמּוֹדֵד אֶת מִדַּת אִי־הַסֵּדֶר שֶׁל מַעֲרֶכֶת; בִּמְעַרְכוֹת סְגוּרוֹת הִיא נוֹטָה לִגְדֹּל.",
            definitionNative = "Мера беспорядка в системе; в замкнутых системах она имеет тенденцию расти со временем.",
            example = "כּוֹס קָפֶה מִתְקָרֶרֶת מַדְגִּימָה אֵיךְ אֶנְטְרוֹפְּיָה גְּדֵלָה בְּמַעֲרֶכֶת סְגוּרָה.",
            exampleNative = "Остывающий кофе показывает, как אֶנְטְרוֹפְּיָה растёт в замкнутой системе.",
            pos = "noun", semanticGroup = "science_physics_thermo", fillInBlankExclusions = listOf(189722L, 189723L, 189724L, 189725L)),

        WordEntity(id = 189722, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "הוֹלָכָה",
            translation = "теплопроводность",
            definition = "הַעֲבָרָה שֶׁל חֹם אוֹ זֶרֶם דֶּרֶךְ גּוּף בְּעֶזְרַת מַגָּע יָשִׁיר בֵּין הַחַלֲקִיקִים שֶׁלּוֹ.",
            definitionNative = "Передача тепла или тока внутри тела за счёт прямого контакта его частиц друг с другом.",
            example = "מַחֲבַת נְחֹשֶׁת מְחַמֶּמֶת אֹכֶל בִּמְהִירוּת בִּגְלַל הַהוֹלָכָה הַטּוֹבָה שֶׁל הַמַּתֶּכֶת.",
            exampleNative = "Медная сковорода греет еду быстро благодаря хорошей הוֹלָכָה металла.",
            pos = "noun", semanticGroup = "science_physics_thermo", fillInBlankExclusions = listOf(189721L, 189723L, 189724L, 189725L)),

        WordEntity(id = 189723, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "קְרִינָה",
            translation = "излучение / радиация",
            definition = "פְּלִיטָה שֶׁל אֵנֶרְגִיָּה אוֹ חַלֲקִיקִים מִגּוּף לַחוּצָה, בְּצוּרַת גַּלִּים אוֹ קַרְנַיִם.",
            definitionNative = "Испускание энергии или частиц телом наружу — в виде волн или лучей.",
            example = "הַטֶּכְנַאי לוֹבֵשׁ אֲפֻדָּה מְעֻפֶּרֶת כְּדֵי לְהָגֵן מִפְּנֵי קְרִינָה.",
            exampleNative = "Техник надевает свинцовый жилет, чтобы защититься от קְרִינָה.",
            pos = "noun", semanticGroup = "science_physics_thermo", fillInBlankExclusions = listOf(189721L, 189722L, 189724L, 189725L)),

        WordEntity(id = 189724, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "צְמִיגוּת",
            translation = "вязкость",
            definition = "מִדַּת הָעָבִּיּוּת שֶׁל נוֹזֵל — עַד כַּמָּה הַשְּׁכָבוֹת הַפְּנִימִיּוֹת שֶׁלּוֹ מַפְרִיעוֹת זוֹ לְזוֹ בִּזְרִימָה.",
            definitionNative = "Степень густоты жидкости — насколько её внутренние слои тормозят друг друга при течении.",
            example = "לִדְבַשׁ קַר יֵשׁ צְמִיגוּת גְּבוֹהָה — לִשְׁפֹּךְ אוֹתוֹ זֶה כְּמוֹ גּוּמִי.",
            exampleNative = "У холодного мёда такая צְמִיגוּת, что лить — будто тянуть резину.",
            pos = "noun", semanticGroup = "science_physics_thermo", fillInBlankExclusions = listOf(189721L, 189722L, 189723L, 189725L)),

        WordEntity(id = 189725, setId = 1897, languagePair = "he-ru", rarity = "RARE",
            original = "הִתְאַדּוּת",
            translation = "испарение",
            definition = "מַעֲבָר שֶׁל נוֹזֵל לְמַצַּב גַּז עַל פְּנֵי הַשֶּׁטַח, בְּלִי שֶׁהוּא צָרִיךְ לְהַגִּיעַ לִנְקֻדַּת הָרְתִיחָה.",
            definitionNative = "Переход жидкости в газ на поверхности — без необходимости доходить до точки кипения.",
            example = "בְּקַיִץ יִשְׂרְאֵלִי הַכְּבִיסָה מִתְיַבֶּשֶׁת מַהֵר בִּגְלַל הִתְאַדּוּת.",
            exampleNative = "Израильским летом бельё сохнет быстро из-за הִתְאַדּוּת.",
            pos = "noun", semanticGroup = "science_physics_thermo", fillInBlankExclusions = listOf(189721L, 189722L, 189723L, 189724L)),
    )
}
