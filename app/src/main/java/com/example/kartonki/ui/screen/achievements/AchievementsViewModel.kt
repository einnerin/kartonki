package com.example.kartonki.ui.screen.achievements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.AchievementRepository
import com.example.kartonki.domain.model.AchievementState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AchievementsUiState(
    val isLoading: Boolean = true,
    val visibleAchievements: List<AchievementState> = emptyList(),
    val hiddenAchievements: List<AchievementState> = emptyList(),
) {
    val unlockedCount: Int get() = (visibleAchievements + hiddenAchievements).count { it.isUnlocked }
    val totalCount: Int get() = visibleAchievements.size + hiddenAchievements.size
}

@HiltViewModel
class AchievementsViewModel @Inject constructor(
    private val achievementRepository: AchievementRepository,
    prefs: UserPreferencesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AchievementsUiState())
    val uiState: StateFlow<AchievementsUiState> = _uiState.asStateFlow()

    /** Currently-studied language pair — UI uses this to pick the reward word. */
    val languagePair: StateFlow<String> = prefs.languagePair
        .stateIn(viewModelScope, SharingStarted.Eagerly, "en-ru")

    init { load() }

    fun load() = viewModelScope.launch {
        val achievements = achievementRepository.getAll()
        _uiState.update {
            it.copy(
                isLoading = false,
                visibleAchievements = achievements.filter { a -> !a.id.isHidden },
                hiddenAchievements  = achievements.filter { a -> a.id.isHidden },
            )
        }
    }
}
