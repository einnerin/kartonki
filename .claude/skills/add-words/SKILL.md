---
name: add-words
description: Добавить новый тематический набор из 25 слов в Kartonki (en-ru или he-ru). Использовать всегда, когда пользователь просит создать новый сет, добавить слова по теме, пополнить базу слов, или сделать набор на определённую тему. Skill выполняет полный цикл: проверка дублей, написание ровно 25 слов с правильным распределением редкостей, все 8 валидаторов, полировка, **FILL_IN_BLANK exclusions + flip safety flag (обязательно)**, регистрация в WordRegistry, поднятие версии, сборка, коммит и пуш.
---

# Добавление набора слов в Kartonki

## 0. Обязательная подготовка

**Прежде чем что-либо делать — прочитай:**
- `CLAUDE.md` → секция **«Наборы слов (Word Sets / Seed Data)»** — там актуальный чеклист и перечень частых ошибок
- `app/src/main/java/com/example/kartonki/data/WordRegistry.kt` → найди:
  - `languageIdBlocks` (en-ru = 1..999, he-ru = 1001..1999)
  - последний использованный `setId` в нужном языке
  - формат `allSets` и `allWords`
- `docs/claude/quality_standards_definitions.md` — стандарт качества поля `definition` (живой стиль учителя, без однокоренных, лимит длины)
- `docs/claude/quality_standards_examples.md` — стандарт качества поля `example` (живая речь носителя, однозначный пропуск, лимит длины)
- `docs/claude/quality_standards_metadata.md` — стандарт качества полей `pos` и `semanticGroup` (длинные формы, snake_case, принцип «опасных близнецов», оптимум группы 3-8 слов)

## 1. Уточни у пользователя (если не указано)

- **Язык:** en-ru или he-ru
- **Тема** набора (1 слово или короткая фраза)
- **Уровень:** начальный / средний / продвинутый — влияет на распределение редкостей
- **Куда писать:** в какой `WordData*Batch*.kt` файл. По умолчанию — в последний batch; если он заполнен, создать новый batch-файл.

## 2. Подбор setId

- setId должен быть в блоке языка и **не пересекаться** с существующими
- Проверь: `grep -rE "setId = [0-9]+" app/src/main/java/com/example/kartonki/data/ | grep -oE "[0-9]+" | sort -u | tail`
- Следующий свободный setId — обычно `последний + 1`

## 3. Проверка дублей (КРИТИЧНО)

Это самая частая причина багов. **Каждое слово** из задуманного списка проверить batch-командой:

```bash
cd /c/Users/Einerin/AndroidStudioProjects/kartonki/app/src/main/java/com/example/kartonki/data
for word in слово1 слово2 слово3 ...; do
  result=$(grep -rFl "original = \"$word\"" . 2>/dev/null)
  if [ -n "$result" ]; then
    echo "ДУБЛЬ: '$word' — $result"
  else
    echo "СВОБОДНО: '$word'"
  fi
done
```

**Правила:**
- Для иврита используй `grep -F` (точное байтовое совпадение) — огласовки ломают `-w`
- Каждую **замену дубля** тоже проверяй grep-ом — замена сама может оказаться дублем
- Не полагайся на память — ранние batch-файлы (1–249) выходят за окно контекста и не видны

## 4. Проверка на слова-награды достижений

Не используй слова из `AchievementCards.ALL_EXCLUSIVE` — они зарезервированы для достижений:

```bash
grep -A 100 "ALL_EXCLUSIVE" app/src/main/java/com/example/kartonki/data/AchievementCards.kt
```

## 5. Распределение редкостей

Шкала (из `feedback_rarity_scale.md`):
- **COMMON** — A1, детская лексика (≈ 10 слов на набор)
- **UNCOMMON** — A2–B1 (≈ 8 слов)
- **RARE** — B2 (≈ 4 слова)
- **EPIC** — C1 (≈ 2 слова)
- **LEGENDARY** — C2+ / архаика (≈ 1 слово)

**Все 5 уровней обязательны в каждом наборе.** Не смешивай слишком разные уровни в одном наборе.

## 6. Написание набора

### Именование набора (финальное правило 2026-04-24)

