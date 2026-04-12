package com.example.kartonki.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.kartonki.domain.model.AchievementId
import com.example.kartonki.ui.theme.RarityLegendary
import com.example.kartonki.ui.theme.glowEffect

@Composable
fun AchievementNotificationDialog(
    achievement: AchievementId,
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.7f)),
            contentAlignment = Alignment.Center,
        ) {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + scaleIn(animationSpec = spring()),
            ) {
                Column(
                    modifier = Modifier
                        .padding(32.dp)
                        .glowEffect(RarityLegendary, glowRadius = 32.dp, cornerRadius = 24.dp, alpha = 0.6f)
                        .background(
                            Brush.verticalGradient(
                                listOf(Color(0xFF1C1400), Color(0xFF2A1E00)),
                            ),
                            shape = RoundedCornerShape(24.dp),
                        )
                        .border(2.dp, RarityLegendary.copy(alpha = 0.8f), RoundedCornerShape(24.dp))
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Text("✨", fontSize = 48.sp)
                    Text(
                        text = "Достижение получено!",
                        style = MaterialTheme.typography.labelLarge,
                        color = RarityLegendary,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = achievement.icon,
                        fontSize = 56.sp,
                    )
                    Text(
                        text = achievement.title,
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = achievement.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.7f),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(Modifier.height(8.dp))
                    // Reward card
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF0F0A00), RoundedCornerShape(12.dp))
                            .border(1.dp, RarityLegendary.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                            .padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "🏆  Награда: Legendary карточка",
                            style = MaterialTheme.typography.labelSmall,
                            color = RarityLegendary.copy(alpha = 0.8f),
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = achievement.rewardWordOriginal,
                            style = MaterialTheme.typography.titleLarge,
                            color = RarityLegendary,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Text(
                            text = "добавлена в вашу коллекцию",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.5f),
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    Button(
                        onClick = onDismiss,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = RarityLegendary,
                            contentColor = Color(0xFF1A1000),
                        ),
                    ) {
                        Text("Отлично!", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
