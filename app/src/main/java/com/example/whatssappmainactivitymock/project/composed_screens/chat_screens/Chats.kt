@file:OptIn(ExperimentalMaterialApi::class)

package com.example.whatssappmainactivitymock.project.composed_screens.chat_screens


import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.whatssappmainactivitymock.R
import com.example.whatssappmainactivitymock.project.composed_screens.*
import com.example.whatssappmainactivitymock.project.navigation.ShowNavBar


val chats = getAllChats()
val filteredChats = getFilteredChats()
var isNavShowing = mutableStateOf(true)
var isFiltered = mutableStateOf(false)
var isChatClicked = mutableStateOf(false)

@Composable
fun ChatsScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        val scrollState = rememberScrollState()
        TopBar(stringResource(R.string.edit))
        Column(modifier = Modifier
            .fillMaxSize()
            .scrollable(state = scrollState, orientation = Orientation.Vertical)) {
            TitleBar(title = stringResource(R.string.chats),
                textAlignment = TextAlign.Start,
                arrangement = Arrangement.Start,
                textSize = 36.sp)
            SearchField()
            BroadcastListAndNewGroup()
            ArchivedChats()
            ChatListLazyColumn()
            ShowNavBar(isNavShowing)
        }
    }
}

@Composable
fun TopBar(title: String) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {

        val (headerText, createButton, cameraIcon) = createRefs()
        ClickableText(
            modifier = Modifier
                .padding(12.dp)
                .constrainAs(headerText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            style = TextStyle(
                fontSize = 20.sp,
                color = colorResource(id = R.color.light_blue)
            ),
            text = AnnotatedString(title),
            onClick = {
                editChatScreen()
            }
        )

        IconButton(onClick = {

            isChatClicked.value = true
            isNavShowing.value = false
        },

            modifier = Modifier
                .padding(12.dp)
                .size(24.dp)
                .constrainAs(createButton) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
        ) {
            Icon(
                contentDescription = "create",
                painter = painterResource(R.drawable.create),
                tint = colorResource(R.color.light_blue)
            )
        }

        IconButton(onClick = {
            openCamera()
        },
            modifier = Modifier
                .padding(9.dp)
                .size(30.dp)
                .constrainAs(cameraIcon) {
                    top.linkTo(parent.top)
                    end.linkTo(createButton.start)
                }
        ) {
            Icon(
                contentDescription = "camera",
                painter = painterResource(R.drawable.camera),
                tint = colorResource(R.color.light_blue)
            )
        }

    }
    BottomSheetDialogPopUp(isChatClicked.value)
}

@Composable
fun ChatListLazyColumn() {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = if (isFiltered.value) filteredChats else chats, itemContent = {
            ChatItemScreen(it)
        })
    }
}

@Composable
fun ContactListLazyColumn() {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = usersForNewChatList, itemContent = {
            ChooseContact(it)
        })
    }
}

fun createNewGroup() {

}

fun moveToBroadCastList() {

}


fun openCamera() {

}

fun editChatScreen() {

}


fun moveToArchiveChats() {

}