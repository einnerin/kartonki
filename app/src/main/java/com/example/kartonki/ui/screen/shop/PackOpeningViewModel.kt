package com.example.kartonki.ui.screen.shop

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.repository.PackRepository
import com.example.kartonki.domain.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PackOpeningUiState(
    val isLoading: Boolean = true,
    val cards: List<Word> = emptyList(),
    val revealedIndices: Set<Int> = emptySet(),
) {
    val allRevealed: Boolean get() = cards.isNotEmpty() && revealedIndices.size >= cards.size
    val revealedCount: Int get() = revealedIndices.size
}

@HiltViewModel
class PackOpeningViewModel @Inject constructor(
    private val packRepository: PackRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val packCount: Int = savedStateHandle.get<Int>("count") ?: 1

    private val _uiState = MutableStateFlow(PackOpeningUiState())
    val uiState: StateFlow<PackOpeningUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val cards = packRepository.consumeAndOpenPacks(packCount)
            _uiState.update { it.copy(isLoading = false, cards = cards) }
        }
    }

    fun revealCard(index: Int) {
        _uiState.update { it.copy(revealedIndices = it.revealedIndices + index) }
    }

    fun revealAll() {
        _uiState.update { state ->
            state.copy(revealedIndices = state.cards.indices.toSet())
        }
    }
}
