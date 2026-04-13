package com.example.kartonki.ui.screen.pvp

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.kartonki.ui.theme.BgCard
import com.example.kartonki.ui.theme.BgDeep
import com.example.kartonki.ui.theme.BgMedium
import com.example.kartonki.ui.theme.LocalAppStrings
import com.example.kartonki.ui.theme.TextSecondary

private val OnlineSurrenderRed = Color(0xFFEF5350)

// ─── Entry point ──────────────────────────────────────────────────────────────

@Composable
fun OnlinePvpGameScreen(
    onNavigateHome: () -> Unit,
    viewModel: OnlinePvpGameViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize().background(BgDeep),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
        return
    }

    uiState.connectionError?.let { err ->
        Box(
            modifier = Modifier.fillMaxSize().background(BgDeep).padding(32.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("⚠️", fontSize = 40.sp)
                Spacer(Modifier.height(12.dp))
                Text(err, color = Color.White, textAlign = TextAlign.Center)
                Spacer(Modifier.height(24.dp))
                Button(onClick = onNavigateHome) { Text("На главную") }
            }
        }
        return
    }

    val s = LocalAppStrings.current
    val players = buildOnlinePlayers(uiState)
    val highlightIndex = when (uiState.phase) {
        is OnlinePvpPhase.MyHandSelection,
        is OnlinePvpPhase.MyQuiz -> uiState.myIndex
        is OnlinePvpPhase.WaitingForOpponent,
        is OnlinePvpPhase.WaitingForAnswer -> 1 - uiState.myIndex
        else -> -1
    }

    when (val phase = uiState.phase) {
        is OnlinePvpPhase.MyHandSelection ->
            OnlineHandSelectionScreen(
                title = s.pvpTurn(uiState.myName),
                players = players,
                highlightIndex = highlightIndex,
                timeRemaining = uiState.timeRemaining,
                hand = phase.hand,
                remainingDeck = phase.remainingDeck,
                onCardSelected = viewModel::onCardSelected,
                onSurrender = viewModel::onSurrenderClick,
            )
        is OnlinePvpPhase.WaitingForOpponent ->
            OnlineWaitingScreen(
                title = s.pvpTurn(uiState.opponentName),
                message = "Ожидаем, пока противник выбирает карту...",
                players = players,
                highlightIndex = highlightIndex,
                timeRemaining = uiState.timeRemaining,
                onSurrender = viewModel::onSurrenderClick,
            )
        is OnlinePvpPhase.MyQuiz ->
            OnlineQuizScreen(
                title = s.pvpTaskFor(uiState.myName),
                phase = phase,
                players = players,
                highlightIndex = highlightIndex,
                timeRemaining = uiState.timeRemaining,
                onAnswerSelected = viewModel::onAnswerSelected,
                onConfirm = viewModel::onConfirmAnswer,
                onSurrender = viewModel::onSurrenderClick,
            )
        is OnlinePvpPhase.WaitingForAnswer ->
            OnlineWaitingScreen(
                title = s.pvpTaskFor(uiState.opponentName),
                message = "Ожидаем ответа противника...",
                players = players,
                highlightIndex = highlightIndex,
                timeRemaining = uiState.timeRemaining,
                onSurrender = viewModel::onSurrenderClick,
            )
        is OnlinePvpPhase.GameOver ->
            OnlineGameOverScreen(phase, onNavigateHome)
    }

    // Surrender dialog — managed by viewmodel state
    if (uiState.showSurrenderDialog) {
        SurrenderDialog(
            playerName = uiState.myName,
            onConfirm = { viewModel.onSurrenderDismiss(); viewModel.surrender() },
            onDismiss = viewModel::onSurrenderDismiss,
        )
    }
}

// ─── Helpers ──────────────────────────────────────────────────────────────────

private fun buildOnlinePlayers(uiState: OnlinePvpGameUiState): List<PvpPlayerState> {
    val me = PvpPlayerState(
        name = uiState.myName,
        remainingCards = emptyList(),
        score = uiState.myScore,
        streak = uiState.myStreak,
        multiplier = PvpGameLogic.streakToMultiplier(uiState.myStreak),
    )
    val opponent = PvpPlayerState(
        name = uiState.opponentName,
        remainingCards = emptyList(),
        score = uiState.opponentScore,
        streak = uiState.opponentStreak,
        multiplier = PvpGameLogic.streakToMultiplier(uiState.opponentStreak),
    )
    return if (uiState.myIndex == 0) listOf(me, opponent) else listOf(opponent, me)
}

// ─── Hand Selection ───────────────────────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OnlineHandSelectionScreen(
    title: String,
    players: List<PvpPlayerState>,
    highlightIndex: Int,
    timeRemaining: Int,
    hand: List<Word>,
    remainingDeck: List<Word>,
    onCardSelected: (Word) -> Unit,
    onSurrender: () -> Unit,
) {
    val s = LocalAppStrings.current
    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BgMedium,
                    titleContentColor = Color.White,
                ),
                title = { Text(title, fontWeight = FontWeight.Bold) },
                actions = {
                    TextButton(onClick = onSurrender) {
                        Text(s.pvpSurrender, color = OnlineSurrenderRed, fontWeight = FontWeight.Bold)
                    }
                },
            )
        },
        bottomBar = {
            if (timeRemaining <= 15) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(bottom = 12.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    TimerWidget(timeRemaining)
                }
            }
        },
    ) { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            MultiplierRow(players = players, highlightIndex = highlightIndex)
            HorizontalDivider(color = BgCard)
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = s.pvpSelectCard,
                    style = MaterialTheme.typography.titleSmall,
                    color = TextSecondary,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = s.pvpInDeck(remainingDeck.size),
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary.copy(alpha = 0.7f),
                    )
                    DeckRarityIndicator(remainingDeck)
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(hand, key = { it.id }) { card ->
                    PvpHandCard(word = card, onClick = { onCardSelected(card) })
                }
            }
        }
    }
}

