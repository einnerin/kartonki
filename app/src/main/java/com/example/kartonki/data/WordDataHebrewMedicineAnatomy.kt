package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1895 (he-ru).
 * Медицина: внутренние органы и анатомические системы (L3 / RARE + EPIC).
 *
 * Расширение темы «Медицина». Дополняет:
 *   - 802, 803, 804 (Doctor L3..L5) — клиническая лексика, виды врачей.
 *   - 1820 (MedicineV2) — общая медицина и базовые части тела.
 *   - 1815..1818 (HealthFitness) — здоровье и спорт.
 *   - 805 (Nurse L1) — медсестринская лексика.
 *
 * Подтема — анатомия человека: внутренние органы и системы тела.
 * Пять семантических групп по системам организма:
 *   medicine_anatomy_digestive    — печень, поджелудочная, желчный пузырь, желудок, кишечник, пищевод, 12-пёрстная
 *   medicine_anatomy_respiratory  — трахея, бронхи, бронхиолы, лёгкое
 *   medicine_anatomy_circulatory  — артерия, вена, капилляр, аорта, желудочек сердца
 *   medicine_anatomy_urogenital   — почка, мочевой пузырь, уретра, яичник, семенник
 *   medicine_anatomy_endocrine    — железа, щитовидка, надпочечник, гипофиз
 *
 * Из шорт-листа исключены дубли уже занятых слов:
 *   - סַרְעֶפֶת (диафрагма)  — AppearanceL4 (1824)
 *   - גָּרוֹן  (гортань)     — Batch39
 *   - רֶחֶם   (матка/утроба) — AppearanceL5 (1826) как библейское «утроба»
 *   - לֵב     (сердце)       — MedicineV2 (1820)
 *   - טְחוֹל  (селезёнка)    — намеренно опущена для баланса групп
 *
 * Word IDs: 189501..189525 (setId × 100 + position).
 */
object WordDataHebrewMedicineAnatomy {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1895, languagePair = "he-ru", orderIndex = 1895,
            name = "Медицина",
            description = "Внутренние органы и системы тела: כָּבֵד, כִּלְיָה, עוֹרֵק, רֵאָה, בַּלּוּטַת הַתְרִיס",
            topic = "Медицина",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: medicine_anatomy_digestive (7 words) ──────────────────────

        WordEntity(id = 189501, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "כָּבֵד",
            translation = "печень",
            definition = "אֵיבָר פְּנִימִי גָּדוֹל בַּצַּד הַיְּמָנִי שֶׁל הַבֶּטֶן הַמְּסַנֵּן אֶת הַדָּם וּמְפָרֵק רַעֲלִים.",
            definitionNative = "Большой внутренний орган в правой части живота: фильтрует кровь и расщепляет токсины.",
            example = "אַחֲרֵי שָׁנִים שֶׁל שְׁתִיָּה רוֹפְאִים גִּלּוּ פְּגִיעָה חֲמוּרָה בַּכָּבֵד שֶׁלּוֹ.",
            exampleNative = "После многих лет выпивки врачи обнаружили у него серьёзное повреждение כָּבֵד.",
            transliteration = "кавэд",
            pos = "noun", semanticGroup = "medicine_anatomy_digestive",
            fillInBlankExclusions = listOf(189502L, 189503L, 189504L, 189505L, 189506L, 189507L)),

        WordEntity(id = 189502, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "לַבְלָב",
            translation = "поджелудочная железа",
            definition = "בַּלּוּטָה אֲרֻכָּה מֵאֲחוֹרֵי הַקֵּיבָה הַמַּפְרִישָׁה אִינְסוּלִין וּמִיצֵי עִכּוּל.",
            definitionNative = "Вытянутая железа за желудком: выделяет инсулин и пищеварительные соки.",
            example = "סוּכֶּרֶת מִסּוּג רִאשׁוֹן מִתְפַּתַּחַת כְּשֶׁהַלַּבְלָב מַפְסִיק לְיַצֵּר אִינְסוּלִין.",
            exampleNative = "Диабет первого типа развивается, когда לַבְלָב перестаёт производить инсулин.",
            transliteration = "лавлав",
            pos = "noun", semanticGroup = "medicine_anatomy_digestive",
            fillInBlankExclusions = listOf(189501L, 189503L, 189504L, 189505L, 189506L, 189507L), isFillInBlankSafe = false),

