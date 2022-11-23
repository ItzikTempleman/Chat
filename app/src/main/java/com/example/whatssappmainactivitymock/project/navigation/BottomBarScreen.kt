package com.example.whatssappmainactivitymock.project.navigation

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
