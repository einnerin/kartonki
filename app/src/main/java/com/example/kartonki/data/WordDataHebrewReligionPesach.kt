package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1906 (he-ru).
 * Религия и праздники: Песах — седер, обряды и предметы
 *   (L3 / RARE + EPIC).
 *
 * Парный к set 1905 (Шабат). Второй главный ритуальный цикл иудаизма:
 * подготовка дома, ход седера, ритуальные блюда на קְעָרָה, тексты Агады,
 * календарные подразделения праздника.
 *
 * Базовая лексика темы (פֶּסַח, מַצָּה, סֵדֶר, הַגָּדָה, הַלֵּל, חָמֵץ,
 * חֲרוֹסֶת, הַגְעָלָה, שִׁיר הַשִּׁירִים) уже занята более ранними сетами темы
 * (ReligionL1, Batch10/45/50/82, Immigrant4/6, AliyaV2). Этот сет берёт
 * **сопутствующую** лексику — то, что окружает базовые термины, не
 * дублируя их.
 *
 * Исключены как дубли с существующими he-ru сетами темы:
 *   - פֶּסַח, מַצָּה, סֵדֶר, הַגָּדָה, הַלֵּל, חָמֵץ — ReligionL1,
 *     Batch10/50, Immigrant4/6 → заменены композитными фразами того же
 *     ритуального поля (סֵדֶר פֶּסַח, לֵיל הַסֵּדֶר, חַג הַמַּצּוֹת,
 *     בִּעוּר חָמֵץ).
 *   - חֲרוֹסֶת — Batch45 → заменено на марор/карпас/хазерет/зроа
 *     (остальные блюда седера).
 *   - הַגְעָלָה — Immigrant6 → заменено на בְּדִיקַת חָמֵץ и
 *     מְכִירַת חָמֵץ (два других этапа подготовки).
 *   - שִׁיר הַשִּׁירִים — Batch82 → заменено на שְׁפוֹךְ חֲמָתְךָ и
 *     אֶחָד מִי יוֹדֵעַ (другие литургические фрагменты седера).
 *
 * Кросс-темные коллизии — избежаны через композитные фразы:
 *   - זְרוֹעַ в Immigrant6 (set 1146, «Армия») = «род войск», UNCOMMON.
 *     Чтобы не плодить rarity-коллизию по одной лексеме, на пасхальное
 *     блюдо взят композитный термин זְרוֹעַ הַסֵּדֶר («косточка седера»).
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   RARE — 14 слов (B2, общеизвестные практикующим традицию: биур, бдика,
 *          кашрут лэ-пэсах, сэдэр пэсах, лэйль hа-сэдэр, кэарат hа-сэдэр,
 *          арба косот, марор, зроа, афикоман, ма ништана, дайейну, хад гадья,
 *          хаг hа-мацот, йэциат мицраим).
 *   EPIC — 11 слов (C1, более узкая литургическая или раввинская лексика:
 *          мхират хамэц, hасеба, карпас, хазерет, эхад ми йодеа, шфох
 *          хаматха, кос Элияhу, авадим hайину, холь hа-моэд, шви'и шэль
 *          пэсах).
 *
 * Пять семантических подгрупп:
 *   religion_pesach_preparation  — 4 слова: подготовка дома к Песаху
 *   religion_pesach_seder_order  — 5 слов: ход и атрибутика седера
 *   religion_pesach_foods        — 5 слов: ритуальные блюда на блюде седера
 *   religion_pesach_hagada_texts — 7 слов: песни и фрагменты текста Агады
 *   religion_pesach_calendar     — 4 слова: подразделения времени праздника
 *
 * Word IDs: 190601..190625 (setId × 100 + position).
 */
object WordDataHebrewReligionPesach {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1906, languagePair = "he-ru", orderIndex = 1906,
            name = "Религия и праздники",
            description = "Песах изнутри: подготовка (בְּדִיקַת חָמֵץ, מְכִירַת חָמֵץ), седер (קְעָרַת הַסֵּדֶר, אַרְבַּע כּוֹסוֹת, הַסֵּבָּה), блюдо (מָרוֹר, זְרוֹעַ, כַּרְפַּס), Агада (מָה נִשְׁתַּנָּה, דַּיֵּינוּ, חַד גַּדְיָא)",
            topic = "Религия и праздники",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: religion_pesach_preparation (4 words) ──────────────────────

