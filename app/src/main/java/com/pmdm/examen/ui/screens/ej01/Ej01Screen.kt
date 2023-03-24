package com.pmdm.examen.ui.screens.ej01

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.examen.R

@Composable
@Preview
fun Ej01Screen(){
    var mostrarContadores by rememberSaveable{ mutableStateOf(false) }
    var numeroContadores by rememberSaveable{ mutableStateOf(0) }

    val focusManager = LocalFocusManager.current

    var onMostrarClick = {

    }
    var onValueContadoresChange = {}


    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        topBar = { TopAppBar(title={ Text(text = "Contadores") }) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (mostrarContadores) {
                    PantallaContadores(numeroContadores, )
                } else {
                    DefinirContadores(numeroContadores, onMostrarClick, onValueContadoresChange, Modifier)
                }
            }
        }
    )
}

@Composable
fun PantallaContadores(
    cantidadContadores: Int,
) {
    //var listaContadores by rememberSaveable{ mutableListOf(List<Int>) }
    var listaContadores = List(cantidadContadores) { _ -> 0 }
    val saveLista = rememberSaveable { mutableListOf(listaContadores) }

    //val incrementar: () -> Unit = { contador1 += incremento1; contadorGlobal += incremento1 }

    Column(modifier = Modifier.fillMaxSize()) {
        for (i in 0 until cantidadContadores - 1) {
            BloqueContador(listaContadores.get(i), Unit, Unit)
        }
    }

}

@Composable
fun BloqueContador(
    valor: Int,
    incrementar: Unit,
    decrementar: Unit,

    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center,
    ){
        Button(onClick = { incrementar } ){Text(text= stringResource(R.string.incrementar))}
        Text(text = "$valor")
        Button(onClick = { decrementar }){Text(text= stringResource(R.string.decrementar))}
    }
}

@Composable
fun DefinirContadores(
    cantidadContadores: Int,
    onClick: () -> Unit,
    onValueChange: () -> Unit,
    modifier: Modifier
) {
    var text by remember { mutableStateOf("") }
    Column(modifier = modifier
        .fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { stringResource(R.string.tfNumeroContadoresPlaceholder)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )

        Button(onClick = onClick) { Text(text = stringResource(R.string.mostrar)) }
    }
}