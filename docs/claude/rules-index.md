# Правила и стандарты — индекс

Канонический список правил работы в Kartonki. Все правила расписаны в своих файлах; здесь — только короткое summary + якорная ссылка.

**Когда читать:** перед любой существенной задачей сверяйся с этим индексом, чтобы не пропустить правило. `CLAUDE.md` указывает, что читать для задачи; этот индекс указывает, какие правила в принципе существуют.

**Когда обновлять:** когда ты (или будущий Claude) добавляешь/меняешь правило — обнови эту страницу и соответствующий doc. Память — не источник правды, репо — источник.

## Правила по нумерации

Нумерация сохранена из сессии обхода правил (2026-04-22..23). Каждое правило — либо подтверждённое, либо подтверждённое + улучшенное.

### Содержание слов и наборов

1. **Шкала редкости CEFR** — `COMMON=A1, UNCOMMON=A2-B1, RARE=B2, EPIC=C1, LEGENDARY=C2+`. См. `CLAUDE.md` («Шкала редкости слов»).
2. **Редкость объективна, менять нельзя ради удобства** — метка CEFR привязана к слову, не к позиции в наборе. См. `memory/feedback_rarity_never_change.md`.
3. **Разброс редкости в наборе ≤ 2 смежных уровня** — не «плавная прогрессия». См. [`word-sets.md`](word-sets.md).
4. **Структура наборов — 5 уровней** (основы/продвинутый/углублённый/профессиональный/носитель). Для обширной темы (Еда, AI и ML, Медицина и т.п.) — **обязательно минимум 5 наборов, по одному на level**. Только-L1 тема в обширной области = «недоделанная» (UI без прогрессии). Меньше 5 разрешено только для объективно узких тем (Приветствия, Цветы — нет лексики на верхних уровнях). Уточнено 2026-05-06. См. [`word-sets.md`](word-sets.md) и `memory/feedback_set_structure.md`.
5. **Политика дублей** — внутри темы нет, между темами ок. См. [`word-sets.md`](word-sets.md).
6. **Чеклист редактирования набора** — 25 слов, тема, нет однокоренных, переводы уникальны. См. `memory/feedback_seeddata_wordsets.md`.

### Качество текстов

7. **Стандарт качества определений** (`definition`, `definitionNative`) — живой стиль учителя, ≤16 слов / ≤90 символов (смягчено 2026-04-24 с 14/80 для релиза), нет однокоренных с original/translation, формула «суть — например, X, Y, Z» максимум 60-70% слов набора (правило 8 стандарта). См. [`quality_standards_definitions.md`](quality_standards_definitions.md).
8. **Стандарт качества example-предложений** — целевое слово в форме `original`, ≤14 слов / ≤90 символов (англ.), ≤12 слов / ≤80 символов (иврит). Живая речь носителя. Rule 2 «Однозначность пропуска» смягчено — близкие соседи теперь ловит runtime pipeline (см. правило 17b ниже). См. [`quality_standards_examples.md`](quality_standards_examples.md).

8a. **Hard-блок валидаторы качества текстов (2026-05-25..27)** — серия валидаторов закрывает классы багов, ранее ловившихся только при ручном аудите. Подключены в `validate_all.sh` (**20 проверок total: 18 hard-блок + 2 advisory**), pre-commit hook автоматически их применяет. Advisory — `validate_group_sizes` (после Phase 2 эксперимента 2026-04-23) и `validate_no_cognates` (heuristic с known FP) — оба printят warning но не блокируют коммит. Дополнительно есть `validate_original_in_examplenative` — scan-only (не в `validate_all.sh` из-за ~17% FP rate; для батч-аудита).

   - `validate_no_headword_in_def` — `original` (en/he) не должен литерально стоять в собственном `definition` (квиз превращается в matching). Hard block.
   - `validate_no_translation_in_defnative` — русский `translation` не должен литерально стоять в собственном `definitionNative` (тавтология на LEGENDARY card flip). Симметричен предыдущему.
   - `validate_text_terminators` — все 4 text-поля заканчиваются на `.!?…")]`. Типографическая чистота.
   - `validate_original_in_example` — `original` (или его 3-char stem с Hebrew prefix tolerance) должен присутствовать в `example`. Иначе FILL_IN_BLANK ломается.
   - `validate_no_foreign_in_examplenative` — `exampleNative` начинается с заглавной русской/Hebrew/цифры/кавычки. Строчная латинская в начале = непереведённое английское слово (известный класс багов).
   - `validate_no_clerical` — запрещены канцеляризмы из `quality_standards_*.md` («являться», «осуществить», «представляет собой», «характеризуется», «используется для», «данный объект» и пр.).
   - `validate_blank_ambiguity_hebrew` — Python-port `HebrewBlankMatcher`; ловит safe-но-runtime-не-найдёт слова в Hebrew FILL_IN_BLANK.
   - `validate_no_foreign_script_in_original` — `original` использует script соответствующий languagePair (Hebrew для he-ru, Latin для en-ru). Ловит mixed-script опечатки типа арабская `ت` U+062A vs ивритская `ת` U+05EA.

