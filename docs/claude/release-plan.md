# План релиза в Google Play Store

**Статус на 2026-04-22:** Аналитика встроена, privacy policy развёрнут. Release-подготовка отложена.

Когда возвращаешься к задаче — **начни с чтения этого файла**. Он описывает где мы остановились и что дальше.

---

## ✅ Что уже сделано

### Аналитика (коммиты `021c45b`, `17c9b96`, `dda1861`)

- **Инфраструктура:** `AnalyticsManager` + Firebase Analytics SDK подключён, Hilt модуль
- **События (18+ заполненных из 28 в sealed class):**
  - Engagement: `session_started/finished/abandoned`, `tab_selected`, `streak_extended/broken`
  - Learning: `word_seen`, `quiz_answered`, `set_opened`, `set_completed`, `problem_word_reviewed`, `problem_words_session_completed`, `achievement_unlocked`
  - Decks: `deck_built`, `deck_deleted`
  - PvP Local: `pvp_local_match_started/finished`
  - PvP Online: `pvp_online_matchmaking_started/result`
  - Collection: `pack_opened`
  - Auth: `login_method`
  - Technical: `app_crash` (через UncaughtExceptionHandler)
- **User properties:** `preferred_language_pair`, `install_cohort_week`
- **Tester mode:** 7 тапов по версии в Settings включают/выключают (user_id="tester" в Firebase)
- **Debug user filter:** BuildConfig.DEBUG → user_id="dev_einnerin"
- **Google Analytics включён** в Firebase Console, DebugView работает, события идут

### Privacy policy

- **Хостинг:** GitHub Pages из папки `/docs` репозитория `einnerin/kartonki`
- **URLs для Play Console:**
  - RU: https://einnerin.github.io/kartonki/legal/privacy-policy
  - EN: https://einnerin.github.io/kartonki/legal/privacy-policy-en
- **Исходники:** `docs/legal/privacy-policy.md` (ru) + `docs/legal/privacy-policy-en.md` (en)

### Инфраструктура кода

- `firebase-analytics-ktx` 22.1.2 в `gradle/libs.versions.toml`
- `buildConfig = true` в `app/build.gradle.kts`
- `KartonkiApplication.onCreate`: init analytics + crash handler + user_id
- `localMaven/` в `.gitignore`

---

## ⏳ Что осталось — release-подготовка

### 1. Signing keystore (критически важно, **НЕЛЬЗЯ потерять потом**)

Keystore = файл с твоей подписью. Без него Play Store не пустит апдейты (проверяет что новый APK подписан тем же ключом что и первый).

**Действия:**
1. Сгенерировать через Android Studio: `Build → Generate Signed Bundle / APK → Create new keystore`
2. Или через командную строку:
   ```powershell
   "C:\Program Files\Android\Android Studio\jbr\bin\keytool.exe" -genkey -v -keystore kartonki-release.jks -keyalg RSA -keysize 2048 -validity 10000 -alias kartonki
   ```
3. **Запомни/сохрани в менеджере паролей:**
   - Store password (общий пароль keystore)
   - Key password (пароль конкретного ключа, можно такой же)
   - Key alias (`kartonki` в примере)
4. **Положи keystore вне репо** — например в `C:\Users\Einerin\.android-keystores\kartonki-release.jks`
5. **Сделай бэкап** этого файла (Google Drive / Dropbox / внешний диск). Потеря = невозможность апдейтов навсегда

### 2. Release build config

В `app/build.gradle.kts` добавить:
```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("путь/к/kartonki-release.jks")
            storePassword = "..."
            keyAlias = "kartonki"
            keyPassword = "..."
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
}
```

Пароли **НЕ в репо** — либо через `local.properties` + `gradle.properties` с `.gitignore`, либо через переменные окружения. Подскажу варианты.

### 3. ProGuard правила

Release-билд пропускает код через обфускатор. Без правильных правил **сломается Hilt, Firebase, Room, Compose navigation**.

Нужно в `app/proguard-rules.pro` добавить keep-правила для:
- Hilt (генерируемые классы)
- Firebase (Kotlin Serialization model классы)
- Room (entity-классы)
- Compose Navigation (SavedStateHandle работа с reflection)
- Kotlinx serialization если используется
- Kotlin reflection

Конкретные правила напишу когда дойдём — зависит от версий библиотек.

### 4. Версионирование

В `app/build.gradle.kts`:
```kotlin
defaultConfig {
    versionCode = 1      // при каждом релизе в Play Store +1
    versionName = "1.0.0" // semantic: major.minor.patch
}
```

Сейчас `versionCode = 1, versionName = "1.0"` — это для первого релиза нормально. Но когда будешь выпускать апдейт — **обязательно увеличить versionCode**, иначе Play Store не примет.

### 5. Собрать Release AAB

