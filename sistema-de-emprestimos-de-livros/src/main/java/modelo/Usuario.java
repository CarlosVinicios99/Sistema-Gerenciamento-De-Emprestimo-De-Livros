package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String matricula;
	
	private String nome;
	
	private String cpf;
	
	private String email;
	
	private String senha;
	
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	
	
	public Usuario() {
		
	}
	
	public Usuario(String matricula, String nome, String cpf, String email, String senha) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	public boolean emprestimoPermitido() {
		if(emprestimos.size() >= 3) {
			return false;
		}
		return true;
	}
	
	public boolean adicionarEmprestimo(Emprestimo emprestimo) {
		return emprestimos.add(emprestimo);
	}
	
	public boolean removerEmprestimo(Livro livro) {
		Emprestimo emprestimoParaRemover = null;
		
		for(Emprestimo emprestimo: emprestimos) {
			if(emprestimo.getLivro().getCodigo().equals(livro.getCodigo())) {
				emprestimoParaRemover = emprestimo;
			}
		}
		
		if(emprestimoParaRemover != null) {
			emprestimos.remove(emprestimoParaRemover);
			return true;
		}
		
		return false;	
	}
	

	@Override
	public String toString() {
		String retorno = "\nID: " + id + "\nMatricula: " + matricula + "\nNome: " + nome
			+ "\nCPF: " + cpf + "\nE-mail: " + email + "\nSenha: " + senha + "\nEmprestimos: \n";
		
		
		for(Emprestimo emprestimo: emprestimos) {
			retorno = retorno.concat(emprestimo.toString() + "\n");
		}
		
		return retorno;
	}
}
