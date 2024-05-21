# Gestão de Projetos - README
Este projeto consiste em um sistema de gestão de projetos, com frontend desenvolvido em Vue.js e backend em Spring Boot. Abaixo, você encontrará detalhes sobre a estrutura do projeto, suas funcionalidades, configuração e como executar localmente.

<details>
  <summary><b>Estrutura do Projeto</b></summary>
  <ul>
    <li>
      <details>
        <summary><b>Frontend</b></summary>
        <ul>
          <li><code>public</code></li>
          <li><code>src</code></li>
          <li>
            <details>
              <summary><b>components</b></summary>
              <ul>
                <li><code>AlterarDados.vue</code></li>
                <li><code>AtividadeForm.vue</code></li>
                <li><code>AtividadeList.vue</code></li>
                <li><code>AtualizacaoModal.vue</code></li>
                <li><code>ClienteForm.vue</code></li>
                <li><code>ClienteList.vue</code></li>
                <li><code>ProjetoForm.vue</code></li>
                <li><code>ProjetoList.vue</code></li>
              </ul>
            </details>
          </li>
          <li><code>router</code></li>
          <li><code>services</code></li>
          <li><code>views</code></li>
          <li><code>App.vue</code></li>
          <li><code>main.js</code></li>
          <!-- ... -->
        </ul>
      </details>
    </li>
    <li>
      <details>
        <summary><b>Backend</b></summary>
        <ul>
          <li>
            <details>
              <summary><b>controllers</b></summary>
              <ul>
                <li><code>AtividadeController.java</code></li>
                <li><code>ClienteController.java</code></li>
                <li><code>ProjetoController.java</code></li>
              </ul>
            </details>
          </li>
          <li>
            <details>
              <summary><b>DTO</b></summary>
              <ul>
                <li><code>AtividadeDTO.java</code></li>
                <li><code>ClienteDTO.java</code></li>
                <li><code>ProjetoDTO.java</code></li>
              </ul>
            </details>
          </li>
          <li>
            <details>
              <summary><b>enumeration</b></summary>
              <ul>
                <li><code>StatusAtividade.java</code></li>
                <li><code>StatusProjeto.java</code></li>
              </ul>
            </details>
          </li>
          <li>
            <details>
              <summary><b>exceptions</b></summary>
              <ul>
                <li><code>GlobalExceptionHandler.java</code></li>
                <li><code>ResourceNotFoundException.java</code></li>
              </ul>
            </details>
          </li>
          <li>
            <details>
              <summary><b>models</b></summary>
              <ul>
                <li><code>Atividade.java</code></li>
                <li><code>Cliente.java</code></li>
                <li><code>Projeto.java</code></li>
              </ul>
            </details>
          </li>
          <li>
            <details>
              <summary><b>repositories</b></summary>
              <ul>
                <li><code>AtividadeRepository.java</code></li>
                <li><code>ClienteRepository.java</code></li>
                <li><code>ProjetoRepository.java</code></li>
              </ul>
            </details>
          </li>
          <li>
            <details>
              <summary><b>service</b></summary>
              <ul>
                <li><code>AtividadeService.java</code></li>
                <li><code>ClienteService.java</code></li>
                <li><code>ProjetoService.java</code></li>
              </ul>
            </details>
          </li>
          <li><code>GestaoProjetosApplication.java</code></li>
        </ul>
      </details>
    </li>
    <li><code>.idea</code></li>
    <li><code>.mvn</code></li>
    <li><code>Interface</code></li>
    <li><code>node_modules</code></li>
    <li><code>test</code></li>
    <li><code>target</code></li>
    <li><code>.gitignore</code></li>
    <li><code>HELP.md</code></li>
    <li><code>mvnw</code></li>
    <li><code>mvnw.cmd</code></li>
    <li><code>package.json</code></li>
    <li><code>package-lock.json</code></li>
    <li><code>pom.xml</code></li>
    <li><code>vue.config.js</code></li>
  </ul>
</details>

## Funcionalidades

O sistema oferece diversas funcionalidades tanto no frontend quanto no backend. Abaixo estão as principais:

## Frontend (Vue.js)

1. Cadastro e Edição de Atividades e Projetos
O frontend permite cadastrar e editar informações sobre atividades e projetos, incluindo título, descrição, status e datas de início e fim.

2. Listagem de Atividades e Projetos
Exibe uma lista de atividades e projetos cadastrados no sistema, com opções de filtragem e ordenação.

3. Visualização Detalhada
Permite visualizar detalhes completos de uma atividade ou projeto específico.

## Backend (Spring Boot)
O backend fornece endpoints RESTful para interação com o banco de dados e outras funcionalidades.

## Configurações
Requisitos do Ambiente
Java 17 instalado.
Node.js e npm instalados para o ambiente de frontend.
PostgreSQL instalado e configurado.
Maven instalado para o ambiente de backend.
Configuração do Ambiente de Desenvolvimento
Clone o repositório do projeto do GitHub:

`git clone https://github.com/pablohsk/gestao_projetos`

## Configuração do frontend:

`cd gestao_projetos
cd Interface
npm install`

## Configuração do backend:

`cd gestao_projetos
mvn clean install`

## Configure o banco de dados PostgreSQL:

Abra o arquivo application.properties em src/main/resources.
Verifique as configurações em `spring.datasource` e ajuste conforme necessário, incluindo o nome do banco de dados, usuário e senha.

Certifique-se de que o PostgreSQL esteja em execução e acessível.

## Execução do Servidor

Para iniciar o servidor Spring Boot, execute:

`cd gestao_projetos
mvn spring-boot:run`

## Para iniciar o servidor de desenvolvimento do Vue.js, execute:

`cd seu-projeto/Interface
npm run serve`

## Endpoints

