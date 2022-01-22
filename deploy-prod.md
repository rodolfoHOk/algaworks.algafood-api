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
