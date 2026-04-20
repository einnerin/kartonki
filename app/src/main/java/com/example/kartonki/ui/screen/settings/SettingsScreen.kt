package com.example.kartonki.ui.screen.settings

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.input.KeyboardCapitalization
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
import com.example.kartonki.ui.theme.LocalAppStrings

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit,
    onNavigateToStats: () -> Unit,
    onNavigateToWordStats: () -> Unit,
    onNavigateToAchievements: () -> Unit,
    onSignOut: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    val s = LocalAppStrings.current

    // Navigate to login when sign-out completes
    LaunchedEffect(state.signOutDone) {
        if (state.signOutDone) {
            viewModel.onSignOutNavigated()
            onSignOut()
        }
    }

    val googleSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
    ) { result ->
        viewModel.handleGoogleSignInResult(result.data)
    }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
    ) { uri: Uri? ->
        uri?.let { viewModel.onPhotoSelected(it) }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(s.settingsTitle) },
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
            // ── Account ────────────────────────────────────────────────────────
            SectionHeader("Аккаунт")
            AccountSection(
                isSignedIn = state.isSignedIn,
                isAnonymous = state.isAnonymous,
                isSigningIn = state.isSigningIn,
                email = state.accountEmail,
                displayName = state.accountDisplayName,
                onSignOut = viewModel::onSignOutClick,
                onSignIn = { googleSignInLauncher.launch(viewModel.getGoogleSignInIntent(context)) },
            )
            Spacer(Modifier.height(8.dp))

            // ── Profile ────────────────────────────────────────────────────────
            SectionHeader(s.settingsProfileSection)

            // Avatar
            Text(
                s.settingsAvatarLabel,
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
                                contentDescription = s.settingsAvatarLabel,
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
                    Text(s.settingsFromGallery)
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
                BackHandler { viewModel.onSaveName() }
                OutlinedTextField(
                    value = state.nameInput,
                    onValueChange = viewModel::onNameInputChange,
                    label = { Text(s.settingsPlayerName) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                    trailingIcon = {
                        Row {
                            IconButton(onClick = { viewModel.onSaveName() }) {
                                Text(
                                    "✓",
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                )
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                )
                TextButton(onClick = viewModel::onCancelEditName) { Text(s.settingsCancelButton) }
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
                            s.settingsPlayerName,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Text(
                            state.username,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                    Text("✏", color = MaterialTheme.colorScheme.primary, fontSize = 18.sp)
                }
                Spacer(Modifier.height(16.dp))
            }

            // ── Appearance ─────────────────────────────────────────────────────
            SectionHeader(s.settingsAppearanceSection)
            SettingsRow(label = s.settingsDarkTheme) {
                Switch(
                    checked = state.isDarkTheme,
                    onCheckedChange = viewModel::onThemeToggle,
                )
            }

            // ── Language ───────────────────────────────────────────────────────
            SectionHeader(s.settingsLanguageSection)
            SettingsRow(label = s.settingsNativeLanguage) {
                Text(
                    NATIVE_LANGUAGES[state.nativeLanguage] ?: state.nativeLanguage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowLanguagePicker() },
                )
            }
            SettingsRow(label = s.settingsStudyLanguage) {
                Text(
                    STUDY_LANGUAGES[state.languagePair] ?: state.languagePair,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowStudyLanguagePicker() },
                )
            }

            if (state.showStudyLanguagePicker) {
                AlertDialog(
                    onDismissRequest = viewModel::onDismissStudyLanguagePicker,
                    title = { Text(s.settingsStudyLanguageTitle) },
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
                        TextButton(onClick = viewModel::onDismissStudyLanguagePicker) { Text(s.settingsCancelButton) }
                    },
                )
            }

            if (state.showLanguagePicker) {
                AlertDialog(
                    onDismissRequest = viewModel::onDismissLanguagePicker,
                    title = { Text(s.settingsChooseNativeLanguage) },
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
                        TextButton(onClick = viewModel::onDismissLanguagePicker) { Text(s.settingsCancelButton) }
                    },
                )
            }

            // ── Tasks ─────────────────────────────────────────────────────────
            SectionHeader(s.settingsTasksSection)
            SettingsRow(label = s.settingsDefinitionMode) {
                Text(
                    s.quizModeLabels[state.definitionQuizMode] ?: state.definitionQuizMode,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowDefinitionModePicker() },
                )
            }
            SettingsRow(label = s.settingsFillBlankMode) {
                Text(
                    s.quizModeLabels[state.fillBlankQuizMode] ?: state.fillBlankQuizMode,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowFillBlankModePicker() },
                )
            }
            SettingsRow(label = s.settingsQuizTypesLabel) {
                Text(
                    s.settingsQuizTypesCount(state.enabledQuizTypes.size, s.quizTypeLabels.size),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowQuizTypesPicker() },
                )
            }
            SettingsRow(label = s.settingsProblemWordsSource) {
                Text(
                    s.problemWordsSourceLabels[state.problemWordsSource] ?: state.problemWordsSource,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowProblemWordsSourcePicker() },
                )
            }

            if (state.showQuizTypesPicker) {
                AlertDialog(
                    onDismissRequest = viewModel::onDismissQuizTypesPicker,
                    title = { Text(s.settingsQuizTypesLabel) },
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            s.quizTypeLabels.entries.forEach { (key, label) ->
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
                        TextButton(onClick = viewModel::onDismissQuizTypesPicker) { Text(s.settingsDone) }
                    },
                )
            }
            if (state.showDefinitionModePicker) {
                QuizModePickerDialog(
                    title = s.settingsDefinitionMode,
                    selectedMode = state.definitionQuizMode,
                    onSelect = { viewModel.onDefinitionModeSelected(it) },
                    onDismiss = viewModel::onDismissDefinitionModePicker,
                )
            }
            if (state.showFillBlankModePicker) {
                QuizModePickerDialog(
                    title = s.settingsFillBlankMode,
                    selectedMode = state.fillBlankQuizMode,
                    onSelect = { viewModel.onFillBlankModeSelected(it) },
                    onDismiss = viewModel::onDismissFillBlankModePicker,
                )
            }
            if (state.showProblemWordsSourcePicker) {
                AlertDialog(
                    onDismissRequest = viewModel::onDismissProblemWordsSourcePicker,
                    title = { Text(s.settingsProblemWordsSourceTitle) },
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            s.problemWordsSourceLabels.entries.forEach { (key, name) ->
                                val isSelected = key == state.problemWordsSource
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(
                                            if (isSelected) MaterialTheme.colorScheme.primaryContainer
                                            else MaterialTheme.colorScheme.surface
                                        )
                                        .clickable { viewModel.onProblemWordsSourceSelected(key) }
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
                        TextButton(onClick = viewModel::onDismissProblemWordsSourcePicker) { Text(s.settingsCancelButton) }
                    },
                )
            }

            // ── Study ──────────────────────────────────────────────────────────
            SectionHeader("Обучение")
            SettingsRow(label = "Верных ответов для освоения слова") {
                Text(
                    "${state.studyCorrectToCount}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowStudyCorrectToCountPicker() },
                )
            }

            if (state.showStudyCorrectToCountPicker) {
                IntPickerDialog(
                    title = "Верных ответов для освоения слова",
                    subtitle = "Сколько раз нужно правильно ответить на слово в обычных занятиях, чтобы оно засчиталось в прогресс набора",
                    options = listOf(1, 2, 3, 5, 10),
                    selected = state.studyCorrectToCount,
                    onSelect = viewModel::onStudyCorrectToCountSelected,
                    onDismiss = viewModel::onDismissStudyCorrectToCountPicker,
                )
            }

            SettingsRow(label = "Поиск: кнопка «Назад» из набора") {
                Text(
                    SEARCH_BACK_BEHAVIOR_LABELS[state.searchBackBehavior] ?: state.searchBackBehavior,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { viewModel.onShowSearchBackBehaviorPicker() },
                )
            }
            if (state.showSearchBackBehaviorPicker) {
                StringPickerDialog(
                    title = "Кнопка «Назад» из набора",
                    options = SEARCH_BACK_BEHAVIOR_LABELS,
                    selected = state.searchBackBehavior,
                    onSelect = viewModel::onSearchBackBehaviorSelected,
                    onDismiss = viewModel::onDismissSearchBackBehaviorPicker,
                )
            }

            // ── Problem words ──────────────────────────────────────────────────
            SectionHeader("Работа над ошибками")
            SettingsRow(label = "Включить режим работы над ошибками") {
                Switch(
                    checked = state.problemWordsEnabled,
                    onCheckedChange = viewModel::onProblemWordsEnabledToggle,
                )
            }
            if (state.problemWordsEnabled) {
                SettingsRow(label = "Неверных ответов для попадания в список ошибок") {
                    Text(
                        "${state.problemWordsMinEncounters}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.clickable { viewModel.onShowMinEncountersPicker() },
                    )
                }
                SettingsRow(label = "Верных ответов для выхода из списка ошибок") {
                    Text(
                        "${state.problemWordsCorrectToLearn}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.clickable { viewModel.onShowCorrectToLearnPicker() },
                    )
                }
            }

            if (state.showMinEncountersPicker) {
                IntPickerDialog(
                    title = "Неверных ответов для попадания в список ошибок",
                    subtitle = "Слово попадёт в список ошибок, если накопилось не менее этого числа неверных ответов",
                    options = listOf(1, 2, 3, 5, 10),
                    selected = state.problemWordsMinEncounters,
                    onSelect = viewModel::onMinEncountersSelected,
                    onDismiss = viewModel::onDismissMinEncountersPicker,
                )
            }
            if (state.showCorrectToLearnPicker) {
                IntPickerDialog(
                    title = "Верных ответов для выхода из списка ошибок",
                    subtitle = "Сколько раз нужно правильно ответить на слово в режиме работы над ошибками, чтобы оно покинуло список",
                    options = listOf(1, 2, 3, 5),
                    selected = state.problemWordsCorrectToLearn,
                    onSelect = viewModel::onCorrectToLearnSelected,
                    onDismiss = viewModel::onDismissCorrectToLearnPicker,
                )
            }

            // ── Navigation links ───────────────────────────────────────────────
            SectionHeader(s.settingsProgressSection)
            NavRow(s.settingsPlayerStats, onClick = onNavigateToStats)
            Spacer(Modifier.height(8.dp))
            NavRow(s.settingsWordStats, onClick = onNavigateToWordStats)
            Spacer(Modifier.height(8.dp))
            NavRow(s.settingsAchievements, onClick = onNavigateToAchievements)
            Spacer(Modifier.height(32.dp))
        }
    }

    // Sign-in error dialog
    state.signInError?.let { err ->
        AlertDialog(
            onDismissRequest = viewModel::dismissSignInError,
            title = { Text("Ошибка входа") },
            text = { Text(err) },
            confirmButton = {
                TextButton(onClick = viewModel::dismissSignInError) { Text("OK") }
            },
        )
    }

    // Sign-out confirmation dialog
    if (state.showSignOutDialog) {
        AlertDialog(
            onDismissRequest = viewModel::onSignOutDismiss,
            title = { Text("Выйти из аккаунта?") },
            text = { Text("Прогресс и коллекция сохранены локально. Онлайн PvP будет недоступен.") },
            confirmButton = {
                TextButton(
                    onClick = viewModel::onSignOutConfirmed,
                    colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error),
                ) { Text("Выйти") }
            },
            dismissButton = {
                TextButton(onClick = viewModel::onSignOutDismiss) { Text("Отмена") }
            },
        )
    }
}

