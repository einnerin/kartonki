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
    version = 24,
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
    }
}
