package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1905 (he-ru).
 * Религия и праздники: Шабат — церемонии, предметы и порядок
 *   (L3 / RARE + EPIC).
 *
 * Точечное расширение темы «Религия и праздники». Подтема — конкретный
 * порядок Шабата: вечерняя встреча и проводы, молитвенный сэдэр,
 * ритуальные предметы, трапезы и законы мукцэ/эрув.
 * Это НЕ зеркало en-ru: на иврите тема Шабата прорабатывается глубже,
 * так как русскоговорящему репатрианту лексика традиции нужна на бытовом
 * уровне (свечи в пятницу, киддуш у стола, hавдала в субботу вечером).
 *
 * Базовая лексика темы (שַׁבָּת, חַלָּה, קִדּוּשׁ, הַבְדָּלָה, נֵר שַׁבָּת,
 * הַדְלָקַת נֵרוֹת, קַבָּלַת שַׁבָּת) уже занята более ранними сетами темы
 * (RelHolidaysL1, ReligionL1, RelHolidaysL5, Immigrant4, Batch10/16/50/83).
 * Этот сет берёт **сопутствующую** лексику — то, что окружает базовые
 * термины, не дублируя их.
 *
 * Исключены как дубли с существующими he-ru сетами темы:
 *   - שַׁבָּת, חַלָּה, קִדּוּשׁ, הַבְדָּלָה, נֵר שַׁבָּת, הַדְלָקַת נֵרוֹת,
 *     קַבָּלַת שַׁבָּת — Batch10/16/50/83, RelHolidaysL1/L5, Immigrant4/6,
 *     ReligionL1 → заменено на сопутствующие термины (לֶכָה דוֹדִי вместо
 *     קַבָּלַת שַׁבָּת, קִדּוּשָׁא רַבָּא вместо קִדּוּשׁ, נֵר הַבְדָּלָה
 *     вместо הַבְדָּלָה, לֶחֶם מִשְׁנֶה вместо חַלָּה).
 *   - שַׁחֲרִית (Batch83 в значении «утренняя заря») — взят מוּסָף и
 *     פַּרְשַׁת הַשָּׁבוּעַ как часть утреннего сэдэра.
 *   - הַפְטָרָה, סִדּוּר, מַחֲזוֹר, סֵפֶר תּוֹרָה, בִּימָה, אֵשֶׁת חַיִל,
 *     נְטִילַת יָדַיִם, בִּרְכַּת הַמָּזוֹן, מוֹצָאֵי שַׁבָּת, זְמִירוֹת
 *     שַׁבָּת — уже в Batch10/16/50/83, заменены неперекрывающимися
 *     терминами (שָׁלוֹם עֲלֵיכֶם, דְּבַר תּוֹרָה, צֵאת הַשַּׁבָּת).
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   RARE — 13 слов (B2, общеизвестные среди практикующих традицию:
 *          лэха доди, шалом алейхем, маарив, мусаф, криат hа-тора,
 *          паршат hа-шавуа, бэсамим, кос кидуш, сэудат шабат, онэг
 *          шабат, мэлаха, цет hа-шабат, шмират шабат).
 *   EPIC — 12 слов (C1, более узкая или раввинская лексика: кидуша
 *          раба, нэр hавдала, тосэфэт шабат, минха, памот, мапат хала,
 *          лэхэм мишнэ, сэуда шлишит, мэлавэ малка, двар тора, мукцэ,
 *          эрув).
 *
 * Пять семантических подгрупп:
 *   religion_shabbat_ceremonies — 5 слов: встреча и проводы Шабата
 *   religion_shabbat_prayers    — 5 слов: молитвенный сэдэр субботы
 *   religion_shabbat_objects    — 5 слов: ритуальные предметы стола
 *   religion_shabbat_meals      — 5 слов: трапезы и атмосфера дня
 *   religion_shabbat_laws       — 5 слов: законы и понятия Шабата
 *
 * Word IDs: 190501..190525 (setId × 100 + position).
 */
