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

## Amazon Web Services (AWS)

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
			
				Preencher:
				
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

	Página da conta - Pesquisar rds -> Services -> RDS
	
		TopBar -> us-east-1
		
		SideBar -> Databases
		
			-> Create database
				
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


