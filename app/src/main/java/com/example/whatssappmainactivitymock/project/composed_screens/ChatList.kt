package com.example.whatssappmainactivitymock.project.composed_screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.whatssappmainactivitymock.R

val chats = getAllChats()
val filteredChats = getFilteredChats()

var isFiltered = mutableStateOf(false)
var unfilteredColor = R.color.light_blue
var filteredContentColor = R.color.blue
@Composable
fun ChatsScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        RotateAnimation(isFiltered = isFiltered.value)

        Title(title = stringResource(R.string.chats))
        SearchField(modifier = Modifier)
        Divider(Modifier.padding(horizontal = 12.dp), thickness = 0.33.dp, color = Color.Black)

        ChatListLazyColumn()
    }
}


@Composable
fun TopBar(title: String, currentRotation: Float) {

    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {

        val (editText, filterIcon, createButton) = createRefs()

        Text(
            text = title,
            modifier = Modifier
                .padding(12.dp)
                .constrainAs(editText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            textAlign = TextAlign.Start,
            color = colorResource(R.color.light_blue),
            fontSize = 20.sp
        )

        IconButton(onClick = {
            isFiltered.value = !isFiltered.value
        },
            modifier = Modifier
                .rotate(currentRotation)
                .padding(12.dp)
                .size(24.dp)
                .constrainAs(filterIcon) {
                    top.linkTo(parent.top)
                    end.linkTo(createButton.start)
                }
        ) {
            Icon(
                contentDescription = "filter",
                painter = painterResource(R.drawable.filter),
                tint = colorResource(if (isFiltered.value) filteredContentColor else unfilteredColor),

                )
        }


        Icon(
            contentDescription = "create",
            painter = painterResource(R.drawable.create),
            tint = colorResource(R.color.light_blue),
            modifier = Modifier
                .padding(12.dp)
                .size(24.dp)
                .constrainAs(createButton) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Composable
fun Title(title: String, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            modifier = modifier.padding(horizontal = 12.dp),
            textAlign = TextAlign.Start,
            color = colorResource(R.color.black),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SearchField(modifier: Modifier = Modifier) {
    val textColor = colorResource(R.color.black)
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(45.dp),
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
            backgroundColor = textColor.copy(
                TextFieldDefaults.BackgroundOpacity
            ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp)
    )
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
    TopBar(title = stringResource(R.string.edit), currentRotation)
}


