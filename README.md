# Kartonki

Android-приложение для изучения иностранных слов с механикой ККИ.

- **PvE** — интервальное повторение (карточки с SRS-прогрессией)
- **PvP** — pass-and-play на одном устройстве, матчи на колодах до 20 карт
- **Ранги** — COMMON (серый) · UNCOMMON · RARE · EPIC · LEGENDARY, привязка к CEFR A1–C2+

Технически: Kotlin 2.2.10, Jetpack Compose + Material 3, Room, Hilt, MVVM + Clean Architecture, API 36 / minSdk 24.

## Setup for contributors

После `git clone` **обязательно** однократно запустить:

```bash
bash scripts/install-hooks.sh
```

Это активирует pre-commit hook (уровень 5 из 7 системы гарантий качества). Без хука коммиты в WordData могут проскочить непроверенными. Подробности системы — в [`docs/claude/quality_gates.md`](docs/claude/quality_gates.md).

### Сборка

```bash
JAVA_HOME="C:/Program Files/Android/Android Studio/jbr" ./gradlew assembleDebug
```

Результат в `app/build/outputs/apk/debug/`.

### Проверка данных перед коммитом

```bash
# Один setId
bash scripts/validate/validate_all.sh <setId>

# Вся база
bash scripts/validate/audit_all_files.sh
```

## Документация

| Задача | Файл |
|--------|------|
| Общий контекст, правила работы с git | [`CLAUDE.md`](CLAUDE.md) |
| Система гарантий качества | [`docs/claude/quality_gates.md`](docs/claude/quality_gates.md) |
| Активный план полировки + техдолг | [`docs/claude/polishing_plan.md`](docs/claude/polishing_plan.md) |
| Стандарты качества текстов | [`docs/claude/quality_standards_*.md`](docs/claude/) |
| Добавление/изменение набора слов | [`docs/claude/word-sets.md`](docs/claude/word-sets.md) |
| Архитектура, фазы, зависимости | [`docs/claude/architecture.md`](docs/claude/architecture.md) |

## Структура репозитория

```
app/                                    Android app (Kotlin)
├─ src/main/java/com/example/kartonki/
│  ├─ data/                              Room, WordData*.kt — seed data
│  ├─ domain/                            Word, QuizBuilder
│  └─ ui/                                Compose screens + ViewModels
scripts/                                Tooling
├─ validate/                            7 валидаторов + парсер + фикстуры
│  ├─ _parser.py                        Общий парсер Kotlin-DSL
│  ├─ validate_*.sh / validate_*.py     Обёртки + логика (архитектура Y)
│  ├─ validate_all.sh                   Агрегатор
│  ├─ audit_all_files.sh                Полный аудит базы
│  ├─ find_real_dupes.py                Глобальные проверки (дубли, word-count)
│  └─ tests/                            Фикстуры + run_tests.sh
└─ install-hooks.sh                     Установщик git hooks (обязательно!)
.githooks/pre-commit                    Pre-commit quality gate
.github/workflows/                      CI
├─ validate-words-pr.yml                Blocking на PR (только изменённые setIds)
└─ validate-words-health.yml            Info-only еженедельный аудит
docs/claude/                            Инструкции для Claude + стандарты
.claude/agents/                         Sub-agents (definition-polisher и т.п.)
.claude/skills/                         Skills (/add-words)
```

## Лицензия

Собственная разработка, не open-source.
