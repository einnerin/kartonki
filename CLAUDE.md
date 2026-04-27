# Kartonki — Android App

Изучение иностранных слов с механикой ККИ. PvE (интервальное повторение) + PvP (pass-and-play на одном устройстве).
Ранги карточек: COMMON (серый) · UNCOMMON · RARE · EPIC · LEGENDARY. Колода ≤ 20 карт.

## ⚠️ Статус запуска: пользователей пока нет

**Приложение ещё не выпущено в Play Store.** Реальных пользователей нет — только тестовые установки разработчика.

**Что это меняет для работы со словами/наборами/заданиями:**
- Можно свободно **удалять, переименовывать, перенумеровывать сеты** — ничей прогресс не потеряется
- **Не писать миграционный код** для сохранения прогресса по меняющимся WordEntity
- Если сет нарушает стандарты на >50% — **переписать с нуля эффективнее, чем латать** (проверено 2026-04-23: ~70-80K токенов на новый сет vs. ~350K на пакет из 10 полировок)
- WordDataVersion всё равно поднимать при любых правках данных — для тестовых установок

**Когда статус поменяется** — пользователь сообщит первым. До этого — полная свобода правок.

См. `docs/claude/release-plan.md` для плана релиза.

## Технический стек

| Слой | Технология |
|------|-----------|
| UI | Jetpack Compose + Material 3 |
| Архитектура | MVVM + Clean Architecture + Hilt |
| БД | Room (локальная) |
| Async | Kotlin Coroutines + Flow |
| Сборка | Gradle KTS, Kotlin 2.2.10, API 36, minSdk 24 |

## Шкала редкости слов

`COMMON` = A1 · `UNCOMMON` = A2-B1 · `RARE` = B2 · `EPIC` = C1 · `LEGENDARY` = C2+

Поле `rarity` в `WordEntity` — строка: `"COMMON"`, `"UNCOMMON"`, `"RARE"`, `"EPIC"`, `"LEGENDARY"`.

## Правила и стандарты

**[`docs/claude/rules-index.md`](docs/claude/rules-index.md)** — канонический список всех правил проекта с короткими summary и ссылками на детальные doc'и. Перед любой существенной задачей сверяйся с индексом, чтобы не пропустить правило.

Коротко: правила делятся на контентные (редкость, структура наборов, качество текстов), процессные (Git, параллельные агенты), данные (обязательные поля, транслитерация) и мета (навигация, FILL_IN_BLANK pipeline).

## Перед задачей — читай нужный файл

| Задача | Инструкции |
|--------|-----------|
| **Любая задача — начни с этого** | [`docs/claude/rules-index.md`](docs/claude/rules-index.md) — индекс всех правил |
| **Подготовка релиза в Play Store (отложено)** | [`docs/claude/release-plan.md`](docs/claude/release-plan.md) — текущий статус + TODO для release-подготовки |
| **Аналитика (работает, скелет для расширения)** | [`docs/claude/analytics-plan.md`](docs/claude/analytics-plan.md) — схема событий и архитектура |
| **Переработка he-ru наборов (активная задача)** | [`docs/claude/he-ru-restructure-plan.md`](docs/claude/he-ru-restructure-plan.md) — **читать первым** |
| **FILL_IN_BLANK exclusions (активная задача)** | [`docs/claude/fill-in-blank-pipeline.md`](docs/claude/fill-in-blank-pipeline.md) — защита квиза от неоднозначных дистракторов, pipeline LLM + safety net |
| **Рефакторинг существующих наборов** | [`docs/claude/rework-plan.md`](docs/claude/rework-plan.md) — там прогресс старых задач |
| Добавить / изменить набор слов | [`docs/claude/word-sets.md`](docs/claude/word-sets.md) |
| Качество `definition`/`definitionNative` | [`docs/claude/quality_standards_definitions.md`](docs/claude/quality_standards_definitions.md) |
| Качество `example`/`exampleNative` | [`docs/claude/quality_standards_examples.md`](docs/claude/quality_standards_examples.md) |
| Качество `pos`/`semanticGroup` | [`docs/claude/quality_standards_metadata.md`](docs/claude/quality_standards_metadata.md) |
| Пользовательские наборы (UGC, будущая фича) | [`docs/claude/ugc-plan.md`](docs/claude/ugc-plan.md) — план, ещё не реализовано |
| Добавить достижение | [`docs/claude/achievements.md`](docs/claude/achievements.md) |
| Архитектура, модели, фазы, зависимости | [`docs/claude/architecture.md`](docs/claude/architecture.md) |
| Изменить схему БД / добавить миграцию | [`docs/claude/database.md`](docs/claude/database.md) |
| Добавить новый язык (fr-ru, ar-ru и т.д.) | [`docs/claude/new-language.md`](docs/claude/new-language.md) |
| Пресетные колоды (DeckSeed) | [`docs/claude/preset-decks.md`](docs/claude/preset-decks.md) |
| Добавить новый экран / маршрут навигации | [`docs/claude/ui-screens.md`](docs/claude/ui-screens.md) |
| Quality gates (хук, валидаторы, METADATA_ONLY_COMMIT) | [`docs/claude/quality_gates.md`](docs/claude/quality_gates.md) |

