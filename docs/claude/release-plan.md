# План релиза в Google Play Store

**Статус на 2026-04-29:** Кодовая release-инфра готова, **keystore создан и проверен на телефоне, ID verification approved**. Осталась физическая часть в Play Console (создание приложения, листинг, загрузка AAB). Стратегия — Internal testing → Open testing (бета для первых пользователей) → Production.

Когда возвращаешься к задаче — **начни с чтения этого файла**. Он описывает где мы остановились и что дальше.

## Стратегия релиза: Internal → Open → Production

| Трек | Видимость | Тестеры | Когда использовать |
|---|---|---|---|
| Internal testing | Скрыто, только по opt-in URL | до 100 e-mail | Сразу — для себя + 3-4 знакомых тестеров |
| Open testing | Публично с пометкой Early access | без лимита | Для первых реальных пользователей (бета) |
| Production | Полный релиз | все | После 14-дневного Closed test для новых personal-аккаунтов |

**Важно про правило 14 дней:** новые personal Play Console аккаунты (после ноября 2023) обязаны провести Closed testing с 12+ тестерами в течение 14 дней перед получением доступа к Production. Internal и Open testing **не требуют** этого — туда можно сразу. Закрытый тест запускается параллельно с публичной бетой, чтобы 14-дневный таймер не блокировал когда созреешь до прода.

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

### Кодовая release-инфра (коммиты `be7ae36`, `c7e29f2`, `3a80484` — 2026-04-28)

- **applicationId сменён**: `com.example.kartonki` → `com.einerin.kartonki`. Это постоянный идентификатор в Play Store, после первой публикации не меняется. Kotlin namespace оставлен `com.example.kartonki` — это package, на него извне не смотрят, refactor имён не нужен.
- **Firebase Console**: зарегистрировано второе Android-приложение под `com.einerin.kartonki` (mobilesdk_app_id `1:75116979020:android:e18e4f82b679f85ea3a5e9`). Старая регистрация `com.example.kartonki` оставлена для экстренного отката — `app/google-services.json` содержит обе записи в `client[]`. `FirebaseModule.kt` обновлён под новый App ID.
- **Versioning**: `versionCode = 1`, `versionName = "0.1.0"` (semver, бета-семантика).
- **signingConfigs.release**: читает из `keystore.properties` (в `.gitignore`). Если файла нет — фолбэк на debug-подпись с громким Gradle warning'ом. Это позволяет локально проверять minified release-build до создания настоящего keystore'а.
- **ProGuard rules** (`app/proguard-rules.pro`): keep для Firebase Realtime Database POJO (`data.remote.model.**`), `-keepattributes SourceFile,LineNumberTable` для readable Crashlytics traces, `-dontwarn` JDK-only из Firestore. Hilt/Room/Compose покрыты consumer-rules самих библиотек.
- **R8 включён**: `isMinifyEnabled = true`, `isShrinkResources = true`. Тестовая `assembleRelease` зелёная, APK 7.8 MB.

### Открытый TODO в коде (Google Sign-In)

После смены applicationId Google Sign-In в **debug-сборке** перестанет работать пока в Firebase Console для нового приложения не добавлен SHA-1 fingerprint debug-keystore. Все остальные Firebase-сервисы (Realtime DB, Firestore, Auth по email/anon, Analytics) работают сразу. Шаги:

1. Получить SHA-1: `keytool -list -v -keystore "$env:USERPROFILE\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android | findstr SHA1`
2. https://console.firebase.google.com/project/kartonki-e18c5/settings/general → найти Kartonki Production (`com.einerin.kartonki`) → Add fingerprint → вставить SHA-1
3. Скачать обновлённый `google-services.json`, заменить `app/google-services.json`

---

## ✅ Сделано 2026-04-29

### Release keystore (создан, проверен)
- **Файл:** `C:\Users\Einerin\.android-keystores\kartonki-release.jks`
- **Параметры:** RSA 2048, SHA384withRSA, validity 10000 дней (~2053), alias `kartonki`
- **DN:** `CN=kartonki.developer, C=IL`
- **Release SHA-1:** `C3:6F:3C:D2:ED:59:45:BA:0A:4B:49:56:95:76:05:C8:B3:5C:8D:DC` — добавлен в Firebase Console
- **Release SHA-256:** `09:76:E6:6A:0C:B3:96:94:7B:B2:5A:C2:EB:E6:59:81:9F:96:47:AD:74:2F:4F:4C:E0:29:AB:3C:1D:B5:41:DF`
- **Debug SHA-1:** `C7:79:05:36:20:D1:98:07:90:78:0F:C0:92:3B:0B:64:43:5A:7B:F8` — добавлен в Firebase Console
- **Бэкапы:** Google Drive
- **Пароли:** в Bitwarden vault
- **`keystore.properties`** в корне репо (gitignored), Gradle подписывает автоматически

