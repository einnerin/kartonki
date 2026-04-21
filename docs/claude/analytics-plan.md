# План аналитики игроков

## Цель

Получать поведенческую статистику после релиза в Google Play Store на ~3000 начальных пользователей, чтобы:
- Понять, интересно ли приложение (retention, session length, возвраты)
- Найти проблемные слова / неудачные дистракторы (accuracy < 60%)
- Диагностировать drop-off по экранам и режимам
- Оценить востребованность PvP (особенно онлайн) vs PvE
- Видеть какой сложности колоды строят и как часто сдаются в матчах

## Архитектура

Проект использует Firebase (Auth, Firestore, RTDB) через **ручную инициализацию** в `di/FirebaseModule.kt` (google-services.json в .gitignore). Для Analytics:

- ✅ Используем `FirebaseAnalytics.getInstance(firebaseApp)` — работает с существующим FirebaseApp
- ❌ Плагин `google-services` не подключаем — не переделываем текущую архитектуру
- ❌ Crashlytics откладываем — требует плагин; MVP пишет краш-события через собственный `UncaughtExceptionHandler` в `app_crash` event

### Новые файлы

```
app/src/main/java/com/example/kartonki/
├── analytics/
│   ├── AnalyticsManager.kt       # interface + Firebase impl
│   ├── AnalyticsEvent.kt         # sealed class всех 28 событий
│   ├── AnalyticsUserProperty.kt  # sealed class для user_property
│   ├── AnalyticsCrashHandler.kt  # глобальный UncaughtExceptionHandler
│   └── NoOpAnalyticsManager.kt   # для тестов и fallback
├── di/
│   └── AnalyticsModule.kt        # Hilt @Provides
docs/legal/
├── privacy-policy.md             # русский для пользователей
└── privacy-policy-en.md          # английский (для Play Store)
```

## Решения (финал)

| # | Решение |
|---|---------|
| Consent-экран | **Не показываем в MVP.** Soft launch на ~3000 знакомых/случайных пользователей из Play Store — Play Store требует privacy policy URL, но consent-диалог не обязателен для базовой анонимной аналитики. Добавим отдельно, если выйдем на EU-рынок. |
| Privacy policy | **Обязательна для Play Store.** Пишем сразу шаблон (ru+en), размещаем на GitHub Pages (`https://einnerin.github.io/kartonki/privacy`), URL вставляется в Play Console при публикации. |
| Фильтр dev-устройства | `BuildConfig.DEBUG → setUserId("dev_einnerin")`. Твои сессии через Android Studio не смешиваются со статистикой. |
| Tester mode (friends) | 7 тапов по версии приложения в Settings → сохраняется `tester_mode_enabled=true` в SharedPreferences → `setUserId("tester")`. В Firebase Console фильтруешь `user_id != tester`. |
| Crash reporting | Простой `UncaughtExceptionHandler` логирует `app_crash` event в Analytics. Без stack trace, но видно что крашится/когда/на каких устройствах. Полноценный Crashlytics — отдельная задача. |
| Свободный текст | **Не собираем** (deck names, search queries) — чтобы не поймать случайно PII. |

## События — 28 custom events

### Engagement (6)

| Event | Параметры | Где триггерится |
|-------|-----------|-----------------|
| `session_started` | `mode`, `deck_level`, `deck_size`, `deck_avg_rarity` | Вход в study/pvp/problem session |
| `session_finished` | `mode`, `duration_sec`, `words_reviewed`, `correct_count`, `completed` (bool) | Нормальный выход из сессии |
| `session_abandoned` | `mode`, `completed_percent`, `reason` (background/back/timeout) | Убито системой или свёрнуто |
| `tab_selected` | `tab_name` (home/collection/decks/stats/achievements/settings) | Навигация (дебаунсим — не чаще 1 раза на таб за сессию) |
| `streak_extended` | `new_length`, `previous_length` | При апдейте StudyStreak |
| `streak_broken` | `lost_length` | Пропуск дня, streak сбросился |

### Learning (7)

| Event | Параметры | Где триггерится |
|-------|-----------|-----------------|
| `word_seen` | `word_id`, `set_id`, `rarity`, `language_pair`, `session_mode` | При показе карточки |
| `quiz_answered` | `word_id`, `quiz_type` (FILL_IN_BLANK/MCD_NATIVE/MCT), `correct`, `response_ms`, `distractor_count`, `attempt_number` | Ответ в квизе |
| `card_rarity_promoted` | `word_id`, `from_rarity`, `to_rarity`, `cumulative_attempts` | Апгрейд в ProgressRepository |
| `problem_word_reviewed` | `word_id`, `fail_count_before`, `correct_now` (bool) | В Problem Words session |
| `set_opened` | `set_id`, `first_time` (bool), `from_screen` | WordSetDetail init |
| `set_completed` | `set_id`, `days_since_first_open`, `total_attempts` | Все 25 слов в UNCOMMON+ |
| `problem_words_session_completed` | `words_reviewed`, `learned_count`, `fail_streak_words` | После ProblemWordsSession |

