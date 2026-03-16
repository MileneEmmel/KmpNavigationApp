package com.example.aula03.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.aula03.screens.DeviceDetailScreen
import com.example.aula03.screens.DeviceListScreen

/**
 * Define as rotas da navegação da aplicação
 */
sealed class NavigationRoute {
    object DeviceList : NavigationRoute()
    data class DeviceDetail(val deviceName: String) : NavigationRoute()
}

/**
 * Composable principal que gerencia a navegação centralizada
 * Contém todas as rotas e telas da aplicação
 * Usa State para gerenciar navegação de forma compatível com multiplatform
 */
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val currentRoute = remember { mutableStateOf<NavigationRoute>(NavigationRoute.DeviceList) }

    when (val route = currentRoute.value) {
        // Tela de Listagem de Dispositivos
        NavigationRoute.DeviceList -> {
            DeviceListScreen(
                onDeviceClick = { deviceName ->
                    currentRoute.value = NavigationRoute.DeviceDetail(deviceName)
                },
                modifier = modifier
            )
        }

        // Tela de Detalhes do Dispositivo
        is NavigationRoute.DeviceDetail -> {
            DeviceDetailScreen(
                deviceName = route.deviceName,
                onBackClick = {
                    currentRoute.value = NavigationRoute.DeviceList
                },
                modifier = modifier
            )
        }
    }
}



