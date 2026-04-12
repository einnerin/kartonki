package com.example.kartonki.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.ui.theme.LocalAppStrings
import com.example.kartonki.ui.theme.localizedName

/**
 * A row of rarity filter chips with multi-select support.
 * Always shows each rarity in its own color (active = filled, inactive = tinted).
 *
 * @param activeFilters currently selected rarities (empty = show all)
 * @param onToggle called when a chip is tapped
 * @param sublabelFor optional second line for each chip (e.g. "2/4" slot counts in DeckBuilder)
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RarityFilterChips(
    activeFilters: Set<Rarity>,
    onToggle: (Rarity) -> Unit,
    modifier: Modifier = Modifier,
    sublabelFor: ((Rarity) -> String)? = null,
) {
    val s = LocalAppStrings.current
    FlowRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Rarity.entries.forEach { rarity ->
            val color = Color(rarity.colorArgb)
            val isActive = rarity in activeFilters
            Surface(
                onClick = { onToggle(rarity) },
                shape = RoundedCornerShape(20.dp),
                color = if (isActive) color.copy(alpha = 0.85f) else color.copy(alpha = 0.15f),
                border = BorderStroke(1.dp, if (isActive) color else color.copy(alpha = 0.4f)),
            ) {
                val sub = sublabelFor?.invoke(rarity)
                if (sub != null) {
                    Text(
                        text = "${rarity.localizedName(s)}\n$sub",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = if (isActive) FontWeight.ExtraBold else FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = if (isActive) Color.White else color,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp),
                    )
                } else {
                    Text(
                        text = rarity.localizedName(s),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal,
                        color = if (isActive) Color.White else color,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                    )
                }
            }
        }
    }
}
