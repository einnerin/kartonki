package com.example.kartonki.data.repository

import com.example.kartonki.data.SeedData
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.dao.WordSetDao
import com.example.kartonki.data.db.entity.WordSetEntity
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WordSetRepository @Inject constructor(
    private val wordSetDao: WordSetDao,
    private val wordDao: WordDao,
) {
    /** Inserts seed sets + words on first run (or after destructive migration). */
    suspend fun ensureSeeded() {
        if (wordSetDao.getSetCount() == 0) {
            wordSetDao.insertSets(SeedData.sets)
            wordDao.insertAll(SeedData.words)
        }
    }

    suspend fun getAllSets(): List<WordSetEntity> = wordSetDao.getAllSets()

    suspend fun getSetById(id: Long): WordSetEntity? = wordSetDao.getSetById(id)

    suspend fun getWordsInSet(setId: Long): List<Word> =
        wordSetDao.getWordsInSet(setId).map { entity ->
            Word(
                id = entity.id,
                original = entity.original,
                translation = entity.translation,
                definition = entity.definition,
                example = entity.example,
                rarity = Rarity.valueOf(entity.rarity),
                languagePair = entity.languagePair,
                pos = entity.pos,
                semanticGroup = entity.semanticGroup,
            )
        }

    suspend fun getWordCountInSet(setId: Long): Int = wordSetDao.getWordCountInSet(setId)

    suspend fun getRarityForSet(setId: Long): Rarity =
        wordSetDao.getRarityForSet(setId)?.let { runCatching { Rarity.valueOf(it) }.getOrNull() }
            ?: Rarity.COMMON
}
