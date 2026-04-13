package com.example.kartonki.ui.screen.study

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.TextButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.kartonki.domain.model.Rarity
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.ui.theme.LocalAppStrings
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.kartonki.R
import com.example.kartonki.ui.component.RarityBadge
import com.example.kartonki.ui.component.RarityFilterChips
import com.example.kartonki.ui.theme.BgCard
import com.example.kartonki.ui.theme.BgDeep
import com.example.kartonki.ui.theme.BgMedium
import com.example.kartonki.ui.theme.TextSecondary
import com.example.kartonki.ui.theme.glowEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudyScreen(
    onNavigateToSetDetail: (Long) -> Unit,
    onNavigateToProblemWords: () -> Unit,
    onNavigateBack: () -> Unit,
    viewModel: StudyViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) viewModel.refresh()
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    Scaffold(
        containerColor = BgDeep,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BgMedium,
                    titleContentColor = Color.White,
                ),
                title = { Text(LocalAppStrings.current.studyTitle, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            RarityFilterChips(
                activeFilters = uiState.activeFilters,
                onToggle = { viewModel.toggleFilter(it) },
            )
            // Problem words chip — appears when there are problem words
            if (uiState.problemWordCount > 0) {
                ProblemWordsChip(
                    count = uiState.problemWordCount,
                    onClick = onNavigateToProblemWords,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 12.dp, bottom = 4.dp),
                )
            }
            // First-time hint about the problem words chip
            if (uiState.showProblemChipHint) {
                ProblemChipHintCard(
                    onDismiss = { viewModel.dismissProblemChipHint() },
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                )
            }
            HorizontalDivider(color = Color.White.copy(alpha = 0.08f))

            val listState = rememberLazyListState()

            // Restore saved scroll position when the screen re-enters composition
            // (e.g. language change causes ViewModel recreation).
            LaunchedEffect(Unit) {
                val idx = viewModel.savedScrollIndex
                val off = viewModel.savedScrollOffset
                if (idx > 0 || off > 0) {
                    listState.scrollToItem(idx, off)
                }
            }

            // Persist scroll position continuously so it survives navigation.
            LaunchedEffect(listState) {
                snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
                    .collect { (index, offset) -> viewModel.saveScrollPosition(index, offset) }
            }

            // Scroll to top only when the user explicitly toggles a filter chip
            // (filterVersion is 0 on initial composition, so we skip that first run).
            LaunchedEffect(uiState.filterVersion) {
                if (uiState.filterVersion > 0) listState.scrollToItem(0)
            }

            Box(modifier = Modifier.fillMaxSize()) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                } else {
                    LazyColumn(
                        state = listState,
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp),
                    ) {
                        items(uiState.filteredSets, key = { it.id }) { item ->
                            WordSetCard(
                                item = item,
                                onClick = { onNavigateToSetDetail(item.id) },
                            )
                        }
                    }
                }
            }
        }
    }
}

private val ProblemRed = Color(0xFFEF5350)

@Composable
private fun ProblemWordsChip(
    count: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    androidx.compose.foundation.layout.Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .border(1.dp, ProblemRed.copy(alpha = 0.6f), RoundedCornerShape(20.dp))
            .background(ProblemRed.copy(alpha = 0.12f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick,
            )
            .padding(horizontal = 10.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text("🔴", fontSize = 10.sp)
        Text(
            text = "Ошибки: $count",
            style = MaterialTheme.typography.labelSmall,
            color = ProblemRed,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
private fun ProblemChipHintCard(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f))
            .border(
                1.dp,
                MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                RoundedCornerShape(12.dp),
            )
            .padding(horizontal = 14.dp, vertical = 10.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = "💡 Появились проблемные слова",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Text(
                text = "Красный значок «Ошибки» показывает слова, с которыми у тебя часто возникают трудности. " +
                       "Нажми на него, чтобы выбрать слова и поработать над ними.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            TextButton(
                onClick = onDismiss,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary,
                ),
                contentPadding = PaddingValues(0.dp),
            ) {
                Text("Понятно", style = MaterialTheme.typography.labelMedium)
            }
        }
    }
}

@Composable
private fun WordSetCard(item: WordSetUiItem, onClick: () -> Unit) {
    val rarityColor = Color(item.rarity.colorArgb)
    val progress = if (item.totalWords == 0) 0f
                   else item.introducedWords.toFloat() / item.totalWords

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .glowEffect(rarityColor, glowRadius = 12.dp, cornerRadius = 16.dp, alpha = 0.35f)
            .clip(RoundedCornerShape(16.dp))
            .border(1.5.dp, rarityColor.copy(alpha = 0.6f), RoundedCornerShape(16.dp))
            .background(
                Brush.verticalGradient(
                    colors = listOf(BgCard, rarityColor.copy(alpha = 0.06f))
                )
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 14.dp),
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                    if (item.description.isNotEmpty()) {
                        Spacer(Modifier.height(2.dp))
                        Text(
                            text = item.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
                Column(horizontalAlignment = Alignment.End) {
                    RarityBadge(rarity = item.rarity)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "${item.introducedWords} / ${item.totalWords}",
                        style = MaterialTheme.typography.labelSmall,
                        color = TextSecondary,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }
            Spacer(Modifier.height(12.dp))
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = rarityColor,
                trackColor = rarityColor.copy(alpha = 0.15f),
                strokeCap = StrokeCap.Round,
            )
        }
    }
}
