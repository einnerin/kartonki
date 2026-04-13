package com.example.kartonki.ui.screen.pvp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.theme.AccentGold
import com.example.kartonki.ui.theme.AccentPurple
import com.example.kartonki.ui.theme.BgCard
import com.example.kartonki.ui.theme.BgDeep
import com.example.kartonki.ui.theme.BgMedium
import com.example.kartonki.ui.theme.TextSecondary

@Composable
fun OnlinePvpGameScreen(
    onNavigateHome: () -> Unit,
    viewModel: OnlinePvpGameViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF0D1B30), BgDeep)))
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        when {
            uiState.isLoading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(color = AccentGold)
                        Spacer(Modifier.height(16.dp))
                        Text("Подключение к матчу...", color = TextSecondary)
                    }
                }
            }

            uiState.connectionError != null -> {
                Box(Modifier.fillMaxSize().padding(32.dp), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("⚠️", fontSize = 40.sp)
                        Spacer(Modifier.height(12.dp))
                        Text(uiState.connectionError!!, color = Color.White, textAlign = TextAlign.Center)
                        Spacer(Modifier.height(24.dp))
                        Button(onClick = onNavigateHome) { Text("На главную") }
                    }
                }
            }

            else -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    // ─── Header: scoreboard + surrender ──────────────────────
                    OnlineScoreboard(
                        uiState = uiState,
                        showSurrender = uiState.phase !is OnlinePvpPhase.GameOver,
                        onSurrender = viewModel::onSurrenderClick,
                    )
                    // ─── Timer bar ────────────────────────────────────────────
                    PvpTimerBar(
                        timeRemaining = uiState.timeRemaining,
                        modifier = Modifier.padding(horizontal = 12.dp),
                    )
                    Spacer(Modifier.height(12.dp))
                    // ─── Phase content ────────────────────────────────────────
                    Box(modifier = Modifier.weight(1f)) {
                        when (val phase = uiState.phase) {
                            is OnlinePvpPhase.MyHandSelection ->
                                OnlineHandSelectionContent(phase.hand, viewModel::onCardSelected)
                            is OnlinePvpPhase.WaitingForOpponent ->
                                WaitingContent("Ход противника...\nОн выбирает карту")
                            is OnlinePvpPhase.MyQuiz ->
                                OnlineQuizContent(
                                    phase = phase,
                                    onAnswerSelected = viewModel::onAnswerSelected,
                                    onConfirm = viewModel::onConfirmAnswer,
                                )
                            is OnlinePvpPhase.WaitingForAnswer ->
                                WaitingContent("Противник отвечает...\n\"${phase.question}\"")
                            is OnlinePvpPhase.GameOver ->
                                OnlineGameOverContent(phase, onNavigateHome)
                        }
                    }
                }

                // Surrender confirmation dialog
                if (uiState.showSurrenderDialog) {
                    AlertDialog(
                        onDismissRequest = viewModel::onSurrenderDismiss,
                        title = { Text("Сдаться?") },
                        text = { Text("Противник получит победу. Вы уверены?") },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    viewModel.onSurrenderDismiss()
                                    viewModel.surrender()
                                },
                                colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFFEF5350)),
                            ) { Text("Сдаться") }
                        },
                        dismissButton = {
                            TextButton(onClick = viewModel::onSurrenderDismiss) { Text("Отмена") }
                        },
                    )
                }
            }
        }
    }
}

// ─── Scoreboard ───────────────────────────────────────────────────────────────

@Composable
private fun OnlineScoreboard(
    uiState: OnlinePvpGameUiState,
    showSurrender: Boolean,
    onSurrender: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgMedium)
            .padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // My side
        OnlinePlayerChip(
            name = uiState.myName,
            score = uiState.myScore,
            streak = uiState.myStreak,
            isMe = true,
            modifier = Modifier.weight(1f),
        )

        if (showSurrender) {
            TextButton(
                onClick = onSurrender,
                colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFFEF5350)),
            ) { Text("🏳️", fontSize = 18.sp) }
        } else {
            Text("⚔️", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 8.dp))
        }

        // Opponent side
        OnlinePlayerChip(
            name = uiState.opponentName,
            score = uiState.opponentScore,
            streak = uiState.opponentStreak,
            isMe = false,
            modifier = Modifier.weight(1f),
        )
    }
    HorizontalDivider(color = BgCard)
}

