package com.pmdm.examen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Product(var id : Int, val name : String, var initialChecked: Boolean = false){
    var checked by mutableStateOf(initialChecked)
}

fun generarListaProductos() = List(10) { i -> Product(i, "Producto $i")}