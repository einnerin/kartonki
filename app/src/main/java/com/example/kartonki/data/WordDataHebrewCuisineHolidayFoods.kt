package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1916 (he-ru).
 * Кулинария Израиля: праздничные блюда еврейского календаря (L3 / UNCOMMON + RARE).
 *
 * Уникальный для he-ru угол: праздничные кушанья, привязанные к конкретным
 * датам еврейского календаря — Ханука, Пурим, Песах, Шавуот, Шабат и Ту
 * би-Шват. Дополняет триаду религиозных сетов 1905 (Шабат), 1906 (Песах),
 * 1907 (Ямим Нораим): там — порядок служб, тексты молитв, предметы;
 * здесь — конкретные блюда на каждом празднике с объяснением символики.
 *
 * Распределение редкости (validate_rarity_spread: 2 смежных уровня):
 *   UNCOMMON — 10 слов (A2-B1): общепонятные блюда и компоненты, известные
 *     многим израильтянам и репатриантам (шемен заит, гвина лвана, мишлоах
 *     манот, сэудат пурим, маахалэй халав, угат гвина, марк тарнэголет,
 *     хала агула, пэйрот йэвэшим, бэйца каша).
 *   RARE — 15 слов (B2): специализированная праздничная лексика и редкие
 *     ашкеназские/сефардские дворовые блюда (суфганья, бимуэлос, крэйхит,
 *     крэплах, мацат мицва, кофтаот, маца брэйа, марор, марк кофтаот,
 *     блинцэс, крэп гвина, хольнт, кугль йерушалми, шиват hа-миним, тиш).
 *
 * Rarity выровнен с существующими дублями в других темах (правило: при
 * повторе слова в разных темах rarity должен совпадать с pre-existing):
 *   - מִשְׁלוֹחַ מָנוֹת=UNCOMMON (set 1035, Immigrant4)
 *   - מָרוֹר=RARE (set 1906, ReligionPesach)
 *
 * Не пересекается со словами в существующих he-ru сетах темы «Кулинария
 * Израиля» (1842, 1843, 1844, 1845, 1846). Исключены кандидаты-дубли
 * внутри одной темы:
 *   - חָמִין — в set 1842 (IsraeliCuisineL1, та же тема)
 *   - קוּגֶל (одиночный) — в set 1843 (IsraeliCuisineL2, та же тема);
 *     остаётся составное קוּגְל יְרוּשַׁלְמִי (другая лексема — иерусалимский)
 *   - אָזְנֵי הָמָן — в set 1843 (IsraeliCuisineL2, та же тема)
 *   - קְנֵיידְלָךְ (одиночный) — в set 1843; остаётся составное מַרְק
 *     קְנֵיידְלָאךְ (другая лексема — суп с кнэйдлах)
 *
 * Слова, имеющиеся в других темах (НЕ «Кулинария Израиля») — допустимы:
 *   - שֶׁמֶן זַיִת — в Immigrant5 / set 1143 («Еда и кулинария»); там
 *     общекулинарный смысл, здесь — ритуальное масло для свечей Хануки
 *   - מִשְׁלוֹחַ מָנוֹת — в Immigrant4 / set 1035 («Религия и праздники»)
 *   - מָרוֹר — в WordDataHebrewReligionPesach (другая тема «Религия и
 *     праздники», ритуально-обрядовый контекст)
 *   - סוּפְגָּנִיָּה — в RelHolidaysL1 / set 1710 (праздничный аксессуар);
 *     здесь — расширенное определение с символикой чуда масла
 *
 * Дополнительно исключён לְבִיבָה: в set 1710 помечен COMMON, что
 * несовместимо с разбросом RARE+UNCOMMON; заменён сефардским аналогом
 * בִּמּוּאֵלוֹס (Хануке тоже специфичен, RARE, без коллизий).
 *   - פֵּירוֹת יְבֵשִׁים — встречается в общеботанических контекстах,
 *     здесь как символ Ту би-Шват
 * Cross-topic дубли разрешены валидатором.
 *
 * Шесть семантических подгрупп (validate_group_sizes: 3-8 на группу):
 *   food_holidays_hanukkah — 4: ханукальная еда (масло, пончики, латкес)
 *   food_holidays_purim    — 4: пуримская еда (мишлоах манот, крэплах)
 *   food_holidays_pesach   — 5: пасхальная еда (маца, кнэйдлах, марор)
 *   food_holidays_shavuot  — 4: молочные блюда Шавуот (чизкейк, блинцы)
 *   food_holidays_shabbat  — 4: шабатние блюда (хольнт, иерусалимский кугль)
 *   food_holidays_other    — 4: Ту би-Шват и ритуальное (сухофрукты, яйцо)
 *
 * Все слова помечены isFillInBlankSafe=false: ивритская морфология (биньян,
 * огласовки, артикли ה/ב/ל/מ, смихут — многие записи — фразы из 2-3 слов)
 * ломает подстрочную замену в FILL_IN_BLANK, пока не реализована Hebrew-aware
 * логика. Финальный pipeline проставит exclusions и снимет флаг для
 * безопасных слов.
 *
 * Word IDs: 191601..191625 (setId × 100 + position).
 */
