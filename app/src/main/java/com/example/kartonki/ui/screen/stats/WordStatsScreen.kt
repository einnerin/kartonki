package com.example.kartonki.ui.screen.stats

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.remember
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.WordStat
import com.example.kartonki.domain.model.WordStatSort
import com.example.kartonki.ui.component.RarityBadge
import com.example.kartonki.ui.theme.LocalAppStrings
import com.example.kartonki.ui.theme.localizedName
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordStatsScreen(
    onNavigateBack: () -> Unit,
    onNavigateToProblemWords: () -> Unit = {},
    viewModel: WordStatsViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    val s = LocalAppStrings.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(s.wordStatsTitle) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .navigationBarsPadding(),
        ) {
            // Problem words banner
            if (state.problemWordCount > 0) {
                ProblemWordsBannerStats(
                    count = state.problemWordCount,
                    onClick = onNavigateToProblemWords,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                )
            }
            // Sort chips
            LazyRow(
                contentPadding = PaddingValues(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 8.dp),
            ) {
                val sorts = listOf(
                    WordStatSort.MOST_ERRORS to s.wordStatsSortDifficult,
                    WordStatSort.EASIEST to s.wordStatsSortEasiest,
                    WordStatSort.MOST_ENCOUNTERS to s.wordStatsSortFrequent,
                    WordStatSort.RECENTLY_STUDIED to s.wordStatsSortRecent,
                )
                items(sorts) { (sort, label) ->
                    FilterChip(
                        selected = state.sortBy == sort,
                        onClick = { viewModel.onSortChange(sort) },
                        label = { Text(label) },
                    )
                }
            }

            // Rarity filter chips
            LazyRow(
                contentPadding = PaddingValues(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(bottom = 8.dp),
            ) {
                val rarities: List<Rarity?> = listOf(null) + Rarity.entries
                items(rarities) { rarity ->
                    val label = rarity?.localizedName(s) ?: s.filterAll
                    val color = rarity?.let { Color(it.colorArgb) } ?: MaterialTheme.colorScheme.primary
                    FilterChip(
                        selected = state.rarityFilter == rarity,
                        onClick = { viewModel.onRarityFilterChange(rarity) },
                        label = { Text(label) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = color.copy(alpha = 0.2f),
                            selectedLabelColor = color,
                        ),
                    )
                }
            }

            HorizontalDivider()

            if (state.isLoading) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (state.words.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        s.wordStatsEmpty,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    )
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    items(state.words) { stat ->
                        WordStatRow(stat)
                    }
                }
            }
        }
    }
}

@Composable
private fun ProblemWordsBannerStats(
    count: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val warningColor = Color(0xFFFF6F00)
    val s = LocalAppStrings.current
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(
                Brush.horizontalGradient(listOf(Color(0xFF3D1A00), Color(0xFF5A2800)))
            )
            .border(1.5.dp, warningColor.copy(alpha = 0.7f), RoundedCornerShape(14.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick,
            )
            .padding(horizontal = 14.dp, vertical = 12.dp),
    ) {
        androidx.compose.foundation.layout.Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Text("⚠️", fontSize = 20.sp)
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = s.wordStatsProblemTitle(count),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = warningColor,
                )
                Text(
                    text = s.wordStatsProblemSubtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            Text("›", fontSize = 22.sp, color = warningColor)
        }
    }
}

@Composable
private fun WordStatRow(stat: WordStat) {
    val s = LocalAppStrings.current
    val errorPercent = (stat.errorRate * 100).roundToInt()
    val errorColor = when {
        errorPercent >= 60 -> Color(0xFFEF5350)
        errorPercent >= 30 -> Color(0xFFFF9800)
        else               -> Color(0xFF66BB6A)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        RarityBadge(rarity = stat.rarity)
        Column(modifier = Modifier.weight(1f)) {
            Text(
                stat.original,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )
            Text(
                stat.translation,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(
                s.wordStatsErrors(errorPercent),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = errorColor,
            )
            Text(
                s.wordStatsEncounters(stat.encounters),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
