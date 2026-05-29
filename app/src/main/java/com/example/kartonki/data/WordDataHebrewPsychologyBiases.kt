package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1900 (he-ru).
 * Психология: когнитивные искажения и предубеждения (L4 / RARE + EPIC).
 *
 * Зеркало en-ru set 466. Расширение темы «Психология».
 * Подтема — конкретные именованные когнитивные искажения по работам
 * Канемана/Тверски и поведенческой экономики: confirmation bias, anchoring,
 * sunk cost fallacy, dunning-kruger effect, endowment effect и др.
 *
 * Пять семантических групп:
 *   psy_bias_memory   — confirmation, recency, hindsight, primacy, peak-end
 *   psy_bias_judgment — availability, base rate, gambler's, negativity, anchoring
 *   psy_bias_social   — herd, attribution error, self-serving, in-group, false consensus
 *   psy_bias_decision — sunk cost, status quo, endowment, IKEA, ostrich
 *   psy_bias_self     — Dunning-Kruger, optimism, planning, illusory correlation, survivorship
 *
 * Исключён из шорт-листа (дубль):
 *   - אֶפֶקְט הַהִילָה (halo effect) — ShoppingL5
 *   Заменён на אֶפֶקְט הָעֵדֶר (herd effect / стадный эффект).
 *
 * Word IDs: 190001..190025 (setId × 100 + position).
 */
object WordDataHebrewPsychologyBiases {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1900, languagePair = "he-ru", orderIndex = 1900,
            name = "Психология",
            description = "Когнитивные искажения и предубеждения: הֲטָיַת אִישּׁוּר, הֲטָיַת עִגּוּן, כֶּשֶׁל הָעֲלוּת הַשְׁקוּעָה, אֶפֶקְט דַּנִינְג-קְרוּגֶר",
            topic = "Психология",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: psy_bias_memory (5 words) ──────────────────────────────────

        WordEntity(id = 190001, setId = 1900, languagePair = "he-ru", rarity = "RARE",
            original = "הֲטָיַת אִישּׁוּר",
            translation = "склонность к подтверждению",
            definition = "נְטִיָּה לִשְׂים לֵב לָעֻבְדּוֹת שֶׁתּוֹמְכוֹת בְּעֶמְדָּתְךָ וּלְהִתְעַלֵּם מִכָּל מַה שֶּׁסּוֹתֵר אוֹתָהּ.",
            definitionNative = "Привычка замечать факты в поддержку своей позиции и обходить вниманием то, что ей мешает.",
            example = "הוּא קוֹרֵא רַק שְׁלוֹשָׁה אֲתָרִים שֶׁל דֵּעוֹתָיו — הֲטָיַת אִישּׁוּר טִיפּוּסִית.",
            exampleNative = "Он читает только три сайта своих взглядов — типичная הֲטָיַת אִישּׁוּר.",
            pos = "phrase", semanticGroup = "psy_bias_memory", fillInBlankExclusions = listOf(190002L, 190003L, 190004L, 190005L)),

        WordEntity(id = 190002, setId = 1900, languagePair = "he-ru", rarity = "RARE",
            original = "הֲטָיַת הָאַחֲרוֹנוּת",
            translation = "эффект недавности",
            definition = "נְטִיָּה לִזְכֹּר טוֹב יוֹתֵר אֶת מַה שֶּׁקָּרָה לָאַחֲרוֹנָה וְלִשְׁכֹּחַ מַה שֶּׁהָיָה קֹדֶם.",
            definitionNative = "Склонность лучше запоминать последнее по времени и забывать всё, что было раньше.",
            example = "הַמְּנַהֵל זָכַר רַק אֶת הַחֹדֶשׁ הָאַחֲרוֹן — הֲטָיַת הָאַחֲרוֹנוּת בַּהַעֲרָכָה.",
            exampleNative = "Менеджер помнил только последний месяц — הֲטָיַת הָאַחֲרוֹנוּת в оценке.",
            pos = "phrase", semanticGroup = "psy_bias_memory", fillInBlankExclusions = listOf(190001L, 190003L, 190004L, 190005L)),

