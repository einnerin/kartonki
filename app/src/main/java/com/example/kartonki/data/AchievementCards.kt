package com.example.kartonki.data

/**
 * Words reserved for achievements — must never appear in packs or the starter collection.
 *
 * Uses [original] strings (stable across DB rebuilds) rather than auto-generated IDs.
 *
 * Two tiers:
 *  - [EXCLUSIVE_LEGENDARY] — the 30 most obscure/complex Legendary words,
 *    reserved for challenging long-term achievements.
 *  - [STARTER_ACHIEVEMENT_REWARDS] — a handful of Epic words given as
 *    rewards for easy first-time achievements (first session, first win,
 *    streak milestones, etc.).
 */
object AchievementCards {

    /**
     * The 30 most linguistically obscure Legendary words.
     * Excluded from packs and starter selection — only obtainable via achievements.
     */
    val EXCLUSIVE_LEGENDARY: Set<String> = setOf(
        "diaphanous",      // прозрачный/тонкий
        "lugubrious",      // мрачный/унылый
        "obstreperous",    // шумный/буйный
        "abstruse",        // трудный для понимания
        "meretricious",    // мишурный/показной
        "pellucid",        // кристально ясный
        "platitudinous",   // банальный
        "recondite",       // малоизвестный/сокровенный
        "stentorian",      // громоподобный
        "ineffaceable",    // неизгладимый
        "sempiternal",     // вечный
        "desideratum",     // насущная потребность
        "palimpsest",      // палимпсест
        "synecdoche",      // синекдоха
        "solipsism",       // солипсизм
        "perspicacious",   // проницательный
        "solipsistic",     // солипсистский
        "intertextuality", // интертекстуальность
        "prolepsis",       // пролепсис
        "insouciant",      // беззаботный/безразличный
        "magniloquent",    // напыщенный/высокопарный
        "pusillanimous",   // малодушный
        "ossify",          // окостеневать/коснеть
        "precipitate",     // стремительно вызывать (гл.)
        "attrite",         // постепенно истощать
        "reify",           // реифицировать
        "ramify",          // разветвляться
        "efflorescence",   // расцвет/пышное развитие
        "metastasise",     // метастазировать/разрастаться
        "fructify",        // давать плоды/приносить пользу
    )

    /**
     * Epic words reserved as rewards for easy starter achievements.
     * Also excluded from packs and starter selection so they feel earned.
     *
     * Suggested award mapping (to be wired up when achievements are implemented):
     *   paradigm   — "Complete your first study session"
     *   inference  — "Complete 3 study sessions"
     *   conjecture — "Play your first PvP match"
     *   refute     — "Win your first PvP match"
     *   elucidate  — "Study 5 days in a row"
     */
    val STARTER_ACHIEVEMENT_REWARDS: Set<String> = setOf(
        "paradigm",   // парадигма
        "inference",  // умозаключение
        "conjecture", // предположение/гипотеза
        "refute",     // опровергать
        "elucidate",  // разъяснять
        "accomplish", // достигать — EXPERT
        "consistent", // последовательный — STREAK_5/STREAK_7
        "dedicate",   // посвящать — COLLECTOR
        "excel",      // преуспевать — LEGEND
    )

    /** Union of all exclusive originals — used to filter packs and starter selection. */
    val ALL_EXCLUSIVE: Set<String> = EXCLUSIVE_LEGENDARY + STARTER_ACHIEVEMENT_REWARDS
}
