# Правила: Добавление нового языка

## Файлы для чтения перед работой
- `data/WordRegistry.kt` — `allSets`, `allWords`, `allPrebuiltDecks`, `languageIdBlocks`
- `data/WordDataEnglish.kt` — образец структуры языкового файла
- `data/WordDataHebrew.kt` — образец для языка с нелатинским алфавитом
- `data/db/entity/WordSetEntity.kt` — поле `languagePair`

## Блоки ID

| Пара | Наборы (setId) | Слова (wordId) |
|------|----------------|----------------|
| en-ru | 1–999 | 100–99 999 |
| he-ru | 1001–1999 | 100 100–199 999 |
| **новый язык** | 2001–2999 | 200 100–299 999 |

Формула: `wordId = setId × 100 + position (1–25)`

## Пошаговый чеклист

1. **Создай `WordDataXxx.kt`** (и `WordDataXxxExpanded.kt` если наборов > 20):
   - `object WordDataFrench { val sets: List<WordSetEntity>; val words: List<WordEntity>; val prebuiltDecks: List<DeckSeed> }`
   - `languagePair = "fr-ru"` во всех сущностях
   - `setId` в диапазоне нового блока (например 2001+)
   - Имена наборов на русском языке

2. **Добавь в `WordRegistry`**:
   - `allSets`: `+ WordDataFrench.sets`
   - `allWords`: `+ WordDataFrench.words`
   - `allPrebuiltDecks`: `+ WordDataFrench.prebuiltDecks`
   - `languageIdBlocks`: `"fr-ru" to 2001..2999`

3. **Подними обе версии**:
   - `WordDataVersion.CURRENT` + 1
   - `PresetDecksVersion.CURRENT` + 1

4. **Проверь дубли** (особенно если языки схожи):
   ```bash
   grep -rFl "original = \"WORD\"" app/src/main/java/com/example/kartonki/data/
   ```
   UNIQUE-индекс `(original, languagePair)` — дубли между языками невозможны,
   но дубли внутри одного языка (`fr-ru`) уничтожат старые строки.

5. **Добавь язык в UI** (если нужно переключение в настройках):
   - `ui/screen/settings/SettingsScreen.kt` — выбор языковой пары
   - `ui/screen/study/StudyScreen.kt` — фильтрация наборов по `languagePair`

## Частые ошибки
- Использовал уже занятый диапазон setId → слова с одинаковым wordId перезапишут друг друга.
- Забыл добавить в `languageIdBlocks` → аудит-тест может ругаться на неожиданные ID.
- `name`/`description` на изучаемом языке вместо русского — ошибка видна в UI.