object WordDataHebrewReligionShabbat {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1905, languagePair = "he-ru", orderIndex = 1905,
            name = "Религия и праздники",
            description = "Шабат изнутри: гимны встречи (לֶכָה דוֹדִי, שָׁלוֹם עֲלֵיכֶם), сэдэр молитв (מוּסָף, מִנְחָה, פַּרְשַׁת הַשָּׁבוּעַ), стол (לֶחֶם מִשְׁנֶה, בְּשָׂמִים), законы (מוּקְצֶה, עֵירוּב)",
            topic = "Религия и праздники",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: religion_shabbat_ceremonies (5 words) ──────────────────────

        WordEntity(id = 190501, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "לֶכָה דוֹדִי",
            translation = "лэха доди (гимн встречи Шабата)",
            definition = "פִּיּוּט מֵהַמֵּאָה הַ-16 שֶׁשָּׁרִים בַּעֲרֶב שִׁשִּׁי כְּדֵי לְקַבֵּל אֶת פְּנֵי הַכַּלָּה.",
            definitionNative = "Пиют XVI века, который поют в пятницу вечером, выходя навстречу Невесте.",
            example = "הַקְּהִילָּה פָּצְחָה בְּלֶכָה דוֹדִי וּפָנְתָה אֶל פֶּתַח בֵּית הַכְּנֶסֶת.",
            exampleNative = "Община запела לֶכָה דוֹדִי и обернулась ко входу в синагогу.",
            pos = "phrase", semanticGroup = "religion_shabbat_ceremonies", fillInBlankExclusions = listOf(190502L, 190503L, 190504L, 190505L)),

        WordEntity(id = 190502, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "שָׁלוֹם עֲלֵיכֶם",
            translation = "шалом алейхем (гимн ангелам)",
            definition = "זֶמֶר שֶׁבּוֹ מְבָרְכִים אֶת מַלְאֲכֵי הַשָּׁרֵת שֶׁמְּלַוִּים אֶת הָאָב מִבֵּית הַכְּנֶסֶת הַבַּיְתָה.",
            definitionNative = "Песня, которой приветствуют ангелов служения, провожающих отца из синагоги домой.",
            example = "אַחֲרֵי שָׁלוֹם עֲלֵיכֶם הָאָב הִתְיַשֵּׁב לְקַדֵּשׁ עַל הַיַּיִן.",
            exampleNative = "После שָׁלוֹם עֲלֵיכֶם отец сел освящать вино.",
            pos = "phrase", semanticGroup = "religion_shabbat_ceremonies", fillInBlankExclusions = listOf(190501L, 190503L, 190504L, 190505L, 190506L)),

        WordEntity(id = 190503, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "קִדּוּשָׁא רַבָּא",
            translation = "большой утренний кидуш",
            definition = "טֶקֶס קָצָר עַל הַיַּיִן בְּבֹקֶר שֶׁל שִׁשִּׁי לַחֹדֶשׁ, לִפְנֵי הָאֲרוּחָה הַשְּׁנִיָּה שֶׁל הַיּוֹם.",
            definitionNative = "Краткий обряд над вином в субботнее утро, перед второй дневной трапезой.",
            example = "אַחֲרֵי הַתְּפִילָּה הָאוֹרֵחַ עָשָׂה קִדּוּשָׁא רַבָּא עַל כּוֹסִית.",
            exampleNative = "После молитвы гость произнёс קִדּוּשָׁא רַבָּא над рюмкой.",
            pos = "phrase", semanticGroup = "religion_shabbat_ceremonies", fillInBlankExclusions = listOf(190501L, 190502L, 190504L, 190505L)),