object WordDataHebrewCuisineHolidayFoods {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1916, languagePair = "he-ru", orderIndex = 1916,
            name = "Кулинария Израиля",
            description = "Праздничные блюда календаря: суфганьот на Хануку, гоменташи на Пурим, маца и кнейдлах на Песах, чизкейк на Шавуот, хольнт на Шабат.",
            topic = "Кулинария Израиля",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: food_holidays_hanukkah (4 words) ───────────────────────────

        WordEntity(id = 191601, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "סוּפְגָּנִיָּה",
            translation = "суфганья (ханукальный пончик)",
            definition = "כַּדּוּר בָּצֵק מְטֻגָּן בְּשֶׁמֶן עָמֹק, מְמֻלָּא רִבָּה אוֹ קְרֶם וּמְפֻזָּר אֲבְקַת סֻכָּר.",
            definitionNative = "Шарик теста, обжаренный в масле, с начинкой из джема или крема и сахарной пудрой.",
            example = "בְּחַג הַחֲנֻכָּה אוֹכְלִים סוּפְגָּנִיָּה כְּסֵמֶל לְנֵס פַּךְ הַשֶּׁמֶן.",
            exampleNative = "В Хануку едят סוּפְגָּנִיָּה как символ чуда с кувшинчиком масла.",
            transliteration = "суфганья",
            pos = "noun", semanticGroup = "food_holidays_hanukkah", fillInBlankExclusions = listOf(191602L)),

        WordEntity(id = 191602, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "בִּמּוּאֵלוֹס",
            translation = "бимуэлос (сефардские ханукальные пончики в сиропе)",
            definition = "כַּדּוּרֵי בָּצֵק מְטֻגָּנִים בְּשֶׁמֶן עָמֹק וְטוֹבְלִים בִּסְרֻפֵּי דְּבַשׁ — מָסֹרֶת סְפָרַדִּית לַחֲנֻכָּה.",
            definitionNative = "Шарики теста, жаренные в масле и пропитанные медовым сиропом — сефардская традиция Хануки.",
            example = "סָבְתָּא מִתֶּימָן הֵכִינָה בִּמּוּאֵלוֹס לַנְּכָדִים בְּחַג הָאוּרִים.",
            exampleNative = "Йеменская бабушка приготовила бимуэлос внукам в праздник огней.",
            transliteration = "бимуэлос",
            pos = "noun", semanticGroup = "food_holidays_hanukkah", fillInBlankExclusions = listOf(191601L)),

        WordEntity(id = 191603, setId = 1916, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שֶׁמֶן זַיִת",
            translation = "оливковое масло (ритуальное)",
            definition = "שֶׁמֶן הַמּוּפָק מִזֵּיתִים — מַזְכִּיר אֶת נֵס פַּךְ הַשֶּׁמֶן שֶׁדָּלַק שְׁמוֹנָה יָמִים.",
            definitionNative = "Масло из оливок — напоминает о чуде кувшинчика, горевшего восемь дней в Храме.",
            example = "טִגְּנוּ אֶת הַסּוּפְגָּנִיּוֹת בְּשֶׁמֶן זַיִת כְּמוֹ בַּמָּסֹרֶת הָעַתִּיקָה.",
            exampleNative = "Пончики жарили в שֶׁמֶן זַיִת по древней традиции праздника.",
            transliteration = "шемен заит",
            pos = "phrase", semanticGroup = "food_holidays_hanukkah", fillInBlankExclusions = listOf(191604L)),

