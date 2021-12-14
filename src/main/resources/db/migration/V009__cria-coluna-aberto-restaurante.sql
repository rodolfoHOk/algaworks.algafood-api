alter table restaurante add column aberto tinyint(1) not null;
update restaurante set aberto = false;