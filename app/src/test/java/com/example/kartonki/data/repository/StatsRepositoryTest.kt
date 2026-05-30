package com.example.kartonki.data.repository

import com.example.kartonki.data.db.entity.PvpMatchEntity
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Regression tests for [StatsRepository.computePvpStats] — the win-counting fix.
 *
 * The previous implementation counted wins/losses by name (`winnerName == player1Name`),
 * which broke whenever both players were "Игрок" (default name in pass-and-play)
 * and reported the wrong bestPvpScore for online PvP rows where the client played
 * P2. The fix relies on [PvpMatchEntity.deviceOwnerIndex] (role), so these tests
 * lock in the role-based aggregation.
 */
class StatsRepositoryTest {

    private fun match(
        deviceOwnerIndex: Int? = 0,
        player1Name: String = "Игрок",
        player2Name: String = "Игрок",
        player1Score: Int = 0,
        player2Score: Int = 0,
    ): PvpMatchEntity {
        val winnerName = when {
            player1Score > player2Score -> player1Name
            player2Score > player1Score -> player2Name
            else -> null
        }
        return PvpMatchEntity(
            timestamp = 0L,
            player1Name = player1Name,
            player2Name = player2Name,
            player1Score = player1Score,
            player2Score = player2Score,
            winnerName = winnerName,
            deviceOwnerIndex = deviceOwnerIndex,
        )
    }

    // ── Pass-and-play: identical names must NOT collapse win/loss counters ───

    @Test fun `pass-and-play equal names — P1 wins counts as 1 win`() {
        val stats = StatsRepository.computePvpStats(listOf(
            match(deviceOwnerIndex = 0, player1Score = 10, player2Score = 3),
        ))
        assertEquals(1, stats.wins)
        assertEquals(0, stats.losses)
        assertEquals(0, stats.draws)
    }

    @Test fun `pass-and-play equal names — P2 wins counts as 1 loss (not 1 win)`() {
        // Old name-based logic would have flipped this — player2's win matched
        // `winnerName == player1Name` since both names are «Игрок».
        val stats = StatsRepository.computePvpStats(listOf(
            match(deviceOwnerIndex = 0, player1Score = 3, player2Score = 10),
        ))
        assertEquals(0, stats.wins)
        assertEquals(1, stats.losses)
    }

    // ── Online PvP — device owner can be P2 ──────────────────────────────────

    @Test fun `online PvP — device owner played P2 and won → 1 win`() {
        val stats = StatsRepository.computePvpStats(listOf(
            match(
                deviceOwnerIndex = 1,
                player1Name = "Opp", player2Name = "Me",
                player1Score = 5, player2Score = 12,
            ),
        ))
        assertEquals(1, stats.wins)
        assertEquals(0, stats.losses)
    }

    @Test fun `online PvP — device owner played P2 and lost → 1 loss`() {
        val stats = StatsRepository.computePvpStats(listOf(
            match(
                deviceOwnerIndex = 1,
                player1Name = "Opp", player2Name = "Me",
                player1Score = 12, player2Score = 5,
            ),
        ))
        assertEquals(0, stats.wins)
        assertEquals(1, stats.losses)
    }

    // ── Legacy rows (pre-migration) ──────────────────────────────────────────

    @Test fun `legacy row with null deviceOwnerIndex is skipped (no win, no loss)`() {
        val stats = StatsRepository.computePvpStats(listOf(
            match(deviceOwnerIndex = null, player1Score = 10, player2Score = 3),
        ))
        assertEquals(0, stats.wins)
        assertEquals(0, stats.losses)
        assertEquals(0, stats.bestScore)
    }

    @Test fun `legacy draw still counts as draw`() {
        // winnerName-based draw detection works for legacy rows too.
        val stats = StatsRepository.computePvpStats(listOf(
            match(deviceOwnerIndex = null, player1Score = 5, player2Score = 5),
        ))
        assertEquals(1, stats.draws)
    }

    // ── Draws ────────────────────────────────────────────────────────────────

    @Test fun `equal scores counts as draw not win or loss`() {
        val stats = StatsRepository.computePvpStats(listOf(
            match(deviceOwnerIndex = 0, player1Score = 7, player2Score = 7),
        ))
        assertEquals(0, stats.wins)
        assertEquals(0, stats.losses)
        assertEquals(1, stats.draws)
    }

    // ── bestScore — device owner's own best ──────────────────────────────────

    @Test fun `bestScore reports device owner's own max, not absolute max in table`() {
        // Player 2 (device owner) scores 8 and 4; player 1 scores 11 and 2.
        // bestScore must be 8 (device owner's best), not 11 (opponent's).
        val stats = StatsRepository.computePvpStats(listOf(
            match(deviceOwnerIndex = 1, player1Score = 11, player2Score = 8),
            match(deviceOwnerIndex = 1, player1Score = 2,  player2Score = 4),
        ))
        assertEquals(8, stats.bestScore)
    }

    @Test fun `bestScore mixes P1 and P2 device-owner matches correctly`() {
        // Mixed: sometimes device owner played P1, sometimes P2 (changing accounts /
        // online matchmaking outcome). bestScore must pick own score in each.
        val stats = StatsRepository.computePvpStats(listOf(
            match(deviceOwnerIndex = 0, player1Score = 15, player2Score = 3),  // mine = 15
            match(deviceOwnerIndex = 1, player1Score = 9,  player2Score = 12), // mine = 12
            match(deviceOwnerIndex = 0, player1Score = 7,  player2Score = 20), // mine = 7
        ))
        assertEquals(15, stats.bestScore)
    }

    // ── Mixed scenario — full smoke test ─────────────────────────────────────

    @Test fun `mixed batch — wins losses draws bestScore all correct`() {
        val stats = StatsRepository.computePvpStats(listOf(
            // P1, win
            match(deviceOwnerIndex = 0, player1Score = 10, player2Score = 4),
            // P2, win
            match(deviceOwnerIndex = 1, player1Score = 2, player2Score = 9),
            // P1, loss
            match(deviceOwnerIndex = 0, player1Score = 1, player2Score = 8),
            // P2, loss
            match(deviceOwnerIndex = 1, player1Score = 11, player2Score = 5),
            // draw
            match(deviceOwnerIndex = 0, player1Score = 6, player2Score = 6),
            // legacy — skipped
            match(deviceOwnerIndex = null, player1Score = 99, player2Score = 0),
        ))
        assertEquals(2, stats.wins)
        assertEquals(2, stats.losses)
        // 1 explicit draw + the legacy `winnerName == null` rows none here (legacy
        // row has non-equal scores so winnerName is non-null).
        assertEquals(1, stats.draws)
        // Best of my scores: 10, 9, 1, 5, 6, (legacy excluded) → 10
        assertEquals(10, stats.bestScore)
    }
}
