package com.example.kartonki.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.kartonki.R
import com.example.kartonki.ui.screen.shop.PackShopViewModel
import com.example.kartonki.ui.theme.LocalAppStrings
import com.example.kartonki.ui.theme.AccentBlue
import com.example.kartonki.ui.theme.AccentGold
import com.example.kartonki.ui.theme.AccentPurple
import com.example.kartonki.ui.theme.AccentTeal
import com.example.kartonki.ui.theme.BgDeep
import com.example.kartonki.ui.theme.TextSecondary
import com.example.kartonki.ui.theme.glowEffect

@Composable
fun HomeScreen(
    onNavigateToStudy: () -> Unit,
    onNavigateToPvp: () -> Unit,
    onNavigateToCollection: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToShop: () -> Unit,
    onNavigateToProblemWords: () -> Unit,
    packViewModel: PackShopViewModel = hiltViewModel(),
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }
    val packState by packViewModel.uiState.collectAsState()
    val homeState by homeViewModel.uiState.collectAsState()
    val s = LocalAppStrings.current

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) homeViewModel.refresh()
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF0D1B30), BgDeep),
                )
            )
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        // Settings gear button (top-right corner)
        IconButton(
            onClick = onNavigateToSettings,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp),
        ) {
            Text("⚙", fontSize = 22.sp, color = AccentGold.copy(alpha = 0.8f))
        }

        // Free pack indicator (top-left corner)
        FreePackIndicator(
            activityCount = packState.activityCount,
            freePackCount = packState.freePackCount,
            onClick = onNavigateToShop,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(10.dp),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            // ── Logo ──────────────────────────────────────────────────────────
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(tween(700)) + slideInVertically(tween(700)) { it / 3 },
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "✦",
                        fontSize = 36.sp,
                        color = AccentGold,
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.app_name).uppercase(),
                        style = MaterialTheme.typography.displayMedium.copy(
                            letterSpacing = 6.sp,
                        ),
                        fontWeight = FontWeight.ExtraBold,
                        color = AccentGold,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = s.homeSubtitle,
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary,
                        textAlign = TextAlign.Center,
                    )
                }
            }

            Spacer(Modifier.height(40.dp))

            // ── Buttons ───────────────────────────────────────────────────────
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(tween(700, delayMillis = 150)) +
                        slideInVertically(tween(700, delayMillis = 150)) { it / 2 },
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    GradientButton(
                        text = s.homePveButton,
                        gradient = Brush.horizontalGradient(
                            listOf(Color(0xFF1565C0), AccentBlue)
                        ),
                        glowColor = AccentBlue,
                        onClick = onNavigateToStudy,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    GradientButton(
                        text = s.homePvpButton,
                        gradient = Brush.horizontalGradient(
                            listOf(Color(0xFF6A0DAD), AccentPurple)
                        ),
                        glowColor = AccentPurple,
                        onClick = onNavigateToPvp,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    GradientButton(
                        text = s.homeCollectionButton,
                        gradient = Brush.horizontalGradient(
                            listOf(Color(0xFF00695C), AccentTeal)
                        ),
                        glowColor = AccentTeal,
                        onClick = onNavigateToCollection,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    GradientButton(
                        text = s.homeShopButton,
                        gradient = Brush.horizontalGradient(
                            listOf(Color(0xFF7B3F00), AccentGold)
                        ),
                        glowColor = AccentGold,
                        onClick = onNavigateToShop,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    if (homeState.problemWordCount > 0) {
                        ProblemWordsBanner(
                            count = homeState.problemWordCount,
                            onClick = onNavigateToProblemWords,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ProblemWordsBanner(
    count: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val warningColor = Color(0xFFFF6F00)
    val s = LocalAppStrings.current
    Box(
        modifier = modifier
            .glowEffect(warningColor, glowRadius = 14.dp, cornerRadius = 16.dp, alpha = 0.35f)
            .clip(RoundedCornerShape(16.dp))
            .background(
                Brush.horizontalGradient(
                    listOf(Color(0xFF3D1A00), Color(0xFF5A2800))
                )
            )
            .border(1.5.dp, warningColor.copy(alpha = 0.7f), RoundedCornerShape(16.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick,
            )
            .padding(vertical = 14.dp, horizontal = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text("⚠️", fontSize = 18.sp)
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = s.homeProblemWordsTitle(count),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = warningColor,
                )
                Text(
                    text = s.homeProblemWordsSubtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary,
                )
            }
            Text("›", fontSize = 22.sp, color = warningColor)
        }
    }
}

@Composable
private fun FreePackIndicator(
    activityCount: Int,
    freePackCount: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val isReady = freePackCount >= 1
    val glowAlpha = if (isReady) 0.5f else 0f
    val borderColor = if (isReady) AccentGold else AccentGold.copy(alpha = 0.3f)
    val bgColor = if (isReady) Color(0xFF2A1E00) else Color(0xFF111A26)

    Box(
        modifier = modifier
            .then(if (isReady) Modifier.glowEffect(AccentGold, 10.dp, 20.dp, glowAlpha) else Modifier)
            .clip(RoundedCornerShape(20.dp))
            .background(bgColor)
            .border(1.dp, borderColor, RoundedCornerShape(20.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick,
            )
            .padding(horizontal = 10.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            Text("🎴", fontSize = 14.sp)
            Text(
                text = if (isReady) LocalAppStrings.current.homePackReady else "$activityCount/3",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = if (isReady) AccentGold else TextSecondary,
            )
        }
    }
}

@Composable
private fun GradientButton(
    text: String,
    gradient: Brush,
    glowColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale = if (isPressed) 0.97f else 1f

    Box(
        modifier = modifier
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .glowEffect(glowColor, glowRadius = 20.dp, cornerRadius = 16.dp, alpha = 0.45f)
            .clip(RoundedCornerShape(16.dp))
            .background(gradient)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
            )
            .padding(vertical = 18.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            letterSpacing = 0.5.sp,
        )
    }
}
