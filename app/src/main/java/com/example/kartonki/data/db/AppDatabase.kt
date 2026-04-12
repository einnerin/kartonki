package com.example.kartonki.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
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
    version = 15,
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
}
