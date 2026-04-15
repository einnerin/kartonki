package com.example.kartonki.ui.screen.pvp

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.ui.component.DeckLevelBadge
import com.example.kartonki.ui.theme.AccentGold
import com.example.kartonki.ui.theme.AccentPurple
import com.example.kartonki.ui.theme.BgDeep
import com.example.kartonki.ui.theme.TextSecondary
import com.example.kartonki.ui.theme.glowEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnlineMatchmakingScreen(
    onNavigateBack: () -> Unit,
    onMatchFound: (matchId: String, myIndex: Int) -> Unit,
    viewModel: OnlineMatchmakingViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    // Navigate when match found
    LaunchedEffect(uiState.phase) {
        val phase = uiState.phase
        if (phase is OnlineMatchmakingUiState.Phase.Found) {
            onMatchFound(phase.matchId, phase.myIndex)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF0D1B30), BgDeep)))
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        IconButton(
            onClick = {
                if (uiState.phase is OnlineMatchmakingUiState.Phase.Searching) {
                    viewModel.cancelSearch()
                } else {
                    onNavigateBack()
                }
            },
            modifier = Modifier.padding(8.dp),
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = AccentGold.copy(alpha = 0.8f),
            )
        }

        when (val phase = uiState.phase) {
            is OnlineMatchmakingUiState.Phase.DeckSelect -> {
                DeckSelectContent(
                    uiState = uiState,
                    onDeckSelected = viewModel::selectDeck,
                    onStartSearch = viewModel::startSearch,
                )
            }
            is OnlineMatchmakingUiState.Phase.Searching -> {
                SearchingContent(onCancel = viewModel::cancelSearch)
            }
            is OnlineMatchmakingUiState.Phase.Found -> {
                // Navigating...
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = AccentGold)
                }
            }
        }
    }

    // Error dialog
    uiState.error?.let { err ->
        AlertDialog(
            onDismissRequest = viewModel::dismissError,
            title = { Text("Ошибка") },
            text = { Text(err) },
            confirmButton = { TextButton(onClick = viewModel::dismissError) { Text("OK") } },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DeckSelectContent(
    uiState: OnlineMatchmakingUiState,
    onDeckSelected: (PvpDeckOption) -> Unit,
    onStartSearch: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("🌐", fontSize = 40.sp)
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Онлайн PvP",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = AccentGold,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Выберите колоду и найдите соперника",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary,
        )

        Spacer(Modifier.height(40.dp))

        if (uiState.isLoading) {
            CircularProgressIndicator(color = AccentGold)
        } else if (uiState.decks.isEmpty()) {
            Text(
                text = "Создайте хотя бы одну колоду перед игрой",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        } else {
            var expanded by remember { mutableStateOf(false) }
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it },
                modifier = Modifier.fillMaxWidth(),
            ) {
                OutlinedTextField(
                    value = uiState.selectedDeck?.name ?: "",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Выберите колоду") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(MenuAnchorType.PrimaryNotEditable),
                )
                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    uiState.decks.forEach { deck ->
                        DropdownMenuItem(
                            text = {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            deck.name,
                                            color = if (!deck.isValid) MaterialTheme.colorScheme.error else Color.Unspecified,
                                        )
                                        if (!deck.isValid) {
                                            Text(
                                                "Состав не соответствует уровню",
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.error,
                                            )
                                        }
                                    }
                                    if (!deck.isValid) {
                                        Icon(
                                            imageVector = Icons.Filled.Warning,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.error,
                                            modifier = Modifier.size(16.dp),
                                        )
                                    }
                                    DeckLevelBadge(deck.level)
                                }
                            },
                            onClick = {
                                onDeckSelected(deck)
                                expanded = false
                            },
                        )
                    }
                }
            }

            val selectedInvalid = uiState.selectedDeck?.isValid == false
            if (selectedInvalid) {
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Выбранная колода не соответствует уровню",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                )
            }

            Spacer(Modifier.height(32.dp))

            Button(
                onClick = onStartSearch,
                enabled = uiState.selectedDeck?.isValid == true,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = AccentPurple),
            ) {
                Text(
                    text = "🔍  Найти матч онлайн",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
private fun SearchingContent(onCancel: () -> Unit) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "pulse_scale",
    )
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "pulse_alpha",
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // Pulsing circle
        Box(
            modifier = Modifier
                .size(120.dp)
                .scale(scale)
                .glowEffect(AccentPurple, 24.dp, 60.dp, alpha * 0.5f)
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        listOf(AccentPurple.copy(alpha = 0.8f), Color(0xFF6A0DAD))
                    )
                )
                .border(2.dp, AccentPurple.copy(alpha = alpha), CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Text("⚔️", fontSize = 40.sp)
        }

        Spacer(Modifier.height(32.dp))
        Text(
            text = "Ищем соперника...",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Мы ищем игрока с колодой того же уровня.\nОтмените поиск в любой момент.",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 40.dp),
        )

        Spacer(Modifier.height(48.dp))

        // Animated dots
        val dot by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 3f,
            animationSpec = infiniteRepeatable(tween(1200), RepeatMode.Restart),
            label = "dots",
        )
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(3) { i ->
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(
                            AccentPurple.copy(alpha = if (dot.toInt() == i) 1f else 0.3f)
                        ),
                )
            }
        }

        Spacer(Modifier.height(48.dp))

        Button(
            onClick = onCancel,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1A1A2E),
                contentColor = Color.White,
            ),
            modifier = Modifier
                .border(1.dp, Color(0xFF444466), RoundedCornerShape(50))
                .clip(RoundedCornerShape(50)),
        ) {
            Text("✕  Отменить поиск")
        }
    }
}
