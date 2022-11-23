package com.example.whatssappmainactivitymock.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatssappmainactivitymock.project.composed_screens.*

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController,BottomBarScreen.Status.route) {

        composable(route = BottomBarScreen.Status.route) {
            StatusScreen()
        }
        composable(route = BottomBarScreen.Calls.route) {
            CallsScreen()
        }

        composable(route = BottomBarScreen.Communities.route) {
            CommunityScreen()
        }
        composable(route = BottomBarScreen.Chats.route) {
            ChatsScreen()
        }

        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }
}