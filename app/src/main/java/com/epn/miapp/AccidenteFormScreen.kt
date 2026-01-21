package com.epn.miapp

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AccidenteFormScreen() {
    val context = LocalContext.current

    var tipoAccidente by remember { mutableStateOf("Choque") }
    var matricula by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var cedula by remember { mutableStateOf("") }
    var observaciones by remember { mutableStateOf("") }

    val fecha = remember {
        SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Registro de Accidente", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        Text("Tipo de Accidente")
        DropdownTipoAccidente(tipoAccidente) { tipoAccidente = it }

        Spacer(Modifier.height(8.dp))
        Text("Fecha: $fecha")

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = matricula,
            onValueChange = { matricula = it },
            label = { Text("Matrícula del vehículo") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del conductor") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cedula,
            onValueChange = { cedula = it },
            label = { Text("Cédula del conductor") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = observaciones,
            onValueChange = { observaciones = it },
            label = { Text("Observaciones") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                context.startActivity(
                    android.content.Intent(context, CameraActivity::class.java)
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Tomar Fotografía 📷")
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                context.startActivity(
                    android.content.Intent(context, LocationActivity::class.java)
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Obtener Ubicación 📍")
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                vibrarTelefono(context)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Accidente 🚨")
        }
    }
}