Play Store предпочитает `.aab` (Android App Bundle), не `.apk`. Gradle команда:
```
./gradlew bundleRelease
```
Результат будет в `app/build/outputs/bundle/release/app-release.aab`.

### 6. Протестировать release-билд на телефоне

Release-билд с ProGuard может сломаться там, где debug работает. Обязательный шаг:
```powershell
"C:\Users\Einerin\AppData\Local\Android\Sdk\platform-tools\adb.exe" install -r "C:\Users\Einerin\AndroidStudioProjects\Kartonki\app\build\outputs\apk\release\app-release.apk"
```
(для APK версии — их тоже собирает `./gradlew assembleRelease`)

Запусти, пройди все основные сценарии:
- Онбординг (если есть)
- Вход в study-сессию, квиз
- PvP local (если хватит устройств)
- Настройки
- Достижения
- Коллекция, открытие паков

Если что-то падает — проблема в ProGuard, будет лог в Logcat.

---

## ⏳ Твоя часть — визуал и листинг

**Можешь начать в любой момент параллельно с release-подготовкой:**

### Иконка приложения
- **512×512 PNG** — для листинга в Play Store
- Также нужна в приложении (вероятно уже есть в `app/src/main/res/mipmap-*`)

### Feature graphic
- **1024×500 PNG** — баннер, показывается на карточке приложения в Play Store
- Можно сделать в Figma / Canva / Paint.NET — простой фон + название + подзаголовок

### Скриншоты
- Минимум 2, рекомендую 4-8
- Разрешение любое, но одинаковое для всех
- Снимки через эмулятор: **Extended Controls** (три точки справа) → **Camera** → **Take screenshot**
- Или с телефона: `adb exec-out screencap -p > screenshot.png`

### Описание
- **Короткое** — до 80 символов. Пример: «Учи иностранные слова через квизы и PvP-карточки»
- **Полное** — до 4000 символов. Разделы:
  - Что приложение делает
  - Ключевые фичи (PvE интервальное повторение, PvP локальный и онлайн, коллекция карт, достижения)
  - Поддерживаемые языки (en-ru, he-ru)
  - Преимущества перед конкурентами (если хочешь)

---

## ⏳ Google Play Console

1. Регистрация: https://play.google.com/console
2. Одноразовый платёж **$25** (нужна банковская карта с валютой в $ / €)
3. Подтверждение личности (загрузка паспорта / ID)
4. Создание Developer account — занимает 1-2 дня на верификацию
5. Создание приложения внутри:
   - Название, описание, иконка, скриншоты, feature graphic
   - Категория: Education
   - Target audience (возрастная группа)
   - **Privacy policy URL:** https://einnerin.github.io/kartonki/legal/privacy-policy
   - Content rating (опросник от IARC, определяет рейтинг 3+/7+/12+)
   - Pricing (бесплатно)
   - Countries distribution
6. Загрузка `.aab` файла в Production track (или Internal Testing для начала)
7. Отправка на review — Google проверяет 1-3 дня

**Первая публикация** часто в Internal Testing — там можно пригласить до 100 человек по email. Затем Production.

---

## Важные артефакты (запиши куда-нибудь)

| Что | Где | Примечание |
|-----|-----|-----------|
| Firebase project | `kartonki-e18c5` | Console: https://console.firebase.google.com/project/kartonki-e18c5 |
| Privacy policy URL (ru) | https://einnerin.github.io/kartonki/legal/privacy-policy | Для Play Console |
| Privacy policy URL (en) | https://einnerin.github.io/kartonki/legal/privacy-policy-en | Опционально |
| google-services.json | `app/google-services.json` | **В .gitignore**, не коммитить |
| Signing keystore | *ещё не создан* | Создать **вне репо**, бэкапнуть в облако |
| Release AAB | `app/build/outputs/bundle/release/` | После сборки |
| Контакт для privacy | einerin40@gmail.com | Указан в политике |

---

## С чего начинать когда вернёшься

Скажи Claude: **«Возвращаемся к release-подготовке, читай `docs/claude/release-plan.md`»**

Первым делом — создаём signing keystore. Дальше всё по списку выше.

---

## План событий аналитики (для справки)

Полный список событий и решения по аналитике — в [`analytics-plan.md`](analytics-plan.md).

События в скелете (реализуются позже если понадобятся данные):
- `card_rarity_promoted` (концептуально не подходит к архитектуре — rarity фиксировано в WordEntity)
- `deck_edited`, `deck_selected_for_session`, `card_retained_as_favorite`
- `pvp_online_match_started/finished/disconnect`
- Остальные 7 user_properties (`total_decks`, `total_words_learned`, `favorite_mode` и т.п.)

Если после первого месяца в Play Store обнаружится что этих данных не хватает — вернёмся и доделаем.
