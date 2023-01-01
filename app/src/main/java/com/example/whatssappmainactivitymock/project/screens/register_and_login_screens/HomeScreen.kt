package com.example.whatssappmainactivitymock.project.screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.whatssappmainactivitymock.project.graphs.HomeNavGraph


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