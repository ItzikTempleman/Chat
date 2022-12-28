package com.example.whatssappmainactivitymock.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.whatssappmainactivitymock.R
import com.example.whatssappmainactivitymock.project.composed_screens.*
import com.example.whatssappmainactivitymock.project.composed_screens.chat_screens.ChatsScreen

sealed class BottomBarScreen(val id: String, val title: String, val icon: Int) {

    object Status : BottomBarScreen("status","Status",R.drawable.status)
    object Calls : BottomBarScreen("calls","Calls",R.drawable.calls)
    object Communities : BottomBarScreen("communities","Communities",R.drawable.communities)
    object Chats : BottomBarScreen("chats","Chats",R.drawable.chats)
    object Settings : BottomBarScreen("settings","Settings",R.drawable.settings)

}

sealed class ChatMessageScreen(val id:String, val messages:List<String>) {

    object ChatMessage : ChatMessageScreen("chat_message_screen", emptyList())
}

object AppGraph {
    const val MAIN = "main_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}

@Composable
fun MainNavigationHost(navController: NavHostController) {
    NavHost(navController, AppGraph.MAIN, Modifier, AppGraph.HOME) {
        composable(AppGraph.MAIN) {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreenNavHost(navController: NavHostController) {

    NavHost(navController, BottomBarScreen.Status.id, Modifier, AppGraph.HOME) {

        composable(BottomBarScreen.Status.id) {
            StatusScreen()
        }
        composable(BottomBarScreen.Calls.id) {
            CallsScreen()
        }

        composable(BottomBarScreen.Communities.id) {
            CommunityScreen()
        }
        composable(BottomBarScreen.Chats.id) {
            ChatsScreen(navController)
        }

        composable(BottomBarScreen.Settings.id) {
            SettingsScreen()
        }
    }
}

@Composable
fun DetailsNavGraph(navController: NavHostController){
    NavHost(navController, ChatMessageScreen.ChatMessage.id, Modifier, AppGraph.DETAILS) {
        composable(ChatMessageScreen.ChatMessage.id) {
            ScreenContent(emptyList())
        }
    }
}


