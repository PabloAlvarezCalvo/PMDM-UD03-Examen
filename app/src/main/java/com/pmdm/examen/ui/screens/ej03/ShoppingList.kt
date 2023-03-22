package com.pmdm.examen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pmdm.examen.ui.screens.ej03.Product

@Composable
fun ShoppingList(
    productList: List<Product>,
    onCheckedChange: (Product) -> Unit,
    onDelete: (Product) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier) {
        items(
            items = productList
        ) { element ->
            ShoppingListItem(
                elementName = element.name,
                checked = element.checked,
                onCheckedChange = {onCheckedChange(element)},
                onDeleteClick = {
                    onDelete(element)
                },
                modifier = modifier
            )
        }
    }
}