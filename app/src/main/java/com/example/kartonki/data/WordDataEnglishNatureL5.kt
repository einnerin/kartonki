package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Природа и экология (level 5, носитель языка).
 *
 * Set 333: «Природа и экология» — литературная и архаичная природная
 * лексика: поэтические образы, редкие термины, романтические описания
 * (C2+ / EPIC + LEGENDARY, преобладает LEGENDARY).
 *
 * Дополняет уже существующие сеты темы «Природа и экология»:
 *   - Set 281 (WordDataEnglishBatch12.kt)    — L1 COMMON/UNCOMMON.
 *   - Set 232 (WordDataEnglishExpanded.kt)   — L2 (copse, fjord, tundra…).
 *   - Set 233 (WordDataEnglishExpanded.kt)   — L3 (canopy, symbiosis, ecotone…).
 *   - Set 332 (WordDataEnglishNatureL4.kt)   — L4 (biome, biota, fauna, stewardship…).
 *
 * Слова setId=333 не пересекаются ни с одним из перечисленных setId
 * (проверено grep по `original = "..."` и по теме).
 *
 * Распределение редкости: 5 EPIC + 20 LEGENDARY — два смежных уровня шкалы.
 *
 * SemanticGroups (5 × 5):
 *   nature_archaic_winds      — zephyr, mistral, foehn, harmattan, chinook
 *   nature_archaic_landscape  — glade, dell, glen, moor, heath
 *   nature_archaic_flora      — bramble, thicket, undergrowth, foliage, verdure
 *   nature_archaic_phenomena  — aurora, mirage, halo, alpenglow, petrichor
 *   nature_archaic_water      — tarn, firth, freshet, rill, slough
 *
 * Word IDs: 33301..33325 (setId × 100 + position).
 *
 * Регистрация в WordRegistry.kt — отложена (отдельный коммит вместе с bump
 * WordDataVersion); этот файл — только данные.
 */