        WordEntity(id = 189503, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "כִּיס מָרָה",
            translation = "жёлчный пузырь",
            definition = "שַׂקִּיק קָטָן בְּצוּרַת אַגָּס מִתַּחַת לַכָּבֵד הַמְּאַחְסֵן אֶת הַמָּרָה לְעִכּוּל שֻׁמָּנִים.",
            definitionNative = "Небольшой грушевидный мешочек под печенью: хранит жёлчь для переваривания жиров.",
            example = "אַחֲרֵי הַהֶתְקֵף הוֹצִיאוּ לָהּ אֶת כִּיס הַמָּרָה בְּנִתּוּחַ לָפָּרוֹסְקוֹפִּי.",
            exampleNative = "После приступа ей удалили כִּיס מָרָה лапароскопической операцией.",
            transliteration = "кис мара",
            pos = "phrase", semanticGroup = "medicine_anatomy_digestive",
            fillInBlankExclusions = listOf(189501L, 189502L, 189504L, 189505L, 189506L, 189507L)),

        WordEntity(id = 189504, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "וֵשֶׁט",
            translation = "пищевод",
            definition = "צִנּוֹר שְׁרִירִי הַמּוֹבִיל אֶת הַמָּזוֹן מֵהַלּוֹעַ אֶל הַקֵּיבָה בִּפְעוּלוֹת לְחִיצָה.",
            definitionNative = "Мышечная трубка, проталкивающая пищу из глотки в желудок волнообразными сжатиями.",
            example = "צְרֵבוֹת חוֹזְרוֹת שׂוֹרְפוֹת לְאַט אֶת רִפּוּד הַוֵּשֶׁט.",
            exampleNative = "Постоянная изжога медленно обжигает слизистую וֵשֶׁט.",
            transliteration = "вэшэт",
            pos = "noun", semanticGroup = "medicine_anatomy_digestive",
            fillInBlankExclusions = listOf(189501L, 189502L, 189503L, 189505L, 189506L, 189507L)),

        WordEntity(id = 189505, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "קֵיבָה",
            translation = "желудок",
            definition = "אֵיבָר חָלוּל בְּצוּרַת שַׂק שֶׁבּוֹ הַמָּזוֹן מִתְעַכֵּל בְּעֶזְרַת חוּמְצָה וְאֶנְזִימִים.",
            definitionNative = "Полый мешковидный орган, в котором пища переваривается под действием кислоты и ферментов.",
            example = "הָרוֹפֵא מָצָא אֲצִיר בַּקֵּיבָה וְהִפְנָה אוֹתָהּ לְגַסְטְרוֹסְקוֹפְּיָה.",
            exampleNative = "Врач обнаружил язву в קֵיבָה и направил её на гастроскопию.",
            transliteration = "кэйва",
            pos = "noun", semanticGroup = "medicine_anatomy_digestive",
            fillInBlankExclusions = listOf(189501L, 189502L, 189503L, 189504L, 189506L, 189507L)),

        WordEntity(id = 189506, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "מֵעַיִם",
            translation = "кишечник",
            definition = "צִנּוֹר אָרֹךְ וּמְפֻתָּל מִתַּחַת לַקֵּיבָה הַסּוֹפֵג חֻמְרֵי תְּזוּנָה מֵהַמָּזוֹן.",
            definitionNative = "Длинная свёрнутая трубка под желудком: всасывает питательные вещества из пищи.",
            example = "רֹב הַבַּרְזֶל מֵהַמָּזוֹן נִסְפַּג בַּמֵּעַיִם הַדַּקִּים.",
            exampleNative = "Большая часть железа из пищи всасывается в тонком מֵעַיִם.",
            transliteration = "мэаим",
            pos = "noun", semanticGroup = "medicine_anatomy_digestive",
            fillInBlankExclusions = listOf(189501L, 189502L, 189503L, 189504L, 189505L, 189507L)),

