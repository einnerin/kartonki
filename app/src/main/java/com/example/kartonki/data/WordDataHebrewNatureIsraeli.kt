package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1913 (he-ru).
 * Природа и экология: флора и фауна Израиля (L3 / UNCOMMON + RARE).
 *
 * Уникальный для he-ru ракурс: характерные виды Эрец-Исраэль —
 * Средиземноморское побережье, пустыня Негев, Иорданская долина,
 * Иудейские горы и Эйлатский залив. То, что встречается в нацпарках,
 * заповедниках и поговорках на иврите — а не «общие» животные.
 *
 * НЕ общие домашние/мировые звери (set 1015 «Животные», уже есть в Animals.kt),
 * НЕ общая ботаника, НЕ геология (set 1896 «Природа и экология: геология»).
 *
 * Исключены кандидаты из-за дублей с WordDataHebrewAnimals.kt и Immigrant4.kt:
 *   - יָעֵל (яэль, горный козёл) — Animals.kt
 *   - זְאֵב (волк) — Animals.kt
 *   - שׁוּעָל (лиса) — Animals.kt
 *   - נֶשֶׁר (орёл) — Animals.kt
 *   - בָּז (сокол) — Animals.kt
 *   - מִדְבָּר (пустыня) — Immigrant4.kt
 *   - חוֹלוֹת (дюны/пески) — Immigrant4.kt
 *   - שׁוּנִית (риф, отд. слово) — Batch5.kt
 *   - אִילָנָה (рожковое, поэт.) — синоним חָרוּב в этом же сете
 *
 * Заменители подобраны под эндемичные/символические виды Эрец-Исраэль:
 *   - רֵאֵם (орикс/аддакс — библейская антилопа Негева) вместо яэля
 *   - דַּרְבָּן (дикобраз — ночной обитатель Иудейских гор) вместо лисы
 *   - רָחָם (стервятник египетский — символ Машгиах) вместо орла
 *   - חָסִידָה (аист — на крышах кибуцев весной) вместо сокола
 *   - עֲרָבָה (Арава — южная пустынная долина) вместо общей мидбар
 *   - שׁוֹנִית אַלְמוּגִים (коралловый риф Эйлата) — полная фраза, не дубль
 *   - תְּאֵנָה (инжир — одно из 7 видов Земли Израиля)
 *   - רֹתֶם (ротэм/ракитник — пустынный куст, тень для пророка Илии)
 *
 * Распределение редкости (validate_rarity_spread: 2 смежных уровня):
 *   UNCOMMON — 12 слов (A2-B1): виды, которых видишь в парке или
 *     на экскурсии в первый год в Израиле (шафан hа-села, цви, хазир,
 *     духифат, агур, хасида, анпа, эла, шикма, ракэфет, каланит, шита).
 *   RARE — 13 слов (B2): продвинутая лексика — узкоспециальные эндемики,
 *     библейские названия растений, экологические термины ландшафта
 *     (реэм, дарбан, рахам, орэн йерушалаим, харув, тээна, нурит, ирит,
 *     хатав hа-элоhим, ротэм, арава, алмог, шонит алмугим).
 *
 * Пять семантических подгрупп (validate_group_sizes: 3-8 на группу):
 *   nature_il_mammals — 5 слов: млекопитающие Эрец-Исраэль
 *   nature_il_birds — 5 слов: характерные птицы (включая национальную — удод)
 *   nature_il_trees — 5 слов: деревья библейские и эндемичные
 *   nature_il_flowers — 5 слов: дикие цветы (символ Израиля — каланит)
 *   nature_il_landscape — 5 слов: пустыня, побережье, коралловые рифы
 *
 * Word IDs: 191301..191325 (setId × 100 + position).
 */
object WordDataHebrewNatureIsraeli {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1913, languagePair = "he-ru", orderIndex = 1913,
            name = "Природа и экология",
            description = "Флора и фауна Израиля: דּוּכִיפַת, רַקֶּפֶת, אֵלָה, אַלְמוּג.",
            topic = "Природа и экология",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: nature_il_mammals (5 words) ────────────────────────────────

