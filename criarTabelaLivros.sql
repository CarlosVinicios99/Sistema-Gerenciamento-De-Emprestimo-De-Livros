CREATE TABLE livros(
	id INT NOT NULL AUTO_INCREMENT,
    codigo VARCHAR(15) NOT NULL,
    titulo VARCHAR(60) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    autor VARCHAR(60) NOT NULL,
    proprietario VARCHAR(60) NOT NULL,
    disponibilidade BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);