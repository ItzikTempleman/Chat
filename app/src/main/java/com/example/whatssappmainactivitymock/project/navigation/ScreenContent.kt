package com.example.whatssappmainactivitymock.project.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.whatssappmainactivitymock.project.composed_screens.ChatLazyColumn
import com.example.whatssappmainactivitymock.project.composed_screens.ChatTopBar
import com.example.whatssappmainactivitymock.project.composed_screens.MessageBottomTextField

@Composable
fun ScreenContent(individualChatMessage: String, function: () -> Unit) {
        Column(modifier = Modifier.fillMaxWidth()) {
            ChatTopBar()
            ChatLazyColumn(emptyList())
            MessageBottomTextField()
    }
}