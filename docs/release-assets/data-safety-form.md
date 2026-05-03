# Data safety form — шпаргалка для Play Console

Заполняется в Console: **App content → Data safety → Manage**.

Основано на коде (что реально собирается) + текущей `docs/legal/privacy-policy.md`. Если в Console обнаружится поле, не упомянутое здесь, проверь — мы могли что-то упустить.

---

## Раздел 1 — Data collection and security

| Вопрос | Ответ |
|---|---|
| Does your app collect or share any of the required user data types? | **Yes** |
| Is all of the user data collected by your app encrypted in transit? | **Yes** (Firebase: TLS) |
| Do you provide a way for users to request that their data be deleted? | **Yes** |

**Account deletion paths (готовы 2026-05-03):**
- **In-app:** Settings → Аккаунт → «Удалить аккаунт» (видно для signed-in non-anonymous; реализовано в `AccountDeletionRepository`). Удаляет: Auth user, Firestore `/users/{uid}`, RTDB matchmaking_lobby slots с этим uid. При `RECENT_LOGIN_REQUIRED` — auto-reauth + retry.
- **Web URL** (для поля Console «Account deletion URL»): `https://einnerin.github.io/kartonki/legal/account-deletion` — инструкция в приложении + email fallback на 30-дневное удаление

---

## Раздел 2 — Data types collected

Для каждой строки в форме: **Collected**, **Shared** (с третьими сторонами), **Optional/Required**, **Purposes**, **User-facing data?** (true если эти данные показываются другим пользователям, как имя в PvP лобби).

`Shared` в Play Console = передача **third parties**. Firebase = service provider Google, **не** third party — поэтому везде ниже **No**.

### Personal info

| Тип | Collected | Shared | Optional? | Purposes | User-facing? | Источник |
|---|---|---|---|---|---|---|
| **Name** | Yes | No | Optional | App functionality | **Yes** (никнейм в PvP) | Google Sign-In `displayName` (если пользователь логинится) |
| **Email address** | Yes | No | Optional | Account management | No | Google Sign-In (только если пользователь логинится) |
| **User IDs** | Yes | No | Required | App functionality, Analytics | No | Firebase uid (есть у анонимных тоже) |
| Address | — | — | — | — | — | не собираем |
| Phone number | — | — | — | — | — | не собираем |
| Race/ethnicity | — | — | — | — | — | не собираем |
| Political/religious beliefs | — | — | — | — | — | не собираем |
| Sexual orientation | — | — | — | — | — | не собираем |
| Other info | — | — | — | — | — | не собираем |

### Financial info
**Ничего не собираем.** Free app, no IAP, no ads, no subscriptions.

### Health and fitness
**Ничего не собираем.**

### Messages, Photos and videos, Audio files, Files and docs, Calendar, Contacts
**Ничего не собираем.**

> Уточнение про `photoUrl` из Google Sign-In: мы храним **ссылку** на аватарку Google CDN, а не сам файл изображения. Per Play Console guidelines это не считается "Photos collection". Не отмечать.

### Location
**Ничего не собираем.** (Firebase Analytics показывает country-level в DebugView — это derived из IP на серверной стороне Google, не collected from device.)

### Web browsing
**Ничего не собираем.**

### App activity

| Тип | Collected | Shared | Optional? | Purposes | User-facing? | Источник |
|---|---|---|---|---|---|---|
| **App interactions** | Yes | No | Required | Analytics | No | Firebase Analytics events: `quiz_answered`, `set_opened`, `deck_built`, `pvp_local_match_started`, и т.д. |
| In-app search history | — | — | — | — | — | UGC search не реализован |
| Other user-generated content | — | — | — | — | — | UGC отложено |
| Other actions | — | — | — | — | — | overlap с App interactions |

### App info and performance

| Тип | Collected | Shared | Optional? | Purposes | User-facing? | Источник |
|---|---|---|---|---|---|---|
| **Crash logs** | Yes | No | Required | Analytics | No | `app_crash` event через `AnalyticsCrashHandler` (тип ошибки + версия, без stack trace) |
| **Diagnostics** | Yes | No | Required | Analytics | No | Firebase Analytics стандартное: app version, OS version, device model, performance data |
| Other app performance data | No | — | — | — | — | не собираем сверх стандартных Analytics |

### Device or other IDs

| Тип | Collected | Shared | Optional? | Purposes | User-facing? | Источник |
|---|---|---|---|---|---|---|
| **Device or other IDs** | Yes | No | Required | Analytics | No | Firebase Installation ID (сбрасывается при удалении app); Android Advertising ID не используем явно, но Firebase SDK может его читать на устройствах с Google Play Services |

---

## Раздел 3 — Privacy policy URL

В поле «Privacy policy» вставить:

```
https://einnerin.github.io/kartonki/legal/privacy-policy
```

(EN-версия — `/legal/privacy-policy-en` — добавится позже как extra language если нужно.)

---

## Что Console спросит ещё (вне Data safety, но по теме)

### App access
- Опция: **All functionality is available without special access**
- Анонимный режим работает из коробки — login optional. Кнопка Google Sign-In в Login screen, но её можно проскочить.
- Не нужно предоставлять Google тестовые credentials.

### Ads
- **No, my app does not contain ads.**

### Government apps / News / COVID-19 contact tracing
- **No** на все три.

### Target audience and content
- **Target age groups:** 13+ (избегаем Families program с COPPA)
- **Apps in Families:** No — мы не таргетируем детей до 13
- **Designed for children?** No

### Content guidelines
- **User-generated content:** No (UGC отложено, см. memory)
- **Encryption:** Standard TLS, Firebase
