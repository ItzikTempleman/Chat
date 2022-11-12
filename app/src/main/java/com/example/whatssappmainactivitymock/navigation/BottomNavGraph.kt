package com.example.whatssappmainactivitymock.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatssappmainactivitymock.composed_screens.*

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Status.route
    ) {
        composable(route = BottomBarScreen.Status.route) {
            StatusScreen()
        }
        composable(route = BottomBarScreen.Calls.route) {
            CallsScreen()
        }

        composable(route = BottomBarScreen.Camera.route) {
            CameraScreen()
        }
        composable(route = BottomBarScreen.Chats.route) {
            ChatsScreen()
        }

        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }
}