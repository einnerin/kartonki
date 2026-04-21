package com.example.kartonki.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.kartonki.data.remote.FirebaseAuthManager
import com.example.kartonki.ui.component.AchievementNotificationDialog
import com.example.kartonki.ui.screen.achievements.AchievementEventViewModel
import com.example.kartonki.ui.screen.achievements.AchievementsScreen
import com.example.kartonki.ui.screen.collection.CollectionScreen
import com.example.kartonki.ui.screen.deckbuilder.DeckBuilderScreen
import com.example.kartonki.ui.screen.home.HomeScreen
import com.example.kartonki.ui.screen.login.LoginScreen
import com.example.kartonki.ui.screen.mydecks.MyDecksScreen
import com.example.kartonki.ui.screen.pvp.OnlineMatchmakingScreen
import com.example.kartonki.ui.screen.pvp.OnlinePvpGameScreen
import com.example.kartonki.ui.screen.pvp.PvpDeckSelectScreen
import com.example.kartonki.ui.screen.pvp.PvpGameScreen
import com.example.kartonki.ui.screen.pvp.PvpModeSelectScreen
import com.example.kartonki.ui.screen.rewards.NewCardsEventViewModel
import com.example.kartonki.ui.screen.rewards.NewCardsScreen
import com.example.kartonki.ui.screen.settings.SettingsScreen
import com.example.kartonki.ui.screen.splash.SplashScreen
import com.example.kartonki.ui.screen.shop.PackOpeningScreen
import com.example.kartonki.ui.screen.shop.PackShopScreen
import com.example.kartonki.ui.screen.stats.PlayerStatsScreen
import com.example.kartonki.ui.screen.stats.WordStatsScreen
import com.example.kartonki.ui.screen.study.ProblemWordsListScreen
import com.example.kartonki.ui.screen.study.ProblemWordsSessionScreen
import com.example.kartonki.ui.screen.study.StudyScreen
import com.example.kartonki.ui.screen.study.StudySessionScreen
import com.example.kartonki.ui.screen.study.WordSetDetailScreen

