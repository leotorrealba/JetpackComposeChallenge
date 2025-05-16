package com.leotorrealba.jetpackcomposechallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leotorrealba.jetpackcomposechallenge.ui.screens.ColorPickerScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "colorPicker"
    ) {
        composable("colorPicker") {
            ColorPickerScreen()
        }
    }
}