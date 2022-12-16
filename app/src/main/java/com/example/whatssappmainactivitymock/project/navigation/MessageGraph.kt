package com.example.whatssappmainactivitymock.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatssappmainactivitymock.project.composed_screens.ChatMessageScreen

@Composable
fun ChatMessageScreenNavGraph(navController: NavHostController, messageList:List<String>){

    NavHost(navController, ChatScreen.ChatPage.route){
        composable(ChatScreen.ChatPage.route) {
            ChatMessageScreen(messageList)
        }
    }
}
