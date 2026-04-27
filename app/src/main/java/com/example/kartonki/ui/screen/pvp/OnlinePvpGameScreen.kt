package com.example.kartonki.ui.screen.pvp

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
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
import com.example.kartonki.ui.theme.LocalAppStrings

private val OnlineSurrenderRed = Color(0xFFEF5350)

// ─── Entry point ──────────────────────────────────────────────────────────────

@Composable
fun OnlinePvpGameScreen(
    onNavigateHome: () -> Unit,
    viewModel: OnlinePvpGameViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    // Back button / gesture: surrender during game, go home when game is over
    val isGameOver = uiState.phase is OnlinePvpPhase.GameOver
    BackHandler {
        if (isGameOver) onNavigateHome() else viewModel.onSurrenderClick()
    }

    // Detect when the user backgrounds or closes the app so the opponent isn't left waiting
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = object : DefaultLifecycleObserver {
            override fun onStop(owner: LifecycleOwner) = viewModel.onAppBackground()
            override fun onStart(owner: LifecycleOwner) = viewModel.onAppForeground()
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    if (uiState.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
        return
    }

    uiState.connectionError?.let { err ->
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(32.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("⚠️", fontSize = 40.sp)
                Spacer(Modifier.height(12.dp))
                Text(err, color = MaterialTheme.colorScheme.onBackground, textAlign = TextAlign.Center)
                Spacer(Modifier.height(24.dp))
                Button(onClick = onNavigateHome) { Text("На главную") }
            }
        }
        return
    }

    val s = LocalAppStrings.current
    val players = buildOnlinePlayers(uiState)
    // players is always [me, opponent], so 0 = me (left), 1 = opponent (right)
    val highlightIndex = when (uiState.phase) {
        is OnlinePvpPhase.MyHandSelection,
        is OnlinePvpPhase.MyQuiz -> 0
        is OnlinePvpPhase.WaitingForOpponent,
        is OnlinePvpPhase.WaitingForAnswer -> 1
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
                opponentName = uiState.opponentName,
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
    return listOf(me, opponent) // always: me on the left, opponent on the right
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
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
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
            HorizontalDivider(color = MaterialTheme.colorScheme.surfaceContainer)
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = s.pvpSelectCard,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = s.pvpInDeck(remainingDeck.size),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
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
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
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
            HorizontalDivider(color = MaterialTheme.colorScheme.surfaceContainer)
            Box(
                modifier = Modifier.weight(1f).fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = message,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
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
    opponentName: String,
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
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
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
            HorizontalDivider(color = MaterialTheme.colorScheme.surfaceContainer)

            Column(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Spacer(Modifier.height(16.dp))

                    // Context banner: shows the user whose card they are being quizzed on
                    Text(
                        text = "⚔ $opponentName сыграл карту",
                        style = MaterialTheme.typography.labelMedium,
                        color = AccentGold,
                        fontWeight = FontWeight.SemiBold,
                    )

                    Text(
                        text = phase.questionLabel,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )

                    Text(
                        text = phase.question,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
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
                        Spacer(Modifier.height(8.dp))
                    }
                }

                if (answered) {
                    Button(
                        onClick = onConfirm,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 8.dp, bottom = 24.dp),
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
            .background(Brush.verticalGradient(listOf(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.background)))
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
                        .background(MaterialTheme.colorScheme.surfaceContainer)
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
                            color = if (name == winnerName) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
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
                color = if (winnerName != null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
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
