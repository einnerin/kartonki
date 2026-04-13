package com.example.kartonki.data.remote

import android.content.Context
import android.content.Intent
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
import javax.inject.Inject
import javax.inject.Singleton

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
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        val result = auth.signInWithCredential(credential).await()
        result.user?.toProfile() ?: error("Firebase user is null after sign-in")
    }

    suspend fun signInAnonymously(): Result<UserProfile> = runCatching {
        val result = auth.signInAnonymously().await()
        result.user?.toProfile() ?: error("Firebase user is null after anonymous sign-in")
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
