package com.example.kartonki.domain.model

data class Word(
    val id: Long = 0,
    val original: String,
    val translation: String,
    val definition: String? = null,          // definition in the foreign language
    val definitionNative: String? = null,    // definition in the native language (Russian)
    val example: String? = null,             // example sentence in the foreign language
    val exampleNative: String? = null,       // example sentence in the native language (Russian)
    val rarity: Rarity,
    val languagePair: String = "en-ru",
    val pos: String? = null,
    val semanticGroup: String? = null,
    val transliteration: String? = null,
    val isFillInBlankSafe: Boolean = true,   // false → skip this word in FILL_IN_BLANK quiz
    val fillInBlankExclusions: List<Long> = emptyList(), // words that also fit this example's blank — filtered from FILL_IN_BLANK distractors
)
