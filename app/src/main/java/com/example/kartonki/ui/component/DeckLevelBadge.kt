package com.example.kartonki.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kartonki.domain.model.Rarity

/**
 * Compact chip showing deck difficulty.
 *
 * Levels 1–5 map to the five rarity colors.
 * Levels 6–7 share the LEGENDARY gold color but gain an increasingly
 * strong multi-layer glow so they stand out from level 5.
 *
 *  L1 Новичок  — grey  (COMMON)
 *  L2 Ученик   — green (UNCOMMON)
 *  L3 Знаток   — blue  (RARE)
 *  L4 Опытный  — purple(EPIC)
 *  L5 Умелый   — gold  (LEGENDARY)
 *  L6 Мастер   — gold  + soft glow
 *  L7 Эксперт  — gold  + strong glow
 */
@Composable
fun DeckLevelBadge(level: Int, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    val color = deckLevelColor(level)
    val shape = RoundedCornerShape(50)

    val glowModifier: Modifier = when (level) {
        6    -> Modifier.levelGlow(color, halos = 4, maxSpreadDp = 4.dp, baseAlpha = 0.14f)
        7    -> Modifier.levelGlow(color, halos = 6, maxSpreadDp = 7.dp, baseAlpha = 0.20f)
        else -> Modifier
    }

    // L6/L7 get a slightly denser chip background to reinforce the premium feel.
    val bgAlpha     = if (level >= 6) 0.22f else 0.13f
    val borderAlpha = if (level >= 6) 0.90f else 0.65f

    val clickableModifier = if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier

    Box(
        modifier = modifier
            .then(glowModifier)
            .clip(shape)
            .background(color.copy(alpha = bgAlpha))
            .border(1.dp, color.copy(alpha = borderAlpha), shape)
            .then(clickableModifier)
            .padding(horizontal = 10.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "★",
            style = MaterialTheme.typography.bodyMedium,
            color = color,
            fontWeight = FontWeight.Bold,
        )
    }
}

// ── Helpers ───────────────────────────────────────────────────────────────────

/**
 * Draws [halos] concentric rounded-rect halos behind the composable.
 * Each halo spreads a bit further out and fades in alpha — no blur filter
 * required, so it works on all API levels with hardware acceleration.
 */
private fun Modifier.levelGlow(
    color: Color,
    halos: Int,
    maxSpreadDp: Dp,
    baseAlpha: Float,
): Modifier = drawBehind {
    val maxSpread = maxSpreadDp.toPx()
    val step = maxSpread / halos
    repeat(halos) { i ->
        val spread = maxSpread - i * step
        val alpha  = baseAlpha * (1f - i.toFloat() / halos)
        drawRoundRect(
            color = color.copy(alpha = alpha),
            topLeft = Offset(-spread, -spread),
            size = Size(size.width + spread * 2, size.height + spread * 2),
            cornerRadius = CornerRadius(size.height / 2 + spread),
        )
    }
}

private fun deckLevelColor(level: Int): Color = when (level) {
    1    -> Color(Rarity.COMMON.colorArgb)
    2    -> Color(Rarity.UNCOMMON.colorArgb)
    3    -> Color(Rarity.RARE.colorArgb)
    4    -> Color(Rarity.EPIC.colorArgb)
    else -> Color(Rarity.LEGENDARY.colorArgb)   // L5, L6, L7
}

/**
 * Compact "!" badge indicating a deck is invalid (wrong card composition for its level).
 * Matches the visual weight and size of [DeckLevelBadge] so they sit naturally side-by-side.
 */
@Composable
fun DeckInvalidBadge(modifier: Modifier = Modifier) {
    val color = Color(0xFFE53935)
    val shape = RoundedCornerShape(50)
    Box(
        modifier = modifier
            .clip(shape)
            .background(color.copy(alpha = 0.14f))
            .border(1.dp, color.copy(alpha = 0.80f), shape)
            .padding(horizontal = 10.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "!",
            style = MaterialTheme.typography.bodyMedium,
            color = color,
            fontWeight = FontWeight.ExtraBold,
        )
    }
}