        WordEntity(id = 191301, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "רֵאֵם",
            translation = "орикс, аддакс (антилопа Негева)",
            definition = "אֲנְטִילוֹפָּה לְבָנָה גְּדוֹלָה שֶׁל הַנֶּגֶב — מֻזְכֶּרֶת בַּתַּנַ״ךְ, הֻחְזְרָה לַטֶּבַע אַחֲרֵי הַכְחָדָה.",
            definitionNative = "Крупная белая антилопа Негева — упомянута в Танахе, возвращена в природу после исчезновения.",
            example = "בִּשְׁמוּרַת חַי־בָּר יוֹטְבָתָה רוֹאִים עֶדְרֵי רֵאֵם בָּעֲרָבָה.",
            exampleNative = "В заповеднике Хай-Бар Йотвата видно стада רֵאֵם в Араве.",
            transliteration = "рээм",
            pos = "noun", semanticGroup = "nature_il_mammals", fillInBlankExclusions = listOf(191302L, 191303L, 191304L, 191305L)),

        WordEntity(id = 191302, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שָׁפָן הַסֶּלַע",
            translation = "даман (скальная гирaks)",
            definition = "יוֹנֵק קָטָן וְשָׁמֵן הַחַי בְּסַלְעֵי הַגָּלִיל וְהַגּוֹלָן — קָרוֹב הַפִּילִים מִבְּחִינָה גֵּנֵטִית.",
            definitionNative = "Мелкий упитанный зверь со скал Галилеи и Голан — генетически родня слонам.",
            example = "בַּסֶּלַע מֵעַל הַשְּׁבִיל יָשַׁב שָׁפָן הַסֶּלַע וְהִשְׁתַּזֵּף בַּשֶּׁמֶשׁ.",
            exampleNative = "На скале над тропой сидел שָׁפָן הַסֶּלַע и грелся на солнце.",
            transliteration = "шафан hа-сэла",
            pos = "noun", semanticGroup = "nature_il_mammals", fillInBlankExclusions = listOf(191301L, 191303L, 191304L, 191305L, 191309L, 191310L)),

        WordEntity(id = 191303, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צְבִי הָרִים",
            translation = "горная газель (эндемик)",
            definition = "אַיָּל קָטָן וְחָטוּב הַחַי בְּהָרֵי יְהוּדָה וְהַכַּרְמֶל — סֵמֶל הַזְּרִיזוּת בְּעִבְרִית.",
            definitionNative = "Маленький стройный олень с холмов Иудеи и Кармеля — символ быстроты в иврите.",
            example = "בַּשַּׁחַר רָאִינוּ צְבִי הָרִים חוֹצֶה אֶת הַשְּׁבִיל בַּכַּרְמֶל.",
            exampleNative = "На рассвете видели צְבִי הָרִים, пересекавшую тропу на Кармеле.",
            transliteration = "цви hа-hарим",
            pos = "noun", semanticGroup = "nature_il_mammals", fillInBlankExclusions = listOf(191301L, 191302L, 191304L, 191305L)),

        WordEntity(id = 191304, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲזִיר־בָּר",
            translation = "кабан, дикий вепрь",
            definition = "יוֹנֵק חָזָק וּמְסֻכָּן הַחַי בַּחֻרְשׁוֹת וּבְעֵמֶק הַחוּלָה — נִכְנָס לְחָצְרוֹת הַיִּשּׁוּבִים בַּצָּפוֹן.",
            definitionNative = "Сильный опасный зверь рощ и Хульской долины — заходит во дворы посёлков на севере.",
            example = "בַּלַּיְלָה חֲזִיר־בָּר הָפַךְ אֶת פַּחֵי הַזֶּבֶל בָּרְחוֹב.",
            exampleNative = "Ночью חֲזִיר־בָּר перевернул мусорные баки на улице.",
            transliteration = "хазир бар",
            pos = "noun", semanticGroup = "nature_il_mammals", fillInBlankExclusions = listOf(191301L, 191302L, 191303L, 191305L)),

