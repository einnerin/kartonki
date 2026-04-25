package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Автомобиль (he-ru), 2 PARTIAL sets (levels 1 and 4).
 *
 * Set 1712 (level 1, 15 COMMON + 10 UNCOMMON):
 *   основы — части машины, базовая лексика водителя.
 *   6 групп: actions, signals, interior, exterior, climate, controls.
 *
 * Set 1713 (level 4, 10 EPIC + 15 LEGENDARY):
 *   профессиональный — диагностика, ремонт, специализированные узлы.
 *   5 групп: engine_internals, cooling, fuel_oil_exhaust, brakes_chassis, sensors_meters.
 *
 * Не пересекается со словами из существующих сетов темы «Автомобиль»:
 * 1178 (Immigrant12 — UNCOMMON), 1379 (Batch64 L2 — UNCOMMON+RARE),
 * 1380 (Batch65 L3 — RARE+EPIC), 1381 (Batch65 L5 — EPIC+LEGENDARY),
 * 1382 (Batch65 L5 — LEGENDARY).
 */
object WordDataHebrewAutomobilePartial {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1712, languagePair = "he-ru", orderIndex = 1712,
            name = "Автомобиль",
            description = "Управление машиной: салон, кузов, базовые приборы и сигналы",
            topic = "Автомобиль", level = 1,
        ),
        WordSetEntity(
            id = 1713, languagePair = "he-ru", orderIndex = 1713,
            name = "Автомобиль",
            description = "Диагностика, ремонт, узлы двигателя и тормозной системы",
            topic = "Автомобиль", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1712 — Автомобиль: основы (level=1, COMMON + UNCOMMON)
        // 6 групп: driving_actions, signals_alerts, interior_seats,
        //          body_exterior, climate, dashboard_controls
        // ══════════════════════════════════════════════════════════════════════

        // ── auto_driving_actions (5) — глаголы вождения ──
        WordEntity(
            id = 171201, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "auto_driving_actions", transliteration = "letadlek",
            original = "לְתַדְלֵק", translation = "заправлять",
            definition = "למלא את מיכל הרכב בבנזין או סולר בתחנה.",
            definitionNative = "Залить горючее в бак на станции — обычно бензин или дизель.",
            example = "אני צריך לְתַדְלֵק את הרכב לפני הנסיעה.",
            exampleNative = "Мне надо לְתַדְלֵק машину перед дальней поездкой.",
         fillInBlankExclusions = listOf(171202L, 171203L, 171204L, 171205L)),
        WordEntity(
            id = 171202, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "auto_driving_actions", transliteration = "linsoa",
            original = "לִנְסֹעַ", translation = "ехать",
            definition = "להתקדם בכלי תחבורה ממקום אחד למקום אחר.",
            definitionNative = "Перемещаться на машине, поезде или автобусе от точки до точки.",
            example = "החלטנו לִנְסֹעַ לים בשבת בבוקר.",
            exampleNative = "Мы решили לִנְסֹעַ к морю в субботу утром.",
        ),
        WordEntity(
            id = 171203, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "auto_driving_actions", transliteration = "leha'et",
            original = "לְהָאֵט", translation = "замедляться",
            definition = "להפחית מהירות לפני סיבוב, אור אדום או מכשול בכביש.",
            definitionNative = "Уменьшать скорость — перед поворотом, светофором или препятствием.",
            example = "צריך לְהָאֵט בכניסה לכפר.",
            exampleNative = "Надо לְהָאֵט при въезде в деревню.",
         fillInBlankExclusions = listOf(171201L, 171202L, 171204L, 171205L)),
        WordEntity(
            id = 171204, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "auto_driving_actions", transliteration = "lehakhnot",
            original = "לְהַחְנוֹת", translation = "парковать",
            definition = "להעמיד את הרכב במקום מוגדר וכבוי לזמן מה.",
            definitionNative = "Оставить машину в выделенном месте с заглушённым мотором.",
            example = "קשה לְהַחְנוֹת ליד השוק בשעות העומס.",
            exampleNative = "Трудно לְהַחְנוֹת возле рынка в часы пик.",
         fillInBlankExclusions = listOf(171201L, 171202L, 171203L, 171205L)),
        WordEntity(
            id = 171205, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "auto_driving_actions", transliteration = "le'akef",
            original = "לְעַקֵּף", translation = "обгонять",
            definition = "לעבור רכב אחר משמאל ולחזור לנתיב לפניו.",
            definitionNative = "Объехать переднюю машину слева и вернуться в свой ряд.",
            example = "אסור לְעַקֵּף בקו לבן רצוף.",
            exampleNative = "Запрещено לְעַקֵּף через сплошную белую линию.",
         fillInBlankExclusions = listOf(171201L, 171202L, 171203L, 171204L)),

        // ── auto_signals_alerts (4) — звуковые и световые сигналы ──
        WordEntity(
            id = 171206, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "auto_signals_alerts", transliteration = "tsofar",
            original = "צוֹפָר", translation = "клаксон",
            definition = "התקן קולני שלוחצים עליו כדי להזהיר נהג אחר.",
            definitionNative = "Громкое устройство на руле, которое подаёт предупреждающий звук.",
            example = "הוא לחץ על הצוֹפָר באגרסיביות.",
            exampleNative = "Он раздражённо ударил по צוֹפָר в пробке.",
        ),
        WordEntity(
            id = 171207, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "auto_signals_alerts", transliteration = "itut",
            original = "אִתּוּת", translation = "поворотник",
            definition = "אור צהוב מהבהב המראה לאיזה כיוון הנהג עומד לפנות.",
            definitionNative = "Мигающий жёлтый огонь, который показывает направление поворота.",
            example = "תמיד צריך אִתּוּת לפני שינוי נתיב.",
            exampleNative = "Перед сменой полосы всегда нужен אִתּוּת.",
         fillInBlankExclusions = listOf(171206L, 171209L)),
        WordEntity(
            id = 171208, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_signals_alerts", transliteration = "az'akat rekhev",
            original = "אַזְעָקַת רֶכֶב", translation = "автосигнализация",
            definition = "מערכת קולנית שמופעלת כשמישהו מנסה לפרוץ למכונית.",
            definitionNative = "Система, которая громко срабатывает при попытке вскрыть машину.",
            example = "אַזְעָקַת רֶכֶב צרחה כל הלילה ברחוב.",
            exampleNative = "אַזְעָקַת רֶכֶב орала во дворе всю ночь.",
         fillInBlankExclusions = listOf(171209L)),
        WordEntity(
            id = 171209, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "auto_signals_alerts", transliteration = "sirena",
            original = "סִירֶנָה", translation = "сирена",
            definition = "צליל חזק וחוזר של רכב חירום הקורא לפנות מהדרך.",
            definitionNative = "Громкий повторяющийся вой машины спасателей или полиции.",
            example = "סִירֶנָה של אמבולנס שמעה את כל הרובע.",
            exampleNative = "סִירֶנָה скорой была слышна на весь квартал.",
         fillInBlankExclusions = listOf(171206L, 171207L)),

        // ── auto_interior_seats (4) — места и отсеки для людей ──
        WordEntity(
            id = 171210, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "auto_interior_seats", transliteration = "moshav nehag",
            original = "מוֹשַׁב נֶהָג", translation = "водительское сиденье",
            definition = "המקום שבו יושב מי שמוביל את הרכב, מול ההגה.",
            definitionNative = "Место за рулём, где сидит человек, ведущий машину.",
            example = "ילדים אסורים על מוֹשַׁב נֶהָג.",
            exampleNative = "Детям нельзя на מוֹשַׁב נֶהָג.",
         fillInBlankExclusions = listOf(171211L, 171212L, 171213L, 171215L)),
        WordEntity(
            id = 171211, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "auto_interior_seats", transliteration = "moshav akhori",
            original = "מוֹשָׁב אֲחוֹרִי", translation = "заднее сиденье",
            definition = "ספסל מאחור לכמה אנשים, מאחורי הכיסאות הקדמיים.",
            definitionNative = "Скамья сзади, рассчитанная на нескольких пассажиров.",
            example = "הילדים נרדמו על מוֹשָׁב אֲחוֹרִי.",
            exampleNative = "Дети уснули на מוֹשָׁב אֲחוֹרִי по дороге домой.",
         fillInBlankExclusions = listOf(171210L, 171212L, 171213L)),
        WordEntity(
            id = 171212, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_interior_seats", transliteration = "moshav yeled",
            original = "מוֹשַׁב יֶלֶד", translation = "детское автокресло",
            definition = "כיסא מיוחד עם רצועות שמחזיק תינוק או פעוט בבטחה.",
            definitionNative = "Кресло с ремнями, держащее малыша безопасно во время поездки.",
            example = "החוק מחייב מוֹשַׁב יֶלֶד עד גיל שמונה.",
            exampleNative = "Закон требует מוֹשַׁב יֶלֶד до восьми лет.",
         fillInBlankExclusions = listOf(171210L, 171211L, 171213L)),
        WordEntity(
            id = 171213, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_interior_seats", transliteration = "ta nehag",
            original = "תָּא נֶהָג", translation = "кабина водителя",
            definition = "החלל הקדמי של הרכב שבו יושב מי שמוביל אותו.",
            definitionNative = "Передний отсек, где находится тот, кто управляет машиной.",
            example = "המראה הראשית תלויה מעל תָּא נֶהָג.",
            exampleNative = "Главное зеркало висит над תָּא נֶהָג.",
         fillInBlankExclusions = listOf(171210L, 171211L, 171212L)),

        // ── auto_body_exterior (5) — кузовные элементы снаружи ──
        WordEntity(
            id = 171214, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "auto_body_exterior", transliteration = "magen ruakh",
            original = "מָגֵן רוּחַ", translation = "лобовое стекло",
            definition = "החלון הגדול מקדימה דרכו הנהג רואה את הכביש.",
            definitionNative = "Большое переднее окно, через которое водитель смотрит на дорогу.",
            example = "אבן עפה ונסדק מָגֵן רוּחַ.",
            exampleNative = "Камень ударил, и треснуло מָגֵן רוּחַ.",
        ),
        WordEntity(
            id = 171215, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "auto_body_exterior", transliteration = "gagon",
            original = "גַּגּוֹן", translation = "багажник на крыше",
            definition = "קופסה או מתלה מעל הרכב להובלת מטען נוסף.",
            definitionNative = "Короб или стойка сверху для груза, который не влез в салон.",
            example = "קשרנו את האופניים על הגַּגּוֹן.",
            exampleNative = "Велосипеды привязали наверх к גַּגּוֹן.",
        ),
        WordEntity(
            id = 171216, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "auto_body_exterior", transliteration = "galgal khilufi",
            original = "גַּלְגַּל חִילוּפִי", translation = "запасное колесо",
            definition = "צמיג נוסף שנושאים בתוך הרכב למקרה תקר בדרך.",
            definitionNative = "Дополнительная шина в багажнике на случай прокола в пути.",
            example = "תמיד יש גַּלְגַּל חִילוּפִי בתא המטען.",
            exampleNative = "В багажнике всегда лежит גַּלְגַּל חִילוּפִי на крайний случай.",
         fillInBlankExclusions = listOf(171214L, 171217L, 171218L)),
        WordEntity(
            id = 171217, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_body_exterior", transliteration = "magen bots",
            original = "מָגֵן בּוֹץ", translation = "брызговик",
            definition = "לוח גמיש מאחורי הגלגל שמונע התזת רפש על מכוניות אחרות.",
            definitionNative = "Гибкая пластина за колесом, не дающая грязи лететь на других.",
            example = "מָגֵן בּוֹץ נשבר אחרי הגשם הכבד.",
            exampleNative = "מָגֵן בּוֹץ оторвался после сильного дождя.",
         fillInBlankExclusions = listOf(171207L, 171214L, 171215L, 171216L, 171218L, 171219L, 171221L)),
        WordEntity(
            id = 171218, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_body_exterior", transliteration = "mikhse manoa",
            original = "מִכְסֵה מָנוֹעַ", translation = "капот",
            definition = "הלוח שמכסה את החלק הקדמי של הרכב מעל המנוע.",
            definitionNative = "Крышка спереди, под которой скрыт двигатель машины.",
            example = "הוא פתח את מִכְסֵה מָנוֹעַ לבדוק את השמן.",
            exampleNative = "Он открыл מִכְסֵה מָנוֹעַ, чтобы проверить уровень масла.",
        ),

        // ── auto_climate (3) — климат и вентиляция ──
        WordEntity(
            id = 171219, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "auto_climate", transliteration = "mazgan",
            original = "מַזְגָן", translation = "кондиционер",
            definition = "מערכת שמקררת את האוויר בתוך הרכב בקיץ החם.",
            definitionNative = "Прибор, охлаждающий воздух внутри машины жарким летом.",
            example = "המַזְגָן ברכב התקלקל באמצע אוגוסט.",
            exampleNative = "מַזְגָן в машине сломался прямо в середине августа.",
        ),
        WordEntity(
            id = 171220, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_climate", transliteration = "pitkhei avir",
            original = "פִּתְחֵי אֲוִיר", translation = "воздуховоды",
            definition = "החורים בלוח שמהם יוצא אוויר קר או חם פנימה.",
            definitionNative = "Отверстия в панели, откуда дует тёплый или холодный поток.",
            example = "סובבתי את פִּתְחֵי אֲוִיר לכיוון הפנים.",
            exampleNative = "Я повернул פִּתְחֵי אֲוִיר прямо в лицо.",
        ),
        WordEntity(
            id = 171221, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "auto_climate", transliteration = "ivrur",
            original = "אִוְרוּר", translation = "вентиляция",
            definition = "החלפת אוויר במכונית כדי שלא יהיה מחנק או ריח.",
            definitionNative = "Обмен воздуха в салоне, чтобы не было душно или запахов.",
            example = "אִוְרוּר טוב מונע ערפל על השמשה.",
            exampleNative = "Хороший אִוְרוּר спасает от запотевания стёкол зимой.",
         fillInBlankExclusions = listOf(171219L)),

        // ── auto_dashboard_controls (4) — приборы и педали ──
        WordEntity(
            id = 171222, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "auto_dashboard_controls", transliteration = "mad mehirut",
            original = "מַד מְהִירוּת", translation = "спидометр",
            definition = "השעון שמראה לנהג כמה קילומטרים לשעה הוא נוסע.",
            definitionNative = "Прибор, показывающий, как быстро идёт машина в данный момент.",
            example = "מַד מְהִירוּת הראה מאה ועשרים בכביש החוף.",
            exampleNative = "מַד מְהִירוּת показал сто двадцать на приморской трассе.",
         fillInBlankExclusions = listOf(171223L, 171225L)),
        WordEntity(
            id = 171223, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_dashboard_controls", transliteration = "mad delek",
            original = "מַד דֶּלֶק", translation = "указатель уровня топлива",
            definition = "הסמל בלוח שמראה כמה בנזין נשאר במיכל.",
            definitionNative = "Шкала на панели, показывающая остаток горючего в баке.",
            example = "מַד דֶּלֶק כבר על שריטה אדומה.",
            exampleNative = "מַד דֶּלֶק уже стоит на красной риске.",
         fillInBlankExclusions = listOf(171222L, 171225L)),
        WordEntity(
            id = 171224, setId = 1712, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "auto_dashboard_controls", transliteration = "davsha",
            original = "דַּוְשָׁה", translation = "педаль",
            definition = "כפתור גדול ברגל שלוחצים עליו כדי להאיץ או לבלום.",
            definitionNative = "Большая ножная кнопка для разгона или остановки машины.",
            example = "הוא לחץ על הדַּוְשָׁה עד הרצפה.",
            exampleNative = "Он вдавил דַּוְשָׁה в пол на пустом шоссе.",
        ),
        WordEntity(
            id = 171225, setId = 1712, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "auto_dashboard_controls", transliteration = "blem kherum",
            original = "בְּלֵם חֵרוּם", translation = "аварийный тормоз",
            definition = "ידית מיוחדת שמושכים בה כדי לעצור מיד במקרה של סכנה.",
            definitionNative = "Рычаг или кнопка для немедленной остановки в опасной ситуации.",
            example = "היא משכה את בְּלֵם חֵרוּם ברגע האחרון.",
            exampleNative = "Она дёрнула בְּלֵם חֵרוּם в самый последний момент.",
         fillInBlankExclusions = listOf(171222L, 171223L)),

        // ══════════════════════════════════════════════════════════════════════
        // Set 1713 — Автомобиль: профессиональный (level=4, EPIC + LEGENDARY)
        // 5 групп: engine_internals, cooling_system, fuel_oil_exhaust,
        //          brakes_chassis, sensors_meters
        // ══════════════════════════════════════════════════════════════════════

        // ── auto_engine_internals (6) — внутренние узлы двигателя ──
        WordEntity(
            id = 171301, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_engine_internals", transliteration = "atam rosh",
            original = "אַטָם רֹאשׁ", translation = "прокладка ГБЦ",
            definition = "אטם דקיק בין ראש הציליינדרים לגוש המנוע, מונע דליפת לחץ.",
            definitionNative = "Тонкий уплотнитель между головкой блока и его корпусом.",
            example = "אַטָם רֹאשׁ נשרף בגלל התחממות יתר.",
            exampleNative = "אַטָם רֹאשׁ прогорела из-за сильного перегрева.",
        ),
        WordEntity(
            id = 171302, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_engine_internals", transliteration = "taba'at bokhna",
            original = "טַבַּעַת בּוֹכְנָה", translation = "поршневое кольцо",
            definition = "חישוק דק שמקיף את הבוכנה ושומר על אטימות בתוך הציליינדר.",
            definitionNative = "Узкий обруч на поршне, удерживающий герметичность внутри цилиндра.",
            example = "טַבַּעַת בּוֹכְנָה שחוקה גורמת לעשן כחול.",
            exampleNative = "Стёртое טַבַּעַת בּוֹכְנָה вызывает синий выхлоп.",
         fillInBlankExclusions = listOf(171301L, 171303L, 171304L, 171305L)),
        WordEntity(
            id = 171303, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_engine_internals", transliteration = "gal ptikha",
            original = "גַּל פִּתִיחָה", translation = "распределительный вал",
            definition = "ציר מסתובב שפותח וסוגר את השסתומים בזמן הנכון.",
            definitionNative = "Вращающаяся ось, которая в нужный миг открывает клапаны.",
            example = "גַּל פִּתִיחָה מפלסטיק מתכלה אחרי מאתיים אלף.",
            exampleNative = "Пластиковый גַּל פִּתִיחָה изнашивается после двухсот тысяч.",
         fillInBlankExclusions = listOf(171301L, 171302L, 171304L, 171305L)),
        WordEntity(
            id = 171304, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_engine_internals", transliteration = "tumkhot manoa",
            original = "תֻּמְכוֹת מְנוֹעַ", translation = "опоры двигателя",
            definition = "כריות גומי שמחזיקות את המנוע ובולעות רעידות מהדרך.",
            definitionNative = "Резиновые подушки, на которых держится мотор и гасятся вибрации.",
            example = "תֻּמְכוֹת מְנוֹעַ סדוקות מעבירות זעזוע לרצפה.",
            exampleNative = "Треснувшие תֻּמְכוֹת מְנוֹעַ передают тряску на пол кузова.",
        ),
        WordEntity(
            id = 171305, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_engine_internals", transliteration = "slil hatsata",
            original = "סְלִיל הַצָּתָה", translation = "катушка зажигания",
            definition = "רכיב חשמלי שמחזק את המתח כדי ליצור ניצוץ במצת.",
            definitionNative = "Электрический узел, повышающий напряжение для искры на свече.",
            example = "סְלִיל הַצָּתָה כשל וההתנעה נכשלה בקור.",
            exampleNative = "סְלִיל הַצָּתָה вышла из строя — мотор не завёлся утром.",
         fillInBlankExclusions = listOf(171301L, 171302L, 171303L, 171304L, 171306L, 171312L)),
        WordEntity(
            id = 171306, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "auto_engine_internals", transliteration = "solenoid",
            original = "סוֹלֵנוֹאִיד", translation = "соленоид",
            definition = "סלילון חשמלי שמושך גרעין מתכת ופותח שסתומים או מצמדים.",
            definitionNative = "Электромагнитная катушка, тянущая шток для срабатывания клапанов.",
            example = "סוֹלֵנוֹאִיד של מתנע נתקע ולא משחרר.",
            exampleNative = "סוֹלֵנוֹאִיד стартера заклинил и не отпускает шестерню.",
        ),

        // ── auto_cooling_system (5) — охлаждение ──
        WordEntity(
            id = 171307, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_cooling_system", transliteration = "mash'evat mayim",
            original = "מַשְׁאֵבַת מַיִם", translation = "водяной насос",
            definition = "התקן שמזרים את נוזל הקירור דרך גוש המנוע והרדיאטור.",
            definitionNative = "Узел, гоняющий охлаждающую жидкость через мотор и радиатор.",
            example = "מַשְׁאֵבַת מַיִם דולפת ויוצרת שלולית מתחת.",
            exampleNative = "מַשְׁאֵבַת מַיִם течёт и оставляет лужу под мотором.",
         fillInBlankExclusions = listOf(171308L, 171309L, 171310L, 171312L)),
        WordEntity(
            id = 171308, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_cooling_system", transliteration = "ma'avir khom",
            original = "מַעֲבִיר חֹם", translation = "теплообменник",
            definition = "התקן שמעביר חום מנוזל אחד לאחר בלי לערבב ביניהם.",
            definitionNative = "Узел, передающий тепло из одной жидкости в другую без смешения.",
            example = "מַעֲבִיר חֹם של תיבת ההילוכים נסתם בלכלוך.",
            exampleNative = "מַעֲבִיר חֹם коробки забился отложениями за годы.",
         fillInBlankExclusions = listOf(171307L, 171309L, 171310L)),
        WordEntity(
            id = 171309, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_cooling_system", transliteration = "ma'agal kerur",
            original = "מַעֲגַל קֵרוּר", translation = "контур охлаждения",
            definition = "מערכת סגורה של צינורות ונוזל ששומרת על טמפרטורת המנוע.",
            definitionNative = "Замкнутая сеть труб с жидкостью, поддерживающая температуру мотора.",
            example = "מַעֲגַל קֵרוּר איבד לחץ אחרי הקילומטר האחרון.",
            exampleNative = "מַעֲגַל קֵרוּר потерял давление на последних километрах.",
         fillInBlankExclusions = listOf(171307L, 171308L, 171310L)),
        WordEntity(
            id = 171310, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_cooling_system", transliteration = "tsinor radyator",
            original = "צִינּוֹר רַדְיָאטוֹר", translation = "патрубок радиатора",
            definition = "צינור גמיש שמחבר את גוש המנוע למצנן ונושא נוזל חם.",
            definitionNative = "Гибкая трубка между мотором и радиатором с горячей жидкостью.",
            example = "צִינּוֹר רַדְיָאטוֹר התפוצץ באמצע הכביש.",
            exampleNative = "צִינּוֹר רַדְיָאטוֹר лопнул прямо посреди трассы.",
         fillInBlankExclusions = listOf(171307L, 171308L, 171309L)),
        WordEntity(
            id = 171311, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "auto_cooling_system", transliteration = "termostat",
            original = "טֶרְמוֹסְטָט", translation = "термостат",
            definition = "שסתום אוטומטי שפותח זרימת נוזל ברגע שהמנוע מתחמם.",
            definitionNative = "Клапан, открывающий поток жидкости при нагреве мотора.",
            example = "טֶרְמוֹסְטָט תקוע גורם להתחממות מהירה.",
            exampleNative = "Заклинивший טֶרְמוֹסְטָט вызывает быстрый перегрев двигателя.",
         fillInBlankExclusions = listOf(171307L)),

        // ── auto_fuel_oil_exhaust (4) — топливо, масло и выхлоп ──
        WordEntity(
            id = 171312, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_fuel_oil_exhaust", transliteration = "mash'evat delek",
            original = "מַשְׁאֵבַת דֶּלֶק", translation = "топливный насос",
            definition = "אבזר חשמלי שמעביר בנזין מהמיכל אל המנוע בלחץ קבוע.",
            definitionNative = "Электронасос, гонящий горючее из бака к мотору под напором.",
            example = "מַשְׁאֵבַת דֶּלֶק רעשה ופסקה לעבוד.",
            exampleNative = "מַשְׁאֵבַת דֶּלֶק загудела и встала на середине шоссе.",
         fillInBlankExclusions = listOf(171307L, 171313L, 171314L, 171315L)),
        WordEntity(
            id = 171313, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_fuel_oil_exhaust", transliteration = "kayul mazrekim",
            original = "כַּיּוּל מַזְרֵקִים", translation = "калибровка форсунок",
            definition = "כיוון מדויק של פתחי הזרקת הדלק לפי מפרט יצרן.",
            definitionNative = "Точная настройка струй впрыска под параметры производителя.",
            example = "כַּיּוּל מַזְרֵקִים נעשה במכשיר אבחון מתקדם.",
            exampleNative = "כַּיּוּל מַזְרֵקִים делают на современном диагностическом стенде.",
         fillInBlankExclusions = listOf(171312L, 171314L, 171315L, 171319L, 171320L)),
        WordEntity(
            id = 171314, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_fuel_oil_exhaust", transliteration = "ma'arekhet hitpaltut",
            original = "מַעֲרֶכֶת הִתְפַּלְּטוּת", translation = "выпускная система",
            definition = "סדרת צינורות וממירים שמסלקים את גזי השרפה החוצה.",
            definitionNative = "Связка труб и катализаторов, выводящая горелые газы наружу.",
            example = "מַעֲרֶכֶת הִתְפַּלְּטוּת חלודה שורקת בכל סיבוב.",
            exampleNative = "Ржавая מַעֲרֶכֶת הִתְפַּלְּטוּת свистит на каждом повороте.",
         fillInBlankExclusions = listOf(171312L, 171313L, 171315L)),
        WordEntity(
            id = 171315, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_fuel_oil_exhaust", transliteration = "hakhlafat shemen",
            original = "הַחְלָפַת שֶׁמֶן", translation = "замена масла",
            definition = "פעולת תחזוקה שבה מוציאים שמן ישן ומכניסים חדש למנוע.",
            definitionNative = "Регламентная работа: старая жидкость сливается, новая заливается.",
            example = "הַחְלָפַת שֶׁמֶן מומלצת כל עשרת אלפים קילומטר.",
            exampleNative = "הַחְלָפַת שֶׁמֶן рекомендуется каждые десять тысяч километров.",
         fillInBlankExclusions = listOf(171312L, 171313L, 171314L, 171319L, 171320L)),

        // ── auto_brakes_chassis (5) — тормоза и шасси ──
        WordEntity(
            id = 171316, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_brakes_chassis", transliteration = "ma'atsor disk",
            original = "מַעֲצוֹר דִּיסְק", translation = "дисковый тормоз",
            definition = "צלחת מתכת מסתובבת שכריות לוחצות עליה כדי לעצור גלגל.",
            definitionNative = "Вращающаяся стальная пластина, которую сжимают колодки для остановки.",
            example = "מַעֲצוֹר דִּיסְק התעקם ורעד בנהיגה.",
            exampleNative = "מַעֲצוֹר דִּיסְק повело, и руль вибрирует при торможении.",
         fillInBlankExclusions = listOf(171317L, 171318L, 171319L, 171320L)),
        WordEntity(
            id = 171317, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_brakes_chassis", transliteration = "kariot blamim",
            original = "כָּרִיוֹת בְּלָמִים", translation = "тормозные колодки",
            definition = "חלקי חיכוך מוחלפים שלוחצים על הדיסק או התוף לעצירה.",
            definitionNative = "Сменные фрикционные элементы, прижимающие диск или барабан.",
            example = "כָּרִיוֹת בְּלָמִים שחוקות יוצרות חריקה גבוהה.",
            exampleNative = "Стёртые כָּרִיוֹת בְּלָמִים визжат высоким металлическим звуком.",
         fillInBlankExclusions = listOf(171316L, 171319L, 171320L)),
        WordEntity(
            id = 171318, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "auto_brakes_chassis", transliteration = "saren",
            original = "סָרֵן", translation = "ось, мост",
            definition = "מוט עבה שמחבר שני גלגלים ומחזיק עליהם את משקל הרכב.",
            definitionNative = "Толстый стержень, соединяющий два колеса и несущий вес машины.",
            example = "סָרֵן אחורי התעקם בתאונה.",
            exampleNative = "סָרֵן заднего моста повело при ударе в столб.",
         fillInBlankExclusions = listOf(171316L)),
        WordEntity(
            id = 171319, setId = 1713, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "auto_brakes_chassis", transliteration = "izun galgalim",
            original = "אִיזּוּן גַּלְגַּלִּים", translation = "балансировка колёс",
            definition = "התאמת משקל סביב הצמיג כדי שהנהיגה לא תרעד במהירות.",
            definitionNative = "Подгонка веса по ободу шины, чтобы руль не дрожал на скорости.",
            example = "אִיזּוּן גַּלְגַּלִּים נעשה אחרי כל החלפה.",
            exampleNative = "אִיזּוּן גַּלְגַּלִּים делают после каждой замены покрышек.",
         fillInBlankExclusions = listOf(171315L, 171316L, 171317L, 171320L)),
        WordEntity(
            id = 171320, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_brakes_chassis", transliteration = "kavnun zviyot",
            original = "כַּוְונוּן זְוִיּוֹת", translation = "развал-схождение",
            definition = "קביעה מדויקת של כיוון הגלגלים יחסית לכביש ולציר.",
            definitionNative = "Точная настройка наклона колёс относительно дороги и оси.",
            example = "כַּוְונוּן זְוִיּוֹת מאריך חיי צמיגים.",
            exampleNative = "כַּוְונוּן זְוִיּוֹת продлевает жизнь шинам в полтора раза.",
         fillInBlankExclusions = listOf(171316L, 171317L, 171319L)),

        // ── auto_sensors_meters (5) — датчики и приборы диагностики ──
        WordEntity(
            id = 171321, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_sensors_meters", transliteration = "makhshev manoa",
            original = "מַחְשֵׁב מְנוֹעַ", translation = "блок управления двигателем",
            definition = "מחשב קטן שאוסף נתונים ומחליט איך להפעיל את המנוע.",
            definitionNative = "Электронный модуль, управляющий впрыском, искрой и расходом мотора.",
            example = "מַחְשֵׁב מְנוֹעַ שלח קוד שגיאה למוסך.",
            exampleNative = "מַחְשֵׁב מְנוֹעַ отдал код ошибки на диагностику.",
        ),
        WordEntity(
            id = 171322, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_sensors_meters", transliteration = "khayshan khamtsan",
            original = "חַיְשַׁן חַמְצָן", translation = "лямбда-зонд",
            definition = "רכיב שמודד גזים אחרי השרפה ומדווח על איכות התערובת.",
            definitionNative = "Датчик, замеряющий состав выхлопа и точность смеси топлива.",
            example = "חַיְשַׁן חַמְצָן זקן הגדיל את צריכת הדלק.",
            exampleNative = "Старый חַיְשַׁן חַמְצָן заметно увеличил расход бензина.",
         fillInBlankExclusions = listOf(171321L, 171323L, 171324L, 171325L)),
        WordEntity(
            id = 171323, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_sensors_meters", transliteration = "khayshan zrima",
            original = "חַיְשַׁן זְרִימָה", translation = "расходомер воздуха",
            definition = "התקן שמודד כמות אוויר שנשאבת אל המנוע בכל שנייה.",
            definitionNative = "Прибор, отслеживающий объём всасываемого мотором воздуха.",
            example = "חַיְשַׁן זְרִימָה מלוכלך הפך נסיעה חלשה לרועדת.",
            exampleNative = "Грязный חַיְשַׁן זְרִימָה превратил езду в дёрганую и слабую.",
         fillInBlankExclusions = listOf(171321L, 171322L, 171324L, 171325L)),
        WordEntity(
            id = 171324, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_sensors_meters", transliteration = "mad lakhats shemen",
            original = "מַד לַחַץ שֶׁמֶן", translation = "датчик давления масла",
            definition = "אבזר שדורש הפסקה מיידית אם הסיכה במנוע נופלת.",
            definitionNative = "Прибор, требующий немедленно встать, если смазка падает в моторе.",
            example = "מַד לַחַץ שֶׁמֶן הבהב אדום בעלייה תלולה.",
            exampleNative = "מַד לַחַץ שֶׁמֶן мигнул красным на крутом подъёме.",
         fillInBlankExclusions = listOf(171321L, 171322L, 171323L, 171325L)),
        WordEntity(
            id = 171325, setId = 1713, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "auto_sensors_meters", transliteration = "mad sivuvim",
            original = "מַד סִיבּוּבִים", translation = "тахометр",
            definition = "השעון בלוח שמראה כמה פעמים המנוע מסתובב בדקה.",
            definitionNative = "Прибор, показывающий, сколько оборотов мотор делает в минуту.",
            example = "מַד סִיבּוּבִים זינק עד הקו האדום.",
            exampleNative = "מַד סִיבּוּבִים подскочил до самой красной зоны.",
         fillInBlankExclusions = listOf(171321L, 171322L, 171323L, 171324L)),
    )
}