@Composable
private fun AccountSection(
    isSignedIn: Boolean,
    isAnonymous: Boolean,
    isSigningIn: Boolean,
    email: String,
    displayName: String,
    onSignOut: () -> Unit,
    onSignIn: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f),
        ) {
            // Account icon
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        if (!isAnonymous) MaterialTheme.colorScheme.primaryContainer
                        else MaterialTheme.colorScheme.surfaceVariant
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text(if (isAnonymous) "👤" else "G", fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (!isAnonymous) MaterialTheme.colorScheme.onPrimaryContainer
                            else MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Column {
                if (isAnonymous || !isSignedIn) {
                    Text(
                        "Гость",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                    )
                    Text(
                        "Войдите для онлайн PvP",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                } else {
                    Text(
                        displayName.ifBlank { email },
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                    )
                    if (email.isNotBlank()) {
                        Text(
                            email,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
            }
        }
        if (isSigningIn) {
            androidx.compose.material3.CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                strokeWidth = 2.dp,
            )
        } else if (isAnonymous || !isSignedIn) {
            TextButton(onClick = onSignIn) { Text("Войти") }
        } else {
            TextButton(
                onClick = onSignOut,
                colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error),
            ) { Text("Выйти") }
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
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f).padding(end = 8.dp),
        )
        trailing()
    }
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun StringPickerDialog(
    title: String,
    options: Map<String, String>,
    selected: String,
    onSelect: (String) -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                options.entries.forEach { (key, label) ->
                    val isSelected = key == selected
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (isSelected) MaterialTheme.colorScheme.primaryContainer
                                else MaterialTheme.colorScheme.surface
                            )
                            .clickable { onSelect(key) }
                            .padding(horizontal = 12.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            label,
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
            TextButton(onClick = onDismiss) { Text("Отмена") }
        },
    )
}

@Composable
private fun QuizModePickerDialog(
    title: String,
    selectedMode: String,
    onSelect: (String) -> Unit,
    onDismiss: () -> Unit,
) {
    val s = LocalAppStrings.current
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                s.quizModeLabels.entries.forEach { (mode, name) ->
                    val isSelected = mode == selectedMode
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (isSelected) MaterialTheme.colorScheme.primaryContainer
                                else MaterialTheme.colorScheme.surface
                            )
                            .clickable { onSelect(mode) }
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
            TextButton(onClick = onDismiss) { Text(s.settingsCancelButton) }
        },
    )
}

@Composable
private fun IntPickerDialog(
    title: String,
    subtitle: String,
    options: List<Int>,
    selected: Int,
    onSelect: (Int) -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 8.dp),
                )
                options.forEach { option ->
                    val isSelected = option == selected
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                if (isSelected) MaterialTheme.colorScheme.primaryContainer
                                else MaterialTheme.colorScheme.surface
                            )
                            .clickable { onSelect(option) }
                            .padding(horizontal = 12.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "$option",
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
            TextButton(onClick = onDismiss) { Text("Отмена") }
        },
    )
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