        WordEntity(id = 190003, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "הֲטָיַת בְּדִיעֲבַד",
            translation = "ретроспективная иллюзия",
            definition = "תְּחוּשָׁה אַחֲרֵי מַעֲשֶׂה שֶׁתּוֹצָאָה הָיְתָה בְּרוּרָה מֵרֹאשׁ — «יָדַעְתִּי שֶׁכָּךְ יִקְרֶה».",
            definitionNative = "Ощущение задним числом, что исход был очевиден заранее — «я так и знал, что так будет».",
            example = "אַחֲרֵי הַמַּשְׁבֵּר כָּל הָאַנָּלִיסְטִים אָמְרוּ «רָאִינוּ» — הֲטָיַת בְּדִיעֲבַד טְהוֹרָה.",
            exampleNative = "После кризиса все аналитики говорили «мы видели» — чистая הֲטָיַת בְּדִיעֲבַד.",
            pos = "phrase", semanticGroup = "psy_bias_memory", fillInBlankExclusions = listOf(190001L, 190002L, 190004L, 190005L)),

        WordEntity(id = 190004, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶפֶקְט הָרִאשׁוֹנוּת",
            translation = "эффект первичности",
            definition = "נְטִיָּה לִזְכֹּר טוֹב יוֹתֵר אֶת הַפְּרִיטִים הָרִאשׁוֹנִים בִּסְדִרָה וְלִשְׁכֹּחַ אֶת אֶמְצַע הָרְשִׁימָה.",
            definitionNative = "Склонность лучше запоминать первые пункты в ряду и забывать середину списка.",
            example = "מוּעֲמָדִים שֶׁדִּבְּרוּ רִאשׁוֹנִים בָּרְאָיוֹן זָכוּ בְּיֶתֶר זְכִירָה — אֶפֶקְט הָרִאשׁוֹנוּת.",
            exampleNative = "Кандидатов, выступавших первыми, лучше запомнили — אֶפֶקְט הָרִאשׁוֹנוּת.",
            pos = "phrase", semanticGroup = "psy_bias_memory", fillInBlankExclusions = listOf(190001L, 190002L, 190003L, 190005L)),

        WordEntity(id = 190005, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "כְּלָל הַשִּׂיא וְהַסּוֹף",
            translation = "правило «пик-конец»",
            definition = "אֲנָשִׁים שׁוֹפְטִים חֲוָיָה לְפִי הָרֶגַע הָעַז בְּיוֹתֵר וְהָרֶגַע הָאַחֲרוֹן, וְלֹא לְפִי הַמְּמֻצָּע הַכּוֹלֵל.",
            definitionNative = "Люди судят о пережитом по самому острому моменту и самому последнему, а не по общему усреднению.",
            example = "כְּלָל הַשִּׂיא וְהַסּוֹף מַסְבִּיר לָמָּה כְּאֵב חַד בַּסּוֹף מַשְׁכִּיחַ שָׁעוֹת נוֹחוֹת.",
            exampleNative = "כְּלָל הַשִּׂיא וְהַסּוֹף объясняет, почему резкая боль в конце стирает память о часах покоя.",
            pos = "phrase", semanticGroup = "psy_bias_memory", fillInBlankExclusions = listOf(190001L, 190002L, 190003L, 190004L)),

        // ── Group: psy_bias_judgment (5 words) ────────────────────────────────

        WordEntity(id = 190006, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "הֶיוּרִיסְטִיקָה שֶׁל זְמִינוּת",
            translation = "эвристика доступности",
            definition = "שִׁפּוּט הִסְתַּבְּרוּת לְפִי הַקַּלּוּת שֶׁבָּהּ עוֹלֶה בָּרֹאשׁ דֻּגְמָה חַיָּה לָאֵרוּעַ.",
            definitionNative = "Оценка вероятности события по тому, насколько легко в голове всплывает яркий пример.",
            example = "כְּתָבָה אַחַת עַל כְּרִישׁ — הֶיוּרִיסְטִיקָה שֶׁל זְמִינוּת בְּפְּעֻלָּה.",
            exampleNative = "Один сюжет об акуле — и הֶיוּרִיסְטִיקָה שֶׁל זְמִינוּת уже работает.",
            pos = "phrase", semanticGroup = "psy_bias_judgment", fillInBlankExclusions = listOf(190007L, 190008L, 190009L, 190010L)),

