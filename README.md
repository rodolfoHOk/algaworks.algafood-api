# AlgaFood API - Curso Especialista Spring Rest da AlgaWorks

## Conteúdo (histórico de commits em ordem cronológica):

### 1 - Spring e Injeção de Dependências:

- Conteúdo no repositório: https://github.com/rodolfoHOk/algaworks.esr.injecaodependencias

### 2 - Introdução ao JPA e Hibernate:

- Adicionando JPA e configurando o Data SourceMapeando entidades com JP

- Criando as tabelas do banco a partir das entidades

- Mapeando o id da entidade para autoincremento

- Importando dados de teste com import.sql

- Consultando objetos do banco de dados

- Adicionando um objeto no banco de dados

- Buscando um objeto pelo id no banco de dados

- Atualizando um objeto no banco de dados

- Excluindo um objeto do banco de dados

- Conhecendo e implementando o padrão Repository - Orientado a persistencia

- Conhecendo e implementando o padrão Repository - Orientado a colecao

- Conhecendo e implementando o padrão Repository - retornando a orientado a persistencia

- Conhecendo e usando o Lombok

- Lombok e repositório de restaurantes

- Mapeando relacionamento com @ManyToOne

- A anotação @JoinColumn

- Mapeando entidades FormaPagamento Permissao Estado Cidade


### 3 - REST com Spring:

- Modelando e requisitando um Collection Resource com GET

- Collection resource de estados

- Implementando content negotiation para retornar JSON ou XML - no metodo exemplo json e xml

- Implementando content negotiation para retornar JSON ou XML - no escopo da classe exemplo json somente

- Implementando content negotiation para retornar JSON ou XML - em metodos diferentes

- Consultando Singleton Resource com GET e @PathVariable

- Customizando as representações XML e JSON com @JsonIgnore, @JsonProperty e @JsonRootName

- Customizando a representação em XML com Wrapper e anotações do Jackson

- Definindo o status da resposta HTTP com @ResponseStatus

- Manipulando a resposta HTTP com ResponseEntity

- Corrigindo o Status HTTP para resource inexistente

- Modelando e implementando a inclusão de recursos com POST

- Modelando e implementando a atualização de recursos com PUT

- Modelando e implementando a exclusão de recursos com DELETE

- Implementando a camada de domain services (e a importância da linguagem ubíqua)

- Refatorando a exclusão de cozinhas para usar domain services

- Refatorando a atualizacao de cozinha para usar domain services

- Removendo suporte a requisicoes XML

- Removendo pacote jpa usado nos estudos para testar a aplicacao

- Modelando e implementando a consulta de recursos de restaurantes

- Modelando e implementando a inclusão de recursos de restaurantes

- Modelando e implementando a atualização de recursos de restaurantes

- Analisando solução para atualização parcial de recursos com PATCH

- Finalizando a atualização parcial com a API de Reflections do Spring

- Implementando serviços REST de cidades e estados

### 4 - Super poderes do Spring Data JPA:

- Implementando consultas JPQL em repositórios - nome = :nome

- Implementando consultas JPQL em repositórios - nome like :nome

- Criando um repositório com Spring Data JPA e Refatorando o código

- Refatorando todos os repositórios para usar Spring Data JPA

- Criando consultas com query methods - nome(String nome)

- Criando consultas com query methods - findByNome(String nome)

- Criando consultas com query methods - findCozinhasByNome(String nome)

- Criando consultas com query methods - unica com optional

- Usando as keywords para definir critérios de query methods

- Conhecendo os prefixos de query methods

- Usando queries JPQL customizadas com @Query e @Param

- Externalizando consultas JPQL para um arquivo XML

- Implementando um repositório SDJ customizado

- Implementando uma consulta dinâmica com JPQL

- Implementando uma consulta simples com Criteria API

- Adicionando restrições na cláusula where com Criteria API

- Tornando a consulta com Criteria API com filtros dinâmicos

- Specifications (DDD) com SDJ e Implementando Specifications

- Criando uma fábrica de Specifications

- Injetando o próprio repositório na implementação customizada e a anotação @Lazy

- Estendendo o JpaRepository para customizar o repositório base


### 5 - Explorando mais do JPA e Hibernate:

- Mapeando relacionamento bidirecional com @OneToMany

- Mapeando relacionamento muitos-para-muitos com @ManyToMany

- Analisando o impacto do relacionamento muitos-para-muitos na REST API

- Mapeando classes incorporáveis com @Embedded e @Embeddable

- Testando e analisando o impacto da incorporação de classe na REST API

- Mapeando propriedades com @CreationTimestamp e @UpdateTimestampI

- Mapeando relacionamento muitos-para-um - Produto Restaurante

- Mapeando relacionamento um-para-muitos - Restaurante Produto

- Mapeando relacionamentos muitos-para-muitos - Grupo Permissao e Usuario Permissao

-


## Links úteis: 

### Documentação do Spring Data JPA: Keywords de query methods:

https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

### Estrutura do arquivo orm.xml

https://gist.github.com/thiagofa/35d5a651a39cb0b26f050dc3b1ce8f9b