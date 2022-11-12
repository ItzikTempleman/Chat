package com.example.whatssappmainactivitymock.navigation

import com.example.whatssappmainactivitymock.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
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

    object Camera : BottomBarScreen(
        route = "camera",
        title = "Camera",
        icon = R.drawable.camera
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