        WordEntity(id = 191604, setId = 1916, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּבִינָה לְבָנָה",
            translation = "белый сыр (для летних блюд Хануки)",
            definition = "גְּבִינַת קוֹטֵג' רַכָּה — בְּמָסֹרֶת אַחַת אוֹכְלִים אוֹתָהּ לְזֵכֶר יְהוּדִית שֶׁהֶאֱכִילָה אֶת הוֹלוֹפֶרְנֵס.",
            definitionNative = "Мягкий творожный сыр — по преданию едят в память о Юдифи, угощавшей сыром Олоферна.",
            example = "אִמָּא הֵכִינָה לְבִיבוֹת עִם גְּבִינָה לְבָנָה לְכָבוֹד חֲנֻכָּה.",
            exampleNative = "Мама приготовила оладьи с גְּבִינָה לְבָנָה в честь Хануки.",
            transliteration = "гвина лвана",
            pos = "phrase", semanticGroup = "food_holidays_hanukkah", fillInBlankExclusions = listOf(191603L)),

        // ── Group: food_holidays_purim (4 words) ──────────────────────────────

        WordEntity(id = 191605, setId = 1916, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִשְׁלוֹחַ מָנוֹת",
            translation = "мишлоах манот (подарочный набор еды)",
            definition = "חֲבִילַת מַאֲכָלִים שֶׁשּׁוֹלְחִים לְחָבֵר בְּפוּרִים — מִצְוָה מֵהַמְּגִילָּה.",
            definitionNative = "Набор еды, который дарят другу на Пурим — заповедь, прописанная в Книге Эстер.",
            example = "הַיְּלָדִים חִלְּקוּ מִשְׁלוֹחַ מָנוֹת לַשְּׁכֵנִים בְּבֹּקֶר פּוּרִים.",
            exampleNative = "Дети разнесли מִשְׁלוֹחַ מָנוֹת соседям в утро Пурима.",
            transliteration = "мишлоах манот",
            pos = "phrase", semanticGroup = "food_holidays_purim", fillInBlankExclusions = listOf(191608L)),

        WordEntity(id = 191606, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "כְּרֵיכִית",
            translation = "крэйхит (треугольное печенье с начинкой)",
            definition = "מַאֲפֶה מָתוֹק מְשֻׁלָּשׁ עִם מִלּוּי פֵּירוֹת, פֶּרֶג אוֹ שׁוֹקוֹלָד — מַסְמִיל אֶת כִּסֵּא הַמֶּלֶךְ.",
            definitionNative = "Сладкое треугольное печенье с начинкой из фруктов, мака или шоколада — символ короны царя.",
            example = "הָאוֹפָה הוֹצִיא מֵהַתַּנּוּר מַגַּשׁ שֶׁל כְּרֵיכִית רֵיחָנִית לְכָבוֹד הַחַג.",
            exampleNative = "Пекарь достал из печи поднос ароматных כְּרֵיכִית к празднику.",
            transliteration = "крэйхит",
            pos = "noun", semanticGroup = "food_holidays_purim", fillInBlankExclusions = listOf(191607L)),

        WordEntity(id = 191607, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "קְרֶפְּלָךְ",
            translation = "крэплах (пельмени с мясом)",
            definition = "כִּיסּוֹנֵי בָּצֵק מְמֻלָּאִים בְּשַׂר בָּקָר טָחוּן — נֶאֱכָלִים בְּפוּרִים וְלִפְנֵי יוֹם כִּפּוּר.",
            definitionNative = "Тестяные кармашки с фаршем из говядины — едят на Пурим и накануне Йом Кипур.",
            example = "סָבְתָּא הָאַשְׁכְּנַזִּית בִּשְּׁלָה קְרֶפְּלָךְ בְּמָרָק הַתַּרְנְגוֹלֶת.",
            exampleNative = "Ашкеназская бабушка отварила קְרֶפְּלָךְ в курином бульоне.",
            transliteration = "крэплах",
            pos = "noun", semanticGroup = "food_holidays_purim"),