object WordDataEnglishNatureL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 333, name = "Природа и экология",
            description = "Литературная и архаичная лексика природы: поэтические образы, редкие термины, романтические описания",
            languagePair = "en-ru",
            topic = "Природа и экология", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── nature_archaic_winds (5) ──────────────────────────────────────

        WordEntity(id = 33301, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "zephyr", transliteration = "[ˈzɛfər]", translation = "лёгкий западный ветерок (поэт.)",
            definition = "A soft warm breeze, especially from the west — a poetic word for gentle wind.",
            definitionNative = "Мягкий тёплый ветерок, особенно с запада — поэтичное слово для лёгкого дуновения.",
            example = "A warm zephyr stirred the curtains and carried the scent of jasmine.",
            exampleNative = "Тёплый zephyr колыхал занавеси и нёс аромат жасмина.",
            pos = "noun", semanticGroup = "nature_archaic_winds", fillInBlankExclusions = listOf(33302L, 33303L, 33304L, 33305L)),

        WordEntity(id = 33302, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mistral", transliteration = "[ˈmɪstrəl]", translation = "мистраль (холодный ветер с Альп)",
            definition = "A cold dry wind that sweeps down the Rhone valley to the southern coast of France.",
            definitionNative = "Холодный сухой ветер, скатывающийся по долине Роны к южному побережью Франции.",
            example = "A bitter mistral howled through the village and rattled every shutter.",
            exampleNative = "Жестокий mistral выл по деревне и тряс каждую ставню.",
            pos = "noun", semanticGroup = "nature_archaic_winds", fillInBlankExclusions = listOf(33301L, 33303L, 33304L, 33305L)),

        WordEntity(id = 33303, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "foehn", transliteration = "[fən]", translation = "фён (тёплый альпийский ветер)",
            definition = "A warm dry wind that pours down the lee side of a mountain range.",
            definitionNative = "Тёплый сухой ветер, скатывающийся с подветренной стороны горного хребта.",
            example = "A sudden foehn melted the snow on the valley slopes overnight.",
            exampleNative = "Внезапный foehn растопил снег на склонах долины за одну ночь.",
            pos = "noun", semanticGroup = "nature_archaic_winds", fillInBlankExclusions = listOf(33301L, 33302L, 33304L, 33305L)),

        WordEntity(id = 33304, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "harmattan", transliteration = "[hɑrməˈtæn]", translation = "харматан (сухой ветер Сахары)",
            definition = "A dusty desert wind that blows from the Sahara across West Africa each winter.",
            definitionNative = "Пыльный пустынный ветер, дующий из Сахары через Западную Африку каждой зимой.",
            example = "A dry harmattan filled the air with reddish dust for days.",
            exampleNative = "Сухой harmattan наполнил воздух красноватой пылью на несколько дней.",
            pos = "noun", semanticGroup = "nature_archaic_winds", fillInBlankExclusions = listOf(33301L, 33302L, 33303L, 33305L)),

        WordEntity(id = 33305, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "chinook", transliteration = "[ʃɪˈnʊk]", translation = "чинук (тёплый ветер Скалистых гор)",
            definition = "A warm dry wind that sweeps down the eastern slopes of the Rocky Mountains.",
            definitionNative = "Тёплый сухой ветер, скатывающийся с восточных склонов Скалистых гор.",
            example = "A sudden chinook raised the temperature thirty degrees within an hour.",
            exampleNative = "Внезапный chinook поднял температуру на тридцать градусов за час.",
            pos = "noun", semanticGroup = "nature_archaic_winds", fillInBlankExclusions = listOf(33301L, 33302L, 33303L, 33304L)),

        // ── nature_archaic_landscape (5) ──────────────────────────────────

        WordEntity(id = 33306, setId = 333, languagePair = "en-ru", rarity = "EPIC",
            original = "glade", transliteration = "[ɡleɪd]", translation = "лесная поляна",
            definition = "A small open space inside a forest where sunlight reaches the ground.",
            definitionNative = "Маленькое открытое место в лесу, куда проникает солнечный свет.",
            example = "A young deer paused at the edge of the sunlit glade.",
            exampleNative = "Молодой олень замер на краю освещённой солнцем glade.",
            pos = "noun", semanticGroup = "nature_archaic_landscape", fillInBlankExclusions = listOf(33307L, 33308L, 33309L, 33310L, 33312L)),

        WordEntity(id = 33307, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dell", transliteration = "[dɛl]", translation = "лощина (поэт., малая долинка)",
            definition = "A small wooded hollow between low hills — an archaic, gentle word for a tiny valley.",
            definitionNative = "Маленькая лесистая впадина между холмами — архаичное мягкое слово для крошечной долины.",
            example = "Children played beside a brook in the quiet dell.",
            exampleNative = "Дети играли у ручья в тихой dell.",
            pos = "noun", semanticGroup = "nature_archaic_landscape", fillInBlankExclusions = listOf(33306L, 33308L, 33309L, 33310L)),

        WordEntity(id = 33308, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "glen", transliteration = "[ɡlɛn]", translation = "глен (узкая горная долина, шотл.)",
            definition = "A long narrow valley running between steep hills, especially in Scotland or Ireland.",
            definitionNative = "Длинная узкая долина между крутыми холмами, особенно в Шотландии и Ирландии.",
            example = "Mist filled the lonely glen long after sunrise.",
            exampleNative = "Туман заполнял пустынный glen долго после восхода.",
            pos = "noun", semanticGroup = "nature_archaic_landscape", fillInBlankExclusions = listOf(33306L, 33307L, 33309L, 33310L)),

        WordEntity(id = 33309, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "moor", transliteration = "[mʊr]", translation = "вересковая пустошь",
            definition = "A wide rolling upland of poor soil covered with heather and rough grass.",
            definitionNative = "Широкое холмистое нагорье с бедной почвой, поросшее вереском и грубой травой.",
            example = "A lone shepherd crossed the windswept moor at dawn.",
            exampleNative = "Одинокий пастух пересекал продуваемый ветром moor на рассвете.",
            pos = "noun", semanticGroup = "nature_archaic_landscape", fillInBlankExclusions = listOf(33306L, 33307L, 33308L, 33310L)),

        WordEntity(id = 33310, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "heath", transliteration = "[hiθ]", translation = "верещатник (открытая равнина с кустарником)",
            definition = "A flat open stretch of land covered with low woody shrubs and tough grass.",
            definitionNative = "Плоский открытый участок земли, покрытый низкими древесными кустарниками и жёсткой травой.",
            example = "Wild ponies grazed across the purple heath in late summer.",
            exampleNative = "Дикие пони паслись на лиловом heath в конце лета.",
            pos = "noun", semanticGroup = "nature_archaic_landscape", fillInBlankExclusions = listOf(33306L, 33307L, 33308L, 33309L)),

        // ── nature_archaic_flora (5) ──────────────────────────────────────

        WordEntity(id = 33311, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bramble", transliteration = "[ˈbræmbəl]", translation = "ежевичный куст / колючий кустарник",
            definition = "A prickly trailing shrub of the rose family, bearing dark berries and sharp thorns.",
            definitionNative = "Колючий стелющийся кустарник из семейства розовых, с тёмными ягодами и острыми шипами.",
            example = "A thick bramble blocked the narrow path through the woods.",
            exampleNative = "Густой bramble преградил узкую тропу через лес.",
            pos = "noun", semanticGroup = "nature_archaic_flora", fillInBlankExclusions = listOf(33312L, 33313L, 33314L, 33315L)),

        WordEntity(id = 33312, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "thicket", transliteration = "[ˈθɪkɪt]", translation = "густые заросли / чаща",
            definition = "A dense group of bushes or small trees growing tightly together.",
            definitionNative = "Плотная группа кустов или мелких деревьев, растущих тесно друг к другу.",
            example = "A startled fox darted into the dark thicket beside the stream.",
            exampleNative = "Испуганная лиса метнулась в тёмный thicket у ручья.",
            pos = "noun", semanticGroup = "nature_archaic_flora", fillInBlankExclusions = listOf(33311L, 33313L, 33314L, 33315L)),

        WordEntity(id = 33313, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "undergrowth", transliteration = "[ˈʌndərɡroʊθ]", translation = "подлесок",
            definition = "Low plants and shrubs that grow beneath the taller trees of a forest.",
            definitionNative = "Низкие растения и кусты, растущие под высокими деревьями леса.",
            example = "Hikers struggled through dense undergrowth all afternoon.",
            exampleNative = "Туристы пробирались сквозь густой undergrowth весь день.",
            pos = "noun", semanticGroup = "nature_archaic_flora", fillInBlankExclusions = listOf(33311L, 33312L, 33314L, 33315L)),

        WordEntity(id = 33314, setId = 333, languagePair = "en-ru", rarity = "EPIC",
            original = "foliage", transliteration = "[ˈfoʊliɪʤ]", translation = "листва",
            definition = "The leaves of a plant or tree taken together as a single mass of green.",
            definitionNative = "Зелёная крона растения или дерева как единая густая масса.",
            example = "Autumn foliage burned red and gold along the river road.",
            exampleNative = "Осенняя foliage горела красным и золотым вдоль речной дороги.",
            pos = "noun", semanticGroup = "nature_archaic_flora", fillInBlankExclusions = listOf(33311L, 33312L, 33313L, 33315L)),

        WordEntity(id = 33315, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "verdure", transliteration = "[ˈvɜrʤər]", translation = "свежая зелень (поэт.)",
            definition = "Fresh green vegetation seen as a whole — a literary word for lush plant cover.",
            definitionNative = "Свежая зелёная растительность как целое — литературное слово для пышного покрова.",
            example = "Spring rains brought a sudden verdure to the bare meadows.",
            exampleNative = "Весенние дожди принесли внезапную verdure на голые луга.",
            pos = "noun", semanticGroup = "nature_archaic_flora", fillInBlankExclusions = listOf(33311L, 33312L, 33313L, 33314L)),

        // ── nature_archaic_phenomena (5) ──────────────────────────────────

        WordEntity(id = 33316, setId = 333, languagePair = "en-ru", rarity = "EPIC",
            original = "aurora", transliteration = "[əˈrɔrə]", translation = "полярное сияние",
            definition = "A coloured glow in the night sky near the poles, caused by particles from the sun.",
            definitionNative = "Цветное свечение в ночном небе у полюсов, вызванное частицами от солнца.",
            example = "A green aurora rippled across the Arctic sky for hours.",
            exampleNative = "Зелёная aurora мерцала по арктическому небу часами.",
            pos = "noun", semanticGroup = "nature_archaic_phenomena", fillInBlankExclusions = listOf(33317L, 33318L, 33319L, 33320L)),

        WordEntity(id = 33317, setId = 333, languagePair = "en-ru", rarity = "EPIC",
            original = "mirage", transliteration = "[məˈrɑʒ]", translation = "мираж",
            definition = "A trick of the eye in hot air that makes distant objects look like water or sky.",
            definitionNative = "Обман зрения в жарком воздухе: далёкие предметы кажутся водой или небом.",
            example = "A shimmering mirage rose above the hot desert road at noon.",
            exampleNative = "Мерцающий mirage поднимался над раскалённой пустынной дорогой в полдень.",
            pos = "noun", semanticGroup = "nature_archaic_phenomena", fillInBlankExclusions = listOf(33316L, 33318L, 33319L, 33320L)),

        WordEntity(id = 33318, setId = 333, languagePair = "en-ru", rarity = "EPIC",
            original = "halo", transliteration = "[ˈheɪloʊ]", translation = "гало (световое кольцо)",
            definition = "A bright ring of light around the sun or moon caused by ice crystals in the air.",
            definitionNative = "Яркое кольцо света вокруг солнца или луны, вызванное ледяными кристаллами в воздухе.",
            example = "A pale halo circled the winter moon all evening.",
            exampleNative = "Бледное halo окружало зимнюю луну весь вечер.",
            pos = "noun", semanticGroup = "nature_archaic_phenomena", fillInBlankExclusions = listOf(33316L, 33317L, 33319L, 33320L)),

        WordEntity(id = 33319, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "alpenglow", transliteration = "[ˈælpənˌɡloʊ]", translation = "альпийское зарево (отсвет на горах после заката)",
            definition = "The reddish glow on high mountain peaks just before sunrise or just after sunset.",
            definitionNative = "Красноватое свечение на вершинах гор сразу до восхода или после заката.",
            example = "A soft alpenglow lit the snowy summits long after sundown.",
            exampleNative = "Мягкий alpenglow освещал снежные вершины долго после заката.",
            pos = "noun", semanticGroup = "nature_archaic_phenomena", fillInBlankExclusions = listOf(33316L, 33317L, 33318L, 33320L)),

        WordEntity(id = 33320, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "petrichor", transliteration = "[ˈpɛtrɪkɔr]", translation = "запах земли после дождя",
            definition = "The earthy smell that rises from dry soil when fresh rain finally falls.",
            definitionNative = "Землистый аромат, поднимающийся от сухой почвы, когда наконец выпадает свежий дождь.",
            example = "A sweet petrichor filled the air after the long drought broke.",
            exampleNative = "Сладкая petrichor наполнила воздух, когда долгая засуха наконец закончилась.",
            pos = "noun", semanticGroup = "nature_archaic_phenomena", fillInBlankExclusions = listOf(33316L, 33317L, 33318L, 33319L)),

        // ── nature_archaic_water (5) ──────────────────────────────────────

        WordEntity(id = 33321, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tarn", transliteration = "[tɑrn]", translation = "карово́е озеро (горное озерцо)",
            definition = "A small mountain lake that fills the rocky bowl left by an ancient glacier.",
            definitionNative = "Маленькое горное озеро в каменной чаше, оставленной древним ледником.",
            example = "A still tarn reflected the cliffs above the silent valley.",
            exampleNative = "Неподвижный tarn отражал скалы над безмолвной долиной.",
            pos = "noun", semanticGroup = "nature_archaic_water", fillInBlankExclusions = listOf(33322L, 33323L, 33324L, 33325L)),

        WordEntity(id = 33322, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "firth", transliteration = "[fɜrθ]", translation = "ферт (узкий морской залив, шотл.)",
            definition = "A long narrow inlet of the sea, especially the mouth of a Scottish river.",
            definitionNative = "Длинный узкий морской залив, особенно устье шотландской реки.",
            example = "Fishing boats drifted home across the calm firth at dusk.",
            exampleNative = "Рыбацкие лодки возвращались по спокойному firth в сумерках.",
            pos = "noun", semanticGroup = "nature_archaic_water", fillInBlankExclusions = listOf(33321L, 33323L, 33324L, 33325L)),

        WordEntity(id = 33323, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "freshet", transliteration = "[ˈfrɛʃɪt]", translation = "паводок (от талого снега или дождей)",
            definition = "A sudden rise of a river caused by melting snow or by heavy spring rain.",
            definitionNative = "Резкий подъём реки от тающего снега или сильных весенних дождей.",
            example = "The spring freshet swept logs and branches down the swollen river.",
            exampleNative = "Весенний freshet нёс брёвна и ветви по разлившейся реке.",
            pos = "noun", semanticGroup = "nature_archaic_water", fillInBlankExclusions = listOf(33321L, 33322L, 33324L, 33325L)),

        WordEntity(id = 33324, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "rill", transliteration = "[rɪl]", translation = "ручеёк (поэт., тонкая струйка)",
            definition = "A very small stream of water — a poetic word for a thin trickle in the grass.",
            definitionNative = "Очень маленький водный поток — поэтичное слово для тонкой струйки в траве.",
            example = "A clear rill ran through the meadow toward the old mill.",
            exampleNative = "Прозрачный rill бежал через луг к старой мельнице.",
            pos = "noun", semanticGroup = "nature_archaic_water", fillInBlankExclusions = listOf(33321L, 33322L, 33323L, 33325L)),

        WordEntity(id = 33325, setId = 333, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "slough", transliteration = "[slu]", translation = "топь / болотистая низина",
            definition = "A muddy pool or backwater where slow water gathers among reeds and soft mud.",
            definitionNative = "Грязный пруд или заводь, где медленная вода собирается среди тростника и мягкой грязи.",
            example = "Frogs croaked in the dark slough behind the reed beds.",
            exampleNative = "Лягушки квакали в тёмном slough за тростниковыми зарослями.",
            pos = "noun", semanticGroup = "nature_archaic_water", fillInBlankExclusions = listOf(33321L, 33322L, 33323L, 33324L)),
    )
}
