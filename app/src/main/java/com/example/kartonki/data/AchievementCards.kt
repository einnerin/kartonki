package com.example.kartonki.data

/**
 * Word IDs that are reserved for achievements and must never appear
 * in packs or the starter collection.
 *
 * Two tiers:
 *  - EXCLUSIVE_LEGENDARY — the 30 most obscure/complex Legendary words,
 *    reserved for challenging long-term achievements.
 *  - STARTER_ACHIEVEMENT_REWARDS — a handful of Epic words given as
 *    rewards for easy first-time achievements (first session, first win,
 *    streak milestones, etc.).
 */
object AchievementCards {

    /**
     * The 30 most linguistically obscure Legendary words.
     * Excluded from packs and starter selection — only obtainable via achievements.
     */
    val EXCLUSIVE_LEGENDARY_IDS: Set<Long> = setOf(
        1880L, // diaphanous      — прозрачный/тонкий
        1881L, // lugubrious      — мрачный/унылый
        1885L, // obstreperous    — шумный/буйный
        1886L, // abstruse        — трудный для понимания
        1888L, // meretricious    — мишурный/показной
        1890L, // pellucid        — кристально ясный
        1893L, // platitudinous   — банальный
        1894L, // recondite       — малоизвестный/сокровенный
        1895L, // stentorian      — громоподобный
        1899L, // ineffaceable    — неизгладимый
        1900L, // sempiternal     — вечный
        1914L, // desideratum     — насущная потребность
        1916L, // palimpsest      — палимпсест
        1920L, // synecdoche      — синекдоха
        1925L, // solipsism       — солипсизм
        1927L, // perspicacious   — проницательный
        1931L, // solipsistic     — солипсистский
        1999L, // intertextuality — интертекстуальность
        2000L, // prolepsis       — пролепсис
        2008L, // insouciant      — беззаботный/безразличный
        2021L, // magniloquent    — напыщенный/высокопарный
        2023L, // pusillanimous   — малодушный
        2037L, // ossify          — окостеневать/коснеть
        2041L, // precipitate     — стремительно вызывать (гл.)
        2045L, // attrite         — постепенно истощать
        2046L, // reify           — реифицировать
        2065L, // ramify          — разветвляться
        2066L, // efflorescence   — расцвет/пышное развитие
        2067L, // metastasise     — метастазировать/разрастаться
        2069L, // fructify        — давать плоды/приносить пользу
    )

    /**
     * Epic words reserved as rewards for easy starter achievements.
     * Also excluded from packs and starter selection so they feel earned.
     *
     * Suggested award mapping (to be wired up when achievements are implemented):
     *   paradigm  (1456) — "Complete your first study session"
     *   inference (1462) — "Complete 3 study sessions"
     *   conjecture(1464) — "Play your first PvP match"
     *   refute    (1467) — "Win your first PvP match"
     *   elucidate (1471) — "Study 5 days in a row"
     */
    val STARTER_ACHIEVEMENT_REWARD_IDS: Set<Long> = setOf(
        1456L, // paradigm   — парадигма
        1462L, // inference  — умозаключение
        1464L, // conjecture — предположение/гипотеза
        1467L, // refute     — опровергать
        1471L, // elucidate  — разъяснять
    )

    /** Union of all exclusive IDs — used to filter packs and starter selection. */
    val ALL_EXCLUSIVE_IDS: Set<Long> = EXCLUSIVE_LEGENDARY_IDS + STARTER_ACHIEVEMENT_REWARD_IDS
}