        WordEntity(id = 190504, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "נֵר הַבְדָּלָה",
            translation = "свеча проводов Шабата",
            definition = "נֵר שָׁזוּר מִכַּמָּה פְּתִילוֹת שֶׁמַּדְלִיקִים בְּצֵאת הַיּוֹם הַשְּׁבִיעִי.",
            definitionNative = "Витая свеча из нескольких фитилей, которую зажигают на исходе седьмого дня.",
            example = "הַיֶּלֶד אָחַז נֵר הַבְדָּלָה גָּבוֹהַ מֵעַל הַשֻּׁלְחָן.",
            exampleNative = "Мальчик держал נֵר הַבְדָּלָה высоко над столом.",
            pos = "phrase", semanticGroup = "religion_shabbat_ceremonies", fillInBlankExclusions = listOf(190501L, 190502L, 190503L, 190505L, 190511L, 190512L, 190514L)),

        WordEntity(id = 190505, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "תּוֹסֶפֶת שַׁבָּת",
            translation = "удлинение Шабата",
            definition = "מִנְהָג לִקְבֹּעַ אֶת תְּחִלַּת הַיּוֹם הַשְּׁבִיעִי מְעַט לִפְנֵי הַשְּׁקִיעָה וְלִסְיֵּם אַחֲרֵי צֵאת הַכּוֹכָבִים.",
            definitionNative = "Обычай начинать седьмой день немного до заката и заканчивать после появления звёзд.",
            example = "הַמִּשְׁפָּחָה שׁוֹמֶרֶת תּוֹסֶפֶת שַׁבָּת שֶׁל רֶבַע שָׁעָה כָּל שִׁשִּׁי.",
            exampleNative = "Семья каждую пятницу соблюдает תּוֹסֶפֶת שַׁבָּת в четверть часа.",
            pos = "phrase", semanticGroup = "religion_shabbat_ceremonies", fillInBlankExclusions = listOf(190501L, 190502L, 190503L, 190504L)),

        // ── Group: religion_shabbat_prayers (5 words) ─────────────────────────

        WordEntity(id = 190506, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "מַעֲרִיב",
            translation = "вечерняя молитва",
            definition = "סֵדֶר תְּפִילָּה שֶׁל הַלַּיְלָה הַנֶּאֱמָר אַחֲרֵי שְׁקִיעַת הַחַמָּה.",
            definitionNative = "Ночной молитвенный чин, который произносят после захода солнца.",
            example = "הָאָב נִכְנַס לְבֵית הַכְּנֶסֶת לְמַעֲרִיב מִיָּד אַחֲרֵי הַסְּעוּדָה.",
            exampleNative = "Отец зашёл в синагогу на מַעֲרִיב сразу после ужина.",
            pos = "noun", semanticGroup = "religion_shabbat_prayers", fillInBlankExclusions = listOf(190507L, 190508L)),

        WordEntity(id = 190507, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "מִנְחָה",
            translation = "послеполуденная молитва",
            definition = "סֵדֶר תְּפִילָּה שֶׁל אַחַר הַצָּהֳרַיִם, בֵּין הַשָּׁעָה הָרְבִיעִית לִשְׁקִיעָה.",
            definitionNative = "Послеполуденный молитвенный чин — между четвёртым часом дня и закатом.",
            example = "הִיא הִגִּיעָה לְמִנְחָה בְּדִיּוּק לִפְנֵי שֶׁסָּגְרוּ אֶת הַדְּלָתוֹת.",
            exampleNative = "Она пришла на מִנְחָה прямо перед тем, как закрыли двери.",
            pos = "noun", semanticGroup = "religion_shabbat_prayers", fillInBlankExclusions = listOf(190506L, 190508L)),

