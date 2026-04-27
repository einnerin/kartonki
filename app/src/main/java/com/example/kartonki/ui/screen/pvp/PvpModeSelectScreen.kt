package com.example.kartonki.ui.screen.pvp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kartonki.data.remote.FirebaseAuthManager
import com.example.kartonki.ui.theme.AccentGold
import com.example.kartonki.ui.theme.AccentPurple
import com.example.kartonki.ui.theme.glowEffect

@Composable
fun PvpModeSelectScreen(
    authManager: FirebaseAuthManager,
    onNavigateBack: () -> Unit,
    onNavigateToOnlineMatchmaking: () -> Unit,
    onNavigateToLocalPvp: () -> Unit,
) {
    val isSignedIn = authManager.currentUser.value?.isAnonymous == false

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.background)))
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        IconButton(
            onClick = onNavigateBack,
            modifier = Modifier.padding(8.dp),
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = AccentGold.copy(alpha = 0.8f),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "⚔️",
                fontSize = 40.sp,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "PvP — Выбор режима",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = AccentGold,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Сразись с другим игроком",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            Spacer(Modifier.height(48.dp))

            // Online button
            ModeCard(
                emoji = "🌐",
                title = "Онлайн",
                subtitle = if (isSignedIn)
                    "Найти соперника в интернете"
                else
                    "Требуется аккаунт Google\n(сейчас: режим гостя)",
                gradient = Brush.horizontalGradient(
                    listOf(Color(0xFF6A0DAD), AccentPurple)
                ),
                glowColor = AccentPurple,
                enabled = true,
                onClick = onNavigateToOnlineMatchmaking,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.height(16.dp))

            // Local button
            ModeCard(
                emoji = "📱",
                title = "На одном устройстве",
                subtitle = "Pass & play с другом рядом",
                gradient = Brush.horizontalGradient(
                    listOf(Color(0xFF1565C0), Color(0xFF1A88C0))
                ),
                glowColor = Color(0xFF1A88C0),
                enabled = true,
                onClick = onNavigateToLocalPvp,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun ModeCard(
    emoji: String,
    title: String,
    subtitle: String,
    gradient: Brush,
    glowColor: Color,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale = if (isPressed && enabled) 0.97f else 1f

    Box(
        modifier = modifier
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .then(
                if (enabled) Modifier.glowEffect(glowColor, 18.dp, 20.dp, 0.4f)
                else Modifier
            )
            .clip(RoundedCornerShape(20.dp))
            .background(if (enabled) gradient else Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.surfaceVariant, MaterialTheme.colorScheme.surfaceVariant)))
            .border(
                1.5.dp,
                if (enabled) glowColor.copy(alpha = 0.5f) else MaterialTheme.colorScheme.outline,
                RoundedCornerShape(20.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                onClick = onClick,
            )
            .padding(24.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(emoji, fontSize = 32.sp)
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = if (enabled) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = if (enabled) Color.White.copy(alpha = 0.75f) else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                    textAlign = TextAlign.Start,
                )
            }
            Text(
                text = "›",
                fontSize = 24.sp,
                color = if (enabled) Color.White else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.3f),
            )
        }
    }
}
