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
import com.example.kartonki.ui.component.AchievementNotificationDialog
import com.example.kartonki.ui.screen.achievements.AchievementEventViewModel
import com.example.kartonki.ui.screen.achievements.AchievementsScreen
import com.example.kartonki.ui.screen.collection.CollectionScreen
import com.example.kartonki.ui.screen.deckbuilder.DeckBuilderScreen
import com.example.kartonki.ui.screen.home.HomeScreen
import com.example.kartonki.ui.screen.mydecks.MyDecksScreen
import com.example.kartonki.ui.screen.pvp.PvpDeckSelectScreen
import com.example.kartonki.ui.screen.pvp.PvpGameScreen
import com.example.kartonki.ui.screen.rewards.NewCardsEventViewModel
import com.example.kartonki.ui.screen.rewards.NewCardsScreen
import com.example.kartonki.ui.screen.settings.SettingsScreen
import com.example.kartonki.ui.screen.splash.SplashScreen
import com.example.kartonki.ui.screen.shop.PackOpeningScreen
import com.example.kartonki.ui.screen.shop.PackShopScreen
import com.example.kartonki.ui.screen.stats.PlayerStatsScreen
import com.example.kartonki.ui.screen.stats.WordStatsScreen
import com.example.kartonki.ui.screen.study.ProblemWordsSessionScreen
import com.example.kartonki.ui.screen.study.StudyScreen
import com.example.kartonki.ui.screen.study.StudySessionScreen
import com.example.kartonki.ui.screen.study.WordSetDetailScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    // Achievement notification overlay — shared across all screens
    val achievementVm: AchievementEventViewModel = hiltViewModel()
    val pendingAchievement by achievementVm.pendingNotification.collectAsState()

    // New cards event overlay — shared across all screens
    val newCardsVm: NewCardsEventViewModel = hiltViewModel()
    val pendingNewCards by newCardsVm.pendingNewCards.collectAsState()

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

        composable(Route.Home.path) {
            HomeScreen(
                onNavigateToStudy = { navController.navigate(Route.Study.path) },
                onNavigateToPvp = { navController.navigate(Route.PvpDeckSelect.path) },
                onNavigateToCollection = { navController.navigate(Route.MyDecks.path) },
                onNavigateToSettings = { navController.navigate(Route.Settings.path) },
                onNavigateToShop = { navController.navigate(Route.PackShop.path) },
                onNavigateToProblemWords = { navController.navigate(Route.ProblemWordsSession.path) },
            )
        }

        composable(Route.Settings.path) {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToStats = { navController.navigate(Route.PlayerStats.path) },
                onNavigateToWordStats = { navController.navigate(Route.WordStats.path) },
                onNavigateToAchievements = { navController.navigate(Route.Achievements.path) },
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
                onNavigateBack = { navController.popBackStack() },
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
                onNavigateToDeckBuilder = {
                    navController.navigate(Route.DeckBuilder.createRoute(0L))
                },
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
                onOpenPack = { navController.navigate(Route.PackOpening.path) },
            )
        }

        composable(Route.PackOpening.path) {
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
