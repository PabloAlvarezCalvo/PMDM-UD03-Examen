package com.pmdm.examen.ui.screens.ej01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmdm.examen.R
import com.pmdm.examen.ui.screens.ej02.Contador

@Composable
fun BloqueContador(
    contador: Contador

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp, 5.dp, 5.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { contador.incrementar(1) },
        ) {
            Text(text = stringResource(R.string.incrementar))
        }
        Text(text = "${contador.valor}", fontSize = 30.sp)
        Button(
            onClick = { contador.decrementar(1) },
            enabled = contador.valor > 0
        ) {
            Text(text = stringResource(R.string.decrementar))
        }
    }
}