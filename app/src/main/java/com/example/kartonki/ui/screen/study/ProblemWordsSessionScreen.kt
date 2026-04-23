package com.example.kartonki.ui.screen.study

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.domain.model.StudyStep
import com.example.kartonki.ui.theme.LocalAppStrings

private val ColorCorrect   = Color(0xFF66BB6A)
private val ColorIncorrect = Color(0xFFEF5350)
private val ColorWarning   = Color(0xFFFF9800)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProblemWordsSessionScreen(
    onNavigateBack: () -> Unit,
    viewModel: ProblemWordsSessionViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(LocalAppStrings.current.problemWordsTitle) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            when {
                uiState.isLoading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
                uiState.isDisabled -> ProblemWordsDisabledContent(
                    modifier = Modifier.align(Alignment.Center),
                    onBack = onNavigateBack,
                )
                uiState.isEmpty -> ProblemWordsEmptyContent(
                    modifier = Modifier.align(Alignment.Center),
                    onBack = onNavigateBack,
                )
                uiState.isSessionComplete -> ProblemWordsCompleteContent(
                    correctCount     = uiState.correctCount,
                    incorrectCount   = uiState.incorrectCount,
                    learnedCount     = uiState.learnedCount,
                    progressedCount  = uiState.progressedCount,
                    noProgressCount  = uiState.noProgressCount,
                    wordsStudied     = uiState.wordsStudied,
                    showSettingsHint = uiState.showSettingsHint,
                    onNewSession     = { viewModel.loadSession() },
                    onNavigateBack   = onNavigateBack,
                    modifier = Modifier.fillMaxSize().padding(24.dp),
                )
                else -> Column(Modifier.fillMaxSize()) {
                    // Progress bar
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(uiState.progress)
                                .fillMaxHeight()
                                .background(ColorWarning),
                        )
                    }
                    Text(
                        text = "${uiState.currentStepIndex + 1} / ${uiState.totalSteps}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.align(Alignment.End).padding(end = 16.dp, top = 2.dp),
                    )
                    when (val step = uiState.currentStep) {
                        is StudyStep.Introduction -> IntroductionContent(
                            step = step,
                            onContinue = { viewModel.onIntroductionContinue() },
                            modifier = Modifier.fillMaxSize().padding(16.dp),
                        )
                        is StudyStep.Quiz -> QuizContent(
                            step = step,
                            answerState = uiState.answerState,
                            onOptionSelected = { viewModel.onMultipleChoiceAnswer(it) },
                            onContinue = { viewModel.onAnsweredContinue() },
                            modifier = Modifier.fillMaxSize().padding(16.dp),
                        )
                        null -> {}
                    }
                }
            }
        }
    }
}

@Composable
private fun ProblemWordsDisabledContent(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text("⚙️", fontSize = 48.sp)
        Text(
            "Работа над ошибками отключена в настройках",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
        OutlinedButton(onClick = onBack) { Text(LocalAppStrings.current.problemWordsBack) }
    }
}

@Composable
private fun ProblemWordsEmptyContent(modifier: Modifier = Modifier, onBack: () -> Unit) {
    val s = LocalAppStrings.current
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text("✅", fontSize = 48.sp)
        Text(
            s.problemWordsEmpty,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
        OutlinedButton(onClick = onBack) { Text(s.problemWordsBack) }
    }
}

@Composable
private fun ProblemWordsCompleteContent(
    correctCount: Int,
    incorrectCount: Int,
    learnedCount: Int,
    progressedCount: Int,
    noProgressCount: Int,
    wordsStudied: Int,
    showSettingsHint: Boolean,
    onNewSession: () -> Unit,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = LocalAppStrings.current
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val emoji = when {
            learnedCount > 0                       -> "🏆"
            progressedCount >= wordsStudied / 2    -> "🎉"
            progressedCount > 0                    -> "📈"
            else                                   -> "💪"
        }
        Text(emoji, style = MaterialTheme.typography.displayLarge)
        Spacer(Modifier.height(12.dp))
        Text(
            text = s.problemWordsCompleteTitle,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(24.dp))

        // Correct / Incorrect row
        Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("$correctCount", style = MaterialTheme.typography.displaySmall,
                    color = ColorCorrect, fontWeight = FontWeight.Bold)
                Text(s.problemWordsCorrectLabel, style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("$incorrectCount", style = MaterialTheme.typography.displaySmall,
                    color = ColorIncorrect, fontWeight = FontWeight.Bold)
                Text(s.problemWordsIncorrectLabel, style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }

        Spacer(Modifier.height(20.dp))

        // Learned (mastered) — removed from problem list
        if (learnedCount > 0) {
            OutcomeBanner(
                emoji = "🏆",
                text = "Выучено: $learnedCount — слова убраны из работы над ошибками",
                color = ColorCorrect,
            )
            Spacer(Modifier.height(8.dp))
        }

        // Progressed — closer to mastery but not yet there
        if (progressedCount > 0) {
            OutcomeBanner(
                emoji = "📈",
                text = "В процессе: $progressedCount — засчитан новый тип задания",
                color = ColorWarning,
            )
            Spacer(Modifier.height(8.dp))
        }

        // No progress — session touched them but no new type mastered
        if (noProgressCount > 0) {
            OutcomeBanner(
                emoji = "💪",
                text = "Ещё работаем: $noProgressCount — прогресса в этой сессии нет",
                color = ColorIncorrect,
            )
            Spacer(Modifier.height(8.dp))
        }

        // Fallback if all three counters are zero (defensive — shouldn't happen)
        if (learnedCount == 0 && progressedCount == 0 && noProgressCount == 0) {
            OutcomeBanner(
                emoji = "💪",
                text = s.problemWordsNoImprovement,
                color = ColorWarning,
            )
        }

        // Settings hint (shown only after first completed session)
        if (showSettingsHint) {
            Spacer(Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                        RoundedCornerShape(12.dp),
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp),
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "💡 Знаешь ли ты?",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                    Text(
                        text = "В настройках можно изменить параметры работы над ошибками: " +
                               "минимум попыток для попадания в список, " +
                               "сколько раз нужно правильно ответить чтобы слово считалось усвоенным, " +
                               "и полностью отключить этот режим.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
            }
        }

        Spacer(Modifier.height(32.dp))
        Button(onClick = onNewSession, modifier = Modifier.fillMaxWidth()) {
            Text(s.problemWordsRetry)
        }
        Spacer(Modifier.height(12.dp))
        OutlinedButton(onClick = onNavigateBack, modifier = Modifier.fillMaxWidth()) {
            Text(s.problemWordsBack)
        }
    }
}

@Composable
private fun OutcomeBanner(
    emoji: String,
    text: String,
    color: Color,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color.copy(alpha = 0.12f), RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(emoji, style = MaterialTheme.typography.titleLarge)
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = color,
                modifier = Modifier.weight(1f),
            )
        }
    }
}
