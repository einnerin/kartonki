# Правила: Наборы слов (Word Sets / Seed Data)

## Файлы для чтения перед работой
- `data/WordRegistry.kt` — реестр всех наборов/слов/колод
- `data/AchievementCards.kt` — слова-исключения (нельзя добавлять в обычные наборы)
- Соответствующий `WordDataXxx.kt`

## ⚠️ Главное правило: одно слово — один набор

`WordEntity` имеет **UNIQUE-индекс на `(original, languagePair)`**. В БД слово существует ровно в одном наборе. При загрузке используется стратегия **REPLACE** — побеждает **последнее вхождение** в порядке `WordRegistry.allWords`.

**Порядок реестра:** English → HebrewEveryday/More/Advanced/Tech → Immigrant1–6 → HebrewBatch5–39 → **Immigrant7–16 (последние)**

Если слово есть и в Batch-наборе, и в Immigrant-наборе — в БД окажется версия Immigrant. Batch-набор потеряет слово и станет 24-словным. Пользователи, открывшие приложение после обновления, потеряют это слово из старого набора **навсегда** (до переустановки или сброса БД).

**Pre-commit хук автоматически блокирует коммит при наличии дублей.** Установка (однократно):
```bash
git config core.hooksPath .githooks
```

Если хук сработал — следуй процессу ниже.

---

## Процесс при обнаружении украденного слова

Хук покажет: `'слово' [lang] stolen by set X from set Y`. Дальше:

### 1. Прочитай оба набора
```bash
grep -A3 "setId = X," WordDataXxx.kt | head -80
grep -A3 "setId = Y," WordDataYyy.kt | head -80
```

### 2. Реши, в каком наборе слово уместнее

Критерии (по приоритету):
- **Тема**: слово `כְּנֶסֶת` (Кнессет) уместнее в "Политика", чем в "Иммиграция"
- **Уровень CEFR**: слово не должно выбиваться из диапазона набора
- **Контекст**: в наборе для иммигрантов важнее практические слова, не специфические термины

### 3а. Если слово остаётся в СТАРОМ наборе → убери дубль из нового

Просто замени в новом файле на другое слово. Проверь что оно свободно:
```bash
python list_set_words.py   # покажет занятые слова и свободных кандидатов
```
Или вручную:
```bash
grep -rF 'original = "СЛОВО"' app/src/main/java/com/example/kartonki/data/
```

### 3б. Если слово переходит в НОВЫЙ набор → компенсируй старый

Старый набор остался с 24 словами — ему нужна замена. Подбери слово:
- По теме старого набора
- Того же уровня CEFR (та же `rarity`)
- Которого нет ни в одном наборе (`find_real_dupes.py` после добавления)

### 4. Проверь и коммить
```bash
python find_real_dupes.py   # должно быть: 0 stolen words
git add ... && git commit
```

---

## Как работает загрузка в БД
- `WordLoader.doLoad()` срабатывает при `storedVersion < WordDataVersion.CURRENT`
- Наборы: `insertSets` (IGNORE) + `updateSetMetadata` (только seed-поля: `name`, `description`, `orderIndex`). Поле `isFavorite` — пользовательское, не трогать.
- Слова: `insertAllOrReplace` = REPLACE по `(original, languagePair)`. Побеждает последнее вхождение в порядке реестра (см. выше).

## Редкость — первостепенное свойство

`rarity` — это объективный уровень CEFR слова, не субъективная оценка.
**Никогда не угадывай редкость по смыслу или теме.** Всегда читай из БД:

```bash
grep -A3 "original = \"СЛОВО\"" app/src/main/java/com/example/kartonki/data/WordDataXxx.kt | grep rarity
```

Пакетно для списка слов:
```python
import re, glob, sys
sys.stdout.reconfigure(encoding='utf-8')
all_words = {}
for f in glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt'):
    for e in re.findall(r'WordEntity\([^)]+\)', open(f, encoding='utf-8').read(), re.DOTALL):
        om = re.search(r'original\s*=\s*"([^"]+)"', e)
        rm = re.search(r'rarity\s*=\s*"([^"]+)"', e)
        if om and rm: all_words[om.group(1)] = rm.group(1)
for w in ['слово1', 'слово2']: print(f'{w}: {all_words.get(w, "NOT FOUND")}')
```

На редкости строится вся логика: лимиты в колодах, цвета карточек, PvP-баланс.
Ошибка в метке распространяется на всё. Редкость меняется только если метка
**объективно неверна** по CEFR — не ради удобства набора или колоды.

