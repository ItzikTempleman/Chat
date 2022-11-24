@file:OptIn(ExperimentalMaterialApi::class)

package com.example.whatssappmainactivitymock.project.composed_screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.whatssappmainactivitymock.R
import com.example.whatssappmainactivitymock.project.navigation.ShowNavBar


val chats = getAllChats()
val filteredChats = getFilteredChats()


var isNavShowing = mutableStateOf(true)
var isFiltered = mutableStateOf(false)
var isChatClicked = mutableStateOf(false)




@Composable
fun ChatsScreen() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .scrollable(state = scrollState, orientation = Orientation.Vertical)) {
        TopBar(title = stringResource(R.string.edit))
        TitleBar(title = stringResource(R.string.chats),
            textAlignment = TextAlign.Start,
            arrangement = Arrangement.Start,
            textSize = 36.sp)
        SearchField()
        BroadcastListAndNewGroup()
        ArchivedChats()
        ChatListLazyColumn()
        BottomSheetDialogPopUp(isChatClicked.value)
        ShowNavBar(isNavShowing)
    }
}

@Composable
fun ArchivedChats() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable {
                moveToArchiveChats()
            }
    )


    {
        val (archiveBtn, archivedText, divider) = createRefs()
        Icon(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(archiveBtn) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            contentDescription = "archive",
            painter = painterResource(id = R.drawable.archived),
            tint = colorResource(id = R.color.lighter_grey)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(archivedText) {
                    top.linkTo(parent.top)
                    start.linkTo(archiveBtn.end)
                },
            text = stringResource(id = R.string.archived),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Divider(Modifier
            .padding(start = 80.dp)
            .constrainAs(divider) {
                top.linkTo(archivedText.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }, thickness = 0.5.dp, color = colorResource(R.color.lighter_grey))
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

}


@Composable
fun TitleBar(
    title: String,
    modifier: Modifier = Modifier,
    textAlignment: TextAlign,
    arrangement: Arrangement.Horizontal,
    textSize: TextUnit,
) {
    Row(horizontalArrangement = arrangement, modifier = Modifier.fillMaxWidth()) {

        Text(
            text = title,
            modifier = modifier.padding(horizontal = 12.dp),
            textAlign = textAlignment,
            color = colorResource(R.color.black),
            fontSize = textSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SearchField() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (filterIcon, textField) = createRefs()


        val textColor = colorResource(R.color.lighter_grey)
        var text by remember { mutableStateOf("") }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(
                    start = 54.dp,
                    bottom = 20.dp
                )
                .constrainAs(textField) {
                    end.linkTo(filterIcon.start)
                },
            value = text,
            onValueChange = { text = it },
            label = { Text(stringResource(R.string.search)) },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "search") },

            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = textColor,
                focusedLabelColor = textColor,
                cursorColor = textColor,
                textColor = textColor,
                leadingIconColor = textColor,
                backgroundColor = colorResource(R.color.light_grey),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )

        IconButton(onClick = {
            isFiltered.value = !isFiltered.value
        },
            modifier = Modifier
                .size(44.dp)
                .padding(
                    bottom = 20.dp
                )
                .constrainAs(filterIcon) {
                    top.linkTo(textField.top)

                    end.linkTo(parent.end)
                    bottom.linkTo(textField.bottom)
                }
        ) {
            Icon(
                painter = painterResource(if (!isFiltered.value) R.drawable.filtered_inner_shape else R.drawable.filter),
                contentDescription = "filter",
                tint = colorResource(R.color.light_blue)
            )
        }


    }
}


@Composable
fun BroadcastListAndNewGroup() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {

        val (broadcastList, newGroup, dividerLine) = createRefs()

        ClickableText(
            modifier = Modifier
                .padding(12.dp)
                .constrainAs(broadcastList) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            style = TextStyle(
                fontSize = 20.sp,
                color = colorResource(id = R.color.light_blue)
            ),
            text = AnnotatedString(stringResource(R.string.broadcast_lists)),
            onClick = {
                moveToBroadCastList()
            },

            )

        ClickableText(
            modifier = Modifier
                .padding(12.dp)
                .constrainAs(newGroup) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
            style = TextStyle(
                fontSize = 20.sp,
                color = colorResource(id = R.color.light_blue)
            ),
            text = AnnotatedString(stringResource(R.string.new_group)),
            onClick = {
                createNewGroup()
            }
        )
        Divider(Modifier.constrainAs(dividerLine) {
            top.linkTo(newGroup.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }, thickness = 0.75.dp, color = colorResource(R.color.lighter_grey))
    }
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










