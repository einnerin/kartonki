package com.example.kartonki.ui.screen.pvp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.R
import com.example.kartonki.domain.model.DeckLevel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PvpDeckSelectScreen(
    onNavigateBack: () -> Unit,
    onStartGame: (p1Name: String, p2Name: String, deck1Id: Long, deck2Id: Long) -> Unit,
    viewModel: PvpDeckSelectViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.pvp_deck_select_title)) },
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

        if (uiState.decks.isEmpty()) {
            Box(Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
                Text(
                    text = stringResource(R.string.pvp_no_decks),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp),
        ) {
            Spacer(Modifier.height(16.dp))

            PlayerSection(
                label = stringResource(R.string.pvp_player1_label),
                name = uiState.player1Name,
                onNameChange = { viewModel.setPlayer1Name(it) },
                decks = uiState.decks,
                selectedDeck = uiState.selectedDeck1,
                onDeckSelected = { viewModel.selectDeck1(it) },
            )

            Spacer(Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))

            PlayerSection(
                label = stringResource(R.string.pvp_player2_label),
                name = uiState.player2Name,
                onNameChange = { viewModel.setPlayer2Name(it) },
                decks = uiState.decks,
                selectedDeck = uiState.selectedDeck2,
                onDeckSelected = { viewModel.selectDeck2(it) },
            )

            Spacer(Modifier.weight(1f))

            if (!uiState.levelsMatch) {
                Text(
                    text = stringResource(R.string.pvp_level_mismatch),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                )
            }

            Button(
                onClick = {
                    val d1 = uiState.selectedDeck1 ?: return@Button
                    val d2 = uiState.selectedDeck2 ?: return@Button
                    onStartGame(uiState.player1Name, uiState.player2Name, d1.id, d2.id)
                },
                enabled = uiState.canStart,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(stringResource(R.string.pvp_start_game))
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PlayerSection(
    label: String,
    name: String,
    onNameChange: (String) -> Unit,
    decks: List<PvpDeckOption>,
    selectedDeck: PvpDeckOption?,
    onDeckSelected: (PvpDeckOption) -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(label, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text(stringResource(R.string.pvp_name_hint)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )

        DeckDropdown(
            decks = decks,
            selected = selectedDeck,
            onSelected = onDeckSelected,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DeckDropdown(
    decks: List<PvpDeckOption>,
    selected: PvpDeckOption?,
    onSelected: (PvpDeckOption) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = Modifier.fillMaxWidth(),
    ) {
        OutlinedTextField(
            value = selected?.let { "${it.name}  ${DeckLevel.starsFor(it.level)}  (${it.cardCount} карт)" } ?: "",
            onValueChange = {},
            readOnly = true,
            label = { Text(stringResource(R.string.pvp_deck_hint)) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryNotEditable),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            decks.forEach { deck ->
                DropdownMenuItem(
                    text = {
                        Text("${deck.name}  ${DeckLevel.starsFor(deck.level)}  — ${deck.cardCount} карт")
                    },
                    onClick = {
                        onSelected(deck)
                        expanded = false
                    },
                )
            }
        }
    }
}
