# Kartonki — Android App

Приложение для изучения иностранных слов, сочетающее механику Memrise и коллекционных карточных игр (ККИ).

## Концепция

- **PvE режим**: классическое изучение слов (перевод, определение, аудирование и т.д.)
- **PvP режим** (pass-and-play на одном устройстве): игроки по очереди разыгрывают карточки-слова; противник получает задание по этому слову — угадал = очки (зависят от редкости), нет = 0
- **Ранги редкости**: Common / Rare / Epic / Legendary (как в ККИ)
- **Коллода**: ~20 карточек с лимитом по рангам (напр.: max 2 Legendary, 4 Epic, 6 Rare, остальные Common)

## Текущее состояние

Стартовый шаблон Android Studio. MainActivity показывает "Hello Android!". Нет логики, нет данных, нет навигации.

## Технический стек

| Слой | Технология |
|------|-----------|
| UI | Jetpack Compose + Material 3 |
| Навигация | Navigation Compose |
| Архитектура | MVVM + Clean Architecture |
| DI | Hilt |
| БД | Room (локальная) |
| Async | Kotlin Coroutines + Flow |
| Сборка | Gradle KTS, Kotlin 2.2.10, API 36, minSdk 24 |

## Структура проекта (целевая)

```
app/src/main/java/com/example/kartonki/
├── data/
│   ├── db/
│   │   ├── AppDatabase.kt          # Room база данных
│   │   ├── dao/
│   │   │   ├── WordDao.kt
│   │   │   ├── DeckDao.kt
│   │   │   └── ProgressDao.kt
│   │   └── entity/
│   │       ├── WordEntity.kt       # слово + перевод + ранг
│   │       ├── DeckEntity.kt       # колода игрока
│   │       └── ProgressEntity.kt  # прогресс изучения (PvE)
│   └── repository/
│       ├── WordRepository.kt
│       ├── DeckRepository.kt
│       └── ProgressRepository.kt
├── domain/
│   ├── model/
│   │   ├── Word.kt                 # доменная модель слова
│   │   ├── Card.kt                 # карточка (слово + ранг + визуал)
│   │   ├── Deck.kt                 # колода (список карт + лимиты)
│   │   ├── Rarity.kt               # enum: COMMON/RARE/EPIC/LEGENDARY
│   │   └── QuizType.kt             # enum: TRANSLATION/DEFINITION/FILL_IN
│   └── usecase/
│       ├── GetNextQuizUseCase.kt
│       ├── SubmitAnswerUseCase.kt
│       ├── BuildDeckUseCase.kt
│       └── StartPvpGameUseCase.kt
├── ui/
│   ├── navigation/
│   │   └── AppNavGraph.kt          # NavHost + sealed Routes
│   ├── screen/
│   │   ├── home/
│   │   │   ├── HomeScreen.kt
│   │   │   └── HomeViewModel.kt
│   │   ├── pve/
│   │   │   ├── StudyScreen.kt      # изучение (Memrise-стиль)
│   │   │   ├── StudyViewModel.kt
│   │   │   ├── QuizScreen.kt       # тест по слову
│   │   │   └── QuizViewModel.kt
│   │   ├── pvp/
│   │   │   ├── DeckSelectScreen.kt # выбор колод обоих игроков
│   │   │   ├── PvpGameScreen.kt    # игровое поле pass-and-play
│   │   │   ├── PvpGameViewModel.kt
│   │   │   └── PvpResultScreen.kt
│   │   ├── collection/
│   │   │   ├── CollectionScreen.kt # все карточки игрока
│   │   │   └── CollectionViewModel.kt
│   │   └── deckbuilder/
│   │       ├── DeckBuilderScreen.kt
│   │       └── DeckBuilderViewModel.kt
│   ├── component/
│   │   ├── CardView.kt             # карточка с анимацией редкости
│   │   ├── RarityBadge.kt          # бейдж редкости
│   │   ├── ProgressBar.kt
│   │   └── QuizInput.kt            # компонент ввода ответа
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
└── MainActivity.kt
```

