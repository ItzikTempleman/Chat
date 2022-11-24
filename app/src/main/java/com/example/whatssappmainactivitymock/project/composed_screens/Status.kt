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
import com.example.whatssappmainactivitymock.project.composed_screens.chat_screens.TitleBar

@Composable
fun StatusScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TitleBar(title = stringResource(R.string.status),
            textAlignment = TextAlign.Start,
            arrangement = Arrangement.Start,
           textSize = 36.sp
            )
    }
}