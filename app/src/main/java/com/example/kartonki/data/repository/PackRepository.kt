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
        val excluded = AchievementCards.ALL_EXCLUSIVE.toList()

        val result = mutableListOf<WordEntity>()
        val taken = mutableSetOf<Long>()

        suspend fun pick(weights: Map<String, Float>) {
            val roll = Random.Default.nextFloat()
            var cumulative = 0f
            // Try the rolled rarity, then walk the rest as fallbacks (avoids
            // empty-bucket misses on languages where a rarity is sparse).
            val rarities = weights.keys.toMutableList()
            val rolled = run {
                for (r in weights.keys) {
                    cumulative += weights.getValue(r)
                    if (roll <= cumulative) return@run r
                }
                weights.keys.last()
            }
            rarities.remove(rolled)
            rarities.add(0, rolled)
            for (r in rarities) {
                // Pull a couple of candidates so we can skip ones already taken
                // without a second round-trip.
                val pool = wordDao.getRandomByLangAndRarity(langPair, r, excluded, 3)
                val pick = pool.firstOrNull { it.id !in taken } ?: continue
                result += pick
                taken += pick.id
                return
            }
        }

        pick(GUARANTEED_WEIGHTS)
        repeat(4) { pick(NORMAL_WEIGHTS) }

        // Fill to 5 if any rarity bucket was empty across all fallbacks.
        if (result.size < 5) {
            val pool = wordDao.getAllWordsByLanguage(langPair)
                .asSequence()
                .filter { it.id !in taken && it.original !in AchievementCards.ALL_EXCLUSIVE }
                .shuffled()
                .take(5 - result.size)
                .toList()
            result.addAll(pool)
        }

        val words = result.take(5).map { it.toDomain() }
        collectionDao.insertAll(words.map { CollectionEntity(wordId = it.id) })
        return words
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
