package com.example.kartonki.data.remote

import android.util.Log
import com.example.kartonki.data.remote.model.OnlineMatchData
import com.example.kartonki.data.remote.model.OnlineRoundData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.MutableData
import com.google.firebase.database.ServerValue
import com.google.firebase.database.Transaction
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

private const val TAG = "OnlineGameRepository"

@Singleton
class OnlineGameRepository @Inject constructor(
    private val database: FirebaseDatabase,
) {
    private fun matchRef(matchId: String) = database.getReference("matches").child(matchId)

    /**
     * Listens to game state updates in real time.
     *
     * Emits `null` for both "match doc deleted" AND "RTDB error / permission denied".
     * The two are conflated by design (the consumer ViewModel treats either as
     * "connection lost"), but the error path now logs the [DatabaseError] detail
     * so transient failures are diagnosable in Logcat / Crashlytics — silent
     * swallow is the worst of both worlds.
     */
    fun listenToMatch(matchId: String): Flow<OnlineMatchData?> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (!snapshot.exists()) { trySend(null); return }
                trySend(snapshot.toMatchData())
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "listenToMatch $matchId cancelled: code=${error.code} msg=${error.message}")
                trySend(null)
            }
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

    /**
     * Push the current player's own progress (score, streak) and shared turn-control
     * fields (currentTurn, phase) for an ONGOING match.
     *
     * Critically: writes only player {myIndex}'s score/streak — never the opponent's.
     * The previous `confirmAnswer(p1Score, p2Score, …)` API read the opponent's score
     * from this client's local snapshot and blind-wrote it back, which let one player's
     * late `updateChildren` clobber a concurrent write by the other. Each player now
     * owns its own `playerN*` fields end-to-end.
     *
     * Game-OVER is handled separately by [finalizeMatch] (an idempotent transaction),
     * NOT here — this method must only be used while the match continues.
     */
    suspend fun pushMyTurn(
        matchId: String,
        myIndex: Int,
        myScore: Int,
        myStreak: Int,
        nextTurn: Int,
        nextPhase: String,
    ) {
        val scoreKey  = if (myIndex == 0) "player1Score"  else "player2Score"
        val streakKey = if (myIndex == 0) "player1Streak" else "player2Streak"
        matchRef(matchId).updateChildren(
            mapOf(
                scoreKey to myScore,
                streakKey to myStreak,
                "currentTurn" to nextTurn,
                "phase" to nextPhase,
                "roundStartTime" to System.currentTimeMillis(),
            )
        ).await()
    }

    /**
     * Idempotently ends the match. Runs an RTDB transaction on the match node so the
     * FIRST finalizer wins: if `status` is already `finished`, it's a complete no-op
     * and returns null — a late surrender / disconnect-forfeit / last-card write can no
     * longer overwrite the real outcome (the previous code used plain `updateChildren`,
     * so last-writer-wins could flip an already-decided winner, and every path
     * unconditionally bumped the player's Firestore W/L even when it didn't actually
     * finalize → double-counted stats).
     *
     * Writes this player's own score/streak as part of the same atomic op, then resolves
     * the winner via [MatchFinalizer] (for [FinalOutcome.ByScore] from the live scores in
     * the transaction, not a stale local snapshot).
     *
     * @return the resolved winnerIndex (0/1, or -1 for draw) if THIS call performed the
     *         finalization — the caller should record its own win/loss/draw stat based on
     *         it — or null if the match was already finished by someone else.
     */
    suspend fun finalizeMatch(
        matchId: String,
        myIndex: Int,
        myScore: Int,
        myStreak: Int,
        outcome: FinalOutcome,
    ): Int? = suspendCancellableCoroutine { cont ->
        val didFinalize = AtomicBoolean(false)
        val resolvedWinner = AtomicInteger(-1)
        matchRef(matchId).runTransaction(object : Transaction.Handler {
            override fun doTransaction(currentData: MutableData): Transaction.Result {
                val status = currentData.child("status").getValue(String::class.java)
                if (status == OnlineMatchData.STATUS_FINISHED) {
                    didFinalize.set(false)
                    return Transaction.success(currentData)   // already finished → no-op
                }
                // Write my own score/streak slot.
                val scoreKey  = if (myIndex == 0) "player1Score"  else "player2Score"
                val streakKey = if (myIndex == 0) "player1Streak" else "player2Streak"
                currentData.child(scoreKey).value  = myScore.toLong()
                currentData.child(streakKey).value = myStreak.toLong()

                val p1 = if (myIndex == 0) myScore
                         else currentData.child("player1Score").getValue(Long::class.java)?.toInt() ?: 0
                val p2 = if (myIndex == 1) myScore
                         else currentData.child("player2Score").getValue(Long::class.java)?.toInt() ?: 0
                val winner = MatchFinalizer.resolveWinner(outcome, p1, p2)

                currentData.child("status").value      = OnlineMatchData.STATUS_FINISHED
                currentData.child("winnerIndex").value  = winner.toLong()
                currentData.child("phase").value        = OnlineMatchData.PHASE_GAME_OVER
                currentData.child("currentTurn").value  = 0L
                resolvedWinner.set(winner)
                didFinalize.set(true)
                return Transaction.success(currentData)
            }

            override fun onComplete(error: DatabaseError?, committed: Boolean, currentData: DataSnapshot?) {
                if (!cont.isActive) return
                when {
                    error != null            -> cont.resumeWithException(error.toException())
                    committed && didFinalize.get() -> cont.resume(resolvedWinner.get())
                    else                     -> cont.resume(null)   // already finished, or not committed
                }
            }
        }, false) // applyLocally=false: decide from committed server state
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
