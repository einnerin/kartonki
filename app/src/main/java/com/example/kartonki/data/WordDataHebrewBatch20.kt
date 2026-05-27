package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch20 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1084, languagePair = "he-ru", orderIndex = 1084,
            name = "Еда и кулинария",
            description = "Продвинутые техники и термины",
            topic = "Еда и кулинария",
            level = 4
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1082: Алия и Израиль — продвинутый ───────────────────────

        // UNCOMMON (A2–B1),
        
        
        
        
        
        
        
        
        
        
        
        

        // RARE (B2),
                                                                                                        
        // ── Set 1083: Социальные сети ──────────────────────────────────────

        // COMMON (A1),

        // UNCOMMON (A2-B1),

        // RARE (B2),

        // ── Set 1084: Еда и кулинария ──────────────────────────────────────

        // EPIC (C1),
        WordEntity(
            id = 108401, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "miz an plas",
            original = "מִיז אָן פְּלָס", translation = "мизанплас (подготовка ингредиентов перед готовкой)",
            definition = "סִידּוּר מֻקְפָּד שֶׁל כָּל הַמַּרְכִּיבִים בִּכְלֵי קְטָנִים לִפְנֵי הַדְלָקַת הָאֵשׁ.",
            definitionNative = "Упорядоченная раскладка всех составляющих до начала приготовления.",
            example = "הַשֶּׁף דּוֹרֵשׁ מִיז אָן פְּלָס מוּשְׁלָם לִפְנֵי פְּתִיחַת הַמִּסְעָדָה.",
            exampleNative = "Шеф требует идеальный мизанплас до открытия ресторана.",
        ),
        WordEntity(
            id = 108402, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "demi glas",
            original = "דֵּמִי גְלַס", translation = "деми-гляс (концентрированный соус)",
            definition = "רוֹטֵב חוּם סָמִיךְ הַמִּתְקַבֵּל מֵצִמְצוּם אָרֹךְ שֶׁל מַרַק עַצְמוֹת בָּקָר.",
            definitionNative = "Густой коричневый соус из выпаренного мясного бульона для блюд из говядины.",
            example = "הַשֶּׁף הִכִין דֵּמִי גְלַס בְּמֶשֶׁךְ שְׁמוֹנֶה שָׁעוֹת.",
            exampleNative = "Шеф готовил деми-гляс на протяжении восьми часов.",
         fillInBlankExclusions = listOf(108403L, 108404L, 108408L, 108412L)),
        WordEntity(
            id = 108403, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "beshamel",
            original = "בֶּשָׁמֶל", translation = "соус бешамель",
            definition = "רוֹטֵב לָבָן צָרְפַתִי קְלָאסִי שֶׁמַּכִינִים מֵחָלָב, חֶמְאָה וְקֶמַח לָבָן.",
            definitionNative = "Классический белый французский соус на молоке с мукой и маслом.",
            example = "הַלָּזַנְיָה מְכוּסָה בְּשִׁכְבַת בֶּשָׁמֶל סְמִיכָה.",
            exampleNative = "Лазанья покрыта плотным слоем бешамели.",
         fillInBlankExclusions = listOf(108402L)),
        WordEntity(
            id = 108404, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "vinigret",
            original = "וִינַיְגְרֵט", translation = "винегрет (масляно-уксусная заправка)",
            definition = "תַּחְלִיב חַד שֶׁל שֶׁמֶן וְחוֹמֶץ עִם תַּבְלִינִים לְהַטְבָּלַת עָלִים יְרֻקִּים.",
            definitionNative = "Эмульсия из растительного масла, уксуса и приправ для заправки салата.",
            example = "הוּא הִכִין וִינַיְגְרֵט קְלָאסִי עִם דְּבַשׁ וְחַרְדָּל.",
            exampleNative = "Он приготовил классический винегрет с мёдом и горчицей.",
         fillInBlankExclusions = listOf(108402L, 108403L)),
        WordEntity(
            id = 108405, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "shliqa",
            original = "שְׁלִיקָה", translation = "варка-пашот (в едва кипящей жидкости)",
            definition = "בִּשּׁוּל עָדִין שֶׁל מָזוֹן בְּמַיִם רוֹחֲשִׁים סְבִיב שְׁמוֹנִים מַעֲלוֹת בִּלְבַד.",
            definitionNative = "Деликатное приготовление продукта в едва кипящей воде около восьмидесяти градусов.",
            example = "הַבֵּיצָה מוּכֶנֶת בְּשִׁיטַת שְׁלִיקָה תּוֹךְ שָׁלוֹשׁ דַּקּוֹת.",
            exampleNative = "Яйцо готовится способом пашот за три минуты.",
        ),
        WordEntity(
            id = 108406, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "zgiga",
            original = "זְגִיגָה", translation = "глазирование (покрытие блестящим соусом)",
            definition = "מְשִׁיחַת שִׁכְבָה מַבְרִיקָה שֶׁל סִירוֹפּ אוֹ רוֹטֶב מָתוֹק עַל הַקִּינּוּחַ.",
            definitionNative = "Покрытие блюда блестящим слоем сиропа, желе или восстановленного соуса.",
            example = "הַקּוֹנְדִיטוֹר מָרַח זְגִיגָה אֲדוּמָה עַל הָעוּגָה.",
            exampleNative = "Кондитер нанёс красную глазурь на торт.",
        ),
        WordEntity(
            id = 108407, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "breizing",
            original = "בְּרֵיזִינְג", translation = "брезирование (тушение в малом количестве жидкости)",
            definition = "תִּבְשׁוּל אִטִּי שֶׁל בָּשָׂר תַּחַת מִכְסֶה בִּמְעַט נוֹזֵל וִירָקוֹת רֵיחָנִיִּים.",
            definitionNative = "Медленное томление мяса под крышкой в малом количестве ароматной жидкости.",
            example = "הוּא הִכִין כָּתֵף טָלֶה בְּשִׁיטַת בְּרֵיזִינְג שֵׁשׁ שָׁעוֹת.",
            exampleNative = "Он готовил баранью лопатку методом брезирования шесть часов.",
         fillInBlankExclusions = listOf(108414L, 108420L)),
        WordEntity(
            id = 108408, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "marak etsem",
            original = "מַרַק עֶצֶם", translation = "костный бульон",
            definition = "נוֹזֵל עָשִׁיר וְעָמֹק בְּטַעַם הַמִּתְבַּשֵּׁל שָׁעוֹת רַבּוֹת מֵאֶבָרֵי בָּקָר וִירָקוֹת.",
            definitionNative = "Насыщенная жидкость, полученная длительной варкой говяжьих мослов и овощей.",
            example = "הַשֶּׁף מְבַשֵּׁל מַרַק עֶצֶם שְׁנֵים-עָשָׂר שָׁעוֹת.",
            exampleNative = "Шеф варит костный бульон двенадцать часов.",
        ),
        WordEntity(
            id = 108409, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "rotev em",
            original = "רוֹטֵב אֵם", translation = "материнский соус (base sauce)",
            definition = "תַּעֲרֹבֶת בְּסִיסִית בַּמִּטְבָּח הַצָּרְפָתִי הַמְּשַׁמֶּשֶׁת יְסוֹד לִרְטָבִים נוֹסָפִים.",
            definitionNative = "Базовый французский соус, служащий основой для производных вариантов.",
            example = "בְּמִטְבַּח צָרְפַת קַיָּמִים חֲמִישָּׁה רוֹטֵב אֵם קְלָאסִיִּים.",
            exampleNative = "Во французской кухне существует пять классических базовых соусов.",
        ),
        WordEntity(
            id = 108410, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "panira",
            original = "פָּנִירָה", translation = "панировка",
            definition = "צִיפּוּי שֶׁל פֵּרוּרֵי לֶחֶם אוֹ קֶמַח עַל הַמָּזוֹן לְקִבּוּל קְרוּם זָהֹב בַּטִּיגּוּן.",
            definitionNative = "Покрытие из крошек хлеба или муки на продукте перед обжаркой во фритюре.",
            example = "הַשֶּׁף הוֹסִיף שׁוּמְשׁוּם לַפָּנִירָה לְקְרִיסְפִּיּוּת.",
            exampleNative = "Шеф добавил кунжут в панировку для хрусткости.",
        ),
        WordEntity(
            id = 108411, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "batsek alim",
            original = "בָּצֵק עָלִים", translation = "слоёное тесто",
            definition = "מַאֲפֶה מֵאוֹת שִׁכְבוֹת דַּקִּיקוֹת שֶׁל קֶמַח עִם חֶמְאָה הַמּוּפְרָדוֹת בָּאֲפִיָּה.",
            definitionNative = "Нежное тесто из тонких пластов с прослойками сливочного масла.",
            example = "הַקְּרוּאָסוֹן עָשׂוּי מִבָּצֵק עָלִים מַעֲרָכָה אַחַר מַעֲרָכָה.",
            exampleNative = "Круассан сделан из слоёного теста складка за складкой.",
        ),
        WordEntity(
            id = 108412, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "makhmasa",
            original = "מַחְמָצָה", translation = "закваска для хлеба",
            definition = "עִיסַּת קֶמַח וּמַיִם חַיָּה עִם שְׁמָרִים פְּרָאִיִים שֶׁמַּתְפִּיחָה לֶחֶם בְּלִי שְׁמָרִים.",
            definitionNative = "Живая культура диких дрожжей и бактерий для подъёма хлебного теста.",
            example = "הוּא מַזִין מַחְמָצָה בְּקֶמַח שֶׁבַע שָׁנִים.",
            exampleNative = "Он подкармливает закваску мукой уже семь лет.",
        ),
        WordEntity(
            id = 108413, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "pastrami",
            original = "פַּסְטְרִימִי", translation = "пастрами (вяленая копчёная говядина)",
            definition = "בְּשַׂר בָּקָר מָלוּחַ וּמְעֻשָּׁן עִם קְרוּם פִּלְפֵּל וְכֻסְבָּרָה — מָנָה יְהוּדִית-נְיוּ יוֹרְקִית.",
            definitionNative = "Солёная копчёная говядина с острой пряной коркой из перца и кориандра.",
            example = "הַסֶּנְדְּוִיץ' שֶׁלּוֹ מְמַלָּא בְּפַּסְטְרִימִי מְפֻלְפָּל.",
            exampleNative = "Его сэндвич набит перчёной пастрами.",
        ),
        WordEntity(
            id = 108414, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "so-vi",
            original = "סוֹ-וִי", translation = "су-вид (готовка в вакуумном пакете)",
            definition = "בִּשּׁוּל בְּשַׂקִּית וָקוּם בְּטֶמְפֶּרָטוּרָה נְמוּכָה וּמְדֻיֶּקֶת לְמֶשֶׁךְ שָׁעוֹת אֲרֻכּוֹת.",
            definitionNative = "Приготовление в герметичном пакете при точной низкой температуре в воде.",
            example = "סְטֵיק סוֹ-וִי מוּכָן בְּחַמִּשִּׁים וְחָמֵשׁ מַעֲלוֹת.",
            exampleNative = "Стейк в технике סוֹ-וִי готов при пятидесяти пяти градусах.",
        ),
        WordEntity(
            id = 108415, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "zaafran",
            original = "זָעְפְּרָן", translation = "шафран",
            definition = "הַתַּבְלִין הַיָּקָר בָּעוֹלָם, חוּטִים אֲדֻמִּים-כְּתֻמִּים מִתּוֹךְ פֶּרַח כַּרְכֹּם.",
            definitionNative = "Дорогая красно-оранжевая пряность из рылец цветка крокуса.",
            example = "הַפַּאֵלָּה הִסְפַּגָה בְּגָוֶן זָהֹב בִּזְכוּת זָעְפְּרָן.",
            exampleNative = "Паэлья пропиталась золотым оттенком благодаря шафрану.",
         fillInBlankExclusions = listOf(108416L)),
        WordEntity(
            id = 108416, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "shalot",
            original = "שָׁלוֹט", translation = "шалот (лук-шалот)",
            definition = "בָּצָל קָטָן וּמֻאֳרָךְ בְּטַעַם עָדִין וּמָתוֹק, מַתְאִים לִרְטָבִים צָרְפַתִיִּים.",
            definitionNative = "Сладкая луковица с продолговатой головкой и тонким мягким ароматом.",
            example = "הַשֶּׁף קוֹצֵץ שָׁלוֹט דַּק לְרוֹטֶב הַסָּלָט.",
            exampleNative = "Шеф мелко рубит шалот для соуса к салату.",
        ),
        WordEntity(
            id = 108417, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "emulsiya",
            original = "אֶמוּלְסִיָּה", translation = "эмульсия",
            definition = "תַּעֲרֹבֶת יַצִּיבָה שֶׁל שְׁנֵי נוֹזְלִים שֶׁלֹּא מִתְעָרְבִים, כְּמוֹ שֶׁמֶן וּמַיִם בְּמַיוֹנֵז.",
            definitionNative = "Устойчивая смесь двух несмешивающихся жидкостей вроде масла и воды.",
            example = "הַמַּיוֹנֵז הוּא אֶמוּלְסִיָּה שֶׁל שֶׁמֶן וְחֶלְמוֹן.",
            exampleNative = "Майонез — это эмульсия из масла и желтка.",
        ),
        WordEntity(
            id = 108418, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "reduktsiya",
            original = "רֶדוּקְצְיָה", translation = "редукция (упаривание соуса)",
            definition = "אִדּוּי אִטִּי שֶׁל נוֹזֵל עַל הָאֵשׁ עַד שֶׁהַטַּעַם מִתְרַכֵּז וְהַמִּרְקָם נַעֲשֶׂה סָמִיךְ.",
            definitionNative = "Уваривание жидкости до концентрации вкуса и густой консистенции.",
            example = "הַשֶּׁף הִכִין רֶדוּקְצְיָה שֶׁל יַיִן אָדוֹם וְצָלוֹט.",
            exampleNative = "Шеф приготовил редукцию из красного вина и шалота.",
        ),
        WordEntity(
            id = 108419, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "blanching",
            original = "בְּלַנְשִׁינְג", translation = "бланширование",
            definition = "טְבִילָה קְצָרָה שֶׁל יְרָקוֹת בְּמַיִם רוֹתְחִים וּמִיָּד אַחַר כָּךְ בְּקַעֲרַת קֶרַח.",
            definitionNative = "Кратковременное погружение продукта в кипяток с последующим охлаждением во льду.",
            example = "הַיְּרָקוֹת עוֹבְרִים בְּלַנְשִׁינְג קָצָר לִשְׁמִירַת הַצֶּבַע.",
            exampleNative = "Овощи проходят короткое бланширование для сохранения цвета.",
        ),
        WordEntity(
            id = 108420, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "konfi",
            original = "קוֹנְפִי", translation = "конфи (медленное томление в жире)",
            definition = "תִּבְשׁוּל אִטִּי שֶׁל רֶגֶל בַּרְוָז אוֹ אַוָּז טָבוּלָה כֻּלָּהּ בְּשׁוּמַן עַצְמָהּ.",
            definitionNative = "Медленное томление мяса в собственном жире при низкой температуре.",
            example = "רֶגֶל בַּרְוָז קוֹנְפִי מַגִּיעָה לְמִרְקָם נָמֵס בַּפֶּה.",
            exampleNative = "Утиная ножка конфи получается тающей во рту.",
        ),
        WordEntity(
            id = 108421, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "plating",
            original = "פְּלֵיטִינְג", translation = "сервировка блюда (plating)",
            definition = "אֳמָנוּת סִידּוּר הָאֹכֶל עַל הַצַּלַּחַת בְּצוּרָה יָפָה לְפִי כְּלָלֵי עִיצּוּב מִקְצוֹעִיִּים.",
            definitionNative = "Искусство эстетичного расположения еды на тарелке в дорогом ресторане.",
            example = "הַשֶּׁף לוֹמֵד פְּלֵיטִינְג מִינִימָלִיסְטִי יָפָּנִי.",
            exampleNative = "Шеф изучает минималистичную сервировку блюда в японском стиле.",
        ),
        WordEntity(
            id = 108422, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "gastronomiya",
            original = "גַּסְטְרוֹנוֹמִיָּה", translation = "гастрономия",
            definition = "אֳמָנוּת וּמַדָּע שֶׁל אֳכָלִים מְשׁוּבָּחִים, מֵהַהֲכָנָה וְעַד הַהֲנָאָה בַּפֶּה.",
            definitionNative = "Искусство и наука приготовления и наслаждения изысканной пищей.",
            example = "צָרְפַת מְפֻרְסֶמֶת בַּגַּסְטְרוֹנוֹמִיָּה שֶׁלָּהּ בָּעוֹלָם.",
            exampleNative = "Франция знаменита своей гастрономией во всём мире.",
        ),
        WordEntity(
            id = 108423, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "mayar",
            original = "מֵיאָרְ", translation = "реакция Майяра (потемнение при жарке)",
            definition = "תְּגוּבָה כִּימִית בֵּין חֶלְבּוֹנִים וּסְכָּרִים בְּחוֹם גָּבוֹהַּ שֶׁיּוֹצֶרֶת קְרוּם זָהֹב וְטָעִים.",
            definitionNative = "Химическое потемнение белков и сахаров при сильном нагреве.",
            example = "הַסְּטֵיק מְקַבֵּל גָּוֶן זָהֹב בִּזְכוּת מֵיאָרְ.",
            exampleNative = "Стейк получает золотистый оттенок благодаря реакции Майяра.",
        ),
        WordEntity(
            id = 108424, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "brunuaz",
            original = "בְּרוּנוֹאָז", translation = "брюнуаз (мелкая кубическая нарезка)",
            definition = "חִיתּוּךְ צָרְפַתִי שֶׁל יְרָקוֹת לְקוּבִיּוֹת זְעִירוֹת בְּגֹדֶל שְׁנֵי מ\"מ בִּלְבַד.",
            definitionNative = "Очень мелкая кубическая нарезка овощей размером два миллиметра.",
            example = "הַשֶּׁף חוֹתֵךְ גֶּזֶר בְּרוּנוֹאָז לְמִלּוּי הַמָּנָה.",
            exampleNative = "Шеф нарезает морковь брюнуазом для начинки блюда.",
        ),
        WordEntity(
            id = 108425, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "teruar",
            original = "טֶרוּאָר", translation = "терруар (влияние места на продукт)",
            definition = "צֵירוּף יִחוּדִי שֶׁל אַקְלִים, אֲדָמָה וּמָסוֹרֶת מְקוֹמִית שֶׁמְּעַצֵּב טַעַם יַיִן אוֹ גְבִינָה.",
            definitionNative = "Совокупность природных условий и традиций, формирующих вкус продукта.",
            example = "הַיַּיִן הַזֶּה מְשַׁקֵּף אֶת הַטֶּרוּאָר שֶׁל הַגָּלִיל.",
            exampleNative = "Это вино отражает терруар Галилеи.",
        ),
    )
}
