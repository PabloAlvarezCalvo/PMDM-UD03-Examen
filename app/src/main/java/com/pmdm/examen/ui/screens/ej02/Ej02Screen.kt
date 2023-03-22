package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Ej02Screen(){
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = { Text("Andrey Breslav") }) },
        content = {
                padding -> Modifier.padding(padding)
            Chat(messages = messages)
        }
    )
}