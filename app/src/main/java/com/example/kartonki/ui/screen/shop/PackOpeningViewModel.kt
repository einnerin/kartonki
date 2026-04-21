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
    private val analytics: com.example.kartonki.analytics.AnalyticsManager,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val packCount: Int = savedStateHandle.get<Int>("count") ?: 1

    private val _uiState = MutableStateFlow(PackOpeningUiState())
    val uiState: StateFlow<PackOpeningUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val cards = packRepository.consumeAndOpenPacks(packCount)
            _uiState.update { it.copy(isLoading = false, cards = cards) }
            // pack_opened — по одному event на каждый pack (можно хорошо раскрыть rarity-распределение)
            val highest = cards.maxByOrNull { com.example.kartonki.domain.model.Rarity.valueOf(it.rarity.name).points }?.rarity?.name ?: "COMMON"
            repeat(packCount) {
                analytics.log(
                    com.example.kartonki.analytics.AnalyticsEvent.PackOpened(
                        packType = "standard",
                        newCardsCount = cards.size / packCount.coerceAtLeast(1),
                        duplicatesCount = 0,  // duplicate detection — Фаза 5 если понадобится
                        highestRarityObtained = highest,
                        packSource = "activity_reward",
                    )
                )
            }
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