### `app/google-services.json` обновлён с новыми SHA-1

### AAB и APK собраны и проверены
- AAB: `app/build/outputs/bundle/release/app-release.aab` (12.8 MB)
- APK: `app/build/outputs/apk/release/app-release.apk` (8.3 MB) — установлен на телефон через `adb install -r`
- Smoke-test пройден: study-сессия, квизы (FILL_IN_BLANK/DEFINITION/MCT), PvP local, коллекция, паки, settings, TTS, achievements, **Google Sign-In работает в release**

### Play Console verification approved
- ID verification: **APPROVED** 2026-04-29 (Teudat Zehut + Sefah)
- Адрес: Hashlavim 10, кв. 4, Givatayim 5325615, Israel
- Блокировка снята — можно создавать приложения

## ⏳ Что осталось

### Build команды для повторных сборок

**AAB для загрузки в Play Console:**
```powershell
$env:JAVA_HOME = "C:\Program Files\Android\Android Studio\jbr"
./gradlew bundleRelease -x lintVitalAnalyzeRelease -x lintVitalReportRelease -x lintVitalRelease -x lint -x lintRelease -x lintAnalyzeRelease -x lintReportRelease
```

**APK для прямой установки на телефон:**
```powershell
$env:JAVA_HOME = "C:\Program Files\Android\Android Studio\jbr"
./gradlew assembleRelease -x lintVitalAnalyzeRelease -x lintVitalReportRelease -x lintVitalRelease -x lint -x lintRelease -x lintAnalyzeRelease -x lintReportRelease
& "C:\Users\Einerin\AppData\Local\Android\Sdk\platform-tools\adb.exe" install -r "C:\Users\Einerin\AndroidStudioProjects\Kartonki\app\build\outputs\apk\release\app-release.apk"
```

### Versioning
`versionCode = 1`, `versionName = "0.1.0"`. При каждом обновлении в Play — `versionCode += 1`. `versionName` по semver.

---

## ✅ Сделано 2026-04-29 (вечер) — листинг-артефакты

Все материалы для Play Console листинга в `docs/release-assets/`:

| Файл | Что внутри |
|---|---|
| `play_store_icon_512.png` | Иконка 512×512 PNG (RGB, без alpha) — готова к загрузке. Регенерируется `python scripts/release/make_play_icon.py` |
| `feature_graphic_1024x500.png` | Draft feature graphic. ОК для Internal/Open testing, для Production желательно заменить дизайнерским вариантом. Регенерируется `python scripts/release/make_feature_graphic.py` |
| `listing-ru.md` | App name (≤30), short description (≤80), full description (~1900 симв из 4000), release notes для Internal — на русском, варианты на выбор |
| `data-safety-form.md` | Шпаргалка для Data safety form в Console — по каждому типу данных (Personal info, App activity, Crash logs, Device IDs) с источниками в коде |
| `content-rating-iarc.md` | Шпаргалка для IARC questionnaire (категория Education, ожидаемый рейтинг 3+) |
| `screenshots-guide.md` | Инструкция как снимать 4-6 скриншотов: какие экраны, на эмуляторе или телефоне, команды adb. Сами скрины снимает пользователь, складывать в `docs/release-assets/screenshots/NN-name.png` |

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
| applicationId (Play Store) | `com.einerin.kartonki` | Постоянно, после публикации не меняется |
| Firebase App ID (com.einerin.kartonki) | `1:75116979020:android:e18e4f82b679f85ea3a5e9` | В `FirebaseModule.kt` |
| Firebase App ID (старый, com.example.kartonki) | `1:75116979020:android:77edb30deed49a3fa3a5e9` | В `google-services.json` `client[1]` для отката, не используется |
| Privacy policy URL (ru) | https://einnerin.github.io/kartonki/legal/privacy-policy | Для Play Console |
| Privacy policy URL (en) | https://einnerin.github.io/kartonki/legal/privacy-policy-en | Опционально |
| google-services.json | `app/google-services.json` | **В .gitignore**, не коммитить |
| Signing keystore | `C:\Users\Einerin\.android-keystores\kartonki-release.jks` | Создан 2026-04-29, бэкап в Google Drive, пароли в Bitwarden |
| Release SHA-1 | `C3:6F:3C:D2:ED:59:45:BA:0A:4B:49:56:95:76:05:C8:B3:5C:8D:DC` | Добавлен в Firebase для `com.einerin.kartonki` |
| Debug SHA-1 | `C7:79:05:36:20:D1:98:07:90:78:0F:C0:92:3B:0B:64:43:5A:7B:F8` | Добавлен в Firebase |
| keystore.properties | корень репо | **В .gitignore**, паттерн в build.gradle.kts |
| Release AAB | `app/build/outputs/bundle/release/` | После сборки |
| Бэкап старого google-services.json | пользователь сохранил локально 2026-04-28 | Для отката если новая регистрация Firebase сломается |
| Контакт для privacy | einerin40@gmail.com | Указан в политике |

