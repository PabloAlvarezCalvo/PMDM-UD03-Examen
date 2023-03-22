package com.pmdm.examen.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pmdm.examen.ui.screens.MainScreen
import com.pmdm.examen.ui.screens.ej01.Ej01Screen
import com.pmdm.examen.ui.screens.ej02.Ej02Screen
import com.pmdm.examen.ui.screens.ej03.Ej03Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.MainScreen.route) {

        composable(route = Screens.MainScreen.route) { MainScreen(navController) }
        composable(route = Screens.Ejercicio01.route) { Ej01Screen() }
        composable(route = Screens.Ejercicio02.route) { Ej02Screen() }
        composable(route = Screens.Ejercicio03.route) { Ej03Screen() }

    }
}



