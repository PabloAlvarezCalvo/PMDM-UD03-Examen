package com.pmdm.examen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.pmdm.examen.ui.navigation.Screens


@Composable
fun MainScreen(navController: NavController){
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        topBar = {TopAppBar(title={Text(text = "Examen Ev2 - Pablo AC")})},
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = { navController.navigate(route = Screens.Ejercicio01.route) }) {
                    Text(text = "Ejercicio 01")
                }
                Button(onClick = { navController.navigate(route = Screens.Ejercicio02.route) }) {
                    Text(text = "Ejercicio 02")
                }
                Button(onClick = { navController.navigate(route = Screens.Ejercicio03.route) }) {
                    Text(text = "Ejercicio 03")
                }
            }
        }
    )
}