### Decks (4)

| Event | Параметры | Где триггерится |
|-------|-----------|-----------------|
| `deck_built` | `size`, `avg_rarity`, `common_count`, `uncommon_count`, `rare_count`, `epic_count`, `legendary_count`, `language_pair`, `build_duration_sec`, `cards_considered` | DeckBuilderViewModel.save() |
| `deck_edited` | `size_delta`, `avg_rarity_after`, `language_pair` | Редактирование колоды |
| `deck_deleted` | `age_days`, `was_ever_used` (bool) | Удаление |
| `deck_selected_for_session` | `deck_id`, `deck_level`, `deck_size`, `for_mode` | Выбор колоды перед PvE/PvP |

### PvP Local (2)

| Event | Параметры |
|-------|-----------|
| `pvp_local_match_started` | `p1_deck_level`, `p1_deck_size`, `p2_deck_level`, `p2_deck_size` |
| `pvp_local_match_finished` | `rounds`, `winner_slot` (1/2/draw), `duration_sec`, `surrendered` (bool), `surrendered_by_slot`, `rounds_won_p1`, `rounds_won_p2` |

### PvP Online (5)

| Event | Параметры |
|-------|-----------|
| `pvp_online_matchmaking_started` | `deck_level`, `deck_size`, `deck_avg_rarity` |
| `pvp_online_matchmaking_result` | `outcome` (found/cancelled/timeout/error), `duration_sec` |
| `pvp_online_match_started` | `own_deck_level`, `own_deck_size`, `opponent_estimated_level` |
| `pvp_online_match_finished` | `rounds`, `won` (bool), `duration_sec`, `surrendered`, `surrendered_by_opponent` |
| `pvp_online_disconnect` | `reason` (timeout/server/network/opponent_left), `round_number` |

### Collection & Rewards (3)

| Event | Параметры |
|-------|-----------|
| `pack_opened` | `pack_type`, `new_cards_count`, `duplicates_count`, `highest_rarity_obtained`, `pack_source` (purchase/achievement) |
| `achievement_unlocked` | `achievement_id`, `days_since_first_open` |
| `card_retained_as_favorite` | `word_id`, `rarity` |

### Auth & Technical (3)

| Event | Параметры |
|-------|-----------|
| `login_method` | `method` (google/anonymous), `first_time` (bool) |
| `app_crash` | `error_type` (class name), `screen` (current route if known), `is_fatal` |
| `tester_mode_enabled` | (no params) — маркер активации tester-mode |

## User properties (9)

Firebase хранит эти свойства attached к user_id и использует в сегментации дашбордов.

| Property | Тип | Когда обновляется |
|----------|-----|-------------------|
| `preferred_language_pair` | string (en-ru/he-ru) | При смене в Settings |
| `total_decks` | int | При создании/удалении колоды |
| `total_words_learned` | int | При старте сессии (кол-во слов в UNCOMMON+) |
| `total_words_mastered` | int | При старте сессии (кол-во в LEGENDARY) |
| `favorite_mode` | string (PVE/PVP_LOCAL/PVP_ONLINE) | Еженедельно по большинству сессий |
| `avg_daily_session_minutes` | int | Раз в неделю |
| `install_cohort_week` | string (YYYY-WW) | Проставляется раз при первом запуске |
| `has_played_pvp_online` | bool | После первого успешного онлайн-матча |
| `highest_streak` | int | При обновлении streak |

## Автоматические события Firebase (бесплатно, без кода)

`first_open`, `session_start`, `session_end`, `app_update`, `app_remove`, `screen_view`, `notification_receive`, `user_engagement` — Firebase SDK собирает сам после подключения dependency.

## Точки интеграции в код

| Событие | Файл | Метод |
|---------|------|-------|
| `word_seen` | `QuizSessionHelper.kt` | при `currentWord = ...` |
| `quiz_answered` | `QuizSessionHelper.kt` | в `submitAnswer()` |
| `session_started` | Splash → Navigation / entry ViewModels | при входе по экранам |
| `session_finished` | ViewModels в `onCleared()` / явные exit-методы | |
| `session_abandoned` | `KartonkiApplication.onTerminate()` / lifecycle listener | |
| `deck_built` | `DeckBuilderViewModel.save()` | |
| `deck_selected_for_session` | `PvpDeckSelectViewModel` + PvE entry | |
| `set_opened` | `WordSetDetailViewModel.init` | |
| `set_completed` | `ProgressRepository.checkCompletion()` | |
| `achievement_unlocked` | `AchievementEventViewModel` | |
| `card_rarity_promoted` | `ProgressRepository.upgradeRarity()` | |
| `pvp_local_match_*` | `PvpGameLogic` | |
| `pvp_online_*` | `OnlineMatchmakingViewModel`, `OnlineGameRepository` | |
| `pack_opened` | `PackOpeningViewModel` | |
| `problem_word_reviewed` | `ProblemWordsSessionScreen` | |
| `streak_*` | `StudyStreakDao` / после insert | |
| `login_method` | `LoginViewModel` success | |
| `tab_selected` | `AppNavGraph` — debounce per session | |
| `app_crash` | `AnalyticsCrashHandler` — глобальный Thread.setDefaultUncaughtExceptionHandler | |

