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
2. `git add` изменённые файлы
3. Коммит на русском языке + строка `Co-Authored-By: Claude Sonnet 4.6 <noreply@anthropic.com>`
4. `git push origin main`

Если в процессе работы обнаруживаешь новый «подводный камень» — **добавляй его в соответствующий файл** из таблицы выше, а не сюда.