        WordEntity(id = 191608, setId = 1916, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְעוּדַת פּוּרִים",
            translation = "праздничная трапеза Пурима",
            definition = "אֲרוּחָה חֲגִיגִית בְּיוֹם פּוּרִים — מִצְוָה לֶאֱכֹל בָּשָׂר וְלִשְׁתּוֹת יַיִן לְשִׂמְחַת הַחַג.",
            definitionNative = "Праздничный обед в день Пурима — заповедь есть мясо и пить вино в радость праздника.",
            example = "סְעוּדַת פּוּרִים הִתְחִילָה אַחֲרֵי הַצָּהֳרַיִם וְנִמְשְׁכָה עַד הָעֶרֶב.",
            exampleNative = "סְעוּדַת פּוּרִים началась после полудня и продолжалась до вечера.",
            transliteration = "сэудат пурим",
            pos = "phrase", semanticGroup = "food_holidays_purim", fillInBlankExclusions = listOf(191605L)),

        // ── Group: food_holidays_pesach (5 words) ─────────────────────────────

        WordEntity(id = 191609, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "מַצַּת מִצְוָה",
            translation = "шмура маца (ритуальная маца седера)",
            definition = "מַצָּה הַנֶּאֱפֵית בְּפִקּוּחַ מְיֻחָד מִקְּצִיר הַחִטָּה — מְשַׁמֶּשֶׁת בְּלֵיל הַסֵּדֶר.",
            definitionNative = "Маца особого надзора с самого сбора пшеницы — используется в вечер седера Песаха.",
            example = "הָרַב הִכִּין מַצַּת מִצְוָה עֲגֻלָּה מֵחִטָּה שְׁמוּרָה.",
            exampleNative = "Раввин приготовил круглую מַצַּת מִצְוָה из строго оберегаемой пшеницы.",
            transliteration = "мацат мицва",
            pos = "phrase", semanticGroup = "food_holidays_pesach", fillInBlankExclusions = listOf(191611L, 191613L)),

        WordEntity(id = 191610, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "כּוֹפְתָּאוֹת",
            translation = "кнэйдлах (шарики из мацовой муки)",
            definition = "כַּדּוּרֵי בָּצֵק מִקֶּמַח מַצָּה וּבֵיצִים, שֶׁמְּבַשְּׁלִים בְּמָרָק הַתַּרְנְגוֹלֶת בְּפֶסַח.",
            definitionNative = "Шарики из мацовой муки с яйцами, которые варят в курином бульоне на Песах.",
            example = "הַדּוֹדָה גִּלְגְּלָה כּוֹפְתָּאוֹת רַכּוֹת לִפְנֵי לֵיל הַסֵּדֶר.",
            exampleNative = "Тётя слепила мягкие כּוֹפְתָּאוֹת перед вечером седера.",
            transliteration = "кофтаот",
            pos = "noun", semanticGroup = "food_holidays_pesach", fillInBlankExclusions = listOf(191612L)),

        WordEntity(id = 191611, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "מַצָּה בְּרַייָה",
            translation = "маца брэйа (омлет из размоченной мацы)",
            definition = "מַאֲכַל בֹּקֶר אַשְׁכְּנַזִּי שֶׁל פֶּסַח: שׁוֹבְרִים מַצָּה, מַשְׁרִים בְּחָלָב וּמְטַגְּנִים עִם בֵּיצִים.",
            definitionNative = "Ашкеназский завтрак Песаха: ломают мацу, замачивают в молоке и жарят с яйцами.",
            example = "אַבָּא טִגֵּן מַצָּה בְּרַייָה לַיְלָדִים בַּבֹּקֶר שֶׁל חֹל הַמּוֹעֵד.",
            exampleNative = "Папа пожарил детям מַצָּה בְּרַייָה утром холь hа-моэд.",
            transliteration = "маца брэйа",
            pos = "phrase", semanticGroup = "food_holidays_pesach", fillInBlankExclusions = listOf(191609L, 191613L)),

        WordEntity(id = 191612, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "מָרוֹר",
            translation = "марор (горькая зелень седера)",
            definition = "יָרָק מַר — חֲסָה אוֹ חֲזֶרֶת — שֶׁאוֹכְלִים בְּלֵיל הַסֵּדֶר לְזֵכֶר מָרִירוּת הַשִּׁעְבּוּד.",
            definitionNative = "Горький овощ — латук или хрен — едят в седер в память о горечи египетского рабства.",
            example = "כָּל אֶחָד מֵהַמְּסֻבִּים טָבַל מָרוֹר בַּחֲרוֹסֶת לִפְנֵי הָאֲכִילָה.",
            exampleNative = "Каждый сидящий за столом обмакнул מָרוֹר в харосет перед едой.",
            transliteration = "марор",
            pos = "noun", semanticGroup = "food_holidays_pesach", fillInBlankExclusions = listOf(191610L)),

