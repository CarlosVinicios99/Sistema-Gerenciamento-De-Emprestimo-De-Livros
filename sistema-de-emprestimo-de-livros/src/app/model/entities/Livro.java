package app.model.entities;


public class Livro {
	
	private int id;
	
	private String codigo;
	
	private String titulo;
	
	private String descricao;
	
	private String autor;
		
	private String proprietario;
	
	private boolean disponibilidade;
	
	public Livro() {
		
	}
	
	public Livro(String codigo, String titulo, String descricao, String autor, String proprietario) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.autor = autor;
		this.proprietario = proprietario;
	}
	
	public Livro(String codigo, String titulo, String descricao, String autor, String proprietario, boolean disponibilidade) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.autor = autor;
		this.proprietario = proprietario;
		this.disponibilidade = disponibilidade;
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

	public boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	@Override
	public String toString() {
		return "Livro: " + titulo + "\nDisponibilidade: ";
	}
	
}
