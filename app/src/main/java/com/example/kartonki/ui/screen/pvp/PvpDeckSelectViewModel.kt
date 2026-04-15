package com.example.kartonki.ui.screen.pvp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.dao.DeckDao
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

data class PvpDeckOption(
    val id: Long,
    val name: String,
    val cardCount: Int,
    val level: Int = 1,
    val isValid: Boolean = true,
)

data class PvpDeckSelectUiState(
    val isLoading: Boolean = true,
    val decks: List<PvpDeckOption> = emptyList(),
    val player1Name: String = "Игрок 1",
    val player2Name: String = "Игрок 2",
    val selectedDeck1: PvpDeckOption? = null,
    val selectedDeck2: PvpDeckOption? = null,
) {
    val levelsMatch: Boolean get() =
        selectedDeck1 == null || selectedDeck2 == null ||
        selectedDeck1.level == selectedDeck2.level

    val canStart: Boolean get() =
        player1Name.isNotBlank() &&
        player2Name.isNotBlank() &&
        selectedDeck1 != null && selectedDeck1.isValid &&
        selectedDeck2 != null && selectedDeck2.isValid &&
        levelsMatch
}

@HiltViewModel
class PvpDeckSelectViewModel @Inject constructor(
    private val deckDao: DeckDao,
    private val collectionRepository: CollectionRepository,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(PvpDeckSelectUiState())
    val uiState: StateFlow<PvpDeckSelectUiState> = _uiState.asStateFlow()

    init { loadDecks() }

    fun setPlayer1Name(name: String) = _uiState.update { it.copy(player1Name = name) }
    fun setPlayer2Name(name: String) = _uiState.update { it.copy(player2Name = name) }
    fun selectDeck1(deck: PvpDeckOption) = _uiState.update { it.copy(selectedDeck1 = deck) }
    fun selectDeck2(deck: PvpDeckOption) = _uiState.update { it.copy(selectedDeck2 = deck) }

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
            val default = options.firstOrNull()
            _uiState.update {
                it.copy(
                    isLoading = false,
                    decks = options,
                    selectedDeck1 = default,
                    selectedDeck2 = default,
                )
            }
        }
    }
}