        WordEntity(id = 190601, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "בִּעוּר חָמֵץ",
            translation = "сжигание квасного",
            definition = "טֶקֶס שְׂרֵפַת שְׁאֵרִיּוֹת לֶחֶם וּבָצֵק בְּבֹקֶר עֶרֶב הַחַג, לִפְנֵי הַשָּׁעָה הָעֲשִׂירִית.",
            definitionNative = "Обряд сжигания остатков хлеба и теста утром накануне праздника, до десятого часа.",
            example = "אַבָּא הִדְלִיק מְדוּרַת בִּעוּר חָמֵץ בֶּחָצֵר.",
            exampleNative = "Папа разжёг костёр בִּעוּר חָמֵץ во дворе.",
            transliteration = "биур хамэц",
            pos = "phrase", semanticGroup = "religion_pesach_preparation", fillInBlankExclusions = listOf(190602L, 190603L, 190604L)),

        WordEntity(id = 190602, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "בְּדִיקַת חָמֵץ",
            translation = "поиск квасного",
            definition = "מַעֲשֶׂה חִיפּוּשׂ פֵּרוּרֵי לֶחֶם בַּבַּיִת בְּעֶרֶב הַחַג לְאוֹר נֵר, עִם נוֹצָה וְכַף עֵץ.",
            definitionNative = "Действо поиска крошек хлеба в доме вечером накануне праздника при свече, с пёрышком и деревянной ложкой.",
            example = "הַיְלָדִים עָזְרוּ בִּבְדִיקַת חָמֵץ עִם נֵר קָטָן.",
            exampleNative = "Дети помогали с בְּדִיקַת חָמֵץ с маленькой свечой.",
            transliteration = "бдикат хамэц",
            pos = "phrase", semanticGroup = "religion_pesach_preparation"),

        WordEntity(id = 190603, setId = 1906, languagePair = "he-ru", rarity = "EPIC",
            original = "מְכִירַת חָמֵץ",
            translation = "продажа квасного",
            definition = "הֶסְכֵּם מִשְׁפָּטִי שֶׁבּוֹ מוֹסְרִים בְּעֵרֶךְ אֶת הַמּוּצָרִים הָאֲסוּרִים לְגוֹי לְכָל יְמֵי הַחַג.",
            definitionNative = "Юридическое соглашение, по которому запрещённые продукты формально передают нееврею на все дни праздника.",
            example = "הָרַב חָתַם עַל מְכִירַת חָמֵץ שֶׁל כָּל הַקְּהִילָּה.",
            exampleNative = "Раввин подписал מְכִירַת חָמֵץ за всю общину.",
            transliteration = "мхират хамэц",
            pos = "phrase", semanticGroup = "religion_pesach_preparation", fillInBlankExclusions = listOf(190601L, 190602L, 190604L)),

        WordEntity(id = 190604, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "כַּשְׁרוּת לְפֶסַח",
            translation = "кашерность к Песаху",
            definition = "תַּקָּנוֹת מַחְמִירוֹת עַל מָזוֹן וְכֵלִים, שֶׁאוֹסְרוֹת כָּל שְׁאֵר תְּבוּאָה תְּפוּחָה בִּימֵי הַחַג.",
            definitionNative = "Строгие требования к пище и посуде, запрещающие любое поднявшееся зерно в дни праздника.",
            example = "הָאֹרֶז קִבֵּל תָּו כַּשְׁרוּת לְפֶסַח מֵהָרַבָּנוּת.",
            exampleNative = "Рис получил знак כַּשְׁרוּת לְפֶסַח от раввината.",
            transliteration = "кашрут лэ-пэсах",
            pos = "phrase", semanticGroup = "religion_pesach_preparation", fillInBlankExclusions = listOf(190601L, 190602L, 190603L)),

        // ── Group: religion_pesach_seder_order (5 words) ──────────────────────