        WordEntity(id = 190007, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "כֶּשֶׁל שִׁעוּר הַבָּסִיס",
            translation = "ошибка базовой частоты",
            definition = "מַתַּן מִשְׁקָל יֶתֶר לְמִקְרֶה פְּרָטִי חַי וְהִתְעַלְּמוּת מִכַּמָּה נָדִיר אוֹ שָׁכִיחַ הָאֵרוּעַ בָּאֻכְלוּסִיָּה.",
            definitionNative = "Чрезмерное доверие яркому частному случаю и невнимание к тому, насколько событие редко или часто в популяции.",
            example = "בְּדִיקָה חִיּוּבִית לְמַחֲלָה נְדִירָה הִיא לְרֹב אַזְעָקַת שָׁוְא — כֶּשֶׁל שִׁעוּר הַבָּסִיס.",
            exampleNative = "Положительный тест на редкую болезнь чаще всего ложный — כֶּשֶׁל שִׁעוּר הַבָּסִיס.",
            pos = "phrase", semanticGroup = "psy_bias_judgment", fillInBlankExclusions = listOf(190006L, 190008L, 190009L, 190010L)),

        WordEntity(id = 190008, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "כֶּשֶׁל הַמְּהַמֵּר",
            translation = "ошибка игрока",
            definition = "אֱמוּנָה שֶׁאַחֲרֵי רֶצֶף שֶׁל תּוֹצָאָה אַחַת תַּגִּיעַ הַתּוֹצָאָה הַהֲפוּכָה בִּיתֵר סִכּוּי בַּסִּבּוּב הַבָּא.",
            definitionNative = "Вера, что после серии одинаковых исходов на следующем розыгрыше выпадет противоположное.",
            example = "אַחֲרֵי חָמֵשׁ שְׁחוֹרוֹת בָּרוּלֶטָה הִכְפִּיל עַל אָדֹם — כֶּשֶׁל הַמְּהַמֵּר קְלָאסִי.",
            exampleNative = "После пяти чёрных он удвоил на красное — классический כֶּשֶׁל הַמְּהַמֵּר.",
            pos = "phrase", semanticGroup = "psy_bias_judgment", fillInBlankExclusions = listOf(190006L, 190007L, 190009L, 190010L)),

        WordEntity(id = 190009, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "הֲטָיָה שְׁלִילִית",
            translation = "негативное искажение",
            definition = "נְטִיָּה לִתֵּן מִשְׁקָל גָּדוֹל יוֹתֵר לְמֵידָע רַע מֵאֲשֶׁר לְמֵידָע טוֹב בְּעֹצֶם זֵהֶה.",
            definitionNative = "Склонность придавать плохой информации больший вес, чем хорошей той же силы.",
            example = "בִּקֹּרֶת אַחַת קְשָׁה זְכוּרָה יוֹתֵר מֵעֶשֶׂר מַחְמָאוֹת — הֲטָיָה שְׁלִילִית.",
            exampleNative = "Один резкий отзыв запоминается лучше десяти похвал — הֲטָיָה שְׁלִילִית.",
            pos = "phrase", semanticGroup = "psy_bias_judgment", fillInBlankExclusions = listOf(190006L, 190007L, 190008L, 190010L)),

        WordEntity(id = 190010, setId = 1900, languagePair = "he-ru", rarity = "RARE",
            original = "הֲטָיַת עִגּוּן",
            translation = "якорный эффект",
            definition = "הִיצָּמְדוּת לַמִּסְפָּר אוֹ לָעֻבְדָּה הָרִאשׁוֹנָה שֶׁשּׁוֹמְעִים וְשִׁפּוּט כָּל מַה שֶּׁבָּא אַחֲרֶיהָ מוּלָהּ.",
            definitionNative = "Прицепление к первому услышанному числу или факту и оценка всего последующего относительно него.",
            example = "תִּמְחוּר סַפָּה בְּתִשַׁע מֵאוֹת הוֹפֵךְ אַרְבַּע מֵאוֹת לְזוֹל — הֲטָיַת עִגּוּן.",
            exampleNative = "Цена дивана девятьсот делает четыреста «дёшево» — הֲטָיַת עִגּוּן.",
            pos = "phrase", semanticGroup = "psy_bias_judgment", fillInBlankExclusions = listOf(190006L, 190007L, 190008L, 190009L)),