        WordEntity(id = 189507, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "תְּרֵיסַרְיוֹן",
            translation = "двенадцатиперстная кишка",
            definition = "הַחֵלֶק הָרִאשׁוֹן וְהַקָּצָר שֶׁל הַמֵּעִי הַדַּק שֶׁבּוֹ הַמָּזוֹן נִפְגָּשׁ עִם מָרָה וְעִם מִיץ הַלַּבְלָב.",
            definitionNative = "Короткий первый отдел тонкого кишечника: там пища встречается с жёлчью и панкреатическим соком.",
            example = "כִּיב בַּתְּרֵיסַרְיוֹן מַכְאִיב לְרֹב כַּמָּה שָׁעוֹת אַחֲרֵי הָאֲרוּחָה.",
            exampleNative = "Язва в תְּרֵיסַרְיוֹן обычно болит через несколько часов после еды.",
            transliteration = "трэйсарьон",
            pos = "noun", semanticGroup = "medicine_anatomy_digestive",
            fillInBlankExclusions = listOf(189501L, 189502L, 189503L, 189504L, 189505L, 189506L)),

        // ── Group: medicine_anatomy_respiratory (4 words) ────────────────────

        WordEntity(id = 189508, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "קְנֵה הַנְּשִׁימָה",
            translation = "трахея",
            definition = "צִנּוֹר נֻקְשֶׁה מִטַּבָּעוֹת סְחוּס הַמּוֹבִיל אֲוִיר מֵהַלּוֹעַ אֶל הָרֵיאוֹת.",
            definitionNative = "Жёсткая трубка из хрящевых полуколец, проводящая воздух из глотки в лёгкие.",
            example = "הַמְּנַתֵּחַ פָּתַח חוֹר קָטָן בִּקְנֵה הַנְּשִׁימָה כְּדֵי לַעֲזֹר לוֹ לִנְשֹׁם.",
            exampleNative = "Хирург проделал маленькое отверстие в קְנֵה הַנְּשִׁימָה, чтобы помочь ему дышать.",
            transliteration = "кнэ hа-нэшима",
            pos = "phrase", semanticGroup = "medicine_anatomy_respiratory",
            fillInBlankExclusions = listOf(189509L, 189510L, 189511L)),

        WordEntity(id = 189509, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "סִמְפּוֹנוֹת",
            translation = "бронхи",
            definition = "שְׁנֵי הַצִּנּוֹרוֹת הָרָאשִׁיִּים הַמִּתְפַּצְּלִים מִקְּנֵה הַנְּשִׁימָה לְתוֹךְ הָרֵיאוֹת.",
            definitionNative = "Две главные воздухоносные трубки, ответвляющиеся от трахеи в каждое лёгкое.",
            example = "צִלּוּם הַחָזֶה הֶרְאָה גִּדּוּל הַחוֹסֵם אֶת אַחַד הַסִּמְפּוֹנוֹת.",
            exampleNative = "Снимок грудной клетки показал опухоль, перекрывающую один из סִמְפּוֹנוֹת.",
            transliteration = "симпонот",
            pos = "noun", semanticGroup = "medicine_anatomy_respiratory",
            fillInBlankExclusions = listOf(189508L, 189510L, 189511L)),

        WordEntity(id = 189510, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "בְּרוֹנְכִיוֹלִים",
            translation = "бронхиолы",
            definition = "הַסְּעִיפִים הַדַּקִּים בְּיוֹתֵר שֶׁל הַסִּמְפּוֹנוֹת, מַגִּיעִים עַד שַׂקִּיקֵי הָאֲוִיר בָּרֵיאוֹת.",
            definitionNative = "Самые тонкие ответвления бронхиального дерева; ведут к воздушным мешочкам — альвеолам.",
            example = "בְּאַסְטְמָה הַשְּׁרִירִים סְבִיב הַבְּרוֹנְכִיוֹלִים מִתְכַּוְּצִים וְמַקְשִׁים עַל הַנְּשִׁימָה.",
            exampleNative = "При астме мышцы вокруг בְּרוֹנְכִיוֹלִים спазмируются и затрудняют дыхание.",
            transliteration = "бронхиолим",
            pos = "noun", semanticGroup = "medicine_anatomy_respiratory",
            fillInBlankExclusions = listOf(189508L, 189509L, 189511L)),

