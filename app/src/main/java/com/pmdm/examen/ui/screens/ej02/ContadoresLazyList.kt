package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ContadoresLazyList(
    list: List<Contador>,
    onRemoveItem: (Contador) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(items = list) { contador ->
            ContadoresListItem(
                contador = contador,
                onClose = { onRemoveItem(contador) }
            )
        }

    }
}