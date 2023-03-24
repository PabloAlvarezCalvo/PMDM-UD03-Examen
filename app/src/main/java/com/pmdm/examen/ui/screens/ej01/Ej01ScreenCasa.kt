package com.pmdm.examen.ui.screens.ej01

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun Ej01ScreenCasa() {
    var contador1 by rememberSaveable { mutableStateOf(0) }
    var contador2 by rememberSaveable { mutableStateOf(0) }
    var contadorGlobal by rememberSaveable { mutableStateOf(0) }

    var incremento1 by rememberSaveable { mutableStateOf(1) }
    var incremento2 by rememberSaveable { mutableStateOf(1) }

    var incrementoPrevio1 by rememberSaveable { mutableStateOf(1) }
    var incrementoPrevio2 by rememberSaveable { mutableStateOf(1) }

    val incrementar1: () -> Unit = { contador1 += incremento1; contadorGlobal += incremento1 }
    val incrementar2: () -> Unit = { contador2 += incremento2; contadorGlobal += incremento2 }
    val modificarIncremento1: (Int) -> Unit = { incremento1 = it }
    val modificarIncremento2: (Int) -> Unit = { incremento2 = it }
    val modificarIncrementoPrevio1: (Int) -> Unit = { incrementoPrevio1 = it }
    val modificarIncrementoPrevio2: (Int) -> Unit = { incrementoPrevio2 = it }
    val borrar1: () -> Unit = { contador1 = 0 }
    val borrar2: () -> Unit = { contador2 = 0 }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Contador(contador1, incremento1, incrementar1, modificarIncremento1, borrar1, incrementoPrevio1, modificarIncrementoPrevio1)

        Contador(contador2, incremento2, incrementar2, modificarIncremento2, borrar2, incrementoPrevio2, modificarIncrementoPrevio2)

        Row() {
            Text(text = "Global $contadorGlobal")
            Icon(painterResource(
                id = android.R.drawable.ic_menu_delete
            ),
                contentDescription = "Icono borrar",
                modifier = Modifier.clickable { contadorGlobal = 0 }
            )
        }
    }
}

@Composable
fun Contador(
    contadorLocal: Int,
    incremento: Int,
    onClick: () -> Unit,
    onValueChange: (Int) -> Unit,
    borrar: () -> Unit,
    incrementoPrevio: Int,
    modificarIncrementoPrevio : (Int) -> Unit

) {
    val focusManager = LocalFocusManager.current

    Column(
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { onClick(); focusManager.clearFocus() },
                enabled = incremento != 0
            ) {
                Text("Contador 1 ($contadorLocal)")
            }
            Text(text = "$contadorLocal", fontSize = 32.sp)
            Icon(painterResource(
                id = android.R.drawable.ic_menu_delete
            ),
                contentDescription = "Icono borrar",
                modifier = Modifier.clickable { borrar() }
            )

        }
        Row() {
            Text(text = "Incremento:")
            OutlinedTextField(
                modifier = Modifier.onFocusChanged { onValueChange(incrementoPrevio) },
                value = incremento.toString(),
                onValueChange = {
                    if (it.isNotBlank()) {
                        onValueChange(it.toInt())
                    } else {
                        onValueChange(incrementoPrevio)
                    }

                    modificarIncrementoPrevio(it.toInt())
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                )
        }
    }
}