**`name = topic`.** Всегда, без исключений. Всю различающую информацию клади в `description`.

```kotlin
WordSetEntity(
    id = 1600,
    name = "Медицина",                        // = topic
    description = "Тело, боль и самочувствие", // различает этот сет от остальных «Медицина»
    topic = "Медицина",
    level = 1,
    languagePair = "he-ru",
    orderIndex = ...,
)
```

**Хорошие `description`:**
- ✅ `"Тело, боль и самочувствие"` (для первого набора темы «Медицина»)
- ✅ `"У врача: приём, жалобы, диагноз"`
- ✅ `"Купат холим, аптека, лекарства"`
- ✅ `"Документы: паспорт, теудат зеут, виза"` (для «Алия и Израиль»)

**Плохие `description`:**
- ❌ `"Медицина"` — повторяет topic, ничего не добавляет
- ❌ `"Продвинутый уровень"` — не объясняет содержимое
- ❌ `"Набор 1"` — порядковый номер

**Критично:** в одной теме `description` всех сетов должны быть уникальными. `find_real_dupes.py` проверяет это по паре `(name, description, languagePair)`.

**Why:** UI показывает topic в заголовке темы и description как заголовок карточки сета. Если name = topic, то description становится единственным различителем. Старый формат `{topic}: {level} — {subtopic}` отменён — создавал двойные двоеточия и дублирование информации в UI. См. `~/.claude/.../memory/feedback_set_naming_pattern.md`.

Если 25 слов не распадаются на осмысленное описание — возможно набор собран плохо, пересобрать.

### Формат WordEntity

Формат записи (см. существующие WordData*.kt):
```kotlin
WordEntity(
    id = SET_ID * 100 + POSITION,  // position 1..25
    original = "слово",
    translation = "перевод",
    definition = "определение",
    rarity = Rarity.COMMON,
    languagePair = "en-ru",
    setId = SET_ID,
    semanticGroup = "тема_латиницей",
    transliteration = null,         // для иврита — обязательно
    ipa = "...",                    // для английского — IPA транскрипция
),
```

**Требования:**
- Ровно **25 слов**, номер позиции 1..25
- Для английского — всегда заполнять `ipa`
- Для иврита — всегда заполнять `transliteration`

**Качество текстов (обязательно по стандартам — см. п.0):**
- `definition` — живой стиль учителя, нет однокоренных с `original`/`translation`, ≤14 слов / ≤80 символов
- `example` — живая речь носителя, целевое слово присутствует, пропуск однозначен, ≤12 слов / ≤80 символов (англ) или ≤10 / ≤70 (иврит)

**Метаданные каждого слова (по стандарту `quality_standards_metadata.md`):**
- `pos` — часть речи из допустимого множества (длинные формы): `noun`/`verb`/`adjective`/`adverb`/`number`/`phrase`/`preposition`/`interjection`/`conjunction`/`pronoun`. Короткие формы (`adj`, `adv`, `interj`, `pron`) **запрещены** — ломают strict-equality в QuizBuilder.
- `semanticGroup` — snake_case, формат `{topic_prefix}_{subtopic}`. В сете 3-8 подгрупп по принципу «опасных близнецов» (см. стандарт). Группа из 1 слова — нельзя, из 13+ — тоже. Перед выбором префикса grep'нуть существующие.

## 7. Проверка после написания (ОБЯЗАТЕЛЬНО — блокирующая валидация)

### 7.1. Обязательная валидация через `validate_all.sh`

```bash
bash scripts/validate/validate_all.sh <newSetId>
```

Запускает **все 7 валидаторов** (fields_filled, pos_values, group_sizes, text_lengths, rarity_spread, no_duplicates, no_cognates).

**Правило**: если код возврата не 0 — **НЕ ПРОДОЛЖАТЬ**. Проанализировать отчёт, исправить нарушения, повторить `validate_all.sh`. Цикл до полного успеха.

Типичные провалы и что делать:

| Валидатор | Что делать при провале |
|-----------|------------------------|
| `validate_fields_filled` | Найти слова с пустым/отсутствующим полем (definition/example/pos/semanticGroup и т.д.), дописать по стандарту |
| `validate_group_sizes` | Перегруппировать по «опасным близнецам» (см. `quality_standards_metadata.md`). 1 слово в группе → объединить; 13+ → раздробить |
| `validate_text_lengths` | Сократить определение (≤14 слов/80 симв) или пример (≤12/80 для англ, ≤10/70 для иврита) |
| `validate_no_cognates` | Переписать определение без однокоренных с `original`/`translation`. Исключение — отдельные компоненты многословного `original` (см. стандарт definitions) |
| `validate_pos_values` | Короткие формы → длинные (`adj`→`adjective`, `adv`→`adverb`, `interj`→`interjection`, `pron`→`pronoun`), либо уточнить категорию по стандарту метаданных |
| `validate_rarity_spread` | Перераспределить редкости в пределах 2 смежных уровней; заменить слова выбивающегося уровня на подходящие |
| `validate_no_duplicates` | Найти дубли (внутри setId или с другим setId той же темы), заменить одно из слов на семантически близкое. **Проверить замену grep-ом** — она тоже может оказаться дублем |

### 7.2. QA-полировщики

После **успешной** `validate_all.sh` — прогнать `definition-polisher` и `example-polisher` на новом `setId`. Если они внесли правки — значит стиль изначально недотягивал до стандарта, учесть в следующий раз.

### 7.3. Повторная валидация после полировщиков

Полировщики могут поменять длину текстов. Ещё раз:

```bash
bash scripts/validate/validate_all.sh <newSetId>
```

Провал здесь — противоречие между стандартом и полировщиком (стандарт требует X, polisher переписывает в Y). **Остановиться и обсудить с пользователем** — это баг в инструкции, не нарушение данных.

### 7.4. Переход к следующему шагу

Только после **двух успешных валидаций подряд** (до и после полировщиков) — переходить к регистрации в WordRegistry и коммиту (шаги 8–11).

### 7.5. FILL_IN_BLANK pipeline (ОБЯЗАТЕЛЬНО, не опционально)

После полировщиков и перед коммитом — прогнать полный FILL_IN_BLANK pipeline: exclusions + flip safety flag. Это защита квиза FILL_IN_BLANK от «ложных дистракторов»: когда подставляешь сосед из того же сета в пропуск — получается тоже корректное предложение, и игрок зря теряет очки. Детали: `docs/claude/fill-in-blank-pipeline.md`.

Без этого шага **нельзя коммитить** — новый набор будет отображаться в UI с некорректными квизами. Тестовая установка покажет дефект, Play Store рецензент — тоже.

```bash
# 1. Генерация промпта (требует PYTHONIOENCODING=utf-8 на Windows из-за символа →)
PYTHONIOENCODING=utf-8 python scripts/validate/fill_in_blank_prompt.py --set-id <newSetId> > /tmp/prompt.md

# 2. Прогон general-purpose subagent на промпте
# Subagent применяет 5 правил ко всем 24 соседям каждого из 25 слов,
# возвращает JSON массив. Для иврита Rule 1 (артикли) неприменимо,
# но Rule 3 (form_mismatch) критично — префиксы ה/ב/ל/מ ломают буквальное совпадение.
# Промпт передаётся полностью в Agent call (content of .prompt_<id>.md),
# subagent пишет ответ в .out_<id>.json через Write.

# 3. Применить exclusions + поднять WordDataVersion автоматически
PYTHONIOENCODING=utf-8 python scripts/validate/generate_fill_in_blank_exclusions.py \
    --set-id <newSetId> \
    --llm-output .out_<newSetId>.json \
    --apply

# 4. Поставить isFillInBlankSafe = true на все безопасные слова сета
#    (safety net пометит form_mismatch как false автоматически)
PYTHONIOENCODING=utf-8 python scripts/validate/generate_fill_in_blank_exclusions.py \
    --set-id <newSetId> \
    --llm-output .out_<newSetId>.json \
    --flip-safety-flag
```

Выход — в каждом WordEntity нового набора появится `fillInBlankExclusions = listOf(...)`, а `isFillInBlankSafe` либо останется `true` (дефолт), либо станет `false` для слов с form_mismatch.

### 7.6. Финальная валидация (обязательно)