        WordEntity(id = 191613, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "מְרַק כּוֹפְתָּאוֹת",
            translation = "суп с кнэйдлах (куриный с мацовыми шариками)",
            definition = "מָרָק תַּרְנְגוֹלֶת בָּהִיר עִם כַּדּוּרֵי מַצָּה — מָנָה רִאשׁוֹנָה קְלָסִית בְּלֵיל הַסֵּדֶר.",
            definitionNative = "Прозрачный куриный бульон с шариками из мацы — классическая закуска на седер.",
            example = "כָּל מְסֻבָּה קִבְּלָה קְעָרָה שֶׁל מְרַק כּוֹפְתָּאוֹת חַם.",
            exampleNative = "Каждому гостю налили миску горячего מְרַק כּוֹפְתָּאוֹת.",
            transliteration = "марк кофтаот",
            pos = "phrase", semanticGroup = "food_holidays_pesach", fillInBlankExclusions = listOf(191609L, 191611L)),

        // ── Group: food_holidays_shavuot (4 words) ────────────────────────────

        WordEntity(id = 191614, setId = 1916, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַאֲכָלֵי חָלָב",
            translation = "молочные блюда (Шавуот)",
            definition = "אוֹכֶל הַמּוּכָן מֵחָלָב וּמוּצָרָיו — מָסֹרֶת הָאֲכִילָה בְּחַג הַשָּׁבוּעוֹת.",
            definitionNative = "Еда из молока и его производных — традиция праздника Шавуот, связанная с дарованием Торы.",
            example = "בְּחַג הַשָּׁבוּעוֹת עוֹרְכִים שֻׁלְחָן מָלֵא מַאֲכָלֵי חָלָב.",
            exampleNative = "На Шавуот накрывают стол, полный מַאֲכָלֵי חָלָב.",
            transliteration = "маахалэй халав",
            pos = "phrase", semanticGroup = "food_holidays_shavuot", fillInBlankExclusions = listOf(191615L, 191617L)),

        WordEntity(id = 191615, setId = 1916, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עוּגַת גְּבִינָה",
            translation = "чизкейк (творожный пирог)",
            definition = "עוּגָה עָשִׁירָה מִגְּבִינַת שַׁמֶּנֶת עַל בְּסִיס בִּיסְקְוִיט — דֶּגֶל הַקּוֹנְדִיטוֹרְיָה שֶׁל שָׁבוּעוֹת.",
            definitionNative = "Густой торт из сливочного сыра на бисквитной основе — флагман кондитерской Шавуот.",
            example = "הַשֵּׁף אֲפָה עוּגַת גְּבִינָה גְּבוֹהָה עִם תּוּתִים טְרִיִּים לְמַעְלָה.",
            exampleNative = "Шеф испёк высокий עוּגַת גְּבִינָה со свежей клубникой сверху.",
            transliteration = "угат гвина",
            pos = "phrase", semanticGroup = "food_holidays_shavuot", fillInBlankExclusions = listOf(191614L, 191617L)),

        WordEntity(id = 191616, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "בְּלִינְצֶ'ס",
            translation = "блинцэс (тонкие блины с творогом)",
            definition = "פַּנְקֵיק דַּק מְמֻלָּא בִּגְבִינָה לְבָנָה מְתוּקָה, מְקֻפָּל לְמַעֲטֶפֶת וּמְטֻגָּן עַד זָהֹב.",
            definitionNative = "Тонкий блинчик с начинкой из сладкого творога, свёрнутый конвертом и обжаренный до золота.",
            example = "סָבָה הַפּוֹלָנִיָּה הִכִּינָה בְּלִינְצֶ'ס לְכָבוֹד שָׁבוּעוֹת.",
            exampleNative = "Польская бабушка приготовила בְּלִינְצֶ'ס в честь Шавуот.",
            transliteration = "блинцэс",
            pos = "noun", semanticGroup = "food_holidays_shavuot"),

