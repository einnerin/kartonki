package com.example.kartonki.data.remote

import com.example.kartonki.domain.model.UserProfile
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirestoreUserRepository @Inject constructor(
    private val firestore: FirebaseFirestore,
) {
    private fun usersCollection() = firestore.collection("users")

    suspend fun saveProfile(profile: UserProfile) {
        val data = mapOf(
            "uid" to profile.uid,
            "displayName" to profile.displayName,
            "email" to profile.email,
            "photoUrl" to (profile.photoUrl ?: ""),
            "isAnonymous" to profile.isAnonymous,
        )
        usersCollection().document(profile.uid).set(data, SetOptions.merge()).await()
    }

    suspend fun getProfile(uid: String): UserProfile? {
        val doc = usersCollection().document(uid).get().await()
        if (!doc.exists()) return null
        return UserProfile(
            uid = doc.getString("uid") ?: uid,
            displayName = doc.getString("displayName") ?: "Игрок",
            email = doc.getString("email") ?: "",
            photoUrl = doc.getString("photoUrl")?.takeIf { it.isNotEmpty() },
            isAnonymous = doc.getBoolean("isAnonymous") ?: false,
            pvpOnlineWins = doc.getLong("pvpOnlineWins")?.toInt() ?: 0,
            pvpOnlineLosses = doc.getLong("pvpOnlineLosses")?.toInt() ?: 0,
            pvpOnlineDraws = doc.getLong("pvpOnlineDraws")?.toInt() ?: 0,
        )
    }

    suspend fun incrementWin(uid: String) = incrementStat(uid, "pvpOnlineWins")
    suspend fun incrementLoss(uid: String) = incrementStat(uid, "pvpOnlineLosses")
    suspend fun incrementDraw(uid: String) = incrementStat(uid, "pvpOnlineDraws")

    private suspend fun incrementStat(uid: String, field: String) {
        val doc = usersCollection().document(uid)
        firestore.runTransaction { tx ->
            val snap = tx.get(doc)
            val cur = snap.getLong(field)?.toInt() ?: 0
            tx.update(doc, field, cur + 1)
        }.await()
    }
}
