package com.example.kartonki.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

/**
 * Displays a deck's difficulty level as a compact two-row star pyramid.
 *
 * Top row holds ⌈level/2⌉ stars, bottom row holds ⌊level/2⌋ stars.
 * This keeps the maximum width at 4 characters regardless of level (1–7).
 *
 * Examples:
 *   L1 → ★
 *   L3 → ★★ / ★
 *   L5 → ★★★ / ★★
 *   L7 → ★★★★ / ★★★
 */
@Composable
fun DeckLevelBadge(level: Int, modifier: Modifier = Modifier) {
    val top    = (level + 1) / 2   // ceiling
    val bottom = level / 2         // floor

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "★".repeat(top),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            lineHeight = 15.sp,
        )
        if (bottom > 0) {
            Text(
                text = "★".repeat(bottom),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                lineHeight = 15.sp,
            )
        }
    }
}
