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
            painter = painterResource(chat.person.image),
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
            text = chat.person.firstName + " " + chat.person.familyName,
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
            text = chat.messageList[0].content,
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
                .padding(start = 40.dp, bottom = 4.dp, top = 4.dp)
                .constrainAs(divider) {
                    top.linkTo(imageIcon.bottom)
                    start.linkTo(imageIcon.end)
                    end.linkTo(parent.end)
                }, thickness = 0.2.dp, color = colorResource(R.color.lighter_grey)
        )

    }
}
