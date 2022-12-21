package app.model.entities;

import java.time.LocalDateTime;

public class Emprestimo {
	
	private int id;
	
	private Livro livro;
	
	private LocalDateTime dataInicial;
	
	private LocalDateTime dataFinal;
	
	
	public Emprestimo() {
		
	}
	
	public Emprestimo(Livro livro) {
		this.livro = livro;
		this.dataInicial = LocalDateTime.now();
		this.dataFinal = LocalDateTime.now().plusDays(7);
	}
	
	public Emprestimo(Livro livro, LocalDateTime dataInicial, LocalDateTime dataFinal) {
		this.livro = livro;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LocalDateTime getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDateTime dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}
}
