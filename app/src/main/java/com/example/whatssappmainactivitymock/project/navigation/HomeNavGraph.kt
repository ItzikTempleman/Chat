package com.example.whatssappmainactivitymock.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.whatssappmainactivitymock.project.composed_screens.CallsScreen
import com.example.whatssappmainactivitymock.project.composed_screens.CommunityScreen
import com.example.whatssappmainactivitymock.project.composed_screens.SettingsScreen
import com.example.whatssappmainactivitymock.project.composed_screens.StatusScreen
import com.example.whatssappmainactivitymock.project.composed_screens.chat_screens.ChatsScreen


@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Status.id
    ) {
        composable(route = BottomBarScreen.Status.id) {
            StatusScreen()
        }
        composable(route = BottomBarScreen.Calls.id) {
            CallsScreen()
        }

        composable(route = BottomBarScreen.Communities.id) {
            CommunityScreen()
        }
        composable(route = BottomBarScreen.Chats.id) {
            ChatsScreen(navController)
        }

        composable(route = BottomBarScreen.Settings.id) {
            SettingsScreen()
        }
        detailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = BottomBarScreen.Chats.id
    ) {
        composable(route = BottomBarScreen.Chats.id) {
            ScreenContent(BottomBarScreen.Chats.id) {
                navController.navigate(ChatMessageScreen.ChatMessage.id)
            }
        }
    }
}


sealed class ChatMessageScreen(val id: String) {
    object ChatMessage : ChatMessageScreen(id = "CHAT_MESSAGE")
}
