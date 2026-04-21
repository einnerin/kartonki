---
name: audit-words
description: Запустить полный аудит базы слов Kartonki и выдать отчёт о проблемах. Использовать когда пользователь просит проверить наборы, найти проблемы в базе слов, сделать аудит, проверить качество, посчитать дубли, найти неполные наборы. Skill только читает файлы — ничего не меняет, не коммитит. На выходе — структурированный отчёт.
---

# Аудит базы слов Kartonki

**ВАЖНО:** этот skill **только читает** файлы. Ничего не изменять, не коммитить, не запускать сборку. На выходе — отчёт с категоризацией проблем.

## Структура отчёта

Итоговый отчёт должен содержать 7 секций в таком порядке:

1. **Общая статистика** (числа)
2. **Неполные наборы** (≠ 25 слов)
3. **Дубли слов** (одинаковый `original` в разных местах)
4. **Наборы с неправильным распределением редкостей**
5. **Пропущенные обязательные поля** (IPA / transliteration)
6. **Наборы, разбитые между файлами** (признак оборванной генерации)
7. **Пересечения с AchievementCards.ALL_EXCLUSIVE**

После каждой секции — короткий итог: «Проблем: N» или «Всё чисто».

В конце — **сводка и рекомендация**: массово чинить или нет.

---

## Шаг 1. Общая статистика

```bash
cd /c/Users/Einerin/AndroidStudioProjects/kartonki
DIR="app/src/main/java/com/example/kartonki/data"

echo "=== Файлы данных ==="
ls -1 "$DIR"/WordData*.kt | wc -l

echo "=== Количество слов ==="
grep -rh "WordEntity(" "$DIR"/WordData*.kt | wc -l

echo "=== Уникальные setId по файлам ==="
for file in "$DIR"/WordData*.kt; do
  count=$(grep -oE "setId = [0-9]+" "$file" | sort -u | wc -l)
  echo "$(basename $file): $count сетов"
done
```

Ожидаемое число слов на набор: 25.
Итого слов ≈ (число сетов × 25).

---

## Шаг 2. Неполные наборы (≠ 25 слов)

Главная команда из CLAUDE.md — запустить и собрать весь список проблем:

```bash
DIR="app/src/main/java/com/example/kartonki/data"
for file in "$DIR"/WordData*.kt; do
  fname=$(basename "$file")
  setids=$(grep -oE "setId = [0-9]+" "$file" | grep -oE "[0-9]+" | sort -u)
  for sid in $setids; do
    count=$(grep -c "setId = $sid," "$file" 2>/dev/null || true)
    if [ "$count" != "25" ]; then
      echo "ПРОБЛЕМА: $fname — setId=$sid — $count слов"
    fi
  done
done
```

**Исключения (не считать проблемой):**
- `setId = 0` с 5 словами — сентинел наград достижений, это нормально
- Набор, разбитый между двумя файлами (например 87 в English.kt и EnglishExpanded.kt): если в сумме = 25, считать нормальным, но пометить отдельно в шаге 6

Вывод по секции: список `файл — setId — количество`.

---

## Шаг 3. Дубли слов

### 3.1. Глобальные дубли (одинаковый `original` в разных наборах)

```bash
cd /c/Users/Einerin/AndroidStudioProjects/kartonki/app/src/main/java/com/example/kartonki/data

# Английские
grep -rh "original = " WordDataEnglish*.kt | \
  grep -oE "original = \"[^\"]*\"" | \
  sort | uniq -d

# Ивритские
grep -rh "original = " WordDataHebrew*.kt | \
  grep -oE "original = \"[^\"]*\"" | \
  sort | uniq -d
```

### 3.2. Дубли внутри одного набора

```bash
DIR="app/src/main/java/com/example/kartonki/data"
for file in "$DIR"/WordData*.kt; do
  fname=$(basename "$file")
  setids=$(grep -oE "setId = [0-9]+" "$file" | grep -oE "[0-9]+" | sort -u)
  for sid in $setids; do
    dupes=$(awk -v sid="$sid" '
      /setId = / { current=$0 }
      /original = / && current ~ ("setId = " sid ",") { print }
    ' "$file" | grep -oE "original = \"[^\"]*\"" | sort | uniq -d)
    if [ -n "$dupes" ]; then
      echo "ВНУТРЕННИЙ ДУБЛЬ: $fname, setId=$sid"
      echo "$dupes"
    fi
  done
done
```

Вывод: сгруппировать по языку, показать TOP-20 самых частых дублирующихся слов.

---

## Шаг 4. Распределение редкостей

Для каждого набора должны быть **все 5 редкостей**: COMMON, UNCOMMON, RARE, EPIC, LEGENDARY.

```bash
DIR="app/src/main/java/com/example/kartonki/data"
for file in "$DIR"/WordData*.kt; do
  fname=$(basename "$file")
  setids=$(grep -oE "setId = [0-9]+" "$file" | grep -oE "[0-9]+" | sort -u)
  for sid in $setids; do
    if [ "$sid" = "0" ]; then continue; fi
    # Собрать редкости этого setId
    rarities=$(awk -v sid="$sid" '
      /setId = / { current=$0 }
      /rarity = / && current ~ ("setId = " sid ",") { print }
    ' "$file" | grep -oE "Rarity\.[A-Z]+" | sort -u)
    missing=""
    for r in COMMON UNCOMMON RARE EPIC LEGENDARY; do
      if ! echo "$rarities" | grep -q "Rarity\.$r"; then
        missing="$missing $r"
      fi
    done
    if [ -n "$missing" ]; then
      echo "НЕ ВСЕ РЕДКОСТИ: $fname, setId=$sid, нет:$missing"
    fi
  done
done
```