        WordEntity(id = 191305, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "דַּרְבָּן",
            translation = "дикобраз (ночной)",
            definition = "מַכְרְסֵם גָּדוֹל עִם קוֹצִים אֲרֻכִּים — פָּעִיל בַּלַּיְלָה בְּהָרֵי יְהוּדָה וּבַגָּלִיל.",
            definitionNative = "Крупный грызун с длинными иглами — ведёт ночной образ жизни в Иудее и Галилее.",
            example = "מָצָאנוּ קוֹץ שֶׁל דַּרְבָּן עַל הַשְּׁבִיל לְיַד הַמְּעָרָה.",
            exampleNative = "Нашли иглу דַּרְבָּן на тропе у пещеры.",
            transliteration = "дарбан",
            pos = "noun", semanticGroup = "nature_il_mammals", fillInBlankExclusions = listOf(191301L, 191302L, 191303L, 191304L)),

        // ── Group: nature_il_birds (5 words) ──────────────────────────────────

        WordEntity(id = 191306, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דּוּכִיפַת",
            translation = "удод (национальная птица)",
            definition = "צִפּוֹר עִם כֶּתֶר נוֹצוֹת בָּרֹאשׁ וּמַקּוֹר אָרֹךְ — נִבְחֲרָה כְּסֵמֶל הַמְּדִינָה בִּשְׁנַת 2008.",
            definitionNative = "Птица с хохолком на голове и длинным клювом — выбрана символом страны в 2008 году.",
            example = "בַּגִּנָּה שֶׁל סָבָתָא חוֹפֶרֶת דּוּכִיפַת אַחַר תּוֹלָעִים בָּעֵשֶׂב.",
            exampleNative = "В саду бабушки דּוּכִיפַת роет червей в траве.",
            transliteration = "духифат",
            pos = "noun", semanticGroup = "nature_il_birds", fillInBlankExclusions = listOf(191307L, 191308L, 191309L, 191310L)),

        WordEntity(id = 191307, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֵגוּר",
            translation = "журавль (перелётный)",
            definition = "צִפּוֹר נוֹדֶדֶת גְּדוֹלָה הָעוֹצֶרֶת בְּאַגְמוֹן הַחוּלָה בַּסְּתָו וּבָאָבִיב.",
            definitionNative = "Крупная перелётная птица, останавливающаяся в Хульской долине осенью и весной.",
            example = "אֶלֶף עֲגוּרִים יָרְדוּ בַּשָּׂדֶה לְיַד הַכְּפָר בְּנוֹבֶמְבֶּר.",
            exampleNative = "Тысячи журавлей сели на поле у деревни в ноябре.",
            transliteration = "агур",
            pos = "noun", semanticGroup = "nature_il_birds", isFillInBlankSafe = false),

        WordEntity(id = 191308, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "רָחָם",
            translation = "стервятник египетский",
            definition = "עוֹף דּוֹרֵס לָבָן וְצָהֹב הַמְּנַקֶּה אֶת הַטֶּבַע מִפְּגָרִים — בְּסַכָּנַת הַכְחָדָה בָּאָרֶץ.",
            definitionNative = "Бело-жёлтая хищная птица, очищающая природу от падали — под угрозой исчезновения в стране.",
            example = "בַּשְּׁמוּרָה מַאֲכִילִים אֶת הָרָחָם כְּדֵי לְשַׁמֵּר אֶת הַמִּין.",
            exampleNative = "В заповеднике подкармливают רָחָם, чтобы сохранить вид.",
            transliteration = "рахам",
            pos = "noun", semanticGroup = "nature_il_birds", fillInBlankExclusions = listOf(191306L, 191307L, 191309L, 191310L)),

