package com.example.kartonki.ui.screen.shop

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.example.kartonki.ui.theme.AccentGold
import com.example.kartonki.ui.theme.LocalAppStrings
import com.example.kartonki.ui.theme.BgCard
import com.example.kartonki.ui.theme.BgDeep
import com.example.kartonki.ui.theme.BgMedium
import com.example.kartonki.ui.theme.RarityLegendary
import com.example.kartonki.ui.theme.TextSecondary
import com.example.kartonki.ui.theme.glowEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PackShopScreen(
    onNavigateBack: () -> Unit,
    onOpenPacks: (Int) -> Unit,
    viewModel: PackShopViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    val s = LocalAppStrings.current

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BgMedium,
                    titleContentColor = AccentGold,
                    navigationIconContentColor = Color.White,
                ),
                title = {
                    Text(s.shopTitle, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(Color(0xFF0D1B30), BgDeep)))
                .padding(innerPadding)
                .navigationBarsPadding(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TokenBalanceHeader(
                    tokens = state.tokensBalance,
                    dailyDone = state.dailyActivityCount,
                    dailyMax = state.dailyLimit,
                    isCapReached = state.isDailyCapReached,
                )

                Spacer(Modifier.height(24.dp))

                FreePackSection(
                    state = state,
                    onSetCount = viewModel::setPackCount,
                    onBuy = { onOpenPacks(state.selectedPackCount) },
                )

                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun TokenBalanceHeader(
    tokens: Int,
    dailyDone: Int,
    dailyMax: Int,
    isCapReached: Boolean,
) {
    val s = LocalAppStrings.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .glowEffect(AccentGold, glowRadius = 18.dp, cornerRadius = 16.dp, alpha = 0.4f)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    Brush.horizontalGradient(listOf(Color(0xFF1C1400), Color(0xFF3A2A00)))
                )
                .border(1.dp, AccentGold.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                .padding(horizontal = 20.dp, vertical = 14.dp),
        ) {
            Text(
                text = s.shopTokensBalance(tokens) + " 🪙",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold,
                color = AccentGold,
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = if (isCapReached) s.shopDailyLimitReached
                   else s.shopDailyProgress(dailyDone, dailyMax),
            style = MaterialTheme.typography.bodySmall,
            color = if (isCapReached) RarityLegendary.copy(alpha = 0.85f) else TextSecondary,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun FreePackSection(
    state: PackShopUiState,
    onSetCount: (Int) -> Unit,
    onBuy: () -> Unit,
) {
    val s = LocalAppStrings.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Pack art card
        Box(
            modifier = Modifier
                .size(140.dp)
                .glowEffect(AccentGold, glowRadius = 26.dp, cornerRadius = 20.dp, alpha = 0.45f)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF1C1400), Color(0xFF2A1E00), Color(0xFF3A2A00))
                    )
                )
                .border(
                    2.dp,
                    Brush.verticalGradient(listOf(RarityLegendary, AccentGold.copy(alpha = 0.4f))),
                    RoundedCornerShape(20.dp),
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text("🎴", fontSize = 56.sp)
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = s.shopPackNameFor(state.languagePair),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
            color = AccentGold,
            textAlign = TextAlign.Center,
        )
        Text(
            text = s.shopPackCards,
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary,
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(20.dp))

        // Count selector
        Text(
            text = s.shopCountLabel,
            style = MaterialTheme.typography.labelLarge,
            color = TextSecondary,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            PACK_COUNT_OPTIONS.forEach { count ->
                val isSelected = state.selectedPackCount == count
                val canAfford = state.tokensBalance >= count * 100
                if (isSelected) {
                    Button(
                        onClick = { onSetCount(count) },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AccentGold,
                            contentColor = Color(0xFF1A1000),
                        ),
                        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 10.dp),
                    ) {
                        Text("×$count", fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                    }
                } else {
                    OutlinedButton(
                        onClick = { onSetCount(count) },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = if (canAfford) AccentGold else TextSecondary,
                        ),
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp,
                            if (canAfford) AccentGold.copy(alpha = 0.5f)
                            else TextSecondary.copy(alpha = 0.2f),
                        ),
                        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 10.dp),
                    ) {
                        Text("×$count", fontWeight = FontWeight.Medium, fontSize = 15.sp)
                    }
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        // Cost
        Text(
            text = s.shopCost(state.cost),
            style = MaterialTheme.typography.bodyMedium,
            color = if (state.canAfford) AccentGold else TextSecondary,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(16.dp))

        // Buy button
        if (state.canAfford) {
            Button(
                onClick = onBuy,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .glowEffect(AccentGold, glowRadius = 20.dp, cornerRadius = 16.dp, alpha = 0.5f),
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
                        text = "${s.shopBuyButton} ×${state.selectedPackCount}",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(BgCard)
                    .border(1.dp, TextSecondary.copy(alpha = 0.3f), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = s.shopInsufficientTokens,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextSecondary,
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = s.shopEarnPacks,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary.copy(alpha = 0.6f),
                textAlign = TextAlign.Center,
            )
        }
    }
}

