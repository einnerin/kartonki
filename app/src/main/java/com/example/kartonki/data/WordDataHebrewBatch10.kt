package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — batch 10.
 * Sets 1053–1055: Israeli Holidays, Banking/Finances, Job Hunting.
 */
object WordDataHebrewBatch10 {

    val sets = listOf(
        WordSetEntity(id = 1053, name = "Религия: продвинутый — еврейские праздники, традиции и обряды",              description = "Еврейские праздники, традиции и обряды", languagePair = "he-ru", orderIndex = 53,
            topic = "Религия",
            level = 2),
                    )

    val words = listOf(

        // ──────────────────────────────────────────────────────────────────
        // Set 1053 — חגים ישראליים  (Israeli holidays, A2/B1),
        // 25 words: 6 COMMON + 10 UNCOMMON + 6 RARE + 2 EPIC + 1 LEGENDARY
        // ──────────────────────────────────────────────────────────────────

        WordEntity(
            id = 105301, setId = 1053, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holiday_basics", transliteration = "yom tov",
            original = "יוֹם טוֹב", translation = "праздничный день; йом-тов (религ. праздник)",
            definition = "יוֹם חַג דָּתִי אוֹ לְאֻמִּי; גַּם בִּרְכַּת חַג.",
            definitionNative = "Религиозный или национальный праздник; также праздничное приветствие.",
            example = "חַג שָׂמֵחַ — יוֹם טוֹב לְכָל הַמִּשְׁפָּחָה!",
            exampleNative = "С праздником — יוֹם טוֹב всей семье!",
         fillInBlankExclusions = listOf(105304L, 105305L)),
        WordEntity(
            id = 105302, setId = 1053, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holiday_food", transliteration = "matza",
            original = "מַצָּה", translation = "маца (пресный хлеб)",
            definition = "לֶחֶם שָׁטוּחַ וְיָבֵשׁ שֶׁנֶּאֱכָל בְּחַג הַפֶּסַח.",
            definitionNative = "Плоский сухой хлеб без дрожжей, который едят на Пасху.",
            example = "בְּפֶסַח אוֹכְלִים מַצָּה וְלֹא לֶחֶם רָגִיל.",
            exampleNative = "На Пасху едят מַצָּה, а не обычный хлеб.",
        ),
        WordEntity(
            id = 105303, setId = 1053, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holiday_prayer", transliteration = "tefila",
            original = "תְּפִילָה", translation = "молитва",
            definition = "פְּנִיָּה לְאֵלֹהִים בְּדִבּוּר אוֹ בְּלֵב, בְּיַחִיד אוֹ בְּצִבּוּר.",
            definitionNative = "Обращение к Богу словами или в мыслях, лично или в общине.",
            example = "אָמַרְנוּ תְּפִילַת הַמּוֹצִיא לִפְנֵי הָאֲרוּחָה הַחַגִּיגִית.",
            exampleNative = "Мы произнесли תְּפִילָה гамоци перед праздничной трапезой.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 105304, setId = 1053, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holiday_celebration", transliteration = "khagiga",
            original = "חַגִּיגָה", translation = "праздник, торжество",
            definition = "אֵירוּעַ שִׂמְחָה שֶׁל קְהִלָּה אוֹ מִשְׁפָּחָה לִכְבוֹד אוֹקָזְיָה מְיֻחֶדֶת.",
            definitionNative = "Радостное событие общины или семьи в честь особого повода.",
            example = "הָיְתָה חַגִּיגָה גְּדוֹלָה בַּכִּיכָּר עִם מוּסִיקָה וְרִיקּוּדִים.",
            exampleNative = "На площади была большая חַגִּיגָה с музыкой и танцами.",
         fillInBlankExclusions = listOf(105306L)),
        WordEntity(
            id = 105305, setId = 1053, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holiday_basics", transliteration = "tzom",
            original = "צוֹם", translation = "пост (воздержание от еды)",
            definition = "הִמְנָעוּת מֵאֲכִילָה וּשְׁתִיָּה לִתְקוּפָה מְסֻיֶּמֶת מִטַּעֲמִים דָּתִיִּים.",
            definitionNative = "Воздержание от еды и питья в течение определённого времени по религиозным причинам.",
            example = "בְּיוֹם כִּפּוּר מְקַיְּמִים צוֹם שֶׁל 25 שָׁעוֹת.",
            exampleNative = "В Йом Кипур соблюдают צוֹם продолжительностью 25 часов.",
         fillInBlankExclusions = listOf(105301L)),
        WordEntity(
            id = 105306, setId = 1053, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "holiday_lagbomer", transliteration = "medura",
            original = "מְדוּרָה", translation = "костёр",
            definition = "אֵשׁ גְּדוֹלָה שֶׁמַּדְלִיקִים בַּחוּץ, בִּמְיֻחָד בְּלַג בָּעֹמֶר.",
            definitionNative = "Большой огонь, зажигаемый на улице, особенно на Лаг ба-Омер.",
            example = "הַיְּלָדִים שָׁרוּ סְבִיב הַמְּדוּרָה בְּלַג בָּעֹמֶר.",
            exampleNative = "Дети пели вокруг מְדוּרָה на Лаг ба-Омер.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 105307, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_calendar", transliteration = "shavuot",
            original = "שָׁבוּעוֹת", translation = "Шавуот (праздник дарования Торы)",
            definition = "חַג יְהוּדִי הַחָל 50 יוֹם לְאַחַר פֶּסַח, בּוֹ חוֹגְגִים מַתַּן תּוֹרָה.",
            definitionNative = "Еврейский праздник, отмечаемый через 50 дней после Пасхи, в честь дарования Торы.",
            example = "בְּשָׁבוּעוֹת נוֹהֲגִים לֶאֱכֹל מַאֲכָלֵי חָלָב.",
            exampleNative = "На שָׁבוּעוֹת принято есть молочные блюда.",
        ),
        WordEntity(
            id = 105308, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_national", transliteration = "yom ha'atzma'ut",
            original = "יוֹם הָעַצְמָאוּת", translation = "День независимости Израиля",
            definition = "חַג לְאֻמִּי שֶׁל מְדִינַת יִשְׂרָאֵל, הַנֶּחְגָּג בְּה' בְּאִיָּר.",
            definitionNative = "Национальный праздник Государства Израиль, отмечаемый 5 ияра.",
            example = "בְּיוֹם הָעַצְמָאוּת עוֹרְכִים מַנְגָּל וְצוֹפִים בְּזִיקּוּקִין.",
            exampleNative = "В יוֹם הָעַצְמָאוּת устраивают барбекю и смотрят фейерверки.",
         fillInBlankExclusions = listOf(105309L, 105315L)),
        WordEntity(
            id = 105309, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_national", transliteration = "yom hashoah",
            original = "יוֹם הַשּׁוֹאָה", translation = "День памяти Катастрофы (Йом hаШоа)",
            definition = "יוֹם זִכָּרוֹן לְשֵׁשֶׁת מִילְיוֹנֵי הַיְּהוּדִים שֶׁנִּרְצְחוּ בַּשּׁוֹאָה.",
            definitionNative = "День памяти шести миллионов евреев, погибших в Катастрофе.",
            example = "בְּיוֹם הַשּׁוֹאָה צוֹפֵר הַזִּכָּרוֹן נִשְׁמַע בְּכָל הָאָרֶץ.",
            exampleNative = "В יוֹם הַשּׁוֹאָה по всей стране звучит сирена памяти.",
         fillInBlankExclusions = listOf(105308L, 105315L)),
        WordEntity(
            id = 105310, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_lagbomer", transliteration = "lag ba'omer",
            original = "לַג בָּעֹמֶר", translation = "Лаг ба-Омер",
            definition = "חַג יְהוּדִי הַנֶּחְגָּג בִּשְׂרֵפוֹת מְדוּרוֹת, בְּל\"ג לָעֹמֶר.",
            definitionNative = "Еврейский праздник, отмечаемый кострами, на 33-й день омера.",
            example = "הַיְּלָדִים אָסְפוּ עֵצִים לַמְּדוּרָה שֶׁל לַג בָּעֹמֶר.",
            exampleNative = "Дети собирали дрова для костра לַג בָּעֹמֶר.",
         fillInBlankExclusions = listOf(105306L)),
        WordEntity(
            id = 105311, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_sukkot", transliteration = "sukka",
            original = "סֻכָּה", translation = "сукка (праздничный шалаш)",
            definition = "מִבְנֶה זְמַנִּי הַנִּבְנֶה לְחַג הַסֻּכּוֹת, בְּגַגּוֹ פַּלְמִית אוֹ עֲנָפִים.",
            definitionNative = "Временная постройка для праздника Суккот с крышей из пальмовых листьев.",
            example = "בָּנִינוּ סֻכָּה יָפָה בְּחֶדֶר הַמַּדְרֵגוֹת עַל הַגַּג.",
            exampleNative = "Мы построили красивую סֻכָּה на лестничной площадке на крыше.",
        ),
        WordEntity(
            id = 105312, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_rosh_hashana", transliteration = "shofar",
            original = "שׁוֹפָר", translation = "шофар (бараний рог)",
            definition = "כְּלִי נְגִינָה עֲשׂוּי מִקֶּרֶן אַיִל שֶׁתּוֹקְעִים בּוֹ בְּרֹאשׁ הַשָּׁנָה.",
            definitionNative = "Музыкальный инструмент из бараньего рога, в который трубят в Рош а-Шана.",
            example = "קוֹל הַשּׁוֹפָר מְסַמֵּן אֶת תְּחִילַת הַתְּפִלָּה.",
            exampleNative = "Звук שׁוֹפָר возвещает начало молитвы.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 105313, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_shabbat", transliteration = "hadlakat nerot",
            original = "הַדְלָקַת נֵרוֹת", translation = "зажигание свечей",
            definition = "טֶקֶס דָּתִי שֶׁל הַדְלָקַת נֵרוֹת לִכְבוֹד שַׁבָּת אוֹ חַג.",
            definitionNative = "Религиозный обряд зажигания свечей в честь Шаббата или праздника.",
            example = "אִמָּא מַדְלִיקָה נֵרוֹת בְּבֹוא הַשַּׁבָּת וּמְבָרֶכֶת עַל הַהַדְלָקָה.",
            exampleNative = "Мама зажигает свечи с наступлением Шаббата и произносит благословение.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 105314, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_hanukkah", transliteration = "nerot khanuka",
            original = "נֵרוֹת חֲנֻכָּה", translation = "ханукальные свечи",
            definition = "נֵרוֹת מְיֻחָדִים שֶׁמַּדְלִיקִים בְּחֲנֻכִּיָּה שְׁמוֹנָה לֵילוֹת בְּחֲנֻכָּה.",
            definitionNative = "Специальные свечи, зажигаемые в ханукии восемь ночей на Хануку.",
            example = "מַדְלִיקִים נֵרוֹת חֲנֻכָּה וּמְבָרְכִים לְפָנֵיהֶן.",
            exampleNative = "Зажигают נֵרוֹת חֲנֻכָּה и произносят благословения перед ними.",
        ),
        WordEntity(
            id = 105315, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_national", transliteration = "yom yerushalayim",
            original = "יוֹם יְרוּשָׁלַיִם", translation = "День Иерусалима",
            definition = "יוֹם לְאֻמִּי הַמְּצַיֵּן אֶת אִיחוּד יְרוּשָׁלַיִם בְּמִלְחֶמֶת שֵׁשֶׁת הַיָּמִים.",
            definitionNative = "Национальный праздник, отмечающий воссоединение Иерусалима в ходе Шестидневной войны.",
            example = "בְּיוֹם יְרוּשָׁלַיִם מִצְעָדִים עוֹלִים לָעִיר הָעַתִּיקָה.",
            exampleNative = "В יוֹם יְרוּשָׁלַיִם шествия направляются в Старый город.",
         fillInBlankExclusions = listOf(105308L, 105309L)),
        WordEntity(
            id = 105316, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_memorial", transliteration = "ner zikaron",
            original = "נֵר זִכָּרוֹן", translation = "поминальная свеча",
            definition = "נֵר שֶׁמַּדְלִיקִים לְזֵכֶר אָדָם שֶׁנִּפְטַר, בְּיוֹם פְּטִירָתוֹ אוֹ בַּיָּמִים הַקְּדוֹשִׁים.",
            definitionNative = "Свеча, зажигаемая в память об умершем в годовщину смерти или в священные дни.",
            example = "הִדְלַקְנוּ נֵר זִכָּרוֹן בְּיוֹם הַשּׁוֹאָה לְזֵכֶר קְרוֹבֵינוּ.",
            exampleNative = "Мы зажгли נֵר זִכָּרוֹן в Йом аШоа в память о наших родственниках.",
         fillInBlankExclusions = listOf(105322L)),
        WordEntity(
            id = 105317, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_shavuot", transliteration = "bikurim",
            original = "בִּכּוּרִים", translation = "бикурим (праздник первых плодов)",
            definition = "טֶקֶס הַגָּשַׁת פֵּרוֹת הַבִּכּוּרִים לַמִּקְדָּשׁ, חָגוּג בְּשָׁבוּעוֹת.",
            definitionNative = "Обряд принесения первых плодов в Храм, отмечаемый на Шавуот.",
            example = "בְּחַג הַבִּכּוּרִים הֵבִיאוּ הָאֲנָשִׁים פֵּרוֹת לַבֵּית הַמִּקְדָּשׁ.",
            exampleNative = "На праздник בִּכּוּרִים люди приносили плоды в Храм.",
         fillInBlankExclusions = listOf(105307L)),
        WordEntity(
            id = 105318, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "synagogue_aliya", transliteration = "aliya latora",
            original = "עֲלִיָּה לַתּוֹרָה", translation = "алия ла-Тора (вызов к Торе)",
            definition = "כָּבוֹד דָּתִי הַנִּתָּן לְבֵן-קְהִלָּה לָקוּם לְבֵימָה וְלִקְרֹא מִן הַתּוֹרָה בְּשַׁבָּת.",
            definitionNative = "Религиозная честь, оказываемая члену общины: подняться на биму и читать из Торы в субботу.",
            example = "קִבַּלְתִּי עֲלִיָּה לַתּוֹרָה בְּשַׁבַּת בַּר הַמִּצְוָה שֶׁל אָחִי.",
            exampleNative = "Я получил עֲלִיָּה לַתּוֹרָה в шаббат бар-мицвы моего брата.",
        ),
        WordEntity(
            id = 105319, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "ethics_charity", transliteration = "tsedaka",
            original = "צְדָקָה", translation = "благотворительность, пожертвование",
            definition = "נְתִינַת כֶּסֶף אוֹ עֶזְרָה לַנְּזְקָקִים כְּחוֹבָה דָּתִית וּמוּסָרִית.",
            definitionNative = "Денежное пожертвование или помощь нуждающимся как религиозная и нравственная обязанность.",
            example = "הַמִּצְוָה שֶׁל צְדָקָה כּוֹלֶלֶת לִתֵּת מֵאָה שֶׁקֶל לַחֹדֶשׁ לַנְּצְרָכִים.",
            exampleNative = "Заповедь צְדָקָה включает пожертвование ста шекелей в месяц нуждающимся.",
        ),
        WordEntity(
            id = 105320, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "synagogue_ark", transliteration = "aron kodesh",
            original = "אָרוֹן קֹדֶשׁ", translation = "Арон кодеш (ковчег в синагоге)",
            definition = "הָאָרוֹן שֶׁבּוֹ מַנִּיחִים אֶת סִפְרֵי הַתּוֹרָה בְּבֵית הַכְּנֶסֶת.",
            definitionNative = "Ковчег в синагоге, в котором хранятся свитки Торы.",
            example = "כְּשֶׁפּוֹתְחִים אֶת הָאָרוֹן קֹדֶשׁ כָּל הַקָּהָל קָם עַל רַגְלָיו.",
            exampleNative = "Когда открывают אָרוֹן קֹדֶשׁ, вся конгрегация встаёт.",
        ),
        WordEntity(
            id = 105321, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holiday_purim", transliteration = "masekha",
            original = "מָסֵכָּה", translation = "маска; карнавальный костюм",
            definition = "כִּסּוּי לַפָּנִים שֶׁמַּסְתִּיר אֶת הַזֶּהוּת; נְהוּג בְּפּוּרִים.",
            definitionNative = "Накладка на лицо, скрывающая личность; принято надевать на Пурим.",
            example = "הַיְּלָדִים לָבְשׁוּ תַּחְפּוֹשׂוֹת וּמָסֵכּוֹת בְּפּוּרִים.",
            exampleNative = "Дети надели карнавальные костюмы и מָסֵכּוֹת на Пурим.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 105322, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shabbat_candles", transliteration = "ner shabat",
            original = "נֵר שַׁבָּת", translation = "субботние свечи",
            definition = "נֵרוֹת שֶׁמַּדְלִיקִים בְּעֶרֶב שַׁבָּת לִכְבוֹד הַשַּׁבָּת.",
            definitionNative = "Свечи, зажигаемые в канун субботы в честь шаббата.",
            example = "הָאֵם מַדְלִיקָה שְׁנֵי נֵרוֹת שַׁבָּת וּמְבָרֶכֶת עֲלֵיהֶם.",
            exampleNative = "Мать зажигает два נֵר שַׁבָּת и произносит над ними благословение.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 105323, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "yom_kippur", transliteration = "kipur",
            original = "כִּפּוּר", translation = "искупление (Йом Кипур)",
            definition = "מוֹשָׂג יְהוּדִי שֶׁל סְלִיחָה וְכַפָּרָה עַל חֲטָאִים; יוֹם כִּפּוּר הוּא הַיּוֹם הַקָּדוֹשׁ בְּיוֹתֵר.",
            definitionNative = "Еврейская концепция прощения и искупления грехов; Йом Кипур — самый священный день.",
            example = "בְּיוֹם הַכִּפּוּרִים צָמִים מִכָּל אֹכֶל וּמִשְׁתֶּה.",
            exampleNative = "В Йом כִּפּוּר постятся — воздерживаются от еды и питья.",
        ),
        WordEntity(
            id = 105324, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "conversion", transliteration = "ger",
            original = "גֵּר", translation = "прозелит, новообращённый",
            definition = "אֶחָד שֶׁהִתְגַּיֵּר וְקִיבֵּל עָלָיו אֶת הַיַּהֲדוּת.",
            definitionNative = "Человек, принявший иудаизм путём гиюра.",
            example = "הַגֵּר עָבַר תְּהָלִיךְ גִּיּוּר וְנִקְלַט בַּקְּהִלָּה.",
            exampleNative = "גֵּר прошёл процесс гиюра и был принят в общину.",
        ),
        WordEntity(
            id = 105325, setId = 1053, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "prayer_shema", transliteration = "kriat shma",
            original = "קְרִיאַת שְׁמַע", translation = "Шма Исраэль (молитва-исповедание веры)",
            definition = "הַתְּפִלָּה הַיְּסוֹדִית בְּיַהֲדוּת שֶׁמַּכְרִיזָה עַל אֶחְדוּת הָאֵל.",
            definitionNative = "Основная молитва в иудаизме, провозглашающая единство Бога.",
            example = "יְהוּדִים אוֹמְרִים קְרִיאַת שְׁמַע בְּכָל בֹּקֶר וּבְכָל עֶרֶב.",
            exampleNative = "Евреи читают קְרִיאַת שְׁמַע каждое утро и вечер.",
         fillInBlankExclusions = listOf(105303L)),

        // ──────────────────────────────────────────────────────────────────
        // Set 1054 — בנק וכספים  (Banking and finances, B1/B2),
        // 25 words: 6 COMMON + 10 UNCOMMON + 6 RARE + 2 EPIC + 1 LEGENDARY
        // ──────────────────────────────────────────────────────────────────

                                                                                                                                                                                                        
        // ──────────────────────────────────────────────────────────────────
        // Set 1055 — חיפוש עבודה  (Job hunting and employment, A2/B2),
        // 25 words: 6 COMMON + 10 UNCOMMON + 6 RARE + 2 EPIC + 1 LEGENDARY
        // ──────────────────────────────────────────────────────────────────

                                                                                                                                                                                                            )
}
