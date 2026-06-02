package com.example.kartonki.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.widget.Toast
import com.example.kartonki.BuildConfig

/**
 * Sends a user feedback report via the device's email client.
 *
 * Why mailto: at 400-user scale, a server-side feedback collection (Firestore
 * write + admin dashboard) is overkill. An email with diagnostic info pre-filled
 * gets the bug into the developer's inbox with zero infrastructure cost.
 *
 * Diagnostics included by default: app version, build flavour, device model,
 * Android version, optional caller-supplied context (e.g. match ID for a PvP
 * outcome complaint). User can add their description above the pre-filled block.
 *
 * If no email client is installed, falls back to a Toast — better than a silent
 * ActivityNotFoundException crash.
 */
object FeedbackHelper {
    private const val SUPPORT_EMAIL = "einerin40@gmail.com"

    fun sendReport(
        context: Context,
        subject: String,
        userInstructions: String,
        extraContext: String? = null,
        emptyClientFallbackMessage: String,
    ) {
        val diagnostics = buildString {
            appendLine()
            appendLine()
            appendLine("---")
            appendLine("App version: ${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})")
            appendLine("Build type: ${BuildConfig.BUILD_TYPE}")
            appendLine("Device: ${Build.MANUFACTURER} ${Build.MODEL}")
            appendLine("Android: ${Build.VERSION.RELEASE} (SDK ${Build.VERSION.SDK_INT})")
            if (!extraContext.isNullOrBlank()) {
                appendLine()
                appendLine(extraContext)
            }
        }
        val body = userInstructions + diagnostics

        // ACTION_SENDTO with mailto: only resolves to email clients (not random
        // share targets), which is what we want for a support email.
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(SUPPORT_EMAIL))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }
        try {
            context.startActivity(intent)
        } catch (_: ActivityNotFoundException) {
            Toast.makeText(context, emptyClientFallbackMessage, Toast.LENGTH_LONG).show()
        }
    }
}
