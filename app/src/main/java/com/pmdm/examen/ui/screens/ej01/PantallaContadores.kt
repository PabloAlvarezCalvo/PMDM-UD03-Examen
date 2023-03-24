package com.pmdm.examen.ui.screens.ej01

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmdm.examen.ui.screens.ej02.ListaContadoresViewmodel

@Composable
fun PantallaContadores(
    cantidadContadores: Int,
) {
    val viewModel: ListaContadoresViewmodel = viewModel()
    //Por algún motivo si uso el clear para intentar regenerar la lista tras reinicio, pierdo
    //la posibilidad de modificar los contadores
    //viewModel.listaContadores.clear()
    for (i in 1..cantidadContadores) {
        viewModel.addContador("$i")
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = viewModel.listaContadores) { contador ->
            BloqueContador(contador)
        }
    }

}