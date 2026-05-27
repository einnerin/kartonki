package scripts.validate.tests

// TEST FIXTURE — не импортируется в приложение.
// Три setId'а с намеренными нарушениями по каждому валидатору:
//   9992 — en-ru, основные нарушения
//   9993 — he-ru, специфичные для иврита (transliteration format, blank ambiguity,
//          mixed-script с арабской ت вместо ивритской ת)
//   9994 — en-ru, монотонные examples (триггер validate_example_variety,
//          остальные валидаторы должны на нём пройти)
//
// Используется в run_tests.sh для регрессии: каждый валидатор должен
// ЗАБЛОКИРОВАТЬ свой целевой setId с соответствующим сообщением.

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataBadFixture {

    val sets = listOf(
        WordSetEntity(
            id = 9992, languagePair = "en-ru", orderIndex = 9992,
            name = "TestBad", description = "Invalid fixture — каждое слово нарушает правило",
            topic = "TestFixtureBad", level = 1,
        ),
        WordSetEntity(
            id = 9993, languagePair = "he-ru", orderIndex = 9993,
            name = "TestBadHe", description = "Invalid he-ru fixture — IPA translit, mixed-script, blank ambiguity",
            topic = "TestFixtureBadHe", level = 1,
        ),
        WordSetEntity(
            id = 9994, languagePair = "en-ru", orderIndex = 9994,
            name = "TestBadMonotone", description = "Invalid fixture — 11 examples с одинаковым префиксом",
            topic = "TestFixtureBadMonotone", level = 1,
        ),
    )

    val words = listOf(
        // ════════════════════════════════════════════════════════════════════
        // setId=9992: основные нарушения en-ru-валидаторов
        // ════════════════════════════════════════════════════════════════════

        // 1. violate validate_fields_filled — отсутствует definition
        WordEntity(id = 999201, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "bad_missing_def", translation = "нарушитель-1",
            definitionNative = "Есть нативное определение.",
            example = "The bad_missing_def appeared in a sentence.",
            exampleNative = "Слово bad_missing_def в предложении.",
            pos = "noun", semanticGroup = "bad_group_a"),

        // 2. violate validate_pos_values — pos="adj" (запрещённая короткая форма)
        WordEntity(id = 999202, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "bad_short_pos", translation = "нарушитель-2",
            definition = "Valid short text.",
            definitionNative = "Валидный короткий текст.",
            example = "A bad_short_pos thing was here.",
            exampleNative = "Было нечто bad_short_pos рядом.",
            pos = "adj", semanticGroup = "bad_group_a"),

        // 3. violate validate_group_sizes — единственное слово в группе bad_group_lonely
        WordEntity(id = 999203, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "bad_lonely", translation = "нарушитель-3",
            definition = "Unique tiny group member.",
            definitionNative = "Уникальный член крошечной группы.",
            example = "The bad_lonely item stood alone.",
            exampleNative = "Стоял один bad_lonely на столе.",
            pos = "noun", semanticGroup = "bad_group_lonely"),

        // 4. violate validate_text_lengths — definition >90 chars
        WordEntity(id = 999204, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "bad_too_long",
            translation = "нарушитель-4",
            definition = "This definition is intentionally very long so that it easily exceeds the ninety character limit imposed by the relaxed quality standard.",
            definitionNative = "Коротко — на русском.",
            example = "Here bad_too_long lives.",
            exampleNative = "Вот bad_too_long на русском.",
            pos = "noun", semanticGroup = "bad_group_a"),

        // 5. violate validate_no_cognates AND validate_no_headword_in_def —
        // definition содержит сам original как whole word
        WordEntity(id = 999205, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "mysterygem", translation = "тест-камень",
            definition = "A shiny mysterygem sparkles under light.",
            definitionNative = "Описание без корня перевода.",
            example = "The mysterygem was bright.",
            exampleNative = "Яркий mysterygem на витрине.",
            pos = "noun", semanticGroup = "bad_group_a"),

        // 6a+6b. violate validate_no_duplicates — два слова с одинаковым original
        WordEntity(id = 999206, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "dup_word", translation = "дубль-первый",
            definition = "First of a duplicate pair.",
            definitionNative = "Первый из дубликатной пары.",
            example = "A dup_word began here.",
            exampleNative = "Первый dup_word заметили.",
            pos = "noun", semanticGroup = "bad_group_b"),
        WordEntity(id = 999207, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "dup_word", translation = "дубль-второй",
            definition = "Second copy of a duplicate pair.",
            definitionNative = "Вторая копия дубликатной пары.",
            example = "Another dup_word appeared too.",
            exampleNative = "Ещё один dup_word всплыл.",
            pos = "noun", semanticGroup = "bad_group_b"),

        // 7. violate validate_rarity_spread — LEGENDARY на фоне остальных COMMON (spread >2)
        WordEntity(id = 999208, setId = 9992, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bad_rarity_outlier", translation = "нарушитель-редкости",
            definition = "A LEGENDARY word thrown into a COMMON set.",
            definitionNative = "LEGENDARY-слово среди COMMON-слов.",
            example = "This bad_rarity_outlier is rare.",
            exampleNative = "Очень редкое bad_rarity_outlier.",
            pos = "noun", semanticGroup = "bad_group_b"),

        // 8. violate validate_no_cognates НОВАЯ ПРОВЕРКА — литеральное английское
        // original внутри definitionNative (translation не содержит корня, но
        // английское слово protruded в русский текст).
        WordEntity(id = 999209, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "leakword", translation = "утечка-русский",
            definition = "An English root unexpectedly appears in the Russian definition.",
            definitionNative = "Английский leakword просочился в русский текст определения.",
            example = "The leakword made a mess.",
            exampleNative = "leakword всплыл некстати.",
            pos = "noun", semanticGroup = "bad_group_b"),

        // 9a+9b. violate validate_blank_ambiguity FORM_MISMATCH AND
        // validate_original_strict_in_example — example использует множественную
        // форму "formbreakers" при original="formbreaker"
        // → UI: ugly "___s" + strict-letter check падает
        WordEntity(id = 999210, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "formbreaker", translation = "нарушитель-формы",
            definition = "A singular noun that leaks its plural suffix into the UI blank.",
            definitionNative = "Слово, у которого в примере стоит множественное число.",
            example = "She placed three formbreakers on the kitchen counter yesterday.",
            exampleNative = "Поставила три formbreakers на кухонную столешницу вчера.",
            pos = "noun", semanticGroup = "bad_group_c"),
        WordEntity(id = 999211, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "formbreakerpal", translation = "напарник-по-форме",
            definition = "Sibling needed so bad_group_c has size two for group_sizes.",
            definitionNative = "Напарник по группе для прохождения group_sizes.",
            example = "The formbreakerpal stood quietly beside the wooden shelf.",
            exampleNative = "formbreakerpal тихо стоял рядом с деревянной полкой.",
            pos = "verb", semanticGroup = "bad_group_c"),

        // 10. violate validate_no_translation_in_defnative — translation литерально
        // в собственном definitionNative как whole word
        WordEntity(id = 999212, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "twincard", translation = "близнечный",
            definition = "Generic stub for translation echo bug demonstration.",
            definitionNative = "Близнечный объект — повторяется тут зачем-то.",
            example = "The twincard echoed loudly.",
            exampleNative = "Тот twincard прозвучал громко.",
            pos = "adjective", semanticGroup = "bad_group_d"),

        // 11. violate validate_text_terminators — definition без точки в конце
        WordEntity(id = 999213, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "noendword", translation = "беззавершенник",
            definition = "A short text that omits the terminator on purpose",
            definitionNative = "Короткое описание без точки в конце.",
            example = "The noendword vanished.",
            exampleNative = "Тот noendword исчез.",
            pos = "noun", semanticGroup = "bad_group_d"),

        // 12. violate validate_original_in_example — example не содержит original
        // и не содержит 3-stem; полностью про другое
        WordEntity(id = 999214, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "phantomword", translation = "призрак-слово",
            definition = "Word completely absent from the example sentence.",
            definitionNative = "Слово полностью отсутствует в примере.",
            example = "The morning fog rolled across the silent valley.",
            exampleNative = "Утренний phantomword расползся над тихой долиной.",
            pos = "noun", semanticGroup = "bad_group_d"),

        // 13. violate validate_no_foreign_in_examplenative — exampleNative
        // начинается со строчной латинской
        WordEntity(id = 999215, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "tagged", translation = "помеченный",
            definition = "Adjective whose Russian example starts with a lowercase Latin word.",
            definitionNative = "Прилагательное с битым началом русского примера.",
            example = "The tagged file moved to archive.",
            exampleNative = "tagged файл попал в архив сразу.",
            pos = "adjective", semanticGroup = "bad_group_d"),

        // 14. violate validate_no_clerical — definitionNative содержит «является»
        WordEntity(id = 999216, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "clericword", translation = "канцелярит",
            definition = "Used to demonstrate a stiff bureaucratic definition.",
            definitionNative = "Это слово является примером канцелярита в тексте.",
            example = "The clericword arrived late.",
            exampleNative = "Тот clericword прибыл с опозданием.",
            pos = "noun", semanticGroup = "bad_group_e"),

        // 15. violate validate_no_mixed_script_in_words — exampleNative содержит
        // слово «бывает» с латинской «b» (U+0062) вместо кириллической «б» (U+0431)
        WordEntity(id = 999217, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "mixscript", translation = "смешанный-скрипт",
            definition = "A word demonstrating a mixed-script typo in the Russian example.",
            definitionNative = "Описание для слова со смешанным скриптом в примере.",
            example = "The mixscript was caught fast.",
            exampleNative = "Такой mixscript bывает и не один раз.",
            pos = "noun", semanticGroup = "bad_group_e"),

        // ════════════════════════════════════════════════════════════════════
        // setId=9993: Hebrew-специфичные нарушения
        // ════════════════════════════════════════════════════════════════════

        // 16. violate validate_hebrew_transliteration_format — IPA-стиль в скобках
        WordEntity(id = 999301, setId = 9993, languagePair = "he-ru", rarity = "COMMON",
            original = "מַחְשֵׁב", transliteration = "[mɑxˈʃev]", translation = "компьютер",
            definition = "Устройство для обработки данных и вычислений.",
            definitionNative = "Машина для обработки данных и вычислений.",
            example = "מַחְשֵׁב חָדָשׁ עוֹמֵד עַל הַשּׁוּלְחָן.",
            exampleNative = "Новый מַחְשֵׁב стоит на столе хозяина.",
            pos = "noun", semanticGroup = "bad_he_a"),

        // 17. violate validate_blank_ambiguity_hebrew — isFillInBlankSafe=true
        // но original в example вообще не найти даже с prefix-tolerance
        WordEntity(id = 999302, setId = 9993, languagePair = "he-ru", rarity = "COMMON",
            original = "סֵפֶר", transliteration = "sefer", translation = "книга",
            definition = "Множество страниц с буквами под одной обложкой.",
            definitionNative = "Связка страниц с текстом под одной обложкой.",
            example = "הוּא יָשַׁב לְיַד הַחַלּוֹן בַּשֶּׁקֶט הַגָּמוּר.",
            exampleNative = "Утренний סֵפֶר лежал у окна несколько часов.",
            pos = "noun", semanticGroup = "bad_he_a",
            isFillInBlankSafe = true),

        // 18. violate validate_no_foreign_script_in_original — арабская ت (U+062A)
        // вставлена в Hebrew original вместо ивритской ת (U+05EA)
        WordEntity(id = 999303, setId = 9993, languagePair = "he-ru", rarity = "COMMON",
            original = "בَית", transliteration = "bayit", translation = "дом",
            definition = "Здание, где живут люди.",
            definitionNative = "Здание, где живут люди и хранят вещи.",
            example = "הַבַּיִת הַגָּדוֹל עוֹמֵד עַל גִּבְעָה.",
            exampleNative = "Большой בַּיִת стоит на холме за рекой.",
            pos = "noun", semanticGroup = "bad_he_a"),

        // 19. Filler — нужен 4-й word для прохождения group_sizes на 9993
        WordEntity(id = 999304, setId = 9993, languagePair = "he-ru", rarity = "COMMON",
            original = "כֶּלֶב", transliteration = "kelev", translation = "собака",
            definition = "Домашнее животное на четырёх лапах.",
            definitionNative = "Домашнее животное, которое лает и виляет хвостом.",
            example = "הַכֶּלֶב רָץ אַחֲרֵי הַחָתוּל.",
            exampleNative = "Большой כֶּלֶב побежал за котом во двор.",
            pos = "noun", semanticGroup = "bad_he_a"),

        // ════════════════════════════════════════════════════════════════════
        // setId=9994: монотонные examples (11 штук «Every test ...»)
        // Только validate_example_variety падает; остальные проходят.
        // ════════════════════════════════════════════════════════════════════

        WordEntity(id = 999401, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "alphaword", translation = "альфа-слово",
            definition = "Generic stub one for monotone example testing.",
            definitionNative = "Заглушка номер один для теста монотонности.",
            example = "Every test alphaword arrives quietly on schedule.",
            exampleNative = "Тестовое alphaword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
        WordEntity(id = 999402, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "betaword", translation = "бета-слово",
            definition = "Generic stub two for monotone example testing.",
            definitionNative = "Заглушка номер два для теста монотонности.",
            example = "Every test betaword arrives quietly on schedule.",
            exampleNative = "Тестовое betaword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
        WordEntity(id = 999403, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "gammaword", translation = "гамма-слово",
            definition = "Generic stub three for monotone example testing.",
            definitionNative = "Заглушка номер три для теста монотонности.",
            example = "Every test gammaword arrives quietly on schedule.",
            exampleNative = "Тестовое gammaword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
        WordEntity(id = 999404, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "deltaword", translation = "дельта-слово",
            definition = "Generic stub four for monotone example testing.",
            definitionNative = "Заглушка номер четыре для теста монотонности.",
            example = "Every test deltaword arrives quietly on schedule.",
            exampleNative = "Тестовое deltaword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
        WordEntity(id = 999405, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "epsilonword", translation = "эпсилон-слово",
            definition = "Generic stub five for monotone example testing.",
            definitionNative = "Заглушка номер пять для теста монотонности.",
            example = "Every test epsilonword arrives quietly on schedule.",
            exampleNative = "Тестовое epsilonword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
        WordEntity(id = 999406, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "zetaword", translation = "зета-слово",
            definition = "Generic stub six for monotone example testing.",
            definitionNative = "Заглушка номер шесть для теста монотонности.",
            example = "Every test zetaword arrives quietly on schedule.",
            exampleNative = "Тестовое zetaword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
        WordEntity(id = 999407, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "etaword", translation = "эта-слово",
            definition = "Generic stub seven for monotone example testing.",
            definitionNative = "Заглушка номер семь для теста монотонности.",
            example = "Every test etaword arrives quietly on schedule.",
            exampleNative = "Тестовое etaword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
        WordEntity(id = 999408, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "thetaword", translation = "тета-слово",
            definition = "Generic stub eight for monotone example testing.",
            definitionNative = "Заглушка номер восемь для теста монотонности.",
            example = "Every test thetaword arrives quietly on schedule.",
            exampleNative = "Тестовое thetaword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
        WordEntity(id = 999409, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "iotaword", translation = "йота-слово",
            definition = "Generic stub nine for monotone example testing.",
            definitionNative = "Заглушка номер девять для теста монотонности.",
            example = "Every test iotaword arrives quietly on schedule.",
            exampleNative = "Тестовое iotaword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
        WordEntity(id = 999410, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "kappaword", translation = "каппа-слово",
            definition = "Generic stub ten for monotone example testing.",
            definitionNative = "Заглушка номер десять для теста монотонности.",
            example = "Every test kappaword arrives quietly on schedule.",
            exampleNative = "Тестовое kappaword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
        WordEntity(id = 999411, setId = 9994, languagePair = "en-ru", rarity = "COMMON",
            original = "lambdaword", translation = "ламбда-слово",
            definition = "Generic stub eleven for monotone example testing.",
            definitionNative = "Заглушка номер одиннадцать для теста монотонности.",
            example = "Every test lambdaword arrives quietly on schedule.",
            exampleNative = "Тестовое lambdaword пришло тихо по расписанию.",
            pos = "noun", semanticGroup = "mono_group"),
    )
}
