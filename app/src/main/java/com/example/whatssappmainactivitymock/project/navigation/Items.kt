package com.example.whatssappmainactivitymock.project.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.whatssappmainactivitymock.R

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

