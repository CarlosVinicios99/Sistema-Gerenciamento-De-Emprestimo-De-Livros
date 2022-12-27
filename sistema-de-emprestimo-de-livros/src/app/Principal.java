package app;

import app.model.entities.Emprestimo;
import app.model.entities.Livro;
import app.model.entities.Usuario;
import app.repositories.DAO;

public class Principal {
	
	public static void main(String[] args) {
	
		//INSERIR USUARIO - TESTADO
		//DAO.iniciarConexao();
		//Usuario usuario = new Usuario("12345", "Carlos", "111222", "Carlos@gmail.com", "ABCD");
		//DAO.inserirUsuario(usuario);
		//DAO.fecharConexao();
		
		//INSERIR LIVRO - TESTADO
		//DAO.iniciarConexao();
		//Livro livro = 
			//new Livro("2022-0001", "Programacao C", "Programacao", "Rosemberg", "Biblioteca", true);
		//DAO.inserirLivro(livro);
		
		
		//CONSULTAR LIVRO POR TITULO - TESTADO 
		//DAO.iniciarConexao();
		//Livro livro = DAO.consultarLivroPorTitulo("Programacao C");
		//System.out.println(livro);
		//DAO.fecharConexao();
		
		//CONSULTAR USUARIO - TESTADO
		//DAO.iniciarConexao();
		//Usuario usuario = DAO.consultarUsuario("111222", "ABCD");
		//System.out.println(usuario);
		//DAO.fecharConexao();
		
		//INSERIR EMPRESTIMO;
		//DAO.iniciarConexao();
		//Emprestimo emprestimo = new Emprestimo(livro);
		//DAO.inserirEmprestimo(emprestimo, usuario.getId());
		
		
	}
	
}
