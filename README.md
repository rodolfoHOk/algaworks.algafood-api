# AlgaFood API

> Projeto Principal do Curso Especialista Spring Rest da AlgaWorks

## Conteúdo Resumido do Curso

### Spring e Injeção de Dependências

- O ecossistema Spring

- Spring Boot e Spring Initializer
	
- Maven e o pom.xml

- Spring MVC e DevTools

- Injeção de Dependências e o IoC Container do Spring

- Spring Profiles

- Configurando projetos no Spring Boot (application.properties)

- Propriedades customizadas e Variáveis de ambiente

### JPA e Hibernate

- O que é JPA e Hibernate?

- Mapeando entidades com JPA

- Consultando, Adicionando, Buscando, Atualizando, Excluindo um objeto do banco de dados com JPA

- O padrão Aggregate do DDD

- Conhecendo e implementando o padrão Repository

- Mapeando relacionamentos

### REST com Spring

- O que é REST? As constraints do REST, Diferenças entre REST e RESTFul

- O protocolo HTTP, métodos e status HTTP.

- Postman

- Recursos REST, Collection Resource e Singleton Resource

- Controller, Rest Controller Spring

- Content Negotiation

- Modelos de representação

- ResponseStatus

- Consultas de Collection e de Singleton Resource, Inclusão, Atualização e Exclusão de recursos

- Camada de Domain Services

- API de Reflections do Spring

- Modelo de Maturidade de Richardson

### Spring Data JPA (SDJ)

- Consultas JPQL em repositórios

- O projeto Spring Data JPA

- Repositório com Spring Data JPA 

- Consultas com query methods

- Queries JPQL customizadas

- Criteria API

- Specifications (DDD) com SDJ

- Mapeamentos ManyToOne, OneToMany, ManyToMany

- Mapeando classes incorporáveis (Embedded / Embeddable)

- Eager Loading e Lazy Loading

### Pool de conexões e Flyway

- Hikari, a solução padrão de poll de conexões no Spring Boot

- Flyway, ferramenta de versionamento de schemas de banco de dados

- Migrations

### Tratamento e modelagem de erros da API

- Tratamento e modelagem de erros

- Lançando exceções customizadas anotadas com @ResponseStatus e do tipo ResponseStatusException

- Afinando a granularidade e definindo a hierarquia das exceptions

- Tratando exceções em nível de controlador com @ExceptionHandler

- Tratando exceções globais com @ExceptionHandler e @ControllerAdvice

- RFC 7807 (Problem Details for HTTP APIs)

- Padronizando o formato de problemas no corpo de respostas com a RFC 7807

### Validações com Bean Validation

- Validação do Modelo com Bean Validation

- Constraints de validação

- Validando no controller com @Valid

- Tratando exception de violação de constraints de validação

- Customizando mensagens de validação

### Testes de integração

- Testes de Integração e Testes de APIs

- Teste de integração com Spring Boot, JUnit e AssertJ

- Rodando os testes pelo Maven

- Testes de API com REST Assured, validando o código de status HTTP e corpo da resposta HTTP


### Boas práticas e técnicas para APIs

- Usar anotação @Transactional em métodos com mais de uma alteração no banco de dados

- Boas práticas para trabalhar com data e hora em REST APIs (UTC, OffsetDateTime)

- Isolando o Domain Model do Representation Model com o padrão DTO

- ModelMapper

### Modelagem avançada e implementação da API

- Modelando sub-recursos para relacionamentos

- Modelando conceitos abstratos de negócio e ações não-CRUD como recursos

- Um pouco mais sobre JPA: objeto alterado fora da transação é sincronizado com o banco de dados

- Regras de negócio

- implementação da API

- Otimizando queries

- Usando IDs vs UUIDs nas URIs de recursos

- Limitando campos retornados pela API com Squiggly

- Paginação e ordenação em recursos de coleção da API

- Consulta com dados agregados

- Relatórios com JasperSoft Studio, emissão de relatório em PDF

### Upload e download de arquivos

- Soluções para upload de arquivos em REST APIs

- Upload de arquivo com multipart/form-data

- Armazenagem de fotos no disco local

- Servindo arquivos de fotos pela API

- Amazon S3: Serviço de storage da AWS

- SDK Java da Amazon S3

- Inclusão, exclusão e recuperação de objetos no bucket da Amazon S3

- Serviço de storage de fotos

### E-mails transacionais e Domain Events

- Soluções para envio de e-mails transacionais

- Envio de e-mails usando servidor SMTP com Spring

- Processando template do corpo de e-mails com Apache FreeMarker

- Serviços de envio de e-mail real, fake e sandbox

- O padrão Domain Events do DDD

- Publicando Domain Events

