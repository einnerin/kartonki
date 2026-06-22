package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1908 (he-ru).
 * Архитектура: стили и направления (L3 / RARE + EPIC).
 *
 * Зеркало успешного en-ru set 452. Точечное расширение темы «Архитектура»
 * в he-ru — рядом с существующими сетами 1086 (L2), 1221 (L1), 1256 + 1257
 * (L3 + L5), 1706 (L4). Фокус — на названия архитектурных стилей и
 * направлений, не повторяющихся со старыми сетами темы.
 *
 * Исключены как дубли с существующими he-ru сетами «Архитектура»:
 *   - בָּרוֹק / בַּאְרוֹקוֹ → выпало в пользу маньеризма (Mannerism).
 *   - גּוֹתִי → заменено на нֵאוֹ-гוֹתִי (поздняя стадия, отдельный стиль).
 *   - רֶנֶסַנְס → заменено на פַּלָּאדְיָאנִיוּת (узкое ренессансное течение).
 *   - רוֹקוֹקוֹ → заменено на сִגְנוֹן בּוֹזָאר (поздний классицизм).
 *   - קְלַסִיצִיזְם / נֵאוֹ-קְלַסִיצִיזְם → заменены тремя «национальными»
 *     неоклассиками: סִגְנוֹן אַמְפִּיר, סִגְנוֹן פֵדֵרָלִי, תְּחִיָּה יְוָנִית.
 *   - מוֹדֶרְנִיזְם / אַדְרִיכָלוּת אוֹרְגָנִית / פּוֹסְט־מוֹדֶרְנִיזְם /
 *     דֵּקוֹנְסְטְרוּקְטִיבִיזְם / מֶטָבּוֹלִיזְם / קוֹנְסְטְרוּקְטִיבִיזְם /
 *     בַּאוּהָאוּס / פוּנְקְצְיוֹנַלִיזְם / אַר-דֶּקוֹ → всё уже занято.
 *     Заменены на узкие движения: דֵה סְטֵייל, פוּטוּרִיזְם, סְטְרִימְלַיין
 *     מוֹדֶרְן, סִגְנוֹן הַפְּרֵרְיָה, הַסִּגְנוֹן הַבֵּינְלְאוּמִי,
 *     בָּאוּהָאוּס תֵּל אָבִיב (композит — само солo занято).
 *
 * Локальная израильская специфика:
 *   - הָעִיר הַלְּבָנָה — Белый город (ЮНЕСКО, Тель-Авив).
 *   - בָּאוּהָאוּס תֵּל אָבִיב — местная вариация международного баухауза.
 *   - אַדְרִיכָלוּת תֵּמְפְּלָרִית — поселения немецких темплеров (Сарона).
 *   - בְּרוּטָלִיזְם — отдельная страница в архитектуре Иерусалима.
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   RARE — 14 слов (B2, узнаваемые «школьные» названия стилей):
 *          Tudor, Georgian, Edwardian, Regency, Greek Revival, Neo-Gothic,
 *          Art Nouveau, Futurism, High-Tech, Mannerism, эклектика, Белый
 *          город Тель-Авива, brutalism, международный стиль.
 *   EPIC — 11 слов (C1, более специальные движения и направления):
 *          Beaux-Arts, Streamline Moderne, De Stijl, Empire, Federal,
 *          Prairie, parametricism, Palladianism, темплерская архитектура,
 *          биоклиматическая архитектура, Bauhaus Тель-Авива.
 *
 * Пять семантических подгрупп:
 *   arch_styles_english_historical — 4 слова: Tudor, Georgian, Edwardian, Regency
 *   arch_styles_revival            — 6 слов: Greek Revival, Neo-Gothic, Mannerism,
 *                                            Beaux-Arts, Empire, Federal
 *   arch_styles_early_modern       — 5 слов: Art Nouveau, Futurism, Mannerism →
 *                                            DeStijl, Streamline Moderne, Palladianism
 *   arch_styles_late_modern        — 5 слов: High-Tech, Prairie, brutalism,
 *                                            международный стиль, parametricism
 *   arch_styles_israeli            — 5 слов: эклектика, Белый город, Bauhaus
 *                                            Тель-Авива, темплерская, биоклиматическая
 *
 * Word IDs: 190801..190825 (setId × 100 + position).
 */