        WordEntity(id = 190605, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "סֵדֶר פֶּסַח",
            translation = "пасхальный седер",
            definition = "אֲרוּחַת לַיְלָה חֲגִיגִית בְּעֶרֶב הָרִאשׁוֹן, שֶׁעוֹבֶרֶת לְפִי חֲמֵשׁ עֶשְׂרֵה תַּחֲנוֹת קְבוּעוֹת.",
            definitionNative = "Торжественный ночной ужин в первый вечер, проходящий по пятнадцати фиксированным этапам.",
            example = "סֵדֶר פֶּסַח אֶצְלָם נִמְשַׁךְ עַד שָׁלוֹשׁ לִפְנוֹת בֹּקֶר.",
            exampleNative = "סֵדֶר פֶּסַח у них длился до трёх ночи.",
            transliteration = "сэдэр пэсах",
            pos = "phrase", semanticGroup = "religion_pesach_seder_order", fillInBlankExclusions = listOf(190606L, 190607L, 190608L)),

        WordEntity(id = 190606, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "לֵיל הַסֵּדֶר",
            translation = "ночь седера",
            definition = "הָעֶרֶב הָרִאשׁוֹן שֶׁל הַחַג, שֶׁבּוֹ הַמִּשְׁפָּחָה יוֹשֶׁבֶת סְבִיב הַשֻּׁלְחָן וְקוֹרֵאת מִתּוֹךְ הַסֵּפֶר.",
            definitionNative = "Первый вечер праздника, когда семья сидит вокруг стола и читает из книги.",
            example = "בְּלֵיל הַסֵּדֶר אֲנַחְנוּ מַזְמִינִים אֶת הַסַּבְתָּא וְהַסַּבָּא.",
            exampleNative = "На לֵיל הַסֵּדֶר мы зовём бабушку и дедушку.",
            transliteration = "лэйль hа-сэдэр",
            pos = "phrase", semanticGroup = "religion_pesach_seder_order", fillInBlankExclusions = listOf(190605L, 190607L, 190608L)),

        WordEntity(id = 190607, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "קְעָרַת הַסֵּדֶר",
            translation = "блюдо седера",
            definition = "צַלַּחַת גְּדוֹלָה עִם שֵׁשׁ תָּאִים, שֶׁמְּסַדְּרִים עָלֶיהָ אֶת הַמַּאֲכָלִים הַסִּימְלִיִּים שֶׁל הַלַּיְלָה.",
            definitionNative = "Большое блюдо с шестью ячейками, на котором раскладывают символические кушанья ночи.",
            example = "קְעָרַת הַסֵּדֶר עָמְדָה בְּמֶרְכַּז הַשֻּׁלְחָן.",
            exampleNative = "קְעָרַת הַסֵּדֶר стояла в центре стола.",
            transliteration = "кэарат hа-сэдэр",
            pos = "phrase", semanticGroup = "religion_pesach_seder_order", fillInBlankExclusions = listOf(190605L, 190606L, 190608L)),

        WordEntity(id = 190608, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "אַרְבַּע כּוֹסוֹת",
            translation = "четыре бокала",
            definition = "חוֹבָה לִשְׁתּוֹת אַרְבַּע כּוֹסִיּוֹת יַיִן בְּמַהֲלַךְ הַלַּיְלָה, כְּנֶגֶד אַרְבַּע לְשׁוֹנוֹת שֶׁל גְּאוּלָּה.",
            definitionNative = "Обязанность за ночь выпить четыре чарки вина — по числу четырёх выражений избавления.",
            example = "אַחֲרֵי אַרְבַּע כּוֹסוֹת הוּא נִרְדַּם עַל הַסַּפָּה.",
            exampleNative = "После אַרְבַּע כּוֹסוֹת он уснул на диване.",
            transliteration = "арба косот",
            pos = "phrase", semanticGroup = "religion_pesach_seder_order", fillInBlankExclusions = listOf(190605L, 190606L, 190607L)),