        // ── Group: psy_bias_social (5 words) ──────────────────────────────────

        WordEntity(id = 190011, setId = 1900, languagePair = "he-ru", rarity = "RARE",
            original = "אֶפֶקְט הָעֵדֶר",
            translation = "стадный эффект",
            definition = "נְטִיָּה לְאַמֵּץ דֵּעוֹת אוֹ הִתְנַהֲגוּת שֶׁל קְבוּצָה גְּדוֹלָה רַק כִּי הַסְּבִיבָה עוֹשָׂה אֶת זֶה.",
            definitionNative = "Склонность перенимать мнения или поведение большой группы только потому, что так делают окружающие.",
            example = "כָּל הָעוֹלָם קָנָה אֶת הַמְּנָיָה וְהוּא קָפַץ אַחֲרֵיהֶם — אֶפֶקְט הָעֵדֶר.",
            exampleNative = "Все скупали акцию, и он прыгнул следом — אֶפֶקְט הָעֵדֶר.",
            pos = "phrase", semanticGroup = "psy_bias_social", fillInBlankExclusions = listOf(190012L, 190013L, 190014L, 190015L)),

        WordEntity(id = 190012, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "שְׁגִיאַת יִחוּס בְּסִיסִית",
            translation = "фундаментальная ошибка атрибуции",
            definition = "נְטִיָּה לְהַסְבִּיר הִתְנַהֲגוּת שֶׁל אַחֵר בְּאִישִׁיּוּתוֹ וְלִשְׁכֹּחַ אֶת הַנְּסִבּוֹת שֶׁלָּחֲצוּ עָלָיו.",
            definitionNative = "Склонность объяснять чужое поведение характером человека и забывать про обстоятельства, которые на него давили.",
            example = "הוּא אִחֵר וְכוּלָּם חָשְׁבוּ «עַצְלָן» בְּלִי לִשְׁאֹל עַל הַפְּקָק — שְׁגִיאַת יִחוּס בְּסִיסִית.",
            exampleNative = "Он опоздал, и все решили «лентяй», не спросив про пробку — שְׁגִיאַת יִחוּס בְּסִיסִית.",
            pos = "phrase", semanticGroup = "psy_bias_social", fillInBlankExclusions = listOf(190011L, 190013L, 190014L, 190015L)),

        WordEntity(id = 190013, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "הֲטָיָה שֶׁל שֵׁרוּת עַצְמִי",
            translation = "корыстная атрибуция",
            definition = "יִחוּס הַצְלָחוֹת לְכִשְׁרוֹנוֹ הָאִישִׁי וְהַטָּלַת כִּשְׁלוֹנוֹת עַל מַזָּל רַע אוֹ אֲנָשִׁים אֲחֵרִים.",
            definitionNative = "Объяснение успехов личным талантом и сваливание неудач на невезение или других людей.",
            example = "זָכָה — «הָיִיתִי טוֹב»; הִפְסִיד — «הַשּׁוֹפֵט גָּנַב» — הֲטָיָה שֶׁל שֵׁרוּת עַצְמִי.",
            exampleNative = "Выиграл — «я молодец»; проиграл — «судья украл» — הֲטָיָה שֶׁל שֵׁרוּת עַצְמִי.",
            pos = "phrase", semanticGroup = "psy_bias_social", fillInBlankExclusions = listOf(190011L, 190012L, 190014L, 190015L)),

        WordEntity(id = 190014, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "הֲטָיַת קְבוּצַת פְּנִים",
            translation = "ингрупповой фаворитизм",
            definition = "נְטִיָּה לְהַעֲדִיף בְּנֵי הַקְּבוּצָה שֶׁלְּךָ וְלִשְׁפֹּט אוֹתָם בְּקַלּוּת רַבָּה יוֹתֵר מֵאֲנָשִׁים זָרִים.",
            definitionNative = "Склонность отдавать предпочтение своим и судить о них мягче, чем о чужих.",
            example = "הַמְּנַהֵל מְקַדֵּם בּוֹגְרֵי אוֹתָהּ אוּנִיבֶרְסִיטָה — הֲטָיַת קְבוּצַת פְּנִים בְּגִיּוּס.",
            exampleNative = "Начальник продвигает выпускников своего вуза — הֲטָיַת קְבוּצַת פְּנִים при найме.",
            pos = "phrase", semanticGroup = "psy_bias_social", fillInBlankExclusions = listOf(190011L, 190012L, 190013L, 190015L)),