object WordDataHebrewArchitectureStyles {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1908, languagePair = "he-ru", orderIndex = 1908,
            name = "Архитектура",
            description = "Стили и направления: טוּדוֹר, אַרְט נוּבוֹ, מַנְיֶרִיזְם, פוּטוּרִיזְם, סִגְנוֹן בּוֹזָאר, דֵה סְטֵייל, סִגְנוֹן אַמְפִּיר, פָּרָמֵטְרִיצִיזְם и местное — הָעִיר הַלְּבָנָה, בָּאוּהָאוּס תֵּל אָבִיב, אַדְרִיכָלוּת תֵּמְפְּלָרִית.",
            topic = "Архитектура",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: arch_styles_english_historical (4 words) ───────────────────

        WordEntity(id = 190801, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "טוּדוֹר",
            translation = "тюдоровский (стиль)",
            definition = "סִגְנוֹן אַנְגְּלִי קָדוּם עִם קוֹרוֹת עֵץ כֵּהוֹת עַל קִירוֹת לְבָנִים וְגַגּוֹת תְּלוּלִים.",
            definitionNative = "Старый английский стиль: тёмные деревянные балки на белых стенах и крутые крыши.",
            example = "הַבַּיִת הַקָּטָן הוּא טוּדוֹר אוֹתֶנְטִי לְגַמְרֵי.",
            exampleNative = "Этот домик — совершенно подлинный טוּדוֹר.",
            pos = "adjective", semanticGroup = "arch_styles_english_historical", fillInBlankExclusions = listOf(190802L, 190803L, 190806L, 190807L, 190811L, 190812L, 190816L, 190818L, 190820L, 190821L)),

        WordEntity(id = 190802, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "גֵּאוֹרְגִ׳יָאנִי",
            translation = "георгианский (стиль)",
            definition = "סִגְנוֹן אַנְגְּלִי שֶׁל הַמֵּאָה הַשְּׁמוֹנֶה־עֶשְׂרֵה — סִימֶטְרִיָּה קְפֵדָנִית וַחֲזִיתוֹת לְבֵנָה אֲדֻמָּה.",
            definitionNative = "Английский стиль XVIII века: строгая симметрия и красно-кирпичные фасады.",
            example = "הָעִיר בָּאת מְפֻרְסֶמֶת בַּטוּרֵי הַבָּתִּים הַגֵּאוֹרְגִ׳יָאנִיִּים שֶׁלָּהּ.",
            exampleNative = "Город Бат знаменит изящными георгианскими террасами.",
            pos = "adjective", semanticGroup = "arch_styles_english_historical", isFillInBlankSafe = false, fillInBlankExclusions = listOf(190801L, 190803L)),

        WordEntity(id = 190803, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "אֶדְוַרְדִיאָנִי",
            translation = "эдвардианский (стиль)",
            definition = "סִגְנוֹן אַנְגְּלִי סְבִיב שְׁנַת 1900 — בָּתִּים מְאֻוְּרָרִים וּמוּאָרִים יוֹתֵר מֵהַסִּגְנוֹן הַוִיקְטוֹרִיָּאנִי.",
            definitionNative = "Английский стиль около 1900 года: дома просторнее и светлее, чем викторианские.",
            example = "הַדִּירָה שֶׁלָּהֶם נִמְצֵאת בְּבַיִת אֶדְוַרְדִיאָנִי גָּבוֹהַּ.",
            exampleNative = "Их квартира — в высоком אֶדְוַרְדִיאָנִי-доме.",
            pos = "adjective", semanticGroup = "arch_styles_english_historical", fillInBlankExclusions = listOf(190801L, 190802L)),