        WordEntity(id = 189511, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "רֵאָה",
            translation = "лёгкое",
            definition = "אֵיבָר נְשִׁימָה גָּדוֹל בַּחָזֶה שֶׁבּוֹ עוֹבֵר חַמְצָן מֵהָאֲוִיר אֶל הַדָּם.",
            definitionNative = "Большой дыхательный орган в грудной клетке: через него кислород из воздуха переходит в кровь.",
            example = "הַמְּעַשְּׁנִים מַסְכִּימִים שֶׁפְּגִיעָה בָּרֵאָה הִיא הַסָּכָנָה הַגְּדוֹלָה בְּיוֹתֵר.",
            exampleNative = "Курильщики соглашаются, что поражение רֵאָה — это главная опасность.",
            transliteration = "рэа",
            pos = "noun", semanticGroup = "medicine_anatomy_respiratory",
            fillInBlankExclusions = listOf(189508L, 189509L, 189510L)),

        // ── Group: medicine_anatomy_circulatory (5 words) ────────────────────

        WordEntity(id = 189512, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "עוֹרֵק",
            translation = "артерия",
            definition = "כְּלִי דָּם בַּעַל דָּפְנוֹת עָבוֹת הַמּוֹבִיל דָּם מְחֻמְצָן מֵהַלֵּב אֶל אֵיבְרֵי הַגּוּף.",
            definitionNative = "Кровеносный сосуд с толстыми стенками: несёт насыщенную кислородом кровь от сердца к органам.",
            example = "חֲסִימָה בָּעוֹרֵק הַמְּלִילִי בַּמֹּחַ גָּרְמָה לוֹ שָׁבָץ.",
            exampleNative = "Закупорка עוֹרֵק в мозге вызвала у него инсульт.",
            transliteration = "орэк",
            pos = "noun", semanticGroup = "medicine_anatomy_circulatory",
            fillInBlankExclusions = listOf(189513L, 189514L, 189515L, 189516L)),

        WordEntity(id = 189513, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "וְרִיד",
            translation = "вена",
            definition = "כְּלִי דָּם בַּעַל דָּפְנוֹת דַּקּוֹת הַמַּחְזִיר דָּם מֵהַגּוּף בַּחֲזָרָה אֶל הַלֵּב.",
            definitionNative = "Кровеносный сосуд с тонкими стенками: возвращает кровь от тела обратно к сердцу.",
            example = "הָאָחוֹת חִפְּשָׂה הַרְבֵּה זְמַן וְרִיד טוֹב לְעֵרוּי הַתְּרוּפָה.",
            exampleNative = "Медсестра долго искала подходящий וְרִיד для капельницы.",
            transliteration = "врид",
            pos = "noun", semanticGroup = "medicine_anatomy_circulatory",
            fillInBlankExclusions = listOf(189512L, 189514L, 189515L, 189516L)),

        WordEntity(id = 189514, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "נִימָה",
            translation = "капилляр",
            definition = "כְּלִי דָּם זָעִיר שֶׁדַּרְכּוֹ עוֹבְרִים חַמְצָן וְחֻמְרֵי תְּזוּנָה מֵהַדָּם אֶל הָרְקָמוֹת.",
            definitionNative = "Микроскопический сосуд, через стенку которого кислород и питательные вещества переходят из крови в ткани.",
            example = "נִימָה שֶׁנִּקְרְעָה מִתַּחַת לָעוֹר מַשְׁאִירָה כֶּתֶם אָדֹם קָטָן.",
            exampleNative = "Лопнувший под кожей נִימָה оставляет маленькое красное пятнышко.",
            transliteration = "нима",
            pos = "noun", semanticGroup = "medicine_anatomy_circulatory",
            fillInBlankExclusions = listOf(189512L, 189513L, 189515L, 189516L)),

