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

/** Supported native languages: code → display name */
val NATIVE_LANGUAGES: LinkedHashMap<String, String> = linkedMapOf(
    "ru" to "Русский",
    "en" to "English",
    "de" to "Deutsch",
    "fr" to "Français",
    "es" to "Español",
    "zh" to "中文",
    "ja" to "日本語",
    "ar" to "العربية",
)

val STUDY_LANGUAGES: LinkedHashMap<String, String> = linkedMapOf(
    "en-ru" to "Английский 🇬🇧",
    "he-ru" to "Иврит 🇮🇱",
)

val CONTEXT_QUIZ_MODES: LinkedHashMap<String, String> = linkedMapOf(
    "foreign" to "На изучаемом языке",
    "native"  to "На родном языке",
    "both"    to "Оба варианта",
)

val DEFINITION_MODE_LABELS: LinkedHashMap<String, String> = CONTEXT_QUIZ_MODES
val FILL_BLANK_MODE_LABELS: LinkedHashMap<String, String>  = CONTEXT_QUIZ_MODES

val QUIZ_TYPE_LABELS: LinkedHashMap<String, String> = linkedMapOf(
    "translation" to "Перевод (4 варианта)",
    "definition"  to "Определение",
    "fill_blank"  to "Вставка слова",
)

data class SettingsUiState(
    val isDarkTheme: Boolean = true,
    val username: String = "Игрок",
    val avatarChoice: String = "🎮",
    val languagePair: String = "en-ru",
    val nativeLanguage: String = "ru",
    val definitionQuizMode: String = "both",
    val fillBlankQuizMode: String = "both",
    val enabledQuizTypes: Set<String> = setOf("translation", "definition", "fill_blank"),
    val isEditingName: Boolean = false,
    val nameInput: String = "",
    val showLanguagePicker: Boolean = false,
    val showStudyLanguagePicker: Boolean = false,
    val showDefinitionModePicker: Boolean = false,
    val showFillBlankModePicker: Boolean = false,
    val showQuizTypesPicker: Boolean = false,
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
                combine(
                    prefs.isDarkTheme,
                    prefs.username,
                    prefs.avatarChoice,
                    prefs.languagePair,
                    prefs.nativeLanguage,
                    prefs.definitionQuizMode,
                ) { values ->
                    SettingsUiState(
                        isDarkTheme          = values[0] as Boolean,
                        username             = values[1] as String,
                        avatarChoice         = values[2] as String,
                        languagePair         = values[3] as String,
                        nativeLanguage       = values[4] as String,
                        definitionQuizMode   = values[5] as String,
                    )
                },
                combine(
                    prefs.fillBlankQuizMode,
                    prefs.quizTypesEnabled,
                ) { fillBlankMode, enabledTypes ->
                    Pair(fillBlankMode, enabledTypes)
                },
            ) { base, (fillBlankMode, enabledTypes) ->
                base.copy(fillBlankQuizMode = fillBlankMode, enabledQuizTypes = enabledTypes)
            }.collect { state ->
                _uiState.update { current ->
                    state.copy(
                        isEditingName           = current.isEditingName,
                        nameInput               = current.nameInput,
                        showLanguagePicker      = current.showLanguagePicker,
                        showStudyLanguagePicker = current.showStudyLanguagePicker,
                        showDefinitionModePicker = current.showDefinitionModePicker,
                        showFillBlankModePicker  = current.showFillBlankModePicker,
                        showQuizTypesPicker     = current.showQuizTypesPicker,
                    )
                }
            }
        }
    }

    fun onThemeToggle(isDark: Boolean) = viewModelScope.launch { prefs.setDarkTheme(isDark) }

    fun onShowLanguagePicker() = _uiState.update { it.copy(showLanguagePicker = true) }
    fun onDismissLanguagePicker() = _uiState.update { it.copy(showLanguagePicker = false) }
    fun onNativeLanguageSelected(code: String) = viewModelScope.launch {
        prefs.setNativeLanguage(code)
        _uiState.update { it.copy(showLanguagePicker = false) }
    }

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

    fun onShowStudyLanguagePicker() = _uiState.update { it.copy(showStudyLanguagePicker = true) }
    fun onDismissStudyLanguagePicker() = _uiState.update { it.copy(showStudyLanguagePicker = false) }
    fun onStudyLanguageSelected(pair: String) = viewModelScope.launch {
        prefs.setLanguagePair(pair)
        _uiState.update { it.copy(showStudyLanguagePicker = false) }
    }

    fun onShowDefinitionModePicker() = _uiState.update { it.copy(showDefinitionModePicker = true) }
    fun onDismissDefinitionModePicker() = _uiState.update { it.copy(showDefinitionModePicker = false) }
    fun onDefinitionModeSelected(mode: String) {
        prefs.setDefinitionQuizMode(mode)
        _uiState.update { it.copy(showDefinitionModePicker = false) }
    }

    fun onShowFillBlankModePicker() = _uiState.update { it.copy(showFillBlankModePicker = true) }
    fun onDismissFillBlankModePicker() = _uiState.update { it.copy(showFillBlankModePicker = false) }
    fun onFillBlankModeSelected(mode: String) {
        prefs.setFillBlankQuizMode(mode)
        _uiState.update { it.copy(showFillBlankModePicker = false) }
    }

    fun onShowQuizTypesPicker() = _uiState.update { it.copy(showQuizTypesPicker = true) }
    fun onDismissQuizTypesPicker() = _uiState.update { it.copy(showQuizTypesPicker = false) }
    fun onQuizTypeToggled(key: String) {
        val current = _uiState.value.enabledQuizTypes.toMutableSet()
        if (key in current && current.size > 1) current.remove(key)  // keep at least one enabled
        else current.add(key)
        prefs.setQuizTypesEnabled(current)
    }

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
