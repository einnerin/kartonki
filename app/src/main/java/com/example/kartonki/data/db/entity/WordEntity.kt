package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * A single vocabulary word in the database.
 *
 * The same word may appear in multiple sets (different topics). The index on
 * (original, languagePair) is non-unique — it exists for query performance only.
 *
 * [isDefaultPvpCard] — true for the fixed ~500-card starter collection that every
 * user receives regardless of their study progress. Marked in seed data; used by
 * CollectionRepository to build a deterministic, identical starter set for all users.
 *
 * [isFillInBlankSafe] — false for words whose `example` cannot be disambiguated
 * at all (e.g. "I saw a ___" — any noun fits). QuizBuilder skips this type for
 * unsafe words. Default true. For the ordinary case where a few specific words
 * would also fit the blank, use [fillInBlankExclusions] instead.
 *
 * [fillInBlankExclusions] — IDs of other words in the same set whose meaning
 * also fits this word's example sentence. QuizBuilder removes them from the
 * distractor pool for FILL_IN_BLANK quiz, so the player never sees a distractor
 * that would also have been correct. Populated by the LLM labeling pipeline
 * (see docs/claude/fill-in-blank-pipeline.md).
 */
@Entity(
    tableName = "words",
    indices = [
        Index(value = ["original", "languagePair"]),
        // Hot WHERE filters in WordDao queries — without these Room does a
        // table scan over ~17k seeded rows on every call.
        Index(value = ["languagePair"]),
        Index(value = ["rarity"]),
        Index(value = ["isDefaultPvpCard"]),
        Index(value = ["semanticGroup", "languagePair"]),
        Index(value = ["setId"]),
    ],
)
data class WordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val original: String,
    val translation: String,
    val definition: String? = null,          // definition in the foreign language
    val definitionNative: String? = null,    // definition in the native language (Russian)
    val example: String? = null,             // example sentence in the foreign language
    val exampleNative: String? = null,       // example sentence in the native language (Russian)
    val rarity: String,
    val languagePair: String = "en-ru",
    val setId: Long = 0,
    val pos: String? = null,
    val semanticGroup: String? = null,
    val transliteration: String? = null,
    val isDefaultPvpCard: Boolean = false,   // part of the fixed starter PvP collection
    val isFillInBlankSafe: Boolean = true,   // false → skip this word in FILL_IN_BLANK quiz
    val fillInBlankExclusions: List<Long> = emptyList(), // IDs of words that also fit this example's blank
)
