CREATE TABLE usuario_emprestimo(
	id INT NOT NULL AUTO_INCREMENT,
	id_usuario INT NOT NULL,
    id_emprestimo INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY(id_emprestimo) REFERENCES emprestimos(id),
    UNIQUE KEY(id_emprestimo)
);
