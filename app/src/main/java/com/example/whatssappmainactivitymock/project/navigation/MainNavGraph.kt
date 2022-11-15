package com.example.whatssappmainactivitymock.project.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatssappmainactivitymock.project.composed_screens.*

@Composable
fun MainNavGraph(navController: NavHostController, composable: Unit) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Status.route
    ) {
        //addDestination()
        /*composable(route = BottomBarScreen.Status.route) {
            StatusScreen()
        }*/
    }
}