# FILL_IN_BLANK pipeline: exclusions + safety net

Этот документ описывает как Kartonki защищает FILL_IN_BLANK-квиз от **неоднозначных дистракторов** — неправильных вариантов, которые на самом деле тоже подходят в пропуск, из-за чего игрок выбирает «правильно выглядящий» ответ и получает «неверно».

## Проблема

Квиз `FILL_IN_BLANK` удаляет целевое слово из его `example` и предлагает игроку выбрать правильное из 4 вариантов. До этой системы `QuizBuilder` тянул 3 дистрактора из той же `semanticGroup` (чтобы квиз был сложнее). Но именно близкие по смыслу слова чаще всего **тоже подходят в пропуск** — «Their ___ has three bedrooms» подходит и `house`, и `apartment`, и `cottage`.

Результат: игрок выбирает семантически валидный дистрактор → система говорит «неверно» → раздражение → отток. До фикса массово помечали слова как `isFillInBlankSafe = false` (4325 из ~18000), что фактически ломало половину квиза.

## Решение — три слоя защиты

### Слой 1 — Раздельная стратегия дистракторов по типу квиза

В `QuizBuilder.pickDistractors` (`app/src/main/java/com/example/kartonki/domain/quiz/QuizBuilder.kt`) есть флаг `forFillInBlank`:

| Квиз | Стратегия |
|------|-----------|
| TRANSLATION / DEFINITION / WORD_FROM_DEF | `sameSem + diffSem + diffPos` (близкие сначала — сложнее) |
| FILL_IN_BLANK | `diffSem + sameSem + diffPos` (далёкие сначала — меньше ambiguity) |

Реализовано в Фазе 1 (коммит `129b51d`).

### Слой 2 — Поле `fillInBlankExclusions` на каждом слове

`WordEntity.fillInBlankExclusions: List<Long>` хранит id слов **того же набора**, которые подходят в пропуск этого example. Эти id выкидываются из пула дистракторов для FILL_IN_BLANK. Хранятся в Room как comma-separated TEXT, конвертер `WordConverters.kt`.

Слой 2 покрывает то, что Слой 1 не ловит: **межгрупповых ложных друзей**. Например, `apple` и `egg` в разных `semanticGroup` (fruits vs protein_dairy), но оба встают в «She ate an ___ for breakfast».

### Слой 3 — Флаг `isFillInBlankSafe = false` для безнадёжных

Остаются случаи, где никакие exclusions не помогут:
- **Form mismatch**: `original = "egg"`, но `example = "She fried two eggs"` — пропуск рендерится как «two ___s» (мусор).
- **Объективно generic example**: «I saw a ___» — подходит вообще любое существительное, exclusion-список должен быть из всех 24 соседей, проще пометить unsafe и переписать пример.

Такие слова пропускаются в FILL_IN_BLANK, но остаются в TRANSLATION и DEFINITION квизах.

## Pipeline заполнения `fillInBlankExclusions`

### Архитектура

Для каждого слова нужно найти соседей по набору (максимум 24), чьё `original` подходит в пропуск данного слова's example. Это требует смысловой оценки → LLM. Но чистый LLM делает систематические ошибки (нарушения грамматики артиклей, пропуски очевидных случаев). Поэтому pipeline — **LLM-labeller + детерминистический safety net**.

```
  Для каждого set:
    1. LLM subagent размечает exclusions для 25 слов (промпт v3)
       → JSON со списком exclusion-id на каждое слово
    2. Python safety net чистит и дополняет результат:
       a. Удаляет Rule 1 нарушения (artлык не совпадает с началом кандидата)
       b. Автодобавляет same-semanticGroup + same-pos + same-rarity соседей,
          которые проходят Rule 1 и ещё не в списке
       c. Автоматически ставит form_mismatch=true для слов, где original ≠ example
    3. Записывает результат в WordData*.kt как
       fillInBlankExclusions = listOf(<id>, <id>, ...)
```

### Качество

| Подход | Misses на 25 слов (критических) | Скорость |
|--------|----------------------------------|----------|
| Pure LLM v3 | ~4/25 (16%) | Быстро |
| LLM + safety net | ~2/25 (8%) | Быстро |
| Manual (я, Claude в чате) | 0-1/25 (~0-4%) | ~30-40 мин на набор |

**Выбранная стратегия (2026-04-22):** LLM + safety net по всей базе → публикация → полировка точечно (Path Б) по конкретным жалобам пользователей. Полный manual pass откладывается как избыточный до появления реальных сигналов из прода.

