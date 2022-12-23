CREATE TABLE usuarios(
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    matricula VARCHAR(20) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    PRIMARY KEY(id),
    UNIQUE KEY(matricula),
    UNIQUE KEY(cpf),
    UNIQUE KEY(email)
);

