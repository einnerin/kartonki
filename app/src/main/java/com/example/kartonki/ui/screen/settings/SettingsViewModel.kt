package com.example.kartonki.ui.screen.settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.remote.FirebaseAuthManager
import com.example.kartonki.data.remote.FirestoreUserRepository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "SettingsViewModel"

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

val PROBLEM_WORDS_SOURCE_LABELS: LinkedHashMap<String, String> = linkedMapOf(
    "both"     to "PvE + PvP вместе",
    "pve_only" to "Только PvE",
    "pvp_only" to "Только PvP",
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
    val problemWordsSource: String = "both",
    // Study settings
    val studyCorrectToCount: Int = 1,
    val showStudyCorrectToCountPicker: Boolean = false,
    // Problem words block
    val problemWordsEnabled: Boolean = true,
    val problemWordsMinEncounters: Int = 2,
    val problemWordsCorrectToLearn: Int = 1,
    val showMinEncountersPicker: Boolean = false,
    val showCorrectToLearnPicker: Boolean = false,
    val isEditingName: Boolean = false,
    val nameInput: String = "",
    val showLanguagePicker: Boolean = false,
    val showStudyLanguagePicker: Boolean = false,
    val showDefinitionModePicker: Boolean = false,
    val showFillBlankModePicker: Boolean = false,
    val showQuizTypesPicker: Boolean = false,
    val showProblemWordsSourcePicker: Boolean = false,
    // Account
    val isSignedIn: Boolean = false,
    val isAnonymous: Boolean = true,
    val accountEmail: String = "",
    val accountDisplayName: String = "",
    val showSignOutDialog: Boolean = false,
    val signOutDone: Boolean = false,
    val isSigningIn: Boolean = false,
    val signInError: String? = null,
)

