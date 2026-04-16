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

    val allSets: List<WordSetEntity>
        get() = WordDataEnglish.sets + WordDataEnglishExpanded.sets +
                WordDataEnglishBatch3.sets +
                WordDataEnglishBatch4.sets +
                WordDataEnglishBatch5.sets +
                WordDataEnglishBatch6.sets +
                WordDataHebrew.sets + WordDataHebrewEveryday.sets +
                WordDataHebrewMore.sets + WordDataHebrewAdvanced.sets +
                WordDataHebrewTech.sets +
                WordDataHebrewImmigrant.sets +
                WordDataHebrewImmigrant2.sets +
                WordDataHebrewImmigrant3.sets +
                WordDataHebrewImmigrant4.sets +
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
                WordDataHebrewBatch18.sets

    val allWords: List<WordEntity>
        get() = WordDataEnglish.words + WordDataEnglishExpanded.words +
                WordDataEnglishExpanded.achievementRewardWords() +
                WordDataEnglishBatch3.words +
                WordDataEnglishBatch4.words +
                WordDataEnglishBatch5.words +
                WordDataEnglishBatch6.words +
                WordDataHebrew.words + WordDataHebrewEveryday.words +
                WordDataHebrewMore.words + WordDataHebrewAdvanced.words +
                WordDataHebrewTech.words +
                WordDataHebrewImmigrant.words +
                WordDataHebrewImmigrant2.words +
                WordDataHebrewImmigrant3.words +
                WordDataHebrewImmigrant4.words +
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
                WordDataHebrewBatch18.words

    val allPrebuiltDecks: List<DeckSeed>
        get() = WordDataEnglish.prebuiltDecks + WordDataHebrew.prebuiltDecks

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