### Идентификация и структура

9. **Формула ID** — `id = setId × 100 + позиция (1..25)`. Позиция глобальная по всем файлам, если набор разнесён. См. [`word-sets.md`](word-sets.md).
10. **Формат имени набора** — `name = topic` (финал 2026-04-24). Все различия между сетами одной темы (уровень, подтема, акцент) живут только в `description`; `description` всех сетов в теме должны быть уникальны. Применяется только к встроенным наборам — для UGC отдельный трек (см. [`ugc-plan.md`](ugc-plan.md)). Валидатор `check_name_consistency` в `find_real_dupes.py` ослаблен до проверки `name.startswith(topic)` (пропускает старый формат у legacy-сетов), но новые сеты всегда `name = topic`. Историю смены формата см. в `memory/feedback_set_naming_pattern.md`.
11. **Описание без CEFR-меток** — никаких «(A1)», «B2» в `description`. Блокирующая проверка с 2026-04-23 (regex case-insensitive). См. `find_real_dupes.py#check_description_cefr`.

### Процесс

12. **Git-правила** — явные пути в `git add` (никогда `-A`), bump `WordDataVersion` при любых правках `WordData*.kt`, коммит на русском + `Co-Authored-By: Claude Opus 4.7 (1M context) <noreply@anthropic.com>`, push после каждой задачи. Pipeline-скрипты автоматически bump'ают версию. См. `CLAUDE.md` («Git — после каждой задачи»).
13. **Параллельные агенты** — нельзя одновременно: `WordRegistry.kt`, `WordDataVersion.kt`, наборы одного языка, Room-миграции. Можно: разные языки (en-ru + he-ru), независимые документы. См. `CLAUDE.md`.
14. **Стандарт метаданных `pos`/`semanticGroup`** — длинные формы (`adjective`, не `adj`), snake_case, группы 3-8 слов оптимум, принцип «опасных близнецов». Для FILL_IN_BLANK tier-порядок инвертирован. См. [`quality_standards_metadata.md`](quality_standards_metadata.md).

### Данные

15. **Транслитерация — только для en-ru (IPA)** — у he-ru слов `transliteration` НЕ заполняется (убрано 2026-05-28: огласовка-никуд в `original` + TTS дают произношение, а схема транслитерации была рассинхронизирована). У en-ru `transliteration` = IPA в квадратных скобках (`[dɔg]`). Валидатор `validate_hebrew_transliteration_format` и проверка `check_transliteration_missing` удалены.
16. **Обязательные поля WordSetEntity и WordEntity** — 6 обязательных в WordSetEntity (id, name, description, languagePair, topic, level), 6 в WordEntity (id, setId, languagePair, rarity, original, translation; для en-ru также `transliteration` = IPA). `orderIndex` исторический, в новых наборах можно опустить. См. [`word-sets.md`](word-sets.md).

16b. **Покрытие опциональных полей (2026-04-23 аудит) — известный техдолг.** Из 18 475 слов:
    - ~63% без `definition`/`example` (нет FILL_IN_BLANK и DEFINITION-квизов)
    - ~62% без `pos`/`semanticGroup` (дистракторы случайны)
    Распределение: en-ru почти полностью заполнено (99.9%), he-ru на 84% skeleton.
    FILL_IN_BLANK pipeline (правило 17b) может работать на ~280 заполненных наборах из 739. Заполнение skeleton-слов текстами — отдельный проект через агенты `text-author` + `metadata-filler`.

16c. **Hebrew FILL_IN_BLANK runtime (обновлено 2026-05-26) — закрыто `HebrewBlankMatcher`.** Раньше: 1014 слов помечены `isFillInBlankSafe = false` (6.8% Hebrew), потому что strict `example.replace(original, "_____")` ломался на Hebrew-префиксах (`לְבֵית` vs `בֵּית`). Теперь:
   - `app/.../domain/quiz/HebrewBlankMatcher.kt` — runtime matcher с tolerance к префиксам `ה/ב/ל/מ/כ/ו/ש` + комбинациям + nikud + multi-word с per-token prefix + word-boundary.
   - Подключён в `QuizBuilder.kt:165` для `languagePair == "he-ru"`; en-ru сохраняет strict replace.
   - 10 unit-тестов (`HebrewBlankMatcherTest`) + integration-тесты в `QuizBuilderTest` для Hebrew FILL_IN_BLANK веток.
   - Python-port `scripts/validate/hebrew_blank_matcher.py` ⇄ Kotlin parity, используется в `validate_blank_ambiguity_hebrew`.
   - Net result: 1014 → 255 unsafe (6.8% → 1.7%). Оставшиеся 255 — реальные suffix-flexions (`חוֹטֶם → חוֹטְמָהּ`), runtime корректно fallback к MULTIPLE_CHOICE_TRANSLATION.

