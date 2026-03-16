## Fluxo de Navegação Centralizado - Aula 03

### 📋 Resumo da Implementação

Foi implementado um **fluxo de navegação centralizado** no módulo `commonMain` (multiplatform) contendo:

### 🎯 Componentes Principais

#### 1. **Navigation.kt** (`com.example.aula03.navigation`)
- **NavigationRoute**: Sealed class que define as rotas da aplicação
  - `DeviceList`: Tela de listagem
  - `DeviceDetail(deviceName)`: Tela de detalhes com parâmetro de dispositivo

- **AppNavigation()**: Composable principal que gerencia toda a navegação centralizada
  - Usa `mutableStateOf` para gerenciar o estado da navegação
  - Compatível com multiplatform (sem dependências Android-only)
  - Implementa lógica de transição entre telas

#### 2. **DeviceListScreen.kt** (`com.example.aula03.screens`)
- Exibe uma lista de dispositivos (iPhone 15, Galaxy S24, Pixel 8, etc.)
- Cada item é um `DeviceListItem` clicável
- Ao clicar, navega para a tela de detalhes passando o nome do dispositivo

#### 3. **DeviceDetailScreen.kt** (`com.example.aula03.screens`)
- Recebe o nome do dispositivo via parâmetro da rota
- Exibe o nome do dispositivo em destaque
- Mostra informações adicionais (modelo, status, última sincronização)
- Botão "Voltar" que retorna à tela de listagem

#### 4. **App.kt** (Atualizado)
- Agora usa `AppNavigation()` como ponto de entrada
- Simplificado para apenas envolver a navegação no `MaterialTheme`

### 🏗️ Arquitetura

```
commonMain/
├── kotlin/
│   └── com/example/aula03/
│       ├── App.kt (atualizado)
│       ├── navigation/
│       │   └── Navigation.kt (novo)
│       └── screens/
│           ├── DeviceListScreen.kt (novo)
│           └── DeviceDetailScreen.kt (novo)
```

### 🔄 Fluxo de Navegação

```
App() 
  ↓
MaterialTheme
  ↓
AppNavigation()
  ├─→ [DeviceList Route]
  │      ↓
  │      DeviceListScreen
  │      └─→ Click on device
  │         └─→ Update currentRoute
  │
  └─→ [DeviceDetail Route]
         ↓
         DeviceDetailScreen
         └─→ Click "Voltar"
            └─→ Update currentRoute back to DeviceList
```

### ✨ Recursos

✅ **Navegação centralizada** em um único arquivo (`Navigation.kt`)
✅ **Compatível com multiplatform** - sem dependências Android-only
✅ **Rotas tipadas** - uso de sealed classes para type-safety
✅ **Estado gerenciado localmente** - usando `mutableStateOf` do Compose
✅ **Transição entre telas** - passagem de parâmetros via rotas
✅ **UI responsiva** - Material Design 3 com tema integrado

### 🚀 Como Usar

1. Clonar/abrir o projeto
2. Compilar o projeto (Gradle sync)
3. Executar em Android, iOS ou Desktop (conforme configurado)
4. A tela de listagem será exibida automaticamente
5. Clicar em um dispositivo para ver os detalhes
6. Usar "Voltar" para retornar à listagem

### 📱 Dispositivos Disponíveis na Lista

- iPhone 15
- Galaxy S24
- Pixel 8
- OnePlus 12
- Xiaomi 14
- Samsung Galaxy A55

### 🔧 Tecnologias Utilizadas

- **Kotlin Multiplatform** - Compartilhamento de código entre plataformas
- **Jetpack Compose** - UI declarativa
- **Material Design 3** - Design system moderno
- **State Management** - Estado local com `remember` e `mutableStateOf`

---

**Desenvolvido com ❤️ para Aula 03**