        WordEntity(id = 190015, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶפֶקְט הַקּוֹנְסֶנְזוּס הַשָּׁקְרִי",
            translation = "иллюзия ложного консенсуса",
            definition = "אֲנָשִׁים מַעֲרִיכִים יֶתֶר עַל הַמִּדָּה כַּמָּה אֲחֵרִים מַסְכִּימִים עִם דֵּעוֹתֵיהֶם אוֹ עוֹשִׂים אוֹתָם דְּבָרִים.",
            definitionNative = "Люди завышают долю окружающих, разделяющих их мнение или поступающих так же, как они.",
            example = "הוּא הָיָה בָּטוּחַ שֶׁכֻּלָּם נֶגֶד הַחֹק — אֶפֶקְט הַקּוֹנְסֶנְזוּס הַשָּׁקְרִי.",
            exampleNative = "Он был уверен, что все против закона — אֶפֶקְט הַקּוֹנְסֶנְזוּס הַשָּׁקְרִי.",
            pos = "phrase", semanticGroup = "psy_bias_social", fillInBlankExclusions = listOf(190011L, 190012L, 190013L, 190014L)),

        // ── Group: psy_bias_decision (5 words) ────────────────────────────────

        WordEntity(id = 190016, setId = 1900, languagePair = "he-ru", rarity = "RARE",
            original = "כֶּשֶׁל הָעֲלוּת הַשְׁקוּעָה",
            translation = "ошибка невозвратных издержек",
            definition = "הִתְמַדַּת בְּפְּרוֹיֶקְט גָּרוּעַ רַק כְּדֵי לֹא לְבַזְבֵּז אֶת הַזְּמַן וְהַכֶּסֶף שֶׁכְּבָר הוּשְׁקְעוּ.",
            definitionNative = "Продолжение провального проекта только ради того, чтобы не пропали уже потраченные время и деньги.",
            example = "אַחֲרֵי שָׁלוֹשׁ נְפִילוֹת הוּא הִמְשִׁיךְ לְהַשְׁקִיעַ — כֶּשֶׁל הָעֲלוּת הַשְׁקוּעָה קְלָאסִי.",
            exampleNative = "После трёх провалов он продолжал вкладываться — классический כֶּשֶׁל הָעֲלוּת הַשְׁקוּעָה.",
            pos = "phrase", semanticGroup = "psy_bias_decision", fillInBlankExclusions = listOf(190017L, 190018L, 190019L, 190020L)),

        WordEntity(id = 190017, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "הֲטָיַת סְטָטוּס קְוֹו",
            translation = "склонность к статус-кво",
            definition = "הַעֲדָפַת הַמַּצָּב הַקַּיָּם פָּשׁוּט מִשּׁוּם שֶׁהוּא קַיָּם — גַּם כְּשֶׁאַלְטֶרְנָטִיבָה עֲדִיפָה זְמִינָה.",
            definitionNative = "Предпочтение текущего положения просто потому, что оно есть — даже когда доступна объективно лучшая альтернатива.",
            example = "הִיא לֹא הֶחְלִיפָה קֻפַּת חוֹלִים יְקָרָה שָׁנִים — הֲטָיַת סְטָטוּס קְוֹו.",
            exampleNative = "Она годами не меняла дорогую кассу — הֲטָיַת סְטָטוּס קְוֹו.",
            pos = "phrase", semanticGroup = "psy_bias_decision", fillInBlankExclusions = listOf(190016L, 190018L, 190019L, 190020L)),

