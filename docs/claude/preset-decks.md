# Правила: Пресетные колоды (DeckSeed)

## Файлы для чтения перед работой
- `data/DeckSeed.kt` — data class
- `data/PresetDecksVersion.kt` — текущая версия
- `data/WordDataEnglish.kt` — `prebuiltDecks` для en-ru (в конце файла)
- `data/WordDataHebrew.kt` — `prebuiltDecks` для he-ru (в конце файла)
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
    name = "Название",
    level = 3,                          // 1–7, см. таблицу уровней ниже
    wordOriginals = listOf("cat", ...),  // ровно 21 слово
    languagePair = "en-ru",             // или "he-ru"
)
```

## Уровни сложности колод (DeckLevel)

7 уровней. Каждый определяет максимальное количество карт каждой редкости.
Итого всегда = **21 карта**.

| Уровень | Название | ⬜ COMMON | 🟢 UNCOMMON | 🔵 RARE | 🟣 EPIC | 🟠 LEGENDARY |
|---------|----------|----------|------------|--------|--------|-------------|
| 1 ★     | Новичок  | ≤12      | ≤9         | 0      | 0      | 0           |
| 2 ★★    | Ученик   | ≤10      | ≤6         | ≤5     | 0      | 0           |
| 3 ★★★   | Знаток   | ≤8       | ≤6         | ≤4     | ≤2     | ≤1          |
| 4 ★★★★  | Опытный  | ≤4       | ≤7         | ≤6     | ≤3     | ≤1          |
| 5 ★★★★★ | Умелый   | 0        | ≤6         | ≤8     | ≤5     | ≤2          |
| 6 ★×6   | Мастер   | 0        | ≤3         | ≤8     | ≤7     | ≤3          |
| 7 ★×7   | Эксперт  | 0        | 0          | ≤6     | ≤10    | ≤5          |

Звёзды отображаются разным цветом (серая → жёлтая с разным свечением).
Код: `DeckLevel.starsFor(level)` → `"★".repeat(level)`

## Редкость слов в колодах — ОБЯЗАТЕЛЬНО проверять из БД

При составлении колоды **никогда не угадывай редкость** по теме или интуиции.
Слово «комната» кажется простым — но в БД оно может быть UNCOMMON, а не COMMON.

**Всегда проверяй фактическую редкость** каждого слова перед тем как распределять
по слотам COMMON/UNCOMMON/RARE/EPIC/LEGENDARY:

```python
import re, glob, sys
sys.stdout.reconfigure(encoding='utf-8')
all_words = {}
for f in glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt'):
    for e in re.findall(r'WordEntity\([^)]+\)', open(f, encoding='utf-8').read(), re.DOTALL):
        om = re.search(r'original\s*=\s*"([^"]+)"', e)
        rm = re.search(r'rarity\s*=\s*"([^"]+)"', e)
        if om and rm: all_words[om.group(1)] = rm.group(1)
for w in [...список слов...]: print(f'{w}: {all_words.get(w, "NOT FOUND")}')
```

Комментарий `// COMMON ×12` должен отражать **реальную** редкость из БД,
а не предположение. Несоответствие → нарушение лимитов уровня → неверный баланс колоды.

## Чеклист при изменении пресетных колод

1. Убедись, что все слова в `wordOriginals` **существуют в БД** (grep по `original`).
2. **Проверь фактическую редкость каждого слова** (см. скрипт выше) — не угадывай.
3. Ровно 21 слово в каждой колоде.
4. Соблюдай лимиты уровня (таблица выше) — каждая редкость ≤ лимита для уровня.
5. Добавь/измени `DeckSeed` в `WordDataEnglish.prebuiltDecks` (или `WordDataHebrew`).
6. Подними `PresetDecksVersion.CURRENT` на 1.
7. **Не поднимай `WordDataVersion`** за это (только за изменение слов).

## Когда НЕ нужно поднимать PresetDecksVersion
- При добавлении новых наборов слов — `CollectionRepository` автоматически триггерится через `WordDataVersion`. Поднимать обе версии нужно только если одновременно меняются и слова, и состав колод.

## Частые ошибки
- Слово в `wordOriginals` не существует в БД → слово тихо пропускается при создании колоды.
- Забыл поднять `PresetDecksVersion.CURRENT` → старые пользователи не получат обновлённые колоды.
- Изменил только слова внутри набора, но не поднял `PresetDecksVersion` → нормально, `WordDataVersion` достаточно.
- Неверное количество слов (не 21) → `isDeckValid` вернёт false, колода считается невалидной.
