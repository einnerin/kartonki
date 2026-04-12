package com.example.kartonki.ui.screen.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.repository.PackRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class PackShopUiState(
    val activityCount: Int = 0,
    val freePackCount: Int = 0,
    val languagePair: String = "en-ru",
    val selectedPackCount: Int = 1,
) {
    val canOpen: Boolean get() = freePackCount >= selectedPackCount
}

val PACK_COUNT_OPTIONS = listOf(1, 5, 10, 50)

@HiltViewModel
class PackShopViewModel @Inject constructor(
    private val packRepository: PackRepository,
) : ViewModel() {

    private val _selectedPackCount = MutableStateFlow(1)

    val uiState: StateFlow<PackShopUiState> = combine(
        packRepository.activityCount,
        packRepository.freePackCount,
        packRepository.languagePair,
        _selectedPackCount,
    ) { activity, packs, langPair, count ->
        PackShopUiState(
            activityCount = activity,
            freePackCount = packs,
            languagePair = langPair,
            selectedPackCount = count,
        )
    }.stateIn(viewModelScope, SharingStarted.Eagerly, PackShopUiState())

    fun setPackCount(count: Int) {
        _selectedPackCount.update { count }
    }
}