---

## Шаг 5. Пропущенные обязательные поля

### 5.1. Английские слова без IPA

```bash
DIR="app/src/main/java/com/example/kartonki/data"
for file in "$DIR"/WordDataEnglish*.kt; do
  # Считаем WordEntity блоки без `ipa = ` или с `ipa = null`/`ipa = ""`
  total=$(grep -c "WordEntity(" "$file")
  with_ipa=$(grep -c "ipa = \"[^\"]" "$file")
  missing=$((total - with_ipa))
  if [ "$missing" -gt 0 ]; then
    echo "$(basename $file): $missing слов без IPA (из $total)"
  fi
done
```

### 5.2. Ивритские слова без transliteration

```bash
DIR="app/src/main/java/com/example/kartonki/data"
for file in "$DIR"/WordDataHebrew*.kt; do
  total=$(grep -c "WordEntity(" "$file")
  with_tr=$(grep -c "transliteration = \"[^\"]" "$file")
  missing=$((total - with_tr))
  if [ "$missing" -gt 0 ]; then
    echo "$(basename $file): $missing слов без transliteration (из $total)"
  fi
done
```

---

## Шаг 6. Наборы, разбитые между файлами

Это признак оборванной генерации (набор 87 из истории был таким).

```bash
DIR="app/src/main/java/com/example/kartonki/data"
# Собираем: для каждого setId — в скольких файлах он встречается
declare -A setid_files
for file in "$DIR"/WordData*.kt; do
  fname=$(basename "$file")
  setids=$(grep -oE "setId = [0-9]+" "$file" | grep -oE "[0-9]+" | sort -u)
  for sid in $setids; do
    if [ "$sid" = "0" ]; then continue; fi
    if [ -n "${setid_files[$sid]}" ]; then
      setid_files[$sid]="${setid_files[$sid]}, $fname"
    else
      setid_files[$sid]="$fname"
    fi
  done
done

# Печатаем только те, что в 2+ файлах
for sid in "${!setid_files[@]}"; do
  files="${setid_files[$sid]}"
  if [[ "$files" == *","* ]]; then
    echo "РАЗБИТ: setId=$sid → $files"
  fi
done
```

Для каждого разбитого набора — посчитать суммарное число слов (если в сумме = 25, это ОК исторически, но всё равно стоит консолидировать).

---

## Шаг 7. Пересечения с AchievementCards.ALL_EXCLUSIVE

Слова-награды достижений не должны встречаться в обычных наборах.

```bash
# Вытащить список эксклюзивных слов
EXCL_FILE=/tmp/excl_words.txt
awk '/ALL_EXCLUSIVE/,/\)/' app/src/main/java/com/example/kartonki/data/AchievementCards.kt | \
  grep -oE "\"[^\"]+\"" > "$EXCL_FILE"

# Для каждого искать в обычных наборах
while read -r word; do
  clean=$(echo "$word" | tr -d '"')
  # Ищем вхождения как original, НЕ в setId=0
  result=$(grep -rFl "original = \"$clean\"" app/src/main/java/com/example/kartonki/data/WordData*.kt 2>/dev/null)
  if [ -n "$result" ]; then
    # Проверить, не в setId=0 ли это
    for f in $result; do
      context=$(awk -v w="original = \"$clean\"" '
        /setId = / { current=$0 }
        index($0, w) > 0 { print current }
      ' "$f")
      if ! echo "$context" | grep -q "setId = 0,"; then
        echo "ЭКСКЛЮЗИВ В НАБОРЕ: '$clean' — $f"
      fi
    done
  fi
done < "$EXCL_FILE"
```

---

## Шаг 8. Итоговая сводка и рекомендация

После прохождения всех шагов — собрать таблицу:

```
| Проблема                          | Кол-во | Критичность |
|-----------------------------------|--------|-------------|
| Неполные наборы                   | N      | Высокая     |
| Глобальные дубли                  | N      | Высокая     |
| Внутренние дубли                  | N      | Высокая     |
| Наборы без всех редкостей         | N      | Средняя     |
| Английские слова без IPA          | N      | Средняя     |
| Ивритские слова без transliter    | N      | Средняя     |
| Наборы, разбитые между файлами    | N      | Низкая      |
| Эксклюзивные слова в наборах      | N      | Высокая     |
```

### Рекомендация

Сформулировать одну из трёх:

1. **«Всё в порядке»** — если все счётчики = 0 или мелочи. Массовая переработка не нужна.
2. **«Точечный ремонт»** — если проблем десятки, но не сотни. Исправить конкретные места, не трогая остальное.
3. **«Массовый ремонт»** — если проблем >100 или они системные. Планировать постепенную миграцию с учётом риска OnConflictStrategy.REPLACE → битые `deck_cards`.

Обязательно упомянуть риск: **замена `original` у слова ломает колоды пользователей**. Для критичных фиксов лучше добавлять новое слово и деактивировать старое, чем заменять `original`.

## Что НЕ делать в этом skill

- ❌ Не менять файлы
- ❌ Не коммитить
- ❌ Не запускать `./gradlew`
- ❌ Не предлагать конкретные замены слов (только перечислить проблемы)
- ❌ Не лезть в `build/` директорию

Только чтение и отчёт.
