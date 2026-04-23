package com.example.kartonki.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.StatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val problemWordCount: Int = 0,
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val statsRepository: StatsRepository,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun refresh() {
        viewModelScope.launch {
            val enabled = prefs.problemWordsEnabled.first()
            if (!enabled) {
                _uiState.value = HomeUiState(problemWordCount = 0)
                return@launch
            }
            val source = prefs.problemWordsSource.first()
            val minEnc = prefs.problemWordsMinEncounters.first()
            val dismissed = prefs.getDismissedProblemWordIds()
            val count = statsRepository.getProblemWordCount(source, minEnc, dismissed)
            _uiState.value = HomeUiState(problemWordCount = count)
        }
    }
}
