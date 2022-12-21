package model.entities;

import model.enums.Estado;

public class Livro {
	
	private int id;
	
	private String codigo;
	
	private String titulo;
	
	private String descricao;
	
	private String autor;
		
	private String proprietario;
	
	private Estado estado;
	
	public Livro() {
		
	}
	
	public Livro(String codigo, String titulo, String descricao, String autor, String proprietario) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.autor = autor;
		this.proprietario = proprietario;
	}
	
	public Livro(String codigo, String titulo, String descricao, String autor, String proprietario, Estado estado) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.autor = autor;
		this.proprietario = proprietario;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
}
