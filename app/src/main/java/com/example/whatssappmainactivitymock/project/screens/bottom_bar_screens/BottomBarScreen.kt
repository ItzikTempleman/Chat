package com.example.whatssappmainactivitymock.project.screens.bottom_bar_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.whatssappmainactivitymock.R



@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Status,
        BottomBarScreen.Calls,
        BottomBarScreen.Communities,
        BottomBarScreen.Chats,
        BottomBarScreen.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        BottomNavigation(
            backgroundColor = colorResource(R.color.white)
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen, currentDestination, navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(screen: BottomBarScreen, currentDestination: NavDestination?, navController: NavHostController) {
    BottomNavigationItem(
        label = {
            Text(
                text = screen.title,
                fontSize = 9.sp
            )
        },
        selectedContentColor = colorResource(R.color.toolbar_blue),
        icon = {
            Icon(
                modifier = Modifier.size(32.dp),
                painter = painterResource(screen.icon),
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = colorResource(R.color.grey),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
) {
    object Status : BottomBarScreen(
        route = "status",
        title = "Status",
        icon = R.drawable.status
    )

    object Calls : BottomBarScreen(
        route = "calls",
        title = "Calls",
        icon = R.drawable.calls
    )

    object Communities : BottomBarScreen(
        route = "communities",
        title = "Communities",
        icon = R.drawable.communities
    )

    object Chats : BottomBarScreen(
        route = "chats",
        title = "Chats",
        icon = R.drawable.chats
    )

    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = R.drawable.settings
    )
}