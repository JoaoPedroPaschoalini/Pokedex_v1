## Pokédex Android App (Protótipo Local)

Um aplicativo Android simples e intuitivo desenvolvido para funcionar como uma Pokédex. O projeto foi construído utilizando Kotlin e Layouts em XML,
funcionando para listagem e visualização de detalhes dos Pokémon.


## Objetivo do Aplicativo

O objetivo principal deste projeto é demonstrar a arquitetura básica de uma Pokédex no ecossistema Android Nativo sem a dependência inicial de APIs externas. 

* Principais Recursos:
- **Lista Principais de Pokémon:** Exibição dos Pokémon cadastrados através de um "RecyclerView".
- **Visualização de Detalhes:** Navegação para uma tela dedicada ("DetailActivity") ao clicar em qualquer card.
- **Cadeia de Evolução Visual:** Exibição horizontal das formas de evolução com fotos, nomes e requisitos de evolução.
- **Lista de Ataques:** Exibição dos movimentos e ataques que o Pokémon pode aprender.
- **Execução Offline:** Todos os dados e imagens estão armazenados localmente ("Mocks" e pasta "drawable"), dispensando conexão com a internet.


## Como Rodar o Projeto Localmente

Siga o passo a passo abaixo para baixar ou clonar e executar o aplicativo na sua máquina:

## Pré-requisitos
- **Android Studio** instalado (versão Hedgehog ou superior).
- **JDK 17** ou superior configurado.
- Um emulador Android configurado no Android Studio ou um dispositivo físico com a Depuração USB ativada.

## Passo a Passo

## Opção A: Baixando o arquivo ZIP

1. No topo desta página do GitHub, clique no botão verde "< > Code" e depois em "Download ZIP".
2. Extraia o arquivo ".zip" baixado em uma pasta do seu computador.
3. Abra o Android Studio.
4. Clique em *Open* (ou *File > Open*) e selecione a pasta que você acabou de extrair.
5. Caso não consiga rodar o aplicativo ou caso os gradles não tenham dado sync pode ser que tenha selecionado a pasta anterior a pasta que contém as configurações do projeto
6. nesse caso feche o projeto e abra a pasta que contenha o arquivo build.gradle o android studio precisa enxergar o arquivo build.gradle (ou build.gradle.kts) na pasta selecionada para reconhecer que é um projeto Android


## Opção B: Clonando via Git terminal
   ```bash
   git clone (https://github.com/JoaoPedroPaschoalini/Pokedex_v1.git)
