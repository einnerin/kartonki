package com.example.kartonki.ui.screen.pvp

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.theme.LocalAppStrings

private val SurrenderRed = Color(0xFFEF5350)

@Composable
fun PvpGameScreen(
    onNavigateHome: () -> Unit,
    onPlayAgain: () -> Unit,
    viewModel: PvpGameViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    var multiplierRowBottomPx by remember { mutableIntStateOf(0) }

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
        return
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when (val phase = state.phase) {
            is PvpPhase.HandSelection -> HandSelectionScreen(
                state = state,
                hand = phase.hand,
                onCardSelected = { viewModel.onCardSelected(it) },
                onSurrender = { viewModel.onSurrender(state.currentPlayerIndex) },
                onMultiplierRowPositioned = { multiplierRowBottomPx = it },
            )
            is PvpPhase.Quiz -> QuizScreen(
                state = state,
                phase = phase,
                onAnswerSelected = { viewModel.onAnswerSelected(it) },
                onConfirm = { viewModel.onConfirmAnswer() },
                onSurrender = { viewModel.onSurrender(phase.defenderIndex) },
                onMultiplierRowPositioned = { multiplierRowBottomPx = it },
            )
            is PvpPhase.GameOver -> GameOverScreen(
                players = state.players,
                phase = phase,
                onPlayAgain = onPlayAgain,
                onHome = onNavigateHome,
            )
        }

        if (state.showMultiplierHint && multiplierRowBottomPx > 0) {
            MultiplierHintOverlay(
                anchorBottomPx = multiplierRowBottomPx,
                onDismiss = viewModel::dismissMultiplierHint,
            )
        }
    }
}

