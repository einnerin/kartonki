package com.example.kartonki.ui.screen.study

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.repository.ProgressRepository
import com.example.kartonki.data.repository.WordSetRepository
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class WordSetDetailUiState(
    val isLoading: Boolean = true,
    val setName: String = "",
    val setDescription: String = "",
    val words: List<Word> = emptyList(),
    val introducedWords: Int = 0,
)

@HiltViewModel
class WordSetDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val wordSetRepository: WordSetRepository,
    private val progressRepository: ProgressRepository,
    private val analytics: com.example.kartonki.analytics.AnalyticsManager,
) : ViewModel() {

    val setId: Long = checkNotNull(savedStateHandle[Route.WordSetDetail.ARG_SET_ID])

    private val _uiState = MutableStateFlow(WordSetDetailUiState())
    val uiState: StateFlow<WordSetDetailUiState> = _uiState.asStateFlow()

    private var setOpenedLogged = false

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val set = wordSetRepository.getSetById(setId)
            val words = wordSetRepository.getWordsInSet(setId)
            val progress = progressRepository.getProgressForSet(setId)
            val introduced = progress.count { p -> p.level > 0 }
            _uiState.update {
                it.copy(
                    isLoading = false,
                    setName = set?.name ?: "",
                    setDescription = set?.description ?: "",
                    words = words,
                    introducedWords = introduced,
                )
            }
            if (!setOpenedLogged) {
                setOpenedLogged = true
                analytics.log(
                    com.example.kartonki.analytics.AnalyticsEvent.SetOpened(
                        setId = setId.toInt(),
                        firstTime = introduced == 0,
                        fromScreen = "study_detail",
                    )
                )
                // set_completed: все слова сета прошли минимум 1 верный ответ
                if (words.isNotEmpty() && introduced >= words.size) {
                    analytics.log(
                        com.example.kartonki.analytics.AnalyticsEvent.SetCompleted(
                            setId = setId.toInt(),
                            daysSinceFirstOpen = 0,  // вычисление точной даты — отдельная задача
                            totalAttempts = progress.sumOf { it.correctCount + it.incorrectCount },
                        )
                    )
                }
            }
        }
    }

    /**
     * Только перечитывает прогресс — не флэшит loading-спиннером и не дёргает
     * analytics. Вызывается при возврате на экран из study-сессии: пользователь
     * уже видит старый список слов, мы тихо обновляем "Изучено: X/Y" с актуального
     * состояния прогресса в БД.
     */
    fun refreshProgress() {
        viewModelScope.launch {
            val progress = progressRepository.getProgressForSet(setId)
            val introduced = progress.count { p -> p.level > 0 }
            _uiState.update { it.copy(introducedWords = introduced) }
        }
    }
}
