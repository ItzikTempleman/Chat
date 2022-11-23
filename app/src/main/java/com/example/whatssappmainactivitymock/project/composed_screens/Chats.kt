@file:OptIn(ExperimentalMaterialApi::class)

package com.example.whatssappmainactivitymock.project.composed_screens


import android.util.Log
import android.view.animation.RotateAnimation
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
    Column(modifier = Modifier.fillMaxSize()) {
        RotateAnimation(isFiltered = isFiltered.value)
        Title(title = stringResource(R.string.chats),
            textAlignment = TextAlign.Start,
            arrangement = Arrangement.Start,
            textSize = 36.sp)
        SearchField(modifier = Modifier)
        BroadcastListAndNewGroup()
        Divider(Modifier, thickness = 0.75.dp, color = colorResource(R.color.lighter_grey))
        ChatListLazyColumn()
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

        BottomSheetDialogPopUp(isChatClicked.value)
        ShowNavBar(isNavShowing)
    }

}


@Composable
fun Title(
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
fun SearchField(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (filterIcon, textField) = createRefs()


        val textColor = colorResource(R.color.lighter_grey)
        var text by remember { mutableStateOf("") }

        TextField(
            modifier = modifier
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
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp)

    ) {

        ClickableText(
            
            style = TextStyle(
                fontSize = 20.sp,
                color = colorResource(id = R.color.light_blue)
            ),
            text = AnnotatedString(stringResource(R.string.broadcast_lists)),
            onClick = {
                moveToBroadCastList()
            }
        )

        ClickableText(
            style = TextStyle(
                fontSize = 20.sp,
                color = colorResource(id = R.color.light_blue)
            ),
            text = AnnotatedString(stringResource(R.string.new_group)),
            onClick = {
               createNewGroup()
            }
        )

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

@Composable
fun RotateAnimation(isFiltered: Boolean) {
    var currentRotation by remember { mutableStateOf(0f) }
    val rotation = remember { Animatable(currentRotation) }
    LaunchedEffect(isFiltered) {

        if (isFiltered) {
            rotation.animateTo(
                targetValue = currentRotation + 180F,
                animationSpec = tween(300, easing = LinearEasing)
            ) {
                currentRotation = value
            }
        } else {
            if (currentRotation > 0) {
                rotation.animateTo(
                    targetValue = currentRotation - 180F,
                    animationSpec = tween(300, easing = LinearEasing)
                ) {
                    currentRotation = value
                }
            }
        }
    }
    TopBar(title = stringResource(R.string.edit))
}

fun createNewGroup() {

}

fun moveToBroadCastList() {

}


fun openCamera() {

}

fun editChatScreen() {

}









