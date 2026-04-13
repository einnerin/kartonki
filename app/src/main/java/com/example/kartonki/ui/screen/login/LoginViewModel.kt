package com.example.kartonki.ui.screen.login

import android.content.Context
import android.content.Intent
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

data class LoginUiState(
    val isLoading: Boolean = false,
    val isSignedIn: Boolean = false,
    val error: String? = null,
)

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authManager: FirebaseAuthManager,
    private val userRepository: FirestoreUserRepository,
) : ViewModel() {

    // Web client ID — needs to be set up in Firebase Console → Authentication → Google
    // Then add SHA-1 fingerprint and update google-services.json
    private val WEB_CLIENT_ID = "YOUR_WEB_CLIENT_ID"

    private val _uiState = MutableStateFlow(LoginUiState(isSignedIn = authManager.isSignedIn))
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun getGoogleSignInIntent(context: Context): Intent =
        authManager.getGoogleSignInIntent(context, WEB_CLIENT_ID)

    fun handleGoogleSignInResult(data: Intent?) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val account = GoogleSignIn.getSignedInAccountFromIntent(data)
                    .getResult(ApiException::class.java)
                val idToken = account.idToken ?: error("ID token is null")
                val result = authManager.firebaseSignInWithGoogle(idToken)
                result.onSuccess { profile ->
                    userRepository.saveProfile(profile)
                    _uiState.update { it.copy(isLoading = false, isSignedIn = true) }
                }.onFailure { e ->
                    _uiState.update { it.copy(isLoading = false, error = e.message) }
                }
            } catch (e: ApiException) {
                _uiState.update { it.copy(isLoading = false, error = "Google Sign-In failed: ${e.statusCode}") }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun signInAnonymously() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            authManager.signInAnonymously()
                .onSuccess { profile ->
                    userRepository.saveProfile(profile)
                    _uiState.update { it.copy(isLoading = false, isSignedIn = true) }
                }
                .onFailure { e ->
                    _uiState.update { it.copy(isLoading = false, error = e.message) }
                }
        }
    }

    fun dismissError() = _uiState.update { it.copy(error = null) }
}
