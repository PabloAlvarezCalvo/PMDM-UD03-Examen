package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ContadoresLazyList(
    list: List<Contador>,
    incrementar: (Contador) -> Unit,
    decrementar: (Contador) -> Unit
    onRemoveItem: (Contador) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(items = list) { contador ->
            ContadoresList(
                contadorText = contador.nombre,
                incrementar = { incrementar(contador)},
                decrementar = { decrementar(contador) },
                onClose = { onRemoveItem(contador) }
            )
        }

    }
}

@Composable
fun ContadoresList(
    contadorText: String,
    incrementar: () -> Unit,
    decrementar: () -> Unit,
    onClose: () -> Unit
) {

}