16d. **Preset decks (обновлено 2026-04-27) — закрыто валидатором.** Раньше техдолг (~129 несоответствий: orphan-слова, cross-topic rarity collisions, level-limit overflows). Теперь:
    - Создан `scripts/validate/validate_preset_decks.py` — ловит ORPHAN / WRONG_RARITY / LIMIT_VIOLATION с учётом WordRegistry порядка (last-write-wins как в Room).
    - Подключён в pre-commit hook (раздел 2d): любая правка `WordData*.kt` блокируется коммитом, если ломает какую-либо DeckSeed — даже если автор редактировал совсем другой набор.
    - Все 28 preset-колод приведены в порядок (commits bd21486..459ef64 за 2026-04-27).
    Полная документация по DeckSeed, типичным багам и workflow фикса — [`preset-decks.md`](preset-decks.md).
    Тест `SeedDataAuditTest.preset_decks_rarity_distribution` всё ещё `@Ignore`, потому что использует first-occurrence (вместо last-write-wins) — Python-валидатор корректнее. Можно удалить или починить тест отдельной задачей.

### Мета

17. **«Читай CLAUDE.md перед задачей»** — CLAUDE.md = фронт-дор, там таблица «задача → какой doc читать». Дальше — этот индекс правил. Если находишь новый «подводный камень» — добавляй в соответствующий doc и в этот индекс. См. `CLAUDE.md`.

17b. **FILL_IN_BLANK exclusions pipeline** (связанное правило, введено 2026-04-22) — трёхслойная защита квиза от неоднозначных дистракторов: раздельная стратегия `QuizBuilder` для FILL_IN_BLANK, поле `fillInBlankExclusions` со списком соседей-синонимов, `isFillInBlankSafe = false` для безнадёжных. См. [`fill-in-blank-pipeline.md`](fill-in-blank-pipeline.md).

17c. **Pipeline overview как единая карта** (введено 2026-05-27 audit Phase C) — [`pipeline-overview.md`](pipeline-overview.md) описывает все компоненты pipeline'а (контент, стандарты, исполнители, валидаторы, gates), жизненные циклы (новый сет, правка example, правка definition, batch-аудит) и навигационную карту в одном файле. Не дублирует правила — только ссылается на детальные doc'и.

## Источник правды

1. **Репо-документы (`docs/claude/*.md`)** — ЕДИНСТВЕННЫЙ источник правды. Все правила и стандарты живут тут.
2. **CLAUDE.md** — фронт-дор с таблицей навигации.
3. **Этот индекс (`rules-index.md`)** — канонический список правил. Каждое — ссылка на детальный doc.
4. **Валидаторы в `scripts/validate/`** — машинное enforcement того, что поддаётся автоматизации.
5. **Память (`~/.claude/.../memory/`)** — контекст сессий и решений; **НЕ** источник правды для правил. Ссылается на репо.
6. **Agents/skills (`.claude/agents/*.md`, `.claude/skills/*/SKILL.md`)** — исполнители; должны всегда читать актуальные doc'и перед работой.

## История обновлений

- **2026-04-22..23** — большая сессия обхода правил. Добавлены/уточнены 17 правил, реализован FILL_IN_BLANK pipeline (Фазы 1-3 на пилотном наборе 9). Две проверки переведены из warning в block: CEFR в описаниях (№11), транслитерация he-ru (№15). `orderIndex` задокументирован как исторический (№16).
- **2026-05-25..27** — серия аудитов и фиксов 11 классов багов (headword-in-def, translation-in-defNative, терминаторы, copy-paste в exampleNative, missing original в example, канцелярит, IPA в Hebrew translit, mixed-script в original, Hebrew FILL_IN_BLANK runtime, mixed-script внутри слов, монотонные шаблоны examples). Hard-блок-валидаторы добавлены (правило 8a). Hebrew FILL_IN_BLANK обновлён runtime matcher'ом (правило 16c). `validate_all.sh` теперь **21 проверка**.
- **2026-05-28** — pipeline audit (Phases A/B/C `8fd020a→9223ddd`) + fixture coverage 8→19 валидаторов (`036de06`, 38 регрессионных проверок) + batch-fix 60 сетов exampleNative anchor (`e5622bc`, 110 violations → 50 pre-existing tech-debt). Memory синхронизирована, релиз v0.1.14 готовится. Pipeline-overview.md (правило 17c) — единая навигация по системе.
- **2026-05-28** — **убрана транслитерация у иврита** (правило 15 переписано). После ревью: схема he-ru transliteration была рассинхронизирована (латиница vs кириллица), а огласовка-никуд в `original` + TTS уже дают произношение. Вычищено ~15K `transliteration` из 267 `WordDataHebrew*.kt`, скрыто в UI (`CardView`, `StudySessionScreen`), удалён `validate_hebrew_transliteration_format` + проверка `check_transliteration_missing`, обновлены `add-words/SKILL.md` и доки. en-ru IPA не тронут. `validate_all.sh` теперь **20 проверок**, регрессия — 36.
