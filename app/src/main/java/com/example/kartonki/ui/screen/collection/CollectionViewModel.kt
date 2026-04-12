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
    val rarityFilter: Rarity? = null,
)

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val collectionRepository: CollectionRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CollectionUiState())
    val uiState: StateFlow<CollectionUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    fun setFilter(rarity: Rarity?) {
        _uiState.update { it.copy(rarityFilter = rarity) }
        load(rarity)
    }

    fun refresh() = load(_uiState.value.rarityFilter)

    private fun load(filter: Rarity? = null) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            collectionRepository.ensureStarterPack()
            val words = collectionRepository.getOwnedWords(filter)
            val total = collectionRepository.getTotalCount()
            _uiState.update {
                it.copy(isLoading = false, words = words, totalCount = total)
            }
        }
    }
}
