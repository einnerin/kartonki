package com.example.kartonki.data.remote

import org.junit.Assert.assertEquals
import org.junit.Test

class MatchFinalizerTest {

    @Test fun byScore_player1Higher_winsPlayer1() {
        assertEquals(0, MatchFinalizer.resolveWinner(FinalOutcome.ByScore, player1Score = 30, player2Score = 10))
    }

    @Test fun byScore_player2Higher_winsPlayer2() {
        assertEquals(1, MatchFinalizer.resolveWinner(FinalOutcome.ByScore, player1Score = 10, player2Score = 30))
    }

    @Test fun byScore_tie_isDraw() {
        assertEquals(-1, MatchFinalizer.resolveWinner(FinalOutcome.ByScore, player1Score = 20, player2Score = 20))
    }

    @Test fun byScore_bothZero_isDraw() {
        assertEquals(-1, MatchFinalizer.resolveWinner(FinalOutcome.ByScore, player1Score = 0, player2Score = 0))
    }

    @Test fun explicitWinner_overridesScore() {
        // Surrender / disconnect-forfeit: the named player wins even with a lower score.
        assertEquals(1, MatchFinalizer.resolveWinner(FinalOutcome.Winner(1), player1Score = 99, player2Score = 0))
        assertEquals(0, MatchFinalizer.resolveWinner(FinalOutcome.Winner(0), player1Score = 0, player2Score = 99))
    }

    @Test fun draw_isAlwaysMinusOne() {
        assertEquals(-1, MatchFinalizer.resolveWinner(FinalOutcome.Draw, player1Score = 50, player2Score = 0))
    }
}
