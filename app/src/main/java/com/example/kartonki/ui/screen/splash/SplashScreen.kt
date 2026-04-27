package com.example.kartonki.ui.screen.splash

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kartonki.R
import kotlinx.coroutines.delay

private val SplashBg = Color(0xFF0D0D1A)

// logo.png is 1024×1024. Around the squircle artwork there are ~141 px of
// fully-transparent margin and 1 px of nearly-white anti-alias halo
// (RGB ≈ 206/207/213). At 220-dp render that 1 px stretches to a visible
// thin stripe along the squircle perimeter. Inset crop removes both the
// transparent margin and the halo before the bitmap reaches the GPU,
// giving a clean splash without any clip/scale tricks.
private const val LOGO_INSET_FRACTION = 0.142f  // ~145 px on a 1024 px source

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    val context = LocalContext.current

    var bitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    LaunchedEffect(Unit) {
        val src: Bitmap? = BitmapFactory.decodeResource(context.resources, R.drawable.logo)
        bitmap = src?.let { source ->
            val drop = (source.width * LOGO_INSET_FRACTION).toInt()
            val w = source.width - 2 * drop
            val h = source.height - 2 * drop
            if (w > 0 && h > 0) {
                Bitmap.createBitmap(source, drop, drop, w, h).asImageBitmap()
            } else {
                source.asImageBitmap()
            }
        }
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
            Image(
                bitmap = it,
                contentDescription = "Kartonki",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(220.dp),
            )
        }
    }
}