        WordEntity(id = 190018, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶפֶקְט הַהַעֲנָקָה",
            translation = "эффект владения",
            definition = "אֲנָשִׁים מְבַקְּשִׁים מְחִיר גָּבוֹהַּ עַל חֵפֶץ שֶׁלָּהֶם מֵאֲשֶׁר הָיוּ מוּכָנִים לְשַׁלֵּם עַל אוֹתוֹ חֵפֶץ עַצְמוֹ.",
            definitionNative = "Люди требуют за свой предмет более высокую цену, чем готовы заплатить за тот же самый предмет.",
            example = "הוּא בִּקֵּשׁ עַל הָרֶכֶב פִּי שְׁנַיִם מֵהַשּׁוּק — אֶפֶקְט הַהַעֲנָקָה.",
            exampleNative = "Он просил за машину вдвое больше рынка — אֶפֶקְט הַהַעֲנָקָה.",
            pos = "phrase", semanticGroup = "psy_bias_decision", fillInBlankExclusions = listOf(190016L, 190017L, 190019L, 190020L)),

        WordEntity(id = 190019, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶפֶקְט IKEA",
            translation = "эффект IKEA",
            definition = "אֲנָשִׁים מַעֲרִיכִים יֶתֶר עַל הַמִּדָּה דְּבָרִים שֶׁהֵם הִרְכִּיבוּ אוֹ יָצְרוּ בְּעַצְמָם.",
            definitionNative = "Люди завышают ценность вещей, которые они собрали или сделали своими руками.",
            example = "הַשֻּׁלְחָן הָרָעוּעַ יָקָר לוֹ כִּי הִרְכִּיב אוֹתוֹ לְבַד — אֶפֶקְט IKEA.",
            exampleNative = "Шаткий стол ему дорог, потому что собирал сам — אֶפֶקְט IKEA.",
            pos = "phrase", semanticGroup = "psy_bias_decision", fillInBlankExclusions = listOf(190016L, 190017L, 190018L, 190020L)),

        WordEntity(id = 190020, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶפֶקְט הַיַּעֵן",
            translation = "эффект страуса",
            definition = "הִתְעַלְּמוּת מְכֻוֶּנֶת מִמֵּידָע שְׁלִילִי — אַל תִּפְתַּח אֶת הַחֶשְׁבּוֹן כְּדֵי לֹא לִרְאוֹת הֶפְסֵד.",
            definitionNative = "Намеренное игнорирование плохой информации — не открывать счёт, чтобы не видеть убыток.",
            example = "הוּא לֹא בָּדַק תִּיק הַשְׁקָעוֹת חֲצִי שָׁנָה — אֶפֶקְט הַיַּעֵן בַּמַּשְׁבֵּר.",
            exampleNative = "Полгода он не смотрел инвестпортфель — אֶפֶקְט הַיַּעֵן в кризис.",
            pos = "phrase", semanticGroup = "psy_bias_decision", fillInBlankExclusions = listOf(190016L, 190017L, 190018L, 190019L)),

        // ── Group: psy_bias_self (5 words) ────────────────────────────────────

        WordEntity(id = 190021, setId = 1900, languagePair = "he-ru", rarity = "RARE",
            original = "אֶפֶקְט דַּנִינְג-קְרוּגֶר",
            translation = "эффект Даннинга-Крюгера",
            definition = "מַתְחִילִים בְּלִי יֶדַע מַעֲרִיכִים אֶת יְכָלְתָּם גָּבוֹהַּ, מֻמְחִים אֲמִתִּיִּים — דַּוְקָא צְנוּעִים מֵרֹב מוּדָעוּת.",
            definitionNative = "Новички без знаний оценивают свои способности высоко, а настоящие специалисты — наоборот, скромны от понимания глубины.",
            example = "אַחֲרֵי שִׁעוּר אֶחָד הוּא קָרָא לְעַצְמוֹ סַייְבֶּר-מֻמְחֶה — אֶפֶקְט דַּנִינְג-קְרוּגֶר.",
            exampleNative = "После одного урока он назвался кибер-экспертом — אֶפֶקְט דַּנִינְג-קְרוּגֶר.",
            pos = "phrase", semanticGroup = "psy_bias_self", fillInBlankExclusions = listOf(190022L, 190023L, 190024L, 190025L)),

