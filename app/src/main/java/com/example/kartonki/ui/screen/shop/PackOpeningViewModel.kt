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
    val compensationTokens: Int = 0,
    val purchaseFailed: Boolean = false,
) {
    val allRevealed: Boolean get() = cards.isNotEmpty() && revealedIndices.size >= cards.size
    val revealedCount: Int get() = revealedIndices.size
}

@HiltViewModel
class PackOpeningViewModel @Inject constructor(
    private val packRepository: PackRepository,
    private val analytics: com.example.kartonki.analytics.AnalyticsManager,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val packCount: Int = savedStateHandle.get<Int>("count") ?: 1

    private val _uiState = MutableStateFlow(PackOpeningUiState())
    val uiState: StateFlow<PackOpeningUiState> = _uiState.asStateFlow()

    init {
        // Idempotency guard against process death. SavedStateHandle survives process
        // recreation, the ViewModel does not — so without this, a kill while the opening
        // screen is in the background re-runs init on restore and charges the user a
        // SECOND time (and loses the first pack's cards). We mark the intent BEFORE the
        // purchase: replaying can at worst skip a purchase, never double-charge. The cards
        // are already persisted to the collection by PackRepository, so finishing the
        // screen (purchaseFailed triggers navigation back) loses only the reveal animation.
        if (savedStateHandle.get<Boolean>(KEY_PURCHASE_STARTED) == true) {
            _uiState.update { it.copy(isLoading = false, purchaseFailed = true) }
        } else {
            savedStateHandle[KEY_PURCHASE_STARTED] = true
            openPacks()
        }
    }

    private fun openPacks() {
        viewModelScope.launch {
            val result = packRepository.purchasePacksWithTokens(packCount)
            if (result.cards.isEmpty()) {
                _uiState.update { it.copy(isLoading = false, purchaseFailed = true) }
                return@launch
            }
            _uiState.update {
                it.copy(
                    isLoading = false,
                    cards = result.cards,
                    compensationTokens = result.duplicateRewardTokens,
                )
            }
            // Per-pack analytics. Duplicate count is per-purchase total — we
            // keep highestRarity per-purchase too (good enough for cohort stats).
            val highest = result.cards
                .maxByOrNull { com.example.kartonki.domain.model.Rarity.valueOf(it.rarity.name).points }
                ?.rarity?.name ?: "COMMON"
            // Cards per pack always 5 by PackRepository contract.
            val cardsPerPack = (result.cards.size / packCount.coerceAtLeast(1))
            // Approximate duplicate count per pack — split evenly. Used for analytics only.
            val duplicatesTotal = if (result.duplicateRewardTokens > 0) {
                // Estimate from compensation table is noisy; just expose per-pack share.
                (result.duplicateRewardTokens / 10).coerceAtLeast(1)  // very rough; we mainly care it's > 0
            } else 0
            repeat(packCount) {
                analytics.log(
                    com.example.kartonki.analytics.AnalyticsEvent.PackOpened(
                        packType = "standard",
                        newCardsCount = cardsPerPack,
                        duplicatesCount = duplicatesTotal / packCount.coerceAtLeast(1),
                        highestRarityObtained = highest,
                        packSource = "tokens",
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

    private companion object {
        const val KEY_PURCHASE_STARTED = "pack_purchase_started"
    }
}
