# Api BakcEnd Forum Hub

<p align="center">
   <img src="https://img.shields.io/badge/ STATUS-LANÇADO (desenvolvido)-brightgreen"/>
</p>
<p align="center">
   <img src="https://img.shields.io/badge/ STATUS-VERSÃO 2.5-brightgreen"/>
</p>

> Escrito em `JAVA 17`.

&nbsp;
## Introdução

<p align="justify">

Bem-vindo à documentação da aplicação `Forum Hub`.

Uma ferramenta para gerenciamento de `fóruns`, permitindo a `criação e gerenciamento` de `usuários, tópicos e respostas`, desenvolvida por [Wesley Pereira](https://github.com/wesleyp846).

Esta aplicação foi criada no contexto da bolsa do curso da [Oracle](https://www.oracle.com/br/), [Alura](https://www.alura.com.br/) e [Ifood](https://www.ifood.com.br/), com foco em `BackEnders iniciantes`.

A aplicação é escrita `exclusivamente` em [JAVA](https://docs.oracle.com/en/java/javase/17/docs/api/), utilizando o framework [Spring Boot](https://spring.io/projects/spring-boot) e em sua versão 2.5 traz suporte `implemantação` em [Docker](https://www.docker.com/).


Para implementação direto do `DOCKER HUB`, cole em seu terminal:

      sudo docker pull wesleyp846/forum_hub:V2.5
      sudo docker run -d -p 8080:8080 wesleyp846/forum_hub:V2.5

</p>

&nbsp;
&nbsp;
## Versão Atual: 2.5
&nbsp;
Na versão 2.5, a aplicacação foi `finalizada`, `Dockerizada` e `entregue`.

&nbsp;
&nbsp;
> ### Pré-requisitos
&nbsp;
* Acesso à `WEB`.
* `Doker`
* `Java 17` instalado (opicional).
* `Intellij IDEA` instalado (opicional).
* `Maven` configurado (opicional).

&nbsp;
&nbsp;
> ### Tecnologias Utilizadas
&nbsp;

[JAVA](https://www.oracle.com/java/technologies/downloads/#java22): Usado como linguagem de programação.

[Spring Boot](https://spring.io/projects/spring-boot): Usado como framework para construção da aplicação.

[Intellij](https://www.jetbrains.com/pt-br/idea/): Usado como IDE na codificação.

[Postgresql](https://www.postgresql.org/download): Usado como banco de dados em memória para desenvolvimento.

[Docker](https://www.docker.com/): Usado na conteinerização da aplicação como um todo.

&nbsp;
&nbsp;
> ### Funcionalidades
&nbsp;


1. A aplicação permite a `criação e gerenciamento de usuários`.
2. Os `tópicos` podem ser `criados, editados, listados e deletados`.
3. As `respostas` aos tópicos podem ser `criadas, editadas, listadas e deletadas`.
4. A `autenticação` dos usuários é gerenciada por meio de `tokens JWT`.
5. Como o `Docker` instalado é possível clonar o [repositório](https://github.com/wesleyp846/ForumHub) e com comando simples via `terminal`, rodar a aplicação` 

&nbsp;
&nbsp;
> ### Endpoints da API

#### Usuario Controller

- **PUT /usuarios/{id}**
  - Atualiza um usuário específico.

- **DELETE /usuarios/{id}**
  - Deleta um usuário específico.

- **GET /usuarios**
  - Lista todos os usuários.

- **POST /usuarios**
  - Cria um novo usuário.

#### Topico Controller

- **GET /topicos/{id}**
  - Retorna detalhes de um tópico específico.

- **PUT /topicos/{id}**
  - Atualiza um tópico específico.

- **DELETE /topicos/{id}**
  - Deleta um tópico específico.

- **GET /topicos**
  - Lista todos os tópicos.

- **POST /topicos**
  - Cria um novo tópico.

#### Resposta Controller

- **PUT /respostas/{id}**
  - Atualiza uma resposta específica.

- **POST /respostas/{id}**
  - Cria uma nova resposta.

- **DELETE /respostas/{id}**
  - Deleta uma resposta específica.

- **GET /respostas**
  - Lista todas as respostas.

#### Auth Controller

- **POST /login**
  - Autentica um usuário.(`Usuario deve estar previamente cadastrado no banco de dados com e-mail e senha`)

&nbsp;
&nbsp;
> ### Modelos de Dados (Schemas)

- **DadosEdicaoDeUsuarioDto**: Dados para edição de um usuário.
- **EditarTopicoDto**: Dados para edição de um tópico.
- **RespostaEditaTopicoDTO**: Dados para edição de uma resposta.
- **EditarRespostaDto**: Dados para edição de uma resposta.
- **DadosNovoUsuarioDto**: Dados para criação de um novo usuário.
- **DadosNovoTopicoDto**: Dados para criação de um novo tópico.
- **DtoDadosNovaResposta**: Dados para criação de uma nova resposta.
- **EnvioAutenticacaoDTO**: Dados para autenticação de um usuário.
- **Pageable**: Dados para paginação.
- **ListagemDeDadosUsuariosDto**: Dados de listagem de usuários.
- **PageListagemDeDadosUsuariosDto**: Dados de paginação de listagem de usuários.
- **PageableObject**: Objeto de paginação.
- **SortObject**: Objeto de ordenação.
- **ListagemDeDadosTopicosDto**: Dados de listagem de tópicos.
- **PageListagemDeDadosTopicosDto**: Dados de paginação de listagem de tópicos.
- **UsuarioSimplesDTO**: Dados simplificados de um usuário.
- **DetalhesRespostaDTO**: Detalhes de uma resposta.
- **PageDetalhesRespostaDTO**: Dados de paginação de detalhes de respostas.

&nbsp;
&nbsp;

> ### Configuração via DOCKER

>> Clone do repositório

      git clone https://github.com/wesleyp846/ForumHub

>> Navegue até a pasta do app

      cd ForumHub

>> Compile a aplicação

      sudo docker-compose build

>> Rode a aplicação

      sudo docker-compose up

&nbsp;
&nbsp;
> ### Configuração

Para rodar este projeto, siga os passos abaixo:

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/wesleyp846/ForumHub
   cd ForumHub

Configure o banco de dados:
Atualize as configurações do banco de dados no arquivo `application.properties`.

Execute a aplicação:


      ./mvnw spring-boot:run

Acesse a documentação da API:
A documentação da API gerada pelo Swagger pode ser acessada em 

      http://localhost:8080/swagger-ui/index.html#/


#### Contribuição
Para contribuir com o projeto, siga os passos abaixo:

Fork o repositório.
Crie uma nova branch:

      git checkout -b minha-feature
      
Faça suas alterações e commit:

      git commit -m "Minha nova feature"

Envie para o repositório remoto:

      git push origin minha-feature

Abra um Pull Request.

&nbsp;
&nbsp; 

>Licença
MIT

&nbsp;
&nbsp;

> ### Créditos
Baseado em orientação da [Alura](https://www.alura.com.br/) e seus `professores`, com `live` única de lançamento do exercício.

&nbsp;

Esperamos que esta documentação ajude você a compreender a aplicação.

Fique à vontade para contribuir e adicionar melhorias ao código.

Para mais informações, visite o LinkedIn de [Wesley Pereira](https://www.linkedin.com/in/wesleyp846).

Primeiro commit na data de 29/06/2024

&nbsp;
&nbsp;

### Demonstrativos:


> Demonstração da API rodando em terminal no servidor

![Demonstração da API rodando em terminal no servidor](https://github.com/wesleyp846/ForumHub/blob/main/img/imagemDoTerminal.png)

&nbsp;
&nbsp;

> Demonstração dos retornos da API via Insomnia

![Demonstração da API rodando em requisições backend](https://github.com/wesleyp846/ForumHub/blob/main/img/ExemploDeRespostaDaAPI.png)

&nbsp;
&nbsp;


> Demonstração da documentação adicioal SWAGGER

![Demonstração da documentação Swagger adicinal da API](https://github.com/wesleyp846/ForumHub/blob/main/img/TelaDocumentacaoSwagger.png)

&nbsp;
&nbsp;


> Demonstação das tabelas no Banco de Dados

![Demonstração do banco de dados da API](https://github.com/wesleyp846/ForumHub/blob/main/img/TabelasNoDB.png)

&nbsp;
&nbsp;


> Demonstração da estrutura de arquivos do codigo fonte

![Demonstração da estrutura de arquivos](https://github.com/wesleyp846/ForumHub/blob/main/img/EstruturaDeArquivos.png)
