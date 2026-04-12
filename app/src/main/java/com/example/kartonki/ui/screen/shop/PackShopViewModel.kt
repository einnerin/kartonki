package com.example.kartonki.ui.screen.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.repository.PackRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class PackShopUiState(
    val activityCount: Int = 0,
    val freePackCount: Int = 0,
    val selectedLanguage: String = "en",
)

@HiltViewModel
class PackShopViewModel @Inject constructor(
    private val packRepository: PackRepository,
) : ViewModel() {

    val uiState: StateFlow<PackShopUiState> = combine(
        packRepository.activityCount,
        packRepository.freePackCount,
    ) { activity, packs ->
        PackShopUiState(activityCount = activity, freePackCount = packs)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, PackShopUiState())
}
