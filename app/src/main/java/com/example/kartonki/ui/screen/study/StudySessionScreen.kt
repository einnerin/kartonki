package com.example.kartonki.ui.screen.study

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.R
import com.example.kartonki.domain.model.StudyQuizType
import com.example.kartonki.domain.model.StudyStep
import com.example.kartonki.ui.component.WordCard
import com.example.kartonki.ui.theme.LocalAppStrings

private val ColorCorrect       = Color(0xFF66BB6A)
private val ColorCorrectBg     = Color(0xFF1A3A1A)
private val ColorCorrectBorder = Color(0xFF4CAF50)
private val ColorIncorrect     = Color(0xFFEF5350)
private val ColorIncorrectBg   = Color(0xFF3A1A1A)
private val ColorIncorrectBorder = Color(0xFFC62828)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudySessionScreen(
    onNavigateBack: () -> Unit,
    viewModel: StudySessionViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(LocalAppStrings.current.studyTitle) },
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
                uiState.isEmpty -> EmptyContent(Modifier.align(Alignment.Center), onNavigateBack)
                uiState.isSessionComplete -> SessionCompleteContent(
                    correctCount = uiState.correctCount,
                    incorrectCount = uiState.incorrectCount,
                    onNewSession = { viewModel.loadSession() },
                    onNavigateBack = onNavigateBack,
                    modifier = Modifier.fillMaxSize().padding(24.dp),
                )
                else -> Column(Modifier.fillMaxSize()) {
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
                                .background(MaterialTheme.colorScheme.primary),
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
internal fun IntroductionContent(
    step: StudyStep.Introduction,
    onContinue: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = LocalAppStrings.current
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = s.studyNewWord,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold,
        )
        WordCard(word = step.word, showDetails = true)
        Spacer(Modifier.weight(1f))
        Button(onClick = onContinue, modifier = Modifier.fillMaxWidth()) {
            Text(s.studyGotIt)
        }
    }
}

@Composable
internal fun QuizContent(
    step: StudyStep.Quiz,
    answerState: AnswerState,
    onOptionSelected: (String) -> Unit,
    onContinue: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val answered = answerState as? AnswerState.Answered
    val s = LocalAppStrings.current

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        val label = when (step.type) {
            StudyQuizType.MULTIPLE_CHOICE_TRANSLATION          -> s.studyQTranslation
            StudyQuizType.MULTIPLE_CHOICE_DEFINITION           -> s.studyQDefinition
            StudyQuizType.MULTIPLE_CHOICE_DEFINITION_NATIVE    -> s.studyQDefinitionNative
            StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF        -> s.studyQWordFromDef
            StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE -> s.studyQWordFromDefNative
            StudyQuizType.FILL_IN_BLANK                        -> s.studyQFillBlank
            StudyQuizType.FILL_IN_BLANK_NATIVE                 -> s.studyQFillBlankNative
        }
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold,
        )
        // Question is RTL when it displays a raw Hebrew word (not a definition or sentence in any language)
        val isHebrewQuestionRtl = step.word.languagePair.startsWith("he") &&
            step.type == StudyQuizType.MULTIPLE_CHOICE_TRANSLATION
        // Options are RTL when they contain Hebrew words (word-from-def types for Hebrew)
        val isHebrewOptionsRtl = step.word.languagePair.startsWith("he") &&
            (step.type == StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF ||
             step.type == StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE ||
             step.type == StudyQuizType.FILL_IN_BLANK ||
             step.type == StudyQuizType.FILL_IN_BLANK_NATIVE)
        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp),
            ) {
                Text(
                    text = step.question,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        textDirection = if (isHebrewQuestionRtl) TextDirection.Rtl else TextDirection.Ltr,
                    ),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                if (isHebrewQuestionRtl && step.word.transliteration != null) {
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = step.word.transliteration,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                        fontSize = 13.sp,
                    )
                }
            }
        }
        MultipleChoiceSection(
            options = step.options,
            answered = answered,
            optionsRtl = isHebrewOptionsRtl,
            onOptionSelected = onOptionSelected,
        )
        if (answered != null) {
            TranslationPanel(
                original = step.word.original,
                translation = step.word.translation,
                isCorrect = answered.isCorrect,
            )
            Button(onClick = onContinue, modifier = Modifier.fillMaxWidth()) {
                Text(s.studyContinue)
            }
        }
    }
}

