package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "У врача в Израиле", уровень L5 (носитель языка).
 *
 * Set 1806: «У врача в Израиле» — носитель языка (EPIC+LEGENDARY):
 *           серьёзные онкологические диагнозы, специальные процедуры,
 *           второе мнение и медицинская этика в израильской системе,
 *           продвинутая фармакология (orphan drugs, дженерики, формулы).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   doctor_serious_dx        — серьёзные диагнозы: онкология, опухоль, карцинома, стадия, патогенность
 *   doctor_special_procedures — спец-процедуры: биопсия, эндоскопия, цинтур (катетер), ангиография, трансплантация
 *   doctor_second_opinion    — второе мнение: chavat daat, врачебная комиссия, ошибка диагноза, показание, схема лечения
 *   doctor_ethics            — этика: паллиатив, информированное согласие, advance directive, врачебная тайна, моральная дилемма
 *   doctor_advanced_meds     — продвинутая фарма: лекарства по обязательству, дженерик, orphan drug, мед-добавки, адаптивная формула
 *
 * Word IDs: setId × 100 + position (180601..180625).
 *
 * Пересечения с другими наборами:
 *   - WordDataHebrewMedicineV2 (1600-1606) — общая медицинская лексика; здесь не повторяются
 *     (исключены גְּרוּרוֹת/רְמִיסְיָה из 1606, заменены на קַרְצִינוֹמָה/סְטָדְיוּם שֶׁל הַמַּחֲלָה).
 *   - WordDataHebrewHealthFitness L4-L5 (1790-1791) — фитнес и эндокринология; не пересекаются.
 *   - L1-L4 «У врача в Израиле» (1802-1805, параллельная задача) — здесь не повторяются.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 *
 * Замечание про термин «צִנְתּוּר לֵב» (id=180608): в задании было передано как
 * «צְנִיחַת לֵב», что буквально означает «прыжок сердца» и не является медицинским
 * термином. Реальное обозначение катетеризации сердца — צִנְתּוּר לֵב, использовано здесь.
 */
