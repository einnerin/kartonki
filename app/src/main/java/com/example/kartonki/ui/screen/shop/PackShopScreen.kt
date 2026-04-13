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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.kartonki.ui.theme.TextPrimary
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
        // Centered content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            // Pack art card
            Box(
                modifier = Modifier
                    .size(180.dp)
                    .glowEffect(AccentGold, glowRadius = 32.dp, cornerRadius = 24.dp, alpha = 0.5f)
                    .clip(RoundedCornerShape(24.dp))
                    .background(
                        Brush.verticalGradient(
                            listOf(Color(0xFF1C1400), Color(0xFF2A1E00), Color(0xFF3A2A00))
                        )
                    )
                    .border(
                        2.dp,
                        Brush.verticalGradient(listOf(RarityLegendary, AccentGold.copy(alpha = 0.4f))),
                        RoundedCornerShape(24.dp),
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text("✦", fontSize = 24.sp, color = AccentGold)
                    Text("🎴", fontSize = 48.sp)
                    Text("✦", fontSize = 18.sp, color = AccentGold.copy(alpha = 0.6f))
                }
            }

            Spacer(Modifier.height(24.dp))

            // Pack name (language-aware)
            Text(
                text = s.shopPackNameFor(state.languagePair),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold,
                color = AccentGold,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = s.shopPackCards,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                textAlign = TextAlign.Center,
            )

            Spacer(Modifier.height(32.dp))

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
                    val isAffordable = state.freePackCount >= count
                    if (isSelected) {
                        Button(
                            onClick = { viewModel.setPackCount(count) },
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
                            onClick = { viewModel.setPackCount(count) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = if (isAffordable) AccentGold else TextSecondary,
                            ),
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                if (isAffordable) AccentGold.copy(alpha = 0.5f)
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

            // Available packs indicator
            Text(
                text = s.shopHavePacks(state.freePackCount),
                style = MaterialTheme.typography.bodyMedium,
                color = if (state.canOpen) AccentGold.copy(alpha = 0.8f) else TextSecondary,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.height(20.dp))

            // Open button
            if (state.canOpen) {
                Button(
                    onClick = { onOpenPacks(state.selectedPackCount) },
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
                            text = "${s.shopOpenButton} ×${state.selectedPackCount}",
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
                        text = s.shopNoPacks,
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
    }
}
