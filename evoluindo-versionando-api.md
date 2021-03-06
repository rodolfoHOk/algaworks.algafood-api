# Evoluindo e versionando a API

## Evitando quebrar os clientes

### A - Evitando quebrar os clientes: nova propriedade no modelo

- Modelo de representação saída: tem retrocompatibilidade

- Modelo de representação entrada: manter opcional por um tempo para manter retrocompatibilidade

### B - Evitando quebrar os clientes: exclusão de propriedade do modelo

- Modelo de representação saída: quebra de retrocompatibilidade, manter por um tempo com valor zero ou vazio por exemplo

- Modelo de representação entrada: retirar da documentação e manter oculta sem validação por um tempo

### C - Evitando quebrar os clientes: alteração de tipo de propriedade do modelo

- Modelo de representação saída tipo amplo para específico: tem retrocompatibilidade

- Modelo de representação saída tipo específico para amplo: adicionar uma nova propriedade e manter a antiga por um tempo
	informando na documentação como depreciada
	
- Modelo de representação entrada tipo amplo para específico: pode ter quebra de retrocompatibilidade

- Modelo de representação saída tipo específico para amplo: tem retrocompatibilidade

### D - Evitando quebrar os clientes: alteração na estrutura de dados do modelo

- Modelo de representação saída: mantenha retornando opções novas e antigas por um tempo depreciando a antiga

- Modelo de representação entrada: aceite os modelos novos e antigos depreciando por um tempo a antiga e obrigando um ou
	outro se for o caso
	
### E - Evitando quebrar os clientes: alteração de URL de recurso

- Quebra a retrocompatibilidade, solução: manter url antiga e nova por um tempo,
	se usar Hateoas mantém a retrocompatibilidade e pode adicionar um novo link com rel novo para a mesma url
	
## As principais técnicas de versionamento de APIs

Tendo controllers da versão 1 e controllers da versão 2

1 - Versionamento por Media Type: no cabeçalho da requisição é passado a versão, 
		ex: Get /cozinhas, Accept: application/vnd.algafood.v2+json

2 - Versionamento por URI: ex: Get /v1/cozinhas Accept: application/json

## As principais abordagens para manter a base de código de APIs versionadas

1 - Projeto separado para cada versão: servidor de proxy reverso na frente que direciona as requisições para as apis v1 ou v2

	vantagem: totalmente separadas pode até ser desenvolvidas com linguagem de programação diferentes ou versões mais atuais.
	
	desvantagem: duplicação de código
	
2 - Mesmo projeto responde pelas versões v1 e v2: Api base que responde para ambas (v1 e v2 sem mudanças) e Api v2 para
	as com mudanças, camadas de domínio e infraestrutura compartilhadas
	
	vantagem: evita duplicação de código
	
	desvantagem: alterações no código pode refletir em ambas as versões, deve ser utilizada mesma stack de tecnologias da v1 na v2

3 - Mesmo projeto mas separando totalmente as camadas da api: camadas de domínio e infraestrutura compartilhadas

	desvantagem: deve ser utilizada mesma stack de tecnologias da v1 na v2 e duplicação de código.
	