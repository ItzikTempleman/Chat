package com.example.whatssappmainactivitymock.project.composed_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.whatssappmainactivitymock.R

@Composable
fun CommunityScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Title(
            title = stringResource(R.string.communities),
            textAlignment = TextAlign.Start,
            arrangement = Arrangement.Start, textSize = 36.sp
        )
    }
}