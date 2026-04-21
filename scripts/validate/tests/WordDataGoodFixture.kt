package scripts.validate.tests

// TEST FIXTURE — не импортируется в приложение.
// Содержит валидный setId=9991 (6 слов) для регрессии validate_all.sh.
// Все 7 валидаторов должны пройти без блокирующих ошибок (warning допустим).

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataGoodFixture {

    val sets = listOf(
        WordSetEntity(
            id = 9991, languagePair = "en-ru", orderIndex = 9991,
            name = "TestGood", description = "Valid fixture",
            topic = "TestFixtureGood", level = 1,
        ),
    )

    val words = listOf(
        WordEntity(id = 999101, setId = 9991, languagePair = "en-ru", rarity = "COMMON",
            original = "fruit_a", translation = "фрукт-а",
            definition = "A round red food you can eat.",
            definitionNative = "Круглая красная еда, которую можно съесть.",
            example = "I ate a fruit_a for breakfast today.",
            exampleNative = "Съел fruit_a утром на завтрак.",
            pos = "noun", semanticGroup = "test_fruits"),
        WordEntity(id = 999102, setId = 9991, languagePair = "en-ru", rarity = "COMMON",
            original = "fruit_b", translation = "фрукт-б",
            definition = "A yellow soft food with thin skin.",
            definitionNative = "Жёлтая мягкая еда с тонкой кожурой.",
            example = "She peeled a fruit_b before eating it.",
            exampleNative = "Она почистила fruit_b перед едой.",
            pos = "noun", semanticGroup = "test_fruits"),
        WordEntity(id = 999103, setId = 9991, languagePair = "en-ru", rarity = "COMMON",
            original = "fruit_c", translation = "фрукт-ц",
            definition = "A small dark purple sweet food.",
            definitionNative = "Маленькая тёмно-фиолетовая сладкая еда.",
            example = "He picked a fruit_c off the bush.",
            exampleNative = "Сорвал fruit_c с куста.",
            pos = "noun", semanticGroup = "test_fruits"),
        WordEntity(id = 999104, setId = 9991, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tool_a", translation = "инструмент-а",
            definition = "A sharp hand thing for cutting bread.",
            definitionNative = "Острая ручная вещь для нарезания хлеба.",
            example = "Grandma used a tool_a to slice the loaf.",
            exampleNative = "Бабушка резала хлеб своим tool_a.",
            pos = "noun", semanticGroup = "test_tools"),
        WordEntity(id = 999105, setId = 9991, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tool_b", translation = "инструмент-б",
            definition = "A small hand device with sharp points.",
            definitionNative = "Маленькое ручное устройство с острыми зубцами.",
            example = "Use a tool_b to pick up the pasta.",
            exampleNative = "Возьми tool_b, чтобы есть пасту.",
            pos = "noun", semanticGroup = "test_tools"),
        WordEntity(id = 999106, setId = 9991, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tool_c", translation = "инструмент-ц",
            definition = "A round deep dish for soup or salad.",
            definitionNative = "Круглая глубокая посуда для супа или салата.",
            example = "She filled a tool_c with hot soup.",
            exampleNative = "Наполнила tool_c горячим супом.",
            pos = "noun", semanticGroup = "test_tools"),
    )
}