## Чеклист перед добавлением набора (и перед КАЖДЫМ коммитом)

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

   > ⚠️ **Файлы Immigrant10–12 слишком большие для ручного контроля.** Для иврита
   > **всегда** строй полный список занятых слов перед написанием нового файла:
   > ```bash
   > grep -h 'setId = 1[0-9][0-9][0-9]' app/src/main/java/com/example/kartonki/data/WordDataHebrew*.kt \
   >   app/src/main/java/com/example/kartonki/data/WordDataHebrewImmigrant*.kt 2>/dev/null \
   >   | grep -oE 'original = "[^"]+"' | sed 's/original = "//;s/"//' | sort -u > /tmp/taken_he.txt
   > grep -Fx '"СЛОВО"' /tmp/taken_he.txt  # проверить одно слово
   > ```
   > Дубли **между** новыми файлами тоже опасны — проверяй после написания всех файлов батча.

3. **Не добавляй слова из `AchievementCards.ALL_EXCLUSIVE`.**
4. **Шкала редкости:** COMMON=A1 · UNCOMMON=A2-B1 · RARE=B2 · EPIC=C1 · LEGENDARY=C2+
5. **Диапазон редкости в одном наборе — не шире 2 смежных уровней.**
   - ✅ COMMON+UNCOMMON, UNCOMMON+RARE, RARE+EPIC, EPIC+LEGENDARY
   - ❌ COMMON+RARE (пропуск), COMMON+EPIC, UNCOMMON+LEGENDARY, COMMON+LEGENDARY
   - Правило: **не смешивать COMMON и EPIC** в одном наборе.
   - Если нужна «лёгкая» и «продвинутая» версия темы — делай два набора: «основы» и «углублённо».
6. **ID слова = `setId × 100 + position`.** setId не должен пересекаться с `languageIdBlocks` в `WordRegistry`.
   Исключение: слова-награды достижений — `setId = 0`, ID 24990–24994, `semanticGroup = "achievement_reward"`.
7. **После добавления** — зарегистрируй в `WordRegistry.allSets` и `WordRegistry.allWords`.
8. **Всегда поднимай `WordDataVersion.CURRENT`** при любом изменении слов. `PresetDecksVersion` отдельно поднимать не нужно (кроме изменений в DeckSeed-колодах).
9. **Ровно 25 слов в каждом наборе.** После написания проверяй:
   ```bash
   grep -c "setId = XXXX," WordDataXxx.kt
   ```
10. **Проверяй дубли между всеми новыми файлами батча** после написания, не только с уже существующими:
    ```bash
    # Полный аудит дублей по всей базе одной командой:
    grep -h 'setId = 1[0-9][0-9][0-9]' app/src/main/java/com/example/kartonki/data/WordDataHebrew*.kt \
      app/src/main/java/com/example/kartonki/data/WordDataHebrewImmigrant*.kt 2>/dev/null \
      | grep -oE 'original = "[^"]+"' | sort | uniq -d
    # Любой вывод = дубль → починить до коммита.
    ```

## Частые ошибки
- Дубль по `original` → REPLACE удаляет старую строку → старый набор теряет слово → становится 24-словным.
- Замена дубля выбрана «по смыслу» без grep → замена тоже дубль (cashback, garnish, liability...).
- Для иврита `grep -w` ненадёжен с огласовками. Только `grep -F`.
- `name`/`description` написаны на иврите — ошибка незаметна в коде, но видна в UI.
- Написал меньше 25 слов (повторялось на наборах 1022–1037, 1019–1021).
- Контекстное окно кончилось в середине набора → набор получил 2–4 слова (setId=87).
- При исправлении коротких наборов проверяй соседние группы тоже.
- **Широкий диапазон редкости** (COMMON → EPIC в одном наборе) — добавляешь «интересное» последнее слово, не замечая, что оно выбивается по уровню. Следи за разбросом при написании каждого набора.
- **Не проверял большие файлы Immigrant10–12** — их содержимое не влезает в контекст, поэтому grep по всей директории обязателен.

## Полный аудит всех наборов

**Основной инструмент — `find_real_dupes.py`** (в корне проекта):
```bash
python find_real_dupes.py
```
Показывает, какие слова фактически будут «украдены» из каких наборов при загрузке в БД (симулирует REPLACE). Ожидаемый результат: `0 stolen words, 1 sets with != 25 words` (только set 0).

Дополнительно — `audit_all.py` для синонимов/производных:
```bash
python audit_all.py
```
Это более широкая проверка (нормализованные дубли, синонимы, производные).

Bash-версия подсчёта слов по файлу:
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
