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

    // FIFO queue of unlocks waiting to be shown. A single session-end can unlock
    // several achievements at once (checkFirstLesson + checkDiligent + checkStreak5
    // + recordPvpMatch …); a single-slot StateFlow would let each new id overwrite
    // the previous before the user dismissed it, silently dropping all but the last
    // toast. The queue shows them one at a time. Mutated only from the collector and
    // dismissNotification — both run on the Main dispatcher, so no extra locking.
    private val queue = ArrayDeque<AchievementId>()

    private val _pendingNotification = MutableStateFlow<AchievementId?>(null)
    val pendingNotification: StateFlow<AchievementId?> = _pendingNotification.asStateFlow()

    /** Language pair for the unlocked achievement — used to pick the reward word. */
    val languagePair: StateFlow<String> = prefs.languagePair
        .stateIn(viewModelScope, SharingStarted.Eagerly, "en-ru")

    init {
        viewModelScope.launch {
            achievementRepository.newlyUnlocked.collect { id ->
                if (_pendingNotification.value == null) {
                    _pendingNotification.value = id
                } else {
                    queue.addLast(id)
                }
            }
        }
    }

    fun dismissNotification() {
        _pendingNotification.value = queue.removeFirstOrNull()
    }
}
