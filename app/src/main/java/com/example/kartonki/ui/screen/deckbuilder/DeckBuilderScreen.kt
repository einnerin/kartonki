package com.example.kartonki.ui.screen.deckbuilder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.R
import com.example.kartonki.domain.model.DeckLevel
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.component.DeckLevelBadge
import com.example.kartonki.ui.component.RarityBadge
import com.example.kartonki.ui.component.RarityFilterChips
import com.example.kartonki.ui.theme.LocalAppStrings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeckBuilderScreen(
    onNavigateBack: () -> Unit,
    viewModel: DeckBuilderViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val s = LocalAppStrings.current
    var levelMenuExpanded by remember { mutableStateOf(false) }
    // Fresh state (position 0) whenever the filter changes
    val deckListState = remember(uiState.rarityFilter) { LazyListState() }
    val availableListState = remember(uiState.rarityFilter) { LazyListState() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        if (uiState.deckName.isNotEmpty()) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(uiState.deckName, modifier = Modifier.weight(1f, fill = false))
                                Box(modifier = Modifier.padding(start = 8.dp)) {
                                    DeckLevelBadge(
                                        level = uiState.deckLevel,
                                        onClick = { levelMenuExpanded = true },
                                    )
                                    DropdownMenu(
                                        expanded = levelMenuExpanded,
                                        onDismissRequest = { levelMenuExpanded = false },
                                    ) {
                                        (1..DeckLevel.COUNT).forEach { level ->
                                            DropdownMenuItem(
                                                text = {
                                                    Row(
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                                                    ) {
                                                        DeckLevelBadge(level)
                                                        Text(DeckLevel.nameFor(level))
                                                    }
                                                },
                                                onClick = {
                                                    viewModel.changeLevel(level)
                                                    levelMenuExpanded = false
                                                },
                                            )
                                        }
                                    }
                                }
                            }
                        } else {
                            Text(s.deckBuilderTitle)
                        }
                        val hasOverLimit = uiState.raritySlots.any { it.isOverLimit }
                        Text(
                            text = if (hasOverLimit) s.deckInvalidLabel
                                   else s.deckBuilderSize(uiState.totalCards, DeckBuilderUiState.DECK_MAX_SIZE),
                            style = MaterialTheme.typography.labelSmall,
                            color = if (hasOverLimit || uiState.isFull && !uiState.isValid)
                                        MaterialTheme.colorScheme.error
                                    else if (uiState.isFull) MaterialTheme.colorScheme.primary
                                    else MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
    ) { innerPadding ->
        if (uiState.isLoading) {
            Box(Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            return@Scaffold
        }

        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            // Rarity slots row — clickable to toggle filter
            RarityFilterChips(
                activeFilters = uiState.rarityFilter,
                onToggle = { viewModel.toggleRarityFilter(it) },
                sublabelFor = { rarity ->
                    uiState.raritySlots.firstOrNull { it.rarity == rarity }
                        ?.let { "${it.used}/${it.limit}" } ?: ""
                },
                isOverLimitFor = { rarity ->
                    uiState.raritySlots.firstOrNull { it.rarity == rarity }?.isOverLimit == true
                },
            )
            HorizontalDivider()

            // Tabs
            PrimaryTabRow(selectedTabIndex = uiState.selectedTab) {
                Tab(
                    selected = uiState.selectedTab == 0,
                    onClick = { viewModel.selectTab(0) },
                    text = { Text(s.deckTabInDeck(uiState.deckCards.size)) },
                )
                Tab(
                    selected = uiState.selectedTab == 1,
                    onClick = { viewModel.selectTab(1) },
                    text = { Text(s.deckTabAvailable(uiState.allOwnedCards.size)) },
                )
            }

            // Tab content — weight(1f) so LazyColumn is bounded and can scroll
            val deckCardIds = uiState.deckCardIds
            val errorColor = MaterialTheme.colorScheme.error
            val primaryColor = MaterialTheme.colorScheme.primary
            when (uiState.selectedTab) {
                0 -> CardList(
                    cards = uiState.filteredDeckCards,
                    listState = deckListState,
                    emptyText = s.deckEmptyDeck,
                    actionLabel = { "−" },
                    actionEnabled = { true },
                    actionColor = { errorColor },
                    onAction = { viewModel.removeCard(it) },
                    modifier = Modifier.weight(1f),
                )
                1 -> CardList(
                    cards = uiState.filteredAllCards,
                    listState = availableListState,
                    emptyText = s.deckEmptyAvailable,
                    actionLabel = { if (it.id in deckCardIds) "−" else "+" },
                    actionEnabled = { if (it.id in deckCardIds) true else uiState.canAdd(it) },
                    actionColor = { if (it.id in deckCardIds) errorColor else primaryColor },
                    onAction = { if (it.id in deckCardIds) viewModel.removeCard(it) else viewModel.addCard(it) },
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
private fun CardList(
    cards: List<Word>,
    listState: LazyListState,
    emptyText: String,
    actionLabel: (Word) -> String,
    actionEnabled: (Word) -> Boolean,
    actionColor: (Word) -> Color,
    onAction: (Word) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (cards.isEmpty()) {
        Box(modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(emptyText, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        return
    }
    LazyColumn(state = listState, modifier = modifier, contentPadding = PaddingValues(bottom = 16.dp)) {
        items(cards, key = { it.id }) { word ->
            DeckCardItem(
                word = word,
                actionLabel = actionLabel(word),
                enabled = actionEnabled(word),
                actionColor = actionColor(word),
                onAction = { onAction(word) },
            )
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}

@Composable
private fun DeckCardItem(
    word: Word,
    actionLabel: String,
    enabled: Boolean,
    actionColor: Color,
    onAction: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = word.original,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = word.translation,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        RarityBadge(rarity = word.rarity)
        Spacer(modifier = Modifier.width(4.dp))
        OutlinedButton(
            onClick = onAction,
            enabled = enabled,
            colors = ButtonDefaults.outlinedButtonColors(contentColor = actionColor),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
        ) {
            Text(actionLabel, fontWeight = FontWeight.Bold)
        }
    }
}