        WordEntity(id = 190804, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "רֵגֶ׳נְסִי",
            translation = "стиль регентства",
            definition = "סִגְנוֹן אַנְגְּלִי סְבִיב 1810 — חֲזִיתוֹת טִיחַ לָבָן וּמַעֲקוֹת בַּרְזֶל דַּקִּים.",
            definitionNative = "Английский стиль около 1810 года: белая штукатурка и тонкие чугунные балконы.",
            example = "בְּבְּרַייְטוֹן יֵשׁ רְחוֹבוֹת שְׁלֵמִים שֶׁל בָּתֵּי רֵגֶ׳נְסִי בְּצֶבַע שַׁמֶּנֶת.",
            exampleNative = "В Брайтоне целые улицы кремовых רֵגֶ׳נְסִי-домов.",
            pos = "noun", semanticGroup = "arch_styles_english_historical", fillInBlankExclusions = listOf(190801L, 190803L, 190806L, 190807L)),

        // ── Group: arch_styles_revival (6 words) ──────────────────────────────

        WordEntity(id = 190805, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "תְּחִיָּה יְוָנִית",
            translation = "греческое возрождение",
            definition = "סִגְנוֹן שֶׁל הַמֵּאָה הַתְּשַׁע־עֶשְׂרֵה שֶׁמַּעֲתִיק מִקְדָּשִׁים אַתִּיִּים — עַמּוּדִים וְגַמְלוֹנִים מְשֻׁלָּשִׁים.",
            definitionNative = "Стиль XIX века, копирующий аттические храмы — колонны и треугольные фронтоны.",
            example = "בֵּית הַמִּשְׁפָּט הַיָּשָׁן הוּא תְּחִיָּה יְוָנִית מְפֹאֶרֶת מִ־1830.",
            exampleNative = "Старое здание суда — величественная תְּחִיָּה יְוָנִית 1830-х.",
            pos = "phrase", semanticGroup = "arch_styles_revival", fillInBlankExclusions = listOf(190808L, 190809L, 190810L)),

        WordEntity(id = 190806, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "נֵאוֹ-גוֹתִי",
            translation = "неоготика",
            definition = "תְּחִיָּה שֶׁל הַמֵּאָה הַתְּשַׁע־עֶשְׂרֵה — קַשְׁתוֹת חַדּוֹת וּצְרִיחִים גְּבוֹהִים מִכְּנֵסִיּוֹת יְמֵי הַבֵּינַיִם.",
            definitionNative = "Возрождение XIX века: возвращает стрельчатые арки и высокие шпили средневековых соборов.",
            example = "הַפַּרְלָמֶנְט הַבְּרִיטִי הוּא צִיּוּן דֶּרֶךְ נֵאוֹ-גוֹתִי מְפֻרְסָם.",
            exampleNative = "Британский парламент — знаменитый ориентир נֵאוֹ-גוֹתִי.",
            pos = "noun", semanticGroup = "arch_styles_revival", fillInBlankExclusions = listOf(190801L, 190807L, 190811L, 190812L, 190816L, 190818L, 190820L, 190821L)),

        WordEntity(id = 190807, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "מַנְיֶרִיזְם",
            translation = "маньеризм",
            definition = "סִגְנוֹן רֵנֶסַנְסִי מְאֻחָר שֶׁשִּׁבֵּר אֶת הַכְּלָלִים הַקְּלָאסִיִּים בִּשְׁבִיל הַפְתָּעָה וּמֶתַח.",
            definitionNative = "Поздний ренессансный стиль: нарочито нарушал классические правила ради эффекта и напряжения.",
            example = "אַרְמוֹן רוֹמַנוֹ בְּמַנְטוּאָה הוּא דֻּגְמָה שְׁנוּנָה לְמַנְיֶרִיזְם.",
            exampleNative = "Дворец Романо в Мантуе — остроумный пример מַנְיֶרִיזְם.",
            pos = "noun", semanticGroup = "arch_styles_revival", fillInBlankExclusions = listOf(190806L, 190811L, 190812L, 190818L, 190820L, 190821L)),