val AVATAR_EMOJI_OPTIONS = listOf(
    "🎮", "🃏", "👑", "🐉", "⚔️", "🏆",
    "🦊", "🦁", "🐺", "🦅", "🌟", "💎",
    "🧙", "🔮", "🎯", "🏹",
)

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val prefs: UserPreferencesRepository,
    private val authManager: FirebaseAuthManager,
    private val userRepository: FirestoreUserRepository,
    @ApplicationContext private val appContext: Context,
) : ViewModel() {

    private val WEB_CLIENT_ID = "75116979020-g8b7ug8lknrfbrid1alk9agtqd2skn78.apps.googleusercontent.com"

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            authManager.currentUser.collect { profile ->
                val signedInWithAccount = profile != null && profile.isAnonymous == false
                _uiState.update {
                    it.copy(
                        isSignedIn = profile != null,
                        isAnonymous = profile?.isAnonymous ?: true,
                        accountEmail = profile?.email ?: "",
                        accountDisplayName = profile?.displayName ?: "",
                        // Clear spinner as soon as auth state reflects successful sign-in,
                        // regardless of whether the sign-in Task coroutine has completed.
                        isSigningIn = if (signedInWithAccount) false else it.isSigningIn,
                    )
                }
            }
        }
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
                        isEditingName                = current.isEditingName,
                        nameInput                    = current.nameInput,
                        showLanguagePicker           = current.showLanguagePicker,
                        showStudyLanguagePicker      = current.showStudyLanguagePicker,
                        showDefinitionModePicker     = current.showDefinitionModePicker,
                        showFillBlankModePicker      = current.showFillBlankModePicker,
                        showQuizTypesPicker          = current.showQuizTypesPicker,
                        showProblemWordsSourcePicker = current.showProblemWordsSourcePicker,
                        // Preserve settings loaded by separate coroutines — they must not
                        // be reset to defaults when any other preference changes
                        // (race condition with the shared prefsFlow).
                        studyCorrectToCount          = current.studyCorrectToCount,
                        showStudyCorrectToCountPicker = current.showStudyCorrectToCountPicker,
                        problemWordsSource           = current.problemWordsSource,
                        problemWordsEnabled          = current.problemWordsEnabled,
                        problemWordsMinEncounters    = current.problemWordsMinEncounters,
                        problemWordsCorrectToLearn   = current.problemWordsCorrectToLearn,
                        showMinEncountersPicker      = current.showMinEncountersPicker,
                        showCorrectToLearnPicker     = current.showCorrectToLearnPicker,
                        // Preserve account state set by the authManager collector above
                        isSignedIn                   = current.isSignedIn,
                        isAnonymous                  = current.isAnonymous,
                        accountEmail                 = current.accountEmail,
                        accountDisplayName           = current.accountDisplayName,
                    )
                }
            }
        }
        // Collect problemWordsSource and problem words settings in separate coroutines
        viewModelScope.launch {
            prefs.problemWordsSource.collect { source ->
                _uiState.update { it.copy(problemWordsSource = source) }
            }
        }
        viewModelScope.launch {
            prefs.problemWordsEnabled.collect { v ->
                _uiState.update { it.copy(problemWordsEnabled = v) }
            }
        }
        viewModelScope.launch {
            prefs.problemWordsMinEncounters.collect { v ->
                _uiState.update { it.copy(problemWordsMinEncounters = v) }
            }
        }
        viewModelScope.launch {
            prefs.problemWordsCorrectToLearn.collect { v ->
                _uiState.update { it.copy(problemWordsCorrectToLearn = v) }
            }
        }
        viewModelScope.launch {
            prefs.studyCorrectToCount.collect { v ->
                _uiState.update { it.copy(studyCorrectToCount = v) }
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

    fun onShowProblemWordsSourcePicker() = _uiState.update { it.copy(showProblemWordsSourcePicker = true) }
    fun onDismissProblemWordsSourcePicker() = _uiState.update { it.copy(showProblemWordsSourcePicker = false) }
    fun onProblemWordsSourceSelected(source: String) {
        prefs.setProblemWordsSource(source)
        _uiState.update { it.copy(showProblemWordsSourcePicker = false) }
    }

    // ── Study settings ────────────────────────────────────────────────────────
    fun onShowStudyCorrectToCountPicker() = _uiState.update { it.copy(showStudyCorrectToCountPicker = true) }
    fun onDismissStudyCorrectToCountPicker() = _uiState.update { it.copy(showStudyCorrectToCountPicker = false) }
    fun onStudyCorrectToCountSelected(n: Int) {
        prefs.setStudyCorrectToCount(n)
        _uiState.update { it.copy(showStudyCorrectToCountPicker = false) }
    }

    // ── Problem words block ────────────────────────────────────────────────────
    fun onProblemWordsEnabledToggle(enabled: Boolean) = prefs.setProblemWordsEnabled(enabled)

    fun onShowMinEncountersPicker() = _uiState.update { it.copy(showMinEncountersPicker = true) }
    fun onDismissMinEncountersPicker() = _uiState.update { it.copy(showMinEncountersPicker = false) }
    fun onMinEncountersSelected(n: Int) {
        prefs.setProblemWordsMinEncounters(n)
        _uiState.update { it.copy(showMinEncountersPicker = false) }
    }

    fun onShowCorrectToLearnPicker() = _uiState.update { it.copy(showCorrectToLearnPicker = true) }
    fun onDismissCorrectToLearnPicker() = _uiState.update { it.copy(showCorrectToLearnPicker = false) }
    fun onCorrectToLearnSelected(n: Int) {
        prefs.setProblemWordsCorrectToLearn(n)
        _uiState.update { it.copy(showCorrectToLearnPicker = false) }
    }

    fun onSignOutClick() = _uiState.update { it.copy(showSignOutDialog = true) }
    fun onSignOutDismiss() = _uiState.update { it.copy(showSignOutDialog = false) }
    fun onSignOutConfirmed() {
        authManager.signOut(appContext, WEB_CLIENT_ID)
        _uiState.update { it.copy(showSignOutDialog = false, signOutDone = true) }
    }
    fun onSignOutNavigated() = _uiState.update { it.copy(signOutDone = false) }

    fun getGoogleSignInIntent(context: Context): Intent =
        authManager.getGoogleSignInIntent(context, WEB_CLIENT_ID)

    fun handleGoogleSignInResult(data: Intent?) {
        viewModelScope.launch {
            _uiState.update { it.copy(isSigningIn = true, signInError = null) }
            try {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val account = task.getResult(ApiException::class.java)
                val idToken = account.idToken ?: run {
                    Log.e(TAG, "idToken is null — SHA-1 not registered in Firebase Console")
                    _uiState.update { it.copy(isSigningIn = false, signInError = "Ошибка: ID токен не получен. Проверьте SHA-1 в Firebase Console.") }
                    return@launch
                }
                authManager.firebaseSignInWithGoogle(idToken)
                    .onSuccess { profile ->
                        userRepository.saveProfile(profile)
                        _uiState.update { it.copy(isSigningIn = false) }
                    }
                    .onFailure { e ->
                        val msg = e.message?.takeIf { it.isNotBlank() } ?: e.javaClass.simpleName
                        Log.e(TAG, "Google sign-in failed: $msg", e)
                        _uiState.update { it.copy(isSigningIn = false, signInError = "Ошибка входа: $msg") }
                    }
            } catch (e: ApiException) {
                val msg = when (e.statusCode) {
                    10 -> "DEVELOPER_ERROR — SHA-1 не зарегистрирован в Firebase Console"
                    12500 -> "Вход не выполнен"
                    12501 -> "Вход отменён"
                    else -> "Ошибка Google Sign-In (код ${e.statusCode})"
                }
                Log.e(TAG, msg, e)
                _uiState.update { it.copy(isSigningIn = false, signInError = msg) }
            } catch (e: Exception) {
                val msg = e.message?.takeIf { it.isNotBlank() } ?: e.javaClass.simpleName
                Log.e(TAG, "handleGoogleSignInResult exception: $msg", e)
                _uiState.update { it.copy(isSigningIn = false, signInError = msg) }
            }
        }
    }

    fun dismissSignInError() = _uiState.update { it.copy(signInError = null) }

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
