package com.example.kartonki.ui.screen.achievements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.AchievementRepository
import com.example.kartonki.domain.model.AchievementId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Shared ViewModel (activity-scoped) that listens for achievement unlocks
 * and exposes them as a notification to display over any screen.
 */
@HiltViewModel
class AchievementEventViewModel @Inject constructor(
    achievementRepository: AchievementRepository,
    prefs: UserPreferencesRepository,
) : ViewModel() {

    private val _pendingNotification = MutableStateFlow<AchievementId?>(null)
    val pendingNotification: StateFlow<AchievementId?> = _pendingNotification.asStateFlow()

    /** Language pair for the unlocked achievement — used to pick the reward word. */
    val languagePair: StateFlow<String> = prefs.languagePair
        .stateIn(viewModelScope, SharingStarted.Eagerly, "en-ru")

    init {
        viewModelScope.launch {
            achievementRepository.newlyUnlocked.collect { id ->
                _pendingNotification.value = id
            }
        }
    }

    fun dismissNotification() {
        _pendingNotification.value = null
    }
}
