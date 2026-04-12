package com.example.kartonki.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val CcgDarkColorScheme = darkColorScheme(
    primary             = AccentBlue,
    onPrimary           = Color.White,
    primaryContainer    = Color(0xFF1A3A6A),
    onPrimaryContainer  = Color(0xFFB8D4FF),

    secondary           = AccentPurple,
    onSecondary         = Color.White,
    secondaryContainer  = Color(0xFF3A1A6A),
    onSecondaryContainer= Color(0xFFE0C0FF),

    tertiary            = AccentGold,
    onTertiary          = Color(0xFF1A1000),
    tertiaryContainer   = Color(0xFF4A3000),
    onTertiaryContainer = Color(0xFFFFE0A0),

    background          = BgDeep,
    onBackground        = TextPrimary,

    surface             = BgMedium,
    onSurface           = TextPrimary,
    surfaceVariant      = BgSurface,
    onSurfaceVariant    = TextSecondary,

    surfaceContainer        = BgCard,
    surfaceContainerHigh    = BgElevated,
    surfaceContainerHighest = BgElevated,

    outline             = Color(0xFF2A3E54),
    outlineVariant      = Color(0xFF1A2A3A),

    error               = Color(0xFFFF5252),
    onError             = Color.White,
    errorContainer      = Color(0xFF4A0000),
    onErrorContainer    = Color(0xFFFFB3B3),
)

private val CcgLightColorScheme = lightColorScheme(
    primary             = LightAccentBlue,
    onPrimary           = Color.White,
    primaryContainer    = Color(0xFFD8E8FF),
    onPrimaryContainer  = Color(0xFF001E45),

    secondary           = LightAccentPurple,
    onSecondary         = Color.White,
    secondaryContainer  = Color(0xFFEEDEFF),
    onSecondaryContainer= Color(0xFF2D005E),

    tertiary            = LightAccentGold,
    onTertiary          = Color.White,
    tertiaryContainer   = Color(0xFFFFE9A0),
    onTertiaryContainer = Color(0xFF2C2000),

    background          = LightBg,
    onBackground        = LightTextPrimary,

    surface             = LightSurface,
    onSurface           = LightTextPrimary,
    surfaceVariant      = LightSurfaceVar,
    onSurfaceVariant    = LightTextSecondary,

    surfaceContainer        = LightCard,
    surfaceContainerHigh    = LightElevated,
    surfaceContainerHighest = LightElevated,

    outline             = Color(0xFF8A9BB0),
    outlineVariant      = Color(0xFFB0BFCF),

    error               = Color(0xFFB3261E),
    onError             = Color.White,
    errorContainer      = Color(0xFFF9DEDC),
    onErrorContainer    = Color(0xFF410E0B),
)

@Composable
fun KartonkiTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) CcgDarkColorScheme else CcgLightColorScheme,
        typography  = Typography,
        content     = content,
    )
}
