# Перенос Kartonki на iOS (Kotlin Multiplatform)

## Стратегия: Kotlin Multiplatform (KMP)

Переносим бизнес-логику в общий модуль, UI пишем отдельно для каждой платформы.

- Android UI: Compose (остаётся как есть)
- iOS UI: SwiftUI (пишется заново)
- Общий модуль: domain, data, ViewModel, логика игры

## Безопасность Android-версии

Миграция ведётся в ветке `feature/kmp`. Ветка `main` (Android) живёт независимо.

1. Создать ветку: `git checkout -b feature/kmp`
2. Периодически подтягивать новые наборы слов: `git merge main`
3. Android публикуется только из `main` — пользователи ничего не замечают
4. Мёрж в `main` только когда iOS-версия полностью готова и протестирована

## Что нужно переписать

| Компонент | Сейчас (Android) | Замена (KMP) |
|-----------|-----------------|--------------|
| БД | Room | SQLDelight |
| DI | Hilt | Koin или ручной DI |
| Preferences | DataStore / SharedPreferences | multiplatform-settings |
| ViewModel | Jetpack ViewModel | KMP-совместимый (kotlinx или decompose) |
| Async | Coroutines + Flow | остаётся как есть ✅ |

## Что остаётся без изменений

- Все domain-модели (`Word`, `Rarity`, `StudyStep`, …)
- Вся логика игры (`PvpGameLogic`, `QuizBuilder`, `StudyConstants`)
- Все наборы слов (`WordData*.kt`) — чистые данные
- Android UI — не трогается вообще

## Объём работы (оценка)

- Замена Room → SQLDelight: **самая трудоёмкая часть** — все DAO, все миграции
- Замена Hilt → Koin: трудоёмко, Hilt пронизывает весь проект
- iOS UI на SwiftUI: отдельная большая работа
- Итого: **несколько недель**, не дней

## Когда браться

Когда Android-версия стабильна и больше не требует частых изменений в архитектуре.
