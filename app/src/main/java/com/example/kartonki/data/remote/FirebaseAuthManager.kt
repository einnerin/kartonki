package com.example.kartonki.data.remote

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.kartonki.domain.model.UserProfile
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FirebaseAuthManager"

@Singleton
class FirebaseAuthManager @Inject constructor(
    private val auth: FirebaseAuth,
) {
    private val _currentUser = MutableStateFlow<UserProfile?>(auth.currentUser?.toProfile())
    val currentUser: StateFlow<UserProfile?> = _currentUser.asStateFlow()

    val isSignedIn: Boolean get() = auth.currentUser != null

    init {
        auth.addAuthStateListener { firebaseAuth ->
            _currentUser.value = firebaseAuth.currentUser?.toProfile()
        }
    }

    fun getGoogleSignInClient(context: Context, webClientId: String): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(webClientId)
            .requestEmail()
            .requestProfile()
            .build()
        return GoogleSignIn.getClient(context, gso)
    }

    fun getGoogleSignInIntent(context: Context, webClientId: String): Intent =
        getGoogleSignInClient(context, webClientId).signInIntent

    suspend fun firebaseSignInWithGoogle(idToken: String): Result<UserProfile> = runCatching {
        Log.d(TAG, "firebaseSignInWithGoogle: creating credential")
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        Log.d(TAG, "firebaseSignInWithGoogle: calling signInWithCredential...")
        val result = withTimeout(30_000L) {
            auth.signInWithCredential(credential).await()
        }
        Log.d(TAG, "firebaseSignInWithGoogle: success, user=${result.user?.uid}")
        result.user?.toProfile() ?: error("Firebase user is null after sign-in")
    }.also { result ->
        result.onFailure { e -> Log.e(TAG, "firebaseSignInWithGoogle failed: ${e.javaClass.simpleName}: ${e.message}", e) }
    }

    suspend fun signInAnonymously(): Result<UserProfile> = runCatching {
        Log.d(TAG, "signInAnonymously: calling...")
        val result = withTimeout(30_000L) {
            auth.signInAnonymously().await()
        }
        Log.d(TAG, "signInAnonymously: success, user=${result.user?.uid}")
        result.user?.toProfile() ?: error("Firebase user is null after anonymous sign-in")
    }.also { result ->
        result.onFailure { e -> Log.e(TAG, "signInAnonymously failed: ${e.javaClass.simpleName}: ${e.message}", e) }
    }

    fun signOut(context: Context, webClientId: String) {
        auth.signOut()
        getGoogleSignInClient(context, webClientId).signOut()
    }

    private fun FirebaseUser.toProfile() = UserProfile(
        uid = uid,
        displayName = displayName ?: "Игрок",
        email = email ?: "",
        photoUrl = photoUrl?.toString(),
        isAnonymous = isAnonymous,
    )
}