        WordEntity(id = 190609, setId = 1906, languagePair = "he-ru", rarity = "EPIC",
            original = "הַסֵּבָּה",
            translation = "возлежание за столом",
            definition = "מִנְהָג לִשְׁעוֹן עַל הַצַּד הַשְּׂמָאלִי בִּזְמַן שְׁתִיָּה וַאֲכִילָה, כְּסִימָן שֶׁל בְּנֵי חוֹרִין.",
            definitionNative = "Обычай облокачиваться на левый бок во время питья и еды — как знак свободного человека.",
            example = "הוּא שָׁתָה אֶת הַכּוֹס בְּהַסֵּבָּה כְּמוֹ הָאַחֲרוֹנִים.",
            exampleNative = "Он выпил бокал в הַסֵּבָּה, как остальные.",
            transliteration = "hасэба",
            pos = "noun", semanticGroup = "religion_pesach_seder_order"),

        // ── Group: religion_pesach_foods (5 words) ────────────────────────────

        WordEntity(id = 190610, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "מָרוֹר",
            translation = "горькая зелень",
            definition = "יָרָק מַר שֶׁאוֹכְלִים בַּלַּיְלָה לְזֵכֶר עֲבוֹדַת הַפֶּרֶךְ שֶׁל הָאָבוֹת בְּמִצְרַיִם.",
            definitionNative = "Горький овощ, который едят ночью в память о тяжком труде предков в Египте.",
            example = "הַסַּבָּא לָעַס אֶת הַמָּרוֹר בְּלִי לְהַעֲוֵה פָּנִים.",
            exampleNative = "Дедушка жевал מָרוֹר, не морщась.",
            transliteration = "марор",
            pos = "noun", semanticGroup = "religion_pesach_foods"),

        WordEntity(id = 190611, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "זְרוֹעַ הַסֵּדֶר",
            translation = "пасхальная косточка",
            definition = "עֶצֶם שָׂרוּף שֶׁל עוֹף שֶׁמַּנִּיחִים עַל הַקְּעָרָה לְזֵכֶר קָרְבַּן הַפֶּסַח שֶׁל יְמֵי הַבַּיִת.",
            definitionNative = "Опалённая куриная косточка на блюде — в память о пасхальной жертве времён Храма.",
            example = "אִמָּא שָׂמָה זְרוֹעַ הַסֵּדֶר לְיַד הַבֵּיצָה.",
            exampleNative = "Мама положила זְרוֹעַ הַסֵּדֶר рядом с яйцом.",
            transliteration = "зроа hа-сэдэр",
            pos = "phrase", semanticGroup = "religion_pesach_foods"),

        WordEntity(id = 190612, setId = 1906, languagePair = "he-ru", rarity = "EPIC",
            original = "כַּרְפַּס",
            translation = "зелень для омакания",
            definition = "יָרָק יָרֹק — בְּדֶרֶךְ כְּלָל פֶּטְרוֹזִילִיָּה אוֹ תַּפּוּחַ אֲדָמָה — שֶׁטּוֹבְלִים בְּמֵי מֶלַח בְּתָאוּת הַסֵּדֶר.",
            definitionNative = "Зелёный овощ — обычно петрушка или картофель — который окунают в подсолённую воду на этапе седера.",
            example = "הַיֶּלֶד טָבַל אֶת הַכַּרְפַּס בַּמֶּלַח וְצָחַק.",
            exampleNative = "Мальчик окунул כַּרְפַּס в соль и засмеялся.",
            transliteration = "карпас",
            pos = "noun", semanticGroup = "religion_pesach_foods", fillInBlankExclusions = listOf(190610L, 190611L, 190613L, 190614L)),

        WordEntity(id = 190613, setId = 1906, languagePair = "he-ru", rarity = "EPIC",
            original = "חֲזֶרֶת",
            translation = "хрен или салат-латук",
            definition = "יָרָק חָרִיף שֶׁמְּמַלֵּא אֶת תַּפְקִיד הַיָּרָק הַמַּר בִּסְעוּדַת הַלַּיְלָה לְפִי מִנְהָגֵי אֵירוֹפָּה.",
            definitionNative = "Острый овощ, исполняющий роль горькой зелени в ночной трапезе по европейскому обычаю.",
            example = "הוּא גָּרַד חֲזֶרֶת טְרִיָּה לְכָל הָאוֹרְחִים.",
            exampleNative = "Он натёр свежий חֲזֶרֶת всем гостям.",
            transliteration = "хазэрэт",
            pos = "noun", semanticGroup = "religion_pesach_foods", fillInBlankExclusions = listOf(190610L, 190611L, 190612L, 190614L)),

