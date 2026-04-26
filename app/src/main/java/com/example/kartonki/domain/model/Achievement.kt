package com.example.kartonki.domain.model

enum class AchievementId(
    val title: String,
    val description: String,
    val icon: String,
    val rewardWordEnRu: String,
    val rewardWordHeRu: String,
    val rewardWordTranslation: String,
    val isHidden: Boolean = false,
) {
    // ── Visible achievements ──────────────────────────────────────────────────

    FIRST_LESSON(
        title = "Первые шаги",
        description = "Завершить первую учебную сессию",
        icon = "🌱",
        rewardWordEnRu = "paradigm",
        rewardWordHeRu = "דֶּגֶם",
        rewardWordTranslation = "парадигма / образец",
    ),
    DILIGENT(
        title = "Прилежный",
        description = "Заниматься 10 разных дней",
        icon = "📖",
        rewardWordEnRu = "inference",
        rewardWordHeRu = "מַסְקָנָה",
        rewardWordTranslation = "умозаключение",
    ),
    FIRST_FIGHT(
        title = "Первый бой",
        description = "Сыграть первый PvP матч",
        icon = "⚔️",
        rewardWordEnRu = "conjecture",
        rewardWordHeRu = "הַשְׁעָרָה",
        rewardWordTranslation = "предположение / гипотеза",
    ),
    FIRST_WIN(
        title = "Победитель",
        description = "Выиграть первый PvP матч",
        icon = "🏆",
        rewardWordEnRu = "refute",
        rewardWordHeRu = "לְהַפְרִיךְ",
        rewardWordTranslation = "опровергать",
    ),
    STREAK_5(
        title = "В потоке",
        description = "Учиться 5 дней подряд",
        icon = "🔥",
        rewardWordEnRu = "elucidate",
        rewardWordHeRu = "לְבָאֵר",
        rewardWordTranslation = "разъяснять",
    ),
    EXPERT(
        title = "Знаток",
        description = "Изучить 50 слов (уровень 3+)",
        icon = "📚",
        rewardWordEnRu = "accomplish",
        rewardWordHeRu = "לְהַשִּׂיג",
        rewardWordTranslation = "достигать",
    ),
    POLYGLOT(
        title = "Полиглот",
        description = "Изучить 200 слов",
        icon = "🌍",
        rewardWordEnRu = "fluent",
        rewardWordHeRu = "שׁוֹטֵף",
        rewardWordTranslation = "свободно владеющий языком",
    ),
    STREAK_7(
        title = "Серия",
        description = "Учиться 7 дней подряд",
        icon = "⚡",
        rewardWordEnRu = "consistent",
        rewardWordHeRu = "עִקְבִי",
        rewardWordTranslation = "последовательный",
    ),
    COLLECTOR(
        title = "Коллекционер",
        description = "Собрать полную колоду из 20 карточек",
        icon = "🎴",
        rewardWordEnRu = "dedicate",
        rewardWordHeRu = "לְהַקְדִּישׁ",
        rewardWordTranslation = "посвящать",
    ),
    LEGEND(
        title = "Легенда",
        description = "Получить все видимые достижения",
        icon = "⭐",
        rewardWordEnRu = "excel",
        rewardWordHeRu = "לְהִצְטַיֵּין",
        rewardWordTranslation = "преуспевать / выделяться",
    ),

    // ── Hidden achievements ───────────────────────────────────────────────────
    // Title and description are revealed only when unlocked.
    // Reward is one of the exclusive Legendary cards.

    DOMINATOR(
        title = "Доминатор",
        description = "Выиграть PvP матч с перевесом в счёте в 2 и более раза",
        icon = "👑",
        rewardWordEnRu = "diaphanous",
        rewardWordHeRu = "שָׁקוּף",
        rewardWordTranslation = "прозрачный / тонкий",
        isHidden = true,
    ),
    NIGHT_OWL(
        title = "Ночная сова",
        description = "Пройти учебную сессию после 23:00",
        icon = "🦉",
        rewardWordEnRu = "lugubrious",
        rewardWordHeRu = "קוֹדֵר",
        rewardWordTranslation = "мрачный / унылый",
        isHidden = true,
    ),
    PERFECTIONIST(
        title = "Перфекционист",
        description = "Пройти учебную сессию без единой ошибки",
        icon = "💎",
        rewardWordEnRu = "obstreperous",
        rewardWordHeRu = "סוֹעֵר",
        rewardWordTranslation = "шумный / буйный",
        isHidden = true,
    ),
    DEEP_LEARNER(
        title = "Мастер слов",
        description = "Довести 20 слов до максимального уровня",
        icon = "🧠",
        rewardWordEnRu = "abstruse",
        rewardWordHeRu = "סָבוּךְ",
        rewardWordTranslation = "трудный для понимания",
        isHidden = true,
    ),
    VETERAN(
        title = "Ветеран",
        description = "Провести 10 PvP матчей",
        icon = "🎖️",
        rewardWordEnRu = "meretricious",
        rewardWordHeRu = "רַאֲוָתָנִי",
        rewardWordTranslation = "мишурный / показной",
        isHidden = true,
    ),
    CENTURION(
        title = "Центурион",
        description = "Дать 100 правильных ответов суммарно",
        icon = "🛡️",
        rewardWordEnRu = "pellucid",
        rewardWordHeRu = "צָלוּל",
        rewardWordTranslation = "кристально ясный",
        isHidden = true,
    ),
    DRAW_MASTER(
        title = "Миротворец",
        description = "Завершить PvP матч вничью",
        icon = "🤝",
        rewardWordEnRu = "platitudinous",
        rewardWordHeRu = "שִׁגְרָתִי",
        rewardWordTranslation = "банальный",
        isHidden = true,
    ),
    MONDAY_SCHOLAR(
        title = "Понедельник — день тяжёлый",
        description = "Пройти учебную сессию в понедельник",
        icon = "📅",
        rewardWordEnRu = "recondite",
        rewardWordHeRu = "כָּמוּס",
        rewardWordTranslation = "малоизвестный / сокровенный",
        isHidden = true,
    ),
    GOLDEN_SHOT(
        title = "Золотой выстрел",
        description = "Набрать 50 очков в одном PvP матче",
        icon = "✨",
        rewardWordEnRu = "stentorian",
        rewardWordHeRu = "רַעַם",
        rewardWordTranslation = "громоподобный",
        isHidden = true,
    ),
    WEEKLY_GRIND(
        title = "Недельный марафон",
        description = "Заниматься 5 дней в течение одной недели",
        icon = "🗓️",
        rewardWordEnRu = "ineffaceable",
        rewardWordHeRu = "בִּלְתִּי-נִמְחָק",
        rewardWordTranslation = "неизгладимый",
        isHidden = true,
    ),
    WHITE_FLAG(
        title = "Честное поражение",
        description = "Сдаться в PvP матче",
        icon = "🏳️",
        rewardWordEnRu = "sempiternal",
        rewardWordHeRu = "נִצְחִי",
        rewardWordTranslation = "вечный",
        isHidden = true,
    ),
    EXPLORER(
        title = "Исследователь",
        description = "Изучить слова из 5 разных тематических групп",
        icon = "🗺️",
        rewardWordEnRu = "desideratum",
        rewardWordHeRu = "צֹרֶךְ",
        rewardWordTranslation = "насущная потребность",
        isHidden = true,
    ),
    MARATHON(
        title = "Марафон",
        description = "Провести 3 PvP матча за один день",
        icon = "🏃",
        rewardWordEnRu = "synecdoche",
        rewardWordHeRu = "דִּמּוּי",
        rewardWordTranslation = "синекдоха / сравнение",
        isHidden = true,
    ),
    RUSTY(
        title = "Возвращение",
        description = "Вернуться к учёбе после 7-дневного перерыва",
        icon = "🦀",
        rewardWordEnRu = "solipsism",
        rewardWordHeRu = "סוֹלִיפְּסִיזְם",
        rewardWordTranslation = "солипсизм",
        isHidden = true,
    ),
    LONG_WORD(
        title = "Буквоед",
        description = "Выучить слово длиннее 12 символов",
        icon = "🔤",
        rewardWordEnRu = "perspicacious",
        rewardWordHeRu = "חַד-עַיִן",
        rewardWordTranslation = "проницательный",
        isHidden = true,
    ),
    ;

    /** Returns the reward word `original` for the given language pair. */
    fun rewardOriginalFor(languagePair: String): String = when (languagePair) {
        "he-ru" -> rewardWordHeRu
        else -> rewardWordEnRu
    }
}

data class AchievementState(
    val id: AchievementId,
    val unlockedAt: Long?,
    val rewardWordId: Long?,
) {
    val isUnlocked: Boolean get() = unlockedAt != null
}
