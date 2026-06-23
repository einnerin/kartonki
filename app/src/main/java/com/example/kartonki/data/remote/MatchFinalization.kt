package com.example.kartonki.data.remote

/**
 * How an online match's winner is decided when it ends. Kept separate from the
 * Firebase layer so the resolution rule is a pure, unit-testable function.
 */
sealed interface FinalOutcome {
    /** Normal end: winner is whoever has the higher final score; equal = draw. */
    object ByScore : FinalOutcome
    /** Forced end (surrender / disconnect-forfeit): a specific player wins regardless of score. */
    data class Winner(val index: Int) : FinalOutcome
    /** No winner (both players abandoned) — no rating change for either side. */
    object Draw : FinalOutcome
}

object MatchFinalizer {
    /**
     * Pure winner resolution. Returns player index 0 or 1, or -1 for a draw.
     * For [FinalOutcome.ByScore] the decision uses the two final scores so it is
     * identical no matter which client computes it (no reliance on a possibly-stale
     * local snapshot of the opponent's score).
     */
    fun resolveWinner(outcome: FinalOutcome, player1Score: Int, player2Score: Int): Int =
        when (outcome) {
            is FinalOutcome.Winner -> outcome.index
            FinalOutcome.Draw -> -1
            FinalOutcome.ByScore -> when {
                player1Score > player2Score -> 0
                player2Score > player1Score -> 1
                else -> -1
            }
        }
}
