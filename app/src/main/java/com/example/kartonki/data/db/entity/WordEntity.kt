package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * A single vocabulary word in the database.
 *
 * Uniqueness is enforced at the DB level: no two rows may share the same
 * (original, languagePair) pair, preventing silent duplicates across seed files.
 *
 * [isDefaultPvpCard] — true for the fixed ~500-card starter collection that every
 * user receives regardless of their study progress. Marked in seed data; used by
 * CollectionRepository to build a deterministic, identical starter set for all users.
 */
@Entity(
    tableName = "words",
    indices = [Index(value = ["original", "languagePair"], unique = true)],
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
)