## Доменные модели

### Rarity (ранг редкости)
```kotlin
enum class Rarity(
    val displayName: String,
    val points: Int,        // очки за правильный ответ в PvP
    val color: Long,        // цвет карточки
) {
    COMMON("Common", 1, 0xFFAAAAAA),
    RARE("Rare", 2, 0xFF4A90E2),
    EPIC("Epic", 3, 0xFF9B51E0),
    LEGENDARY("Legendary", 5, 0xFFF5A623),
}
```

### Word / Card
```kotlin
data class Word(
    val id: Long,
    val original: String,      // слово на изучаемом языке
    val translation: String,   // перевод
    val definition: String?,   // определение (опционально)
    val rarity: Rarity,
    val languagePair: String,  // напр. "en-ru"
)

data class Card(val word: Word, val isUnlocked: Boolean)
```

### Deck
```kotlin
data class Deck(
    val id: Long,
    val name: String,
    val cards: List<Card>,     // ~20 карточек
) {
    companion object {
        const val MAX_SIZE = 20
        val RARITY_LIMITS = mapOf(
            Rarity.LEGENDARY to 2,
            Rarity.EPIC to 4,
            Rarity.RARE to 6,
        )
    }
}
```

### PvP игра
```kotlin
data class PvpGame(
    val player1Name: String,
    val player2Name: String,
    val deck1: Deck,
    val deck2: Deck,
    val rounds: List<PvpRound>,
    val currentPlayerIndex: Int,
)

data class PvpRound(
    val card: Card,             // сыгранная карточка
    val attackerIndex: Int,     // кто разыгрывал
    val quizType: QuizType,
    val isCorrect: Boolean?,    // null = ещё не отвечено
    val pointsEarned: Int,
)
```

## PvP механика (pass-and-play)

1. Оба игрока выбирают свои колоды на одном устройстве
2. Игрок 1 выбирает карточку из своей руки (hand = 5 случайных карт из колоды)
3. Устройство передаётся Игроку 2 — он видит задание по этой карточке
4. Игрок 2 отвечает → система засчитывает очки
5. Ходы чередуются до конца колод или до N раундов
6. Побеждает набравший больше очков

**Типы заданий (QuizType)**:
- `TRANSLATION` — введи перевод слова
- `DEFINITION` — выбери правильное определение из 4 вариантов
- `FILL_IN_BLANK` — заполни пропуск в предложении

**Очки**: зависят от `Rarity.points` карточки, которую разыграл атакующий.

## PvE механика (изучение слов)

Основана на интервальном повторении (spaced repetition):
- Новое слово → показ карточки → тест → оценка (знаю/не знаю/сложно)
- `ProgressEntity` хранит: количество правильных ответов, дату следующего повторения, уровень освоения (0–5)
- При достижении уровня 3+ слово считается изученным и открывает карточку в коллекции с рангом

## Маршруты навигации

```
HOME
├── PVE/STUDY          → QuizScreen → (результат)
├── PVP/DECK_SELECT    → PvpGameScreen → PvpResultScreen
├── COLLECTION         → (просмотр карточек)
└── DECK_BUILDER/{id}  → (сборка колоды)
```

## Лимиты в колоде

```
Рарность    | Лимит | Очки за ответ
------------|-------|---------------
Common      | —     | 1
Rare        | 6     | 2
Epic        | 4     | 3
Legendary   | 2     | 5
Всего карт  | 20    |
```

## Зависимости для добавления в build.gradle.kts

```kotlin
// Navigation
implementation("androidx.navigation:navigation-compose:2.7.7")

// Room
implementation("androidx.room:room-runtime:2.6.1")
implementation("androidx.room:room-ktx:2.6.1")
ksp("androidx.room:room-compiler:2.6.1")

// Hilt
implementation("com.google.dagger:hilt-android:2.51.1")
ksp("com.google.dagger:hilt-android-compiler:2.51.1")
implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

// ViewModel
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

// DataStore (настройки)
implementation("androidx.datastore:datastore-preferences:1.0.0")
```