## Зависимости

### `gradle/libs.versions.toml`
```toml
firebase-analytics = { group = "com.google.firebase", name = "firebase-analytics-ktx" }
```

### `app/build.gradle.kts`
```kotlin
implementation(libs.firebase.analytics)
```

## Фазы работы

### ✅ Фаза 1 — инфраструктура + engagement (текущая сессия)
- `AnalyticsManager` interface + Firebase impl + NoOp (для тестов)
- `AnalyticsEvent` sealed class (все 28 кейсов в skeleton, 6 engagement-событий заполнены)
- `AnalyticsUserProperty` sealed class
- `AnalyticsCrashHandler` + инициализация в `KartonkiApplication`
- `AnalyticsModule.kt` Hilt
- `BuildConfig.DEBUG → user_id=dev_einnerin`
- `UserPreferencesRepository` расширен tester-mode
- `SettingsScreen` — 7 тапов по версии
- Интеграция 6 engagement-событий
- Privacy policy (ru+en) в `docs/legal/`

### Фаза 2 — Learning events
- 7 событий: `word_seen`, `quiz_answered`, `card_rarity_promoted`, `problem_word_reviewed`, `set_opened`, `set_completed`, `problem_words_session_completed`
- Интеграция в QuizSessionHelper, ProgressRepository, WordSetDetailViewModel, ProblemWordsSession

### Фаза 3 — Decks + PvP
- 4 deck-события + 2 PvP Local + 5 PvP Online = 11 событий
- Интеграция в DeckBuilder, PvpGameLogic, OnlineMatchmakingViewModel

### Фаза 4 — Collection, auth, финализация
- 3 collection + 1 auth = 4 события
- Все 9 user properties заполняются
- Финальное тестирование через Firebase DebugView
- README / docs обновлены

## Дашборды

**Сразу после релиза:**
- Firebase Console → Analytics — DAU/MAU, retention, events, funnels, cohorts
- Firebase Console → Analytics → DebugView — real-time проверка в debug-сборке

**Когда наберётся ~месяц данных (опционально):**
- BigQuery export: Firebase → Project Settings → Integrations → BigQuery → Enable
- Looker Studio → подключить BigQuery → кастомные SQL-дашборды для деталей типа «слова с accuracy < 60%»

## Проверка после Фазы 1

1. Debug сборка на устройство через Android Studio
2. `adb shell setprop debug.firebase.analytics.app com.example.kartonki` (включает DebugView)
3. Firebase Console → Analytics → DebugView
4. В приложении триггернуть события: войти в study-сессию, закончить, нажать на tab
5. Увидеть события в реальном времени в DebugView
6. Проверить user_id — должно быть `dev_einnerin` (BuildConfig.DEBUG)

## Privacy policy — minimum требуемое Play Store

Текст должен описывать:
- Какие данные собираются (анонимные метрики поведения, анонимный Firebase ID, тип устройства, версия ОС)
- Зачем (улучшение приложения, анализ удобства, поиск ошибок)
- Делятся ли (только с Google Firebase)
- Как удалить (удаление приложения прекращает сбор; исторические данные через запрос на contact email)
- Контакт (email разработчика)

Шаблон — в `docs/legal/privacy-policy.md`, URL на GitHub Pages вставляется в Play Console.

## Оценка трудозатрат (финальная)

Без consent-экрана, с расширенным набором событий:
- **Фаза 1:** 3-4 часа (инфра + 6 событий + tester-mode UI + privacy policy)
- **Фаза 2:** 2 часа (7 learning-событий)
- **Фаза 3:** 2.5 часа (11 deck + PvP событий)
- **Фаза 4:** 1.5 часа (4 события + user properties + финалка)

**Итого:** ~10 часов, разделены на 4 коммитабельные сессии.

## Что НЕ делаем в MVP

- Crashlytics (требует google-services plugin, отдельная задача)
- Performance Monitoring (аналогично)
- Remote Config / A/B testing
- Consent-диалоги (добавим при выходе на EU)
- Сбор free-text (deck names, search queries — PII-риск)
- Экспортная панель в самом приложении (делаем через Firebase Console)
