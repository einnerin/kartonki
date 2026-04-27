# Правила: Пресетные колоды (DeckSeed)

## Файлы для чтения перед работой
- `data/DeckSeed.kt` — data class
- `data/PresetDecksVersion.kt` — текущая версия
- `data/WordDataEnglish.kt` — `prebuiltDecks` для en-ru
- `data/WordDataHebrew.kt` — `prebuiltDecks` для he-ru
- `domain/model/DeckLevel.kt` — точные лимиты по уровню
- `data/repository/CollectionRepository.kt:migratePresetDecks` — как DeckSeed становится колодой в БД

## Структура DeckSeed

```kotlin
DeckSeed(name = "Название", level = 3, languagePair = "en-ru",
    wordOriginals = listOf(
        // COMMON ×8
        "cat", "dog", ...,
        // UNCOMMON ×6
        "kitten", ...,
        // ...
    ))  // ровно 21 слово, разбит по bucket-комментариям
```

**Bucket-комментарии (`// COMMON ×N`) — обязательны.** Их парсит `validate_preset_decks.py` чтобы сравнить ожидаемую rarity с реальной (см. ниже).

## Уровни сложности (всегда = 21 карта)

| Уровень | ⬜COMMON | 🟢UNCOMMON | 🔵RARE | 🟣EPIC | 🟠LEGENDARY |
|---------|---------|-----------|------|------|------------|
| 1 Новичок | 12 | 9 | 0 | 0 | 0 |
| 2 Ученик | 10 | 6 | 5 | 0 | 0 |
| 3 Знаток | 8 | 6 | 4 | 2 | 1 |
| 4 Опытный | 4 | 7 | 6 | 3 | 1 |
| 5 Умелый | 0 | 6 | 8 | 5 | 2 |
| 6 Мастер | 0 | 3 | 8 | 7 | 3 |
| 7 Эксперт | 0 | 0 | 6 | 10 | 5 |

Это **точные** числа — не «не более». DeckLevel.Limits = expectedCount, не maxCount. Поэтому если фактическая rarity слова не попадает в свой bucket, в UI deck-builder появляется переполнение фильтр-чипа («Обыч 5/4», «Обыч 21/12»).

## ⚠️ Три класса бага DeckSeed (актуально на 2026-04-27)

### 1. ORPHAN — слово не существует в БД

`wordOriginals = listOf("relative", ...)` — но в БД нет слова `relative` для этого языка. `migratePresetDecks` молча пропускает (`?: continue`), пользователь видит колоду из 13 карт вместо 21.

Причина: за время жизни проекта слова добавляются/переименовываются/удаляются. DeckSeed ссылается на строки, не на ID — компайл-time проверки нет.

### 2. WRONG_RARITY — слово есть, но в БД с другой rarity (cross-topic collision)

Слово `סִיסְמָה` (пароль) — UNCOMMON в наборе «Технологии» (setId=1001) и COMMON в `CyberL1` (setId=1780). Room имеет `UNIQUE(original, languagePair)` с `OnConflictStrategy.REPLACE` — **last-write-wins по WordRegistry порядку**. CyberL1 регистрируется позже → в БД остаётся COMMON.

DeckSeed «Технологии» помечает `סִיסְמָה` как UNCOMMON в bucket-комментарии — но реально слово COMMON. Получаем `UNCOMMON=6 (вместо 7) + COMMON=5 (вместо 4)` — переполнение COMMON в level 4 deck.

### 3. LIMIT_VIOLATION — bucket-распределение нарушает DeckLevel.Limits

Бывает когда автор кладёт «больше слов чем лимит на этот rarity для этого level». Например, тема «Семья» имеет много COMMON-слов и мало UNCOMMON — соблазн положить 21 COMMON, но level 1 лимит COMMON=12 → переполнение.

## ✅ Защита: автоматический валидатор

```bash
python scripts/validate/validate_preset_decks.py
```