        WordEntity(id = 190508, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "מוּסָף",
            translation = "дополнительная субботняя молитва",
            definition = "סֵדֶר תְּפִילָּה מְיֻחָד לְשַׁבָּת וְלַחַגִּים, נֶאֱמָר מִיָּד אַחֲרֵי קְרִיאַת הַתּוֹרָה.",
            definitionNative = "Особый молитвенный чин субботы и праздников, читаемый сразу после чтения Торы.",
            example = "אַחֲרֵי מוּסָף הַקְּהִילָּה יָצְאָה לְקִדּוּשׁ בָּאוּלָם.",
            exampleNative = "После מוּסָף община вышла на угощение в зал.",
            pos = "noun", semanticGroup = "religion_shabbat_prayers", fillInBlankExclusions = listOf(190501L, 190502L, 190506L, 190507L, 190509L)),

        WordEntity(id = 190509, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "קְרִיאַת הַתּוֹרָה",
            translation = "чтение Торы",
            definition = "מַעֲמָד שֶׁבּוֹ קוֹרְאִים מִתּוֹךְ הַמְּגִילָּה הַקְּדוּשָׁה לְפִי חֲלוּקַת הַשָּׁבוּעוֹת.",
            definitionNative = "Действо, во время которого читают из священного свитка по недельной разбивке.",
            example = "בְּזְמַן קְרִיאַת הַתּוֹרָה הַיֶּלֶד עָמַד לְיַד הָאָב.",
            exampleNative = "Во время קְרִיאַת הַתּוֹרָה мальчик стоял рядом с отцом.",
            pos = "phrase", semanticGroup = "religion_shabbat_prayers", fillInBlankExclusions = listOf(190501L, 190502L, 190503L, 190506L, 190507L, 190508L, 190510L, 190516L, 190517L, 190519L, 190520L)),

        WordEntity(id = 190510, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "פַּרְשַׁת הַשָּׁבוּעַ",
            translation = "недельная глава Торы",
            definition = "קֶטַע קָבוּעַ מֵחֲמֵשֶׁת הַסְּפָרִים שֶׁמַּתְאִים לַשָּׁבוּעַ הַנּוֹכְחִי בִּלְבַד.",
            definitionNative = "Фиксированный отрывок из Пятикнижия, привязанный именно к текущей неделе года.",
            example = "פַּרְשַׁת הַשָּׁבוּעַ הַזּוֹ מְסַפֶּרֶת עַל יְצִיאַת מִצְרַיִם.",
            exampleNative = "פַּרְשַׁת הַשָּׁבוּעַ этой недели рассказывает об исходе из Египта.",
            pos = "phrase", semanticGroup = "religion_shabbat_prayers"),

        // ── Group: religion_shabbat_objects (5 words) ─────────────────────────

        WordEntity(id = 190511, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "בְּשָׂמִים",
            translation = "благовония для hавдалы",
            definition = "תַּעֲרֹבֶת צְמָחִים רֵיחָנִיִּים שֶׁמַּרְחִיקִים אֶת הָעֶצֶב אַחֲרֵי צֵאת הַיּוֹם הַקָּדוֹשׁ.",
            definitionNative = "Смесь душистых трав, которой отгоняют печаль после исхода святого дня.",
            example = "הַסַּבְתָּא הִגִּישָׁה קֻפְסַת בְּשָׂמִים סְבִיב הַשֻּׁלְחָן.",
            exampleNative = "Бабушка пустила коробочку בְּשָׂמִים по кругу стола.",
            pos = "noun", semanticGroup = "religion_shabbat_objects", fillInBlankExclusions = listOf(190512L)),

        WordEntity(id = 190512, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "פָּמוֹט",
            translation = "подсвечник",
            definition = "כְּלִי כֶּסֶף אוֹ פִּלָדָה שֶׁמַּחֲזִיק אֶת הַנֵּרוֹת לַעֲרֶב שִׁשִּׁי.",
            definitionNative = "Серебряный или стальной сосуд, держащий свечи для пятничного вечера.",
            example = "פָּמוֹט עָבָר בִּירוּשָּׁה מִסַּבְתָּא בְּפּוֹלִין.",
            exampleNative = "פָּמוֹט достался по наследству от бабушки из Польши.",
            pos = "noun", semanticGroup = "religion_shabbat_objects", fillInBlankExclusions = listOf(190511L, 190513L, 190514L)),

