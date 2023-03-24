package com.pmdm.examen.ui.screens.ej02

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Contador(val nombre : String) {
    var valor by mutableStateOf(0)
}