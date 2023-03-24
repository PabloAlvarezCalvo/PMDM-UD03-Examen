package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pmdm.examen.R

@Composable
fun Ej02Screen(){
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = { Text(stringResource(R.string.contadores)) }) },
        content = {
                padding -> Modifier.padding(padding)
            ListaCompraContadores()
        }
    )
}