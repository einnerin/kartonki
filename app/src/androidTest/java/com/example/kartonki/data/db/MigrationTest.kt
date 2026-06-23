package com.example.kartonki.data.db

import androidx.room.testing.MigrationTestHelper
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val TEST_DB = "migration-test.db"

@RunWith(AndroidJUnit4::class)
class MigrationTest {

    @get:Rule
    val helper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        AppDatabase::class.java,
    )

    @Test
    fun migrate41to42_addsWordsIndexes() {
        helper.createDatabase(TEST_DB, 41).use { db ->
            db.execSQL(
                "INSERT INTO words(original, translation, rarity, languagePair, setId, " +
                "isDefaultPvpCard, isFillInBlankSafe, fillInBlankExclusions) " +
                "VALUES('hello', 'привет', 'COMMON', 'en-ru', 1, 0, 1, '')"
            )
        }
        helper.runMigrationsAndValidate(TEST_DB, 42, true, AppDatabase.MIGRATION_41_42).use { db ->
            val indexes = mutableSetOf<String>()
            db.query("SELECT name FROM sqlite_master WHERE type='index' AND tbl_name='words'").use { c ->
                while (c.moveToNext()) indexes += c.getString(0)
            }
            listOf(
                "index_words_original_languagePair",
                "index_words_languagePair",
                "index_words_rarity",
                "index_words_isDefaultPvpCard",
                "index_words_semanticGroup_languagePair",
                "index_words_setId",
            ).forEach { expected ->
                assertTrue("v42 must contain index $expected; got $indexes", expected in indexes)
            }
            db.query("SELECT translation FROM words WHERE original='hello'").use { c ->
                assertTrue(c.moveToNext())
                assertEquals("привет", c.getString(0))
            }
        }
    }

    @Test
    fun migrate42to43_dropsWordSetMembership() {
        helper.createDatabase(TEST_DB, 42).use { db ->
            db.execSQL("INSERT INTO word_set_membership(wordId, setId) VALUES(1, 1)")
        }
        helper.runMigrationsAndValidate(TEST_DB, 43, true, AppDatabase.MIGRATION_42_43).use { db ->
            val tables = mutableSetOf<String>()
            db.query("SELECT name FROM sqlite_master WHERE type='table'").use { c ->
                while (c.moveToNext()) tables += c.getString(0)
            }
            assertFalse(
                "word_set_membership must not exist in v43; tables=$tables",
                "word_set_membership" in tables,
            )
        }
    }

    @Test
    fun migrate43to44_addsNullableDeviceOwnerIndex() {
        helper.createDatabase(TEST_DB, 43).use { db ->
            db.execSQL(
                "INSERT INTO pvp_matches(timestamp, player1Name, player2Name, " +
                "player1Score, player2Score, winnerName, wasSurrender, languagePair) " +
                "VALUES(123, 'A', 'B', 10, 5, 'A', 0, 'en-ru')"
            )
        }
        helper.runMigrationsAndValidate(TEST_DB, 44, true, AppDatabase.MIGRATION_43_44).use { db ->
            db.query("SELECT deviceOwnerIndex FROM pvp_matches WHERE timestamp=123").use { c ->
                assertTrue(c.moveToNext())
                assertTrue(
                    "legacy row must have NULL deviceOwnerIndex per migration contract",
                    c.isNull(0),
                )
            }
        }
    }

    @Test
    fun fullChain41to44_preservesData() {
        helper.createDatabase(TEST_DB, 41).use { db ->
            db.execSQL(
                "INSERT INTO words(original, translation, rarity, languagePair, setId, " +
                "isDefaultPvpCard, isFillInBlankSafe, fillInBlankExclusions) " +
                "VALUES('cat', 'кот', 'COMMON', 'en-ru', 7, 0, 1, '')"
            )
            db.execSQL(
                "INSERT INTO pvp_matches(timestamp, player1Name, player2Name, " +
                "player1Score, player2Score, winnerName, wasSurrender, languagePair) " +
                "VALUES(1, 'A', 'B', 10, 5, NULL, 0, 'en-ru')"
            )
        }
        helper.runMigrationsAndValidate(
            TEST_DB,
            44,
            true,
            AppDatabase.MIGRATION_41_42,
            AppDatabase.MIGRATION_42_43,
            AppDatabase.MIGRATION_43_44,
        ).use { db ->
            db.query("SELECT translation, setId FROM words WHERE original='cat'").use { c ->
                assertTrue(c.moveToNext())
                assertEquals("кот", c.getString(0))
                assertEquals(7L, c.getLong(1))
            }
            db.query(
                "SELECT player1Score, deviceOwnerIndex FROM pvp_matches WHERE timestamp=1"
            ).use { c ->
                assertTrue(c.moveToNext())
                assertEquals(10, c.getInt(0))
                assertTrue("legacy pvp_matches.deviceOwnerIndex must be NULL", c.isNull(1))
            }
        }
    }

    @Test
    fun migrate44to45_addsIsMasteredDefaultFalseAndKeepsHistory() {
        helper.createDatabase(TEST_DB, 44).use { db ->
            db.execSQL(
                "INSERT INTO progress(wordId, correctCount, incorrectCount, level, " +
                "nextReviewAt, pvpCorrectCount, pvpIncorrectCount) " +
                "VALUES(1, 3, 5, 2, 0, 0, 0)"
            )
        }
        helper.runMigrationsAndValidate(TEST_DB, 45, true, AppDatabase.MIGRATION_44_45).use { db ->
            db.query("SELECT isMastered, incorrectCount FROM progress WHERE wordId=1").use { c ->
                assertTrue(c.moveToNext())
                assertEquals("isMastered must default to 0 for legacy rows", 0, c.getInt(0))
                assertEquals("incorrectCount must be preserved by the migration", 5, c.getInt(1))
            }
        }
    }
}
