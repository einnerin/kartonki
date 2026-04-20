package com.example.kartonki.ui.screen.study

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.WordLoader
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
    val topic: String = "",
    val level: Int = 0,
)

data class TopicGroup(
    val topic: String,
    val sets: List<WordSetUiItem>,
    val isExpanded: Boolean = true,
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
    val expandedTopics: Set<String> = emptySet(),
) {
    val favoriteCount: Int get() = sets.count { it.isFavorite }

    val filteredSets: List<WordSetUiItem> get() {
        val base = if (selectedTab == 1) sets.filter { it.isFavorite } else sets
        return if (activeFilters.isEmpty()) base else base.filter { it.rarity in activeFilters }
    }

    fun groupedSets(activeFilters: Set<Rarity>): List<TopicGroup> {
        val filtered = if (activeFilters.isEmpty()) sets else sets.filter { it.rarity in activeFilters }
        val (withTopic, noTopic) = filtered.partition { it.topic.isNotEmpty() }
        val groups = withTopic
            .groupBy { it.topic }
            .map { (topic, items) ->
                TopicGroup(
                    topic = topic,
                    sets = items.sortedWith(compareBy({ it.level }, { it.id })),
                    isExpanded = topic in expandedTopics,
                )
            }
            .sortedBy { it.topic }
        return if (noTopic.isEmpty()) groups
               else groups + listOf(TopicGroup(topic = "", sets = noTopic, isExpanded = "" in expandedTopics))
    }
}

@HiltViewModel
class StudyViewModel @Inject constructor(
    private val wordSetRepository: WordSetRepository,
    private val progressRepository: ProgressRepository,
    private val statsRepository: StatsRepository,
    private val prefs: UserPreferencesRepository,
    private val wordLoader: WordLoader,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(StudyListUiState())
    val uiState: StateFlow<StudyListUiState> = _uiState.asStateFlow()

    /** Scroll position persisted in SavedStateHandle so it survives navigation back. */
    val savedScrollIndex: Int get() = savedStateHandle["scrollIndex"] ?: 0
    val savedScrollOffset: Int get() = savedStateHandle["scrollOffset"] ?: 0

    fun saveScrollPosition(index: Int, offset: Int) {
        savedStateHandle["scrollIndex"] = index
        savedStateHandle["scrollOffset"] = offset
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
            val updated = if (rarity in state.activeFilters) emptySet() else setOf(rarity)
            state.copy(activeFilters = updated, filterVersion = state.filterVersion + 1)
        }
    }

    /** Refreshes data silently — no loading spinner so the scroll position is preserved. */
    fun refresh() {
        viewModelScope.launch {
            loadSets(prefs.languagePair.first(), showLoading = false)
        }
    }

    fun toggleTopicExpanded(topic: String) {
        _uiState.update { state ->
            val updated = if (topic in state.expandedTopics)
                state.expandedTopics - topic
            else
                state.expandedTopics + topic
            state.copy(expandedTopics = updated)
        }
    }

    fun dismissProblemChipHint() {
        prefs.setProblemChipHintShown()
        _uiState.update { it.copy(showProblemChipHint = false) }
    }

    private suspend fun loadSets(languagePair: String, showLoading: Boolean) {
        if (showLoading) _uiState.update { it.copy(isLoading = true) }
        wordLoader.ensureFresh()
        val sets = wordSetRepository.getSetsByLanguage(languagePair)
        val setIds = sets.map { it.id }

        // Three batch queries replace N×3 individual queries.
        val wordCounts      = wordSetRepository.getWordCountsForSets(setIds)
        val correctThreshold = prefs.studyCorrectToCount.first()
        val introducedCounts = progressRepository.getIntroducedCountsForSets(setIds, correctThreshold)

        val items = sets.map { set ->
            val rarity = Rarity.fromLevel(set.level)
            WordSetUiItem(
                id = set.id,
                name = set.name,
                description = set.description,
                totalWords = wordCounts[set.id] ?: 0,
                introducedWords = introducedCounts[set.id] ?: 0,
                rarity = rarity,
                isFavorite = set.isFavorite,
                topic = set.topic,
                level = set.level,
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
