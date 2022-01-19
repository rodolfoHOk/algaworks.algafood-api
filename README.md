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

- Alterando a estratégia de fetching para Lazy Loading - Exemplo no RestauranteController da busca Lazy

- Alterando a estratégia de fetching para Lazy Loading - @JsonIgnoreProperties({"hibernateLazyInitializer"})

- Alterando a estratégia de fetching para Lazy Loading

- Alterando a estratégia de fetching para Eager Loading

- Resolvendo o Problema do N+1 com fetch join na JPQL

### 6 - Pool de conexões e Flyway:

- Configurando o pool de conexões do Hikari

- Adicionando o Flyway, ferramenta de versionamento de schemas de banco de dados, no projeto

- Criando a primeira migração

- Evoluindo o banco de dados com novas migrações

- Criando migrações complexas com remanejamento de dados

- Criando migração a partir de DDL gerado por schema generation

- Adicionando dados de testes com callback do Flyway

- Reparando migrações com erros

- Criando migrações e mapeando as entidades Pedido e ItemPedido

### 7 - Tratamento e modelagem de erros da API 

- Lançando exceções customizadas anotadas com @ResponseStatus

- Lançando exceções do tipo ResponseStatusException

- Estendendo ResponseStatusException

- Simplificando o código com o uso de @ResponseStatus em exceptions

- Refatorando os serviços REST

- Criando a exception NegocioException

- Usando a exception NegocioException

- Afinando a granularidade e definindo a hierarquia das exceptions de negócios

- Lançando exceptions de granularidade fina

- Tratando exceções em nível de controlador com @ExceptionHandler

- Tratando exceções globais com @ExceptionHandler e @ControllerAdvice

- Implementando exception handler - EntidadeEmUsoException

- Criando um exception handler global com ResponseEntityExceptionHandler

- Customizando o corpo da resposta padrão de ResponseEntityExceptionHandler

- Padronizando o formato de problemas no corpo de respostas com a RFC 7807

- Usando o formato de problemas no corpo de respostas

- Customizando exception handlers de ResponseEntityExceptionHandler

- Tratando a exception InvalidFormatException na desserialização

- Habilitando erros na desserialização de propriedades inexistentes ou ignoradas

- Tratando a PropertyBindingException na desserialização

- Lançando exception de desserialização na atualização parcial PATCH

- Tratando exception de parâmetro de URL inválido

- Tratando a exceção NoHandlerFoundException

- Tratando outras exceções não capturadas

- Estendendo o formato do problema para adicionar novas propriedades

- Estendendo o formato do problema para todos os handles

### 8 - Validações com Bean Validation

- Adicionando o spring-boot-starter-validation

- Adicionando constraints e validando no controller com @Valid

- Tratando exception de violação de constraints de validação

- Estendendo o Problem Details para adicionar as propriedades com constraints violadas

- Conhecendo e adicionando mais constraints de validação no modelo

- Validando as associações de uma entidade em cascata

- Agrupando e restringindo constraints que devem ser usadas na validação

- Convertendo grupos de constraints para validação em cascata com @ConvertGroup

- Adicionando constraints de validação nos modelos Estado Cidade

- Customizando mensagens de validação na anotação da constraint

- Customizando e resolvendo mensagens de validação globais em Resource Bundle

- Customizando mensagens de validação

- Resolvendo mensagens de validação com Resource Bundle do Bean Validation

- Usando o Resource Bundle do Spring como Resource Bundle do Bean Validation

- Criando constraints de validação customizadas usando composição

- Criando constraints de validação customizadas com implementação de ConstraintValidator

- Criando constraints de validação customizadas em nível de classe

- Ajustando Exception Handler para adicionar mensagens de validação em nível de classe

- Executando processo de validação programaticamente

- Tratando a exception customizada de validações programáticas

### 9 - Testes de integração

- Criando e rodando um teste de integração com Spring Boot, JUnit e AssertJ

- Escrevendo bons nomes de testes

- Escrevendo testes de integração

- Rodando os testes pelo Maven (./mvnw test)

- Configurando Maven Failsafe Plugin no projeto (./mvnw verify)

- Implementando Testes de API com REST Assured e validando o código de status HTTP

- Validando o corpo da resposta HTTP

- Criando um método para fazer setup dos testes

- Entendendo o problema da ordem de execução dos testes (um teste não pode depender de outro teste para passar)

- Voltando o estado inicial do banco de dados para cada execução de teste com callback do Flyway

