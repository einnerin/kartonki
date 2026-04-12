package com.example.kartonki.ui.screen.shop

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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

    BackHandler {
        if (state.allRevealed) onFinished()
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
        if (state.isLoading) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                CircularProgressIndicator(color = AccentGold, modifier = Modifier.size(48.dp))
                Text(
                    text = s.packOpeningLoading,
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextSecondary,
                )
            }
        } else {
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
                    text = s.packOpeningProgress(state.revealedCount, state.cards.size),
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary,
                )

                Spacer(Modifier.height(16.dp))

                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    itemsIndexed(state.cards, key = { _, word -> word.id }) { index, word ->
                        PackCardSlot(
                            word = word,
                            isRevealed = index in state.revealedIndices,
                            onReveal = { viewModel.revealCard(index) },
                        )
                    }
                }

                // Bottom button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 16.dp),
                ) {
                    if (!state.allRevealed) {
                        GoldGradientButton(
                            text = s.packOpeningRevealAll,
                            onClick = { viewModel.revealAll() },
                        )
                    } else {
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            Button(
                                onClick = onFinished,
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
                                onClick = onNavigateHome,
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
            }
        }
    }
}

@Composable
private fun GoldGradientButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .glowEffect(AccentGold, glowRadius = 18.dp, cornerRadius = 16.dp, alpha = 0.45f),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        contentPadding = PaddingValues(0.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(listOf(Color(0xFF1A4A8A), AccentGold)),
                    shape = RoundedCornerShape(16.dp),
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
    }
}

@Composable
private fun PackCardSlot(
    word: Word,
    isRevealed: Boolean,
    onReveal: () -> Unit,
) {
    val rarityColor = Color(word.rarity.colorArgb)

    // 3D flip: 0° = back face, 180° = front face
    val flipRotation = remember { Animatable(0f) }
    LaunchedEffect(isRevealed) {
        if (isRevealed && flipRotation.value < 90f) {
            flipRotation.animateTo(
                targetValue = 180f,
                animationSpec = tween(durationMillis = 450, easing = FastOutSlowInEasing),
            )
        }
    }

    val isFaceUp = flipRotation.value > 90f
    val glowColor = if (isFaceUp) rarityColor else AccentGold
    val glowAlpha = if (isFaceUp) 0.4f else 0.15f
    val borderColor = when {
        isFaceUp -> rarityColor.copy(alpha = 0.8f)
        else     -> AccentGold.copy(alpha = 0.35f)
    }

    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .width(280.dp)
            .heightIn(min = 120.dp)
            .graphicsLayer {
                rotationY = flipRotation.value
                cameraDistance = 12f * density
            }
            .glowEffect(glowColor, glowRadius = 16.dp, cornerRadius = 18.dp, alpha = glowAlpha)
            .clip(RoundedCornerShape(18.dp))
            .background(
                if (isFaceUp) {
                    Brush.verticalGradient(
                        listOf(rarityColor.copy(alpha = 0.25f), BgCard)
                    )
                } else {
                    Brush.verticalGradient(listOf(BgCard, Color(0xFF0D1520)))
                }
            )
            .border(1.5.dp, borderColor, RoundedCornerShape(18.dp))
            .then(
                if (!isRevealed) Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onReveal,
                ) else Modifier
            )
            .padding(horizontal = 16.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center,
    ) {
        if (!isFaceUp) {
            // Back face
            Text(
                text = "?",
                fontSize = 42.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AccentGold.copy(alpha = 0.5f),
            )
        } else {
            // Front face — counter-rotate to undo the mirror from parent's rotationY ≈ 180°
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer { rotationY = 180f },
                contentAlignment = Alignment.CenterStart,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    RarityBadge(rarity = word.rarity)
                    Text(
                        text = word.original,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        fontSize = 20.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = word.translation,
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}
