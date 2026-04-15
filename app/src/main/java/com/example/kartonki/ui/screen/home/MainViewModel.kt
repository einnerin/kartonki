package com.example.kartonki.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.AchievementRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    prefs: UserPreferencesRepository,
    private val achievementRepository: AchievementRepository,
) : ViewModel() {
    val isDarkTheme: StateFlow<Boolean> = prefs.isDarkTheme
        .stateIn(viewModelScope, SharingStarted.Eagerly, true)

    val nativeLanguage: StateFlow<String> = prefs.nativeLanguage
        .stateIn(viewModelScope, SharingStarted.Eagerly, "ru")

    init {
        viewModelScope.launch {
            achievementRepository.checkFirstLaunch()
        }
    }
}