@Composable
private fun OnlinePlayerChip(
    name: String,
    score: Int,
    streak: Int,
    isMe: Boolean,
    modifier: Modifier = Modifier,
) {
    val multiplier = PvpGameLogic.streakToMultiplier(streak)
    val multiplierColor = when (multiplier) {
        2    -> Color(0xFF4A90E2)
        3    -> Color(0xFF9B51E0)
        4    -> Color(0xFFF5A623)
        else -> Color(0xFF9E9E9E)
    }
    Column(
        modifier = modifier.padding(horizontal = 4.dp, vertical = 4.dp),
        horizontalAlignment = if (isMe) Alignment.Start else Alignment.End,
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            color = if (isMe) AccentGold else TextSecondary,
            fontWeight = if (isMe) FontWeight.Bold else FontWeight.Normal,
        )
        Text(
            text = "$score очков",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
        )
        if (multiplier > 1) {
            Text(
                text = "×$multiplier  🔥$streak",
                style = MaterialTheme.typography.labelSmall,
                color = multiplierColor,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

// ─── Hand selection ───────────────────────────────────────────────────────────

@Composable
private fun OnlineHandSelectionContent(hand: List<Word>, onCardSelected: (Word) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp),
    ) {
        Text(
            text = "Твой ход — выбери карту для атаки",
            style = MaterialTheme.typography.titleSmall,
            color = TextSecondary,
            modifier = Modifier.padding(bottom = 8.dp),
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(bottom = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(hand, key = { it.id }) { word ->
                PvpHandCard(word = word, onClick = { onCardSelected(word) })
            }
        }
    }
}

// ─── Quiz ─────────────────────────────────────────────────────────────────────

@Composable
private fun OnlineQuizContent(
    phase: OnlinePvpPhase.MyQuiz,
    onAnswerSelected: (String) -> Unit,
    onConfirm: () -> Unit,
) {
    val answered = phase.selectedAnswer != null
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Spacer(Modifier.height(4.dp))

        Text(
            text = phase.questionLabel,
            style = MaterialTheme.typography.labelLarge,
            color = TextSecondary,
        )

        // Question box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(BgCard)
                .border(1.dp, AccentPurple.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
                .padding(20.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = phase.question,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }

        // Answer options
        phase.options.forEach { option ->
            val isCorrect = option == phase.correctAnswer
            val isSelected = option == phase.selectedAnswer
            val ansState = when {
                !answered  -> PvpAnswerState.Normal
                isCorrect  -> PvpAnswerState.Correct
                isSelected -> PvpAnswerState.Wrong
                else       -> PvpAnswerState.Dimmed
            }
            PvpAnswerButton(
                text = option,
                answerState = ansState,
                enabled = !answered,
                onClick = { onAnswerSelected(option) },
            )
        }

        // Result panel + confirm button after answering
        if (answered) {
            val isCorrect = phase.selectedAnswer == phase.correctAnswer
            PvpResultPanel(
                wordOriginal = phase.playedCardWord,
                wordTranslation = phase.playedCardTranslation,
                isCorrect = isCorrect,
            )
            Spacer(Modifier.weight(1f))
            Button(
                onClick = onConfirm,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                shape = RoundedCornerShape(14.dp),
            ) {
                Text("Продолжить", fontWeight = FontWeight.Bold)
            }
        }
    }
}

// ─── Waiting ──────────────────────────────────────────────────────────────────

@Composable
private fun WaitingContent(message: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(
                color = AccentPurple,
                modifier = Modifier.size(48.dp),
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = message,
                style = MaterialTheme.typography.titleMedium,
                color = TextSecondary,
                textAlign = TextAlign.Center,
            )
        }
    }
}

// ─── Game over ────────────────────────────────────────────────────────────────

@Composable
private fun OnlineGameOverContent(
    phase: OnlinePvpPhase.GameOver,
    onNavigateHome: () -> Unit,
) {
    val iWon = phase.winnerIndex == phase.myIndex
    val isDraw = phase.winnerIndex == -1

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = when {
                    isDraw -> "🤝"
                    iWon -> "🏆"
                    else -> "💔"
                },
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                text = when {
                    isDraw -> "Ничья!"
                    iWon -> "Победа!"
                    else -> "Поражение"
                },
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = when {
                    isDraw -> AccentGold
                    iWon -> Color(0xFF4CAF50)
                    else -> Color(0xFFF44336)
                },
                textAlign = TextAlign.Center,
            )

            // Score comparison
            val myFirst = iWon || isDraw
            listOf(
                Triple(phase.myName, phase.myScore, true),
                Triple(phase.opponentName, phase.opponentScore, false),
            ).sortedByDescending { it.second }.forEach { (name, score, isMe) ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(BgCard)
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = if (score >= maxOf(phase.myScore, phase.opponentScore)) FontWeight.ExtraBold else FontWeight.Normal,
                            color = if (isMe) AccentGold else TextSecondary,
                        )
                        Text(
                            "$score очков",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outline)

            Text(
                text = when {
                    isDraw -> "Ничья!"
                    iWon   -> "Победа: ${phase.myName}"
                    else   -> "Победа: ${phase.opponentName}"
                },
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = if (!isDraw && iWon) MaterialTheme.colorScheme.primary else TextSecondary,
                textAlign = TextAlign.Center,
            )

            Spacer(Modifier.height(8.dp))
            Button(
                onClick = onNavigateHome,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
            ) {
                Text("На главную", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}
