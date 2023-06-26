CREATE DATABASE db_integrador_instituicoes;

USE db_integrador_instituicoes;

CREATE TABLE tb_usuario
(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200),
senha VARCHAR(200)
);

INSERT INTO tb_usuario (nome, senha)
VALUES ('admin', 'admin');

CREATE TABLE tb_instituicao (
id INT PRIMARY KEY AUTO_INCREMENT, 
nome_instituicao VARCHAR(200) NOT NULL, 
telefone VARCHAR(200) NOT NULL
);

CREATE TABLE db_integrador_instituicoes.tb_item (
id INT AUTO_INCREMENT NOT NULL,
nome VARCHAR(80) NOT NULL,
descricao VARCHAR(200) NULL,
PRIMARY KEY (id)
);

ALTER TABLE tb_item MODIFY id INT AUTO_INCREMENT;

CREATE TABLE db_integrador_instituicoes.tb_intituicao_item (
id_instituicao INT(11) NOT NULL,
id_item INT(11) NOT NULL,
nome VARCHAR(80) NULL,
descricao VARCHAR(200) NULL,
PRIMARY KEY (id_instituicao, id_item),
INDEX fk_item_idx (id_item ASC),
CONSTRAINT fk_item
	FOREIGN KEY (id_item)
    REFERENCES db_integrador_instituicoes.tb_item (id)
	ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT fk_instituicao
	FOREIGN KEY (id_instituicao)
    REFERENCES db_integrador_instituicoes.tb_instituicao (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

RENAME TABLE tb_intituicao_item TO tb_instituicao_item;