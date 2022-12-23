package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bibliotecario {
	
	@Id
	private int id;
	
	private String senha;
	
	private String email;
	
	private String nome;
	
	private String cpf;
	
	public Bibliotecario() {
		
	}
	
	public Bibliotecario(String senha, String email, String nome, String cpf) {
		this.senha = senha;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
}
