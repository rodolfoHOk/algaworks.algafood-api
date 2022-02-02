# Decidindo qual fluxo (grant_type) OAuth2 usar

## Se pergunte:

### P1 - O cliente é público? (não pode ocultar devidamente o client_secret)

- R1 Sim: Usar Authorization Code com PKCE

- R1 Nao: Segue para a próxima pergunta (P2)

### P2 - O cliente tem usuários finais?

- R2 Não: Usar Client Credentials Flow

- R2 Sim: Segue para a próxima pergunta (P3)

### P3 - Cliente é confiável (sua empresa é a desenvolvedora) e outros fluxos (Authorization Code com PKCE ou Authorization Code) não são viáveis?

- R3 Sim: Usar Password Credentials Flow (último caso se não for possível usar Authorization Code com PKCE e Authorization Code)

- R3 Não: Usar Authorization Code
