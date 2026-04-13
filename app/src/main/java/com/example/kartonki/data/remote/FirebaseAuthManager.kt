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
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

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
        val currentUser = auth.currentUser
        val task = if (currentUser != null && currentUser.isAnonymous) {
            Log.d(TAG, "firebaseSignInWithGoogle: linking anonymous account to Google")
            currentUser.linkWithCredential(credential)
        } else {
            Log.d(TAG, "firebaseSignInWithGoogle: calling signInWithCredential...")
            auth.signInWithCredential(credential)
        }
        val result = task.awaitTask()
        Log.d(TAG, "firebaseSignInWithGoogle: success, user=${result.user?.uid}")
        result.user?.toProfile() ?: error("Firebase user is null after sign-in")
    }.also { result ->
        result.onFailure { e -> Log.e(TAG, "firebaseSignInWithGoogle failed: ${e.javaClass.simpleName}: ${e.message}", e) }
    }

    fun signOut(context: Context, webClientId: String) {
        auth.signOut()
        getGoogleSignInClient(context, webClientId).signOut()
    }

    /**
     * More reliable alternative to Task.await() from kotlinx-coroutines-play-services.
     * That library uses addOnCompleteListener which can fail to resume the coroutine on
     * some devices/Play Services versions. Using separate success/failure listeners avoids
     * the issue where auth state updates (via AuthStateListener) but the Task never completes.
     */
    private suspend fun <T> com.google.android.gms.tasks.Task<T>.awaitTask(): T =
        suspendCancellableCoroutine { cont ->
            addOnSuccessListener { result ->
                if (cont.isActive) cont.resume(result)
            }
            addOnFailureListener { e ->
                if (cont.isActive) cont.resumeWithException(e)
            }
            addOnCanceledListener {
                if (cont.isActive) cont.cancel(CancellationException("Firebase Task was cancelled"))
            }
        }

    private fun FirebaseUser.toProfile() = UserProfile(
        uid = uid,
        displayName = displayName ?: "Игрок",
        email = email ?: "",
        photoUrl = photoUrl?.toString(),
        isAnonymous = isAnonymous,
    )
}