        WordEntity(id = 190808, setId = 1908, languagePair = "he-ru", rarity = "EPIC",
            original = "סִגְנוֹן בּוֹזָאר",
            translation = "боз-ар",
            definition = "סִגְנוֹן צָרְפָתִי מְפֹאָר שֶׁלֻּמַּד בְּפָּרִיז — סִימֶטְרִיָּה, עַמּוּדִים וְעִטּוּרֵי גִּלּוּף עֲשִׁירִים.",
            definitionNative = "Пышный французский стиль из парижской школы: симметрия, колонны и пышная резьба.",
            example = "תַּחֲנַת גְּרַנְד סֶנְטְרָל בְּנִיוּ יוֹרְק הִיא פְּנִינַת סִגְנוֹן בּוֹזָאר.",
            exampleNative = "Гранд-Сентрал в Нью-Йорке — жемчужина סִגְנוֹן בּוֹזָאר.",
            pos = "phrase", semanticGroup = "arch_styles_revival", fillInBlankExclusions = listOf(190805L, 190809L, 190810L, 190817L)),

        WordEntity(id = 190809, setId = 1908, languagePair = "he-ru", rarity = "EPIC",
            original = "סִגְנוֹן אַמְפִּיר",
            translation = "ампир",
            definition = "סִגְנוֹן מַלְכוּתִי שֶׁל תְּקוּפַת נַפּוֹלֵיאוֹן — עַמּוּדִים כְּבֵדִים, זָהָב וּמוֹטִיבִים שֶׁל מִלְחֶמֶת רוֹמָא.",
            definitionNative = "Парадный стиль эпохи Наполеона: тяжёлые колонны, золото и римские военные мотивы.",
            example = "כְּנֵסִיַּת מַדְלֶן בְּפָּרִיז הִיא הַדֻּגְמָה הַנּוֹעֶזֶת לְסִגְנוֹן אַמְפִּיר.",
            exampleNative = "Церковь Мадлен в Париже — самый смелый пример סִגְנוֹן אַמְפִּיר.",
            pos = "phrase", semanticGroup = "arch_styles_revival", fillInBlankExclusions = listOf(190805L, 190808L, 190810L, 190817L)),

        WordEntity(id = 190810, setId = 1908, languagePair = "he-ru", rarity = "EPIC",
            original = "סִגְנוֹן פֶדֶרָלִי",
            translation = "федеральный стиль",
            definition = "סִגְנוֹן אֲמֵרִיקָאִי מֻקְדָּם סְבִיב 1800 — עַמּוּדִים דַּקִּים, חַלּוֹנוֹת מְנִיפָה וְסִימֶטְרִיָּה שַׁלְוָה.",
            definitionNative = "Ранний американский стиль около 1800 года: тонкие колонны, веерные окна и спокойная симметрия.",
            example = "הַרְבֵּה בָּתִּים יְשָׁנִים בְּבּוֹסְטוֹן הֵם דֻּגְמָה מְאֻפֶּקֶת לְסִגְנוֹן פֶדֶרָלִי.",
            exampleNative = "Многие старые дома Бостона — сдержанный федеральный стиль.",
            pos = "phrase", semanticGroup = "arch_styles_revival", fillInBlankExclusions = listOf(190805L, 190808L, 190809L, 190817L)),

        // ── Group: arch_styles_early_modern (5 words) ─────────────────────────

