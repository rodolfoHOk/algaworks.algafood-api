# Deploy em containers Docker na Amazon

## Locais possíveis de implantação

### Servidor on-premises

- Rodar o jar em uma máquina

CMD: java -jar target/algafood-api-0.0.1-SNAPSHOT.jar

- Rodar em containers e orquestradores de containers

### PAAS - Platform as a Service

- [CloudFoundry: Certified Distributions](https://www.cloudfoundry.org/the-foundry/#cert-distros)

- [Heroku](https://www.heroku.com/)

- Serviços de orquestração de containers (kubernets na nuvem por exemplo)

### Provedor de serviços na nuvem

- [Digital Ocean](https://www.digitalocean.com) (máquinas virtuais, kubernets, databases, ...)

- [Microsoft Azure](https://azure.microsoft.com/pt-br) (máquinas virtuais, containers gerenciados, kubernets, databases, ...)

- [Google Cloud](https://cloud.google.com) (máquinas virtuais, containers gerenciados, kubernets, databases, ...)

- [Alibaba Cloud](https://www.alibabacloud.com) (máquinas virtuais, containers gerenciados, databases, ...)

- [Amazon Web Services - AWS](https://aws.amazon.com/pt) (máquinas virtuais, containers gerenciados, kubernets, databases, ...)

## Deploy na Amazon Web Services (AWS)

### Entendendo alguns conceitos fundamentais da nuvem da AWS

- Região

- Zona de disponibilidade

- VPC

- Subnet

### Monitorando e criando um alerta de orçamento da AWS

**Dica: Parar os serviços não utilizados, por exemplo, em testes.**

Criando o alerta:

	Menu da sua conta (seu nome) -> My Billing Dashboard
	
		-> Details 
		
		Top Free Tier Services by Usage -> View All
		
		-> SideBar 
		
			-> Billing Preferences
			
				Marcar: Receive PDF Invoice By Email, Receive Free Tier Usage Alerts, Receive Billing Alerts
				
				-> Save Preferences
				
			-> Budgets -> Create a budget
			
				Cost budget -> Set your budget
				
					Preencher: 
					
						Name (algafood-limite-custo), 
						
						Period (Monthly), 
						
						Specify your monthly budget - Budgeted amount ($5)
						
					-> Configure thresholds
					
						Define your budget threshold - Alert threshold (80 %)
						
						Set uo your notifications - Email recipients (email mais usado)
						
						-> Confirm budget -> Create

### Criando o bucket no Amazon S3

[Link para o Amazon S3](https://aws.amazon.com/pt/s3/)

Consultar os Preços:

	TopBar -> Definição de preço
	
Criando o Bucket:

	Página da conta - Pesquisar S3 -> Services -> S3
	
		SideBar -> Buckets
		
			-> Create bucket

				Bucket name (algafood-photos-production)
					
				AWS Region (us-east-1)
				
				Block all public access (desmarcar) -> confirmar o alerta
					
				-> Create bucket
					
			-> algafood-photos-production
			
				-> Upload
				
					Drag and Drop (teste.jpg)
					
					-> Additional upload options
					
						Access control list
						
							Everyone -> Read -> confirmar o alerta
							
					-> Upload
					
				-> teste.jpg marcar -> delete -> confirmar escrevendo permanently delete -> Delete objects
				
		TopBar -> Pesquisar iam -> Services -> IAM
		
			SideBar -> Policies
			
				-> Create policy
				
					Select a service
					
						Service (S3)
						
						Actions - Access level
						
							-> Write (Put object, Delete object)
							
							-> Permissions management (PutObjectAcl, PutObjectVersionAcl)
							
						Resources 
						
							-> Specific
							
							object -> Add ARN
							
								Bucket name (algafood-photos-production) 
								
								Object name (Any)
								
								-> Add
								
					-> Next: Tags
					
						-> Next: Review
						
							Review Policy
							
								Name (AlgaFoodProductionGravacaoFotosS3)
								
								-> create Policy
								
			SideBar -> Users
			
				-> Add user
				
					Set user details
					
						User name (algafood-photos-production-s3)
						
					Select AWS access type
					
						Access type (Programmatic access)
						
						-> Next-permissions
						
							Set permissions
							
								-> Attach existing policies directly
								
								Filter (algafood)
								
								-> AlgaFoodProductionGravacaoFotosS3
								
								-> Next: Tags
								
									-> Next: Review
									
										-> Create user
										
					algafood-photos-production-s3
					
						Access key id (anotar e guardar em lugar seguro)
						
						Secret access key (anotar e guardar em lugar seguro)
						
				[Caso perca o Secret access key]
				
				-> algafood-photos-production-s3
				
					-> Security credentials
					
						Access key
						
							Create access key

### Criando uma instância do MySQL no Amazon RDS

[Link para o Amazon RDS](https://aws.amazon.com/pt/rds/)

Consultar os Preços:

	TopBar -> Definição de preço

Criando a instância do Banco de dados:

	Página da conta -> Pesquisar rds -> Services -> RDS
	
		TopBar -> us-east-1
		
		SideBar -> Databases
		
			-> Create database obs: em produção Multi-AZ
				
				Choose a database creation method (Standard create)
				
				Engine options (MySQL)
				
					Version MySQL 8.0.xx
				
				Templates (Free tier)
				
				Settings
					
					DB instance identifier (algafood-mysql)
					
					Credentials Settings
					
						Master username (admin)
						
						Master password (preencher e guardar em local seguro)
						
						Confirm password (preencher)
						
				Connectivity
				
					Virtual private cloud (Create new vpc se não tiver nenhuma, ou selecionar a que já vem criada)
					
					Public access (Yes)
					
					VPC security group (Create new)
					
					New VPC security group name (algafood-mysql-sg)
					
					Availability Zone (No preference)
					
				-> Create database
				
### Criando schema e usuário da aplicação

Nomeando a VPC :
	
	Página da conta - Pesquisar vpc -> Services -> VPC
	
		SideBar -> Your VPCs
		
			Edit name (algafood-vpc)
		
		[Mudar o IP permitido acessar o Banco de dados MySQL]
		
		SideBar - Security -> Security Groups
			
			-> algafood-mysql-sg
			
					Inbound rules -> Edit inbound rules
					
						Source (Anywhere ou My IP)
						
						-> Save rules
					
Acessando o Banco de dados externamente:

	Página da conta - Pesquisar rds -> Services -> RDS
					
		SideBar -> Databases
		
			-> algafood-mysql	
			
				Connectivity & security - Endpoint & port
					
					copiar Endpoint e Port se não 3306
					
	No MySQL Workbench - MySQL connections -> +
		
		Setup New Connection
		
			Name (AlgaFood Production)
		
			Hostname (colar o Endpoint)
			
			Port (3306)
			
			Username (admin)
			
			Password -> Store in Keychain (colar a senha guardada)
			
		-> Test Connection - caso de erro verifique se o seu IP não mudou e se a instância do Banco já foi criada
		
		-> OK
		
	No MySQL Workbench - AlgaFood Production
		
		TopBar -> Schemas
		
			-> New schema
			
				Schema Name (algafood)
				
				Character Set (utf8mb4)
				
				-> Apply
				
					-> Apply
		
		TopBar -> Administration
	
			SideBar - Management -> Users and Privileges
		
				-> Add Account 
					
					Login
					
						Login name (algafood-api)
						
						Password (preencher e guardar em local seguro)
						
						Confirm Password (preencher e guardar em local seguro)
					
					-> Schema Privileges
						
						-> Add Entry...
						
							Selected Schema (algafood)
							
							-> OK
							
						-> Select "ALL"
						
						-> Apply
						
### Conhecendo e criando uma conta no Redislabs e Criando uma instância do Redis na nuvem

- Uma opção ao redis na AWS: [Amazon ElasticCache](https://aws.amazon.com/pt/elasticache/)

	obs: A Amazon ElasticCache é mais complicada a configuração para acesso externo por isso...

- Usaremos a Redislabs

[Link para a Redislabs](https://redis.com/)

Criando uma conta e uma instância do Redis:

	-> Try Free
	
		-> Cloud
		
		Preencher o formulário -> Aceitar termos do serviço -> Get Started
		
	-> Login
		
		Fazer o login
		
	-> Create Subscription
	
		New Subscription
		
			Select Cloud Provider (AWS)
			
			Select Region (us-east-1)
			
			Fixed Size
			
				High-Availability (Replication) obs: em produção Multi-AZ
				
				DatasetSize (30MB Free)
				
					Subscription Name (AlgaFood)
					
					-> Create
					
		Create Database
		
			Database Name (algafood-redis)
			
			Access Control & Security
			
				-> Redis Password
				
				-> Visibility (Copiar e guardar a senha em local seguro)
				
			Data Eviction Policy (volatile-lru)
			
			-> Activate
			
		algafood-redis
		
			-> Configuration
			
				Endpoint (Copiar e guardar em local seguro)
	
Testando o Redis criado na nuvem :

	Máquina local:
	
		docker container run --rm -it redis:6-alpine redis-cli -h colar-o-end-point -p colar-a-porta
		
			auth colar-a-senha-redis
			
			keys *
			
			set nome Rodolfo
			
			keys *
			
			get nome
			
			del nome
			
			keys *
			
### Conhecendo o Amazon Elastic Container Service (ECS) e AWS Fargate

Opçoes do deploy da api:

- Criar uma instância [Amazon EC2](https://aws.amazon.com/pt/ec2/), instalar o docker e rodar a aplicação

	obs: nesse caso a responsabilidade de gerenciar os containers será nossa

- Usar o [Amazon Elastic Kubernetes Service (EKS)](https://aws.amazon.com/pt/eks/)

- Usar o [Amazon Elastic Container Service (ECS)](https://aws.amazon.com/pt/ecs/)

Usaremos o ECS no curso:

	Para isso precisamos de um cluster para rodar os containers, na AWS podemos fazer de duas formas:
	
		- criar instâncias de EC2, pelo menos duas para alta disponibilidade, e gerenciar elas
		
		- usar o [AWS Fargate](https://aws.amazon.com/pt/fargate/), ele pode ser usado tanto para o ECS como EKS
		
			Fargate = Computação sem servidor para containers, não é necessário gerenciar os servidores (EC2)
			
Consultar os Preços do ECS:

	TopBar -> Definição de preço
	
		Depende do Modelo de execução:
		
			- Fargate
			
			- EC2
			
			- Outposts
	
		-> Fargate
		
			Região (escolha a região para ver os preços)
			
			por vCPU hora
			
			por GB hora
			
### Publicando um container no Amazon ECS

	Página da conta -> Pesquisar ecs -> Services -> Elastic Container Service
	
		[Criando uma Task Definition]
	
		SideBar -> Task Definitions
			
			-> Create new Task Definition
			
				Select launch type compatibility (Fargate)
				
				-> Next step
				
				Configure task and container definitions
				
					Task Definition Name (nginx-taskdef)
					
					Task Role (deixa em blanco)
					
					Task size
					
						Task memory (0.5GB)
					
						Task CPU (0.25 vCPU)
						
					Container Definitions
					
						-> Add container
						
							Container name (nginx-container)
							
							Image (nginx:1.21.5-alpine)
							
							Port mappings (80)
							
							-> Add
					
					-> Create
					
						-> View Task Definition
			
		SideBar -> Task Definitions [somente para ver na lista]
		
		[Criando um cluster]
		
		SideBar -> Clusters
		
			-> Create Cluster
				
				Select cluster template (Network only - Powered by Fargate)
				
				-> Next step
				
					Configure Cluster
					
						Cluster name (algafood-cluster)
						
					Networking
					
						Create cluster (não marcar)
						
					-> Create
					
						-> View Cluster
		
		[Rodando uma Task]
						
		SideBar -> Clusters
		
			-> algafood-cluster
			
				-> Tasks
				
					-> Run new task
					
						Task Definition (nginx-taskdef)
						
						obs: não iremos rodar por aqui, se cair a task para.
						
			algafood-cluster
			
				-> Services [obs: mantém a task rodando, se cair levanta novamente]
				
					-> Create
					
						Launch type (Fargate)
						
						Task Definition (nginx-taskdef)
						
						Cluster (algafood-cluster)
						
						Service name (nginx-service)
						
						Number of tasks (1) [escala a aplicação]
						
						-> Next step
						
							VPC and security groups
							
								Cluster VPC (algafood-vpc)
								
								Subnets (selecionar uma) [colocar mais de uma se for escalar mais de uma]
								
								Security groups -> Edit
								
									Assigned security groups (Create new security group)
									
									Security group name (nginx-sg)
									
									Inbound rules for security group (HTTP, Anywhere)
									
									-> Save
									
								Auto-assing public IP (Enable)
								
								-> Next step
								
									-> Next step
									
										-> Create service
										
											-> View service
											
												-> Tasks [tem task aqui]
												
		SideBar -> Clusters
		
			algafood-cluster - Fargate - 1 services
					
			-> algafood-cluster
			
				-> Services
				
				-> Tasks
					
					nginx-taskdef - RUNNING
					
					[ver os logs do container]
					
					-> Task id
					
						Containers - [1 container na task] nginx-container
						
						-> nginx-container
						
							Log Configuration -> View logs in CloudWatch
			
				[ver IP para acessar o nginx]
	
				Tasks - Details - Network - Public IP [Copiar e colar no navegador]
				
			[para evitar gastos desnecessários]
				
			algafood-cluster -> Services
				
				[1]
			
				selecionar nginx-service -> delete
				
				[2]
				
				selecionar nginx-service -> Update
				
					Force new deployment (marcar)
				
					Number of tasks (0)
					
					-> Next step
					
						-> Next step
						
							-> Next step
							
								-> Update Service
								
### Subindo a imagem Docker para o Amazon Elastic Container Registry (ECR)

[Amazon Elastic Container Registry (ECR)](https://aws.amazon.com/pt/ecr/)

Consultar os Preços:

	TopBar -> Definição de preço
	

 Subindo a imagem Docker:
 	
	Página da conta -> Pesquisar ecr -> Services -> Elastic Container Registry
	
		SideBar - Amazon ECR -> Repositories
		
			-> Private
				
				-> Create Repository
				
					Repository name (algafood-api)
					
						-> Create repository
					
			Repositories
			
				Selecionar algafood-api -> View push commands
				
					Seguir o passo a passo, porém é necessário instalar aws-cli
					
					[AWS CLI](https://aws.amazon.com/pt/cli/)
					
						Instalar e voltar para seguir o passo a passo dos comandos
						
Configurando chave de acesso para o AWS CLI

	Página da conta -> Pesquisar iam -> Services -> IAM
	
		SideBar -> Users
		
			-> Add user
			
				User name (rodolfo-awscli)
				
				Access type (Programmatic access)
				
				-> Next permissions
				
					-> Attach existing policies directly
					
						Filter policies (AmazonEC2ContainerRegistry)
						
						Select AmazonEC2ContainerRegistryPowerUser
						
						-> Next tags
						
							-> Next review
							
								-> Create user
								
									Copiar e guardar em local seguro Access key ID e Secret access key >

Continuando subindo a imagem Docker
						
	Na máquina local:
		
		Após instalar o AWS CLI
	
		aws configure
		
			AWS Access Key Id (Colar Access key ID)
			
			AWS Secret Access Key (Colar Secret access key)
			
			Enter
			
			Enter
			
		[colar comando do View push commands]
		
		aws ecr get-login-password...
		
		[fazendo o buid da imagem, já na pasta raiz do projeto, substituindo o commando original]
		
		./mvnw package -P docker
		
		[colar comando do View push commands]
		
		docker tag ...
		
		[colar comando do View push commands]
		
		docker push ...
		
	Na conta da AWS
	
		Amazon ECR -> Repositories -> algafood-api [lista as imagens no repositório]
		
### Organizando as variáveis de ambiente do container da aplicação

DB_HOST = RDS > Database > algafood-mysql -> Connectivity & security - EndPoint e Port

SPRING_DATASOURCE_USERNAME = algafood-api

SPRING_DATASOURCE_PASSWORD = colar a senha copiada

ALGAFOOD_JWT_KEYSTORE_JKS_LOCATION = gerar novo com cmd keytool > encodar jks em base64 > colar "base64:" + "jks-encodado" tudo junto

ALGAFOOD_JWT_KEYSTORE_PASSWORD = senha usada na hora de gerar novo

ALGAFOOD_JWT_KEYSTORE_KEYPAIR_ALIAS = alias usado na hora de gerar novo (algafood)

SPRING_REDIS_HOST = Redislabs > Databases -> algafood-redis - Endpoint - retirar a porta

SPRING_REDIS_PORT = Redislabs > Databases -> algafood-redis - Endpoint - somente a porta

SPRING_REDIS_PASSWORD = Redislabs > Databases -> algafood-redis - Access Control & security -> Visibility

LOGGING_LOGGLY_TOKEN = Loggly -> Source Setup -> Customer Tokens - Customer Token

ALGAFOOD_EMAIL_REMETENTE = AlgaFood <testes.dev.hiok@gmail.com>

SPRING_MAIL_HOST = smtp.sendgrid.net

SPRING_MAIL_PORT = 587

SPRING_MAIL_USERNAME = apikey

SPRING_MAIL_PASSWORD = sendgrid -> settings -> api_keys -> Create API Key - Api Key Name (AlgaFood Production), (Restricted Access), Mail Send (Full) -> Create and View - copiar e colar

ALGAFOOD_STOGARE_S3_ID_CHAVE_ACESSO = IAM -> Users -> algafood-photos-production-s3 - Access key ID

ALGAFOOD_STOGARE_S3_CHAVE_ACESSO_SECRETA = colar a senha guardada

ALGAFOOD_STOGARE_S3_BUCKET = algafood-photos-production

ALGAFOOD_STOGARE_S3_REGIAO = us-east-1

### Gerenciando as configurações com AWS Systems Manager Parameter Store

	Página da conta -> pesquisar Systems Manager -> Services -> Systems Manager
		
		SideBar - Application Manager -> Parameter Store
		
			-> Create Parameter
				
				Name: (/prod/servico-teste/senha-db)
				
				Tier: (Standard)
				
				Type: (SecureString)
				
				Value: (teste123)
				
				-> Create Parameter
				
/prod/algafood-api-service/DB_HOST = RDS > Database > algafood-mysql -> Connectivity & security - EndPoint e Port

/prod/algafood-api-service/SPRING_DATASOURCE_USERNAME = algafood-api

/prod/algafood-api-service/SPRING_DATASOURCE_PASSWORD = colar a senha copiada

/prod/algafood-api-service/ALGAFOOD_JWT_KEYSTORE_JKS_LOCATION = gerar novo com cmd keytool > encodar jks em base64 > colar "base64:" + "jks-encodado" tudo junto

/prod/algafood-api-service/ALGAFOOD_JWT_KEYSTORE_PASSWORD = senha usada na hora de gerar novo

/prod/algafood-api-service/ALGAFOOD_JWT_KEYSTORE_KEYPAIR_ALIAS = alias usado na hora de gerar novo (algafood)

/prod/algafood-api-service/SPRING_REDIS_HOST = Redislabs > Databases -> algafood-redis - Endpoint - retirar a porta

/prod/algafood-api-service/SPRING_REDIS_PORT = Redislabs > Databases -> algafood-redis - Endpoint - somente a porta

/prod/algafood-api-service/SPRING_REDIS_PASSWORD = Redislabs > Databases -> algafood-redis - Access Control & security -> Visibility

/prod/algafood-api-service/LOGGING_LOGGLY_TOKEN = Loggly -> Source Setup -> Customer Tokens - Customer Token

/prod/algafood-api-service/ALGAFOOD_EMAIL_REMETENTE = AlgaFood <testes.dev.hiok@gmail.com>

/prod/algafood-api-service/SPRING_MAIL_HOST = smtp.sendgrid.net

/prod/algafood-api-service/SPRING_MAIL_PORT = 587

/prod/algafood-api-service/SPRING_MAIL_USERNAME = apikey

/prod/algafood-api-service/SPRING_MAIL_PASSWORD = sendgrid -> settings -> api_keys -> Create API Key - Api Key Name (AlgaFood Production), (Restricted Access), Mail Send (Full) -> Create and View - copiar e colar

/prod/algafood-api-service/ALGAFOOD_STOGARE_S3_ID_CHAVE_ACESSO = IAM -> Users -> algafood-photos-production-s3 - Access key ID

/prod/algafood-api-service/ALGAFOOD_STOGARE_S3_CHAVE_ACESSO_SECRETA = colar a senha guardada

/prod/algafood-api-service/ALGAFOOD_STOGARE_S3_BUCKET = algafood-photos-production

/prod/algafood-api-service/ALGAFOOD_STOGARE_S3_REGIAO = us-east-1

### Configurando Amazon ECS para rodar nossa aplicação

	Página da conta -> pesquisar ecs ->	Services -> Elastic Container Service
	
		SideBar -> Task Definitions	-> Create new Task Definition
		
			-> Fargate
				
				Task definition name: (algafood-api-taskdef)
				
				Task memory: (1G)
				
				Task CPU: (0.5 vCPU)
				
				-> Add Container
				
					Container name: (algafood-api-container)
					
					Image: (*.amazonaws.com/algafood-api)
					
					Port mapping: 8080
					
					Environment Variables: 
						
						Key: (SPRING_DATASOURCE_USERNAME) (ValueFrom) Value: 
															(/prod/algafood-api-service/SPRING_DATASOURCE_USERNAME)
						Key: (SPRING_DATASOURCE_PASSWORD) (ValueFrom) Value: 
															(/prod/algafood-api-service/SPRING_DATASOURCE_PASSWORD)
						.
						.
						.
						
						Key: (SPRING_PROFILES_ACTIVE) (Value) Value: (production)
						
					-> ADD
					
				-> Create
				
		SideBar -> Clusters -> Algafood-cluster
		
			-> aba Services -> Create
			
				Launch type: (Fargate)
				
				Task definition: algafood-api-taskdef
				
				Cluster: algafood-cluster
				
				Service name: algafood-api-service
				
				Number of tasks: 1
				
				-> Next Step
				
					Cluster VPC: (a existente)
					
					Subnets: (a primeira) (a segunda)
					
					Security Groups: -> Edit
					
						Assigned security groups: (create new security group)
						
						Security group name: (algafood-api-service-sg)
						
						Type: (Custom TCP) Port range: (8080) Source: (Anywhere)
						
						-> Save
						
					-> Next Step
					
						-> Next Step
						
							-> Create Service
							
								-> View service
								
			-> aba Tasks -> [Task id] 
			
				-> View logs in CloudWatch
				
				Stopped reason [Error - AccessDeniedException]
				
### Permitindo a leitura de parâmetros do Parameter Store pelo serviço do Amazon ECS
					:	Página da conta -> pesquisar iam -> Services - IAM
					
		SideBar -> Roles
		
			-> pesquisar ecs -> ecsTaskExecutionRole
				
				aba Permissions -> Add inline policy
				
					Service: (Systems Manager)
					
					Actions - Access level -> Read: (GetParameter, GetParameters, GetParameterByPath)
					
					Resources: (Specific)
						
						-> Add ARN
							
							Region: (Any)
							
							Account: (já existente)
							
							Fully qualified parameter name: prod/*
							
							-> Add
							
					-> Review Policy
					
						Name: ParameterStoreReadOnly
						
						-> Create Policy
						
	Página da conta -> pesquisar ecs -> Services - Elastic Container Service
	
		aba service -> selecionar algafood-api-service -> Update
		
			Force new deployment
			
			-> Next step
			
				-> Next step
				
					-> Next step
					
						-> Update Service
						
		aba Tasks -> [Update]
		
			-> [task id criada]
			
				-> View logs in CloudWatch	
					Error: CommunicationsException
					
### Permitindo o acesso ao MySQL pelo Security Group do serviço do Amazon ECS

	Página da conta -> pesquisar vpc -> Services - VPC
	
		SideBar -> Security Groups -> id do algafood-mysql-sg
		
			-> Edit inbound rules
			
				-> Add Rule
				
				Type: (MYSQL) Source: (algafood-api-service-sg)
				
				-> Save rules
				
	Página da conta -> pesquisar ecs -> Services - Elastic Container Service
	
		SideBar -> Clusters
		
			aba Services -> selecionar algafood-api-service -> Update
			
				Force new deployment
			
				-> Next step
				
					-> Next step
					
						-> Next step
						
							-> Update Service
							
			aba Tasks -> [Update]
		
				-> [task id criada]
				
					copiar e guardar o Public IP
				
					-> View logs in CloudWatch
					
						-> Resume
						
							obs: Ok está rodando a aplicação
	
	Minha Máquina -> MySQL Workbench
	
		-> Algafood-production
		
			obs: estão criadas as tabelas
			
### Inserindo dados no banco de dados de produção

	copiar os dados que queremos do afterMigrate.sql
	
	no MySQL Workbench -> Algafood-production
	
		SideBar -> algafood botão direito Default Schema
	
			colar os dados na janela Query e executar (safe mode)
			
		Menu preferences -> SQL Editor -> desmarcar Safe Updates
		
			fechar janela do Algafood-production (fechar a conexão) e conectar novamente (abrir novamente)
		
			executar novamente as queries
			
	no Postman ou Insomnia podemos testar a aplicação
	
		usando o Public IP guardado:
		
			gerar o access token pelo password flow e copiar
			
			usar o token para testar a aplicação
			
### Configurando e provisionando um Load Balancer na Amazon

	Página da conta -> pesquisar elb -> Features - Load balancers
	
		obs: cai na página do EC2 no SideBar tem menu do Load balancing caso necessite usar
		
		-> Create Load Balancer
		
			Application load balancer -> Create
			
				Step 1
				
					Name: (algafood-lb)
					
					Scheme: (internet-facing)
					
					Listeners: Protocol: (HTTP) Port(80)
					
					Availability Zones: VPC:(selectonar existente) Zones: (us-east-1a, us-east-1b)
					
					-> Next: ...
					
				Step 2
				
					-> Next: ...
					
				Step 3
				
					Assign a security group -> Create a new security group
					
						 Security group name: (algafood-lb-sg)
						 
					-> Next: ...
					
				Step 4
				
					Target group: (New target group)
					
					Name: (algafood-api-service-tg)
					
					Target type: (IP)
					
					Health ckecks
					
						Path: /v1
						
						Healthy threshold: 2
						
						Unhealthy threshold: 2
						
						Timeout: 10
						
						Interval: 30
						
						Success codes: 200
					
					-> Next: ...
					
				Step 5
				
					-> Next: ...
						
				Step 6
				
					-> Create
					
	selecionando o load balance criado
		
		aba Description

			copiar o DNS name
			
### Configurando o balanceamento de carga no serviço do Amazon ECS

	Página da conta -> pesquisar ecs -> Services - Elastic Container Service
	
		SideBar -> Clusters -> algafood-cluster
		
			aba Services 
				
				-> selecionar algafood-api-service -> Delete
				
				-> Create
				
					repetir processo de [###Configurando Amazon ECS para rodar nossa aplicação] mudando:
					
						Number of tasks: (2)
						
							-> Next Step
						
						Subnets: (selecionar as mesmas do load balancer)
						
						Security groups: (selecionar algafood-api-service-sg)
						
						Health check grace pediod: 150
						
						Load Balancer
						
							Load Balancer Type: (Application Load Balancer)
							
							Load Balance Name: (algafood-lb)
							
							Container name: (selecionar algafood-api-container:8080) -> Add to load balancer
							
								Production listener port: (80:HTTP)
								
								Target group name: (algafood-api-service-tg)
								
							-> Next Step
						
						-> Create Service				
						
						-> View Service
						
	Página da conta -> pesquisar ec2 -> Services - EC2
	
		SideBar -> Target Groups -> algafood-api-service-tg
		
			Registered targets -> refresh
			
				obs: irá aparecer os targets (containers)
				
testando
				
	Minha máquina no Postman ou Insomnia
		
		usar o DNS name do load balancer criado na url para testar
		
			url/hostcheck -> obs: vemos o balanceamento sendo feito
			
não permitir o tráfego direto sem passar no load balancer

	Página da conta -> pesquisar vpc -> Services - VPC
	
		SideBar -> Security Groups -> algafood-api-service-sg
		
			-> Edit inbound rules
			
				-> Delete
				
			-> Edit inbound rules
			
				Type: (Custom TCP) Port: (8080) Source: (algafood-lb-sg)
				
				-> Save rules
				
### Registrando um domínio de internet no Registro.br

	criar uma conta no Registro.br
	
	clicar em Registre
	
	verificar o disponibilidade de um domínio e registar qual estiver disponível
	
	aguardar o email para efetuar o pagamento
	
	compensando o pagamento o registro estará pronto	
	
				
### Configurando o domínio para o Application Load Balancer

configurando um serviço de DNS: usaremos do Registro.br

	no site Registro.br logar
	
	no meu "painel"
	
	selecionar aba Domínios
	
	selecionar o domínio
	
		DNS -> Editar zona
		
			-> Nova Entrada
			
				(api).meu-dominio.com.br (cname) (DNS name do load balance da AWS)
				
				-> Adicionar
				
					-> Salvar
					
testar o dominio pode demorar dias para funcionar

	Minha máquina no Postman ou Insomnia
	
		usar o domínio registrado na url e testar como sempre
		
para funcionar somente pelo dominio registrado
	
	Página da conta -> pesquisar ec2 -> Services - EC2
	
		SideBar -> Load Balancer
		
			aba Listeners -> View/edit rules
			
				aba adicionar[+]
				
					insert rule
					
						Add Condition: (Host header is api.meu-dominio.com.br) 
						
						Add Action: (Forward to algafood-api-service-tg)
						
						-> Ok[check]
					
					-> Save
					
				aba editar[pencil]
				
					selecionar o antigo
					
						then -> Delete[trash] substituir (fixed response 503)
		
						-> Ok[check]
				
					-> Update
					
### Configurando certificado TLS (HTTPS) com AWS Certificate Manager

emitindo um certificado

	Página da conta -> pesquisar cerfificate manager -> Services - Certificate Manager
	
		Provision Certificates -> Get started
		
			Selecionar Request a public certificate
			
				-> Request a certificate
				
					Domain name: (*.meu-dominio.com.br)
					
					-> Next
					
					Selecionar Email validation
					
					-> Next
					
					-> Review
					
					-> confirm request
					
					-> continue

utilizando o certificado
					
	Página da conta -> pesquisar ec2 -> Services - EC2
	
		SideBar -> Load Balancer	
		
			aba Listeners -> Add listener
				
					Protocol: (HTTPS):(443)
					
					Default action: (fixed response 503) -> Ok[check]
					
					Default SSL certificate: (From ACM) (*.meu-dominio.com.br)
					
					-> Add listener
				
				HTTPS:443 -> View/edit rules
				
					-> Insert rule
					
						Add condition: (host header is api.meu-dominio.com.br) -> Ok[check]
						
						Add action: (forward to algafood-api-services-tg) -> Ok[check]
						
						-> Save
						
				HTTP:80 -> Delete
				
	EC2 > Security Groups
	
		-> id do algafood-lb-sg
		
			-> Edit rules
			
				Alterar Type: (HTTPS) ... 
				
				Alterar Type: (HTTPS) ...
				
				-> Save rules

testando
				
	testar no Postman ou Insomnia como sempre
	
