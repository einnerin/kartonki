package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Single source of truth for all seed word/set/deck data.
 *
 * HOW TO ADD A NEW LANGUAGE:
 * 1. Create WordData<Language>.kt (and split files if needed, e.g. WordData<Language>Expanded.kt).
 * 2. Add the new object's sets and words to [allSets] and [allWords] below.
 * 3. Add the new language's preset decks property to [allPrebuiltDecks].
 * 4. Add the new language ID block to [languageIdBlocks].
 * 5. Bump [WordDataVersion.CURRENT] and [PresetDecksVersion.CURRENT].
 *
 * That's the only file you need to touch outside the new WordData file itself.
 */
object WordRegistry {

    val allSets: List<WordSetEntity> by lazy {
        WordDataEnglish.sets + WordDataEnglishExpanded.sets +
                WordDataEnglishBatch3.sets +
                WordDataEnglishBatch4.sets +
                WordDataEnglishBatch5.sets +
                WordDataEnglishBatch6.sets +
                WordDataEnglishBatch7.sets +
                WordDataEnglishBatch8.sets +
                WordDataEnglishBatch9.sets +
                WordDataEnglishBatch10.sets +
                WordDataEnglishBatch11.sets +
                WordDataEnglishBatch12.sets +
                WordDataHebrew.sets + WordDataHebrewEveryday.sets +
                WordDataHebrewMore.sets + WordDataHebrewAdvanced.sets +
                WordDataHebrewTech.sets +
                WordDataHebrewImmigrant.sets +
                WordDataHebrewImmigrant2.sets +
                WordDataHebrewImmigrant3.sets +
                WordDataHebrewImmigrant4.sets +
                WordDataHebrewImmigrant5.sets +
                WordDataHebrewImmigrant6.sets +
                WordDataHebrewBatch5.sets +
                WordDataHebrewBatch6.sets +
                WordDataHebrewBatch7.sets +
                WordDataHebrewBatch8.sets +
                WordDataHebrewBatch9.sets +
                WordDataHebrewBatch10.sets +
                WordDataHebrewBatch11.sets +
                WordDataHebrewBatch12.sets +
                WordDataHebrewBatch13.sets +
                WordDataHebrewBatch14.sets +
                WordDataHebrewBatch15.sets +
                WordDataHebrewBatch16.sets +
                WordDataHebrewBatch17.sets +
                WordDataHebrewBatch18.sets +
                WordDataHebrewBatch19.sets +
                WordDataHebrewBatch20.sets +
                WordDataHebrewBatch21.sets +
                WordDataHebrewBatch22.sets +
                WordDataHebrewBatch23.sets +
                WordDataHebrewBatch24.sets +
                WordDataHebrewBatch25.sets +
                WordDataHebrewBatch26.sets +
                WordDataHebrewBatch27.sets +
                WordDataHebrewBatch28.sets +
                WordDataHebrewBatch29.sets +
                WordDataHebrewBatch30.sets +
                WordDataHebrewBatch31.sets +
                WordDataHebrewBatch32.sets +
                WordDataHebrewBatch33.sets +
                WordDataHebrewBatch34.sets +
                WordDataHebrewBatch35.sets +
                WordDataHebrewBatch36.sets +
                WordDataHebrewBatch37.sets +
                WordDataHebrewBatch38.sets +
                WordDataHebrewBatch39.sets +
                WordDataHebrewImmigrant7.sets +
                WordDataHebrewImmigrant8.sets +
                WordDataHebrewImmigrant9.sets +
                WordDataHebrewImmigrant10.sets +
                WordDataHebrewImmigrant11.sets +
                WordDataHebrewImmigrant12.sets +
                WordDataHebrewImmigrant13.sets +
                WordDataHebrewImmigrant14.sets +
                WordDataHebrewImmigrant15.sets +
                WordDataHebrewImmigrant16.sets +
                WordDataHebrewBatch40.sets +
                WordDataHebrewBatch41.sets +
                WordDataHebrewBatch42.sets +
                WordDataHebrewBatch43.sets +
                WordDataHebrewBatch44.sets +
                WordDataHebrewBatch45.sets +
                WordDataHebrewBatch46.sets +
                WordDataHebrewBatch47.sets +
                WordDataHebrewBatch48.sets +
                WordDataHebrewBatch49.sets +
                WordDataHebrewBatch50.sets +
                WordDataHebrewBatch51.sets +
                WordDataHebrewBatch52.sets +
                WordDataHebrewBatch53.sets +
                WordDataHebrewBatch54.sets +
                WordDataHebrewBatch55.sets +
                WordDataHebrewBatch56.sets +
                WordDataHebrewBatch57.sets +
                WordDataHebrewBatch58.sets +
                WordDataHebrewBatch59.sets +
                WordDataHebrewBatch60.sets +
                WordDataHebrewBatch61.sets +
                WordDataHebrewBatch62.sets +
                WordDataHebrewBatch63.sets +
                WordDataHebrewBatch64.sets +
                WordDataHebrewBatch65.sets +
                WordDataHebrewBatch66.sets +
                WordDataHebrewBatch67.sets +
                WordDataHebrewBatch68.sets +
                WordDataHebrewBatch69.sets +
                WordDataHebrewBatch70.sets +
                WordDataHebrewBatch71.sets +
                WordDataHebrewBatch72.sets
    }

