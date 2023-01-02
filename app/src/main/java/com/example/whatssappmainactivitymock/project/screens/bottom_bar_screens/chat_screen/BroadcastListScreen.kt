package com.example.whatssappmainactivitymock.project.screens.chat_screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.whatssappmainactivitymock.R
import com.example.whatssappmainactivitymock.project.screens.bottom_bar_screens.chat_screen.createNewGroup
import com.example.whatssappmainactivitymock.project.screens.bottom_bar_screens.chat_screen.moveToBroadCastList

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
            }
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
