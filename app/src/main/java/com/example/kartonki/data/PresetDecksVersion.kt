package com.example.kartonki.data

/**
 * Version of the preset deck definitions.
 *
 * HOW TO UPDATE PRESET DECKS:
 * 1. Edit the relevant WordData file's prebuiltDecks (en-ru → WordDataEnglish, he-ru → WordDataHebrew, etc.).
 * 2. Bump [CURRENT] by 1.
 * 3. Build and deploy.
 *
 * On the next launch CollectionRepository detects the stale version,
 * deletes all preset decks (isPreset = true), and recreates them from
 * the new definitions. User-created decks (isPreset = false) are untouched.
 * New words required by the updated decks are also added to the collection.
 */
object PresetDecksVersion {
    const val CURRENT = 19
}