@Composable
private fun MultipleChoiceSection(
    options: List<String>,
    answered: AnswerState.Answered?,
    optionsRtl: Boolean = false,
    onOptionSelected: (String) -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        options.forEach { option ->
            val isCorrect  = answered != null && option.equals(answered.correctAnswer, ignoreCase = true)
            val isSelected = answered != null && option.equals(answered.selectedAnswer, ignoreCase = true)
            val isWrong    = isSelected && !isCorrect

            val (bgColor, borderColor, textColor) = when {
                answered == null -> Triple(
                    MaterialTheme.colorScheme.surfaceVariant,
                    MaterialTheme.colorScheme.outline,
                    MaterialTheme.colorScheme.onSurface,
                )
                isCorrect -> Triple(ColorCorrectBg, ColorCorrectBorder, ColorCorrect)
                isWrong   -> Triple(ColorIncorrectBg, ColorIncorrectBorder, ColorIncorrect)
                else      -> Triple(
                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                    MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.35f),
                )
            }

            OutlinedButton(
                onClick = { onOptionSelected(option) },
                enabled = answered == null,
                border = androidx.compose.foundation.BorderStroke(
                    width = if (isCorrect || isWrong) 2.dp else 1.dp,
                    color = borderColor,
                ),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = bgColor,
                    contentColor = textColor,
                    disabledContainerColor = bgColor,
                    disabledContentColor = textColor,
                ),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = option,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        textDirection = if (optionsRtl) TextDirection.Rtl else TextDirection.Ltr,
                    ),
                    fontWeight = if (isCorrect || isWrong) FontWeight.Bold else FontWeight.Normal,
                )
            }
        }
    }
}

@Composable
private fun TranslationPanel(
    original: String,
    translation: String,
    isCorrect: Boolean,
) {
    val s = LocalAppStrings.current
    val accentColor = if (isCorrect) ColorCorrect else ColorIncorrect
    val bgColor     = if (isCorrect) ColorCorrectBg else ColorIncorrectBg
    val borderColor = if (isCorrect) ColorCorrectBorder else ColorIncorrectBorder

    Surface(
        color = bgColor,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, borderColor.copy(alpha = 0.6f)),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            if (!isCorrect) {
                Text(
                    text = s.studyIncorrect,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = accentColor,
                )
            }
            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.Bold)) {
                        append(original)
                    }
                    withStyle(SpanStyle(color = accentColor, baselineShift = BaselineShift(0.12f))) {
                        append("  →  ")
                    }
                    withStyle(SpanStyle(color = accentColor, fontWeight = FontWeight.Bold)) {
                        append(translation)
                    }
                },
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun SessionCompleteContent(
    correctCount: Int,
    incorrectCount: Int,
    onNewSession: () -> Unit,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = LocalAppStrings.current
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("🎉", style = MaterialTheme.typography.displayLarge)
        Spacer(Modifier.height(16.dp))
        Text(
            text = s.studySessionComplete,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
        )
        Spacer(Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("$correctCount", style = MaterialTheme.typography.displaySmall,
                    color = ColorCorrect, fontWeight = FontWeight.Bold)
                Text(s.studyCorrectLabel,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("$incorrectCount", style = MaterialTheme.typography.displaySmall,
                    color = ColorIncorrect, fontWeight = FontWeight.Bold)
                Text(s.studyIncorrectLabel,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        Spacer(Modifier.height(40.dp))
        Button(onClick = onNewSession, modifier = Modifier.fillMaxWidth()) {
            Text(s.studyNewSession)
        }
        Spacer(Modifier.height(12.dp))
        OutlinedButton(onClick = onNavigateBack, modifier = Modifier.fillMaxWidth()) {
            Text(s.studyBackHome)
        }
    }
}

@Composable
private fun EmptyContent(modifier: Modifier = Modifier, onBack: () -> Unit) {
    val s = LocalAppStrings.current
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(s.studyNoWords, textAlign = TextAlign.Center)
        OutlinedButton(onClick = onBack) { Text(s.studyBack) }
    }
}
