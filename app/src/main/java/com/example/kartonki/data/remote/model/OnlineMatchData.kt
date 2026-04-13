package com.example.kartonki.data.remote.model

data class OnlineMatchData(
    val matchId: String = "",
    val player1Uid: String = "",
    val player2Uid: String = "",
    val player1Name: String = "",
    val player2Name: String = "",
    val player1CardIds: List<Long> = emptyList(),
    val player2CardIds: List<Long> = emptyList(),
    val status: String = STATUS_ACTIVE,
    val currentTurn: Int = 0,
    val phase: String = PHASE_HAND_SELECTION,
    val player1Score: Int = 0,
    val player2Score: Int = 0,
    val player1Streak: Int = 0,
    val player2Streak: Int = 0,
    val player1RemainingIds: List<Long> = emptyList(),
    val player2RemainingIds: List<Long> = emptyList(),
    val roundStartTime: Long = 0L,
    val currentRound: OnlineRoundData? = null,
    val winnerIndex: Int = -1,
) {
    companion object {
        const val STATUS_ACTIVE = "active"
        const val STATUS_FINISHED = "finished"
        const val PHASE_HAND_SELECTION = "hand_selection"
        const val PHASE_QUIZ = "quiz"
        const val PHASE_GAME_OVER = "game_over"
    }
}

data class OnlineRoundData(
    val playedCardId: Long = 0L,
    val attackerIndex: Int = 0,
    val question: String = "",
    val questionLabel: String = "",
    val options: List<String> = emptyList(),
    val correctAnswer: String = "",
    val selectedAnswer: String = "",
)