        WordEntity(id = 191309, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חָסִידָה",
            translation = "аист белый (перелётный)",
            definition = "צִפּוֹר גְּדוֹלָה בִּלְבָנָה־שְׁחֹרָה הַעוֹצֶרֶת בָּאָרֶץ בִּזְמַן הַנְּדִידָה מֵאֵירוֹפָּה לְאַפְרִיקָה.",
            definitionNative = "Большая чёрно-белая птица, останавливающаяся в стране на пути из Европы в Африку.",
            example = "עַל הַגַּג שֶׁל הַקִּיבּוּץ בָּנְתָה חָסִידָה קֵן מֵעֲנָפִים.",
            exampleNative = "На крыше кибуца חָסִידָה свила гнездо из веток.",
            transliteration = "хасида",
            pos = "noun", semanticGroup = "nature_il_birds", fillInBlankExclusions = listOf(191306L, 191307L, 191308L, 191310L)),

        WordEntity(id = 191310, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַנְפָּה",
            translation = "цапля (длинноногая)",
            definition = "עוֹף מַיִם בַּעַל רַגְלַיִם אֲרֻכּוֹת וְצַוָּאר מָתוּחַ — צָדָה דָּגִים בַּבִּצּוֹת וּבַבְּרֵכוֹת.",
            definitionNative = "Водная птица с длинными ногами и вытянутой шеей — ловит рыбу в болотах и прудах.",
            example = "אַנְפָּה אַחַת עָמְדָה לְלֹא נוֹעַ בִּקְצֵה הַבְּרֵכָה שָׁעָה שְׁלֵמָה.",
            exampleNative = "Одна אַנְפָּה стояла без движения у края пруда целый час.",
            transliteration = "анпа",
            pos = "noun", semanticGroup = "nature_il_birds", fillInBlankExclusions = listOf(191306L, 191307L, 191308L, 191309L)),

        // ── Group: nature_il_trees (5 words) ──────────────────────────────────

        WordEntity(id = 191311, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֵלָה",
            translation = "теребинт, фисташковое дерево",
            definition = "עֵץ מְקוֹמִי בַּעַל גֶּזַע אָדֹם וְעָלִים קְטַנִּים — נִזְכָּר בַּתַּנַ״ךְ כְּסֵמֶל לַחֹסֶן.",
            definitionNative = "Местное дерево с красным стволом и мелкими листьями — упомянуто в Танахе как символ стойкости.",
            example = "תַּחַת הָאֵלָה הָעַתִּיקָה בֵּית־כְּנֶסֶת הַשְׁכַּן בַּכְּפָר.",
            exampleNative = "Под старой אֵלָה в деревне расположилась синагога.",
            transliteration = "эла",
            pos = "noun", semanticGroup = "nature_il_trees", fillInBlankExclusions = listOf(191312L, 191313L, 191314L, 191315L)),

        WordEntity(id = 191312, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שִׁקְמָה",
            translation = "сикомор (фиговое дерево)",
            definition = "עֵץ עָבֶה וְרָחָב הַגָּדֵל בָּעֲרָבָה וּבַשְּׁפֵלָה — נוֹתֵן צֵל גָּדוֹל וְעוֹשֶׂה פֵּרוֹת מְתוּקִים.",
            definitionNative = "Толстое раскидистое дерево, растущее в Араве и низменности — даёт большую тень и сладкие плоды.",
            example = "תַּחַת הַשִּׁקְמָה בַּכִּכָּר יוֹשְׁבִים הַזְּקֵנִים בָּעֶרֶב.",
            exampleNative = "Под שִׁקְמָה на площади старики сидят вечером.",
            transliteration = "шикма",
            pos = "noun", semanticGroup = "nature_il_trees"),

