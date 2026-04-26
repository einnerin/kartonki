package com.example.kartonki.ui.screen.study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DismissedProblemWordsUiState(
    val isLoading: Boolean = true,
    val words: List<Word> = emptyList(),
)

/**
 * Lists words the user previously removed from the problem-words list and lets
 * them restore individual entries (one tap) or all at once. Counterpart to
 * [ProblemWordsListViewModel.dismissWord].
 */
@HiltViewModel
class DismissedProblemWordsViewModel @Inject constructor(
    private val wordDao: WordDao,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DismissedProblemWordsUiState())
    val uiState: StateFlow<DismissedProblemWordsUiState> = _uiState.asStateFlow()

    init { reload() }

    fun reload() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val ids = prefs.getDismissedProblemWordIds()
            val words = if (ids.isEmpty()) emptyList()
                        else wordDao.getWordsByIds(ids.toList()).map { it.toDomain() }
            // Sort alphabetically by `original` for predictable scanning.
            _uiState.update {
                it.copy(isLoading = false, words = words.sortedBy { w -> w.original })
            }
        }
    }

    /** Removes [wordId] from the dismissed set so it can re-enter the problem list. */
    fun restore(wordId: Long) {
        prefs.removeDismissedProblemWordId(wordId)
        reload()
    }

    fun restoreAll() {
        prefs.clearDismissedProblemWordIds()
        reload()
    }

    private fun com.example.kartonki.data.db.entity.WordEntity.toDomain(): Word = Word(
        id = id,
        original = original,
        translation = translation,
        definition = definition,
        definitionNative = definitionNative,
        example = example,
        exampleNative = exampleNative,
        rarity = runCatching { Rarity.valueOf(rarity) }.getOrElse { Rarity.COMMON },
        languagePair = languagePair,
        pos = pos,
        semanticGroup = semanticGroup,
        transliteration = transliteration,
        isFillInBlankSafe = isFillInBlankSafe,
        fillInBlankExclusions = fillInBlankExclusions,
    )
}