После pipeline — повторить `validate_all.sh`:

```bash
bash scripts/validate/validate_all.sh <newSetId>
```

Теперь все 8 проверок (включая `validate_blank_ambiguity`) должны быть ✅ (или WARN — не блок).

### 7.7. Доп.диагностика (опционально)

Если нужна картина по всей базе:

```bash
bash scripts/validate/audit_all_files.sh
```

Проходит по всем setId во всех файлах. Показывает, какие setId не проходят все 8 проверок (известный техдолг — см. `docs/claude/polishing_plan.md`).

## 8. Регистрация в WordRegistry

Открыть `data/WordRegistry.kt` и добавить:
- Новый `WordSetEntity` в `allSets`
- Новые слова в `allWords` (через spread оператор от объекта WordDataXxx)

Если создан **новый файл** WordData*.kt — импортировать его в WordRegistry.

## 9. Поднять версию

Открыть `data/WordDataVersion.kt`, увеличить `CURRENT` на 1.

**`PresetDecksVersion` поднимать НЕ нужно** — CollectionRepository автоматически пересобирает пресетные колоды при изменении WordDataVersion. Исключение: если меняется состав DeckSeed-колод.

## 10. Сборка

```bash
JAVA_HOME="C:/Program Files/Android/Android Studio/jbr" ./gradlew assembleDebug
```

Только при **BUILD SUCCESSFUL** идти дальше. Если ошибки — исправить и пересобрать.

## 11. Коммит и пуш

**Никогда не использовать `git add -A` или `git add .`** — может захватить untracked-мусор из параллельных сессий. Только явные пути:

```bash
git add app/src/main/java/com/example/kartonki/data/WordData<нужныеФайлы>.kt \
        app/src/main/java/com/example/kartonki/data/WordRegistry.kt \
        app/src/main/java/com/example/kartonki/data/WordDataVersion.kt

# Почистить временные файлы промпта/ответа (они в .gitignore, но для аккуратности)
rm -f .prompt_<newSetId>.md .out_<newSetId>.json

git commit -m "$(cat <<'EOF'
Добавить набор слов «<тема>» (set <ID>): <язык>, уровень <уровень>

<1–2 строки описания — какие темы покрывает, особенности>

Co-Authored-By: Claude Opus 4.7 (1M context) <noreply@anthropic.com>
EOF
)"
git push origin main
```

## Чеклист финальной проверки

Перед сообщением пользователю о завершении:

- [ ] 25 слов в наборе (grep -c = 25)
- [ ] Нет дубликатов внутри набора
- [ ] Нет дубликатов с другими наборами (grep -rFl проверен для каждого слова)
- [ ] Все 5 редкостей представлены
- [ ] Нет слов из AchievementCards.ALL_EXCLUSIVE
- [ ] Для английского — есть IPA у всех слов
- [ ] Для иврита — есть transliteration у всех слов
- [ ] `name = topic`, уникальное непустое `description`, не дублирующее description других сетов той же темы
- [ ] `validate_all.sh <setId>` прошёл (шаг 7.1)
- [ ] Полировщики прогнаны и повторный `validate_all.sh` тоже прошёл (шаги 7.2-7.3)
- [ ] **FILL_IN_BLANK pipeline прогнан полностью** (шаг 7.5): `--apply` + `--flip-safety-flag`
- [ ] Зарегистрирован в WordRegistry.allSets и allWords
- [ ] WordDataVersion.CURRENT поднят (pipeline сам поднимает, но проверить git diff)
- [ ] BUILD SUCCESSFUL
- [ ] `git add` по явным путям (не `-A`)
- [ ] Коммит сделан и запушен

## Красные флаги — остановись и подумай

- Набор разбит между двумя файлами (setId 8701–8702 в одном, 8703 в другом) — это признак оборванной генерации
- grep находит дубль, но это «вроде другое слово» — проверь ещё раз, не полагайся на интуицию
- Меньше 25 слов «закончились идеи» — лучше попросить у пользователя подсказку по теме, чем оставить неполный набор
- При исправлении группы сетов (напр. 1022–1037) — обязательно проверить соседние (1019–1021, 1038–1040) на ту же проблему