Плагины в root build.gradle.kts:
```kotlin
id("com.google.dagger.hilt.android") version "2.51.1" apply false
id("com.google.devtools.ksp") version "2.2.10-1.0.29" apply false
```

## План разработки (фазы)

### Фаза 1 — Фундамент
- [ ] Добавить зависимости (Navigation, Room, Hilt, KSP)
- [ ] Настроить Hilt (Application класс, модули)
- [ ] Создать Room базу данных (entities + DAOs)
- [ ] Создать доменные модели (Rarity, Word, Card, Deck)
- [ ] Настроить Navigation Compose с базовыми экранами
- [ ] Создать HomeScreen с кнопками PvE / PvP / Коллекция

### Фаза 2 — PvE режим
- [ ] WordRepository + ProgressRepository
- [ ] Заполнить тестовыми данными (seed data при первом запуске)
- [ ] StudyScreen — показ новых слов с карточкой
- [ ] QuizScreen — тип TRANSLATION (ввод текста)
- [ ] QuizScreen — тип DEFINITION (выбор из 4)
- [ ] Алгоритм spaced repetition (упрощённый SM-2)
- [ ] Экран прогресса изучения

### Фаза 3 — Коллекция и колоды
- [ ] CollectionScreen — список всех карточек с фильтром по рангу
- [ ] CardView composable с визуальным оформлением по Rarity
- [ ] DeckBuilderScreen — сборка колоды с проверкой лимитов
- [ ] DeckRepository

### Фаза 4 — PvP режим
- [ ] DeckSelectScreen — оба игрока выбирают колоды
- [ ] PvpGameScreen — игровое поле, рука карт, передача устройства
- [ ] PvpGameViewModel — логика ходов, подсчёт очков
- [ ] PvpResultScreen — итоговый счёт и победитель
- [ ] Анимации (открытие карточки, правильный/неправильный ответ)

### Фаза 5 — Полировка
- [ ] Анимации редкости карточек (свечение, блёстки для Legendary)
- [ ] Звуки (опционально)
- [ ] Настройки (язык пары, имена игроков по умолчанию)
- [ ] Onboarding для новых пользователей

## Конвенции кода

- **Именование**: PascalCase для классов/composables, camelCase для функций/переменных
- **Composables**: один файл = один экран + его подкомпоненты
- **ViewModel**: один на экран, общается с репозиторием через use cases
- **State**: `UiState` sealed class или data class в каждом ViewModel
- **Side effects**: через `LaunchedEffect` / `SideEffect` в Compose
- **Strings**: все строки в `strings.xml`, поддержка i18n с первого дня
- **Нет nullable там где не нужно**: предпочитать sealed class/enum вместо nullable флагов

## Чеклисты перед изменением системы

Перед работой с определёнными системами **обязательно** прочитай указанные файлы и выполни проверки.
Если в процессе работы обнаруживаешь новый «подводный камень» — добавляй его в соответствующий чеклист самостоятельно.

---

### Достижения (Achievements)

**Файлы для чтения:**
- `domain/model/Achievement.kt` — enum `AchievementId` со всеми достижениями
- `data/AchievementCards.kt` — слова, зарезервированные исключительно для достижений
- `data/repository/AchievementRepository.kt` — логика unlock/check

**Перед добавлением нового достижения:**
1. Добавь запись в `AchievementId` (название, описание, иконка, `rewardWordOriginal`).
2. Убедись, что слово `rewardWordOriginal` **существует в базе данных** — найди его в `WordDataEnglish.kt` / `WordDataEnglishExpanded.kt` / соответствующем файле данных. Если слова нет — создай его через `achievementRewardWords()` (или аналог) с `setId = 0` и `semanticGroup = "achievement_reward"`.
3. Добавь `rewardWordOriginal` в `AchievementCards.STARTER_ACHIEVEMENT_REWARDS` (или `EXCLUSIVE_LEGENDARY` для легендарных наград) — иначе слово попадёт в обычные наборы/стартер и потеряет эксклюзивность.
4. Если достижение проверяется в `recordStudyDay` / `recordPvpMatch` / другом публичном методе — добавь вызов check-функции туда; если это отдельное событие (как FIRST_LAUNCH) — создай отдельный `suspend fun checkXxx()` и вызови его из нужного ViewModel.
5. После изменения схемы БД (если добавляешь новую таблицу/поле) — увеличь версию Room и добавь миграцию.

