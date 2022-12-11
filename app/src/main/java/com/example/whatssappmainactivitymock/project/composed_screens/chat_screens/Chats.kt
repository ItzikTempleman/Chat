package com.example.whatssappmainactivitymock.project.composed_screens.chat_screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.rememberNavController
import com.example.whatssappmainactivitymock.R
import com.example.whatssappmainactivitymock.project.composed_screens.*
import com.example.whatssappmainactivitymock.project.models.Chat
import com.example.whatssappmainactivitymock.project.models.getAllChats
import com.example.whatssappmainactivitymock.project.models.getFilteredChats
import com.example.whatssappmainactivitymock.project.navigation.ChatMessageScreenNavGraph
import com.example.whatssappmainactivitymock.project.navigation.ShowNavBar
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

val chats = getAllChats()
val filteredChats = getFilteredChats()
var isNavShowing = mutableStateOf(true)
var isFiltered = mutableStateOf(false)
var isChatClicked = mutableStateOf(false)

@Composable
fun ChatsScreen() {
    val state = rememberCollapsingToolbarScaffoldState()
    Column(modifier = Modifier.fillMaxWidth()) {
        TopBar()
        CollapsingToolbarScaffold(modifier = Modifier,
            state = state,
            scrollStrategy = ScrollStrategy.EnterAlways,
            toolbar = {
                val textSize = (30 * state.toolbarState.progress).sp
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .pin()
                    .background(color = colorResource(id = R.color.white)))
                Column() {
                    Text(text = stringResource(id = R.string.chats),
                        style = TextStyle(color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Bold,
                            fontSize = textSize),
                        modifier = Modifier.padding(15.dp))
                    SearchField()
                    BroadcastListAndNewGroup()
                    ArchivedChats()
                }
            }
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                ChatListLazyColumn(){
                    Log.d("TAG", it.user.firstName)
                   // moveToChat(it.messageList)

                }
                ShowNavBar(isNavShowing)
            }
        }
    }
}

@Composable
fun moveToChat(messageList: List<String>) {
    ChatMessageScreen(individualChatMessageList = messageList)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TopBar() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {

        val (headerText, createButton, cameraIcon) = createRefs()
        ClickableText(
            modifier = Modifier
                .padding(top = 24.dp, start = 12.dp)
                .constrainAs(headerText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            style = TextStyle(
                fontSize = 20.sp,
                color = colorResource(id = R.color.light_blue)
            ),
            text = AnnotatedString(stringResource(id = R.string.edit)),
            onClick = {
                editChatScreen()
            }
        )

        IconButton(onClick = {
            isChatClicked.value = true
            isNavShowing.value = false
        },

            modifier = Modifier
                .padding(top = 24.dp, end = 20.dp)
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
                .padding(top = 21.dp, end = 30.dp)
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
fun ChatListLazyColumn(selectedChat:(Chat)->Unit) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = if (isFiltered.value) filteredChats else chats, itemContent = {
            Surface(modifier = Modifier
                .fillMaxHeight()
                .clickable {
                    selectedChat(it)
                }
            ) {
                ChatItemScreen(it)
            }
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