        WordEntity(id = 190811, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "אַרְט נוּבוֹ",
            translation = "ар-нуво",
            definition = "סִגְנוֹן סְבִיב 1900 — קַוִּים מִתְעַקְּלִים בִּדְמוּת צְמָחִים, מְלָאכוֹת בַּרְזֶל וּזְכוּכִית צְבוּעָה.",
            definitionNative = "Стиль около 1900 года: вьющиеся «растительные» линии, ковка и витражи.",
            example = "כְּנִיסוֹת הָרַכֶּבֶת הַתַּחְתִּית בְּפָּרִיז הֵן יְצִירוֹת אַרְט נוּבוֹ קְלָאסִיּוֹת.",
            exampleNative = "Входы парижского метро — классические работы אַרְט נוּבוֹ.",
            pos = "phrase", semanticGroup = "arch_styles_early_modern"),

        WordEntity(id = 190812, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "פוּטוּרִיזְם",
            translation = "футуризм",
            definition = "תְּנוּעָה אִיטַלְקִית מִלִּפְנֵי מִלְחֶמֶת הָעוֹלָם — פֻּלְחָן הַמְּהִירוּת, הַמְּכוֹנוֹת וְהַמִּגְדָּלִים.",
            definitionNative = "Итальянское движение до Первой мировой: культ скорости, машин и высоких башен.",
            example = "סַנְט אֶלִיָּא צִיֵּר עָרִים שֶׁל פוּטוּרִיזְם שֶׁמֵּעוֹלָם לֹא נִבְנוּ.",
            exampleNative = "Сант-Элиа рисовал города פוּטוּרִיזְם, которые так и не построили.",
            pos = "noun", semanticGroup = "arch_styles_early_modern", fillInBlankExclusions = listOf(190807L, 190815L, 190818L, 190820L, 190821L)),

        WordEntity(id = 190813, setId = 1908, languagePair = "he-ru", rarity = "EPIC",
            original = "סְטְרִימְלַיין מוֹדֶרְן",
            translation = "стримлайн-модерн",
            definition = "סִגְנוֹן שֶׁל שְׁנוֹת הַשְּׁלוֹשִׁים — פִּנּוֹת מְעֻגָּלוֹת, קַוִּים אֳפָקִיִּים אֲרֻכִּים וּמַרְאֶה שֶׁל אֳנִיָּה.",
            definitionNative = "Стиль 1930-х: скруглённые углы, длинные горизонтальные линии и облик океанского лайнера.",
            example = "מִזְנוֹנֵי מַיָאמִי הַיְשָׁנִים מַצִּיגִים פִּתּוּלֵי סְטְרִימְלַיין מוֹדֶרְן וּכְרוֹם.",
            exampleNative = "Старые закусочные Майами щеголяют изгибами סְטְרִימְלַיין מוֹדֶרְן и хромом.",
            pos = "phrase", semanticGroup = "arch_styles_early_modern", fillInBlankExclusions = listOf(190811L, 190814L)),

        WordEntity(id = 190814, setId = 1908, languagePair = "he-ru", rarity = "EPIC",
            original = "דֵה סְטֵייל",
            translation = "Де Стейл",
            definition = "תְּנוּעָה הוֹלַנְדִּית שֶׁמְּצַמְצֶמֶת בִּנְיָנִים לְמִשְׁטָחִים שְׁטוּחִים בְּצִבְעֵי יְסוֹד וְשָׁחֹר־לָבָן.",
            definitionNative = "Голландское движение: здание сводится к плоскостям в основных цветах и чёрно-белом.",
            example = "בֵּית רִיטְוֵלְד שְׁרוֹדֶר הוּא הַבִּנְיָן הַשָּׁלֵם הַיָּחִיד שֶׁל דֵה סְטֵייל.",
            exampleNative = "Дом Шрёдер Ритвельда — единственное полное здание דֵה סְטֵייל.",
            pos = "phrase", semanticGroup = "arch_styles_early_modern", fillInBlankExclusions = listOf(190811L, 190813L, 190815L)),

