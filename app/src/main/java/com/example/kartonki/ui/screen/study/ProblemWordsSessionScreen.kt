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
                uiState.isEmpty -> ProblemWordsEmptyContent(
                    modifier = Modifier.align(Alignment.Center),
                    onBack = onNavigateBack,
                )
                uiState.isSessionComplete -> ProblemWordsCompleteContent(
                    correctCount   = uiState.correctCount,
                    incorrectCount = uiState.incorrectCount,
                    improvedCount  = uiState.improvedCount,
                    wordsStudied   = uiState.wordsStudied,
                    onNewSession   = { viewModel.loadSession() },
                    onNavigateBack = onNavigateBack,
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
    improvedCount: Int,
    wordsStudied: Int,
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
            improvedCount >= wordsStudied / 2 -> "🎉"
            improvedCount > 0                 -> "📈"
            else                              -> "💪"
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

        // Improvement summary
        val improvementColor = if (improvedCount > 0) ColorCorrect else ColorWarning
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    improvementColor.copy(alpha = 0.12f),
                    RoundedCornerShape(12.dp),
                )
                .padding(horizontal = 20.dp, vertical = 14.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = if (improvedCount > 0)
                        s.problemWordsImproved(improvedCount, wordsStudied)
                    else
                        s.problemWordsNoImprovement,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = improvementColor,
                    textAlign = TextAlign.Center,
                )
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
