# Правила: Достижения (Achievements)

## Файлы для чтения перед работой
- `domain/model/Achievement.kt` — enum `AchievementId` со всеми достижениями
- `data/AchievementCards.kt` — слова-награды, зарезервированные исключительно для достижений
- `data/repository/AchievementRepository.kt` — логика unlock/check

## Чеклист перед добавлением достижения

1. Добавь запись в `AchievementId` (название, описание, иконка, `rewardWordOriginal`).
2. Убедись, что слово `rewardWordOriginal` **существует в БД** — найди в `WordDataEnglish.kt` / `WordDataEnglishExpanded.kt` / соответствующем файле. Если нет — создай через `achievementRewardWords()` с `setId = 0` и `semanticGroup = "achievement_reward"`.
3. Добавь `rewardWordOriginal` в `AchievementCards.STARTER_ACHIEVEMENT_REWARDS` (или `EXCLUSIVE_LEGENDARY` для легендарных наград) — иначе слово попадёт в обычные наборы.
4. Добавь вызов check-функции в нужное место:
   - Регулярные события (`recordStudyDay`, `recordPvpMatch`) → добавь вызов туда.
   - Разовые события (FIRST_LAUNCH и т.п.) → создай `suspend fun checkXxx()` и вызови из ViewModel.
5. При изменении схемы БД — увеличь версию Room, добавь миграцию.

## Частые ошибки
- Слово награды не существует в БД → `getWordByOriginal()` вернёт null → `rewardWordId = null`.
- Слово не добавлено в `AchievementCards.ALL_EXCLUSIVE` → появляется в обычных наборах.
- Достижение добавлено в enum, но check-функция нигде не вызывается.