**Частые ошибки:**
- Слово награды не существует в БД → `getWordByOriginal()` вернёт null → `rewardWordId = null` в `AchievementEntity`.
- Слово не добавлено в `AchievementCards.ALL_EXCLUSIVE` → слово появляется в обычных наборах.
- Достижение добавлено в enum, но check-функция нигде не вызывается.

---

### Наборы слов (Word Sets / Seed Data)

**Файлы для чтения:**
- `data/WordRegistry.kt` — реестр всех наборов/слов/колод
- `data/AchievementCards.kt` — исключения из наборов (слова-награды)
- Соответствующий `WordDataXxx.kt`

**Как работает загрузка данных в БД:**
- `WordLoader.doLoad()` срабатывает при `storedVersion < WordDataVersion.CURRENT`.
- Наборы: сначала `insertSets` (IGNORE — вставляет только новые), затем `updateSetMetadata` для каждого набора (UPDATE только seed-полей: `name`, `description`, `orderIndex`). Поле `isFavorite` — пользовательское, никогда не перезаписывается из seed-данных.
- Слова: `insertAllOrReplace` — полный REPLACE по PK (`id`). На словах есть UNIQUE-индекс по `(original, languagePair)`: если два слова имеют одинаковый `original`, второй INSERT удалит первое слово из БД, и его набор потеряет слово.

**Перед добавлением/изменением наборов:**
1. **`name` и `description` в `WordSetEntity` всегда на языке интерфейса (сейчас — русский).** Не на изучаемом языке, не на английском. Пример: `name = "Пляж"`, `description = "Активности на море A2/B1"`. Если в будущем появится новый родной язык — использовать его.
2. **Обязательно проверь каждое новое слово на дубли** перед тем как вписать его в файл.
   Для одного слова (английский):
   ```bash
   grep -rl "original = \"WORD\"" app/src/main/java/com/example/kartonki/data/
   ```
   Для одного слова (иврит, с огласовками — требует точного байтового совпадения):
   ```bash
   grep -rFl "original = \"СЛОВО\"" app/src/main/java/com/example/kartonki/data/
   ```
   Для пакетной проверки нескольких кандидатов сразу:
   ```bash
   cd app/src/main/java/com/example/kartonki/data
   for word in слово1 слово2 слово3; do
     result=$(grep -rFl "original = \"$word\"" . 2>/dev/null)
     if [ -n "$result" ]; then echo "ДУБЛЬ: '$word' — $result"; else echo "СВОБОДНО: '$word'"; fi
   done
   ```
   **Если слово найдено — оно дубль. Придумай замену и проверь замену тем же способом.**
   Замена тоже может оказаться дублем — проверять обязательно, не полагаться на интуицию.
3. Не добавляй слова из `AchievementCards.ALL_EXCLUSIVE` в обычные наборы.
4. Соблюдай шкалу редкости: COMMON=A1, UNCOMMON=A2-B1, RARE=B2, EPIC=C1, LEGENDARY=C2+.
6. ID слова = `setId × 100 + position`; убедись, что setId не пересекается с существующими блоками из `languageIdBlocks`.
   **Исключение:** слова-награды достижений имеют `setId = 0` (сентинел) и вручную заданные ID (24990–24994). Они намеренно не попадают под формулу — `SeedDataAuditTest` освобождает их по `semanticGroup == "achievement_reward"`.
