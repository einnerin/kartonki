package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "У врача в Израиле", L2 «Продвинутый» (UNCOMMON+RARE).
 *
 * Set 1803: «У врача в Израиле» — продвинутый L2:
 *           запись, измерения, типичные процедуры, анамнез, направления.
 *
 * Целевая аудитория — русскоязычные репатрианты в Израиле, попадающие
 * к семейному врачу или специалисту. Лексика — то, что реально звучит
 * у стойки, в кабинете и в выписке: בְּדִיקַת גָּרוֹן, רֶקַע רְפוּאִי,
 * הַפְנָיָה לְמוּמְחֶה, פְּטוֹר חוֹלִים, אִישּׁוּר נְסִיעָה.
 *
 * Распределение редкостей: 13 UNCOMMON + 12 RARE.
 *
 * SemanticGroups (5 × 5):
 *   doctor_appointment        — срочный приём, отмена/перенос, ресепшн, консультант
 *   doctor_measurements       — давление, пульс, вес, рост, температура
 *   doctor_simple_procedures  — общий осмотр, выслушивание сердца, осмотр горла/уха, пальпация
 *   doctor_history            — медицинский анамнез: фон, аллергии, операции, семья, лекарства
 *   doctor_referrals          — направления, выписной эпикриз, освобождение, справки
 *
 * Word IDs: setId × 100 + position (180301..180325).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewDoctorL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1803, languagePair = "he-ru", orderIndex = 1803,
            name = "У врача в Израиле",
            description = "Продвинутый базовый: запись, измерения, типичные процедуры",
            topic = "У врача в Израиле", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1803 — У врача в Израиле: продвинутый (L2, UNCOMMON+RARE)
        // 5 групп × 5 слов: appointment, measurements, simple_procedures, history, referrals
        // ══════════════════════════════════════════════════════════════════════

        // ── doctor_appointment (5) — запись, отмена, ресепшн ──
        WordEntity(
            id = 180301, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_appointment", transliteration = "tor dakhuf",
            original = "תּוֹר דָּחוּף", translation = "срочный приём",
            definition = "פְּגִישָׁה אֵצֶל הָרוֹפֵא שֶׁמְּסַדְּרִים בְּאוֹתוֹ הַיּוֹם בְּגִין מַצָּב חָמוּר.",
            definitionNative = "Встреча у врача в тот же день — когда состояние не терпит ожидания.",
            example = "קִבַּלְתִּי תּוֹר דָּחוּף לַצָּהֳרַיִם בִּגְלַל חֹם גָּבוֹהַּ.",
            exampleNative = "Получил תּוֹר דָּחוּף на полдень из-за высокой температуры.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180302, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_appointment", transliteration = "bitul tor",
            original = "בִּטּוּל תּוֹר", translation = "отмена записи",
            definition = "הוֹדָעָה לַמִּרְפָּאָה שֶׁאֵין מַגִּיעִים — כְּדֵי לְפַנּוֹת לְמִישֶׁהוּ אַחֵר.",
            definitionNative = "Сообщить в клинику, что не придёшь — чтобы освободить место другим.",
            example = "בִּטּוּל תּוֹר אֶפְשָׁרִי בָּאַפְּלִיקַצְיָה עַד שְׁלוֹשׁ שָׁעוֹת קֹדֶם.",
            exampleNative = "בִּטּוּל תּוֹר возможно через приложение за три часа до приёма.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180303, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_appointment", transliteration = "dkhiyat tor",
            original = "דְּחִיַּת תּוֹר", translation = "перенос записи",
            definition = "הַעֲבָרָה שֶׁל הַפְּגִישָׁה לְמוֹעֵד אַחֵר — בְּגִלְלֵי הַמִּרְפָּאָה אוֹ הַמְּטֻפָּל.",
            definitionNative = "Сдвиг встречи на другой день — по причине клиники или пациента.",
            example = "הִתְקַשְׁרוּ מֵהַקֻּפָּה וּבִקְשׁוּ דְּחִיַּת תּוֹר לַשָּׁבוּעַ הַבָּא.",
            exampleNative = "Звонили из больничной кассы и просили דְּחִיַּת תּוֹר на следующую неделю.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180304, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_appointment", transliteration = "mazkira refuit",
            original = "מַזְכִּירָה רְפוּאִית", translation = "медицинский секретарь",
            definition = "הָאִשָּׁה בַּקַּבָּלָה שֶׁמְּסַדֶּרֶת תְּעוּדוֹת, תּוֹרִים וּכְנִיסָה לָרוֹפֵא.",
            definitionNative = "Женщина на ресепшне — оформляет справки, очередь и впускает к врачу.",
            example = "מַזְכִּירָה רְפוּאִית בִּקְשָׁה מִמֶּנִּי תְּעוּדַת זֶהוּת בַּכְּנִיסָה.",
            exampleNative = "מַזְכִּירָה רְפוּאִית попросила у меня удостоверение на входе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180305, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_appointment", transliteration = "yoets refui",
            original = "יוֹעֵץ רְפוּאִי", translation = "медицинский консультант",
            definition = "אִישׁ מִקְצוֹעַ הַמְּסַיֵּעַ לִבְחוֹר רוֹפֵא, טִיפּוּל אוֹ דֶּרֶךְ פְּעֻלָּה.",
            definitionNative = "Профессионал — помогает выбрать врача, лечение или дальнейший путь.",
            example = "יוֹעֵץ רְפוּאִי הִמְלִיץ לִי לִפְנוֹת לַקַּרְדִּיוֹלוֹג.",
            exampleNative = "יוֹעֵץ רְפוּאִי посоветовал мне обратиться к кардиологу.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_measurements (5) — давление, пульс, вес, рост, температура ──
        WordEntity(
            id = 180306, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_measurements", transliteration = "lakhats dam",
            original = "לַחַץ דָּם", translation = "артериальное давление",
            definition = "הַכֹּחַ שֶׁבּוֹ הַנּוֹזֵל בַּגּוּף לוֹחֵץ עַל דְּפָנוֹת הַצִּינּוֹרוֹת הַפְּנִימִיִּים.",
            definitionNative = "Сила, с которой жидкость в теле давит на стенки внутренних трубок.",
            example = "הָאָחוֹת מָדְדָה לִי לַחַץ דָּם לִפְנֵי הַכְּנִיסָה לָרוֹפֵא.",
            exampleNative = "Медсестра измерила мне לַחַץ דָּם перед входом к врачу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180307, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "doctor_measurements", transliteration = "dofek",
            original = "דֹּפֶק", translation = "пульс",
            definition = "הַפְּעִימוֹת שֶׁמַּרְגִּישִׁים בַּפֶּרֶק הַיָּד אוֹ בַּצַּוָּאר — מֵרֶמֶז עַל לֵב.",
            definitionNative = "Толчки, которые чувствуешь на запястье или шее — отголоски сердца.",
            example = "הָרוֹפֵא בָּדַק דֹּפֶק וְרָשַׁם שִׁבְעִים לְדַקָּה.",
            exampleNative = "Врач проверил דֹּפֶק и записал семьдесят в минуту.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180308, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "doctor_measurements", transliteration = "mishkal",
            original = "מִשְׁקָל", translation = "вес тела",
            definition = "כַּמָּה הָאָדָם כָּבֵד — נִמְדָּד בְּקִילוֹגְרָמִים עַל מַכְשִׁיר מְיֻחָד.",
            definitionNative = "Насколько человек тяжёлый — измеряют в килограммах на специальных весах.",
            example = "אַחַת לְשָׁנָה הָרוֹפֵא בּוֹדֵק מִשְׁקָל וְרוֹשֵׁם בַּתִּיק.",
            exampleNative = "Раз в год врач проверяет מִשְׁקָל и записывает в карту.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180309, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "doctor_measurements", transliteration = "gova",
            original = "גֹּבַהּ", translation = "рост",
            definition = "הַמֶּרְחָק מֵהַרַגְלַיִם עַד הָרֹאשׁ — נִמְדָּד בְּסַנְטִימֶטְרִים בַּמִּרְפָּאָה.",
            definitionNative = "Расстояние от ног до макушки — измеряют в сантиметрах в клинике.",
            example = "הָאָחוֹת רָשְׁמָה גֹּבַהּ מֵאָה וְשִׁבְעִים בַּתִּיק הָרְפוּאִי.",
            exampleNative = "Медсестра записала גֹּבַהּ сто семьдесят в медкарту.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180310, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_measurements", transliteration = "medidat khom",
            original = "מְדִידַת חוֹם", translation = "измерение температуры",
            definition = "בְּדִיקָה בְּמַד־חֹם כַּמָּה הַגּוּף חַם — מַרְאָה אִם יֵשׁ דַּלֶּקֶת.",
            definitionNative = "Проверка градусником, насколько тело горячее — показывает, есть ли воспаление.",
            example = "מְדִידַת חוֹם בַּכְּנִיסָה לַמִּרְפָּאָה הִיא חוֹבָה לְכֻלָּם.",
            exampleNative = "מְדִידַת חוֹם при входе в клинику обязательна для всех.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_simple_procedures (5) — осмотры и пальпация ──
        WordEntity(
            id = 180311, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_simple_procedures", transliteration = "bdika klalit",
            original = "בְּדִיקָה כְּלָלִית", translation = "общий осмотр",
            definition = "סְקִירָה שִׁגְרָתִית שֶׁל כָּל הַגּוּף — בְּלִי הִתְמַקְּדוּת בְּתְלוּנָה אַחַת.",
            definitionNative = "Рутинный осмотр всего тела — без фокуса на одной жалобе.",
            example = "אַחַת לְשָׁנָה אֲנִי הוֹלֵךְ לִבְּדִיקָה כְּלָלִית אֵצֶל הָרוֹפֵא.",
            exampleNative = "Раз в год я хожу на בְּדִיקָה כְּלָלִית к врачу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180312, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_simple_procedures", transliteration = "akshava la-lev",
            original = "הַקְשָׁבָה לַלֵּב", translation = "выслушивание сердца",
            definition = "הָרוֹפֵא מַצְמִיד מַכְשִׁיר לֶחָזֶה — שׁוֹמֵעַ אֶת הַפְּעִימוֹת וְקוֹלוֹת פְּנִימִיִּים.",
            definitionNative = "Врач прикладывает прибор к груди — слышит толчки и внутренние шумы.",
            example = "אַחֲרֵי הַקְשָׁבָה לַלֵּב הָרוֹפֵא אָמַר שֶׁהַכֹּל תָּקִין.",
            exampleNative = "После הַקְשָׁבָה לַלֵּב врач сказал, что всё в порядке.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180313, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_simple_procedures", transliteration = "bdikat garon",
            original = "בְּדִיקַת גָּרוֹן", translation = "осмотр горла",
            definition = "הָרוֹפֵא מַבִּיט עִם פָּנָס וּמַקֵּל עֵץ — מְחַפֵּשׂ אֹדֶם אוֹ פֶּצַע פְּנִימִי.",
            definitionNative = "Врач смотрит фонариком и деревянной палочкой — ищет красноту или ранку.",
            example = "אַחֲרֵי בְּדִיקַת גָּרוֹן הִתְבָּרֵר שֶׁיֵּשׁ דַּלֶּקֶת חַזָּקָה.",
            exampleNative = "После בְּדִיקַת גָּרוֹן выяснилось, что воспаление сильное.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180314, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_simple_procedures", transliteration = "bdikat ozen",
            original = "בְּדִיקַת אֹזֶן", translation = "осмотр уха",
            definition = "הָרוֹפֵא מַכְנִיס מַכְשִׁיר עִם אוֹר וּמַבִּיט פְּנִימָה — מְחַפֵּשׂ נוֹזֵל אוֹ דַּלֶּקֶת.",
            definitionNative = "Врач вставляет прибор с лампочкой — ищет жидкость или воспаление внутри.",
            example = "הַיֶּלֶד בָּכָה בְּמַהֲלָךְ בְּדִיקַת אֹזֶן בְּאֶצְלוֹ דַּלֶּקֶת.",
            exampleNative = "Ребёнок плакал во время בְּדִיקַת אֹזֶן — у него воспаление.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180315, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_simple_procedures", transliteration = "mishush beten",
            original = "מִישּׁוּשׁ בֶּטֶן", translation = "пальпация живота",
            definition = "הָרוֹפֵא לוֹחֵץ בַּיָּדַיִם עַל הַבֶּטֶן — מַרְגִּישׁ אֵיפֹה כּוֹאֵב אוֹ נִמְתָּח.",
            definitionNative = "Врач надавливает руками на живот — нащупывает, где больно или напряжено.",
            example = "מִישּׁוּשׁ בֶּטֶן זִיהָה לָרוֹפֵא נְקֻדָּה רְגִישָׁה בַּצַּד הַיְמָנִי.",
            exampleNative = "מִישּׁוּשׁ בֶּטֶן помогло врачу найти чувствительную точку справа.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_history (5) — анамнез: фон, аллергии, операции, семья, лекарства ──
        WordEntity(
            id = 180316, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_history", transliteration = "reka refui",
            original = "רֶקַע רְפוּאִי", translation = "медицинский анамнез",
            definition = "סִפּוּר הַמַּחֲלוֹת שֶׁל הָאָדָם בֶּעָבָר — מַה שֶּׁעוֹזֵר לְהַחֲלִיט עַל טִיפּוּל.",
            definitionNative = "История прошлых болезней человека — помогает решить, как лечить сейчас.",
            example = "הָרוֹפֵא בִּקֵּשׁ לְפָרֵט רֶקַע רְפוּאִי לִפְנֵי הַנִּתּוּחַ.",
            exampleNative = "Врач попросил рассказать רֶקַע רְפוּאִי перед операцией.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180317, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "doctor_history", transliteration = "alergiyot",
            original = "אֲלֶרְגְיוֹת", translation = "аллергии",
            definition = "תְּגוּבוֹת חֲרִיפוֹת שֶׁל הַגּוּף לְאֹכֶל, תְּרוּפָה אוֹ אָבָק — כְּמוֹ פְּרִיחָה.",
            definitionNative = "Резкие реакции тела на еду, лекарство или пыль — например, сыпь.",
            example = "צִיַּיְנְתִּי בַּטֹּפֶס אֲלֶרְגְיוֹת לִתְרוּפַת אַנְטִיבְּיוֹטִיקָה.",
            exampleNative = "Я указал в анкете אֲלֶרְגְיוֹת на антибиотики.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180318, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_history", transliteration = "nitukhim kodmim",
            original = "נִתּוּחִים קוֹדְמִים", translation = "перенесённые операции",
            definition = "כָּל הַפְּעֻלּוֹת הַכִּירוּרְגִיּוֹת בֶּעָבָר — חֲשׁוּב לְהַחֲלָטָה עַל טִיפּוּל.",
            definitionNative = "Все прошлые хирургические вмешательства — важно для решения о лечении.",
            example = "בַּטֹּפֶס פֵּרַטְתִּי נִתּוּחִים קוֹדְמִים בְּעֶשֶׂר הַשָּׁנִים.",
            exampleNative = "В анкете я перечислил נִתּוּחִים קוֹדְמִים за десять лет.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180319, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_history", transliteration = "makhalot mishpakha",
            original = "מַחֲלוֹת מִשְׁפָּחָה", translation = "семейные заболевания",
            definition = "מַחֲלוֹת שֶׁעוֹבְרוֹת בַּגֵּנִים — לְמָשָׁל מֵהוֹרִים אוֹ מִסַּבָּא לַנֶּכֶד.",
            definitionNative = "Болезни, которые передаются по генам — например, от родителей или от деда внуку.",
            example = "מַחֲלוֹת מִשְׁפָּחָה כּוֹלְלוֹת אֵצְלֵנוּ סוּכֶּרֶת וּמַחֲלוֹת לֵב.",
            exampleNative = "מַחֲלוֹת מִשְׁפָּחָה у нас включают диабет и сердечные болезни.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180320, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_history", transliteration = "trufot kvuot",
            original = "תְּרוּפוֹת קְבוּעוֹת", translation = "постоянные лекарства",
            definition = "תַּכְשִׁירִים שֶׁאָדָם לוֹקֵחַ כָּל יוֹם בְּלִי הַפְסָקָה — בִּגְלַל מַחֲלָה כְּרוֹנִית.",
            definitionNative = "Препараты, которые человек принимает каждый день без перерыва — из-за хронической болезни.",
            example = "סַבָּא לוֹקֵחַ תְּרוּפוֹת קְבוּעוֹת לְלַחַץ דָּם וּלְכוֹלֶסְטֶרוֹל.",
            exampleNative = "Дед принимает תְּרוּפוֹת קְבוּעוֹת от давления и холестерина.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_referrals (5) — направления, эпикриз, освобождение, справки ──
        WordEntity(
            id = 180321, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_referrals", transliteration = "afnaya le-mumkhe",
            original = "הַפְנָיָה לְמוּמְחֶה", translation = "направление к специалисту",
            definition = "מִכְתָּב מֵהָרוֹפֵא הַמִּשְׁפַּחְתִּי — מַתִּיר פְּגִישָׁה אֵצֶל רוֹפֵא צָר תְּחוּם.",
            definitionNative = "Письмо от семейного врача — даёт право на встречу с узким специалистом.",
            example = "קִבַּלְתִּי הַפְנָיָה לְמוּמְחֶה בָּעוֹר בִּגְלַל פְּרִיחָה מוּזָרָה.",
            exampleNative = "Получил הַפְנָיָה לְמוּמְחֶה по коже из-за странной сыпи.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180322, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_referrals", transliteration = "mikhtav akhlama",
            original = "מִכְתָּב הַחְלָמָה", translation = "выписной эпикриз",
            definition = "מִסְמָךְ שֶׁל בֵּית הַחוֹלִים בְּסוֹף הָאִשְׁפּוּז — מְסַכֵּם מָה הָיָה וּמָה לַעֲשׂוֹת.",
            definitionNative = "Документ из больницы в конце госпитализации — итог: что было и что делать дальше.",
            example = "הָבֵא מִכְתָּב הַחְלָמָה לָרוֹפֵא הַמִּשְׁפַּחְתִּי אַחֲרֵי הַשִּׁחְרוּר.",
            exampleNative = "Принеси מִכְתָּב הַחְלָמָה семейному врачу после выписки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180323, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_referrals", transliteration = "ptor kholim",
            original = "פְּטוֹר חוֹלִים", translation = "освобождение по болезни",
            definition = "אִישׁוּר רִשְׁמִי שֶׁפּוֹטֵר אָדָם מִלִּמּוּדִים אוֹ מְשִׂימוֹת בִּגְלַל מַצָּבוֹ.",
            definitionNative = "Официальная справка — освобождает от учёбы или заданий из-за состояния.",
            example = "הַתַּלְמִידָה הֵבִיאָה פְּטוֹר חוֹלִים לְשִׁעוּר הַסְּפּוֹרְט.",
            exampleNative = "Школьница принесла פְּטוֹר חוֹלִים для урока физкультуры.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180324, setId = 1803, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_referrals", transliteration = "ishur avoda",
            original = "אִישּׁוּר עֲבוֹדָה", translation = "справка для работы",
            definition = "מִסְמָךְ מִן הָרוֹפֵא — מַסְבִּיר לַמַּעֲסִיק לָמָּה הָעוֹבֵד נֶעְדָּר.",
            definitionNative = "Документ от врача — объясняет работодателю, почему сотрудник не явился.",
            example = "הַמַּעֲבִיד דָּרַשׁ אִישּׁוּר עֲבוֹדָה לְכָל יוֹם הֵיעָדְרוּת.",
            exampleNative = "Работодатель потребовал אִישּׁוּר עֲבוֹדָה за каждый день отсутствия.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180325, setId = 1803, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "doctor_referrals", transliteration = "ishur nesia",
            original = "אִישּׁוּר נְסִיעָה", translation = "справка для путешествия",
            definition = "מִסְמָךְ רְפוּאִי הַמַּתִּיר טִיסָה אוֹ נְסִיעָה אֲרֻכָּה בְּגִין מַצָּב בְּרִיאוּתִי.",
            definitionNative = "Медицинский документ — разрешает полёт или долгую поездку при состоянии здоровья.",
            example = "לִפְנֵי הַטִּיסָה לְרוּסְיָה בִּקְשׁוּ אִישּׁוּר נְסִיעָה מֵהָרוֹפֵא.",
            exampleNative = "Перед полётом в Россию попросили אִישּׁוּר נְסִיעָה от врача.",
            isFillInBlankSafe = false,
        ),
    )
}
