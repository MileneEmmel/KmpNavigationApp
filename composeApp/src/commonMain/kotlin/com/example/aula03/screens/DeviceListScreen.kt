package com.example.aula03.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Tela que exibe uma lista de dispositivos
 * Ao clicar em um dispositivo, navega para a tela de detalhes
 */
@Composable
fun DeviceListScreen(
    onDeviceClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Lista de dispositivos de exemplo
    val devices = listOf(
        "iPhone 15",
        "Galaxy S24",
        "Pixel 8",
        "OnePlus 12",
        "Xiaomi 14",
        "Samsung Galaxy A55"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .safeContentPadding()
            .padding(16.dp)
    ) {
        // Título
        Text(
            text = "Dispositivos",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp),
            color = MaterialTheme.colorScheme.onBackground
        )

        // Lista de dispositivos
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(devices) { device ->
                DeviceListItem(
                    deviceName = device,
                    onClick = { onDeviceClick(device) }
                )
            }
        }
    }
}

/**
 * Composable que representa um item individual da lista de dispositivos
 */
@Composable
private fun DeviceListItem(
    deviceName: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = onClick)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = deviceName,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Preview
@Composable
fun DeviceListScreenPreview() {
    MaterialTheme {
        DeviceListScreen(onDeviceClick = {})
    }
}



