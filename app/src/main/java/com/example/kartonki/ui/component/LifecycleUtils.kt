package com.example.kartonki.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner

/**
 * Invokes [action] every time the host lifecycle transitions to ON_RESUME.
 *
 * The DisposableEffect is keyed only on the lifecycle owner — so the observer is
 * registered once per Activity/screen, not re-registered on every recomposition.
 * [rememberUpdatedState] keeps `currentAction` pointing at the latest lambda so
 * a caller passing a fresh closure each recomposition (capturing fresh state)
 * still sees up-to-date values when ON_RESUME fires.
 */
@Composable
fun OnResume(action: () -> Unit) {
    val currentAction by rememberUpdatedState(action)
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) currentAction()
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }
}
