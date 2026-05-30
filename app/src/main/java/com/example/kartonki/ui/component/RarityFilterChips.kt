package com.example.kartonki.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
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
 * Layouts:
 * - [sublabelFor] != null: each chip takes equal share via `weight(1f)` and shows
 *   the localized short name on top of the sublabel string (e.g. card count in
 *   DeckBuilder: «Обыч / 3/10»).
 * - Otherwise: chips wrap to content width and show 1-5 stars (`★`) — count
 *   equals the rarity ordinal + 1. Color carries the rarity; long-press shows
 *   the full localized name via Material PlainTooltip for discoverability.
 *
 * Stars-only is the default for plain filter rows because localized short names
 * («Обыч», «Uncomm», «P.comm») truncated badly when weight(1f) split width
 * across 5 chips on phone-sized screens.
 *
 * [trailingContent] lets the caller place a sibling element in the same row.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RarityFilterChips(
    activeFilters: Set<Rarity>,
    onToggle: (Rarity) -> Unit,
    modifier: Modifier = Modifier,
    sublabelFor: ((Rarity) -> String)? = null,
    isOverLimitFor: ((Rarity) -> Boolean)? = null,
    trailingContent: (@Composable RowScope.() -> Unit)? = null,
) {
    val s = LocalAppStrings.current
    val hasSublabel = sublabelFor != null
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .then(modifier),
        horizontalArrangement = if (hasSublabel) Arrangement.spacedBy(4.dp) else Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Rarity.entries.forEach { rarity ->
            val baseColor = Color(rarity.colorArgb)
            val overLimit = isOverLimitFor?.invoke(rarity) == true
            // When over-limit: use error red as the chip color to signal a problem.
            val chipColor = if (overLimit) Color(0xFFE53935) else baseColor
            val isActive = rarity in activeFilters
            val chipModifier = if (hasSublabel) Modifier.weight(1f) else Modifier
            val surface: @Composable () -> Unit = {
                Surface(
                    onClick = { onToggle(rarity) },
                    shape = RoundedCornerShape(20.dp),
                    color = if (isActive) chipColor.copy(alpha = 0.85f) else chipColor.copy(alpha = if (overLimit) 0.20f else 0.15f),
                    border = BorderStroke(if (overLimit) 2.dp else 1.dp, if (isActive) chipColor else chipColor.copy(alpha = 0.6f)),
                    modifier = chipModifier,
                ) {
                    val sub = sublabelFor?.invoke(rarity)
                    if (sub != null) {
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
                    } else {
                        Text(
                            text = "★".repeat(rarity.ordinal + 1),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = if (isActive) FontWeight.Bold else FontWeight.Medium,
                            color = if (isActive) Color.White else chipColor,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        )
                    }
                }
            }
            // Long-press tooltip exposes the full localized name for accessibility
            // and rarity-system discovery — stars alone don't teach «COMMON».
            // Tooltip is only attached in the stars-only layout (sublabel layout
            // already shows the short name visibly).
            if (hasSublabel) {
                surface()
            } else {
                TooltipBox(
                    positionProvider = TooltipDefaults.rememberTooltipPositionProvider(
                        positioning = TooltipAnchorPosition.Above,
                    ),
                    tooltip = { PlainTooltip { Text(rarity.localizedName(s)) } },
                    state = rememberTooltipState(),
                ) {
                    surface()
                }
            }
        }
        if (trailingContent != null) {
            Spacer(Modifier.weight(1f))
            trailingContent()
        }
    }
}
