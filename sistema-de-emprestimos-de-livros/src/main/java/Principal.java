import modelo.Emprestimo;
import modelo.Livro;
import repositorio.DAO;

public class Principal {
	
	public static void main(String[] args) {
		
		Livro livro = new Livro("1", "Programacao C", "Livro de Prog", "Carlos", "Biblioteca", true);
		Emprestimo emprestimo = new Emprestimo(livro);
		
		DAO<Livro> daoLivro = new DAO<>(Livro.class);
		DAO<Emprestimo>daoEmprestimo = new DAO<>(Emprestimo.class);
		
		daoLivro.inserir(livro);
		daoEmprestimo.inserir(emprestimo);
		
	}
	
}
