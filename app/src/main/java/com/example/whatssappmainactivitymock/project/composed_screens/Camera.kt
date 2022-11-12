package com.example.whatssappmainactivitymock.project.composed_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.whatssappmainactivitymock.R

@Composable
fun CameraScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Title(title = stringResource(R.string.camera))
    }
}