package com.example.kartonki.ui.screen.collection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.repository.CollectionRepository
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CollectionUiState(
    val isLoading: Boolean = true,
    val words: List<Word> = emptyList(),
    val totalCount: Int = 0,
    val rarityFilter: Set<Rarity> = emptySet(),
)

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val collectionRepository: CollectionRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CollectionUiState())
    val uiState: StateFlow<CollectionUiState> = _uiState.asStateFlow()

    private var allWords: List<Word> = emptyList()

    init {
        load()
    }

    fun toggleFilter(rarity: Rarity) {
        _uiState.update {
            val newFilter = if (rarity in it.rarityFilter) it.rarityFilter - rarity
                            else it.rarityFilter + rarity
            it.copy(rarityFilter = newFilter, words = applyFilter(newFilter))
        }
    }

    fun refresh() = load()

    private fun applyFilter(filter: Set<Rarity>): List<Word> =
        if (filter.isEmpty()) allWords else allWords.filter { it.rarity in filter }

    private fun load() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            collectionRepository.ensureStarterPack()
            allWords = collectionRepository.getOwnedWords()
            val total = collectionRepository.getTotalCount()
            _uiState.update {
                it.copy(isLoading = false, words = applyFilter(it.rarityFilter), totalCount = total)
            }
        }
    }
}
