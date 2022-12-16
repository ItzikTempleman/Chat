package com.example.whatssappmainactivitymock.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.whatssappmainactivitymock.project.navigation.MainScreen
import com.example.whatssappmainactivitymock.project.navigation.RootNavigationGraph
import com.example.whatssappmainactivitymock.theme.WhatssappMainActivityMockTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
               // MainScreen()
            RootNavigationGraph(navController = rememberNavController())
        }
    }
}
