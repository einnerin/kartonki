package com.example.kartonki.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.kartonki.data.db.dao.AchievementDao
import com.example.kartonki.data.db.dao.CollectionDao
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.db.dao.ProgressDao
import com.example.kartonki.data.db.dao.PvpMatchDao
import com.example.kartonki.data.db.dao.StudyStreakDao
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.dao.WordSetDao
import com.example.kartonki.data.db.entity.AchievementEntity
import com.example.kartonki.data.db.entity.CollectionEntity
import com.example.kartonki.data.db.entity.DeckCardCrossRef
import com.example.kartonki.data.db.entity.DeckEntity
import com.example.kartonki.data.db.entity.ProgressEntity
import com.example.kartonki.data.db.entity.PvpMatchEntity
import com.example.kartonki.data.db.entity.StudyStreakEntity
import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

@Database(
    entities = [
        WordEntity::class,
        WordSetEntity::class,
        CollectionEntity::class,
        DeckEntity::class,
        DeckCardCrossRef::class,
        ProgressEntity::class,
        AchievementEntity::class,
        StudyStreakEntity::class,
        PvpMatchEntity::class,
    ],
    version = 27,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
    abstract fun wordSetDao(): WordSetDao
    abstract fun collectionDao(): CollectionDao
    abstract fun deckDao(): DeckDao
    abstract fun progressDao(): ProgressDao
    abstract fun achievementDao(): AchievementDao
    abstract fun studyStreakDao(): StudyStreakDao
    abstract fun pvpMatchDao(): PvpMatchDao

    companion object {
        val MIGRATION_16_17 = object : Migration(16, 17) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE word_sets ADD COLUMN languagePair TEXT NOT NULL DEFAULT 'en-ru'")
                db.execSQL("ALTER TABLE words ADD COLUMN transliteration TEXT")
            }
        }
        /** Removes incorrectly-seeded Hebrew data so ensureSeeded() re-inserts it cleanly. */
        val MIGRATION_17_18 = object : Migration(17, 18) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("DELETE FROM words WHERE setId IN (101, 102, 103)")
                db.execSQL("DELETE FROM word_sets WHERE id IN (101, 102, 103)")
            }
        }
        /** Adds definitionNative and exampleNative columns; reseeds Hebrew with corrected data. */
        val MIGRATION_18_19 = object : Migration(18, 19) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE words ADD COLUMN definitionNative TEXT")
                db.execSQL("ALTER TABLE words ADD COLUMN exampleNative TEXT")
                db.execSQL("DELETE FROM words WHERE setId IN (101, 102, 103)")
                db.execSQL("DELETE FROM word_sets WHERE id IN (101, 102, 103)")
            }
        }
        /** Adds PvP-specific counters to progress for problem-words source filtering. */
        val MIGRATION_19_20 = object : Migration(19, 20) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE progress ADD COLUMN pvpCorrectCount INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE progress ADD COLUMN pvpIncorrectCount INTEGER NOT NULL DEFAULT 0")
            }
        }
        /**
         * Resets the collection so ensureStarterPack() re-seeds it with ~500 cards
         * instead of the old behaviour of adding every word to the collection.
         * PvE no longer requires collection ownership — it uses wordDao directly.
         */
        val MIGRATION_20_21 = object : Migration(20, 21) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("DELETE FROM collection")
            }
        }
        /** Adds surrender flag to pvp_matches for WHITE_FLAG hidden achievement. */
        val MIGRATION_21_22 = object : Migration(21, 22) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE pvp_matches ADD COLUMN wasSurrender INTEGER NOT NULL DEFAULT 0")
            }
        }
        /** Adds isFavorite flag to word_sets for the Favourites tab in StudyScreen. */
        val MIGRATION_22_23 = object : Migration(22, 23) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE word_sets ADD COLUMN isFavorite INTEGER NOT NULL DEFAULT 0")
            }
        }
        /**
         * Fixes sets 211–219 (Архитектура … Химия) which may have been seeded with the wrong
         * setId in older builds. Deleting by word-ID range guarantees removal regardless of
         * whatever setId is currently stored. ensureSeeded() / doSeed() will re-insert them
         * with the correct setId immediately after the migration.
         * Word IDs 2266–2490 belong exclusively to sets 211–219 (25 words × 9 sets = 225 rows).
         */
        val MIGRATION_23_24 = object : Migration(23, 24) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("DELETE FROM words WHERE id BETWEEN 2266 AND 2490")
            }
        }
        /**
         * Corrects 6 rarity misclassifications found during full audit:
         *  id=357  library:    COMMON   → UNCOMMON
         *  id=391  bargain:    COMMON   → UNCOMMON
         *  id=915  atom:       UNCOMMON → COMMON
         *  id=1323 narcissism: RARE     → EPIC
         *  id=1597 anticipate: EPIC     → RARE
         *  id=2122 pilot(noun):COMMON   → UNCOMMON
         */
        val MIGRATION_24_25 = object : Migration(24, 25) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("UPDATE words SET rarity = 'UNCOMMON' WHERE id IN (357, 391, 2122)")
                db.execSQL("UPDATE words SET rarity = 'COMMON'   WHERE id = 915")
                db.execSQL("UPDATE words SET rarity = 'EPIC'     WHERE id = 1323")
                db.execSQL("UPDATE words SET rarity = 'RARE'     WHERE id = 1597")
            }
        }
        /**
         * Full rarity audit — 27 corrections:
         *
         * COMMON → UNCOMMON (слова выше A1):
         *  274 region, 275 suburb, 288 ambulance, 289 prescription, 290 allergy,
         *  299 ache, 364 canteen, 368 assembly, 418 tournament, 423 championship,
         *  479 luggage, 490 hostel, 493 boarding, 531 colleague, 532 salary,
         *  548 absence, 2125 architect, 2583 arrest, 2584 victim
         *
         * LEGENDARY → EPIC (подтверждённые C1, не C2+):
         *  1903 euphemism, 1905 anomaly, 1953 circumvent,
         *  2050 eradicate, 2052 proliferate, 2056 culminate
         *
         * RARE → UNCOMMON: 1254 journalist (B1)
         * EPIC → RARE:     1609 refugee (B2)
         */
        val MIGRATION_25_26 = object : Migration(25, 26) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("""UPDATE words SET rarity = 'UNCOMMON'
                    WHERE id IN (274,275,288,289,290,299,364,368,418,423,
                                 479,490,493,531,532,548,2125,2583,2584,1254)""")
                db.execSQL("UPDATE words SET rarity = 'EPIC' WHERE id IN (1903,1905,1953,2050,2052,2056)")
                db.execSQL("UPDATE words SET rarity = 'RARE' WHERE id = 1609")
            }
        }
        /**
         * Splits 9 thematic sets (200,201,202,203,204,206,208,209,219) that mixed
         * COMMON+EPIC/LEGENDARY words into two halves:
         *   - "X: основы"    (sets 200–219, COMMON+UNCOMMON words stay)
         *   - "X: углублённо" (sets 240–248, RARE/EPIC/LEGENDARY words move here)
         *
         * For existing users: creates the new word_sets rows and re-points the
         * 113 moved words to their new setId. New words (id >= 3076) are inserted
         * by doSeed() via the word-count sentinel check.
         */
        val MIGRATION_26_27 = object : Migration(26, 27) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Rename the 9 split sets to "основы" variant
                db.execSQL("UPDATE word_sets SET name='Супермаркет: основы',      description='Покупки в магазине — базовая лексика'          WHERE id=200")
                db.execSQL("UPDATE word_sets SET name='Инструменты: основы',      description='Базовые инструменты и материалы'                WHERE id=201")
                db.execSQL("UPDATE word_sets SET name='Праздники: основы',        description='Праздники и торжества — базовая лексика'        WHERE id=202")
                db.execSQL("UPDATE word_sets SET name='Профессии 2: основы',      description='Распространённые профессии и специальности'     WHERE id=203")
                db.execSQL("UPDATE word_sets SET name='Быт: основы',              description='Домашний быт — базовая лексика'                 WHERE id=204")
                db.execSQL("UPDATE word_sets SET name='Кино и театр: основы',     description='Кино и театр — базовая лексика'                 WHERE id=206")
                db.execSQL("UPDATE word_sets SET name='Садоводство: основы',      description='Сад и огород — базовая лексика'                 WHERE id=208")
                db.execSQL("UPDATE word_sets SET name='Интернет и соцсети: основы',description='Цифровой мир — базовая лексика'                WHERE id=209")
                db.execSQL("UPDATE word_sets SET name='Химия: основы',            description='Химия — базовые понятия'                        WHERE id=219")
                // Create the new "углублённо" word_set rows
                db.execSQL("INSERT OR IGNORE INTO word_sets(id,name,description,orderIndex,languagePair,isFavorite) VALUES(240,'Супермаркет: углублённо','Торговля и ритейл — продвинутая лексика',123,'en-ru',0)")
                db.execSQL("INSERT OR IGNORE INTO word_sets(id,name,description,orderIndex,languagePair,isFavorite) VALUES(241,'Инструменты: углублённо','Специализированные инструменты и техники',124,'en-ru',0)")
                db.execSQL("INSERT OR IGNORE INTO word_sets(id,name,description,orderIndex,languagePair,isFavorite) VALUES(242,'Праздники: углублённо','Торжества и церемонии — продвинутая лексика',125,'en-ru',0)")
                db.execSQL("INSERT OR IGNORE INTO word_sets(id,name,description,orderIndex,languagePair,isFavorite) VALUES(243,'Профессии 2: углублённо','Редкие и узкоспециализированные профессии',126,'en-ru',0)")
                db.execSQL("INSERT OR IGNORE INTO word_sets(id,name,description,orderIndex,languagePair,isFavorite) VALUES(244,'Быт: углублённо','Домашний быт — продвинутая и техническая лексика',127,'en-ru',0)")
                db.execSQL("INSERT OR IGNORE INTO word_sets(id,name,description,orderIndex,languagePair,isFavorite) VALUES(245,'Кино и театр: углублённо','Кинематограф и сцена — профессиональная лексика',128,'en-ru',0)")
                db.execSQL("INSERT OR IGNORE INTO word_sets(id,name,description,orderIndex,languagePair,isFavorite) VALUES(246,'Садоводство: углублённо','Ботаника и агрономия — продвинутая лексика',129,'en-ru',0)")
                db.execSQL("INSERT OR IGNORE INTO word_sets(id,name,description,orderIndex,languagePair,isFavorite) VALUES(247,'Интернет и соцсети: углублённо','Кибербезопасность и технологии — продвинутая лексика',130,'en-ru',0)")
                db.execSQL("INSERT OR IGNORE INTO word_sets(id,name,description,orderIndex,languagePair,isFavorite) VALUES(248,'Химия: углублённо','Химия — углублённая и специализированная лексика',131,'en-ru',0)")
                // Move RARE/EPIC/LEGENDARY words from basics sets to their new advanced sets
                db.execSQL("UPDATE words SET setId=240 WHERE id IN (2076,2083,2085,2086,2087,2089,2090,2091,2092,2494,2495,2496,2497,2498)")
                db.execSQL("UPDATE words SET setId=241 WHERE id IN (2102,2103,2104,2106,2107,2505,2506,2507,2508)")
                db.execSQL("UPDATE words SET setId=242 WHERE id IN (2115,2117,2119,2517,2518,2519,2520)")
                db.execSQL("UPDATE words SET setId=243 WHERE id IN (2130,2132,2133,2134,2135,2525,2526,2527,2528,2529,2530)")
                db.execSQL("UPDATE words SET setId=244 WHERE id IN (2146,2147,2148,2149,2150,2536,2537,2538,2539,2540)")
                db.execSQL("UPDATE words SET setId=245 WHERE id IN (2176,2178,2181,2182,2183,2184,2185,2186,2187,2188,2189,2190,2549,2550)")
                db.execSQL("UPDATE words SET setId=246 WHERE id IN (2211,2212,2213,2215,2216,2217,2219,2221,2222,2223,2224,2225,2226,2227,2228,2559,2560,2561,2562)")
                db.execSQL("UPDATE words SET setId=247 WHERE id IN (2237,2240,2241,2242,2243,2244,2245,2246,2247,2568)")
                db.execSQL("UPDATE words SET setId=248 WHERE id IN (2471,2472,2474,2475,2476,2477,2478,2479,2480,2481,2482,2483,2484,2485,2486,2487,2488,2489,2490)")
            }
        }
    }
}
