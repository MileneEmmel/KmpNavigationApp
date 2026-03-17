# Aula 03 - Navegação em Aplicações Multiplataforma

## Questão Teórica: Multi-Activity vs Single Activity em Contexto Multiplataforma

Durante o desenvolvimento desta atividade, ficou evidente uma diferença fundamental entre o modelo tradicional de Multi-Activity do Android nativo e o modelo Single Activity aplicado ao contexto multiplataforma. No Android tradicional, cada tela é uma Activity separada, cada uma com seu próprio ciclo de vida gerenciado pelo sistema operacional. A navegação acontece através de Intents, e o back stack é gerenciado nativamente pelo Android. Isso significa que se você quer implementar a mesma aplicação em iOS, precisa reescrever toda a lógica usando ViewControllers e outro padrão de navegação completamente diferente. Você está, basicamente, desenvolvendo duas aplicações.

Em contraste, o modelo Single Activity usado nesta atividade com Compose Multiplatform funciona de forma completamente diferente. Existe apenas uma Activity que serve como container, e toda a navegação é gerenciada por um NavHost e NavController. As telas são funções Composables que recebem callbacks para navegação. O grande diferencial é que esse código é compartilhado entre Android e iOS através do Kotlin Multiplatform. A mesma função DeviceListScreen funciona em ambas as plataformas sem modificações, a mesma navegação com NavHost/NavController funciona em iOS e Android.

Isso impacta enormemente o reaproveitamento de código. No modelo tradicional de Multi-Activity, você está condenado a duplicar praticamente toda a lógica de apresentação: uma vez em Kotlin/Android com Activities e uma vez em Swift/iOS com ViewControllers. Se precisa consertar um bug na lógica de listagem, precisa fazer em dois lugares, em duas linguagens diferentes. No modelo Single Activity multiplataforma, você escreve a tela uma única vez em Kotlin, em um arquivo na pasta commonMain, e funciona em ambas as plataformas. Corrigir um bug significa mexer em um lugar, uma linguagem, uma versão do código.

Nesta atividade especificamente, quase todo o código está em commonMain: DeviceListScreen.kt, DeviceDetailScreen.kt, Navigation.kt com o NavHost. O reaproveitamento é praticamente 100% entre Android e iOS. Você não vai reimplementar essas telas em Swift. A única coisa específica de plataforma seria detalhes muito pontuais, e mesmo assim mínimos. Esse é o ganho real do Single Activity com Compose Multiplatform: você não duplica código de apresentação entre plataformas. Escreve uma vez, usa em duas. Mantém uma vez, não duas. Isso reduz significativamente o tempo de desenvolvimento e o risco de inconsistências entre as versões de cada plataforma.