object WordDataHebrewDoctorL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1806, languagePair = "he-ru", orderIndex = 1806,
            name = "У врача в Израиле",
            description = "Уровень носителя: серьёзные диагнозы, специальные процедуры, медицинская этика",
            topic = "У врача в Израиле", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1806 — У врача в Израиле: носитель языка (L5, EPIC+LEGENDARY)
        // 5 групп × 5 слов: serious_dx, special_procedures, second_opinion, ethics, advanced_meds
        // ══════════════════════════════════════════════════════════════════════

        // ── doctor_serious_dx (5) — серьёзные диагнозы и онкология ──
        WordEntity(
            id = 180601, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_serious_dx", transliteration = "rofe hemato-onkolog",
            original = "רוֹפֵא הֵמָטוֹ-אוֹנְקוֹלוֹג", translation = "гемато-онколог",
            definition = "מֻמְחֶה לְמַחֲלוֹת הַדָּם וְלִגְדִילוֹת מַמְאִירוֹת — מְלַוֶּה כִּימוֹתֶרַפְּיָה.",
            definitionNative = "Специалист по болезням крови и злокачественным образованиям — ведёт химию.",
            example = "רוֹפֵא הֵמָטוֹ-אוֹנְקוֹלוֹג קוֹבֵעַ אֶת מַסְלוּל הַטִּפּוּל הַסּוֹפִי.",
            exampleNative = "רוֹפֵא הֵמָטוֹ-אוֹנְקוֹלוֹג назначает финальный план лечения.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180602, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_serious_dx", transliteration = "gidul memaer",
            original = "גִּדּוּל מְמַאֵר", translation = "злокачественная опухоль",
            definition = "מַסָּה שֶׁל תָּאִים שֶׁמִּתְרַבִּים בְּלִי שְׁלִיטָה וְעֲלוּלִים לְהִתְפַּשֵּׁט בַּגּוּף.",
            definitionNative = "Скопление клеток, что бесконтрольно растёт и может расползаться по телу.",
            example = "הַבְּדִיקָה אִשְּׁרָה שֶׁמְּדֻבָּר בְּגִדּוּל מְמַאֵר וְלֹא בְּצִיסְטָה.",
            exampleNative = "Анализ подтвердил, что это גִּדּוּל מְמַאֵר, а не киста.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180603, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_serious_dx", transliteration = "kartzinoma",
            original = "קַרְצִינוֹמָה", translation = "карцинома",
            definition = "סוּג שֶׁל גִּדּוּל הַמּוֹפִיעַ בָּרְקָמוֹת הַמְּצַפּוֹת אֶת הַגּוּף וְאֶת אֵיבָרָיו.",
            definitionNative = "Тип опухоли, что появляется в тканях, выстилающих тело и его органы.",
            example = "הַבִּיוֹפְּסִיָּה גִּלְּתָה קַרְצִינוֹמָה שֶׁל הָעוֹר בְּשַׁלָּב מֻקְדָּם.",
            exampleNative = "Биопсия выявила קַרְצִינוֹמָה кожи на ранней стадии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180604, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_serious_dx", transliteration = "stadium shel ha-makhala",
            original = "סְטָדְיוּם שֶׁל הַמַּחֲלָה", translation = "стадия болезни",
            definition = "דַּרְגַּת הַחֻמְרָה וְהַהִתְפַּשְּׁטוּת שֶׁל הַתַּהֲלִיךְ הַחוֹלָנִי בַּגּוּף.",
            definitionNative = "Степень тяжести и распространения болезненного процесса в теле.",
            example = "הָרוֹפֵא הִסְבִּיר שֶׁהַסְּטָדְיוּם שֶׁל הַמַּחֲלָה קוֹבֵעַ אֶת מַסְלוּל הַטִּפּוּל.",
            exampleNative = "Врач объяснил, что סְטָדְיוּם שֶׁל הַמַּחֲלָה определяет схему лечения.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180605, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_serious_dx", transliteration = "poganut",
            original = "פּוֹגָנוּת", translation = "патогенность",
            definition = "מִדַּת הַיְּכֹלֶת שֶׁל גּוֹרֵם זָר לִגְרֹם נֶזֶק וּלְהוֹלִיד מַחֲלָה אֵצֶל הַמְּאוּחְזָר.",
            definitionNative = "Способность чужеродного фактора причинять вред и порождать болезнь у заражённого.",
            example = "הַפּוֹגָנוּת שֶׁל הַזַּן הֶחָדָשׁ נִבְדֶּקֶת בְּמַעְבָּדוֹת בִּטְחוֹן גָּבוֹהַּ.",
            exampleNative = "פּוֹגָנוּת нового штамма проверяют в лабораториях высокой безопасности.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_special_procedures (5) — специальные диагностические и хирургические процедуры ──
        WordEntity(
            id = 180606, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_special_procedures", transliteration = "dgimat rikma",
            original = "דְּגִימַת רִקְמָה", translation = "взятие образца ткани",
            definition = "לְקִיחַת חֵלֶק זָעִיר מֵאֵיבָר חַי כְּדֵי לִבְדֹּק תַּחַת מִיקְרוֹסְקוֹפּ.",
            definitionNative = "Изъятие крошечной части живого органа, чтобы рассмотреть под микроскопом.",
            example = "הָרוֹפֵא הִזְמִין דְּגִימַת רִקְמָה מִן הַשּׁוּמָה הַחֲשׁוּדָה.",
            exampleNative = "Врач назначил взятие образца ткани с подозрительной родинки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180607, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_special_procedures", transliteration = "endoskopiya",
            original = "אֶנְדּוֹסְקוֹפְּיָה", translation = "эндоскопия",
            definition = "בְּדִיקָה פְּנִימִית בְּעֶזְרַת צִנּוֹר דַּק עִם מַצְלֵמָה הַמּוּחְדָּר דֶּרֶךְ פֶּתַח טִבְעִי.",
            definitionNative = "Внутренний осмотр тонкой трубкой с камерой, что вводят через естественное отверстие.",
            example = "אֶנְדּוֹסְקוֹפְּיָה בַּקֵּיבָה גִּלְּתָה כִּיב קָטָן וְשׁוֹתֵת.",
            exampleNative = "אֶנְדּוֹסְקוֹפְּיָה желудка обнаружила небольшую кровоточащую язву.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180608, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_special_procedures", transliteration = "tzintur lev",
            original = "צִנְתּוּר לֵב", translation = "катетеризация сердца",
            definition = "הַחְדָּרַת צִנּוֹרִית דַּקָּה אֶל כְּלֵי הַדָּם כְּדֵי לְאַבְחֵן אוֹ לִפְתֹּחַ חֲסִימָה.",
            definitionNative = "Введение тонкой трубочки в сосуды, чтобы поставить диагноз или раскрыть закупорку.",
            example = "אַחֲרֵי הַתְקָפָה הוּא עָבַר צִנְתּוּר לֵב דְּחוּף.",
            exampleNative = "После приступа он прошёл срочную צִנְתּוּר לֵב.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180609, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_special_procedures", transliteration = "angiografiya",
            original = "אַנְגְיוֹגְרַפְיָה", translation = "ангиография",
            definition = "צִלּוּם שֶׁל כְּלֵי הַדָּם בְּעֶזְרַת חֹמֶר נִגּוּד וּקְרִינַת רֶנְטְגֵּן.",
            definitionNative = "Снимок кровеносных сосудов с помощью контрастного вещества и рентгеновских лучей.",
            example = "הָרוֹפֵא הִזְמִין אַנְגְיוֹגְרַפְיָה כְּדֵי לְאַתֵּר אֶת הַחֲסִימָה.",
            exampleNative = "Врач назначил אַנְגְיוֹגְרַפְיָה, чтобы найти точное место закупорки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180610, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_special_procedures", transliteration = "hashtala",
            original = "הַשְׁתָּלָה", translation = "трансплантация",
            definition = "הַעֲבָרָה שֶׁל אֵיבָר בָּרִיא מִתּוֹרֵם אֶל גּוּפוֹ שֶׁל מִי שֶׁחַי בְּלִי תִּפְקוּד תָּקִין.",
            definitionNative = "Передача здорового органа от донора в тело того, кто живёт без нормальной работы органа.",
            example = "אַחֲרֵי שָׁנִים שֶׁל הַמְתָּנָה הוּא קִבֵּל הַשְׁתָּלָה שֶׁל כָּבֵד.",
            exampleNative = "После лет ожидания он получил הַשְׁתָּלָה печени.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_second_opinion (5) — второе мнение, комиссия, ошибки диагностики ──
        WordEntity(
            id = 180611, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_second_opinion", transliteration = "hitya'atzut mumkhe nosaf",
            original = "הִתְיַעֲצוּת מוּמְחֶה נוֹסָף", translation = "дополнительная экспертная консультация",
            definition = "פְּגִישָׁה אֶצֶל אִישׁ מִקְצוֹעַ אַחֵר לְקַבָּלַת זָוִית רְאִיָּה שׁוֹנָה עַל אַבְחָנָה.",
            definitionNative = "Встреча у другого специалиста — чтобы получить иной взгляд на поставленный диагноз.",
            example = "לִפְנֵי הַנִּתּוּחַ הוּא קָבַע הִתְיַעֲצוּת מוּמְחֶה נוֹסָף בְּבֵית חוֹלִים פְּרָטִי.",
            exampleNative = "Перед операцией он назначил дополнительную экспертную консультацию в частной больнице.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180612, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_second_opinion", transliteration = "vaadat rofim",
            original = "וַעֲדַת רוֹפְאִים", translation = "врачебная комиссия",
            definition = "צֶוֶת שֶׁל כַּמָּה מֻמְחִים שֶׁמִּתְכַּנֵּס לְהַחְלִיט בְּמִקְרֶה מֻרְכָּב.",
            definitionNative = "Совет нескольких специалистов, что собирается решить сложный случай.",
            example = "וַעֲדַת רוֹפְאִים אִשְּׁרָה אֶת הַזְּכוּת שֶׁלּוֹ לְטִפּוּל יָקָר.",
            exampleNative = "וַעֲדַת רוֹפְאִים подтвердила его право на дорогостоящее лечение.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180613, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_second_opinion", transliteration = "ivkhun mut'eh",
            original = "אִבְחוּן מוּטָעֶה", translation = "ошибочный диагноз",
            definition = "מַצָּב שֶׁבּוֹ הַזִּהוּי שֶׁל הַמַּחֲלָה אֵינוֹ נָכוֹן וְהַטִּפּוּל פּוֹנֶה לְכִוּוּן לֹא נְכוֹן.",
            definitionNative = "Когда определение болезни ошибочно и лечение идёт не в ту сторону.",
            example = "אִבְחוּן מוּטָעֶה גָּרַם לוֹ לְקַבֵּל תְּרוּפוֹת לֹא מַתְאִימוֹת חֳדָשִׁים אֲרֻכִּים.",
            exampleNative = "אִבְחוּן מוּטָעֶה заставил его получать неподходящие препараты долгие месяцы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180614, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_second_opinion", transliteration = "hatvaya refuit",
            original = "הַתְוָיָה רְפוּאִית", translation = "медицинское показание",
            definition = "סִבָּה מִקְצוֹעִית מְבֻסֶּסֶת שֶׁמַּצְדִּיקָה מַתָּן טִפּוּל אוֹ נִתּוּחַ לַחוֹלֶה.",
            definitionNative = "Профессионально обоснованная причина, что оправдывает лечение или операцию у больного.",
            example = "אֵין הַתְוָיָה רְפוּאִית לַנִּתּוּחַ הַזֶּה — הַשְּׁרִירִים יִתְחַזְּקוּ לְבַד.",
            exampleNative = "Нет הַתְוָיָה רְפוּאִית к этой операции — мышцы окрепнут сами.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180615, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_second_opinion", transliteration = "maslul tipul",
            original = "מַסְלוּל טִפּוּל", translation = "схема лечения",
            definition = "תָּכְנִית שֶׁל שְׁלָבִים וּפְעֻלּוֹת שֶׁהָרוֹפֵא מְתַכְנֵן עֲבוּר הַחוֹלֶה לְאֹרֶךְ זְמָן.",
            definitionNative = "План этапов и действий, что врач выстраивает для больного на длительный срок.",
            example = "מַסְלוּל הַטִּפּוּל כּוֹלֵל שִׁשָּׁה מַחֲזוֹרִים בְּמֶרְחָק שָׁבוּעַ.",
            exampleNative = "מַסְלוּל טִפּוּל включает шесть циклов с интервалом в неделю.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_ethics (5) — медицинская этика, паллиатив, согласие, конфиденциальность ──
        WordEntity(
            id = 180616, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_ethics", transliteration = "rippui paliyativi",
            original = "רִפּוּי פַּלִּיאַטִיבִי", translation = "паллиативная терапия",
            definition = "טִפּוּל שֶׁמַּפְחִית סֵבֶל וּמְשַׁפֵּר אֵיכוּת חַיִּים כַּאֲשֶׁר אֵין מַרְפֵּא לַמַּחֲלָה.",
            definitionNative = "Помощь, что снимает страдания и улучшает качество жизни, когда болезнь уже неизлечима.",
            example = "הַמִּשְׁפָּחָה הֶחְלִיטָה לַעֲבֹר מִטִּפּוּל פָּעִיל לְרִפּוּי פַּלִּיאַטִיבִי.",
            exampleNative = "Семья решила перейти от активного лечения к רִפּוּי פַּלִּיאַטִיבִי.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180617, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_ethics", transliteration = "khatima al ha-haskama",
            original = "חֲתִימָה עַל הַסְכָּמָה", translation = "подписание согласия",
            definition = "אִשּׁוּר בִּכְתָב שֶׁל הַחוֹלֶה לְבַצֵּעַ פְּעֻלָּה רְפוּאִית, אַחֲרֵי שֶׁהֵבִין אֶת סִכּוּנֶיהָ.",
            definitionNative = "Письменное подтверждение пациента на медицинскую процедуру, после понимания её рисков.",
            example = "לִפְנֵי הַנִּיתּוּחַ נִדְרֶשֶׁת חֲתִימָה עַל הַסְכָּמָה מוּדַעַת.",
            exampleNative = "Перед операцией требуется חֲתִימָה עַל הַסְכָּמָה — информированная.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180618, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_ethics", transliteration = "tzava'a mekademet",
            original = "צַוָּאָה מְקַדֶּמֶת", translation = "предварительное распоряжение",
            definition = "מִסְמָךְ מְשַׁפְטִי שֶׁבּוֹ אָדָם קוֹבֵעַ מֵרֹאשׁ אֵיךְ לְטַפֵּל בּוֹ אִם לֹא יוּכַל לְהַחְלִיט.",
            definitionNative = "Юридический документ, в котором человек заранее задаёт, как лечить его, если он не сможет решать.",
            example = "הוּא חָתַם עַל צַוָּאָה מְקַדֶּמֶת בָּהּ סֵרֵב לְהַחְיָאָה.",
            exampleNative = "Он подписал צַוָּאָה מְקַדֶּמֶת с отказом от реанимации.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180619, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_ethics", transliteration = "sodiyut refuit",
            original = "סוֹדִיוּת רְפוּאִית", translation = "врачебная тайна",
            definition = "חוֹבָה שֶׁל הָרוֹפֵא לֹא לְגַלּוֹת מֵידָע אִישִׁי שֶׁל הַחוֹלֶה לְאַף אֶחָד אַחֵר.",
            definitionNative = "Долг врача не раскрывать личные сведения о больном никакому третьему лицу.",
            example = "הָרוֹפֵא סֵרֵב לְמַסֹר מֵידָע לַבַּעַל מִשּׁוּם סוֹדִיוּת רְפוּאִית.",
            exampleNative = "Врач отказался передать сведения мужу из-за סוֹדִיוּת רְפוּאִית.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180620, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_ethics", transliteration = "safek musari",
            original = "סָפֵק מוּסָרִי", translation = "моральная дилемма",
            definition = "מַצָּב שֶׁבּוֹ קָשֶׁה לְהַכְרִיעַ בֵּין שְׁתֵּי דְּרָכִים שֶׁשְּׁתֵּיהֶן פּוֹגְעוֹת בְּעֶרֶךְ חָשׁוּב.",
            definitionNative = "Положение, когда трудно выбрать между двумя путями — оба задевают важную ценность.",
            example = "הָרוֹפֵאָה הִתְלַבְּטָה בְּסָפֵק מוּסָרִי בֵּין רְצוֹן הַמִּשְׁפָּחָה לְטוֹבַת הַחוֹלֶה.",
            exampleNative = "Врач переживала סָפֵק מוּסָרִי между желанием семьи и интересом больного.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_advanced_meds (5) — продвинутая фармакология ──
        WordEntity(
            id = 180621, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_advanced_meds", transliteration = "trufot be-hitkhayvut",
            original = "תְּרוּפוֹת בְּהִתְחַיְּבוּת", translation = "лекарства по обязательству",
            definition = "תַּכְשִׁירִים יְקָרִים שֶׁקֻּפַּת הַחוֹלִים מְמַמֶּנֶת רַק אַחֲרֵי אִשּׁוּר מְיֻחָד וּמְיֻעָד.",
            definitionNative = "Дорогие препараты, что больничная касса оплачивает лишь после особого утверждения.",
            example = "הַתַּכְשִׁיר נִכְלָל בִּתְרוּפוֹת בְּהִתְחַיְּבוּת — חַיִּים לְמַלֵּא טֹפֶס מַתְאִים.",
            exampleNative = "Препарат входит в תְּרוּפוֹת בְּהִתְחַיְּבוּת — нужно заполнить специальный бланк.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180622, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_advanced_meds", transliteration = "generika",
            original = "גֵּנֵרִיקָה", translation = "дженерик",
            definition = "תַּכְשִׁיר עִם אוֹתוֹ חֹמֶר פָּעִיל כְּמוֹ הַתַּכְשִׁיר הַמְּקוֹרִי, אֲבָל בְּמְחִיר נָמוּךְ יוֹתֵר.",
            definitionNative = "Препарат с тем же действующим веществом, что у оригинала, — но дешевле.",
            example = "הָרוֹקֵחַ הִצִּיעַ גֵּנֵרִיקָה בִּמְקוֹם הַתַּכְשִׁיר הַיָּקָר שֶׁל הַחֶבְרָה.",
            exampleNative = "Аптекарь предложил גֵּנֵרִיקָה вместо дорогого фирменного препарата.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180623, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_advanced_meds", transliteration = "sam yatom",
            original = "סַם יָתוֹם", translation = "орфанный препарат",
            definition = "תַּכְשִׁיר נָדִיר שֶׁמְּפַתְּחִים עֲבוּר מַחֲלוֹת שֶׁפּוֹגְעוֹת בְּמִעוּט קָטָן שֶׁל אֲנָשִׁים.",
            definitionNative = "Редкий препарат, что разрабатывают для болезней — те, что бьют по малому числу людей.",
            example = "הַחֹלֶה קִבֵּל סַם יָתוֹם רַק אַחֲרֵי מַאֲבָק מִשְׁפָּטִי אָרֹךְ.",
            exampleNative = "Больной получил סַם יָתוֹם только после долгой судебной тяжбы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180624, setId = 1806, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "doctor_advanced_meds", transliteration = "tosaf tezuna refui",
            original = "תּוֹסָף תְּזוּנָה רְפוּאִי", translation = "медицинская добавка",
            definition = "מוֹצָר עִם וִיטָמִינִים אוֹ חֹמְרֵי תְּזוּנָה שֶׁמַּשְׁלִים מַחְסוֹר אֵצֶל הַחוֹלֶה.",
            definitionNative = "Продукт с витаминами или питательными веществами — восполняет нехватку у больного.",
            example = "אַחֲרֵי הַנִּיתּוּחַ הִיא קִבְּלָה תּוֹסָף תְּזוּנָה רְפוּאִי לְהַחְלָמָה מְהִירָה.",
            exampleNative = "После операции ей дали תּוֹסָף תְּזוּנָה רְפוּאִי для быстрого восстановления.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180625, setId = 1806, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_advanced_meds", transliteration = "formula mat'ema",
            original = "פוֹרְמוּלָה מַתְאֶמֶת", translation = "адаптивная формула",
            definition = "מִרְשָׁם מְיֻחָד שֶׁמַּתְאִימִים אִישִׁית לַחוֹלֶה לְפִי גִּיל, מִשְׁקָל וּתְגוּבָה לַטִּפּוּל.",
            definitionNative = "Особый состав, что подгоняют под пациента — по возрасту, весу и отклику на лечение.",
            example = "הָרוֹקֵחַ הֵכִין לוֹ פוֹרְמוּלָה מַתְאֶמֶת לְפִי הַנְחָיוֹת הָרוֹפֵא.",
            exampleNative = "Аптекарь приготовил ему פוֹרְמוּלָה מַתְאֶמֶת по указаниям врача.",
            isFillInBlankSafe = false,
        ),
    )
}