## Инструменты валидации

Живут в `scripts/validate/`. Pre-commit хук запускает их автоматически для staged setId'ов. Можно дёрнуть вручную до коммита:

```bash
# Полный набор из 8 проверок для одного setId
bash scripts/validate/validate_all.sh 9

# Агрегированная проверка всей базы (ID-коллизии, дубли тем, разброс редкости и т.д.)
python scripts/validate/find_real_dupes.py

# Preset PvP колоды (DeckSeed) — orphans / wrong rarity / level-limit overflow
python scripts/validate/validate_preset_decks.py

# FILL_IN_BLANK pipeline для одного сета
python scripts/validate/fill_in_blank_prompt.py --set-id 9          # генерит промпт для LLM
python scripts/validate/generate_fill_in_blank_exclusions.py \
    --set-id 9 --llm-output out.json --apply                        # применяет exclusions + bump версии
python scripts/validate/generate_fill_in_blank_exclusions.py \
    --set-id 9 --llm-output out.json --flip-safety-flag             # Фаза 3: убирает isFillInBlankSafe=false
```

## Параллельные агенты

Можно запускать одновременно, если задачи не трогают одни и те же файлы:
- Наборы `en-ru` + наборы `he-ru` — разные файлы и ID-блоки, дублей быть не может
- Несколько независимых файлов документации

Нельзя параллельно — один из агентов потеряет изменения:
- Любые задачи, редактирующие `WordRegistry.kt` или `WordDataVersion.kt`
- Наборы внутри одного языка — агенты не видят слова друг друга → дубли
- Room-миграции — номера строго последовательны

## Git — пре-коммит чеклист

Перед каждым коммитом пройтись по списку:

1. **Build зелёный.** `JAVA_HOME="C:/Program Files/Android/Android Studio/jbr" ./gradlew assembleDebug` → `BUILD SUCCESSFUL`. Если не зелёный — чинить, не коммитить.
2. **WordDataVersion bumped**, если менялись `WordData*.kt`. Без этого `WordLoader` не перечитает базу на устройствах. Pre-commit хук блокирует `WordData*.kt` без bump (с 2026-04-21). Pipeline-скрипты (`generate_fill_in_blank_exclusions.py --apply/--flip-safety-flag`) bump'ают автоматически — руками не надо.
3. **`git add` по явным путям**, никогда `-A` / `.` (см. ниже).
4. **`git status` визуально проверен.** Ничего лишнего в Staged changes.
5. **Валидаторы прошли.** Если не уверен — `bash scripts/validate/validate_all.sh <setId>` до коммита.
6. **Коммит-сообщение на русском** + строка:
   ```
   Co-Authored-By: Claude Opus 4.7 (1M context) <noreply@anthropic.com>
   ```
7. **`git push origin main`** — публикуй сразу, не копи локальные коммиты.

### Запрет на `git add -A` / `git add .`

Никогда не использовать `git add -A` или `git add .` для коммитов изменений кода. Это может захватить untracked-файлы из параллельных сессий, отладочный мусор, worktree-папки, локальные скрипты.

Вместо этого — **явное указание путей**:
- `git add app/src/main/java/com/example/kartonki/data/WordData*.kt` — по паттерну
- `git add scripts/validate/` — конкретная директория
- `git add .claude/agents/new-agent.md` — конкретный файл

`.gitignore` дополнительно защищает от случайного захвата: `scripts/**/_*` (scratch-файлы), `.claude/worktrees/`, `.claude/scheduled_tasks.lock`, `*.tmp`. Defence in depth.

**Инцидент:** коммит `f353472` (revert `def4fee`) — попытка `git add -A` захватила 60+ untracked-файлов из параллельных сессий (Python-скрипты, отладочные txt) и подцепила `.claude/worktrees/agent-a054b794` как embedded git repository (submodule mode 160000). Пришлось делать revert, пересобирать коммит, проводить чистку.

## Источник правды — иерархия

1. **Репо-документы (`docs/claude/*.md`)** — единственный источник правды для правил и стандартов.
2. **`CLAUDE.md`** (этот файл) — фронт-дор с таблицей навигации.
3. **`docs/claude/rules-index.md`** — канонический индекс 17 правил.
4. **Валидаторы (`scripts/validate/`)** — машинное enforcement.
5. **Память Claude** (`~/.claude/.../memory/`) — контекст сессий и решений; **не** источник правды для правил.

Если в процессе работы находишь новый «подводный камень» — **добавь в соответствующий doc и в `rules-index.md`**, а не в CLAUDE.md или память. Здесь — только навигация и процесс.
