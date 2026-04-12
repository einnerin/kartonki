package com.example.kartonki.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.theme.BgCard
import com.example.kartonki.ui.theme.TextSecondary
import com.example.kartonki.ui.theme.glowEffect

@Composable
fun WordCard(
    word: Word,
    showDetails: Boolean = true,
    modifier: Modifier = Modifier,
) {
    val rarityColor = Color(word.rarity.colorArgb)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .glowEffect(rarityColor, glowRadius = 14.dp, cornerRadius = 16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.5.dp, rarityColor.copy(alpha = 0.7f)),
        colors = CardDefaults.cardColors(containerColor = BgCard),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row {
                Spacer(modifier = Modifier.weight(1f))
                RarityBadge(rarity = word.rarity)
            }
            val isHebrew = word.languagePair.startsWith("he")
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = word.original,
                style = MaterialTheme.typography.displaySmall.copy(
                    textDirection = if (isHebrew) TextDirection.Rtl else TextDirection.Ltr,
                ),
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
            if (isHebrew && word.transliteration != null) {
                Text(
                    text = word.transliteration,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary,
                    fontSize = 14.sp,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = word.translation,
                style = MaterialTheme.typography.headlineSmall,
                color = rarityColor,
                fontWeight = FontWeight.Medium,
            )
            if (showDetails) {
                word.definition?.let { def ->
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = def,
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary,
                    )
                }
                word.example?.let { ex ->
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "\"$ex\"",
                        style = MaterialTheme.typography.bodyMedium,
                        fontStyle = FontStyle.Italic,
                        color = TextSecondary,
                    )
                }
            }
        }
    }
}

@Composable
fun RarityBadge(rarity: Rarity, modifier: Modifier = Modifier) {
    val color = Color(rarity.colorArgb)
    Surface(
        modifier = modifier,
        color = color.copy(alpha = 0.18f),
        contentColor = color,
        shape = RoundedCornerShape(6.dp),
    ) {
        Text(
            text = rarity.displayName.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        )
    }
}
