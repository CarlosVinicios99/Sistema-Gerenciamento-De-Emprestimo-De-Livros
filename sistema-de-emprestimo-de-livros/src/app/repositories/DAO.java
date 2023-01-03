package app.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.model.entities.Emprestimo;
import app.model.entities.Livro;
import app.model.entities.Usuario;

public class DAO {
	
	private static Connection conexao;
	private static PreparedStatement preparedStatement;
	
	private DAO() {
		
	}
	
	//TESTADO
	public static void iniciarConexao() {
		conexao = FabricaConexao.getConexao();
	}
	
	//TESTADO
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
	
	//metodos de insercao-----------------------------------------------------------------------------------------
	
	//TESTADO
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
	
	//TESTADO
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
	//TESTADO
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
			atualizarDisponibilidadeDeLivro(emprestimo.getLivro());
		}
		
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		Emprestimo emprestimoConsulta = 
			consultarEmprestimo(emprestimo.getLivro());

		inserirUsuarioEmprestimo(idUsuario, emprestimoConsulta.getId());
	}
	
	//TESTADO
	private static void inserirUsuarioEmprestimo(int idUsuario, int idEmprestimo) {
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

//Metodos de Consulta -----------------------------------------------------------------------------------------
	
	//TESTADO
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
	
	//TESTADO
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
	
	//TESTADO
	private static Emprestimo consultarEmprestimo(Livro livroConsulta) {
		String SQL =
				"""
					SELECT * FROM emprestimos WHERE id_livro = ?;
				""";
			
			try {
				preparedStatement = conexao.prepareStatement(SQL);
				preparedStatement.setInt(1, livroConsulta.getId());
				ResultSet resultadoConsulta = preparedStatement.executeQuery();
				
				if(resultadoConsulta != null) {
					while(resultadoConsulta.next()) {
						int idEmprestimo = resultadoConsulta.getInt("id");
						Date dataInicialConsulta = resultadoConsulta.getDate("data_inicial");
						Date dataFinalConsulta = resultadoConsulta.getDate("data_final");
						int idLivro = resultadoConsulta.getInt("id_livro");
						Livro livro = consultarLivroPorId(idLivro);
						return new Emprestimo(idEmprestimo, livro, dataInicialConsulta, dataFinalConsulta);
					} 
				}
				
				return null;
				
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
	}
	
	//TESTADO
	public static Usuario consultarUsuario(String cpfConsulta, String senhaConsulta) {
		String SQL = 
			"""
				SELECT * FROM usuarios WHERE cpf = ? AND senha = ?;
			""";
		
		try {
			preparedStatement = conexao.prepareStatement(SQL);
			preparedStatement.setString(1, cpfConsulta);
			preparedStatement.setString(2, senhaConsulta);
			ResultSet resultadoConsulta = preparedStatement.executeQuery();
			
			Usuario usuarioConsulta = new Usuario();
			if(resultadoConsulta != null) {
				while(resultadoConsulta.next()) {
					int idUsuario = resultadoConsulta.getInt("id");
					String matricula = resultadoConsulta.getString("matricula");
					String nome = resultadoConsulta.getString("nome");
					String cpf = resultadoConsulta.getString("cpf");
					String email = resultadoConsulta.getString("email");
					String senha = resultadoConsulta.getString("senha");
					
					usuarioConsulta.setId(idUsuario);
					usuarioConsulta.setMatricula(matricula);
					usuarioConsulta.setNome(nome);
					usuarioConsulta.setCpf(cpf);
					usuarioConsulta.setEmail(email);
					usuarioConsulta.setSenha(senha);
					usuarioConsulta.setEmprestimos(consultarEmprestimosDeUsuarios(idUsuario));
					return usuarioConsulta;
				}
			}
			
			return null;
		}
		
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	//TESTADO
	private static ArrayList<Emprestimo> consultarEmprestimosDeUsuarios(int idUsuario){
		ArrayList<Emprestimo> emprestimos = new ArrayList<>();
		String SQL = 
			"""
				SELECT * FROM emprestimos WHERE id IN 
					(SELECT id_emprestimo FROM usuario_emprestimo WHERE id_usuario = ?);
			""";
		try {
			preparedStatement = conexao.prepareStatement(SQL);
			preparedStatement.setInt(1, idUsuario);
			ResultSet resultadoConsulta = preparedStatement.executeQuery();
			
			if(resultadoConsulta != null) {
				while(resultadoConsulta.next()) {
					int idEmprestimo = resultadoConsulta.getInt("id");
					Date dataInicial = resultadoConsulta.getDate("data_inicial");
					Date dataFinal = resultadoConsulta.getDate("data_final");
					int idLivro = resultadoConsulta.getInt("id_livro");
					Livro livro = consultarLivroPorId(idLivro);
					emprestimos.add(new Emprestimo(idEmprestimo, livro, dataInicial, dataFinal));
				}
				return emprestimos;
			}
			return null;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	//TESTADO
	public static Livro consultarLivroPorTitulo(String tituloConsulta) {
		String SQL =
				"""
					SELECT * FROM livros WHERE titulo = ?;
				""";
			
			try {
				preparedStatement = conexao.prepareStatement(SQL);
				preparedStatement.setString(1, tituloConsulta);
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
	
	public static Livro consultarLivroPorCodigo(String codigoConsulta) {
		String SQL =
				"""
					SELECT * FROM livros WHERE codigo = ?;
				""";
			
			try {
				preparedStatement = conexao.prepareStatement(SQL);
				preparedStatement.setString(1, codigoConsulta);
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
	
	//TESTADO
	private static void atualizarDisponibilidadeDeLivro(Livro livro) {
		livro.alterarDisponibilidade();
		String SQL = 
			"""
				UPDATE livros SET disponibilidade = ? WHERE id = ?;
			""";
		
		try {
			preparedStatement = conexao.prepareStatement(SQL);
			preparedStatement.setBoolean(1, livro.getDisponibilidade());
			preparedStatement.setInt(2, livro.getId());
			preparedStatement.execute();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//Metodos de exclusao------------------------------------------------------------------------------------------
	
	public static void excluirUsuario(Usuario usuario) {
		if(usuario.getEmprestimos().isEmpty()) {
			String SQL =
				"""
					DELETE FROM usuarios WHERE id = ?
				""";
			
			try {
				preparedStatement = conexao.prepareStatement(SQL);
				preparedStatement.setInt(1, usuario.getId());
				preparedStatement.execute();
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void excluirEmprestimo(int idUsuario, Livro livro) {
		atualizarDisponibilidadeDeLivro(livro);
		Emprestimo emprestimo = consultarEmprestimo(livro);
		excluirEmprestimoDeUsuario(emprestimo.getId(), idUsuario);
		
		String SQL = 
			"""
				DELETE FROM emprestimos WHERE id = ?;	
			""";
		
		try {
			preparedStatement = conexao.prepareStatement(SQL);
			preparedStatement.setInt(1, emprestimo.getId());
			preparedStatement.execute();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	private static void excluirEmprestimoDeUsuario(int idEmprestimo, int idUsuario) {
		String SQL = 
			"""
				DELETE FROM usuario_emprestimo WHERE id_emprestimo = ? AND id_usuario = ?;
			""";
		
		try {
			preparedStatement = conexao.prepareStatement(SQL);
			preparedStatement.setInt(1, idEmprestimo);
			preparedStatement.setInt(2, idUsuario);
			preparedStatement.execute();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void excluirLivro(Livro livro) {
		if(livro.getDisponibilidade()) {
			
			String SQL = 
				"""
					DELETE FROM livros WHERE id = ?;
				""";
			
			try {
				preparedStatement = conexao.prepareStatement(SQL);
				preparedStatement.setInt(1, livro.getId());
				preparedStatement.execute();
			}
	
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
