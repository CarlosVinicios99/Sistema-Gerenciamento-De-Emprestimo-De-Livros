package app.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.model.entities.Emprestimo;
import app.model.entities.Livro;
import app.model.entities.Usuario;

public class DAO {
	
	private static Connection conexao;
	private static PreparedStatement preparedStatement;
	
	private DAO() {
		
	}
	
	public static void iniciarConexao() {
		conexao = FabricaConexao.getConexao();
	}
	
	
	public static void inserirUsuario(Usuario usuario) {
		String SQL = 
			""" 
				INSERT INTO usuarios (matricula, nome, email, senha, cpf) VALUES (?, ?, ?, ?, ?);
			""";
			try {
				preparedStatement = conexao.prepareStatement(SQL);
				preparedStatement.setString(1, usuario.getMatricula());
				preparedStatement.setString(2, usuario.getNome());
				preparedStatement.setString(3, usuario.getEmail());
				preparedStatement.setString(4, usuario.getSenha());
				preparedStatement.setString(5, usuario.getCpf());
				preparedStatement.execute();
			}
			
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	public static void inserirLivro(Livro livro) {
		String SQL =
			"""
				INSERT INTO livros (codigo, titulo, descricao, autor, proprietario, disponibilidade)
					VALUES (?, ?, ?, ?, ?, ?);
			""";
		
		try {
			preparedStatement = conexao.prepareStatement(SQL);
			preparedStatement.setString(1, livro.getCodigo());
			preparedStatement.setString(2, livro.getTitulo());
			preparedStatement.setString(3, livro.getDescricao());
			preparedStatement.setString(4, livro.getAutor());
			preparedStatement.setString(5, livro.getProprietario());
			preparedStatement.setBoolean(6, livro.getDisponibilidade());
			preparedStatement.execute();
		}
		
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
			
	}
	
	public static void inserirEmprestimo(Emprestimo emprestimo) {
		String SQL = 
			"""
				INSERT INTO emprestimos (data_inicial, data_final, id_livro)
					VALUES (?, ?, ?);
			""";
		
		try {
			preparedStatement = conexao.prepareStatement(SQL);
			preparedStatement.setDate(1, Date.valueOf(emprestimo.getDataInicial().toString()));
			preparedStatement.setDate(2, Date.valueOf(emprestimo.getDataFinal().toString()));
			preparedStatement.setInt(3, emprestimo.getLivro().getId());
			preparedStatement.execute();
		}
		
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void inserirUsuarioEmprestimo(int idUsuario, int idEmprestimo) {
		String SQL =
			"""
				INSERT INTO usuario_emprestimo (id_usuario, id_emprestimo) 
					VALUES(?, ?)
			""";
		
		try {
			preparedStatement = conexao.prepareStatement(SQL);
			preparedStatement.setInt(1, idUsuario);
			preparedStatement.setInt(2, idEmprestimo);
			preparedStatement.execute();
		}
		
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
		
	
	
}
