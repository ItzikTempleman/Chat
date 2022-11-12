package com.example.whatssappmainactivitymock.composed_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatssappmainactivitymock.R
import com.example.whatssappmainactivitymock.models.Chat

@Composable
fun ChatItemScreen(chat: Chat) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = chat.name,
            modifier = Modifier.padding(12.dp),
            textAlign = TextAlign.Start,
            color = colorResource(R.color.black),
            fontSize = 20.sp
        )
        Text(
            text = chat.summary,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Start,
            color = colorResource(R.color.black),
            fontSize = 12.sp
        )
        Divider(Modifier.padding(horizontal = 12.dp), thickness = 0.2.dp, color = Color.Black)
    }
}


private val allChats: MutableList<Chat> = mutableListOf()
private val filteredChatList: MutableList<Chat> = mutableListOf()
private val chat1 = Chat("John", "Yeah i'm coming!")
private val chat2 = Chat("Michael", "Don't tell")
private val chat3 = Chat("Orel", "yes i am coming")
private val chat4 = Chat("Steve", "My favorite..")
private val chat5 = Chat("Itzik", "Yesterday he was ok")

fun getAllChats(): MutableList<Chat> {
    allChats.add(chat1)
    allChats.add(chat2)
    allChats.add(chat3)
    allChats.add(chat4)
    allChats.add(chat5)
    return allChats
}

fun getFilteredChats(): MutableList<Chat> {
    filteredChatList.add(chat5)
    filteredChatList.add(chat3)
    return filteredChatList
}