        WordEntity(id = 189515, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "אָב הָעוֹרְקִים",
            translation = "аорта",
            definition = "כְּלִי הַדָּם הַגָּדוֹל בְּיוֹתֵר בַּגּוּף, יוֹצֵא מֵהַלֵּב וּמְזַן אֶת כָּל הָעוֹרְקִים הָרָאשִׁיִּים.",
            definitionNative = "Самый крупный сосуд тела: выходит из сердца и питает все главные артерии.",
            example = "קְרִיעָה בְּאָב הָעוֹרְקִים הִיא מַצָּב חֵרוּם מְסַכֵּן חַיִּים.",
            exampleNative = "Расслоение אָב הָעוֹרְקִים — это угрожающее жизни неотложное состояние.",
            transliteration = "ав hа-оркИм",
            pos = "phrase", semanticGroup = "medicine_anatomy_circulatory",
            fillInBlankExclusions = listOf(189512L, 189513L, 189514L, 189516L)),

        WordEntity(id = 189516, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "חֲדַר הַלֵּב",
            translation = "желудочек сердца",
            definition = "אַחַת מִשְּׁתֵי הַתָּאִים הַתַּחְתּוֹנִים שֶׁל הַלֵּב הַשּׁוֹאֲבִים דָּם הַחוּצָה בְּלַחַץ.",
            definitionNative = "Одна из двух нижних камер сердца: выталкивает кровь наружу под давлением.",
            example = "חֲדַר הַלֵּב הַשְּׂמָאלִי עוֹשֶׂה אֶת רֹב עֲבוֹדַת הַשְּׁאִיבָה בַּגּוּף.",
            exampleNative = "Левый חֲדַר הַלֵּב выполняет основную работу по перекачке крови в теле.",
            transliteration = "хадар hа-лэв",
            pos = "phrase", semanticGroup = "medicine_anatomy_circulatory",
            fillInBlankExclusions = listOf(189512L, 189513L, 189514L, 189515L)),

        // ── Group: medicine_anatomy_urogenital (5 words) ─────────────────────

        WordEntity(id = 189517, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "כִּלְיָה",
            translation = "почка",
            definition = "אֵיבָר בְּצוּרַת שְׁעוּעִית הַמְּסַנֵּן רַעֲלִים מֵהַדָּם וְיוֹצֵר שֶׁתֶן.",
            definitionNative = "Бобовидный орган: очищает кровь от шлаков и образует мочу.",
            example = "הוּא עוֹבֵר דִּיאָלִיזָה שָׁלֹשׁ פְּעָמִים בְּשָׁבוּעַ כִּי הַכִּלְיָה שֶׁלּוֹ הִפְסִיקָה לְתַפְקֵד.",
            exampleNative = "Он ходит на диализ три раза в неделю, потому что его כִּלְיָה перестала работать.",
            transliteration = "килья",
            pos = "noun", semanticGroup = "medicine_anatomy_urogenital",
            fillInBlankExclusions = listOf(189518L, 189519L, 189520L, 189521L)),

        WordEntity(id = 189518, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "שַׁלְפּוּחִית הַשֶּׁתֶן",
            translation = "мочевой пузырь",
            definition = "שַׂקִּיק שְׁרִירִי גָּמִישׁ בְּתַחְתִּית הַבֶּטֶן הַמְּאַחְסֵן שֶׁתֶן עַד לְהַטָּלָתוֹ.",
            definitionNative = "Эластичный мышечный мешок внизу живота: накапливает мочу до момента её выведения.",
            example = "אַחֲרֵי שָׁלֹשׁ כּוֹסוֹת תֵּה שַׁלְפּוּחִית הַשֶּׁתֶן שֶׁלִּי כִּמְעַט הִתְפּוֹצְצָה.",
            exampleNative = "После трёх чашек чая моя שַׁלְפּוּחִית הַשֶּׁתֶן чуть не лопнула.",
            transliteration = "шальпухит hа-шэтэн",
            pos = "phrase", semanticGroup = "medicine_anatomy_urogenital",
            fillInBlankExclusions = listOf(189517L, 189519L, 189520L, 189521L)),