// ─── Hand Selection ───────────────────────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HandSelectionScreen(
    state: PvpGameUiState,
    hand: List<Word>,
    onCardSelected: (Word) -> Unit,
    onSurrender: () -> Unit,
    onMultiplierRowPositioned: (Int) -> Unit = {},
) {
    val activePlayer = state.activePlayer
    val handIds = hand.map { it.id }.toSet()
    val deckCards = (activePlayer?.remainingCards ?: emptyList())
        .filter { it.id !in handIds }
        .sortedByDescending { it.rarity.points }

    var showSurrenderDialog by remember { mutableStateOf(false) }

    if (showSurrenderDialog) {
        SurrenderDialog(
            playerName = activePlayer?.name ?: "",
            onConfirm = { showSurrenderDialog = false; onSurrender() },
            onDismiss = { showSurrenderDialog = false },
        )
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                ),
                title = {
                    val s = LocalAppStrings.current
                    Text(
                        s.pvpTurn(activePlayer?.name ?: ""),
                        fontWeight = FontWeight.Bold,
                    )
                },
                actions = {
                    val s = LocalAppStrings.current
                    TextButton(onClick = { showSurrenderDialog = true }) {
                        Text(s.pvpSurrender, color = SurrenderRed, fontWeight = FontWeight.Bold)
                    }
                },
            )
        },
        bottomBar = {
            if (state.timeRemaining <= 15) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(bottom = 12.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    TimerWidget(state.timeRemaining)
                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Box(modifier = Modifier.onGloballyPositioned { coords ->
                onMultiplierRowPositioned(coords.boundsInWindow().bottom.toInt())
            }) {
                MultiplierRow(
                    players = state.players,
                    highlightIndex = state.currentPlayerIndex,
                )
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.surfaceContainer)

            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                val s = LocalAppStrings.current
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
                        text = s.pvpInDeck(deckCards.size),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                    )
                    DeckRarityIndicator(deckCards)
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

// ─── Quiz ─────────────────────────────────────────────────────────────────────

private val CorrectGreen       = Color(0xFF2E7D32)
private val CorrectGreenBorder = Color(0xFF66BB6A)
private val WrongRed           = Color(0xFFC62828)
private val WrongRedBorder     = Color(0xFFEF5350)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun QuizScreen(
    state: PvpGameUiState,
    phase: PvpPhase.Quiz,
    onAnswerSelected: (String) -> Unit,
    onConfirm: () -> Unit,
    onSurrender: () -> Unit,
    onMultiplierRowPositioned: (Int) -> Unit = {},
) {
    val answered = phase.selectedAnswer != null
    var showSurrenderDialog by remember { mutableStateOf(false) }

    if (showSurrenderDialog) {
        SurrenderDialog(
            playerName = phase.defenderName,
            onConfirm = { showSurrenderDialog = false; onSurrender() },
            onDismiss = { showSurrenderDialog = false },
        )
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                ),
                title = {
                    val s = LocalAppStrings.current
                    Text(
                        s.pvpTaskFor(phase.defenderName),
                        fontWeight = FontWeight.Bold,
                    )
                },
                actions = {
                    val s = LocalAppStrings.current
                    TextButton(onClick = { showSurrenderDialog = true }) {
                        Text(s.pvpSurrender, color = SurrenderRed, fontWeight = FontWeight.Bold)
                    }
                },
            )
        },
        bottomBar = {
            if (state.timeRemaining <= 15 && !answered) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(bottom = 12.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    TimerWidget(state.timeRemaining)
                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Box(modifier = Modifier.onGloballyPositioned { coords ->
                onMultiplierRowPositioned(coords.boundsInWindow().bottom.toInt())
            }) {
                MultiplierRow(
                    players = state.players,
                    highlightIndex = phase.defenderIndex,
                )
            }
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

                    Text(
                        text = phase.quiz.questionLabel,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )

                    Text(
                        text = phase.quiz.question,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        softWrap = true,
                    )

                    Spacer(Modifier.height(4.dp))

                    phase.quiz.options.forEach { option ->
                        val isCorrect = option == phase.quiz.correctAnswer
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
                        val isCorrect = phase.selectedAnswer == phase.quiz.correctAnswer
                        PvpResultPanel(
                            wordOriginal = phase.quiz.playedCard.original,
                            wordTranslation = phase.quiz.playedCard.translation,
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
                        Text(LocalAppStrings.current.pvpContinue, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

// AnswerState and AnswerButton are in PvpSharedComponents.kt as PvpAnswerState / PvpAnswerButton

// ─── Game Over ────────────────────────────────────────────────────────────────

@Composable
private fun GameOverScreen(
    players: List<PvpPlayerState>,
    phase: PvpPhase.GameOver,
    onPlayAgain: () -> Unit,
    onHome: () -> Unit,
) {
    val loserIndex = phase.loserIndex
    val isForced = loserIndex != null  // forfeit or AFK
    val s = LocalAppStrings.current

    // In forced endings the winner is the other player
    val winner = if (isForced) {
        players.getOrNull(1 - loserIndex!!)
    } else {
        val sorted = players.sortedByDescending { it.score }
        if (sorted.size >= 2 && sorted[0].score == sorted[1].score) null else sorted.firstOrNull()
    }

    val headerEmoji = if (isForced) "🏳️" else "🏆"
    val headerText  = if (isForced) s.pvpGameEnded else s.pvpGameOver
    val defaultName = players.getOrNull(loserIndex ?: 0)?.name ?: ""
    val reasonText  = when (phase.reason) {
        GameOverReason.FORFEIT -> s.pvpForfeit(defaultName)
        GameOverReason.AFK     -> s.pvpAfk(defaultName)
        GameOverReason.NORMAL  -> null
    }

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
            Text(headerEmoji, style = MaterialTheme.typography.displayLarge)
            Text(
                text = headerText,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
            )

            if (reasonText != null) {
                Text(
                    text = reasonText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = SurrenderRed,
                    textAlign = TextAlign.Center,
                )
            }

            Spacer(Modifier.height(4.dp))

            players.sortedByDescending { it.score }.forEach { player ->
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
                            player.name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = if (player == winner) FontWeight.ExtraBold else FontWeight.Normal,
                            color = if (player == winner) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Text(
                            s.pvpScore(player.score),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outline)

            Text(
                text = if (winner != null) s.pvpWinner(winner.name) else s.pvpDraw,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = if (winner != null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )

            Spacer(Modifier.height(8.dp))

            Button(
                onClick = onPlayAgain,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
            ) {
                Text(s.pvpPlayAgain, fontWeight = FontWeight.Bold)
            }
            OutlinedButton(
                onClick = onHome,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
            ) {
                Text(s.pvpGoHome)
            }
        }
    }
}

// ─── Shared components ────────────────────────────────────────────────────────

@Composable
internal fun SurrenderDialog(
    playerName: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    val s = LocalAppStrings.current
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(s.pvpSurrenderDialogTitle) },
        text = {
            Text(s.pvpSurrenderConfirm(playerName))
        },
        confirmButton = {
            Button(
                onClick = onConfirm,
                colors = ButtonDefaults.buttonColors(containerColor = SurrenderRed),
            ) {
                Text(s.pvpSurrender, fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) {
                Text(s.pvpCancel)
            }
        },
    )
}

@Composable
internal fun MultiplierRow(
    players: List<PvpPlayerState>,
    highlightIndex: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        players.forEachIndexed { index, player ->
            val isActive = index == highlightIndex
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (isActive) MaterialTheme.colorScheme.surfaceContainer else Color.Transparent)
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Column(modifier = Modifier.weight(1f, fill = false)) {
                    Text(
                        text = player.name,
                        style = MaterialTheme.typography.labelMedium,
                        color = if (isActive) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = "${player.score} очков",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
                MultiplierBadge(player.multiplier, player.streak)
            }
        }
    }
}

// MultiplierBadge is in PvpSharedComponents.kt

@Composable
internal fun DeckRarityIndicator(
    deckCards: List<Word>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        deckCards.forEach { card ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(Color(card.rarity.colorArgb), CircleShape)
            )
        }
    }
}

// PvpResultPanel is in PvpSharedComponents.kt

@Composable
internal fun TimerWidget(timeRemaining: Int) {
    val danger   = timeRemaining <= 5
    val color    = if (danger) Color(0xFFEF5350) else Color(0xFFF5A623)
    val progress = timeRemaining / 15f

    Box(
        modifier = Modifier.size(56.dp),
        contentAlignment = Alignment.Center,
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val stroke   = 4.dp.toPx()
            val diameter = size.minDimension - stroke
            val topLeft  = Offset(stroke / 2, stroke / 2)
            val arcSize  = Size(diameter, diameter)
            drawArc(
                color = color.copy(alpha = 0.18f),
                startAngle = -90f, sweepAngle = 360f,
                useCenter = false, topLeft = topLeft, size = arcSize,
                style = Stroke(stroke, cap = StrokeCap.Round),
            )
            drawArc(
                color = color,
                startAngle = -90f, sweepAngle = 360f * progress,
                useCenter = false, topLeft = topLeft, size = arcSize,
                style = Stroke(stroke, cap = StrokeCap.Round),
            )
        }
        Text(
            text = "$timeRemaining",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
            color = color,
        )
    }
}

