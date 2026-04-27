package com.example.kartonki.ui.screen.splash

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kartonki.R
import kotlinx.coroutines.delay

private val SplashBg = Color(0xFF0D0D1A)

// Geometry of logo.png (1024×1024):
//   - 141 px transparent margin around the squircle artwork
//   - 1 px almost-white anti-alias halo on the squircle perimeter
//   - squircle corner radius ~168 px in source space
// Inset crop drops the transparent margin AND the halo on straight edges,
// but at the rounded corners the halo follows the squircle curve and lies
// inside the cropped rectangle. We mask it by drawing a SplashBg-colored
// border over the rendered Image — width 4 dp covers the ~1 phys-px halo
// with a comfortable tolerance, and the rounded-corner shape matches the
// squircle radius in render space (≈ 50 dp at 220 dp size).
private const val LOGO_INSET_FRACTION = 0.142f

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
            Box(
                modifier = Modifier.size(220.dp),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    bitmap = it,
                    contentDescription = "Kartonki",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize(),
                )
                // Mask halo: dark border drawn over the Image perimeter.
                // SplashBg matches the screen bg, so the border is invisible
                // against it but covers the white halo under the squircle curve.
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            width = 4.dp,
                            color = SplashBg,
                            shape = RoundedCornerShape(50.dp),
                        ),
                )
            }
        }
    }
}
