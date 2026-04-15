package com.example.kartonki.ui.screen.mydecks

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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.math.roundToInt
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.kartonki.R
import com.example.kartonki.domain.model.DeckLevel
import com.example.kartonki.ui.component.DeckLevelBadge
import com.example.kartonki.ui.screen.deckbuilder.DeckBuilderUiState
import com.example.kartonki.ui.theme.LocalAppStrings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDecksScreen(
    onNavigateToDeckBuilder: (deckId: Long) -> Unit,
    onNavigateToCollection: () -> Unit,
    onNavigateBack: () -> Unit,
    viewModel: MyDecksViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val s = LocalAppStrings.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val listState = rememberLazyListState()
    var deckPendingDelete by remember { mutableStateOf<DeckSummary?>(null) }

    uiState.navigateToDeckId?.let { deckId ->
        onNavigateToDeckBuilder(deckId)
        viewModel.onNavigationConsumed()
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) viewModel.refresh()
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(s.myDecksTitle) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    TextButton(onClick = onNavigateToCollection) {
                        Text(s.myDecksCollectionLink)
                    }
                },
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { viewModel.showCreateDialog() },
                text = { Text(s.myDecksCreate) },
                icon = { Text("+") },
            )
        },
    ) { innerPadding ->
        if (uiState.isLoading) {
            Box(Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (uiState.decks.isEmpty()) {
            Box(Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
                Text(
                    text = s.myDecksEmpty,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        } else {
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                contentPadding = PaddingValues(bottom = 88.dp),
            ) {
                items(uiState.decks, key = { it.id }) { deck ->
                    DeckItem(
                        deck = deck,
                        onEdit = { onNavigateToDeckBuilder(deck.id) },
                        onDelete = { deckPendingDelete = deck },
                    )
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }

    if (uiState.showCreateDialog) {
        CreateDeckDialog(
            onConfirm = { name, level -> viewModel.createDeck(name, level) },
            onDismiss = { viewModel.dismissCreateDialog() },
        )
    }

    deckPendingDelete?.let { deck ->
        AlertDialog(
            onDismissRequest = { deckPendingDelete = null },
            title = { Text(s.myDecksDeleteTitle) },
            text = { Text(s.myDecksDeleteConfirm(deck.name)) },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.deleteDeck(deck)
                    deckPendingDelete = null
                }) {
                    Text(s.myDecksDelete, color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { deckPendingDelete = null }) {
                    Text(s.myDecksCreateDialogCancel)
                }
            },
        )
    }
}

@Composable
private fun DeckItem(
    deck: DeckSummary,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 4.dp, top = 4.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = deck.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = LocalAppStrings.current.deckCardCount(deck.cardCount, DeckBuilderUiState.DECK_MAX_SIZE),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        val s = LocalAppStrings.current
        DeckLevelBadge(
            level = deck.level,
            modifier = Modifier.padding(horizontal = 8.dp),
        )
        IconButton(onClick = onEdit) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = s.myDecksEdit,
                tint = MaterialTheme.colorScheme.primary,
            )
        }
        IconButton(onClick = onDelete) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = s.myDecksDelete,
                tint = MaterialTheme.colorScheme.error,
            )
        }
    }
}

@Composable
private fun CreateDeckDialog(
    onConfirm: (String, Int) -> Unit,
    onDismiss: () -> Unit,
) {
    val s = LocalAppStrings.current
    var name by remember { mutableStateOf("") }
    var selectedLevel by remember { mutableStateOf(1) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(s.myDecksCreateDialogTitle) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(s.myDecksCreateDialogHint) },
                    singleLine = true,
                )
                Text(
                    text = s.myDecksCreateDialogLevel,
                    style = MaterialTheme.typography.labelLarge,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = DeckLevel.starsFor(selectedLevel),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(
                        text = DeckLevel.nameFor(selectedLevel),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
                Slider(
                    value = selectedLevel.toFloat(),
                    onValueChange = { selectedLevel = it.roundToInt() },
                    valueRange = 1f..DeckLevel.COUNT.toFloat(),
                    steps = DeckLevel.COUNT - 2,
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onConfirm(name, selectedLevel) },
                enabled = name.isNotBlank(),
            ) {
                Text(s.myDecksCreateDialogConfirm)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(s.myDecksCreateDialogCancel)
            }
        },
    )
}
