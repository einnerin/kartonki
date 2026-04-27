package com.example.kartonki.ui.screen.shop

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.component.RarityBadge
import com.example.kartonki.ui.theme.AccentGold
import com.example.kartonki.ui.theme.LocalAppStrings
import com.example.kartonki.ui.theme.BgCard
import com.example.kartonki.ui.theme.BgDeep
import com.example.kartonki.ui.theme.TextSecondary
import com.example.kartonki.ui.theme.glowEffect

@Composable
fun PackOpeningScreen(
    onFinished: () -> Unit,
    onNavigateHome: () -> Unit,
    viewModel: PackOpeningViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    val s = LocalAppStrings.current

    var currentIndex by remember { mutableIntStateOf(0) }
    val showSummary = state.cards.isNotEmpty() && currentIndex >= state.cards.size

    // If purchase failed (e.g. balance changed mid-flight), bounce back.
    LaunchedEffect(state.purchaseFailed) {
        if (state.purchaseFailed) onFinished()
    }

    BackHandler {
        if (showSummary) onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF080C14), Color(0xFF0F1828), BgDeep),
                )
            )
            .statusBarsPadding()
            .navigationBarsPadding(),
        contentAlignment = Alignment.Center,
    ) {
        when {
            state.isLoading -> LoadingPhase(s.packOpeningLoading)
            showSummary -> SummaryPhase(
                cards = state.cards,
                compensationTokens = state.compensationTokens,
                onToShop = onFinished,
                onToHome = onNavigateHome,
            )
            else -> StackRevealPhase(
                cards = state.cards,
                currentIndex = currentIndex,
                revealedIndices = state.revealedIndices,
                onTapTopCard = {
                    val i = currentIndex
                    if (i in state.revealedIndices) {
                        currentIndex = (i + 1).coerceAtMost(state.cards.size)
                    } else {
                        viewModel.revealCard(i)
                    }
                },
                onSkipAll = {
                    viewModel.revealAll()
                    currentIndex = state.cards.size
                },
            )
        }
    }
}

// ─── Phases ─────────────────────────────────────────────────────────────────

@Composable
private fun LoadingPhase(loadingText: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        CircularProgressIndicator(color = AccentGold, modifier = Modifier.size(48.dp))
        Text(
            text = loadingText,
            style = MaterialTheme.typography.bodyLarge,
            color = TextSecondary,
        )
    }
}

@Composable
private fun StackRevealPhase(
    cards: List<Word>,
    currentIndex: Int,
    revealedIndices: Set<Int>,
    onTapTopCard: () -> Unit,
    onSkipAll: () -> Unit,
) {
    val s = LocalAppStrings.current
    val total = cards.size

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = s.packOpeningTitle,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold,
            color = AccentGold,
            letterSpacing = 2.sp,
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = s.packOpeningProgress(
                (currentIndex + 1).coerceAtMost(total),
                total,
            ),
            style = MaterialTheme.typography.bodySmall,
            color = TextSecondary,
        )

        // Card stack — fills the rest of vertical space
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center,
        ) {
            // Render top card (depth=0) and 3 peek cards behind (depth=1..3),
            // plus 1 frame of "exit" (depth=-1) for the card sliding up out of view.
            cards.forEachIndexed { i, word ->
                val depth = i - currentIndex
                if (depth in -1..3) {
                    Box(modifier = Modifier.zIndex((10 - depth).toFloat())) {
                        StackedCard(
                            word = word,
                            depth = depth,
                            isRevealed = i in revealedIndices,
                            isInteractive = depth == 0,
                            onTap = onTapTopCard,
                        )
                    }
                }
            }
        }

        // Skip-all button (only while we still have unrevealed cards)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center,
        ) {
            if (revealedIndices.size < total) {
                TextButton(onClick = onSkipAll) {
                    Text(
                        text = s.packOpeningRevealAll,
                        color = TextSecondary,
                        fontSize = 14.sp,
                    )
                }
            } else {
                // After all revealed — hint to advance
                Text(
                    text = "•••",
                    color = AccentGold.copy(alpha = 0.6f),
                    fontSize = 18.sp,
                )
            }
        }
    }
}

