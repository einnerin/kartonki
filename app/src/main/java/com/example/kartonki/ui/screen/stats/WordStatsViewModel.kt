package com.example.kartonki.ui.screen.stats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.StatsRepository
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.WordStat
import com.example.kartonki.domain.model.WordStatSort
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class WordStatsUiState(
    val isLoading: Boolean = true,
    val words: List<WordStat> = emptyList(),
    val sortBy: WordStatSort = WordStatSort.MOST_ERRORS,
    val rarityFilter: Rarity? = null,
    val problemWordCount: Int = 0,
)

@HiltViewModel
class WordStatsViewModel @Inject constructor(
    private val statsRepository: StatsRepository,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(WordStatsUiState())
    val uiState: StateFlow<WordStatsUiState> = _uiState.asStateFlow()

    init { load() }

    fun onSortChange(sort: WordStatSort) {
        _uiState.update { it.copy(sortBy = sort) }
        load()
    }

    fun onRarityFilterChange(rarity: Rarity?) {
        _uiState.update { it.copy(rarityFilter = rarity) }
        load()
    }

    private fun load() = viewModelScope.launch {
        _uiState.update { it.copy(isLoading = true) }
        val state = _uiState.value
        val words = statsRepository.getWordStats(state.sortBy, state.rarityFilter)
        val source = prefs.problemWordsSource.first()
        val problemCount = statsRepository.getProblemWordCount(source)
        _uiState.update { it.copy(isLoading = false, words = words, problemWordCount = problemCount) }
    }
}
