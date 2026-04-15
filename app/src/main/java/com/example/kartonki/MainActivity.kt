package com.example.kartonki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.example.kartonki.data.remote.FirebaseAuthManager
import com.example.kartonki.ui.navigation.AppNavGraph
import com.example.kartonki.ui.screen.home.MainViewModel
import com.example.kartonki.ui.theme.KartonkiTheme
import com.example.kartonki.ui.theme.LocalAppStrings
import com.example.kartonki.ui.theme.LocalTtsManager
import com.example.kartonki.ui.theme.appStringsFor
import com.example.kartonki.util.TtsManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @Inject lateinit var authManager: FirebaseAuthManager
    @Inject lateinit var ttsManager: TtsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isDarkTheme by mainViewModel.isDarkTheme.collectAsState()
            val nativeLanguage by mainViewModel.nativeLanguage.collectAsState()
            KartonkiTheme(darkTheme = isDarkTheme) {
                CompositionLocalProvider(
                    LocalAppStrings provides appStringsFor(nativeLanguage),
                    LocalTtsManager provides ttsManager,
                ) {
                    val navController = rememberNavController()
                    AppNavGraph(navController = navController, authManager = authManager)
                }
            }
        }
    }
}
