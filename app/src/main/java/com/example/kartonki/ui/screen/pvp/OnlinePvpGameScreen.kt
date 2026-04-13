package com.example.kartonki.ui.screen.pvp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import com.example.kartonki.ui.theme.BgDeep
import com.example.kartonki.ui.theme.TextSecondary
import com.example.kartonki.ui.theme.glowEffect

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
                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                ) {
                    // Scoreboard + surrender button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            OnlineScoreboard(uiState)
                        }
                        if (uiState.phase !is OnlinePvpPhase.GameOver) {
                            TextButton(
                                onClick = viewModel::onSurrenderClick,
                                colors = ButtonDefaults.textButtonColors(
                                    contentColor = Color(0xFFEF5350),
                                ),
                            ) { Text("Сдаться", fontSize = 12.sp) }
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    // Timer
                    OnlineTimerBar(uiState.timeRemaining)
                    Spacer(Modifier.height(16.dp))
                    // Phase content
                    Box(modifier = Modifier.weight(1f)) {
                        when (val phase = uiState.phase) {
                            is OnlinePvpPhase.MyHandSelection ->
                                HandSelectionContent(phase.hand, viewModel::onCardSelected)
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
                                colors = ButtonDefaults.textButtonColors(
                                    contentColor = Color(0xFFEF5350),
                                ),
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

@Composable
private fun OnlineScoreboard(uiState: OnlinePvpGameUiState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF1A1A2E))
            .border(1.dp, Color(0xFF333355), RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        PlayerScoreColumn(
            name = uiState.myName,
            score = uiState.myScore,
            streak = uiState.myStreak,
            isMe = true,
        )
        Text(
            text = "⚔️",
            fontSize = 24.sp,
        )
        PlayerScoreColumn(
            name = uiState.opponentName,
            score = uiState.opponentScore,
            streak = 0,
            isMe = false,
        )
    }
}

@Composable
private fun PlayerScoreColumn(name: String, score: Int, streak: Int, isMe: Boolean) {
    Column(horizontalAlignment = if (isMe) Alignment.Start else Alignment.End) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = if (isMe) AccentGold else TextSecondary,
        )
        Text(
            text = "$score очков",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
        )
        if (isMe && streak >= 3) {
            Text(
                text = "🔥 ×${streakToMultiplierDisplay(streak)}",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFFFF6F00),
            )
        }
    }
}

private fun streakToMultiplierDisplay(streak: Int) = when {
    streak >= 15 -> 4
    streak >= 10 -> 3
    streak >= 5  -> 2
    else         -> 1
}

@Composable
private fun OnlineTimerBar(timeRemaining: Int) {
    val fraction = timeRemaining / 30f
    val color = when {
        fraction > 0.5f -> Color(0xFF4CAF50)
        fraction > 0.25f -> Color(0xFFFF9800)
        else -> Color(0xFFF44336)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
            .clip(RoundedCornerShape(3.dp))
            .background(Color(0xFF333355)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction)
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(color),
        )
    }
}

@Composable
private fun HandSelectionContent(hand: List<Word>, onCardSelected: (Word) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Твой ход — выбери карту для атаки",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = AccentGold,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(hand) { word ->
                OnlineCardItem(word = word, onClick = { onCardSelected(word) })
            }
        }
    }
}

@Composable
private fun OnlineCardItem(word: Word, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .glowEffect(Color(word.rarity.colorArgb), 8.dp, 12.dp, 0.3f)
            .clip(RoundedCornerShape(12.dp))
            .background(
                Brush.verticalGradient(
                    listOf(Color(word.rarity.colorArgb).copy(alpha = 0.3f), Color(0xFF0D0D1A))
                )
            )
            .border(1.5.dp, Color(word.rarity.colorArgb).copy(alpha = 0.7f), RoundedCornerShape(12.dp))
            .clickable(interactionSource = interactionSource, indication = null, onClick = onClick)
            .padding(12.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = word.original,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = word.translation,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "+${word.rarity.points} очк.",
                style = MaterialTheme.typography.labelSmall,
                color = Color(word.rarity.colorArgb),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
private fun OnlineQuizContent(
    phase: OnlinePvpPhase.MyQuiz,
    onAnswerSelected: (String) -> Unit,
    onConfirm: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Ответь на вопрос!",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = AccentGold,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = phase.questionLabel,
            style = MaterialTheme.typography.labelLarge,
            color = TextSecondary,
        )
        Spacer(Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF1A1A2E))
                .border(1.dp, AccentPurple.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
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

        Spacer(Modifier.height(16.dp))

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            phase.options.forEach { option ->
                val isSelected = phase.selectedAnswer == option
                val isCorrect = option == phase.correctAnswer
                val bgColor = when {
                    phase.selectedAnswer == null -> Color(0xFF1A1A2E)
                    isCorrect -> Color(0xFF1B5E20)
                    isSelected -> Color(0xFF7F0000)
                    else -> Color(0xFF1A1A2E)
                }
                val borderColor = when {
                    phase.selectedAnswer == null -> Color(0xFF333355)
                    isCorrect -> Color(0xFF4CAF50)
                    isSelected -> Color(0xFFF44336)
                    else -> Color(0xFF333355)
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(bgColor)
                        .border(1.5.dp, borderColor, RoundedCornerShape(12.dp))
                        .clickable(
                            enabled = phase.selectedAnswer == null,
                            onClick = { onAnswerSelected(option) },
                        )
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                    )
                }
            }
        }

        if (phase.selectedAnswer != null) {
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = onConfirm,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = AccentPurple),
            ) {
                Text("Продолжить", fontWeight = FontWeight.Bold)
            }
        }
    }
}

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
        ) {
            Text(
                text = when {
                    isDraw -> "🤝"
                    iWon -> "🏆"
                    else -> "💔"
                },
                fontSize = 56.sp,
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = when {
                    isDraw -> "Ничья!"
                    iWon -> "Победа!"
                    else -> "Поражение"
                },
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.ExtraBold,
                color = when {
                    isDraw -> AccentGold
                    iWon -> Color(0xFF4CAF50)
                    else -> Color(0xFFF44336)
                },
            )

            Spacer(Modifier.height(24.dp))

            // Score comparison
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF1A1A2E))
                    .border(1.dp, Color(0xFF333355), RoundedCornerShape(16.dp))
                    .padding(20.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(phase.myName, style = MaterialTheme.typography.labelLarge, color = AccentGold)
                        Spacer(Modifier.height(4.dp))
                        Text(
                            "${phase.myScore}",
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                        )
                    }
                    Text("vs", style = MaterialTheme.typography.titleLarge, color = TextSecondary,
                        modifier = Modifier.align(Alignment.CenterVertically))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(phase.opponentName, style = MaterialTheme.typography.labelLarge, color = TextSecondary)
                        Spacer(Modifier.height(4.dp))
                        Text(
                            "${phase.opponentScore}",
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                        )
                    }
                }
            }

            Spacer(Modifier.height(32.dp))
            Button(
                onClick = onNavigateHome,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = AccentPurple),
            ) {
                Text("На главную", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}
