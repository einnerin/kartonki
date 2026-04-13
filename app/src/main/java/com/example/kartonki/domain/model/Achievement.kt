package com.example.kartonki.domain.model

enum class AchievementId(
    val title: String,
    val description: String,
    val icon: String,
    val rewardWordOriginal: String,
    val isHidden: Boolean = false,
) {
    // ── Visible achievements ──────────────────────────────────────────────────

    FIRST_LESSON(
        title = "Первые шаги",
        description = "Завершить первую учебную сессию",
        icon = "🌱",
        rewardWordOriginal = "paradigm",
    ),
    DILIGENT(
        title = "Прилежный",
        description = "Заниматься 10 разных дней",
        icon = "📖",
        rewardWordOriginal = "inference",
    ),
    FIRST_FIGHT(
        title = "Первый бой",
        description = "Сыграть первый PvP матч",
        icon = "⚔️",
        rewardWordOriginal = "conjecture",
    ),
    FIRST_WIN(
        title = "Победитель",
        description = "Выиграть первый PvP матч",
        icon = "🏆",
        rewardWordOriginal = "refute",
    ),
    STREAK_5(
        title = "В потоке",
        description = "Учиться 5 дней подряд",
        icon = "🔥",
        rewardWordOriginal = "elucidate",
    ),
    EXPERT(
        title = "Знаток",
        description = "Изучить 50 слов (уровень 3+)",
        icon = "📚",
        rewardWordOriginal = "accomplish",
    ),
    POLYGLOT(
        title = "Полиглот",
        description = "Изучить 200 слов",
        icon = "🌍",
        rewardWordOriginal = "fluent",
    ),
    STREAK_7(
        title = "Серия",
        description = "Учиться 7 дней подряд",
        icon = "⚡",
        rewardWordOriginal = "consistent",
    ),
    COLLECTOR(
        title = "Коллекционер",
        description = "Собрать полную колоду из 20 карточек",
        icon = "🎴",
        rewardWordOriginal = "dedicate",
    ),
    LEGEND(
        title = "Легенда",
        description = "Получить все видимые достижения",
        icon = "⭐",
        rewardWordOriginal = "excel",
    ),

    // ── Hidden achievements ───────────────────────────────────────────────────
    // Title and description are revealed only when unlocked.
    // Reward is one of the 30 exclusive Legendary cards.

    DOMINATOR(
        title = "Доминатор",
        description = "Выиграть PvP матч с перевесом в счёте в 2 и более раза",
        icon = "👑",
        rewardWordOriginal = "diaphanous",
        isHidden = true,
    ),
    NIGHT_OWL(
        title = "Ночная сова",
        description = "Пройти учебную сессию после 23:00",
        icon = "🦉",
        rewardWordOriginal = "lugubrious",
        isHidden = true,
    ),
    PERFECTIONIST(
        title = "Перфекционист",
        description = "Пройти учебную сессию без единой ошибки",
        icon = "💎",
        rewardWordOriginal = "obstreperous",
        isHidden = true,
    ),
    DEEP_LEARNER(
        title = "Мастер слов",
        description = "Довести 20 слов до максимального уровня",
        icon = "🧠",
        rewardWordOriginal = "abstruse",
        isHidden = true,
    ),
    VETERAN(
        title = "Ветеран",
        description = "Провести 10 PvP матчей",
        icon = "🎖️",
        rewardWordOriginal = "meretricious",
        isHidden = true,
    ),
    CENTURION(
        title = "Центурион",
        description = "Дать 100 правильных ответов суммарно",
        icon = "🛡️",
        rewardWordOriginal = "pellucid",
        isHidden = true,
    ),
    DRAW_MASTER(
        title = "Миротворец",
        description = "Завершить PvP матч вничью",
        icon = "🤝",
        rewardWordOriginal = "platitudinous",
        isHidden = true,
    ),
    MONDAY_SCHOLAR(
        title = "Понедельник — день тяжёлый",
        description = "Пройти учебную сессию в понедельник",
        icon = "📅",
        rewardWordOriginal = "recondite",
        isHidden = true,
    ),
    GOLDEN_SHOT(
        title = "Золотой выстрел",
        description = "Набрать 50 очков в одном PvP матче",
        icon = "✨",
        rewardWordOriginal = "stentorian",
        isHidden = true,
    ),
    WEEKLY_GRIND(
        title = "Недельный марафон",
        description = "Заниматься 5 дней в течение одной недели",
        icon = "🗓️",
        rewardWordOriginal = "ineffaceable",
        isHidden = true,
    ),
    WHITE_FLAG(
        title = "Честное поражение",
        description = "Сдаться в PvP матче",
        icon = "🏳️",
        rewardWordOriginal = "sempiternal",
        isHidden = true,
    ),
    EXPLORER(
        title = "Исследователь",
        description = "Изучить слова из 5 разных тематических групп",
        icon = "🗺️",
        rewardWordOriginal = "desideratum",
        isHidden = true,
    ),
    MARATHON(
        title = "Марафон",
        description = "Провести 3 PvP матча за один день",
        icon = "🏃",
        rewardWordOriginal = "synecdoche",
        isHidden = true,
    ),
    RUSTY(
        title = "Возвращение",
        description = "Вернуться к учёбе после 7-дневного перерыва",
        icon = "🦀",
        rewardWordOriginal = "solipsism",
        isHidden = true,
    ),
    LONG_WORD(
        title = "Буквоед",
        description = "Выучить слово длиннее 12 символов",
        icon = "🔤",
        rewardWordOriginal = "perspicacious",
        isHidden = true,
    ),
}

data class AchievementState(
    val id: AchievementId,
    val unlockedAt: Long?,
    val rewardWordId: Long?,
) {
    val isUnlocked: Boolean get() = unlockedAt != null
}
