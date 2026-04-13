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
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

sealed class MatchmakingResult {
    /** Joined queue, searching */
    object Searching : MatchmakingResult()
    /** Match found — matchId is the key in /matches */
    data class Found(val matchId: String, val myIndex: Int) : MatchmakingResult()
    /** Error */
    data class Error(val message: String) : MatchmakingResult()
}

@Singleton
class MatchmakingRepository @Inject constructor(
    private val database: FirebaseDatabase,
) {
    private val queueRef get() = database.getReference("matchmaking")
    private val matchesRef get() = database.getReference("matches")

    /**
     * Registers the player in the matchmaking queue and listens for a match.
     * Emits [MatchmakingResult.Searching] immediately, then [MatchmakingResult.Found]
     * when paired, or [MatchmakingResult.Error] on failure.
     */
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

        // Listen for a "matchId" field appearing on my queue entry (set by the other client)
        val listener = object : ValueEventListener {
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
        myRef.addValueEventListener(listener)

        // Also try to find an existing opponent in queue with same level AND language
        // Firebase RTDB supports single-field ordering only, so language is filtered client-side
        queueRef.orderByChild("deckLevel").equalTo(entry.deckLevel.toDouble())
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val others = snapshot.children.filter {
                        val uid = it.child("uid").getValue(String::class.java)
                        val matchId = it.child("matchId").getValue(String::class.java)
                        val lang = it.child("languagePair").getValue(String::class.java)
                        uid != null && uid != entry.uid && matchId == null &&
                            (lang == null || lang == entry.languagePair)
                    }
                    if (others.isNotEmpty()) {
                        val opponent = others.first()
                        val opponentUid = opponent.child("uid").getValue(String::class.java) ?: return
                        val opponentName = opponent.child("playerName").getValue(String::class.java) ?: "Игрок"
                        val opponentDeckId = opponent.child("deckId").getValue(Long::class.java) ?: 0L
                        @Suppress("UNCHECKED_CAST")
                        val opponentCardIds = (opponent.child("cardIds").value as? List<Long>) ?: emptyList()

                        val matchId = matchesRef.push().key ?: return
                        val player1Cards = entry.cardIds
                        val player2Cards = opponentCardIds

                        val matchData = mapOf(
                            "matchId" to matchId,
                            "player1Uid" to entry.uid,
                            "player2Uid" to opponentUid,
                            "player1Name" to entry.playerName,
                            "player2Name" to opponentName,
                            "player1CardIds" to player1Cards,
                            "player2CardIds" to player2Cards,
                            "player1RemainingIds" to player1Cards,
                            "player2RemainingIds" to player2Cards,
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

                        // Notify both queue entries
                        queueRef.child(entry.uid).updateChildren(mapOf("matchId" to matchId, "myIndex" to 0))
                        queueRef.child(opponentUid).updateChildren(mapOf("matchId" to matchId, "myIndex" to 1))
                    }
                }
                override fun onCancelled(error: DatabaseError) {}
            })

        awaitClose {
            myRef.removeEventListener(listener)
        }
    }

    suspend fun leaveQueue(uid: String) {
        queueRef.child(uid).removeValue().await()
    }
}
