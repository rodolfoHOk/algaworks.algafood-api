create table foto_produto (
	produto_id bigint not null,
	nome_arquivo varchar(150) not null,
	descricao varchar(150),
	content_type varchar(80) not null,
	tamanho int not null,
	
	primary key (produto_id)
) engine=InnoDB default charset=utf8;

alter table foto_produto add constraint
foreign key (produto_id) references produto (id);