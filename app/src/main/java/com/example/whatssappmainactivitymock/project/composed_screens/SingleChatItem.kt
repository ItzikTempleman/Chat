package com.example.whatssappmainactivitymock.project.composed_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.whatssappmainactivitymock.R


@Composable
fun Chat(individualChatMessageList: MutableList<String>) {

    Column(modifier = Modifier.fillMaxWidth()) {
        ChatTopBar()
        ChatLazyColumn(individualChatMessageList)
        MessageBottomTextField()
    }

}

@Composable
fun MessageBottomTextField() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(colorResource(id = R.color.grey))
    )
}

@Composable
fun ChatLazyColumn(chat: MutableList<String>) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = chat, itemContent = {message->
            MessageItem(message)
        })
    }
}

@Composable
fun MessageItem(message: String) {

}


@Composable
fun ChatTopBar() {

}
