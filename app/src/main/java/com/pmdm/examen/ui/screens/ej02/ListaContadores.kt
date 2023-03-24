package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmdm.examen.R

@Composable
fun ListaCompraContadores(){
    val viewModel: ListaContadoresViewmodel = viewModel()
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
        ){
            TextField(value = text, onValueChange = { text = it })
            Button(onClick = {viewModel.addContador(text)}) { Text(text = stringResource(R.string.anhadir))}
        }
        ContadoresLazyList(
            list = viewModel.listaContadores,
            incrementar = {viewModel.incrementarContador(it, 1)},
            decrementar = {viewModel.decrementarContador(it, 1)},
            onRemoveItem = { viewModel.removeContador(it) },
        )
    }
}