package com.example.kartonki.ui.screen.settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.preferences.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SettingsUiState(
    val isDarkTheme: Boolean = true,
    val username: String = "Игрок",
    val avatarChoice: String = "🎮",
    val languagePair: String = "en-ru",
    val isEditingName: Boolean = false,
    val nameInput: String = "",
)

val AVATAR_EMOJI_OPTIONS = listOf(
    "🎮", "🃏", "👑", "🐉", "⚔️", "🏆",
    "🦊", "🦁", "🐺", "🦅", "🌟", "💎",
    "🧙", "🔮", "🎯", "🏹",
)

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val prefs: UserPreferencesRepository,
    @ApplicationContext private val appContext: Context,
) : ViewModel() {

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                prefs.isDarkTheme,
                prefs.username,
                prefs.avatarChoice,
                prefs.languagePair,
            ) { dark, name, avatar, lang ->
                SettingsUiState(
                    isDarkTheme  = dark,
                    username     = name,
                    avatarChoice = avatar,
                    languagePair = lang,
                )
            }.collect { state ->
                _uiState.update { current ->
                    state.copy(
                        isEditingName = current.isEditingName,
                        nameInput     = current.nameInput,
                    )
                }
            }
        }
    }

    fun onThemeToggle(isDark: Boolean) = viewModelScope.launch { prefs.setDarkTheme(isDark) }

    fun onStartEditName() = _uiState.update {
        it.copy(isEditingName = true, nameInput = it.username)
    }

    fun onNameInputChange(value: String) = _uiState.update { it.copy(nameInput = value) }

    fun onSaveName() = viewModelScope.launch {
        val name = _uiState.value.nameInput.trim().ifBlank { "Игрок" }
        prefs.setUsername(name)
        _uiState.update { it.copy(isEditingName = false) }
    }

    fun onCancelEditName() = _uiState.update { it.copy(isEditingName = false) }

    fun onEmojiAvatarSelected(emoji: String) = viewModelScope.launch {
        prefs.setAvatarChoice(emoji)
    }

    fun onPhotoSelected(uri: Uri) = viewModelScope.launch {
        try {
            appContext.contentResolver.takePersistableUriPermission(
                uri,
                Intent.FLAG_GRANT_READ_URI_PERMISSION,
            )
        } catch (_: SecurityException) { /* some pickers don't grant persistable permission */ }
        prefs.setAvatarChoice(uri.toString())
    }
}
