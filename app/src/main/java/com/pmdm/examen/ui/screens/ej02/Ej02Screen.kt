package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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

@Composable
fun ListaCompraContadores(){
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
        ){
            TextField(value = text, onValueChange = { text = it })
            Button(onClick = {}) { Text(text = stringResource(R.string.anhadir))}
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            
        }
    }
}