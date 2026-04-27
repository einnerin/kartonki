package com.example.kartonki.ui.screen.home

import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kartonki.ui.theme.AccentGold
import com.example.kartonki.ui.theme.LocalAppStrings
import com.example.kartonki.ui.theme.TextSecondary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val FEEDBACK_EMAIL = "kartonki.feedback@gmail.com"

private val BetaAmber = Color(0xFFFFB300)
private val BetaBg = Color(0xFF2A1F00)

@Composable
fun BetaBadge(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = LocalAppStrings.current
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(BetaBg)
            .border(1.dp, BetaAmber.copy(alpha = 0.7f), RoundedCornerShape(20.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick,
            )
            .padding(horizontal = 10.dp, vertical = 5.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = s.betaBadge,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = BetaAmber,
            letterSpacing = 1.sp,
        )
    }
}

@Composable
fun BetaInfoDialog(
    onDismiss: () -> Unit,
) {
    val s = LocalAppStrings.current
    val context = LocalContext.current
    val clipboard = LocalClipboard.current
    val scope = remember { CoroutineScope(Dispatchers.Main) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = s.betaDialogTitle,
                fontWeight = FontWeight.Bold,
                color = AccentGold,
            )
        },
        text = {
            Column {
                Text(
                    text = s.betaDialogText,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(Modifier.height(14.dp))

                // Email row: clickable email + copy icon
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Black.copy(alpha = 0.25f))
                        .border(
                            1.dp,
                            AccentGold.copy(alpha = 0.4f),
                            RoundedCornerShape(10.dp),
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { sendFeedbackEmail(context) }
                            .padding(horizontal = 12.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text(
                            text = "✉",
                            fontSize = 18.sp,
                            color = AccentGold,
                        )
                        Text(
                            text = FEEDBACK_EMAIL,
                            style = MaterialTheme.typography.bodyMedium,
                            color = AccentGold,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                    IconButton(
                        onClick = {
                            scope.launch {
                                clipboard.setClipEntry(
                                    ClipEntry(
                                        ClipData.newPlainText(
                                            s.betaDialogEmailLabel,
                                            FEEDBACK_EMAIL,
                                        )
                                    )
                                )
                                Toast.makeText(
                                    context,
                                    s.betaDialogEmailCopied,
                                    Toast.LENGTH_SHORT,
                                ).show()
                            }
                        },
                        modifier = Modifier.size(40.dp),
                    ) {
                        Text(
                            text = "⎘",
                            fontSize = 18.sp,
                            color = TextSecondary,
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(s.betaDialogClose, color = AccentGold)
            }
        },
    )
}

private fun sendFeedbackEmail(context: android.content.Context) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:$FEEDBACK_EMAIL")
    }
    val chooser = Intent.createChooser(intent, null)
    try {
        context.startActivity(chooser)
    } catch (_: ActivityNotFoundException) {
        Toast.makeText(
            context,
            FEEDBACK_EMAIL,
            Toast.LENGTH_LONG,
        ).show()
    }
}
