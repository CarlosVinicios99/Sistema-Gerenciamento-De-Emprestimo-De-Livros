CREATE TABLE emprestimos(
	id INT NOT NULL AUTO_INCREMENT,
    data_inicial DATE NOT NULL,
    data_final DATE NOT NULL,
    id_livro INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_livro) REFERENCES livros (id),
    UNIQUE KEY(id_livro)
);