package com.example.kartonki.ui.screen.study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.ProgressRepository
import com.example.kartonki.data.repository.StatsRepository
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
    val isFavorite: Boolean = false,
)

data class StudyListUiState(
    val isLoading: Boolean = true,
    val sets: List<WordSetUiItem> = emptyList(),
    val activeFilters: Set<Rarity> = emptySet(),
    val problemWordCount: Int = 0,
    val showProblemChipHint: Boolean = false,
    /**
     * Increments each time the user actively toggles a filter chip or switches tabs.
     * Used as a LaunchedEffect key so the list scrolls to top only on an explicit change.
     */
    val filterVersion: Int = 0,
    /** 0 = all sets, 1 = favourites only. */
    val selectedTab: Int = 0,
) {
    val favoriteCount: Int get() = sets.count { it.isFavorite }

    val filteredSets: List<WordSetUiItem> get() {
        val base = if (selectedTab == 1) sets.filter { it.isFavorite } else sets
        return if (activeFilters.isEmpty()) base else base.filter { it.rarity in activeFilters }
    }
}

@HiltViewModel
class StudyViewModel @Inject constructor(
    private val wordSetRepository: WordSetRepository,
    private val progressRepository: ProgressRepository,
    private val statsRepository: StatsRepository,
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

    fun selectTab(index: Int) {
        _uiState.update { it.copy(selectedTab = index, filterVersion = it.filterVersion + 1) }
    }

    fun toggleFavorite(setId: Long) {
        // Optimistic update: flip the star in UI immediately, no reload needed.
        _uiState.update { state ->
            state.copy(
                sets = state.sets.map {
                    if (it.id == setId) it.copy(isFavorite = !it.isFavorite) else it
                }
            )
        }
        // Persist to DB in background.
        viewModelScope.launch {
            wordSetRepository.toggleFavorite(setId)
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

    fun dismissProblemChipHint() {
        prefs.setProblemChipHintShown()
        _uiState.update { it.copy(showProblemChipHint = false) }
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
                isFavorite = set.isFavorite,
            )
        }
        // Load problem word count and determine whether to show the first-time hint
        val problemEnabled = prefs.problemWordsEnabled.first()
        val problemCount = if (problemEnabled) {
            val source = prefs.problemWordsSource.first()
            val minEnc = prefs.problemWordsMinEncounters.first()
            statsRepository.getProblemWordCount(source, minEnc)
        } else 0
        val wasHintShown = prefs.isProblemChipHintShown()
        val showHint = problemCount > 0 && !wasHintShown
        _uiState.update {
            it.copy(
                isLoading = false,
                sets = items,
                problemWordCount = problemCount,
                showProblemChipHint = showHint,
            )
        }
    }
}
