create table oauth_code(
	code varchar(256),
	authentication blob
)engine=innodb default charset=utf8;