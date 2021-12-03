insert into estado (nome) values ('São Paulo');
insert into estado (nome) values ('Minas Gerais');
insert into estado (nome) values ('Rio de Janeiro');

insert into cidade (nome, estado_id) values ('São Paulo', 1);
insert into cidade (nome, estado_id) values ('Campinas', 1);
insert into cidade (nome, estado_id) values ('Belo Horizonte', 2);
insert into cidade (nome, estado_id) values ('Niteroi', 3);

insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');

insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into forma_pagamento (descricao) values ('Cartão de Crédito');
insert into forma_pagamento (descricao) values ('Cartão de Débito');
insert into forma_pagamento (descricao) values ('Dinheiro');
insert into forma_pagamento (descricao) values ('PIX');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);

insert into permissao (nome, descricao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (nome, descricao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');
