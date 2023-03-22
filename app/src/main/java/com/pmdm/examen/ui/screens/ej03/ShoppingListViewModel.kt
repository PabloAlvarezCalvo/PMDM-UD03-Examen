package com.pmdm.examen.ui.screens.ej03

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class ShoppingListViewModel : ViewModel() {
    //private val _shoppingList = mutableListOf<Product>() //Inicialización vacía
    private val _list = generarListaProductos().toMutableStateList() //Inicialización desde la lista demo
    val list get() = _list

    fun remove(item : Product){
        _list.remove(item)
    }

    fun changeProductChecked(item : Product){
        item.checked = !item.checked
    }
}