- Configurando um banco de testes e usando @TestPropertySource

- Limpando e populando o banco de dados de teste

- Testando endpoint passando parâmetro de URL

- Refatorando o código de testes

- Escrevendo testes de API

### 10 - Boas práticas e técnicas para APIs

- Analisando e definindo melhor o escopo das transações - usar @Transactional em métodos com mais de uma alteração no banco de dados

- Refinando o payload de cadastro com @JsonIgnoreProperties

- Criando classes de mixin para usar as anotações do Jackson

- Usando @JsonIgnoreProperties e Jackson Mixin

- Boas práticas para trabalhar com data e hora em REST APIs

- Desconfigurando data e hora - para implementar do zero na próxima

- Configurando e refatorando o projeto para usar UTC

- Refatorando o código para usar OffsetDateTime

- Isolando o Domain Model do Representation Model com o padrão DTO

- Implementando a conversão de entidade para DTO

- Criando DTOs para entrada de dados na API

- Refatorando e criando um assembler de DTO

- Refatorando e criando um disassembler do DTO

- Adicionando e usando o ModelMapper

- Customizando o mapeamento de propriedades com ModelMapper

- Mapeando para uma instância destino (e não um tipo) com ModelMapper

- Revisando e ajustando as mensagens de validação com o uso de DTOs

- Estratégias de nomes de propriedades: snake case vs lower camel case

- Usando DTOs como representation model

- Corrigindo bug de tratamento de exception de integridade de dados com flush do JPA

### 11 - Modelagem avançada e implementação da API 

- Implementando os endpoints de ativação e inativação de restaurantes

- Implementando os endpoints de formas de pagamento

- Adicionando endereço no modelo da representação do recurso de restaurante

- Refatorando serviço de cadastro de restaurante para incluir endereço

- Implementando os endpoints de grupos

- Implementando os endpoints de usuarios

- Um pouco mais sobre JPA: objeto alterado fora da transação é sincronizado com o banco de dados

- Implementando regra de negócio para evitar usuários com e-mails duplicados

- Implementando os endpoints de associação de formas de pagamento em restaurantes

- Implementando os endpoints de produtos

- Implementando os endpoints de abertura e fechamento de restaurantes

- Implementando os endpoints de associação de grupos com permissões

- Implementando os endpoints de associação de usuários com grupos

- Implementando endpoints de associação de usuários responsáveis com restaurantes

- Implementando ativação e inativação em massa de restaurantes

- Implementando os endpoints de consulta de pedidos

- Otimizando a query de pedidos e retornando model resumido na listagem

- Implementando o endpoint de emissão de pedidos

- Implementando endpoint de transição de status de pedidos

- Refatorando o código de regras para transição de status de pedidos

- Usando IDs vs UUIDs nas URIs de recursos

### 12 - Modelagem de projeções, pesquisas e relatórios

- Fazendo projeção de recursos com @JsonView do Jackson

- Limitando os campos retornados pela API com @JsonFilter do Jackson

- Limitando os campos retornados pela API com Squiggly

- Implementando pesquisas simples na API

- Modelando pesquisas complexas na API

- Implementando pesquisas complexas na API

- Tratando BindException ao enviar parâmetros de URL inválidos

- Implementando paginação e ordenação em recursos de coleção da API

- Implementando paginação e ordenação de pedidos

- Implementando JsonSerializer para customizar representação de paginação

- Implementando um conversor de propriedades de ordenação

- Modelando endpoints e implementando consulta com dados agregados (ideal para gráficos e dashboards) vendas diárias

- Adicionando os filtros na consulta de vendas diárias

- Tratando time offset na agregação de vendas diárias por data