        WordEntity(id = 191313, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹרֶן יְרוּשָׁלַיִם",
            translation = "иерусалимская сосна",
            definition = "מִין מְקוֹמִי שֶׁל מָחָט בַּעַל מַחֲטִים אֲרֻכּוֹת — נָטוּעַ בִּיעָרוֹת קֶרֶן קַיֶּמֶת בְּכֹל הָאָרֶץ.",
            definitionNative = "Местный хвойный вид с длинной хвоей — посажен в лесах ККЛ по всей стране.",
            example = "יַעַר שֶׁל אוֹרֶן יְרוּשָׁלַיִם מַקִּיף אֶת הַמּוֹשָׁב מִדָּרוֹם.",
            exampleNative = "Лес אוֹרֶן יְרוּשָׁלַיִם окружает мошав с юга.",
            transliteration = "орэн йерушалаим",
            pos = "noun", semanticGroup = "nature_il_trees", fillInBlankExclusions = listOf(191311L, 191312L, 191314L, 191315L)),

        WordEntity(id = 191314, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "חָרוּב",
            translation = "рожковое дерево",
            definition = "עֵץ יְרוֹק תָּמִיד עִם תַּרְמִילִים חוּמִים מְתוּקִים — נִקְשָׁר לְאַגָּדַת חוֹנִי הַמְעַגֵּל וְהַתַּלְמוּד.",
            definitionNative = "Вечнозелёное дерево с коричневыми сладкими стручками — связано с легендой о Хони а-Меагеле и Талмудом.",
            example = "מִתַּרְמִילֵי הַחָרוּב מְכִינִים סִילָאן וְקֶמַח בָּרִיא.",
            exampleNative = "Из стручков חָרוּב делают силан и полезную муку.",
            transliteration = "харув",
            pos = "noun", semanticGroup = "nature_il_trees", fillInBlankExclusions = listOf(191311L, 191312L, 191313L, 191315L)),

        WordEntity(id = 191315, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "תְּאֵנָה",
            translation = "инжирное дерево, смоковница",
            definition = "אֶחָד מִשִּׁבְעַת הַמִּינִים שֶׁל אֶרֶץ יִשְׂרָאֵל — עֵץ נָמוּךְ עִם עָלִים גְּדוֹלִים וּפֵרוֹת מְתוּקִים.",
            definitionNative = "Одно из семи видов Земли Израиля — низкое дерево с большими листьями и сладкими плодами.",
            example = "סָבָא קָטַף תְּאֵנָה בְּשֵׁלָה מֵהֶעָנָף וְהוֹשִׁיט לִי.",
            exampleNative = "Дед сорвал спелый плод с תְּאֵנָה и протянул мне.",
            transliteration = "тээна",
            pos = "noun", semanticGroup = "nature_il_trees", fillInBlankExclusions = listOf(191311L, 191312L, 191313L, 191314L)),

        // ── Group: nature_il_flowers (5 words) ────────────────────────────────

        WordEntity(id = 191316, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רַקֶּפֶת",
            translation = "цикламен (зимний цветок)",
            definition = "פֶּרַח בָּר וָרוֹד שֶׁל הַחֹרֶף — צוֹמֵחַ בֵּין סְלָעִים בַּכַּרְמֶל וּבַגָּלִיל, מֻגָּן בְּחֹק.",
            definitionNative = "Дикий розовый зимний цветок — растёт между скалами на Кармеле и в Галилее, охраняется законом.",
            example = "אַחֲרֵי הַגֶּשֶׁם הָרִאשׁוֹן פָּרְחָה רַקֶּפֶת מִתַּחַת לָאֵלָה.",
            exampleNative = "После первого дождя расцвёл רַקֶּפֶת под теребинтом.",
            transliteration = "ракэфэт",
            pos = "noun", semanticGroup = "nature_il_flowers", fillInBlankExclusions = listOf(191317L, 191318L, 191319L)),

        WordEntity(id = 191317, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כַּלָּנִית",
            translation = "анемона (красный цветок)",
            definition = "פֶּרַח אָדֹם בּוֹהֵק שֶׁל סוֹף הַחֹרֶף — מְכַסֶּה אֶת הַשְּׂדוֹת בָּדָּרוֹם בְּפֶסְטִיבָל הַ״דָּרוֹם אָדֹם״.",
            definitionNative = "Ярко-красный позднезимний цветок — покрывает поля юга на фестивале «Красный юг».",
            example = "מִשְׁפַּחְתֵּנוּ נָסְעָה לִרְאוֹת אֶת שָׂדוֹת הַכַּלָּנִית בִּשְׁבִיל הַ״דָּרוֹם אָדֹם״.",
            exampleNative = "Семья поехала смотреть поля כַּלָּנִית на «Красном юге».",
            transliteration = "каланит",
            pos = "noun", semanticGroup = "nature_il_flowers", fillInBlankExclusions = listOf(191316L, 191318L, 191319L)),

