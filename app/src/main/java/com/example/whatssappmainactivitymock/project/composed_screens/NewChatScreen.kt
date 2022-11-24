package com.example.whatssappmainactivitymock.project.composed_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.whatssappmainactivitymock.R
import com.example.whatssappmainactivitymock.project.composed_screens.chat_screens.ContactListLazyColumn
import com.example.whatssappmainactivitymock.project.composed_screens.chat_screens.TitleBar
import kotlinx.coroutines.launch



@ExperimentalMaterialApi
@Composable
fun BottomSheetDialogPopUp(isExpanded: Boolean) {

    if (isExpanded) {
        val scope = rememberCoroutineScope()
        val sheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
        val scaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = sheetState
        )


        BottomSheetScaffold(

            scaffoldState = scaffoldState,
            sheetContent = {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(800.dp)
                        .background(
                            color = colorResource(R.color.white),
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    ConstraintLayout(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        val (cancelButton) = createRefs()
                        IconButton(onClick = {
                            scope.launch {
                                sheetState.collapse()
                            }
                        },
                            modifier = Modifier
                                .padding(12.dp)
                                .size(36.dp)
                                .constrainAs(cancelButton) {
                                    top.linkTo(parent.top)
                                    end.linkTo(parent.end)
                                }) {
                            Icon(
                                contentDescription = "cancel",
                                painter = painterResource(R.drawable.cancel),
                                tint = colorResource(R.color.light_grey)
                            )
                        }
                        TitleBar(
                            title = stringResource(R.string.new_chat),
                            textAlignment = TextAlign.Center,
                            arrangement = Arrangement.Center,
                            textSize = 18.sp
                        )
                    }
                    NewChatSearchField(modifier = Modifier)
                    ContactListLazyColumn()

                }
            }
        ) {

            Box() {
                Button(onClick = {
                    scope.launch {
                        sheetState.expand()
                    }
                }) {

                }
            }
        }
    }
}


@Composable
fun NewChatSearchField(modifier: Modifier = Modifier) {
    val textColor = colorResource(R.color.black)
    var text by remember { mutableStateOf("") }
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
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
            backgroundColor = colorResource(
                R.color.light_grey
            ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp)
    )
}







