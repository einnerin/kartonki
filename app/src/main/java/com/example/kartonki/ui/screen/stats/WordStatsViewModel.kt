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
    val rarityFilter: Set<Rarity> = emptySet(),
    val problemWordCount: Int = 0,
)

@HiltViewModel
class WordStatsViewModel @Inject constructor(
    private val statsRepository: StatsRepository,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(WordStatsUiState())
    val uiState: StateFlow<WordStatsUiState> = _uiState.asStateFlow()

    private var allWordStats: List<WordStat> = emptyList()

    init { load() }

    fun onSortChange(sort: WordStatSort) {
        _uiState.update { it.copy(sortBy = sort) }
        load()
    }

    fun toggleRarityFilter(rarity: Rarity) {
        _uiState.update {
            val newFilter = if (rarity in it.rarityFilter) it.rarityFilter - rarity
                            else it.rarityFilter + rarity
            it.copy(rarityFilter = newFilter, words = applyFilter(newFilter))
        }
    }

    private fun applyFilter(filter: Set<Rarity>): List<WordStat> =
        if (filter.isEmpty()) allWordStats else allWordStats.filter { it.rarity in filter }

    private fun load() = viewModelScope.launch {
        _uiState.update { it.copy(isLoading = true) }
        val state = _uiState.value
        allWordStats = statsRepository.getWordStats(state.sortBy, null)
        val source = prefs.problemWordsSource.first()
        val problemCount = statsRepository.getProblemWordCount(source)
        _uiState.update {
            it.copy(
                isLoading = false,
                words = applyFilter(it.rarityFilter),
                problemWordCount = problemCount,
            )
        }
    }
}
