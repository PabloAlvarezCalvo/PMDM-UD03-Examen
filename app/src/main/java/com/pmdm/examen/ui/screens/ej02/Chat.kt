package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun Chat(messages: List<DataMessages>){
    LazyColumn{
        items(messages) {message ->
            MessageCard(message)
        }
    }
}