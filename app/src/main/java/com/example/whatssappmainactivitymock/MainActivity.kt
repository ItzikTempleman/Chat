package com.example.whatssappmainactivitymock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.whatssappmainactivitymock.navigation.MainScreen
import com.example.whatssappmainactivitymock.theme.WhatssappMainActivityMockTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatssappMainActivityMockTheme {
                MainScreen()
            }
        }
    }
}
