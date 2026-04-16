# Архитектура и план разработки

## Структура проекта
```
app/src/main/java/com/example/kartonki/
├── data/
│   ├── db/  (AppDatabase, dao/, entity/)
│   └── repository/  (Word, Deck, Progress)
├── domain/
│   ├── model/  (Word, Card, Deck, Rarity, QuizType)
│   └── usecase/
└── ui/
    ├── navigation/AppNavGraph.kt
    ├── screen/  (home, pve, pvp, collection, deckbuilder)
    ├── component/  (CardView, RarityBadge, ProgressBar, QuizInput)
    └── theme/
```

## Доменные модели (ключевые)

**Rarity:** COMMON(1очко, серый) / RARE(2, синий) / EPIC(3, фиолетовый) / LEGENDARY(5, оранжевый)

**Deck:** MAX_SIZE=20, лимиты: LEGENDARY≤2, EPIC≤4, RARE≤6

**Word ID:** `setId × 100 + position`. Блоки: `en-ru` → 1..999, `he-ru` → 1001..1999.

## Навигация
```
HOME → PVE/STUDY → QuizScreen
     → PVP/DECK_SELECT → PvpGameScreen → PvpResultScreen
     → COLLECTION
     → DECK_BUILDER/{id}
```

## PvP механика
1. Оба игрока выбирают колоды → Игрок 1 играет карту → передаёт устройство → Игрок 2 отвечает → очки по Rarity.points → чередование до конца колод.
QuizType: TRANSLATION / DEFINITION (4 варианта) / FILL_IN_BLANK

## PvE механика
Spaced repetition (SM-2). ProgressEntity: правильные ответы + дата повторения + уровень 0–5. Уровень 3+ = слово изучено, карточка открыта в коллекции.

## Конвенции кода
- PascalCase классы/composables, camelCase функции/переменные
- Один файл = один экран + подкомпоненты
- UiState sealed class/data class в каждом ViewModel
- Все строки в `strings.xml`

## Зависимости (build.gradle.kts)
```kotlin
implementation("androidx.navigation:navigation-compose:2.7.7")
implementation("androidx.room:room-runtime:2.6.1")
implementation("androidx.room:room-ktx:2.6.1")
ksp("androidx.room:room-compiler:2.6.1")
implementation("com.google.dagger:hilt-android:2.51.1")
ksp("com.google.dagger:hilt-android-compiler:2.51.1")
implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
implementation("androidx.datastore:datastore-preferences:1.0.0")
```
Root plugins: `hilt-android:2.51.1`, `ksp:2.2.10-1.0.29`

## Фазы разработки
1. **Фундамент** — зависимости, Hilt, Room, модели, навигация, HomeScreen
2. **PvE** — репозитории, seed data, StudyScreen, QuizScreen, spaced repetition
3. **Коллекция** — CollectionScreen, CardView, DeckBuilderScreen
4. **PvP** — DeckSelectScreen, PvpGameScreen, подсчёт очков, PvpResultScreen
5. **Полировка** — анимации редкости, звуки, настройки, onboarding
