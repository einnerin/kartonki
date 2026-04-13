package com.example.kartonki.data.remote

import com.example.kartonki.data.remote.model.MatchmakingEntry
import com.example.kartonki.data.remote.model.OnlineMatchData
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

sealed class MatchmakingResult {
    object Searching : MatchmakingResult()
    data class Found(val matchId: String, val myIndex: Int) : MatchmakingResult()
    data class Error(val message: String) : MatchmakingResult()
}

@Singleton
class MatchmakingRepository @Inject constructor(
    private val database: FirebaseDatabase,
) {
    private val queueRef   get() = database.getReference("matchmaking")
    private val matchesRef get() = database.getReference("matches")

    fun findMatch(entry: MatchmakingEntry): Flow<MatchmakingResult> = callbackFlow {
        val myRef = queueRef.child(entry.uid)

        val entryMap = mapOf(
            "uid"          to entry.uid,
            "playerName"   to entry.playerName,
            "deckId"       to entry.deckId,
            "deckName"     to entry.deckName,
            "deckLevel"    to entry.deckLevel,
            "languagePair" to entry.languagePair,
            "cardIds"      to entry.cardIds,
            "timestamp"    to entry.timestamp,
        )
        myRef.setValue(entryMap).await()
        trySend(MatchmakingResult.Searching)

        // ── Listener: matchId written to MY OWN entry ───────────────────────
        // Happens either by me (after I create the match) or by the opponent
        // via a cross-user write (if Firebase rules allow it).
        val myMatchListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val matchId = snapshot.child("matchId").getValue(String::class.java) ?: return
                val myIndex = snapshot.child("myIndex").getValue(Long::class.java)?.toInt() ?: return
                trySend(MatchmakingResult.Found(matchId, myIndex))
            }
            override fun onCancelled(error: DatabaseError) {
                trySend(MatchmakingResult.Error(error.message))
            }
        }
        myRef.addValueEventListener(myMatchListener)

        // ── Find a match in the matches collection by UID ───────────────────
        // Fallback for the early-joiner when cross-user writes are blocked.
        fun checkMatchForMe(matchId: String) {
            matchesRef.child(matchId).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snap: DataSnapshot) {
                    val p1Uid = snap.child("player1Uid").getValue(String::class.java)
                    val p2Uid = snap.child("player2Uid").getValue(String::class.java)
                    val myIdx = when (entry.uid) {
                        p1Uid -> 0
                        p2Uid -> 1
                        else  -> return  // not our match
                    }
                    trySend(MatchmakingResult.Found(matchId, myIdx))
                }
                override fun onCancelled(error: DatabaseError) {}
            })
        }

        // ── Create the match (called only by the LATER joiner) ──────────────
        // Using timestamp to decide who creates avoids the race condition where
        // both phones see each other and both try to create simultaneously.
        fun tryPairWith(snapshot: DataSnapshot) {
            val opponentUid = snapshot.child("uid").getValue(String::class.java) ?: return
            if (opponentUid == entry.uid) return                                         // skip self
            if (snapshot.child("matchId").getValue(String::class.java) != null) return  // already paired

            val lang = snapshot.child("languagePair").getValue(String::class.java)
            if (lang != null && lang != entry.languagePair) return                       // different language

            val opponentTimestamp = snapshot.child("timestamp").getValue(Long::class.java) ?: 0L

            // Only the LATER joiner (higher timestamp) creates the match.
            // Tiebreak by UID string comparison so exactly one phone "wins".
            val iCreate = entry.timestamp > opponentTimestamp ||
                (entry.timestamp == opponentTimestamp && entry.uid > opponentUid)
            if (!iCreate) return  // the other phone will create

            val opponentName    = snapshot.child("playerName").getValue(String::class.java) ?: "Игрок"
            val opponentCardIds = snapshot.child("cardIds").value.toCardIdList()

            val matchId = matchesRef.push().key ?: return

            val matchData = mapOf(
                "matchId"              to matchId,
                "player1Uid"           to entry.uid,
                "player2Uid"           to opponentUid,
                "player1Name"          to entry.playerName,
                "player2Name"          to opponentName,
                "player1CardIds"       to entry.cardIds,
                "player2CardIds"       to opponentCardIds,
                "player1RemainingIds"  to entry.cardIds,
                "player2RemainingIds"  to opponentCardIds,
                "status"               to OnlineMatchData.STATUS_ACTIVE,
                "currentTurn"          to 0,
                "phase"                to OnlineMatchData.PHASE_HAND_SELECTION,
                "player1Score"         to 0,
                "player2Score"         to 0,
                "player1Streak"        to 0,
                "player2Streak"        to 0,
                "roundStartTime"       to System.currentTimeMillis(),
                "currentRound"         to null,
                "winnerIndex"          to -1,
            )
            matchesRef.child(matchId).setValue(matchData)
            // I am player1 (index 0)
            myRef.updateChildren(mapOf("matchId" to matchId, "myIndex" to 0))
            // Write to opponent's entry (player2, index 1).
            // May be blocked by Firebase rules — that's OK:
            // the opponent discovers the match via onChildChanged → checkMatchForMe().
            queueRef.child(opponentUid).updateChildren(mapOf("matchId" to matchId, "myIndex" to 1))
        }

        // ── Queue listener ───────────────────────────────────────────────────
        val childListener = object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                tryPairWith(snapshot)
            }
            // Opponent wrote matchId to THEIR OWN entry → we're the early joiner,
            // find our index by reading the match document directly.
            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                val opponentUid = snapshot.child("uid").getValue(String::class.java) ?: return
                if (opponentUid == entry.uid) return
                val matchId = snapshot.child("matchId").getValue(String::class.java) ?: return
                checkMatchForMe(matchId)
            }
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        }
        queueRef.addChildEventListener(childListener)

        // Initial scan for anyone already waiting
        queueRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach { tryPairWith(it) }
            }
            override fun onCancelled(error: DatabaseError) {}
        })

        awaitClose {
            myRef.removeEventListener(myMatchListener)
            queueRef.removeEventListener(childListener)
        }
    }

    suspend fun leaveQueue(uid: String) {
        queueRef.child(uid).removeValue().await()
    }
}

// Firebase can return card ID lists as List<Long>, List<Int>, or ArrayList<Any>
private fun Any?.toCardIdList(): List<Long> =
    (this as? List<*>)?.mapNotNull {
        (it as? Long) ?: (it as? Int)?.toLong()
    } ?: emptyList()
