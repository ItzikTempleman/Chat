package com.example.whatssappmainactivitymock.project.navigation

sealed class Screen(val route: String, val message: List<String> = emptyList()) {
    object MainScreen : Screen("main_screen")
    object ChatMessageScreen : Screen("chat_screen")
}
