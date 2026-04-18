# Правила: Наборы слов (Word Sets / Seed Data)

## Файлы для чтения перед работой
- `data/WordRegistry.kt` — реестр всех наборов/слов/колод
- `data/AchievementCards.kt` — слова-исключения (нельзя добавлять в обычные наборы)
- Соответствующий `WordDataXxx.kt`

## Как работает загрузка в БД
- `WordLoader.doLoad()` срабатывает при `storedVersion < WordDataVersion.CURRENT`
- Наборы: `insertSets` (IGNORE) + `updateSetMetadata` (только seed-поля: `name`, `description`, `orderIndex`). Поле `isFavorite` — пользовательское, не трогать.
- Слова: `insertAllOrReplace` = REPLACE по PK. Есть UNIQUE-индекс `(original, languagePair)` — дубль уничтожает старую строку, старый набор теряет слово.

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

   > ⚠️ **Файлы Immigrant10–12 слишком большие для ручного контроля.** Для иврита
   > **всегда** строй полный список занятых слов перед написанием нового файла:
   > ```bash
   > grep -h 'setId = 1[0-9][0-9][0-9]' app/src/main/java/com/example/kartonki/data/WordDataHebrew*.kt \
   >   app/src/main/java/com/example/kartonki/data/WordDataHebrewImmigrant*.kt 2>/dev/null \
   >   | grep -oE 'original = "[^"]+"' | sed 's/original = "//;s/"//' | sort -u > /tmp/taken_he.txt
   > grep -Fx '"СЛОВО"' /tmp/taken_he.txt  # проверить одно слово
   > ```
   > Дубли **между** новыми файлами тоже опасны — проверяй после написания всех файлов батча.

   > ⚠️ **При переписывании существующих наборов (rewrite)** — особая опасность.
   > Соблазн: исключить переписываемый диапазон из `taken` и выбирать слова «по теме»
   > вручную. Это приводит к сотням незамеченных дублей (прецедент: наборы 1184–1207,
   > 170+ дублей). Правильный подход — Python-скрипт для пакетной проверки кандидатов:
   > ```python
   > import re, glob, sys
   > sys.stdout.reconfigure(encoding='utf-8')
   > # Строим taken, исключая только переписываемый диапазон (например 1184-1207)
   > rewrite_range = set(range(1184, 1208))
   > taken = set()
   > for f in glob.glob('app/src/main/java/com/example/kartonki/data/WordDataHebrew*.kt'):
   >     for e in re.finditer(r'WordEntity\(([^)]+)\)', open(f, encoding='utf-8').read(), re.DOTALL):
   >         om = re.search(r'original\s*=\s*"([^"]+)"', e.group(1))
   >         sm = re.search(r'setId\s*=\s*(\d+)', e.group(1))
   >         if om and sm and int(sm.group(1)) not in rewrite_range:
   >             taken.add(om.group(1))
   > # Проверяем список кандидатов разом:
   > candidates = ["слово1", "слово2", "слово3"]
   > for c in candidates:
   >     print(f"{'TAKEN' if c in taken else 'FREE'}: {c}")
   > ```
   > **Никогда не пиши слово-кандидат в файл без предварительной проверки этим скриптом.**
   > «Тематически уникальное» слово всё равно может быть дублем — база велика (1000+ наборов).

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
- **При переписывании наборов выбирал слова вручную** без Python-проверки кандидатов — результат: 170+ дублей в наборах 1184–1207, незамеченных при написании. В базе 1000+ наборов в 40+ файлах; невозможно знать наизусть, что где лежит. Исключение переписываемого диапазона из `taken` — правильно, но кандидаты всё равно должны проходить автоматическую проверку скриптом (см. блок выше).

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
