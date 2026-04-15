package com.example.kartonki.ui.screen.deckbuilder

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.entity.DeckCardCrossRef
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.CollectionRepository
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.domain.model.DeckLevel
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RaritySlot(val rarity: Rarity, val used: Int, val limit: Int) {
    val isFull: Boolean get() = used >= limit
    /** True when the level was changed and this rarity now exceeds its new limit. */
    val isOverLimit: Boolean get() = used > limit
}

data class DeckBuilderUiState(
    val isLoading: Boolean = true,
    val deckName: String = "",
    val deckLevel: Int = 1,
    val deckCards: List<Word> = emptyList(),
    val availableCards: List<Word> = emptyList(),
    val allOwnedCards: List<Word> = emptyList(),
    val selectedTab: Int = 0,
    val rarityFilter: Set<Rarity> = emptySet(),
) {
    val totalCards: Int get() = deckCards.size
    val isFull: Boolean get() = totalCards >= DECK_MAX_SIZE

    val deckCardIds: Set<Long> get() = deckCards.map { it.id }.toSet()

    val raritySlots: List<RaritySlot> get() {
        val limits = DeckLevel.limitsFor(deckLevel)
        return Rarity.entries.map { rarity ->
            RaritySlot(rarity, deckCards.count { it.rarity == rarity }, limits.limitFor(rarity))
        }
    }

    val isValid: Boolean get() =
        totalCards == DECK_MAX_SIZE && raritySlots.none { it.isOverLimit }

    val filteredDeckCards: List<Word> get() =
        if (rarityFilter.isEmpty()) deckCards else deckCards.filter { it.rarity in rarityFilter }

    val filteredAllCards: List<Word> get() =
        if (rarityFilter.isEmpty()) allOwnedCards else allOwnedCards.filter { it.rarity in rarityFilter }

    fun canAdd(word: Word): Boolean {
        if (isFull) return false
        val used = deckCards.count { it.rarity == word.rarity }
        return used < DeckLevel.limitsFor(deckLevel).limitFor(word.rarity)
    }

    companion object {
        const val DECK_MAX_SIZE = 21
    }
}

@HiltViewModel
class DeckBuilderViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val collectionRepository: CollectionRepository,
    private val deckDao: DeckDao,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    // 0 means "use default deck"
    private val deckIdArg: Long = savedStateHandle.get<Long>(Route.DeckBuilder.ARG_DECK_ID) ?: 0L
    private var currentDeckId: Long = 0L

    private val _uiState = MutableStateFlow(DeckBuilderUiState())
    val uiState: StateFlow<DeckBuilderUiState> = _uiState.asStateFlow()

    init {
        loadDeck()
    }

    fun selectTab(index: Int) = _uiState.update { it.copy(selectedTab = index) }

    fun changeLevel(newLevel: Int) {
        viewModelScope.launch {
            val deck = deckDao.getDeckById(currentDeckId) ?: return@launch
            deckDao.insertDeck(deck.copy(level = newLevel))
            val limits = DeckLevel.limitsFor(newLevel)
            val newFilter = Rarity.entries.filter { limits.limitFor(it) > 0 }.toSet()
            _uiState.update { it.copy(deckLevel = newLevel, rarityFilter = newFilter) }
        }
    }

    fun toggleRarityFilter(rarity: Rarity) = _uiState.update {
        val newFilter = if (rarity in it.rarityFilter) it.rarityFilter - rarity
                        else it.rarityFilter + rarity
        it.copy(rarityFilter = newFilter)
    }

    fun addCard(word: Word) {
        val state = _uiState.value
        if (!state.canAdd(word)) return
        viewModelScope.launch {
            deckDao.addCardToDeck(DeckCardCrossRef(currentDeckId, word.id))
            refreshCards()
        }
    }

    fun removeCard(word: Word) {
        viewModelScope.launch {
            deckDao.removeCardFromDeck(DeckCardCrossRef(currentDeckId, word.id))
            refreshCards()
        }
    }

    private fun loadDeck() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            collectionRepository.ensureStarterPack()
            val deck = if (deckIdArg > 0L) deckDao.getDeckById(deckIdArg)
                       else deckDao.getFirstDeck()
            currentDeckId = deck?.id ?: 0L
            val deckName = deck?.name ?: "Моя колода"
            val deckLevel = deck?.level ?: 1
            val limits = DeckLevel.limitsFor(deckLevel)
            val initialFilter = Rarity.entries.filter { limits.limitFor(it) > 0 }.toSet()
            _uiState.update { it.copy(deckName = deckName, deckLevel = deckLevel, rarityFilter = initialFilter) }
            refreshCards(deckName, deckLevel)
        }
    }

    private suspend fun refreshCards(deckName: String = _uiState.value.deckName, deckLevel: Int = _uiState.value.deckLevel) {
        val deckWordIds = deckDao.getWordIdsForDeck(currentDeckId).toSet()
        val languagePair = prefs.getLanguagePair()
        val allOwned = collectionRepository.getOwnedWords(languagePair = languagePair).sortedByRarityDesc()
        val inDeck = allOwned.filter { it.id in deckWordIds }
        val available = allOwned.filter { it.id !in deckWordIds }
        _uiState.update {
            it.copy(
                isLoading = false,
                deckName = deckName,
                deckLevel = deckLevel,
                deckCards = inDeck,
                availableCards = available,
                allOwnedCards = allOwned,
                // Open on "All cards" tab when deck is empty (newly created)
                selectedTab = if (inDeck.isEmpty()) 1 else it.selectedTab,
            )
        }
    }

    private fun List<Word>.sortedByRarityDesc(): List<Word> =
        sortedWith(compareByDescending<Word> { it.rarity.ordinal }.thenBy { it.original })
}