## LLM промпт (v3)

Хранится в `scripts/validate/fill_in_blank_prompt.py`. Ключевые инструкции:

1. **Rule 1 — Артикль**. `an ___` → только гласные. `a ___` → только согласные.
2. **Rule 2 — Модификаторы**. `roast ___` → проверить «roast [candidate]»; модификатор сохраняется.
3. **Rule 3 — Слово уже в example**. Если candidate есть в example — REJECT.
4. **Rule 4 — Mental substitution**. Подставить и прочитать всё предложение.
5. **Rule 5 — Conservatism**. Если сомнение — включить. Over-exclusion безопасно.
6. **Систематический проход всех 24 соседей**. Не останавливаться на 1-2 «очевидных».

Worked examples в промпте: `apple` (article filter), `tea` (in-sentence repeat). Calibration — агент должен сгенерировать тот же список, что и в примерах.

## Python safety net

`scripts/validate/generate_fill_in_blank_exclusions.py`:

- **Input**: JSON от LLM subagent + данные всех слов набора.
- **Output**: очищенный + расширенный JSON → формат для `Edit` в `WordData*.kt`.

Rules:

1. **Удалить Rule 1 нарушения**. Парсинг example: если перед целевым словом стоит `an`, то exclusions фильтруются до только-гласных.
2. **Автодобавить same-semanticGroup + same-pos + same-rarity соседей**, которые проходят Rule 1. Это гарантия: ни один близкий по смыслу/классу сосед не станет дистрактором, даже если LLM его пропустил.
3. **form_mismatch детекция**. Если `original.lower() not in example.lower()` — ставим `form_mismatch = true`, exclusions = `[]`.
4. **Sanity**: exclusions ⊆ соседей того же set, не включает target сам себя.

## Интерактивный запуск

Для одного набора:

```bash
# 1. Извлечь данные набора в JSON (промпт + метаданные)
python scripts/validate/fill_in_blank_prompt.py --set-id 9 > /tmp/prompt.md

# 2. Скопировать содержимое /tmp/prompt.md в subagent (general-purpose).
#    Subagent возвращает JSON-массив exclusions для 25 слов.

# 3. Сохранить JSON в файл и прогнать через safety net
python scripts/validate/generate_fill_in_blank_exclusions.py \
    --set-id 9 \
    --llm-output /tmp/subagent_out.json \
    > /tmp/final_exclusions.json

# 4. Скрипт также печатает готовые Edit-команды для добавления
#    fillInBlankExclusions = listOf(...) в каждый WordEntity набора.
```

## Регенерация при изменениях

Exclusion-список слова **зависит от его example**. Если example меняется (polisher, ручная правка) — exclusions нужно пересчитать **для этого слова и для всех его соседей по набору** (потому что изменение в одном слове могло сделать его кандидатом в чужие exclusion-списки или выкинуть из них).

Правило:
- При изменении example одного слова — прогонять pipeline по всему его набору.
- При добавлении нового набора (через skill `add-words`) — прогонять pipeline по новому набору после того, как все 25 слов зафиксированы.
- При массовой полировке examples (сеты-чанки) — прогонять по затронутым наборам после завершения чанка.

## Фазы внедрения

- **Фаза 1** (✅ 2026-04-22) — архитектура. `QuizBuilder` раздельная стратегия, поле `fillInBlankExclusions`, Room миграция 39→40, TypeConverter, тесты. Коммит `129b51d`.
- **Фаза 2** (в работе) — LLM labeller + safety net. Prompt v3 откалиброван. Скрипты в `scripts/validate/`. Прогон по всем 18 000 слов.
- **Фаза 3** (после Фазы 2) — аудит `isFillInBlankSafe = false`. После заполнения exclusions большинство из 4325 помеченных слов можно вернуть на `true`. Оставляем `false` только для form_mismatch и объективно generic examples.
- **Фаза 4** — bump `WordDataVersion.CURRENT`, финальный build + push.

## Связанные документы

- `docs/claude/quality_standards_examples.md` — стандарт example (правило 2 «Однозначность» смягчено в пользу runtime exclusions).
- `docs/claude/word-sets.md` — поле `fillInBlankExclusions` в WordEntity.
- `.claude/skills/add-words/SKILL.md` — шаг генерации exclusions для новых наборов.
- `app/src/main/java/com/example/kartonki/domain/quiz/QuizBuilder.kt` — реализация Слоя 1.
- `app/src/main/java/com/example/kartonki/data/db/entity/WordEntity.kt` — поле Слоя 2.
