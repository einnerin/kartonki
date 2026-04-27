package com.example.kartonki.ui.screen.splash

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kartonki.R
import kotlinx.coroutines.delay

// Splash bg matches @color/splash_background — system splash → Compose splash
// без мерцания. Запускается до загрузки темы, поэтому не зависит от light/dark.
private val SplashBg = Color(0xFF0D0D1A)

// Rarity-themed radial halo around the logo — амбер ядро (LEGENDARY) → фиолет
// (EPIC) → темный край. Скрывает анти-алиасинг logo.png по периметру.
private val LegendaryGold = Color(0xFFF5A623)
private val EpicPurple    = Color(0xFF4A2168)

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    val context = LocalContext.current

    var bitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    LaunchedEffect(Unit) {
        bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.logo)?.asImageBitmap()
        delay(2000)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SplashBg),
        contentAlignment = Alignment.Center,
    ) {
        // Glow halo behind logo — gradient зашивает белый ободок PNG.
        Box(
            modifier = Modifier
                .size(260.dp)
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        colorStops = arrayOf(
                            0.00f to LegendaryGold.copy(alpha = 0.55f),
                            0.40f to EpicPurple.copy(alpha = 0.45f),
                            0.85f to SplashBg,
                            1.00f to SplashBg,
                        ),
                    )
                ),
        )
        bitmap?.let {
            Image(
                bitmap = it,
                contentDescription = "Kartonki",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(220.dp)
                    .clip(CircleShape),
            )
        }
    }
}
