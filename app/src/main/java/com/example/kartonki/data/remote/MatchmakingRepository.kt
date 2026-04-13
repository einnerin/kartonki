package com.example.kartonki.data.remote

import com.example.kartonki.data.remote.model.MatchmakingEntry
import com.example.kartonki.data.remote.model.OnlineMatchData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
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
 * Simple single-slot matchmaking:
 *
 *   /lobby/{languagePair}  — one shared slot per language pair
 *
 * First player writes their info and waits.
 * Second player reads the slot, creates the match, writes matchId back.
 * Both navigate when they have a matchId.
 *
 * No per-user queue reads required — only one shared path is ever read.
 */
@Singleton
class MatchmakingRepository @Inject constructor(
    private val database: FirebaseDatabase,
) {
    private val lobbyRef   get() = database.getReference("lobby")
    private val matchesRef get() = database.getReference("matches")

    fun findMatch(entry: MatchmakingEntry): Flow<MatchmakingResult> = callbackFlow {
        val slotRef = lobbyRef.child(entry.languagePair)
        var done = false

        trySend(MatchmakingResult.Searching)

        // ── Persistent listener on the lobby slot ────────────────────────────
        val slotListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (done) return
                val slotUid  = snapshot.child("uid").getValue(String::class.java)
                val matchId  = snapshot.child("matchId").getValue(String::class.java)

                // Case A: I'm the waiter and the creator wrote a matchId for me
                if (slotUid == entry.uid && matchId != null) {
                    done = true
                    val myIdx = snapshot.child("myIndex").getValue(Long::class.java)?.toInt() ?: 1
                    trySend(MatchmakingResult.Found(matchId, myIdx))
                    return
                }

                // Case B: Someone else is waiting (no matchId yet) — I create the match
                if (slotUid != null && slotUid != entry.uid && matchId == null) {
                    done = true
                    val opponentUid   = slotUid
                    val opponentName  = snapshot.child("playerName").getValue(String::class.java) ?: "Игрок"
                    val opponentCards = snapshot.child("cardIds").value.toCardIdList()

                    val newMatchId = matchesRef.push().key ?: return
                    val matchData = mapOf(
                        "matchId"             to newMatchId,
                        "player1Uid"          to entry.uid,        // I am player 1 (index 0)
                        "player2Uid"          to opponentUid,      // Waiter is player 2 (index 1)
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
                    matchesRef.child(newMatchId).setValue(matchData).addOnSuccessListener {
                        // Tell the waiter (player 2, index 1) their matchId via the slot
                        slotRef.updateChildren(mapOf("matchId" to newMatchId, "myIndex" to 1))
                        // I am player 1 (index 0) — navigate immediately
                        trySend(MatchmakingResult.Found(newMatchId, 0))
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(MatchmakingResult.Error(error.message))
            }
        }
        slotRef.addValueEventListener(slotListener)

        // ── Try to claim the slot as the first waiter ────────────────────────
        // If the slot is empty or has a stale/completed entry, write ourselves.
        // If someone else is already waiting, the persistent listener above handles it.
        slotRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (done) return
                val existingUid     = snapshot.child("uid").getValue(String::class.java)
                val existingMatchId = snapshot.child("matchId").getValue(String::class.java)
                // Claim the slot if it's free, stale (has matchId = already matched pair), or mine
                if (existingUid == null || existingMatchId != null || existingUid == entry.uid) {
                    slotRef.setValue(mapOf(
                        "uid"        to entry.uid,
                        "playerName" to entry.playerName,
                        "cardIds"    to entry.cardIds,
                        "timestamp"  to entry.timestamp,
                    ))
                }
                // If existingUid != null and no matchId: persistent listener already triggered Case B
            }
            override fun onCancelled(error: DatabaseError) {}
        })

        awaitClose {
            slotRef.removeEventListener(slotListener)
            // Clean up: remove the slot only if we're still the waiter with no match
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

    suspend fun leaveQueue(uid: String) {
        // No-op: awaitClose cleanup in findMatch handles slot removal
    }
}

// Firebase can return card-ID lists as List<Long>, List<Int>, or ArrayList<Any>
private fun Any?.toCardIdList(): List<Long> =
    (this as? List<*>)?.mapNotNull {
        (it as? Long) ?: (it as? Int)?.toLong()
    } ?: emptyList()
