package com.example.kartonki.ui.screen.study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.StatsRepository
import com.example.kartonki.domain.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProblemWordsListUiState(
    val isLoading: Boolean = true,
    val words: List<Word> = emptyList(),
    /** Word IDs that the user has checked for this session (all checked by default). */
    val selectedIds: Set<Long> = emptySet(),
    /** Total number of words the user has dismissed and could restore. */
    val dismissedCount: Int = 0,
) {
    val selectedCount: Int get() = selectedIds.size
}

@HiltViewModel
class ProblemWordsListViewModel @Inject constructor(
    private val statsRepository: StatsRepository,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProblemWordsListUiState())
    val uiState: StateFlow<ProblemWordsListUiState> = _uiState.asStateFlow()

    init {
        reload()
    }

    /** Re-reads problem words from stats + prefs. Call after a dismiss action. */
    fun reload() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val source    = prefs.problemWordsSource.first()
            val minEnc    = prefs.problemWordsMinEncounters.first()
            val dismissed = prefs.getDismissedProblemWordIds()
            val words     = statsRepository.getProblemWords(
                source, minEnc, limit = 200, dismissedIds = dismissed,
            )
            val selectedIds = words.map { it.id }.toSet()
            _uiState.update {
                it.copy(
                    isLoading = false,
                    words = words,
                    selectedIds = selectedIds,
                    dismissedCount = dismissed.size,
                )
            }
        }
    }

    /** Permanently remove a word from the problem-words list (trash-button action). */
    fun dismissWord(wordId: Long) {
        prefs.addDismissedProblemWordId(wordId)
        reload()
    }

    fun toggleWord(wordId: Long) {
        _uiState.update { state ->
            val updated = if (wordId in state.selectedIds)
                state.selectedIds - wordId
            else
                state.selectedIds + wordId
            state.copy(selectedIds = updated)
        }
    }

    fun selectAll() {
        _uiState.update { it.copy(selectedIds = it.words.map { w -> w.id }.toSet()) }
    }

    /**
     * Saves the excluded word IDs (words NOT selected) to prefs so that
     * [ProblemWordsSessionViewModel] can filter them out on start.
     */
    fun commitSelectionAndStartSession() {
        val state = _uiState.value
        val excludedIds = state.words.map { it.id }.toSet() - state.selectedIds
        prefs.setSessionExcludedWordIds(excludedIds)
    }
}
