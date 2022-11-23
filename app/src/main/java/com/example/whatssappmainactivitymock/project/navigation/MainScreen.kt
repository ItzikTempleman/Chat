package com.example.whatssappmainactivitymock.project.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.whatssappmainactivitymock.R

var isNavVisible = mutableStateOf(true)

@Composable
fun ShowNavBar(navStatus: MutableState<Boolean>) {
    isNavVisible = navStatus
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    if (isNavVisible.value) {
        val navController = rememberNavController()
        Scaffold(bottomBar = { BottomBar(navController) }) {
            BottomNavGraph(navController)
        }
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

            navController.navigate(screen.route)
        }
    )
}