        WordEntity(id = 189519, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "שִׁפְכָה",
            translation = "уретра (мочеиспускательный канал)",
            definition = "צִנּוֹר צַר הַמּוֹצִיא אֶת הַשֶּׁתֶן מִשַּׁלְפּוּחִית הַשֶּׁתֶן הַחוּצָה מֵהַגּוּף.",
            definitionNative = "Узкая трубка, по которой моча выходит из мочевого пузыря наружу.",
            example = "הָרוֹפֵא הִחְדִּיר קָתֵטֶר עָדִין דֶּרֶךְ הַשִּׁפְכָה אֶל שַׁלְפּוּחִית הַשֶּׁתֶן.",
            exampleNative = "Врач аккуратно ввёл катетер через שִׁפְכָה в мочевой пузырь.",
            transliteration = "шифха",
            pos = "noun", semanticGroup = "medicine_anatomy_urogenital",
            fillInBlankExclusions = listOf(189517L, 189518L, 189520L, 189521L)),

        WordEntity(id = 189520, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶשֶׁךְ",
            translation = "семенник, яичко",
            definition = "אֵיבָר זִכְרִי בַּעַל צוּרַת בֵּיצָה הַמְּיַצֵּר זֶרַע וְהוֹרְמוֹן טֶסְטוֹסְטֶרוֹן.",
            definitionNative = "Мужской орган яйцевидной формы: вырабатывает сперму и гормон тестостерон.",
            example = "הָרוֹפֵא הִמְלִיץ עַל בְּדִיקַת אוּלְטְרָאסָאוּנְד שֶׁל הָאֶשֶׁךְ אַחֲרֵי מְצִיאַת גּוּשׁ.",
            exampleNative = "После обнаружения уплотнения врач рекомендовал УЗИ אֶשֶׁךְ.",
            transliteration = "эшэх",
            pos = "noun", semanticGroup = "medicine_anatomy_urogenital",
            fillInBlankExclusions = listOf(189517L, 189518L, 189519L, 189521L)),

        WordEntity(id = 189521, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "שַׁחֲלָה",
            translation = "яичник",
            definition = "אַחַת מִשְּׁתֵי הַבְּלוּטוֹת הַנְּקֵבִיּוֹת הַמְּשַׁחְרְרוֹת בֵּיצִיּוֹת וּמַפְרִישׁוֹת הוֹרְמוֹנֵי מִין.",
            definitionNative = "Одна из двух женских желёз: выпускает яйцеклетки и вырабатывает половые гормоны.",
            example = "הָאוּלְטְרָאסָאוּנְד מָצָא צִיסְטָה קְטַנָּה עַל הַשַּׁחֲלָה הַיְּמָנִית שֶׁלָּהּ.",
            exampleNative = "УЗИ обнаружило маленькую кисту на её правой שַׁחֲלָה.",
            transliteration = "шахала",
            pos = "noun", semanticGroup = "medicine_anatomy_urogenital",
            fillInBlankExclusions = listOf(189517L, 189518L, 189519L, 189520L)),

        // ── Group: medicine_anatomy_endocrine (4 words) ──────────────────────

