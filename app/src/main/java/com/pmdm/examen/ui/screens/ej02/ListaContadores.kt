package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pmdm.examen.R

@Composable
fun ListaContadores() {
    var mostrarCuadro by rememberSaveable { mutableStateOf(false) }
    var cantidadContadores by rememberSaveable{ mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        if(mostrarCuadro){
            OutlinedTextField(
                value = cantidadContadores.toString(),
                onValueChange = {},
                placeholder = { stringResource(R.string.tfNumeroContadoresPlaceholder)},
            )
            Button(
                onClick = { /*TODO*/ }
            ) {
                Button(onClick = {} ) { Text(text = stringResource(R.string.mostrar)) }
            }
        } else {

        }
    }

}