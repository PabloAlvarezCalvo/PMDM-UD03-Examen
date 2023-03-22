package com.pmdm.examen.ui.screens.ej02

import androidx.compose.runtime.Composable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DataMessages(val author: String, val text: String, val timestamp: LocalDateTime, var pointedCorner : Boolean)


val formatter: DateTimeFormatter =
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")


val messages: List<DataMessages> = listOf(
    DataMessages("Person 1",
        "Hola, ¿has oído hablar de la programación reactiva en Android",
        LocalDateTime.parse("07/02/2023 16:00", formatter),
        false),

    DataMessages("Self",
        "No, no he oído hablar de eso. ¿Puedes explicármelo?",
        LocalDateTime.parse("07/02/2023 16:05", formatter),
        false),

    DataMessages("Person 1",
        "Claro, es un paradigma de programación que se centra en manejar flujos de datos y eventos asíncronos." +
                " Fue introducido por primera vez en Android con la aparición de la biblioteca RxJava en 2013 por Netflix.",
        LocalDateTime.parse("07/02/2023 16:10", formatter),
        false),

    DataMessages("Self",
        "Entiendo, entonces es una forma de manejar tareas asíncronas de manera más eficiente.",
        LocalDateTime.parse("07/02/2023 16:12", formatter),
        false),

    DataMessages("Person 1",
        "Exacto, se utiliza para manejar tareas como peticiones de red, operaciones de base de datos y entrada " +
                "de usuario de una forma más eficiente y mantenible. En resumen, permite manejar de manera sencilla los " +
                "cambios de estado y eventos en una aplicación, lo que ayuda a evitar problemas de sincronización de estado " +
                "y aumenta la estabilidad y rendimiento del sistema",
        LocalDateTime.parse("07/02/2023 16:18", formatter),
        false),

    DataMessages("Person 1",
        "Compose se basea en la programación reactiva, permitiendo a los desarrolladores declarar cómo debe ser " +
                "su interfaz de usuario en función del estado y los eventos. Esto ayuda a crear un código más legible, mantenible y fácil de probar.",
        LocalDateTime.parse("07/02/2023 16:24", formatter),
        false),

    DataMessages("Self",
        "Eso es realmente interesante. Definitivamente investigaré más sobre ello. ¡Gracias por explicármelo!",
        LocalDateTime.parse("07/02/2023 16:30", formatter),
        false)
)

@Composable
fun ModifyPointedCorner(messages: DataMessages, lastAuthor: String){

}