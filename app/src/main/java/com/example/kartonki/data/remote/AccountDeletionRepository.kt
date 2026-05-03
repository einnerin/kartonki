package com.example.kartonki.data.remote

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "AccountDeletion"

/**
 * Удаление аккаунта пользователя со всеми облачными данными:
 *   1. Слот в matchmaking_lobby с этим uid (RTDB) — best-effort
 *   2. Документ /users/{uid} в Firestore — best-effort
 *   3. Сам Firebase Auth пользователь — обязательно
 *
 * Активные/завершённые матчи в /matches/{matchId} НЕ удаляются — это shared
 * data между двумя игроками, удаление одной стороной нарушит историю оппонента.
 * Имя/uid в исторических матчах остаётся, но это не персональная PII в смысле
 * нарушения приватности (никто кроме оппонента уже не видит).
 *
 * Auth `delete()` требует "recent login" (≤ ~5 мин с последнего sign-in) —
 * если требование не выполнено, возвращается [Result.ReauthRequired] без
 * выполнения других шагов: бесполезно чистить Firestore/RTDB, если потом мы
 * не смогли удалить сам Auth-аккаунт.
 */
@Singleton
class AccountDeletionRepository @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    private val database: FirebaseDatabase,
) {
    sealed class Result {
        object Success : Result()
        object ReauthRequired : Result()
        object NotSignedIn : Result()
        data class Error(val message: String) : Result()
    }

    suspend fun deleteAccount(): Result {
        val user = auth.currentUser ?: return Result.NotSignedIn
        val uid = user.uid

        // Сначала проверяем, удалится ли вообще Auth — если потребуется reauth,
        // не трогаем Firestore/RTDB.
        try {
            user.delete().await()
        } catch (_: FirebaseAuthRecentLoginRequiredException) {
            Log.d(TAG, "delete: reauth required, returning ReauthRequired")
            return Result.ReauthRequired
        } catch (e: Exception) {
            Log.e(TAG, "delete: auth.delete() failed", e)
            return Result.Error(e.message ?: e.javaClass.simpleName)
        }

        // Auth удалён — теперь чистим оставшийся cloud state. Если что-то падает,
        // это уже не блокер: аккаунта нет, оставшиеся orphan-записи безопасны
        // (никто не сможет к ним привязаться через uid). Лог для диагностики.
        runCatching { firestore.collection("users").document(uid).delete().await() }
            .onFailure { Log.w(TAG, "Firestore /users/$uid cleanup failed", it) }

        runCatching { cleanupMatchmakingLobby(uid) }
            .onFailure { Log.w(TAG, "RTDB matchmaking_lobby cleanup failed", it) }

        return Result.Success
    }

    /**
     * Удаляет персональные ноды пользователя в matchmaking_lobby.
     * Layout (см. MatchmakingRepository):
     *   /matchmaking_lobby/{lang}_data_{uid} — личные данные слота, удаляем
     *   /matchmaking_lobby/{lang}/slot       — общий слот; чистим если в нём наш uid
     */
    private suspend fun cleanupMatchmakingLobby(uid: String) {
        val lobbyRef = database.getReference("matchmaking_lobby")
        val snap = lobbyRef.get().await()
        val suffix = "_data_$uid"
        for (child in snap.children) {
            val key = child.key ?: continue
            if (key.endsWith(suffix)) {
                lobbyRef.child(key).removeValue().await()
                continue
            }
            // {lang} нода с подписями slot.uid — если slot держится за нами, очищаем
            val slotUid = child.child("slot").child("uid").getValue(String::class.java)
            if (slotUid == uid) {
                lobbyRef.child("$key/slot").removeValue().await()
            }
        }
    }
}
