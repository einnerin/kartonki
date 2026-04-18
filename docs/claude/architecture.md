# Архитектура и план разработки

## Структура проекта
```
app/src/main/java/com/example/kartonki/
├── data/
│   ├── db/  (AppDatabase, dao/, entity/)
│   └── repository/  (Word, Deck, Progress, Collection)
├── domain/
│   ├── model/  (Word, Card, Deck, Rarity, QuizType)
│   └── usecase/
└── ui/
    ├── navigation/  (Route.kt, AppNavGraph.kt)
    ├── screen/  (home, pve, pvp, collection, deckbuilder, stats)
    ├── component/  (CardView, RarityBadge, ProgressBar, QuizInput)
    └── theme/
```

## Доменные модели

**Rarity:** COMMON(1очко) · UNCOMMON · RARE(2) · EPIC(3) · LEGENDARY(5)

**Deck:** MAX_SIZE=20, лимиты: LEGENDARY≤2, EPIC≤4, RARE≤6

**Word ID:** `setId × 100 + position`. Блоки: `en-ru` → 1..999, `he-ru` → 1001..1999.

## Механика

**PvE:** Spaced repetition (SM-2). `ProgressEntity`: правильные ответы + дата + уровень 0–5. Уровень 3+ = слово изучено, карточка открыта в коллекции.

**PvP:** Оба выбирают колоды → Игрок 1 играет карту → передаёт устройство → Игрок 2 отвечает → очки по `Rarity.points` → чередование до конца колод.

**QuizType:** TRANSLATION / DEFINITION (4 варианта) / FILL_IN_BLANK

## Конвенции кода
- PascalCase классы/composables, camelCase функции/переменные
- Один файл = один экран + подкомпоненты
- UiState: sealed/data class в каждом ViewModel
- Все строки в `strings.xml`
