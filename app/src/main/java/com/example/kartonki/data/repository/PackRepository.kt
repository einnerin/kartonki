package com.example.kartonki.data.repository

import com.example.kartonki.data.AchievementCards
import com.example.kartonki.data.db.dao.CollectionDao
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.entity.CollectionEntity
import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class PackRepository @Inject constructor(
    private val wordDao: WordDao,
    private val collectionDao: CollectionDao,
    private val userPrefs: UserPreferencesRepository,
) {
    private val _pendingNewCards = MutableStateFlow<List<Word>>(emptyList())
    val pendingNewCards: StateFlow<List<Word>> = _pendingNewCards.asStateFlow()

    val activityCount: Flow<Int>  = userPrefs.activityCount
    val freePackCount: Flow<Int>  = userPrefs.freePackCount
    val languagePair: Flow<String> = userPrefs.languagePair

    fun clearPendingNewCards() {
        _pendingNewCards.value = emptyList()
    }

    suspend fun onActivityCompleted() {
        val current = userPrefs.getActivityCount()
        val next = current + 1
        if (next >= 3) {
            userPrefs.setActivityCount(0)
            userPrefs.setFreePackCount(userPrefs.getFreePackCount() + 1)
        } else {
            userPrefs.setActivityCount(next)
        }
    }

    suspend fun consumeAndOpenPacks(count: Int): List<Word> {
        val current = userPrefs.getFreePackCount()
        val toConsume = minOf(count, current)
        if (toConsume > 0) {
            userPrefs.setFreePackCount(current - toConsume)
        }
        return (1..toConsume).flatMap { generatePackCards() }
    }

    private suspend fun generatePackCards(): List<Word> {
        val langPair = userPrefs.getLanguagePair()
        val allWords = wordDao.getAllWordsByLanguage(langPair)
            .filter { it.original !in AchievementCards.ALL_EXCLUSIVE }
        val byRarity = allWords.groupBy { it.rarity }

        val result = mutableListOf<WordEntity>()

        // Slot 1: guaranteed Uncommon+
        pickByRarity(byRarity, GUARANTEED_WEIGHTS)?.let { result.add(it) }

        // Slots 2-5: normal weights
        repeat(4) {
            pickByRarity(byRarity, NORMAL_WEIGHTS)?.let { result.add(it) }
        }

        // Fill to 5 if needed
        if (result.size < 5) {
            val already = result.map { it.id }.toSet()
            val fallback = allWords.filter { it.id !in already }.shuffled().take(5 - result.size)
            result.addAll(fallback)
        }

        val words = result.take(5).map { it.toDomain() }

        // Add to collection
        collectionDao.insertAll(words.map { CollectionEntity(wordId = it.id) })

        return words
    }

    private fun pickByRarity(
        byRarity: Map<String, List<WordEntity>>,
        weights: Map<String, Float>,
    ): WordEntity? {
        val roll = Random.Default.nextFloat()
        var cumulative = 0f
        for ((rarityName, weight) in weights) {
            cumulative += weight
            if (roll <= cumulative) {
                val candidates = byRarity[rarityName]
                if (!candidates.isNullOrEmpty()) {
                    return candidates.random()
                }
            }
        }
        // Fallback: pick any available word
        return byRarity.values.flatten().randomOrNull()
    }

    private fun WordEntity.toDomain(): Word = Word(
        id = id,
        original = original,
        translation = translation,
        definition = definition,
        definitionNative = definitionNative,
        example = example,
        exampleNative = exampleNative,
        rarity = Rarity.valueOf(rarity),
        languagePair = languagePair,
        pos = pos,
        semanticGroup = semanticGroup,
        transliteration = transliteration,
        isFillInBlankSafe = isFillInBlankSafe,
        fillInBlankExclusions = fillInBlankExclusions,
    )

    companion object {
        val NORMAL_WEIGHTS = linkedMapOf(
            "COMMON"    to 0.60f,
            "UNCOMMON"  to 0.25f,
            "RARE"      to 0.10f,
            "EPIC"      to 0.04f,
            "LEGENDARY" to 0.01f,
        )
        val GUARANTEED_WEIGHTS = linkedMapOf(
            "UNCOMMON"  to 0.5875f,
            "RARE"      to 0.25f,
            "EPIC"      to 0.125f,
            "LEGENDARY" to 0.0375f,
        )
    }
}
