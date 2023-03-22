package com.pmdm.examen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShoppingListItem(
    elementName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(10.dp, 10.dp, 10.dp, 5.dp), backgroundColor = MaterialTheme.colors.secondary) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 0.dp, 20.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(modifier = Modifier
                .fillMaxSize()
                .weight(8f),
                text = elementName,
                fontSize = 20.sp)
            Row(modifier = Modifier
                .fillMaxSize()
                .weight(2f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = checked, onCheckedChange = onCheckedChange )
                IconButton(onClick = onDeleteClick ) {
                    Icon(Icons.Filled.Close, contentDescription = "Close")
                }
            }
        }
    }
}