    val allWords: List<WordEntity> by lazy {
        WordDataEnglish.words + WordDataEnglishExpanded.words +
                WordDataEnglishExpanded.achievementRewardWords() +
                WordDataEnglishBatch3.words +
                WordDataEnglishBatch4.words +
                WordDataEnglishBatch5.words +
                WordDataEnglishBatch6.words +
                WordDataEnglishBatch7.words +
                WordDataEnglishBatch8.words +
                WordDataEnglishBatch9.words +
                WordDataEnglishBatch10.words +
                WordDataEnglishBatch11.words +
                WordDataEnglishBatch12.words +
                WordDataHebrew.words + WordDataHebrewEveryday.words +
                WordDataHebrewMore.words + WordDataHebrewAdvanced.words +
                WordDataHebrewTech.words +
                WordDataHebrewImmigrant.words +
                WordDataHebrewImmigrant2.words +
                WordDataHebrewImmigrant3.words +
                WordDataHebrewImmigrant4.words +
                WordDataHebrewImmigrant5.words +
                WordDataHebrewImmigrant6.words +
                WordDataHebrewImmigrantExtra.words +
                WordDataHebrewBatch5.words +
                WordDataHebrewBatch6.words +
                WordDataHebrewBatch7.words +
                WordDataHebrewBatch8.words +
                WordDataHebrewBatch9.words +
                WordDataHebrewBatch10.words +
                WordDataHebrewBatch11.words +
                WordDataHebrewBatch12.words +
                WordDataHebrewBatch13.words +
                WordDataHebrewBatch14.words +
                WordDataHebrewBatch15.words +
                WordDataHebrewBatch16.words +
                WordDataHebrewBatch17.words +
                WordDataHebrewBatch18.words +
                WordDataHebrewBatch19.words +
                WordDataHebrewBatch20.words +
                WordDataHebrewBatch21.words +
                WordDataHebrewBatch22.words +
                WordDataHebrewBatch23.words +
                WordDataHebrewBatch24.words +
                WordDataHebrewBatch25.words +
                WordDataHebrewBatch26.words +
                WordDataHebrewBatch27.words +
                WordDataHebrewBatch28.words +
                WordDataHebrewBatch29.words +
                WordDataHebrewBatch30.words +
                WordDataHebrewBatch31.words +
                WordDataHebrewBatch32.words +
                WordDataHebrewBatch33.words +
                WordDataHebrewBatch34.words +
                WordDataHebrewBatch35.words +
                WordDataHebrewBatch36.words +
                WordDataHebrewBatch37.words +
                WordDataHebrewBatch38.words +
                WordDataHebrewBatch39.words +
                WordDataHebrewImmigrant7.words +
                WordDataHebrewImmigrant8.words +
                WordDataHebrewImmigrant9.words +
                WordDataHebrewImmigrant10.words +
                WordDataHebrewImmigrant11.words +
                WordDataHebrewImmigrant12.words +
                WordDataHebrewImmigrant13.words +
                WordDataHebrewImmigrant14.words +
                WordDataHebrewImmigrant15.words +
                WordDataHebrewImmigrant16.words +
                WordDataHebrewBatch40.words +
                WordDataHebrewBatch41.words +
                WordDataHebrewBatch42.words +
                WordDataHebrewBatch43.words +
                WordDataHebrewBatch44.words +
                WordDataHebrewBatch45.words +
                WordDataHebrewBatch46.words +
                WordDataHebrewBatch47.words +
                WordDataHebrewBatch48.words +
                WordDataHebrewBatch49.words +
                WordDataHebrewBatch50.words +
                WordDataHebrewBatch51.words +
                WordDataHebrewBatch52.words +
                WordDataHebrewBatch53.words +
                WordDataHebrewBatch54.words +
                WordDataHebrewBatch55.words +
                WordDataHebrewBatch56.words +
                WordDataHebrewBatch57.words +
                WordDataHebrewBatch58.words +
                WordDataHebrewBatch59.words +
                WordDataHebrewBatch60.words +
                WordDataHebrewBatch61.words +
                WordDataHebrewBatch62.words +
                WordDataHebrewBatch63.words +
                WordDataHebrewBatch64.words +
                WordDataHebrewBatch65.words +
                WordDataHebrewBatch66.words +
                WordDataHebrewBatch67.words +
                WordDataHebrewBatch68.words +
                WordDataHebrewBatch69.words +
                WordDataHebrewBatch70.words +
                WordDataHebrewBatch71.words +
                WordDataHebrewBatch72.words
    }

    val allPrebuiltDecks: List<DeckSeed> by lazy {
        WordDataEnglish.prebuiltDecks + WordDataHebrew.prebuiltDecks
    }

    /**
     * Valid set-ID ranges per language pair.
     * Word IDs follow the formula: setId × 100 + position (1–99).
     *
     * Add a new entry here when a new language pair is introduced.
     * Convention: allocate blocks of 1000 (e.g. fr-ru → 2001..2999).
     */
    val languageIdBlocks: Map<String, IntRange> = mapOf(
        "en-ru" to 1..999,
        "he-ru" to 1001..1999,
    )
}
