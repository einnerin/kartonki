package com.example.kartonki.ui.screen.pvp

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.theme.BgCard
import com.example.kartonki.ui.theme.TextSecondary

// ─── Answer state ─────────────────────────────────────────────────────────────

enum class PvpAnswerState { Normal, Correct, Wrong, Dimmed }

// ─── Answer button ────────────────────────────────────────────────────────────

private val CorrectGreen       = Color(0xFF2E7D32)
private val CorrectGreenBorder = Color(0xFF66BB6A)
private val WrongRed           = Color(0xFFC62828)
private val WrongRedBorder     = Color(0xFFEF5350)

/**
 * Standard PvP answer option button with press animation and 4 visual states.
 * Used in both local pass-and-play and online PvP quiz screens.
 */
@Composable
fun PvpAnswerButton(
    text: String,
    answerState: PvpAnswerState,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed && enabled) 0.97f else 1f,
        animationSpec = spring(),
        label = "pvp_ans_scale",
    )

    val (bgColor, borderColor, textColor) = when (answerState) {
        PvpAnswerState.Correct -> Triple(CorrectGreen.copy(alpha = 0.25f), CorrectGreenBorder, CorrectGreenBorder)
        PvpAnswerState.Wrong   -> Triple(WrongRed.copy(alpha = 0.25f),    WrongRedBorder,     WrongRedBorder)
        PvpAnswerState.Dimmed  -> Triple(BgCard.copy(alpha = 0.4f),       Color(0xFF2A3E54),  TextSecondary.copy(alpha = 0.4f))
        PvpAnswerState.Normal  -> Triple(BgCard,                          MaterialTheme.colorScheme.outline, Color.White)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = if (answerState == PvpAnswerState.Correct || answerState == PvpAnswerState.Wrong) 2.dp else 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(12.dp),
            )
            .background(bgColor)
            .then(
                if (enabled) Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onClick,
                ) else Modifier
            )
            .padding(horizontal = 16.dp, vertical = 14.dp),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = textColor,
            fontWeight = if (answerState == PvpAnswerState.Correct || answerState == PvpAnswerState.Wrong)
                FontWeight.Bold else FontWeight.Normal,
        )
    }
}

// ─── Result panel ─────────────────────────────────────────────────────────────

/**
 * Shown after the defender answers — reveals the correct word + translation pair
 * with colour-coded feedback. Used in both local and online PvP.
 */
@Composable
fun PvpResultPanel(
    wordOriginal: String,
    wordTranslation: String,
    isCorrect: Boolean,
    modifier: Modifier = Modifier,
) {
    val accentColor = if (isCorrect) Color(0xFF66BB6A) else Color(0xFFEF5350)
    val bgColor     = if (isCorrect) Color(0xFF1A3A1A) else Color(0xFF3A1A1A)
    val borderColor = if (isCorrect) Color(0xFF4CAF50) else Color(0xFFC62828)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, borderColor.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
            .background(bgColor)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        if (!isCorrect) {
            Text(
                text = "Неверно!",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.ExtraBold,
                color = accentColor,
            )
        }
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.Bold)) {
                    append(wordOriginal)
                }
                withStyle(SpanStyle(color = accentColor, baselineShift = BaselineShift(0.12f))) {
                    append("  →  ")
                }
                withStyle(SpanStyle(color = accentColor, fontWeight = FontWeight.Bold)) {
                    append(wordTranslation)
                }
            },
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
    }
}

// ─── Hand card ────────────────────────────────────────────────────────────────

/**
 * Card tile shown in the attacker's hand grid.
 * Used in both local and online PvP hand-selection screens.
 */
@Composable
fun PvpHandCard(
    word: Word,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val rarityColor = Color(word.rarity.colorArgb)
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(),
        label = "pvp_card_scale",
    )

    Column(
        modifier = modifier
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, rarityColor.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
            .background(BgCard)
            .clickable(interactionSource = interactionSource, indication = null, onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 10.dp),
    ) {
        Text(
            text = word.original,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = word.rarity.displayName,
                style = MaterialTheme.typography.labelSmall,
                color = rarityColor,
            )
            Text(
                text = "+${word.rarity.points}",
                style = MaterialTheme.typography.labelSmall,
                color = rarityColor,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

// ─── Timer bar ────────────────────────────────────────────────────────────────

/**
 * Horizontal progress bar that shows remaining time.
 * Green > 50 %, orange 25–50 %, red < 25 %.
 * Used in both local and online PvP.
 */
@Composable
fun PvpTimerBar(
    timeRemaining: Int,
    timerDuration: Int = PvpGameLogic.TIMER_DURATION,
    modifier: Modifier = Modifier,
) {
    val fraction = (timeRemaining.toFloat() / timerDuration).coerceIn(0f, 1f)
    val color = when {
        fraction > 0.5f  -> Color(0xFF4CAF50)
        fraction > 0.25f -> Color(0xFFFF9800)
        else             -> Color(0xFFF44336)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(6.dp)
            .clip(RoundedCornerShape(3.dp))
            .background(Color(0xFF333355)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction)
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(color),
        )
    }
}
