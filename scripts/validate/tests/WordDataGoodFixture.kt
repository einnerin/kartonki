package scripts.validate.tests

// TEST FIXTURE — не импортируется в приложение.
// Содержит валидный setId=9991 для регрессии validate_all.sh.
// Все 8 валидаторов должны пройти без блокирующих ошибок (warning допустим).
//
// Слова подобраны так, чтобы внутри каждой semanticGroup длины original отличались
// минимум на 4 символа — это «выключает» эвристику validate_blank_ambiguity
// (порог similarity = ±3 символа). При добавлении новых слов сохраняй это
// свойство, иначе good-фикстура начнёт падать на AMBIGUOUS_BLANK.

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
        // test_fruits: fig (3) vs watermelon (10) — diff 7, не срабатывает ambiguity.
        WordEntity(id = 999101, setId = 9991, languagePair = "en-ru", rarity = "COMMON",
            original = "fig", translation = "инжир",
            definition = "A small round sweet food with tiny seeds inside.",
            definitionNative = "Маленький круглый сладкий плод с мелкими семечками.",
            example = "Grandma picked a ripe fig from the old garden tree.",
            exampleNative = "Бабушка сорвала спелый fig со старого садового дерева.",
            pos = "noun", semanticGroup = "test_fruits"),
        WordEntity(id = 999102, setId = 9991, languagePair = "en-ru", rarity = "COMMON",
            original = "watermelon", translation = "арбуз",
            definition = "A very big round green food with sweet red inside.",
            definitionNative = "Очень большой круглый зелёный плод со сладкой красной мякотью.",
            example = "We shared a huge watermelon at the summer family picnic.",
            exampleNative = "Поделили огромный watermelon на летнем семейном пикнике.",
            pos = "noun", semanticGroup = "test_fruits"),

        // test_tools: axe (3) vs screwdriver (11) — diff 8, не срабатывает ambiguity.
        WordEntity(id = 999103, setId = 9991, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "axe", translation = "топор",
            definition = "A sharp metal tool on a long wooden handle for chopping.",
            definitionNative = "Острый металлический инструмент на длинной ручке для рубки.",
            example = "Dad kept a sharp axe by the woodpile all year.",
            exampleNative = "Отец держал острый axe у поленницы весь год.",
            pos = "noun", semanticGroup = "test_tools"),
        WordEntity(id = 999104, setId = 9991, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "screwdriver", translation = "отвёртка",
            definition = "A hand tool with a long handle used for turning small bolts.",
            definitionNative = "Ручной инструмент с длинной рукоятью для закручивания винтов.",
            example = "My grandfather's old screwdriver still works perfectly today.",
            exampleNative = "Старая screwdriver дедушки до сих пор работает отлично.",
            pos = "noun", semanticGroup = "test_tools"),
    )
}
