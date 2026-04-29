# Content rating (IARC) — шпаргалка

Заполняется в Console: **App content → Content rating → Start questionnaire**.

IARC — International Age Rating Coalition. Один опросник, на выходе сразу несколько рейтингов: ESRB (US), PEGI (EU), USK (DE), Classification Board (AU), GRAC (KR), и др. Для русского рынка важен PEGI/ESRB; в РФ Play Store рейтинг — производный от тех же ответов.

---

## Шаг 1 — Email и категория

| Поле | Ответ |
|---|---|
| Email address | `einerin40@gmail.com` |
| Category | **Reference, News, or Educational** |

**Почему не Game:** хотя у Kartonki есть PvP-битвы, основное — обучение. Education-подход даёт более мягкий рейтинг (3+/PEGI 3) и попадает в правильные подборки. Word Game категория тянет за собой вопросы про game elements.

---

## Шаг 2 — Опросник (для Reference/News/Educational)

Все вопросы — **Yes / No**. Ниже — что ответить и почему.

### Violence
| Вопрос | Ответ | Обоснование |
|---|---|---|
| Does the app contain violence? | **No** | PvP — это викторина на знание слов, никакого визуала ударов/борьбы |
| Does the app contain references to violence? | **No** | в словах могут попадаться `war`, `fight`, `weapon` как лексика, но это не «contains references» в смысле IARC — это словарь |

### Sexuality
| Вопрос | Ответ | Обоснование |
|---|---|---|
| Does the app contain sexually explicit content? | **No** | |
| Does the app contain references to sexuality? | **No** | в продвинутой лексике есть `kiss`, `romance`, `relationship` — это нейтральный словарь, не контент |
| Does the app contain nudity? | **No** | |

### Language
| Вопрос | Ответ |
|---|---|
| Does the app contain crude or inappropriate language? | **No** |
| Does the app contain swearing? | **No** |

> Если в наборе слов попадутся слова уровня LEGENDARY типа `damn`, `hell`, `crap` — это не классифицируется как «swearing» по IARC (это mild slang). True profanity (англ. f-word, c-word) у нас нет в списках.

### Controlled Substances
| Вопрос | Ответ | Обоснование |
|---|---|---|
| Does the app contain references to drugs, alcohol, or tobacco? | **No** | можно ответить **Yes** если хочешь быть супер-аккуратным — `wine`, `beer`, `cigarette` могут встречаться в темах «еда» / «вечеринки». Но это **lexical reference**, не glamorizing. Для educational app — No корректнее. |

### Gambling and Contests
| Вопрос | Ответ | Обоснование |
|---|---|---|
| Does the app contain simulated gambling? | **No** | паки в коллекции — это reward за обучение, не loot box за деньги (free, no IAP) |
| Does the app contain real gambling? | **No** | |

> ⚠️ Если Google спросит про **loot boxes** отдельно — у нас есть «паки» с случайным содержимым, но они **зарабатываются игрой** (3 активности = 100 жетонов = 1 пак), не покупаются. Это **не классифицируется как gambling** per IARC. Если вопрос явно про random rewards earned through gameplay — отвечай **No**, это стандартная reward механика.

### Fear and Horror
| Вопрос | Ответ |
|---|---|
| Does the app contain horror imagery? | **No** |
| Does the app contain content that may scare children? | **No** |

### Crime / Discrimination / Other
| Вопрос | Ответ |
|---|---|
| Does the app contain criminal activities? | **No** |
| Does the app contain discriminatory content? | **No** |
| Other inappropriate content? | **No** |

### Interactive elements
Этот блок Google спросит отдельно — он не влияет на рейтинг, но влияет на пометки на карточке.

| Вопрос | Ответ | Обоснование |
|---|---|---|
| Users interact with each other (chat, messages, voice)? | **Yes** | online PvP позволяет видеть никнейм соперника. Хотя чата нет, **«users see each other»** — Yes |
| Users share location with other users? | **No** | |
| Users share personal info with other users? | **No** | только displayName в PvP лобби |
| Users buy digital goods? | **No** | |

> Про PvP: в коде нет чата, только видишь никнейм соперника и его ходы. Вероятно Google обозначит «User Interaction» — это нормальная пометка, не штраф.

---

## Ожидаемый итоговый рейтинг

После таких ответов:
- **PEGI 3** (Suitable for all ages, может быть отметка «Online interactivity»)
- **ESRB Everyone** (3+)
- **USK 0** (DE)
- **IARC 3+**

Это идеально для education app. Никаких возрастных ограничений в Play Store, попадает в максимум стран.

---

## Если опросник изменится

Google периодически обновляет вопросы. Если увидишь незнакомый — общий принцип:
1. Если про конкретный визуальный/нарративный контент в приложении → почти всегда **No** (мы — словарь+квиз)
2. Если про user interaction → **Yes** на «users see each other», **No** на остальное
3. Если про monetization → **No, free app, no IAP, no ads**

Если сомневаешься — пингуй меня с конкретным вопросом, разберём.