7. После добавления нового набора — зарегистрируй его в `WordRegistry.allSets` и `WordRegistry.allWords`.
8. Всегда поднимай `WordDataVersion.CURRENT` при любом изменении слов. `CollectionRepository` автоматически триггерит пересборку пресетных колод при изменении `WordDataVersion`, так что отдельно поднимать `PresetDecksVersion` **не нужно** — если только не меняется состав самих DeckSeed-колод (добавление/удаление слов из колоды, новая колода).
9. **Каждый набор должен содержать ровно 25 слов.** После написания каждого набора — обязательно подсчитай слова командой:
   ```bash
   grep -c "setId = XXXX," WordDataXxx.kt
   ```
   Результат должен быть ровно `25`. Проверяй каждый набор отдельно, не только итог файла.

**Частые ошибки:**
- Слово с тем же `original` уже есть в другом файле данных → `OnConflictStrategy.REPLACE` удалит старую строку и создаст новую с другим `id` → ссылки в `deck_cards` станут невалидными.
  **Корень проблемы:** при написании больших batch-файлов ранние наборы (1–249) выходят за окно контекста и не видны — поэтому grep обязателен для каждого слова, полагаться на память нельзя.
- Замена дубля выбрана «по смыслу» без grep-проверки → замена сама оказывается дублем. Такое случалось неоднократно (cashback, garnish, liability, circulate и др.). Всегда проверяй кандидата перед использованием.
- Для иврита `grep -w` (границы слова) работает ненадёжно с огласовками (шин שִׁ и син שִׂ — разные байты). Всегда использовать `grep -F` (точное байтовое совпадение).
- `name`/`description` набора написаны на изучаемом языке (иврит) вместо родного (русский) — ошибка незаметна в коде, но сразу видна в UI. Проверяй при написании каждого `WordSetEntity`.
- Слово из нового батча совпадает по `original` со словом в старом файле — UNIQUE-индекс `(original, languagePair)` + `insertAllOrReplace` удаляет старую строку, старый набор теряет слово и становится 24-словным. Grep обязателен не только внутри языковой пары, но и по всем файлам.
- Написал меньше 25 слов — ошибка повторялась многократно (наборы 1022–1037). Всегда считай слова после написания каждого набора.
- Контекстное окно кончилось в середине набора → набор получает 2–4 слова и остаётся незамеченным годами (setId=87: 4 слова из 25). Признак: набор разбит между двумя файлами (напр. 8701–8702 в English.kt, 8703–8704 в EnglishExpanded.kt) — значит генерация оборвалась.
- При исправлении «коротких» наборов в одной группе (напр. 1022–1037) — **обязательно** одновременно проверять соседние группы (1019–1021 оказались такими же короткими, но были пропущены).
- После любого batch-исправления запускать полный аудит всех наборов командой:
  ```bash
  DIR="app/src/main/java/com/example/kartonki/data" && for file in "$DIR"/WordData*.kt; do fname=$(basename "$file"); setids=$(grep -oE "setId = [0-9]+" "$file" | grep -oE "[0-9]+" | sort -u); for sid in $setids; do count=$(grep -c "setId = $sid," "$file" 2>/dev/null || true); if [ "$count" != "25" ]; then echo "ПРОБЛЕМА: $fname — setId=$sid — $count слов"; fi; done; done
  ```
  Ложные тревоги: setId=0 (5 слов — сентинел наград) и setId=XXXX в Extra-файле (20+5=25 суммарно).

---

## Правила работы с Git

После завершения каждой задачи автоматически:
1. Собери проект (`./gradlew assembleDebug`) и убедись, что BUILD SUCCESSFUL
2. Добавь все изменённые файлы в индекс (`git add`)
3. Сделай коммит с подробным описанием на русском языке
4. Запушь в origin main (`git push origin main`)

**Переменная окружения для сборки:** `JAVA_HOME="C:/Program Files/Android/Android Studio/jbr"`

Коммит всегда включает строку:
```
Co-Authored-By: Claude Sonnet 4.6 <noreply@anthropic.com>
```
