# Правила: База данных (Room)

## Файлы для чтения перед работой
- `data/db/AppDatabase.kt` — версия БД + все миграции
- `data/db/entity/` — все Entity-классы
- `data/db/dao/` — все DAO

## Текущая версия БД
`version = 40` (в аннотации `@Database`). Последняя миграция `MIGRATION_39_40` добавила
колонку `fillInBlankExclusions` (TEXT, CSV ids) — см. [`fill-in-blank-pipeline.md`](fill-in-blank-pipeline.md).

## Таблицы
`words`, `word_sets`, `word_set_membership`, `collection`, `decks`, `deck_cards`,
`progress`, `achievements`, `study_streaks`, `pvp_matches`, `retained_favorites`

## Защита избранных наборов (isFavorite)
`retained_favorites` — вспомогательная таблица (setId INTEGER PK).
**Если миграция удаляет `word_sets`**, перед удалением обязательно:
```sql
INSERT OR REPLACE INTO retained_favorites SELECT id FROM word_sets WHERE isFavorite = 1
```
WordLoader автоматически восстановит `isFavorite = 1` и очистит таблицу при следующем запуске.

## Чеклист при изменении схемы

1. **Измени Entity** — добавь/удали поле.
2. **Создай миграцию** в `AppDatabase.companion`. Нумерация — следующая после последней (см. выше, `MIGRATION_39_40`):
   ```kotlin
   val MIGRATION_40_41 = object : Migration(40, 41) {
       override fun migrate(db: SupportSQLiteDatabase) {
           db.execSQL("ALTER TABLE ... ADD COLUMN ...")
       }
   }
   ```
3. **Подними версию** в `@Database(version = 41, ...)` на следующее число.
4. **Зарегистрируй миграцию** в `DatabaseModule` (или где создаётся `Room.databaseBuilder`) — добавь `.addMigrations(MIGRATION_40_41)`.
5. **Никогда не меняй уже выпущенную миграцию** — создавай новую поверх.
6. **Параллельные агенты не могут одновременно добавлять миграции** (см. [`rules-index.md#13`](rules-index.md)) — номера строго последовательны, конфликт гарантирован.

## Паттерны миграций (из истории)

| Ситуация | Что делать |
|----------|-----------|
| Добавить колонку | `ALTER TABLE t ADD COLUMN col TYPE DEFAULT val` |
| Удалить строки (reseed) | `DELETE FROM table WHERE condition` |
| Исправить данные | `UPDATE words SET rarity='X' WHERE id IN (...)` |
| Новая таблица | `CREATE TABLE IF NOT EXISTS ...` |
| Новый индекс | `CREATE UNIQUE INDEX IF NOT EXISTS ... ON table(col1, col2)` |
| Полный сброс данных | `DELETE FROM words / word_sets / progress / collection / deck_cards` — WordLoader пересеет при следующем запуске |

## Индекс на words
`index_words_original_languagePair ON words(original, languagePair)` — **non-unique** индекс для производительности запросов. Исторически был UNIQUE (добавлен в 32→33), но убран в 37→38 — теперь одно слово может появляться в наборах разных тем. См. `rules-index.md#5` (политика дублей между темами).

## Частые ошибки
- Изменил Entity, но забыл поднять версию → краш `Room.IllegalStateException` у пользователей.
- Добавил миграцию, но не зарегистрировал её → `fallbackToDestructiveMigration` сотрёт данные.
- Миграция удаляет строки, но не чистит зависимые таблицы (progress, collection, deck_cards) → висящие foreign-key-like ссылки.
