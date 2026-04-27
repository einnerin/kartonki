package com.example.kartonki.ui.screen.splash

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kartonki.R
import kotlinx.coroutines.delay

// Splash bg matches @color/splash_background — system splash → Compose splash
// без мерцания. Запускается до загрузки темы.
private val SplashBg = Color(0xFF0D0D1A)

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
        bitmap?.let {
            // Hiding the PNG's anti-alias halo by scaling the bitmap up by ~6%
            // INSIDE a slightly-smaller squircle clip. Modifier order matters:
            // .clip → .scale means scale is applied first (bigger image), then
            // clipped — the white pixel ring at the very edge falls outside the
            // clip bounds and is cut off.
            Image(
                bitmap = it,
                contentDescription = "Kartonki",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(220.dp)
                    .clip(RoundedCornerShape(48.dp))
                    .scale(1.06f),
            )
        }
    }
}