        WordEntity(id = 190513, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "מַפַּת חַלָּה",
            translation = "покрытие для халы",
            definition = "בַּד רָקוּם שֶׁמְּכַסֶּה אֶת הַלֶּחֶם עַל הַשֻּׁלְחָן בֵּין הַדְלָקַת הַנֵּרוֹת לַקִּדּוּשׁ.",
            definitionNative = "Вышитая ткань, накрывающая хлеб на столе в промежутке между зажиганием и киддушем.",
            example = "מַפַּת חַלָּה לְבָנָה הִתְנַעְנְעָה כְּשֶׁפָּתְחוּ אֶת הַחַלּוֹן.",
            exampleNative = "Белая מַפַּת חַלָּה колыхнулась, когда открыли окно.",
            pos = "phrase", semanticGroup = "religion_shabbat_objects", fillInBlankExclusions = listOf(190514L, 190515L)),

        WordEntity(id = 190514, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "כּוֹס קִדּוּשׁ",
            translation = "бокал для кидуша",
            definition = "כּוֹסִית מְיֻחֶדֶת, בְּדֶרֶךְ כְּלָל מִכֶּסֶף, שֶׁמְּמַלְּאִים בְּיַיִן לִבְרָכָה.",
            definitionNative = "Особая чарка, обычно серебряная, которую наполняют вином для благословения.",
            example = "אַבָּא הִגְבִּיהַ אֶת כּוֹס קִדּוּשׁ מֵעַל לַשֻּׁלְחָן.",
            exampleNative = "Папа поднял כּוֹס קִדּוּשׁ над столом.",
            pos = "phrase", semanticGroup = "religion_shabbat_objects"),

        WordEntity(id = 190515, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "לֶחֶם מִשְׁנֶה",
            translation = "две халы на трапезу",
            definition = "זוּג כִּכָּרוֹת מְלוּחוֹת שֶׁמַּנִּיחִים תַּחַת הַמַּפָּה לְזֵכֶר הַמָּן הַכָּפוּל.",
            definitionNative = "Пара круглых хлебов, которые кладут под скатерть в память о двойной порции манны.",
            example = "הוּא בָּצַע לֶחֶם מִשְׁנֶה וְחִלֵּק לַכֻּלָּם.",
            exampleNative = "Он надломил לֶחֶם מִשְׁנֶה и раздал всем за столом.",
            pos = "phrase", semanticGroup = "religion_shabbat_objects", fillInBlankExclusions = listOf(190513L, 190514L)),

        // ── Group: religion_shabbat_meals (5 words) ───────────────────────────

        WordEntity(id = 190516, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "סְעוּדַת שַׁבָּת",
            translation = "субботняя трапеза",
            definition = "אֲרוּחָה חֲגִיגִית שֶׁל הָעֶרֶב הַשִּׁשִּׁי, עִם דָּגִים, בָּשָׂר וְשִׁירָה סְבִיב הַשֻּׁלְחָן.",
            definitionNative = "Праздничный ужин в пятницу вечером — с рыбой, мясом и пением вокруг стола.",
            example = "לִסְעוּדַת שַׁבָּת אֶצְלָם תָּמִיד מַזְמִינִים שְׁכֵנִים.",
            exampleNative = "На סְעוּדַת שַׁבָּת у них всегда зовут соседей.",
            pos = "phrase", semanticGroup = "religion_shabbat_meals", fillInBlankExclusions = listOf(190517L, 190518L, 190519L, 190520L)),

