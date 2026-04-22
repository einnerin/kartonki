# Kartonki — Android App

Изучение иностранных слов с механикой ККИ. PvE (интервальное повторение) + PvP (pass-and-play на одном устройстве).
Ранги карточек: COMMON (серый) · UNCOMMON · RARE · EPIC · LEGENDARY. Колода ≤ 20 карт.

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

## Перед задачей — читай нужный файл

| Задача | Инструкции |
|--------|-----------|
| **Подготовка релиза в Play Store (отложено)** | [`docs/claude/release-plan.md`](docs/claude/release-plan.md) — текущий статус + TODO для release-подготовки |
| **Аналитика (работает, скелет для расширения)** | [`docs/claude/analytics-plan.md`](docs/claude/analytics-plan.md) — схема событий и архитектура |
| **Переработка he-ru наборов (активная задача)** | [`docs/claude/he-ru-restructure-plan.md`](docs/claude/he-ru-restructure-plan.md) — **читать первым** |
| **FILL_IN_BLANK exclusions (активная задача)** | [`docs/claude/fill-in-blank-pipeline.md`](docs/claude/fill-in-blank-pipeline.md) — защита квиза от неоднозначных дистракторов, pipeline LLM + safety net |
| **Рефакторинг существующих наборов** | [`docs/claude/rework-plan.md`](docs/claude/rework-plan.md) — там прогресс старых задач |
| Добавить / изменить набор слов | [`docs/claude/word-sets.md`](docs/claude/word-sets.md) |
| Добавить достижение | [`docs/claude/achievements.md`](docs/claude/achievements.md) |
| Архитектура, модели, фазы, зависимости | [`docs/claude/architecture.md`](docs/claude/architecture.md) |
| Изменить схему БД / добавить миграцию | [`docs/claude/database.md`](docs/claude/database.md) |
| Добавить новый язык (fr-ru, ar-ru и т.д.) | [`docs/claude/new-language.md`](docs/claude/new-language.md) |
| Пресетные колоды (DeckSeed) | [`docs/claude/preset-decks.md`](docs/claude/preset-decks.md) |
| Добавить новый экран / маршрут навигации | [`docs/claude/ui-screens.md`](docs/claude/ui-screens.md) |

## Параллельные агенты

Можно запускать одновременно, если задачи не трогают одни и те же файлы:
- Наборы `en-ru` + наборы `he-ru` — разные файлы и ID-блоки, дублей быть не может
- Несколько независимых файлов документации

Нельзя параллельно — один из агентов потеряет изменения:
- Любые задачи, редактирующие `WordRegistry.kt` или `WordDataVersion.kt`
- Наборы внутри одного языка — агенты не видят слова друг друга → дубли
- Room-миграции — номера строго последовательны

## Git — после каждой задачи

1. Собери: `JAVA_HOME="C:/Program Files/Android/Android Studio/jbr" ./gradlew assembleDebug` → должно быть `BUILD SUCCESSFUL`
2. Если менялись `WordData*.kt` (любое поле любого слова) — **подними `WordDataVersion.CURRENT` на 1** в одном коммите с изменениями данных. Без этого `WordLoader` не перечитает базу на устройствах пользователей — новые тексты/группировки останутся невидимыми. Pre-commit hook с 2026-04-21 блокирует коммит `WordData*.kt` без bump.
3. `git add` изменённые файлы **по явным путям** (см. правила ниже)
4. Коммит на русском языке + строка `Co-Authored-By: Claude Sonnet 4.6 <noreply@anthropic.com>`
5. `git push origin main`

### Запрет на `git add -A` / `git add .`

Никогда не использовать `git add -A` или `git add .` для коммитов изменений кода. Это может захватить untracked-файлы из параллельных сессий, отладочный мусор, worktree-папки, локальные скрипты.

Вместо этого — **явное указание путей**:
- `git add app/src/main/java/com/example/kartonki/data/WordData*.kt` — по паттерну
- `git add scripts/validate/` — конкретная директория
- `git add .claude/agents/new-agent.md` — конкретный файл

Перед коммитом **обязательно** смотреть `git status` и визуально подтверждать, что в Staged changes нет ничего лишнего.

**Инцидент:** коммит `f353472` (revert `def4fee`) — попытка `git add -A` захватила 60+ untracked-файлов из параллельных сессий (Python-скрипты, отладочные txt) и подцепила `.claude/worktrees/agent-a054b794` как embedded git repository (submodule mode 160000). Пришлось делать revert, пересобирать коммит, проводить чистку.

Если в процессе работы обнаруживаешь новый «подводный камень» — **добавляй его в соответствующий файл** из таблицы выше, а не сюда.
