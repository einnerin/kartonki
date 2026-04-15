package com.example.kartonki.util

import android.content.Context
import android.speech.tts.TextToSpeech
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TtsManager @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private var tts: TextToSpeech? = null
    @Volatile private var isReady = false

    init {
        tts = TextToSpeech(context) { status ->
            isReady = status == TextToSpeech.SUCCESS
        }
    }

    fun speak(text: String, languagePair: String) {
        if (!isReady) return
        val engine = tts ?: return
        val locale = localeFor(languagePair)
        val result = engine.setLanguage(locale)
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            // Fallback to English if the requested language is unavailable
            engine.setLanguage(Locale.ENGLISH)
        }
        engine.speak(text, TextToSpeech.QUEUE_FLUSH, null, "tts_$text")
    }

    private fun localeFor(languagePair: String): Locale = when {
        languagePair.startsWith("he") -> Locale("he", "IL")
        else -> Locale.US
    }
}