        WordEntity(id = 190517, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "סְעוּדָה שְׁלִישִׁית",
            translation = "третья трапеза",
            definition = "אֲרוּחָה קַלָּה שֶׁל אַחַר הַצָּהֳרַיִם, בֵּין מִנְחָה לְצֵאת הַכּוֹכָבִים.",
            definitionNative = "Лёгкое застолье во второй половине дня, между послеполуденной молитвой и появлением звёзд.",
            example = "בַּסְּעוּדָה שְׁלִישִׁית הִגִּישׁוּ דָּג כָּבוּשׁ וְסָלָט.",
            exampleNative = "На סְעוּדָה שְׁלִישִׁית подали маринованную рыбу и салат.",
            pos = "phrase", semanticGroup = "religion_shabbat_meals"),

        WordEntity(id = 190518, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "עוֹנֶג שַׁבָּת",
            translation = "радость Шабата",
            definition = "מִצְוָה לְהַרְגִּישׁ הַנָּאָה בַּיּוֹם הַשְּׁבִיעִי — מַאֲכָל טוֹב, שֵׁנָה, שִׁירָה וּמְנוּחָה.",
            definitionNative = "Заповедь чувствовать в седьмой день удовольствие — вкусной пищей, сном, пением и отдыхом.",
            example = "עוֹנֶג שַׁבָּת אֶצְלָם זֶה שֵׁנָה אֲרוּכָה אַחֲרֵי הָאֲרוּחָה.",
            exampleNative = "עוֹנֶג שַׁבָּת у них — это долгий сон после еды.",
            pos = "phrase", semanticGroup = "religion_shabbat_meals", fillInBlankExclusions = listOf(190516L, 190517L, 190519L, 190520L)),

        WordEntity(id = 190519, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "מְלַוֶּה מַלְכָּה",
            translation = "проводы Царицы Шабат",
            definition = "אֲרוּחָה רְבִיעִית מְאֻחֶרֶת, אַחֲרֵי הַהַבְדָּלָה, שֶׁבָּהּ מְלַוִּים אֶת הַיּוֹם הַקָּדוֹשׁ.",
            definitionNative = "Поздний четвёртый ужин, уже после hавдалы, которым провожают святой день.",
            example = "הַחֲסִידִים נִשְׁאֲרוּ לִמְלַוֶּה מַלְכָּה עִם גִּטָּרָה עַד חָצוֹת.",
            exampleNative = "Хасиды остались на מְלַוֶּה מַלְכָּה с гитарой до полуночи.",
            pos = "phrase", semanticGroup = "religion_shabbat_meals", fillInBlankExclusions = listOf(190516L, 190517L, 190518L, 190520L)),

        WordEntity(id = 190520, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "דְּבַר תּוֹרָה",
            translation = "слово Торы у стола",
            definition = "הֶסְבֵּר קָצָר שֶׁאוֹמְרִים בֵּין הַמָּנוֹת, סְבִיב פַּרְשַׁת הַשָּׁבוּעַ הַנּוֹכְחִית.",
            definitionNative = "Короткое толкование, которое произносят между блюдами, на тему текущей недельной главы.",
            example = "הָאוֹרֵחַ הִכִּין דְּבַר תּוֹרָה קָצָר עַל יוֹסֵף וְאֶחָיו.",
            exampleNative = "Гость подготовил короткое דְּבַר תּוֹרָה об Иосифе и его братьях.",
            pos = "phrase", semanticGroup = "religion_shabbat_meals", fillInBlankExclusions = listOf(190509L, 190516L, 190517L, 190518L, 190519L)),

        // ── Group: religion_shabbat_laws (5 words) ────────────────────────────

        WordEntity(id = 190521, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "מוּקְצֶה",
            translation = "запретный к перемещению",
            definition = "מַעֲמַד שֶׁל חֵפֶץ שֶׁאָסוּר לָגַעַת בּוֹ בַּיּוֹם הַשְּׁבִיעִי — כְּסָפִים, עֵטִים, פְּטִישׁ.",
            definitionNative = "Статус предмета, к которому нельзя прикасаться в седьмой день — деньги, ручки, молоток.",
            example = "הַטֶּלֶפוֹן נִשְׁאַר עַל הַשֻּׁלְחָן כִּי הוּא מוּקְצֶה.",
            exampleNative = "Телефон остался на столе, потому что он מוּקְצֶה.",
            pos = "adjective", semanticGroup = "religion_shabbat_laws"),

