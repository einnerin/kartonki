package com.example.kartonki.ui.component

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kartonki.domain.model.Word

/**
 * Modal-style word card overlay used across Collection, DeckBuilder, and
 * WordSetDetail screens. Tapping the dim background or pressing the system
 * back button closes the overlay (instead of navigating away from the screen).
 *
 * Pass [word] = null to hide the overlay.
 */
@Composable
fun WordDetailOverlay(
    word: Word?,
    onDismiss: () -> Unit,
) {
    if (word != null) {
        BackHandler(onBack = onDismiss)
    }
    AnimatedVisibility(
        visible = word != null,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.6f))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onDismiss,
                ),
            contentAlignment = Alignment.Center,
        ) {
            AnimatedVisibility(
                visible = word != null,
                enter = scaleIn(initialScale = 0.85f) + fadeIn(),
                exit = scaleOut(targetScale = 0.85f) + fadeOut(),
            ) {
                word?.let { w ->
                    WordCard(
                        word = w,
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            // Absorb taps so they don't bubble to the dim layer
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {},
                            ),
                    )
                }
            }
        }
    }
}
