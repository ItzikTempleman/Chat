package com.example.whatssappmainactivitymock.project.screens.register_and_login_screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.whatssappmainactivitymock.project.graphs.HomeNavGraph
import com.example.whatssappmainactivitymock.project.screens.bottom_bar_screens.BottomBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController()){
        Scaffold(
            bottomBar = { BottomBar(navController=navController) }
        ) {
              HomeNavGraph(navController=navController)
        }
}