package com.example.kartonki.domain.model

/**
 * Achievement metadata.
 *
 * `rewardWords` maps each supported `languagePair` (e.g. `"en-ru"`, `"he-ru"`) to
 * the `original` of the reward card the user receives when unlocking this
 * achievement while studying that language. Adding a new language is one entry
 * per achievement — no other code change required (DAO, UI, repository all
 * read the language at runtime via [rewardOriginalFor]).
 *
 * `rewardWordTranslation` is the Russian gloss of the reward concept — single
 * for now because native-language is always Russian. When mult-native lands,
 * this becomes a parallel `Map<String, String>`.
 */
enum class AchievementId(
    val title: String,
    val description: String,
    val icon: String,
    val rewardWords: Map<String, String>,
    val rewardWordTranslation: String,
    val isHidden: Boolean = false,
) {
    // ── Visible achievements ──────────────────────────────────────────────────

    FIRST_LESSON(
        title = "Первые шаги",
        description = "Завершить первую учебную сессию",
        icon = "🌱",
        rewardWords = mapOf(
            "en-ru" to "paradigm",
            "he-ru" to "דֶּגֶם",
        ),
        rewardWordTranslation = "парадигма / образец",
    ),
    DILIGENT(
        title = "Прилежный",
        description = "Заниматься 10 разных дней",
        icon = "📖",
        rewardWords = mapOf(
            "en-ru" to "inference",
            "he-ru" to "מַסְקָנָה",
        ),
        rewardWordTranslation = "умозаключение",
    ),
    FIRST_FIGHT(
        title = "Первый бой",
        description = "Сыграть первый PvP матч",
        icon = "⚔️",
        rewardWords = mapOf(
            "en-ru" to "conjecture",
            "he-ru" to "הַשְׁעָרָה",
        ),
        rewardWordTranslation = "предположение / гипотеза",
    ),
    FIRST_WIN(
        title = "Победитель",
        description = "Выиграть первый PvP матч",
        icon = "🏆",
        rewardWords = mapOf(
            "en-ru" to "refute",
            "he-ru" to "לְהַפְרִיךְ",
        ),
        rewardWordTranslation = "опровергать",
    ),
    STREAK_5(
        title = "В потоке",
        description = "Учиться 5 дней подряд",
        icon = "🔥",
        rewardWords = mapOf(
            "en-ru" to "elucidate",
            "he-ru" to "לְבָאֵר",
        ),
        rewardWordTranslation = "разъяснять",
    ),
    EXPERT(
        title = "Знаток",
        description = "Изучить 50 слов (уровень 3+)",
        icon = "📚",
        rewardWords = mapOf(
            "en-ru" to "accomplish",
            "he-ru" to "לְהַשִּׂיג",
        ),
        rewardWordTranslation = "достигать",
    ),
    POLYGLOT(
        title = "Полиглот",
        description = "Изучить 200 слов",
        icon = "🌍",
        rewardWords = mapOf(
            "en-ru" to "fluent",
            "he-ru" to "שׁוֹטֵף",
        ),
        rewardWordTranslation = "свободно владеющий языком",
    ),
    STREAK_7(
        title = "Серия",
        description = "Учиться 7 дней подряд",
        icon = "⚡",
        rewardWords = mapOf(
            "en-ru" to "consistent",
            "he-ru" to "עִקְבִי",
        ),
        rewardWordTranslation = "последовательный",
    ),
    COLLECTOR(
        title = "Коллекционер",
        description = "Собрать полную колоду из 20 карточек",
        icon = "🎴",
        rewardWords = mapOf(
            "en-ru" to "dedicate",
            "he-ru" to "לְהַקְדִּישׁ",
        ),
        rewardWordTranslation = "посвящать",
    ),
    LEGEND(
        title = "Легенда",
        description = "Получить все видимые достижения",
        icon = "⭐",
        rewardWords = mapOf(
            "en-ru" to "excel",
            "he-ru" to "לְהִצְטַיֵּין",
        ),
        rewardWordTranslation = "преуспевать / выделяться",
    ),

    // ── Hidden achievements ───────────────────────────────────────────────────
    // Title and description are revealed only when unlocked.
    // Reward is one of the exclusive Legendary cards.

    DOMINATOR(
        title = "Доминатор",
        description = "Выиграть PvP матч с перевесом в счёте в 2 и более раза",
        icon = "👑",
        rewardWords = mapOf(
            "en-ru" to "diaphanous",
            "he-ru" to "שָׁקוּף",
        ),
        rewardWordTranslation = "прозрачный / тонкий",
        isHidden = true,
    ),
    NIGHT_OWL(
        title = "Ночная сова",
        description = "Пройти учебную сессию после 23:00",
        icon = "🦉",
        rewardWords = mapOf(
            "en-ru" to "lugubrious",
            "he-ru" to "קוֹדֵר",
        ),
        rewardWordTranslation = "мрачный / унылый",
        isHidden = true,
    ),
    PERFECTIONIST(
        title = "Перфекционист",
        description = "Пройти учебную сессию без единой ошибки",
        icon = "💎",
        rewardWords = mapOf(
            "en-ru" to "obstreperous",
            "he-ru" to "סוֹעֵר",
        ),
        rewardWordTranslation = "шумный / буйный",
        isHidden = true,
    ),
    DEEP_LEARNER(
        title = "Мастер слов",
        description = "Довести 20 слов до максимального уровня",
        icon = "🧠",
        rewardWords = mapOf(
            "en-ru" to "abstruse",
            "he-ru" to "סָבוּךְ",
        ),
        rewardWordTranslation = "трудный для понимания",
        isHidden = true,
    ),
    VETERAN(
        title = "Ветеран",
        description = "Провести 10 PvP матчей",
        icon = "🎖️",
        rewardWords = mapOf(
            "en-ru" to "meretricious",
            "he-ru" to "רַאֲוָתָנִי",
        ),
        rewardWordTranslation = "мишурный / показной",
        isHidden = true,
    ),
    CENTURION(
        title = "Центурион",
        description = "Дать 100 правильных ответов суммарно",
        icon = "🛡️",
        rewardWords = mapOf(
            "en-ru" to "pellucid",
            "he-ru" to "צָלוּל",
        ),
        rewardWordTranslation = "кристально ясный",
        isHidden = true,
    ),
    DRAW_MASTER(
        title = "Миротворец",
        description = "Завершить PvP матч вничью",
        icon = "🤝",
        rewardWords = mapOf(
            "en-ru" to "platitudinous",
            "he-ru" to "שִׁגְרָתִי",
        ),
        rewardWordTranslation = "банальный",
        isHidden = true,
    ),
    MONDAY_SCHOLAR(
        title = "Понедельник — день тяжёлый",
        description = "Пройти учебную сессию в понедельник",
        icon = "📅",
        rewardWords = mapOf(
            "en-ru" to "recondite",
            "he-ru" to "כָּמוּס",
        ),
        rewardWordTranslation = "малоизвестный / сокровенный",
        isHidden = true,
    ),
    GOLDEN_SHOT(
        title = "Золотой выстрел",
        description = "Набрать 50 очков в одном PvP матче",
        icon = "✨",
        rewardWords = mapOf(
            "en-ru" to "stentorian",
            "he-ru" to "רַעַם",
        ),
        rewardWordTranslation = "громоподобный",
        isHidden = true,
    ),
    WEEKLY_GRIND(
        title = "Недельный марафон",
        description = "Заниматься 5 дней в течение одной недели",
        icon = "🗓️",
        rewardWords = mapOf(
            "en-ru" to "ineffaceable",
            "he-ru" to "בִּלְתִּי-נִמְחָק",
        ),
        rewardWordTranslation = "неизгладимый",
        isHidden = true,
    ),
    WHITE_FLAG(
        title = "Честное поражение",
        description = "Сдаться в PvP матче",
        icon = "🏳️",
        rewardWords = mapOf(
            "en-ru" to "sempiternal",
            "he-ru" to "נִצְחִי",
        ),
        rewardWordTranslation = "вечный",
        isHidden = true,
    ),
    EXPLORER(
        title = "Исследователь",
        description = "Изучить слова из 5 разных тематических групп",
        icon = "🗺️",
        rewardWords = mapOf(
            "en-ru" to "desideratum",
            "he-ru" to "צֹרֶךְ",
        ),
        rewardWordTranslation = "насущная потребность",
        isHidden = true,
    ),
    MARATHON(
        title = "Марафон",
        description = "Провести 3 PvP матча за один день",
        icon = "🏃",
        rewardWords = mapOf(
            "en-ru" to "synecdoche",
            "he-ru" to "דִּמּוּי",
        ),
        rewardWordTranslation = "синекдоха / сравнение",
        isHidden = true,
    ),
    RUSTY(
        title = "Возвращение",
        description = "Вернуться к учёбе после 7-дневного перерыва",
        icon = "🦀",
        rewardWords = mapOf(
            "en-ru" to "solipsism",
            "he-ru" to "סוֹלִיפְּסִיזְם",
        ),
        rewardWordTranslation = "солипсизм",
        isHidden = true,
    ),
    LONG_WORD(
        title = "Буквоед",
        description = "Выучить слово длиннее 12 символов",
        icon = "🔤",
        rewardWords = mapOf(
            "en-ru" to "perspicacious",
            "he-ru" to "חַד-עַיִן",
        ),
        rewardWordTranslation = "проницательный",
        isHidden = true,
    ),
    ;

    /**
     * Returns the reward word `original` for the given language pair.
     * Falls back to `en-ru` if the language doesn't have a dedicated reward
     * (e.g. a future language that hasn't been authored yet).
     */
    fun rewardOriginalFor(languagePair: String): String =
        rewardWords[languagePair]
            ?: rewardWords["en-ru"]
            ?: error("AchievementId.$name has no reward word for any language")
}

data class AchievementState(
    val id: AchievementId,
    val unlockedAt: Long?,
    val rewardWordId: Long?,
) {
    val isUnlocked: Boolean get() = unlockedAt != null
}
