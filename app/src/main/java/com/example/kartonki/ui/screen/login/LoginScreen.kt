package com.example.kartonki.ui.screen.login

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kartonki.ui.theme.AccentBlue
import com.example.kartonki.ui.theme.AccentGold
import com.example.kartonki.ui.theme.BgDeep
import com.example.kartonki.ui.theme.TextSecondary
import com.example.kartonki.ui.theme.glowEffect

@Composable
fun LoginScreen(
    onSignedIn: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    // Auto-navigate when signed in
    LaunchedEffect(uiState.isSignedIn) {
        if (uiState.isSignedIn) onSignedIn()
    }

    val googleSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
    ) { result ->
        viewModel.handleGoogleSignInResult(result.data)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(Color(0xFF0D1B30), BgDeep))
            )
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            // Logo
            Text(text = "✦", fontSize = 48.sp, color = AccentGold)
            Spacer(Modifier.height(12.dp))
            Text(
                text = "KARTONKI",
                style = MaterialTheme.typography.displaySmall.copy(letterSpacing = 6.sp),
                fontWeight = FontWeight.ExtraBold,
                color = AccentGold,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Войдите, чтобы играть онлайн\nи сохранять статистику",
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                textAlign = TextAlign.Center,
            )

            Spacer(Modifier.height(56.dp))

            if (uiState.isLoading) {
                CircularProgressIndicator(
                    color = AccentGold,
                    modifier = Modifier.size(48.dp),
                )
            } else {
                // Google Sign-In button
                LoginButton(
                    text = "Войти через Google",
                    gradient = Brush.horizontalGradient(listOf(Color(0xFF1A237E), AccentBlue)),
                    glowColor = AccentBlue,
                    onClick = {
                        googleSignInLauncher.launch(viewModel.getGoogleSignInIntent(context))
                    },
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(Modifier.height(16.dp))

                // Guest button
                LoginButton(
                    text = "Играть как гость",
                    gradient = Brush.horizontalGradient(
                        listOf(Color(0xFF1B1B2F), Color(0xFF2D2D44))
                    ),
                    glowColor = Color(0xFF555577),
                    onClick = viewModel::signInAnonymously,
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(Modifier.height(16.dp))
                Text(
                    text = "Как гость вы можете играть офлайн.\nДля онлайн PvP нужен аккаунт Google.",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary.copy(alpha = 0.6f),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }

    // Error dialog
    uiState.error?.let { err ->
        AlertDialog(
            onDismissRequest = viewModel::dismissError,
            title = { Text("Ошибка входа") },
            text = { Text(err) },
            confirmButton = {
                TextButton(onClick = viewModel::dismissError) { Text("OK") }
            },
        )
    }
}

@Composable
private fun LoginButton(
    text: String,
    gradient: Brush,
    glowColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(if (isPressed) 0.97f else 1f, tween(100))

    Box(
        modifier = modifier
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .glowEffect(glowColor, glowRadius = 16.dp, cornerRadius = 16.dp, alpha = 0.4f)
            .clip(RoundedCornerShape(16.dp))
            .background(gradient)
            .border(1.dp, glowColor.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
            .clickable(interactionSource = interactionSource, indication = null, onClick = onClick)
            .padding(vertical = 18.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
    }
}