        WordEntity(id = 190614, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "אֲפִיקוֹמָן",
            translation = "афикоман (кусок мацы)",
            definition = "חֲצִי הַמַּצָּה הָאֶמְצָעִית, שֶׁמַּחְבִּיאִים בִּתְחִלַּת הַלַּיְלָה וְאוֹכְלִים בְּסוֹף הַסְּעוּדָה.",
            definitionNative = "Половинка средней опресночной лепёшки — её прячут в начале ночи и съедают в конце ужина.",
            example = "הַיֶּלֶד מָצָא אֲפִיקוֹמָן מִתַּחַת לַכָּרִית.",
            exampleNative = "Мальчик нашёл אֲפִיקוֹמָן под подушкой.",
            transliteration = "афикоман",
            pos = "noun", semanticGroup = "religion_pesach_foods", fillInBlankExclusions = listOf(190610L, 190611L, 190612L, 190613L)),

        // ── Group: religion_pesach_hagada_texts (7 words) ─────────────────────

        WordEntity(id = 190615, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "מָה נִשְׁתַּנָּה",
            translation = "«чем эта ночь отличается»",
            definition = "אַרְבַּע הַשְּׁאֵלוֹת שֶׁשּׁוֹאֵל הַיֶּלֶד הַצָּעִיר בִּתְחִלַּת הַטֶּקֶס, עַל הֶבְדֵּלֵי הַלַּיְלָה.",
            definitionNative = "Четыре вопроса, которые младший ребёнок задаёт в начале обряда — об отличиях этой ночи.",
            example = "הַבַּת הַקְּטַנָּה שָׁאֲלָה אֶת מָה נִשְׁתַּנָּה בְּקוֹל רוֹעֵד.",
            exampleNative = "Младшая дочь спросила מָה נִשְׁתַּנָּה дрожащим голосом.",
            transliteration = "ма ништана",
            pos = "phrase", semanticGroup = "religion_pesach_hagada_texts", fillInBlankExclusions = listOf(190617L, 190618L, 190619L, 190620L, 190621L)),

        WordEntity(id = 190616, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "דַּיֵּינוּ",
            translation = "«нам было бы достаточно»",
            definition = "פִּיּוּט בֶּן חֲמֵשׁ עֶשְׂרֵה שׁוּרוֹת, שֶׁמּוֹדֶה עַל כָּל שָׁלָב בִּנְפָרָד שֶׁל יְצִיאַת הָעָם מִמִּצְרַיִם.",
            definitionNative = "Пиют из пятнадцати строк, благодарящий за каждый этап выхода народа из Египта по отдельности.",
            example = "הַיְלָדִים שָׁרוּ דַּיֵּינוּ בְּקוֹל וְהִתְמַחָאוּ כַּף.",
            exampleNative = "Дети пели דַּיֵּינוּ во весь голос и хлопали в ладоши.",
            transliteration = "дайейну",
            pos = "interjection", semanticGroup = "religion_pesach_hagada_texts"),

        WordEntity(id = 190617, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "חַד גַּדְיָא",
            translation = "«один козлёнок»",
            definition = "שִׁיר אֲרַמִּי מַצְטַבֵּר שֶׁסּוֹגֵר אֶת הַלַּיְלָה, עַל גְּדִי שֶׁאָבָא קָנָה בִּשְׁנֵי זוּזִים.",
            definitionNative = "Арамейская накопительная песня, закрывающая ночь — о козлёнке, которого отец купил за две монетки.",
            example = "אַחֲרֵי חַד גַּדְיָא כָּל הַשֻּׁלְחָן צָחַק.",
            exampleNative = "После חַד גַּדְיָא весь стол смеялся.",
            transliteration = "хад гадья",
            pos = "phrase", semanticGroup = "religion_pesach_hagada_texts", fillInBlankExclusions = listOf(190615L, 190618L, 190619L, 190620L, 190621L)),

