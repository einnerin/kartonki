package com.example.kartonki.ui.screen.study

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.component.RarityBadge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DismissedProblemWordsScreen(
    onNavigateBack: () -> Unit,
    viewModel: DismissedProblemWordsViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    var confirmRestoreAll by remember { mutableStateOf(false) }

    if (confirmRestoreAll) {
        AlertDialog(
            onDismissRequest = { confirmRestoreAll = false },
            title = { Text("Восстановить все скрытые слова?") },
            text = {
                Text("${state.words.size} слов вернутся в список проблемных, " +
                        "если их статистика по-прежнему этому соответствует.")
            },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.restoreAll()
                    confirmRestoreAll = false
                }) { Text("Восстановить все") }
            },
            dismissButton = {
                TextButton(onClick = { confirmRestoreAll = false }) { Text("Отмена") }
            },
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Скрытые проблемные слова") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    if (state.words.isNotEmpty()) {
                        TextButton(onClick = { confirmRestoreAll = true }) {
                            Text("Восстановить все")
                        }
                    }
                },
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            when {
                state.isLoading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
                state.words.isEmpty() -> {
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text(
                            "Нет скрытых слов",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                        Text(
                            "Когда ты убираешь слово из списка проблемных, оно появляется здесь. " +
                                    "Нажми на стрелку, чтобы вернуть конкретное слово.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
                else -> {
                    Column(Modifier.fillMaxSize()) {
                        Text(
                            text = "${state.words.size} слов скрыто. " +
                                    "Нажми на стрелку справа, чтобы вернуть слово в проблемные.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        )
                        HorizontalDivider()
                        LazyColumn(
                            contentPadding = PaddingValues(vertical = 4.dp),
                        ) {
                            items(state.words, key = { it.id }) { word ->
                                DismissedWordRow(
                                    word = word,
                                    onRestore = { viewModel.restore(word.id) },
                                )
                                HorizontalDivider(
                                    modifier = Modifier.padding(horizontal = 16.dp),
                                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
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
private fun DismissedWordRow(
    word: Word,
    onRestore: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = word.original,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = word.translation,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        RarityBadge(rarity = word.rarity)
        IconButton(onClick = onRestore) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Вернуть в проблемные",
                tint = MaterialTheme.colorScheme.primary,
            )
        }
    }
}