        WordEntity(id = 191318, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "נוּרִית",
            translation = "лютик азиатский (жёлтый)",
            definition = "פֶּרַח בָּר צָהֹב קָטָן עִם עָלִים חֲרוּצִים — פּוֹרֵחַ בְּחֻרְשׁוֹת הָאָרֶץ בָּאָבִיב.",
            definitionNative = "Маленький жёлтый дикий цветок с резными листьями — цветёт в рощах страны весной.",
            example = "בֵּין הַסְּלָעִים בַּכַּרְמֶל גִּלִּינוּ נוּרִית כְּחֻלָּה נְדִירָה.",
            exampleNative = "Между скал на Кармеле нашли редкий синий נוּרִית.",
            transliteration = "нурит",
            pos = "noun", semanticGroup = "nature_il_flowers", fillInBlankExclusions = listOf(191316L, 191317L, 191319L)),

        WordEntity(id = 191319, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "עִירִית",
            translation = "асфодель (царь полей)",
            definition = "צֶמַח בָּר עִם שִׁבֳּלִים לְבָנוֹת וְעָלִים אֲרֻכִּים — נִשְׁמָר בְּכֹל שִׂדוֹת הָאָרֶץ בְּחֹדֶשׁ אֲדָר.",
            definitionNative = "Дикое растение с белыми колосьями и длинными листьями — повсюду на полях в месяц адар.",
            example = "בִּשְׂדוֹת הַשְּׁפֵלָה פּוֹרַחַת עִירִית גְּבוֹהַת קוֹמָה.",
            exampleNative = "На полях низменности цветёт высокий עִירִית.",
            transliteration = "ирит",
            pos = "noun", semanticGroup = "nature_il_flowers", fillInBlankExclusions = listOf(191316L, 191317L, 191318L, 191320L)),

        WordEntity(id = 191320, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "חַטָּב הָאֱלֹהִים",
            translation = "посох Аарона (морск. лук)",
            definition = "צֶמַח בָּר בַּעַל שִׁבֳּלֶת לְבָנָה גְּבוֹהָה — פּוֹרֵחַ בַּסְּתָו לִפְנֵי בּוֹא הַגְּשָׁמִים בָּאָרֶץ.",
            definitionNative = "Дикое растение с высоким белым колосом — цветёт осенью до прихода дождей в стране.",
            example = "מֵעֵבֶר לַגָּדֵר רָאִינוּ חַטָּב הָאֱלֹהִים פּוֹרֵחַ בַּשָּׂדֶה הַיָּבֵשׁ.",
            exampleNative = "За забором цвёл חַטָּב הָאֱלֹהִים на сухом поле.",
            transliteration = "хатав hа-элоhим",
            pos = "phrase", semanticGroup = "nature_il_flowers", fillInBlankExclusions = listOf(191319L)),

        // ── Group: nature_il_landscape (5 words) ──────────────────────────────

        WordEntity(id = 191321, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "רֹתֶם",
            translation = "ретама, белый ракитник",
            definition = "שִׂיחַ מִדְבָּרִי לָבָן עִם פְּרָחִים קְטַנִּים — נָתַן צֵל לְאֵלִיָּהוּ הַנָּבִיא בַּמִּדְבָּר.",
            definitionNative = "Белый кустарник пустыни с мелкими цветами — давал тень пророку Илии в пустыне.",
            example = "תַּחַת הָרֹתֶם בָּעֲרָבָה מָצָאנוּ צֵל בְּאֶמְצַע הַטִּיוּל.",
            exampleNative = "Под רֹתֶם в Араве нашли тень посреди похода.",
            transliteration = "ротэм",
            pos = "noun", semanticGroup = "nature_il_landscape", fillInBlankExclusions = listOf(191322L, 191324L)),

