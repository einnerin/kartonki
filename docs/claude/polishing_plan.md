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

## Технический долг, выявленный валидаторами

Запуск `scripts/validate/` по живой базе вскрыл два слоя известного/нового техдолга. Описаны отдельно, т.к. масштаб исправлений разный и приоритет разный.

### Категория A — `definitionNative` в Batch3–6 + Batch17 (ожидаемый)

**Где.** setId 250–261 (Batch3-6) и 299 (Batch17). Около **300 слов в 13 setId**.

**Что ловят валидаторы.**
- `validate_text_lengths` — `definitionNative` превышает 80 символов из-за канцелярских конструкций типа «используемый для», «подаваемый», «являющийся».
- `validate_no_cognates` — в `definitionNative` присутствуют однокоренные с `translation` (напр. `beverage`/«напиток» → defNative содержит «напит»).

**Причина.** В предыдущих сессиях `definition-polisher` правил только английский `definition`. Русское `definitionNative` осталось в стиле исходной генерации — дословный перевод без «живого учителя».

**Как чинить.** Прогнать `definition-polisher` с явной инструкцией править именно поле `definitionNative` по стандарту живого стиля (стандарт уже написан, нужно только инструктивное указание агенту).

**Приоритет.** Средний — улучшение качества квиза `MULTIPLE_CHOICE_DEFINITION_NATIVE` + LEGENDARY-карточек. Не блокирует UX, но заметно для пользователей.

**Проверка после починки.** `bash scripts/validate/validate_all.sh <setId>` должен вернуть 0 для каждого из 13 сетов.

### Категория B — плоский `semanticGroup` в legacy (новый)

**Где.** `WordDataEnglish.kt` сеты 1–83 и `WordDataEnglishExpanded.kt` 200–249 + Hebrew legacy (`WordDataHebrew.kt`, `WordDataHebrewEveryday.kt`, `WordDataHebrewMore.kt`, `WordDataHebrewImmigrant*.kt` и т.п.). Порядка **~100 сетов**.

**Что ловят валидаторы.**
- `validate_group_sizes` — блокирует из-за групп **13+ слов**. Типичная ситуация: весь сет лежит в одном плоском `semanticGroup="daily_life"` (25 слов) или `semanticGroup="family"` и т.д.

**Причина.** Legacy-архитектура: один сет = одна тема = один semanticGroup, без подгрупп. Отличается от новой конвенции (3–8 слов на подгруппу, см. [`quality_standards_metadata.md`](quality_standards_metadata.md)).

**Как чинить.** Прогнать `metadata-filler` на каждом legacy-сете с инструкцией разбить плоскую группу на 3–5 подгрупп по принципу «опасных близнецов». Также проверить/добавить `pos` где отсутствует.

**Приоритет.** Низкий для релиза (квиз работает, просто дистракторы tier1 менее оптимальны), **высокий для долгосрочного качества** — без исправления весь `QuizBuilder.pickDistractors` tier1 в legacy вырождается до tier2.

**Проверка.** `bash scripts/validate/audit_all_files.sh` — цель: ≥95% setIds проходят все 7 валидаторов.

### Мелкие задачи (быстро, отдельно)

**Нормализация `pos = "interj"` → `"interjection"` и `"pron"` → `"pronoun"`** — 8 слов суммарно. Когда запустится `validate_pos_values` на полном базе, он их покажет. Фикс: `sed -i 's|pos = "interj"|pos = "interjection"|g; s|pos = "pron"|pos = "pronoun"|g' app/src/main/java/com/example/kartonki/data/WordData*.kt`. После — прогнать `validate_pos_values.sh` на затронутых setId, чтобы убедиться в прохождении.

### Полировка больших файлов (не трогались)
- **WordDataEnglish.kt сеты 6–84** — definitions (остаток ~1952 слов) + examples всех 2077 слов
- **WordDataEnglishExpanded.kt** — definitions + examples (~1265 слов)

Это работа под отдельные сессии чанками по 5 setId, как описано ниже в «Стратегии для больших файлов».

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
