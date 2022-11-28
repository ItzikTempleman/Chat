package com.example.whatssappmainactivitymock.project.composed_screens

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
import com.example.whatssappmainactivitymock.project.models.User
import com.example.whatssappmainactivitymock.project.models.getUsersForNewChatList

val usersForNewChatList = getUsersForNewChatList()

@Composable
fun ChooseContact(user: User) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = user.firstName+ " "+user.familyName,
            modifier = Modifier.padding(12.dp),
            textAlign = TextAlign.Start,
            color = colorResource(R.color.black),
            fontSize = 20.sp
        )
        Divider(Modifier.padding(horizontal = 12.dp), thickness = 0.2.dp, color = Color.Black)
    }

}