A seguir estão os endpoints disponíveis neste projeto:

Listar todas as atividades

`Método: GET
URL: /atividade
Descrição: Retorna uma lista de todas as atividades cadastradas.
Buscar atividade por ID`

`Método: GET
URL: /atividade/{id}
Descrição: Retorna os detalhes de uma atividade com base no ID fornecido.
Incluir atividade`

`Método: POST
URL: /atividade
Descrição: Adiciona uma nova atividade ao banco de dados.
Atualizar atividade por ID`

`Método: PUT
URL: /atividade/{id}
Descrição: Atualiza os dados de uma atividade com base no ID fornecido.
Excluir atividade por ID`

`Método: DELETE
URL: /atividade/{id}
Descrição: Remove uma atividade do banco de dados com o ID fornecido.
Listar todos os projetos`

`Método: GET
URL: /projeto
Descrição: Retorna uma lista de todos os projetos cadastrados.
Buscar projeto por ID`

`Método: GET
URL: /projeto/{id}
Descrição: Retorna os detalhes de um projeto com base no ID fornecido.
Incluir projeto`

`Método: POST
URL: /projeto
Descrição: Adiciona um novo projeto ao banco de dados.
Atualizar projeto por ID`

`Método: PUT
URL: /projeto/{id}
Descrição: Atualiza os dados de um projeto com base no ID fornecido.
Excluir projeto por ID`

`Método: DELETE
URL: /projeto/{id}
Descrição: Remove um projeto do banco de dados com o ID fornecido.`

## Diagrama de Classes

    class Projeto {
        +Long id
        +String nome
        +String descricao
        +StatusProjeto status
        +LocalDate dataInicio
        +LocalDate dataFim
    }

    class Atividade {
        +Long id
        +String nome
        +String descricao
        +StatusAtividade status
        +LocalDate dataInicio
        +LocalDate dataFim
        +Projeto projeto
    }

    class Cliente {
        +Long id
        +String nome
        +String email
    }

    class ProjetoDTO {
        +Long id
        +String nome
        +String descricao
        +StatusProjeto status
        +LocalDate dataInicio
        +LocalDate dataFim
    }

    class AtividadeDTO {
        +Long id
        +String nome
        +String descricao
        +StatusAtividade status
        +LocalDate dataInicio
        +LocalDate dataFim
        +Long projetoId
    }

    class ClienteDTO {
        +Long id
        +String nome
        +String email
    }

    class ProjetoController {
        +List~ProjetoDTO~ getAllProjetos()
        +ProjetoDTO getProjeto(Long id)
        +ProjetoDTO createProjeto(ProjetoDTO projetoDTO)
        +ProjetoDTO updateProjeto(Long id, ProjetoDTO projetoDTO)
        +void deleteProjeto(Long id)
        +List~Projeto~ getProjetosAtivos()
    }

    class AtividadeController {
        +List~AtividadeDTO~ getAllAtividades()
        +AtividadeDTO getAtividade(Long id)
        +AtividadeDTO createAtividade(AtividadeDTO atividadeDTO)
        +AtividadeDTO updateAtividade(Long id, AtividadeDTO atividadeDTO)
        +void deleteAtividade(Long id)
    }

    class ClienteController {
        +List~ClienteDTO~ getAllClientes()
        +ClienteDTO getCliente(Long id)
        +ClienteDTO createCliente(ClienteDTO clienteDTO)
        +ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO)
        +void deleteCliente(Long id)
    }

    class ProjetoService {
        +List~Projeto~ findAll()
        +Projeto findById(Long id)
        +Projeto save(Projeto projeto)
        +void deleteById(Long id)
        +List~Projeto~ findByStatusNotConcluida()
    }

    class AtividadeService {
        +List~Atividade~ findAll()
        +Atividade findById(Long id)
        +Atividade save(Atividade atividade)
        +void deleteById(Long id)
    }

    class ClienteService {
        +List~Cliente~ findAll()
        +Cliente findById(Long id)
        +Cliente save(Cliente cliente)
        +void deleteById(Long id)
    }

    class ProjetoRepository {
        +List~Projeto~ findAll()
        +Optional~Projeto~ findById(Long id)
        +Projeto save(Projeto projeto)
        +void deleteById(Long id)
        +List~Projeto~ findByStatusNot(StatusProjeto status)
    }

    class AtividadeRepository {
        +List~Atividade~ findAll()
        +Optional~Atividade~ findById(Long id)
        +Atividade save(Atividade atividade)
        +void deleteById(Long id)
    }

    class ClienteRepository {
        +List~Cliente~ findAll()
        +Optional~Cliente~ findById(Long id)
        +Cliente save(Cliente cliente)
        +void deleteById(Long id)
    }

    Projeto --> ProjetoDTO
    Projeto --> Atividade : contém
    Atividade --> AtividadeDTO
    Cliente --> ClienteDTO

    ProjetoController --> ProjetoService
    AtividadeController --> AtividadeService
    ClienteController --> ClienteService

    ProjetoService --> ProjetoRepository
    AtividadeService --> AtividadeRepository
    ClienteService --> ClienteRepository

    StatusProjeto : +CONCLUIDA
    StatusProjeto : +EM_PROGRESSO
    StatusProjeto : +PENDENTE

    StatusAtividade : +CONCLUIDA
    StatusAtividade : +EM_PROGRESSO
    StatusAtividade : +PENDENTE


## Desenvolvedor

Este projeto foi desenvolvido por Pablo Fidelis Dias. Para mais detalhes, consulte o link: [[link do repositório no GitHub]](https://github.com/pablohsk/gestao_projetos).

Qualquer dúvida ou sugestão, sinta-se à vontade para entrar em contato. Obrigado por utilizar o Gestão de Projetos!

*/ Me Contrata /*
