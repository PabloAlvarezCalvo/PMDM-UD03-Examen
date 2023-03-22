package com.pmdm.examen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreenLista() {
    val shoppingListViewModel : ShoppingListViewModel = viewModel()

    Scaffold(
        topBar = { TopAppBar(title = { Text( "Shopping list") }) },
    ) {
        paddingValues ->

        ShoppingList(
            productList = shoppingListViewModel.list,
            onCheckedChange = {shoppingListViewModel.changeProductChecked(it)},
            onDelete = {shoppingListViewModel.remove(it)},
            modifier = Modifier.padding(paddingValues)
        )
    }
}