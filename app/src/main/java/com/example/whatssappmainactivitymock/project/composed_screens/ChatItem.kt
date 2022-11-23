package com.example.whatssappmainactivitymock.project.composed_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.whatssappmainactivitymock.R
import com.example.whatssappmainactivitymock.project.models.Chat
import com.example.whatssappmainactivitymock.project.models.User

@Composable
fun ChatItemScreen(chat: Chat) {

    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (imageIcon, userName, message, divider) = createRefs()

        Image(
            painter = painterResource(chat.image),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 4.dp)
                .constrainAs(imageIcon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                .size(52.dp)
                .clip(CircleShape)
                .border(0.5.dp, colorResource(R.color.lighter_grey), CircleShape)
        )


        Text(
            text = chat.name.firstName + " " + chat.name.familyName,
            modifier = Modifier
                .padding(start = 4.dp)
                .constrainAs(userName) {
                    top.linkTo(imageIcon.top)
                    start.linkTo(imageIcon.end)
                },
            textAlign = TextAlign.Start,
            color = colorResource(R.color.black),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Text(
            text = chat.summary,
            modifier = Modifier
                .padding(start = 4.dp)
                .constrainAs(message) {
                    top.linkTo(userName.bottom)
                    start.linkTo(imageIcon.end)
                },
            textAlign = TextAlign.Start,
            color = colorResource(R.color.black),
            fontSize = 14.sp
        )
        Divider(
            Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, bottom = 4.dp, top = 4.dp)
                .constrainAs(divider) {
                    top.linkTo(imageIcon.bottom)
                    start.linkTo(imageIcon.end)
                    end.linkTo(parent.end)
                }, thickness = 0.2.dp, color = colorResource(R.color.lighter_grey)
        )

    }
}


private val allUsers: MutableList<User> = mutableListOf()
private val allChats: MutableList<Chat> = mutableListOf()
private val filteredChatList: MutableList<Chat> = mutableListOf()


private val user1 = User("John", "Cohen")
private val user2 = User("Michael", "Potter")
private val user3 = User("Orel", "Lev")
private val user4 = User("Steve", "Gates")
private val user5 = User("Itzik", "Lasso")


private val chat1 = Chat(user1, "Yeah i'm coming!", R.drawable.profile_image)
private val chat2 = Chat(user2, "Don't tell", R.drawable.profile_image)
private val chat3 = Chat(user3, "yes i am coming", R.drawable.profile_image)
private val chat4 = Chat(user4, "My favorite..", R.drawable.profile_image)
private val chat5 = Chat(user5, "Yesterday he was ok", R.drawable.profile_image)


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

fun getUsersForNewChatList(): MutableList<User> {
    allUsers.add(user1)
    allUsers.add(user2)
    allUsers.add(user3)
    allUsers.add(user4)
    allUsers.add(user5)
    return allUsers
}