package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pmdm.examen.R

@Composable
fun ContadoresListItem(
    contador: Contador,
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
            Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = contador.nombre)
                Text(text = contador.valor.toString())
                Column() {
                    Button(onClick = { contador.incrementar(1) }) {
                        Text(text = "^")
                    }
                    Button(onClick = { contador.decrementar(1) }) {
                        Text(text = "v")
                    }
                }
                IconButton(onClick = onClose) {
                    Icon(Icons.Filled.Close, contentDescription = stringResource(R.string.cerrar))
                }
            }
        }

    }
}