-- comentários
-- a linha abaixo cria um banco de dados
create database dbinfox;
-- a linha abaixo escolhe o banco de dados
use dbinfox;
-- o bloco de instruções abaixo cria uma tabela
create table tbusuarios(
	iduser int primary key,
	nome_instituicao varchar(50) not null,
    fone varchar(15),
    cnpj varchar(15) not null unique,
    senha varchar(15) not null
);
-- o comando abaixo descreve a tabela
describe tbusuarios;
-- insere dados na tabela (CRUD)
-- create -> insert
-- insert into tbusuarios(iduser, nome_instituicao, fone, cnpj, senha)
-- values(1, xxx, xxx, xxx, xxx);
-- a linha abaixo exibe os dados da tabela (CRUD)
-- read -> select
select * from tbusuarios;

-- a linha abaixo modifica dados na tabela (CRUD)
-- update -> update
update tbusuarios set fone='7777-9999' where iduser=2;

-- a linha abaixo apaga um registro da tabela (CRUD)
-- delet -> delete
-- delete from tbusuarios where iduser=3;

