package com.example.whatssappmainactivitymock.project.navigation

import com.example.whatssappmainactivitymock.R

sealed class BottomBarScreen(
    val id: String,
    val title: String,
    val icon: Int
) {

    object Status : BottomBarScreen(
        id = "status",
        title = "Status",
        icon = R.drawable.status
    )

    object Calls : BottomBarScreen(
        id = "calls",
        title = "Calls",
        icon = R.drawable.calls
    )

    object Communities : BottomBarScreen(
        id = "communities",
        title = "Communities",
        icon = R.drawable.communities
    )

    object Chats : BottomBarScreen(
        id = "chats",
        title = "Chats",
        icon = R.drawable.chats
    )

    object Settings : BottomBarScreen(
        id = "settings",
        title = "Settings",
        icon = R.drawable.settings
    )

}
