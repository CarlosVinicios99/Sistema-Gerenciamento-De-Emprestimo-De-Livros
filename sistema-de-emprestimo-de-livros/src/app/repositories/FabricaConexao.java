package app.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	
	private FabricaConexao() {
		
	}
	
	public static Connection getConexao() {
		
		try {
			String url = "jdbc:mysql://localhost/emprestimo_de_livros";
			String usuario = "root";
			String senha = "alanturing";
			return DriverManager.getConnection(url, usuario, senha);
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
}
