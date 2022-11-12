package com.example.whatssappmainactivitymock.composed_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.whatssappmainactivitymock.R

@Composable
fun CallsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Title(title = stringResource(R.string.calls))
    }
}