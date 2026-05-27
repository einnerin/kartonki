# Release notes — v0.1.14 (versionCode 15)

**Период:** 2026-05-13 → 2026-05-27 (65 коммитов)
**Прошлый билд:** v0.1.13 (versionCode 14), AAB на диске от 2026-05-13.

## Bump перед загрузкой в Play Console

```kotlin
// app/build.gradle.kts:40-41
versionCode = 15      // было 14
versionName = "0.1.14" // было "0.1.13"
```

## Play Console — Russian (≤500 символов)

```
Версия 0.1.14:
• Новые тематические наборы: религия и праздники (Шабат, Песах, Ямим Нораим),
  политика и право Израиля, израильский баскетбол, флора Израиля, морфология
  иврита, EdTech, удалёнка, морской транспорт, физика и космос.
• Улучшено качество ~1000 определений и примеров: убран канцелярит, исправлены
  тавтологии, добавлены живые контексты.
• Иврит: исправлены RTL-выравнивание в FILL_IN_BLANK квизе и баг с двойным
  пропуском в примерах с повторяющимся словом.
• Расширена база с ~620 до ~684 сетов.
```

## Play Console — English (≤500 chars, для будущей expansion)

```
Version 0.1.14:
• New themed sets: religion & holidays (Shabbat, Pesach, Yamim Noraim), Israeli
  politics & law, Israeli basketball, flora, Hebrew morphology, EdTech, remote
  work, maritime transport, physics & space.
• Quality boost: ~1000 definitions and examples rewritten — less bureaucratic
  jargon, fixed tautologies, more vivid contexts.
• Hebrew bugs fixed: RTL alignment in FILL_IN_BLANK quiz, double-blank issue.
• Database grew from ~620 to ~684 word sets.
```

## Internal changelog (для команды, не в Play Console)

### Контент
- **+24 новых сета (en-ru 461-472, he-ru 1894-1917)** — расширения по темам категории А: Еда (специи), Медицина (анатомия), Природа (геология), Технологии (CS), Наука (физика), Психология (когнитивные искажения), Транспорт (морской), Финансы (рынки), Философия (школы), Работа (удалёнка), Журналистика (fact-checking), Образование (EdTech) — для обоих языков; уникальные для he-ru: религия (3 сета — Шабат, Песах, Ямим Нораим), архитектура Израиля, политика, морфология иврита, идиомы, флора Израиля, право Израиля, спорт-баскетбол, кулинария Израиля, медсистема, лингвистика, хайтек-алгоритмы.

### Качество текстов (массовые правки)
- **447 examples** переписаны под strict letter-for-letter rule (en-ru) — `cookies` → `cookie` в example, чтобы FILL_IN_BLANK не давал «___s» в UI (коммит `1ed5859`)
- **~315 definitionNative** — убрана тавтология «translation в собственном definitionNative» (`7c87066`)
- **47 точечных definitions** — убран headword из собственного definition (`f2f191d`)
- **17 массивных сетов** — definitions переписаны через definition-polisher (1084, 1092, 1093, 1099, 1141, 1240, 1242, 1243, 1245, 1253, 1255, 1266, 1281, 1284, 1287, 1290, 1294)
- **609 терминаторов** добавлено в text-поля (`_autofix_terminators.py`)
- **194 текста** — исправлены exampleNative-копипасты, missing original в example, канцелярит (`1937062`)
- **5 системно слабых сетов переписаны** (62 Философия, 76 Изысканные прилагательные, 423 Business, 439 Животные, 1887 Сад)
- **98 setIds в Hebrew semantic sweep** — ~105 точечных фиксов (typos, mixed-script, неверный pos/semanticGroup) (`9aca2b8`)
- **41 stale сет** — FILL_IN_BLANK exclusions пере-сгенерированы

### UI bug fixes (видны пользователю)
- **Hebrew RTL alignment в FILL_IN_BLANK** (`333aff3`, `777c49a`) — blank больше не уезжает на левый край при Hebrew quiz, options тоже правильно ориентированы
- **Двойной blank в Hebrew примерах** (`333aff3`) — `String.replace` теперь заменяет только первое вхождение (через indexOf+substring + Regex pattern)
- **Compose LayoutDirection.Rtl** обёртка для Hebrew quiz типов

### Quality pipeline (внутреннее)
- **+13 hard-блок-валидаторов**: `no_headword_in_def`, `no_translation_in_defnative`, `text_terminators`, `original_in_example`, `original_strict_in_example`, `no_foreign_in_examplenative`, `no_clerical`, `hebrew_transliteration_format`, `blank_ambiguity_hebrew`, `no_foreign_script_in_original`, `no_mixed_script_in_words`, `example_variety`, `fillinblank_exclusions_fresh`
- **HebrewBlankMatcher (Kotlin)** + Python-port — runtime tolerance к Hebrew-префиксам, 1014 unsafe → 255 (6.8% → 1.7%)
- **Fixture coverage 8 → 19 валидаторов** (38 регрессионных проверок)
- **Pipeline audit** — sync чисел, subagent docs -28%, единый `pipeline-overview.md`
- **WordDataVersion 1493 → 1626** (на каждой правке данных bump'ался)

## Что проверить перед загрузкой

1. `./gradlew bundleRelease` собирается на текущем HEAD
2. Установить AAB на устройство, прогнать smoke-test: открыть Hebrew set, проверить FILL_IN_BLANK квиз (RTL + double-blank fix), открыть один из новых сетов
3. Поднять `versionCode` и `versionName` в `app/build.gradle.kts`, закоммитить
4. Залить в Play Console в Internal testing трек
