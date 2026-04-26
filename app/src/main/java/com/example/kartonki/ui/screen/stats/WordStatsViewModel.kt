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

    private var rawWordStats: List<WordStat> = emptyList()

    init { load() }

    fun onSortChange(sort: WordStatSort) {
        _uiState.update { state ->
            state.copy(sortBy = sort, words = applyFilterAndSort(state.rarityFilter, sort))
        }
    }

    fun toggleRarityFilter(rarity: Rarity) {
        _uiState.update { state ->
            val newFilter = if (rarity in state.rarityFilter) state.rarityFilter - rarity
                            else state.rarityFilter + rarity
            state.copy(rarityFilter = newFilter, words = applyFilterAndSort(newFilter, state.sortBy))
        }
    }

    private fun applyFilterAndSort(filter: Set<Rarity>, sort: WordStatSort): List<WordStat> {
        val filtered = if (filter.isEmpty()) rawWordStats else rawWordStats.filter { it.rarity in filter }
        return when (sort) {
            WordStatSort.MOST_ERRORS      -> filtered.sortedByDescending { it.errorRate }
            WordStatSort.EASIEST          -> filtered.filter { it.encounters > 0 }.sortedBy { it.errorRate }
            WordStatSort.MOST_ENCOUNTERS  -> filtered.sortedByDescending { it.encounters }
            WordStatSort.RECENTLY_STUDIED -> filtered.sortedByDescending { it.nextReviewAt }
        }
    }

    private fun load() = viewModelScope.launch {
        _uiState.update { it.copy(isLoading = true) }
        rawWordStats = statsRepository.getWordStats()
        val source = prefs.problemWordsSource.first()
        val minEnc = prefs.problemWordsMinEncounters.first()
        val dismissed = prefs.getDismissedProblemWordIds()
        // Must use the same minEncounters as ProblemWordsListViewModel — otherwise
        // the count shown here disagrees with what the list screen actually displays.
        val problemCount = statsRepository.getProblemWordCount(source, minEnc, dismissedIds = dismissed)
        _uiState.update { state ->
            state.copy(
                isLoading = false,
                words = applyFilterAndSort(state.rarityFilter, state.sortBy),
                problemWordCount = problemCount,
            )
        }
    }
}
