package com.pmdm.examen.ui.screens.ej01

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import com.pmdm.examen.R
import com.pmdm.examen.ui.screens.ej02.Contador
import com.pmdm.examen.ui.screens.ej02.ListaContadoresViewmodel

@Composable
@Preview
fun Ej01Screen() {
    var mostrarContadores by rememberSaveable { mutableStateOf(false) }
    var numeroContadores by rememberSaveable { mutableStateOf(0) }

    val onMostrarClick: (Int) -> Unit = { numeroContadores = it }


    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = { Text(text = "Contadores") }) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (mostrarContadores) {
                    PantallaContadores(numeroContadores)
                } else {
                    DefinirContadores(onMostrarClick, Modifier)
                }
            }
        }
    )
}

@Composable
fun PantallaContadores(
    cantidadContadores: Int,
) {
    val viewModel: ListaContadoresViewmodel = viewModel()
    for (i in 1..cantidadContadores) {
        viewModel.addContador("$i")
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = viewModel.listaContadores) { contador ->
            BloqueContador(contador)
        }
    }

}

@Composable
fun BloqueContador(
    contador: Contador

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(onClick = { contador.incrementar(1) }) { Text(text = stringResource(R.string.incrementar)) }
        Text(text = "${contador.valor}")
        Button(onClick = { contador.decrementar(1) }) { Text(text = stringResource(R.string.decrementar)) }
    }
}

@Composable
fun DefinirContadores(
    onClick: (Int) -> Unit,
    modifier: Modifier
) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { stringResource(R.string.tfNumeroContadoresPlaceholder) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )

        Button(
            onClick = { onClick(text.toInt()) }
        ) { Text(text = stringResource(R.string.mostrar)) }
    }
}