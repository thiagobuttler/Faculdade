CREATE DATABASE db_instituicoes_item;

USE db_instituicoes_item;

CREATE TABLE tb_instituicao
(
id_instituicao INT PRIMARY KEY AUTO_INCREMENT,
nome_instituicao VARCHAR(200),
telefone VARCHAR(200),
senha VARCHAR(200)
);

CREATE TABLE tb_item
(
id_item INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(80),
descricao VARCHAR(200),
id_instituicao INT,
CONSTRAINT fk_instituicao
	FOREIGN KEY (id_instituicao)
    REFERENCES tb_instituicao (id_instituicao)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