        WordEntity(id = 191322, setId = 1913, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שִׁיטָּה",
            translation = "акация (пустынная)",
            definition = "עֵץ קוֹצָנִי הַגָּדֵל בָּעֲרָבָה וּבַנֶּגֶב — מִמֶּנּוּ עָשׂוּ אֶת אֲרוֹן הַבְּרִית בַּתַּנַ״ךְ.",
            definitionNative = "Колючее дерево, растущее в Араве и Негеве — из него делали Ковчег Завета в Танахе.",
            example = "בְּלֵב הַנֶּגֶב צָמְחָה שִׁיטָּה בּוֹדֶדֶת לְיַד הָוָאדִי.",
            exampleNative = "Посреди Негева у вади росла одинокая שִׁיטָּה.",
            transliteration = "шита",
            pos = "noun", semanticGroup = "nature_il_landscape", fillInBlankExclusions = listOf(191321L, 191323L, 191324L)),

        WordEntity(id = 191323, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "עֲרָבָה",
            translation = "Арава (южная пустынная долина)",
            definition = "בִּקְעָה מִדְבָּרִית בֵּין יָם הַמֶּלַח לְאֵילַת — נוֹף שֶׁל מַחְצָבוֹת וְהָרִים אֲדֻמִּים.",
            definitionNative = "Пустынная долина между Мёртвым морем и Эйлатом — пейзаж карьеров и красных гор.",
            example = "הַטִּיסָה לְאֵילַת חוֹלֶפֶת מֵעַל הָעֲרָבָה הָרֵיקָה.",
            exampleNative = "Полёт в Эйлат проходит над пустой עֲרָבָה.",
            transliteration = "арава",
            pos = "noun", semanticGroup = "nature_il_landscape", fillInBlankExclusions = listOf(191321L, 191322L, 191324L)),

        WordEntity(id = 191324, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "אַלְמוּג",
            translation = "коралл (морской)",
            definition = "יְצוּר יָם זָעִיר הַחַי בִּמְשֻׁתָּף וּבוֹנֶה שִׁלְדִים אֲבָנִיִּים צִבְעוֹנִיִּים בִּמְפְרַץ אֵילַת.",
            definitionNative = "Микроскопический морской организм, живущий в колонии и строящий цветные каменные скелеты в Эйлатском заливе.",
            example = "צַלָּלְנוּ לִרְאוֹת אַלְמוּג אָדֹם בְּחוֹף הַשֻּׁמָּרֶת.",
            exampleNative = "Ныряли увидеть красный אַלְמוּג на пляже-заповеднике.",
            transliteration = "алмог",
            pos = "noun", semanticGroup = "nature_il_landscape", fillInBlankExclusions = listOf(191321L, 191322L, 191323L)),

        WordEntity(id = 191325, setId = 1913, languagePair = "he-ru", rarity = "RARE",
            original = "שׁוֹנִית אַלְמוּגִים",
            translation = "коралловый риф",
            definition = "מִבְנֶה תַּת־יַמִּי מִשִּׁלְדֵי אַלְמוּגִים — מָקוֹם מָגוֹר לְמֵאוֹת מִינֵי דָּגִים בְּמִפְרַץ אֵילַת.",
            definitionNative = "Подводная структура из скелетов кораллов — место обитания сотен видов рыб в Эйлатском заливе.",
            example = "שׁוֹנִית אַלְמוּגִים שֶׁל אֵילַת מוֹשֶׁכֶת צוֹלְלִים מִכֹּל הָעוֹלָם.",
            exampleNative = "שׁוֹנִית אַלְמוּגִים Эйлата притягивает дайверов со всего мира.",
            transliteration = "шонит алмугим",
            pos = "phrase", semanticGroup = "nature_il_landscape"),
    )
}
