package com.example.kartonki.data.repository

import com.example.kartonki.data.SeedData
import com.example.kartonki.data.SeedDataEnglishNative
import com.example.kartonki.data.SeedDataHebrew
import com.example.kartonki.data.SeedDataHebrewEveryday
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
        if (wordSetDao.getSetCountByLanguage("en-ru") == 0) {
            wordSetDao.insertSets(SeedData.sets)
            wordDao.insertAll(SeedData.words)
        }
        if (wordSetDao.getSetCountByLanguage("he-ru") == 0) {
            wordSetDao.insertSets(SeedDataHebrew.sets)
            wordDao.insertAll(SeedDataHebrew.words)
        }
        // Everyday Hebrew sets added in a later update — seed if set 104 is missing.
        if (wordSetDao.getSetById(104L) == null) {
            wordSetDao.insertSets(SeedDataHebrewEveryday.sets)
            wordDao.insertAll(SeedDataHebrewEveryday.words)
        }
        // Patch English words with Russian-language native content (definitionNative + exampleNative).
        // Runs once: skipped when the count of already-patched English words matches the dataset.
        patchEnglishNativeContent()
    }

    private suspend fun patchEnglishNativeContent() {
        val alreadyDone = wordDao.countWordsWithNativeContent("en-ru")
        if (alreadyDone >= SeedDataEnglishNative.ENTRY_COUNT) return
        SeedDataEnglishNative.data.forEach { (original, content) ->
            wordDao.updateNativeContent(
                original = original,
                langPair = "en-ru",
                defNative = content.first,
                exNative  = content.second,
            )
        }
    }

    suspend fun getSetsByLanguage(languagePair: String): List<WordSetEntity> =
        wordSetDao.getSetsByLanguage(languagePair)

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
                transliteration = entity.transliteration,
                definitionNative = entity.definitionNative,
                exampleNative = entity.exampleNative,
            )
        }

    suspend fun getWordCountInSet(setId: Long): Int = wordSetDao.getWordCountInSet(setId)

    suspend fun getRarityForSet(setId: Long): Rarity =
        wordSetDao.getRarityForSet(setId)?.let { runCatching { Rarity.valueOf(it) }.getOrNull() }
            ?: Rarity.COMMON
}