        WordEntity(id = 190815, setId = 1908, languagePair = "he-ru", rarity = "EPIC",
            original = "פַּלָּאדְיָאנִיוּת",
            translation = "палладианство",
            definition = "תְּנוּעָה רֵנֶסַנְסִית שֶׁל הַמֵּאָה הַשֵּׁשׁ־עֶשְׂרֵה לְפִי כְּלָלֵי הָאַדְרִיכָל הַוֵּנֶצְיָאנִי אַנְדְּרֵאָה פַּלָּאדְיוֹ.",
            definitionNative = "Ренессансное течение XVI века по правилам венецианского зодчего Андреа Палладио.",
            example = "וִילּוֹת בְּצָפוֹן אִיטַלְיָה הֵן הַדֻּגְמָה הַטְּהוֹרָה שֶׁל פַּלָּאדְיָאנִיוּת.",
            exampleNative = "Виллы на севере Италии — чистейший пример פַּלָּאדְיָאנִיוּת.",
            pos = "noun", semanticGroup = "arch_styles_early_modern", fillInBlankExclusions = listOf(190807L, 190812L, 190820L, 190821L)),

        // ── Group: arch_styles_late_modern (5 words) ──────────────────────────

        WordEntity(id = 190816, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "הַיי-טֶק",
            translation = "хай-тек (стиль)",
            definition = "סִגְנוֹן שֶׁל סוֹף הַמֵּאָה הָעֶשְׂרִים שֶׁמּוֹצִיא אֶל הַחוּץ צִנּוֹרוֹת, קוֹרוֹת וּמַעֲלִיּוֹת.",
            definitionNative = "Стиль конца XX века: выносит наружу трубы, балки и лифты.",
            example = "מֶרְכַּז פּוֹמְפִּידוּ הוּא הַבִּנְיָן הַנּוֹעָז שֶׁל הַיי-טֶק בְּפָּרִיז.",
            exampleNative = "Центр Помпиду — самое смелое здание הַיי-טֶק в Париже.",
            pos = "phrase", semanticGroup = "arch_styles_late_modern", fillInBlankExclusions = listOf(190811L, 190817L, 190818L, 190819L, 190820L)),

        WordEntity(id = 190817, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "סִגְנוֹן הַפְּרֵרְיָה",
            translation = "стиль прерий",
            definition = "סִגְנוֹן אֲמֵרִיקָאִי שֶׁל תְּחִלַּת הַמֵּאָה הָעֶשְׂרִים — גַּגּוֹת נְמוּכִים וְקַוִּים אֳפָקִיִּים צְמוּדִים לַקַּרְקַע.",
            definitionNative = "Американский стиль начала XX века: низкие крыши и горизонтальные линии, прижатые к земле.",
            example = "בֵּית רוֹבִּי שֶׁל פְרֶנְק לוֹיְד רַייְט הוּא אַיְקוֹן שֶׁל סִגְנוֹן הַפְּרֵרְיָה.",
            exampleNative = "Дом Роби Райта — икона סִגְנוֹן הַפְּרֵרְיָה.",
            pos = "phrase", semanticGroup = "arch_styles_late_modern", fillInBlankExclusions = listOf(190808L, 190809L, 190810L, 190816L, 190819L)),

        WordEntity(id = 190818, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "בְּרוּטָלִיזְם",
            translation = "брутализм",
            definition = "סִגְנוֹן שֶׁל אֶמְצַע הַמֵּאָה הָעֶשְׂרִים — בֵּטוֹן חָשׂוּף, גּוּשִׁים כְּבֵדִים וְקַוִּים גָּסִים.",
            definitionNative = "Стиль середины XX века: голый бетон, тяжёлые объёмы и грубые линии.",
            example = "הַרְבֵּה מְשַׂרְדֵי מֶמְשָׁלָה בִּירוּשָׁלַיִם הֵם בְּרוּטָלִיזְם טִיפּוּסִי.",
            exampleNative = "Многие правительственные здания Иерусалима — типичный בְּרוּטָלִיזְם.",
            pos = "noun", semanticGroup = "arch_styles_late_modern", fillInBlankExclusions = listOf(190807L, 190812L, 190820L, 190821L)),

