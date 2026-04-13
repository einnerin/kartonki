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
    private val queueRef get() = database.getReference("matchmaking")
    private val matchesRef get() = database.getReference("matches")

    fun findMatch(entry: MatchmakingEntry): Flow<MatchmakingResult> = callbackFlow {
        val myRef = queueRef.child(entry.uid)

        // Write own queue entry
        val entryMap = mapOf(
            "uid" to entry.uid,
            "playerName" to entry.playerName,
            "deckId" to entry.deckId,
            "deckName" to entry.deckName,
            "deckLevel" to entry.deckLevel,
            "languagePair" to entry.languagePair,
            "cardIds" to entry.cardIds,
            "timestamp" to entry.timestamp,
        )
        myRef.setValue(entryMap).await()
        trySend(MatchmakingResult.Searching)

        // Listen for matchId appearing on my queue entry (set by whichever client creates the match)
        val myMatchListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val matchId = snapshot.child("matchId").getValue(String::class.java)
                val myIndex = snapshot.child("myIndex").getValue(Long::class.java)?.toInt()
                if (matchId != null && myIndex != null) {
                    trySend(MatchmakingResult.Found(matchId, myIndex))
                }
            }
            override fun onCancelled(error: DatabaseError) {
                trySend(MatchmakingResult.Error(error.message))
            }
        }
        myRef.addValueEventListener(myMatchListener)

        // Try to pair with an opponent. Called both on initial scan and when new entries appear.
        fun tryPairWith(snapshot: DataSnapshot) {
            val uid = snapshot.child("uid").getValue(String::class.java) ?: return
            if (uid == entry.uid) return                                         // skip self
            if (snapshot.child("matchId").getValue(String::class.java) != null) return // already paired
            val lang = snapshot.child("languagePair").getValue(String::class.java)
            if (lang != null && lang != entry.languagePair) return               // different language
            val level = snapshot.child("deckLevel").getValue(Long::class.java)?.toInt()
            if (level != null && level != entry.deckLevel) return                // different level

            val opponentUid = uid
            val opponentName = snapshot.child("playerName").getValue(String::class.java) ?: "Игрок"
            val opponentDeckId = snapshot.child("deckId").getValue(Long::class.java) ?: 0L
            @Suppress("UNCHECKED_CAST")
            val opponentCardIds = (snapshot.child("cardIds").value as? List<Long>) ?: emptyList()

            val matchId = matchesRef.push().key ?: return

            val matchData = mapOf(
                "matchId" to matchId,
                "player1Uid" to entry.uid,
                "player2Uid" to opponentUid,
                "player1Name" to entry.playerName,
                "player2Name" to opponentName,
                "player1CardIds" to entry.cardIds,
                "player2CardIds" to opponentCardIds,
                "player1RemainingIds" to entry.cardIds,
                "player2RemainingIds" to opponentCardIds,
                "status" to OnlineMatchData.STATUS_ACTIVE,
                "currentTurn" to 0,
                "phase" to OnlineMatchData.PHASE_HAND_SELECTION,
                "player1Score" to 0,
                "player2Score" to 0,
                "player1Streak" to 0,
                "player2Streak" to 0,
                "roundStartTime" to System.currentTimeMillis(),
                "currentRound" to null,
                "winnerIndex" to -1,
            )
            matchesRef.child(matchId).setValue(matchData)
            // I am player1 (index 0), opponent is player2 (index 1)
            myRef.updateChildren(mapOf("matchId" to matchId, "myIndex" to 0))
            queueRef.child(opponentUid).updateChildren(mapOf("matchId" to matchId, "myIndex" to 1))
        }

        // Initial scan: find anyone already in the queue
        queueRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach { tryPairWith(it) }
            }
            override fun onCancelled(error: DatabaseError) {}
        })

        // Reactive: pair with any new player who joins after us
        val childListener = object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                tryPairWith(snapshot)
            }
            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        }
        queueRef.addChildEventListener(childListener)

        awaitClose {
            myRef.removeEventListener(myMatchListener)
            queueRef.removeEventListener(childListener)
        }
    }

    suspend fun leaveQueue(uid: String) {
        queueRef.child(uid).removeValue().await()
    }
}
