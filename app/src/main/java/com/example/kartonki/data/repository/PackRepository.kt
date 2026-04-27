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

/**
 * Result of opening one or more packs.
 *
 * @param cards every card pulled (5 × pack count). Already inserted into the
 *              user's collection.
 * @param duplicateRewardTokens total tokens awarded as compensation for cards
 *              the user already owned. The caller does NOT need to credit the
 *              user — it has already been added to their token balance.
 */
data class PackResult(
    val cards: List<Word>,
    val duplicateRewardTokens: Int,
)

@Singleton
class PackRepository @Inject constructor(
    private val wordDao: WordDao,
    private val collectionDao: CollectionDao,
    private val userPrefs: UserPreferencesRepository,
) {
    private val _pendingNewCards = MutableStateFlow<List<Word>>(emptyList())
    val pendingNewCards: StateFlow<List<Word>> = _pendingNewCards.asStateFlow()

    val activityCount: Flow<Int>      = userPrefs.activityCount
    val freePackCount: Flow<Int>      = userPrefs.freePackCount       // legacy, kept for compat (returns 0 after migration)
    val tokensBalance: Flow<Int>      = userPrefs.tokensBalance
    val dailyActivityCount: Flow<Int> = userPrefs.dailyActivityCount
    val languagePair: Flow<String>    = userPrefs.languagePair

    fun clearPendingNewCards() {
        _pendingNewCards.value = emptyList()
    }

    /**
     * Registers one completed activity. Counts toward the daily limit and grants
     * tokens every [UserPreferencesRepository.ACTIVITIES_PER_TOKEN_GRANT] activities.
     *
     * Activities beyond [UserPreferencesRepository.DAILY_ACTIVITY_LIMIT] in a single
     * day are silently ignored — the user has hit the daily token cap.
     */
    suspend fun onActivityCompleted() {
        val counted = userPrefs.registerDailyActivity()
        if (!counted) return  // daily cap reached

        val current = userPrefs.getActivityCount()
        val next = current + 1
        if (next >= UserPreferencesRepository.ACTIVITIES_PER_TOKEN_GRANT) {
            userPrefs.setActivityCount(0)
            userPrefs.addTokens(UserPreferencesRepository.TOKENS_PER_PACK)
        } else {
            userPrefs.setActivityCount(next)
        }
    }

    fun canAffordPacks(count: Int): Boolean {
        val cost = count * UserPreferencesRepository.TOKENS_PER_PACK
        return userPrefs.getTokensBalance() >= cost
    }

    /**
     * Spends [count] × [UserPreferencesRepository.TOKENS_PER_PACK] tokens and opens that many packs.
     * Returns empty result if the user can't afford.
     *
     * Cards already in the user's collection generate compensation tokens
     * (see [DUPLICATE_COMPENSATION]). The compensation is credited automatically
     * to the token balance and reflected in [PackResult.duplicateRewardTokens].
     */
    suspend fun purchasePacksWithTokens(count: Int): PackResult {
        if (count <= 0) return PackResult(emptyList(), 0)
        val cost = count * UserPreferencesRepository.TOKENS_PER_PACK
        val balance = userPrefs.getTokensBalance()
        if (balance < cost) return PackResult(emptyList(), 0)
        userPrefs.setTokensBalance(balance - cost)

        val ownedIds = collectionDao.getCollectedWordIds().toHashSet()
        val cards = mutableListOf<Word>()
        var compensation = 0
        repeat(count) {
            val pack = generatePackCards()
            for (w in pack) {
                if (w.id in ownedIds) {
                    compensation += DUPLICATE_COMPENSATION[w.rarity] ?: 0
                } else {
                    ownedIds += w.id  // a duplicate within the same multi-pack purchase still counts as already-owned
                }
                cards += w
            }
        }
        if (compensation > 0) {
            userPrefs.addTokens(compensation)
        }
        return PackResult(cards, compensation)
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

        /** Token compensation when a pulled card is already in the player's collection. */
        val DUPLICATE_COMPENSATION = mapOf(
            Rarity.COMMON    to 10,
            Rarity.UNCOMMON  to 20,
            Rarity.RARE      to 50,
            Rarity.EPIC      to 100,
            Rarity.LEGENDARY to 200,
        )
    }
}
