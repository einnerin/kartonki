package com.example.kartonki.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
import com.example.kartonki.ui.screen.settings.SettingsScreen
import com.example.kartonki.ui.screen.splash.SplashScreen
import com.example.kartonki.ui.screen.shop.PackOpeningScreen
import com.example.kartonki.ui.screen.shop.PackShopScreen
import com.example.kartonki.ui.screen.stats.PlayerStatsScreen
import com.example.kartonki.ui.screen.stats.WordStatsScreen
import com.example.kartonki.ui.screen.study.DismissedProblemWordsScreen
import com.example.kartonki.ui.screen.study.ProblemWordsListScreen
import com.example.kartonki.ui.screen.study.ProblemWordsSessionScreen
import com.example.kartonki.ui.screen.study.StudyScreen
import com.example.kartonki.ui.screen.study.StudySessionScreen
import com.example.kartonki.ui.screen.study.WordSetDetailScreen

@Composable
fun AppNavGraph(navController: NavHostController, authManager: FirebaseAuthManager) {
    // Achievement notification overlay — shared across all screens
    val achievementVm: AchievementEventViewModel = hiltViewModel()
    val pendingAchievement by achievementVm.pendingNotification.collectAsStateWithLifecycle()
    val achievementLanguagePair by achievementVm.languagePair.collectAsStateWithLifecycle()

    // Analytics: tab navigation tracking — фиксируем смену destination'а
    val navTracker: com.example.kartonki.analytics.NavigationAnalyticsTracker = hiltViewModel()
    androidx.compose.runtime.DisposableEffect(navController) {
        val listener = androidx.navigation.NavController.OnDestinationChangedListener { _, destination, _ ->
            navTracker.onDestinationChanged(destination.route)
        }
        navController.addOnDestinationChangedListener(listener)
        onDispose { navController.removeOnDestinationChangedListener(listener) }
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
                onNavigateToStudy = { navController.navigateSingleTop(Route.Study.path) },
                onNavigateToPvp = { navController.navigateSingleTop(Route.PvpModeSelect.path) },
                onNavigateToCollection = { navController.navigateSingleTop(Route.MyDecks.path) },
                onNavigateToSettings = { navController.navigateSingleTop(Route.Settings.path) },
                onNavigateToShop = { navController.navigateSingleTop(Route.PackShop.path) },
            )
        }

        composable(Route.PvpModeSelect.path) {
            PvpModeSelectScreen(
                authManager = authManager,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToOnlineMatchmaking = { navController.navigateSingleTop(Route.OnlineMatchmaking.path) },
                onNavigateToLocalPvp = { navController.navigateSingleTop(Route.PvpDeckSelect.path) },
                onNavigateToLogin = { navController.navigateSingleTop(Route.Login.path) },
            )
        }

        composable(Route.OnlineMatchmaking.path) {
            OnlineMatchmakingScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToDecks = { navController.navigateSingleTop(Route.MyDecks.path) },
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
                onNavigateToStats = { navController.navigateSingleTop(Route.PlayerStats.path) },
                onNavigateToWordStats = { navController.navigateSingleTop(Route.WordStats.path) },
                onNavigateToAchievements = { navController.navigateSingleTop(Route.Achievements.path) },
                onNavigateToDismissedProblemWords = {
                    navController.navigateSingleTop(Route.DismissedProblemWords.path)
                },
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
                onNavigateToProblemWords = { navController.navigateSingleTop(Route.ProblemWordsSession.path) },
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
                    navController.navigateSingleTop(Route.WordSetDetail.createRoute(setId))
                },
                onNavigateToProblemWords = { navController.navigateSingleTop(Route.ProblemWordsList.path) },
                onNavigateBack = { navController.popBackStack() },
            )
        }

        composable(Route.ProblemWordsList.path) {
            ProblemWordsListScreen(
                onNavigateBack = { navController.popBackStack() },
                onStartSession = {
                    navController.navigateSingleTop(Route.ProblemWordsSession.path)
                },
                onNavigateToDismissed = {
                    navController.navigateSingleTop(Route.DismissedProblemWords.path)
                },
            )
        }

        composable(Route.DismissedProblemWords.path) {
            DismissedProblemWordsScreen(onNavigateBack = { navController.popBackStack() })
        }

        composable(
            route = Route.WordSetDetail.path,
            arguments = listOf(
                navArgument(Route.WordSetDetail.ARG_SET_ID) { type = NavType.LongType },
            ),
        ) {
            WordSetDetailScreen(
                onStartStudy = { setId ->
                    navController.navigateSingleTop(Route.StudySession.createRoute(setId))
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
                    navController.navigateSingleTop(Route.DeckBuilder.createRoute(deckId))
                },
                onNavigateToCollection = { navController.navigateSingleTop(Route.Collection.path) },
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
                    navController.navigateSingleTop(
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
                onOpenPacks = { count -> navController.navigateSingleTop(Route.PackOpening.createRoute(count)) },
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

    }

    // Global achievement notification dialog
    pendingAchievement?.let { achievement ->
        AchievementNotificationDialog(
            achievement = achievement,
            languagePair = achievementLanguagePair,
            onDismiss = { achievementVm.dismissNotification() },
        )
    }
}

/**
 * navigate() that ignores a duplicate tap on an already-top destination — prevents a
 * second copy of the same screen from a fast double-tap. For plain forward pushes only;
 * transitions that already use popUpTo are inherently safe and keep plain navigate().
 */
private fun androidx.navigation.NavController.navigateSingleTop(route: String) =
    navigate(route) { launchSingleTop = true }
