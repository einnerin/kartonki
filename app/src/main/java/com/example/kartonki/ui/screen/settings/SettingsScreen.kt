package com.example.kartonki.ui.screen.settings

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import android.graphics.BitmapFactory
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit,
    onNavigateToStats: () -> Unit,
    onNavigateToWordStats: () -> Unit,
    onNavigateToAchievements: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
    ) { uri: Uri? ->
        uri?.let { viewModel.onPhotoSelected(it) }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Настройки") },
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
                .navigationBarsPadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp),
        ) {
            // ── Profile ────────────────────────────────────────────────────────
            SectionHeader("Профиль")

            // Avatar
            Text(
                "Аватар",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 8.dp),
            )
            val isPhotoUri = state.avatarChoice.startsWith("content://") ||
                             state.avatarChoice.startsWith("file://")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(bottom = 12.dp),
            ) {
                // Current avatar preview
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    if (isPhotoUri) {
                        var bitmap by remember(state.avatarChoice) { mutableStateOf<ImageBitmap?>(null) }
                        LaunchedEffect(state.avatarChoice) {
                            try {
                                val uri = android.net.Uri.parse(state.avatarChoice)
                                context.contentResolver.openInputStream(uri)?.use { stream ->
                                    bitmap = BitmapFactory.decodeStream(stream)?.asImageBitmap()
                                }
                            } catch (_: Exception) {}
                        }
                        bitmap?.let {
                            Image(
                                bitmap = it,
                                contentDescription = "Аватар",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize(),
                            )
                        }
                    } else {
                        Text(state.avatarChoice, fontSize = 28.sp)
                    }
                }
                Button(
                    onClick = {
                        photoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    },
                ) {
                    Text("Из галереи")
                }
            }
            // Emoji grid
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
            ) {
                AVATAR_EMOJI_OPTIONS.forEach { emoji ->
                    val isSelected = state.avatarChoice == emoji
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                if (isSelected) MaterialTheme.colorScheme.primaryContainer
                                else MaterialTheme.colorScheme.surfaceVariant
                            )
                            .border(
                                width = if (isSelected) 2.dp else 0.dp,
                                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                                shape = RoundedCornerShape(12.dp),
                            )
                            .clickable { viewModel.onEmojiAvatarSelected(emoji) },
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(emoji, fontSize = 24.sp)
                    }
                }
            }

            // Username
            if (state.isEditingName) {
                OutlinedTextField(
                    value = state.nameInput,
                    onValueChange = viewModel::onNameInputChange,
                    label = { Text("Имя игрока") },
                    singleLine = true,
                    trailingIcon = {
                        Row {
                            IconButton(onClick = { viewModel.onSaveName() }) {
                                Text("✓")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                )
                TextButton(onClick = viewModel::onCancelEditName) { Text("Отмена") }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.onStartEditName() }
                        .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(12.dp))
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column {
                        Text(
                            "Имя игрока",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Text(
                            state.username,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                    Text("✏", color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                Spacer(Modifier.height(16.dp))
            }

            // ── Appearance ─────────────────────────────────────────────────────
            SectionHeader("Оформление")
            SettingsRow(label = "Тёмная тема") {
                Switch(
                    checked = state.isDarkTheme,
                    onCheckedChange = viewModel::onThemeToggle,
                )
            }

            // ── Language ───────────────────────────────────────────────────────
            SectionHeader("Язык")
            SettingsRow(label = "Язык изучения") {
                Text(
                    STUDY_LANGUAGES[state.languagePair] ?: state.languagePair,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowStudyLanguagePicker() },
                )
            }
            SettingsRow(label = "Задания с контекстом") {
                Text(
                    CONTEXT_QUIZ_MODES[state.contextQuizMode] ?: state.contextQuizMode,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowContextQuizModePicker() },
                )
            }

            SettingsRow(label = "Типы заданий (PvE)") {
                Text(
                    "${state.enabledQuizTypes.size} из ${QUIZ_TYPE_LABELS.size}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowQuizTypesPicker() },
                )
            }

            if (state.showQuizTypesPicker) {
                AlertDialog(
                    onDismissRequest = viewModel::onDismissQuizTypesPicker,
                    title = { Text("Типы заданий (PvE)") },
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            QUIZ_TYPE_LABELS.entries.forEach { (key, label) ->
                                val isChecked = key in state.enabledQuizTypes
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .clickable { viewModel.onQuizTypeToggled(key) }
                                        .padding(horizontal = 4.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Checkbox(
                                        checked = isChecked,
                                        onCheckedChange = { viewModel.onQuizTypeToggled(key) },
                                    )
                                    Text(
                                        label,
                                        style = MaterialTheme.typography.bodyLarge,
                                        modifier = Modifier.padding(start = 4.dp),
                                    )
                                }
                            }
                        }
                    },
                    confirmButton = {
                        TextButton(onClick = viewModel::onDismissQuizTypesPicker) { Text("Готово") }
                    },
                )
            }

            if (state.showContextQuizModePicker) {
                AlertDialog(
                    onDismissRequest = viewModel::onDismissContextQuizModePicker,
                    title = { Text("Задания с контекстом (PvE)") },
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            CONTEXT_QUIZ_MODES.entries.forEach { (mode, name) ->
                                val isSelected = mode == state.contextQuizMode
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(
                                            if (isSelected) MaterialTheme.colorScheme.primaryContainer
                                            else MaterialTheme.colorScheme.surface
                                        )
                                        .clickable { viewModel.onContextQuizModeSelected(mode) }
                                        .padding(horizontal = 12.dp, vertical = 12.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Text(
                                        name,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
                                                else MaterialTheme.colorScheme.onSurface,
                                    )
                                    if (isSelected) Text("✓", color = MaterialTheme.colorScheme.primary)
                                }
                            }
                        }
                    },
                    confirmButton = {},
                    dismissButton = {
                        TextButton(onClick = viewModel::onDismissContextQuizModePicker) { Text("Отмена") }
                    },
                )
            }

            SettingsRow(label = "Родной язык") {
                Text(
                    NATIVE_LANGUAGES[state.nativeLanguage] ?: state.nativeLanguage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowLanguagePicker() },
                )
            }

            if (state.showStudyLanguagePicker) {
                AlertDialog(
                    onDismissRequest = viewModel::onDismissStudyLanguagePicker,
                    title = { Text("Язык изучения") },
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            STUDY_LANGUAGES.entries.forEach { (pair, name) ->
                                val isSelected = pair == state.languagePair
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(
                                            if (isSelected) MaterialTheme.colorScheme.primaryContainer
                                            else MaterialTheme.colorScheme.surface
                                        )
                                        .clickable { viewModel.onStudyLanguageSelected(pair) }
                                        .padding(horizontal = 12.dp, vertical = 12.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Text(
                                        name,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
                                                else MaterialTheme.colorScheme.onSurface,
                                    )
                                    if (isSelected) Text("✓", color = MaterialTheme.colorScheme.primary)
                                }
                            }
                        }
                    },
                    confirmButton = {},
                    dismissButton = {
                        TextButton(onClick = viewModel::onDismissStudyLanguagePicker) { Text("Отмена") }
                    },
                )
            }

            if (state.showLanguagePicker) {
                AlertDialog(
                    onDismissRequest = viewModel::onDismissLanguagePicker,
                    title = { Text("Выберите родной язык") },
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            NATIVE_LANGUAGES.entries.forEach { (code, name) ->
                                val isSelected = code == state.nativeLanguage
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(
                                            if (isSelected) MaterialTheme.colorScheme.primaryContainer
                                            else MaterialTheme.colorScheme.surface
                                        )
                                        .clickable { viewModel.onNativeLanguageSelected(code) }
                                        .padding(horizontal = 12.dp, vertical = 12.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Text(
                                        name,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
                                                else MaterialTheme.colorScheme.onSurface,
                                    )
                                    if (isSelected) Text("✓", color = MaterialTheme.colorScheme.primary)
                                }
                            }
                        }
                    },
                    confirmButton = {},
                    dismissButton = {
                        TextButton(onClick = viewModel::onDismissLanguagePicker) { Text("Отмена") }
                    },
                )
            }

            // ── Navigation links ───────────────────────────────────────────────
            SectionHeader("Прогресс")
            NavRow("📊  Статистика игрока", onClick = onNavigateToStats)
            Spacer(Modifier.height(8.dp))
            NavRow("📖  Статистика по словам", onClick = onNavigateToWordStats)
            Spacer(Modifier.height(8.dp))
            NavRow("🏆  Достижения", onClick = onNavigateToAchievements)
            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title.uppercase(),
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 20.dp, bottom = 8.dp),
    )
}

@Composable
private fun SettingsRow(label: String, trailing: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(label, style = MaterialTheme.typography.bodyLarge)
        trailing()
    }
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun NavRow(label: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(label, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
        Text("›", style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
