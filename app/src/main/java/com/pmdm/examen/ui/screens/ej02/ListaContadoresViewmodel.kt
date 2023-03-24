package com.pmdm.examen.ui.screens.ej02

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ListaContadoresViewmodel : ViewModel() {
    private val _listaContadores = mutableStateListOf<Contador>()
    val listaContadores get() = _listaContadores

    private fun addContador(contador : Contador) =
        listaContadores.add(contador)

    fun removeContador(contador: Contador) {
        listaContadores.remove(contador)
    }
}