// ─── Multiplier hint overlay ──────────────────────────────────────────────────

@Composable
private fun MultiplierHintOverlay(
    anchorBottomPx: Int,
    onDismiss: () -> Unit,
) {
    val density = LocalDensity.current
    val arrowSize = with(density) { 10.dp.toPx() }
    val cardHorizontalPadding = with(density) { 16.dp.toPx() }
    val hintBg = MaterialTheme.colorScheme.surfaceContainerHigh
    val hintBorder = MaterialTheme.colorScheme.outline

    // Full-screen scrim — tap outside card to dismiss
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.55f))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onDismiss,
            ),
    ) {
        Column(
            modifier = Modifier
                .offset { IntOffset(0, anchorBottomPx) }
                .padding(horizontal = 16.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = {},
                ),
        ) {
            // Upward-pointing arrow
            Canvas(
                modifier = Modifier
                    .padding(start = 24.dp)
                    .size(width = 20.dp, height = 10.dp),
            ) {
                val w = size.width
                val h = size.height
                val path = Path().apply {
                    moveTo(w / 2f, 0f)
                    lineTo(w, h)
                    lineTo(0f, h)
                    close()
                }
                drawPath(path, color = hintBorder)
                // Inner fill (slightly smaller)
                val inner = Path().apply {
                    moveTo(w / 2f, 2f)
                    lineTo(w - 2f, h)
                    lineTo(2f, h)
                    close()
                }
                drawPath(inner, color = hintBg)
            }

            // Tooltip card
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(8.dp, RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
                    .background(hintBg)
                    .border(1.dp, hintBorder, RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                // Title
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text("⚡", fontSize = 18.sp)
                    Text(
                        text = "Множитель очков",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                }

                Text(
                    text = "Правильные ответы подряд увеличивают множитель — вы зарабатываете больше очков за каждую карту!",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 18.sp,
                )

                // Streak tiers
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    listOf(
                        Triple("×1", "старт", Color(0xFF9E9E9E)),
                        Triple("×2", "5 🔥", Color(0xFF4A90E2)),
                        Triple("×3", "10 🔥", Color(0xFF9B51E0)),
                        Triple("×4", "15 🔥", Color(0xFFF5A623)),
                    ).forEach { (mult, label, color) ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(color.copy(alpha = 0.15f), RoundedCornerShape(6.dp))
                                    .border(1.dp, color.copy(alpha = 0.5f), RoundedCornerShape(6.dp))
                                    .padding(horizontal = 8.dp, vertical = 3.dp),
                            ) {
                                Text(
                                    text = mult,
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = color,
                                )
                            }
                            Text(
                                text = label,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 10.sp,
                            )
                        }
                    }
                }

                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text("Понял!", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

// CompactHandCard → replaced by PvpHandCard from PvpSharedComponents.kt
