# Правила: Наборы слов (Word Sets / Seed Data)

## Файлы для чтения перед работой
- `data/WordRegistry.kt` — реестр всех наборов/слов/колод
- `data/AchievementCards.kt` — слова-исключения (нельзя добавлять в обычные наборы)
- Соответствующий `WordDataXxx.kt`

## Как работает загрузка в БД
- `WordLoader.doLoad()` срабатывает при `storedVersion < WordDataVersion.CURRENT`
- Наборы: `insertSets` (IGNORE) + `updateSetMetadata` (только seed-поля: `name`, `description`, `orderIndex`). Поле `isFavorite` — пользовательское, не трогать.
- Слова: `insertAllOrReplace` = REPLACE по PK. Есть UNIQUE-индекс `(original, languagePair)` — дубль уничтожает старую строку, старый набор теряет слово.

## Чеклист перед добавлением набора

1. **`name`/`description` — всегда на русском.** Не на иврите, не на английском.
2. **Проверь каждое слово на дубль** (для иврита обязательно `-F`):
   ```bash
   grep -rFl "original = \"СЛОВО\"" app/src/main/java/com/example/kartonki/data/
   ```
   Пакетная проверка:
   ```bash
   DIR="app/src/main/java/com/example/kartonki/data"
   for word in слово1 слово2 слово3; do
     result=$(grep -rFl "original = \"$word\"" "$DIR" 2>/dev/null)
     [ -n "$result" ] && echo "ДУБЛЬ: '$word' — $result" || echo "СВОБОДНО: '$word'"
   done
   ```
   Замена тоже может быть дублем — проверяй замену тем же способом.
3. **Не добавляй слова из `AchievementCards.ALL_EXCLUSIVE`.**
4. **Шкала редкости:** COMMON=A1 · UNCOMMON=A2-B1 · RARE=B2 · EPIC=C1 · LEGENDARY=C2+
5. **ID слова = `setId × 100 + position`.** setId не должен пересекаться с `languageIdBlocks` в `WordRegistry`.
   Исключение: слова-награды достижений — `setId = 0`, ID 24990–24994, `semanticGroup = "achievement_reward"`.
6. **После добавления** — зарегистрируй в `WordRegistry.allSets` и `WordRegistry.allWords`.
7. **Всегда поднимай `WordDataVersion.CURRENT`** при любом изменении слов. `PresetDecksVersion` отдельно поднимать не нужно (кроме изменений в DeckSeed-колодах).
8. **Ровно 25 слов в каждом наборе.** После написания проверяй:
   ```bash
   grep -c "setId = XXXX," WordDataXxx.kt
   ```

## Частые ошибки
- Дубль по `original` → REPLACE удаляет старую строку → старый набор теряет слово → становится 24-словным.
- Замена дубля выбрана «по смыслу» без grep → замена тоже дубль (cashback, garnish, liability...).
- Для иврита `grep -w` ненадёжен с огласовками. Только `grep -F`.
- `name`/`description` написаны на иврите — ошибка незаметна в коде, но видна в UI.
- Написал меньше 25 слов (повторялось на наборах 1022–1037, 1019–1021).
- Контекстное окно кончилось в середине набора → набор получил 2–4 слова (setId=87).
- При исправлении коротких наборов проверяй соседние группы тоже.

## Полный аудит всех наборов
```bash
DIR="app/src/main/java/com/example/kartonki/data" && for file in "$DIR"/WordData*.kt; do
  fname=$(basename "$file")
  setids=$(grep -oE "setId = [0-9]+" "$file" | grep -oE "[0-9]+" | sort -u)
  for sid in $setids; do
    count=$(grep -c "setId = $sid," "$file" 2>/dev/null || true)
    [ "$count" != "25" ] && echo "ПРОБЛЕМА: $fname — setId=$sid — $count слов"
  done
done
```
Ложные тревоги: setId=0 (5 слов — награды) и Extra-файлы (20+5=25 суммарно).
