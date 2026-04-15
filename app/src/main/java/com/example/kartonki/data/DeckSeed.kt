package com.example.kartonki.data

/**
 * Blueprint for a preset PvP deck shipped with the app.
 *
 * Preset decks are stored in each language's WordData file and aggregated
 * by [WordRegistry.allPrebuiltDecks].
 *
 * HOW TO ADD A PRESET DECK:
 * 1. Add a [DeckSeed] entry to the appropriate WordData file
 *    (e.g. WordDataEnglish for en-ru, WordDataHebrew for he-ru).
 * 2. Bump [PresetDecksVersion.CURRENT] by 1.
 * 3. Build and deploy.
 */
data class DeckSeed(
    val name: String,
    val level: Int = 1,
    val wordOriginals: List<String>,
    val languagePair: String = "en-ru",
)
