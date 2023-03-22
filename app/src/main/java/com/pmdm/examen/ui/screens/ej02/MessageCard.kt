package com.pmdm.examen.ui.screens.ej02

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.format.DateTimeFormatter

@Composable
fun MessageCard(message: DataMessages){
    /* TODO Mensajes con custom shape
     *  https://gist.github.com/SylpheM/1da000b0044ff5c60d8537e5f26d7f2d
     */
    var visible by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 10.dp, 20.dp, 10.dp),
        horizontalArrangement = if (message.author == "Self") {
            Arrangement.End} else {
            Arrangement.Start},
    ) {
        Card(
            modifier = Modifier.width((LocalConfiguration.current.screenWidthDp * 0.8).dp).clickable { visible = !visible },
            shape = if (message.author == "Self") {
                RoundedCornerShape(10.dp, 10.dp, 0.dp, 10.dp)
            } else {
                RoundedCornerShape(10.dp, 10.dp, 10.dp, 0.dp)
            },
            backgroundColor = if (message.author == "Self") { MaterialTheme.colors.primary } else { MaterialTheme.colors.secondary},
            contentColor = if (message.author == "Self") { MaterialTheme.colors.onPrimary } else { MaterialTheme.colors.onSecondary},
        ) {
            Column(modifier = Modifier,
                //horizontalAlignment = Alignment.End)
            ){
                Text(modifier = Modifier.padding(10.dp), text = message.text)
                if(visible){
                    Text(
                        modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 5.dp).fillMaxWidth(),
                        text = message.timestamp.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}