package com.example.kartonki.data.remote

import com.example.kartonki.data.remote.model.OnlineMatchData
import com.example.kartonki.data.remote.model.OnlineRoundData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OnlineGameRepository @Inject constructor(
    private val database: FirebaseDatabase,
) {
    private fun matchRef(matchId: String) = database.getReference("matches").child(matchId)

    /** Listens to game state updates in real time. */
    fun listenToMatch(matchId: String): Flow<OnlineMatchData?> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (!snapshot.exists()) { trySend(null); return }
                trySend(snapshot.toMatchData())
            }
            override fun onCancelled(error: DatabaseError) { trySend(null) }
        }
        matchRef(matchId).addValueEventListener(listener)
        awaitClose { matchRef(matchId).removeEventListener(listener) }
    }

    /** Attacker submits card pick + quiz data. */
    suspend fun submitCardPick(
        matchId: String,
        attackerIndex: Int,
        round: OnlineRoundData,
        newRemainingIds: List<Long>,
        playerIndex: Int,
    ) {
        val roundMap = mapOf(
            "playedCardId"          to round.playedCardId,
            "attackerIndex"         to round.attackerIndex,
            "question"              to round.question,
            "questionLabel"         to round.questionLabel,
            "options"               to round.options,
            "correctAnswer"         to round.correctAnswer,
            "selectedAnswer"        to "",
            "playedCardOriginal"    to round.playedCardOriginal,
            "playedCardTranslation" to round.playedCardTranslation,
        )
        val remainingKey = if (playerIndex == 0) "player1RemainingIds" else "player2RemainingIds"
        matchRef(matchId).updateChildren(
            mapOf(
                "phase" to OnlineMatchData.PHASE_QUIZ,
                "currentRound" to roundMap,
                "roundStartTime" to System.currentTimeMillis(),
                remainingKey to newRemainingIds,
            )
        ).await()
    }

    /**
     * Registers a server-side onDisconnect handler so Firebase automatically writes
     * the disconnect timestamp if the client loses connection for ANY reason — including
     * crash, phone death, or internet loss while the app stays in the foreground.
     *
     * Must be called every time the player (re-)enters the foreground, because Firebase
     * cancels the registered handler on reconnect and it needs to be re-queued.
     */
    fun registerDisconnectHandler(matchId: String, playerIndex: Int) {
        val key = if (playerIndex == 0) "player1DisconnectedAt" else "player2DisconnectedAt"
        matchRef(matchId).child(key).onDisconnect().setValue(ServerValue.TIMESTAMP)
    }

    /** Marks a player as disconnected (app went to background / closed). */
    suspend fun reportDisconnect(matchId: String, playerIndex: Int, timestamp: Long) {
        val key = if (playerIndex == 0) "player1DisconnectedAt" else "player2DisconnectedAt"
        matchRef(matchId).child(key).setValue(timestamp).await()
    }

    /** Clears the disconnected flag and re-registers the onDisconnect handler when the player returns. */
    suspend fun clearDisconnect(matchId: String, playerIndex: Int) {
        val key = if (playerIndex == 0) "player1DisconnectedAt" else "player2DisconnectedAt"
        matchRef(matchId).child(key).setValue(0L).await()
        // Re-register after reconnect — Firebase cancels the handler when connection is restored.
        registerDisconnectHandler(matchId, playerIndex)
    }

    /**
     * Fire-and-forget version of clearDisconnect for use in ViewModel.onCleared()
     * where the coroutine scope is already cancelled.
     */
    fun clearDisconnectSync(matchId: String, playerIndex: Int) {
        val key = if (playerIndex == 0) "player1DisconnectedAt" else "player2DisconnectedAt"
        matchRef(matchId).child(key).setValue(0L)
        // onDisconnect re-registration is intentionally skipped here:
        // onCleared means the ViewModel is going away, so no need to guard against future disconnects.
    }

    /** Defender submits their answer selection. */
    suspend fun submitAnswer(matchId: String, answer: String) {
        matchRef(matchId).child("currentRound").child("selectedAnswer").setValue(answer).await()
    }

    /** Confirm answer and advance to next turn. */
    suspend fun confirmAnswer(
        matchId: String,
        p1Score: Int,
        p2Score: Int,
        p1Streak: Int,
        p2Streak: Int,
        nextTurn: Int,
        nextPhase: String,
        isGameOver: Boolean,
        winnerIndex: Int,
    ) {
        val updates = mutableMapOf<String, Any>(
            "player1Score" to p1Score,
            "player2Score" to p2Score,
            "player1Streak" to p1Streak,
            "player2Streak" to p2Streak,
            "currentTurn" to nextTurn,
            "phase" to nextPhase,
            "roundStartTime" to System.currentTimeMillis(),
        )
        if (isGameOver) {
            updates["status"] = OnlineMatchData.STATUS_FINISHED
            updates["winnerIndex"] = winnerIndex
        }
        matchRef(matchId).updateChildren(updates).await()
    }

    private fun DataSnapshot.toMatchData(): OnlineMatchData {
        val p1Cards    = child("player1CardIds").toCardIdList()
        val p2Cards    = child("player2CardIds").toCardIdList()
        val p1Remaining = child("player1RemainingIds").toCardIdList().ifEmpty { p1Cards }
        val p2Remaining = child("player2RemainingIds").toCardIdList().ifEmpty { p2Cards }

        val roundSnap = child("currentRound")
        val round = if (roundSnap.exists()) {
            val opts = roundSnap.child("options").children
                .mapNotNull { it.getValue(String::class.java) }
            OnlineRoundData(
                playedCardId          = roundSnap.child("playedCardId").getValue(Long::class.java) ?: 0L,
                attackerIndex         = roundSnap.child("attackerIndex").getValue(Long::class.java)?.toInt() ?: 0,
                question              = roundSnap.child("question").getValue(String::class.java) ?: "",
                questionLabel         = roundSnap.child("questionLabel").getValue(String::class.java) ?: "",
                options               = opts,
                correctAnswer         = roundSnap.child("correctAnswer").getValue(String::class.java) ?: "",
                selectedAnswer        = roundSnap.child("selectedAnswer").getValue(String::class.java) ?: "",
                playedCardOriginal    = roundSnap.child("playedCardOriginal").getValue(String::class.java) ?: "",
                playedCardTranslation = roundSnap.child("playedCardTranslation").getValue(String::class.java) ?: "",
            )
        } else null

        return OnlineMatchData(
            matchId = child("matchId").getValue(String::class.java) ?: "",
            player1Uid = child("player1Uid").getValue(String::class.java) ?: "",
            player2Uid = child("player2Uid").getValue(String::class.java) ?: "",
            player1Name = child("player1Name").getValue(String::class.java) ?: "",
            player2Name = child("player2Name").getValue(String::class.java) ?: "",
            player1CardIds = p1Cards,
            player2CardIds = p2Cards,
            player1RemainingIds = p1Remaining,
            player2RemainingIds = p2Remaining,
            status = child("status").getValue(String::class.java) ?: OnlineMatchData.STATUS_ACTIVE,
            currentTurn = child("currentTurn").getValue(Long::class.java)?.toInt() ?: 0,
            phase = child("phase").getValue(String::class.java) ?: OnlineMatchData.PHASE_HAND_SELECTION,
            player1Score = child("player1Score").getValue(Long::class.java)?.toInt() ?: 0,
            player2Score = child("player2Score").getValue(Long::class.java)?.toInt() ?: 0,
            player1Streak = child("player1Streak").getValue(Long::class.java)?.toInt() ?: 0,
            player2Streak = child("player2Streak").getValue(Long::class.java)?.toInt() ?: 0,
            roundStartTime = child("roundStartTime").getValue(Long::class.java) ?: 0L,
            currentRound = round,
            winnerIndex = child("winnerIndex").getValue(Long::class.java)?.toInt() ?: -1,
            player1DisconnectedAt = child("player1DisconnectedAt").getValue(Long::class.java) ?: 0L,
            player2DisconnectedAt = child("player2DisconnectedAt").getValue(Long::class.java) ?: 0L,
        )
    }
}

// Firebase can return integer lists as List<Long>, List<Int>, or ArrayList<Any>
private fun DataSnapshot.toCardIdList(): List<Long> =
    children.mapNotNull { snap ->
        snap.getValue(Long::class.java)
            ?: snap.getValue(Int::class.java)?.toLong()
    }
