package com.pmdm.examen.ui.screens.ej02

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class ListaContadoresViewmodel : ViewModel() {
    //private val _listaContadores = mutableStateListOf<Contador>()
    private val _listaContadores = generarListaContadores().toMutableStateList()
    val listaContadores get() = _listaContadores

    fun addContador(nombre : String) =
        if(listaContadores.none{nombre == it.nombre})
            listaContadores.add(Contador(nombre))
        else false

    fun removeContador(contador: Contador) {
        listaContadores.remove(contador)
    }

    fun incrementarContador(contador : Contador, incremento : Int){
        contador.incrementar(incremento)
    }

    fun decrementarContador(contador : Contador, decremento : Int){
        contador.decrementar(decremento)
    }
}