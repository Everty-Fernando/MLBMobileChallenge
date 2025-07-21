# MLB

Aplicativo Android para busca, visualização e detalhes de produtos, inspirado no Mercado Livre.

## ✨ Funcionalidades

- Tela de splash animada com Lottie
- Busca de produtos com integração à API
- Detalhes completos do produto
- Tratamento de loading, empty state e error state com animações

## 🏗️ Arquitetura

O projeto segue o padrão **MVVM (Model-View-ViewModel)**, promovendo separação de responsabilidades, testabilidade e escalabilidade.

- **Model:** Camada de dados, models e mapeamentos de API.
- **View:** Telas em Jetpack Compose, componentes reutilizáveis e layouts responsivos.
- **ViewModel:** Gerenciamento de estado, lógica de apresentação e integração com use cases.

Fluxo de dados:
```
View (Compose) <-> ViewModel <-> UseCase <-> Repository <-> API/Network
```

## 🛠️ Tecnologias e Frameworks

- **Kotlin** — Linguagem principal
- **Jetpack Compose** — UI declarativa e moderna
- **Koin** — Injeção de dependência
- **Retrofit + OkHttp** — Consumo de APIs REST
- **Coil** — Carregamento de imagens
- **Lottie Compose** — Animações Lottie
- **MockK** — Testes unitários com mocks
- **JUnit** — Testes unitários
- **Coroutines/Flow** — Programação assíncrona e reativa
- **Accompanist** — Utilitários para Compose (ex: status bar)
- **Modularização** — Projeto dividido em módulos: app, features, shared (network, presentation, utils)

## 📁 Estrutura de Pastas

```
MLBMobileChallenge/
  app/                # Módulo principal Android
  features/           # Funcionalidades (ex: product)
    product/
      data/           # Models, DTOs, APIs
      repository/     # Implementação dos repositórios
      domain/         # UseCases, mapeadores, entidades de domínio
      presentation/   # Telas, ViewModels, eventos, estados, componentes de UI
  shared/             # Módulos compartilhados (network, presentation, utils)
```

## 🚀 Como rodar

1. Clone o repositório
2. Abra no Android Studio
3. **Configure o seu token de acesso do Mercado Livre:**
   - No arquivo `shared/network/build.gradle`, adicione o valor do seu token em:
     ```kotlin
     buildConfigField("String", "ACCESS_TOKEN", "\"SEU_TOKEN_AQUI\"")
     ```
4. Sincronize o projeto (Sync Project with Gradle Files)
5. Configure um emulador ou dispositivo físico
6. Clique em "Run"

## 📦 Dependências principais

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Koin](https://insert-koin.io/)
- [Retrofit](https://square.github.io/retrofit/)
- [Coil](https://coil-kt.github.io/coil/)
- [Lottie Compose](https://airbnb.io/lottie/#/android-compose)
- [MockK](https://mockk.io/)
- [Accompanist](https://google.github.io/accompanist/)

## 💡 Observações

- O projeto utiliza animações Lottie para melhorar a experiência do usuário em estados de loading, erro e vazio.

## 🧪 Testes Unitários

O projeto possui cobertura de testes unitários para as principais camadas de domínio e dados:

- **Repository:**  Testes para todos os fluxos (sucesso, erro, parcial) usando MockK para simular respostas da API e logs.
- **Use Cases:**  Testes para todos os casos de uso, garantindo que os dados são corretamente mapeados e propagados.
- **Mappers:**  Testes para conversão de models de dados para models de UI, cobrindo cenários completos e campos opcionais.
- **Mocks:**  Uso de MockK para simular dependências e garantir previsibilidade dos testes.

### Como rodar os testes

No terminal, execute:
```sh
./gradlew test
```
Ou rode os testes diretamente pelo Android Studio, clicando com o botão direito na pasta `test` do módulo desejado e selecionando "Run Tests".