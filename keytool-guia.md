## Keytool 

> Ferramenta para gerar par de chaves para usar no token assimétrico

### Gerando um arquivo JKS com um par de chaves

CMD Exemplo: keytool -genkeypair -alias algafood -keyalg RSA -keypass 123456 -keystore algafood.jks -storepass 123456 -validity 3650

### Listando as entradas de um arquivo JKS

CMD Exemplo: keytool -list -keystore algafood.jks

### Gerando o certificado

CMD Exemplo: keytool -export -rfc -alias algafood -keystore algafood.jks -file algafood-cert.pem

### Gerando a chave pública

CMD Exemplo: openssl x509 -pubkey -noout -in algafood-cert.pem > algafood-pkey.pem