---

## С чего начинать когда вернёшься

Скажи Claude: **«Возвращаемся к release-подготовке, читай `docs/claude/release-plan.md`»**

Текущий статус (2026-04-29): кодовая часть и keystore готовы, AAB собран, ID verification approved. Очерёдность дальше:

1. **Play Console → Create app**:
   - Название: обсуждалось `Картонки — учи слова с игрой` или `Kartonki`
   - Default language: ru-RU
   - Тип: Education App
   - Free
2. **Setup checklist в Console** — Privacy URL `https://einnerin.github.io/kartonki/legal/privacy-policy`, App access (без логин-стенки), Ads (нет), Content rating (IARC), Target audience (13+), Data safety form, government/news/COVID-19 → No.
3. **Main store listing** — иконка 512×512, feature graphic 1024×500, скриншоты, короткое (≤80) и полное (≤4000) описание. Listing-материалы можно готовить параллельно.
4. **Загрузка AAB в Internal testing** — `app/build/outputs/bundle/release/app-release.aab` уже собран. Создать релиз, указать release notes.
5. **После первой загрузки AAB — Production SHA-1**: Play Console → Release → Setup → App integrity → App signing key certificate → скопировать SHA-1 → добавить в Firebase Console для `com.einerin.kartonki` четвёртым отпечатком (без него Google Sign-In у production-пользователей не сработает).
6. **Параллельно Closed testing** с 12 тестерами на 14 дней (запускает таймер production access).
7. **Open testing** — публичная бета для первых пользователей (Early access tag).
8. **Production** — после 14 дней Closed test и заявки на production access.
9. **Поднять локальный Maven proxy** перед production-сборкой (или fix конфигурацию репозиториев) — чтобы lint прошёл без 7 `-x` флагов.

---

## ⚠️ Известные блокеры перед Production (не блокируют Internal)

### In-app account deletion
Google требует с 2024: если приложение позволяет создать аккаунт, оно должно предоставить **in-app кнопку «Удалить аккаунт»** + **web-ссылку для удаления без установки**. Сейчас удаление только через email `einerin40@gmail.com` (упомянуто в `docs/legal/privacy-policy.md`, SLA 30 дней).

Что нужно сделать:
- Добавить кнопку «Удалить аккаунт» в `SettingsScreen` для авторизованных пользователей. Действие: подтверждение → вызов Firebase Auth `delete()` + удаление документа в Firestore `/users/{uid}` + очистка PvP истории в RTDB
- Опционально: лендинг с формой запроса на удаление для не-установивших (можно простую страницу в `docs/legal/`)

Для Internal testing — не блокер (review нет, доступ только по opt-in URL). Для Open/Production — блокирующий.

### Feature graphic
Текущий — placeholder из `make_feature_graphic.py`. Для Production желательно заменить дизайнерским (Figma/Canva), для Open testing — допустим.

### Скриншоты
Не сняты. Без них Console не даст загрузить листинг (минимум 2 phone screenshots обязательны). См. `docs/release-assets/screenshots-guide.md`.

---

## План событий аналитики (для справки)

Полный список событий и решения по аналитике — в [`analytics-plan.md`](analytics-plan.md).

События в скелете (реализуются позже если понадобятся данные):
- `card_rarity_promoted` (концептуально не подходит к архитектуре — rarity фиксировано в WordEntity)
- `deck_edited`, `deck_selected_for_session`, `card_retained_as_favorite`
- `pvp_online_match_started/finished/disconnect`
- Остальные 7 user_properties (`total_decks`, `total_words_learned`, `favorite_mode` и т.п.)

Если после первого месяца в Play Store обнаружится что этих данных не хватает — вернёмся и доделаем.
