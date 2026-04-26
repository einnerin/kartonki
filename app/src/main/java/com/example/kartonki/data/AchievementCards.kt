package com.example.kartonki.data

/**
 * Words reserved for achievements — must never appear in packs or the starter collection.
 *
 * Uses [original] strings (stable across DB rebuilds) rather than auto-generated IDs.
 *
 * Per-language: each achievement has both an English (en-ru) reward word and a
 * Hebrew (he-ru) reward word. The user gets the card matching their currently-
 * studied language. [ALL_EXCLUSIVE] is the union across all supported languages
 * — used to filter packs/starter selection (a word reserved for any language is
 * never given out outside the achievement flow).
 *
 * Two tiers per language:
 *  - EXCLUSIVE_LEGENDARY — the most obscure/complex Legendary words for hidden
 *    long-term achievements.
 *  - STARTER_ACHIEVEMENT_REWARDS — Epic words given as rewards for visible
 *    starter achievements (first session, first win, streaks, etc.).
 */
object AchievementCards {

    /** Legendary reward originals across all supported language pairs. */
    val EXCLUSIVE_LEGENDARY: Set<String> = setOf(
        // en-ru
        "diaphanous", "lugubrious", "obstreperous", "abstruse", "meretricious",
        "pellucid", "platitudinous", "recondite", "stentorian", "ineffaceable",
        "sempiternal", "desideratum", "palimpsest", "synecdoche", "solipsism",
        "perspicacious", "solipsistic", "intertextuality", "prolepsis",
        "insouciant", "magniloquent", "pusillanimous", "ossify", "precipitate",
        "attrite", "reify", "ramify", "efflorescence", "metastasise", "fructify",
        // he-ru (Hebrew counterparts of the 15 hidden achievements)
        "שָׁקוּף",         // diaphanous
        "קוֹדֵר",         // lugubrious
        "סוֹעֵר",         // obstreperous
        "סָבוּךְ",         // abstruse
        "רַאֲוָתָנִי",     // meretricious
        "צָלוּל",         // pellucid
        "שִׁגְרָתִי",      // platitudinous
        "כָּמוּס",         // recondite
        "רַעַם",          // stentorian
        "בִּלְתִּי-נִמְחָק", // ineffaceable
        "נִצְחִי",         // sempiternal
        "צֹרֶךְ",          // desideratum
        "דִּמּוּי",         // synecdoche
        "סוֹלִיפְּסִיזְם",   // solipsism
        "חַד-עַיִן",       // perspicacious
    )

    /** Epic starter reward originals across all supported language pairs. */
    val STARTER_ACHIEVEMENT_REWARDS: Set<String> = setOf(
        // en-ru
        "paradigm", "inference", "conjecture", "refute", "elucidate",
        "accomplish", "consistent", "dedicate", "excel", "fluent",
        // he-ru
        "דֶּגֶם",          // paradigm
        "מַסְקָנָה",        // inference
        "הַשְׁעָרָה",      // conjecture
        "לְהַפְרִיךְ",     // refute
        "לְבָאֵר",         // elucidate
        "לְהַשִּׂיג",      // accomplish
        "עִקְבִי",         // consistent
        "לְהַקְדִּישׁ",     // dedicate
        "לְהִצְטַיֵּין",    // excel
        "שׁוֹטֵף",         // fluent
    )

    /** Union of all exclusive originals — used to filter packs and starter selection. */
    val ALL_EXCLUSIVE: Set<String> = EXCLUSIVE_LEGENDARY + STARTER_ACHIEVEMENT_REWARDS
}
