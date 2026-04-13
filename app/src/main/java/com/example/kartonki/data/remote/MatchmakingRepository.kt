package com.example.kartonki.data.remote

import com.example.kartonki.data.remote.model.MatchmakingEntry
import com.example.kartonki.data.remote.model.OnlineMatchData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.MutableData
import com.google.firebase.database.Transaction
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

sealed class MatchmakingResult {
    object Searching : MatchmakingResult()
    data class Found(val matchId: String, val myIndex: Int) : MatchmakingResult()
    data class Error(val message: String) : MatchmakingResult()
}

/**
 * Two-phase matchmaking using a single shared lobby slot per language pair.
 *
 * Path layout:
 *   /matchmaking_lobby/{lang}/slot          — atomic slot: who is waiting
 *   /matchmaking_lobby/{lang}_data_{uid}    — player card data (written first)
 *   /matches/{matchId}                      — active game document
 *
 * Protocol:
 *   1. Each player writes their card data to their personal data node.
 *   2. Each player runs a Firebase Transaction on the slot:
 *        - Slot empty  → claim it (write own uid). Become the Waiter.
 *        - Slot taken  → leave it unchanged.          Become the Creator.
 *   3. Waiter  — listens on the slot for matchId to appear.
 *   4. Creator — reads opponent's card data, creates the match document,
 *                writes matchId back to the slot so the Waiter can navigate.
 *
 * The Transaction ensures exactly one player claims the slot even when both
 * arrive simultaneously (Firebase retries on conflict with fresh server data).
 */