        WordEntity(id = 190819, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "הַסִּגְנוֹן הַבֵּינְלְאוּמִי",
            translation = "международный стиль",
            definition = "תְּנוּעָה שֶׁל אַחֲרֵי מִלְחֶמֶת הָעוֹלָם הָרִאשׁוֹנָה — קֻפְסָאוֹת לְבָנוֹת, גַּגּוֹת שְׁטוּחִים וְחַלּוֹנוֹת אֳפָקִיִּים.",
            definitionNative = "Движение после Первой мировой: белые коробки, плоские крыши и горизонтальные окна.",
            example = "תֵּל אָבִיב נִבְנְתָה בְּחֶלְקָהּ עַל פִּי הַסִּגְנוֹן הַבֵּינְלְאוּמִי.",
            exampleNative = "Тель-Авив отчасти строился по הַסִּגְנוֹן הַבֵּינְלְאוּמִי.",
            pos = "phrase", semanticGroup = "arch_styles_late_modern", fillInBlankExclusions = listOf(190816L, 190817L)),

        WordEntity(id = 190820, setId = 1908, languagePair = "he-ru", rarity = "EPIC",
            original = "פָּרָמֵטְרִיצִיזְם",
            translation = "параметризм",
            definition = "גִּישָׁה דִּיגִיטָלִית שֶׁמְּעַצֶּבֶת בִּנְיָנִים דֶּרֶךְ עַקְמוּמִיּוֹת מָתֵמָטִיּוֹת בַּמַּחְשֵׁב.",
            definitionNative = "Цифровой подход: форма здания задаётся математическими кривыми на компьютере.",
            example = "הַבִּנְיָנִים הַשּׁוֹטְפִים שֶׁל זָהָא חָדִיד הֵם פְּנֵי פָּרָמֵטְרִיצִיזְם.",
            exampleNative = "Текучие здания Захи Хадид — лицо פָּרָמֵטְרִיצִיזְם.",
            pos = "noun", semanticGroup = "arch_styles_late_modern", fillInBlankExclusions = listOf(190807L, 190812L, 190818L, 190821L)),

        // ── Group: arch_styles_israeli (5 words) ──────────────────────────────

        WordEntity(id = 190821, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "אֶקְלֶקְטִיצִיזְם",
            translation = "эклектика",
            definition = "גִּישָׁה שֶׁמְּעָרֶבֶת בְּחֹפֶשׁ חֲלָקִים מִסִּגְנוֹנוֹת הִיסְטוֹרִיִּים שׁוֹנִים בְּבִנְיָן אֶחָד.",
            definitionNative = "Подход: свободно смешивает части разных исторических стилей в одном здании.",
            example = "הָרְחוֹב רוֹטְשִׁילְד בְּתֵל אָבִיב מָלֵא בְּאֶקְלֶקְטִיצִיזְם שֶׁל שְׁנוֹת הָעֶשְׂרִים.",
            exampleNative = "Улица Ротшильда в Тель-Авиве полна אֶקְלֶקְטִיצִיזְם 1920-х.",
            pos = "noun", semanticGroup = "arch_styles_israeli", fillInBlankExclusions = listOf(190807L, 190812L, 190818L, 190820L)),

        WordEntity(id = 190822, setId = 1908, languagePair = "he-ru", rarity = "RARE",
            original = "הָעִיר הַלְּבָנָה",
            translation = "Белый город (Тель-Авив)",
            definition = "כִּינּוּי לְלֵב תֵּל אָבִיב, אֶזוֹר שֶׁל יוֹנֶסְקוֹ עִם רִכּוּז גָּדוֹל שֶׁל בָּתֵּי בַּאוּהָאוּס מֻלְבָּנִים.",
            definitionNative = "Прозвание сердца Тель-Авива — объект ЮНЕСКО с большим скоплением выбеленных бауhаус-домов.",
            example = "טִיּוּל בְּרֶגֶל בְּהָעִיר הַלְּבָנָה מַתְחִיל מִשְּׂדֵרוֹת רוֹטְשִׁילְד.",
            exampleNative = "Пешая прогулка по הָעִיר הַלְּבָנָה начинается с бульвара Ротшильда.",
            pos = "phrase", semanticGroup = "arch_styles_israeli", fillInBlankExclusions = listOf(190823L, 190824L, 190825L)),

