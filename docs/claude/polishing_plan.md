# План дальнейшей полировки английских текстов

## Готово

### Полировка
- **Batch3** (сеты 250–252) — 75 def + 14 example
- **Batch4** (сеты 253–255) — 75 def + 18 example (3 blood-правки по обновлённому стандарту)
- **Batch5** (сеты 256–258) — 75 def + 18 example
- **Batch6** (сеты 259–261) — 43 def + 14 example
- **WordDataEnglish.kt сеты 1–5** — 125 def правок (example ещё не делались)

### Первичное написание текстов (text-author)
- **Batch7** (262–264), **Batch8** (265–267), **Batch9** (268–270), **Batch10** (271–273) — 300 слов × 4 поля
- **Batch11** (274–278), **Batch12** (279–283) — 250 слов × 4 поля
- **Batch13** (284–287) — 100 слов × 4 поля
- **Batch14** (288–291), **Batch15** (292–295), **Batch16** (296–298) — 275 слов × 4 поля
- **Всего:** 37 setId × 25 слов = 925 слов × 4 поля = **3700 новых текстов**

### Первичное заполнение pos/semanticGroup (metadata-filler)
- Все 37 setId из списка выше получили `pos` (длинные формы: noun/verb/adjective/adverb/preposition/pronoun/interjection/number) и `semanticGroup` по принципу «опасных близнецов» (слова в одной группе — правдоподобные альтернативы в квизе)
- **222 уникальных semanticGroup** на 925 слов (~6 групп на setId)
- Размеры: 48 групп по 2 слова (21.6%), 170 групп 3-8 слов (76.6%), 4 группы 9+ слов (1.8%)
- 1-словных групп нет (кросс-наборные группы `city_ways`/`city_venues_civic` покрывают единичные члены через `WordSetRepository.getDistractorExtras`)

## Осталось

### Полировка `definitionNative` в Batch3–6 + Batch17
**Новая задача.** Обнаружено при работе с text-author: в уже отполированных Batch3–6 поле `definitionNative` осталось **деревянным** (канцелярит «используемый для», «подаваемый» и т.п.) — polisher в прошлой сессии правил только английский `definition`. Поле **используется в квизах** (`MULTIPLE_CHOICE_DEFINITION_NATIVE`) и показывается на LEGENDARY-карточках — критично для UX.

**Что делать:** прогнать `definition-polisher` с инструкцией править именно `definitionNative` по стандарту живого стиля (без канцелярита). Файлы: Batch3, Batch4, Batch5, Batch6, Batch17 — 325 слов.

### Полировка больших файлов (не трогались)
- **WordDataEnglish.kt сеты 6–84** — definitions (остаток ~1952 слов) + examples всех 2077 слов
- **WordDataEnglishExpanded.kt** — definitions + examples (~1265 слов)

### Нормализация pos: `adj` → `adjective`, `adv` → `adverb`
33 слов в базе имеют `pos = "adj"` и 6 — `pos = "adv"` (устаревшая короткая форма). Это ломает strict-equality в `QuizBuilder.pickDistractors` tier1. **Что делать:** sed-замена по всей базе. Мелкая задача.

## Стратегия для больших файлов

Делать чанками по 5 сетов (~125 слов) в свежих сессиях Claude, чтобы контекст родителя не переполнялся.

Пример команды: **«Запусти definition-polisher на WordDataEnglish.kt сеты 6–10»**.

Между чанками: коммит с указанием сетов в сообщении, пуш, отчёт.

## Инфраструктура агентов (всё под git)

| Агент | Назначение | Спека |
|-------|-----------|-------|
| `definition-polisher` | Правит существующие `definition` в живой стиль | `.claude/agents/definition-polisher.md` |
| `example-polisher` | Правит `example` в живую речь носителя | `.claude/agents/example-polisher.md` |
| `text-author` | Пишет с нуля 4 текстовых поля | `.claude/agents/text-author.md` |
| `metadata-filler` | Заполняет pos/semanticGroup | `.claude/agents/metadata-filler.md` |

Стандарты качества в `docs/claude/quality_standards_definitions.md` и `docs/claude/quality_standards_examples.md`.

## Иврит

Не трогать до отдельного обсуждения — нужен специальный подход (носитель языка для проверки грамматики, огласовок, биньянов).