Проверяет все три класса бага. **Запускается в pre-commit hook** при изменении любых WordData*.kt — коммит блокируется при найденных проблемах. Источник правды для эффективной rarity = WordRegistry порядок + last-write-wins (как в БД).

Если валидатор находит проблему — сообщение точно указывает: какой deck, какой word, какая bucket vs effective rarity, или какая граница нарушена.

## Workflow при добавлении / правке DeckSeed

1. Открой `WordDataEnglish.kt` или `WordDataHebrew.kt`, найди `prebuiltDecks`.
2. Добавь / отредактируй `DeckSeed` с **bucket-комментариями** (`// COMMON ×N`).
3. Для каждого слова в `wordOriginals` проверь:
   ```bash
   grep -A3 'original = "СЛОВО"' app/src/main/java/com/example/kartonki/data/*.kt | grep rarity
   ```
   Если слово встречается в нескольких файлах с разной rarity — **решает последний** в WordRegistry.kt порядке. Поэтому проверяй **все** файлы.
4. Прогони `python scripts/validate/validate_preset_decks.py` локально.
5. Подними `PresetDecksVersion.CURRENT` на 1 — иначе `migratePresetDecks` не запустится на устройстве.
6. Подними `WordDataVersion.CURRENT` если правил WordData* (это и так требуется pre-commit hook'ом).

## Workflow при жалобе пользователя на колоду

1. Прогони `python scripts/validate/validate_preset_decks.py` — он покажет точно что не так.
2. Если ORPHAN — найди тематически близкие сеты по `topic = "X"` (могут быть в `WordDataEnglishBatch*.kt` для en-ru или `WordDataHebrewBatch*.kt`/`*L*.kt` для he-ru), подбери замену с правильной rarity.
3. Если WRONG_RARITY (cross-topic) — два варианта:
   - **Заменить слово** в DeckSeed на синоним без cross-topic коллизий (легче).
   - **Унифицировать rarity** в обоих файлах (требует понимания почему rarity разная — обычно одна из них ошибка автора).
4. Если LIMIT_VIOLATION — изменить структуру bucket'ов в DeckSeed (но DeckLevel лимиты — фиксированные, не их).
5. Подними `PresetDecksVersion.CURRENT` (re-migration на устройствах).
6. Закоммить с описанием в commit message **что именно** пофиксено.

## Инциденты

### 2026-04-27: bd21486 → 459ef64 — Семья (en-ru) и Технологии (he-ru)

Жалоба пользователя: колода «Семья» показывает «Обыч 21/12» — переполнение COMMON.

Корневые причины:
1. **Семья (level 1):** в исходном DeckSeed было 9 orphan-слов (`relative`, `sibling`, `infant`, `toddler`, `teenager`, `spouse`, `wedding`, `honeymoon`, `partner`). `migratePresetDecks` их пропускал. Первый fix-коммит (bd21486) положил 21 COMMON в bucket-комментарии — но это нарушило DeckLevel-лимит COMMON=12.
2. **Технологии (level 4):** слово `סִיסְמָה` стояло в UNCOMMON-bucket, но в БД оно COMMON (cross-topic collision с `WordDataHebrewCyberL1.kt`).

Финальный fix (459ef64):
- Семья: 12 COMMON из setId=8 + 9 UNCOMMON из setId=284 (тема «Семья» level 2 — где есть UNCOMMON-семейные слова).
- Технологии: `סִיסְמָה` → `הַעֲלָאָה` (только в setId=1001, без cross-topic коллизий).

Также по итогам инцидента (2026-04-27 commits после 459ef64):
- Создан `scripts/validate/validate_preset_decks.py`.
- Подключён в pre-commit hook (раздел 2d).
- Дополнена эта документация.
- Чтобы исключить повторение, **любая правка WordData*.kt теперь блокируется коммитом, если ломает DeckSeed** — даже если автор правил совсем другой набор.

## Связанные документы

- `quality_gates.md` — pre-commit hook overview
- `architecture.md` — Room schema, UNIQUE(original, languagePair)
- `rules-index.md` — индекс всех правил проекта
