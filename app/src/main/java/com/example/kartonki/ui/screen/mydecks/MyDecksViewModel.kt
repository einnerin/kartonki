package com.example.kartonki.ui.screen.mydecks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.db.entity.DeckEntity
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.CollectionRepository
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
) : ViewModel() {

    private val _uiState = MutableStateFlow(MyDecksUiState())
    val uiState: StateFlow<MyDecksUiState> = _uiState.asStateFlow()

    init {
        loadDecks()
    }

    fun refresh() {
        loadDecks()
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
        }
    }

    fun onNavigationConsumed() = _uiState.update { it.copy(navigateToDeckId = null) }

    fun deleteDeck(deck: DeckSummary) {
        viewModelScope.launch {
            deckDao.clearDeck(deck.id)
            deckDao.deleteDeck(DeckEntity(id = deck.id, name = deck.name))
            loadDecks()
        }
    }

    private fun loadDecks() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            collectionRepository.ensureStarterPack()
            val languagePair = prefs.getLanguagePair()
            val entities = deckDao.getDecksOnce(languagePair)
            val summaries = entities.map { entity ->
                DeckSummary(
                    id = entity.id,
                    name = entity.name,
                    cardCount = deckDao.getOwnedCardCountForDeck(entity.id),
                    level = entity.level,
                )
            }
            _uiState.update { it.copy(isLoading = false, decks = summaries) }
        }
    }
}
