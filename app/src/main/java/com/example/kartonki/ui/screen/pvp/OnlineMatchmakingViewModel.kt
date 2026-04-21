package com.example.kartonki.ui.screen.pvp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.remote.FirebaseAuthManager
import com.example.kartonki.data.remote.MatchmakingRepository
import com.example.kartonki.data.remote.MatchmakingResult
import com.example.kartonki.data.remote.model.MatchmakingEntry
import com.example.kartonki.data.repository.CollectionRepository
import com.example.kartonki.domain.model.DeckLevel
import com.example.kartonki.domain.model.Rarity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OnlineMatchmakingUiState(
    val isLoading: Boolean = true,
    val decks: List<PvpDeckOption> = emptyList(),
    val selectedDeck: PvpDeckOption? = null,
    val phase: Phase = Phase.DeckSelect,
    val error: String? = null,
) {
    sealed class Phase {
        object DeckSelect : Phase()
        object Searching : Phase()
        data class Found(val matchId: String, val myIndex: Int) : Phase()
    }
}

@HiltViewModel
class OnlineMatchmakingViewModel @Inject constructor(
    private val deckDao: DeckDao,
    private val collectionRepository: CollectionRepository,
    private val matchmakingRepository: MatchmakingRepository,
    private val authManager: FirebaseAuthManager,
    private val prefs: UserPreferencesRepository,
    private val analytics: com.example.kartonki.analytics.AnalyticsManager,
) : ViewModel() {

    private val _uiState = MutableStateFlow(OnlineMatchmakingUiState())
    val uiState: StateFlow<OnlineMatchmakingUiState> = _uiState.asStateFlow()

    private var searchJob: Job? = null
    private var searchStartedAtMs: Long = 0L
    private var searchOutcomeLogged = false

    init { loadDecks() }

    private fun loadDecks() {
        viewModelScope.launch {
            collectionRepository.ensureStarterPack()
            val languagePair = prefs.getLanguagePair()
            val entities = deckDao.getDecksOnce(languagePair)
            val options = entities.map {
                val cardCount = deckDao.getCardCountForDeck(it.id)
                val rarityCounts = deckDao.getRarityCountsForDeck(it.id)
                    .associate { row -> Rarity.valueOf(row.rarity) to row.cnt }
                PvpDeckOption(
                    id = it.id,
                    name = it.name,
                    cardCount = cardCount,
                    level = it.level,
                    isValid = DeckLevel.isDeckValid(it.level, cardCount, rarityCounts),
                )
            }
            _uiState.update {
                it.copy(
                    isLoading = false,
                    decks = options,
                    selectedDeck = options.firstOrNull(),
                )
            }
        }
    }

    fun selectDeck(deck: PvpDeckOption) = _uiState.update { it.copy(selectedDeck = deck) }

    fun startSearch() {
        val deck = _uiState.value.selectedDeck ?: return
        if (!deck.isValid) return
        val user = authManager.currentUser.value ?: return

        searchJob = viewModelScope.launch {
            _uiState.update { it.copy(phase = OnlineMatchmakingUiState.Phase.Searching) }
            searchStartedAtMs = System.currentTimeMillis()
            searchOutcomeLogged = false
            analytics.log(
                com.example.kartonki.analytics.AnalyticsEvent.PvpOnlineMatchmakingStarted(
                    deckLevel = deck.level,
                    deckSize = deck.cardCount,
                    deckAvgRarity = "UNKNOWN",  // computed in DeckBuilder; matchmaking VM doesn't have it
                )
            )

            // Load card IDs from deck
            val cardIds = deckDao.getWordIdsForDeck(deck.id)

            val languagePair = prefs.languagePair.first()

            val entry = MatchmakingEntry(
                uid = user.uid,
                playerName = user.displayName,
                deckId = deck.id,
                deckName = deck.name,
                deckLevel = deck.level,
                languagePair = languagePair,
                cardIds = cardIds,
                timestamp = System.currentTimeMillis(),
            )

            matchmakingRepository.findMatch(entry).collect { result ->
                when (result) {
                    is MatchmakingResult.Searching -> { /* already set */ }
                    is MatchmakingResult.Found -> {
                        _uiState.update {
                            it.copy(
                                phase = OnlineMatchmakingUiState.Phase.Found(
                                    result.matchId, result.myIndex
                                )
                            )
        }
                        logMatchmakingResult(com.example.kartonki.analytics.MatchmakingOutcome.FOUND)
                    }
                    is MatchmakingResult.Error -> {
                        _uiState.update {
                            it.copy(
                                phase = OnlineMatchmakingUiState.Phase.DeckSelect,
                                error = result.message,
                            )
                        }
                        logMatchmakingResult(com.example.kartonki.analytics.MatchmakingOutcome.ERROR)
                    }
                }
            }
        }
    }

    private fun logMatchmakingResult(outcome: com.example.kartonki.analytics.MatchmakingOutcome) {
        if (searchOutcomeLogged || searchStartedAtMs == 0L) return
        searchOutcomeLogged = true
        analytics.log(
            com.example.kartonki.analytics.AnalyticsEvent.PvpOnlineMatchmakingResult(
                outcome = outcome,
                durationSec = (System.currentTimeMillis() - searchStartedAtMs) / 1000,
            )
        )
    }

    fun cancelSearch() {
        val user = authManager.currentUser.value ?: return
        searchJob?.cancel()
        viewModelScope.launch {
            matchmakingRepository.leaveQueue(user.uid)
        }
        _uiState.update { it.copy(phase = OnlineMatchmakingUiState.Phase.DeckSelect) }
        logMatchmakingResult(com.example.kartonki.analytics.MatchmakingOutcome.CANCELLED)
    }

    fun dismissError() = _uiState.update { it.copy(error = null) }

    override fun onCleared() {
        super.onCleared()
        cancelSearch()
    }
}