        WordEntity(id = 190618, setId = 1906, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶחָד מִי יוֹדֵעַ",
            translation = "«кто знает один»",
            definition = "שִׁיר חִידוֹת מִשְּׁלוֹשׁ עֶשְׂרֵה שׁוּרוֹת עַל מִסְפָּרִים, שֶׁבּוֹ כָּל מִסְפָּר רוֹמֵז לְעִקָּר שֶׁל הַתּוֹרָה.",
            definitionNative = "Песня-загадка из тринадцати строк о числах, где каждое число намекает на основу Торы.",
            example = "אֶחָד מִי יוֹדֵעַ עוֹזֵר לַיְלָדִים לִלְמֹד מִסְפָּרִים.",
            exampleNative = "אֶחָד מִי יוֹדֵעַ помогает детям учить числа.",
            transliteration = "эхад ми йодеа",
            pos = "phrase", semanticGroup = "religion_pesach_hagada_texts"),

        WordEntity(id = 190619, setId = 1906, languagePair = "he-ru", rarity = "EPIC",
            original = "שְׁפוֹךְ חֲמָתְךָ",
            translation = "«излей гнев Твой»",
            definition = "קֶטַע קָצָר מִתְּהִילִּים שֶׁאוֹמְרִים אַחֲרֵי הַסְּעוּדָה, כְּשֶׁפּוֹתְחִים אֶת הַדֶּלֶת לְאֵלִיָּהוּ.",
            definitionNative = "Короткий отрывок из Псалмов, который произносят после ужина, открывая дверь Илье-пророку.",
            example = "אַבָּא קָם וּפָתַח אֶת הַדֶּלֶת בִּזְמַן שְׁפוֹךְ חֲמָתְךָ.",
            exampleNative = "Папа встал и открыл дверь в момент שְׁפוֹךְ חֲמָתְךָ.",
            transliteration = "шфох хаматха",
            pos = "phrase", semanticGroup = "religion_pesach_hagada_texts"),

        WordEntity(id = 190620, setId = 1906, languagePair = "he-ru", rarity = "EPIC",
            original = "כּוֹס שֶׁל אֵלִיָּהוּ",
            translation = "бокал пророка Илии",
            definition = "כּוֹסִית חֲמִישִׁית שֶׁמְּמַלְּאִים עַל הַשֻּׁלְחָן אֲבָל לֹא שׁוֹתִים — שְׁמוּרָה לִנְבִיא הַגְּאוּלָּה.",
            definitionNative = "Пятая чарка, которую наполняют на столе, но не пьют — её хранят для пророка избавления.",
            example = "כּוֹס שֶׁל אֵלִיָּהוּ נִשְׁאֲרָה מְלֵאָה עַד הַסּוֹף.",
            exampleNative = "כּוֹס שֶׁל אֵלִיָּהוּ оставался полным до конца.",
            transliteration = "кос шэль элияhу",
            pos = "phrase", semanticGroup = "religion_pesach_hagada_texts"),

        WordEntity(id = 190621, setId = 1906, languagePair = "he-ru", rarity = "EPIC",
            original = "עֲבָדִים הָיִינוּ",
            translation = "«рабами были мы»",
            definition = "מִשְׁפָּט פּוֹתֵחַ שֶׁל סִפּוּר הַיְּצִיאָה: כָּל אֶחָד מְחוּיָּב לִרְאוֹת אֶת עַצְמוֹ כְּמִי שֶׁשּׁוּחְרַר.",
            definitionNative = "Начальная фраза рассказа об Исходе: каждый обязан видеть себя так, словно лично освобождён.",
            example = "הַסַּבָּא הִתְחִיל בְּעֲבָדִים הָיִינוּ וְהִכָּה עַל הַשֻּׁלְחָן.",
            exampleNative = "Дедушка начал с עֲבָדִים הָיִינוּ и хлопнул по столу.",
            transliteration = "авадим hайину",
            pos = "phrase", semanticGroup = "religion_pesach_hagada_texts"),

        // ── Group: religion_pesach_calendar (4 words) ─────────────────────────