        WordEntity(id = 191617, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "קְרֵפ גְּבִינָה",
            translation = "сырный крэп (французский блин с сыром)",
            definition = "פַּנְקֵיק צָרְפָתִי דַּקִּיק עִם גְּבִינָה מְלוּחָה אוֹ מְתוּקָה — וַרְיַאצְיָה מוֹדֶרְנִית לְחַג הֶחָלָב.",
            definitionNative = "Тонкий французский блин с солёным или сладким сыром — современная вариация для молочного праздника.",
            example = "בַּמִּסְעָדָה הִגִּישׁוּ קְרֵפ גְּבִינָה עִם דְּבַשׁ וְאֱגוֹזִים.",
            exampleNative = "В ресторане подали קְרֵפ גְּבִינָה с мёдом и орехами.",
            transliteration = "крэп гвина",
            pos = "phrase", semanticGroup = "food_holidays_shavuot", fillInBlankExclusions = listOf(191614L, 191615L)),

        // ── Group: food_holidays_shabbat (4 words) ────────────────────────────

        WordEntity(id = 191618, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "חוֹלְנְט",
            translation = "хольнт (субботнее ашкеназское рагу)",
            definition = "תַּבְשִׁיל בָּשָׂר וּשְׁעוּעִית הַמִּתְבַּשֵּׁל לְאַט מִלֵּיל שִׁישִּׁי עַד שַׁבָּת בַּבֹּקֶר.",
            definitionNative = "Ашкеназское рагу из мяса и фасоли — томится с пятницы до субботнего утра.",
            example = "אַחֲרֵי הַתְּפִלָּה הִתְכַּנֵּסְנוּ לְאֱכֹל חוֹלְנְט חַם בְּבֵית הַסָּבָא.",
            exampleNative = "После молитвы мы собрались у деда, чтобы поесть горячий חוֹלְנְט.",
            transliteration = "хольнт",
            pos = "noun", semanticGroup = "food_holidays_shabbat"),

        WordEntity(id = 191619, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "קוּגְל יְרוּשַׁלְמִי",
            translation = "иерусалимский кугель (запеканка)",
            definition = "אִיטְרִיּוֹת אֲפוּיוֹת בְּסֻכָּר חוּם מְקֻרְמָל וּפִלְפֵּל שָׁחוֹר — מַאֲכַל שַׁבָּת מַסֹּרְתִּי שֶׁל יְרוּשָׁלַיִם.",
            definitionNative = "Лапша, запечённая в карамелизованном коричневом сахаре и чёрном перце — традиционное шабатнее блюдо Иерусалима.",
            example = "הָאוֹפֶה מוֹכֵר קוּגְל יְרוּשַׁלְמִי בְּכָל יוֹם שִׁישִּׁי בַּשּׁוּק.",
            exampleNative = "Пекарь продаёт קוּגְל יְרוּשַׁלְמִי каждую пятницу на рынке Махане-Йеhуда.",
            transliteration = "кугль йерушалми",
            pos = "phrase", semanticGroup = "food_holidays_shabbat", fillInBlankExclusions = listOf(191620L, 191621L)),

        WordEntity(id = 191620, setId = 1916, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְרַק תַּרְנְגוֹלֶת",
            translation = "куриный бульон (шабатний)",
            definition = "מָרָק עוֹף בָּהִיר עִם יְרָקוֹת וְאִיטְרִיּוֹת — פּוֹתֵחַ אֶת אֲרוּחַת לֵיל שַׁבָּת.",
            definitionNative = "Прозрачный отвар из птицы с овощами и лапшой — открывает шабатнюю трапезу в пятницу вечером.",
            example = "אִמָּא הִגִּישָׁה מְרַק תַּרְנְגוֹלֶת חַם אַחֲרֵי הַקִּדּוּשׁ.",
            exampleNative = "Мама подала горячий מְרַק תַּרְנְגוֹלֶת после кидуша.",
            transliteration = "марк тарнэголет",
            pos = "phrase", semanticGroup = "food_holidays_shabbat", fillInBlankExclusions = listOf(191619L, 191621L)),

        WordEntity(id = 191621, setId = 1916, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חַלָּה עֲגוּלָה",
            translation = "круглая хала (на Рош а-Шана)",
            definition = "כִּכַּר חַלָּה בְּצוּרַת סְלִיל מְעֻגָּל — סֶמֶל לְמַעְגַּל הַשָּׁנָה וְלָאֲרֻכַּת יָמִים.",
            definitionNative = "Каравай халы в форме круглой улитки — символ круговорота года и долголетия на Рош а-Шана.",
            example = "אָפִינוּ חַלָּה עֲגוּלָה עִם צִמּוּקִים לְרֹאשׁ הַשָּׁנָה.",
            exampleNative = "Мы испекли חַלָּה עֲגוּלָה с изюмом к Новому году.",
            transliteration = "хала агула",
            pos = "phrase", semanticGroup = "food_holidays_shabbat", fillInBlankExclusions = listOf(191619L, 191620L)),

