package com.pmdm.examen.ui.screens.ej01

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.pmdm.examen.R
import com.pmdm.examen.ui.screens.ej02.Contador
import com.pmdm.examen.ui.screens.ej02.ListaContadoresViewmodel

@Composable
@Preview
fun Ej01Screen() {
    var mostrarContadores by rememberSaveable { mutableStateOf(false) }
    var numeroContadores by rememberSaveable { mutableStateOf(0) }

    val focusManager = LocalFocusManager.current

    val onMostrarClick: (Int) -> Unit = {
        numeroContadores = it;
        mostrarContadores = true;
        focusManager.clearFocus();
    }


    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        topBar = {TopAppBar(
                title = { Text(text = "Contadores") },
            actions = {
                if (mostrarContadores) {
                    Button(onClick = { numeroContadores = 0; mostrarContadores = false; }) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_revert),
                            contentDescription = stringResource(R.string.reiniciarContadores)
                        )
                    }
                }
            }
            )},
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (mostrarContadores) {
                    PantallaContadores(numeroContadores)
                } else {
                    DefinirContadores(onMostrarClick, Modifier)
                }
            }
        }
    )
}