@Composable
private fun SummaryPhase(
    cards: List<Word>,
    compensationTokens: Int,
    onToShop: () -> Unit,
    onToHome: () -> Unit,
) {
    val s = LocalAppStrings.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = s.packOpeningTitle,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold,
            color = AccentGold,
            letterSpacing = 2.sp,
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = s.packOpeningProgress(cards.size, cards.size),
            style = MaterialTheme.typography.bodySmall,
            color = TextSecondary,
        )

        if (compensationTokens > 0) {
            Spacer(Modifier.height(8.dp))
            Text(
                text = s.packOpeningCompensation(compensationTokens),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = AccentGold,
            )
        }

        Spacer(Modifier.height(20.dp))

        // Grid: 2 + 3 layout for 5 cards
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ) {
            val firstRow = cards.take(2)
            val secondRow = cards.drop(2).take(3)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            ) {
                firstRow.forEach { w ->
                    SummaryCard(word = w, modifier = Modifier.weight(1f, fill = false))
                }
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            ) {
                secondRow.forEach { w ->
                    SummaryCard(word = w, modifier = Modifier.weight(1f, fill = false))
                }
            }
        }

        // Bottom buttons
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Button(
                onClick = onToShop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .glowEffect(AccentGold, glowRadius = 18.dp, cornerRadius = 16.dp, alpha = 0.5f),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(0.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.horizontalGradient(listOf(Color(0xFF7B3F00), AccentGold)),
                            shape = RoundedCornerShape(16.dp),
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = s.packOpeningToShop,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                }
            }
            Button(
                onClick = onToHome,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
            ) {
                Text(
                    text = s.packOpeningToHome,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}

// ─── Cards ──────────────────────────────────────────────────────────────────

/**
 * Card in the reveal stack.
 * @param depth 0 = top (large, interactive); 1..3 = peek cards behind, scaled and offset down;
 *              -1 = card sliding up and out of view
 */
@Composable
private fun StackedCard(
    word: Word,
    depth: Int,
    isRevealed: Boolean,
    isInteractive: Boolean,
    onTap: () -> Unit,
) {
    val rarityColor = Color(word.rarity.colorArgb)

    // For depth >= 0: stack visually with downward offset and shrink.
    // For depth = -1: slide up and fade (exit animation for the card just advanced).
    val targetScale = if (depth >= 0) 1f - depth * 0.06f else 1.05f
    val targetOffsetY = if (depth >= 0) (depth * 18).dp else (-360).dp
    val targetAlpha = when {
        depth < 0 -> 0f
        else -> 1f - depth * 0.20f
    }

    val scale by animateFloatAsState(targetScale, tween(350, easing = FastOutSlowInEasing), label = "stack-scale")
    val offsetY by animateDpAsState(targetOffsetY, tween(350, easing = FastOutSlowInEasing), label = "stack-offsetY")
    val alpha by animateFloatAsState(targetAlpha, tween(350, easing = FastOutSlowInEasing), label = "stack-alpha")

    val flipRotation = remember { Animatable(0f) }
    LaunchedEffect(isRevealed) {
        if (isRevealed && flipRotation.value < 90f) {
            flipRotation.animateTo(
                targetValue = 180f,
                animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
            )
        }
    }

    val isFaceUp = flipRotation.value > 90f
    val glowColor = if (isFaceUp) rarityColor else AccentGold
    val glowAlpha = when {
        depth != 0 -> 0.0f
        isFaceUp -> 0.55f
        else -> 0.20f
    }
    val borderColor = when {
        isFaceUp -> rarityColor.copy(alpha = 0.85f)
        else -> AccentGold.copy(alpha = 0.4f)
    }

    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .graphicsLayer {
                this.translationY = offsetY.toPx()
                scaleX = scale
                scaleY = scale
                this.alpha = alpha
            }
            .width(280.dp)
            .aspectRatio(0.72f)
            .graphicsLayer {
                rotationY = flipRotation.value
                cameraDistance = 12f * density
            }
            .glowEffect(glowColor, glowRadius = 20.dp, cornerRadius = 22.dp, alpha = glowAlpha)
            .clip(RoundedCornerShape(22.dp))
            .background(
                if (isFaceUp) {
                    Brush.verticalGradient(
                        listOf(rarityColor.copy(alpha = 0.35f), BgCard),
                    )
                } else {
                    Brush.verticalGradient(
                        listOf(BgCard, Color(0xFF0D1520)),
                    )
                }
            )
            .border(1.5.dp, borderColor, RoundedCornerShape(22.dp))
            .then(
                if (isInteractive) Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onTap,
                ) else Modifier
            )
            .padding(horizontal = 22.dp, vertical = 24.dp),
        contentAlignment = Alignment.Center,
    ) {
        if (!isFaceUp) {
            Text(
                text = "?",
                fontSize = 80.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AccentGold.copy(alpha = 0.45f),
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer { rotationY = 180f },
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(14.dp, Alignment.CenterVertically),
                ) {
                    RarityBadge(rarity = word.rarity)
                    Text(
                        text = word.original,
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        fontSize = 30.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = word.translation,
                        style = MaterialTheme.typography.titleMedium,
                        color = TextSecondary,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

/**
 * Compact card for the summary grid — always face-up, no flip animation.
 */
@Composable
private fun SummaryCard(
    word: Word,
    modifier: Modifier = Modifier,
) {
    val rarityColor = Color(word.rarity.colorArgb)
    Box(
        modifier = modifier
            .width(108.dp)
            .aspectRatio(0.72f)
            .glowEffect(rarityColor, glowRadius = 10.dp, cornerRadius = 14.dp, alpha = 0.5f)
            .clip(RoundedCornerShape(14.dp))
            .background(
                Brush.verticalGradient(
                    listOf(rarityColor.copy(alpha = 0.3f), BgCard),
                )
            )
            .border(1.dp, rarityColor.copy(alpha = 0.7f), RoundedCornerShape(14.dp))
            .padding(horizontal = 8.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
        ) {
            RarityBadge(rarity = word.rarity)
            Text(
                text = word.original,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = word.translation,
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}
