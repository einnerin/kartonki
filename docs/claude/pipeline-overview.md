# Pipeline overview — Kartonki

Единая карта pipeline'а добавления и обеспечения качества контента. **Здесь — только навигация и жизненные циклы.** Для правил, стандартов и деталей — иди по ссылкам в нужный doc.

## Компоненты pipeline'а

### Контент

| Что | Где | Версия |
|---|---|---|
| Данные слов | `app/src/main/java/com/example/kartonki/data/WordData*.kt` | `WordDataVersion.kt` (bump при любом изменении) |
| Регистрация сетов | `WordRegistry.kt` | — |
| Preset PvP колоды | `WordDataPresetDecks*.kt` + `DeckSeed.kt` | `PresetDecksVersion.kt` (bump при правке) |

### Стандарты качества

| Поля | Стандарт |
|---|---|
| `definition`, `definitionNative` | [`quality_standards_definitions.md`](quality_standards_definitions.md) |
| `example`, `exampleNative` | [`quality_standards_examples.md`](quality_standards_examples.md) |
| `pos`, `semanticGroup` | [`quality_standards_metadata.md`](quality_standards_metadata.md) |

**Источник правды.** Все остальные doc'и и subagent'ы ссылаются на эти три файла, а не дублируют правила.

### Исполнители (subagent'ы)

| Агент | Зона | Файл |
|---|---|---|
| `text-author` | Пишет 4 текст-поля с нуля (где их нет) | `.claude/agents/text-author.md` |
| `example-polisher` | Переписывает existing `example` (+ `exampleNative` синхронно) | `.claude/agents/example-polisher.md` |
| `definition-polisher` | Переписывает existing `definition` ИЛИ `definitionNative` (по `--field`) | `.claude/agents/definition-polisher.md` |
| `metadata-filler` | Добавляет `pos` + `semanticGroup` | `.claude/agents/metadata-filler.md` |

### Skill `/add-words`

Один skill для нового сета — 8 шагов end-to-end: стандарты → ID → text-author → metadata-filler → FILL_IN_BLANK pipeline → валидация → bump версии → commit. См. `.claude/skills/add-words/SKILL.md`.

### Валидаторы

| Уровень | Что | Запуск |
|---|---|---|
| Per-setId (19 hard-блок + 2 advisory) | Полный набор проверок одного сета | `bash scripts/validate/validate_all.sh <setId>` |
| Глобальные | ID-коллизии, дубли тем, разброс редкости, name/topic, transliteration | `python scripts/validate/find_real_dupes.py` (pre-commit hook) |
| Preset DeckSeed | Orphans / wrong rarity / level-limit overflow | `python scripts/validate/validate_preset_decks.py` (pre-commit hook) |
| FILL_IN_BLANK pipeline | hash-based staleness detection | `python scripts/validate/generate_fill_in_blank_exclusions.py --set-id N --apply` |
| Scan-only (не блокирует) | `validate_original_in_examplenative` — exampleNative якорится к слову | Ручной батч-аудит |
| Full-base audit | Прогон всех valid_all.sh по всем setIds | `bash scripts/validate/audit_all_files.sh` (~15 мин) |

**21 валидатор внутри validate_all.sh** (19 hard-блок + 2 advisory: `validate_group_sizes`, `validate_no_cognates`) перечислены в самом скрипте. Регрессия валидаторов через fixture: `scripts/validate/tests/run_tests.sh` (19 × 2 = 38 проверок).

### Защита — 7 уровней

Полная архитектура gates с инцидентами-причинами: [`quality_gates.md`](quality_gates.md).

### FILL_IN_BLANK pipeline

Трёхслойная защита квиза от неоднозначных дистракторов: раздельная стратегия `QuizBuilder`, поле `fillInBlankExclusions`, флаг `isFillInBlankSafe`, `HebrewBlankMatcher` (runtime tolerance к Hebrew-префиксам). Детали: [`fill-in-blank-pipeline.md`](fill-in-blank-pipeline.md).

## Жизненные циклы

### Новый сет (через skill)

