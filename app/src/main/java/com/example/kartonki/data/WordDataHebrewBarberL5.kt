package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — Салон красоты и работа парикмахером, level 5 (носитель языка).
 *
 * Set:
 *   - 1799 (L5, EPIC + LEGENDARY) — управленческая, имиджевая и
 *     индустриальная лексика топ-парикмахера: бизнес салона, фэшн-индустрия,
 *     наставничество, личный бренд, гигиена и безопасность.
 *
 * Подтемы (5 × 5):
 *   barber_business         — администрирование, бронирование, оборот, прибыль, лицензия
 *   barber_fashion          — модный показ, fashion week, эстетика, редакторская стрижка, фэшн-команда
 *   barber_training_advanced — мастер-класс, наставничество, ассистент, освоение техники, портфолио
 *   barber_culture_brand    — личный бренд, контент, презентация работы, признание, имидж салона
 *   barber_health_safety    — гигиена, аллергическая реакция, тест чувствительности, дезинфекция, защита кожи
 *
 * Word IDs: 179901..179925 (setId * 100 + position).
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewBarberL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1799, languagePair = "he-ru", orderIndex = 1799,
            name = "Салон красоты и работа парикмахером",
            description = "Управление салоном: бизнес, мода, тренинг, культура, образ профессии",
            topic = "Салон красоты и работа парикмахером", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1799 — L5, EPIC + LEGENDARY
        // ══════════════════════════════════════════════════════════════════════

        // ── barber_business (5) ───────────────────────────────────────────────
        WordEntity(
            id = 179901, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_business", transliteration = "менаѓель салон",
            original = "מְנַהֵל סָלוֹן", translation = "администратор салона",
            definition = "אִישׁ הָעוֹמֵד עַל הַתִּפְעוּל הַיּוֹמְיוֹמִי שֶׁל הַמָּקוֹם וְהָעוֹבְדִים.",
            definitionNative = "Тот, кто отвечает за ежедневную работу заведения и команду.",
            example = "מְנַהֵל סָלוֹן טוֹב חוֹסֵךְ זְמַן לְכָל הַצֶּוֶת.",
            exampleNative = "Хороший מְנַהֵל סָלוֹן экономит время всей команде.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179902, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_business", transliteration = "ѓазмана мэрош",
            original = "הַזְמָנָה מֵרָאשׁ", translation = "предварительное бронирование",
            definition = "סִידּוּר תּוֹר לִפְנֵי הַגָּעָה — בִּטְלֵפוֹן, בְּאַפְּלִיקַצְיָה אוֹ בָּאֲתָר.",
            definitionNative = "Запись клиента до прихода — по телефону, в приложении или на сайте.",
            example = "בְּלִי הַזְמָנָה מֵרָאשׁ קָשֶׁה לִקְבּוֹעַ פְּגִישָׁה בְּשַׁבָּת.",
            exampleNative = "Без הַזְמָנָה מֵרָאשׁ трудно попасть к мастеру в субботу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179903, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_business", transliteration = "махзор каспи",
            original = "מַחְזוֹר כַּסְפִּי", translation = "денежный оборот",
            definition = "סְכוּם כָּל הַהַכְנָסוֹת שֶׁעָבְרוּ דֶּרֶךְ הָעֵסֶק בְּפֶרֶק זְמַן.",
            definitionNative = "Сумма всех поступлений в заведении за определённый период времени.",
            example = "מַחְזוֹר כַּסְפִּי בְּדֶצֶמְבֶּר תָּמִיד גָּבוֹהַּ מִשְּׁאָר הַשָּׁנָה.",
            exampleNative = "מַחְזוֹר כַּסְפִּי в декабре всегда выше, чем в остальные месяцы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179904, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_business", transliteration = "ахуз рэвах",
            original = "אֲחוּז רֶוַח", translation = "доля прибыли",
            definition = "הַחֵלֶק שֶׁמַּגִּיעַ לַמַּסְפֵּר מִכָּל פְּעוּלָה אַחֲרֵי נִכּוּי הוֹצָאוֹת.",
            definitionNative = "Часть от каждой услуги, которую получает мастер после вычета расходов.",
            example = "הַסַּפָּר חָתַם עַל אֲחוּז רֶוַח שֶׁל אַרְבָּעִים מִן הַטִּפּוּל.",
            exampleNative = "Мастер подписал на אֲחוּז רֶוַח сорок процентов от процедуры.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179905, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_business", transliteration = "ришьон эсек",
            original = "רִשְׁיוֹן עֵסֶק", translation = "лицензия на деятельность",
            definition = "אִישּׁוּר רִשְׁמִי מֵהָעִירִיָּה לְהַפְעָלַת הַמָּקוֹם בְּאוֹפֶן חֻקִּי.",
            definitionNative = "Официальное разрешение от муниципалитета на законную работу заведения.",
            example = "בְּלִי רִשְׁיוֹן עֵסֶק הַמָּקוֹם נִסְגָּר עַל יְדֵי הַפַּקָּחִים.",
            exampleNative = "Без רִשְׁיוֹן עֵסֶק заведение закрывают инспекторы.",
            isFillInBlankSafe = false,
        ),

        // ── barber_fashion (5) ────────────────────────────────────────────────
        WordEntity(
            id = 179906, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_fashion", transliteration = "тацугат офна",
            original = "תַּצְוּגַת אוֹפְנָה", translation = "модный показ",
            definition = "אֵירוּעַ בּוֹ דֻּגְמָנִיּוֹת מַצִּיגוֹת בְּגָדִים וּמַרְאוֹת חֲדָשִׁים עַל בָּמָה.",
            definitionNative = "Мероприятие, где на сцене демонстрируют новые наряды и образы.",
            example = "הִיא עִצְּבָה תִּסְפֹּרוֹת לְכָל הַדֻּגְמָנִיּוֹת בַּתַּצְוּגַת אוֹפְנָה.",
            exampleNative = "Она оформила причёски всем моделям на תַּצְוּגַת אוֹפְנָה.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179907, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_fashion", transliteration = "фэшн вик",
            original = "פֶשֶׁן וִיק", translation = "fashion week, неделя моды",
            definition = "סִדְרָה שֶׁל אֵירוּעֵי הַשָּׁקָה בְּעִיר אַחַת בְּמֶשֶׁךְ שִׁבְעָה יָמִים.",
            definitionNative = "Серия показов и презентаций в одном городе на протяжении семи дней.",
            example = "צֶוֶת הַסָּלוֹן טָס לְמִילָאנוֹ בִּשְׁבִיל פֶשֶׁן וִיק.",
            exampleNative = "Команда салона летит в Милан ради פֶשֶׁן וִיק.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179908, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_fashion", transliteration = "signon ishi",
            original = "סִגְנוֹן אִישִׁי", translation = "личный стиль (визитка мастера)",
            definition = "קַו אָמָנוּתִי יִחוּדִי שֶׁמַּזְהֶה אֶת הָעֲבוֹדָה שֶׁל מַסְפְּרָה מְסֻיֶּמֶת.",
            definitionNative = "Уникальный художественный почерк — по нему узнают работу конкретного мастера.",
            example = "הַסִּגְנוֹן הָאִישִׁי שֶׁלּוֹ זוֹהֵר בָּעַרְפֵל הַתִּסְפֹּרֶת הַסְּפָרָדִית.",
            exampleNative = "Его סִגְנוֹן אִישִׁי сияет в дымке испанской стрижки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179909, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_fashion", transliteration = "тиспорет маарахтит",
            original = "תִּסְפֹּרֶת מַעֲרַכְתִּית", translation = "редакторская стрижка",
            definition = "מַרְאֶה אַוַנְגַּרְדִּי שֶׁנִּבְנֶה לְצִילּוּם בְּמַגָּזִין, לֹא לִיוֹמְיוֹם.",
            definitionNative = "Авангардный образ, созданный для журнальной съёмки, а не для будней.",
            example = "תִּסְפֹּרֶת מַעֲרַכְתִּית כָּזֹאת לֹא תַּחְזִיק אֲפִלּוּ יוֹם בָּרְחוֹב.",
            exampleNative = "Такая תִּסְפֹּרֶת מַעֲרַכְתִּית не продержится и дня в обычной жизни.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179910, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_fashion", transliteration = "цэвет йоцэр",
            original = "צֶוֶת יוֹצֵר", translation = "креативная команда",
            definition = "קְבוּצַת מֻמְחִים שֶׁבּוֹנָה רַעְיוֹן חָזוּתִי שָׁלֵם לִתְמוּנָה אוֹ אֵירוּעַ.",
            definitionNative = "Группа специалистов, выстраивающая цельный визуальный замысел съёмки или шоу.",
            example = "הַצֶּוֶת יוֹצֵר חָשַׁב עַל כָּל פְּרַט בַּקַמְפַּיְן הֶחָדָשׁ.",
            exampleNative = "צֶוֶת יוֹצֵר продумал каждую деталь новой кампании.",
            isFillInBlankSafe = false,
        ),

        // ── barber_training_advanced (5) ──────────────────────────────────────
        WordEntity(
            id = 179911, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_training_advanced", transliteration = "садна",
            original = "סָדְנָה", translation = "воркшоп, практический семинар",
            definition = "מִפְגָּשׁ קָצָר וְמַעֲשִׂי בּוֹ לוֹמְדִים שִׁיטָה אַחַת תַּחַת מַדְרִיךְ.",
            definitionNative = "Короткая практическая встреча, где осваивают одну методику под руководством.",
            example = "נִרְשַׁמְתִּי לְסָדְנָה שֶׁל יוֹמַיִם בְּתֵל אָבִיב.",
            exampleNative = "Я записалась на двухдневный סָדְנָה в Тель-Авиве.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179912, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_training_advanced", transliteration = "ханиха",
            original = "חֲנִיכָה", translation = "наставничество",
            definition = "לִיוּוּי אִישִׁי שֶׁבּוֹ מִקְצוֹעָן וָתִיק מַעֲבִיר יֶדַע לְמִי שֶׁמַּתְחִיל.",
            definitionNative = "Личное сопровождение, где опытный профессионал передаёт знания новичку.",
            example = "חֲנִיכָה שֶׁל שְׁנָתַיִם נָתְנָה לָהּ בִּטָּחוֹן מִקְצוֹעִי.",
            exampleNative = "Двухлетняя חֲנִיכָה дала ей профессиональную уверенность.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179913, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_training_advanced", transliteration = "митмахэ",
            original = "מַתְמַחֶה", translation = "стажёр-ассистент",
            definition = "מִי שֶׁעוֹבֵד לְצַד מַסְפֵּר וָתִיק כְּדֵי לִרְכּוֹשׁ נִסָּיוֹן בְּשָׂדֶה.",
            definitionNative = "Тот, кто работает рядом с опытным мастером, чтобы получить практику в деле.",
            example = "הַמַּתְמַחֶה הֶחָדָשׁ שׁוֹטֵף וְעוֹזֵר בִּכְלֵי הָעֲבוֹדָה.",
            exampleNative = "Новый מַתְמַחֶה моет и помогает с инвентарём.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179914, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_training_advanced", transliteration = "ѓатмаат техника",
            original = "הַטְמָעַת טֶכְנִיקָה", translation = "освоение новой техники",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ שִׁיטָה חֲדָשָׁה הוֹפֶכֶת לְחֵלֶק טִבְעִי מִן הָעֲבוֹדָה.",
            definitionNative = "Процесс, в котором новый метод становится естественной частью работы.",
            example = "הַטְמָעַת טֶכְנִיקָה צְרִיכָה לְפָחוֹת חוֹדֶשׁ שֶׁל אִמּוּן יוֹמְיוֹמִי.",
            exampleNative = "הַטְמָעַת טֶכְנִיקָה требует не меньше месяца ежедневной практики.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179915, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_training_advanced", transliteration = "альбом аводот",
            original = "אַלְבּוֹם עֲבוֹדוֹת", translation = "альбом работ, портфолио мастера",
            definition = "אֹסֶף תְּמוּנוֹת מְעוּקָב שֶׁמַּצִּיג אֶת הַמַּהֲלָךְ הַמִּקְצוֹעִי לְאוֹרֶךְ זְמַן.",
            definitionNative = "Подобранная коллекция фото, показывающая профессиональный рост со временем.",
            example = "אַלְבּוֹם עֲבוֹדוֹת מְסֻדָּר עוֹזֵר לְהַשִּׂיג לָקוֹחוֹת שֶׁל יֻקְרָה.",
            exampleNative = "Аккуратный אַלְבּוֹם עֲבוֹדוֹת помогает привлекать премиальных клиентов.",
            isFillInBlankSafe = false,
        ),

        // ── barber_culture_brand (5) ──────────────────────────────────────────
        WordEntity(
            id = 179916, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_culture_brand", transliteration = "мутаг иши",
            original = "מוּתָג אִישִׁי", translation = "личный бренд",
            definition = "הַזֶּהוּת הָעַצְמָאִית שֶׁבּוֹנֶה בַּעַל הַמִּקְצוֹעַ סְבִיב הַשֵּׁם שֶׁלּוֹ.",
            definitionNative = "Самостоятельная репутация, которую профессионал выстраивает вокруг своего имени.",
            example = "מוּתָג אִישִׁי חָזָק שׁוֹוֶה יוֹתֵר מִכָּל פִּרְסֹמֶת.",
            exampleNative = "Сильный מוּתָג אִישִׁי стоит дороже любой рекламы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179917, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_culture_brand", transliteration = "тохэн рэшэт",
            original = "תֹּכֶן רֶשֶׁת", translation = "контент в соцсетях",
            definition = "כָּל מַה שֶּׁמִּתְפַּרְסֵם לְמַעַקַב — תְּמוּנוֹת, סְרָטוֹנִים וּפוֹסְטִים.",
            definitionNative = "Всё, что публикуется для подписчиков — фото, ролики и посты.",
            example = "תֹּכֶן רֶשֶׁת אֵיכוּתִי מֵבִיא לָקוֹחוֹת בְּלִי הוֹצָאָה גְּדוֹלָה.",
            exampleNative = "Качественный תֹּכֶן רֶשֶׁת приводит клиентов без больших трат.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179918, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_culture_brand", transliteration = "ѓадгама микцоит",
            original = "הַדְגָּמָה מִקְצוֹעִית", translation = "профессиональная презентация работы",
            definition = "מָסַד שֶׁבּוֹ בַּעַל הַמִּקְצוֹעַ מַרְאֶה אֵיךְ הוּא מַשִּׂיג תּוֹצָאָה.",
            definitionNative = "Формат, в котором мастер показывает, как он добивается результата.",
            example = "הַהַדְגָּמָה הַמִּקְצוֹעִית בַּכֶּנֶס מָשְׁכָה אֲלָפִים שֶׁל צוֹפִים.",
            exampleNative = "הַדְגָּמָה מִקְצוֹעִית на конференции собрала тысячи зрителей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179919, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_culture_brand", transliteration = "ѓокара цибурит",
            original = "הוֹקָרָה צִבּוּרִית", translation = "общественное признание",
            definition = "כָּבוֹד שֶׁמַּעֲנִיקָה קְבוּצָה רְחָבָה לְמִי שֶׁתָּרַם לַתְּחוּם.",
            definitionNative = "Уважение, которое широкая аудитория оказывает тому, кто внёс вклад в дело.",
            example = "אַחֲרֵי שְׁלוֹשִׁים שָׁנָה הוּא זָכָה בְּהוֹקָרָה צִבּוּרִית בְּטֶקֶס מְפוּאָר.",
            exampleNative = "Через тридцать лет он удостоился הוֹקָרָה צִבּוּרִית на торжественной церемонии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179920, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_culture_brand", transliteration = "тадмит салон",
            original = "תַּדְמִית סָלוֹן", translation = "имидж салона",
            definition = "הַדֶּרֶךְ שֶׁבָּהּ הַצִּבּוּר תּוֹפֵס אֶת הַמָּקוֹם וְאֶת הָרָמָה שֶׁלּוֹ.",
            definitionNative = "То, как публика воспринимает заведение и его уровень.",
            example = "תַּדְמִית סָלוֹן נִבְנֵית בִּשְׁנִים וְנֶהֱרֶסֶת בְּשָׁבוּעַ.",
            exampleNative = "תַּדְמִית סָלוֹן строится годами и рушится за неделю.",
            isFillInBlankSafe = false,
        ),

        // ── barber_health_safety (5) ──────────────────────────────────────────
        WordEntity(
            id = 179921, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barber_health_safety", transliteration = "ѓигьена",
            original = "הִיגְיֶנָה", translation = "гигиена",
            definition = "כְּלָלֵי נִקָּיוֹן שֶׁשּׁוֹמְרִים עַל בְּרִיאוּת הַלָּקוֹחַ וְהַצֶּוֶת.",
            definitionNative = "Правила чистоты, оберегающие здоровье клиента и команды.",
            example = "הִיגְיֶנָה לְקוּיָה מוֹרִידָה אֶת הַסָּלוֹן בְּדֵרוּג הַפִּקּוּחַ.",
            exampleNative = "Плохая הִיגְיֶנָה снижает оценку салона при инспекции.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179922, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "barber_health_safety", transliteration = "тгува алергит",
            original = "תְּגוּבָה אַלֶרְגִית", translation = "аллергическая реакция",
            definition = "תְּשׁוּבַת הַגּוּף לְחֹמֶר זָר שֶׁמּוֹפִיעָה כְּגֵרוּי, אֲדִימוּת אוֹ נְפִיחוּת.",
            definitionNative = "Ответ организма на чуждое вещество, проявляющийся зудом, краснотой или отёком.",
            example = "תְּגוּבָה אַלֶרְגִית קָשָׁה לְצֶבַע מַחְיֶיבֶת קְרִיאָה לְמוֹקֵד.",
            exampleNative = "Сильная תְּגוּבָה אַלֶרְגִית на краску требует звонка в скорую.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179923, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_health_safety", transliteration = "мивхан регишут",
            original = "מִבְחַן רְגִישׁוּת", translation = "тест на чувствительность",
            definition = "טִפְטוּף קָטָן שֶׁל חוֹמֶר עַל הָעוֹר אַרְבָּעִים שָׁעוֹת לִפְנֵי הַטִּפּוּל.",
            definitionNative = "Капля состава на коже за двое суток до основной процедуры.",
            example = "כָּל קוֹלוֹרִיסְטִית מִקְצוֹעִית מְבַקֶּשֶׁת מִבְחַן רְגִישׁוּת מֵרָאשׁ.",
            exampleNative = "Любой профессиональный колорист просит מִבְחַן רְגִישׁוּת заранее.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179924, setId = 1799, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "barber_health_safety", transliteration = "хитуй",
            original = "חִטּוּי", translation = "дезинфекция",
            definition = "טִפּוּל בְּחֹמֶר חָזָק שֶׁמּוֹרִיד חַיְדַּקִּים מִן הַכֵּלִים אַחֲרֵי לָקוֹחַ.",
            definitionNative = "Обработка сильным средством, убирающая микробы с инструментов после клиента.",
            example = "חִטּוּי מָלֵא שֶׁל הַמִּסְפָּרַיִים מִתְבַּצֵּעַ לְאַחַר כָּל לָקוֹחַ.",
            exampleNative = "Полный חִטּוּי ножниц проводят после каждого клиента.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179925, setId = 1799, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barber_health_safety", transliteration = "маген ор",
            original = "מָגֵן עוֹר", translation = "защита для кожи",
            definition = "מוּצָר שֶׁמַּפְרִיד בֵּין הַחוֹמֶר הָאַגְרֶסִיבִי לַפָּנִים אוֹ הַיָּדַיִם.",
            definitionNative = "Средство, отделяющее агрессивный состав от лица или рук.",
            example = "הַסַּפָּר מוֹרֵחַ מָגֵן עוֹר לִפְנֵי כָּל צְבִיעָה.",
            exampleNative = "Мастер наносит מָגֵן עוֹר перед каждым окрашиванием.",
            isFillInBlankSafe = false,
        ),
    )
}
