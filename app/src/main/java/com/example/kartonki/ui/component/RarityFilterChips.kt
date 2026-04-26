package com.example.kartonki.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.ui.theme.LocalAppStrings
import com.example.kartonki.ui.theme.localizedName
import com.example.kartonki.ui.theme.localizedShortName

/**
 * Filter chips for word rarity.
 *
 * Two layouts:
 * - Default: each chip takes an equal share via `weight(1f)` and shows the
 *   localized short name (or a name+sublabel pair for the deck builder).
 * - [compact] = true: chips wrap to content width and show one to five stars
 *   (`★`) instead of text — count equals the rarity ordinal + 1. Lets the
 *   caller place a sibling chip in [trailingContent] within the same row.
 */
@Composable
fun RarityFilterChips(
    activeFilters: Set<Rarity>,
    onToggle: (Rarity) -> Unit,
    modifier: Modifier = Modifier,
    sublabelFor: ((Rarity) -> String)? = null,
    isOverLimitFor: ((Rarity) -> Boolean)? = null,
    compact: Boolean = false,
    trailingContent: (@Composable RowScope.() -> Unit)? = null,
) {
    val s = LocalAppStrings.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Rarity.entries.forEach { rarity ->
            val baseColor = Color(rarity.colorArgb)
            val overLimit = isOverLimitFor?.invoke(rarity) == true
            // When over-limit: use error red as the chip color to signal a problem.
            val chipColor = if (overLimit) Color(0xFFE53935) else baseColor
            val isActive = rarity in activeFilters
            val chipModifier = if (compact) Modifier else Modifier.weight(1f)
            Surface(
                onClick = { onToggle(rarity) },
                shape = RoundedCornerShape(20.dp),
                color = if (isActive) chipColor.copy(alpha = 0.85f) else chipColor.copy(alpha = if (overLimit) 0.20f else 0.15f),
                border = BorderStroke(if (overLimit) 2.dp else 1.dp, if (isActive) chipColor else chipColor.copy(alpha = 0.6f)),
                modifier = chipModifier,
            ) {
                val sub = sublabelFor?.invoke(rarity)
                when {
                    compact -> {
                        Text(
                            text = "★",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = if (isActive) FontWeight.Bold else FontWeight.Medium,
                            color = if (isActive) Color.White else chipColor,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        )
                    }
                    sub != null -> {
                        Text(
                            text = "${rarity.localizedShortName(s)}\n$sub",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = if (isActive || overLimit) FontWeight.ExtraBold else FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = if (isActive) Color.White else chipColor,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 4.dp, vertical = 4.dp),
                        )
                    }
                    else -> {
                        Text(
                            text = rarity.localizedShortName(s),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal,
                            color = if (isActive) Color.White else chipColor,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 4.dp, vertical = 4.dp),
                        )
                    }
                }
            }
        }
        if (trailingContent != null) {
            Spacer(Modifier.weight(1f))
            trailingContent()
        }
    }
}
