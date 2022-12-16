package com.example.whatssappmainactivitymock.project.navigation

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.whatssappmainactivitymock.R




@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
        Scaffold(bottomBar = { BottomBar(navController) }) {
            BottomNavGraph(navController)
           // RootNavigationGraph()
        }
    }


@Composable
fun BottomBar(navController: NavController) {
    val screens = listOf(
        BottomBarScreen.Status,
        BottomBarScreen.Calls,
        BottomBarScreen.Communities,
        BottomBarScreen.Chats,
        BottomBarScreen.Settings,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = colorResource(R.color.white)
    ) {

        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController as NavHostController
            )
        }
    }
}

