# Правила: Пресетные колоды (DeckSeed)

## Файлы для чтения перед работой
- `data/DeckSeed.kt` — data class
- `data/PresetDecksVersion.kt` — текущая версия (сейчас 11)
- `data/WordDataEnglish.kt` — `prebuiltDecks` для en-ru
- `data/WordDataHebrew.kt` — `prebuiltDecks` для he-ru
- `data/WordRegistry.kt` — `allPrebuiltDecks`

## Как работает обновление пресетов

При запуске `CollectionRepository` сравнивает сохранённую версию с `PresetDecksVersion.CURRENT`.
Если версии расходятся:
1. Удаляет все колоды с `isPreset = true`.
2. Создаёт колоды заново из `WordRegistry.allPrebuiltDecks`.
3. Добавляет слова из новых колод в коллекцию пользователя.

Пользовательские колоды (`isPreset = false`) не трогаются.

## Структура DeckSeed

```kotlin
DeckSeed(
    name = "Стартовая колода",
    level = 1,                     // 1 = beginner, выше = сложнее
    wordOriginals = listOf("cat", "dog", "house", ...),  // ровно 20 слов
    languagePair = "en-ru",        // или "he-ru"
)
```

## Чеклист при изменении пресетных колод

1. Убедись, что все слова в `wordOriginals` **существуют в БД** (grep по `original`).
2. Соблюдай лимиты Deck: LEGENDARY ≤ 2, EPIC ≤ 4, RARE ≤ 6, итого 20 карт.
3. Добавь/измени `DeckSeed` в `WordDataEnglish.prebuiltDecks` (или `WordDataHebrew`).
4. Подними `PresetDecksVersion.CURRENT` на 1.
5. **Не поднимай `WordDataVersion`** за это (только за изменение слов).

## Когда НЕ нужно поднимать PresetDecksVersion
- При добавлении новых наборов слов — `CollectionRepository` автоматически триггерится через `WordDataVersion`. Поднимать обе версии нужно только если одновременно меняются и слова, и состав колод.

## Частые ошибки
- Слово в `wordOriginals` не существует в БД → слово тихо пропускается при создании колоды.
- Забыл поднять `PresetDecksVersion.CURRENT` → старые пользователи не получат обновлённые колоды.
- Изменил только слова внутри набора, но не поднял `PresetDecksVersion` → нормально, `WordDataVersion` достаточно.
