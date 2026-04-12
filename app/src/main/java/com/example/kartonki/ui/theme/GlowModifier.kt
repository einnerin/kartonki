package com.example.kartonki.ui.theme

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Draws a soft colored glow behind the composable, simulating CCG card rarity glow.
 */
fun Modifier.glowEffect(
    color: Color,
    glowRadius: Dp = 12.dp,
    cornerRadius: Dp = 12.dp,
    alpha: Float = 0.55f,
): Modifier = this.drawBehind {
    drawIntoCanvas { canvas ->
        val paint = Paint()
        paint.asFrameworkPaint().apply {
            isAntiAlias = true
            this.color = color.copy(alpha = alpha).toArgb()
            maskFilter = BlurMaskFilter(glowRadius.toPx(), BlurMaskFilter.Blur.NORMAL)
        }
        val cr = cornerRadius.toPx()
        canvas.drawRoundRect(0f, 0f, size.width, size.height, cr, cr, paint)
    }
}
