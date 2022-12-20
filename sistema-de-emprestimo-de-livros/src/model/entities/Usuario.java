package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
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
	
	public boolean adicionarEmprestimo(Emprestimo emprestimo) {
		if(emprestimos.size() == 3 || emprestimo == null) {
			return false;
		}
		return emprestimos.add(emprestimo);
	}
	
	public boolean removerEmprestimo(Emprestimo emprestimo) {
		return emprestimos.remove(emprestimo);
	}
	
	
	@Override
	public String toString() {
		return "\nID: " + id + "\nMatricula: " + matricula + "\nNome: " + nome
			+ "\nCPF: " + cpf + "\nE-mail: " + email + "\nSenha: " + senha;
	}
	
}
