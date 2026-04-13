package com.example.kartonki.ui.screen.pvp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.remote.FirebaseAuthManager
import com.example.kartonki.data.remote.MatchmakingRepository
import com.example.kartonki.data.remote.MatchmakingResult
import com.example.kartonki.data.remote.model.MatchmakingEntry
import com.example.kartonki.data.repository.CollectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
) : ViewModel() {

    private val _uiState = MutableStateFlow(OnlineMatchmakingUiState())
    val uiState: StateFlow<OnlineMatchmakingUiState> = _uiState.asStateFlow()

    private var searchJob: Job? = null

    init { loadDecks() }

    private fun loadDecks() {
        viewModelScope.launch {
            collectionRepository.ensureStarterPack()
            val entities = deckDao.getDecksOnce()
            val options = entities.map {
                PvpDeckOption(it.id, it.name, deckDao.getCardCountForDeck(it.id), it.level)
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
        val user = authManager.currentUser.value ?: return

        searchJob = viewModelScope.launch {
            _uiState.update { it.copy(phase = OnlineMatchmakingUiState.Phase.Searching) }

            // Load card IDs from deck
            val cardIds = deckDao.getWordIdsForDeck(deck.id)

            val entry = MatchmakingEntry(
                uid = user.uid,
                playerName = user.displayName,
                deckId = deck.id,
                deckName = deck.name,
                deckLevel = deck.level,
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
                    }
                    is MatchmakingResult.Error -> {
                        _uiState.update {
                            it.copy(
                                phase = OnlineMatchmakingUiState.Phase.DeckSelect,
                                error = result.message,
                            )
                        }
                    }
                }
            }
        }
    }

    fun cancelSearch() {
        val user = authManager.currentUser.value ?: return
        searchJob?.cancel()
        viewModelScope.launch {
            matchmakingRepository.leaveQueue(user.uid)
        }
        _uiState.update { it.copy(phase = OnlineMatchmakingUiState.Phase.DeckSelect) }
    }

    fun dismissError() = _uiState.update { it.copy(error = null) }

    override fun onCleared() {
        super.onCleared()
        cancelSearch()
    }
}
