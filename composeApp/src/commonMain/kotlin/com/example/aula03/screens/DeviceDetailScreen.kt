package com.example.aula03.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeviceDetailScreen(deviceName: String, onBackClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
            .safeContentPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Detalhes do Dispositivo",
                fontSize = 18.sp,
                color = Color(0xFF333333),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5E6F0), RoundedCornerShape(12.dp))
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = deviceName, fontSize = 20.sp, color = Color(0xFF333333))
            }

            Spacer(modifier = Modifier.height(24.dp))

            InfoCard("Modelo", deviceName)
            InfoCard("Status", "Ativo")
            InfoCard("Última sincronização", "Hoje")
        }

        Button(
            onClick = onBackClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5E6F0)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Voltar", color = Color(0xFF333333))
        }
    }
}

@Composable
private fun InfoCard(label: String, value: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Column {
            Text(text = label, fontSize = 12.sp, color = Color(0xFF999999))
            Text(text = value, fontSize = 14.sp, color = Color(0xFF333333))
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}




