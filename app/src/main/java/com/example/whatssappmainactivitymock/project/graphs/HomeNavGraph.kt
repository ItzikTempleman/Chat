package com.example.whatssappmainactivitymock.project.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument

import com.example.whatssappmainactivitymock.project.screens.*
import com.example.whatssappmainactivitymock.project.screens.bottom_bar_screens.BottomBarScreen
import com.example.whatssappmainactivitymock.project.screens.bottom_bar_screens.chat_screen.ChatsScreen


@Composable
fun HomeNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Status.route
    ) {
        composable(route = BottomBarScreen.Status.route) {
            StatusScreen()
        }

        composable(route = BottomBarScreen.Calls.route) {
            CallsScreen()
        }

        composable(route = BottomBarScreen.Communities.route) {
            CommunityScreen()
        }

        composable(route = BottomBarScreen.Chats.route,
        arguments = listOf(

            navArgument("chats"){
                type= NavType.StringType
                defaultValue="chat"
                nullable=true
            }
        )
            ) {
            it.arguments?.getString("chats")?.let { it1 -> ChatsScreen(navController, it1) }

        }

        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
        detailsNavGraph(navController = navController)

    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreens.ChatMessage.route
    ) {
        composable(route = DetailsScreens.ChatMessage.route) {
            ChatMessageScreen(name = DetailsScreens.ChatMessage.route) {
                navController.navigate(DetailsScreens.ChatMessage.route)
            }
        }
    }
}

