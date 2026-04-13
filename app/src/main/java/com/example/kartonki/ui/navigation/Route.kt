package com.example.kartonki.ui.navigation

import android.net.Uri

sealed class Route(val path: String) {
    object Splash        : Route("splash")
    object Home          : Route("home")
    object Study         : Route("study")
    object MyDecks       : Route("my_decks")
    object Collection    : Route("collection")
    object PvpDeckSelect : Route("pvp_deck_select")
    object Settings      : Route("settings")
    object PlayerStats   : Route("player_stats")
    object WordStats     : Route("word_stats")
    object Achievements  : Route("achievements")

    object WordSetDetail : Route("set_detail/{setId}") {
        fun createRoute(setId: Long) = "set_detail/$setId"
        const val ARG_SET_ID = "setId"
    }

    object StudySession : Route("study_session/{setId}") {
        fun createRoute(setId: Long) = "study_session/$setId"
        const val ARG_SET_ID = "setId"
    }

    object DeckBuilder : Route("deck_builder/{deckId}") {
        fun createRoute(deckId: Long) = "deck_builder/$deckId"
        const val ARG_DECK_ID = "deckId"
    }

    object ProblemWordsList    : Route("problem_words_list")
    object ProblemWordsSession : Route("problem_words_session")

    object PackShop    : Route("pack_shop")
    object PackOpening : Route("pack_opening/{count}") {
        fun createRoute(count: Int) = "pack_opening/$count"
        const val ARG_COUNT = "count"
    }
    object NewCards    : Route("new_cards")

    object PvpGame : Route("pvp_game/{deck1Id}/{deck2Id}?p1Name={p1Name}&p2Name={p2Name}") {
        fun createRoute(p1Name: String, p2Name: String, deck1Id: Long, deck2Id: Long): String {
            val e1 = Uri.encode(p1Name)
            val e2 = Uri.encode(p2Name)
            return "pvp_game/$deck1Id/$deck2Id?p1Name=$e1&p2Name=$e2"
        }
        const val ARG_DECK1_ID = "deck1Id"
        const val ARG_DECK2_ID = "deck2Id"
        const val ARG_P1_NAME  = "p1Name"
        const val ARG_P2_NAME  = "p2Name"
    }

    object Login : Route("login")

    object PvpModeSelect : Route("pvp_mode_select")

    object OnlineMatchmaking : Route("online_matchmaking")

    object OnlinePvpGame : Route("online_pvp_game/{matchId}/{myIndex}") {
        fun createRoute(matchId: String, myIndex: Int) = "online_pvp_game/$matchId/$myIndex"
        const val ARG_MATCH_ID = "matchId"
        const val ARG_MY_INDEX = "myIndex"
    }
}
