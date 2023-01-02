package com.example.whatssappmainactivitymock.project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.whatssappmainactivitymock.R

sealed class DetailsScreens(val route: String, val messages: List<String>) {
    object ChatMessage : DetailsScreens("Chat details", emptyList())

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

@Composable
fun ChatMessageScreen(name: String, onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        ChatTopBar(name, onClick)
        ChatLazyColumn(emptyList())
        MessageBottomTextField()
    }
}

@Composable
fun ChatTopBar(name: String, onClick: () -> Unit) {
    Text(
        modifier = Modifier.clickable { onClick() },
        text = name,
        fontSize = MaterialTheme.typography.h3.fontSize,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ChatLazyColumn(chat: List<String>) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = chat, itemContent = {
            MessageItem(it)
        })
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
fun ChatBubble(isUserMe: Boolean) {
    Row(Modifier.height(IntrinsicSize.Max)) {
        Column(
            modifier = Modifier
                .background(
                    color = if (isUserMe) colorResource(R.color.tea_green) else colorResource(R.color.white),
                    shape = if (isUserMe) RoundedCornerShape(4.dp,
                        4.dp,
                        0.dp,
                        4.dp) else RoundedCornerShape(4.dp, 4.dp, 4.dp, 0.dp)
                )
                .width(IntrinsicSize.Max)
        ) {
            Text("Demo chat")
        }
    }
}

@Composable
fun MessageItem(messageList: String) {

}

