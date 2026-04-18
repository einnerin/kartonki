# Правила: Наборы слов (Word Sets / Seed Data)

## ⚠️ Главное: одно слово — один набор

`WordEntity` имеет UNIQUE-индекс на `(original, languagePair)`. Стратегия REPLACE — побеждает **последнее вхождение** в `WordRegistry.allWords`.

Порядок реестра: English → Hebrew* → Immigrant1–6 → HebrewBatch5–39 → **Immigrant7–16 (последние)**

Дубль в новом файле «крадёт» слово у старого набора → тот становится 24-словным у всех пользователей.

**Pre-commit хук блокирует коммит при дублях.** Первичная установка: `git config core.hooksPath .githooks`

## Процесс при срабатывании хука

Хук покажет: `'слово' stolen by set NEW from set OLD`. Дальше:
1. Прочитай оба набора: `grep -A3 "setId = X," WordDataXxx.kt`
2. Реши где уместнее: тема → уровень CEFR → практичность слова
3. **Слово остаётся в OLD** → замени в NEW на свободное слово
4. **Слово переходит в NEW** → найди замену для OLD того же уровня CEFR
5. Проверь: `python find_real_dupes.py` → должно быть `0 stolen words`

Найти свободные слова: `python list_set_words.py` или `grep -rF 'original = "СЛОВО"' data/`

## Чеклист перед добавлением набора

1. `name`/`description` — только на русском
2. 25 слов ровно: `grep -c "setId = XXXX," WordDataXxx.kt`
3. ID слова = `setId × 100 + position`; setId не пересекается с `languageIdBlocks`
4. Диапазон редкости — не шире 2 смежных уровней (COMMON+UNCOMMON, RARE+EPIC и т.д.)
5. Нет слов из `AchievementCards.ALL_EXCLUSIVE`
6. Зарегистрировать в `WordRegistry.allSets` и `WordRegistry.allWords`
7. Поднять `WordDataVersion.CURRENT` на 1

## Редкость

COMMON=A1 · UNCOMMON=A2-B1 · RARE=B2 · EPIC=C1 · LEGENDARY=C2+
Объективный CEFR-уровень, не интуиция. Проверять: `grep -A3 'original = "СЛОВО"' data/ | grep rarity`

## Аудит

```bash
python find_real_dupes.py   # реальные DB-дубли (главная проверка)
python audit_all.py         # синонимы, производные, размер наборов
```

## Частые ошибки

- Замена дубля выбрана «на глаз» → замена тоже дубль — всегда grep перед записью
- `grep -w` ненадёжен для иврита с огласовками — только `grep -F`
- Написал < 25 слов из-за того что контекстное окно кончилось — считать в конце