@Composable
fun AppNavGraph(navController: NavHostController, authManager: FirebaseAuthManager) {
    // Achievement notification overlay — shared across all screens
    val achievementVm: AchievementEventViewModel = hiltViewModel()
    val pendingAchievement by achievementVm.pendingNotification.collectAsState()

    // New cards event overlay — shared across all screens
    val newCardsVm: NewCardsEventViewModel = hiltViewModel()
    val pendingNewCards by newCardsVm.pendingNewCards.collectAsState()

    // Analytics: tab navigation tracking — фиксируем смену destination'а
    val navTracker: com.example.kartonki.analytics.NavigationAnalyticsTracker = hiltViewModel()
    androidx.compose.runtime.DisposableEffect(navController) {
        val listener = androidx.navigation.NavController.OnDestinationChangedListener { _, destination, _ ->
            navTracker.onDestinationChanged(destination.route)
        }
        navController.addOnDestinationChangedListener(listener)
        onDispose { navController.removeOnDestinationChangedListener(listener) }
    }

    LaunchedEffect(pendingNewCards.isNotEmpty()) {
        if (pendingNewCards.isNotEmpty()) {
            navController.navigate(Route.NewCards.path) { launchSingleTop = true }
        }
    }

    NavHost(navController = navController, startDestination = Route.Splash.path) {

        composable(Route.Splash.path) {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(Route.Home.path) {
                        popUpTo(Route.Splash.path) { inclusive = true }
                    }
                },
            )
        }

        composable(Route.Login.path) {
            LoginScreen(
                onSignedIn = {
                    navController.navigate(Route.Home.path) {
                        popUpTo(Route.Login.path) { inclusive = true }
                    }
                },
            )
        }

        composable(Route.Home.path) {
            HomeScreen(
                onNavigateToStudy = { navController.navigate(Route.Study.path) },
                onNavigateToPvp = { navController.navigate(Route.PvpModeSelect.path) },
                onNavigateToCollection = { navController.navigate(Route.MyDecks.path) },
                onNavigateToSettings = { navController.navigate(Route.Settings.path) },
                onNavigateToShop = { navController.navigate(Route.PackShop.path) },
            )
        }

        composable(Route.PvpModeSelect.path) {
            PvpModeSelectScreen(
                authManager = authManager,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToOnlineMatchmaking = { navController.navigate(Route.OnlineMatchmaking.path) },
                onNavigateToLocalPvp = { navController.navigate(Route.PvpDeckSelect.path) },
            )
        }

        composable(Route.OnlineMatchmaking.path) {
            OnlineMatchmakingScreen(
                onNavigateBack = { navController.popBackStack() },
                onMatchFound = { matchId, myIndex ->
                    navController.navigate(Route.OnlinePvpGame.createRoute(matchId, myIndex)) {
                        popUpTo(Route.OnlineMatchmaking.path) { inclusive = true }
                    }
                },
            )
        }

        composable(
            route = Route.OnlinePvpGame.path,
            arguments = listOf(
                navArgument(Route.OnlinePvpGame.ARG_MATCH_ID) { type = NavType.StringType },
                navArgument(Route.OnlinePvpGame.ARG_MY_INDEX) { type = NavType.IntType },
            ),
        ) {
            OnlinePvpGameScreen(
                onNavigateHome = {
                    navController.navigate(Route.Home.path) {
                        popUpTo(Route.Home.path) { inclusive = true }
                    }
                },
            )
        }

        composable(Route.Settings.path) {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToStats = { navController.navigate(Route.PlayerStats.path) },
                onNavigateToWordStats = { navController.navigate(Route.WordStats.path) },
                onNavigateToAchievements = { navController.navigate(Route.Achievements.path) },
                onSignOut = {
                    navController.navigate(Route.Home.path) {
                        popUpTo(0) { inclusive = true }
                    }
                },
            )
        }

        composable(Route.PlayerStats.path) {
            PlayerStatsScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable(Route.WordStats.path) {
            WordStatsScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToProblemWords = { navController.navigate(Route.ProblemWordsSession.path) },
            )
        }

        composable(Route.ProblemWordsSession.path) {
            ProblemWordsSessionScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable(Route.Achievements.path) {
            AchievementsScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable(Route.Study.path) {
            StudyScreen(
                onNavigateToSetDetail = { setId ->
                    navController.navigate(Route.WordSetDetail.createRoute(setId))
                },
                onNavigateToProblemWords = { navController.navigate(Route.ProblemWordsList.path) },
                onNavigateBack = { navController.popBackStack() },
            )
        }

        composable(Route.ProblemWordsList.path) {
            ProblemWordsListScreen(
                onNavigateBack = { navController.popBackStack() },
                onStartSession = {
                    navController.navigate(Route.ProblemWordsSession.path)
                },
            )
        }

        composable(
            route = Route.WordSetDetail.path,
            arguments = listOf(
                navArgument(Route.WordSetDetail.ARG_SET_ID) { type = NavType.LongType },
            ),
        ) {
            WordSetDetailScreen(
                onStartStudy = { setId ->
                    navController.navigate(Route.StudySession.createRoute(setId))
                },
                onNavigateBack = { navController.popBackStack() },
            )
        }

        composable(
            route = Route.StudySession.path,
            arguments = listOf(
                navArgument(Route.StudySession.ARG_SET_ID) { type = NavType.LongType },
            ),
        ) {
            StudySessionScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable(Route.MyDecks.path) {
            MyDecksScreen(
                onNavigateToDeckBuilder = { deckId ->
                    navController.navigate(Route.DeckBuilder.createRoute(deckId))
                },
                onNavigateToCollection = { navController.navigate(Route.Collection.path) },
                onNavigateBack = { navController.popBackStack() },
            )
        }

        composable(Route.Collection.path) {
            CollectionScreen(
                onNavigateBack = { navController.popBackStack() },
            )
        }

        composable(
            route = Route.DeckBuilder.path,
            arguments = listOf(
                navArgument(Route.DeckBuilder.ARG_DECK_ID) { type = NavType.LongType },
            ),
        ) {
            DeckBuilderScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable(Route.PvpDeckSelect.path) {
            PvpDeckSelectScreen(
                onNavigateBack = { navController.popBackStack() },
                onStartGame = { p1Name, p2Name, deck1Id, deck2Id ->
                    navController.navigate(
                        Route.PvpGame.createRoute(p1Name, p2Name, deck1Id, deck2Id)
                    )
                },
            )
        }

        composable(
            route = Route.PvpGame.path,
            arguments = listOf(
                navArgument(Route.PvpGame.ARG_DECK1_ID) { type = NavType.LongType },
                navArgument(Route.PvpGame.ARG_DECK2_ID) { type = NavType.LongType },
                navArgument(Route.PvpGame.ARG_P1_NAME) {
                    type = NavType.StringType; defaultValue = "Игрок 1"
                },
                navArgument(Route.PvpGame.ARG_P2_NAME) {
                    type = NavType.StringType; defaultValue = "Игрок 2"
                },
            ),
        ) {
            PvpGameScreen(
                onNavigateHome = {
                    navController.navigate(Route.Home.path) {
                        popUpTo(Route.Home.path) { inclusive = true }
                    }
                },
                onPlayAgain = {
                    navController.navigate(Route.PvpDeckSelect.path) {
                        popUpTo(Route.PvpDeckSelect.path) { inclusive = true }
                    }
                },
            )
        }

        composable(Route.PackShop.path) {
            PackShopScreen(
                onNavigateBack = { navController.popBackStack() },
                onOpenPacks = { count -> navController.navigate(Route.PackOpening.createRoute(count)) },
            )
        }

        composable(
            route = Route.PackOpening.path,
            arguments = listOf(navArgument(Route.PackOpening.ARG_COUNT) { type = NavType.IntType }),
        ) {
            PackOpeningScreen(
                onFinished = { navController.popBackStack() },
                onNavigateHome = {
                    navController.navigate(Route.Home.path) {
                        popUpTo(Route.Home.path) { inclusive = true }
                    }
                },
            )
        }

        composable(Route.NewCards.path) {
            val cards by newCardsVm.pendingNewCards.collectAsState()
            NewCardsScreen(
                cards = cards,
                onDismiss = {
                    newCardsVm.consume()
                    navController.popBackStack()
                },
            )
        }
    }

    // Global achievement notification dialog
    pendingAchievement?.let { achievement ->
        AchievementNotificationDialog(
            achievement = achievement,
            onDismiss = { achievementVm.dismissNotification() },
        )
    }
}
