package com.example.kartonki.data.remote

import com.example.kartonki.data.remote.model.MatchmakingEntry
import com.example.kartonki.data.remote.model.OnlineMatchData
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
import java.util.concurrent.atomic.AtomicBoolean
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
 *        - Slot empty  → claim it (write own uid, clear matchId). Become the Waiter.
 *        - Slot taken  → leave it unchanged.                      Become the Creator.
 *   3. Waiter  — adds a slot listener ONLY AFTER the transaction confirms the claim,
 *                so the listener never sees a stale matchId from a previous session.
 *                After reading the matchId, removes the slot so the next search is clean.
 *   4. Creator — reads opponent's card data, creates the match document,
 *                writes matchId back to the slot so the Waiter can navigate.
 *
 * The Transaction ensures exactly one player claims the slot even when both
 * arrive simultaneously. Adding the slot listener post-transaction eliminates
 * the "stale slot" bug where the listener fired on a cached matchId from the
 * previous game, causing an immediate false "match found" result.
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
        // flowClosed gates the Creator's deferred work (opponent-data read + match-doc
        // setValue success callback). Without this, cancelling the search AFTER the
        // transaction committed but BEFORE the match document was created would still
        // create the match in Firebase — Waiter would then navigate into a no-show game.
        val flowClosed = AtomicBoolean(false)

        // Shared cleanup: remove my personal data node when done or cancelled.
        val cleanup: () -> Unit = { myDataRef.removeValue() }

        // Slot listener is only registered if we become the Waiter (after the transaction
        // confirms the slot is ours with matchId cleared). Keeping a reference so
        // awaitClose can deregister it in all exit paths.
        var slotListener: ValueEventListener? = null

        // Creator's opponent-data single-value listener — kept so awaitClose can remove
        // it before opponent data arrives. Firebase auto-removes after fire, but if we
        // cancel between addListenerForSingleValueEvent and the actual fire, we want to
        // detach it so the Creator's onDataChange body never runs.
        var creatorDataRef: com.google.firebase.database.DatabaseReference? = null
        var creatorDataListener: ValueEventListener? = null

        trySend(MatchmakingResult.Searching)

        // ── Step 1: Write card data BEFORE touching the slot ──────────────────
        myDataRef.setValue(mapOf(
            "playerName" to entry.playerName,
            "cardIds"    to entry.cardIds,
            "timestamp"  to entry.timestamp,
        )).addOnSuccessListener {

            // ── Step 2: Transaction — atomically claim the slot ───────────────
            slotRef.runTransaction(object : Transaction.Handler {

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
                        //
                        // IMPORTANT: The listener is registered HERE, after the transaction,
                        // not at the top of findMatch. The transaction already wrote
                        // matchId=null into the slot, so the first Firebase event will
                        // reflect that clean state — no stale matchId from a previous
                        // session can trigger a false "match found".
                        val listener = object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (done) return
                                val uid     = snapshot.child("uid").getValue(String::class.java)
                                val matchId = snapshot.child("matchId").getValue(String::class.java)
                                if (uid == entry.uid && matchId != null) {
                                    done = true
                                    val myIdx = snapshot.child("myIndex")
                                        .getValue(Long::class.java)?.toInt() ?: 1
                                    // Remove slot immediately so the next search starts clean.
                                    slotRef.removeValue()
                                    trySend(MatchmakingResult.Found(matchId, myIdx))
                                    cleanup()
                                }
                            }
                            override fun onCancelled(error: DatabaseError) {
                                trySend(MatchmakingResult.Error(error.message))
                            }
                        }
                        slotListener = listener
                        slotRef.addValueEventListener(listener)
                        return
                    }

                    // ── Creator path ─────────────────────────────────────────
                    done = true
                    val opponentUid = slotUid

                    val opponentDataRef = lobbyRef.child("${entry.languagePair}_data_${opponentUid}")
                    creatorDataRef = opponentDataRef
                    val creatorListener = object : ValueEventListener {
                            override fun onDataChange(snap: DataSnapshot) {
                                if (flowClosed.get()) return
                                val opponentName  = snap.child("playerName").getValue(String::class.java) ?: "Игрок"
                                val opponentCards = snap.child("cardIds").value.toCardIdList()

                                // The Waiter may have cancelled and removed their data node
                                // between our slot-claim and this read. Creating a match with
                                // an empty opponent deck drops the Creator into a broken,
                                // instantly-ending game — bail to Error instead.
                                if (!snap.exists() || opponentCards.isEmpty()) {
                                    trySend(MatchmakingResult.Error("Соперник отменил поиск"))
                                    return
                                }

                                val newMatchId = matchesRef.push().key
                                if (newMatchId == null) {
                                    trySend(MatchmakingResult.Error("Не удалось зарезервировать matchId"))
                                    return
                                }
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
                                    "roundStartTime"      to ServerValue.TIMESTAMP,
                                    "currentRound"        to null,
                                    "winnerIndex"         to -1,
                                )

                                matchesRef.child(newMatchId).setValue(matchData)
                                    .addOnSuccessListener {
                                        // Gate: if the user cancelled the search between transaction
                                        // and Firebase confirming the doc write, don't notify Waiter
                                        // (slot has already been cleaned, or will be by awaitClose).
                                        if (flowClosed.get()) return@addOnSuccessListener
                                        // Write matchId into the slot → Waiter's listener fires.
                                        slotRef.setValue(mapOf(
                                            "uid"     to opponentUid,
                                            "matchId" to newMatchId,
                                            "myIndex" to 1,
                                        ))
                                        // Creator is player 1 (index 0) — navigate immediately.
                                        trySend(MatchmakingResult.Found(newMatchId, 0))
                                        cleanup()
                                    }
                                    .addOnFailureListener { e ->
                                        if (flowClosed.get()) return@addOnFailureListener
                                        trySend(MatchmakingResult.Error("Match creation failed: ${e.message}"))
                                    }
                            }
                            override fun onCancelled(error: DatabaseError) {
                                if (flowClosed.get()) return
                                trySend(MatchmakingResult.Error(error.message))
                            }
                        }
                    creatorDataListener = creatorListener
                    opponentDataRef.addListenerForSingleValueEvent(creatorListener)
                }
            }, false) // applyLocally=false: use committed server state, not local cache
        }

        awaitClose {
            flowClosed.set(true)
            slotListener?.let { slotRef.removeEventListener(it) }
            // Detach the Creator's single-value listener if it hasn't fired yet —
            // Firebase auto-removes after fire but holds it until then. Without this,
            // a late onDataChange could still create a match doc for a cancelled search.
            val cListener = creatorDataListener
            val cRef      = creatorDataRef
            if (cListener != null && cRef != null) cRef.removeEventListener(cListener)
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
}

// Firebase can return arrays as List<Long>, List<Int>, ArrayList<Any>, or HashMap<String, Any>.
// The Map case happens when Firebase stores a list as {"0": v0, "1": v1, ...} and returns it
// via .value as a HashMap — this is the root cause of Player 2's card IDs being read as empty.
private fun Any?.toCardIdList(): List<Long> =
    when (this) {
        is List<*> -> mapNotNull { (it as? Long) ?: (it as? Int)?.toLong() }
        is Map<*, *> -> values.mapNotNull { (it as? Long) ?: (it as? Int)?.toLong() }
        else -> emptyList()
    }
