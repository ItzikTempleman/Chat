package com.example.whatssappmainactivitymock.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun MainContainerNavGraph(navController: NavHostController/*, messageList:List<String>*/) {
    NavHost(navController, Screen.MainScreen.route) {

        /*composable(Screen.MainScreen.route) {
            MainScreen(navController)
        }*/

        navigation(BottomBarScreen.Status.route, BottomBarScreen.Status.route){
            navController.navigate(route = Screen.MainScreen.route)
        }

        composable(Screen.MainScreen.route) {
            MainScreen()
        }

    }
}