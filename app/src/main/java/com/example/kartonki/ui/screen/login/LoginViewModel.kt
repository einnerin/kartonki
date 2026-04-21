package com.example.kartonki.ui.screen.login

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.remote.FirebaseAuthManager
import com.example.kartonki.data.remote.FirestoreUserRepository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "LoginViewModel"

data class LoginUiState(
    val isLoading: Boolean = false,
    val isSignedIn: Boolean = false,
    val error: String? = null,
)

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authManager: FirebaseAuthManager,
    private val userRepository: FirestoreUserRepository,
    private val analytics: com.example.kartonki.analytics.AnalyticsManager,
) : ViewModel() {

    // Web client ID — needs to be set up in Firebase Console → Authentication → Google
    // Then add SHA-1 fingerprint and update google-services.json
    private val WEB_CLIENT_ID = "75116979020-g8b7ug8lknrfbrid1alk9agtqd2skn78.apps.googleusercontent.com"

    // Anonymous users must go through login to link their account — not considered "signed in"
    private val _uiState = MutableStateFlow(LoginUiState(
        isSignedIn = authManager.isSignedIn && authManager.currentUser.value?.isAnonymous == false,
    ))
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun getGoogleSignInIntent(context: Context): Intent =
        authManager.getGoogleSignInIntent(context, WEB_CLIENT_ID)

    fun handleGoogleSignInResult(data: Intent?) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                Log.d(TAG, "handleGoogleSignInResult: data=${data != null}")
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val account = task.getResult(ApiException::class.java)
                Log.d(TAG, "handleGoogleSignInResult: account=${account.email}, idToken=${if (account.idToken != null) "present" else "NULL"}")
                val idToken = account.idToken ?: run {
                    Log.e(TAG, "idToken is null — SHA-1 fingerprint probably not registered in Firebase Console")
                    _uiState.update { it.copy(isLoading = false, error = "Ошибка входа: ID токен не получен. Проверьте настройки Firebase Console.") }
                    return@launch
                }
                val result = authManager.firebaseSignInWithGoogle(idToken)
                result.onSuccess { profile ->
                    val firstTime = userRepository.getProfile(profile.uid) == null
                    userRepository.saveProfile(profile)
                    _uiState.update { it.copy(isLoading = false, isSignedIn = true) }
                    analytics.log(
                        com.example.kartonki.analytics.AnalyticsEvent.LoginMethod(
                            method = "google",
                            firstTime = firstTime,
                        )
                    )
                }.onFailure { e ->
                    val msg = e.message?.takeIf { it.isNotBlank() } ?: "${e.javaClass.simpleName} (без сообщения)"
                    Log.e(TAG, "Firebase sign-in failed: $msg", e)
                    _uiState.update { it.copy(isLoading = false, error = "Ошибка Firebase: $msg") }
                }
            } catch (e: ApiException) {
                val msg = "Google Sign-In код ${e.statusCode}: ${googleErrorDescription(e.statusCode)}"
                Log.e(TAG, msg, e)
                _uiState.update { it.copy(isLoading = false, error = msg) }
            } catch (e: Exception) {
                val msg = e.message?.takeIf { it.isNotBlank() } ?: e.javaClass.simpleName
                Log.e(TAG, "handleGoogleSignInResult exception: $msg", e)
                _uiState.update { it.copy(isLoading = false, error = msg) }
            }
        }
    }

    private fun googleErrorDescription(code: Int) = when (code) {
        10 -> "DEVELOPER_ERROR — SHA-1 не зарегистрирован в Firebase Console"
        12500 -> "SIGN_IN_FAILED"
        12501 -> "SIGN_IN_CANCELLED"
        12502 -> "SIGN_IN_CURRENTLY_IN_PROGRESS"
        else -> "неизвестная ошибка"
    }

    fun dismissError() = _uiState.update { it.copy(error = null) }
}