// ─── Waiting ──────────────────────────────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OnlineWaitingScreen(
    title: String,
    message: String,
    players: List<PvpPlayerState>,
    highlightIndex: Int,
    timeRemaining: Int,
    onSurrender: () -> Unit,
) {
    val s = LocalAppStrings.current
    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BgMedium,
                    titleContentColor = Color.White,
                ),
                title = { Text(title, fontWeight = FontWeight.Bold) },
                actions = {
                    TextButton(onClick = onSurrender) {
                        Text(s.pvpSurrender, color = OnlineSurrenderRed, fontWeight = FontWeight.Bold)
                    }
                },
            )
        },
        bottomBar = {
            if (timeRemaining <= 15) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(bottom = 12.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    TimerWidget(timeRemaining)
                }
            }
        },
    ) { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            MultiplierRow(players = players, highlightIndex = highlightIndex)
            HorizontalDivider(color = BgCard)
            Box(
                modifier = Modifier.weight(1f).fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = message,
                    style = MaterialTheme.typography.titleMedium,
                    color = TextSecondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp),
                )
            }
        }
    }
}

// ─── Quiz ─────────────────────────────────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OnlineQuizScreen(
    title: String,
    phase: OnlinePvpPhase.MyQuiz,
    players: List<PvpPlayerState>,
    highlightIndex: Int,
    timeRemaining: Int,
    onAnswerSelected: (String) -> Unit,
    onConfirm: () -> Unit,
    onSurrender: () -> Unit,
) {
    val s = LocalAppStrings.current
    val answered = phase.selectedAnswer != null

    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BgMedium,
                    titleContentColor = Color.White,
                ),
                title = { Text(title, fontWeight = FontWeight.Bold) },
                actions = {
                    TextButton(onClick = onSurrender) {
                        Text(s.pvpSurrender, color = OnlineSurrenderRed, fontWeight = FontWeight.Bold)
                    }
                },
            )
        },
        bottomBar = {
            if (timeRemaining <= 15 && !answered) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(bottom = 12.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    TimerWidget(timeRemaining)
                }
            }
        },
    ) { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            MultiplierRow(players = players, highlightIndex = highlightIndex)
            HorizontalDivider(color = BgCard)

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Spacer(Modifier.height(16.dp))

                Text(
                    text = phase.questionLabel,
                    style = MaterialTheme.typography.labelLarge,
                    color = TextSecondary,
                )

                Text(
                    text = phase.question,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    softWrap = true,
                )

                Spacer(Modifier.height(4.dp))

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
                        Text(s.pvpContinue, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

// ─── Game Over ────────────────────────────────────────────────────────────────

@Composable
private fun OnlineGameOverScreen(
    phase: OnlinePvpPhase.GameOver,
    onHome: () -> Unit,
) {
    val s = LocalAppStrings.current
    val iWon = phase.winnerIndex == phase.myIndex
    val isDraw = phase.winnerIndex == -1
    val winnerName = when {
        isDraw -> null
        iWon   -> phase.myName
        else   -> phase.opponentName
    }

    val sortedPlayers = listOf(
        Triple(phase.myName, phase.myScore, true),
        Triple(phase.opponentName, phase.opponentScore, false),
    ).sortedByDescending { it.second }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF0D1B30), BgDeep)))
            .navigationBarsPadding()
            .padding(32.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = when { isDraw -> "🤝"; iWon -> "🏆"; else -> "💔" },
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                text = when { isDraw -> s.pvpDraw; iWon -> "Победа!"; else -> "Поражение" },
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = when { isDraw -> AccentGold; iWon -> Color(0xFF4CAF50); else -> Color(0xFFF44336) },
                textAlign = TextAlign.Center,
            )

            Spacer(Modifier.height(4.dp))

            sortedPlayers.forEach { (name, score, _) ->
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
                            text = name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = if (name == winnerName) FontWeight.ExtraBold else FontWeight.Normal,
                            color = if (name == winnerName) MaterialTheme.colorScheme.primary else TextSecondary,
                        )
                        Text(
                            text = s.pvpScore(score),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
            }

            androidx.compose.material3.HorizontalDivider(color = MaterialTheme.colorScheme.outline)

            Text(
                text = if (winnerName != null) s.pvpWinner(winnerName) else s.pvpDraw,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = if (winnerName != null) MaterialTheme.colorScheme.primary else TextSecondary,
                textAlign = TextAlign.Center,
            )

            Spacer(Modifier.height(8.dp))
            Button(
                onClick = onHome,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
            ) {
                Text(s.pvpGoHome, fontWeight = FontWeight.Bold)
            }
        }
    }
}