```
/add-words "хочу сет по теме X"
  ↓
1. Skill читает 3 стандарта качества
  ↓
2. Skill выбирает свободные ID (формула id = setId × 100 + позиция)
  ↓
3. Skill вызывает text-author для каждого setId (5 уровней = 5 субагентов)
  ↓
4. text-author читает 2 стандарта, пишет 4 текст-поля × 25 слов
  ↓
5. Skill вызывает metadata-filler — добавляет pos/semanticGroup
  ↓
6. Skill прогоняет FILL_IN_BLANK pipeline (LLM-augmented для нюансов)
  ↓
7. validate_all.sh × 5 setIds → 21 проверка зелёные
  ↓
8. WordDataVersion bump + регистрация в WordRegistry
  ↓
9. git add → pre-commit hook (find_real_dupes + validate_all + preset_decks
   + bump check) → commit → push
```

### Правка existing `example`

```
Замечен баг (ручной аудит / валидатор / тестер)
  ↓
example-polisher переписывает (читает quality_standards_examples)
  ↓
FILL_IN_BLANK pipeline пере-запуск (exclusions становятся stale →
  hash-валидатор заблокирует коммит без рефреша)
  ↓
validate_all.sh × N (затронутые setIds)
  ↓
git commit → pre-commit hook → push
```

### Правка existing `definition`

```
Баг найден (типично — headword в собственном definition, канцелярит)
  ↓
definition-polisher (--field=definition или --field=definitionNative)
  ↓
validate_all.sh × N
  ↓
git commit → pre-commit hook → push
```

### Batch-аудит классов багов

Когда находится новый класс багов через ручной обход / тестер:

```
1. Написать regex/scan-only валидатор (.py + .sh)
2. Прогнать по всей базе → собрать список violations
3. Запустить subagent (text/example/definition-polisher) пачкой по нарушениям
4. Подключить валидатор в validate_all.sh (если FP-rate приемлем)
   ИЛИ оставить scan-only (если есть legitimate edge cases)
5. Memory: записать класс багов как закрытый
```

История уже закрытых классов багов — раздел «Истории обновлений» в [`rules-index.md`](rules-index.md).

## Куда идти — карта навигации

| Хочу | Иду в |
|---|---|
| Понять что и где есть | этот файл |
| 17 правил списком | [`rules-index.md`](rules-index.md) |
| Архитектура защиты | [`quality_gates.md`](quality_gates.md) |
| Добавить новый сет | `.claude/skills/add-words/SKILL.md` |
| Правила definition | [`quality_standards_definitions.md`](quality_standards_definitions.md) |
| Правила example | [`quality_standards_examples.md`](quality_standards_examples.md) |
| Правила pos/semGroup | [`quality_standards_metadata.md`](quality_standards_metadata.md) |
| Структура наборов (5 уровней, дубли, ID-формула) | [`word-sets.md`](word-sets.md) |
| FILL_IN_BLANK механика | [`fill-in-blank-pipeline.md`](fill-in-blank-pipeline.md) |
| Preset PvP колоды | [`preset-decks.md`](preset-decks.md) |
| Новый язык (fr-ru, ar-ru) | [`new-language.md`](new-language.md) |
| Запустить один валидатор | `bash scripts/validate/validate_<name>.sh <setId>` |
| Запустить все 21 проверки | `bash scripts/validate/validate_all.sh <setId>` |
| Полный аудит базы | `bash scripts/validate/audit_all_files.sh` (~15 мин) |
| Структура файла данных | `app/src/main/java/com/example/kartonki/data/WordData*.kt` |

## Принципы pipeline'а (важно при добавлении нового)

1. **Стандарты — единственный источник правды для правил.** Subagent'ы и валидаторы ссылаются, не дублируют.
2. **Каждый валидатор сам пишет fix-инструкции** в stderr/stdout. Таблицы «если упал X → сделай Y» в subagent doc'ах не нужны и устаревают первыми.
3. **Не консолидировать валидаторы.** Каждый закрыл реальный класс багов из аудита — слияние ослабит защиту.
4. **При добавлении валидатора:** `.py` + `.sh` + строка в `validate_all.sh`. По возможности — fixture в `scripts/validate/tests/` (good_set + bad_set).
5. **При добавлении правила:** обновить релевантный `quality_standards_*.md` + добавить в `rules-index.md`. Subagent'ы и skill автоматически подхватят (они читают стандарты в начале работы).
