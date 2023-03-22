package com.pmdm.examen.ui.screens.ej03

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmdm.examen.ShoppingList

@Composable
fun Ej03Screen() {
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