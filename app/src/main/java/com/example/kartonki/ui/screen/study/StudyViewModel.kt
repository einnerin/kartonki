package com.example.kartonki.ui.screen.study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.ProgressRepository
import com.example.kartonki.data.repository.WordSetRepository
import com.example.kartonki.domain.model.Rarity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class WordSetUiItem(
    val id: Long,
    val name: String,
    val description: String,
    val totalWords: Int,
    val introducedWords: Int,
    val rarity: Rarity = Rarity.COMMON,
)

data class StudyListUiState(
    val isLoading: Boolean = true,
    val sets: List<WordSetUiItem> = emptyList(),
    val activeFilters: Set<Rarity> = emptySet(),
    /**
     * Increments each time the user actively toggles a filter chip.
     * Used as a LaunchedEffect key so the list scrolls to top only on an explicit
     * filter change — not on initial composition or when returning from a session.
     */
    val filterVersion: Int = 0,
) {
    val filteredSets: List<WordSetUiItem> get() =
        if (activeFilters.isEmpty()) sets else sets.filter { it.rarity in activeFilters }
}

@HiltViewModel
class StudyViewModel @Inject constructor(
    private val wordSetRepository: WordSetRepository,
    private val progressRepository: ProgressRepository,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(StudyListUiState())
    val uiState: StateFlow<StudyListUiState> = _uiState.asStateFlow()

    /** Scroll position saved so it survives navigation and silent refreshes. */
    var savedScrollIndex: Int = 0
        private set
    var savedScrollOffset: Int = 0
        private set

    fun saveScrollPosition(index: Int, offset: Int) {
        savedScrollIndex = index
        savedScrollOffset = offset
    }

    init {
        viewModelScope.launch {
            prefs.languagePair.collect { pair ->
                loadSets(pair, showLoading = true)
            }
        }
    }

    fun toggleFilter(rarity: Rarity) {
        _uiState.update { state ->
            val updated = if (rarity in state.activeFilters)
                state.activeFilters - rarity
            else
                state.activeFilters + rarity
            state.copy(activeFilters = updated, filterVersion = state.filterVersion + 1)
        }
    }

    /** Refreshes data silently — no loading spinner so the scroll position is preserved. */
    fun refresh() {
        viewModelScope.launch {
            loadSets(prefs.languagePair.first(), showLoading = false)
        }
    }

    private suspend fun loadSets(languagePair: String, showLoading: Boolean) {
        if (showLoading) _uiState.update { it.copy(isLoading = true) }
        wordSetRepository.ensureSeeded()
        val sets = wordSetRepository.getSetsByLanguage(languagePair)
        val items = sets.map { set ->
            val total = wordSetRepository.getWordCountInSet(set.id)
            val progress = progressRepository.getProgressForSet(set.id)
            val rarity = wordSetRepository.getRarityForSet(set.id)
            WordSetUiItem(
                id = set.id,
                name = set.name,
                description = set.description,
                totalWords = total,
                introducedWords = progress.count { it.level > 0 },
                rarity = rarity,
            )
        }
        _uiState.update { it.copy(isLoading = false, sets = items) }
    }
}
