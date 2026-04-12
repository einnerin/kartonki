package com.example.kartonki.domain.model

enum class AchievementId(
    val title: String,
    val description: String,
    val icon: String,
    val rewardWordOriginal: String,
) {
    FIRST_STEPS(
        title = "Первые шаги",
        description = "Ответить правильно на 10 заданий",
        icon = "🌱",
        rewardWordOriginal = "persevere",
    ),
    EXPERT(
        title = "Знаток",
        description = "Изучить 50 слов (достичь 3-го уровня)",
        icon = "📚",
        rewardWordOriginal = "accomplish",
    ),
    POLYGLOT(
        title = "Полиглот",
        description = "Изучить 200 слов",
        icon = "🌍",
        rewardWordOriginal = "fluent",
    ),
    WINNER(
        title = "Победитель",
        description = "Завершить первый PvP матч с победителем",
        icon = "🏆",
        rewardWordOriginal = "triumph",
    ),
    STREAK(
        title = "Серия",
        description = "Заниматься 7 дней подряд",
        icon = "🔥",
        rewardWordOriginal = "consistent",
    ),
    COLLECTOR(
        title = "Коллекционер",
        description = "Собрать колоду из 20 карточек",
        icon = "🎴",
        rewardWordOriginal = "dedicate",
    ),
    LEGEND(
        title = "Легенда",
        description = "Получить все остальные достижения",
        icon = "⭐",
        rewardWordOriginal = "excel",
    ),
}

data class AchievementState(
    val id: AchievementId,
    val unlockedAt: Long?,
    val rewardWordId: Long?,
) {
    val isUnlocked: Boolean get() = unlockedAt != null
}
