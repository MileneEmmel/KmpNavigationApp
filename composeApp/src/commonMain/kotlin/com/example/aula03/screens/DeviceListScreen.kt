package com.example.aula03.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeviceListScreen(onDeviceClick: (String) -> Unit, modifier: Modifier = Modifier) {
    val devices = listOf(
        "iPhone 15", "Galaxy S24", "Pixel 8",
        "OnePlus 12", "Xiaomi 14", "Samsung Galaxy A55"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
            .safeContentPadding()
            .padding(16.dp)
    ) {
        Text(
            text = "Dispositivos",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally),
            color = Color(0xFF333333)
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(devices) { device ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5E6F0), RoundedCornerShape(8.dp))
                        .clickable { onDeviceClick(device) }
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = device, fontSize = 15.sp, color = Color(0xFF333333))
                }
            }
        }
    }
}



