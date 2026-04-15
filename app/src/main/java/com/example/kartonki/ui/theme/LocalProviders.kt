package com.example.kartonki.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.kartonki.util.TtsManager

/** Provides [TtsManager] to any composable in the tree. Null outside MainActivity. */
val LocalTtsManager = staticCompositionLocalOf<TtsManager?> { null }