@Singleton
class MatchmakingRepository @Inject constructor(
    private val database: FirebaseDatabase,
) {
    private val lobbyRef   get() = database.getReference("matchmaking_lobby")
    private val matchesRef get() = database.getReference("matches")

    fun findMatch(entry: MatchmakingEntry): Flow<MatchmakingResult> = callbackFlow {
        val slotRef   = lobbyRef.child("${entry.languagePair}/slot")
        val myDataRef = lobbyRef.child("${entry.languagePair}_data_${entry.uid}")
        var done = false

        // Shared cleanup: remove my personal data node when done or cancelled.
        val cleanup: () -> Unit = { myDataRef.removeValue() }

        trySend(MatchmakingResult.Searching)

        // ── Listener: waiter path — fires when creator writes matchId ─────────
        val slotListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (done) return
                val slotUid = snapshot.child("uid").getValue(String::class.java)
                val matchId = snapshot.child("matchId").getValue(String::class.java)
                if (slotUid == entry.uid && matchId != null) {
                    done = true
                    val myIdx = snapshot.child("myIndex").getValue(Long::class.java)?.toInt() ?: 1
                    trySend(MatchmakingResult.Found(matchId, myIdx))
                    cleanup()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                trySend(MatchmakingResult.Error(error.message))
            }
        }
        slotRef.addValueEventListener(slotListener)

        // ── Step 1: Write card data BEFORE touching the slot ──────────────────
        // The creator reads this when building the match document.
        // applyLocally is irrelevant here; we chain on addOnSuccessListener to
        // guarantee the data exists on the server before the transaction runs.
        myDataRef.setValue(mapOf(
            "playerName" to entry.playerName,
            "cardIds"    to entry.cardIds,
            "timestamp"  to entry.timestamp,
        )).addOnSuccessListener {

            // ── Step 2: Transaction — atomically claim the slot ───────────────
            slotRef.runTransaction(object : Transaction.Handler {

                // doTransaction may be called multiple times (Firebase retries on
                // conflict). Must handle null currentData (local cache miss).
                override fun doTransaction(currentData: MutableData): Transaction.Result {
                    val slotUid = currentData.child("uid").getValue(String::class.java)
                    val matchId = currentData.child("matchId").getValue(String::class.java)

                    return when {
                        // Empty slot or stale completed-match entry — claim it.
                        slotUid == null || matchId != null || slotUid == entry.uid -> {
                            currentData.child("uid").value     = entry.uid
                            currentData.child("matchId").value = null
                            currentData.child("myIndex").value = null
                            Transaction.success(currentData)
                        }
                        // Someone else is waiting — don't change, just observe.
                        else -> Transaction.success(currentData)
                    }
                }

                override fun onComplete(
                    error: DatabaseError?,
                    committed: Boolean,
                    currentData: DataSnapshot?,
                ) {
                    if (done) return
                    if (error != null || currentData == null) {
                        trySend(MatchmakingResult.Error(error?.message ?: "Transaction failed"))
                        return
                    }

                    val slotUid = currentData.child("uid").getValue(String::class.java)

                    if (slotUid == entry.uid || slotUid == null) {
                        // I claimed the slot — become the Waiter.
                        // slotListener above fires when the Creator writes matchId.
                        return
                    }

                    // ── Creator path ─────────────────────────────────────────
                    // Someone else is in the slot; I create the match.
                    done = true
                    val opponentUid = slotUid

                    lobbyRef.child("${entry.languagePair}_data_${opponentUid}")
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snap: DataSnapshot) {
                                val opponentName  = snap.child("playerName").getValue(String::class.java) ?: "Игрок"
                                val opponentCards = snap.child("cardIds").value.toCardIdList()

                                val newMatchId = matchesRef.push().key ?: return
                                val matchData = mapOf(
                                    "matchId"             to newMatchId,
                                    "player1Uid"          to entry.uid,
                                    "player2Uid"          to opponentUid,
                                    "player1Name"         to entry.playerName,
                                    "player2Name"         to opponentName,
                                    "player1CardIds"      to entry.cardIds,
                                    "player2CardIds"      to opponentCards,
                                    "player1RemainingIds" to entry.cardIds,
                                    "player2RemainingIds" to opponentCards,
                                    "status"              to OnlineMatchData.STATUS_ACTIVE,
                                    "currentTurn"         to 0,
                                    "phase"               to OnlineMatchData.PHASE_HAND_SELECTION,
                                    "player1Score"        to 0,
                                    "player2Score"        to 0,
                                    "player1Streak"       to 0,
                                    "player2Streak"       to 0,
                                    "roundStartTime"      to System.currentTimeMillis(),
                                    "currentRound"        to null,
                                    "winnerIndex"         to -1,
                                )

                                // Commit the match document first; only then signal the Waiter.
                                matchesRef.child(newMatchId).setValue(matchData)
                                    .addOnSuccessListener {
                                        // Write matchId into the slot → Waiter's slotListener fires.
                                        slotRef.setValue(mapOf(
                                            "uid"     to opponentUid,
                                            "matchId" to newMatchId,
                                            "myIndex" to 1,           // Waiter is player 2
                                        ))
                                        // Creator is player 1 (index 0) — navigate immediately.
                                        trySend(MatchmakingResult.Found(newMatchId, 0))
                                        cleanup()
                                    }
                                    .addOnFailureListener { e ->
                                        trySend(MatchmakingResult.Error("Match creation failed: ${e.message}"))
                                    }
                            }
                            override fun onCancelled(error: DatabaseError) {
                                trySend(MatchmakingResult.Error(error.message))
                            }
                        })
                }
            }, false) // applyLocally=false: use committed server state, not local cache
        }

        awaitClose {
            slotRef.removeEventListener(slotListener)
            cleanup()
            // Remove from slot only if I'm still the Waiter with no match assigned.
            slotRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val uid     = snapshot.child("uid").getValue(String::class.java)
                    val matchId = snapshot.child("matchId").getValue(String::class.java)
                    if (uid == entry.uid && matchId == null) slotRef.removeValue()
                }
                override fun onCancelled(error: DatabaseError) {}
            })
        }
    }

    suspend fun leaveQueue(uid: String) { /* cleanup is handled by awaitClose */ }
}

// Firebase can return integer lists as List<Long>, List<Int>, or ArrayList<Any>
private fun Any?.toCardIdList(): List<Long> =
    (this as? List<*>)?.mapNotNull {
        (it as? Long) ?: (it as? Int)?.toLong()
    } ?: emptyList()
