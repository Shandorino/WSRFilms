package com.example.wsrfilms

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wsrfilms.screens.SignInScreen
import com.example.wsrfilms.screens.SplashScreen

@Composable
fun Navigation(vm: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("SplashScreen") {
            SplashScreen(navController)
        }
        composable("SignInScreen") {
            SignInScreen(vm)
        }
    }
}