- Observando e reagindo a Domain Events

- Reagindo a Domain Events em fases específicas da transação

### CORS e consumo da API com JavaScript e Java

- Funcionamento básico de CORS

- Funcionamento de preflight do CORS

- Same Origin Policy

- Habilitando CORS globalmente na API

- Implementando client Javascript

- Implementando client Java e Spring com RestTemplate

### Cache de HTTP

- Cache de HTTP

- Cache com Headers Cache-Control e max-age

- Entendendo validação de representações em cache com ETags

- Shallow ETags e Deep ETags

### Documentação da API com OpenAPI, Swagger UI e SpringFox

- Documentação de REST APIs

- OpenAPI (antes Swagger)

- Gerando a definição OpenAPI em JSON com SpringFox

- Gerando a documentação da API em HTML com Swagger UI e SpringFox

- Customizando a documentação

### Discoverability e HATEOAS: A Glória do REST

- Discoverability e HATEOAS

- Spring HATEOAS

- Especificações para formatos Hypermedia

- HAL, especificação default do Spring HATEOAS

- Links dinâmicos com WebMvcLinkBuilder

- Modelo de representação com RepresentationModel

- Montando modelo de representação com RepresentationModelAssembler

### Evoluindo e versionando a API

- Evoluindo a API com gestão de mudanças

- Evitando quebrar os clientes

- O que é e quando versionar uma API?

- As principais técnicas de versionamento de APIs

- Versionamento da API por Media Type

- Versionamento da API por URI

### Logging

- Logback e SLF4J

- Registrando logs de exceptions não tratadas

- Loggly: serviço de gerenciamento de logs na nuvem

- Configurando o appender do Loggly no Logback

- Configurando o Logback para alternar as configurações por Spring Profiles

### Segurança com Spring Security e OAuth2

- Segurança em REST APIs

- Spring Security

- OAuth2

- Criando o Authorization Server com Spring Security OAuth2

- Fluxo de Autenticação Resource Owner Password Credentials Grant, Password Credentials no Authorization Server

- Fluxo para emitir e usar Refresh Tokens, Refresh Token Grant Type no Authorization Server

- Fluxo Client Credentials, Client Credentials Grant Type no Authorization Server

- Fluxo Authorization Code, Authorization Code Grant Type no Authorization Server

- Fluxo Implicit, Implicit Grant Type no Authorization Server

- Mais segurança com PKCE e Authorization Code Grant

- Testando um client JavaScript com PKCE e Authorization Code

- Armazenando tokens no Redis: um banco de dados NoSQL

- Stateful e Stateless Authentication

- Transparent Tokens: conhecendo o JSON Web Tokens (JWT)

- Assinando o JWT com RSA SHA-256 (chave assimétrica)

- Autenticando usuário com dados do banco de dados

- Customizando a página de login

- Customizando a página de OAuth2 Approval

- Obtendo usuário autenticado no Resource Server

- Restringindo acessos no Resource Server com @PreAuthorize e SpEL

### Dockerizando a aplicação

- Docker

- Arquitetura do Docker

- Docker Images e o Docker Hub

- Gerenciando images e containers

- Executando container do MySQL

- Construindo a imagem da aplicação com Dockerfile

- Docker network

- Imagem da aplicação no Docker Hub

- Docker Compose

- Escalando um serviço com Docker Compose

- Poor Man's Load Balancer (DNS Round Robin)

- Proxy reverso com Nginx

- Redis no arquivo do Docker Compose

- Spring Session Data Redis

### Deploy em containers Docker na Amazon

- Organização das propriedades do projeto com Spring Profiles

- Amazon Web Services (AWS)

- Monitorando e criando um alerta de orçamento da AWS

- Amazon S3 (storage das fotos de produtos da aplicação)

- Amazon Identity and Access Management (IAM) (Gerenciamento de acessos e usuários) 

- Amazon RDS (instância do MySQL)

- RedisLabs (instância do Redis)

- Amazon Elastic Container Service (ECS) e AWS Fargate (instâncias de containers da aplicação)

- Amazon Elastic Container Registry (ECR) (armazenar o docker image da aplicação)

- AWS Systems Manager Parameter Store (Gerenciar os propriedades da aplicação)

- Elastic Load Balancing da Amazon (Load balancer para resiliência a aplicação)

- Registro.br (Registro de domínio para a aplicação)

- AWS Certificate Manager (certificado TLS para HTTPS)

## Conteúdo Completo do Curso

[Conteúdo completo do curso ESR](conteudo-curso.md)

## Certificado de conclusão do curso

<img src="https://raw.githubusercontent.com/rodolfoHOk/portfolio-img/main/images/certificado-algaworks-esr.png" alt="AlgaWorks Certificado ESR" width="450"/>


