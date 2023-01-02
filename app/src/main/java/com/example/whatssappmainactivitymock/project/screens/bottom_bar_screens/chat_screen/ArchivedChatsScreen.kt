package com.example.whatssappmainactivitymock.project.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.whatssappmainactivitymock.R
import com.example.whatssappmainactivitymock.project.screens.bottom_bar_screens.chat_screen.moveToArchiveChats

@Composable
fun ArchivedChats() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable {
                moveToArchiveChats()
            }
    ) {
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