        // ── Group: food_holidays_other (4 words) ──────────────────────────────

        WordEntity(id = 191622, setId = 1916, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פֵּירוֹת יְבֵשִׁים",
            translation = "сухофрукты (для Ту би-Шват)",
            definition = "פֵּירוֹת מְיֻבָּשִׁים — תְּמָרִים, צִמּוּקִים, תְּאֵנִים — שֶׁאוֹכְלִים בְּט\"וּ בִּשְׁבָט כְּסֶמֶל לְעֵץ הַיּוֹם.",
            definitionNative = "Высушенные фрукты — финики, изюм, инжир — едят на Ту би-Шват в честь Нового года деревьев.",
            example = "עַל הַשֻּׁלְחָן הִנִּיחוּ צַלַּחַת שֶׁל פֵּירוֹת יְבֵשִׁים וַאֱגוֹזִים.",
            exampleNative = "На стол поставили блюдо с פֵּירוֹת יְבֵשִׁים и орехами.",
            transliteration = "пэйрот йэвэшим",
            pos = "phrase", semanticGroup = "food_holidays_other", fillInBlankExclusions = listOf(191623L, 191624L)),

        WordEntity(id = 191623, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "שִׁבְעַת הַמִּינִים",
            translation = "семь видов плодов Земли Израиля",
            definition = "חִטָּה, שְׂעוֹרָה, גֶּפֶן, תְּאֵנָה, רִמּוֹן, זַיִת וּדְבַשׁ — שֶׁבַע פֵּירוֹת אֶרֶץ יִשְׂרָאֵל בַּתּוֹרָה.",
            definitionNative = "Пшеница, ячмень, виноград, инжир, гранат, олива и финиковый мёд — семь плодов Эрец-Исраэль в Торе.",
            example = "בְּט\"וּ בִּשְׁבָט נָהוּג לִטְעֹם מִכָּל שִׁבְעַת הַמִּינִים.",
            exampleNative = "На Ту би-Шват принято попробовать каждый из שִׁבְעַת הַמִּינִים.",
            transliteration = "шиват hа-миним",
            pos = "phrase", semanticGroup = "food_holidays_other", fillInBlankExclusions = listOf(191622L, 191624L)),

        WordEntity(id = 191624, setId = 1916, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בֵּיצָה קָשָׁה",
            translation = "крутое яйцо (ритуальное)",
            definition = "בֵּיצָה שֶׁבֻּשְּׁלָה בָּקְלִיפָּה — סֶמֶל הָאֵבֶל בִּסְעוּדַת הַבְרָאָה וְעַל קְעָרַת הַסֵּדֶר.",
            definitionNative = "Яйцо, сваренное в скорлупе — символ траура в трапезе скорбящих и часть пасхального кеара.",
            example = "אַחֲרֵי הַלְוָיָה הִגִּישׁוּ לֶחֶם וּבֵיצָה קָשָׁה לָאֲבֵלִים.",
            exampleNative = "После похорон скорбящим подали хлеб и בֵּיצָה קָשָׁה.",
            transliteration = "бэйца каша",
            pos = "phrase", semanticGroup = "food_holidays_other"),

        WordEntity(id = 191625, setId = 1916, languagePair = "he-ru", rarity = "RARE",
            original = "טִישׁ",
            translation = "тиш (хасидская праздничная трапеза)",
            definition = "אֲרוּחַת חַג סְבִיב שֻׁלְחַן הָרַבִּי בַּחֲסִידוּת — שִׁירִים, דִּבְרֵי תּוֹרָה וַחֲלֻקַּת שְׁיָרֵי אֹכֶל.",
            definitionNative = "Праздничная трапеза за столом ребе в хасидской общине — пение, слова Торы и раздача шираим.",
            example = "הַחֲסִידִים הִתְכַּנְּסוּ לְטִישׁ אָרֹךְ בְּלֵיל שִׂמְחַת תּוֹרָה.",
            exampleNative = "Хасиды собрались на долгий טִישׁ в вечер Симхат Торы.",
            transliteration = "тиш",
            pos = "noun", semanticGroup = "food_holidays_other"),
    )
}