        WordEntity(id = 190022, setId = 1900, languagePair = "he-ru", rarity = "RARE",
            original = "הֲטָיַת אוֹפְטִימִיזְם",
            translation = "склонность к оптимизму",
            definition = "אֲנָשִׁים מַעֲרִיכִים שֶׁדְּבָרִים רָעִים יִקְרוּ דַּוְקָא לָאֲחֵרִים וְלֹא לָהֶם.",
            definitionNative = "Люди считают, что плохое случится скорее с другими, а не с ними.",
            example = "הוּא נָהַג בְּלִי חֲגוֹרָה — «לִי זֶה לֹא יִקְרֶה» — הֲטָיַת אוֹפְטִימִיזְם.",
            exampleNative = "Он ездил без ремня — «со мной не случится» — הֲטָיַת אוֹפְטִימִיזְם.",
            pos = "phrase", semanticGroup = "psy_bias_self", fillInBlankExclusions = listOf(190021L, 190023L, 190024L, 190025L)),

        WordEntity(id = 190023, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "כֶּשֶׁל הַתִּכְנוּן",
            translation = "ошибка планирования",
            definition = "אֲנָשִׁים מַעֲרִיכִים זְמַן שֶׁל מְשִׂימָה נְמוּךְ מִדַּי גַּם כְּשֶׁמְּשִׂימוֹת דּוֹמוֹת בֶּעָבָר תָּמִיד אָרְכוּ יוֹתֵר.",
            definitionNative = "Люди ставят на задачу слишком короткие сроки, даже когда такие же задачи в прошлом всегда занимали больше.",
            example = "הוּא הִבְטִיחַ לִסַיֵּם בְּשָׁבוּעַ וְנִתְקַעַ לְחֹדֶשׁ — כֶּשֶׁל הַתִּכְנוּן.",
            exampleNative = "Он обещал закрыть за неделю, а застрял на месяц — כֶּשֶׁל הַתִּכְנוּן.",
            pos = "phrase", semanticGroup = "psy_bias_self", fillInBlankExclusions = listOf(190021L, 190022L, 190024L, 190025L)),

        WordEntity(id = 190024, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "מִתְאָם מְדוּמֶּה",
            translation = "иллюзорная корреляция",
            definition = "תְּחוּשָׁה שֶׁשְּׁנֵי דְּבָרִים מְקֻשָּׁרִים זֶה לָזֶה גַּם כְּשֶׁאֵין בֵּינֵיהֶם שׁוּם קֶשֶׁר אֲמִתִּי.",
            definitionNative = "Ощущение связи между двумя явлениями там, где на деле никакой связи нет.",
            example = "הוּא לָבַשׁ אוֹתָהּ חֻלְצָה בְּכָל מִשְׂחָק זָכוּי — מִתְאָם מְדוּמֶּה טִיפּוּסִי.",
            exampleNative = "Он надевал ту же футболку на каждый выигранный матч — типичный מִתְאָם מְדוּמֶּה.",
            pos = "phrase", semanticGroup = "psy_bias_self", fillInBlankExclusions = listOf(190021L, 190022L, 190023L, 190025L)),

        WordEntity(id = 190025, setId = 1900, languagePair = "he-ru", rarity = "EPIC",
            original = "הֲטָיַת הַשּׂוֹרְדִים",
            translation = "ошибка выжившего",
            definition = "מַסִּיקִים עַל הַצְלָחָה רַק מֵהַזּוֹכִים וּמַתְעַלְּמִים מֵהָרֹב הֶעָצוּם שֶׁנִּכְשַׁל בְּשֶׁקֶט.",
            definitionNative = "Выводят правила успеха только по победителям и не учитывают огромное большинство, провалившееся тихо.",
            example = "סִפּוּרֵי מִילְיַארְדֵרִים מַסְתִּירִים אַלְפֵי כִּשְׁלוֹנוֹת — הֲטָיַת הַשּׂוֹרְדִים.",
            exampleNative = "Истории миллиардеров скрывают тысячи провалов — הֲטָיַת הַשּׂוֹרְדִים.",
            pos = "phrase", semanticGroup = "psy_bias_self", fillInBlankExclusions = listOf(190021L, 190022L, 190023L, 190024L)),
    )
}