        WordEntity(id = 190823, setId = 1908, languagePair = "he-ru", rarity = "EPIC",
            original = "בָּאוּהָאוּס תֵּל אָבִיב",
            translation = "тель-авивский баухаус",
            definition = "וַרְיַאצְיָה מְקוֹמִית שֶׁל הַתְּנוּעָה הַגֶּרְמָנִית, מֻתְאֶמֶת לַחֹם: מִרְפְּסוֹת מֻצְלוֹת וְקִירוֹת לְבָנִים.",
            definitionNative = "Местная вариация немецкого движения, приспособленная к жаре: затенённые балконы и белые стены.",
            example = "הַסַּדְנָה מַסְבִּירָה אֵיךְ בָּאוּהָאוּס תֵּל אָבִיב הִתְמוֹדֵד עִם הָאַקְלִים.",
            exampleNative = "Семинар объясняет, как בָּאוּהָאוּס תֵּל אָבִיב справлялся с климатом.",
            pos = "phrase", semanticGroup = "arch_styles_israeli", fillInBlankExclusions = listOf(190822L, 190824L, 190825L)),

        WordEntity(id = 190824, setId = 1908, languagePair = "he-ru", rarity = "EPIC",
            original = "אַדְרִיכָלוּת תֵּמְפְּלָרִית",
            translation = "темплерская архитектура",
            definition = "סִגְנוֹן הַמּוֹשָׁבוֹת שֶׁל הַתֵּמְפְּלָרִים הַגֶּרְמָנִים בְּאֶרֶץ יִשְׂרָאֵל — אֶבֶן יְרוּשָׁלְמִית וְגַגּוֹת אֲדֻמִּים.",
            definitionNative = "Стиль колоний немецких темплеров в Палестине — иерусалимский камень и красные крыши.",
            example = "סָרוֹנָה בְּתֵל אָבִיב שִׁמֵּרָה אֶת הָאַדְרִיכָלוּת הַתֵּמְפְּלָרִית הַמְּקוֹרִית.",
            exampleNative = "Сарона в Тель-Авиве сохранила исходную אַדְרִיכָלוּת תֵּמְפְּלָרִית.",
            pos = "phrase", semanticGroup = "arch_styles_israeli"),

        WordEntity(id = 190825, setId = 1908, languagePair = "he-ru", rarity = "EPIC",
            original = "אַדְרִיכָלוּת בִּיוֹקְלִימָטִית",
            translation = "биоклиматическая архитектура",
            definition = "גִּישָׁה שֶׁמַּתְאִימָה בִּנְיָן לְשֶׁמֶשׁ, רוּחַ וְלַחוּת מְקוֹמִיּוֹת בִּמְקוֹם לְהִישָּׁעֵן עַל מַזְגָּנִים.",
            definitionNative = "Подход: подгоняет здание под местное солнце, ветер и влажность, не полагаясь на кондиционеры.",
            example = "הַמִּבְנֶה הֶחָדָשׁ בַּנֶּגֶב מַדְגִּים אַדְרִיכָלוּת בִּיוֹקְלִימָטִית.",
            exampleNative = "Новое здание в Негеве демонстрирует אַדְרִיכָלוּת בִּיוֹקְלִימָטִית.",
            pos = "phrase", semanticGroup = "arch_styles_israeli", fillInBlankExclusions = listOf(190822L, 190823L, 190824L)),
    )
}