        WordEntity(id = 190522, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "מְלָאכָה",
            translation = "запрещённая работа",
            definition = "פְּעֻלָּה יוֹצֶרֶת — בִּשּׁוּל, כְּתִיבָה, הַדְלָקַת אֵשׁ — שֶׁאֲסוּרָה בַּיּוֹם הַקָּדוֹשׁ.",
            definitionNative = "Созидательное действие — варка, письмо, разжигание огня — запретное в седьмой день.",
            example = "לְהַדְלִיק אוֹר זֹאת מְלָאכָה אֲסוּרָה לְפִי הַהֲלָכָה.",
            exampleNative = "Включить свет — это מְלָאכָה, запрещённая по закону.",
            pos = "noun", semanticGroup = "religion_shabbat_laws", fillInBlankExclusions = listOf(190523L)),

        WordEntity(id = 190523, setId = 1905, languagePair = "he-ru", rarity = "EPIC",
            original = "עֵירוּב",
            translation = "эрув (символическая ограда)",
            definition = "תַּיִל דַּק שֶׁמַּקִּיף שְׁכוּנָה וּמְאַחֵד אֶת חֲצֵרוֹתֶיהָ לִרְשׁוּת אַחַת, כְּדֵי שֶׁמֻּתָּר יִהְיֶה לָשֵׂאת.",
            definitionNative = "Тонкая проволока, обводящая район и соединяющая его дворы в одно владение, чтобы разрешить носить.",
            example = "בְּלִי הָעֵירוּב אֵין אֵיךְ לְהוֹצִיא עֲגָלָה לָרְחוֹב.",
            exampleNative = "Без עֵירוּב коляску на улицу не вывезешь.",
            pos = "noun", semanticGroup = "religion_shabbat_laws", fillInBlankExclusions = listOf(190522L)),

        WordEntity(id = 190524, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "צֵאת הַשַּׁבָּת",
            translation = "исход Шабата",
            definition = "הָרֶגַע שֶׁבּוֹ שָׁלוֹשׁ כּוֹכָבִים נִרְאִים בַּשָּׁמַיִם וְהַיּוֹם הַקָּדוֹשׁ מִסְתַּיֵּם.",
            definitionNative = "Миг, когда на небе видны три звезды и святой день заканчивается.",
            example = "בְּצֵאת הַשַּׁבָּת הָאָב חָזַר לַטֶּלֶפוֹן וּלְחָדָשׁוֹת.",
            exampleNative = "В צֵאת הַשַּׁבָּת отец вернулся к телефону и новостям.",
            pos = "phrase", semanticGroup = "religion_shabbat_laws", fillInBlankExclusions = listOf(190525L)),

        WordEntity(id = 190525, setId = 1905, languagePair = "he-ru", rarity = "RARE",
            original = "שְׁמִירַת שַׁבָּת",
            translation = "соблюдение Шабата",
            definition = "אֹרַח חַיִּים שֶׁל הַקְפָּדָה עַל כָּל אִסּוּרֵי הַיּוֹם הַשְּׁבִיעִי וְעַל מִצְווֹתָיו.",
            definitionNative = "Образ жизни со строгим вниманием ко всем запретам седьмого дня и к его заповедям.",
            example = "מֵאָז הָעֲלִיָּה הִיא אִמְּצָה שְׁמִירַת שַׁבָּת מְלֵאָה.",
            exampleNative = "После репатриации она приняла полное שְׁמִירַת שַׁבָּת.",
            pos = "phrase", semanticGroup = "religion_shabbat_laws", fillInBlankExclusions = listOf(190505L, 190518L, 190524L)),
    )
}