        WordEntity(id = 189522, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "בַּלּוּטָה",
            translation = "железа (орган)",
            definition = "אֵיבָר הַמְּיַצֵּר נוֹזֵל אוֹ הוֹרְמוֹן וּמַפְרִישׁ אוֹתוֹ אֶל הַגּוּף אוֹ אֶל פְּנֵי הַשֶּׁטַח שֶׁלּוֹ.",
            definitionNative = "Орган, производящий жидкость или гормон и выделяющий его в организм либо на поверхность тела.",
            example = "הָרוֹפֵא מִשֵּׁשׁ בַּלּוּטָה נְפוּחָה בְּצִדֵּי הַצַּוָּאר שֶׁלָּהּ.",
            exampleNative = "Врач нащупал увеличенную בַּלּוּטָה сбоку на её шее.",
            transliteration = "балута",
            pos = "noun", semanticGroup = "medicine_anatomy_endocrine",
            fillInBlankExclusions = listOf(189523L, 189524L, 189525L)),

        WordEntity(id = 189523, setId = 1895, languagePair = "he-ru", rarity = "RARE",
            original = "בַּלּוּטַת הַתְּרִיס",
            translation = "щитовидная железа",
            definition = "בַּלּוּטָה בְּצוּרַת פַּרְפַּר בִּקְדֵמַת הַצַּוָּאר הַמְּוַסֶּתֶת אֶת קֶצֶב חִלּוּף הַחֳמָרִים בַּגּוּף.",
            definitionNative = "Железа в форме бабочки на передней поверхности шеи: регулирует скорость обмена веществ в теле.",
            example = "הִיא לוֹקַחַת כַּדּוּר בְּכָל בֹּקֶר בִּגְלַל תַּת־פְּעִילוּת שֶׁל בַּלּוּטַת הַתְּרִיס.",
            exampleNative = "Она каждое утро пьёт таблетку из-за пониженной функции בַּלּוּטַת הַתְּרִיס.",
            transliteration = "балутат hа-трис",
            pos = "phrase", semanticGroup = "medicine_anatomy_endocrine",
            fillInBlankExclusions = listOf(189522L, 189524L, 189525L)),

        WordEntity(id = 189524, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "יוֹתֶרֶת הַכִּלְיָה",
            translation = "надпочечник",
            definition = "בַּלּוּטָה קְטַנָּה הַיּוֹשֶׁבֶת עַל גַּג הַכִּלְיָה וּמַפְרִישָׁה הוֹרְמוֹנֵי לַחַץ כְּגוֹן אַדְרֵנָלִין וְקוֹרְטִיזוֹל.",
            definitionNative = "Маленькая железа, сидящая на верхушке почки: выделяет гормоны стресса — адреналин и кортизол.",
            example = "לַחַץ כְּרוֹנִי בַּעֲבוֹדָה שׁוֹחֵק עִם הַשָּׁנִים אֶת יוֹתֶרֶת הַכִּלְיָה.",
            exampleNative = "Хронический стресс на работе с годами истощает יוֹתֶרֶת הַכִּלְיָה.",
            transliteration = "йотэрэт hа-килья",
            pos = "phrase", semanticGroup = "medicine_anatomy_endocrine",
            fillInBlankExclusions = listOf(189522L, 189523L, 189525L)),

        WordEntity(id = 189525, setId = 1895, languagePair = "he-ru", rarity = "EPIC",
            original = "יַתֶּרֶת הַמּוֹחַ",
            translation = "гипофиз",
            definition = "בַּלּוּטָה קְטַנָּה בְּגֹדֶל אֲפוּן בְּבָסִיס הַמֹּחַ הַמְּנַהֶלֶת אֶת רֹב הַהוֹרְמוֹנִים שֶׁל הַגּוּף.",
            definitionNative = "Железа размером с горошину у основания мозга: управляет большинством гормонов тела.",
            example = "גִּדּוּל קָטָן עַל יַתֶּרֶת הַמּוֹחַ יָכוֹל לִגְרֹם לִגְדִילָה פִּתְאוֹמִית גַּם בִּמְבֻגָּרִים.",
            exampleNative = "Маленькая опухоль на יַתֶּרֶת הַמּוֹחַ может вызвать внезапный рост даже у взрослых.",
            transliteration = "ятэрэт hа-моах",
            pos = "phrase", semanticGroup = "medicine_anatomy_endocrine",
            fillInBlankExclusions = listOf(189522L, 189523L, 189524L)),
    )
}
