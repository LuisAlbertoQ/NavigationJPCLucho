package com.example.nabigationjpclucho.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nabigationjpclucho.ui.presentation.screens.HomeScreen
import com.example.nabigationjpclucho.ui.presentation.screens.ProfileScreen
import com.example.nabigationjpclucho.ui.presentation.screens.SettingsScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
    }
}