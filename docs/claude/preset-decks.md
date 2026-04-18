# Правила: Пресетные колоды (DeckSeed)

## Файлы для чтения перед работой
- `data/DeckSeed.kt` — data class
- `data/PresetDecksVersion.kt` — текущая версия
- `data/WordDataEnglish.kt` — `prebuiltDecks` для en-ru
- `data/WordDataHebrew.kt` — `prebuiltDecks` для he-ru

## Структура DeckSeed

```kotlin
DeckSeed(name = "Название", level = 3, languagePair = "en-ru",
    wordOriginals = listOf("cat", ...))  // ровно 21 слово
```

## Уровни сложности (всегда = 21 карта)

| Уровень | ⬜COMMON | 🟢UNCOMMON | 🔵RARE | 🟣EPIC | 🟠LEGENDARY |
|---------|---------|-----------|------|------|------------|
| 1 Новичок | ≤12 | ≤9 | 0 | 0 | 0 |
| 2 Ученик | ≤10 | ≤6 | ≤5 | 0 | 0 |
| 3 Знаток | ≤8 | ≤6 | ≤4 | ≤2 | ≤1 |
| 4 Опытный | ≤4 | ≤7 | ≤6 | ≤3 | ≤1 |
| 5 Умелый | 0 | ≤6 | ≤8 | ≤5 | ≤2 |
| 6 Мастер | 0 | ≤3 | ≤8 | ≤7 | ≤3 |
| 7 Эксперт | 0 | 0 | ≤6 | ≤10 | ≤5 |

## ⚠️ Редкость слов — всегда проверять из БД

Никогда не угадывай. «Комната» кажется COMMON, но может быть UNCOMMON.

```bash
grep -A3 'original = "СЛОВО"' app/src/main/java/com/example/kartonki/data/ -r | grep rarity
```

## Чеклист

1. Все слова в `wordOriginals` существуют в БД (grep)
2. Проверь фактическую редкость каждого слова
3. Ровно 21 слово, лимиты уровня соблюдены
4. Поднять `PresetDecksVersion.CURRENT` на 1
5. **Не** поднимать `WordDataVersion` (только если одновременно меняются слова)

## Частые ошибки
- Слово не существует в БД → тихо пропускается при создании колоды
- Забыл поднять `PresetDecksVersion` → старые пользователи не получат обновление
- Неверное количество слов (не 21) → `isDeckValid = false`
