package com.example.whatssappmainactivitymock.project.composed_screens.chat_screens

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.whatssappmainactivitymock.R


@Composable
fun SearchField() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (textField, filterIcon) = createRefs()
        val textColor = colorResource(R.color.lighter_grey)
        var newText by remember { mutableStateOf("") }

        TextField(
            modifier = Modifier
                .width(350.dp)
                .height(50.dp)
                .constrainAs(textField) {
                    end.linkTo(filterIcon.start)
                    start.linkTo(parent.start)
                },
            value = newText,
            onValueChange = { initialText ->
                newText = initialText
            },
            textStyle = TextStyle(
                fontSize = 16.sp

            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.search),
                    fontSize = 16.sp
                )
            },

            leadingIcon = {
                Icon(
                    Icons.Filled.Search, contentDescription = "search"
                )
            },

            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = textColor,
                focusedLabelColor = textColor,
                cursorColor = textColor,
                textColor = colorResource(R.color.grey),
                leadingIconColor = Color.Black,
                backgroundColor = colorResource(R.color.light_grey),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp)
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
