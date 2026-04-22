package scripts.validate.tests

// TEST FIXTURE — не импортируется в приложение.
// Содержит setId=9992 с намеренными нарушениями по каждому валидатору.
// Используется в run_tests.sh для регрессии: каждый валидатор должен
// ЗАБЛОКИРОВАТЬ этот набор с соответствующим сообщением.

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataBadFixture {

    val sets = listOf(
        WordSetEntity(
            id = 9992, languagePair = "en-ru", orderIndex = 9992,
            name = "TestBad", description = "Invalid fixture — каждое слово нарушает правило",
            topic = "TestFixtureBad", level = 1,
        ),
    )

    val words = listOf(
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

        // 4. violate validate_text_lengths — definition >80 chars
        WordEntity(id = 999204, setId = 9992, languagePair = "en-ru", rarity = "COMMON",
            original = "bad_too_long",
            translation = "нарушитель-4",
            definition = "This definition is intentionally very long so that it easily exceeds the 80 character limit imposed by the quality standard.",
            definitionNative = "Коротко — на русском.",
            example = "Here bad_too_long lives.",
            exampleNative = "Вот bad_too_long на русском.",
            pos = "noun", semanticGroup = "bad_group_a"),

        // 5. violate validate_no_cognates — definition содержит корень original
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

        // 9. violate validate_blank_ambiguity FORM_MISMATCH — example использует
        // множественную форму "formbreakers" при original="formbreaker" →
        // UI сгенерирует уродливый пропуск "___s".
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
    )
}
