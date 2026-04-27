package com.example.kartonki.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kartonki.R
import kotlinx.coroutines.delay

// Splash bg is fixed brand color — runs before any theme is read, so it should
// not depend on light/dark mode. Matches @color/splash_background used by the
// theme's windowBackground (so the system splash and the Compose splash blend
// without a flicker).
private val SplashBg = Color(0xFF0D0D1A)

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SplashBg),
        contentAlignment = Alignment.Center,
    ) {
        // Vector logo — same asset as the adaptive launcher foreground, no PNG
        // anti-alias halo around the rounded card.
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Kartonki",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(220.dp),
        )
    }
}
