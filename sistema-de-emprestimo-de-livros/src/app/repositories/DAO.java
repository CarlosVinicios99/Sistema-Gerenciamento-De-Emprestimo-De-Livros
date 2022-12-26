package app.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import app.model.entities.Bibliotecario;
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
	
	public static void fecharConexao() {
		try {
			if(!conexao.isClosed()) {
				conexao.close();
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//metodos de insercao
	
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
	
	public static void inserirEmprestimo(Emprestimo emprestimo, int idUsuario) {
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
		
		//consultar o emprestimo inserido e obter seu id, inserir na tabela usuario_emprestimo passando
		//o id do usuario e o id do emprestimo
		//inserirUsuarioEmprestimo(idUsuario, emprestimoConsulta.getId())
	}
	
	private void inserirUsuarioEmprestimo(int idUsuario, int idEmprestimo) {
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
	
	public static boolean bibliotecarioExiste(String cpf, String senha) {
		String SQL =
			"""
				SELECT * FROM bibliotecarios WHERE cpf = ? AND senha = ?;
			""";
		
		try {
			preparedStatement = conexao.prepareStatement(SQL);
			preparedStatement.setString(1, cpf);
			preparedStatement.setString(2, senha);
			ResultSet resultadoConsulta = preparedStatement.executeQuery();
			
			if(resultadoConsulta != null) {
				return true;
			}
			return false;
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	private static Livro consultarLivroPorId(int id) {
		String SQL =
				"""
					SELECT * FROM livros WHERE id = ?;
				""";
			
			try {
				preparedStatement = conexao.prepareStatement(SQL);
				preparedStatement.setInt(1, id);
				ResultSet resultadoConsulta = preparedStatement.executeQuery();
				
				if(resultadoConsulta != null) {
					while(resultadoConsulta.next()) {
						int idLivro = resultadoConsulta.getInt("id");
						String codigo = resultadoConsulta.getString("codigo");
						String titulo = resultadoConsulta.getString("titulo");
						String descricao = resultadoConsulta.getString("descricao");
						String autor = resultadoConsulta.getString("autor");
						String proprietario = resultadoConsulta.getString("proprietario");
						boolean disponibilidade = resultadoConsulta.getBoolean("disponibilidade");
						return new Livro(idLivro, codigo, titulo, descricao, autor, proprietario, disponibilidade);
					} 
				}
				return null;
				
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
	}
	
	private static Emprestimo consultarEmprestimo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		String SQL =
				"""
					SELECT * FROM emprestimos WHERE data_inicial = ? AND data_final = ?;
				""";
			
			try {
				preparedStatement = conexao.prepareStatement(SQL);
				preparedStatement.setDate(1, Date.valueOf(dataInicial.toString()));
				preparedStatement.setDate(2, Date.valueOf(dataFinal.toString()));
				ResultSet resultadoConsulta = preparedStatement.executeQuery();
				
				if(resultadoConsulta != null) {
					while(resultadoConsulta.next()) {
						int idEmprestimo = resultadoConsulta.getInt("id");
						Date dataInicialConsulta = resultadoConsulta.getDate("data_inicial");
						Date dataFinalConsulta = resultadoConsulta.getDate("data_final");
						int idLivro = resultadoConsulta.getInt("id_livro");
						Livro livro = consultarLivroPorId(idLivro);
						//return new Emprestimo(idEmprestimo, livro, dataInicialConsulta, dataFinalConsulta);
						//modificar os campos de emprestimo para receber Date
;					} 
				}
				
				return null;
				
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
	}
	
	//public static Livro consultarLivroPorTitulo
	//public static Usuario consultarUsuario() com seus respectivos emprestimos
	
	
	//metodos de exclusao
	
}