## URL da Documentação da API

http://localhost:8080/swagger-ui/index.html

## Repositórios dos projetos do curso

[Injeção de dependências com Spring IoC](https://github.com/rodolfoHOk/algaworks.esr.injecaodependencias)

[AlgaFood API](https://github.com/rodolfoHOk/algaworks.algafood-api)

[AlgaFood Relatórios com JasperReport](https://github.com/rodolfoHOk/algaworks.algafood-reports)

[AlgaFood Authorization Server](https://github.com/rodolfoHOk/algaworks.algafood-auth)

[AlgaFood JavaScript Client](https://github.com/rodolfoHOk/algaworks.algafood-js-client)

[AlgaFood JavaClient](https://github.com/rodolfoHOk/algaworks.algafood-java-client)

[FoodAnalytics JavaScript Client](https://github.com/rodolfoHOk/algaworks.foodanalytics-js-client)

## Outros arquivos markdown sobre o curso:

[Evoluindo e versionando a API](evoluindo-versionando-api.md)

[Guia de requisições de autenticação para os clients](client-example.md)

[Guia de uso do Keytool](keytool-guia.md)

[Decidindo qual fluxo OAuth2 usar](decidindo-fluxo-oauth2.md)

[Guia de deploy da aplicação](deploy-prod.md)

[Conteúdo completo do curso ESR](conteudo-curso.md)

## Links úteis: 

### Resource Server - API

[Documentação do Spring Data JPA: Keywords de query methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)

[Estrutura do arquivo orm.xml](https://gist.github.com/thiagofa/35d5a651a39cb0b26f050dc3b1ce8f9b)

[Constraints do Bean Validation](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints)

[Lazy loading com mapeamento OneToOne](https://blog.algaworks.com/lazy-loading-com-mapeamento-onetoone/)

[Boas práticas de HTML para e-mails](https://ajuda.locaweb.com.br/wiki/boas-praticas-de-html-para-email-marketing-ajuda-locaweb/)

[Definição de requisição simples, de acordo com CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS#simple_requests)

[Wireshark - software para análise de tráfego de rede](https://www.wireshark.org/)

[HAL - Hypertext Application Language](https://stateless.group/hal_specification.html)

[Componente para habilitar HAL para custom media type](https://gist.github.com/thiagofa/8952d7fee7650c94bb116917d63c9ae6)

[Documentação do Loggly](https://documentation.solarwinds.com/en/success_center/loggly/content/admin/java-logback.htm?cshid=loggly_java-logback)

[Especificação do OAuth 2.0](https://datatracker.ietf.org/doc/html/rfc6749)

[Template da página de login com Bootstrap](https://gist.github.com/thiagofa/9b5cb7db488ca9b4ae123661a8087a9f#file-login-html)

[RFC-7517 - JSON Web Key (JWK)](https://datatracker.ietf.org/doc/html/rfc7517)

[Dockerfile Maven Plugin](https://github.com/spotify/dockerfile-maven)

[Documentação dos comandos do docker-compose](https://docs.docker.com/compose/reference/)

[Repositório no GitHub do wait-for-it (para aguardar a inicialização do banco de dados antes de iniciar a api)](https://github.com/vishnubob/wait-for-it)

[SpringDoc Documentação](https://springdoc.org/)

### Authorization Server

[Especificação do OAuth 2.0](https://datatracker.ietf.org/doc/html/rfc6749)

[Dependências para resolver problema com Spring Security OAuth2 e Java 11+](https://gist.github.com/thiagofa/ef9a40d495016cb2581add41b5cbde1b)

[RFC 7662 - OAuth 2.0 Token Introspection](https://datatracker.ietf.org/doc/html/rfc7662)

[Configuração de CORS no Authorization Server com CorsFilter](https://gist.github.com/thiagofa/764260dfd8ba21f30f2f79806d734563)

[RFC 7636 - PKCE](https://datatracker.ietf.org/doc/html/rfc7636)

[Implementação de PKCE para Spring Security OAuth2](https://gist.github.com/thiagofa/daca4f4790b5b18fed800b83747127ca)

[Ferramenta online para gerar Code Verifier e Code Challenge (PKCE)](https://tonyxu-io.github.io/pkce-generator/)

[RFC 7519 - JSON Web Token](https://datatracker.ietf.org/doc/html/rfc7519)

[Ferramenta online para debugging de JWT](https://jwt.io/)

[Bcrypt Generator](https://bcrypt-generator.com/)

[DDL da tabela de clientes OAuth2](https://gist.github.com/thiagofa/7b1792745d4de64bd86b230d0e3a381d)

[Spring Authorization Server Github](https://github.com/spring-projects/spring-authorization-server)
