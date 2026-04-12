package com.example.kartonki.ui.screen.stats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.repository.StatsRepository
import com.example.kartonki.domain.model.PlayerStats
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PlayerStatsUiState(
    val isLoading: Boolean = true,
    val stats: PlayerStats = PlayerStats(),
)

@HiltViewModel
class PlayerStatsViewModel @Inject constructor(
    private val statsRepository: StatsRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(PlayerStatsUiState())
    val uiState: StateFlow<PlayerStatsUiState> = _uiState.asStateFlow()

    init { load() }

    private fun load() = viewModelScope.launch {
        val stats = statsRepository.getPlayerStats()
        _uiState.update { it.copy(isLoading = false, stats = stats) }
    }
}
