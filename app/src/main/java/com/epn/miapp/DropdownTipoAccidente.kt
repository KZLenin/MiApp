package com.epn.miapp

import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun DropdownTipoAccidente(
    seleccionado: String,
    onSeleccionar: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val opciones = listOf("Choque", "Colisión", "Atropello")

    OutlinedButton(onClick = { expanded = true }) {
        Text(seleccionado)
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        opciones.forEach {
            DropdownMenuItem(
                text = { Text(it) },
                onClick = {
                    onSeleccionar(it)
                    expanded = false
                }
            )
        }
    }
}
