package com.example.kartonki.ui.screen.mydecks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.db.entity.DeckEntity
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.CollectionRepository
import com.example.kartonki.domain.model.DeckLevel
import com.example.kartonki.domain.model.Rarity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DeckSummary(
    val id: Long,
    val name: String,
    val cardCount: Int,
    val level: Int = 1,
    val isValid: Boolean = true,
)

data class MyDecksUiState(
    val isLoading: Boolean = true,
    val decks: List<DeckSummary> = emptyList(),
    val showCreateDialog: Boolean = false,
    val navigateToDeckId: Long? = null,
)

@HiltViewModel
class MyDecksViewModel @Inject constructor(
    private val deckDao: DeckDao,
    private val collectionRepository: CollectionRepository,
    private val prefs: UserPreferencesRepository,
    private val analytics: com.example.kartonki.analytics.AnalyticsManager,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MyDecksUiState())
    val uiState: StateFlow<MyDecksUiState> = _uiState.asStateFlow()

    init {
        loadDecks(showLoadingSpinner = true)
    }

    fun refresh() {
        loadDecks(showLoadingSpinner = false)
    }

    fun showCreateDialog() = _uiState.update { it.copy(showCreateDialog = true) }
    fun dismissCreateDialog() = _uiState.update { it.copy(showCreateDialog = false) }

    fun createDeck(name: String, level: Int = 1) {
        val trimmed = name.trim()
        if (trimmed.isEmpty()) return
        viewModelScope.launch {
            val languagePair = prefs.getLanguagePair()
            val newId = deckDao.insertDeck(DeckEntity(name = trimmed, level = level, languagePair = languagePair))
            _uiState.update { it.copy(showCreateDialog = false, navigateToDeckId = newId) }
            // Empty deck just created — partial deck_built event without rarity info.
            // DeckBuilder will emit deck_edited as user adds cards.
            analytics.log(
                com.example.kartonki.analytics.AnalyticsEvent.DeckBuilt(
                    size = 0,
                    avgRarity = "EMPTY",
                    commonCount = 0,
                    uncommonCount = 0,
                    rareCount = 0,
                    epicCount = 0,
                    legendaryCount = 0,
                    languagePair = languagePair,
                    buildDurationSec = 0L,
                    cardsConsidered = 0,
                )
            )
        }
    }

    fun onNavigationConsumed() = _uiState.update { it.copy(navigateToDeckId = null) }

    fun deleteDeck(deck: DeckSummary) {
        viewModelScope.launch {
            deckDao.clearDeck(deck.id)
            deckDao.deleteDeck(DeckEntity(id = deck.id, name = deck.name))
            loadDecks()
            analytics.log(
                com.example.kartonki.analytics.AnalyticsEvent.DeckDeleted(
                    ageDays = 0,  // age tracking — Фаза 4 (нужно поле created_at в DeckEntity)
                    wasEverUsed = deck.cardCount > 0,
                )
            )
        }
    }

    private fun loadDecks(showLoadingSpinner: Boolean = false) {
        viewModelScope.launch {
            // Show spinner only on first load (list is empty). On refresh — update silently
            // so the list stays visible and scroll position is preserved.
            if (showLoadingSpinner) _uiState.update { it.copy(isLoading = true) }
            collectionRepository.ensureStarterPack()
            val languagePair = prefs.getLanguagePair()
            val entities = deckDao.getDecksOnce(languagePair)
            val summaries = entities.map { entity ->
                val cardCount = deckDao.getCardCountForDeck(entity.id)
                val rarityCounts = deckDao.getRarityCountsForDeck(entity.id)
                    .associate { Rarity.valueOf(it.rarity) to it.cnt }
                DeckSummary(
                    id = entity.id,
                    name = entity.name,
                    cardCount = cardCount,
                    level = entity.level,
                    isValid = DeckLevel.isDeckValid(entity.level, cardCount, rarityCounts),
                )
            }
            _uiState.update { it.copy(isLoading = false, decks = summaries) }
        }
    }
}