- [Conhecendo o JasperSoft Studio e Criando um layout do relatório JasperReports de vendas diárias](https://github.com/rodolfoHOk/algaworks.algafood-reports)

- Estruturando endpoint e serviço de emissão de relatório em PDF

- Preenchendo um relatório JasperReports com JavaBeans e gerando bytes do PDF

### 13 - Upload e download de arquivos

- Conhecendo soluções para upload de arquivos em REST APIs

- Implementando upload de arquivo com multipart/form-data

- Validando o tamanho máximo do arquivo

- Validando o content type do arquivo

- Mapeando entidade FotoProduto e relacionamento um-para-um

- Implementando serviço de cadastro de foto de produto

- Excluindo e substituindo cadastro de foto de produto

- Implementando o serviço de armazenagem de fotos no disco local

- Integrando o serviço de catálogo de fotos com o serviço de armazenagem

- Implementando a remoção e substituição de arquivos de fotos no serviço de armazenagem

- Implementando recuperação de foto no serviço de armazenagem

- Implementando endpoint de consulta de foto de produto

- Servindo arquivos de fotos pela API

- Checando media type ao servir arquivos de fotos

- Implementando endpoint de exclusão de foto de produto

- Corrigindo exception handler de media type não aceita

- Criando bean de propriedades de configuração dos serviços de storage

- Adicionando o SDK Java da Amazon S3 no projeto e criando classe do serviço de storage

- Definindo bean do client da Amazon S3 e configurando credenciais

- Implementando a inclusão de objetos no bucket da Amazon S3

- Implementando a exclusão de objetos do bucket da Amazon S3

- Implementando a recuperação de foto no serviço de storage do S3

- Selecionando a implementação do serviço de storage de fotos

- Adicionando condição para a criação do bean amazonS3 para não serem necessárias id-chave-acesso e chave-acesso-secreta quando em armazenamento local

### 14 - E-mails transacionais e Domain Events

- Configurando o projeto para envio de e-mails usando servidor SMTP

- Implementando o serviço de infraestrutura de envio de e-mails com Spring

- Usando o serviço de envio de e-mails na confirmação de pedidos

- Processando template do corpo de e-mails com Apache FreeMarker

- Melhorando o texto do e-mail com FTL (FreeMarker Template Language)

- Formatando valores monetários com FTL

- Implementando serviço de envio de e-mail fake

- Implementando serviço de envio de e-mail sandbox

- Conhecendo o padrão Domain Events do DDD

- Publicando Domain Events a partir do Aggregate Root

- Observando e reagindo a Domain Events

- Reagindo a Domain Events em fases específicas da transação

- Enviando e-mails no cancelamento de pedidos

### 15 - CORS e consumo da API com JavaScript e Java

- [Implementando uma chamada na REST API com JavaScript](https://github.com/rodolfoHOk/algaworks.algafood-js-client)

- Testando a requisição na API com JavaScript e entendendo a Same Origin Policy

- Entendendo o funcionamento básico de CORS e habilitando na API

- Habilitando CORS em controladores e métodos com @CrossOrigin

- Entendendo o funcionamento de preflight do CORS

- Habilitando CORS globalmente no projeto da API

- [Implementando um client da REST API com Java e Spring (RestTemplate)](https://github.com/rodolfoHOk/algaworks.algafood-java-client)

### 16 - Cache de HTTP

- Habilitando o cache com o cabeçalho Cache-Control e a diretiva max-age

- Adicionando o cabeçalho Cache-Control na resposta

- Entendendo a validação de representações em cache com ETags e Implementando requisições condicionais com Shallow ETags

- Adicionando outras diretivas de Cache-Control na resposta HTTP

- Usando a diretiva no-cache no cabeçalho Cache-Control da requisição

- Entendendo e preparando a implementação de Deep ETags

- Implementando requisições condicionais com Deep ETags

- Implementando requisições condicionais com Deep ETags no recurso único

### 17 - Documentação da API com OpenAPI, Swagger UI e SpringFox

- Gerando a definição OpenAPI em JSON com SpringFox

- Gerando a documentação da API em HTML com Swagger UI e SpringFox

- Selecionando os endpoints da API para gerar a documentação

- Descrevendo informações da API na documentação

- Descrevendo tags na documentação e associando com controllers

- Descrevendo as operações de endpoints na documentação

- Descrevendo parâmetros de entrada na documentação

- Descrevendo modelos de representações e suas propriedades

- Descrevendo restrições de validação de propriedades do modelo

- Descrevendo códigos de status de respostas de forma global

- Descrevendo códigos de status de respostas de forma global outros métodos

- Descrevendo o modelo de representação (adicional) de problema

- Referenciando modelo de representação de problema com códigos de status de erro

- Descrevendo códigos de status de respostas em endpoints específicos

- Desacoplando anotações do Swagger dos controladores

- Descrevendo documentação de endpoints de grupos

- Descrevendo media type da resposta nos endpoints

- Corrigindo documentação com substituição de Pageable

- Corrigindo documentação com substituição de Page

- Descrevendo documentação de endpoints de cozinhas

- Ignorando tipos de parâmetros de operações na documentação

- Descrevendo documentação de endpoints de formas de pagamento

- Descrevendo parâmetros globais em operações

- Descrevendo parâmetros implícitos em operações

- Descrevendo documentação de endpoints de pedidos

- Descrevendo parâmetros de projeções em endpoints de consultas

- Descrevendo documentação de endpoints de restaurantes

- Descrevendo documentação de endpoints de estados

- Descrevendo documentação de endpoints de fluxo de pedidos

- Descrevendo documentação de endpoints de associação de restaurantes com formas de pagamento

- Descrevendo documentação de endpoints de associação de restaurantes com usuários

- Descrevendo documentação de endpoints de produtos

- Descrevendo documentação de endpoints de fotos de produtos

- Corrigindo documentação no Swagger UI para upload de arquivos

- Descrevendo documentação de endpoints de associação de permissões com grupos

- Descrevendo documentação de endpoints de usuários

- Descrevendo documentação de endpoints de associação de grupos com usuários

- Descrevendo documentação de endpoint de estatísticas

### 18 - Discoverability e HATEOAS: A Glória do REST

- Adicionando a URI do recurso criado no header da resposta

- Adicionando o Spring HATEOAS no projeto

- Adicionando hypermedia na representação de recurso único com HAL

- Construindo links dinâmicos com WebMvcLinkBuilder

- Construindo links que apontam para métodos

- Adicionando hypermedia na representação de recursos de coleção

- Montando modelo de representação com RepresentationModelAssembler

- Adicionando hypermedia nos recursos de usuários

- Corrigindo link de coleção de recurso de responsáveis por restaurante

- Adicionando hypermedia nos recursos de estados

- Adicionando hypermedia em recursos com paginação

- Adicionando hypermedia em recursos de pedidos (paginação)

- Corrigindo links de paginação com ordenação

- Adicionando links com template variables

- Adicionando template variables do filtro de pedidos

- Refatorando construção e inclusão de links em representation model

- Refatorando construção e inclusão de links

- Adicionando links de transições de status de pedidos

- Adicionando links condicionalmente

- Adicionando hypermedia nos recursos de restaurantes

- Adicionando links condicionais no recurso de restaurante

- Adicionando template variable de projeção de restaurantes

- Adicionando hypermedia nos recursos de formas de pagamento

- Adicionando links para desassociação de formas de pagamento com restaurante

- Adicionando links com template variable de caminho de formas de pagamento do restaurante

- Adicionando links de associação de restaurantes com responsáveis

- Adicionando hypermedia nos recursos de produtos

- Adicionando links para recurso de foto de produto

- Adicionando hypermedia nos recursos de grupos

- Adicionando links de associação de grupos com permissões

- Adicionando links de associação de usuários com grupos

- Implementando o Root Entry Point da API

- Implementando endpoint com links de recursos de estatísticas

- Comprimindo as respostas HTTP com Gzip

- Corrigindo as propriedades de links na documentação

- Corrigindo a documentação dos endpoints de cidades

- Corrigindo a documentação links para _links de cidades

- Corrigindo a paginação na documentação

- Corrigindo a documentação dos endpoints de estados

- Corrigindo a documentação dos endpoints de formas de pagamento

- Corrigindo a documentação dos endpoints de grupos

- Corrigindo a documentação dos endpoint de pedidos (paginação)

- Corrigindo a documentação dos endpoints de produtos

- Corrigindo a documentação dos endpoints de restaurantes e usuários

- Removendo modelo de representação inutilizado da documentação

- Removendo modelo de api inutilizado

- Corrigindo a documentação dos endpoints de foto de produto

### 19 - Evoluindo e versionando a API

- Evoluindo a API com gestão de mudanças

- [Evitando quebrar os clientes](evoluindoVersionandoAPI.md)

- O que é e quando versionar uma API

- [As principais técnicas de versionamento de APIs](evoluindoVersionandoAPI.md)

- [As principais abordagens para manter a base de código de APIs versionadas](evoluindoVersionandoAPI.md)

- Preparando o projeto para versionamento da API por Media Type

- Implementando o versionamento da API por Media Type

- Definindo a versão padrão da API quando o Media Type não é informado

- Implementando o versionamento da API por URI

- Refatorando controladores para adicionar /v1 nas URIs

- Adicionando os recursos de cozinhas na v2 da API

- Gerando documentação das versões da API com SpringFox e Swagger UI

- Revisando documentação da v2 da API

- Depreciando uma versão da API

- Desligando uma versão da API

- Voltando a versão v1 para continuar com o curso

### 20 - Logging

- Introdução ao Logback e SLF4J

- Registrando logs de exceptions não tratadas

- Criando uma conta no Loggly: serviço de gerenciamento de logs na nuvem

- Configurando o appender do Loggly no Logback

- Configurando o Logback para alternar as configurações por Spring Profiles

### 21 - Segurança com Spring Security e OAuth2

- Introdução à segurança de REST APIs

- Adicionando segurança na API com Spring Security

- Configurando Spring Security com HTTP Basic

- Configurando autenticação de usuários em memória

- Introdução ao OAuth2

- Soluções para OAuth2: nova stack do Spring Security vs Spring Security OAuth

- Conhecendo o fluxo Resource Owner Password Credentials Grant

- [Criando o projeto do Authorization Server com Spring Security OAuth2](https://github.com/rodolfoHOk/algaworks.algafood-auth)

- Configurando o Resource Server com a nova stack do Spring Security

- [Testando o fluxo Authorization Code com um client JavaScript](https://github.com/rodolfoHOk/algaworks.foodanalytics-js-client)

- [Mais em AlgaFood Authorization Server Repository](https://github.com/rodolfoHOk/algaworks.algafood-auth)

### 22 - OAuth2 avançado com JWT e controle de acesso

- [AlgaFood Authorization Server Repository](https://github.com/rodolfoHOk/algaworks.algafood-auth)

- Configurando o Resource Server para JWT assinado com chave simétrica

- Configurando a validação de JWT no Resource Server com a chave pública

- Refatorando serviços de usuários para usar BCrypt

- Obtendo usuário autenticado no Resource Server

- Definindo e criando as permissões de acesso

- Carregando as Granted Authorities e restringindo acesso a endpoints na API

- Method Security: Restringindo acesso com @PreAuthorize e SpEL

- Tratando AccessDeniedException no ExceptionHandler

- Simplificando o controle de acesso em métodos com meta-anotações

- Entendendo os escopos do OAuth2

- Carregando Granted Authorities dos escopos do OAuth2 no Resource Server

- Restringindo acesso a endpoints por escopos do OAuth2

- Restringindo acesso dos endpoints de restaurantes

- Restringindo acessos de forma contextual (sensível à informação)

- Restringindo acessos com @PostAuthorize

- Restringindo acessos ao endpoint de pesquisa de pedidos

- Restringindo acessos aos endpoints de transição de status de pedidos

- Restringindo acessos aos endpoints de formas de pagamentos

- Restringindo acessos aos endpoints de cidades e estados

- Restringindo acessos aos endpoints de usuários, grupos e permissões

- Restringindo acessos aos endpoints de estatísticas

- [Configurando os clientes OAuth2 em um banco de dados SQL](https://github.com/rodolfoHOk/algaworks.algafood-auth)

- Cadastrando clientes OAuth2 no banco de dados e testando a emissão de tokens

- Corrigindo lógica de restrição de acessos para Client Credentials Flow

- Gerando links do HAL dinamicamente de acordo com permissões do usuário

- Gerando links do HAL dinamicamente de acordo com permissões

- Juntando o Resource Server com o Authorization Server no mesmo projeto

- Ajustando a documentação da API para suporte a OAuth2

- 

## AlgaFood Authorization Server Repository

### GitHub

https://github.com/rodolfoHOk/algaworks.algafood-auth

## Documentação da API

http://localhost:8080/swagger-ui/index.html


## Links úteis: 

### Documentação do Spring Data JPA: Keywords de query methods:

https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

### Estrutura do arquivo orm.xml

https://gist.github.com/thiagofa/35d5a651a39cb0b26f050dc3b1ce8f9b

### Constraints do Bean Validation

https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints

### Lazy loading com mapeamento OneToOne

https://blog.algaworks.com/lazy-loading-com-mapeamento-onetoone/

### Boas práticas de HTML para e-mails

https://ajuda.locaweb.com.br/wiki/boas-praticas-de-html-para-email-marketing-ajuda-locaweb/

### Definição de requisição simples, de acordo com CORS

https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS#simple_requests

### Wireshark - software para análise de tráfego de rede

https://www.wireshark.org/

### HAL - Hypertext Application Language

https://stateless.group/hal_specification.html

### Componente para habilitar HAL para custom media type

https://gist.github.com/thiagofa/8952d7fee7650c94bb116917d63c9ae6

### Documentação do Loggly

https://documentation.solarwinds.com/en/success_center/loggly/content/admin/java-logback.htm?cshid=loggly_java-logback

### Especificação do OAuth 2.0

https://datatracker.ietf.org/doc/html/rfc6749