        WordEntity(id = 190622, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "חַג הַמַּצּוֹת",
            translation = "Праздник опресноков",
            definition = "הַשֵּׁם הַתּוֹרָתִי שֶׁל הַחַג, עַל שֵׁם הַלֶּחֶם הַשָּׁטוּחַ שֶׁאוֹכְלִים שִׁבְעָה יָמִים.",
            definitionNative = "Тороическое название праздника — по плоскому хлебу, который едят семь дней подряд.",
            example = "בַּסִּדּוּר הַחַג נִקְרָא חַג הַמַּצּוֹת, לֹא פֶּסַח.",
            exampleNative = "В молитвеннике праздник зовётся חַג הַמַּצּוֹת, а не Песах.",
            transliteration = "хаг hа-мацот",
            pos = "phrase", semanticGroup = "religion_pesach_calendar", fillInBlankExclusions = listOf(190623L, 190624L, 190625L)),

        WordEntity(id = 190623, setId = 1906, languagePair = "he-ru", rarity = "EPIC",
            original = "חֹל הַמּוֹעֵד",
            translation = "будни праздника",
            definition = "אַרְבָּעָה יָמִים בְּאֶמְצַע הַחַג, שֶׁבָּהֶם רֹב הַמְּלָאכוֹת מוּתָּרוֹת אֲבָל הָאֳפִי שֶׁל מוֹעֵד נִשְׁמָר.",
            definitionNative = "Четыре дня в середине праздника, когда большинство работ разрешены, но праздничный характер сохраняется.",
            example = "בְּחֹל הַמּוֹעֵד הִיא נָסְעָה לַטִּיּוּל שֶׁל הַמִּשְׁפָּחָה.",
            exampleNative = "В חֹל הַמּוֹעֵד она поехала с семьёй в поход.",
            transliteration = "холь hа-моэд",
            pos = "phrase", semanticGroup = "religion_pesach_calendar", fillInBlankExclusions = listOf(190622L, 190624L, 190625L)),

        WordEntity(id = 190624, setId = 1906, languagePair = "he-ru", rarity = "EPIC",
            original = "שְׁבִיעִי שֶׁל פֶּסַח",
            translation = "седьмой день Песаха",
            definition = "יוֹם טוֹב שֶׁבְּסוֹף הַשָּׁבוּעַ, לְזֵכֶר קְרִיעַת יַם סוּף וְהַצָּלַת הָאָבוֹת מִיַּד פַּרְעֹה.",
            definitionNative = "Праздничный день в конце недели — в память о рассечении Тростникового моря и спасении предков от фараона.",
            example = "בִּשְׁבִיעִי שֶׁל פֶּסַח הֵם הָלְכוּ לְבֵית הַכְּנֶסֶת מֻקְדָּם.",
            exampleNative = "На שְׁבִיעִי שֶׁל פֶּסַח они пошли в синагогу рано.",
            transliteration = "шви'и шэль пэсах",
            pos = "phrase", semanticGroup = "religion_pesach_calendar", fillInBlankExclusions = listOf(190622L, 190623L, 190625L)),

        WordEntity(id = 190625, setId = 1906, languagePair = "he-ru", rarity = "RARE",
            original = "יְצִיאַת מִצְרַיִם",
            translation = "Исход из Египта",
            definition = "הָאֵרוּעַ הַמְּכוֹנֵן שֶׁל הָעָם — שִׁחְרוּר הָאָבוֹת מֵעַבְדוּת וְהַיְּצִיאָה לַמִּדְבָּר אֶל הַחֵרוּת.",
            definitionNative = "Учреждающее событие народа — освобождение предков из рабства и выход в пустыню навстречу свободе.",
            example = "כָּל הַסִּפּוּר שֶׁל הַלַּיְלָה סוֹבֵב סְבִיב יְצִיאַת מִצְרַיִם.",
            exampleNative = "Весь рассказ ночи крутится вокруг יְצִיאַת מִצְרַיִם.",
            transliteration = "йэциат мицраим",
            pos = "phrase", semanticGroup = "religion_pesach_calendar", fillInBlankExclusions = listOf(190622L, 190623L, 190624L)),
    )
}
