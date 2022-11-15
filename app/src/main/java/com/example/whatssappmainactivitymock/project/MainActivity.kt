package com.example.whatssappmainactivitymock.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.whatssappmainactivitymock.project.navigation.MainNavGraph
import com.example.whatssappmainactivitymock.project.navigation.MainScreen
import com.example.whatssappmainactivitymock.theme.WhatssappMainActivityMockTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatssappMainActivityMockTheme {
                //MainNavGraph(navController = NavHostController(this), composable = MainScreen())
                MainScreen()
            }
        }
    }
}
