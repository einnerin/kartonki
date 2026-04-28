# План релиза в Google Play Store

**Статус на 2026-04-28:** Кодовая release-инфра готова. Осталась физическая часть (keystore, Play Console аккаунт, листинг). Стратегия — Internal testing → Open testing (бета для первых пользователей) → Production.

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

### 2. Создать `keystore.properties`

После генерации keystore — рядом с `app/build.gradle.kts` (в корне репо) создать файл `keystore.properties` (он уже в `.gitignore`):

```properties
storeFile=C:/Users/Einerin/.android-keystores/kartonki-release.jks
storePassword=...
keyAlias=kartonki
keyPassword=...
```

После этого `assembleRelease` подпишется реальным ключом, без debug-fallback warning'а. Никаких изменений в `build.gradle.kts` не нужно — он уже умеет читать этот файл.

### 3. Версионирование (готово)

`versionCode = 1`, `versionName = "0.1.0"`. При каждом обновлении в Play — `versionCode += 1` (иначе Play отклонит апдейт). `versionName` менять по semver (`0.1.1` → `0.2.0` → `1.0.0` для production).

### 4. Собрать Release AAB

Play Store предпочитает `.aab` (Android App Bundle), не `.apk`. Gradle команда:
```
JAVA_HOME="C:/Program Files/Android/Android Studio/jbr" ./gradlew bundleRelease -x lintVitalAnalyzeRelease
```
(флаг `-x` пропускает lint, который сейчас падает из-за неподнятого локального Maven-прокси на 127.0.0.1:18080. Перед production-релизом нужно поднять прокси или fix конфигурацию репозиториев и пройти lint один раз.)

Результат: `app/build/outputs/bundle/release/app-release.aab`.

### 5. Протестировать release-билд на телефоне (можно ДО создания keystore'а — fallback на debug-подпись)

```powershell
& "C:\Users\Einerin\AppData\Local\Android\Sdk\platform-tools\adb.exe" install -r "C:\Users\Einerin\AndroidStudioProjects\Kartonki\app\build\outputs\apk\release\app-release.apk"
```

Прогнать все основные сценарии:
- Онбординг (если есть)
- Вход в study-сессию, квиз FILL_IN_BLANK / DEFINITION
- PvP local
- PvP online (требует Google Sign-In → нужен SHA-1 в Firebase Console для com.einerin.kartonki)
- Настройки
- Достижения
- Коллекция, открытие паков
- TTS на иврите/английском

Если что-то падает — проблема в ProGuard rules, лог в Logcat. Добавить targeted `-keep` в `app/proguard-rules.pro`.

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
| applicationId (Play Store) | `com.einerin.kartonki` | Постоянно, после публикации не меняется |
| Firebase App ID (com.einerin.kartonki) | `1:75116979020:android:e18e4f82b679f85ea3a5e9` | В `FirebaseModule.kt` |
| Firebase App ID (старый, com.example.kartonki) | `1:75116979020:android:77edb30deed49a3fa3a5e9` | В `google-services.json` `client[1]` для отката, не используется |
| Privacy policy URL (ru) | https://einnerin.github.io/kartonki/legal/privacy-policy | Для Play Console |
| Privacy policy URL (en) | https://einnerin.github.io/kartonki/legal/privacy-policy-en | Опционально |
| google-services.json | `app/google-services.json` | **В .gitignore**, не коммитить |
| Signing keystore | *ещё не создан* | Создать **вне репо**, бэкапнуть в облако |
| keystore.properties | корень репо | **В .gitignore**, паттерн в build.gradle.kts |
| Release AAB | `app/build/outputs/bundle/release/` | После сборки |
| Бэкап старого google-services.json | пользователь сохранил локально 2026-04-28 | Для отката если новая регистрация Firebase сломается |
| Контакт для privacy | einerin40@gmail.com | Указан в политике |

---

## С чего начинать когда вернёшься

Скажи Claude: **«Возвращаемся к release-подготовке, читай `docs/claude/release-plan.md`»**

Текущий статус (2026-04-28): кодовая часть готова. Очерёдность дальше:

1. **Тестовая установка release-APK на телефон** — `app/build/outputs/apk/release/app-release.apk` уже есть (debug-подписанный, 7.8 MB после R8). Убедиться что приложение работает после минификации — все основные сценарии.
2. **SHA-1 в Firebase Console для Google Sign-In** — иначе вход через Google в debug сломан после смены applicationId.
3. **Сгенерировать release keystore** — `keytool -genkey ...`, положить вне репо, **сделать минимум 2 бэкапа в облака**. Пароли — в менеджер паролей.
4. **Создать `keystore.properties`** — рядом с build.gradle.kts (gitignore'нут).
5. **Регистрация Play Console аккаунта** — $25, ID-верификация 1-3 дня.
6. **Параллельно листинг материалы**: иконка 512×512, feature graphic 1024×500, скриншоты, описание (короткое 80 символов + полное 4000).
7. **Поднять локальный Maven proxy** перед production-сборкой (или fix конфигурацию репозиториев) — чтобы lint прошёл без `-x lintVitalAnalyzeRelease`.
8. **Загрузка в Internal testing** — для себя + 3-4 тестеров (часы на ревью).
9. **Параллельно Closed testing** с 12 тестерами на 14 дней (запускает таймер production access).
10. **Open testing** — публичная бета для первых пользователей (Early access tag).
11. **Production** — после 14 дней Closed test и заявки на production access.

---

## План событий аналитики (для справки)

Полный список событий и решения по аналитике — в [`analytics-plan.md`](analytics-plan.md).

События в скелете (реализуются позже если понадобятся данные):
- `card_rarity_promoted` (концептуально не подходит к архитектуре — rarity фиксировано в WordEntity)
- `deck_edited`, `deck_selected_for_session`, `card_retained_as_favorite`
- `pvp_online_match_started/finished/disconnect`
- Остальные 7 user_properties (`total_decks`, `total_words_learned`, `favorite_mode` и т.п.)

Если после первого месяца в Play Store обнаружится что этих данных не хватает — вернёмся и доделаем.
