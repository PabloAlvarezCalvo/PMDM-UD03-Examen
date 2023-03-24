package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pmdm.examen.R

@Composable
fun ContadoresListItem(
    contador: Contador,
    incrementar: () -> Unit,
    decrementar: () -> Unit,
    onClose: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Card(
            Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.secondary,
            elevation = 8.dp
        ) {
            Text(text = contador.nombre)
            Text(text = contador.valor.toString())
            Column() {
                Button(onClick = { incrementar }) {
                    Text(text = "^")
                }
                Button(onClick = { decrementar }) {
                    Text(text = "v")
                }
            }
            IconButton(onClick = onClose) {
                Icon(Icons.Filled.Close, contentDescription = stringResource(R.string.cerrar))
            }
        }

    }
}