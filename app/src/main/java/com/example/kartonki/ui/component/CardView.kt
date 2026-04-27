package com.example.kartonki.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.theme.LocalAppStrings
import com.example.kartonki.ui.theme.LocalTtsManager
import com.example.kartonki.ui.theme.glowEffect
import com.example.kartonki.ui.theme.localizedName

@Composable
fun WordCard(
    word: Word,
    modifier: Modifier = Modifier,
) {
    val rarityColor = Color(word.rarity.colorArgb)
    val ttsManager = LocalTtsManager.current
    val isRtl = word.languagePair.startsWith("he")

    Card(
        modifier = modifier
            .fillMaxWidth()
            .glowEffect(rarityColor, glowRadius = 14.dp, cornerRadius = 16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.5.dp, rarityColor.copy(alpha = 0.7f)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)) {

            // ── Word ─────────────────────────────────────────────────────────
            Text(
                text = word.original,
                style = MaterialTheme.typography.displaySmall.copy(
                    textDirection = if (isRtl) TextDirection.Rtl else TextDirection.Ltr,
                ),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
            )

            // ── Transliteration + TTS button ─────────────────────────────────
            val hasTranslit = word.transliteration != null
            if (hasTranslit || ttsManager != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (hasTranslit) {
                        Text(
                            text = word.transliteration!!,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.weight(1f, fill = false),
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    if (ttsManager != null) {
                        IconButton(
                            onClick = { ttsManager.speak(word.original, word.languagePair) },
                            modifier = Modifier.size(32.dp),
                        ) {
                            Text("🔊", fontSize = 16.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // ── Translation ───────────────────────────────────────────────────
            Text(
                text = word.translation,
                style = MaterialTheme.typography.headlineSmall,
                color = rarityColor,
                fontWeight = FontWeight.Medium,
            )

            // ── Definition (LEGENDARY only) ───────────────────────────────────
            if (word.rarity == Rarity.LEGENDARY) {
                word.definitionNative?.let { def ->
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = def,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontStyle = FontStyle.Italic,
                    )
                }
            }
        }
    }
}

@Composable
fun RarityBadge(rarity: Rarity, modifier: Modifier = Modifier) {
    val color = Color(rarity.colorArgb)
    val s = LocalAppStrings.current
    Surface(
        modifier = modifier,
        color = color.copy(alpha = 0.18f),
        contentColor = color,
        shape = RoundedCornerShape(6.dp),
    ) {
        Text(
            text = rarity.localizedName(s).uppercase(),
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        )
    }
}
